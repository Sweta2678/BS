package com.ihg.journal;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.journal.ArticleDisplayDateException;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalService;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceWrapper;

import java.io.File;
import java.util.Locale;
import java.util.Map;

public class BFJournalArticle extends JournalArticleLocalServiceWrapper {

	public BFJournalArticle(JournalArticleLocalService journalArticleLocalService) {
		super(journalArticleLocalService);
		// TODO Auto-generated constructor stub
	}
			
	@Override
	public JournalArticle addArticle(long userId, long groupId, long folderId, long classNameId, long classPK, String articleId, boolean autoArticleId, 
			double version, Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, String content, String type, String ddmStructureKey, String ddmTemplateKey, 
			String layoutUuid, int displayDateMonth, int displayDateDay,	int displayDateYear, int displayDateHour, int displayDateMinute, int expirationDateMonth, int expirationDateDay, 
			int expirationDateYear, int expirationDateHour, int expirationDateMinute, boolean neverExpire, int reviewDateMonth, int reviewDateDay, int reviewDateYear,
			int reviewDateHour, int reviewDateMinute, boolean neverReview, boolean indexable, boolean smallImage, String smallImageURL,
			File smallFile, Map<String, byte[]> images, String articleURL, ServiceContext serviceContext) throws PortalException, SystemException {

		String communityName = GroupLocalServiceUtil.getGroup(groupId).getName();

		if (isBrandFrameworkCommunity(communityName)
				&& (serviceContext.getAssetCategoryIds() == null || serviceContext.getAssetCategoryIds().length == 0)) {
			throw new ArticleDisplayDateException("No Category Selected");
		}

		return super.addArticle(userId, groupId, folderId, classNameId, classPK, articleId, autoArticleId, version, titleMap, descriptionMap, 
				content, type, ddmStructureKey, ddmTemplateKey, layoutUuid, displayDateMonth, displayDateDay, displayDateYear, displayDateHour, displayDateMinute, expirationDateMonth, 
				expirationDateDay, expirationDateYear, expirationDateHour, expirationDateMinute, neverExpire, reviewDateMonth, reviewDateDay, reviewDateYear,
				reviewDateHour, reviewDateMinute, neverReview, indexable, smallImage, smallImageURL, smallFile, images, articleURL, serviceContext);
	}

	@Override
	public JournalArticle updateArticle(long userId, long groupId, long folderId, String articleId, double version, Map<Locale, String> titleMap,
			Map<Locale, String> descriptionMap, String content, String type, String ddmStructureKey, String ddmTemplateKey, String layoutUuid,
			int displayDateMonth, int displayDateDay, int displayDateYear, int displayDateHour, int displayDateMinute, int expirationDateMonth,
			int expirationDateDay, int expirationDateYear, int expirationDateHour, int expirationDateMinute, boolean neverExpire, int reviewDateMonth, 
			int reviewDateDay, int reviewDateYear, int reviewDateHour, int reviewDateMinute, boolean neverReview, boolean indexable, boolean smallImage,
			String smallImageURL, File smallImageFile, Map<String, byte[]> images, String articleURL, ServiceContext serviceContext) 
					throws PortalException, SystemException {

		String communityName = GroupLocalServiceUtil.getGroup(groupId).getName();

		if (isBrandFrameworkCommunity(communityName)
				&& (serviceContext.getAssetCategoryIds() == null || serviceContext.getAssetCategoryIds().length == 0)) {
			throw new ArticleDisplayDateException("No Category Selected");
		}

		return super.updateArticle(userId, groupId, folderId, articleId, version, titleMap, descriptionMap, content, type, ddmStructureKey, ddmTemplateKey, layoutUuid, 
				displayDateMonth, displayDateDay, displayDateYear, displayDateHour, displayDateMinute, expirationDateMonth, expirationDateDay, expirationDateYear,
				expirationDateHour, expirationDateMinute, neverExpire, reviewDateMonth, reviewDateDay, reviewDateYear, reviewDateHour,
				reviewDateMinute, neverReview, indexable, smallImage, smallImageURL, smallImageFile, images, articleURL, serviceContext);
	}

	private Boolean isBrandFrameworkCommunity(String name) {
		if (name.equalsIgnoreCase("Brand Framework EX")) {
			return true;
		}

		return false;
	}

}
