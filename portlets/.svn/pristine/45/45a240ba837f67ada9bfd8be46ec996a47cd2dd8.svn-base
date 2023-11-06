<%@page import="com.ihg.brandstandards.db.model.Standards"%>
<%@include file="/html/standards/init.jsp" %>
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/crossReference.css"/>
<%
	String regionCode = ParamUtil.get(request, "regionCode", StringPool.BLANK);
	long stdId = ParamUtil.get(request, "stdId", 0L);
	List<Standards> standards = StandardsLocalServiceUtil.getCrossStandards(stdId);
	List<Standards> xStandardsOthers = StandardsCrossReferenceLocalServiceUtil.getXStandardsOthers(stdId);
%>

<input type="hidden" id="addStdIds" name="addStdIds" />
<input type="hidden" id="deleteStdIds" name="deleteStdIds" />
<input type="hidden" id="updateOrderStdIds" name="updateOrderStdIds" />
<input type="hidden" id="isDragged" name="isDragged" />
<p>  						
	To add a cross-reference, first use the search to locate the Standard, Specification or Guideline that should be cross-referenced.
</p>
<p>						
	Standard, Specification or Guideline ID: <input type="text" name="crs_std_id" id="crs_std_id"> <input type="button" id="Search" value="Search by ID"/><span class="cross_note">Note: Only single CMS IDs are accepted</span>
</p>
<div id="resultSearchDiv" style="display:none;">
	<p class="cross_headers">Search Results</p>
	<div id="results">
	</div>
</div>
<div id="myreferences" style="display:none">
	<p class="cross_headers">My Cross References<span class="cross_note">Note: Drag rows in the table below to re-order</span></p>
	<table id="searchedContentTable" class="cross_order">
		<thead>
			<tr class="cross_order_header">
				<th>ID</th>
				<th>Type</th>
				<th>Standard Text</th>
				<th class="cross_delete_cell">Delete</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</div>
<br>
<div id="otherreferences" style="display:none">
	<p class="cross_headers">Items that cross-references this one</p>
	<table id="otehrReferenceSection" class="cross_order">
		<thead>
			<tr class="cross_order_header">
				<th>ID</th>
				<th>Type</th>
				<th>Standard Text</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</div>
<script type="text/javascript">
var standardArray = new Array();
var addStdIds = new Array();
var deleteStdIds = new Array();
var xRefOtherArray = new Array();
<%
for(Standards std:standards){
%>
	var standard = new Object();
	standard.std = <%= std.getStdId()%>;
	standard.type = '<%= std.getStdTyp()%>';
	standard.title = '<%= std.getStdTyp().equalsIgnoreCase(BrandStandardsUtil.STD_TYPE_GDLN) ? StringEscapeUtils.escapeJavaScript(std.getDescription()) : StringEscapeUtils.escapeJavaScript(std.getTitle())%>';
	standardArray[standardArray.length] = standard;
	var htmlTr = '<tr id="'+standard.std+'" class="crossRefRow"><td>'+standard.std+'</td><td>'+standard.type+'</td><td>'+standard.title+'</td><td><a class="delete_cross_item"><img style="cursor:pointer;" src="/BSTheme-theme/images/delete.png" alt="delete" title="delete" onclick="deleteRecord('+standard.std+')"/></a></td></tr>';
	jQuery('#myreferences').show();
	jQuery('#searchedContentTable tbody').append(htmlTr);
<%
}
%>
<%
for(Standards std:xStandardsOthers){
%>
	var standard = new Object();
	standard.std = <%= std.getStdId()%>;
	standard.type = '<%= std.getStdTyp()%>';
	standard.title = '<%= std.getStdTyp().equalsIgnoreCase(BrandStandardsUtil.STD_TYPE_GDLN) ? StringEscapeUtils.escapeJavaScript(std.getDescription()) : StringEscapeUtils.escapeJavaScript(std.getTitle())%>';
	xRefOtherArray[xRefOtherArray.length] = standard;
	var htmlTr = '<tr id="'+standard.std+'" class="crossRefRow"><td>'+standard.std+'</td><td>'+standard.type+'</td><td>'+standard.title+'</td></tr>';
	jQuery('#otherreferences').show();
	jQuery('#otehrReferenceSection tbody').append(htmlTr);
<%
}
%>
initStdDragNDrop();
jQuery("#Search").click(function(){
	searchAction();
});
</script>