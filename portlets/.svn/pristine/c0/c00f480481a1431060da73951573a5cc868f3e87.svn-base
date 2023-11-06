<%@include file="../init.jsp"%>
<%-- <tr><td width="200px" class="ri"></td><td  ></td><td width="200px" class="ri">All Countries: </td><td  ><c:if test="${not empty countryDetailMap}"><input type="checkbox" name="allCountry" id="allCountry"></c:if></td></tr> --%>
<c:forEach items="${subRegionCountryMap}" var="subRegion" varStatus="rgnIndex">
		<c:if test="${subRegion.key ne 'GC' }">
			<tr>
				<td width="250px" class="ri"><h4>Sub Region: <c:out value="${subRegion.key}"/></h4></td>
				<%-- <td  width="200px"><c:if test="${not empty countryDetailMap}"><input type="checkbox" name="region${rgnIndex.count}" id="region${rgnIndex.count}" class="region${rgnIndex.count}"  ></c:if></td> --%>
			</tr>
		</c:if>
		<c:set var="cntIndex" scope="page" value="1" />
		<c:forEach items="${subRegion.value}" var="country" >
			<c:if test="${cntIndex % 2 eq 1 }">
				<tr>
				<td width="200px" class="ri"><c:out value='${countryNameList[country]  }' /> </td>
				<td width="200px">
				<c:choose>
					<c:when test="${not empty countryDetailMap[country] }">
	                    <c:choose>
	                        <c:when test="${'Y' eq countryDetailMap[country].flag }">
	                            <input type="checkbox" name="country" disabled class="country${rgnIndex.count}" id="country" value="${country}" checked>&nbsp;
	                            <span class="ctryAttributed show_inline label label-success">Attributed</span>
	                        </c:when>
	                        <c:when test="${'N' eq countryDetailMap[country].flag }">
	                            <input type="checkbox" name="country" disabled class="country${rgnIndex.count}" id="country" value="${country}">&nbsp;
	                            <span class="ctryNotIncluded show_inline label label-gray">Not Included</span>
	                        </c:when>
	                    </c:choose>
					</c:when>
				<c:otherwise>
					<input type="checkbox" name="country" disabled class="country${rgnIndex.count}" id="country" value="${country}">&nbsp;
	                <span class="ctryNotIncluded show_inline label label-gray">Not Included</span>
				</c:otherwise>
				</c:choose>
				</td>
			</c:if>
			<c:if test="${cntIndex % 2 eq 0 }">
				<td class="ri"><c:out value='${countryNameList[country]  }' /> </td>
				<td >
				<c:choose>
					<c:when test="${not empty countryDetailMap[country] }">
		                <c:choose>
		                    <c:when test="${'Y' eq countryDetailMap[country].flag }">
		                        <input type="checkbox" name="country" disabled class="country${rgnIndex.count}" id="country" value="${country}" checked>&nbsp;
		                        <span class="ctryAttributed show_inline label label-success">Attributed</span>
		                    </c:when>
		                    <c:when test="${'N' eq countryDetailMap[country].flag }">
		                        <input type="checkbox" name="country" disabled class="country${rgnIndex.count}" id="country" value="${country}">&nbsp;
		                        <span class="ctryNotIncluded show_inline label label-gray">Not Included</span>
		                    </c:when>
		                </c:choose>
					</c:when>
					<c:otherwise>
						<input type="checkbox" name="country" disabled class="country${rgnIndex.count}" id="country" value="${country}">&nbsp;
	                    <span class="ctryNotIncluded show_inline label label-gray">Not Included</span>
					</c:otherwise>
				</c:choose>
				</td>
				</tr>
			</c:if>
			<c:set var="cntIndex" scope="page" value="${cntIndex + 1}" />
		</c:forEach>
		
</c:forEach>
<script type="text/javascript">
var publishId = '${bridgeGblPubId}';
var regionCode = '${regionCode}';
$('#bridgeGlobalPublishId').val(publishId); //will put value in popup hidden field
$('#regionCode').val(regionCode);
selectSubRegion();
</script>
