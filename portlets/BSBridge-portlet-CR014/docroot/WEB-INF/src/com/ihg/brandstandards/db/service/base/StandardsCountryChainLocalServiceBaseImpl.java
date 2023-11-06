/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.ihg.brandstandards.db.service.base;

import com.ihg.brandstandards.db.model.StandardsCountryChain;
import com.ihg.brandstandards.db.service.StandardsCountryChainLocalService;
import com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsCountryPersistence;
import com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsFinder;
import com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPersistence;
import com.ihg.brandstandards.db.service.persistence.BrandArticleFinder;
import com.ihg.brandstandards.db.service.persistence.BrandTaxonomyPersistence;
import com.ihg.brandstandards.db.service.persistence.BrandTaxonomyTranslatePersistence;
import com.ihg.brandstandards.db.service.persistence.BridgeGlobalPublishCountryPersistence;
import com.ihg.brandstandards.db.service.persistence.BridgeGlobalPublishFinder;
import com.ihg.brandstandards.db.service.persistence.BridgeGlobalPublishPersistence;
import com.ihg.brandstandards.db.service.persistence.BridgePublishCountryFinder;
import com.ihg.brandstandards.db.service.persistence.BridgePublishCountryPersistence;
import com.ihg.brandstandards.db.service.persistence.BridgePublishCountryStateExFinder;
import com.ihg.brandstandards.db.service.persistence.BridgePublishCountryStateExPersistence;
import com.ihg.brandstandards.db.service.persistence.BridgePublishFinder;
import com.ihg.brandstandards.db.service.persistence.BridgePublishImportFinder;
import com.ihg.brandstandards.db.service.persistence.BridgePublishImportPersistence;
import com.ihg.brandstandards.db.service.persistence.BridgePublishLangFinder;
import com.ihg.brandstandards.db.service.persistence.BridgePublishLangPersistence;
import com.ihg.brandstandards.db.service.persistence.BridgePublishPersistence;
import com.ihg.brandstandards.db.service.persistence.BridgePublishPreviewFinder;
import com.ihg.brandstandards.db.service.persistence.BridgePublishPreviewPersistence;
import com.ihg.brandstandards.db.service.persistence.BridgePublishStateExFinder;
import com.ihg.brandstandards.db.service.persistence.BridgePublishStateExPersistence;
import com.ihg.brandstandards.db.service.persistence.BridgePublishStatusPersistence;
import com.ihg.brandstandards.db.service.persistence.BusImpactAssmtPersistence;
import com.ihg.brandstandards.db.service.persistence.ChainAttachmentsStandardsPersistence;
import com.ihg.brandstandards.db.service.persistence.ChainExternalLinkStandardsPersistence;
import com.ihg.brandstandards.db.service.persistence.ChainStandardsPersistence;
import com.ihg.brandstandards.db.service.persistence.CountryStandardsExtFinder;
import com.ihg.brandstandards.db.service.persistence.CountryStandardsExtPersistence;
import com.ihg.brandstandards.db.service.persistence.CountryStandardsPersistence;
import com.ihg.brandstandards.db.service.persistence.DepartmentFinder;
import com.ihg.brandstandards.db.service.persistence.DepartmentPersistence;
import com.ihg.brandstandards.db.service.persistence.ErrNotificationFinder;
import com.ihg.brandstandards.db.service.persistence.ErrNotificationPersistence;
import com.ihg.brandstandards.db.service.persistence.ExternalLinkStandardsCountryPersistence;
import com.ihg.brandstandards.db.service.persistence.ExternalLinkStandardsFinder;
import com.ihg.brandstandards.db.service.persistence.ExternalLinkStandardsPersistence;
import com.ihg.brandstandards.db.service.persistence.FlagCategoryFinder;
import com.ihg.brandstandards.db.service.persistence.FlagCategoryPersistence;
import com.ihg.brandstandards.db.service.persistence.FlagStandardsFinder;
import com.ihg.brandstandards.db.service.persistence.FlagStandardsPersistence;
import com.ihg.brandstandards.db.service.persistence.GEMCategoryFinder;
import com.ihg.brandstandards.db.service.persistence.GEMCategoryPersistence;
import com.ihg.brandstandards.db.service.persistence.GEMChainMeasurementPersistence;
import com.ihg.brandstandards.db.service.persistence.GEMCodePersistence;
import com.ihg.brandstandards.db.service.persistence.GEMGeneratedReportPersistence;
import com.ihg.brandstandards.db.service.persistence.GEMGeneratedReportValPersistence;
import com.ihg.brandstandards.db.service.persistence.GEMManagementBucketPersistence;
import com.ihg.brandstandards.db.service.persistence.GEMManagementIdFinder;
import com.ihg.brandstandards.db.service.persistence.GEMManagementIdPersistence;
import com.ihg.brandstandards.db.service.persistence.GEMMeasurementBucketChainPersistence;
import com.ihg.brandstandards.db.service.persistence.GEMMeasurementFormulaPersistence;
import com.ihg.brandstandards.db.service.persistence.GEMMeasurementFormulaValuePersistence;
import com.ihg.brandstandards.db.service.persistence.GEMMeasurementPersistence;
import com.ihg.brandstandards.db.service.persistence.GEMMeasurementTypePersistence;
import com.ihg.brandstandards.db.service.persistence.GEMQlReportFinder;
import com.ihg.brandstandards.db.service.persistence.GEMQlReportPersistence;
import com.ihg.brandstandards.db.service.persistence.GEMRoleFinder;
import com.ihg.brandstandards.db.service.persistence.GEMRolePersistence;
import com.ihg.brandstandards.db.service.persistence.GEMScoringValuePersistence;
import com.ihg.brandstandards.db.service.persistence.GEMSeverityPersistence;
import com.ihg.brandstandards.db.service.persistence.GEMStdCategoryPersistence;
import com.ihg.brandstandards.db.service.persistence.GEMTemplateCategoryPersistence;
import com.ihg.brandstandards.db.service.persistence.GEMTemplateColumnFinder;
import com.ihg.brandstandards.db.service.persistence.GEMTemplateColumnPersistence;
import com.ihg.brandstandards.db.service.persistence.GEMTemplateFinder;
import com.ihg.brandstandards.db.service.persistence.GEMTemplatePersistence;
import com.ihg.brandstandards.db.service.persistence.GEMTemplateReferencePersistence;
import com.ihg.brandstandards.db.service.persistence.GEMTemplateValuesPersistence;
import com.ihg.brandstandards.db.service.persistence.GEMTriggerPersistence;
import com.ihg.brandstandards.db.service.persistence.GEMUniqueGroupCountryFinder;
import com.ihg.brandstandards.db.service.persistence.GEMUniqueGroupCountryPersistence;
import com.ihg.brandstandards.db.service.persistence.GEMUniqueGroupFinder;
import com.ihg.brandstandards.db.service.persistence.GEMUniqueGroupPersistence;
import com.ihg.brandstandards.db.service.persistence.GEMUniqueGroupStandardPersistence;
import com.ihg.brandstandards.db.service.persistence.GlossaryExtFinder;
import com.ihg.brandstandards.db.service.persistence.GlossaryExtPersistence;
import com.ihg.brandstandards.db.service.persistence.GlossaryFinder;
import com.ihg.brandstandards.db.service.persistence.GlossaryPersistence;
import com.ihg.brandstandards.db.service.persistence.GlossaryRegionNavPersistence;
import com.ihg.brandstandards.db.service.persistence.GlossaryTranslatePersistence;
import com.ihg.brandstandards.db.service.persistence.HistManualAttachmentPersistence;
import com.ihg.brandstandards.db.service.persistence.HistManualChainPersistence;
import com.ihg.brandstandards.db.service.persistence.HistManualRegionPersistence;
import com.ihg.brandstandards.db.service.persistence.HistManualsFinder;
import com.ihg.brandstandards.db.service.persistence.HistManualsPersistence;
import com.ihg.brandstandards.db.service.persistence.ImageFinder;
import com.ihg.brandstandards.db.service.persistence.ImagePersistence;
import com.ihg.brandstandards.db.service.persistence.JobQueueFinder;
import com.ihg.brandstandards.db.service.persistence.JobQueuePersistence;
import com.ihg.brandstandards.db.service.persistence.MustPublishFinder;
import com.ihg.brandstandards.db.service.persistence.MustPublishPersistence;
import com.ihg.brandstandards.db.service.persistence.PublicationFinder;
import com.ihg.brandstandards.db.service.persistence.PublicationPersistence;
import com.ihg.brandstandards.db.service.persistence.PublishCountryStandardPersistence;
import com.ihg.brandstandards.db.service.persistence.PublishDeptFinder;
import com.ihg.brandstandards.db.service.persistence.PublishDeptPersistence;
import com.ihg.brandstandards.db.service.persistence.PublishExtStdPersistence;
import com.ihg.brandstandards.db.service.persistence.PublishParmFinder;
import com.ihg.brandstandards.db.service.persistence.PublishParmPersistence;
import com.ihg.brandstandards.db.service.persistence.PublishQueueFinder;
import com.ihg.brandstandards.db.service.persistence.PublishQueuePersistence;
import com.ihg.brandstandards.db.service.persistence.PublishStandardsExtFinder;
import com.ihg.brandstandards.db.service.persistence.PublishStandardsExtPersistence;
import com.ihg.brandstandards.db.service.persistence.PublishStdFinder;
import com.ihg.brandstandards.db.service.persistence.PublishStdPersistence;
import com.ihg.brandstandards.db.service.persistence.PublishTaxonomyExtFinder;
import com.ihg.brandstandards.db.service.persistence.PublishTaxonomyExtPersistence;
import com.ihg.brandstandards.db.service.persistence.PublishTaxonomyPersistence;
import com.ihg.brandstandards.db.service.persistence.PublishedPdfListPersistence;
import com.ihg.brandstandards.db.service.persistence.SpecialWordDictionaryPersistence;
import com.ihg.brandstandards.db.service.persistence.SpreadSheetAttributeUpdateFinder;
import com.ihg.brandstandards.db.service.persistence.SpreadSheetAttributeUpdatePersistence;
import com.ihg.brandstandards.db.service.persistence.StandardsAuthorsPersistence;
import com.ihg.brandstandards.db.service.persistence.StandardsChainImagesPersistence;
import com.ihg.brandstandards.db.service.persistence.StandardsComplianceExtFinder;
import com.ihg.brandstandards.db.service.persistence.StandardsComplianceExtPersistence;
import com.ihg.brandstandards.db.service.persistence.StandardsComplianceFinder;
import com.ihg.brandstandards.db.service.persistence.StandardsCompliancePersistence;
import com.ihg.brandstandards.db.service.persistence.StandardsCountryChainFinder;
import com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK;
import com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPersistence;
import com.ihg.brandstandards.db.service.persistence.StandardsCountryExtFinder;
import com.ihg.brandstandards.db.service.persistence.StandardsCountryExtPersistence;
import com.ihg.brandstandards.db.service.persistence.StandardsCountryImagesPersistence;
import com.ihg.brandstandards.db.service.persistence.StandardsCountryPersistence;
import com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePersistence;
import com.ihg.brandstandards.db.service.persistence.StandardsDisplayOrderExtFinder;
import com.ihg.brandstandards.db.service.persistence.StandardsDisplayOrderExtPersistence;
import com.ihg.brandstandards.db.service.persistence.StandardsDisplayOrderPersistence;
import com.ihg.brandstandards.db.service.persistence.StandardsExtFinder;
import com.ihg.brandstandards.db.service.persistence.StandardsExtPersistence;
import com.ihg.brandstandards.db.service.persistence.StandardsFinder;
import com.ihg.brandstandards.db.service.persistence.StandardsHistoricalManualFinder;
import com.ihg.brandstandards.db.service.persistence.StandardsHistoricalManualPersistence;
import com.ihg.brandstandards.db.service.persistence.StandardsImagesFinder;
import com.ihg.brandstandards.db.service.persistence.StandardsImagesPersistence;
import com.ihg.brandstandards.db.service.persistence.StandardsLocaleFinder;
import com.ihg.brandstandards.db.service.persistence.StandardsLocalePersistence;
import com.ihg.brandstandards.db.service.persistence.StandardsPersistence;
import com.ihg.brandstandards.db.service.persistence.StandardsRegionChainPersistence;
import com.ihg.brandstandards.db.service.persistence.StandardsRegionLocalePersistence;
import com.ihg.brandstandards.db.service.persistence.StandardsRegionPersistence;
import com.ihg.brandstandards.db.service.persistence.StandardsStatusPersistence;
import com.ihg.brandstandards.db.service.persistence.StandardsTranslatePersistence;
import com.ihg.brandstandards.db.service.persistence.TaxonomyExtFinder;
import com.ihg.brandstandards.db.service.persistence.TaxonomyExtPersistence;
import com.ihg.brandstandards.db.service.persistence.TaxonomyFinder;
import com.ihg.brandstandards.db.service.persistence.TaxonomyPersistence;
import com.ihg.brandstandards.db.service.persistence.TaxonomyStandardsPersistence;
import com.ihg.brandstandards.db.service.persistence.TaxonomyTranslatePersistence;
import com.ihg.brandstandards.db.service.persistence.TreeXMLPersistence;
import com.ihg.brandstandards.db.service.persistence.UIElementFinder;
import com.ihg.brandstandards.db.service.persistence.UIElementPersistence;
import com.ihg.brandstandards.db.service.persistence.UIElementTranslatePersistence;
import com.ihg.brandstandards.db.service.persistence.UniqueGroupCountryFinder;
import com.ihg.brandstandards.db.service.persistence.UniqueGroupCountryPersistence;
import com.ihg.brandstandards.db.service.persistence.UniqueGroupFinder;
import com.ihg.brandstandards.db.service.persistence.UniqueGroupPersistence;
import com.ihg.brandstandards.db.service.persistence.UniqueGroupStandardPersistence;
import com.ihg.brandstandards.db.service.persistence.UserPreferenceFinder;
import com.ihg.brandstandards.db.service.persistence.UserPreferencePersistence;
import com.ihg.brandstandards.db.service.persistence.UserSearchCriteriaPersistence;
import com.ihg.brandstandards.db.service.persistence.WorkflowPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the standards country chain local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.ihg.brandstandards.db.service.impl.StandardsCountryChainLocalServiceImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.impl.StandardsCountryChainLocalServiceImpl
 * @see com.ihg.brandstandards.db.service.StandardsCountryChainLocalServiceUtil
 * @generated
 */
