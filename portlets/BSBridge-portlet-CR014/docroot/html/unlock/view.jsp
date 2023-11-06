<%@include file="/html/init.jsp"%>
<liferay-portlet:actionURL var="releaseLockedRecordsURL" name="releaseLockedRecords" />
<liferay-portlet:actionURL var="unLockedRecordsURL" name="unLockedRecords" />
<liferay-portlet:actionURL var="lockedRecordsURL" name="lockedRecords" />

<style type="text/css">
	.aui .alert-success {
		color: #ffffff;
	}
</style>
<script type="text/javascript">
	var finalCount = 0;
	$(document).ready(function() {
		$('.rightClickDisabled').bind('contextmenu', function(e){
			return false;
		});
		
		var wordCounts = {};
		$("#lockOrUnlockStdIds").keyup(function() {
			var lockOrUnlockStdIds = jQuery.trim(jQuery('textarea#lockOrUnlockStdIds').val());
			lockOrUnlockStdIds = lockOrUnlockStdIds.split('\n').join(' ');
			lockOrUnlockStdIds = lockOrUnlockStdIds.replace(/[^0-9 ,]+/g, '').trim();
			lockOrUnlockStdIds = lockOrUnlockStdIds.replace(/\s{2,}/g, ' ')
			
		    var matches = lockOrUnlockStdIds.match(/\b/g);
		    wordCounts[this.id] = matches ? matches.length / 2 : 0;
		    finalCount = 0;
		    $.each(wordCounts, function(k, v) {
		        finalCount += v;
		    });
		    $('#display_count').html(finalCount);
		    if(finalCount > 10000){
		    	$("#noOfStandardsMessage").css({"color":"#b94a48"});
			} else {
				$("#noOfStandardsMessage").css({"color":"#333333"});
			}
		}).keyup();
		
		$("#lockOrUnlockStdIds").blur(function() {
			var lockOrUnlockStdIds = jQuery.trim(jQuery('textarea#lockOrUnlockStdIds').val());
			lockOrUnlockStdIds = lockOrUnlockStdIds.split('\n').join(' ');
			lockOrUnlockStdIds = lockOrUnlockStdIds.replace(/[^0-9 ,]+/g, '').trim();
			lockOrUnlockStdIds = lockOrUnlockStdIds.replace(/\s{2,}/g, ' ')
			jQuery('textarea#lockOrUnlockStdIds').val(lockOrUnlockStdIds);
		}).blur();
		
		jQuery("#lockOrUnlockStdIds").keydown(function(event) {
	        /* Allow: escape, backspace, delete, tab, space, enter, home, end, left, right Ctrl*/ 
	        if ( event.keyCode == 27 || event.keyCode == 46 || event.keyCode == 8 || event.keyCode == 9 || 
	             event.keyCode == 32 || event.keyCode == 13 || (event.keyCode >= 35 && event.keyCode <= 40) || event.ctrlKey ) {
	            return;
	        } else {
	            /* Ensure that it is a number and stop the keypress*/
	            if (event.shiftKey || (event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 96 || event.keyCode > 105 )) {
	                event.preventDefault(); 
	            }   
	        }
	    });
	});
		
	function releaseLockedRecords(url) {
		jQuery.msgBox({
	        title: "Are You Sure",
	        content: "Are you sure you want release all locked records?", 
	        type: "confirm",
	        buttons: [{ value: "Yes" }, { value: "No" }],
	        success: function (result) {
				if (result == "Yes") {
					document.lockOrUnlockFM.action = url;
					document.lockOrUnlockFM.submit();
				} else {
					return false;
				}
	        }
	    });
	}
	
	function unlockRecords(url) {
		var lockOrUnlockStdIds = jQuery.trim(jQuery('textarea#lockOrUnlockStdIds').val());
		if(typeof lockOrUnlockStdIds == 'undefined' || lockOrUnlockStdIds == null || lockOrUnlockStdIds == '' || lockOrUnlockStdIds == 'null') {
			jQuery.msgBox("Please enter atleast one standard Id.");
			return false;
		} else if(finalCount > 10000){
			jQuery.msgBox("Please enter maximum 10,000 standards.");
			return false;
		} else {
			document.lockOrUnlockFM.action = url;
			document.lockOrUnlockFM.submit();
		}
	}
	
	function lockRecords(url) {
		var lockOrUnlockStdIds = jQuery.trim(jQuery('textarea#lockOrUnlockStdIds').val());
		if(typeof lockOrUnlockStdIds == 'undefined' || lockOrUnlockStdIds == null || lockOrUnlockStdIds == '' || lockOrUnlockStdIds == 'null') {
			jQuery.msgBox("Please enter atleast one standard Id.");
			return false;
		} else if(finalCount > 10000){
			jQuery.msgBox("Please enter maximum 10,000 standards.");
			return false;
		} else {
			document.lockOrUnlockFM.action = url;
			document.lockOrUnlockFM.submit();
		}
	}
</script>

<!-- Keep the below 2 un-closed divs as this is a fix for footer left aligning issue -->
<div><div>

<form action="" method="post" name="lockOrUnlockFM" id="lockOrUnlockFM">
	
	<div class="row">
		<div class="span12">
			<div class="row">
				<div class="span4"><h3>Unlock</h3></div>
	            <div class="span7 pull-right alert alert-danger" style="display:table;">
					<span style="font-size: 120%; display:table-cell; vertical-align:middle;">
	            		<strong>There are currently ${lockedCount} locked records in CMS.</strong>
	            	</span>
					<c:choose>
						<c:when test="${lockedCount gt 0}">   
							<span class="pull-right">
								<button type="button" class="btn btn-danger btn-small"  id="releaseLock" 
									onClick="javascript:releaseLockedRecords('${releaseLockedRecordsURL}');">Release All Locks</button>
							</span>
						</c:when>
						<c:otherwise>
							<span class="pull-right">
								<button class="btn btn-danger btn-small"  id="releaseLock" disabled="disabled">Release All Locks</button>
							</span>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="span12">
			<p><strong>If you are a <em>Brand Standards Super Admin</em>, you can already edit locked records.  By unlocking records in this screen you are making them available (editable) across any active publications across any Brand and any Region.</strong></p>
		</div>
	</div>

	<div class="row">
		<div class="span12">
			<p>To unlock specific records, please paste your Standard ID's into the text area below and click Unlock:</p>
		</div>
	</div>

	<div class="row">
		<div class="span10">
			<em id="noOfStandardsMessage">Total Standards Count: <span id="display_count">0</span> / 10,000 Standards.</em>
			<textarea rows="6" style="width:100%" name="lockOrUnlockStdIds" id="lockOrUnlockStdIds" class="rightClickDisabled"></textarea>
		</div>
	</div>

	<div class="row">
		<div class="span2">
			<c:choose>
				<c:when test="${lockedCount gt 0}">
					<button type="button" class="btn btn-danger" onClick="javascript:unlockRecords('${unLockedRecordsURL}');">Unlock</button>
				</c:when>
				<c:otherwise>
					<button type="button" class="btn btn-danger" disabled="disabled">Unlock</button>
				</c:otherwise>
			</c:choose>
			<button type="button" class="btn btn-success" onClick="javascript:lockRecords('${lockedRecordsURL}');">Lock</button>
		</div>
	</div>
</form>