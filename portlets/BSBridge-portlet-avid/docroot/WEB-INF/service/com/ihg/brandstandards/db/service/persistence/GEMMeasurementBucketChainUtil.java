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

import com.ihg.brandstandards.db.model.GEMMeasurementBucketChain;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the g e m measurement bucket chain service. This utility wraps {@link GEMMeasurementBucketChainPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMMeasurementBucketChainPersistence
 * @see GEMMeasurementBucketChainPersistenceImpl
 * @generated
 */
public class GEMMeasurementBucketChainUtil {
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
		GEMMeasurementBucketChain gemMeasurementBucketChain) {
		getPersistence().clearCache(gemMeasurementBucketChain);
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
	public static List<GEMMeasurementBucketChain> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GEMMeasurementBucketChain> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GEMMeasurementBucketChain> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GEMMeasurementBucketChain update(
		GEMMeasurementBucketChain gemMeasurementBucketChain)
		throws SystemException {
		return getPersistence().update(gemMeasurementBucketChain);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GEMMeasurementBucketChain update(
		GEMMeasurementBucketChain gemMeasurementBucketChain,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(gemMeasurementBucketChain, serviceContext);
	}

	/**
	* Caches the g e m measurement bucket chain in the entity cache if it is enabled.
	*
	* @param gemMeasurementBucketChain the g e m measurement bucket chain
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.GEMMeasurementBucketChain gemMeasurementBucketChain) {
		getPersistence().cacheResult(gemMeasurementBucketChain);
	}

	/**
	* Caches the g e m measurement bucket chains in the entity cache if it is enabled.
	*
	* @param gemMeasurementBucketChains the g e m measurement bucket chains
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GEMMeasurementBucketChain> gemMeasurementBucketChains) {
		getPersistence().cacheResult(gemMeasurementBucketChains);
	}

	/**
	* Creates a new g e m measurement bucket chain with the primary key. Does not add the g e m measurement bucket chain to the database.
	*
	* @param measurementBucketChainId the primary key for the new g e m measurement bucket chain
	* @return the new g e m measurement bucket chain
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurementBucketChain create(
		long measurementBucketChainId) {
		return getPersistence().create(measurementBucketChainId);
	}

	/**
	* Removes the g e m measurement bucket chain with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param measurementBucketChainId the primary key of the g e m measurement bucket chain
	* @return the g e m measurement bucket chain that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementBucketChainException if a g e m measurement bucket chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurementBucketChain remove(
		long measurementBucketChainId)
		throws com.ihg.brandstandards.db.NoSuchGEMMeasurementBucketChainException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(measurementBucketChainId);
	}

	public static com.ihg.brandstandards.db.model.GEMMeasurementBucketChain updateImpl(
		com.ihg.brandstandards.db.model.GEMMeasurementBucketChain gemMeasurementBucketChain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(gemMeasurementBucketChain);
	}

	/**
	* Returns the g e m measurement bucket chain with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMMeasurementBucketChainException} if it could not be found.
	*
	* @param measurementBucketChainId the primary key of the g e m measurement bucket chain
	* @return the g e m measurement bucket chain
	* @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementBucketChainException if a g e m measurement bucket chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurementBucketChain findByPrimaryKey(
		long measurementBucketChainId)
		throws com.ihg.brandstandards.db.NoSuchGEMMeasurementBucketChainException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(measurementBucketChainId);
	}

	/**
	* Returns the g e m measurement bucket chain with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param measurementBucketChainId the primary key of the g e m measurement bucket chain
	* @return the g e m measurement bucket chain, or <code>null</code> if a g e m measurement bucket chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurementBucketChain fetchByPrimaryKey(
		long measurementBucketChainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(measurementBucketChainId);
	}

	/**
	* Returns all the g e m measurement bucket chains.
	*
	* @return the g e m measurement bucket chains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMMeasurementBucketChain> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the g e m measurement bucket chains.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementBucketChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m measurement bucket chains
	* @param end the upper bound of the range of g e m measurement bucket chains (not inclusive)
	* @return the range of g e m measurement bucket chains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMMeasurementBucketChain> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the g e m measurement bucket chains.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementBucketChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m measurement bucket chains
	* @param end the upper bound of the range of g e m measurement bucket chains (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of g e m measurement bucket chains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMMeasurementBucketChain> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the g e m measurement bucket chains from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of g e m measurement bucket chains.
	*
	* @return the number of g e m measurement bucket chains
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GEMMeasurementBucketChainPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GEMMeasurementBucketChainPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					GEMMeasurementBucketChainPersistence.class.getName());

			ReferenceRegistry.registerReference(GEMMeasurementBucketChainUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GEMMeasurementBucketChainPersistence persistence) {
	}

	private static GEMMeasurementBucketChainPersistence _persistence;
}