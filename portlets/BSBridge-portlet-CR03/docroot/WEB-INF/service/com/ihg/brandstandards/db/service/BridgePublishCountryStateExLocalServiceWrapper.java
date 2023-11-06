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
 * Provides a wrapper for {@link BridgePublishCountryStateExLocalService}.
 *
 * @author Mummanedi
 * @see BridgePublishCountryStateExLocalService
 * @generated
 */
public class BridgePublishCountryStateExLocalServiceWrapper
	implements BridgePublishCountryStateExLocalService,
		ServiceWrapper<BridgePublishCountryStateExLocalService> {
	public BridgePublishCountryStateExLocalServiceWrapper(
		BridgePublishCountryStateExLocalService bridgePublishCountryStateExLocalService) {
		_bridgePublishCountryStateExLocalService = bridgePublishCountryStateExLocalService;
	}

	/**
	* Adds the bridge publish country state ex to the database. Also notifies the appropriate model listeners.
	*
	* @param bridgePublishCountryStateEx the bridge publish country state ex
	* @return the bridge publish country state ex that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.BridgePublishCountryStateEx addBridgePublishCountryStateEx(
		com.ihg.brandstandards.db.model.BridgePublishCountryStateEx bridgePublishCountryStateEx)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgePublishCountryStateExLocalService.addBridgePublishCountryStateEx(bridgePublishCountryStateEx);
	}

	/**
	* Creates a new bridge publish country state ex with the primary key. Does not add the bridge publish country state ex to the database.
	*
	* @param bridgePublishCountryStateExPK the primary key for the new bridge publish country state ex
	* @return the new bridge publish country state ex
	*/
	@Override
	public com.ihg.brandstandards.db.model.BridgePublishCountryStateEx createBridgePublishCountryStateEx(
		com.ihg.brandstandards.db.service.persistence.BridgePublishCountryStateExPK bridgePublishCountryStateExPK) {
		return _bridgePublishCountryStateExLocalService.createBridgePublishCountryStateEx(bridgePublishCountryStateExPK);
	}

	/**
	* Deletes the bridge publish country state ex with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bridgePublishCountryStateExPK the primary key of the bridge publish country state ex
	* @return the bridge publish country state ex that was removed
	* @throws PortalException if a bridge publish country state ex with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.BridgePublishCountryStateEx deleteBridgePublishCountryStateEx(
		com.ihg.brandstandards.db.service.persistence.BridgePublishCountryStateExPK bridgePublishCountryStateExPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bridgePublishCountryStateExLocalService.deleteBridgePublishCountryStateEx(bridgePublishCountryStateExPK);
	}

	/**
	* Deletes the bridge publish country state ex from the database. Also notifies the appropriate model listeners.
	*
	* @param bridgePublishCountryStateEx the bridge publish country state ex
	* @return the bridge publish country state ex that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.BridgePublishCountryStateEx deleteBridgePublishCountryStateEx(
		com.ihg.brandstandards.db.model.BridgePublishCountryStateEx bridgePublishCountryStateEx)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgePublishCountryStateExLocalService.deleteBridgePublishCountryStateEx(bridgePublishCountryStateEx);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bridgePublishCountryStateExLocalService.dynamicQuery();
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
		return _bridgePublishCountryStateExLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishCountryStateExModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _bridgePublishCountryStateExLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishCountryStateExModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _bridgePublishCountryStateExLocalService.dynamicQuery(dynamicQuery,
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
		return _bridgePublishCountryStateExLocalService.dynamicQueryCount(dynamicQuery);
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
		return _bridgePublishCountryStateExLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgePublishCountryStateEx fetchBridgePublishCountryStateEx(
		com.ihg.brandstandards.db.service.persistence.BridgePublishCountryStateExPK bridgePublishCountryStateExPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgePublishCountryStateExLocalService.fetchBridgePublishCountryStateEx(bridgePublishCountryStateExPK);
	}

	/**
	* Returns the bridge publish country state ex with the primary key.
	*
	* @param bridgePublishCountryStateExPK the primary key of the bridge publish country state ex
	* @return the bridge publish country state ex
	* @throws PortalException if a bridge publish country state ex with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.BridgePublishCountryStateEx getBridgePublishCountryStateEx(
		com.ihg.brandstandards.db.service.persistence.BridgePublishCountryStateExPK bridgePublishCountryStateExPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bridgePublishCountryStateExLocalService.getBridgePublishCountryStateEx(bridgePublishCountryStateExPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bridgePublishCountryStateExLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the bridge publish country state exs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishCountryStateExModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge publish country state exs
	* @param end the upper bound of the range of bridge publish country state exs (not inclusive)
	* @return the range of bridge publish country state exs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishCountryStateEx> getBridgePublishCountryStateExs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgePublishCountryStateExLocalService.getBridgePublishCountryStateExs(start,
			end);
	}

	/**
	* Returns the number of bridge publish country state exs.
	*
	* @return the number of bridge publish country state exs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBridgePublishCountryStateExsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgePublishCountryStateExLocalService.getBridgePublishCountryStateExsCount();
	}

	/**
	* Updates the bridge publish country state ex in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bridgePublishCountryStateEx the bridge publish country state ex
	* @return the bridge publish country state ex that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.BridgePublishCountryStateEx updateBridgePublishCountryStateEx(
		com.ihg.brandstandards.db.model.BridgePublishCountryStateEx bridgePublishCountryStateEx)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgePublishCountryStateExLocalService.updateBridgePublishCountryStateEx(bridgePublishCountryStateEx);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _bridgePublishCountryStateExLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_bridgePublishCountryStateExLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _bridgePublishCountryStateExLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishCountryStateEx> getBridgePublishCountryStateEx(
		java.lang.String chainCd, long regionCd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgePublishCountryStateExLocalService.getBridgePublishCountryStateEx(chainCd,
			regionCd);
	}

	@Override
	public void clearCache() {
		_bridgePublishCountryStateExLocalService.clearCache();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BridgePublishCountryStateExLocalService getWrappedBridgePublishCountryStateExLocalService() {
		return _bridgePublishCountryStateExLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBridgePublishCountryStateExLocalService(
		BridgePublishCountryStateExLocalService bridgePublishCountryStateExLocalService) {
		_bridgePublishCountryStateExLocalService = bridgePublishCountryStateExLocalService;
	}

	@Override
	public BridgePublishCountryStateExLocalService getWrappedService() {
		return _bridgePublishCountryStateExLocalService;
	}

	@Override
	public void setWrappedService(
		BridgePublishCountryStateExLocalService bridgePublishCountryStateExLocalService) {
		_bridgePublishCountryStateExLocalService = bridgePublishCountryStateExLocalService;
	}

	private BridgePublishCountryStateExLocalService _bridgePublishCountryStateExLocalService;
}