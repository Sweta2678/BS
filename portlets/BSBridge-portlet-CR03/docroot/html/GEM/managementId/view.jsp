<%@include file="/html/GEM/managementId/init.jsp" %>

<link type="text/css" rel="stylesheet" href="/BSBridge-theme/css/msgBoxLight.css" />
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.msgBox.js"></script>
<portlet:resourceURL var="editManageIdURL" id="editManageIdURL" />

<style type="text/css">
.aui .alert.alert-success
{
	color : white;
}
</style>
<div class="row">
	<div class="span12">
		<div class="row">
			<div class="span9"><h3 class="progress-title">Management Ids</h3></div>
			<div class="span3"></div>
		</div>
	</div>
</div>
<c:if test="${fn:length(errorMessage) < 1}" >
<form name="ManageIdFM" method="post" action="">
	<table id="manageIdTable" class="table table-bordered">
			<thead>
				<tr class="results_header_bar">
		            <th width="20%">Country</th>
		            <th width="10%">Code</th>
		            <th colspan="${fn:length(subBrands)}" style="text-align: center;"><c:out value="${brandName}" /></th>
		            <th width="5%"><strong>Actions</strong></th>
        		</tr>
		        <tr>
		            <th data-options="field:'country'"></th>
		            <th data-options="field:'country'"></th>
		            <c:forEach items="${subBrands}" var="subBrand">
		            	<th data-options="field:'chain1'" width="20%"><c:out value="${subBrand}"></c:out></th>
		            </c:forEach>
		            <th width="5%"></th>
		        </tr>
    </thead>
    <tbody>
    	<!--  Structure is Map<Country, SubBrand<ManageId>> --> 
    	<c:forEach items="${allCountries}" var="countryMap" varStatus="index">
        <tr>
            <td><span class="wrap_field"><c:out value="${countryMap.value}" /></span></td>
            <td><span class="wrap_field"><c:out value="${countryMap.key}" /></span></td>
            <c:set var="brandMap" value="${countryMap.value}" > </c:set>
            <c:forEach items="${subBrands}" var="subBrand">
            	<td><span class="wrap_field">
            	<c:if test="${managementIds.containsKey(countryMap.key) && managementIds[countryMap.key].containsKey(subBrand)}" >
            		<c:set var="manageid" value="${managementIds[countryMap.key][subBrand]}" > </c:set>
	            	<c:if test="${manageid != null}">
	            		<c:out value="${manageid.value}" />
	            	</c:if>
	            </c:if>
            	</span></td>
            </c:forEach>
			<td style="text-align:center;">
				<a class="edit_link" href="javascript: void(0)" title="Edit Management Id" onclick="editManageIdPopup('${countryMap.key}','${brand}')">
					<i class="icon-edit" id=""></i>
				</a>
			</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</form>
<div id="editManageId_popup" style="display:none;"></div>
<script type="text/javascript">
	var closeLabel = 'Close';
	var editManageIdDialog;
	jQuery(document).ready(function() {
		editManageIdDialog = jQuery("#editManageId_popup").dialog({
			title: 'Management Id',
			closeText: closeLabel,
			autoOpen: false,
			center: true,
			resizable: false,
			width: 575,
			modal: true,
			open: function() {
				jQuery('.editManageIdPopupClose').bind('click', function() {
					editManageIdDialog.dialog('close');
				});
			}
		});
	});

	function editManageIdPopup(countryCode, brandCode) {
		$.ajax({
			url: '${editManageIdURL}',
			type: "POST",
			dataType: "text",
			data: {
				countryCode: countryCode,
				brandCode : brandCode
			},
			success: function(data) {
				if (data != null && data != '' && typeof data != 'undefined') {
					jQuery('#editManageId_popup').html(data);
					editManageIdDialog.dialog("open");
				}
			}
		});
	}
</script>
</c:if>
<c:if test="${errorMessage!=null && fn:length(errorMessage) > 0}" >
<c:out value="${errorMessage}" />
</c:if>
