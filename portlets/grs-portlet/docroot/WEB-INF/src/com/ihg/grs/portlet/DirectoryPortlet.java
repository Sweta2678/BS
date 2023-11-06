
package com.ihg.grs.portlet;

import com.ihg.grs.common.model.Directory;
import com.ihg.grs.common.service.DirectoryLocalServiceUtil;
import com.ihg.grs.util.DirectoryUtil;
import com.ihg.grs.util.PaginationUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Portlet implementation class DirectoryPortlet.
 */
public class DirectoryPortlet extends MVCPortlet
{

	private static final String DIRECTORY_ARTICLE_ID = "directoryArticleId";
	private static final String DELTA = "delta";
	private static final Log LOGGER = LogFactoryUtil.getLog(DirectoryPortlet.class.getName());

	/**
	 * Add, edit and list all directory.
	 * @param renderRequest A render request object.
	 * @param renderResponse A render response object.
	 */
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
	{
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		String cmd = ParamUtil.getString(httpRequest, "view");
		String id = ParamUtil.getString(httpRequest, "id");

		if ("add".equalsIgnoreCase(cmd))
		{
			viewAddDirectory(renderRequest, renderResponse);
		}
		else if (Validator.isNotNull(id))
		{
			viewEditDirectory(renderRequest, renderResponse);
		}
		else
		{
			viewListDirectory(renderRequest, renderResponse);
		}
	}

