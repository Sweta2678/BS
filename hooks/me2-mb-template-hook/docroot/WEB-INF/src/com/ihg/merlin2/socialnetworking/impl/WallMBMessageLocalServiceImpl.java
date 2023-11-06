package com.ihg.merlin2.socialnetworking.impl;

import com.liferay.portal.kernel.dao.shard.ShardCallable;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.transaction.TransactionCommitCallbackRegistryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.SubscriptionSender;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.messageboards.model.MBCategory;
import com.liferay.portlet.messageboards.model.MBCategoryConstants;
import com.liferay.portlet.messageboards.model.MBMailingList;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBMessageConstants;
import com.liferay.portlet.messageboards.model.MBThread;
import com.liferay.portlet.messageboards.service.MBCategoryLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBMailingListLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBMessageLocalService;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceWrapper;
import com.liferay.portlet.messageboards.service.MBStatsUserLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBThreadLocalServiceUtil;
import com.liferay.portlet.social.model.SocialActivityConstants;
import com.liferay.portlet.social.service.SocialActivityLocalServiceUtil;
import com.liferay.util.ContentUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * As MBMessageLocalServiceImpl's methods are already overridden in MSS-hook so this hook is not used 
 * anymore also don't deploy this hook on server as it will break the functionality implemented in MSS-hook... - Jatin Panchal
 * @author jpanchal
 *
 */
@Deprecated
public class WallMBMessageLocalServiceImpl extends MBMessageLocalServiceWrapper{

	MBMessageLocalService mbMessageLocalService;
	public WallMBMessageLocalServiceImpl(
			MBMessageLocalService mbMessageLocalService) {
		super(mbMessageLocalService);	
		this.mbMessageLocalService = mbMessageLocalService;
	}
	
	
	public MBMessage updateStatus(
			long userId, long messageId, int status,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		String fromWall = null;
		if(serviceContext.getAttribute("fromWall")!=null){
			fromWall = (String)serviceContext.getAttribute("fromWall");
		}
				
		_log.info("@@@@@@@@@@@@@@ INSIDE WallMBMessageLocalServiceImpl");
		_log.info("From Wall"+ fromWall);
		
		/****
		 * For other communities and from other portlet except Social wall portlet it will call LR OOB
		 ***/
		if(fromWall == null || !fromWall.equals("true")){
			return super.updateStatus(userId, messageId, status, serviceContext);
		}
		
		_log.info("@@@@@@@@@@@@@@ From Social Wall  Execute custom code");

		
		// Message

		MBMessage message = getMessage(messageId);

		int oldStatus = message.getStatus();

		User user = UserLocalServiceUtil.getUser(userId);
		//User user = userPersistence.findByPrimaryKey(userId);
		
		Date now = new Date();

		Date modifiedDate = serviceContext.getModifiedDate(now);

		message.setStatus(status);
		message.setStatusByUserId(userId);
		message.setStatusByUserName(user.getFullName());
		message.setStatusDate(modifiedDate);
		
		mbMessageLocalService.updateMBMessage(message);
		//mbMessagePersistence.update(message);

		// Thread

		MBThread thread = MBThreadLocalServiceUtil.getMBThread(message.getThreadId());
		//MBThread thread = mbThreadPersistence.findByPrimaryKey(message.getThreadId());

		updateThreadStatus(thread, message, user, oldStatus, modifiedDate);

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
			MBMessage.class);

