<%@include file="/html/init.jsp"%>
<%
	BSLanguageUtil obsmLanguageUtil = (BSLanguageUtil)session.getAttribute("obsmLanguageUtil");
%>
<portlet:resourceURL id='downloadAllAttachments'
	var="downloadAllAttachments">
	<portlet:param name="modalType" value="download"></portlet:param>
</portlet:resourceURL>
<div id="allSupportingModal" title="${allSupportingMaterialTitle}">

<div class="modal-body">
<div class="row">
<c:if test="${showSearchResultsMsg}">
	<div class="span7">
	<div class="infoBar highlight" style="text-align: left">${searchResultsMsg}</div>
	</div>
</c:if> 
<c:if test="${showNoSearchActiveMsg}">
	<div class="span10">
	<div class="infoBar">${noSearchActiveMsg}</div>
	</div>
</c:if> <c:set var="smallSize" value="< 1 MB"  /> <span
	class="span2 pull-right"> <span data-geo="data-geo"
	class="help-tooltip pull-right btn btn-small btn-primary"
	title="${helpMsg}"><i class="icon-white icon-question-sign"></i>
${help}</span> </span></div>
<p style="margin-top: 5px;"><em>${searchMessage}</em></p>
<div class="accordion_supporting_material" id="allsupportaccordion"
	style="margin-top: 10px;">
	<c:forEach var="attachmentType"
	items="${attachmentTypes}" varStatus="status">
	<c:if test='${attachmentType.key ne "" && not empty stdDetails.attachments[attachmentType.key]}'>
		<c:set var="attachKey" value="${attachmentType.key}" />
		<h3 class="accordionTitle">
			<%
				String attachMentType = "";
				if(obsmLanguageUtil != null){
				    attachMentType = obsmLanguageUtil.get("bs.attachment.type." + pageContext.getAttribute("attachKey").toString().toLowerCase());
				} else{
				    attachMentType = "bs.attachment.type." + pageContext.getAttribute("attachKey").toString().toLowerCase();
				}
			%>
			<%= attachMentType %> 
			<span class="black">(${fn:length(stdDetails.attachments[attachmentType.key])} ${items})</span>
		</h3>

		<div class="design_solutions"><c:set var="temp" value="" /> <c:set
			var="fileSize" value="0" /> 
		<div class="accordion-inner">
		<c:if test='${not empty stdDetails.attachments[attachmentType.key]}'>

			<c:if test="${fn:length(stdDetails.attachments[attachmentType.key]) gt 1}">
				<table width="100%">
					<tr>
						<td>&nbsp;
							<div class="alert-informative" id="accordian_${status.index}_label" style="display: none;">
							</div>
						</td>
						<td width="200">
							<div class="right_section_aco">
								<label	id="${attachmentType.key}_file" style="display: inline;">${fileSize} MB</label> 
								<a class="btn" id="accordian_${status.index}" onclick="javascript:downloadAttachments($(this).attr('id'));">
									<i class="icon-download-alt"></i> ${downloadAll}</a>&nbsp;
							</div>
						</td>
					</tr>
				</table>
			</c:if>
		</c:if>
		<table class="table table-condensed">
			<tr>
				<th>${type}</th>
				<th>${title}</th>
				<th class="stdId">${standard}</th>
				<th class="downloadCell"></th>
			</tr>
			<c:forEach var="attachment"
				items="${stdDetails.attachments[attachmentType.key]}"
				varStatus="atchStatus">
				<c:if test="${not empty temp}">
					<c:set var="temp" value="${temp},${attachment.dlFileEntryId}" />
				</c:if>
				<c:if test="${empty temp}">
					<c:set var="temp" value="${attachment.dlFileEntryId}" />
				</c:if>
				<c:set var="contentType"
					value="${fn:toLowerCase(attachment.attachmentExt)}" />
				<c:if test='${fn:contains(supportedFormats,contentType)}'>
					<c:set var="contentType" value="${displayFormat}" />
				</c:if>
				<tr>
					<c:set var="fileSize" value="${fileSize + attachment.fileSize}" />
					
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
					<td class="stdId">[${attachment.standardId}]</td>
					<td class="downloadCell"><c:set var="attachment_size"
						value="${attachment.fileSize}" /> <c:choose>
						<c:when test='${attachment.fileSize gt 0 }'>
							<c:set var="sizeInMB" value="MB" />
							<label id="${attachment.dlFileEntryId}_file"
								style="display: inline;"> ${attachment_size} ${sizeInMB}</label>
						</c:when>
						<c:otherwise>
							<label id="${attachment.dlFileEntryId}_file"
								style="display: inline;"> ${smallSize}</label>
						</c:otherwise>
					</c:choose> <a class="btn" href="${attachment.attachmentLink}" target="_blank"
						title="${downloadMsg}" onclick="_gaq.push(['_trackEvent', 'All Supporting Material', 'Download Attachment',
						'Attachment ${attachment.attachmentName}']);"><i class="icon-download-alt"></i>
					${downloadMsg}</a></td>
				</tr>
				<c:if test="${atchStatus.last}">
					<input type="hidden" value="${temp}"
						id="accordian_${status.index}_ids" />
					<script type="text/javascript">
	var attachmentKey = '${attachmentType.key}_file';
	var size = '${fileSize}';
	if (size == 0) {
		size = '< 1MB';
	} else {
		size = size + ' MB';
	}
	$('#' + attachmentKey).html(size);
