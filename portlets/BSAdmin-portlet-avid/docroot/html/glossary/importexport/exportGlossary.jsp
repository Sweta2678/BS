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

<%  String importIdExl=(String)request.getAttribute(GlossaryUtil.PARAM_EXPORT_ID_EXCEL); %>
<portlet:resourceURL var="exportExcelUrl1" id="excelExport" />
<liferay-ui:upload-progress id="<%=importIdExl%>" message="Downloading" redirect="#" />
<div>
	<aui:form action="$[exportExcelUrl1}" method="post" name="excelfm" >
	     <aui:input name="localeCd" id="localeCd" type="hidden" value="" />
		 <aui:input name="importProgressId" type="hidden" value="<%= importIdExl %>" />
		 <aui:fieldset>
			    <aui:select name="language"  id="locale_code" label="Select Language">
					<c:forEach items="${localeList}" var="stdLocale">
					    <aui:option value='${stdLocale.localeCode }'>${stdLocale.localeName }</aui:option> 
					</c:forEach>
	    		</aui:select>
		</aui:fieldset>
	</aui:form>
</div>
 
<aui:script use="aui-base">
     var nodeObject = A.one('#<portlet:namespace />locale_code');
     A.one('#<portlet:namespace />localeCd').set('value',nodeObject.get('value'));
     if(nodeObject)
     {
        nodeObject.on('change', function(event){
        A.one('#<portlet:namespace />localeCd').set('value',nodeObject.get('value'));
       });
     }
</aui:script>