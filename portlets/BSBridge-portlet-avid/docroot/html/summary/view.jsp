<%@include file="/html/init.jsp"%>

<portlet:resourceURL id='regionRefreshURL' var="regionRefreshURL">
    <portlet:param name="requestType" value="RegionRefreshURL" />
</portlet:resourceURL>
<portlet:actionURL name='resetPublication' var="resetPublicationURL" />

<portlet:resourceURL var="createReportURL" id='createReport'>
    <portlet:param name="requestType" value="createReport"></portlet:param>
</portlet:resourceURL>

<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/msgBoxLight.css" />
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.msgBox.js"></script>

<style type="text/css">
	/* Please keep this css here as we are overriding below css class only for summary portlet. */	
	div.msgBoxContent { height: 120px; }
</style>

<script type="text/javascript">
function jumpToProgress()
{
    window.location.href = "/web/brand-standards/bridge/progress";
}

var createReportURL = '${createReportURL}';
</script>

<c:if test="${'GLBL' == regionCode}">
    <script>
        jumpToProgress(); 
    </script>
</c:if>

<div id="summary">
	<div class="row">
		<div class="span12">
			<div class="row">
				<div class="span7"><h3 class="progress-title">${selectedBrand} Publication</h3></div>
                <c:if test="${activePublish}">
    				<c:choose>
    					<c:when test="${publicationOverDue}">
    						<div class="span4 pull-right alert alert-error">PUBLICATION OVERDUE</div>
    					</c:when>
    					<c:otherwise>
    						<div class="span4 pull-right alert alert-info">${durationLeft}&nbsp;${duration} left until publication</div>
    					</c:otherwise>
    				</c:choose>
                </c:if>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="span12">
			<p>
	            <c:choose>
	                <c:when test="${activePublish}">
	                    For <u id="brandLabel">${selectedBrand}</u>, the following is a summary of your progress towards the ${bridgePublishDate} publication:
	                </c:when>
	                <c:otherwise>
	                    Please create new publication.
	                </c:otherwise>
	            </c:choose>
			</p>
		</div>
	</div>
    <c:if test="${activePublish}">
    	<div class="row">
    		<div id="region" class="summary-region"> </div>
    	</div>
    	<div class="row">
    		<div class="span12">
    			<div class="pull-right">
    				<a data-toggle="modal" role="button" class="btn btn-danger" href="javascript:resetPublication()">Reset Publication</a>
    				<button class="btn btn-primary" id="summary-report">Reports</button>
    			</div>
    		</div>
    	</div>
    </c:if>
</div>

<div id="createReportDialog" title="Create Report" style="display:none">
	<form id="createReportForm" name="createReportForm" method="post" >
	    <div class="modal-body">
	        <div id="reportLst">
              <c:choose>
               <c:when test="${'AMEA' == regionCode}">
                 <span><input type='radio' name='reports' value='132' publishId='${activePublishId}' checked /> Region Current Publication Status</span>
                 <br>
                 <span><input type='radio' name='reports' value='128' publishId='${arhivePublishId}' /> Region Post Publication Summary</span>
                 <br>
                 <span><input type='radio' name='reports' value='146' publishId='${activePublishId}' /> Title change report</span>
               </c:when>
               <c:when test="${'AMER' == regionCode}">
                 <span><input type='radio' name='reports' value='133' publishId='${activePublishId}' checked /> Region Current Publication Status</span>
                 <br>
                 <span><input type='radio' name='reports' value='129' publishId='${arhivePublishId}' /> Region Post Publication Summary</span>
                 <br>
                 <span><input type='radio' name='reports' value='146' publishId='${activePublishId}' /> Title change report</span>
               </c:when>
               <c:when test="${'EURO' == regionCode}">
                 <span><input type='radio' name='reports' value='134' publishId='${activePublishId}' checked /> Region Current Publication Status</span>
                 <br>
                 <span><input type='radio' name='reports' value='130' publishId='${arhivePublishId}' /> Region Post Publication Summary</span>
                 <br>
                 <span><input type='radio' name='reports' value='146' publishId='${activePublishId}' /> Title change report</span>
               </c:when>
               <c:when test="${'GC' == regionCode}">
                 <span><input type='radio' name='reports' value='135' publishId='${activePublishId}' checked /> Region Current Publication Status</span>
                 <br>
                 <span><input type='radio' name='reports' value='131' publishId='${arhivePublishId}' /> Region Post Publication Summary</span>
                 <br>
                 <span><input type='radio' name='reports' value='146' publishId='${activePublishId}' /> Title change report</span>
               </c:when>
              </c:choose>
	        </div>
	        <h4>Report Title <input type="text" id="reportTitle" name="reportTitle"/> </h4> 
	      </div>
	    <div class="modal-footer">
	        <div class="pull-left"><button type="button" class="btn reportCancel">Cancel</button></div>
	        <div class="pull-right"><a class="btn btn-primary" href="javascript:createReport()">Run</a></div>
	    </div>
	</form>
