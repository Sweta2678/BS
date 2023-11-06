<%@ include file="/html/init.jsp" %>
<%@page import="com.ihg.grs.constant.DiscussionConstant"%>
<%@page import="com.ihg.me2.core.bean.MBMessageInfo"%>
<%@page import="com.ihg.grs.util.DiscussionCommonUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@ page import="com.liferay.portlet.messageboards.model.MBMessage" %>

<c:set var="messageListInfo" value="${discussions}" />
<c:set var="discussionCommentsURL" value="<%= DiscussionCommonUtil.getFullURLByPageName(resourceRequest, DiscussionConstant.DISCUSSION_DETAIL) %>" />

<c:if test="${not empty loadMoreDiscussion }">		
<c:forEach var="discussion" items="${loadMoreDiscussion}">
<div class="post">
			<div class="row-fluid">
				<div class="span5">
					<div class="image">
						<c:set var="userId" value="${discussion.userId}"></c:set>
						<%String userId = pageContext.getAttribute("userId").toString() ; 
							String userPortrait = DiscussionCommonUtil.getImageUrl(Long.valueOf(userId), themeDisplay);
							pageContext.setAttribute("userPortrait", userPortrait);
						%>
						<c:choose>
							<c:when test="${not empty userPortrait}">
								<img alt="${discussion.messageUserName}"  title="${discussion.messageUserName}"  src="${userPortrait}" width="72" height="70" alt="" />
							</c:when>
							<c:otherwise>
								<img alt="${discussion.messageUserName}" title="${discussion.messageUserName}"  src="<%=DiscussionConstant.DEFAULT_USER_IMAGE_URLS%>" />
							</c:otherwise>
						</c:choose>
					</div>
					<div class="lftContent">
						<c:if test="${not empty discussion.messageUserName}">
							<p>Posted by: <b>${discussion.messageUserName}</b></p>
							<span>${discussion.messageShortDate}</span>
						</c:if>
					</div>
					
				</div>
				<div class="span7">
				<div class="rytContent">
						<h3><a class="pdet_Title" title="Click to get discussion details" href='${discussionCommentsURL}?id=${discussion.threadId}'>${discussion.title}</a></h3>
						<p>${discussion.threadBody}</p>
						<div class="bottomLinks">
							<div class="likes">
								<span class="icn">Likes</span>
								${discussion.likeCount}
							</div>
							<div class="chat">
								<span class="icn">Comments</span>
								${discussion.commentCount}
							</div>
						</div>
					</div>
				</div>
			</div>
			<hr />
		</div>
	</c:forEach>
</c:if>