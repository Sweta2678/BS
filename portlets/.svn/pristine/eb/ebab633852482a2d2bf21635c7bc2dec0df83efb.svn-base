<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.util.JavaConstants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.io.File"%>
<%@include file="/html/init.jsp" %>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.ihg.brandstandards.util.StandardsUtil"%>
<%@page import="com.ihg.brandstandards.util.StandardsStatusUtil"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsStatus"%>
<%@page import="com.ihg.brandstandards.util.BSAdminConstants"%>


<portlet:actionURL name="importTags" var="importURL"/>
<portlet:actionURL name="removeTags" var="removeTagURL"/>
<portlet:resourceURL id="uploadTags" var="uploadTagsURL"/>
<portlet:resourceURL id="updateTags" var="updTags" />

<script type="text/javascript" src="/BSTheme-theme/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery-ui-1.10.1.custom.min.js"></script>

<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.blockUI.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.msgBox.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.nyroModal.custom.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/manage-tag.js"></script>

<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/msgBoxLight.css" />
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/other/jquery-ui-1.10.1/themes/base/jquery.ui.all.css" />
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/bulk-update.css" />
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/manage-tag.css" />
<%
String fileAdded=(Validator.isNotNull(renderRequest.getAttribute("fileAdded"))? (String)renderRequest.getAttribute("fileAdded"):"false");
%>
<portlet:resourceURL id="getXLSData" var="getXLSData">
 </portlet:resourceURL>
 <portlet:resourceURL id="addRemoveTags" var="addRemoveTagsUrl"/>

<%

long userId = PortalUtil.getUserId(renderRequest);
if (userId > 1)
{
	boolean isSuperAdmin = StandardsUtil.isSuperAdmin(user.getRoles());
	boolean isApprover = StandardsStatusUtil.hasApproverRole(user);
	
%>
<liferay-ui:error key="please-add-valid-file" message="Please add Valid file" />
<liferay-ui:error key="please-add-valid-columnname" message="Please add valid column names in file" />
<input type="hidden" name="updBrandStatus" id="updBrandStatus" value="<%=updTags%>" />
<div class="rounded_container">
    <div class="rounded_container_contents">
            
        <h4>Manage Standards Tag</h4>
        <!-- Tags Import -->
        <aui:form id="importForm" name="importForm" action="<%=uploadTagsURL %>" method="post" enctype="multipart/form-data">
        <aui:input type="hidden" id="submitAction" name="submitAction" value=""/>
        <label class="wrapper_label file-label" for="file" title="File"><span class="wrapper_span"><em class="required">* </em>Please select a file to upload:</span>
             <aui:input type="file" id="file" class="add_item_file_input fileInput" name="file" label=""/>
             <img class="clear_file" id="clear_file" title="clear file selecction" src="/BSTheme-theme/images/delete.png" alt="clear file selection" >
        </label>
         <!-- <div class="modal-footer">
            <div class="pull-left"><button type="button" class="btn searchoptioncancel">Cancel</button></div>
            <div class="pull-right"><button type="submit" id="upload" class="btn btn-primary" >Upload</button></div>
        </div>
   		 -->
       	<div style="clear: both;padding-left: 400px;">OR</div>

        <!-- tags bulk update -->
     	 <label class="wrapper_label" for="StandardsIds" title="Standard/Spec ID"><span class="wrapper_span"><em class="required">* </em>Standard/Spec ID:</span>
            <input class="stdIdsText" type="text" name="stdIdsText" id="stdIdsText" value="" />
        </label>
        <div class="upd2Bottons">
            <input type="button" name="tagsAdd" id="tagsAdd" class="ui-state-disabled" value="Add" title="Add Tags" disabled/> 
            
            <input type="button" name="tagsRemove" id="tagsRemove" class="ui-state-disabled" value="Remove" title="Remove Tags" disabled/> 
			
        </div>
        <div class="clear"></div>

        <label class="wrapper_label" for="tags" title="Tags"><span class="wrapper_span"><em class="required">* </em>Tags:</span>
            <div id="tag-container" style="width:252px;display:inline-block;">
			<div id="tag-box">
	<div class="lfr-form-row lfr-form-row-inline"  style="width: 250px;height: 34px;float: left;">
		<div class="row-fields" style="width: 269px;">
		 <input class="field" id="tagIds" name="tagIds" type="hidden" value="1"> 
		 <input class="field" id="dltTagIds" name="dltTagIds" type="hidden" value=""> 
			<div class="control-group control-group-inline">
									<input class="field lfr-input-text tagText" id="tagText_1" name="tagText_1" style="max-width: 200px; " type="text" value="" maxlength="75" >
			</div>
		</div>
		<span class="lfr-autorow-controls toolbar toolbar-horizontal" ><span class="toolbar-content">
			<img class="delete-row " id="delete-row" title="remove tag text" src="/BSTheme-theme/images/delete.png" alt="remove tag text" style="margin-bottom:5px;">
		</span></span>
	</div>
	</div>
	<button type="button" id="addTagRow" class="add-row btn-content btn btn-icon-only toolbar-first toolbar-item" title=""  >
		<span class="btn-icon icon icon-plus"></span></button>
</div>

<div id="blank_tag_box" style="display:none;">
<div class="lfr-form-row lfr-form-row-inline" id="append-box"  style="width: 250px;height: 34px;float: left;">
	<div class="row-fields" style="width: 269px;">
		<!-- <input class="field"  name="tagId" type="hidden" value="0"> -->
		<div class="control-group control-group-inline">
								<input class="field lfr-input-text tagText tagText_2" id="tagText_2" name="tagText_2" style="max-width: 200px; " type="text" value="" maxlength="75">
		</div>
	</div>
	<span class="lfr-autorow-controls toolbar toolbar-horizontal" ><span class="toolbar-content">
		<img class="delete-row " id="delete-row" title="remove tag text" src="/BSTheme-theme/images/delete.png" alt="remove tag text" style="margin-bottom:5px;">
	</span></span>
</div>
</div>




        </label>
        </aui:form>
        <!-- END OF Other Author -->
       
       
		<div class="clear"></div>	
		
    </div>
    <!--ends rounded_container_contents -->
    <div class="rounded_container_bottom">&nbsp;</div>
</div>
<div id="manageTagImport" title="Attention" style="display:none;">
				<div class="modal-body">
				  <h4>Some standards failed to be <span id="action"></span> due to one of the following reasons:</h4>
			        <ul >
			       		  <li>1 Not Regional/Global Ids</li>
						  <li>2 Not Valid Ids</li>
						  <li>3 No Tags associated with Ids</li>
					</ul>
						<p>       					
       					<strong>To view Invalid Standard/Spec/Guideline Id('s) click on 
       					 <a href="#" onclick="window.location.href='${getXLSData}'"> Download. </a> 
       					
       					</strong>
       					</p>
			      </div>
				<div class="modal-footer">
				    <div class="pull-right"><button type="button" style="width:85px;"  class="btn btn-primary errorInImport">OK</button></div>
			  	</div>
		</div>
<%
    } else {
%>
    Not logged in !!
<%
    }
%>


<style>

.aui #tag-container .control-group {

    margin-bottom: 0px;

}
</style>

 <script>
 

