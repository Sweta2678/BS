<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@include file="/html/init.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.Map"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.ihg.brandstandards.db.model.BridgePublishStateEx"%>
<%@page import="com.ihg.brandstandards.bridge.model.BridgePublishAppModel"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.ihg.brandstandards.custom.model.Standard"%>

<%
	String idSearchCriteria = (String)request.getAttribute("highlightSearchIds");
	if(Validator.isNull(idSearchCriteria)){
		idSearchCriteria = "";
	}
%>
<portlet:actionURL var="FilterData" name="FilterData"/>
<portlet:resourceURL var="editCompliancehURL" id='editCompliancehURL' />
<portlet:resourceURL var="exportReportURL" id='exportReport'>
    <portlet:param name="requestType" value="exportComplianceReport" />
</portlet:resourceURL>

<script type="text/javascript" src="/BSBridge-theme/js/jquery.validate.min-1.11.1.js"></script>
<script type="text/javascript" src="/BSBridge-theme/js/additional-methods.min-1.11.1.js"></script>
<script type="text/javascript" src="/BSBridge-theme/js/treeAdmin/jquery.blockUI.js"></script>
<script type="text/javascript" src="/BSBridge-theme/js/treeAdmin/jquery.msgBox.js"></script>
<script type="text/javascript" src="/BSBridge-portlet/js/viewCompliance.js"></script>
<script type="text/javascript">
    var searchPerformed = '${searchPerformed}';
</script>
<style type="text/css">
	.btns-div {
	    float: left; 
	    min-height: 1px; 
	    width: 400px;
	}
	.date-div {
	    float: left; 
	    min-height: 1px; 
	    width: 518px;
	}
	.error-div {margin-left: 20px;}
	.select-date {width: 100px;}
	.input-txt {margin-bottom: 0px;}
	.export-report {padding-right: 12px;}
	.lfr-search-container {margin-top: 0px!important;}
	.pager {margin: 10px 0 !important;}
	.std-title-row {width:845px;}
	.cmpl-dt-cell {
	    width:30px;
	    text-align: center;
	}
	label.error {
	    color: red;
	    font-size: 0.8em;
	    margin-left : 0.5em;
	}
	span.complianceDate:hover{cursor: pointer;}
	span.expiryDate:hover{cursor: pointer;}
</style>

