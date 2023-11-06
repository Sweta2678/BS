<%@include file="/html/init.jsp"%>

<c:if test="${not empty structureKey}">
<c:choose>
	<c:when test='<%=renderRequest.getAttribute("structureKey").equals(ApplicationConstants.BLOG_STRUCTURE_KEY) %>'>
            <%@include file="/html/latestarticle/recent-posts.jsp"%>
    </c:when>    
    <c:otherwise>
    	    <%@include file="/html/latestarticle/latest-article.jsp"%>
    </c:otherwise>
</c:choose>
</c:if>