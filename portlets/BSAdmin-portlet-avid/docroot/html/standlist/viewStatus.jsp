<%@include file="/html/standlist/init.jsp" %>
<%@page import="com.ihg.brandstandards.db.model.StandardsStatus"%>
<%@page import="com.ihg.brandstandards.util.StandardsStatusUtil"%>

<script type="text/javascript" src="/BSTheme-theme/js/jquery-1.9.1.min.js"></script>
<link href="/BSTheme-theme/css/other/jquery-ui-1.10.1/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css" />
<script src="/BSTheme-theme/js/jquery-ui-1.10.1.custom.min.js"></script>
<script src="/BSTheme-theme/js/jquery.multiselect.min.js"></script>

<%Standards standard = (Standards) request.getAttribute("standards");
ChainStandards chainStandard = (ChainStandards) request.getAttribute("chainStandards");
String selectStatusId = "status_"+standard.getStdId();
List<StandardsStatus> statusList = StandardsStatusUtil.getStatuses(standard);
%>
<select label="" class="status_select" name="status" inlineLabel="left" id="<%=selectStatusId %>" onfocus="getCurrentValue(<%=standard.getStdId() %>, this)" onChange="showComments(<%=standard.getStdId() %>)">
	<%	for (StandardsStatus stdStatus : statusList)	{ %>
		<option  value="<%=stdStatus.getStatusId()%>" <%=(chainStandard.getStatusId()==stdStatus.getStatusId())?"selected='true'":""%>><%=stdStatus.getTitle()%></option>
	<%  } %>
</select>
