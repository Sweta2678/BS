<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.theme.NavItem"%>
<%@include file="../init.jsp"%>
<c:set var="navItems" value="<%=NavItem.fromLayouts(request, themeDisplay.getLayouts(), null)%>" />
<c:set var="portalUrl" value="${themeDisplay.getPortalURL()}"></c:set>
<c:set var="groupId" value="${themeDisplay.scopeGroup.friendlyURL }"></c:set>
<c:set var="currentUrl" value="${themeDisplay.getURLCurrent()}"></c:set>
<!-- Change netwrok header start -->

<div class="changeNetworkHeader">
	<div class="docheadcon">
		<h1><%= Validator.isNull(layout.getTitle(Locale.US)) ? layout.getName(Locale.US) : layout.getTitle(Locale.US)  %></h1>
		<c:if test="${fn:contains(currentUrl, '/web/concerto-hotel-hub/resources') || fn:contains(currentUrl, '/web/concerto-change-network/action-plans-guides')}">
			<span><a href="${portalUrl}/web${groupId}/asset-library">Asset Library</a></span>
		</c:if>
	</div>
	
	<ul class="tabs">
		<c:forEach items="${navItems }" var="navItem">
			<c:choose>
				<c:when test="${navItem.layout.plid eq plid }">
					<li class="active">${navItem.name}</li>
				</c:when>
				<c:otherwise>
					<li><a href="${navItem.URL}">${navItem.name}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</ul>
</div>
