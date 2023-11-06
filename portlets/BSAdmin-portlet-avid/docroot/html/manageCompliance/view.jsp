<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.ihg.brandstandards.db.model.ChainStandards"%>
<%@page import="com.ihg.brandstandards.bsadmin.model.ComplianceView"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsComplianceExt"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@include file="/html/standards/init.jsp" %>
<script type="text/javascript" src="/BSTheme-theme/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery-ui-1.10.1.custom.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.nyroModal.custom.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.msgBox.js"></script>
<script src="/BSTheme-theme/js/jquery-ui-multiselect-widget.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/manageCompliance.js"></script>
<link href="/static/apps/brandstandards/assets/other/jquery-ui-1.10.1/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="/static/apps/brandstandards/assets/css/jquery.multiselect.css" />
<link type="text/css" rel="stylesheet" href="/static/apps/brandstandards/assets/css/bsstyle.css" />
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/msgBoxLight.css"/>
<!-- <link type="text/css" rel="stylesheet" href="/static/apps/brandstandards/assets/css/msgBoxLight.css"/> -->
<link type="text/css" rel="stylesheet" href="/static/apps/brandstandards/assets/css/manageCompliance.css" />

<portlet:resourceURL var="complianceBrand" id="complianceBrand"/>
<portlet:resourceURL var="countryAttribution" id="countryAttribution" />
<%
long stdId = (Long) request.getAttribute("id"); 
ArrayList<ChainStandards> arlChainStandards = (ArrayList)request.getAttribute("chainStandards");
ArrayList<ComplianceView> arlComplianceByBrand = (ArrayList)request.getAttribute("arlComplianceByBrand");
//String chainCode = (String) request.getAttribute("chainCode");
boolean isGlobalUser = (StandardsUtil.isSuperAdmin(user.getRoles())) || (StandardsUtil.getUserRegionFromUserRole(user.getRoles()).equals("GLBL"));
String userRegion = "GLBL";
if(!isGlobalUser)
{
	userRegion = StandardsUtil.getUserRegionFromUserRole(user.getRoles());
}
%>
 <script>
 var complianceByBrand = '<%=complianceBrand%>';
jQuery(function() {
	jQuery( "#accordion_chn" ).accordion( {
			collapsible: true,
	        active: false  } );
	jQuery('#accordion_chn h3').bind('click', function (e) {
		var selected = jQuery("#accordion_chn").accordion("option", "active");
		var accrodianName = jQuery.trim(jQuery(this).text());
		var accordionCode = $(this).attr('id').substring('changeBrandAccordion_'.length, $(this).attr('id').length);
		jQuery('#complianceSelect_'+accordionCode).val("true");
	});
	
	function viewCompliance(brandVal) {
		//if (jQuery('#compliance_'+brandVal+"_check").val() != 'true') {
			//alert("inside viewCompliance "+complianceByBrand);
			var url = complianceByBrand;
			var stdId = <%=stdId%>;
			var inData = {stdId:stdId,chainCode:brandVal};
			jQuery.ajax({
				type: "POST",
				url: url,
				data: inData,
			}).done( function(data) {
				   jQuery('#manageCompliance_'+brandVal).html(data);
				//   jQuery('#compliance_'+brandVal+"_check").val("true");
			}).fail( function(jqXHR, textStatus) {
					alert("AJAX request failed with status:" + textStatus);
			});
		//}
	}
	
	
	var dateToday = new Date();
	jQuery( ".Inputdatepicker" ).datepicker({
		showOn: "button",
		buttonImage: "/BSTheme-theme/images/calendar_small_icon.png",
		buttonImageOnly: true,
		buttonText: "Select date",
		dateFormat: 'dd-M-yy',
		minDate: dateToday
	});
	
	//var selectedOnLoad = jQuery('#globalrule_'+chnCode).val();

	
});

function showHideComplianceDiv(nodeValue, chainCode){
	//alert("inside showHideComplianceDiv "+nodeValue+" "+chainCode);
	  if(nodeValue=='compliance_'+chainCode)
	  {		//alert("inside complaince_"+chainCode);
			jQuery("#compliance_"+chainCode).show();
			jQuery("#expiry_"+chainCode).hide();
			jQuery("#expiryRadio_"+chainCode).prop('checked', false);
	  }
	  else if(nodeValue=='expiry_'+chainCode)
	  {		//alert("inside expiry_"+chainCode);
	  		jQuery("#expiry_"+chainCode).show();
			jQuery("#compliance_"+chainCode).hide();
			jQuery("#complianceRadio_"+chainCode).prop('checked', false);
	 }

}
function showHideRuleDiv(nodeValue,chainCode){
	//alert("inisde show hide rule div");
	if(nodeValue=='rule_'+chainCode)
	  {
			 jQuery(".showHide_rule_"+chainCode).show();
			 jQuery(".showHide_date_"+chainCode).hide();
			 jQuery("#dateRadio_"+chainCode).prop('checked', false);
	  }
	  else if(nodeValue=='date_'+chainCode)
	  {
			jQuery(".showHide_rule_"+chainCode).hide();
			jQuery(".showHide_date_"+chainCode).show();
			jQuery("#ruleRadio_"+chainCode).prop('checked', false);
	 }
	
}
function changeRule(chnCode)	
{
	 var selectedValue = jQuery('#globalrule_'+chnCode).val();
	 jQuery('#amearule_'+chnCode).val(selectedValue);
	 jQuery('#amerrule_'+chnCode).val(selectedValue);
	 jQuery('#eurorule_'+chnCode).val(selectedValue);
	 jQuery('#gcrule_'+chnCode).val(selectedValue);
}

function changeExpDate(chnCode)
{
	var selectedValue = jQuery('#glblexdate_'+chnCode).val();
	  jQuery('#ameaexdate_'+chnCode).val(selectedValue);
	  jQuery('#amerexdate_'+chnCode).val(selectedValue);
	  jQuery('#euroexdate_'+chnCode).val(selectedValue);
	  jQuery('#gcexdate_'+chnCode).val(selectedValue);
}

function deleteExpDate(chnCode)
{
	var selectedValue = jQuery('#glblexdate_'+chnCode).val();
	var selectedValueLength = jQuery('#glblexdate_'+chnCode).val().length;
	if(selectedValueLength > 0 && selectedValue!=""){
		jQuery("#delglblexdate_"+chnCode).val("GLB_DelExpDate");
		jQuery('#delameaexdate_'+chnCode).val("AMEA_DelExpDate");
		jQuery('#delamerexdate_'+chnCode).val("AMER_DelExpDate");
		jQuery('#deleuroexdate_'+chnCode).val("EURO_DelExpDate");
		jQuery('#delgcexdate_'+chnCode).val("GC_DelExpDate");
	} else {
		showDeleteErrorMsgBox();
		//alert("Please select a date first.");
		return false;
	}
	jQuery('#glblexdate_'+chnCode).val("");
	jQuery('#ameaexdate_'+chnCode).val("");
	jQuery('#amerexdate_'+chnCode).val("");
	jQuery('#euroexdate_'+chnCode).val("");
	jQuery('#gcexdate_'+chnCode).val(""); 
	
}

function deleteAmeaExpDate(chnCode){
	 var ameaSelectedVal = jQuery('#ameaexdate_'+chnCode).val();
	 var ameaSelectedValLength = jQuery('#ameaexdate_'+chnCode).val().length;
	 if(ameaSelectedValLength > 0 && ameaSelectedVal != ""){
		 jQuery('#delameaexdate_'+chnCode).val("AMEA_DelExpDate");
	 } else {
		 //alert("Please select a date first.");''
		 showDeleteErrorMsgBox();
		return false;
	 }
	 
	 jQuery('#ameaexdate_'+chnCode).val("");
}

