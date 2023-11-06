package com.ihg.brandstandards.portlet;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.portlet.PortletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;

import com.ihg.brandstandards.bsadmin.model.XlsModelData;
import com.ihg.brandstandards.custom.model.CMSSearchCriteria;
import com.ihg.brandstandards.db.model.PublishQueue;
import com.ihg.brandstandards.db.model.StandardsExt;
import com.ihg.brandstandards.db.model.StandardsLocale;
import com.ihg.brandstandards.db.model.TaxonomyExt;
import com.ihg.brandstandards.db.service.PublishQueueLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsExtLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.TaxonomyExtLocalServiceUtil;
import com.ihg.brandstandards.report.ReportConfig;
import com.ihg.brandstandards.report.ReportConfigLoader;
import com.ihg.brandstandards.service.StandardsReportBuilder;
import com.ihg.brandstandards.spreadsheet.PublishXlsSheetIterator;
import com.ihg.brandstandards.util.BSAdminConstants;
import com.ihg.brandstandards.util.BrandStandardsCacheUtil;
import com.ihg.brandstandards.util.CMSStandardsListUtil;
import com.ihg.brandstandards.util.StandardsUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Publish Admin portlet.
 * @author KhandeN
 *
 */
public class PublishPortlet extends MVCPortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(PublishPortlet.class);

    /**
     * Overwrite method 
     */
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        LOG.debug("THIS IS PUBLISH PORTLET DO VIEW !");
        Long count = StandardsLocalServiceUtil.getLockedStandardsCount("EX");
        renderRequest.setAttribute("lockedStdCount", count);
        List<ReportConfig> config = ReportConfigLoader.getSortedReportConfig();
        renderRequest.setAttribute("reportConfigs", config);
        final PortletRequestDispatcher reqDisp = getPortletContext().getRequestDispatcher(viewTemplate);
        reqDisp.include(renderRequest, renderResponse);
    }
    
    /**
     * Serve AJAX calls.
     * @see com.liferay.util.bridges.mvc.MVCPortlet#serveResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
     * 
     * @param resourceRequest - ResourceRequest
     * @param resourceResponse - ResourceResponse
     * @throws IOException - exception
     * @throws PortletException - exception
     */
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException
    {
        resourceResponse.setContentType("text/html");
        final String resourceID = resourceRequest.getResourceID();

        if ("validate".equalsIgnoreCase(resourceID))
        {
            validateRecordsForPublishing(resourceRequest, resourceResponse);
        }
        else if ("confirmed".equalsIgnoreCase(resourceID)) 
        {
            addToPublishQueue(resourceRequest, resourceResponse);
        }
        else if ("deleteSchedule".equalsIgnoreCase(resourceID)) 
        {
            deletePublishQueue(resourceRequest, resourceResponse);
        }
        else if ("releaseLockedRecords".equalsIgnoreCase(resourceID)) 
        {
            releaseLockedRecords(resourceRequest, resourceResponse);
        }
        else if ("createManuals".equalsIgnoreCase(resourceID)) 
        {
            createManuals(resourceRequest, resourceResponse);
        }
        else if ("runReport".equalsIgnoreCase(resourceID)) 
        {
            runReport(resourceRequest, resourceResponse);
        }
        else if ("getHistData".equalsIgnoreCase(resourceID)) 
        {
            getPublishQueueHistory(resourceRequest, resourceResponse);
        }
        else if ("getBrandLocales".equalsIgnoreCase(resourceID)) 
        {
            getBrandLocales(resourceRequest, resourceResponse);
        }
        else
        {
            LOG.error("Unknown Resource ID: " + resourceRequest.getResourceID());
        }
    }

    /**
     * Perform records validation before publishing.
     * @param resourceRequest request
     * @param resourceResponse response
     * @throws PortletException exception
     * @throws IOException exception
     */
    private void validateRecordsForPublishing(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws PortletException, IOException
    {
        HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
        final boolean isMultipart = PortletFileUpload.isMultipartContent(new ServletRequestContext(request));
        if (!isMultipart)
        {
            throw new PortletException("No file found for upload!");
        }
        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
        final String brandCd = uploadRequest.getParameter("selectBrand");
//        final String fetchLocalesByStdId = uploadRequest.getParameter("fetchLocalesStdId");
//        final String[] locales = uploadRequest.getParameterValues("selectLocale");
        final String fileName = uploadRequest.getFileName("uploadFile");
        final File sourceFile = (File) uploadRequest.getFile("uploadFile");
        String idLstStr = null;
        String result = null;
        List<Long> stdIds = new ArrayList<Long>();
        
        if (fileName.endsWith(".xls"))
        {
            try 
            {
                idLstStr = getIdsFromExcelFile(sourceFile, stdIds);
            }
            catch (PortletException e)
            {
                LOG.error(ExceptionUtils.getFullStackTrace(e));
            }
        }
        // should be text file
        else 
        {
            idLstStr = getIdsFromTextFile(sourceFile, stdIds);
        }
        
        if (stdIds.size() > 0)
        {
//            if ("true".equals(fetchLocalesByStdId))
//            {
//                final JSONObject jsonMain = getBrandLocalesJson(stdIds, brandCd);
//                result = jsonMain.toString();
//            }
//            else 
//            {
                String ret = validateRecords(idLstStr, brandCd);
                
                if ("SUCCESS".equals(ret))
                {
                    result = idLstStr;
                }
                else
                {
                    result = "ERROR: " + ret;
                }
//            }
        }
        else 
        {
            result = "ERROR: No IDs found in the file.";
        }
        final PrintWriter writer = resourceResponse.getWriter();
        writer.write(result);
        writer.flush();
    }

    /**
     * Retrieve historical data from Publish Queue table.  
     * @param resourceRequest request
     * @param resourceResponse response
     * @throws IOException exception
     */
    private void getPublishQueueHistory(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException
    {
        int recCnt = resourceRequest.getParameter("recordCnt") == null ? 25 : Integer.parseInt(resourceRequest.getParameter("recordCnt"));
        String envType = resourceRequest.getParameter("envType") == null ? BSAdminConstants.ENVIRONMENT_PRODUCTION 
                : resourceRequest.getParameter("envType");
        envType = BSAdminConstants.ENVIRONMENT_PRODUCTION.equals(envType) ? "Production" : "Staging";
        
        final JSONObject jsonMain = JSONFactoryUtil.createJSONObject();
        String errorMsg = "SUCCESS";
        try
        {
            Map<String, String> localeMap = getAllLocales();
            
            List<PublishQueue> histList = PublishQueueLocalServiceUtil.findPublishQueueByEnvironment(envType, recCnt);

            if (!StandardsUtil.isNullOrBlank(histList))
            {
                jsonMain.put("recordCnt", histList.size());

                int indx = 1;
                for (PublishQueue item : histList)
                {
                    final JSONObject jsonOSM = JSONFactoryUtil.createJSONObject();
                    jsonOSM.put("id", item.getPublishQueueId());
                    jsonOSM.put("pubId", item.getPublishId());
                    jsonOSM.put("env", item.getPublishEnvironment());
                    jsonOSM.put("brand", StandardsUtil.decodeChainCode(item.getChainCd()));
                    jsonOSM.put("stat", item.getQueueStatCd());
                    jsonOSM.put("schedule_dt", item.getSchedulePublish() != null ? item.getSchedulePublish().toString() : "");
                    jsonOSM.put("prod_pub_dt", item.getExpectedProdPublishDt() != null ? item.getExpectedProdPublishDt().toString() : "");

                    String decodedLocales = decodeLocales(localeMap, item);
                    jsonOSM.put("locale_lst", decodedLocales);
                    
                    if (item.getExpectedProdPublishDt() != null && item.getExpectedProdPublishDt().getTime() > item.getUpdatedDate().getTime())
                    {
                        jsonOSM.put("allow_prod_pub", "true");
                    }
                    else 
                    {
                        jsonOSM.put("allow_prod_pub", "false");
                    }
                    jsonOSM.put("start_dt", item.getScheduleStart() != null ? item.getScheduleStart().toString() : "");
                    jsonOSM.put("end_dt", item.getScheduleEnd() != null ? item.getScheduleEnd().toString() : "");
                    jsonOSM.put("email", item.getNotificationEmailId().replaceAll(",", ", "));
                    jsonOSM.put("user", PortalUtil.getUserName(Long.valueOf(item.getCreatorId()), item.getCreatorId()));
                    jsonMain.put(String.valueOf(indx), jsonOSM);
                    indx++;
                }
            }
            else
            {
                jsonMain.put("recordCnt", 0);
            }
        }
        catch (SystemException e)
        {
            LOG.error(ExceptionUtils.getFullStackTrace(e));
            errorMsg = "Search failed";
        }
        jsonMain.put("message", errorMsg);
        
        final PrintWriter writer = resourceResponse.getWriter();
        writer.write(jsonMain.toString());
        writer.flush();
    }

    /**
     * Decode Locale code to Title.
     * @param localeMap map of all locales
     * @param item PublishQueue object
     * @return locale title.
     */
    private String decodeLocales(Map<String, String> localeMap, PublishQueue item)
    {
        String decodedLocale = "";
        
        if (item.getPublishLocaleList() != null)
        {
            String[] locales = item.getPublishLocaleList().split(",");
            StringBuilder builder = new StringBuilder();
            for (String key : locales) 
            {
                String value = localeMap.get(key);
                if (value != null && !value.isEmpty())
                {
                    if (builder.length() > 0)
                    {
                        builder.append(", ");
                    }
                    builder.append(value);
                }
            }
            decodedLocale = builder.length() > 0 ? builder.toString() : "";
        }
        return decodedLocale;
    }

    /**
     * Fetch all locales.
     * @return map of locales. 
     * @throws SystemException exception.
     */
    private Map<String, String> getAllLocales() throws SystemException
    {
        List<StandardsLocale> languages = BrandStandardsCacheUtil.getAllLocales();
        Map<String, String> locales = new HashMap<String, String>();
        
        for (StandardsLocale language : languages) 
        {
            locales.put(language.getLocaleCode(), language.getLocaleName());
        }
        
        return locales;
    }

    /**
     * Retrieve locales for the Brand.  
     * @param resourceRequest request
     * @param resourceResponse response
     * @throws IOException exception
     */
    private void getBrandLocales(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException
    {
        final String brandCd = resourceRequest.getParameter("selectBrand");
        
        final JSONObject jsonMain = getBrandLocalesJson(brandCd);
        
        final PrintWriter writer = resourceResponse.getWriter();
        writer.write(jsonMain.toString());
        writer.flush();
    }

    /**
     * Find locales and put them to JSON.
     * @param stdIds list of ids
     * @param brandCd Brand
     * @return JSON object
     */
    private JSONObject getBrandLocalesJson(final List<Long> stdIds, final String brandCd)
    {
        final JSONObject jsonMain = JSONFactoryUtil.createJSONObject();
        String errorMsg = "SUCCESS";
        try
        {
//            Map<String, String> locales = PublishQueueLocalServiceUtil.getLocalesByStdId(stdIds, brandCd);
            Map<String, String> locales = PublishQueueLocalServiceUtil.getLocalesByBrand(brandCd);

            if (!StandardsUtil.isNullOrBlank(locales))
            {
                int indx = 1;
                for (Entry<String, String> locale : locales.entrySet())
                {
                    final JSONObject jsonOSM = JSONFactoryUtil.createJSONObject();
                    jsonOSM.put("value", locale.getKey());
                    jsonOSM.put("text", locale.getValue());
                    jsonMain.put(String.valueOf(indx), jsonOSM);
                    indx++;
                }
            }
        }
        catch (SystemException e)
        {
            LOG.error(ExceptionUtils.getFullStackTrace(e));
            errorMsg = "Search failed";
        }
        jsonMain.put("message", errorMsg);
        return jsonMain;
    }

    /**
     * Find locales and put them to JSON.
     * @param brandCd Brand
     * @return JSON object
     */
    private JSONObject getBrandLocalesJson(final String brandCd)
    {
        final JSONObject jsonMain = JSONFactoryUtil.createJSONObject();
        String errorMsg = "SUCCESS";
        boolean isEnGbExist = false;
        try
        {
            Map<String, String> locales = PublishQueueLocalServiceUtil.getLocalesByBrand(brandCd);
            int indx = 1;

            if (!StandardsUtil.isNullOrBlank(locales))
            {
                for (Entry<String, String> locale : locales.entrySet())
                {
                    if ("en_GB".equals(locale.getKey()))
                    {
                        isEnGbExist = true;
                    }
                    final JSONObject jsonOSM = JSONFactoryUtil.createJSONObject();
                    jsonOSM.put("value", locale.getKey());
                    jsonOSM.put("text", locale.getValue());
                    jsonMain.put(String.valueOf(indx), jsonOSM);
                    indx++;
                }
            }
            if (!isEnGbExist)
            {
                final JSONObject jsonOSM = JSONFactoryUtil.createJSONObject();
                jsonOSM.put("value", "en_GB");
                jsonOSM.put("text", "English (UK)");
                jsonMain.put(String.valueOf(indx), jsonOSM);
            }
        }
        catch (SystemException e)
        {
            LOG.error(ExceptionUtils.getFullStackTrace(e));
            errorMsg = "Search failed";
        }
        jsonMain.put("message", errorMsg);
        return jsonMain;
    }

    /**
     * Validate specified STD IDs.
     * @param stdIds list of ids
     * @param chainCd brand
     * @return SUCCESS or error message
     */
    private String validateRecords(final String stdIds, final String chainCd)
    {
        // verify if specified records are DELETED or not existing.
        // verify if SPEC or Guideline does not have parent
        String result;
        try
        {
            String ids = stdIds.replaceAll(" ", "");
            result = PublishQueueLocalServiceUtil.validateStdIds(ids, chainCd);
        }
        catch (SystemException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            result = "ERROR occur!";
        }
        LOG.debug("Validation result: " + result);
        return result;
    }

    /**
     * Fetch STD IDs from excel file. 
     * @param sourceFile file
     * @param stdIds return list of ids
     * @return string of comma separated list of ids
     * @throws PortletException exception
     */
    private String getIdsFromExcelFile(final File sourceFile, List<Long> stdIds) throws PortletException
    {
        PublishXlsSheetIterator xlsSheetIterator = new PublishXlsSheetIterator(sourceFile);
        String result = null;

        try
        {
            List<XlsModelData> xlsModelDataList = xlsSheetIterator.processSpreadsheet();
            if (xlsModelDataList != null)
            {
                StringBuilder builder = new StringBuilder();
                for (XlsModelData data : xlsModelDataList)
                {
                    if (!data.getId().isEmpty())
                    {
                        if (builder.length() > 0)
                        {
                            builder.append(", ");
                        }
                        builder.append(data.getId());
                        stdIds.add(Long.parseLong(data.getId()));
                    }
                }
                result = builder.toString();
            }
            else
            {
                LOG.info("Please attach Excel sheet with apt values!");
                result = "Error: Please attach text file with correct values!";
            }
        }
        catch (InvalidFormatException e)
        {
            LOG.error(ExceptionUtils.getFullStackTrace(e));
            throw new PortletException(e);
        }
        catch (IOException e)
        {
            LOG.error(ExceptionUtils.getFullStackTrace(e));
            throw new PortletException(e);
        }
        return result;
    }


    /**
     * Fetch STD IDs from text file. 
     * @param sourceFile file
     * @param stdIds return list of ids
     * @return string of comma separated list of ids
     * @throws PortletException exception
     */
    private String getIdsFromTextFile(final File sourceFile, List<Long> stdIds) throws PortletException
    {
        PublishXlsSheetIterator xlsSheetIterator = new PublishXlsSheetIterator(sourceFile);
        String result = null;

        try
        {
            List<XlsModelData> xlsModelDataList = xlsSheetIterator.processSpreadsheet();
            if (xlsModelDataList != null)
            {
                StringBuilder builder = new StringBuilder();
                for (XlsModelData data : xlsModelDataList)
                {
                    if (builder.length() > 0)
                    {
                        builder.append(",");
                    }
                    builder.append(data.getId());
                    stdIds.add(Long.parseLong(data.getId()));
                }
                result = builder.toString();
            }
            else
            {
                LOG.info("Please attach Excel sheet with apt values!");
                result = "Error: Please attach Excel file with correct values!";
            }
        }
        catch (InvalidFormatException e)
        {
            LOG.error(ExceptionUtils.getFullStackTrace(e));
            throw new PortletException(e);
        }
        catch (IOException e)
        {
            LOG.error(ExceptionUtils.getFullStackTrace(e));
            throw new PortletException(e);
        }
        return result;
    }

    /**
     * Add Publish request to publish queue.
     * @param resourceRequest request
     * @param resourceResponse response
     * @throws IOException exception
     * @throws PortletException exception
     */

    private void addToPublishQueue(final ResourceRequest resourceRequest, final ResourceResponse resourceResponse) throws IOException,
            PortletException
    {
        String pubEnv = resourceRequest.getParameter("pubEnv");
        final String userId = String.valueOf(PortalUtil.getUserId(resourceRequest));
        String status = "SUCCESS";
        
        try
        {
            if ("STAGING".equals(pubEnv))
            {
                addToPublishQueueStaging(resourceRequest, pubEnv, userId);
            }
            else if ("PRODUCTION".equals(pubEnv))
            {
                addToPublishQueueProduction(resourceRequest, pubEnv);
            }
            else 
            {
                status = "ERROR";
                LOG.error("Unknown Publish Environment: " + pubEnv);
            }
        }
        catch (SystemException e)
        {
            status = "ERROR";
            LOG.error(ExceptionUtils.getFullStackTrace(e));
            throw new PortletException(e);
        }
        final PrintWriter writer = resourceResponse.getWriter();
        writer.write(status);
        writer.flush();
    }

    /**
     * Add request to publish to a specified Environment.
     * @param resourceRequest request
     * @param pubEnv environment
     * @throws SystemException exception
     */
    private void addToPublishQueueProduction(final ResourceRequest resourceRequest, String pubEnv) throws SystemException
    {
        String pubQueueId = resourceRequest.getParameter("pubQueueId");
        long publishQueueId = Long.parseLong(pubQueueId);
        PublishQueue queue = PublishQueueLocalServiceUtil.clonePublishQueue(publishQueueId);
        queue.setPublishEnvironment(pubEnv);
        queue.setQueueStatCd("NEW");
        queue.setSchedulePublish(queue.getExpectedProdPublishDt());
        PublishQueueLocalServiceUtil.addPublishQueue(queue);
        PublishQueueLocalServiceUtil.updatePublishQueueStatus(publishQueueId, "COMPLETE_PROD_SCHEDULED");
    }

    /**
     * Add request to publish to Staging Environment.
     * @param resourceRequest
     * @param pubEnv
     * @param userId
     * @throws SystemException
     */
    private void addToPublishQueueStaging(final ResourceRequest resourceRequest, String pubEnv, final String userId)
            throws SystemException
    {
        String pubSchedule = resourceRequest.getParameter("pubSchedule");
        String pubDate = resourceRequest.getParameter("pubDate");
        String pubTime = resourceRequest.getParameter("pubTime");
        String pubBrand = resourceRequest.getParameter("pubBrand");
        String pubEmail = resourceRequest.getParameter("pubEmail");
        String pubStdIds = resourceRequest.getParameter("pubStdIds");
        String locales = resourceRequest.getParameter("localeLst");
        if (locales != null && !locales.contains("en_GB"))
        {
            if (locales.isEmpty())
            {
                locales = "en_GB";
            }
            else 
            {
                locales = "en_GB," + locales;
            }
        }
        
        Date prodPublishDate = null;
        try
        {
            SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy hh:mmaa");
            pubDate = pubDate.replaceAll("-", " ");
            prodPublishDate = formatter.parse(pubDate + " " + pubTime);
        }
        catch (ParseException e)
        {
            LOG.error(ExceptionUtils.getFullStackTrace(e));
            throw new SystemException(e);
        }

        PublishQueue queue = PublishQueueLocalServiceUtil.createPublishQueueOraSecuence();
        queue.setPublishFileText(pubStdIds.replaceAll(" " , ""));
        queue.setPublishEnvironment(pubEnv);
        queue.setNotificationEmailId(pubEmail);
        queue.setQueueStatCd("NEW");
        if ("PUBLISH_OFF_HOURS".equals(pubSchedule))
        {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, 19);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            Date publishDate = calendar.getTime();
            queue.setSchedulePublish(publishDate);
        }
        else
        {
            queue.setSchedulePublish(queue.getCreatedDate());
        }
        queue.setExpectedProdPublishDt(prodPublishDate);
        queue.setChainCd(pubBrand);
        queue.setPublishLocaleList(locales);
        queue.setCreatorId(userId);
        queue.setUpdatedBy(userId);
        PublishQueueLocalServiceUtil.addPublishQueue(queue);
    }
    
    /**
     * Add Publish request to publish queue.
     * @param resourceRequest request
     * @param resourceResponse response
     * @throws IOException exception
     * @throws PortletException exception
     */
    private void deletePublishQueue(final ResourceRequest resourceRequest, final ResourceResponse resourceResponse) throws IOException,
            PortletException
    {
        String pubEnv = resourceRequest.getParameter("pubEnv").toUpperCase();
        String status = "SUCCESS";
        
        try
        {
            if (BSAdminConstants.ENVIRONMENT_PRODUCTION.equals(pubEnv))
            {
                String pubQueueId = resourceRequest.getParameter("pubQueueId");
                long publishQueueId = Long.parseLong(pubQueueId);
                PublishQueueLocalServiceUtil.updatePublishQueueStatus(publishQueueId, "DELETED");
            }
            else 
            {
                status = "ERROR";
                LOG.error("Unknown Publish Environment: " + pubEnv);
            }
        }
        catch (SystemException e)
        {
            status = "ERROR";
            LOG.error(ExceptionUtils.getFullStackTrace(e));
            throw new PortletException(e);
        }
        final PrintWriter writer = resourceResponse.getWriter();
        writer.write(status);
        writer.flush();
    }
    
    /**
     * Release locked records.
     * @param resourceRequest request
     * @param resourceResponse response
     * @throws IOException exception
     * @throws PortletException exception
     */
    private void releaseLockedRecords(final ResourceRequest resourceRequest, final ResourceResponse resourceResponse) throws IOException,
            PortletException
    {
        String status = "SUCCESS";
        try
        {
            StandardsLocalServiceUtil.setStandardsStatusUnlock("EX");
        }
        catch (SystemException e)
        {
            status = "ERROR";
            LOG.error(ExceptionUtils.getFullStackTrace(e));
            throw new PortletException(e);
        }

        final PrintWriter writer = resourceResponse.getWriter();
        writer.write(status);
        writer.flush();
    }
    
    /**
     * Create Manuals.
     * @param resourceRequest request
     * @param resourceResponse response
     * @throws IOException exception
     * @throws PortletException exception
     */
    private void createManuals(final ResourceRequest resourceRequest, final ResourceResponse resourceResponse) throws IOException,
            PortletException
    {
        String pubEnv = resourceRequest.getParameter("pubEnv");
        String status = "SUCCESS";
        
        try
        {
            if ("STAGING".equals(pubEnv))
            {
                String pubQueueId = resourceRequest.getParameter("pubQueueId");
                long publishQueueId = Long.parseLong(pubQueueId);
                PublishQueueLocalServiceUtil.createManuals(publishQueueId, pubEnv);            
            }
            else 
            {
                status = "ERROR";
                LOG.error("Unknown Publish Environment: " + pubEnv);
            }
        }
        catch (SystemException e)
        {
            status = "ERROR";
            LOG.error(ExceptionUtils.getFullStackTrace(e));
            throw new PortletException(e);
        }

        final PrintWriter writer = resourceResponse.getWriter();
        writer.write(status);
        writer.flush();
    }

    /**
     * Run Report.
     * @param resourceRequest request
     * @param resourceResponse response
     * @throws IOException exception
     * @throws PortletException exception
     */
    private void runReport(final ResourceRequest resourceRequest, final ResourceResponse resourceResponse) throws IOException,
            PortletException
    {
        final String pubEnv = resourceRequest.getParameter("pubEnv");
        final String reportId = resourceRequest.getParameter("reportId");
        final long pubQueueId = Long.parseLong(resourceRequest.getParameter("pubQueueId") == null ? "0" : resourceRequest.getParameter("pubQueueId"));
        final long publishId = Long.parseLong(resourceRequest.getParameter("publishId") == null ? "0" : resourceRequest.getParameter("publishId"));
        
        final CMSSearchCriteria criteria = new CMSSearchCriteria();
        criteria.setPublishQueueId(pubQueueId);
        criteria.setPublishId(publishId);
        criteria.setReportId(reportId);
        criteria.setPublishEnvironment(pubEnv);
        ReportConfig config = ReportConfigLoader.getReportConfigMap().get(reportId);

        LOG.debug("Requester Report Export. Report Id = " + reportId);
        List<StandardsExt> standards = getRecordsForReport(criteria);
        setResponseHeaders(resourceResponse, config.getName());

        if (standards != null)
        {
            CMSStandardsListUtil.sortRecords(standards);
            Map<Long, Map<StandardsExt, List<StandardsExt>>> stdIndexWithSpcGdln = CMSStandardsListUtil.getStdsWithChild(standards);
            CMSStandardsListUtil.sortOnStdOrder(stdIndexWithSpcGdln);
            standards = CMSStandardsListUtil.generateSortedList(stdIndexWithSpcGdln);
        }

        try
        {
            final Workbook workbook = StandardsReportBuilder.createReport(standards, config);
            final OutputStream out = resourceResponse.getPortletOutputStream();
            workbook.write(out);
            out.flush();
            out.close();
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
    }

    /**
     * Fetch Indexes with associated Standards.
     * 
     * @param criteria - search criteria
     * @return List of records or null
     */
    private List<StandardsExt> getRecordsForReport(final CMSSearchCriteria criteria)
    {
        List<StandardsExt> standards = null;
        try
        {
            standards = getReportRecords(criteria);
            getAllIndexesSetIndexOrder(standards);
        }
        catch (SystemException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return standards;
    }

    /**
     * Fetch records for the report.
     * 
     * @param criteria - search criteria
     * @return List of records
     * @throws SystemException - exception
     */
    private List<StandardsExt> getReportRecords(final CMSSearchCriteria criteria) throws SystemException
    {
        final Map<String, CMSSearchCriteria> criteriaMap = new HashMap<String, CMSSearchCriteria>();
        criteriaMap.put("StandardsSearchCriteria", criteria);

        final List<StandardsExt> standards = PublishQueueLocalServiceUtil.getStandards(criteriaMap);
        LOG.debug("Query returned : " + standards.size() + " records");
        return standards;
    }

    /**
     * Set response headers.
     * 
     * @param resourceResponse - ResourceResponse
     * @param fileName - file name
     */
    private void setResponseHeaders(final ResourceResponse resourceResponse, final String fileName)
    {
        resourceResponse.setContentType("application/vnd.ms-excel");
        resourceResponse.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
        final String date = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
        resourceResponse.addProperty("Content-Disposition", "attachment; filename=" + fileName + "_" + date + ".xls");
    }

    /**
     * Fetch all indexes from the database and set Index order on Standard records.
     * 
     * @param standards list of records
     * @return all Indexes
     */
    private Map<Long, StandardsExt> getAllIndexesSetIndexOrder(final List<StandardsExt> standards)
    {
        final Map<Long, StandardsExt> indexMap = getAllIndexes();

        for (StandardsExt std : standards)
        {
            StandardsExt rec = indexMap.get(std.getIndexOrigId());
            std.setIndexOrder(rec.getIndexOrder());
        }
        return indexMap;
    }

    /**
     * Get all Indexes.
     * 
     * @return map of Indexes
     */
    private Map<Long, StandardsExt> getAllIndexes()
    {
        final Map<Long, StandardsExt> indexMap = new HashMap<Long, StandardsExt>();
        try
        {
            final List<TaxonomyExt> indexes = TaxonomyExtLocalServiceUtil.getAllIndexes();
            for (TaxonomyExt indx : indexes)
            {
                if (indx.getTaxId() > 1L)
                {
                    final StandardsExt std = StandardsExtLocalServiceUtil.getStandardsExtObject();
                    std.setIndexId(indx.getTaxId());
                    std.setIndexPrntId(indx.getParentId());
                    std.setIndexLevel(Long.parseLong(indx.getLvl()));
                    std.setIndexTitle(indx.getTitle());
                    std.setIndexPath(indx.getPath());
                    std.setIndexLevelSortOrder(indx.getLevelSortOrder());
                    std.setIndexOrder(indx.getIndexOrder());
                    indexMap.put(indx.getTaxId(), std);
                }
            }
            LOG.debug("indexMap contains : " + indexMap.size());
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return indexMap;
    }
}
