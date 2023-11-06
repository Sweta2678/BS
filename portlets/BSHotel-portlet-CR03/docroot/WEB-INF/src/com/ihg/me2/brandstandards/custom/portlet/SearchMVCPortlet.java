/**
 * ©2016 IHG. All rights reserved.
 */
package com.ihg.me2.brandstandards.custom.portlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpSession;

import com.ihg.brandstandards.db.model.FlagCategory;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.StandardsLocale;
import com.ihg.brandstandards.db.model.UserPreference;
import com.ihg.brandstandards.db.service.BrandArticleLocalServiceUtil;
import com.ihg.brandstandards.db.service.FlagCategoryLocalServiceUtil;
import com.ihg.brandstandards.db.service.JobQueueLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublicationLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocaleLocalServiceUtil;
import com.ihg.brandstandards.db.service.UserPreferenceLocalServiceUtil;
import com.ihg.brandstandards.util.BSLanguageUtil;
import com.ihg.me2.brandstandards.custom.application.DownloadManual;
import com.ihg.me2.brandstandards.custom.application.UserPreferencesApplication;
import com.ihg.me2.brandstandards.custom.pojo.AccessAndPreferences;
import com.ihg.me2.brandstandards.custom.pojo.StandardsSearchCriteria;
import com.ihg.me2.brandstandards.custom.util.ApplicationUtil;
import com.ihg.me2.brandstandards.custom.util.BrandStandardsConstant;
import com.ihg.me2.brandstandards.custom.util.BrandStandardsUtil;
import com.ihg.me2.brandstandards.custom.util.QueryUtils;
import com.ihg.me2.brandstandards.custom.util.WCOQueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * <a href="SearchMVCPortlet.java.html"><b><i>View Source</i></b></a>.
 * 
 * Project: Brand Standards
 * 
 * @author Lakshminarayana Mummanedi
 */
public class SearchMVCPortlet extends BrandStandardsPortlet {
	
	protected static final String CONSTANT_Y = "Y";
	protected static final String DISPLAY_OPTIONS = "displayOptions";
	protected static final String SEARCH_CRITERIA = "searchCriteria";
	protected static final String WHAT_CHANGED_CRITERIA = "whatChangedCriteria";
	protected static final String STANDARD_IDS_OF_SEARCH = "standardIdsOfSearch";
	protected static final String ERROR = "Error";
	protected static final String INACTIVE = "Inactive";
	protected static final String PDF_SELECTED_LANG_CODE = "pdfSelectedLangCode";
	protected static final String NO_SEARCH_ACTIVE_MSG = "noSearchActiveMsg";
	protected static final String SEARCH_RESULTS_MSG = "searchResultsMsg";
	protected static final String SHOW_NO_SEARCH_ACTIVE_MSG = "showNoSearchActiveMsg";
	protected static final String SHOW_SEARCH_RESULTS_MSG = "showSearchResultsMsg";
	protected static final String LETTER_SELECTED = "letterSelected";
	protected static final String SELECTED = "selected";
	protected static final String A4_SELECTED = "a4Selected";
	protected static final String SHOW_SEARCH_OPTIONS = "showSearchOptions";
	protected static final String ENVIRONMENT = "environmentVal";
	protected static final String SEARCH_STANDARDS = "SearchStandards";
	protected static final String WCO = "WCO";
	
	private static final Log LOG = LogFactoryUtil.getLog(SearchMVCPortlet.class);
	
	/**
     * This method will process the logic of serveResource for both Summary & Progress Portlets.
     * @param resourceRequest
     * @param resourceResponse
     * @param publish
     * @param regionCd
     * @param rgnId
     * @throws PortletException
     * @throws IOException
     */
	protected void processResourceRendering(ResourceRequest resourceRequest, ResourceResponse resourceResponse, AccessAndPreferences accessPrefs,
			String scope, String modalType) {
    	ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String environment = resourceRequest.getPreferences().getValue(ENVIRONMENT, BrandStandardsConstant.ENVIRONMENT_PROD);
        HttpSession session = getHttpSession(getHttpRequest(resourceRequest));
        BSLanguageUtil obsmLanguageUtil = getOBSMLanguageUtil(resourceRequest, accessPrefs.getLangCode(), "OBSM");
        int resultCount = 0;
        if (session.getAttribute("resultCount") != null) {
            resultCount = (Integer) session.getAttribute("resultCount");
        }
        
    	if ("createPDF".equalsIgnoreCase(modalType)) {
    		setCreatePDFLabels(resourceRequest, obsmLanguageUtil);
    		openCreatePDFPopup(resourceRequest, resourceResponse, environment, accessPrefs, session, obsmLanguageUtil, resultCount, scope);
        } else if ("generatePDF".equalsIgnoreCase(modalType)) {
            generatePDF(resourceRequest, resourceResponse, environment, scope, obsmLanguageUtil);
        } else if ("viewSearch".equalsIgnoreCase(modalType)) {
        	setSearchOptionsPopupLabels(resourceRequest, obsmLanguageUtil,accessPrefs.getLangCode());
        	getViewSearch(resourceRequest, resourceResponse, environment, accessPrefs, obsmLanguageUtil, scope);
        } else if ("viewHelp".equalsIgnoreCase(modalType)) {
            getViewHelp(resourceRequest, resourceResponse, themeDisplay, accessPrefs, obsmLanguageUtil);
        } 
    }
    
