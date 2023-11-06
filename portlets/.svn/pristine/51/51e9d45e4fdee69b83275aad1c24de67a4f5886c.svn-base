
package com.ihg.grs.portlet;

import com.ihg.grs.bean.MBMessageBean;
import com.ihg.grs.constant.DiscussionConstant;
import com.ihg.grs.util.ActionUtil;
import com.ihg.grs.util.DiscussionCommonUtil;
import com.ihg.grs.util.DiscussionPortletUtil;
import com.ihg.me2.core.bean.MBMessageInfo;
import com.ihg.me2.core.service.CoreMessageLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.messageboards.model.MBCategory;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBMessageConstants;
import com.liferay.portlet.messageboards.service.MBCategoryLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;
import javax.servlet.http.HttpServletRequest;

/**
 * Portlet implementation class DiscussionPortlet.
 */
public class DiscussionPortlet extends MVCPortlet
{

	private static final Log LOGGER = LogFactoryUtil.getLog(DiscussionPortlet.class.getName());
	private static final String MAX_DISCUSSION = "maxDiscussion";
	private static final String WEB_CONTENT_ID = "webContentId";
	private static final String PARAM_DISCUSSION_COMMENTS_LIST = "discussionCommentsList";

	/**
	 * Retrieve list of all discussion, details of a particular discussion and start new discussion.
	 * @param request Render request object.
	 * @param response Render response object.
	 */
	public void doView(RenderRequest request, RenderResponse response)
	{
		String view = DiscussionCommonUtil.getParameterValue(request, "view");
		String discussionId = DiscussionCommonUtil.getParameterValue(request, "id");
		if ("startDiscussion".equalsIgnoreCase(view))
		{
			viewStartDiscussion(request, response);
		}
		else if (Validator.isNotNull(discussionId))
		{
			viewDiscussionComments(request, response);
		}
		else
		{
			viewDiscussionLanding(request, response);
		}
	}

	/**
	 * Discussion landing page to display overview of all discussions.
	 * @param renderRequest Request object.
	 * @param renderResponse Response object.
	 */
	private void viewDiscussionLanding(RenderRequest renderRequest, RenderResponse renderResponse)
	{
		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long parentCategoryId = 0l;
		int lstDiscussionCount = 0;
		List<MBCategory> categories = null;
		List<MBMessageBean> listDiscussionThread = null;

		long selectedMbCategoryId = 0l;
		if (httpReq.getParameter("categoryid") != null && Validator.isDigit(httpReq.getParameter("categoryid")))
		{
			selectedMbCategoryId = Long.valueOf(httpReq.getParameter("categoryid"));
		}

		String communityUrl = themeDisplay.getScopeGroup().getFriendlyURL();
		String redirect = "/web" + communityUrl + "/discussion";

		PortletPreferences prefs = renderRequest.getPreferences();
		int end = Integer.valueOf(prefs.getValue(MAX_DISCUSSION, String.valueOf(DiscussionConstant.MAX_DISCUSSION_SIZE)));
		int start = Integer.valueOf(DiscussionConstant.DEFAULT_DISCUSSIONS);

		categories = getCategories(themeDisplay.getScopeGroupId(), parentCategoryId);
		listDiscussionThread = getDiscussions(themeDisplay.getScopeGroupId(), selectedMbCategoryId, start, end);
		lstDiscussionCount = getDiscussionCount(themeDisplay.getScopeGroupId(), selectedMbCategoryId);

		User user = themeDisplay.getUser();

		String userPortrait = StringPool.BLANK;
		String currentGroupURL = StringPool.BLANK;

		try
		{
			currentGroupURL = PortalUtil.getLayoutFullURL(themeDisplay.getLayout(), themeDisplay);
			userPortrait = user.getPortraitURL(themeDisplay);
		}
		catch (PortalException e1)
		{
			// TODO Auto-generated catch block
			LOGGER.error("Portlet Exception discussion landing page:", e1);
		}
		catch (SystemException e1)
		{
			// TODO Auto-generated catch block
			LOGGER.error("System Exception discussion landing page:", e1);
		}

		renderRequest.setAttribute("redirect", redirect);
		renderRequest.setAttribute("categories", categories);
		renderRequest.setAttribute("selectedMbCategory", selectedMbCategoryId);
		renderRequest.setAttribute("discussionCount", lstDiscussionCount);
		renderRequest.setAttribute("listDiscussionThread", listDiscussionThread);
		renderRequest.setAttribute("currentGroupURL", currentGroupURL);
		renderRequest.setAttribute("prefs", end);
		renderRequest.setAttribute("user", user);
		renderRequest.setAttribute("userPortrait", userPortrait);

		try
		{
			include("/html/discussion/discussionLanding.jsp", renderRequest, renderResponse);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			LOGGER.error("IOException discussion landing page:", e);
		}
		catch (PortletException e)
		{
			// TODO Auto-generated catch block
			LOGGER.error("Portlet Exception discussion landing page exception:", e);
		}

	}

