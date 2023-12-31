<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
--%>

<%@ include file="/html/portlet/journal/init.jsp" %>

<%
JournalArticle article = (JournalArticle)request.getAttribute(WebKeys.JOURNAL_ARTICLE);

boolean smallImage = BeanParamUtil.getBoolean(article, request, "smallImage");
String smallImageURL = BeanParamUtil.getString(article, request, "smallImageURL");

String defaultLanguageId = (String)request.getAttribute("edit_article.jsp-defaultLanguageId");
String toLanguageId = (String)request.getAttribute("edit_article.jsp-toLanguageId");

PortletPreferences portletSetup = renderRequest.getPreferences();
String noCustom = portletSetup.getValue("noCustom","true");
String hideAbstractDesc = "false";
String hideSmallImage = "false";

if(!"true".equals(noCustom)) {
	hideAbstractDesc = portletSetup.getValue("hideAbstractDesc","false");
	hideSmallImage = portletSetup.getValue("hideSmallImage","false");
}
%>

<liferay-ui:error-marker key="errorSection" value="abstract" />

<aui:model-context bean="<%= article %>" defaultLanguageId="<%= defaultLanguageId %>" model="<%= JournalArticle.class %>" />

<h3><liferay-ui:message key="abstract" /></h3>

<liferay-ui:error exception="<%= ArticleSmallImageNameException.class %>">

	<%
	String[] imageExtensions = PrefsPropsUtil.getStringArray(PropsKeys.JOURNAL_IMAGE_EXTENSIONS, StringPool.COMMA);
	%>

	<liferay-ui:message key="image-names-must-end-with-one-of-the-following-extensions" /> <%= StringUtil.merge(imageExtensions, ", ") %>.
</liferay-ui:error>

<liferay-ui:error exception="<%= ArticleSmallImageSizeException.class %>">

	<%
	long imageMaxSize = PrefsPropsUtil.getLong(PropsKeys.JOURNAL_IMAGE_SMALL_MAX_SIZE) / 1024;
	%>

	<liferay-ui:message arguments="<%= imageMaxSize %>" key="please-enter-a-small-image-with-a-valid-file-size-no-larger-than-x" />
</liferay-ui:error>

<aui:fieldset>
      			
    <c:if test='<%= !hideAbstractDesc.equals("true")%>'>
		<aui:input label="summary" languageId="<%= Validator.isNotNull(toLanguageId) ? toLanguageId : defaultLanguageId %>" name="description" />
	</c:if>

	<c:if test='<%= Validator.isNull(toLanguageId) && !hideSmallImage.equals("true")%>'>
		<div id="<portlet:namespace />smallImageContainer">
			<div class="lfr-journal-small-image-header">
				<aui:input label="use-small-image" name="smallImage" />
			</div>

			<div class="lfr-journal-small-image-content toggler-content-collapsed">
				<aui:row>
					<c:if test="<%= smallImage && (article != null) %>">
						<aui:col width="<%= 50 %>">
							<img alt="<liferay-ui:message key="preview" />" class="lfr-journal-small-image-preview" src="<%= Validator.isNotNull(article.getSmallImageURL()) ? HtmlUtil.escapeAttribute(article.getSmallImageURL()) : themeDisplay.getPathImage() + "/template?img_id=" + article.getSmallImageId() + "&t=" + WebServerServletTokenUtil.getToken(article.getSmallImageId()) %>" />
						</aui:col>
					</c:if>

					<aui:col width="<%= (smallImage && (article != null)) ? 50 : 100 %>">
						<aui:fieldset>
							<aui:input cssClass="lfr-journal-small-image-type" inlineField="<%= true %>" label="small-image-url" name="smallImageType" type="radio" />

							<aui:input cssClass="lfr-journal-small-image-value" inlineField="<%= true %>" label="" name="smallImageURL" />
						</aui:fieldset>

						<aui:fieldset>
							<aui:input cssClass="lfr-journal-small-image-type" inlineField="<%= true %>" label="small-image" name="smallImageType" type="radio" />

							<aui:input cssClass="lfr-journal-small-image-value" inlineField="<%= true %>" label="" name="smallFile" type="file" />
						</aui:fieldset>
					</aui:col>
				</aui:row>
			</div>
		</div>

		<aui:script use="aui-toggler">
			var container = A.one('#<portlet:namespace />smallImageContainer');

			var types = container.all('.lfr-journal-small-image-type');
			var values = container.all('.lfr-journal-small-image-value');

			var selectSmallImageType = function(index) {
				types.set('checked', false);

				types.item(index).set('checked', true);

				values.set('disabled', true);

				values.item(index).set('disabled', false);
			};

			container.delegate(
				'change',
				function(event) {
					var index = types.indexOf(event.currentTarget);

					selectSmallImageType(index);
				},
				'.lfr-journal-small-image-type'
			);

			new A.Toggler(
				{
					animated: true,
					content: '#<portlet:namespace />smallImageContainer .lfr-journal-small-image-content',
					expanded: <%= smallImage %>,
					header: '#<portlet:namespace />smallImageContainer .lfr-journal-small-image-header',
					on: {
						animatingChange: function(event) {
							var instance = this;

							var expanded = !instance.get('expanded');

							A.one('#<portlet:namespace />smallImage').set('value', expanded);
							A.one('#<portlet:namespace />smallImageCheckbox').set('checked', expanded);

							if (expanded) {
								types.each(
									function(item, index, collection) {
										if (item.get('checked')) {
											values.item(index).set('disabled', false);
										}
									}
								);
							}
							else {
								values.set('disabled', true);
							}
						}
					}
				}
			);

			selectSmallImageType('<%= (article != null) && Validator.isNotNull(article.getSmallImageURL()) ? 0 : 1 %>');
		</aui:script>
	</c:if>
</aui:fieldset>