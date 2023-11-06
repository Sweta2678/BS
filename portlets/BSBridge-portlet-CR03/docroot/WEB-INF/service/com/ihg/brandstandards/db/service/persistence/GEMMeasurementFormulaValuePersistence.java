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

import com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the g e m measurement formula value service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMMeasurementFormulaValuePersistenceImpl
 * @see GEMMeasurementFormulaValueUtil
 * @generated
 */
public interface GEMMeasurementFormulaValuePersistence extends BasePersistence<GEMMeasurementFormulaValue> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GEMMeasurementFormulaValueUtil} to access the g e m measurement formula value persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the g e m measurement formula value in the entity cache if it is enabled.
	*
	* @param gemMeasurementFormulaValue the g e m measurement formula value
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue gemMeasurementFormulaValue);

	/**
	* Caches the g e m measurement formula values in the entity cache if it is enabled.
	*
	* @param gemMeasurementFormulaValues the g e m measurement formula values
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue> gemMeasurementFormulaValues);

	/**
	* Creates a new g e m measurement formula value with the primary key. Does not add the g e m measurement formula value to the database.
	*
	* @param formulaValueId the primary key for the new g e m measurement formula value
	* @return the new g e m measurement formula value
	*/
	public com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue create(
		long formulaValueId);

	/**
	* Removes the g e m measurement formula value with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param formulaValueId the primary key of the g e m measurement formula value
	* @return the g e m measurement formula value that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaValueException if a g e m measurement formula value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue remove(
		long formulaValueId)
		throws com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaValueException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue updateImpl(
		com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue gemMeasurementFormulaValue)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m measurement formula value with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaValueException} if it could not be found.
	*
	* @param formulaValueId the primary key of the g e m measurement formula value
	* @return the g e m measurement formula value
	* @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaValueException if a g e m measurement formula value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue findByPrimaryKey(
		long formulaValueId)
		throws com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaValueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m measurement formula value with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param formulaValueId the primary key of the g e m measurement formula value
	* @return the g e m measurement formula value, or <code>null</code> if a g e m measurement formula value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue fetchByPrimaryKey(
		long formulaValueId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the g e m measurement formula values.
	*
	* @return the g e m measurement formula values
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the g e m measurement formula values.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementFormulaValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m measurement formula values
	* @param end the upper bound of the range of g e m measurement formula values (not inclusive)
	* @return the range of g e m measurement formula values
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the g e m measurement formula values.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementFormulaValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m measurement formula values
	* @param end the upper bound of the range of g e m measurement formula values (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of g e m measurement formula values
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the g e m measurement formula values from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m measurement formula values.
	*
	* @return the number of g e m measurement formula values
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}