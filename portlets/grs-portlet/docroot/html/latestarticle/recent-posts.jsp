<%@include file="/html/init.jsp"%>

<c:if test="${not empty articleList}">
	<div class="latest-article">
		<div class="header"><span class="icnAnnounce"></span><span><h3>Recent Posts</h3></span></div>
		<c:set var="url"  value="<%= ActionUtil.getFullURLByPageName(renderRequest,ApplicationConstants.PAGE_NAME_BLOG_DETAIL) %>"/>
			<c:forEach var="article" items="${articleList}"  varStatus="counter">
				<div class="articleItem">
					<div class="blog1">
						<div class="recent-date"><c:out value="${article.dispDate}" /></div>		                        
                        <img src="${article.imageUrl}" alt="${article.title}"/>
                     </div>
					<p class="title-recent"><a href="${url}?id=${article.articleId}" title="${article.title}"><c:out value="${article.shortTitle}" /></a></p>
								
					<p><c:out value="${article.shortDescription}" escapeXml="false" /></p>
					<div class="like">
                           <div class="taglib-ratings thumbs thumbfloat">
                              <span></span> <c:out value="${article.likeCount}" />
                           </div>
                     </div>
                     <div class="coment">
                        <div class="taglib-ratings thumbs thumbfloat">
                            <span></span> <c:out value="${article.commentCount}" />
                        </div>
                     </div>   
                     <div class="welreadmore-recent"><a href="${url}?id=${article.articleId}">read more<span></span></a></div>
				</div>	
				<c:if test="${counter.count <  fn:length(articleList)}">
					<hr>
				</c:if>
			</c:forEach>	
	</div>
</c:if>