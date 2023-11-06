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

import com.ihg.brandstandards.db.model.GEMMeasurementType;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the g e m measurement type service. This utility wraps {@link GEMMeasurementTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMMeasurementTypePersistence
 * @see GEMMeasurementTypePersistenceImpl
 * @generated
 */
public class GEMMeasurementTypeUtil {
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
	public static void clearCache(GEMMeasurementType gemMeasurementType) {
		getPersistence().clearCache(gemMeasurementType);
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
	public static List<GEMMeasurementType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GEMMeasurementType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GEMMeasurementType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GEMMeasurementType update(
		GEMMeasurementType gemMeasurementType) throws SystemException {
		return getPersistence().update(gemMeasurementType);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GEMMeasurementType update(
		GEMMeasurementType gemMeasurementType, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(gemMeasurementType, serviceContext);
	}

	/**
	* Caches the g e m measurement type in the entity cache if it is enabled.
	*
	* @param gemMeasurementType the g e m measurement type
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.GEMMeasurementType gemMeasurementType) {
		getPersistence().cacheResult(gemMeasurementType);
	}

	/**
	* Caches the g e m measurement types in the entity cache if it is enabled.
	*
	* @param gemMeasurementTypes the g e m measurement types
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GEMMeasurementType> gemMeasurementTypes) {
		getPersistence().cacheResult(gemMeasurementTypes);
	}

	/**
	* Creates a new g e m measurement type with the primary key. Does not add the g e m measurement type to the database.
	*
	* @param measurementType the primary key for the new g e m measurement type
	* @return the new g e m measurement type
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurementType create(
		java.lang.String measurementType) {
		return getPersistence().create(measurementType);
	}

	/**
	* Removes the g e m measurement type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param measurementType the primary key of the g e m measurement type
	* @return the g e m measurement type that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementTypeException if a g e m measurement type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurementType remove(
		java.lang.String measurementType)
		throws com.ihg.brandstandards.db.NoSuchGEMMeasurementTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(measurementType);
	}

	public static com.ihg.brandstandards.db.model.GEMMeasurementType updateImpl(
		com.ihg.brandstandards.db.model.GEMMeasurementType gemMeasurementType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(gemMeasurementType);
	}

	/**
	* Returns the g e m measurement type with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMMeasurementTypeException} if it could not be found.
	*
	* @param measurementType the primary key of the g e m measurement type
	* @return the g e m measurement type
	* @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementTypeException if a g e m measurement type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurementType findByPrimaryKey(
		java.lang.String measurementType)
		throws com.ihg.brandstandards.db.NoSuchGEMMeasurementTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(measurementType);
	}

	/**
	* Returns the g e m measurement type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param measurementType the primary key of the g e m measurement type
	* @return the g e m measurement type, or <code>null</code> if a g e m measurement type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurementType fetchByPrimaryKey(
		java.lang.String measurementType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(measurementType);
	}

	/**
	* Returns all the g e m measurement types.
	*
	* @return the g e m measurement types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMMeasurementType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the g e m measurement types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m measurement types
	* @param end the upper bound of the range of g e m measurement types (not inclusive)
	* @return the range of g e m measurement types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMMeasurementType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the g e m measurement types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m measurement types
	* @param end the upper bound of the range of g e m measurement types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of g e m measurement types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMMeasurementType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the g e m measurement types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of g e m measurement types.
	*
	* @return the number of g e m measurement types
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GEMMeasurementTypePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GEMMeasurementTypePersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					GEMMeasurementTypePersistence.class.getName());

			ReferenceRegistry.registerReference(GEMMeasurementTypeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GEMMeasurementTypePersistence persistence) {
	}

	private static GEMMeasurementTypePersistence _persistence;
}