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

import com.ihg.brandstandards.db.model.TaxonomyTranslate;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the taxonomy translate service. This utility wraps {@link TaxonomyTranslatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see TaxonomyTranslatePersistence
 * @see TaxonomyTranslatePersistenceImpl
 * @generated
 */
public class TaxonomyTranslateUtil {
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
	public static void clearCache(TaxonomyTranslate taxonomyTranslate) {
		getPersistence().clearCache(taxonomyTranslate);
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
	public static List<TaxonomyTranslate> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TaxonomyTranslate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TaxonomyTranslate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TaxonomyTranslate update(TaxonomyTranslate taxonomyTranslate)
		throws SystemException {
		return getPersistence().update(taxonomyTranslate);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TaxonomyTranslate update(
		TaxonomyTranslate taxonomyTranslate, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(taxonomyTranslate, serviceContext);
	}

	/**
	* Caches the taxonomy translate in the entity cache if it is enabled.
	*
	* @param taxonomyTranslate the taxonomy translate
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.TaxonomyTranslate taxonomyTranslate) {
		getPersistence().cacheResult(taxonomyTranslate);
	}

	/**
	* Caches the taxonomy translates in the entity cache if it is enabled.
	*
	* @param taxonomyTranslates the taxonomy translates
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.TaxonomyTranslate> taxonomyTranslates) {
		getPersistence().cacheResult(taxonomyTranslates);
	}

	/**
	* Creates a new taxonomy translate with the primary key. Does not add the taxonomy translate to the database.
	*
	* @param taxonomyTranslatePK the primary key for the new taxonomy translate
	* @return the new taxonomy translate
	*/
	public static com.ihg.brandstandards.db.model.TaxonomyTranslate create(
		com.ihg.brandstandards.db.service.persistence.TaxonomyTranslatePK taxonomyTranslatePK) {
		return getPersistence().create(taxonomyTranslatePK);
	}

	/**
	* Removes the taxonomy translate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taxonomyTranslatePK the primary key of the taxonomy translate
	* @return the taxonomy translate that was removed
	* @throws com.ihg.brandstandards.db.NoSuchTaxonomyTranslateException if a taxonomy translate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.TaxonomyTranslate remove(
		com.ihg.brandstandards.db.service.persistence.TaxonomyTranslatePK taxonomyTranslatePK)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyTranslateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(taxonomyTranslatePK);
	}

	public static com.ihg.brandstandards.db.model.TaxonomyTranslate updateImpl(
		com.ihg.brandstandards.db.model.TaxonomyTranslate taxonomyTranslate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(taxonomyTranslate);
	}

	/**
	* Returns the taxonomy translate with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchTaxonomyTranslateException} if it could not be found.
	*
	* @param taxonomyTranslatePK the primary key of the taxonomy translate
	* @return the taxonomy translate
	* @throws com.ihg.brandstandards.db.NoSuchTaxonomyTranslateException if a taxonomy translate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.TaxonomyTranslate findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.TaxonomyTranslatePK taxonomyTranslatePK)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyTranslateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(taxonomyTranslatePK);
	}

	/**
	* Returns the taxonomy translate with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param taxonomyTranslatePK the primary key of the taxonomy translate
	* @return the taxonomy translate, or <code>null</code> if a taxonomy translate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.TaxonomyTranslate fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.TaxonomyTranslatePK taxonomyTranslatePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(taxonomyTranslatePK);
	}

	/**
	* Returns all the taxonomy translates.
	*
	* @return the taxonomy translates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.TaxonomyTranslate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the taxonomy translates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of taxonomy translates
	* @param end the upper bound of the range of taxonomy translates (not inclusive)
	* @return the range of taxonomy translates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.TaxonomyTranslate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the taxonomy translates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of taxonomy translates
	* @param end the upper bound of the range of taxonomy translates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of taxonomy translates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.TaxonomyTranslate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the taxonomy translates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of taxonomy translates.
	*
	* @return the number of taxonomy translates
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TaxonomyTranslatePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TaxonomyTranslatePersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					TaxonomyTranslatePersistence.class.getName());

			ReferenceRegistry.registerReference(TaxonomyTranslateUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TaxonomyTranslatePersistence persistence) {
	}

	private static TaxonomyTranslatePersistence _persistence;
}