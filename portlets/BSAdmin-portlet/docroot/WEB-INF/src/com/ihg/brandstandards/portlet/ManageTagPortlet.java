package com.ihg.brandstandards.portlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.db.NoSuchStandardsException;
import com.ihg.brandstandards.db.model.ChainStandards;
import com.ihg.brandstandards.db.model.StandardTag;
import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.Workflow;
import com.ihg.brandstandards.db.service.ChainStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardTagLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsStatusLocalServiceUtil;
import com.ihg.brandstandards.db.service.WorkflowLocalServiceUtil;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.ihg.brandstandards.util.StandardsStatusUtil;
import com.ihg.brandstandards.util.StandardsUtil;
import com.ihg.brandstandards.util.WorkBookSpreadSheetUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class Manage Tags
 */
public class ManageTagPortlet extends MVCPortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(ManageTagPortlet.class);
  
    /**
     * Overwrite method 
     */
    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        try
        {
            User user = PortalUtil.getUser(renderRequest);
            Preferences preferences = getPreferences(renderRequest);
            boolean isSuperAdmin = StandardsUtil.isSuperAdmin(user.getRoles());
            String regionCode = getRegionCode(preferences, user, isSuperAdmin);
            renderRequest.setAttribute("regionCode", regionCode);
            renderRequest.setAttribute("namespace", renderResponse.getNamespace());
        }
        catch (PortalException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        catch (SystemException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        
        final PortletRequestDispatcher reqDisp = getPortletContext().getRequestDispatcher(viewTemplate);
        reqDisp.include(renderRequest, renderResponse);
    }

    @Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException
    {
    	try 
    	{
    		final String resourceID = resourceRequest.getResourceID();
    		User user = PortalUtil.getUser(resourceRequest);
    		Preferences preferences = getPreferences(resourceRequest);
    		boolean isSuperAdmin = StandardsUtil.isSuperAdmin(user.getRoles());
    		String regionCode = getRegionCode(preferences, user, isSuperAdmin);
    	    String stdIds = resourceRequest.getParameter("stdIds");
    	    
    		if ("updateTags".equals(resourceID))
            {
            	    updateTags(user, regionCode, stdIds, preferences, resourceRequest);
            }else if("uploadTags".equals(resourceID)){
            	
            	try {
					uploadTags(resourceRequest, resourceResponse);
				} catch (InvalidFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
            }
    		if("getXLSData".equals(resourceID)){
    			downloadFile(resourceRequest, resourceResponse);
    		}
    		if("addRemoveTags".equals(resourceID)){
    			addRemoveTags(resourceRequest, resourceResponse);
    		}
            else
            {
                LOG.error("Unknown Resource ID: " + resourceID);
            }
    		
    		//resourceResponse.setContentType(ContentTypes.APPLICATION_TEXT);
		} 
    	catch (PortalException e) 
    	{
			LOG.error("Invalid User "+ StackTraceUtil.getStackTrace(e));
		} catch (SystemException e) 
		{
			LOG.error("Unknown User "+ StackTraceUtil.getStackTrace(e));
		}
    }
    
 
    

    private void addRemoveTags(ResourceRequest resourceRequest,
    		ResourceResponse resourceResponse) throws IOException {
		// TODO Auto-generated method stub
		String standardIds=ParamUtil.getString(resourceRequest,"standardIds","");
		String tagsValue=ParamUtil.getString(resourceRequest,"tagsValue","");
		String action=ParamUtil.getString(resourceRequest,"action","");
		String inValidIds="";
		JSONObject obj=JSONFactoryUtil.createJSONObject();
		//get user details
		
		User user;
		try {
			user = PortalUtil.getUser(resourceRequest);
			Preferences preferences = getPreferences(resourceRequest);
			boolean isSuperAdmin = StandardsUtil.isSuperAdmin(user.getRoles());
			String regionCode = getRegionCode(preferences, user, isSuperAdmin);
			if(Validator.isNotNull(standardIds) && Validator.isNotNull(tagsValue)){
			String[] stdIds = standardIds.split(" ");
			String[] tags=tagsValue.split(",");
			for(int i=0;i<stdIds.length;i++){
				if(Validator.isNotNull(stdIds[i])){
				try {
					Standards std=StandardsLocalServiceUtil.getStandards(Long.valueOf(stdIds[i]));
					if(Validator.isNotNull(std) && (regionCode.equalsIgnoreCase("GLBL") || std.getRegionCode().equalsIgnoreCase(regionCode) ||	regionCode.equalsIgnoreCase(std.getRegionCode()))){
					for(int j =0;j<tags.length;j++){
						if(Validator.isNotNull(tags[j])){
						StandardTag stdTag=StandardTagLocalServiceUtil.getStandardTagWithStdId(std.getStdId(),tags[j]);
						if(action.equalsIgnoreCase("add") && Validator.isNull(stdTag) && Validator.isNotNull(user)){
							addTags(std.getStdId(),tags[j],user.getUserId());
						}else if(action.equalsIgnoreCase("remove") && Validator.isNotNull(stdTag) ){
							StandardTagLocalServiceUtil.deleteStandardTag(stdTag);
						}
						}
					}
					String comments = "Tags - "+ tags +" are "+ (action.equalsIgnoreCase("add")? "added":"deleted") +" for standard id " +  std.getStdId() ;
					updateWorkflow(user, std, comments);
					}
					else{
						inValidIds=(inValidIds==""?"":inValidIds+",")+stdIds[i];
					}
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					inValidIds=(inValidIds==""?"":inValidIds+",")+stdIds[i];
					LOG.error("error in getting standard ids: "+e.getMessage());
				}catch (SystemException e) {
					// TODO Auto-generated catch block
					inValidIds=(inValidIds==""?"":inValidIds+",")+stdIds[i];
					LOG.error("error in getting standard ids: "+e.getMessage());
				}
				}
			}
			if(Validator.isNotNull(inValidIds)){
				obj.put("hasInValData","true");
				obj.put("idList",inValidIds);
				long inValidIdsLength=inValidIds.split(",").length;
				long inputIds=stdIds.length;
				if((inValidIdsLength-inputIds) == 0){
					obj.put("status","Failure");
				}else{
					obj.put("status","Success");
				}
			}else{
				obj.put("hasInValData", "false");
				obj.put("status","Success");
			}
		}
		} catch (PortalException e1) {
			// TODO Auto-generated catch block
		LOG.error("error in fetching user details "+ e1.getMessage());
		}catch (SystemException e1) {
			// TODO Auto-generated catch block
		LOG.error("error in fetching user details "+ e1.getMessage());
		}
		
		
		writeJSON(resourceRequest,resourceResponse,obj);
	}

    
    private void addTags(Long stdId,String tag, Long userId) throws SystemException{
    	Date currDate=new Date();
		StandardTag newStdTag=StandardTagLocalServiceUtil.getStandardTagObject();
		newStdTag.setStdId(stdId);
		newStdTag.setTag(tag);
		newStdTag.setCreatedDate(currDate);
		newStdTag.setCreatorId(String.valueOf(userId));
		newStdTag.setUpdatedBy(String.valueOf(userId));
		newStdTag.setUpdatedDate(currDate);
		StandardTagLocalServiceUtil.addStandardTag(newStdTag);
		
    }
    
	private void updateTags(User user, String regionCode,String stdIds,Preferences preferences, ResourceRequest resourceRequest) {
    	
    	List<Long> stdLists = getStandardsIds(stdIds);
    	LOG.info("=========>"+stdLists.size());
	}

	/**
     * Get List of stdIds by passing string of stdIds.
     * 
     * @param stdIds
     * @return
     */
    public static List<Long> getStandardsIds(String stdIds) 
    {
    	String[] standardsIds = stdIds.split(" |,");
    	List<Long> stdLists = new ArrayList<Long>();
    	for (String string : standardsIds) 
    	{
			if (!BrandStandardsUtil.IsNullOrBlank(string))
				stdLists.add(GetterUtil.getLong(string, 0));
		}
    	 
    	return stdLists;
    }
    
      
    public String getWorkbook(Map<String,String> Ids) throws IOException{
    	Workbook workbook = new HSSFWorkbook();
		workbook=WorkBookSpreadSheetUtil.createWorkbookForErrorStdIDs(Ids);
		File xlsFile = File.createTempFile("managetag", ".xls");
        FileOutputStream fos = new FileOutputStream(xlsFile);
        workbook.write(fos);
        fos.flush();
        fos.close();
        return xlsFile.getName();
    }

  /*  public void uploadTags(ActionRequest actionRequest,
    		ActionResponse actionResponse) throws IOException, PortletException, InvalidFormatException {
    	*/
    private void uploadTags(ResourceRequest resourceRequest,ResourceResponse resourceResponse)throws IOException, PortletException, InvalidFormatException {
    	UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
    	
    	PrintWriter out = resourceResponse.getWriter();
        JSONObject recordsjsonObject = JSONFactoryUtil.createJSONObject();
        
    	//JSONArray jsonArr=JSONFactoryUtil.createJSONArray();
		String action =  uploadRequest.getParameter("submitAction");
		File file = uploadRequest.getFile("file");
		Map<String, String> notUpdatedIdsTags=new HashMap<String,String>();
		final Date currDate = new Date();
		if(Validator.isNotNull(file)){
			Map<String,Map<String,String>> stdIds=getStandardsIdListForTag(file,resourceRequest);
			Map<String,String> ids=stdIds.get("forDB");
			if(!ids.isEmpty()){
				try{
					User user = PortalUtil.getUser(resourceRequest);
					Preferences preferences = getPreferences(resourceRequest);
					boolean isSuperAdmin = StandardsUtil.isSuperAdmin(user.getRoles());
					String regionCode = getRegionCode(preferences, user, isSuperAdmin);
					
					// add all stdIds and tag into DB
					for (Map.Entry<String,String> entry : ids.entrySet())  {
						 if(Validator.isNotNull(entry.getKey())){
							Long stdId=Long.valueOf(entry.getKey());
							try{
								Standards std=StandardsLocalServiceUtil.getStandards(stdId);
								String[] tags = entry.getValue().split(",|\\|");
								if(Validator.isNotNull(std)){
									if(regionCode.equalsIgnoreCase("GLBL") || std.getRegionCode().equalsIgnoreCase(regionCode) ||	regionCode.equalsIgnoreCase(std.getRegionCode())){
										if(tags.length>0){
											for(int j=0;j<tags.length;j++){
												StandardTag existStdTag=StandardTagLocalServiceUtil.getStandardTagWithStdId(stdId,tags[j].trim());
												if(action.equalsIgnoreCase("add") && Validator.isNull(existStdTag)){
													addTags(Long.valueOf(entry.getKey()), tags[j].trim(), user.getUserId());
												}else if(action.equalsIgnoreCase("remove") && Validator.isNotNull(existStdTag) ){
			      									StandardTagLocalServiceUtil.deleteStandardTag(existStdTag);
												}
											}
										}
										String comments = "Tags - "+entry.getValue()+" are "+(action.equalsIgnoreCase("add")?"added":"deleted") +" for standard id " + Long.valueOf(entry.getKey()) ;
										updateWorkflow(user, std, comments);
									}else{
										notUpdatedIdsTags.put(String.valueOf(stdId),entry.getValue());
									}
								}
							}catch(NoSuchStandardsException e){
								notUpdatedIdsTags.put(String.valueOf(stdId),entry.getValue());
								LOG.error("Error in getting standard based on standarID: "+e.getMessage()); 
							}catch (SystemException e) {
								notUpdatedIdsTags.put(String.valueOf(stdId),entry.getValue());
								LOG.error("Error in upating tag for standards: "+e.getMessage()); 
							}catch (Exception e) {
								notUpdatedIdsTags.put(String.valueOf(stdId),entry.getValue());
								LOG.error("Error in upating tag for standards:"+e.getMessage()); 
							}
						 }		
					}
					
				} catch (PortalException e) {
					LOG.error("Error in upload file :"+e.getMessage()); 
				} catch (SystemException e1) {
					LOG.error("Error in upload file : "+e1.getMessage()); 
				}				
			}
			if(!stdIds.get("nullIds").isEmpty()){
				notUpdatedIdsTags.putAll(stdIds.get("nullIds"));
			}
			
			if(!notUpdatedIdsTags.isEmpty()){
				String fileName=getWorkbook(notUpdatedIdsTags);
				recordsjsonObject.put("xlsFile", fileName);
			}else{
				 recordsjsonObject.put("success", "true");
			}
			Map<String,String> failMsg=stdIds.get("failMsg");
			if(!failMsg.isEmpty()){
				for(Map.Entry<String,String> entry : failMsg.entrySet()){
					recordsjsonObject.put(entry.getKey(),entry.getValue());
				}
				recordsjsonObject.put("success", "false");
			}
		}	
		if(notUpdatedIdsTags.size()>0){
			 recordsjsonObject.put("fileAdded", "true");
		}
            resourceResponse.getWriter().print(recordsjsonObject.toString());
         
    }	

	public Map<String,Map<String,String>> getStandardsIdListForTag(File file,ResourceRequest actionRequest) throws InvalidFormatException, IOException
    {
		Map<String,Map<String,String>> IdsWithStatus=new HashMap<String,Map<String,String>>();
        Map<String,String> ids=new HashMap<String, String>();
        Map<String,String> nullIds=new HashMap<String, String>();
        Map<String,String> errorMsg=new HashMap<String, String>();
        Workbook workbook = WorkbookFactory.create(file);
        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
        // data should be always on first sheet
        Sheet sheet = workbook.getSheetAt(0);
        int rows = sheet.getPhysicalNumberOfRows();
       
        // map header column number to column name
        Row row = sheet.getRow(0);
        if (row != null)
        {
            HSSFDataFormatter formatter = new HSSFDataFormatter();
            // grab number of columns from first row - it is header row.
            
            Cell columnName=sheet.getRow(0).getCell(0);
            Cell columnName2=sheet.getRow(0).getCell(1);
            if(Validator.isNotNull(columnName) && !columnName.getStringCellValue().isEmpty() && columnName.getStringCellValue().equals("STD_ID")
            	&& Validator.isNotNull(columnName2)&& !columnName2.getStringCellValue().isEmpty() && columnName2.getStringCellValue().equals("Tags")){
            	int rowCount=1;
            	for(int i=1;i<=rows;i++){
					if(sheet.getRow(rowCount)!=null && sheet.getRow(rowCount).getCell(0)!=null
							&& sheet.getRow(rowCount).getCell(1)!=null){
						String tagNames=String.valueOf(WorkBookSpreadSheetUtil.getCellData(evaluator, sheet.getRow(rowCount).getCell(1), formatter));
						ids.put(String.valueOf(WorkBookSpreadSheetUtil.getCellData(evaluator, sheet.getRow(rowCount).getCell(0), formatter)),tagNames);
					}else if(sheet.getRow(rowCount)!=null && sheet.getRow(rowCount).getCell(1) != null){
						nullIds.put("0",String.valueOf(WorkBookSpreadSheetUtil.getCellData(evaluator, sheet.getRow(rowCount).getCell(1), formatter)));
					}else  if(sheet.getRow(rowCount)!=null && sheet.getRow(rowCount).getCell(0) != null){
						nullIds.put(String.valueOf(WorkBookSpreadSheetUtil.getCellData(evaluator, sheet.getRow(rowCount).getCell(0), formatter)),"null");
					}
                    rowCount++;
            	}
            }else{
            	//SessionErrors.add(actionRequest,"please-add-valid-columnname");
            	errorMsg.put("message", "Please add valid column");
            }
	    }else{
	    	//SessionErrors.add(actionRequest,"please-add-valid-file");
	    	errorMsg.put("message", "Please add valid file");
	    }
       IdsWithStatus.put("forDB",ids);
       IdsWithStatus.put("nullIds", nullIds);
       IdsWithStatus.put("failMsg",errorMsg);
       return IdsWithStatus;
     }
	
	  
    
     /**
     * Update Audit log.
     * 
     * @param user - user
     * @param std - record
     * @param comments - comments
     * @throws SystemException - exception on addWorkflow.
     * @throws PortalException 
     */
    private static void updateWorkflow(final User user, Standards std, final String comments)
            throws SystemException, PortalException
    {
        List<ChainStandards> brands = ChainStandardsLocalServiceUtil.getChainStandardsByStdId(std.getStdId());
        
        if (!StandardsUtil.IsNullOrBlank(brands))
        {
            for (ChainStandards chnStd : brands)
            {
                String brandCd = chnStd.getChainCode();
                Workflow lastLog = WorkflowLocalServiceUtil.getLastLogBySTDObjectId(std.getStdId(), brandCd);
                addAuditLog(user, std, comments, lastLog, brandCd, chnStd);
            }
        }
        else 
        {
            Workflow lastLog = WorkflowLocalServiceUtil.getLastLogBySTDObjectId(std.getStdId());
            addAuditLog(user, std, comments, lastLog, null, null);
        }
    }


   public void downloadFile(final ResourceRequest request, final ResourceResponse response) throws IOException, PortletException {
		final String downloadDirectoryPath = System.getProperty("java.io.tmpdir");
		String fileName=ParamUtil.getString(request,"fileName","");
		if(Validator.isNotNull(fileName) || fileName.length()>0){
		final File outputFile = new File(downloadDirectoryPath, fileName);
		response.setContentType("text/plain");
		response.addProperty("Content-disposition", "atachment; filename="+fileName);
		OutputStream out = null;
		InputStream in = null;
		try {
			out = response.getPortletOutputStream();
			in = new FileInputStream(outputFile);
			IOUtils.copy(in, out);		
		} catch (final IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (Validator.isNotNull(out)) {
					out.flush();
					out.close();
				}
				if (Validator.isNotNull(in)) {
					in.close();
				}

			} catch (final IOException e) {
				e.printStackTrace();
			}
		}	
		}
	}
    /**
     * Create Audit log entry
     * @param user user
     * @param std standard
     * @param comments comments
     * @param lastLog last log entry
     * @param brandCd brand
     * @throws SystemException exception
     * @throws PortalException 
     */
    private static void addAuditLog(final User user, Standards std, final String comments, Workflow lastLog, String brandCd, ChainStandards chnStd) throws SystemException, PortalException
    {
        final long wrkflowId = CounterLocalServiceUtil.increment(Workflow.class.getName());
        final Workflow workflow = WorkflowLocalServiceUtil.getWorkflowObject();
        workflow.setWorkflowActvtId(wrkflowId);
        String newStatus = StringPool.BLANK;
        String prevStatus = StringPool.BLANK;
        String chainCd;
        
        
        if (StandardsUtil.IsNullOrBlank(lastLog))
        {
            newStatus = StandardsStatusUtil.getDefaultStatus(std.getRegionCode());
            chainCd = brandCd;
            prevStatus = newStatus;
        }
        else
        {
            if (!StandardsUtil.IsNullOrBlank(chnStd))
            {
            	newStatus = StandardsStatusLocalServiceUtil.getStandardsStatus(chnStd.getStatusId()).getStatusCode();
            }
            else
            {
            	newStatus = lastLog.getStatus();
            }
            prevStatus = lastLog.getStatus();
            chainCd = lastLog.getChainCode();
        }
        workflow.setStatus(newStatus);
        workflow.setPrevStatus(prevStatus);
        workflow.setObjectId(std.getStdId());
        workflow.setObjectType(std.getStdTyp());
        workflow.setCreatedBy(user.getScreenName());
        workflow.setUpdatedBy(String.valueOf(user.getUserId()));
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        workflow.setUpdatedDate(calendar.getTime());
        workflow.setCreatedDate(calendar.getTime());
        workflow.setCreatorId(String.valueOf(user.getUserId()));
        workflow.setComment(comments);
        workflow.setChainCode(chainCd);
        if (std.getStdTyp().equals(StandardsUtil.STD_TYPE_GDLN))
        {
            workflow.setTitle(std.getDescription());
        }
        else
        {
            workflow.setTitle(std.getTitle());
        }
        
        WorkflowLocalServiceUtil.addWorkflow(workflow);
    }
    
    /**
     * Get preferences by passing request for common request.
     * @param portletRequest
     * @return
     */
    public static Preferences getPreferences(PortletRequest portletRequest)
    {
    	 final HttpServletRequest hsrw = PortalUtil.getHttpServletRequest(portletRequest);
         final HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(hsrw);
         return  (Preferences)httpRequest.getSession().getAttribute("Preferences");
    }
    
    /**
     * Get region code based on login user.
     * @param preferences
     * @param user
     * @param isSuperAdmin
     * @return
     * @throws SystemException
     */
    public static String getRegionCode(Preferences preferences, User user, boolean isSuperAdmin) throws SystemException
    {
    	String regionCode = StringPool.BLANK;
    	if (!BrandStandardsUtil.IsNullOrBlank(preferences))
    	{
    		if (isSuperAdmin) 
    	
	        {
	        	regionCode = preferences.getRegionCode();
	        }
	    	else
	    	{
	    		regionCode  = StandardsController.getRegionCodeFromUserRole(user.getRoles());
	    	}
    	}
    	return regionCode;
    }
}
