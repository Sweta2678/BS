package com.ihg.me2.service;

import com.ihg.me2.service.indexer.util.CommunityIndexerUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalService;
import com.liferay.portal.service.GroupLocalServiceWrapper;
import com.liferay.portal.service.ServiceContext;

/**
 * @author PatelHet
 *
 */
public class CustomGroupLocalServiceImpl extends GroupLocalServiceWrapper
{
	
	private static Log _log = LogFactoryUtil.getLog(CustomGroupLocalServiceImpl.class);
	
	static
	{
		/* Registering Group Indexer Object on class load*/
		CommunityIndexerUtil.getOrRegisterGroupIndexer();
	}
	
	public CustomGroupLocalServiceImpl(GroupLocalService groupLocalService) 
	{
		super(groupLocalService);
	}

	@Override
	public Group addGroup(long userId, long parentGroupId, String className,
			long classPK, long liveGroupId, String name, String description,
			int type, boolean manualMembership, int membershipRestriction,
			String friendlyURL, boolean site, boolean active,
			ServiceContext serviceContext) throws PortalException,
			SystemException 
	{
		return super.addGroup(userId, parentGroupId, className, classPK, liveGroupId,
				name, description, type, manualMembership, membershipRestriction,
				friendlyURL, site, active, serviceContext);
	}

	@Override
	public Group updateGroup(long groupId, long parentGroupId, String name,
			String description, int type, boolean manualMembership,
			int membershipRestriction, String friendlyURL, boolean active,
			ServiceContext serviceContext) throws PortalException,
			SystemException 
	{
		
		Group group= super.updateGroup(groupId, parentGroupId, name, description, type,
				manualMembership, membershipRestriction, friendlyURL, active,
				serviceContext);
		
		try
		{
			/*Calling Indexer to create Indexes*/
			CommunityIndexerUtil.craeteGroupIndex(group);
		}catch(Exception e)
		{
			_log.error("Error in creating Group Index "+ e);
		}
		
		return group;
	}

	
	@Override
	public Group deleteGroup(Group group) throws PortalException,SystemException
	{
		try
		{
			/*Calling Indexer to delete Group index*/
			CommunityIndexerUtil.deleteGroupIndex(group);
		}catch(Exception e)
		{
			_log.error("Error in deleting Group Index "+ e);
		}
		
		return super.deleteGroup(group);
	}

	@Override
	public Group deleteGroup(long groupId) throws PortalException,	SystemException 
	{
		try
		{
		/*Calling Indexer to delete Group index*/
		CommunityIndexerUtil.deleteGroupIndex(groupId);
		
		}catch(Exception e)
		{
			_log.error("Error in deleting Group Index "+ e);
		}
		
		return super.deleteGroup(groupId);
	}

	
}
