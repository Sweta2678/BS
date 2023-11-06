package com.ihg.mss.service.messageboards;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.ihg.me2.wall.servlet.WallNotificationServlet;
import com.ihg.mss.merlin.util.CustomUpdateStatusUtil;
import com.ihg.mss.portal.util.CommonUtil;
import com.ihg.mss.portal.util.MSSCommonsUtil;
import com.ihg.mss.util.HookNitroServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.service.MBMessageLocalService;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceWrapper;


/**
 * Custom Service Wrapper Implementation for Message Boards to gamify it.
 * Custom Service Wrapper Implementation for 'COMMENTS' to gamify Liferay Commenting Framework
 * 
 * Gamified component:  1. 'Web-Content Comments'
 * 						2. 'START NEW THREAD' 		- Action Type -3 "Sector"
 * 						3. 'POST REPLY/COMMENT'		- Action Type -3 "Sector"
 * 						4. 'UPDATE COMMENT/THREAD'  - Action Type -3 "Sector"
 *  
 * 
 * @author Jay Patel
 *
 */

public class MeetingPointMessageboardLocalServiceImpl extends MBMessageLocalServiceWrapper
{
	
	MBMessageLocalService mbMessageLocalService;
	
	public MeetingPointMessageboardLocalServiceImpl(MBMessageLocalService mbMessageLocalService) 
	{
		super(mbMessageLocalService);
		this.mbMessageLocalService = mbMessageLocalService;
	}

	
	/**
	 * Gamified "Add Comment Message" for 
	 * 1. Web-content
	 * 
	 * @param userId
	 * @param userName
	 * @param groupId
	 * @param className
	 * @param classPK
	 * @param threadId
	 * @param parentMessageId
	 * @param subject
	 * @param body
	 * @param serviceContext
	 * @throws PortalException
	 * @throws SystemException
	 * 
	 */
	@Override
	public MBMessage addDiscussionMessage(
			long userId, String userName, long groupId, String className,
			long classPK, long threadId, long parentMessageId, String subject,
			String body, ServiceContext serviceContext) throws PortalException, SystemException
			{

		MBMessage message = super.addDiscussionMessage(userId, userName, groupId, className, classPK, 
				threadId, parentMessageId, subject, body, serviceContext);

		/**
		 * Check if the site is one of the Meeting Point Sites
		 */
		boolean isMeetingPointSite = MSSCommonsUtil.isMeetingPointSite(groupId);

		_log.info("MeetingPointMessageboardLocalServiceImpl.addDiscussionMessage()");
		

		/**
		 * Get page & Nitro action associated with the Page 
		 */		
		if(isMeetingPointSite
				&& JournalArticle.class.getName().equalsIgnoreCase(className))
		{
			long plId = serviceContext.getPlid();
			Layout layout = LayoutLocalServiceUtil.getLayout(plId);

			if(layout != null)
			{
				_log.info("MeetingPointMessageboardLocalServiceImpl.addDiscussionMessage(): layout is: " + layout.getFriendlyURL());

				String pageSectoLevelValue = CommonUtil.getPageType(serviceContext.getCompanyId(), layout);
				
				String actionTagName = CommonUtil.getCommentsAction(classPK, pageSectoLevelValue);
				
				if(Validator.isNotNull(actionTagName))
				{
					User user = null;						
					
					try{
						user = UserLocalServiceUtil.getUser(userId);
					}catch(Exception e){
						_log.error("User could NOT be found with userId:" + userId);
					}

					if(user != null)
					{	
						if(HookNitroServiceUtil.callBunchballActionService(user.getScreenName(), user.getScreenName(), actionTagName))
						{
							_log.info("Successfully logged Nitro Action for COMMENT ...");
						}
						else
						{
							_log.info("Error while logging Nitro Action for COMMENT !!!");
						}
					}
				}
			}
		}
		
		return message;
		
			}	
	
	

