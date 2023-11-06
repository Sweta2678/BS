
package com.ihg.grs.util;

import com.ihg.grs.bean.SearchVO;
import com.ihg.grs.constant.ApplicationConstants;
import com.ihg.me2.core.service.CoreArticleLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.messageboards.model.MBMessage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;



/**
 * @author hiren.patel Search Util class used for Global Site Search portlet.
 */
public final class SearchUtil
{

	private static final Log LOGGER = LogFactoryUtil.getLog(SearchUtil.class);
	private static String[] articleKeywordsFields;
	private static String[] structureKeyList;
	private static final String DEFAULT_PER_PAGE_RECORDS = "10";

	/**
	 * Private Constructor.
	 */
	private SearchUtil()
	{

	}

	/**
	 * Get search result by passing keyword and portlet request.
	 * 
	 * @param keywords
	 *            Keyword from which need to search.
	 * @param request
	 *            Portlet request.
	 * @param sort
	 *            Sort 0 ->A-Z, 1->Z-A,2->Last Modified Date.
	 * @return List of SerachVO object.
	 */
	public static List<SearchVO> getSearchResults(String keywords, PortletRequest request, int sort)
	{

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(request);
		httpServletRequest = PortalUtil.getOriginalServletRequest(httpServletRequest);

		List<SearchVO> contentList = new ArrayList<SearchVO>();
		structureKeyList = StringUtils.split(request.getPreferences().getValue(ApplicationConstants.SITE_SEARCH_STRUCTURE_KEYS, StringPool.BLANK), StringPool.COMMA);

		int total = 0;

		setDisplayFieldsArray(themeDisplay);

		Hits results = null;

		// Set records per page as per the preferences
		int perPageRecords = Integer.parseInt(request.getPreferences().getValue("recordsPerPage", DEFAULT_PER_PAGE_RECORDS));

		PaginationUtil.paginate(httpServletRequest, perPageRecords);
		int start = GetterUtil.getInteger(httpServletRequest.getAttribute(PaginationUtil.START_INDEX), QueryUtil.ALL_POS);
		int end = GetterUtil.getInteger(httpServletRequest.getAttribute(PaginationUtil.END_INDEX), QueryUtil.ALL_POS);

		String[] entryClassNames = new String[] {
			JournalArticle.class.getName(), DLFileEntry.class.getName(), MBMessage.class.getName()
		};

		SearchContext searchContext = new SearchContext();
		searchContext.setEntryClassNames(entryClassNames);
		searchContext.setGroupIds(new long[] {
			themeDisplay.getScopeGroupId()
		});
		searchContext.setCompanyId(themeDisplay.getCompanyId());
		searchContext.setKeywords(keywords);
		searchContext.setSorts(getSortParam(sort));
		searchContext.setStart(start);
		searchContext.setEnd(end);
		searchContext.setAttribute("assetCategoryTitle", ApplicationConstants.ASSET_CATEGORY_ARCHIVES);
		searchContext.setAttribute("fieldsName", new String[] {
			Field.TITLE
		});
		searchContext.setAttribute("structureKeyList", structureKeyList);
		searchContext.setAttribute("assetCategoryTitleBooleanClause", BooleanClauseOccur.MUST_NOT.toString());
		searchContext.setAttribute("isSearchKeywordWithStar", Boolean.TRUE);

		results = CoreArticleLocalServiceUtil.getSearchResults(searchContext);

		if (Validator.isNotNull(results))
		{
			LOGGER.info("Search counts ---->" + results.getLength());
			total = results.getLength();
			setSearchVOList(contentList, results, request);
		}

		PaginationUtil.paginate(httpServletRequest, total, perPageRecords);
		request.setAttribute("totalcount", total);
		return contentList;
	}

