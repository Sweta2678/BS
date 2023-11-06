package com.ihg.portlet.security.community;

import com.ihg.portlet.security.util.SecurityConstants;
import com.ihg.portlet.security.util.SecurityUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.service.GroupLocalService;
import com.liferay.portal.service.GroupLocalServiceWrapper;
import com.liferay.portal.service.ServiceContext;

public class CustomGroupLocalServiceImpl extends GroupLocalServiceWrapper {
	/* (non-Java-doc)
	 * @see com.liferay.portal.service.GroupLocalServiceWrapper#GroupLocalServiceWrapper(GroupLocalService groupLocalService)
	 */
	private final static Log LOG_4 = LogFactoryUtil.getLog(CustomGroupLocalServiceImpl.class);
	public CustomGroupLocalServiceImpl(GroupLocalService groupLocalService) {
		super(groupLocalService);
	}
	
	@Override
	public Group addGroup(
			long userId, long parentGroupId, String className, long classPK,
			long liveGroupId, String name, String description, int type,
			boolean manualMembership, int membershipRestriction,
			String friendlyURL, boolean site, boolean active,
			ServiceContext serviceContext)
		throws PortalException, SystemException {
		
		Group group = super.addGroup(
				userId, GroupConstants.DEFAULT_PARENT_GROUP_ID, className, classPK,
				GroupConstants.DEFAULT_LIVE_GROUP_ID, name, description, type, true,
				GroupConstants.DEFAULT_MEMBERSHIP_RESTRICTION, friendlyURL, site,
				active, serviceContext);
		
		/*
		 * Below code is to add the default category for the community 
		 * by checking the condition as community having merlin and community specific tags while creating the community.
		 */
		try{
			if(!group.isOrganization() && SecurityUtil.isCommunityHavingMerlinTagAndCommunityTag(group, SecurityConstants.COMMUNITY_TAGS_FOR_GROUP_LIST)){
					SecurityUtil.addDefaultCategoriesToCommunity(group,userId);
			}
		}catch(Exception e){
			LOG_4.error("Unable to add default category to the community while creating a community."+e.getMessage());
		}
		return group;
	}
	
	@Override
	public Group updateGroup(
			long groupId, long parentGroupId, String name, String description,
			int type, boolean manualMembership, int membershipRestriction,
			String friendlyURL, boolean active, ServiceContext serviceContext)
		throws PortalException, SystemException {
		
		Group group = super.updateGroup(groupId, parentGroupId, name, description, type, manualMembership, membershipRestriction,
								friendlyURL, active, serviceContext);
		
		/*
		 * Below code is to add the default category for the community 
		 * by checking the condition as community having merlin and community specific tags while updating the community.
		 */
		try{
			if(!group.isOrganization() && SecurityUtil.isCommunityHavingMerlinTagAndCommunityTag(group, SecurityConstants.COMMUNITY_TAGS_FOR_GROUP_LIST)){
					SecurityUtil.addDefaultCategoriesToCommunity(group,group.getCreatorUserId());
			}
		}catch(Exception e){
			LOG_4.error("Unable to add the default category to the community while updating the community."+e.getMessage());
		}
		return group;
	}

}
