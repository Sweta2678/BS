<%@page import="com.ihg.grs.util.AssetLibUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />
<%@ include file="/html/init.jsp" %>

<portlet:resourceURL var="sendEmail" id="shareContent">
	<liferay-portlet:param name="requestType" value="shareContent" />
</portlet:resourceURL>

<liferay-portlet:renderURL  var="grsAssetLibraryUrl">
	<portlet:param name="key" value="${key}"/>
</liferay-portlet:renderURL>
<div class=" wrap maincontent">
<div class="layout-100-8020">
			<div class="col-100">
						<div class="changeNetworkHeader ">
						<form name="asset_library_search" id="asset_library_search" action="${grsAssetLibraryUrl}" method="get" onsubmit="return validateForm()">
							<h1>Asset Library/Toolkit</h1>
							
		                    <div class="search-container toollanding">
                    		<div class="srcmodify-con">
                        		<div class="searcmodify">
                             		<input type="text" placeholder="Enter Keyword(s)" class="keyword search" id="key" name="key" value="${key}" autocomplete="off">
                                  	<!-- <button class="lib_search">Search</button> -->  
	                         	</div>
		                    </div>
								<div class="control-drop">
										<span class="required">${vocabularyOne}</span>
										<span>
											 <select class="customSelect" name="catOne" id="catOne">
											<option id="AllBrands"  value="-1" title="All" >All</option>
											<c:forEach items="${categoryOneList}"  var="category">
												<option value="${category.categoryId}" title="${category.name}"	
													<c:if test="${category.categoryId eq categoryOneId}">selected</c:if>>
													<c:out value="${category.name}" />
												</option>
											</c:forEach>
											</select>
										</span> 
								</div>
								<div class="control-drop">
										<span class="required">${vocabularyTwo}</span>
										<span>
											<select class="customSelect" name="catTwo" id="catTwo">
											<option id="AllBrands"  value="-1" title="All" >All</option>
											<c:forEach items="${categoryTwoList}" varStatus="status" var="category">
												<option value="${category.categoryId}" title="${category.name}"	
													<c:if test="${category.categoryId eq categoryTwoId}">selected</c:if>>
													<c:out value="${category.name}" />
												</option>
											</c:forEach>
											</select>
										</span>
								</div>
								<div class="assetLibSearch">
		                        	<input type="submit" class="pull-right postsearch" value="Search"/>
		                        </div>
    	                 	</div>
    	                 	<div class="library_result">
    	          			<c:if test="${not empty key}">
								<c:if test="${totalCount > 0 }">
									<div class="result_count"><${totalCount}>&nbsp; <liferay-ui:message key="search-sub-heading-results"/> <c:if test="${not empty key }">  '<span>${key}</span>' </c:if></div>
								</c:if>
								<c:if test="${totalCount eq 0 }">
									<div class="result_count"> <0> &nbsp; <liferay-ui:message key="search-sub-heading-results"/> '<span>${key}</span>' </div>
								</c:if>
    	          			</c:if>
		                   
		                   <c:set var="url"  value="<%= ActionUtil.getFullURLByPageName(renderRequest,ApplicationConstants.ASSET_LIBRARY_SEARCH_RESULT) %>"/>
		                   <c:if test="${not empty searchList}">
		                   
	                    	
		                   <div class="list_view">
								<select name="sortValue" id="sortValue" onchange="redirectURL()" class="customSelect">
									<option value="0"><liferay-ui:message key="label.sortBy" /></option>
									<option value="1" ${sortingSelected eq 1?'selected':''}><liferay-ui:message key="label.modified" /></option>
									<option value="2" ${sortingSelected eq 2?'selected':''}><liferay-ui:message key="label.a-z" /></option>
									<option value="3" ${sortingSelected eq 3?'selected':''}><liferay-ui:message key="label.z-a" /></option>
								</select>
							</div>
							
		                   <div class="search_result">
							  
							  <c:forEach items="${searchList}" var="assetLibraryBean" varStatus="">
							  	<ul class="search_list">
							    <li>
							      <div class="search_left">
							        <img src="/grs-theme/images/document-img/document.png">
							        
							        <h6>Document</h6>
							      </div>
							      <!--/.search_left--> 
							      <div class="search_right">
							      	<a href="${assetLibraryBean.downloadLink}"><h3>${assetLibraryBean.heading}</h3></a> 
							        <p><c:out value="${fn:substring(assetLibraryBean.description,0,200)}"/><c:if test="${fn:length(assetLibraryBean.description) ge 200}">...</c:if></p>
							        <p>${assetLibraryBean.createdDate}</p>
							  		<div class="bottomLinksearch">
										<button class="dwnbtncon" type="button" onclick="window.location='${assetLibraryBean.downloadLink}'" ><span class="dwnicn"></span>Download</button>
							            <button class="sharebtncon" type="button" onclick="clearFormValues('${assetLibraryBean.downloadLink}','${assetLibraryBean.heading}','${assetLibraryBean.description}')" data-toggle="modal" data-target="#myModal"><span class="shareicn"></span>Share</button>
								    </div>   
							      </div>
							     
							    </li>
							    </ul>
							  <!--/.search_list-->
							  <div class="clear"></div>
							  
							  <%-- <%@include file="/html/common/share.jsp" %> --%>
							</c:forEach>
							</div>
							
							<%@include file="/html/common/share.jsp" %>
							<%@include file="/html/common/pagination.jsp" %>
							 </c:if>
							 </div>
							</form>
                     	</div>
					</div>
</div>
</div>
							
							
<script type="text/javascript"> 
function validateForm()
{
	var x=document.forms["asset_library_search"]["key"].value;
	if (x==null || x=="" || x=="Enter Keyword(s)"){
		 alert("You must enter some keyword before clicking Search Button");
		return false;
	}else{
		return true;
	} 
}

function redirectURL(){
	var x=document.forms["asset_library_search"]["key"].value;
	if (x==null || x=="" || x=="Enter Keyword(s)"){
		alert("You must enter some keyword before clicking Search Button");
		return false;
	}else{
		 var sortValue =document.forms["asset_library_search"]["sortValue"].value;
		 var url = "${url}?key=" +x+ "&sortValue=" + sortValue;
		 window.location.href = url;
	} 
}



</script>