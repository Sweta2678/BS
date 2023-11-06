<%@page import="com.liferay.portlet.journal.model.JournalArticleDisplay"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@include file="/html/init.jsp"%>

<div class="modal-body">
     <c:if test='${not empty resourcePrimaryKey}'>
    	
    	<%
    		long resourcePrimaryKey = Long.parseLong(""+request.getAttribute("resourcePrimaryKey"));
    		JournalArticle article =  JournalArticleLocalServiceUtil.getLatestArticle(resourcePrimaryKey);
    		String articleContent = JournalArticleLocalServiceUtil.getArticleContent(article, article.getTemplateId(), null, "", themeDisplay);
    	%>
    	<%=articleContent%>
	</c:if>
</div>
  <div class="modal-footer">
    <button class="btn pull-left helpModalCancel">${helpCancel}</button>
    <button class="btn btn-primary pull-right helpModalClose">${helpClose}</button>
  </div>
    <script type="text/javascript">
  $(document).ready(function(){
  $( ".helpModalCancel" ).click(function() {
		$( "#helpModal" ).dialog( "close" );
	});
	$( ".helpModalClose" ).click(function() {
		$( "#helpModal" ).dialog( "close" );
	});
  });
  </script>