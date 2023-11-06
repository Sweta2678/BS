<%@include file="../init.jsp"%>
<c:if test="${not empty contentDetailsMap}">
 	<c:set var="aboutconcertoImage"  value="<%= ApplicationConstants.GRS_HOTEL_IMPL_ABOUT_CONCERTO %>"/>
 	<c:set var="getReadyGRSImage"  value="<%= ApplicationConstants.GRS_HOTEL_IMPL_GETTING_READY %>"/>
	<c:set var="regiontoolsimplImage"  value="<%= ApplicationConstants.GRS_HOTEL_IMPL_REGION_TOOLS_IMPL %>"/>
	
	<% 
	JournalArticle journalArticle = null;			
			ArticleInfoBean	articalInfo = ((ArticleInfoBean) renderRequest.getAttribute("articleInfo"));
			journalArticle = articalInfo.getArtical();
			String groupId = String.valueOf(journalArticle.getGroupId());
			String articalId = String.valueOf(journalArticle.getArticleId());
			String version = String.valueOf(journalArticle.getVersion());			
			String structureKey = journalArticle.getStructureId();						
	%>
	
  <c:forEach var="contentMap" items="${contentDetailsMap}">
      <div class="article-landing todo-container">
      <c:if test="${not empty articleInfo.mainTitle}">
        <h3>${articleInfo.mainTitle}</h3>    
      </c:if>  
        <div class="to-do-first">     
	        <div class="article-content grs-steps">
	          <div class="todo-left">
	            <div class="todo-img"> <img src="${aboutconcertoImage}" alt="About Concerto"> </div>
	          </div>
	          <div class="todo-right">
	            <h3>${articleInfo.title1}</h3>
	            <p>${articleInfo.description1}</p>
	            <div class="understand-grs">
	              <ul>
	             	<c:forEach var="understandTheGrsList" items="${contentMap.key}" varStatus="counter">
	             		<c:choose>
	             			<c:when  test="${(recordsPerCategory > 0) && (counter.count <=  recordsPerCategory)}">
	             				 <li><a href="${understandTheGrsList.url}" <c:if test="${understandTheGrsList.getType() != 'document'}">target="_blank"</c:if>
											title="${understandTheGrsList.title}">${understandTheGrsList.title}</a></li>
							</c:when>
							<c:otherwise>	
								<c:if  test="${recordsPerCategory == 0}">	
						 			<li><a href="${understandTheGrsList.url}" <c:if test="${understandTheGrsList.getType() != 'document'}">target="_blank"</c:if>
											title="${understandTheGrsList.title}">${understandTheGrsList.title}</a></li>
								</c:if>			
							</c:otherwise>
						</c:choose>		
	            	</c:forEach>                  
	              </ul>
	            </div>
	          </div>
	        </div>
	        <div class="article-content grs-steps">
	          <div class="todo-left">
	            <div class="todo-img"> <img src="${getReadyGRSImage}" alt="Getting Ready"> </div>
	          </div>
	          <div class="todo-right">
	            <h3>${articleInfo.title2}</h3>
	             <p>${articleInfo.description2}</p>
	            <div class="understand-grs grs-ready">
	              <ul>
	               <c:forEach var="getReadyTheGrsList" items="${contentMap.value}" varStatus="counter">
	               <c:choose>
	             		<c:when  test="${(recordsPerCategory > 0) && (counter.count <=  recordsPerCategory)}">
	             			 <li><a href="${getReadyTheGrsList.url}" <c:if test="${getReadyTheGrsList.getType() != 'document'}">target="_blank"</c:if>
											title="${getReadyTheGrsList.title}">${getReadyTheGrsList.title}</a></li>
						</c:when>
						<c:otherwise>		
							<c:if  test="${recordsPerCategory == 0}">	
								<li><a href="${getReadyTheGrsList.url}" <c:if test="${getReadyTheGrsList.getType() != 'document'}">target="_blank"</c:if>
											title="${getReadyTheGrsList.title}">${getReadyTheGrsList.title}</a></li>
							</c:if>
						</c:otherwise>
					</c:choose>							
	            	</c:forEach>    
	              </ul>
	            </div>
	          </div>
	        </div> 
	        
	        <div class="article-content grs-steps">
	          <div class="todo-left">
	            <div class="todo-img"> <img src="${regiontoolsimplImage}" alt="Region Tools Implementation"> </div>
	          </div>
	          <div class="todo-right">
	            <h3>${articleInfo.title5}</h3>
	            <p>${articleInfo.description5}</p>
	          </div>
	        </div>
	         
        </div>  
          <div class="to-do-second">
            <div class="todo-left">
              <div class="todo-img"></div>
            </div>
            <div class="todo-right">
              <h3>${articleInfo.title3}</h3>
             	<div class="regional-grs">
					<ul>
					<c:if test="${not empty articleInfo.image1 && not empty articleInfo.url1 && not empty articleInfo.label1}">
    					<li><img src="${articleInfo.image1}" /><a href="${articleInfo.url1}">${articleInfo.label1}</a></li>  
					</c:if>
					<c:if test="${not empty articleInfo.image2 && not empty articleInfo.url2 && not empty articleInfo.label2}">	
						<li><img src="${articleInfo.image2}" /><a href="${articleInfo.url2}">${articleInfo.label2}</a></li>
					</c:if>
					<c:if test="${not empty articleInfo.image3 && not empty articleInfo.url3 && not empty articleInfo.label3}">	
						<li><img src="${articleInfo.image3}" /><a href="${articleInfo.url3}">${articleInfo.label3}</a></li>
					</c:if>
					<c:if test="${not empty articleInfo.image4 && not empty articleInfo.url4 && not empty articleInfo.label4}">	
						<li><img src="${articleInfo.image4}" /><a href="${articleInfo.url4}">${articleInfo.label4}</a></li>
					</c:if>	
					</ul>
				</div>
            </div>
            <%@include file="/html/common/edit_web_content.jsp"%>
        </div>              
      </div>
      </c:forEach> 
</c:if>