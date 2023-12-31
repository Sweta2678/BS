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

<%@ include file="/html/portlet/announcements/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

AnnouncementsEntry entry = (AnnouncementsEntry)request.getAttribute(WebKeys.ANNOUNCEMENTS_ENTRY);

long entryId = BeanParamUtil.getLong(entry, request, "entryId");

String content = BeanParamUtil.getString(entry, request, "content");

boolean displayImmediately = ParamUtil.getBoolean(request, "displayImmediately");

if (entry == null) {
	displayImmediately = true;
}
String scope = ParamUtil.getString(request, "distributionScope");
%>

<aui:form method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveEntry();" %>'>
 	<aui:input type="hidden"  name="distributionScope" value="<%=scope%>"/>
	<aui:input name="<%= Constants.CMD %>" type="hidden" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="entryId" type="hidden" value="<%= entryId %>" />
	<aui:input name="alert" type="hidden" value="<%= portletName.equals(PortletKeys.ALERTS) %>" />

	<liferay-ui:header
		backURL="<%= redirect %>"
		title="entry"
	/>

	<liferay-ui:error exception="<%= EntryContentException.class %>" message="please-enter-valid-content" />
	<liferay-ui:error exception="<%= EntryDisplayDateException.class %>" message="please-enter-a-valid-display-date" />
	<liferay-ui:error exception="<%= EntryExpirationDateException.class %>" message="please-enter-a-valid-expiration-date" />
	<liferay-ui:error exception="<%= EntryTitleException.class %>" message="please-enter-a-valid-title" />
	<liferay-ui:error exception="<%= EntryURLException.class %>" message="please-enter-a-valid-url" />

	<aui:model-context bean="<%= entry %>" model="<%= AnnouncementsEntry.class %>" />

	<aui:fieldset>
		<div style="display: none">
			<c:choose>
				<c:when test="<%= entry != null %>">
	
					<%
					boolean showScopeName = true;
					%>
	
					<%@ include file="/html/portlet/announcements/entry_scope.jspf" %>
	
				</c:when>
				<c:otherwise>
	
					<%
					String distributionScope = ParamUtil.getString(request, "distributionScope");
	
					long classNameId = -1;
					long classPK = -1;
	
					String[] distributionScopeArray = StringUtil.split(distributionScope);
	
					if (distributionScopeArray.length == 2) {
						classNameId = GetterUtil.getLong(distributionScopeArray[0]);
						classPK = GetterUtil.getLong(distributionScopeArray[1]);
					}
	
					boolean submitOnChange = false;
					%>
	
					<%@ include file="/html/portlet/announcements/entry_select_scope.jspf" %>
	
				</c:otherwise>
			</c:choose>
		</div>

		<aui:input autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) %>" name="title" />

		<div style="display: none"><aui:input name="url" /></div>

		<aui:field-wrapper label="content">
			<liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" />

			<aui:input name="content" type="hidden" />
		</aui:field-wrapper>

		<div style="display: none">
			<aui:select name="type">
	
				<%
				for (String curType : AnnouncementsEntryConstants.TYPES) {
				%>
					<aui:option label="<%= curType %>" selected="<%= (entry != null) && curType.equals(entry.getType()) %>" />
				<%
				}
				%>
	
			</aui:select>
	
			<aui:select name="priority">
				<aui:option label="normal" selected="<%= (entry != null) && (entry.getPriority() == 0) %>" value="0" />
				<aui:option label="important" selected="<%= (entry != null) && (entry.getPriority() == 1) %>" value="1" />
			</aui:select>
	
			<aui:input dateTogglerCheckboxLabel="display-immediately" disabled="<%= displayImmediately %>" name="displayDate" />
	
			<aui:input name="expirationDate" />
		</div>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" onClick='<%="return "+renderResponse.getNamespace() + "extractCodeFromEditor();"%>'/>

		<div style="display: none"><aui:button onClick='<%= renderResponse.getNamespace() + "previewEntry();" %>' value="preview" /></div>

		<aui:button href="<%= redirect %>" type="cancel" />
	</aui:button-row>
</aui:form>

<aui:script>
	function <portlet:namespace />getContent() {
		return window.<portlet:namespace />editor.getHTML();
	}

	function <portlet:namespace />initEditor() {
		return "<%= UnicodeFormatter.toString(content) %>";
	}

	function <portlet:namespace />previewEntry() {
		document.<portlet:namespace />fm.action = '<portlet:actionURL><portlet:param name="struts_action" value="/announcements/preview_entry" /></portlet:actionURL>';
		document.<portlet:namespace />fm.target = '_blank';
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.PREVIEW %>";
		document.<portlet:namespace />fm.<portlet:namespace />content.value = <portlet:namespace />getContent();
		document.<portlet:namespace />fm.submit();
	}

	function <portlet:namespace />saveEntry() {
		document.<portlet:namespace />fm.action = '<portlet:actionURL><portlet:param name="struts_action" value="/announcements/edit_entry" /></portlet:actionURL>';
		document.<portlet:namespace />fm.target = '';
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= (entry == null) ? Constants.ADD : Constants.UPDATE %>";
		document.<portlet:namespace />fm.<portlet:namespace />content.value = <portlet:namespace />getContent();

		submitForm(document.<portlet:namespace />fm);
	}
	
	window.onload = function(e){
		document.<portlet:namespace />fm.<portlet:namespace />content.setAttribute("maxlength","350");
	}
	
	function <portlet:namespace />extractCodeFromEditor() {
        var content = <portlet:namespace />getContent();
        var contentLength = $("<div/>").html(content).text().length;
		if(contentLength > 350){
			alert("Max character length is 350.");
			return false;
		}
    }
</aui:script>

<%!
public static final String EDITOR_WYSIWYG_IMPL_KEY = "editor.wysiwyg.portal-web.docroot.html.portlet.announcements.edit_entry.jsp";
%>