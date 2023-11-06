<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@include file="/html/init.jsp"%>

<script type="text/javascript">
	jQuery(function() {
		
		$(".filter_text").bind('paste', function () {
		    var element = this;
		    setTimeout(function () {
		        var newVal = jQuery(element).val().replace(/[^0-9 ]+/g, '').trim();
		        newVal = newVal.replace(/\s{2,}/g, ' ').trim();
		        jQuery(element).val(newVal);
		        showFilterCount();
		    }, 200);
		});
	
		$(".filter_text").keydown(function(event) {
		    /* Allow: escape, backspace, delete, tab,*/ 
		    if ( event.keyCode == 27 || event.keyCode == 46 || event.keyCode == 8 || event.keyCode == 9 || 
		         /* Allow: space,           enter,                        home, end, left, right                  Ctrl*/
		         event.keyCode == 32 || event.keyCode == 13 || (event.keyCode >= 35 && event.keyCode <= 40) || event.ctrlKey )
		    {
		        return;
		    }
		    else 
		    {
		        /* Ensure that it is a number and stop the keypress*/
		        if (event.shiftKey || (event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 96 || event.keyCode > 105 )) 
		        {
		            event.preventDefault(); 
		        }   
		    }
		});
		
		$( "#closeModal" ).click(function() {
			$( "#updateLevelId_popup" ).dialog( "close" );
		});
		
		$( "#closePopUp" ).click(function() {
			$( "#updateLevelId_popup" ).dialog( "close" );
		});
	});
	
	
</script>
<portlet:actionURL name="updateLevelId" var="updateLevelId" />
	<c:choose>
		<c:when test='${adminUser eq true && groupType eq "WR"}'>
			<form method="post" action="${updateLevelId}" id="updateLevelId" name="updateLevelId">
		</c:when>
		<c:otherwise>
			<form method="post" action="" id="updateLevelId" name="updateLevelId" onsubmit="return false;">
		</c:otherwise>
	</c:choose>
		<div class="modal-body">
        	<div class="row-fluid">
        		<div class="pad10"> 
			        <div class="form-inline form-levelID">
						<table width="100%" class="table table-bordered">
							<c:choose>
								<c:when test='${groupType eq "WR"}'>
									<thead><tr><th>Group Name</th><th>Country/Region List</th><th>Level Id</th></tr></thead>
									<tbody>
										<c:forEach var="group" items="${groupData}">
											<tr>
												<td width="20%">${group.groupName}</td>
												<td width="60%">${group.countryList}</td>
												<td width="20%">
													<input type="text" class="filter_text" name="${group.groupId}" id="${group.groupId}" value="${group.levelId}">
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</c:when>
								<c:otherwise>
									<thead><tr><th>Group Name</th><th>Country/Region List</th></tr></thead>
									<tbody>
										<c:forEach var="group" items="${groupData}">
											<tr>
												<td width="20%">${group.groupName}</td>
												<td width="80%">${group.countryList}</td>
											</tr>
										</c:forEach>
									</tbody>
								</c:otherwise>
							</c:choose>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<c:if test='${adminUser eq true && groupType eq "WR"}'>
				<input type="submit" class="btn pull-right" value="Save" name="Save" />
			</c:if>
		    <input type="button" id="closeModal" class="btn pull-left" value="Cancel" name="Cancel" />
		</div>
	</form>