<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.util.ImageAdminUtil"%>
<%@page import="com.ihg.brandstandards.util.BrandStandardsUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<portlet:defineObjects />
<script type="text/javascript" src="/BSTheme-theme/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery-ui-1.10.1.custom.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.msgBox.js"></script>
<script type="text/javascript">
    $(document).ready( function () {
		maxLength = $("textarea#description").attr("maxlength");
        $("textarea#description").after("<div style='display:none;'><span id='remainingLengthTempId'/></div>");
        $("textarea#description").bind("keyup change", function(){checkMaxLength(this.id,  maxLength); } )
 
    });
 
    function checkMaxLength(textareaID, maxLength){
        currentLengthInTextarea = $("#"+textareaID).val().length;
        $('#remainingLengthTempId').text(parseInt(maxLength) - parseInt(currentLengthInTextarea));
		if (currentLengthInTextarea > (maxLength)) { 
			$("textarea#description").val($("textarea#description").val().slice(0, maxLength));
 
		}
    }
</script>
<style>
	.portlet-msg-success {
		display : none;
	}
</style>
<portlet:actionURL var="saveFolderURL"  name="saveFolder"/>
<portlet:actionURL var="cancel" name="cancel"/>
<%
	String folderId = (String) request.getAttribute(ImageAdminUtil.FOLDER_ID);
	String cmd = (String)request.getAttribute(ImageAdminUtil.CMD);
	String currFolderId = (String) request.getAttribute(ImageAdminUtil.CURR_FOLDER);
%>
<liferay-ui:header title='<%= (cmd.equals(ImageAdminUtil.CMD_EDIT_FOLDER)) ? DLFolderLocalServiceUtil.getFolder(Long.valueOf(folderId)).getName() : "new-folder" %>' />

<aui:form action="<%= saveFolderURL %>" method="post" name="fm">
	<aui:input name="<%=ImageAdminUtil.FOLDER_ID%>" type="hidden" value="<%= folderId %>" />
	<aui:input name="<%=ImageAdminUtil.CURR_FOLDER%>" type="hidden" value="<%= currFolderId %>" />
	<aui:input name="<%=ImageAdminUtil.CMD%>" type="hidden" value="<%=cmd%>" />
	Name<br/>
	<input type="text" name="name" id="folderName" size="75" maxlength="75" style="width:50%;" value='<%=ImageAdminUtil.getValueOrBlank(request.getAttribute("name")) %>' />
	<br/><br/>
	Description<br/>
	<textarea id="description" name="description" maxlength="2000" class="input_text" style="width:80%;height:75px;"><%=ImageAdminUtil.getValueOrBlank(request.getAttribute("description")) %></textarea> 
	<aui:button-row>
		<aui:button type="submit" id="addUpdateImage" disabled="true"/>
		<aui:button onClick="<%= cancel %>" type="cancel" />
	</aui:button-row>
</aui:form>
<script type="text/javascript" src="/BSTheme-theme/js/folderAdmin.js"></script>