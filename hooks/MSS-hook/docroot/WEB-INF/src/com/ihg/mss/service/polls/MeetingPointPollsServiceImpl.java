package com.ihg.mss.service.polls;

import com.ihg.mss.util.HookNitroServiceUtil;
import com.ihg.mss.portal.util.MSSCommonsUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.polls.model.PollsVote;
import com.liferay.portlet.polls.service.PollsVoteLocalService;
import com.liferay.portlet.polls.service.PollsVoteLocalServiceWrapper;


/**
 * Custom Service Wrapper Implementation for 'POLLS VOTE' to gamify Liferay Polls Display
 * Gamified component: 1. 'Polls Vote'
 * 
 * @author Jay Patel
 *
 */
public class MeetingPointPollsServiceImpl extends PollsVoteLocalServiceWrapper 
{

	public MeetingPointPollsServiceImpl(PollsVoteLocalService pollsVoteLocalService) 
	{
		super(pollsVoteLocalService);
	}

	
	/**
	 * Gamified "Add Polls Vote"
	 * 
	 * @param
	 * @param
	 * @param
	 * @param
	 * @throws PortalException
	 * @throws SystemException
	 */
	public PollsVote addVote(long userId, long questionId, long choiceId,
			ServiceContext serviceContext) throws PortalException, SystemException
	{
		_log.info("MeetingPointPollsServiceImpl.addVote()");
		
		PollsVote pollsVote = super.addVote(userId, questionId, choiceId, serviceContext);
		
		
		/**
		 * Check if the site is one of the Meeting Point Sites
		 */
		long groupId = serviceContext.getScopeGroupId();
		boolean isMeetingPointSite = MSSCommonsUtil.isMeetingPointSite(groupId);


		/**
		 * Get page & Nitro action associated with the Page 
		 */		
		if(isMeetingPointSite)
		{
			long plId = serviceContext.getPlid();
			Layout layout = LayoutLocalServiceUtil.getLayout(plId);

			if(layout != null)
			{
				_log.info("MeetingPointPollsServiceImpl.addVote(): layout is: " + layout.getFriendlyURL());

				Object pageType = layout.getExpandoBridge().getAttribute("Mssleveltype");

				if(pageType != null)
				{
					String[] pageTypeArr = (String[])pageType;

					if(pageTypeArr != null & pageTypeArr.length > 0)
					{
						_log.info("pageType: " + pageTypeArr[0]);

						String actionTagName = pageTypeArr[0] + PropsUtil.get("polls.vote.action.name.suffix");

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
								_log.info("Successfully logged Nitro Action for POLLS VOTE ...");
							}
							else
							{
								_log.info("Error while logging Nitro Action for POLLS VOTE !!!");
							}
						}
					}
				}
			}
		}
		
		
		return pollsVote;
	}
	
	
	private static final Log _log = LogFactoryUtil.getLog(MeetingPointPollsServiceImpl.class);
}
