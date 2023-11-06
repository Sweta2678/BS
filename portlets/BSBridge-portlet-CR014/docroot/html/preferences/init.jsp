<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%@page import="java.util.Map"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Calendar" %>
<%@page import="java.util.Collections" %>
<%@page import="java.util.LinkedHashMap"%>

<%@page import="javax.portlet.PortletURL" %>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil" %>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil" %>
<%@page import="com.liferay.portal.model.Role" %>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.util.PortalUtil" %>

<%@page import="com.ihg.me2.utils.session.MerlinCache"%>
<%@page import="com.ihg.brandstandards.bridge.util.BrandStandardsUtil"%>
<%@page import="com.ihg.brandstandards.custom.model.Preferences"%>