<%@page import="com.ihg.brandstandards.custom.model.Standard"%>
<%@page import="com.ihg.brandstandards.bridge.util.BrandStandardsUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@page import="com.liferay.portal.kernel.search.SearchContext" %>
<%@page import="com.liferay.portal.kernel.search.SearchContextFactory" %>
<%@page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@page import="com.liferay.portal.kernel.util.StringPool" %>
<%@page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@page import="com.liferay.portal.kernel.util.Validator" %>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.ihg.brandstandards.custom.model.Preferences"%>
<%@page import="java.util.ArrayList"%>
<%@include file="/html/init.jsp"%>
<c:choose>
    <c:when test="${displayNoPublishMessage}">
        Please create new publication.
    </c:when>
    <c:otherwise>

<portlet:actionURL name="importStandards" var="importURL"/>
<portlet:resourceURL id="addStandards" var="addStandardsURL">
	<portlet:param name="modalType" value="addStandards"></portlet:param>
</portlet:resourceURL>

<portlet:actionURL name="saveStandardImport" var="saveStandardImport"/>
<portlet:resourceURL var="updateStdSelection" id="updateStdSelection">
	<portlet:param name="modalType" value="updateSelection"></portlet:param>
</portlet:resourceURL>
<portlet:resourceURL var="exportURL" id="exportSelection">
	<portlet:param name="modalType" value="exportSelection"></portlet:param>
</portlet:resourceURL>
<portlet:actionURL name="deleteStandardsImport" var="cancelURL"></portlet:actionURL>

<%
String publicUrl = themeDisplay.getPathFriendlyURLPublic();
String friendlyUrl = themeDisplay.getLayout().getFriendlyURL();
String url = publicUrl+"/brand-standards"+friendlyUrl;
long previousTaxonomyId = 0;
List<Standard> displayList = (List<Standard>)request.getAttribute("displayList");

Map<Long,String> myPublicationSession = (Map<Long,String>) request.getAttribute("myPublicationSession");
int importCount = (Integer)request.getAttribute("importCount");
long bridgePublishId = (Long)request.getAttribute("bridgePublishId");
boolean isPublicationLocked = session == null ? false : (session.getAttribute("publicationLocked") == null ? false : (Boolean) session.getAttribute("publicationLocked"));
int pageNumber = (Integer)request.getAttribute("pageNumber");
int  noOfPages = (Integer)request.getAttribute("noOfPages");
int previousPage = 1;
int nextPage = noOfPages;
String recordsPerPage = String.valueOf(request.getAttribute("recordsPerPage"));
if(pageNumber == previousPage)
{
	previousPage = 1;	
}
else
{
	previousPage = pageNumber-1;	
}
if(pageNumber == nextPage)
{
	nextPage = noOfPages;	
}
else
{
	nextPage = pageNumber+1;	
}

Preferences accessPrefs = (Preferences) session.getAttribute("Preferences");
String rgnName = "";
String brandName = "";
String brandCode = "";
Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap();

if(accessPrefs != null)
{
    rgnName = accessPrefs.getRegionName();
	brandCode = accessPrefs.getBrand();
}
		brandName =	chnCdMap.get(brandCode);
	//SearchContainer listContainer = (SearchContainer)request.getAttribute("searchContainer");
%>
<style type="text/css">
	.taglib-search-iterator-page-iterator-top {margin-left: -20px;}
	
	#page-footer { height: 100px; 
	background-color: lightgrey;
	}

</style>


<script>
var updatePublicationURL = '${updateStdSelection}';
var exportURL = '${exportURL}';
var saveStandardImportURL = '${saveStandardImport}';
var addStandardsURL = '${addStandardsURL}';
var pageUrl = '<%=url%>';
var portletNameSpace = '<portlet:namespace/>';
var disableAddToMyPub = ${disableAddToMyPub};


