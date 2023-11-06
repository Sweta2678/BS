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
<%@ include file="/html/portlet/journal/init.jsp" %>

<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="javax.portlet.PortletRequest" %>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%
	String portletResource = ParamUtil.getString(request, "portletResource");
	PortletPreferences portletSetup = renderRequest.getPreferences();
	String noCustom = portletSetup.getValue("noCustom","true"); //Check to use liferay's OOB
	
	String redirect = ParamUtil.getString(request, "redirect");
%>
<%
		String tabs2 = ParamUtil.getString(request, "tabs2");
		
		// Make sure the redirect is correct. This is a workaround for a layout that
		// has both the Journal and Journal Content portlets and the user edits an
		// article through the Journal Content portlet and then hits cancel.
		
		/*if (redirect.indexOf("p_p_id=" + PortletKeys.JOURNAL_CONTENT) != -1) {
			if (layoutTypePortlet.hasPortletId(PortletKeys.JOURNAL)) {
				PortletURL portletURL = renderResponse.createRenderURL();
		
				portletURL.setPortletMode(PortletMode.VIEW);
				portletURL.setWindowState(WindowState.NORMAL);
		
				redirect = portletURL.toString();
			}
		}*/
		
		String backURL = ParamUtil.getString(request, "backURL");
		
		String referringPortletResource = ParamUtil.getString(request, "referringPortletResource");
		
		JournalArticle article = (JournalArticle)request.getAttribute(WebKeys.JOURNAL_ARTICLE);
		
		//Patch for date component to migrate from 6.0 to 6.2

		String xmlContentStr = "<root></root>";
		if (article != null && article.getContent() != null && !"".equals(article.getContent())) {
			xmlContentStr = article.getContent();
			org.dom4j.Document xmlContent = org.dom4j.DocumentHelper.parseText(xmlContentStr);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			List<org.dom4j.Node> dateElements = xmlContent.selectNodes("//root/dynamic-element[@type='date']");
			List<org.dom4j.Node> ddmDateElements = xmlContent.selectNodes("//root/dynamic-element[@type='ddm-date-time']");
			if (ddmDateElements != null && !ddmDateElements.isEmpty()) {
				for (org.dom4j.Node ddmDate : ddmDateElements) {
					org.dom4j.Node dateNode =  ddmDate.selectSingleNode("dynamic-content");
					if (dateNode != null && dateNode.getText() != null && !"".equals(dateNode.getText())) {
							String dateValue = dateNode.getText();
							dateNode.setText(""+formatter.parse(dateValue).getTime());
					}
				}
				article.setContent(xmlContent.asXML());
			} else if (dateElements!= null &&  !dateElements.isEmpty()) {
				
				for (org.dom4j.Node ddmDate : dateElements) {
					org.dom4j.Node dateNode =  ddmDate.selectSingleNode("dynamic-content");
					//System.out.println("ddmDate :"+dateNode);
					if (dateNode != null) {
						org.dom4j.Element element = (org.dom4j.Element)dateNode;
						if ( dateNode.getText() != null && !"".equals(dateNode.getText())) {
							String dateValue = dateNode.getText();
							dateNode.setText(""+formatter.parse(dateValue).getTime());
						}
							element.addAttribute("fieldNamespace", "ddm");
							element.addAttribute("dataType", "date");
							element.addAttribute("type", "ddm-date-time");
					}
				}
				article.setContent(xmlContent.asXML());
			}
		}
		
		long groupId = BeanParamUtil.getLong(article, request, "groupId", scopeGroupId);
		
		long folderId = BeanParamUtil.getLong(article, request, "folderId", JournalFolderConstants.DEFAULT_PARENT_FOLDER_ID);
		
		long classNameId = BeanParamUtil.getLong(article, request, "classNameId");
		long classPK = BeanParamUtil.getLong(article, request, "classPK");
		
		String articleId = BeanParamUtil.getString(article, request, "articleId");
		
		double version = BeanParamUtil.getDouble(article, request, "version", JournalArticleConstants.VERSION_DEFAULT);
		
		String structureId = BeanParamUtil.getString(article, request, "structureId");
		
		DDMStructure ddmStructure = null;
		
		long ddmStructureId = ParamUtil.getLong(request, "ddmStructureId");
		
		if (ddmStructureId > 0) {
			try {
				ddmStructure = DDMStructureLocalServiceUtil.getStructure(ddmStructureId);
			}
			catch (NoSuchStructureException nsse) {
			}
		}
		else if (Validator.isNotNull(structureId)) {
			try {
				ddmStructure = DDMStructureLocalServiceUtil.getStructure(themeDisplay.getSiteGroupId(), PortalUtil.getClassNameId(JournalArticle.class), structureId, true);
			}
			catch (NoSuchStructureException nsse) {
			}
		}
		
		String templateId = BeanParamUtil.getString(article, request, "templateId");
		
		DDMTemplate ddmTemplate = null;
		
		long ddmTemplateId = ParamUtil.getLong(request, "ddmTemplateId");
		
		if (ddmTemplateId > 0) {
			try {
				ddmTemplate = DDMTemplateLocalServiceUtil.getTemplate(ddmTemplateId);
			}
			catch (NoSuchTemplateException nste) {
			}
		}
		else if (Validator.isNotNull(templateId)) {
			try {
				ddmTemplate = DDMTemplateLocalServiceUtil.getTemplate(groupId, PortalUtil.getClassNameId(DDMStructure.class), templateId, true);
			}
			catch (NoSuchStructureException nste) {
			}
		}
		
		String defaultLanguageId = ParamUtil.getString(request, "defaultLanguageId");
		
		String toLanguageId = ParamUtil.getString(request, "toLanguageId");
		
		if (Validator.isNull(defaultLanguageId) || !LanguageUtil.isAvailableLocale(themeDisplay.getSiteGroupId(), defaultLanguageId)) {
			if (article != null) {
				defaultLanguageId = article.getDefaultLanguageId();
			}
			else {
				defaultLanguageId = LocaleUtil.toLanguageId(themeDisplay.getSiteDefaultLocale());
			}
		}
		
		boolean showHeader = ParamUtil.getBoolean(request, "showHeader", true);
		
		String[] mainSections = PropsValues.JOURNAL_ARTICLE_FORM_ADD;
		
		if (Validator.isNotNull(toLanguageId)) {
			mainSections = PropsValues.JOURNAL_ARTICLE_FORM_TRANSLATE;
		}
		else if ((article != null) && (article.getId() > 0)) {
			mainSections = PropsValues.JOURNAL_ARTICLE_FORM_UPDATE;
		}
		else if (classNameId > JournalArticleConstants.CLASSNAME_ID_DEFAULT) {
			mainSections = PropsValues.JOURNAL_ARTICLE_FORM_DEFAULT_VALUES;
		}

		request.setAttribute("edit_article.jsp-redirect", redirect);
		
		request.setAttribute("edit_article.jsp-structure", ddmStructure);
		request.setAttribute("edit_article.jsp-template", ddmTemplate);
		
		request.setAttribute("edit_article.jsp-defaultLanguageId", defaultLanguageId);
		request.setAttribute("edit_article.jsp-toLanguageId", toLanguageId);
