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
 * Provides a wrapper for {@link HistManualRegionLocalService}.
 *
 * @author Mummanedi
 * @see HistManualRegionLocalService
 * @generated
 */
public class HistManualRegionLocalServiceWrapper
	implements HistManualRegionLocalService,
		ServiceWrapper<HistManualRegionLocalService> {
	public HistManualRegionLocalServiceWrapper(
		HistManualRegionLocalService histManualRegionLocalService) {
		_histManualRegionLocalService = histManualRegionLocalService;
	}

	/**
	* Adds the hist manual region to the database. Also notifies the appropriate model listeners.
	*
	* @param histManualRegion the hist manual region
	* @return the hist manual region that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.HistManualRegion addHistManualRegion(
		com.ihg.brandstandards.db.model.HistManualRegion histManualRegion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _histManualRegionLocalService.addHistManualRegion(histManualRegion);
	}

	/**
	* Creates a new hist manual region with the primary key. Does not add the hist manual region to the database.
	*
	* @param histManualRegionPK the primary key for the new hist manual region
	* @return the new hist manual region
	*/
	@Override
	public com.ihg.brandstandards.db.model.HistManualRegion createHistManualRegion(
		com.ihg.brandstandards.db.service.persistence.HistManualRegionPK histManualRegionPK) {
		return _histManualRegionLocalService.createHistManualRegion(histManualRegionPK);
	}

	/**
	* Deletes the hist manual region with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param histManualRegionPK the primary key of the hist manual region
	* @return the hist manual region that was removed
	* @throws PortalException if a hist manual region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.HistManualRegion deleteHistManualRegion(
		com.ihg.brandstandards.db.service.persistence.HistManualRegionPK histManualRegionPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _histManualRegionLocalService.deleteHistManualRegion(histManualRegionPK);
	}

	/**
	* Deletes the hist manual region from the database. Also notifies the appropriate model listeners.
	*
	* @param histManualRegion the hist manual region
	* @return the hist manual region that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.HistManualRegion deleteHistManualRegion(
		com.ihg.brandstandards.db.model.HistManualRegion histManualRegion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _histManualRegionLocalService.deleteHistManualRegion(histManualRegion);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _histManualRegionLocalService.dynamicQuery();
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
		return _histManualRegionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _histManualRegionLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _histManualRegionLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _histManualRegionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _histManualRegionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.HistManualRegion fetchHistManualRegion(
		com.ihg.brandstandards.db.service.persistence.HistManualRegionPK histManualRegionPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _histManualRegionLocalService.fetchHistManualRegion(histManualRegionPK);
	}

	/**
	* Returns the hist manual region with the primary key.
	*
	* @param histManualRegionPK the primary key of the hist manual region
	* @return the hist manual region
	* @throws PortalException if a hist manual region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.HistManualRegion getHistManualRegion(
		com.ihg.brandstandards.db.service.persistence.HistManualRegionPK histManualRegionPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _histManualRegionLocalService.getHistManualRegion(histManualRegionPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _histManualRegionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the hist manual regions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of hist manual regions
	* @param end the upper bound of the range of hist manual regions (not inclusive)
	* @return the range of hist manual regions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.HistManualRegion> getHistManualRegions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _histManualRegionLocalService.getHistManualRegions(start, end);
	}

	/**
	* Returns the number of hist manual regions.
	*
	* @return the number of hist manual regions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getHistManualRegionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _histManualRegionLocalService.getHistManualRegionsCount();
	}

	/**
	* Updates the hist manual region in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param histManualRegion the hist manual region
	* @return the hist manual region that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.HistManualRegion updateHistManualRegion(
		com.ihg.brandstandards.db.model.HistManualRegion histManualRegion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _histManualRegionLocalService.updateHistManualRegion(histManualRegion);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _histManualRegionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_histManualRegionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _histManualRegionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.ihg.brandstandards.db.model.HistManualRegion getHistManualRegionObject() {
		return _histManualRegionLocalService.getHistManualRegionObject();
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.HistManualRegion> getManualRegionById(
		long manualId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _histManualRegionLocalService.getManualRegionById(manualId);
	}

	@Override
	public void clearCache() {
		_histManualRegionLocalService.clearCache();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public HistManualRegionLocalService getWrappedHistManualRegionLocalService() {
		return _histManualRegionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedHistManualRegionLocalService(
		HistManualRegionLocalService histManualRegionLocalService) {
		_histManualRegionLocalService = histManualRegionLocalService;
	}

	@Override
	public HistManualRegionLocalService getWrappedService() {
		return _histManualRegionLocalService;
	}

	@Override
	public void setWrappedService(
		HistManualRegionLocalService histManualRegionLocalService) {
		_histManualRegionLocalService = histManualRegionLocalService;
	}

	private HistManualRegionLocalService _histManualRegionLocalService;
}