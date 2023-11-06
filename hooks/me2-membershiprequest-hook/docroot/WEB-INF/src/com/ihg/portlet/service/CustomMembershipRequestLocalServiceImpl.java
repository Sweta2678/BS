package com.ihg.portlet.service;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletRequest;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.MembershipRequestCommentsException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncStringWriter;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.MembershipRequest;
import com.liferay.portal.model.MembershipRequestConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.MembershipRequestLocalService;
import com.liferay.portal.service.MembershipRequestLocalServiceUtil;
import com.liferay.portal.service.MembershipRequestLocalServiceWrapper;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.ContentUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Group;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

/**
 * @author patelhet
 * This hook is added to stop LR OOTB notification while asking for Member request
 */
public class CustomMembershipRequestLocalServiceImpl extends MembershipRequestLocalServiceWrapper
{
    private static Log _log = LogFactoryUtil.getLog(CustomMembershipRequestLocalServiceImpl.class);

    public CustomMembershipRequestLocalServiceImpl(MembershipRequestLocalService membershipRequestLocalService)
    {
        super(membershipRequestLocalService);
    }

    @Override
    public MembershipRequest addMembershipRequest(long userId, long groupId, String comments, ServiceContext serviceContext) throws PortalException,
            SystemException
    {
    	
        String communityName = GroupLocalServiceUtil.getGroup(groupId).getName();
        if (isHookExcludedForCommunity(communityName))
        {
            _log.info("calling OOTB addMembershipRequest method for group :- " + communityName);
            return super.addMembershipRequest(userId, groupId, comments, serviceContext);
        }
        _log.info("calling Custom  addMembershipRequest method for group :- " + communityName);
        User user = UserLocalServiceUtil.getUser(userId);
		Date now = new Date();

		validate(comments);

		long membershipRequestId = CounterLocalServiceUtil.increment();

		MembershipRequest membershipRequest = MembershipRequestLocalServiceUtil
	                .createMembershipRequest(membershipRequestId);

		membershipRequest.setCompanyId(user.getCompanyId());
		membershipRequest.setUserId(userId);
		membershipRequest.setCreateDate(now);
		membershipRequest.setGroupId(groupId);
		membershipRequest.setComments(comments);
		membershipRequest.setStatusId(MembershipRequestConstants.STATUS_PENDING);

		MembershipRequestLocalServiceUtil.updateMembershipRequest(membershipRequest);

		return membershipRequest;
    }

    @Override
	public void updateStatus(
			long replierUserId, long membershipRequestId, String replyComments,
			int statusId, boolean addUserToGroup, ServiceContext serviceContext)
		throws PortalException, SystemException {

		MembershipRequest membershipRequest = MembershipRequestLocalServiceUtil.getMembershipRequest(membershipRequestId);
		Group group = GroupLocalServiceUtil.getGroup(membershipRequest.getGroupId());
		String communityName = group.getName();
		if (isHookExcludedForCommunity(communityName))
		{
		    _log.info("calling OOTB updateStatus method for group :- " + communityName);
		    super.updateStatus(replierUserId, membershipRequestId, replyComments, statusId, addUserToGroup, serviceContext);
		}

		membershipRequest.setReplyComments(replyComments);
		membershipRequest.setReplyDate(new Date());

		if (replierUserId != 0) {
			membershipRequest.setReplierUserId(replierUserId);
		}
		else {
			long defaultUserId = UserLocalServiceUtil.getDefaultUserId(
				membershipRequest.getCompanyId());

			membershipRequest.setReplierUserId(defaultUserId);
		}

		membershipRequest.setStatusId(statusId);

		MembershipRequestLocalServiceUtil.updateMembershipRequest(membershipRequest);

		if ((statusId == MembershipRequestConstants.STATUS_APPROVED) &&
			addUserToGroup) {

			long[] addUserIds = new long[] {membershipRequest.getUserId()};

			UserLocalServiceUtil.addGroupUsers(
				membershipRequest.getGroupId(), addUserIds);
		}

		if (replierUserId != 0) {
	        User replierUser = UserLocalServiceUtil.getUser(replierUserId);
            String replierUserEmailId = replierUser.getEmailAddress();
            User requesterUser = UserLocalServiceUtil.getUser(membershipRequest.getUserId());
            String requesterUserEmailId = requesterUser.getEmailAddress();
            String requesterUserName = requesterUser.getFullName();
            String status = "Approved";
            if (statusId == MembershipRequestConstants.STATUS_DENIED)
            {
                status = "Rejected";
            }
            String url = getURL(statusId, group, serviceContext);
            sendEmailToRequester(replierUserEmailId, requesterUserEmailId, communityName, requesterUserName, status,
                    replyComments, url);
            _log.info("Email sent to :- " + requesterUserEmailId);
		}
	}
    
