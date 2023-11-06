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

import com.ihg.brandstandards.db.model.GEMMeasurementFormula;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the g e m measurement formula service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMMeasurementFormulaPersistenceImpl
 * @see GEMMeasurementFormulaUtil
 * @generated
 */
public interface GEMMeasurementFormulaPersistence extends BasePersistence<GEMMeasurementFormula> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GEMMeasurementFormulaUtil} to access the g e m measurement formula persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the g e m measurement formula in the entity cache if it is enabled.
	*
	* @param gemMeasurementFormula the g e m measurement formula
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.GEMMeasurementFormula gemMeasurementFormula);

	/**
	* Caches the g e m measurement formulas in the entity cache if it is enabled.
	*
	* @param gemMeasurementFormulas the g e m measurement formulas
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GEMMeasurementFormula> gemMeasurementFormulas);

	/**
	* Creates a new g e m measurement formula with the primary key. Does not add the g e m measurement formula to the database.
	*
	* @param formulaId the primary key for the new g e m measurement formula
	* @return the new g e m measurement formula
	*/
	public com.ihg.brandstandards.db.model.GEMMeasurementFormula create(
		long formulaId);

	/**
	* Removes the g e m measurement formula with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param formulaId the primary key of the g e m measurement formula
	* @return the g e m measurement formula that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaException if a g e m measurement formula with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMMeasurementFormula remove(
		long formulaId)
		throws com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.GEMMeasurementFormula updateImpl(
		com.ihg.brandstandards.db.model.GEMMeasurementFormula gemMeasurementFormula)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m measurement formula with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaException} if it could not be found.
	*
	* @param formulaId the primary key of the g e m measurement formula
	* @return the g e m measurement formula
	* @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaException if a g e m measurement formula with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMMeasurementFormula findByPrimaryKey(
		long formulaId)
		throws com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m measurement formula with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param formulaId the primary key of the g e m measurement formula
	* @return the g e m measurement formula, or <code>null</code> if a g e m measurement formula with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMMeasurementFormula fetchByPrimaryKey(
		long formulaId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the g e m measurement formulas.
	*
	* @return the g e m measurement formulas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMMeasurementFormula> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the g e m measurement formulas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementFormulaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m measurement formulas
	* @param end the upper bound of the range of g e m measurement formulas (not inclusive)
	* @return the range of g e m measurement formulas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMMeasurementFormula> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the g e m measurement formulas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementFormulaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m measurement formulas
	* @param end the upper bound of the range of g e m measurement formulas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of g e m measurement formulas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMMeasurementFormula> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the g e m measurement formulas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m measurement formulas.
	*
	* @return the number of g e m measurement formulas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}