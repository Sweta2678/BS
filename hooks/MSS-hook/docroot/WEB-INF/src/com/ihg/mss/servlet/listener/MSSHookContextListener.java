package com.ihg.mss.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.ihg.mss.utils.BunchballUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * 
 * @author Jay Patel
 * 
 *
 */
public class MSSHookContextListener implements ServletContextListener 
{

	
	public void contextDestroyed(ServletContextEvent contextEvent) 
	{
		_log.info(contextEvent.getServletContext().getServletContextName() + " destroyed....");
	}

	
	public void contextInitialized(ServletContextEvent contextEvent) 
	{	
		_log.info(contextEvent.getServletContext().getServletContextName() + " initialized....");
		
		_log.info("Trying to initialize 'Meeting Point Application Context' to talk to Bunchball !!!");
		
		/**
		 * Initialize "Meeting Point Application Context" to talk to Bunchball
		 * This avoids issue if at all context is NOT initialized & services are requested.
		 * However logs should be monitored to check static JAXBContext & Rest Client are NOT loaded all the time.
		 */
		
		BunchballUtil.initializeContext();
		
		_log.info("Successfully initialized 'Meeting Point Application Context' !!!");
	}

	
	private static final Log _log = LogFactoryUtil.getLog(MSSHookContextListener.class);
}
