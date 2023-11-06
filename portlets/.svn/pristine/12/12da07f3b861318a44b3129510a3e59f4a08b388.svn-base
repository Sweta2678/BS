<%@page import="com.ihg.grs.util.WhatsHappeningUtil"%>
<%@page import="com.liferay.portlet.announcements.model.AnnouncementsEntry"%>
<%@include file="../init.jsp"%>

<c:forEach var="announcement" items="${announcements}" varStatus="loop">
	<%
		AnnouncementsEntry announcement = (AnnouncementsEntry) pageContext.getAttribute("announcement");
	%>
	<c:choose>
		<c:when test="${(oddRow ? loop.count + 1 : loop.count) % 2 == 1 }">
			<div class="rightChat">
				<div class="content">${announcement.content }</div>
				<div class="timeSection">
					<span class="icon"></span> <a><%=WhatsHappeningUtil.getAnnouncementDate(announcement.getDisplayDate())%></a>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="leftChat">
				<div class="timeSection">
					<span class="icon"></span> <a><%=WhatsHappeningUtil.getAnnouncementDate(announcement.getDisplayDate())%></a>
				</div>

				<div class="content">${announcement.content }</div>
			</div>
		</c:otherwise>
	</c:choose>
</c:forEach>