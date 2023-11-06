
package com.ihg.grs.portlet;

import com.ihg.grs.bean.MBMessageBean;
import com.ihg.grs.constant.ApplicationConstants;
import com.ihg.grs.constant.DiscussionConstant;
import com.ihg.grs.util.ActionUtil;
import com.ihg.grs.util.DiscussionCommonUtil;
import com.ihg.me2.core.bean.MBMessageInfo;
import com.ihg.me2.core.service.CoreMessageLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class HomepageCarouselPortlet.
 */
public class MostCommentedDiscussionPortlet extends MVCPortlet
{

	private static final Log LOGGER = LogFactoryUtil.getLog(MostCommentedDiscussionPortlet.class.getName());

	/**
	 * Retrieving list of most commented discussions.
	 * @param renderRequest A render request object.
	 * @param renderResponse A render response object.
	 */
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
	{
		LOGGER.debug("Inside MostCommentedDiscussionPortlet :: doView()");

		try
		{

			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			PortletPreferences prefs = renderRequest.getPreferences();

			List<MBMessageBean> lstMBMessageBean = new ArrayList<MBMessageBean>();

			int noOfRecords = 0;

			if (Validator.isNotNull(prefs))
			{
				noOfRecords = Integer.parseInt(prefs.getValue(ApplicationConstants.NO_OF_ARTICLES, "0"));
			}

			LOGGER.debug("GRS :: MostCommentedDiscussionPortlet Preferences are - noOfRecords : " + noOfRecords);

			if (noOfRecords > 0)
			{
				List<MBMessageInfo> lstMBMessageInfo = CoreMessageLocalServiceUtil.getMostCommentedMessage(themeDisplay.getScopeGroupId(), null, 0, noOfRecords);
				lstMBMessageBean = ActionUtil.convetToMBMessagePojo(lstMBMessageInfo);
			}

			renderRequest.setAttribute("discussionList", lstMBMessageBean);
			renderRequest.setAttribute("discussionCommentsURL", DiscussionCommonUtil.getFullURLByPageName(renderRequest, DiscussionConstant.DISCUSSION_DETAIL));

			super.doView(renderRequest, renderResponse);

		}
		catch (Exception e)
		{
			LOGGER.error("Exception thrown from MostCommentedDiscussionPortlet :: doView()", e);
		}

	}

	/**
	 * Setting preferences for Homepage Carousel Portlet.
	 * 
	 * @param actionRequest
	 *            Action request is passed when Preferences saved.
	 * @param actionResponse
	 *            After saving action response is passing response.
	 */
	public void setMostCommentedDiscussionPreference(ActionRequest actionRequest, ActionResponse actionResponse)
	{

		try
		{
			PortletPreferences portletPreferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);

			portletPreferences.setValue(ApplicationConstants.NO_OF_ARTICLES, ParamUtil.getString(actionRequest, ApplicationConstants.NO_OF_ARTICLES, StringPool.BLANK));

			portletPreferences.store();

		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage(), e);
		}
	}

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException
	{

		PortletPreferences prefs = renderRequest.getPreferences();
		if (Validator.isNotNull(prefs))
		{

			String articlesPerPage = prefs.getValue(ApplicationConstants.NO_OF_ARTICLES, StringPool.BLANK);
			renderRequest.setAttribute(ApplicationConstants.NO_OF_ARTICLES, articlesPerPage);

		}
		super.doEdit(renderRequest, renderResponse);
	}

}
