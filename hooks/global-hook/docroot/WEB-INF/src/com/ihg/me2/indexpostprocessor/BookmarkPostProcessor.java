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
import com.liferay.portlet.bookmarks.model.BookmarksEntry;


public class BookmarkPostProcessor extends BaseIndexerPostProcessor {
	private static Log _log = LogFactoryUtil
			.getLog(BookmarkPostProcessor.class);

	
	@Override
	public void postProcessDocument(Document doc, Object obj)
			throws Exception {
		
		BookmarksEntry bookmarkEntry = (BookmarksEntry) obj;

		if (doc != null) {
			try {
					Group group = CustomIndexerUtil.getGroupById(bookmarkEntry.getGroupId());
					if(!group.isOrganization() && CustomIndexerUtil.isContentFromMerlin(group,PrefsPropsUtil.getString("tag-merlin"))){
						if(group.getName().equals(PrefsPropsUtil.getString("news-room-community-name"))){
							doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_SOURCE, PrefsPropsUtil.getString("meta-data-content-source-value"));
							doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_TYPE, PrefsPropsUtil.getString("meta-data-content-type-link"));
							doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_LINK,CustomIndexerConstant.BOOKMARK_LINK	+ bookmarkEntry.getEntryId());
							doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_NAME, CustomIndexerConstant.NEWS_PARENT_NAME);
							doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_LINK,CustomIndexerConstant.NEWS_PARENT_LINK);
							doc.addKeyword(CustomIndexerConstant.META_DATA_PARENT_CONTENT_TYPE, PrefsPropsUtil.getString("meta-data-content-type-news-article"));
						} else if(group.getName().equals(PrefsPropsUtil.getString("app-stor-community-name")) ){
							doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_SOURCE, PrefsPropsUtil.getString("meta-data-content-source-value"));
							doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_TYPE, PrefsPropsUtil.getString("meta-data-content-type-link"));
							doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_LINK,CustomIndexerConstant.BOOKMARK_LINK	+ bookmarkEntry.getEntryId());
							doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_NAME,CustomIndexerConstant.APPS_PARENT_NAME);
							doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_LINK,CustomIndexerConstant.APPS_PARENT_LINK);
							doc.addKeyword(CustomIndexerConstant.META_DATA_PARENT_CONTENT_TYPE, PrefsPropsUtil.getString("meta-data-content-type-application"));
						} else if(group.getName().equals(PrefsPropsUtil.getString("merlin-community-name")) ){
							doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_SOURCE, PrefsPropsUtil.getString("meta-data-content-source-value")	);
							doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_TYPE, PrefsPropsUtil.getString("meta-data-content-type-link"));
							doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_LINK,CustomIndexerConstant.BOOKMARK_LINK	+ bookmarkEntry.getEntryId());
							doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_NAME,CustomIndexerConstant.MERLIN_PARENT_NAME);
							doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_LINK,CustomIndexerConstant.MERLIN_PARENT_LINK);
							doc.addKeyword(CustomIndexerConstant.META_DATA_PARENT_CONTENT_TYPE, PrefsPropsUtil.getString("meta-data-content-type-teamspace"));
						} else if (CustomIndexerUtil.isContentFromMerlin(group,PrefsPropsUtil.getString("tag-teamspace"))){
							doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_SOURCE, PrefsPropsUtil.getString("meta-data-content-source-value"));
							doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_TYPE,  PrefsPropsUtil.getString("meta-data-content-type-link"));
							doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_LINK,CustomIndexerConstant.BOOKMARK_LINK	+ bookmarkEntry.getEntryId());
							doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_NAME,group.getName());
							doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_LINK,CustomIndexerConstant.WEB + group.getFriendlyURL() + CustomIndexerConstant.HOME);
							doc.addKeyword(CustomIndexerConstant.META_DATA_PARENT_CONTENT_TYPE, PrefsPropsUtil.getString("meta-data-content-type-teamspace"));
						}else{
						    doc=updateMerlinMetadata(Group.class.getName(), group.getGroupId(), doc, group, bookmarkEntry);
						}
					}else if (group.isOrganization() ){
						Organization org = CustomIndexerUtil.getOrganizationById(group.getClassPK());
						if(CustomIndexerUtil.isMerlinTag(Organization.class.getName(), org.getOrganizationId(), PrefsPropsUtil.getString("tag-merlin"))){
	                        if(CustomIndexerUtil.isOrganziationDepartment(org)){
								doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_SOURCE, PrefsPropsUtil.getString("meta-data-content-source-value"));
								doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_TYPE, PrefsPropsUtil.getString("meta-data-content-type-link"));
								doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_LINK, CustomIndexerConstant.BOOKMARK_LINK	+ bookmarkEntry.getEntryId());
								doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_NAME,group.getFriendlyURL().substring(1));
								doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_LINK,CustomIndexerConstant.WEB + group.getFriendlyURL() + CustomIndexerConstant.HOME);
								doc.addKeyword(CustomIndexerConstant.META_DATA_PARENT_CONTENT_TYPE,PrefsPropsUtil.getString("meta-data-content-type-department"));
	                        }else{
	                            Group orgGroup = CustomIndexerUtil.getGroupById(org.getGroup().getGroupId());
	                            doc=updateMerlinMetadata(Organization.class.getName(), org.getOrganizationId(), doc, orgGroup, bookmarkEntry);
	                        }
						}
					}
					_log.info("Indexing meta-data field from post processor for bookmark ");
				}catch (Exception ex) {
				_log.error("Problem while Bookmark indexer : " + ex.getMessage(), ex);
			}
			
			doc.addText("customModified_sortable", String.valueOf(bookmarkEntry.getModifiedDate().getTime()));
			
			_log.info("====================== customModified value added for =========== "+  bookmarkEntry.getEntryId());
		}
		super.postProcessDocument(doc, obj);
	}

   
    /**
     * @param className
     * @param classPk
     * @param doc
     * @param group
     * @param bookmarkEntry
     * @return
     */
    private Document updateMerlinMetadata(String className, long classPk,Document doc, Group group, BookmarksEntry bookmarkEntry)
    {
        try
        {
            String searchEnabledTagName=CustomIndexerUtil.getGroupSearchEnabledTagName(className,classPk,  "bookmark-search-tag-list");
            if(Validator.isNotNull(searchEnabledTagName))
            {
                doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_SOURCE, PrefsPropsUtil.getString("meta-data-content-source-value"));
                doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_TYPE,  PrefsPropsUtil.getString(CustomIndexerConstant.LINK_CONTENT_TYPE+searchEnabledTagName));
                doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_LINK,CustomIndexerConstant.BOOKMARK_LINK + bookmarkEntry.getEntryId());
                doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_NAME,group.getName());
                doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_LINK,CustomIndexerConstant.WEB + group.getFriendlyURL() + CustomIndexerConstant.HOME);
                doc.addKeyword(CustomIndexerConstant.META_DATA_PARENT_CONTENT_TYPE, PrefsPropsUtil.getString(CustomIndexerConstant.PARENT_CONTENT_TYPE+searchEnabledTagName));
                _log.info("Added custom metadata for "+searchEnabledTagName +" to bookmarkEntry id: "+ bookmarkEntry.getEntryId());
            }
        } catch (Exception e)
        {
            _log.error("Error while udating Merlin custom metadata  : " + e.getMessage(), e);
        }
        return doc;
    }
}
