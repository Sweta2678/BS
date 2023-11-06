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

import com.ihg.brandstandards.db.model.StandardsCountryExt;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the standards country ext service. This utility wraps {@link StandardsCountryExtPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsCountryExtPersistence
 * @see StandardsCountryExtPersistenceImpl
 * @generated
 */
public class StandardsCountryExtUtil {
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
	public static void clearCache(StandardsCountryExt standardsCountryExt) {
		getPersistence().clearCache(standardsCountryExt);
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
	public static List<StandardsCountryExt> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StandardsCountryExt> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StandardsCountryExt> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static StandardsCountryExt update(
		StandardsCountryExt standardsCountryExt) throws SystemException {
		return getPersistence().update(standardsCountryExt);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static StandardsCountryExt update(
		StandardsCountryExt standardsCountryExt, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(standardsCountryExt, serviceContext);
	}

	/**
	* Caches the standards country ext in the entity cache if it is enabled.
	*
	* @param standardsCountryExt the standards country ext
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.StandardsCountryExt standardsCountryExt) {
		getPersistence().cacheResult(standardsCountryExt);
	}

	/**
	* Caches the standards country exts in the entity cache if it is enabled.
	*
	* @param standardsCountryExts the standards country exts
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.StandardsCountryExt> standardsCountryExts) {
		getPersistence().cacheResult(standardsCountryExts);
	}

	/**
	* Creates a new standards country ext with the primary key. Does not add the standards country ext to the database.
	*
	* @param rowNum the primary key for the new standards country ext
	* @return the new standards country ext
	*/
	public static com.ihg.brandstandards.db.model.StandardsCountryExt create(
		long rowNum) {
		return getPersistence().create(rowNum);
	}

	/**
	* Removes the standards country ext with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rowNum the primary key of the standards country ext
	* @return the standards country ext that was removed
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCountryExtException if a standards country ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCountryExt remove(
		long rowNum)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryExtException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(rowNum);
	}

	public static com.ihg.brandstandards.db.model.StandardsCountryExt updateImpl(
		com.ihg.brandstandards.db.model.StandardsCountryExt standardsCountryExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(standardsCountryExt);
	}

	/**
	* Returns the standards country ext with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsCountryExtException} if it could not be found.
	*
	* @param rowNum the primary key of the standards country ext
	* @return the standards country ext
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCountryExtException if a standards country ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCountryExt findByPrimaryKey(
		long rowNum)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryExtException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(rowNum);
	}

	/**
	* Returns the standards country ext with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param rowNum the primary key of the standards country ext
	* @return the standards country ext, or <code>null</code> if a standards country ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCountryExt fetchByPrimaryKey(
		long rowNum) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(rowNum);
	}

	/**
	* Returns all the standards country exts.
	*
	* @return the standards country exts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCountryExt> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the standards country exts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards country exts
	* @param end the upper bound of the range of standards country exts (not inclusive)
	* @return the range of standards country exts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCountryExt> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the standards country exts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards country exts
	* @param end the upper bound of the range of standards country exts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of standards country exts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCountryExt> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the standards country exts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of standards country exts.
	*
	* @return the number of standards country exts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StandardsCountryExtPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StandardsCountryExtPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					StandardsCountryExtPersistence.class.getName());

			ReferenceRegistry.registerReference(StandardsCountryExtUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(StandardsCountryExtPersistence persistence) {
	}

	private static StandardsCountryExtPersistence _persistence;
}