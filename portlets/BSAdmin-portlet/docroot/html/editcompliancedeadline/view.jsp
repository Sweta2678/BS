<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK"%>
<%@page import="com.ihg.brandstandards.db.service.StandardsCountryChainLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsCountryChain"%>
<%@page import="com.ihg.brandstandards.util.CMSStandardsListUtil"%>
<%@page import="com.ihg.brandstandards.util.BrandStandardsUtil"%>
<%@include file="/html/init.jsp" %>
<%@page import="com.ihg.brandstandards.db.model.StandardsChainImages"%>
<%@page import="com.ihg.brandstandards.db.model.Standards"%>
<%@page import="java.util.List"%>
<portlet:actionURL name="setDeadlineDates" var="deadlineFormAction"/>
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/editComplianceDeadline.css" />
<%
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
	Standards std = (Standards) request.getAttribute("std");
	String brandCode = (String) request.getAttribute("brandCode");
	 String expiryDate = "";
	 String complianceDate = "";
	 String regionCompDate="";
	 String regionExpiryDate="";
%>
<div class="rounded_container">
	<div class="rounded_container_contents">
		<div class="edit_comp_deadline">
			<h4>Edit Compliance Deadline</h4>
			<form id="compForm" method="post" action="<%=deadlineFormAction.toString()%>" class="bbq">
				<input type="hidden" value="" name="defaultDate" id="defaultDate"/>
				<input type="hidden" value="${brandCode}" name="brandCode" id="brandCode"/>
				<input type="hidden" value="${std.stdId}" name="stdId" id="stdId"/>
				<!-- Add hidden field to persist data Defect 5678 -->
				<input type="hidden" value="${caloption}" name="caloption" id="caloption"/>
				<input type="hidden" value="${between}" name="between" id="between"/>
				<input type="hidden" value="${andVal}" name="andVal" id="andVal"/>
				<input type="hidden" value="${Search}" name="Search" id="Search"/>
				<input type="hidden" value="${isNotMatch}" name="isNotMatch" id="isNotMatch"/>
				<p>
					<u>Important Note</u> By amending these deadlines you are adjusting
					the Compliance Deadline as viewed by our Hotel team and the date
					that will be sent to QEM.
				<table class="results_table" summary="Data table for all results">
					<tbody>
						<tr>
							<td class="parent_id" width="40">${std.stdId}</td>
							<td>
			<%
				List<StandardsChainImages> stdImgs = CMSStandardsListUtil.getStandardsImagesByStdIdChaincode(std.getStdId(), brandCode);
				if(!BrandStandardsUtil.isNullOrBlank(stdImgs))
				{
			%>
					<a><img src="/BSTheme-theme/images/camera_icon.jpg" class="global_icon" title="Has Images" alt="Has Images" /></a>
			<%  } 
               	if("GLBL".equals(std.getRegionCode())) {
                	if("G".equals(std.getIsGlobal())) {
						if("Y".equals(std.getFramework()))  {
            %>
                			<img src="/BSTheme-theme/images/global_icon_red.png" class="global_icon" title="Global Framework standard icon" alt="Global Framework standard icon" />
            <%			} else { %>
                            <img src="/BSTheme-theme/images/global_icon.png" class="global_icon" title="Global standard icon" alt="Global standard icon" />
            <%          }
                 	} else {
						if("Y".equals(std.getFramework()))  {
            %>
                   			<img src="/BSTheme-theme/images/global_icon_halfred.png" class="global_icon" title="Multi-region Framework standard icon" alt="Multi-region Framework standard icon" />
            <%		    } else { %>
                            <img src="/BSTheme-theme/images/multi_region_icon.png" class="global_icon" title="Multi-region standard icon" alt="Multi-region standard icon" />
            <% 			}
      				}
    			}
           	%>
						<%=std.getTitle() %>
						</td>
						</tr>
					</tbody>
				</table>
				<div>
				<c:if test="${regionMapModified.size() gt 1}" >
				<div class="amendAll">
					<h3 >AMEND ALL</h3>
					<%
					String amendAllCompDate = StandardsCountryChainLocalServiceUtil.getDefaultComplianceDate(std.getStdId(), brandCode, "");
					String amendallExpiryDate = StandardsCountryChainLocalServiceUtil.getDefaulExpiryDate(std.getStdId(), brandCode, "");
					%>
					
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="125">Compliance Date:</td>
								<td>
									<table border="0" cellspacing="0" cellpadding="0"
										id="comp_edit_table_no_border">
										<tr>
											<td width="90"><span class="current_deadline_date"><%=amendAllCompDate %></span></td>
											<td><a class="edit_link">Edit...</a><input type="hidden" id="dp" name="dpAmendAll" value=""/>
											<input type="hidden" id="amendCancel" name="amendCancel" value=""/>
											<div></div></td>
											<td width="10"><a class="apply_link">Apply</a></td>
											<td><a class="cancel_link">Cancel</a></td>
											<td><a onclick="deleteAllComplianceDate()"><img alt="delete" src="/BSTheme-theme/images/delete.png" ></a></td>
										</tr>
									</table>
								</td>
								<td width="93">Expiry Date:</td>
								<td>
									<table border="0" cellspacing="0" cellpadding="0"
										id="comp_edit_table_no_border">
										<tr>
											<td width="90"><span class="current__expiry_date"><%=amendallExpiryDate %></span></td>
											<td><a class="edit_expiry_date_link">Edit...</a><input type="hidden" id="expDate" name="expDateAmendAll" value=""/>
											<input type="hidden" id="amendExpDateCancel" name="amendExpDateCancel" value=""/>
											<div></div></td>
											<td width="10"><a class="apply_expiry_date_link">Apply</a></td>
											<td><a class="cancel_expiry_date_link">Cancel</a></td>
											<td><a onclick="deleteAllExpiryDate()"><img alt="delete" src="/BSTheme-theme/images/delete.png" ></a></td>
										</tr>
									</table>
								</td>
								<%-- <td style="text-align: right;"><b>Expires:</b> ${expireIds}</td> --%>
							</tr>
						</table>
						<div class="clear"></div>
					</div>
					</c:if>
				</div>
				
				<div id="accordion">
					<c:forEach items="${regionMapModified}" var="regionMap">
						<h3>${regionMap.key}</h3>
						<c:set  var="regionCode" value="${regionMap.key}" scope="request"></c:set>
						<%
						String regionCode = (String)request.getAttribute("regionCode");
						 regionCompDate = StandardsCountryChainLocalServiceUtil.getDefaultComplianceDate(std.getStdId(), brandCode, regionCode);
						 regionExpiryDate = StandardsCountryChainLocalServiceUtil.getDefaulExpiryDate(std.getStdId(), brandCode, regionCode);
						%>
						<div>
							<div>
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="125">Compliance Date:</td>
											<td>
												<table border="0" cellspacing="0" cellpadding="0"
													id="comp_edit_table_no_border">
													<tr>
														<td class="parent" width="90"><span id="region_current_deadline_date${regionMap.key}" class="region_current_deadline_date"><%=regionCompDate %></span></td>
														<td><a class="region_edit_link" id="region_edit_link${regionMap.key}" regioncode="${regionMap.key}" onclick="javascript:editRegionDate(this);">Edit...</a><input type="hidden" id="regiondp${regionMap.key}" name="regiondp${regionMap.key}"  class="regiondp"  value=""/>
														<input type="hidden" class="region_cancel" id="regionAmendCancel${regionMap.key}" name="regionAmendCancel${regionMap.key}" value=""/>
														<div></div></td>
														<td width="10"><a class="region_apply_link" regioncode="${regionMap.key}" onclick="javascript:applyRegionDate(this);" id="region_apply_link_${regionMap.key}">Apply</a></td>
														<td><a class="region_cancel_link" id="region_cancel_link_${regionMap.key}" regioncode="${regionMap.key}" onclick="javascript:cancelRegionDate(this);">Cancel</a></td>
														<td><a onclick="deleteRegionDate('${regionMap.key}')"><img alt="delete" src="/BSTheme-theme/images/delete.png" ></a></td>
													</tr>
												</table>
											</td>
											<td width="93">Expiry Date:</td>
											<td>
												<table border="0" cellspacing="0" cellpadding="0"
													id="comp_edit_table_no_border">
													<tr>
														<td class="parent" width="95"><span id="region_current__expiry_date${regionMap.key}" class="region_current__expiry_date"><%=regionExpiryDate%></span></td>
														<td><a class="region_edit_expiry_date_link" id="region_edit_expiry_date_link${regionMap.key}" regioncode="${regionMap.key}" onclick="javascript:editRegionExpiryDate(this);">Edit...</a><input type="hidden" id="regionExpDate${regionMap.key}" name="regionExpDate${regionMap.key}" class="regionExpDate" value=""/>
														<input type="hidden" id="regionAmendExpDateCancel${regionMap.key}" name="regionAmendExpDateCancel${regionMap.key}" value=""/>
														<div></div></td>
														<td width="10"><a class="region_apply_expiry_date_link" regioncode="${regionMap.key}" onclick="javascript:applyRegionExpiryDate(this);" id="region_apply_expiry_date_link_${regionMap.key}">Apply</a></td>
														<td><a class="region_cancel_expiry_date_link" id="region_cancel_expiry_date_link_${regionMap.key}" regioncode="${regionMap.key}" onclick="javascript:cancelRegionExpiryDate(this);">Cancel</a></td>
														<td><a onclick="deleteRegionExpiryDate('${regionMap.key}')"><img alt="delete" src="/BSTheme-theme/images/delete.png" ></a></td>
													</tr>
												</table>
											</td>
											<%-- <td style="text-align: right;"><b>Expires:</b> ${expireIds}</td> --%>
										</tr>
									</table>
									<div class="clear"></div>
							</div>
						
						
							<table border="0" cellspacing="0" cellpadding="0" width="100%"
								id="compliance_admin_edit_table">
								<tr class="comp_edit_title">
									<td><b>Country/Region</b></td>
									<td><b>Compliance Date</b></td>
									<td><b>Expiry Date</b></td>
									<td class="blankTd" style="border-bottom:none;"></td>
									<td><b>Country/Region</b></td>
									<td><b>Compliance Date</b></td>
									<td><b>Expiry Date</b></td>
								</tr>
								<c:forEach items="${regionMap.value}" var="country" varStatus="i">
									<c:if test="${i.index%2 eq 0}">
										<tr>
									</c:if>
									<td width="10%">${country.value}</td>
								<td width="20%">
								  <c:if test="${countriesEditable[country.key] eq 'true'}" >  
									<c:set  var="countryCode" value="${country.key}" scope="request"></c:set>
									
									<%
											
										try{
											  String countryCode = (String)request.getAttribute("countryCode");
											  StandardsCountryChain countryChain = StandardsCountryChainLocalServiceUtil.getStandardsCountryChain(new StandardsCountryChainPK(std.getStdId(), countryCode, brandCode));
											 if(Validator.isNotNull(countryChain.getCompDate())){
												 complianceDate = df.format(countryChain.getCompDate());
											 }
											 if(Validator.isNotNull(countryChain.getExprDate())){
												 expiryDate = df.format(countryChain.getExprDate());
											 } 
										}catch(Exception e){System.out.println("Exception "+e);}
											%>
									
									
									 <table border="0" cellspacing="0" cellpadding="0"
											id="comp_edit_table_no_border" width="100%">
											<tr>
											<c:if test="${countriesEditable[country.key] eq 'true'}" > 
												<td class="parent" width="70%"><span id="current_deadline_date1${country.key}" class="current_deadline_date1 region_currentdeadline_${regionMap.key}"><%=complianceDate %></span></td>
												<td width="20%"><a class="edit_link1 region_dp_${regionMap.key}" id="edit_link_${country.key}" ctrycode="${country.key}" onclick="javascript:editDate(this);">Edit</a><input
													type="hidden" id="dp${country.key}" name="datepicker_${country.key}" class="dp1 regiondp1${regionMap.key}" value="<%=complianceDate %>"/>
													<input
													type="hidden" id="cancel${country.key}" name="cancel_${country.key}" class="cancelDate regionCancelDate${regionMap.key}" value="<%=complianceDate %>"/>
												<div></div></td>
												<td ><a class="apply_link1" ctrycode="${country.key}" onclick="javascript:applyDate(this);" id="apply_link_${country.key}">Apply</a></td>
												<td><a class="cancel_link1" id="cancel_link_${country.key}" ctrycode="${country.key}" onclick="javascript:cancelDate(this);">Cancel</a></td>
											 	<td><a onclick="deleteComplianceDate('${country.key}');"><img alt="delete" src="/BSTheme-theme/images/delete.png" ></a></td>
											 </c:if>
											</tr>
										</table>
									</c:if>
									</td>
									<td width="20%">
									<c:if test="${countriesEditable[country.key] eq 'true'}" >  
										<table border="0" cellspacing="0" cellpadding="0"
											id="comp_edit_table_no_border" width="100%">
											<tr>
											<c:if test="${countriesEditable[country.key] eq 'true'}" > 
											
											
												<td class="parent" width="70%"><span id="current__expiry_date1${country.key}" class="current__expiry_date1 region_expirydeadline_${regionMap.key}"><%=expiryDate %></span></td>
												<td width="20%"><a class="edit_expiry_date_link1 region_expiryDate_${regionMap.key}" id="edit_expiry_date_link_${country.key}" ctrycode="${country.key}" onclick="javascript:editExpiryDate(this);">Edit</a><input
													type="hidden" id="expDate${country.key}" name="expDatepicker_${country.key}" class="expDate1 regionexpdate1${regionMap.key}" value="<%=expiryDate %>"/>
													<input
													type="hidden" id="expDateCancel${country.key}" name="expDateCance_${country.key}" class="cancelExpiryDate regionCancelExpiryDate${regionMap.key}" value="<%=expiryDate %>"/>
												<div></div></td>
												<td ><a class="apply_expiry_date_link1" ctrycode="${country.key}" onclick="javascript:applyExpiryDate(this);" id="apply_expiry_date_link_${country.key}">Apply</a></td>
												<td><a class="cancel_expiry_date_link1" id="cancel_expiry_date_link_${country.key}" ctrycode="${country.key}" onclick="javascript:cancelExpiryDate(this);">Cancel</a></td>
											 	<td><a onclick="deleteExpiryDate('${country.key}');"><img alt="delete" src="/BSTheme-theme/images/delete.png" ></a></td>
											 </c:if> 
											</tr>
										</table> 
										</c:if>
									</td>
									
									<c:if test="${(i.index+1)%2 ne 0}">
									<td class="blankTd" style="border-top:none;border-bottom:none;"></td>
									</c:if>
									<c:if test="${(i.index+1)%2 eq 0}">
									
										</tr>
									</c:if>
									<c:if test="${i.last && (i.index)%2 eq 0}">
										<td></td>
										<td></td>
										</tr>
									</c:if>
									<%
									 complianceDate ="";
									 expiryDate ="";
									%>
								</c:forEach>
							</table>
							<div class="clear"></div>
						</div>
						<%
						 regionCompDate="";
						 regionExpiryDate="";
						%>
					</c:forEach>
				</div>
				<!-- End Accordian -->
				<div class="wizard_navigation" style="float: right;">
					<input class="navigation_button" id="cancel" value="Cancel"
						type="button">
					<input class="navigation_button" id="next"
						value="Submit" type="submit" />
				</div>
			</form>
		</div>
		<div class="clear"></div>
	</div>
	<!--ends rounded_container_contents -->
	<div class="rounded_container_bottom">&nbsp;</div>
