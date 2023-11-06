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

<%@page import="java.io.StringReader"%>
<%@page import="org.xml.sax.InputSource"%>
<%@page import="org.dom4j.DocumentException"%>
<%@page import="org.dom4j.io.SAXReader"%>
<%@page import="org.dom4j.DocumentHelper"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@ include file="/html/portlet/asset_publisher/init.jsp" %>
<%@ page import="com.liferay.portlet.ratings.service.RatingsStatsLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.ratings.model.RatingsStats" %>

<%
List results = (List)request.getAttribute("view.jsp-results");

int assetEntryIndex = ((Integer)request.getAttribute("view.jsp-assetEntryIndex")).intValue();

AssetEntry assetEntry = (AssetEntry)request.getAttribute("view.jsp-assetEntry");
AssetRendererFactory assetRendererFactory = (AssetRendererFactory)request.getAttribute("view.jsp-assetRendererFactory");
AssetRenderer assetRenderer = (AssetRenderer)request.getAttribute("view.jsp-assetRenderer");

boolean show = ((Boolean)request.getAttribute("view.jsp-show")).booleanValue();

request.setAttribute("view.jsp-showIconLabel", true);

String title = (String)request.getAttribute("view.jsp-title");

if (Validator.isNull(title)) {
	title = assetRenderer.getTitle(locale);
}

PortletURL viewFullContentURL = renderResponse.createRenderURL();

viewFullContentURL.setParameter("struts_action", "/asset_publisher/view_content");
viewFullContentURL.setParameter("assetEntryId", String.valueOf(assetEntry.getEntryId()));
viewFullContentURL.setParameter("type", assetRendererFactory.getType());

if (Validator.isNotNull(assetRenderer.getUrlTitle())) {
	if (assetRenderer.getGroupId() != scopeGroupId) {
		viewFullContentURL.setParameter("groupId", String.valueOf(assetRenderer.getGroupId()));
	}

	viewFullContentURL.setParameter("urlTitle", assetRenderer.getUrlTitle());
}

String viewFullContentURLString = viewFullContentURL.toString();

viewFullContentURLString = HttpUtil.setParameter(viewFullContentURLString, "redirect", currentURL);

String summary = StringUtil.shorten(assetRenderer.getSummary(locale), abstractLength);
String viewURL = viewInContext ? assetRenderer.getURLViewInContext(liferayPortletRequest, liferayPortletResponse, viewFullContentURLString) : viewFullContentURLString;
String viewURLMessage = viewInContext ? assetRenderer.getViewInContextMessage() : "read-more-x-about-x";

viewURL = _checkViewURL(assetEntry, viewInContext, viewURL, currentURL, themeDisplay);

//Custom code
JournalArticle journalArticle = JournalArticleLocalServiceUtil.getLatestArticle(assetEntry.getClassPK());
org.dom4j.Document document = DocumentHelper.createDocument();


String answer = "";

if (Validator.isNotNull(journalArticle.getContent())) {
	SAXReader reader = new SAXReader();
	try {
		document = reader.read(new InputSource(new StringReader(journalArticle.getContent())));
		for(Iterator iterator = document.getRootElement().elements().iterator(); iterator.hasNext();) {
			org.dom4j.Element element = (org.dom4j.Element)iterator.next();
			
			if(Validator.isNotNull(element.attribute("name")) && element.attribute("name").getStringValue().equalsIgnoreCase("answer")
					&& Validator.isNotNull(element.element("dynamic-content"))) {
				
				answer = element.element("dynamic-content").getText();
				
				
			} 
		}
	} catch (DocumentException e) {
		e.printStackTrace();
	}
	//travelDetails = StringUtil.shorten(travelDetails, abstractLength);
}

//Changes end
%>
<c:if test="<%= show %>">
	<liferay-util:include page="/html/portlet/asset_publisher/asset_actions.jsp" />
	
	<p class="fBold">
		<%= title %>
	</p>
	<p class="mLeft25">
		<%= answer %>
	</p>
	
	<div class="asset-metadata">

		<%
		request.setAttribute("asset_metadata.jspf-filterByMetadata", true);
		%>

		<%@ include file="/html/portlet/asset_publisher/asset_metadata.jspf" %>
	</div>

	<c:if test="<%= (assetEntryIndex + 1) == results.size() %>">
		<div class="final-separator"><!-- --></div>
	</c:if>
</c:if>