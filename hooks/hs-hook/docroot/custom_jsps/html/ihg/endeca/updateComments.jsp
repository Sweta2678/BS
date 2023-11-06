<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="com.ihg.me2.hs.endecasearch.EndecaPost"%>
<%@page import="com.ihg.me2.hs.endecasearch.MerlinSearch"%>
<%@page import="com.ihg.me2.hs.logging.MerlinLogger"%>
<%@page import="com.ihg.me2.hs.logging.MerlinLoggerFactory"%>
<%@page import="com.ihg.me2.services.model.AlfrescoComments"%>
<%@page import="com.ihg.me2.services.service.AlfrescoCommentsLocalServiceUtil"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%

MerlinLogger mLogger = MerlinLoggerFactory.getMerlinLogger("updateComments.jsp");
MerlinSearch.setLogger(mLogger);
long messageId = Long.valueOf(request.getParameter("messageId")).longValue();
String trackingStatus = request.getParameter("status");
String commentType = request.getParameter("type");

// Update Liferay Record
AlfrescoComments alfrescoComments = AlfrescoCommentsLocalServiceUtil.getByMessageId(messageId);
int temp = 500;
if(commentType!=null)
{
	alfrescoComments.setCommentType(commentType);
}
if(trackingStatus!=null)
{
	alfrescoComments.setTrackingStatus(trackingStatus);
}
AlfrescoCommentsLocalServiceUtil.updateAlfrescoComments(alfrescoComments);

// Endeca Record Update.
StringBuffer xmlData = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?><record><pCommentID>"+ alfrescoComments.getMessageId() +"</pCommentID>");
if(commentType!=null)
	xmlData.append("<pCommentType>"+ commentType +"</pCommentType>");
if(trackingStatus!=null)
	xmlData.append("<pCommentTrackingStatus>" + trackingStatus + "</pCommentTrackingStatus>");
xmlData.append("<pAlfrescoID>workspace://SpacesStore/"+alfrescoComments.getAlfrescoUUID()+"</pAlfrescoID></record>");
EndecaPost post = new EndecaPost();
temp = post.postXML(xmlData.toString(), "/ws/addComments");
%>
<test>
<%=temp%>
</test>