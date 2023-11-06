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
 * Provides a wrapper for {@link HistManualsLocalService}.
 *
 * @author Mummanedi
 * @see HistManualsLocalService
 * @generated
 */
public class HistManualsLocalServiceWrapper implements HistManualsLocalService,
	ServiceWrapper<HistManualsLocalService> {
	public HistManualsLocalServiceWrapper(
		HistManualsLocalService histManualsLocalService) {
		_histManualsLocalService = histManualsLocalService;
	}

	/**
	* Adds the hist manuals to the database. Also notifies the appropriate model listeners.
	*
	* @param histManuals the hist manuals
	* @return the hist manuals that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.HistManuals addHistManuals(
		com.ihg.brandstandards.db.model.HistManuals histManuals)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _histManualsLocalService.addHistManuals(histManuals);
	}

	/**
	* Creates a new hist manuals with the primary key. Does not add the hist manuals to the database.
	*
	* @param histManualId the primary key for the new hist manuals
	* @return the new hist manuals
	*/
	@Override
	public com.ihg.brandstandards.db.model.HistManuals createHistManuals(
		long histManualId) {
		return _histManualsLocalService.createHistManuals(histManualId);
	}

	/**
	* Deletes the hist manuals with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param histManualId the primary key of the hist manuals
	* @return the hist manuals that was removed
	* @throws PortalException if a hist manuals with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.HistManuals deleteHistManuals(
		long histManualId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _histManualsLocalService.deleteHistManuals(histManualId);
	}

	/**
	* Deletes the hist manuals from the database. Also notifies the appropriate model listeners.
	*
	* @param histManuals the hist manuals
	* @return the hist manuals that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.HistManuals deleteHistManuals(
		com.ihg.brandstandards.db.model.HistManuals histManuals)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _histManualsLocalService.deleteHistManuals(histManuals);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _histManualsLocalService.dynamicQuery();
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
		return _histManualsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _histManualsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _histManualsLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _histManualsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _histManualsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.HistManuals fetchHistManuals(
		long histManualId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _histManualsLocalService.fetchHistManuals(histManualId);
	}

	/**
	* Returns the hist manuals with the primary key.
	*
	* @param histManualId the primary key of the hist manuals
	* @return the hist manuals
	* @throws PortalException if a hist manuals with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.HistManuals getHistManuals(
		long histManualId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _histManualsLocalService.getHistManuals(histManualId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _histManualsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the hist manualses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of hist manualses
	* @param end the upper bound of the range of hist manualses (not inclusive)
	* @return the range of hist manualses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.HistManuals> getHistManualses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _histManualsLocalService.getHistManualses(start, end);
	}

	/**
	* Returns the number of hist manualses.
	*
	* @return the number of hist manualses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getHistManualsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _histManualsLocalService.getHistManualsesCount();
	}

	/**
	* Updates the hist manuals in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param histManuals the hist manuals
	* @return the hist manuals that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.HistManuals updateHistManuals(
		com.ihg.brandstandards.db.model.HistManuals histManuals)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _histManualsLocalService.updateHistManuals(histManuals);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _histManualsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_histManualsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _histManualsLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.HistManuals> getManuals()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _histManualsLocalService.getManuals();
	}

	@Override
	public int getManualsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _histManualsLocalService.getManualsCount();
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.HistManuals> findHistoricalManualsByFilter(
		java.util.List<java.lang.String> brand,
		java.util.List<java.lang.String> region,
		java.util.List<java.lang.String> manualType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _histManualsLocalService.findHistoricalManualsByFilter(brand,
			region, manualType);
	}

	@Override
	public void clearCache() {
		_histManualsLocalService.clearCache();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public HistManualsLocalService getWrappedHistManualsLocalService() {
		return _histManualsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedHistManualsLocalService(
		HistManualsLocalService histManualsLocalService) {
		_histManualsLocalService = histManualsLocalService;
	}

	@Override
	public HistManualsLocalService getWrappedService() {
		return _histManualsLocalService;
	}

	@Override
	public void setWrappedService(
		HistManualsLocalService histManualsLocalService) {
		_histManualsLocalService = histManualsLocalService;
	}

	private HistManualsLocalService _histManualsLocalService;
}