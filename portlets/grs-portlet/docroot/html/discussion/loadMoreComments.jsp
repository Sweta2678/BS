<%@page import="com.liferay.portlet.messageboards.model.MBThread"%>
<%@page import="com.liferay.portal.service.SubscriptionLocalServiceUtil"%>
<%@page import="com.ihg.grs.constant.DiscussionConstant"%>
<%@include file="/html/init.jsp" %>
<%@page import="com.ihg.me2.core.bean.MBMessageInfo"%>
<%@page import="com.ihg.grs.util.DiscussionPortletUtil"%>
<%@page import="com.liferay.portal.kernel.util.FileUtil"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.ihg.grs.util.DiscussionCommonUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portlet.messageboards.model.MBMessage"%>
<%@page import="java.util.List"%>
<script type="text/javascript">
	isCustomFnbHookCall = true;
</script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<portlet:resourceURL var="subscribeThreadURL" id="subscribeThread">
</portlet:resourceURL>

<c:if test="${not empty discussionCommentsList}">

	<c:forEach var="discussionComments" items="${discussionCommentsList}">
	<c:choose>
		<c:when test="${ctr eq 0}">
			<c:if test="${ firstMessage eq true}">
				<div class="postComment">
					<div class="row-fluid">
						<div class="span12">
						<div class="image">
							<c:set var="userId" value="${discussionComments.userId}"></c:set>
								<%String userId = pageContext.getAttribute("userId").toString() ; 
									String userPortrait = DiscussionCommonUtil.getImageUrl(Long.valueOf(userId), themeDisplay);
									pageContext.setAttribute("userPortrait", userPortrait);
								%>
							<c:choose>
								<c:when test="${not empty userPortrait}">
									<img alt="${discussionComments.messageUserName}"  title="${discussionComments.messageUserName}"  src="${userPortrait}" width="72" height="70" alt="" />
								</c:when>
								<c:otherwise>
									<img alt="${discussionComments.messageUserName}" title="${discussionComments.messageUserName}"  src="<%=DiscussionConstant.DEFAULT_USER_IMAGE_URLS%>" />
								</c:otherwise>
							</c:choose>
						</div>
					
						<div class="content">
							<h2>${discussionComments.title}</h2>
							<div class="title row-fluid">
								<div class="span8">
									<h4>${discussionComments.messageUserName}</h4>
									<span>${discussionComments.messageShortDate}</span>
								</div>
								<div class="span4">
									<div class="links pull-right">
										<div class="likes">
											<liferay-ui:ratings className="<%= MBMessage.class.getName() %>" classPK="${discussionComments.messageId}" type="thumbs"/>
										</div>
										<div class="chat">
											<span class="icn">Comments</span>
											${discussionComments.commentCount}
										</div>
									
										<div class="sub">
											<c:set var="threadId" value="${discussionComments.threadId}"/>
											<c:choose>
					                            <c:when test='<%= SubscriptionLocalServiceUtil.isSubscribed(themeDisplay.getCompanyId(), user.getUserId(), MBThread.class.getName(), Long.valueOf(pageContext.getAttribute("threadId").toString())) == true %>'>
					                                    <div class="subscribeDiv">
					                                    	<a href="javascript:;" onclick="javascript:subscribeThread('<portlet:namespace />', '${discussionComments.messageId}',this)" title="Unsubscribe Post" class="sub" style="text-decoration: none;">
					                                    		<span class="icn"></span>
					                                    		<img name="unsubscribe" class="icon" src="/html/themes/control_panel/images/common/unsubscribe.png" alt=""/>
					                                    		<input type="hidden" id="subscribe${discussionComments.messageId}" value="false">
					                                    		<span>Unsubscribe</span>
					                                    	</a>
					                                    	
					                                    </div>
					                            </c:when>
					                            <c:otherwise>
					                                    <div class="subscribeDiv">
					                                    	<a href="javascript:;" onclick="javascript:subscribeThread('<portlet:namespace />', '${discussionComments.messageId}',this)" title="Subscribe Post" class="sub" style="text-decoration: none;">
					                                    		<span class="icn"></span>
					                                    		<img name="subscribe" class="icon" src="/html/themes/control_panel/images/common/subscribe.png" alt=""/>
					                                    		<input type="hidden" id="subscribe${discussionComments.messageId}" value="true">
					                                    		<span>Subscribe</span>
					                                    	</a>
					                                    	
					                                    </div>
					                             </c:otherwise>
					                     	</c:choose>
				                     	</div>	
									</div>
									
									</div>
							</div>
							<p>
								<c:if test="${ firstMessage eq true}">
								<c:if test="${not empty discussionComments.attachmentsFileEntries }">
								<c:forEach var="fileEntry" items="${discussionComments.attachmentsFileEntries}">
								<span>
			                		<a title="download" href="<%= DiscussionCommonUtil.getFileURL(pageContext.getAttribute("fileEntry")) %>" id="fancybox-manual-a">${fileEntry.title}</a>
								</span>
								</c:forEach>
								</c:if>
								<div>
									${discussionComments.threadBody}
								</div>
								<c:set var="firstMessage" value="false"/>
								</c:if>
							</p>
						</div>
					</div>
					
					
				</div>
				<hr />
				</div>		
					
			</c:if>
		</c:when>
		<c:otherwise>
			<div class="postComment">
				<div class="row-fluid">
					<div class="span12">
					<div class="image">
						<c:set var="userId" value="${discussionComments.userId}"></c:set>
							<%String userId = pageContext.getAttribute("userId").toString() ; 
								String userPortrait = DiscussionCommonUtil.getImageUrl(Long.valueOf(userId), themeDisplay);
								pageContext.setAttribute("userPortrait", userPortrait);
							%>
						<c:choose>
							<c:when test="${not empty userPortrait}">
								<img alt="${discussionComments.messageUserName}"  title="${discussionComments.messageUserName}"  src="${userPortrait}" width="72" height="70" alt="" />
							</c:when>
							<c:otherwise>
								<img alt="${discussionComments.messageUserName}" title="${discussionComments.messageUserName}"  src="<%=DiscussionConstant.DEFAULT_USER_IMAGE_URLS%>" />
							</c:otherwise>
						</c:choose>
					</div>
					<div class="content">
						<div class="title row-fluid">
							<div class="span8">
								<h4>${discussionComments.messageUserName}</h4>
								<span>${discussionComments.messageShortDate}</span>
							</div>
						</div>
						<p>${discussionComments.threadBody}</p>
					</div>
					</div>
				</div>
				<hr />
			</div>		
			
		</c:otherwise>
		</c:choose>
		<c:set var="ctr" value="1" scope="request"></c:set>
	</c:forEach>
