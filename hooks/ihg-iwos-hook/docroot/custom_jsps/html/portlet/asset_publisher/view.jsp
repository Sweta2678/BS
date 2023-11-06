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
boolean isWayOfSales=false;
//com.liferay.portal.theme.ThemeDisplay themeDisplay 		= (com.liferay.portal.theme.ThemeDisplay)req.getAttribute(com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);
//com.liferay.portal.model.Layout ihgLayout = themeDisplay.getLayout();
//com.liferay.portal.model.Group ihggroup = com.liferay.portal.service.GroupLocalServiceUtil.getGroup( ihgLayout.getGroupId() );
String ihgtype=com.liferay.portal.util.PortalUtil.getCurrentURL(renderRequest);

if( ihgtype.indexOf("way-of-sales")!=-1){
		isWayOfSales=true;
}
if (mergeUrlTags || mergeLayoutTags) {
	String[] compilerTagNames = new String[0];

	if (mergeUrlTags) {
		compilerTagNames = ParamUtil.getParameterValues(request, "tags");
	}

	if (mergeLayoutTags) {
		Set<String> layoutTagNames = AssetUtil.getLayoutTagNames(request);

		if (!layoutTagNames.isEmpty()) {
			compilerTagNames = ArrayUtil.append(compilerTagNames, layoutTagNames.toArray(new String[layoutTagNames.size()]));
		}
	}

	String titleEntry = null;

	if (ArrayUtil.isNotEmpty(compilerTagNames)) {
		String[] newAssetTagNames = ArrayUtil.append(allAssetTagNames, compilerTagNames);

		allAssetTagNames = ArrayUtil.distinct(newAssetTagNames, new StringComparator());

		long[] allAssetTagIds = AssetTagLocalServiceUtil.getTagIds(siteGroupIds, allAssetTagNames);

		assetEntryQuery.setAllTagIds(allAssetTagIds);

		titleEntry = compilerTagNames[compilerTagNames.length - 1];
	}

	String portletTitle = portletDisplay.getTitle();

	portletTitle = AssetUtil.substituteTagPropertyVariables(scopeGroupId, titleEntry, portletTitle);

	renderResponse.setTitle(portletTitle);
}
else {
	allAssetTagNames = ArrayUtil.distinct(allAssetTagNames, new StringComparator());
}

for (String curAssetTagName : allAssetTagNames) {
	try {
		AssetTag assetTag = AssetTagLocalServiceUtil.getTag(scopeGroupId, curAssetTagName);

		AssetTagProperty journalTemplateIdProperty = AssetTagPropertyLocalServiceUtil.getTagProperty(assetTag.getTagId(), "journal-template-id");

		String journalTemplateId = journalTemplateIdProperty.getValue();

		request.setAttribute(WebKeys.JOURNAL_TEMPLATE_ID, journalTemplateId);

		break;
	}
	catch (NoSuchTagException nste) {
	}
	catch (NoSuchTagPropertyException nstpe) {
	}
}

if (enableTagBasedNavigation && selectionStyle.equals("manual") && ((assetEntryQuery.getAllCategoryIds().length > 0) || (assetEntryQuery.getAllTagIds().length > 0))) {
	selectionStyle = "dynamic";
}

Group scopeGroup = themeDisplay.getScopeGroup();
%>

<div class="subscribe-action">
	<c:if test="<%= !portletName.equals(PortletKeys.HIGHEST_RATED_ASSETS) && !portletName.equals(PortletKeys.MOST_VIEWED_ASSETS) && !portletName.equals(PortletKeys.RECENT_CONTENT) && !portletName.equals(PortletKeys.RELATED_ASSETS) && PortletPermissionUtil.contains(permissionChecker, plid, portletDisplay.getId(), ActionKeys.SUBSCRIBE) && AssetPublisherUtil.getEmailAssetEntryAddedEnabled(portletPreferences) %>">
		<c:choose>
			<c:when test="<%= AssetPublisherUtil.isSubscribed(themeDisplay.getCompanyId(), user.getUserId(), themeDisplay.getPlid(), portletDisplay.getId()) %>">
				<portlet:actionURL var="unsubscribeURL">
					<portlet:param name="struts_action" value="/asset_publisher/edit_subscription" />
					<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.UNSUBSCRIBE %>" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
				</portlet:actionURL>

				<liferay-ui:icon
					image="unsubscribe"
					label="<%= true %>"
					url="<%= unsubscribeURL %>"
				/>
			</c:when>
			<c:otherwise>
				<portlet:actionURL var="subscribeURL">
					<portlet:param name="struts_action" value="/asset_publisher/edit_subscription" />
					<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.SUBSCRIBE %>" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
				</portlet:actionURL>

				<liferay-ui:icon
					image="subscribe"
					label="<%= true %>"
					url="<%= subscribeURL %>"
				/>
			</c:otherwise>
		</c:choose>
	</c:if>

	<c:if test="<%= enableRSS %>">
		<liferay-portlet:resourceURL varImpl="rssURL">
			<portlet:param name="struts_action" value="/asset_publisher/rss" />
		</liferay-portlet:resourceURL>

		<liferay-ui:rss resourceURL="<%= rssURL %>" />
	</c:if>
