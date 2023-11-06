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

package com.ihg.brandstandards.db.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for BridgePublish. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Mummanedi
 * @see BridgePublishLocalServiceUtil
 * @see com.ihg.brandstandards.db.service.base.BridgePublishLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.BridgePublishLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface BridgePublishLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BridgePublishLocalServiceUtil} to access the bridge publish local service. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.BridgePublishLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the bridge publish to the database. Also notifies the appropriate model listeners.
	*
	* @param bridgePublish the bridge publish
	* @return the bridge publish that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublish addBridgePublish(
		com.ihg.brandstandards.db.model.BridgePublish bridgePublish)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new bridge publish with the primary key. Does not add the bridge publish to the database.
	*
	* @param bridgePublishId the primary key for the new bridge publish
	* @return the new bridge publish
	*/
	public com.ihg.brandstandards.db.model.BridgePublish createBridgePublish(
		long bridgePublishId);

	/**
	* Deletes the bridge publish with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bridgePublishId the primary key of the bridge publish
	* @return the bridge publish that was removed
	* @throws PortalException if a bridge publish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublish deleteBridgePublish(
		long bridgePublishId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the bridge publish from the database. Also notifies the appropriate model listeners.
	*
	* @param bridgePublish the bridge publish
	* @return the bridge publish that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublish deleteBridgePublish(
		com.ihg.brandstandards.db.model.BridgePublish bridgePublish)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.ihg.brandstandards.db.model.BridgePublish fetchBridgePublish(
		long bridgePublishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publish with the primary key.
	*
	* @param bridgePublishId the primary key of the bridge publish
	* @return the bridge publish
	* @throws PortalException if a bridge publish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.ihg.brandstandards.db.model.BridgePublish getBridgePublish(
		long bridgePublishId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bridge publishs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge publishs
	* @param end the upper bound of the range of bridge publishs (not inclusive)
	* @return the range of bridge publishs
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublish> getBridgePublishs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge publishs.
	*
	* @return the number of bridge publishs
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getBridgePublishsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the bridge publish in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bridgePublish the bridge publish
	* @return the bridge publish that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublish updateBridgePublish(
		com.ihg.brandstandards.db.model.BridgePublish bridgePublish)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public void clearCache();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublish> getByPublish(
		long publishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublish> getByPublishIdAndStdId(
		long publishId, long standardId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublish> getByPublishIdAndRegionId(
		long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.ihg.brandstandards.db.model.BridgePublish getByPublishIdRegionIdAndStdId(
		long publishId, long regionCode, long standardId)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.lang.Long> getStandardIds(long publishId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Map<java.lang.String, java.lang.Long> getBridgeProgress(
		long publishId, java.lang.String chainCode, java.util.Date publishDate,
		long regionId, boolean allRegions, java.lang.String progressType)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Map<java.lang.String, java.lang.Long> getOverallProgress(
		long publishId, long regionId, boolean allRegions);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Map<java.lang.String, java.lang.Long> getTranslationProgress(
		long publishId, long regionId, boolean allRegions)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Map<java.lang.String, java.lang.Long> getIndexTranslationProgress(
		long publishId, java.lang.String chainCode, long regionId,
		boolean allRegions)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getProgressViewDetailsStandards(
		long publishId, long regionId, java.lang.String chainCode,
		java.util.Date publishDate, java.lang.String localeCode,
		java.lang.String statIndText);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getUnpublishedDetailsStandards(
		long publishId, long regionId, java.lang.String chainCode,
		java.lang.String regionCode, java.lang.String stdIds);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List getTranslationViewDetailsStandards(long publishId,
		long regionId, java.lang.String localeCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.PublishQueue> getPublishQueueRecords(
		java.lang.String brandCode, java.lang.String environment,
		java.lang.String status);

	public void resetBridgePublication(long bridgePublishId, long regionId,
		java.lang.String chainCode, java.lang.String userScreenName)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateUnpublishedToPublishedRecords(long publishId,
		java.lang.String brandCode, long regionId, java.lang.String screenName,
		java.lang.String stdIds);

	public void createDraftPublication(long publishId,
		java.lang.String brandCode, java.lang.String screenName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getMyPublicationByBrand(
		java.lang.String chainCode, java.lang.String regionCode,
		java.lang.String query)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* @param publishId
	* @return long
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getStandardCountForPublication(long publishId);

	public com.ihg.brandstandards.db.model.BridgePublish createOraSequence()
		throws com.liferay.portal.kernel.exception.SystemException;

	public boolean updateBridgePublishAndCountryFromImport(
		long bridgePublishId, long prodPublishId, java.lang.String brandCode,
		long regionId, java.lang.String screenName)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.lang.Long> getBridgePublishStandardsByParent(
		java.lang.String query)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.ihg.brandstandards.db.model.BridgePublish getBridgePublishStandardsById(
		java.lang.String query)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.custom.model.Standard> getStandardDetails(
		java.lang.String query);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getPublishedStandardsCompliance(
		java.util.List<java.lang.Long> stdIds, java.lang.String stdType,
		java.lang.String brandCd, java.lang.String regionCode,
		java.lang.String fromDate, java.lang.String toDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Map<java.lang.String, java.lang.String> getPublishedStandardComplianceDetails(
		long stdId, java.lang.String brandCode, java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getBridgeStandardsCompliance(
		java.util.List<java.lang.Long> stdIds, java.lang.String stdType,
		java.lang.String brandCd, java.lang.String regionCode,
		java.lang.String fromDate, java.lang.String toDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Map<java.lang.String, java.lang.String> getBridgeStandardComplianceDetails(
		long stdId, java.lang.String brandCode, java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void createManuals(long publishQueueId, long publishId,
		java.lang.String emailAddress, java.lang.String userName,
		java.lang.String manualRegions);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.lang.Long> getMissingReferences(long publishId,
		long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void addStdToBridgeForAddById(long bridgePublishId,
		long prodPublishId, java.lang.String brandCode, long regionId,
		java.util.List<java.lang.Long> stdIds, java.lang.String screenName);

	/**
	* Get active Bridge Publish Ids for specified standard id.
	*
	* @param stdId standard id
	* @return String
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.lang.Long> getBridgePublishIdsByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* @param publishId
	* @param stdId
	* @return
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.lang.Long> getRegionsByPublishIdAndStdId(
		long publishId, long stdId);
}