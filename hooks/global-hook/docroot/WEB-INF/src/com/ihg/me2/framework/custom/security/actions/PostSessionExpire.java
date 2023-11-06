package com.ihg.me2.framework.custom.security.actions;

import com.ihg.me2.utils.session.MerlinSession;
import com.liferay.portal.kernel.events.SessionAction;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.servlet.http.HttpSession;

/**
 * Post Session Expire class. This class must be configured in Liferay's portal-ext.properties
 * @author SheladG
 *
 */
public class PostSessionExpire extends SessionAction 
{
	private static Log LOG = LogFactoryUtil.getLog(PostSessionExpire.class);
	
	/**
	 * Remove the static value from MerlinSession, and then let Liferay do their post expire stuff.
	 * @param session
	 */
	public void run(HttpSession session) 
	{
		MerlinSession.unset(session.getId());
		LOG.info("Merlin Session Destroyed");
	}
	
}
