
package com.ihg.grs.portlet;

import com.ihg.grs.bean.ArticleInfoBean;
import com.ihg.grs.constant.ApplicationConstants;
import com.ihg.grs.util.ArticleUtil;
import com.ihg.grs.util.PaginationUtil;
import com.ihg.me2.core.service.CoreArticleLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.persistence.AssetEntryQuery;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleResource;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Portlet implementation class ArticleListingPortlet.
 * Retrieving preferences and List of Articles agains Structure Key.
 */
public class ArticleListingPortlet extends MVCPortlet
{

	private static final Log LOGGER = LogFactoryUtil.getLog(ArticleListingPortlet.class);


	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
	{
		try
		{
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			PortletPreferences prefs = renderRequest.getPreferences();
			String structureKey = StringPool.BLANK;
			String categoryPrefID = StringPool.BLANK;
			String glblPrefCategoryID = StringPool.BLANK;
			long categoryID = 0l;
			long glblCategoryID = 0l;
			String[] structureKeyArray = new String[1];
			List<ArticleInfoBean> articleInfoList = new ArrayList<ArticleInfoBean>();
			HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));

			SearchContext searchContext = new SearchContext();
			searchContext.setSorts(new Sort(ApplicationConstants.ARTICLE_LISTING_DEFAULT_SORT_ORDER, true));
			int perPage = 0;
			int totalRecords = 0;

			if (Validator.isNotNull(prefs))
			{
				structureKey = prefs.getValue(ApplicationConstants.STRUCTURE_KEY, StringPool.BLANK);
				structureKeyArray[0] = structureKey;
				perPage = Integer.parseInt(prefs.getValue(ApplicationConstants.ARTICLE_PER_PAGE, "10"));
				categoryPrefID = prefs.getValue(ApplicationConstants.CATEGORY_ID, "0");
				categoryID = Long.parseLong(categoryPrefID.trim());
				glblPrefCategoryID = prefs.getValue(ApplicationConstants.GLOBAL_CATEGORY_ID, "0");
				glblCategoryID = Long.parseLong(glblPrefCategoryID.trim());
				LOGGER.info("Global Category ID : "+glblCategoryID + " Category ID : "+categoryID);
			}

			if (Validator.isNotNull(structureKey) && !Validator.isBlank(structureKey))
			{
//				adding check for preference set for categoryID and fetching articles based on the preffered category
				if(categoryID > 0 || glblCategoryID > 0){
					long[] categoryIDs = null;
					if(categoryID > 0 && glblCategoryID == 0){
						categoryIDs = new long[] {categoryID};
						totalRecords = CoreArticleLocalServiceUtil.getStructureArticlesByStructureKeyCategoryIdCount(themeDisplay.getScopeGroupId(), structureKeyArray, searchContext,categoryIDs);
						PaginationUtil.paginate(httpReq, totalRecords, perPage);
						int start = GetterUtil.getInteger(renderRequest.getAttribute(PaginationUtil.START_INDEX), QueryUtil.ALL_POS);
						int end = GetterUtil.getInteger(renderRequest.getAttribute(PaginationUtil.END_INDEX), QueryUtil.ALL_POS);
						List<JournalArticle> articles = CoreArticleLocalServiceUtil.getStructureArticlesByStructureKeyCategoryId(themeDisplay.getScopeGroupId(), structureKeyArray,searchContext,categoryIDs , start, end);
						articleInfoList = ArticleUtil.getArticleInfoFromArticleList(themeDisplay, articles);
					}
					else if(categoryID == 0 && glblCategoryID > 0){
						categoryIDs = new long[] {glblCategoryID};
						totalRecords = CoreArticleLocalServiceUtil.getStructureArticlesByStructureKeyCategoryIdCount(themeDisplay.getScopeGroupId(), structureKeyArray, searchContext,categoryIDs);
						PaginationUtil.paginate(httpReq, totalRecords, perPage);
						int start = GetterUtil.getInteger(renderRequest.getAttribute(PaginationUtil.START_INDEX), QueryUtil.ALL_POS);
						int end = GetterUtil.getInteger(renderRequest.getAttribute(PaginationUtil.END_INDEX), QueryUtil.ALL_POS);
						List<JournalArticle> articles = CoreArticleLocalServiceUtil.getStructureArticlesByStructureKeyCategoryId(themeDisplay.getScopeGroupId(), structureKeyArray,searchContext,categoryIDs , start, end);
						articleInfoList = ArticleUtil.getArticleInfoFromArticleList(themeDisplay, articles);
					}
					else{
						// Get Articles with the combination of category and Global Categories
						categoryIDs = new long[] {categoryID, glblCategoryID};
						List<JournalArticle> articles = getGlobalandSiteCategoryArticles(totalRecords, perPage, httpReq, categoryIDs, themeDisplay.getScopeGroupId(), structureKey);
						articleInfoList = ArticleUtil.getArticleInfoFromArticleList(themeDisplay, articles);
					}
				}
				else{
					totalRecords = CoreArticleLocalServiceUtil.getStructureArticlesByStructureKeyCount(themeDisplay.getScopeGroupId(), structureKeyArray, searchContext);
					PaginationUtil.paginate(httpReq, totalRecords, perPage);
					int start = GetterUtil.getInteger(renderRequest.getAttribute(PaginationUtil.START_INDEX), QueryUtil.ALL_POS);
					int end = GetterUtil.getInteger(renderRequest.getAttribute(PaginationUtil.END_INDEX), QueryUtil.ALL_POS);
					List<JournalArticle> articles = CoreArticleLocalServiceUtil.getStructureArticlesByStructureKey(themeDisplay.getScopeGroupId(), structureKeyArray, searchContext, start, end);
					articleInfoList = ArticleUtil.getArticleInfoFromArticleList(themeDisplay, articles);
				}
			}

