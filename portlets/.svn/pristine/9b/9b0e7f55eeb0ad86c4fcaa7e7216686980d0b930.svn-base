
<%@page import="com.ihg.brandstandards.db.model.ChainStandards"%>
<%@page import="com.ihg.brandstandards.bridge.util.BrandStandardsUtil"%>
<%@page import="java.util.Map"%>
<%@page import="com.ihg.brandstandards.db.model.Department"%>
<%@page import="com.ihg.brandstandards.db.service.DepartmentLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@include file="/html/mustPublish/init.jsp"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsRegion"%>
<liferay-portlet:actionURL name="importSelection" var="importSelectionURL"/>
<liferay-portlet:resourceURL var="validateSelectionURL" id="validateSelection" />
<liferay-portlet:resourceURL var="clearMeasurementURL" id="clearMeasurement" />

<liferay-ui:error key="error-excel-validation" message="Sorry, uploaded excel file is not valid." />
<liferay-ui:error key="error-publication" message="Sorry, publication is not available for selected brand and region." />
<liferay-ui:error key="error-templateId" message="Sorry, SE Template is not uploaded for selected brand and region." />
<script type="text/javascript">
    var currentBrandName = 'VN';
    var selectBrandErrorMsg = "Please select Brand.";
    var selectRegionErrorMsg = "Please select Region.";
    var selectDeptErrorMsg = "Please select Department.";
    var selectFileErrorMsg = "Please select Import File.";
	var publicationErrorMsg  = "Publication is not available for selected Brand and Department.";
	var seTemplateErrorMssg = "SETemplate is not uploaded for selected brand and region.";
    var isGemAdmin = "false";
    var isGEMPage = "true";
    var validateSelectionURL = '${validateSelectionURL}';
    var clearMeasurementURL = '${clearMeasurementURL}';
    var isSuccessRequest = '${importSuccess }';
	var successMessage = "Import successfully processed.";
    $( function() {
    	if(isSuccessRequest){
			jQuery.msgBox({
		    	    title:"Success",
		    	    content:successMessage,
					type:"info"
		   	});
        } 
    });
    function importSelection(isSubmit)
    {
        //validate dropdowns are selected
		 if(jQuery("#brand").val() == "" || jQuery("#brand").val() == null)
        {
           // alert(selectBrandErrorMsg);
			jQuery.msgBox({
		    	    title:"Warning",
		    	    content:selectBrandErrorMsg
		    	});
            return false;
        }
        else if(jQuery("#region").val() == null || jQuery("#region").val() == "")
        {
        	jQuery.msgBox({
		    	    title:"Warning",
		    	    content:selectRegionErrorMsg
		    	});
            return false;
        } else if((jQuery("#dept").val() == "" || jQuery("#dept").val() == null))
        {
        	jQuery.msgBox({
		    	    title:"Warning",
		    	    content:selectDeptErrorMsg
		    	});
            return false;
        } else if((jQuery("#import_selection_file").val() == "" || jQuery("#import_selection_file").val() == null) && isSubmit)
        {
        	jQuery.msgBox({
		    	    title:"Warning",
		    	    content:selectFileErrorMsg
		    	});
            return false;
        }
        else
        {	
        	var re = /(\.xls|\.xlsx|\.xlsm)$/i;
			if(!re.exec($('#import_selection_file').val()) && isSubmit)
			{
				jQuery.msgBox({
		    	    title:"Error",
		    	    content:"File extension not supported!"
		    	});
            return false;
			}
			jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
			/** Load Data to the model window before opening */
       		jQuery.ajax({
       		  	url:validateSelectionURL,
       		  	type: "POST",
       		  	data: {brand:jQuery("#brand").val(),region:jQuery("#region").val(),dept:jQuery("#dept").val() }
       	    }).done(function(data) {
       	    	if(isSubmit){
       	    		executeSubmitRequest(data);
       	    	}else{
       	    		executeClearMeasurementRequest(data);
       	    	}
				
				jQuery.unblockUI();
       	    }).fail( function(jqXHR) {
				jQuery.unblockUI();
				 jQuery.msgBox({
						title:"Error",
						content:"Unable to import selection file.!"
				});
       	    });
			 
        }
    }
    
    function clearForm(){
			jQuery("#brand").val("");
			jQuery("#region").val("");
			jQuery("#dept").val("");
			$('#import_selection_file').val("");      
    };
    

	function executeSubmitRequest(data){
		var obj = JSON.parse(data);
				if(obj.isValid=="true"){
					jQuery.msgBox({
						title: "Are You Sure",
						content: "Are you sure you want to Import the selection? Import porcess will start runtime immedialtly once you click yes below.",
						type: "confirm",
						buttons: [{ value: "Yes" }, { value: "No" }],
						success: function (result) {
							
							if (result == "Yes") {
								jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
								var frm  = document.getElementById('importSelectionForm');
								frm.submit();
							}
							if(result == "No" || result == "Cancel")
							{
								return false;
							}
						}
					}); 				
				}else{
					if(obj.errorMessage == "publication-not-available"){
						jQuery.msgBox({
							title:"Warning",
							content:publicationErrorMsg
						});
						return false;
					}else if(obj.errorMessage == "seTemplate-not-available"){
						jQuery.msgBox({
							title:"Warning",
							content:seTemplateErrorMssg
						});
						return false;
					}
				}
	}
	function executeClearMeasurementRequest(data){
		var obj = JSON.parse(data);
		if(obj.isValid=="true"){
			jQuery.msgBox({
				title: "Are You Sure",
				content: "Are you sure you want to clear measurement selection? Clear selection porcess will start runtime immedialtly once you click yes below.",
				type: "confirm",
				buttons: [{ value: "Yes" }, { value: "No" }],
				success: function (result) {
					
					if (result == "Yes") {
						jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
						jQuery.ajax({
			    		  	url:clearMeasurementURL,
			    		  	type: "POST",
			    		  	data: {brand:jQuery("#brand").val(),region:jQuery("#region").val(),dept:jQuery("#dept").val() }
			    	    }).done(function(clearMesurementResult) {
			    	    	var obj1 = JSON.parse(clearMesurementResult);
			    			if(obj1.isValid=="true"){
			    				jQuery.msgBox({
									title:"Success",
									content:"Measurement selection cleared successfully.",
									type:"info"
								});
								clearForm();
								
							}else{
								jQuery.msgBox({
										title:"Warning",
										content:obj1.errorMessage										
									});		
								jQuery.unblockUI();
								return false;									
							}
							jQuery.unblockUI();
			    	    }).fail( function(jqXHR) {
							jQuery.unblockUI();
							 jQuery.msgBox({
									title:"Error",
									content:"Unable to clear measurement selections!"
							});
			    	    });
					
					}
					if(result == "No" || result == "Cancel")
					{
						return false;
					}
				}
			}); 				
		}else{
			if(obj.errorMessage == "publication-not-available"){
				jQuery.msgBox({
					title:"Warning",
					content:publicationErrorMsg
				});
				return false;
			}else if(obj.errorMessage == "seTemplate-not-available"){
				jQuery.msgBox({
					title:"Warning",
					content:seTemplateErrorMssg
				});
				return false;
			}
		}
	}
