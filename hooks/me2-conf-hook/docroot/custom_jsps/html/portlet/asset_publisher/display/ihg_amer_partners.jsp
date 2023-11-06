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

String summary = StringUtil.shorten(assetRenderer.getSummary(), abstractLength);
String viewFullContentURLString = viewFullContentURL.toString();

viewFullContentURLString = HttpUtil.setParameter(viewFullContentURLString, "redirect", currentURL);

String viewURL = viewInContext ? assetRenderer.getURLViewInContext(liferayPortletRequest, liferayPortletResponse, viewFullContentURLString) : viewFullContentURLString;

viewURL = _checkViewURL(assetEntry, viewInContext, viewURL, currentURL, themeDisplay);
String viewURLMessage = viewInContext ? assetRenderer.getViewInContextMessage() : "read-more-x-about-x";

// Custom code
JournalArticle journalArticle = JournalArticleLocalServiceUtil.getLatestArticle(assetEntry.getClassPK());
org.dom4j.Document document = DocumentHelper.createDocument();

String smallImage = "";
String image = "";
String description = "";
String details = "";
String website = "";
String contactPerson = "";
String email = "";
String telephone = "";

if (Validator.isNotNull(journalArticle.getContent())) {
	SAXReader reader = new SAXReader();
	try {
		document = reader.read(new InputSource(new StringReader(journalArticle.getContent())));
		for(Iterator iterator = document.getRootElement().elements().iterator(); iterator.hasNext();) {
			org.dom4j.Element element = (org.dom4j.Element)iterator.next();
			
			if(Validator.isNotNull(element.attribute("name")) && element.attribute("name").getStringValue().equalsIgnoreCase("smallImage")
					&& Validator.isNotNull(element.element("dynamic-content"))) {
				
				smallImage = element.element("dynamic-content").getText();
				if(image.length() == 0) {
					image = "/me2-conf-theme/images/no-image-available-icon.jpg";
				}
				
			} else if(Validator.isNotNull(element.attribute("name")) && element.attribute("name").getStringValue().equalsIgnoreCase("image")
					&& Validator.isNotNull(element.element("dynamic-content"))) {
				
				image = element.element("dynamic-content").getText();
				
			} else if(Validator.isNotNull(element.attribute("name")) && element.attribute("name").getStringValue().equalsIgnoreCase("description")
					&& Validator.isNotNull(element.element("dynamic-content"))) {
				
				description = element.element("dynamic-content").getText();
				
			} else if(Validator.isNotNull(element.attribute("name")) && element.attribute("name").getStringValue().equalsIgnoreCase("website")
					&& Validator.isNotNull(element.element("dynamic-content"))) {
				
				website = element.element("dynamic-content").getText();
				if(!website.contains("http://")) {
					website = "http://" + website;
				}
				
			} else if(Validator.isNotNull(element.attribute("name")) && element.attribute("name").getStringValue().equalsIgnoreCase("contactPerson")
					&& Validator.isNotNull(element.element("dynamic-content"))) {
				
				contactPerson = element.element("dynamic-content").getText();
				
			} else if(Validator.isNotNull(element.attribute("name")) && element.attribute("name").getStringValue().equalsIgnoreCase("email")
					&& Validator.isNotNull(element.element("dynamic-content"))) {
				
				email = element.element("dynamic-content").getText();
				
			} else if(Validator.isNotNull(element.attribute("name")) && element.attribute("name").getStringValue().equalsIgnoreCase("telephone")
					&& Validator.isNotNull(element.element("dynamic-content"))) {
				
				telephone = element.element("dynamic-content").getText();
			}
		}
	} catch (DocumentException e) {
		e.printStackTrace();
	}
}

// Changes end
%>

	<liferay-util:include page="/html/portlet/asset_publisher/asset_actions.jsp" />
<!-- ================================================================================================================================================================= -->	
	<%-- <div class="portlet-sub-content">
		<div class="fLeft partner-portlet-left">
			<a name="<%= title%>"><img class="speaker-img-cls" src="<%= image%>" width="250px" height="100px"></a>
		</div>
		<div class="fLeft partner-portlet-right">
			<h1 class="speaker-h1"><%= title%></h1>
			<p style="margin:0px;"><%= description%></p>
		</div>
			<div class="speaker-right-col">
	<%
		if(!"".equals(website)) {
	%>
			
				<h1 class="speaker-h1">Web</h1>
				<a href="<%= website%>" target="_blank" style="font-size: 16px;"><strong><%= website%></strong></a>
			
	<%
		}
		
		if(!"".equals(contactPerson)) {
	%>
			
				<h1 class="speaker-h1">Contact Person</h1>
				<strong><%= contactPerson%></strong>
			
	<%
		}
		
		if(!"".equals(email)) {
	%>
			
				<h1 class="speaker-h1">Email</h1>
				<a href="mailto:<%= email%>" style="font-size: 16px;"><strong><%= email%></strong></a>
			
	<%
		}
		
		if(!"".equals(telephone)) {
	%>
			
				<h1 class="speaker-h1">Phone</h1>
				<strong><%= telephone%></strong>
			
	<%
		}
	%>
			</div>
			<div class="clear "></div>
	</div> --%>
	<!-- ====================================================================================================================================================== -->
						<ul>
							<li id="<%=title%>">
						
							<span class="partner_img"><img alt="user image" title="user image" src="<%= image%>" width="209" height="91"></span>
							
							<h2>
								<a href="#" title="#"><%= title%></a>
							</h2>						

							<p class="address">
								<span class="title">CONTACT PERSON</span>
								<%
									
									
									if(!"".equals(contactPerson)) {
								%>								
								<span class="name"><%= contactPerson%></span>
								<%
									}
									if(!"".equals(email)) {
								%>
								<span class="email"><%= email%></span>
								<%
									}
									if(!"".equals(website)) {
								%>
								<span class="url"><%= website%></span>
								<%
									}
									if(!"".equals(telephone)) {
								%>
								<span class="ph"><%= telephone%></span>
								<%
									}
								%>
							</p>
							
							<p>						
								<%= description%>
							</p>
							
							<span>
								<a href="#" class="top rightpos">
									<span>TOP</span>
								</a>
							</span>
							</li>
						</ul>
	
	
	
	<!-- <div class="partner-bottom-line"><a href="#" class="back-to-top fRight">Back to top</a></div> -->
	
	<div class="asset-metadata">
			<%
				request.setAttribute("asset_metadata.jspf-filterByMetadata", true);
			%>
			
		<%@ include file="/html/portlet/asset_publisher/asset_metadata.jspf" %>
	</div>
	
	<c:if test="<%= (assetEntryIndex + 1) == results.size() %>">
		<div class="final-separator"><!-- --></div>
	</c:if>
