
package com.ihg.grs.portlet;

import com.ihg.grs.bean.ArticleInfoBean;
import com.ihg.grs.bean.MessagePojo;
import com.ihg.grs.constant.ApplicationConstants;
import com.ihg.grs.util.ArticleUtil;
import com.ihg.me2.core.service.CoreArticleLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

/**
 * Portlet implementation class ArticleDetailPortlet.
 * Retrieving Article Id from parameter and setting Article Information Details through Article Info Bean
 */
public class ArticleDetailPortlet extends MVCPortlet
{

	private static final Log LOGGER = LogFactoryUtil.getLog(ArticleDetailPortlet.class);


	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
	{
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletPreferences prefs = renderRequest.getPreferences();
		List<ArticleInfoBean> articleInfoList = new ArrayList<ArticleInfoBean>();
		ArticleInfoBean articleInfo = null;
		List<JournalArticle> articleList = new ArrayList<JournalArticle>();
		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		String articleId = StringPool.BLANK;
		boolean isCommentVisibility = Boolean.FALSE;
		int start = 0;
		int end = 0;
		int noOfCommentDisplay = 0;
		int webContentId = 0;

		try
		{

			articleId = httpReq.getParameter(ApplicationConstants.ARTICLE_DETAIL_ARTICLE_ID);

			if (Validator.isNotNull(prefs))
			{

				if (Validator.isNull(articleId))
				{
					articleId = prefs.getValue(ApplicationConstants.ARTICLE_ID, StringPool.BLANK);
				}
				isCommentVisibility = Boolean.parseBoolean(prefs.getValue(ApplicationConstants.COMMENT_VISIBILITY, Boolean.FALSE.toString()));
				noOfCommentDisplay = Integer.parseInt(prefs.getValue(ApplicationConstants.NO_OF_DISPLAY_COMMENT, "0"));
				webContentId = Integer.parseInt(prefs.getValue(ApplicationConstants.COMMENT_POLICY_WEBCONTENT_ID, "0"));
			}

			if (Validator.isNotNull(articleId))
			{
				JournalArticle article = JournalArticleLocalServiceUtil.getLatestArticle(themeDisplay.getScopeGroupId(), articleId);

				articleList.add(article);
				articleInfoList = ArticleUtil.getArticleInfoFromArticleList(themeDisplay, articleList);
				if (isCommentVisibility)
				{
					int articleCommentCount =
						ArticleUtil.getCommentCount(themeDisplay, themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), JournalArticle.class.getName(), article.getResourcePrimKey());

					if (noOfCommentDisplay > 0)
					{

						if (articleCommentCount > noOfCommentDisplay)
						{
							start = articleCommentCount - noOfCommentDisplay;
						}
						end = start + noOfCommentDisplay;

					}

					List<MessagePojo> treeList =
						ArticleUtil.getArticleCommentsList(themeDisplay, themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), JournalArticle.class.getName(), article.getResourcePrimKey());
					if (!treeList.isEmpty())
					{
						treeList = ListUtil.subList(treeList, start, end);
						Collections.reverse(treeList);
						renderRequest.setAttribute("treeList", treeList);
						renderRequest.setAttribute("articleCommentCount", articleCommentCount);
						renderRequest.setAttribute("noOfCommentDisplay", noOfCommentDisplay);
					}
				}
			}

			if (!articleInfoList.isEmpty() && articleInfoList.size() > 0)
			{
				articleInfo = articleInfoList.get(0);
			}

