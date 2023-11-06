  <%@include file="/html/init.jsp"%>
<%@include file="init.jsp"%>

<portlet:resourceURL var="searchById" id="searchById">
	<portlet:param name="modalType" value="searchById"/>
</portlet:resourceURL>
  
<portlet:resourceURL var="addItems" id="addItems">
	<portlet:param name="modalType" value="updateStdList"></portlet:param>
</portlet:resourceURL>
  
<portlet:renderURL var="addStdById">
	<portlet:param name="pageType" value="addStdById"/>
</portlet:renderURL> 

<portlet:resourceURL var="deleteStandardRec" id="deleteStandardRec">
	<portlet:param name="modalType" value="deleteStandard"/>
</portlet:resourceURL>

<portlet:renderURL var="cancelURL">
</portlet:renderURL>



 
  
  	<div class="clearfix"></div> 
    <div class="row-fluid">
      <p>To Add a Standard, Specification or Guideline use the search features below to locate the Standard, Specification or Guideline that should be added.  <strong>Note: Only single CMS IDs are accepted.</strong></p><hr>
    </div>
    <div class="row-fluid">
      <div class="span5">
        <form class="form-inline" style="padding-top: 10px;" onsubmit="javascript:searchByStdId(); return false;">
          <span><strong>Find By ID:</strong></span>
          <input style="margin-bottom: 0px;" class="input-medium" type="text" placeholder="Enter STD ID to find ..." id="searchByVal">
          <a href="#" role="button" class="btn btn-primary"  onclick="javascript:searchByStdId();"><i class="icon-search icon-white"></i> Go</a>
        </form>
        <hr>
      </div>
      <div class="span4">
      	<c:if test='${not empty errorMsg}'>
      		<div class="alert alert-danger">${errorMsg}</div>
      	</c:if>
        <!--<div class="alert alert-danger">Record not found</div>-->
      </div>
    </div>
    <div class="row-fluid" id="searchResults" style="display: none">
      <div class="span12">
        <h4>Search Results:</h4>
      </div>
    </div>
    <div class="row-fluid" id="searchResultContainer">
    	
    </div>
    <div class="row-fluid" id="itemsAdded" style="display: none">
      <div class="span12">
        <h4>Items to be added:</h4>
      </div>
    </div>
    <div class="row-fluid" id="results">
    	<!-- Items which are already added will get displayed here -->
    </div>
    <div class="row-fluid" id="addRecords" style="display: none">
		<button class="btn pull-left" data-dismiss="modal" aria-hidden="true" onclick="javascript:redirectToMyPublication('<%=cancelURL%>');">Cancel</button>
    	<button id="changeSettingsButton" class="btn btn-primary pull-right" data-dismiss="modal" aria-hidden="true" onclick="javascript:redirectToMyPublication('<%=addStdById%>');">Add</button>
    </div>

  <script type="text/javascript">
  	var searchURL = '<%=searchById%>';
  	var addItems = '<%=addItems%>';
  	var deleteStandardURL = '<%=deleteStandardRec%>';
  	function searchByStdId () {
  		var stdId = $('#searchByVal').val();
  		jQuery.blockUI({ message: '<h3><img src="/BSBridge-theme/images/busy.gif" /> </h3>' });
  		$.ajax({
 		     type:'POST',
 			 url:searchURL,
 		     data: {"standardId":stdId},
 		     success: function (data) {
 		            $('#searchResultContainer').html(data);
 		            $('#searchResults').css('display','block');
 		           jQuery.unblockUI();
 		    }
  		     ,
            error: function (jqXHR) {
                jQuery.unblockUI();
                jQuery.msgBox({
                    title: "Error!",
                    content: "Failed submit request! Failure status:" + jqXHR.statusText + " status code:" + jqXHR.status ,
                    type: "error",
                    success: function (result) {
                        ;
                    }
                });
            }
 		});
  	}
  	
  	function redirectToMyPublication (pageURL) {
  		window.location.href = pageURL;
  	}
  	
  	$("#searchByVal").bind('paste', function () {
	    var element = this;
	    setTimeout(function () {
	        var newVal = jQuery(element).val().replace(/[^0-9]+/g, '').trim();
	        newVal = newVal.replace(/\s{2,}/g, ' ').trim();
	        $(element).val(newVal);
	    }, 200);
	});
	 

   $("#searchByVal").keydown(function(event) {
	   /*Allow: space-> event.keyCode == 32 || Allow: escape, backspace, delete, tab,*/ 
       if ( event.keyCode == 27 || event.keyCode == 46 || event.keyCode == 8 || event.keyCode == 9 || 
            /*     enter,                        home, end, left, right                  Ctrl */
            event.keyCode == 13 || (event.keyCode >= 35 && event.keyCode <= 40) || event.ctrlKey )
       {
           return;
       }
       else 
       {
           /* Ensure that it is a number and stop the keypress */
           if (event.shiftKey || (event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 96 || event.keyCode > 105 )) 
           {
               event.preventDefault();
           }   
       }
   });
  </script>