	/**
	 * Display details of a discussion including comments, like counts, comment counts and attachments.
	 * @param renderRequest A request object.
	 * @param renderResponse A response object.
	 */
	private void viewDiscussionComments(RenderRequest renderRequest, RenderResponse renderResponse)
	{
		String discussionId = DiscussionCommonUtil.getParameterValue(renderRequest, "id");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences prefs = renderRequest.getPreferences();
		if (Validator.isNotNull(discussionId))
		{

			try
			{
				List<MBMessage> discussionCommentsList = null;
				int commentsCount = MBMessageLocalServiceUtil.getThreadMessagesCount(Long.valueOf(discussionId), WorkflowConstants.STATUS_ANY);
				commentsCount--;
				int last = Integer.valueOf(prefs.getValue(MAX_DISCUSSION, String.valueOf(DiscussionConstant.MAX_DISCUSSION_SIZE)));
				int first = Integer.valueOf(DiscussionConstant.DEFAULT_DISCUSSIONS);

				discussionCommentsList = DiscussionCommonUtil.getDiscussionCommentsList(Long.valueOf(discussionId), first, last);

				List<MBMessageBean> commentsList = ActionUtil.converToMBMessageCommentsPojo(discussionCommentsList);

				String webContentId = prefs.getValue(WEB_CONTENT_ID, "0");

				renderRequest.setAttribute(PARAM_DISCUSSION_COMMENTS_LIST, commentsList);
				// request.setAttribute("parentid", parentDiscussionId);
				renderRequest.setAttribute("discussionId", discussionId);
				renderRequest.setAttribute("firstMessage", Boolean.TRUE);
				renderRequest.setAttribute("commentsCount", commentsCount);
				renderRequest.setAttribute("ctr", 0);
				renderRequest.setAttribute(WEB_CONTENT_ID, webContentId);
				renderRequest.setAttribute("userImage", DiscussionCommonUtil.getImageUrl(themeDisplay.getUserId(), themeDisplay));

			}
			catch (SystemException e)
			{
				// TODO Auto-generated catch block
				LOGGER.error("System Exception discussion comments page:", e);
			}

		}
		try
		{
			include("/html/discussion/discussionDetails.jsp", renderRequest, renderResponse);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			LOGGER.error("IO Exception discussion comments page:", e);
		}
		catch (PortletException e)
		{
			// TODO Auto-generated catch block
			LOGGER.error("Portal Exception discussion details page:", e);
		}
	}

	/**
	 * To create new discussion.
	 * @param renderRequest A request object.
	 * @param renderResponse A response object.
	 */
	private void viewStartDiscussion(RenderRequest renderRequest, RenderResponse renderResponse)
	{

		List<MBCategory> categories = null;
		long parentCategoryId = 0l;
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		String userPortrait = StringPool.BLANK;
		try
		{
			userPortrait = user.getPortraitURL(themeDisplay);
		}
		catch (PortalException e)
		{
			// TODO Auto-generated catch block
			LOGGER.error("Portal Exception while start new discussion:", e);
		}
		catch (SystemException e)
		{
			// TODO Auto-generated catch block
			LOGGER.error("System Exception while start new discussion:", e);
		}

		categories = getCategories(themeDisplay.getScopeGroupId(), parentCategoryId);

		renderRequest.setAttribute("userImage", DiscussionCommonUtil.getImageUrl(themeDisplay.getUserId(), themeDisplay));
		renderRequest.setAttribute("categories", categories);
		renderRequest.setAttribute("userPortrait", userPortrait);
		try
		{
			include("/html/discussion/startNewDiscussion.jsp", renderRequest, renderResponse);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			LOGGER.error("IO Exception while start new discussion:", e);
		}
		catch (PortletException e)
		{
			// TODO Auto-generated catch block
			LOGGER.error("Portlet Exception while start new discussion:", e);
		}
	}

