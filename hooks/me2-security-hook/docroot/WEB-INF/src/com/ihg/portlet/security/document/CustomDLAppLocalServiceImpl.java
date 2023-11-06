package com.ihg.portlet.security.document;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.ihg.portlet.security.util.SecurityConstants;
import com.ihg.portlet.security.util.SecurityUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RepositoryLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppLocalService;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceWrapper;

public class CustomDLAppLocalServiceImpl extends DLAppLocalServiceWrapper  {

	private final static Log LOG_4 = LogFactoryUtil.getLog(CustomDLAppLocalServiceImpl.class);
	
	public CustomDLAppLocalServiceImpl(DLAppLocalService dLAppLocalService) {
		super(dLAppLocalService);
	}
	
	@Override
	public FileEntry addFileEntry(
			long userId, long repositoryId, long folderId,
			String sourceFileName, String mimeType, String title,
			String description, String changeLog, byte[] bytes,
			ServiceContext serviceContext)
		throws PortalException, SystemException 
		{
		
		/*Code to Process Image/Video file for Merlin related communities and All Organizations --- START*/
		try
		{
			long groupId =0;
			try
			{
				 groupId =RepositoryLocalServiceUtil.getRepository(repositoryId).getGroupId();
				 
			}catch(Exception e)
			{
				groupId = serviceContext.getScopeGroupId();
				
				if(LOG_4.isDebugEnabled())
				{
					LOG_4.debug(e.getMessage() + " Hence fetched groupId from service context -- groupId:-"+ groupId);
				}
			}
			
			if(Validator.isNotNull(groupId) && groupId!=0)
			{
				Group group = GroupLocalServiceUtil.getGroup(groupId);
				
				if(ImageCompressionUtil.isOrgOrMerlinCommunity(group) && ImageCompressionUtil.isVideoOrImage(mimeType))
				{
					if(LOG_4.isDebugEnabled())
					{
						LOG_4.debug("It's a Merlin site or Organization hence start compressing Image for groupId:-"+ groupId);
					}
					try
					{
						if(Validator.isNotNull(bytes))
						{
								long st = System.currentTimeMillis();
								
								File file = ImageCompressionUtil.compressImageOrVideo(mimeType, bytes) ;
								
								 //Converting file back to byte array after processing
							    bytes = ImageCompressionUtil.fileToByte(file);
							    
								long et = System.currentTimeMillis();
								
								if(LOG_4.isDebugEnabled())
								{
									LOG_4.debug("Time to process video/file is:-- "+ (et-st) +" in ms from groupId:-"+ groupId);
								}
						}else
						{
							if(LOG_4.isDebugEnabled())
							{
								LOG_4.debug("File is null from groupId:-"+ groupId);
							}
						}
					}catch(Exception e)
					{
						LOG_4.error(e.getMessage(),e);
					}
				}
			}else
			{
				if(LOG_4.isDebugEnabled())
				{
						LOG_4.debug("GroupId is not valid ---"+ groupId +"  Hence not compressing Image");
				}
			}
		}
		catch(Exception e)
		{
			LOG_4.error("Problem in Compressing Image or Video for Merlin site ......" + e.getMessage());
		}
		/*Code to Process Image/Video file for Merlin related communities and All Organizations --- END*/
		
		FileEntry dlfileEntry = super.addFileEntry(
				userId, repositoryId, folderId,
				sourceFileName, mimeType, title,
				description, changeLog, bytes,
				serviceContext);
		//Changing to see how it works
		LOG_4.info("Document uploaded successfully by Super1");
		
		try{
			
			Group group = GroupLocalServiceUtil.getGroup(dlfileEntry.getGroupId());
			
			if(group.isOrganization()) 
			{
				SecurityUtil.addDefaultCategoryAndRole(userId, group, dlfileEntry);
			}else if(SecurityUtil.isCommunityHavingMerlinTagAndCommunityTag(group, SecurityConstants.COMMUNITY_TAGS_LIST)){
				
				 // Below code is to assign default role and default category to the document.
				 
				SecurityUtil.addDefaultCategoriesToModel(userId, SecurityUtil.getGlobalGroupId(), group, DLFileEntry.class.getName(), dlfileEntry.getFileEntryId());
				
				SecurityUtil.updateRoles(dlfileEntry);
				
			}
		}catch(PortalException e){
			LOG_4.error("Unable to add default role and category while uploading the document."+e.getMessage());
		}
		return dlfileEntry;
	}
		
