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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the g e m measurement formula value service. This utility wraps {@link GEMMeasurementFormulaValuePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMMeasurementFormulaValuePersistence
 * @see GEMMeasurementFormulaValuePersistenceImpl
 * @generated
 */
public class GEMMeasurementFormulaValueUtil {
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
	public static void clearCache(
		GEMMeasurementFormulaValue gemMeasurementFormulaValue) {
		getPersistence().clearCache(gemMeasurementFormulaValue);
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
	public static List<GEMMeasurementFormulaValue> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GEMMeasurementFormulaValue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GEMMeasurementFormulaValue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GEMMeasurementFormulaValue update(
		GEMMeasurementFormulaValue gemMeasurementFormulaValue)
		throws SystemException {
		return getPersistence().update(gemMeasurementFormulaValue);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GEMMeasurementFormulaValue update(
		GEMMeasurementFormulaValue gemMeasurementFormulaValue,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(gemMeasurementFormulaValue, serviceContext);
	}

	/**
	* Caches the g e m measurement formula value in the entity cache if it is enabled.
	*
	* @param gemMeasurementFormulaValue the g e m measurement formula value
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue gemMeasurementFormulaValue) {
		getPersistence().cacheResult(gemMeasurementFormulaValue);
	}

	/**
	* Caches the g e m measurement formula values in the entity cache if it is enabled.
	*
	* @param gemMeasurementFormulaValues the g e m measurement formula values
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue> gemMeasurementFormulaValues) {
		getPersistence().cacheResult(gemMeasurementFormulaValues);
	}

	/**
	* Creates a new g e m measurement formula value with the primary key. Does not add the g e m measurement formula value to the database.
	*
	* @param formulaValueId the primary key for the new g e m measurement formula value
	* @return the new g e m measurement formula value
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue create(
		long formulaValueId) {
		return getPersistence().create(formulaValueId);
	}

	/**
	* Removes the g e m measurement formula value with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param formulaValueId the primary key of the g e m measurement formula value
	* @return the g e m measurement formula value that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaValueException if a g e m measurement formula value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue remove(
		long formulaValueId)
		throws com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaValueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(formulaValueId);
	}

	public static com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue updateImpl(
		com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue gemMeasurementFormulaValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(gemMeasurementFormulaValue);
	}

	/**
	* Returns the g e m measurement formula value with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaValueException} if it could not be found.
	*
	* @param formulaValueId the primary key of the g e m measurement formula value
	* @return the g e m measurement formula value
	* @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaValueException if a g e m measurement formula value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue findByPrimaryKey(
		long formulaValueId)
		throws com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaValueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(formulaValueId);
	}

	/**
	* Returns the g e m measurement formula value with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param formulaValueId the primary key of the g e m measurement formula value
	* @return the g e m measurement formula value, or <code>null</code> if a g e m measurement formula value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue fetchByPrimaryKey(
		long formulaValueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(formulaValueId);
	}

	/**
	* Returns all the g e m measurement formula values.
	*
	* @return the g e m measurement formula values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the g e m measurement formula values from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of g e m measurement formula values.
	*
	* @return the number of g e m measurement formula values
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GEMMeasurementFormulaValuePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GEMMeasurementFormulaValuePersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					GEMMeasurementFormulaValuePersistence.class.getName());

			ReferenceRegistry.registerReference(GEMMeasurementFormulaValueUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		GEMMeasurementFormulaValuePersistence persistence) {
	}

	private static GEMMeasurementFormulaValuePersistence _persistence;
}