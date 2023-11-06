package com.ihg.grs.util;

import com.ihg.grs.bean.AssetLibraryBean;
import com.ihg.grs.constant.ApplicationConstants;
import com.ihg.grs.constant.AssetLibraryConstant;
import com.ihg.grs.mail.GenericMail;
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
import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.util.portlet.PortletProps;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * Common utility class for Asset library toolkit portlet.
 * @author nakul.patel
 *
 */
public final class AssetLibUtil
{
	private static final Log LOGGER = LogFactoryUtil.getLog(AssetLibUtil.class);
	private static final int SORT = 3;
	
	/**
	 * private constructor for AssetLibUtil. 
	 */
	private AssetLibUtil()
	{
	
	}

	/**
	 * Categories of document for filtering search result.
	 * @param groupId Group id.
 	 * @param vocabularyName Name of vocabulary to get its category.
	 * @param request Portlet request object.
	 */
	public static void getAssetCategories(long groupId, String vocabularyName, PortletRequest request)
	{
		
		
		String vocabularyOne = PortletProps.get("VOCABULARY_ONE");
		String vocabularyTwo = PortletProps.get("VOCABULARY_TWO");
		
		try
		{
			AssetVocabulary oneCategory =  AssetVocabularyLocalServiceUtil.getGroupVocabulary(groupId, vocabularyOne);
			AssetVocabulary twoCategory = AssetVocabularyLocalServiceUtil.getGroupVocabulary(groupId, vocabularyTwo);
			
			List<AssetCategory> categoryOneList = AssetCategoryLocalServiceUtil.getVocabularyCategories(oneCategory.getVocabularyId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
			List<AssetCategory> categoryTwoList = AssetCategoryLocalServiceUtil.getVocabularyCategories(twoCategory.getVocabularyId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
			
			request.setAttribute("vocabularyOne", oneCategory.getName());
			request.setAttribute("vocabularyTwo", twoCategory.getName());
			request.setAttribute("categoryOneList", categoryOneList);
			request.setAttribute("categoryTwoList", categoryTwoList);
			

		}
		catch (PortalException e)
		{
			LOGGER.error(e.getMessage(), e);
		}
		catch (SystemException e)
		{
			LOGGER.error(e.getMessage(), e);
		}
		
	
	}
	
	/**
	 * Search for documents and returns POJO of the Document.
	 * @param keyWords The search keyword.
	 * @param themeDisplay Theme display object.
	 * @param renderRequest Render request object.
	 * @param categoryArray Array of category id for filtering search result.
	 * @param sortingOrder Sorting the search results order.
	 * @param searchContext Search context object.
	 * @return Search for documents and returns POJO of the Document.
	 */
	public static List<AssetLibraryBean> getSearchResult(String keyWords, ThemeDisplay themeDisplay, RenderRequest renderRequest, long[] categoryArray, 
		int sortingOrder, SearchContext searchContext)
	{
		
		HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		String[] entryClassNames = new String[]{DLFileEntry.class.getName()};
		List<AssetLibraryBean> searchList = new ArrayList<AssetLibraryBean>();
		
		if (Validator.isNotNull(keyWords) && !keyWords.equals(StringPool.BLANK))
		{
			/*BooleanQuery fullQuery = getBooleanQueryForKeywords(keyWords.toLowerCase(), themeDisplay, categoryArray,searchContext,renderRequest);*/
			
			PortletPreferences prefs = renderRequest.getPreferences();
			int perPage = Integer.valueOf(prefs.getValue("maxDocuments", "10"));
			
			/*LOGGER.info("fullQuery for AssetLibrary search :: " + fullQuery.toString());*/
			
			PaginationUtil.paginate(request, perPage);
			int start = GetterUtil.getInteger(request.getAttribute(PaginationUtil.START_INDEX), QueryUtil.ALL_POS);
			int end = GetterUtil.getInteger(request.getAttribute(PaginationUtil.END_INDEX), QueryUtil.ALL_POS);
			
			Hits hits = null;
			int total = 0;
			
			SearchContext searchContextParams = new SearchContext();
			searchContextParams.setEntryClassNames(entryClassNames);
			searchContextParams.setGroupIds(new long[]{themeDisplay.getScopeGroupId()});
			searchContextParams.setCompanyId(themeDisplay.getCompanyId());
			searchContextParams.setKeywords(keyWords);
			searchContextParams.setSorts(getSortParam(sortingOrder));
			searchContextParams.setStart(start);
			searchContextParams.setEnd(end);
			searchContextParams.setAttribute("assetCategoryTitle", ApplicationConstants.ASSET_CATEGORY_ARCHIVES);
			searchContextParams.setAttribute("fieldsName",  new String[]{Field.TITLE, Field.DESCRIPTION});
			searchContextParams.setAttribute("assetCategoryTitleBooleanClause", BooleanClauseOccur.MUST.toString());
			searchContextParams.setAttribute("isSearchKeywordWithStar", Boolean.TRUE);
			searchContextParams.setCategoryIds(categoryArray);
			QueryConfig queryConfig = new QueryConfig();
			queryConfig.setSearchSubfolders(true);
			searchContextParams.setQueryConfig(queryConfig);
			
			hits = CoreArticleLocalServiceUtil.getSearchResults(searchContextParams);
			
			if (Validator.isNotNull(hits))
			{
				total = hits.getLength();
				searchList = getSearchList(hits, themeDisplay, renderRequest);
			}
		    
			
			
			PaginationUtil.paginate(request, total, perPage);
			renderRequest.setAttribute("totalCount", total);
			
		}
		return searchList;
	
		
	}
	
	/**
	 * Converts the SOLR hits to Document object.
	 * @param hits Solr boolean query hits.
	 * @param themeDisplay Theme display object.
	 * @param renderRequest Render request object.
	 * @return Asset library bean pojo list.
	 */
	public static  List<AssetLibraryBean> getSearchList(Hits hits, ThemeDisplay themeDisplay, RenderRequest renderRequest) 
	{
		
		List<AssetLibraryBean> searchList = new ArrayList<AssetLibraryBean>();
		List<Document> documentList = hits.toList();
		AssetLibraryBean search = null ;
		String[] catnames = null;
		String cat = "";
		for (Document doc : documentList)
		{
			 search = new AssetLibraryBean();

			 if (doc.get(Field.TITLE) != null && !doc.get(Field.TITLE).equals(StringPool.BLANK))
			 {
				 String title = doc.get(Field.TITLE);
				 if (title.contains("."))
				 {
					 search.setHeading(title.substring(0, title.indexOf(".")));
				 }
				 else
				 {
					 search.setHeading(title);
				 }
			 }
			 
			 if (doc.getValues("assetCategoryNames") != null && doc.getValues("assetCategoryNames").length > 0)
			{
				 catnames = doc.getValues("assetCategoryNames") ;
				LOGGER.info("Categories length >>>>>>>>>>>>>" + catnames.length);
				 
				 cat = StringUtil.merge(catnames, ",");
				 cat = cat.replaceAll("\\[", "").replaceAll("\\]", "");
				 search.setCategory(cat);
				 }
				 	 LOGGER.info("category names" + cat);
				 if (Validator.isNotNull(cat) || !cat.isEmpty())
				 {
				 	 search.setCategories(true);
				 }
				 
				 search.setDescription(doc.get(Field.DESCRIPTION));
				 search.setModDate(doc.get(Field.MODIFIED_DATE));
			 
				 search.setExtension(doc.get("extension"));
				 //Code for finding download link.
			 
				 try 
				 {
				
				 	DLFileEntry dlFile;
					long documentId =  Long.parseLong(doc.get(Field.ENTRY_CLASS_PK));
					
					dlFile = DLFileEntryLocalServiceUtil.getDLFileEntry(documentId);
					
					String downLink = AssetLibraryConstant.DOWNLOAD_PATH + dlFile.getGroupId() + StringPool.SLASH + dlFile.getUuid();
					
					String createdDate = DateFormatFactoryUtil.getSimpleDateFormat("dd MMM yyyy", themeDisplay.getLocale()).format(dlFile.getCreateDate());
					
					//Added create date as Most recently added.
					search.setRecentAddDate(dlFile.getCreateDate());
					//Added modified date
					search.setCreatedDate(createdDate);
					search.setDocumentId(documentId);
					search.setDownloadLink(downLink);
				}
				catch (PortalException e) 
				{
					LOGGER.error(e.getMessage(), e);
				} 
				catch (SystemException e) 
				{
					LOGGER.error(e.getMessage(), e);
				}
				searchList.add(search);

			}
		return searchList;
	}
	
	/**
	 * Send mail for sharing the Asset library search content.
	 * @param resourceRequest Resource request object.
	 * @param toAddresses Email address to be send.
	 * @param contentTitle Title of the document search content.
	 * @param contentLink Download link of the document search content.
	 * @param isCCAddress If any other Email address in CC.
	 * @throws AddressException Address exception in case the email address not found.
	 */
	public static void sendMail (ResourceRequest resourceRequest, String[] toAddresses, String contentTitle, String contentLink, boolean isCCAddress) throws AddressException 
	{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String from = GetterUtil.getString(PropsUtil.get("ihg.from.email.address"));
		String cc = GetterUtil.getString(PropsUtil.get(themeDisplay.getUser().getEmailAddress()));
		
		GenericMail mailMessage = new GenericMail();
		mailMessage.setFrom(from);
		mailMessage.setTo(toAddresses);
		if (isCCAddress)
		{
			mailMessage.setCC(cc);
		}
		mailMessage.setSubject(contentTitle);
		mailMessage.setBody(contentLink);
		mailMessage.sendEmail();
	}

	/**
	 * Returns sort parameter for search results.
	 * @param sort Sorting search result.
	 * @return Sort object.
	 */
	private static Sort getSortParam(int sort)
	{
		Sort sortParam = null;
		if (sort == 2)
		{
			sortParam = SortFactoryUtil.create(ApplicationConstants.SEARCH_TITLE, false);
		}
		else if (sort == SORT)
		{
			sortParam = SortFactoryUtil.create(ApplicationConstants.SEARCH_TITLE, true);
		}
		else if (sort == 1)
		{
			sortParam = SortFactoryUtil.create(ApplicationConstants.SEARCH_LAST_MODIFIED_DATE, false);
		}
		return sortParam;	
	}
}
