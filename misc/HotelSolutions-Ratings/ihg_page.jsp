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

<%@ include file="/html/taglib/ui/ratings/init.jsp" %>

<%
String randomNamespace = "ihg_rating" + StringPool.UNDERLINE;

String className = (String)request.getAttribute("ihg-ui:ratings:className");
long classPK = GetterUtil.getLong((String)request.getAttribute("ihg-ui:ratings:classPK"));
int numberOfStars = GetterUtil.getInteger((String)request.getAttribute("ihg-ui:ratings:numberOfStars"));
RatingsEntry ratingsEntry = (RatingsEntry)request.getAttribute("ihg-ui:ratings:ratingsEntry");
RatingsStats ratingsStats = (RatingsStats)request.getAttribute("ihg-ui:ratings:ratingsStats");
boolean setRatingsEntry = GetterUtil.getBoolean((String)request.getAttribute("ihg-ui:ratings:setRatingsEntry"));
boolean setRatingsStats = GetterUtil.getBoolean((String)request.getAttribute("ihg-ui:ratings:setRatingsStats"));
String type = GetterUtil.getString((String)request.getAttribute("ihg-ui:ratings:type"));
String ratingType = GetterUtil.getString((String)request.getAttribute("ihg-ui:ratings:ratingType"));
String url = (String)request.getAttribute("ihg-ui:ratings:url");

if (numberOfStars < 1) {
	numberOfStars = 1;
}

if (!setRatingsEntry) {
	ratingsEntry = RatingsEntryLocalServiceUtil.fetchEntry(themeDisplay.getUserId(), className, classPK);
}

if (!setRatingsStats) {
	ratingsStats = RatingsStatsLocalServiceUtil.getStats(className, classPK);
}

if (Validator.isNull(url)) {
	url = themeDisplay.getPathMain() + "/portal/rate_entry";
}

double yourScore = 0.0;

if (ratingsEntry != null) {
	yourScore = ratingsEntry.getScore();
}
%>

