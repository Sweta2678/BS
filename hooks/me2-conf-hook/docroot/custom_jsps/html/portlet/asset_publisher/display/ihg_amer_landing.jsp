
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

<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%






AssetEntry assetEntry = (AssetEntry)request.getAttribute("view.jsp-assetEntry");
AssetRendererFactory assetRendererFactory = (AssetRendererFactory)request.getAttribute("view.jsp-assetRendererFactory");
AssetRenderer assetRenderer = (AssetRenderer)request.getAttribute("view.jsp-assetRenderer");

boolean show = ((Boolean)request.getAttribute("view.jsp-show")).booleanValue();

request.setAttribute("view.jsp-showIconLabel", true);


// Custom code
JournalArticle journalArticle = JournalArticleLocalServiceUtil.getLatestArticle(assetEntry.getClassPK());
org.dom4j.Document document = DocumentHelper.createDocument();

String eventimage = "";
String eventtitle = "";
String startdate = "";
String enddate = "";
String location = "";
String description = "";
String detailslink = "";


if (Validator.isNotNull(journalArticle.getContent())) {
	SAXReader reader = new SAXReader();
	try {
		document = reader.read(new InputSource(new StringReader(journalArticle.getContent())));
		for(Iterator iterator = document.getRootElement().elements().iterator(); iterator.hasNext();) {
			org.dom4j.Element element = (org.dom4j.Element)iterator.next();
			
			if(Validator.isNotNull(element.attribute("name")) && element.attribute("name").getStringValue().equalsIgnoreCase("eventimage")
					&& Validator.isNotNull(element.element("dynamic-content"))) {
				
				eventimage = element.element("dynamic-content").getText();
				if(eventimage.length() == 0) {
					eventimage = "/me2-conf-theme/images/no-image-available-icon.jpg";
				}
				
			} else if(Validator.isNotNull(element.attribute("name")) && element.attribute("name").getStringValue().equalsIgnoreCase("eventtitle")
					&& Validator.isNotNull(element.element("dynamic-content"))) {
				
				eventtitle = element.element("dynamic-content").getText();
				
			} else if(Validator.isNotNull(element.attribute("name")) && element.attribute("name").getStringValue().equalsIgnoreCase("startdate")
					&& Validator.isNotNull(element.element("dynamic-content"))) {
				
				startdate = element.element("dynamic-content").getText();
				
			} else if(Validator.isNotNull(element.attribute("name")) && element.attribute("name").getStringValue().equalsIgnoreCase("enddate")
					&& Validator.isNotNull(element.element("dynamic-content"))) {
				
				enddate = element.element("dynamic-content").getText();
				
			} else if(Validator.isNotNull(element.attribute("name")) && element.attribute("name").getStringValue().equalsIgnoreCase("location")
					&& Validator.isNotNull(element.element("dynamic-content"))) {
				
				location = element.element("dynamic-content").getText();
				
			} else if(Validator.isNotNull(element.attribute("name")) && element.attribute("name").getStringValue().equalsIgnoreCase("description")
					&& Validator.isNotNull(element.element("dynamic-content"))) {
				
				description = element.element("dynamic-content").getText();
				
			} else if(Validator.isNotNull(element.attribute("name")) && element.attribute("name").getStringValue().equalsIgnoreCase("detailslink")
					&& Validator.isNotNull(element.element("dynamic-content"))) {
				
				detailslink = element.element("dynamic-content").getText();
			}
		}
	} catch (DocumentException e) {
		e.printStackTrace();
	}
}

// Changes end
%>


<%

SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
Date dateCurrent = new Date();


Date dateEvent = dateFormat.parse(enddate);

if(dateCurrent.before(dateEvent)) 
{
	
	final String OLD_FORMAT = "yyyy-MM-dd hh:mm";
	final String NEW_FORMAT = "dd MMM yyyy";

	
	String oldDateString = startdate;
	String newDateString;

	SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
	Date d = sdf.parse(oldDateString);
	sdf.applyPattern(NEW_FORMAT);
	newDateString = sdf.format(d);
	
%>

<c:if test="<%= show %>">
	<liferay-util:include page="/html/portlet/asset_publisher/asset_actions.jsp" />

	<div class = "conf_container <%= defaultAssetPublisher ? "default-asset-publisher" : StringPool.BLANK %>">
		<div class = "conf_img">
			<img src = "<%=eventimage%>">
		</div>
		<div class = "conf_content">
			<div class = "conf_label"><%=eventtitle %></div>
			<div class = "conf_start_info"><label class = "conf_start">Starts on: </label><label class = "conf_start_date"><%=newDateString %></label></div>
			<div class = "conf_loc_info"><label class = "conf_location">Location: </label><label class = "conf_location_name"><%=location %></label>
			</div>
			<div style="clear: both;height:0px;">&nbsp;</div>
			
			<div class = "conf_content_text">
			<%=description %>... 
			<a href="<%=detailslink%>">read more</a>
			</div>
		</div>
		<div style="clear: both;height:0px;">&nbsp;</div>
	</div>
	<div class = "conf_sep_line"></div>
	
	<div class="asset-metadata">
		<%@ include file="/html/portlet/asset_publisher/asset_metadata.jspf" %>
	</div>

</c:if>

<%
}
%>