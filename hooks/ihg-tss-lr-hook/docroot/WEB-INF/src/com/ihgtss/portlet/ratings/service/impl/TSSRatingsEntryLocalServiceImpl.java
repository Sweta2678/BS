package com.ihgtss.portlet.ratings.service.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleServiceUtil;
import com.liferay.portlet.ratings.model.RatingsEntry;
import com.liferay.portlet.ratings.service.RatingsEntryLocalService;
import com.liferay.portlet.ratings.service.RatingsEntryLocalServiceWrapper;
import com.liferay.portlet.ratings.service.RatingsStatsLocalServiceUtil;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author leena.ruhela
 * 
 */
public class TSSRatingsEntryLocalServiceImpl extends RatingsEntryLocalServiceWrapper {

	/**
	 * @param ratingsEntryLocalService
	 */
	public TSSRatingsEntryLocalServiceImpl(RatingsEntryLocalService ratingsEntryLocalService) {

		super(ratingsEntryLocalService);
		// TODO Auto-generated constructor stub
	}

	private static final Log LOG = LogFactoryUtil.getLog(TSSRatingsEntryLocalServiceImpl.class);
	
	public RatingsEntry updateEntry(long userId, String className, long classPK, double score, ServiceContext serviceContext) throws PortalException, SystemException {
		RatingsEntry ratingEntry = super.updateEntry(userId, className, classPK, score, serviceContext);
		
		String journalClassName = JournalArticle.class.getName();
		if (journalClassName.equals(className)) {
			// Set ExpandoAttributes
			try {
				DynamicQuery query = DynamicQueryFactoryUtil.forClass(JournalArticle.class, "journalArticle", PortalClassLoaderUtil.getClassLoader());
				query.add(RestrictionsFactoryUtil.eq("articleId", String.valueOf(classPK)));
				
				List<JournalArticle> journalArticles = JournalArticleLocalServiceUtil.dynamicQuery(query);
				if(journalArticles != null && !journalArticles.isEmpty()) {
					JournalArticle journalArticle = JournalArticleLocalServiceUtil.getLatestArticle(journalArticles.get(0).getResourcePrimKey(), WorkflowConstants.STATUS_APPROVED);
					double customFieldValue = RatingsStatsLocalServiceUtil.getStats(JournalArticle.class.getName(), Long.valueOf(journalArticle.getArticleId())).getTotalScore();
					ExpandoTable expandoTable = ExpandoTableLocalServiceUtil.getDefaultTable(journalArticle.getCompanyId(), JournalArticle.class.getName());
					ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(expandoTable.getTableId(), "averageScore");					
					if (column != null) {
						ExpandoValue val = null;
						Serializable itemValue = (Serializable) customFieldValue;
						val = ExpandoValueLocalServiceUtil.addValue(journalArticle.getCompanyId(), JournalArticle.class.getName(), expandoTable.getName(), column.getName(), journalArticle.getId(), itemValue);
						
						if (val == null) {
							throw new SystemException(
									"Could not add expando value: class: "
											+ JournalArticle.class.getName() + ", table: " + expandoTable.getName()
											+ ", column: " + column.getName() + " classPKId: "
											+ classPK);
						}
					}
				//	reIndex(journalArticle.getIndexable(), JournalArticle.class.getName(), journalArticle.getResourcePrimKey());
				}
			} catch (PortalException e) {
				LOG.error("unable to set ExpandoAttributes on JournalArticle", e);
			}
		}
		return ratingEntry;
	}
	
	/**
	 * Reindex the journal article
	 * @param isIndexEnabled (for the journal article)
	 * @param className
	 * @param classPK
	 */
	void reIndex(boolean isIndexEnabled, String className, long classPK) {
		if (!isIndexEnabled) {
			return;
		}
		Indexer indexer = IndexerRegistryUtil.getIndexer(className);
		if (indexer != null) {
			try {
				indexer.reindex(className, classPK);
			} catch (Exception e) {
				LOG.error("reindex journal article error", e);
			}
		}
	}
}
