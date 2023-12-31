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
 * Provides a wrapper for {@link BridgePublishStateExLocalService}.
 *
 * @author Mummanedi
 * @see BridgePublishStateExLocalService
 * @generated
 */
public class BridgePublishStateExLocalServiceWrapper
	implements BridgePublishStateExLocalService,
		ServiceWrapper<BridgePublishStateExLocalService> {
	public BridgePublishStateExLocalServiceWrapper(
		BridgePublishStateExLocalService bridgePublishStateExLocalService) {
		_bridgePublishStateExLocalService = bridgePublishStateExLocalService;
	}

	/**
	* Adds the bridge publish state ex to the database. Also notifies the appropriate model listeners.
	*
	* @param bridgePublishStateEx the bridge publish state ex
	* @return the bridge publish state ex that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.BridgePublishStateEx addBridgePublishStateEx(
		com.ihg.brandstandards.db.model.BridgePublishStateEx bridgePublishStateEx)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgePublishStateExLocalService.addBridgePublishStateEx(bridgePublishStateEx);
	}

	/**
	* Creates a new bridge publish state ex with the primary key. Does not add the bridge publish state ex to the database.
	*
	* @param bridgePublishStateExPK the primary key for the new bridge publish state ex
	* @return the new bridge publish state ex
	*/
	@Override
	public com.ihg.brandstandards.db.model.BridgePublishStateEx createBridgePublishStateEx(
		com.ihg.brandstandards.db.service.persistence.BridgePublishStateExPK bridgePublishStateExPK) {
		return _bridgePublishStateExLocalService.createBridgePublishStateEx(bridgePublishStateExPK);
	}

	/**
	* Deletes the bridge publish state ex with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bridgePublishStateExPK the primary key of the bridge publish state ex
	* @return the bridge publish state ex that was removed
	* @throws PortalException if a bridge publish state ex with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.BridgePublishStateEx deleteBridgePublishStateEx(
		com.ihg.brandstandards.db.service.persistence.BridgePublishStateExPK bridgePublishStateExPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bridgePublishStateExLocalService.deleteBridgePublishStateEx(bridgePublishStateExPK);
	}

	/**
	* Deletes the bridge publish state ex from the database. Also notifies the appropriate model listeners.
	*
	* @param bridgePublishStateEx the bridge publish state ex
	* @return the bridge publish state ex that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.BridgePublishStateEx deleteBridgePublishStateEx(
		com.ihg.brandstandards.db.model.BridgePublishStateEx bridgePublishStateEx)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgePublishStateExLocalService.deleteBridgePublishStateEx(bridgePublishStateEx);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bridgePublishStateExLocalService.dynamicQuery();
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
		return _bridgePublishStateExLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishStateExModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _bridgePublishStateExLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishStateExModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _bridgePublishStateExLocalService.dynamicQuery(dynamicQuery,
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
		return _bridgePublishStateExLocalService.dynamicQueryCount(dynamicQuery);
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
		return _bridgePublishStateExLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgePublishStateEx fetchBridgePublishStateEx(
		com.ihg.brandstandards.db.service.persistence.BridgePublishStateExPK bridgePublishStateExPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgePublishStateExLocalService.fetchBridgePublishStateEx(bridgePublishStateExPK);
	}

	/**
	* Returns the bridge publish state ex with the primary key.
	*
	* @param bridgePublishStateExPK the primary key of the bridge publish state ex
	* @return the bridge publish state ex
	* @throws PortalException if a bridge publish state ex with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.BridgePublishStateEx getBridgePublishStateEx(
		com.ihg.brandstandards.db.service.persistence.BridgePublishStateExPK bridgePublishStateExPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bridgePublishStateExLocalService.getBridgePublishStateEx(bridgePublishStateExPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bridgePublishStateExLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the bridge publish state exs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishStateExModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge publish state exs
	* @param end the upper bound of the range of bridge publish state exs (not inclusive)
	* @return the range of bridge publish state exs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishStateEx> getBridgePublishStateExs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgePublishStateExLocalService.getBridgePublishStateExs(start,
			end);
	}

	/**
	* Returns the number of bridge publish state exs.
	*
	* @return the number of bridge publish state exs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBridgePublishStateExsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgePublishStateExLocalService.getBridgePublishStateExsCount();
	}

	/**
	* Updates the bridge publish state ex in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bridgePublishStateEx the bridge publish state ex
	* @return the bridge publish state ex that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.BridgePublishStateEx updateBridgePublishStateEx(
		com.ihg.brandstandards.db.model.BridgePublishStateEx bridgePublishStateEx)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgePublishStateExLocalService.updateBridgePublishStateEx(bridgePublishStateEx);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _bridgePublishStateExLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_bridgePublishStateExLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _bridgePublishStateExLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishStateEx> getBridgePublishStateExByRegionBrand(
		java.lang.String chainCd, long regionCd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgePublishStateExLocalService.getBridgePublishStateExByRegionBrand(chainCd,
			regionCd);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishStateEx> getBridgePublishStateExByRegionBrand(
		java.lang.String chainCd, long regionCd, java.lang.String filterState,
		java.lang.String filterIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgePublishStateExLocalService.getBridgePublishStateExByRegionBrand(chainCd,
			regionCd, filterState, filterIds);
	}

	@Override
	public void clearCache() {
		_bridgePublishStateExLocalService.clearCache();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BridgePublishStateExLocalService getWrappedBridgePublishStateExLocalService() {
		return _bridgePublishStateExLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBridgePublishStateExLocalService(
		BridgePublishStateExLocalService bridgePublishStateExLocalService) {
		_bridgePublishStateExLocalService = bridgePublishStateExLocalService;
	}

	@Override
	public BridgePublishStateExLocalService getWrappedService() {
		return _bridgePublishStateExLocalService;
	}

	@Override
	public void setWrappedService(
		BridgePublishStateExLocalService bridgePublishStateExLocalService) {
		_bridgePublishStateExLocalService = bridgePublishStateExLocalService;
	}

	private BridgePublishStateExLocalService _bridgePublishStateExLocalService;
}