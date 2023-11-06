<%
/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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
%>
<%@include file="/html/init.jsp" %>
<%@page import="com.ihg.brandstandards.util.ManualsUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.ihg.brandstandards.util.BrandStandardsUtil"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.db.model.Taxonomy"%>
<%@page import="java.util.List,java.text.DecimalFormat"%>
<%@page import="com.ihg.brandstandards.db.service.StandardsLocalServiceUtil"%>

<%
	long userId = PortalUtil.getUserId(renderRequest);
	if (userId > 1)
	{
		DecimalFormat formatter = new DecimalFormat("###,###");
		boolean approver = true;
		long stdCount = StandardsLocalServiceUtil.getStdTypeCount("STD");
		long specCount = StandardsLocalServiceUtil.getStdTypeCount("SPEC");
		long guidelnCount = StandardsLocalServiceUtil.getStdTypeCount("GDLN");
%>

    <div class="horiz_summary_cont">
        <ul>
            <li class="horiz_summary">Summary</li>
            <li class="horiz_data">Standards: <span class="horiz_nobold"><%= formatter.format(stdCount)%></span></li>
            <li class="horiz_data">Specifications: <span class="horiz_nobold"><%=formatter.format(specCount)%></span></li>
            <li class="horiz_data">Guidelines: <span class="horiz_nobold"><%=formatter.format(guidelnCount)%></span></li>
        </ul>
    </div>
<%
	}
%>