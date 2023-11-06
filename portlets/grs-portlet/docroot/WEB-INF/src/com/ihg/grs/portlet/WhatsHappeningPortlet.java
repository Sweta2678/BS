
package com.ihg.grs.portlet;

import com.ihg.grs.util.WhatsHappeningUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.announcements.model.AnnouncementsEntry;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Portlet implementation class WhatsHappeningPortlet.
 */
public class WhatsHappeningPortlet extends MVCPortlet
{

	private static final Log LOGGER = LogFactoryUtil.getLog(WhatsHappeningPortlet.class);
	private static final String DELTA = "delta";

	/**
	 * Default view page.
	 * 
	 * @param renderRequest
	 *            Render request is passed when loading page.
	 * @param renderResponse
	 *            After retrieving announcementEntry response is passing
	 *            response.
	 * @throws IOException
	 *             Throws IOException during loadMoreAnnouncment
	 * @throws PortletException
	 *             Throws PortletException during loadMoreAnnouncment
	 */
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException
	{
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		PortletPreferences preferences = renderRequest.getPreferences();
		int delta = GetterUtil.getInteger(preferences.getValue(DELTA, "5"));

		long total = WhatsHappeningUtil.getAnnouncementsEntriesCount(themeDisplay.getScopeGroupId());

		List<AnnouncementsEntry> announcements = WhatsHappeningUtil.getAnnouncementsEntries(themeDisplay.getScopeGroupId(), 0, delta);

		renderRequest.setAttribute("announcements", announcements);
		renderRequest.setAttribute("total", total);
		renderRequest.setAttribute("delta", delta);

		super.doView(renderRequest, renderResponse);
	}

	/**
	 * Set preferences.
	 * 
	 * @param actionRequest
	 *            Action request is passed when Preferences saved.
	 * @param actionResponse
	 *            After saving action response is passing response.
	 */
	public void setPreferences(ActionRequest actionRequest, ActionResponse actionResponse)
	{
		try
		{
			String delta = ParamUtil.getString(actionRequest, DELTA);

			PortletPreferences portletPreferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);

			portletPreferences.setValue(DELTA, delta);

			portletPreferences.store();

			SessionMessages.add(actionRequest, "preferences-saved-successfully");

		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage(), e);
			SessionMessages.add(actionRequest, "error-saving-preferences");
		}
	}

	/**
	 * on Load more annoucement Calling Ajax.
	 * 
	 * @param resourceRequest
	 *            Resource request is passed when loading page.
	 * @param resourceResponse
	 *            After retrieving announcementEntry response is passing
	 *            response.
	 * @throws IOException
	 *             Throws IOException during loadMoreAnnouncment
	 * @throws PortletException
	 *             Throws PortletException during loadMoreAnnouncment
	 */
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException
	{
		String resourceId = resourceRequest.getResourceID();
		if ("loadMoreAnnoucements".equalsIgnoreCase(resourceId))
		{
			loadMoreAnnoucements(resourceRequest, resourceResponse);
		}
	}

	/**
	 * Load more annoucement.
	 * 
	 * @param resourceRequest
	 *            Resource request is passed when loading page.
	 * @param resourceResponse
	 *            After retrieving announcementEntry response is passing
	 *            response.
	 * @throws IOException
	 *             Throws IOException during loadMoreAnnouncment
	 * @throws PortletException
	 *             Throws PortletException during loadMoreAnnouncment
	 */
	public void loadMoreAnnoucements(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException
	{
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));

		PortletPreferences preferences = resourceRequest.getPreferences();
		int delta = Math.abs(GetterUtil.getInteger(preferences.getValue(DELTA, "5")));
		boolean oddRow = false;
		if (delta % 2 == 1)
		{
			oddRow = true;
		}

		int start = ParamUtil.getInteger(httpRequest, "start");
		int end = ParamUtil.getInteger(httpRequest, "end");

		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Start=" + start + " End=" + end);
		}

		List<AnnouncementsEntry> announcements = WhatsHappeningUtil.getAnnouncementsEntries(themeDisplay.getScopeGroupId(), start, end);

		resourceRequest.setAttribute("announcements", announcements);
		resourceRequest.setAttribute("oddRow", oddRow);
		include("/html/whatshappening/loadMoreAnnoucements.jsp", resourceRequest, resourceResponse);
	}

}
