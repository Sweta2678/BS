package com.ihg.brandstandards.gem.portlet;

import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.db.model.GEMManagementId;
import com.ihg.brandstandards.db.service.GEMManagementIdLocalServiceUtil;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.ihg.me2.utils.session.MerlinCache;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.util.PortalUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/**
 * 
 * @author AkhaniC
 *
 */
public class GEMManagementIdPortlet extends  BrandStandardsGemPortlet {

	public static final String CHAIN_BRAND = "CHAIN_BRAND";

    private static final Log LOG = LogFactoryUtil.getLog(GEMManagementIdPortlet.class);
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		//Get User Region and Brand
		Preferences preferences = getGEMUserPreferences(renderRequest);
		long regionId = BrandStandardsUtil.getRegionId(preferences.getRegionCode());
		String brandCode = preferences.getBrand();
		String brandName = brandCode;
		String errorMessage = "";
		try 
		{
			
			Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap();
	        Map<String, Object> subBrandCacheMap = (Map<String, Object>) MerlinCache.getCacheData(CHAIN_BRAND);
	        
			if(chnCdMap != null && chnCdMap.size() > 0 && brandCode != null && subBrandCacheMap!=null && subBrandCacheMap.size() > 0) 
			{
				brandName =	chnCdMap.get(brandCode);
				String subBrands = null;
				// Get SubBrands.
				//Get All active brand / sub - brand from merlin cache
				if(brandCode.equals("CR"))
				{
					subBrands = (String) subBrandCacheMap.get("CP");
				}
				else 
				{
					subBrands = (String) subBrandCacheMap.get(brandCode);
				}
				if(subBrands!=null && !subBrands.equals(""))
				{
					
					//Get All management Ids for current brand and region
					List<GEMManagementId> managementIds = GEMManagementIdLocalServiceUtil.getManagementIdsByRegionAndBrand(regionId, subBrands);
					// Structure is Map<Country, SubBrand<ManageId>>
					Map<String, Map<String, GEMManagementId>> managementIdsMap = new HashMap<String, Map<String,GEMManagementId>>();
					if(managementIds!=null && managementIds.size() > 0)
					{
						for(GEMManagementId managementId : managementIds)
						{
							if(managementIdsMap.get(managementId.getCountryCode())==null)
							{
								Map<String, GEMManagementId> brandMap = new HashMap<String, GEMManagementId>();
								brandMap.put(managementId.getChainCode(), managementId);
								managementIdsMap.put(managementId.getCountryCode(), brandMap);
							}
							else
							{
								Map<String, GEMManagementId> brandMap = managementIdsMap.get(managementId.getCountryCode());
								brandMap.put(managementId.getChainCode(), managementId);
							}										
						}
					}
					renderRequest.setAttribute("brand", brandCode);
					renderRequest.setAttribute("brandName", brandName);
					String[]  subBrandArr = subBrands.split(","); 
					Arrays.sort(subBrandArr);
					List<String> subBrandList = Arrays.asList(subBrandArr);
					renderRequest.setAttribute("subBrands", subBrandList);
					renderRequest.setAttribute("managementIds", managementIdsMap);
					renderRequest.setAttribute("allCountries", BrandStandardsUtil.getCountryNamesForRegion(preferences.getRegionCode()));
				}
				else
				{
					errorMessage = "Brand Cache data not available.";
					renderRequest.setAttribute("errorMessage", errorMessage);
				}
			}
			else
			{
				errorMessage = "Brand Cache data not available.";
				renderRequest.setAttribute("errorMessage", errorMessage);
			}
		}
		catch (Exception exc) {
			
		}
		super.doView(renderRequest, renderResponse);
	}

    @ProcessAction(name = "saveManageIdAction")
    public void saveManageIdAction(ActionRequest actionRequest,
            ActionResponse actionResponse) throws IOException, PortletException 
    {
        String message = BridgeConstants.SUCCESS_MESSAGE;
        System.out.println("1111111111111111");
        message = saveManageIds(actionRequest);
        LOG.debug("Message " + message);
    }

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
	       final String resourceID = resourceRequest.getResourceID();
	       if ("editManageIdURL".equalsIgnoreCase(resourceID))
	       {
	          showManagementId(resourceRequest, resourceResponse); 
	       }

		super.serveResource(resourceRequest, resourceResponse);
	}
	
    private String saveManageIds(ActionRequest actionRequest)
    {
       String message = BridgeConstants.SUCCESS_MESSAGE;
       String countryCode = ParamUtil.get(actionRequest, "countryCode", StringPool.BLANK);
       String brandCode = ParamUtil.get(actionRequest, "brandCode", StringPool.BLANK);
       final long userId = PortalUtil.getUserId(actionRequest);
	   // Get SubBrands.
       Map<String, Object> subBrandCacheMap = (Map<String, Object>) MerlinCache.getCacheData(CHAIN_BRAND);
       String subBrands = null;
		if(brandCode.equals("CR"))
		{
			subBrands = (String) subBrandCacheMap.get("CP");
		}
		else 
		{
			subBrands = (String) subBrandCacheMap.get(brandCode);
		}
       
       String[]  subBrandArr = subBrands.split(",");
       if(countryCode!=null && countryCode.length() > 0 &&  subBrands!=null && subBrands.length() > 0)
       {
    	   for(String subBrand : subBrandArr)
    	   {
			   String newValue = ParamUtil.get(actionRequest, subBrand, StringPool.BLANK);
    		   try
    		   {   
    			   GEMManagementId manageId = GEMManagementIdLocalServiceUtil.getManagementIdsByCountryAndBrand(countryCode, subBrand);
    			   if(manageId!=null && newValue!=null)
	               {
    				   if(!newValue.equals(StringPool.BLANK))
    				   {
	    				   manageId.setValue(newValue);
	                	   manageId.setUpdatedBy(userId+"");
	                	   manageId.setUpdatedDate(new Date());
	    				   GEMManagementIdLocalServiceUtil.updateGEMManagementId(manageId);
    				   }
    				   else
    				   {
    					   GEMManagementIdLocalServiceUtil.deleteGEMManagementId(manageId);
    				   }
	               }
	            }
                catch (Exception e)
                {
                   if(newValue!=null && !newValue.equals(StringPool.BLANK))
 	               {
                	   GEMManagementId manageId;
                	   try 
                	   {
                		   manageId = GEMManagementIdLocalServiceUtil.createGEMManagementId(CounterLocalServiceUtil.increment(GEMManagementId.class.getName()));
                		   manageId.setCountryCode(countryCode);
                		   manageId.setChainCode(subBrand);
                		   manageId.setValue(newValue);
                		   manageId.setCreatorId(userId+"");
                		   manageId.setCreatedDate(new Date());
                		   manageId.setUpdatedBy(userId+"");
                		   manageId.setUpdatedDate(new Date());
                		   GEMManagementIdLocalServiceUtil.updateGEMManagementId(manageId);
						} catch (SystemException e1) {
							LOG.error(e1.getMessage());
						}
 	               }
                }
    	   }
       }
       return message;
    }

	private PortletRequestDispatcher showManagementId(final ResourceRequest resourceRequest,
            final ResourceResponse resourceResponse)
            throws PortletException, IOException
    {
        String countryCode  =  resourceRequest.getParameter("countryCode");
        String brandCode  =  resourceRequest.getParameter("brandCode");
		// Get SubBrands.
        Map<String, Object> subBrandCacheMap = (Map<String, Object>) MerlinCache.getCacheData(CHAIN_BRAND);
        String subBrands = null;
		if(brandCode.equals("CR"))
		{
			subBrands = (String) subBrandCacheMap.get("CP");
		}
		else 
		{
			subBrands = (String) subBrandCacheMap.get(brandCode);
		}
		
		String[]  subBrandArr = subBrands.split(",");
        Map<String, GEMManagementId> manageIdsMap = new HashMap<String, GEMManagementId>();

       if(countryCode!=null && countryCode.length() > 0 &&  brandCode!=null && brandCode.length() > 0)
       {
    	   for(String subBrand : subBrandArr)
    	   {
    		   try
    		   {            	
    			   GEMManagementId manageId = GEMManagementIdLocalServiceUtil.getManagementIdsByCountryAndBrand(countryCode, subBrand);
    			   if(manageId!=null)
	               {
    				   manageIdsMap.put(manageId.getChainCode(), manageId);
	               }
	            }
                catch (Exception e)
                {
                    manageIdsMap.put(subBrand, null);
                }
    	   }
       }
		String brandName = brandCode;
		Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap();		
		if(chnCdMap != null && brandCode != null) {
			brandName =	chnCdMap.get(brandCode);
		}
       resourceRequest.setAttribute("country", countryCode);
       resourceRequest.setAttribute("brandName", brandName);
       resourceRequest.setAttribute("brand", brandCode); 
       resourceRequest.setAttribute("managementIds", manageIdsMap);
       final PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/html/GEM/managementId/editManageId.jsp");
       dispatcher.include(resourceRequest, resourceResponse);
       return dispatcher;
    }
}
