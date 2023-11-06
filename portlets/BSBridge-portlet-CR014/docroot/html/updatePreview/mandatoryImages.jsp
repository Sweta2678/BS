<%@include file="/html/init.jsp"%>

<div id=imageModal">
	<div class="modal-body">
		<c:forEach var="image" items="${stdDetails}">
			<img class="viewDetailsImg" src="/image/image_gallery?uuid=${image.uuid}&groupId=${image.groupId}" title="${image.imageTitle}"> <br>
		</c:forEach>
	</div>
	<div class="modal-footer">
		<button id="closePopUp" class="btn closebtnBottom" title="${closeMsg}">${closeMsg}</button>
	</div>
</div>
<script type="text/javascript">
	$("#closePopUp").click(function() {
		$("#mandatoryImages_popup").dialog("close");
	});
</script>