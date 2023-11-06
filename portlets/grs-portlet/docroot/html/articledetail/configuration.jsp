<%@include file="/html/init.jsp"%>
<portlet:actionURL name="editPreferences" var="setPreferencesURL" />
<portlet:renderURL var="cancelURL" portletMode="view"/>

<aui:form action="${setPreferencesURL }" method="post">
	<aui:input name="prefArticleId" label="Enter Article ID:" value="${articleId}" />
	<aui:input name="prefWebcontentId" label="Enter Comment Policy Article ID:" value="${webcontentId}" />
	<aui:input type="checkbox" name="preftVisibility" label="Show Comments?" checked="${visibility}" helpMessage="If true, enter number of comments below." />
	<aui:input name="prefLoadMoreComment" label="Enter Number of Comments:" value="${loadMoreComment}" />
	<aui:button-row>
		<aui:button type="submit" value="Save" />
		<aui:button value="Cancel" href="${cancelURL }" />
	</aui:button-row>
</aui:form>