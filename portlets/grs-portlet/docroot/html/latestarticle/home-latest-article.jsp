<%@include file="/html/init.jsp"%>
<c:set var="url"  value="<%= ActionUtil.getFullURLByPageName(renderRequest,ApplicationConstants.PAGE_NAME_ARTICLE_DETAIL) %>"/>

<c:if test="${not empty articleList}">
<div class="changeNetworkHomeRight">
	<h2>Latest Articles</h2>
	<div class="articleListings">
		<c:forEach var="article" items="${articleList}"  varStatus="counter">
		<c:if test="${counter.count ne 1}"><hr /></c:if>
		<div class="listItem">
			<a href="${url}?id=${article.articleId}"><h3><c:out value="${article.title}" /></h3></a>
			<p><c:out value="${article.shortContent}" escapeXml="false" /></p>
			<div class="dateTime">Posted <fmt:formatDate value="${article.artical.displayDate}" pattern="MMM,dd yyyy, h:mm a"/> by ${article.artical.userName}</div>
			<div class="readMore">
				<a href="${url}?id=${article.articleId}"><span>read more</span> <span class="icn"></span></a>
			</div>
		</div>
		</c:forEach>
	</div>
</div>
</c:if>