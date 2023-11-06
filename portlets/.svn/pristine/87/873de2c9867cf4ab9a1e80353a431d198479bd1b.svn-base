<%@include file="/html/init.jsp"%>
 

<c:choose>
<c:when test="${seTemplateId > 0}">
	<portlet:resourceURL var="stdIdValidation" id="stdIdValidation">
	    <portlet:param name="requestType" value="stdIdValidation" />
	</portlet:resourceURL>
	<portlet:resourceURL var="reloadDuplicateList" id="reloadDuplicateList">
	    <portlet:param name="requestType" value="reloadDuplicateList" />
	</portlet:resourceURL>

	
	<portlet:resourceURL var="duplicateStandard" id="duplicateStandard">
	    <portlet:param name="requestType" value="duplicateStandard" />
	</portlet:resourceURL>
	<div class="row">
			<div class="span12">
				<div class="row">
					<div class="span9"><h3 class="progress-title">Manage Duplicates</h3></div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<form id="<portlet:namespace/>searchForm" name="<portlet:namespace/>searchForm"  method="POST" class="form-inline" onSubmit="return false;" >
					<span><strong>Strandard, Specification or Guideline ID:</strong></span>
					<input style="margin-bottom: 0px;" class="input-medium" type="text" id="<portlet:namespace/>findId" name="<portlet:namespace/>findId" placeholder="Enter STD ID to find ..." >
					<a href="javascript:searchByStdId();" role="button" class="btn btn-primary" ><i class="icon-search icon-white"></i> Search by ID</a>
				</form>
				<hr>
			</div>
		</div>
		<div class="row">
			<span><strong>Duplicate</strong></span>
			<form  id="<portlet:namespace/>duplicateForm" name="<portlet:namespace/>duplicateForm" class="form-inline" method="POST" >
				<input   name="<portlet:namespace/>gemPublishId"  value="${gemPublishId}" type="hidden">
				<span><strong>STD ID </strong></span>
				<input  class="input-small" name="<portlet:namespace/>duplicateStdId" id="<portlet:namespace/>duplicateStdId" type="text">
				<span><strong> No of Times </strong></span>
				<input  class="input-small"  name="<portlet:namespace/>noOfTimes" id="<portlet:namespace/>noOfTimes" type="text">
				<a href="javascript:void(0);" role="button" class="btn btn-primary"  onclick="javascript:submitForm();"> Duplicate</a>
			</form>
			<hr>
		</div>
	<div class="clear"></div>
	<div id="duplicate-list-div" class="gem-grid-panel">
	    <%@include file="/html/GEM/manageDuplicates/duplicates-list.jsp"%>
	</div>
	  <script type="text/javascript">
	  function searchByStdId(){
		  var searchIds = jQuery.trim($('#<portlet:namespace/>findId').val()); 
		  setTimeout(function(){ 
		   reloadDuplicateListing(searchIds);
		  }, 2000);
	  }
	  $(function() {
		  $("#<portlet:namespace/>findId").keydown(function(event) {
		        // Allow: escape, backspace, delete, tab, 
		        if ( event.keyCode == 27 || event.keyCode == 46 || event.keyCode == 8 || event.keyCode == 9 || event.keyCode == 32 || event.keyCode == 13 || (event.keyCode >= 35 && event.keyCode <= 40) || event.ctrlKey )
		        {
		            return;
		        }
		        else 
		        {
		        	if (event.shiftKey || (event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 96 || event.keyCode > 105 )) 
		            {
		                event.preventDefault();
		            }   
		        }
		  });
		  $("#<portlet:namespace/>duplicateStdId").keydown(function(event) {
		        // Allow: escape, backspace, delete, tab, 
		        if ( event.keyCode == 27 || event.keyCode == 46 || event.keyCode == 8 || event.keyCode == 9  || event.keyCode == 13 || (event.keyCode >= 35 && event.keyCode <= 40) || event.ctrlKey )
		        {
		            return;
		        }
		        else 
		        {
		        	if (event.shiftKey || (event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 96 || event.keyCode > 105 )) 
		            {
		                event.preventDefault();
		            }   
		        }
		  });
		  $("#<portlet:namespace/>noOfTimes").keydown(function(event) {
		        // Allow: escape, backspace, delete, tab, 
		        if ( event.keyCode == 27 || event.keyCode == 46 || event.keyCode == 8 || event.keyCode == 9  || event.keyCode == 13 || (event.keyCode >= 35 && event.keyCode <= 40) || event.ctrlKey )
		        {
		            return;
		        }
		        else 
		        {
		        	if (event.shiftKey || (event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 96 || event.keyCode > 105 )) 
		            {
		                event.preventDefault();
		            }   
		        }
		  });
	  $("#<portlet:namespace/>findId").bind('paste', function () {
		    var element = this;
		        var newVal = $(element).val().replace(/[^0-9 ]+/g, '').trim();
		        newVal = newVal.replace(/\s{2,}/g, ' ').trim();
		        $(element).val(newVal);
		});
	 
	  $("#<portlet:namespace/>duplicateStdId").bind('paste', function () {
		    var element = this;
		        var newVal = $(element).val().replace(/[^0-9 ]+/g, '').trim();
		        newVal = newVal.replace(/\s{2,}/g, ' ').trim();
		        $(element).val(newVal);
		});
	 
	  $("#<portlet:namespace/>noOfTimes").bind('paste', function () {
		    var element = this;
		        var newVal = $(element).val().replace(/[^0-9 ]+/g, '').trim();
		        newVal = newVal.replace(/\s{2,}/g, ' ').trim();
		        $(element).val(newVal);
		});
	  });
    	function submitForm(){
    	var numbers = /^[0-9]+$/; 
    	var stdId = jQuery.trim($('#<portlet:namespace/>duplicateStdId').val());
    	var noOfTimes = jQuery.trim($('#<portlet:namespace/>noOfTimes').val());
    	if(typeof stdId == 'undefined' || stdId == null || stdId == '' || stdId == 'null' || stdId==0||stdId=='0') {
    		jQuery.msgBox("Please enter Standard ID.");
   		 }else if(typeof noOfTimes == 'undefined' || noOfTimes == null || noOfTimes == '' || noOfTimes == 'null' || noOfTimes == 0 || noOfTimes == '0'){
   			 jQuery.msgBox("Please enter No of Times value.");
   		 }else if(!stdId.match(numbers)||!noOfTimes.match(numbers)){
   			jQuery.msgBox("Please input numeric characters only");
   		 }else if(stdId !='' && noOfTimes != '' ){
   			
   			 $.ajax({
				  	url: '<%=stdIdValidation%>',
				  	data: {stdId: stdId},
					type: "POST",
				  	dataType: "text",
				  	async: false,
				    success: function(data) {
				    	
				    	if (data != null && data != '' && typeof data != 'undefined') {
				    		var parsedData = JSON.parse(data);
				    		 var stdIdExist =  parsedData.stdIdExist;
					            if(stdIdExist=='true'){
					            	duplicateStandard();
					            	
					            	
					            }else{
					            	
					            	jQuery.msgBox("Standard ID is not exist in Measurement");
					            }
				  	
				    	} 
				    }
				});
   		 }
    		
    		
    	}
    	function duplicateStandard(){
    		jQuery.blockUI({ message: '<h3><img src="/BSBridge-theme/images/busy.gif" /> Please wait...</h3>' });
    		setTimeout(function(){ 
    		 $.ajax({
				  	url: '<%=duplicateStandard%>',
				  	data:  $("#<portlet:namespace/>duplicateForm").serialize(),
					type: "POST",
				  	dataType: "text",
				  	async: false,
				    success: function(data) {
				    	jQuery.unblockUI();
				    	if (data != null && data != '' && typeof data != 'undefined') {
				    		
				    		if(data == 'Success'){
								jQuery.msgBox({
		                         	title: "Success!",
		                            content: "Duplicate standard added successfully." ,
		                            type: "info",
		                            buttons: [{ value: "OK" }],
		                            success: function (result) {
		                            	reloadDuplicateListing('');
		                            	$('#<portlet:namespace/>duplicateStdId').val('');
		                            	$('#<portlet:namespace/>noOfTimes').val('');
		                            	$('#<portlet:namespace/>findId').val('');
										return;
		                           	}
								});
							} else {
								
								jQuery.msgBox({
									title: "Errors!",
		                            content: "Duplicate STD can not be deleted." ,
		                            type: "info",
		                            success: function (result) {
		                       			return;
		                        	}
								});
							}
				  			
				    	} 
				    	
				    }
				});
    		}, 2000);	  
    	}
    	function reloadDuplicateListing(stdIds){
    		var div = jQuery('#duplicate-list-div');
    		
    		 $.ajax({
				  	url: '<%=reloadDuplicateList%>',
				  	data: {stdIds: stdIds},
					type: "POST",
				  	dataType: "text",
				    success: function(data) {
				    	if (data != null && data != '' && typeof data != 'undefined') {
				    		div.html(data);
				    		//jQuery.unblockUI();
				    	} 
				    }
				});
    		
    	}
    	function loadProgressBar () {
    		jQuery.blockUI({ message: '<h3><img src="/BSBridge-theme/images/busy.gif" /> Please wait...</h3>' });
    	}
    </script>
	
</c:when>
<c:when test="${not activeGemPublish}">
	Please create new measurement publication.
</c:when>
<c:otherwise>
	Please upload SE Template for this region!
</c:otherwise>
</c:choose>