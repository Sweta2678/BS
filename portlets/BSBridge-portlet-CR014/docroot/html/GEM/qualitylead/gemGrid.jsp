<%@page import="com.ihg.brandstandards.db.model.GEMMeasurement"%>
<%@page import="com.ihg.brandstandards.db.model.GEMSeverity"%>
<%@page import="com.ihg.brandstandards.db.model.GEMManagementBucket"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Map"%>
<html>
<body style="padding: 0px !important;">

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" type="text/css" href="/BSBridge-theme/css/easyui/themes/gray/easyui.css" />
<link rel="stylesheet" type="text/css" href="/BSBridge-theme/css/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="/BSBridge-theme/css/qlForm.css" />

<script type="text/javascript" src="/BSBridge-theme/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="/BSBridge-theme/js/jquery.easyui.min.js"></script>
<style>
	.editrgnlStd input[type="checkbox"]
	{
    display:none;
	}
	.editrgnlSpecGdln input[type="checkbox"]{
	 display:none;
	}
		-->
	</style>
<%
	Map<String, String> bktSeverityCatgyCnts = new LinkedHashMap<String, String>();
	Map<String, String> gemBktSeverityCatgyTotalCounts = new LinkedHashMap<String, String>();
	Map<String, String> qtyHeaderValues = new LinkedHashMap<String, String>();

	if(request.getAttribute("bktSeverityCatgyCnts") != null){
		bktSeverityCatgyCnts = (Map<String, String>)request.getAttribute("bktSeverityCatgyCnts");
	}
	if(request.getAttribute("gemBktSeverityCatgyTotalCounts") != null){
		gemBktSeverityCatgyTotalCounts = (Map<String, String>)request.getAttribute("gemBktSeverityCatgyTotalCounts");
	}
	if(request.getAttribute("qtyHeaderValues") != null){
		qtyHeaderValues = (Map<String, String>)request.getAttribute("qtyHeaderValues");
	}

%>

