
<%@include file="/html/editStates/init.jsp" %>
<portlet:actionURL  name="SaveCountries" var="SaveCountries"/>
<form name="saveCountries" method="POST" id="saveCountries" action="<%=SaveCountries%>">
<div class="modal-body">
	<input type="hidden" name="publishId" id="publishId" value="${publishId}">
	<input type="hidden" name="crntPg" id="crntPg" value="${crntPg}">
	<input type="hidden" name="rcPrPg" id="rcPrPg" value="${rcPrPg}">
	<div class="row-fluid">
		<div class="span6">
			<h4>Region: <c:out value="${region}" /></h4>
		</div>
		<div class="span6 pull-right">
			<div class="pull-right">
				All attributed countries/region: 
					<select class="input-ian" name="all" id="all">
					    <option value="-1" selected="selected">All</option>
						<c:forEach items="${stateList}" var="state">
							<option value="${state.publishStatusCode}">${state.publishStatusName}</option>
						</c:forEach>
					</select>
			</div>
		</div>
	 </div>
	 <div class="row-fluid" id="allCountries">
     	<div class="span12">
       		<table width="100%" id="wobble">
       			<tbody id="rgn-cnt-tbody">
       			  <c:forEach items="${countryNameList}" var="allcountry" varStatus="index">
       			  		<c:set var="bFound" value="false" />
						<c:if test="${index.count % 2 eq 1 }">
							<tr>
					    </c:if>
							<td width="250px" class="ri"><c:out value='${allcountry.value}' /></td>
							<td width="250px">
					    <c:forEach items="${countryList}" var="country">
					    	<c:if test="${!bFound && allcountry.key eq country.countryCode}">
					    		<c:set var="bFound" value="true" />
					    		<select class="input-ian2" name="${country.countryCode}" id="${country.countryCode}">
									<c:forEach items="${stateList}" var="state">
										<c:choose>
											<c:when test="${state.publishStatusCode eq country.statusCode}">
												<option value="${state.publishStatusCode}" selected="selected">${state.publishStatusName}</option>
											</c:when>
											<c:otherwise>
												<option value="${state.publishStatusCode}">${state.publishStatusName}</option>
											</c:otherwise>
										</c:choose>								
									</c:forEach>
								</select>
					    	</c:if>
						</c:forEach>
						<c:if test="${bFound == false}">
						   	 <select class="input-ian2" name="NONAME" id="NONAME" disabled="disabled">
						   	 	<option value="-100">Not Attributed</option>
						   	 </select>
						</c:if>
							</td>
						<c:if test="${index.count % 2 eq 0 }">
								</tr>
						</c:if>
					</c:forEach>
       			</tbody>
       		</table>
     	</div>
   	</div>
</div>
<div class="modal-footer">
    <button aria-hidden="true" data-dismiss="modal" type="button" name="cancel" id="cancel" class="btn pull-left">Cancel</button>
    <button aria-hidden="true" data-dismiss="modal" type="submit" name="submit" id="submit" class="btn btn-primary pull-right">Save</button>
</div>
</form>
<script language="javascript">
jQuery(function(){
	jQuery( "#cancel" ).click(function() {
		jQuery( "#regionCountrylist" ).dialog( "close" );
	});
});

jQuery(document).ready(function(){
	jQuery("#all").bind("change",changeAllCountries);
	
	var defaultTxt = '';
	var changed = false;
	jQuery("#allCountries :input").each(function(){
		if(!changed && defaultTxt!='' && defaultTxt!=jQuery(this).val())
		{
			changed = true;
		}
		defaultTxt = jQuery(this).val();
	});
	
	<c:if test="${readOnly}">
		jQuery("#saveCountries :input").prop("disabled", true);
		jQuery("#saveCountries select").prop('disabled', 'disabled');
		jQuery("#submit").attr('disabled','disabled');
	</c:if>
});

 function changeAllCountries()
 {
	jQuery("#allCountries :input").each(function(){
		jQuery(this).val(jQuery("#all").val());
	});
 }
 
</script>