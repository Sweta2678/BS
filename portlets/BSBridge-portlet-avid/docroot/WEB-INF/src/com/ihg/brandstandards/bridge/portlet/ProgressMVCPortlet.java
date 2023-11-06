/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.brandstandards.bridge.portlet;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.poi.ss.usermodel.Workbook;

import com.ihg.brandstandards.bridge.application.BridgeApplication;
import com.ihg.brandstandards.bridge.application.impl.BridgeApplicationImpl;
import com.ihg.brandstandards.bridge.util.BrandStandardsUtil;
import com.ihg.brandstandards.bridge.util.BridgeCommonUtil;
import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.bridge.util.ProgressPortletUtil;
import com.ihg.brandstandards.custom.model.Standard;
import com.ihg.brandstandards.db.model.BridgePublishLang;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.service.BridgePublishLangLocalServiceUtil;
import com.ihg.brandstandards.db.service.BridgePublishLocalServiceUtil;
import com.ihg.brandstandards.db.service.ErrNotificationLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublicationLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocaleLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.ihg.brandstandards.util.BSCommonConstants;
import com.ihg.brandstandards.util.BSLanguageUtil;
import com.ihg.brandstandards.util.QueryUtils;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * <a href="ProgressMVCPortlet.java.html"><b><i>View Source</i></b></a>.
 * 
 * @project: Brand Standards Bridge.
 * @author MUMMANL
 */