jQuery(window).bind("load", function() { 
    
    var footerHeight = 0,
        footerTop = 0,
        footerDiv = jQuery("#page-footer");
        
    positionFooter();
    
    function positionFooter() {
    
             footerHeight = footerDiv.height();
             footerTop = (jQuery(window).scrollTop()+jQuery(window).height()-footerHeight)+"px";
    
            if ( (jQuery(document.body).height()+footerHeight) < jQuery(window).height()) {
            	footerDiv.css({
                     position: "absolute"
                }).animate({
                     top: footerTop
                })
            } else {
            	footerDiv.css({
                     position: "static"
                })
            }
            
    }
    
    jQuery(window)
            .scroll(positionFooter)
            .resize(positionFooter);
});

</script>

<script type="text/javascript" src="/BSBridge-theme/js/treeAdmin/jquery.blockUI.js"></script>
<script type="text/javascript" src="/BSBridge-theme/js/treeAdmin/jquery.msgBox.js"></script>
<script src="/BSBridge-portlet/js/addByImport.js"></script>

<aui:form method="post" name="addPublishStadnards" id="addPublishStadnards">
<aui:input type="hidden" id="hidStdId" name="hidStdId" value=""/>
<!-- Keep the below 2 un-closed divs as this is a fix for footer left aligning issue -->
<div><div>

<div class="row" > 
	<div class="well well-small" style="margin-bottom: 10px;" > 
		<%if( importCount == 0 && bridgePublishId > 0 && !isPublicationLocked){ %>
			<div class="row" style="margin-top: 5px;"> 
				<div class="span4"> 
					<div class="form-inline" style="margin-bottom: 0;"> 
							<a class="btn btn-primary add-by-import" href="#"><i class="icon-white icon-upload"></i> Add By Import</a> 
						<div style="margin-top: 3px;"> </div> 
					</div> 
				</div> 
			</div> 
			<hr/>  
		<%} %>
		<div class="row" style="margin-top: 5px;">
			<div class="span8 form-inline">	 
				
					<label>Items Per Page:</label>
					<select class="input-mini" id="itemsPerPage" name="itemsPerPage" onchange="submitPagination('itemsPerPage',0)">
						<c:forEach var="opt" items="${itemsPerPageOptions}">
							<%
								String opt = (String)pageContext.getAttribute("opt");
								String selected = "";
								if(recordsPerPage != null && opt != null && recordsPerPage.trim().equalsIgnoreCase(opt.trim())) {
									selected = "selected";
								}
							%>
							<option <%=selected%> value="${opt}">${opt}</option>
						</c:forEach>
					</select>
					<label>&nbsp;|&nbsp;Page:</label>
					<select class="input-mini" id="pageNumber" name="pageNumber" onchange="submitPagination('pageNumber',0)">
						<% 	for(int i = 0; i < noOfPages; i++) {
								if(i+1 == pageNumber) { 
						%>  
									<option selected value="<%=i+1%>"><%=i+1 %></option>
						<%  	} else { %>
									<option value="<%=i+1%>"><%=i+1 %></option>
						<%  	}
				          	} 
				        %>
					</select>
				    <span> of &nbsp; <%=noOfPages %></span>
				    <span>&nbsp;|&nbsp;</span>
				   	<% if(pageNumber != 1) { %>
				   		<a href="#" onclick="submitPagination('links', 1)">
				   			<i class="icon-step-backward"></i>First
				   		</a>
				   	<% } else { %>
				   		<i class="icon-step-backward"></i>First
				   	<% } %>
				    <span>&nbsp;|&nbsp;</span>
				   	<% if(pageNumber != 1) { %>
				   		<a href="#" onclick="submitPagination('links', <%=previousPage%>)">
				   			<i class="icon-chevron-left"></i>Previous
				   		</a>
				   	<% } else { %>
				   		<i class="icon-chevron-left"></i>Previous
				   	<% } %>
				    <span>&nbsp;|&nbsp;</span>
				    <% if(pageNumber != noOfPages) { %>
				    	<a href="#" onclick="submitPagination('links', <%=nextPage%>)">
				    		<i class="icon-chevron-right"></i>&nbsp;Next
				    	</a>
				    <% } else { %>
				    <i class="icon-chevron-right"></i>&nbsp;Next
				    <% } %>
				    <span>&nbsp;|&nbsp;</span>
				    <% if(pageNumber != noOfPages) { %>
				    	<a href="#" onclick="submitPagination('links', <%=noOfPages%>)">
				    		<i class="icon-step-forward"></i>&nbsp;Last
				    	</a>
				    <% } else { %>
				    	<i class="icon-step-forward"></i>&nbsp;Last
				    <% } %>
				
	        	
			</div>
			<c:if test="${importIssueCount gt 0}">
				<div class="span2">
					<div class="pull-right issues_count">
							<img src="/BSBridge-theme/images/issue_icon.png"> ${importIssueCount} Issues
					</div>
				</div>
				 <div>
					<div class="pull-right">
						<a class="btn btn-primary export-report" href="#" id="export" > <i class="icon-white icon-arrow-down"></i> Export</a> 
					</div>
				</div> 
			</c:if>
		</div>
	</div>
