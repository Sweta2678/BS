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

<%@page import="com.liferay.portal.kernel.search.BooleanClauseOccur"%>
<%@page import="com.liferay.portal.kernel.search.BooleanClauseFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.search.BooleanClause"%>
<%@ include file="/html/portlet/journal_content_search/init.ihg-iwos-hook.jsp" %>
<%@ page import="com.ihg.me2.utils.session.MerlinSession,com.liferay.portlet.journal.model.JournalArticleDisplay" %>
<%
String snippet = "";
%>
<c:choose>
	<c:when test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
		<style type="text/css">
			.portlet-journal-content-search .search-results {
				margin-top: 1em;
			}
		</style>

		<%
		String defaultKeywords = LanguageUtil.get(pageContext, "search");// + StringPool.TRIPLE_PERIOD;
		String unicodeDefaultKeywords = UnicodeFormatter.toString(defaultKeywords);

		String keywords = ParamUtil.getString(request, "keywords", defaultKeywords);
		%>

		<portlet:renderURL var="searchURL">
			<portlet:param name="struts_action" value="/journal_content_search/search" />
			<portlet:param name="showListed" value="<%= String.valueOf(showListed) %>" />
			<portlet:param name="targetPortletId" value="<%= targetPortletId %>" />
			<portlet:param name="type" value="<%= type %>" />
		</portlet:renderURL>

		<aui:form action="<%= searchURL %>" method="post" name="fm">

			<%
			PortletURL portletURL = renderResponse.createRenderURL();

			portletURL.setParameter("struts_action", "/journal_content_search/search");
			portletURL.setParameter("keywords", keywords);

			List<String> headerNames = new ArrayList<String>();

			/* headerNames.add("#");
			headerNames.add("language");
			headerNames.add("name");
			headerNames.add("content"); */

			SearchContainer searchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, headerNames, LanguageUtil.format(pageContext, "no-pages-were-found-that-matched-the-keywords-x", "<strong>" + HtmlUtil.escape(keywords) + "</strong>"));

			try {
				
				Map<String, String> merlinSession = MerlinSession.get(user.getScreenName());
				String pdb_role = (String)merlinSession.get("WOS_PDBROLE");
				
				Indexer indexer = IndexerRegistryUtil.getIndexer(JournalArticle.class);

				SearchContext searchContext = SearchContextFactory.getInstance(request);

				searchContext.setAttribute("articleType", type);
				searchContext.setGroupIds(new long[]{layout.getGroupId()});
				searchContext.setKeywords((themeDisplay.getLanguageId().equalsIgnoreCase("zh_CN") || themeDisplay.getLanguageId().equalsIgnoreCase("ja_JP"))?keywords+"*":keywords);
				
				
				//TO DO DDMStructureLocalServiceUtil.getStructure(groupId, classNameId, structureKey);
 				BooleanClause pathwayExcludeClause = BooleanClauseFactoryUtil.create(
						searchContext, "ddmStructureKey", "43622039", BooleanClauseOccur.MUST_NOT.getName());//Prod StructureKey 43622039 // QA 22964514
 				/* BooleanClause pathwayExcludeClause1 = BooleanClauseFactoryUtil.create(
						searchContext, "ddmStructureKey", "learning_pathway_structure", BooleanClauseOccur.MUST_NOT.getName()); */
				searchContext.setBooleanClauses(new BooleanClause[]{pathwayExcludeClause});
				//System.out.println("Query ::: " + pathwayExcludeClause.getQuery().toString()); 
				


				QueryConfig queryConfig = new QueryConfig();

				queryConfig.setHighlightEnabled(true);

				searchContext.setQueryConfig(queryConfig);

				Hits hits = indexer.search(searchContext);
				
				
				//////////////////////
				//This method is custom method in case above solution will not work -- Gaurang
				/* BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
				fullQuery.addRequiredTerm("head", Boolean.TRUE);
				fullQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, JournalArticle.class.getName());
				fullQuery.addRequiredTerm(Field.SCOPE_GROUP_ID, themeDisplay.getScopeGroupId());
				fullQuery.addRequiredTerm(Field.GROUP_ID, themeDisplay.getScopeGroupId());
				
				BooleanQuery searchQuery = BooleanQueryFactoryUtil.create(searchContext);
				String[] _KEYWORDS_FIELDS = { Field.COMMENTS,
					    Field.CONTENT, Field.DESCRIPTION, Field.PROPERTIES, 
						Field.URL, Field.USER_NAME, Field.TITLE , Field.ASSET_TAG_NAMES, Field.ASSET_CATEGORY_TITLES};
				for(int i=0;i<_KEYWORDS_FIELDS.length;i++)
				{
					searchQuery.addTerm(_KEYWORDS_FIELDS[i],keywords);
					if(keywords.split("\\s+").length > 1)
					{
						String exactKeyword="\"" + keywords +"\"";
					    searchQuery.addTerm(_KEYWORDS_FIELDS[i], exactKeyword);
					}
					
				}
				System.out.println("Search Keyword Query ::: " + searchQuery);
				
				BooleanQuery structureIdQuery = BooleanQueryFactoryUtil.create(searchContext);
				structureIdQuery.addExactTerm("ddmStructureKey","22964514");// "RESOURCE"
				fullQuery.add(structureIdQuery, BooleanClauseOccur.MUST_NOT);
				fullQuery.add(searchQuery, BooleanClauseOccur.MUST);
				System.out.println("fullQuery ::: " + fullQuery);
				Hits hits2 = SearchEngineUtil.search(searchContext, fullQuery);
				int total2 = hits2.getLength();
				System.out.println("total 2222 ::: " + total2); */
				//////////////////////
				

				String[] queryTerms = hits.getQueryTerms();

				/* ContentHits contentHits = new ContentHits();

				contentHits.setShowListed(showListed);

				contentHits.recordHits(results, layout.getGroupId(), layout.isPrivateLayout(), searchContainer.getStart(), searchContainer.getEnd()); */
				
				int total = hits.getLength();

				searchContainer.setTotal(total);
				
				int start = searchContainer.getStart();
				int end = searchContainer.getEnd();
				if (end > total) {
					end = total;
				}
				List<Document> docs_results = ListUtil.toList(hits.getDocs());
				List<Document> results = docs_results.subList(start, end);
								
			//	List<Document> results = ListUtil.toList(hits.getDocs());

				List resultRows = searchContainer.getResultRows();
				
				int searchTotal = 0;

				for (int i = 0; i < results.size(); i++) {
					
					try {
						boolean isTargetRole = true;
						
						Document doc = results.get(i);
	
						PortletURL summaryURL = PortletURLUtil.clone(portletURL, renderResponse);

						Summary summary = indexer.getSummary(doc, locale, StringPool.BLANK, summaryURL);

						JournalArticle jArticle = JournalArticleLocalServiceUtil.getLatestArticle(themeDisplay.getScopeGroupId(),doc.get("articleId"));
						String localeContent = jArticle.getContentByLocale(themeDisplay.getLanguageId());
						String contentTitle = "";
						String roles = "";
						String listContent = "";
						String articleType = "";
						
						try 
						{
							com.liferay.portal.kernel.xml.Document document = com.liferay.portal.kernel.xml.SAXReaderUtil.read(localeContent);
							 if(jArticle.getTemplateId().equalsIgnoreCase("RESOURCE_ARTICLE_TEMPLATE")) 
							{
								roles = document.selectSingleNode("/root/dynamic-element[@name='target_roles']/dynamic-content").getStringValue();
								snippet = document.selectSingleNode("/root/dynamic-element[@name='abstract']/dynamic-content").getText();
								contentTitle = document.selectSingleNode("/root/dynamic-element[@name='article_name']/dynamic-content").getText();
								articleType = document.selectSingleNode("/root/dynamic-element[@name='article_type']/dynamic-content").getText();
							}
							else if(jArticle.getTemplateId().equalsIgnoreCase("LANDINGPAGEWITHPERFORMANCE")||
									 jArticle.getTemplateId().equalsIgnoreCase("GETTINGSTARTED")||
									 jArticle.getTemplateId().equalsIgnoreCase("INSIDETRACK")||
									 jArticle.getTemplateId().equalsIgnoreCase("SALESRESOURCES"))
							{
								snippet = document.selectSingleNode("/root/dynamic-element[@name='content']/dynamic-content").getText();
							}
							 else if(jArticle.getTemplateId().equalsIgnoreCase("BUILDINGTHERIGHTTEAM"))
							{
								snippet = document.selectSingleNode("/root/dynamic-element[@name='introtext']/dynamic-content").getText();
								contentTitle = document.selectSingleNode("/root/dynamic-element[@name='introtitle']/dynamic-content").getText();
							}
							else if(jArticle.getTemplateId().equalsIgnoreCase("LANDINGPAGEPOWERUPS"))
							{
								List<com.liferay.portal.kernel.xml.Node> nodeList = document.selectNodes("//dynamic-element[@name='modulecontent']/dynamic-content");
								for (com.liferay.portal.kernel.xml.Node node : nodeList)
								{
									listContent = listContent + node.getText();
								}
							}
							else if(jArticle.getTemplateId().equalsIgnoreCase("FINDITEASY")||
									jArticle.getTemplateId().equalsIgnoreCase("FINDITEASYTEAM"))
							{
								List<com.liferay.portal.kernel.xml.Node> nodeList = document.selectNodes("//dynamic-element[@name='title']/dynamic-content");
								for (com.liferay.portal.kernel.xml.Node node : nodeList)
								{
									listContent = listContent + " " + node.getText();
								}
								snippet = listContent;
							}
							else if(jArticle.getTemplateId().equalsIgnoreCase("SELLING_STORIES_TEMPLATE")||
									jArticle.getTemplateId().equalsIgnoreCase("IDENTIFY_TYPES_TEMPLATE"))
							{
								snippet = document.selectSingleNode("/root/dynamic-element[@name='contentmain']/dynamic-content").getText();
							}
							else if(jArticle.getTemplateId().equalsIgnoreCase("STAGE_TEMPLATE")||
									jArticle.getTemplateId().equalsIgnoreCase("CUSTOMER_PERSONALITY_OVERVIEW_TEMPLATE")||
									jArticle.getTemplateId().equalsIgnoreCase("MAIN_TEMPLATE"))
							{
								snippet = document.selectSingleNode("/root/dynamic-element[@name='content1']/dynamic-content").getText();
								contentTitle = document.selectSingleNode("/root/dynamic-element[@name='contentTitle']/dynamic-content").getText();
							}
							else if(jArticle.getTemplateId().equalsIgnoreCase("TOOL_LIST_TEMPLATE"))
							{
								List<com.liferay.portal.kernel.xml.Node> nodeList = document.selectNodes("//dynamic-element[@name='sectiontitle']/dynamic-content");
								for (com.liferay.portal.kernel.xml.Node node : nodeList)
								{
									listContent = listContent + " " + node.getText();
								}
							}
							else if(jArticle.getTemplateId().equalsIgnoreCase("BRAND_SELLING_STORIES_TEMPLATE")||
									jArticle.getTemplateId().equalsIgnoreCase("WHATSHAPPENING"))
							{
								snippet = StringUtil.shorten(document.selectSingleNode("/root/dynamic-element[@name='content1']/dynamic-content").getText(),200);
							}
							else if(jArticle.getTemplateId().equalsIgnoreCase("FINDOUTMORE"))
							{
								snippet = document.selectSingleNode("/root/dynamic-element[@name='title']/dynamic-content").getText();
							}
							else if(jArticle.getTemplateId().equalsIgnoreCase("GLOSSARY"))
							{
								List<com.liferay.portal.kernel.xml.Node> nodeList = document.selectNodes("//dynamic-element[@name='definition']/dynamic-content");
								for (com.liferay.portal.kernel.xml.Node node : nodeList)
								{
									listContent = listContent + node.getText();
								}
							}
							else if(jArticle.getTemplateId().equalsIgnoreCase("TOPSTORIES"))
							{
								snippet = StringUtil.shorten(document.selectSingleNode("/root/dynamic-element[@name='tab1_article_content']/dynamic-content").getText(),200);
							}
							else if(jArticle.getTitle().equalsIgnoreCase("Privacy_Policy")||jArticle.getTitle().equalsIgnoreCase("Terms_Of_Use"))
							{
								snippet = StringUtil.shorten(localeContent,500);
							}
							else if(jArticle.getTitle().contains("_Steps"))
							{
								snippet = document.selectSingleNode("/root/static-content").getText();
								if(null!=snippet&&!"".equalsIgnoreCase(snippet))
									snippet = StringUtil.shorten(snippet.substring(snippet.indexOf("<p>"),snippet.length()),200);
							}
							else
							{
								 JournalArticleDisplay articleDisplay = JournalArticleLocalServiceUtil.getArticleDisplay(jArticle.getGroupId(), jArticle.getArticleId(), "", themeDisplay.getLanguageId(), themeDisplay);
								 snippet=articleDisplay.getContent(); 
								
							}  
							 if(!"".equalsIgnoreCase(roles)&&!roles.contains(pdb_role))
									isTargetRole = false;
							 if(!"".equalsIgnoreCase(listContent))
								 snippet = StringUtil.shorten(listContent, 200);
							 if(!snippet.contains("..."))
								 snippet = snippet + "...";
						}  
						catch(Exception e)
						{
							_log.error(e.getMessage());
						}
						
						//summary.setContent(snippet);
						
						ResultRow row = new ResultRow(new Object[] {queryTerms, doc, summary, articleType}, i, i);

						// Position

					//	row.addText(searchContainer.getStart() + i + 1 + StringPool.PERIOD);

					//	row.addJSP("/html/portlet/journal_content_search/article_language.jsp");

						// Title

						String title = !"".equalsIgnoreCase(contentTitle)? contentTitle:HtmlUtil.escape(summary.getTitle());

						title = StringUtil.highlight(title, queryTerms);

						//row.addText(title);

						// Content
						row.setParameter("title", title.replace("_", " "));
						row.addJSP("/html/portlet/journal_content_search/article_content.ihg-iwos-hook.jsp");

						// Add result row
						if(isTargetRole){
							resultRows.add(row);
							searchTotal++;
						}
					} catch (Exception e) {
						_log.error(e.getMessage());	
					}
					
				} //for
				//searchContainer.setTotal(searchTotal);
			%>

			<%
			String taglibOnBlur = "if (this.value == '') { this.value = '" + unicodeDefaultKeywords + "'; }";
			String taglibOnFocus = "if (this.value == '" + unicodeDefaultKeywords + "') { this.value = ''; }";
			String iwosKeywords = HtmlUtil.escape(keywords).replaceAll("&amp;","&").replaceAll("&#039;","\'").replaceAll("&#034;","\"");
			%>

			<div class="searchBoxSurround">
				<aui:input autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) %>" cssClass="lfr-search-keywords" inlineField="<%= true %>" label="" name="keywords" onBlur="<%= taglibOnBlur %>" onFocus="<%= taglibOnFocus %>" size="30" title="search-web-content" type="text" value="<%= iwosKeywords %>" />
	
				<aui:input align="absmiddle" alt='<%= LanguageUtil.get(pageContext, "search") %>' border="0" cssClass="lfr-search-button" inlineField="<%= true %>" label="" name="search" src='<%= themeDisplay.getPathThemeImages() + "/common/search.png" %>' title="search" type="image" />
			</div>

			<div class="search-results">
				<liferay-ui:search-speed hits="<%= hits %>" searchContainer="<%= searchContainer %>" />

				<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
			</div>

			<%
			}
			catch (Exception e) {
				_log.error(e.getMessage());
			}
			%>

		</aui:form>
	</c:when>
	<c:otherwise>
		<liferay-ui:journal-content-search
			showListed="<%= showListed %>"
			targetPortletId="<%= targetPortletId %>"
			type="<%= type %>"
		/>
	</c:otherwise>
</c:choose>

<%!
private static Log _log = LogFactoryUtil.getLog("portal-web.docroot.html.portlet.journal_content_search.search_jsp");
%>