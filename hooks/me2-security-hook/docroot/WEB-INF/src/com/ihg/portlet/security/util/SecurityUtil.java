/**
 * 
 */
package com.ihg.portlet.security.util;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.bookmarks.model.BookmarksEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.expando.model.ExpandoBridge;

import java.util.ArrayList;
import java.util.List;

public class SecurityUtil {
	private static final Log LOG_4 = LogFactoryUtil.getLog(SecurityUtil.class);
	
	public static long getGlobalGroupId() {
		long globalGroupId = 0;
		try {
			globalGroupId = GroupLocalServiceUtil.getCompanyGroup(
					PortalUtil.getDefaultCompanyId()).getGroupId();
		} catch (PortalException e) {
			LOG_4.error(
					"Unable to retrieve Global GroupID, " + e.getMessage(), e);
		} catch (SystemException e) {
			LOG_4.error(
					"Unable to retrieve Global GroupID, " + e.getMessage(), e);
		}
		return globalGroupId;
	}
	
	public static boolean isCommunityHavingMerlinTagAndCommunityTag(Group group, List<String> tagList){
		boolean flag = false;
		/*
		 * below code is to get the merlin tag id.
		 */
		String merlinTagName = SecurityConstants.MERLIN_TAG_NAME;
		if(SecurityConstants.NEWSROOM_COMMUNITY_NAME.equalsIgnoreCase(group.getName())){
			boolean isMerlinTagged= false;
			/*
			 * below code is to get the communities having merlin tag.
			 */
			AssetEntry assetEntry;
			try {
				AssetEntry	entry = AssetEntryLocalServiceUtil.getEntry(Group.class.getName(), group.getGroupId() );
				assetEntry = AssetEntryLocalServiceUtil.getAssetEntry(entry.getEntryId());
				for (AssetTag tag :assetEntry.getTags()){
					if(tag.getGroupId() == SecurityUtil.getGlobalGroupId() && tag.getName().equalsIgnoreCase(merlinTagName)){
						isMerlinTagged = true;
					}
				}
			} catch (PortalException e) {
				LOG_4.error("Unable to get the community having merlin tag portlet exception:"+e.getMessage());
			} catch (SystemException e) {
				LOG_4.error("Unable to get the community having merlin tag system exception:"+e.getMessage());
			}
			if(isMerlinTagged){
				flag =true;
			}
		}else{
		    
		    flag=isCommunityHavingTags(merlinTagName,tagList, group);
		}
		return flag;
	}
	
