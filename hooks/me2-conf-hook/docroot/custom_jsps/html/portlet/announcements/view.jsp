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

<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page
	import="com.liferay.portlet.announcements.service.AnnouncementsEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar" %>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Date"%>
<%@ include file="/html/portlet/announcements/init.jsp" %>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>

<%! String announcementDateFormat(Date date){
	StringBuilder dateString = new StringBuilder();
	Calendar  calendar = new GregorianCalendar();
	Date current = calendar.getTime();
	
	//in milliseconds
	long diff = current.getTime() - date.getTime();

	long diffSeconds = diff / 1000 % 60;
	long diffMinutes = diff / (60 * 1000) % 60;
	long diffHours = diff / (60 * 60 * 1000) % 24;
	long diffDays = diff / (24 * 60 * 60 * 1000);
	
	calendar.setTime(date);
	int hour = calendar.get(Calendar.HOUR);
	int minute = calendar.get(Calendar.MINUTE);	
	String AM_PM = "";
	switch(calendar.get(Calendar.AM_PM)){
		case Calendar.AM: AM_PM = "AM";
		break;
		case Calendar.PM: AM_PM = "PM";
	}
	if(diffDays < 2){
		if(diffDays < 1){
			if(diffHours < 1){
				if(diffMinutes < 1){
					dateString.append("Just Now");	
				}else{
					dateString.append(diffMinutes).append(StringPool.SPACE).append(diffMinutes==1?"minute":"minutes").append(" ago");
				}
			}else{
				dateString.append(diffHours).append(StringPool.SPACE).append(diffHours==1?"hour":"hours").append(" ago");
			}
		}else{
			dateString.append("Yesterday");	
		}
	}else{
		dateString.append(diffDays).append(StringPool.SPACE).append(diffDays==1?"day":"days").append(" ago");
	}
	dateString.append(StringPool.SPACE).append(hour).append(":").append(minute<10?"0":"").append(minute).append(StringPool.SPACE).append(AM_PM);

	return dateString.toString();
}
%>


<!-- <h1 class="black">Blurbs</h1> -->
<%
String tabs1 = ParamUtil.getString(request, "tabs1", "entries");

PortletURL tabs1URL = renderResponse.createRenderURL();
PortletURL portletURL = renderResponse.createRenderURL();

tabs1URL.setParameter("struts_action", "/announcements/view");
tabs1URL.setParameter("tabs1", tabs1);
/* tabs1URL.setParameter("windowState", WindowState.MAXIMIZED.toString());
tabs1URL.setParameter("redirect", currentURL);
if(tabs1.equals("manage-entries")){
}
 */
String tabs1Names = "entries,manage-entries";

/* if ((UserGroupRoleLocalServiceUtil.hasUserGroupRole(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),RoleConstants.COMMUNITY_OWNER)) || (UserGroupRoleLocalServiceUtil.hasUserGroupRole(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),RoleConstants.COMMUNITY_ADMINISTRATOR)) || (renderRequest.isUserInRole(RoleConstants.ADMINISTRATOR))) {
	 tabs1Names += ",manage-entries";
} */
		
String distributionScope = PortalUtil.getClassNameId(Group.class) + StringPool.COMMA + themeDisplay.getLayout().getGroup().getGroupId();
String[] distributionScopeArray = StringUtil.split(distributionScope);
long classNameId = GetterUtil.getLong(distributionScopeArray[0]);
long classPK = GetterUtil.getLong(distributionScopeArray[1]);

DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AnnouncementsEntry.class);

Criterion rest1 = RestrictionsFactoryUtil.eq("classNameId", classNameId);

dynamicQuery.add(rest1);
rest1 = RestrictionsFactoryUtil.eq("classPK", classPK);
dynamicQuery.add(rest1);
dynamicQuery.addOrder(OrderFactoryUtil.desc("displayDate"));

List<AnnouncementsEntry>  AnnouncementsEntryResults =  AnnouncementsEntryLocalServiceUtil.dynamicQuery(dynamicQuery);

if (PortletPermissionUtil.contains(permissionChecker, plid, PortletKeys.ANNOUNCEMENTS, ActionKeys.ADD_ENTRY)) {	
%>
	<c:if test="<%= !portletName.equals(PortletKeys.ALERTS) || (portletName.equals(PortletKeys.ALERTS) && AnnouncementsEntryPermission.contains(permissionChecker, layout, PortletKeys.ALERTS, ActionKeys.ADD_ENTRY)) %>">
		<liferay-ui:tabs
		names="<%= tabs1Names %>"
		url="<%= tabs1URL.toString() %>"></liferay-ui:tabs>
	</c:if>
	
	<c:choose>
		<c:when test='<%= tabs1.equals("entries") %>'>
			<%@ include
				file="/html/portlet/announcements/blurbsDisplay.me2-conf-hook.jsp"%>
		</c:when>
		<c:when test='<%= tabs1.equals("manage-entries") %>'>
			<%
				PortletURL iteratorURL = PortletURLUtil.clone(portletURL, renderResponse);
				iteratorURL.setParameter("distributionScope", distributionScope);
				iteratorURL.setParameter("tabs1", "manage-entries");
				
				%>

							<aui:form action="<%= portletURL.toString() %>" method="post" name="fm">
							<aui:button onClick='<%= renderResponse.getNamespace() + "addEntry()" %>' value="add-entry" cssClass="button"/>
							</aui:form>
							<div class="separator"><!-- --></div>
							<liferay-ui:search-container iteratorURL="<%=iteratorURL %>" emptyResultsMessage="no-records-were-found" delta="10">
							<liferay-ui:search-container-results>
							
							<%
								List AnnouncementsResults = ListUtil.subList(AnnouncementsEntryResults, searchContainer.getStart(), searchContainer.getEnd());
								total = AnnouncementsEntryResults.size();
								pageContext.setAttribute("results", AnnouncementsResults);
								pageContext.setAttribute("total", total);			
							%>
							</liferay-ui:search-container-results>
							<liferay-ui:search-container-row className="com.liferay.portlet.announcements.model.AnnouncementsEntry" keyProperty="entryId" modelVar="blogsEntry" >
							
							<liferay-ui:search-container-column-text name="Title" property="title" />
							<liferay-ui:search-container-column-text name="Type" property="type" />
							
							 <liferay-ui:search-container-column-jsp path="/html/portlet/announcements/blurbsDisplay_view_manage_entries_entry_action.me2-conf-hook.jsp" align="right"/>
							
							</liferay-ui:search-container-row>
							
							<liferay-ui:search-iterator/>
							</liferay-ui:search-container> 
				
				<aui:script>
					function <portlet:namespace />addEntry() {
						location.href = '<portlet:renderURL windowState="<%=WindowState.MAXIMIZED.toString()%>"><portlet:param name="struts_action" value="/announcements/edit_entry" /><portlet:param name="redirect" value="<%= currentURL %>" /><portlet:param name="distributionScope" value="<%= distributionScope %>" /></portlet:renderURL>';
					}
				
					function <portlet:namespace />selectDistributionScope(distributionScope) {
						var url = "<%= portletURL.toString() %>&<portlet:namespace />distributionScope=" + distributionScope;
						submitForm(document.<portlet:namespace />fm, url);
					}
				</aui:script>
		</c:when>
	</c:choose>
<%
}else{
	%>
	<%@ include
			file="/html/portlet/announcements/blurbsDisplay.me2-conf-hook.jsp"%>
	<% 
}
%>