	/**
	 * Set List SerachVO object list with search result.
	 * 
	 * @param contentList
	 *            Content List for adding SerachVO object.
	 * @param results
	 *            Search Results based on keyword search.
	 * @param request
	 *            URL retrieve on PageName.
	 */
	private static void setSearchVOList(List<SearchVO> contentList, Hits results, PortletRequest request)
	{
		for (int i = 0; i < results.toList().size(); i++)
		{
			Document doc = results.doc(i);
			SearchVO searchVO = new SearchVO();
			try
			{
				if (doc.get(Field.ENTRY_CLASS_NAME).equals(DLFileEntry.class.getName()))
				{
					searchVO.setType("document");

					long documentId = Long.parseLong(doc.get(Field.ENTRY_CLASS_PK));
					DLFileEntry dlFile = DLFileEntryLocalServiceUtil.getDLFileEntry(documentId);

					searchVO.setUrl(ApplicationConstants.DOWNLOAD_PATH + dlFile.getGroupId() + StringPool.SLASH + dlFile.getUuid());
					searchVO.setDesc(StringUtil.shorten(HtmlUtil.stripHtml(doc.get(Field.DESCRIPTION)), ApplicationConstants.ARTICLE_LISTING_DESCRIPTION_LENGTH));
					searchVO.setId(doc.get(Field.ENTRY_CLASS_PK));
					searchVO.setTitle(doc.get(Field.TITLE));
					searchVO.setDate(DateUtil.getFormattedDate(doc.get(Field.CREATE_DATE), ApplicationConstants.ARTICLE_DETAILS_DATE_FORMAT));
					searchVO.setImageUrl(ApplicationConstants.DEFAULT_SEARCH_RESULT_IMAGE_URLS + searchVO.getType() + ApplicationConstants.IMAGE_EXTENSION);

				}
				else if (doc.get(Field.ENTRY_CLASS_NAME).equals(JournalArticle.class.getName()))
				{
					String structurekey = doc.get("ddmStructureKey");
					searchVO.setTitle(doc.get(getFieldNamebyStructureKey(structurekey, Field.TITLE)));
					searchVO.setType(getArticleTypeByStructureKey(structurekey));
					searchVO.setDesc(StringUtil.shorten(
						HtmlUtil.stripHtml(doc.get(getFieldNamebyStructureKey(structurekey, Field.DESCRIPTION))), ApplicationConstants.ARTICLE_LISTING_DESCRIPTION_LENGTH));
					String articleId = doc.get("articleId");
					LOGGER.info("Article ID : " + articleId + "------->>> " + doc.get(Field.TITLE));

					searchVO.setId(articleId);
					searchVO.setUrl(ActionUtil.getFullURLByPageName(request, getPageNameByStuctureKey(structurekey)) + "?id=" + articleId);
					searchVO.setDate(DateUtil.getFormattedDate(doc.get("displayDate"), ApplicationConstants.ARTICLE_DETAILS_DATE_FORMAT));
					searchVO.setImageUrl(ApplicationConstants.DEFAULT_SEARCH_RESULT_IMAGE_URLS + searchVO.getType() + ApplicationConstants.IMAGE_EXTENSION);
				}
				else if (doc.get(Field.ENTRY_CLASS_NAME).equals(MBMessage.class.getName()))
				{
					searchVO.setTitle(doc.get(Field.TITLE));
					searchVO.setType("discuss");
					searchVO.setDesc(StringUtil.shorten(HtmlUtil.stripHtml(doc.get(Field.CONTENT)), ApplicationConstants.ARTICLE_LISTING_DESCRIPTION_LENGTH));
					searchVO.setId(doc.get(Field.ENTRY_CLASS_PK));
					searchVO.setImageUrl(ApplicationConstants.DEFAULT_SEARCH_RESULT_IMAGE_URLS + searchVO.getType() + ApplicationConstants.IMAGE_EXTENSION);
					searchVO.setDate(DateUtil.getFormattedDate(doc.get(Field.CREATE_DATE), ApplicationConstants.ARTICLE_DETAILS_DATE_FORMAT));
					searchVO.setUrl(ActionUtil.getFullURLByPageName(request, ApplicationConstants.PAGE_NAME_DISCUSSIONS) + "?id=" + doc.get("threadId"));
				}
			}
			catch (NumberFormatException e)
			{
				LOGGER.error("Number Format Error in retrieving articles", e);
			}
			catch (ParseException e)
			{
				LOGGER.error("Parse Error in retrieving articles", e);
			}
			catch (PortalException e)
			{
				LOGGER.error("Portal Error in retrieving articles", e);
			}
			catch (SystemException e)
			{
				LOGGER.error("System Error in retrieving articles", e);
			}

			contentList.add(searchVO);
		}
	}

