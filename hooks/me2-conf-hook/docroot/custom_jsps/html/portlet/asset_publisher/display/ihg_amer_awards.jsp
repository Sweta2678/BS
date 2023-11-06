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

PortletURL viewFullContentURL = liferayPortletResponse.createLiferayPortletURL(plid, portletDisplay.getId(), PortletRequest.RENDER_PHASE, true);

viewFullContentURL.setParameter("struts_action", "/asset_publisher/view_content");
viewFullContentURL.setParameter("redirect", currentURL);
viewFullContentURL.setParameter("assetEntryId", String.valueOf(assetEntry.getEntryId()));
viewFullContentURL.setParameter("type", assetRendererFactory.getType());

if (Validator.isNotNull(assetRenderer.getUrlTitle())) {
	if (assetRenderer.getGroupId() != scopeGroupId) {
		viewFullContentURL.setParameter("groupId", String.valueOf(assetRenderer.getGroupId()));
	}

	viewFullContentURL.setParameter("urlTitle", assetRenderer.getUrlTitle());
}

String summary = StringUtil.shorten(assetRenderer.getSummary(locale), abstractLength);
String viewURL = null;

if (viewInContext) {
	String viewFullContentURLString = viewFullContentURL.toString();

	viewFullContentURLString = HttpUtil.setParameter(viewFullContentURLString, "redirect", currentURL);

	viewURL = assetRenderer.getURLViewInContext(liferayPortletRequest, liferayPortletResponse, viewFullContentURLString);
}
else {
	viewURL = viewFullContentURL.toString();
}

if (Validator.isNull(viewURL)) {
	viewURL = viewFullContentURL.toString();
}

String viewURLMessage = viewInContext ? assetRenderer.getViewInContextMessage() : "read-more-x-about-x";

viewURL = _checkViewURL(assetEntry, viewInContext, viewURL, currentURL, themeDisplay);


// Custom code
JournalArticle journalArticle = JournalArticleLocalServiceUtil.getLatestArticle(assetEntry.getClassPK());
org.dom4j.Document document = DocumentHelper.createDocument();

String content = "";
String smallImage = "";
String area = "";
String designation = "";
String awardWon = "";

if (Validator.isNotNull(journalArticle.getContent()) ) {
	  SAXReader reader = new SAXReader();
	  try {
		document = reader.read(new InputSource(new StringReader(journalArticle.getContent())));
		for(Iterator iterator = document.getRootElement().elements().iterator(); iterator.hasNext();) 
		{
			org.dom4j.Element element = (org.dom4j.Element)iterator.next();
			if(Validator.isNotNull(element.attribute("name")) && element.attribute("name").getStringValue().equalsIgnoreCase("Body")
					&& Validator.isNotNull(element.element("dynamic-content"))) {
				
				content = element.element("dynamic-content").getText();
			} else if(Validator.isNotNull(element.attribute("name")) && element.attribute("name").getStringValue().equalsIgnoreCase("smallImage")
					&& Validator.isNotNull(element.element("dynamic-content"))) {
				
				smallImage = element.element("dynamic-content").getText();				
				if(smallImage.length() == 0) {
					smallImage = "/me2-conf-theme/images/no-image-available-icon.jpg";
				}
			}else if(Validator.isNotNull(element.attribute("name")) && element.attribute("name").getStringValue().equalsIgnoreCase("designation")
					&& Validator.isNotNull(element.element("dynamic-content"))) {
				
				designation = element.element("dynamic-content").getText();
			}
			else if(Validator.isNotNull(element.attribute("name")) && element.attribute("name").getStringValue().equalsIgnoreCase("area")
					&& Validator.isNotNull(element.element("dynamic-content"))) {
				
				area = element.element("dynamic-content").getText();
			}		
			else if(Validator.isNotNull(element.attribute("name")) && element.attribute("name").getStringValue().equalsIgnoreCase("awardWon")
					&& Validator.isNotNull(element.element("dynamic-content"))) {
				
				awardWon = element.element("dynamic-content").getText();
			}
		}
	} catch (DocumentException e) {
		e.printStackTrace();
	}
	content = StringUtil.shorten(content, abstractLength);
}


// Changes end
%>

<c:if test="<%= show %>">
	<%	
	// Odd/First column
	if((assetEntryIndex + 1) % 2 != 0){
	%>
		<div class="awards_left <%= defaultAssetPublisher ? "default-asset-publisher" : StringPool.BLANK %>">
			<div class="awards_content_container">
				<liferay-util:include page="/html/portlet/asset_publisher/asset_actions.jsp" />
				<div class="awards_img">
					<img src="<%=smallImage%>" width="114" height="114"/>
				</div>
				<div class="awards_content_text">
					<div class="awards_name"><%=HtmlUtil.escape(title)%></div>
					<div class="awards_sep_line"></div>
					<div class="awards_label"><%=awardWon%></div>			
					<div class="awards_designation"><%=designation%></div>
					<div class="awards_area"><%=area%></div>
				</div>
				
			</div>
		</div>
		<%-- <div class="asset-metadata">
			<%@ include file="/html/portlet/asset_publisher/asset_metadata.jspf" %>
		</div>
		
		<c:if test="<%= (assetEntryIndex + 1) == results.size() %>">
			<div class="final-separator"><!-- --></div>
		</c:if> --%>
	
	<%
	} //Even/Second column
	else if((assetEntryIndex + 1) % 2 == 0){
	%>
		
	
		<div class="awards_right" >
			<div class="awards_content_container">
				<liferay-util:include page="/html/portlet/asset_publisher/asset_actions.jsp" />
				<div class="awards_img">
					<img src="<%=smallImage%>" width="114" height="114"/>
				</div>
				<div class="awards_content_text">
					<div class="awards_name"><%=HtmlUtil.escape(title)%></div>
					<div class="awards_sep_line"></div>
					<div class="awards_label"><%=awardWon%></div>
					<div class="awards_designation"><%=designation%></div>
					<div class="awards_area"><%=area%></div>
				</div>
				
			</div>
		</div>
		
			
		
	<%}	
	if((assetEntryIndex + 1) % 2 == 0){	%>
	<div class="asset-metadata">
	<%} %>
		<%@ include file="/html/portlet/asset_publisher/asset_metadata.jspf" %>
	<%
	if((assetEntryIndex + 1) % 2 == 0){
	%>
	</div>
	<%} %>
		
	<c:if test="<%= (assetEntryIndex + 1) == results.size() %>">
		<div class="final-separator"></div>
	</c:if>
	
</c:if>