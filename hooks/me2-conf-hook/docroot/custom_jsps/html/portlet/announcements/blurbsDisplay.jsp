
<%
	String path = PropsUtil.get("ihg.amer.blurbs.page");
	String seeAllBlurbsURL = themeDisplay.getPathFriendlyURLPublic()
			+ themeDisplay.getScopeGroup().getFriendlyURL() + path;
	String timeStamp = new SimpleDateFormat("h:mm a").format(Calendar
			.getInstance().getTime());
%>
<%
	if (AnnouncementsEntryResults.size() == 0) {
%>
No Entries Were Found

<%
	}
%>
<div class="chat-details">
	<div class="leftpanel">
		<!-- 		<label class="chat_details_label">What's happening now...</label> -->
		<div class="row video_Box">
			<label class="main_Titles articleHeading">What's Happening Now...</label>
		</div>
		
		<div class="chat_container">

			<%
				for (int i = 0; i < AnnouncementsEntryResults.size(); i++) {
					AnnouncementsEntry entry = AnnouncementsEntryResults.get(i);
					if (i < 5) {
			%>
			<!--content box started-->
			<%
				if (i % 2 == 0) {
			%>
			<div class="chat_wrapper">
				<div class="left_chat fLeft">
					<div class="left_chat_img"></div>
					<%=entry.getContent()%>
				</div>
				<span class="chat_post_time_left"><%=announcementDateFormat(entry.getDisplayDate())%></span>
				<div style="clear: both; height: 0px;">&nbsp;</div>
			</div>
			<%
				} else {
			%>
			<div class="chat_wrapper">
				<span class="chat_post_time_right"><%=announcementDateFormat(entry.getDisplayDate())%></span>
				<div class="right_chat fRight">
					<div class="right_chat_img"></div>
					<%=entry.getContent()%>
				</div>
				<div style="clear: both; height: 0px;">&nbsp;</div>
			</div>
			<%
				}
			%>
			<div style="clear: both; height: 0px;">&nbsp;</div>
			<%
				}
			%>
			<!--content box ended-->

			<%
				}
			%>
			<div style="clear: both; height: 0px;">&nbsp;</div>
		</div>

		<%
			if (AnnouncementsEntryResults.size() > 1) {
		%>
		<p>
		
			<% if (themeDisplay.getScopeGroupName().equalsIgnoreCase("GRS Change Network")) { %>
				<a class="read-more fRight " href="<%=seeAllBlurbsURL%>"> View Archives</a>
			<% } else { %>
				<a class="read-more fRight " href="<%=seeAllBlurbsURL%>"> Read More</a>				
			<% } %>

		</p>
		<div class="clear "></div>
		<%
			}
		%>

	</div>
	<div style="clear: both; height: 0px;">&nbsp;</div>
</div>

