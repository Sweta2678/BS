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

<%@ include file="/html/portlet/journal_content_search/init.ihg-iwos-hook.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Object[] objArray = (Object[])row.getObject();

String[] queryTerms = (String[])objArray[0];
Document doc = (Document)objArray[1];
Summary summary = (Summary)objArray[2];
String articleType = (String)objArray[3];

String content = StringUtil.highlight(summary.getContent(), queryTerms);

long articleGroupId = GetterUtil.getLong(doc.get(Field.GROUP_ID));
String articleId = doc.get("articleId");

String templateId = doc.get("ddmTemplateKey");
String title = GetterUtil.getString(doc.get(Field.TITLE));
String urlLocale = locale.toString().split("_")[0];
if(null!=urlLocale&&!urlLocale.equalsIgnoreCase("en"))
	urlLocale = "/"+urlLocale+"/web/way-of-sales";
else
	urlLocale = "/web/way-of-sales";

List hitLayoutIds = JournalContentSearchLocalServiceUtil.getLayoutIds(layout.getGroupId(), layout.isPrivateLayout(), articleId);

String link = "";

%>

<c:choose>
	<c:when test="<%= !hitLayoutIds.isEmpty() %>">

		<%
		for (int i = 0; i < hitLayoutIds.size(); i++) {
			Long hitLayoutId = (Long)hitLayoutIds.get(i);

			Layout hitLayout = null;

			try {
				hitLayout = LayoutLocalServiceUtil.getLayout(layout.getGroupId(), layout.isPrivateLayout(), hitLayoutId.longValue());
			}
			catch (Exception e) {
				if (_log.isWarnEnabled()) {
					_log.warn("Journal content search is stale and contains layout {" + layout.getGroupId() + ", " + layout.isPrivateLayout() + ", " + hitLayoutId.longValue() + "}");
				}

				continue;
			}

			String hitLayoutURL = PortalUtil.getLayoutFullURL(hitLayout, themeDisplay);
			
			link = hitLayoutURL;
		}
		%>
	</c:when>
	<c:otherwise>
		<%
		if (Validator.isNull(targetPortletId)) {
			targetPortletId = PortletKeys.JOURNAL_CONTENT;
		}

		
		String articleURL ="http://"+request.getServerName()+urlLocale;
		PortletURL webContentPortletURL;
		if(null!=templateId&&templateId.equalsIgnoreCase("RESOURCE_ARTICLE_TEMPLATE")) 
		{
			articleURL = articleURL+"/article?webContentID=" + articleId + "&fullview=1";
			
			link = articleURL.toString();
		}
		else if(null!=templateId&&templateId.equalsIgnoreCase("LANDINGPAGEPOWERUPS"))
		{
			if (title.equalsIgnoreCase("Build The Right Team_PowerUps"))
			{
				articleURL = articleURL+"/team";
			} else if (title.equalsIgnoreCase("Develop The Right Opportunities_PowerUps"))
			{
				articleURL = articleURL+"/develop";
			} else if (title.equalsIgnoreCase("Measure And Learn_PowerUps"))
			{
				articleURL = articleURL+ "/measure";
			} else if (title.equalsIgnoreCase("Set The Right Sales Goals_Power ups"))
			{
				articleURL = articleURL+ "/goals";
			} else if (title.equalsIgnoreCase("Win The Right Business_PowerUps"))
			{
				articleURL = articleURL+ "/win";
			}
			
			link = articleURL.toString();
		}
		else
		{ 
			webContentPortletURL = PortletURLFactoryUtil.create(request, targetPortletId, plid, PortletRequest.RENDER_PHASE);
	
			webContentPortletURL.setParameter("struts_action", "/journal_content/view");
			webContentPortletURL.setParameter("groupId", String.valueOf(articleGroupId));
			webContentPortletURL.setParameter("articleId", articleId);
			
			link = webContentPortletURL.toString();
		}
		%>
	</c:otherwise>
</c:choose>

<div class="searchResults <%=articleType%>">
	<a class="titleLink" href="<%=link%>"><%=row.getParameter("title")%></a><br>
	<p class="search-result-desc"><%-- < % = content % > --%></p>
</div>

<%!
private static Log _log = LogFactoryUtil.getLog("portal-web.docroot.html.portlet.journal_content_search.article_content_jsp");
%>