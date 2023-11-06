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

import com.ihg.brandstandards.db.model.HistManuals;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the hist manuals service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see HistManualsPersistenceImpl
 * @see HistManualsUtil
 * @generated
 */
public interface HistManualsPersistence extends BasePersistence<HistManuals> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HistManualsUtil} to access the hist manuals persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the hist manuals in the entity cache if it is enabled.
	*
	* @param histManuals the hist manuals
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.HistManuals histManuals);

	/**
	* Caches the hist manualses in the entity cache if it is enabled.
	*
	* @param histManualses the hist manualses
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.HistManuals> histManualses);

	/**
	* Creates a new hist manuals with the primary key. Does not add the hist manuals to the database.
	*
	* @param histManualId the primary key for the new hist manuals
	* @return the new hist manuals
	*/
	public com.ihg.brandstandards.db.model.HistManuals create(long histManualId);

	/**
	* Removes the hist manuals with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param histManualId the primary key of the hist manuals
	* @return the hist manuals that was removed
	* @throws com.ihg.brandstandards.db.NoSuchHistManualsException if a hist manuals with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.HistManuals remove(long histManualId)
		throws com.ihg.brandstandards.db.NoSuchHistManualsException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.HistManuals updateImpl(
		com.ihg.brandstandards.db.model.HistManuals histManuals)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the hist manuals with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchHistManualsException} if it could not be found.
	*
	* @param histManualId the primary key of the hist manuals
	* @return the hist manuals
	* @throws com.ihg.brandstandards.db.NoSuchHistManualsException if a hist manuals with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.HistManuals findByPrimaryKey(
		long histManualId)
		throws com.ihg.brandstandards.db.NoSuchHistManualsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the hist manuals with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param histManualId the primary key of the hist manuals
	* @return the hist manuals, or <code>null</code> if a hist manuals with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.HistManuals fetchByPrimaryKey(
		long histManualId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the hist manualses.
	*
	* @return the hist manualses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.HistManuals> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the hist manualses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of hist manualses
	* @param end the upper bound of the range of hist manualses (not inclusive)
	* @return the range of hist manualses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.HistManuals> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the hist manualses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of hist manualses
	* @param end the upper bound of the range of hist manualses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of hist manualses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.HistManuals> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the hist manualses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of hist manualses.
	*
	* @return the number of hist manualses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}