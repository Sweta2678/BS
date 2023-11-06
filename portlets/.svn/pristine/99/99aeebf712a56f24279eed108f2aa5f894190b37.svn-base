package com.ihg.brandstandards.bridge.portlet;

import com.ihg.brandstandards.bridge.model.BridgePublishAppModel;
import com.ihg.brandstandards.bridge.util.BridgeCommonUtil;
import com.ihg.brandstandards.bridge.util.MustPublishUtilities;
import com.ihg.brandstandards.bridge.util.SpreadsheetUtil;
import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.db.NoSuchChainStandardsException;
import com.ihg.brandstandards.db.model.BridgePublishPreview;
import com.ihg.brandstandards.db.model.ChainStandards;
import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.StandardsCountryExt;
import com.ihg.brandstandards.db.service.BridgeGlobalPublishLocalServiceUtil;
import com.ihg.brandstandards.db.service.BridgePublishPreviewLocalServiceUtil;
import com.ihg.brandstandards.db.service.ChainStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublicationLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsCountryExtLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocalServiceUtil;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.ArrayUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/***
 * 
 * @author ketan.savaliya
 *
 */
public class MustPublishPortlet extends BrandStandardsBridgePortlet 
{
	 private static final Log LOG = LogFactoryUtil.getLog(MustPublishPortlet.class);
	 
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
	{
		
		long userId = PortalUtil.getUserId(renderRequest);
        if (userId > 1)
        {
        	boolean publicationLocked = false;
        	boolean isStagePublicationExist = false;
        	HttpServletRequest request = getHttpRequest(renderRequest);
        	HttpSession session = getHttpSession(request);
        	PortletPreferences preference = MustPublishUtilities.getPreferances(renderRequest);
			boolean isMust = true;
			long bridgePublishId = 0;
			Preferences userPreferences = getBridgeUserPreferences(renderRequest);
	        String brand = userPreferences.getBrand();
	        if(preference != null) 
	        {
	        	String isMustPublish = preference.getValue("type", "Y");
	        	if ("Y".equals(isMustPublish)) 
	        	{
	        		isMust = true;
	        	} 
	        	else 
	        	{
	        		isMust = false;
	        	}
	        }
			try {
				if (Validator.isNotNull(brand)) {
					bridgePublishId = PublicationLocalServiceUtil.getPublishIdByBrand(brand, "BRIDGE");
				}
			} catch (SystemException e) {
				LOG.error(e.getMessage(), e);
			}
			long issueCount = MustPublishUtilities.getIssueCount(isMust ? "Y" : "N", bridgePublishId, brand);
			List<BridgePublishAppModel> display = MustPublishUtilities.getMustPublishStandardsList(renderRequest, brand, isMust); 
            
            
            StringBuilder stdIdLst = new StringBuilder();
            for (BridgePublishAppModel std : display)
            {
                addStdId(stdIdLst, std);
                
                for (BridgePublishAppModel rec : std.getSpecifications())
                {
                    addStdId(stdIdLst, rec);
                }
                for (BridgePublishAppModel rec : std.getGuidelines())
                {
                    addStdId(stdIdLst, rec);
                }
            }
            renderRequest.setAttribute("reportId", 117);
            session.setAttribute("stdIdLst", stdIdLst.toString());

            SearchContainer<BridgePublishAppModel> searchContainer = BridgeCommonUtil.getBridgePublishAppSearchContainer(renderRequest, renderResponse);
            searchContainer.setTotal(display.size());
            display = ListUtil.subList(display, searchContainer.getStart(), searchContainer.getEnd());
            searchContainer.setEmptyResultsMessage("No Standards Available");
            searchContainer.setResults(display);
            renderRequest.setAttribute("searchContainerObj", searchContainer);
            
            //Global flags to verify whether any publication is in progress or not
            if (session.getAttribute("publicationLocked") != null)
            {
                publicationLocked = GetterUtil.getBoolean(StringPool.BLANK + session.getAttribute("publicationLocked"), false);
            }
            //check whether any stage publication is active or not.
            if (session.getAttribute("isStagePublicationExist") != null)
            {
                isStagePublicationExist = GetterUtil.getBoolean(StringPool.BLANK + session.getAttribute("isStagePublicationExist"), false);
            }
            
            if (LOG.isDebugEnabled()) {
            	LOG.debug("publicationLocked :"+publicationLocked);
            	LOG.debug("isStagePublicationExist :"+isStagePublicationExist);
            }
            
			//renderRequest.setAttribute("displayStd", display);
            renderRequest.setAttribute("brand",renderRequest.getParameter("brand"));
            renderRequest.setAttribute("issueCount", issueCount);
			renderRequest.setAttribute("loggedIn", true);
			renderRequest.setAttribute("isMust", isMust);
			renderRequest.setAttribute("publicationLocked", publicationLocked);
			renderRequest.setAttribute("isStagePublicationExist", isStagePublicationExist);
			renderRequest.setAttribute("bridgePublishId", bridgePublishId);
        } 
        else 
        {
        	renderRequest.setAttribute("loggedIn", false);
        }
		super.doView(renderRequest, renderResponse);
	}
	
