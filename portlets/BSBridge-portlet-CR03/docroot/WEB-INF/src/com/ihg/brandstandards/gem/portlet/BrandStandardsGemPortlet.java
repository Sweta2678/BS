package com.ihg.brandstandards.gem.portlet;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ihg.brandstandards.bridge.util.BridgeCommonUtil;
import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.db.NoSuchPublicationException;
import com.ihg.brandstandards.db.NoSuchPublishDeptException;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.PublishDept;
import com.ihg.brandstandards.db.service.PublicationLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublishDeptLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocaleLocalServiceUtil;
import com.ihg.brandstandards.util.BSLanguageUtil;
import com.ihg.brandstandards.util.QueryUtils;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PortalUtil;

public class BrandStandardsGemPortlet extends BrandStandardsMVCPortlet {
	
	private static final Log LOG = LogFactoryUtil.getLog(BrandStandardsGemPortlet.class);
	
	/**
     * get user preferences from session.
     * 
     * @param request The PortletRequest Object
     * @return AccessAndPreferences return AccessAndPreferences Object
     */
    public Preferences getGEMUserPreferences(PortletRequest request)
    {
        return getPreferences(request, "GEM");
    }
    
    /**
     * 
     * @param chainCd
     * @param environment
     * @param status
     * @return Publication
     */
    public Publication getActivePublication (String chainCd, String environment, String status) {
    	Publication publication = null;
    	try {
			publication =  PublicationLocalServiceUtil.getPublishByStatEnvChainCode(status, environment, chainCd);
		} catch (NoSuchPublicationException e) {
			LOG.error(e.getMessage(), e);
		} catch (SystemException e) {
			LOG.error(e.getMessage(), e);
		}
    	return publication;
    }
    
    
    /**
     * Get Active Bridge Publish for a Brand.
     * 
     * @param brandCode brand code
     * @return Active Bridge Publish
     */
    protected Publication getActiveBridgePublication(String brandCode, HttpServletRequest request)
    {
    	Publication bridgePublish = null;
        try
        {
           // bridgePublish = PublicationLocalServiceUtil.getPublishByStatEnvChainCode(BridgeConstants.PUBLISH_ACTIVE_STATUS_CODE, BridgeConstants.BRIDGE_ENVIRONMENT, brandCode);
        	String domain = new URL(request.getRequestURL().toString()).getHost(); 	
        	String env = "PROD";
        	if(domain.contains("me2qa"))
        	{
        		env = "QA";
        	}
        	long publishId = Long.parseLong(decodeBridgePublishId(brandCode, env));
        	bridgePublish = PublicationLocalServiceUtil.getPublication(publishId);
        	
        }
        catch (Exception e)
        {
            LOG.error("No Active Bridge Publish Exist for brand:" + brandCode);
        }
        //If No active Bridge Publish exist then get archived bridge publish by using parent id of active OBSM Publication. 
        if(bridgePublish == null){
        	Publication prodPublish = getActiveProductionPublication(brandCode);
        	if(prodPublish != null && prodPublish.getParentPublishId() > 0){
        		try {
					bridgePublish = PublicationLocalServiceUtil.getPublication(prodPublish.getParentPublishId());
				} catch (Exception e) {
					LOG.error("No Active OBSM Publish Exist for brand:" + brandCode);
				}
        	}
        }
        return bridgePublish;
    }
    
    /**
     * Get Active Production Publish for a Brand.
     * 
     * @param brandCode brand code
     * @return Active Publish
     */
    protected Publication getActiveProductionPublication(String brandCode)
    {
    	Publication publish = null;
        try
        {
            publish = PublicationLocalServiceUtil.getPublishByStatEnvChainCode(BridgeConstants.PUBLISH_ACTIVE_STATUS_CODE, BridgeConstants.PRODUCTION_ENVIRONMENT, brandCode);
        }
        catch (Exception e)
        {
            LOG.error("No Active Production Publish Exist for brand:" + brandCode);
        }
        return publish;
    }

    /**
     * @param portletRequest The PortletRequest object
     * @return HttpServletRequest
     */
    public HttpServletRequest getHttpServletRequest(PortletRequest portletRequest)
    {
        HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(portletRequest);
        return PortalUtil.getOriginalServletRequest(httpServletRequest);
    }
    
