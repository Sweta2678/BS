
package com.ihg.grs.portlet;

import com.ihg.grs.bean.ArticleInfoBean;
import com.ihg.grs.constant.ApplicationConstants;
import com.ihg.grs.util.ArticleUtil;
import com.ihg.me2.core.service.CoreArticleLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.lang.StringUtils;

/**
 * Portlet implementation class HomepageCarouselPortlet.
 */
public class HomepageCarouselPortlet extends MVCPortlet
{

	private static final Log LOGGER = LogFactoryUtil.getLog(HomepageCarouselPortlet.class);

	/**
	 * Default view  for Homepage Carousel Portlet.
	 * 
	 * @param renderRequest 
	 *            Render request is passed when loading page.
	 * @param renderResponse
	 *            After retrieving data Render response is passing response.
	 */
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
	{
		LOGGER.debug("Inside HomepageCarouselPortlet :: doView()");

		try
		{

			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			PortletPreferences prefs = renderRequest.getPreferences();

			List<ArticleInfoBean> articleInfoList = new ArrayList<ArticleInfoBean>();
			String[] structureKeyArray = null;
			int noOfRecords = 0;
			int cacheTime = 0;
			
			if (Validator.isNotNull(prefs))
			{
				int arrayCountNo= StringUtils.countMatches(prefs.getValue(ApplicationConstants.STRUCTURE_KEY, StringPool.BLANK), ",");
				structureKeyArray = new String[arrayCountNo+1];
				structureKeyArray = prefs.getValue(ApplicationConstants.STRUCTURE_KEY, StringPool.BLANK).split(",");
				
				noOfRecords = Integer.parseInt(prefs.getValue(ApplicationConstants.NO_OF_ARTICLES, "0"));
				cacheTime = Integer.parseInt(prefs.getValue(ApplicationConstants.CACHE_TIME, "0"));
			}

			LOGGER.debug("GRS :: Homepage Carousel Preferences are - structureKey : " + structureKeyArray[0] + " noOfRecords : " + noOfRecords + " cacheTime : " + cacheTime);

			if (structureKeyArray.length > 0 && noOfRecords > 0)
			{
				
				SearchContext searchContext = new SearchContext();
				searchContext.setSorts(new Sort(ApplicationConstants.ARTICLE_LISTING_DEFAULT_SORT_ORDER, true));

				List<JournalArticle> articles = CoreArticleLocalServiceUtil.getStructureArticlesByStructureKeys(themeDisplay.getScopeGroupId(), structureKeyArray, searchContext, 0, noOfRecords);
				
				articleInfoList = ArticleUtil.getArticleInfoFromArticleList(themeDisplay, articles);

			}

			renderRequest.setAttribute(ApplicationConstants.ARTICLE_INFO_LIST, articleInfoList);
			super.doView(renderRequest, renderResponse);

		}
		catch (Exception e)
		{
			LOGGER.error("Exception thrown from HomepageCarouselPortlet :: doView()", e);
		}

	}

	/**
	 * Setting preferences for Homepage Carousel Portlet.
	 * 
	 * @param actionRequest
	 *            Action request is passed when Preferences saved.
	 * @param actionResponse
	 *            After saving action response is passing response.
	 */
	public void setCarouselPreferences(ActionRequest actionRequest, ActionResponse actionResponse)
	{

		try
		{
			PortletPreferences portletPreferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);

			portletPreferences.setValue(ApplicationConstants.STRUCTURE_KEY, ParamUtil.getString(actionRequest, ApplicationConstants.STRUCTURE_KEY, StringPool.BLANK));

			portletPreferences.setValue(ApplicationConstants.NO_OF_ARTICLES, ParamUtil.getString(actionRequest, ApplicationConstants.NO_OF_ARTICLES, StringPool.BLANK));

			portletPreferences.setValue(ApplicationConstants.CACHE_TIME, ParamUtil.getString(actionRequest, ApplicationConstants.CACHE_TIME, StringPool.BLANK));

			portletPreferences.store();

		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage(), e);
		}
	}

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException
	{

		PortletPreferences prefs = renderRequest.getPreferences();
		if (Validator.isNotNull(prefs))
		{
			String structureKey = prefs.getValue(ApplicationConstants.STRUCTURE_KEY, StringPool.BLANK);
			renderRequest.setAttribute(ApplicationConstants.STRUCTURE_KEY, structureKey);

			String articlesPerPage = prefs.getValue(ApplicationConstants.NO_OF_ARTICLES, StringPool.BLANK);
			renderRequest.setAttribute(ApplicationConstants.NO_OF_ARTICLES, articlesPerPage);

			String cacheTime = prefs.getValue(ApplicationConstants.CACHE_TIME, StringPool.BLANK);
			renderRequest.setAttribute(ApplicationConstants.CACHE_TIME, cacheTime);
		}
		super.doEdit(renderRequest, renderResponse);
	}

}
