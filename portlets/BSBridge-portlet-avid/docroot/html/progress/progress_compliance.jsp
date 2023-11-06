<%@include file="/html/init.jsp"%>
<portlet:resourceURL id='complianceProgressRefreshURL' var="complianceProgressRefreshURL">
    <portlet:param name="requestType" value="ComplianceProgress"></portlet:param>
    <portlet:param name="tabIndx" value="${tabIndx}"></portlet:param>
</portlet:resourceURL>

<div align="center" class="span6">
    <table class="table table-bordered">
        <thead>
            <tr>
                <th colspan="3">
                    Compliance Progress&nbsp;<i id="complianceProgressRefresh${tabIndx}" class="icon-refresh pull-right"></i>
                </th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <c:choose>
                    <c:when test="${noOfExpiredIds gt 0}">
                        <td class="cen"><span class="badge badge-important">${noOfExpiredIds}</span> </td>
                    </c:when>
                    <c:otherwise>
                        <td class="cen"><span class="badge badge-success">0</span> </td>
                    </c:otherwise>
                </c:choose>
                <td>Expired date before publication.</td>
                <c:choose>
                    <c:when test="${noOfExpiredIds gt 0}">
                        <td class="cen" width="20%">
                        	<a class="rightClickDisabled" href="javascript:showViewDetails('', 'ExpiredView')">
                        		<span class="label label-info">View Details</span>
                        	</a>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td class="cen" width="20%"></td>
                    </c:otherwise>
                </c:choose>
            </tr>
            <tr>
                <c:choose>
                    <c:when test="${noOfCompliantIds gt 0}">
                        <td class="cen"><span class="badge badge-important">${noOfCompliantIds}</span> </td>
                    </c:when>
                    <c:otherwise>
                        <td class="cen"><span class="badge badge-success">0</span> </td>
                    </c:otherwise>
                </c:choose>
                <td>Compliance date before publication.</td>
                <c:choose>
                    <c:when test="${noOfCompliantIds gt 0}">
                        <td class="cen" width="20%">
                        	<a class="rightClickDisabled" href="javascript:showViewDetails('', 'ComplianceView')">
                        		<span class="label label-info">View Details</span>
                        	</a>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td class="cen" width="20%"></td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </tbody>
    </table>
</div>
<script type="text/javascript">
    $("#complianceProgressRefresh${tabIndx}").click(function() {
        var complianceProgressRefreshURL = '${complianceProgressRefreshURL}';
        /* load block UI */
        loadProgressBar();
        $.ajax({
            url :complianceProgressRefreshURL,
            type: "POST",
            dataType: "text"
        }).done(function(data) {
            if (data != null && data != '' && typeof data != 'undefined') {
                $('#complianceProgress${tabIndx}').html(data);
            }
            /* Un load block UI */
            jQuery.unblockUI();
        }).fail( function(jqXHR) {
            /* Un load block UI */
            jQuery.unblockUI();
        });
    });
    
    function submitOverallProgressFM(viewType) {
        var viewURL = "/web/brand-standards<%=themeDisplay.getLayout().getFriendlyURL()%>?requestType="+viewType+"&tabIndx=${tabIndx}";
        window.location = viewURL;
    }
</script>