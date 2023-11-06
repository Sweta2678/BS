<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portlet.documentlibrary.util.DLUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@include file="/html/init.jsp"%>

<div id="imageModal" title="Mandatory Images">
	<div class="modal-body">
	<%
		if(request.getAttribute("imageIds") != null){
			String imageIds = (String)request.getAttribute("imageIds");
			if(Validator.isNotNull(imageIds)){
				String images[] = imageIds.split(",");
				for(String imageId : images){
					if(Validator.isNotNull(imageIds)){
						String largeImageTitle = "";
						String largeImageURL = "";
						try{
							FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(Long.parseLong(imageId));
							largeImageTitle = fileEntry.getTitle();
	                        largeImageURL = DLUtil.getPreviewURL(fileEntry, fileEntry.getLatestFileVersion(), themeDisplay, "");
				       	} catch(Exception e){
				       		_log.error("Failed to get image from liferay with imageId:"+imageId);
				       	}
	%>
						<span><%= largeImageTitle%></span><br/>
						<img src="<%=largeImageURL %>" alt="<%= largeImageTitle%>" id="<%=imageId %>"/><br/>
	<%				
					}
				}
			}
		}
	%>
			
	</div>
	<div class="modal-footer">
		<button id="showImagesPopupClose" class="btn closebtnBottom showImagesPopupClose" title="Close">Close</button>
	</div>
</div>
<script type="text/javascript">
	$(".showImagesPopupClose").click(function() {
		$("#show_image_popup").dialog("close");
	});
</script>
<%!
	private static Log _log = LogFactoryUtil.getLog("BSBridge-portlet.docroot.html.progress.mandatoryImages_jsp");
%>