			renderRequest.setAttribute(ApplicationConstants.STRUCTURE_KEY, structureKey);
			renderRequest.setAttribute(ApplicationConstants.ARTICLE_INFO_LIST, articleInfoList);
			renderRequest.setAttribute(ApplicationConstants.CATEGORY_ID, categoryID);
			renderRequest.setAttribute(ApplicationConstants.GLOBAL_CATEGORY_ID, glblCategoryID);

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
				String structureKey = prefs.getValue(ApplicationConstants.STRUCTURE_KEY, StringPool.BLANK);
				renderRequest.setAttribute(ApplicationConstants.STRUCTURE_KEY, structureKey);
				String articlesPerPage = prefs.getValue(ApplicationConstants.ARTICLE_PER_PAGE, "10");
				renderRequest.setAttribute(ApplicationConstants.ARTICLE_PER_PAGE, articlesPerPage);
				String categoryID = prefs.getValue(ApplicationConstants.CATEGORY_ID, "0");
				renderRequest.setAttribute(ApplicationConstants.CATEGORY_ID, categoryID);
				String glblCategoryID = prefs.getValue(ApplicationConstants.GLOBAL_CATEGORY_ID, "0");
				renderRequest.setAttribute(ApplicationConstants.GLOBAL_CATEGORY_ID, glblCategoryID);

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
			portletPreferences.setValue(ApplicationConstants.ARTICLE_PER_PAGE, ParamUtil.getString(actionRequest, ApplicationConstants.PREFERECES_ARTICLE_PER_PAGE, "10"));
			portletPreferences.setValue(ApplicationConstants.CATEGORY_ID, ParamUtil.getString(actionRequest, ApplicationConstants.CATEGORY_ID, "0"));
			portletPreferences.setValue(ApplicationConstants.GLOBAL_CATEGORY_ID, ParamUtil.getString(actionRequest, ApplicationConstants.GLOBAL_CATEGORY_ID, "0"));
			portletPreferences.store();

		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage(), e);
		}
	}
	/**
	 * Get Articles based on the preferences for both category and Global category.
	 * 
	 */
	public List<JournalArticle> getGlobalandSiteCategoryArticles(int totalRecords, int perPage, HttpServletRequest httpReq, long[] categoryIDs, long groupId, String structureKey){
		int start = 0;
		int end = 0;
		AssetEntryQuery assetEntryQuery = new AssetEntryQuery();
		assetEntryQuery.setClassNameIds(new long[] { ClassNameLocalServiceUtil
				.getClassNameId(JournalArticle.class.getName()) });
		assetEntryQuery.setGroupIds(new long[] { groupId });
//		displayDate of JournalArticle is same as publishDate of AssetEntry
		assetEntryQuery.setOrderByCol1("publishDate");
		assetEntryQuery.setAllCategoryIds(categoryIDs);
		assetEntryQuery.setClassTypeIds(getStructureIdByName(groupId,structureKey));
		try {
			totalRecords =  AssetEntryLocalServiceUtil.getEntries(assetEntryQuery).size();
			PaginationUtil.paginate(httpReq, totalRecords, perPage);
			start = GetterUtil.getInteger(httpReq.getAttribute(PaginationUtil.START_INDEX), QueryUtil.ALL_POS);
			end = GetterUtil.getInteger(httpReq.getAttribute(PaginationUtil.END_INDEX), QueryUtil.ALL_POS);
		} catch (SystemException e2) {
			e2.printStackTrace();
		}
		assetEntryQuery.setStart(start);
		assetEntryQuery.setEnd(end);
		List<AssetEntry> assetEntryList = new ArrayList<AssetEntry>();
		List<JournalArticle> journalArticleList = new ArrayList<JournalArticle>();
		try 
		{
			assetEntryList = AssetEntryLocalServiceUtil.getEntries(assetEntryQuery);
			for (AssetEntry ae : assetEntryList) 
			{
				JournalArticleResource journalArticleResourceObj;
				try 
				{
					journalArticleResourceObj = JournalArticleResourceLocalServiceUtil.getJournalArticleResource(ae.getClassPK());
					JournalArticle journalArticleObj = JournalArticleLocalServiceUtil.getArticle(groupId, journalArticleResourceObj.getArticleId());
					journalArticleList.add(journalArticleObj);
				}
				catch (PortalException e) 
				{
					LOGGER.error("Error while fecthing assetEntry with classPK: " + ae.getClassPK(), e);
				}
			}
		}
		catch (SystemException e1) 
		{
			LOGGER.error("Error while fecthing Latest Articles for Global and site Categories: " + e1.getMessage(), e1);
		}
		return journalArticleList;
	}
	/**
	 * Get StructureID based on the Structure Key preferences.
	 * 
	 */
	public static long[] getStructureIdByName(long groupId, String structureName) {
		long structureId = 0l;
		try {
			DDMStructure ddmStructure =  DDMStructureLocalServiceUtil.getStructure(groupId, ClassNameLocalServiceUtil.getClassNameId(JournalArticle.class.getName()), structureName);
			structureId = ddmStructure.getStructureId();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return new long[]{structureId};
	} 
}