</div>

<%
PortletURL portletURL = renderResponse.createRenderURL();

SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, delta, portletURL, null, null);

if (!paginationType.equals("none")) {
	searchContainer.setDelta(delta);
	searchContainer.setDeltaConfigurable(false);
}
%>

<% if (isWayOfSales){ %>
<div class="content-title bottom-pad"><liferay-ui:message key="ihg.article.asset.header.title.resources"/></div>
<div id="wos-asset-publisher">
	<ul class="asset-publisher-tabs">  
	  <li id="tab-showall" class="active" tab="all" title="<liferay-ui:message key="ihg.resources.asset.tabs.showall"/>"><liferay-ui:message key="ihg.resources.asset.tabs.showall"/></li>
	  <li id="tab-article" tab="articles" title="<liferay-ui:message key="ihg.resources.asset.tabs.articles"/>"><liferay-ui:message key="ihg.resources.asset.tabs.articles"/></li>
	  <li id="tab-tools" tab="tools" title="<liferay-ui:message key="ihg.resources.asset.tabs.tools"/>"><liferay-ui:message key="ihg.resources.asset.tabs.tools"/></li>
	  <li id="tab-links" tab="links" title="<liferay-ui:message key="ihg.resources.asset.tabs.links"/>"><liferay-ui:message key="ihg.resources.asset.tabs.links"/></li>
	  <br clear='all' />
	</ul>

	<c:if test="<%= showMetadataDescriptions %>">
		<liferay-ui:categorization-filter
			assetType="content"
			portletURL="<%= portletURL %>"
		/>
	</c:if>

	<%
	long portletDisplayDDMTemplateId = PortletDisplayTemplateUtil.getPortletDisplayTemplateDDMTemplateId(displayStyleGroupId, displayStyle);
	
	Map<String, Object> contextObjects = new HashMap<String, Object>();
	
	contextObjects.put(PortletDisplayTemplateConstants.ASSET_PUBLISHER_HELPER, AssetPublisherHelperUtil.getAssetPublisherHelper());
	%>

	<c:choose>
		<c:when test='<%= selectionStyle.equals("dynamic") %>'>
			<%@ include file="/html/portlet/asset_publisher/view_wofs_dynamic_list.ihg-iwos-hook.jspf" %>
		</c:when>
		<c:when test='<%= selectionStyle.equals("manual") %>'>
			<%@ include file="/html/portlet/asset_publisher/view_manual.jspf" %>
		</c:when>
	</c:choose>
	
	<c:if test='<%= !paginationType.equals("none") && (searchContainer.getTotal() > searchContainer.getResults().size()) %>'>
		<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" type="<%= paginationType %>" />
	</c:if>
</div>
<%}else{ %>
	<c:if test="<%= showMetadataDescriptions %>">
		<liferay-ui:categorization-filter
			assetType="content"
			portletURL="<%= portletURL %>"
		/>
	</c:if>

	<%
	long portletDisplayDDMTemplateId = PortletDisplayTemplateUtil.getPortletDisplayTemplateDDMTemplateId(displayStyleGroupId, displayStyle);
	
	Map<String, Object> contextObjects = new HashMap<String, Object>();
	
	contextObjects.put(PortletDisplayTemplateConstants.ASSET_PUBLISHER_HELPER, AssetPublisherHelperUtil.getAssetPublisherHelper());
	%>

	<c:choose>
		<c:when test='<%= selectionStyle.equals("dynamic") %>'>
			<%@ include file="/html/portlet/asset_publisher/view_dynamic_list.jspf" %>
		</c:when>
		<c:when test='<%= selectionStyle.equals("manual") %>'>
			<%@ include file="/html/portlet/asset_publisher/view_manual.jspf" %>
		</c:when>
	</c:choose>
	
	<c:if test='<%= !paginationType.equals("none") && (searchContainer.getTotal() > searchContainer.getResults().size()) %>'>
		<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" type="<%= paginationType %>" />
	</c:if>
<%} %>
<%!
private static Log _log = LogFactoryUtil.getLog("portal-web.docroot.html.portlet.asset_publisher.view_jsp");
%>
