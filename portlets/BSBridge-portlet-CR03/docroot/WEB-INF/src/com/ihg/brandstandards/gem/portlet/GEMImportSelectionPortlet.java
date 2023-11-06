package com.ihg.brandstandards.gem.portlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.db.NoSuchPublishDeptException;
import com.ihg.brandstandards.db.model.GEMQlReport;
import com.ihg.brandstandards.db.model.GEMTemplate;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.PublishDept;
import com.ihg.brandstandards.db.service.GEMQlReportLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMTemplateLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublishDeptLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.ihg.brandstandards.gem.score.AbstractScoreCalculator;
import com.ihg.brandstandards.gem.score.GEMScore;
import com.ihg.brandstandards.gem.util.GemConstants;
import com.ihg.brandstandards.gem.util.GemImportSelectionProcessor;
import com.ihg.brandstandards.gem.util.ImportExcelGeneralException;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;


public class GEMImportSelectionPortlet extends BrandStandardsGemPortlet {
	private static final Log LOGGER = LogFactoryUtil.getLog(GEMImportSelectionPortlet.class);
	@Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		boolean hasError = GetterUtil.getBoolean(renderRequest.getParameter("hasError"),false); 
        if(hasError){
        	renderRequest.setAttribute("hasError", true);
        	renderRequest.setAttribute("error-type", renderRequest.getParameter("error-type"));
        	renderRequest.setAttribute("brand", renderRequest.getParameter("brand"));
        	renderRequest.setAttribute("region", renderRequest.getParameter("region"));
        	renderRequest.setAttribute("dept", renderRequest.getParameter("dept"));
        	renderRequest.setAttribute("import_selection_file", renderRequest.getParameter("import_selection_file"));
        }else if(GetterUtil.getBoolean(renderRequest.getParameter("importSuccess"),false)){
        	renderRequest.setAttribute("importSuccess", "true");
        }
        include(viewTemplate, renderRequest, renderResponse);
    }
	
	
	
 public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
		final String resourceID = resourceRequest.getResourceID();
		 try { 
			 ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			 JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			 PrintWriter writer = resourceResponse.getWriter();
			 String brand = resourceRequest.getParameter("brand");
		     String regionCd = resourceRequest.getParameter("region");
		     long regionId=StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCd);
		     long department = GetterUtil.getLong(resourceRequest.getParameter("dept"));
		     String screenName = themeDisplay.getUser().getScreenName();
		     LOGGER.debug("========>Brand : "+brand+"-- Region "+regionCd+"Department Name : "+department);
		     Publication publication = getActiveGEMPublication(department,brand);
		 
			 if(("validateSelection").equals(resourceID)){
			 try {
				    if(Validator.isNull(publication)){	
			    	 jsonObject.put("isValid", "false");
			    	 jsonObject.put("errorMessage", "publication-not-available");
		        	
		        }else{
		        	long seTemplateID = getTemplateId(publication.getPublishId(), StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCd), GemConstants.SE_REPORT_TYPE);
		        	 if(Validator.isNull(seTemplateID) || seTemplateID==0){
		        		 jsonObject.put("isValid", "false");
				    	 jsonObject.put("errorMessage", "seTemplate-not-available");
		        	 }else{
		        		 jsonObject.put("isValid", "true");
		        	 }
		        }
				 writer.write(jsonObject.toString());
			 } catch (Exception e) {
				 LOGGER.error("Error in checking deparment name exist or not " + e.getMessage(), e);
			}
		  }else if(("clearMeasurement").equals(resourceID)){
			  GemImportSelectionProcessor selectionProcessor = new GemImportSelectionProcessor();
			  boolean success = selectionProcessor.clearSelection(publication,regionCd, department);
			  if(!success){
		        		 jsonObject.put("isValid", "false");
				    	 jsonObject.put("errorMessage", "Clear Selection process got failed.");
		        	 }else{
		        		 EntityCacheUtil.clearCache(GEMQlReport.class.getName());
		        		 FinderCacheUtil.clearCache(GEMQlReport.class.getName());
		        		 GEMQlReportLocalServiceUtil.clearCache();
		        		 jsonObject.put("isValid", "true");
		        		 calculateScore(publication, regionId, department,screenName);
		        	 }
		      
				 writer.write(jsonObject.toString());
			}	 
		 } catch (Exception e) {
	            LOGGER.error(e);
	      }
	 }
 
 
 public void importSelection(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException, InvalidFormatException, IOException
	{
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		 UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		    File file = uploadRequest.getFile("import_selection_file");
	        String brand = uploadRequest.getParameter("brand");
	        String regionCd = uploadRequest.getParameter("region");
	        long department = GetterUtil.getLong(uploadRequest.getParameter("dept"));
	        long regionId=StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCd);
	        String screenname = themeDisplay.getUser().getScreenName();
	        LOGGER.debug("========>Brand : "+brand+"-- Region "+regionCd+"Department Name : "+department);
	        InputStream inputFileStream = new FileInputStream(file);
	        GemImportSelectionProcessor selectionProcessor = new GemImportSelectionProcessor();
	        Publication publication = getActiveGEMPublication(department,brand);
	        
	        boolean hasError = false;
	        if(Validator.isNotNull(publication)){	
	        	 long seTemplateID = getTemplateId(publication.getPublishId(), regionId, GemConstants.SE_REPORT_TYPE);
	        	 if(Validator.isNotNull(seTemplateID) || seTemplateID!=0){
	        		 try {
						selectionProcessor.processImport(brand,regionCd,department,inputFileStream,publication,seTemplateID);
						
					} catch (ImportExcelGeneralException e) {
						 hasError =true;
						 actionResponse.setRenderParameter("hasError", "true");
		        		 actionResponse.setRenderParameter("error-type", "error-excel-validation");
		        		 SessionErrors.add(actionRequest, "error-excel-validation");
					}
	        	 }else{
	        		 hasError =true;
	        		 SessionErrors.add(actionRequest, "error-templateId");
	        		 actionResponse.setRenderParameter("hasError", "true");
	        		 actionResponse.setRenderParameter("error-type", "templetId");
	        	 }
	        	
	        }else{
	        	hasError =true;
	        	SessionErrors.add(actionRequest, "error-publication");
	        	actionResponse.setRenderParameter("hasError", "true");
       		    actionResponse.setRenderParameter("error-type", "publication");
	        }
	        if(hasError){
	        	actionResponse.setRenderParameter("brand", brand);
       		    actionResponse.setRenderParameter("region", regionCd);
       		    actionResponse.setRenderParameter("dept", StringUtil.valueOf(department));
       		 actionResponse.setRenderParameter("import_selection_file", file.getPath());
	        }else{
	        	actionResponse.setRenderParameter("importSuccess", "true");
	        	EntityCacheUtil.clearCache(GEMQlReport.class.getName());
       		 	FinderCacheUtil.clearCache(GEMQlReport.class.getName());
       		 	GEMQlReportLocalServiceUtil.clearCache();
	        	calculateScore(publication, regionId, department,screenname);
	        	//GEMQlReportLocalServiceUtil.populateScoringCounts(publishDept.getPublishDeptId(), publish.getParentPublishId(), publishId, seTemplateId, regionId, screenName);
	            
	        	//SessionMessages.add(actionRequest, "import-success");
	        }
	}
 private long getTemplateId(long publishId, long regionId, String templType)
 {
     long templateId = 0;
     try
     {
         List<GEMTemplate> list = GEMTemplateLocalServiceUtil.getByPublishIdAndRgnIdAndType(publishId, regionId, GemConstants.TEMPLATE_TYPE_SE);
         if(list != null && !list.isEmpty())
         {
             templateId = list.get(0).getTemplateId();
         }
     }
     catch (SystemException e)
     {
         LOGGER.error("Failed to get " + templType + " temlates:" + e);
     }
     return templateId;
 }
 private void calculateScore(Publication publication,long regionId,long deptId,String screenName)
 {
     long publishId = publication.getPublishId();
   //  long regionId = BrandStandardsUtil.getRegionId(userPreferences.getRegionCode());
     PublishDept publishDept = null;
		try {
			publishDept = PublishDeptLocalServiceUtil.getActivePublicationByDept(publishId,deptId);
		} catch (NoSuchPublishDeptException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (SystemException e) {
			LOGGER.error(e.getMessage(), e);
		}
     
     long seTemplateId = getTemplateId(publishId, regionId, GemConstants.TEMPLATE_TYPE_SE);
     GEMQlReportLocalServiceUtil.populateScoringCounts(publishDept.getPublishDeptId(), publication.getParentPublishId(), publishId, seTemplateId, regionId, screenName);
     
   //  AbstractScoreCalculator calc = new GEMScore();
   //  calc.calculate(publishId, regionId, brandCode);

   //  return populateDataToJSON(seTemplateId,userPreferences.getDepartmentId());
 }
 	
}
