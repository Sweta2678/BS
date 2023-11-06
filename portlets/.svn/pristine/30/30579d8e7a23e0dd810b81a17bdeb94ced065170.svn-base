
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.util.portlet.PortletProps"%>
<%@include file="/html/init.jsp"%>
<%@page import="com.liferay.portal.util.PortletKeys"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>


<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content sharewrapper">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="share-title">Share Content</h4>
        </div>
        <div class="modal-body">
          <p id="mailDescription"></p>
          <div class="control share-field">
				<label>From</label>
				<input type="text" id="fromMailId" name="<portlet:namespace/>from" value="${themeDisplay.user.emailAddress}" class="disabled" readonly="readonly"/>
		  </div>
          <div class="control share-field">
				<span class="required">*</span><label>To</label>
				<input type="text" id="toMailIds"  />
		  </div>
          <div class="control share-field">
				<span class="required">*</span><label>Subject</label>
				<input type="text" id="mailSubject" readonly="readonly" />
		  </div>
          <div class="control">
			<span class="required">*</span><label>Message</label>
			<textarea  id="mailBody" readonly="readonly" ></textarea>
		  </div>
          <div class="bottomLink">
							<input type="button" value="Send" class="pull-right postMsg" onclick="sendEmail();"/>
							<input type="button" value="Cancel" class="pull-right cancel" onclick="closeDialog();"/>
						</div>
        </div>
      </div>
      
    </div>
  </div>   
  
  
<script type="text/javascript">


var contentURL;
function sendEmail() {
	
	//Cancel the link behavior
	var sendEmailURL = '${sendEmail}';	
	var toAddresses = $('#toMailIds').val();
	var contentTitle = $('#mailSubject').val();
	var contentURL = $('#mailBody').val();
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var validation=true;
	if(typeof toAddresses == 'undefined' || toAddresses == null || toAddresses == '' || toAddresses == 'null') {
		ErrorMessage.showError("#toMailIds","Please provide a valid email address.");
		jQuery("#toMailIds").focus();
		validation=false;
	}else{
		ErrorMessage.hideError("#toMailIds");
	}
	if(typeof contentTitle == 'undefined' || contentTitle == null || contentTitle == '' || contentTitle == 'null'){
		ErrorMessage.showError("#mailSubject","Please provide subject.");
		jQuery("#mailSubject").focus();
		validation=false;
	}else{
		ErrorMessage.hideError("#mailSubject");
	}if(typeof contentURL == 'undefined' || contentURL == null || contentURL == '' || contentURL == 'null'){
		ErrorMessage.showError("#mailBody","Please provide Message.");
		jQuery("#mailBody").focus();
		validation=false;
	}else{
		ErrorMessage.hideError("#mailBody");
	}
	if(toAddresses!=''){
		var result = toAddresses.split(",");
		for (var i = 0; i < result.length; i++) {
            if (result[i] != '') {
                if (!filter.test(result[i])){
                    ErrorMessage.showError("#toMailIds","Please provide a valid email address.");
                    jQuery("#toMailIds").focus();
                    validation=false;
                    return false;
                }else{
            		ErrorMessage.hideError("#toMailIds");
            	}
            }
        }
	}

	if(validation){
		contentURL = contentURL.replace(/\r?\n/g, '<br />');
		$.ajax({
		  	url :sendEmailURL,
		  	data : {"toAddresses":toAddresses,"contentTitle":contentTitle,"contentURL":contentURL},
		  	type: "POST",
		  	dataType: "text"
		}).done(function(data) {
	    	if (data != null && data != '' && typeof data != 'undefined') {
	    		
	    	}
	    	$('.close').click();
		}).fail( function(jqXHR) {
			$('.close').click();
        });
	}
	
}

function closeDialog(){
	$('.close').click();
}

function clearFormValues(downloadLink, heading, description) {
	 var baseURL = "${themeDisplay.getURLPortal()}";
		$('#toMailIds').val('');
	 $('#mailDescription').text(description);
     $('#mailSubject').val('Link to '+ heading);
     console.log(downloadLink + " " +heading + " " + description );
     contentURL='Open following link to read about '+heading+'. ' + baseURL + downloadLink;
     console.log(contentURL);
     $('#mailBody').text(contentURL);     
     ErrorMessage.hideError("#toMailIds");
     ErrorMessage.hideError("#mailSubject");
     ErrorMessage.hideError("#mailBody");
}	
</script>