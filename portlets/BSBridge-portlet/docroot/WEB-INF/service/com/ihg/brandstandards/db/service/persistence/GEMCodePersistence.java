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

import com.ihg.brandstandards.db.model.GEMCode;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the g e m code service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMCodePersistenceImpl
 * @see GEMCodeUtil
 * @generated
 */
public interface GEMCodePersistence extends BasePersistence<GEMCode> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GEMCodeUtil} to access the g e m code persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the g e m code in the entity cache if it is enabled.
	*
	* @param gemCode the g e m code
	*/
	public void cacheResult(com.ihg.brandstandards.db.model.GEMCode gemCode);

	/**
	* Caches the g e m codes in the entity cache if it is enabled.
	*
	* @param gemCodes the g e m codes
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GEMCode> gemCodes);

	/**
	* Creates a new g e m code with the primary key. Does not add the g e m code to the database.
	*
	* @param code the primary key for the new g e m code
	* @return the new g e m code
	*/
	public com.ihg.brandstandards.db.model.GEMCode create(java.lang.String code);

	/**
	* Removes the g e m code with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param code the primary key of the g e m code
	* @return the g e m code that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGEMCodeException if a g e m code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMCode remove(java.lang.String code)
		throws com.ihg.brandstandards.db.NoSuchGEMCodeException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.GEMCode updateImpl(
		com.ihg.brandstandards.db.model.GEMCode gemCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m code with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMCodeException} if it could not be found.
	*
	* @param code the primary key of the g e m code
	* @return the g e m code
	* @throws com.ihg.brandstandards.db.NoSuchGEMCodeException if a g e m code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMCode findByPrimaryKey(
		java.lang.String code)
		throws com.ihg.brandstandards.db.NoSuchGEMCodeException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m code with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param code the primary key of the g e m code
	* @return the g e m code, or <code>null</code> if a g e m code with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMCode fetchByPrimaryKey(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the g e m codes.
	*
	* @return the g e m codes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMCode> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the g e m codes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m codes
	* @param end the upper bound of the range of g e m codes (not inclusive)
	* @return the range of g e m codes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMCode> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the g e m codes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m codes
	* @param end the upper bound of the range of g e m codes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of g e m codes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMCode> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the g e m codes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m codes.
	*
	* @return the number of g e m codes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}