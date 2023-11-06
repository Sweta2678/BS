<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<portlet:defineObjects />
<liferay-theme:defineObjects/>
<portlet:resourceURL var="saveAttribution" id="saveAttribution" />
<style>
img.ui-datepicker-trigger
{
	margin-bottom: 10px;
	margin-left: 5px;
}
.aui .popupDatePicker {
    display: inline-block;
    width: 250px;
}
.popupDatePicker input{
	width : 140px;
}
</style>
<form name="countryAttributionForm" id="countryAttributionForm">
	<div id="test" style="width: 700px;">
	
		<input type="hidden" name="stdId" id="publishId" value="${stdId}">
		<input type="hidden" name="chainCode" id="chainCode" value="${chainCode}">
		<input type="hidden" name="compType" id="compType" value="${compType}">
		<input type="hidden" name="ruleType" id="ruleType" value="${ruleType}">
		<input type="hidden" name="region" id="region" value="${region}">
		<h3><c:out value="${region}" /> Attribution</h3>
		
		<div style="float: right;">All Countries/Region 
			<span>
				<c:if test="${ruleType eq 'D'}">
			    	<span>
			    		<input type="text" value="" name="all_countries" id="all_countries" class="Inputdatepicker">
			    		<%--  <c:if test="${compType eq 'E'}"> --%>
				    		<input type="hidden" name="del_all_countries_date" id="del_all_countries_date" >
				    		<a id="del_all_countries"><img src="<%= themeDisplay.getPathThemeImages() %>/delete.png" alt="delete"></a>
			    		<%-- </c:if> --%>
			    	</span>
			    </c:if>
			    <c:if test="${ruleType eq 'R'}">
	   					<select  class="globalRuleSelect" name="all_countries" id = "all_countries">
	   						<c:forEach items="${ComplianceRules}" var="complyRule">
	   							<option value="${complyRule.key}">${complyRule.value}</option>
	   						</c:forEach>
						</select>
			    </c:if>
			</span>
		</div>        
		<table id="allCountries" style="width: 100%;">
			<tbody>
				<c:set var="cntIndex" scope="page" value="1" />
				<c:forEach items="${StandardsCompliance}" var="country" varStatus="index">
					<c:choose>
						<c:when test="${cntIndex % 2 eq 1 }">
							<tr>
								<td style="width:175px;padding-left:18px">
						</c:when>
						<c:otherwise>
								<td style="width:175px;padding-right:18px">							
						</c:otherwise>
					</c:choose>
					
					<label><c:out value='${countries[country.countryCode]}' /></label></td>
					
					<td style="width:275px">
					    <c:if test="${ruleType eq 'D'}">
					    	<fmt:formatDate value="${country.complianceExpiryDate}" var="startFormat" type="date" pattern="dd-MMM-yyyy"/>
					    	<span class="popupDatePicker">
					    		<c:choose>
		   							   <c:when test="${compRule  eq 'C' && compType eq 'C' && country.complianceExpiryRule eq 'C'}">
		   							   		<input type="text" value="${country.ruleDate eq 'D'?startFormat:''}" name="country_${country.countryCode}" class="Inputdatepicker" id="country_${country.countryCode}">
		   							   </c:when>
		   							   <c:when test="${compRule  eq 'E' && compType eq 'E' && country.complianceExpiryRule eq 'E' }">
		   							   		<input type="text" value="${country.ruleDate eq 'D'?startFormat:''}" name="country_${country.countryCode}" class="Inputdatepicker" id="country_${country.countryCode}">
		   							   </c:when>
		   							   <c:when test="${compRule  eq 'E' && compType eq 'E' && country.complianceExpiryRule eq 'C' }">
		   							   		<input type="text" value="" name="country_${country.countryCode}" class="Inputdatepicker" id="country_${country.countryCode}">
		   							   </c:when>
		   							   <c:when test="${compRule  eq 'C' && compType eq 'C' && country.complianceExpiryRule eq 'E' }">
		   							   		<input type="text" value="" name="country_${country.countryCode}" class="Inputdatepicker" id="country_${country.countryCode}">
		   							   </c:when>
		   							    <c:when test="${compRule  eq 'E' && compType eq 'C'  && country.complianceExpiryRule eq 'C'}">
		   							   		<input type="text" value="${country.ruleDate eq 'D'?startFormat:''}" name="country_${country.countryCode}" class="Inputdatepicker" id="country_${country.countryCode}">
		   							   </c:when>
		   							    <c:when test="${compRule  eq 'C' && compType eq 'E' && country.complianceExpiryRule eq 'E'}">
		   							   		<input type="text" value="${country.ruleDate eq 'D'?startFormat:''}" name="country_${country.countryCode}" class="Inputdatepicker" id="country_${country.countryCode}">
		   							   </c:when>
		   							   <c:when test="${compRule  eq 'E' && compType eq 'C' }">
		   							   		<input type="text" value="" name="country_${country.countryCode}" class="Inputdatepicker" id="country_${country.countryCode}">
		   							   </c:when>
		   							    <c:when test="${compRule  eq 'C' && compType eq 'E'}">
		   							   		<input type="text" value="" name="country_${country.countryCode}" class="Inputdatepicker" id="country_${country.countryCode}">
		   							   </c:when>
		   							    <c:otherwise>
		   									<input type="text" value="${startFormat}" name="country_${country.countryCode}" class="Inputdatepicker" id="country_${country.countryCode}">
		   								</c:otherwise>
	   								</c:choose>  
					    	   		<%-- <input type="text" value="${ruleDate eq 'D'?startFormat:''}" name="country_${country.countryCode}" class="Inputdatepicker" id="country_${country.countryCode}"> --%>
					    	  
					    	  <%--  <c:if test="${compType eq 'E'}"> --%>
					    	   		<input type="hidden" id="delDatecountry_${country.countryCode}" name="delDatecountry_${country.countryCode}"/>
					    	 		<a class="del_countries_date" id="delcountry_${country.countryCode}" onclick="delCountryDate('${country.countryCode}');"><img src="<%= themeDisplay.getPathThemeImages() %>/delete.png" alt="delete"></a>
					    	 	<%-- </c:if> --%>
					    	 	
					    	 </span>
					    </c:if>
					    <c:if test="${ruleType eq 'R'}">
		    				<select  class="globalRuleSelect" name="country_${country.countryCode}">
	   							<c:forEach items="${ComplianceRules}" var="complyRule">
	   							   <c:choose>
		   							   <c:when test="${complyRule.key==country.complianceRuleMonths && country.ruleDate eq 'R'}">
		   							   		<option value="${complyRule.key}" selected="selected">${complyRule.value}</option>
		   							   </c:when>
		   							   <c:otherwise>
		   									<option value="${complyRule.key}">${complyRule.value}</option>
		   								</c:otherwise>
	   								</c:choose>
	   							</c:forEach>
							</select>
					    </c:if>
					</td>
					<c:if test="${cntIndex % 2 eq 0 }">
						</tr>
					</c:if>
					<c:set var="cntIndex" scope="page" value="${cntIndex + 1}" />
				</c:forEach>
				<c:forEach items="${StandardsCountry}" var="country" varStatus="index">
					<c:choose>
						<c:when test="${cntIndex % 2 eq 1 }">
							<tr>
								<td style="width:200px; padding-left:18px">
						</c:when>
						<c:otherwise>
								<td style="width:200px; padding-right:18px">							
						</c:otherwise>
					</c:choose>
						
					<label><c:out value='${countries[country.country]}' /></label></td>
					<td style="width:225px">
					    <c:if test="${ruleType eq 'D'}">
					    	<span class="popupDatePicker">
					    		<input type="text" style="width:140px" value="" name="country_${country.country}" id="country_${country.country}" class="Inputdatepicker">
					    		<%-- <c:if test="${compType eq 'E'}"> --%>
					    	   		<input type="hidden" id="delDatecountry_${country.country}" name="delDatecountry_${country.country}"/>
					    	 		<a class="del_countries_date" id="delcountry_${country.country}" onclick="delCountryDate('${country.country}');"><img src="<%= themeDisplay.getPathThemeImages() %>/delete.png" alt="delete"></a>
					    	 	<%-- </c:if> --%>
					    	 	
					    	</span>
					    </c:if>
					    <c:if test="${ruleType eq 'R'}">
		    				<select  class="globalRuleSelect" name="country_${country.country}">
	   							<c:forEach items="${ComplianceRules}" var="complyRule">
	   								<option value="${complyRule.key}">${complyRule.value}</option>
	   							</c:forEach>
							</select>
					    </c:if>
					</td>
					<c:if test="${cntIndex % 2 eq 0 }">
						</tr>
					</c:if>
					<c:set var="cntIndex" scope="page" value="${cntIndex + 1}" />
				</c:forEach>
			</tbody>
		</table>
	  <div class="clear"></div> 
	  <div class="button"><a href="#" id="changeSettingsButton" onClick="callSubmit();">Save</a><span></span></div> 
	  <div class="button perspective_cancel"><a href="#" class="perspective_cancel_a" onclick="closeDialog()">Cancel</a><span></span></div>
	
	</div>