</div>
<section id="standards">		
	<%	
	if(displayList!=null && displayList.size()>0) {	
		for(Standard standards : displayList) {
			List<Standard> specsList = standards.getSpecifications();
			List<Standard> gdlnsList = standards.getGuidelines();
			if(previousTaxonomyId != standards.getTaxonomyId()) {
				String indexPath = standards.getTaxonomyPath();
				String currentIndex = standards.getTaxonomyText();
				if (indexPath != null && indexPath.contains(currentIndex)) {
					indexPath = indexPath.replace(currentIndex, "");
	%>
			<div class="row">
				<h4><span class="grey"><%=indexPath %></span> <span class="blue"><%= currentIndex%></span></h4>
			</div>
	<%			} else { %>
						
			<div class="row">
				<h4><span class="grey"><%=indexPath%></span></h4>
			</div>
	<%			} 
			} 
			previousTaxonomyId = standards.getTaxonomyId();
	%>
	<div class="row">
		<table border="0" class="specs">
			<tbody>                                                           
				<tr >	
				<td align="center" width="120px">
					<% if(standards.getStatus().equals("NOTBRND")) { %>
						<span class="label label-warning">Not <%=brandName %></span>
					<% } else if(standards.getStatus().equals("NOTRGN")) { %>
						<span class="label label-warning">Not <%=rgnName %></span>
					<% } else if(standards.getStatus().equals("GLBLMST")) { %>
						<span class="label label-success">Global Must</span>
					<% } else if(standards.getStatus().equals("GLBLMSTNOT")) { %>
						<span class="label label-important">Global Must Not</span>
					<% } else if(standards.getStatus().equals("GNOTINMUST")) { %>
						<span class="label label-important">Global Not In Must</span>
					<% } else if(standards.getStatus().equals("UNPUBLISH")) { %>
						<span class="label label-important">Unpublish</span>
					<% } else if(standards.getStatus().equals("DISCONT")) { %>
						<span class="label label-warning">Discontinued</span>
					<% } else if(standards.getStatus().equals("ORPHAN")) { %>
						<span class="label label-inverse">Orphan</span>
					<% } else if(standards.getStatus().equals("MISSING")) { %>
						<span class="label label-inverse">Missing</span>
					<% } else { %>&nbsp;<% } %>
				</td>
				<td width="10px">
					<%	if(standards.getStatus().equals("NOTBRND") || standards.getStatus().equals("NOTRGN") || 
							standards.getStatus().equals("GLBLMSTNOT") || standards.getStatus().equals("GNOTINMUST") || standards.getStatus().equals("DISCONT")) {
					%>&nbsp;
					<% 	} else if(standards.getStatus().equals("GLBLMST")) { %>
						<input type="checkbox" name="selectStd" id="selectStd" value="<%=standards.getStdId()%>" disabled="true" checked>
					<%	} else if(standards.getStatus().equals("ORPHAN") || standards.getStatus().equals("MISSING") || standards.getStatus().equals("UNPUBLISH")) {
							if ("Y".equalsIgnoreCase(myPublicationSession.get(standards.getStdId()))) {
					%>
								<input type="checkbox" name="selectStd" id="selectStd_<%=standards.getStdId()%>" value="<%=standards.getStdId()%>" checked  
									onclick="javascript:updateSelectionVal(<%=standards.getStdId()%>);"/>
					<%    	} else { %>
								<input type="checkbox" name="selectStd" id="selectStd_<%=standards.getStdId()%>" value="<%=standards.getStdId()%>" 
									onclick="javascript:updateSelectionVal(<%=standards.getStdId()%>);"/>
					<% 		}
						} else {
							if ("Y".equalsIgnoreCase(myPublicationSession.get(standards.getStdId()))) {
					%>
								<input type="checkbox" name="selectStd" id="selectStd_<%=standards.getStdId()%>" value="<%=standards.getStdId()%>" checked  
									onclick="javascript:updateSelectionVal(<%=standards.getStdId()%>);"/>
					<%
							} else {
					%>
								<input type="checkbox" name="selectStd" id="selectStd_<%=standards.getStdId()%>" value="<%=standards.getStdId()%>" 
									onclick="javascript:updateSelectionVal(<%=standards.getStdId()%>);"/>
					<% 		}
						} 
					%>
				</td>
				
				<td colspan="2" >
					<strong><%=standards.getTitle()%></strong>&nbsp;<span class="grey">[<%=standards.getStdId()%>]</span>
					<% 	if (Validator.isNotNull(standards.getStdRefId())) { %>
						<span class="label"><i class="icon-share-alt icon-white"></i>${referencedIds} [
					<%
							int count =0;
							for (String refIds : standards.getStdRefId().split(",")) {
						    	if (count > 0) {
					%>
									,&nbsp;
					<% 		} %>
						 		<a href="#" class="grey" onclick='javascript:stdReferencePopup("<%=refIds %>")'><%=StringUtil.trim(refIds) %></a>
					<%
								count++;
							}
					%>
						]</span>
					<%	} %>
				</td>
				</tr>
				<% 	for(Standard specs: specsList) { %>
				<tr >
				<td align="center" width="120px">
					<% if(specs.getStatus().equals("NOTBRND")) { %>
						<span class="label label-warning">Not <%=brandName %></span>
					<% } else if(specs.getStatus().equals("NOTRGN")) { %>
						<span class="label label-warning">Not <%=rgnName %></span>
					<% } else if(specs.getStatus().equals("GLBLMST")) { %>
						<span class="label label-success">Global Must</span>
					<% } else if(specs.getStatus().equals("GLBLMSTNOT")) { %>
						<span class="label label-important">Global Must Not</span>
					<% } else if(specs.getStatus().equals("GNOTINMUST")) { %>
						<span class="label label-important">Global Not In Must</span>
					<% } else if(specs.getStatus().equals("UNPUBLISH")) { %>
						<span class="label label-important">Unpublish</span>
					<% } else if(specs.getStatus().equals("DISCONT")) { %>
						<span class="label label-warning">Discontinued</span>
					<% } else if(specs.getStatus().equals("ORPHAN")) { %>
						<span class="label label-inverse">Orphan</span>
					<% } else if(specs.getStatus().equals("MISSING")) { %>
						<span class="label label-inverse">Missing</span>
					<% } else { %>&nbsp;<% } %>
				</td>
				<td width="10px">
					<% 
						if(specs.getStatus().equals("NOTBRND") || specs.getStatus().equals("NOTRGN") || 
								specs.getStatus().equals("GLBLMSTNOT") || specs.getStatus().equals("GNOTINMUST") || specs.getStatus().equals("DISCONT")) { 
					%>
						&nbsp;
					<%  } else if(specs.getStatus().equals("GLBLMST")) {%>
							<input type="checkbox" name="selectStd" id="selectStd" value="<%=specs.getStdId()%>" disabled="true" checked>
					<%  } else if(specs.getStatus().equals("ORPHAN") || specs.getStatus().equals("MISSING") || specs.getStatus().equals("UNPUBLISH")) {
							if ("Y".equalsIgnoreCase(myPublicationSession.get(specs.getStdId()))) {
					%>
								<input type="checkbox" name="selectStd" id="selectStd_<%=specs.getStdId()%>" value="<%=specs.getStdId()%>" checked 
								onclick="javascript:updateSelectionVal(<%=specs.getStdId()%>);">
					<% 		} else { %>
								<input type="checkbox" name="selectStd" id="selectStd_<%=specs.getStdId()%>" value="<%=specs.getStdId()%>" 
								onclick="javascript:updateSelectionVal(<%=specs.getStdId()%>);">
					<% 		}
					    } else {
							if ("Y".equalsIgnoreCase(myPublicationSession.get(specs.getStdId()))) {
					%>
								<input type="checkbox" name="selectStd" id="selectStd_<%=specs.getStdId()%>" value="<%=specs.getStdId()%>" checked 
								onclick="javascript:updateSelectionVal(<%=specs.getStdId()%>);">
					<%	 	} else { %>
								<input type="checkbox" name="selectStd" id="selectStd_<%=specs.getStdId()%>" value="<%=specs.getStdId()%>" 
								onclick="javascript:updateSelectionVal(<%=specs.getStdId()%>);">
					<% 		}
					    } 
					%>
				</td>
				<td class="bull">&bull;</td>
				<td>
					<%=specs.getTitle() %><span class="grey">&nbsp;[<%=specs.getStdId() %>] </span>
					<%	if (Validator.isNotNull(specs.getStdRefId())) { %>
						<span class="label"><i class="icon-share-alt icon-white"></i>${referencedIds} [
					<%
						int count =0;    
						for (String refIds : specs.getStdRefId().split(",")) {
							if (count > 0) {
					%>
							,&nbsp;
					<%		}
					%>
							<a href="#" class="grey" onclick='javascript:stdReferencePopup("<%=refIds %>")'><%=StringUtil.trim(refIds) %></a>
					<%		count++;
						}
					%>
						]</span>
					<%	} %>
				</td>
				</tr>
				<% 
					}
					if(gdlnsList.size()>0) {
				%>
					<tr>
					<td class="update invisible"></td><td>
					&nbsp;</td>
					<td class="lg" colspan="2" style="padding-top:5px;"><strong>Guidelines</strong></td></tr>
				<%
					}
					for(Standard gdln: gdlnsList) {
				%>
				<tr>
				<td align="center" width="120px">
					<% if(gdln.getStatus().equals("NOTBRND")) { %>
						<span class="label label-warning">Not <%=brandName %></span>
					<% } else if(gdln.getStatus().equals("NOTRGN")) { %>
						<span class="label label-warning">Not <%=rgnName %></span>
					<% } else if(gdln.getStatus().equals("GLBLMST")) { %>
						<span class="label label-success">Global Must</span>
					<% } else if(gdln.getStatus().equals("GLBLMSTNOT")) { %>
						<span class="label label-important">Global Must Not</span>
					<% } else if(gdln.getStatus().equals("GNOTINMUST")) { %>
						<span class="label label-important">Global Not In Must</span>
					<% } else if(gdln.getStatus().equals("UNPUBLISH")) { %>
						<span class="label label-important">Unpublish</span>
					<% } else if(gdln.getStatus().equals("DISCONT")) { %>
						<span class="label label-warning">Discontinued</span>
					<% } else if(gdln.getStatus().equals("ORPHAN")) { %>
						<span class="label label-inverse">Orphan</span>
					<% } else if(gdln.getStatus().equals("MISSING")) { %>
						<span class="label label-inverse">Missing</span>
					<% } else { %>&nbsp;<% } %>
				</td>
				<td width="10px">
					<%	if(gdln.getStatus().equals("NOTBRND") || gdln.getStatus().equals("NOTRGN") || 
							gdln.getStatus().equals("GLBLMSTNOT") || gdln.getStatus().equals("GNOTINMUST") || gdln.getStatus().equals("DISCONT")) { %>		
							&nbsp;
					<%	} else if(gdln.getStatus().equals("GLBLMST")) { %>
							<input type="checkbox" name="selectStd" id="selectStd" value="<%=gdln.getStdId()%>" disabled="true" checked>
					<%	} else if(gdln.getStatus().equals("ORPHAN") || gdln.getStatus().equals("MISSING") || gdln.getStatus().equals("UNPUBLISH")) {
							if ("Y".equalsIgnoreCase(myPublicationSession.get(gdln.getStdId()))) {
					%>
								<input type="checkbox" name="selectStd" id="selectStd_<%=gdln.getStdId()%>" value="<%=gdln.getStdId()%>" checked 
								onclick="javascript:updateSelectionVal(<%=gdln.getStdId()%>);">
					<%	
							} else {
					%>
								<input type="checkbox" name="selectStd" id="selectStd_<%=gdln.getStdId()%>" value="<%=gdln.getStdId()%>" 
								onclick="javascript:updateSelectionVal(<%=gdln.getStdId()%>);">
					<%		}
						} else {
							if ("Y".equalsIgnoreCase(myPublicationSession.get(gdln.getStdId()))) {
					%>
								<input type="checkbox" name="selectStd" id="selectStd_<%=gdln.getStdId()%>" value="<%=gdln.getStdId()%>" checked 
								onclick="javascript:updateSelectionVal(<%=gdln.getStdId()%>);">
					<%	
								} else {
					%>
								<input type="checkbox" name="selectStd" id="selectStd_<%=gdln.getStdId()%>" value="<%=gdln.getStdId()%>" 
								onclick="javascript:updateSelectionVal(<%=gdln.getStdId()%>);">
					<%		
								}
						
					} 
					%>
				</td>
				<td class="bull lg">&bull; &nbsp;</td>
				<%	boolean isSearchMatchedGdlnId = false; %>
				<td class="lg ">
					<%=gdln.getDescription() %>&nbsp;[<%=gdln.getStdId() %>]
					<span>&nbsp;</span>
					<%	if (Validator.isNotNull(gdln.getStdRefId())) { %>
						<span class="label"><i class="icon-share-alt icon-white"></i>${referencedIds} [
					<%
							int count =0;    
							for (String refIds : gdln.getStdRefId().split(",")) {
						    	if (count > 0) {
					%>
									,&nbsp;
					<%	 		} %>
							 	<a href="#" class="grey" onclick='javascript:stdReferencePopup("<%=refIds %>")'><%=StringUtil.trim(refIds) %></a>
					<%	    
								count++;    
							}
					%>
							]</span>
					<%	} %>
				</td>
				</tr>
				<%	}
					previousTaxonomyId = standards.getTaxonomyId();
				%>
			</tbody>
		 </table>
	  <hr/>
	</div>
	<%		}
		}
	%>
