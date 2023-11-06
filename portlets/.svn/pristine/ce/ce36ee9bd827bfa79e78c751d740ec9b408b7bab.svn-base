<%
/**
* Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
*
* This library is free software; you can redistribute it and/or modify it under
* the terms of the GNU Lesser General Public License as published by the Free
* Software Foundation; either version 2.1 of the License, or (at your option)
* any later version.
*
* This library is distributed in the hope that it will be useful, but WITHOUT
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
* FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
* details.
*/
%>
<%@include file="/html/init.jsp" %>

<%@page import="javax.portlet.PortletURL" %>
<%@page import="org.apache.commons.lang.StringEscapeUtils"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Calendar" %>
<%@page import="java.util.Collections" %>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="com.liferay.portal.kernel.bean.BeanParamUtil" %>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@page import="com.liferay.portal.kernel.search.SearchContext" %>
<%@page import="com.liferay.portal.kernel.search.SearchContextFactory" %>
<%@page import="com.liferay.portal.kernel.search.Hits" %>
<%@page import="com.liferay.portal.kernel.search.Document" %>
<%@page import="com.liferay.portal.kernel.search.Field" %>
<%@page import="com.liferay.portal.kernel.search.Indexer"%>
<%@page import="com.liferay.portal.kernel.search.IndexerRegistryUtil" %>
<%@page import="com.liferay.portal.kernel.util.StringPool" %>
<%@page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@page import="com.liferay.portal.kernel.util.Validator" %>
<%@page import="com.liferay.portal.kernel.log.Log" %>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %>
<%@page import="com.liferay.portal.security.permission.ActionKeys" %>
<%@page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@page import="com.liferay.portal.service.permission.PortalPermissionUtil" %>
<%@page import="com.liferay.portal.service.permission.PortletPermissionUtil" %>
<%@page import="com.liferay.portal.util.PortalUtil" %>
<%@page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil" %>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil" %>
<%@page import="com.liferay.portal.model.Role" %>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.ihg.brandstandards.db.model.ChainStandards"%>
<%@page import="com.ihg.brandstandards.util.StandardsUtil"%>
<%@page import="com.ihg.brandstandards.util.BrandStandardsUtil"%>
<%@page import="com.ihg.brandstandards.db.model.Standards"%>
<%@page import="com.ihg.brandstandards.db.model.FlagCategory"%>
<%@page import="com.ihg.brandstandards.db.model.Taxonomy"%>
<%@page import="com.ihg.brandstandards.db.service.StandardsLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.db.service.TaxonomyLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.db.service.FlagCategoryLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.db.service.StandardsLocaleLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsLocale"%>
<%@page import="com.ihg.brandstandards.db.service.StandardsLocalService"%>
<%@page import="com.ihg.brandstandards.db.model.FlagStandards"%>
<%@page import="com.ihg.brandstandards.db.service.HistManualsLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.db.model.HistManuals"%>
<%@page import="com.ihg.brandstandards.bsadmin.model.StandardsView"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.util.DLUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%
String currentURL = PortalUtil.getCurrentURL(request);
%>