 <%@include file="/html/userprefs/init.jsp" %>
 <%
 	List<StandardsLocale> arlLanguages = new ArrayList<StandardsLocale>();
 	arlLanguages= new ArrayList((List) request.getAttribute("languages"));
 %>
 <div class="control-group">
	<label class="control-label" for="access_corp_choose_language"><strong>${language}</strong></label>
	<div class="controls"> 
		<select id="access_corp_choose_language" class="access_corp_choose_language" name="access_corp_choose_language" title="access_corp_choose_language">
       	<% for(StandardsLocale bsLocale: arlLanguages) { %>
       		<option value="<%=bsLocale.getLocaleCode()%>"><%=bsLocale.getLocaleName() %>
       	<% } %>
		</select>
 	</div>
 </div>
