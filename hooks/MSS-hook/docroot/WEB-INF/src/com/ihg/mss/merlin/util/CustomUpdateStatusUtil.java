package com.ihg.mss.merlin.util;

import com.liferay.portal.kernel.dao.shard.ShardCallable;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.transaction.TransactionCommitCallbackRegistryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portal.util.SubscriptionSender;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.messageboards.model.MBCategory;
import com.liferay.portlet.messageboards.model.MBCategoryConstants;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBMessageConstants;
import com.liferay.portlet.messageboards.model.MBThread;
import com.liferay.portlet.messageboards.service.MBCategoryLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBMessageLocalService;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBStatsUserLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBThreadLocalServiceUtil;
import com.liferay.portlet.social.model.SocialActivityConstants;
import com.liferay.portlet.social.service.SocialActivityLocalServiceUtil;
import com.liferay.util.ContentUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

public class CustomUpdateStatusUtil 
{
	
	public static MBMessage me2WallUpdateStatus(long userId, long messageId, int status,
			MBMessage message, ServiceContext serviceContext) throws PortalException,SystemException{
				
				int oldStatus = message.getStatus();
				User user = UserLocalServiceUtil.fetchUser(userId);
				//User user = userPersistence.findByPrimaryKey(userId);
				Date now = new Date();

				Date modifiedDate = serviceContext.getModifiedDate(now);

				message.setStatus(status);
				message.setStatusByUserId(userId);
				message.setStatusByUserName(user.getFullName());
				message.setStatusDate(modifiedDate);
				
				MBMessageLocalServiceUtil.updateMBMessage(message);
				
				//mbMessagePersistence.update();

				// Thread
				
				MBThread thread = MBThreadLocalServiceUtil.fetchMBThread(message.getThreadId());
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
							
							AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(message.getWorkflowClassName(), message.getMessageId());
							
							//AssetEntry assetEntry = assetEntryLocalService.fetchEntry(message.getWorkflowClassName(), message.getMessageId());

							if ((assetEntry != null) &&
								(assetEntry.getPublishDate() != null)) {

								publishDate = assetEntry.getPublishDate();
							}
							else {
								publishDate = now;

								serviceContext.setCommand(Constants.ADD);
							}
							
							AssetEntryLocalServiceUtil.updateEntry(message.getWorkflowClassName(), message.getMessageId(), publishDate, true);
							
							//assetEntryLocalService.updateEntry(message.getWorkflowClassName(), message.getMessageId(), publishDate, true);
							
						}

