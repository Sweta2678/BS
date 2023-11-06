<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@include file="/html/regionalmanual/init.jsp" %>
<portlet:actionURL  name="Cancel" var="Cancel"/>
<portlet:resourceURL var="SaveStandard"  id="SaveStandard" />

<%
long userId = PortalUtil.getUserId(renderRequest);
if (userId > 1)
{ 
	RegionalView regManStdView = (RegionalView) request.getAttribute("RegManStdView");
	Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap();
    boolean hasAccess = RegionalUtil.hasEditAccess(user, regManStdView.getStandard());

%>

<script>
var authorRegions = new Array();

var submitted = false;

var isStd = <%=regManStdView.getStandard().getStdTyp().equals(RegionalUtil.STD_TYPE_STANDARD) ? "true" : "false"%>;

function cancelMe(url)
{
	jQuery.msgBox({
        title:"Are You Sure",
        content:"Are you sure you would like to cancel and lose your changes?" ,
        type:"confirm",
        buttons: [{ value: "Yes" }, { value: "No" }],
        success: function (result) {
            if (result == "Yes") {
            	location.href=url;	            
            }
            if (result == "No") {
            	return;         
            }
        }
    });
}

function showComments()
{	
	var popID = "comments_div"; //Get Popup Name
	var popWidth = 700;
	//alert(statusCurrValue);
	//Fade in the Popup and add close button
	jQuery('#comments_div').fadeIn().css({ 'width': Number( popWidth ) });

	//Define margin for center alignment (vertical   horizontal) - we add 80px to the height/width to accomodate for the padding  and border width defined in the css
	var popMargTop = (jQuery('#comments_div').height() + 80) / 2;
	var popMargLeft = (jQuery('#comments_div').width() + 80) / 2;

	//Apply Margin to Popup
	jQuery('#comments_div').css({
		'margin-top' : -popMargTop,
		'margin-left' : -popMargLeft
	});
	
		jQuery('body').append('<div id="cmt_modalwindow_fade"></div>'); //Add the fade layer to bottom of the body tag.
		jQuery('#cmt_modalwindow_fade').css({'filter' : 'alpha(opacity=80)', 'position': 'fixed', 'z-index': 10}).fadeIn();
		jQuery('#comments_div').insertAfter('#cmt_modalwindow_fade'); 
		//Close Popups and Fade Layer
		jQuery('#cmt_close').click(function() { //When clicking on the close ...
	    	jQuery('#cmt_modalwindow_fade, .comments_modalwindow_block').fadeOut(function() {
		        jQuery('#cmt_modalwindow_fade, a.comments_modalwindow_close').remove();  //fade them both out
		        jQuery("#cmt_txt_area").val("");
		        submitted = false;
	    	});
	    
	    return false;
	});
	// On click of Ok button.
	jQuery('#cmt_submit').click(function() { //When clicking on the close ... 
		commentsVal = jQuery("#cmt_txt_area").val();
		//alert("1");
        //alert("Request update for record id = " + stdId);
		if (submitted==false)
        {
            submitted = true;
			//alert("2");
			 if(commentsVal.length > 0)
	         {
				//alert("3");
		    	jQuery('#cmt_modalwindow_fade, .comments_modalwindow_block').fadeOut(function() {
		        	jQuery('#cmt_modalwindow_fade, a.comments_modalwindow_close').remove();  //fade them both out
		   		});
		    	//alert("record id = " + lastSelectedStdId);
                updateStatus(commentsVal);
	         }
			 else
	         {
	             alert("Please enter comments.");
                 submitted = false;
	         }
        }
	    return false;
	});
	return false;
}

function updateStatus(commentsVal)
{	
	    jQuery("#overlay").fadeIn();
	    submitted = false;
		jQuery("#cmt_txt_area").val("");
		jQuery("#overlay").fadeOut();
		alert("hi");
		jQuery("#new_standard_form").submit();
}


</script>
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
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.msgBox.js"></script>
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/msgBoxLight.css"/>
  <script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.blockUI.js"></script>


<%@include file="/html/common/countryregions.jsp" %>

<script type="text/javascript" src="/BSTheme-theme/js/jquery.nyroModal.custom.min.js"></script>
<script src="/BSTheme-theme/js/regionalStd.js"></script>
<%@include file="/html/common/initmenu.jsp" %>

<div class="rounded_container">

        <div class="rounded_container_contents">

            <h4>
                Link To Regional Manual
             </h4>

			<h5 id="status"></h5>

    		<form id="new_standard_form" target="native-results" method="post" name="new_standard_form" action="<%=SaveStandard%>" class="bbq wizard_form">
            

            <input type="hidden" name="historical_manual_url" id="historical_manual_url" value='<portlet:resourceURL id="getHistoricalManual"></portlet:resourceURL>' />
            <input type="hidden" name="<%=RegionalUtil.REQUEST_PARAM_ID%>" id="<%=RegionalUtil.REQUEST_PARAM_ID%>" value="<%=regManStdView.getStandard().getStdId()%>" />
			<input type="hidden" name="<%=RegionalUtil.REQUEST_PARAM_OBJ_TYP%>" id="<%=RegionalUtil.REQUEST_PARAM_OBJ_TYP%>" value="<%=regManStdView.getStandard().getStdTyp()%>" />
			
            <input type="hidden" name="<%=RegionalUtil.REQUEST_PARAM_HIDDEN_MANUAL_REFERENCES%>" id="<%=RegionalUtil.REQUEST_PARAM_HIDDEN_MANUAL_REFERENCES%>" value="" />
            <input type="hidden" name="<%=RegionalUtil.REQUEST_PARAM_HIDDEN_DEL_MANUAL_REFERENCES%>" id="<%=RegionalUtil.REQUEST_PARAM_HIDDEN_DEL_MANUAL_REFERENCES%>" value="" />

            <input type="hidden" name="<%=RegionalUtil.REQUEST_PARAM_HIDDEN_COMMENT%>" id="<%=RegionalUtil.REQUEST_PARAM_HIDDEN_COMMENT%>" value="" />
		    <input type="hidden" name="<%=RegionalUtil.REQUEST_PARAM_HIDDEN_REGIONS%>" id="<%=RegionalUtil.REQUEST_PARAM_HIDDEN_REGIONS%>" value="" />
		
		     <%
               String recType = "";
               if(regManStdView.getStandard().getStdTyp().equals(RegionalUtil.STD_TYPE_STANDARD)) { 
            	recType="Standard";
                }else if(regManStdView.getStandard().getStdTyp().equals(RegionalUtil.STD_TYPE_SPEC)) { 
                recType = "Specification";
                } else {
                recType = "Guideline";
                }
             %>
		
		 		<div class="field_wrapper">
 
                    <span id="fourth_step" class="step">
                      
                        
             <div>
				<label class="header_label" title="Header Standard Text"><span class="header_span_title"><%=recType%> Text: </span>
				    <%
				       if(regManStdView.getStandard().getStdTyp().equals(RegionalUtil.STD_TYPE_STANDARD) || regManStdView.getStandard().getStdTyp().equals(RegionalUtil.STD_TYPE_SPEC)) { %>
				        <span class="header_span_manual_reference" id="header_rec_title"><%=RegionalUtil.getValueOrBlank(regManStdView.getStandard().getTitle()) == null ? "" : RegionalUtil.getValueOrBlank(regManStdView.getStandard().getTitle())%></span>             
				    <% } else { %>
				        <span class="header_span_manual_reference" id="header_rec_title" style="text-align:left;"><%=RegionalUtil.getValueOrBlank(regManStdView.getStandard().getDescription()) == null ? "" : RegionalUtil.getValueOrBlank(regManStdView.getStandard().getDescription())%></span>             
				    <% } %>
				</label>
            </div>
            <%if(regManStdView.getStandard().getStdId() > 0) {%>
            <div class="clear_header"></div>
            <div>
				<label class="header_label" title="Header Standard Id"><span class="header_span_title"><%=recType%> ID: </span>
				    <span class="header_span_manual_reference"><%=regManStdView.getStandard().getStdId() < 1 ? "" : regManStdView.getStandard().getStdId()%></span>             
				</label>            
			</div> 
			<%} %>
                        
                            <%
		                            List<StandardsHistoricalManual> manuals = regManStdView.getStandardsHistoricalManuals();
                            %>
                     
                    
                    <div class="clear"></div>
                    
                    <div class="hidden_form_contents">
                   
                    <div class="divider">&nbsp;</div>
                    
                        <p class="italic_text">Filter Historical Sources</p>
                        
                        <label class="wrapper_label" for="manual_type" title="Manual Type label"><span class="wrapper_span">Manual Type</span>                
                            <select id="manual_type" class="multis" name="manual_type" title="manual type select">
                                <option value="">Select</option>
                                <option value="OFFCL_STND_MNL">Official Standards Manual</option>
                                <option value="RSRCS">Resources</option>
                                <option value="GDLN">Guidelines</option>
                                <option value="SPCFCTN">Specifications</option>
                                <option value="OTHER">Other</option>
                            </select>        
                        </label>
                     
                           <label class="wrapper_label" for="manuals_brand" title="manual brand label"><span class="wrapper_span">Applicable Brands</span>
                            <div class="brands">
                            <select id="manuals_brand" class="multis combo_select_width" name="manuals_brand" title="manual brand select" multiple="multiple">
                            
                          <%
							 List<ChainStandards> selectedChainStnds = regManStdView.getChainStandards();
				
									for(String chncode : chnCdMap.keySet())
									{
										if(RegionalUtil.contains(selectedChainStnds, chncode))
										{
								%> 
											<option value="<%=chncode%>" selected="selected"><%=chnCdMap.get(chncode)%></option>
								<%
										}
										else {
								%>
											<option value="<%=chncode%>"><%=chnCdMap.get(chncode)%></option>
								<%													
										}
									}
								//}
							%> 
                            </select>
                            </div>
                        </label>
                         <div class="clear"></div>
                        
                        <label class="wrapper_label" title="Historical Manual button label"><span class="wrapper_span">&nbsp;</span>  
                            <div class="button"><a href="#" class="filter_contents" title="Historical Manual filter button">Filter</a><span></span></div>
                            
                        </label> 
                        <div class="clear"></div>
                        <div class="divider">&nbsp;</div>
                        
                        <p class="italic_text">Add Historical Reference(s)</p>
                        <p class="file_instructions">1. Select the manual > 2. Select the type of change from this manual > 3. Add a reference to the historical standard > 4. Click 'Add Reference'</p>
                        
                        <label class="wrapper_label" for="brand_manual" title="Brand Manual label"><span class="wrapper_span">
                        <em class="required">* </em>Brand Manual</span>
                            <select id="brand_manual" name="brand_manual" class="single_select combo_select_width" title="Brand Manual Select">
                                <option value="">Click the filter button</option>
                            </select> 
                        </label>
                        <div class="clear"></div>
                        
                        <label class="wrapper_label" for="change_type" title="Change type from selected manual label"><span class="wrapper_span">Change type from selected manual</span>
                            <select id="change_type" name="change_type" class="single_select" title="Change type from selected manual">
                                <option value="NEW">New</option>
                                <option value="NO_CHANGE">No change</option>
                                <option value="TEXT_CHANGE">Textual change</option>
                                <option value="MATERIAL_CHANGE">Material change</option>
                            </select>
                        </label>
                        <div class="clear"></div>
                        
                        <label class="wrapper_label" for="title_code_page" title="Standard Title / Code / Page / Paragraph label"><span class="wrapper_span_char_count">
                             <em class="required">* </em>Standard Title / Code / Page &amp; Paragraph</span>              
                            <input type="text" class="input_text" name="title_code_page" id="title_code_page" title="Standard Title / Code / Page / Paragraph" maxlength="500"/>             
                        </label>
                        <div class="clear"></div>
                        
                        <label class="wrapper_label" title="Add Reference button label"><span class="wrapper_span">&nbsp;</span>  
                            <div class="button"><a href="#" class="add_reference" title="add reference to a historical manual button">Add Reference</a><span></span></div>
                        </label> 
                        <div class="clear"></div>
                                     
                        <table id="reg_references" summary="References">
                            <tr class="spec_links_header">
                                <td style="display:none;"></td>  <!-- stdManualId -->
                                <td style="display:none;"></td>  <!-- manualId -->
                                <td><strong>Brand</strong></td>
                                <td><strong>Region</strong></td>
                                <td><strong>Change Type</strong></td>
                                <td><strong>Manual</strong></td>
                                <td><strong>Title / Code</strong></td>
                                <td></td>
                            </tr>
                            
                            <%
                            if(!RegionalUtil.isNullOrBlank(manuals)) { 
                                for(StandardsHistoricalManual manual : manuals)
                                {
                                	boolean hasDeleteAccess = RegionalUtil.hasDeleteAccess(user, manual); if(hasDeleteAccess){ %>
                                    <tr class="table_links_list"><td style="display:none;" class="standard_file_type_td this_link"><%= manual.getStdMnlId()%><input type="hidden" value="~~~id:<%= manual.getStdMnlId()%>"/></td><td style="display:none;" class="standard_file_type_td this_link"><%= manual.getHistManualId()%><input type="hidden" value="<%= manual.getHistManualId()%>"/></td><td class="standard_file_type_td this_link"><%= RegionalUtil.decodeChainCode(manual.getChain())%><input type="hidden" value="<%= manual.getChain()%>"/></td><td class="standard_file_type_td this_link"><%= RegionalUtil.decodeRegionCode(manual.getRegion())%>
                                    <input type="hidden" id="region_<%= manual.getStdMnlId()%>"  value="<%=hasDeleteAccess%>"/></td><td class="standard_file_type_td this_link"><%= RegionalUtil.decodeChangeCode(manual.getChange())%><input type="hidden" value="<%= manual.getChange()%>"/></td><td class="standard_file_type_td this_link"><%= manual.getHistManualTitle()%><input type="hidden" value="<%= manual.getHistManualType()%>"/></td><td class="standard_file_type_td this_link"><%= manual.getTitle()%><input type="hidden" value="<%= manual.getTitle()%>"/></td>
                                    <td><img class="delete_manual_reference" src="/BSTheme-theme/images/delete.png" alt="Delete Historical Manual img" title="Delete Historical Manual Reference"/></td>
                                    </tr>
                                    <%}else
                                    {%>
                                     <tr class="table_links_list"><td style="display:none;" class="standard_file_type_td this_link"><%= manual.getStdMnlId()%><input type="hidden" value="~~~id:<%= manual.getStdMnlId()%>"/></td><td style="display:none;" class="standard_file_type_td this_link"><%= manual.getHistManualId()%><input type="hidden" value="<%= manual.getHistManualId()%>"/></td><td class="standard_file_type_td this_link"><%= RegionalUtil.decodeChainCode(manual.getChain())%><input type="hidden" value="<%= manual.getChain()%>"/></td><td class="standard_file_type_td this_link"><%= RegionalUtil.decodeRegionCode(manual.getRegion())%>
                                    <input type="hidden" id="region_<%= manual.getStdMnlId()%>"  value="<%=hasDeleteAccess%>"/></td><td class="standard_file_type_td this_link"><%= RegionalUtil.decodeChangeCode(manual.getChange())%><input type="hidden" value="<%= manual.getChange()%>"/></td><td class="standard_file_type_td this_link"><%= manual.getHistManualTitle()%><input type="hidden" value="<%= manual.getHistManualType()%>"/></td><td class="standard_file_type_td this_link"><%= manual.getTitle()%><input type="hidden" value="<%= manual.getTitle()%>"/></td>
                                    <td><img class="delete_manual_reference" src="/BSTheme-theme/images/delete_not.png" alt="Can't Delete Historical Manual img" title="Can't Delete Historical Manual Reference"/></td>
                                    </tr>
                                   <% }
                                } 
                            }
                            %>
                        </table>
                        <br/>
                        <div class="file_uploader_advice"><em class="required">Click the Add Reference button above to add more historical links.</em></div>

                    </div><!--ends hidden content -->
                    <div class="clear"></div>
                  	 
                    </span>
                    
				</div>

				<div class="wizard_navigation"> 							

			      <input class="navigation_button ui-state-active" id="form_submit" value="Submit" type=button onClick="showComments();" />
			      <!--  <input class="navigation_button" id="next" value="Submit" type="submit" title="Submit" /> -->
					
					<%
					HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(request);
					long expandStdId = httpRequest.getParameter(BrandStandardsUtil.REQUEST_PARAM_STD_ID) == null ? 0L : Long.parseLong(httpRequest.getParameter(BrandStandardsUtil.REQUEST_PARAM_STD_ID));
				    int pageNum = httpRequest.getParameter(BrandStandardsUtil.REQUEST_PARAM_PAGE_NUM) == null ? 0 : Integer.parseInt(httpRequest.getParameter(BrandStandardsUtil.REQUEST_PARAM_PAGE_NUM));
				    int recPerPage = httpRequest.getParameter(BrandStandardsUtil.REQUEST_PARAM_REC_PER_PAGE) == null ? 0 : Integer.parseInt(httpRequest.getParameter(BrandStandardsUtil.REQUEST_PARAM_REC_PER_PAGE));
				    String urlQuery = "?pageNum=" + pageNum;
				    if(recPerPage > 0)
				    {
                        urlQuery = urlQuery + "&" + BrandStandardsUtil.REQUEST_PARAM_REC_PER_PAGE + "=" + recPerPage;
				    }
				    if(!regManStdView.getStandard().getStdTyp().equals(RegionalUtil.STD_TYPE_STANDARD)) {
				        urlQuery = urlQuery + "&prntid=" + expandStdId;
				    } 
					%>
                    <input type=button id="form_cancel" class="navigation_button ui-state-active" title="Cancel" onClick="cancelMe('/web/brand-standards/standards<%=urlQuery %>')" value='Cancel'>
				</div>
				
				<div id="comments_div" class="comments_modalwindow_block">
					 <div style="color:#FFFFFF; font-size:13px; text-align:center; margin-top:20px">
					 <div style="float:left;padding-top:25%; padding-right:20px;">Comments </div><div><textarea rows="20" cols="80" name="cmt_txt_area" id="cmt_txt_area" maxlength="2000"></textarea></div>
					 
					 </div>
					 <div class="cmt_button">
					    <input type="button" value="Cancel" name="cancel" id="cmt_close" />
						<input id="next" value="Submit" type="submit" title="Submit" />
			    
					 </div>

				</div>   

			</form>

            <div class="clear"></div>			

			<p id="data"></p>

        </div><!--ends rounded_container_contents -->

        <div class="rounded_container_bottom">&nbsp;</div>

    </div><!--ends rounded_container -->
    
<script language="JavaScript">
var showAlert=false;
jQuery(function(){

<%
String pTitle = ""; 
if(regManStdView.getStandard().getStdTyp().equals(RegionalUtil.STD_TYPE_SPEC)) {
	pTitle = pTitle + "Specification";
} else if(regManStdView.getStandard().getStdTyp().equals(RegionalUtil.STD_TYPE_STANDARD)) {
	pTitle = pTitle + "Standard";
} else {
	pTitle = pTitle + "Guideline";
}

// Update Page Header Title
	 pTitle =pTitle+ " - Link To Regional Manual";


%>
	<%-- jQuery(".grid_12 h2").text(jQuery(".grid_12 h2").text()+ '<%=pTitle%>'); --%>
	jQuery(".grid_12 h2").text('<%=pTitle%>');
});
</script>

 
<script type="text/javascript">
<%
if(hasAccess) {
	List<Role> roles = user.getRoles();
	boolean admin = false;
	for(Role role : roles)
	{
		if(role.getName().equalsIgnoreCase(RegionalUtil.AUTHORS_GLOBAL_ROLE) || role.getName().equalsIgnoreCase(RegionalUtil.BRANDSTAND_ADMIN_ROLE)) {
			admin = true;
		}
	}
	if(admin)
	{
%>
		authorRegions.push("AMEA");
		authorRegions.push("AMER");
		authorRegions.push("EURO");
		authorRegions.push("GC"); 
<%			
	}
	else 
	{
		for(Role role : roles)
		{
			if(role.getName().equalsIgnoreCase(RegionalUtil.AUTHORS_AMEA_ROLE)) {
%>				authorRegions.push("AMEA");
<%			} if(role.getName().equalsIgnoreCase(RegionalUtil.AUTHORS_AMER_ROLE)) {
%>				authorRegions.push("AMER");
<%			} if(role.getName().equalsIgnoreCase(RegionalUtil.AUTHORS_EUROPE_ROLE)) {
%>				authorRegions.push("EURO");
<%			} if(role.getName().equalsIgnoreCase(RegionalUtil.AUTHORS_GC_ROLE)) {
%> 				authorRegions.push("GC");
<%			}
		}
	}
}
%>

jQuery(function(){
	jQuery("#hidden_regions").val(authorRegions);
	
	jQuery('.filter_contents').trigger('click');
});


</script>


<%
	} else {
%>
	Not logged in !!
<%
	}
%>