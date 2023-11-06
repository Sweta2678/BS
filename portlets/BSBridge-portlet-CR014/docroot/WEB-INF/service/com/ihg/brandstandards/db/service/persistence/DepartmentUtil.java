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

package com.ihg.brandstandards.db.service.persistence;

import com.ihg.brandstandards.db.model.Department;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the department service. This utility wraps {@link DepartmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see DepartmentPersistence
 * @see DepartmentPersistenceImpl
 * @generated
 */
public class DepartmentUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Department department) {
		getPersistence().clearCache(department);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Department> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Department> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Department> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Department update(Department department)
		throws SystemException {
		return getPersistence().update(department);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Department update(Department department,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(department, serviceContext);
	}

	/**
	* Returns all the departments where activeInd = &#63;.
	*
	* @param activeInd the active ind
	* @return the matching departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Department> findByActiveIndicator(
		java.lang.String activeInd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByActiveIndicator(activeInd);
	}

	/**
	* Returns a range of all the departments where activeInd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param activeInd the active ind
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @return the range of matching departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Department> findByActiveIndicator(
		java.lang.String activeInd, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByActiveIndicator(activeInd, start, end);
	}

	/**
	* Returns an ordered range of all the departments where activeInd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param activeInd the active ind
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Department> findByActiveIndicator(
		java.lang.String activeInd, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByActiveIndicator(activeInd, start, end,
			orderByComparator);
	}

	/**
	* Returns the first department in the ordered set where activeInd = &#63;.
	*
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching department
	* @throws com.ihg.brandstandards.db.NoSuchDepartmentException if a matching department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Department findByActiveIndicator_First(
		java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchDepartmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByActiveIndicator_First(activeInd, orderByComparator);
	}

	/**
	* Returns the first department in the ordered set where activeInd = &#63;.
	*
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching department, or <code>null</code> if a matching department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Department fetchByActiveIndicator_First(
		java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByActiveIndicator_First(activeInd, orderByComparator);
	}

	/**
	* Returns the last department in the ordered set where activeInd = &#63;.
	*
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching department
	* @throws com.ihg.brandstandards.db.NoSuchDepartmentException if a matching department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Department findByActiveIndicator_Last(
		java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchDepartmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByActiveIndicator_Last(activeInd, orderByComparator);
	}

	/**
	* Returns the last department in the ordered set where activeInd = &#63;.
	*
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching department, or <code>null</code> if a matching department could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Department fetchByActiveIndicator_Last(
		java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByActiveIndicator_Last(activeInd, orderByComparator);
	}

	/**
	* Returns the departments before and after the current department in the ordered set where activeInd = &#63;.
	*
	* @param departmentId the primary key of the current department
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next department
	* @throws com.ihg.brandstandards.db.NoSuchDepartmentException if a department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Department[] findByActiveIndicator_PrevAndNext(
		long departmentId, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchDepartmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByActiveIndicator_PrevAndNext(departmentId, activeInd,
			orderByComparator);
	}

	/**
	* Removes all the departments where activeInd = &#63; from the database.
	*
	* @param activeInd the active ind
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByActiveIndicator(java.lang.String activeInd)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByActiveIndicator(activeInd);
	}

	/**
	* Returns the number of departments where activeInd = &#63;.
	*
	* @param activeInd the active ind
	* @return the number of matching departments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByActiveIndicator(java.lang.String activeInd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByActiveIndicator(activeInd);
	}

	/**
	* Caches the department in the entity cache if it is enabled.
	*
	* @param department the department
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.Department department) {
		getPersistence().cacheResult(department);
	}

	/**
	* Caches the departments in the entity cache if it is enabled.
	*
	* @param departments the departments
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.Department> departments) {
		getPersistence().cacheResult(departments);
	}

	/**
	* Creates a new department with the primary key. Does not add the department to the database.
	*
	* @param departmentId the primary key for the new department
	* @return the new department
	*/
	public static com.ihg.brandstandards.db.model.Department create(
		long departmentId) {
		return getPersistence().create(departmentId);
	}

	/**
	* Removes the department with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param departmentId the primary key of the department
	* @return the department that was removed
	* @throws com.ihg.brandstandards.db.NoSuchDepartmentException if a department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Department remove(
		long departmentId)
		throws com.ihg.brandstandards.db.NoSuchDepartmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(departmentId);
	}

	public static com.ihg.brandstandards.db.model.Department updateImpl(
		com.ihg.brandstandards.db.model.Department department)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(department);
	}

	/**
	* Returns the department with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchDepartmentException} if it could not be found.
	*
	* @param departmentId the primary key of the department
	* @return the department
	* @throws com.ihg.brandstandards.db.NoSuchDepartmentException if a department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Department findByPrimaryKey(
		long departmentId)
		throws com.ihg.brandstandards.db.NoSuchDepartmentException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(departmentId);
	}

	/**
	* Returns the department with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param departmentId the primary key of the department
	* @return the department, or <code>null</code> if a department with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Department fetchByPrimaryKey(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(departmentId);
	}

	/**
	* Returns all the departments.
	*
	* @return the departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Department> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.ihg.brandstandards.db.model.Department> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the departments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of departments
	* @param end the upper bound of the range of departments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of departments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Department> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the departments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of departments.
	*
	* @return the number of departments
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DepartmentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DepartmentPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					DepartmentPersistence.class.getName());

			ReferenceRegistry.registerReference(DepartmentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DepartmentPersistence persistence) {
	}

	private static DepartmentPersistence _persistence;
}