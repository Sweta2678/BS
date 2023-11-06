package com.ihg.brandstandards.portlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ihg.brandstandards.db.NoSuchStandardsRegionChainException;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.PublishCountryStandard;
import com.ihg.brandstandards.db.model.PublishStd;
import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.StandardsCountryChain;
import com.ihg.brandstandards.db.service.PublicationLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublishCountryStandardLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublishStdLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsCountryChainLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionChainLocalServiceUtil;
import com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK;
import com.ihg.brandstandards.db.service.persistence.StandardsRegionChainPK;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class EditComplianceDeadlinePortlet extends MVCPortlet
{

    private static final Log LOG = LogFactoryUtil.getLog(EditComplianceDeadlinePortlet.class);

    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        final HttpServletRequest hsrw = PortalUtil.getHttpServletRequest(renderRequest);
        final HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(hsrw);
        List<StandardsCountryChain> chains = Collections.emptyList();
        long stdId = ParamUtil.getLong(httpRequest, "stdId", 0L);
        long timeInMilis = ParamUtil.getLong(httpRequest, "deadlineDate", 0L);
        String brandCode = ParamUtil.get(httpRequest, "brandCode", StringPool.BLANK);
        //&caloption="+filterOn+"&between="+fromDate+"&and="+toDate+"&search="+stdString+"&isNotMatch="+isNonMatch;";
        //Added for defect 5678
        String caloption = ParamUtil.get(httpRequest, "caloption", StringPool.BLANK);
        String between = ParamUtil.get(httpRequest, "between", StringPool.BLANK);
        String andVal = ParamUtil.get(httpRequest, "and", StringPool.BLANK);
        String search = ParamUtil.get(httpRequest, "Search", StringPool.BLANK);
        HttpSession session = httpRequest.getSession();
        String isNotMatch = ParamUtil.get(httpRequest, "isNotMatch", StringPool.BLANK);
        if(Validator.isNull(isNotMatch))
        {
        	isNotMatch = (String)session.getAttribute("isNotMatch");
        }
        
        
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(timeInMilis);
        c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), 0, 0, 0);
        Date compDate = c.getTime();
        Standards std = null;
        String expireIds = StringPool.BLANK;
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String date = df.format(compDate);
        Map<String, Map<String, String>> regionCountries = new LinkedHashMap<String, Map<String, String>>();
        Map<String, Map<String, String>> regionMap = BrandStandardsUtil.getCountries();
        Map<String, Map<String, String>> regionMapModified = new HashMap<String, Map<String,String>>(regionMap);
        Map<String, String> countriesEditable = new HashMap<String, String>();
        try
        {
            //chains = StandardsCountryChainLocalServiceUtil.getStandardsCountryChains(stdId, brandCode, compDate);
            chains = StandardsCountryChainLocalServiceUtil.getStandardsChain(stdId, brandCode);
            std = StandardsLocalServiceUtil.getStandards(stdId);
            try
            {
                expireIds = StandardsRegionChainLocalServiceUtil.getStandardsRegionChain(
                        new StandardsRegionChainPK(stdId, BrandStandardsUtil.REGION_GLOBAL, brandCode)).getExpiredIds();
            }
            catch (NoSuchStandardsRegionChainException e)
            {
                LOG.error("Error while fetching expireIds->" + e.getMessage());
            }
            catch (Exception e)
            {
                LOG.error("Error while fetching expireIds==>" + e.getMessage(), e);
            }
            for (StandardsCountryChain countryChain : chains)
            {
                Map<String, String> countrys = regionMap.get(countryChain.getRegionCode());
                if (regionCountries.containsKey(countryChain.getRegionCode()))
                {
                    Map<String, String> countries = regionCountries.get(countryChain.getRegionCode());
                    countries.put(countryChain.getCountryCode(), countrys.get(countryChain.getCountryCode()));
                    countriesEditable.put(countryChain.getCountryCode(), "true");
                }
                else
                {
                    Map<String, String> countries = new LinkedHashMap<String, String>();
                    countries.put(countryChain.getCountryCode(), countrys.get(countryChain.getCountryCode()));
                    regionCountries.put(countryChain.getRegionCode(), countries);
                    countriesEditable.put(countryChain.getCountryCode(), "true");
                }
            }
            for(String regions : regionMap.keySet())
            {
                if(!regionCountries.containsKey(regions) && regionMapModified.containsKey(regions))
                {
                    regionMapModified.remove(regions);
                }
                
                
            }
        }
        catch (SystemException e)
        {
            LOG.error("Error while fetching countrychains" + e.getMessage());
        }
        catch (PortalException e)
        {
            LOG.error("Error while fetching standard" + e.getMessage());
        }
        renderRequest.setAttribute("std", std);
        renderRequest.setAttribute("expireIds", expireIds);
        renderRequest.setAttribute("brandCode", brandCode);
        renderRequest.setAttribute("defaultDate", date);
        renderRequest.setAttribute("regionMapModified", regionMapModified);
        renderRequest.setAttribute("countriesEditable", countriesEditable);
        //Added field for Defect 5678
        renderRequest.setAttribute("caloption", caloption);
        renderRequest.setAttribute("between", between);
        renderRequest.setAttribute("andVal", andVal);
        renderRequest.setAttribute("Search", search);
        renderRequest.setAttribute("isNotMatch", isNotMatch);
        
        super.doView(renderRequest, renderResponse);
    }

    /**
     * Set Deadline date.
     * @param actionRequest
     * @param actionResponse
     * @throws IOException
     * @throws PortletException
     */
    public void setDeadlineDates(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
        String defaultDate = ParamUtil.get(actionRequest, "defaultDate", StringPool.BLANK);
        String brandCode = ParamUtil.get(actionRequest, "brandCode", StringPool.BLANK);
        
        //Added for defect 5678
        String caloption = ParamUtil.get(actionRequest, "caloption", StringPool.BLANK);
        String between = ParamUtil.get(actionRequest, "between", StringPool.BLANK);
        String andVal = ParamUtil.get(actionRequest, "andVal", StringPool.BLANK);
        String search = ParamUtil.get(actionRequest, "Search", StringPool.BLANK);
        String isNotMatch = ParamUtil.get(actionRequest, "isNotMatch", StringPool.BLANK);
        
        long stdId = ParamUtil.getLong(actionRequest, "stdId", 0L);
        Enumeration<String> allParams = actionRequest.getParameterNames();
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        while (allParams.hasMoreElements())
        {
            String param = allParams.nextElement();
            if (param.contains("datepicker_")||param.contains("expDatepicker_"))
            {
                String value = ParamUtil.get(actionRequest, param, StringPool.BLANK);
                String countryCode = param.substring(param.indexOf(StringPool.UNDERLINE) + 1, param.length());
               
                	  try
                      {
                			Date updatedDate = null;
                		  if(Validator.isNotNull(value)){
		                      	updatedDate = df.parse(value);
                		  }
		                          StandardsCountryChain countryChain = StandardsCountryChainLocalServiceUtil
		                                  .getStandardsCountryChain(new StandardsCountryChainPK(stdId, countryCode, brandCode));
		                          if (Validator.isNotNull(countryChain))
		                          {
		                        	  if (param.contains("datepicker_")&& countryChain.getCompDate()!=updatedDate){
		                        		 countryChain.setCompDate(updatedDate);
		                               	 StandardsCountryChainLocalServiceUtil.updateStandardsCountryChain(countryChain);
		                        	  }else if (param.contains("expDatepicker_")&&countryChain.getExprDate()!=updatedDate){
		                        		  countryChain.setExprDate(updatedDate);
		                              	 StandardsCountryChainLocalServiceUtil.updateStandardsCountryChain(countryChain);
		                        	  
		                        	  }
		                        		  
		                              	
		                          }
		                          
		                        /* Commenting by Anil Gurjar as discuss with LakshmiNarayan
		                         *  Publication publish = PublicationLocalServiceUtil.getPublishByStatEnvChainCode("ACTIVE", "PRODUCTION", brandCode);
		                          if (Validator.isNotNull(publish)) {
		                          	PublishStd publishStd = PublishStdLocalServiceUtil.getPublishForStdId(publish.getPublishId(), stdId);                        	
		                          	if(Validator.isNotNull(publishStd)) {                        		
		                          		PublishCountryStandard publishCntStd = PublishCountryStandardLocalServiceUtil.getPublishCountryStandardByVerIdStdId(publishStd.getPublishStdVerId(), countryCode);                        		
		                          		if(Validator.isNotNull(publishCntStd)) {                        			
		                          			publishCntStd.setStdComplyDeadlineDate(updatedDate); 
		                          			PublishCountryStandardLocalServiceUtil.updatePublishCountryStandard(publishCntStd);
		                          		}
		                          	}
		                          }*/
                		 
                      }
                      catch (PortalException e)
                      {
                          LOG.error("Error while fetching country chain record" + e.getMessage());
                      }
                      catch (SystemException e)
                      {
                          LOG.error("Error while fetching country chain record" + e.getMessage());
                      }
                      catch (ParseException e)
                      {
                          LOG.error("Error while parsing date" + e.getMessage());
                      }
               
                
                }
            
        } 
        String redirectUrl = "&caloption="+caloption+"&between="+between+"&and="+andVal+"&Search="+search+"&isNotMatch="+isNotMatch;
        //actionResponse.sendRedirect("/web/brand-standards/compliance-admin?p_p_id=ComplianceAdmin_WAR_BSAdminportlet&tabs1="+brandCode +redirectUrl);
        actionResponse.sendRedirect("/web/brand-standards/compliance-deadline?stdId="+stdId+"&brandCode="+brandCode+redirectUrl);
      
    }
}
