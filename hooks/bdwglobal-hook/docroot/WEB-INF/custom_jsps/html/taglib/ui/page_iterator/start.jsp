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

<%@ include file="/html/taglib/init.jsp" %>

<%

String formName = namespace + request.getAttribute("liferay-ui:page-iterator:formName");
int cur = GetterUtil.getInteger((String)request.getAttribute("liferay-ui:page-iterator:cur"));
String curParam = (String)request.getAttribute("liferay-ui:page-iterator:curParam");
int delta = GetterUtil.getInteger((String)request.getAttribute("liferay-ui:page-iterator:delta"));
boolean deltaConfigurable = GetterUtil.getBoolean((String)request.getAttribute("liferay-ui:page-iterator:deltaConfigurable"));
String deltaParam = (String)request.getAttribute("liferay-ui:page-iterator:deltaParam");
String id = (String)request.getAttribute("liferay-ui:page-iterator:id");
String jsCall = GetterUtil.getString((String)request.getAttribute("liferay-ui:page-iterator:jsCall"));
int maxPages = GetterUtil.getInteger((String)request.getAttribute("liferay-ui:page-iterator:maxPages"));
String target = (String)request.getAttribute("liferay-ui:page-iterator:target");
int total = GetterUtil.getInteger((String)request.getAttribute("liferay-ui:page-iterator:total"));
String type = (String)request.getAttribute("liferay-ui:page-iterator:type");
String url = (String)request.getAttribute("liferay-ui:page-iterator:url");
String urlAnchor = (String)request.getAttribute("liferay-ui:page-iterator:urlAnchor");
if(themeDisplay.getPortalURL().contains("ihg.com")) {
	url = url.replace("https", "http").replace("/web/", "/");
	urlAnchor = urlAnchor.replace("https", "http").replace("/web/", "/");
	System.out.println("url after changed.."+url);
}
int pages = GetterUtil.getInteger((String)request.getAttribute("liferay-ui:page-iterator:pages"));

if (Validator.isNull(id)) {
	id = PortalUtil.generateRandomKey(request, "taglib-page-iterator");
}

int start = (cur - 1) * delta;
int end = cur * delta;

if (end > total) {
	end = total;
}

int resultRowsSize = delta;

if (total < delta) {
	resultRowsSize = total;
}
else {
	resultRowsSize = total - ((cur - 1) * delta);

	if (resultRowsSize > delta) {
		resultRowsSize = delta;
	}
}

String deltaURL = HttpUtil.removeParameter(url, namespace + deltaParam);

NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
%>

<c:if test='<%= type.equals("approximate") || type.equals("more") || type.equals("regular") || (type.equals("article") && (total > resultRowsSize)) %>'>
	<div class="taglib-page-iterator" id="<%= namespace + id %>">
</c:if>

<c:if test='<%= type.equals("article") && (total > resultRowsSize) %>'>
	<div class="search-results">
		<liferay-ui:message key="pages" />:

		<%
		int pagesIteratorMax = maxPages;
		int pagesIteratorBegin = 1;
		int pagesIteratorEnd = pages;

		if (pages > pagesIteratorMax) {
			pagesIteratorBegin = cur - pagesIteratorMax;
			pagesIteratorEnd = cur + pagesIteratorMax;

			if (pagesIteratorBegin < 1) {
				pagesIteratorBegin = 1;
			}

			if (pagesIteratorEnd > pages) {
				pagesIteratorEnd = pages;
			}
		}

		String content = null;

		if (pagesIteratorEnd < pagesIteratorBegin) {
			content = StringPool.BLANK;
		}
		else {
			StringBundler sb = new StringBundler((pagesIteratorEnd - pagesIteratorBegin + 1) * 6);

			for (int i = pagesIteratorBegin; i <= pagesIteratorEnd; i++) {
				if (i == cur) {
					sb.append("<strong class='journal-article-page-number'>");
					sb.append(i);
					sb.append("</strong>");
				}
				else {
					sb.append("<a class='journal-article-page-number' href='");
					sb.append(_getHREF(formName, namespace + curParam, i, jsCall, url, urlAnchor));
					sb.append("'>");
					sb.append(i);
					sb.append("</a>");
				}

				sb.append("&nbsp;&nbsp;");
			}

			content = sb.toString();
		}
		%>

		<%= content %>
	</div>
</c:if>

