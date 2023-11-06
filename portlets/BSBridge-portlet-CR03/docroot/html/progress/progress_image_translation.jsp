<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@include file="/html/init.jsp"%>
<portlet:resourceURL id='imageTranslationProgressRefreshURL' var="imageTranslationProgressRefreshURL">
    <portlet:param name="requestType" value="ImageTranslationProgress"></portlet:param>
    <portlet:param name="tabIndx" value="${tabIndx}"></portlet:param>
</portlet:resourceURL>
<div align="center" class="span6">
    <table class="table table-bordered">
        <thead>
            <tr>
                <th colspan="3">
                    Mandatory Images Progress&nbsp;<i id="imageTranslationProgressRefresh${tabIndx}" class="icon-refresh pull-right"></i>
                </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="langOpt" items="${activeSecondLanguages}">
                <%
                    Map<String, String> selectedBrdgRgnLangs = new HashMap<String, String>();
                    Map<String, Long> imageTranslationCounts = new HashMap<String, Long>();
                    String checked = "";
                    boolean selected = false;
                    long count = -1;
                    if(request.getAttribute("selectedBrdgRgnLangs") != null){
                    	selectedBrdgRgnLangs = (Map<String, String>)request.getAttribute("selectedBrdgRgnLangs");
                    }
                    if(request.getAttribute("imageTranslationCounts") != null){
                    	imageTranslationCounts = (Map<String, Long>)request.getAttribute("imageTranslationCounts");
                    }
                    Map.Entry<String, String> langOpt = (Map.Entry<String, String>)pageContext.getAttribute("langOpt");
                    if(selectedBrdgRgnLangs != null && selectedBrdgRgnLangs.get(langOpt.getKey()) != null) {
                        checked = "checked=\"checked\"";
                        selected = true;
                        if(imageTranslationCounts != null && imageTranslationCounts.get(langOpt.getKey()) != null) {
                            count = imageTranslationCounts.get(langOpt.getKey());
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
									<a class="rightClickDisabled" href="javascript:showViewDetails('${langOpt.key}', 'ImageTranslationView')">
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
    $("#imageTranslationProgressRefresh${tabIndx}").click(function() {
        var imageTranslationProgressRefreshURL = '${imageTranslationProgressRefreshURL}';
        /* load block UI */
        loadProgressBar();
        $.ajax({
            url :imageTranslationProgressRefreshURL,
            type: "POST",
            dataType: "text"
        }).done(function(data) {
            if (data != null && data != '' && typeof data != 'undefined') {
                $('#imagesProgress${tabIndx}').html(data);
            }
            /* Un load block UI */
            jQuery.unblockUI();
        }).fail( function(jqXHR) {
            /* Un load block UI */
            jQuery.unblockUI();
        });
    });
    
    function submitTranslationProgressFM(localeCode) {
        var viewURL = "/web/brand-standards<%=themeDisplay.getLayout().getFriendlyURL()%>?requestType=TranslationView&localeCode="+localeCode+"&tabIndx=${tabIndx}";
        window.location = viewURL;
    }
</script>
