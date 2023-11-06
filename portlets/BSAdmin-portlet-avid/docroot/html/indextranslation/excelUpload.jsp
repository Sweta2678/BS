<%@include file="/html/indextranslation/init.jsp" %>

<style>
#errors {
	display:none;
	padding:10px;
	background-color:#9F9;
	border:2px solid #396;
	margin-bottom:20px;
	} 
</style>

<%  
String requestLocaleCd=(String)request.getAttribute(IndexTranslationUtil.SELECTED_LOCALE);
String importIdExl=(String)request.getAttribute(IndexTranslationUtil.IMPORT_ID_EXCEL);
%>
<portlet:resourceURL var="exelImportUrl"  id="excelExport" ></portlet:resourceURL>
	<liferay-ui:upload-progress
    id="<%=importIdExl%>"
    message="uploading"
    redirect="#"
   />


<aui:form id="exelImportForm" action="${exelImportUrl}" enctype="multipart/form-data" method="post" name="excelfm" >

     <aui:input name="localeCd" id="localeCd" type="hidden" value="<%= requestLocaleCd %>" />
	 <aui:input name="importProgressId" type="hidden" value="<%= importIdExl %>" />
	  <aui:field-wrapper>

		<%
		long imageMaxSize = 10240000 / 1024;
		%>

		<c:if test="<%= imageMaxSize != 0 %>">
			<div class="portlet-msg-info">
				<%= LanguageUtil.format(pageContext, "upload-images-no-larger-than-x-k", String.valueOf(imageMaxSize), false) %>
			</div>
		</c:if>
	</aui:field-wrapper>

	<aui:fieldset>
	<% 
    Map<String, String>localeMap = null;
	localeMap= IndexTranslationUtil.localeMap();
	
	if(requestLocaleCd.equalsIgnoreCase(IndexTranslationUtil.DEFAULT_LOCALE)){ 
	   localeMap.remove(IndexTranslationUtil.DEFAULT_LOCALE);
	%>
    <aui:select name="language"  id="locale_code" label="Select Language">
    	<%	for(String localeCd :localeMap.keySet())
			{	%>
				<aui:option value='<%=localeCd%>'><%=localeMap.get(localeCd)%></aui:option> 
		<%  }   %> 
			
    </aui:select>
    <% } else {%>
    <aui:select name="language"  label="Select Language" disabled="true">
		<%	for(String localeCd : localeMap.keySet())
			{	if(requestLocaleCd.equalsIgnoreCase(localeCd)){%>
				<aui:option value='<%=localeCd%>' selected="true"><%=localeMap.get(localeCd)%></aui:option>
				<%}else{%> 
				<aui:option value='<%=localeCd%>'><%=localeMap.get(localeCd)%></aui:option>
		<% } }   %> 
    </aui:select>
    
    <% } %>
	<aui:input name="file" type="file" label="Import File"/>
		
	</aui:fieldset>

	
</aui:form>
</div>

<div id='errors'></div>


<!-- Grid Start -->
<table id="indexExcelGrid"></table>
<div id="indexExcelPager"></div>
<table id="navgrid"></table>
<div id="pagernav"></div>
<!-- Grid End -->
<script>


 

</script>
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