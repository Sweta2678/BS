package com.ihg.brandstandards.portlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.UnavailableException;

import com.ihg.brandstandards.db.model.TreeXML;
import com.ihg.brandstandards.util.ActionUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;

public class TaxonomyTreePortlet extends GenericPortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(TaxonomyTreePortlet.class);

    public void init(PortletConfig portletConfig) throws UnavailableException, PortletException
    {
        super.init(portletConfig);
    }

    /* public void doView(RenderRequest request, RenderResponse response)
                        throws PortletException, IOException
     {
        try {
      	    logger.debug("<<<<<In TaxonomyTreePortlet>>>");
    		HttpServletResponse response1 = PortalUtil.getHttpServletResponse(response);
    		response1.setContentType("text/html");
              
    		TreeXML treeXmlTbl = ActionUtil.getXMLTreeTaxonomy(1L);
    		
    		OutputStream out = response1.getOutputStream();
    		Result result = new StreamResult(out);
    		String checkXml=treeXmlTbl.getXMLLOB();
    		//logger.debug("checkXml===>>>"+checkXml);
              if(!checkXml.equals(""))
    		{
              byte[] bytes = treeXmlTbl.getXMLLOB().getBytes();

    		Source xmlSource = new StreamSource(new ByteArrayInputStream(bytes));
              HttpServletRequest request1 = PortalUtil.getHttpServletRequest(request);
              ServletContext servletContext = request1.getSession().getServletContext();
    		String path = servletContext.getRealPath("/XSL/");
    		//logger.debug("====>>>>>>"+servletContext.getContextPath()); 
    		Source xsltSource = new StreamSource(new File(path,"tree.xslt"));
    
    		//String reconstructedURL = getBaseUrl(request1);
    		//logger.debug(reconstructedURL);
    		TransformerFactory transFact = TransformerFactory.newInstance();
    		Transformer trans = transFact.newTransformer(xsltSource);
    		trans.setParameter("contextPath",servletContext.getContextPath());

    		trans.transform(xmlSource, result);
              }
    		out.flush();
    		out.close();

    	} catch (Exception e) {
    		logger.error(e.getMessage());
    	}
      } */

    public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException
    {
        LOG.debug("In doView code");
        response.setContentType("text/html");
        String url = "/html/taxonomy/view.jsp";
        getPortletContext().getRequestDispatcher(response.encodeURL(url)).include(request, response);
    }

    public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException
    {

        String resourceID = request.getResourceID();
        //Ajax Call for Tree Data
        if (resourceID.equals("getTreeData"))
        {
            try
            {
                response.setContentType("text/xml");
                xmlTaxonomy(request, response);
            }
            catch (Exception e)
            {
                LOG.error(StackTraceUtil.getStackTrace(e));
            }
        } //end if
    }

    public void xmlTaxonomy(ResourceRequest request, ResourceResponse response)
    {
        try
        {
            PrintWriter out = response.getWriter();
            StringBuffer sb = new StringBuffer();
            //ActionUtil.insertAdminXML(1l);
            TreeXML treeXmlTbl = ActionUtil.getXMLTreeTaxonomy(1L);
            if (treeXmlTbl != null)
            {
                sb.append(treeXmlTbl.getXMLLOB());
                out.write(sb.toString());
            }
            out.flush();
            out.close();
        }
        catch (Exception pe)
        {
            LOG.error(StackTraceUtil.getStackTrace(pe));
        }
    }

}
