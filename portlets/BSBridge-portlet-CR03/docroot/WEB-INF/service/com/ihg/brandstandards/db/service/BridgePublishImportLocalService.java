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
 * Provides the local service interface for BridgePublishImport. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Mummanedi
 * @see BridgePublishImportLocalServiceUtil
 * @see com.ihg.brandstandards.db.service.base.BridgePublishImportLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.BridgePublishImportLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface BridgePublishImportLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BridgePublishImportLocalServiceUtil} to access the bridge publish import local service. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.BridgePublishImportLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the bridge publish import to the database. Also notifies the appropriate model listeners.
	*
	* @param bridgePublishImport the bridge publish import
	* @return the bridge publish import that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishImport addBridgePublishImport(
		com.ihg.brandstandards.db.model.BridgePublishImport bridgePublishImport)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new bridge publish import with the primary key. Does not add the bridge publish import to the database.
	*
	* @param publishImportId the primary key for the new bridge publish import
	* @return the new bridge publish import
	*/
	public com.ihg.brandstandards.db.model.BridgePublishImport createBridgePublishImport(
		long publishImportId);

	/**
	* Deletes the bridge publish import with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param publishImportId the primary key of the bridge publish import
	* @return the bridge publish import that was removed
	* @throws PortalException if a bridge publish import with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishImport deleteBridgePublishImport(
		long publishImportId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the bridge publish import from the database. Also notifies the appropriate model listeners.
	*
	* @param bridgePublishImport the bridge publish import
	* @return the bridge publish import that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishImport deleteBridgePublishImport(
		com.ihg.brandstandards.db.model.BridgePublishImport bridgePublishImport)
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishImportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishImportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public com.ihg.brandstandards.db.model.BridgePublishImport fetchBridgePublishImport(
		long publishImportId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publish import with the primary key.
	*
	* @param publishImportId the primary key of the bridge publish import
	* @return the bridge publish import
	* @throws PortalException if a bridge publish import with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.ihg.brandstandards.db.model.BridgePublishImport getBridgePublishImport(
		long publishImportId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bridge publish imports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishImportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge publish imports
	* @param end the upper bound of the range of bridge publish imports (not inclusive)
	* @return the range of bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishImport> getBridgePublishImports(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge publish imports.
	*
	* @return the number of bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getBridgePublishImportsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the bridge publish import in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bridgePublishImport the bridge publish import
	* @return the bridge publish import that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishImport updateBridgePublishImport(
		com.ihg.brandstandards.db.model.BridgePublishImport bridgePublishImport)
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

	public com.ihg.brandstandards.db.model.BridgePublishImport createOraSequence()
		throws com.liferay.portal.kernel.exception.SystemException;

	public int addBridgePublishImport(java.util.List<java.lang.Long> stdIds,
		long publishId, java.lang.String chainCode, long rgnId,
		java.lang.String userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.BridgePublishImport findByPublishIdAndStdId(
		long publishId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getBridgeImportedRecordsCount(long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishImport> findByPublishIdAndRegionId(
		long publishId, long rgnId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Long> findByPublishIdRegionIdandSelectionInd(
		long publishId, long rgnId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void deleteBridgeImportByPublishIdAndRegionId(long publishId,
		long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateBridgePublishImport(long publishId,
		java.util.List<java.lang.Long> mustPublish,
		java.util.List<java.lang.Long> mustNotPublish,
		java.util.List<java.lang.Long> unPublish,
		java.util.List<java.lang.Long> wrongBrand,
		java.util.List<java.lang.Long> wrongRgn,
		java.util.List<java.lang.Long> doPublish,
		java.util.List<java.lang.Long> discont,
		java.util.List<java.lang.Long> missing,
		java.util.List<java.lang.Long> orphan)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.lang.Long> getStandardsByRegion(long publishId,
		long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.lang.Long> getDiscountinuedStandards(
		java.util.List<java.lang.Long> stdIds, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getMyPublicationIssuesCount(long publishId, long regionId,
		java.lang.String vldStatusExclude);

	public void clearCache();

	public void updateGlobalRegionalStdCountries(long publishId, long stdId,
		long cmsRegionId, java.lang.String userScreenName);

	public void updateStdCountriesState(long publishId, long stdId,
		long cmsRegionId, java.lang.String userScreenName);

	public void setBridgePublishForImport(long publishId, long rgnId,
		java.util.Map<java.lang.Long, java.lang.String> importSelection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getSTDToBeAddedCount(long publishId, long rgnId);
}