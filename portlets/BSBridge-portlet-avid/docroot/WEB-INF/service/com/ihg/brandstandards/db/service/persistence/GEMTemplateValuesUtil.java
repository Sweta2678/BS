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

import com.ihg.brandstandards.db.model.GEMTemplateValues;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the g e m template values service. This utility wraps {@link GEMTemplateValuesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMTemplateValuesPersistence
 * @see GEMTemplateValuesPersistenceImpl
 * @generated
 */
public class GEMTemplateValuesUtil {
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
	public static void clearCache(GEMTemplateValues gemTemplateValues) {
		getPersistence().clearCache(gemTemplateValues);
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
	public static List<GEMTemplateValues> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GEMTemplateValues> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GEMTemplateValues> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GEMTemplateValues update(GEMTemplateValues gemTemplateValues)
		throws SystemException {
		return getPersistence().update(gemTemplateValues);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GEMTemplateValues update(
		GEMTemplateValues gemTemplateValues, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(gemTemplateValues, serviceContext);
	}

	/**
	* Caches the g e m template values in the entity cache if it is enabled.
	*
	* @param gemTemplateValues the g e m template values
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.GEMTemplateValues gemTemplateValues) {
		getPersistence().cacheResult(gemTemplateValues);
	}

	/**
	* Caches the g e m template valueses in the entity cache if it is enabled.
	*
	* @param gemTemplateValueses the g e m template valueses
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GEMTemplateValues> gemTemplateValueses) {
		getPersistence().cacheResult(gemTemplateValueses);
	}

	/**
	* Creates a new g e m template values with the primary key. Does not add the g e m template values to the database.
	*
	* @param valueId the primary key for the new g e m template values
	* @return the new g e m template values
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplateValues create(
		long valueId) {
		return getPersistence().create(valueId);
	}

	/**
	* Removes the g e m template values with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param valueId the primary key of the g e m template values
	* @return the g e m template values that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateValuesException if a g e m template values with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplateValues remove(
		long valueId)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateValuesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(valueId);
	}

	public static com.ihg.brandstandards.db.model.GEMTemplateValues updateImpl(
		com.ihg.brandstandards.db.model.GEMTemplateValues gemTemplateValues)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(gemTemplateValues);
	}

	/**
	* Returns the g e m template values with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMTemplateValuesException} if it could not be found.
	*
	* @param valueId the primary key of the g e m template values
	* @return the g e m template values
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateValuesException if a g e m template values with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplateValues findByPrimaryKey(
		long valueId)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateValuesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(valueId);
	}

	/**
	* Returns the g e m template values with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param valueId the primary key of the g e m template values
	* @return the g e m template values, or <code>null</code> if a g e m template values with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplateValues fetchByPrimaryKey(
		long valueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(valueId);
	}

	/**
	* Returns all the g e m template valueses.
	*
	* @return the g e m template valueses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplateValues> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the g e m template valueses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateValuesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m template valueses
	* @param end the upper bound of the range of g e m template valueses (not inclusive)
	* @return the range of g e m template valueses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplateValues> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the g e m template valueses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateValuesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m template valueses
	* @param end the upper bound of the range of g e m template valueses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of g e m template valueses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplateValues> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the g e m template valueses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of g e m template valueses.
	*
	* @return the number of g e m template valueses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GEMTemplateValuesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GEMTemplateValuesPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					GEMTemplateValuesPersistence.class.getName());

			ReferenceRegistry.registerReference(GEMTemplateValuesUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GEMTemplateValuesPersistence persistence) {
	}

	private static GEMTemplateValuesPersistence _persistence;
}