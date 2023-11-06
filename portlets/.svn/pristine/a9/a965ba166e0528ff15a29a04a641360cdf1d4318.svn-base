
package com.ihg.grs.util;

import com.ihg.grs.bean.ArticleInfoBean;
import com.ihg.grs.bean.SearchVO;
import com.ihg.grs.constant.ApplicationConstants;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.bookmarks.model.BookmarksEntry;
import com.liferay.portlet.bookmarks.service.BookmarksEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * Utility class of HotelImplementationUtil.
 */
public final class HotelImplementationUtil
{

	private static final Log LOGGER = LogFactoryUtil.getLog(HotelImplementationUtil.class);
	private static String[] structureKeyList;

	/**
	 * Define a private constructor.
	 */
	private HotelImplementationUtil()
	{
	}
 
	public static Map<List<SearchVO>,List<SearchVO>> getArticlesDlFilesAndBookmarksByStrKeyAndCategoryIds(PortletRequest request)
	{

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(request);
		httpServletRequest = PortalUtil.getOriginalServletRequest(httpServletRequest);
		PortletPreferences prefs = request.getPreferences();

		Map<List<SearchVO>, List<SearchVO>> contentDetailsMap = new HashMap<List<SearchVO>, List<SearchVO>>();
		List<String> understandTheGrsCategroyList = new ArrayList<String>();
		List<String> getReadyGrsCategroyList = new ArrayList<String>();
		structureKeyList = new String[] {ApplicationConstants.ARTICLE_STRUCTURE_KEY};

		long grsCommGroupId = 0l;
		long grsCommUnderstandTheGRSCategroyId = 0l;
		long grsCommGetReadyGRSCategroyId = 0l;
		long grsHtlImplUnderstandTheGRSCategroyId = 0l;
		long grsHtlImplGetReadyGRSCategroyId = 0l;

		if (Validator.isNotNull(prefs))
		{
			grsCommGroupId = Long.parseLong(prefs.getValue(ApplicationConstants.GRS_COMM_GROUPID, "0"));
			grsCommUnderstandTheGRSCategroyId = Long.parseLong(prefs.getValue(ApplicationConstants.GRS_COMM_CATEGORYID_UNDERSTAND_GRS, "0"));
			grsCommGetReadyGRSCategroyId = Long.parseLong(prefs.getValue(ApplicationConstants.GRS_COMM_CATEGORYID_GET_READY, "0"));
			grsHtlImplUnderstandTheGRSCategroyId = Long.parseLong(prefs.getValue(ApplicationConstants.GRS_HOTELIMP_CATEGORYID_UNDERSTAND_GRS, "0"));
			grsHtlImplGetReadyGRSCategroyId = Long.parseLong(prefs.getValue(ApplicationConstants.GRS_HOTELIMP_CATEGORYID_GET_READY, "0"));

			understandTheGrsCategroyList.add(String.valueOf(grsCommUnderstandTheGRSCategroyId));
			understandTheGrsCategroyList.add(String.valueOf(grsHtlImplUnderstandTheGRSCategroyId));

			getReadyGrsCategroyList.add(String.valueOf(grsCommGetReadyGRSCategroyId));
			getReadyGrsCategroyList.add(String.valueOf(grsHtlImplGetReadyGRSCategroyId));

			Hits results = null;

			String[] entryClassNames = new String[] {
				JournalArticle.class.getName(), DLFileEntry.class.getName(), BookmarksEntry.class.getName()
			};

			SearchContext searchContext = new SearchContext();
			searchContext.setEntryClassNames(entryClassNames);
			searchContext.setGroupIds(new long[] {
				themeDisplay.getScopeGroupId(), grsCommGroupId
			});
			searchContext.setSorts(SortFactoryUtil.create(ApplicationConstants.SEARCH_LAST_MODIFIED_DATE, true));
			searchContext.setCompanyId(themeDisplay.getCompanyId());
			searchContext.setAttribute("structureKeyList", structureKeyList);
			searchContext.setCategoryIds(new long[] {
				grsCommUnderstandTheGRSCategroyId, grsCommGetReadyGRSCategroyId, grsHtlImplUnderstandTheGRSCategroyId, grsHtlImplGetReadyGRSCategroyId
			});

			QueryConfig queryConfig = new QueryConfig();
			queryConfig.setSearchSubfolders(true);
			searchContext.setQueryConfig(queryConfig);

			results = getArticlesDlFilesAndBookmarksByStrKeyAndCategoryIds(searchContext);

			if (Validator.isNotNull(results))
			{
				LOGGER.debug("Search counts ---->" + results.getLength());
				setContentDetailsVO(contentDetailsMap, results, understandTheGrsCategroyList, getReadyGrsCategroyList, request, themeDisplay.getLocale().toString());
			}
		}
		return contentDetailsMap;
	}
	
	
	public static Hits getArticlesDlFilesAndBookmarksByStrKeyAndCategoryIds(SearchContext searchContextParams)
	{
		Hits results = null;
		
		if (searchContextParams.getEntryClassNames() != null)
		{
			String[] structureKeyList = (String[]) searchContextParams.getAttribute("structureKeyList");
			List<String> entryClassNames = Arrays.asList(searchContextParams.getEntryClassNames());
			
			SearchContext searchContext = new SearchContext();
			searchContext.setCompanyId(searchContextParams.getCompanyId());
			searchContext.setGroupIds(searchContextParams.getGroupIds());
			searchContext.setQueryConfig(searchContextParams.getQueryConfig());

			BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);			
			fullQuery.addRequiredTerm(Field.STATUS, WorkflowConstants.STATUS_APPROVED);

			try
			{
				if (searchContextParams.getGroupIds() != null && searchContextParams.getGroupIds().length > 0)
				{
					BooleanQuery allGroupIDQuery = BooleanQueryFactoryUtil.create(searchContext);
					for (long groupId : searchContextParams.getGroupIds())
					{
						allGroupIDQuery.addExactTerm(Field.GROUP_ID, groupId);
					}
					fullQuery.add(allGroupIDQuery, BooleanClauseOccur.MUST);
				}
				
				if (Validator.isNotNull(searchContextParams.getCategoryIds()) && searchContextParams.getCategoryIds().length > 0)
				{
					BooleanQuery assetCategoryIdQuery = BooleanQueryFactoryUtil.create(searchContext);
					for (long categoryid : searchContextParams.getCategoryIds()) 
					{
						if (categoryid != -1 )
						{
							assetCategoryIdQuery.addExactTerm(Field.ASSET_CATEGORY_IDS, categoryid);
						}
					}
					fullQuery.add(assetCategoryIdQuery,BooleanClauseOccur.MUST);	
				}
				
				BooleanQuery mainSearchQuery = BooleanQueryFactoryUtil.create(searchContext);

				/* Preparing article query */
				if (entryClassNames.contains(JournalArticle.class.getName()))
				{

					BooleanQuery articleQuery = BooleanQueryFactoryUtil.create(searchContext);
					articleQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, JournalArticle.class.getName());
					articleQuery.addRequiredTerm("head", Boolean.TRUE);
					
					if (structureKeyList != null && structureKeyList.length > 0)
					{
						BooleanQuery allStructureQuery = BooleanQueryFactoryUtil.create(searchContext);
						for (String structureId : structureKeyList)
						{
							allStructureQuery.addExactTerm("ddmStructureKey", structureId);
						}
						articleQuery.add(allStructureQuery, BooleanClauseOccur.MUST);
					}					
					
					mainSearchQuery.add(articleQuery, BooleanClauseOccur.SHOULD);
				}

				/* Preparing dlFileEntry query */
				if (entryClassNames.contains(DLFileEntry.class.getName()))
				{

					BooleanQuery dlFileEntryQuery = BooleanQueryFactoryUtil.create(searchContext);
					dlFileEntryQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, DLFileEntry.class.getName());
					dlFileEntryQuery.addRequiredTerm(Field.HIDDEN, Boolean.FALSE);
					
					mainSearchQuery.add(dlFileEntryQuery, BooleanClauseOccur.SHOULD);
				}
				
