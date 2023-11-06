<%@page import="com.ihg.brandstandards.db.service.DepartmentLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.db.model.Department"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@include file="init.jsp"%>
<%
String deptName= "";
String deptDescription="";
String inActiveSelected = " ";
String deptType= "";
String departmentId= (String)request.getAttribute("departmentId");
if(Validator.isNotNull(departmentId)){
	Department department= DepartmentLocalServiceUtil.getDepartment(Long.valueOf(departmentId));
	deptName = department.getDepartmentName();
	deptDescription= department.getDescription();
	deptType = department.getActiveInd();
	if(department.getActiveInd().equals("N")){
		inActiveSelected = "selected";
	}
}

%>
<portlet:resourceURL var="validateNameURL" id='isdeptNameExist'>
    <portlet:param name="cmd" value="validateDepartmentName"></portlet:param>
</portlet:resourceURL>
<portlet:actionURL name="saveDepartment" var="saveDepartmentURL" />
<portlet:renderURL var="cancelURL">
	<portlet:param name="jspPage" value="/html/GEM/departmentAdmin/view.jsp" />
</portlet:renderURL>
<div id="AddDepartmentModal" title="Add Department">
<div style="max-height:400px; overflow-y:auto;">
<liferay-ui:error key="please-enter-name-and-description" message="Please enter department name and description."></liferay-ui:error>
<aui:form id="deptfm" name="deptfm" action="<%= saveDepartmentURL %>"	method="post">
	<aui:input name="departmentId" type="hidden" value="<%=departmentId %>"></aui:input>
	<aui:input name="oldDeptName" type="hidden" value="<%=deptName %>"></aui:input>
	<aui:input name="oldDeptType" type="hidden" value="<%=deptType %>"></aui:input>
	<div class="clear"></div>
	<div class="form-horizontal">
		<div class="control-group">
					<label class="control-label" title="Department Name"><em class="required">* </em>Department Name:</label>
					<div class="controls">
						<input type="text" id="<portlet:namespace/>deptName" name="<portlet:namespace/>deptName" maxlength=100 style="width:300px;" value="<%=deptName %>" class="input_text required">
					</div>
		</div>
		<div class="control-group">
					<label class="control-label" title="Department Type"><em class="required">* </em>Department Type:</label>
					<div class="controls">
						<select id="<portlet:namespace/>departmentType" name="<portlet:namespace/>departmentType">
							<option value="Y" >Active</option>
							<option value="N" <%=inActiveSelected %>>Inactive</option>
						</select>
					</div>
				</div>
		<div class="control-group">
					<label class="control-label" title="Department Description"><em class="required">* </em>Department Description:</label>
					<div class="controls">
						<textarea  id="<portlet:namespace/>deptDescription" style="width:500px;height:100px;" name="<portlet:namespace/>deptDescription"   class="input_text required"><%=deptDescription%></textarea>
					</div>
		</div>
	</div>
	
</aui:form>
</div>
<div class="modal-footer aui-panel-ft">
		<input class="btn pull-left" type="button" title="Add Department" value="Save" onclick="submitDepartment()">
		<button class="btn pull-right addDepartmentPopupClose editDepartmentPopupClose" title="Cancel">Cancel</button>
	</div>
</div>
<script type="text/javascript">
$(".addDepartmentPopupClose").click(function() {
	addDepartmentDialog.dialog('close');
});

$(".editDepartmentPopupClose").click(function() {
	editDepartmentDialog.dialog('close');
});
function submitDepartment() {
	 var deptName = jQuery.trim($('#<portlet:namespace/>deptName').val());
	 var deptDescription = jQuery.trim($('#<portlet:namespace/>deptDescription').val());

	 
	 if(typeof deptName == 'undefined' || deptName == null || deptName == '' || deptName == 'null') {
		 jQuery.msgBox("Please enter Department Name.");
	 } else if(deptName.length > 100){
		 jQuery.msgBox("Department Name cannot be more than 100 characters.");
	 } else if(typeof deptDescription == 'undefined' || deptDescription == null || deptDescription == '' || deptDescription == 'null') {
		 jQuery.msgBox("Please enter Department Description.");
	 } else if($('#<portlet:namespace/>departmentId').val()==''){
		 $.ajax({
		  	url: '<%=validateNameURL%>',
		  	data: {deptName: deptName},
			type: "POST",
		  	dataType: "text",
		  	async: false,
		    success: function(data) {
		    	if (data != null && data != '' && typeof data != 'undefined') {
		    		var parsedData = JSON.parse(data);
		    		 var isNameExist =  parsedData.isdeptNameExist;
			            if(isNameExist=='true'){
			            	jQuery.msgBox("Department Name already exist. Please enter different Department Name.");
			            }else{
			            	  $( "#<portlet:namespace/>deptfm" ).submit();
			            }
		  	
		    	} 
		    }
		});
	 }else if($('#<portlet:namespace/>departmentId').val()!=''){
		 
		 if($('#<portlet:namespace/>oldDeptName').val()!=deptName){
			 
			 $.ajax({
				  	url: '<%=validateNameURL%>',
				  	data: {deptName: deptName},
					type: "POST",
				  	dataType: "text",
				  	async: false,
				    success: function(data) {
				    	if (data != null && data != '' && typeof data != 'undefined') {
				    		var parsedData = JSON.parse(data);
				    		 var isNameExist =  parsedData.isdeptNameExist;
					            if(isNameExist=='true'){
					            	jQuery.msgBox("Department Name already exist. Please enter different Department Name.");
					            }else{
					            	if($('#<portlet:namespace/>oldDeptType').val()=='Y'&&$('#<portlet:namespace/>departmentType').val()=='N'){
					    				jQuery.msgBox({
					            		    title: "Are You Sure",
					            		    content: "<span class=\"alert alert-danger\">Are you sure you want to Inactive this department?</span>",
					            		    type: "confirm",
					            		    buttons: [{ value: "Yes" }, { value: "No" }],
					            		    success: function (importConfirmation) {
					            		        if (importConfirmation == "Yes") {
					            		        	$( "#<portlet:namespace/>deptfm" ).submit();
					            		        } else if(importConfirmation == "No" || importConfirmation == "Cancel") {
					            					return;
					            				}
					            		    }
					            		});
					    			 
					    			 }else{
					    				 $( "#<portlet:namespace/>deptfm" ).submit();
					    			 }
					            }
				  	
				    	} 
				    }
				});
			 
		 }else{
			 if($('#<portlet:namespace/>oldDeptType').val()=='Y'&&$('#<portlet:namespace/>departmentType').val()=='N'){
				jQuery.msgBox({
        		    title: "Are You Sure",
        		    content: "<span class=\"alert alert-danger\">Are you sure you want to Inactive this department?</span>",
        		    type: "confirm",
        		    buttons: [{ value: "Yes" }, { value: "No" }],
        		    success: function (importConfirmation) {
        		        if (importConfirmation == "Yes") {
        		        	$( "#<portlet:namespace/>deptfm" ).submit();
        		        } else if(importConfirmation == "No" || importConfirmation == "Cancel") {
        					return;
        				}
        		    }
        		});
			 
			 }else{
				 $( "#<portlet:namespace/>deptfm" ).submit();
			 }
			 
		 }
		 
	 }
}

</script>