<!-- Scoring Grid -->
<div class="easyui-accordion" id="scoring" style="width:100%">
  <div id="score-title" title="${defaultScoringHeader}" class="accordion-inner" >
      <div id="scoring-table" style="display:none;">
        <table class="scoring-tbl" >
            <tr>
                <td colspan="2" class="measur-header">Regional On-Site Measurement Summary</td>
                <c:forEach var="catgy" items="${severityCatgy}">
                    <td rowspan="${rowspanSize}" ><span id="${catgy.measurementId}" class="vertical">${catgy.measurementName}</span></td>
                </c:forEach>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            
            <c:forEach var="catgy" items="${measurCatgy}">
                <tr>
                    <td class="measur-catgy"># of 
                    <c:choose>
                        <c:when test="${fn:endsWith(catgy.measurementName, 's') || fn:endsWith(catgy.measurementName, 'ts')}">
                            ${catgy.measurementName}
                        </c:when>
                        <c:otherwise>
                            ${catgy.measurementName}s
                        </c:otherwise>
                    </c:choose>
                     measured:</td>
                    <td class="measur-num">
                    	<input type="text" id="mgtQty_${catgy.measurementId}" style="width:45px" oldValue="${catgy.multiplierQty}"
                    		value="${catgy.multiplierQty}" onchange="updateMeasurementQty('${catgy.measurementId}')">
                    </td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </c:forEach>
            
            <c:forEach var="bucket" items="${manageBucket}">
            	<% GEMManagementBucket bucket = (GEMManagementBucket)pageContext.getAttribute("bucket"); %>
                <tr class="measur-bkt">
                    <td colspan="2" class="measur-bkt-hdr">${bucket.bucketName}</td>
                    <td colspan="${severitySpanSize}" class="measur-bkt-qu-hdr">QUESTION BREAKDOWN</td>
                    <td class="measur-bkt-total-hdr">Total Q's</td>
                    <td class="measur-bkt-total-hdr">Net Q's</td>
                    <td class="measur-bkt-non-cmpl-e">Non Compl</td>
                    <td class="measur-bkt-non-cmpl-e-pct">
                    	<span id="${bucket.bucketId}_scorePctQty">100%</span>
                    </td>
                </tr>
                <c:forEach var="severity" items="${severityLst}">
                  <c:if test="${severity.severityId gt 0 }">
                  	<% GEMSeverity severity = (GEMSeverity)pageContext.getAttribute("severity"); %>
                    <tr>
                        <td colspan="2" class="measur-bkt-item">${severity.severityName}</td>
                        <c:forEach var="catgy" items="${severityCatgy}">
                            <td class="measur-bkt-item-cnt">
                            	<span id="${bucket.bucketId}_${severity.severityId}_${catgy.measurementId}">
                            		<%
	                            		GEMMeasurement measurement = (GEMMeasurement)pageContext.getAttribute("catgy");
	                            		String bktSeverityVal = "0";
	                            		if(bktSeverityCatgyCnts.get(bucket.getBucketId()+"_"+severity.getSeverityId()+"_"+measurement.getMeasurementId()) != null){
	                            			bktSeverityVal = bktSeverityCatgyCnts.get(bucket.getBucketId()+"_"+severity.getSeverityId()+"_"+measurement.getMeasurementId());
	                            		}
	                            	%>
	                            	<%=bktSeverityVal %>
                            	</span>
                            	
                            </td>
                        </c:forEach>

                        <td class="measur-bkt-total">
                        	<span id="${bucket.bucketId}_${severity.severityId}_totalQty">
                        	<%
                           		String bktSeverityTotalQty = "0";
                           		if(gemBktSeverityCatgyTotalCounts.get(bucket.getBucketId()+"_"+severity.getSeverityId()+"_totalQty") != null){
                           			bktSeverityTotalQty = gemBktSeverityCatgyTotalCounts.get(bucket.getBucketId()+"_"+severity.getSeverityId()+"_totalQty");
                           		}
                           	%>
                           	<%=bktSeverityTotalQty%>
                        	</span>
                        </td>
                        <td class="measur-bkt-total">
                        	<span id="${bucket.bucketId}_${severity.severityId}_netQty">
                        	<%
                           		String bktSeverityNetQty = "0";
                           		if(gemBktSeverityCatgyTotalCounts.get(bucket.getBucketId()+"_"+severity.getSeverityId()+"_netQty") != null){
                           			bktSeverityNetQty = gemBktSeverityCatgyTotalCounts.get(bucket.getBucketId()+"_"+severity.getSeverityId()+"_netQty");
                           		}
                           	%>
                           	<%=bktSeverityNetQty%>
                        	</span>
                        </td>
                        <td class="measur-bkt-non-cmpl-e">
                        	<span id="${bucket.bucketId}_${severity.severityId}_nonComplQty">
                        	<%
                           		String bktSeverityNonComplQty = "0";
                           		if(gemBktSeverityCatgyTotalCounts.get(bucket.getBucketId()+"_"+severity.getSeverityId()+"_nonComplQty") != null){
                           			bktSeverityNonComplQty = gemBktSeverityCatgyTotalCounts.get(bucket.getBucketId()+"_"+severity.getSeverityId()+"_nonComplQty");
                           		}
                           	%>
                           	<%=bktSeverityNonComplQty%>
                        	</span>
                        </td>
                        <td class="measur-bkt-non-cmpl-e-pct">
                          <c:if test="${fn:containsIgnoreCase(bucket.bucketName, 'IHG Way') == false}">
                        	<span id="noncmpl_pct_${bucket.bucketId}_${severity.severityId}">
                        		<input type="text" id="input_nonCmplQty_${bucket.bucketId}_<%=severity.getSeverityName().replaceAll(" ", "")%>" 
                        			severityId="${severity.severityId}" style="width:45px" value="0" onchange="calculateScorePercent('${bucket.bucketId}')">
                        	</span>
                          </c:if>
                        </td>
                    </tr>
                  </c:if>
                </c:forEach>
            </c:forEach>
        </table>
      </div>
  </div>
