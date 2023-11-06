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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the g e m role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMRolePersistenceImpl
 * @see GEMRoleUtil
 * @generated
 */
public interface GEMRolePersistence extends BasePersistence<GEMRole> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GEMRoleUtil} to access the g e m role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the g e m role where gemGrpCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchGEMRoleException} if it could not be found.
	*
	* @param gemGrpCode the gem grp code
	* @return the matching g e m role
	* @throws com.ihg.brandstandards.db.NoSuchGEMRoleException if a matching g e m role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMRole findByGemGrpCode(
		java.lang.String gemGrpCode)
		throws com.ihg.brandstandards.db.NoSuchGEMRoleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m role where gemGrpCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param gemGrpCode the gem grp code
	* @return the matching g e m role, or <code>null</code> if a matching g e m role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMRole fetchByGemGrpCode(
		java.lang.String gemGrpCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m role where gemGrpCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param gemGrpCode the gem grp code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching g e m role, or <code>null</code> if a matching g e m role could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMRole fetchByGemGrpCode(
		java.lang.String gemGrpCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the g e m role where gemGrpCode = &#63; from the database.
	*
	* @param gemGrpCode the gem grp code
	* @return the g e m role that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMRole removeByGemGrpCode(
		java.lang.String gemGrpCode)
		throws com.ihg.brandstandards.db.NoSuchGEMRoleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m roles where gemGrpCode = &#63;.
	*
	* @param gemGrpCode the gem grp code
	* @return the number of matching g e m roles
	* @throws SystemException if a system exception occurred
	*/
	public int countByGemGrpCode(java.lang.String gemGrpCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the g e m role in the entity cache if it is enabled.
	*
	* @param gemRole the g e m role
	*/
	public void cacheResult(com.ihg.brandstandards.db.model.GEMRole gemRole);

	/**
	* Caches the g e m roles in the entity cache if it is enabled.
	*
	* @param gemRoles the g e m roles
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GEMRole> gemRoles);

	/**
	* Creates a new g e m role with the primary key. Does not add the g e m role to the database.
	*
	* @param gemGrpId the primary key for the new g e m role
	* @return the new g e m role
	*/
	public com.ihg.brandstandards.db.model.GEMRole create(long gemGrpId);

	/**
	* Removes the g e m role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param gemGrpId the primary key of the g e m role
	* @return the g e m role that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGEMRoleException if a g e m role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMRole remove(long gemGrpId)
		throws com.ihg.brandstandards.db.NoSuchGEMRoleException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.GEMRole updateImpl(
		com.ihg.brandstandards.db.model.GEMRole gemRole)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m role with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMRoleException} if it could not be found.
	*
	* @param gemGrpId the primary key of the g e m role
	* @return the g e m role
	* @throws com.ihg.brandstandards.db.NoSuchGEMRoleException if a g e m role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMRole findByPrimaryKey(
		long gemGrpId)
		throws com.ihg.brandstandards.db.NoSuchGEMRoleException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m role with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param gemGrpId the primary key of the g e m role
	* @return the g e m role, or <code>null</code> if a g e m role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMRole fetchByPrimaryKey(
		long gemGrpId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the g e m roles.
	*
	* @return the g e m roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMRole> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.GEMRole> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.GEMRole> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the g e m roles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m roles.
	*
	* @return the number of g e m roles
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}