	/**
	 * Set Keyword Search Fields based on StructureKeys defined in preferences.
	 * 
	 * @param themeDisplay
	 *            use for current site id.
	 */
	private static void setDisplayFieldsArray(ThemeDisplay themeDisplay)
	{
		try
		{
			long journalArticleClassNameId = ClassNameLocalServiceUtil.getClassNameId(JournalArticle.class.getName());
			int col = 0;
			DDMStructure curStructure = null;
			String articlesKeywordsFields = StringPool.BLANK;
			if (structureKeyList.length == 3)
			{
				// GRS_ARTICLE
				curStructure = DDMStructureLocalServiceUtil.getStructure(themeDisplay.getScopeGroupId(), journalArticleClassNameId, structureKeyList[col]);

				articlesKeywordsFields =
					"ddm" + StringPool.SLASH + curStructure.getStructureId() + StringPool.SLASH + ApplicationConstants.ARTICLE_TITLE + StringPool.UNDERLINE + themeDisplay.getLocale() +
						StringPool.COMMA;
				articlesKeywordsFields +=
					"ddm" + StringPool.SLASH + curStructure.getStructureId() + StringPool.SLASH + ApplicationConstants.ARTICLE_DESCRTIPTION + StringPool.UNDERLINE + themeDisplay.getLocale() +
						StringPool.COMMA;

				// BLOG_ARTICLE
				curStructure = DDMStructureLocalServiceUtil.getStructure(themeDisplay.getScopeGroupId(), journalArticleClassNameId, structureKeyList[++col]);

				articlesKeywordsFields +=
					"ddm" + StringPool.SLASH + curStructure.getStructureId() + StringPool.SLASH + ApplicationConstants.BLOG_TITLE + StringPool.UNDERLINE + themeDisplay.getLocale() + StringPool.COMMA;
				articlesKeywordsFields +=
					"ddm" + StringPool.SLASH + curStructure.getStructureId() + StringPool.SLASH + ApplicationConstants.BLOG_DESCRTIPTION + StringPool.UNDERLINE + themeDisplay.getLocale() +
						StringPool.COMMA;

				// FAQ_ARTICLE
				curStructure = DDMStructureLocalServiceUtil.getStructure(themeDisplay.getScopeGroupId(), journalArticleClassNameId, structureKeyList[++col]);

				articlesKeywordsFields +=
					"ddm" + StringPool.SLASH + curStructure.getStructureId() + StringPool.SLASH + ApplicationConstants.FAQ_QUESTION + StringPool.UNDERLINE + themeDisplay.getLocale() +
						StringPool.COMMA;
				articlesKeywordsFields +=
					"ddm" + StringPool.SLASH + curStructure.getStructureId() + StringPool.SLASH + ApplicationConstants.FAQ_ANSWER + StringPool.UNDERLINE + themeDisplay.getLocale() + StringPool.COMMA;
				articlesKeywordsFields += Field.TITLE;
			}
			else if (structureKeyList.length == 1)
			{
				// GRS_ARTICLE
				curStructure = DDMStructureLocalServiceUtil.getStructure(themeDisplay.getScopeGroupId(), journalArticleClassNameId, structureKeyList[col]);

				articlesKeywordsFields =
					"ddm" + StringPool.SLASH + curStructure.getStructureId() + StringPool.SLASH + ApplicationConstants.ARTICLE_TITLE + StringPool.UNDERLINE + themeDisplay.getLocale() +
						StringPool.COMMA;
				articlesKeywordsFields +=
					"ddm" + StringPool.SLASH + curStructure.getStructureId() + StringPool.SLASH + ApplicationConstants.ARTICLE_DESCRTIPTION + StringPool.UNDERLINE + themeDisplay.getLocale() +
						StringPool.COMMA;
				articlesKeywordsFields += Field.TITLE;
			}
			articleKeywordsFields = StringUtils.split(articlesKeywordsFields, StringPool.COMMA);
		}
		catch (PortalException e)
		{
			LOGGER.error("Portal Error in retrieving search results", e);
		}
		catch (SystemException e)
		{
			LOGGER.error("System Error in retrieving search results", e);
		}
	}

