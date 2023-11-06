<%@include file="/html/init.jsp"%>


<div class="notification changeNetworkHeader">
	<h1><liferay-ui:message key="notfications.and.subscription.heading"></liferay-ui:message></h1>
	<div class="act-sub-head"><liferay-ui:message key="activity.heading"></liferay-ui:message></div>
	<div class="notification-container">
		<table>
			<c:choose>
				<c:when test="${not empty activityLists}">
					<c:forEach var="asset" items="${activityLists}">
						<c:set var="categoryName" value="${asset.categoryName}" scope="request"></c:set>
						<c:set var="userName" value="${asset.userName}" scope="request"></c:set>

						<tr>
							<td class="noty-date">${asset.publishDate}</td>
							<td><liferay-ui:message key="notification.desc.document" arguments='<%=new Object[] {request.getAttribute("userName"), request.getAttribute("categoryName")	}%>' />
								<a href="${asset.resourceLink}">${asset.title}</a>
							</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<liferay-ui:message key="message.norecords" />
				</c:otherwise>
			</c:choose>
		</table>
	</div>
</div>


