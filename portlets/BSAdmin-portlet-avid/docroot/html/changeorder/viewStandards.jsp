<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.webserver.WebServerServletTokenUtil"%>
<%@page import="com.liferay.portal.service.ImageLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Image"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.db.service.StandardsImagesLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsImages"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsDisplayOrderExt"%>
<%@page import="com.ihg.brandstandards.util.BrandStandardsUtil"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String title = (String)request.getAttribute("title");
    String indexAdminRoles = (String)request.getAttribute("indexAdminRoles");
%>

<table id="ordering_table" summary="Data table for assigned images." style="width:100%;margin-top:10px;float:left;">
    <tr class="ordering_table_header nodrop nodrag">
        <td width="8%">ID</td>
        <td width="80%">Standard</td>
        <td width="7%">Region</td>
        <td width="5%"></td>
    </tr>
<% 
    List<StandardsDisplayOrderExt> standardsDisplayOrder = (List<StandardsDisplayOrderExt>)request.getAttribute("standardsDisplayOrders");
    if(!BrandStandardsUtil.isNullOrBlank(standardsDisplayOrder)) {
        out.println("<tr class='nodrag' style='visibility:hidden'><td style='border:none'></td><td style='border:none'></td><td style='border:none'></td></tr>");
        for(StandardsDisplayOrderExt standardsDispOrder : standardsDisplayOrder) {
            boolean showMoveIcon = true;
%>
            <c:choose>
                <c:when test="${isIndexGLBLAdmin}">
                    <tr id="<%=standardsDispOrder.getStdId()%>">
                </c:when>
                <c:otherwise>
                <%
                    String cssClassForRecord = "";
                    String cssStyleForRecord = "display:none";
                    /* if("GLBL".equalsIgnoreCase(standardsDispOrder.getRegionCode()))
                    {
                        cssClassForRecord = " nodrag ";
                        showMoveIcon = false;
                    } */
                    if(Validator.isNotNull(indexAdminRoles))
                    {
                        for(String roleCode:indexAdminRoles.split(",")){
                            if(roleCode.equalsIgnoreCase(standardsDispOrder.getRegionCode()) || "GLBL".equalsIgnoreCase(standardsDispOrder.getRegionCode()) )
                            {
                                cssStyleForRecord = "";
                            }
                        }
                    }
                %>
                <tr id="<%=standardsDispOrder.getStdId()%>" class="<%=cssClassForRecord%>" style="<%=cssStyleForRecord%>">
                    <%-- <tr id="<%=standard.getStdId()%>" 
                    class="<%=("GLBL".equalsIgnoreCase(standard.getRegionCode()) ? "nodrop nodrag" : "")%>"> --%>
                </c:otherwise>
            </c:choose>
                <td><%=standardsDispOrder.getStdId()%></td>
                <td>
                <%
                    List<StandardsImages> stdImgs = StandardsImagesLocalServiceUtil.getStandardsImagesByStdId(standardsDispOrder.getStdId());
                    if(!BrandStandardsUtil.isNullOrBlank(stdImgs)) {
                %> 
						<img src="/BSTheme-theme/images/camera_icon.jpg"
                                class="global_icon" title="Has Images" alt="Has Images" />
                        <div id="<%=standardsDispOrder.getStdId()%>" style="display: none">
                            <%  
                                for(StandardsImages stdImg : stdImgs) {
								    DLFileEntry igImage = null;
                                    Image largeImage = null;
                                    try {
									    igImage = DLFileEntryLocalServiceUtil.getDLFileEntry(stdImg.getImageId());
                                        largeImage = ImageLocalServiceUtil.getImage(igImage.getLargeImageId());
                                    } catch(Exception e){
                                    }
                                    if(largeImage != null) {
                                        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
                            %>
								<img src="<%=themeDisplay.getPathImage() %>/image_gallery?img_id=<%= largeImage.getImageId() %>&t=<%= WebServerServletTokenUtil.getToken(largeImage.getImageId()) %>"
                                    alt="Standards Image" /> <br />
                            <%      }    
                                }
                            %>
                        </div> 
                <%  } 
                    if("GLBL".equals(standardsDispOrder.getRegionCode())) {
                        if("G".equals(standardsDispOrder.getIsGlobal())) {
                            if("Y".equals(standardsDispOrder.getFramework())) {
                %> 
								<img src="/BSTheme-theme/images/global_icon_red.png"
                                    class="global_icon" title="Global Framework standard icon"
                                    alt="Global Framework standard icon" /> 
                <%          
                            } else { 
                %> 
								<img src="/BSTheme-theme/images/global_icon.png"
                                    class="global_icon" title="Global standard icon"
                                    alt="Global standard icon" /> 
                <%          }
                        } else {
                            if("Y".equals(standardsDispOrder.getFramework())) {
                %> 
                      			<img src="/BSTheme-theme/images/global_icon_halfred.png"
                                    class="global_icon" title="Multi-region Framework standard icon"
                                    alt="Multi-region Framework standard icon" /> 
                <%          } else { %> 
								<img src="/BSTheme-theme/images/multi_region_icon.png"
                                    class="global_icon" title="Multi-region standard icon"
                                    alt="Multi-region standard icon" /> 
                <%          }
                        }
                    }
                %> 
                    <%=standardsDispOrder.getTitle()%>
                </td>
                <td><%=(standardsDispOrder.getRegionCode())%></td>
                <c:choose>
                    <c:when test="<%=showMoveIcon %>">
                        <td>
							<img src="/BSTheme-theme/images/movable_icon.jpg"
                                class="global_icon" title="Movable Row" alt="Movable Row" />
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td></td>
                    </c:otherwise>
                </c:choose>
            </tr>
<%      }
        out.println("<tr class='nodrag' style='visibility:hidden'><td style='border:none'></td><td style='border:none'></td><td style='border:none'></td></tr>");
    }
%>
</table>
<div class="wizard_navigation" id="stdOrderSubmitBtn">                          
    <input class="navigation_button" id="saveBtn" value="Save" type="submit" />
</div>
<script>
    originalStandardIdsOrder = '${originalStandardIdsOrder}';
    var userPrefChainCode = '${usrPrefchainCode}';
    if(userPrefChainCode != 'GL') {
        initDragNDrop("#ordering_table");   
    }
    
    var count = '${standardsDisplayOrdersCount}';
    if(count ==  0){
		
            //document.getElementById("copyBtn").disabled = true;
            document.getElementById("Submit").disabled = true;
            document.getElementById("saveBtn").disabled = true;
    }else{
            //document.getElementById("copyBtn").disabled = false;
            document.getElementById("Submit").disabled = false;
            
    }
    
</script>