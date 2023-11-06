package com.ihg.security.util;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Group;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;

public class ValidationUtil
{
    private static final Log LOGGER = LogFactoryUtil.getLog(ValidationUtil.class);
    
    /**
     * @param structureId
     * @param groupId
     * @return
     */
    public static boolean isValidMerlinContent(String structureId, long groupId)
    {
        boolean isValid=false;
        
        if(SecurityConstants.APPLICATION_STRUCTURE_IDS_LIST.contains(structureId) || SecurityConstants.DEPARTMENT_STRUCTURE_IDS_LIST.contains(structureId) 
                || SecurityConstants.INITIATIVES_STRUCTURE_IDS_LIST.contains(structureId) || SecurityConstants.CONF_STRUCTURE_IDS_LIST.contains(structureId)
                 || SecurityConstants.NEWSROOM_STRUCTURE_IDS_LIST.contains(structureId)
                 && (isCommunityHavingTags(SecurityConstants.MERLIN_TAG_NAME,SecurityConstants.COMMUNITY_TAGS_LIST, groupId)) )
        {
            isValid=true;
            LOGGER.debug("Satisfying Merlin validation .....");
        }
        
        return isValid;
    }
    
    /**
     * @param merlinTagName
     * @param communityTags
     * @param group
     * @return
     */
    public static boolean isCommunityHavingTags(String merlinTagName,List<String> communityTagList,long groupId)
    {
        //boolean isMerlinTagged= false;
        boolean isCommunityTagName = false;
        try {
                AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(Group.class.getName(), groupId );
                
                for (AssetTag tag :assetEntry.getTags())
                {
                        if(tag.getGroupId() == JournalArticleSecurityUtil.getGlobalGroupId())
                        {
                            
                            if (communityTagList.contains(tag.getName()))
                            {
                                    isCommunityTagName = true;
                                    
                                    break;
                            }
                        }
                }
        } 
        catch (PortalException e) 
        {
                LOGGER.error("Unable to get the communities having merlin and community specific tags portlet exception:"+e.getMessage());
        }
        catch (SystemException e) 
        {
            LOGGER.error("Unable to get the communities having merlin and community specific tags system exception:"+e.getMessage());
        }
        catch (Exception e) 
        {
            LOGGER.error("Error in checking community tags:"+e.getMessage());
        }
        
        return (isCommunityTagName);
    }
}