	/**
	 * Redirect to Add directory page.
	 * @param renderRequest A request object.
	 * @param renderResponse A response object.
	 */
	public void viewAddDirectory(RenderRequest renderRequest, RenderResponse renderResponse)
	{
		try
		{
			include("/html/directory/add.jsp", renderRequest, renderResponse);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
		catch (PortletException e)
		{
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * Allow to edit details of directory based on directory id.
	 * @param renderRequest A request object.
	 * @param renderResponse A response object.
	 */
	public void viewEditDirectory(RenderRequest renderRequest, RenderResponse renderResponse)
	{
		// Hide default error message
		SessionMessages.add(renderRequest, PortalUtil.getPortletId(renderRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		int directoryId = ParamUtil.getInteger(httpRequest, "id");
		if (Validator.isNotNull(directoryId))
		{
			try
			{
				Directory directory = DirectoryLocalServiceUtil.getDirectory(directoryId);
				renderRequest.setAttribute("directory", directory);
			}
			catch (PortalException e)
			{
				SessionErrors.add(renderRequest, "invalid-directory-id");
				LOGGER.debug("Not found directory with id " + directoryId);
			}
			catch (SystemException e)
			{
				SessionErrors.add(renderRequest, "error-processing-directory");
				LOGGER.error(e.getMessage());
			}
		}
		else
		{
			SessionErrors.add(renderRequest, "invalid-directory-id");
		}

		try
		{
			include("/html/directory/add.jsp", renderRequest, renderResponse);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
		catch (PortletException e)
		{
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * List of all directories to display.
	 * @param renderRequest A request object.
	 * @param renderResponse A response object.
	 */
	public void viewListDirectory(RenderRequest renderRequest, RenderResponse renderResponse)
	{
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		try
		{
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			PortletPreferences prefs = renderRequest.getPreferences();
			int delta = GetterUtil.getInteger(prefs.getValue(DELTA, "20"));
			String directoryArticleId = prefs.getValue(DIRECTORY_ARTICLE_ID, StringPool.BLANK);
			JournalArticle directoryArticle = null;

			int total = DirectoryLocalServiceUtil.getDirectoriesCount();

			if (LOGGER.isDebugEnabled()) 
			{
				LOGGER.debug("Total directory count: " + total);
			}

			PaginationUtil.paginate(httpRequest, total, delta);

			int start = GetterUtil.getInteger(renderRequest.getAttribute(PaginationUtil.START_INDEX), QueryUtil.ALL_POS);
			int end = GetterUtil.getInteger(renderRequest.getAttribute(PaginationUtil.END_INDEX), QueryUtil.ALL_POS);

			String sortBy = ParamUtil.getString(httpRequest, "sortBy", "lastName");
			String sortOrder = ParamUtil.getString(httpRequest, "sortOrder", "asc");

			List<Directory> directories = DirectoryUtil.getDirectories(start, end, sortBy, sortOrder);

			if (Validator.isNotNull(directoryArticleId))
			{
				try
				{
					directoryArticle = JournalArticleLocalServiceUtil.getLatestArticle(themeDisplay.getScopeGroupId(), directoryArticleId);
				}
				catch (PortalException e)
				{
					LOGGER.error(e.getMessage());
				}
			}

			renderRequest.setAttribute("total", total);
			renderRequest.setAttribute("directories", directories);
			renderRequest.setAttribute("sortBy", sortBy);
			renderRequest.setAttribute("sortOrder", sortOrder);
			renderRequest.setAttribute("directoryArticle", directoryArticle);
		}
		catch (SystemException e)
		{
			LOGGER.error("Error in fetching directory details.", e);
		}

		try
		{
			super.doView(renderRequest, renderResponse);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
		catch (PortletException e)
		{
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
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
			String resultDelta = ParamUtil.getString(actionRequest, DELTA);

			String directoryArticleId = ParamUtil.getString(actionRequest, DIRECTORY_ARTICLE_ID);

			PortletPreferences portletPreferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);

			portletPreferences.setValue(DELTA, resultDelta);
			portletPreferences.setValue(DIRECTORY_ARTICLE_ID, directoryArticleId);

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
	 * To create new directory.
	 * @param actionRequest Action request object.
	 * @param actionResponse Action response object.
	 */
	public void addDirectory(ActionRequest actionRequest, ActionResponse actionResponse)
	{
		Directory directory;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Date currentDate = new Date();
		// Hide default error message
		SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

		int directoryId = ParamUtil.getInteger(actionRequest, "directoryId");
		try
		{
			try
			{
				directory = DirectoryLocalServiceUtil.getDirectory(directoryId);
			}
			catch (PortalException e)
			{
				directory = DirectoryLocalServiceUtil.createDirectory((int) CounterLocalServiceUtil.increment(Directory.class.toString()));
			}

			String firstName = ParamUtil.getString(actionRequest, "firstName");
			String lastName = ParamUtil.getString(actionRequest, "lastName");
			String businessTitle = ParamUtil.getString(actionRequest, "businessTitle");
			String geoRegion = ParamUtil.getString(actionRequest, "geoRegion");
			String role = ParamUtil.getString(actionRequest, "role");
			String regionType = ParamUtil.getString(actionRequest, "regionType");
			String organizationName = ParamUtil.getString(actionRequest, "organizationName");
			String portraitURL = ParamUtil.getString(actionRequest, "portraitURL");
			String emailId=ParamUtil.getString(actionRequest, "email");

			directory.setFirstName(firstName);
			directory.setLastName(lastName);
			directory.setBusinessTitle(businessTitle);
			directory.setGeoRegion(geoRegion);
			directory.setRole(role);
			directory.setRegionType(regionType);
			directory.setOrganizationName(organizationName);
			directory.setPortraitURL(portraitURL);
			directory.setEmail(emailId);

			if (directory.isNew())
			{
				directory.setCreateUserId(themeDisplay.getUser().getScreenName());
				directory.setCreatedate(currentDate);
				directory.setLastUpdateUserId(themeDisplay.getUser().getScreenName());
				directory.setUpdatedate(currentDate);
			}
			else
			{
				directory.setLastUpdateUserId(themeDisplay.getUser().getScreenName());
				directory.setUpdatedate(currentDate);
			}

			directory.persist();

			SessionMessages.add(actionRequest, "directory-processed-successfully");

			if (LOGGER.isDebugEnabled()) 
			{
				LOGGER.debug("Directory added to database successfully.");
			}

		}
		catch (Exception e)
		{
			SessionErrors.add(actionRequest, "error-processing-directory");
			LOGGER.error(e.getMessage());
		}

		try
		{
			sendRedirect(actionRequest, actionResponse);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}
	}

}
