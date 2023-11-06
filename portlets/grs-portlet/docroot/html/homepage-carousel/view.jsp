<%@include file="/html/init.jsp"%>


<!-- first section start -->
<div class="backLinkWrap">&nbsp;</div>

<div class="jcarousel-wrapper">
<div class="jcarousel">

<c:set var="articledetailurl"  value="<%= ActionUtil.getFullURLByPageName(renderRequest,ApplicationConstants.PAGE_NAME_ARTICLE_DETAIL) %>"/>
<c:set var="blogdetailurl"  value="<%= ActionUtil.getFullURLByPageName(renderRequest,ApplicationConstants.PAGE_NAME_BLOG_DETAIL) %>"/>
<c:set var="videodetailurl"  value="<%= ActionUtil.getFullURLByPageName(renderRequest,ApplicationConstants.PAGE_NAME_VIDEO_DETAIL) %>"/>
<c:set var="blogstrcttype"  value="<%=ApplicationConstants.BLOG_STRUCTURE_KEY %>"/>
<c:set var="videostrcttype"  value="<%=ApplicationConstants.VIDEO_STRUCTURE_KEY %>"/>
<c:set var="articlestrcttype"  value="<%=ApplicationConstants.ARTICLE_STRUCTURE_KEY %>"/>


<ul>
<c:forEach var="article" items="${articleList}">
	<li>
	<div class="imgcontainer"><img src="${article.imageUrl}" alt="${article.shortTitle}"/></div>
	
	<div class="textcontainer">
	
	<c:choose>
         <c:when test = "${article.structureType eq blogstrcttype}">
            <h3><a href="${blogdetailurl}?id=${article.articleId}" title="${article.title}">${article.shortTitle}</a></h3>
         </c:when>
         <c:when test = "${article.structureType eq videostrcttype}">
           <h3><a href="${videodetailurl}?id=${article.articleId}" title="${article.title}">${article.shortTitle}</a></h3>
         </c:when>
         <c:when test = "${article.structureType eq articlestrcttype}">
          	<h3><a href="${articledetailurl}?id=${article.articleId}" title="${article.title}">${article.shortTitle}</a></h3>
        </c:when>
        <c:otherwise>
        	<h3><a href="#" title="${article.title}">${article.shortTitle}</a></h3>
        </c:otherwise>
      </c:choose>
	<!-- <div class="car-date"><span class="dat-sty">09</span><span class="dat-sty">Jul</span><span class="dat-sty">2015</span></div> -->
	<div class="car-date">${article.dispDate}</div>

	<div class="like_subscribe">
	<div class="like">
	<div class="taglib-ratings thumbs thumbfloat"><span></span>&nbsp;${article.likeCount}</div>
	</div>

	<div class="coment">
	<div class="taglib-ratings thumbs thumbfloat"><span></span>&nbsp;${article.commentCount}</div>
	</div>

	<div class="car-desc">
	<p>${article.shortContent}</p>
	</div>

	<div class="clear">&nbsp;</div>
	</div>
	</div>
	</li>
</c:forEach>

</ul>
</div>
<a class="jcarousel-control-prev" href="#">&lsaquo;</a> <a class="jcarousel-control-next" href="#">&rsaquo;</a>

<p class="jcarousel-pagination">&nbsp;</p>
</div>
<!-- first section end -->
    	
    	
    	
      
 	       
    



