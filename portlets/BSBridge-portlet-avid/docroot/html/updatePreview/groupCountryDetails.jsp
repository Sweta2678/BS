<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@include file="/html/init.jsp"%>

<script type="text/javascript">
	jQuery(function() {
		
		$( "#closeModal" ).click(function() {
			$( "#updateLevelId_popup" ).dialog( "close" );
		});
		
		$( "#closePopUp" ).click(function() {
			$( "#updateLevelId_popup" ).dialog( "close" );
		});
	});
	
	
</script>
<portlet:actionURL name="changeGroup" var="changeGroup" />
		
		<form method="post" action="${changeGroup}" id="changeGroup" name="changeGroup">
		<div class="modal-body">
        	<div class="row-fluid">
        		<div class="pad10"> 
			        <div class="form-inline form-levelID">
						<table width="100%" class="table table-bordered">
							<thead><tr><th>Group Name</th><th>Country List</th><th>Action</th></tr></thead>
							<tbody>
								<c:forEach var="group" items="${groupData}">
									<tr>
										<td width="20%">${group.groupName}</td>
										<td width="60%">${group.countryList}</td>
										<td width="20%">
											<c:choose>
												<c:when test="${group.groupName eq selectedGrpName}">
													<input type="radio" name="currentGroup" id="currentGroup" checked value="${group.groupName}"/>
												</c:when>
												<c:otherwise>
													<input type="radio" name="currentGroup" id="currentGroup" value="${group.groupName}"/>
												</c:otherwise>											
											</c:choose>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<input type="submit" class="btn pull-right" value="Save" name="Save" />
		    <input type="button" id="closeModal" class="btn pull-left" value="Cancel" name="Cancel" />
		</div>
	</form>