</section>
<section class="row">
	<div class="well well-small" style="margin-top: 5px;">
		<div class="form-inline" style="margin-top: 5px;">
         		
				<label>Items Per Page:</label>
				<select class="input-mini" id="itemsPerPageLower" name="itemsPerPageLower" onchange="submitPagination('itemsPerPageLower',0)">
					<c:forEach var="opt" items="${itemsPerPageOptions}">
						<%
							String opt = (String)pageContext.getAttribute("opt");
							String selected = "";
							if(recordsPerPage != null && opt != null && recordsPerPage.trim().equalsIgnoreCase(opt.trim())) {
								selected = "selected";
							}
						%>
						<option <%=selected%> value="${opt}">${opt}</option>
					</c:forEach>
				</select>
				<label>&nbsp;|&nbsp;Page:</label>
				<select class="input-mini" id="pageNumberLower" name="pageNumberLower" onchange="submitPagination('pageNumberLower',0)">
					<% 	for(int i = 0; i < noOfPages; i++) {
							if(i+1 == pageNumber) { 
					%>  
								<option selected value="<%=i+1%>"><%=i+1 %></option>
					<%  	} else { %>
								<option value="<%=i+1%>"><%=i+1 %></option>
					<%  	}
			          	} 
			        %>
				</select>
			    <span> of&nbsp; <%=noOfPages %></span>
			    <span>&nbsp;|&nbsp;</span>
			   	<% if(pageNumber != 1) { %>
			   		<a href="#" onclick="submitPagination('links', 1)">
			   			<i class="icon-step-backward"></i>First
			   		</a>
			   	<% } else { %>
			   		<i class="icon-step-backward"></i>First
			   	<% } %>
			    <span>&nbsp;|&nbsp;</span>
			   	<% if(pageNumber != 1) { %>
			   		<a href="#" onclick="submitPagination('links', <%=previousPage%>)">
			   			<i class="icon-chevron-left"></i>Previous
			   		</a>
			   	<% } else { %>
			   		<i class="icon-chevron-left"></i>Previous
			   	<% } %>
			    <span>&nbsp;|&nbsp;</span>
			    <% if(pageNumber != noOfPages) { %>
			    	<a href="#" onclick="submitPagination('links', <%=nextPage%>)">
			    		<i class="icon-chevron-right"></i>&nbsp;Next
			    	</a>
			    <% } else { %>
			    <i class="icon-chevron-right"></i>&nbsp;Next
			    <% } %>
			    <span>&nbsp;|&nbsp;</span>
			    <% if(pageNumber != noOfPages) { %>
			    	<a href="#" onclick="submitPagination('links', <%=noOfPages%>)">
			    		<i class="icon-step-forward"></i>&nbsp;Last
			    	</a>
			    <% } else { %>
			    	<i class="icon-step-forward"></i>&nbsp; Last
			    <% } %>
			
       	</div>
       </div>
       
