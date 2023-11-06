package com.ihg.tcc.login;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TCCCustomLogoutPostAction extends Action {
	private static final Log LOGGER = LogFactoryUtil
			.getLog(TCCCustomLogoutPostAction.class);
	private static final String GOOGLE_TRANSLATE_COOKIE_NAME = "googtrans";

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response)
			throws ActionException {
		deleteGoogleTranslateCookie(request, response);
	}

	private void deleteGoogleTranslateCookie(HttpServletRequest request,
			HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();

		// Delete google translate cookies after logout
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equalsIgnoreCase(GOOGLE_TRANSLATE_COOKIE_NAME)) {
					cookies[i].setPath(StringPool.FORWARD_SLASH);
					cookies[i].setValue(null);
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
					return;
				}
			}
		}

	
		
	}

}
