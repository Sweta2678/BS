<%@include file="../init.jsp"%>
<c:forEach items="${subRegionCountryMap}" var="subRegion" varStatus="rgnIndex">
	<c:if test="${subRegion.key ne 'GC' }">
		<tr>
			<td width="250px" class="ri"><h4>Sub Region: <c:out value="${subRegion.key}"/></h4></td>
		</tr>
	</c:if>
	<c:set var="cntIndex" scope="page" value="1" />
	<c:forEach items="${subRegion.value}" var="country" >
		<c:choose>
			<c:when test="${'Unpublished' eq countryDetailMap[country].flag}">
				<c:set var="cssColor" scope="page" value="ctryNotIncluded show_inline label label-gray"/>
			</c:when>
			<c:when test="${'Not Attributed' eq countryDetailMap[country].flag}">
				<c:set var="cssColor" scope="page" value="ctryNotAttributed show_inline label label-orange"/>
			</c:when>
			<c:otherwise><c:set var="cssColor" scope="page" value="ctryAttributed show_inline label label-success"/></c:otherwise>
		</c:choose>
		<c:if test="${cntIndex % 2 eq 1 }">
			<tr>
			<td width="200px" class="ri"><c:out value='${countryNameList[country]  }' /> </td>
			<td width="200px">
			<c:if test="${not empty countryDetailMap[country] }">
            	<span class="${cssColor}">${countryDetailMap[country].flag}</span>
  				<!-- <span class="ctryNotIncluded show_inline label label-gray">Not Included</span> -->
			</c:if>
			</td>
		</c:if>
		<c:if test="${cntIndex % 2 eq 0 }">
			<td class="ri"><c:out value='${countryNameList[country]  }' /> </td>
			<td width="200px">
			<c:if test="${not empty countryDetailMap[country] }">
	            <span class="${cssColor}">${countryDetailMap[country].flag}</span>
	            <!-- <span class="ctryNotIncluded show_inline label label-gray">Not Included</span> -->
			</c:if>
			</td>
			</tr>
		</c:if>
		<c:set var="cntIndex" scope="page" value="${cntIndex + 1}" />
	</c:forEach>	
</c:forEach>
