<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
--%>

<%@ include file="/html/portlet/message_boards/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

MBMessageDisplay messageDisplay = (MBMessageDisplay)request.getAttribute(WebKeys.MESSAGE_BOARDS_MESSAGE);

MBMessage message = messageDisplay.getMessage();

MBCategory category = messageDisplay.getCategory();

MBThread thread = messageDisplay.getThread();

MBThread previousThread = messageDisplay.getPreviousThread();
MBThread nextThread = messageDisplay.getNextThread();

String threadView = messageDisplay.getThreadView();

MBThreadFlag threadFlag = MBThreadFlagLocalServiceUtil.getThreadFlag(themeDisplay.getUserId(), thread);
%>



<ul class="thread-view-controls">
		<li class="viewControlText">
		VIEWS:
		</li>
	<c:if test="<%= PropsValues.MESSAGE_BOARDS_THREAD_VIEWS.length > 1 %>">
		<c:if test="<%= ArrayUtil.contains(PropsValues.MESSAGE_BOARDS_THREAD_VIEWS, MBThreadConstants.THREAD_VIEW_COMBINATION) %>">
			<li class="thread-icon">

				<%
				currentURLObj.setParameter("threadView", MBThreadConstants.THREAD_VIEW_COMBINATION);
				%>

				<liferay-ui:icon
					image="../message_boards/thread_view_combination"
					message="combination-view"
					method="get"
					url="<%= currentURLObj.toString() %>"
				/>
			</li>
		</c:if>

		<c:if test="<%= ArrayUtil.contains(PropsValues.MESSAGE_BOARDS_THREAD_VIEWS, MBThreadConstants.THREAD_VIEW_FLAT) %>">
			<li class="thread-icon">

				<%
				currentURLObj.setParameter("threadView", MBThreadConstants.THREAD_VIEW_FLAT);
				%>

				<liferay-ui:icon
					image="../message_boards/thread_view_flat"
					message="flat-view"
					method="get"
					url="<%= currentURLObj.toString() %>"
				/>
			</li>
		</c:if>

		<c:if test="<%= ArrayUtil.contains(PropsValues.MESSAGE_BOARDS_THREAD_VIEWS, MBThreadConstants.THREAD_VIEW_TREE) %>">
			<li class="thread-icon">

				<%
				currentURLObj.setParameter("threadView", MBThreadConstants.THREAD_VIEW_TREE);
				%>

				<liferay-ui:icon
					image="../message_boards/thread_view_tree"
					message="tree-view"
					method="get"
					url="<%= currentURLObj.toString() %>"
				/>
			</li>
		</c:if>
	</c:if>
</ul>

