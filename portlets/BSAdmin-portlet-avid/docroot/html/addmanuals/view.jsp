<%
/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
 %>
<%@include file="/html/init.jsp" %>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.db.model.HistManualChain"%>
<%@page import="com.ihg.brandstandards.db.model.HistManualAttachment"%>
<%@page import="com.ihg.brandstandards.db.model.HistManualRegion"%>
<%@page import="com.ihg.brandstandards.bsadmin.model.ManualView"%>
<%@page import="com.ihg.brandstandards.util.ManualsUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.lang.StringEscapeUtils"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>

<portlet:actionURL  name="Cancel" var="Cancel"/>
<portlet:resourceURL var="SaveManual"  id="SaveManual" />

<%
long userId = PortalUtil.getUserId(renderRequest);
if (userId > 1)
{
	ManualView manualView = (ManualView) request.getAttribute("ManualView");
	Map<String, String> chnCdMap = ManualsUtil.chainCodeMap();
%>

<link href="/BSTheme-theme/css/other/development_bundle/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/BSTheme-theme/js/jquery-1.4.2.min.js"></script>
<script src="/BSTheme-theme/js/jquery-ui-1.8.10.custom.min.js"></script>
<script src="/BSTheme-theme/js/jquery-ui-multiselect-widget.js"></script>

<!-- form wizard items -->
<script type="text/javascript" src="/BSTheme-theme/js/jquery.form.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.validate.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.ui.datepicker.validation.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/bbq.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.form.wizard.js"></script>
<%@include file="/html/common/countryregions.jsp" %>
<%@include file="/html/common/initmenu.jsp" %>
<script type="text/javascript">

function showFilterCount()
{
	// DO NOT DELETE. Referenced from countryregion.js, this has to be blank here.
}

var goto_url = "/web/brand-standards/historical-manuals";
var allowSbmt = <%=manualView.isHasAccess()%>;
var isEditable = <%=ManualsUtil.isEditable(manualView.getManual())%>;

jQuery(function(){
	
	jQuery(".multis").multiselect();
	jQuery.datepicker.setDefaults({showOn: 'both', buttonImageOnly: true, buttonImage: '/BSTheme-theme/images/calendar_icon.png', buttonText: 'Select Date'});
	jQuery(".datepicker").datepicker({dateFormat: 'dd-M-yy', changeMonth: true, changeYear: true});
	
	jQuery.validator.addClassRules({
		manual_file:{
            required: true
		}
    });
	jQuery("#new_manuals_form").formwizard({ 
		formPluginEnabled: true,
		historyEnabled : true,
		validationEnabled: true,
		validationOptions : {
			rules: {
				required: "required"
			},
		ignore: ":hidden:not('#manuals_brand')" //Tells it to check the jqueryUI multi-select
		},
		focusFirstInput : true,
		formOptions :{
			success: function(data){
				alert(data);
                window.location.href = goto_url;
			},
			beforeSerialize: function (data){
				if(!allowSbmt)
				{
					alert("You do not have enough rights to perform this action.");
				}
				if(!isEditable)
				{
					alert("You can not edit this manual, it is referenced by Standard or Specification or Guideline.");
					return false;
				}
				return allowSbmt;
			},
			resetForm: false
		},
		disableInputFields: true
	 });
});

function populateRegions(slctRegions)
{
	for (iReg1=0;iReg1<regions.length;iReg1++){
		var isSelected = false;
		for (iSelReg1=0;iSelReg1<slctRegions.length;iSelReg1++) {
			if(regions[iReg1].region_cd==slctRegions[iSelReg1]) {
				isSelected = true; break;
			}
		}
		if(isSelected) {
			jQuery('#manuals_regions').append('<option value="' + regions[iReg1].region_cd +'" selected="selected">' + regions[iReg1].region_nm + '</option>') ;
		} else {
			jQuery('<option/>').val(regions[iReg1].region_cd).html(regions[iReg1].region_nm).appendTo('#manuals_regions');
		}
	}
}

function cancel()
{
	window.location.href = goto_url;
}
function getRegionByCode(rgn_cd)
{
	for (iReg1=0;iReg1<regions.length;iReg1++){
		if(regions[iReg1].region_cd == rgn_cd) {
			return regions[iReg1].region_nm;
		}
	}
}
function deleteFile()
{
	jQuery("#manualfilediv").show();
	jQuery("#manuafiletable").hide();	
}
function addRegions(newRegion)
{
	bFound = false;
	for (iReg1=0;iReg1<regions.length;iReg1++){
		if(regions[iReg1].region_cd == newRegion.region_cd) {
			bFound = true;
		}
	}
	if(!bFound)
	{
		regions.push(newRegion);
	}
}
</script>
	<div class="rounded_container">
        <div class="rounded_container_contents">
        	<% if(manualView.getManual().getHistManualId() < 0) { %>
            	<h4>Add New Manual</h4>
			<% } else { %>
				<h4> Edit Manual </h4>
			<% } %>
			<form id="new_manuals_form" target="native-results" method="post" action="<%=SaveManual%>" class="bbq wizard_form" enctype="multipart/form-data">
                <div class="field_wrapper">
				<span class="step" id="submit_step">
					<span class="step_title">Filter Historical Sources</span>
                    <br/><br/>
                    <input type="hidden" name="<%=ManualsUtil.REQUEST_PARAM_ID%>" id="<%=ManualsUtil.REQUEST_PARAM_ID%>" value="<%=manualView.getManual().getHistManualId()%>" />
                    
                    <label class="wrapper_label" for="manuals_brand"><span class="wrapper_span"><em class="required">* </em>Applicable Brands</span>
					   <div class="brands">
                       <select id="manuals_brand" class="multis required" name="manuals_brand" multiple="multiple" style="width:463px">
                        	<option value="">Select</option>
                        <% for(String chncode : chnCdMap.keySet()) {
                        	boolean selected = false;
                        	for(HistManualChain manualChain : manualView.getManualChain())
                        	{
                        		if(manualChain.getChainCode().equalsIgnoreCase(chncode))
                        		{
                        %> 			<option value="<%=chncode%>" selected="selected"><%=chnCdMap.get(chncode)%></option>
                        <%			selected = true;
                        			break;
                        		}
                        	}
                        	if(!selected)
                        	{
                       %> 			<option value="<%=chncode%>"><%=chnCdMap.get(chncode)%></option>
                       <%                        		
                        	}
                        } %>
                        </select>
						</div>
                    </label>
                    <div class="clear"></div>
                    <label class="wrapper_label" for="manuals_regions"><span class="wrapper_span"><em class="required">* </em>Applicable Regions</span>
                        <select id="manuals_regions" name="manuals_regions" multiple="multiple" class="required" >
                        </select>
                    </label>
                    <div class="clear"></div>
                    <label class="wrapper_label" for="manual_type"><span class="wrapper_span"><em class="required">* </em>Manual Type</span>                
                        <select id="manual_type" class="single_select required" name="manual_type">
                        	<option value="">Select</option>
                        	<option value="OFFCL_STND_MNL" <%=ManualsUtil.getValueOrBlank(manualView.getManual().getType()).equals("OFFCL_STND_MNL")?"selected='selected'":""%> >Official Standards Manual</option>
                            <option value="RSRCS" <%=ManualsUtil.getValueOrBlank(manualView.getManual().getType()).equals("RSRCS")?"selected='selected'":""%>>Resources</option>
                            <option value="GDLN" <%=ManualsUtil.getValueOrBlank(manualView.getManual().getType()).equals("GDLN")?"selected='selected'":""%>>Guidelines</option>
                            <option value="SPCFCTN" <%=ManualsUtil.getValueOrBlank(manualView.getManual().getType()).equals("SPCFCTN")?"selected='selected'":""%>>Specifications</option>
                            <option value="OTHER" <%=ManualsUtil.getValueOrBlank(manualView.getManual().getType()).equals("OTHER")?"selected='selected'":""%>>Other</option>
                        </select>        
                    </label>
                    <div class="clear"></div>
                    <label class="wrapper_label" for="manual_file_title"><span class="wrapper_span"><em class="required">* </em>File Title</span>                
                        <div class="filetitle1">
						<input type="text" class="input_text required" name="manual_file_title" id="manual_file_title" value="<%=ManualsUtil.getValueOrBlank(manualView.getManual().getTitle())%>" maxlength="256" />          
						</div>
                    </label>
                    <label class="wrapper_label" for="manual_pub_date"><span class="wrapper_span"><em class="required">* </em>Publication Date</span>                
                        <%  
                        	DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
						%>
                        <input type="text" class="datepicker required" name="manual_pub_date" readonly="readonly" id="manual_pub_date" value="<%=manualView.getManual().getPubDate()==null? "": formatter.format(manualView.getManual().getPubDate())%>" />
                    </label>
                    <div class="clear"></div>
                    
                    <label class="wrapper_label" for="manual_file"><span class="wrapper_span"><em class="required">* </em>File</span>
					<% if(manualView.getManual().getHistManualId() < 0) { %>
	                       <input type="file" name="manual_file" id="manual_file" class="files_to_upload required" />     
	                <% } else { 
	                		HistManualAttachment attachment = manualView.getAttachment();
	                		String fileName = attachment.getAttachmentPath().substring(attachment.getAttachmentPath().lastIndexOf("/")+1, attachment.getAttachmentPath().length());
                            String path = attachment.getAttachmentPath().substring(0, attachment.getAttachmentPath().lastIndexOf('/'));
                            long groupId = themeDisplay.getScopeGroupId();
                            long folderId = Long.valueOf(path.substring(path.lastIndexOf("/")+1, path.length()));  
                            DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(groupId, folderId, fileName);
                            path = "/documents/"+ groupId + "/" + fileEntry.getUuid();
                            
	                %>
	                	<div id="manualfilediv" style="display:none">
	                		<input type="file" name="manual_file" id="manual_file" class="files_to_upload required"/>
	                	</div>
	                	<div  id="manuafiletable" style="float: left; margin-top: 4px;">
	                	<table>
	                		<tr class="table_links_list">
	                			<td class="standard_file_file_td this_link">
	                				<a title="file path" href="<%=path%>" <%=fileName.toLowerCase().endsWith(".pdf")? "target='_blank'":""%> ><%=fileName%></a>
	                				&nbsp;&nbsp;<img alt="delete" src="/BSTheme-theme/images/delete.png" title="delete" class="delete_this_file" onclick="deleteFile();"/>
	                			</td>
	                		</tr>
	                	</table>
	                	</div>
	                <% } %>
					</label>                    
                    
                    <div class="clear"></div>
				</span>
				</div>
				<div class="wizard_navigation"> 							
					<input class="navigation_button" id="back" value="Back" type="reset" />
					<input class="navigation_button" id="next" value="Next" type="submit" />
                    <input type="button" id="form_cancel" class="navigation_button ui-state-active" onClick="cancel();" value='Cancel'>
				</div>
			</form>
            <div class="clear"></div>			
        </div><!--ends rounded_container_contents -->
        <div class="rounded_container_bottom">&nbsp;</div>
    </div><!--ends rounded_container -->
<script language="JavaScript">
regions = new Array();
selRegions = new Array(); 
<%  
	// Edit mode
	if(manualView.getManual().getHistManualId() > 0) {
		List<HistManualRegion> regions = manualView.getManualRegions();
		
		for(HistManualRegion region : regions)
		{
			if(region.getRegionCode().equals("AMEA")) {
%>				addRegions(new regionsObj("AMEA", "AMEA", ameaOptions));
				selRegions.push("AMEA");
<%			} else if(region.getRegionCode().equals("AMER")) {
%>				addRegions(new regionsObj("Americas", "AMER", amerOptions));
				selRegions.push("AMER");
<%			} else if(region.getRegionCode().equals("EURO")) {
%>				addRegions(new regionsObj("Europe", "EURO", euOptions));
				selRegions.push("EURO");
<%			} else if(region.getRegionCode().equals("GC")) {
%> 				addRegions(new regionsObj("Greater China", "GC", gcOptions));
				selRegions.push("GC");
<%			}			
		}
		List<Role> roles = user.getRoles();
		for(Role role : roles)
			{
				if(role.getName().equalsIgnoreCase(ManualsUtil.MNL_AUTHORS_GLOBAL_ROLE)) {
	%>				addRegions(new regionsObj("AMEA", "AMEA", ameaOptions));
					addRegions(new regionsObj("Americas", "AMER", amerOptions));
					addRegions(new regionsObj("Europe", "EURO", euOptions));
					addRegions(new regionsObj("Greater China", "GC", gcOptions));	
	<%				break;
				}
			}
	}
	// New Manual mode
	else {
		List<Role> roles = user.getRoles();
		for(Role role : roles)
			{
				if(role.getName().equalsIgnoreCase(ManualsUtil.MNL_AUTHORS_GLOBAL_ROLE)) {
	%>				regions.push(new regionsObj("AMEA", "AMEA", ameaOptions));
					regions.push(new regionsObj("Americas", "AMER", amerOptions));
					regions.push(new regionsObj("Europe", "EURO", euOptions));
					regions.push(new regionsObj("Greater China", "GC", gcOptions));	
	<%				break;
				} else if(role.getName().equalsIgnoreCase(ManualsUtil.MNL_AUTHORS_AMEA_ROLE)) {
	%>				regions.push(new regionsObj("AMEA", "AMEA", ameaOptions));
	<%			} else if(role.getName().equalsIgnoreCase(ManualsUtil.MNL_AUTHORS_AMER_ROLE)) {
	%>				regions.push(new regionsObj("Americas", "AMER", amerOptions));
	<%			} else if(role.getName().equalsIgnoreCase(ManualsUtil.MNL_AUTHORS_EUROPE_ROLE)) {
	%>				regions.push(new regionsObj("Europe", "EURO", euOptions));
	<%			} else if(role.getName().equalsIgnoreCase(ManualsUtil.MNL_AUTHORS_GC_ROLE)) {
	%> 				regions.push(new regionsObj("Greater China", "GC", gcOptions));
	<%			}
			}
	}
%>	populateRegions(selRegions);
	</script>
<% } else {
%>
	Not logged in !!
<%  }
%>