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

import com.ihg.brandstandards.db.model.StandardsCompliance;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the standards compliance service. This utility wraps {@link StandardsCompliancePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsCompliancePersistence
 * @see StandardsCompliancePersistenceImpl
 * @generated
 */
public class StandardsComplianceUtil {
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
	public static void clearCache(StandardsCompliance standardsCompliance) {
		getPersistence().clearCache(standardsCompliance);
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
	public static List<StandardsCompliance> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StandardsCompliance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StandardsCompliance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static StandardsCompliance update(
		StandardsCompliance standardsCompliance) throws SystemException {
		return getPersistence().update(standardsCompliance);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static StandardsCompliance update(
		StandardsCompliance standardsCompliance, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(standardsCompliance, serviceContext);
	}

	/**
	* Returns all the standards compliances where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @return the matching standards compliances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCompliance> findByStdChain(
		long stdId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdChain(stdId, chainCode);
	}

	/**
	* Returns a range of all the standards compliances where stdId = &#63; and chainCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsComplianceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param start the lower bound of the range of standards compliances
	* @param end the upper bound of the range of standards compliances (not inclusive)
	* @return the range of matching standards compliances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCompliance> findByStdChain(
		long stdId, java.lang.String chainCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdChain(stdId, chainCode, start, end);
	}

	/**
	* Returns an ordered range of all the standards compliances where stdId = &#63; and chainCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsComplianceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param start the lower bound of the range of standards compliances
	* @param end the upper bound of the range of standards compliances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standards compliances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCompliance> findByStdChain(
		long stdId, java.lang.String chainCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdChain(stdId, chainCode, start, end,
			orderByComparator);
	}

	/**
	* Returns the first standards compliance in the ordered set where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards compliance
	* @throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException if a matching standards compliance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCompliance findByStdChain_First(
		long stdId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdChain_First(stdId, chainCode, orderByComparator);
	}

	/**
	* Returns the first standards compliance in the ordered set where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards compliance, or <code>null</code> if a matching standards compliance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCompliance fetchByStdChain_First(
		long stdId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStdChain_First(stdId, chainCode, orderByComparator);
	}

	/**
	* Returns the last standards compliance in the ordered set where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards compliance
	* @throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException if a matching standards compliance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCompliance findByStdChain_Last(
		long stdId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdChain_Last(stdId, chainCode, orderByComparator);
	}

	/**
	* Returns the last standards compliance in the ordered set where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards compliance, or <code>null</code> if a matching standards compliance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCompliance fetchByStdChain_Last(
		long stdId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStdChain_Last(stdId, chainCode, orderByComparator);
	}

	/**
	* Returns the standards compliances before and after the current standards compliance in the ordered set where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdComplianceId the primary key of the current standards compliance
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards compliance
	* @throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException if a standards compliance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCompliance[] findByStdChain_PrevAndNext(
		long stdComplianceId, long stdId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdChain_PrevAndNext(stdComplianceId, stdId,
			chainCode, orderByComparator);
	}

	/**
	* Removes all the standards compliances where stdId = &#63; and chainCode = &#63; from the database.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStdChain(long stdId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStdChain(stdId, chainCode);
	}

	/**
	* Returns the number of standards compliances where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @return the number of matching standards compliances
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStdChain(long stdId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStdChain(stdId, chainCode);
	}

	/**
	* Returns the standards compliance where stdId = &#63; and chainCode = &#63; and countryCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsComplianceException} if it could not be found.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param countryCode the country code
	* @return the matching standards compliance
	* @throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException if a matching standards compliance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCompliance findByStdChainCountry(
		long stdId, java.lang.String chainCode, java.lang.String countryCode)
		throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdChainCountry(stdId, chainCode, countryCode);
	}

	/**
	* Returns the standards compliance where stdId = &#63; and chainCode = &#63; and countryCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param countryCode the country code
	* @return the matching standards compliance, or <code>null</code> if a matching standards compliance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCompliance fetchByStdChainCountry(
		long stdId, java.lang.String chainCode, java.lang.String countryCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStdChainCountry(stdId, chainCode, countryCode);
	}

	/**
	* Returns the standards compliance where stdId = &#63; and chainCode = &#63; and countryCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param countryCode the country code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching standards compliance, or <code>null</code> if a matching standards compliance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCompliance fetchByStdChainCountry(
		long stdId, java.lang.String chainCode, java.lang.String countryCode,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStdChainCountry(stdId, chainCode, countryCode,
			retrieveFromCache);
	}

	/**
	* Removes the standards compliance where stdId = &#63; and chainCode = &#63; and countryCode = &#63; from the database.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param countryCode the country code
	* @return the standards compliance that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCompliance removeByStdChainCountry(
		long stdId, java.lang.String chainCode, java.lang.String countryCode)
		throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByStdChainCountry(stdId, chainCode, countryCode);
	}

	/**
	* Returns the number of standards compliances where stdId = &#63; and chainCode = &#63; and countryCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param countryCode the country code
	* @return the number of matching standards compliances
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStdChainCountry(long stdId,
		java.lang.String chainCode, java.lang.String countryCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByStdChainCountry(stdId, chainCode, countryCode);
	}

	/**
	* Caches the standards compliance in the entity cache if it is enabled.
	*
	* @param standardsCompliance the standards compliance
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.StandardsCompliance standardsCompliance) {
		getPersistence().cacheResult(standardsCompliance);
	}

	/**
	* Caches the standards compliances in the entity cache if it is enabled.
	*
	* @param standardsCompliances the standards compliances
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.StandardsCompliance> standardsCompliances) {
		getPersistence().cacheResult(standardsCompliances);
	}

	/**
	* Creates a new standards compliance with the primary key. Does not add the standards compliance to the database.
	*
	* @param stdComplianceId the primary key for the new standards compliance
	* @return the new standards compliance
	*/
	public static com.ihg.brandstandards.db.model.StandardsCompliance create(
		long stdComplianceId) {
		return getPersistence().create(stdComplianceId);
	}

	/**
	* Removes the standards compliance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stdComplianceId the primary key of the standards compliance
	* @return the standards compliance that was removed
	* @throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException if a standards compliance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCompliance remove(
		long stdComplianceId)
		throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(stdComplianceId);
	}

	public static com.ihg.brandstandards.db.model.StandardsCompliance updateImpl(
		com.ihg.brandstandards.db.model.StandardsCompliance standardsCompliance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(standardsCompliance);
	}

	/**
	* Returns the standards compliance with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsComplianceException} if it could not be found.
	*
	* @param stdComplianceId the primary key of the standards compliance
	* @return the standards compliance
	* @throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException if a standards compliance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCompliance findByPrimaryKey(
		long stdComplianceId)
		throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(stdComplianceId);
	}

	/**
	* Returns the standards compliance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param stdComplianceId the primary key of the standards compliance
	* @return the standards compliance, or <code>null</code> if a standards compliance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCompliance fetchByPrimaryKey(
		long stdComplianceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(stdComplianceId);
	}

	/**
	* Returns all the standards compliances.
	*
	* @return the standards compliances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCompliance> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the standards compliances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsComplianceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards compliances
	* @param end the upper bound of the range of standards compliances (not inclusive)
	* @return the range of standards compliances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCompliance> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the standards compliances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsComplianceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards compliances
	* @param end the upper bound of the range of standards compliances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of standards compliances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCompliance> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the standards compliances from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of standards compliances.
	*
	* @return the number of standards compliances
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StandardsCompliancePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StandardsCompliancePersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					StandardsCompliancePersistence.class.getName());

			ReferenceRegistry.registerReference(StandardsComplianceUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(StandardsCompliancePersistence persistence) {
	}

	private static StandardsCompliancePersistence _persistence;
}