		if (status == WorkflowConstants.STATUS_APPROVED) {
			if (oldStatus != WorkflowConstants.STATUS_APPROVED) {

				// Asset

				if (serviceContext.isAssetEntryVisible() &&
					((message.getClassNameId() == 0) ||
					 (message.getParentMessageId() != 0))) {

					Date publishDate = null;

					AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
							message.getWorkflowClassName(), message.getMessageId());
					/*AssetEntry assetEntry = assetEntryLocalService.fetchEntry(
						message.getWorkflowClassName(), message.getMessageId());*/

					if ((assetEntry != null) &&
						(assetEntry.getPublishDate() != null)) {

						publishDate = assetEntry.getPublishDate();
					}
					else {
						publishDate = now;

						serviceContext.setCommand(Constants.ADD);
					}

					AssetEntryLocalServiceUtil.updateEntry(
							message.getWorkflowClassName(), message.getMessageId(),
							publishDate, true);
					/*assetEntryLocalService.updateEntry(
						message.getWorkflowClassName(), message.getMessageId(),
						publishDate, true);*/
				}

				if (serviceContext.isCommandAdd()) {

					// Social

					JSONObject extraDataJSONObject =
						JSONFactoryUtil.createJSONObject();

					extraDataJSONObject.put("title", message.getSubject());

					if (!message.isDiscussion() ) {
						if (!message.isAnonymous() && !user.isDefaultUser()) {
							long receiverUserId = 0;

							MBMessage parentMessage =MBMessageLocalServiceUtil.fetchMBMessage(message.getParentMessageId());
							/*MBMessage parentMessage =
								mbMessagePersistence.fetchByPrimaryKey(
									message.getParentMessageId());*/

							if (parentMessage != null) {
								receiverUserId = parentMessage.getUserId();
							}

							SocialActivityLocalServiceUtil.addActivity(
									message.getUserId(), message.getGroupId(),
									MBMessage.class.getName(),
									message.getMessageId(),1,
									extraDataJSONObject.toString(), receiverUserId);

							/*socialActivityLocalService.addActivity(
								message.getUserId(), message.getGroupId(),
								MBMessage.class.getName(),
								message.getMessageId(),
								MBActivityKeys.ADD_MESSAGE,
								extraDataJSONObject.toString(), receiverUserId);
*/
							if ((parentMessage != null) &&
								(receiverUserId != message.getUserId())) {

								SocialActivityLocalServiceUtil.addActivity(
										message.getUserId(),
										parentMessage.getGroupId(),
										MBMessage.class.getName(),
										parentMessage.getMessageId(),2,
										extraDataJSONObject.toString(), 0);
								/*socialActivityLocalService.addActivity(
									message.getUserId(),
									parentMessage.getGroupId(),
									MBMessage.class.getName(),
									parentMessage.getMessageId(),
									MBActivityKeys.REPLY_MESSAGE,
									extraDataJSONObject.toString(), 0);*/
							}
						}
					}
					else {
						String className = (String)serviceContext.getAttribute(
							"className");
						long classPK = ParamUtil.getLong(
							serviceContext, "classPK");
						long parentMessageId = message.getParentMessageId();

						if (parentMessageId !=
								MBMessageConstants.DEFAULT_PARENT_MESSAGE_ID) {

							AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
										className, classPK);
							/*AssetEntry assetEntry =
								assetEntryLocalService.fetchEntry(
									className, classPK);*/

							if (assetEntry != null) {
								extraDataJSONObject.put(
									"messageId", message.getMessageId());

								SocialActivityLocalServiceUtil.addActivity(
										message.getUserId(),
										assetEntry.getGroupId(), className, classPK,
										SocialActivityConstants.TYPE_ADD_COMMENT,
										extraDataJSONObject.toString(),
										assetEntry.getUserId());
								/*socialActivityLocalService.addActivity(
									message.getUserId(),
									assetEntry.getGroupId(), className, classPK,
									SocialActivityConstants.TYPE_ADD_COMMENT,
									extraDataJSONObject.toString(),
									assetEntry.getUserId());*/
							}
						}
					}
				}
			}

			// Subscriptions

			notifySubscribers((MBMessage)message.clone(), serviceContext);

			// Indexer

			indexer.reindex(message);

			// Ping

			//pingPingback(message, serviceContext);
		}
		else if (oldStatus == WorkflowConstants.STATUS_APPROVED) {

			// Asset

			AssetEntryLocalServiceUtil.updateVisible(
					message.getWorkflowClassName(), message.getMessageId(), false);
			/*assetEntryLocalService.updateVisible(
				message.getWorkflowClassName(), message.getMessageId(), false);*/

			// Indexer

			indexer.delete(message);
		}

		// Statistics

		if (!message.isDiscussion()) {
			MBStatsUserLocalServiceUtil.updateStatsUser(
					message.getGroupId(), userId,
					serviceContext.getModifiedDate(now));
			/*mbStatsUserLocalService.updateStatsUser(
				message.getGroupId(), userId,
				serviceContext.getModifiedDate(now));*/
		}

		return message;
	}

	protected void updateThreadStatus(
			MBThread thread, MBMessage message, User user, int oldStatus,
			Date modifiedDate)
		throws PortalException, SystemException {

		MBCategory category = null;

		int status = message.getStatus();

		if ((thread.getCategoryId() !=
				MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) &&
			(thread.getCategoryId() !=
				MBCategoryConstants.DISCUSSION_CATEGORY_ID)) {

			category = MBCategoryLocalServiceUtil.fetchMBCategory(thread.getCategoryId());
			/*category = mbCategoryPersistence.findByPrimaryKey(
				thread.getCategoryId());*/
		}

		if ((thread.getRootMessageId() == message.getMessageId()) &&
			(oldStatus != status)) {

			thread.setModifiedDate(modifiedDate);
			thread.setStatus(status);
			thread.setStatusByUserId(user.getUserId());
			thread.setStatusByUserName(user.getFullName());
			thread.setStatusDate(modifiedDate);
		}

		if (status == oldStatus) {
			return;
		}

		if (status == WorkflowConstants.STATUS_APPROVED) {
			if (message.isAnonymous()) {
				thread.setLastPostByUserId(0);
			}
			else {
				thread.setLastPostByUserId(message.getUserId());
			}

			thread.setLastPostDate(modifiedDate);

			if (category != null) {
				category.setLastPostDate(modifiedDate);

				category = MBCategoryLocalServiceUtil.updateMBCategory(category);
				/*category = mbCategoryPersistence.update(category);*/
			}
		}

		if ((oldStatus == WorkflowConstants.STATUS_APPROVED) ||
			(status == WorkflowConstants.STATUS_APPROVED)) {

			// Thread

			updateThreadMessageCount(
				thread.getCompanyId(), thread.getThreadId());

			// Category

			if ((category != null) &&
				(thread.getRootMessageId() == message.getMessageId())) {

				updateCategoryStatistics(
					category.getCompanyId(), category.getCategoryId());
			}

			if ((category != null) &&
				!(thread.getRootMessageId() == message.getMessageId())) {

				updateCategoryMessageCount(
					category.getCompanyId(), category.getCategoryId());
			}
		}

		// Indexer

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
			MBThread.class);

		indexer.reindex(thread);
		
		MBThreadLocalServiceUtil.updateMBThread(thread);
		//mbThreadPersistence.update(thread);
	}


	
	private void updateCategoryMessageCount(long companyId, final long categoryId) {
		Callable<Void> callable = new ShardCallable<Void>(companyId) {

			@Override
			protected Void doCall() throws Exception {
				MBCategory category =
					MBCategoryLocalServiceUtil.fetchMBCategory(categoryId);

				if (category == null) {
					return null;
				}

				int messageCount = MBMessageLocalServiceUtil.getCategoryMessagesCount(
						category.getGroupId(), category.getCategoryId(),
						WorkflowConstants.STATUS_APPROVED);

				category.setMessageCount(messageCount);

				MBCategoryLocalServiceUtil.updateMBCategory(category);

				return null;
			}

		};

		TransactionCommitCallbackRegistryUtil.registerCallback(callable);
		
	}


	private void updateCategoryStatistics(long companyId,final long categoryId) {
		Callable<Void> callable = new ShardCallable<Void>(companyId) {

			@Override
			protected Void doCall() throws Exception {
				MBCategory category =
					MBCategoryLocalServiceUtil.fetchMBCategory(categoryId);

				if (category == null) {
					return null;
				}

				int messageCount = MBMessageLocalServiceUtil.getCategoryMessagesCount(
						category.getGroupId(), category.getCategoryId(),
						WorkflowConstants.STATUS_APPROVED);

				int threadCount =
					MBThreadLocalServiceUtil.getCategoryThreadsCount(
						category.getGroupId(), category.getCategoryId(),
						WorkflowConstants.STATUS_APPROVED);

				category.setMessageCount(messageCount);
				category.setThreadCount(threadCount);

				MBCategoryLocalServiceUtil.updateMBCategory(category);

				return null;
			}

		};

		TransactionCommitCallbackRegistryUtil.registerCallback(callable);
		
	}


	private void updateThreadMessageCount(long companyId,final long threadId) {
 
		Callable<Void> callable = new ShardCallable<Void>(companyId) {

			@Override
			protected Void doCall() throws Exception {
				MBThread thread = MBThreadLocalServiceUtil.fetchThread(threadId);

				if (thread == null) {
					return null;
				}

				int messageCount =
					MBMessageLocalServiceUtil.getThreadMessagesCount(
						threadId, WorkflowConstants.STATUS_APPROVED);

				thread.setMessageCount(messageCount);

				MBThreadLocalServiceUtil.updateMBThread(thread);

				return null;
			}

		};

		TransactionCommitCallbackRegistryUtil.registerCallback(callable);
	}


	protected void notifySubscribers(
			MBMessage message, ServiceContext serviceContext)
		throws PortalException, SystemException {

		String layoutFullURL = serviceContext.getLayoutFullURL();
		layoutFullURL = layoutFullURL + "?post="+message.getRootMessageId();
		
		if (!message.isApproved() || Validator.isNull(layoutFullURL)) {
			return;
		}

		if (message.isDiscussion()) {
			try {
				notifyDiscussionSubscribers(message, serviceContext);
			}
			catch (Exception e) {
				_log.error(e, e);
			}

			return;
		}
/*
		PortletPreferences preferences =
			ServiceContextUtil.getPortletPreferences(serviceContext);

		if (preferences == null) {
			long ownerId = message.getGroupId();
			int ownerType = PortletKeys.PREFS_OWNER_TYPE_GROUP;
			long plid = PortletKeys.PREFS_PLID_SHARED;
			String portletId = PortletKeys.MESSAGE_BOARDS;
			String defaultPreferences = null;

			preferences = PortletPreferencesLocalServiceUtil.getPreferences(
					message.getCompanyId(), ownerId, ownerType, plid, portletId,
					defaultPreferences);
			preferences = portletPreferencesLocalService.getPreferences(
				message.getCompanyId(), ownerId, ownerType, plid, portletId,
				defaultPreferences);
		}

		if (serviceContext.isCommandAdd() &&
			getEmailMessageAddedEnabled(preferences)) {
		}
		else if (serviceContext.isCommandUpdate() &&
			getEmailMessageUpdatedEnabled(preferences)) {
		}
		else {
			return;
		}
		
		Company company = companyPersistence.findByPrimaryKey(
			message.getCompanyId());

		Group group = groupPersistence.findByPrimaryKey(message.getGroupId());

		Company company = CompanyLocalServiceUtil.fetchCompany(message.getCompanyId());
		
		Group group = GroupLocalServiceUtil.fetchGroup(message.getGroupId());
		
		String emailAddress = PortalUtil.getUserEmailAddress(
			message.getUserId());
		String fullName = PortalUtil.getUserName(
			message.getUserId(), message.getUserName());

		if (message.isAnonymous()) {
			emailAddress = StringPool.BLANK;
			fullName = serviceContext.translate("anonymous");
		}
*/
		
		Company company = CompanyLocalServiceUtil.fetchCompany(message.getCompanyId());
		
		Group group = GroupLocalServiceUtil.fetchGroup(message.getGroupId());
		
		MBCategory category = message.getCategory();

		String categoryName = category.getName();

		if (category.getCategoryId() ==
				MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) {

			categoryName = serviceContext.translate("message-boards-home");

			categoryName += " - " + group.getDescriptiveName();
		}

		List<Long> categoryIds = new ArrayList<Long>();

		categoryIds.add(message.getCategoryId());

		if (message.getCategoryId() !=
				MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) {

			categoryIds.addAll(category.getAncestorCategoryIds());
		}

		String unsubscribeLink = (String) serviceContext.getAttribute("hiddenUnsubURL");
		unsubscribeLink = StringUtil.replace(unsubscribeLink, "messageIdValue", ""+message.getMessageId());

		/*String fromName = MBUtil.getEmailFromName(
			preferences, message.getCompanyId());
		String fromAddress = MBUtil.getEmailFromAddress(
			preferences, message.getCompanyId());
		
		if (PropsValues.POP_SERVER_NOTIFICATIONS_ENABLED) {
			replyToAddress = MBUtil.getReplyToAddress(
				message.getCategoryId(), message.getMessageId(),
				company.getMx(), fromAddress);
		}

		String subject = null;
		String body = null;
		String signature = null;

		if (serviceContext.isCommandUpdate()) {
			subject = MBUtil.getEmailMessageUpdatedSubject(preferences);
			body = MBUtil.getEmailMessageUpdatedBody(preferences);
			signature = MBUtil.getEmailMessageUpdatedSignature(preferences);
		}
		else {
			subject = MBUtil.getEmailMessageAddedSubject(preferences);
			body = MBUtil.getEmailMessageAddedBody(preferences);
			signature = MBUtil.getEmailMessageAddedSignature(preferences);
		}
		
		boolean htmlFormat = MBUtil.getEmailHtmlFormat(preferences);

		if (Validator.isNotNull(signature)) {
			String signatureSeparator = null;

			if (htmlFormat) {
				signatureSeparator = "<br />--<br />";
			}
			else {
				signatureSeparator = "\n--\n";
			}

			body += signatureSeparator + signature;
		}

		String messageBody = message.getBody();

		if (htmlFormat && message.isFormatBBCode()) {
			try {
				messageBody = BBCodeTranslatorUtil.getHTML(messageBody);

				HttpServletRequest request = serviceContext.getRequest();

				if (request != null) {
					ThemeDisplay themeDisplay =
						(ThemeDisplay)request.getAttribute(
							WebKeys.THEME_DISPLAY);

					messageBody = MBUtil.replaceMessageBodyPaths(
						themeDisplay, messageBody);
				}
			}
			catch (Exception e) {
				_log.error(
					"Could not parse message " + message.getMessageId() +
						" " + e.getMessage());
			}
		}

		String inReplyTo = null;

		if (message.getParentMessageId() !=
				MBMessageConstants.DEFAULT_PARENT_MESSAGE_ID) {

			inReplyTo = PortalUtil.getMailId(
				company.getMx(), MBUtil.MESSAGE_POP_PORTLET_PREFIX,
				message.getCategoryId(), message.getParentMessageId());
		}

		SubscriptionSender subscriptionSenderPrototype =
			new MBSubscriptionSender();

		subscriptionSenderPrototype.setBody(body);
		subscriptionSenderPrototype.setBulk(
			PropsValues.MESSAGE_BOARDS_EMAIL_BULK);
		subscriptionSenderPrototype.setCompanyId(message.getCompanyId());
		subscriptionSenderPrototype.setContextAttribute(
			"[$MESSAGE_BODY$]", messageBody, false);
		subscriptionSenderPrototype.setContextAttributes(
			"[$CATEGORY_NAME$]", categoryName, "[$MAILING_LIST_ADDRESS$]",
			replyToAddress, "[$MESSAGE_ID$]", message.getMessageId(),
			"[$MESSAGE_SUBJECT$]", message.getSubject(), "[$MESSAGE_URL$]",
			getMessageURL(message, serviceContext), "[$MESSAGE_USER_ADDRESS$]",
			emailAddress, "[$MESSAGE_USER_NAME$]", fullName);
		subscriptionSenderPrototype.setFrom(fromAddress, fromName);
		subscriptionSenderPrototype.setHtmlFormat(htmlFormat);
		subscriptionSenderPrototype.setInReplyTo(inReplyTo);
		subscriptionSenderPrototype.setMailId(
			MBUtil.MESSAGE_POP_PORTLET_PREFIX, message.getCategoryId(),
			message.getMessageId());
		subscriptionSenderPrototype.setPortletId(PortletKeys.MESSAGE_BOARDS);
		subscriptionSenderPrototype.setReplyToAddress(replyToAddress);
		subscriptionSenderPrototype.setScopeGroupId(message.getGroupId());
		subscriptionSenderPrototype.setServiceContext(serviceContext);
		subscriptionSenderPrototype.setSubject(subject);
		subscriptionSenderPrototype.setUserId(message.getUserId());

		SubscriptionSender subscriptionSender =
			(SubscriptionSender)SerializableUtil.clone(
				subscriptionSenderPrototype);

		subscriptionSender.addPersistedSubscribers(
			MBCategory.class.getName(), message.getGroupId());

		for (long categoryId : categoryIds) {
			if (categoryId != MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) {
				subscriptionSender.addPersistedSubscribers(
					MBCategory.class.getName(), categoryId);
			}
		}

		subscriptionSender.addPersistedSubscribers(
			MBThread.class.getName(), message.getThreadId());

		notify(
			subscriptionSender, subscriptionSenderPrototype,
			message.getGroupId(), categoryIds);
		*/
		
		String fromName = PropsUtil.get("socialportlet.email.fromname");	
		String fromAddress = PropsUtil.get("socialportlet.portlet.email.fromaddress");	

		String discussion=message.getSubject();
		discussion=discussion.toUpperCase();
		String subject = getSubject(message.getParentMessageId()==MBMessageConstants.DEFAULT_PARENT_MESSAGE_ID,message.getCategory());
		String template = getBodyTemplate(message.getParentMessageId()==MBMessageConstants.DEFAULT_PARENT_MESSAGE_ID);
		String[] oldSubs = new String[] {"[$discussion$]","[$group_name$]", "[$user_name$]", "[$link$]", "[$unsubscribe_link$]", "[$email_admin_name$]", "[$commenter$]", "[$message$]"};
		String[] newSubs = new String[] {discussion, category.getName(), message.getUserName(), layoutFullURL, "", fromName, message.getUserName(), message.getBody()};
		String body = StringUtil.replace(template, oldSubs, newSubs);
		
		com.liferay.portal.kernel.messaging.Message messagingObj =
			new com.liferay.portal.kernel.messaging.Message();
		messagingObj.put("companyId", message.getCompanyId());
		messagingObj.put("userId", message.getUserId());
		messagingObj.put("groupId", message.getGroupId());
		messagingObj.put("categoryIds", StringUtil.merge(categoryIds));
		messagingObj.put("threadId", message.getThreadId());
		messagingObj.put("fromName", fromName);
		messagingObj.put("fromAddress", fromAddress);
		messagingObj.put("subject", subject);
		messagingObj.put("body", body);
		//messagingObj.put("replyToAddress", replyToAddress);
		messagingObj.put("mailId", "");
		//messagingObj.put("inReplyTo", inReplyTo);
		messagingObj.put("htmlFormat", Boolean.TRUE);
		messagingObj.put("sourceMailingList", true);
		
		MessageBusUtil.sendMessage("liferay/message_boards", messagingObj);
	}
	

	protected void notifyDiscussionSubscribers(
			MBMessage message, ServiceContext serviceContext)
		throws SystemException {

		if (!PrefsPropsUtil.getBoolean(
				message.getCompanyId(),
				PropsKeys.DISCUSSION_EMAIL_COMMENTS_ADDED_ENABLED)) {

			return;
		}

		String contentURL = (String)serviceContext.getAttribute("contentURL");

		String userAddress = StringPool.BLANK;
		String userName = (String)serviceContext.getAttribute(
			"pingbackUserName");

		if (Validator.isNull(userName)) {
			userAddress = PortalUtil.getUserEmailAddress(message.getUserId());
			userName = PortalUtil.getUserName(
				message.getUserId(), StringPool.BLANK);
		}

		String fromName = PrefsPropsUtil.getString(
			message.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_NAME);
		String fromAddress = PrefsPropsUtil.getString(
			message.getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);

		String subject = PrefsPropsUtil.getContent(
			message.getCompanyId(), PropsKeys.DISCUSSION_EMAIL_SUBJECT);
		String body = PrefsPropsUtil.getContent(
			message.getCompanyId(), PropsKeys.DISCUSSION_EMAIL_BODY);

		SubscriptionSender subscriptionSender = new SubscriptionSender();

		subscriptionSender.setBody(body);
		subscriptionSender.setCompanyId(message.getCompanyId());
		subscriptionSender.setContextAttribute(
			"[$COMMENTS_BODY$]", message.getBody(true), false);
		subscriptionSender.setContextAttributes(
			"[$COMMENTS_USER_ADDRESS$]", userAddress, "[$COMMENTS_USER_NAME$]",
			userName, "[$CONTENT_URL$]", contentURL);
		subscriptionSender.setFrom(fromAddress, fromName);
		subscriptionSender.setHtmlFormat(true);
		subscriptionSender.setMailId(
			"mb_discussion", message.getCategoryId(), message.getMessageId());
		subscriptionSender.setScopeGroupId(message.getGroupId());
		subscriptionSender.setServiceContext(serviceContext);
		subscriptionSender.setSubject(subject);
		subscriptionSender.setUserId(message.getUserId());

		String className = (String)serviceContext.getAttribute("className");
		long classPK = ParamUtil.getLong(serviceContext, "classPK");

		subscriptionSender.addPersistedSubscribers(className, classPK);

		subscriptionSender.flushNotificationsAsync();
	}
	public static String getSubject(boolean isPost, MBCategory category){
		String subjectTeplate="[$group_name$] wall: New discussion started";
		if(isPost){
			subjectTeplate = "[$group_name$] wall: New discussion started";			
		}else{
			subjectTeplate = "[$group_name$] wall: New comment posted";			
		}
		String subject = StringUtil.replace(subjectTeplate, new String[] {"[$group_name$]"}, new String[]{category.getName()});	
		return subject;
	}
	
	public static String getBodyTemplate(boolean isPost){
		if(isPost){
			return ContentUtil.get("com/ihg/merlin2/socialnetworking/impl/start_thread.vm");	
		}else{
			return ContentUtil.get("com/ihg/merlin2/socialnetworking/impl/new_comment.vm");	
		}
	}
	
	public static String getMailingListAddress(
			long groupId, long categoryId, long messageId, String mx,
			String defaultMailingListAddress) {

			if (PropsUtil.get(PropsKeys.POP_SERVER_SUBDOMAIN).length() <= 0) {
				String mailingListAddress = defaultMailingListAddress;

				try {
					MBMailingList mailingList =
						MBMailingListLocalServiceUtil.getCategoryMailingList(
							groupId, categoryId);

					if (mailingList.isActive()) {
						mailingListAddress = mailingList.getEmailAddress();
					}
				}
				catch (Exception e) {
				}

				return mailingListAddress;
			}

			StringBundler sb = new StringBundler(8);
			sb.append("mb.");
			sb.append(categoryId);
			sb.append(StringPool.PERIOD);
			sb.append(messageId);
			sb.append(StringPool.AT);
			sb.append(PropsUtil.get(PropsKeys.POP_SERVER_SUBDOMAIN));
			sb.append(StringPool.PERIOD);
			sb.append(mx);

			return sb.toString();
		}
	
	public static String getMailId(String mx, long categoryId, long messageId) {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.LESS_THAN);
		sb.append("mb.");
		sb.append(categoryId);
		sb.append(StringPool.PERIOD);
		sb.append(messageId);
		sb.append(StringPool.AT);

		sb.append(mx);
		sb.append(StringPool.GREATER_THAN);

		return sb.toString();
	}
	
	private static Log _log = LogFactoryUtil.getLog(
			WallMBMessageLocalServiceImpl.class);
}
