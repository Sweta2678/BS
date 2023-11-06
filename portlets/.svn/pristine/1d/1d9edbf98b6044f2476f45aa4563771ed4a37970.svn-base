package com.ihg.brandstandards.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.Workflow;
import com.ihg.brandstandards.db.service.StandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.WorkflowLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class LogHistoryController extends MVCPortlet
{
    public void doView(RenderRequest request, RenderResponse renderResponse) throws IOException, PortletException
    {        
        int standardsLogCount = 0;
        long objectId = 0;
        String stdType = "";
        List<Workflow> arlStandardsLog = new ArrayList();
        List<Workflow> arlWorkflowLog = null;
        String strObjectId = "";
        try
        {
            HttpServletRequest hsrw = null;
            PortletURL portletURL = renderResponse.createRenderURL();
            hsrw = PortalUtil.getHttpServletRequest(request);
            HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(hsrw);
            strObjectId = httpRequest.getParameter("stdId");
            if (strObjectId != null)
            {
                objectId = Long.parseLong(strObjectId);
                portletURL.setParameter("stdId", strObjectId);
            }
            String objectType = httpRequest.getParameter("objType");
            if ("STD".equals(objectType))
            {
                arlStandardsLog = WorkflowLocalServiceUtil.getLogBySTDObjectId(objectId);
            }
            else
            {
                arlStandardsLog = WorkflowLocalServiceUtil.getLogByObjectId(objectId);
            }
            Standards standards = StandardsLocalServiceUtil.getStandards(objectId);
            stdType = standards.getStdTyp();
            standardsLogCount = arlStandardsLog.size();
            arlWorkflowLog = new ArrayList(arlStandardsLog);
        }
        catch (NumberFormatException e)
        {
            e.printStackTrace();
        }
        catch (SystemException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        request.setAttribute("arlStandards", arlWorkflowLog);
        request.setAttribute("standardsCount", standardsLogCount);
        request.setAttribute("standardsId", strObjectId);
        request.setAttribute("logStdType", stdType);

        PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher("/html/loghistory/view.jsp");
        rd.include(request, renderResponse);
    }
}
