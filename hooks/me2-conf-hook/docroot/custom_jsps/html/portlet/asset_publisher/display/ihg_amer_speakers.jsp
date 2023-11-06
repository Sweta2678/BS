<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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
<%@page import="java.util.ArrayList"%>
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
String viewURLMessage = viewInContext ? assetRenderer.getViewInContextMessage() : "read-more-x-about-x";

String viewFullContentURLString = viewFullContentURL.toString();

viewFullContentURLString = HttpUtil.setParameter(viewFullContentURLString, "redirect", currentURL);

String viewURL = viewInContext ? assetRenderer.getURLViewInContext(liferayPortletRequest, liferayPortletResponse, viewFullContentURLString) : viewFullContentURLString;

viewURL = _checkViewURL(assetEntry, viewInContext, viewURL, currentURL, themeDisplay);


// Custom code
JournalArticle journalArticle = JournalArticleLocalServiceUtil.getLatestArticle(assetEntry.getClassPK());
org.dom4j.Document document = DocumentHelper.createDocument();

String content = "";
String smallImage = "";
String area = "";
String designation = "";
String sessionName = "";
String time = "";
List<String> sessionNameList = new ArrayList<String>();
List<String> sessionTimeList = new ArrayList<String>();


if (Validator.isNotNull(journalArticle.getContent())) {
	  SAXReader reader = new SAXReader();
	  try {
		document = reader.read(new InputSource(new StringReader(journalArticle.getContent())));
		for(Iterator iterator = document.getRootElement().elements().iterator(); iterator.hasNext();) 
		{
			org.dom4j.Element element = (org.dom4j.Element)iterator.next();
			if(Validator.isNotNull(element.attribute("name")) && element.attribute("name").getStringValue().equalsIgnoreCase("content")
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
			else if(Validator.isNotNull(element.attribute("name")) && element.attribute("name").getStringValue().equalsIgnoreCase("session")
					&& Validator.isNotNull(element.element("dynamic-content"))) {
				
				//speakerName = element.element("dynamic-content").getText();
				for(Iterator iterator1 = element.elements().iterator(); iterator1.hasNext();) {
					org.dom4j.Element element1 = (org.dom4j.Element)iterator1.next();
					if(Validator.isNotNull(element1.attribute("name")) && element1.attribute("name").getStringValue().equalsIgnoreCase("sessionName")
							&& Validator.isNotNull(element1.element("dynamic-content"))) {
						
						sessionName = element1.element("dynamic-content").getText();
						sessionNameList.add(sessionName);
					} else if(Validator.isNotNull(element1.attribute("name")) && element1.attribute("name").getStringValue().equalsIgnoreCase("time")
							&& Validator.isNotNull(element1.element("dynamic-content"))) {
						
						time = element1.element("dynamic-content").getText();
						sessionTimeList.add(time);
					}
					
					
					
					
				}
			}
			
		}
	} catch (DocumentException e) {
		e.printStackTrace();
	}
	//content = StringUtil.shorten(content, abstractLength);
}

// Changes end
%>

	<liferay-util:include page="/html/portlet/asset_publisher/asset_actions.jsp" />
	
<%-- 	<div class="portlet-sub-content" >
		<a name="link<%=assetEntryIndex%>">
			<div class="fLeft speaker-portlet-left">
				<img class="speaker-img-cls" src="<%=smallImage%>" style="margin-right:10px;width:150px;height:150px">
			</div>
		</a>
		<div class="fLeft portlet-speaker-right">
			<h1 class="speaker-h1"><%=HtmlUtil.escape(title)%></h1>
			<h2 class="speaker-h2"><%=designation%><%=designation != null && !designation.equals("") &&  area != null && !area.equals("") ? "," : "" %> <%=area%></h2>
			<p style="margin:0px;">
				<%=content%>
			</p>
		</div>
		<div class="award-right-col">
			<h1 class="speaker-h1 left-padding-10">Sessions</h1>
			<ul class="speaker-right-ul">
			<%
			for (int i = 0; i < sessionNameList.size(); i++) {
				String  nameOfSession = (String)sessionNameList.get(i);
				String  timeOfSession = (String)sessionTimeList.get(i);
			%>
				<li>
					<strong><%=nameOfSession%></strong>
					<span><%=timeOfSession%></span>
				</li>
			<%
			}
			%>
			
			</ul>
		</div>
		<div class="clear "></div>
	</div>
	
	<div class="back-to-top-main margT75"><a class="back-to-top-award" href="#">Back to top</a></div>
	
	<div class="asset-metadata">
		<%@ include file="/html/portlet/asset_publisher/asset_metadata.jspf" %>
	</div>
	
	<c:if test="<%= (assetEntryIndex + 1) == results.size() %>">
		<div class="final-separator"><!-- --></div>
	</c:if> --%>
	
		
					<ul>
						<li id="link<%=assetEntryIndex%>">
							<span class="events_result_img"><img  src="<%=smallImage%>" width="110" height="110"></span>
							<h2>
								<a href="#" title="#"><%=HtmlUtil.escape(title)%></a>
							</h2>
							<span class="designation"><%=designation%></span>
							<p>					
								<%=content%>
							</p>
							
							<span>
								<a href="#" class="top rightpos">
									<span>TOP</span>
								</a>
							</span>
						</li>
						
					</ul>
	
	<div class="asset-metadata">
		<%
			request.setAttribute("asset_metadata.jspf-filterByMetadata", true);
		%>
			
		<%@ include file="/html/portlet/asset_publisher/asset_metadata.jspf" %>
	</div>
