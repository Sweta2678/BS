<%@page import="com.ihg.grs.constant.DiscussionConstant"%>
<%@page import="com.ihg.grs.util.DiscussionCommonUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.ihg.me2.core.bean.MBMessageInfo"%>
<%@ include file="/html/init.jsp" %>

<%@ page import="com.liferay.portlet.messageboards.model.MBMessage" %>
<%@ page import="com.liferay.portlet.messageboards.model.MBCategory" %>
<%@ page import="com.liferay.portlet.messageboards.model.MBMessageDisplay" %>

<portlet:renderURL var="discussionRenderURL"></portlet:renderURL>

<portlet:resourceURL var="loadMoreDiscussions"></portlet:resourceURL>

<c:set var="startNewDiscussionURL" value="<%= DiscussionCommonUtil.getFullURLByPageName(renderRequest, DiscussionConstant.START_NEW_DISCUSSION) %>" />
<c:set var="discussionCommentsURL" value="<%= DiscussionCommonUtil.getFullURLByPageName(renderRequest, DiscussionConstant.DISCUSSION_DETAIL) %>" />

		<!-- Discussions Start -->
		<div class="discussionsWrap">
		<h1>
			<c:choose>
				<c:when test='<%=themeDisplay.getScopeGroup().getFriendlyURL().contains("/concerto-change-network")%>'>
					Let's Chat
				</c:when>
				<c:otherwise>Social Wall</c:otherwise>
			</c:choose>
		</h1>
		<div class="filter">
			<%-- <label for="fltr">Filter Post</label>
			<form name="discussion" method="post" id="discussion" action="<%=discussionRenderURL.toString()%>" class="pull-left">
				<input type="hidden" id="categoriesTab" name="categoriesTab" value="${selectedTab}"/>
				<select id="categories" name="categories " class="customSelect">
					<option value="" <c:if test="${selectedMbCategory eq -1}">selected</c:if>>All</option>
					<c:forEach items="${categories}" var="category">
						<option value="${category.categoryId}" <c:if test="${selectedMbCategory eq category.categoryId}">selected</c:if>>${category.name}</option>
					</c:forEach>
				</select>
			</form> --%>
			<input type="button" class="pull-right" value="Start a Discussion" onclick="javascript:location.href='${startNewDiscussionURL}'"/>
				
		</div>
<c:if test="${not empty listDiscussionThread }">
<div class="discussionList" id="discussionList">		
<c:forEach var="discussion" items="${listDiscussionThread}">
			
				<div id="discussionMessages">
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
				</div>
			
		</c:forEach>
</div>
		<c:if test="${discussionCount > (fn:length(listDiscussionThread)) }">
			<div class="loadMore text-center">
				<input type="button" value="Load More"  name="moreDiscussions" id="moreDiscussions" class="moreDiscussions"/>
			</div>
		</c:if>	
			
	</c:if>
</div>
		<!-- Discussions End -->

<script type="text/javascript">

	jQuery(document).ready(function(){
		
		jQuery("#categories").change(function(){
			var currentGroupURL = '${currentGroupURL}';
			var categories = jQuery('#categories').val();
			if(categories > 0){
				currentGroupURL = currentGroupURL +'?categoryid='+categories;	
			}else{
				currentGroupURL = currentGroupURL;
			}
			
			jQuery("#discussion").attr("action", currentGroupURL);
			jQuery("#discussion").submit();
		});
		
		var categoryId = jQuery('#categories').val();
			
		LoadMore.init({
			content : $('#discussionList'),
			loadMoreButton : $('#moreDiscussions'),
			url : '${loadMoreDiscussions}&categoryId='+categoryId,
			delta : ${fn:length(listDiscussionThread)},
			total : ${discussionCount}
		});
		
		
	});
	
</script>