	/**
	 * To set preferences, default number of discussion to display.
	 * @param request A request object.
	 * @param response A response object.
	 * @throws IOException Signals that an I/O exception of some sort has occurred.
	 */
	public void doEdit(RenderRequest request, RenderResponse response)
		throws IOException
	{

		PortletPreferences preferences = request.getPreferences();
		String discussionPrefs = preferences.getValue(MAX_DISCUSSION, "5");
		String webContentId = preferences.getValue(WEB_CONTENT_ID, "0");
		request.setAttribute("discussionPrefs", discussionPrefs);
		request.setAttribute(WEB_CONTENT_ID, webContentId);
		try
		{
			super.doEdit(request, response);
		}
		catch (PortletException e)
		{
			// TODO Auto-generated catch block
			LOGGER.error("Portlet exception while setting preferences:", e);
		}
	}

	/**
	 * To display next list of discussion and discussion comments on click of load more button.
	 * @param request A Ajax request object
	 * @param response A Ajax response object
	 * @throws IOException Signals that an I/O exception of some sort has occurred.
	 */
	public void serveResource(ResourceRequest request, ResourceResponse response)
		throws IOException
	{
		String resourceId = request.getResourceID();
		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
		if (Validator.isNotNull(resourceId) && "moreDiscussion".equals(resourceId))
		{
			long discussionId = ParamUtil.getLong(request, "discussionId");
			List<MBMessage> discussionCommentsList = null;

			int first = Integer.valueOf(httpReq.getParameter("start"));
			int end = Integer.valueOf(httpReq.getParameter("end"));

			discussionCommentsList = DiscussionCommonUtil.getDiscussionThread(discussionId, first, end);
			List<MBMessageBean> moreCommentsList = ActionUtil.converToMBMessageCommentsPojo(discussionCommentsList);
			int commentsCount = discussionCommentsList.size() - 1;
			request.setAttribute(PARAM_DISCUSSION_COMMENTS_LIST, moreCommentsList);
			request.setAttribute("discussionId", discussionId);
			request.setAttribute("commentsCount", commentsCount);
			try
			{
				include("/html/discussion/loadMoreComments.jsp", request, response);
			}
			catch (PortletException e)
			{
				// TODO Auto-generated catch block
				LOGGER.error(e.getMessage(), e);
			}
		} 
		else if (Validator.isNotNull(resourceId) && "subscribeThread".equals(resourceId))
		{
			long messageId = ParamUtil.getLong(httpReq, "messageId");
			boolean subscribe = ParamUtil.getBoolean(httpReq, "subscribe");
			LOGGER.info("Inside subscribeThread."+messageId+subscribe);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			DiscussionCommonUtil.subscribeDiscussion(themeDisplay.getUser().getUserId(), messageId, subscribe);
			
		}
		else 
		{
			List<MBMessageBean> loadMoreDiscussion = null;
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			PortletPreferences preferences = request.getPreferences();
			long categoryId = 0l;
			if (httpReq.getParameter("categoryId") != null && Validator.isDigit(httpReq.getParameter("categoryId")))
			{
				categoryId = Long.valueOf(httpReq.getParameter("categoryId"));
			}

			int start = Integer.valueOf(httpReq.getParameter("start"));

			int end = Integer.valueOf(preferences.getValue(MAX_DISCUSSION, String.valueOf(DiscussionConstant.MAX_DISCUSSION_SIZE)));

			int lstDiscussionCount = getDiscussionCount(themeDisplay.getScopeGroupId(), categoryId);
			loadMoreDiscussion = getDiscussions(themeDisplay.getScopeGroupId(), categoryId, start, end);
			request.setAttribute("loadMoreDiscussion", loadMoreDiscussion);
			request.setAttribute("discussionCount", lstDiscussionCount);
			// request.setAttribute("prefs", end);

			try
			{
				include("/html/discussion/loadMoreDiscussion.jsp", request, response);
			}
			catch (PortletException e)
			{
				// TODO Auto-generated catch block
				LOGGER.error(e.getMessage(), e);
			}
		}
		try
		{
			super.serveResource(request, response);
		}
		catch (PortletException e)
		{
			// TODO Auto-generated catch block
			LOGGER.error(e.getMessage(), e);
		}

	}