			renderRequest.setAttribute("article", articleInfo);
			String preferredName=ArticleUtil.getPreferredNamebyUserId(themeDisplay.getUserId(),true);
			renderRequest.setAttribute("userFullName",preferredName);
			renderRequest.setAttribute("userImageUrl", ArticleUtil.getImageUrl(themeDisplay.getUserId(), themeDisplay));
			renderRequest.setAttribute("isCommentVisibility", isCommentVisibility);
			renderRequest.setAttribute("commentPolicyArticleId", webContentId);
			super.doView(renderRequest, renderResponse);

		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage(), e);
		}
	}

	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse)
	{
		try
		{
			PortletPreferences prefs = renderRequest.getPreferences();
			if (Validator.isNotNull(prefs))
			{
				String articleId = prefs.getValue(ApplicationConstants.ARTICLE_ID, StringPool.BLANK);
				renderRequest.setAttribute(ApplicationConstants.ARTICLE_ID, articleId);
				String webcontentId = prefs.getValue(ApplicationConstants.COMMENT_POLICY_WEBCONTENT_ID, "0");
				renderRequest.setAttribute(ApplicationConstants.COMMENT_POLICY_WEBCONTENT_ID, webcontentId);
				boolean visibility = Boolean.parseBoolean(prefs.getValue(ApplicationConstants.COMMENT_VISIBILITY, Boolean.FALSE.toString()));
				renderRequest.setAttribute(ApplicationConstants.COMMENT_VISIBILITY, visibility);
				String noOfDisplayComment = prefs.getValue(ApplicationConstants.NO_OF_DISPLAY_COMMENT, "0");
				renderRequest.setAttribute(ApplicationConstants.NO_OF_DISPLAY_COMMENT, noOfDisplayComment);
			}
			super.doEdit(renderRequest, renderResponse);
		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage(), e);
		}
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException
	{
		String resourceID = resourceRequest.getResourceID();
		String requestType = resourceRequest.getParameter("requestType");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if (requestType != null && "shareContent".equals(requestType))
		{
			shareContent(resourceRequest);
		}
		else if (Validator.isNotNull(resourceID) && "loadMoreForComments".equals(resourceID))
		{
			long classPK = ParamUtil.getLong(resourceRequest, "classPK");
			HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));

			int startPosition = ParamUtil.getInteger(httpRequest, "start");
			int endPosition = ParamUtil.getInteger(httpRequest, "end");

			try
			{
				List<MessagePojo> treeList = ArticleUtil.getArticleCommentsList(themeDisplay, themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), JournalArticle.class.getName(), classPK);
				if (!treeList.isEmpty())
				{
					Collections.reverse(treeList);
					treeList = ListUtil.subList(treeList, startPosition, endPosition);
					resourceRequest.setAttribute("treeList", treeList);
				}
				include("/html/articledetail/comment-list.jsp", resourceRequest, resourceResponse);
			}
			catch (Exception e)
			{
				LOGGER.error("Error while retrive message : " + e.getMessage());
			}
		}

	}

	/**
	 * Setting preferences for Article Listing Portlet.
	 * 
	 * @param actionRequest
	 *            Action request is passed when Preferences saved.
	 * @param actionResponse
	 *            After saving action response is passing response.
	 */
	public void editPreferences(ActionRequest actionRequest, ActionResponse actionResponse)
	{
		try
		{
			PortletPreferences portletPreferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);
			portletPreferences.setValue(ApplicationConstants.ARTICLE_ID, ParamUtil.getString(actionRequest, ApplicationConstants.PREF_ARTICLE_ID, StringPool.BLANK));
			portletPreferences.setValue(ApplicationConstants.COMMENT_POLICY_WEBCONTENT_ID, ParamUtil.getString(actionRequest, ApplicationConstants.PREF_COMMENT_POLICY_WEBCONTENT_ID, "0"));

			Boolean visibility = ParamUtil.getBoolean(actionRequest, ApplicationConstants.PREF_COMMENT_VISIBILITY, Boolean.FALSE);
			portletPreferences.setValue(ApplicationConstants.COMMENT_VISIBILITY, visibility.toString());
			portletPreferences.setValue(ApplicationConstants.NO_OF_DISPLAY_COMMENT, ParamUtil.getString(actionRequest, ApplicationConstants.PREF_NO_OF_DISPLAY_COMMENT, "0"));
			portletPreferences.store();

		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * This method is used for comments Article Detail page.
	 * @param request with parameter
	 * @param response redirect to jsp page 
	 */
	public void addNewComment(ActionRequest request, ActionResponse response)
	{
		try
		{
			HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
			String className = ParamUtil.getString(request, "className");
			long classPK = ParamUtil.getLong(request, "classPK");
			String subject = ParamUtil.getString(request, "subject");
			String body = ParamUtil.getString(httpReq, "body");
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(MBMessage.class.getName(), request);
			CoreArticleLocalServiceUtil.addNewComment(subject, body, themeDisplay, className, classPK, PropsUtil.get("discussion.thread.view"), serviceContext);
			response.sendRedirect(ParamUtil.getString(request, "renderJspPage"));
		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * Share content via email.
	 * 
	 * @param resourceRequest
	 *            Resource request.
	 */
	private void shareContent(ResourceRequest resourceRequest)
	{
		try
		{
			MailMessage mailMsg = new MailMessage();
			boolean htmlFormat = true;
			mailMsg.setHTMLFormat(htmlFormat);
			
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String username=themeDisplay.getUser().getFirstName()+StringPool.SPACE+themeDisplay.getUser().getLastName();
			String useremailaddress=themeDisplay.getUser().getEmailAddress();
			
			HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
			String strAddresses = ParamUtil.getString(httpRequest, "toAddresses");
			String contentTitle = ParamUtil.getString(httpRequest, "contentTitle");
			String contentURL = ParamUtil.getString(httpRequest, "contentURL").concat("<br>" + "<br>" + "From," + "<br>" + username + "<br>" + useremailaddress + "<br>");
			String[] toAddresses = strAddresses.split(",");
			ArticleUtil.sendMail(resourceRequest, toAddresses, contentTitle, contentURL, false);
		}
		catch (Exception e)
		{
			LOGGER.info("Exception in shareContent: " + e.getMessage());
		}
	}

}
