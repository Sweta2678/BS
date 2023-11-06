
package com.ihg.grs.util;

import com.ihg.grs.bean.MBMessageBean;
import com.ihg.grs.constant.ApplicationConstants;
import com.ihg.grs.constant.DiscussionConstant;
import com.ihg.me2.core.bean.MBMessageInfo;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.util.portlet.PortletProps;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletRequest;

/**
 * Utility class of Action.
 */
public final class ActionUtil
{

	/**
	 * Define a private constructor.
	 */
	private ActionUtil()
	{
	}
	private static final Log LOGGER = LogFactoryUtil.getLog(ActionUtil.class);

	/**
	 * Get friendlyUrl from pageName.
	 * 
	 * @param themeDisplay of ThemeDisplay
	 * @param friendlyURL page friendly url
	 * @return url
	 */
	public static String getFullURLByFriendlyURL(ThemeDisplay themeDisplay, String friendlyURL)
	{
		String url = StringPool.BLANK;
		Layout layout;
		try
		{
			layout = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), false, friendlyURL);
			url = PortalUtil.getLayoutFullURL(layout, themeDisplay);
		}
		catch (Exception e)
		{
			if (LOGGER.isErrorEnabled())
			{
				LOGGER.error("No page found with friendly url = " + friendlyURL);
			}
		}
		return url;
	}

	/**
	 * Generate friendly url based on pagename.
	 * @param portletRequest passing request parameter
	 * @param pageName Passing pageName
	 * @return pageFriendlyURL
	 */
	public static String getFullURLByPageName(PortletRequest portletRequest, String pageName)
	{

		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Layout pageLayout = null;
		StringBuilder pageFriendlyURL = new StringBuilder();
		try
		{
			if (Validator.isNotNull(pageName))
			{
				pageLayout = getPageLayout(pageName, themeDisplay);
				if (Validator.isNotNull(pageLayout))
				{
					Group currentGroup = GroupLocalServiceUtil.getGroup(themeDisplay.getScopeGroupId());
					String groupFriendlyUrl = currentGroup.getPathFriendlyURL(false, themeDisplay);
					String communityUrl = currentGroup.getFriendlyURL();
					pageFriendlyURL.append(groupFriendlyUrl).append(communityUrl).append(pageLayout.getFriendlyURL());
					if (LOGGER.isDebugEnabled())
					{
						LOGGER.debug("groupFriendly URL :>>" + groupFriendlyUrl);
						LOGGER.debug("community URL :>>" + communityUrl);
					}
				}
			}
		}
		catch (PortalException e)
		{
			LOGGER.error(e.getMessage(), e);
		}
		catch (SystemException e)
		{
			LOGGER.error(e.getMessage(), e);
		}
		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Relative Page URL :>>" + pageFriendlyURL.toString());
		}

		return pageFriendlyURL.toString();
	}

	/**
	 * Generate friendly url based on pagename.
	 * @param portletRequest passing request parameter
	 * @param pageName Passing pageName
	 * @return pageFriendlyURL
	 */
	public static String getFullURLByPageName(PortletRequest portletRequest,long groupId, String pageName)
	{

		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Layout pageLayout = null;
		StringBuilder pageFriendlyURL = new StringBuilder();
		try
		{
			if (Validator.isNotNull(pageName))
			{
				pageLayout = getPageLayout(pageName, themeDisplay);
				if (Validator.isNotNull(pageLayout))
				{
					Group currentGroup = GroupLocalServiceUtil.getGroup(groupId);
					String groupFriendlyUrl = currentGroup.getPathFriendlyURL(false, themeDisplay);
					String communityUrl = currentGroup.getFriendlyURL();
					pageFriendlyURL.append(groupFriendlyUrl).append(communityUrl).append(pageLayout.getFriendlyURL());
					if (LOGGER.isDebugEnabled())
					{
						LOGGER.debug("groupFriendly URL :>>" + groupFriendlyUrl);
						LOGGER.debug("community URL :>>" + communityUrl);
					}
				}
			}
		}
		catch (PortalException e)
		{
			LOGGER.error(e.getMessage(), e);
		}
		catch (SystemException e)
		{
			LOGGER.error(e.getMessage(), e);
		}
		if (LOGGER.isDebugEnabled())
		{
			LOGGER.debug("Relative Page URL :>>" + pageFriendlyURL.toString());
		}

		return pageFriendlyURL.toString();
	}
	/**
	 * Get layout from pageName.
	 * 
	 * @param pageName of layout pageName
	 * @param themeDisplay of ThemeDisplay
	 * @return pageLayout
	 */
	private static Layout getPageLayout(String pageName, ThemeDisplay themeDisplay)
	{
		List<Layout> layoutList = null;
		Layout pageLayout = null;
		try
		{
			layoutList = LayoutLocalServiceUtil.getLayouts(themeDisplay.getScopeGroupId(), false);
			for (Layout layout : layoutList)
			{
				if (layout.getName(Locale.US).equalsIgnoreCase(pageName))
				{
					pageLayout = layout;
					break;
				}
				List<Layout> childLayouts = (List<Layout>) layout.getAllChildren();
				for (Layout childLayout : childLayouts)
				{
					if (childLayout.getName(Locale.US).equalsIgnoreCase(pageName))
					{
						pageLayout = childLayout;
						break;
					}
				}
			}
		}
		catch (SystemException e)
		{
			LOGGER.debug(e.getMessage(), e);
		}

		return pageLayout;
	}

	/**
	 * Checks resource permission.
	 * 
	 * @param themeDisplay of ThemeDisplay
	 * @return hasEditPermission
	 */
	public static boolean hasResourcePermission(ThemeDisplay themeDisplay)
	{
		long scopeGroupId = themeDisplay.getScopeGroupId();

		boolean hasEditPermission = false;

		boolean isOminiAdmin = false;
		boolean isCommunityAdmin = false;
		boolean isIHGContentAdmin = false;
		boolean isIHGContentPublisher = false;
		boolean isIHGSupuerContentPublisher = false;
		boolean isIHGGlobalAdmin = false;
		try
		{
			PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
			isOminiAdmin = permissionChecker.isOmniadmin();
			isCommunityAdmin = permissionChecker.isGroupAdmin(scopeGroupId);

			isIHGContentAdmin = UserGroupRoleLocalServiceUtil.hasUserGroupRole(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), PortletProps.get("ihg.global.content.admin.role.name"), false);
			isIHGContentPublisher =
				UserGroupRoleLocalServiceUtil.hasUserGroupRole(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), PortletProps.get("ihg.content.publisher.role.name"), false);
			isIHGSupuerContentPublisher =
				UserGroupRoleLocalServiceUtil.hasUserGroupRole(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), PortletProps.get("ihg.super.content.publisher.role.name"), false);
			isIHGGlobalAdmin = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), PortletProps.get("ihg.global.admin.role.name"), false);

			if (isOminiAdmin || isIHGGlobalAdmin || isCommunityAdmin || isIHGContentAdmin || isIHGContentPublisher || isIHGSupuerContentPublisher)
			{
				hasEditPermission = true;
			}
		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage(), e);
		}

		return hasEditPermission;
	}

	/**
	 * @param lstMBMessageInfo convert to MBMessagePojo
	 * @return lstMBMessageBean
	 */
	public static List<MBMessageBean> convetToMBMessagePojo(List<MBMessageInfo> lstMBMessageInfo)
	{

		List<MBMessageBean> lstMBMessageBean = new ArrayList<MBMessageBean>();
		try
		{
			for (MBMessageInfo messageInfo : lstMBMessageInfo)
			{

				MBMessageBean messageBean = null;
				String preferredName=new String();
				try
				{

					messageBean = new MBMessageBean();

					MBMessage rootMessage = messageInfo.getMessage();
					User rootPoster = DiscussionCommonUtil.getUser(rootMessage.getUserId());

					messageBean.setTitle(rootMessage.getSubject());
					messageBean.setMessageShortDate(DiscussionCommonUtil.getDiscussionShortFormattedDate(rootMessage.getCreateDate()));
					messageBean.setMessageDate(DateUtil.getFormattedDate(rootMessage.getCreateDate(), DiscussionConstant.DISCUSSION_DETAILS_DATE_FORMAT));
					preferredName=ArticleUtil.getPreferredNamebyUserId(rootMessage.getUserId(),true);
					messageBean.setMessageUserName(preferredName);
					messageBean.setLikeCount(String.valueOf(messageInfo.getLikeCount()));
					messageBean.setCommentCount(String.valueOf(messageInfo.getCommentCount()));
					messageBean.setThreadId(String.valueOf(rootMessage.getThreadId()));
					messageBean.setUserId(String.valueOf(rootPoster.getUserId()));
					messageBean.setThreadBody(StringUtil.shorten(HtmlUtil.stripHtml(rootMessage.getBody()), ApplicationConstants.DISCUSSION_DESCRIPTION_LENGTH));

				}
				catch (Exception e)
				{
					messageBean = null;
					LOGGER.error("Exception thrown from ActionUtil :: convetToMBMessagePojo()", e);
				}

				if (Validator.isNotNull(messageBean))
				{
					lstMBMessageBean.add(messageBean);
				}

			}
		}
		catch (Exception e)
		{
			LOGGER.error("Exception thrown from ActionUtil :: convetToMBMessagePojo()", e);
		}
		return lstMBMessageBean;

	}

	/**
	 * @param discussionComments Convert MBMessageCommentsPojo
	 * @return lstMBMessageCommentsList
	 */
	public static List<MBMessageBean> converToMBMessageCommentsPojo(List<MBMessage> discussionComments)
	{

		List<MBMessageBean> lstMBMessageCommentsList = new ArrayList<MBMessageBean>();

		try
		{
			for (MBMessage message : discussionComments)
			{

				MBMessageBean messageBean = null;
				String preferredName=new String();
				try
				{

					messageBean = new MBMessageBean();

					MBMessage rootMessage = DiscussionPortletUtil.getMessage(message.getMessageId());
					User rootPoster = DiscussionCommonUtil.getUser(rootMessage.getUserId());

					messageBean.setTitle(rootMessage.getSubject());
					messageBean.setMessageShortDate(DiscussionCommonUtil.getDiscussionShortFormattedDate(rootMessage.getCreateDate()));
					preferredName=ArticleUtil.getPreferredNamebyUserId(rootMessage.getUserId(),true);
					messageBean.setMessageUserName(preferredName);
					messageBean.setLikeCount(String.valueOf(DiscussionCommonUtil.getPostLikeCount(rootMessage.getMessageId())));
					messageBean.setCommentCount(String.valueOf(MBMessageLocalServiceUtil.getThreadMessagesCount(rootMessage.getThreadId(), WorkflowConstants.STATUS_ANY) - 1));
					messageBean.setThreadId(String.valueOf(rootMessage.getThreadId()));
					messageBean.setUserId(String.valueOf(rootPoster.getUserId()));
					messageBean.setThreadBody(rootMessage.getBody());
					messageBean.setMessageId(message.getMessageId());
					if (message.getAttachmentsFileEntries().size() > 0)
					{
						messageBean.setAttachmentsFileEntries(message.getAttachmentsFileEntries());
					}

				}
				catch (Exception e)
				{
					messageBean = null;
					LOGGER.error("Exception thrown from ActionUtil :: convetToMBMessagePojo()", e);
				}

				if (Validator.isNotNull(messageBean))
				{
					lstMBMessageCommentsList.add(messageBean);
				}

			}
		}
		catch (Exception e)
		{
			LOGGER.error("Exception thrown from ActionUtil :: converToMBMessageCommentsPojo()", e);
		}
		return lstMBMessageCommentsList;
	}

	/**
	 *
	 * @param companyId of companyID
	 * @param userId current user id   
	 * @return getExpandoValue
	 */
	public static String getBusinessJobTitle(long companyId, long userId)
	{
		String attributeName = ApplicationConstants.USER_CUSTOM_ATTRIBUTE_BUSINESS_JOB_TITLE;
		return getExpandoValue(companyId, User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME, attributeName, userId);
	}

	/**
	 * Based on given parameters, retrieves Expando Value, used for "String" type value.
	 * 
	 * @param companyId of Company ID
	 * @param className ClassName
	 * @param expandoTableName TableName expando
	 * @param expandoColumnName Column Name Expando
	 * @param classPK class primary key
	 * @return data
	 */
	public static String getExpandoValue(long companyId, String className, String expandoTableName, String expandoColumnName, long classPK)
	{
		String data = StringPool.BLANK;

		try
		{
			Object attributeVale = ExpandoValueLocalServiceUtil.getData(companyId, className, expandoTableName, expandoColumnName, classPK);

			if (attributeVale != null)
			{
				data = attributeVale.toString();
			}
		}
		catch (Exception e)
		{
			LOGGER.error("Error while getting expando attribute value, error: " + e.getMessage(), e);
		}

		return data;
	}

}
