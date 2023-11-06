<table class="table table-bordered">
<thead>
	<tr class="results_header_bar">
		<td width="15%"><strong>Notification Title</strong></td>
		<td width="7%"><strong>STD ID</strong></td>
		<td width="5%"><strong>Type</strong></td>
		<td width="25%"><strong>Text</strong></td>
		<td width="31%"><strong>Notification Description</strong></td>
		<td width="12%"><strong>Created Date</strong></td>
		<c:if test="${(((currentPage eq 'Progress') && (selectedRegion eq 'GLBL')) || (currentPage eq 'Summary'))}">
			<td width="5%"><strong>Acknowledge</strong></td>
		</c:if>
	</tr>
</thead>
<liferay-ui:search-container hover="false" searchContainer="${searchContainer}">
	<liferay-ui:search-container-results>
	<%
		stdCount = 0;
		specCount = 0;
		gdlnCount = 0;
		pageContext.setAttribute("results", searchContainer.getResults());
	    pageContext.setAttribute("total", searchContainer.getTotal() );
	    currPage = searchContainer.getCur();
	%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="com.ihg.brandstandards.custom.model.Standard" keyProperty="stdId" modelVar="standards">
	<%	
		if(!standardIds.toString().isEmpty()){
			standardIds.append(StringPool.COMMA);
		}
		standardIds.append(standards.getTaxonomyId());
		
		if("STD".equals(standards.getStdType())){
			stdCount = stdCount + 1;
		} else if("SPEC".equals(standards.getStdType())){
			specCount = specCount + 1;
		} else if("GDLN".equals(standards.getStdType())){
			gdlnCount = gdlnCount + 1;
		}
	%>
	<tr id="notifRow${standards.taxonomyId}">
		<c:choose>
    		<c:when test="${currentPage eq 'Progress'}">
    			<td><span class="label label-warning">${standards.taxonomyText}</span></td>
    		</c:when>
    		<c:otherwise>
				<td><span class="label label-important">${standards.taxonomyText}</span></td>
			</c:otherwise>
		</c:choose>
		<td><span class="wrap_field">${standards.stdId}</span></td>
		<td><span class="wrap_field">${standards.stdType}</span></td>
		<td><span class="wrap_field">${standards.title}</span></td>
		<td><span class="wrap_field">${standards.taxonomyDesc}</span></td>
		<td><span class="wrap_field">${standards.complDateStr}</span></td>
		<c:if test="${(((currentPage eq 'Progress') && (selectedRegion eq 'GLBL')) || (currentPage eq 'Summary'))}">
			<td style="text-align:center;" id="notif${standards.taxonomyId}">
				<a class="edit_link" href="javascript: void(0)" title="Acknowledge" onclick="acknowledgeNotification('${standards.taxonomyId}')">
					<img src="/BSTheme-theme/images/red_x.jpg" alt="Manage Translations" class="log_icon">
				</a>
			</td>
		</c:if>
	</tr>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
</table>