</div>
<!--ends rounded_container -->
<div class="clear"></div>
<script type="text/javascript">
jQuery(function() {
	//accordian function call 
	    jQuery("#accordion").accordion({
	        collapsible: true,
	        active: 0,
			heightStyle: "content"
	    });

	    jQuery("#dp").datepicker({
			defaultDate: "+1w",
			changeMonth: true,
			changeYear: true,
			buttonText: 'Select Date',
			numberOfMonths: 3,
			dateFormat: "dd-M-yy",
			minDate: +0,		
	        onSelect: function(dateText, inst) {			
				jQuery(".current_deadline_date").html(dateText);
	        },
	        beforeShow: function (event, ui) {
	            var jQuerylink = jQuery(".edit_link");
	            ui.dpDiv.offset({
	                top: jQuerylink.offset().top + 10,
	                left: jQuerylink.offset().left + 10
	            });
	        }
	    });
	
	 	// edit click - show apply & cancel link
	    jQuery(".edit_link").click(function() { 
	        jQuery("#dp").datepicker("show");		
			jQuery(".apply_link").show();
			jQuery(".cancel_link").show();
			jQuery(".edit_link").hide();
		});
		// apply click - show edit & hide cancel & apply link
		jQuery(".apply_link").click (function(){
			jQuery(".current_deadline_date1").html(jQuery(".current_deadline_date").html());
			jQuery(".region_current_deadline_date").html(jQuery(".current_deadline_date").html());
			jQuery(".dp1").val(jQuery("#dp").val());
			jQuery("#amendCancel").val(jQuery("#dp").val());
			jQuery(".cancelDate").val(jQuery("#dp").val());
			jQuery(".region_cancel").val(jQuery("#dp").val());
			jQuery(".edit_link").show();
			jQuery(".cancel_link").hide();
			jQuery(".apply_link").hide();
			jQuery(".current__expiry_date").html("");
			deleteAllExpiryDate();
		});
	
		// cancel click - show edit & hide apply & cancel link
		jQuery(".cancel_link").click (function(){
			jQuery("#dp").val(jQuery("#amendCancel").val());
			jQuery(".current_deadline_date").html(jQuery("#amendCancel").val());
			jQuery(".edit_link").show();
			jQuery(".apply_link").hide();
			jQuery(".cancel_link").hide();
		});
		
		jQuery("#cancel").click(function(){
			var brand = jQuery("#brandCode").val();
			//Defect 5678 resolve
			var filterOn = jQuery("#caloption").val();
			var fromDate = jQuery("#between").val();
			var toDate = jQuery("#andVal").val();
			var stdString = jQuery("#Search").val();
			var isNonMatch = jQuery("#isNotMatch").val();
			var backUrlWithParam = "&caloption="+filterOn+"&between="+fromDate+"&and="+toDate+"&Search="+stdString+"&isNotMatch="+isNonMatch;
			window.location.href = "/web/brand-standards/compliance-admin?p_p_id=ComplianceAdmin_WAR_BSAdminportlet&tabs1="+brand+backUrlWithParam;
		});
	    
		// onclick of edit_link1 datepicker will open up with 3 months options
	    jQuery(".expDate1").each(function(){
	    	jQuery(this).datepicker({
				defaultDate: "+1w",
				changeMonth: true,
				changeYear: true,
				buttonText: 'Select Date',
				numberOfMonths: 3,
				dateFormat: "dd-M-yy",
				minDate: +0,		
		        onSelect: function(dateText, inst) {
					jQuery(this).parent("td").siblings("td.parent").children("span").html(dateText);
					jQuery(this).val(jQuery(this).siblings('input[type="hidden"]').val());
		        },
		        beforeShow: function (event, ui) {
		            var jQuerylink = jQuery(".edit_expiry_date_link1");
		            ui.dpDiv.offset({
		                top: jQuerylink.offset().top + 10,
		                left: jQuerylink.offset().left + 10
		            });
		        }
	    	});
	    });
		
		
	    jQuery(".dp1").each(function(){
	    	jQuery(this).datepicker({
				defaultDate: "+1w",
				changeMonth: true,
				changeYear: true,
				buttonText: 'Select Date',
				numberOfMonths: 3,
				dateFormat: "dd-M-yy",
				minDate: +0,		
		        onSelect: function(dateText, inst) {
					jQuery(this).parent("td").siblings("td.parent").children("span").html(dateText);
					jQuery(this).val(jQuery(this).siblings('input[type="hidden"]').val());
		        },
		        beforeShow: function (event, ui) {
		            var jQuerylink = jQuery(".edit_link1");
		            ui.dpDiv.offset({
		                top: jQuerylink.offset().top + 10,
		                left: jQuerylink.offset().left + 10
		            });
		        }
	    	});
	    });
		
	     jQuery(".regiondp").each(function(){
	    	jQuery(this).datepicker({
				defaultDate: "+1w",
				changeMonth: true,
				changeYear: true,
				buttonText: 'Select Date',
				numberOfMonths: 3,
				dateFormat: "dd-M-yy",
				minDate: +0,		
		        onSelect: function(dateText, inst) {
					jQuery(this).parent("td").siblings("td.parent").children("span").html(dateText);
					
					//jQuery(this).val(jQuery(this).siblings('input[type="hidden"]').val());
		        },
		        beforeShow: function (event, ui) {
		            var jQuerylink = jQuery(".region_edit_link");
		            ui.dpDiv.offset({
		                top: jQuerylink.offset().top + 10,
		                left: jQuerylink.offset().left + 10
		            });
		        }
	    	});
	    }); 
	     
	     jQuery(".regionExpDate").each(function(){
		    	jQuery(this).datepicker({
					defaultDate: "+1w",
					changeMonth: true,
					changeYear: true,
					buttonText: 'Select Date',
					numberOfMonths: 3,
					dateFormat: "dd-M-yy",
					minDate: +0,		
			        onSelect: function(dateText, inst) {
						jQuery(this).parent("td").siblings("td.parent").children("span").html(dateText);
						
						//jQuery(this).val(jQuery(this).siblings('input[type="hidden"]').val());
			        },
			        beforeShow: function (event, ui) {
			            var jQuerylink = jQuery(".region_edit_expiry_date_link");
			            ui.dpDiv.offset({
			                top: jQuerylink.offset().top + 10,
			                left: jQuerylink.offset().left + 10
			            });
			        }
		    	});
		    }); 
	});
	function editDate(object){
		var ctrycode = jQuery(object).attr("ctrycode");
		jQuery(object).next().datepicker("show");
		jQuery("#apply_link_"+ctrycode).show();
		jQuery("#cancel_link_"+ctrycode).show();
		jQuery("#edit_link_"+ctrycode).hide();
	}
	// apply click - show edit & hide cancel & apply link
	function applyDate(object){
		var ctrycode = jQuery(object).attr("ctrycode");
		jQuery("#dp"+ctrycode).val(jQuery("#current_deadline_date1"+ctrycode).html());
		jQuery("#cancel"+ctrycode).val(jQuery("#dp"+ctrycode).val());
		jQuery("#edit_link_"+ctrycode).show();
		jQuery("#cancel_link_"+ctrycode).hide();
		jQuery("#apply_link_"+ctrycode).hide();
		deleteExpiryDate(ctrycode);
	}
	// cancel click - show edit & hide apply & cancel link
	function cancelDate(object){
		var ctrycode = jQuery(object).attr("ctrycode");
		//alert(jQuery("#cancel"+ctrycode).val());
		jQuery("#dp"+ctrycode).val(jQuery("#cancel"+ctrycode).val());
		jQuery("#current_deadline_date1"+ctrycode).html(jQuery("#cancel"+ctrycode).val());
		//alert(jQuery("#dp"+ctrycode).val());
		jQuery("#edit_link_"+ctrycode).show();
		jQuery("#apply_link_"+ctrycode).hide();
		jQuery("#cancel_link_"+ctrycode).hide();
	}
	//Added by Anil Gurjar
	jQuery("#expDate").datepicker({
		defaultDate: "+1w",
		changeMonth: true,
		changeYear: true,
		buttonText: 'Select Date',
		numberOfMonths: 3,
		dateFormat: "dd-M-yy",
		minDate: +0,		
        onSelect: function(dateText, inst) {			
			jQuery(".current__expiry_date").html(dateText);
        },
        beforeShow: function (event, ui) {
            var jQuerylink = jQuery(".edit_expiry_date_link");
            ui.dpDiv.offset({
                top: jQuerylink.offset().top + 10,
                left: jQuerylink.offset().left + 10
            });
        }
    });
	
	 jQuery(".edit_expiry_date_link").click(function() { 
	        jQuery("#expDate").datepicker("show");		
			jQuery(".apply_expiry_date_link").show();
			jQuery(".cancel_expiry_date_link").show();
			jQuery(".edit_expiry_date_link").hide();
		});
	 
	 
	 jQuery(".apply_expiry_date_link").click (function(){
			jQuery(".current__expiry_date1").html(jQuery(".current__expiry_date").html());
			jQuery(".region_current__expiry_date").html(jQuery(".current__expiry_date").html());
			jQuery(".expDate1").val(jQuery("#expDate").val());
			jQuery("#amendExpDateCancel").val(jQuery("#expDate").val());
			jQuery(".cancelExpiryDate").val(jQuery("#expDate").val());
			jQuery(".edit_expiry_date_link").show();
			jQuery(".cancel_expiry_date_link").hide();
			jQuery(".apply_expiry_date_link").hide();
			jQuery(".current_deadline_date").html("");
			deleteAllComplianceDate();
		});
	 
	 jQuery(".cancel_expiry_date_link").click (function(){
			jQuery("#expDate").val(jQuery("#amendExpDateCancel").val());
			jQuery(".current__expiry_date").html(jQuery("#amendExpDateCancel").val());
			jQuery(".edit_expiry_date_link").show();
			jQuery(".apply_expiry_date_link").hide();
			jQuery(".cancel_expiry_date_link").hide();
		});
	 
	 function editRegionDate(object){
			var regioncode = jQuery(object).attr("regioncode");
			jQuery(object).next().datepicker("show");
			jQuery("#region_apply_link_"+regioncode).show();
			jQuery("#region_cancel_link_"+regioncode).show();
			jQuery("#region_edit_link"+regioncode).hide();
		}
	 function cancelRegionDate(object){
			var regioncode = jQuery(object).attr("regioncode");
			//alert(jQuery("#cancel"+ctrycode).val());
			jQuery("#regiondp"+regioncode).val(jQuery("#regionAmendCancel"+regioncode).val());
			jQuery("#region_current_deadline_date"+regioncode).html(jQuery("#regionAmendCancel"+regioncode).val());
			//alert(jQuery("#dp"+ctrycode).val());
			jQuery("#region_edit_link"+regioncode).show();
			jQuery("#region_apply_link_"+regioncode).hide();
			jQuery("#region_cancel_link_"+regioncode).hide();
		}
	 
	 
	 function applyRegionDate(object){
			var regioncode = jQuery(object).attr("regioncode");
					jQuery(".region_currentdeadline_"+regioncode).html(jQuery("#region_current_deadline_date"+regioncode).html());
					jQuery(".regiondp1"+regioncode).val(jQuery("#regiondp"+regioncode).val());
					jQuery("#regionAmendCancel"+regioncode).val(jQuery("#regiondp"+regioncode).val());
					jQuery(".regionCancelDate"+regioncode).val(jQuery("#regiondp"+regioncode).val());
					jQuery("#region_edit_link"+regioncode).show();
					jQuery("#region_apply_link_"+regioncode).hide();
					jQuery("#region_cancel_link_"+regioncode).hide();
					deleteRegionExpiryDate(regioncode);
		}
	 
	 function editRegionExpiryDate(object){
			var regioncode = jQuery(object).attr("regioncode");
			jQuery(object).next().datepicker("show");
			jQuery("#region_apply_expiry_date_link_"+regioncode).show();
			jQuery("#region_cancel_expiry_date_link_"+regioncode).show();
			jQuery("#region_edit_expiry_date_link"+regioncode).hide();
		}
	 function cancelRegionExpiryDate(object){
			var regioncode = jQuery(object).attr("regioncode");
			//alert(jQuery("#cancel"+ctrycode).val());
			jQuery("#regionExpDate"+regioncode).val(jQuery("#regionAmendExpDateCancel"+regioncode).val());
			jQuery("#region_current__expiry_date"+regioncode).html(jQuery("#regionAmendExpDateCancel"+regioncode).val());
			//alert(jQuery("#dp"+ctrycode).val());
			jQuery("#region_edit_expiry_date_link"+regioncode).show();
			jQuery("#region_apply_expiry_date_link_"+regioncode).hide();
			jQuery("#region_cancel_expiry_date_link_"+regioncode).hide();
		}
	 
	 
	 function applyRegionExpiryDate(object){
			var regioncode = jQuery(object).attr("regioncode");
					jQuery(".region_expirydeadline_"+regioncode).html(jQuery("#region_current__expiry_date"+regioncode).html());
					jQuery(".regionexpdate1"+regioncode).val(jQuery("#regionExpDate"+regioncode).val());
					jQuery("#regionAmendExpDateCancel"+regioncode).val(jQuery("#regionExpDate"+regioncode).val());
					jQuery(".regionCancelExpiryDate"+regioncode).val(jQuery("#regionExpDate"+regioncode).val());
					jQuery("#region_edit_expiry_date_link"+regioncode).show();
					jQuery("#region_apply_expiry_date_link_"+regioncode).hide();
					jQuery("#region_cancel_expiry_date_link_"+regioncode).hide();
					deleteRegionDate(regioncode);
		}
	 
	 function editExpiryDate(object){
			var ctrycode = jQuery(object).attr("ctrycode");
			jQuery(object).next().datepicker("show");
			jQuery("#apply_expiry_date_link_"+ctrycode).show();
			jQuery("#cancel_expiry_date_link_"+ctrycode).show();
			jQuery("#edit_expiry_date_link_"+ctrycode).hide();
		}
		// apply click - show edit & hide cancel & apply link
		function applyExpiryDate(object){
			var ctrycode = jQuery(object).attr("ctrycode");
			jQuery("#expDate"+ctrycode).val(jQuery("#current__expiry_date1"+ctrycode).html());
			jQuery("#expDateCancel"+ctrycode).val(jQuery("#expDate"+ctrycode).val());
			jQuery("#edit_expiry_date_link_"+ctrycode).show();
			jQuery("#cancel_expiry_date_link_"+ctrycode).hide();
			jQuery("#apply_expiry_date_link_"+ctrycode).hide();
			deleteComplianceDate(ctrycode);
		}
		// cancel click - show edit & hide apply & cancel link
		function cancelExpiryDate(object){
			var ctrycode = jQuery(object).attr("ctrycode");
			//alert(jQuery("#cancel"+ctrycode).val());
			jQuery("#expDate"+ctrycode).val(jQuery("#expDateCancel"+ctrycode).val());
			jQuery("#current__expiry_date1"+ctrycode).html(jQuery("#expDateCancel"+ctrycode).val());
			//alert(jQuery("#dp"+ctrycode).val());
			jQuery("#edit_expiry_date_link_"+ctrycode).show();
			jQuery("#apply_expiry_date_link_"+ctrycode).hide();
			jQuery("#cancel_expiry_date_link_"+ctrycode).hide();
		}
		
		function deleteExpiryDate(ctrycode){
			jQuery("#current__expiry_date1"+ctrycode).html("");
			jQuery("#expDate"+ctrycode).val("");
			jQuery("#expDateCancel"+ctrycode).val("");
		}
		function deleteComplianceDate(ctrycode){
			jQuery("#current_deadline_date1"+ctrycode).html("");
			jQuery("#dp"+ctrycode).val("");
			jQuery("#cancel"+ctrycode).val("");
			
		}
		
		 function deleteRegionExpiryDate(regioncode){
						jQuery("#region_current__expiry_date"+regioncode).html("");
						jQuery(".region_expirydeadline_"+regioncode).html("");
						jQuery(".regionexpdate1"+regioncode).val("");
						jQuery("#regionAmendExpDateCancel"+regioncode).val("");
						jQuery(".regionCancelExpiryDate"+regioncode).val("");
					
			}
		 
		 function deleteRegionDate(regioncode){
			 			jQuery("#region_current_deadline_date"+regioncode).html("");
						jQuery(".region_currentdeadline_"+regioncode).html("");
						jQuery(".regiondp1"+regioncode).val("");
						jQuery("#regionAmendCancel"+regioncode).val("");
						jQuery(".regionCancelDate"+regioncode).val("");
			}
		 
		 function deleteAllComplianceDate(){
				 jQuery(".current_deadline_date").html("");
				jQuery(".current_deadline_date1").html("");
				jQuery(".region_current_deadline_date").html("");
				jQuery(".dp1").val("");
				jQuery("#amendCancel").val("");
				jQuery(".cancelDate").val("");
				jQuery(".region_cancel").val("");
			};
			
			
			 function deleteAllExpiryDate(){
				jQuery(".current__expiry_date").html("");
				jQuery(".current__expiry_date1").html("");
				jQuery(".region_current__expiry_date").html("");
				jQuery(".expDate1").val("");
				jQuery("#amendExpDateCancel").val("");
				jQuery(".cancelExpiryDate").val("");
			};
</script>