	/**
	 * Based on structurekey, we are passing article type.
	 * 
	 * @param ddmStructureKey
	 *            Structure key.
	 * @return articleType Type of Article.
	 */
	private static String getArticleTypeByStructureKey(String ddmStructureKey)
	{
		String articleType = StringPool.BLANK;
		if (ddmStructureKey.equals(ApplicationConstants.ARTICLE_STRUCTURE_KEY) || ddmStructureKey.equals(ApplicationConstants.VIDEO_STRUCTURE_KEY) )
		{
			articleType = ApplicationConstants.SITE_SEARCH_ARTICLE_TYPE;
		}
		else if (ddmStructureKey.equals(ApplicationConstants.BLOG_STRUCTURE_KEY))
		{
			articleType = ApplicationConstants.SITE_SEARCH_BLOG_TYPE;
		}
		else if (ddmStructureKey.equals(ApplicationConstants.FAQ_STRUCTURE_KEY))
		{
			articleType = ApplicationConstants.SITE_SEARCH_FAQ_TYPE;
		}

		return articleType;
	}

	/**
	 * This method is returned field name as per structurekey.
	 * 
	 * @param ddmStructureKey
	 *            passing structurekey.
	 * @param fieldName
	 *            passing fieldName.
	 * @return fieldNameStucture structure Field Name.
	 */
	private static String getFieldNamebyStructureKey(String ddmStructureKey, String fieldName)
	{
		String fieldNameStucture = StringPool.BLANK;
		if (ddmStructureKey.equals(ApplicationConstants.ARTICLE_STRUCTURE_KEY) && fieldName.contains(Field.TITLE))
		{
			fieldNameStucture = articleKeywordsFields[0];
		}
		if (ddmStructureKey.equals(ApplicationConstants.ARTICLE_STRUCTURE_KEY) && fieldName.contains(Field.DESCRIPTION))
		{
			fieldNameStucture = articleKeywordsFields[1];
		}
		else if (ddmStructureKey.equals(ApplicationConstants.BLOG_STRUCTURE_KEY) && fieldName.contains(Field.TITLE))
		{
			fieldNameStucture = articleKeywordsFields[2];
		}
		else if (ddmStructureKey.equals(ApplicationConstants.BLOG_STRUCTURE_KEY) && fieldName.contains(Field.DESCRIPTION))
		{
			fieldNameStucture = articleKeywordsFields[3];
		}
		else if (ddmStructureKey.equals(ApplicationConstants.FAQ_STRUCTURE_KEY) && fieldName.contains(Field.TITLE))
		{
			fieldNameStucture = articleKeywordsFields[4];
		}
		else if (ddmStructureKey.equals(ApplicationConstants.FAQ_STRUCTURE_KEY) && fieldName.contains(Field.DESCRIPTION))
		{
			fieldNameStucture = articleKeywordsFields[5];
		}

		return fieldNameStucture;
	}

	/**
	 * Based on Structurekey, we are returning page name.
	 * 
	 * @param ddmStructureKey
	 *            passing structurekey.
	 * @return pageName Name of Page.
	 */
	private static String getPageNameByStuctureKey(String ddmStructureKey)
	{
		String pageName = StringPool.BLANK;
		if (ddmStructureKey.equals(ApplicationConstants.ARTICLE_STRUCTURE_KEY))
		{
			pageName = ApplicationConstants.PAGE_NAME_ARTICLE_DETAIL;
		}
		if (ddmStructureKey.equals(ApplicationConstants.BLOG_STRUCTURE_KEY))
		{
			pageName = ApplicationConstants.PAGE_NAME_BLOG_DETAIL;
		}
		else if (ddmStructureKey.equals(ApplicationConstants.FAQ_STRUCTURE_KEY))
		{
			pageName = ApplicationConstants.PAGE_NAME_FAQ;
		}
		return pageName;
	}

	/**
	 * This method will be returning sortParam passing sort value.
	 * 
	 * @param sort
	 *            integer sort no
	 * @return sort parameter
	 */
	private static Sort getSortParam(int sort)
	{
		Sort sortParam = null;
		if (sort == 0)
		{
			sortParam = SortFactoryUtil.create(ApplicationConstants.SEARCH_TITLE, false);
		}
		else if (sort == 1)
		{
			sortParam = SortFactoryUtil.create(ApplicationConstants.SEARCH_TITLE, true);
		}
		else if (sort == 2)
		{
			sortParam = SortFactoryUtil.create(ApplicationConstants.SEARCH_LAST_MODIFIED_DATE, true);
		}
		return sortParam;
	}
}