</form>
<script>
	var dateToday = new Date();
	jQuery(function() {
		jQuery( ".Inputdatepicker" ).datepicker({
			showOn: "button",
			buttonImage: "/BSTheme-theme/images/calendar_icon.png",
			buttonImageOnly: true,
			buttonText: "Select date",
			dateFormat: 'dd-M-yy',
			minDate: dateToday
		});
		$('.nyroModal').nyroModal()
		
		jQuery('input[type="text"]').prop("readonly", true);
		
	});
	function closeDialog()
	{
		jQuery(".nyroModalCloseButton").click();
	}
	function callSubmit()
	{
		jQuery("#countryAttributionForm").submit();	
	}
	jQuery("#countryAttributionForm").submit(function() {
		jQuery.ajax({
	           type: "POST",
	           url: '<%=saveAttribution%>',
	           data: jQuery(this).serialize(), // serializes the form's elements.
	           success: function(data)
	           {
               		jQuery.msgBox({
	    				title: "Success!",
	    				content: data, 
	    				type: "info",
    				});
               		setParentWindowValues();
	           }
	    });
		jQuery(".nyroModalCloseButton").click();
	    return false; // avoid to execute the actual submit of the form.
	});
	function setParentWindowValues()
	{
		var tVal = '';
		var tMatch = true;
		jQuery("#allCountries :input").each(function(){
			if(tVal!='' && tMatch)
			{
				if(tVal!=jQuery(this).val())
					tMatch =  false;
			}
			tVal = jQuery(this).val();
		});
		var chainCode = jQuery("#chainCode").val();
		var compType = jQuery("#compType").val();
		var ruleType = jQuery("#ruleType").val();
		var region = jQuery("#region").val();
		region =  region.toLowerCase();
		if(tMatch)
		{
			if(compType=='E')
			{
				jQuery("#"+region+"exdate_" + chainCode).parent().parent().children(':nth-child(1)').show();
				jQuery("#"+region+"exdate_" + chainCode).parent().parent().children(':nth-child(2)').hide();
				jQuery("#"+region+"exdate_" + chainCode).removeAttr('disabled');
				jQuery("#"+region+"exdate_" + chainCode).val(tVal);
			}
			else
			{
				if(ruleType=='R')
				{
					jQuery("#"+region+"rule_" + chainCode).parent().parent().children(':nth-child(1)').show();
					jQuery("#"+region+"rule_" + chainCode).parent().parent().children(':nth-child(2)').hide();
					jQuery("#"+region+"rule_" + chainCode).removeAttr('disabled');
					jQuery("#"+region+"rule_" + chainCode).val(tVal);
				}
				else
				{
					jQuery("#"+region+"date_" + chainCode).parent().parent().children(':nth-child(1)').show();
					jQuery("#"+region+"date_" + chainCode).parent().parent().children(':nth-child(2)').hide();
					jQuery("#"+region+"date_" + chainCode).removeAttr('disabled');
					jQuery("#"+region+"date_" + chainCode).val(tVal);
				}
			}
			jQuery("#"+region+"_"+chainCode).removeClass("lightBT").addClass("darkBT");
		}
		else
		{
			if(compType=='E')
			{
				jQuery("#"+region+"exdate_" + chainCode).parent().parent().children(':nth-child(2)').show();
				jQuery("#"+region+"exdate_" + chainCode).parent().parent().children(':nth-child(1)').hide();
				jQuery("#"+region+"exdate_" + chainCode).attr('disabled', 'disabled');
			}
			else
			{
				if(ruleType=='R')
				{
					jQuery("#"+region+"rule_" + chainCode).parent().parent().children(':nth-child(2)').show();
					jQuery("#"+region+"rule_" + chainCode).parent().parent().children(':nth-child(1)').hide();
					jQuery("#"+region+"rule_" + chainCode).attr('disabled', 'disabled');
				}
				else
				{
					jQuery("#"+region+"date_" + chainCode).parent().parent().children(':nth-child(2)').show();
					jQuery("#"+region+"date_" + chainCode).parent().parent().children(':nth-child(1)').hide();
					jQuery("#"+region+"date_" + chainCode).attr('disabled', 'disabled');
				}
			}
			jQuery("#"+region+"_"+chainCode).removeClass("darkBT").addClass("lightBT");
		}
		
		jQuery("#popupRuleDate_" + chainCode).val(ruleType);
		jQuery("#popupCompRule_" + chainCode).val(compType);
	}
	jQuery(document).ready(function(){
		
		jQuery("#del_all_countries").on("click",function(){
			jQuery("#del_all_countries_expiry_date").val("All_COUNTRY_EXPIRY_DATE_DELETE");
			jQuery("#all_countries").val("");
			deleteAllCountriesVal();
		});
		
		
		
		jQuery("#all_countries").bind("change",changeAllCountries);
		
		var tVal = '';
		var tMatch = true;
		
		jQuery("#allCountries input[type='text']").each(function(){
			if(tVal!='' && tMatch)
			{
				if(tVal!=jQuery(this).val())
					tMatch =  false;
			}
			tVal = jQuery(this).val();
		});
		
		jQuery("#allCountries select").each(function(){
			if(tVal!='' && tMatch)
			{
				if(tVal!=jQuery(this).val())
					tMatch =  false;
			}
			tVal = jQuery(this).val();
		});
		
		if(tMatch)
		{
			jQuery("#all_countries").val(tVal);
		}
	
		
	});

	 function changeAllCountries()
	 {
		 jQuery("#allCountries input[type='text']").each(function(){ // setting values to only those inputs which have type="text" 
				jQuery(this).val(jQuery("#all_countries").val());
			});
		
		 jQuery("#allCountries select").each(function(){ // setting values to only those inputs which have type="text" 
				jQuery(this).val(jQuery("#all_countries").val());
		});
	 }
	 
	 function deleteAllCountriesVal()
	 {
		 
		jQuery("#allCountries input[type='text']").each(function(){//#allCountries input:hidden
			jQuery(this).val("");
		});
		
		jQuery("#allCountries input:hidden").each(function(){//#allCountries input:hidden
			jQuery(this).val("delDate");
		});
	 }
	
	 function delCountryDate(countryCode){
		 var countryDate = jQuery("#country_"+countryCode).val();
		 var countryDateLength = jQuery("#country_"+countryCode).val().length;
		 if(countryDateLength > 0 && countryDate != ''){
			 jQuery("#delDatecountry_"+countryCode).val("delDate");
			 jQuery("#country_"+countryCode).val("");
		 } else {
			 jQuery.msgBox({
					title: "Error!",
				    content: "Please select a date first!!!",
				    type: "error"
			    });
		 }
	 }
	
</script>