%>
<c:choose>
	<c:when test='<%= noCustom.equals("true") %>'>
		<%@ include file="edit_article_original.jsp" %>
	</c:when>
	<c:otherwise>
		<%@ include file="edit_article_with_configuration.jsp" %>
	</c:otherwise>
</c:choose>

<aui:script>
	var <portlet:namespace />documentLibraryInput = null;
	var <portlet:namespace />imageGalleryInput = null;

	function <portlet:namespace />publishArticle() {
		document.<portlet:namespace />fm1.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.PUBLISH %>";
	}

	function <portlet:namespace />removeArticleLocale() {
		if (confirm("<%= UnicodeLanguageUtil.get(pageContext, "are-you-sure-you-want-to-deactivate-this-language") %>")) {
			document.<portlet:namespace />fm1.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.DELETE_TRANSLATION %>";
			document.<portlet:namespace />fm1.<portlet:namespace />redirect.value = "<portlet:renderURL><portlet:param name="redirect" value="<%= redirect %>" /><portlet:param name="struts_action" value="/journal/edit_article" /><portlet:param name="groupId" value="<%= String.valueOf(groupId) %>" /><portlet:param name="articleId" value="<%= articleId %>" /><portlet:param name="version" value="<%= String.valueOf(version) %>" /></portlet:renderURL>&<portlet:namespace />languageId=<%= HtmlUtil.escapeJS(defaultLanguageId) %>";

			submitForm(document.<portlet:namespace />fm1);
		}
	}

	function <portlet:namespace />saveArticle() {
		document.<portlet:namespace />fm1.<portlet:namespace /><%= Constants.CMD %>.value = "<%= ((article == null) || Validator.isNull(article.getArticleId())) ? Constants.ADD : Constants.UPDATE %>";
	}

	function <portlet:namespace />selectDocumentLibrary(url) {
		document.getElementById(<portlet:namespace />documentLibraryInput).value = url;
	}

	function <portlet:namespace />selectImageGallery(url) {
		document.getElementById(<portlet:namespace />imageGalleryInput).value = url;
	}

	function <portlet:namespace />submitForm(event) {
		event.preventDefault();

		if (window.<portlet:namespace />journalPortlet) {
			var cmd = document.<portlet:namespace />fm1.<portlet:namespace /><%= Constants.CMD %>.value;

			if (cmd === '<%= Constants.TRANSLATE %>') {
				window.<portlet:namespace />journalPortlet.translateArticle();
			}
			else {
				window.<portlet:namespace />journalPortlet.saveArticle(cmd);
			}
		}
	}

	function <portlet:namespace />translateArticle() {
		document.<portlet:namespace />fm1.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.TRANSLATE %>";
	}

	<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
		<c:choose>
			<c:when test="<%= PropsValues.JOURNAL_ARTICLE_FORCE_AUTOGENERATE_ID %>">
				Liferay.Util.focusFormField(document.<portlet:namespace />fm1.<portlet:namespace />title);
			</c:when>
			<c:otherwise>
				Liferay.Util.focusFormField(document.<portlet:namespace />fm1.<portlet:namespace /><%= (article == null) ? "newArticleId" : "title" %>);
			</c:otherwise>
		</c:choose>
	</c:if>
</aui:script>

<%!
private String _getSectionJsp(String name) {
	return TextFormatter.format(name, TextFormatter.N);
}

private static final String[] _CATEGORY_NAMES = {""};
%>