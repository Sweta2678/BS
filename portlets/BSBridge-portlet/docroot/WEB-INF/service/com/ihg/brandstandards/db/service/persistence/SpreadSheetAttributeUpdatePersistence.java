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

import com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the spread sheet attribute update service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see SpreadSheetAttributeUpdatePersistenceImpl
 * @see SpreadSheetAttributeUpdateUtil
 * @generated
 */
public interface SpreadSheetAttributeUpdatePersistence extends BasePersistence<SpreadSheetAttributeUpdate> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SpreadSheetAttributeUpdateUtil} to access the spread sheet attribute update persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the spread sheet attribute updates where status = &#63;.
	*
	* @param status the status
	* @return the matching spread sheet attribute updates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate> findBystatus(
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the spread sheet attribute updates where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpreadSheetAttributeUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of spread sheet attribute updates
	* @param end the upper bound of the range of spread sheet attribute updates (not inclusive)
	* @return the range of matching spread sheet attribute updates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate> findBystatus(
		java.lang.String status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the spread sheet attribute updates where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpreadSheetAttributeUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of spread sheet attribute updates
	* @param end the upper bound of the range of spread sheet attribute updates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching spread sheet attribute updates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate> findBystatus(
		java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first spread sheet attribute update in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching spread sheet attribute update
	* @throws com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException if a matching spread sheet attribute update could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate findBystatus_First(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first spread sheet attribute update in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching spread sheet attribute update, or <code>null</code> if a matching spread sheet attribute update could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate fetchBystatus_First(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last spread sheet attribute update in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching spread sheet attribute update
	* @throws com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException if a matching spread sheet attribute update could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate findBystatus_Last(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last spread sheet attribute update in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching spread sheet attribute update, or <code>null</code> if a matching spread sheet attribute update could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate fetchBystatus_Last(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the spread sheet attribute updates before and after the current spread sheet attribute update in the ordered set where status = &#63;.
	*
	* @param speardSheetId the primary key of the current spread sheet attribute update
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next spread sheet attribute update
	* @throws com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException if a spread sheet attribute update with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate[] findBystatus_PrevAndNext(
		long speardSheetId, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the spread sheet attribute updates where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeBystatus(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of spread sheet attribute updates where status = &#63;.
	*
	* @param status the status
	* @return the number of matching spread sheet attribute updates
	* @throws SystemException if a system exception occurred
	*/
	public int countBystatus(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the spread sheet attribute update in the entity cache if it is enabled.
	*
	* @param spreadSheetAttributeUpdate the spread sheet attribute update
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate spreadSheetAttributeUpdate);

	/**
	* Caches the spread sheet attribute updates in the entity cache if it is enabled.
	*
	* @param spreadSheetAttributeUpdates the spread sheet attribute updates
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate> spreadSheetAttributeUpdates);

	/**
	* Creates a new spread sheet attribute update with the primary key. Does not add the spread sheet attribute update to the database.
	*
	* @param speardSheetId the primary key for the new spread sheet attribute update
	* @return the new spread sheet attribute update
	*/
	public com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate create(
		long speardSheetId);

	/**
	* Removes the spread sheet attribute update with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param speardSheetId the primary key of the spread sheet attribute update
	* @return the spread sheet attribute update that was removed
	* @throws com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException if a spread sheet attribute update with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate remove(
		long speardSheetId)
		throws com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate updateImpl(
		com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate spreadSheetAttributeUpdate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the spread sheet attribute update with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException} if it could not be found.
	*
	* @param speardSheetId the primary key of the spread sheet attribute update
	* @return the spread sheet attribute update
	* @throws com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException if a spread sheet attribute update with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate findByPrimaryKey(
		long speardSheetId)
		throws com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the spread sheet attribute update with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param speardSheetId the primary key of the spread sheet attribute update
	* @return the spread sheet attribute update, or <code>null</code> if a spread sheet attribute update with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate fetchByPrimaryKey(
		long speardSheetId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the spread sheet attribute updates.
	*
	* @return the spread sheet attribute updates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the spread sheet attribute updates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpreadSheetAttributeUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of spread sheet attribute updates
	* @param end the upper bound of the range of spread sheet attribute updates (not inclusive)
	* @return the range of spread sheet attribute updates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the spread sheet attribute updates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpreadSheetAttributeUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of spread sheet attribute updates
	* @param end the upper bound of the range of spread sheet attribute updates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of spread sheet attribute updates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the spread sheet attribute updates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of spread sheet attribute updates.
	*
	* @return the number of spread sheet attribute updates
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}