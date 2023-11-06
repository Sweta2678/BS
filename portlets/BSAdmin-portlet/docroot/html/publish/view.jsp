<%@include file="/html/init.jsp" %>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.ihg.brandstandards.util.BrandStandardsUtil"%>
<%@page import="com.ihg.brandstandards.report.ReportConfig"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.List"%>
<portlet:resourceURL var="submitURl" id="validate" />

<%
long userId = PortalUtil.getUserId(renderRequest);
String email = null;
if (userId > 1)
{
    email = user.getDisplayEmailAddress();
    Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap();
    Long lockedStdCount = request.getAttribute("lockedStdCount") == null ? 0L : (Long) request.getAttribute("lockedStdCount");
%>

<script type="text/javascript" src="/BSTheme-theme/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery-ui-1.10.1.custom.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.validate.min-1.11.1.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/additional-methods.min-1.11.1.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.form.3.28.0.js"></script>

<script type="text/javascript" src="/BSTheme-theme/js/jquery.timepicker.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.ui.datepicker.validation.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.multiselect.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.blockUI.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.msgBox.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.nyroModal.custom.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/publish.js"></script>

<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/msgBoxLight.css" />
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/jquery.multiselect.css" />
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/jquery.timepicker.css" />
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/other/jquery-ui-1.10.1/themes/base/jquery.ui.all.css" />
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/publish.css" />
 
<div id="selectOptions" class="select_options">
    <div class="locked_rec_cont_div">
    <%if (lockedStdCount > 0) { %>
	<span class="locked_rec_note">Locked records: <%=lockedStdCount %></span>
    <%} else { %>
    <span class="no_locked_rec_note">There are no locked records</span>
    <%} %>
    </div>
    <input type="button" class="release_rec_button" id="release_rec_button" value="Release All Locked Records" title="Release All Locked Records button" />
</div>
<br>

<div class="rounded_container">
	<div class="rounded_container_contents">

      <input type="hidden" name="hist_data_url" id="hist_data_url" value='<portlet:resourceURL id="getHistData"></portlet:resourceURL>' />
      <input type="hidden" name="release_rec_url" id="release_rec_url" value='<portlet:resourceURL id="releaseLockedRecords"></portlet:resourceURL>' />
      <input type="hidden" name="create_manual_url" id="create_manual_url" value='<portlet:resourceURL id="createManuals"></portlet:resourceURL>' />
      <input type="hidden" name="run_report_url" id="run_report_url" value='<portlet:resourceURL id="runReport"></portlet:resourceURL>' />
      <input type="hidden" name="get_locales_url" id="get_locales_url" value='<portlet:resourceURL id="getBrandLocales"></portlet:resourceURL>' />

      <div id="pub_tabs">
        <ul>
            <li><a href="#pub_tabs_stage">Publish Staging</a></li>
            <li><a href="#pub_tabs_prod">Publish Production</a></li>
            <li><a href="#pub_tabs_hist_prod">Production Publish History</a></li>
        </ul>

      <div id="pub_tabs_stage">
      
		<form id="publishAdminForm" name="publishAdminForm" enctype="multipart/form-data" method="post" action="<%=submitURl%>" >
        
        <input type="hidden" name="confirmed_url" id="confirmed_url" value='<portlet:resourceURL id="confirmed"></portlet:resourceURL>' />
<!--        <input type="hidden" name="fetchLocalesStdId" id="fetchLocalesStdId" value="false" /> -->
        
        <div class="initial_data" id="initial_data_div">
            <span class="header_note">Your request can take sometime to process. You will be notified by email once your request has been completed. Please verify your email
        address in the field below.</span> 
            <div class="clear"></div>

			<label class="wrapper_label" for="uploadFile" title="Select File to Upload"><span class="wrapper_span"><em class="required">* </em>File to Upload: 
			    <a class="help_icon tooltip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" />
			        <span class="classic">Comma separated text file or Excel file (xls) containing list of Standard IDs to publish.</span></a></span> 
			    <input class="input_text upload_ids_file required" type="file" name="uploadFile" id="uploadFile" /> 
			</label>

			<div class="clear"></div>
 					
			<label class="wrapper_label" title="Expected Production Publish Date"><span class="wrapper_span"><em class="required">* </em>Expected Production Publish Date:</span>
			    <input type="text" class="datepicker required" readonly="readonly" name="dateInput" id="dateInput" />
			    <span class="time_text_box"><input type="text" name="timeInput" id="timeInput" class="small_text_box required" />
                <img class="ui-timepicker-trigger" src="/BSTheme-theme/images/analog-clock.png" alt="select time" title="select time"></span>
			</label>
 				
            <div class="clear"></div>

            <label class="wrapper_label" title="Publish Schedule"><span class="wrapper_span"><em class="required">* </em>Publish Schedule:</span>
                <input id="publish_off_hours" name="pub_schedule" type="radio" value="PUBLISH_OFF_HOURS" checked="checked" /> Publish Later (recommended) 
                <input id="publish_now" name="pub_schedule" type="radio" value="PUBLISH_NOW" /> Publish Now
            </label>
                
            <div class="clear"></div>
				
			<label class="wrapper_label" for="selectBrand" title="Publish Brand"><span class="wrapper_span"><em class="required">* </em>Publish Brand:</span>
				<select id="selectBrand" name="selectBrand" class="single_select required" title="This field is required." >
					<option value="">Select</option>
                    <%  
                    for(String chncode : chnCdMap.keySet())
                    {   
                    %>  
                    <option value='<%=chncode%>'><%=chnCdMap.get(chncode)%></option> 
                    <%
                    }%> 
				</select>
			</label>
 				
            <div class="clear"></div>

            <label class="wrapper_label" for="selectLocale" title="Publish Locale"><span class="wrapper_span"><em class="required">* </em>Publish Language:</span>
                <select id="selectLocale" name="selectLocale" class="multis required" multiple="multiple" title="This field is required." >
                    <!--<option value="en_GB">English UK</option>-->
                </select>
                <span id="locale_err_span"></span>
            </label>
                 
            <div class="clear"></div>
			<label class="wrapper_label" title="Notification Email Address"><span class="wrapper_span"><em class="required">* </em>Notification Email Address:</span>
				<input class="input_text email_text required" type="text" id="emailField" name="emailField" value=<%=email %> title="This field is required." maxlength="500" />
			</label>
				
            <div class="clear"></div>
			
		    <div style="margin-left:50%;">
                 <input type="submit" id="validate" name="validateButton" value="Validate" title="Validate form" />  
			</div>
        
        </div>
        
        <div class="confirm_data" id="confirm_data_div" style="overflow:hidden;display:none">
                <div class="clear"></div>
                <label class="wrapper_label"><span class="wrapper_span">Publish Environment:</span><div style="padding-top:5px;" ><span id="displ_environment"></span></div></label>
                <div class="clear"></div>
                <label class="wrapper_label"><span class="wrapper_span">Publish Schedule:</span><div style="padding-top:5px;" ><span id="displ_date"></span></div></label>
                <div class="clear"></div>
                <label class="wrapper_label"><span class="wrapper_span">Expected Production Publish Date:</span><div style="padding-top:5px;" ><span id="displ_schedule_date"></span>&nbsp;&nbsp;&nbsp;&nbsp;<span id="displ_schedule_time"></span></div></label>
                <div class="clear"></div>
                <label class="wrapper_label"><span class="wrapper_span">Publish Brand:</span><div style="padding-top:5px;" ><span id="displ_brand"></span></div></label>
                <div class="clear"></div> 
                <label class="wrapper_label"><span class="wrapper_span">Publish Language:</span><div style="padding-top:5px; display: flex;" ><span id="displ_locale"></span></div></label>
                <div class="clear"></div> 
                <label class="wrapper_label"><span class="wrapper_span">Notification Email Address:</span><div style="padding-top:5px;" ><span id="displ_email"></span></div></label>
                <div class="clear"></div>
                <label class="wrapper_label"><span class="wrapper_span">Publish IDs:</span>
                    <div class="div_displ_id_less" style="padding-top:5px;" ><span id="displ_id_less"></span><a class="displ_more_ids" href="#">&nbsp;&nbsp;More</a></div>
                    <div class="div_displ_id_more" style="padding-top:5px;width:690px;overflow:hidden;display:none"><span id="displ_id_more"></span><a class="displ_less_ids" href="#">&nbsp;&nbsp;Less</a></div>
                </label>
                <div class="clear"></div>
                <div class="clear"></div>
      
                <div style="margin-left:43%;">
                    <input type="button" name="cancelButton" id="cancel_confirm" value="Cancel" title="Cancel form" onClick="location.href='/web/brand-standards/publish'" /> 
                    <input type="button" name="confirmButton" id="confirm" value="Confirm" title="Submit form" />
                </div>
        </div>

            <div class="error_data" id="errorm_data_div" style="overflow:hidden;display:none">
                <div class="clear"></div>
                <div class="div_displ_error" style="padding-top:5px;" ><span id="displ_error"></span></div>
                <div class="clear"></div>
                <div class="clear"></div>
      
                <div style="margin-left:43%;">
                    <input name="cancel" id="cancel_error" type="button" value="Cancel" title="Cancel form" onClick="location.href='/web/brand-standards/publish'" /> 
                </div>
            </div>
        </form>
      </div>
      <div id="pub_tabs_prod">

          <input type="hidden" name="del_schedule_url" id="del_schedule_url" value='<portlet:resourceURL id="deleteSchedule"></portlet:resourceURL>' />
          <span class="header_note">Publish desired Brand's data from Staging to Production.</span>
          
          <div class="clear"></div>
          
        <table id="publish_stg_hist_table" class="publish_hist_table" summary="This table contains data from Publish Queue table for Staging.">
            <tr class="pub_tbl_header">
                <td><strong>Id</strong></td>
                <td><strong>Brand</strong></td>
                <td><strong>Status</strong></td>
                <td><strong>Expected Production Publish Date</strong></td>
                <td><strong>Publish Schedule</strong></td>
                <td><strong><span class="pub_locale_heared">Language</span></strong></td>
<!--                 <td><strong>Start Date</strong></td>
                <td><strong>End Date</strong></td> -->
                <td><strong><span class="pub_email_header">Email</span></strong></td>
                <td><strong>Scheduled By</strong></td>
                <td><strong>Create Report</strong></td>
                <td><strong>Create Manuals</strong></td>
                <td><strong>Publish to Production</strong></td>
            </tr>
          </table>
      </div>
      <div id="pub_tabs_hist_prod">

          <span class="header_note">Historical table for Production environment contains up to 25 requests for publishing.</span>
          
          <div class="clear"></div>
          
        <table id="publish_prod_hist_table" class="publish_hist_table" summary="This table contains data from Publish Queue table for Producton.">
            <tr class="pub_tbl_header">
                <td><strong>Id</strong></td>
                <td><strong>Brand</strong></td>
                <td><strong>Status</strong></td>
                <td><strong>Schedule Date</strong></td>
                <td><strong>Start Date</strong></td>
                <td><strong>End Date</strong></td>
                <td><strong><span class="pub_hist_locale_heared">Language</span></strong></td>
                <td><strong><span class="pub_hist_email_header">Email</span></strong></td>
                <td><strong>Scheduled By</strong></td>
                <td><strong>Delete</strong></td>
            </tr>
          </table>
      </div>
    </div>
	</div>
	<!--ends rounded_container_contents -->
	<div class="rounded_container_bottom">&nbsp;</div>
</div>

<!-- Report pop-up --> 

<div id="report_container" class="report_container">
    <%List<ReportConfig> reportConfigs = (List<ReportConfig>) request.getAttribute("reportConfigs"); %>
    <div class="reports">
        <p class="report_instructions">Choose a report, then click 'run'. <br/>Only one report can be run at a time.</p>
            <div class="reportsContent">
                <ul>
                <%for (ReportConfig entry : reportConfigs) {
                    if ("PublishAdmin".equals(entry.getFeature())) {
                %>
                    <li>
                        <input type="radio" class="report_checkbox" value="<%=entry.getId() %>" name="export_report" id="content_report_<%=entry.getId()%>"  report_type="content_report" title="Content Report: <%=entry.getName() %>" />
                        <label for="content_report_<%=entry.getId()%>" class="report_label"><%=entry.getName() %></label>
                    </li>
                <%  }
                  }%>
                </ul>
            </div>
        <div class="clear"></div>
        <div class="button report_run"><a href="#" class="run_reports" title="Run Report">Run</a><span></span></div>
        <div class="button report_run"><a href="#" class="cancel_reports" title="Cancel Report">Cancel</a><span></span></div>
    </div>
</div>
<!-- End of Report pop-up --> 

<%
}
else
{
%>	
	Not logged in !!	
<%	
}
%>

<!--ends rounded_container -->
