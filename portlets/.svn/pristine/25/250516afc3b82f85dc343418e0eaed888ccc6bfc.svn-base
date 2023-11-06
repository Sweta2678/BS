<%@page import="com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ihg.brandstandards.util.StandardsUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.util.DLUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.ihg.brandstandards.util.BrandStandardsUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Image"%>
<%@page import="com.ihg.brandstandards.db.service.StandardsImagesLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsImages"%>
<%@page import="com.ihg.brandstandards.db.model.Standards"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

		<%
        List<Standards> specList = (List<Standards>) request.getAttribute("specList");
		List<Standards> guideLineList = (List<Standards>) request.getAttribute("gdlnList");
		String chainCodeVal = ""+request.getAttribute("brandName");
		String regionName = ""+request.getAttribute("regionName");
		String message = "To define a new display order for specifications or guidelines 'drag and drop' the rows in the tables below:";
		if (specList.size() == 0 && guideLineList.size() == 0) {
			message = "No specifications and guidelines are attributed to "+chainCodeVal + " for "+regionName; 
		}
        %>
        <p class="change_order_description"><%=message %></p>
		<%
			if (specList.size() > 0) {
		%>
			<table id="specification_list_${chainCode}"  style="width:100%">
                  <tr class="specification_list_header nodrop nodrag">
                      <td><p>ID</p></td>
                      <td><p>Specifications</p></td>
                      <td><p>Region</p></td>
                  </tr>
           <%
        	for(Standards specItem : specList){
        %>
        <tr id="<%=specItem.getStdId() %>">
                      <td><%=specItem.getStdId() %></td>
                      <td style="width:75%;">
	                    <%
								List<StandardsImages> stdImgs = StandardsImagesLocalServiceUtil.getStandardsImagesByStdId(specItem.getStdId());
								if(!BrandStandardsUtil.isNullOrBlank(stdImgs))
								{
							%>
									<img src="/BSTheme-theme/images/camera_icon.jpg" class="global_icon" title="Has Images" alt="Has Images" />
									<div id="<%=specItem.getStdId()%>" style="display:none">
										<%  for(StandardsImages stdImg : stdImgs)
											{
												DLFileEntry igImage = DLFileEntryLocalServiceUtil.getDLFileEntry(stdImg.getImageId());
												//Image largeImage = ImageLocalServiceUtil.getImage(igImage.getLargeImageId());
												FileEntry largeImage = DLAppLocalServiceUtil.getFileEntry(stdImg.getImageId());
												ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
										%>
												<img src="<%=DLUtil.getImagePreviewURL(largeImage, themeDisplay) %>" alt="Standards Image"/>
												<br/>
										<%	}
										%>
									</div>
							<%  } %>
	                      	<%
                            if("GLBL".equals(specItem.getRegionCode())) 
                            {
                                if("G".equals(specItem.getIsGlobal())) 
    							{
    							    if("Y".equals(specItem.getFramework())) 
    							    {
                                    %>
	                                <img src="/BSTheme-theme/images/global_icon_red.png" class="global_icon" title="Global Framework standard icon" alt="Global Framework standard icon" />
                                    <%
                                    }
    							    else
    							    {
                                    %>
                                    <img src="/BSTheme-theme/images/global_icon.png" class="global_icon" title="Global standard icon" alt="Global standard icon" />
                                    <%
                                    }
                                } 
                                else
                                {
                                    if("Y".equals(specItem.getFramework())) 
                                    {
                                    %>
                                    <img src="/BSTheme-theme/images/global_icon_halfred.png" class="global_icon" title="Multi-region Framework standard icon" alt="Multi-region Framework standard icon" />
                                    <%
                                    }
                                    else
                                    {
                                    %>
                                    <img src="/BSTheme-theme/images/multi_region_icon.png" class="global_icon" title="Multi-region standard icon" alt="Multi-region standard icon" />
                                    <%
                                    }
                                }
                                
                            }
                            %>
	                      	<%=specItem.getTitle() %>
	                     
                      </td>
                      <td>
                      	<%=StandardsUtil.getRegionNameFromRegionCode(specItem.getRegionCode()) %>
                      </td>
        </tr>
                  <%
        }%>
        </table>
        <%
		}	
        %>
        <table id="guideline_list_${chainCode}" style="width:100%">
         <%
         if(guideLineList.size() > 0){
        %>
                  <tr class="guideline_list_header nodrop nodrag">
                      <td><p>ID</p></td>
                      <td><p>Guidelines</p></td>
                      <td><p>Region</p></td>
                  </tr>
        <%
        	for(Standards guideLineItem : guideLineList){
        %>
        <tr id="<%=guideLineItem.getStdId() %>">
                      <td><%=guideLineItem.getStdId() %></td>
                      <td style="width:75%;">
                     <%
								List<StandardsImages> stdImgs = StandardsImagesLocalServiceUtil.getStandardsImagesByStdId(guideLineItem.getStdId());
								if(!BrandStandardsUtil.isNullOrBlank(stdImgs))
								{
							%>
									<a onclick="showImages(<%=guideLineItem.getStdId()%>);" ><img src="/BSTheme-theme/images/camera_icon.jpg" class="global_icon" title="Has Images" alt="Has Images" /></a>
									<div id="<%=guideLineItem.getStdId()%>" style="display:none">
										<%  for(StandardsImages stdImg : stdImgs)
											{
												DLFileEntry igImage = DLFileEntryLocalServiceUtil.getDLFileEntry(stdImg.getImageId());
												//Image largeImage = ImageLocalServiceUtil.getImage(igImage.getLargeImageId());
												FileEntry largeImage = DLAppLocalServiceUtil.getFileEntry(stdImg.getImageId());
												ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
										%>
												<img src="<%=DLUtil.getImagePreviewURL(largeImage, themeDisplay) %>" alt="Standards Image"/>
												<br/>
										<%	}
										%>
									</div>
							<%  } %>
                      <%
                            if("GLBL".equals(guideLineItem.getRegionCode())) 
                            {
                                if("G".equals(guideLineItem.getIsGlobal())) 
    							{
    							    if("Y".equals(guideLineItem.getFramework())) 
    							    {
                                    %>
	                                <img src="/BSTheme-theme/images/global_icon_red.png" class="global_icon" title="Global Framework standard icon" alt="Global Framework standard icon" />
                                    <%
                                    }
    							    else
    							    {
                                    %>
                                    <img src="/BSTheme-theme/images/global_icon.png" class="global_icon" title="Global standard icon" alt="Global standard icon" />
                                    <%
                                    }
                                } 
                                else
                                {
                                    if("Y".equals(guideLineItem.getFramework())) 
                                    {
                                    %>
                                    <img src="/BSTheme-theme/images/global_icon_halfred.png" class="global_icon" title="Multi-region Framework standard icon" alt="Multi-region Framework standard icon" />
                                    <%
                                    }
                                    else
                                    {
                                    %>
                                    <img src="/BSTheme-theme/images/multi_region_icon.png" class="global_icon" title="Multi-region standard icon" alt="Multi-region standard icon" />
                                    <%
                                    }
                                }
                            }
                            %>
                      <%=guideLineItem.getDescription() %>
                     </td>
                     <td>
                      	<%=StandardsUtil.getRegionNameFromRegionCode(guideLineItem.getRegionCode()) %>
                      </td>
        </tr>
                  <%
        }
        }%>
</table>
        <input type="hidden" id="spec_std_ids_${chainCode}" name="spec_std_ids_${chainCode}" value=""/>
        <input type="hidden" id="guide_std_ids_${chainCode}" name="guide_std_ids_${chainCode}" value=""/>
		

<script>
var accordion_chain = '${chainCode}';
initDragNDrop("#specification_list_"+accordion_chain);
initDragNDrop("#guideline_list_"+accordion_chain);
</script>