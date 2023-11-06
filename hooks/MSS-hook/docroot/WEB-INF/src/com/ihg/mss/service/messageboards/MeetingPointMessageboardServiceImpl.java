package com.ihg.mss.service.messageboards;

import java.io.InputStream;
import java.util.List;

import com.ihg.mss.portal.util.CommonUtil;
import com.ihg.mss.util.HookNitroServiceUtil;
import com.ihg.mss.portal.util.MSSCommonsUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBMessageConstants;
import com.liferay.portlet.messageboards.service.MBMessageService;
import com.liferay.portlet.messageboards.service.MBMessageServiceWrapper;


/**
 * Custom Service Wrapper Implementation for Message Boards to gamify it.
 * 
 * Gamified component:  1. 'START NEW THREAD' 		- Action Type -3 "Sector"
 * 						2. 'POST REPLY/COMMENT'		- Action Type -3 "Sector"
 * 						3. 'UPDATE COMMENT/THREAD'  - Action Type -3 "Sector" 
 *  
 * 
 * @author Jay Patel
 * @deprecated - shifted services to 'MeetingPointMessageboardLocalServiceImpl'
 *
 */

public class MeetingPointMessageboardServiceImpl extends MBMessageServiceWrapper
{

	public MeetingPointMessageboardServiceImpl(MBMessageService mbMessageService) 
	{
		super(mbMessageService);
	}


	/**
	 * Gamified "START THREAD" 
	 * 
	 * 
	 * @param groupId
	 * @param categoryId
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
	public MBMessage addMessage(
			long groupId, long categoryId, String subject, String body,
			java.util.List<com.liferay.portal.kernel.util.ObjectValuePair<java.lang.String, InputStream>> files,
			boolean anonymous, double priority, boolean allowPingbacks, ServiceContext serviceContext) throws PortalException, SystemException
			{

		_log.info("MeetingPointMessageboardServiceImpl.addMessage(), Gamify START THREAD");


		MBMessage mbMessage = super.addMessage(groupId, categoryId, subject, body, MBMessageConstants.DEFAULT_FORMAT, files, anonymous, priority, allowPingbacks, serviceContext);


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
			
			logAction(serviceContext.getCompanyId(), groupId, serviceContext, actionName);
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
	public MBMessage addMessage(
			long groupId, long categoryId, long threadId, long parentMessageId, String subject, String body,
			java.util.List<com.liferay.portal.kernel.util.ObjectValuePair<java.lang.String, InputStream>> files,
			boolean anonymous, double priority, boolean allowPingbacks, ServiceContext serviceContext)
					throws PortalException, SystemException 
					{

		MBMessage mbMessage = super.addMessage(groupId, categoryId, threadId, parentMessageId, 
				subject, body, MBMessageConstants.DEFAULT_FORMAT, files, anonymous, priority, 
				allowPingbacks, serviceContext); 


		/**
		 * Gamify "POST REPLY"
		 */
		if(mbMessage != null)
		{
			logAction(serviceContext.getCompanyId(),groupId, serviceContext, PropsUtil.get("social.wall.post.comment.action.name.prefix")); //WallPost_Auto
		}

		return mbMessage;
					}


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
	public MBMessage updateMessage(
			long messageId, String subject, String body,
			java.util.List<com.liferay.portal.kernel.util.ObjectValuePair<java.lang.String, InputStream>> files,
			List<String> existingFiles, double priority, boolean allowPingbacks, ServiceContext serviceContext)
					throws PortalException, SystemException 
					{	

		MBMessage mbMessage = super.updateMessage(messageId, subject, body, files, existingFiles, 
				priority, allowPingbacks, serviceContext); 


		/**
		 * Gamify "UPDATE THREAD/MESSAGE/POST"
		 */
		/*if(mbMessage != null)
		{
			logAction(serviceContext.getScopeGroupId(), serviceContext, "UPDATE_MESSAGE");
		}*/

		return mbMessage;
					}



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

	private static final Log _log = LogFactoryUtil.getLog(MeetingPointMessageboardServiceImpl.class);

}
