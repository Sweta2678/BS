<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.ihg.brandstandards.bridge.util.BridgeConstants"%>
<%@include file="/html/editStates/init.jsp" %>

<script type="text/javascript" src="/BSBridge-theme/js/treeAdmin/jquery.blockUI.js"></script>
<script type="text/javascript" src="/BSBridge-theme/js/treeAdmin/jquery.msgBox.js"></script>

<portlet:actionURL  name="SaveCountries" var="SaveCountries"/>
<portlet:actionURL name="FilterData" var="FilterData" />
<portlet:actionURL name="ClearFilter" var="ClearFilter" />
<portlet:resourceURL var="SaveState" id="SaveState" />
<portlet:resourceURL var="ShowCountries" id="ShowCountries" />
<portlet:resourceURL var="ExcelExport" id="ExcelExport" />
<portlet:actionURL var="ExcelImport" name="ExcelImport" />

<script type="text/javascript">
    var showCountriesURL = '${ShowCountries}';
    var changeStateURL = '${SaveState}';
    var clearFilterURL = '${ClearFilter}';
	var excelExportURL = '${ExcelExport}';
	var excelImportURL = '${ExcelImport}';
	var byIdString = '${byId}';
	var crntPg = '${crntPg1}';
	var rcPrPg = '${rcPrPg1}';	
	$(document).ready(function() {
		/* Hiding Un-necessary info of liferay search container */
		if(jQuery('.search-results').length > 0){
			jQuery(".table-striped").css({"display":"none"}); 
		} else {
			jQuery(".taglib-search-iterator-page-iterator-bottom").css({"display":"none"});
		}
	});
</script>
<style type="text/css">
	.lfr-search-container {margin-top: 0px;!important;}
	.pager {margin: 10px 0 !important;}
</style>
<c:choose>
<c:when test ="${!notLoggedIn}">
<%
    SearchContainer<BridgePublishAppModel> searchContainerObj = (SearchContainer<BridgePublishAppModel>) request.getAttribute("searchContainerObj");
%>
<script type="text/javascript">
	<% if (searchContainerObj !=null) { %>
		crntPg = <%=searchContainerObj.getCur()%>;
		rcPrPg = <%=searchContainerObj.getDelta()%>;
	<% } %>
</script>
<script src="/BSBridge-portlet/js/jquery.highlight.js"></script>
<script src="/BSBridge-portlet/js/editstate.js"></script>
<c:if test="${errorMessage ne null}">
    <c:out value="${errorMessage}"></c:out>
</c:if>

<c:choose>
	<c:when test="${activePublish}">
<!-- Keep the below 2 un-closed divs as this is a fix for footer left aligning issue -->
<div><div>

<div class="row"> 
    <div class="well well-small" style="margin-bottom: 2px;">
	    <div class="row">
			<div class="span6">
				<div class="pull-left"></div>
			</div>
			<div class="span6">
				<div class="pull-right">
					<c:if test="${superUser eq 'SUPER' || globalUser eq 'GLOBAL' || (searchContainerObj ne null  && searchContainerObj.total > 0 && allReadOnly ne 'true')}">
						<a role="button" class="btn btn-primary" onclick="javascript: showImportPopup();"><i class="icon-arrow-up icon-white"></i>Import</a>&nbsp;
					</c:if>
					<!-- <a role="button" class="btn btn-primary" onclick="javascript:exportFilter();"><i class="icon-arrow-down icon-white"></i>Export</a> -->
                    <a class="btn btn-primary create-report" href="#" id="create-report" ><i class="icon-white icon-arrow-down"></i>Export</a>
				</div>
			</div>
		</div>
		<hr>
       	<form class="form-inline form-search" style="margin-bottom: 0;" name="formbystate" id="formbystate" method="POST" action="<%=FilterData%>">
        <div class="row" style="margin-top: 5px;"> 
         <div class="span6"> 
           <div class="pull-left"> 
 
	         <span><strong>Filter By:</strong></span> &nbsp;
             <select class="input-medium" name="byState" id="byState" onChange="javascript:filterbyState();"> 
                 	<option value="">Please Select</option>
                 	<c:forEach items="${stateList}" var="state">
						<c:choose>
						<c:when test="${byState ne null && state.publishStatusCode eq byState}">
							<option value="${state.publishStatusCode}" selected="selected">${state.publishStatusName}</option>
						</c:when>
						<c:otherwise>
							<option value="${state.publishStatusCode}">${state.publishStatusName}</option>
						</c:otherwise>
						</c:choose>								
					</c:forEach>
					<option value="BYCNTRY" <c:if test="${byState eq 'BYCNTRY'}">selected="selected"</c:if> >By Country/Region Variations</option>
             </select> 
          </div> 
          </div> 
          <div class="span6"> 
             <div class="pull-right"> 
             	   <span><strong>Find By ID:</strong></span> 
             	   <input type="text" style="margin-bottom: 0px;" value="${byId}" class="input-medium" placeholder="Enter STD ID to find ..." name="byId" id="byId" maxlength="2000"> 
             	     <a href="#find" role="button" class="btn btn-primary" onclick="javascript:filterbyId();"><i class="icon-search icon-white"></i> Go</a> 
             	     <a href="#clearFind" role="button" class="btn" onclick="javascript:clearFilter();"><i class="icon-remove"></i> Clear</a> 
             </div> 
         </div> 
      </div>  
    </form>
    </div> 
 </div>