</div>

<script type="text/javascript">

	$(function() {
	    $("#createReportDialog").dialog({
	        autoOpen: false,
	        width: 560,
	         modal: true,
	        open: function() {
	            jQuery('.ui-widget-overlay').bind('click', function() {
	                jQuery('#createReportDialog').dialog('close');
	            })
	        }
	    });
	    
	    $(".reportCancel").click(function() {
	        $("#createReportDialog").dialog("close");
	    });
	    
	    $("#summary-report").click(function() {
	        /* $("#createReportDialog").dialog('option', 'title', 'Create Bridge Report'); */
	        $('#reportTitle').val('');
	        
	        /* Populate report here */
	        /*
	        $("#reportLst").empty();
	        $("<span><input type='radio' name='reports' value='120' checked />Global Current Publication Status Report</span>").appendTo("#reportLst");
	        $("<br>").appendTo("#reportLst");
	        $("<span><input type='radio' name='reports' value='121' />Global Post Publication Summary Report</span>").appendTo("#reportLst");
	        */
	        $("#createReportDialog").dialog("open");
	    });
	});

	function loadProgressBar () {
		jQuery.blockUI({ message: '<h3><img src="/BSBridge-theme/images/busy.gif" /> Please wait...</h3>' });
	}
	
	$(document).ready(function() {
		loadProgressBar();
		var activePublish = '${activePublish}';
		if(activePublish) {
			var regionRefreshURL = '${regionRefreshURL}';
			$.ajax({
			  	url :regionRefreshURL,
			  	type: "POST",
			  	dataType: "text"
			}).done(function(data) {
		    	if (data != null && data != '' && typeof data != 'undefined') {
		    		$('#region').html(data);
		    	}
				/* Un load block UI */
				jQuery.unblockUI();
			}).fail( function(jqXHR) {
				/* Un load block UI */
	            jQuery.unblockUI();
	        });
		}
	});
	
	function refreshPage() {
	    window.location.href = "/web/brand-standards/bridge/summary";
	}

	function resetPublication(){
		jQuery.msgBox({
		    title: "Are You Sure",
		    content: "<span class=\"alert alert-danger\">Are you sure you want to reset this publication? Resetting it will cause the whole of your current publication to be deleted and you will need to start again.</span>",
		    type: "confirm",
		    buttons: [{ value: "Yes" }, { value: "No" }],
		    success: function (importConfirmation) {
		        if (importConfirmation == "Yes") {
		        	var resetPublicationURL = '${resetPublicationURL}';
		        	loadProgressBar();
		            $.ajax({
		                url :resetPublicationURL,
		                type: "POST",
		                dataType: "text"
		            }).done(function(data) {
		                /* Un load block UI */
		                jQuery.unblockUI();
		                refreshPage();
		            }).fail( function(jqXHR, textStatus) {
		                /* Un load block UI */
		                jQuery.unblockUI();
		                jQuery.msgBox("Error occurr: " + textStatus);
	                    console.log(jqXHR);
		            });

		        } else if(importConfirmation == "No" || importConfirmation == "Cancel")
				{
					return;
				}
		    }
		});
	}
	
	function createReport(reportId) {
	    var reportTitle = jQuery("#reportTitle").val();
	    var reportId = jQuery("input[name='reports']:checked", "#createReportForm").val();
	    var publishId = jQuery("input[name='reports']:checked").attr("publishId");
	    var postData = {reportId:reportId,reportTitle:reportTitle,reportPublishId:publishId};
	    loadProgressBar();
	    
	    jQuery.ajax({
	        type: "POST",
	        url: createReportURL,
	        data: postData
	    }).done( function(data) {
	        jQuery.unblockUI();
	        jQuery.msgBox({
	            title: "Success!",
	            content: "An email with a link to your Report will be sent to you once the Report has been generated.", 
	            type: "info",
	            buttons: [{ value: "OK" }],
	            success: function (result) {
	                $("#createReportDialog").dialog("close");
	            }
	        });
	    }).fail( function(jqXHR) {
	        jQuery.unblockUI();
	        jQuery.msgBox({
	            title: "Error!",
	            content: "Failed submit request! Failure status:" + jqXHR.statusText + " status code:" + jqXHR.status ,
	            type: "error",
	            success: function (result) {
	                ;
	            }
	        });
	    });
	};

</script>