<c:if test="<%= (total > delta) || (total > PropsValues.SEARCH_CONTAINER_PAGE_DELTA_VALUES[0]) %>">
	<div class="clearfix lfr-pagination">
		<c:if test='<%= type.equals("regular") %>'>
			<c:if test="<%= PropsValues.SEARCH_CONTAINER_PAGE_DELTA_VALUES.length > 0 %>">
				<div class="lfr-pagination-config">
					<div class="lfr-pagination-page-selector">
						<c:choose>
							<c:when test="<%= themeDisplay.isFacebook() %>">
								<liferay-ui:message key="page" />

								<%= cur %>
							</c:when>
							<c:otherwise>

								<%
								String suffix = LanguageUtil.get(pageContext, "of") + StringPool.SPACE + numberFormat.format(pages);

								if (type.equals("approximate") || type.equals("more")) {
									suffix = StringPool.BLANK;
								}
								%>

								<liferay-ui:icon-menu
									cssClass="current-page-menu"
									direction="down"
									icon=""
									message='<%= LanguageUtil.get(pageContext, "page") + StringPool.SPACE + cur + StringPool.SPACE + suffix %>'
									showWhenSingleIcon="true"
								>

									<%
									int pagesIteratorMax = maxPages;
									int pagesIteratorBegin = 1;
									int pagesIteratorEnd = pages;

									if (pages > pagesIteratorMax) {
										pagesIteratorBegin = cur - pagesIteratorMax;
										pagesIteratorEnd = cur + pagesIteratorMax;

										if (pagesIteratorBegin < 1) {
											pagesIteratorBegin = 1;
										}

										if (pagesIteratorEnd > pages) {
											pagesIteratorEnd = pages;
										}
									}

									for (int i = pagesIteratorBegin; i <= pagesIteratorEnd; i++) {
									%>

										<liferay-ui:icon
											message="<%= String.valueOf(i) %>"
											url='<%= url + namespace + curParam + "=" + i + urlAnchor %>'
										/>

									<%
									}
									%>

								</liferay-ui:icon-menu>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="lfr-pagination-delta-selector">
						<c:choose>
							<c:when test="<%= !deltaConfigurable || themeDisplay.isFacebook() %>">
								&mdash;

								<%= delta %>

								<liferay-ui:message key="items-per-page" />
							</c:when>
							<c:otherwise>
								<liferay-ui:icon-menu
									direction="down"
									icon=""
									message='<%= delta + StringPool.SPACE + LanguageUtil.get(pageContext, "items-per-page") %>'
									showWhenSingleIcon="true"
								>

									<%
									for (int curDelta : PropsValues.SEARCH_CONTAINER_PAGE_DELTA_VALUES) {
										if (curDelta > SearchContainer.MAX_DELTA) {
											continue;
										}
									%>

										<liferay-ui:icon
											message="<%= String.valueOf(curDelta) %>"
											url='<%= deltaURL + "&" + namespace + deltaParam + "=" + curDelta + urlAnchor %>'
										/>

									<%
									}
									%>

								</liferay-ui:icon-menu>
							</c:otherwise>
						</c:choose>
					</div>
				</c:if>
			</div>
		</c:if>

		<c:if test='<%= type.equals("approximate") || type.equals("more") || type.equals("regular") %>'>
			<%@ include file="/html/taglib/ui/page_iterator/showing_x_results.jspf" %>
		</c:if>

		<ul class="pager lfr-pagination-buttons">
			<c:if test='<%= type.equals("approximate") || type.equals("more") || type.equals("regular") %>'>
				<li class="<%= (cur != 1) ? "" : "disabled" %> first">
					<a href="<%= (cur != 1) ? _getHREF(formName, namespace + curParam, 1, jsCall, url, urlAnchor) : "javascript:;" %>" target="<%= target %>">
						&larr; <liferay-ui:message key="first" />
					</a>
				</li>
			</c:if>

			<li class="<%= (cur != 1) ? "" : "disabled" %>">
				<a href="<%= (cur != 1) ? _getHREF(formName, namespace + curParam, cur - 1, jsCall, url, urlAnchor) : "javascript:;" %>" target="<%= target %>">
					<liferay-ui:message key="previous" />
				</a>
			</li>

			<li class="<%= (cur != pages) ? "" : "disabled" %>">
				<a href="<%= (cur != pages) ? _getHREF(formName, namespace + curParam, cur + 1, jsCall, url, urlAnchor) : "javascript:;" %>" target="<%= target %>">
					<c:choose>
						<c:when test='<%= type.equals("approximate") || type.equals("more") %>'>
							<liferay-ui:message key="more" />
						</c:when>
						<c:otherwise>
							<liferay-ui:message key="next" />
						</c:otherwise>
					</c:choose>
				</a>
			</li>

			<c:if test='<%= type.equals("regular") %>'>
				<li class="<%= (cur != pages) ? "" : "disabled" %> last">
					<a href="<%= (cur != pages) ? _getHREF(formName, namespace + curParam, pages, jsCall, url, urlAnchor) : "javascript:;" %>" target="<%= target %>">
						<liferay-ui:message key="last" /> &rarr;
					</a>
				</li>
			</c:if>
		</ul>
	</div>
</c:if>

<c:if test='<%= type.equals("approximate") || type.equals("more") || type.equals("regular") || (type.equals("article") && (total > resultRowsSize)) %>'>
	</div>
</c:if>

<%!
private String _getHREF(String formName, String curParam, int cur, String jsCall, String url, String urlAnchor) throws Exception {
	String href = null;

	if (Validator.isNotNull(url)) {
		href = HtmlUtil.escape(url + curParam + "=" + cur + urlAnchor);
	}
	else {
		href = "javascript:document." + formName + "." + curParam + ".value = '" + cur + "'; " + jsCall;
	}

	return href;
}
%>