	public static void addDefaultRole(FileEntry dlfileEntry, String roleName){
		try{
		    
			Role guestRole=RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), RoleConstants.GUEST); 
		 	Role userRole=RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), RoleConstants.USER);
		 	Role defaultRole = null;
		 	try{
		 		defaultRole=RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), roleName);
		 		
		 	}catch(Exception e)
		 	{
		 		LOG_4.error("Unable to get the 'User Type Corporate and Temporary Contractors' role details "+e.getMessage());
		 	}
		 	if(defaultRole != null){
		 		ResourcePermissionLocalServiceUtil.setResourcePermissions(CompanyThreadLocal.getCompanyId(), DLFileEntry.class.getName(), 
		 				ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(dlfileEntry.getPrimaryKey()), defaultRole.getRoleId(), new String[]{ActionKeys.VIEW});
				ResourcePermissionLocalServiceUtil.removeResourcePermission(CompanyThreadLocal.getCompanyId(), DLFileEntry.class.getName(),
						ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(dlfileEntry.getPrimaryKey()), guestRole.getRoleId(), ActionKeys.VIEW);
				ResourcePermissionLocalServiceUtil.removeResourcePermission(CompanyThreadLocal.getCompanyId(), DLFileEntry.class.getName(),
						ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(dlfileEntry.getPrimaryKey()), userRole.getRoleId(), ActionKeys.VIEW);
		 	}
		 }catch(Exception e){
			 LOG_4.error("Unable to add default role :"+e.getMessage());
		 }
	}
	
	/**
	 * @param bookmarkEntry
	 * @param roleName
	 */
	public static void addDefaultRoleToBookmarks(BookmarksEntry bookmarkEntry, String roleName){
            try{
                
                    Role guestRole=RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), RoleConstants.GUEST); 
                    Role userRole=RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), RoleConstants.USER);
                    Role defaultRole = null;
                    try{
                            defaultRole=RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), roleName);
                            
                    }catch(Exception e){
                            LOG_4.error("Unable to get the 'User Type Corporate and Temporary Contractors' role details "+e.getMessage());
                    }
                    if(defaultRole != null){
                            ResourcePermissionLocalServiceUtil.setResourcePermissions(CompanyThreadLocal.getCompanyId(), BookmarksEntry.class.getName(), 
                                            ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(bookmarkEntry.getPrimaryKey()), defaultRole.getRoleId(), new String[]{ActionKeys.VIEW});
                            ResourcePermissionLocalServiceUtil.removeResourcePermission(CompanyThreadLocal.getCompanyId(), BookmarksEntry.class.getName(),
                                            ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(bookmarkEntry.getPrimaryKey()), guestRole.getRoleId(), ActionKeys.VIEW);
                            ResourcePermissionLocalServiceUtil.removeResourcePermission(CompanyThreadLocal.getCompanyId(), BookmarksEntry.class.getName(),
                                            ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(bookmarkEntry.getPrimaryKey()), userRole.getRoleId(), ActionKeys.VIEW);
                    }
             }catch(Exception e){
                     LOG_4.error("Unable to add default role :"+e.getMessage());
             }
    }
	
	/**
	 * @param userId
	 * @param globalGroupId
	 * @param group
	 * @param className
	 * @param classPK
	 */
	public static void addDefaultCategoriesToModel(long userId, long globalGroupId,Group group, String className, long classPK) 
	{
            boolean isCommunityTypeIsInitiativeOrConference = false;
            try{
                    AssetEntry      entry = AssetEntryLocalServiceUtil.getEntry(Group.class.getName(), group.getGroupId());
                    List<AssetTag>  assetTagsList = AssetTagLocalServiceUtil.getEntryTags(entry.getEntryId());
                    for(AssetTag assetTagObj : assetTagsList){
                            if(SecurityConstants.INITIATIVE_TAG_NAME.equalsIgnoreCase(assetTagObj.getName()) || SecurityConstants.CONFERENCE_TAG_NAME.equalsIgnoreCase(assetTagObj.getName())){
                                    isCommunityTypeIsInitiativeOrConference = true;
                                    break;
                            }
                    }
                    /*
                     * Below code is to get the asset tags of the community for update the tags if any while applying the default category to the community .
                     */
                    AssetEntry tagEnteryOfDocument = AssetEntryLocalServiceUtil.getEntry(className, classPK );
                    
                    List<AssetTag> assetTagsListOfDocument = AssetTagLocalServiceUtil.getEntryTags(tagEnteryOfDocument.getEntryId());
                    //code end here of getting tags of community.
                    final String[] tagNames = new String[assetTagsListOfDocument.size()];
                    for(int count = 0; count<assetTagsListOfDocument.size() ; count++)
                    {
                            tagNames[count] = assetTagsListOfDocument.get(count).getName(); 
                    }
                    if(isCommunityTypeIsInitiativeOrConference)
                    {
                            /*
                             * Below code is to get the categories of community and categories of document.
                             */
                    		
                            java.util.List<AssetCategory> globalCategoriesList = null;
                            List<AssetCategory>  assetCategoryOfDocument = null;
                            List<AssetCategory>  assetCategoryOfCommunity = null;
                            try 
                            {
                                    assetCategoryOfCommunity =  AssetCategoryLocalServiceUtil.getCategories(Group.class.getName(), group.getGroupId());
                                    
                            } catch (SystemException e) 
                            {
                                    LOG_4.error("Unable to get the asset categories of Group."+e.getMessage());
                            }
                            try 
                            {
                                    assetCategoryOfDocument =  AssetCategoryLocalServiceUtil.getCategories(className, classPK);
                            } catch (SystemException e) 
                            {
                                    LOG_4.error("Unable to get the asset categories of document."+e.getMessage());
                            }
                            
                            globalCategoriesList = getCategoryDetails(globalGroupId, SecurityConstants.DEFAULT_CATEGORY_NAME);
                            
                            List<AssetCategory> gloabalAndDocumentCatList = new ArrayList<AssetCategory>();
                            List<AssetCategory> removeCatList = new ArrayList<AssetCategory>();
                            gloabalAndDocumentCatList.addAll(assetCategoryOfDocument);
                                                        
                            for (AssetCategory assetCategory : gloabalAndDocumentCatList) 
                            {
                            	if(assetCategory.getParentCategoryId() != 0 )
                            	{
                            		AssetCategory parentAssetCategory = AssetCategoryLocalServiceUtil.getCategory(assetCategory.getParentCategoryId());
                            		if(SecurityConstants.CATEGORY_NAMES_LIST.contains(parentAssetCategory.getName()))
                            		{
                            			if(!assetCategoryOfCommunity.contains(assetCategory))
                            			{
                            				LOG_4.debug(assetCategory.getName() +" -- Is Not in scop of parent so putting in remove list... " );
                            				removeCatList.add(assetCategory);
                            			}
                            		}
                            	}
							}
                            
                            /*Removing categories which are not in parent scope*/
                            if(!removeCatList.isEmpty())
                            {
                            	 gloabalAndDocumentCatList.removeAll(removeCatList);
                            }
                            
                            /*Adding default categories to list*/
                            gloabalAndDocumentCatList.addAll(globalCategoriesList);
                            
                            int counter = 0;
                            
                            final long[] assetCategoryIds = new long[gloabalAndDocumentCatList.size()];
                            
                        	for(AssetCategory assetCategory:gloabalAndDocumentCatList)
                        	{
                        		assetCategoryIds[counter++] = assetCategory.getCategoryId();
                        	}
                            
                            try 
                            {
                                    AssetEntryLocalServiceUtil.updateEntry(userId, group.getGroupId() ,className, classPK,assetCategoryIds, tagNames);
                            } catch (PortalException e) 
                            {
                                    LOG_4.error("Unable to add categories to uploading document "+e.getMessage());
                            } catch (SystemException e) 
                            {
                                    LOG_4.error("Unable to add categories to uploading document "+e.getMessage());
                            }
                            
                    }else
                    {
                            addDefaultCategories(userId, globalGroupId,group,className, classPK, null);
                    }
            }catch(SystemException e)
            {
                    LOG_4.error("Unable to add default categories:"+e.getMessage());
            }catch(PortalException e)
            {
                    LOG_4.error("Unable to add default categories due portal exception:"+e.getMessage());
            }
    }
	
	/**
	 * @param userId
	 * @param globalGroupId
	 * @param group
	 * @param className
	 * @param classPK
	 * @param userTypeCorporateCategoryId
	 */
