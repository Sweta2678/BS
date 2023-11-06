package com.ihg.brandstandards.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.db.model.Glossary;
import com.ihg.brandstandards.db.model.GlossaryExt;
import com.ihg.brandstandards.db.service.GlossaryExtLocalServiceUtil;
import com.ihg.brandstandards.db.service.GlossaryLocalServiceUtil;
import com.ihg.brandstandards.db.service.GlossaryRegionNavLocalServiceUtil;
import com.ihg.brandstandards.db.service.GlossaryTranslateLocalServiceUtil;
import com.ihg.brandstandards.spreadsheet.GlossaryReportProcessor;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.ihg.brandstandards.util.GlossaryUtil;
import com.ihg.brandstandards.util.UserPreferencesUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ProgressTracker;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class Glossary List Controller.
 */
public class GlossaryListController extends MVCPortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(GlossaryListController.class);

    /* (non-Javadoc)
     * @see com.liferay.util.bridges.mvc.MVCPortlet#doView(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
     */
    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        String pageName  =  "/html/glossary/view.jsp";     
        try 
    	{
			long userId = PortalUtil.getUserId(renderRequest);
			if (userId > 1)
			{
                renderRequest.setAttribute("loggedIn", true);
			    //Logic for listing of Glossary
				StringBuilder enableChars = new StringBuilder();
		        List<String> staticChars = new ArrayList<String>();
		        List<GlossaryExt> glossaryExts = new ArrayList<GlossaryExt>();
		        String chainCode = UserPreferencesUtil.getUserpreferences(renderRequest);
                final HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		        Preferences preferences = (Preferences)httpReq.getSession().getAttribute("Preferences");
		        if(preferences!=null)
		        {
		            chainCode = preferences.getBrand();
		        }
		        
				Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap();
		        String visibleChar = httpReq.getParameter(GlossaryUtil.REQUEST_PARAM_GLOSSARY_VISIBLE_CHAR);
	            if (GlossaryUtil.IsNullOrBlank(visibleChar))
	            {
	              visibleChar = "ALL";
	            }
		        for (char i = 'A'; i <= 'Z'; i++)
		        {
		        	glossaryExts = GlossaryExtLocalServiceUtil.getGlossaryByBrandCodeAndVisibleChar(chainCode, String.valueOf(i));
		            if (!glossaryExts.isEmpty())
		            {
		                enableChars.append(i).append(StringPool.COMMA);
		            }
		            staticChars.add(String.valueOf(i));
		        }
		        if (enableChars.length() > 0)
		        {
		            enableChars = enableChars.deleteCharAt(enableChars.length() - 1);
		        }
		        if (Validator.isNull(visibleChar) && enableChars.length() > 0)
		        {
		            visibleChar = enableChars.substring(0, 1);
		        }
		        if (Validator.isNotNull(visibleChar))
		        {
		            glossaryExts = GlossaryExtLocalServiceUtil.getGlossaryByBrandCodeAndVisibleChar(chainCode, visibleChar);
		        }
		        if (!GlossaryUtil.IsNullOrBlank(glossaryExts) && !glossaryExts.isEmpty())
                {
		            for(GlossaryExt glossExt : glossaryExts)
		            {
		                glossExt.setGlossaryRegions(GlossaryUtil.deleteDuplicate(glossExt.getGlossaryRegions()));
		                glossExt.setGlossaryChains(GlossaryUtil.deleteDuplicate(glossExt.getGlossaryChains()));
		            }
                }
		        renderRequest.setAttribute("enableChars", enableChars);
		        renderRequest.setAttribute("staticChars", staticChars);
		        renderRequest.setAttribute("activeChar", visibleChar);
		        renderRequest.setAttribute("glossaryExts", glossaryExts);
		        renderRequest.setAttribute("chnCdMap", chnCdMap);
			}
			else
			{
				renderRequest.setAttribute("loggedIn", false);
			}
		}
    	catch (Exception e)
    	{
			LOG.error(e.getMessage());
			renderRequest.setAttribute("errorMessage", e.getMessage());
		}
        final PortletRequestDispatcher reqDisp  =  getPortletContext().getRequestDispatcher(pageName); 
        reqDisp.include(renderRequest,  renderResponse); 
    }
    
   
    /**
     * This is action method which is call when Glossay Delete is called.
     * 
     * @param actionRequest Action request pass when delete action called.
     * @param actionResponse Response is when delete action is execute.
     * 
     * @throws IOException This method throws IOExceptino if any IO operation failed.
     * @throws PortletException This method throws PortletException if any portlet operation failed.
     */
    @ProcessAction(name = "deleteGlossary")
    public void deleteGlossary(ActionRequest actionRequest,
    		ActionResponse actionResponse) throws IOException, PortletException 
    {
    	final HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
    	long glossaryId = Long.valueOf(httpReq.getParameter(GlossaryUtil.REQUEST_PARAM_GLOSSARY_ID));
    	if (Validator.isNotNull(glossaryId))
    	{
	    	try 
	    	{
	    	    Glossary glossary = GlossaryLocalServiceUtil.getGlossary(glossaryId);
	    	    if (Validator.isNotNull(glossary) && glossary.getActiveInd().equals("N"))
	    	    {
    	    	    GlossaryRegionNavLocalServiceUtil.removeGlossayRegionByGlossayId(glossaryId);
    	    	    GlossaryTranslateLocalServiceUtil.removeGlossaryTranslateByGlossaryId(glossaryId);
    	    	    GlossaryLocalServiceUtil.deleteGlossary(glossaryId);
	    	    }
	    	    else
	    	    {
	    	        SessionMessages.add(actionRequest, "deleteFailMessage");
	    	    }
	    	} 
	    	catch (SystemException e) 
	    	{
	    		LOG.error(StackTraceUtil.getStackTrace(e));
	    		actionRequest.setAttribute("errorMessage", e.getMessage());
			}	
	    	catch (PortalException e) 
	    	{
	    		LOG.error(StackTraceUtil.getStackTrace(e));
	    		actionRequest.setAttribute("errorMessage", e.getMessage());
			}
    	}
    }
    
    /* (non-Javadoc)
     * @see com.liferay.util.bridges.mvc.MVCPortlet#serveResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
     */
    @Override
    public void serveResource(ResourceRequest resourceRequest,
            ResourceResponse resourceResponse) throws IOException,
            PortletException 
    {
    	if ("glossaryImportPopup".equals(resourceRequest.getResourceID())) 
        {
            String importIdExl  =  resourceRequest.getParameter(GlossaryUtil.PARAM_IMPORT_ID_EXCEL); 
            resourceRequest.getPortletSession().setAttribute(ProgressTracker.PERCENT + importIdExl, 0, PortletSession.APPLICATION_SCOPE); 
            resourceRequest.setAttribute(GlossaryUtil.PARAM_IMPORT_ID_EXCEL,  importIdExl); 
            resourceRequest.setAttribute("localeList",  GlossaryUtil.getStandardsLocaleList()); 
            include("/html/glossary/importexport/importGlossary.jsp", resourceRequest, resourceResponse);
        }
        else if ("glossaryExportPopup".equals(resourceRequest.getResourceID()))
        {
            String exportIdExl  =  resourceRequest.getParameter(GlossaryUtil.PARAM_EXPORT_ID_EXCEL); 
            resourceRequest.getPortletSession().setAttribute(ProgressTracker.PERCENT + exportIdExl, 0, PortletSession.APPLICATION_SCOPE); 
            resourceRequest.setAttribute(GlossaryUtil.PARAM_EXPORT_ID_EXCEL,  exportIdExl); 
            resourceRequest.setAttribute("localeList",  GlossaryUtil.getStandardsLocaleList()); 
            include("/html/glossary/importexport/exportGlossary.jsp", resourceRequest, resourceResponse); 
        }
    	else if ("excelExport".equalsIgnoreCase(resourceRequest.getResourceID())) 
        {
            GlossaryReportProcessor.exportGlossary(resourceRequest,  resourceResponse);
        } 
        else if ("uploadValidateExcel".equalsIgnoreCase(resourceRequest.getResourceID())) 
        {
        	GlossaryReportProcessor.importGlossary(resourceRequest,  resourceResponse);
        }
    }
}
