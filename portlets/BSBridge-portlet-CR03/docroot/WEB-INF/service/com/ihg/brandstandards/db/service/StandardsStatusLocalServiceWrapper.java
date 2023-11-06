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
 * Provides a wrapper for {@link StandardsStatusLocalService}.
 *
 * @author Mummanedi
 * @see StandardsStatusLocalService
 * @generated
 */
public class StandardsStatusLocalServiceWrapper
	implements StandardsStatusLocalService,
		ServiceWrapper<StandardsStatusLocalService> {
	public StandardsStatusLocalServiceWrapper(
		StandardsStatusLocalService standardsStatusLocalService) {
		_standardsStatusLocalService = standardsStatusLocalService;
	}

	/**
	* Adds the standards status to the database. Also notifies the appropriate model listeners.
	*
	* @param standardsStatus the standards status
	* @return the standards status that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsStatus addStandardsStatus(
		com.ihg.brandstandards.db.model.StandardsStatus standardsStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsStatusLocalService.addStandardsStatus(standardsStatus);
	}

	/**
	* Creates a new standards status with the primary key. Does not add the standards status to the database.
	*
	* @param statusId the primary key for the new standards status
	* @return the new standards status
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsStatus createStandardsStatus(
		long statusId) {
		return _standardsStatusLocalService.createStandardsStatus(statusId);
	}

	/**
	* Deletes the standards status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param statusId the primary key of the standards status
	* @return the standards status that was removed
	* @throws PortalException if a standards status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsStatus deleteStandardsStatus(
		long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsStatusLocalService.deleteStandardsStatus(statusId);
	}

	/**
	* Deletes the standards status from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsStatus the standards status
	* @return the standards status that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsStatus deleteStandardsStatus(
		com.ihg.brandstandards.db.model.StandardsStatus standardsStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsStatusLocalService.deleteStandardsStatus(standardsStatus);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _standardsStatusLocalService.dynamicQuery();
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
		return _standardsStatusLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _standardsStatusLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _standardsStatusLocalService.dynamicQuery(dynamicQuery, start,
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
		return _standardsStatusLocalService.dynamicQueryCount(dynamicQuery);
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
		return _standardsStatusLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsStatus fetchStandardsStatus(
		long statusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsStatusLocalService.fetchStandardsStatus(statusId);
	}

	/**
	* Returns the standards status with the primary key.
	*
	* @param statusId the primary key of the standards status
	* @return the standards status
	* @throws PortalException if a standards status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsStatus getStandardsStatus(
		long statusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsStatusLocalService.getStandardsStatus(statusId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsStatusLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the standards statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards statuses
	* @param end the upper bound of the range of standards statuses (not inclusive)
	* @return the range of standards statuses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsStatus> getStandardsStatuses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsStatusLocalService.getStandardsStatuses(start, end);
	}

	/**
	* Returns the number of standards statuses.
	*
	* @return the number of standards statuses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getStandardsStatusesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsStatusLocalService.getStandardsStatusesCount();
	}

	/**
	* Updates the standards status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param standardsStatus the standards status
	* @return the standards status that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsStatus updateStandardsStatus(
		com.ihg.brandstandards.db.model.StandardsStatus standardsStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsStatusLocalService.updateStandardsStatus(standardsStatus);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _standardsStatusLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_standardsStatusLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _standardsStatusLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void clearCache() {
		_standardsStatusLocalService.clearCache();
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsStatus getStandardsStatusObject() {
		return _standardsStatusLocalService.getStandardsStatusObject();
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsStatus> getStatusesByRegionCode(
		long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsStatusLocalService.getStatusesByRegionCode(regionId);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsStatus> getStatusesByStatusCode(
		java.lang.String statusCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsStatusLocalService.getStatusesByStatusCode(statusCode);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public StandardsStatusLocalService getWrappedStandardsStatusLocalService() {
		return _standardsStatusLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedStandardsStatusLocalService(
		StandardsStatusLocalService standardsStatusLocalService) {
		_standardsStatusLocalService = standardsStatusLocalService;
	}

	@Override
	public StandardsStatusLocalService getWrappedService() {
		return _standardsStatusLocalService;
	}

	@Override
	public void setWrappedService(
		StandardsStatusLocalService standardsStatusLocalService) {
		_standardsStatusLocalService = standardsStatusLocalService;
	}

	private StandardsStatusLocalService _standardsStatusLocalService;
}