</section>		


<c:if test="<%=displayList.size() > 0 %>">
<nav>
	<div class="row navbar">
		<div class="footer navbar-fixed-bottom1" style="background-color: Gainsboro;" valign="middle">
			<div class="container" style="padding-top: 10px;padding-bottom: 10px;">
				<div class="pull-left">
					<c:choose>
					<c:when test="${disableAddToMyPub}">
						<a class="btn" href="javascript:void(0)" disabled="disabled">Cancel</a></div>
					</c:when>
					<c:otherwise>
						<a class="btn" href="<%=cancelURL%>">Cancel</a></div>
					</c:otherwise>
					</c:choose>
				<div class="pull-right" style="padding-right: 40px;">
					<a id="saveImport" class="btn btn-primary" href="javascript:saveStds()">Save</a> 
					<a id="addToMyPublication" class="btn btn-primary" href="javascript:addStds()">Add To My Publications</a>
				</div>
			</div>
		</div>
	</div>
</nav>
</c:if>
</aui:form>

<div id="exportReport" title="Issue Report" style="display:none">
    <form id="exportForm" name="exportForm" method="post" >
        <div class="modal-body">
        	<input type="radio" checked  style="margin-top: -3px;"/> Export Issue from Import
            <h4>Report Title <input type="text" id="reportTitle" name="reportTitle"/> </h4> 
          </div>
        <div class="modal-footer">
            <div class="pull-left"><button type="button" class="btn exportCancel">Cancel</button></div>
            <div class="pull-right"><a class="btn btn-primary" href="javascript:exportStds(${reportId})">Run</a></div>
        </div>
    </form>
</div>

<div id="addByImport" title="Add items to My Publication" style="display:none">
    <form id="importForm" name="importForm" action="<%=importURL %>" method="post" enctype="multipart/form-data">
        <div class="modal-body">
            <h4>Please select a file to upload:</h4> <input type="file" id="file" class="add_item_file_input" name="file"/>
          </div>
        <div class="modal-footer">
            <div class="pull-left"><button type="button" class="btn searchoptioncancel">Cancel</button></div>
            <div class="pull-right"><button type="submit" id="upload" class="btn btn-primary">Upload</button></div>
        </div>
    </form>
</div>

    </c:otherwise>
</c:choose>