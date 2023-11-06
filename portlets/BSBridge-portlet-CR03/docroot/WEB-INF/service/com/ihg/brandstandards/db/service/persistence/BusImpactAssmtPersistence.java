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

import com.ihg.brandstandards.db.model.BusImpactAssmt;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the bus impact assmt service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BusImpactAssmtPersistenceImpl
 * @see BusImpactAssmtUtil
 * @generated
 */
public interface BusImpactAssmtPersistence extends BasePersistence<BusImpactAssmt> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BusImpactAssmtUtil} to access the bus impact assmt persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the bus impact assmt in the entity cache if it is enabled.
	*
	* @param busImpactAssmt the bus impact assmt
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.BusImpactAssmt busImpactAssmt);

	/**
	* Caches the bus impact assmts in the entity cache if it is enabled.
	*
	* @param busImpactAssmts the bus impact assmts
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.BusImpactAssmt> busImpactAssmts);

	/**
	* Creates a new bus impact assmt with the primary key. Does not add the bus impact assmt to the database.
	*
	* @param busImpactAssmtId the primary key for the new bus impact assmt
	* @return the new bus impact assmt
	*/
	public com.ihg.brandstandards.db.model.BusImpactAssmt create(
		long busImpactAssmtId);

	/**
	* Removes the bus impact assmt with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param busImpactAssmtId the primary key of the bus impact assmt
	* @return the bus impact assmt that was removed
	* @throws com.ihg.brandstandards.db.NoSuchBusImpactAssmtException if a bus impact assmt with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BusImpactAssmt remove(
		long busImpactAssmtId)
		throws com.ihg.brandstandards.db.NoSuchBusImpactAssmtException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.BusImpactAssmt updateImpl(
		com.ihg.brandstandards.db.model.BusImpactAssmt busImpactAssmt)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bus impact assmt with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBusImpactAssmtException} if it could not be found.
	*
	* @param busImpactAssmtId the primary key of the bus impact assmt
	* @return the bus impact assmt
	* @throws com.ihg.brandstandards.db.NoSuchBusImpactAssmtException if a bus impact assmt with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BusImpactAssmt findByPrimaryKey(
		long busImpactAssmtId)
		throws com.ihg.brandstandards.db.NoSuchBusImpactAssmtException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bus impact assmt with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param busImpactAssmtId the primary key of the bus impact assmt
	* @return the bus impact assmt, or <code>null</code> if a bus impact assmt with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BusImpactAssmt fetchByPrimaryKey(
		long busImpactAssmtId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bus impact assmts.
	*
	* @return the bus impact assmts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BusImpactAssmt> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bus impact assmts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BusImpactAssmtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bus impact assmts
	* @param end the upper bound of the range of bus impact assmts (not inclusive)
	* @return the range of bus impact assmts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BusImpactAssmt> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bus impact assmts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BusImpactAssmtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bus impact assmts
	* @param end the upper bound of the range of bus impact assmts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bus impact assmts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BusImpactAssmt> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bus impact assmts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bus impact assmts.
	*
	* @return the number of bus impact assmts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}