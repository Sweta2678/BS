<%@ include file="/html/init.jsp"%>

<!--Second div-->
<div class="latest-article">

<c:if test="${not empty discussionList}">

<div class="header">
<span class="icnSocial"></span>
<h3><span>Social Wall</span></h3>
</div>

<c:forEach var="discussion" items="${discussionList}"  varStatus="counter">
<div class="articleItem">
<h4><a href="${discussionCommentsURL}?id=${discussion.threadId}">${discussion.title}</a></h4>

<p><b>${discussion.messageUserName}</b></p>

<div class="bottomLinks"><span class="date pull-left">${discussion.messageDate}</span>

<div class="favs pull-right">
<div class="likes"><span class="icn">likes</span>&nbsp;${discussion.likeCount}</div>

<div class="chat"><span class="icn">Chat</span>&nbsp;${discussion.commentCount}</div>
</div>
</div>
</div>

				<c:if test="${counter.count <  fn:length(discussionList)}">
					<hr />
				</c:if>
</c:forEach>
</c:if>
</div>

    	
    	
    	
      
 	       
    