</div>

<!-- Main Standard Grid -->
<div id="editGrid">
    <div style="margin:10px 0;"></div>
	<div class="well well-small" style="margin-bottom:0px; padding:5px;">
		<div class="row">
			<div id="filterSelection" class="filter-info-bar"></div>
		</div>
	</div>
    <table id="dg"></table>
</div>

<!-- Standard Unique Groups and Countries detail model window -->
<div style="display:none;">
    <div id="ctrydlg" style="padding:5px 10px;">
        <div id="stdGrpCtryDtl"></div>
	</div>
</div>

<!-- Edit Model Popup -->
<div style="display:none;">
    <div id="dlg" style="padding:10px 20px;">
        <div id="ftitle" class="ftitle"></div>
        <div class="clear"></div>
        <form id="fm" method="post" novalidate>
            <input id="ql_id" hidden="true">
            <input id="ql_std_id" hidden="true">
            <input id="ql_prnt_std_id" hidden="true">
            <input id="ql_std_type" hidden="true">
            <input id="ql_cur_index" hidden="true">
            <input id="ql_publish_id" hidden="true">
            <div class="fitem glbl_must_div">
                <label for="ql_glblMust" style="width:150px;float:left;">Global Must:</label>
                <input id="ql_glblMust" name="ql_glblMust" type="checkbox">
            </div>
            <div class="fitem">
                <label for="catgyHeadNm" style="width:150px;float:left;">Category Heading:</label>
                <input id="catgyHeadNm" name="catgyHead" class="easyui-combobox" style="width:250px;" 
                data-options='
                valueField: "catgyHead",
                textField: "catgyHeadNm",
                data: ${categoryHeading}'>
            </div>
            <div class="fitem">
                <label for="seRptCatgyNm" style="width:150px;float:left;">SE Reporting Category:</label>
                <input id="seRptCatgyNm" name="seRptCatgy" class="easyui-combobox" style="width:250px;" 
                data-options='
                valueField: "seRptCatgy",
                textField: "seRptCatgyNm",
                data: ${reportingCategory}'>
            </div>
            <div class="fitem">
                <label for="critNm" style="width:150px;float:left;">Q Criticality:</label>
                <input id="critNm" name="crit" class="easyui-combobox" style="width:250px;" 
                data-options='
                valueField: "crit",
                textField: "critNm",
                data: ${criticality}'>
            </div>
            <div class="fitem">
                <label for="seSeqNo" style="width:150px;float:left;">SE Sequence No:</label>
                <input id="seSeqNo" name="seSeqNo" class="easyui-numberbox" 
                	data-options="
                	    min:0,
               			precision:3,
               			formatter:function(value){
               			    if (!value || value == 0)
               			    {
               			        return '0';
               			    }
							return parseFloat(value);
						},
               			onChange:function(newVal, oldVal){
							if(oldVal && oldVal != newVal){
                			   reSequence = true;
                			   <!-- alert('reSequence-->'+reSequence+'--oldVal->'+oldVal+'--newVal->'+newVal); -->
                		   }
						}">
            </div>
            <div class="fitem">
                <label for="complDueNm" style="width:150px;float:left;">Due Date:</label>
                <input id="complDueNm" name="complDue" class="easyui-combobox" style="width:250px;" 
                data-options='
                valueField: "complDue",
                textField: "complDueNm",
                data: ${complDue}'>
            </div>
            <div class="fitem">
                <label for="questionNm" style="width:150px;float:left;">Trigger Question:</label>
                <input id="questionNm" name="question" class="easyui-combobox" style="width:320px;" 
                data-options='
                valueField: "question",
                textField: "questionNm",
                data: ${questions}'>
            </div>
        </form>
    </div>
</div>

