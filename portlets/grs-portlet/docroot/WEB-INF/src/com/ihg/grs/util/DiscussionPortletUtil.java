
package com.ihg.grs.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBMessageConstants;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;

import java.io.InputStream;
import java.util.List;

/**
 * Utility class for Discussion Portlet.
 * @author nakul.patel
 *
 */
public final class DiscussionPortletUtil
{

	private static final Log LOGGER = LogFactoryUtil.getLog(DiscussionCommonUtil.class.getName());

	/**
	 * private constructor for DiscussionPortletUtil class.
	 */
	private DiscussionPortletUtil() 
	{
		
	}
	
	/**
	 * Create a new message in Message Board portlet.
	 * @param user Object of user who is creating a new discussion.
	 * @param groupId Site id of current site.
	 * @param categoryId Category id of Message board category.
	 * @param threadId Root thread id of Message board.
	 * @param parentMessageId Id of parent message.
	 * @param subject Subject of the message board discussion.
	 * @param body Body of the message board discussion.
	 * @param files Attachment of the message board discussion.
	 * @param anonymous Boolean parameter.
	 * @param priority To set priority of message.
	 * @param allowPingbacks Boolean parameter.
	 * @param serviceContext Service context object.
	 * @return Message board object
	 */
	public static MBMessage addMessage(
		User user, long groupId, long categoryId, long threadId, long parentMessageId, String subject, String body, List<ObjectValuePair<String, InputStream>> files, boolean anonymous,
		double priority, boolean allowPingbacks, ServiceContext serviceContext)
	{
		MBMessage message = null;

		if (threadId <= 0)
		{

			try
			{
				message =
					MBMessageLocalServiceUtil.addMessage(
						user.getUserId(), user.getFullName(), groupId, categoryId, subject, body, MBMessageConstants.DEFAULT_FORMAT, files, anonymous, priority, allowPingbacks, serviceContext);
			}
			catch (PortalException e)
			{
				// TODO Auto-generated catch block
				LOGGER.error(e.getMessage(), e);
			}
			catch (SystemException e)
			{
				// TODO Auto-generated catch block
				LOGGER.error(e.getMessage(), e);
			}
		}
		else
		{
			try
			{
				message =
					MBMessageLocalServiceUtil.addMessage(
						user.getUserId(), user.getFullName(), groupId, categoryId, threadId, parentMessageId, subject, body, MBMessageConstants.DEFAULT_FORMAT, files, anonymous, priority, allowPingbacks,
						serviceContext);
			}
			catch (PortalException e)
			{
				// TODO Auto-generated catch block
				LOGGER.error(e.getMessage(), e);
			}
			catch (SystemException e)
			{
				// TODO Auto-generated catch block
				LOGGER.error(e.getMessage(), e);
			}
		}

		return message;
	}

	/**
	 * Return MBMessage boar object based on messageId.
	 * @param messageId Id of the MBMessage Board.
	 * @return MBMessage board object.
	 */
	public static MBMessage getMessage(long messageId)
	{
		MBMessage message = null;

		try
		{
			message = MBMessageLocalServiceUtil.getMBMessage(messageId);

		}
		catch (PortalException e)
		{
			LOGGER.error("Error while finding Message based on messageId:" + messageId, e);
		}
		catch (SystemException e)
		{
			LOGGER.error("Error while finding Message based on messageId:" + messageId, e);
		}

		return message;
	}
}
