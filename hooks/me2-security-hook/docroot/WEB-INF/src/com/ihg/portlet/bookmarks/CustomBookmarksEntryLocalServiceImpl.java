package com.ihg.portlet.bookmarks;

import com.ihg.portlet.security.util.SecurityConstants;
import com.ihg.portlet.security.util.SecurityUtil;
import com.liferay.portlet.bookmarks.model.BookmarksEntry;
import com.liferay.portlet.bookmarks.service.BookmarksEntryLocalService;
import com.liferay.portlet.bookmarks.service.BookmarksEntryLocalServiceWrapper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;

public class CustomBookmarksEntryLocalServiceImpl extends BookmarksEntryLocalServiceWrapper {

	private static final Log LOGGER = LogFactoryUtil.getLog(CustomBookmarksEntryLocalServiceImpl.class);
	
	public CustomBookmarksEntryLocalServiceImpl(BookmarksEntryLocalService bookmarksEntryLocalService) {
		super(bookmarksEntryLocalService);
		// TODO Auto-generated constructor stub
	}
	
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public BookmarksEntry addEntry(
			long userId, long groupId, long folderId, String name, String url,
			String description, ServiceContext serviceContext)
		throws PortalException, SystemException {
		
		BookmarksEntry bookmarksEntry = super.addEntry(userId, groupId, folderId, name, url, description, serviceContext);
		
		LOGGER.info("Creating  Book Mark In Service Hook");

		try {
			Group group = GroupLocalServiceUtil.getGroup(groupId);

			if (group.isOrganization()) {
				
				SecurityUtil.addDefaultCategoryAndRoleToBookmark(userId, group, bookmarksEntry);
				
			}else if (SecurityUtil.isCommunityHavingMerlinTagAndCommunityTag(group, SecurityConstants.COMMUNITY_TAGS_LIST)) {
				
				// Below code is to assign default role and default category to the Bookmark.

				SecurityUtil.addDefaultCategoriesToModel(
					userId, SecurityUtil.getGlobalGroupId(), group, BookmarksEntry.class.getName(),
					bookmarksEntry.getEntryId());

				SecurityUtil.updateRoles(bookmarksEntry);
			}
		} catch (PortalException e) {
			LOGGER.error("Unable to add default role and category while uploading the document." + e.getMessage());
		}
		return bookmarksEntry;
		
	}
	
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public BookmarksEntry updateEntry(
			long userId, long entryId, long groupId, long folderId, String name,
			String url, String description, ServiceContext serviceContext)
		throws PortalException, SystemException {
		
		BookmarksEntry bookmarksEntry =
				super.updateEntry(userId, entryId, groupId, folderId, name, url, description, serviceContext);

		LOGGER.info("Updating  Book Mark In Service Hook");
		
		try {
			Group group = GroupLocalServiceUtil.getGroup(groupId);
			
			if (group.isOrganization()) {
				
				SecurityUtil.addDefaultCategoryAndRoleToBookmark(userId, group, bookmarksEntry);
				
			}
			else if (SecurityUtil.isCommunityHavingMerlinTagAndCommunityTag(group, SecurityConstants.COMMUNITY_TAGS_LIST)) {

				// Below code is to assign default role and default category to the Bookmark.

				SecurityUtil.addDefaultCategoriesToModel(
					userId, SecurityUtil.getGlobalGroupId(), group, BookmarksEntry.class.getName(),
					bookmarksEntry.getEntryId());
				
				SecurityUtil.updateRoles(bookmarksEntry);
				
			}
		} catch (PortalException e) {
			LOGGER.error("Unable to add default role and category while uploading the document." + e.getMessage());
		}
		return bookmarksEntry;
	}
}
