<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.ihg.grs.common.model.Directory"%>
<%@include file="../init.jsp"%>

<portlet:actionURL var="addDirectoryURL" name="addDirectory" />
<c:set var="pageURL" value="<%=ActionUtil.getFullURLByPageName(renderRequest,ApplicationConstants.PAGE_NAME_DIRECTORY_PUBLISHING)%>" />
<c:set var="cancelURL" value="<%=ActionUtil.getFullURLByPageName(renderRequest,ApplicationConstants.PAGE_NAME_DIRECTORY)%>" />

<aui:model-context model="<%=Directory.class %>" bean="${directory }" />
<div class="changeNetwrkBody">
	<div class="feedbackForm">
		<liferay-ui:success key="directory-processed-successfully" message="your-request-completed-successfully" />
		<liferay-ui:error key="error-processing-directory" message="your-request-could-not-be-processed" />
		<liferay-ui:error key="invalid-directory-id" message="invalid-directory-id" />

		<aui:form action="${addDirectoryURL }" method="post">
			<aui:input name="directoryId" type="hidden" />
			<aui:input name="redirect" type="hidden" value="${themeDisplay.URLCurrent }" />
			<aui:fieldset>
				<aui:input name="lastName" required="true" max="100" showRequiredLabel="false" />
				<aui:input name="firstName" required="true" max="100" showRequiredLabel="false" />
				<aui:input name="businessTitle" label="Business Title" required="true" max="100" showRequiredLabel="false" />
				<aui:input name="geoRegion" label="Geo Region" required="true" max="50" showRequiredLabel="false" />
			</aui:fieldset>
			<aui:fieldset>
				<div class="customSelectWrap">
					<aui:select name="role" cssClass="customSelect" label="Change Network Status" required="true"
						showRequiredLabel="false">
						<aui:option>Select</aui:option>
						<aui:option value="Leader">Leader</aui:option>
						<aui:option value="Advisor">Advisor</aui:option>
						<aui:option value="Member">Member</aui:option>
						<aui:option value="Facilitator">Facilitator</aui:option>
						<aui:option value="Sponsor">Sponsor</aui:option>
						<aui:option value="Account Manager">Account Manager</aui:option>
					</aui:select>
				</div>
				<aui:input name="regionType" label="Global/Regional" required="true" max="50" showRequiredLabel="false" />
				<aui:input name="organizationName" label="Stakeholder Group" required="true" max="100" showRequiredLabel="false" />
				<aui:input name="portraitURL" label="Portrait URL" max="500" />
				<aui:input name="email" label="Email Id" required="false" max="100" showRequiredLabel="false" />
			</aui:fieldset>
			

			<div class="bottomLink">
				<input type="submit" class="postMsg" value="Submit" /> <input type="button" class="cancel" value="Cancel"
					onclick="javascript: location.href='${cancelURL }';" />
			</div>
		</aui:form>
	</div>
</div>