<!--  Filter / Search  toolbar  -->
<div id="tb" style="padding:2px 5px;">
    <div style="display:none">
	    STD ID: <input id="std-id" class="easyui-textbox" style="width:100px"> &nbsp;
	    Category Heading: 
	    <input id="catgyHeadFlt" name="catgyHeadFlt" class="easyui-combobox" style="width:100px;" 
	        data-options='
	        valueField: "catgyHead",
	        textField: "catgyHeadNm",
	        data: ${categoryHeading}'> &nbsp;
	    Owner: 
	    <input id="std-owner" class="easyui-combobox" style="width:100px;" 
	        data-options='
	        valueField: "stdBusOwner",
	        textField: "stdBusOwnerNm",
	        data: ${stdBusOwner}'> &nbsp;
	    Status:
	    <select id="std-rec-status" class="easyui-combobox" panelHeight="auto" style="width:74px">
	        <option value="">All</option>
	        <option value="MEASURED">Measured</option>
	        <option value="NOT_MEASURED">Not Measured</option>
	        <option value="GLBL_MUST_MEASURE">Global Must</option>
	    </select> &nbsp;
	    Region:
	    <select id="std-region" class="easyui-combobox" panelHeight="auto" style="width:64px">
	        <option value="">All</option>
	        <option value="GLBL">Global</option>
	        <option value="AMEA">AMEA</option>
	        <option value="AMER">AMER</option>
	        <option value="EURO">EUROPE</option>
	        <option value="GC">GC</option>
	    </select> &nbsp;
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="searchRec()">Search</a> &nbsp;
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="cancelFilter()" title="Clear Search Filter">Clear</a>
    </div>
    <div class="row">
    	<div class="pull-left span6 gem-btn">
    		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="searchRec()">Search</a> &nbsp;
		    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="cancelFilter()" title="Clear Search Filter">Clear</a>
    	</div>
	    <div class="pull-right span6 gem-btn">
		    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="saveChanges()">Save</a>&nbsp;&nbsp;
		    <a href="javascript:void(0)" class="easyui-linkbutton" onClick="exportStdRecords()">Export</a>&nbsp;&nbsp;
		    <a href="javascript:void(0)" class="easyui-linkbutton" id="toggleDisplayOptions" style="width:150px">Hide Display Options</a>&nbsp;&nbsp;
		    <c:choose>
			    <c:when test="${showMaximize}">
		        	<a href="javascript:void(0)" onclick="resizeScreen('/web/brand-standards/gem/ql-scoring-maximize')" class="easyui-linkbutton" data-options="iconCls:'icon-fullscreen'" title="Maximize"></a>
		        </c:when>
		        <c:otherwise>	
		        	<a href="javascript:void(0)" onclick="resizeScreen('/web/brand-standards/gem/ql-scoring')" class="easyui-linkbutton" data-options="iconCls:'icon-smallscreen'" title="Minimize"></a>
		        </c:otherwise>
	        </c:choose>
		</div>
    </div>
	<div style="clear:both"></div>
	<hr>
	<div class="show" id="columnSelectionDiv">
		<table style="width:100%; border:1px solid #e5e5e5 !important;">
		   	<tbody>		   	
		   	<tr style="background:#0092dc none repeat scroll 0 0">
		   		<th colspan="5" style="text-align:left;color:#fff; font-weight:bold">Display Column Options</th>
		   	</tr>
		   	<tr>
				<td width="20%"><input id="show-mnlType" type="checkbox" onclick="togleColumn('show-mnlType', 'mnlType')"> Manual Type</td>
				<td width="20%"><input id="show-path" type="checkbox" onclick="togleColumn('show-path', 'path')"> Path</td>
				<td width="20%"><input id="show-stat" type="checkbox" checked onclick="togleColumn('show-stat', 'stdStatus')"> Status</td>
				<td width="20%"><input id="show-type" type="checkbox" checked onclick="togleColumn('show-type', 'stdType')"> Type</td>
				<td width="20%"><input id="show-text" type="checkbox" checked onclick="togleColumn('show-text', 'title')"> Text</td>
			</tr>
			<tr>
				<td><input id="show-catgy" type="checkbox" checked onclick="togleColumn('show-catgy', 'catgy')"> Category</td>
				<td><input id="show-owner" type="checkbox" onclick="togleColumn('show-owner', 'stdOwner')"> Standard Owner</td>
				<td><input id="show-cmplydt" type="checkbox" checked onclick="togleColumn('show-cmplydt', 'cmply')"> Compliance Date</td>
				<td><input id="show-cpytobrnd" type="checkbox" checked onclick="togleColumn('show-cpytobrnd', 'copyToBrand')"> Copy To Brand</td>
				<td><input id="show-catgyhead" type="checkbox" checked onclick="togleColumn('show-catgyhead', 'catgyHead')"> Category Heading</td>				
			</tr>
			<tr>
				<td><input id="show-secatgy" type="checkbox" checked onclick="togleColumn('show-secatgy', 'seRptCatgy')"> SE Reporting Category</td>
				<td><input id="show-crit" type="checkbox" checked onclick="togleColumn('show-crit', 'crit')"> Q Criticality</td>
				<td><input id="show-seq" type="checkbox" checked onclick="togleColumn('show-seq', 'seSeqNo')"> SE Sequence No</td> 
				<td><input id="show-question" type="checkbox" checked onclick="togleColumn('show-question', 'question')"> Trigger Question</td>
				<td><input id="show-duedt" type="checkbox" checked onclick="togleColumn('show-duedt', 'complDue')"> Due Date</td>
			</tr>
			</tbody>
		</table> 
		<hr>
	</div>
	<div style="padding: 2px;"></div>
