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

import com.ihg.brandstandards.db.model.PublishCountryStandard;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the publish country standard service. This utility wraps {@link PublishCountryStandardPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see PublishCountryStandardPersistence
 * @see PublishCountryStandardPersistenceImpl
 * @generated
 */
public class PublishCountryStandardUtil {
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
	public static void clearCache(PublishCountryStandard publishCountryStandard) {
		getPersistence().clearCache(publishCountryStandard);
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
	public static List<PublishCountryStandard> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PublishCountryStandard> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PublishCountryStandard> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static PublishCountryStandard update(
		PublishCountryStandard publishCountryStandard)
		throws SystemException {
		return getPersistence().update(publishCountryStandard);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static PublishCountryStandard update(
		PublishCountryStandard publishCountryStandard,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(publishCountryStandard, serviceContext);
	}

	/**
	* Returns the publish country standard where publishVerId = &#63; and countryCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublishCountryStandardException} if it could not be found.
	*
	* @param publishVerId the publish ver ID
	* @param countryCode the country code
	* @return the matching publish country standard
	* @throws com.ihg.brandstandards.db.NoSuchPublishCountryStandardException if a matching publish country standard could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishCountryStandard findBypublishVerIdCountry(
		long publishVerId, java.lang.String countryCode)
		throws com.ihg.brandstandards.db.NoSuchPublishCountryStandardException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublishVerIdCountry(publishVerId, countryCode);
	}

	/**
	* Returns the publish country standard where publishVerId = &#63; and countryCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param publishVerId the publish ver ID
	* @param countryCode the country code
	* @return the matching publish country standard, or <code>null</code> if a matching publish country standard could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishCountryStandard fetchBypublishVerIdCountry(
		long publishVerId, java.lang.String countryCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBypublishVerIdCountry(publishVerId, countryCode);
	}

	/**
	* Returns the publish country standard where publishVerId = &#63; and countryCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param publishVerId the publish ver ID
	* @param countryCode the country code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching publish country standard, or <code>null</code> if a matching publish country standard could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishCountryStandard fetchBypublishVerIdCountry(
		long publishVerId, java.lang.String countryCode,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBypublishVerIdCountry(publishVerId, countryCode,
			retrieveFromCache);
	}

	/**
	* Removes the publish country standard where publishVerId = &#63; and countryCode = &#63; from the database.
	*
	* @param publishVerId the publish ver ID
	* @param countryCode the country code
	* @return the publish country standard that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishCountryStandard removeBypublishVerIdCountry(
		long publishVerId, java.lang.String countryCode)
		throws com.ihg.brandstandards.db.NoSuchPublishCountryStandardException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeBypublishVerIdCountry(publishVerId, countryCode);
	}

	/**
	* Returns the number of publish country standards where publishVerId = &#63; and countryCode = &#63;.
	*
	* @param publishVerId the publish ver ID
	* @param countryCode the country code
	* @return the number of matching publish country standards
	* @throws SystemException if a system exception occurred
	*/
	public static int countBypublishVerIdCountry(long publishVerId,
		java.lang.String countryCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBypublishVerIdCountry(publishVerId, countryCode);
	}

	/**
	* Returns the publish country standard where publishCountryStdId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublishCountryStandardException} if it could not be found.
	*
	* @param publishCountryStdId the publish country std ID
	* @return the matching publish country standard
	* @throws com.ihg.brandstandards.db.NoSuchPublishCountryStandardException if a matching publish country standard could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishCountryStandard findBypublishCountryStdId(
		java.lang.String publishCountryStdId)
		throws com.ihg.brandstandards.db.NoSuchPublishCountryStandardException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBypublishCountryStdId(publishCountryStdId);
	}

	/**
	* Returns the publish country standard where publishCountryStdId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param publishCountryStdId the publish country std ID
	* @return the matching publish country standard, or <code>null</code> if a matching publish country standard could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishCountryStandard fetchBypublishCountryStdId(
		java.lang.String publishCountryStdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBypublishCountryStdId(publishCountryStdId);
	}

	/**
	* Returns the publish country standard where publishCountryStdId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param publishCountryStdId the publish country std ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching publish country standard, or <code>null</code> if a matching publish country standard could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishCountryStandard fetchBypublishCountryStdId(
		java.lang.String publishCountryStdId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBypublishCountryStdId(publishCountryStdId,
			retrieveFromCache);
	}

	/**
	* Removes the publish country standard where publishCountryStdId = &#63; from the database.
	*
	* @param publishCountryStdId the publish country std ID
	* @return the publish country standard that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishCountryStandard removeBypublishCountryStdId(
		java.lang.String publishCountryStdId)
		throws com.ihg.brandstandards.db.NoSuchPublishCountryStandardException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeBypublishCountryStdId(publishCountryStdId);
	}

	/**
	* Returns the number of publish country standards where publishCountryStdId = &#63;.
	*
	* @param publishCountryStdId the publish country std ID
	* @return the number of matching publish country standards
	* @throws SystemException if a system exception occurred
	*/
	public static int countBypublishCountryStdId(
		java.lang.String publishCountryStdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBypublishCountryStdId(publishCountryStdId);
	}

	/**
	* Caches the publish country standard in the entity cache if it is enabled.
	*
	* @param publishCountryStandard the publish country standard
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.PublishCountryStandard publishCountryStandard) {
		getPersistence().cacheResult(publishCountryStandard);
	}

	/**
	* Caches the publish country standards in the entity cache if it is enabled.
	*
	* @param publishCountryStandards the publish country standards
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.PublishCountryStandard> publishCountryStandards) {
		getPersistence().cacheResult(publishCountryStandards);
	}

	/**
	* Creates a new publish country standard with the primary key. Does not add the publish country standard to the database.
	*
	* @param publishCountryStdId the primary key for the new publish country standard
	* @return the new publish country standard
	*/
	public static com.ihg.brandstandards.db.model.PublishCountryStandard create(
		java.lang.String publishCountryStdId) {
		return getPersistence().create(publishCountryStdId);
	}

	/**
	* Removes the publish country standard with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param publishCountryStdId the primary key of the publish country standard
	* @return the publish country standard that was removed
	* @throws com.ihg.brandstandards.db.NoSuchPublishCountryStandardException if a publish country standard with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishCountryStandard remove(
		java.lang.String publishCountryStdId)
		throws com.ihg.brandstandards.db.NoSuchPublishCountryStandardException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(publishCountryStdId);
	}

	public static com.ihg.brandstandards.db.model.PublishCountryStandard updateImpl(
		com.ihg.brandstandards.db.model.PublishCountryStandard publishCountryStandard)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(publishCountryStandard);
	}

	/**
	* Returns the publish country standard with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchPublishCountryStandardException} if it could not be found.
	*
	* @param publishCountryStdId the primary key of the publish country standard
	* @return the publish country standard
	* @throws com.ihg.brandstandards.db.NoSuchPublishCountryStandardException if a publish country standard with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishCountryStandard findByPrimaryKey(
		java.lang.String publishCountryStdId)
		throws com.ihg.brandstandards.db.NoSuchPublishCountryStandardException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(publishCountryStdId);
	}

	/**
	* Returns the publish country standard with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param publishCountryStdId the primary key of the publish country standard
	* @return the publish country standard, or <code>null</code> if a publish country standard with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishCountryStandard fetchByPrimaryKey(
		java.lang.String publishCountryStdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(publishCountryStdId);
	}

	/**
	* Returns all the publish country standards.
	*
	* @return the publish country standards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishCountryStandard> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the publish country standards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishCountryStandardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of publish country standards
	* @param end the upper bound of the range of publish country standards (not inclusive)
	* @return the range of publish country standards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishCountryStandard> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the publish country standards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishCountryStandardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of publish country standards
	* @param end the upper bound of the range of publish country standards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of publish country standards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishCountryStandard> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the publish country standards from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of publish country standards.
	*
	* @return the number of publish country standards
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PublishCountryStandardPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PublishCountryStandardPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					PublishCountryStandardPersistence.class.getName());

			ReferenceRegistry.registerReference(PublishCountryStandardUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PublishCountryStandardPersistence persistence) {
	}

	private static PublishCountryStandardPersistence _persistence;
}