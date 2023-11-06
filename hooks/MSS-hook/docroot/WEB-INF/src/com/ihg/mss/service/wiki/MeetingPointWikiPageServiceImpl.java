package com.ihg.mss.service.wiki;

import com.ihg.mss.portal.util.CommonUtil;
import com.ihg.mss.util.HookNitroServiceUtil;
import com.ihg.mss.portal.util.MSSCommonsUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.wiki.model.WikiPage;
import com.liferay.portlet.wiki.service.WikiPageLocalService;
import com.liferay.portlet.wiki.service.WikiPageLocalServiceWrapper;

/**
 * Custom Service Wrapper Implementation for 'WIKI' to gamify Liferay Wiki
 * Gamified component: 1. 'Wiki Page Update' 
 *  
 * 
 * @author Jay Patel
 *
 */

public class MeetingPointWikiPageServiceImpl extends WikiPageLocalServiceWrapper
{

	public MeetingPointWikiPageServiceImpl(WikiPageLocalService wikiPageLocalService) 
	{
		super(wikiPageLocalService);
	}

	
	/**
	 * Gamified 'Wiki Page Update' action
	 * 
	 * @param userId
	 * @param nodeId
	 * @param title
	 * @param version
	 * @param content
	 * @param summary
	 * @param minorEdit
	 * @param format
	 * @param parentTitle
	 * @param redirectTitle
	 * @param serviceContext
	 * @return WikiPage
	 * @throws PortalException
	 * @throws SystemException
	 * @return WikiPage
	 * 
	 */
	public com.liferay.portlet.wiki.model.WikiPage updatePage(
			long userId, long nodeId, String title, double version,
			String content, String summary, boolean minorEdit, String format,
			String parentTitle, String redirectTitle,
			ServiceContext serviceContext)
		throws PortalException, SystemException 
	{
		_log.info("MeetingPointWikiPageServiceImpl.updatePage() called...");
		
		
		/**
		 * Call actual Wiki service
		 */
		WikiPage wikiPage = super.updatePage(userId, nodeId, title, version, 
				content, summary, minorEdit, format, 
				parentTitle, redirectTitle, serviceContext);
		
		
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
				_log.info("MeetingPointWikiPageServiceImpl.updatePage(): layout is: " + layout.getFriendlyURL());

				String pageSectoLevelValue = CommonUtil.getPageType(serviceContext.getCompanyId(), layout);				
				
				if(Validator.isNotNull(pageSectoLevelValue) && 
						!pageSectoLevelValue.equalsIgnoreCase(PropsUtil.get("page.type.custom.attribute.null.value")))
				{
					_log.info("pageType for WIKI gamification : " + pageSectoLevelValue);
					
					String actionTagName = PropsUtil.get("wiki.glossary.action.name.prefix") + 
							pageSectoLevelValue + PropsUtil.get("wiki.glossary.action.name.suffix");						
					
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
							_log.info("Successfully logged WIKI UPDATE action on Nitro...");
						}
						else
						{
							_log.info("Error while logging WIKI UPDATE action on Nitro...");
						}
					}
				}
			}
		}
		
		return wikiPage;
	}
	
	
	
	private static final Log _log = LogFactoryUtil.getLog(MeetingPointWikiPageServiceImpl.class);
	
}