	/**
	 * Returns Message board categories.
	 * @param groupId current site id.
	 * @param parentCategoryId id of parent category of Message Board Portlet.
	 * @return mbCategories list of Message Board Categories.
	 */
	public List<MBCategory> getCategories(long groupId, long parentCategoryId)
	{

		List<MBCategory> mbCategories = null;

		try
		{
			mbCategories = MBCategoryLocalServiceUtil.getCategories(groupId, parentCategoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		}
		catch (SystemException e)
		{
			LOGGER.error("SystemException while retreive MBCategory. " + e.getMessage(), e);
		}
		return mbCategories;
	}

	/**
	 * Returns total number of comments posted for a discussion.
	 * @param groupId current site id.
	 * @param categoryId id of parent category of Message Board Portlet.
	 * @return count Number of comments posted for a discussion.
	 */
	public int getDiscussionCount(long groupId, long categoryId)
	{
		int count = 0;
		long[] categories = {};
		if (categoryId > 0)
		{
			categories = new long[1];
			categories[0] = categoryId;
		}
		count = CoreMessageLocalServiceUtil.getLatestMessageCount(groupId, categories);

		return count;
	}

	/**
	 * Returns all root level discussion for discussion landing page.
	 * @param groupId current site id.
	 * @param categoryId id of parent category of Message Board Portlet.
	 * @param start Start position of Message board discussions list.
	 * @param end End position of Message board discussions list.
	 * @return mbMessageBeanList Returns all root level discussions.
	 */
	public List<MBMessageBean> getDiscussions(long groupId, long categoryId, int start, int end)
	{

		List<MBMessageBean> mbMessageBeanList = null;
		long[] categories = {};
		if (categoryId > 0)
		{
			categories = new long[1];
			categories[0] = categoryId;
		}
		List<MBMessageInfo> discussionList = CoreMessageLocalServiceUtil.getLatestMessage(groupId, categories, start, end);

		mbMessageBeanList = ActionUtil.convetToMBMessagePojo(discussionList);

		return mbMessageBeanList;
	}

	/**
	 * Action method to start new discussion.
	 * @param request An Action request object.
	 * @param response An Action response object.
	 */
	public void startNewDiscussion(ActionRequest request, ActionResponse response)
	{

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		MBMessage message = null;
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);

		List<ObjectValuePair<String, InputStream>> fileList = DiscussionCommonUtil.getFiles(uploadRequest, "uploadFile");

		long groupId = themeDisplay.getScopeGroupId();
		double msgPriority = 1.0;

		long categoryId = ParamUtil.getLong(uploadRequest, "categories");

		String threadBody = ParamUtil.getString(uploadRequest, "myThreadBody");
		String subject = ParamUtil.getString(uploadRequest, "subject");
		try
		{

			ServiceContext serviceContext = DiscussionCommonUtil.getMBMessageServiceContext(request);
			serviceContext.setAddGroupPermissions(Boolean.TRUE);
			serviceContext.setAddGuestPermissions(Boolean.FALSE);

			message =
				DiscussionPortletUtil.addMessage(
					themeDisplay.getUser(), groupId, categoryId, DiscussionConstant.NEW_DISCUSSION_ID, DiscussionConstant.NEW_DISCUSSION_PARENT_DISCUSSION_ID
					, subject, threadBody, fileList, DiscussionConstant.IS_ANONYMUS, 
					msgPriority, DiscussionConstant.DEFAULT_ALLOW_PINGBACKS, serviceContext);

			String emailNotification = ParamUtil.getString(uploadRequest, "subscribe", DiscussionConstant.SEND_EMAIL_DEFAULT);

			if (message != null && emailNotification.equalsIgnoreCase(DiscussionConstant.SEND_EMAIL_YES))
			{
					LOGGER.info("Email will be sent as per preferences set !!!");

					MBMessageLocalServiceUtil.subscribeMessage(themeDisplay.getUser().getUserId(), message.getMessageId());
					LOGGER.info("Subscription Added for " + themeDisplay.getUser().getEmailAddress() + " For message id:- " + message.getMessageId());

			}
		}
		catch (PortalException e)
		{
			LOGGER.error("FileSizeException" + e.getLocalizedMessage(), e);
		}
		catch (SystemException e)
		{
			LOGGER.error(e.getLocalizedMessage(), e);
		}

	}