	@Override
	public FileEntry addFileEntry(
			long userId, long repositoryId, long folderId,
			String sourceFileName, String mimeType, String title,
			String description, String changeLog, File file,
			ServiceContext serviceContext)
		throws PortalException, SystemException 
		{
		/*Code to Process Image/Video file for Merlin related communities and All Organizations --- START*/
		try
		{
			long groupId =0;
			try
			{
				 groupId =RepositoryLocalServiceUtil.getRepository(repositoryId).getGroupId();
				 
			}catch(Exception e)
			{
				groupId = serviceContext.getScopeGroupId();
				
				if(LOG_4.isDebugEnabled())
				{
					LOG_4.debug(e.getMessage() + " Hence fetched groupId from service context -- groupId:-"+ groupId);
				}
			}
			
			if(Validator.isNotNull(groupId) && groupId!=0)
			{
				Group group = GroupLocalServiceUtil.getGroup(groupId);
				
				if(ImageCompressionUtil.isOrgOrMerlinCommunity(group) && ImageCompressionUtil.isVideoOrImage(mimeType))
				{
					if(LOG_4.isDebugEnabled())
					{
						LOG_4.debug("It's a Merlin site or Organization hence start compressing Image for groupId:-"+ groupId);
					}
					try
					{
						if(Validator.isNotNull(file))
						{
								long st = System.currentTimeMillis();
								
								file = ImageCompressionUtil.compressImageOrVideo(mimeType, file) ;
								
								long et = System.currentTimeMillis();
								
								if(LOG_4.isDebugEnabled())
								{
									LOG_4.debug("Time to process video/file is:-- "+ (et-st) +" in ms from groupId:-"+ groupId);
								}
						}else
						{
							if(LOG_4.isDebugEnabled())
							{
								LOG_4.debug("File is null from groupId:-"+ groupId);
							}
						}
					}catch(Exception e)
					{
						LOG_4.error(e.getMessage(),e);
					}
				}
			}else
			{
				if(LOG_4.isDebugEnabled())
				{
						LOG_4.debug("GroupId is not valid ---"+ groupId +"  Hence not compressing Image");
				}
			}
		}
		catch(Exception e)
		{
			LOG_4.error("Problem in Compressing Image or Video for Merlin site ......" + e.getMessage());
		}
		/*Code to Process Image/Video file for Merlin related communities and All Organizations --- END*/
		
		FileEntry dlfileEntry = super.addFileEntry(
				userId, repositoryId, folderId,
				sourceFileName, mimeType, title,
				description, changeLog, file, serviceContext);
		
		LOG_4.info("Document uploaded successfully by Super2");
		
		try{
			
			Group group = GroupLocalServiceUtil.getGroup(dlfileEntry.getGroupId());
			
			if(group.isOrganization()) 
			{
				SecurityUtil.addDefaultCategoryAndRole(userId, group, dlfileEntry);
				
			}else if(SecurityUtil.isCommunityHavingMerlinTagAndCommunityTag(group, SecurityConstants.COMMUNITY_TAGS_LIST))
			{
				 // Below code is to assign default role and default category to the document.
				 
				SecurityUtil.addDefaultCategoriesToModel(userId, SecurityUtil.getGlobalGroupId(), group, DLFileEntry.class.getName(), dlfileEntry.getFileEntryId());
				
				SecurityUtil.updateRoles(dlfileEntry);
				
			}
		}catch(PortalException e){
			LOG_4.error("Unable to add default role and category while uploading the document."+e.getMessage());
		}
		return dlfileEntry;
	}
	
