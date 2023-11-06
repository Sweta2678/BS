<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
--%>

<%@ include file="/html/portlet/asset_publisher/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

List results = (List)request.getAttribute("view.jsp-results");

if (Validator.isNull(redirect) && results.isEmpty()) {
	PortletURL portletURL = renderResponse.createRenderURL();

	portletURL.setParameter("struts_action", "/asset_publisher/view");

	redirect = portletURL.toString();
}

int assetEntryIndex = ((Integer)request.getAttribute("view.jsp-assetEntryIndex")).intValue();

AssetEntry assetEntry = (AssetEntry)request.getAttribute("view.jsp-assetEntry");
AssetRendererFactory assetRendererFactory = (AssetRendererFactory)request.getAttribute("view.jsp-assetRendererFactory");
AssetRenderer assetRenderer = (AssetRenderer)request.getAttribute("view.jsp-assetRenderer");

String languageId = LanguageUtil.getLanguageId(request);

String title = assetRenderer.getTitle(LocaleUtil.fromLanguageId(languageId));

boolean show = ((Boolean)request.getAttribute("view.jsp-show")).booleanValue();
boolean print = ((Boolean)request.getAttribute("view.jsp-print")).booleanValue();

request.setAttribute(WebKeys.LAYOUT_ASSET_ENTRY, assetEntry);

request.setAttribute("view.jsp-fullContentRedirect", currentURL);
request.setAttribute("view.jsp-showIconLabel", true);
%>

<div class="asset-full-content <%= defaultAssetPublisher ? "default-asset-publisher" : StringPool.BLANK %> <%= showAssetTitle ? "show-asset-title" : "no-title" %>">

	<%

	// Dynamically created asset entries are never persisted so incrementing the view counter breaks

	if (!assetEntry.isNew() && assetEntry.isVisible()) {
		AssetEntry incrementAssetEntry = null;

		if (assetEntryQuery.isEnablePermissions()) {
			incrementAssetEntry = AssetEntryServiceUtil.incrementViewCounter(assetEntry.getClassName(), assetEntry.getClassPK());
		}
		else {
			incrementAssetEntry = AssetEntryLocalServiceUtil.incrementViewCounter(user.getUserId(), assetEntry.getClassName(), assetEntry.getClassPK());
		}

		if (incrementAssetEntry != null) {
			assetEntry = incrementAssetEntry;
		}
	}

	if (showContextLink) {
		if (PortalUtil.getPlidFromPortletId(assetRenderer.getGroupId(), assetRendererFactory.getPortletId()) == 0) {
			showContextLink = false;
		}
	}

	PortletURL viewFullContentURL = renderResponse.createRenderURL();

	viewFullContentURL.setParameter("struts_action", "/asset_publisher/view_content");
	viewFullContentURL.setParameter("type", assetRendererFactory.getType());
	viewFullContentURL.setParameter("viewMode", print ? Constants.PRINT : Constants.VIEW);

	if (Validator.isNotNull(assetRenderer.getUrlTitle())) {
		if (assetRenderer.getGroupId() != scopeGroupId) {
			viewFullContentURL.setParameter("groupId", String.valueOf(assetRenderer.getGroupId()));
		}

		viewFullContentURL.setParameter("urlTitle", assetRenderer.getUrlTitle());
	}

	String viewFullContentURLString = viewFullContentURL.toString();

	viewFullContentURLString = HttpUtil.setParameter(viewFullContentURLString, "redirect", currentURL);
	%>

	<div class="asset-content" id="<portlet:namespace /><%= assetEntry.getEntryId() %>"  style="margin:0px">
		<c:if test='<%= enableSocialBookmarks && socialBookmarksDisplayPosition.equals("top") && !print %>'>
			<liferay-ui:social-bookmarks
				contentId="<%= String.valueOf(assetEntry.getEntryId()) %>"
				displayStyle="<%= socialBookmarksDisplayStyle %>"
				target="_blank"
				title="<%= title %>"
				url="<%= PortalUtil.getCanonicalURL(viewFullContentURL.toString(), themeDisplay, layout) %>"
			/>
		</c:if>

		<%
		String path = assetRenderer.render(renderRequest, renderResponse, AssetRenderer.TEMPLATE_FULL_CONTENT);

		request.setAttribute(WebKeys.ASSET_RENDERER_FACTORY, assetRendererFactory);
		request.setAttribute(WebKeys.ASSET_RENDERER, assetRenderer);
		%>

		<liferay-util:include page="<%= path %>" portletId="<%= assetRendererFactory.getPortletId() %>">
			<liferay-util:param name="showHeader" value="<%= Boolean.FALSE.toString() %>" />
		</liferay-util:include>

		<c:if test="<%= showContextLink && !print && assetEntry.isVisible() %>">
			<div class="asset-more">
				<a href="<%= assetRenderer.getURLViewInContext(liferayPortletRequest, liferayPortletResponse, viewFullContentURLString) %>"><liferay-ui:message key="<%= assetRenderer.getViewInContextMessage() %>" /> &raquo;</a>
			</div>
		</c:if>

		<br />
	</div>
</div>

<%!
private static Log _log = LogFactoryUtil.getLog("portal-web.docroot.html.portlet.asset_publisher.display_full_content_jsp");
%>