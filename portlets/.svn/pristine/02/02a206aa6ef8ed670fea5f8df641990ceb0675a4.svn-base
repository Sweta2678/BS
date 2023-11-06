<%@page import="com.liferay.counter.model.Counter"%>
<%@page import="com.liferay.util.portlet.PortletProps"%>
<%@include file="/html/init.jsp"%>
<c:choose>
	<c:when test="${hasSyncCounterPortletAccess}">
		<% Map<String, Long> bsTableCounters = (Map<String, Long>)request.getAttribute("bsTableCounters");%>
		<portlet:actionURL name="syncCounters" var="syncCountersURL"/>
		<p>Clicking on Sync Counter button will Sync the Liferay Entity Counters with Brand Standards Tables MAX of entry counts. So that when adding new entries will have correct counter increment.</p>
		<p>This Functionality uses the mapping entries available in portlet.properties.</p>
		<p>Any New Tables needed to sync must have an entry in portlet.propeties.</p>
		<p>It will only process for the entries available in portlet.propeties</p> 
		<div class="pull-right">
			<form action="${syncCountersURL}" method="post" name="syncCountersFM" >
				<input class="btn btn-primary" type="submit" id="syncCounters" name="syncCounters" value="Sync Counters">
			</form>
		</div>
		<div class="clear"></div>
		<div id="BSLRCounters">		
			<table class="results_table">
				<thead><tr class="results_header_bar"><th width="40%">Counter Name</th><th width="7%">Counter</th><th width="38%">BS Table Query</th><th width="15%">BS Table Counter</th></tr></thead>
				<tbody>
					<c:forEach var="counter" items="${bsSyncCounters}">
						<% 
							String style = "";
							Counter counter = (Counter)pageContext.getAttribute("counter");
							if(counter.getCurrentId() < bsTableCounters.get(counter.getName())){
								style = "background-color:#f2dede";
							}
						%>
						<tr style="<%=style%>">
							<td>${counter.name}</td>
							<td>${counter.currentId}</td>
							<td><%=PortletProps.get("counter."+counter.getName()) %></td>
							<td><%=bsTableCounters.get(counter.getName()) %></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:when>
	<c:otherwise>
		You do not have access to this portlet. Please contact support/technical team to get access to this portlet.
	</c:otherwise>
</c:choose>