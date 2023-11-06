<%@include file="/html/init.jsp"%>
<portlet:renderURL var="cancel" />
<!-- CSS Imports -->
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/other/jquery-ui-1.10.1/themes/base/jquery-ui.css" />
<link type="text/css" rel="stylesheet" href="/BSBridge-theme/css/msgBoxLight.css" />
<link rel="stylesheet" type="text/css" media="screen" href="/BSTheme-theme/css/jqgrid/themes/ui.jqgrid.css" />
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/other/jquery-ui-1.10.1/themes/base/jquery.ui.all.css" />

<!-- JS Imports -->
<script src="/BSTheme-theme/js/jqGrid/jquery.js" type="text/javascript"></script>
<script src="/BSTheme-theme/js/jqGrid/jquery-ui-custom.min.js" type="text/javascript"></script>
<script src="/BSTheme-theme/js/jqGrid/jquery.jqGrid.js" type="text/javascript"></script>
<script src="/BSTheme-theme/js/jqGrid/i18n/grid.locale-en.js" type="text/javascript"></script>
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.msgBox.js"></script>

<!-- Keep this css here because we are overriding only for this JSP. -->
<style>
	#errors {
		display:none;
		padding:10px;
		background-color:#9F9;
		border:2px solid #396;
		margin-bottom:20px;
	} 
</style>

<aui:form action="${auiImportElement}" enctype="multipart/form-data" method="post" name="excelfm" >
 	 <aui:fieldset>
		
		<aui:input name="file" type="file" label="<em class=\"required\">* </em>Import File"></aui:input>
		
		<aui:select name="importType"  id="importType" label="<em class=\"required\">* </em>Import Type">
			<option value="Catgy">Categories</option>
			<option value="StdCatgyMapping">Standard to Category Mapping</option>
   		</aui:select>		
	 </aui:fieldset>
</aui:form>
<div id='errors'></div>

<!-- Grid Start -->
<table id="indexExcelGrid"></table>
<div id="indexExcelPager"></div>
<table id="navgrid"></table>
<div id="pagernav"></div>
<!-- Grid End -->

<aui:script use="aui-base">
	var validateFile = function(fileField) {
		var value = fileField.val();
		if (value) {
			var extension = value.substring(value.lastIndexOf('.')).toLowerCase();
			var validExtensions = ['.xls','.xlsm'];
			if ((A.Array.indexOf(validExtensions, '*') == -1) &&
				(A.Array.indexOf(validExtensions, extension) == -1)) {
					alert('Only files with following extensions are allowed: xls, xlsm');
					fileField.val('');
			}
		}
	};

	var onFileChange = function(event) {
		validateFile(event.currentTarget);
	};

	var fileField = A.one('#<portlet:namespace />file')

	if (fileField) {
		fileField.on('change', onFileChange);
		validateFile(fileField);
	}
</aui:script>