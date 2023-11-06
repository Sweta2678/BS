package com.ihg.brandstandards.messaging;

import com.ihg.brandstandards.bridge.processor.Processor;
import com.ihg.brandstandards.bridge.processor.ProcessorFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;

public class BridgeMessageListener implements MessageListener
{
    private static final Log LOG = LogFactoryUtil.getLog(BridgeMessageListener.class);

    @Override
    public void receive(Message message) 
    {
        try {
            message.getPayload();
            String requestType = (String)message.get("requestType"); 
            LOG.debug("Received request: " + requestType);
            Processor processor = ProcessorFactory.getProcessor(requestType);
            processor.process(message);
        }
        catch (Exception e)
        {
            LOG.error("Unable to process message: ", e);
        }
    }
}
