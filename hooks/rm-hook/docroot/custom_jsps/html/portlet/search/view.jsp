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

<%@ include file="/html/portlet/search/init.jsp" %>

<%@ page import="com.liferay.taglib.aui.AUIUtil" %>
<%@ page import="com.liferay.taglib.util.InlineUtil" %>

<%
PortletRequest portletRequest = (PortletRequest)request.getAttribute(JavaConstants.JAVAX_PORTLET_REQUEST);

PortletResponse portletResponse = (PortletResponse)request.getAttribute(JavaConstants.JAVAX_PORTLET_RESPONSE);

String namespace = StringPool.BLANK;

namespace = StringPool.BLANK;
boolean useNamespace = GetterUtil.getBoolean((String)request.getAttribute("aui:form:useNamespace"), true);

if ((portletResponse != null) && useNamespace) {
	namespace = portletResponse.getNamespace();
}

//String currentURL = PortalUtil.getCurrentURL(request);
%>
<%
long groupId = ParamUtil.getLong(request, namespace + "groupId");

Group group = themeDisplay.getScopeGroup();

String keywords = ParamUtil.getString(request, namespace + "keywords");

PortletURL portletURL = null;

if (portletResponse != null) {
	LiferayPortletResponse liferayPortletResponse = (LiferayPortletResponse)portletResponse;

	portletURL = liferayPortletResponse.createLiferayPortletURL(PortletKeys.SEARCH, PortletRequest.RENDER_PHASE);
}
else {
	portletURL = new PortletURLImpl(request, PortletKeys.SEARCH, plid, PortletRequest.RENDER_PHASE);
}

portletURL.setParameter("struts_action", "/search/search");
portletURL.setParameter("redirect", currentURL);
portletURL.setPortletMode(PortletMode.VIEW);
portletURL.setWindowState(WindowState.MAXIMIZED);

pageContext.setAttribute("portletURL", portletURL);
%>

<form action="<%= HtmlUtil.escapeAttribute(portletURL.toString()) %>" method="get" name="<%= namespace %>fm" onSubmit="<%= namespace %>search(); return false;">
<liferay-portlet:renderURLParams varImpl="portletURL" />

<input name="<%= namespace %>keywords" size="30" title="<liferay-ui:message key="search" />" type="text" value="<%= HtmlUtil.escapeAttribute(keywords) %>" />

<select name="<%= namespace %>groupId" title="<liferay-ui:message key="scope" /> ">
	<%-- <option value="0" <%= (groupId == 0) ? "selected" : "" %>><liferay-ui:message key="everything" /></option> --%>
	<option value="<%= group.getGroupId() %>" <%= (groupId != 0) ? "selected" : "" %>><liferay-ui:message key='<%= "this-" + (group.isOrganization() ? "organization" : "site") %>' /></option>
</select>

<input align="absmiddle" border="0" src="<%= themeDisplay.getPathThemeImages() %>/common/search.png" title="<liferay-ui:message key="search" />" type="image" />

<aui:script>
	function <%= namespace %>search() {
		var keywords = document.<%= namespace %>fm.<%= namespace %>keywords.value;

		keywords = keywords.replace(/^\s+|\s+$/, '');

		if (keywords != '') {
			submitForm(document.<%= namespace %>fm);
		}
	}
</aui:script>