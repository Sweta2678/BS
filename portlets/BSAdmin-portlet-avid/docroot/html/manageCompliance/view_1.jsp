<%@include file="/html/init.jsp" %>
<%@page import="com.ihg.brandstandards.db.model.Standards"%>
<%@page import="com.ihg.brandstandards.bsadmin.model.ComplianceView"%>
<%@page import="com.ihg.brandstandards.bsadmin.model.BrandRegionProperties"%>

<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/bsstyle.css" />
<!--<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>-->
<portlet:resourceURL var="searchExpireStd" id="searchExpireStd">
	<portlet:param name="id" value="${id}"></portlet:param>
</portlet:resourceURL>
<portlet:resourceURL var="validateExpiry" id="validateExpiry">
	<portlet:param name="id" value="${id}"></portlet:param>
</portlet:resourceURL>
<script type="text/javascript">
var searchExpireURL = '<%= searchExpireStd %>';
var validateExpiryURL = '<%= validateExpiry %>';
</script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery-1.9.1.min.js"></script>
<!--<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>-->
<script type="text/javascript" src="/BSTheme-theme/js/jquery-ui-1.10.1.custom.min.js"></script>
<link href="/BSTheme-theme/css/other/jquery-ui-1.10.1/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/jquery.multiselect.css" />
<script src="/BSTheme-theme/js/jquery-ui-multiselect-widget.js"></script>
<link type="text/css" rel="stylesheet"
	href="/BSTheme-theme/css/bsstyle.css" />
<script type="text/javascript" src="/BSTheme-theme/js/jquery.nyroModal.custom.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.msgBox.js"></script>
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/msgBoxLight.css"/>
<script type="text/javascript" src="/BSTheme-theme/js/manageCompliance.js"></script>
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/manageCompliance.css" />
<portlet:actionURL name="saveComplianceRule" var="saveComplianceRuleURL">
	<portlet:param name="id" value="${id}"></portlet:param>
	<portlet:param name="urlQuery" value="${urlQuery}"></portlet:param>
</portlet:actionURL>