function deleteAmerExpDate(chnCode){
	 var ameaSelectedVal = jQuery('#amerexdate_'+chnCode).val();
	 var ameaSelectedValLength = jQuery('#amerexdate_'+chnCode).val().length;
	 if(ameaSelectedValLength > 0 && ameaSelectedVal != ""){
		 jQuery('#delamerexdate_'+chnCode).val("AMER_DelExpDate");
	 } else {
		 //alert("Please select a date first.");
		 showDeleteErrorMsgBox();
		return false;
	 }
	 
	 jQuery('#amerexdate_'+chnCode).val("");
}

function deleteEuroExpDate(chnCode){
	 var ameaSelectedVal = jQuery('#euroexdate_'+chnCode).val();
	 var ameaSelectedValLength = jQuery('#euroexdate_'+chnCode).val().length;
	 if(ameaSelectedValLength > 0 && ameaSelectedVal != ""){
		 jQuery('#deleuroexdate_'+chnCode).val("EURO_DelExpDate");
	 } else {
		 //alert("Please select a date first.");
		 showDeleteErrorMsgBox();
		return false;
	 }
	 
	 jQuery('#euroexdate_'+chnCode).val("");
}

function deleteGCExpDate(chnCode){
	 var ameaSelectedVal = jQuery('#gcexdate_'+chnCode).val();
	 var ameaSelectedValLength = jQuery('#gcexdate_'+chnCode).val().length;
	 if(ameaSelectedValLength > 0 && ameaSelectedVal != ""){
		 jQuery('#delgcexdate_'+chnCode).val("GC_DelExpDate");
	 } else {
		 //alert("Please select a date first.");
		 showDeleteErrorMsgBox();
		return false;
	 }
	 
	 jQuery('#gcexdate_'+chnCode).val("");
}

function showDeleteErrorMsgBox(){
	jQuery.msgBox({
		 title: "Error!",
		 content: "Please select a date first.",
		 type: "error",
		});
}
function changeCompDate(chnCode)
{
	 var selectedValue = jQuery('#globaldate_'+chnCode).val();
	  jQuery('#ameadate_'+chnCode).val(selectedValue);
	  jQuery('#amerdate_'+chnCode).val(selectedValue);
	  jQuery('#eurodate_'+chnCode).val(selectedValue);
	  jQuery('#gcdate_'+chnCode).val(selectedValue);
}


function deleteAmeaComplianceDate(chnCode){
	 var ameaSelectedVal = jQuery('#ameadate_'+chnCode).val();
	 var ameaSelectedValLength = jQuery('#ameadate_'+chnCode).val().length;
	 if(ameaSelectedValLength > 0 && ameaSelectedVal != ""){
		 jQuery('#delameacmpdate_'+chnCode).val("AMEA_DelComplianceDate");
	 } else {
		 //alert("Please select a date first.");''
		 showDeleteErrorMsgBox();
		return false;
	 }
	 
	 jQuery('#ameadate_'+chnCode).val("");
}

function deleteAmerComplianceDate(chnCode){
	 var ameaSelectedVal = jQuery('#amerdate_'+chnCode).val();
	 var ameaSelectedValLength = jQuery('#amerdate_'+chnCode).val().length;
	 if(ameaSelectedValLength > 0 && ameaSelectedVal != ""){
		 jQuery('#delamercmpdate_'+chnCode).val("AMER_DelComplianceDate");
	 } else {
		 //alert("Please select a date first.");
		 showDeleteErrorMsgBox();
		return false;
	 }
	 
	 jQuery('#amerdate_'+chnCode).val("");
}

function deleteEuroComplianceDate(chnCode){
	 var ameaSelectedVal = jQuery('#eurodate_'+chnCode).val();
	 var ameaSelectedValLength = jQuery('#eurodate_'+chnCode).val().length;
	 if(ameaSelectedValLength > 0 && ameaSelectedVal != ""){
		 jQuery('#deleurocmpdate_'+chnCode).val("EURO_DelComplianceDate");
	 } else {
		 //alert("Please select a date first.");
		 showDeleteErrorMsgBox();
		return false;
	 }
	 
	 jQuery('#eurodate_'+chnCode).val("");
}

function deleteGCComplianceDate(chnCode){
	 var ameaSelectedVal = jQuery('#gcdate_'+chnCode).val();
	 var ameaSelectedValLength = jQuery('#gcdate_'+chnCode).val().length;
	 if(ameaSelectedValLength > 0 && ameaSelectedVal != ""){
		 jQuery('#delgccmpdate_'+chnCode).val("GC_DelComplianceDate");
	 } else {
		 //alert("Please select a date first.");
		 showDeleteErrorMsgBox();
		return false;
	 }
	 
	 jQuery('#gcdate_'+chnCode).val("");
}

function deleteComplianceDate(chnCode)
{
	var selectedValue = jQuery('#globaldate_'+chnCode).val();
	var selectedValueLength = jQuery('#globaldate_'+chnCode).val().length;
	if(selectedValueLength > 0 && selectedValue!=""){
		jQuery("#delglblcmpdate_"+chnCode).val("GLB_DelComplianceDate");
		jQuery('#delameacmpdate_'+chnCode).val("AMEA_DelComplianceDate");
		jQuery('#delamercmpdate_'+chnCode).val("AMER_DelComplianceDate");
		jQuery('#deleurocmpdate_'+chnCode).val("EURO_DelComplianceDate");
		jQuery('#delgccmpdate_'+chnCode).val("GC_DelComplianceDate");
	} else {
		showDeleteErrorMsgBox();
		//alert("Please select a date first.");
		return false;
	}
	jQuery('#globaldate_'+chnCode).val("");
	jQuery('#ameadate_'+chnCode).val("");
	jQuery('#amerdate_'+chnCode).val("");
	jQuery('#eurodate_'+chnCode).val("");
	jQuery('#gcdate_'+chnCode).val(""); 
	
}
</script>

<style>.aui .ManagecomplianceTable {
width: 100%;
}
.aui .ManagecomplianceTable td {
padding: 5px;
width:180px;
}
.aui .ManagecomplianceTable img.ui-datepicker-trigger {
width: 25px !important;
height: 25px !important;
margin-top: -4px;
}
.aui .ManagecomplianceTable input.Inputdatepicker {
width: 90px;
padding: 4px;
margin-top: 1px;
border: 1px double #BFBFBF;
}
.aui .a-BT, .aui .a-BT:hover {
	color: #fff; 
	font-family: Verdana,Arial,sans-serif;
    font-size: 1em;
	border-radius: 4px;
	border: 1px double #c8c9ca;
	padding: 5px;
	font-weight: bold;
	display: inline-block;
	text-decoration: none;
}
.aui .darkBT, .aui .darkBT:hover{
	background: none repeat scroll 0px 0px #004ea1;
	
}
.aui .greyBT, .aui .greyBT:hover {
    background: none repeat scroll 0 0 #eeeeee;
    color: #aaaaaa;
	cursor: default;
}
.aui .lightBT, .aui .lightBT:hover {
    background: none repeat scroll 0 0 #cce5f1;
    color: #000;
}

.aui .manageCompliance_section span {
    display: inline-block;
}
</style>
<%

%>
<portlet:actionURL name="saveComplianceRule" var="saveComplianceRuleURL">
	<portlet:param name="id" value="${id}"></portlet:param>
	<portlet:param name="urlQuery" value="${urlQuery}"></portlet:param>
</portlet:actionURL>

