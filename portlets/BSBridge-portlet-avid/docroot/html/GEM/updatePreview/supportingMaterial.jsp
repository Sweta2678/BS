<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.ihg.brandstandards.util.BSLanguageUtil"%>
<%@include file="/html/init.jsp"%>
<%
	BSLanguageUtil obsmLanguageUtil = new BSLanguageUtil("en_GB", "OBSM");
%>
<div id="SupportingMatModal" title="${supportingMaterial}">

<div class="modal-body"><span data-geo="data-geo"
	class="help-tooltip-sup pull-right btn btn-small btn-primary"
	title="${helpMsg}"><i class="icon-white icon-question-sign"></i>
${help}</span>
<table class="table">
	<tbody>
		<c:forEach var="attachmentType" items="${attachmentTypes}">
			<c:if test='${attachmentType.key ne "" && not empty stdDetails.attachments[attachmentType.key]}'>
				<c:set var="attachKey" value="${attachmentType.key}" />
				<tr>
					<%
						if (Validator.isNotNull(request.getAttribute("langCode"))) {
					%>
					<td colspan="4">
						<strong>
						<%
							String attachMentType = "";
							if(obsmLanguageUtil != null){
							    attachMentType = obsmLanguageUtil.get("bs.attachment.type." + pageContext.getAttribute("attachKey").toString().toLowerCase());
							} else{
							    attachMentType = "bs.attachment.type." + pageContext.getAttribute("attachKey").toString().toLowerCase();
							}
						%>
						<%= attachMentType %>
						</strong>
					</td>
					<%
						} else {
					%>
					<td colspan="4"><strong>${attachmentType.value}</strong></td>
					<%
						}
					%>
				</tr>
				<c:forEach var="attachment"
					items="${stdDetails.attachments[attachmentType.key]}">
					<tr>
						<c:set var="contentType"
							value="${fn:toLowerCase(attachment.attachmentExt)}" />
						<c:if test='${fn:contains(supportedFormats,contentType)}'>
							<c:set var="contentType" value="${displayFormat}" />
						</c:if>
						<td><span class="label label-success">${contentType}</span></td>
						<td style="width:60%;"><a href="#" title="${attachment.attachmentName}">${attachment.attachmentName}</a> 
						<c:choose>
							<c:when test='${fn:containsIgnoreCase(attachment.attachmentStatus,"New")}'>
								<span class="label label-success">${newRecord}</span>
							</c:when>
							<c:when test='${fn:containsIgnoreCase(attachment.attachmentStatus,"Updated")}'>
								<span class="label label-warning">${updatedRecord}</span>
							</c:when>
							<c:otherwise>
								<span></span>
							</c:otherwise>
						</c:choose>
						</td>
						<td class="downloadCell"><a class="btn"
							href="${attachment.attachmentLink}" target="_blank" title="${downloadMsg}"><i
							class="icon-download-alt"></i></a></td>
					</tr>
				</c:forEach>
			</c:if>
		</c:forEach>
		<c:if test='${not empty stdDetails.externalLinks}'> 
		<tr>
			<td colspan="4"><strong>${links}</strong></td>
		</tr>
		<c:forEach var="externalLink" items="${stdDetails.externalLinks}">
			<tr>
				<td></td>
				<td style="width:60%;"><a href="${externalLink.externalURL}" target="_blank" class="ltrt-margin" title="${externalLink.externalLink}" 
				onclick="_gaq.push(['_trackEvent', 'Supporting Material', 'Click External Link',
				'External URL ${externalLink.externalLink}']);">${externalLink.externalLink}</a>
				<c:choose>
					<c:when test='${fn:containsIgnoreCase(externalLink.externalLinkStatus, "New")}'>
						<span class="label label-success">${newRecord}</span>
					</c:when>
					<c:when test='${fn:containsIgnoreCase(externalLink.externalLinkStatus, "Updated")}'>
						<span class="label label-warning">${updatedRecord}</span>
					</c:when>
					<c:otherwise>
						<span></span>
					</c:otherwise>
					</c:choose>
				</td>
				<td class="downloadCell"></td>
			</tr>
		</c:forEach>
		</c:if>
	</tbody>
</table>
</div>
<div class="modal-footer">
<button class="btn" id="closeModal" data-dismiss="modal"
	aria-hidden="true" title="${closeMsg}">${closeMsg}</button>
</div>
</div>
<script type="text/javascript">
$( "#closeModal" ).click(function() {
	$( "#supportingMaterial_popup" ).dialog( "close" );
});
$( "#closePopUp" ).click(function() {
	$( "#supportingMaterial_popup" ).dialog( "close" );
});
$(".help-tooltip-sup").tooltip({
	items: "img, [data-geo], [title]",
	content: function() {
	var element = $( this );
		if ( element.is( "[data-geo]" ) ) {
		var title = element.attr( "title" );
		var text = element.text();
		return "<h3 class='tooltip-title'>"+text+"</h3><div class='tooltip-content'>"+title+"</div>";
		}

	},
	 position: {
		my: "center bottom-20",
		at: "center top",
		using: function( position, feedback ) {
		$( this ).css( position );
		$( "<div>" )
		.addClass( "arrow" )
		.addClass( feedback.vertical )
		.addClass( feedback.horizontal )
		.appendTo( this );
		}
		}

});
</script>