    private void addStdId(StringBuilder stdIdLst, BridgePublishAppModel std)
    {
        if (stdIdLst.length() > 0)
        {
            stdIdLst.append(":::");
        }
        stdIdLst.append(std.getStdId());
    }

	/**
	 * This processAction is importing data from xls file.
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortletException
	 */
	public void importMustPublish(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException
	{
		String error = StringPool.BLANK ;
		/*PortletPreferences preference = MustPublishUtilities.getPreferances(actionRequest);
		String isMustPublish =StringPool.BLANK;
        if(preference != null) 
        {
        	isMustPublish = preference.getValue("type", "Y");
        }*/
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        Preferences userPreferences = getBridgeUserPreferences(actionRequest);
        String brand = userPreferences.getBrand();
        long publishId = MustPublishUtilities.getActivePublishIdByBrand(brand);
        //Map<String,String> idsMap=new HashMap<String, String>();
        List<Long> stdIds;
        Map<String,String> resultMap=new HashMap<String,String>();
		try 
		{
			stdIds = SpreadsheetUtil.getStandardsIdList(actionRequest);
			if (stdIds.size() > 0 )
			{
				String stdIdsCommaSeparated = stdIds.toString().replace("[", "").replace("]", "").replace(", ", ",");
				//validateStdIds(stdIdsCommaSeparated, brand,statusMap);
				try {
					resultMap=BridgeGlobalPublishLocalServiceUtil.importGlobalMustPublishStandards(publishId, brand, themeDisplay.getUser().getScreenName(), stdIdsCommaSeparated);
				} catch (SystemException e) {
					LOG.error(e);
				}
				
				
				
				
				/*StringBuilder standNotFound=new StringBuilder();
				StringBuilder StandNotGlobal=new StringBuilder();
				StringBuilder StandNotBrand=new StringBuilder();
				StringBuilder StandDeleted=new StringBuilder();
				StringBuilder Others=new StringBuilder();
				if(Validator.isNotNull(IdList)){
					String[] ids=IdList.split(",");
					for(int i=0;i<ids.length;i++){
					try {
					Standards std=StandardsLocalServiceUtil.getStandards(Long.valueOf(ids[i]));
						if(Validator.isNull(std)){
							standNotFound.append(ids[i]+",");
						}
						else{
							ChainStandards chstds=null;
							try{
							 chstds=ChainStandardsLocalServiceUtil.getChainStandardsByChainCode(Long.valueOf(ids[i]), brand);
							}catch(NoSuchChainStandardsException ex){
								
							}	
							if( Validator.isNotNull(chstds)){
									if(!std.getRegionCode().equals("GLBL")){
										StandNotGlobal.append(ids[i]+",");
									}else if(std.getStatus().equals("DELETED")){
										StandDeleted.append(ids[i]+",");
									}else{
										Others.append(ids[i]+",");
									}
									
								}
								else if(chstds == null){
									StandNotBrand.append(ids[i]+",");
								}
								else{
									Others.append(ids[i]+",");
								}
							
							
						}
						
					} catch (NumberFormatException | PortalException
							| SystemException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
					}
				}
				idsMap.put("Standard not found",(standNotFound.toString().equals("")? "0":standNotFound.toString().substring(0, standNotFound.toString().length() - 1)));
				idsMap.put("Standard does not belong to this brand",(StandNotBrand.toString().equals("")? "0":StandNotBrand.toString().substring(0, StandNotBrand.toString().length() - 1)));
				idsMap.put("Standard is not global",(StandNotGlobal.toString().equals("")? "0":StandNotGlobal.toString().substring(0, StandNotGlobal.toString().length() - 1)));
				idsMap.put("Standard is Deleted",(StandDeleted.toString().equals("")? "0":StandDeleted.toString().substring(0, StandDeleted.toString().length() - 1)));
				idsMap.put("Other",(Others.toString().equals("")? "0":Others.toString().substring(0, Others.toString().length() - 1)));*/
				//MustPublishUtilities.importStandards(stdIds, brand, userId, publishId, isMustPublish);
			}
		} 
		catch (InvalidFormatException e) 
		{
			LOG.error(StackTraceUtil.getStackTrace(e));
			error = e.getMessage();
		} 
		catch (IOException e) 
		{
			LOG.error(StackTraceUtil.getStackTrace(e));
			error = e.getMessage();
		}
		
		//session.setAttribute("idsMap",idsMap);
		HttpServletRequest hsrw = PortalUtil.getHttpServletRequest(actionRequest);
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(hsrw);
		HttpSession session=httpRequest.getSession();
		session.setAttribute("result_ids", resultMap.get("result_ids"));
		Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap();
		//actionResponse.setRenderParameter("result_ids",resultMap.get("result_ids"));
		actionResponse.setRenderParameter("fileName",resultMap.get("fileName"));
		//actionResponse.setRenderParameter("filePath",resultMap.get("filePath"));
		actionResponse.setRenderParameter("recordCount",resultMap.get("recordCount"));
		actionResponse.setRenderParameter("brand",chnCdMap.get(brand));
		actionRequest.setAttribute("error", error);
		
	}
	
	
	
	
	/**
	 * This processAction is add entry by ids in mustpublish.
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortletException
	 */
	public void addMustPublish(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException 
	{
		PortletPreferences preference = MustPublishUtilities.getPreferances(actionRequest);
		String isMustPublish =StringPool.BLANK;
        if(preference != null) 
        {
        	isMustPublish = preference.getValue("type", "Y");
        }
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long userId = themeDisplay.getUserId();
        long publishId = 0;
        Preferences userPreferences = getBridgeUserPreferences(actionRequest);
        String brand = userPreferences.getBrand();
		publishId = MustPublishUtilities.getActivePublishIdByBrand(brand);
		String stdIds = ParamUtil.getString(actionRequest, "addByIds");
		List<Long> stdIdList = Arrays.asList(ArrayUtils.toObject(StringUtil.split(stdIds, 1l)));
		
		if (stdIdList.size() > 0 )
		{
			MustPublishUtilities.importStandards(stdIdList, brand, userId, publishId, isMustPublish);
		}
		if (actionRequest.getParameter("findId") != null)
		{
			actionResponse.setRenderParameter("findId", actionRequest.getParameter("findId"));
		}
	}
	
	/**
	 * This processAction is delete selected mustpublish std
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortletException
	 */
	public void deleteStandards(ActionRequest actionRequest, ActionResponse actionResponse)
	{
		Preferences userPreferences = getBridgeUserPreferences(actionRequest);
        String brand = userPreferences.getBrand();
		String error = MustPublishUtilities.deleteMustPublishStandrd(actionRequest, actionResponse, brand);
		actionRequest.setAttribute("error", error);
	}
	
	/**
	 * This is portlet serveResource(), is use for popup showing for region specific 
	 * @param resourceRequest
	 * @param resourceResponse
	 * @return
	 * @throws PortletException
	 * @throws IOException
	 */
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException
	{
		final String resourceID = resourceRequest.getResourceID();
		HttpServletRequest hsrw = PortalUtil.getHttpServletRequest(resourceRequest);
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(hsrw);
		Preferences userPreferences = getBridgeUserPreferences(resourceRequest);
        String brand = userPreferences.getBrand();
        if("getCSVData".equals(resourceID)){
        	downloadStdIdsExcelFile(resourceRequest,resourceResponse);
        }
		if ("regionCountryList".equals(resourceID))
		{
			long stdId = ParamUtil.getLong(resourceRequest, "stdId");
			long regionId = ParamUtil.getLong(resourceRequest,"rgnId");
			String regionCode = ParamUtil.getString(resourceRequest,"rgnCode");
			try 
			{
			    Map<String, List<String>> subRegionCountryMap = BrandStandardsUtil.getSubRegionCountriesForRegion(regionCode);
                Map<String, String> countryNameMap = BrandStandardsUtil.getCountryNamesForRegion(regionCode);
				long publishId = PublicationLocalServiceUtil.getPublishIdByBrand(brand, "BRIDGE");
				Map<String, StandardsCountryExt> countryDetailMap = new LinkedHashMap<String, StandardsCountryExt>();
				List<StandardsCountryExt> countryList = StandardsCountryExtLocalServiceUtil.getCountryListByStdIdAndRegionId(stdId, regionId, publishId);
				for (StandardsCountryExt cntry : countryList)
				{
					countryDetailMap.put(cntry.getCountryCode(), cntry);
				}
				httpRequest.setAttribute("regionCode",regionCode);
				httpRequest.setAttribute("bridgeGblPubId",	BridgeGlobalPublishLocalServiceUtil.getByPublishIdAndStdId(publishId, stdId).getGlobalPublishId());
				httpRequest.setAttribute("subRegionCountryMap", subRegionCountryMap);
				httpRequest.setAttribute("countryDetailMap", countryDetailMap);
				httpRequest.setAttribute("countryNameList", countryNameMap);
				include("/html/mustPublish/popup.jsp", resourceRequest, resourceResponse);
	        }
	        catch (IOException e)
	        {
	        	LOG.error(StackTraceUtil.getStackTrace(e));
	        }
	        catch (PortletException e)
	        {
	        	LOG.error(StackTraceUtil.getStackTrace(e));
	        } catch (SystemException e) {
	        	LOG.error(StackTraceUtil.getStackTrace(e));
			}
		}
		else if("addByIdSearch".equals(resourceID))
		{
			String stdIds = ParamUtil.getString(resourceRequest, "stdId");
			PortletPreferences preference = MustPublishUtilities.getPreferances(resourceRequest);
			boolean isMust = true;
			boolean isEntiretyAdded = true;
	        if(preference!=null) 
	        {
	        	if ("Y".equals(preference.getValue("type", "Y")))
	        	{
	        		isMust = true;
	        	} 
	        	else 
	        	{
	        		isMust = false;
	        	}
	        }
			List<BridgePublishAppModel> display = new ArrayList<BridgePublishAppModel>();
			try 
			{
				long bridgePublishId = PublicationLocalServiceUtil.getPublishIdByBrand(brand, "BRIDGE");
				String messageText = MustPublishUtilities.getValidationMessage(bridgePublishId, stdIds, brand, isMust);
				if(!messageText.contains("you can’t publish this Standard ID"))
				{
					List<BridgePublishPreview> list =  BridgePublishPreviewLocalServiceUtil.searchStandardsById(stdIds, brand, isMust);
					isEntiretyAdded = MustPublishUtilities.fillAddByIdSearchPojoList(list, display);
				}
				if(!isEntiretyAdded)
				{
					httpRequest.setAttribute("stdList", display);
				} 
				else if(messageText.isEmpty()) 
				{
					messageText = "Standard ID [" + stdIds + "] already added in its entirety";
				}
				if(!messageText.isEmpty())
				{
					 httpRequest.setAttribute("messageText", messageText);
				}
			} 
			catch (SystemException e) 
			{
				LOG.error(StackTraceUtil.getStackTrace(e));
			} 
			catch (PortalException e) 
			{
				LOG.error(StackTraceUtil.getStackTrace(e));
			}
			resourceRequest.setAttribute("isMust", isMust);
			include("/html/mustPublish/addById.jsp", resourceRequest, resourceResponse);
		} 
		else if ("exportReport".equals(resourceID))
        {
		    submitReportRequest(resourceRequest, resourceResponse, true);
        }
	}

	private void downloadStdIdsExcelFile(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		// TODO Auto-generated method stub
		String fileName=ParamUtil.getString(resourceRequest,"fileName",null);
		if(Validator.isNotNull(fileName) && fileName.length()>0){
			resourceResponse.setContentType("text/html");  
			try {
				String filePath=System.getProperty("java.io.tmpdir")+"/"+ fileName;
				 File file=new File(filePath);
				FileInputStream fileInputStream = new FileInputStream(filePath);  
			byte[] bytesArray = new byte[(int) file.length()];
	            fileInputStream.read(bytesArray);
	            String contentType = ContentTypes.APPLICATION_TEXT;
	            PortletResponseUtil.sendFile(resourceRequest, resourceResponse,
	       			 fileName, bytesArray, contentType);
				fileInputStream.close();   
				resourceRequest.setAttribute("Success","Perfect");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			
			   
			}  
		
	}

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
	{
		PortletPreferences prefs = renderRequest.getPreferences();
		renderRequest.setAttribute("type", prefs.getValue("type","Y"));
		super.doEdit(renderRequest, renderResponse);
	}
	
	/**
     * set the preferences for Portlet
     * @param request
     * @param response
     * @throws PortalException
     * @throws SystemException
     */
    public void setPreferences(ActionRequest request, ActionResponse response) throws PortalException, SystemException
    {
        // Storing preferences
        try
        {
        	PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(request);
            preferences.setValue("type", request.getParameter("type"));
            preferences.store();
        }
        catch (ReadOnlyException e)
        {
        	LOG.error(StackTraceUtil.getStackTrace(e));
        } 
        catch (ValidatorException e)
        {
        	LOG.error(StackTraceUtil.getStackTrace(e));
        } 
        catch (IOException e)
        {
        	LOG.error(StackTraceUtil.getStackTrace(e));
        }
    }
    
    /**
     * Method is use to set View mode of portlet, it's use for coming back from edit mode
     * @param actionRequest
     * @param actionResponse
     * @throws IOException
     * @throws PortletException
     */
    public void setPortletMode(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
		actionResponse.setPortletMode(PortletMode.VIEW);
	}
    
}