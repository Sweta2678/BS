<%@include file="../init.jsp"%>

<portlet:resourceURL var="loadMoreURL" id="loadMoreAnnoucements" />

<div class="changeNetworkHomeRight">
	<div class="chatContent">
		<%@include file="/html/whatshappening/loadMoreAnnoucements.jsp"%>
	</div>

	<c:if test="${total > delta }">
		<div class="loadMore text-center">
			<input id="loadMoreButton" type="button" value="Load More" />
		</div>
	</c:if>
</div>

<script type="text/javascript">
$(function() {
	LoadMore.init({
		content : $('.changeNetworkHomeRight .chatContent'),
		loadMoreButton : $('#loadMoreButton'),
		url : '${loadMoreURL}',
		delta : ${delta},
		total : ${total}
	});
});
</script>