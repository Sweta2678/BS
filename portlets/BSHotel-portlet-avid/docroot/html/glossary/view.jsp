<%@include file="/html/init.jsp" %>
<portlet:renderURL var="changeCharacter"/>
<div class="row">
  <div class="span12">
    <h3 class="noBottomMargin">Glossary</h3>
  </div>
</div>
<div class="row">
  <div class="span12">
    <p>Welcome to the glossary. Please select a letter to view glossary terms and descriptions</p>
  </div>
</div>
<form id="glossaryForm" method="post">
<div class="row">
  <div class="pagination pagination-centered pagination-small">
	<ul>
	<c:choose>
		<c:when test="${not empty glossaries}">
    		<li <c:if test='${activeChar eq "ALL"}'>class="active"</c:if>><a class="enableLink" style="cursor: pointer;">ALL</a></li>
    	</c:when>
    	<c:otherwise>
				<li class="disabled"><a>ALL</a></li>
		</c:otherwise>
    </c:choose>
    <c:forEach items="${staticChars}" var="staticChar">
    	<c:choose>
    		<c:when test="${fn:contains(enableChars, staticChar)}">
    			<c:choose>
    				<c:when test="${staticChar eq activeChar}"><li class="active"><a class="enableLink" style="cursor: pointer;">${staticChar}</a></li></c:when>
    				<c:otherwise><li class="disabled"><a class="enableLink" style="cursor: pointer;">${staticChar}</a></li></c:otherwise>
    			</c:choose>
    		</c:when>
    		<c:otherwise>
	   			<li class="disabled"><a>${staticChar}</a></li>
	   		</c:otherwise>
    	</c:choose>
    </c:forEach>
    </ul>
  </div>
</div>
</form>
<div class="row">
  <div class="span12 tableTdPadding">
	  <c:forEach items="${glossaries}" var="glossary" varStatus="i">
		<c:choose>
			 <c:when test="${i.index % 2 eq 0}">
				<table width="100%">
			</c:when>
			<c:otherwise>
				<table width="100%" class="table_gray_bg">
			 </c:otherwise>
		</c:choose>
		  		<tr>
		          <td class="term">${glossary.glossaryTermText}</td>
		          <td class="def">${glossary.glossaryTermDesc}</td>
		        </tr>
		        <c:if test="${not empty xGlossaries}">
		        	<tr>
			          <td class="tterm">${xGlossaries[glossary.glossaryId].glossaryTermText}</td>
			          <td class="tdef">${xGlossaries[glossary.glossaryId].glossaryTermDesc}</td>
			        </tr>
		        </c:if>
	  		</table>
	  </c:forEach>
  </div>
</div>
<script type="text/javascript">
	jQuery(".enableLink").click(function(){
		var appendChar = jQuery(this).html();
		var url = "<%=changeCharacter%>&visibleChar="+appendChar;
		jQuery("#glossaryForm").attr("action", url);
		jQuery("#glossaryForm").submit();
	});
</script>