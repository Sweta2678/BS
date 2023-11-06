<div class="span9 form-inline">
	<label>${itemsPerPage}:</label>
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
	<label>&nbsp;|&nbsp;${page}:</label>
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
    <span> ${ofLabel}&nbsp; <%=noOfPages %></span>
    <span>&nbsp;|&nbsp;</span>
   	<% if(pageNumber != 1) { %>
   		<a href="#" onclick="submitPagination('links', 1)">
   			<i class="icon-step-backward"></i>${first}
   		</a>
   	<% } else { %>
   		<i class="icon-step-backward"></i>${first}
   	<% } %>
    <span>&nbsp;|&nbsp;</span>
   	<% if(pageNumber != 1) { %>
   		<a href="#" onclick="submitPagination('links', <%=previousPage%>)">
   			<i class="icon-chevron-left"></i>${previous}
   		</a>
   	<% } else { %>
   		<i class="icon-chevron-left"></i>${previous}
   	<% } %>
    <span>&nbsp;|&nbsp;</span>
    <% if(pageNumber != noOfPages) { %>
    	<a href="#" onclick="submitPagination('links', <%=nextPage%>)">
    		<i class="icon-chevron-right"></i>&nbsp;${next}
    	</a>
    <% } else { %>
    <i class="icon-chevron-right"></i>&nbsp;${next}
    <% } %>
    <span>&nbsp;|&nbsp;</span>
    <% if(pageNumber != noOfPages) { %>
    	<a href="#" onclick="submitPagination('links', <%=noOfPages%>)">
    		<i class="icon-step-forward"></i>&nbsp;${last}
    	</a>
    <% } else { %>
    	<i class="icon-step-forward"></i>&nbsp;${last}
    <% } %>
</div>