				/* Preparing BookmarksEntry query */
				if (entryClassNames.contains(BookmarksEntry.class.getName()))
				{
					BooleanQuery bookMarkQuery = BooleanQueryFactoryUtil.create(searchContext);
					bookMarkQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, BookmarksEntry.class.getName());

					mainSearchQuery.add(bookMarkQuery, BooleanClauseOccur.SHOULD);
				}

				/* Adding all sub queries in full query */

				if(mainSearchQuery.clauses().size() >0){
					fullQuery.add(mainSearchQuery, BooleanClauseOccur.MUST);
				}

				LOGGER.info("Full Query :::  \n" + fullQuery);

				if (searchContextParams.getSorts() == null || searchContextParams.getSorts()[0] == null)
				{
					results = SearchEngineUtil.search(searchContext.getSearchEngineId(), searchContextParams.getCompanyId(), fullQuery,QueryUtil.ALL_POS,QueryUtil.ALL_POS);
				}
				else
				{
					results = SearchEngineUtil.search(searchContext.getSearchEngineId(), searchContextParams.getCompanyId(), fullQuery, searchContextParams.getSorts(), QueryUtil.ALL_POS,QueryUtil.ALL_POS);
				}
			}
			catch (Exception e)
			{
				LOGGER.error(e.getMessage(), e);
			}
			
		}
		return results;
	}
	
	
	private static void setContentDetailsVO(Map<List<SearchVO>,List<SearchVO>> contentList, Hits results, List<String> understandTheGrsCategroyList, List<String> getReadyGrsCategroyList, PortletRequest portletRequest, String locale )
	{
		List<SearchVO> understandTheGrsCategroyContentList = new ArrayList<SearchVO>();
		List<SearchVO> getReadyGrsCategroyContentList = new ArrayList<SearchVO>();
		for (int i = 0; i < results.toList().size(); i++)
		{
			Document doc = results.doc(i);
			SearchVO searchVO = new SearchVO();
			try
			{
				if (doc.get(Field.ENTRY_CLASS_NAME).equals(DLFileEntry.class.getName()))
				{
					long documentId = Long.parseLong(doc.get(Field.ENTRY_CLASS_PK));
					DLFileEntry dlFile = DLFileEntryLocalServiceUtil.getDLFileEntry(documentId);
					
					searchVO.setTitle(doc.get(Field.TITLE));
					searchVO.setType("document");
					searchVO.setUrl(ApplicationConstants.DOWNLOAD_PATH + dlFile.getGroupId() + StringPool.SLASH + dlFile.getUuid());
				}
				else if (doc.get(Field.ENTRY_CLASS_NAME).equals(JournalArticle.class.getName()))
				{
					String structurekey = doc.get("ddmStructureKey");
					long groupId = Long.parseLong(doc.get(Field.SCOPE_GROUP_ID));
					searchVO.setTitle(doc.get(getFieldNamebyStructureKey(structurekey, groupId, locale)));
					searchVO.setType(ApplicationConstants.SITE_SEARCH_ARTICLE_TYPE);
					String articleId = doc.get("articleId");
					searchVO.setUrl(ActionUtil.getFullURLByPageName(portletRequest, groupId, ApplicationConstants.PAGE_NAME_ARTICLE_DETAIL) + "?id=" + articleId);					
				}
				else if (doc.get(Field.ENTRY_CLASS_NAME).equals(BookmarksEntry.class.getName()))
				{
					long entryId = Long.parseLong(doc.get(Field.ENTRY_CLASS_PK));
					BookmarksEntry bkFile = BookmarksEntryLocalServiceUtil.getBookmarksEntry(entryId);
					
					searchVO.setTitle(doc.get(Field.TITLE));
					searchVO.setType("bookmark");
					searchVO.setUrl(bkFile.getUrl());
				}
				List<String> assetCategoryIdsList = Arrays.asList(doc.getValues(Field.ASSET_CATEGORY_IDS));
				if(assetCategoryIdsList.contains(understandTheGrsCategroyList.get(0)) || assetCategoryIdsList.contains(understandTheGrsCategroyList.get(1)))
				{
					understandTheGrsCategroyContentList.add(searchVO);
				}
				if(assetCategoryIdsList.contains(getReadyGrsCategroyList.get(0)) || assetCategoryIdsList.contains(getReadyGrsCategroyList.get(1)))
				{
					getReadyGrsCategroyContentList.add(searchVO);
				}	
				
			}
			catch (NumberFormatException e)
			{
				LOGGER.error("Number Format Error in retrieving articles", e);
			}
			
			catch (PortalException e)
			{
				LOGGER.error("Portal Error in retrieving articles", e);
			}
			catch (SystemException e)
			{
				LOGGER.error("System Error in retrieving articles", e);
			}
		}
		contentList.put(understandTheGrsCategroyContentList, getReadyGrsCategroyContentList);
	}
	
	/**
	 * Converting list of articles into custom article info bean.
	 * 
	 * @param themeDisplay of ThemeDisplay
	 * @param articleId of JournalArticle
	 * @return articleInfoBean
	 */
	public static ArticleInfoBean getArticleInfo(ThemeDisplay themeDisplay, String articleId)
	{
		ArticleInfoBean articleInfoBean = new ArticleInfoBean();
		Map<String, String> dataMap = new HashMap<String, String>();
		try
		{
			JournalArticle journalArticle = JournalArticleLocalServiceUtil.getLatestArticle(themeDisplay.getScopeGroupId(), articleId);
			
			dataMap = XMLUtils.getXMLDynamicData(journalArticle.getContent(), ApplicationConstants.DYNAMIC_HOME_PAGE_FIELDS);
			
			articleInfoBean.setArtical(journalArticle);
			articleInfoBean.setMainTitle(dataMap.get(ApplicationConstants.HOTEL_IMP_MAIN_TITLE));
			articleInfoBean.setTitle1(dataMap.get(ApplicationConstants.HOTEL_IMP_TITLE_1));
			articleInfoBean.setDescription1(dataMap.get(ApplicationConstants.HOTEL_IMP_DESCRIPTION_1));
			articleInfoBean.setTitle2(dataMap.get(ApplicationConstants.HOTEL_IMP_TITLE_2));
			articleInfoBean.setDescription2(dataMap.get(ApplicationConstants.HOTEL_IMP_DESCRIPTION_2));
			articleInfoBean.setTitle3(dataMap.get(ApplicationConstants.HOTEL_IMP_TITLE_3));
			articleInfoBean.setImage1(dataMap.get(ApplicationConstants.HOTEL_IMP_IMAGE_1));
			articleInfoBean.setLabel1(dataMap.get(ApplicationConstants.HOTEL_IMP_LABEL_1));
			articleInfoBean.setUrl1(dataMap.get(ApplicationConstants.HOTEL_IMP_URL_1));
			articleInfoBean.setImage2(dataMap.get(ApplicationConstants.HOTEL_IMP_IMAGE_2));
			articleInfoBean.setLabel2(dataMap.get(ApplicationConstants.HOTEL_IMP_LABEL_2));
			articleInfoBean.setUrl2(dataMap.get(ApplicationConstants.HOTEL_IMP_URL_2));
			articleInfoBean.setImage3(dataMap.get(ApplicationConstants.HOTEL_IMP_IMAGE_3));
			articleInfoBean.setLabel3(dataMap.get(ApplicationConstants.HOTEL_IMP_LABEL_3));
			articleInfoBean.setUrl3(dataMap.get(ApplicationConstants.HOTEL_IMP_URL_3));
			articleInfoBean.setImage4(dataMap.get(ApplicationConstants.HOTEL_IMP_IMAGE_4));
			articleInfoBean.setLabel4(dataMap.get(ApplicationConstants.HOTEL_IMP_LABEL_4));
			articleInfoBean.setUrl4(dataMap.get(ApplicationConstants.HOTEL_IMP_URL_4));
			articleInfoBean.setTitle5(dataMap.get(ApplicationConstants.HOTEL_IMP_TITLE_5));
			articleInfoBean.setDescription5(dataMap.get(ApplicationConstants.HOTEL_IMP_DESCRIPTION_5));
		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage(), e);
		}
		return articleInfoBean;
	}
	
	/**
	 * This method is returned field name as per structurekey.
	 * 
	 * @param ddmStructureKey           
	 * @param scopeGroupId
	 * @param locale
	 * @return fieldNameStucture structure Field Name.
	 */
	private static String getFieldNamebyStructureKey(String ddmStructureKey, long scopeGroupId, String locale)
	{
		long journalArticleClassNameId = ClassNameLocalServiceUtil.getClassNameId(JournalArticle.class.getName());	
		DDMStructure curStructure =  null;
		String article_title =  StringPool.BLANK;
		try
		{
			curStructure = DDMStructureLocalServiceUtil.getStructure(scopeGroupId, journalArticleClassNameId, ddmStructureKey);
			article_title = "ddm" + StringPool.SLASH + curStructure.getStructureId() + StringPool.SLASH + ApplicationConstants.ARTICLE_TITLE + StringPool.UNDERLINE + locale;
		}
		catch (PortalException e)
		{
			LOGGER.error("Portal Error in retrieving Field Name", e);
		}
		catch (SystemException e)
		{
			LOGGER.error("System Error in retrieving Field Name", e);
		}
		
		
		return article_title;
		
	}
}
