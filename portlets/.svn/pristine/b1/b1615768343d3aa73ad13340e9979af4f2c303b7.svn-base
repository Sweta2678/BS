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

<script src="/BSBridge-portlet/js/mypublication.js"></script>

<portlet:actionURL name="addStandards" var="addStandardsURL"/>
<portlet:actionURL name="saveStandardImport" var="saveStandardImport"/>
<portlet:resourceURL var="updateStdSelection" id="updateStdSelection">
	<portlet:param name="modalType" value="updateSelection"></portlet:param>
</portlet:resourceURL>

<portlet:renderURL var="cancelURL"></portlet:renderURL>

<%
String publicUrl = themeDisplay.getPathFriendlyURLPublic();
String communityUrl = themeDisplay.getURLHome();
String friendlyUrl = themeDisplay.getLayout().getFriendlyURL();
String url = publicUrl+"/brand-standards"+friendlyUrl;
long previousTaxonomyId = 0;
int currPage = 0;
List<Standard> displayList = new ArrayList<Standard>();
displayList = (List<Standard>)request.getAttribute("displayList");

Map<Long,String> myPublicationSession = (Map<Long,String>) request.getAttribute("myPublicationSession");

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
String userName = "";
String rgnName = "";
String languageName = "";
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
<script type="text/javascript">

var saveStandardImportURL = '${saveStandardImport}';

function submitPagination(source, value)
{	var pageNoValue = "";
	var itemsPageValue = "";
	//alert($("#itemsPerPage").val());
	itemsPageValue = $("#itemsPerPage").val();
	 pageNoValue=$("#pageNumber").val();
	if(source == "links")
	{
		pageNoValue = value;
	}
	if(source == 'itemsPerPageLower')
	{
		itemsPageValue = $("#itemsPerPageLower").val();
	}
	if(source == 'pageNumberLower')
	{
		 pageNoValue=$("#pageNumberLower").val();
	}
	if(source == 'itemsPerPage' || source == 'itemsPerPageLower')
	{
		pageNoValue = 1;
	}
	var submitUrl = "<%=url%>?renderJSP=viewImport&pageNumber="+pageNoValue+"&itemsPerPage="+itemsPageValue;
	window.location = submitUrl;
}

function saveStds()
{
	jQuery( "#<portlet:namespace/>addPublishStadnards" ).attr('action',saveStandardImportURL);
	jQuery( "#<portlet:namespace/>addPublishStadnards" ).submit();
}


function addStds()
{
	jQuery( "#<portlet:namespace/>addPublishStadnards" ).submit();
}
</script>

<style type="text/css">
	.taglib-search-iterator-page-iterator-top {margin-left: -20px;}
	
	#page-footer { height: 100px; 
	background-color: lightgrey;
	}

</style>
<aui:form action="<%=addStandardsURL %>" method="post" name="addPublishStadnards" id="addPublishStadnards">
<aui:input type="hidden" id="hidStdId" name="hidStdId" value=""/>
<!-- Keep the below 2 un-closed divs as this is a fix for footer left aligning issue -->
<div><div>
<div class="clear"></div>



<div class="row" > 
	<div class="well well-small" style="margin-bottom: 10px;" > 
		<div class="row" style="margin-top: 5px;"> 
			
			<div class="span6 pull-left"> 
				
					<span><strong>Find By ID:</strong></span> 
					<input type="text" style="margin-bottom: 0px;" class="input-medium" placeholder="Enter STD ID to find ..."> 
									<a href="#find" role="button" class="btn btn-primary"><i class="icon-search icon-white"></i> Go</a> 
									<a href="#clearFind" role="button" class="btn"><i class="icon-remove"></i> Clear</a> 
				
			</div> 
		</div> 
		<hr/>  
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
			 <div class="span2">
				<div class="pull-right">
					<a class="btn btn-small" href="#" id="export">Export</a>
				</div>
			</div> 
		</div>
	</div>