    /**
     * 
     * @param httpRequest The HttpServletRequest Object
     * @return HttpSession return HttpSession Object
     */
    public HttpSession getHttpSession(HttpServletRequest httpRequest)
    {
        return httpRequest.getSession();
    }

    /**
     * 
     * @param portletRequest The PortletRequest Object
     * @return HttpSession return HttpSession Object
     */
    public HttpSession getHttpSession(PortletRequest portletRequest)
    {
        HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(portletRequest));

        return httpRequest.getSession();
    }

    
    /**
     * UI Element Access Util method.
     * 
     * @param request
     * @param localeCode
     * @param moduleUsedIn
     * @return
     */
    public BSLanguageUtil getOBSMLanguageUtil(PortletRequest request, String localeCode, String moduleUsedIn)
    {
        BSLanguageUtil obsmLanguageUtil = null;
        HttpSession session = getHttpSession(request);
        if (session.getAttribute("bridgeLanguageUtil") != null)
        {
            obsmLanguageUtil = (BSLanguageUtil) session.getAttribute("bridgeLanguageUtil");
        }
        if (obsmLanguageUtil == null)
        {
            if(moduleUsedIn != null){
                obsmLanguageUtil = new BSLanguageUtil(localeCode, moduleUsedIn);
            } else {
                obsmLanguageUtil = new BSLanguageUtil(localeCode);
            }
            session.setAttribute("bridgeLanguageUtil", obsmLanguageUtil);
        }
        return obsmLanguageUtil;
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
    
    public static String decodeBridgePublishId(String chain, String env)
    {
        String publishId = "";
        final Map<String, String> pubCdMap = new LinkedHashMap<String, String>();
        System.out.println("the environment is "+env);
        if(env.equals("QA"))
        {    pubCdMap.put("EX", "48011");
       		pubCdMap.put("HI", "49018");
	        pubCdMap.put("RS", "51021");
	        pubCdMap.put("CP", "48014");
	        pubCdMap.put("CR", "49039");
	        pubCdMap.put("IC", "48016");
	        pubCdMap.put("IR", "48017");
	        pubCdMap.put("VN", "51018");
	        pubCdMap.put("UL", "0");
	        pubCdMap.put("SB", "0");
	        pubCdMap.put("CW", "0");
        }
        else if (env.equals("PROD"))
        {
        	pubCdMap.put("EX", "49008");
 	        pubCdMap.put("HI", "49006");
 	        pubCdMap.put("RS", "49007");
 	        pubCdMap.put("CP", "49005");
 	        pubCdMap.put("CR", "49003");
 	        pubCdMap.put("IC", "49002");
 	        pubCdMap.put("IR", "49004");
 	        pubCdMap.put("VN", "49009");
 	        pubCdMap.put("UL", "0");
 	        pubCdMap.put("SB", "0");
 	        pubCdMap.put("CW", "0");
        }
       
        publishId = pubCdMap.get(chain);
        if (LOG.isDebugEnabled())
        {
            LOG.debug("the value of chain code is " + publishId);
        }
        System.out.println("value of chaincode is "+publishId);
        return publishId;
    }
    
    /**
     * 
     * @param publishId
     * @param departmentId
     * @return PublishDept
     */
    public PublishDept getActivePublicationByDept (long publishId, long departmentId) {
    	
    	PublishDept publishDept = null;
    	
    	try {
    		publishDept = PublishDeptLocalServiceUtil.getActivePublicationByDept(publishId, departmentId);
		} catch (NoSuchPublishDeptException e) {
			LOG.error(e.getMessage(), e);
		} catch (SystemException e) {
			LOG.error(e.getMessage(), e);
		}
    	return publishDept;
    }
    
    /**
     * 
     * patelhiren_CR19
     * 
     * This method will get the active languages for a region except en_GB.
     * 
     * @param regionCd the region code
     * @return Map<String, String>
     */
    protected Map<String, String> getRegionActiveSecondLanguages(String regionCd)
    {
        Map<String, String> activeSecondLanguages = new LinkedHashMap<String, String>();
        try
        {
            activeSecondLanguages = StandardsLocaleLocalServiceUtil.getActiveLanguages(QueryUtils.getActiveSecondLangsByRegion(regionCd));
        }
        catch (Exception e)
        {
            LOG.error(e);
        }
        return activeSecondLanguages;
    }
}
