
<%@page import="com.ihg.grs.util.PaginationUtil"%>
<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@include file="/html/init.jsp"%>

<%
String currentURL = themeDisplay.getURLCurrent();
%>

<c:if test="${totalPage gt 1}">

<c:choose>
		<c:when test="${totalPage <= 5 }">
			<c:set var="pageStart" value="1"/>
			<c:set var="pageEnd" value="${totalPage}"/>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test='${pageno-2 > 0 }'>
					<c:set var="pageStart" value="${pageno-2}"/>
				</c:when>
				<c:otherwise>
					<c:set var="pageStart" value="1"/>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test='${pageStart+4 <= totalPage }'>
					<c:set var="pageEnd" value="${pageStart+4}"/>
				</c:when>
				<c:otherwise>
					<c:set var="pageEnd" value="${totalPage}"/>
					<c:choose>
						<c:when test="${(pageEnd - pageStart) < 5  && (pageEnd+1)<=5}">
							<c:set var="pageStart" value="1"/>
						</c:when>
						<c:otherwise>
							<c:set var="pageStart" value="${pageEnd-4}"/>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
 <div class="paginat">
        	<ul class="pagination">
					<c:if test="${pageno != 1}">
						<c:set var="i" value="${pageno - 1 }"/>
	       			   	<li class="pag-first"><a  title="Previous" href='<%=PaginationUtil.addCurrentPageParam(currentURL, pageContext.getAttribute("i"))%>'>&#10094;</a></li>
			    	</c:if>
					<c:forEach begin="${pageStart}" end="${pageEnd}" var="i">
			                <c:choose>
			                    <c:when test="${pageno eq i}">							                       
			                        <li><a  title="Page ${i}" class="active" href='<%=PaginationUtil.addCurrentPageParam(currentURL, pageContext.getAttribute("i"))%>'>${i}</a></li>
			                    </c:when>
			                    <c:otherwise>	
			                     	<li><a  title="Page ${i}" href='<%=PaginationUtil.addCurrentPageParam(currentURL, pageContext.getAttribute("i"))%>'>${i}</a></li>                   
			                    </c:otherwise>
		                	</c:choose>
					</c:forEach>
					<c:if test="${pageno lt totalPage}">
						<c:set var="i" value="${pageno + 1 }"/>
				       	<li class="pag-last"><a  title="Next" href='<%=PaginationUtil.addCurrentPageParam(currentURL, pageContext.getAttribute("i"))%>'>&#10095;</a></li>
				    </c:if>			
            </ul>
        </div>
</c:if>