<%@page import="com.ihg.brandstandards.db.service.DepartmentLocalServiceUtil"%>
<%@include file="init.jsp"%>
<% int currPage = 0; %>
<form name="GEMDepartmentFM" method="post" action="">
		<table id="gemDeptTable" class="table table-bordered">
			<thead>
				<tr class="results_header_bar">
					<td width="10%"><strong>Dept ID</strong></td>
					<td width="30%"><strong>Department Name</strong></td>
					<td width="40%"><strong>Department Description</strong></td>
					<td width="10%"><strong>Status</strong></td>
					<td width="10%"><strong>Actions</strong></td>
				</tr>
			</thead>
			<tbody>
			<div>
			<liferay-ui:search-container hover="false" searchContainer="${searchContainer}">
				<liferay-ui:search-container-results>
				    <%
				    
   						pageContext.setAttribute("results", searchContainer.getResults());
   						pageContext.setAttribute("total", searchContainer.getTotal() );
   						currPage = searchContainer.getCur();
				    %>
				</liferay-ui:search-container-results>
				<liferay-ui:search-container-row className="com.ihg.brandstandards.db.model.Department" keyProperty="departmentId" modelVar="department">
					<portlet:resourceURL id='editDepartmentPopupURL' var ="editDepartmentPopupURL">
						<portlet:param name="cmd" value="editDepartment" />
						<portlet:param name="departmentId" value="${department.departmentId}" />
					</portlet:resourceURL>
					<portlet:resourceURL id='deleteDepartmentPopupURL' var ="deleteDepartmentPopupURL">
						<portlet:param name="cmd" value="deleteDepartment" />
						<portlet:param name="departmentId" value="${department.departmentId}" />
					</portlet:resourceURL>
					<tr id="${department.departmentId}">
						<td><span class="wrap_field">${department.departmentId}</span></td>
						<td><span class="wrap_field">${department.departmentName}</span></td>
						<td><span class="wrap_field">${department.description}</span></td>
						<td><span id="statusSpan" class="wrap_field">${department.activeInd=='Y'?'Active':'Inactive'}</span></td>
						
						<td style="text-align:center;">
							<a class="edit_link" href="javascript: void(0)" title="Edit Department" onclick="createEditDepartmentPopup('${editDepartmentPopupURL}')">
								<i class="icon-edit" id=""></i>
							</a>
							<c:if test="${department.activeInd=='N'}">
							<a class="edit_link" href="javascript: void(0)" title="Delete Department" onclick="deleteDepartment('${deleteDepartmentPopupURL}', '${department.departmentId}')">
								<i class="icon-remove"></i>
							</a>
							</c:if>
						</td>
					</tr>
				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator />
			</liferay-ui:search-container>	
			</div>	
			</tbody>
		</table>
	</form>
<%-- <script type="text/javascript">
function deleteDepartment(departmentId){
		jQuery.ajax({          
	        url:'<%=checkDeleteAssociationURL%>',
	        data: {
	        	departmentId: departmentId
	        },
	        type: 'POST',
			async: false,
	        success: function(data) 
	        { 
				var parsedData = JSON.parse(data);
	            var isAssociate =  parsedData.isAssociate;
	            if(isAssociate=='true'){
	            	
	            	if(confirm("This Department has associated with Publication. Are you sure you want to delete this ?")){
	            		location.href = '<%=deleteDepartmentURL%>'+'&departmentId='+departmentId;
	            	}
	            	
	            }else{
	            	if(confirm("Are you sure you want to delete this ?")){
	            		location.href = '<%=deleteDepartmentURL%>'+'&departmentId='+departmentId;
	            	}
	            }
	        }
	    }); 
		
	}
	
</script> --%>