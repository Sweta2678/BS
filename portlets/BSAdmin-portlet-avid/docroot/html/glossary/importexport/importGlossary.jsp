<%@include file="/html/glossary/init.jsp" %>
<style>
	#errors {
		display:none;
		padding:10px;
		background-color:#9F9;
		border:2px solid #396;
		margin-bottom:20px;
	} 
</style>

<% String importIdExl=(String)request.getAttribute(GlossaryUtil.PARAM_IMPORT_ID_EXCEL); %>
<portlet:resourceURL var="uploadExcelUrl1" id="uploadValidateExcel"/>
<liferay-ui:upload-progress id="<%=importIdExl%>" message="uploading"  redirect="#" />

<aui:form action="${uploadExcelUrl1}" enctype="multipart/form-data" method="post" name="excelfm" >
     <aui:input name="localeCd" id="localeCd" type="hidden" value="" />
	 <aui:input name="importProgressId" type="hidden" value="<%= importIdExl %>" />
 	 <aui:fieldset>
	    <aui:select name="language"  id="locale_code" label="Select Language">
			<c:forEach items="${localeList}" var="stdLocale">
			    <aui:option value='${stdLocale.localeCode }'>${stdLocale.localeName }</aui:option> 
			</c:forEach>
   		</aui:select>
		<aui:input name="file" type="file" label="Import File"/>
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

     var nodeObject = A.one('#<portlet:namespace />locale_code');
     A.one('#<portlet:namespace />localeCd').set('value',nodeObject.get('value'));
     if(nodeObject)
     {
        nodeObject.on('change', function(event){
        A.one('#<portlet:namespace />localeCd').set('value',nodeObject.get('value'));
       });
     }
</aui:script>