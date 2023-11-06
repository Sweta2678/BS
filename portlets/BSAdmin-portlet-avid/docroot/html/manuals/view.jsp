<%@ include file="/html/standlist/init.jsp" %>
<%@page import="com.ihg.brandstandards.util.ManualsUtil"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>

<script type="text/javascript" src="/BSTheme-theme/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery-ui-1.10.1.custom.min.js"></script>
<link href="/BSTheme-theme/css/other/jquery-ui-1.10.1/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.msgBox.js"></script>
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/msgBoxLight.css"/>
<%@include file="/html/common/initmenu.jsp" %>

<script>
function refreshPortlet() {
    var namespacedId = "p_p_id<portlet:namespace/>";
    var jPortlet = jQuery('#' + namespacedId);
    var portlet = jPortlet[0];
    Liferay.Portlet.refresh(portlet);
}
function setTimer(manualId) {
	window.setTimeout("showAlert("+manualId+")",1500);
	return false;
}
function showAlert(manualId) {
	 $.msgBox({
 	    title:"Record deleted",
 	    content:"Manual has been removed with id  "+manualId+".",
 	    type:"info",
 	 }); 
}
function deleteManual(manualId)
{	   
	$.msgBox({
	    title: "Are You Sure",
	    content: "Would you like to delete manual with id  "+manualId+"?",
	    type: "confirm",
	    buttons: [{ value: "Yes" }, { value: "No" }, { value: "Cancel"}],
	    success: function (result) {
	        if (result == "Yes") {
	        	var url = '<portlet:resourceURL id="deleteManual"></portlet:resourceURL>';
	        	jQuery.post(url, {manualId:manualId}, function(data){
	        		var message = JSON.parse(data);
	        	      if(message.response=="Failure")
	        			{
	        	    	  $("#response").html(message.response+": "+message.message);
	        	            $("#response").slideDown('slow');
	        	            setTimeout(function () {
	        	                $("#response").slideUp("slow", function () {});
	        	            },
	        	            2000); 
	        	    	  $("#loading").fadeOut('slow');
	        			}
	        			else 
	        			{
	        				setTimer(manualId);
	        				refreshPortlet();
	        		    }   
	            }); 
	        
	        }
	        if(result == "No" || result == "Cancel")
	        {
	          return false;
	        }
	    }
	 }); 
}

function accessNot(manualId,action)
{	
	$.msgBox({
	    title:"Can not perform "+action+" action",
	    content:"standards, specifications or guidelines referencing this manual"
	});
	return;
}
</script>
<!--ends opening scripts -->

<%
	long userId = PortalUtil.getUserId(renderRequest);
	if (userId > 1)  {
		String redirect = ParamUtil.getString(request, "redirect");
		String keywords = ParamUtil.getString(request, "keywords");
%>
<div id="response"></div>
<liferay-portlet:renderURL varImpl="searchURL" />
<aui:form action="<%= searchURL %>" method="post" name="filterForm" onSubmit="selectAllToSubmit()" cssClass="hist_grid">
    <%
	    PortletURL itUrl = renderResponse.createRenderURL();
	    SearchContainer listContainer = (SearchContainer)request.getAttribute("searchContainer");
		User userObj = themeDisplay.getUser(); 
		long companyId = themeDisplay.getCompanyId();
		long currentUserId = themeDisplay.getUser().getUserId();
		List<Role> arlCurrentUserRoles = RoleLocalServiceUtil.getUserRoles(currentUserId);
    %>
<div class="grid_9">
	<div class="rounded_container">
        <div class="rounded_container_contents">
            <h4 class="short_page_subtitle">Manuals</h4>
            <div class="results_right_util result_utils">
            <%	if(ManualsUtil.hasCreateRights(user)) { %> 
                   <a class="add_new_standard" href="/web/brand-standards/manuals_wizard"><img class="add_icon" src="/BSTheme-theme/images/plus_icon.png" alt="Upload Manual" title="Upload Manual" /> Upload Manual</a>
             <%	} %>
            </div>
        	<div class="clear"></div>
           	<div class="divider">&nbsp;</div>
            <div class="clear"></div>
    	<table class="results_table">
           	<tr class="results_header_bar">
            	<td class="result_table_cell1"><strong>ID</strong></td>
                <td class="man_table_cell2"><strong>Title</strong></td>
                <td class="result_table_cell4"><strong>Author</strong></td>
                <td class="result_table_cell5">&nbsp;</td>
          	</tr>
		<liferay-ui:search-container hover="false"  searchContainer="<%=listContainer%>" >
		    <liferay-ui:search-container-results>
		     <%
				  pageContext.setAttribute("results",searchContainer.getResults());
				  pageContext.setAttribute("total", searchContainer.getTotal() );
		     %>
		    </liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="com.ihg.brandstandards.db.model.HistManuals" keyProperty="histManualId" modelVar="manual">
                <% 
					String cuserId = manual.getCreatorId();
					List<Role> arlRoles = RoleLocalServiceUtil.getUserRoles(Long.parseLong(cuserId));
					boolean isRole = false;
					for(Role roles:arlRoles)
					{
						for(Role curUserRole: arlCurrentUserRoles)
						{
							if(roles.getName().equals(curUserRole.getName()))
							{
								isRole = true;
							}
						}
					}
					User author = null;
					String authorName = "";
			    	try {
	                	author = UserLocalServiceUtil.getUserById(Long.parseLong(manual.getCreatorId()));
			    	} catch(Exception e){
			    	    
			    	}
			    	if(author != null){
	                	authorName = author.getFirstName()+" "+author.getLastName();
			    	}
	            %>
                <tr>
                	<td class="parent_id"><%=manual.getHistManualId()%></td>
                    <td><%=manual.getTitle()%></td>
                    <td><%=authorName%></td>
					<td> 
					<%if(ManualsUtil.hasEditDeleteRigths(userObj, manual) ||  request.isUserInRole("Administrator")) {
					    if(ManualsUtil.isEditable(manual))
					    {
						%>
								<a alt="Delete" title="Delete" class="delete_manual" href="#"><img src="/BSTheme-theme/images/delete.png" alt="Delete" title="Delete"  onclick="deleteManual(<%=manual.getHistManualId()%>);"/></a>
						<% }else{%>
							    <a alt="Delete" title="Delete" class="delete_manual" href="#"><img src="/BSTheme-theme/images/delete.png" alt="Delete" title="Delete"  onclick="accessNot(<%=manual.getHistManualId()%>,'delete');"/></a>
							
				<% 		} 
					}  			%> 
						
						<a title="Edit Tooltip" href="/web/brand-standards/manuals_wizard?id=<%=manual.getHistManualId() %>">
							<img class="edit_icon" alt="Edit" title="Edit" src="/BSTheme-theme/images/edit_pencil_icon.png" />
						</a>
					</td>
                </tr>

                </liferay-ui:search-container-row>
			    <liferay-ui:search-iterator />
			    </liferay-ui:search-container>
		</table>
   <div class="rounded_container_bottom">&nbsp;</div>
   </div>
 </div><!--ends rounded_container -->
</div><!--ends grid_9 -->
<div class="clear"></div>
</aui:form>
<% 
	} else {
%>
	Not logged in !!
<%
	}
%>
