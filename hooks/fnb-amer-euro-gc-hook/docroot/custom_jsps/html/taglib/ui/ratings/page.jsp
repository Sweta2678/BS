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
String randomNamespace = PortalUtil.generateRandomKey(request, "taglib_ui_ratings_page") + StringPool.UNDERLINE;

String className = (String)request.getAttribute("liferay-ui:ratings:className");
long classPK = GetterUtil.getLong((String)request.getAttribute("liferay-ui:ratings:classPK"));
int numberOfStars = GetterUtil.getInteger((String)request.getAttribute("liferay-ui:ratings:numberOfStars"));
RatingsEntry ratingsEntry = (RatingsEntry)request.getAttribute("liferay-ui:ratings:ratingsEntry");
RatingsStats ratingsStats = (RatingsStats)request.getAttribute("liferay-ui:ratings:ratingsStats");
boolean setRatingsEntry = GetterUtil.getBoolean((String)request.getAttribute("liferay-ui:ratings:setRatingsEntry"));
boolean setRatingsStats = GetterUtil.getBoolean((String)request.getAttribute("liferay-ui:ratings:setRatingsStats"));
String type = GetterUtil.getString((String)request.getAttribute("liferay-ui:ratings:type"));
String url = (String)request.getAttribute("liferay-ui:ratings:url");

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

<script>
	isCustomFnbHookCall = true;
</script>

	<div class="taglib-ratings <%= type %>" id="<%= randomNamespace %>ratingContainer">
		<c:choose>
			<c:when test='<%= type.equals("stars") %>'>
				<c:choose>
					<c:when test="<%= themeDisplay.isSignedIn() && !TrashUtil.isInTrash(className, classPK) %>">
						<div class="liferay-rating-vote" id="<%= randomNamespace %>ratingStar">
							<div id="<%= randomNamespace %>ratingStarContent">
								<div class="rating-label"><liferay-ui:message key="your-rating" /></div>

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

				<div class="liferay-rating-score" id="<%= randomNamespace %>ratingScore">
					<div id="<%= randomNamespace %>ratingScoreContent">
						<div class="rating-label">
							<liferay-ui:message key="average" />

							(<%= ratingsStats.getTotalEntries() %> <liferay-ui:message key='<%= (ratingsStats.getTotalEntries() == 1) ? "vote" : "votes" %>' />)
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
			</c:when>
			<c:when test='<%= type.equals("thumbs") %>'>
						<div class="thumbrating liferay-rating-vote" id="<%= randomNamespace %>ratingThumb">
							<div class="helper-clearfix rating-content thumbrating-content" id="<%= randomNamespace %>ratingThumbContent">
								<liferay-util:whitespace-remover>
									<div class="rating-label">
										<c:choose>
											<c:when test="<%= (ratingsStats.getTotalScore() == 0) %>">
												0
											</c:when>
											<c:otherwise>
												<%-- <%= (ratingsStats.getAverageScore() > 0) ? "+" : StringPool.BLANK %><%= (int)ratingsStats.getTotalScore() %> --%>
												<%= (int)(ratingsStats.getAverageScore() * ratingsStats.getTotalScore()) %>
											</c:otherwise>
										</c:choose>

										<%-- <%= StringPool.SPACE %>(<%= ratingsStats.getTotalEntries() %> <liferay-ui:message key='<%= (ratingsStats.getTotalEntries() == 1) ? "vote" : "votes" %>' />) --%>
									</div>

								<c:choose>
									<c:when test="<%= themeDisplay.isSignedIn() %>">
										<c:choose>
										<c:when test="<%= TrashUtil.isInTrash(className, classPK) %>">
											<span class="rating-element rating-<%= (yourScore > 0) ? "on" : "off" %> rating-thumb-up" title="<liferay-ui:message key="ratings-are-disabled-because-this-entry-is-in-the-recycle-bin" />"></span>

											<span class="rating-element rating-<%= (yourScore < 0) ? "on" : "off" %> rating-thumb-down" title="<liferay-ui:message key="ratings-are-disabled-because-this-entry-is-in-the-recycle-bin" />"  style="display: none;"></span>
										</c:when>
										<c:otherwise>
											<a class="rating-element rating-<%= (yourScore > 0) ? "on" : "off" %> rating-thumb-up icon-thumbs-up" href="javascript:;"></a>

											<a class="rating-element rating-<%= (yourScore < 0) ? "on" : "off" %> rating-thumb-down icon-thumbs-down" href="javascript:;"  style="display: none;"></a>

											<div class="rating-input-container">

												<%
												String ratingId = PortalUtil.generateRandomKey(request, "taglib_ui_ratings_page_rating");
												%>

												<label for="<%= ratingId %>">This post liked by <%= (int)(ratingsStats.getAverageScore() * ratingsStats.getTotalScore()) %> people</label>
												
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

	<c:if test="<%= !TrashUtil.isInTrash(className, classPK) %>">
		<aui:script use="liferay-ratings">
			Liferay.Ratings.register(
				{
					averageScore: <%= ratingsStats.getAverageScore() %>,
					className: '<%= HtmlUtil.escapeJS(className) %>',
					classPK: '<%= classPK %>',
					containerId: '<%= randomNamespace %>ratingContainer',
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
	</c:if>
</c:if>
