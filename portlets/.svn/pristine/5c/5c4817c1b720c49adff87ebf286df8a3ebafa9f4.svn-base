<%@include file="/html/init.jsp"%>

	<c:if test="${not empty articleList}">
      <!--Article Landing Start -->      
       <c:choose>
    		<c:when test='<%=renderRequest.getAttribute("structureKey").equals(ApplicationConstants.BLOG_STRUCTURE_KEY) %>'>
    		        <div class="article-landing article-fullwidth blog-overlay-img">
    		        <c:set var="url"  value="<%= ActionUtil.getFullURLByPageName(renderRequest,ApplicationConstants.PAGE_NAME_BLOG_DETAIL) %>"/>
    		</c:when>   
    		<c:when test='<%=renderRequest.getAttribute("structureKey").equals(ApplicationConstants.VIDEO_STRUCTURE_KEY) %>'>
        		    <div class="article-landing">
        		    <c:set var="url"  value="<%= ActionUtil.getFullURLByPageName(renderRequest,ApplicationConstants.PAGE_NAME_VIDEO_DETAIL) %>"/>
    		</c:when> 
    		<c:otherwise>
        		    <div class="article-landing">
        		    <c:set var="url"  value="<%= ActionUtil.getFullURLByPageName(renderRequest,ApplicationConstants.PAGE_NAME_ARTICLE_DETAIL) %>"/>
    		</c:otherwise>
    		
		</c:choose>    	
			
			<c:forEach var="article" items="${articleList}"  varStatus="counter">
			
			<div class="article-content">
        	 	<div class="article-left">
        	 		<c:if test='<%=renderRequest.getAttribute("structureKey").equals(ApplicationConstants.BLOG_STRUCTURE_KEY) %>'>
        	 			<div class="overlaydate"><c:out value="${article.dispDate}" /></div>
        	 		</c:if>
              		<div class="article-secimg">              		    
                			<img src="${article.imageUrl}" alt="${article.shortTitle}"/>
              		</div>
              	</div>
              	<div class="article-right">
             	 <h3><a href="${url}?id=${article.articleId}" title="${article.title}">${article.shortTitle}</a></h3>
             	 	<div>  		       	            		
              			<c:if test='<%=!renderRequest.getAttribute("structureKey").equals(ApplicationConstants.BLOG_STRUCTURE_KEY) %>'>
    		        		<div class="date-art"><c:out value="${article.dispDate}" /></div>
    					</c:if> 
              			<div class="like_subscribe">
                			<div class="like">
                  				<div class="taglib-ratings thumbs thumbfloat">
                    				<span></span><c:out value="${article.likeCount}" />
                  				</div>
                			</div>
                			<div class="coment">
                  				<div class="taglib-ratings thumbs thumbfloat">
                    				<span></span><c:out value="${article.commentCount}" />
                  				</div>
                			</div>
              			</div>               			
              		</div>	 
              			<p class="article-paragraph"><c:out value="${article.shortContent}" escapeXml="false"  /></p>
              			<c:if test='<%=renderRequest.getAttribute("structureKey").equals(ApplicationConstants.BLOG_STRUCTURE_KEY) %>'>              				
              				<div class="readMore">
									<a href="${url}?id=${article.articleId}" class="pull-right"><span>read more</span><span class="icn"></span></a>
							</div>
						</c:if>           	
            	</div>
        	</div>   
        	<c:if test="${counter.count <  fn:length(articleList)}">
					<hr>
			</c:if>
			</c:forEach>			
		<%@include file="/html/common/pagination.jsp"%>		       	
    	</div>
    	<!--Article Landing End -->
    	</c:if> 
    	
    	
    	
      
 	       
    



