package com.ihg.brandstandards.bridge.processor;

import com.liferay.portal.kernel.messaging.Message;

public interface Processor
{
    public void process(Message message);
}