	/**
	 * Gamified "START THREAD"
	 * 
	 * @param userId
	 * @param userName
	 * @param groupId
	 * @param categoryId
	 * @param subject
	 * @param body
	 * @param format
	 * @param files
	 * @param anonymous
	 * @param priority
	 * @param allowPingbacks
	 * @param serviceContext
	 * 
	 */
	@Override
	public MBMessage addMessage(long userId, String userName, long groupId, long categoryId,
			String subject, String body, String format, List<ObjectValuePair<String, InputStream>> files,
			boolean anonymous, double priority, boolean allowPingbacks, ServiceContext serviceContext) throws PortalException, SystemException {

		_log.info("MeetingPointMessageboardLocalServiceImpl.addMessage(), type :: thread...");
		
		MBMessage mbMessage = super.addMessage(userId, userName, groupId, categoryId, subject, body, format, files, anonymous, priority, allowPingbacks, serviceContext);

		/**
		 * Check if the site is one of the Meeting Point Sites
		 */
		boolean isMeetingPointSite = MSSCommonsUtil.isMeetingPointSite(groupId);
		
		_log.info("MeetingPointMessageboardLocalServiceImpl.addMessage(), is gamified site : " + isMeetingPointSite);
		
		if(isMeetingPointSite)
		{
			long threadId = mbMessage.getThreadId();
			
			/*if(serviceContext.getAttribute("MP_THREADID") != null)
			{	
				_log.info("Retrieved threadId from service context : " + threadId);*/
			
			_log.info("MeetingPointMessageboardLocalServiceImpl.addMessage(), threadId : " + threadId);
			
			if(threadId <= 0)
			{	
				/**
				 * Gamify "START THREAD"
				 */

				if(mbMessage != null)
				{	
					String actionName = PropsUtil.get("social.wall.start.thread.action.name.prefix");//WallNewThread_Auto
					
					if(files != null && !files.isEmpty())
					{
						actionName += (StringPool.COMMA + PropsUtil.get("social.wall.upload.file.action.name.prefix"));//WallUpload_Auto
					}
					
					_log.info("MeetingPointMessageboardLocalServiceImpl.addMessage(), gamify 'START THREAD' with actionName " + actionName);
					
					logAction(serviceContext.getCompanyId(), groupId, serviceContext, actionName);
				}
			}
			else
			{
				/**
				 * Gamify "POST REPLY"
				 */
				if(mbMessage != null)
				{
					String actionNamePrefix = PropsUtil.get("social.wall.post.comment.action.name.prefix");
					
					_log.info("MeetingPointMessageboardLocalServiceImpl.addMessage(), gamify 'POST REPLY' with actionName " + actionNamePrefix);
					
					logAction(serviceContext.getCompanyId(),groupId, serviceContext, actionNamePrefix); //WallPost_Auto
				}
			}
			/*}
			else
			{
				_log.info("Could NOT retrieve threadId from service context");
			}*/
		}		
		
		return mbMessage;
	}


	/**
	 * Gamified "POST REPLY"
	 * 
	 *  
	 * @param userId
	 * @param userName
	 * @param groupId
	 * @param categoryId
	 * @param threadId
	 * @param parentMessageId
	 * @param subject
	 * @param body
	 * @param format
	 * @param inputStreamOVPs
	 * @param anonymous
	 * @param priority
	 * @param allowPingbacks
	 * @param serviceContext
	 * 
	 * @return {@link MBMessage}
	 */
	@Override
	public com.liferay.portlet.messageboards.model.MBMessage addMessage(
			long userId, java.lang.String userName, long groupId, long categoryId,
			long threadId, long parentMessageId, java.lang.String subject,
			java.lang.String body, java.lang.String format,
			java.util.List<com.liferay.portal.kernel.util.ObjectValuePair<java.lang.String, java.io.InputStream>> inputStreamOVPs,
			boolean anonymous, double priority, boolean allowPingbacks,
			com.liferay.portal.service.ServiceContext serviceContext) throws PortalException, SystemException
	{
		_log.info("MeetingPointMessageboardLocalServiceImpl.addMessage(), type: post Reply ?? ");
		
		MBMessage mbMessage =  super.addMessage(userId, userName, groupId, categoryId, threadId, parentMessageId, 
				subject, body, format, inputStreamOVPs,
				anonymous, priority, allowPingbacks, serviceContext);
		
		/**
		 * Gamify "POST REPLY"
		 */
		if(mbMessage != null)
		{
			String actionNamePrefix = PropsUtil.get("social.wall.post.comment.action.name.prefix");
			
			_log.info("MeetingPointMessageboardLocalServiceImpl.addMessage(), gamify 'POST REPLY' with actionName " + actionNamePrefix);
			
			logAction(serviceContext.getCompanyId(),groupId, serviceContext, actionNamePrefix); //WallPost_Auto
		}
		
		return mbMessage;
	}
	
			
	/**
	 * Gamified "POST REPLY" 
	 * 
	 * @param groupId
	 * @param categoryId
	 * @param threadId
	 * @param parentMessageId
	 * @param subject
	 * @param body
	 * @param files
	 * @param anonymous
	 * @param priority
	 * @param allowPingbacks
	 * @param serviceContext
	 * @throws PortalException
	 * @throws SystemException
	 * @return MBMessage
	 */
	/*public MBMessage addMessage(
			long groupId, long categoryId, long threadId, long parentMessageId, String subject, String body,
			java.util.List<com.liferay.portal.kernel.util.ObjectValuePair<java.lang.String, InputStream>> files,
			boolean anonymous, double priority, boolean allowPingbacks, ServiceContext serviceContext)
					throws PortalException, SystemException 
					{

		MBMessage mbMessage = super.addMessage(groupId, categoryId, threadId, parentMessageId, 
				subject, body, MBMessageConstants.DEFAULT_FORMAT, files, anonymous, priority, 
				allowPingbacks, serviceContext);
		
		if(mbMessage != null)
		{
			logAction(serviceContext.getCompanyId(),groupId, serviceContext, PropsUtil.get("social.wall.post.comment.action.name.prefix")); //WallPost_Auto
		}

		return mbMessage;
	}*/
	
	
	/**
	 * Gamified "UPDATE THREAD/MESSAGE/POST" 
	 * 
	 * @param messageId
	 * @param subject
	 * @param body
	 * @param files
	 * @param existingFiles
	 * @param priority
	 * @param allowPingbacks
	 * @param serviceContext
	 * @throws PortalException
	 * @throws SystemException
	 * @return MBMessage
	 */
	/*public MBMessage updateMessage(
			long messageId, String subject, String body,
			java.util.List<com.liferay.portal.kernel.util.ObjectValuePair<java.lang.String, InputStream>> files,
			List<String> existingFiles, double priority, boolean allowPingbacks, ServiceContext serviceContext)
					throws PortalException, SystemException 
					{	

		MBMessage mbMessage = super.updateMessage(messageId, subject, body, files, existingFiles, 
				priority, allowPingbacks, serviceContext); 


		
		if(mbMessage != null)
		{
			logAction(serviceContext.getScopeGroupId(), serviceContext, "UPDATE_MESSAGE");
		}

		return mbMessage;
		}*/



