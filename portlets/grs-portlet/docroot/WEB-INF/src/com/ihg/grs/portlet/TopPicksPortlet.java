
package com.ihg.grs.portlet;

import com.ihg.grs.bean.ArticleInfoBean;
import com.ihg.grs.constant.ApplicationConstants;
import com.ihg.grs.util.ArticleUtil;
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
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class TopPicksPortlet.
 */
public class TopPicksPortlet extends MVCPortlet
{

	private static final Log LOGGER = LogFactoryUtil.getLog(TopPicksPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
	{

		try
		{
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			PortletPreferences prefs = renderRequest.getPreferences();
			List<String> prefArticleList = new ArrayList<String>();
			List<JournalArticle> articleList = new ArrayList<JournalArticle>();
			List<ArticleInfoBean> articleInfoList = new ArrayList<ArticleInfoBean>();

			SearchContext searchContext = new SearchContext();
			searchContext.setSorts(new Sort(ApplicationConstants.ARTICLE_LISTING_DEFAULT_SORT_ORDER, false));

			if (Validator.isNotNull(prefs))
			{

				String articleIds = prefs.getValue(ApplicationConstants.TOP_PICKS_ARTICLE_IDS, StringPool.BLANK);

				prefArticleList = Arrays.asList(articleIds.split(StringPool.COMMA));

			}

			if (Validator.isNotNull(prefArticleList))
			{

				for (String articleId : prefArticleList)
				{
					JournalArticle article = JournalArticleLocalServiceUtil.getLatestArticle(themeDisplay.getScopeGroupId(), articleId);
					articleList.add(article);
				}
				articleInfoList = ArticleUtil.getArticleInfoFromArticleList(themeDisplay, articleList);

			}

			renderRequest.setAttribute(ApplicationConstants.ARTICLE_INFO_LIST, articleInfoList);

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
				renderRequest.setAttribute(ApplicationConstants.TOP_PICKS_ARTICLE_IDS, prefs.getValue(ApplicationConstants.TOP_PICKS_ARTICLE_IDS, StringPool.BLANK));
			}
			super.doEdit(renderRequest, renderResponse);
		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * Setting preferences for Top Picks Portlet.
	 * 
	 * @param actionRequest
	 *            Action request is passed when Preferences saved.
	 * @param actionResponse
	 *            After saving action response is passing response.
	 */
	public void setTopPicksPreferences(ActionRequest actionRequest, ActionResponse actionResponse)
	{

		try
		{
			PortletPreferences portletPreferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);
			portletPreferences.setValue(ApplicationConstants.TOP_PICKS_ARTICLE_IDS, ParamUtil.getString(actionRequest, ApplicationConstants.TOP_PICKS_PREF_ARTICLE_IDS, StringPool.BLANK));

			portletPreferences.store();

		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage(), e);
		}
	}

}
