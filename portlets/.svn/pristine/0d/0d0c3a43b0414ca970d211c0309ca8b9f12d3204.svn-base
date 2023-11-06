
package com.ihg.grs.mail;

import com.ihg.grs.common.model.Feedback;
import com.ihg.grs.common.model.FeedbackDetail;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.portlet.PortletProps;

import java.io.File;
import java.io.StringWriter;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

/**
 * Mail Sending functionality for Feedback.
 * @author hiren.patel
 *
 */
public class FeedbackMail extends GenericMail
{

	private static final Log LOGGER = LogFactoryUtil.getLog(FeedbackMail.class);
	private static String EMAIL_TEMPLATE_LOCATION = File.separator + "email-template" + File.separator;
	private static VelocityEngine ve;

	static
	{
		/* Get and initialize velocity engine */
		ve = new VelocityEngine();
		try
		{
			ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
			ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
			ve.init();
		}
		catch (Exception e)
		{
			if (LOGGER.isDebugEnabled())
			{
				LOGGER.debug(e.getMessage(), e);
			}
		}

	}

	private Feedback feedback;
	private List<FeedbackDetail> feedbackDetails;

	/** Get method getFeedback.
	 * @return feedback
	 **/  
	public Feedback getFeedback()
	{
		return feedback;
	}

	/** Set method For feedback.
	 * @param feedback of Feedback
	 **/
	public void setFeedback(Feedback feedback)
	{
		this.feedback = feedback;
	}

	/** Get method getFeedbackDetail.
	 * @return feedbackDetails
	 **/  
	public List<FeedbackDetail> getFeedbackDetail()
	{
		return feedbackDetails;
	}

	/** Set method feedBackDetail.
	 * @param feedbackDetails list of feedback details
	 **/
	public void setFeedbackDetail(List<FeedbackDetail> feedbackDetails)
	{
		this.feedbackDetails = feedbackDetails;
	}

	/**
	 * Send Feedback Acknowledgement for Mail.
	 */
	public void sendFeedbackAcknowledgementMail()
	{ 
		VelocityContext context = new VelocityContext();

		// Set subject
		String fileName = "feedback-acknowledgement.vm";
		setSubject(PortletProps.get("feedback.mail.acknowledgement.subject"));

		context.put("feedback", getFeedback());
		context.put("feedbackDetails", getFeedbackDetail());

		// Set body
		setBody(getBody(fileName, context));

		// Send Email
		sendEmail();
	}

	/**
	 * Feedback Submission Mail.
	 */
	public void sendFeedbackSubmissionMail()
	{
		VelocityContext context = new VelocityContext();

		// Set Subject
		String subject = PortletProps.get("feedback.mail.submission.subject");
		setSubject(subject);

		List<FeedbackDetail> feedbackDetails = getFeedbackDetail();
		context.put("feedback", getFeedback());
		context.put("feedbackDetails", feedbackDetails);

		// Set body
		String fileName = "feedback-submission.vm";
		setBody(getBody(fileName, context));

		// Add attachment
		for (FeedbackDetail feedbackDetail : feedbackDetails)
		{
			if (Validator.isNotNull(feedbackDetail.getFileName()))
			{
				addFileAttachment(feedbackDetail.getFeedbackFile(), feedbackDetail.getFileName());
			}
		}

		// Send Mail
		sendEmail();

	}

	/**
	 * 
	 * @param fileName of Filename
	 * @param context VelocityContext
	 * @return null
	 */
	protected String getBody(String fileName, VelocityContext context)
	{
		fileName = EMAIL_TEMPLATE_LOCATION + fileName;
		try
		{
			Template t = ve.getTemplate(fileName, "UTF-8");
			StringWriter writer = new StringWriter();
			t.merge(context, writer);
			return writer.toString();
		}
		catch (Exception e)
		{
			LOGGER.error("Error while reading file: " + fileName, e);
		}
		return null;
	}

}
