
package com.ihg.grs.portlet;

import com.ihg.grs.constant.ApplicationConstants;
import com.ihg.me2.core.service.CoreNotificationSubscriptionLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.portlet.PortletProps;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class ActivityNotificationPortlet.
 */
public class ActivityNotificationPortlet extends MVCPortlet
{

	private static final Log LOGGER = LogFactoryUtil.getLog(ActivityNotificationPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
	{

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences prefs = renderRequest.getPreferences();
		int notificationMaxRecords = 0;
		List<com.ihg.me2.core.bean.ActivityNotificationBean> activityLists = null;
		try
		{
			if (Validator.isNotNull(prefs))
			{
				notificationMaxRecords = Integer.parseInt(prefs.getValue(ApplicationConstants.NOTIFICATION_MAX_RECORDS, "10"));
				activityLists = CoreNotificationSubscriptionLocalServiceUtil.getActivityNotificationsList(PortletProps.get("subscription-local-vocabulary-name"), themeDisplay, notificationMaxRecords);
			}
			renderRequest.setAttribute("activityLists", activityLists);
			super.doView(renderRequest, renderResponse);
		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage(), e);
		}
	}

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse)
	{

		try
		{
			PortletPreferences prefs = renderRequest.getPreferences();
			if (Validator.isNotNull(prefs))
			{

				String notificationMaxRecords = prefs.getValue(ApplicationConstants.NOTIFICATION_MAX_RECORDS, "10");
				renderRequest.setAttribute(ApplicationConstants.NOTIFICATION_MAX_RECORDS, notificationMaxRecords);

			}
			super.doEdit(renderRequest, renderResponse);
		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage(), e);
		}

	}

	/**
	 * Setting preferences for Article Listing Portlet.
	 * 
	 * @param actionRequest
	 *            Action request is passed when Preferences saved.
	 * @param actionResponse
	 *            After saving action response is passing response.
	 */
	public void setNotificationMaxRecordsPreferences(ActionRequest actionRequest, ActionResponse actionResponse)
	{

		try
		{
			PortletPreferences portletPreferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);
			portletPreferences.setValue(ApplicationConstants.NOTIFICATION_MAX_RECORDS, ParamUtil.getString(actionRequest, ApplicationConstants.PREF_NOTIFICATION_MAX_RECORDS, "10"));
			portletPreferences.store();

		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage(), e);
		}
	}

}
