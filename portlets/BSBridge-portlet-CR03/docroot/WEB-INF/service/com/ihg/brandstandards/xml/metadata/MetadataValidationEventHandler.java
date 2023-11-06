package com.ihg.brandstandards.xml.metadata;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.ValidationEventLocator;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Implementation of ValidationEventHandler for XLS document.
 * 
 * @author kryvora
 * 
 */
public class MetadataValidationEventHandler implements ValidationEventHandler
{
    private static final Log LOG = LogFactoryUtil.getLog(MetadataValidationEventHandler.class);

    /**
     * Override handleEvent.
     */
    public boolean handleEvent(ValidationEvent event)
    {
        Boolean valid = true;

        if (event.getSeverity() == ValidationEvent.FATAL_ERROR || event.getSeverity() == ValidationEvent.ERROR)
        {
            ValidationEventLocator locator = event.getLocator();
            LOG.error("Invalid xml document: " + locator.getURL() + " Error: " + event.getMessage() + "Error at column "
                    + locator.getColumnNumber() + ", line " + locator.getLineNumber());
            valid = false;
        }
        return valid;
    }
}
