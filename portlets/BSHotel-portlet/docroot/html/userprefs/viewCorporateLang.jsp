<%@page import="com.ihg.brandstandards.db.service.StandardsLocaleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="java.util.Locale"%>
<%@include file="/html/userprefs/init.jsp" %>
 <%
 	List<StandardsLocale> arlLanguages = new ArrayList<StandardsLocale>();
 	arlLanguages= new ArrayList((List) request.getAttribute("languages"));
 	String regionName=(String)request.getAttribute("regionName");
 	StandardsLocale english_uk = StandardsLocaleLocalServiceUtil.getStandardsLocale("en_GB");
 	 if(Validator.isNotNull(regionName)  && Validator.isNotNull(english_uk) 
 			 && arlLanguages.size()>0 && regionName.equals("EURO") && arlLanguages.contains(english_uk)){
     	int indexUK=arlLanguages.indexOf(english_uk);
     	//StandardsLocale english_locale=arlLanguages.get(indexUK);
     	arlLanguages.remove(indexUK);
     	arlLanguages.add(0,english_uk); 
     }

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