<c:if test="<%= !themeDisplay.isFacebook() %>">
	<div class="taglib-ratings <%= type %>" id="<%= randomNamespace %>ratingContainer">
		<c:choose>
			<c:when test='<%= type.equals("stars") %>'>
				
				<div class="liferay-rating-score" id="<%= randomNamespace %>ratingScore">
					<div id="<%= randomNamespace %>ratingScoreContent">
						<div class="rating-label aui-rating-label-element-ihg">
							<c:set var="avgStr"><liferay-ui:message key="average" /></c:set>
							<c:out value="${fn:trim(avgStr)}" />
							<div style="float: right;padding-top:10px; padding-left:5px" class="liferay-rating-score-ihg" >
							(<%= ratingsStats.getTotalEntries() %> <liferay-ui:message key='<%= (ratingsStats.getTotalEntries() == 1) ? "rating" : "ratings" %>' />)
							</div>
						</div>
						
						<liferay-util:whitespace-remover>					

							<%
							for (int i = 1; i <= numberOfStars; i++) {
							%>

								<a class="rating-element <%= (i <= Math.round(ratingsStats.getAverageScore())) ? "icon-star" : "icon-star-empty" %>" href="javascript:;" title="<%= TrashUtil.isInTrash(className, classPK) ? LanguageUtil.get(pageContext, "ratings-are-disabled-because-this-entry-is-in-the-recycle-bin") : ((i == 1) ? LanguageUtil.format(pageContext, "the-average-rating-is-x-stars-out-of-x", new Object[] {ratingsStats.getAverageScore(), numberOfStars}) : StringPool.BLANK) %>"></a>

							<%
							}
							%>

						</liferay-util:whitespace-remover>
					</div>
				</div>
				<div class="clear"></div>
				<c:choose>
					<c:when test="<%= themeDisplay.isSignedIn() %>">
						<div class="liferay-rating-vote" id="<%= randomNamespace %>ratingStar">
							<div id="<%= randomNamespace %>ratingStarContent">
								<div class="rating-label aui-rating-label-element-ihg">
									<c:set var="yourStr"><liferay-ui:message key="your-rating" /></c:set>
									<c:out value="${fn:trim(yourStr)}" />
								<div style="float:right; padding-top:10px; padding-left:0px" class="liferay-rating-score-ihg" >(click to rate)</div>
								</div>
								
								<liferay-util:whitespace-remover>

									<%
									for (int i = 1; i <= numberOfStars; i++) {
										String ratingId = PortalUtil.generateRandomKey(request, "taglib_ui_ratings_page_rating");
									%>

										<a class="rating-element <%= (i <= yourScore) ? "icon-star" : "icon-star-empty" %>" href="javascript:;"></a>

										<div class="rating-input-container">
											<label for="<%= ratingId %>"><liferay-ui:message arguments="<%= new Object[] {i, numberOfStars} %>" key='<%= (yourScore == i) ? "you-have-rated-this-x-stars-out-of-x" : "rate-this-x-stars-out-of-x" %>' /></label>

											<input checked="<%= i == yourScore %>" class="rating-input" id="<%= ratingId %>" name="<portlet:namespace />rating" type="radio" value="<%= i %>">
										</div>

									<%
									}
									%>

								</liferay-util:whitespace-remover>
							</div>
						</div>
					</c:when>
				</c:choose>
			</c:when>
			<c:when test='<%= type.equals("thumbs") %>'>
				<div class="thumbrating liferay-rating-vote" id="<%= randomNamespace %>ratingThumb">
					<div class="helper-clearfix rating-content thumbrating-content" id="<%= randomNamespace %>ratingThumbContent">
						<liferay-util:whitespace-remover>
							<div class="rating-label">
								(<%= ratingsStats.getTotalEntries() %>)
							</div>

							<c:choose>
								<c:when test="<%= themeDisplay.isSignedIn() %>">
									<c:choose>
										<c:when test="<%= TrashUtil.isInTrash(className, classPK) %>">
											<span class="rating-element rating-<%= (yourScore > 0) ? "on" : "off" %> rating-thumb-up" title="<liferay-ui:message key="ratings-are-disabled-because-this-entry-is-in-the-recycle-bin" />"></span>

											<span style="display: none" class="rating-element rating-<%= (yourScore < 0) ? "on" : "off" %> rating-thumb-down" title="<liferay-ui:message key="ratings-are-disabled-because-this-entry-is-in-the-recycle-bin" />"></span><span>I like this</span>
										</c:when>
										<c:otherwise>
											<a class="rating-element rating-<%= (yourScore > 0) ? "on" : "off" %> rating-thumb-up icon-thumbs-up" href="javascript:;"></a>

											<a style="display: none" class="rating-element rating-<%= (yourScore < 0) ? "on" : "off" %> rating-thumb-down icon-thumbs-down" href="javascript:;"></a><span>I like this</span>

											<div class="rating-input-container">

												<%
												String ratingId = PortalUtil.generateRandomKey(request, "taglib_ui_ratings_page_rating");
												%>

												<label for="<%= ratingId %>"><liferay-ui:message key='<%= (yourScore > 0) ? "you-have-rated-this-as-good" : "rate-this-as-good" %>' /></label>

												<input class="rating-input" id="<%= ratingId %>" name="<portlet:namespace />ratingThumb" type="radio" value="up">

												<%
												ratingId = PortalUtil.generateRandomKey(request, "taglib_ui_ratings_page_rating");
												%>

												<label for="<%= ratingId %>"><liferay-ui:message key='<%= (yourScore > 0) ? "you-have-rated-this-as-bad" : "rate-this-as-bad" %>' /></label>

												<input class="rating-input" id="<%= ratingId %>" name="<portlet:namespace />ratingThumb" type="radio" value="down">
											</div>
										</c:otherwise>
									</c:choose>
								</c:when>
							</c:choose>
						</liferay-util:whitespace-remover>
					</div>
				</div>
			</c:when>
		</c:choose>
	</div>

	<aui:script use="liferay-ratings">
		Liferay.Ratings.register(
			{
				averageScore: <%= ratingsStats.getAverageScore() %>,
				className: '<%= HtmlUtil.escapeJS(className) %>',
				classPK: '<%= classPK %>',
				namespace: '<%= randomNamespace %>',
				size: <%= numberOfStars %>,
				totalEntries: <%= ratingsStats.getTotalEntries() %>,
				totalScore: <%= ratingsStats.getTotalScore() %>,
				type: '<%= type %>',
				uri: '<%= url %>',
				yourScore: <%= yourScore %>
			}
		);
	</aui:script>
	<script language="JavaScript">
		var ratingType = '<%= ratingType %>';
		<%
			if(type.equals("stars"))
			{
		%>
			var ihgAverageRating = '<%= ratingsStats.getAverageScore() %>';
		<%
			}
		%>
	</script>
	<!-- // Added for HS : Rating service.  -->
	<style>
		.rating-element {
			background : transparent url('/hs-theme/images/rating_large.jpg') no-repeat scroll 0 0;
			width : 24px;
			height : 24px;
		}
		.icon-star-empty {
			background-position : 0px -25px;
		}
		.icon-star{
			background-position : 0px -48px;
		}
		.taglib-ratings {
			height : auto!important;
		}
	</style>
</c:if>