<%@include file="/html/GEM/support/init.jsp" %>
<%@page import="com.ihg.brandstandards.gem.util.MailUtil"%>

<!--items for jquery UI -->
<script type="text/javascript" src="/BSBridge-theme/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="/BSBridge-theme/js/jquery-ui.js"></script>
<!-- <script type="text/javascript" src="/BSTheme-theme/js/jquery.nyroModal.custom.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery-ui-1.10.1.custom.min.js"></script> 
<script type="text/javascript" src="/BSTheme-theme/js/jquery.multiselect.min.js"></script>

<script type="text/javascript" src="/BSBridge-theme/js/jquery.validate.min-1.11.1.js"></script>
<script type="text/javascript" src="/BSBridge-theme/js/jquery.form.3.28.0.js"></script>
<script type="text/javascript" src="/BSBridge-theme/js/treeAdmin/jquery.msgBox.js"></script>

<link type="text/css" rel="stylesheet" href="/BSBridge-theme/css/msgBoxLight.css"/>
<!-- <link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/bsstyle.css"/> -->
<!-- <link href="/BSTheme-theme/css/other/jquery-ui-1.10.1/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css" /> -->
<!--ends jquery UI items -->

<!-- <script src="/BSTheme-theme/js/supportForm.js"></script> -->
  
<style>
#errors {
    display:none;
    padding:10px;
    background-color:#9F9;
    border:2px solid #396;
    margin-bottom:20px;
    }
</style>


