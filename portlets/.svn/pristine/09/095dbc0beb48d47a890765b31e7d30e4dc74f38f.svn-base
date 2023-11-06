<%@ include file="/html/init.jsp" %>
<%ThemeDisplay display = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY); %>

<c:set var="discussionURL" value="/web${themeDisplay.scopeGroup.friendlyURL }/discussions"/>

<portlet:actionURL var="startNewDiscussionURL" name="startNewDiscussion">
	<portlet:param name="redirect" value="${discussionURL}"/>
</portlet:actionURL>	
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
			
			<div class="messagePost">
				<div class="image">
					<img src="${userImage}">
				</div>
				<div class="form">
					<form name="<portlet:namespace />newDiscussion" id="<portlet:namespace />newDiscussion" method="post" enctype="multipart/form-data">
						<h3><%=ArticleUtil.getPreferredNamebyUserId(themeDisplay.getUserId(),true) %></h3>
						<div class="control">
							<label>Subject</label>
							<input type="text" maxlength="75" name="<portlet:namespace />subject" id="<portlet:namespace />add-subject-box"/>
						</div>
						<div class="control">
							<label>Message</label>
							<textarea title="Message" id="<portlet:namespace />myThreadBody" name="<portlet:namespace />myThreadBody"></textarea>
						</div>
						<div class="control">
							<label>Upload File</label>
							<div  id="FileUpload">
								<input class="filebrowser" id="FileField" type="text">
								<div id="BrowserVisible">
									<input type="file" accept="" value="File" id="file"	name="uploadFile" class="filestyle filebrowserclick" onchange="getElementById('FileField').value = getElementById('file').value;">
								</div>    
							</div> 
						</div>
						<!--  
						<div class="control" style="display: none;">
							<label>Post in Group</label>
							<select class="customSelect" id="categories" name="categories"> 
								<c:forEach items="${categories}" var="category">
								${category}
									<option value="${category.categoryId}" <c:if test="${category.name eq 'General' }">selected</c:if>>${category.name}</option>
								</c:forEach>
							</select>
						</div>-->
						<div class="control">
							<input type="checkbox" class="customChk" value="yes" id="answer" name="subscribe" data-label="Subscribe" checked="checked"/> 
						</div>
						<div class="bottomLink">
							<input class="pull-right postMsg" type="submit" value="Post message" value='<liferay-ui:message key="btn-add-message" />' name="" onclick="return startNewThread('<portlet:namespace />', '<%=startNewDiscussionURL%>','<%=display.getScopeGroupName()%>');" />
							<input type="button" class="pull-right cancel" value="Cancel" onclick="return resetForm('${discussionURL}');"/>
						</div>
						
					</form>
				</div>
			</div>
		</div>
		<!-- Discussions End -->
		
	
