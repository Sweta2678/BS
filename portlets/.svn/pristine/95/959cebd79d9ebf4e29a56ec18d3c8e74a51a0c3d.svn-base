<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.ihg.brandstandards.bridge.util.BrandStandardsUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@include file="/html/preferences/init.jsp" %>
<%
    Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap();
    long userId = 0;
    Preferences accessUserPrefs = null;
    boolean isUserOnGEMScope = GetterUtil.getBoolean(request.getAttribute("isUserOnGEMScope"), false);
    String selectedRegion = StringPool.BLANK;
    
    if(isUserOnGEMScope){
    	selectedRegion = GetterUtil.getString(request.getAttribute("regCodeFrmUsrRole"), StringPool.BLANK);
    	accessUserPrefs = (Preferences) session.getAttribute("gemPreferences");    	
    } else {
    	accessUserPrefs = (Preferences) session.getAttribute("Preferences");
    }
  
    String selectedBrand = "";   
    if (accessUserPrefs != null)
    {
        selectedBrand = accessUserPrefs.getBrand();
        selectedRegion = accessUserPrefs.getRegionCode();
    }
   	pageContext.setAttribute("selectedRegion", selectedRegion);
%>

<script type="text/javascript">
    var currentBrandName = '<%=selectedBrand%>';
    var selectBrandErrorMsg = "${selectBrandErrorMsg}";
    var selectRegionErrorMsg = "${selectRegionErrorMsg}";
    var selectDeptErrorMsg = "${selectDeptErrorMsg}";
    var isGemAdmin = "${isGemAdmin}";
    var isGEMPage = "${isUserOnGEMScope}";
    
    function changeSettings()
    {
        //validate dropdowns are selected
        if(jQuery("#access_corp_choose_brand").val() == "" || jQuery("#access_corp_choose_brand").val() == null)
        {
            alert(selectBrandErrorMsg);
            return false;
        }
        else if(isGEMPage == "true" && isGemAdmin == "true" && (jQuery("#access_corp_choose_region").val() == "" || jQuery("#access_corp_choose_region").val() == null))
        {
        	alert(selectRegionErrorMsg);
            return false;
        } else if(isGEMPage == "true" && (jQuery("#access_corp_choose_dept").val() == "" || jQuery("#access_corp_choose_dept").val() == null))
        {
        	alert(selectDeptErrorMsg);
            return false;
        }
        //access_corp_choose_dept
        else 
        {
            var hidBrand = document.getElementById('<portlet:namespace/>chnCd');
            var hidRegion = document.getElementById('<portlet:namespace/>rgnCd');
            
            hidBrand.value = jQuery("#access_corp_choose_brand").val();
            hidRegion.value = jQuery("#access_corp_choose_region").val();
            var frm  = document.getElementById('<portlet:namespace/>accessForm');
            frm.submit();
        }
    }
    
    $( ".yourviewcancel" ).click(function() {
        if (currentBrandName != null && currentBrandName != '' && currentBrandName != 'null') {
            $( "#yourviewModal" ).dialog("close");
        } else {
            window.location.reload();
        }
    });
    
    function cancelYourViewModal(){
        if (currentBrandName != null && currentBrandName != '' && currentBrandName != 'null') {
            $( "#yourviewModal" ).dialog("close");
        } else {
            window.location.reload();
        }
    }
    
    
</script>

<portlet:actionURL var="accessPrefs" name="setPreference"></portlet:actionURL>

