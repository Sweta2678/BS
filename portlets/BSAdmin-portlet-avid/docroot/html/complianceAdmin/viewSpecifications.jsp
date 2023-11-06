<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.util.DLUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ihg.brandstandards.util.BrandStandardsUtil"%>
<%@include file="/html/init.jsp" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.ihg.brandstandards.db.model.PublishExtStd"%>
<%@page import="com.liferay.portal.service.ImageLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Image"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.db.service.StandardsImagesLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsImages"%>
<%@page import="com.liferay.portal.webserver.WebServerServletTokenUtil"%>
<%@page import="java.util.List"%>
<script type="text/javascript">
	jQuery(function() {
	    jQuery('.nyroModal').nyroModal(); 
	});
</script>
<table  class="results_table" summary="Data table showing Specifications for a Standard.">
<%
	DateFormat df = new SimpleDateFormat("d MMM yyyy");
	List<PublishExtStd> arlSpecifications = (List<PublishExtStd>)request.getAttribute("arlSpecifications");
	long standardId = (Long)request.getAttribute("standardsId");
	String tabs1 = (String)request.getAttribute("tabs1");
	String editUrl = (String)request.getAttribute("editUrlParam");
	if(arlSpecifications != null  && arlSpecifications.size() > 0) {
		for(int i = 0; i < arlSpecifications.size(); i++) {
	    	PublishExtStd standards = (PublishExtStd)arlSpecifications.get(i);
%>
	<tr style="background: none repeat scroll 0 0 #EEEEEE;">
       	<td class="result_table_cell1"><img src="/BSTheme-theme/images/solo_branch.png" title="sub item" alt="sub item icon"/><%=standards.getStdId() %></td>
       	<td>
       	<%
			List<StandardsImages> stdImgs = new ArrayList<StandardsImages>();
       		try {
       			stdImgs = StandardsImagesLocalServiceUtil.getStandardsImagesByStdId(standards.getStdId());
       		} catch(Exception e){
       			_log.error(e.getMessage());
       		}
			if(!BrandStandardsUtil.isNullOrBlank(stdImgs)) {
		%>
			<a onclick="showImages(<%=standards.getStdId()%>);" ><img src="/BSTheme-theme/images/camera_icon.jpg" class="global_icon" title="Has Images" alt="Has Images" /></a>
			<div id="<%=standards.getStdId()%>" style="display:none">
			<%  for(StandardsImages stdImg : stdImgs) {
					DLFileEntry igImage = null;
	                String largeImage = "";
	                String imageId = "";
	            	try {
	            		imageId = stdImg.getImageId()+"";
	                	igImage = DLFileEntryLocalServiceUtil.getDLFileEntry(stdImg.getImageId());
	                	FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(igImage.getFileEntryId());
	                    largeImage = DLUtil.getPreviewURL(fileEntry, fileEntry.getLatestFileVersion(), themeDisplay, "");
	            	} catch(Exception e){
	                	_log.error(e.getMessage());
	            	}	
			%>
					<img src="<%=largeImage %>" alt="Standards Image" id="<%=imageId %>"/><br/>
			<%	} %>
			</div>
		<%  } %>
       	<%
       		if("GLBL".equals(standards.getRegionCode())) {
           		if("G".equals(standards.getIsGlobal())) {
               		if("Y".equals(standards.getFramework())) {
		%>
               			<img src="/BSTheme-theme/images/global_icon_red.png" class="global_icon" title="Global Framework standard icon" alt="Global Framework standard icon" />
		<%			} else { %>
               			<img src="/BSTheme-theme/images/global_icon.png" class="global_icon" title="Global standard icon" alt="Global standard icon" />
		<%			}
           		} else {
               		if("Y".equals(standards.getFramework())) {
		%>
               			<img src="/BSTheme-theme/images/global_icon_halfred.png" class="global_icon" title="Multi-region Framework standard icon" alt="Multi-region Framework standard icon" />
		<%			} else { %>
               			<img src="/BSTheme-theme/images/multi_region_icon.png" class="global_icon" title="Multi-region standard icon" alt="Multi-region standard icon" />
		<%			}
           		}
       		}
       	%>
      			<%=standards.getTitle() %>
      		</td>
		<%-- <td class="result_table_cell3"><%=df.format(standards.getCompDate()) %></td> --%>
		<%-- <td class="result_table_cell4"><c:choose><c:when test="<%=Validator.isNotNull(standards.getExpiredIds()) %>">Yes</c:when><c:otherwise>&nbsp;</c:otherwise></c:choose></td> --%>
		<%-- &deadlineDate=<%=(standards.getCompDate() != null ? standards.getCompDate().getTime() : System.currentTimeMillis())%> --%>
		<td class="result_table_spec_cell5">
			<a title="Edit Tooltip" 
				href="/web/brand-standards/compliance-deadline?stdId=<%=standards.getStdId()%>&brandCode=<%=tabs1%><%=editUrl %>">
				<img class="log_icon" alt="Edit Icon" title="Edit Deadline" src="/BSTheme-theme/images/edit_pencil_icon.png" /> 
			</a>
		</td>
	</tr>
<%
		}
	}
%>
</table>
<%!
	private static Log _log = LogFactoryUtil.getLog("BSAdmin-portlet.docroot.html.complianceAdmin.viewSpecifications_jsp");
%>