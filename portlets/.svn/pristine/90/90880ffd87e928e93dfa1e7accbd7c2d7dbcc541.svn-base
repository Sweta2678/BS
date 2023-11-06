
package com.ihg.grs.portlet;

import com.ihg.grs.constant.ApplicationConstants;
import com.ihg.grs.util.SearchUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Portlet implementation class SearchPortlet.
 */
public class SearchPortlet extends MVCPortlet
{

	private static final Log LOGGER = LogFactoryUtil.getLog(SearchPortlet.class);

	@Override
	public void render(RenderRequest request, RenderResponse response)
	{

		try
		{
			if (Validator.isNull(request.getAttribute("action")))
			{
				LOGGER.info("***************************Inside Site Search portlet***************************");

				String keywords = ParamUtil.get(request, "q", StringPool.BLANK);
				int sort = ParamUtil.get(request, "sort", -1);

				if (Validator.isNull(keywords) || Validator.isNull(sort))
				{
					HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(request);
					httpServletRequest = PortalUtil.getOriginalServletRequest(httpServletRequest);

					keywords = ParamUtil.get(httpServletRequest, "q", StringPool.BLANK);
					sort = ParamUtil.get(httpServletRequest, "sort", -1);
				}

				if (keywords.trim().length() > 0)
				{
					request.setAttribute("searchList", SearchUtil.getSearchResults(keywords, request, sort));
				}

				request.setAttribute("search_keywords", keywords);
				request.setAttribute("sort", sort);
			}
			super.render(request, response);
		}
		catch (IOException e)
		{
			LOGGER.error(e.getMessage(), e);
		}	
		catch (PortletException e)
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
				String recordsPerPage = prefs.getValue(ApplicationConstants.SITE_SEARCH_RESULTS_PER_PAGE, "10");
				renderRequest.setAttribute(ApplicationConstants.SITE_SEARCH_RESULTS_PER_PAGE, recordsPerPage);
				String structureKeys = prefs.getValue(ApplicationConstants.SITE_SEARCH_STRUCTURE_KEYS, StringPool.BLANK);
				renderRequest.setAttribute(ApplicationConstants.SITE_SEARCH_STRUCTURE_KEYS, structureKeys);

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
	public void setSearchResultsPreferences(ActionRequest actionRequest, ActionResponse actionResponse)
	{

		try
		{
			PortletPreferences portletPreferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);
			portletPreferences.setValue(ApplicationConstants.SITE_SEARCH_RESULTS_PER_PAGE, ParamUtil.getString(actionRequest, ApplicationConstants.PREF_SITE_SEARCH_RESULTS_PER_PAGE, "10"));
			portletPreferences.setValue(ApplicationConstants.SITE_SEARCH_STRUCTURE_KEYS, ParamUtil.getString(actionRequest, ApplicationConstants.SITE_SEARCH_PREF_STRUCTURE_KEYS, StringPool.BLANK));
			portletPreferences.store();

		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage(), e);
		}
	}

}
