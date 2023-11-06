<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%@page import="com.ihg.grs.constant.ApplicationConstants"%>
<%@page import="com.ihg.grs.bean.ArticleInfoBean"%>
<%@page import="com.ihg.grs.bean.SearchVO"%>
<%@page import="com.ihg.grs.util.ArticleUtil"%>
<%@page import="com.ihg.grs.util.ActionUtil"%>
<%@page import="com.ihg.grs.util.DateUtil"%>
<%@ page import="com.liferay.portal.kernel.util.StringUtil" %>

<%@page import="java.util.List"%>
