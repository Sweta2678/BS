package com.ihg.me2.indexpostprocessor;

import com.ihg.me2.indexpostprocessor.util.CustomIndexerConstant;
import com.ihg.me2.indexpostprocessor.util.CustomIndexerUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexerPostProcessor;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;

/**
 * @author PatelHet
 *
 */
public class DLEntryPostProcessor extends BaseIndexerPostProcessor
{
	
	private static Log _log = LogFactoryUtil.getLog(DLEntryPostProcessor.class);

	@Override
	public void postProcessDocument(Document doc, Object obj) 	throws Exception 
	{
		
		DLFileEntry dlFileEntry = (DLFileEntry) obj;

		if (doc != null) 
		{
			try 
			{
				long sizeinbyte = dlFileEntry.getSize();
				
				doc.addNumber("filesize", sizeinbyte);
				
				Group group = CustomIndexerUtil.getGroupById(dlFileEntry.getGroupId());
				
				if(!group.isOrganization() && CustomIndexerUtil.isContentFromMerlin(group,PrefsPropsUtil.getString("tag-merlin")))
				{
					if(group.getName().equals(PrefsPropsUtil.getString("news-room-community-name")))
					{
						doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_SOURCE, PrefsPropsUtil.getString("meta-data-content-source-value"));
						doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_TYPE, PrefsPropsUtil.getString("meta-data-content-type-resource")	);
						doc.addKeyword(CustomIndexerConstant.META_DATA_RESOURCE_TYPE, CustomIndexerUtil.getFileResourType(dlFileEntry));
						doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_LINK,CustomIndexerConstant.DOCUMENT+dlFileEntry.getGroupId()+ StringPool.SLASH + dlFileEntry.getUuid()	);
						doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_NAME, CustomIndexerConstant.NEWS_PARENT_NAME);
						doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_LINK,CustomIndexerConstant.NEWS_PARENT_LINK);
						doc.addKeyword(CustomIndexerConstant.META_DATA_PARENT_CONTENT_TYPE, PrefsPropsUtil.getString("meta-data-content-type-news-article"));
					} 
					else if(group.getName().equals(PrefsPropsUtil.getString("app-stor-community-name")) )
					{
						doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_SOURCE, PrefsPropsUtil.getString("meta-data-content-source-value"));
						doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_TYPE, PrefsPropsUtil.getString("meta-data-content-type-resource")	);
						doc.addKeyword(CustomIndexerConstant.META_DATA_RESOURCE_TYPE, CustomIndexerUtil.getFileResourType(dlFileEntry));
						doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_LINK,CustomIndexerConstant.DOCUMENT+dlFileEntry.getGroupId()+ StringPool.SLASH + dlFileEntry.getUuid()	);
						doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_NAME,CustomIndexerConstant.APPS_PARENT_NAME);
						doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_LINK,CustomIndexerConstant.APPS_PARENT_LINK);
						doc.addKeyword(CustomIndexerConstant.META_DATA_PARENT_CONTENT_TYPE, PrefsPropsUtil.getString("meta-data-content-type-application"));
					} 
					else if(group.getName().equals(PrefsPropsUtil.getString("merlin-community-name")) )
					{
						doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_SOURCE, PrefsPropsUtil.getString("meta-data-content-source-value"));
						doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_TYPE,  PrefsPropsUtil.getString("meta-data-content-type-resource")	);
						doc.addKeyword(CustomIndexerConstant.META_DATA_RESOURCE_TYPE, CustomIndexerUtil.getFileResourType(dlFileEntry));
						doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_LINK,CustomIndexerConstant.DOCUMENT+dlFileEntry.getGroupId()+ StringPool.SLASH + dlFileEntry.getUuid()	);
						doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_NAME,CustomIndexerConstant.MERLIN_PARENT_NAME);
						doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_LINK,CustomIndexerConstant.MERLIN_PARENT_LINK);
						doc.addKeyword(CustomIndexerConstant.META_DATA_PARENT_CONTENT_TYPE, PrefsPropsUtil.getString("meta-data-content-type-teamspace"));
					} 
					else if (CustomIndexerUtil.isContentFromMerlin(group,PrefsPropsUtil.getString("tag-teamspace")))
					{
						doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_SOURCE, PrefsPropsUtil.getString("meta-data-content-source-value"));
						doc.addKeyword(CustomIndexerConstant.META_DATA_RESOURCE_TYPE, CustomIndexerUtil.getFileResourType(dlFileEntry));
						doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_TYPE,  PrefsPropsUtil.getString("meta-data-content-type-resource")	);
						doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_LINK,CustomIndexerConstant.DOCUMENT+dlFileEntry.getGroupId()+ StringPool.SLASH + dlFileEntry.getUuid()	);
						doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_NAME,group.getName());
						doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_LINK,CustomIndexerConstant.WEB + group.getFriendlyURL() + CustomIndexerConstant.HOME);
						doc.addKeyword(CustomIndexerConstant.META_DATA_PARENT_CONTENT_TYPE, PrefsPropsUtil.getString("meta-data-content-type-teamspace"));
					}else
					{
					   doc= updateMerlinMetadata(Group.class.getName(), group.getGroupId(), doc, group, dlFileEntry); 
					}
				}
				else if (group.isOrganization() )
				{
					Organization org = CustomIndexerUtil.getOrganizationById(group.getClassPK());
					
					if(CustomIndexerUtil.isMerlinTag(Organization.class.getName(), org.getOrganizationId(), PrefsPropsUtil.getString("tag-merlin")))
					{
        					if(CustomIndexerUtil.isOrganziationDepartment(org))
        					{
        						doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_SOURCE, PrefsPropsUtil.getString("meta-data-content-source-value"));
        						doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_TYPE,  PrefsPropsUtil.getString("meta-data-content-type-resource")	);
        						doc.addKeyword(CustomIndexerConstant.META_DATA_RESOURCE_TYPE, CustomIndexerUtil.getFileResourType(dlFileEntry));
        						doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_LINK,CustomIndexerConstant.DOCUMENT+dlFileEntry.getGroupId()+ StringPool.SLASH + dlFileEntry.getUuid()	);
        						doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_NAME,group.getFriendlyURL().substring(1));
        						doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_LINK,CustomIndexerConstant.WEB + group.getFriendlyURL() + CustomIndexerConstant.HOME);
        						doc.addKeyword(CustomIndexerConstant.META_DATA_PARENT_CONTENT_TYPE,PrefsPropsUtil.getString("meta-data-content-type-department"));
        					}else
        					{
        					    Group orgGroup = CustomIndexerUtil.getGroupById(org.getGroup().getGroupId());
        					    doc=updateMerlinMetadata(Organization.class.getName(), org.getOrganizationId(), doc, orgGroup, dlFileEntry);
        					}
					}
				}
				
				_log.info("Indexing filesize & meta-data field from post processor for document library ");

			} 
			catch (Exception ex) 
			{
				_log.error("Problem while indexing DLFileEntry with Custom BrandFrameworkDLIndexer ::" 
						+ ex.getMessage(), ex);
			}
		}
		
		doc.addText("customModified_sortable", String.valueOf(dlFileEntry.getModifiedDate().getTime()));
		
		_log.info("====================== customModified value added for =========== "+  dlFileEntry.getFileEntryId());
		
		super.postProcessDocument(doc, obj);
	}
	
	/**
     * @param className
     * @param classPk
     * @param doc
     * @param group
     * @param dlFileEntry
     * @return
     */
    private Document updateMerlinMetadata(String className, long classPk,Document doc, Group group, DLFileEntry dlFileEntry)
    {
        try
        {
            String searchEnabledTagName = CustomIndexerUtil.getGroupSearchEnabledTagName(className, classPk, "dl-search-tag-list");
            if (Validator.isNotNull(searchEnabledTagName))
            {
                doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_SOURCE,
                        PrefsPropsUtil.getString("meta-data-content-source-value"));
                doc.addKeyword(CustomIndexerConstant.META_DATA_RESOURCE_TYPE,
                        CustomIndexerUtil.getFileResourType(dlFileEntry));
                doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_TYPE,
                        PrefsPropsUtil.getString(CustomIndexerConstant.RESOURCE_CONTENT_TYPE+searchEnabledTagName));
                doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_LINK, CustomIndexerConstant.DOCUMENT
                        + dlFileEntry.getGroupId() + StringPool.SLASH + dlFileEntry.getUuid());
                doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_NAME, group.getName());
                doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_LINK,
                        CustomIndexerConstant.WEB + group.getFriendlyURL() + CustomIndexerConstant.HOME);
                doc.addKeyword(CustomIndexerConstant.META_DATA_PARENT_CONTENT_TYPE,
                        PrefsPropsUtil.getString(CustomIndexerConstant.PARENT_CONTENT_TYPE + searchEnabledTagName));
                _log.info("Added custom metadata for " + searchEnabledTagName + " to dlFileEntry- id: "+ dlFileEntry.getFileEntryId());
            }
        } catch (Exception e)
        {
            _log.error("Error while udating Merlin custom metadata  : " + e.getMessage(), e);
        }
        return doc;
    }
	
	
}