	/**
	 * Generic method to logAction
	 * 
	 * @param groupId
	 * @param serviceContext
	 * @param actionNameSuffix
	 */
	public void logAction(long companyId, long groupId, ServiceContext serviceContext, String actionNameSuffix)
	{
		_log.info("Start logAction for Messageboard:" + actionNameSuffix);

		/**
		 * Check for "Meeting Point" site
		 */

		boolean isMeetingPointSite = MSSCommonsUtil.isMeetingPointSite(groupId);


		/**
		 * Get page & Nitro action associated with the Page 
		 */

		if(isMeetingPointSite)
		{
			/**
			 * Get the Page
			 */

			long plId = serviceContext.getPlid();
			Layout layout = null;

			try {
				layout = LayoutLocalServiceUtil.getLayout(plId);
			} catch (Exception e1) {
				_log.error("Could NOT find laypout based on plId: " + plId);
			}			

			if(layout != null)
			{
				_log.info("MeetingPointMessageboardServiceImpl.updatePage(): layout is: " + layout.getFriendlyURL());

				String pageSectoLevelValue = CommonUtil.getPageType(companyId, layout);
				
				User user = null;
				long userId = 0;

				try{
					userId = serviceContext.getUserId();
					user = UserLocalServiceUtil.getUser(userId);
				}catch(Exception e){
					_log.error("User could NOT be found with userId:" + userId);
				}

				/* Create Action Name by  "actionNameSuffix" + "pageSectoLevelValue" */
				
				String actionTagName = StringPool.BLANK;
				
				if(actionNameSuffix.indexOf(StringPool.COMMA) > 0 && actionNameSuffix.split(StringPool.COMMA).length == 2)
				{
					String[] arrActionName = actionNameSuffix.split(StringPool.COMMA);
					
					actionTagName = arrActionName[0] + pageSectoLevelValue + StringPool.COMMA
							+ arrActionName[1] + pageSectoLevelValue;
				}
				else
				{
					actionTagName += (actionNameSuffix + pageSectoLevelValue);
				}
				
				_log.info("actionTagName for MessageBoard Action after processing: " + actionTagName);
				
				
				if(user != null)
				{	
					if(HookNitroServiceUtil.callBunchballActionService(user.getScreenName(), user.getScreenName(), actionTagName))
					{
						_log.info("Successfully logged Nitro Action for MessageBoard...");
					}
					else
					{
						_log.info("Error while logging Nitro Action for MessageBoard...");
					}
				}
			}
		}		
	}
	
	
	/*This method is override for Merlin WALL Email body customization --- Actual change is in notifySubscriber() method. */
	
	@Override
	public MBMessage updateStatus(long userId, long messageId, int status,
			ServiceContext serviceContext) throws PortalException,
			SystemException 
	{
		if(serviceContext.getThemeDisplay()==null || serviceContext.getThemeDisplay().getLayout()==null){
			return super.updateStatus(userId, messageId, status, serviceContext);
		}
		
		MBMessage message = getMessage(messageId);
		long groupId = serviceContext.getThemeDisplay().getLayout().getGroupId();
		List<Long> groupIds = new ArrayList<Long>(WallNotificationServlet.getGroupIds().keySet());
		
		String fromWall = null;
		if(serviceContext.getAttribute("fromWall")!=null)
		{
			fromWall = (String)serviceContext.getAttribute("fromWall");
		}
		
		
		_log.info("Message is posted from Merlin Wall related community ??? "+ fromWall);
		
		/****
		 * For other communities and from other portlet except Social wall portlet it will call LR OOB
		 ***/
		if(fromWall != null && fromWall.equals("true"))
		{
			_log.info("Executing custom code ........ ");
			return  CustomUpdateStatusUtil.customUpdateStatue(userId, messageId, status, mbMessageLocalService, message, serviceContext);
		}
		else if(groupIds.contains(groupId)){
			_log.info("Impleming me2 wall hook functionality...");
			return CustomUpdateStatusUtil.me2WallUpdateStatus(userId, messageId, status,message, serviceContext);
		}
		else
		{
			return super.updateStatus(userId, messageId, status, serviceContext);
		}
		
		
		
	}
	
	
	private static final Log _log = LogFactoryUtil.getLog(MeetingPointMessageboardLocalServiceImpl.class);

}