</c:if>

<script type="text/javascript">
	jQuery(document).ready(function() {
		
		$('.rating-label').each(function() {
			var innerData = $(this).text().split(" ");
			if (innerData.length > 0) {
				$(this).text(innerData[0].replace("+", " "));
			}
		});
	});
	
	function subscribeThread(portletNamespace, messageId, link) {
		var subscribeThreadURL = '<%= subscribeThreadURL.toString()%>';
		if (portletNamespace != null && subscribeThreadURL != null && messageId != null) {
			var subscribe = jQuery('#subscribe'+messageId).val();
			subscribeThreadURL += "&messageId=" + messageId+"&subscribe="+subscribe;		
			jQuery.ajax({
				type: "POST",
				url: subscribeThreadURL,
				cache: false,
				success: function(data) 
				{	
					if(subscribe == 'true'){
						$("a.sub").attr("title", "Unsubscribe Post");
						$("a.sub > span").text("Unsubscribe");
					}else{
						$("a.sub").attr("title", "Subscribe Post");
						$("a.sub > span").text("Subscribe");
					}
					if(subscribe == 'true'){
						jQuery('#subscribe'+messageId).val('false');
					}else{
						jQuery('#subscribe'+messageId).val('true');
					}
				}
			});
		}
	}
</script>

