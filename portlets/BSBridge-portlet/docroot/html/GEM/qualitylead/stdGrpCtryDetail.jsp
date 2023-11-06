<%@include file="/html/init.jsp"%>
<c:choose>
	<c:when test="${hasGroupDetails}">
		<table class="table_grp_ctry_dtl">
			<thead>
				<tr>
					<th width="25%">Group Name</th>
					<th width="75%">Country/Region List</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="group" items="${groupData}">
				<tr>
					<td>${group.key}</td>
					<td>${group.value}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:when>
	<c:otherwise>
		No Unique Groups Exist for this standard.
	</c:otherwise>
</c:choose>
