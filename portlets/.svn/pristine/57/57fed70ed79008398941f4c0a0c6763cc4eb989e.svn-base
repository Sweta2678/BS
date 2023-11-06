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
 * Provides a wrapper for {@link PublishDeptLocalService}.
 *
 * @author Mummanedi
 * @see PublishDeptLocalService
 * @generated
 */
public class PublishDeptLocalServiceWrapper implements PublishDeptLocalService,
	ServiceWrapper<PublishDeptLocalService> {
	public PublishDeptLocalServiceWrapper(
		PublishDeptLocalService publishDeptLocalService) {
		_publishDeptLocalService = publishDeptLocalService;
	}

	/**
	* Adds the publish dept to the database. Also notifies the appropriate model listeners.
	*
	* @param publishDept the publish dept
	* @return the publish dept that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishDept addPublishDept(
		com.ihg.brandstandards.db.model.PublishDept publishDept)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishDeptLocalService.addPublishDept(publishDept);
	}

	/**
	* Creates a new publish dept with the primary key. Does not add the publish dept to the database.
	*
	* @param publishDeptId the primary key for the new publish dept
	* @return the new publish dept
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishDept createPublishDept(
		long publishDeptId) {
		return _publishDeptLocalService.createPublishDept(publishDeptId);
	}

	/**
	* Deletes the publish dept with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param publishDeptId the primary key of the publish dept
	* @return the publish dept that was removed
	* @throws PortalException if a publish dept with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishDept deletePublishDept(
		long publishDeptId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishDeptLocalService.deletePublishDept(publishDeptId);
	}

	/**
	* Deletes the publish dept from the database. Also notifies the appropriate model listeners.
	*
	* @param publishDept the publish dept
	* @return the publish dept that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishDept deletePublishDept(
		com.ihg.brandstandards.db.model.PublishDept publishDept)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishDeptLocalService.deletePublishDept(publishDept);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _publishDeptLocalService.dynamicQuery();
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
		return _publishDeptLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishDeptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _publishDeptLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishDeptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _publishDeptLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _publishDeptLocalService.dynamicQueryCount(dynamicQuery);
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
		return _publishDeptLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.PublishDept fetchPublishDept(
		long publishDeptId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishDeptLocalService.fetchPublishDept(publishDeptId);
	}

	/**
	* Returns the publish dept with the primary key.
	*
	* @param publishDeptId the primary key of the publish dept
	* @return the publish dept
	* @throws PortalException if a publish dept with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishDept getPublishDept(
		long publishDeptId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishDeptLocalService.getPublishDept(publishDeptId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishDeptLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the publish depts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishDeptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of publish depts
	* @param end the upper bound of the range of publish depts (not inclusive)
	* @return the range of publish depts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.PublishDept> getPublishDepts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishDeptLocalService.getPublishDepts(start, end);
	}

	/**
	* Returns the number of publish depts.
	*
	* @return the number of publish depts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPublishDeptsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishDeptLocalService.getPublishDeptsCount();
	}

	/**
	* Updates the publish dept in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param publishDept the publish dept
	* @return the publish dept that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishDept updatePublishDept(
		com.ihg.brandstandards.db.model.PublishDept publishDept)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishDeptLocalService.updatePublishDept(publishDept);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _publishDeptLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_publishDeptLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _publishDeptLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void clearCache() {
		_publishDeptLocalService.clearCache();
	}

	/**
	* @param publishId
	* @param departmentId
	* @return PublishDept
	* @throws NoSuchPublishDeptException
	* @throws SystemException
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishDept getActivePublicationByDept(
		long publishId, long departmentId)
		throws com.ihg.brandstandards.db.NoSuchPublishDeptException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishDeptLocalService.getActivePublicationByDept(publishId,
			departmentId);
	}

	/**
	* @param departmentId
	* @param brandCode
	* @return Publication
	*/
	@Override
	public com.ihg.brandstandards.db.model.Publication getAcitveDepartmentPublication(
		long departmentId, java.lang.String brandCode) {
		return _publishDeptLocalService.getAcitveDepartmentPublication(departmentId,
			brandCode);
	}

	/**
	* @return PublishDept
	* @throws SystemException
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishDept createDeptPublication()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishDeptLocalService.createDeptPublication();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PublishDeptLocalService getWrappedPublishDeptLocalService() {
		return _publishDeptLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPublishDeptLocalService(
		PublishDeptLocalService publishDeptLocalService) {
		_publishDeptLocalService = publishDeptLocalService;
	}

	@Override
	public PublishDeptLocalService getWrappedService() {
		return _publishDeptLocalService;
	}

	@Override
	public void setWrappedService(
		PublishDeptLocalService publishDeptLocalService) {
		_publishDeptLocalService = publishDeptLocalService;
	}

	private PublishDeptLocalService _publishDeptLocalService;
}