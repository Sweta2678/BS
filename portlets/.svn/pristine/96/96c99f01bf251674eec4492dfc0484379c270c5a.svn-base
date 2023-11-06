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

import com.ihg.brandstandards.db.model.TaxonomyStandards;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the taxonomy standards service. This utility wraps {@link TaxonomyStandardsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see TaxonomyStandardsPersistence
 * @see TaxonomyStandardsPersistenceImpl
 * @generated
 */
public class TaxonomyStandardsUtil {
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
	public static void clearCache(TaxonomyStandards taxonomyStandards) {
		getPersistence().clearCache(taxonomyStandards);
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
	public static List<TaxonomyStandards> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TaxonomyStandards> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TaxonomyStandards> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TaxonomyStandards update(TaxonomyStandards taxonomyStandards)
		throws SystemException {
		return getPersistence().update(taxonomyStandards);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TaxonomyStandards update(
		TaxonomyStandards taxonomyStandards, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(taxonomyStandards, serviceContext);
	}

	/**
	* Returns the taxonomy standards where stdId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchTaxonomyStandardsException} if it could not be found.
	*
	* @param stdId the std ID
	* @return the matching taxonomy standards
	* @throws com.ihg.brandstandards.db.NoSuchTaxonomyStandardsException if a matching taxonomy standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.TaxonomyStandards findByStdId(
		long stdId)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId(stdId);
	}

	/**
	* Returns the taxonomy standards where stdId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param stdId the std ID
	* @return the matching taxonomy standards, or <code>null</code> if a matching taxonomy standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.TaxonomyStandards fetchByStdId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStdId(stdId);
	}

	/**
	* Returns the taxonomy standards where stdId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param stdId the std ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching taxonomy standards, or <code>null</code> if a matching taxonomy standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.TaxonomyStandards fetchByStdId(
		long stdId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStdId(stdId, retrieveFromCache);
	}

	/**
	* Removes the taxonomy standards where stdId = &#63; from the database.
	*
	* @param stdId the std ID
	* @return the taxonomy standards that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.TaxonomyStandards removeByStdId(
		long stdId)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByStdId(stdId);
	}

	/**
	* Returns the number of taxonomy standardses where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the number of matching taxonomy standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStdId(stdId);
	}

	/**
	* Caches the taxonomy standards in the entity cache if it is enabled.
	*
	* @param taxonomyStandards the taxonomy standards
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.TaxonomyStandards taxonomyStandards) {
		getPersistence().cacheResult(taxonomyStandards);
	}

	/**
	* Caches the taxonomy standardses in the entity cache if it is enabled.
	*
	* @param taxonomyStandardses the taxonomy standardses
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.TaxonomyStandards> taxonomyStandardses) {
		getPersistence().cacheResult(taxonomyStandardses);
	}

	/**
	* Creates a new taxonomy standards with the primary key. Does not add the taxonomy standards to the database.
	*
	* @param stdId the primary key for the new taxonomy standards
	* @return the new taxonomy standards
	*/
	public static com.ihg.brandstandards.db.model.TaxonomyStandards create(
		long stdId) {
		return getPersistence().create(stdId);
	}

	/**
	* Removes the taxonomy standards with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stdId the primary key of the taxonomy standards
	* @return the taxonomy standards that was removed
	* @throws com.ihg.brandstandards.db.NoSuchTaxonomyStandardsException if a taxonomy standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.TaxonomyStandards remove(
		long stdId)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(stdId);
	}

	public static com.ihg.brandstandards.db.model.TaxonomyStandards updateImpl(
		com.ihg.brandstandards.db.model.TaxonomyStandards taxonomyStandards)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(taxonomyStandards);
	}

	/**
	* Returns the taxonomy standards with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchTaxonomyStandardsException} if it could not be found.
	*
	* @param stdId the primary key of the taxonomy standards
	* @return the taxonomy standards
	* @throws com.ihg.brandstandards.db.NoSuchTaxonomyStandardsException if a taxonomy standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.TaxonomyStandards findByPrimaryKey(
		long stdId)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(stdId);
	}

	/**
	* Returns the taxonomy standards with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param stdId the primary key of the taxonomy standards
	* @return the taxonomy standards, or <code>null</code> if a taxonomy standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.TaxonomyStandards fetchByPrimaryKey(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(stdId);
	}

	/**
	* Returns all the taxonomy standardses.
	*
	* @return the taxonomy standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.TaxonomyStandards> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the taxonomy standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of taxonomy standardses
	* @param end the upper bound of the range of taxonomy standardses (not inclusive)
	* @return the range of taxonomy standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.TaxonomyStandards> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the taxonomy standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of taxonomy standardses
	* @param end the upper bound of the range of taxonomy standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of taxonomy standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.TaxonomyStandards> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the taxonomy standardses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of taxonomy standardses.
	*
	* @return the number of taxonomy standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TaxonomyStandardsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TaxonomyStandardsPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					TaxonomyStandardsPersistence.class.getName());

			ReferenceRegistry.registerReference(TaxonomyStandardsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TaxonomyStandardsPersistence persistence) {
	}

	private static TaxonomyStandardsPersistence _persistence;
}