public class ProgressMVCPortlet extends BrandStandardsBridgePortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(ProgressMVCPortlet.class);

    @SuppressWarnings("unchecked")
	protected void setViewDetails(PortletRequest portletRequest, SearchContainer<Standard> searchContainer, Publication publish, 
    		String viewType, String localeCode, String regionCode, long regionId, int pageNumber) {
    	PortletSession portletSession = portletRequest.getPortletSession();
    	List<Standard> viewDetailsStandards = null;
        String statusIndText = "";
        boolean translationExecOverrideChecked = false;
        if(publish != null && publish.getValidateTranslation() != null && publish.getValidateTranslation().equals("Y")){
        	translationExecOverrideChecked = true;
        }
        if ("DiscontinuedView".equals(viewType))
        {
            statusIndText = BridgeConstants.STAT_IND_DISCONTINUED;
            portletRequest.setAttribute("overallProgressSection", BridgeConstants.STAT_IND_DISCONTINUED);
            portletRequest.setAttribute("indicatorStyle", "label-important");
        } 
        else if ("UnattributeBrndView".equals(viewType))
        {
            statusIndText = BridgeConstants.STAT_IND_UNATTRIBUTE_BRAND;
            portletRequest.setAttribute("overallProgressSection", BridgeConstants.STAT_IND_UNATTRIBUTE_BRAND);
            portletRequest.setAttribute("indicatorStyle", "label-important");
        } 
        else if ("UnattributeRgnView".equals(viewType))
        {
            statusIndText = BridgeConstants.STAT_IND_UNATTRIBUTE_REGION;
            portletRequest.setAttribute("overallProgressSection", BridgeConstants.STAT_IND_UNATTRIBUTE_REGION);
            portletRequest.setAttribute("indicatorStyle", "label-important");
        }
        else if ("GlobalMustView".equals(viewType))
        {
            statusIndText = BridgeConstants.STAT_IND_GLBL_MUST;
            portletRequest.setAttribute("overallProgressSection", BridgeConstants.STAT_IND_GLBL_MUST);
            portletRequest.setAttribute("indicatorStyle", "label-important");
        }
        else if ("GlobalNotInMustView".equals(viewType))
        {
            statusIndText = BridgeConstants.STAT_IND_GLBL_NOT_IN_MUST;
            portletRequest.setAttribute("overallProgressSection", BridgeConstants.STAT_IND_GLBL_NOT_IN_MUST);
            portletRequest.setAttribute("indicatorStyle", "label-important");
        }
        else if ("GlobalMustNotView".equals(viewType))
        {
            statusIndText = BridgeConstants.STAT_IND_GLBL_MUST_NOT;
            portletRequest.setAttribute("overallProgressSection", BridgeConstants.STAT_IND_GLBL_MUST_NOT);
            portletRequest.setAttribute("indicatorStyle", "label-important");
        }
        else if ("SelectStateView".equals(viewType))
        {
            statusIndText = BridgeConstants.STAT_IND_SELECT_STATE;
            portletRequest.setAttribute("overallProgressSection", BridgeConstants.STAT_IND_SELECT_STATE);
            portletRequest.setAttribute("indicatorStyle", "label-important");
        } 
        else if ("OverriddenView".equals(viewType))
        {
            statusIndText = BridgeConstants.STAT_IND_OVERRIDDEN;
            portletRequest.setAttribute("overallProgressSection", BridgeConstants.STAT_IND_OVERRIDDEN);
            portletRequest.setAttribute("indicatorStyle", "badge-warning");
        }
        else if ("MissingXrefView".equals(viewType))
        {
            statusIndText = BridgeConstants.STAT_IND_MISS_XREF;
            portletRequest.setAttribute("overallProgressSection", BridgeConstants.STAT_IND_MISS_XREF);
            portletRequest.setAttribute("indicatorStyle", "label-warning");
        }
        else if ("ExpiredView".equals(viewType))
        {
            statusIndText = BridgeConstants.STAT_IND_EXPIRED_DATE;
            portletRequest.setAttribute("overallProgressSection", BridgeConstants.STAT_IND_EXPIRED_DATE);
            portletRequest.setAttribute("indicatorStyle", "label-important");
        }
        else if ("ComplianceView".equals(viewType))
        {
            statusIndText = BridgeConstants.STAT_IND_COMPLIANCE_DATE;
            portletRequest.setAttribute("overallProgressSection", BridgeConstants.STAT_IND_COMPLIANCE_DATE);
            portletRequest.setAttribute("indicatorStyle", "label-important");
        }
        else if ("NotificationView".equals(viewType))
        {
            statusIndText = BridgeConstants.STAT_IND_NOFITICATION;
            portletRequest.setAttribute("overallProgressSection", BridgeConstants.STAT_IND_NOFITICATION);
            portletRequest.setAttribute("indicatorStyle", "label-important");
        }
        else if ("IndexTranslationView".equals(viewType))
        {
            statusIndText = BridgeConstants.STAT_IND_MISS_TRANS_INDEX;
            portletRequest.setAttribute("overallProgressSection", BridgeConstants.STAT_IND_MISS_TRANS_INDEX);
            if(translationExecOverrideChecked) {
	            portletRequest.setAttribute("indicatorStyle", "label-warning");
	        } else {
	        	portletRequest.setAttribute("indicatorStyle", "label-important");
	        }
        }
        else if ("ContentTranslationView".equals(viewType))
        {
            statusIndText = BridgeConstants.STAT_IND_MISS_TRANS_CONTENT;
            portletRequest.setAttribute("overallProgressSection", BridgeConstants.STAT_IND_MISS_TRANS_CONTENT);
            if(translationExecOverrideChecked) {
	            portletRequest.setAttribute("indicatorStyle", "label-warning");
	        } else {
	        	portletRequest.setAttribute("indicatorStyle", "label-important");
	        }
        }
        else if("AttachmentTranslationView".equals(viewType)){
        	statusIndText = BridgeConstants.STAT_IND_MISS_TRANS_ATTACH;
            portletRequest.setAttribute("overallProgressSection", BridgeConstants.STAT_IND_MISS_TRANS_ATTACH);
            if(translationExecOverrideChecked) {
	            portletRequest.setAttribute("indicatorStyle", "label-warning");
	        } else {
	        	portletRequest.setAttribute("indicatorStyle", "label-important");
	        }
        }
        else if("LinkTranslationView".equals(viewType)){
        	statusIndText = BridgeConstants.STAT_IND_MISS_TRANS_LINKS;
            portletRequest.setAttribute("overallProgressSection", BridgeConstants.STAT_IND_MISS_TRANS_LINKS);
            if(translationExecOverrideChecked) {
	            portletRequest.setAttribute("indicatorStyle", "label-warning");
	        } else {
	        	portletRequest.setAttribute("indicatorStyle", "label-important");
	        }
        }
        else if("ImageTranslationView".equals(viewType)){
        	statusIndText = BridgeConstants.STAT_IND_MISS_TRANS_IMAGES;
            portletRequest.setAttribute("overallProgressSection", BridgeConstants.STAT_IND_MISS_TRANS_IMAGES);
            if(translationExecOverrideChecked) {
	            portletRequest.setAttribute("indicatorStyle", "label-warning");
	        } else {
	        	portletRequest.setAttribute("indicatorStyle", "label-important");
	        }
        }
        Map<String, String> activeSecondLanguages = getRegionActiveSecondLanguages(regionCode);
        if (localeCode != null && activeSecondLanguages != null && activeSecondLanguages.get(localeCode) != null)
        {
        	portletRequest.setAttribute("translationLocale", activeSecondLanguages.get(localeCode));
        }
        
        int curPage = portletRequest.getParameter(SearchContainer.DEFAULT_CUR_PARAM) == null ? pageNumber : Integer.parseInt(portletRequest.getParameter(SearchContainer.DEFAULT_CUR_PARAM));
        if (curPage <= 1)
        {
            BridgeApplication bridgeApp = new BridgeApplicationImpl();
            viewDetailsStandards = bridgeApp.getStandardsForProgressViewDetails(publish, regionId, viewType, localeCode, statusIndText);
            portletSession.setAttribute(viewType+"DetailStandards", viewDetailsStandards);
        }
        else if(portletSession.getAttribute(viewType+"DetailStandards") != null)
        {
            viewDetailsStandards = (List<Standard>) portletSession.getAttribute(viewType+"DetailStandards");
        }
        
        if (viewDetailsStandards == null)
        {
            viewDetailsStandards = new ArrayList<Standard>();
            portletRequest.setAttribute("showExportButton", "NO");
        } 
        
        if (viewDetailsStandards == null || viewDetailsStandards.size() <= 0)
        {
            portletRequest.setAttribute("showExportButton", "NO");
        } 
        else 
        {
        	portletRequest.setAttribute("showExportButton", "YES");
        }
        
        setResultsToSearchContainer(portletRequest, viewDetailsStandards, searchContainer, regionCode, pageNumber);
        
    }
    
    /**
     * Set records on Details page.
     * 
     * @param renderRequest request
     * @param portletSession session
     * @param viewDetailsStandards List of records
     * @param searchContainer pagination container
     * @param regionCode Region
     * @param pageNum page number
     */
    protected void setResultsToSearchContainer(PortletRequest portletRequest, List<Standard> viewDetailsStandards, SearchContainer<Standard> searchContainer, 
    		String regionCode, int pageNumber)
    {
        searchContainer.setTotal(viewDetailsStandards.size());
        List<Standard> viewDetailDisplayList = ListUtil.subList(viewDetailsStandards, searchContainer.getStart(),
                searchContainer.getEnd());
        searchContainer.setResults(viewDetailDisplayList);
        searchContainer.setEmptyResultsMessage("No Standards Available");
        portletRequest.setAttribute("searchContainer", searchContainer);

        portletRequest.setAttribute("selectedRegion", regionCode);
        //portletRequest.setAttribute("viewDetailDisplayList", viewDetailDisplayList);
        portletRequest.setAttribute("curPageNum",
        		portletRequest.getParameter(SearchContainer.DEFAULT_CUR_PARAM) == null ? String.valueOf(pageNumber) : 
        			portletRequest.getParameter(SearchContainer.DEFAULT_CUR_PARAM));
    }
    
    /**
     * Fetch Translation and Overall Status from database.
     * 
     * @param resourceRequest request
     * @param publish Publication
     * @param regionCd region code
     * @param rgnId region id
     * @return Map<String, String> selectedTranslations
     * @throws PortletException
     */
    protected void getRegionalProgressStatus(ResourceRequest resourceRequest, Publication publish, String regionCd, long rgnId) 
            throws PortletException
    {
    	setOverallProgressCounts(resourceRequest, publish, rgnId);
    	setComplianceProgressCounts(resourceRequest, publish, rgnId);
    	setNotificationProgressCounts(resourceRequest, publish, rgnId);
    	setIndexTranslationCounts(resourceRequest, publish, rgnId);
    	setContentTranslationCounts(resourceRequest, publish, rgnId);
    	setSupportDocsTranslationCounts(resourceRequest, publish, rgnId);
    	setLinkTranslationCounts(resourceRequest, publish, rgnId);
    	setImageTranslationCounts(resourceRequest, publish, rgnId);
    }
    
    /**
     * This method will fetch Overall Progress Items Count.
     * 
     * @param portletRequest request
     * @param publish Publication
     * @param regionCd region code
     * @param rgnId region id
     * @return Map<String, String> selectedTranslations
     * @throws PortletException
     */
    protected Map<String, Long> setOverallProgressCounts(PortletRequest portletRequest, Publication publish, long rgnId)
    {
        long noOfDiscontinuedIds = -1;
        long noOfUnattrBrandIds = -1;
        long noOfUnattrRegionIds = -1;
        long noOfOverrideStdIds = -1;
        long noOfGlblMustIds = -1;
        long noOfGlblNotInMustIds = -1;
        long noOfGlblMustNotIds = -1;
        long noOfSelectStateIds = -1;
        long noOfMissingXrefIds = -1;
        Map<String, Long> overAllProgress = new HashMap<String, Long>();
        
        if (publish != null)
        {
            try
            {
                overAllProgress = BridgePublishLocalServiceUtil.getBridgeProgress(publish.getPublishId(), publish.getChainCode(), 
                        publish.getPublishDate(), rgnId, rgnId == 1 ? true : false, BridgeConstants.PROGRESS_TYPE_OVERALL);
            }
            catch (Exception e)
            {
                LOG.error("Overall Progress count exception", e);
            }
        }

        if (overAllProgress != null && !overAllProgress.isEmpty())
        {
            if (overAllProgress.get(BridgeConstants.COUNT_DISCONTINUED) != null)
            {
                noOfDiscontinuedIds = overAllProgress.get(BridgeConstants.COUNT_DISCONTINUED);
            }
            if (overAllProgress.get(BridgeConstants.COUNT_UNATTRIBUTE_BRND) != null)
            {
                noOfUnattrBrandIds = overAllProgress.get(BridgeConstants.COUNT_UNATTRIBUTE_BRND);
            }
            if (overAllProgress.get(BridgeConstants.COUNT_UNATTRIBUTE_RGN) != null)
            {
            	noOfUnattrRegionIds = overAllProgress.get(BridgeConstants.COUNT_UNATTRIBUTE_RGN);
            }
            if (overAllProgress.get(BridgeConstants.COUNT_OVERRIDDEN) != null)
            {
                noOfOverrideStdIds = overAllProgress.get(BridgeConstants.COUNT_OVERRIDDEN);
            }
            if (overAllProgress.get(BridgeConstants.COUNT_GLBL_MUST) != null)
            {
            	noOfGlblMustIds = overAllProgress.get(BridgeConstants.COUNT_GLBL_MUST);
            }
            if (overAllProgress.get(BridgeConstants.COUNT_GLBL_NOT_IN_MUST) != null)
            {
            	noOfGlblNotInMustIds = overAllProgress.get(BridgeConstants.COUNT_GLBL_NOT_IN_MUST);
            }
            if (overAllProgress.get(BridgeConstants.COUNT_GLBL_MUST_NOT) != null)
            {
                noOfGlblMustNotIds = overAllProgress.get(BridgeConstants.COUNT_GLBL_MUST_NOT);
            }
            if (overAllProgress.get(BridgeConstants.COUNT_SELECT_STATE) != null)
            {
            	noOfSelectStateIds = overAllProgress.get(BridgeConstants.COUNT_SELECT_STATE);
            }
            if (overAllProgress.get(BridgeConstants.COUNT_MISS_XREF) != null)
            {
            	noOfMissingXrefIds = overAllProgress.get(BridgeConstants.COUNT_MISS_XREF);
            }
        }

        portletRequest.setAttribute(BridgeConstants.COUNT_DISCONTINUED, noOfDiscontinuedIds);
        portletRequest.setAttribute(BridgeConstants.COUNT_UNATTRIBUTE_BRND, noOfUnattrBrandIds);
        portletRequest.setAttribute(BridgeConstants.COUNT_UNATTRIBUTE_RGN, noOfUnattrRegionIds);
        portletRequest.setAttribute(BridgeConstants.COUNT_OVERRIDDEN, noOfOverrideStdIds);
        portletRequest.setAttribute(BridgeConstants.COUNT_GLBL_MUST, noOfGlblMustIds);
        portletRequest.setAttribute(BridgeConstants.COUNT_GLBL_NOT_IN_MUST, noOfGlblNotInMustIds);
        portletRequest.setAttribute(BridgeConstants.COUNT_GLBL_MUST_NOT, noOfGlblMustNotIds);
        portletRequest.setAttribute(BridgeConstants.COUNT_SELECT_STATE, noOfSelectStateIds);
        portletRequest.setAttribute(BridgeConstants.COUNT_MISS_XREF, noOfMissingXrefIds);
        return overAllProgress;
    }

    /**
     * This method will fetch Compliance Progress Items Count.
     * 
     * @param portletRequest request
     * @param publish Publication
     * @param regionCd region code
     * @param rgnId region id
     * @return Map<String, String> selectedTranslations
     * @throws PortletException
     */
    protected Map<String, Long> setComplianceProgressCounts(PortletRequest portletRequest, Publication publish, long rgnId)
    {
        long noOfExpiredIds = -1;
        long noOfCompliantIds = -1;
        Map<String, Long> progress = new HashMap<String, Long>();
        
        if (publish != null)
        {
            try
            {
                progress = BridgePublishLocalServiceUtil.getBridgeProgress(publish.getPublishId(), publish.getChainCode(), 
                        publish.getPublishDate(), rgnId, rgnId == 1 ? true : false, BridgeConstants.PROGRESS_TYPE_COMPLIANCE);
            }
            catch (SystemException e)
            {
                LOG.error("Overall Progress count exception", e);
            }
       }

        if (progress != null && !progress.isEmpty())
        {
            if (progress.get(BridgeConstants.COUNT_EXPIRED) != null)
            {
                noOfExpiredIds = progress.get(BridgeConstants.COUNT_EXPIRED);
            }
            if (progress.get(BridgeConstants.COUNT_COMPLIANT) != null)
            {
                noOfCompliantIds = progress.get(BridgeConstants.COUNT_COMPLIANT);
            }
        }

        portletRequest.setAttribute(BridgeConstants.COUNT_EXPIRED, noOfExpiredIds);
        portletRequest.setAttribute(BridgeConstants.COUNT_COMPLIANT, noOfCompliantIds);
        return progress;
    }
    
    /**
     * This method will fetch Notification Progress Items Count.
     * 
     * @param portletRequest request
     * @param publish Publication
     * @param regionCd region code
     * @param rgnId region id
     * @return Map<String, String> selectedTranslations
     * @throws PortletException
     */
    protected Map<String, Long> setNotificationProgressCounts(PortletRequest portletRequest, Publication publish, long rgnId)
    {
        long noOfNotifications = -1;
        Map<String, Long> progress = new HashMap<String, Long>();
        
        if (publish != null)
        {
            try
            {
                progress = BridgePublishLocalServiceUtil.getBridgeProgress(publish.getPublishId(), publish.getChainCode(), 
                        publish.getPublishDate(), rgnId, rgnId == 1 ? true : false, BridgeConstants.PROGRESS_TYPE_NOTIFICATIONS);
            }
            catch (SystemException e)
            {
                LOG.error("Overall Progress count exception", e);
            }
       }

        if (progress != null && !progress.isEmpty())
        {
            if (progress.get(BridgeConstants.COUNT_NOTIFICATIONS) != null)
            {
            	noOfNotifications = progress.get(BridgeConstants.COUNT_NOTIFICATIONS);
            }
        }

        portletRequest.setAttribute(BridgeConstants.COUNT_NOTIFICATIONS, noOfNotifications);
        return progress;
    }

    /**
     * This method will fetch Missing Index Translation Count for selected languages.
     * 
     * @param portletRequest request
     * @param publish Publication
     * @param regionCd region code
     * @param rgnId region id
     * @throws PortletException
     */
    protected void setIndexTranslationCounts(PortletRequest portletRequest, Publication publish, long rgnId) 
            throws PortletException
    {
        Map<String, Long> indexTranslationCounts = new LinkedHashMap<String, Long>();
        try
        {
            if (publish != null)
            {
            	indexTranslationCounts = BridgePublishLocalServiceUtil.getBridgeProgress(publish.getPublishId(), publish.getChainCode(), 
                        publish.getPublishDate(), rgnId, rgnId == 1 ? true : false, BridgeConstants.PROGRESS_TYPE_INDEX_TRANS);
            }
        }
        catch (SystemException e)
        {
            LOG.error("Index Translation count exception", e);
        }
        portletRequest.setAttribute("indexTranslationCounts", indexTranslationCounts);
    }

    /**
     * This method will fetch Missing Content Translation Count for selected languages.
     * 
     * @param portletRequest request
     * @param publish Publication
     * @param regionCd region code
     * @param rgnId region id
     * @throws PortletException
     */
    protected void setContentTranslationCounts(PortletRequest portletRequest, Publication publish, long rgnId) 
            throws PortletException
    {
        Map<String, Long> contentTranslationCount = new LinkedHashMap<String, Long>();
        try
        {
            if (publish != null)
            {
            	contentTranslationCount = BridgePublishLocalServiceUtil.getBridgeProgress(publish.getPublishId(), publish.getChainCode(), 
                        publish.getPublishDate(), rgnId, rgnId == 1 ? true : false, BridgeConstants.PROGRESS_TYPE_CONTENT_TRANS);
            }
        }
        catch (SystemException e)
        {
            LOG.error(e);
        }
        portletRequest.setAttribute("contentTranslationCount", contentTranslationCount);
    }
    
    /**
     * This method will fetch Missing Content Translation Count for selected languages.
     * 
     * @param portletRequest request
     * @param publish Publication
     * @param regionCd region code
     * @param rgnId region id
     * @throws PortletException
     */
    protected void setSupportDocsTranslationCounts(PortletRequest portletRequest, Publication publish, long rgnId) 
            throws PortletException
    {
        Map<String, Long> supportDocsTranslationCounts = new LinkedHashMap<String, Long>();
        try
        {
            if (publish != null)
            {
            	supportDocsTranslationCounts = BridgePublishLocalServiceUtil.getBridgeProgress(publish.getPublishId(), publish.getChainCode(), 
                        publish.getPublishDate(), rgnId, rgnId == 1 ? true : false, BridgeConstants.PROGRESS_TYPE_ATTACH_TRANS);
            }
        }
        catch (SystemException e)
        {
            LOG.error(e);
        }
        portletRequest.setAttribute("supportDocsTranslationCounts", supportDocsTranslationCounts);
    }
    
    /**
     * This method will fetch Missing Link Translation Count for selected languages.
     * 
     * @param portletRequest request
     * @param publish Publication
     * @param regionCd region code
     * @param rgnId region id
     * @throws PortletException
     */
    protected void setLinkTranslationCounts(PortletRequest portletRequest, Publication publish, long rgnId) 
            throws PortletException
    {
        Map<String, Long> linkTranslationCounts = new LinkedHashMap<String, Long>();
        try
        {
            if (publish != null)
            {
            	linkTranslationCounts = BridgePublishLocalServiceUtil.getBridgeProgress(publish.getPublishId(), publish.getChainCode(), 
                        publish.getPublishDate(), rgnId, rgnId == 1 ? true : false, BridgeConstants.PROGRESS_TYPE_LINKS_TRANS);
            }
        }
        catch (SystemException e)
        {
            LOG.error(e);
        }
        portletRequest.setAttribute("linkTranslationCounts", linkTranslationCounts);
    }
    
    /**
     * This method will fetch Missing Image Translation Count for selected languages.
     * 
     * @param portletRequest request
     * @param publish Publication
     * @param regionCd region code
     * @param rgnId region id
     * @throws PortletException
     */
    protected void setImageTranslationCounts(PortletRequest portletRequest, Publication publish, long rgnId) 
            throws PortletException
    {
        Map<String, Long> imageTranslationCounts = new LinkedHashMap<String, Long>();
        try
        {
            if (publish != null)
            {
            	imageTranslationCounts = BridgePublishLocalServiceUtil.getBridgeProgress(publish.getPublishId(), publish.getChainCode(), 
                        publish.getPublishDate(), rgnId,
                        rgnId == 1 ? true : false, BridgeConstants.PROGRESS_TYPE_IMAGE_TRANS);
            }
        }
        catch (SystemException e)
        {
            LOG.error(e);
        }
        portletRequest.setAttribute("imageTranslationCounts", imageTranslationCounts);
    }

    
    /**
     * Add/Remove language selection for Publication.
     * 
     * @param resourceRequest request
     * @param themeDisplay themeDisplay
     * @param publish Publication
     * @param regionCd region code
     * @param rgnId region ID
     */
    protected void updatePublicationLanguage(ResourceRequest resourceRequest, ThemeDisplay themeDisplay, Publication publish,
            String regionCd, long rgnId)
    {
        String localeCode = getHttpRequest(resourceRequest).getParameter("localeCode");
        String elementChecked = getHttpRequest(resourceRequest).getParameter("elementChecked");
        if(LOG.isDebugEnabled()){
        	LOG.debug("serviceresource selectedRegion-->" + regionCd + " localeCode=" + localeCode + " --elementChecked=" + elementChecked);
        }
        Map<String, String> selectedBrdgRgnLangs = new LinkedHashMap<String, String>();
        Map<String, String> regionActiveLang = new LinkedHashMap<String, String>();
        try
        {
            BridgePublishLang bridgePublishLang = getBridgePublishLanguage(publish, rgnId, localeCode);
            BridgePublishLang regionalLang = null;
            if (bridgePublishLang == null && "true".equals(elementChecked))
            {
            	addBridgePublishLang(publish,rgnId,localeCode, themeDisplay);
            	if (rgnId != 1)
            	{
            		regionActiveLang = getRegionActiveSecondLanguages(StandardsRegionLocalServiceUtil.fetchStandardsRegion(1).getRegionCode());
        			if(regionActiveLang.get(localeCode)!= null)
        			{
     	               addBridgePublishLang(publish,1,localeCode, themeDisplay);
                 	}
            	}
            	else
            	{
            		for(int rid=2; rid<=5 ; rid++)
            		{
            			regionActiveLang = getRegionActiveSecondLanguages(StandardsRegionLocalServiceUtil.fetchStandardsRegion(rid).getRegionCode());
            			if(regionActiveLang.get(localeCode)!= null)
            			{
         	               addBridgePublishLang(publish,rid,localeCode, themeDisplay);
                     	}
            		}
            	}
            }
            else if (bridgePublishLang != null && "false".equals(elementChecked))
            {
            	if (rgnId == 1)
            	{
            		for(int rid=2; rid<=5 ; rid++)
            		{
            			regionalLang = getBridgePublishLanguage(publish, rid, localeCode);
            			if (regionalLang != null)
            			{
            				BridgePublishLangLocalServiceUtil.deleteBridgePublishLang(regionalLang);
            			}
            		}
            	}
            	else
            	{
            		regionalLang = getBridgePublishLanguage(publish, 1, localeCode);
        			if (regionalLang != null)
        			{
        				BridgePublishLangLocalServiceUtil.deleteBridgePublishLang(regionalLang);
        			}
            	}
                BridgePublishLangLocalServiceUtil.deleteBridgePublishLang(bridgePublishLang);
            }

            clearBridgePublishLangCache();
            List<BridgePublishLang> bridgePublishLangList = BridgePublishLangLocalServiceUtil.getByRegion(publish.getPublishId(), rgnId);
            if (bridgePublishLangList != null && !bridgePublishLangList.isEmpty())
            {
                for (BridgePublishLang lang : bridgePublishLangList)
                {
                	selectedBrdgRgnLangs.put(lang.getLocaleCode(), lang.getLocaleCode());
                }
            }
        }
        catch (Exception e)
        {
            LOG.error(e);
        }
        resourceRequest.setAttribute("selectedBrdgRgnLangs", selectedBrdgRgnLangs);
    }
    
    /**
     * Get Publish language for a Region.
     * 
     * @param publish Publish
     * @param rgnId Region Id
     * @param localeCode locale
     * @return BridgePublishLang or null
     */
    protected BridgePublishLang getBridgePublishLanguage(Publication publish, long rgnId, String localeCode)
    {
        BridgePublishLang bridgePublishLang = null;
        try
        {
            bridgePublishLang = BridgePublishLangLocalServiceUtil.getByRegionAndLocale(publish.getPublishId(), rgnId, localeCode);
        }
        catch (Exception e)
        {
        	 LOG.error(e);
        }
        return bridgePublishLang;
    }

    /**
     * This method will clear BridhePublishLang entity cache.
     */
    protected void clearBridgePublishLangCache()
    {
        try
        {
            BridgePublishLangLocalServiceUtil.clearCache();
        }
        catch (Exception e)
        {
            // Do nothing
        }
    }

    /**
     * Calculate time before Publication to Production environment.
     * 
     * @param renderRequest request
     * @param publish Publish record
     */
    protected void timeBeforePublication(RenderRequest renderRequest, Publication publish)
    {
        if (publish != null && publish.getPublishDate() != null)
        {
            long durationLeft = 0;
            String duration = "Days";
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(publish.getPublishDate());
            calendar.set(Calendar.HOUR, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);

            Map<TimeUnit, Long> timeDiff = BridgeCommonUtil.computeTimeDiff(new Date(), calendar.getTime());
            renderRequest.setAttribute("publicationOverDue", false);
            if (timeDiff.get(TimeUnit.DAYS) > 0)
            {
                durationLeft = timeDiff.get(TimeUnit.DAYS);
                duration = "Days";
            }
            else if (timeDiff.get(TimeUnit.DAYS) < 0)
            {
                renderRequest.setAttribute("publicationOverDue", true);
            }
            else if (timeDiff.get(TimeUnit.HOURS) > 0)
            {
                durationLeft = timeDiff.get(TimeUnit.HOURS);
                duration = "Hours";
            }
            else if (timeDiff.get(TimeUnit.HOURS) < 0)
            {
                renderRequest.setAttribute("publicationOverDue", true);
            }
            else if (timeDiff.get(TimeUnit.MINUTES) > 0)
            {
                durationLeft = timeDiff.get(TimeUnit.MINUTES);
                duration = "Minutes";
            }
            else if (timeDiff.get(TimeUnit.MINUTES) < 0)
            {
                renderRequest.setAttribute("publicationOverDue", true);
            }
            renderRequest.setAttribute("durationLeft", durationLeft);
            renderRequest.setAttribute("duration", duration);
            renderRequest.setAttribute("bridgePublishDate", new SimpleDateFormat("dd MMM yyyy").format(publish.getPublishDate()));
            renderRequest.setAttribute("activePublish", true);
        }
        else
        {
            renderRequest.setAttribute("activePublish", false);
        }
    }

    /**
     * This method will set UI Elements labels in request.
     * 
     * @param request
     * @param brandCode
     */
    protected void setProgressUIElements(PortletRequest request, String brandCode)
    {
    	Map<String, String> chainCodeMap = BrandStandardsUtil.chainCodeMap();
    	if(chainCodeMap != null && Validator.isNotNull(chainCodeMap.get(brandCode))){
    		request.setAttribute("selectedBrand", chainCodeMap.get(brandCode));
    	}  else {
	        if (brandCode != null && !brandCode.isEmpty()) {
	        	BSLanguageUtil obsmLanguageUtil = getOBSMLanguageUtil(request, "en_GB", BSCommonConstants.ELEMENT_MODULE_BRIDGE);
		        request.setAttribute("selectedBrand", obsmLanguageUtil.get("bs.brnd." + brandCode.toLowerCase()));
	        }
    	}
    }

    /**
     * Fetch Active languages for a Region from database.
     * 
     * @param portletRequest request
     * @param publish Publication
     * @param regionCd region code
     * @param rgnId region id
     */
    protected void setActiveLanguages(PortletRequest portletRequest, Publication publish, String regionCd, long rgnId) 
    {
        Map<String, String> activeSecondLanguages = getRegionActiveSecondLanguages(regionCd);
        portletRequest.setAttribute("activeSecondLanguages", activeSecondLanguages.entrySet());
        Map<String, String> selectedBrdgRgnLangs = new LinkedHashMap<String, String>();
        try
        {
            if (publish != null)
            {
                clearBridgePublishLangCache();
                List<BridgePublishLang> bridgePublishLangList = BridgePublishLangLocalServiceUtil.getByRegion(publish.getPublishId(), rgnId);
                if (bridgePublishLangList != null && !bridgePublishLangList.isEmpty())
                {
                    for (BridgePublishLang lang : bridgePublishLangList)
                    {
                    	selectedBrdgRgnLangs.put(lang.getLocaleCode(), lang.getLocaleCode());
                    }
                }
            }
        }
        catch (SystemException e)
        {
            LOG.error(e);
        }
        portletRequest.setAttribute("selectedBrdgRgnLangs", selectedBrdgRgnLangs);
    }
    
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
    @SuppressWarnings("unchecked")
	protected void processResourceRendering(ResourceRequest resourceRequest, ResourceResponse resourceResponse, 
    		Publication publish, String regionCd, long rgnId) throws PortletException, IOException {
		
    	ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
    	PortletSession portletSession = resourceRequest.getPortletSession();
    	String requestType = resourceRequest.getParameter("requestType");
        String updateLanguage = resourceRequest.getParameter("updateLanguage");
        if(LOG.isDebugEnabled()){
        	LOG.debug("serveResource===requestType====>" + requestType +"===updateLanguage====>"+updateLanguage);
        }
        setActiveLanguages(resourceRequest, publish, regionCd, rgnId);
        
        if ("RegionRefreshURL".equals(requestType))
        {
        	if(Validator.isNotNull(updateLanguage)){
        		updatePublicationLanguage(resourceRequest, themeDisplay, publish, regionCd, rgnId);
        		setActiveLanguages(resourceRequest, publish, regionCd, rgnId);
        	}
            getRegionalProgressStatus(resourceRequest, publish, regionCd, rgnId);
            include("/html/progress/region.jsp", resourceRequest, resourceResponse);
        }
        else if ("TranslationExecOverride".equals(requestType)){
        	String returnMsg = "";
        	String elementChecked = getHttpRequest(resourceRequest).getParameter("elementChecked");
            try {
        		if("true".equals(elementChecked)){
        			publish.setValidateTranslation("Y");
                } else {
                	publish.setValidateTranslation("N");
                }
				PublicationLocalServiceUtil.updatePublication(publish);
				returnMsg = "Success";
			} catch (Exception e) {
				returnMsg = "Fail";
				LOG.error("Failed to update TranslationExecOverride to:"+elementChecked, e);
			}
            resourceResponse.getWriter().write(returnMsg);
        }
        else if ("OverallProgress".equals(requestType))
        {
        	setOverallProgressCounts(resourceRequest, publish, rgnId);
            include("/html/progress/progress_overall.jsp", resourceRequest, resourceResponse);
        }
        else if ("ComplianceProgress".equals(requestType))
        {
        	setComplianceProgressCounts(resourceRequest, publish, rgnId);
            include("/html/progress/progress_compliance.jsp", resourceRequest, resourceResponse);
        }
        else if ("NotificationProgress".equals(requestType))
        {
        	setNotificationProgressCounts(resourceRequest, publish, rgnId);
            include("/html/progress/progress_notifications.jsp", resourceRequest, resourceResponse);
        }
        else if ("IndexTranslationProgress".equals(requestType))
        {
        	setIndexTranslationCounts(resourceRequest, publish, rgnId);
            include("/html/progress/progress_index_translation.jsp", resourceRequest, resourceResponse);
        }
        else if ("ContentTranslationProgress".equals(requestType))
        {
            setContentTranslationCounts(resourceRequest, publish, rgnId);
            include("/html/progress/progress_content_translation.jsp", resourceRequest, resourceResponse);
        }
        else if ("SupportDocsTranslationProgress".equals(requestType))
        {
            setSupportDocsTranslationCounts(resourceRequest, publish, rgnId);
            include("/html/progress/progress_attachment_translation.jsp", resourceRequest, resourceResponse);
        }
        else if ("LinksTranslationProgress".equals(requestType))
        {
            setLinkTranslationCounts(resourceRequest, publish, rgnId);
            include("/html/progress/progress_link_translation.jsp", resourceRequest, resourceResponse);
        }
        else if ("ImageTranslationProgress".equals(requestType))
        {
            setImageTranslationCounts(resourceRequest, publish, rgnId);
            include("/html/progress/progress_image_translation.jsp", resourceRequest, resourceResponse);
        }
        else if("ShowImagesPopup".equals(requestType)){
            String imageIds = resourceRequest.getParameter("imageIds");
            resourceRequest.setAttribute("imageIds", imageIds);
        	include("/html/progress/mandatoryImages.jsp", resourceRequest, resourceResponse);
        }
        else if("ExportPopup".equals(requestType)){
        	String reportType = resourceRequest.getParameter("reportType");
        	String reportLocaleCode = resourceRequest.getParameter("reportLocaleCode");
        	//String standardIds = resourceRequest.getParameter("standardIds");
        	resourceRequest.setAttribute("reportType", reportType);
        	resourceRequest.setAttribute("reportLocaleCode", reportLocaleCode);
        	//resourceRequest.setAttribute("standardIds", standardIds);
        	
        	if("IndexTranslationView".equals(reportType)) 
        	{
        		List<Standard> viewDetailsStandards = new ArrayList<Standard>();
        		if(portletSession.getAttribute(reportType+"DetailStandards") != null){
        			viewDetailsStandards = (List<Standard>) portletSession.getAttribute(reportType+"DetailStandards");
        		}
        		final Workbook workbook = ProgressPortletUtil.exportIndexTranslations(reportType, reportLocaleCode, viewDetailsStandards);
        		resourceResponse.setContentType("application/vnd.ms-excel");
        		resourceResponse.addProperty("Content-Disposition", "attachment; filename=Progress_"+publish.getChainCode()+"_"+regionCd+"_"+reportLocaleCode+"_"+reportType+"Details.xls");
        		final OutputStream outputStream = resourceResponse.getPortletOutputStream();
        		workbook.write(outputStream);
        		outputStream.flush();
        		outputStream.close();
        		
        	} 
        	if("NotificationView".equals(reportType)) 
        	{
        		List<Standard> viewDetailsStandards = new ArrayList<Standard>();
        		/*if(portletSession.getAttribute(reportType+"DetailStandards") != null){
        			viewDetailsStandards = (List<Standard>) portletSession.getAttribute(reportType+"DetailStandards");
        		}*/
        		viewDetailsStandards = new BridgeApplicationImpl().getStandardsForProgressViewDetails(publish, rgnId, BridgeConstants.VIEW_TYP_NOFITICATION, null, BridgeConstants.STAT_IND_ALL_NOFITICATION);
        		final Workbook workbook = ProgressPortletUtil.exportNotifications(reportType, viewDetailsStandards);
        		resourceResponse.setContentType("application/vnd.ms-excel");
        		resourceResponse.addProperty("Content-Disposition", "attachment; filename=Progress_"+publish.getChainCode()+"_"+regionCd+"_"+reportType+"Details.xls");
        		final OutputStream outputStream = resourceResponse.getPortletOutputStream();
        		workbook.write(outputStream);
        		outputStream.flush();
        		outputStream.close();
        		
        	}
        	else if("ContentTranslationView".equals(reportType) || "DiscontinuedView".equals(reportType) ||  "UnattributeBrndView".equals(reportType) 
        			||  "UnattributeRgnView".equals(reportType) ||  "GlobalMustView".equals(reportType) ||  "GlobalNotInMustView".equals(reportType) 
        			||  "GlobalMustNotView".equals(reportType) ||  "SelectStateView".equals(reportType) ||  "OverriddenView".equals(reportType)  
        			||  "MissingXrefView".equals(reportType) ||  "ExpiredView".equals(reportType)  ||  "ComplianceView".equals(reportType) ) 
        	{
        		List<Standard> viewDetailsStandards = new ArrayList<Standard>();
        		if(portletSession.getAttribute(reportType+"DetailStandards") != null){
        			viewDetailsStandards = (List<Standard>) portletSession.getAttribute(reportType+"DetailStandards");
        		}
        		final Workbook workbook = ProgressPortletUtil.exportContentDetailStandards(reportType, reportLocaleCode, viewDetailsStandards);
        		resourceResponse.setContentType("application/vnd.ms-excel");
        		if("ContentTranslationView".equals(reportType)){
        			resourceResponse.addProperty("Content-Disposition", "attachment; filename=Progress_"+publish.getChainCode()+"_"+regionCd+"_"+reportLocaleCode+"_"+reportType+"Details.xls");
        		} else {
        			resourceResponse.addProperty("Content-Disposition", "attachment; filename=Progress_"+publish.getChainCode()+"_"+regionCd+"_"+reportType+"Details.xls");
        		}
        		final OutputStream outputStream = resourceResponse.getPortletOutputStream();
        		workbook.write(outputStream);
        		outputStream.flush();
        		outputStream.close();
        		
        	} else if("AttachmentTranslationView".equals(reportType) || "LinkTranslationView".equals(reportType) || "ImageTranslationView".equals(reportType) )
        	{
        		List<Standard> viewDetailsStandards = new ArrayList<Standard>();
        		if(portletSession.getAttribute(reportType+"DetailStandards") != null){
        			viewDetailsStandards = (List<Standard>) portletSession.getAttribute(reportType+"DetailStandards");
        		}
        		final Workbook workbook = ProgressPortletUtil.exportSupportContentTranslations(reportType, reportLocaleCode, viewDetailsStandards);
        		resourceResponse.setContentType("application/vnd.ms-excel");
        		resourceResponse.addProperty("Content-Disposition", "attachment; filename=Progress_"+publish.getChainCode()+"_"+regionCd+"_"+reportLocaleCode+"_"+reportType+"Details.xls");
        		final OutputStream outputStream = resourceResponse.getPortletOutputStream();
        		workbook.write(outputStream);
        		outputStream.flush();
        		outputStream.close();
        		
        	}
        } else if("Acknowledge".equals(requestType)){
        	String notificationIds = resourceRequest.getParameter("notificationIds");
        	String returnMsg = "";
            try {
            	if(Validator.isNotNull(notificationIds) && ErrNotificationLocalServiceUtil.acknowledgeNotifications(notificationIds)){
            		returnMsg = "Success";
            	} else {
            		returnMsg = "Fail";
            	}
			} catch (Exception e) {
				returnMsg = "Fail";
				LOG.error("Failed to update Acknowledgement for notifications:"+notificationIds, e);
			}
            resourceResponse.getWriter().write(returnMsg);
        }
	}
    
    private static void addBridgePublishLang(Publication publish,long regionId, String localeCode,ThemeDisplay themeDisplay)
    {
    	BridgePublishLang bridgePublishLang;
		try {
			bridgePublishLang = BridgePublishLangLocalServiceUtil.createBridgePublishLang(CounterLocalServiceUtil
			         .increment(BridgePublishLang.class.getName()));
			bridgePublishLang.setPublishId(publish.getPublishId());
			bridgePublishLang.setRegionId(regionId);
			bridgePublishLang.setLocaleCode(localeCode);
			bridgePublishLang.setCreatorId(String.valueOf(themeDisplay.getUserId()));
			bridgePublishLang.setCreatedDate(new Date());
			bridgePublishLang.setUpdatedBy(String.valueOf(themeDisplay.getUserId()));
			bridgePublishLang.setUpdatedDate(new Date());
			BridgePublishLangLocalServiceUtil.updateBridgePublishLang(bridgePublishLang);
		} catch (SystemException e) {
			LOG.error("While adding BridgePublishLang : ",e);
		}
    }
}
