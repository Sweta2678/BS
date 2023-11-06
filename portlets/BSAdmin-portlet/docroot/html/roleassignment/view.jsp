<%@include file="/html/init.jsp" %>
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/other/jquery-ui-1.10.1/themes/base/jquery.ui.all.css"/>
<link rel="stylesheet" href="/BSTheme-theme/css/other/jquery-ui-1.10.1/themes/base/jquery-ui.css" />

<script type="text/javascript" src="/BSTheme-theme/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery-ui-1.10.1.custom.min.js"></script>

<portlet:resourceURL var="assignRoleURL" id="assignRole" />
<portlet:resourceURL var="deleteRoleURL" id="deleteRole"/>
<portlet:resourceURL var="getRolesBySubTypeURL" id="getRolesBySubType" />

<c:if test="${!hasPreferencesSet}" >
	<div class="alert alert-error" > Portlet preferences are not set. Please set the portlet preferences with comma separated role types. </div>
</c:if>

<aui:form  action="${assignRoleURL}" method="post" name="RoleAssignmentForm" id="RoleAssignmentForm">

	<div class="alert alert-error" id="userNotExists" style="display: none;"> No user exists with User Name / Email Address you are provided.</div>
	<div class="alert alert-success" id="successMessage" style="display: none;"> Roles successfully assigned to user. </div>
	<div class="alert alert-success" id="deleteMessage" style="display: none;"> Roles successfully deleted. </div>
	<div class="alert alert-error" id="roleuserNotExists" style="display: none;"> Role does not exist for user. Hence cannot be deleted.</div>

	<aui:select id="subTypes" name="subTypes" label="Select Application (Role Sub Type)" required="true">
		<option value=""></option>
		<c:forEach var="opt" items="${roleSubTypesList}">
			<option value="${opt}">${opt}</option>
		</c:forEach>
	</aui:select>
	<aui:input id="userName" type="text" name="userName" label="Enter User Name(Network Id) / Email Address" value="${userName}">
		<aui:validator name="required" errorMessage="Please enter User Name"/>
		<aui:validator name="maxLength">75</aui:validator>
	</aui:input>
	<aui:select id="selectedRole" name="selectedRole" label="Select Role" required="true" >
    	<option value=""></option>
	</aui:select>
	<aui:button id="assignRole" name="assignRole" type="button" value="Assign Role" />
	<aui:button id="deleteRole" name="deleteRole" type="button" value="Delete Role" />
</aui:form>

<script type="text/javascript">
var getRolesBySubTypeURL = '${getRolesBySubTypeURL}';
var assignRoleURL = '${assignRoleURL}';
var deleteRoleURL = '${deleteRoleURL}';
jQuery(document).ready(function(){
	jQuery("#_brndstndroleassignment_WAR_BSAdminportlet_subTypes").change(function () {
    	var roleSubType = $(this).val();
    	if(roleSubType != ''){
    		jQuery.ajax({
    			url : getRolesBySubTypeURL,
    			data: {"roleSubType" : roleSubType},
    			type: "POST",
    			dataType: "text"
    		}).done(function(data) {
   				if (typeof data != 'undefined' && data != null && data != '') {
   					jQuery('#_brndstndroleassignment_WAR_BSAdminportlet_selectedRole').empty();
   					jQuery('#_brndstndroleassignment_WAR_BSAdminportlet_selectedRole').append(data);
   				}
    		}).fail( function(jqXHR, textStatus) {
                alert("AJAX request failed with status:" + textStatus);
    	    });
    	}
    })
    
     jQuery("#_brndstndroleassignment_WAR_BSAdminportlet_assignRole").click(function () {
    	jQuery("#userNotExists").hide();
		jQuery("#successMessage").hide();
    	var userName = jQuery("#_brndstndroleassignment_WAR_BSAdminportlet_userName").val();
    	var roleId = $('#_brndstndroleassignment_WAR_BSAdminportlet_selectedRole option:selected').val();
    	if(userName != ''){
    		jQuery.ajax({
    			url : assignRoleURL,
    			data: {"userName" : userName,"roleId":roleId},
    			type: "POST",
    			dataType: "text"
    		}).done(function(data) {
   				if (typeof data != 'undefined' && data != null && data != '') {
   					if(data == 'Success'){
   						jQuery("#successMessage").show();
   					} else if(data == 'Not_Exists'){ 
   						jQuery("#userNotExists").show();
   					}
   				}
    		}).fail( function(jqXHR, textStatus) {
                alert("AJAX request failed with status:" + textStatus);
    	    });
    	}
    })
    
    jQuery("#_brndstndroleassignment_WAR_BSAdminportlet_deleteRole").click(function () {
		jQuery("#deleteMessage").hide();
		jQuery("#roleuserNotExists").hide();
		jQuery("#userNotExists").hide();
		jQuery("#successMessage").hide();
    	var userName = jQuery("#_brndstndroleassignment_WAR_BSAdminportlet_userName").val();
    	var roleId = $('#_brndstndroleassignment_WAR_BSAdminportlet_selectedRole option:selected').val();
    	if(userName != ''){
    		jQuery.ajax({
    			url : deleteRoleURL,
    			data: {"userName" : userName,"roleId":roleId},
    			type: "POST",
    			dataType: "text"
    		}).done(function(data) {
   				if (typeof data != 'undefined' && data != null && data != '') {
   					if(data == 'Not_Exists'){
   						jQuery("#userNotExists").show();
   					} else if(data == 'RoleUserNotExist') { 
   						jQuery("#roleuserNotExists").show();
   					} else if(data == 'Deleted'){
   						jQuery("#deleteMessage").show();
   					}
   				}
    		}).fail( function(jqXHR, textStatus) {
                alert("AJAX request failed with status:" + textStatus);
    	    });
    	}
    }) 
});
</script>