<%@include file="/html/init.jsp" %>
<%@page import="com.ihg.brandstandards.util.BrandStandardsUtil"%>
<%@page import="com.ihg.brandstandards.db.model.AttachmentsStandards"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsImages"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsLocale"%>
<%@page import="com.ihg.brandstandards.db.model.ExternalLinkStandards"%>
<%@page import="com.ihg.brandstandards.util.TranslationsUtil"%>
<%@page import="com.ihg.brandstandards.util.StandardsUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.ihg.brandstandards.bsadmin.model.TranslationsView"%>
<portlet:resourceURL var="saveTranslation" id="saveTranslation">
	<portlet:param name="urlQuery" value="${urlQuery}"></portlet:param>
</portlet:resourceURL>

<script type="text/javascript" src="/BSTheme-theme/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.nyroModal.custom.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery-ui-1.10.1.custom.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.blockUI.js"></script>
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/other/jquery-ui-1.10.1/themes/base/jquery.ui.all.css"/>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.validate.min-1.11.0.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.form.3.28.0.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.msgBox.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.tablednd.min.js"></script>
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/msgBoxLight.css" />
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/bsstyle.css" />
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/manageTranslations.css" />

<%
    TranslationsView transView = (TranslationsView) request.getAttribute("transView");
    StandardsLocale selectedLanguage = null;
    String objType = TranslationsUtil.getDisplayText(transView.getStandard().getStdTyp());
%>
<portlet:resourceURL var="refreshTranslationView" id="refreshTranslationView">
	<portlet:param name="standardsId" value="<%= String.valueOf(transView.getStandard().getStdId()) %>"></portlet:param>
	<portlet:param name="urlQuery" value="${urlQuery}"></portlet:param>
</portlet:resourceURL>
<script type="text/javascript">
var refreshUrl = '<%= refreshTranslationView.toString() %>';
var stdId = <%=transView.getStandard().getStdId()%>;
var regionCode ="-1";
var stdType = "<%= transView.getStandard().getStdTyp() %>";
if(stdId>0) {
	regionCode = "<%=transView.getRegionCode()%>";
}
var transmodified = false;
</script>
<script
	src="/BSTheme-theme/js/manageTranslations.js"></script>

