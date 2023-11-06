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
 * Provides a wrapper for {@link MustPublishLocalService}.
 *
 * @author Mummanedi
 * @see MustPublishLocalService
 * @generated
 */
public class MustPublishLocalServiceWrapper implements MustPublishLocalService,
	ServiceWrapper<MustPublishLocalService> {
	public MustPublishLocalServiceWrapper(
		MustPublishLocalService mustPublishLocalService) {
		_mustPublishLocalService = mustPublishLocalService;
	}

	/**
	* Adds the must publish to the database. Also notifies the appropriate model listeners.
	*
	* @param mustPublish the must publish
	* @return the must publish that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.MustPublish addMustPublish(
		com.ihg.brandstandards.db.model.MustPublish mustPublish)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mustPublishLocalService.addMustPublish(mustPublish);
	}

	/**
	* Creates a new must publish with the primary key. Does not add the must publish to the database.
	*
	* @param stdId the primary key for the new must publish
	* @return the new must publish
	*/
	@Override
	public com.ihg.brandstandards.db.model.MustPublish createMustPublish(
		long stdId) {
		return _mustPublishLocalService.createMustPublish(stdId);
	}

	/**
	* Deletes the must publish with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stdId the primary key of the must publish
	* @return the must publish that was removed
	* @throws PortalException if a must publish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.MustPublish deleteMustPublish(
		long stdId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mustPublishLocalService.deleteMustPublish(stdId);
	}

	/**
	* Deletes the must publish from the database. Also notifies the appropriate model listeners.
	*
	* @param mustPublish the must publish
	* @return the must publish that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.MustPublish deleteMustPublish(
		com.ihg.brandstandards.db.model.MustPublish mustPublish)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mustPublishLocalService.deleteMustPublish(mustPublish);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _mustPublishLocalService.dynamicQuery();
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
		return _mustPublishLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.MustPublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _mustPublishLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.MustPublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _mustPublishLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _mustPublishLocalService.dynamicQueryCount(dynamicQuery);
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
		return _mustPublishLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.MustPublish fetchMustPublish(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return _mustPublishLocalService.fetchMustPublish(stdId);
	}

	/**
	* Returns the must publish with the primary key.
	*
	* @param stdId the primary key of the must publish
	* @return the must publish
	* @throws PortalException if a must publish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.MustPublish getMustPublish(
		long stdId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mustPublishLocalService.getMustPublish(stdId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mustPublishLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the must publishs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.MustPublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of must publishs
	* @param end the upper bound of the range of must publishs (not inclusive)
	* @return the range of must publishs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.MustPublish> getMustPublishs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mustPublishLocalService.getMustPublishs(start, end);
	}

	/**
	* Returns the number of must publishs.
	*
	* @return the number of must publishs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMustPublishsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mustPublishLocalService.getMustPublishsCount();
	}

	/**
	* Updates the must publish in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param mustPublish the must publish
	* @return the must publish that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.MustPublish updateMustPublish(
		com.ihg.brandstandards.db.model.MustPublish mustPublish)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mustPublishLocalService.updateMustPublish(mustPublish);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _mustPublishLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_mustPublishLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _mustPublishLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void clearCache() {
		_mustPublishLocalService.clearCache();
	}

	/**
	* @param query
	* @return boolean
	*/
	@Override
	public boolean deleteRegionalRecordCountries(java.lang.String query) {
		return _mustPublishLocalService.deleteRegionalRecordCountries(query);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MustPublishLocalService getWrappedMustPublishLocalService() {
		return _mustPublishLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMustPublishLocalService(
		MustPublishLocalService mustPublishLocalService) {
		_mustPublishLocalService = mustPublishLocalService;
	}

	@Override
	public MustPublishLocalService getWrappedService() {
		return _mustPublishLocalService;
	}

	@Override
	public void setWrappedService(
		MustPublishLocalService mustPublishLocalService) {
		_mustPublishLocalService = mustPublishLocalService;
	}

	private MustPublishLocalService _mustPublishLocalService;
}