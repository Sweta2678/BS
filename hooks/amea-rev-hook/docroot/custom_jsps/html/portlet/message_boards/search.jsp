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

<%@ include file="/html/portlet/message_boards/init.jsp" %>
<div class="search-page-div">
<%
String redirect = ParamUtil.getString(request, "redirect");

long breadcrumbsCategoryId = ParamUtil.getLong(request, "breadcrumbsCategoryId");
long breadcrumbsMessageId = ParamUtil.getLong(request, "breadcrumbsMessageId");

long searchCategoryId = ParamUtil.getLong(request, "searchCategoryId");

long[] categoryIdsArray = null;

List categoryIds = new ArrayList();

categoryIds.add(new Long(searchCategoryId));

MBCategoryServiceUtil.getSubcategoryIds(categoryIds, scopeGroupId, searchCategoryId);

categoryIdsArray = StringUtil.split(StringUtil.merge(categoryIds), 0L);

long threadId = ParamUtil.getLong(request, "threadId");
String keywords = ParamUtil.getString(request, "keywords");
%>

<liferay-portlet:renderURL varImpl="searchURL">
	<portlet:param name="struts_action" value="/message_boards/search" />
</liferay-portlet:renderURL>


<div class="bgWhite-inner">
<h1>Share</h1>
</div>
<aui:form action="<%= searchURL %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="breadcrumbsCategoryId" type="hidden" value="<%= breadcrumbsCategoryId %>" />
	<aui:input name="breadcrumbsMessageId" type="hidden" value="<%= breadcrumbsMessageId %>" />
	<aui:input name="searchCategoryId" type="hidden" value="<%= searchCategoryId %>" />
	<aui:input name="threadId" type="hidden" value="<%= threadId %>" />

	<liferay-ui:header
		backURL="<%= redirect %>"
		title="search"
	/>

	<div class="form-search">
		<liferay-ui:input-search autoFocus="<%= (windowState.equals(WindowState.MAXIMIZED) && !themeDisplay.isFacebook()) %>" placeholder='<%= LanguageUtil.get(locale, "keywords") %>' title='<%= LanguageUtil.get(locale, "search-messages") %>' />
	</div>

	<%
	PortletURL portletURL = renderResponse.createRenderURL();

	portletURL.setParameter("struts_action", "/message_boards/search");
	portletURL.setParameter("redirect", redirect);
	portletURL.setParameter("breadcrumbsCategoryId", String.valueOf(breadcrumbsCategoryId));
	portletURL.setParameter("breadcrumbsMessageId", String.valueOf(breadcrumbsMessageId));
	portletURL.setParameter("searchCategoryId", String.valueOf(searchCategoryId));
	portletURL.setParameter("threadId", String.valueOf(threadId));
	portletURL.setParameter("keywords", keywords);
	%>

	<liferay-ui:search-container
		emptyResultsMessage='<%= LanguageUtil.format(pageContext, "no-messages-were-found-that-matched-the-keywords-x", "<strong>" + HtmlUtil.escape(keywords) + "</strong>") %>'
		iteratorURL="<%= portletURL %>"
	>

		<%
		Hits hits = null;
		%>

		<liferay-ui:search-container-results>

			<%
			Indexer indexer = IndexerRegistryUtil.getIndexer(MBMessage.class);

			SearchContext searchContext = SearchContextFactory.getInstance(request);

			searchContext.setAttribute("paginationType", "more");
			searchContext.setCategoryIds(categoryIdsArray);
			searchContext.setEnd(searchContainer.getEnd());
			searchContext.setIncludeAttachments(true);
			searchContext.setKeywords(keywords);

			QueryConfig queryConfig = new QueryConfig();

			queryConfig.setHighlightEnabled(true);

			searchContext.setQueryConfig(queryConfig);

			searchContext.setStart(searchContainer.getStart());

			hits = indexer.search(searchContext);

			searchContainer.setTotal(hits.getLength());

			PortletURL hitURL = renderResponse.createRenderURL();

			results = SearchResultUtil.getSearchResults(hits, locale, hitURL);

			searchContainer.setResults(results);
			%>

		</liferay-ui:search-container-results>

		<liferay-ui:search-container-row
			className="com.liferay.portal.kernel.search.SearchResult"
			modelVar="searchResult"
		>

			<%
			MBMessage message = MBMessageLocalServiceUtil.getMessage(searchResult.getClassPK());

			Summary summary = searchResult.getSummary();
			%>

			<portlet:renderURL var="rowURL">
				<portlet:param name="struts_action" value="/message_boards/view_message" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="messageId" value="<%= String.valueOf(message.getMessageId()) %>" />
			</portlet:renderURL>

			<liferay-ui:app-view-search-entry
				containerIcon="../common/conversation"
				containerName="<%= MBUtil.getAbsolutePath(renderRequest, message.getCategoryId()) %>"
				containerType='<%= LanguageUtil.get(locale, "category[message-board]") %>'
				cssClass='<%= MathUtil.isEven(index) ? "search" : "search alt" %>'
				description="<%= (summary != null) ? HtmlUtil.escape(summary.getContent()) : StringPool.BLANK %>"
				fileEntryTuples="<%= searchResult.getFileEntryTuples() %>"
				queryTerms="<%= hits.getQueryTerms() %>"
				title="<%= (summary != null) ? HtmlUtil.escape(summary.getTitle()) : HtmlUtil.escape(message.getSubject()) %>"
				url="<%= rowURL %>"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" type="more" />
	</liferay-ui:search-container>

</aui:form>

<%
if (breadcrumbsCategoryId > 0) {
	MBUtil.addPortletBreadcrumbEntries(breadcrumbsCategoryId, request, renderResponse);
}

PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "search") + ": " + keywords, currentURL);
%>


</div>