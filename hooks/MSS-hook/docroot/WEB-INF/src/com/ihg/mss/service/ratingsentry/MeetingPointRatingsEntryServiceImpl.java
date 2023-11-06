package com.ihg.mss.service.ratingsentry;

import java.util.Arrays;
import java.util.List;

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
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.ratings.model.RatingsEntry;
import com.liferay.portlet.ratings.service.RatingsEntryLocalService;
import com.liferay.portlet.ratings.service.RatingsEntryLocalServiceWrapper;


/**
 * Custom Service Wrapper Implementation for 'RatingsEntry' to gamify Liferay Ratings service
 * Gamified component: 1. '5 STAR Rating' 
 *  
 * 
 * @author Jay Patel
 *
 */

public class MeetingPointRatingsEntryServiceImpl extends RatingsEntryLocalServiceWrapper
{

	public MeetingPointRatingsEntryServiceImpl(RatingsEntryLocalService ratingsEntryLocalService) 
	{
		super(ratingsEntryLocalService);
	}
	


	/**
	 * Gamified "ADD/UPDATE Ratings" on
	 * 1. Web-Content 
	 * 
	 * @param userId
	 * @param className
	 * @param classPK
	 * @param double
	 * @param serviceContext
	 */
	public RatingsEntry updateEntry(
			long userId, String className, long classPK, double score,
			ServiceContext serviceContext) throws PortalException, SystemException
	{
		_log.info("MeetingPointRatingsEntryServiceImpl.updateEntry()");
		
		
		RatingsEntry ratingsEntry = super.updateEntry(userId, className, classPK, score, serviceContext);
		
		
		if(ratingsEntry != null)
		{
			
			/**
			 * Check if the site is one of the Meeting Point Sites
			 */
			
			long groupId = serviceContext.getScopeGroupId();
			boolean isMeetingPointSite = MSSCommonsUtil.isMeetingPointSite(groupId);
			
			/**
			 * Get page & Nitro action associated with the Page 
			 */
			
			if(isMeetingPointSite && _gamifiedEntitiesList.contains(className))
			{
				long plId = serviceContext.getPlid();
				Layout layout = LayoutLocalServiceUtil.getLayout(plId);
				
				if(layout != null)
				{
					_log.info("MeetingPointRatingsEntryServiceImpl.updateEntry(): layout is: " + layout.getFriendlyURL());

					Object pageType = layout.getExpandoBridge().getAttribute("Mssleveltype");
					
					if(pageType != null)
					{
						String[] pageTypeArr = (String[])pageType;
						
						if(pageTypeArr != null & pageTypeArr.length > 0)
						{
							_log.info("pageType: " + pageTypeArr[0]);
							
							String actionTagName = pageTypeArr[0] + PropsUtil.get("ratings.webcontent.action.name.suffix");
							
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
									_log.info("Successfully logged Nitro Action for RATINGS ...");
								}
								else
								{
									_log.info("Error while logging Nitro Action for RATINGS !!!");
								}
							}
						}
					}
				}
			}
		}
		
		return ratingsEntry;
	}
	
	
	private static final Log _log = LogFactoryUtil.getLog(MeetingPointRatingsEntryServiceImpl.class);
	
	private static final String[] _gamifiedEntitiesArray = new String[]{JournalArticle.class.getName()};
	
	private static final List<String> _gamifiedEntitiesList = Arrays.asList(_gamifiedEntitiesArray);
}