<c:if test="${not empty notFound }">
	<div class="alert alert-warning" role="alert">
    	<strong>The following terms were not found <c:out value="${notFound}"/></strong> 
   	</div>
   	<%  searchContainerObj.setEmptyResultsMessage(StringPool.BLANK); %> <!-- Here we set empty message for search container, to remove multiple message i.e. above message and empty result message. -->
</c:if>

<section id="standards">
    <div id="result" style="min-height:400px;">
    <c:set var="prevPath" value="-" />
    <table>
<liferay-ui:search-container id="searchContainer" searchContainer="<%=searchContainerObj%>">
    <liferay-ui:search-container-results results="<%=searchContainer.getResults()%>" total="<%=searchContainer.getTotal()%>"/>
    <liferay-ui:search-container-row className="com.ihg.brandstandards.bridge.model.BridgePublishAppModel" keyProperty="stdId" modelVar="std" >
    <c:set var="currPath" value="${std.taxonomyPath}${ std.taxonomyText}" />
    <c:choose>
        <c:when test="${currPath eq prevPath}">
        </c:when>
        <c:otherwise>
           <tr><td>
            <div class="row" >
                <h4 >
                    <span class="grey" >
                      ${std.taxonomyPath}
                    </span>
                    <c:out value="${std.taxonomyText}"/>
                </h4>
            </div>
          </td></tr>
        </c:otherwise>
    </c:choose>
    <tr> 
        <td>
         <div  class="row">
           <table class="specs" border="0">
            <tbody>
                <tr>
                    <td width="140px" class="ri">
                        <c:if test="${!std.readOnly || std.state eq byCountry}">
                            <a onclick='javascript:showCountry(<c:out value="${std.publishId}" /> , <c:out value="${std.readOnly && std.state eq byCountry}" />);'><i class="icon-edit"></i></a>&nbsp;
                        </c:if>
                        <select name='<c:out value="${std.publishId}" />' id='<c:out value="${std.publishId}" />' 
                            class="input-ian" <c:if test="${std.state eq byCountry || std.readOnly}">disabled="disabled"</c:if> 
                            onChange='javascript:changeState(<c:out value="${std.publishId}" />);'>
                            <c:forEach items="${stateList}" var="state">
                                <c:choose>
                                    <c:when test="${state.publishStatusCode eq std.state}">
                                        <option value="${state.publishStatusCode}" selected="selected">${state.publishStatusName}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${state.publishStatusCode}">${state.publishStatusName}</option>
                                    </c:otherwise>
                                </c:choose>                             
                            </c:forEach>
                            <c:if test="${std.state eq byCountry}">
                                <option value="${byCountry}" selected="selected"><%=BridgeConstants.BY_COUNTRY%></option>
                            </c:if>
                        </select>
                    </td>
                    <td colspan="2"><strong><c:out value="${ std.title}"/><span id="s_id"><c:out value="[${std.stdId }] "/></span></strong></td>
                </tr>
                <c:forEach items="${std.specifications}" var="specStd">
                    <tr>
                        <td width="140px" class="ri">
                            <c:if test="${!specStd.readOnly || specStd.state eq byCountry}">
                                <a onclick='javascript:showCountry(<c:out value="${specStd.publishId}" /> , <c:out value="${specStd.readOnly && specStd.state eq byCountry}" />);'><i class="icon-edit"></i></a>&nbsp;
                            </c:if>
                            <select name='<c:out value="${specStd.publishId}" />' id='<c:out value="${specStd.publishId}" />' class="input-ian" <c:if test="${specStd.state eq byCountry || specStd.readOnly }">disabled="disabled"</c:if>  onChange='javascript:changeState(<c:out value="${specStd.publishId}" />);' >
                          
                                <c:forEach items="${stateList}" var="state">
                                    <c:choose>
                                        <c:when test="${state.publishStatusCode eq specStd.state}">
                                            <option value="${state.publishStatusCode}" selected="selected">${state.publishStatusName}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${state.publishStatusCode}">${state.publishStatusName}</option>
                                        </c:otherwise>
                                    </c:choose>                             
                                </c:forEach>
                                <c:if test="${specStd.state eq byCountry}">
                                    <option value="${byCountry}" selected="selected"><%=BridgeConstants.BY_COUNTRY%></option>
                                </c:if>
                            </select>

                        </td>
                        <td class="bull">&#8226;</td>
                        <td><c:out value="${ specStd.title}"/><span id="s_id"><c:out value="[${specStd.stdId }] "/></span></td>
                    </tr>
                    
                </c:forEach>
                <c:if test="${fn:length(std.guidelines) gt 0}">
                    <tr>
                        <td class="update invisible"></td>
                            <td style="padding-top:5px;" class="lg" colspan="2"><strong>Guidelines</strong></td>
                        </tr>
                <c:forEach items="${std.guidelines}" var="gdlnStd">
                    <tr>
                        <td width="140px" class="ri">
                           <c:if test="${!gdlnStd.readOnly || gdlnStd.state eq byCountry}">
                                <a onclick='javascript:showCountry(<c:out value="${gdlnStd.publishId}" /> , <c:out value="${gdlnStd.readOnly && gdlnStd.state eq byCountry}" />);'><i class="icon-edit"></i></a>&nbsp;
                            </c:if>
                            <select name='<c:out value="${gdlnStd.publishId}" />' id='<c:out value="${gdlnStd.publishId}" />' class="input-ian" <c:if test="${gdlnStd.state eq byCountry || gdlnStd.readOnly}">disabled="disabled"</c:if>  onChange='javascript:changeState(<c:out value="${gdlnStd.publishId}" />);' >
                          
                                <c:forEach items="${stateList}" var="state">
                                    <c:choose>
                                        <c:when test="${state.publishStatusCode eq gdlnStd.state}">
                                            <option value="${state.publishStatusCode}" selected="selected">${state.publishStatusName}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${state.publishStatusCode}">${state.publishStatusName}</option>
                                        </c:otherwise>
                                    </c:choose>                             
                                </c:forEach>
                                <c:if test="${gdlnStd.state eq byCountry}">
                                    <option value="${byCountry}" selected="selected"><%=BridgeConstants.BY_COUNTRY%></option>
                                </c:if>
                            </select>
                        </td>
                        <td class="bull lg">&#8226;</td>
                        <td class="lg"><c:out value="${gdlnStd.title} "/><span id="s_id"><c:out value="[${gdlnStd.stdId }] "/></span></td>
                    </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
        <hr>
    </div>
    </td>
    </tr>
        <c:set var="prevPath" value="${currPath}" />
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator/>
</liferay-ui:search-container>
</table>
</div>
</section>

