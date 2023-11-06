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
 * Provides a wrapper for {@link DepartmentLocalService}.
 *
 * @author Mummanedi
 * @see DepartmentLocalService
 * @generated
 */
public class DepartmentLocalServiceWrapper implements DepartmentLocalService,
	ServiceWrapper<DepartmentLocalService> {
	public DepartmentLocalServiceWrapper(
		DepartmentLocalService departmentLocalService) {
		_departmentLocalService = departmentLocalService;
	}

	/**
	* Adds the department to the database. Also notifies the appropriate model listeners.
	*
	* @param department the department
	* @return the department that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.Department addDepartment(
		com.ihg.brandstandards.db.model.Department department)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _departmentLocalService.addDepartment(department);
	}

	/**
	* Creates a new department with the primary key. Does not add the department to the database.
	*
	* @param departmentId the primary key for the new department
	* @return the new department
	*/
	@Override
	public com.ihg.brandstandards.db.model.Department createDepartment(
		long departmentId) {
		return _departmentLocalService.createDepartment(departmentId);
	}

	/**
	* Deletes the department with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param departmentId the primary key of the department
	* @return the department that was removed
	* @throws PortalException if a department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.Department deleteDepartment(
		long departmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _departmentLocalService.deleteDepartment(departmentId);
	}

	/**
	* Deletes the department from the database. Also notifies the appropriate model listeners.
	*
	* @param department the department
	* @return the department that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.Department deleteDepartment(
		com.ihg.brandstandards.db.model.Department department)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _departmentLocalService.deleteDepartment(department);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _departmentLocalService.dynamicQuery();
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
		return _departmentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _departmentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _departmentLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _departmentLocalService.dynamicQueryCount(dynamicQuery);
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
		return _departmentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.Department fetchDepartment(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _departmentLocalService.fetchDepartment(departmentId);
	}

	/**
	* Returns the department with the primary key.
	*
	* @param departmentId the primary key of the department
	* @return the department
	* @throws PortalException if a department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.Department getDepartment(
		long departmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _departmentLocalService.getDepartment(departmentId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _departmentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the departments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @return the range of departments
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Department> getDepartments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _departmentLocalService.getDepartments(start, end);
	}

	/**
	* Returns the number of departments.
	*
	* @return the number of departments
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDepartmentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _departmentLocalService.getDepartmentsCount();
	}

	/**
	* Updates the department in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param department the department
	* @return the department that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.Department updateDepartment(
		com.ihg.brandstandards.db.model.Department department)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _departmentLocalService.updateDepartment(department);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _departmentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_departmentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _departmentLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* @param activeInd
	* @return List<Department>
	* @throws SystemException
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Department> getActiveDepartments(
		java.lang.String activeInd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _departmentLocalService.getActiveDepartments(activeInd);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Department> getActiveDepartments(
		java.lang.String activeInd, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _departmentLocalService.getActiveDepartments(activeInd, start,
			end, orderByComparator);
	}

	@Override
	public com.ihg.brandstandards.db.model.Department createDepartment()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _departmentLocalService.createDepartment();
	}

	@Override
	public java.util.List<java.lang.Object> getPublicationActiveDepartment(
		long departmentId, java.lang.String activeInd) {
		return _departmentLocalService.getPublicationActiveDepartment(departmentId,
			activeInd);
	}

	@Override
	public com.ihg.brandstandards.db.model.Department getActiveDepartmentByName(
		java.lang.String deptName, java.lang.String activeInd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _departmentLocalService.getActiveDepartmentByName(deptName,
			activeInd);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DepartmentLocalService getWrappedDepartmentLocalService() {
		return _departmentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDepartmentLocalService(
		DepartmentLocalService departmentLocalService) {
		_departmentLocalService = departmentLocalService;
	}

	@Override
	public DepartmentLocalService getWrappedService() {
		return _departmentLocalService;
	}

	@Override
	public void setWrappedService(DepartmentLocalService departmentLocalService) {
		_departmentLocalService = departmentLocalService;
	}

	private DepartmentLocalService _departmentLocalService;
}