</script>


<%
long userId = PortalUtil.getUserId(renderRequest);
if (userId > 1)
{ 
	boolean flag = request.isUserInRole("BRND_STND_GEM_IMPORT_SELECTIONS_ADMIN"); 
    if(flag){
%>
<form action="${importSelectionURL}" class="form  " id="importSelectionForm" method="post" name="importSelectionForm" title="Import Selection Form" enctype="multipart/form-data">
	<div class="modal_body">
        <div class="row-fluid">
            <div class="pad10">
            	<p>
	            			This application allows you to Import measurement selection for a particular Brand, Region and Department in the Global Evaluation Manager (GEM).
            	</p>
                <div class="form-horizontal" >
	                <div class="control-group" >
	                    <label class="control-label" for="brand" title="Brand"><em class="required">* </em><strong>Brand</strong></label>
	                    <div class="controls">
	                    <%
	                    	Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap();
	                    	List<StandardsRegion> regionList = StandardsRegionLocalServiceUtil.getStandardsParentRegionsList();
	                    	List<Department> deptList = DepartmentLocalServiceUtil.getActiveDepartments("Y");
	                    %>
	                        <select id="brand" class="brand" name="brand" title="select Brand value" value="${brand}">
	                            <option value="" selected="">Select</option>
							
	                             <%
							
									for(String chncode : chnCdMap.keySet())
									{
										%>
										<c:set var="brndvar" value="<%=chncode%>"/>
										<c:if test="${brand eq brndvar}">selected</c:if>
										
										<option <c:if test="${brand eq brndvar}">selected</c:if> value="<%=chncode%>"><%=chnCdMap.get(chncode)%> </option>
								<%		
									}
							%> 
	                        </select>
	                    </div>
	                </div>
	              <div class="control-group">  
                	<label class="control-label" for="brand" title="Region"><em class="required">* </em><strong>Region</strong></label>
                	<div class="controls">
               		<select id="region" class="region" name="region" title="select Region value">
              			<option value="" selected="">Select</option>
              			<%  for(StandardsRegion region : regionList){	
							    if(!region.getRegionCode().equalsIgnoreCase("GLBL")){        	%>
								<c:set var="regvar" value="<%=region.getRegionCode() %>" />
							<option <c:if test="${region eq regvar}">selected</c:if> value="<%=region.getRegionCode() %>"><%=region.getRegionCode() %></option>            	
						<%}} %>
						 <%-- <option value="GLBL" <c:if test='${selectedRegion  eq "GLBL"}'> selected</c:if> >Global</option>
				                            <option value="AMEA" <c:if test='${selectedRegion  eq "AMEA"}'> selected</c:if> >AMEA</option>
				                            <option value="AMER" <c:if test='${selectedRegion  eq "AMER"}'> selected</c:if> >AMER</option>
				                            <option value="GC" <c:if test='${selectedRegion  eq "GC"}'> selected</c:if> >GC</option>
				                            <option value="EURO" <c:if test='${selectedRegion  eq "EURO"}'> selected</c:if> >EURO</option> --%>
               		</select>
	               	</div>
				</div>	
	         <div class="control-group">
		                <label class="control-label" for="dept" title="Department"><em class="required">* </em><strong>Department</strong></label>
			                	<div class="controls" >
			                		<select id="dept" class="dept" name="dept" title="select Department value">
			                			<option value="">Select</option>
											<!-- <option value="101" >Department 1</option>
								<option value="102" >Department 2</option>
								<option value="103" >Department 3</option>
								<option value="104" >Department 4</option>
								<option value="105" >Department 5</option>  -->
			                			<%
		                					for(Department dept : deptList){	
		                				%>
										<c:set var="deptvar" value="<%=dept %>" />
		                				<option <c:if test="${dept eq deptvar}">selected</c:if> value="<%=dept.getDepartmentId() %>"><%=dept.getDepartmentName() %></option>
										
			                			<%} %>
										
			                		</select>
			                	</div>
	                </div>
	                <div><label class="control-label" for="import_selection_file" title="File"><em class="required">* </em><strong>File</strong></label>
					  <div class="controls"><input id="import_selection_file" name="import_selection_file" type="file" /></div>
					</div>
            	</div>
       		</div> 
    	</div>
    	<div style="margin: 10px 110px;">
	        <a class="btn pull-left" href="javascript:clearForm()" title="Clear">Clear</a>
	        <button id="importButton" class="btn pull-right1" type="button" title="" onclick="javascript:importSelection(true)" style="margin-left: 20px;">Import</button>
	        <button id="importButton" class="btn pull-right1" type="button" title="" onclick="javascript:importSelection(false)" style="margin-left: 20px;">Clear Selection</button>
    	</div>
    </div>
</form>
<%}else{%>
	
	You do not have access to this portlet. Please contact support/technical team to get access to this portlet.
	
<%}	} else {
%>
	Not logged in !!
<%
	}
%>

<style>
.aui em {
    color: red;
}
</style>