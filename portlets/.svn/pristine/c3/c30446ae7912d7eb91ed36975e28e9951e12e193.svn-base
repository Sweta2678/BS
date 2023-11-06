<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="org.apache.commons.lang.StringEscapeUtils"%>
<%@include file="/html/init.jsp" %>

<% 
String gaVal="";
%>
<c:set var="discussionURL" value="/web${themeDisplay.scopeGroup.friendlyURL }/discussion"/>
<portlet:resourceURL var="loadDiscussionComments" id="moreDiscussion">
	<portlet:param name="discussionId" value="${discussionId}"/>
</portlet:resourceURL>
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
			<div class="discussionCommentList" id="discussionCommentList">
				 <%@ include file="loadMoreComments.jsp" %>			   
			</div>

<%
if (themeDisplay.isSignedIn()) {
	User loggedInUser = themeDisplay.getUser();
%>


			<!--Add Comment box/div -->
		<div class="discussionCommentList">
			<portlet:actionURL var="addDiscussionComments" name="addDiscussionComments"></portlet:actionURL>
			<form name="<portlet:namespace />addDiscussionMessage" id="discussion_comments_form" method="post">
				<fieldset>
					<input type="hidden" name="<portlet:namespace />redirect" value="${themeDisplay.URLCurrent}"/>
					<input type="hidden" name="<portlet:namespace />discussionId" value="${discussionId}"/>
			<c:if test="${commentsCount > (fn:length(discussionCommentsList) - 1) }">
				<div class="loadmore text-center">
					<input type="button" value="Load More"  name="moreDiscussionComments" id="moreDiscussionComments" class="moreDiscussionComments"/>
				</div>
			</c:if>	
			<div class="postComment">
				<div class="row-fluid">
					<div class="span12">
						<div class="image">
							<img class="fleft" src="${userImage}" />
							<%-- <img class="fleft" src="<%= loggedInUser.getPortraitURL(themeDisplay)%>" /> --%>
						</div>
						<div class="content">
							<div class=" row-fluid">
								<div class="span12">
									<%-- <h4><%= loggedInUser.getFullName()%></h4>
									<textarea title="Add new comment" id="add-comment-box" name="<portlet:namespace />addDiscussionCommentBody"></textarea>
									 --%>
									<div class="control">
										<h4><%=ArticleUtil.getPreferredNamebyUserId(loggedInUser.getUserId(),true)%></h4>
										<textarea title="Add new comment" id="add-comment-box" name="<portlet:namespace />addDiscussionCommentBody"></textarea>
									</div>
								</div>
							</div>
						</div>
					</div>			
					<div class="row-fluid">
						<div class="commentBtns span12">
							<a title="Read full commenting policy" data-target="#myModalsec" data-toggle="modal" href="#" class="pull-left">Read full commenting policy</a>				
							<input type="button" class="pull-right" value="Add Comment" onclick="return newThreadMessage('<portlet:namespace />', '<%=addDiscussionComments%>', '<%= StringEscapeUtils.escapeXml(gaVal.replace("'","\\'")) %>');"/>
						</div>
					</div>	
				</div>
				<hr />
			</div>
			</fieldset>
		</form>
	</div>
	</div>
<%
	}
%>
  <c:if test="${webContentId > 0 }">
<div class="modal fade" id="myModalsec" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content sharewrapper">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<liferay-ui:journal-article articleId="${webContentId}"
					groupId="<%= themeDisplay.getScopeGroupId() %>"></liferay-ui:journal-article>
			</div>
			<div class="modal-body"></div>
		</div>

	</div>
</div>

<!--Comment Policy popup end-->
</c:if>
  
  
 <script type="text/javascript">
 
 jQuery(document).ready(function(){
	 
	 LoadMore.init({
		   content : $('#discussionCommentList'),
		   loadMoreButton : $('#moreDiscussionComments'),
		   url : '<%=loadDiscussionComments.toString()%>',
		   delta : ${fn:length(discussionCommentsList) -1},
		   total : ${commentsCount}
		  });

 });
 </script>
 <script type="text/javascript">
 function newThreadMessage(portletNamespace, startThreadURL, tsName) {
		var editorTextAreaValue = $('#add-comment-box').val();
		console.log("editorTextAreaValue"+editorTextAreaValue);

		if (editorTextAreaValue.length > 0 && editorTextAreaValue.indexOf("Type message") == -1) {
			
				var startThreadFormName = 'discussion_comments_form';
				var formObj = document.getElementById(startThreadFormName);
				if (formObj != null) {
					formObj.action = startThreadURL;
					formObj.submit();
				} else {
					console.log("addThreadMessage form not found");
				}
		} else {
			ErrorMessage.showError("#add-comment-box","Please enter message.");
		}
		return true;
		
	}
 
 </script>