<div class="thread-controls">
	<c:if test="<%= PropsValues.MESSAGE_BOARDS_THREAD_PREVIOUS_AND_NEXT_NAVIGATION_ENABLED %>">
		<div class="thread-navigation">
			<span class="nav-label"><liferay-ui:message key="threads" />:</span>

			

			<c:choose>
				<c:when test="<%= previousThread != null %>">
					<portlet:renderURL var="previousThreadURL">
						<portlet:param name="struts_action" value="/message_boards/view_message" />
						<portlet:param name="messageId" value="<%= String.valueOf(previousThread.getRootMessageId()) %>" />
					</portlet:renderURL>
					<aui:a href="<%= previousThreadURL %>" >
					<span class="prevIcon">PrevIcon</span>
					<span class="prevText">Prev</span>
					</aui:a>
				</c:when>
				<c:otherwise>
					<span class="disablePrevIcon">PrevIcon</span>
					<span class="prevText">Prev</span>
					<!-- <liferay-ui:message key="previous" /> -->
				</c:otherwise>
			</c:choose>
			<span class="thread-control-pie">
			|
			</span>
			<c:choose>
				<c:when test="<%= nextThread != null %>">
					<portlet:renderURL var="nextThreadURL">
						<portlet:param name="struts_action" value="/message_boards/view_message" />
						<portlet:param name="messageId" value="<%= String.valueOf(nextThread.getRootMessageId()) %>" />
					</portlet:renderURL>
					<aui:a href="<%= nextThreadURL %>" >
					<span class="nextText">
						Next
					</span>
					<span class="nextIcon">nextIcon</span>
					</aui:a>
				</c:when>
				<c:otherwise>
					<span class="nextText"><liferay-ui:message key="next" /></span>
					<span class="disableNextIcon">nextIcon</span>
				</c:otherwise>
			</c:choose>

			
		</div>
	</c:if>

	<div class="thread-actions">
		<liferay-ui:icon-list>
			<c:if test="<%= MBCategoryPermission.contains(permissionChecker, scopeGroupId, (category != null) ? category.getCategoryId() : MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID, ActionKeys.ADD_MESSAGE) %>">
				<portlet:renderURL var="addMessageURL">
					<portlet:param name="struts_action" value="/message_boards/edit_message" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="mbCategoryId" value="<%= (category != null) ? String.valueOf(category.getCategoryId()) : String.valueOf(MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) %>" />
				</portlet:renderURL>

				<liferay-ui:icon
					image="post"
					message="post-new-thread"
					url="<%= addMessageURL %>"
				/>
			</c:if>

			<c:if test="<%= !thread.isLocked() && MBMessagePermission.contains(permissionChecker, message, ActionKeys.PERMISSIONS) %>">

				<%
				MBMessage rootMessage = null;

				if (message.isRoot()) {
					rootMessage = message;
				}
				else {
					rootMessage = MBMessageLocalServiceUtil.getMessage(message.getRootMessageId());
				}
				%>

				<liferay-security:permissionsURL
					modelResource="<%= MBMessage.class.getName() %>"
					modelResourceDescription="<%= rootMessage.getSubject() %>"
					resourcePrimKey="<%= String.valueOf(thread.getRootMessageId()) %>"
					var="permissionsURL"
					windowState="<%= LiferayWindowState.POP_UP.toString() %>"
				/>

				<liferay-ui:icon
					image="permissions"
					method="get"
					url="<%= permissionsURL %>"
					useDialog="<%= true %>"
				/>
			</c:if>

			<c:if test="<%= enableRSS && MBMessagePermission.contains(permissionChecker, message, ActionKeys.VIEW) %>">

				<%
				rssURL.setParameter("mbCategoryId", StringPool.BLANK);
				rssURL.setParameter("threadId", String.valueOf(message.getThreadId()));
				%>

				<liferay-ui:rss
					delta="<%= rssDelta %>"
					displayStyle="<%= rssDisplayStyle %>"
					feedType="<%= rssFeedType %>"
					resourceURL="<%= rssURL %>"
				/>
			</c:if>

			<c:if test="<%= MBMessagePermission.contains(permissionChecker, message, ActionKeys.SUBSCRIBE) && (MBUtil.getEmailMessageAddedEnabled(portletPreferences) || MBUtil.getEmailMessageUpdatedEnabled(portletPreferences)) %>">
				<c:choose>
					<c:when test="<%= SubscriptionLocalServiceUtil.isSubscribed(user.getCompanyId(), user.getUserId(), MBThread.class.getName(), message.getThreadId()) %>">
						<portlet:actionURL var="unsubscribeURL">
							<portlet:param name="struts_action" value="/message_boards/edit_message" />
							<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.UNSUBSCRIBE %>" />
							<portlet:param name="redirect" value="<%= currentURL %>" />
							<portlet:param name="messageId" value="<%= String.valueOf(message.getMessageId()) %>" />
						</portlet:actionURL>

						<liferay-ui:icon
							image="unsubscribe"
							url="<%= unsubscribeURL %>"
						/>
					</c:when>
					<c:otherwise>
						<portlet:actionURL var="subscribeURL">
							<portlet:param name="struts_action" value="/message_boards/edit_message" />
							<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.SUBSCRIBE %>" />
							<portlet:param name="redirect" value="<%= currentURL %>" />
							<portlet:param name="messageId" value="<%= String.valueOf(message.getMessageId()) %>" />
						</portlet:actionURL>

						<liferay-ui:icon
							image="subscribe"
							url="<%= subscribeURL %>"
						/>
					</c:otherwise>
				</c:choose>
			</c:if>

			<c:if test="<%= MBCategoryPermission.contains(permissionChecker, scopeGroupId, (category != null) ? category.getCategoryId() : MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID, ActionKeys.LOCK_THREAD) %>">
				<c:choose>
					<c:when test="<%= thread.isLocked() %>">
						<portlet:actionURL var="unlockThreadURL">
							<portlet:param name="struts_action" value="/message_boards/edit_message" />
							<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.UNLOCK %>" />
							<portlet:param name="redirect" value="<%= currentURL %>" />
							<portlet:param name="threadId" value="<%= String.valueOf(message.getThreadId()) %>" />
						</portlet:actionURL>

						<liferay-ui:icon
							image="unlock"
							message="unlock-thread"
							url="<%= unlockThreadURL %>"
						/>
					</c:when>
					<c:otherwise>
						<portlet:actionURL var="lockThreadURL">
							<portlet:param name="struts_action" value="/message_boards/edit_message" />
							<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.LOCK %>" />
							<portlet:param name="redirect" value="<%= currentURL %>" />
							<portlet:param name="threadId" value="<%= String.valueOf(message.getThreadId()) %>" />
						</portlet:actionURL>

						<liferay-ui:icon
							image="lock"
							message="lock-thread"
							url="<%= lockThreadURL %>"
						/>
					</c:otherwise>
				</c:choose>
			</c:if>

			<c:if test="<%= MBCategoryPermission.contains(permissionChecker, scopeGroupId, (category != null) ? category.getCategoryId() : MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID, ActionKeys.MOVE_THREAD) %>">
				<portlet:renderURL var="editThreadURL">
					<portlet:param name="struts_action" value="/message_boards/move_thread" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="mbCategoryId" value="<%= (category != null) ? String.valueOf(category.getCategoryId()) : String.valueOf(MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) %>" />
					<portlet:param name="threadId" value="<%= String.valueOf(message.getThreadId()) %>" />
				</portlet:renderURL>

				<liferay-ui:icon
					image="forward"
					message="move-thread"
					url="<%= editThreadURL %>"
				/>
			</c:if>

			<c:if test="<%= MBMessagePermission.contains(permissionChecker, message, ActionKeys.DELETE) && !thread.isLocked() %>">
				<portlet:renderURL var="parentCategoryURL">
					<portlet:param name="struts_action" value="/message_boards/view" />
					<portlet:param name="mbCategoryId" value="<%= (category != null) ? String.valueOf(category.getCategoryId()) : String.valueOf(MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) %>" />
				</portlet:renderURL>

				<portlet:actionURL var="deleteURL">
					<portlet:param name="struts_action" value="/message_boards/delete_thread" />
					<portlet:param name="<%= Constants.CMD %>" value="<%= TrashUtil.isTrashEnabled(themeDisplay.getScopeGroupId()) ? Constants.MOVE_TO_TRASH : Constants.DELETE %>" />
					<portlet:param name="redirect" value="<%= parentCategoryURL %>" />
					<portlet:param name="threadId" value="<%= String.valueOf(message.getThreadId()) %>" />
				</portlet:actionURL>

				<liferay-ui:icon-delete
					trash="<%= TrashUtil.isTrashEnabled(themeDisplay.getScopeGroupId()) %>"
					url="<%= deleteURL %>"
				/>
			</c:if>
		</liferay-ui:icon-list>
	</div>

	<div class="clear"></div>
