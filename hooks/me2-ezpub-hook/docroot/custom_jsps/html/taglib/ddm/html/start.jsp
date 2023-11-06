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

<%@page import="java.util.List"%>
<%@page import="com.liferay.portlet.dynamicdatamapping.storage.Fields"%>
<%@ include file="/html/taglib/ddm/html/init.jsp" %>

<div class="lfr-ddm-container" id="<%= randomNamespace %>">
	<c:if test="<%= Validator.isNotNull(xsd) %>">

		<%
		pageContext.setAttribute("checkRequired", checkRequired);
		%>
		<%
		org.dom4j.Document xmlContent = org.dom4j.DocumentHelper.parseText(xsd);

		List<org.dom4j.Node> dateNodes =  xmlContent.selectNodes("//root/dynamic-element[@type='ddm-date-time']");
		if (dateNodes != null && !dateNodes.isEmpty()) {
			for (org.dom4j.Node dateNode : dateNodes) {
				org.dom4j.Element element = (org.dom4j.Element)dateNode;
					element.addAttribute("type", "ddm-date");
					element.addAttribute("dataType", "date");
					element.addAttribute("fieldNamespace", "ddm");
			}
		}
		%>
		<%= DDMXSDUtil.getHTML(pageContext, xmlContent.asXML(), fields, portletResponse.getNamespace(), fieldsNamespace, mode, readOnly, requestedLocale) %>

		<aui:input name="<%= fieldsDisplayInputName %>" type="hidden" />

		<aui:script use="liferay-ddm-repeatable-fields">
			new Liferay.DDM.RepeatableFields(
				{
					classNameId: <%= classNameId %>,
					classPK: <%= classPK %>,
					container: '#<%= randomNamespace %>',
					doAsGroupId: <%= scopeGroupId %>,
					fieldsDisplayInput: '#<portlet:namespace /><%= fieldsDisplayInputName %>',
					namespace: '<%= fieldsNamespace %>',
					p_l_id: <%= themeDisplay.getPlid() %>,
					portletNamespace: '<portlet:namespace />',
					repeatable: <%= repeatable %>
				}
			);
		</aui:script>
	</c:if>