<div class="grid_12">
	<div class="rounded_container">
        <div class="rounded_container_contents">
        <form id="complianceForm" method="post" action="<%= saveComplianceRuleURL %>" class="bbq" >
        
        <div id="stdDetails"><h4><%=stdId %></h4>&nbsp;<%=StandardsLocalServiceUtil.getStandards(stdId).getTitle()%></div>
        <div id="accordion_chn">
			<%
			for(ComplianceView complianceView: arlComplianceByBrand)
				{
					Map<String, String> arlRegions = new HashMap<String,String>();
					arlRegions = complianceView.getAssociatedRegions();
					Map<Long, String> months = complianceView.getValidMonths();
				
					Map<String, String> publishRegion = new LinkedHashMap<String, String>();
					publishRegion = complianceView.getComplianceDate();
					boolean isGlobal = false;
					boolean isAmer = false;
					boolean isAmea = false;
					boolean isEuro = false;
					boolean isGc = false;
					String amer ="";
					String euro ="";
					String amea = "";
					String gc ="";
					String glbl = "";
					String amerdate ="";
					String eurodate ="";
					String ameadate = "";
					String gcdate ="";
					String glbldate = "";
					String compRule ="";
					String ruleDate = "";
					String selected = "selected";
					String brand = complianceView.getSelectedBrand();
					//Basd on publication show comply date and disable drop box and date field
					boolean isGlblPublish = false;
					boolean isAmerPublish = false;
					boolean isAmeaPublish = false;
					boolean isEuroPublish = false;
					boolean isGcPublish = false;
					String glblCompDate = "";
					String amerCompDate = "";
					String ameaCompDate = "";
					String euroCompDate = "";
					String gcCompDate = "";
					String isAmeaExpiry ="";
					String isAmerExpiry ="";
					String isEuroExpiry ="";
					String isGcExpiry ="";
					
					
					List<StandardsComplianceExt> arlComplianceExt = complianceView.getArlStdCompliance();
					for(StandardsComplianceExt stdComp: arlComplianceExt)
					{
						
						ruleDate = !(complianceView.isSuperAdmin() || complianceView.isGlobalAuthor()) && stdComp.getComplianceExpiryRule().equals("E") ?  "R" : stdComp.getRuleDate();
						compRule = !(complianceView.isSuperAdmin() || complianceView.isGlobalAuthor()) ?  "C" : stdComp.getComplianceExpiryRule();
						
						if(compRule.equals("C") && ruleDate.equals("R"))
						{
							if(stdComp.getRegionCode().equals("AMER"))
							{
								amer = String.valueOf(stdComp.getComplianceRuleMonths());
								
							}
							if(stdComp.getRegionCode().equals("EURO"))
							{
								euro = String.valueOf(stdComp.getComplianceRuleMonths());
							}
							if(stdComp.getRegionCode().equals("AMEA"))
							{
								amea = String.valueOf(stdComp.getComplianceRuleMonths());
							}
							if(stdComp.getRegionCode().equals("GC"))
							{
								gc = String.valueOf(stdComp.getComplianceRuleMonths());
							}
							if(stdComp.getRegionCode().equals("GLBL"))
							{
								glbl = String.valueOf(stdComp.getComplianceRuleMonths());
							}
						}
						else if((compRule.equals("C") && ruleDate.equals("D")))
						{
							if(stdComp.getRegionCode().equals("AMER"))
							{
								amerdate = String.valueOf(stdComp.getComplianceDateString());
							}
							if(stdComp.getRegionCode().equals("EURO"))
							{
								eurodate = String.valueOf(stdComp.getComplianceDateString());
							}
							if(stdComp.getRegionCode().equals("AMEA"))
								
							{
								ameadate = String.valueOf(stdComp.getComplianceDateString());
							}
							if(stdComp.getRegionCode().equals("GC"))
							{
								gcdate = String.valueOf(stdComp.getComplianceDateString());
							}
							if(stdComp.getRegionCode().equals("GLBL"))
							{
								glbldate = String.valueOf(stdComp.getComplianceDateString());
							}
						}
						else if((compRule.equals("E") && ruleDate.equals("D")))
						{
							if(stdComp.getRegionCode().equals("AMER"))
							{
								amerdate = String.valueOf(stdComp.getExpiryDateString());
							}
							if(stdComp.getRegionCode().equals("EURO"))
							{
								eurodate = String.valueOf(stdComp.getExpiryDateString());
							}
							if(stdComp.getRegionCode().equals("AMEA"))
							{
								ameadate = String.valueOf(stdComp.getExpiryDateString());
							}
							if(stdComp.getRegionCode().equals("GC"))
							{
								gcdate = String.valueOf(stdComp.getExpiryDateString());
							}
							if(stdComp.getRegionCode().equals("GLBL"))
							{
								glbldate = String.valueOf(stdComp.getExpiryDateString());
							}
						}
						
						
						if(stdComp.getRegionCode().equals("AMER"))
						{
							isAmerExpiry = compRule;
							
						}
						if(stdComp.getRegionCode().equals("EURO"))
						{
							isEuroExpiry = compRule;
						}
						if(stdComp.getRegionCode().equals("AMEA"))
						{
							isAmeaExpiry = compRule;
						}
						if(stdComp.getRegionCode().equals("GC"))
						{
							isGcExpiry = compRule;
						}
						
					}
					
					
				for(String str:arlRegions.keySet())
				{
					if("GLBL".equals(str))
					{
						isGlobal = true;
					}
					if("AMER".equals(str))
					{
						isAmer = true;
					}
					if("AMEA".equals(str))
					{
						isAmea = true;
					}
					if("EURO".equals(str))
					{
						
						isEuro = true;
					}
					if("GC".equals(str))
					{
						isGc = true;
					}
				}
				
				//Check for region publish date Defect 5302
				if(publishRegion != null && publishRegion.size() > 0 )
				{
					for(String str : publishRegion.keySet())
				
					{
						if("GLBL".equals(str))
						{
							String[] compliance_date = publishRegion.get(str).split("_");
							if(compliance_date != null && compliance_date.length > 0){
								//String compDate = compliance_date[0];
								String publishStr = compliance_date[1];
								if("Y".equals(publishStr)){
									isGlblPublish = true;
									glblCompDate = compliance_date[0];
								}
							}
						}
						if("AMER".equals(str))
						{
							String[] compliance_date = publishRegion.get(str).split("_");
							if(compliance_date != null && compliance_date.length > 0){
								//String compDate = compliance_date[0];
								String publishStr = compliance_date[1];
								if("Y".equals(publishStr)){
									isAmerPublish = true;
									amerCompDate = compliance_date[0]; 
								}
							}	
							
						}
						if("AMEA".equals(str))
						{
							String[] compliance_date = publishRegion.get(str).split("_");
							if(compliance_date != null && compliance_date.length > 0){
								//String compDate = compliance_date[0];
								String publishStr = compliance_date[1];
								if("Y".equals(publishStr)){
									isAmeaPublish = true;
									ameaCompDate = compliance_date[0]; 
								}
							}
						}
						if("EURO".equals(str))
						{
							String[] compliance_date = publishRegion.get(str).split("_");
							if(compliance_date != null && compliance_date.length > 0){
								//String compDate = compliance_date[0];
								String publishStr = compliance_date[1];
								if("Y".equals(publishStr)){
									isEuroPublish = true;
									 euroCompDate = compliance_date[0];
								}
							}
						}
						if("GC".equals(str))
						{
							String[] compliance_date = publishRegion.get(str).split("_");
							if(compliance_date != null && compliance_date.length > 0){
								//String compDate = compliance_date[0];
								String publishStr = compliance_date[1];
								if("Y".equals(publishStr)){
									isGcPublish = true;
									gcCompDate = compliance_date[0]; 
								}
							}
						}
					}
				}	
				%>
			<h3 id="changeBrandAccordion_<%=brand %>"><%=BrandStandardsUtil.chainCodeMap().get(brand)%></h3>
			<div id="manageCompliance_<%=brand %>" style="display:inline-block;width:849px">
			<input type="hidden" value="false" name="complianceSelect_<%=brand%>" id="complianceSelect_<%=brand%>"/>
				<div class="manageCompliance_section">
								<span><label>
								<%if(compRule.equals("C") || compRule.equals("") ){ %>
								<input id="complianceRadio_<%=brand %>" type="radio" name="complianceRadio_<%=brand %>" value="compliance_<%=brand%>" checked onchange="showHideComplianceDiv('compliance_<%=brand%>','<%=brand%>')"/>
								<%}else { %>
								<input id="complianceRadio_<%=brand %>" type="radio" name="complianceRadio_<%=brand %>" value="compliance_<%=brand%>" onchange="showHideComplianceDiv('compliance_<%=brand%>','<%=brand%>')"/>
								<%} %>
								Compliance</label></span>
							<span style="margin-left: 10px;">
							<%if(complianceView.isSuperAdmin() || complianceView.isGlobalAuthor()) {%>
								<label>
								<%if(compRule.equals("E")){ %>
									<input id="expiryRadio_<%=brand%>" type="radio" name="expiryRadio_<%=brand%>" value="expiry_<%=brand %>" checked onchange="showHideComplianceDiv('expiry_<%=brand%>','<%=brand%>')"/>
								<%}else{ %>
								<input id="expiryRadio_<%=brand%>" type="radio" name="expiryRadio_<%=brand%>" value="expiry_<%=brand %>"  onchange="showHideComplianceDiv('expiry_<%=brand%>','<%=brand%>')"/>
								<%} %>
								Expiry</label>
							<%} %>
							</span>
				</div>
				<!-- Compliance Rule Section Start --> 
				<div id="compliance_<%=brand %>" class="complianceExp" <%=(compRule.equals("C") || compRule.equals(""))?"style='display:block; margin-top: 20px;'":"style='display:none;'" %>>
				    <div class="manageCompliance_section"><input id="comp_dateId" type="hidden" value ='<%=compRule+"_"+ruleDate%>' />
					    <span>
					    	<label>
							    <%if(ruleDate.equals("R") || ruleDate.equals("") ){ %>
							    <input id="ruleRadio_<%=brand %>" type="radio" name="ruleRadio_<%=brand %>" value="rule_<%=brand%>" checked  onchange="showHideRuleDiv('rule_<%=brand%>','<%=brand%>')"/>
							    <%}else{ %>
							    <input id="ruleRadio_<%=brand %>" type="radio" name="ruleRadio_<%=brand %>" value="rule_<%=brand%>" onchange="showHideRuleDiv('rule_<%=brand%>','<%=brand%>')"/>
							    <%} %>
							    Rule
							</label>
						</span>
						<span style="margin-left: 10px;">
							<label>
								<%if(ruleDate.equals("D") ){ %>
								<input id="dateRadio_<%=brand %>" type="radio" name="dateRadio_<%=brand %>" value="date_<%=brand %>" checked onClick="showHideRuleDiv('date_<%=brand%>','<%=brand%>')"/>
								<%}else{ %>
							    <input id="dateRadio_<%=brand %>" type="radio" name="dateRadio_<%=brand %>" value="date_<%=brand %>"  onClick="showHideRuleDiv('date_<%=brand%>','<%=brand%>')"/>
							    <%} %>
								Date
							</label>
						</span>
					</div>
					<div>&nbsp;</div>
					<div id="ruleDiv" class=dr style="display:block">
					
						<table class="ManagecomplianceTable">
						<tbody>
							<tr>
							<%if(isGlobal){ %>
								<td style="vertical-align: middle; width: 180px;">
									<b>GLOBAL</b><br/>
									
								</td>
								<%}
								if(isAmea)
								{
									if(isAmeaPublish && !complianceView.isSuperAdmin())
									{		
								%>		<td> 
											<a href="#" class="a-BT greyBT">AMEA</a><br/>
										</td>
									<%}else{%>
										<td> 
											<a href="#" class='a-BT <%=arlRegions.get("AMEA").equals("ALL")? "darkBT":"lightBT"  %>' onclick='getRegionAttribution("AMEA", "<%=brand %>");' id="amea_<%=brand%>">AMEA</a><br/>
											
										</td>
									<% }
								}else{%>
								<td>
									<a href="#" class="a-BT greyBT">AMEA</a><br/>
									</td>
								<%}
								if(isAmer)
								{
									if(isAmerPublish && !complianceView.isSuperAdmin())
									{	
								%>
										<td> 
											<a href="#" class="a-BT greyBT">AMER</a><br/>
										</td>
									<%}else{%>
										<td> 
										<a href="#" class='a-BT <%=arlRegions.get("AMER").equals("ALL")? "darkBT":"lightBT"  %>' onclick='getRegionAttribution("AMER", "<%=brand %>" );' id="amer_<%=brand%>">AMER</a><br/>
										</td>
								
									<% }
								}else {%>
								<td>
									<a href="#" class="a-BT greyBT">AMER</a><br/>
									</td>
								<%}
								if(isEuro)
								{
									if(isEuroPublish && !complianceView.isSuperAdmin())
									{	
								%>
										<td> 
											<a href="#" class="a-BT greyBT">EURO</a><br/>
										</td>
									<%}else{%>
										<td> 
											<a href="#" class='a-BT <%=arlRegions.get("EURO").equals("ALL")? "darkBT":"lightBT"  %>' onclick='getRegionAttribution("EURO", "<%=brand %>");' id="euro_<%=brand%>">EURO</a><br/>
											
										</td>
										
									<% }
								}else {%>
								<td>
								<a href="#" class="a-BT greyBT">EURO</a><br/>
								</td>
								<%}
								if(isGc)
								{   if(isGcPublish && !complianceView.isSuperAdmin())
									{	
								%>
									<td> 
											<a href="#" class="a-BT greyBT">GC</a><br/>
									</td>
									<%}else{%>
									<td> 
										<a href="#" class='a-BT <%=arlRegions.get("GC").equals("ALL")? "darkBT":"lightBT"  %>' onclick='getRegionAttribution("GC", "<%=brand %>");' id="gc_<%=brand%>">GC</a><br/>
										
									</td>
									<% }
								}else {%>
								<td>
									<a href="#" class="a-BT greyBT">GC</a><br/>
									</td>
								<%}%>
							</tr>
							<%if(ruleDate.equals("D")){ %>
							<tr class="showHide_rule_<%=brand %>" style="display:none">
							<%}else{ %>
							<tr class="showHide_rule_<%=brand %>">
							<%} %>
							
							<%
							if(isGlobal)
							{ 
								if(isGlblPublish && !complianceView.isSuperAdmin())
								{
							%>
								<td>
									<p <%=arlRegions.get("GLBL").equals("PARTIAL") ?"style='display:none'":"" %> > 
										<strong><%=glblCompDate %></strong>
									</p>
									<p <%=!arlRegions.get("GLBL").equals("PARTIAL") || !(compRule.equals("C") && ruleDate.equals("R"))?"style='display:none'":"" %>><strong>By Country</strong></p>
								</td>
								<%} else { %>	
								<td style="vertical-align: middle; width: 180px;">
									<p> 
											<select  class="globalRuleSelect" name="globalrule_<%=brand %>" id = "globalrule_<%=brand %>" onchange="changeRule('<%=brand%>')" <%= isGlobalUser?"":"disabled='disabled'" %> >
												<%for (Map.Entry<Long, String> entry : months.entrySet()) { 
												if(glbl.equals(String.valueOf(entry.getKey()))) {%>
												<option value="<%=entry.getKey() %>" selected="<%=selected%>"><%=entry.getValue() %></option>
												<%} 
												else{
												%>
												<option value="<%=entry.getKey() %>" ><%=entry.getValue() %></option>
												<%}
												}%>
											</select>
									</p>		
										<%if(isGlblPublish && complianceView.isSuperAdmin()) {%>
										  	<p><strong><%=glblCompDate %></strong></p>
										<% }%>
									
								</td>
							<%
								}
							}
							if(isAmea)
							{
							
								if(isAmeaPublish && !complianceView.isSuperAdmin())
								{
							%>
									<td>
										<p <%=arlRegions.get("AMEA").equals("PARTIAL") ?"style='display:none'":"" %> > 
											<strong><%=ameaCompDate %></strong>
										</p>
										<p <%=!arlRegions.get("AMEA").equals("PARTIAL") || !(compRule.equals("C") && ruleDate.equals("R"))?"style='display:none'":"" %>><strong>By Country</strong></p>
									</td>
							  <%} else { %>	
									<td> 
									<p <%=arlRegions.get("AMEA").equals("PARTIAL")?"style='display:none'":"" %> > 
										<select  class="globalRuleSelect" name="amearule_<%=brand %>" id = "amearule_<%=brand %>" 
										    <%= !arlRegions.get("AMEA").equals("PARTIAL") && (isGlobalUser|| userRegion.equals("AMEA"))?"":"disabled='disabled'" %>>
												
												<%for (Map.Entry<Long, String> entry : months.entrySet()) { 
												if(amea.equals(String.valueOf(entry.getKey()))) {%>
												<option value="<%=entry.getKey() %>" <%=selected%>><%=entry.getValue() %></option>
												<%} 
												else{
												%>
												<option value="<%=entry.getKey() %>" ><%=entry.getValue() %></option>
												<%}
												}%>
										</select>
									</p>
									<p <%=!arlRegions.get("AMEA").equals("PARTIAL") || !(compRule.equals("C") && ruleDate.equals("R"))?"style='display:none'":"" %>><strong>By Country</strong></p>
									<input type="hidden" value="<%=ameaCompDate%>" name="AMEA_<%=brand %>" />
									<%if(isAmeaPublish && complianceView.isSuperAdmin()) {%>
										  	<p><strong><%=ameaCompDate%></strong></p>
										  	
										<% }%>
								</td>
							<% }
							}else{
							%>
								<td>&nbsp;</td>
							<%}
							if(isAmer)
							{
								if(isAmerPublish && !complianceView.isSuperAdmin())
								{
							%>
									<td>
										<p <%=arlRegions.get("AMER").equals("PARTIAL") ?"style='display:none'":"" %> > 
											<strong><%=amerCompDate %></strong>
										</p>
										<p <%=!arlRegions.get("AMER").equals("PARTIAL") || !(compRule.equals("C") && ruleDate.equals("R"))?"style='display:none'":"" %>><strong>By Country</strong></p>
									</td>
							  <%} else { %>	
									<td> 
										<p <%=arlRegions.get("AMER").equals("PARTIAL")?"style='display:none'":"" %>>  
										 <select  class="globalRuleSelect" name="amerrule_<%=brand %>" id = "amerrule_<%=brand %>" 
										         <%= !arlRegions.get("AMER").equals("PARTIAL") && (isGlobalUser|| userRegion.equals("AMER"))?"":"disabled='disabled'" %>>
										<%for (Map.Entry<Long, String> entry : months.entrySet()) { 
													if(amer.equals(String.valueOf(entry.getKey()))) {%>
													<option value="<%=entry.getKey() %>" selected="<%=selected%>"><%=entry.getValue() %></option>
													<%} 
													else{
													%>
													<option value="<%=entry.getKey() %>" ><%=entry.getValue() %></option>
													<%}
													}%>
													</select>
										</p>
										
										<p <%=!arlRegions.get("AMER").equals("PARTIAL") || !(compRule.equals("C") && ruleDate.equals("R"))?"style='display:none'":"" %>><strong>By Country</strong></p>
										<input type="hidden" value="<%=amerCompDate%>" name="AMER_<%=brand %>" />
										<%if(isAmerPublish && complianceView.isSuperAdmin()) {%>
										  	<p><strong><%=amerCompDate %></strong></p>
										<% }%>
									
								</td>
								<%} 
							} else
							{%>
								<td>&nbsp;</td>
							<%}
							if(isEuro)
							{
								if(isEuroPublish && !complianceView.isSuperAdmin())
								{
							%>
									<td>
										<p <%=arlRegions.get("EURO").equals("PARTIAL") ?"style='display:none'":"" %> > 
											<strong><%=euroCompDate %></strong>
										</p>
										<p <%=!arlRegions.get("EURO").equals("PARTIAL") || !(compRule.equals("C") && ruleDate.equals("R"))?"style='display:none'":"" %>><strong>By Country</strong></p>
									</td>
							  <%} else { %>	
									<td> 
										<p <%=arlRegions.get("EURO").equals("PARTIAL")?"style='display:none'":"" %>>   
										<select  class="globalRuleSelect" name="eurorule_<%=brand %>" id = "eurorule_<%=brand %>" 
										          <%= !arlRegions.get("EURO").equals("PARTIAL") && (isGlobalUser|| userRegion.equals("EURO"))?"":"disabled='disabled'" %>>
										<%for (Map.Entry<Long, String> entry : months.entrySet()) { 
													if(euro.equals(String.valueOf(entry.getKey()))) {%>
													<option value="<%=entry.getKey() %>" selected="<%=selected%>"><%=entry.getValue() %></option>
													<%} 
													else{
													%>
													<option value="<%=entry.getKey() %>" ><%=entry.getValue() %></option>
													<%}
													}%>
													</select>
										</p>
										<p <%=!arlRegions.get("EURO").equals("PARTIAL") || !(compRule.equals("C") && ruleDate.equals("R"))?"style='display:none'":"" %>><strong>By Country</strong>
										</p>
										<input type="hidden" value="<%=euroCompDate%>" name="EURO_<%=brand %>" />
										<%if(isEuroPublish && complianceView.isSuperAdmin()) {%>
										  	<p><strong><%=euroCompDate %></strong></p>
										<% }%>
									</td>
							<%}
							}else
							{%>
								<td>&nbsp;</td>
							<%}
							if(isGc)
							{
								if(isGcPublish && !complianceView.isSuperAdmin())
								{
							%>
									<td>
										<p <%=arlRegions.get("GC").equals("PARTIAL") ?"style='display:none'":"" %> > 
											<strong><%=gcCompDate %></strong>
										</p>
										<p <%=!arlRegions.get("GC").equals("PARTIAL") || !(compRule.equals("C") && ruleDate.equals("R"))?"style='display:none'":"" %>><strong>By Country</strong></p>
									</td>
							  <%} else { %>	
									<td> 
										<p <%=arlRegions.get("GC").equals("PARTIAL")?"style='display:none'":"" %>>  
											<select  class="globalRuleSelect" name="gcrule_<%=brand %>" id = "gcrule_<%=brand %>" 
												<%= !arlRegions.get("GC").equals("PARTIAL") && (isGlobalUser|| userRegion.equals("GC"))?"":"disabled='disabled'" %>>
												<%for (Map.Entry<Long, String> entry : months.entrySet()) { 
															if(gc.equals(String.valueOf(entry.getKey()))) {%>
															<option value="<%=entry.getKey() %>" selected="<%=selected%>"><%=entry.getValue() %></option>
															<%} 
															else{
															%>
															<option value="<%=entry.getKey() %>" ><%=entry.getValue() %></option>
															<%}
															}%>
											</select>
										</p>
										<p <%=!arlRegions.get("GC").equals("PARTIAL") || !(compRule.equals("C") && ruleDate.equals("R"))?"style='display:none'":"" %>><strong>By Country</strong>
										</p>
										<input type="hidden" value="<%=gcCompDate%>" name="GC_<%=brand %>" />
										<%if(isGcPublish && complianceView.isSuperAdmin()) {%>
										  	<p><strong><%=gcCompDate %></strong></p>
										<% }%>
									</td>
								<%}
							} else{%>
								<td>&nbsp;</td>
							<%}%>
							
							</tr>
							<%if(ruleDate.equals("D")){ %>
							<tr class = "showHide_date_<%=brand %>" >
							<%}else{ %>
							<tr class = "showHide_date_<%=brand %>" style="display:none">
							<%} %>
								<%if(isGlobal){
									if(isGlblPublish && !complianceView.isSuperAdmin())
									{	
								%>
									<td>
										<p> <strong><%=glblCompDate%></strong></p>
									</td>
									<%}else{ %>
									<td>
									<input type="text" value='<%=compRule.equals("C")? glbldate:""%>' name="globaldate_<%=brand %>" class="Inputdatepicker" id="globaldate_<%=brand %>" onchange="changeCompDate('<%=brand %>')" 
									   <%= isGlobalUser?"":"disabled='disabled'" %>>
									   <input type="hidden" name="delglblcmpdate_<%=brand %>" id="delglblcmpdate_<%=brand %>" >	
									<a onclick="deleteComplianceDate('<%=brand %>');"><img src="<%= themeDisplay.getPathThemeImages() %>/delete.png" alt="delete"></a>
									   
										<%if(isGlblPublish && complianceView.isSuperAdmin()) {%>
										  	<p><strong><%=glblCompDate %></strong></p>
										<% }%>	
									</td>
								<%}
								}else{
								%>
								<td>&nbsp;</td><%
								}
								
								if(isAmea)
								{
									if(isAmeaPublish && !complianceView.isSuperAdmin())
									{	
								%>
									<td> 
										 <p <%=arlRegions.get("AMEA").equals("PARTIAL")?"style='display:none'":"" %>>
										 <strong><%=ameaCompDate %></strong>
										</p>
										<p <%=!arlRegions.get("AMEA").equals("PARTIAL") || !(compRule.equals("C") && ruleDate.equals("D"))?"style='display:none'":"" %>><strong>By Country</strong>
										</p>
									</td>
									<%}else { %>
									<td> 
										 <p <%=arlRegions.get("AMEA").equals("PARTIAL")?"style='display:none'":"" %>>
										<input type="text" value="<%= isAmeaExpiry.equals("C")  ? ameadate : "" %>" name="ameadate_<%=brand %>" class="Inputdatepicker" id="ameadate_<%=brand %>" 
										  <%= !arlRegions.get("AMEA").equals("PARTIAL") && (isGlobalUser|| userRegion.equals("AMEA"))?"":"disabled='disabled'" %>>
										
										<a onclick="deleteAmeaComplianceDate('<%=brand %>');"><img src="<%= themeDisplay.getPathThemeImages() %>/delete.png" alt="delete"></a>
										<input type="hidden" name="delameacmpdate_<%=brand %>" id="delameacmpdate_<%=brand %>">
										</p>
										
										<p <%=!arlRegions.get("AMEA").equals("PARTIAL") || !(compRule.equals("C") && ruleDate.equals("D"))?"style='display:none'":"" %>><strong>By Country</strong>
										</p>
										<input type="hidden" value="<%=ameaCompDate%>" name="AMEA_<%=brand %>" />
										<%if(isAmeaPublish && complianceView.isSuperAdmin()) {%>
										  	<p><strong><%=ameaCompDate %></strong></p>
										<% }%>
									</td>
									<%}
								} else {
								%>
								<td>&nbsp;</td>
								<%}
								
								if(isAmer)
								{
									if(isAmerPublish && !complianceView.isSuperAdmin())
									{	
								%>
									<td> 
										<p <%=arlRegions.get("AMER").equals("PARTIAL")?"style='display:none'":"" %>>
										 <strong><%=amerCompDate %></strong>
										</p>
										<p <%=!arlRegions.get("AMER").equals("PARTIAL") || !(compRule.equals("C") && ruleDate.equals("D"))?"style='display:none'":"" %>><strong>By Country</strong>
										</p>
									</td>
									<%}else { %>
									<td> 
										<p <%=arlRegions.get("AMER").equals("PARTIAL")?"style='display:none'":"" %>>
										<input type="text" value="<%=isAmerExpiry.equals("C")  ? amerdate : "" %>" name="amerdate_<%=brand %>" class="Inputdatepicker" id="amerdate_<%=brand %>" 
										   <%= !arlRegions.get("AMER").equals("PARTIAL") && (isGlobalUser|| userRegion.equals("AMER"))?"":"disabled='disabled'" %>>
										
										<a onclick="deleteAmerComplianceDate('<%=brand %>');"><img src="<%= themeDisplay.getPathThemeImages() %>/delete.png" alt="delete"></a>
										<input type="hidden" name="delamercmpdate_<%=brand %>" id="delamercmpdate_<%=brand %>">
										</p>
										<p <%=!arlRegions.get("AMER").equals("PARTIAL") || !(compRule.equals("C") && ruleDate.equals("D"))?"style='display:none'":"" %>><strong>By Country</strong>
										</p>
										<input type="hidden" value="<%=amerCompDate%>" name="AMER_<%=brand %>" />
										<%if(isAmerPublish && complianceView.isSuperAdmin()) {%>
										  	<p><strong><%=amerCompDate %></strong></p>
										<% }%>
									</td>
								<%}
								}else{
								%>
								<td>&nbsp;</td>
								
								<%}
								if(isEuro)
								{
									if(isEuroPublish && !complianceView.isSuperAdmin())
									{	
								%>
									<td> 
										<p <%=arlRegions.get("EURO").equals("PARTIAL")?"style='display:none'":"" %>>
										 <strong><%=euroCompDate %></strong>
										</p>
										<p <%=!arlRegions.get("EURO").equals("PARTIAL") || !(compRule.equals("C") && ruleDate.equals("D"))?"style='display:none'":"" %>><strong>By Country</strong>
											</p>
									</td>
									<%}else { %>
									<td> 
										<p <%=arlRegions.get("EURO").equals("PARTIAL")?"style='display:none'":"" %>>
										<input type="text" value="<%=isEuroExpiry.equals("C")? eurodate : "" %>" name="eurodate_<%=brand %>" class="Inputdatepicker" id="eurodate_<%=brand %>" 
										   <%= !arlRegions.get("EURO").equals("PARTIAL") && (isGlobalUser|| userRegion.equals("EURO"))?"":"disabled='disabled'" %>>
										
										<a onclick="deleteEuroComplianceDate('<%=brand %>');"><img src="<%= themeDisplay.getPathThemeImages() %>/delete.png" alt="delete"></a>
										<input type="hidden" name="deleurocmpdate_<%=brand %>" id="deleurocmpdate_<%=brand %>">
										</p>
										<p <%=!arlRegions.get("EURO").equals("PARTIAL") || !(compRule.equals("C") && ruleDate.equals("D"))?"style='display:none'":"" %>><strong>By Country</strong>
										</p>
										<input type="hidden" value="<%=euroCompDate%>" name="EURO_<%=brand %>" />
										<%if(isEuroPublish && complianceView.isSuperAdmin()) {%>
										  	<p><strong><%=euroCompDate %></strong></p>
										<% }%>
									</td>
								<%}
								}else{%><td>&nbsp;</td><%}
								
								if(isGc)
								{
									if(isGcPublish && !complianceView.isSuperAdmin())
									{
								%>
									<td> 
										<p <%=arlRegions.get("GC").equals("PARTIAL")?"style='display:none'":"" %>>
										<strong><%=gcCompDate %></strong>
										</p>
										<p <%=!arlRegions.get("GC").equals("PARTIAL") || !(compRule.equals("C") && ruleDate.equals("D"))?"style='display:none'":"" %>><strong>By Country</strong>
										</p>
									</td>
									<%}else { %>
									<td>
										<p <%=arlRegions.get("GC").equals("PARTIAL")?"style='display:none'":"" %>>
										<input type="text" value="<%=isGcExpiry.equals("C") ? gcdate : "" %>" name="gcdate_<%=brand %>" class="Inputdatepicker" id="gcdate_<%=brand %>" 
										   <%= !arlRegions.get("GC").equals("PARTIAL") && (isGlobalUser|| userRegion.equals("GC"))?"":"disabled='disabled'" %>>
										
										<a onclick="deleteGCComplianceDate('<%=brand %>');"><img src="<%= themeDisplay.getPathThemeImages() %>/delete.png" alt="delete"></a>
										<input type="hidden" name="delgccmpdate_<%=brand %>" id="delgccmpdate_<%=brand %>">
										</p>
										<p <%=!arlRegions.get("GC").equals("PARTIAL") || !(compRule.equals("C") && ruleDate.equals("D"))?"style='display:none'":"" %>><strong>By Country</strong>
										</p>
										<input type="hidden" value="<%=gcCompDate%>" name="GC_<%=brand %>" />
										<%if(isGcPublish && complianceView.isSuperAdmin()) {%>
										  	<p><strong><%=gcCompDate %></strong></p>
										<% }%>
									</td>
								<%	} 
								} else{%><td>&nbsp;</td><%}%>
							</tr>	
						</tbody>
						</table>
					</div>
					
				</div>
			
				<!-- Compliance Rule Section  End-->
				
				<!-- Expiray Date  Section  Start-->
				<%if(complianceView.isSuperAdmin() || complianceView.isGlobalAuthor()) {%>
				<div id="expiry_<%=brand %>" class="complianceExp" <%=compRule.equals("E") ?"style='display:block; margin-top: 20px;'":"style='display:none;'" %>>
					<div>&nbsp;</div>
					<div id="expDiv" class=dr style="display:block">
						<table  class="ManagecomplianceTable">
						<tbody>
						<tr><%if(isGlobal){ %>
								<td style="vertical-align: middle; width: 180px;">
									<b>GLOBAL</b><br/>
									
								</td>
								<%}
								if(isAmea)
								{
									if(isAmeaPublish && !complianceView.isSuperAdmin())
									{
								%>
									<td>
										<a href="#" class="a-BT greyBT">AMEA</a><br/>
									</td>
									<%}else{ %>	
									<td> 
										<a href="#" class='a-BT <%=arlRegions.get("AMEA").equals("ALL")? "darkBT":"lightBT"  %>' onclick='getRegionAttribution("AMEA", "<%=brand %>");'>AMEA</a><br/>
										
									</td>
								<%  }
								} else {%>
								<td>
									<a href="#" class="a-BT greyBT">AMEA</a><br/>
									</td>
								<%}
								if(isAmer)
								{
									if(isAmerPublish && !complianceView.isSuperAdmin())
									{	
								%>
									<td>
										<a href="#" class="a-BT greyBT">AMER</a><br/>
									</td>
									<%}else{ %>
									<td> 
										<a href="#" class='a-BT <%=arlRegions.get("AMER").equals("ALL")? "darkBT":"lightBT"  %>' onclick='getRegionAttribution("AMER", "<%=brand %>");'>AMER</a><br/>
									
									</td>
								<%  }
								}else {%>
								<td>
									<a href="#" class="a-BT greyBT">AMER</a><br/>
									</td>
								<%}
								if(isEuro)
								{
									if(isEuroPublish && !complianceView.isSuperAdmin())
									{	
								%>
									<td>
										<a href="#" class="a-BT greyBT">EURO</a><br/>
									</td>
									<%}else{ %>
									<td> 
										<a href="#" class='a-BT <%=arlRegions.get("EURO").equals("ALL")? "darkBT":"lightBT"  %>' onclick='getRegionAttribution("EURO", "<%=brand %>");'>EURO</a><br/>
										
									</td>
								<%}
								}else {%>
								<td>
								<a href="#" class="a-BT greyBT">EURO</a><br/>
								</td>
								<%}
								if(isGc)
								{
									if(isGcPublish && !complianceView.isSuperAdmin())
									{	
								%>
									<td>
										<a href="#" class="a-BT greyBT">GC</a><br/>
									</td>
									<%}else{ %>
									<td> 
										<a href="#" class='a-BT <%=arlRegions.get("GC").equals("ALL")? "darkBT":"lightBT"  %>' onclick='getRegionAttribution("GC", "<%=brand %>");'>GC</a><br/>
										
									</td>
								<%  }
								} else {%>
								<td>
									<a href="#" class="a-BT greyBT">GC</a><br/>
									</td>
								<%}%>
						</tr>
					   	<tr >
					   	<%if(isGlobal){
					   		if(isGlblPublish && !complianceView.isSuperAdmin()){
					   	%>	
					   		<td><strong><%=glblCompDate %></strong></td>
							<%}else{ %>
							<td>
								<input type="text" value='<%=compRule.equals("E")? glbldate:""%>' name="glblexdate_<%=brand %>" class="Inputdatepicker" id="glblexdate_<%=brand %>" onchange="changeExpDate('<%=brand %>')" <%= isGlobalUser?"":"disabled='disabled'" %>>
								<input type="hidden" name="delglblexdate_<%=brand %>" id="delglblexdate_<%=brand %>" >	
								<a onclick="deleteExpDate('<%=brand %>');"><img src="<%= themeDisplay.getPathThemeImages() %>/delete.png" alt="delete"></a>
								<%if(isGlblPublish && complianceView.isSuperAdmin()) {%>
								  	<p><strong><%=glblCompDate %></strong></p>
								 <% }%>
							</td>
							<%}
						}else{
						%><td>&nbsp;</td>
						<%}
					   	
							if(isAmea)
							{
								 if(isAmeaPublish && !complianceView.isSuperAdmin()){
						%>	
									<td>
										<p <%=arlRegions.get("AMEA").equals("PARTIAL")?"style='display:none'":"" %>>
										<strong><%=ameaCompDate %></strong></p>
										<p <%=!arlRegions.get("AMEA").equals("PARTIAL") || !(compRule.equals("E") && ruleDate.equals("D"))?"style='display:none'":"" %>><strong>By Country</strong>
										</p>
									</td>	
								<%}else{ %>
								<td> 
									 <p <%=arlRegions.get("AMEA").equals("PARTIAL")?"style='display:none'":"" %>>
									  
										<input type="text" value="<%=isAmeaExpiry.equals("E")? ameadate: ""%>" name="ameaexdate_<%=brand %>" class="Inputdatepicker" id="ameaexdate_<%=brand %>"  
											<%=  !arlRegions.get("AMEA").equals("PARTIAL") && (isGlobalUser|| userRegion.equals("AMEA"))?"":"disabled='disabled'" %>>
										<a onclick="deleteAmeaExpDate('<%=brand %>');"><img src="<%= themeDisplay.getPathThemeImages() %>/delete.png" alt="delete"></a>
										<input type="hidden" name="delameaexdate_<%=brand %>" id="delameaexdate_<%=brand %>">
									</p>
									<p <%=!arlRegions.get("AMEA").equals("PARTIAL") || !(compRule.equals("E") && ruleDate.equals("D"))?"style='display:none'":"" %>><strong>By Country</strong>
									</p>
									<%if(isAmeaPublish && complianceView.isSuperAdmin()) {%>
								  		<p><strong><%=ameaCompDate %></strong></p>
								 	<% }%>
								</td>
						<%     }
							}else{%>
								<td>&nbsp;</td>
						<%
						}
							
							if(isAmer)
							{
							if(isAmerPublish && !complianceView.isSuperAdmin()){
						%>	
									<td>
										<p <%=arlRegions.get("AMER").equals("PARTIAL")?"style='display:none'":"" %>>
										<strong><%=amerCompDate %></strong></p>
										<p <%=!arlRegions.get("AMER").equals("PARTIAL") || !(compRule.equals("E") && ruleDate.equals("D"))?"style='display:none'":"" %>><strong>By Country</strong>
										</p>
									</td>	
								<%}else{ %>
									<td> 
										<p <%=arlRegions.get("AMER").equals("PARTIAL")?"style='display:none'":"" %>>
										<input type="text" value="<%=isAmerExpiry.equals("E") ?  amerdate : ""%>" name="amerexdate_<%=brand %>" class="Inputdatepicker" id="amerexdate_<%=brand %>" 
											<%= !arlRegions.get("AMER").equals("PARTIAL") && (isGlobalUser|| userRegion.equals("AMER"))?"":"disabled='disabled'" %>>
										<a onclick="deleteAmerExpDate('<%=brand %>');"><img src="<%= themeDisplay.getPathThemeImages() %>/delete.png" alt="delete"></a>
										<input type="hidden" name="delamerexdate_<%=brand %>" id="delamerexdate_<%=brand %>">
										</p>
										<p <%=!arlRegions.get("AMER").equals("PARTIAL") || !(compRule.equals("E") && ruleDate.equals("D"))?"style='display:none'":"" %>><strong>By Country</strong>
										</p>
										<%if(isAmerPublish && complianceView.isSuperAdmin()) {%>
								  			<p><strong><%=amerCompDate %></strong></p>
								 		<% }%>
									</td>
							<%		}
							}else{%>
								<td>&nbsp;</td>
							<%}
							
							if(isEuro)
							{
								if(isEuroPublish && !complianceView.isSuperAdmin()){
							%>	
									<td>
										<p <%=arlRegions.get("EURO").equals("PARTIAL")?"style='display:none'":"" %>>
										<strong><%=euroCompDate %></strong></p>
										<p <%=!arlRegions.get("EURO").equals("PARTIAL") || !(compRule.equals("E") && ruleDate.equals("D"))?"style='display:none'":"" %>><strong>By Country</strong>
										</p>
									</td>	
								<%}else{ %>
									<td> 
										<p <%=arlRegions.get("EURO").equals("PARTIAL")?"style='display:none'":"" %>>
										<input type="text" value="<%=isEuroExpiry.equals("E") ? eurodate : ""%>" name="euroexdate_<%=brand %>" class="Inputdatepicker" id="euroexdate_<%=brand %>" 
											<%=  !arlRegions.get("EURO").equals("PARTIAL") && (isGlobalUser|| userRegion.equals("EURO"))?"":"disabled='disabled'" %>>
											<a onclick="deleteEuroExpDate('<%=brand %>');"><img src="<%= themeDisplay.getPathThemeImages() %>/delete.png" alt="delete"></a>
										<input type="hidden" name="deleuroexdate_<%=brand %>" id="deleuroexdate_<%=brand %>">
										</p>
										<p <%=!arlRegions.get("EURO").equals("PARTIAL") || !(compRule.equals("E") && ruleDate.equals("D"))?"style='display:none'":"" %>><strong>By Country</strong>
										</p>
										<%if(isEuroPublish && complianceView.isSuperAdmin()) {%>
								  			<p><strong><%=euroCompDate %></strong></p>
								 		<% }%>
									</td>
							<%		}
							}else{%>
								<td>&nbsp;</td>
							<%}
							
							if(isGc)
								
							{
								if(isGcPublish && !complianceView.isSuperAdmin()){
								%>	
									<td>
										<p <%=arlRegions.get("GC").equals("PARTIAL")?"style='display:none'":"" %>>
											<strong><%=gcCompDate %></strong></p>
										<p <%=!arlRegions.get("GC").equals("PARTIAL") || !(compRule.equals("E") && ruleDate.equals("D"))?"style='display:none'":"" %>><strong>By Country</strong>
										</p>
									</td>	
								<%}else{ %>
									<td>
									 	<p <%=arlRegions.get("GC").equals("PARTIAL")?"style='display:none'":"" %>>
										<input type="text" value="<%=isGcExpiry.equals("E") ? gcdate : "" %>" name="gcexdate_<%=brand %>" class="Inputdatepicker" id="gcexdate_<%=brand %>" 
											<%= !arlRegions.get("GC").equals("PARTIAL") && (isGlobalUser|| userRegion.equals("GC"))?"":"disabled='disabled'" %>>
										<a onclick="deleteGCExpDate('<%=brand %>');"><img src="<%= themeDisplay.getPathThemeImages() %>/delete.png" alt="delete"></a>
										<input type="hidden" name="delgcexdate_<%=brand %>" id="delgcexdate_<%=brand %>">
										</p>
										<p <%=!arlRegions.get("GC").equals("PARTIAL") || !(compRule.equals("E") && ruleDate.equals("D"))?"style='display:none'":"" %>> <strong>By Country</strong>
										</p>
										<%if(isGcPublish && complianceView.isSuperAdmin()) {%>
								  			<p><strong><%=gcCompDate %></strong></p>
								 		<% }%>
									</td>
							<%	 } 
							}else{%>
								<td>&nbsp;</td>
							<%}%>
							
						</tr>
						</tbody>
						</table>	
					</div>
		
				</div>
		        <%}%>
		        <!-- Expiray Date  Section  End-->
			
			</div>
			<input type="hidden" value="<%=ruleDate%>" name="popupRuleDate_<%=brand%>" id="popupRuleDate_<%=brand%>"/>
			<input type="hidden" value="<%=compRule%>" name="popupCompRule_<%=brand%>" id="popupCompRule_<%=brand%>"/>
			<%
				}
			%>
        </div>
        <div class="form_navigation">
        
        	 <input type="button" id="form_cancel" class="ui-state-active" title="Cancel" onClick="location.href='/web/brand-standards/standards${urlQuery}'" value='Cancel' />
              <input type="submit" id="submit" name="submitButton" value="Submit" title="Submit form" />
        </div>
        </form>
        </div><!--ends rounded_container_contents -->
	<div class="rounded_container_bottom">&nbsp;</div>
    </div><!--ends rounded_container -->
