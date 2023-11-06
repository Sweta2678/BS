
package com.ihg.grs.portlet;

import com.ihg.grs.common.model.Feedback;
import com.ihg.grs.common.model.FeedbackDetail;
import com.ihg.grs.common.service.FeedbackDetailLocalServiceUtil;
import com.ihg.grs.common.service.FeedbackLocalServiceUtil;
import com.ihg.grs.mail.FeedbackMail;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.OutputBlob;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

/**
 * Portlet implementation class FeedbackPortlet.
 */
public class FeedbackPortlet extends MVCPortlet
{

	private static final String ADMIN_EMAIL = "admin-email";
	private static final Log LOGGER = LogFactoryUtil.getLog(WhatsHappeningPortlet.class);

	/**
	 * @param actionRequest  
	 *            Action request is passed when feedback saved.
	 * @param actionResponse
	 *            After saving feedback response is passing response.
	 * @throws IOException Throws IOException during Feedback process
	 */
	public void processFeedback(ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException
	{
		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Inside processFeedback()");
		}

		// Hide default error message
		SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String currentUserId = themeDisplay.getUser().getScreenName();
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		List<FeedbackDetail> feedbackDetails = new ArrayList<FeedbackDetail>();

		String firstName = ParamUtil.getString(uploadRequest, "firstName");
		String lastName = ParamUtil.getString(uploadRequest, "lastName");
		String title = ParamUtil.getString(uploadRequest, "title");
		if (Validator.isNull(title))
		{
			title = "Anonymous";
		}
		String email = ParamUtil.getString(uploadRequest, "email");
		String onBehalfOf = ParamUtil.getString(uploadRequest, "onBehalfOf");
		try
		{

			Feedback feedback = FeedbackLocalServiceUtil.createFeedback((int) CounterLocalServiceUtil.increment(Feedback.class.getName()));
			feedback.setFirstName(firstName);
			feedback.setLastName(lastName);
			feedback.setTitle(title);
			feedback.setEmail(email);
			feedback.setOnBehalfOf(onBehalfOf);

			if (LOGGER.isDebugEnabled())
			{
				LOGGER.debug(String.format("firstName=%s, lastName=%s, email=%s, title=%s", firstName, lastName, email, title));
			}

			for (int i = 1; i <= 5; i++)
			{
				String feedbackType = ParamUtil.getString(uploadRequest, "feedbackType_" + i);
				String topic = ParamUtil.getString(uploadRequest, "topic_" + i);
				String otherTopic = ParamUtil.getString(uploadRequest, "otherTopic_" + i);
				String message = ParamUtil.getString(uploadRequest, "message_" + i);
				String fileName = uploadRequest.getFileName("file_" + i);
				File uploadedFile = uploadRequest.getFile("file_" + i);
				FeedbackDetail feedbackDetail = FeedbackDetailLocalServiceUtil.createFeedbackDetail((int) CounterLocalServiceUtil.increment(FeedbackDetail.class.getName()));
				feedbackDetail.setFeedbackId(feedback.getFeedbackId());
				feedbackDetail.setFeedbackType(feedbackType);
				feedbackDetail.setSubject(topic);
				if ("other".equalsIgnoreCase(topic))
				{
					feedbackDetail.setSubject(otherTopic);
				}
				feedbackDetail.setMessage(message);

				if (isEmptyFeedbackDetail(feedbackDetail))
				{
					continue;
				}

				try
				{
					if (Validator.isNotNull(fileName))
					{
						feedbackDetail.setFileName(fileName);
						OutputBlob fileBlob = new OutputBlob(new FileInputStream(uploadedFile), uploadedFile.length());
						feedbackDetail.setFileContent(fileBlob);
						feedbackDetail.setFeedbackFile(uploadedFile);
					}
				}
				catch (FileNotFoundException e)
				{
					LOGGER.error(e.getMessage());
				}

				feedbackDetails.add(feedbackDetail);

				if (LOGGER.isDebugEnabled())
				{
					LOGGER.debug(String.format("Feedback Type=%s, Subject=%s, Message=%s, File=%s", feedbackDetail.getFeedbackType(), feedbackDetail.getSubject(), message, fileName));
				}
			}

			FeedbackLocalServiceUtil.addFeedback(feedback, feedbackDetails, currentUserId);

			SessionMessages.add(actionRequest, "feedback-processed-successfully");

			if (LOGGER.isDebugEnabled())
			{
				LOGGER.debug("Feedback added to database successfully.");
			}

			// Send Feedback Mail
			PortletPreferences portletPreferences = actionRequest.getPreferences();
			String adminEmail = portletPreferences.getValue(ADMIN_EMAIL, StringPool.BLANK);

			if (Validator.isNotNull(adminEmail))
			{
				FeedbackMail mail = new FeedbackMail();
				try
				{
					mail.setFrom(adminEmail);
					mail.setFeedback(feedback);
					mail.setFeedbackDetail(feedbackDetails);

					// Send Feedback Acknowledgement mail
					mail.setTo(themeDisplay.getUser().getEmailAddress());
					mail.sendFeedbackAcknowledgementMail();

					// Send feedback submission mail
					mail.setTo(adminEmail);
					mail.sendFeedbackSubmissionMail();
				}
				catch (AddressException e)
				{
					LOGGER.error("Error in email address. " + e.getMessage());
				}
			}
			else
			{
				LOGGER.warn("Admin email is not configured. Cannot send feedback mail.");
			}

		}
		catch (SystemException e)
		{
			SessionErrors.add(actionRequest, "error-processing-feedback");
			LOGGER.error("Error while processing feedback.", e);
		}
	}

	/**
	 * Set preferences.
	 * 
	 * @param actionRequest
	 *            Action request is passed when Preferences saved.
	 * @param actionResponse
	 *            After saving action response is passing response.
	 */
	public void setPreferences(ActionRequest actionRequest, ActionResponse actionResponse)
	{

		try
		{

			String adminEmailId = ParamUtil.getString(actionRequest, ADMIN_EMAIL);

			PortletPreferences portletPreferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);

			portletPreferences.setValue(ADMIN_EMAIL, adminEmailId);

			portletPreferences.store();

			SessionMessages.add(actionRequest, "preferences-saved-successfully");

		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage(), e);
			SessionMessages.add(actionRequest, "error-saving-preferences");
		}
	}

	/**
	 * 
	 * @param feedbackDetail isEmptyFeedbackDetail  
	 * @return false
	 */
	private boolean isEmptyFeedbackDetail(FeedbackDetail feedbackDetail)
	{
		if (Validator.isNull(feedbackDetail.getFeedbackType()) && Validator.isNull(feedbackDetail.getSubject()) && Validator.isNull(feedbackDetail.getMessage()))
		{
			return true;
		}
		return false;
	}

}