    private String getURL(int statusId, Group group, ServiceContext serviceContext) 
    {
    	String url = StringPool.BLANK;
    	final String TEAMSPACE_MEMBER_LANDING_PAGE = "member";
    	final String TEAMSPACE_NON_MEMBER_LANDING_PAGE = "home";
    	
		String env = System.getProperty("app.environment.type");
		String portalURL = StringPool.BLANK;
		if(Validator.isNotNull(env)){
			if(env.toLowerCase().contains("qa")){
				portalURL = "https://me2qa.ihgmerlin.com";
			}
			else if(env.toLowerCase().contains("prod")){
				portalURL = "https://me2.ihgmerlin.com";
			}
		}
    	
    	try {
    		
    		if (statusId == MembershipRequestConstants.STATUS_DENIED) {
    			if (group.hasPublicLayouts()) {
    				String communityUrl = group.getFriendlyURL();
    				Layout pageLayout = getPageLayout(
    						TEAMSPACE_NON_MEMBER_LANDING_PAGE,
    						group.getGroupId(), false);
    				if (pageLayout != null) {
    					String pageURL = pageLayout.getFriendlyURL();
    					url = portalURL + "/web" + communityUrl + pageURL;
    				}
    			}
    		} else {
    			if (group.hasPrivateLayouts()) {
    				String communityUrl = group.getFriendlyURL();
    				Layout pageLayout = getPageLayout(
    						TEAMSPACE_MEMBER_LANDING_PAGE,
    						group.getGroupId(), true);
    				if (pageLayout != null) {
    					String pageURL = pageLayout.getFriendlyURL();
    					url = portalURL + "/group" + communityUrl + pageURL;
    				}
    			}
    		}
    	} catch (Exception e) {
    		_log.error("Exception thrown from CustomMembershipRequestLocalServiceImpl :: getURL() " + e.getMessage(), e);
    	}
    	_log.debug("CustomMembershipRequestLocalServiceImpl :: getURL() , URL is " + url);
    	return url;
    }
	/**
	 * Get layout from pageName
	 * 
	 * @param pageName
	 * @param groupId
	 */
	public static Layout getPageLayout(String pageName, long groupId, boolean pageType) {
		List<Layout> layoutList = null;
		Layout pageLayout = null;
		try {
			layoutList = LayoutLocalServiceUtil.getLayouts(groupId, pageType);
			for (Layout layout : layoutList) {
				if (layout.getName(Locale.US).equalsIgnoreCase(pageName)) {
					pageLayout = layout;
					break;
				}
				List<Layout> childLayouts = (List<Layout>) layout
						.getAllChildren();
				for (Layout childLayout : childLayouts) {
					if (childLayout.getName(Locale.US).equalsIgnoreCase(
							pageName)) {
						pageLayout = childLayout;
						break;
					}
				}
			}
		} catch (Exception e) {
			_log.error("Exception thrown from CustomMembershipRequestLocalServiceImpl :: getPageLayout() " + e.getMessage(), e);
		}

		return pageLayout;
	}
    /**
     * @param from
     * @param to
     * @param tsName
     * @param requesterName
     * @param status
     * @param comment
     */
    private void sendEmailToRequester(String from, String to, String tsName, String requesterName, String status,
            String comment, String url)
    {
        try
        {
            MailMessage mailMessage = new MailMessage(new InternetAddress(from),
                    "Reply to the membership request for community  : " + tsName, "", false);
            mailMessage.setHTMLFormat(false);
            mailMessage.setFrom(new InternetAddress(PropsUtil.get("ihg.from.email.address")));
            mailMessage.setTo(new InternetAddress(to));
            mailMessage.setCC(new InternetAddress(from));
            String content = ContentUtil.get("/content/membershipReplyEmailTemplate.vm");
            UnsyncStringWriter unsyncStringWriter = new UnsyncStringWriter();
            VelocityContext context = new VelocityContext();
            context.put("requesterName", requesterName);
            context.put("groupName", tsName);
            context.put("status", status);
            context.put("comment", comment);
            context.put("url", url);
            Velocity.evaluate(context, unsyncStringWriter, CustomMembershipRequestLocalServiceImpl.class.getName(),
                    content);
            mailMessage.setBody(unsyncStringWriter.toString());
            MailServiceUtil.sendEmail(mailMessage);
        } catch (AddressException e)
        {
            e.printStackTrace();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * @param comments
     * @throws PortalException
     */
	protected void validate(String comments) throws PortalException {
		if (Validator.isNull(comments) || Validator.isNumber(comments)) {
			throw new MembershipRequestCommentsException();
		}
	}

    /**
     * @param name
     * @return true if community name specified in Portal-ext or false
     */
    private boolean isHookExcludedForCommunity(String name)
    {
        boolean flag = false;
        String groupName = PropsUtil.get("excluded.membershiprequest.email.notification.community.name");
        _log.info("Excluded Groups from memebership email notification :- " + groupName);
        if (Validator.isNotNull(groupName))
        {
            String[] communities = groupName.split(",");
            for (int i = 0; i < communities.length; i++)
            {
                if (name.equalsIgnoreCase(communities[i].trim()))
                {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

}