    protected void openCreatePDFPopup(ResourceRequest resourceRequest, ResourceResponse resourceResponse, String environment,
            AccessAndPreferences accessPrefs, HttpSession session, BSLanguageUtil obsmLanguageUtil, int resultCount, String scope) {
        try {
        	resourceRequest.setAttribute("scope", scope);
            setCreatePDFLabels(resourceRequest, obsmLanguageUtil);
            StandardsSearchCriteria criteria = null;
            if (session.getAttribute(SEARCH_CRITERIA) != null) {
                criteria = (StandardsSearchCriteria) session.getAttribute(SEARCH_CRITERIA);
            }
            List<StandardsLocale> pdfLangs = new ArrayList<StandardsLocale>();
            if(WCO.equals(scope)) {
            	pdfLangs.add(StandardsLocaleLocalServiceUtil.getStandardsLocale(accessPrefs.getLangCode()));
            } else {
            	pdfLangs.addAll(new UserPreferencesApplication().getLanguagesPerBrandCountry(accessPrefs.getChain(), accessPrefs.getCountry(), environment));
            }
            resourceRequest.setAttribute("pdfLangs", pdfLangs);
            resourceRequest.setAttribute(A4_SELECTED, SELECTED);
            resourceRequest.setAttribute(LETTER_SELECTED, "");
            //Setting user selected pdfLanguage in request to auto select the PDF language in create PDF screen - Start
            resourceRequest.setAttribute(PDF_SELECTED_LANG_CODE, accessPrefs.getPdfLangCode());

            if (accessPrefs.getPaperSize() != null && !(accessPrefs.getPaperSize().isEmpty())) {
                if (BrandStandardsConstant.PAPER_SIZE_A4.equalsIgnoreCase(accessPrefs.getPaperSize())) {
                    resourceRequest.setAttribute(A4_SELECTED, SELECTED);
                    resourceRequest.setAttribute(LETTER_SELECTED, "");
                } else if (BrandStandardsConstant.PAPRE_SIZE_LETTER.equalsIgnoreCase(accessPrefs.getPaperSize())) {
                    resourceRequest.setAttribute(A4_SELECTED, "");
                    resourceRequest.setAttribute(LETTER_SELECTED, SELECTED);
                }
            } else {
                String userRegion = BrandStandardsUtil.getRegionByConuntryCode(accessPrefs.getCountry());
                if (BrandStandardsUtil.REGION_AMER.equalsIgnoreCase(userRegion)) {
                    resourceRequest.setAttribute(A4_SELECTED, "");
                    resourceRequest.setAttribute(LETTER_SELECTED, SELECTED);
                } else {
                    resourceRequest.setAttribute(A4_SELECTED, SELECTED);
                    resourceRequest.setAttribute(LETTER_SELECTED, "");
                }
            }
            if (criteria != null) {
                resourceRequest.setAttribute(SHOW_SEARCH_RESULTS_MSG, true);
                resourceRequest.setAttribute(SEARCH_RESULTS_MSG,
                        BrandStandardsUtil.getSearchResultMessage(criteria, accessPrefs.getLangCode(), resultCount, obsmLanguageUtil));
            } else {
                resourceRequest.setAttribute(SHOW_NO_SEARCH_ACTIVE_MSG, true);
                resourceRequest.setAttribute(NO_SEARCH_ACTIVE_MSG, obsmLanguageUtil.get("bs.search.result.nosearchactive.msg"));
            }
            include("/html/browse/createPDF.jsp", resourceRequest, resourceResponse);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }
    
    /**
     * This method will generate a Manual PDF request by adding an entry to JOB_QUEUE table with necessary metadata.
     * 
     * @param portletRequest This is a PortletRequest object
     * @param environment This is String object
     * @throws IOException It throws IOException
     * @throws PortletException It throws PortletException
     * @return String
     */
    protected void generatePDF(PortletRequest portletRequest, ResourceResponse resourceResponse, String environment, String scope, BSLanguageUtil obsmLanguageUtil) {
        String returnMSG = "";
        Map<String, String> metadataParams = new LinkedHashMap<String, String>();
        Map<String, String> compareMetadataParams = new LinkedHashMap<String, String>();
        Map<String, String> searchFields = new LinkedHashMap<String, String>();
        Map<String, String> compareSearchFields = new LinkedHashMap<String, String>();
        ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
        HttpSession session = getHttpSession(portletRequest);
        
        if(SEARCH_STANDARDS.equals(scope) && session.getAttribute(STANDARD_IDS_OF_SEARCH) == null) {
            LOG.error("No Search Standard Ids found from session->"+session.getAttribute(STANDARD_IDS_OF_SEARCH));
            returnMSG = INACTIVE;
        } 
        else if(WCO.equals(scope) && session.getAttribute(WHAT_CHANGED_CRITERIA) == null) {
        	LOG.error("No WCO Search Criteria found in session->"+session.getAttribute(WHAT_CHANGED_CRITERIA));
            returnMSG = INACTIVE;
        }
        else {
	        try {
	            AccessAndPreferences accessPreferences = getUserPreferences(portletRequest);
	            String pdfLanguage = ParamUtil.getString(portletRequest, "pdfLanguage");
	            String pdfPaper = ParamUtil.getString(portletRequest, "pdfPaper");
	            String isSelfAudit = ParamUtil.getString(portletRequest, "isSelfAudit");
	            
	            addMetadataFields(environment, themeDisplay.getUser().getFirstName(), accessPreferences, pdfLanguage, pdfPaper,
	            		isSelfAudit, metadataParams, compareMetadataParams);
	            StandardsSearchCriteria criteria = null;
	            if (SEARCH_STANDARDS.equals(scope) && session.getAttribute(SEARCH_CRITERIA) != null) {
	                criteria = (StandardsSearchCriteria) session.getAttribute(SEARCH_CRITERIA);
	            } else if(WCO.equals(scope) && session.getAttribute(WHAT_CHANGED_CRITERIA) != null) {
	            	criteria = (StandardsSearchCriteria) session.getAttribute(WHAT_CHANGED_CRITERIA);
	            }
	
	            if (criteria != null) {
	                addMetadataSearchFields(environment, accessPreferences, pdfLanguage, criteria, searchFields, compareSearchFields, obsmLanguageUtil, scope);
	                if(SEARCH_STANDARDS.equals(scope)) {
	                	searchFields.put(BrandStandardsConstant.METADATA_PARAM_SEARCH_STANDARD_IDS, (String) session.getAttribute(STANDARD_IDS_OF_SEARCH));
	                	compareSearchFields.put(BrandStandardsConstant.METADATA_PARAM_SEARCH_STANDARD_IDS, "%");
	                } else {
	                	String newOrUpdateQuery = null;
	                	String removeQuery = null;
	                	String allIndexQuery = null;
	                	String selPublishId = (String)session.getAttribute("selPublishId");
	                	String prevPublishId = (String)session.getAttribute("prevPublishId");
	                	
	                	
	                	if ((criteria.isFilterByNew() || criteria.isFilterByTextUpdate() || criteria.isFilterByComplianceUpdate() || criteria.isFilterByLifecycleUpdate()) 
	                			&& selPublishId != null && !"-1".equalsIgnoreCase(selPublishId)){
		                	if (BrandStandardsConstant.ENVIRONMENT_PROD.equalsIgnoreCase(environment)) {
		                        newOrUpdateQuery = WCOQueryUtil.getWCOSearchQueryProd(pdfLanguage, accessPreferences.getChain(), accessPreferences.getCountry(), criteria, selPublishId, prevPublishId);
		                        allIndexQuery = WCOQueryUtil.getWCOAllIndexQueryProd(selPublishId, prevPublishId);
		                    } else {
		                        newOrUpdateQuery = WCOQueryUtil.getWCOSearchQueryStage(pdfLanguage, accessPreferences.getChain(), accessPreferences.getCountry(), criteria, selPublishId, prevPublishId);
		                        allIndexQuery = WCOQueryUtil.getWCOAllIndexQueryStage(selPublishId, prevPublishId);
		                    }
	                	}
	                	
	                	if (prevPublishId != null && !"-1".equalsIgnoreCase(prevPublishId)){
		                    if (BrandStandardsConstant.ENVIRONMENT_PROD.equalsIgnoreCase(environment)) {
		                        removeQuery = WCOQueryUtil.getWCORemovedSearchQueryProd(pdfLanguage, accessPreferences.getChain(), accessPreferences.getCountry(), criteria, selPublishId, prevPublishId);
		                        if(Validator.isNull(allIndexQuery)){
		                        	allIndexQuery = WCOQueryUtil.getWCOAllIndexQueryProd(selPublishId, prevPublishId);
		                        }
		                    } else {
		                        removeQuery = WCOQueryUtil.getWCORemovedSearchQueryStage(pdfLanguage, accessPreferences.getChain(), accessPreferences.getCountry(), criteria, selPublishId, prevPublishId);
		                        if(Validator.isNull(allIndexQuery)){
		                        	allIndexQuery = WCOQueryUtil.getWCOAllIndexQueryStage(selPublishId, prevPublishId);
		                        }
		                    }
	                	}
	                	metadataParams.put(BrandStandardsConstant.METADATA_PARAM_SEL_PUBLISH_ID, selPublishId);
	                	metadataParams.put(BrandStandardsConstant.METADATA_PARAM_PREV_PUBLISH_ID, prevPublishId);
	                	compareMetadataParams.put(BrandStandardsConstant.METADATA_PARAM_SEL_PUBLISH_ID, selPublishId);
	                	compareMetadataParams.put(BrandStandardsConstant.METADATA_PARAM_PREV_PUBLISH_ID, prevPublishId);
	                	String selPubDtStr = "";
                		String prevPubDtStr = "";
                		try{
	                		Publication selectedPublish = null;
	                		Publication previousPublish = null;
	                		if(Validator.isNotNull(selPublishId) && Long.parseLong(selPublishId) > 0){
	                			selectedPublish = PublicationLocalServiceUtil.getPublication(Long.parseLong(selPublishId));
	                		}
	                		if(Validator.isNotNull(prevPublishId) && Long.parseLong(prevPublishId) > 0){
	                			previousPublish = PublicationLocalServiceUtil.getPublication(Long.parseLong(prevPublishId));
	                		}
	                		if(selectedPublish != null){
	                			selPubDtStr = BrandStandardsUtil.getFormatedDate(selectedPublish.getPublishDate(), pdfLanguage, obsmLanguageUtil);
	                		}
	                		if(selectedPublish != null){
	                			prevPubDtStr = BrandStandardsUtil.getFormatedDate(previousPublish.getPublishDate(), pdfLanguage, obsmLanguageUtil);
	                			String previousPublishDateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(previousPublish.getPublishDate());
	                            metadataParams.put(BrandStandardsConstant.METADATA_PARAM_PREV_PUBLISH_DATE, previousPublishDateStr);
	                            compareMetadataParams.put(BrandStandardsConstant.METADATA_PARAM_PREV_PUBLISH_DATE, "%");
	                		}
	                	} catch(Exception e){}
	                	metadataParams.put(BrandStandardsConstant.METADATA_PARAM_VALIDITY_TXT, obsmLanguageUtil.get("bs.valid")+" "+prevPubDtStr+" - "+selPubDtStr);
                		compareMetadataParams.put(BrandStandardsConstant.METADATA_PARAM_VALIDITY_TXT, "%");
                		
                		searchFields.put(BrandStandardsConstant.METADATA_PARAM_WCO_NEW_UPDATED_QUERY, newOrUpdateQuery);
	                	compareSearchFields.put(BrandStandardsConstant.METADATA_PARAM_WCO_NEW_UPDATED_QUERY, "%");
	                	searchFields.put(BrandStandardsConstant.METADATA_PARAM_WCO_REMOVED_QUERY, removeQuery);
	                	compareSearchFields.put(BrandStandardsConstant.METADATA_PARAM_WCO_REMOVED_QUERY, "%");
	                	searchFields.put(BrandStandardsConstant.METADATA_PARAM_WCO_ALL_INDEX_QUERY, allIndexQuery);
	                	compareSearchFields.put(BrandStandardsConstant.METADATA_PARAM_WCO_ALL_INDEX_QUERY, "%");
                		
                		if(Validator.isNotNull(newOrUpdateQuery)){
                			searchFields.put(BrandStandardsConstant.METADATA_PARAM_WCO_NEW_UPDATED_BASE64_QUERY, Base64.encode(newOrUpdateQuery.getBytes(StringPool.UTF8)));
                			compareSearchFields.put(BrandStandardsConstant.METADATA_PARAM_WCO_NEW_UPDATED_BASE64_QUERY, "%");
                		}
                		if(Validator.isNotNull(removeQuery)){
                			searchFields.put(BrandStandardsConstant.METADATA_PARAM_WCO_REMOVED_BASE64_QUERY, Base64.encode(removeQuery.getBytes(StringPool.UTF8)));
                			compareSearchFields.put(BrandStandardsConstant.METADATA_PARAM_WCO_REMOVED_BASE64_QUERY, "%");
                		}
	                	if(Validator.isNotNull(allIndexQuery)){
                			searchFields.put(BrandStandardsConstant.METADATA_PARAM_WCO_ALL_INDEX_BASE64_QUERY, Base64.encode(allIndexQuery.getBytes(StringPool.UTF8)));
                			compareSearchFields.put(BrandStandardsConstant.METADATA_PARAM_WCO_ALL_INDEX_BASE64_QUERY, "%");
	                	}
	                }
	                
	            }
	            String metaData = null;
            	String compareMetaData = null;
	            if(SEARCH_STANDARDS.equals(scope)) {
		            metaData = BrandStandardsUtil.buildJobQueueMetadataXML(BrandStandardsConstant.JOB_TYPE_MANUAL_PDF,
		                    metadataParams, BrandStandardsConstant.METADATA_PARAM_SEARCH_CRITERIA, searchFields);
		            compareMetaData = BrandStandardsUtil.buildJobQueueMetadataXML(BrandStandardsConstant.JOB_TYPE_MANUAL_PDF,
		                    compareMetadataParams, BrandStandardsConstant.METADATA_PARAM_SEARCH_CRITERIA, compareSearchFields);
		            if (LOG.isDebugEnabled()) {
		                LOG.debug("Extract PDF Actual Metadata:" + metaData);
		                LOG.debug("Extract PDF Compare duplicate query metadata:" + compareMetaData);
		            }
		
		            if (!JobQueueLocalServiceUtil.isJobQueueExistWithSameMetadata(compareMetaData,
		                    themeDisplay.getUser().getScreenName(), BrandStandardsConstant.JOB_TYPE_MANUAL_PDF)) {
		                BrandStandardsUtil.addToJobQueue(BrandStandardsConstant.JOB_TYPE_MANUAL_PDF, metaData, 
		                        themeDisplay.getUser().getScreenName(), themeDisplay.getUser().getEmailAddress());
		            } else {
		                returnMSG = "Exist";
		            }
	            } else {
	            	metaData = BrandStandardsUtil.buildJobQueueMetadataXML(BrandStandardsConstant.JOB_TYPE_WCO_MANUAL_PDF,
		                    metadataParams, BrandStandardsConstant.METADATA_PARAM_SEARCH_CRITERIA, searchFields);
		            compareMetaData = BrandStandardsUtil.buildJobQueueMetadataXML(BrandStandardsConstant.JOB_TYPE_WCO_MANUAL_PDF,
		                    compareMetadataParams, BrandStandardsConstant.METADATA_PARAM_SEARCH_CRITERIA, compareSearchFields);
		            if (LOG.isDebugEnabled()) {
		                LOG.debug("WCO PDF Actual Metadata:" + metaData);
		                LOG.debug("WCO PDF Compare duplicate query metadata:" + compareMetaData);
		            }
		
		            if (!JobQueueLocalServiceUtil.isJobQueueExistWithSameMetadata(compareMetaData,
		                    themeDisplay.getUser().getScreenName(), BrandStandardsConstant.JOB_TYPE_WCO_MANUAL_PDF)) {
		                BrandStandardsUtil.addToJobQueue(BrandStandardsConstant.JOB_TYPE_WCO_MANUAL_PDF, metaData, 
		                        themeDisplay.getUser().getScreenName(), themeDisplay.getUser().getEmailAddress());
		            } else {
		                returnMSG = "Exist";
		            }
	            }
	
	            /** Update User Preferences based on selected language in PDF Popup */
	            try {
	                UserPreference userPreferences = UserPreferenceLocalServiceUtil.getUserPreferencesByUserId(themeDisplay.getUserId(), "OBSM");
	                if (Validator.isNotNull(userPreferences)) {
	                    userPreferences.setPdfLangCode(pdfLanguage);
	                    userPreferences.setPaperSize(pdfPaper);
	                    userPreferences.setUpdatedDate(new Date());
	                    UserPreferenceLocalServiceUtil.updateUserPreference(userPreferences);
	                }
	                /** Update PDFLangCode & PaperSize in AccessAndPreferences object and update in session */
	                accessPreferences.setPdfLangCode(pdfLanguage);
	                accessPreferences.setPaperSize(pdfPaper);
	                session.removeAttribute(USER_PREFERENCES);
	                session.setAttribute(USER_PREFERENCES, accessPreferences);
	            } catch (SystemException e) {
	                returnMSG = ERROR;
	                LOG.error("Failed to update user Preferences from Create PDF Popup", e);
	            }
	        } catch (Exception e) {
	            returnMSG = ERROR;
	            LOG.error("Failed to insert CreatePDF record to Job_Queue", e);
	        }
    	}	
        
        try {
			if ("Exist".equalsIgnoreCase(returnMSG)) {
				resourceResponse.getWriter().write(obsmLanguageUtil.get("bs.createpdf.duplicate.error.msg"));
			} else if (INACTIVE.equalsIgnoreCase(returnMSG)) {
				resourceResponse.getWriter().write(obsmLanguageUtil.get("bs.createpdf.inactive.error.msg"));
			} else if (ERROR.equalsIgnoreCase(returnMSG)) {
				resourceResponse.getWriter().write(obsmLanguageUtil.get("bs.createpdf.fail.error.msg"));
			}
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
		}
    }

    protected void getViewSearch(ResourceRequest resourceRequest, ResourceResponse resourceResponse, String environment,
            AccessAndPreferences accessPrefs, BSLanguageUtil obsmLanguageUtil, String scope) {
        String contentType = "OPERATE";
        try {
            resourceRequest.setAttribute("monthMap", BrandStandardsUtil.getMonthList(obsmLanguageUtil));
            LOG.info(" chain " + accessPrefs.getChain() + " env " + environment + " active  " + BrandStandardsConstant.PUBLISHED_RECORD_STATUS);
            Publication publish = PublicationLocalServiceUtil.getPublishObjectByBrand(accessPrefs.getChain(), environment,
                    BrandStandardsConstant.PUBLISHED_RECORD_STATUS);
            if(publish != null) {
            	 contentType = publish.getPublishContentType();
            } else {
            	LOG.error("Null pointer thrown by Publish object");
            }
            resourceRequest.setAttribute("contentType", contentType);
            if("WCO".equals(scope)){
            	include("/html/whatChangedOn/searchOptions.jsp", resourceRequest, resourceResponse);
            } else {
            	include("/html/browse/search.jsp", resourceRequest, resourceResponse);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }

    protected void getViewHelp(ResourceRequest resourceRequest, ResourceResponse resourceResponse, ThemeDisplay themeDisplay,
            AccessAndPreferences accessPrefs, BSLanguageUtil obsmLanguageUtil) {
        try {
            DownloadManual manual = ApplicationUtil.getDownloadManualObject();
            long categoryId = manual.getAssetCategoryId(themeDisplay.getScopeGroupId(), accessPrefs.getLangCode(), false);
            
            if (LOG.isDebugEnabled()) {
                LOG.debug("category ID :" + categoryId);
            }
            if (categoryId != 0l) {
                @SuppressWarnings("rawtypes")
				List articles = BrandArticleLocalServiceUtil.getJournalArticleResourcPrimKey(QueryUtils.getArticle(
                        BrandStandardsConstant.SEARCH_STANDARD_HELP_CONTENT, categoryId, 0l));
                if (articles != null && articles.size() > 0) {
                    resourceRequest.setAttribute("resourcePrimaryKey", ((BigDecimal) articles.get(0)).longValue());
                }
            }
            resourceRequest.setAttribute("helpCancel", obsmLanguageUtil.get("bs.cancel"));
            resourceRequest.setAttribute("helpClose", obsmLanguageUtil.get("bs.close"));
            include("/html/browse/help.jsp", resourceRequest, resourceResponse);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
    }
    
    /**
     * This method will generate a map with metadata fields based on the search criteria selection.
     * 
     * @param environment Environment where the request is generated.
     * @param userName User First Name
     * @param accessPreferences User Preferences object
     * @param pdfLanguage Language of PDF Manual request
     * @param pdfPaper Paper size of PDF Manual request
     * @param metadataParams map to store metadata fields information
     * @param compareMetaData map to store metadata fields information for comparing the duplicate request
     */
    protected void addMetadataFields(String environment, String userName, AccessAndPreferences accessPreferences,
            String pdfLanguage, String pdfPaper, String isSelfAudit, Map<String, String> metadataParams, Map<String, String> compareMetaData) {
        Publication publish = PublicationLocalServiceUtil.getPublishObjectByBrand(accessPreferences.getChain(), environment,
                BrandStandardsConstant.PUBLISHED_RECORD_STATUS);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        metadataParams.put(BrandStandardsConstant.METADATA_PARAM_ENVIRONMENT, environment);
        metadataParams.put(BrandStandardsConstant.METADATA_PARAM_PUBLISH_ID, String.valueOf(publish.getPublishId()));
        metadataParams.put(BrandStandardsConstant.METADATA_PARAM_CHAIN_CD, accessPreferences.getChain());
        metadataParams.put(BrandStandardsConstant.METADATA_PARAM_COUNTRY_CD, accessPreferences.getCountry());
        metadataParams.put(BrandStandardsConstant.METADATA_PARAM_COUNTRY_DESC, accessPreferences.getCountryName());
        metadataParams.put(BrandStandardsConstant.METADATA_PARAM_USER_PREF_LOCALE_CD, accessPreferences.getLangCode());
        metadataParams.put(BrandStandardsConstant.METADATA_PARAM_SECOND_LOCALE_CD, pdfLanguage);
        metadataParams.put(BrandStandardsConstant.METADATA_PARAM_LOCALE_LIST, pdfLanguage);
        metadataParams.put(BrandStandardsConstant.METADATA_PARAM_PAGE_ORIENTATION, 
                (BrandStandardsConstant.METADATA_PARAM_DEF_LANG .equalsIgnoreCase(pdfLanguage) ? 
                        BrandStandardsConstant.PAGE_ORIENTATION_PORTRAIT : BrandStandardsConstant.PAGE_ORIENTATION_LANDSCAPE));
        metadataParams.put(BrandStandardsConstant.METADATA_PARAM_PAGE_SIZE, pdfPaper);
        metadataParams.put(BrandStandardsConstant.METADATA_PARAM_USER_NAME, userName);
        metadataParams.put(BrandStandardsConstant.METADATA_PARAM_BUILD_TYPE, BrandStandardsConstant.OPERATE);
        metadataParams.put(BrandStandardsConstant.METADATA_PARAM_PUBLISH_CONTENT_TYPE, publish.getPublishContentType());
        metadataParams.put(BrandStandardsConstant.METADATA_PARAM_IS_SELF_AUDIT_PDF, isSelfAudit);

        if (publish.getPublishDate() != null) {
            String dateStr = dateFormat.format(publish.getPublishDate());
            metadataParams.put(BrandStandardsConstant.METADATA_PARAM_PUBLISH_DATE, dateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(publish.getPublishDate());
            calendar.add(Calendar.YEAR, 1);
            dateStr = dateFormat.format(calendar.getTime());
            metadataParams.put(BrandStandardsConstant.METADATA_PARAM_EXPIRATION_DATE, dateStr);
        }

        compareMetaData.put(BrandStandardsConstant.METADATA_PARAM_ENVIRONMENT, environment);
        compareMetaData.put(BrandStandardsConstant.METADATA_PARAM_PUBLISH_ID, String.valueOf(publish.getPublishId()));
        compareMetaData.put(BrandStandardsConstant.METADATA_PARAM_CHAIN_CD, accessPreferences.getChain());
        compareMetaData.put(BrandStandardsConstant.METADATA_PARAM_COUNTRY_CD, accessPreferences.getCountry());
        compareMetaData.put(BrandStandardsConstant.METADATA_PARAM_COUNTRY_DESC, "%");
        compareMetaData.put(BrandStandardsConstant.METADATA_PARAM_USER_PREF_LOCALE_CD, "%");
        compareMetaData.put(BrandStandardsConstant.METADATA_PARAM_SECOND_LOCALE_CD, pdfLanguage);
        compareMetaData.put(BrandStandardsConstant.METADATA_PARAM_LOCALE_LIST, pdfLanguage);
        compareMetaData.put(BrandStandardsConstant.METADATA_PARAM_PAGE_ORIENTATION, 
                (BrandStandardsConstant.METADATA_PARAM_DEF_LANG.equalsIgnoreCase(pdfLanguage) ? 
                        BrandStandardsConstant.PAGE_ORIENTATION_PORTRAIT : BrandStandardsConstant.PAGE_ORIENTATION_LANDSCAPE));
        compareMetaData.put(BrandStandardsConstant.METADATA_PARAM_PAGE_SIZE, pdfPaper);
        compareMetaData.put(BrandStandardsConstant.METADATA_PARAM_USER_NAME, "%");
        compareMetaData.put(BrandStandardsConstant.METADATA_PARAM_BUILD_TYPE, BrandStandardsConstant.OPERATE);
        compareMetaData.put(BrandStandardsConstant.METADATA_PARAM_PUBLISH_CONTENT_TYPE, publish.getPublishContentType());
        compareMetaData.put(BrandStandardsConstant.METADATA_PARAM_IS_SELF_AUDIT_PDF, isSelfAudit);
        if (publish.getPublishDate() != null) {
            compareMetaData.put(BrandStandardsConstant.METADATA_PARAM_PUBLISH_DATE, "%");
            compareMetaData.put(BrandStandardsConstant.METADATA_PARAM_EXPIRATION_DATE, "%");
        }
    }

    /**
     * This method will generate a map with metadata search fields based on the search criteria selection.
     * 
     * @param environment Environment where the request is generated.
     * @param accessPreferences User Preferences object
     * @param pdfLanguage Language of PDF Manual request
     * @param criteria StandardsSearchCriteria
     * @param searchFields map to store search fields information
     * @throws SystemException throws system exception
     */
    protected void addMetadataSearchFields(String environment, AccessAndPreferences accessPreferences,
            String pdfLanguage, StandardsSearchCriteria criteria, Map<String, String> searchFields, Map<String, String> compareSearchFields, BSLanguageUtil obsmLanguageUtil, String scope) throws SystemException
    {
        if (criteria.getTextSearch() != null && !criteria.getTextSearch().isEmpty())
        {
            try {
            	String base64SearchTerm = Base64.encode(criteria.getTextSearch().getBytes(StringPool.UTF8));
                searchFields.put(BrandStandardsConstant.SEARCH_OPTION_SEARCH, base64SearchTerm);
            	compareSearchFields.put(BrandStandardsConstant.SEARCH_OPTION_SEARCH, base64SearchTerm);
            } catch(Exception e){
            	LOG.error("Failed to encode OBSM Search term", e);
            }
            
            String searchType = decodeSearchType(criteria.getTextSearchType());
            if (searchType != null && !searchType.isEmpty())
            {
                searchFields.put(BrandStandardsConstant.SEARCH_OPTION_SEARCH_TYPE, searchType);
                compareSearchFields.put(BrandStandardsConstant.SEARCH_OPTION_SEARCH_TYPE, searchType);
            }
        }

        //Added hotel lifecycle and specialism  for CR 50.2
        List<String> lifecycle = criteria.getHotelLifecycleForDisplay();
        if (lifecycle != null && !lifecycle.isEmpty())
        {
            searchFields.put(BrandStandardsConstant.SEARCH_OPTION_HOTEL_LIFECYCLE, lifecycle.toString().replace("[", "").replace("]", ""));
            compareSearchFields.put(BrandStandardsConstant.SEARCH_OPTION_HOTEL_LIFECYCLE, lifecycle.toString().replace("[", "").replace("]", ""));
        }
        
        if (criteria.getSpecialism() != null && !criteria.getSpecialism().isEmpty())
        {
            searchFields.put(BrandStandardsConstant.SEARCH_OPTION_SPECIALISM, criteria.getSpecialism().toString().replace("[", "").replace("]", ""));
            compareSearchFields.put(BrandStandardsConstant.SEARCH_OPTION_SPECIALISM, criteria.getSpecialism().toString().replace("[", "").replace("]", ""));
        }
        //End
        
        if (criteria.getDeptApplicability() != null && !criteria.getDeptApplicability().isEmpty())
        {
            searchFields.put(BrandStandardsConstant.SEARCH_OPTION_DEPARTMENT, criteria.getDeptApplicability().toString().replace("[", "").replace("]", ""));
            compareSearchFields.put(BrandStandardsConstant.SEARCH_OPTION_DEPARTMENT, criteria.getDeptApplicability().toString().replace("[", "").replace("]", ""));
        }

        if (criteria.getLocHotel() != null && !criteria.getLocHotel().isEmpty())
        {
            searchFields.put(BrandStandardsConstant.SEARCH_OPTION_LOCATION, criteria.getLocHotel().toString().replace("[", "").replace("]", ""));
            compareSearchFields.put(BrandStandardsConstant.SEARCH_OPTION_LOCATION, criteria.getLocHotel().toString().replace("[", "").replace("]", ""));
        }

        if (criteria.getGuestJourney() != null && !criteria.getGuestJourney().isEmpty())
        {
            searchFields.put(BrandStandardsConstant.SEARCH_OPTION_GUEST_JOURNEY, criteria.getGuestJourney().toString().replace("[", "").replace("]", ""));
            compareSearchFields.put(BrandStandardsConstant.SEARCH_OPTION_GUEST_JOURNEY, criteria.getGuestJourney().toString().replace("[", "").replace("]", ""));
        }

        if (criteria.getComplianceDeadline() != null && !criteria.getComplianceDeadline().isEmpty())
        {
            String complDeadline = decodeComplianceDeadline(criteria);
            searchFields.put(BrandStandardsConstant.SEARCH_OPTION_COMPLIANCE_DEADLINE, complDeadline);
            compareSearchFields.put(BrandStandardsConstant.SEARCH_OPTION_COMPLIANCE_DEADLINE, complDeadline);
        }

        String supMaterials = getSupportingMaterialsList(criteria);
        if (supMaterials != null && !supMaterials.isEmpty())
        {
            searchFields.put(BrandStandardsConstant.SEARCH_OPTION_SUPPORTING_MATERIALS, supMaterials);
            compareSearchFields.put(BrandStandardsConstant.SEARCH_OPTION_SUPPORTING_MATERIALS, supMaterials);
        }
        
        String changeTypes = getChangeTypes(criteria);
		if (changeTypes != null && !changeTypes.isEmpty() && WCO.equals(scope))
        {
			searchFields.put(BrandStandardsConstant.SEARCH_OPTION_CHANGE_TYPE, changeTypes);
            compareSearchFields.put(BrandStandardsConstant.SEARCH_OPTION_CHANGE_TYPE, changeTypes);
        }
    }

    /**
     * @param searchType This is a String object
     * @return String
     */
    protected String decodeSearchType(String searchType) {
        String decodedSearchType = searchType;
        if ("all".equals(searchType)) {
            decodedSearchType = "bs.search.type.all.words";//"Search All Words";
        } else if ("exact".equals(searchType)) {
            decodedSearchType = "bs.search.type.match.exact";//"Match Exact Phrase";
        } else if ("any".equals(searchType)) {
            decodedSearchType = "bs.search.type.match.any";//"Match Any of the Words";
        }
        return decodedSearchType;
    }

    /**
     * @param criteria This is a StandardSearchCriteria object
     * @return String
     */
    protected String decodeComplianceDeadline(StandardsSearchCriteria criteria) {
        String complDeadline = criteria.getComplianceDeadline();
        if ("0d".equals(complDeadline)) {
            complDeadline = "bs.search.now";//BrandStandardsConstant.SEARCH_OPTION_VAL_NOW;
        } else if ("7d".equals(complDeadline)) {
            complDeadline = "bs.search.next.seven.days";//BrandStandardsConstant.SEARCH_OPTION_VAL_7_DAYS;
        } else if ("1m".equals(complDeadline)) {
            complDeadline = "bs.search.next.month";//BrandStandardsConstant.SEARCH_OPTION_VAL_NEXT_MONTH;
        } else if ("3m".equals(complDeadline)) {
            complDeadline = "bs.search.next.quarter";//BrandStandardsConstant.SEARCH_OPTION_VAL_NEXT_QUARTER;
        } else if ("6m".equals(complDeadline)) {
            complDeadline = "bs.search.next.six.months";//BrandStandardsConstant.SEARCH_OPTION_VAL_NEXT_6_MON;
        } else if ("12m".equals(complDeadline)) {
            complDeadline = "bs.search.next.twelve.months";//BrandStandardsConstant.SEARCH_OPTION_VAL_NEXT_12_MON;
        } else if ("12m+d".equals(complDeadline)) {
            complDeadline = "bs.search.beyond.twelve.months";//BrandStandardsConstant.SEARCH_OPTION_VAL_BEYOND_12_MON;
        }
        return complDeadline;
    }

    /**
     * @param criteria The StandardsSearchCriteria object
     * @return return a String object
     */
    protected String getSupportingMaterialsList(StandardsSearchCriteria criteria) {
        StringBuilder supMaterials = new StringBuilder();

        if (criteria.isHasAttachments()) {
            supMaterials.append("bs.search.has.attachments");
        }
        if (criteria.isHasImages()) {
        	if (supMaterials.length() > 0) {
                supMaterials.append(", ");
            }
            supMaterials.append("bs.search.has.images");
        }
        if (criteria.isHasLinks()) {
            if (supMaterials.length() > 0) {
                supMaterials.append(", ");
            }
            supMaterials.append("bs.search.has.links");
        }
        if (criteria.isHasTrainingMaterial()) {
            if (supMaterials.length() > 0) {
                supMaterials.append(", ");
            }
            supMaterials.append("bs.search.has.training.material");
        }
        if (criteria.isHasSOP()) {
            if (supMaterials.length() > 0) {
                supMaterials.append(", ");
            }
            supMaterials.append("bs.search.has.sop");
        }
        return supMaterials.toString();
    }
    
    /**
     * @param criteria The StandardsSearchCriteria object
     * @return return a String object
     */
    protected String getChangeTypes(StandardsSearchCriteria criteria) {
        StringBuilder changeTypes = new StringBuilder();

        if (criteria.isFilterByNew()) {
            changeTypes.append("bs.search.new");
        }
        if (criteria.isFilterByTextUpdate()) {
        	if (changeTypes.length() > 0) {
                changeTypes.append(", ");
            }
            changeTypes.append("bs.text.update");
        }
        if (criteria.isFilterByComplianceUpdate()) {
            if (changeTypes.length() > 0) {
                changeTypes.append(", ");
            }
            changeTypes.append("bs.compliance.update");
        }
        if (criteria.isFilterByLifecycleUpdate()) {
            if (changeTypes.length() > 0) {
                changeTypes.append(", ");
            }
            changeTypes.append("bs.lifecycle.update");
        }
        if (criteria.isFilterByRemoved()) {
            if (changeTypes.length() > 0) {
                changeTypes.append(", ");
            }
            changeTypes.append("bs.search.removed");
        }
        return changeTypes.toString();
    }

    /**
     * This method will set the UI labels in request based on the Locale.
     * 
     * @param portletRequest This is a PortletRequest object
     * @param locale This is a Locale object
     */
    protected void setCreatePDFLabels(PortletRequest portletRequest, BSLanguageUtil obsmLanguageUtil) {
        portletRequest.setAttribute("yourPDFLabel", obsmLanguageUtil.get("bs.createpdf.yourpdf"));
        portletRequest.setAttribute("onLabel", obsmLanguageUtil.get("bs.on"));
        portletRequest.setAttribute("paperLabel", obsmLanguageUtil.get("bs.paper"));
        portletRequest.setAttribute("emailNoteLabel", obsmLanguageUtil.get("bs.createpdf.emailnote"));
        portletRequest.setAttribute("availableNoteLabel", obsmLanguageUtil.get("bs.createpdf.availablenote"));
        portletRequest.setAttribute("closeLabel", obsmLanguageUtil.get("bs.close"));
        portletRequest.setAttribute("generatepdfLabel", obsmLanguageUtil.get("bs.generatepdf"));
        portletRequest.setAttribute("generateSelfAuditPdfLabel", obsmLanguageUtil.get("bs.generate.selfaudit.pdf", "Generate Self Audit PDF"));
        portletRequest.setAttribute("letterLabel", obsmLanguageUtil.get("bs.letter"));
        portletRequest.setAttribute("createPDFLabel", obsmLanguageUtil.get("bs.createpdf"));
    }

    /**
     * This method will set the What Changed On UI labels based on the language selections.
     * 
     * @param request PortletRequest Object
     * @param bsLocale Locale Object
     */
    protected void setSearchScreenLabels(PortletRequest request, BSLanguageUtil obsmLanguageUtil, String langCode, String scope) {
    	
    	request.setAttribute("searchOptions", obsmLanguageUtil.get("bs.search.options"));
        request.setAttribute("clearSearch", obsmLanguageUtil.get("bs.clear"));
        request.setAttribute("searchStandards", obsmLanguageUtil.get("bs.search.standards"));
        request.setAttribute("itemsPerPage", obsmLanguageUtil.get("bs.search.items.per.page"));
        request.setAttribute("page", obsmLanguageUtil.get("bs.search.page"));
        request.setAttribute("ofLabel", obsmLanguageUtil.get("bs.search.of"));
        request.setAttribute("first", obsmLanguageUtil.get("bs.search.first"));
        request.setAttribute("previous", obsmLanguageUtil.get("bs.search.previous"));
        request.setAttribute("next", obsmLanguageUtil.get("bs.search.next"));
        request.setAttribute("last", obsmLanguageUtil.get("bs.search.last"));
        request.setAttribute("hideDisplayButton", obsmLanguageUtil.get("bs.search.hide.display.options"));
        request.setAttribute("showDisplayButton", obsmLanguageUtil.get("bs.search.show.display.options"));
        request.setAttribute("DisplayOptions", obsmLanguageUtil.get("bs.search.display.options"));
        request.setAttribute("showFutureCompliance", obsmLanguageUtil.get("bs.search.show.future.compliance.deadlines"));
        request.setAttribute("showSearchHighlight", obsmLanguageUtil.get("bs.search.show.search.highlight"));
        request.setAttribute("showHotelLifeCycle", obsmLanguageUtil.get("bs.search.show.hotelLifeCycle")); 
        request.setAttribute("showSearchHelp", obsmLanguageUtil.get("bs.help"));
        request.setAttribute("searchStandardsHelp", obsmLanguageUtil.get("bs.help.on.search.standards"));
        request.setAttribute("cancelButton", obsmLanguageUtil.get("bs.cancel"));
        request.setAttribute("guidelines", obsmLanguageUtil.get("bs.search.guidelines"));
        request.setAttribute("newLabel", obsmLanguageUtil.get("bs.search.new"));
        request.setAttribute("update", obsmLanguageUtil.get("bs.search.update"));
        request.setAttribute("createPDFLabel", obsmLanguageUtil.get("bs.createpdf"));
        request.setAttribute("expiresTxt", obsmLanguageUtil.get("bs.pdf.expires"));
        
        
        
        if("WCO".equals(scope)) {
	    	/**WCO page specific UI Labels */
        	request.setAttribute("showPreviousText", obsmLanguageUtil.get("bs.show.previous.text"));
	        request.setAttribute("showChange", obsmLanguageUtil.get("bs.show.change"));
	        request.setAttribute("closeChange", obsmLanguageUtil.get("bs.close.change"));
	        request.setAttribute("validText", obsmLanguageUtil.get("bs.valid"));
	        request.setAttribute("publicationText", obsmLanguageUtil.get("bs.publication"));
	        request.setAttribute("changed", obsmLanguageUtil.get("bs.search.changed"));
	        request.setAttribute("filterByRemoved", obsmLanguageUtil.get("bs.search.removed"));
	        request.setAttribute("iconLegendHeading", obsmLanguageUtil.get("bs.icon.legend.heading"));
	        request.setAttribute("textUpdate", obsmLanguageUtil.get("bs.text.update"));
	        request.setAttribute("complianceUpdate", obsmLanguageUtil.get("bs.compliance.update"));
	        request.setAttribute("lifecycleUpdate", obsmLanguageUtil.get("bs.lifecycle.update"));
	        request.setAttribute("removedUpdate", obsmLanguageUtil.get("bs.removed.update"));
        } else {
        	/**Search Standards page specific UI Labels */
        	request.setAttribute("showWhatsNew", obsmLanguageUtil.get("bs.search.show.whats.new"));
        	request.setAttribute("images", obsmLanguageUtil.get("bs.search.images"));
            request.setAttribute("searchTerm", obsmLanguageUtil.get("bs.search.searchfield.note"));
            request.setAttribute("compDeadlineLabel", obsmLanguageUtil.get("bs.search.result.compliancedeadline"));
            request.setAttribute("compDeadlineToLabel", obsmLanguageUtil.get("bs.search.result.compliancedeadline.setto"));
            //Beyond 12 months message
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, +12);
            Date complianceDate = calendar.getTime();
            String complianceDateVal = BrandStandardsUtil.getFormatedDate(complianceDate, langCode, obsmLanguageUtil);
            request.setAttribute("comDeadlineBeyond", obsmLanguageUtil.format("bs.search.result.compliancedeadline.setbeyond", new Object[] { complianceDateVal }));
            request.setAttribute("compDeadlineAndLabel", obsmLanguageUtil.get("bs.and"));
        }
    }

    /**
     * This method will set the What Changed On Search Options UI labels based on the language selections.
     * 
     * @param request PortletRequest Object
     * @param bsLocale Locale Object
     */
    protected void setSearchOptionsPopupLabels(PortletRequest request, BSLanguageUtil obsmLanguageUtil,String localeCode)
    {
        request.setAttribute("searchOptions", obsmLanguageUtil.get("bs.search.options"));
        request.setAttribute("search", obsmLanguageUtil.get("bs.search"));
        request.setAttribute("searchAllWords", obsmLanguageUtil.get("bs.search.type.all.words"));
        request.setAttribute("matchExactPhrase", obsmLanguageUtil.get("bs.search.type.match.exact"));
        request.setAttribute("matchAnyWords", obsmLanguageUtil.get("bs.search.type.match.any"));
        request.setAttribute("searchAllWordsHelp", obsmLanguageUtil.get("bs.search.type.all.words.help"));
        request.setAttribute("matchExactPhraseHelp", obsmLanguageUtil.get("bs.search.type.match.exact.help"));
        request.setAttribute("matchAnyWordsHelp", obsmLanguageUtil.get("bs.search.type.match.any.help"));
        request.setAttribute("goButton", obsmLanguageUtil.get("bs.go"));
        request.setAttribute("clearSearch", obsmLanguageUtil.get("bs.clear"));
        request.setAttribute("cancelButton", obsmLanguageUtil.get("bs.cancel"));
        request.setAttribute("filtersApply", obsmLanguageUtil.get("bs.filters.apply"));
        request.setAttribute("check", obsmLanguageUtil.get("bs.check"));
        request.setAttribute("searchAll", obsmLanguageUtil.get("bs.all"));
        request.setAttribute("searchNone", obsmLanguageUtil.get("bs.none"));
        request.setAttribute("searchNote", obsmLanguageUtil.get("bs.search.note"));
        request.setAttribute("byHotelLifeCycle", obsmLanguageUtil.get("bs.search.by.hotel.lifecycle"));
        request.setAttribute("byHotelLifeCycleComing", obsmLanguageUtil.get("bs.search.by.hotel.lifecycle.coming"));
        request.setAttribute("bySpecialism", obsmLanguageUtil.get("bs.search.by.specialism"));
        request.setAttribute("bySpecialismComing", obsmLanguageUtil.get("bs.search.by.specialism.coming"));
        request.setAttribute("byHotelDepartment", obsmLanguageUtil.get("bs.search.by.hotel.department"));
        request.setAttribute("byHotelLocation", obsmLanguageUtil.get("bs.search.by.hotel.location"));
        request.setAttribute("byGuestJourney", obsmLanguageUtil.get("bs.search.by.guest.journey"));
        request.setAttribute("byComplianceDeadline", obsmLanguageUtil.get("bs.search.by.compliance.deadline"));
        request.setAttribute("bySupportingMaterial", obsmLanguageUtil.get("bs.search.by.supporting.material"));
        request.setAttribute("searchFilterBy", obsmLanguageUtil.get("bs.search.by.change.type"));
        
        request.setAttribute("byHotelLifeCycleNote", obsmLanguageUtil.get("bs.search.by.hotel.lifecycle.note"));
        request.setAttribute("bySpecialismNote", obsmLanguageUtil.get("bs.search.by.specialism.note"));
        request.setAttribute("hotelDepartmentNote", obsmLanguageUtil.get("bs.search.by.hotel.department.note"));
        request.setAttribute("hotelLocationNote", obsmLanguageUtil.get("bs.search.by.hotel.location.note"));
        request.setAttribute("guestJourneyNote", obsmLanguageUtil.get("bs.search.by.guest.journey.note"));
        request.setAttribute("complianceDeadlineNote", obsmLanguageUtil.get("bs.search.by.compliance.deadline.note"));
        request.setAttribute("supportingMaterialNote", obsmLanguageUtil.get("bs.search.by.supporting.material.note"));
        request.setAttribute("byChangeTypeNote", obsmLanguageUtil.get("bs.search.by.changetype.note"));
        
        request.setAttribute("searchNow", obsmLanguageUtil.get("bs.search.now"));
        request.setAttribute("nextSevenDays", obsmLanguageUtil.get("bs.search.next.seven.days"));
        request.setAttribute("clearSearch", obsmLanguageUtil.get("bs.clear"));
        request.setAttribute("nextMonth", obsmLanguageUtil.get("bs.search.next.month"));
        request.setAttribute("nextQuarter", obsmLanguageUtil.get("bs.search.next.quarter"));
        request.setAttribute("nextSixMonths", obsmLanguageUtil.get("bs.search.next.six.months"));
        request.setAttribute("beyond12Months", obsmLanguageUtil.get("bs.search.beyond.twelve.months"));
        request.setAttribute("next12Months", obsmLanguageUtil.get("bs.search.next.twelve.months"));
        
        request.setAttribute("hasAttachments", obsmLanguageUtil.get("bs.search.has.attachments"));
        request.setAttribute("hasLinks", obsmLanguageUtil.get("bs.search.has.links"));
        request.setAttribute("hasImages", obsmLanguageUtil.get("bs.search.has.images"));
        request.setAttribute("hasTM", obsmLanguageUtil.get("bs.search.has.training.material"));
        request.setAttribute("hasSOP", obsmLanguageUtil.get("bs.search.has.sop"));
        request.setAttribute("compDeadlineLabel", obsmLanguageUtil.get("bs.search.result.compliancedeadline"));
        request.setAttribute("compDeadlineToLabel", obsmLanguageUtil.get("bs.search.result.compliancedeadline.setto"));
        //Beyond 12 months message
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, +12);
        Date complianceDate = calendar.getTime();
        String complianceDateVal = BrandStandardsUtil.getFormatedDate(complianceDate, localeCode, obsmLanguageUtil);
        request.setAttribute("comDeadlineBeyond", obsmLanguageUtil.format("bs.search.result.compliancedeadline.setbeyond", new Object[] { complianceDateVal }));
        request.setAttribute("compDeadlineAndLabel", obsmLanguageUtil.get("bs.and"));
        
        request.setAttribute("filtersLabel", obsmLanguageUtil.get("bs.filters"));
        request.setAttribute("filterLabel", obsmLanguageUtil.get("bs.filter"));
        request.setAttribute("filterApply", obsmLanguageUtil.get("bs.filter.apply"));
        request.setAttribute("dayDateLabel", obsmLanguageUtil.get("bs.constant.day"));
        request.setAttribute("monthDateLabel", obsmLanguageUtil.get("bs.constant.month"));
        request.setAttribute("yearDateLabel", obsmLanguageUtil.get("bs.constant.year"));
        
        request.setAttribute("searchStandardsHelp", obsmLanguageUtil.get("bs.help.on.search.standards"));
        request.setAttribute("searchTerm", obsmLanguageUtil.get("bs.search.searchfield.note"));
        request.setAttribute("filterByNew", obsmLanguageUtil.get("bs.search.new"));
        request.setAttribute("filterByUpdated", obsmLanguageUtil.get("bs.search.updated"));
        request.setAttribute("filterByRemoved", obsmLanguageUtil.get("bs.search.removed"));
        request.setAttribute("filterByTextUpdate", obsmLanguageUtil.get("bs.search.text.update"));
        request.setAttribute("filterByComplianceUpdate", obsmLanguageUtil.get("bs.search.compliance.update"));
        request.setAttribute("filterByLifecycleUpdate", obsmLanguageUtil.get("bs.search.lifecycle.update"));
        request.setAttribute("textUpdate", obsmLanguageUtil.get("bs.text.update"));
        request.setAttribute("complianceUpdate", obsmLanguageUtil.get("bs.compliance.update"));
        request.setAttribute("lifecycleUpdate", obsmLanguageUtil.get("bs.lifecycle.update"));
        request.setAttribute("bssAbbreviation", obsmLanguageUtil.get("bs.bss.abbreviation"));
        setFlagCategoryUILabels(request, obsmLanguageUtil);
    }

    /**
     * This method will set the Search Options Hotel Life Cycle(91), Specialism(30, 92, 93), Hotel Department(1), Hotel Location(25) and Guest Journey(20) Flag Category UI labels based on the language selections
     * @param request
     * @param obsmLanguageUtil
     */
    protected void setFlagCategoryUILabels(PortletRequest request, BSLanguageUtil obsmLanguageUtil) {
    	List<FlagCategory> flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoriesForParentIds("1, 20, 25, 30, 91, 92, 93, 500");
    	if(flagCategories != null && flagCategories.size() > 0) {
	    	for(FlagCategory flag : flagCategories) {
	            request.setAttribute(String.valueOf(flag.getFlagCatId()), obsmLanguageUtil.get("bs.flag."+flag.getFlagCatId()));
	            if(flag.getParentCatId() == 91) {
		            request.setAttribute(BrandStandardsConstant.HOTEL_LIFECYCLE_FLAG_DESC+String.valueOf(flag.getFlagCatId()), obsmLanguageUtil.get("bs.flag." + String.valueOf(flag.getFlagCatId())+".desc"));
		            request.setAttribute(BrandStandardsConstant.HOTEL_LIFECYCLE_FLAG_ABBR+String.valueOf(flag.getFlagCatId()), obsmLanguageUtil.get("bs.flag." + String.valueOf(flag.getFlagCatId())+".abbreviation"));
	            }
	        }
    	}
    	
    	request.setAttribute("SPECIALISM_FLAGS", FlagCategoryLocalServiceUtil.getFlagCategories(QueryUtils.getSpecialismCategoriesQuery()));
    }
    
}
