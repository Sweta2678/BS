<%@include file="/html/init.jsp"%>
<c:choose>
<c:when test="${seTemplateId > 0}">
	<portlet:resourceURL var="getStdRecords" id="getStdRecords">
	    <portlet:param name="requestType" value="getStdRecords" />
	</portlet:resourceURL>
	<portlet:resourceURL var="getFilterMessageURL" id="getFilterMessage">
	    <portlet:param name="requestType" value="getFilterMessage" />
	</portlet:resourceURL>
	<portlet:resourceURL var="saveGridURL" id="saveGrid">
	    <portlet:param name="requestType" value="saveGrid" />
	</portlet:resourceURL>
	<portlet:resourceURL var="updateMultiplierQtyURL" id="updateMultiplierQty" />
    <portlet:resourceURL var="calcScoreURL" id="calculateScore" />
    <portlet:resourceURL var="calcScorePercentURL" id="calculateScorePercent" />
    <portlet:resourceURL var="loadScoreURL" id="loadScore" />
	<portlet:resourceURL var="loadStdGrpCtryDetailURL" id="loadStdGrpCtryDetail" />
	<portlet:resourceURL var="exportStdRecsURL" id="exportStdRecords" />
	<portlet:resourceURL var="getBrandsForStdURL" id="getBrandsForStd" />
	<portlet:resourceURL var="updateMessurementPreferenceURL" id="updateMessurementPreference" />
	<style>
		<!--
		.gem-grid-panel {
		    border: none;
		}
		.gem-grid-frame {
		    width: 100%; 
		    height: 300px;  
		    border: none;
		    overflow: hidden;
		}
		-->
	</style>
	<script type="text/javascript">
		var getStdRecordsURL = '${getStdRecords}';
		var saveGridURL = '${saveGridURL}';
		var updateMultiplierQtyURL = '${updateMultiplierQtyURL}';
		var calcScoreURL = '${calcScoreURL}';
		var calcScorePercentURL = '${calcScorePercentURL}';
		var loadStdGrpCtryDetailURL = '${loadStdGrpCtryDetailURL}';
		var loadScoreURL = '${loadScoreURL}';
		var showMaximize = '${showMaximize}';
		var isGEMGlobalUser = '${isGEMGlobalUser}';
		var wrapperWidth = 0;
		var filterMessageURL = '${getFilterMessageURL}';
		var regionCode = '${regionCode}';
		var selManualFilterId = '${selManualFilterId}';
		var exportStdRecsURL = '${exportStdRecsURL}';	
		var getBrandsForStdURL = '${getBrandsForStdURL}';
		var updateMessurementPreferenceURL = '${updateMessurementPreferenceURL}';
		var flagChangedColumn = '${flagChangedColumn }';
		var isMaximize='${isMaximize }';
		$(function(){
			if(isMaximize=='false'){//if(isMaximize==true){//if(showMaximize == 'true'){
				wrapperWidth = $("#wrapper").width();
			} else {
				wrapperWidth = $("#wrapper").width()-20;
			}
			
		    var lastHeight = 0, curHeight = 0;
		    var lastWidth = 0, curWidth = 0;
		    var $frame = $('iframe:eq(0)'); 
		    setInterval(function(){
		        var iBody = $frame.contents().find('body');
		        var gridHeight = iBody.find("#editGrid").height();
		        var scoreHeight = iBody.find('#scoring').height();
		    
		        curHeight = gridHeight + scoreHeight + 40; 
		        if ( curHeight != lastHeight ) {
		            $frame.css('height', (lastHeight = curHeight) + 'px' );
		        }
 		        
		        curWidth = iBody.find(".datagrid").width();
		        if ( curWidth != lastWidth ) {
                    $frame.css('width', (lastWidth = curWidth) + 'px' );
                }
 		    
		    }, 500);
		});
	</script>
	<c:if test="${isMaximize }">
		 <link type='text/css' href='<%=request.getContextPath()%>/css/qlForm-maximized.css' rel='stylesheet' /> 
		<%--<style>
			.aui #wrapper, .aui .container{width: 95% !important;}
			.aui .utilityRow {width: 98% !important;}
			.aui #navigation, .aui .row-fluid .span12 {width: 100% !important;}
		</style> --%>
	</c:if>
	<div id="std-gem-editable" class="gem-grid-panel">
	     <iframe src="/BSBridge-portlet/gem/ql-edit-grid?publishId=${publishId}&bridgePublishId=${bridgePublishId}&gemDepartmentId=${gemDepartmentId}&seTemplateId=${seTemplateId}&saTemplateId=${saTemplateId}&regionId=${regionId}&showMaximize=${isMaximize}" class="gem-grid-frame" id="gem-grid-frame"></iframe>
	</div>
</c:when>
<c:when test="${not activeGemPublish}">
	Please create new measurement publication.
</c:when>
<c:otherwise>
	Please upload SE Template for this region!
</c:otherwise>
</c:choose>