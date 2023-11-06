<%@include file="/html/indextranslation/init.jsp" %>
<%@ page import="com.liferay.util.PwdGenerator"%>

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
String taxId  = (String)request.getAttribute("TAXONOMY_ID");
String requestLocaleCd=(String)request.getAttribute(IndexTranslationUtil.SELECTED_LOCALE);
String imageUrl="";
if(request.getAttribute("transImageUrl")!=null)
{
	imageUrl=(String)request.getAttribute("transImageUrl");
}

String importIdImg=(String)request.getAttribute(IndexTranslationUtil.IMPORT_ID_IMAGE);
%>

<portlet:resourceURL var="uploadTranslationImageUrl" id="uploadTranslationImage"></portlet:resourceURL>
	<liferay-ui:upload-progress
    id="<%=importIdImg%>"
    message="uploading"
    redirect="#"
   />

<aui:form id="fmImageUpload" action="${uploadTranslationImageUrl}" enctype="multipart/form-data" method="post"  name="fmImageUpload" >
    <aui:input name="taxId" type="hidden" value="<%= taxId %>" />
	<aui:input name="localeCd" type="hidden" value="<%= requestLocaleCd %>" />
	<aui:input name="importProgressId" type="hidden" value="<%= importIdImg %>" />
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
    <aui:select name="language"  label="Select Language">
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
	<aui:input name="file" type="file" label="Import Image"/>
	</aui:fieldset>

</aui:form>
</div>
<div id='errors'></div>
<div>
<% 
if(!imageUrl.equals("")){%>
<img class="hidden_icon" id="indexTranslationImage" href="#" src="<%=imageUrl %>" alt="Taxonomy Image" title="Taxonomy Image" style="float:left; height:100px; width:100px;"/>
<%}else{ %>
<img class="hidden_icon" id="indexTranslationImage" href="#" src="/BSTheme-theme/images/placeholder_icon.jpg" alt="Taxonomy Image" title="Taxonomy Image" style="float:left; height:100px; width:100px;"/>
<%} %>
</div>



<aui:script use="aui-base">
	    var validateFile = function(fileField) {
		var value = fileField.val();

		if (value) {
			var extension = value.substring(value.lastIndexOf('.')).toLowerCase();
			var validExtensions = ['.bmp','.gif','.jpeg','.jpg','.png','.tif','.tiff'];

			if ((A.Array.indexOf(validExtensions, '*') == -1) &&
				(A.Array.indexOf(validExtensions, extension) == -1)) {

				alert('Only files with following extensions are allowed: bmp, gif, jpeg, jpg, png, tif, tiff');

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






