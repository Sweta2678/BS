<%@page import="java.util.HashMap"%>
<%@include file="/html/init.jsp"%>


<div id="translationExecOverrideDiv">
		<div class="trans_exec_override_div" style="width:auto;">
			
			<span id="translationExecOverrideTitle" class="translation_exec_override_txt">Measurement Translation Selection</span>
       </div>
    </div>
<div id="languageSelection">
	<div class="well well-small">
		<table style="width: 100%">
			<tbody>
				<tr>
					<c:forEach var="langOpt" items="${activeSecondLanguages}" varStatus="counter">
						<%
							Map<String, String> selectedGemLangs = new HashMap<String, String>();
								String checked = "";
								String disabled="";
								if (request.getAttribute("selectedGemLangs") != null)
								{
									selectedGemLangs = (Map<String, String>) request.getAttribute("selectedGemLangs");
								}
								Map<String, String> selectedBrdgRgnLangs = new HashMap<String, String>();
								if (request.getAttribute("selectedBrdgRgnLangs") != null)
								{
									selectedBrdgRgnLangs = (Map<String, String>) request.getAttribute("selectedBrdgRgnLangs");
								}
								Map.Entry<String, String> langOpt = (Map.Entry<String, String>) pageContext.getAttribute("langOpt");
								if (selectedBrdgRgnLangs != null && selectedBrdgRgnLangs.get(langOpt.getKey()) != null)
								{
									if (selectedGemLangs != null && selectedGemLangs.get(langOpt.getKey()) != null)
									{
										checked = "checked=\"checked\"";
									}
								}else
								{
									disabled = "disabled";
								}
						%>
					<c:if test="${counter.count gt 0 && (counter.count % 5) == 1}">
					</tr><tr>
						</c:if>
					<td><label class="checkbox"> <input type="checkbox"
							name="${langOpt.key}" id="${langOpt.key}" <%=checked %>  <%=disabled %>
							onChange="updateLanguageSelection('${langOpt.key}',this)">
							${langOpt.value}
					</label></td>
					</c:forEach>
				</tr>
			</tbody>
		</table>
	</div>
</div>





