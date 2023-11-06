<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="/html/init.jsp" %>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.util.PwdGenerator"%>
<%@page import="com.ihg.brandstandards.db.model.GlossaryTranslate"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsLocale"%>
<%@page import="com.ihg.brandstandards.bsadmin.model.GlossaryTranslationView"%>
<%@page import="com.ihg.brandstandards.util.GlossaryUtil"%>
<%@page import="com.ihg.brandstandards.util.IndexTranslationUtil"%>
<%@page import="com.ihg.brandstandards.util.StandardsUtil"%>

<script type="text/javascript" src="/BSTheme-theme/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery-ui-1.10.1.custom.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.validate.min-1.11.1.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/additional-methods.min-1.11.1.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.form.3.28.0.js"></script>

<script type="text/javascript" src="/BSTheme-theme/js/jquery.multiselect.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.blockUI.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.msgBox.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.nyroModal.custom.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/glossary.js"></script>

<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/msgBoxLight.css" />
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/jquery.multiselect.css" />
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/other/jquery-ui-1.10.1/themes/base/jquery.ui.all.css" />
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/glossary.css" />
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/bsstyle.css" />