<aui:form  title="User Preferences Form"  action="${accessPrefs}" method="post" name="accessForm" id="accessForm" class="nomargin">
	<aui:input type="hidden" id="applyCorpButton" name="applyCorpButton" value="false"/>
	<aui:input type="hidden" id="userId" name="userId" value="<%=userId %>"/>
	<aui:input type="hidden" id="chnCd" name="chnCd" value=""/>
	<aui:input type="hidden" id="rgnCd" name="rgnCd" value=""/>
	<aui:input type="hidden" id="mnlType" name="mnlType" value=""/>
    <div class="modal_body">
        <div class="row-fluid">
            <div class="pad10">
            	<p>
	            	<c:choose>
	            		<c:when test="${isUserOnGEMScope}">
	            			This application allows you to select what Standard will be measured for a particular brand in the Global Evaluation Manager (GEM).
	            		</c:when>
	            		<c:otherwise>
	            			This application allows you to adjust what's about to be published for a particular Brand.
	            		</c:otherwise>
	            	</c:choose>
            	</p>
                <div class="form-horizontal">
	                <div class="control-group">
	                    <label class="control-label" for="access_corp_choose_brand" title="Brand"><strong>Brand</strong></label>
	                    <div class="controls">
	                    
	                        <select id="access_corp_choose_brand" class="access_corp_choose_brand" 
	                            name="access_corp_choose_brand" title="select Brand value" >
	                            <option value="">Please select</option>
	                            <%  for (String chncode : chnCdMap.keySet()) {
	                                    if (selectedBrand != null && selectedBrand.equals(chncode)) {
	                            %>      
	                                        <option  value='<%=chncode%>' selected><%=chnCdMap.get(chncode)%></option> 
	                            <%		} else { %>      
	                                        <option value='<%=chncode%>'><%=chnCdMap.get(chncode)%></option> 
	                            <%      }
	                                }
	                            %> 
	                        </select>
	                    </div>
	                </div>
	                <c:if test="${not empty departments}">
	                	<div class="control-group">
		                    <label class="control-label" for="access_corp_choose_brand" title="Department"><strong>Department</strong></label>
		                    <div class="controls">
		                        <select id="access_corp_choose_dept" class="access_corp_choose_region" 
		                            name="access_corp_choose_dept" title="select Department value" >
		                            <option value="">Please select</option>
		                            <c:forEach var="department" items="${departments}" varStatus="status">
		                            	<c:choose>
		                            		<c:when test="${department.departmentId eq gemPreferences.departmentId}">
		                            			<option title="${department.description}" value="${department.departmentId}" selected>${department.departmentName}</option>
		                            		</c:when>
		                            		<c:otherwise>
		                            			<option title="${department.description}" value="${department.departmentId}">${department.departmentName}</option>
		                            		</c:otherwise>
		                            	</c:choose>
		                            </c:forEach>
		                        </select>
		                    </div>
		                </div>
	                </c:if>
	                <c:if test="${isUserOnGEMScope}">
		                <c:choose>
			                <c:when test="${isGemAdmin}">
				                <div class="control-group">
				                    <label class="control-label" for="access_corp_choose_brand" title="Region"><strong>Region</strong></label>
				                    <div class="controls">
				                        <select id="access_corp_choose_region" class="access_corp_choose_region" 
				                            name="access_corp_choose_region" title="select Region value" >
				                            <option value="">Please select</option>
				                            <%-- <option value="GLBL" <c:if test='${selectedRegion  eq "GLBL"}'> selected</c:if> >Global</option> --%>
				                            <option value="AMEA" <c:if test='${selectedRegion  eq "AMEA"}'> selected</c:if> >AMEA</option>
				                            <option value="AMER" <c:if test='${selectedRegion  eq "AMER"}'> selected</c:if> >AMER</option>
				                            <option value="GC" <c:if test='${selectedRegion  eq "GC"}'> selected</c:if> >GC</option>
				                            <option value="EURO" <c:if test='${selectedRegion  eq "EURO"}'> selected</c:if> >EURO</option>
				                        </select>
				                    </div>
				                </div>
			                </c:when>
			                <c:otherwise>
			                	<label class="control-label" for="access_corp_choose_brand" title="Region"><strong>Region</strong></label>
			                	<div class="controls">
			                		<select id="access_corp_choose_region" class="access_corp_choose_region" name="access_corp_choose_region" title="select Region value" >
			                			<option value="${selectedRegion}">${selectedRegion}</option>
			                		</select>
			                	</div>
			                </c:otherwise>
		                </c:choose>
	                </c:if>
            	</div>
       		</div> 
    	</div>
    	<div class="modal-footer">
	        <a class="btn pull-left yourviewcancel" href="javascript:cancelYourViewModal()" title="Cancel">Cancel</a>
	        <button  id="changeSettingsButton" class="btn btn-primary pull-right" type="button"  title="${changeSettings}" onclick="javascript:changeSettings()">Change</button>
    	</div>
    </div>
</aui:form>