</div>
<!-- END OF Filter toolbar  -->

<div id="exportStdRecordsFormDiv" style="display:none">
	<form method="POST" name="exportStdRecordsForm" id="exportStdRecordsForm">
		<input type="hidden" name="columnsToExport" id="columnsToExport" />
	</form>
</div>

<script type="text/javascript">
	var gridWidht = parent.wrapperWidth;
	var getStdRecordsURL = parent.getStdRecordsURL;
	var saveGridURL = parent.saveGridURL;
	var updateMultiplierQtyURL = parent.updateMultiplierQtyURL;
	var calcScoreURL = parent.calcScoreURL;
	var calcScorePercentURL = parent.calcScorePercentURL;
	var loadStdGrpCtryDetailURL = parent.loadStdGrpCtryDetailURL;
	var isGEMGlobalUser = parent.isGEMGlobalUser == "true" ? true : false;
	var filterMessageURL = parent.filterMessageURL;
	var regionCode = parent.regionCode;
	var selManualFilterId = parent.selManualFilterId;
	var reportingCategory = ${reportingCategory};
	var criticality = ${criticality};
	var categoryHeading = ${categoryHeading};
	var stdBusOwner = ${stdBusOwner};
	var manualTypes = ${manualTypes};
	var indexpathJsonData = ${indexpathJsonData};
	var questions = ${questions};
	var complDue = ${complDue};
	var reSequence = false;
	var editIndex = undefined;
	var lastWidth = gridWidht; 
	var updatedRows = [];
	var scoringHeader = '${scoringHeader}';
	var ihgWayCrit = '${ihgWayCrit}';
	var ighWayAutoFail = '${ighWayAutoFail}';
	var prdtImp = '${prdtImp}';
	var prdtCrit = '${prdtCrit}';
	var prdtAutoFail = '${prdtAutoFail}';
	var srvsImp = '${srvsImp}';
	var srvsCrit = '${srvsCrit}';
	var srvsAutoFail = '${srvsAutoFail}';
	var exportStdRecsURL = parent.exportStdRecsURL;	
	var getBrandsForStdURL = parent.getBrandsForStdURL;
</script>
<script type="text/javascript" src="/BSBridge-portlet/js/qlForm.js"></script>
<script type="text/javascript" src="/BSBridge-portlet/js/datagrid-filter.js"></script>
</body>
</html>