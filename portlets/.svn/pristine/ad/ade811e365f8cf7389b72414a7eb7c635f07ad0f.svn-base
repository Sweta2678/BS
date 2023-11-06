<%@include file="/html/glossary/init.jsp" %>

<script type="text/javascript" src="/BSTheme-theme/js/jquery.tablednd.1.0.3.min.js"></script>
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/manageTranslations.css" />
<script language="JavaScript">
	var successMessage = '<%=GlossaryUtil.TRANSLATION_SUCCESS_MESSAGE%>';
</script>
<c:choose>
<c:when test ="${!notLoggedIn}">
	<portlet:resourceURL var="SaveTranslation" id="SaveTranslation" />
	<portlet:resourceURL var="RefreshTranslation" id="RefreshTranslation">
		<portlet:param name='<%=GlossaryUtil.REQUEST_PARAM_GLOSSARY_ID%>' value="${TranslationsView.glossary.glossaryId}"></portlet:param>
	</portlet:resourceURL>
    <c:set var="defaultLang" value="<%=StandardsUtil.DEFAULT_LOCALE%>" />
	<c:choose>
	<c:when test = "${TranslationsView!=null && TranslationsView.glossary!=null}">
		<script src="/BSTheme-theme/js/glossaryTranslation.js"></script>

		<div class="grid_12">
		
			<div class="rounded_container">
		
				<div class="rounded_container_contents">
		
					<h4 class="short_page_subtitle">Glossary Translations</h4>
					
		            <div class="clear"></div>
		            <div class="divider">&nbsp;</div>
		            <div class="clear"></div>
		
					<p class="manage_trans_default"> <b><span class="translation_title">English (UK) Term:</span></b> <c:out value="${TranslationsView.glossary.glossaryTermText}" /></p>
					<p class="manage_trans_default"> <b><span class="translation_title">English (UK) Definition:</span></b> <c:out value="${TranslationsView.glossary.glossaryTermDesc}" /></p>
					
					<form id="transForm" method="post" action="<%=SaveTranslation%>">
					<input type="hidden" id="glossaryId" name="glossaryId" value='<c:out value="${TranslationsView.glossary.glossaryId}"/>' />
					<input type="hidden" id="locale" name="locale" value="" />
					<div>
						<table class="translation_table">
							<tr class="translation_table_header">
								<td></td>
								<td class="translation_table_header">Term</td>
								<td class="translation_table_header">Definition</td>
								<td class="table_center"><a href="" class="refresh_translation">
									<img src="/BSTheme-theme/images/refresh_color.png" class="refresh_color" />Refresh</a>
								</td>
							</tr>
							<c:forEach var="glossaryTranslations" items="${TranslationsView.glossaryTranslations}" >
								<c:if test = "${glossaryTranslations.key.localeCode!=defaultLang}">
							
							<tr>
								<td><c:out value="${glossaryTranslations.key.localeName}" /></td>
								<td class="table_center">
								 	<c:choose>
								 	<c:when test = "${glossaryTranslations.value!=null &&  glossaryTranslations.value.isValidTermTxt=='Y'}" >
										<img src="/BSTheme-theme/images/green_arrow.jpg" class="translation_green" />
									</c:when>
									<c:otherwise>
										<img src="/BSTheme-theme/images/red_x.jpg" class="translation_green" />
									</c:otherwise>
									</c:choose>
								</td>
								<td class="table_center">
									<c:choose>
									<c:when test = "${glossaryTranslations.value!=null && glossaryTranslations.value.isValidDescTxt=='Y'}">
										<img src="/BSTheme-theme/images/green_arrow.jpg" class="translation_green" />
									</c:when>
									<c:otherwise>
										<img src="/BSTheme-theme/images/red_x.jpg" class="translation_green" />
									</c:otherwise>
									</c:choose>
								</td>
								<td class="table_center">
									<a class="edit_translation" id="LangName" href="">
										<img src="/BSTheme-theme/images/plus_color.png" class="refresh_color" /> Edit Translation
									</a>
								</td>
							</tr>
							<tr class="table_hidden_row">
								<td colspan="4">
										<div class="hidden_translation_cont">
											<p class="hidden_trans_label"><c:out value="${glossaryTranslations.key.localeName}" /> Term</p>
											<textarea maxlength="255" id='<c:out value="${glossaryTranslations.key.localeCode}"/>Term' name='<c:out value="${glossaryTranslations.key.localeCode}" />Term' class="trans_text required"><c:choose><c:when test="${glossaryTranslations.value!=null && glossaryTranslations.value.glossaryTermText!=null}"><c:out value="${glossaryTranslations.value.glossaryTermText}"/></c:when><c:otherwise></c:otherwise></c:choose></textarea>
											<p class="hidden_trans_label"><c:out value="${glossaryTranslations.key.localeName}"/> Definition</p>
											<textarea maxlength="4000" id='<c:out value="${glossaryTranslations.key.localeCode}"/>Definition' name='<c:out value="${glossaryTranslations.key.localeCode}"/>Definition' class="trans_text required"><c:choose><c:when test="${glossaryTranslations.value!=null && glossaryTranslations.value.glossaryTermDesc!=null}"><c:out value="${glossaryTranslations.value.glossaryTermDesc}"/></c:when><c:otherwise></c:otherwise></c:choose></textarea>
											<div class="button tr_save_btn">
												<a href="#"
													onclick="submitTranslation('<c:out value="${glossaryTranslations.key.localeCode}"/>')"
													class="tr_save">Save</a><span></span>
											</div>
											<div class="button tr_cancel_btn">
												<a href="#" class="tr_cancel">Cancel</a><span></span>
											</div>
										</div> 
								</td>
							</tr>
							</c:if> 
							</c:forEach>
						</table>
					</div>
				</form>
				<input type="button" value="Back To Glossary" title="Back" onclick="location.href='/web/brand-standards/glossary?visibleChar=${visibleChar}'" />
				</div>
			</div>
			<div class="rounded_container_bottom">&nbsp;</div>
		</div>
		<div class="clear"></div>

	</c:when>
	<c:otherwise>
		<c:out value="${errorMessage}" />
	</c:otherwise>
   </c:choose>
</c:when>
<c:otherwise>
	Not logged in !!
</c:otherwise>
</c:choose>