<c:choose>
	<c:when test ="${!notLoggedIn}">
 	<c:choose>
  		<c:when test="${activePublish}">
	<!-- Keep the below 2 un-closed divs as this is a fix for footer left aligning issue -->
	<div><div>
    <div class="row">
        <div class="well well-small" style="margin-bottom: 2px;">
        	<div class="row" style="background-color:#e5e5e5;">
        		<div class="pull-right export-report">
            		<a class="btn btn-primary export-report" id="export" href="#"><i class="icon-arrow-down icon-white"></i>Export</a>
        		</div>
    		</div>
    		<hr>
            <form class="form-inline form-search" style="margin-bottom: 0;" name="formCompliance" id="formCompliance" method="POST" action="<%=FilterData%>">
                <div class="row" style="margin-top: 5px !important;">
                    <div class="error-div"> 
                        <span id="error-placeholder"></span>
                    </div>
                    <div class="date-div">
                        <div class="pull-left" >
                            <span><strong>Filter By:</strong></span> &nbsp; 
                            <select class="input-small select-date" name="selectDate" id="selectDate">
                                <option value="" <c:if test="${empty filterBy}">selected="selected"</c:if> >ALL</option>
                                <option value="week" <c:if test="${'week' eq filterBy}">selected="selected"</c:if> >Week</option>
                                <option value="month" <c:if test="${'month' eq filterBy}">selected="selected"</c:if> >Month</option>
                                <option value="quarter" <c:if test="${'quarter' eq filterBy}">selected="selected"</c:if> >Quarter</option>
                                <option value="between" <c:if test="${'between' eq filterBy}">selected="selected"</c:if> >Between</option>
                            </select>
                             
                            <div class="select-dates" id="selectDatesDiv" >
                            <div id="dateFrom" class="checknow_date">
                                <input class="input-small" size="16" type="text" id="dateInputFrom" name="dateInputFrom" value="${fromDate}" >
                            </div>
                            and 
                            <div id="dateTo" class="checknow_date">
                                <input class="input-small" size="16" type="text" id="dateInputTo" name="dateInputTo" value="${toDate}" >
                            </div>
                            </div>
                        </div>
                    </div>

                    <div class="btns-div">
                        <div class="pull-right">
                            <span><strong>Find By ID:</strong></span> 
                            <input type="text" id="searchById" name="searchById" value="${findById}" class="input-medium input-txt" placeholder="Enter STD ID to find ...">
                            <a href="#find" id="findBtn" role="button" class="btn btn-primary"> <i class="icon-search icon-white"></i> Go</a>
                            <a href="#clearFind" id="clearBtn" role="button" class="btn"><i class="icon-remove"></i> Clear</a>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
                
    <section id="standards">
        <div id="result">
            <c:set var="prevPath" value="-" />
            <table class="results_table" summary="Data table for all results">
            <liferay-ui:search-container id="searchContainer" searchContainer="${searchContainerObj}" delta="1" >
            <liferay-ui:search-container-results results="<%=searchContainer.getResults()%>" total="<%=searchContainer.getTotal()%>"/>
            <liferay-ui:search-container-row className="com.ihg.brandstandards.custom.model.Standard" keyProperty="stdId" modelVar="std" >
        
            <c:set var="currPath" value="${std.taxonomyPath}${ std.currentPath}" />
            <c:choose>
                <c:when test="${currPath ne prevPath}">
                    <tr><td>
                    <div class="row" >
                        <h4><span class="grey">${std.currentPath}</span> <span class="blue"><c:out value="${std.currentTitle}"/></span></h4>
                    </div>
                    </td></tr>
                </c:when>
            </c:choose>
            <tr>
                <td>
                    <div class="row">
                        <table class="specs must-publish-list" style="border:0px">
                            <tr>
                                <!-- Future Compliance Deadline -->
                                <td class="show cmpl-dt-cell">
                                    <c:if test="${std.regionCode eq 'GLBL'}">
                                        <c:choose>
                                            <c:when test="${std.isGlobal eq 'G'}">
                                                <c:if test="${std.framework eq 'Y'}">
                                                    <img src="/BSBridge-theme/images/global_icon_red.png" class="global_icon" 
                                                    title="Global Framework standard icon" alt="Global Framework standard icon" />
                                                </c:if>
                                            </c:when>
                                            <c:otherwise>
                                                <c:if test="${std.framework eq 'Y'}">
                                                    <img src="/BSBridge-theme/images/global_icon_halfred.png" class="global_icon" 
                                                    title="Multi-region Framework standard icon" alt="Multi-region Framework standard icon" />
                                                </c:if>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:if>
                                </td>
                                <td colspan="2" class="std-title-row">
                                	<strong><c:out value="${ std.title} "/></strong><span class="grey">&nbsp;[${std.stdId }] </span>
                                   	<c:if test="${not empty std.expiryDate}">
                                        &nbsp;<a onclick='viewComplianceDetails(<c:out value="${std.stdId}" />, "<c:out value="${crntPg}" />");'>
                                        <span class="expiryDate show_inline label label-inverse">${std.expiryDate}</span>
                                        </a>
                                    </c:if>
                                    <c:if test="${not empty std.complDateStr}">
                                        &nbsp;<a onclick='viewComplianceDetails(<c:out value="${std.stdId}" />, "<c:out value="${crntPg}" />");'>
                                        <span class="complianceDate show_inline label label-info">${std.complDateStr}</span>
                                        </a>
                                        <%--  <a onclick='editCompliance(<c:out value="${std.stdId}" />, "<c:out value="${crntPg}" />");'><i class="icon-edit" style="cursor: pointer;"></i></a>&nbsp; --%>
                                    </c:if>
                                </td>
                            </tr>
                            <c:forEach var="spec" items="${std.specifications}">
                                <tr >
                                    <td class="show cmpl-dt-cell">
                                        <c:if test="${spec.regionCode eq 'GLBL'}">
                                            <c:choose>
                                                <c:when test="${spec.isGlobal eq 'G'}">
                                                    <c:if test="${spec.framework eq 'Y'}">
                                                        <img src="/BSBridge-theme/images/global_icon_red.png" class="global_icon" 
                                                        title="Global Framework standard icon" alt="Global Framework standard icon" />
                                                    </c:if>
                                                </c:when>
                                                <c:otherwise>
                                                    <c:if test="${spec.framework eq 'Y'}">
                                                        <img src="/BSBridge-theme/images/global_icon_halfred.png" class="global_icon" 
                                                        title="Multi-region Framework standard icon" alt="Multi-region Framework standard icon" />
                                                    </c:if>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:if>
                                    </td>
                                    <td class="bull">&bull;&nbsp; </td>
                                    <td>${spec.title} <span class="grey">&nbsp;[${spec.stdId}] </span> 
                                        <c:if test="${not empty spec.expiryDate}">
                                            &nbsp;<a onclick='viewComplianceDetails(<c:out value="${spec.stdId}" />, "<c:out value="${crntPg}" />");'>
                                            <span class="expiryDate show_inline label label-inverse">${spec.expiryDate}</span>
                                            </a>
                                        </c:if>
                                        <c:if test="${not empty spec.complDateStr}">
                                            &nbsp;<a onclick='viewComplianceDetails(<c:out value="${spec.stdId}" />, "<c:out value="${crntPg}" />");'>
                                            <span class="complianceDate show_inline label label-info">${spec.complDateStr}</span>
                                            </a>
                                            <%-- <a onclick='editCompliance(<c:out value="${spec.stdId}" />, "<c:out value="${crntPg}" />");'><i class="icon-edit" style="cursor: pointer;"></i></a>&nbsp; --%>
                                        </c:if>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>  
                        <hr>                          
                    </div>
                </td>
            </tr>
            <c:set var="prevPath" value="${currPath }" />
            </liferay-ui:search-container-row>
            <liferay-ui:search-iterator />
            </liferay-ui:search-container>
            </table> 
        </div>
    </section>
    </c:when>
    <c:otherwise>
        Please create new publication.
    </c:otherwise>
 </c:choose>
    