</div>

<c:choose>
	<c:when test="<%= Validator.isNull(redirect) %>">
		<portlet:renderURL var="backURL">
			<portlet:param name="struts_action" value="/message_boards/view" />
			<portlet:param name="mbCategoryId" value="<%= (category != null) ? String.valueOf(category.getCategoryId()) : String.valueOf(MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) %>" />
		</portlet:renderURL>

		<liferay-ui:header
			backLabel='<%= (category != null) ? category.getName() : "message-boards-home" %>'
			backURL="<%= backURL.toString() %>"
			localizeTitle="<%= false %>"
			title="<%= message.getSubject() %>"
		/>
	</c:when>
	<c:otherwise>
		<liferay-ui:header
			backURL="<%= redirect %>"
			localizeTitle="<%= false %>"
			title="<%= message.getSubject() %>"
		/>
	</c:otherwise>
</c:choose>
<div>

	<%
	MBTreeWalker treeWalker = messageDisplay.getTreeWalker();

	List<MBMessage> messages = null;

	if (treeWalker != null) {
		messages = new ArrayList<MBMessage>();

		messages.addAll(treeWalker.getMessages());

		messages = ListUtil.sort(messages, new MessageCreateDateComparator(true));
	}

	AssetUtil.addLayoutTags(request, AssetTagLocalServiceUtil.getTags(MBMessage.class.getName(), thread.getRootMessageId()));
	%>

	<div class="message-scroll" id="<portlet:namespace />message_0"></div>

	<c:if test="<%= threadView.equals(MBThreadConstants.THREAD_VIEW_COMBINATION) && (messages.size() > 1) %>">
		<liferay-ui:toggle-area id="toggle_id_message_boards_view_message_thread">
			<table class="toggle_id_message_boards_view_message_thread">

			<%
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER, treeWalker);
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_CATEGORY, category);
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_CUR_MESSAGE, treeWalker.getRoot());
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_DEPTH, new Integer(0));
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_LAST_NODE, Boolean.valueOf(false));
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_SEL_MESSAGE, message);
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_THREAD, thread);
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_THREAD_FLAG, threadFlag);
			%>

			<liferay-util:include page="/html/portlet/message_boards/view_thread_shortcut.jsp" />

			</table>
		</liferay-ui:toggle-area>
	</c:if>

	<%
	boolean viewableThread = false;
	%>

	<c:choose>
		<c:when test="<%= threadView.equals(MBThreadConstants.THREAD_VIEW_TREE) %>">

			<%
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER, treeWalker);
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_CATEGORY, category);
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_CUR_MESSAGE, treeWalker.getRoot());
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_DEPTH, new Integer(0));
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_LAST_NODE, Boolean.valueOf(false));
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_SEL_MESSAGE, message);
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_THREAD, thread);
			request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_VIEWABLE_THREAD, Boolean.FALSE.toString());
			%>

			<liferay-util:include page="/html/portlet/message_boards/view_thread_tree.jsp" />

			<%
			viewableThread = GetterUtil.getBoolean((String)request.getAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_VIEWABLE_THREAD));
			%>

		</c:when>
		<c:otherwise>
			<%@ include file="/html/portlet/message_boards/view_thread_flat.jspf" %>
		</c:otherwise>
	</c:choose>

	<c:if test="<%= !viewableThread %>">
		<div class="alert alert-error">
			<liferay-ui:message key="you-do-not-have-permission-to-access-the-requested-resource" />
		</div>
	</c:if>
</div>
