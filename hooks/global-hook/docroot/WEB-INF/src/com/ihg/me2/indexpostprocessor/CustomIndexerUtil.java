package com.ihg.me2.indexpostprocessor;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portlet.asset.NoSuchEntryException;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.journal.model.JournalArticle;
/***
 * 
 * @author ketan.savaliya
 *
 */
public class CustomIndexerUtil {
	
	private static Log _log = LogFactoryUtil.getLog(CustomIndexerUtil.class);
	
		/**
		 * Method is use to check orgnization is tagged with "merlin" and custome field have value "Department"
		 * @param org
		 * @param tagName
		 * @return
		 */
		public static boolean isOrganizationMerlin(Organization org,String tagName){
			return isMerlinTag(Organization.class.getName(), org.getOrganizationId(), tagName) && isOrganziationDepartment(org);
		}
		
		/**
		 * Method is user to check Organization have custome field "Type" value equal to "Deparment"
		 * @param org
		 * @return boolean
		 */
		public static boolean isOrganziationDepartment(Organization org) {
			ExpandoBridge customField = org.getExpandoBridge();
			if(Validator.isNotNull(customField) && Validator.isNotNull(customField.getAttribute("Type"))){	
				String[] types = (String[])customField.getAttribute("Type");
				if(types.length>0){
					return types[0].equals("Department");
				}
			}
			return false;
		}

		/**
		 * This method isuser to check organization or group have tagged with given taga name 
		 * @param className : e.g. Organization.class.getName()
		 * @param classPK : organizationId/communityId
		 * @param tagName : "Merlin"
		 * @return
		 */
		public static boolean isMerlinTag(String className, long classPK,String tagName){
			try {
				AssetEntry entry = AssetEntryLocalServiceUtil.getEntry(className, classPK);
				List<AssetTag> tagList = AssetTagLocalServiceUtil.getEntryTags(entry.getEntryId());
				for (AssetTag tag : tagList){
					if(tag.getName().equalsIgnoreCase(tagName)){
						return true;
					}
				}
			} catch (NoSuchEntryException e) {
				_log.error("Tag not found for classPK  : "  + classPK + " === "+ e.getMessage(), e);
			}catch (PortalException e) {
				_log.error("Error while check organizationID " + classPK + " is tagged with   : " + tagName + ":: " + e.getMessage(), e);
			} catch (SystemException e) {
				_log.error("While check organizationID " + classPK + " is tag with   : " + tagName + "::" + e.getMessage(), e);
			}
			return false;
		}
		
		/**
		 * This method is check Group is tagged with give tagName?
		 * @param group
		 * @param tagName
		 * @return
		 */
		public static boolean isContentFromMerlin(Group group,String tagName){
			if(group!=null){
					return isMerlinTag(Group.class.getName(), group.getGroupId(),tagName);
			}
			return false;
		}
		
		
		/**
		 * Method is use to get Group Object based on group id
		 * @param groupId
		 * @return
		 */
		public static Group getGroupById(long groupId){
			try {
				return GroupLocalServiceUtil.getGroup( groupId);
			} catch (PortalException e) {
				_log.error("Error while get Group : " + e.getMessage(),e);
			} catch (SystemException e) {
				_log.error("Error from getGroupById : " + e.getMessage(),e);
			}
			return null;
		}
		
		/**
		 * this method is user for journalArticle have given structureId ?
		 * @param article
		 * @param structureId
		 * @return
		 */
		public static boolean isArticleMerlin(JournalArticle article,String structureId)
		{
			String[] structureIds = structureId.split(StringPool.COMMA);
			for(String sid : structureIds){
				_log.info(article.getStructureId());
				if(article.getStructureId().equalsIgnoreCase(sid)){
					return true;
				}
			}
			return false;
		}
		