</script>
				</c:if>
			</c:forEach>

		</table>
		</div>

		</div>
	</c:if>
</c:forEach> 
	<h3
		class="accordionTitle ui-accordion-header ui-helper-reset ui-state-default ui-corner-all ui-accordion-icons">${links}<span
		class="black"> (${fn:length(stdDetails.externalLinks)}
	${items})</span></h3>
	<div class="links_aco">
	<div class="accordion-inner">
	<table class="table table-condensed">
		<tr>
			<th>${link}</th>
			<th class="stdId">${standard}</th>
		</tr>
		<c:forEach var="externalLink" items="${stdDetails.externalLinks}">
			<tr>
				<td style="width:60%;"><a href="${externalLink.externalURL}" class="ltrt-margin"
					target="_blank" title="${externalLink.externalLink}"
					 onclick="_gaq.push(['_trackEvent', 'All Supporting Material', 'Click External Link',
					 'External Link ${externalLink.externalLink}']);">${externalLink.externalLink}</a>
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
				<td class="stdId">[${externalLink.standardId}]</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	</div>
</div>
</div>
<div class="modal-footer">
<button id="closePopUp" class="btn closebtnBottom" title="${closeMsg}">${closeMsg}</button>
</div>
</div>
<script type="text/javascript">
	var downloadAllAttachments = '${downloadAllAttachments}';
	var attachments = '';

	$("#closePopUp").click(function() {
		$("#supportingMaterial_popup").dialog("close");
	});

	function downloadAttachments(div) {
		var ids = div + "_ids";
		if ('disabled' == $('#' + div).attr("disabled")) {
			return false;
		} 
		attachments = $('#' + ids).val();
		$.ajax({
			url : downloadAllAttachments,
			data : {
				"attachmentIds" : attachments
			},
			type : "POST",
			dataType : "text",
			success : function(data) {
				if (typeof data != 'undefined' && data != null && data != '') {
					_gaq.push(['_trackEvent', 'All Supporting Material', 'Download All','Download All']);
					$('#' + div).attr("disabled", "disabled");
					$('#' + div+'_label').html(data);
					$('#' + div+'_label').attr('style', 'display:block');
					//alert(data);	
				}
			}
		});
	}
	
	$(document).ready(function() {
		//allsupportaccordion call
		$("#allsupportaccordion").accordion({
			collapsible : true,
			active : false,
			heightStyle : "content"
		});
	});
	$(".help-tooltip").tooltip({
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