</div>
<section id="standards">		
<%	
if(displayList!=null && displayList.size()>0)
{	for(Standard standards : displayList)
	{
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
		<%} else { %>
					
		<div class="row">
			<h4><span class="grey"><%=indexPath%></span></h4>
		</div>
		<% 		} %>
			
		<% 	} 
			previousTaxonomyId = standards.getTaxonomyId();
		%>

		<div class="row">
			<table border="0" class="specs">
				<tbody>                                                           
					<tr >	
					<td align="center" width="120px">
						<%if(standards.getStatus().equals("NOTBRND"))
						{%><span class="label label-warning">Not <%=brandName %></span><%}
						else if(standards.getStatus().equals("NOTRGN"))
						{%><span class="label label-warning">Not <%=rgnName %></span><%}
						else if(standards.getStatus().equals("GLBLMST"))
						{%><span class="label label-success">Global Must</span>
						<%}
						else if(standards.getStatus().equals("GLBLMSTNOT"))
						{%><span class="label label-important">Global Must Not</span><%}
						else if(standards.getStatus().equals("ORPHAN"))
						{%><span class="label label-inverse">Orphan</span><%} 
						else {%>&nbsp;<%} %>
					</td>
					<td width="10px">
						<%if(standards.getStatus().equals("NOTBRND") || standards.getStatus().equals("NOTRGN") || standards.getStatus().equals("GLBLMSTNOT"))
						{%>&nbsp;<%}
						else if(standards.getStatus().equals("GLBLMST"))
						{%><input type="checkbox" name="selectStd" id="selectStd" value="<%=standards.getStdId()%>" disabled="true" checked>
						<%}
						else if(standards.getStatus().equals("ORPHAN") || standards.getStatus().equals("MISSING") || standards.getStatus().equals("UNPUBLISH"))
						{
							if ("Y".equalsIgnoreCase(myPublicationSession.get(standards.getStdId()))) {
								%>
								<input type="checkbox" name="selectStd" id="selectStd_<%=standards.getStdId()%>" value="<%=standards.getStdId()%>" checked  
								onclick="javascript:updateSelectionVal(<%=standards.getStdId()%>);"/>
								<%
							} else {
								%>
									<input type="checkbox" name="selectStd" id="selectStd_<%=standards.getStdId()%>" value="<%=standards.getStdId()%>" 
									onclick="javascript:updateSelectionVal(<%=standards.getStdId()%>);"/>
								<%
							}
						} 
						else {
							if ("Y".equalsIgnoreCase(myPublicationSession.get(standards.getStdId()))) {
								%>
								<input type="checkbox" name="selectStd" id="selectStd_<%=standards.getStdId()%>" value="<%=standards.getStdId()%>" checked  
								onclick="javascript:updateSelectionVal(<%=standards.getStdId()%>);"/>
								<%
							} else {
								%>
									<input type="checkbox" name="selectStd" id="selectStd_<%=standards.getStdId()%>" value="<%=standards.getStdId()%>" 
									onclick="javascript:updateSelectionVal(<%=standards.getStdId()%>);"/>
								<%
							}
							
						} %>
					</td>
					
					<td colspan="2" >
					
					<strong><%=standards.getTitle()%></strong>&nbsp;<span class="grey">[<%=standards.getStdId()%>]</span>
							<% 
							
							if (Validator.isNotNull(standards.getStdRefId())) {
						%>
							<span class="label"><i class="icon-share-alt icon-white"></i>${referencedIds} [
						<%
							    
							int count =0;
							for (String refIds : standards.getStdRefId().split(",")) {
							    if (count > 0) {
						%>
							,&nbsp;
						<%        
							    }
						%>
							 	<a href="#" class="grey" onclick='javascript:stdReferencePopup("<%=refIds %>")'><%=StringUtil.trim(refIds) %></a>
						<%
								count++;
								}
						%>
							]</span>
						<%
							}
						%>
					</td>
					</tr>
					<%
					for(Standard specs: specsList)
					{
					   // publishStdIds.add(specs.getPublishStdId());
						%>
					
					<tr >
					<td align="center" width="120px">
						<%if(specs.getStatus().equals("NOTBRND"))
						{%><span class="label label-warning">Not <%=brandName %></span><%}
						else if(specs.getStatus().equals("NOTRGN"))
						{%><span class="label label-warning">Not <%=rgnName %></span><%}
						else if(specs.getStatus().equals("GLBLMST"))
						{%><span class="label label-success">Global Must</span>
						<%}
						else if(specs.getStatus().equals("GLBLMSTNOT"))
						{%><span class="label label-important">Global Must Not</span><%}
						else if(specs.getStatus().equals("ORPHAN"))
						{%><span class="label label-inverse">Orphan</span><%} 
						else {%>&nbsp;<%} %>
					</td>
					<td width="10px"><%if(specs.getStatus().equals("NOTBRND") || specs.getStatus().equals("NOTRGN") || specs.getStatus().equals("GLBLMSTNOT"))
						{%>&nbsp;<%}
						else if(specs.getStatus().equals("GLBLMST"))
						{%><input type="checkbox" name="selectStd" id="selectStd" value="<%=specs.getStdId()%>" disabled="true" checked>
						<%}
						else if(specs.getStatus().equals("ORPHAN") || specs.getStatus().equals("MISSING") || specs.getStatus().equals("UNPUBLISH"))
						{
							if ("Y".equalsIgnoreCase(myPublicationSession.get(specs.getStdId()))) {
						%>
							<input type="checkbox" name="selectStd" id="selectStd_<%=specs.getStdId()%>" value="<%=specs.getStdId()%>" checked 
							onclick="javascript:updateSelectionVal(<%=specs.getStdId()%>);">
						<%	
							} else {
						%>
							<input type="checkbox" name="selectStd" id="selectStd_<%=specs.getStdId()%>" value="<%=specs.getStdId()%>" 
							onclick="javascript:updateSelectionVal(<%=specs.getStdId()%>);">
						<%		
							}
						} 
						else {
							if ("Y".equalsIgnoreCase(myPublicationSession.get(specs.getStdId()))) {
								%>
									<input type="checkbox" name="selectStd" id="selectStd_<%=specs.getStdId()%>" value="<%=specs.getStdId()%>" checked 
									onclick="javascript:updateSelectionVal(<%=specs.getStdId()%>);">
								<%	
									} else {
								%>
									<input type="checkbox" name="selectStd" id="selectStd_<%=specs.getStdId()%>" value="<%=specs.getStdId()%>" 
									onclick="javascript:updateSelectionVal(<%=specs.getStdId()%>);">
								<%		
									}
							} %>
						</td>
					<td class="bull">&bull;</td>
						
					<td >
					
						<%=specs.getTitle() %><span class="grey">&nbsp;[<%=specs.getStdId() %>] </span>
							<% 
							if (Validator.isNotNull(specs.getStdRefId())) {
							%>
								<span class="label"><i class="icon-share-alt icon-white"></i>${referencedIds} [
							<%
								int count =0;    
								for (String refIds : specs.getStdRefId().split(",")) {
								    if (count > 0) {
							%>
								,&nbsp;
							<%	        
								    }
							%>
									 <a href="#" class="grey" onclick='javascript:stdReferencePopup("<%=refIds %>")'><%=StringUtil.trim(refIds) %></a>
							<%	    count++;
								    }
							%>
								]</span>
							<%
								}
						%>
						</td>
					</tr>
							
					
					<%
					}
					if(gdlnsList.size()>0)
					{
						%>
						<tr>
						<td class="update invisible"></td><td>
						&nbsp;</td>
						<td class="lg" colspan="2" style="padding-top:5px;"><strong>Guidelines</strong></td></tr>
						<%
					}
					for(Standard gdln: gdlnsList)
					{
					  //  publishStdIds.add(gdln.getPublishStdId());
						%>
					
					<tr>
					
						<td align="center" width="120px">
						<%if(gdln.getStatus().equals("NOTBRND"))
						{%><span class="label label-warning">Not <%=brandName %></span><%}
						else if(gdln.getStatus().equals("NOTRGN"))
						{%><span class="label label-warning">Not <%=rgnName %></span><%}
						else if(gdln.getStatus().equals("GLBLMST"))
						{%><span class="label label-success">Global Must</span>
						<%}
						else if(gdln.getStatus().equals("GLBLMSTNOT"))
						{%><span class="label label-important">Global Must Not</span><%}
						else if(gdln.getStatus().equals("ORPHAN"))
						{%><span class="label label-inverse">Orphan</span><%} 
						else {%>&nbsp;<%} %>
					</td>
					<td width="10px"><%if(gdln.getStatus().equals("NOTBRND") || gdln.getStatus().equals("NOTRGN") || gdln.getStatus().equals("GLBLMSTNOT"))
						{%>&nbsp;<%}
						else if(gdln.getStatus().equals("GLBLMST"))
						{%><input type="checkbox" name="selectStd" id="selectStd" value="<%=gdln.getStdId()%>" disabled="true" checked>
						<%}
						else if(gdln.getStatus().equals("ORPHAN") || gdln.getStatus().equals("MISSING") || gdln.getStatus().equals("UNPUBLISH"))
						{
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
						else {
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
							
						} %></td>
		
						<td class="bull lg">&bull; &nbsp;</td>
						<%
					boolean isSearchMatchedGdlnId = false;
				
					
					
					%>
					
					<td class="lg ">
					
						<%=gdln.getDescription() %>&nbsp;[<%=gdln.getStdId() %>]
						
						<span>&nbsp;</span>
						
						<%
							if (Validator.isNotNull(gdln.getStdRefId())) {
						%>
							<span class="label"><i class="icon-share-alt icon-white"></i>${referencedIds} [
						<%
							int count =0;    
							for (String refIds : gdln.getStdRefId().split(",")) {
							    if (count > 0) {
						%>
								,&nbsp;
						<%	        
							    }
						%>
								 <a href="#" class="grey" onclick='javascript:stdReferencePopup("<%=refIds %>")'><%=StringUtil.trim(refIds) %></a>
						<%	    
								count++;    
							}
						%>
							]</span>
						<%
							}
						%>
						</td>
					</tr>
					<%
		}
		previousTaxonomyId = standards.getTaxonomyId();
		%>
				</tbody>
			 </table>
		  <hr/>
		 </div>
	<%
					}
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



<nav>
	<div class="row navbar">
		<div class="footer navbar-fixed-bottom1" style="background-color: Gainsboro;" valign="middle">
			<div class="container" style="padding-top: 10px;padding-bottom: 10px;">
				<div class="pull-left">
					<a class="btn" href="<%=cancelURL%>">Cancel</a></div>
				<div class="pull-right" style="padding-right: 40px;">
					<a class="btn btn-primary" href="javascript:saveStds()">Save</a> <a class="btn btn-primary" href="javascript:addStds()">Add Items</a></div>
			</div>
		</div>
	</div>
</nav>
</aui:form>
<script>
var updatePublicationURL = '${updateStdSelection}';

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
            .resize(positionFooter)
});
function updateSelectionVal (stdId) {
	
	var chkBoxVal = 'N';
	if ($('#selectStd_'+stdId).prop('checked')) {
		chkBoxVal = 'Y';
	}
	$.ajax({
	  	url :updatePublicationURL,
	  	type: "POST",
	  	data: {"standardId":stdId,"isSelected":chkBoxVal},
	  	dataType: "text",
	    success: function(data) {
	    	
	    }
	 });
}


</script>
