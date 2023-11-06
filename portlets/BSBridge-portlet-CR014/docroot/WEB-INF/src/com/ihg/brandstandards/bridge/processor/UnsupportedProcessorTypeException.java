package com.ihg.brandstandards.bridge.processor;

import com.liferay.portal.kernel.exception.SystemException;

public class UnsupportedProcessorTypeException extends SystemException
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public UnsupportedProcessorTypeException()
    {
    }

    public UnsupportedProcessorTypeException(String msg)
    {
        super(msg);
    }

    public UnsupportedProcessorTypeException(String msg, Throwable cause)
    {
        super(msg, cause);
    }

    public UnsupportedProcessorTypeException(Throwable cause)
    {
        super(cause);
    }
}
