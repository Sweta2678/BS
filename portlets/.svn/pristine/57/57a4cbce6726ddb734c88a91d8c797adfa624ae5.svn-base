
package com.ihg.grs.portlet;

import com.ihg.me2.core.service.CoreNotificationSubscriptionLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.portlet.PortletProps;

import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Portlet implementation class SubscriptionPortlet.
 */
public class SubscriptionPortlet extends MVCPortlet
{

	private static final Log LOGGER = LogFactoryUtil.getLog(SubscriptionPortlet.class);

	/*
	 * (non-Javadoc).
	 * @see
	 * com.liferay.util.bridges.mvc.MVCPortlet#doView(javax.portlet.RenderRequest
	 * , javax.portlet.RenderResponse)
	 */
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
	{

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
		httpServletRequest = PortalUtil.getOriginalServletRequest(httpServletRequest);
		String actionType = ParamUtil.get(httpServletRequest, "actionType", StringPool.BLANK);
		try
		{
			String categoyId = StringPool.BLANK;
			categoyId = ParamUtil.getString(httpServletRequest, "categoryId");
			CoreNotificationSubscriptionLocalServiceUtil.addDeleteSubscription(categoyId, themeDisplay, actionType);

			// Get the list of AssetCategory
			List<AssetCategory> assetCategories =
				CoreNotificationSubscriptionLocalServiceUtil.getAssetCategories(PortletProps.get("subscription-local-vocabulary-name"), themeDisplay.getScopeGroupId());
			Map<Long, String> userSubscriptionMap = CoreNotificationSubscriptionLocalServiceUtil.getUserSubscriptions(assetCategories, themeDisplay);

			renderRequest.setAttribute("userSubscriptionMap", userSubscriptionMap);
			renderRequest.setAttribute("assetCategories", assetCategories);

			super.doView(renderRequest, renderResponse);
		}
		catch (Exception e)
		{
			LOGGER.error("Error During Subscription. ", e);
		}
	}
}
