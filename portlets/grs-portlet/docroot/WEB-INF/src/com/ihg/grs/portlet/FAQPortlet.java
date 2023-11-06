
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
 * Portlet implementation class FAQPortlet.
 */
public class FAQPortlet extends MVCPortlet
{

	private static final Log _log = LogFactoryUtil.getLog(FAQPortlet.class);

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
			String prefArticleId = StringPool.BLANK;
			String[] structureKeyArray = new String[1];
			List<JournalArticle> articleList = null;

			String articleId = httpReq.getParameter(ApplicationConstants.ARTICLE_DETAIL_ARTICLE_ID);

			SearchContext searchContext = SearchContextFactory.getInstance(httpReq);
			searchContext.setSorts(new Sort(ApplicationConstants.ARTICLE_LISTING_DEFAULT_SORT_ORDER, true));

			if (Validator.isNotNull(prefs))
			{
				structureKey = prefs.getValue(ApplicationConstants.STRUCTURE_KEY, StringPool.BLANK);
				prefArticleId = prefs.getValue(ApplicationConstants.PREF_ARTICLE_ID, StringPool.BLANK);
				structureKeyArray[0] = structureKey;
			}

			if (Validator.isNotNull(structureKey) && !Validator.isBlank(structureKey))
			{

				if (_log.isDebugEnabled())
				{
					_log.debug("Structure Key=" + structureKey);
				}

				articleList = CoreArticleLocalServiceUtil.getStructureArticlesByStructureKey(themeDisplay.getScopeGroupId(), structureKeyArray, searchContext, -1, -1);

				articleInfoList = ArticleUtil.getArticleInfoFromArticleList(themeDisplay, articleList);
				renderRequest.setAttribute(ApplicationConstants.ARTICLE_INFO_LIST, articleInfoList);
				renderRequest.setAttribute(ApplicationConstants.ARTICLE_ID, ArticleUtil.hasValidArticleID(articleList, articleId));
			}
			renderRequest.setAttribute(ApplicationConstants.PREF_ARTICLE_ID, prefArticleId);

			super.doView(renderRequest, renderResponse);

		}
		catch (Exception e)
		{
			_log.error(e.getMessage(), e);
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
				String prefArticleId = prefs.getValue(ApplicationConstants.PREF_ARTICLE_ID, StringPool.BLANK);
				renderRequest.setAttribute(ApplicationConstants.STRUCTURE_KEY, structureKey);
				renderRequest.setAttribute(ApplicationConstants.PREF_ARTICLE_ID, prefArticleId);
			}
			super.doEdit(renderRequest, renderResponse);
		}
		catch (Exception e)
		{
			_log.error(e.getMessage(), e);
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
	public void setFAQPreferences(ActionRequest actionRequest, ActionResponse actionResponse)
	{

		try
		{
			PortletPreferences portletPreferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);
			portletPreferences.setValue(ApplicationConstants.STRUCTURE_KEY, ParamUtil.getString(actionRequest, ApplicationConstants.PREFERECES_SET, StringPool.BLANK));
			portletPreferences.setValue(ApplicationConstants.PREF_ARTICLE_ID, ParamUtil.getString(actionRequest, ApplicationConstants.PREF_ARTICLE_ID, StringPool.BLANK));

			portletPreferences.store();

		}
		catch (Exception e)
		{
			_log.error(e.getMessage(), e);
		}
	}

}
