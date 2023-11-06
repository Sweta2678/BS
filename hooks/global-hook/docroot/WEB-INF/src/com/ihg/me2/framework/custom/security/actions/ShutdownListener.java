package com.ihg.me2.framework.custom.security.actions;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.servlet.ServletContextEvent;

/**
 * ShutdownListener make sure the cache gets flush in disk storage file.
 * @author Vipul Dave
 * 
 */
public class ShutdownListener extends net.sf.ehcache.constructs.web.ShutdownListener 
{

	// Logger
	private static Log LOG = LogFactoryUtil.getLog(CacheInitAction.class);
	
	/**
	 * Store the cache in disk , before server get shutdown.
	 * @param servletContextEvent
	 */
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) 
	{
		/*Cache cache = CacheManager.getInstance().getCache(com.ihg.me2.framework.custom.security.cache.CacheManager.CACHE_NAME);
		if (cache != null) 
		{
			LOG.info("Started cache flushing (storing to file system) ");
			cache.flush();
			cache.getCacheManager().shutdown();
			LOG.info("Completed cache flushing (storing to file system) ");
		}*/
		super.contextDestroyed(servletContextEvent);
	}
}
