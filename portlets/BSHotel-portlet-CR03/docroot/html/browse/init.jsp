<%@include file="/html/init.jsp" %>

<%@page import="java.util.Map"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Calendar" %>
<%@page import="java.util.Collections" %>
<%@page import="java.util.LinkedHashMap"%>

<%@page import="javax.portlet.PortletURL" %>
<%@page import="com.liferay.portal.kernel.util.StringPool" %>

<%@page import="com.ihg.me2.utils.session.MerlinCache"%>
<%@page import="com.ihg.me2.brandstandards.custom.util.BrandStandardsUtil"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsLocale"%>
<%@page import="com.ihg.brandstandards.db.model.FlagCategory"%>
<%@page import="com.ihg.me2.brandstandards.custom.pojo.AccessAndPreferences"%>
<%@page import="com.ihg.me2.brandstandards.custom.pojo.Taxonomy"%>
<%@page import="com.ihg.brandstandards.custom.model.Standard"%>
<%@page import="com.ihg.brandstandards.db.model.PublishTaxonomyExt"%>
<%@page import="com.ihg.brandstandards.db.service.FlagCategoryLocalServiceUtil"%>
<%@page import="com.ihg.me2.brandstandards.custom.pojo.StandardsSearchCriteria"%>
<%@page import="com.ihg.brandstandards.db.service.PublicationLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.db.model.Publication"%>
<%@page import="com.ihg.me2.brandstandards.custom.util.BrandStandardsConstant"%>
<%@ page import="javax.portlet.PortletPreferences" %>
