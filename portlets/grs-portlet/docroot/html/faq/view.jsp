<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@include file="/html/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%
String articalId = StringPool.BLANK;
String groupId = StringPool.BLANK;
String version = StringPool.BLANK;
%>
<c:if test="${not empty articleList}">
	<div class="backLinkWrap"></div>
	<div class="glossaryWrap">
		<div class="faq-contents">
			<div class="faq-title"><h1>Frequently Asked Questions</h1></div>
			<c:if test="${not empty prefArticleId}">
				<div class="viewAllFAQs">
					<liferay-ui:journal-article 
						articleId="${prefArticleId}" 
						groupId="<%= themeDisplay.getScopeGroupId() %>">
					</liferay-ui:journal-article>
					<%
						articalId = (String)request.getAttribute("prefArticleId");
						groupId = String.valueOf(themeDisplay.getScopeGroupId());
					%>
					<%@include file="/html/common/edit_web_content.jsp"%>
				</div>
			</c:if>
		</div>
		<div class="faq-wrap">
			<c:forEach var="article" items="${articleList}" varStatus="counter">
				<%
					ArticleInfoBean articalInfo = ((ArticleInfoBean) pageContext.getAttribute("article"));
							JournalArticle journalArticle = articalInfo.getArtical();
							groupId = String.valueOf(journalArticle.getGroupId());
							articalId = String.valueOf(journalArticle.getArticleId());
							version = String.valueOf(journalArticle.getVersion());
				%>
				<div class="faq-container">
					<div class="faq-container-left">
						<c:choose>
							<c:when	test="${(empty articleId && counter.count == 1) || (not empty articleId && articleId == article.articleId) }">
								<a href="#" class="faq-arrow1 active"></a>
							</c:when>
							<c:otherwise>
								<a href="#" class="faq-arrow1"></a>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="faq-container-right">
						<h3>
							<c:out value="${article.question}" />
						</h3>

						<c:choose>
							<c:when	test="${(empty articleId && counter.count == 1) || (not empty articleId && articleId == article.articleId) }">
								<div class="faq-edit">
									<p>
										<c:out value="${article.answer}" />
									</p>
									<%@include file="/html/common/edit_web_content.jsp"%>
								</div>
							</c:when>
							<c:otherwise>
								<div class="faq-edit" style="display: none">
									<p>
										<c:out value="${article.answer}" />
									</p>
									<%@include file="/html/common/edit_web_content.jsp"%>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</c:if>

<script type="text/javascript">
	var show;
	$(".faq-container-left a").click(
			function(show) {
				$(".faq-container-right .faq-edit").not($(this).parents('.faq-container').find(".faq-container-right .faq-edit")).css('display', 'none');
				$(".faq-container-left a").not($(this)).removeClass('active');
				$(this).toggleClass("active").parents('.faq-container').find(".faq-container-right .faq-edit").toggle();
			});
</script>