<div id="regionCountrylist" title="Edit States" style="display:none">
</div>

<div id="ImportState" title="Import States" style="display:none">
	<form name="importstateform" method="POST" id="importstateform" action="<%=ExcelImport%>" enctype="multipart/form-data">
	<div class="modal-body">
		<div class="row-fluid">
			<div >
				Import File : 
				<input name="file" id="file" type="file" class="add_item_file_input"/>
		    </div>
		</div>
	</div>
	<div class="modal-footer">
	    <button aria-hidden="true" data-dismiss="modal" type="button" name="cancel" id="cancel" class="btn pull-left">Cancel</button>
	    <button aria-hidden="true" data-dismiss="modal" type="submit" name="submit" id="submit" class="btn btn-primary pull-right">Import</button>
	</div>
	</form>
</div>

<div id="confirm-dialog" title="Confirmation" style="display:none">
    <div class="modal-body" id="confirm-dialog-message">
      
    </div>
    <div class="modal-footer">
        <div class="pull-right"><button type="button" id="confirm-dialog-ok" class="btn btn-primary">Ok</button></div>
    </div>
</div>

<!-- Export Report -->
<div id="createReportDialog" title="Create Report" style="display:none">
    <form id="createReportForm" name="createReportForm" method="post" >
        <div class="modal-body">
            <div id="reportLst">
                <span><input type='radio' name='reports' value='137' checked />Edit States Report</span>
            </div>
            <h4>Report Title <input type="text" id="reportTitle" name="reportTitle"/> </h4> 
          </div>
        <div class="modal-footer">
            <div class="pull-left"><button type="button" class="btn reportCancel">Cancel</button></div>
            <div class="pull-right"><a class="btn btn-primary" href="javascript:createReport()">Run</a></div>
        </div>
    </form>
</div>
<!-- End Of Export Report -->

	</c:when>
		<c:otherwise>
			Please create new publication.
		</c:otherwise>
	</c:choose>
</c:when>
<c:otherwise>
    Not logged in !!
</c:otherwise>
</c:choose>