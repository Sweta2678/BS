<%@include file="/html/userprefs/init.jsp" %>

<script type="text/javascript">
var createAccessDialog ;
	function gotoMerlin()
	{	
		window.location = '<%=themeDisplay.getPortalURL()%>'+'/web/merlin/home';
	}
	$(document).ready(function(){
		 
		 createAccessDialog = jQuery( "#yourviewModal" ).dialog({
			autoOpen: false,
			width: 560,
			resizable:false,
			modal: true,
			close: function() {
				if (selectedBrandName == null || selectedBrandName == '' || selectedBrandName == 'null' || typeof selectedBrandName == 'undefined') {
					window.location.reload();
				}
			}
		});
	
	});
	function changeBrand(){
		$.ajax({
		  	url :viewAccessModal,
		  	type: "POST",
		  	dataType: "text",
		    success: function(data) {
		    	if (data != null && data != '' && typeof data != 'undefined') {
		    		$('#yourviewModal').html(data);
		    		createAccessDialog.dialog( "open" );
		    	}
		    },
			error: function(error) {
	 			window.location.assign("/web/brand-standards/hotel/home");
	 		}
		 });
	}
</script>

<div id="noaccessModal" title="No Access">
	<div class="modal-body">
	  	<div class="row-fluid">
			<div class="span12">
				<c:choose>
  					<c:when test="${isBrandNotActive eq true}">
  						<p>${notActiveBrandMsg}</p>
  					</c:when>
 				 	<c:otherwise>
 				 		<p>${returnToMerlinMsg}</p>
 				 	</c:otherwise>
				</c:choose>
	    		
	  		</div>
	  	</div>
	</div>
	<div class="modal-footer">
	<a onclick="javascript:changeBrand();"  class="btn  changebtn pull-left">
			<i class="icon-cog"></i> ${change} 
	</a>
		<a class="btn btn-primary pull-right" 
		onclick="javascript:gotoMerlin();">${returnToMerlin}</a>
	</div>
</div>


