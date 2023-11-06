<%@include file="/html/init.jsp"%>
<portlet:resourceURL id='notificationProgressRefreshURL' var="notificationProgressRefreshURL">
    <portlet:param name="requestType" value="NotificationProgress" />
    <portlet:param name="tabIndx" value="${tabIndx}" />
</portlet:resourceURL>

<div align="center" class="span6">
    <table class="table table-bordered">
        <thead>
            <tr>
                <th colspan="3">
                    Notifications&nbsp;<i id="notificationProgressRefresh${tabIndx}" class="icon-refresh pull-right"></i>
                </th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <c:choose>
                    <c:when test="${noOfNotifications gt 0}">
                        <c:choose>
    						<c:when test="${currentPage eq 'Progress'}">
                        		<td class="cen" width="13%"><span class="badge badge-warning">${noOfNotifications}</span> </td>
                        	</c:when>
    						<c:otherwise>
    							<td class="cen" width="13%"><span class="badge badge-important">${noOfNotifications}</span> </td>
    						</c:otherwise>
    					</c:choose>
                    </c:when>
                    <c:otherwise>
                        <td class="cen" width="13%"><span class="badge badge-success">0</span> </td>
                    </c:otherwise>
                </c:choose>
                <td>Notifications.</td>
                <c:choose>
                    <c:when test="${noOfNotifications gt 0}">
                        <td class="cen" width="20%">
                        	<a class="rightClickDisabled" href="javascript:showViewDetails('', 'NotificationView')">
                        		<span class="label label-info">View Details</span>
                        	</a>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td class="cen" width="20%">
                        	<portlet:resourceURL id='exportNotifications' var="exportNotificationsURL">
								<portlet:param name="requestType" value="ExportPopup" />
								<portlet:param name="reportType" value="NotificationView" />
							</portlet:resourceURL>
                        	<form action="${exportNotificationsURL}" method="post" name="exportNotificationsFM"></form>
                        	<a class="rightClickDisabled label label-info" href="javascript:exportNotifications()"><i class="icon-arrow-down icon-white"></i>Export</a>
                        </td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </tbody>
    </table>
</div>
<script type="text/javascript">
    $("#notificationProgressRefresh${tabIndx}").click(function() {
        var notificationProgressRefreshURL = '${notificationProgressRefreshURL}';
        /* load block UI */
        loadProgressBar();
        $.ajax({
            url :notificationProgressRefreshURL,
            type: "POST",
            dataType: "text"
        }).done(function(data) {
            if (data != null && data != '' && typeof data != 'undefined') {
                $('#notificationProgress${tabIndx}').html(data);
            }
            /* Un load block UI */
            unLoadProgressBar(); //jQuery.unblockUI();
        }).fail( function(jqXHR) {
            /* Un load block UI */
            unLoadProgressBar(); //jQuery.unblockUI();
        });
    });
    
    function submitOverallProgressFM(viewType) {
        var viewURL = "/web/brand-standards<%=themeDisplay.getLayout().getFriendlyURL()%>?requestType="+viewType+"&tabIndx=${tabIndx}";
        window.location = viewURL;
    }
    function exportNotifications() {
		document.exportNotificationsFM.submit();
	}
</script>