
package com.ihg.grs.mail;

import com.liferay.mail.model.FileAttachment;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.ArrayUtil;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * GenericMail.
 */
public class GenericMail
{

	private static final Log LOGGER = LogFactoryUtil.getLog(GenericMail.class);

	private MailMessage mailMessage;

	/**
	 * Define a public constructor.
	 */
	public GenericMail()
	{
		mailMessage = new MailMessage();
		mailMessage.setHTMLFormat(true);
	}

	/** Get method From MailMessage.
	 * @return getFrom
	 **/
	public String getFrom()
	{
		return mailMessage.getFrom().toString();
	}

	/** Set method From Mail Message.
	 * @param from Sender E-mail.
	 * @throws AddressException InternetAddress
	 **/
	public void setFrom(String from)
		throws AddressException
	{
		this.mailMessage.setFrom(new InternetAddress(from));
	}

	/** Get method To Multiple MailMessage.
	 * @return getTo
	 **/
	public InternetAddress[] getTo()
	{
		return mailMessage.getTo();
	}

	/** Set method To Mail Message.
	 * @param to receiver E-mail ids.
	 * @throws AddressException InternetAddress
	 **/
	public void setTo(String to)
		throws AddressException
	{
		InternetAddress toInternetAddress = new InternetAddress(to);
		mailMessage.setTo(toInternetAddress);
	}

	/**
	 * 
	 * @param to list of receiver E-mail ids.
	 * @throws AddressException InternetAddress
	 */
	public void setTo(String[] to)
		throws AddressException
	{
		if (ArrayUtil.isNotEmpty(to))
		{
			InternetAddress[] toInternetAddress = new InternetAddress[to.length];
			for (int i = 0; i < to.length; i++)
			{
				toInternetAddress[i] = new InternetAddress(to[i]);
			}
			mailMessage.setTo(toInternetAddress);
		}
	}

	/** Get method Cc Email-ids.
	 * @return getCc
	 * 
	 **/
	public InternetAddress[] getCc()
	{
		return mailMessage.getCC();
	}

	/** Set method Cc E-Mail ids.
	 * @param cc Email id.
	 * @throws AddressException InternetAddress.
	 **/
	public void setCC(String cc)
		throws AddressException
	{
		InternetAddress ccInternetAddress = new InternetAddress(cc);
		mailMessage.setCC(ccInternetAddress);
	}

	/** 
	 * 
	 * @param cc List of Email ids.
	 * @throws AddressException InternetAddress
	 */
	public void setCc(String[] cc)
		throws AddressException
	{
		if (ArrayUtil.isNotEmpty(cc))
		{
			InternetAddress[] ccInternetAddress = new InternetAddress[cc.length];
			for (int i = 0; i < cc.length; i++)
			{
				ccInternetAddress[i] = new InternetAddress(cc[i]);
			}
			mailMessage.setCC(ccInternetAddress);
		}
	}

	/** Get method Subject Email.
	 * @return getSubject
	 * 
	 **/
	public String getSubject()
	{
		return mailMessage.getSubject();
	}

	/** Set Email subject.
	 * @param subject of Email.
	 */
	public void setSubject(String subject)
	{
		this.mailMessage.setSubject(subject);
	}

	/** Get method body of Email.
	 * @return getBody
	 * 
	 **/
	public String getBody()
	{
		return mailMessage.getBody();
	}

	/** Set Email Body.
	 * @param body of Email.
	 */
	public void setBody(String body)
	{
		this.mailMessage.setBody(body);
	}

	/** Get method getAttachments Email.
	 * @return getFileAttachments
	 * 
	 **/
	public List<FileAttachment> getAttachments()
	{
		return mailMessage.getFileAttachments();
	}

	/**
	 * 
	 * @param file Email Attachment file
	 */
	public void addFileAttachment(File file)
	{
		this.mailMessage.addFileAttachment(file);
	}

	/**
	 * 
	 * @param file Email Attachment 
	 * @param fileName Email Attachment fileName
	 */
	public void addFileAttachment(File file, String fileName)
	{
		this.mailMessage.addFileAttachment(file, fileName);
	}

	/**
	 * Send Email through MailServiceUtil.  
	 */
	public void sendEmail()
	{
		MailServiceUtil.sendEmail(mailMessage);

		if (LOGGER.isInfoEnabled())
		{
			LOGGER.info(String.format("Mail Sent to %s, Subject: %s", Arrays.toString(mailMessage.getTo()), mailMessage.getSubject()));
		}
	}

}
