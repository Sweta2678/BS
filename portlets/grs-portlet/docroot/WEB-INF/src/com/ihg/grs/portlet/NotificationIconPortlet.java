
package com.ihg.grs.portlet;

import com.ihg.grs.constant.ApplicationConstants;
import com.ihg.me2.core.service.CoreNotificationSubscriptionLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.portlet.PortletProps;

import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class NotificationIconPortlet.
 */
public class NotificationIconPortlet extends MVCPortlet
{

	private static final Log LOGGER = LogFactoryUtil.getLog(NotificationIconPortlet.class);

	/*
	 * (non-Javadoc)
	 * @see
	 * com.liferay.util.bridges.mvc.MVCPortlet#doView(javax.portlet.RenderRequest
	 * , javax.portlet.RenderResponse)
	 */
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
	{
		try
		{
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			if (themeDisplay.isSignedIn())
			{
				PortletSession portletSession = renderRequest.getPortletSession();
				String iconStatusCode = (String) portletSession.getAttribute("iconStatusCode", PortletSession.APPLICATION_SCOPE);

				if (Validator.isNull(iconStatusCode))
				{
					int resultCount = CoreNotificationSubscriptionLocalServiceUtil.notificationAssetCount(PortletProps.get("subscription-local-vocabulary-name"), themeDisplay);

					if (resultCount >= 1)
					{
						portletSession.setAttribute("iconStatusCode", "1", PortletSession.APPLICATION_SCOPE);
						iconStatusCode = "1";
					}
					else
					{
						portletSession.setAttribute("iconStatusCode", "-1", PortletSession.APPLICATION_SCOPE);
						iconStatusCode = "-1";
					}
				}
				if (themeDisplay.getLayout().getFriendlyURL().contains(ApplicationConstants.NOTIFICATION_PAGE_URL))
				{
					portletSession.setAttribute("iconStatusCode", "-1", PortletSession.APPLICATION_SCOPE);
					iconStatusCode = "-1";
				}

				if ("1".equals(iconStatusCode))
				{
					renderRequest.setAttribute("isIconVisible", true);
				}
				else
				{
					renderRequest.setAttribute("isIconVisible", false);
				}

				super.doView(renderRequest, renderResponse);
			}
		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage(), e);
		}
	}

}
