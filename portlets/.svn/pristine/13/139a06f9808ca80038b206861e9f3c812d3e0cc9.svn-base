<%@include file="/html/init.jsp"%>
<portlet:resourceURL id='overallProgressRefreshURL' var="overallProgressRefreshURL">
	<portlet:param name="requestType" value="OverallProgress"></portlet:param>
	<portlet:param name="tabIndx" value="${tabIndx}"></portlet:param>
</portlet:resourceURL>

<div align="center" class="span6">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th colspan="3">
					Overall Progress&nbsp;<i id="overallProgressRefresh${tabIndx}" class="icon-refresh pull-right"></i>
				</th>
			</tr>
		</thead>
		<tbody>
            <tr>
                <c:choose>
                    <c:when test="${noOfDiscontinuedIds gt 0}">
                        <td class="cen"><span class="badge badge-important">${noOfDiscontinuedIds}</span> </td>
                    </c:when>
                    <c:otherwise>
                        <td class="cen"><span class="badge badge-success">0</span> </td>
                    </c:otherwise>
                </c:choose>
                <td>Discontinued/Insight Required.</td>
                <c:choose>
                    <c:when test="${noOfDiscontinuedIds gt 0}">
                        <td class="cen" width="20%">
                        	<a class="rightClickDisabled" href="javascript:showViewDetails('', 'DiscontinuedView')">
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
                    <c:when test="${noOfUnattrBrandIds gt 0}">
                        <td class="cen"><span class="badge badge-important">${noOfUnattrBrandIds}</span> </td>
                    </c:when>
                    <c:otherwise>
                        <td class="cen"><span class="badge badge-success">0</span> </td>
                    </c:otherwise>
                </c:choose>
                <td>Standards where Brand has been Unattributed.</td>
                <c:choose>
                    <c:when test="${noOfUnattrBrandIds gt 0}">
                        <td class="cen" width="20%">
                        	<a class="rightClickDisabled" href="javascript:showViewDetails('', 'UnattributeBrndView')">
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
                    <c:when test="${noOfUnattrRegionIds gt 0}">
                        <td class="cen"><span class="badge badge-important">${noOfUnattrRegionIds}</span> </td>
                    </c:when>
                    <c:otherwise>
                        <td class="cen"><span class="badge badge-success">0</span> </td>
                    </c:otherwise>
                </c:choose>
                <td>Standards where Region has been Unattributed.</td>
                <c:choose>
                    <c:when test="${noOfUnattrRegionIds gt 0}">
                        <td class="cen" width="20%">
                        	<a class="rightClickDisabled" href="javascript:showViewDetails('', 'UnattributeRgnView')">
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
                    <c:when test="${noOfGlblMustIds gt 0}">
                        <td class="cen"><span class="badge badge-important">${noOfGlblMustIds}</span> </td>
                    </c:when>
                    <c:otherwise>
                        <td class="cen"><span class="badge badge-success">0</span> </td>
                    </c:otherwise>
                </c:choose>
                <td>Global Must Publish IDs missing from publication.</td>
                <c:choose>
                    <c:when test="${noOfGlblMustIds gt 0}">
                        <td class="cen" width="20%">
                        	<a class="rightClickDisabled" href="javascript:showViewDetails('', 'GlobalMustView')">
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
                    <c:when test="${noOfGlblNotInMustIds gt 0}">
                        <td class="cen"><span class="badge badge-important">${noOfGlblNotInMustIds}</span> </td>
                    </c:when>
                    <c:otherwise>
                        <td class="cen"><span class="badge badge-success">0</span> </td>
                    </c:otherwise>
                </c:choose>
                <td>Global IDs not in Global Must Publish.</td>
                <c:choose>
                    <c:when test="${noOfGlblNotInMustIds gt 0}">
                        <td class="cen" width="20%">
                        	<a class="rightClickDisabled" href="javascript:showViewDetails('', 'GlobalNotInMustView')">
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
                    <c:when test="${noOfGlblMustNotIds gt 0}">
                        <td class="cen"><span class="badge badge-important">${noOfGlblMustNotIds}</span> </td>
                    </c:when>
                    <c:otherwise>
                        <td class="cen"><span class="badge badge-success">0</span> </td>
                    </c:otherwise>
                </c:choose>
                <td>Global Must <u>Not</u> Publish IDs contained in publication.</td>
                <c:choose>
                    <c:when test="${noOfGlblMustNotIds gt 0}">
                        <td class="cen" width="20%">
                        	<a class="rightClickDisabled" href="javascript:showViewDetails('', 'GlobalMustNotView')">
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
                    <c:when test="${noOfSelectStateIds gt 0}">
                        <td class="cen"><span class="badge badge-important">${noOfSelectStateIds}</span> </td>
                    </c:when>
                    <c:otherwise>
                        <td class="cen"><span class="badge badge-success">0</span> </td>
                    </c:otherwise>
                </c:choose>
                <td><u>Select States...</u> contained in publication.</td>
                <c:choose>
                    <c:when test="${noOfSelectStateIds gt 0}">
                        <td class="cen" width="20%">
                        	<a class="rightClickDisabled" href="javascript:showViewDetails('', 'SelectStateView')">
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
                    <c:when test="${noOfOverrideStdIds gt 0}">
                        <td class="cen"><span class="badge badge-warning">${noOfOverrideStdIds}</span> </td>
                    </c:when>
                    <c:otherwise>
                        <td class="cen"><span class="badge badge-success">0</span> </td>
                    </c:otherwise>
                </c:choose>
                <td>Overridden Standards.</td>
                <c:choose>
                    <c:when test="${noOfOverrideStdIds gt 0}">
                        <td class="cen" width="20%">
                        	<a class="rightClickDisabled" href="javascript:showViewDetails('', 'OverriddenView')">
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
                    <c:when test="${noOfMissingXrefIds gt 0}">
                        <td class="cen"><span class="badge badge-warning">${noOfMissingXrefIds}</span> </td>
                    </c:when>
                    <c:otherwise>
                        <td class="cen"><span class="badge badge-success">0</span> </td>
                    </c:otherwise>
                </c:choose>
                <td>Missing or invalid cross-references.</td>
                <c:choose>
                    <c:when test="${noOfMissingXrefIds gt 0}">
                        <td class="cen" width="20%">
                        	<a class="rightClickDisabled" href="javascript:showViewDetails('', 'MissingXrefView')">
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
	$("#overallProgressRefresh${tabIndx}").click(function() {
		var overallProgressRefreshURL = '${overallProgressRefreshURL}';
		/* load block UI */
		loadProgressBar();
		$.ajax({
		  	url :overallProgressRefreshURL,
		  	type: "POST",
		  	dataType: "text"
		}).done(function(data) {
	    	if (data != null && data != '' && typeof data != 'undefined') {
	    		$('#overallProgress${tabIndx}').html(data);
	    	}
			/* Un load block UI */
			unLoadProgressBar(); //jQuery.unblockUI();;
		}).fail( function(jqXHR) {
			/* Un load block UI */
            unLoadProgressBar(); //jQuery.unblockUI();;
        });
	});
	
	function submitOverallProgressFM(viewType) {
		var viewURL = "/web/brand-standards<%=themeDisplay.getLayout().getFriendlyURL()%>?requestType="+viewType+"&tabIndx=${tabIndx}";
		window.location = viewURL;
	}
</script>