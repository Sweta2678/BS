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

import com.ihg.brandstandards.db.model.GEMRole;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the g e m role service. This utility wraps {@link GEMRolePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMRolePersistence
 * @see GEMRolePersistenceImpl
 * @generated
 */
public class GEMRoleUtil {
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
	public static void clearCache(GEMRole gemRole) {
		getPersistence().clearCache(gemRole);
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
	public static List<GEMRole> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GEMRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GEMRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GEMRole update(GEMRole gemRole) throws SystemException {
		return getPersistence().update(gemRole);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GEMRole update(GEMRole gemRole, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(gemRole, serviceContext);
	}

	/**
	* Returns the g e m role where gemGrpCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchGEMRoleException} if it could not be found.
	*
	* @param gemGrpCode the gem grp code
	* @return the matching g e m role
	* @throws com.ihg.brandstandards.db.NoSuchGEMRoleException if a matching g e m role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMRole findByGemGrpCode(
		java.lang.String gemGrpCode)
		throws com.ihg.brandstandards.db.NoSuchGEMRoleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGemGrpCode(gemGrpCode);
	}

	/**
	* Returns the g e m role where gemGrpCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param gemGrpCode the gem grp code
	* @return the matching g e m role, or <code>null</code> if a matching g e m role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMRole fetchByGemGrpCode(
		java.lang.String gemGrpCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGemGrpCode(gemGrpCode);
	}

	/**
	* Returns the g e m role where gemGrpCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param gemGrpCode the gem grp code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching g e m role, or <code>null</code> if a matching g e m role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMRole fetchByGemGrpCode(
		java.lang.String gemGrpCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGemGrpCode(gemGrpCode, retrieveFromCache);
	}

	/**
	* Removes the g e m role where gemGrpCode = &#63; from the database.
	*
	* @param gemGrpCode the gem grp code
	* @return the g e m role that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMRole removeByGemGrpCode(
		java.lang.String gemGrpCode)
		throws com.ihg.brandstandards.db.NoSuchGEMRoleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByGemGrpCode(gemGrpCode);
	}

	/**
	* Returns the number of g e m roles where gemGrpCode = &#63;.
	*
	* @param gemGrpCode the gem grp code
	* @return the number of matching g e m roles
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGemGrpCode(java.lang.String gemGrpCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGemGrpCode(gemGrpCode);
	}

	/**
	* Caches the g e m role in the entity cache if it is enabled.
	*
	* @param gemRole the g e m role
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.GEMRole gemRole) {
		getPersistence().cacheResult(gemRole);
	}

	/**
	* Caches the g e m roles in the entity cache if it is enabled.
	*
	* @param gemRoles the g e m roles
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GEMRole> gemRoles) {
		getPersistence().cacheResult(gemRoles);
	}

	/**
	* Creates a new g e m role with the primary key. Does not add the g e m role to the database.
	*
	* @param gemGrpId the primary key for the new g e m role
	* @return the new g e m role
	*/
	public static com.ihg.brandstandards.db.model.GEMRole create(long gemGrpId) {
		return getPersistence().create(gemGrpId);
	}

	/**
	* Removes the g e m role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param gemGrpId the primary key of the g e m role
	* @return the g e m role that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGEMRoleException if a g e m role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMRole remove(long gemGrpId)
		throws com.ihg.brandstandards.db.NoSuchGEMRoleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(gemGrpId);
	}

	public static com.ihg.brandstandards.db.model.GEMRole updateImpl(
		com.ihg.brandstandards.db.model.GEMRole gemRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(gemRole);
	}

	/**
	* Returns the g e m role with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMRoleException} if it could not be found.
	*
	* @param gemGrpId the primary key of the g e m role
	* @return the g e m role
	* @throws com.ihg.brandstandards.db.NoSuchGEMRoleException if a g e m role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMRole findByPrimaryKey(
		long gemGrpId)
		throws com.ihg.brandstandards.db.NoSuchGEMRoleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(gemGrpId);
	}

	/**
	* Returns the g e m role with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param gemGrpId the primary key of the g e m role
	* @return the g e m role, or <code>null</code> if a g e m role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMRole fetchByPrimaryKey(
		long gemGrpId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(gemGrpId);
	}

	/**
	* Returns all the g e m roles.
	*
	* @return the g e m roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMRole> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the g e m roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m roles
	* @param end the upper bound of the range of g e m roles (not inclusive)
	* @return the range of g e m roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMRole> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the g e m roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m roles
	* @param end the upper bound of the range of g e m roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of g e m roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMRole> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the g e m roles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of g e m roles.
	*
	* @return the number of g e m roles
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GEMRolePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GEMRolePersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					GEMRolePersistence.class.getName());

			ReferenceRegistry.registerReference(GEMRoleUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GEMRolePersistence persistence) {
	}

	private static GEMRolePersistence _persistence;
}