	@Override
	public FileEntry addFileEntry(
			long userId, long repositoryId, long folderId,
			String sourceFileName, String mimeType, String title,
			String description, String changeLog, InputStream is, long size,
			ServiceContext serviceContext)
		throws PortalException, SystemException 
		{
		
		/*Code to Process Image/Video file for Merlin related communities and All Organizations --- START*/
		try
		{
			/*Fetching groupId from service-context. It is expected that service-context should have set scope groupId*/
			long groupId = serviceContext.getScopeGroupId();
			
			if(Validator.isNotNull(groupId) && groupId!=0)
			{
				Group group = GroupLocalServiceUtil.getGroup(groupId);
				
				if(ImageCompressionUtil.isOrgOrMerlinCommunity(group) && ImageCompressionUtil.isVideoOrImage(mimeType))
				{
					if(LOG_4.isDebugEnabled())
					{
						LOG_4.debug("It's a Merlin site or Organization hence start compressing Image for groupId:-"+ groupId);
					}
					
					try
					{
						if(Validator.isNotNull(is))
						{
								long st = System.currentTimeMillis();
								
								File file = ImageCompressionUtil.compressImageOrVideo(mimeType, is) ;
								
								// Converting file back to InputStream
								try 
								{
									is = new FileInputStream(file);
									size=file.length();
								} catch (FileNotFoundException e) 
								{
									e.printStackTrace();
								}
								
								long et = System.currentTimeMillis();
								
								if(LOG_4.isDebugEnabled())
								{
									LOG_4.debug("Time to process video/file is:-- "+ (et-st) +" in ms from groupId:-"+ groupId);
								}
						}else
						{
							if(LOG_4.isDebugEnabled())
							{
								LOG_4.debug("File is null from groupId:-"+ groupId);
							}
						}
					}catch(Exception e)
					{
						LOG_4.error(e.getMessage(),e);
					}
				}
			}else
			{
				if(LOG_4.isDebugEnabled())
				{
						LOG_4.debug("GroupId is not valid ---"+ groupId +"  Hence not compressing Image");
				}
			}
		}
		catch(Exception e)
		{
			LOG_4.error("Problem in Compressing Image or Video for Merlin site ......" + e.getMessage());
		}
		/*Code to Process Image/Video file for Merlin related communities and All Organizations --- END*/
		
		FileEntry dlfileEntry = super.addFileEntry(
				userId, repositoryId, folderId,	sourceFileName, mimeType, title,
				description, changeLog, is, size, serviceContext);
		
		LOG_4.info("Document uploaded successfully by Super3");
		
		try{
			
			Group group = GroupLocalServiceUtil.getGroup(dlfileEntry.getGroupId());
			
			if(group.isOrganization()) 
			{
				
				SecurityUtil.addDefaultCategoryAndRole(userId, group, dlfileEntry);
				
			}else if(SecurityUtil.isCommunityHavingMerlinTagAndCommunityTag(group, SecurityConstants.COMMUNITY_TAGS_LIST))
			{
				 // Below code is to assign default role and default category to the document.
				 
				SecurityUtil.addDefaultCategoriesToModel(userId, SecurityUtil.getGlobalGroupId(), group, DLFileEntry.class.getName(), dlfileEntry.getFileEntryId());
				
				SecurityUtil.updateRoles(dlfileEntry);
				
			}
		}catch(PortalException e){
			LOG_4.error("Unable to add default role and category while uploading the document."+e.getMessage());
		}
		return dlfileEntry;
	}
			
