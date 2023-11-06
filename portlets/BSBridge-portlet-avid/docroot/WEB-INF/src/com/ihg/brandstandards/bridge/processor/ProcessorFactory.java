package com.ihg.brandstandards.bridge.processor;

import com.ihg.brandstandards.bridge.processor.impl.CMSToBridgeUpdateProcessor;
import com.ihg.brandstandards.bridge.processor.Processor;
import com.ihg.brandstandards.util.BSCommonConstants;

public class ProcessorFactory
{

    public static Processor getProcessor(String requestType) throws UnsupportedProcessorTypeException
    {
        Processor processor = null;
        
        if (BSCommonConstants.MESSAGE_REQ_TYPE_CMS_BRIDGE_SYNC.equals(requestType))
        {
            processor = new CMSToBridgeUpdateProcessor();
        }
        else
        {
            throw new UnsupportedProcessorTypeException("Unknown type: " + requestType);
        }
        
        return processor;
    }
}