						if (serviceContext.isCommandAdd()) {

							// Social

							JSONObject extraDataJSONObject =
								JSONFactoryUtil.createJSONObject();

							extraDataJSONObject.put("title", message.getSubject());

							if (!message.isDiscussion() ) {
								if (!message.isAnonymous() && !user.isDefaultUser()) {
									long receiverUserId = 0;

									
									MBMessage parentMessage = MBMessageLocalServiceUtil.fetchMBMessage(message.getParentMessageId());
									//MBMessage parentMessage = mbMessagePersistence.fetchByPrimaryKey(message.getParentMessageId());

									if (parentMessage != null) {
										receiverUserId = parentMessage.getUserId();
									}
									
									SocialActivityLocalServiceUtil.addActivity(message.getUserId(), message.getGroupId(), MBMessage.class.getName(), message.getMessageId(), 1,	extraDataJSONObject.toString(), receiverUserId);
									//socialActivityLocalService.addActivity(message.getUserId(), message.getGroupId(), MBMessage.class.getName(), message.getMessageId(), 1,	extraDataJSONObject.toString(), receiverUserId);

									if ((parentMessage != null) &&
										(receiverUserId != message.getUserId())) {
										
										SocialActivityLocalServiceUtil.addActivity(message.getUserId(),
											parentMessage.getGroupId(),
											MBMessage.class.getName(),
											parentMessage.getMessageId(),
											2,
											extraDataJSONObject.toString(), 0);
										
										/*socialActivityLocalService.addActivity(
											message.getUserId(),
											parentMessage.getGroupId(),
											MBMessage.class.getName(),
											parentMessage.getMessageId(),
											2,
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

									AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(className, classPK);
									
									//AssetEntry assetEntry =	assetEntryLocalService.fetchEntry(className, classPK);

									if (assetEntry != null) {
										extraDataJSONObject.put(
											"messageId", message.getMessageId());
										
										SocialActivityLocalServiceUtil.addActivity(message.getUserId(),
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

					//notifySubscribers((MBMessage)message.clone(), serviceContext);
					
					// Indexer

					indexer.reindex(message);

					// Ping

//					pingPingback(message, serviceContext);
				}
				else if (oldStatus == WorkflowConstants.STATUS_APPROVED) {

					// Asset
					
					AssetEntryLocalServiceUtil.updateVisible(message.getWorkflowClassName(), message.getMessageId(), false);
					//assetEntryLocalService.updateVisible(message.getWorkflowClassName(), message.getMessageId(), false);

					// Indexer

					indexer.delete(message);
				}

				// Statistics

				if (!message.isDiscussion()) {
					MBStatsUserLocalServiceUtil.updateStatsUser(message.getGroupId(), userId,
							serviceContext.getModifiedDate(now));
					/*mbStatsUserLocalService.updateStatsUser(
						message.getGroupId(), userId,
						serviceContext.getModifiedDate(now));*/
				}

				return message;
			}
	
	public static MBMessage customUpdateStatue(long userId, long messageId, int status,MBMessageLocalService mbMessageLocalService,MBMessage message,
			ServiceContext serviceContext) throws PortalException,SystemException
	{
		if(_log.isDebugEnabled())
		{
			_log.debug("Inside custom update status method for =========================");
			_log.debug("MessageID ::"+ messageId);
			_log.debug("GroupID ::"+ message.getGroupId());
			_log.debug("UserID ::"+ userId);
			_log.debug("=================================================================");
		}
		
		// Message

		//MBMessage message = getMessage(messageId);

		int oldStatus = message.getStatus();

		//User user = userPersistence.findByPrimaryKey(userId);
		User user = UserLocalServiceUtil.getUser(userId);
		Date now = new Date();

		Date modifiedDate = serviceContext.getModifiedDate(now);

		message.setStatus(status);
		message.setStatusByUserId(userId);
		message.setStatusByUserName(user.getFullName());
		message.setStatusDate(modifiedDate);

		//mbMessagePersistence.update(message);
		mbMessageLocalService.updateMBMessage(message);

		// Thread

		//MBThread thread = mbThreadPersistence.findByPrimaryKey(message.getThreadId());
		MBThread thread = MBThreadLocalServiceUtil.getMBThread(message.getThreadId());

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

					/*AssetEntry assetEntry = assetEntryLocalService.fetchEntry(
						message.getWorkflowClassName(), message.getMessageId());*/
					AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
							message.getWorkflowClassName(), message.getMessageId());

					if ((assetEntry != null) &&
						(assetEntry.getPublishDate() != null)) {

						publishDate = assetEntry.getPublishDate();
					}
					else {
						publishDate = now;

						serviceContext.setCommand(Constants.ADD);
					}

					/*assetEntryLocalService.updateEntry(
						message.getWorkflowClassName(), message.getMessageId(),
						publishDate, true);*/

					AssetEntryLocalServiceUtil.updateEntry(
							message.getWorkflowClassName(), message.getMessageId(),
							publishDate, true);
				}

				if (serviceContext.isCommandAdd()) {

					// Social

					JSONObject extraDataJSONObject =
						JSONFactoryUtil.createJSONObject();

					extraDataJSONObject.put("title", message.getSubject());

					if (!message.isDiscussion() ) {
						if (!message.isAnonymous() && !user.isDefaultUser()) {
							long receiverUserId = 0;

							/*MBMessage parentMessage =
								mbMessagePersistence.fetchByPrimaryKey(
									message.getParentMessageId());*/
							MBMessage parentMessage =MBMessageLocalServiceUtil.fetchMBMessage(message.getParentMessageId());

							if (parentMessage != null) {
								receiverUserId = parentMessage.getUserId();
							}

							/*socialActivityLocalService.addActivity(
								message.getUserId(), message.getGroupId(),
								MBMessage.class.getName(),
								message.getMessageId(),
								MBActivityKeys.ADD_MESSAGE,
								extraDataJSONObject.toString(), receiverUserId);*/
							
							SocialActivityLocalServiceUtil.addActivity(
									message.getUserId(), message.getGroupId(),
									MBMessage.class.getName(),
									message.getMessageId(),1,
									extraDataJSONObject.toString(), receiverUserId);

							if ((parentMessage != null) &&
								(receiverUserId != message.getUserId())) {

								/*socialActivityLocalService.addActivity(
									message.getUserId(),
									parentMessage.getGroupId(),
									MBMessage.class.getName(),
									parentMessage.getMessageId(),
									MBActivityKeys.REPLY_MESSAGE,
									extraDataJSONObject.toString(), 0);*/
								SocialActivityLocalServiceUtil.addActivity(
										message.getUserId(),
										parentMessage.getGroupId(),
										MBMessage.class.getName(),
										parentMessage.getMessageId(),2,
										extraDataJSONObject.toString(), 0);
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

							/*AssetEntry assetEntry =
								assetEntryLocalService.fetchEntry(
									className, classPK);*/
							AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
									className, classPK);

							if (assetEntry != null) {
								extraDataJSONObject.put(
									"messageId", message.getMessageId());

								/*socialActivityLocalService.addActivity(
									message.getUserId(),
									assetEntry.getGroupId(), className, classPK,
									SocialActivityConstants.TYPE_ADD_COMMENT,
									extraDataJSONObject.toString(),
									assetEntry.getUserId());*/
								SocialActivityLocalServiceUtil.addActivity(
										message.getUserId(),
										assetEntry.getGroupId(), className, classPK,
										SocialActivityConstants.TYPE_ADD_COMMENT,
										extraDataJSONObject.toString(),
										assetEntry.getUserId());
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
		else if (oldStatus == WorkflowConstants.STATUS_APPROVED) 
		{

			// Asset

		/*	assetEntryLocalService.updateVisible(
				message.getWorkflowClassName(), message.getMessageId(), false);*/
			AssetEntryLocalServiceUtil.updateVisible(
					message.getWorkflowClassName(), message.getMessageId(), false);

			// Indexer

			indexer.delete(message);
		}

		// Statistics

		if (!message.isDiscussion()) 
		{
			/*mbStatsUserLocalService.updateStatsUser(
				message.getGroupId(), userId,
				serviceContext.getModifiedDate(now));*/
			
			MBStatsUserLocalServiceUtil.updateStatsUser(
					message.getGroupId(), userId,
					serviceContext.getModifiedDate(now));
		}

		return message;
	}
	
	/**
	 * @param thread
	 * @param message
	 * @param user
	 * @param oldStatus
	 * @param modifiedDate
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static void updateThreadStatus(
			MBThread thread, MBMessage message, User user, int oldStatus,
			Date modifiedDate)
		throws PortalException, SystemException
		{

			MBCategory category = null;
	
			int status = message.getStatus();
	
			if ((thread.getCategoryId() !=
					MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) &&
				(thread.getCategoryId() !=
					MBCategoryConstants.DISCUSSION_CATEGORY_ID)) {
	
				/*category = mbCategoryPersistence.findByPrimaryKey(
					thread.getCategoryId());*/
				category = MBCategoryLocalServiceUtil.fetchMBCategory(thread.getCategoryId());
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
	
					/*category = mbCategoryPersistence.update(category);*/
					category = MBCategoryLocalServiceUtil.updateMBCategory(category);
				}
			}
	
			if ((oldStatus == WorkflowConstants.STATUS_APPROVED) ||
				(status == WorkflowConstants.STATUS_APPROVED)) {
	
				// Thread
	
				/*MBUtil.updateThreadMessageCount(
					thread.getCompanyId(), thread.getThreadId());*/
				updateThreadMessageCount(
						thread.getCompanyId(), thread.getThreadId());
	
				// Category
	
				if ((category != null) &&
					(thread.getRootMessageId() == message.getMessageId())) {
	
					/*MBUtil.updateCategoryStatistics(
						category.getCompanyId(), category.getCategoryId());*/
					updateCategoryStatistics(
							category.getCompanyId(), category.getCategoryId());
				}
	
				if ((category != null) &&
					!(thread.getRootMessageId() == message.getMessageId())) {
	
					/*MBUtil.updateCategoryMessageCount(
						category.getCompanyId(), category.getCategoryId());*/
					updateCategoryMessageCount(
							category.getCompanyId(), category.getCategoryId());
				}
			}
	
			// Indexer
	
			Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
				MBThread.class);
	
			indexer.reindex(thread);
	
			/*mbThreadPersistence.update(thread);*/
			
			MBThreadLocalServiceUtil.updateMBThread(thread);
	}
	