<div class="grid_12">

	<div class="rounded_container">

		<div class="rounded_container_contents">

			<h4>Manage Translation</h4>


			<div style="padding-left:30px">
			    <br/>
				<p class="manage_trans_default">
					<b><span id="stdTypeHelperText"><%= objType %> Text:</span></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<c:choose><c:when test="<%= !BrandStandardsUtil.STD_TYPE_GDLN.equals(transView.getStandard().getStdTyp()) %>" ><%=transView.getStandard().getTitle()%></c:when><c:otherwise><%=transView.getStandard().getDescription() %></c:otherwise></c:choose>
				</p>
				
				<p class="manage_trans_default">
					<b><span id="stdTypeHelperID">&nbsp;&nbsp;&nbsp;&nbsp;<%= objType %> ID:</span></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=transView.getStandard().getStdId()%>
				</p>
				
				<br />
				<p  style="font-style: italic;">English (UK) Text </p>
				<c:choose> 
					<c:when test="<%= !BrandStandardsUtil.STD_TYPE_GDLN.equals(transView.getStandard().getStdTyp()) %>" ><%=transView.getStandard().getTitle()%></c:when>
					<c:otherwise><%=transView.getStandard().getDescription() %></c:otherwise> 
				</c:choose>
				<c:if test="<%= !BrandStandardsUtil.STD_TYPE_GDLN.equals(transView.getStandard().getStdTyp()) %>" >
				<br /><br />
				<p style="font-style: italic;" >English(UK) Context</p>
				<%=transView.getStandard().getDescription()%> <br />
				</c:if>
			</div>
			
			<form id="transForm" method="post" enctype="multipart/form-data" action="<%= saveTranslation %>">
			<!--  hidden required inputs start -->
			<input name="standardsId" id="standardsId" type="hidden" />
			
			<input name="langId" id="langId" type="hidden" />
			<input name="transTitle" id="transTitle" type="hidden" />
			<input name="stdContext" id="stdContext" type="hidden" />
			<input name="transComment" id="transComment" type="hidden" />
			<input name="parents" id="parents" type="hidden" />
			<input name="transUrls" id="transUrls" type="hidden" />
			<input name="transTitles" id="transTitles" type="hidden" />
			<input name="deletedTransLinks" id="deletedTransLinks" type="hidden" />
			<input name="noneChecked" id="noneChecked" type="hidden" />
			<input name="noneUnChecked" id="noneUnChecked" type="hidden" />
			<input name="parentStdImages" id="parentStdImages" type="hidden" />
			<input name="translatedImages" id="translatedImages" type="hidden" />
			<input name="translatedImagesTitle" id="translatedImagesTitle" type="hidden" />
			<input name="imageDefaultChecked" id="imageDefaultChecked" type="hidden" />
			<input name="imageDefaultUnchecked" id="imageDefaultUnchecked" type="hidden" />
			<input name="defaultLocaleCode" id="defaultLocaleCode" type="hidden" value="${transView.defaultLocale.localeCode}" />
			<input name="newAttachAdded" id="newAttachAdded" type="hidden" />
			<input name="deletedAttachments" id="deletedAttachments" type="hidden" />
			<input name="noneAttachCheck" id="noneAttachCheck" type="hidden" />
			<input name="noneAttachUnCheck" id="noneAttachUnCheck" type="hidden" />
			<input name="newAttachmentsNames" id="newAttachmentsNames" type="hidden" />
			
			<!--  hidden required inputs end -->
			<div>


				<table class="translation_table">
					<tr class="translation_table_header">
						<td></td>
						<td class="translation_table_header">Text</td>
						<c:if test="<%= !BrandStandardsUtil.STD_TYPE_GDLN.equals(transView.getStandard().getStdTyp()) %>" ><td class="translation_table_header">Context</td></c:if>
						<td class="translation_table_header">Images</td>
						<td class="translation_table_header">Attachments</td>
						<td class="translation_table_header">Links</td>
						<td class="table_center"><a href=""
							class="refresh_translation"><img
								src="/BSTheme-theme/images/refresh_color.png"
								class="refresh_color" />Refresh</a></td>
					</tr>
					<tr>
						<c:forEach items="<%=transView.getLanguages()%>" var="language">
							<%
							    selectedLanguage = (StandardsLocale) pageContext.getAttribute("language");
							%>
							<tr>
								<td><c:out value="${language.localeName}" /></td>
								<c:if test="<%= !BrandStandardsUtil.STD_TYPE_GDLN.equals(transView.getStandard().getStdTyp()) %>" ><td class="table_center"><c:choose>
										<c:when
											test="<%=TranslationsUtil.isTranslationAvailable(
                                ((StandardsLocale) pageContext.getAttribute(\"language\")).getLocaleCode(), transView.getStandard()
                                        .getStdId(), TranslationsUtil.FIELD_TEXT, transView)%>">
											<img
												src="/BSTheme-theme/images/green_arrow.jpg"
												class="translation_green" />
										</c:when>
										<c:otherwise>
											<img
												src="/BSTheme-theme/images/red_x.jpg"
												class="translation_green" />
										</c:otherwise>
									</c:choose></td></c:if>
								<td class="table_center"><c:choose>
										<c:when
											test="<%=TranslationsUtil.isTranslationAvailable(
                                ((StandardsLocale) pageContext.getAttribute(\"language\")).getLocaleCode(), transView.getStandard()
                                        .getStdId(), TranslationsUtil.FIELD_CONTEXT, transView)%>">
											<img
												src="/BSTheme-theme/images/green_arrow.jpg"
												class="translation_green" />
										</c:when>
										<c:otherwise>
											<img
												src="/BSTheme-theme/images/red_x.jpg"
												class="translation_green" />
										</c:otherwise>
										</c:choose></td>
								<td class="table_center"><c:choose>
										<c:when
											test="<%=TranslationsUtil.isTranslationAvailable(
                                ((StandardsLocale) pageContext.getAttribute(\"language\")).getLocaleCode(), transView.getStandard()
                                        .getStdId(), TranslationsUtil.FIELD_IMAGES, transView)%>">
											<img src="/BSTheme-theme/images/green_arrow.jpg"
												class="translation_green" />
										</c:when>
										<c:otherwise>
											<img
												src="/BSTheme-theme/images/red_x.jpg"
												class="translation_green" />
										</c:otherwise>
									</c:choose></td>
								<td class="table_center"><c:choose>
										<c:when
											test="<%=TranslationsUtil.isTranslationAvailable(
                                ((StandardsLocale) pageContext.getAttribute(\"language\")).getLocaleCode(), transView.getStandard()
                                        .getStdId(), TranslationsUtil.FIELD_ATTACH, transView)%>">
											<img
												src="/BSTheme-theme/images/green_arrow.jpg"
												class="translation_green" />
										</c:when>
										<c:otherwise>
											<img
												src="/BSTheme-theme/images/red_x.jpg"
												class="translation_green" />
										</c:otherwise>
									</c:choose></td>
								<td class="table_center"><c:choose>
										<c:when
											test="<%=TranslationsUtil.isTranslationAvailable(
                                ((StandardsLocale) pageContext.getAttribute(\"language\")).getLocaleCode(), transView.getStandard()
                                        .getStdId(), TranslationsUtil.FIELD_LINKS, transView)%>">
											<img
												src="/BSTheme-theme/images/green_arrow.jpg"
												class="translation_green" />
										</c:when>
										<c:otherwise>
											<img
												src="/BSTheme-theme/images/red_x.jpg"
												class="translation_green" />
										</c:otherwise>
									</c:choose></td>
								<td class="table_center"><a href=""
									class="edit_translation" id="${language.localeCode}--editTrans"><img
										src="/BSTheme-theme/images/plus_color.png"
										class="refresh_color" /> Edit Translation</a></td>
							</tr>
							<tr class="table_hidden_row">
								<td colspan="7">
									<div class="hidden_translation_cont">
										<c:if test="<%= !BrandStandardsUtil.STD_TYPE_GDLN.equals(transView.getStandard().getStdTyp()) %>" >
										<p class="hidden_trans_label">${language.localeName} Text</p>
										<textarea maxlength="1000"
											id="${language.localeCode}translationTitle"
											name="${language.localeCode}translationTitle"
											class="trans_text"><%=transView.getStdTranslates().get(selectedLanguage.getLocaleCode()) != null ? StandardsUtil.getValueOrBlank(transView.getStdTranslates().get(selectedLanguage.getLocaleCode()).getTitle()): StringPool.BLANK%></textarea>
										</c:if>
										<p class="hidden_trans_label">${language.localeName}
											<c:choose> <c:when test="<%= !BrandStandardsUtil.STD_TYPE_GDLN.equals(transView.getStandard().getStdTyp()) %>" > &nbsp;Context</c:when><c:otherwise>&nbsp;Text</c:otherwise> </c:choose></p>
										<textarea maxlength="4000"
											id="${language.localeCode}translationContext"
											name="${language.localeCode}translationContext"
											class="trans_text"><%=transView.getStdTranslates().get(selectedLanguage.getLocaleCode()) != null ? StandardsUtil.getValueOrBlank(transView.getStdTranslates().get(selectedLanguage.getLocaleCode()).getDescription()): StringPool.BLANK%></textarea>

										<p class="hidden_trans_label">${language.localeName}
											Images</p>
										<div id="${language.localeCode}--imageTranslatorDiv"
											class="hidden_images_cont">

											<c:forEach items="${transView.parentStdImages}"
												var="parentImage">
												<%
												    StandardsImages parentStdImage = (StandardsImages) pageContext.getAttribute("parentImage");
													SimpleDateFormat outputDf = new SimpleDateFormat("d MMM yyyy");
													//User userObj = UserLocalServiceUtil.getUserById(PortalUtil.getCompanyId(request), Long.parseLong(parentStdImage.getDBImage().getCreatorId()));
													User userObj = null;
													String fullName = "Does not exist";
													try {
														userObj = UserLocalServiceUtil.getUserById(PortalUtil.getCompanyId(request), Long.parseLong(parentStdImage.getDBImage().getCreatorId()));
													} catch(Exception e) { }
													if(userObj != null) {
														fullName = userObj.getFullName();
													}
												%>
												<div
													id="<%= parentStdImage.getStdImageId()+"--" %>${language.localeCode}--imageTranslation"
													class="hidden_image_row">
													<div
														id="<%= parentStdImage.getStdImageId()+"--" %>${language.localeCode}--defaultImage"
														class="hidden_images_left">
														<div class="inner_image_container">
															<span style="padding: 10px;"><a
																class="trans_img_link"
																href="/image/image_gallery?uuid=<%=parentStdImage.getDBImage().getImageUuId()%>&groupId=<%=themeDisplay.getScopeGroupId()%>"
																onclick="window.open (this.href, '_blank', 'height = 400, width = 650, resizable = yes'); return false;">
																	<img
																	src="/image/image_gallery?img_id=<%=parentStdImage.getDBImage().getSmallImageId()%>"
																	title="image--<%=parentStdImage.getDBImage().getImageId()%>"
																	alt="image <%=parentStdImage.getDBImage().getSmallImageId()%>"
																	class="trans_img" /> <!--  width="< %=image.getWidth()% >" height="< %=image.getHeight()% >"/> -->
															</a> <!-- <img src="/BSTheme-theme/images/placeholder_hidden_img.jpg" style="padding:10px;" /> -->
																<br />
																<div style="text-align: center;" class="image-title"><%=HtmlUtil.escape(parentStdImage.getDBImage().getImageTitle())%></div>
																<br /> <span class="trans_image_id">ID:&nbsp;<%=parentStdImage.getDBImage().getImageId()%></span><br />
																<span class="trans_image_date">Uploaded :&nbsp;<%=outputDf.format(parentStdImage.getDBImage().getCreatedDate())%>
															</span><br /> <span class="trans_image_author">Author
																	:&nbsp;<%=fullName%><br />
															</span> <span class="trans_image_std_cnt">Standards:&nbsp;<%=TranslationsUtil.getAssociatedImgCount(parentStdImage.getDBImage().getImageId(), "STD")%><br /></span>
																<span class="trans_image_spec_cnt">Specifications:&nbsp;<%=TranslationsUtil.getAssociatedImgCount(parentStdImage.getDBImage().getImageId(), "SPEC")%><br /></span>
																<span class="trans_image_gdln_cnt">Guidelines:&nbsp;<%=TranslationsUtil.getAssociatedImgCount(parentStdImage.getDBImage().getImageId(), "GDLN")%><br /></span>
															</span>
														</div>
													</div>
														<c:if
															test="<%=Validator.isNotNull(TranslationsUtil.getStandardsImageForParent(transView,((StandardsLocale) pageContext.getAttribute(\"language\")).getLocaleCode(),parentStdImage.getStdImageId()))
                                							&& !(TranslationsUtil.getDefaultChecked(transView,((StandardsLocale) pageContext.getAttribute(\"language\")).getLocaleCode(),parentStdImage.getStdImageId()))%>">
															<%
															    StandardsImages transImage = TranslationsUtil.getStandardsImageForParent(transView,((StandardsLocale) pageContext.getAttribute("language")).getLocaleCode(),parentStdImage.getStdImageId());
															%>
															<div
																id="<%= parentStdImage.getStdImageId()+"--" %>${language.localeCode}--defaultImageChild"
																class="hidden_images_left translatedImageContainer">
																<div class="inner_image_container">
																	<span style="padding: 10px;"><a
																		class="trans_img_link"
																		href="/image/image_gallery?uuid=<%=transImage.getDBImage().getImageUuId()%>&groupId=<%=themeDisplay.getScopeGroupId()%>"
																		onclick="window.open (this.href, '_blank', 'height = 400, width = 650, resizable = yes'); return false;">
																			<img
																			src="/image/image_gallery?img_id=<%=transImage.getDBImage().getSmallImageId()%>"
																			title="image--<%=transImage.getDBImage().getImageId()%>"
																			alt="image <%=transImage.getDBImage().getSmallImageId()%>"
																			class="trans_img" /> <!--  width="< %=image.getWidth()% >" height="< %=image.getHeight()% >"/> -->
																	</a> <!-- <img src="/BSTheme-theme/images/placeholder_hidden_img.jpg" style="padding:10px;" /> -->
																		<br />
																		<div style="text-align: center;" class="image-title"><%=HtmlUtil.escape(transImage.getDBImage().getImageTitle())%></div>
																		<br /> <span class="trans_image_id">ID:&nbsp;<%=transImage.getDBImage().getImageId()%></span><br />
																		<span class="trans_image_date">Uploaded :&nbsp;<%=outputDf.format(transImage.getDBImage().getCreatedDate())%>
																	</span><br /> <span class="trans_image_author">Author
																			:&nbsp;<%=fullName%><br />
																	</span> <span class="trans_image_std_cnt">Standards:&nbsp;<%=TranslationsUtil.getAssociatedImgCount(transImage.getDBImage().getImageId(), "STD")%><br /></span>
																		<span class="trans_image_spec_cnt">Specifications:&nbsp;<%=TranslationsUtil.getAssociatedImgCount(transImage.getDBImage().getImageId(), "SPEC")%><br /></span>
																		<span class="trans_image_gdln_cnt">Guidelines:&nbsp;<%=TranslationsUtil.getAssociatedImgCount(transImage.getDBImage().getImageId(), "GDLN")%><br /></span>
																	</span>
																</div>
															</div>
														</c:if>
														<div class="hidden_images_right"
														id="<%= parentStdImage.getStdImageId()+"--" %>${language.localeCode}--select_trans_img_link">
														<c:if
															test="<%=Validator.isNull(TranslationsUtil.getStandardsImageForParent(transView,((StandardsLocale) pageContext.getAttribute(\"language\")).getLocaleCode(),parentStdImage.getStdImageId()))|| TranslationsUtil.getDefaultChecked(transView,((StandardsLocale) pageContext.getAttribute(\"language\")).getLocaleCode(),parentStdImage.getStdImageId())%>">
															<c:choose>

																<c:when
																	test="<%=TranslationsUtil.getDefaultChecked(transView,((StandardsLocale) pageContext.getAttribute(\"language\")).getLocaleCode(),parentStdImage.getStdImageId())%>">
																	<span
																		id="<%= parentStdImage.getStdImageId()+"--" %>${language.localeCode}--use_current_checkboxspan"><input
																		type="checkbox"
																		id="<%= parentStdImage.getStdImageId()+"--" %>${language.localeCode}--use_current_checkbox"
																		class="tr_use_this_1image" value=""
																		name="tr_use_this_1image" checked="checked" /> Use
																		Current Image<br /></span>
																</c:when>
																<c:otherwise>
																	<span
																		id="<%= parentStdImage.getStdImageId()+"--" %>${language.localeCode}--use_current_checkboxspan"><input
																		type="checkbox"
																		id="<%= parentStdImage.getStdImageId()+"--" %>${language.localeCode}--use_current_checkbox"
																		class="tr_use_this_1image" value=""
																		name="tr_use_this_1image" /> Use Current Image<br /></span>
																</c:otherwise>
															</c:choose>
														</c:if>
														<div class="image_translation_link"
															id="<%= parentStdImage.getStdImageId()+"--" %>${language.localeCode}--select_trans_img_div">
															<a href=""
																id="<%= parentStdImage.getStdImageId()+"--" %>${language.localeCode}--select_trans_img_link"
																title="Choose different image link">Choose a
																different image</a><span></span>
														</div>
														<c:if
															test="<%=Validator.isNotNull(TranslationsUtil.getStandardsImageForParent(transView,((StandardsLocale) pageContext.getAttribute(\"language\")).getLocaleCode(),parentStdImage.getStdImageId())) && !(TranslationsUtil.getDefaultChecked(transView,((StandardsLocale) pageContext.getAttribute(\"language\")).getLocaleCode(),parentStdImage.getStdImageId()))%>">
															<div class="image_translation_remove_link"
																id="<%= parentStdImage.getStdImageId()+"--" %>${language.localeCode}--remove_trans_img_div">
																<a href=""
																	id="<%= parentStdImage.getStdImageId()+"--" %>${language.localeCode}--remove_trans_img_link"
																	title="Remove Translated Image">Remove Translated
																	Image</a><span></span>
															</div>
														</c:if>
														<!-- <a href="" id="select_trans_img_link"  title="Choose different image link">Choose a different imagenew</a> -->
													</div>
												</div>
												<div class="clear"></div>
											</c:forEach>
										</div>




										<p class="hidden_trans_label_left">${language.localeName} Attachments</p>
										<div class="hidden_attach">
											<p class="center_help_text">If there is no translation
												for an attachment, please check "none"</p>
											<table class="hidden_attach_table" id="translationAttachTable${language.localeCode}">
												<tr class="tr_hidden_titles">
													<td>Title</td>
													<td>File <a class="help_icon tooltip" href="javascript:return false;" ><img src="/BSTheme-theme/images/help.png" alt="standard help icon"/>
                    	        					<span class="classic">Filename should not contain special characters like &@]}:,=>/<\n[{%|+#?()'\r;*~</span></a> </td>
													<td>Brand</td>
													<td>Language</td>
													<td>Add</td>
													<td>Delete</td>
													<td>None</td>
												</tr>
												<c:forEach var="parentStdAttachment" items="${transView.parentAttachmentStd}">
												<% AttachmentsStandards parentAttachStd = (AttachmentsStandards)pageContext.getAttribute("parentStdAttachment");
												   String attachmentPath = TranslationsUtil.getDownloadablePath(parentAttachStd.getAttachmentPath(), themeDisplay.getScopeGroupId());												
												%>
												<c:choose>
												<c:when test="<%= (TranslationsUtil.getAttachmentTranslation(parentAttachStd, selectedLanguage, transView)==null) || TranslationsUtil.getAttachmentTranslation(parentAttachStd, selectedLanguage, transView).getTranslationIndicator().equals(TranslationsUtil.NOT_APPLICABLE) %>">
												<tr>
													<td>${parentStdAttachment.title}</td>
													<td><a style="cursor: pointer;" href="<%=attachmentPath%>" target="_blank" class="open_hidden_attach">
															<%= parentAttachStd.getAttachmentPath().substring(parentAttachStd.getAttachmentPath().lastIndexOf("/")+1, parentAttachStd.getAttachmentPath().length()) %>
														</a>
													</td>
													<td><p class="tiny_text"><%= transView.getAttachmentsBrandsMapping().get(parentAttachStd.getAttachmentId()) %></p></td>
													<td>${transView.defaultLocale.localeName}</td>
													<td class="align_cell_middle"><a href=""
														class="hidden_add_attach_icon" id="${parentStdAttachment.attachmentId}--${language.localeCode}--addAttachment--${language.localeName}"><img
															src="/BSTheme-theme/images/plus_color.png" /></a></td>
													<td class="align_cell_middle"></td>
													<td class="align_cell_middle">
													<c:choose>
													<c:when test="<%= (TranslationsUtil.getAttachmentTranslation(parentAttachStd, selectedLanguage, transView)!=null) %>">
													<input type="checkbox"
														id="${parentStdAttachment.attachmentId}--${language.localeCode}--noneAttachCheck" class="tr_attach_none attach-none-check" value=""
														name="tr_attach_none_enus" checked="checked" />
													
													</c:when>
													<c:otherwise>
													<input type="checkbox"
														id="${parentStdAttachment.attachmentId}--${language.localeCode}--noneAttachCheck" class="tr_attach_none attach-none-check" value=""
														name="tr_attach_none_enus" />
													</c:otherwise>
													</c:choose>
													</td>
												</tr>
												</c:when>
												<c:otherwise>
												<tr class="attch_connected_row_top">
													<td>${parentStdAttachment.title}</td>
													<td><a style="cursor: pointer;" href="<%=attachmentPath%>" target="_blank" class="open_hidden_attach"><%= parentAttachStd.getAttachmentPath().substring(parentAttachStd.getAttachmentPath().lastIndexOf("/")+1, parentAttachStd.getAttachmentPath().length()) %></a></td>
													<td><p class="tiny_text"><%= transView.getAttachmentsBrandsMapping().get(parentAttachStd.getAttachmentId()) %></p></td>
													<td>${transView.defaultLocale.localeName}</td>
													<td class="align_cell_middle"><a href=""
														class="hidden_add_attach_icon" style="display:none" id="${parentStdAttachment.attachmentId}--${language.localeCode}--addAttachment--${language.localeName}"><img
															src="/BSTheme-theme/images/plus_color.png" /></a></td>
													<td class="align_cell_middle"></td>
													<td class="align_cell_middle"><input type="checkbox"
														id="${parentStdAttachment.attachmentId}--${language.localeCode}--noneAttachCheck" class="tr_attach_none attach-none-check" value=""
														name="tr_attach_none_enus" disabled="disabled" /></td>


												</tr>
												<% AttachmentsStandards translatedAttachment = TranslationsUtil.getAttachmentTranslation(parentAttachStd, selectedLanguage, transView);
												%>
												<tr class="attch_connected_row_btm">
													<td><input
														type="text" maxlength="75" value="<%= translatedAttachment.getTitle() %>"
														name="orig_hidden_title_attch_enus"
														class="orig_hidden_title_attch" readonly="readonly" /></td>
													<td><a style="cursor: pointer;" href="<%=  TranslationsUtil.getDownloadablePath(translatedAttachment.getAttachmentPath(), themeDisplay.getScopeGroupId()) %>" target="_blank" class="open_hidden_attach ${language.localeCode}--attachment"><%= translatedAttachment.getAttachmentPath().substring(translatedAttachment.getAttachmentPath().lastIndexOf("/")+1, translatedAttachment.getAttachmentPath().length()) %><img
															src="/BSTheme-theme/images/change_attach.jpg" /></a></td>
													<td><p class="tiny_text no_change">As original attachment</p></td>
													<td>${language.localeName}</td>
													<td class="align_cell_middle"></td>
													<td class="align_cell_middle"><a href=""
														class="hidden_delete_attachlink_icon" id="${parentStdAttachment.attachmentId}--${language.localeCode}--deleteAttachment"><img
															src="/BSTheme-theme/images/delete.png" /></a></td>
													<td class="align_cell_middle"></td>
												</tr>
												</c:otherwise>
												</c:choose>
												</c:forEach>
											</table>
										</div>

										<p class="hidden_trans_label_left">${language.localeName} Links</p>
										<div class="hidden_attach">
											<p class="center_help_text">If there is no translation
												for a link, please check "none"</p>
											<table class="hidden_attach_table"
												id="translationExtLinks${language.localeCode}">
												<tr class="tr_hidden_titles">
													<td>URL</td>
													<td>Title</td>
													<td>Brand</td>
													<td>Language</td>
													<td>Add</td>
													<td>Delete</td>
													<td>None</td>
												</tr>
												<c:forEach items="${transView.parentStdLinks}" var="parent">
													<c:choose>
														<c:when
															test="<%=transView.getLinkLanguageMapping().get(((ExternalLinkStandards) pageContext.getAttribute(\"parent\")).getExtLinkId()).get(selectedLanguage.getLocaleCode()) != null ? (transView.getLinkLanguageMapping().get(((ExternalLinkStandards) pageContext.getAttribute(\"parent\")).getExtLinkId()).get(selectedLanguage.getLocaleCode()).getTranslationIndicator().equals(TranslationsUtil.NOT_APPLICABLE) ? false : true): false%>">
															<!-- Parent -->
															<tr class="attch_connected_row_top">
																<td>${parent.url}</td>
																<td>${parent.title}</td>
																<td><p class="tiny_text"><%= transView.getExtLinkBrandMapping().get(((ExternalLinkStandards) pageContext.getAttribute("parent")).getExtLinkId()) %></p></td>
																<td>${transView.defaultLocale.localeName}</td>
																<td class="align_cell_middle"><a style="display: none;" href=""
																	id="${parent.extLinkId}--<%= selectedLanguage.getLocaleCode() %>--addExtLink--${language.localeName}"
																	class="hidden_add_link_icon"><img
																		src="/BSTheme-theme/images/plus_color.png" /></a></td>
																<td class="align_cell_middle"></td>
																<td class="align_cell_middle"><c:choose>
																		<c:when
																			test="<%=transView.getLinkLanguageMapping().get(((ExternalLinkStandards) pageContext.getAttribute(\"parent\")).getExtLinkId()).get(selectedLanguage.getLocaleCode()) != null ? transView.getLinkLanguageMapping().get(((ExternalLinkStandards) pageContext.getAttribute(\"parent\")).getExtLinkId()).get(selectedLanguage.getLocaleCode()).getTranslationIndicator().equals(TranslationsUtil.NOT_APPLICABLE) : false%>">
																			<input type="checkbox"
																				class="input-none-checkbox tr_attach_none"
																				id="${parent.extLinkId}--<%= selectedLanguage.getLocaleCode() %>--noTranslation"
																				name="${parent.extLinkId}--<%= selectedLanguage.getLocaleCode() %>noTranslation"
																				checked="checked" disabled="disabled" />
																		</c:when>
																		<c:otherwise>
																			<input type="checkbox"
																				class="input-none-checkbox tr_attach_none"
																				id="${parent.extLinkId}--<%= selectedLanguage.getLocaleCode() %>--noTranslation"
																				name="${parent.extLinkId}--<%= selectedLanguage.getLocaleCode() %>noTranslation"
																				disabled="disabled" />
																		</c:otherwise>
																	</c:choose></td>
															</tr>
															<!-- Child -->
															<tr class="attch_connected_row_btm">
																<td><img
																	src="/BSTheme-theme/images/solo_branch.png" /><span
																	class="${parent.extLinkId}--<%= selectedLanguage.getLocaleCode() %>toggle-helper"><input
																		type="text" class="input-urls orig_hidden_title_attch url" maxlength="2000"
																		id="${parent.extLinkId}--<%= selectedLanguage.getLocaleCode() %>--url"
																		value="<%= transView.getLinkLanguageMapping().get(((ExternalLinkStandards)pageContext.getAttribute("parent")).getExtLinkId()).get(selectedLanguage.getLocaleCode())!=null?transView.getLinkLanguageMapping().get(((ExternalLinkStandards)pageContext.getAttribute("parent")).getExtLinkId()).get(selectedLanguage.getLocaleCode()).getRealUrl():StringPool.BLANK %>">
																</span></td>
																<td><span
																	class="${parent.extLinkId}--<%= selectedLanguage.getLocaleCode() %>toggle-helper"><input
																		type="text"
																		class="input-titles orig_hidden_title_attch required" title="Please enter valid title"
																		id="${parent.extLinkId}--<%= selectedLanguage.getLocaleCode() %>--title" maxlength="500"
																		value="<%= transView.getLinkLanguageMapping().get(((ExternalLinkStandards)pageContext.getAttribute("parent")).getExtLinkId()).get(selectedLanguage.getLocaleCode())!=null?transView.getLinkLanguageMapping().get(((ExternalLinkStandards)pageContext.getAttribute("parent")).getExtLinkId()).get(selectedLanguage.getLocaleCode()).getRealTitle():StringPool.BLANK %>">
																</span></td>
																<td><p class="tiny_text">As original attachment</p></td>
																<td>${language.localeName}</td>
																<td class="align_cell_middle"></td>
																<td class="align_cell_middle"><a href=""
																	id="${parent.extLinkId}--<%= selectedLanguage.getLocaleCode() %>--deleteExtLink"
																	class="hidden_delete_link_icon"><img
																		src="/BSTheme-theme/images/delete.png" /></a></td>
																<td class="align_cell_middle"></td>
															</tr>
														</c:when>
														<c:otherwise>
															<tr>
																<td>${parent.url}</td>
																<td>${parent.title}</td>
																<td><p class="tiny_text"><%= transView.getExtLinkBrandMapping().get(((ExternalLinkStandards) pageContext.getAttribute("parent")).getExtLinkId()) %></p></td>
																<td>${transView.defaultLocale.localeName}</td>
																<td class="align_cell_middle"><a href=""
																	id="${parent.extLinkId}--<%= selectedLanguage.getLocaleCode() %>--addExtLink--${language.localeName}"
																	class="hidden_add_link_icon"><img
																		src="/BSTheme-theme/images/plus_color.png" /></a></td>
																<td class="align_cell_middle"></td>
																<td class="align_cell_middle"><c:choose>
																		<c:when
																			test="<%=transView.getLinkLanguageMapping().get(((ExternalLinkStandards) pageContext.getAttribute(\"parent\")).getExtLinkId()).get(selectedLanguage.getLocaleCode()) != null ? transView.getLinkLanguageMapping().get(((ExternalLinkStandards) pageContext.getAttribute(\"parent\")).getExtLinkId()).get(selectedLanguage.getLocaleCode()).getTranslationIndicator().equals(TranslationsUtil.NOT_APPLICABLE) : false%>">
																			<input type="checkbox"
																				class="input-none-checkbox tr_attach_none"
																				id="${parent.extLinkId}--<%= selectedLanguage.getLocaleCode() %>--noTranslation"
																				name="${parent.extLinkId}--<%= selectedLanguage.getLocaleCode() %>noTranslation"
																				checked="checked" />
																		</c:when>
																		<c:otherwise>
																			<input type="checkbox"
																				class="input-none-checkbox tr_attach_none"
																				id="${parent.extLinkId}--<%= selectedLanguage.getLocaleCode() %>--noTranslation"
																				name="${parent.extLinkId}--<%= selectedLanguage.getLocaleCode() %>noTranslation" />
																		</c:otherwise>
																	</c:choose></td>
															</tr>
														</c:otherwise>
													</c:choose>
												</c:forEach>

											</table>
										</div>





										<p class="hidden_trans_label">Translation Comments</p>
										<textarea id="${language.localeCode}Comment"
											name="${language.localeCode}translationComment"
											title="Please enter a comment" class="trans_text" maxlength="4000"><%=transView.getStdTranslates().get(selectedLanguage.getLocaleCode()) != null ? StandardsUtil.getValueOrBlank(transView.getStdTranslates().get(selectedLanguage.getLocaleCode()).getComment()): StringPool.BLANK%></textarea>
										<div class="button tr_save_btn">
											<a href="#"
												onclick="submitTranslation('${language.localeCode}')"
												class="tr_save">save</a><span></span>
										</div>
										<div class="button tr_cancel_btn">
											<a href="#" class="tr_cancel">cancel</a><span></span>
										</div>


									</div> <!--ends hidden_translation_cont -->
								</td>
							</tr>
						</c:forEach>
				</table>
			</div>
		</form>
		<input type="button" value="Back To Standards" title="Back" onclick="location.href='/web/brand-standards/standards${urlQuery}'" />
		</div>
	</div>
	<div class="rounded_container_bottom">&nbsp;</div>
</div>
<div class="clear"></div>

<!-- Image Gallery Search content for translation -->
<a href="#ImgGallerySearchTranslation"
	id="img_gallery_search_translation" title="" class="nyroModal"
	style="display: none;">DOM Element (hidden div)</a>
<div style="display: none;" id="choose_image_helper"></div>
<div id="ImgGallerySearchTranslation" class="model_content">
	<div id="img_model_frame"></div>
	<iframe
		src="/web/brand-standards/assign-image?COMMAND=GUEST_SEARCH_IMAGE_TRANS"></iframe>
</div>