jQuery("#<portlet:namespace/>file").change(function(){
 	fileOnChangeValidation(this);
 });
 
jQuery( document ).ready(function() {
	 bindTagAction("<%=renderResponse.getNamespace()%>");
	 loadPopUp('<%=fileAdded%>');
	 jQuery('#addTagRow').bind("click", function(){
		jQuery('#tag-container').find('#tag-box').append($('#blank_tag_box').html());
		bindTagAction("<%=renderResponse.getNamespace()%>");
	});
});

jQuery("#tagsAdd").click(function(){
	submitForm("add","<%=renderResponse.getNamespace()%>","<%=getXLSData.toString()%>","<%=uploadTagsURL.toString()%>","<%=addRemoveTagsUrl.toString()%>");
});
jQuery("#tagsRemove").click(function(){
	submitForm("remove","<%=renderResponse.getNamespace()%>","<%=getXLSData.toString()%>","<%=uploadTagsURL.toString()%>","<%=addRemoveTagsUrl.toString()%>");
});

$(document).on("change","#stdIdsText , .tagText",function(){
	checkValues();
});

jQuery('#tag-container').find('#tag-box').find(".lfr-form-row:last-child").find('img.delete-row').bind("click", function(){
		if(jQuery('#tag-container').find(".lfr-form-row").length>1){
			jQuery(this).closest(".lfr-form-row").remove();
		}else{
			jQuery(this).closest(".lfr-form-row").find('input.lfr-input-text').val("");
			}
		
			checkValues();
		updateOrSection('<%=renderResponse.getNamespace()%>');
		
	});

$('#_ManageTag_WAR_BSAdminportlet_file , #stdIdsText  , .tagText ').bind("change", function(){
	updateOrSection('<%=renderResponse.getNamespace()%>');
});
$('.delete-row ').bind("click", function(){
	updateOrSection('<%=renderResponse.getNamespace()%>');
});

$('#clear_file').bind("click", function(){
	$('#<portlet:namespace/>file').val("") ;
	updateOrSection('<%=renderResponse.getNamespace()%>');
});
	
	
</script> 