<% 
long userId = PortalUtil.getUserId(renderRequest);
if (userId > 1)
{
    String FullName  = (String)request.getAttribute(MailUtil.FULL_NAME);
    String ScreenName  = (String)request.getAttribute(MailUtil.SCREEN_NAME);
    String Email  = (String)request.getAttribute(MailUtil.EMAIL);
    Map<String, Object> rolesMap  = (Map<String, Object>)request.getAttribute(MailUtil.ROLES_MAP);
     
%>
<style type="text/css">
 
fieldset {
border: 1px solid #CCCCCC;
margin: 10px;
padding: 10px;
font-size: 13px;
}
 
input[type=text], textarea, select {
border: 1px solid #777;
padding: 3px;
}
 
.aui-form-validator-stack-error {
    color: red;
    display: block;
    font-weight: normal;
    font-style: italic;
    background:none;
}
 
.aui-form-validator-error-container {}
.aui-form-validator-valid-container {}
 
.aui-form-validator-error {
background: lightPink;
}

.field_wrapper_mail {
    padding:10px;
    width:50%;
    border:10px solid #eee;
    margin-left:200px;
    background:#f9f9f9;
    }
    
.width250{
    width:250px !important;
}
.selectwidth260{
    width:260px !important;
}    
button.ui-multiselect{
    width:260px !important;
}

textarea.aui-field-input{
    width: 250px;
    height:120px;
    }
    
.clear_mail_label {
    clear:both;
    font-size:0;
    margin:0;
    padding:0;
    line-height:0;
}
    
</style> 


<script type="text/javascript">
     var portletNamepsace = '<portlet:namespace />';
</script>

<portlet:resourceURL var="SendRequestUrl"  id="SendRequest" />

<div class="rounded_container">
<div class="rounded_container_contents">
<div id='errors'></div>
<form id="request_form"  method="post" name="request_form" action="<%=SendRequestUrl%>"  enctype="multipart/form-data">
 <div class="field_wrapper_mail">
 <div id="title" align="center"><h4>Support Request Form</h4></div>

 <!-- User Name -->
 <label class="wrapper_label" title="user name label">
     <span class="wrapper_span">Name<a class="help_icon tooltip" href="javascript:return false;" title="support request help icon tooltip">
        <img src="/BSBridge-theme/images/help.png" alt="support request help icon" title="help"/>
     <span class="classic">Logged In User Name</span></a></span>
         <label id="user_name_lbl" title="user name" >
               <span class="wrapper_span" style="text-align:left;"><%=FullName%></span>
          </label>
 </label>
 <div class="clear_mail_label"></div>
  
 <!-- User Email -->
 <label class="wrapper_label" title="user email label">
      <span class="wrapper_span">Email<a class="help_icon tooltip" href="javascript:return false;" title="support request help icon tooltip">
         <img src="/BSBridge-theme/images/help.png" alt="support request help icon" title="help"/>
       <span class="classic">Logged In User Email</span></a></span>
         <label id="user_email_lbl" title="user email" >
              <span class="wrapper_span" style="text-align:left;"><%=Email%></span>
         </label>
 </label>
 <div class="clear_mail_label"></div>
 
 
 
 <!-- Request Type -->
 <%
	boolean isBrndAdmn=false;
		 List<Role> roles = user.getRoles();
 		 for(Role role : roles)
			{
				if(role.getName().equalsIgnoreCase("BRND_STND_ADMINS")) {
				    isBrndAdmn=true;  
				}
			}
		
%>
 
 <% //if(isBrndAdmn){ %>
 <label class="wrapper_label" for="request_type" title="request type">
     <span class="wrapper_span">Select Request Type<a class="help_icon tooltip" href="javascript:return false;" title="support request help icon">
     <img src="/BSBridge-theme/images/help.png" alt="support request help icon" title="help"/>
      <span class="classic">Dropdown to select whether this is a new user request, or a support/change request.</span></a></span>
          <select id="request_type" name="request_type" title="This field is required." class="single_select selectwidth260 required" tabindex="1" >
          <option value="0" selected="selected">Select</option>
            <option value="user_request">New User Request</option>
            <option value="change_request">Support/ Change Request</option>
       </select>
 </label>
 
 <%//}else{%>
<!--  <label class="wrapper_label" for="request_type" title="request type">
     <span class="wrapper_span">Select Request Type<a class="help_icon tooltip" href="javascript:return false;" title="support request help icon">
     <img src="/BSTheme-theme/images/help.png" alt="support request help icon" title="help"/>
      <span class="classic">Dropdown to select whether this is a new user request, or a support/change request.</span></a></span>
          <select id="request_type" name="request_type" title="This field is required." class="single_select selectwidth260 required" tabindex="1" >
          <option value="0" selected="selected">Select</option>
            <option value="change_request">Support/ Change Request</option>
       </select>
 </label>
 -->
 <%// }%>
 <div class="clear_mail_label"></div>
 
 
 
 
 <div id="new_user_request_block" style="display:none;"><!--------------new_user_request_block  start-------------------------->
 
 <!-- New User Merlin Id -->

 <label class="wrapper_label" for="user_domain_id" id="user_domain_id_label"  title="merlin id label">
    <span class="wrapper_span"> <em class="required">* </em>User Merlin ID<a class="help_icon tooltip" href="javascript:return false;" title="support request help icon tooltip">
       <img src="/BSBridge-theme/images/help.png" alt="support request help icon" title="help"/>
       <span class="classic">New User's Domain Id/ Merlin Id</span></a></span> 
    <input type="text" class="input_text width250 required" title="This field is required." name="user_domain_id" id="user_domain_id" maxlength="30" tabindex="2" > 
 </label>
 <div class="clear_mail_label"></div>
 
 <!-- New User Full Name -->

 <label class="wrapper_label" for="user_full_name" id="user_full_name_label"  title="user name label">
    <span class="wrapper_span"> <em class="required">* </em>User Full Name<a class="help_icon tooltip" href="javascript:return false;" title="support request help icon tooltip">
       <img src="/BSBridge-theme/images/help.png" alt="support request help icon" title="help"/>
       <span class="classic">New User's Full Name</span></a></span>  
    <input type="text" class="input_text width250 required" title="This field is required." name="user_full_name" id="user_full_name" maxlength="30" tabindex="3" > 
 </label>
 <div class="clear_mail_label"></div>
 
 <!-- New User Region -->

 <label class="wrapper_label" for="user_region" id="user_region_label" title="user region label">
    <span class="wrapper_span"> <em class="required">* </em>User Region<a class="help_icon tooltip" href="javascript:return false;" title="support request help icon tooltip">
       <img src="/BSBridge-theme/images/help.png" alt="support request help icon" title="help"/>
       <span class="classic">New User's Region</span></a></span> 
          <select id="user_region" name="user_region" title="This field is required." class="single_select selectwidth260 required" tabindex="4" >
            <option value="AMEA" selected="selected">AMEA</option>
            <option value="Americas">Americas</option>
            <option value="Europe">Europe</option>
            <option value="Greater China">Greater China</option>
            <option value="Global">Global</option>
          </select>
 </label>
 <div class="clear_mail_label"></div>
 
 <!-- New User Email -->

 <label class="wrapper_label" for="email" id="user_email_label" title="user email label">
    <span class="wrapper_span"> <em class="required">* </em>User Email<a class="help_icon tooltip" href="javascript:return false;" title="support request help icon tooltip">
       <img src="/BSBridge-theme/images/help.png" alt="support request help icon" title="help"/>
       <span class="classic">New User's Email Id</span></a></span>  
    <input type="text" class="input_text width250 required" title="This field is required." name="email" id="email" maxlength="30" tabindex="5" /> 
 </label>
 <div class="clear_mail_label"></div>
 
<!-- New User Roles Required -->
 <label class="wrapper_label" for="select_roles" id="select_roles_label" title="label">
    <span class="wrapper_span">
     <em class="required">* </em> User Roles  
      <a class="help_icon tooltip" href="javascript:return false;" title="tooltip"><img src="/BSBridge-theme/images/help.png" alt="icon" title="help"/>
     <span class="classic">Select New User Roles.</span>
      </a>
    </span>                
       
    <select id="select_roles" class="multis required "  multiple="multiple" name="select_roles" title="select" tabindex="6" >
              <% for(String rolesKey : rolesMap.keySet()){%>
                   <option value="<%=rolesKey%>"><%=rolesMap.get(rolesKey)%></option>
                 <% } %>
    </select>
 </label> 
 <div class="clear_mail_label"></div>
  
  </div><!--------------new_user_request_block end -------------------------->
 
 <div id="change_request_block" style="display:none;"><!--------------change_request_block  start-------------------------->
  
 <!-- Description -->
 <label class="wrapper_label" for="mail_textarea" id="mail_textarea_label" title="mail textarea">
   <span class="wrapper_span">
     <em class="required">* </em>Description
     <a class="help_icon tooltip" href="javascript:return false;" title="tooltip"><img src="/BSTheme-theme/images/help.png" alt="icon" title="help"/>
     <span class="classic">Support/ Change Request Description.</span>
     </a>
    </span>                
    <textarea cols="40" class="message width250 required" rows="5" name="mail_textarea" id="mail_textarea" tabindex="2" ></textarea>   
    <div style="float:right;"><span id="<portlet:namespace />mail-char-count"></span> character(s) remaining.</div>                     
 </label>
 
  <div class="clear_mail_label"></div>
 
 <!-- Upload -->
 <label class="wrapper_label" for="file_upload" id="file_upload_label" title="standard rationale label">
   <span class="wrapper_span_char_count">Attachment<a class="help_icon tooltip" href="javascript:return false;" title="support request help icon tooltip">
      <img src="/BSTheme-theme/images/help.png" alt="support request help icon" title="help"/>
    <span class="classic">File Attachment</span></a></span>  
  <!--  <input type="file"  id="file_upload" name="file_upload"/> -->
  <aui:input name="file" type="file" id="file" label="" tabindex="3" />
 </label>
  <div class="clear_mail_label"></div>

</div><!--------------change_request_block  end-------------------------->
  
 <div class="clear"></div> 
  <!-- submit and cancel button -->
     <div align="center" id="request_form_button" style="display:none;">            
         <input type="button" id="request_submit" name="submitButton" value="Submit" title="Submit form" tabindex="7"/>
         <input type="button" value="Reset" id="reset_button" tabindex="8"/>                
    </div>
 
 <div class="clear_mail_label"></div>

  
</div>

</form>
</div><!--ends rounded_container_contents -->
<div class="rounded_container_bottom">&nbsp;</div>
</div><!--ends rounded_container -->

<aui:script use="aui-base">
AUI().use('aui-char-counter', function(A) {
  

});
  
  var validateFile = function(fileField) {
         var value = fileField.val();
        if (value) {
            var extension = value.substring(value.lastIndexOf('.')).toLowerCase();
            var validExtensions = ['.bmp','.gif','.jpeg','.jpg','.png','.tif','.tiff','.ppt','.pdf','.doc','.docx','.xls','.xlsm','.txt'];

            if ((A.Array.indexOf(validExtensions, '*') == -1) &&
                (A.Array.indexOf(validExtensions, extension) == -1)) {

                alert('Only files with following extensions are allowed: bmp, gif, jpeg, jpg, png, tif, tiff, pdf, doc, docx, xls, xlsm, txt ');

                fileField.val('');
            }
        }
    };

    var onFileChange = function(event) {
        validateFile(event.currentTarget);
    };

    var fileField = A.one('#<portlet:namespace />file')

    if (fileField) {
        fileField.on('change', onFileChange);

        validateFile(fileField);
    }
</aui:script>


<script type="text/javascript">



var rulesNewUserRequest={
            email: {
                required: true,
                email: true
            },
            user_region: {
                required: true
            },
            user_full_name: {
                required: true
            },
            user_domain_id: {
                required: true
            },
            select_roles:{
                required: true,
            }
           
        };

var rulesChangeRequest={ 
             mail_textarea:{
                required: true,
            }
         };
         
var messageNewUserRequest={
            email: {
                email: 'Type your email in this field.',
                required: 'New User\'s Email Required..'
            },
            user_region: {
                required: 'New User\'s Region Required.'
            },
            user_full_name: {
                required: 'New User\'s Full Name Required.'
            },
            user_domain_id: {
                required: 'New User\'s Merlin Id Required.'
            },
            select_roles: {
                required: 'New User\'s Roles Required.'
            }
        };
var messageChangeRequest={
            mail_textarea: {
                required: 'Description Required.'
            }
        
        };
    

AUI().ready('aui-form-validator','aui-char-counter','aui-io','event','event-custom', 'aui-overlay-context-panel', function(A) {
    
	var requestFormValidator;
	var maxTextLength = 400;
	var auiTextAreaIDWithNSpace = '#' +'mail_textarea';
	var auiCountAreaIDWithNSpace = '#' + portletNamepsace + 'mail-char-count';
    
    var btnSubmit = A.one('#request_submit');
    
      A.one('#new_user_request_block').setStyle('display', 'none');
      A.one('#change_request_block').setStyle('display', 'none');
      A.one('#request_form_button').setStyle('display', 'none');
      
     var nodeObject = A.one('#request_type');
     if(nodeObject)
     {
        nodeObject.on('change', function(event){  
        
         if(nodeObject.get('value')=='user_request')
         {
               document.request_form.reset();     
               /* nodeObject.val( 'user_request' ).attr('selected',true); */
               jQuery("select#request_type").val("user_request");
               A.one('#new_user_request_block').setStyle('display', 'block');
               A.one('#request_form_button').setStyle('display', 'block');
               A.one('#change_request_block').setStyle('display', 'none');
                 requestFormValidator = new A.FormValidator({
                        boundingBox: document.request_form,
                        fieldContainer: 'label',
                        validateOnBlur: false,
                        rules:rulesNewUserRequest,
                        //custom message
                        fieldStrings: messageNewUserRequest
                   });
         }
         else
         { 
             if(nodeObject.get('value')=='change_request')
             {
               A.one('#new_user_request_block').setStyle('display', 'none');
               A.one('#change_request_block').setStyle('display', 'block');
               A.one('#request_form_button').setStyle('display', 'block');
                requestFormValidator = new A.FormValidator({
                        boundingBox: document.request_form,
                        fieldContainer: 'label',
                        validateOnBlur: false,
                        rules:rulesChangeRequest,
                        //custom message
                        fieldStrings: messageChangeRequest
                   });
                   auiCountAreaNode.set('text',(maxTextLength - (auiTextAreaNode.get('value').length)));     
          /*       new A.CharCounter({
                    input: '#mail_textarea',
                    counter: '#mail-char-count',
                    maxLength: 400,
                    on: {
                      maxLength: function(event) {
                        alert('The max length limit was reached');
                      }
                    }
                  }); */
             }
             else
             {
             
               A.one('#new_user_request_block').setStyle('display', 'none');
               A.one('#change_request_block').setStyle('display', 'none');
               A.one('#request_form_button').setStyle('display', 'none'); 
             }
         
         }
       });
     }
     
      var resetButtonObj = A.one('#reset_button');
      resetButtonObj.on('click', function(event){  
        document.request_form.reset(); 
        auiCountAreaNode.set('text',(maxTextLength - (auiTextAreaNode.get('value').length)));
      /*   new A.CharCounter({
            input: '#mail_textarea',
            counter: '#mail-char-count',
            maxLength: 400,
            on: {
              maxLength: function(event) {
                alert('The max length limit was reached');
              }
            }
          }); */
        A.one('#new_user_request_block').setStyle('display', 'none');
        A.one('#change_request_block').setStyle('display', 'none');
        A.one('#request_form_button').setStyle('display', 'none');
    });
    
    
    
        var cfg = {
                        method: 'POST',
                        enctype: 'multipart/form-data',
                       
                        form: {
                            id: 'request_form',
                            upload: true
                            },
                        on: {
                              complete: function(id,o,args) {
                                 
                                  if(o && o.responseText)
                                   {
                                     response=A.JSON.parse(o.responseText);
                                     if(response.response == 'Failure')
                                     {
                                      jQuery("#errors").css('display','block');
                                      jQuery("#errors").html(response.response+": "+response.message);
                                          
                                      }
                                      if(response.response == 'Success')
                                      {
                                       /* jQuery("#errors").css('display','block');
                                       jQuery("#errors").html(response.response+": "+response.message); */
                                       document.request_form.reset();
                                       jQuery.msgBox({
                                           title: "Success!",
                                           content: "Mail sent successfully." ,
                                           type: "info",
                                           success: function (result) {
                                        	   A.one('#new_user_request_block').setStyle('display', 'none');
                                               A.one('#change_request_block').setStyle('display', 'none');
                                               A.one('#request_form_button').setStyle('display', 'none');
                                               return;
                                           }
                                       });
                                      
                                      }
                                   }
                            
                             }
                            }
                    };
    
    
        btnSubmit.on("click", function(){
        	
        	 requestFormValidator.validate();
            
             if(!requestFormValidator.hasErrors())
             {
                 var request = A.io('<%=SendRequestUrl.toString()%>', cfg);
             }else
                 {
                 return false;
                 }
        });
        
        var auiTextAreaNode = new A.one(auiTextAreaIDWithNSpace);
        if (auiTextAreaNode === null) {
                alert('AUI Text Area node not found.');
        }
           
        var auiCountAreaNode = new A.one(auiCountAreaIDWithNSpace);
            if (auiCountAreaNode === null) {
                alert('AUI Count Text node not found.');
        }

       auiCountAreaNode.set('text',(maxTextLength - (auiTextAreaNode.get('value').length)));
       
       new A.CharCounter({
            input: auiTextAreaIDWithNSpace,
            counter: auiCountAreaIDWithNSpace,
            maxLength: maxTextLength,
            on: {
              maxLength: function(event) {
                alert('The max length limit was reached');
              }
            }
          });
});

jQuery(".multis").multiselect();
</script>

<%
	} else {
%>
	Not logged in !!
<%
	}
%>