
package com.ihg.grs.portlet;

import com.ihg.grs.bean.ArticleInfoBean;
import com.ihg.grs.constant.ApplicationConstants;
import com.ihg.grs.util.ArticleUtil;
import com.ihg.me2.core.service.CoreArticleLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Portlet implementation class LatestArticlePortlet.
 */
public class LatestArticlePortlet extends MVCPortlet
{

	private static final String VIEW_PAGE = "view-template";
	private static final Log LOGGER = LogFactoryUtil.getLog(LatestArticlePortlet.class);

	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
	{

		try
		{
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			List<ArticleInfoBean> articleInfoList = null;
			PortletPreferences prefs = renderRequest.getPreferences();
			HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
			String structureKey = StringPool.BLANK;
			String[] structureKeyArray = new String[1];
			int noOfArticles = 0;
			List<JournalArticle> articleList = null;
			String viewTemplate = null;

			String articleId = httpReq.getParameter(ApplicationConstants.ARTICLE_DETAIL_ARTICLE_ID);

			// SearchContext searchContext = new SearchContext();
			SearchContext searchContext = SearchContextFactory.getInstance(httpReq);
			searchContext.setSorts(new Sort(ApplicationConstants.ARTICLE_LISTING_DEFAULT_SORT_ORDER, true));

			if (Validator.isNotNull(prefs))
			{
				structureKey = prefs.getValue(ApplicationConstants.STRUCTURE_KEY, StringPool.BLANK);
				structureKeyArray[0] = structureKey;
				noOfArticles = Integer.parseInt(prefs.getValue(ApplicationConstants.NO_OF_LATEST_ARTICLE, "0"));
				viewTemplate = prefs.getValue(VIEW_PAGE, StringPool.BLANK);
			}

			if (Validator.isNotNull(structureKey) && !Validator.isBlank(structureKey) && noOfArticles > 0)
			{
				int start = 0;
				int end = 0;

				if (articleId != null)
				{
					end = noOfArticles + 1;
				}
				else
				{
					end = noOfArticles;
				}

				if (LOGGER.isDebugEnabled())
				{
					LOGGER.debug("Structure Key=" + structureKey);
				}
				articleList = CoreArticleLocalServiceUtil.getStructureArticlesByStructureKey(themeDisplay.getScopeGroupId(), structureKeyArray, searchContext, start, end);

				if (Validator.isNotNull(articleId))
				{
					articleList = ArticleUtil.excludeCurrentArticleFromList(articleList, articleId, noOfArticles);
				}
				
				articleInfoList = ArticleUtil.getArticleInfoFromArticleList(themeDisplay, articleList);
				renderRequest.setAttribute(ApplicationConstants.ARTICLE_INFO_LIST, articleInfoList);
				renderRequest.setAttribute(ApplicationConstants.STRUCTURE_KEY, structureKey);
			}

			if (Validator.isNotNull(viewTemplate))
			{
				String jspPath = "/html/latestarticle/" + viewTemplate + ".jsp";
				LOGGER.debug("jspPath=" + jspPath);
				include(jspPath, renderRequest, renderResponse);
			}
			else
			{
				super.doView(renderRequest, renderResponse);
			}

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
				String structureKey = prefs.getValue(ApplicationConstants.STRUCTURE_KEY, StringPool.BLANK);
				renderRequest.setAttribute(ApplicationConstants.STRUCTURE_KEY, structureKey);
				String noOfArticles = prefs.getValue(ApplicationConstants.NO_OF_LATEST_ARTICLE, StringPool.BLANK);
				renderRequest.setAttribute(ApplicationConstants.NO_OF_LATEST_ARTICLE, noOfArticles);

				String displayStyle = prefs.getValue(VIEW_PAGE, StringPool.BLANK);
				renderRequest.setAttribute("displayStyle", displayStyle);
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
	public void setArticleListingPreferences(ActionRequest actionRequest, ActionResponse actionResponse)
	{

		try
		{
			PortletPreferences portletPreferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);
			portletPreferences.setValue(ApplicationConstants.STRUCTURE_KEY, ParamUtil.getString(actionRequest, ApplicationConstants.PREFERECES_SET, StringPool.BLANK));
			portletPreferences.setValue(ApplicationConstants.NO_OF_LATEST_ARTICLE, ParamUtil.getString(actionRequest, ApplicationConstants.PREF_NO_OF_LATEST_ARTICLE, StringPool.BLANK));

			String displayStyle = ParamUtil.getString(actionRequest, "displayStyle");
			portletPreferences.setValue(VIEW_PAGE, displayStyle);

			portletPreferences.store();

		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage(), e);
		}
	}

}
