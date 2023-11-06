
package com.ihg.grs.bean;

import com.liferay.portlet.messageboards.model.MBMessage;
/**
 * Message board POJO for Discussion.
 * @author nakul.patel
 *
 */
public class MessagePojo
{

	private MBMessage message;
	private String messageDate;
	private String messageUserName;
	private String imapgePath;

	/**
	 * Returns MBMessage object.
	 * @return MBMessage object.
	 */
	public MBMessage getMessage()
	{
		return message;
	}

	/**
	 * Sets MBMessage object to MessagePojo.
	 * @param message MBMessage object.
	 */
	public void setMessage(MBMessage message)
	{
		this.message = message;
	}

	/**
	 * Returns message creation date.
	 * @return Message creation date in String format.
	 */
	public String getMessageDate()
	{
		return messageDate;
	}

	/**
	 * Set message creation date to MessagePojo.
	 * @param messageDate Message creation date in String format.
	 */
	public void setMessageDate(String messageDate)
	{
		this.messageDate = messageDate;
	}

	/**
	 * Returns user name of Message board.
	 * @return message user name.
	 */
	public String getMessageUserName()
	{
		return messageUserName;
	}

	/**
	 * Sets user name of Message board to MessagePojo.
	 * @param messageUserName message user name.
	 */
	public void setMessageUserName(String messageUserName)
	{
		this.messageUserName = messageUserName;
	}

	/**
	 * Retruns user image URL.
	 * @return User image path who created discussion thread.
	 */
	public String getImapgePath()
	{
		return imapgePath;
	}

	/**
	 * Sets user image URL to MessagePojo.
	 * @param imapgePath User image path who created discussion thread.
	 */
	public void setImapgePath(String imapgePath)
	{
		this.imapgePath = imapgePath;
	}

}