</div>

<div class="clear"></div>

<a href="#countryattributionDiv" id="countryattribution" style="display:none">Test</a>
<div id="countryattributionDiv" style="display:none"></div>
<script>
jQuery(function(){
	jQuery("#countryattribution").nyroModal();
	
	jQuery('input[type="text"]').prop("readonly", true);
	jQuery(".ui-datepicker-trigger").each(function(){
		if (jQuery(this).prev().attr("disabled") == "disabled")
		{
			jQuery(this).css("display","none");
		}
	});
});

function getRegionAttribution(region, chainCode)
{		
		var userRegion = '<%=userRegion%>';
		var ruleDate = jQuery("#popupRuleDate_" + chainCode).val();
		var compRule = jQuery("#popupCompRule_" + chainCode).val();
		if (<%=isGlobalUser%> || userRegion==region)
		{
			var ruleType = "D";
			if(jQuery("#ruleRadio_" + chainCode).is(':checked'))
			{
				ruleType = "R";
			}
			var stdId =  <%=stdId%>;
			var chainCode = chainCode;
			var region = region;
			var compType = "C";
			if(jQuery("#expiryRadio_" + chainCode).is(':checked')) // For expiry
			{
				compType = "E";
				ruleType = "D";
			}
			jQuery.ajax({
				url: '<%=countryAttribution%>',
				data: {
					stdId: stdId,
					chainCode: chainCode,
					region: region,
					compType : compType,
					ruleType : ruleType,
					ruleDate : ruleDate,
					compRule:compRule,
				},
				type: 'POST',
				success: function(data) 
				{
					jQuery("#countryattributionDiv").html("");
					jQuery("#countryattributionDiv").html(data);
					jQuery("#countryattribution").click();
				}
			});
		}
}
</script>