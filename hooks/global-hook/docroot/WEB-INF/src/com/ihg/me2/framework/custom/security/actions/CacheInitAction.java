/**
 * 
 */
package com.ihg.me2.framework.custom.security.actions;

import com.ihg.me2.framework.custom.security.cache.CacheManagerUtil;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Date;

/**
 * @author SheladG
 *
 */
public class CacheInitAction extends SimpleAction   {
	
	private static Log LOG = LogFactoryUtil.getLog(CacheInitAction.class);

	@Override
	public void run(String[] ids) throws ActionException {
		try {
		LOG.info("CacheInitServlet.init");
		Date startDate = new Date();
		//BeanFactory.getBean(BeanFactory.CACHE_MANAGER);
		CacheManagerUtil.initSecurityAttributes();
		LOG.debug("CacheInitServlet.init time :" + (new Date().getTime() - startDate.getTime()));
		} catch (Exception e) {
			e.printStackTrace();
			LOG.info("Exception thrown from CacheInitServlet.init");
		}
	}
	
}
