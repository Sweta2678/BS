<%@include file="/html/init.jsp"%>


<portlet:renderURL var="subscribeUrl">
</portlet:renderURL>

<div class="sun-container changeNetworkHeader">
	<div class="act-not-head"><liferay-ui:message key="subscription.heading"></liferay-ui:message></div>
	<div class="your-subscription">
		<form name="subscribe_category_form" id="subscribe_category_form" method="post" action="${subscribeUrl}">
			<table>
				<c:forEach var="assetCategories" items="${assetCategories }">
					<tr>
						<c:set var="categoryName" value="${assetCategories.name }" />
						<c:choose>
							<c:when test="${fn:containsIgnoreCase(categoryName, 'and')}">
								<c:set var="catName"
									value="${fn:replace(categoryName, 'and', '&')}" />
								<td class="sub_name">${catName}</td>
							</c:when>
							<c:otherwise>
								<td class="sub_name">${assetCategories.name }</td>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when
								test="${userSubscriptionMap[assetCategories.categoryId] eq 'Subscribe'}">
								<td><a href="#subscribe"
									onclick="submitFormByUrl('${subscribeUrl}&actionType=add','${assetCategories.categoryId }')"
									title="Click Subscribe">Click to
										${userSubscriptionMap[assetCategories.categoryId]}</a></td>
							</c:when>
							<c:otherwise>
								<td><a href="#unsubscribe"
									onclick="submitFormByUrl('${subscribeUrl}&actionType=delete','${assetCategories.categoryId }')"
									title="Unsubscribe">Click to
										${userSubscriptionMap[assetCategories.categoryId]}</a></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</table>
			<input type="hidden" id="categoryId" name="categoryId" value="">
		</form>
	</div>
</div>

<script type="text/javascript">
	function submitFormByUrl(url, id) {
		jQuery("#categoryId").val(id);

		document.subscribe_category_form.action = url;
		document.subscribe_category_form.submit();
		return false;

	}
</script>
