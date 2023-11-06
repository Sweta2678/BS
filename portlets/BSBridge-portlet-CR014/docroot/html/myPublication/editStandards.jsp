<%@page import="com.ihg.brandstandards.custom.model.Standard"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@page import="com.liferay.portal.kernel.util.StringPool" %>
<%@page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@page import="com.liferay.portal.kernel.util.Validator" %>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="java.util.ArrayList"%>
<%@include file="/html/init.jsp"%>
<%
Standard std = (Standard)request.getAttribute("StandardsObj") ;
long stdId = std.getParentStdId();
%>
<portlet:actionURL name="editedStandards" var="editedURL"/>
<script type="text/javascript">
	function modifyStandards() {
		var standardId = <%=stdId%>
		var nodeObject = document.getElementById('<portlet:namespace/>editStdId');
		var prntStdId = document.getElementById('<portlet:namespace/>prntStdId');
		var allVals = [];
		jQuery('input[name=selStdId]:checked').each(function() {
		   allVals.push($(this).val());
		 });
		prntStdId.value = standardId; 
	    nodeObject.value = allVals;
	    jQuery( "#<portlet:namespace/>editStandard" ).submit();
	}
	
	$(".searchoptioncancel").click(function() {
		$("#editStandard").dialog( "close" );
	});
	function parentCheckUnCheck(){
		var isCheck = $("#parent:enabled:checked").length > 0;
		if(!isCheck){
			/*$("#parent"+stdid).attr("checked","checked");*/
			document.getElementById("parent").checked = true;
		}
	}

	function childCheckUnCheck(stdId){
		var childItems = $("input[id=child]:enabled:checked");
		$(childItems).each(function(){
			$(this).attr("checked",false);
		});
	}
</script>
   <form id="editStandard" name="editStandard" id="editStandard" action="<%=editedURL %>" method="post" >
   <aui:input type="hidden" id="editStdId" name="editStdId" value=""/>
   <aui:input type="hidden" id="prntStdId" name="prntStdId" value=""/>
        <div class="modal-body">
            <%//Standard stds = (Standard)request.getAttribute("StandardsObj") ;
            List<Standard> editSpecsList = std.getSpecifications();
        	List<Standard> editGdlnsList = std.getGuidelines();
        	String indexPath = std.getTaxonomyPath();
        	
    		String currentIndex = std.getTaxonomyText();
    		if (indexPath != null && indexPath.contains(currentIndex)) {
    			indexPath = indexPath.replace(currentIndex, "");
    	%>
    		<div class="row-fluid">
    			<div class="span12">
    				<h4><span style="padding-left: 20px" class="grey"><%=indexPath %></span> <span class="blue"><%= currentIndex%></span></h4>
    			</div>
    		</div>
    		<%} else { %>
    					
    		<div class="row-fluid">
    			<div class="span12">
    				<h4><span style="padding-left: 20px" class="grey"><%=indexPath%></span></h4>
    			</div>
    		</div>
    		<% 		} %>
           <div class="row-fluid">
			<table border="0" class="table table-bordered specs table-striped">
				<tbody>                                                           
					<tr >	
					<td colspan="2"><strong><%=std.getTitle()%></strong>&nbsp;<span class="grey">[<%=std.getStdId()%>]</span></strong></td><td><input type="checkbox" name="selStdId" id="parent" value="<%=std.getStdId()%>" checked onclick="childCheckUnCheck()"></td>
					</tr>
					<%
					for(Standard specs: editSpecsList)
					{
					   // publishStdIds.add(specs.getPublishStdId());
						%>
					
					<tr ><td class="bull">&bull;</td>
					<td >
						<%=specs.getTitle() %>&nbsp;[<%=specs.getStdId() %>]
					</td>
					<td>
					<%if(specs.getPublishStdId() == 0 || specs.getStatus().equals("Y")) {%>
						<input type="checkbox" name="selStdId"  id="child" value="<%=specs.getStdId()%>" onclick="parentCheckUnCheck()">
					<%}else{ %>
						<input type="checkbox" name="selStdId"  id="child" value="<%=specs.getStdId()%>" checked onclick="parentCheckUnCheck()">
					<%} %>
					</td>
					</tr>
							
					
					<%
					}
					if(editGdlnsList.size()>0)
					{
						%>
						<tr>
						<td class="update"></td>
						<td  colspan="2" style="padding-top:5px;"><strong>Guidelines</strong></td></tr>
						<%
					}
					for(Standard gdln: editGdlnsList)
					{
					  //  publishStdIds.add(gdln.getPublishStdId());
						%>
					
					<tr>
					<td class="bull lg">&bull; &nbsp;</td>
					<td ><%=gdln.getDescription() %>&nbsp;[<%=gdln.getStdId() %>]
					</td>
					<td>
					<%if(gdln.getPublishStdId() == 0 || gdln.getStatus().equals("Y")) {%>
						<input type="checkbox" name="selStdId"  id="child" value="<%=gdln.getStdId()%>" onclick="parentCheckUnCheck()">
					<%}else{ %>
						<input type="checkbox" name="selStdId"  id="child" value="<%=gdln.getStdId()%>" checked onclick="parentCheckUnCheck()">
					<%} %>
					</td>
					</tr>
					<%
		}
		
		%>
				</tbody>
			 </table>
		  <hr/>
		 </div>
		 </div>
         </div>
        <div class="modal-footer">
            <div class="pull-left"><button type="button" class="btn searchoptioncancel">Cancel</button></div>
            <div class="pull-right"><button type="submit" id="save" class="btn btn-primary" onclick="javascript:modifyStandards()">Modify</button></div>
        </div>
    </form>
    