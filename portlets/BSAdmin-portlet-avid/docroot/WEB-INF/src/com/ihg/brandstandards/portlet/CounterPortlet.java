package com.ihg.brandstandards.portlet;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class CounterPortlet extends GenericPortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(CounterPortlet.class);

    private static final String COUNTER_URL = "/html/counter/counter.jsp";

    public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException
    {
        //LOG.debug("In doView code");
        response.setContentType("text/html");
        getPortletContext().getRequestDispatcher(response.encodeURL(COUNTER_URL)).include(request, response);
    }

}
