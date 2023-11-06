/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.me2.brandstandards.custom.pojo;

import java.io.Serializable;

import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * <a href="StandardsDisplayOptions.java.html"><b><i>View Source</i></b></a>.
 * 
 * Project: Brand Standards
 * 
 * @author Niranjan Khandekar
 */
public class StandardsDisplayOptions implements Serializable, Cloneable
{
    private static Log LOG = LogFactoryUtil.getLog(StandardsDisplayOptions.class);
    
    private static final String CONSTANT_Y = "Y";
    private static final String HIGH_LIGHT = "highlight";
    private static final String COMP_DATE = "compDate";
    private static final String WHATS_NEW = "whatsNew";
    private static final String HOTEL_LIFECYCLE = "hotelLifeCycle";
    private boolean whatsNew = false;
    private boolean compDate = false;
    private boolean highlight = true;
    private boolean hotelLifeCycle = false;

    /**
     * default constructor.
     */
    public StandardsDisplayOptions()
    {
    }

    /**
     * Preferred constructor.
     * 
     * @param request - RenderRequest
     */
    public StandardsDisplayOptions(RenderRequest request)
    {
        HttpServletRequest hsrw = PortalUtil.getHttpServletRequest(request);
        HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(hsrw);
        init(httpRequest, true);
    }

    /**
     * Preferred constructor.
     * 
     * @param request - ResourceRequest
     */
    public StandardsDisplayOptions(ResourceRequest request)
    {
        HttpServletRequest hsrw = PortalUtil.getHttpServletRequest(request);
        HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(hsrw);
        init(httpRequest, false);
    }

    /**
     * @param request HttpServletRequest object
     */
    public StandardsDisplayOptions(HttpServletRequest request)
    {
        init(request, false);
    }

    /**
     * @param httpRequest HttpServletRequest object
     * @param isRenderRequest boolean specifying whether it RenderRequest object or not.
     */
    private void init(HttpServletRequest httpRequest, boolean isRenderRequest)
    {
        if (ParamUtil.getString(httpRequest, WHATS_NEW) != null)
        {
            this.whatsNew = CONSTANT_Y.equals(ParamUtil.getString(httpRequest, WHATS_NEW));
        }
        if (ParamUtil.getString(httpRequest, COMP_DATE) != null)
        {
            this.compDate = CONSTANT_Y.equals(ParamUtil.getString(httpRequest, COMP_DATE));
        }
        if (ParamUtil.getString(httpRequest, HIGH_LIGHT) != null)
        {
            this.highlight = CONSTANT_Y.equals(ParamUtil.getString(httpRequest, HIGH_LIGHT));
        }
        //CR 50.2 
        if (ParamUtil.getString(httpRequest, HOTEL_LIFECYCLE) != null)
        {
            this.hotelLifeCycle = CONSTANT_Y.equals(ParamUtil.getString(httpRequest, HOTEL_LIFECYCLE));
            if (LOG.isDebugEnabled())
            {
                LOG.debug("init method for hotle Life cycle :: "+ this.hotelLifeCycle);
            }
        }
    }

    /**
     * This will clone the StandardsDisplayOptions object.
     * 
     * @return StandardsDisplayOptions
     * @throws CloneNotSupportedException throws CloneNotSupportedException
     */
    public StandardsDisplayOptions clone() throws CloneNotSupportedException
    {
        StandardsDisplayOptions displayOptions = new StandardsDisplayOptions();
        displayOptions.setWhatsNew(this.whatsNew);
        displayOptions.setCompDate(this.compDate);
        displayOptions.setHighlight(this.highlight);
        displayOptions.setHotelLifeCycle(this.hotelLifeCycle);
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Clone display options hotle Life cycle :: "+ this.hotelLifeCycle);
        }
        return displayOptions;
    }

    /**
     * @return boolean
     */
    public boolean isWhatsNew()
    {
        return whatsNew;
    }

    /**
     * @param whatsNew boolean object
     */
    public void setWhatsNew(boolean whatsNew)
    {
        this.whatsNew = whatsNew;
    }

    /**
     * @return boolean
     */
    public boolean isCompDate()
    {
        return compDate;
    }

    /**
     * @param compDate boolean object
     */
    public void setCompDate(boolean compDate)
    {
        this.compDate = compDate;
    }

    /**
     * @return boolean
     */
    public boolean isHighlight()
    {
        return highlight;
    }

    /**
     * @param highlight boolean object
     */
    public void setHighlight(boolean highlight)
    {
        this.highlight = highlight;
    }
    /**
     * @return the hotelLifeCycle
     */
    public boolean isHotelLifeCycle() {
        return hotelLifeCycle;
    }

    /**
     * @param hotelLifeCycle the hotelLifeCycle to set
     */
    public void setHotelLifeCycle(boolean hotelLifeCycle) {
        this.hotelLifeCycle = hotelLifeCycle;
    }
}
