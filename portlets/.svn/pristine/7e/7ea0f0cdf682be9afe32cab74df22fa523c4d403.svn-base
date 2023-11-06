<%@page import="com.liferay.util.PwdGenerator"%>
<%@page import="com.liferay.util.portlet.PortletProps"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@include file="../init.jsp"%>

<%
String backURL = (String) request.getHeader("referer");
if(Validator.isNull(backURL)){
	backURL = themeDisplay.getURLCurrent();
}
%>
<portlet:actionURL var="processFeedbackURL" name="processFeedback" />

<!-- Feedback Form Start -->
<div class="feedbackForm">

<liferay-ui:success key="feedback-processed-successfully" message="feedback-processed-successfully"/>
<liferay-ui:error key="error-processing-feedback" message="your-request-could-not-be-processed" />

	<h1>Submit Questions | Suggestions | Feedback</h1>
	<aui:form name="feedbackForm" method="post" action="${processFeedbackURL }" onSubmit="event.preventDefault();" enctype="multipart/form-data">
		<div class="anonymousChk">
			<input type="checkbox" class="customChk" value="yes" id="<portlet:namespace/>anonymous" name="<portlet:namespace/>anonymous" data-label="Submit Questions | Suggestions | Feedback anonymously"/> 
		</div>
		<div class="control">
			<label>First name</label>
			<input type="text" id="<portlet:namespace/>firstName" name="<portlet:namespace/>firstName" class="disabled" readonly="readonly" value="<%=ArticleUtil.getPreferredNamebyUserId(themeDisplay.getUserId(),false) %>" />
		</div>
			<div class="control">
			<label>Last name</label>
			<input type="text" id="<portlet:namespace/>lastName" name="<portlet:namespace/>lastName" class="disabled" readonly="readonly" value="${themeDisplay.user.lastName}" />
		</div>
		<div class="control">
			<label>Business title</label>
			<input type="text" id="<portlet:namespace/>title" name="<portlet:namespace/>title" class="disabled" readonly="readonly" value="<%=ActionUtil.getBusinessJobTitle(themeDisplay.getCompanyId(), themeDisplay.getUserId()) %>" />
		</div> 
		<div class="control">
			<label>Email</label>
			<input type="text" id="<portlet:namespace/>email" name="<portlet:namespace/>email" class="disabled" readonly="readonly" value="${themeDisplay.user.emailAddress}" />
		</div>
		<div class="control">
			<label>On Behalf of</label>
			<input type="text" id="<portlet:namespace/>onBehalfOf" name="<portlet:namespace/>onBehalfOf" maxlength="100" />
		</div>
		<div class="repeatingSection">
			<div class="control">
				<span class="required">*</span><label>Questions | Suggestions | Feedback type</label>
				<select class="customSelect350" id="<portlet:namespace/>feedbackType_1" name="<portlet:namespace/>feedbackType_1">
					<option value="">Select Questions | Suggestions | Feedback</option>
					<c:forEach var="type" items="<%=PortletProps.getArray(\"feedback.type\") %>">
						<option>${type }</option>
					</c:forEach>
				</select>
			</div>
			<div class="control">
				<span class="required">*</span><label>Topic</label>
				<select class="customSelect350" id="<portlet:namespace/>topic_1" name="<portlet:namespace/>topic_1">
					<option value="">Select Topic</option>
					<c:forEach var="topic" items="<%=PortletProps.getArray(\"feedback.topic\") %>">
						<option>${topic }</option>
					</c:forEach>
					<option value="other">Other</option>
				</select>
			</div>
			<div class="control">
				<label>Other-Specify Topic</label>
				<input type="text" id="<portlet:namespace/>otherTopic_1" name="<portlet:namespace/>otherTopic_1" maxlength="250"/>
			</div>
			<div class="control">
				<span class="required">*</span><label>Message</label>
				<textarea id="<portlet:namespace/>message_1" name="<portlet:namespace/>message_1" maxlength="500"></textarea>
			</div>
			<div class="control">
				<span class="required"></span><label>Upload File</label>
				<div  id="FileUpload">
					<input class="filebrowser" id="<portlet:namespace/>fileName_1" name="<portlet:namespace/>fileName_1" readonly>
					<div id="BrowserVisible">
						<input type="file" accept="" value="File" id="<portlet:namespace/>file_1" name="<portlet:namespace/>file_1" class="filestyle filebrowserclick" onchange="$(this).parent().prev().val($(this).val());">
					</div>    
				</div> 
			</div>
		</div>
		<span class="repeatable-field-image pull-right"> 
			<liferay-ui:icon cssClass="repeatable-field-add" image="add" /> 
			<liferay-ui:icon cssClass="repeatable-field-delete" image="delete" />
		</span>
		<div class="bottomLink">
			<input type="submit" class="pull-right postMsg" value="Send"/>
			<input type="button" class="pull-right cancel" value="Cancel" onclick="javascript: location.href='<%=backURL %>';" />
		</div>
	</aui:form>
</div>

<script type="text/javascript">
	$(function() {
		Feedback.init({
			form : $('#<portlet:namespace/>feedbackForm'),
			namespace : '<portlet:namespace/>',
			maxFileSize : <%=PortletProps.get("feedback.file.maxsize")%>
		});
	});
</script>