<div class="grid_12">

	<div class="rounded_container">

        <div class="rounded_container_contents">

            <h4>Manage Compliance Rules</h4>

			<form id="complianceForm" method="post" action="<%= saveComplianceRuleURL %>" class="bbq" >
				<div>
                	<!-- <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>  -->
                	<table id="compliance_table">
                    	<tr class="compl_title">
                        	<td>Brand</td>
                            <td>Published Date</td>
                            <td>GLOBAL</td>
                            <td>AMEA</td>
                            <td>AMER</td>
                            <td>EUROPE</td>
                            <td>GC</td>
                        </tr>
                        <c:forEach items="${complianceView.brandRegionMapping}" var="brandRegionMapping">
                        <tr>
                        	<td>${complianceView.allBrands[brandRegionMapping.key]}</td>
                            <td>${complianceView.brandPublishedDate[brandRegionMapping.key]}</td>
                            <td><p class="expire_id"  <c:if test="${complianceView.expireIds[brandRegionMapping.key] ne null}"> title="Expires ${complianceView.expireIds[brandRegionMapping.key]}" </c:if>>${brandRegionMapping.value['GLBL'].validity} <c:if test="${brandRegionMapping.value['GLBL'].editable}" ><a class="comp_regional"><img src="/BSTheme-theme/images/edit_pencil_icon.png" /></a></c:if></td>
                            <td><p><c:choose><c:when test="${brandRegionMapping.value['GLBL'].validity eq brandRegionMapping.value['AMEA'].validity and brandRegionMapping.value['AMEA'].validity ne 'N/A'}" >-</c:when><c:otherwise>${brandRegionMapping.value['AMEA'].validity} </c:otherwise></c:choose> <c:if test="${brandRegionMapping.value['AMEA'].editable}" ><a class="comp_regional"><img src="/BSTheme-theme/images/edit_pencil_icon.png" /></a></c:if></p></td>
                            <td><p><c:choose><c:when test="${brandRegionMapping.value['GLBL'].validity eq brandRegionMapping.value['AMER'].validity and brandRegionMapping.value['AMER'].validity ne 'N/A'}" >-</c:when><c:otherwise>${brandRegionMapping.value['AMER'].validity} </c:otherwise></c:choose> <c:if test="${brandRegionMapping.value['AMER'].editable}" ><a class="comp_regional"><img src="/BSTheme-theme/images/edit_pencil_icon.png" /></a></c:if></p></td>
                            <td><p><c:choose><c:when test="${brandRegionMapping.value['GLBL'].validity eq brandRegionMapping.value['EURO'].validity and brandRegionMapping.value['EURO'].validity ne 'N/A'}" >-</c:when><c:otherwise>${brandRegionMapping.value['EURO'].validity} </c:otherwise></c:choose> <c:if test="${brandRegionMapping.value['EURO'].editable}" ><a class="comp_regional"><img src="/BSTheme-theme/images/edit_pencil_icon.png" /></a></c:if></p></td>
                            <td><p><c:choose><c:when test="${brandRegionMapping.value['GLBL'].validity eq brandRegionMapping.value['GC'].validity and brandRegionMapping.value['GC'].validity ne 'N/A'}" >-</c:when><c:otherwise>${brandRegionMapping.value['GC'].validity} </c:otherwise></c:choose> <c:if test="${brandRegionMapping.value['GC'].editable}" ><a class="comp_regional"><img src="/BSTheme-theme/images/edit_pencil_icon.png" /></a></c:if></p></td>
                        </tr>
                        <c:if test="${complianceView.brandRegionEdit[0] eq brandRegionMapping.key}">
						<tr class="comp_hidden">
                        	<td colspan="7">
                            	<div class="regional_comp_cont">
                                	<p class="regional_comp_p">Change Compliance Rule to <select id="" class="" name="complianceRule"><c:forEach items="${complianceView.validMonths}" var="monthEntrySet"><option value="${monthEntrySet.key}" <c:if test="${brandRegionMapping.value[complianceView.brandRegionEdit[1]].validity eq monthEntrySet.value}">selected</c:if>>${monthEntrySet.value}</option></c:forEach></select> after publication
									<c:if test="${not complianceView.loggedInGlobal}">
									<input type="hidden" value="${complianceView.brandRegionEdit[0]}" name="brandEdit" id="brandEdit" />
                                    <input type="hidden" value="${complianceView.brandRegionEdit[1]}" name="regionEdit" id="regionEdit" />
                                    <input type="button" id="CancelCompliance" style="float:right; margin-right:10px;" class="comp_reg_cancel" name="comp_reg_cancel" id="" alt="comp_reg_cancel" title="Cancel" value="Cancel" />
									<input type="button" id="SaveCompliance" style="float:right; margin-right:10px;" class="comp_reg_save" name="comp_reg_save" value="Save" onclick="validateComplianceForm();" />
									</c:if>
									</p>
                                    <c:if test="${complianceView.loggedInGlobal}">
                                    <p>						
									Standard or Specification ID: <input type="text" name="crs_std_id" id="crs_std_id"> <input type="button" id="SearchStd" value="Search by ID" />&nbsp;&nbsp;<span class="cross_note">Note: Only a single CMS ID is accepted</span>
									
									</p>
                                    <div id="resultSearchDiv" style="display: none;">
										<p class="expire_headers">Search Results</p>
										<div id="results">
										
										</div>
									</div>
									<div style="" id="myreferences">
										<p class="expire_headers" id="aui_3_2_0_11301">When Compliance Date reached, expire the following ID's:</p>
										<table class="expire_order" id="searchedContentTable">
											<thead>
												<tr class="cross_order_header">
													<th>ID</th>
													<th>Type</th>
													<th>Standard Text</th>
													<th class="cross_delete_cell">Delete</th>
												</tr>
											</thead>
											<tbody>
											<c:if test="${complianceView.expireIds[brandRegionMapping.key] ne null}" >
											<c:forEach items="${complianceView.expireStds[complianceView.brandRegionEdit[0]]}" var="std">
												<tr class="expiryRow" id="${std.stdId}"><td>${std.stdId}</td><td>${std.stdTyp}</td><td>${std.title}</td><td><a class="delete_expire_item"><img onclick="deleteRecord(${std.stdId})" title="delete" alt="delete" src="/BSTheme-theme/images/delete.png" style="cursor:pointer;"></a></td></tr>
											</c:forEach>
											</c:if>
											
											</tbody>
										</table>
									</div>
                                    <p class="regional_comp_p">Comment:</p>
                                    <textarea id="complianceComment" class="regional_ids_textarea" name="comment"></textarea><br/>
									<input type="hidden" value="${complianceView.brandRegionEdit[0]}" name="brandEdit" id="brandEdit" />
                                    <input type="hidden" value="${complianceView.brandRegionEdit[1]}" name="regionEdit" id="regionEdit" />
									<input type="hidden" name="expireIds" id="expireIds" />
                                    <input type="button" id="SaveCompliance" style="float:right; margin-right:45px;" class="comp_reg_save" name="comp_reg_save" value="Save" onclick="validateComplianceForm();" />
                                    <input type="button" id="CancelCompliance" style="float:right; margin-right:10px;" class="comp_reg_cancel" name="comp_reg_cancel" id="" alt="comp_reg_cancel" title="Cancel" value="Cancel" />
                                    </c:if>
                                </div>
                            </td>
                        </tr>
                        </c:if>
                        </c:forEach>
                        
                    </table>
                    <div class="clear"></div>
				</div>
				</form>
                <div class="clear"></div>
                <input type="button" value="Back To Standards" title="Back" onclick="location.href='/web/brand-standards/standards${urlQuery}'" />

                </div>
			
			<!--<div class="clear"></div>-->
            
        </div><!--ends rounded_container_contents -->

        <div class="rounded_container_bottom">&nbsp;</div>

    </div><!--ends rounded_container -->


<div class="clear"></div>