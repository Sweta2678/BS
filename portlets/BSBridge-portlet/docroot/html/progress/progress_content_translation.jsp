<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@include file="/html/init.jsp"%>
<portlet:resourceURL id='contentTranslationProgressRefreshURL' var="contentTranslationProgressRefreshURL">
	<portlet:param name="requestType" value="ContentTranslationProgress"></portlet:param>
	<portlet:param name="tabIndx" value="${tabIndx}"></portlet:param>
</portlet:resourceURL>
<div align="center" class="span6">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th colspan="3">
					Content Translation Progress&nbsp;<i id="contentTranslationProgressRefresh${tabIndx}" class="icon-refresh pull-right"></i>
				</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="langOpt" items="${activeSecondLanguages}">
				<%
					Map<String, String> selectedBrdgRgnLangs = new HashMap<String, String>();
					Map<String, Long> contentTranslationCount = new HashMap<String, Long>();
					String checked = "";
					boolean selected = false;
					long count = -1;
					if(request.getAttribute("selectedBrdgRgnLangs") != null){
						selectedBrdgRgnLangs = (Map<String, String>)request.getAttribute("selectedBrdgRgnLangs");
					}
					if(request.getAttribute("contentTranslationCount") != null){
						contentTranslationCount = (Map<String, Long>)request.getAttribute("contentTranslationCount");
					}
					Map.Entry<String, String> langOpt = (Map.Entry<String, String>)pageContext.getAttribute("langOpt");
					if(selectedBrdgRgnLangs != null && selectedBrdgRgnLangs.get(langOpt.getKey()) != null) {
						checked = "checked=\"checked\"";
						selected = true;
						if(contentTranslationCount != null && contentTranslationCount.get(langOpt.getKey()) != null) {
						    count = contentTranslationCount.get(langOpt.getKey());
						}
					}
				%>
				<c:if test="<%=selected%>">
	                <tr>
	                    <c:choose>
	                        <c:when test="<%=(count > 0)%>">
		                        <c:choose>
			                        <c:when test="${not empty translationExecOverrideChecked}">
				                        <td class="cen" width="10%"><span class="badge badge-warning"><%=count%></span> </td>
				                    </c:when>
				                    <c:otherwise>
		                        		<td class="cen" width="10%"><span class="badge badge-important"><%=count%></span> </td>
		                        	</c:otherwise>
		                        </c:choose>
		                    </c:when>
		                    <c:otherwise>
		                        <td class="cen" width="10%"><span class="badge badge-success">0</span></td>
		                    </c:otherwise>
	                    </c:choose>
						<td>${langOpt.value}</td>
						<c:choose>
							<c:when test="<%=(count > 0)%>">
								<td class="cen" width="20%">
									<a class="rightClickDisabled" href="javascript:showViewDetails('${langOpt.key}', 'ContentTranslationView')">
										<span class="label label-info">View Details</span>
									</a>
								</td>
							</c:when>
	                        <c:otherwise>
	                            <td class="cen" width="20%"></td>
	                        </c:otherwise>
	                    </c:choose>
	                </tr>
                </c:if>
			</c:forEach>
		</tbody>
	</table>
</div>

<script type="text/javascript">
	$("#contentTranslationProgressRefresh${tabIndx}").click(function() {
		var contentTranslationProgressRefreshURL = '${contentTranslationProgressRefreshURL}';
		/* load block UI */
		loadProgressBar();
		$.ajax({
		  	url :contentTranslationProgressRefreshURL,
		  	type: "POST",
		  	dataType: "text"
		}).done(function(data) {
	    	if (data != null && data != '' && typeof data != 'undefined') {
	    		$('#contentTranslationProgress${tabIndx}').html(data);
	    	}
			/* Un load block UI */
			unLoadProgressBar(); //jQuery.unblockUI();
		}).fail( function(jqXHR) {
			/* Un load block UI */
            unLoadProgressBar(); //jQuery.unblockUI();
		});
	});
	
	/* function updateLanguageSelection(localeCode){
		var translationProgressRefreshURL = '${translationProgressRefreshURL}';
		var elementChecked = $('#'+localeCode).is(':checked');
		//load block UI
		loadProgressBar();
		$.ajax({
		  	url :translationProgressRefreshURL,
		  	type: "POST",
		  	data: {localeCode:localeCode,elementChecked:elementChecked}
		}).done(function(data) {
	    	if (data != null && data != '' && typeof data != 'undefined') {
	    		$('#translationProgress${tabIndx}').html(data);
	    	}
			//Un load block UI
			jQuery.unblockUI();
		}).fail( function(jqXHR) {
			//Un load block UI
            jQuery.unblockUI();
		});
	} */
	
	function submitTranslationProgressFM(localeCode) {
		var viewURL = "/web/brand-standards<%=themeDisplay.getLayout().getFriendlyURL()%>?requestType=TranslationView&localeCode="+localeCode+"&tabIndx=${tabIndx}";
		window.location = viewURL;
	}
</script>