	@Override
	public FileEntry updateFileEntry(
			long userId, long fileEntryId, String sourceFileName,
			String mimeType, String title, String description, String changeLog,
			boolean majorVersion, byte[] bytes, ServiceContext serviceContext)
		throws PortalException, SystemException {
		
		FileEntry dlfileEntry = super.updateFileEntry(
				userId, fileEntryId, sourceFileName, mimeType, title, description, changeLog,
				majorVersion, bytes, serviceContext);
		
		LOG_4.info("Document uploaded successfully by Super4");
		try{
			Group group = GroupLocalServiceUtil.getGroup(dlfileEntry.getGroupId());
			if(group.isOrganization()) 
			{
				SecurityUtil.addDefaultCategoryAndRole(userId, group, dlfileEntry);
			}else{
				if(SecurityUtil.isCommunityHavingMerlinTagAndCommunityTag(group, SecurityConstants.COMMUNITY_TAGS_LIST)){
					
					// Below code is to assign default role and default category to the document.
					
					SecurityUtil.addDefaultCategoriesToModel(userId, SecurityUtil.getGlobalGroupId(), group, DLFileEntry.class.getName(), dlfileEntry.getFileEntryId());
					
					SecurityUtil.updateRoles(dlfileEntry);
				}
			}
		}catch(PortalException e){
			LOG_4.error("Unable to add the default role and category while updating the document."+e.getMessage());
		}
		return dlfileEntry;
	}
	
	@Override
	public FileEntry updateFileEntry(
			long userId, long fileEntryId, String sourceFileName,
			String mimeType, String title, String description, String changeLog,
			boolean majorVersion, File file, ServiceContext serviceContext)
		throws PortalException, SystemException {
		
		FileEntry dlfileEntry = super.updateFileEntry(
				userId, fileEntryId, sourceFileName, mimeType, title, description, changeLog,
				majorVersion, file, serviceContext);
		LOG_4.info("Document uploaded successfully by Super5");
		try{
			Group group = GroupLocalServiceUtil.getGroup(dlfileEntry.getGroupId());
			
			if(group.isOrganization()) {
				
				SecurityUtil.addDefaultCategoryAndRole(userId, group, dlfileEntry);
			}else{
				if(SecurityUtil.isCommunityHavingMerlinTagAndCommunityTag(group, SecurityConstants.COMMUNITY_TAGS_LIST)){
					
					// Below code is to assign default role and default category to the document.
					
					SecurityUtil.addDefaultCategoriesToModel(userId, SecurityUtil.getGlobalGroupId(), group, DLFileEntry.class.getName(), dlfileEntry.getFileEntryId());
					
					SecurityUtil.updateRoles(dlfileEntry);
				}
			}
		}catch(PortalException e){
			LOG_4.error("Unable to add the default role and category while updating the document."+e.getMessage());
		}
		return dlfileEntry;
	}
	
	@Override
	public FileEntry updateFileEntry(
			long userId, long fileEntryId, String sourceFileName,
			String mimeType, String title, String description, String changeLog,
			boolean majorVersion, InputStream is, long size,
			ServiceContext serviceContext)
		throws PortalException, SystemException {
		
		FileEntry dlfileEntry = super.updateFileEntry(
				userId, fileEntryId, sourceFileName, mimeType, title, description, changeLog,
				majorVersion, is, size, serviceContext);
		LOG_4.info("Document uploaded successfully by Super6");
		
		try{
			Group group = GroupLocalServiceUtil.getGroup(dlfileEntry.getGroupId());
			if(group.isOrganization()) {
				SecurityUtil.addDefaultCategoryAndRole(userId, group, dlfileEntry);
			}else{
				if(SecurityUtil.isCommunityHavingMerlinTagAndCommunityTag(group, SecurityConstants.COMMUNITY_TAGS_LIST)){
					
					// Below code is to assign default role and default category to the document.
					
					SecurityUtil.addDefaultCategoriesToModel(userId, SecurityUtil.getGlobalGroupId(), group, DLFileEntry.class.getName(), dlfileEntry.getFileEntryId());
					
					SecurityUtil.updateRoles(dlfileEntry);
				}
			}
		}catch(PortalException e){
			LOG_4.error("Unable to add the default role and category while updating the document."+e.getMessage());
		}
		return dlfileEntry;
	}
	
	
}
