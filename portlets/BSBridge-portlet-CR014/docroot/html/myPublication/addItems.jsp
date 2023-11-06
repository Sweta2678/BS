 <%@include file="/html/init.jsp"%>
 <%@include file="init.jsp"%>

<div class="span12 content_scroll" >	
	<table border="0" class="table table-bordered specs table-striped">
	  <thead>
	    <tr><th width="60px">STD ID</th><th width="60px">Type</th><th>Content</th><th width="50px"></th></tr>          
	  </thead>
	  <tbody id="results">
		<c:forEach var="stdItem" items="${addedItems}">
			<c:set var="standardRecord" value="${stdItem.value}"></c:set>
			<tr><td>${standardRecord.stdId}</td>
				<td>${standardRecord.stdType}</td>
				<td>${standardRecord.title}</td>
				<td class="cen"><a href="#" role="button" class="btn btn-mini btn-primary" onclick="javascript:deleteItem('${standardRecord.stdId}', '${standardRecord.stdType}')"> Del</a></td>
			</tr>
        </c:forEach>	    
	  </tbody>
	</table>
</div>

<script type="text/javascript">
	function deleteItem (stdIdVal, stdType) {
		jQuery.blockUI({ message: '<h3><img src="/BSBridge-theme/images/busy.gif" /> </h3>' });
		$.ajax({
		     type:'POST',
			 url:deleteStandardURL,
		     data: {"stdIdVal":stdIdVal, "stdTypeVal":stdType},
		     dataType: "text",
		     success: function (data) {
		            $('#results').html(data);
		            jQuery.unblockUI();
		    },error: function (xhr, ajaxOptions, thrownError) {
				jQuery.unblockUI();
			}
		});
	}
</script>