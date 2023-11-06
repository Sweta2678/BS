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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BridgeGlobalPublishLocalService}.
 *
 * @author Mummanedi
 * @see BridgeGlobalPublishLocalService
 * @generated
 */
public class BridgeGlobalPublishLocalServiceWrapper
	implements BridgeGlobalPublishLocalService,
		ServiceWrapper<BridgeGlobalPublishLocalService> {
	public BridgeGlobalPublishLocalServiceWrapper(
		BridgeGlobalPublishLocalService bridgeGlobalPublishLocalService) {
		_bridgeGlobalPublishLocalService = bridgeGlobalPublishLocalService;
	}

	/**
	* Adds the bridge global publish to the database. Also notifies the appropriate model listeners.
	*
	* @param bridgeGlobalPublish the bridge global publish
	* @return the bridge global publish that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.BridgeGlobalPublish addBridgeGlobalPublish(
		com.ihg.brandstandards.db.model.BridgeGlobalPublish bridgeGlobalPublish)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgeGlobalPublishLocalService.addBridgeGlobalPublish(bridgeGlobalPublish);
	}

	/**
	* Creates a new bridge global publish with the primary key. Does not add the bridge global publish to the database.
	*
	* @param globalPublishId the primary key for the new bridge global publish
	* @return the new bridge global publish
	*/
	@Override
	public com.ihg.brandstandards.db.model.BridgeGlobalPublish createBridgeGlobalPublish(
		long globalPublishId) {
		return _bridgeGlobalPublishLocalService.createBridgeGlobalPublish(globalPublishId);
	}

	/**
	* Deletes the bridge global publish with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param globalPublishId the primary key of the bridge global publish
	* @return the bridge global publish that was removed
	* @throws PortalException if a bridge global publish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.BridgeGlobalPublish deleteBridgeGlobalPublish(
		long globalPublishId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bridgeGlobalPublishLocalService.deleteBridgeGlobalPublish(globalPublishId);
	}

	/**
	* Deletes the bridge global publish from the database. Also notifies the appropriate model listeners.
	*
	* @param bridgeGlobalPublish the bridge global publish
	* @return the bridge global publish that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.BridgeGlobalPublish deleteBridgeGlobalPublish(
		com.ihg.brandstandards.db.model.BridgeGlobalPublish bridgeGlobalPublish)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgeGlobalPublishLocalService.deleteBridgeGlobalPublish(bridgeGlobalPublish);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bridgeGlobalPublishLocalService.dynamicQuery();
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgeGlobalPublishLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgeGlobalPublishLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgeGlobalPublishLocalService.dynamicQuery(dynamicQuery,
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgeGlobalPublishLocalService.dynamicQueryCount(dynamicQuery);
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgeGlobalPublishLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgeGlobalPublish fetchBridgeGlobalPublish(
		long globalPublishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgeGlobalPublishLocalService.fetchBridgeGlobalPublish(globalPublishId);
	}

	/**
	* Returns the bridge global publish with the primary key.
	*
	* @param globalPublishId the primary key of the bridge global publish
	* @return the bridge global publish
	* @throws PortalException if a bridge global publish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.BridgeGlobalPublish getBridgeGlobalPublish(
		long globalPublishId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bridgeGlobalPublishLocalService.getBridgeGlobalPublish(globalPublishId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bridgeGlobalPublishLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the bridge global publishs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge global publishs
	* @param end the upper bound of the range of bridge global publishs (not inclusive)
	* @return the range of bridge global publishs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublish> getBridgeGlobalPublishs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgeGlobalPublishLocalService.getBridgeGlobalPublishs(start,
			end);
	}

	/**
	* Returns the number of bridge global publishs.
	*
	* @return the number of bridge global publishs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBridgeGlobalPublishsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgeGlobalPublishLocalService.getBridgeGlobalPublishsCount();
	}

	/**
	* Updates the bridge global publish in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bridgeGlobalPublish the bridge global publish
	* @return the bridge global publish that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.BridgeGlobalPublish updateBridgeGlobalPublish(
		com.ihg.brandstandards.db.model.BridgeGlobalPublish bridgeGlobalPublish)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgeGlobalPublishLocalService.updateBridgeGlobalPublish(bridgeGlobalPublish);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _bridgeGlobalPublishLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_bridgeGlobalPublishLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _bridgeGlobalPublishLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void clearCache() {
		_bridgeGlobalPublishLocalService.clearCache();
	}

	@Override
	public java.util.List getMustPublishStandardsByIdsAndBrand(
		java.lang.String stdIdsByCommaSeprated, java.lang.String brand,
		boolean mustPublish) {
		return _bridgeGlobalPublishLocalService.getMustPublishStandardsByIdsAndBrand(stdIdsByCommaSeprated,
			brand, mustPublish);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.Long> getTotalIssuesforMustpublish(
		java.lang.String isMustPublish, long publishId, java.lang.String brand) {
		return _bridgeGlobalPublishLocalService.getTotalIssuesforMustpublish(isMustPublish,
			publishId, brand);
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgeGlobalPublish getByPublishIdAndStdId(
		long publishId, long stdId) {
		return _bridgeGlobalPublishLocalService.getByPublishIdAndStdId(publishId,
			stdId);
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgeGlobalPublish getByStdIdAndMustPublishInd(
		long publishId, long stdId, java.lang.String mustPublishInd) {
		return _bridgeGlobalPublishLocalService.getByStdIdAndMustPublishInd(publishId,
			stdId, mustPublishInd);
	}

	@Override
	public java.util.List<java.lang.Long> getGlobalStandardsByPublishIdAndIndicator(
		java.lang.String indicator, long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgeGlobalPublishLocalService.getGlobalStandardsByPublishIdAndIndicator(indicator,
			publishId);
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgeGlobalPublish getNewBridgeGlobalPublish() {
		return _bridgeGlobalPublishLocalService.getNewBridgeGlobalPublish();
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry getNewBridgeGlobalPublishCountry() {
		return _bridgeGlobalPublishLocalService.getNewBridgeGlobalPublishCountry();
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry> getBridgeGlobalPublishCountryByGlobalPublishIdAndRegionId(
		long bridgeGlobalPublishId, long regionId) {
		return _bridgeGlobalPublishLocalService.getBridgeGlobalPublishCountryByGlobalPublishIdAndRegionId(bridgeGlobalPublishId,
			regionId);
	}

	@Override
	public void importGlobalMustPublishStandards(long publishId,
		java.lang.String chainCode, java.lang.String screenName,
		java.lang.String stdIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_bridgeGlobalPublishLocalService.importGlobalMustPublishStandards(publishId,
			chainCode, screenName, stdIds);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BridgeGlobalPublishLocalService getWrappedBridgeGlobalPublishLocalService() {
		return _bridgeGlobalPublishLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBridgeGlobalPublishLocalService(
		BridgeGlobalPublishLocalService bridgeGlobalPublishLocalService) {
		_bridgeGlobalPublishLocalService = bridgeGlobalPublishLocalService;
	}

	@Override
	public BridgeGlobalPublishLocalService getWrappedService() {
		return _bridgeGlobalPublishLocalService;
	}

	@Override
	public void setWrappedService(
		BridgeGlobalPublishLocalService bridgeGlobalPublishLocalService) {
		_bridgeGlobalPublishLocalService = bridgeGlobalPublishLocalService;
	}

	private BridgeGlobalPublishLocalService _bridgeGlobalPublishLocalService;
}