public abstract class StandardsCountryChainLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements StandardsCountryChainLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.ihg.brandstandards.db.service.StandardsCountryChainLocalServiceUtil} to access the standards country chain local service.
	 */

	/**
	 * Adds the standards country chain to the database. Also notifies the appropriate model listeners.
	 *
	 * @param standardsCountryChain the standards country chain
	 * @return the standards country chain that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public StandardsCountryChain addStandardsCountryChain(
		StandardsCountryChain standardsCountryChain) throws SystemException {
		standardsCountryChain.setNew(true);

		return standardsCountryChainPersistence.update(standardsCountryChain);
	}

	/**
	 * Creates a new standards country chain with the primary key. Does not add the standards country chain to the database.
	 *
	 * @param standardsCountryChainPK the primary key for the new standards country chain
	 * @return the new standards country chain
	 */
	@Override
	public StandardsCountryChain createStandardsCountryChain(
		StandardsCountryChainPK standardsCountryChainPK) {
		return standardsCountryChainPersistence.create(standardsCountryChainPK);
	}

	/**
	 * Deletes the standards country chain with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param standardsCountryChainPK the primary key of the standards country chain
	 * @return the standards country chain that was removed
	 * @throws PortalException if a standards country chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public StandardsCountryChain deleteStandardsCountryChain(
		StandardsCountryChainPK standardsCountryChainPK)
		throws PortalException, SystemException {
		return standardsCountryChainPersistence.remove(standardsCountryChainPK);
	}

	/**
	 * Deletes the standards country chain from the database. Also notifies the appropriate model listeners.
	 *
	 * @param standardsCountryChain the standards country chain
	 * @return the standards country chain that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public StandardsCountryChain deleteStandardsCountryChain(
		StandardsCountryChain standardsCountryChain) throws SystemException {
		return standardsCountryChainPersistence.remove(standardsCountryChain);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(StandardsCountryChain.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return standardsCountryChainPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return standardsCountryChainPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return standardsCountryChainPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return standardsCountryChainPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return standardsCountryChainPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public StandardsCountryChain fetchStandardsCountryChain(
		StandardsCountryChainPK standardsCountryChainPK)
		throws SystemException {
		return standardsCountryChainPersistence.fetchByPrimaryKey(standardsCountryChainPK);
	}

	/**
	 * Returns the standards country chain with the primary key.
	 *
	 * @param standardsCountryChainPK the primary key of the standards country chain
	 * @return the standards country chain
	 * @throws PortalException if a standards country chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsCountryChain getStandardsCountryChain(
		StandardsCountryChainPK standardsCountryChainPK)
		throws PortalException, SystemException {
		return standardsCountryChainPersistence.findByPrimaryKey(standardsCountryChainPK);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return standardsCountryChainPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the standards country chains.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards country chains
	 * @param end the upper bound of the range of standards country chains (not inclusive)
	 * @return the range of standards country chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsCountryChain> getStandardsCountryChains(int start,
		int end) throws SystemException {
		return standardsCountryChainPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of standards country chains.
	 *
	 * @return the number of standards country chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getStandardsCountryChainsCount() throws SystemException {
		return standardsCountryChainPersistence.countAll();
	}

	/**
	 * Updates the standards country chain in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param standardsCountryChain the standards country chain
	 * @return the standards country chain that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public StandardsCountryChain updateStandardsCountryChain(
		StandardsCountryChain standardsCountryChain) throws SystemException {
		return standardsCountryChainPersistence.update(standardsCountryChain);
	}

	/**
	 * Returns the attachments standards local service.
	 *
	 * @return the attachments standards local service
	 */
	public com.ihg.brandstandards.db.service.AttachmentsStandardsLocalService getAttachmentsStandardsLocalService() {
		return attachmentsStandardsLocalService;
	}

	/**
	 * Sets the attachments standards local service.
	 *
	 * @param attachmentsStandardsLocalService the attachments standards local service
	 */
	public void setAttachmentsStandardsLocalService(
		com.ihg.brandstandards.db.service.AttachmentsStandardsLocalService attachmentsStandardsLocalService) {
		this.attachmentsStandardsLocalService = attachmentsStandardsLocalService;
	}

	/**
	 * Returns the attachments standards persistence.
	 *
	 * @return the attachments standards persistence
	 */
	public AttachmentsStandardsPersistence getAttachmentsStandardsPersistence() {
		return attachmentsStandardsPersistence;
	}

	/**
	 * Sets the attachments standards persistence.
	 *
	 * @param attachmentsStandardsPersistence the attachments standards persistence
	 */
	public void setAttachmentsStandardsPersistence(
		AttachmentsStandardsPersistence attachmentsStandardsPersistence) {
		this.attachmentsStandardsPersistence = attachmentsStandardsPersistence;
	}

	/**
	 * Returns the attachments standards finder.
	 *
	 * @return the attachments standards finder
	 */
	public AttachmentsStandardsFinder getAttachmentsStandardsFinder() {
		return attachmentsStandardsFinder;
	}

	/**
	 * Sets the attachments standards finder.
	 *
	 * @param attachmentsStandardsFinder the attachments standards finder
	 */
	public void setAttachmentsStandardsFinder(
		AttachmentsStandardsFinder attachmentsStandardsFinder) {
		this.attachmentsStandardsFinder = attachmentsStandardsFinder;
	}

	/**
	 * Returns the attachments standards country local service.
	 *
	 * @return the attachments standards country local service
	 */
	public com.ihg.brandstandards.db.service.AttachmentsStandardsCountryLocalService getAttachmentsStandardsCountryLocalService() {
		return attachmentsStandardsCountryLocalService;
	}

	/**
	 * Sets the attachments standards country local service.
	 *
	 * @param attachmentsStandardsCountryLocalService the attachments standards country local service
	 */
	public void setAttachmentsStandardsCountryLocalService(
		com.ihg.brandstandards.db.service.AttachmentsStandardsCountryLocalService attachmentsStandardsCountryLocalService) {
		this.attachmentsStandardsCountryLocalService = attachmentsStandardsCountryLocalService;
	}

	/**
	 * Returns the attachments standards country persistence.
	 *
	 * @return the attachments standards country persistence
	 */
	public AttachmentsStandardsCountryPersistence getAttachmentsStandardsCountryPersistence() {
		return attachmentsStandardsCountryPersistence;
	}

	/**
	 * Sets the attachments standards country persistence.
	 *
	 * @param attachmentsStandardsCountryPersistence the attachments standards country persistence
	 */
	public void setAttachmentsStandardsCountryPersistence(
		AttachmentsStandardsCountryPersistence attachmentsStandardsCountryPersistence) {
		this.attachmentsStandardsCountryPersistence = attachmentsStandardsCountryPersistence;
	}

	/**
	 * Returns the brand article local service.
	 *
	 * @return the brand article local service
	 */
	public com.ihg.brandstandards.db.service.BrandArticleLocalService getBrandArticleLocalService() {
		return brandArticleLocalService;
	}

	/**
	 * Sets the brand article local service.
	 *
	 * @param brandArticleLocalService the brand article local service
	 */
	public void setBrandArticleLocalService(
		com.ihg.brandstandards.db.service.BrandArticleLocalService brandArticleLocalService) {
		this.brandArticleLocalService = brandArticleLocalService;
	}

	/**
	 * Returns the brand article finder.
	 *
	 * @return the brand article finder
	 */
	public BrandArticleFinder getBrandArticleFinder() {
		return brandArticleFinder;
	}

	/**
	 * Sets the brand article finder.
	 *
	 * @param brandArticleFinder the brand article finder
	 */
	public void setBrandArticleFinder(BrandArticleFinder brandArticleFinder) {
		this.brandArticleFinder = brandArticleFinder;
	}

	/**
	 * Returns the brand taxonomy local service.
	 *
	 * @return the brand taxonomy local service
	 */
	public com.ihg.brandstandards.db.service.BrandTaxonomyLocalService getBrandTaxonomyLocalService() {
		return brandTaxonomyLocalService;
	}

	/**
	 * Sets the brand taxonomy local service.
	 *
	 * @param brandTaxonomyLocalService the brand taxonomy local service
	 */
	public void setBrandTaxonomyLocalService(
		com.ihg.brandstandards.db.service.BrandTaxonomyLocalService brandTaxonomyLocalService) {
		this.brandTaxonomyLocalService = brandTaxonomyLocalService;
	}

	/**
	 * Returns the brand taxonomy persistence.
	 *
	 * @return the brand taxonomy persistence
	 */
	public BrandTaxonomyPersistence getBrandTaxonomyPersistence() {
		return brandTaxonomyPersistence;
	}

	/**
	 * Sets the brand taxonomy persistence.
	 *
	 * @param brandTaxonomyPersistence the brand taxonomy persistence
	 */
	public void setBrandTaxonomyPersistence(
		BrandTaxonomyPersistence brandTaxonomyPersistence) {
		this.brandTaxonomyPersistence = brandTaxonomyPersistence;
	}

	/**
	 * Returns the brand taxonomy translate local service.
	 *
	 * @return the brand taxonomy translate local service
	 */
	public com.ihg.brandstandards.db.service.BrandTaxonomyTranslateLocalService getBrandTaxonomyTranslateLocalService() {
		return brandTaxonomyTranslateLocalService;
	}

	/**
	 * Sets the brand taxonomy translate local service.
	 *
	 * @param brandTaxonomyTranslateLocalService the brand taxonomy translate local service
	 */
	public void setBrandTaxonomyTranslateLocalService(
		com.ihg.brandstandards.db.service.BrandTaxonomyTranslateLocalService brandTaxonomyTranslateLocalService) {
		this.brandTaxonomyTranslateLocalService = brandTaxonomyTranslateLocalService;
	}

	/**
	 * Returns the brand taxonomy translate persistence.
	 *
	 * @return the brand taxonomy translate persistence
	 */
	public BrandTaxonomyTranslatePersistence getBrandTaxonomyTranslatePersistence() {
		return brandTaxonomyTranslatePersistence;
	}

	/**
	 * Sets the brand taxonomy translate persistence.
	 *
	 * @param brandTaxonomyTranslatePersistence the brand taxonomy translate persistence
	 */
	public void setBrandTaxonomyTranslatePersistence(
		BrandTaxonomyTranslatePersistence brandTaxonomyTranslatePersistence) {
		this.brandTaxonomyTranslatePersistence = brandTaxonomyTranslatePersistence;
	}

	/**
	 * Returns the bridge global publish local service.
	 *
	 * @return the bridge global publish local service
	 */
	public com.ihg.brandstandards.db.service.BridgeGlobalPublishLocalService getBridgeGlobalPublishLocalService() {
		return bridgeGlobalPublishLocalService;
	}

	/**
	 * Sets the bridge global publish local service.
	 *
	 * @param bridgeGlobalPublishLocalService the bridge global publish local service
	 */
	public void setBridgeGlobalPublishLocalService(
		com.ihg.brandstandards.db.service.BridgeGlobalPublishLocalService bridgeGlobalPublishLocalService) {
		this.bridgeGlobalPublishLocalService = bridgeGlobalPublishLocalService;
	}

	/**
	 * Returns the bridge global publish persistence.
	 *
	 * @return the bridge global publish persistence
	 */
	public BridgeGlobalPublishPersistence getBridgeGlobalPublishPersistence() {
		return bridgeGlobalPublishPersistence;
	}

	/**
	 * Sets the bridge global publish persistence.
	 *
	 * @param bridgeGlobalPublishPersistence the bridge global publish persistence
	 */
	public void setBridgeGlobalPublishPersistence(
		BridgeGlobalPublishPersistence bridgeGlobalPublishPersistence) {
		this.bridgeGlobalPublishPersistence = bridgeGlobalPublishPersistence;
	}

	/**
	 * Returns the bridge global publish finder.
	 *
	 * @return the bridge global publish finder
	 */
	public BridgeGlobalPublishFinder getBridgeGlobalPublishFinder() {
		return bridgeGlobalPublishFinder;
	}

	/**
	 * Sets the bridge global publish finder.
	 *
	 * @param bridgeGlobalPublishFinder the bridge global publish finder
	 */
	public void setBridgeGlobalPublishFinder(
		BridgeGlobalPublishFinder bridgeGlobalPublishFinder) {
		this.bridgeGlobalPublishFinder = bridgeGlobalPublishFinder;
	}

	/**
	 * Returns the bridge global publish country local service.
	 *
	 * @return the bridge global publish country local service
	 */
	public com.ihg.brandstandards.db.service.BridgeGlobalPublishCountryLocalService getBridgeGlobalPublishCountryLocalService() {
		return bridgeGlobalPublishCountryLocalService;
	}

	/**
	 * Sets the bridge global publish country local service.
	 *
	 * @param bridgeGlobalPublishCountryLocalService the bridge global publish country local service
	 */
	public void setBridgeGlobalPublishCountryLocalService(
		com.ihg.brandstandards.db.service.BridgeGlobalPublishCountryLocalService bridgeGlobalPublishCountryLocalService) {
		this.bridgeGlobalPublishCountryLocalService = bridgeGlobalPublishCountryLocalService;
	}

	/**
	 * Returns the bridge global publish country persistence.
	 *
	 * @return the bridge global publish country persistence
	 */
	public BridgeGlobalPublishCountryPersistence getBridgeGlobalPublishCountryPersistence() {
		return bridgeGlobalPublishCountryPersistence;
	}

	/**
	 * Sets the bridge global publish country persistence.
	 *
	 * @param bridgeGlobalPublishCountryPersistence the bridge global publish country persistence
	 */
	public void setBridgeGlobalPublishCountryPersistence(
		BridgeGlobalPublishCountryPersistence bridgeGlobalPublishCountryPersistence) {
		this.bridgeGlobalPublishCountryPersistence = bridgeGlobalPublishCountryPersistence;
	}

	/**
	 * Returns the bridge publish local service.
	 *
	 * @return the bridge publish local service
	 */
	public com.ihg.brandstandards.db.service.BridgePublishLocalService getBridgePublishLocalService() {
		return bridgePublishLocalService;
	}

	/**
	 * Sets the bridge publish local service.
	 *
	 * @param bridgePublishLocalService the bridge publish local service
	 */
	public void setBridgePublishLocalService(
		com.ihg.brandstandards.db.service.BridgePublishLocalService bridgePublishLocalService) {
		this.bridgePublishLocalService = bridgePublishLocalService;
	}

	/**
	 * Returns the bridge publish persistence.
	 *
	 * @return the bridge publish persistence
	 */
	public BridgePublishPersistence getBridgePublishPersistence() {
		return bridgePublishPersistence;
	}

	/**
	 * Sets the bridge publish persistence.
	 *
	 * @param bridgePublishPersistence the bridge publish persistence
	 */
	public void setBridgePublishPersistence(
		BridgePublishPersistence bridgePublishPersistence) {
		this.bridgePublishPersistence = bridgePublishPersistence;
	}

	/**
	 * Returns the bridge publish finder.
	 *
	 * @return the bridge publish finder
	 */
	public BridgePublishFinder getBridgePublishFinder() {
		return bridgePublishFinder;
	}

	/**
	 * Sets the bridge publish finder.
	 *
	 * @param bridgePublishFinder the bridge publish finder
	 */
	public void setBridgePublishFinder(BridgePublishFinder bridgePublishFinder) {
		this.bridgePublishFinder = bridgePublishFinder;
	}

	/**
	 * Returns the bridge publish country local service.
	 *
	 * @return the bridge publish country local service
	 */
	public com.ihg.brandstandards.db.service.BridgePublishCountryLocalService getBridgePublishCountryLocalService() {
		return bridgePublishCountryLocalService;
	}

	/**
	 * Sets the bridge publish country local service.
	 *
	 * @param bridgePublishCountryLocalService the bridge publish country local service
	 */
	public void setBridgePublishCountryLocalService(
		com.ihg.brandstandards.db.service.BridgePublishCountryLocalService bridgePublishCountryLocalService) {
		this.bridgePublishCountryLocalService = bridgePublishCountryLocalService;
	}

	/**
	 * Returns the bridge publish country persistence.
	 *
	 * @return the bridge publish country persistence
	 */
	public BridgePublishCountryPersistence getBridgePublishCountryPersistence() {
		return bridgePublishCountryPersistence;
	}

	/**
	 * Sets the bridge publish country persistence.
	 *
	 * @param bridgePublishCountryPersistence the bridge publish country persistence
	 */
	public void setBridgePublishCountryPersistence(
		BridgePublishCountryPersistence bridgePublishCountryPersistence) {
		this.bridgePublishCountryPersistence = bridgePublishCountryPersistence;
	}

	/**
	 * Returns the bridge publish country finder.
	 *
	 * @return the bridge publish country finder
	 */
	public BridgePublishCountryFinder getBridgePublishCountryFinder() {
		return bridgePublishCountryFinder;
	}

	/**
	 * Sets the bridge publish country finder.
	 *
	 * @param bridgePublishCountryFinder the bridge publish country finder
	 */
	public void setBridgePublishCountryFinder(
		BridgePublishCountryFinder bridgePublishCountryFinder) {
		this.bridgePublishCountryFinder = bridgePublishCountryFinder;
	}

	/**
	 * Returns the bridge publish country state ex local service.
	 *
	 * @return the bridge publish country state ex local service
	 */
	public com.ihg.brandstandards.db.service.BridgePublishCountryStateExLocalService getBridgePublishCountryStateExLocalService() {
		return bridgePublishCountryStateExLocalService;
	}

	/**
	 * Sets the bridge publish country state ex local service.
	 *
	 * @param bridgePublishCountryStateExLocalService the bridge publish country state ex local service
	 */
	public void setBridgePublishCountryStateExLocalService(
		com.ihg.brandstandards.db.service.BridgePublishCountryStateExLocalService bridgePublishCountryStateExLocalService) {
		this.bridgePublishCountryStateExLocalService = bridgePublishCountryStateExLocalService;
	}

	/**
	 * Returns the bridge publish country state ex persistence.
	 *
	 * @return the bridge publish country state ex persistence
	 */
	public BridgePublishCountryStateExPersistence getBridgePublishCountryStateExPersistence() {
		return bridgePublishCountryStateExPersistence;
	}

	/**
	 * Sets the bridge publish country state ex persistence.
	 *
	 * @param bridgePublishCountryStateExPersistence the bridge publish country state ex persistence
	 */
	public void setBridgePublishCountryStateExPersistence(
		BridgePublishCountryStateExPersistence bridgePublishCountryStateExPersistence) {
		this.bridgePublishCountryStateExPersistence = bridgePublishCountryStateExPersistence;
	}

	/**
	 * Returns the bridge publish country state ex finder.
	 *
	 * @return the bridge publish country state ex finder
	 */
	public BridgePublishCountryStateExFinder getBridgePublishCountryStateExFinder() {
		return bridgePublishCountryStateExFinder;
	}

	/**
	 * Sets the bridge publish country state ex finder.
	 *
	 * @param bridgePublishCountryStateExFinder the bridge publish country state ex finder
	 */
	public void setBridgePublishCountryStateExFinder(
		BridgePublishCountryStateExFinder bridgePublishCountryStateExFinder) {
		this.bridgePublishCountryStateExFinder = bridgePublishCountryStateExFinder;
	}

	/**
	 * Returns the bridge publish import local service.
	 *
	 * @return the bridge publish import local service
	 */
	public com.ihg.brandstandards.db.service.BridgePublishImportLocalService getBridgePublishImportLocalService() {
		return bridgePublishImportLocalService;
	}

	/**
	 * Sets the bridge publish import local service.
	 *
	 * @param bridgePublishImportLocalService the bridge publish import local service
	 */
	public void setBridgePublishImportLocalService(
		com.ihg.brandstandards.db.service.BridgePublishImportLocalService bridgePublishImportLocalService) {
		this.bridgePublishImportLocalService = bridgePublishImportLocalService;
	}

	/**
	 * Returns the bridge publish import persistence.
	 *
	 * @return the bridge publish import persistence
	 */
	public BridgePublishImportPersistence getBridgePublishImportPersistence() {
		return bridgePublishImportPersistence;
	}

	/**
	 * Sets the bridge publish import persistence.
	 *
	 * @param bridgePublishImportPersistence the bridge publish import persistence
	 */
	public void setBridgePublishImportPersistence(
		BridgePublishImportPersistence bridgePublishImportPersistence) {
		this.bridgePublishImportPersistence = bridgePublishImportPersistence;
	}

	/**
	 * Returns the bridge publish import finder.
	 *
	 * @return the bridge publish import finder
	 */
	public BridgePublishImportFinder getBridgePublishImportFinder() {
		return bridgePublishImportFinder;
	}

	/**
	 * Sets the bridge publish import finder.
	 *
	 * @param bridgePublishImportFinder the bridge publish import finder
	 */
	public void setBridgePublishImportFinder(
		BridgePublishImportFinder bridgePublishImportFinder) {
		this.bridgePublishImportFinder = bridgePublishImportFinder;
	}

	/**
	 * Returns the bridge publish lang local service.
	 *
	 * @return the bridge publish lang local service
	 */
	public com.ihg.brandstandards.db.service.BridgePublishLangLocalService getBridgePublishLangLocalService() {
		return bridgePublishLangLocalService;
	}

	/**
	 * Sets the bridge publish lang local service.
	 *
	 * @param bridgePublishLangLocalService the bridge publish lang local service
	 */
	public void setBridgePublishLangLocalService(
		com.ihg.brandstandards.db.service.BridgePublishLangLocalService bridgePublishLangLocalService) {
		this.bridgePublishLangLocalService = bridgePublishLangLocalService;
	}

	/**
	 * Returns the bridge publish lang persistence.
	 *
	 * @return the bridge publish lang persistence
	 */
	public BridgePublishLangPersistence getBridgePublishLangPersistence() {
		return bridgePublishLangPersistence;
	}

	/**
	 * Sets the bridge publish lang persistence.
	 *
	 * @param bridgePublishLangPersistence the bridge publish lang persistence
	 */
	public void setBridgePublishLangPersistence(
		BridgePublishLangPersistence bridgePublishLangPersistence) {
		this.bridgePublishLangPersistence = bridgePublishLangPersistence;
	}

	/**
	 * Returns the bridge publish lang finder.
	 *
	 * @return the bridge publish lang finder
	 */
	public BridgePublishLangFinder getBridgePublishLangFinder() {
		return bridgePublishLangFinder;
	}

	/**
	 * Sets the bridge publish lang finder.
	 *
	 * @param bridgePublishLangFinder the bridge publish lang finder
	 */
	public void setBridgePublishLangFinder(
		BridgePublishLangFinder bridgePublishLangFinder) {
		this.bridgePublishLangFinder = bridgePublishLangFinder;
	}

	/**
	 * Returns the bridge publish preview local service.
	 *
	 * @return the bridge publish preview local service
	 */
	public com.ihg.brandstandards.db.service.BridgePublishPreviewLocalService getBridgePublishPreviewLocalService() {
		return bridgePublishPreviewLocalService;
	}

	/**
	 * Sets the bridge publish preview local service.
	 *
	 * @param bridgePublishPreviewLocalService the bridge publish preview local service
	 */
	public void setBridgePublishPreviewLocalService(
		com.ihg.brandstandards.db.service.BridgePublishPreviewLocalService bridgePublishPreviewLocalService) {
		this.bridgePublishPreviewLocalService = bridgePublishPreviewLocalService;
	}

	/**
	 * Returns the bridge publish preview persistence.
	 *
	 * @return the bridge publish preview persistence
	 */
	public BridgePublishPreviewPersistence getBridgePublishPreviewPersistence() {
		return bridgePublishPreviewPersistence;
	}

	/**
	 * Sets the bridge publish preview persistence.
	 *
	 * @param bridgePublishPreviewPersistence the bridge publish preview persistence
	 */
	public void setBridgePublishPreviewPersistence(
		BridgePublishPreviewPersistence bridgePublishPreviewPersistence) {
		this.bridgePublishPreviewPersistence = bridgePublishPreviewPersistence;
	}

	/**
	 * Returns the bridge publish preview finder.
	 *
	 * @return the bridge publish preview finder
	 */
	public BridgePublishPreviewFinder getBridgePublishPreviewFinder() {
		return bridgePublishPreviewFinder;
	}

	/**
	 * Sets the bridge publish preview finder.
	 *
	 * @param bridgePublishPreviewFinder the bridge publish preview finder
	 */
	public void setBridgePublishPreviewFinder(
		BridgePublishPreviewFinder bridgePublishPreviewFinder) {
		this.bridgePublishPreviewFinder = bridgePublishPreviewFinder;
	}

	/**
	 * Returns the bridge publish state ex local service.
	 *
	 * @return the bridge publish state ex local service
	 */
	public com.ihg.brandstandards.db.service.BridgePublishStateExLocalService getBridgePublishStateExLocalService() {
		return bridgePublishStateExLocalService;
	}

	/**
	 * Sets the bridge publish state ex local service.
	 *
	 * @param bridgePublishStateExLocalService the bridge publish state ex local service
	 */
	public void setBridgePublishStateExLocalService(
		com.ihg.brandstandards.db.service.BridgePublishStateExLocalService bridgePublishStateExLocalService) {
		this.bridgePublishStateExLocalService = bridgePublishStateExLocalService;
	}

	/**
	 * Returns the bridge publish state ex persistence.
	 *
	 * @return the bridge publish state ex persistence
	 */
	public BridgePublishStateExPersistence getBridgePublishStateExPersistence() {
		return bridgePublishStateExPersistence;
	}

	/**
	 * Sets the bridge publish state ex persistence.
	 *
	 * @param bridgePublishStateExPersistence the bridge publish state ex persistence
	 */
	public void setBridgePublishStateExPersistence(
		BridgePublishStateExPersistence bridgePublishStateExPersistence) {
		this.bridgePublishStateExPersistence = bridgePublishStateExPersistence;
	}

	/**
	 * Returns the bridge publish state ex finder.
	 *
	 * @return the bridge publish state ex finder
	 */
	public BridgePublishStateExFinder getBridgePublishStateExFinder() {
		return bridgePublishStateExFinder;
	}

	/**
	 * Sets the bridge publish state ex finder.
	 *
	 * @param bridgePublishStateExFinder the bridge publish state ex finder
	 */
	public void setBridgePublishStateExFinder(
		BridgePublishStateExFinder bridgePublishStateExFinder) {
		this.bridgePublishStateExFinder = bridgePublishStateExFinder;
	}

	/**
	 * Returns the bridge publish status local service.
	 *
	 * @return the bridge publish status local service
	 */
	public com.ihg.brandstandards.db.service.BridgePublishStatusLocalService getBridgePublishStatusLocalService() {
		return bridgePublishStatusLocalService;
	}

	/**
	 * Sets the bridge publish status local service.
	 *
	 * @param bridgePublishStatusLocalService the bridge publish status local service
	 */
	public void setBridgePublishStatusLocalService(
		com.ihg.brandstandards.db.service.BridgePublishStatusLocalService bridgePublishStatusLocalService) {
		this.bridgePublishStatusLocalService = bridgePublishStatusLocalService;
	}

	/**
	 * Returns the bridge publish status persistence.
	 *
	 * @return the bridge publish status persistence
	 */
	public BridgePublishStatusPersistence getBridgePublishStatusPersistence() {
		return bridgePublishStatusPersistence;
	}

	/**
	 * Sets the bridge publish status persistence.
	 *
	 * @param bridgePublishStatusPersistence the bridge publish status persistence
	 */
	public void setBridgePublishStatusPersistence(
		BridgePublishStatusPersistence bridgePublishStatusPersistence) {
		this.bridgePublishStatusPersistence = bridgePublishStatusPersistence;
	}

	/**
	 * Returns the bus impact assmt local service.
	 *
	 * @return the bus impact assmt local service
	 */
	public com.ihg.brandstandards.db.service.BusImpactAssmtLocalService getBusImpactAssmtLocalService() {
		return busImpactAssmtLocalService;
	}

	/**
	 * Sets the bus impact assmt local service.
	 *
	 * @param busImpactAssmtLocalService the bus impact assmt local service
	 */
	public void setBusImpactAssmtLocalService(
		com.ihg.brandstandards.db.service.BusImpactAssmtLocalService busImpactAssmtLocalService) {
		this.busImpactAssmtLocalService = busImpactAssmtLocalService;
	}

	/**
	 * Returns the bus impact assmt persistence.
	 *
	 * @return the bus impact assmt persistence
	 */
	public BusImpactAssmtPersistence getBusImpactAssmtPersistence() {
		return busImpactAssmtPersistence;
	}

	/**
	 * Sets the bus impact assmt persistence.
	 *
	 * @param busImpactAssmtPersistence the bus impact assmt persistence
	 */
	public void setBusImpactAssmtPersistence(
		BusImpactAssmtPersistence busImpactAssmtPersistence) {
		this.busImpactAssmtPersistence = busImpactAssmtPersistence;
	}

	/**
	 * Returns the chain attachments standards local service.
	 *
	 * @return the chain attachments standards local service
	 */
	public com.ihg.brandstandards.db.service.ChainAttachmentsStandardsLocalService getChainAttachmentsStandardsLocalService() {
		return chainAttachmentsStandardsLocalService;
	}

	/**
	 * Sets the chain attachments standards local service.
	 *
	 * @param chainAttachmentsStandardsLocalService the chain attachments standards local service
	 */
	public void setChainAttachmentsStandardsLocalService(
		com.ihg.brandstandards.db.service.ChainAttachmentsStandardsLocalService chainAttachmentsStandardsLocalService) {
		this.chainAttachmentsStandardsLocalService = chainAttachmentsStandardsLocalService;
	}

	/**
	 * Returns the chain attachments standards persistence.
	 *
	 * @return the chain attachments standards persistence
	 */
	public ChainAttachmentsStandardsPersistence getChainAttachmentsStandardsPersistence() {
		return chainAttachmentsStandardsPersistence;
	}

	/**
	 * Sets the chain attachments standards persistence.
	 *
	 * @param chainAttachmentsStandardsPersistence the chain attachments standards persistence
	 */
	public void setChainAttachmentsStandardsPersistence(
		ChainAttachmentsStandardsPersistence chainAttachmentsStandardsPersistence) {
		this.chainAttachmentsStandardsPersistence = chainAttachmentsStandardsPersistence;
	}

	/**
	 * Returns the chain external link standards local service.
	 *
	 * @return the chain external link standards local service
	 */
	public com.ihg.brandstandards.db.service.ChainExternalLinkStandardsLocalService getChainExternalLinkStandardsLocalService() {
		return chainExternalLinkStandardsLocalService;
	}

	/**
	 * Sets the chain external link standards local service.
	 *
	 * @param chainExternalLinkStandardsLocalService the chain external link standards local service
	 */
	public void setChainExternalLinkStandardsLocalService(
		com.ihg.brandstandards.db.service.ChainExternalLinkStandardsLocalService chainExternalLinkStandardsLocalService) {
		this.chainExternalLinkStandardsLocalService = chainExternalLinkStandardsLocalService;
	}

	/**
	 * Returns the chain external link standards persistence.
	 *
	 * @return the chain external link standards persistence
	 */
	public ChainExternalLinkStandardsPersistence getChainExternalLinkStandardsPersistence() {
		return chainExternalLinkStandardsPersistence;
	}

	/**
	 * Sets the chain external link standards persistence.
	 *
	 * @param chainExternalLinkStandardsPersistence the chain external link standards persistence
	 */
	public void setChainExternalLinkStandardsPersistence(
		ChainExternalLinkStandardsPersistence chainExternalLinkStandardsPersistence) {
		this.chainExternalLinkStandardsPersistence = chainExternalLinkStandardsPersistence;
	}

	/**
	 * Returns the chain standards local service.
	 *
	 * @return the chain standards local service
	 */
	public com.ihg.brandstandards.db.service.ChainStandardsLocalService getChainStandardsLocalService() {
		return chainStandardsLocalService;
	}

	/**
	 * Sets the chain standards local service.
	 *
	 * @param chainStandardsLocalService the chain standards local service
	 */
	public void setChainStandardsLocalService(
		com.ihg.brandstandards.db.service.ChainStandardsLocalService chainStandardsLocalService) {
		this.chainStandardsLocalService = chainStandardsLocalService;
	}

	/**
	 * Returns the chain standards persistence.
	 *
	 * @return the chain standards persistence
	 */
	public ChainStandardsPersistence getChainStandardsPersistence() {
		return chainStandardsPersistence;
	}

	/**
	 * Sets the chain standards persistence.
	 *
	 * @param chainStandardsPersistence the chain standards persistence
	 */
	public void setChainStandardsPersistence(
		ChainStandardsPersistence chainStandardsPersistence) {
		this.chainStandardsPersistence = chainStandardsPersistence;
	}

	/**
	 * Returns the country standards local service.
	 *
	 * @return the country standards local service
	 */
	public com.ihg.brandstandards.db.service.CountryStandardsLocalService getCountryStandardsLocalService() {
		return countryStandardsLocalService;
	}

	/**
	 * Sets the country standards local service.
	 *
	 * @param countryStandardsLocalService the country standards local service
	 */
	public void setCountryStandardsLocalService(
		com.ihg.brandstandards.db.service.CountryStandardsLocalService countryStandardsLocalService) {
		this.countryStandardsLocalService = countryStandardsLocalService;
	}

	/**
	 * Returns the country standards persistence.
	 *
	 * @return the country standards persistence
	 */
	public CountryStandardsPersistence getCountryStandardsPersistence() {
		return countryStandardsPersistence;
	}

	/**
	 * Sets the country standards persistence.
	 *
	 * @param countryStandardsPersistence the country standards persistence
	 */
	public void setCountryStandardsPersistence(
		CountryStandardsPersistence countryStandardsPersistence) {
		this.countryStandardsPersistence = countryStandardsPersistence;
	}

	/**
	 * Returns the country standards ext local service.
	 *
	 * @return the country standards ext local service
	 */
	public com.ihg.brandstandards.db.service.CountryStandardsExtLocalService getCountryStandardsExtLocalService() {
		return countryStandardsExtLocalService;
	}

	/**
	 * Sets the country standards ext local service.
	 *
	 * @param countryStandardsExtLocalService the country standards ext local service
	 */
	public void setCountryStandardsExtLocalService(
		com.ihg.brandstandards.db.service.CountryStandardsExtLocalService countryStandardsExtLocalService) {
		this.countryStandardsExtLocalService = countryStandardsExtLocalService;
	}

	/**
	 * Returns the country standards ext persistence.
	 *
	 * @return the country standards ext persistence
	 */
	public CountryStandardsExtPersistence getCountryStandardsExtPersistence() {
		return countryStandardsExtPersistence;
	}

	/**
	 * Sets the country standards ext persistence.
	 *
	 * @param countryStandardsExtPersistence the country standards ext persistence
	 */
	public void setCountryStandardsExtPersistence(
		CountryStandardsExtPersistence countryStandardsExtPersistence) {
		this.countryStandardsExtPersistence = countryStandardsExtPersistence;
	}

	/**
	 * Returns the country standards ext finder.
	 *
	 * @return the country standards ext finder
	 */
	public CountryStandardsExtFinder getCountryStandardsExtFinder() {
		return countryStandardsExtFinder;
	}

	/**
	 * Sets the country standards ext finder.
	 *
	 * @param countryStandardsExtFinder the country standards ext finder
	 */
	public void setCountryStandardsExtFinder(
		CountryStandardsExtFinder countryStandardsExtFinder) {
		this.countryStandardsExtFinder = countryStandardsExtFinder;
	}

	/**
	 * Returns the department local service.
	 *
	 * @return the department local service
	 */
	public com.ihg.brandstandards.db.service.DepartmentLocalService getDepartmentLocalService() {
		return departmentLocalService;
	}

	/**
	 * Sets the department local service.
	 *
	 * @param departmentLocalService the department local service
	 */
	public void setDepartmentLocalService(
		com.ihg.brandstandards.db.service.DepartmentLocalService departmentLocalService) {
		this.departmentLocalService = departmentLocalService;
	}

	/**
	 * Returns the department persistence.
	 *
	 * @return the department persistence
	 */
	public DepartmentPersistence getDepartmentPersistence() {
		return departmentPersistence;
	}

	/**
	 * Sets the department persistence.
	 *
	 * @param departmentPersistence the department persistence
	 */
	public void setDepartmentPersistence(
		DepartmentPersistence departmentPersistence) {
		this.departmentPersistence = departmentPersistence;
	}

	/**
	 * Returns the department finder.
	 *
	 * @return the department finder
	 */
	public DepartmentFinder getDepartmentFinder() {
		return departmentFinder;
	}

	/**
	 * Sets the department finder.
	 *
	 * @param departmentFinder the department finder
	 */
	public void setDepartmentFinder(DepartmentFinder departmentFinder) {
		this.departmentFinder = departmentFinder;
	}

	/**
	 * Returns the err notification local service.
	 *
	 * @return the err notification local service
	 */
	public com.ihg.brandstandards.db.service.ErrNotificationLocalService getErrNotificationLocalService() {
		return errNotificationLocalService;
	}

	/**
	 * Sets the err notification local service.
	 *
	 * @param errNotificationLocalService the err notification local service
	 */
	public void setErrNotificationLocalService(
		com.ihg.brandstandards.db.service.ErrNotificationLocalService errNotificationLocalService) {
		this.errNotificationLocalService = errNotificationLocalService;
	}

	/**
	 * Returns the err notification persistence.
	 *
	 * @return the err notification persistence
	 */
	public ErrNotificationPersistence getErrNotificationPersistence() {
		return errNotificationPersistence;
	}

	/**
	 * Sets the err notification persistence.
	 *
	 * @param errNotificationPersistence the err notification persistence
	 */
	public void setErrNotificationPersistence(
		ErrNotificationPersistence errNotificationPersistence) {
		this.errNotificationPersistence = errNotificationPersistence;
	}

	/**
	 * Returns the err notification finder.
	 *
	 * @return the err notification finder
	 */
	public ErrNotificationFinder getErrNotificationFinder() {
		return errNotificationFinder;
	}

	/**
	 * Sets the err notification finder.
	 *
	 * @param errNotificationFinder the err notification finder
	 */
	public void setErrNotificationFinder(
		ErrNotificationFinder errNotificationFinder) {
		this.errNotificationFinder = errNotificationFinder;
	}

	/**
	 * Returns the external link standards local service.
	 *
	 * @return the external link standards local service
	 */
	public com.ihg.brandstandards.db.service.ExternalLinkStandardsLocalService getExternalLinkStandardsLocalService() {
		return externalLinkStandardsLocalService;
	}

	/**
	 * Sets the external link standards local service.
	 *
	 * @param externalLinkStandardsLocalService the external link standards local service
	 */
	public void setExternalLinkStandardsLocalService(
		com.ihg.brandstandards.db.service.ExternalLinkStandardsLocalService externalLinkStandardsLocalService) {
		this.externalLinkStandardsLocalService = externalLinkStandardsLocalService;
	}

	/**
	 * Returns the external link standards persistence.
	 *
	 * @return the external link standards persistence
	 */
	public ExternalLinkStandardsPersistence getExternalLinkStandardsPersistence() {
		return externalLinkStandardsPersistence;
	}

	/**
	 * Sets the external link standards persistence.
	 *
	 * @param externalLinkStandardsPersistence the external link standards persistence
	 */
	public void setExternalLinkStandardsPersistence(
		ExternalLinkStandardsPersistence externalLinkStandardsPersistence) {
		this.externalLinkStandardsPersistence = externalLinkStandardsPersistence;
	}

	/**
	 * Returns the external link standards finder.
	 *
	 * @return the external link standards finder
	 */
	public ExternalLinkStandardsFinder getExternalLinkStandardsFinder() {
		return externalLinkStandardsFinder;
	}

	/**
	 * Sets the external link standards finder.
	 *
	 * @param externalLinkStandardsFinder the external link standards finder
	 */
	public void setExternalLinkStandardsFinder(
		ExternalLinkStandardsFinder externalLinkStandardsFinder) {
		this.externalLinkStandardsFinder = externalLinkStandardsFinder;
	}

	/**
	 * Returns the external link standards country local service.
	 *
	 * @return the external link standards country local service
	 */
	public com.ihg.brandstandards.db.service.ExternalLinkStandardsCountryLocalService getExternalLinkStandardsCountryLocalService() {
		return externalLinkStandardsCountryLocalService;
	}

	/**
	 * Sets the external link standards country local service.
	 *
	 * @param externalLinkStandardsCountryLocalService the external link standards country local service
	 */
	public void setExternalLinkStandardsCountryLocalService(
		com.ihg.brandstandards.db.service.ExternalLinkStandardsCountryLocalService externalLinkStandardsCountryLocalService) {
		this.externalLinkStandardsCountryLocalService = externalLinkStandardsCountryLocalService;
	}

	/**
	 * Returns the external link standards country persistence.
	 *
	 * @return the external link standards country persistence
	 */
	public ExternalLinkStandardsCountryPersistence getExternalLinkStandardsCountryPersistence() {
		return externalLinkStandardsCountryPersistence;
	}

	/**
	 * Sets the external link standards country persistence.
	 *
	 * @param externalLinkStandardsCountryPersistence the external link standards country persistence
	 */
	public void setExternalLinkStandardsCountryPersistence(
		ExternalLinkStandardsCountryPersistence externalLinkStandardsCountryPersistence) {
		this.externalLinkStandardsCountryPersistence = externalLinkStandardsCountryPersistence;
	}

	/**
	 * Returns the flag category local service.
	 *
	 * @return the flag category local service
	 */
	public com.ihg.brandstandards.db.service.FlagCategoryLocalService getFlagCategoryLocalService() {
		return flagCategoryLocalService;
	}

	/**
	 * Sets the flag category local service.
	 *
	 * @param flagCategoryLocalService the flag category local service
	 */
	public void setFlagCategoryLocalService(
		com.ihg.brandstandards.db.service.FlagCategoryLocalService flagCategoryLocalService) {
		this.flagCategoryLocalService = flagCategoryLocalService;
	}

	/**
	 * Returns the flag category persistence.
	 *
	 * @return the flag category persistence
	 */
	public FlagCategoryPersistence getFlagCategoryPersistence() {
		return flagCategoryPersistence;
	}

	/**
	 * Sets the flag category persistence.
	 *
	 * @param flagCategoryPersistence the flag category persistence
	 */
	public void setFlagCategoryPersistence(
		FlagCategoryPersistence flagCategoryPersistence) {
		this.flagCategoryPersistence = flagCategoryPersistence;
	}

	/**
	 * Returns the flag category finder.
	 *
	 * @return the flag category finder
	 */
	public FlagCategoryFinder getFlagCategoryFinder() {
		return flagCategoryFinder;
	}

	/**
	 * Sets the flag category finder.
	 *
	 * @param flagCategoryFinder the flag category finder
	 */
	public void setFlagCategoryFinder(FlagCategoryFinder flagCategoryFinder) {
		this.flagCategoryFinder = flagCategoryFinder;
	}

	/**
	 * Returns the flag standards local service.
	 *
	 * @return the flag standards local service
	 */
	public com.ihg.brandstandards.db.service.FlagStandardsLocalService getFlagStandardsLocalService() {
		return flagStandardsLocalService;
	}

	/**
	 * Sets the flag standards local service.
	 *
	 * @param flagStandardsLocalService the flag standards local service
	 */
	public void setFlagStandardsLocalService(
		com.ihg.brandstandards.db.service.FlagStandardsLocalService flagStandardsLocalService) {
		this.flagStandardsLocalService = flagStandardsLocalService;
	}

	/**
	 * Returns the flag standards persistence.
	 *
	 * @return the flag standards persistence
	 */
	public FlagStandardsPersistence getFlagStandardsPersistence() {
		return flagStandardsPersistence;
	}

	/**
	 * Sets the flag standards persistence.
	 *
	 * @param flagStandardsPersistence the flag standards persistence
	 */
	public void setFlagStandardsPersistence(
		FlagStandardsPersistence flagStandardsPersistence) {
		this.flagStandardsPersistence = flagStandardsPersistence;
	}

	/**
	 * Returns the flag standards finder.
	 *
	 * @return the flag standards finder
	 */
	public FlagStandardsFinder getFlagStandardsFinder() {
		return flagStandardsFinder;
	}

	/**
	 * Sets the flag standards finder.
	 *
	 * @param flagStandardsFinder the flag standards finder
	 */
	public void setFlagStandardsFinder(FlagStandardsFinder flagStandardsFinder) {
		this.flagStandardsFinder = flagStandardsFinder;
	}

	/**
	 * Returns the g e m category local service.
	 *
	 * @return the g e m category local service
	 */
	public com.ihg.brandstandards.db.service.GEMCategoryLocalService getGEMCategoryLocalService() {
		return gemCategoryLocalService;
	}

	/**
	 * Sets the g e m category local service.
	 *
	 * @param gemCategoryLocalService the g e m category local service
	 */
	public void setGEMCategoryLocalService(
		com.ihg.brandstandards.db.service.GEMCategoryLocalService gemCategoryLocalService) {
		this.gemCategoryLocalService = gemCategoryLocalService;
	}

	/**
	 * Returns the g e m category persistence.
	 *
	 * @return the g e m category persistence
	 */
	public GEMCategoryPersistence getGEMCategoryPersistence() {
		return gemCategoryPersistence;
	}

	/**
	 * Sets the g e m category persistence.
	 *
	 * @param gemCategoryPersistence the g e m category persistence
	 */
	public void setGEMCategoryPersistence(
		GEMCategoryPersistence gemCategoryPersistence) {
		this.gemCategoryPersistence = gemCategoryPersistence;
	}

	/**
	 * Returns the g e m category finder.
	 *
	 * @return the g e m category finder
	 */
	public GEMCategoryFinder getGEMCategoryFinder() {
		return gemCategoryFinder;
	}

	/**
	 * Sets the g e m category finder.
	 *
	 * @param gemCategoryFinder the g e m category finder
	 */
	public void setGEMCategoryFinder(GEMCategoryFinder gemCategoryFinder) {
		this.gemCategoryFinder = gemCategoryFinder;
	}

	/**
	 * Returns the g e m chain measurement local service.
	 *
	 * @return the g e m chain measurement local service
	 */
	public com.ihg.brandstandards.db.service.GEMChainMeasurementLocalService getGEMChainMeasurementLocalService() {
		return gemChainMeasurementLocalService;
	}

	/**
	 * Sets the g e m chain measurement local service.
	 *
	 * @param gemChainMeasurementLocalService the g e m chain measurement local service
	 */
	public void setGEMChainMeasurementLocalService(
		com.ihg.brandstandards.db.service.GEMChainMeasurementLocalService gemChainMeasurementLocalService) {
		this.gemChainMeasurementLocalService = gemChainMeasurementLocalService;
	}

	/**
	 * Returns the g e m chain measurement persistence.
	 *
	 * @return the g e m chain measurement persistence
	 */
	public GEMChainMeasurementPersistence getGEMChainMeasurementPersistence() {
		return gemChainMeasurementPersistence;
	}

	/**
	 * Sets the g e m chain measurement persistence.
	 *
	 * @param gemChainMeasurementPersistence the g e m chain measurement persistence
	 */
	public void setGEMChainMeasurementPersistence(
		GEMChainMeasurementPersistence gemChainMeasurementPersistence) {
		this.gemChainMeasurementPersistence = gemChainMeasurementPersistence;
	}

	/**
	 * Returns the g e m code local service.
	 *
	 * @return the g e m code local service
	 */
	public com.ihg.brandstandards.db.service.GEMCodeLocalService getGEMCodeLocalService() {
		return gemCodeLocalService;
	}

	/**
	 * Sets the g e m code local service.
	 *
	 * @param gemCodeLocalService the g e m code local service
	 */
	public void setGEMCodeLocalService(
		com.ihg.brandstandards.db.service.GEMCodeLocalService gemCodeLocalService) {
		this.gemCodeLocalService = gemCodeLocalService;
	}

	/**
	 * Returns the g e m code persistence.
	 *
	 * @return the g e m code persistence
	 */
	public GEMCodePersistence getGEMCodePersistence() {
		return gemCodePersistence;
	}

	/**
	 * Sets the g e m code persistence.
	 *
	 * @param gemCodePersistence the g e m code persistence
	 */
	public void setGEMCodePersistence(GEMCodePersistence gemCodePersistence) {
		this.gemCodePersistence = gemCodePersistence;
	}

	/**
	 * Returns the g e m generated report local service.
	 *
	 * @return the g e m generated report local service
	 */
	public com.ihg.brandstandards.db.service.GEMGeneratedReportLocalService getGEMGeneratedReportLocalService() {
		return gemGeneratedReportLocalService;
	}

	/**
	 * Sets the g e m generated report local service.
	 *
	 * @param gemGeneratedReportLocalService the g e m generated report local service
	 */
	public void setGEMGeneratedReportLocalService(
		com.ihg.brandstandards.db.service.GEMGeneratedReportLocalService gemGeneratedReportLocalService) {
		this.gemGeneratedReportLocalService = gemGeneratedReportLocalService;
	}

	/**
	 * Returns the g e m generated report persistence.
	 *
	 * @return the g e m generated report persistence
	 */
	public GEMGeneratedReportPersistence getGEMGeneratedReportPersistence() {
		return gemGeneratedReportPersistence;
	}

	/**
	 * Sets the g e m generated report persistence.
	 *
	 * @param gemGeneratedReportPersistence the g e m generated report persistence
	 */
	public void setGEMGeneratedReportPersistence(
		GEMGeneratedReportPersistence gemGeneratedReportPersistence) {
		this.gemGeneratedReportPersistence = gemGeneratedReportPersistence;
	}

	/**
	 * Returns the g e m generated report val local service.
	 *
	 * @return the g e m generated report val local service
	 */
	public com.ihg.brandstandards.db.service.GEMGeneratedReportValLocalService getGEMGeneratedReportValLocalService() {
		return gemGeneratedReportValLocalService;
	}

	/**
	 * Sets the g e m generated report val local service.
	 *
	 * @param gemGeneratedReportValLocalService the g e m generated report val local service
	 */
	public void setGEMGeneratedReportValLocalService(
		com.ihg.brandstandards.db.service.GEMGeneratedReportValLocalService gemGeneratedReportValLocalService) {
		this.gemGeneratedReportValLocalService = gemGeneratedReportValLocalService;
	}

	/**
	 * Returns the g e m generated report val persistence.
	 *
	 * @return the g e m generated report val persistence
	 */
	public GEMGeneratedReportValPersistence getGEMGeneratedReportValPersistence() {
		return gemGeneratedReportValPersistence;
	}

	/**
	 * Sets the g e m generated report val persistence.
	 *
	 * @param gemGeneratedReportValPersistence the g e m generated report val persistence
	 */
	public void setGEMGeneratedReportValPersistence(
		GEMGeneratedReportValPersistence gemGeneratedReportValPersistence) {
		this.gemGeneratedReportValPersistence = gemGeneratedReportValPersistence;
	}

	/**
	 * Returns the g e m management bucket local service.
	 *
	 * @return the g e m management bucket local service
	 */
	public com.ihg.brandstandards.db.service.GEMManagementBucketLocalService getGEMManagementBucketLocalService() {
		return gemManagementBucketLocalService;
	}

	/**
	 * Sets the g e m management bucket local service.
	 *
	 * @param gemManagementBucketLocalService the g e m management bucket local service
	 */
	public void setGEMManagementBucketLocalService(
		com.ihg.brandstandards.db.service.GEMManagementBucketLocalService gemManagementBucketLocalService) {
		this.gemManagementBucketLocalService = gemManagementBucketLocalService;
	}

	/**
	 * Returns the g e m management bucket persistence.
	 *
	 * @return the g e m management bucket persistence
	 */
	public GEMManagementBucketPersistence getGEMManagementBucketPersistence() {
		return gemManagementBucketPersistence;
	}

	/**
	 * Sets the g e m management bucket persistence.
	 *
	 * @param gemManagementBucketPersistence the g e m management bucket persistence
	 */
	public void setGEMManagementBucketPersistence(
		GEMManagementBucketPersistence gemManagementBucketPersistence) {
		this.gemManagementBucketPersistence = gemManagementBucketPersistence;
	}

	/**
	 * Returns the g e m management ID local service.
	 *
	 * @return the g e m management ID local service
	 */
	public com.ihg.brandstandards.db.service.GEMManagementIdLocalService getGEMManagementIdLocalService() {
		return gemManagementIdLocalService;
	}

	/**
	 * Sets the g e m management ID local service.
	 *
	 * @param gemManagementIdLocalService the g e m management ID local service
	 */
	public void setGEMManagementIdLocalService(
		com.ihg.brandstandards.db.service.GEMManagementIdLocalService gemManagementIdLocalService) {
		this.gemManagementIdLocalService = gemManagementIdLocalService;
	}

	/**
	 * Returns the g e m management ID persistence.
	 *
	 * @return the g e m management ID persistence
	 */
	public GEMManagementIdPersistence getGEMManagementIdPersistence() {
		return gemManagementIdPersistence;
	}

	/**
	 * Sets the g e m management ID persistence.
	 *
	 * @param gemManagementIdPersistence the g e m management ID persistence
	 */
	public void setGEMManagementIdPersistence(
		GEMManagementIdPersistence gemManagementIdPersistence) {
		this.gemManagementIdPersistence = gemManagementIdPersistence;
	}

	/**
	 * Returns the g e m management ID finder.
	 *
	 * @return the g e m management ID finder
	 */
	public GEMManagementIdFinder getGEMManagementIdFinder() {
		return gemManagementIdFinder;
	}

	/**
	 * Sets the g e m management ID finder.
	 *
	 * @param gemManagementIdFinder the g e m management ID finder
	 */
	public void setGEMManagementIdFinder(
		GEMManagementIdFinder gemManagementIdFinder) {
		this.gemManagementIdFinder = gemManagementIdFinder;
	}

	/**
	 * Returns the g e m measurement local service.
	 *
	 * @return the g e m measurement local service
	 */
	public com.ihg.brandstandards.db.service.GEMMeasurementLocalService getGEMMeasurementLocalService() {
		return gemMeasurementLocalService;
	}

	/**
	 * Sets the g e m measurement local service.
	 *
	 * @param gemMeasurementLocalService the g e m measurement local service
	 */
	public void setGEMMeasurementLocalService(
		com.ihg.brandstandards.db.service.GEMMeasurementLocalService gemMeasurementLocalService) {
		this.gemMeasurementLocalService = gemMeasurementLocalService;
	}

	/**
	 * Returns the g e m measurement persistence.
	 *
	 * @return the g e m measurement persistence
	 */
	public GEMMeasurementPersistence getGEMMeasurementPersistence() {
		return gemMeasurementPersistence;
	}

	/**
	 * Sets the g e m measurement persistence.
	 *
	 * @param gemMeasurementPersistence the g e m measurement persistence
	 */
	public void setGEMMeasurementPersistence(
		GEMMeasurementPersistence gemMeasurementPersistence) {
		this.gemMeasurementPersistence = gemMeasurementPersistence;
	}

	/**
	 * Returns the g e m measurement bucket chain local service.
	 *
	 * @return the g e m measurement bucket chain local service
	 */
	public com.ihg.brandstandards.db.service.GEMMeasurementBucketChainLocalService getGEMMeasurementBucketChainLocalService() {
		return gemMeasurementBucketChainLocalService;
	}

	/**
	 * Sets the g e m measurement bucket chain local service.
	 *
	 * @param gemMeasurementBucketChainLocalService the g e m measurement bucket chain local service
	 */
	public void setGEMMeasurementBucketChainLocalService(
		com.ihg.brandstandards.db.service.GEMMeasurementBucketChainLocalService gemMeasurementBucketChainLocalService) {
		this.gemMeasurementBucketChainLocalService = gemMeasurementBucketChainLocalService;
	}

	/**
	 * Returns the g e m measurement bucket chain persistence.
	 *
	 * @return the g e m measurement bucket chain persistence
	 */
	public GEMMeasurementBucketChainPersistence getGEMMeasurementBucketChainPersistence() {
		return gemMeasurementBucketChainPersistence;
	}

	/**
	 * Sets the g e m measurement bucket chain persistence.
	 *
	 * @param gemMeasurementBucketChainPersistence the g e m measurement bucket chain persistence
	 */
	public void setGEMMeasurementBucketChainPersistence(
		GEMMeasurementBucketChainPersistence gemMeasurementBucketChainPersistence) {
		this.gemMeasurementBucketChainPersistence = gemMeasurementBucketChainPersistence;
	}

	/**
	 * Returns the g e m measurement formula local service.
	 *
	 * @return the g e m measurement formula local service
	 */
	public com.ihg.brandstandards.db.service.GEMMeasurementFormulaLocalService getGEMMeasurementFormulaLocalService() {
		return gemMeasurementFormulaLocalService;
	}

	/**
	 * Sets the g e m measurement formula local service.
	 *
	 * @param gemMeasurementFormulaLocalService the g e m measurement formula local service
	 */
	public void setGEMMeasurementFormulaLocalService(
		com.ihg.brandstandards.db.service.GEMMeasurementFormulaLocalService gemMeasurementFormulaLocalService) {
		this.gemMeasurementFormulaLocalService = gemMeasurementFormulaLocalService;
	}

	/**
	 * Returns the g e m measurement formula persistence.
	 *
	 * @return the g e m measurement formula persistence
	 */
	public GEMMeasurementFormulaPersistence getGEMMeasurementFormulaPersistence() {
		return gemMeasurementFormulaPersistence;
	}

	/**
	 * Sets the g e m measurement formula persistence.
	 *
	 * @param gemMeasurementFormulaPersistence the g e m measurement formula persistence
	 */
	public void setGEMMeasurementFormulaPersistence(
		GEMMeasurementFormulaPersistence gemMeasurementFormulaPersistence) {
		this.gemMeasurementFormulaPersistence = gemMeasurementFormulaPersistence;
	}

	/**
	 * Returns the g e m measurement formula value local service.
	 *
	 * @return the g e m measurement formula value local service
	 */
	public com.ihg.brandstandards.db.service.GEMMeasurementFormulaValueLocalService getGEMMeasurementFormulaValueLocalService() {
		return gemMeasurementFormulaValueLocalService;
	}

	/**
	 * Sets the g e m measurement formula value local service.
	 *
	 * @param gemMeasurementFormulaValueLocalService the g e m measurement formula value local service
	 */
	public void setGEMMeasurementFormulaValueLocalService(
		com.ihg.brandstandards.db.service.GEMMeasurementFormulaValueLocalService gemMeasurementFormulaValueLocalService) {
		this.gemMeasurementFormulaValueLocalService = gemMeasurementFormulaValueLocalService;
	}

	/**
	 * Returns the g e m measurement formula value persistence.
	 *
	 * @return the g e m measurement formula value persistence
	 */
	public GEMMeasurementFormulaValuePersistence getGEMMeasurementFormulaValuePersistence() {
		return gemMeasurementFormulaValuePersistence;
	}

	/**
	 * Sets the g e m measurement formula value persistence.
	 *
	 * @param gemMeasurementFormulaValuePersistence the g e m measurement formula value persistence
	 */
	public void setGEMMeasurementFormulaValuePersistence(
		GEMMeasurementFormulaValuePersistence gemMeasurementFormulaValuePersistence) {
		this.gemMeasurementFormulaValuePersistence = gemMeasurementFormulaValuePersistence;
	}

	/**
	 * Returns the g e m measurement type local service.
	 *
	 * @return the g e m measurement type local service
	 */
	public com.ihg.brandstandards.db.service.GEMMeasurementTypeLocalService getGEMMeasurementTypeLocalService() {
		return gemMeasurementTypeLocalService;
	}

	/**
	 * Sets the g e m measurement type local service.
	 *
	 * @param gemMeasurementTypeLocalService the g e m measurement type local service
	 */
	public void setGEMMeasurementTypeLocalService(
		com.ihg.brandstandards.db.service.GEMMeasurementTypeLocalService gemMeasurementTypeLocalService) {
		this.gemMeasurementTypeLocalService = gemMeasurementTypeLocalService;
	}

	/**
	 * Returns the g e m measurement type persistence.
	 *
	 * @return the g e m measurement type persistence
	 */
	public GEMMeasurementTypePersistence getGEMMeasurementTypePersistence() {
		return gemMeasurementTypePersistence;
	}

	/**
	 * Sets the g e m measurement type persistence.
	 *
	 * @param gemMeasurementTypePersistence the g e m measurement type persistence
	 */
	public void setGEMMeasurementTypePersistence(
		GEMMeasurementTypePersistence gemMeasurementTypePersistence) {
		this.gemMeasurementTypePersistence = gemMeasurementTypePersistence;
	}

	/**
	 * Returns the g e m ql report local service.
	 *
	 * @return the g e m ql report local service
	 */
	public com.ihg.brandstandards.db.service.GEMQlReportLocalService getGEMQlReportLocalService() {
		return gemQlReportLocalService;
	}

	/**
	 * Sets the g e m ql report local service.
	 *
	 * @param gemQlReportLocalService the g e m ql report local service
	 */
	public void setGEMQlReportLocalService(
		com.ihg.brandstandards.db.service.GEMQlReportLocalService gemQlReportLocalService) {
		this.gemQlReportLocalService = gemQlReportLocalService;
	}

	/**
	 * Returns the g e m ql report persistence.
	 *
	 * @return the g e m ql report persistence
	 */
	public GEMQlReportPersistence getGEMQlReportPersistence() {
		return gemQlReportPersistence;
	}

	/**
	 * Sets the g e m ql report persistence.
	 *
	 * @param gemQlReportPersistence the g e m ql report persistence
	 */
	public void setGEMQlReportPersistence(
		GEMQlReportPersistence gemQlReportPersistence) {
		this.gemQlReportPersistence = gemQlReportPersistence;
	}

	/**
	 * Returns the g e m ql report finder.
	 *
	 * @return the g e m ql report finder
	 */
	public GEMQlReportFinder getGEMQlReportFinder() {
		return gemQlReportFinder;
	}

	/**
	 * Sets the g e m ql report finder.
	 *
	 * @param gemQlReportFinder the g e m ql report finder
	 */
	public void setGEMQlReportFinder(GEMQlReportFinder gemQlReportFinder) {
		this.gemQlReportFinder = gemQlReportFinder;
	}

	/**
	 * Returns the g e m role local service.
	 *
	 * @return the g e m role local service
	 */
	public com.ihg.brandstandards.db.service.GEMRoleLocalService getGEMRoleLocalService() {
		return gemRoleLocalService;
	}

	/**
	 * Sets the g e m role local service.
	 *
	 * @param gemRoleLocalService the g e m role local service
	 */
	public void setGEMRoleLocalService(
		com.ihg.brandstandards.db.service.GEMRoleLocalService gemRoleLocalService) {
		this.gemRoleLocalService = gemRoleLocalService;
	}

	/**
	 * Returns the g e m role persistence.
	 *
	 * @return the g e m role persistence
	 */
	public GEMRolePersistence getGEMRolePersistence() {
		return gemRolePersistence;
	}

	/**
	 * Sets the g e m role persistence.
	 *
	 * @param gemRolePersistence the g e m role persistence
	 */
	public void setGEMRolePersistence(GEMRolePersistence gemRolePersistence) {
		this.gemRolePersistence = gemRolePersistence;
	}

	/**
	 * Returns the g e m role finder.
	 *
	 * @return the g e m role finder
	 */
	public GEMRoleFinder getGEMRoleFinder() {
		return gemRoleFinder;
	}

	/**
	 * Sets the g e m role finder.
	 *
	 * @param gemRoleFinder the g e m role finder
	 */
	public void setGEMRoleFinder(GEMRoleFinder gemRoleFinder) {
		this.gemRoleFinder = gemRoleFinder;
	}

	/**
	 * Returns the g e m scoring value local service.
	 *
	 * @return the g e m scoring value local service
	 */
	public com.ihg.brandstandards.db.service.GEMScoringValueLocalService getGEMScoringValueLocalService() {
		return gemScoringValueLocalService;
	}

	/**
	 * Sets the g e m scoring value local service.
	 *
	 * @param gemScoringValueLocalService the g e m scoring value local service
	 */
	public void setGEMScoringValueLocalService(
		com.ihg.brandstandards.db.service.GEMScoringValueLocalService gemScoringValueLocalService) {
		this.gemScoringValueLocalService = gemScoringValueLocalService;
	}

	/**
	 * Returns the g e m scoring value persistence.
	 *
	 * @return the g e m scoring value persistence
	 */
	public GEMScoringValuePersistence getGEMScoringValuePersistence() {
		return gemScoringValuePersistence;
	}

	/**
	 * Sets the g e m scoring value persistence.
	 *
	 * @param gemScoringValuePersistence the g e m scoring value persistence
	 */
	public void setGEMScoringValuePersistence(
		GEMScoringValuePersistence gemScoringValuePersistence) {
		this.gemScoringValuePersistence = gemScoringValuePersistence;
	}

	/**
	 * Returns the g e m severity local service.
	 *
	 * @return the g e m severity local service
	 */
	public com.ihg.brandstandards.db.service.GEMSeverityLocalService getGEMSeverityLocalService() {
		return gemSeverityLocalService;
	}

	/**
	 * Sets the g e m severity local service.
	 *
	 * @param gemSeverityLocalService the g e m severity local service
	 */
	public void setGEMSeverityLocalService(
		com.ihg.brandstandards.db.service.GEMSeverityLocalService gemSeverityLocalService) {
		this.gemSeverityLocalService = gemSeverityLocalService;
	}

	/**
	 * Returns the g e m severity persistence.
	 *
	 * @return the g e m severity persistence
	 */
	public GEMSeverityPersistence getGEMSeverityPersistence() {
		return gemSeverityPersistence;
	}

	/**
	 * Sets the g e m severity persistence.
	 *
	 * @param gemSeverityPersistence the g e m severity persistence
	 */
	public void setGEMSeverityPersistence(
		GEMSeverityPersistence gemSeverityPersistence) {
		this.gemSeverityPersistence = gemSeverityPersistence;
	}

	/**
	 * Returns the g e m std category local service.
	 *
	 * @return the g e m std category local service
	 */
	public com.ihg.brandstandards.db.service.GEMStdCategoryLocalService getGEMStdCategoryLocalService() {
		return gemStdCategoryLocalService;
	}

	/**
	 * Sets the g e m std category local service.
	 *
	 * @param gemStdCategoryLocalService the g e m std category local service
	 */
	public void setGEMStdCategoryLocalService(
		com.ihg.brandstandards.db.service.GEMStdCategoryLocalService gemStdCategoryLocalService) {
		this.gemStdCategoryLocalService = gemStdCategoryLocalService;
	}

	/**
	 * Returns the g e m std category persistence.
	 *
	 * @return the g e m std category persistence
	 */
	public GEMStdCategoryPersistence getGEMStdCategoryPersistence() {
		return gemStdCategoryPersistence;
	}

	/**
	 * Sets the g e m std category persistence.
	 *
	 * @param gemStdCategoryPersistence the g e m std category persistence
	 */
	public void setGEMStdCategoryPersistence(
		GEMStdCategoryPersistence gemStdCategoryPersistence) {
		this.gemStdCategoryPersistence = gemStdCategoryPersistence;
	}

	/**
	 * Returns the g e m template local service.
	 *
	 * @return the g e m template local service
	 */
	public com.ihg.brandstandards.db.service.GEMTemplateLocalService getGEMTemplateLocalService() {
		return gemTemplateLocalService;
	}

	/**
	 * Sets the g e m template local service.
	 *
	 * @param gemTemplateLocalService the g e m template local service
	 */
	public void setGEMTemplateLocalService(
		com.ihg.brandstandards.db.service.GEMTemplateLocalService gemTemplateLocalService) {
		this.gemTemplateLocalService = gemTemplateLocalService;
	}

	/**
	 * Returns the g e m template persistence.
	 *
	 * @return the g e m template persistence
	 */
	public GEMTemplatePersistence getGEMTemplatePersistence() {
		return gemTemplatePersistence;
	}

	/**
	 * Sets the g e m template persistence.
	 *
	 * @param gemTemplatePersistence the g e m template persistence
	 */
	public void setGEMTemplatePersistence(
		GEMTemplatePersistence gemTemplatePersistence) {
		this.gemTemplatePersistence = gemTemplatePersistence;
	}

	/**
	 * Returns the g e m template finder.
	 *
	 * @return the g e m template finder
	 */
	public GEMTemplateFinder getGEMTemplateFinder() {
		return gemTemplateFinder;
	}

	/**
	 * Sets the g e m template finder.
	 *
	 * @param gemTemplateFinder the g e m template finder
	 */
	public void setGEMTemplateFinder(GEMTemplateFinder gemTemplateFinder) {
		this.gemTemplateFinder = gemTemplateFinder;
	}

	/**
	 * Returns the g e m template category local service.
	 *
	 * @return the g e m template category local service
	 */
	public com.ihg.brandstandards.db.service.GEMTemplateCategoryLocalService getGEMTemplateCategoryLocalService() {
		return gemTemplateCategoryLocalService;
	}

	/**
	 * Sets the g e m template category local service.
	 *
	 * @param gemTemplateCategoryLocalService the g e m template category local service
	 */
	public void setGEMTemplateCategoryLocalService(
		com.ihg.brandstandards.db.service.GEMTemplateCategoryLocalService gemTemplateCategoryLocalService) {
		this.gemTemplateCategoryLocalService = gemTemplateCategoryLocalService;
	}

	/**
	 * Returns the g e m template category persistence.
	 *
	 * @return the g e m template category persistence
	 */
	public GEMTemplateCategoryPersistence getGEMTemplateCategoryPersistence() {
		return gemTemplateCategoryPersistence;
	}

	/**
	 * Sets the g e m template category persistence.
	 *
	 * @param gemTemplateCategoryPersistence the g e m template category persistence
	 */
	public void setGEMTemplateCategoryPersistence(
		GEMTemplateCategoryPersistence gemTemplateCategoryPersistence) {
		this.gemTemplateCategoryPersistence = gemTemplateCategoryPersistence;
	}

	/**
	 * Returns the g e m template column local service.
	 *
	 * @return the g e m template column local service
	 */
	public com.ihg.brandstandards.db.service.GEMTemplateColumnLocalService getGEMTemplateColumnLocalService() {
		return gemTemplateColumnLocalService;
	}

	/**
	 * Sets the g e m template column local service.
	 *
	 * @param gemTemplateColumnLocalService the g e m template column local service
	 */
	public void setGEMTemplateColumnLocalService(
		com.ihg.brandstandards.db.service.GEMTemplateColumnLocalService gemTemplateColumnLocalService) {
		this.gemTemplateColumnLocalService = gemTemplateColumnLocalService;
	}

	/**
	 * Returns the g e m template column persistence.
	 *
	 * @return the g e m template column persistence
	 */
	public GEMTemplateColumnPersistence getGEMTemplateColumnPersistence() {
		return gemTemplateColumnPersistence;
	}

	/**
	 * Sets the g e m template column persistence.
	 *
	 * @param gemTemplateColumnPersistence the g e m template column persistence
	 */
	public void setGEMTemplateColumnPersistence(
		GEMTemplateColumnPersistence gemTemplateColumnPersistence) {
		this.gemTemplateColumnPersistence = gemTemplateColumnPersistence;
	}

	/**
	 * Returns the g e m template column finder.
	 *
	 * @return the g e m template column finder
	 */
	public GEMTemplateColumnFinder getGEMTemplateColumnFinder() {
		return gemTemplateColumnFinder;
	}

	/**
	 * Sets the g e m template column finder.
	 *
	 * @param gemTemplateColumnFinder the g e m template column finder
	 */
	public void setGEMTemplateColumnFinder(
		GEMTemplateColumnFinder gemTemplateColumnFinder) {
		this.gemTemplateColumnFinder = gemTemplateColumnFinder;
	}

	/**
	 * Returns the g e m template reference local service.
	 *
	 * @return the g e m template reference local service
	 */
	public com.ihg.brandstandards.db.service.GEMTemplateReferenceLocalService getGEMTemplateReferenceLocalService() {
		return gemTemplateReferenceLocalService;
	}

	/**
	 * Sets the g e m template reference local service.
	 *
	 * @param gemTemplateReferenceLocalService the g e m template reference local service
	 */
	public void setGEMTemplateReferenceLocalService(
		com.ihg.brandstandards.db.service.GEMTemplateReferenceLocalService gemTemplateReferenceLocalService) {
		this.gemTemplateReferenceLocalService = gemTemplateReferenceLocalService;
	}

	/**
	 * Returns the g e m template reference persistence.
	 *
	 * @return the g e m template reference persistence
	 */
	public GEMTemplateReferencePersistence getGEMTemplateReferencePersistence() {
		return gemTemplateReferencePersistence;
	}

	/**
	 * Sets the g e m template reference persistence.
	 *
	 * @param gemTemplateReferencePersistence the g e m template reference persistence
	 */
	public void setGEMTemplateReferencePersistence(
		GEMTemplateReferencePersistence gemTemplateReferencePersistence) {
		this.gemTemplateReferencePersistence = gemTemplateReferencePersistence;
	}

	/**
	 * Returns the g e m template values local service.
	 *
	 * @return the g e m template values local service
	 */
	public com.ihg.brandstandards.db.service.GEMTemplateValuesLocalService getGEMTemplateValuesLocalService() {
		return gemTemplateValuesLocalService;
	}

	/**
	 * Sets the g e m template values local service.
	 *
	 * @param gemTemplateValuesLocalService the g e m template values local service
	 */
	public void setGEMTemplateValuesLocalService(
		com.ihg.brandstandards.db.service.GEMTemplateValuesLocalService gemTemplateValuesLocalService) {
		this.gemTemplateValuesLocalService = gemTemplateValuesLocalService;
	}

	/**
	 * Returns the g e m template values persistence.
	 *
	 * @return the g e m template values persistence
	 */
	public GEMTemplateValuesPersistence getGEMTemplateValuesPersistence() {
		return gemTemplateValuesPersistence;
	}

	/**
	 * Sets the g e m template values persistence.
	 *
	 * @param gemTemplateValuesPersistence the g e m template values persistence
	 */
	public void setGEMTemplateValuesPersistence(
		GEMTemplateValuesPersistence gemTemplateValuesPersistence) {
		this.gemTemplateValuesPersistence = gemTemplateValuesPersistence;
	}

	/**
	 * Returns the g e m trigger local service.
	 *
	 * @return the g e m trigger local service
	 */
	public com.ihg.brandstandards.db.service.GEMTriggerLocalService getGEMTriggerLocalService() {
		return gemTriggerLocalService;
	}

	/**
	 * Sets the g e m trigger local service.
	 *
	 * @param gemTriggerLocalService the g e m trigger local service
	 */
	public void setGEMTriggerLocalService(
		com.ihg.brandstandards.db.service.GEMTriggerLocalService gemTriggerLocalService) {
		this.gemTriggerLocalService = gemTriggerLocalService;
	}

	/**
	 * Returns the g e m trigger persistence.
	 *
	 * @return the g e m trigger persistence
	 */
	public GEMTriggerPersistence getGEMTriggerPersistence() {
		return gemTriggerPersistence;
	}

	/**
	 * Sets the g e m trigger persistence.
	 *
	 * @param gemTriggerPersistence the g e m trigger persistence
	 */
	public void setGEMTriggerPersistence(
		GEMTriggerPersistence gemTriggerPersistence) {
		this.gemTriggerPersistence = gemTriggerPersistence;
	}

	/**
	 * Returns the g e m unique group local service.
	 *
	 * @return the g e m unique group local service
	 */
	public com.ihg.brandstandards.db.service.GEMUniqueGroupLocalService getGEMUniqueGroupLocalService() {
		return gemUniqueGroupLocalService;
	}

	/**
	 * Sets the g e m unique group local service.
	 *
	 * @param gemUniqueGroupLocalService the g e m unique group local service
	 */
	public void setGEMUniqueGroupLocalService(
		com.ihg.brandstandards.db.service.GEMUniqueGroupLocalService gemUniqueGroupLocalService) {
		this.gemUniqueGroupLocalService = gemUniqueGroupLocalService;
	}

	/**
	 * Returns the g e m unique group persistence.
	 *
	 * @return the g e m unique group persistence
	 */
	public GEMUniqueGroupPersistence getGEMUniqueGroupPersistence() {
		return gemUniqueGroupPersistence;
	}

	/**
	 * Sets the g e m unique group persistence.
	 *
	 * @param gemUniqueGroupPersistence the g e m unique group persistence
	 */
	public void setGEMUniqueGroupPersistence(
		GEMUniqueGroupPersistence gemUniqueGroupPersistence) {
		this.gemUniqueGroupPersistence = gemUniqueGroupPersistence;
	}

	/**
	 * Returns the g e m unique group finder.
	 *
	 * @return the g e m unique group finder
	 */
	public GEMUniqueGroupFinder getGEMUniqueGroupFinder() {
		return gemUniqueGroupFinder;
	}

	/**
	 * Sets the g e m unique group finder.
	 *
	 * @param gemUniqueGroupFinder the g e m unique group finder
	 */
	public void setGEMUniqueGroupFinder(
		GEMUniqueGroupFinder gemUniqueGroupFinder) {
		this.gemUniqueGroupFinder = gemUniqueGroupFinder;
	}

	/**
	 * Returns the g e m unique group country local service.
	 *
	 * @return the g e m unique group country local service
	 */
	public com.ihg.brandstandards.db.service.GEMUniqueGroupCountryLocalService getGEMUniqueGroupCountryLocalService() {
		return gemUniqueGroupCountryLocalService;
	}

	/**
	 * Sets the g e m unique group country local service.
	 *
	 * @param gemUniqueGroupCountryLocalService the g e m unique group country local service
	 */
	public void setGEMUniqueGroupCountryLocalService(
		com.ihg.brandstandards.db.service.GEMUniqueGroupCountryLocalService gemUniqueGroupCountryLocalService) {
		this.gemUniqueGroupCountryLocalService = gemUniqueGroupCountryLocalService;
	}

	/**
	 * Returns the g e m unique group country persistence.
	 *
	 * @return the g e m unique group country persistence
	 */
	public GEMUniqueGroupCountryPersistence getGEMUniqueGroupCountryPersistence() {
		return gemUniqueGroupCountryPersistence;
	}

	/**
	 * Sets the g e m unique group country persistence.
	 *
	 * @param gemUniqueGroupCountryPersistence the g e m unique group country persistence
	 */
	public void setGEMUniqueGroupCountryPersistence(
		GEMUniqueGroupCountryPersistence gemUniqueGroupCountryPersistence) {
		this.gemUniqueGroupCountryPersistence = gemUniqueGroupCountryPersistence;
	}

	/**
	 * Returns the g e m unique group country finder.
	 *
	 * @return the g e m unique group country finder
	 */
	public GEMUniqueGroupCountryFinder getGEMUniqueGroupCountryFinder() {
		return gemUniqueGroupCountryFinder;
	}

	/**
	 * Sets the g e m unique group country finder.
	 *
	 * @param gemUniqueGroupCountryFinder the g e m unique group country finder
	 */
	public void setGEMUniqueGroupCountryFinder(
		GEMUniqueGroupCountryFinder gemUniqueGroupCountryFinder) {
		this.gemUniqueGroupCountryFinder = gemUniqueGroupCountryFinder;
	}

	/**
	 * Returns the g e m unique group standard local service.
	 *
	 * @return the g e m unique group standard local service
	 */
	public com.ihg.brandstandards.db.service.GEMUniqueGroupStandardLocalService getGEMUniqueGroupStandardLocalService() {
		return gemUniqueGroupStandardLocalService;
	}

	/**
	 * Sets the g e m unique group standard local service.
	 *
	 * @param gemUniqueGroupStandardLocalService the g e m unique group standard local service
	 */
	public void setGEMUniqueGroupStandardLocalService(
		com.ihg.brandstandards.db.service.GEMUniqueGroupStandardLocalService gemUniqueGroupStandardLocalService) {
		this.gemUniqueGroupStandardLocalService = gemUniqueGroupStandardLocalService;
	}

	/**
	 * Returns the g e m unique group standard persistence.
	 *
	 * @return the g e m unique group standard persistence
	 */
	public GEMUniqueGroupStandardPersistence getGEMUniqueGroupStandardPersistence() {
		return gemUniqueGroupStandardPersistence;
	}

	/**
	 * Sets the g e m unique group standard persistence.
	 *
	 * @param gemUniqueGroupStandardPersistence the g e m unique group standard persistence
	 */
	public void setGEMUniqueGroupStandardPersistence(
		GEMUniqueGroupStandardPersistence gemUniqueGroupStandardPersistence) {
		this.gemUniqueGroupStandardPersistence = gemUniqueGroupStandardPersistence;
	}

	/**
	 * Returns the glossary local service.
	 *
	 * @return the glossary local service
	 */
	public com.ihg.brandstandards.db.service.GlossaryLocalService getGlossaryLocalService() {
		return glossaryLocalService;
	}

	/**
	 * Sets the glossary local service.
	 *
	 * @param glossaryLocalService the glossary local service
	 */
	public void setGlossaryLocalService(
		com.ihg.brandstandards.db.service.GlossaryLocalService glossaryLocalService) {
		this.glossaryLocalService = glossaryLocalService;
	}

	/**
	 * Returns the glossary persistence.
	 *
	 * @return the glossary persistence
	 */
	public GlossaryPersistence getGlossaryPersistence() {
		return glossaryPersistence;
	}

	/**
	 * Sets the glossary persistence.
	 *
	 * @param glossaryPersistence the glossary persistence
	 */
	public void setGlossaryPersistence(GlossaryPersistence glossaryPersistence) {
		this.glossaryPersistence = glossaryPersistence;
	}

	/**
	 * Returns the glossary finder.
	 *
	 * @return the glossary finder
	 */
	public GlossaryFinder getGlossaryFinder() {
		return glossaryFinder;
	}

	/**
	 * Sets the glossary finder.
	 *
	 * @param glossaryFinder the glossary finder
	 */
	public void setGlossaryFinder(GlossaryFinder glossaryFinder) {
		this.glossaryFinder = glossaryFinder;
	}

	/**
	 * Returns the glossary ext local service.
	 *
	 * @return the glossary ext local service
	 */
	public com.ihg.brandstandards.db.service.GlossaryExtLocalService getGlossaryExtLocalService() {
		return glossaryExtLocalService;
	}

	/**
	 * Sets the glossary ext local service.
	 *
	 * @param glossaryExtLocalService the glossary ext local service
	 */
	public void setGlossaryExtLocalService(
		com.ihg.brandstandards.db.service.GlossaryExtLocalService glossaryExtLocalService) {
		this.glossaryExtLocalService = glossaryExtLocalService;
	}

	/**
	 * Returns the glossary ext persistence.
	 *
	 * @return the glossary ext persistence
	 */
	public GlossaryExtPersistence getGlossaryExtPersistence() {
		return glossaryExtPersistence;
	}

	/**
	 * Sets the glossary ext persistence.
	 *
	 * @param glossaryExtPersistence the glossary ext persistence
	 */
	public void setGlossaryExtPersistence(
		GlossaryExtPersistence glossaryExtPersistence) {
		this.glossaryExtPersistence = glossaryExtPersistence;
	}

	/**
	 * Returns the glossary ext finder.
	 *
	 * @return the glossary ext finder
	 */
	public GlossaryExtFinder getGlossaryExtFinder() {
		return glossaryExtFinder;
	}

	/**
	 * Sets the glossary ext finder.
	 *
	 * @param glossaryExtFinder the glossary ext finder
	 */
	public void setGlossaryExtFinder(GlossaryExtFinder glossaryExtFinder) {
		this.glossaryExtFinder = glossaryExtFinder;
	}

	/**
	 * Returns the glossary region nav local service.
	 *
	 * @return the glossary region nav local service
	 */
	public com.ihg.brandstandards.db.service.GlossaryRegionNavLocalService getGlossaryRegionNavLocalService() {
		return glossaryRegionNavLocalService;
	}

	/**
	 * Sets the glossary region nav local service.
	 *
	 * @param glossaryRegionNavLocalService the glossary region nav local service
	 */
	public void setGlossaryRegionNavLocalService(
		com.ihg.brandstandards.db.service.GlossaryRegionNavLocalService glossaryRegionNavLocalService) {
		this.glossaryRegionNavLocalService = glossaryRegionNavLocalService;
	}

	/**
	 * Returns the glossary region nav persistence.
	 *
	 * @return the glossary region nav persistence
	 */
	public GlossaryRegionNavPersistence getGlossaryRegionNavPersistence() {
		return glossaryRegionNavPersistence;
	}

	/**
	 * Sets the glossary region nav persistence.
	 *
	 * @param glossaryRegionNavPersistence the glossary region nav persistence
	 */
	public void setGlossaryRegionNavPersistence(
		GlossaryRegionNavPersistence glossaryRegionNavPersistence) {
		this.glossaryRegionNavPersistence = glossaryRegionNavPersistence;
	}

	/**
	 * Returns the glossary translate local service.
	 *
	 * @return the glossary translate local service
	 */
	public com.ihg.brandstandards.db.service.GlossaryTranslateLocalService getGlossaryTranslateLocalService() {
		return glossaryTranslateLocalService;
	}

	/**
	 * Sets the glossary translate local service.
	 *
	 * @param glossaryTranslateLocalService the glossary translate local service
	 */
	public void setGlossaryTranslateLocalService(
		com.ihg.brandstandards.db.service.GlossaryTranslateLocalService glossaryTranslateLocalService) {
		this.glossaryTranslateLocalService = glossaryTranslateLocalService;
	}

	/**
	 * Returns the glossary translate persistence.
	 *
	 * @return the glossary translate persistence
	 */
	public GlossaryTranslatePersistence getGlossaryTranslatePersistence() {
		return glossaryTranslatePersistence;
	}

	/**
	 * Sets the glossary translate persistence.
	 *
	 * @param glossaryTranslatePersistence the glossary translate persistence
	 */
	public void setGlossaryTranslatePersistence(
		GlossaryTranslatePersistence glossaryTranslatePersistence) {
		this.glossaryTranslatePersistence = glossaryTranslatePersistence;
	}

	/**
	 * Returns the hist manual attachment local service.
	 *
	 * @return the hist manual attachment local service
	 */
	public com.ihg.brandstandards.db.service.HistManualAttachmentLocalService getHistManualAttachmentLocalService() {
		return histManualAttachmentLocalService;
	}

	/**
	 * Sets the hist manual attachment local service.
	 *
	 * @param histManualAttachmentLocalService the hist manual attachment local service
	 */
	public void setHistManualAttachmentLocalService(
		com.ihg.brandstandards.db.service.HistManualAttachmentLocalService histManualAttachmentLocalService) {
		this.histManualAttachmentLocalService = histManualAttachmentLocalService;
	}

	/**
	 * Returns the hist manual attachment persistence.
	 *
	 * @return the hist manual attachment persistence
	 */
	public HistManualAttachmentPersistence getHistManualAttachmentPersistence() {
		return histManualAttachmentPersistence;
	}

	/**
	 * Sets the hist manual attachment persistence.
	 *
	 * @param histManualAttachmentPersistence the hist manual attachment persistence
	 */
	public void setHistManualAttachmentPersistence(
		HistManualAttachmentPersistence histManualAttachmentPersistence) {
		this.histManualAttachmentPersistence = histManualAttachmentPersistence;
	}

	/**
	 * Returns the hist manual chain local service.
	 *
	 * @return the hist manual chain local service
	 */
	public com.ihg.brandstandards.db.service.HistManualChainLocalService getHistManualChainLocalService() {
		return histManualChainLocalService;
	}

	/**
	 * Sets the hist manual chain local service.
	 *
	 * @param histManualChainLocalService the hist manual chain local service
	 */
	public void setHistManualChainLocalService(
		com.ihg.brandstandards.db.service.HistManualChainLocalService histManualChainLocalService) {
		this.histManualChainLocalService = histManualChainLocalService;
	}

	/**
	 * Returns the hist manual chain persistence.
	 *
	 * @return the hist manual chain persistence
	 */
	public HistManualChainPersistence getHistManualChainPersistence() {
		return histManualChainPersistence;
	}

	/**
	 * Sets the hist manual chain persistence.
	 *
	 * @param histManualChainPersistence the hist manual chain persistence
	 */
	public void setHistManualChainPersistence(
		HistManualChainPersistence histManualChainPersistence) {
		this.histManualChainPersistence = histManualChainPersistence;
	}

	/**
	 * Returns the hist manual region local service.
	 *
	 * @return the hist manual region local service
	 */
	public com.ihg.brandstandards.db.service.HistManualRegionLocalService getHistManualRegionLocalService() {
		return histManualRegionLocalService;
	}

	/**
	 * Sets the hist manual region local service.
	 *
	 * @param histManualRegionLocalService the hist manual region local service
	 */
	public void setHistManualRegionLocalService(
		com.ihg.brandstandards.db.service.HistManualRegionLocalService histManualRegionLocalService) {
		this.histManualRegionLocalService = histManualRegionLocalService;
	}

	/**
	 * Returns the hist manual region persistence.
	 *
	 * @return the hist manual region persistence
	 */
	public HistManualRegionPersistence getHistManualRegionPersistence() {
		return histManualRegionPersistence;
	}

	/**
	 * Sets the hist manual region persistence.
	 *
	 * @param histManualRegionPersistence the hist manual region persistence
	 */
	public void setHistManualRegionPersistence(
		HistManualRegionPersistence histManualRegionPersistence) {
		this.histManualRegionPersistence = histManualRegionPersistence;
	}

	/**
	 * Returns the hist manuals local service.
	 *
	 * @return the hist manuals local service
	 */
	public com.ihg.brandstandards.db.service.HistManualsLocalService getHistManualsLocalService() {
		return histManualsLocalService;
	}

	/**
	 * Sets the hist manuals local service.
	 *
	 * @param histManualsLocalService the hist manuals local service
	 */
	public void setHistManualsLocalService(
		com.ihg.brandstandards.db.service.HistManualsLocalService histManualsLocalService) {
		this.histManualsLocalService = histManualsLocalService;
	}

	/**
	 * Returns the hist manuals persistence.
	 *
	 * @return the hist manuals persistence
	 */
	public HistManualsPersistence getHistManualsPersistence() {
		return histManualsPersistence;
	}

	/**
	 * Sets the hist manuals persistence.
	 *
	 * @param histManualsPersistence the hist manuals persistence
	 */
	public void setHistManualsPersistence(
		HistManualsPersistence histManualsPersistence) {
		this.histManualsPersistence = histManualsPersistence;
	}

	/**
	 * Returns the hist manuals finder.
	 *
	 * @return the hist manuals finder
	 */
	public HistManualsFinder getHistManualsFinder() {
		return histManualsFinder;
	}

	/**
	 * Sets the hist manuals finder.
	 *
	 * @param histManualsFinder the hist manuals finder
	 */
	public void setHistManualsFinder(HistManualsFinder histManualsFinder) {
		this.histManualsFinder = histManualsFinder;
	}

	/**
	 * Returns the image local service.
	 *
	 * @return the image local service
	 */
	public com.ihg.brandstandards.db.service.ImageLocalService getImageLocalService() {
		return imageLocalService;
	}

	/**
	 * Sets the image local service.
	 *
	 * @param imageLocalService the image local service
	 */
	public void setImageLocalService(
		com.ihg.brandstandards.db.service.ImageLocalService imageLocalService) {
		this.imageLocalService = imageLocalService;
	}

	/**
	 * Returns the image persistence.
	 *
	 * @return the image persistence
	 */
	public ImagePersistence getImagePersistence() {
		return imagePersistence;
	}

	/**
	 * Sets the image persistence.
	 *
	 * @param imagePersistence the image persistence
	 */
	public void setImagePersistence(ImagePersistence imagePersistence) {
		this.imagePersistence = imagePersistence;
	}

	/**
	 * Returns the image finder.
	 *
	 * @return the image finder
	 */
	public ImageFinder getImageFinder() {
		return imageFinder;
	}

	/**
	 * Sets the image finder.
	 *
	 * @param imageFinder the image finder
	 */
	public void setImageFinder(ImageFinder imageFinder) {
		this.imageFinder = imageFinder;
	}

	/**
	 * Returns the job queue local service.
	 *
	 * @return the job queue local service
	 */
	public com.ihg.brandstandards.db.service.JobQueueLocalService getJobQueueLocalService() {
		return jobQueueLocalService;
	}

	/**
	 * Sets the job queue local service.
	 *
	 * @param jobQueueLocalService the job queue local service
	 */
	public void setJobQueueLocalService(
		com.ihg.brandstandards.db.service.JobQueueLocalService jobQueueLocalService) {
		this.jobQueueLocalService = jobQueueLocalService;
	}

	/**
	 * Returns the job queue remote service.
	 *
	 * @return the job queue remote service
	 */
	public com.ihg.brandstandards.db.service.JobQueueService getJobQueueService() {
		return jobQueueService;
	}

	/**
	 * Sets the job queue remote service.
	 *
	 * @param jobQueueService the job queue remote service
	 */
	public void setJobQueueService(
		com.ihg.brandstandards.db.service.JobQueueService jobQueueService) {
		this.jobQueueService = jobQueueService;
	}

	/**
	 * Returns the job queue persistence.
	 *
	 * @return the job queue persistence
	 */
	public JobQueuePersistence getJobQueuePersistence() {
		return jobQueuePersistence;
	}

	/**
	 * Sets the job queue persistence.
	 *
	 * @param jobQueuePersistence the job queue persistence
	 */
	public void setJobQueuePersistence(JobQueuePersistence jobQueuePersistence) {
		this.jobQueuePersistence = jobQueuePersistence;
	}

	/**
	 * Returns the job queue finder.
	 *
	 * @return the job queue finder
	 */
	public JobQueueFinder getJobQueueFinder() {
		return jobQueueFinder;
	}

	/**
	 * Sets the job queue finder.
	 *
	 * @param jobQueueFinder the job queue finder
	 */
	public void setJobQueueFinder(JobQueueFinder jobQueueFinder) {
		this.jobQueueFinder = jobQueueFinder;
	}

	/**
	 * Returns the must publish local service.
	 *
	 * @return the must publish local service
	 */
	public com.ihg.brandstandards.db.service.MustPublishLocalService getMustPublishLocalService() {
		return mustPublishLocalService;
	}

	/**
	 * Sets the must publish local service.
	 *
	 * @param mustPublishLocalService the must publish local service
	 */
	public void setMustPublishLocalService(
		com.ihg.brandstandards.db.service.MustPublishLocalService mustPublishLocalService) {
		this.mustPublishLocalService = mustPublishLocalService;
	}

	/**
	 * Returns the must publish persistence.
	 *
	 * @return the must publish persistence
	 */
	public MustPublishPersistence getMustPublishPersistence() {
		return mustPublishPersistence;
	}

	/**
	 * Sets the must publish persistence.
	 *
	 * @param mustPublishPersistence the must publish persistence
	 */
	public void setMustPublishPersistence(
		MustPublishPersistence mustPublishPersistence) {
		this.mustPublishPersistence = mustPublishPersistence;
	}

	/**
	 * Returns the must publish finder.
	 *
	 * @return the must publish finder
	 */
	public MustPublishFinder getMustPublishFinder() {
		return mustPublishFinder;
	}

	/**
	 * Sets the must publish finder.
	 *
	 * @param mustPublishFinder the must publish finder
	 */
	public void setMustPublishFinder(MustPublishFinder mustPublishFinder) {
		this.mustPublishFinder = mustPublishFinder;
	}

	/**
	 * Returns the publication local service.
	 *
	 * @return the publication local service
	 */
	public com.ihg.brandstandards.db.service.PublicationLocalService getPublicationLocalService() {
		return publicationLocalService;
	}

	/**
	 * Sets the publication local service.
	 *
	 * @param publicationLocalService the publication local service
	 */
	public void setPublicationLocalService(
		com.ihg.brandstandards.db.service.PublicationLocalService publicationLocalService) {
		this.publicationLocalService = publicationLocalService;
	}

	/**
	 * Returns the publication persistence.
	 *
	 * @return the publication persistence
	 */
	public PublicationPersistence getPublicationPersistence() {
		return publicationPersistence;
	}

	/**
	 * Sets the publication persistence.
	 *
	 * @param publicationPersistence the publication persistence
	 */
	public void setPublicationPersistence(
		PublicationPersistence publicationPersistence) {
		this.publicationPersistence = publicationPersistence;
	}

	/**
	 * Returns the publication finder.
	 *
	 * @return the publication finder
	 */
	public PublicationFinder getPublicationFinder() {
		return publicationFinder;
	}

	/**
	 * Sets the publication finder.
	 *
	 * @param publicationFinder the publication finder
	 */
	public void setPublicationFinder(PublicationFinder publicationFinder) {
		this.publicationFinder = publicationFinder;
	}

	/**
	 * Returns the publish country standard local service.
	 *
	 * @return the publish country standard local service
	 */
	public com.ihg.brandstandards.db.service.PublishCountryStandardLocalService getPublishCountryStandardLocalService() {
		return publishCountryStandardLocalService;
	}

	/**
	 * Sets the publish country standard local service.
	 *
	 * @param publishCountryStandardLocalService the publish country standard local service
	 */
	public void setPublishCountryStandardLocalService(
		com.ihg.brandstandards.db.service.PublishCountryStandardLocalService publishCountryStandardLocalService) {
		this.publishCountryStandardLocalService = publishCountryStandardLocalService;
	}

	/**
	 * Returns the publish country standard persistence.
	 *
	 * @return the publish country standard persistence
	 */
	public PublishCountryStandardPersistence getPublishCountryStandardPersistence() {
		return publishCountryStandardPersistence;
	}

	/**
	 * Sets the publish country standard persistence.
	 *
	 * @param publishCountryStandardPersistence the publish country standard persistence
	 */
	public void setPublishCountryStandardPersistence(
		PublishCountryStandardPersistence publishCountryStandardPersistence) {
		this.publishCountryStandardPersistence = publishCountryStandardPersistence;
	}

	/**
	 * Returns the publish dept local service.
	 *
	 * @return the publish dept local service
	 */
	public com.ihg.brandstandards.db.service.PublishDeptLocalService getPublishDeptLocalService() {
		return publishDeptLocalService;
	}

	/**
	 * Sets the publish dept local service.
	 *
	 * @param publishDeptLocalService the publish dept local service
	 */
	public void setPublishDeptLocalService(
		com.ihg.brandstandards.db.service.PublishDeptLocalService publishDeptLocalService) {
		this.publishDeptLocalService = publishDeptLocalService;
	}

	/**
	 * Returns the publish dept persistence.
	 *
	 * @return the publish dept persistence
	 */
	public PublishDeptPersistence getPublishDeptPersistence() {
		return publishDeptPersistence;
	}

	/**
	 * Sets the publish dept persistence.
	 *
	 * @param publishDeptPersistence the publish dept persistence
	 */
	public void setPublishDeptPersistence(
		PublishDeptPersistence publishDeptPersistence) {
		this.publishDeptPersistence = publishDeptPersistence;
	}

	/**
	 * Returns the publish dept finder.
	 *
	 * @return the publish dept finder
	 */
	public PublishDeptFinder getPublishDeptFinder() {
		return publishDeptFinder;
	}

	/**
	 * Sets the publish dept finder.
	 *
	 * @param publishDeptFinder the publish dept finder
	 */
	public void setPublishDeptFinder(PublishDeptFinder publishDeptFinder) {
		this.publishDeptFinder = publishDeptFinder;
	}

	/**
	 * Returns the published pdf list local service.
	 *
	 * @return the published pdf list local service
	 */
	public com.ihg.brandstandards.db.service.PublishedPdfListLocalService getPublishedPdfListLocalService() {
		return publishedPdfListLocalService;
	}

	/**
	 * Sets the published pdf list local service.
	 *
	 * @param publishedPdfListLocalService the published pdf list local service
	 */
	public void setPublishedPdfListLocalService(
		com.ihg.brandstandards.db.service.PublishedPdfListLocalService publishedPdfListLocalService) {
		this.publishedPdfListLocalService = publishedPdfListLocalService;
	}

	/**
	 * Returns the published pdf list persistence.
	 *
	 * @return the published pdf list persistence
	 */
	public PublishedPdfListPersistence getPublishedPdfListPersistence() {
		return publishedPdfListPersistence;
	}

	/**
	 * Sets the published pdf list persistence.
	 *
	 * @param publishedPdfListPersistence the published pdf list persistence
	 */
	public void setPublishedPdfListPersistence(
		PublishedPdfListPersistence publishedPdfListPersistence) {
		this.publishedPdfListPersistence = publishedPdfListPersistence;
	}

	/**
	 * Returns the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. local service.
	 *
	 * @return the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. local service
	 */
	public com.ihg.brandstandards.db.service.PublishExtStdLocalService getPublishExtStdLocalService() {
		return publishExtStdLocalService;
	}

	/**
	 * Sets the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. local service.
	 *
	 * @param publishExtStdLocalService the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. local service
	 */
	public void setPublishExtStdLocalService(
		com.ihg.brandstandards.db.service.PublishExtStdLocalService publishExtStdLocalService) {
		this.publishExtStdLocalService = publishExtStdLocalService;
	}

	/**
	 * Returns the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. persistence.
	 *
	 * @return the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. persistence
	 */
	public PublishExtStdPersistence getPublishExtStdPersistence() {
		return publishExtStdPersistence;
	}

	/**
	 * Sets the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. persistence.
	 *
	 * @param publishExtStdPersistence the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. persistence
	 */
	public void setPublishExtStdPersistence(
		PublishExtStdPersistence publishExtStdPersistence) {
		this.publishExtStdPersistence = publishExtStdPersistence;
	}

	/**
	 * Returns the publish parm local service.
	 *
	 * @return the publish parm local service
	 */
	public com.ihg.brandstandards.db.service.PublishParmLocalService getPublishParmLocalService() {
		return publishParmLocalService;
	}

	/**
	 * Sets the publish parm local service.
	 *
	 * @param publishParmLocalService the publish parm local service
	 */
	public void setPublishParmLocalService(
		com.ihg.brandstandards.db.service.PublishParmLocalService publishParmLocalService) {
		this.publishParmLocalService = publishParmLocalService;
	}

	/**
	 * Returns the publish parm persistence.
	 *
	 * @return the publish parm persistence
	 */
	public PublishParmPersistence getPublishParmPersistence() {
		return publishParmPersistence;
	}

	/**
	 * Sets the publish parm persistence.
	 *
	 * @param publishParmPersistence the publish parm persistence
	 */
	public void setPublishParmPersistence(
		PublishParmPersistence publishParmPersistence) {
		this.publishParmPersistence = publishParmPersistence;
	}

	/**
	 * Returns the publish parm finder.
	 *
	 * @return the publish parm finder
	 */
	public PublishParmFinder getPublishParmFinder() {
		return publishParmFinder;
	}

	/**
	 * Sets the publish parm finder.
	 *
	 * @param publishParmFinder the publish parm finder
	 */
	public void setPublishParmFinder(PublishParmFinder publishParmFinder) {
		this.publishParmFinder = publishParmFinder;
	}

	/**
	 * Returns the publish queue local service.
	 *
	 * @return the publish queue local service
	 */
	public com.ihg.brandstandards.db.service.PublishQueueLocalService getPublishQueueLocalService() {
		return publishQueueLocalService;
	}

	/**
	 * Sets the publish queue local service.
	 *
	 * @param publishQueueLocalService the publish queue local service
	 */
	public void setPublishQueueLocalService(
		com.ihg.brandstandards.db.service.PublishQueueLocalService publishQueueLocalService) {
		this.publishQueueLocalService = publishQueueLocalService;
	}

	/**
	 * Returns the publish queue persistence.
	 *
	 * @return the publish queue persistence
	 */
	public PublishQueuePersistence getPublishQueuePersistence() {
		return publishQueuePersistence;
	}

	/**
	 * Sets the publish queue persistence.
	 *
	 * @param publishQueuePersistence the publish queue persistence
	 */
	public void setPublishQueuePersistence(
		PublishQueuePersistence publishQueuePersistence) {
		this.publishQueuePersistence = publishQueuePersistence;
	}

	/**
	 * Returns the publish queue finder.
	 *
	 * @return the publish queue finder
	 */
	public PublishQueueFinder getPublishQueueFinder() {
		return publishQueueFinder;
	}

	/**
	 * Sets the publish queue finder.
	 *
	 * @param publishQueueFinder the publish queue finder
	 */
	public void setPublishQueueFinder(PublishQueueFinder publishQueueFinder) {
		this.publishQueueFinder = publishQueueFinder;
	}

	/**
	 * Returns the Custom Query mapping to createlist of standards with translations. local service.
	 *
	 * @return the Custom Query mapping to createlist of standards with translations. local service
	 */
	public com.ihg.brandstandards.db.service.PublishStandardsExtLocalService getPublishStandardsExtLocalService() {
		return publishStandardsExtLocalService;
	}

	/**
	 * Sets the Custom Query mapping to createlist of standards with translations. local service.
	 *
	 * @param publishStandardsExtLocalService the Custom Query mapping to createlist of standards with translations. local service
	 */
	public void setPublishStandardsExtLocalService(
		com.ihg.brandstandards.db.service.PublishStandardsExtLocalService publishStandardsExtLocalService) {
		this.publishStandardsExtLocalService = publishStandardsExtLocalService;
	}

	/**
	 * Returns the Custom Query mapping to createlist of standards with translations. persistence.
	 *
	 * @return the Custom Query mapping to createlist of standards with translations. persistence
	 */
	public PublishStandardsExtPersistence getPublishStandardsExtPersistence() {
		return publishStandardsExtPersistence;
	}

	/**
	 * Sets the Custom Query mapping to createlist of standards with translations. persistence.
	 *
	 * @param publishStandardsExtPersistence the Custom Query mapping to createlist of standards with translations. persistence
	 */
	public void setPublishStandardsExtPersistence(
		PublishStandardsExtPersistence publishStandardsExtPersistence) {
		this.publishStandardsExtPersistence = publishStandardsExtPersistence;
	}

	/**
	 * Returns the Custom Query mapping to createlist of standards with translations. finder.
	 *
	 * @return the Custom Query mapping to createlist of standards with translations. finder
	 */
	public PublishStandardsExtFinder getPublishStandardsExtFinder() {
		return publishStandardsExtFinder;
	}

	/**
	 * Sets the Custom Query mapping to createlist of standards with translations. finder.
	 *
	 * @param publishStandardsExtFinder the Custom Query mapping to createlist of standards with translations. finder
	 */
	public void setPublishStandardsExtFinder(
		PublishStandardsExtFinder publishStandardsExtFinder) {
		this.publishStandardsExtFinder = publishStandardsExtFinder;
	}

	/**
	 * Returns the publish std local service.
	 *
	 * @return the publish std local service
	 */
	public com.ihg.brandstandards.db.service.PublishStdLocalService getPublishStdLocalService() {
		return publishStdLocalService;
	}

	/**
	 * Sets the publish std local service.
	 *
	 * @param publishStdLocalService the publish std local service
	 */
	public void setPublishStdLocalService(
		com.ihg.brandstandards.db.service.PublishStdLocalService publishStdLocalService) {
		this.publishStdLocalService = publishStdLocalService;
	}

	/**
	 * Returns the publish std persistence.
	 *
	 * @return the publish std persistence
	 */
	public PublishStdPersistence getPublishStdPersistence() {
		return publishStdPersistence;
	}

	/**
	 * Sets the publish std persistence.
	 *
	 * @param publishStdPersistence the publish std persistence
	 */
	public void setPublishStdPersistence(
		PublishStdPersistence publishStdPersistence) {
		this.publishStdPersistence = publishStdPersistence;
	}

	/**
	 * Returns the publish std finder.
	 *
	 * @return the publish std finder
	 */
	public PublishStdFinder getPublishStdFinder() {
		return publishStdFinder;
	}

	/**
	 * Sets the publish std finder.
	 *
	 * @param publishStdFinder the publish std finder
	 */
	public void setPublishStdFinder(PublishStdFinder publishStdFinder) {
		this.publishStdFinder = publishStdFinder;
	}

	/**
	 * Returns the publish taxonomy local service.
	 *
	 * @return the publish taxonomy local service
	 */
	public com.ihg.brandstandards.db.service.PublishTaxonomyLocalService getPublishTaxonomyLocalService() {
		return publishTaxonomyLocalService;
	}

	/**
	 * Sets the publish taxonomy local service.
	 *
	 * @param publishTaxonomyLocalService the publish taxonomy local service
	 */
	public void setPublishTaxonomyLocalService(
		com.ihg.brandstandards.db.service.PublishTaxonomyLocalService publishTaxonomyLocalService) {
		this.publishTaxonomyLocalService = publishTaxonomyLocalService;
	}

	/**
	 * Returns the publish taxonomy persistence.
	 *
	 * @return the publish taxonomy persistence
	 */
	public PublishTaxonomyPersistence getPublishTaxonomyPersistence() {
		return publishTaxonomyPersistence;
	}

	/**
	 * Sets the publish taxonomy persistence.
	 *
	 * @param publishTaxonomyPersistence the publish taxonomy persistence
	 */
	public void setPublishTaxonomyPersistence(
		PublishTaxonomyPersistence publishTaxonomyPersistence) {
		this.publishTaxonomyPersistence = publishTaxonomyPersistence;
	}

	/**
	 * Returns the Custom Query mapping to create index path. local service.
	 *
	 * @return the Custom Query mapping to create index path. local service
	 */
	public com.ihg.brandstandards.db.service.PublishTaxonomyExtLocalService getPublishTaxonomyExtLocalService() {
		return publishTaxonomyExtLocalService;
	}

	/**
	 * Sets the Custom Query mapping to create index path. local service.
	 *
	 * @param publishTaxonomyExtLocalService the Custom Query mapping to create index path. local service
	 */
	public void setPublishTaxonomyExtLocalService(
		com.ihg.brandstandards.db.service.PublishTaxonomyExtLocalService publishTaxonomyExtLocalService) {
		this.publishTaxonomyExtLocalService = publishTaxonomyExtLocalService;
	}

	/**
	 * Returns the Custom Query mapping to create index path. persistence.
	 *
	 * @return the Custom Query mapping to create index path. persistence
	 */
	public PublishTaxonomyExtPersistence getPublishTaxonomyExtPersistence() {
		return publishTaxonomyExtPersistence;
	}

	/**
	 * Sets the Custom Query mapping to create index path. persistence.
	 *
	 * @param publishTaxonomyExtPersistence the Custom Query mapping to create index path. persistence
	 */
	public void setPublishTaxonomyExtPersistence(
		PublishTaxonomyExtPersistence publishTaxonomyExtPersistence) {
		this.publishTaxonomyExtPersistence = publishTaxonomyExtPersistence;
	}

	/**
	 * Returns the Custom Query mapping to create index path. finder.
	 *
	 * @return the Custom Query mapping to create index path. finder
	 */
	public PublishTaxonomyExtFinder getPublishTaxonomyExtFinder() {
		return publishTaxonomyExtFinder;
	}

	/**
	 * Sets the Custom Query mapping to create index path. finder.
	 *
	 * @param publishTaxonomyExtFinder the Custom Query mapping to create index path. finder
	 */
	public void setPublishTaxonomyExtFinder(
		PublishTaxonomyExtFinder publishTaxonomyExtFinder) {
		this.publishTaxonomyExtFinder = publishTaxonomyExtFinder;
	}

	/**
	 * Returns the special word dictionary local service.
	 *
	 * @return the special word dictionary local service
	 */
	public com.ihg.brandstandards.db.service.SpecialWordDictionaryLocalService getSpecialWordDictionaryLocalService() {
		return specialWordDictionaryLocalService;
	}

	/**
	 * Sets the special word dictionary local service.
	 *
	 * @param specialWordDictionaryLocalService the special word dictionary local service
	 */
	public void setSpecialWordDictionaryLocalService(
		com.ihg.brandstandards.db.service.SpecialWordDictionaryLocalService specialWordDictionaryLocalService) {
		this.specialWordDictionaryLocalService = specialWordDictionaryLocalService;
	}

	/**
	 * Returns the special word dictionary persistence.
	 *
	 * @return the special word dictionary persistence
	 */
	public SpecialWordDictionaryPersistence getSpecialWordDictionaryPersistence() {
		return specialWordDictionaryPersistence;
	}

	/**
	 * Sets the special word dictionary persistence.
	 *
	 * @param specialWordDictionaryPersistence the special word dictionary persistence
	 */
	public void setSpecialWordDictionaryPersistence(
		SpecialWordDictionaryPersistence specialWordDictionaryPersistence) {
		this.specialWordDictionaryPersistence = specialWordDictionaryPersistence;
	}

	/**
	 * Returns the spread sheet attribute update local service.
	 *
	 * @return the spread sheet attribute update local service
	 */
	public com.ihg.brandstandards.db.service.SpreadSheetAttributeUpdateLocalService getSpreadSheetAttributeUpdateLocalService() {
		return spreadSheetAttributeUpdateLocalService;
	}

	/**
	 * Sets the spread sheet attribute update local service.
	 *
	 * @param spreadSheetAttributeUpdateLocalService the spread sheet attribute update local service
	 */
	public void setSpreadSheetAttributeUpdateLocalService(
		com.ihg.brandstandards.db.service.SpreadSheetAttributeUpdateLocalService spreadSheetAttributeUpdateLocalService) {
		this.spreadSheetAttributeUpdateLocalService = spreadSheetAttributeUpdateLocalService;
	}

	/**
	 * Returns the spread sheet attribute update persistence.
	 *
	 * @return the spread sheet attribute update persistence
	 */
	public SpreadSheetAttributeUpdatePersistence getSpreadSheetAttributeUpdatePersistence() {
		return spreadSheetAttributeUpdatePersistence;
	}

	/**
	 * Sets the spread sheet attribute update persistence.
	 *
	 * @param spreadSheetAttributeUpdatePersistence the spread sheet attribute update persistence
	 */
	public void setSpreadSheetAttributeUpdatePersistence(
		SpreadSheetAttributeUpdatePersistence spreadSheetAttributeUpdatePersistence) {
		this.spreadSheetAttributeUpdatePersistence = spreadSheetAttributeUpdatePersistence;
	}

	/**
	 * Returns the spread sheet attribute update finder.
	 *
	 * @return the spread sheet attribute update finder
	 */
	public SpreadSheetAttributeUpdateFinder getSpreadSheetAttributeUpdateFinder() {
		return spreadSheetAttributeUpdateFinder;
	}

	/**
	 * Sets the spread sheet attribute update finder.
	 *
	 * @param spreadSheetAttributeUpdateFinder the spread sheet attribute update finder
	 */
	public void setSpreadSheetAttributeUpdateFinder(
		SpreadSheetAttributeUpdateFinder spreadSheetAttributeUpdateFinder) {
		this.spreadSheetAttributeUpdateFinder = spreadSheetAttributeUpdateFinder;
	}

	/**
	 * Returns the standards local service.
	 *
	 * @return the standards local service
	 */
	public com.ihg.brandstandards.db.service.StandardsLocalService getStandardsLocalService() {
		return standardsLocalService;
	}

	/**
	 * Sets the standards local service.
	 *
	 * @param standardsLocalService the standards local service
	 */
	public void setStandardsLocalService(
		com.ihg.brandstandards.db.service.StandardsLocalService standardsLocalService) {
		this.standardsLocalService = standardsLocalService;
	}

	/**
	 * Returns the standards persistence.
	 *
	 * @return the standards persistence
	 */
	public StandardsPersistence getStandardsPersistence() {
		return standardsPersistence;
	}

	/**
	 * Sets the standards persistence.
	 *
	 * @param standardsPersistence the standards persistence
	 */
	public void setStandardsPersistence(
		StandardsPersistence standardsPersistence) {
		this.standardsPersistence = standardsPersistence;
	}

	/**
	 * Returns the standards finder.
	 *
	 * @return the standards finder
	 */
	public StandardsFinder getStandardsFinder() {
		return standardsFinder;
	}

	/**
	 * Sets the standards finder.
	 *
	 * @param standardsFinder the standards finder
	 */
	public void setStandardsFinder(StandardsFinder standardsFinder) {
		this.standardsFinder = standardsFinder;
	}

	/**
	 * Returns the standards authors local service.
	 *
	 * @return the standards authors local service
	 */
	public com.ihg.brandstandards.db.service.StandardsAuthorsLocalService getStandardsAuthorsLocalService() {
		return standardsAuthorsLocalService;
	}

	/**
	 * Sets the standards authors local service.
	 *
	 * @param standardsAuthorsLocalService the standards authors local service
	 */
	public void setStandardsAuthorsLocalService(
		com.ihg.brandstandards.db.service.StandardsAuthorsLocalService standardsAuthorsLocalService) {
		this.standardsAuthorsLocalService = standardsAuthorsLocalService;
	}

	/**
	 * Returns the standards authors persistence.
	 *
	 * @return the standards authors persistence
	 */
	public StandardsAuthorsPersistence getStandardsAuthorsPersistence() {
		return standardsAuthorsPersistence;
	}

	/**
	 * Sets the standards authors persistence.
	 *
	 * @param standardsAuthorsPersistence the standards authors persistence
	 */
	public void setStandardsAuthorsPersistence(
		StandardsAuthorsPersistence standardsAuthorsPersistence) {
		this.standardsAuthorsPersistence = standardsAuthorsPersistence;
	}

	/**
	 * Returns the standards chain images local service.
	 *
	 * @return the standards chain images local service
	 */
	public com.ihg.brandstandards.db.service.StandardsChainImagesLocalService getStandardsChainImagesLocalService() {
		return standardsChainImagesLocalService;
	}

	/**
	 * Sets the standards chain images local service.
	 *
	 * @param standardsChainImagesLocalService the standards chain images local service
	 */
	public void setStandardsChainImagesLocalService(
		com.ihg.brandstandards.db.service.StandardsChainImagesLocalService standardsChainImagesLocalService) {
		this.standardsChainImagesLocalService = standardsChainImagesLocalService;
	}

	/**
	 * Returns the standards chain images persistence.
	 *
	 * @return the standards chain images persistence
	 */
	public StandardsChainImagesPersistence getStandardsChainImagesPersistence() {
		return standardsChainImagesPersistence;
	}

	/**
	 * Sets the standards chain images persistence.
	 *
	 * @param standardsChainImagesPersistence the standards chain images persistence
	 */
	public void setStandardsChainImagesPersistence(
		StandardsChainImagesPersistence standardsChainImagesPersistence) {
		this.standardsChainImagesPersistence = standardsChainImagesPersistence;
	}

	/**
	 * Returns the standards compliance local service.
	 *
	 * @return the standards compliance local service
	 */
	public com.ihg.brandstandards.db.service.StandardsComplianceLocalService getStandardsComplianceLocalService() {
		return standardsComplianceLocalService;
	}

	/**
	 * Sets the standards compliance local service.
	 *
	 * @param standardsComplianceLocalService the standards compliance local service
	 */
	public void setStandardsComplianceLocalService(
		com.ihg.brandstandards.db.service.StandardsComplianceLocalService standardsComplianceLocalService) {
		this.standardsComplianceLocalService = standardsComplianceLocalService;
	}

	/**
	 * Returns the standards compliance persistence.
	 *
	 * @return the standards compliance persistence
	 */
	public StandardsCompliancePersistence getStandardsCompliancePersistence() {
		return standardsCompliancePersistence;
	}

	/**
	 * Sets the standards compliance persistence.
	 *
	 * @param standardsCompliancePersistence the standards compliance persistence
	 */
	public void setStandardsCompliancePersistence(
		StandardsCompliancePersistence standardsCompliancePersistence) {
		this.standardsCompliancePersistence = standardsCompliancePersistence;
	}

	/**
	 * Returns the standards compliance finder.
	 *
	 * @return the standards compliance finder
	 */
	public StandardsComplianceFinder getStandardsComplianceFinder() {
		return standardsComplianceFinder;
	}

	/**
	 * Sets the standards compliance finder.
	 *
	 * @param standardsComplianceFinder the standards compliance finder
	 */
	public void setStandardsComplianceFinder(
		StandardsComplianceFinder standardsComplianceFinder) {
		this.standardsComplianceFinder = standardsComplianceFinder;
	}

	/**
	 * Returns the standards compliance ext local service.
	 *
	 * @return the standards compliance ext local service
	 */
	public com.ihg.brandstandards.db.service.StandardsComplianceExtLocalService getStandardsComplianceExtLocalService() {
		return standardsComplianceExtLocalService;
	}

	/**
	 * Sets the standards compliance ext local service.
	 *
	 * @param standardsComplianceExtLocalService the standards compliance ext local service
	 */
	public void setStandardsComplianceExtLocalService(
		com.ihg.brandstandards.db.service.StandardsComplianceExtLocalService standardsComplianceExtLocalService) {
		this.standardsComplianceExtLocalService = standardsComplianceExtLocalService;
	}

	/**
	 * Returns the standards compliance ext persistence.
	 *
	 * @return the standards compliance ext persistence
	 */
	public StandardsComplianceExtPersistence getStandardsComplianceExtPersistence() {
		return standardsComplianceExtPersistence;
	}

	/**
	 * Sets the standards compliance ext persistence.
	 *
	 * @param standardsComplianceExtPersistence the standards compliance ext persistence
	 */
	public void setStandardsComplianceExtPersistence(
		StandardsComplianceExtPersistence standardsComplianceExtPersistence) {
		this.standardsComplianceExtPersistence = standardsComplianceExtPersistence;
	}

	/**
	 * Returns the standards compliance ext finder.
	 *
	 * @return the standards compliance ext finder
	 */
	public StandardsComplianceExtFinder getStandardsComplianceExtFinder() {
		return standardsComplianceExtFinder;
	}

	/**
	 * Sets the standards compliance ext finder.
	 *
	 * @param standardsComplianceExtFinder the standards compliance ext finder
	 */
	public void setStandardsComplianceExtFinder(
		StandardsComplianceExtFinder standardsComplianceExtFinder) {
		this.standardsComplianceExtFinder = standardsComplianceExtFinder;
	}

	/**
	 * Returns the standards country local service.
	 *
	 * @return the standards country local service
	 */
	public com.ihg.brandstandards.db.service.StandardsCountryLocalService getStandardsCountryLocalService() {
		return standardsCountryLocalService;
	}

	/**
	 * Sets the standards country local service.
	 *
	 * @param standardsCountryLocalService the standards country local service
	 */
	public void setStandardsCountryLocalService(
		com.ihg.brandstandards.db.service.StandardsCountryLocalService standardsCountryLocalService) {
		this.standardsCountryLocalService = standardsCountryLocalService;
	}

	/**
	 * Returns the standards country persistence.
	 *
	 * @return the standards country persistence
	 */
	public StandardsCountryPersistence getStandardsCountryPersistence() {
		return standardsCountryPersistence;
	}

	/**
	 * Sets the standards country persistence.
	 *
	 * @param standardsCountryPersistence the standards country persistence
	 */
	public void setStandardsCountryPersistence(
		StandardsCountryPersistence standardsCountryPersistence) {
		this.standardsCountryPersistence = standardsCountryPersistence;
	}

	/**
	 * Returns the standards country chain local service.
	 *
	 * @return the standards country chain local service
	 */
	public com.ihg.brandstandards.db.service.StandardsCountryChainLocalService getStandardsCountryChainLocalService() {
		return standardsCountryChainLocalService;
	}

	/**
	 * Sets the standards country chain local service.
	 *
	 * @param standardsCountryChainLocalService the standards country chain local service
	 */
	public void setStandardsCountryChainLocalService(
		com.ihg.brandstandards.db.service.StandardsCountryChainLocalService standardsCountryChainLocalService) {
		this.standardsCountryChainLocalService = standardsCountryChainLocalService;
	}

	/**
	 * Returns the standards country chain persistence.
	 *
	 * @return the standards country chain persistence
	 */
	public StandardsCountryChainPersistence getStandardsCountryChainPersistence() {
		return standardsCountryChainPersistence;
	}

	/**
	 * Sets the standards country chain persistence.
	 *
	 * @param standardsCountryChainPersistence the standards country chain persistence
	 */
	public void setStandardsCountryChainPersistence(
		StandardsCountryChainPersistence standardsCountryChainPersistence) {
		this.standardsCountryChainPersistence = standardsCountryChainPersistence;
	}

	/**
	 * Returns the standards country chain finder.
	 *
	 * @return the standards country chain finder
	 */
	public StandardsCountryChainFinder getStandardsCountryChainFinder() {
		return standardsCountryChainFinder;
	}

	/**
	 * Sets the standards country chain finder.
	 *
	 * @param standardsCountryChainFinder the standards country chain finder
	 */
	public void setStandardsCountryChainFinder(
		StandardsCountryChainFinder standardsCountryChainFinder) {
		this.standardsCountryChainFinder = standardsCountryChainFinder;
	}

	/**
	 * Returns the standards country ext local service.
	 *
	 * @return the standards country ext local service
	 */
	public com.ihg.brandstandards.db.service.StandardsCountryExtLocalService getStandardsCountryExtLocalService() {
		return standardsCountryExtLocalService;
	}

	/**
	 * Sets the standards country ext local service.
	 *
	 * @param standardsCountryExtLocalService the standards country ext local service
	 */
	public void setStandardsCountryExtLocalService(
		com.ihg.brandstandards.db.service.StandardsCountryExtLocalService standardsCountryExtLocalService) {
		this.standardsCountryExtLocalService = standardsCountryExtLocalService;
	}

	/**
	 * Returns the standards country ext persistence.
	 *
	 * @return the standards country ext persistence
	 */
	public StandardsCountryExtPersistence getStandardsCountryExtPersistence() {
		return standardsCountryExtPersistence;
	}

	/**
	 * Sets the standards country ext persistence.
	 *
	 * @param standardsCountryExtPersistence the standards country ext persistence
	 */
	public void setStandardsCountryExtPersistence(
		StandardsCountryExtPersistence standardsCountryExtPersistence) {
		this.standardsCountryExtPersistence = standardsCountryExtPersistence;
	}

	/**
	 * Returns the standards country ext finder.
	 *
	 * @return the standards country ext finder
	 */
	public StandardsCountryExtFinder getStandardsCountryExtFinder() {
		return standardsCountryExtFinder;
	}

	/**
	 * Sets the standards country ext finder.
	 *
	 * @param standardsCountryExtFinder the standards country ext finder
	 */
	public void setStandardsCountryExtFinder(
		StandardsCountryExtFinder standardsCountryExtFinder) {
		this.standardsCountryExtFinder = standardsCountryExtFinder;
	}

	/**
	 * Returns the standards country images local service.
	 *
	 * @return the standards country images local service
	 */
	public com.ihg.brandstandards.db.service.StandardsCountryImagesLocalService getStandardsCountryImagesLocalService() {
		return standardsCountryImagesLocalService;
	}

	/**
	 * Sets the standards country images local service.
	 *
	 * @param standardsCountryImagesLocalService the standards country images local service
	 */
	public void setStandardsCountryImagesLocalService(
		com.ihg.brandstandards.db.service.StandardsCountryImagesLocalService standardsCountryImagesLocalService) {
		this.standardsCountryImagesLocalService = standardsCountryImagesLocalService;
	}

	/**
	 * Returns the standards country images persistence.
	 *
	 * @return the standards country images persistence
	 */
	public StandardsCountryImagesPersistence getStandardsCountryImagesPersistence() {
		return standardsCountryImagesPersistence;
	}

	/**
	 * Sets the standards country images persistence.
	 *
	 * @param standardsCountryImagesPersistence the standards country images persistence
	 */
	public void setStandardsCountryImagesPersistence(
		StandardsCountryImagesPersistence standardsCountryImagesPersistence) {
		this.standardsCountryImagesPersistence = standardsCountryImagesPersistence;
	}

	/**
	 * Returns the standards cross reference local service.
	 *
	 * @return the standards cross reference local service
	 */
	public com.ihg.brandstandards.db.service.StandardsCrossReferenceLocalService getStandardsCrossReferenceLocalService() {
		return standardsCrossReferenceLocalService;
	}

	/**
	 * Sets the standards cross reference local service.
	 *
	 * @param standardsCrossReferenceLocalService the standards cross reference local service
	 */
	public void setStandardsCrossReferenceLocalService(
		com.ihg.brandstandards.db.service.StandardsCrossReferenceLocalService standardsCrossReferenceLocalService) {
		this.standardsCrossReferenceLocalService = standardsCrossReferenceLocalService;
	}

	/**
	 * Returns the standards cross reference persistence.
	 *
	 * @return the standards cross reference persistence
	 */
	public StandardsCrossReferencePersistence getStandardsCrossReferencePersistence() {
		return standardsCrossReferencePersistence;
	}

	/**
	 * Sets the standards cross reference persistence.
	 *
	 * @param standardsCrossReferencePersistence the standards cross reference persistence
	 */
	public void setStandardsCrossReferencePersistence(
		StandardsCrossReferencePersistence standardsCrossReferencePersistence) {
		this.standardsCrossReferencePersistence = standardsCrossReferencePersistence;
	}

	/**
	 * Returns the standards display order local service.
	 *
	 * @return the standards display order local service
	 */
	public com.ihg.brandstandards.db.service.StandardsDisplayOrderLocalService getStandardsDisplayOrderLocalService() {
		return standardsDisplayOrderLocalService;
	}

	/**
	 * Sets the standards display order local service.
	 *
	 * @param standardsDisplayOrderLocalService the standards display order local service
	 */
	public void setStandardsDisplayOrderLocalService(
		com.ihg.brandstandards.db.service.StandardsDisplayOrderLocalService standardsDisplayOrderLocalService) {
		this.standardsDisplayOrderLocalService = standardsDisplayOrderLocalService;
	}

	/**
	 * Returns the standards display order persistence.
	 *
	 * @return the standards display order persistence
	 */
	public StandardsDisplayOrderPersistence getStandardsDisplayOrderPersistence() {
		return standardsDisplayOrderPersistence;
	}

	/**
	 * Sets the standards display order persistence.
	 *
	 * @param standardsDisplayOrderPersistence the standards display order persistence
	 */
	public void setStandardsDisplayOrderPersistence(
		StandardsDisplayOrderPersistence standardsDisplayOrderPersistence) {
		this.standardsDisplayOrderPersistence = standardsDisplayOrderPersistence;
	}

	/**
	 * Returns the standards display order ext local service.
	 *
	 * @return the standards display order ext local service
	 */
	public com.ihg.brandstandards.db.service.StandardsDisplayOrderExtLocalService getStandardsDisplayOrderExtLocalService() {
		return standardsDisplayOrderExtLocalService;
	}

	/**
	 * Sets the standards display order ext local service.
	 *
	 * @param standardsDisplayOrderExtLocalService the standards display order ext local service
	 */
	public void setStandardsDisplayOrderExtLocalService(
		com.ihg.brandstandards.db.service.StandardsDisplayOrderExtLocalService standardsDisplayOrderExtLocalService) {
		this.standardsDisplayOrderExtLocalService = standardsDisplayOrderExtLocalService;
	}

	/**
	 * Returns the standards display order ext persistence.
	 *
	 * @return the standards display order ext persistence
	 */
	public StandardsDisplayOrderExtPersistence getStandardsDisplayOrderExtPersistence() {
		return standardsDisplayOrderExtPersistence;
	}

	/**
	 * Sets the standards display order ext persistence.
	 *
	 * @param standardsDisplayOrderExtPersistence the standards display order ext persistence
	 */
	public void setStandardsDisplayOrderExtPersistence(
		StandardsDisplayOrderExtPersistence standardsDisplayOrderExtPersistence) {
		this.standardsDisplayOrderExtPersistence = standardsDisplayOrderExtPersistence;
	}

	/**
	 * Returns the standards display order ext finder.
	 *
	 * @return the standards display order ext finder
	 */
	public StandardsDisplayOrderExtFinder getStandardsDisplayOrderExtFinder() {
		return standardsDisplayOrderExtFinder;
	}

	/**
	 * Sets the standards display order ext finder.
	 *
	 * @param standardsDisplayOrderExtFinder the standards display order ext finder
	 */
	public void setStandardsDisplayOrderExtFinder(
		StandardsDisplayOrderExtFinder standardsDisplayOrderExtFinder) {
		this.standardsDisplayOrderExtFinder = standardsDisplayOrderExtFinder;
	}

	/**
	 * Returns the Custom Query mapping between STD and Taxonomy tables. local service.
	 *
	 * @return the Custom Query mapping between STD and Taxonomy tables. local service
	 */
	public com.ihg.brandstandards.db.service.StandardsExtLocalService getStandardsExtLocalService() {
		return standardsExtLocalService;
	}

	/**
	 * Sets the Custom Query mapping between STD and Taxonomy tables. local service.
	 *
	 * @param standardsExtLocalService the Custom Query mapping between STD and Taxonomy tables. local service
	 */
	public void setStandardsExtLocalService(
		com.ihg.brandstandards.db.service.StandardsExtLocalService standardsExtLocalService) {
		this.standardsExtLocalService = standardsExtLocalService;
	}

	/**
	 * Returns the Custom Query mapping between STD and Taxonomy tables. persistence.
	 *
	 * @return the Custom Query mapping between STD and Taxonomy tables. persistence
	 */
	public StandardsExtPersistence getStandardsExtPersistence() {
		return standardsExtPersistence;
	}

	/**
	 * Sets the Custom Query mapping between STD and Taxonomy tables. persistence.
	 *
	 * @param standardsExtPersistence the Custom Query mapping between STD and Taxonomy tables. persistence
	 */
	public void setStandardsExtPersistence(
		StandardsExtPersistence standardsExtPersistence) {
		this.standardsExtPersistence = standardsExtPersistence;
	}

	/**
	 * Returns the Custom Query mapping between STD and Taxonomy tables. finder.
	 *
	 * @return the Custom Query mapping between STD and Taxonomy tables. finder
	 */
	public StandardsExtFinder getStandardsExtFinder() {
		return standardsExtFinder;
	}

	/**
	 * Sets the Custom Query mapping between STD and Taxonomy tables. finder.
	 *
	 * @param standardsExtFinder the Custom Query mapping between STD and Taxonomy tables. finder
	 */
	public void setStandardsExtFinder(StandardsExtFinder standardsExtFinder) {
		this.standardsExtFinder = standardsExtFinder;
	}

	/**
	 * Returns the standards historical manual local service.
	 *
	 * @return the standards historical manual local service
	 */
	public com.ihg.brandstandards.db.service.StandardsHistoricalManualLocalService getStandardsHistoricalManualLocalService() {
		return standardsHistoricalManualLocalService;
	}

	/**
	 * Sets the standards historical manual local service.
	 *
	 * @param standardsHistoricalManualLocalService the standards historical manual local service
	 */
	public void setStandardsHistoricalManualLocalService(
		com.ihg.brandstandards.db.service.StandardsHistoricalManualLocalService standardsHistoricalManualLocalService) {
		this.standardsHistoricalManualLocalService = standardsHistoricalManualLocalService;
	}

	/**
	 * Returns the standards historical manual persistence.
	 *
	 * @return the standards historical manual persistence
	 */
	public StandardsHistoricalManualPersistence getStandardsHistoricalManualPersistence() {
		return standardsHistoricalManualPersistence;
	}

	/**
	 * Sets the standards historical manual persistence.
	 *
	 * @param standardsHistoricalManualPersistence the standards historical manual persistence
	 */
	public void setStandardsHistoricalManualPersistence(
		StandardsHistoricalManualPersistence standardsHistoricalManualPersistence) {
		this.standardsHistoricalManualPersistence = standardsHistoricalManualPersistence;
	}

	/**
	 * Returns the standards historical manual finder.
	 *
	 * @return the standards historical manual finder
	 */
	public StandardsHistoricalManualFinder getStandardsHistoricalManualFinder() {
		return standardsHistoricalManualFinder;
	}

	/**
	 * Sets the standards historical manual finder.
	 *
	 * @param standardsHistoricalManualFinder the standards historical manual finder
	 */
	public void setStandardsHistoricalManualFinder(
		StandardsHistoricalManualFinder standardsHistoricalManualFinder) {
		this.standardsHistoricalManualFinder = standardsHistoricalManualFinder;
	}

	/**
	 * Returns the standards images local service.
	 *
	 * @return the standards images local service
	 */
	public com.ihg.brandstandards.db.service.StandardsImagesLocalService getStandardsImagesLocalService() {
		return standardsImagesLocalService;
	}

	/**
	 * Sets the standards images local service.
	 *
	 * @param standardsImagesLocalService the standards images local service
	 */
	public void setStandardsImagesLocalService(
		com.ihg.brandstandards.db.service.StandardsImagesLocalService standardsImagesLocalService) {
		this.standardsImagesLocalService = standardsImagesLocalService;
	}

	/**
	 * Returns the standards images persistence.
	 *
	 * @return the standards images persistence
	 */
	public StandardsImagesPersistence getStandardsImagesPersistence() {
		return standardsImagesPersistence;
	}

	/**
	 * Sets the standards images persistence.
	 *
	 * @param standardsImagesPersistence the standards images persistence
	 */
	public void setStandardsImagesPersistence(
		StandardsImagesPersistence standardsImagesPersistence) {
		this.standardsImagesPersistence = standardsImagesPersistence;
	}

	/**
	 * Returns the standards images finder.
	 *
	 * @return the standards images finder
	 */
	public StandardsImagesFinder getStandardsImagesFinder() {
		return standardsImagesFinder;
	}

	/**
	 * Sets the standards images finder.
	 *
	 * @param standardsImagesFinder the standards images finder
	 */
	public void setStandardsImagesFinder(
		StandardsImagesFinder standardsImagesFinder) {
		this.standardsImagesFinder = standardsImagesFinder;
	}

	/**
	 * Returns the standards locale local service.
	 *
	 * @return the standards locale local service
	 */
	public com.ihg.brandstandards.db.service.StandardsLocaleLocalService getStandardsLocaleLocalService() {
		return standardsLocaleLocalService;
	}

	/**
	 * Sets the standards locale local service.
	 *
	 * @param standardsLocaleLocalService the standards locale local service
	 */
	public void setStandardsLocaleLocalService(
		com.ihg.brandstandards.db.service.StandardsLocaleLocalService standardsLocaleLocalService) {
		this.standardsLocaleLocalService = standardsLocaleLocalService;
	}

	/**
	 * Returns the standards locale persistence.
	 *
	 * @return the standards locale persistence
	 */
	public StandardsLocalePersistence getStandardsLocalePersistence() {
		return standardsLocalePersistence;
	}

	/**
	 * Sets the standards locale persistence.
	 *
	 * @param standardsLocalePersistence the standards locale persistence
	 */
	public void setStandardsLocalePersistence(
		StandardsLocalePersistence standardsLocalePersistence) {
		this.standardsLocalePersistence = standardsLocalePersistence;
	}

	/**
	 * Returns the standards locale finder.
	 *
	 * @return the standards locale finder
	 */
	public StandardsLocaleFinder getStandardsLocaleFinder() {
		return standardsLocaleFinder;
	}

	/**
	 * Sets the standards locale finder.
	 *
	 * @param standardsLocaleFinder the standards locale finder
	 */
	public void setStandardsLocaleFinder(
		StandardsLocaleFinder standardsLocaleFinder) {
		this.standardsLocaleFinder = standardsLocaleFinder;
	}

	/**
	 * Returns the standards region local service.
	 *
	 * @return the standards region local service
	 */
	public com.ihg.brandstandards.db.service.StandardsRegionLocalService getStandardsRegionLocalService() {
		return standardsRegionLocalService;
	}

	/**
	 * Sets the standards region local service.
	 *
	 * @param standardsRegionLocalService the standards region local service
	 */
	public void setStandardsRegionLocalService(
		com.ihg.brandstandards.db.service.StandardsRegionLocalService standardsRegionLocalService) {
		this.standardsRegionLocalService = standardsRegionLocalService;
	}

	/**
	 * Returns the standards region persistence.
	 *
	 * @return the standards region persistence
	 */
	public StandardsRegionPersistence getStandardsRegionPersistence() {
		return standardsRegionPersistence;
	}

	/**
	 * Sets the standards region persistence.
	 *
	 * @param standardsRegionPersistence the standards region persistence
	 */
	public void setStandardsRegionPersistence(
		StandardsRegionPersistence standardsRegionPersistence) {
		this.standardsRegionPersistence = standardsRegionPersistence;
	}

	/**
	 * Returns the standards region chain local service.
	 *
	 * @return the standards region chain local service
	 */
	public com.ihg.brandstandards.db.service.StandardsRegionChainLocalService getStandardsRegionChainLocalService() {
		return standardsRegionChainLocalService;
	}

	/**
	 * Sets the standards region chain local service.
	 *
	 * @param standardsRegionChainLocalService the standards region chain local service
	 */
	public void setStandardsRegionChainLocalService(
		com.ihg.brandstandards.db.service.StandardsRegionChainLocalService standardsRegionChainLocalService) {
		this.standardsRegionChainLocalService = standardsRegionChainLocalService;
	}

	/**
	 * Returns the standards region chain persistence.
	 *
	 * @return the standards region chain persistence
	 */
	public StandardsRegionChainPersistence getStandardsRegionChainPersistence() {
		return standardsRegionChainPersistence;
	}

	/**
	 * Sets the standards region chain persistence.
	 *
	 * @param standardsRegionChainPersistence the standards region chain persistence
	 */
	public void setStandardsRegionChainPersistence(
		StandardsRegionChainPersistence standardsRegionChainPersistence) {
		this.standardsRegionChainPersistence = standardsRegionChainPersistence;
	}

	/**
	 * Returns the standards region locale local service.
	 *
	 * @return the standards region locale local service
	 */
	public com.ihg.brandstandards.db.service.StandardsRegionLocaleLocalService getStandardsRegionLocaleLocalService() {
		return standardsRegionLocaleLocalService;
	}

	/**
	 * Sets the standards region locale local service.
	 *
	 * @param standardsRegionLocaleLocalService the standards region locale local service
	 */
	public void setStandardsRegionLocaleLocalService(
		com.ihg.brandstandards.db.service.StandardsRegionLocaleLocalService standardsRegionLocaleLocalService) {
		this.standardsRegionLocaleLocalService = standardsRegionLocaleLocalService;
	}

	/**
	 * Returns the standards region locale persistence.
	 *
	 * @return the standards region locale persistence
	 */
	public StandardsRegionLocalePersistence getStandardsRegionLocalePersistence() {
		return standardsRegionLocalePersistence;
	}

	/**
	 * Sets the standards region locale persistence.
	 *
	 * @param standardsRegionLocalePersistence the standards region locale persistence
	 */
	public void setStandardsRegionLocalePersistence(
		StandardsRegionLocalePersistence standardsRegionLocalePersistence) {
		this.standardsRegionLocalePersistence = standardsRegionLocalePersistence;
	}

	/**
	 * Returns the standards status local service.
	 *
	 * @return the standards status local service
	 */
	public com.ihg.brandstandards.db.service.StandardsStatusLocalService getStandardsStatusLocalService() {
		return standardsStatusLocalService;
	}

	/**
	 * Sets the standards status local service.
	 *
	 * @param standardsStatusLocalService the standards status local service
	 */
	public void setStandardsStatusLocalService(
		com.ihg.brandstandards.db.service.StandardsStatusLocalService standardsStatusLocalService) {
		this.standardsStatusLocalService = standardsStatusLocalService;
	}

	/**
	 * Returns the standards status persistence.
	 *
	 * @return the standards status persistence
	 */
	public StandardsStatusPersistence getStandardsStatusPersistence() {
		return standardsStatusPersistence;
	}

	/**
	 * Sets the standards status persistence.
	 *
	 * @param standardsStatusPersistence the standards status persistence
	 */
	public void setStandardsStatusPersistence(
		StandardsStatusPersistence standardsStatusPersistence) {
		this.standardsStatusPersistence = standardsStatusPersistence;
	}

	/**
	 * Returns the standards translate local service.
	 *
	 * @return the standards translate local service
	 */
	public com.ihg.brandstandards.db.service.StandardsTranslateLocalService getStandardsTranslateLocalService() {
		return standardsTranslateLocalService;
	}

	/**
	 * Sets the standards translate local service.
	 *
	 * @param standardsTranslateLocalService the standards translate local service
	 */
	public void setStandardsTranslateLocalService(
		com.ihg.brandstandards.db.service.StandardsTranslateLocalService standardsTranslateLocalService) {
		this.standardsTranslateLocalService = standardsTranslateLocalService;
	}

	/**
	 * Returns the standards translate persistence.
	 *
	 * @return the standards translate persistence
	 */
	public StandardsTranslatePersistence getStandardsTranslatePersistence() {
		return standardsTranslatePersistence;
	}

	/**
	 * Sets the standards translate persistence.
	 *
	 * @param standardsTranslatePersistence the standards translate persistence
	 */
	public void setStandardsTranslatePersistence(
		StandardsTranslatePersistence standardsTranslatePersistence) {
		this.standardsTranslatePersistence = standardsTranslatePersistence;
	}

	/**
	 * Returns the taxonomy local service.
	 *
	 * @return the taxonomy local service
	 */
	public com.ihg.brandstandards.db.service.TaxonomyLocalService getTaxonomyLocalService() {
		return taxonomyLocalService;
	}

	/**
	 * Sets the taxonomy local service.
	 *
	 * @param taxonomyLocalService the taxonomy local service
	 */
	public void setTaxonomyLocalService(
		com.ihg.brandstandards.db.service.TaxonomyLocalService taxonomyLocalService) {
		this.taxonomyLocalService = taxonomyLocalService;
	}

	/**
	 * Returns the taxonomy persistence.
	 *
	 * @return the taxonomy persistence
	 */
	public TaxonomyPersistence getTaxonomyPersistence() {
		return taxonomyPersistence;
	}

	/**
	 * Sets the taxonomy persistence.
	 *
	 * @param taxonomyPersistence the taxonomy persistence
	 */
	public void setTaxonomyPersistence(TaxonomyPersistence taxonomyPersistence) {
		this.taxonomyPersistence = taxonomyPersistence;
	}

	/**
	 * Returns the taxonomy finder.
	 *
	 * @return the taxonomy finder
	 */
	public TaxonomyFinder getTaxonomyFinder() {
		return taxonomyFinder;
	}

	/**
	 * Sets the taxonomy finder.
	 *
	 * @param taxonomyFinder the taxonomy finder
	 */
	public void setTaxonomyFinder(TaxonomyFinder taxonomyFinder) {
		this.taxonomyFinder = taxonomyFinder;
	}

	/**
	 * Returns the Custom Query mapping to create index path. local service.
	 *
	 * @return the Custom Query mapping to create index path. local service
	 */
	public com.ihg.brandstandards.db.service.TaxonomyExtLocalService getTaxonomyExtLocalService() {
		return taxonomyExtLocalService;
	}

	/**
	 * Sets the Custom Query mapping to create index path. local service.
	 *
	 * @param taxonomyExtLocalService the Custom Query mapping to create index path. local service
	 */
	public void setTaxonomyExtLocalService(
		com.ihg.brandstandards.db.service.TaxonomyExtLocalService taxonomyExtLocalService) {
		this.taxonomyExtLocalService = taxonomyExtLocalService;
	}

	/**
	 * Returns the Custom Query mapping to create index path. persistence.
	 *
	 * @return the Custom Query mapping to create index path. persistence
	 */
	public TaxonomyExtPersistence getTaxonomyExtPersistence() {
		return taxonomyExtPersistence;
	}

	/**
	 * Sets the Custom Query mapping to create index path. persistence.
	 *
	 * @param taxonomyExtPersistence the Custom Query mapping to create index path. persistence
	 */
	public void setTaxonomyExtPersistence(
		TaxonomyExtPersistence taxonomyExtPersistence) {
		this.taxonomyExtPersistence = taxonomyExtPersistence;
	}

	/**
	 * Returns the Custom Query mapping to create index path. finder.
	 *
	 * @return the Custom Query mapping to create index path. finder
	 */
	public TaxonomyExtFinder getTaxonomyExtFinder() {
		return taxonomyExtFinder;
	}

	/**
	 * Sets the Custom Query mapping to create index path. finder.
	 *
	 * @param taxonomyExtFinder the Custom Query mapping to create index path. finder
	 */
	public void setTaxonomyExtFinder(TaxonomyExtFinder taxonomyExtFinder) {
		this.taxonomyExtFinder = taxonomyExtFinder;
	}

	/**
	 * Returns the taxonomy standards local service.
	 *
	 * @return the taxonomy standards local service
	 */
	public com.ihg.brandstandards.db.service.TaxonomyStandardsLocalService getTaxonomyStandardsLocalService() {
		return taxonomyStandardsLocalService;
	}

	/**
	 * Sets the taxonomy standards local service.
	 *
	 * @param taxonomyStandardsLocalService the taxonomy standards local service
	 */
	public void setTaxonomyStandardsLocalService(
		com.ihg.brandstandards.db.service.TaxonomyStandardsLocalService taxonomyStandardsLocalService) {
		this.taxonomyStandardsLocalService = taxonomyStandardsLocalService;
	}

	/**
	 * Returns the taxonomy standards persistence.
	 *
	 * @return the taxonomy standards persistence
	 */
	public TaxonomyStandardsPersistence getTaxonomyStandardsPersistence() {
		return taxonomyStandardsPersistence;
	}

	/**
	 * Sets the taxonomy standards persistence.
	 *
	 * @param taxonomyStandardsPersistence the taxonomy standards persistence
	 */
	public void setTaxonomyStandardsPersistence(
		TaxonomyStandardsPersistence taxonomyStandardsPersistence) {
		this.taxonomyStandardsPersistence = taxonomyStandardsPersistence;
	}

	/**
	 * Returns the taxonomy translate local service.
	 *
	 * @return the taxonomy translate local service
	 */
	public com.ihg.brandstandards.db.service.TaxonomyTranslateLocalService getTaxonomyTranslateLocalService() {
		return taxonomyTranslateLocalService;
	}

	/**
	 * Sets the taxonomy translate local service.
	 *
	 * @param taxonomyTranslateLocalService the taxonomy translate local service
	 */
	public void setTaxonomyTranslateLocalService(
		com.ihg.brandstandards.db.service.TaxonomyTranslateLocalService taxonomyTranslateLocalService) {
		this.taxonomyTranslateLocalService = taxonomyTranslateLocalService;
	}

	/**
	 * Returns the taxonomy translate persistence.
	 *
	 * @return the taxonomy translate persistence
	 */
	public TaxonomyTranslatePersistence getTaxonomyTranslatePersistence() {
		return taxonomyTranslatePersistence;
	}

	/**
	 * Sets the taxonomy translate persistence.
	 *
	 * @param taxonomyTranslatePersistence the taxonomy translate persistence
	 */
	public void setTaxonomyTranslatePersistence(
		TaxonomyTranslatePersistence taxonomyTranslatePersistence) {
		this.taxonomyTranslatePersistence = taxonomyTranslatePersistence;
	}

	/**
	 * Returns the tree x m l local service.
	 *
	 * @return the tree x m l local service
	 */
	public com.ihg.brandstandards.db.service.TreeXMLLocalService getTreeXMLLocalService() {
		return treeXMLLocalService;
	}

	/**
	 * Sets the tree x m l local service.
	 *
	 * @param treeXMLLocalService the tree x m l local service
	 */
	public void setTreeXMLLocalService(
		com.ihg.brandstandards.db.service.TreeXMLLocalService treeXMLLocalService) {
		this.treeXMLLocalService = treeXMLLocalService;
	}

	/**
	 * Returns the tree x m l persistence.
	 *
	 * @return the tree x m l persistence
	 */
	public TreeXMLPersistence getTreeXMLPersistence() {
		return treeXMLPersistence;
	}

	/**
	 * Sets the tree x m l persistence.
	 *
	 * @param treeXMLPersistence the tree x m l persistence
	 */
	public void setTreeXMLPersistence(TreeXMLPersistence treeXMLPersistence) {
		this.treeXMLPersistence = treeXMLPersistence;
	}

	/**
	 * Returns the u i element local service.
	 *
	 * @return the u i element local service
	 */
	public com.ihg.brandstandards.db.service.UIElementLocalService getUIElementLocalService() {
		return uiElementLocalService;
	}

	/**
	 * Sets the u i element local service.
	 *
	 * @param uiElementLocalService the u i element local service
	 */
	public void setUIElementLocalService(
		com.ihg.brandstandards.db.service.UIElementLocalService uiElementLocalService) {
		this.uiElementLocalService = uiElementLocalService;
	}

	/**
	 * Returns the u i element persistence.
	 *
	 * @return the u i element persistence
	 */
	public UIElementPersistence getUIElementPersistence() {
		return uiElementPersistence;
	}

	/**
	 * Sets the u i element persistence.
	 *
	 * @param uiElementPersistence the u i element persistence
	 */
	public void setUIElementPersistence(
		UIElementPersistence uiElementPersistence) {
		this.uiElementPersistence = uiElementPersistence;
	}

	/**
	 * Returns the u i element finder.
	 *
	 * @return the u i element finder
	 */
	public UIElementFinder getUIElementFinder() {
		return uiElementFinder;
	}

	/**
	 * Sets the u i element finder.
	 *
	 * @param uiElementFinder the u i element finder
	 */
	public void setUIElementFinder(UIElementFinder uiElementFinder) {
		this.uiElementFinder = uiElementFinder;
	}

	/**
	 * Returns the u i element translate local service.
	 *
	 * @return the u i element translate local service
	 */
	public com.ihg.brandstandards.db.service.UIElementTranslateLocalService getUIElementTranslateLocalService() {
		return uiElementTranslateLocalService;
	}

	/**
	 * Sets the u i element translate local service.
	 *
	 * @param uiElementTranslateLocalService the u i element translate local service
	 */
	public void setUIElementTranslateLocalService(
		com.ihg.brandstandards.db.service.UIElementTranslateLocalService uiElementTranslateLocalService) {
		this.uiElementTranslateLocalService = uiElementTranslateLocalService;
	}

	/**
	 * Returns the u i element translate persistence.
	 *
	 * @return the u i element translate persistence
	 */
	public UIElementTranslatePersistence getUIElementTranslatePersistence() {
		return uiElementTranslatePersistence;
	}

	/**
	 * Sets the u i element translate persistence.
	 *
	 * @param uiElementTranslatePersistence the u i element translate persistence
	 */
	public void setUIElementTranslatePersistence(
		UIElementTranslatePersistence uiElementTranslatePersistence) {
		this.uiElementTranslatePersistence = uiElementTranslatePersistence;
	}

	/**
	 * Returns the unique group local service.
	 *
	 * @return the unique group local service
	 */
	public com.ihg.brandstandards.db.service.UniqueGroupLocalService getUniqueGroupLocalService() {
		return uniqueGroupLocalService;
	}

	/**
	 * Sets the unique group local service.
	 *
	 * @param uniqueGroupLocalService the unique group local service
	 */
	public void setUniqueGroupLocalService(
		com.ihg.brandstandards.db.service.UniqueGroupLocalService uniqueGroupLocalService) {
		this.uniqueGroupLocalService = uniqueGroupLocalService;
	}

	/**
	 * Returns the unique group persistence.
	 *
	 * @return the unique group persistence
	 */
	public UniqueGroupPersistence getUniqueGroupPersistence() {
		return uniqueGroupPersistence;
	}

	/**
	 * Sets the unique group persistence.
	 *
	 * @param uniqueGroupPersistence the unique group persistence
	 */
	public void setUniqueGroupPersistence(
		UniqueGroupPersistence uniqueGroupPersistence) {
		this.uniqueGroupPersistence = uniqueGroupPersistence;
	}

	/**
	 * Returns the unique group finder.
	 *
	 * @return the unique group finder
	 */
	public UniqueGroupFinder getUniqueGroupFinder() {
		return uniqueGroupFinder;
	}

	/**
	 * Sets the unique group finder.
	 *
	 * @param uniqueGroupFinder the unique group finder
	 */
	public void setUniqueGroupFinder(UniqueGroupFinder uniqueGroupFinder) {
		this.uniqueGroupFinder = uniqueGroupFinder;
	}

	/**
	 * Returns the unique group country local service.
	 *
	 * @return the unique group country local service
	 */
	public com.ihg.brandstandards.db.service.UniqueGroupCountryLocalService getUniqueGroupCountryLocalService() {
		return uniqueGroupCountryLocalService;
	}

	/**
	 * Sets the unique group country local service.
	 *
	 * @param uniqueGroupCountryLocalService the unique group country local service
	 */
	public void setUniqueGroupCountryLocalService(
		com.ihg.brandstandards.db.service.UniqueGroupCountryLocalService uniqueGroupCountryLocalService) {
		this.uniqueGroupCountryLocalService = uniqueGroupCountryLocalService;
	}

	/**
	 * Returns the unique group country persistence.
	 *
	 * @return the unique group country persistence
	 */
	public UniqueGroupCountryPersistence getUniqueGroupCountryPersistence() {
		return uniqueGroupCountryPersistence;
	}

	/**
	 * Sets the unique group country persistence.
	 *
	 * @param uniqueGroupCountryPersistence the unique group country persistence
	 */
	public void setUniqueGroupCountryPersistence(
		UniqueGroupCountryPersistence uniqueGroupCountryPersistence) {
		this.uniqueGroupCountryPersistence = uniqueGroupCountryPersistence;
	}

	/**
	 * Returns the unique group country finder.
	 *
	 * @return the unique group country finder
	 */
	public UniqueGroupCountryFinder getUniqueGroupCountryFinder() {
		return uniqueGroupCountryFinder;
	}

	/**
	 * Sets the unique group country finder.
	 *
	 * @param uniqueGroupCountryFinder the unique group country finder
	 */
	public void setUniqueGroupCountryFinder(
		UniqueGroupCountryFinder uniqueGroupCountryFinder) {
		this.uniqueGroupCountryFinder = uniqueGroupCountryFinder;
	}

	/**
	 * Returns the unique group standard local service.
	 *
	 * @return the unique group standard local service
	 */
	public com.ihg.brandstandards.db.service.UniqueGroupStandardLocalService getUniqueGroupStandardLocalService() {
		return uniqueGroupStandardLocalService;
	}

	/**
	 * Sets the unique group standard local service.
	 *
	 * @param uniqueGroupStandardLocalService the unique group standard local service
	 */
	public void setUniqueGroupStandardLocalService(
		com.ihg.brandstandards.db.service.UniqueGroupStandardLocalService uniqueGroupStandardLocalService) {
		this.uniqueGroupStandardLocalService = uniqueGroupStandardLocalService;
	}

	/**
	 * Returns the unique group standard persistence.
	 *
	 * @return the unique group standard persistence
	 */
	public UniqueGroupStandardPersistence getUniqueGroupStandardPersistence() {
		return uniqueGroupStandardPersistence;
	}

	/**
	 * Sets the unique group standard persistence.
	 *
	 * @param uniqueGroupStandardPersistence the unique group standard persistence
	 */
	public void setUniqueGroupStandardPersistence(
		UniqueGroupStandardPersistence uniqueGroupStandardPersistence) {
		this.uniqueGroupStandardPersistence = uniqueGroupStandardPersistence;
	}

	/**
	 * Returns the user preference local service.
	 *
	 * @return the user preference local service
	 */
	public com.ihg.brandstandards.db.service.UserPreferenceLocalService getUserPreferenceLocalService() {
		return userPreferenceLocalService;
	}

	/**
	 * Sets the user preference local service.
	 *
	 * @param userPreferenceLocalService the user preference local service
	 */
	public void setUserPreferenceLocalService(
		com.ihg.brandstandards.db.service.UserPreferenceLocalService userPreferenceLocalService) {
		this.userPreferenceLocalService = userPreferenceLocalService;
	}

	/**
	 * Returns the user preference persistence.
	 *
	 * @return the user preference persistence
	 */
	public UserPreferencePersistence getUserPreferencePersistence() {
		return userPreferencePersistence;
	}

	/**
	 * Sets the user preference persistence.
	 *
	 * @param userPreferencePersistence the user preference persistence
	 */
	public void setUserPreferencePersistence(
		UserPreferencePersistence userPreferencePersistence) {
		this.userPreferencePersistence = userPreferencePersistence;
	}

	/**
	 * Returns the user preference finder.
	 *
	 * @return the user preference finder
	 */
	public UserPreferenceFinder getUserPreferenceFinder() {
		return userPreferenceFinder;
	}

	/**
	 * Sets the user preference finder.
	 *
	 * @param userPreferenceFinder the user preference finder
	 */
	public void setUserPreferenceFinder(
		UserPreferenceFinder userPreferenceFinder) {
		this.userPreferenceFinder = userPreferenceFinder;
	}

	/**
	 * Returns the user search criteria local service.
	 *
	 * @return the user search criteria local service
	 */
	public com.ihg.brandstandards.db.service.UserSearchCriteriaLocalService getUserSearchCriteriaLocalService() {
		return userSearchCriteriaLocalService;
	}

	/**
	 * Sets the user search criteria local service.
	 *
	 * @param userSearchCriteriaLocalService the user search criteria local service
	 */
	public void setUserSearchCriteriaLocalService(
		com.ihg.brandstandards.db.service.UserSearchCriteriaLocalService userSearchCriteriaLocalService) {
		this.userSearchCriteriaLocalService = userSearchCriteriaLocalService;
	}

	/**
	 * Returns the user search criteria persistence.
	 *
	 * @return the user search criteria persistence
	 */
	public UserSearchCriteriaPersistence getUserSearchCriteriaPersistence() {
		return userSearchCriteriaPersistence;
	}

	/**
	 * Sets the user search criteria persistence.
	 *
	 * @param userSearchCriteriaPersistence the user search criteria persistence
	 */
	public void setUserSearchCriteriaPersistence(
		UserSearchCriteriaPersistence userSearchCriteriaPersistence) {
		this.userSearchCriteriaPersistence = userSearchCriteriaPersistence;
	}

	/**
	 * Returns the workflow local service.
	 *
	 * @return the workflow local service
	 */
	public com.ihg.brandstandards.db.service.WorkflowLocalService getWorkflowLocalService() {
		return workflowLocalService;
	}

	/**
	 * Sets the workflow local service.
	 *
	 * @param workflowLocalService the workflow local service
	 */
	public void setWorkflowLocalService(
		com.ihg.brandstandards.db.service.WorkflowLocalService workflowLocalService) {
		this.workflowLocalService = workflowLocalService;
	}

	/**
	 * Returns the workflow persistence.
	 *
	 * @return the workflow persistence
	 */
	public WorkflowPersistence getWorkflowPersistence() {
		return workflowPersistence;
	}

	/**
	 * Sets the workflow persistence.
	 *
	 * @param workflowPersistence the workflow persistence
	 */
	public void setWorkflowPersistence(WorkflowPersistence workflowPersistence) {
		this.workflowPersistence = workflowPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.ihg.brandstandards.db.model.StandardsCountryChain",
			standardsCountryChainLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.ihg.brandstandards.db.model.StandardsCountryChain");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return StandardsCountryChain.class;
	}

	protected String getModelClassName() {
		return StandardsCountryChain.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = standardsCountryChainPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.ihg.brandstandards.db.service.AttachmentsStandardsLocalService.class)
	protected com.ihg.brandstandards.db.service.AttachmentsStandardsLocalService attachmentsStandardsLocalService;
	@BeanReference(type = AttachmentsStandardsPersistence.class)
	protected AttachmentsStandardsPersistence attachmentsStandardsPersistence;
	@BeanReference(type = AttachmentsStandardsFinder.class)
	protected AttachmentsStandardsFinder attachmentsStandardsFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.AttachmentsStandardsCountryLocalService.class)
	protected com.ihg.brandstandards.db.service.AttachmentsStandardsCountryLocalService attachmentsStandardsCountryLocalService;
	@BeanReference(type = AttachmentsStandardsCountryPersistence.class)
	protected AttachmentsStandardsCountryPersistence attachmentsStandardsCountryPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.BrandArticleLocalService.class)
	protected com.ihg.brandstandards.db.service.BrandArticleLocalService brandArticleLocalService;
	@BeanReference(type = BrandArticleFinder.class)
	protected BrandArticleFinder brandArticleFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.BrandTaxonomyLocalService.class)
	protected com.ihg.brandstandards.db.service.BrandTaxonomyLocalService brandTaxonomyLocalService;
	@BeanReference(type = BrandTaxonomyPersistence.class)
	protected BrandTaxonomyPersistence brandTaxonomyPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.BrandTaxonomyTranslateLocalService.class)
	protected com.ihg.brandstandards.db.service.BrandTaxonomyTranslateLocalService brandTaxonomyTranslateLocalService;
	@BeanReference(type = BrandTaxonomyTranslatePersistence.class)
	protected BrandTaxonomyTranslatePersistence brandTaxonomyTranslatePersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.BridgeGlobalPublishLocalService.class)
	protected com.ihg.brandstandards.db.service.BridgeGlobalPublishLocalService bridgeGlobalPublishLocalService;
	@BeanReference(type = BridgeGlobalPublishPersistence.class)
	protected BridgeGlobalPublishPersistence bridgeGlobalPublishPersistence;
	@BeanReference(type = BridgeGlobalPublishFinder.class)
	protected BridgeGlobalPublishFinder bridgeGlobalPublishFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.BridgeGlobalPublishCountryLocalService.class)
	protected com.ihg.brandstandards.db.service.BridgeGlobalPublishCountryLocalService bridgeGlobalPublishCountryLocalService;
	@BeanReference(type = BridgeGlobalPublishCountryPersistence.class)
	protected BridgeGlobalPublishCountryPersistence bridgeGlobalPublishCountryPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.BridgePublishLocalService.class)
	protected com.ihg.brandstandards.db.service.BridgePublishLocalService bridgePublishLocalService;
	@BeanReference(type = BridgePublishPersistence.class)
	protected BridgePublishPersistence bridgePublishPersistence;
	@BeanReference(type = BridgePublishFinder.class)
	protected BridgePublishFinder bridgePublishFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.BridgePublishCountryLocalService.class)
	protected com.ihg.brandstandards.db.service.BridgePublishCountryLocalService bridgePublishCountryLocalService;
	@BeanReference(type = BridgePublishCountryPersistence.class)
	protected BridgePublishCountryPersistence bridgePublishCountryPersistence;
	@BeanReference(type = BridgePublishCountryFinder.class)
	protected BridgePublishCountryFinder bridgePublishCountryFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.BridgePublishCountryStateExLocalService.class)
	protected com.ihg.brandstandards.db.service.BridgePublishCountryStateExLocalService bridgePublishCountryStateExLocalService;
	@BeanReference(type = BridgePublishCountryStateExPersistence.class)
	protected BridgePublishCountryStateExPersistence bridgePublishCountryStateExPersistence;
	@BeanReference(type = BridgePublishCountryStateExFinder.class)
	protected BridgePublishCountryStateExFinder bridgePublishCountryStateExFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.BridgePublishImportLocalService.class)
	protected com.ihg.brandstandards.db.service.BridgePublishImportLocalService bridgePublishImportLocalService;
	@BeanReference(type = BridgePublishImportPersistence.class)
	protected BridgePublishImportPersistence bridgePublishImportPersistence;
	@BeanReference(type = BridgePublishImportFinder.class)
	protected BridgePublishImportFinder bridgePublishImportFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.BridgePublishLangLocalService.class)
	protected com.ihg.brandstandards.db.service.BridgePublishLangLocalService bridgePublishLangLocalService;
	@BeanReference(type = BridgePublishLangPersistence.class)
	protected BridgePublishLangPersistence bridgePublishLangPersistence;
	@BeanReference(type = BridgePublishLangFinder.class)
	protected BridgePublishLangFinder bridgePublishLangFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.BridgePublishPreviewLocalService.class)
	protected com.ihg.brandstandards.db.service.BridgePublishPreviewLocalService bridgePublishPreviewLocalService;
	@BeanReference(type = BridgePublishPreviewPersistence.class)
	protected BridgePublishPreviewPersistence bridgePublishPreviewPersistence;
	@BeanReference(type = BridgePublishPreviewFinder.class)
	protected BridgePublishPreviewFinder bridgePublishPreviewFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.BridgePublishStateExLocalService.class)
	protected com.ihg.brandstandards.db.service.BridgePublishStateExLocalService bridgePublishStateExLocalService;
	@BeanReference(type = BridgePublishStateExPersistence.class)
	protected BridgePublishStateExPersistence bridgePublishStateExPersistence;
	@BeanReference(type = BridgePublishStateExFinder.class)
	protected BridgePublishStateExFinder bridgePublishStateExFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.BridgePublishStatusLocalService.class)
	protected com.ihg.brandstandards.db.service.BridgePublishStatusLocalService bridgePublishStatusLocalService;
	@BeanReference(type = BridgePublishStatusPersistence.class)
	protected BridgePublishStatusPersistence bridgePublishStatusPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.BusImpactAssmtLocalService.class)
	protected com.ihg.brandstandards.db.service.BusImpactAssmtLocalService busImpactAssmtLocalService;
	@BeanReference(type = BusImpactAssmtPersistence.class)
	protected BusImpactAssmtPersistence busImpactAssmtPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.ChainAttachmentsStandardsLocalService.class)
	protected com.ihg.brandstandards.db.service.ChainAttachmentsStandardsLocalService chainAttachmentsStandardsLocalService;
	@BeanReference(type = ChainAttachmentsStandardsPersistence.class)
	protected ChainAttachmentsStandardsPersistence chainAttachmentsStandardsPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.ChainExternalLinkStandardsLocalService.class)
	protected com.ihg.brandstandards.db.service.ChainExternalLinkStandardsLocalService chainExternalLinkStandardsLocalService;
	@BeanReference(type = ChainExternalLinkStandardsPersistence.class)
	protected ChainExternalLinkStandardsPersistence chainExternalLinkStandardsPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.ChainStandardsLocalService.class)
	protected com.ihg.brandstandards.db.service.ChainStandardsLocalService chainStandardsLocalService;
	@BeanReference(type = ChainStandardsPersistence.class)
	protected ChainStandardsPersistence chainStandardsPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.CountryStandardsLocalService.class)
	protected com.ihg.brandstandards.db.service.CountryStandardsLocalService countryStandardsLocalService;
	@BeanReference(type = CountryStandardsPersistence.class)
	protected CountryStandardsPersistence countryStandardsPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.CountryStandardsExtLocalService.class)
	protected com.ihg.brandstandards.db.service.CountryStandardsExtLocalService countryStandardsExtLocalService;
	@BeanReference(type = CountryStandardsExtPersistence.class)
	protected CountryStandardsExtPersistence countryStandardsExtPersistence;
	@BeanReference(type = CountryStandardsExtFinder.class)
	protected CountryStandardsExtFinder countryStandardsExtFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.DepartmentLocalService.class)
	protected com.ihg.brandstandards.db.service.DepartmentLocalService departmentLocalService;
	@BeanReference(type = DepartmentPersistence.class)
	protected DepartmentPersistence departmentPersistence;
	@BeanReference(type = DepartmentFinder.class)
	protected DepartmentFinder departmentFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.ErrNotificationLocalService.class)
	protected com.ihg.brandstandards.db.service.ErrNotificationLocalService errNotificationLocalService;
	@BeanReference(type = ErrNotificationPersistence.class)
	protected ErrNotificationPersistence errNotificationPersistence;
	@BeanReference(type = ErrNotificationFinder.class)
	protected ErrNotificationFinder errNotificationFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.ExternalLinkStandardsLocalService.class)
	protected com.ihg.brandstandards.db.service.ExternalLinkStandardsLocalService externalLinkStandardsLocalService;
	@BeanReference(type = ExternalLinkStandardsPersistence.class)
	protected ExternalLinkStandardsPersistence externalLinkStandardsPersistence;
	@BeanReference(type = ExternalLinkStandardsFinder.class)
	protected ExternalLinkStandardsFinder externalLinkStandardsFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.ExternalLinkStandardsCountryLocalService.class)
	protected com.ihg.brandstandards.db.service.ExternalLinkStandardsCountryLocalService externalLinkStandardsCountryLocalService;
	@BeanReference(type = ExternalLinkStandardsCountryPersistence.class)
	protected ExternalLinkStandardsCountryPersistence externalLinkStandardsCountryPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.FlagCategoryLocalService.class)
	protected com.ihg.brandstandards.db.service.FlagCategoryLocalService flagCategoryLocalService;
	@BeanReference(type = FlagCategoryPersistence.class)
	protected FlagCategoryPersistence flagCategoryPersistence;
	@BeanReference(type = FlagCategoryFinder.class)
	protected FlagCategoryFinder flagCategoryFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.FlagStandardsLocalService.class)
	protected com.ihg.brandstandards.db.service.FlagStandardsLocalService flagStandardsLocalService;
	@BeanReference(type = FlagStandardsPersistence.class)
	protected FlagStandardsPersistence flagStandardsPersistence;
	@BeanReference(type = FlagStandardsFinder.class)
	protected FlagStandardsFinder flagStandardsFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.GEMCategoryLocalService.class)
	protected com.ihg.brandstandards.db.service.GEMCategoryLocalService gemCategoryLocalService;
	@BeanReference(type = GEMCategoryPersistence.class)
	protected GEMCategoryPersistence gemCategoryPersistence;
	@BeanReference(type = GEMCategoryFinder.class)
	protected GEMCategoryFinder gemCategoryFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.GEMChainMeasurementLocalService.class)
	protected com.ihg.brandstandards.db.service.GEMChainMeasurementLocalService gemChainMeasurementLocalService;
	@BeanReference(type = GEMChainMeasurementPersistence.class)
	protected GEMChainMeasurementPersistence gemChainMeasurementPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.GEMCodeLocalService.class)
	protected com.ihg.brandstandards.db.service.GEMCodeLocalService gemCodeLocalService;
	@BeanReference(type = GEMCodePersistence.class)
	protected GEMCodePersistence gemCodePersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.GEMGeneratedReportLocalService.class)
	protected com.ihg.brandstandards.db.service.GEMGeneratedReportLocalService gemGeneratedReportLocalService;
	@BeanReference(type = GEMGeneratedReportPersistence.class)
	protected GEMGeneratedReportPersistence gemGeneratedReportPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.GEMGeneratedReportValLocalService.class)
	protected com.ihg.brandstandards.db.service.GEMGeneratedReportValLocalService gemGeneratedReportValLocalService;
	@BeanReference(type = GEMGeneratedReportValPersistence.class)
	protected GEMGeneratedReportValPersistence gemGeneratedReportValPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.GEMManagementBucketLocalService.class)
	protected com.ihg.brandstandards.db.service.GEMManagementBucketLocalService gemManagementBucketLocalService;
	@BeanReference(type = GEMManagementBucketPersistence.class)
	protected GEMManagementBucketPersistence gemManagementBucketPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.GEMManagementIdLocalService.class)
	protected com.ihg.brandstandards.db.service.GEMManagementIdLocalService gemManagementIdLocalService;
	@BeanReference(type = GEMManagementIdPersistence.class)
	protected GEMManagementIdPersistence gemManagementIdPersistence;
	@BeanReference(type = GEMManagementIdFinder.class)
	protected GEMManagementIdFinder gemManagementIdFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.GEMMeasurementLocalService.class)
	protected com.ihg.brandstandards.db.service.GEMMeasurementLocalService gemMeasurementLocalService;
	@BeanReference(type = GEMMeasurementPersistence.class)
	protected GEMMeasurementPersistence gemMeasurementPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.GEMMeasurementBucketChainLocalService.class)
	protected com.ihg.brandstandards.db.service.GEMMeasurementBucketChainLocalService gemMeasurementBucketChainLocalService;
	@BeanReference(type = GEMMeasurementBucketChainPersistence.class)
	protected GEMMeasurementBucketChainPersistence gemMeasurementBucketChainPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.GEMMeasurementFormulaLocalService.class)
	protected com.ihg.brandstandards.db.service.GEMMeasurementFormulaLocalService gemMeasurementFormulaLocalService;
	@BeanReference(type = GEMMeasurementFormulaPersistence.class)
	protected GEMMeasurementFormulaPersistence gemMeasurementFormulaPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.GEMMeasurementFormulaValueLocalService.class)
	protected com.ihg.brandstandards.db.service.GEMMeasurementFormulaValueLocalService gemMeasurementFormulaValueLocalService;
	@BeanReference(type = GEMMeasurementFormulaValuePersistence.class)
	protected GEMMeasurementFormulaValuePersistence gemMeasurementFormulaValuePersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.GEMMeasurementTypeLocalService.class)
	protected com.ihg.brandstandards.db.service.GEMMeasurementTypeLocalService gemMeasurementTypeLocalService;
	@BeanReference(type = GEMMeasurementTypePersistence.class)
	protected GEMMeasurementTypePersistence gemMeasurementTypePersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.GEMQlReportLocalService.class)
	protected com.ihg.brandstandards.db.service.GEMQlReportLocalService gemQlReportLocalService;
	@BeanReference(type = GEMQlReportPersistence.class)
	protected GEMQlReportPersistence gemQlReportPersistence;
	@BeanReference(type = GEMQlReportFinder.class)
	protected GEMQlReportFinder gemQlReportFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.GEMRoleLocalService.class)
	protected com.ihg.brandstandards.db.service.GEMRoleLocalService gemRoleLocalService;
	@BeanReference(type = GEMRolePersistence.class)
	protected GEMRolePersistence gemRolePersistence;
	@BeanReference(type = GEMRoleFinder.class)
	protected GEMRoleFinder gemRoleFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.GEMScoringValueLocalService.class)
	protected com.ihg.brandstandards.db.service.GEMScoringValueLocalService gemScoringValueLocalService;
	@BeanReference(type = GEMScoringValuePersistence.class)
	protected GEMScoringValuePersistence gemScoringValuePersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.GEMSeverityLocalService.class)
	protected com.ihg.brandstandards.db.service.GEMSeverityLocalService gemSeverityLocalService;
	@BeanReference(type = GEMSeverityPersistence.class)
	protected GEMSeverityPersistence gemSeverityPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.GEMStdCategoryLocalService.class)
	protected com.ihg.brandstandards.db.service.GEMStdCategoryLocalService gemStdCategoryLocalService;
	@BeanReference(type = GEMStdCategoryPersistence.class)
	protected GEMStdCategoryPersistence gemStdCategoryPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.GEMTemplateLocalService.class)
	protected com.ihg.brandstandards.db.service.GEMTemplateLocalService gemTemplateLocalService;
	@BeanReference(type = GEMTemplatePersistence.class)
	protected GEMTemplatePersistence gemTemplatePersistence;
	@BeanReference(type = GEMTemplateFinder.class)
	protected GEMTemplateFinder gemTemplateFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.GEMTemplateCategoryLocalService.class)
	protected com.ihg.brandstandards.db.service.GEMTemplateCategoryLocalService gemTemplateCategoryLocalService;
	@BeanReference(type = GEMTemplateCategoryPersistence.class)
	protected GEMTemplateCategoryPersistence gemTemplateCategoryPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.GEMTemplateColumnLocalService.class)
	protected com.ihg.brandstandards.db.service.GEMTemplateColumnLocalService gemTemplateColumnLocalService;
	@BeanReference(type = GEMTemplateColumnPersistence.class)
	protected GEMTemplateColumnPersistence gemTemplateColumnPersistence;
	@BeanReference(type = GEMTemplateColumnFinder.class)
	protected GEMTemplateColumnFinder gemTemplateColumnFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.GEMTemplateReferenceLocalService.class)
	protected com.ihg.brandstandards.db.service.GEMTemplateReferenceLocalService gemTemplateReferenceLocalService;
	@BeanReference(type = GEMTemplateReferencePersistence.class)
	protected GEMTemplateReferencePersistence gemTemplateReferencePersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.GEMTemplateValuesLocalService.class)
	protected com.ihg.brandstandards.db.service.GEMTemplateValuesLocalService gemTemplateValuesLocalService;
	@BeanReference(type = GEMTemplateValuesPersistence.class)
	protected GEMTemplateValuesPersistence gemTemplateValuesPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.GEMTriggerLocalService.class)
	protected com.ihg.brandstandards.db.service.GEMTriggerLocalService gemTriggerLocalService;
	@BeanReference(type = GEMTriggerPersistence.class)
	protected GEMTriggerPersistence gemTriggerPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.GEMUniqueGroupLocalService.class)
	protected com.ihg.brandstandards.db.service.GEMUniqueGroupLocalService gemUniqueGroupLocalService;
	@BeanReference(type = GEMUniqueGroupPersistence.class)
	protected GEMUniqueGroupPersistence gemUniqueGroupPersistence;
	@BeanReference(type = GEMUniqueGroupFinder.class)
	protected GEMUniqueGroupFinder gemUniqueGroupFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.GEMUniqueGroupCountryLocalService.class)
	protected com.ihg.brandstandards.db.service.GEMUniqueGroupCountryLocalService gemUniqueGroupCountryLocalService;
	@BeanReference(type = GEMUniqueGroupCountryPersistence.class)
	protected GEMUniqueGroupCountryPersistence gemUniqueGroupCountryPersistence;
	@BeanReference(type = GEMUniqueGroupCountryFinder.class)
	protected GEMUniqueGroupCountryFinder gemUniqueGroupCountryFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.GEMUniqueGroupStandardLocalService.class)
	protected com.ihg.brandstandards.db.service.GEMUniqueGroupStandardLocalService gemUniqueGroupStandardLocalService;
	@BeanReference(type = GEMUniqueGroupStandardPersistence.class)
	protected GEMUniqueGroupStandardPersistence gemUniqueGroupStandardPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.GlossaryLocalService.class)
	protected com.ihg.brandstandards.db.service.GlossaryLocalService glossaryLocalService;
	@BeanReference(type = GlossaryPersistence.class)
	protected GlossaryPersistence glossaryPersistence;
	@BeanReference(type = GlossaryFinder.class)
	protected GlossaryFinder glossaryFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.GlossaryExtLocalService.class)
	protected com.ihg.brandstandards.db.service.GlossaryExtLocalService glossaryExtLocalService;
	@BeanReference(type = GlossaryExtPersistence.class)
	protected GlossaryExtPersistence glossaryExtPersistence;
	@BeanReference(type = GlossaryExtFinder.class)
	protected GlossaryExtFinder glossaryExtFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.GlossaryRegionNavLocalService.class)
	protected com.ihg.brandstandards.db.service.GlossaryRegionNavLocalService glossaryRegionNavLocalService;
	@BeanReference(type = GlossaryRegionNavPersistence.class)
	protected GlossaryRegionNavPersistence glossaryRegionNavPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.GlossaryTranslateLocalService.class)
	protected com.ihg.brandstandards.db.service.GlossaryTranslateLocalService glossaryTranslateLocalService;
	@BeanReference(type = GlossaryTranslatePersistence.class)
	protected GlossaryTranslatePersistence glossaryTranslatePersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.HistManualAttachmentLocalService.class)
	protected com.ihg.brandstandards.db.service.HistManualAttachmentLocalService histManualAttachmentLocalService;
	@BeanReference(type = HistManualAttachmentPersistence.class)
	protected HistManualAttachmentPersistence histManualAttachmentPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.HistManualChainLocalService.class)
	protected com.ihg.brandstandards.db.service.HistManualChainLocalService histManualChainLocalService;
	@BeanReference(type = HistManualChainPersistence.class)
	protected HistManualChainPersistence histManualChainPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.HistManualRegionLocalService.class)
	protected com.ihg.brandstandards.db.service.HistManualRegionLocalService histManualRegionLocalService;
	@BeanReference(type = HistManualRegionPersistence.class)
	protected HistManualRegionPersistence histManualRegionPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.HistManualsLocalService.class)
	protected com.ihg.brandstandards.db.service.HistManualsLocalService histManualsLocalService;
	@BeanReference(type = HistManualsPersistence.class)
	protected HistManualsPersistence histManualsPersistence;
	@BeanReference(type = HistManualsFinder.class)
	protected HistManualsFinder histManualsFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.ImageLocalService.class)
	protected com.ihg.brandstandards.db.service.ImageLocalService imageLocalService;
	@BeanReference(type = ImagePersistence.class)
	protected ImagePersistence imagePersistence;
	@BeanReference(type = ImageFinder.class)
	protected ImageFinder imageFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.JobQueueLocalService.class)
	protected com.ihg.brandstandards.db.service.JobQueueLocalService jobQueueLocalService;
	@BeanReference(type = com.ihg.brandstandards.db.service.JobQueueService.class)
	protected com.ihg.brandstandards.db.service.JobQueueService jobQueueService;
	@BeanReference(type = JobQueuePersistence.class)
	protected JobQueuePersistence jobQueuePersistence;
	@BeanReference(type = JobQueueFinder.class)
	protected JobQueueFinder jobQueueFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.MustPublishLocalService.class)
	protected com.ihg.brandstandards.db.service.MustPublishLocalService mustPublishLocalService;
	@BeanReference(type = MustPublishPersistence.class)
	protected MustPublishPersistence mustPublishPersistence;
	@BeanReference(type = MustPublishFinder.class)
	protected MustPublishFinder mustPublishFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.PublicationLocalService.class)
	protected com.ihg.brandstandards.db.service.PublicationLocalService publicationLocalService;
	@BeanReference(type = PublicationPersistence.class)
	protected PublicationPersistence publicationPersistence;
	@BeanReference(type = PublicationFinder.class)
	protected PublicationFinder publicationFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.PublishCountryStandardLocalService.class)
	protected com.ihg.brandstandards.db.service.PublishCountryStandardLocalService publishCountryStandardLocalService;
	@BeanReference(type = PublishCountryStandardPersistence.class)
	protected PublishCountryStandardPersistence publishCountryStandardPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.PublishDeptLocalService.class)
	protected com.ihg.brandstandards.db.service.PublishDeptLocalService publishDeptLocalService;
	@BeanReference(type = PublishDeptPersistence.class)
	protected PublishDeptPersistence publishDeptPersistence;
	@BeanReference(type = PublishDeptFinder.class)
	protected PublishDeptFinder publishDeptFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.PublishedPdfListLocalService.class)
	protected com.ihg.brandstandards.db.service.PublishedPdfListLocalService publishedPdfListLocalService;
	@BeanReference(type = PublishedPdfListPersistence.class)
	protected PublishedPdfListPersistence publishedPdfListPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.PublishExtStdLocalService.class)
	protected com.ihg.brandstandards.db.service.PublishExtStdLocalService publishExtStdLocalService;
	@BeanReference(type = PublishExtStdPersistence.class)
	protected PublishExtStdPersistence publishExtStdPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.PublishParmLocalService.class)
	protected com.ihg.brandstandards.db.service.PublishParmLocalService publishParmLocalService;
	@BeanReference(type = PublishParmPersistence.class)
	protected PublishParmPersistence publishParmPersistence;
	@BeanReference(type = PublishParmFinder.class)
	protected PublishParmFinder publishParmFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.PublishQueueLocalService.class)
	protected com.ihg.brandstandards.db.service.PublishQueueLocalService publishQueueLocalService;
	@BeanReference(type = PublishQueuePersistence.class)
	protected PublishQueuePersistence publishQueuePersistence;
	@BeanReference(type = PublishQueueFinder.class)
	protected PublishQueueFinder publishQueueFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.PublishStandardsExtLocalService.class)
	protected com.ihg.brandstandards.db.service.PublishStandardsExtLocalService publishStandardsExtLocalService;
	@BeanReference(type = PublishStandardsExtPersistence.class)
	protected PublishStandardsExtPersistence publishStandardsExtPersistence;
	@BeanReference(type = PublishStandardsExtFinder.class)
	protected PublishStandardsExtFinder publishStandardsExtFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.PublishStdLocalService.class)
	protected com.ihg.brandstandards.db.service.PublishStdLocalService publishStdLocalService;
	@BeanReference(type = PublishStdPersistence.class)
	protected PublishStdPersistence publishStdPersistence;
	@BeanReference(type = PublishStdFinder.class)
	protected PublishStdFinder publishStdFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.PublishTaxonomyLocalService.class)
	protected com.ihg.brandstandards.db.service.PublishTaxonomyLocalService publishTaxonomyLocalService;
	@BeanReference(type = PublishTaxonomyPersistence.class)
	protected PublishTaxonomyPersistence publishTaxonomyPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.PublishTaxonomyExtLocalService.class)
	protected com.ihg.brandstandards.db.service.PublishTaxonomyExtLocalService publishTaxonomyExtLocalService;
	@BeanReference(type = PublishTaxonomyExtPersistence.class)
	protected PublishTaxonomyExtPersistence publishTaxonomyExtPersistence;
	@BeanReference(type = PublishTaxonomyExtFinder.class)
	protected PublishTaxonomyExtFinder publishTaxonomyExtFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.SpecialWordDictionaryLocalService.class)
	protected com.ihg.brandstandards.db.service.SpecialWordDictionaryLocalService specialWordDictionaryLocalService;
	@BeanReference(type = SpecialWordDictionaryPersistence.class)
	protected SpecialWordDictionaryPersistence specialWordDictionaryPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.SpreadSheetAttributeUpdateLocalService.class)
	protected com.ihg.brandstandards.db.service.SpreadSheetAttributeUpdateLocalService spreadSheetAttributeUpdateLocalService;
	@BeanReference(type = SpreadSheetAttributeUpdatePersistence.class)
	protected SpreadSheetAttributeUpdatePersistence spreadSheetAttributeUpdatePersistence;
	@BeanReference(type = SpreadSheetAttributeUpdateFinder.class)
	protected SpreadSheetAttributeUpdateFinder spreadSheetAttributeUpdateFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.StandardsLocalService.class)
	protected com.ihg.brandstandards.db.service.StandardsLocalService standardsLocalService;
	@BeanReference(type = StandardsPersistence.class)
	protected StandardsPersistence standardsPersistence;
	@BeanReference(type = StandardsFinder.class)
	protected StandardsFinder standardsFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.StandardsAuthorsLocalService.class)
	protected com.ihg.brandstandards.db.service.StandardsAuthorsLocalService standardsAuthorsLocalService;
	@BeanReference(type = StandardsAuthorsPersistence.class)
	protected StandardsAuthorsPersistence standardsAuthorsPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.StandardsChainImagesLocalService.class)
	protected com.ihg.brandstandards.db.service.StandardsChainImagesLocalService standardsChainImagesLocalService;
	@BeanReference(type = StandardsChainImagesPersistence.class)
	protected StandardsChainImagesPersistence standardsChainImagesPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.StandardsComplianceLocalService.class)
	protected com.ihg.brandstandards.db.service.StandardsComplianceLocalService standardsComplianceLocalService;
	@BeanReference(type = StandardsCompliancePersistence.class)
	protected StandardsCompliancePersistence standardsCompliancePersistence;
	@BeanReference(type = StandardsComplianceFinder.class)
	protected StandardsComplianceFinder standardsComplianceFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.StandardsComplianceExtLocalService.class)
	protected com.ihg.brandstandards.db.service.StandardsComplianceExtLocalService standardsComplianceExtLocalService;
	@BeanReference(type = StandardsComplianceExtPersistence.class)
	protected StandardsComplianceExtPersistence standardsComplianceExtPersistence;
	@BeanReference(type = StandardsComplianceExtFinder.class)
	protected StandardsComplianceExtFinder standardsComplianceExtFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.StandardsCountryLocalService.class)
	protected com.ihg.brandstandards.db.service.StandardsCountryLocalService standardsCountryLocalService;
	@BeanReference(type = StandardsCountryPersistence.class)
	protected StandardsCountryPersistence standardsCountryPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.StandardsCountryChainLocalService.class)
	protected com.ihg.brandstandards.db.service.StandardsCountryChainLocalService standardsCountryChainLocalService;
	@BeanReference(type = StandardsCountryChainPersistence.class)
	protected StandardsCountryChainPersistence standardsCountryChainPersistence;
	@BeanReference(type = StandardsCountryChainFinder.class)
	protected StandardsCountryChainFinder standardsCountryChainFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.StandardsCountryExtLocalService.class)
	protected com.ihg.brandstandards.db.service.StandardsCountryExtLocalService standardsCountryExtLocalService;
	@BeanReference(type = StandardsCountryExtPersistence.class)
	protected StandardsCountryExtPersistence standardsCountryExtPersistence;
	@BeanReference(type = StandardsCountryExtFinder.class)
	protected StandardsCountryExtFinder standardsCountryExtFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.StandardsCountryImagesLocalService.class)
	protected com.ihg.brandstandards.db.service.StandardsCountryImagesLocalService standardsCountryImagesLocalService;
	@BeanReference(type = StandardsCountryImagesPersistence.class)
	protected StandardsCountryImagesPersistence standardsCountryImagesPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.StandardsCrossReferenceLocalService.class)
	protected com.ihg.brandstandards.db.service.StandardsCrossReferenceLocalService standardsCrossReferenceLocalService;
	@BeanReference(type = StandardsCrossReferencePersistence.class)
	protected StandardsCrossReferencePersistence standardsCrossReferencePersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.StandardsDisplayOrderLocalService.class)
	protected com.ihg.brandstandards.db.service.StandardsDisplayOrderLocalService standardsDisplayOrderLocalService;
	@BeanReference(type = StandardsDisplayOrderPersistence.class)
	protected StandardsDisplayOrderPersistence standardsDisplayOrderPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.StandardsDisplayOrderExtLocalService.class)
	protected com.ihg.brandstandards.db.service.StandardsDisplayOrderExtLocalService standardsDisplayOrderExtLocalService;
	@BeanReference(type = StandardsDisplayOrderExtPersistence.class)
	protected StandardsDisplayOrderExtPersistence standardsDisplayOrderExtPersistence;
	@BeanReference(type = StandardsDisplayOrderExtFinder.class)
	protected StandardsDisplayOrderExtFinder standardsDisplayOrderExtFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.StandardsExtLocalService.class)
	protected com.ihg.brandstandards.db.service.StandardsExtLocalService standardsExtLocalService;
	@BeanReference(type = StandardsExtPersistence.class)
	protected StandardsExtPersistence standardsExtPersistence;
	@BeanReference(type = StandardsExtFinder.class)
	protected StandardsExtFinder standardsExtFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.StandardsHistoricalManualLocalService.class)
	protected com.ihg.brandstandards.db.service.StandardsHistoricalManualLocalService standardsHistoricalManualLocalService;
	@BeanReference(type = StandardsHistoricalManualPersistence.class)
	protected StandardsHistoricalManualPersistence standardsHistoricalManualPersistence;
	@BeanReference(type = StandardsHistoricalManualFinder.class)
	protected StandardsHistoricalManualFinder standardsHistoricalManualFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.StandardsImagesLocalService.class)
	protected com.ihg.brandstandards.db.service.StandardsImagesLocalService standardsImagesLocalService;
	@BeanReference(type = StandardsImagesPersistence.class)
	protected StandardsImagesPersistence standardsImagesPersistence;
	@BeanReference(type = StandardsImagesFinder.class)
	protected StandardsImagesFinder standardsImagesFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.StandardsLocaleLocalService.class)
	protected com.ihg.brandstandards.db.service.StandardsLocaleLocalService standardsLocaleLocalService;
	@BeanReference(type = StandardsLocalePersistence.class)
	protected StandardsLocalePersistence standardsLocalePersistence;
	@BeanReference(type = StandardsLocaleFinder.class)
	protected StandardsLocaleFinder standardsLocaleFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.StandardsRegionLocalService.class)
	protected com.ihg.brandstandards.db.service.StandardsRegionLocalService standardsRegionLocalService;
	@BeanReference(type = StandardsRegionPersistence.class)
	protected StandardsRegionPersistence standardsRegionPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.StandardsRegionChainLocalService.class)
	protected com.ihg.brandstandards.db.service.StandardsRegionChainLocalService standardsRegionChainLocalService;
	@BeanReference(type = StandardsRegionChainPersistence.class)
	protected StandardsRegionChainPersistence standardsRegionChainPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.StandardsRegionLocaleLocalService.class)
	protected com.ihg.brandstandards.db.service.StandardsRegionLocaleLocalService standardsRegionLocaleLocalService;
	@BeanReference(type = StandardsRegionLocalePersistence.class)
	protected StandardsRegionLocalePersistence standardsRegionLocalePersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.StandardsStatusLocalService.class)
	protected com.ihg.brandstandards.db.service.StandardsStatusLocalService standardsStatusLocalService;
	@BeanReference(type = StandardsStatusPersistence.class)
	protected StandardsStatusPersistence standardsStatusPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.StandardsTranslateLocalService.class)
	protected com.ihg.brandstandards.db.service.StandardsTranslateLocalService standardsTranslateLocalService;
	@BeanReference(type = StandardsTranslatePersistence.class)
	protected StandardsTranslatePersistence standardsTranslatePersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.TaxonomyLocalService.class)
	protected com.ihg.brandstandards.db.service.TaxonomyLocalService taxonomyLocalService;
	@BeanReference(type = TaxonomyPersistence.class)
	protected TaxonomyPersistence taxonomyPersistence;
	@BeanReference(type = TaxonomyFinder.class)
	protected TaxonomyFinder taxonomyFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.TaxonomyExtLocalService.class)
	protected com.ihg.brandstandards.db.service.TaxonomyExtLocalService taxonomyExtLocalService;
	@BeanReference(type = TaxonomyExtPersistence.class)
	protected TaxonomyExtPersistence taxonomyExtPersistence;
	@BeanReference(type = TaxonomyExtFinder.class)
	protected TaxonomyExtFinder taxonomyExtFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.TaxonomyStandardsLocalService.class)
	protected com.ihg.brandstandards.db.service.TaxonomyStandardsLocalService taxonomyStandardsLocalService;
	@BeanReference(type = TaxonomyStandardsPersistence.class)
	protected TaxonomyStandardsPersistence taxonomyStandardsPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.TaxonomyTranslateLocalService.class)
	protected com.ihg.brandstandards.db.service.TaxonomyTranslateLocalService taxonomyTranslateLocalService;
	@BeanReference(type = TaxonomyTranslatePersistence.class)
	protected TaxonomyTranslatePersistence taxonomyTranslatePersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.TreeXMLLocalService.class)
	protected com.ihg.brandstandards.db.service.TreeXMLLocalService treeXMLLocalService;
	@BeanReference(type = TreeXMLPersistence.class)
	protected TreeXMLPersistence treeXMLPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.UIElementLocalService.class)
	protected com.ihg.brandstandards.db.service.UIElementLocalService uiElementLocalService;
	@BeanReference(type = UIElementPersistence.class)
	protected UIElementPersistence uiElementPersistence;
	@BeanReference(type = UIElementFinder.class)
	protected UIElementFinder uiElementFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.UIElementTranslateLocalService.class)
	protected com.ihg.brandstandards.db.service.UIElementTranslateLocalService uiElementTranslateLocalService;
	@BeanReference(type = UIElementTranslatePersistence.class)
	protected UIElementTranslatePersistence uiElementTranslatePersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.UniqueGroupLocalService.class)
	protected com.ihg.brandstandards.db.service.UniqueGroupLocalService uniqueGroupLocalService;
	@BeanReference(type = UniqueGroupPersistence.class)
	protected UniqueGroupPersistence uniqueGroupPersistence;
	@BeanReference(type = UniqueGroupFinder.class)
	protected UniqueGroupFinder uniqueGroupFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.UniqueGroupCountryLocalService.class)
	protected com.ihg.brandstandards.db.service.UniqueGroupCountryLocalService uniqueGroupCountryLocalService;
	@BeanReference(type = UniqueGroupCountryPersistence.class)
	protected UniqueGroupCountryPersistence uniqueGroupCountryPersistence;
	@BeanReference(type = UniqueGroupCountryFinder.class)
	protected UniqueGroupCountryFinder uniqueGroupCountryFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.UniqueGroupStandardLocalService.class)
	protected com.ihg.brandstandards.db.service.UniqueGroupStandardLocalService uniqueGroupStandardLocalService;
	@BeanReference(type = UniqueGroupStandardPersistence.class)
	protected UniqueGroupStandardPersistence uniqueGroupStandardPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.UserPreferenceLocalService.class)
	protected com.ihg.brandstandards.db.service.UserPreferenceLocalService userPreferenceLocalService;
	@BeanReference(type = UserPreferencePersistence.class)
	protected UserPreferencePersistence userPreferencePersistence;
	@BeanReference(type = UserPreferenceFinder.class)
	protected UserPreferenceFinder userPreferenceFinder;
	@BeanReference(type = com.ihg.brandstandards.db.service.UserSearchCriteriaLocalService.class)
	protected com.ihg.brandstandards.db.service.UserSearchCriteriaLocalService userSearchCriteriaLocalService;
	@BeanReference(type = UserSearchCriteriaPersistence.class)
	protected UserSearchCriteriaPersistence userSearchCriteriaPersistence;
	@BeanReference(type = com.ihg.brandstandards.db.service.WorkflowLocalService.class)
	protected com.ihg.brandstandards.db.service.WorkflowLocalService workflowLocalService;
	@BeanReference(type = WorkflowPersistence.class)
	protected WorkflowPersistence workflowPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private StandardsCountryChainLocalServiceClpInvoker _clpInvoker = new StandardsCountryChainLocalServiceClpInvoker();
}