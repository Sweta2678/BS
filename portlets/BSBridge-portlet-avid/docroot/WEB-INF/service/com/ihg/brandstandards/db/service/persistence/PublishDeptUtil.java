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

import com.ihg.brandstandards.db.model.PublishDept;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the publish dept service. This utility wraps {@link PublishDeptPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see PublishDeptPersistence
 * @see PublishDeptPersistenceImpl
 * @generated
 */
public class PublishDeptUtil {
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
	public static void clearCache(PublishDept publishDept) {
		getPersistence().clearCache(publishDept);
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
	public static List<PublishDept> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PublishDept> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PublishDept> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static PublishDept update(PublishDept publishDept)
		throws SystemException {
		return getPersistence().update(publishDept);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static PublishDept update(PublishDept publishDept,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(publishDept, serviceContext);
	}

	/**
	* Returns the publish dept where publishId = &#63; and deptId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublishDeptException} if it could not be found.
	*
	* @param publishId the publish ID
	* @param deptId the dept ID
	* @return the matching publish dept
	* @throws com.ihg.brandstandards.db.NoSuchPublishDeptException if a matching publish dept could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishDept findByPublicationAndDept(
		long publishId, long deptId)
		throws com.ihg.brandstandards.db.NoSuchPublishDeptException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPublicationAndDept(publishId, deptId);
	}

	/**
	* Returns the publish dept where publishId = &#63; and deptId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param publishId the publish ID
	* @param deptId the dept ID
	* @return the matching publish dept, or <code>null</code> if a matching publish dept could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishDept fetchByPublicationAndDept(
		long publishId, long deptId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPublicationAndDept(publishId, deptId);
	}

	/**
	* Returns the publish dept where publishId = &#63; and deptId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param publishId the publish ID
	* @param deptId the dept ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching publish dept, or <code>null</code> if a matching publish dept could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishDept fetchByPublicationAndDept(
		long publishId, long deptId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublicationAndDept(publishId, deptId,
			retrieveFromCache);
	}

	/**
	* Removes the publish dept where publishId = &#63; and deptId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param deptId the dept ID
	* @return the publish dept that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishDept removeByPublicationAndDept(
		long publishId, long deptId)
		throws com.ihg.brandstandards.db.NoSuchPublishDeptException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByPublicationAndDept(publishId, deptId);
	}

	/**
	* Returns the number of publish depts where publishId = &#63; and deptId = &#63;.
	*
	* @param publishId the publish ID
	* @param deptId the dept ID
	* @return the number of matching publish depts
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPublicationAndDept(long publishId, long deptId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPublicationAndDept(publishId, deptId);
	}

	/**
	* Caches the publish dept in the entity cache if it is enabled.
	*
	* @param publishDept the publish dept
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.PublishDept publishDept) {
		getPersistence().cacheResult(publishDept);
	}

	/**
	* Caches the publish depts in the entity cache if it is enabled.
	*
	* @param publishDepts the publish depts
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.PublishDept> publishDepts) {
		getPersistence().cacheResult(publishDepts);
	}

	/**
	* Creates a new publish dept with the primary key. Does not add the publish dept to the database.
	*
	* @param publishDeptId the primary key for the new publish dept
	* @return the new publish dept
	*/
	public static com.ihg.brandstandards.db.model.PublishDept create(
		long publishDeptId) {
		return getPersistence().create(publishDeptId);
	}

	/**
	* Removes the publish dept with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param publishDeptId the primary key of the publish dept
	* @return the publish dept that was removed
	* @throws com.ihg.brandstandards.db.NoSuchPublishDeptException if a publish dept with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishDept remove(
		long publishDeptId)
		throws com.ihg.brandstandards.db.NoSuchPublishDeptException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(publishDeptId);
	}

	public static com.ihg.brandstandards.db.model.PublishDept updateImpl(
		com.ihg.brandstandards.db.model.PublishDept publishDept)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(publishDept);
	}

	/**
	* Returns the publish dept with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchPublishDeptException} if it could not be found.
	*
	* @param publishDeptId the primary key of the publish dept
	* @return the publish dept
	* @throws com.ihg.brandstandards.db.NoSuchPublishDeptException if a publish dept with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishDept findByPrimaryKey(
		long publishDeptId)
		throws com.ihg.brandstandards.db.NoSuchPublishDeptException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(publishDeptId);
	}

	/**
	* Returns the publish dept with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param publishDeptId the primary key of the publish dept
	* @return the publish dept, or <code>null</code> if a publish dept with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishDept fetchByPrimaryKey(
		long publishDeptId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(publishDeptId);
	}

	/**
	* Returns all the publish depts.
	*
	* @return the publish depts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishDept> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.ihg.brandstandards.db.model.PublishDept> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the publish depts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishDeptModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of publish depts
	* @param end the upper bound of the range of publish depts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of publish depts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishDept> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the publish depts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of publish depts.
	*
	* @return the number of publish depts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PublishDeptPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PublishDeptPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					PublishDeptPersistence.class.getName());

			ReferenceRegistry.registerReference(PublishDeptUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PublishDeptPersistence persistence) {
	}

	private static PublishDeptPersistence _persistence;
}