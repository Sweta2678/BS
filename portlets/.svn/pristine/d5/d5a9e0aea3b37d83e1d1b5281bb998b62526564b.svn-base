<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@include file="/html/init.jsp"%>

<div id="SupportingMatModal" title="Reference">
	<div class="modal-body">
	<section id="standards">
		<div class="row">
			<table border="0" class="specs"> <tbody> 
			<tbody>
				<c:if test="${not empty referenceRecords}">
					<tr>
						<td class="update invisible" width="60px"> </td> <td colspan="3" width="900px"> 
							<strong>${referenceRecords.title}</strong>&nbsp;<span class="grey">&nbsp;[${referenceRecords.stdId}]</span><span>&nbsp;</span>
						</td>
					</tr>				
					<c:forEach var="specifications" items="${referenceRecords.specifications}">	
						<tr>	
							<td class="update invisible" width="60px"> </td>
							<td class="bull">&bull;</td> 
							<td>${specifications.title}<span class="grey">&nbsp;[${specifications.stdId}]</span> <span>&nbsp;</span></td>
						</tr>
					</c:forEach>
					<c:if test="${not empty referenceRecords.guidelines}">
						<td class="update invisible"></td>
						<tr><td style="padding-top:5px;padding-left:50px;" class="lg" colspan="3"><strong>${guidelines}</strong></td></tr>
						<c:forEach var="gdlnRecords" items="${referenceRecords.guidelines}">	
							<tr>	
								<td class="update invisible" width="60px"> </td>
								<td class="bull lg">&bull; &nbsp;</td> 
								<td class="lg "> ${gdlnRecords.description} &nbsp; [${gdlnRecords.stdId}]</td>
							</tr>
						</c:forEach>
					</c:if>			
				</c:if>
		 	</tbody> 
		 	</table>
		</div>
	</section>	
	</div>
	<div class="modal-footer">
		<button class="btn" id="closeModal" data-dismiss="modal" aria-hidden="true" title="${closeMsg}">${closeMsg}</button>
	</div>
</div>
<script type="text/javascript">
	$( "#closeModal" ).click(function() {
		$( "#stdReferenceDialog_popup" ).dialog( "close" );
	});
	$( "#closePopUp" ).click(function() {
		$( "#stdReferenceDialog_popup" ).dialog( "close" );
	});
</script>