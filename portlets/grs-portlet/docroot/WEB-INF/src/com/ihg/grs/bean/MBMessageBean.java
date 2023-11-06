
package com.ihg.grs.bean;

import com.liferay.portal.kernel.repository.model.FileEntry;

import java.util.List;

/**
 * A POJO for MBMessageBean class for Discussion Portlet.
 * @author nakul.patel
 *
 */
public class MBMessageBean
{

	private String messageShortDate;
	private String messageUserName;
	private String title;
	private String threadId;
	private String commentCount;
	private String likeCount;
	private String userId;
	private String threadBody;
	private List<FileEntry> attachmentsFileEntries;
	private long messageId;
	private String messageDate;

	/**
	 * Returns date of discussion created in String format.
	 * @return Date of message created.
	 */
	public String getMessageDate()
	{
		return messageDate;
	}

	/**
	 * Sets creation date of discussion.
	 * @param messageDate Date when discussion created.
	 */
	public void setMessageDate(String messageDate)
	{
		this.messageDate = messageDate;
	}

	/**
	 * Returns message id. 
	 * @return Id of the MBMessageBoard discussion.
	 */
	public long getMessageId()
	{
		return messageId;
	}

	/**
	 * Set message id to MBMessageBean POJO.
	 * @param messageId Message id.
	 */
	public void setMessageId(long messageId)
	{
		this.messageId = messageId;
	}

	/**
	 * Returns file object of Attachment of corresponding discussion.
	 * @return File object of attachment.
	 */
	public List<FileEntry> getAttachmentsFileEntries()
	{
		return attachmentsFileEntries;
	}

	/**
	 * Set file object of attachment to MBMessageBean POJO.
	 * @param attachmentsFileEntries File object of attachment.
	 */
	public void setAttachmentsFileEntries(List<FileEntry> attachmentsFileEntries)
	{
		this.attachmentsFileEntries = attachmentsFileEntries;
	}

	/**
	 * Returns body of thread of MBMessageBean.
	 * @return Body of the Thread in String format.
	 */
	public String getThreadBody()
	{
		return threadBody;
	}

	/**
	 * Set body of thread to MBMessageBean POJO.
	 * @param threadBody Body of thread.
	 */
	public void setThreadBody(String threadBody)
	{
		this.threadBody = threadBody;
	}

	/**
	 * Returns userId who created new Thread.
	 * @return UserId who created to new Thread/Discussion.
	 */
	public String getUserId()
	{
		return userId;
	}

	/**
	 * Set userId who created thread to MBMessageBean POJO.
	 * @param userId userId who created the new Thread.
	 */
	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	/**
	 * Returns creation date of discussion.
	 * @return Discussion creation date in String format.
	 */
	public String getMessageShortDate()
	{
		return messageShortDate;
	}

	/**
	 * Set discussion creation date to MBMessageBean POJO.
	 * @param messageShortDate Discussion creation date in String format.
	 */
	public void setMessageShortDate(String messageShortDate)
	{
		this.messageShortDate = messageShortDate;
	}

	/**
	 * Returns thread id of Message Board.
	 * @return Id of thread of Message Board.
	 */
	public String getThreadId()
	{
		return threadId;
	}

	/**
	 * Set threadId to MBMessageBean POJO.
	 * @param threadId thread id of Message board thread.
	 */
	public void setThreadId(String threadId)
	{
		this.threadId = threadId;
	}

	/**
	 * Returns title of discusssion.
	 * @return Return main title of the discussion.
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * Set title of discussion to MBMessageBean POJO.
	 * @param title Title of the discussion.
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	/**
	 * Return total number of like count of discussion.
	 * @return like counts of corresponding discussion.
	 */
	public String getLikeCount()
	{
		return likeCount;
	}

	/**
	 * Set like counts of discussion to MBMessageBean POJO.
	 * @param likeCount like counts of corresponding discussion.
	 */
	public void setLikeCount(String likeCount)
	{
		this.likeCount = likeCount;
	}

	/**
	 * Return total number of comment count of discussion.
	 * @return comment counts of corresponding discussion.
	 */
	public String getCommentCount()
	{
		return commentCount;
	}

	/**
	 * Set comment counts of discussion to MBMessageBean POJO.
	 * @param commentCount Comment counts of corresponding discussion.
	 */
	public void setCommentCount(String commentCount)
	{
		this.commentCount = commentCount;
	}

	/**
	 * Returns user name of Message Board.
	 * @return User name.
	 */
	public String getMessageUserName()
	{
		return messageUserName;
	}

	/**
	 * Set user name of message to MBMessageBean POJO.
	 * @param messageUserName User name.
	 */
	public void setMessageUserName(String messageUserName)
	{
		this.messageUserName = messageUserName;
	}

}
