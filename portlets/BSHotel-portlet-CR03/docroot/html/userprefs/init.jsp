<%@include file="/html/init.jsp" %>

<%@page import="java.util.Calendar" %>
<%@page import="java.util.Collections" %>
<%@page import="javax.portlet.PortletURL" %>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil" %>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil" %>
<%@page import="com.liferay.portal.model.Role" %>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.ihg.me2.utils.session.MerlinCache"%>
<%@page import="com.ihg.me2.brandstandards.custom.util.BrandStandardsUtil"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsLocale"%>
<%@page import="com.ihg.brandstandards.db.model.FlagCategory"%>
<%@page import="com.ihg.me2.brandstandards.custom.pojo.AccessAndPreferences"%>