		/**
		 * This method is user for which type of document based on extension of dlfileEntry
		 * @param dlFileEntry
		 * @return
		 */
		public static String getFileResourType(DLFileEntry dlFileEntry){
			if(ArrayUtil.contains(CustomIndexerConstant.DOC, dlFileEntry.getExtension())){
				return "DOC";
			} else if (ArrayUtil.contains(CustomIndexerConstant.PDF, dlFileEntry.getExtension())){
				return "PDF";
			} else if (ArrayUtil.contains(CustomIndexerConstant.PPT, dlFileEntry.getExtension())){
				return "PPT";
			} else if (ArrayUtil.contains(CustomIndexerConstant.XLS, dlFileEntry.getExtension())){
				return "XLS";
			} else if (ArrayUtil.contains(CustomIndexerConstant.IMG, dlFileEntry.getExtension())){
				return "IMG";
			} else if (ArrayUtil.contains(CustomIndexerConstant.VID, dlFileEntry.getExtension())){
				return "VID";
			} else if (ArrayUtil.contains(CustomIndexerConstant.AUD, dlFileEntry.getExtension())){
				return "AUD";
			} else{
				return "OTH";
			}
		}
		
		/**
		 * This method is use to get Organization object based on organiationid
		 * @param organizationId
		 * @return
		 */
		public static Organization getOrganizationById(long organizationId){
			try {
				return OrganizationLocalServiceUtil.getOrganization( organizationId);
			} catch (PortalException e) {
				_log.error("Error while get organizationById : " + e.getMessage(),e);
			} catch (SystemException e) {
				_log.error("Error from getOrganizationById : " + e.getMessage(),e);
			}
			return null;
		}
		
    /**
     * @param className
     * @param classPK
     * @return
     */
    public static List<AssetTag> getGroupTagList(String className, long classPK)
    {
        List<AssetTag> tagList = null;
        try
        {
            AssetEntry entry = AssetEntryLocalServiceUtil.getEntry(className, classPK);
            tagList = AssetTagLocalServiceUtil.getEntryTags(entry.getEntryId());
        } catch (PortalException e)
        {
            _log.error("Error while getting associated tag list: "+ e.getMessage(), e);
        } catch (SystemException e)
        {
            _log.error("Error while getting associated tag list: "+ e.getMessage(), e);
        }
        return tagList;
    }
    
    /**
     * @param string
     * @param separator
     * @return
     */
    public static List<String> convertStringtoList(String string, String separator )
    {
        List<String> stringList=null;
        try
        {
            if(Validator.isNotNull(string) && Validator.isNotNull(separator) )
            {
                stringList=  new ArrayList<String>();
                String [] strArray=string.split(separator);
                for (int i = 0; i < strArray.length; i++)
                {
                    stringList.add(strArray[i].trim());
                }
            }
        } catch (Exception e)
        {
            _log.error("Error while coverting String to List "+ e.getMessage());
        }
        return stringList;
    }
    
    
    /**
     * @param className
     * @param classPk
     * @param tagSearchKey
     * @return Tag name from Object if matches with passed tag search keys
     */
    public static String getGroupSearchEnabledTagName(String className, long  classPk, String tagSearchKey)
    {
        String tagName=null;
        try
        {
            String globalSearchEnabledTags = PrefsPropsUtil.getString(tagSearchKey);
            _log.debug("global-search-tag-list from Portal-ext.properties :" + globalSearchEnabledTags);
            if(Validator.isNotNull(globalSearchEnabledTags))
            {
                List<String> searchEnabledTagList=CustomIndexerUtil.convertStringtoList(globalSearchEnabledTags, CustomIndexerConstant.TAG_SEPARATOR);
                if(Validator.isNotNull(searchEnabledTagList))
                {
                    List<AssetTag> tagList=CustomIndexerUtil.getGroupTagList(className,classPk);
                   
                    if(Validator.isNotNull(tagList))
                    {
                        for (AssetTag assetTag : tagList)
                        {
                            if(searchEnabledTagList.contains(assetTag.getName()))
                            {
                                tagName=assetTag.getName();
                            }
                        }
                    }
                }
            }
        } catch (Exception e)
        {
            _log.error("Error while reading values from portal-ext.proprties  : " + e.getMessage(), e);
        }
        return tagName;
    }
		
}