	/**
	 * To set preferences, default number of discussion comments to display.
	 * @param request An action request object.
	 * @param response An action response object.
	 */
	public void setDiscussionPreferences(ActionRequest request, ActionResponse response)
	{

		PortletPreferences preferences = request.getPreferences();
		if (Validator.isNotNull(ParamUtil.getString(request, "maxDiscussion")) && Validator.isNotNull(ParamUtil.getString(request, "prefWebcontentId")))
		{
			try
			{
				preferences.setValue(MAX_DISCUSSION, ParamUtil.getString(request, "maxDiscussion"));
				preferences.setValue(WEB_CONTENT_ID, ParamUtil.getString(request, "prefWebcontentId"));
				preferences.store();
			}
			catch (ReadOnlyException e)
			{
				LOGGER.error(e.getMessage(), e);
			}
			catch (ValidatorException e)
			{
				LOGGER.error(e.getMessage(), e);
			}
			catch (IOException e)
			{
				LOGGER.error(e.getMessage(), e);
			}

		}

	}

	/**
	 * 
	 * @param request Action request object.
	 * @param response Action response object.
	 * @throws IOException Signals that an I/O exception of some sort has occurred.
	 */
	public void addDiscussionComments(ActionRequest request, ActionResponse response)
		throws IOException
	{

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String threadBody = ParamUtil.getString(request, "addDiscussionCommentBody");
		// long parentId = Long.valueOf(ParamUtil.getString(uploadRequest,
		// DiscussionConstant.PARENT_ID));
		long discussionId = Long.valueOf(ParamUtil.getString(request, DiscussionConstant.DISCUSSION_ID));

		if (Validator.isNotNull(discussionId))
		{
			request.setAttribute("discussion", String.valueOf(discussionId));
		}

		try
		{
			ServiceContext serviceContext = DiscussionCommonUtil.getMBMessageServiceContext(request);

			serviceContext.setAddGroupPermissions(Boolean.TRUE);
			serviceContext.setAddGuestPermissions(Boolean.FALSE);
			serviceContext.setAttribute("fromWall", "true");

			List<MBMessage> messages = MBMessageLocalServiceUtil.getThreadMessages(discussionId, WorkflowConstants.STATUS_ANY, 0, 1);

			MBMessage mbMessage = messages.get(0);
			String subject = mbMessage.getSubject();
			Long parentId = mbMessage.getRootMessageId();

			List<ObjectValuePair<String, InputStream>> files = new ArrayList<ObjectValuePair<String, InputStream>>();
			boolean anonymous = Boolean.FALSE;
			double priority = mbMessage.getPriority();
			boolean allowPingbacks = Boolean.TRUE;

			MBMessageLocalServiceUtil.addMessage(
				themeDisplay.getUser().getUserId(), themeDisplay.getUser().getFullName(), mbMessage.getGroupId(), mbMessage.getThread().getCategoryId(), mbMessage.getThreadId(), parentId,
				subject, threadBody, MBMessageConstants.DEFAULT_FORMAT, files, anonymous, priority, allowPingbacks, serviceContext);

		}
		catch (PortalException e)
		{
			LOGGER.error("FileSizeException:" + e.getLocalizedMessage(), e);
		}
		catch (SystemException e)
		{
			LOGGER.error(e.getLocalizedMessage(), e);
		}
		sendRedirect(request, response);
	}

}
