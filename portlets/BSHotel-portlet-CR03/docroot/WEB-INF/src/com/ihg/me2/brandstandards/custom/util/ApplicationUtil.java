/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.me2.brandstandards.custom.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ihg.me2.brandstandards.custom.application.Application;
import com.ihg.me2.brandstandards.custom.application.AttachmentsApplication;
import com.ihg.me2.brandstandards.custom.application.ContentApplication;
import com.ihg.me2.brandstandards.custom.application.DownloadManual;

/**
 * <a href="ApplicationUtil.java.html"><b><i>View Source</i></b></a>.
 * 
 * Project: Brand Standards
 * 
 * @author Niranjan Khandekar
 */
public class ApplicationUtil
{
    private static final String BS_HOTEL_BEANS_XML = "bs-hotel-beans.xml";
    private static AttachmentsApplication application;
    private static DownloadManual downloadManual;
    private static ContentApplication contentApplication;
    private static AttachmentsApplication attachmentsApplication;

    /**
     * 
     * @return Application
     */
    public static synchronized Application getApplicationObject()
    {
        if (application == null)
        {
            synchronized (ApplicationUtil.class)
            {
                if (application == null)
                {
                    ApplicationContext context = new ClassPathXmlApplicationContext(BS_HOTEL_BEANS_XML);
                    application = (AttachmentsApplication) context.getBean("application");
                }
            }
        }
        return application;
    }

    /**
     * 
     * @return DownloadManual
     */
    public static synchronized DownloadManual getDownloadManualObject()
    {
        if (downloadManual == null)
        {
            synchronized (ApplicationUtil.class)
            {
                if (downloadManual == null)
                {
                    ApplicationContext context = new ClassPathXmlApplicationContext(BS_HOTEL_BEANS_XML);
                    downloadManual = (DownloadManual) context.getBean("downloadManual");
                }
            }
        }
        return downloadManual;
    }

    /**
     * 
     * @return ContentApplication
     */
    public static synchronized ContentApplication getContentApplicationObject()
    {
        if (contentApplication == null)
        {
            synchronized (ApplicationUtil.class)
            {
                if (contentApplication == null)
                {
                    ApplicationContext context = new ClassPathXmlApplicationContext(BS_HOTEL_BEANS_XML);
                    contentApplication = (ContentApplication) context.getBean("contentApplication");
                }
            }
        }
        return contentApplication;
    }

    /**
     * 
     * @return AttachmentsApplication
     */
    public static synchronized AttachmentsApplication getAtatchmentsApplicationObject()
    {
        if (attachmentsApplication == null)
        {
            synchronized (ApplicationUtil.class)
            {
                if (attachmentsApplication == null)
                {
                    ApplicationContext context = new ClassPathXmlApplicationContext(BS_HOTEL_BEANS_XML);
                    attachmentsApplication = (AttachmentsApplication) context.getBean("attachmentsApplication");
                }
            }
        }
        return attachmentsApplication;
    }
}