<div id="exportReport" title="Compliance Report" style="display:none">
<form id="exportForm" name="exportForm" method="post" >
    <div class="modal-body">
        <input type="radio" checked  style="margin-top: -3px;"/>Export Compliance Report
        <h4>Report Title <input type="text" id="reportTitle" name="reportTitle"/> </h4> 
      </div>
    <div class="modal-footer">
        <div class="pull-left"><button type="button" class="btn exportCancel">Cancel</button></div>
        <div class="pull-right"><a class="btn btn-primary" href="javascript:createExportReport('${exportReportURL}', ${reportId})">Run</a></div>
    </div>
</form>
</div>

</c:when>
<c:otherwise>
    Not logged in !!
</c:otherwise>
</c:choose>

<script type="text/javascript">
$(document).ready(function() {
	/* Hiding Un-necessary info of liferay search container */
	if(jQuery('.search-results').length > 0){
		jQuery(".table-striped").css({"display":"none"}); 
	} else {
		jQuery(".taglib-search-iterator-page-iterator-bottom").css({"display":"none"});
	}
	var idCriteria = [<%=idSearchCriteria%>];
	for(var l = 0; l < idCriteria.length; l++) {
		$("#standards").highlight(idCriteria[l]);	
	}
});
function viewComplianceDetails(stdId, curPageNum) {
    var editURL = "/web/brand-standards<%=themeDisplay.getLayout().getFriendlyURL()%>?requestType=ViewCompliance&stdId=" + stdId + "&pageNum=" + curPageNum + "&selectDate=" + '${filterBy}'+ "&searchById=" +'${findById}'+ "&dateInputFrom=" +'${fromDate}'+ "&dateInputTo=" +'${toDate}';
    window.location.href = editURL;
};

</script>