	/**
	 * @param companyId
	 * @param categoryId
	 */
	private  static void updateCategoryMessageCount(long companyId, final long categoryId) {
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


	/**
	 * @param companyId
	 * @param categoryId
	 */
	private  static void updateCategoryStatistics(long companyId,final long categoryId) 
	{
		Callable<Void> callable = new ShardCallable<Void>(companyId) 
				{

				@Override
				protected Void doCall() throws Exception 
				{
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


	/**
	 * @param companyId
	 * @param threadId
	 */
	private static  void updateThreadMessageCount(long companyId,final long threadId) {
 
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
	
	
	/**
	 * @param message
	 * @param serviceContext
	 * @throws PortalException
	 * @throws SystemException
	 */
	protected static void notifySubscribers(MBMessage message, ServiceContext serviceContext)	throws PortalException, SystemException 
		{

			String layoutFullURL = serviceContext.getLayoutFullURL();
			
			if(layoutFullURL.contains("/grs-") || layoutFullURL.contains("/heartbeat/")){
				layoutFullURL = layoutFullURL + "?id="+message.getThreadId();
			}
			else{
				layoutFullURL = layoutFullURL + "?post="+message.getRootMessageId();
			}
			
			if(_log.isDebugEnabled())
			{
				_log.debug("Custom layoutFullURL::: "+ layoutFullURL);
			}
			
			if (!message.isApproved() || Validator.isNull(layoutFullURL)) 
			{
				return;
			}
	
			if (message.isDiscussion()) 
			{
				try 
				{
					notifyDiscussionSubscribers(message, serviceContext);
				}
				catch (Exception e) 
				{
					_log.error(e, e);
				}
	
				return;
			}
			
			
			
			MBCategory category = message.getCategory();
	
			List<Long> categoryIds = new ArrayList<Long>();
	
			categoryIds.add(message.getCategoryId());
	
			if (message.getCategoryId() !=	MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID)
			{
	
				categoryIds.addAll(category.getAncestorCategoryIds());
			}
	
			String unsubscribeLink = (String) serviceContext.getAttribute("hiddenUnsubURL");
			unsubscribeLink = StringUtil.replace(unsubscribeLink, "messageIdValue", ""+message.getMessageId());
				
			String fromName = PropsUtil.get("socialportlet.email.fromname");	
			String fromAddress = PropsUtil.get("socialportlet.portlet.email.fromaddress");	
	
			String discussion=message.getSubject();
			discussion=discussion.toUpperCase();
			String subject = StringPool.BLANK;
			String template = StringPool.BLANK;
			if(layoutFullURL.contains("/heartbeat/")){
				subject = getHeartbeatSubject();
				template = getHeartbeatBodyTemplate();
			}
			else{
				subject = getSubject(message.getParentMessageId()==MBMessageConstants.DEFAULT_PARENT_MESSAGE_ID,message.getCategory());
				template = getBodyTemplate(message.getParentMessageId()==MBMessageConstants.DEFAULT_PARENT_MESSAGE_ID);
			}
			String[] oldSubs = new String[] {"[$discussion$]","[$group_name$]", "[$user_name$]", "[$link$]", "[$unsubscribe_link$]", "[$email_admin_name$]", "[$commenter$]", "[$message$]"};
			String[] newSubs = new String[] {discussion, category.getName(), message.getUserName(), layoutFullURL, "", fromName, message.getUserName(), message.getBody()};
			String body = StringUtil.replace(template, oldSubs, newSubs);
			
			
			
			String emailAddress = PortalUtil.getUserEmailAddress(message.getUserId());
			String fullName = PortalUtil.getUserName(message.getUserId(), message.getUserName());
			Company company = CompanyLocalServiceUtil.fetchCompany(message.getCompanyId());
			String inReplyTo = null;

			if (message.getParentMessageId() !=
					MBMessageConstants.DEFAULT_PARENT_MESSAGE_ID) {

				inReplyTo = PortalUtil.getMailId(
					company.getMx(), "mb_message.",
					message.getCategoryId(), message.getParentMessageId());
			}
			
			if(_log.isDebugEnabled())
			{
				_log.debug("Preparing email for subscribers =========================");
				_log.debug("fromName ::" + fromName);
				_log.debug("fromAddress ::" + fromAddress);
				_log.debug("discussion ::" + discussion);
				_log.debug("subject ::" + subject);
				_log.debug("body ::" + body);
				_log.debug("category.getName():::"+ category.getName());
				_log.debug("emailAddress::"+ emailAddress);
				_log.debug("fullName:::"+ fullName);
				_log.debug("inReplyTo:::"+ inReplyTo);
			}
			
				/*Preparing object for Subscription sender*/
				SubscriptionSender subscriptionSender =	new SubscriptionSender();

				subscriptionSender.setBody(body);
				subscriptionSender.setBulk(true);
				subscriptionSender.setCompanyId(message.getCompanyId());
				subscriptionSender.setContextAttribute("[$MESSAGE_BODY$]", body, false);
				subscriptionSender.setContextAttributes(
					"[$CATEGORY_NAME$]", category.getName(), "[$MAILING_LIST_ADDRESS$]",
					fromAddress, "[$MESSAGE_ID$]", message.getMessageId(),
					"[$MESSAGE_SUBJECT$]", subject, "[$MESSAGE_URL$]",
					layoutFullURL, "[$MESSAGE_USER_ADDRESS$]",
					emailAddress, "[$MESSAGE_USER_NAME$]", fullName);
				subscriptionSender.setFrom(fromAddress, fromName);
				subscriptionSender.setHtmlFormat(true);
				subscriptionSender.setInReplyTo(inReplyTo);
				subscriptionSender.setMailId("mb_discussion.", message.getCategoryId(),message.getMessageId());
				subscriptionSender.setPortletId(PortletKeys.MESSAGE_BOARDS);
				subscriptionSender.setReplyToAddress(fromAddress);
				subscriptionSender.setScopeGroupId(message.getGroupId());
				subscriptionSender.setServiceContext(serviceContext);
				subscriptionSender.setSubject(subject);
				subscriptionSender.setUserId(message.getUserId());
			
				//subscriptionSender.addPersistedSubscribers(MBCategory.class.getName(), message.getGroupId());
			
				subscriptionSender.addPersistedSubscribers(MBThread.class.getName(), message.getThreadId());
			
				_log.info("Subscription is sending for className::"+MBThread.class.getName() +" & classPK::"+ message.getThreadId() );
			
				/*Scheduling subscription Asynch*/
				subscriptionSender.flushNotificationsAsync();
	}

	
	/**
	 * @param message
	 * @param serviceContext
	 * @throws SystemException
	 */
	protected static void notifyDiscussionSubscribers(MBMessage message, ServiceContext serviceContext)
		throws SystemException 
		{

			if (!PrefsPropsUtil.getBoolean(
					message.getCompanyId(),
					PropsKeys.DISCUSSION_EMAIL_COMMENTS_ADDED_ENABLED))
			{
				return;
			}
	
			String contentURL = (String)serviceContext.getAttribute("contentURL");
			
			if(_log.isDebugEnabled())
			{
				_log.debug("Content URL:::"+ contentURL);
			}
	
			String userAddress = StringPool.BLANK;
			String userName = (String)serviceContext.getAttribute("pingbackUserName");
	
			if (Validator.isNull(userName)) 
			{
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
				"mb_message.", message.getCategoryId(), message.getMessageId());
			
			subscriptionSender.setScopeGroupId(message.getGroupId());
			subscriptionSender.setServiceContext(serviceContext);
			subscriptionSender.setSubject(subject);
			subscriptionSender.setUserId(message.getUserId());
	
			String className = (String)serviceContext.getAttribute("className");
			long classPK = ParamUtil.getLong(serviceContext, "classPK");
	
			subscriptionSender.addPersistedSubscribers(className, classPK);
	
			subscriptionSender.flushNotificationsAsync();
	}
	
	/**
	 * @param isPost
	 * @param category
	 * @return
	 */
	public static String getSubject(boolean isPost, MBCategory category)
	{
		String subjectTeplate="[$group_name$] wall: New discussion started";
		if(isPost)
		{
			subjectTeplate = "[$group_name$] wall: New discussion started";			
		}else
		{
			subjectTeplate = "[$group_name$] wall: New comment posted";			
		}
		String subject = StringUtil.replace(subjectTeplate, new String[] {"[$group_name$]"}, new String[]{category.getName()});	
		return subject;
	}
	
	/**
	 * @return
	 */
	public static String getHeartbeatSubject()
	{
		return "HeartBeat Initiatives Discussion: New comment posted";
	}
	
	/**
	 * @param isPost
	 * @return
	 */
	public static String getBodyTemplate(boolean isPost)
	{
		if(isPost)
		{
			return ContentUtil.get("com/ihg/mss/merlin/util/start_thread.vm");	
		}else
		{
			return ContentUtil.get("com/ihg/mss/merlin/util/new_comment.vm");	
		}
	}
	
	/**
	 * @return
	 */
	public static String getHeartbeatBodyTemplate()
	{
		return ContentUtil.get("com/ihg/mss/merlin/util/new_heartbeat_comment.vm");
	}

	private static final Log _log = LogFactoryUtil.getLog(CustomUpdateStatusUtil.class);
	
}
