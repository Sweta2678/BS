<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@include file="../init.jsp"%>
<c:set var="layoutURL" value="<%=PortalUtil.getLayoutFriendlyURL(layout, themeDisplay)%>" />
<c:set var="pageURL" value="<%=ActionUtil.getFullURLByPageName(renderRequest,ApplicationConstants.PAGE_NAME_DIRECTORY_PUBLISHING)%>" />
<div class="changeNetwrkBody">
	<div class="directoryWrap">
		<div class="patchWrap">
			<c:if test="${not empty directoryArticle }">
				<liferay-ui:journal-article groupId="${themeDisplay.scopeGroupId }" articleId="${directoryArticle.articleId }" />
				<%
					JournalArticle directoryArticle = (JournalArticle) renderRequest.getAttribute("directoryArticle");
						String groupId = String.valueOf(directoryArticle.getGroupId());
						String articalId = directoryArticle.getArticleId();
						String version = String.valueOf(directoryArticle.getVersion());
				%>
				<%@include file="/html/common/edit_web_content.jsp"%>
			</c:if>
		</div>
	<div class="directoryWrap">
	
		<br><br>
		<h3>
			<b>1-${fn:length(directories) } </b> of <b>${total }</b> Items
		</h3>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Last name <c:if test="${sortBy ne 'lastName' || sortBy eq 'lastName' && sortOrder eq 'desc' }">
							<a class="asc" href="${layoutURL }?sortBy=lastName&sortOrder=asc"></a>
						</c:if> <c:if test="${sortBy ne 'lastName' || sortBy eq 'lastName' && sortOrder eq 'asc' }">
							<a class="desc" href="${layoutURL }?sortBy=lastName&sortOrder=desc"></a>
						</c:if>
					</th>
					<th>First name</th>
					<th>Business Title</th>
					<th>Geo Region</th>
					<th>Change Network <c:if test="${sortBy ne 'role' || sortBy eq 'role' && sortOrder eq 'desc' }">
							<a class="asc" href="${layoutURL }?sortBy=role&sortOrder=asc"></a>
						</c:if> <c:if test="${sortBy ne 'role' || sortBy eq 'role' && sortOrder eq 'asc' }">
							<a class="desc" href="${layoutURL }?sortBy=role&sortOrder=desc"></a>
						</c:if>
						<br />Status
					</th>
					<th>Global/ Regional <c:if test="${sortBy ne 'regionType' || sortBy eq 'regionType' && sortOrder eq 'desc' }">
							<a class="asc" href="${layoutURL }?sortBy=regionType&sortOrder=asc"></a>
						</c:if> <c:if test="${sortBy ne 'regionType' || sortBy eq 'regionType' && sortOrder eq 'asc' }">
							<a class="desc" href="${layoutURL }?sortBy=regionType&sortOrder=desc"></a>
						</c:if>
					</th>
					<th>Stakeholder Group <c:if
							test="${sortBy ne 'organizationName' || sortBy eq 'organizationName' && sortOrder eq 'desc' }">
							<a class="asc" href="${layoutURL }?sortBy=organizationName&sortOrder=asc"></a>
						</c:if> <c:if test="${sortBy ne 'organizationName' || sortBy eq 'organizationName' && sortOrder eq 'asc' }">
							<a class="desc" href="${layoutURL }?sortBy=organizationName&sortOrder=desc"></a>
						</c:if></th>
					<c:if test='<%=ActionUtil.hasResourcePermission(themeDisplay) %>'>	
						<th>Edit Link</th>	
					</c:if>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="directory" items="${directories }">
					<tr>
					<c:choose>
						<c:when test="${not empty directory.email }">
							<td><a href="mailto:${directory.email}">${directory.lastName }</a></td>
						</c:when>
						<c:otherwise>
							<td>${directory.lastName }</td>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${not empty directory.email }">
							<td><a href="mailto:${directory.email}">${directory.firstName }</a></td>
						</c:when>
						<c:otherwise>
							<td>${directory.firstName }</td>
						</c:otherwise>
					</c:choose>
						<td>${directory.businessTitle }</td>
						<td>${directory.geoRegion }</td>
						<td>${directory.role }</td>
						<td>${directory.regionType }</td>
						<td>${directory.organizationName }</td>
						<c:if test='<%=ActionUtil.hasResourcePermission(themeDisplay) %>'>
							<td>							
								<liferay-ui:icon image="edit" message="Edit Directory" url="${pageURL}?id=${directory.directoryId}" />							
							</td>
						</c:if>	
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<%@include file="/html/common/pagination.jsp"%>
		
	</div>
</div>