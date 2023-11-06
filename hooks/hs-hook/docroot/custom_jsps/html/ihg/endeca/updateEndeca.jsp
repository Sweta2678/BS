<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.ihg.me2.hs.endecasearch.EndecaPost"%>
<%@page import="com.ihg.me2.hs.endecasearch.MerlinSearch"%>
<%@page import="com.ihg.me2.hs.logging.MerlinLogger"%>
<%@page import="com.ihg.me2.hs.logging.MerlinLoggerFactory"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%
MerlinLogger mLogger = MerlinLoggerFactory.getMerlinLogger("updateEndeca.jsp");
MerlinSearch.setLogger(mLogger);
String uuid = request.getParameter("uuid");
String totalEntries = request.getParameter("totalEntries");
String averageEntries = request.getParameter("averageScore");

double averageScore = Double.parseDouble(averageEntries.trim());
if(averageScore > 5)
{
	averageEntries = "5";
}
String xmlData = "<record><pAlfrescoUUId>workspace://SpacesStore/" + uuid + "</pAlfrescoUUId>";
xmlData = xmlData + "<pAverageScore>"+ averageEntries +"</pAverageScore>";
xmlData = xmlData + "<pTotalRatingEntries>" + totalEntries + "</pTotalRatingEntries></record>";
EndecaPost post = new EndecaPost();
int temp = post.postXML(xmlData, "/ws/addRatingsUtil");
%>
<test>
<%=temp%>
</test>