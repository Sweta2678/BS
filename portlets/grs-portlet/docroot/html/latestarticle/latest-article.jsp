<%@include file="/html/init.jsp"%>

<c:if test="${not empty articleList}">
	<div class="height50"></div>
	<div class="latest-article">
		<div class="header"><span class="icnAnnounce"></span><span><h3>Latest Articles</h3></span></div>
		<c:set var="url"  value="<%= ActionUtil.getFullURLByPageName(renderRequest,ApplicationConstants.PAGE_NAME_ARTICLE_DETAIL) %>"/>
			<c:forEach var="article" items="${articleList}"  varStatus="counter">
				<div class="articleItem">
					<h4><a href="${url}?id=${article.articleId}" title="${article.title}"><b><c:out value="${article.shortTitle}" /></b></a></h4>
					<p><c:out value="${article.shortDescription}" escapeXml="false" /></p>
					<div class="bottomLinks">
							<span class="date pull-left"><c:out value="${article.dispDate}" /></span>
							<div class="favs pull-right">
								<div class="likes">
									<span class="icn">likes</span> 
									<c:out value="${article.likeCount}" />
								</div>
								<div class="chat">
									<span class="icn">comments</span>
									 <c:out value="${article.commentCount}" />									
								</div>
							</div>
					</div>	
				</div>
				<c:if test="${counter.count <  fn:length(articleList)}">
					<hr>
				</c:if>
			</c:forEach>	
	</div>
</c:if>