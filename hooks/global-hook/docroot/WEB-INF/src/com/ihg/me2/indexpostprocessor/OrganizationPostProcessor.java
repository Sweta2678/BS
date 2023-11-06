package com.ihg.me2.indexpostprocessor;

import com.ihg.me2.indexpostprocessor.util.CustomIndexerConstant;
import com.ihg.me2.indexpostprocessor.util.CustomIndexerUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexerPostProcessor;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Organization;


public class OrganizationPostProcessor extends BaseIndexerPostProcessor 
{
	private static Log _log = LogFactoryUtil.getLog(OrganizationPostProcessor.class);
	
	@Override
	public void postProcessDocument(Document doc, Object obj)
			throws Exception {
		Organization org = (Organization) obj;
		if (doc != null) {
			try {	
			    
			    /*Asset tag and category added into document as OrganizationIndexer super class is not adding it*/
		        /*Below code is not needed as it has been taken care in this version (6.2) super class*/
			    /*long[] assetCategoryIds = AssetCategoryLocalServiceUtil.getCategoryIds(
	                                Organization.class.getName(), org.getOrganizationId());
			    String[] assetTagNames = AssetTagLocalServiceUtil.getTagNames(
	                                Organization.class.getName(), org.getOrganizationId());
	                        String[] assetCategoryNames = AssetCategoryLocalServiceUtil.getCategoryNames(
	                                Organization.class.getName(), org.getOrganizationId());
	                        doc.addKeyword(Field.ASSET_CATEGORY_IDS, assetCategoryIds);
	                        doc.addKeyword(Field.ASSET_TAG_NAMES, assetTagNames);
	                        doc.addKeyword(Field.ASSET_CATEGORY_NAMES, assetCategoryNames);*/
				
				if(CustomIndexerUtil.isMerlinTag(Organization.class.getName(), org.getOrganizationId(), PrefsPropsUtil.getString("tag-merlin")))
				{
				    Group group = CustomIndexerUtil.getGroupById(org.getGroup().getGroupId());
				    if(CustomIndexerUtil.isOrganziationDepartment(org))
				    {
					doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_SOURCE, PrefsPropsUtil.getString("meta-data-content-source-value")	);
					doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_TYPE, PrefsPropsUtil.getString("meta-data-content-type-department"));
					doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_LINK, CustomIndexerConstant.WEB+ group.getFriendlyURL() + CustomIndexerConstant.HOME);//"/web/" + org.getName() + "/home"
					doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_NAME, CustomIndexerConstant.ORGANIZATION_PARENT );
					doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_LINK, CustomIndexerConstant.ORGANIZATION_PARENT_LINK	);// "/web/" + org.getParentOrganization().getName() + "/home"
					_log.info("Indexing meta-data field from Post processor for Department ");
				    }else
				    {
				        doc=updateMerlinMetadata(Organization.class.getName(), org.getOrganizationId(), doc, group);
				    }
				}

			} catch (Exception ex) {
				
				_log.error("Problem while Organization indexer : " + ex.getMessage(), ex);
			}
		}

		doc.addText("customModified_sortable", String.valueOf(org.getModifiedDate().getTime()));
		_log.info("====================== customModified value added for =========== "+  org.getOrganizationId());
		
		super.postProcessDocument(doc, obj);
	}
	
	
    /**
     * @param className
     * @param classPk
     * @param doc
     * @param group
     * @return updated solr document with merlin custom metadata
     */
    private Document updateMerlinMetadata(String className, long classPk, Document doc, Group group)
    {
        try
        {
            String searchEnabledTagName = CustomIndexerUtil.getGroupSearchEnabledTagName(className,classPk,"org-search-tag-list");
            if (Validator.isNotNull(searchEnabledTagName))
            {
                doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_SOURCE, PrefsPropsUtil.getString("meta-data-content-source-value"));
                String parentContentTypeKey=CustomIndexerConstant.PARENT_CONTENT_TYPE+searchEnabledTagName;
                doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_TYPE, PrefsPropsUtil.getString(parentContentTypeKey));
                doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_LINK, CustomIndexerConstant.WEB+ group.getFriendlyURL() + CustomIndexerConstant.HOME);
                doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_NAME, PrefsPropsUtil.getString(parentContentTypeKey));
                doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_LINK, PrefsPropsUtil.getString(CustomIndexerConstant.PARENT_LINK+searchEnabledTagName));
                _log.info("Added custom metadata for " + searchEnabledTagName + " to Organization id: "+ classPk);
            }
        } catch (Exception e)
        {
            _log.error("Error while udating Merlin custom metadata  : " + e.getMessage(), e);
        }
        return doc;
    }
}
