<%@include file="/html/mustPublish/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.ihg.brandstandards.bridge.model.BridgePublishAppModel"%>
<c:if test="${empty messageText }">
	<div class="row-fluid">
		<div class="span10">
			<h4>Search Results:</h4>
		</div>
	</div>
	<div class="row-fluid">
	     <div class="span10">
	       <table border="0" class="table table-bordered specs table-striped">
	         <tbody id="searchResult">
	         	<c:forEach items="${stdList}" var="std">
                    <% BridgePublishAppModel std = (BridgePublishAppModel)pageContext.getAttribute("std"); %>
					<tr>
						<td colspan="2">
							<input type="hidden" value='<%= HtmlUtil.escape(std.getTitle()) %>#-#${std.stdId}#-#${std.stdType}' id="${std.stdId}" name="${std.stdId}" />
							<strong>${std.title} [${std.stdId}] </strong>
						</td>
						<td width="80px" class="cen">
							<c:choose>
								<c:when test="${isMust}">
									<input id="parent${std.stdId}" name="isMustPublish" type="checkbox" value="${std.stdId}" 
										<c:choose><c:when test='${std.regionCode ne "-1"}'>disabled="" checked=""</c:when><c:otherwise>onclick="childCheckUnCheck('${std.stdId}')";</c:otherwise></c:choose> >
								</c:when>
								<c:otherwise>
									<input id="parent${std.stdId}" name="isMustPublish" type="checkbox" value="${std.stdId}" disabled="true">
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<c:forEach items="${std.specifications}" var="specStd">
                        <% BridgePublishAppModel specStd = (BridgePublishAppModel)pageContext.getAttribute("specStd"); %>
						<tr>
							<td class="bull">&#8226;</td>
							<td>
								<input type="hidden" value='<%= HtmlUtil.escape(specStd.getTitle()) %>#-#${specStd.stdId}#-#${specStd.stdType}' id="${specStd.stdId}" name="${specStd.stdId}" />
								${specStd.title} [${specStd.stdId}]
							</td>
							<td class="cen">
								<c:choose>
								<c:when test="${isMust}">
									<input id="child${std.stdId}" name="isMustPublish"  type="checkbox" value="${specStd.stdId}" 
										<c:choose><c:when test='${specStd.regionCode ne "-1"}'>disabled="" checked=""</c:when><c:otherwise>onclick="parentCheckUnCheck('${std.stdId}')";</c:otherwise></c:choose>>
								</c:when>
								<c:otherwise>
									<input id="child${std.stdId}" name="isMustPublish"  type="checkbox" value="${specStd.stdId}" <c:if test='${specStd.regionCode ne "-1"}'>disabled="" checked=""</c:if>>
								</c:otherwise>
							</c:choose>
							</td>
						</tr>
					</c:forEach>
					<c:forEach items="${std.guidelines}" var="gndlStd">
                        <% BridgePublishAppModel gndlStd = (BridgePublishAppModel)pageContext.getAttribute("gndlStd"); %>
						<tr>
							<td class="bull">&#8226;</td>
							<td>
								<input type="hidden" value='<%= HtmlUtil.escape(gndlStd.getTitle()) %>#-#${gndlStd.stdId}#-#${gndlStd.stdType}' id="${gndlStd.stdId}" name="${gndlStd.stdId}" />
								${gndlStd.title} [${gndlStd.stdId}]
							</td>
							<td class="cen">
								<c:choose>
								<c:when test="${isMust}">
									<input id="child${std.stdId}" name="isMustPublish" type="checkbox" value="${gndlStd.stdId}" 
										<c:choose><c:when test='${gndlStd.regionCode ne "-1"}'>disabled="" checked=""</c:when><c:otherwise>onclick="parentCheckUnCheck('${std.stdId}')";</c:otherwise></c:choose>>
								</c:when>
								<c:otherwise>
									<input id="child${std.stdId}" name="isMustPublish" type="checkbox" value="${gndlStd.stdId}" <c:if test='${gndlStd.regionCode ne "-1"}'>disabled="" checked=""</c:if>>
								</c:otherwise>
							</c:choose>
							</td>
						</tr>
					</c:forEach>
				</c:forEach>
	         </tbody>
	         <tfoot>
	           <tr><td colspan="2"></td><td class="cen"><button type="button" class="btn btn-small btn-primary" onclick="additems();">Add Items</button></td></tr>
	         </tfoot>
	       </table>
	     </div>
	</div>
	<div class="row-fluid">
		<div class="span10">
			<h4>Items to be added:</h4>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span10">
			<table border="0" class="table table-bordered specs table-striped">
				<thead>
					<tr>
						<th width="60px">STD ID</th>
						<th width="60px">Type</th>
						<th>Content</th>
						<th width="50px"></th>
					</tr>
				</thead>
				<tbody id="selectedItems">
					 <!-- Search result selected item will be added here -->
				</tbody>
			</table>
		</div>
	</div>
</c:if>

<div class="ajax-msg-text" style="display: none">
	<c:if test="${not empty messageText }">
		 <div class="span10">
			<div class="alert alert-warnin">${messageText }</div>
		</div> 
	</c:if>
</div>      