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
 * Provides a wrapper for {@link StandardsDisplayOrderLocalService}.
 *
 * @author Mummanedi
 * @see StandardsDisplayOrderLocalService
 * @generated
 */
public class StandardsDisplayOrderLocalServiceWrapper
	implements StandardsDisplayOrderLocalService,
		ServiceWrapper<StandardsDisplayOrderLocalService> {
	public StandardsDisplayOrderLocalServiceWrapper(
		StandardsDisplayOrderLocalService standardsDisplayOrderLocalService) {
		_standardsDisplayOrderLocalService = standardsDisplayOrderLocalService;
	}

	/**
	* Adds the standards display order to the database. Also notifies the appropriate model listeners.
	*
	* @param standardsDisplayOrder the standards display order
	* @return the standards display order that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsDisplayOrder addStandardsDisplayOrder(
		com.ihg.brandstandards.db.model.StandardsDisplayOrder standardsDisplayOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsDisplayOrderLocalService.addStandardsDisplayOrder(standardsDisplayOrder);
	}

	/**
	* Creates a new standards display order with the primary key. Does not add the standards display order to the database.
	*
	* @param standardsDisplayOrderPK the primary key for the new standards display order
	* @return the new standards display order
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsDisplayOrder createStandardsDisplayOrder(
		com.ihg.brandstandards.db.service.persistence.StandardsDisplayOrderPK standardsDisplayOrderPK) {
		return _standardsDisplayOrderLocalService.createStandardsDisplayOrder(standardsDisplayOrderPK);
	}

	/**
	* Deletes the standards display order with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsDisplayOrderPK the primary key of the standards display order
	* @return the standards display order that was removed
	* @throws PortalException if a standards display order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsDisplayOrder deleteStandardsDisplayOrder(
		com.ihg.brandstandards.db.service.persistence.StandardsDisplayOrderPK standardsDisplayOrderPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsDisplayOrderLocalService.deleteStandardsDisplayOrder(standardsDisplayOrderPK);
	}

	/**
	* Deletes the standards display order from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsDisplayOrder the standards display order
	* @return the standards display order that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsDisplayOrder deleteStandardsDisplayOrder(
		com.ihg.brandstandards.db.model.StandardsDisplayOrder standardsDisplayOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsDisplayOrderLocalService.deleteStandardsDisplayOrder(standardsDisplayOrder);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _standardsDisplayOrderLocalService.dynamicQuery();
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
		return _standardsDisplayOrderLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsDisplayOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _standardsDisplayOrderLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsDisplayOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _standardsDisplayOrderLocalService.dynamicQuery(dynamicQuery,
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
		return _standardsDisplayOrderLocalService.dynamicQueryCount(dynamicQuery);
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
		return _standardsDisplayOrderLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsDisplayOrder fetchStandardsDisplayOrder(
		com.ihg.brandstandards.db.service.persistence.StandardsDisplayOrderPK standardsDisplayOrderPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsDisplayOrderLocalService.fetchStandardsDisplayOrder(standardsDisplayOrderPK);
	}

	/**
	* Returns the standards display order with the primary key.
	*
	* @param standardsDisplayOrderPK the primary key of the standards display order
	* @return the standards display order
	* @throws PortalException if a standards display order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsDisplayOrder getStandardsDisplayOrder(
		com.ihg.brandstandards.db.service.persistence.StandardsDisplayOrderPK standardsDisplayOrderPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsDisplayOrderLocalService.getStandardsDisplayOrder(standardsDisplayOrderPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsDisplayOrderLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the standards display orders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsDisplayOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards display orders
	* @param end the upper bound of the range of standards display orders (not inclusive)
	* @return the range of standards display orders
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsDisplayOrder> getStandardsDisplayOrders(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsDisplayOrderLocalService.getStandardsDisplayOrders(start,
			end);
	}

	/**
	* Returns the number of standards display orders.
	*
	* @return the number of standards display orders
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getStandardsDisplayOrdersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsDisplayOrderLocalService.getStandardsDisplayOrdersCount();
	}

	/**
	* Updates the standards display order in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param standardsDisplayOrder the standards display order
	* @return the standards display order that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsDisplayOrder updateStandardsDisplayOrder(
		com.ihg.brandstandards.db.model.StandardsDisplayOrder standardsDisplayOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsDisplayOrderLocalService.updateStandardsDisplayOrder(standardsDisplayOrder);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _standardsDisplayOrderLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_standardsDisplayOrderLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _standardsDisplayOrderLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void clearCache() {
		_standardsDisplayOrderLocalService.clearCache();
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsDisplayOrder getStandardsDispalyOrder(
		long stdId, java.lang.String chainCode, java.lang.String regionCode) {
		return _standardsDisplayOrderLocalService.getStandardsDispalyOrder(stdId,
			chainCode, regionCode);
	}

	/**
	* Add Standard display order in db.
	*
	* @param stdId  Standard id.
	* @param chainCode Chain code.
	* @param regionCode Region code.
	* @return {@link StandardsDisplayOrder}
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsDisplayOrder addStandardsDisplayOrder(
		long stdId, java.lang.String chainCode, java.lang.String regionCode) {
		return _standardsDisplayOrderLocalService.addStandardsDisplayOrder(stdId,
			chainCode, regionCode);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public StandardsDisplayOrderLocalService getWrappedStandardsDisplayOrderLocalService() {
		return _standardsDisplayOrderLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedStandardsDisplayOrderLocalService(
		StandardsDisplayOrderLocalService standardsDisplayOrderLocalService) {
		_standardsDisplayOrderLocalService = standardsDisplayOrderLocalService;
	}

	@Override
	public StandardsDisplayOrderLocalService getWrappedService() {
		return _standardsDisplayOrderLocalService;
	}

	@Override
	public void setWrappedService(
		StandardsDisplayOrderLocalService standardsDisplayOrderLocalService) {
		_standardsDisplayOrderLocalService = standardsDisplayOrderLocalService;
	}

	private StandardsDisplayOrderLocalService _standardsDisplayOrderLocalService;
}