public static void addDefaultCategories(long userId, long globalGroupId, Group group,String className, long classPK,List<AssetCategory> categories){
	
	List<AssetCategory>  assetCategoryList = new ArrayList<AssetCategory>();
	int counter=0;
	
	try{
		
    	String[] tagNames = AssetTagLocalServiceUtil.getTagNames(className, classPK);
    	
    	if(Validator.isNotNull(categories) && categories.size()>0){
    		assetCategoryList.addAll(categories);
    	}else{
    		List<AssetCategory> globalCategoriesList = getCategoryDetails(globalGroupId, SecurityConstants.DEFAULT_CATEGORY_NAME);
    		assetCategoryList.addAll(globalCategoriesList);
    	}
    	
    	assetCategoryList.addAll( AssetCategoryLocalServiceUtil.getCategories(className, classPK));
    	
    	long[] assetCategoryIds = new long[assetCategoryList.size()];
    	
    	for(AssetCategory assetCategory:assetCategoryList){
    		assetCategoryIds[counter] = assetCategory.getCategoryId();
    		counter++;
    	}
    	
    	AssetEntryLocalServiceUtil.updateEntry(userId, group.getGroupId() ,className, classPK, assetCategoryIds, tagNames);
            
	}catch(SystemException e){
	        LOG_4.error("Unable to add default categories in organization, "+e.getMessage());
	}
	catch (PortalException e) {
		LOG_4.error("Unable to add default categories in organization, "+e.getMessage());
	}
}
	
	
	/**
	 * @param merlinTagName
	 * @param communityTags
	 * @param group
	 * @return
	 */
	public static boolean isCommunityHavingTags(String merlinTagName,List<String> communityTagList,Group group)
	{
            //boolean isMerlinTagged= false;
            boolean isCommunityTagName = false;
            try {
                    AssetEntry      assetEntry = AssetEntryLocalServiceUtil.getEntry(Group.class.getName(), group.getGroupId() );
                    
                    for (AssetTag tag :assetEntry.getTags())
                    {
                            if(tag.getGroupId() == SecurityUtil.getGlobalGroupId())
                            {
                                   /* if(tag.getName().equalsIgnoreCase(merlinTagName))
                                    {
                                            isMerlinTagged = true;
                                            
                                    }
                                    else if (communityTagList.contains(tag.getName()))
                                    {
                                            isCommunityTagName = true;
                                    }*/
                                
                                if (communityTagList.contains(tag.getName()))
                                {
                                        isCommunityTagName = true;
                                }
                            }
                    }
            } 
            catch (PortalException e) 
            {
                    LOG_4.error("Unable to get the communities having merlin and community specific tags portlet exception:"+e.getMessage());
            }
            catch (SystemException e) 
            {
                    LOG_4.error("Unable to get the communities having merlin and community specific tags system exception:"+e.getMessage());
            }
            
            return (isCommunityTagName);
    }
	
	
	
	public static void addDefaultCategoriesToCommunity(Group group,long userId){
		long globalGroupId = SecurityUtil.getGlobalGroupId();
		java.util.List<AssetCategory> globalCategoriesList = null;
		try{
			/*
			 * Below code is to get the asset tags of the community for update the tags if any while applying the default category to the community .
			 */
			AssetEntry entry = AssetEntryLocalServiceUtil.getEntry(Group.class.getName(), group.getGroupId() );
			List<AssetTag>	assetTagsList = AssetTagLocalServiceUtil.getEntryTags(entry.getEntryId());
			String[] tagNames = new String[assetTagsList.size()];
			for(int count = 0; count<assetTagsList.size() ; count++){
				tagNames[count] = assetTagsList.get(count).getName(); 
			}
			//code end here of getting tags of community.
			globalCategoriesList = getCategoryDetails(globalGroupId,SecurityConstants.DEFAULT_CATEGORY_NAME);
			
			if(globalCategoriesList != null && globalCategoriesList.size() >0){
				int assetCategorySize = 1;
				List<AssetCategory>  assetCategoryList = null;
				try {
					assetCategoryList =  AssetCategoryLocalServiceUtil.getCategories(Group.class.getName(), group.getGroupId());
					if(assetCategoryList != null && assetCategoryList.size()>0){
						assetCategorySize = assetCategorySize + assetCategoryList.size();
					}
				} catch (Exception e) {
					LOG_4.error("Exception occured while getting the existed categories of community if any. "+e.getMessage());
				}
				long[] assetCategoryIds = new long[assetCategorySize];
				assetCategoryIds[0] = globalCategoriesList.get(0).getCategoryId();
				if(assetCategoryList != null && assetCategoryList.size()>0){
					for(int count = 0 ; count< assetCategoryList.size() ; count++){
						assetCategoryIds[count+1] = assetCategoryList.get(count).getCategoryId();
					}
				}
				try {
					/*AssetEntryLocalServiceUtil.updateEntry(userId, globalGroupId ,Group.class.getName(), group.getPrimaryKey(),
					  assetCategoryIds, tagNames);*/
				    GroupLocalServiceUtil.updateAsset(group.getCreatorUserId(), group, assetCategoryIds, tagNames);
				    
				    /*Re-indexing  this group to make sure updated asset entries updated in solr document as well*/
		                        Indexer indexer = IndexerRegistryUtil.getIndexer(Group.class);
		                        
		                        LOG_4.info("Indexing individual group with asset entries..");
		                        
		                        indexer.reindex(group);
		                        
				} catch (PortalException e) {
					LOG_4.error("Unable to add categories to created community because portal Exception "+e.getMessage());
				} catch (SystemException e) {
					LOG_4.error("Unable to add categories to created community because system exception  "+e.getMessage());
				}
			}
		}catch(SystemException e){
			LOG_4.error("Unable to add default categories to community:"+e.getMessage());
		}catch(PortalException e){
			LOG_4.error("Unable to add default categories to the community because of portl exception"+e.getMessage());
		}
	}
	public static void addDefaultCategoryAndRole(long userId, Group group, FileEntry dlfileEntry) throws PortalException, SystemException{
		List<AssetCategory> categories = new ArrayList<AssetCategory>(); 
		try{
			Organization organization = OrganizationLocalServiceUtil.getOrganization(group.getOrganizationId());
			Organization ourPeopleOrgObj = null;
			try{
				ourPeopleOrgObj = OrganizationLocalServiceUtil.getOrganization(organization.getParentOrganizationId());
			}catch(Exception e){
				LOG_4.error("Unable get the parent organization details of current organization."+e.getMessage());
			}
			if(ourPeopleOrgObj != null && ourPeopleOrgObj.getName().equalsIgnoreCase(SecurityConstants.OUR_PEOPLE)){
				ExpandoBridge ourPeopleOrganizationExpandoBridge = ourPeopleOrgObj.getExpandoBridge();
				String[] orgType = (String[]) ourPeopleOrganizationExpandoBridge.getAttribute("Type");
				if(Validator.isNotNull(orgType) && orgType.length>0 && 
						(Validator.isNotNull(orgType[0]) && orgType[0].equalsIgnoreCase(SecurityConstants.ABOUT_IHG_CUSTOM_FIELD))) {
					/*
					 * Below code is to get the User Type Corporate Only category id
					 */
					
				        long globalGroupId= SecurityUtil.getGlobalGroupId();
				    
					List<AssetCategory> corporateCategoryList = getCategoryDetails(globalGroupId, SecurityConstants.CORPORATE_CATEGORY_NAME);
					categories.add(corporateCategoryList.get(0));
					
					corporateCategoryList = getCategoryDetails(globalGroupId, SecurityConstants.OWNED_AND_MANAGED_CAT_NAME);
					categories.add(corporateCategoryList.get(0));
					
					corporateCategoryList = getCategoryDetails(globalGroupId, SecurityConstants.IHG_CORP_BRAND_CAT_NAME);
                                        categories.add(corporateCategoryList.get(0));
					
				 	try{
				 		SecurityUtil.addDefaultCategories(userId, globalGroupId, group, DLFileEntry.class.getName(), dlfileEntry.getFileEntryId(),categories);
				 		SecurityUtil.updateRoles(dlfileEntry);
				 	}catch(Exception e){
				 		LOG_4.error("Unable to add default categoires to the document in organization."+e.getMessage());
				 	}
				}
			}else{
				ExpandoBridge organizationExpandoBridge = organization.getExpandoBridge();
				String[] organizationType = (String[]) organizationExpandoBridge.getAttribute("Type");
				if (Validator.isNotNull(organizationType) &&
					organizationType.length > 0 &&
					(Validator.isNotNull(organizationType[0]) && (organizationType[0].equalsIgnoreCase(SecurityConstants.DEPARTMENT_CUSTOM_FIELD) || organizationType[0].equalsIgnoreCase(SecurityConstants.ABOUT_IHG_CUSTOM_FIELD)))) {
						AssetEntry assetEntry;
						try {
							AssetEntry	entry = AssetEntryLocalServiceUtil.getEntry(Organization.class.getName(), group.getOrganizationId() );
							assetEntry = AssetEntryLocalServiceUtil.getAssetEntry(entry.getEntryId());
							for (AssetTag tag :assetEntry.getTags()){
								if(tag.getGroupId() == SecurityUtil.getGlobalGroupId() && tag.getName().equalsIgnoreCase(SecurityConstants.MERLIN_TAG_NAME)){
									SecurityUtil.addDefaultCategories(userId, SecurityUtil.getGlobalGroupId(), group, DLFileEntry.class.getName(), dlfileEntry.getFileEntryId(),null);
									SecurityUtil.updateRoles(dlfileEntry);
									break;
								}
							}
						} catch (SystemException e) {
							LOG_4.error("Unable to get the community having merlin tag system exception:"+e.getMessage());
						}
				}
			}
		}catch(PortalException e){
			LOG_4.error("Unable to add default role and categories to the document in an organization."+e.getMessage());
		}
	}
	

	/**
	 * @param userId
	 * @param group
	 * @param bookmarskentry
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static void addDefaultCategoryAndRoleToBookmark(long userId, Group group, BookmarksEntry bookmarskentry) throws PortalException, SystemException{
		List<AssetCategory> categories = new ArrayList<AssetCategory>(); 
            try{
                    Organization organization = OrganizationLocalServiceUtil.getOrganization(group.getOrganizationId());
                    Organization ourPeopleOrgObj = null;
                    try{
                            ourPeopleOrgObj = OrganizationLocalServiceUtil.getOrganization(organization.getParentOrganizationId());
                    }catch(Exception e){
                            LOG_4.error("Unable get the parent organization details of current organization."+e.getMessage());
                    }
                    if(ourPeopleOrgObj != null && ourPeopleOrgObj.getName().equalsIgnoreCase(SecurityConstants.OUR_PEOPLE)){
                            ExpandoBridge ourPeopleOrganizationExpandoBridge = ourPeopleOrgObj.getExpandoBridge();
                            String[] orgType = (String[]) ourPeopleOrganizationExpandoBridge.getAttribute("Type");
                            if(Validator.isNotNull(orgType) && orgType.length>0 && 
                                            (Validator.isNotNull(orgType[0]) && orgType[0].equalsIgnoreCase(SecurityConstants.ABOUT_IHG_CUSTOM_FIELD))) {
                                    /*
                                     * Below code is to get the User Type Corporate Only category id
                                     */
                                    long globalGroupId=SecurityUtil.getGlobalGroupId();
                                    List<AssetCategory> corporateCategoryList = getCategoryDetails(globalGroupId, SecurityConstants.CORPORATE_CATEGORY_NAME);
                                    categories.add(corporateCategoryList.get(0));
                                    corporateCategoryList = getCategoryDetails(globalGroupId, SecurityConstants.OWNED_AND_MANAGED_CAT_NAME);
                					categories.add(corporateCategoryList.get(0));
                		    corporateCategoryList = getCategoryDetails(globalGroupId, SecurityConstants.IHG_CORP_BRAND_CAT_NAME);
                                                        categories.add(corporateCategoryList.get(0));
                                    /*
                                     * Below code is to add role "User Type Corporate Only" and category 'User type corporate only'
                                     */
                                    try{
                                            SecurityUtil.addDefaultCategories(userId, globalGroupId, group, BookmarksEntry.class.getName(), bookmarskentry.getEntryId(),categories);
                                            SecurityUtil.updateRoles(bookmarskentry);
                                    }catch(Exception e){
                                            LOG_4.error("Unable to add default categoires to the document in organization."+e.getMessage());
                                    }
                            }
                    }else{
                            ExpandoBridge organizationExpandoBridge = organization.getExpandoBridge();
                            String[] organizationType = (String[]) organizationExpandoBridge.getAttribute("Type");
                            if(Validator.isNotNull(organizationType) && organizationType.length>0 && 
                                            (Validator.isNotNull(organizationType[0]) && (organizationType[0].equalsIgnoreCase(SecurityConstants.DEPARTMENT_CUSTOM_FIELD) || organizationType[0].equalsIgnoreCase(SecurityConstants.ABOUT_IHG_CUSTOM_FIELD)))) {
                                            AssetEntry assetEntry;
                                            try {
                                                    AssetEntry      entry = AssetEntryLocalServiceUtil.getEntry(Organization.class.getName(), group.getOrganizationId() );
                                                    assetEntry = AssetEntryLocalServiceUtil.getAssetEntry(entry.getEntryId());
                                                    for (AssetTag tag :assetEntry.getTags()){
                                                            if(tag.getGroupId() == SecurityUtil.getGlobalGroupId() && tag.getName().equalsIgnoreCase(SecurityConstants.MERLIN_TAG_NAME)){
                                                                    SecurityUtil.addDefaultCategories(userId, SecurityUtil.getGlobalGroupId(), group, BookmarksEntry.class.getName(), bookmarskentry.getEntryId(),null);
                                                                    SecurityUtil.updateRoles(bookmarskentry);
                                                                    break;
                                                            }
                                                    }
                                            } catch (SystemException e) {
                                                    LOG_4.error("Unable to get the community having merlin tag system exception:"+e.getMessage());
                                            }
                            }
                    }
            }catch(PortalException e){
                    LOG_4.error("Unable to add default role and categories to the document in an organization."+e.getMessage());
            }
    }
	
	
	public static java.util.List<AssetCategory> getCategoryDetails(long globalGroupId, String categoryName){
		java.util.List<AssetCategory> globalCategoriesList = null;
		try{
			DynamicQuery query1 = DynamicQueryFactoryUtil
	                .forClass(AssetCategory.class, "globalCategories", PortalClassLoaderUtil.getClassLoader())
	                .add(PropertyFactoryUtil.forName("groupId").eq(globalGroupId))
	                .add(PropertyFactoryUtil.forName("parentCategoryId").gt(0L))
	                .add(PropertyFactoryUtil.forName("name").eq(categoryName));
			globalCategoriesList = AssetCategoryLocalServiceUtil.dynamicQuery(query1);
		}catch (Exception e) {
			LOG_4.error("Unable to get global category details "+e.getMessage());
		}
		return globalCategoriesList;
	}
	
	
	
	public static void updateRoles(Object model) {

		List<AssetCategory> modelAssociatedCategories = null;
		List<AssetCategory> userTypeCategories = null;
		
		long modelPrimaryKey = 0L;
		String modelClassName= null;
		
		Role role =null;
		
		try {
			
			//Getting Global UserType Category Information
			
			AssetVocabulary vocabulary =
				AssetVocabularyLocalServiceUtil.getGroupVocabulary(
					SecurityUtil.getGlobalGroupId(), SecurityConstants.GLOBAL_CATEGORY_VOCABULARY_NAME);

			List<AssetCategory> rootCategories =
				AssetCategoryLocalServiceUtil.getVocabularyRootCategories(
					vocabulary.getVocabularyId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
			
			for (AssetCategory rootCategory : rootCategories) {
				if(SecurityConstants.USERTYPE_CATEGORY_NAME.equalsIgnoreCase(rootCategory.getName())){
					userTypeCategories = AssetCategoryLocalServiceUtil.getChildCategories(rootCategory.getCategoryId());
					break;
				}
			}

			//Getting model basic information
			
			if (model instanceof FileEntry) {
				
				FileEntry fileEntry = (FileEntry) model;
				
				modelPrimaryKey = fileEntry.getPrimaryKey();
				modelClassName = DLFileEntry.class.getName();
				
			}else if (model instanceof BookmarksEntry) {
				
				BookmarksEntry bookmarksEntry = (BookmarksEntry) model;
				
				modelPrimaryKey = bookmarksEntry.getPrimaryKey();
				modelClassName = BookmarksEntry.class.getName();
				
			}
			LOG_4.debug("modelAssociatedCategories for ====== modelPrimaryKey::"+ modelPrimaryKey + " === modelClassName::"+ modelClassName);
			//Getting model associated categories information
			
			modelAssociatedCategories =
				AssetCategoryLocalServiceUtil.getCategories(modelClassName, modelPrimaryKey);
			
			for(AssetCategory category: userTypeCategories){
				
				role = SecurityUtil.getRoleFormCategoryName(category.getName());
				
				if(Validator.isNotNull(role)){
					
					//Removing UserType related Categories (This logic is mainly for existing documents)
					SecurityUtil.removePermission(modelPrimaryKey, modelClassName, role, ActionKeys.VIEW);
					
					//Checking whether GLobal UserType Categories are associated with model; if 'YES', adding the role.
					
					if(modelAssociatedCategories.contains(category))
					{
						SecurityUtil.updateRole(modelPrimaryKey, modelClassName,role, ActionKeys.VIEW);
					}
				}
			}
			
			//Removing Guest and User VIEW Permissions
			
			role = RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), RoleConstants.GUEST);
			SecurityUtil.removePermission(modelPrimaryKey, modelClassName, role, ActionKeys.VIEW);
			
			role = RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), RoleConstants.USER);
			SecurityUtil.removePermission(modelPrimaryKey, modelClassName, role, ActionKeys.VIEW);
			
		} catch (PortalException e) {
			LOG_4.error("Unable to get updates roles to the model "+modelClassName+", " + e.getMessage());
		} catch (SystemException e) {
			LOG_4.error("Unable to get updates roles to the model "+modelClassName+", " + e.getMessage());
		}

	}


	public static Role getRoleFormCategoryName(String roleName) {

		Role role=null;
		String name = null;
		
		if(SecurityConstants.CORPORATE_AND_TEMP_CONTRACTORS_CAT_NAME.equals(roleName)){
			name = SecurityConstants.CORPORATE_AND_TEMP_CONTRACTORS_ROLE_NAME;
		}else if(SecurityConstants.FRANCHISE_CAT_NAME.equals(roleName)){
			name = SecurityConstants.FRANCHISE_ROLE_NAME;
		}else if(SecurityConstants.OWNED_AND_MANAGED_CAT_NAME.equals(roleName)){
			name = SecurityConstants.OWNED_AND_MANAGED_ROLE_NAME;
		}else if(SecurityConstants.VENDORS_CAT_NAME.equals(roleName)){
			name = SecurityConstants.VENDORS_ROLE_NAME;
		}else if(SecurityConstants.CORPORATE_CAT_NAME.equals(roleName)){
			name = SecurityConstants.CORPORATE_ROLE_NAME;
		}	
		
		try {
			role = RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), name);
		}
		catch (PortalException e) {
			LOG_4.error("Unable to get Role information, " + e.getMessage());
		}
		catch (SystemException e) {
			LOG_4.error("Unable to get Role information, " + e.getMessage());
		}
		return role;
	}
	
	public static void updateRole(long modelPrimaryKey, String modelClassName, Role role, String acitionKey) {

 		try {
			ResourcePermissionLocalServiceUtil.setResourcePermissions(CompanyThreadLocal.getCompanyId(), modelClassName, 
					ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(modelPrimaryKey), role.getRoleId(), new String[]{acitionKey});
		}
		catch (PortalException e) {
			LOG_4.error("Unable to add "+acitionKey+" permission for model "+modelClassName+", " + e.getMessage());
		}
		catch (SystemException e) {
			LOG_4.error("Unable to add "+acitionKey+" permission for model "+modelClassName+", " + e.getMessage());
		}
		
	}
	
	
	public static void removePermission(long modelPrimaryKey, String modelClassName, Role role, String acitionKey) {
		
		try {
			ResourcePermissionLocalServiceUtil.removeResourcePermission(CompanyThreadLocal.getCompanyId(), modelClassName,
				ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(modelPrimaryKey), role.getRoleId(), acitionKey);
		}
		catch (PortalException e) {
			LOG_4.error("Unable to delete "+acitionKey+" permission from "+role.getName()+", " + e.getMessage());
		}
		catch (SystemException e) {
			LOG_4.error("Unable to delete "+acitionKey+" permission from "+role.getName()+", " + e.getMessage());
		} 
	 	
	}

}
