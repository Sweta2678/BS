package com.ihg.grs.portlet;

import com.ihg.grs.bean.ArticleInfoBean;
import com.ihg.grs.bean.SearchVO;
import com.ihg.grs.constant.ApplicationConstants;
import com.ihg.grs.util.HotelImplementationUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class HotelImplementationHomePortlet.
 */
public class HotelImplementationHomePortlet extends MVCPortlet {
	private static final Log LOGGER = LogFactoryUtil.getLog(HotelImplementationHomePortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
	{
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences prefs = renderRequest.getPreferences();
		Map<List<SearchVO>,List<SearchVO>> contentDetailsMap = new HashMap<List<SearchVO>,List<SearchVO>>();
		
		int recordsPerCategory = 0;
		String articleId = StringPool.BLANK;
		ArticleInfoBean articleInfo = new ArticleInfoBean(); 
		try
		{
			if (Validator.isNotNull(prefs))
			{
				contentDetailsMap = HotelImplementationUtil.getArticlesDlFilesAndBookmarksByStrKeyAndCategoryIds(renderRequest);
				recordsPerCategory = Integer.parseInt(prefs.getValue(ApplicationConstants.RECORDS_PER_PAGE, "0"));
				articleId = prefs.getValue(ApplicationConstants.GRS_IMP_HOME_PAGE_DETAILS_WEB_CONTENT_ID, StringPool.BLANK);
				
				articleInfo = HotelImplementationUtil.getArticleInfo(themeDisplay, articleId);
			}
			
			renderRequest.setAttribute("contentDetailsMap", contentDetailsMap);			
			renderRequest.setAttribute("recordsPerCategory", recordsPerCategory);
			renderRequest.setAttribute("articleInfo", articleInfo);
			
			super.doView(renderRequest, renderResponse);
		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage(), e);
		}
	}
	
	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse)
	{

		try
		{
			PortletPreferences prefs = renderRequest.getPreferences();
			if (Validator.isNotNull(prefs))
			{
				String groupId = prefs.getValue(ApplicationConstants.GRS_COMM_GROUPID, "0");
				renderRequest.setAttribute(ApplicationConstants.GRS_COMM_GROUPID, groupId);
				String grsCommCategoryIdUnderstandTheGRS = prefs.getValue(ApplicationConstants.GRS_COMM_CATEGORYID_UNDERSTAND_GRS,"0");
				renderRequest.setAttribute(ApplicationConstants.GRS_COMM_CATEGORYID_UNDERSTAND_GRS, grsCommCategoryIdUnderstandTheGRS);
				String grsCommCategoryIdGetRady = prefs.getValue(ApplicationConstants.GRS_COMM_CATEGORYID_GET_READY, "0");
				renderRequest.setAttribute(ApplicationConstants.GRS_COMM_CATEGORYID_GET_READY, grsCommCategoryIdGetRady);
				String grsHotelImpCategoryIdUnderstandTheGRS = prefs.getValue(ApplicationConstants.GRS_HOTELIMP_CATEGORYID_UNDERSTAND_GRS, "0");
				renderRequest.setAttribute(ApplicationConstants.GRS_HOTELIMP_CATEGORYID_UNDERSTAND_GRS, grsHotelImpCategoryIdUnderstandTheGRS);
				String grsHotelImpCategoryIdGetRady = prefs.getValue(ApplicationConstants.GRS_HOTELIMP_CATEGORYID_GET_READY, "0");
				renderRequest.setAttribute(ApplicationConstants.GRS_HOTELIMP_CATEGORYID_GET_READY, grsHotelImpCategoryIdGetRady);				
				String recordsPerPage = prefs.getValue(ApplicationConstants.RECORDS_PER_PAGE, "0");
				renderRequest.setAttribute(ApplicationConstants.RECORDS_PER_PAGE, recordsPerPage);
				String pageDetailsWebContentId = prefs.getValue(ApplicationConstants.GRS_IMP_HOME_PAGE_DETAILS_WEB_CONTENT_ID, "0");
				renderRequest.setAttribute(ApplicationConstants.GRS_IMP_HOME_PAGE_DETAILS_WEB_CONTENT_ID, pageDetailsWebContentId);

			}
			super.doEdit(renderRequest, renderResponse);
		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage(), e);
		}

	}

	/**
	 * Setting preferences for Article Listing Portlet.
	 * 
	 * @param actionRequest
	 *            Action request is passed when Preferences saved.
	 * @param actionResponse
	 *            After saving action response is passing response.
	 */
	public void setHomePagePreferences(ActionRequest actionRequest, ActionResponse actionResponse)
	{

		try
		{
			PortletPreferences portletPreferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);
			portletPreferences.setValue(ApplicationConstants.GRS_COMM_GROUPID, ParamUtil.getString(actionRequest, ApplicationConstants.PREF_GRS_COMM_GROUPID, "0"));
			portletPreferences.setValue(ApplicationConstants.GRS_COMM_CATEGORYID_UNDERSTAND_GRS, ParamUtil.getString(actionRequest, ApplicationConstants.PREF_GRS_COMM_CATEGORYID_UNDERSTAND_GRS, "0"));
			portletPreferences.setValue(ApplicationConstants.GRS_COMM_CATEGORYID_GET_READY, ParamUtil.getString(actionRequest, ApplicationConstants.PREF_GRS_COMM_CATEGORYID_GET_READY, "0"));
			portletPreferences.setValue(ApplicationConstants.GRS_HOTELIMP_CATEGORYID_UNDERSTAND_GRS, ParamUtil.getString(actionRequest, ApplicationConstants.PREF_HOTELIMP_COMM_CATEGORYID_UNDERSTAND_GRS, "0"));
			portletPreferences.setValue(ApplicationConstants.GRS_HOTELIMP_CATEGORYID_GET_READY, ParamUtil.getString(actionRequest, ApplicationConstants.PREF_HOTELIMP_COMM_CATEGORYID_GET_READY, "0"));			
			portletPreferences.setValue(ApplicationConstants.RECORDS_PER_PAGE, ParamUtil.getString(actionRequest, ApplicationConstants.PREFERECES_RECORDS_PER_PAGE, "0"));
			portletPreferences.setValue(ApplicationConstants.GRS_IMP_HOME_PAGE_DETAILS_WEB_CONTENT_ID, ParamUtil.getString(actionRequest, ApplicationConstants.PREFERECES_GRS_IMP_HOME_PAGE_DETAILS_WEB_CONTENT_ID, "0"));
			portletPreferences.store();

		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage(), e);
		}
	}
}
