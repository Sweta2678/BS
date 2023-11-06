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

import com.ihg.brandstandards.db.model.StandardsCountryChain;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the standards country chain service. This utility wraps {@link StandardsCountryChainPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsCountryChainPersistence
 * @see StandardsCountryChainPersistenceImpl
 * @generated
 */
public class StandardsCountryChainUtil {
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
	public static void clearCache(StandardsCountryChain standardsCountryChain) {
		getPersistence().clearCache(standardsCountryChain);
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
	public static List<StandardsCountryChain> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StandardsCountryChain> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StandardsCountryChain> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static StandardsCountryChain update(
		StandardsCountryChain standardsCountryChain) throws SystemException {
		return getPersistence().update(standardsCountryChain);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static StandardsCountryChain update(
		StandardsCountryChain standardsCountryChain,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(standardsCountryChain, serviceContext);
	}

	/**
	* Returns all the standards country chains where stdId = &#63; and chainCode = &#63; and compDate = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param compDate the comp date
	* @return the matching standards country chains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> findBystdIdDateChCode(
		long stdId, java.lang.String chainCode, java.util.Date compDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystdIdDateChCode(stdId, chainCode, compDate);
	}

	/**
	* Returns a range of all the standards country chains where stdId = &#63; and chainCode = &#63; and compDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param compDate the comp date
	* @param start the lower bound of the range of standards country chains
	* @param end the upper bound of the range of standards country chains (not inclusive)
	* @return the range of matching standards country chains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> findBystdIdDateChCode(
		long stdId, java.lang.String chainCode, java.util.Date compDate,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBystdIdDateChCode(stdId, chainCode, compDate, start, end);
	}

	/**
	* Returns an ordered range of all the standards country chains where stdId = &#63; and chainCode = &#63; and compDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param compDate the comp date
	* @param start the lower bound of the range of standards country chains
	* @param end the upper bound of the range of standards country chains (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standards country chains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> findBystdIdDateChCode(
		long stdId, java.lang.String chainCode, java.util.Date compDate,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBystdIdDateChCode(stdId, chainCode, compDate, start,
			end, orderByComparator);
	}

	/**
	* Returns the first standards country chain in the ordered set where stdId = &#63; and chainCode = &#63; and compDate = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param compDate the comp date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards country chain
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException if a matching standards country chain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCountryChain findBystdIdDateChCode_First(
		long stdId, java.lang.String chainCode, java.util.Date compDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBystdIdDateChCode_First(stdId, chainCode, compDate,
			orderByComparator);
	}

	/**
	* Returns the first standards country chain in the ordered set where stdId = &#63; and chainCode = &#63; and compDate = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param compDate the comp date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards country chain, or <code>null</code> if a matching standards country chain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCountryChain fetchBystdIdDateChCode_First(
		long stdId, java.lang.String chainCode, java.util.Date compDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBystdIdDateChCode_First(stdId, chainCode, compDate,
			orderByComparator);
	}

	/**
	* Returns the last standards country chain in the ordered set where stdId = &#63; and chainCode = &#63; and compDate = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param compDate the comp date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards country chain
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException if a matching standards country chain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCountryChain findBystdIdDateChCode_Last(
		long stdId, java.lang.String chainCode, java.util.Date compDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBystdIdDateChCode_Last(stdId, chainCode, compDate,
			orderByComparator);
	}

	/**
	* Returns the last standards country chain in the ordered set where stdId = &#63; and chainCode = &#63; and compDate = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param compDate the comp date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards country chain, or <code>null</code> if a matching standards country chain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCountryChain fetchBystdIdDateChCode_Last(
		long stdId, java.lang.String chainCode, java.util.Date compDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBystdIdDateChCode_Last(stdId, chainCode, compDate,
			orderByComparator);
	}

	/**
	* Returns the standards country chains before and after the current standards country chain in the ordered set where stdId = &#63; and chainCode = &#63; and compDate = &#63;.
	*
	* @param standardsCountryChainPK the primary key of the current standards country chain
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param compDate the comp date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards country chain
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException if a standards country chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCountryChain[] findBystdIdDateChCode_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK standardsCountryChainPK,
		long stdId, java.lang.String chainCode, java.util.Date compDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBystdIdDateChCode_PrevAndNext(standardsCountryChainPK,
			stdId, chainCode, compDate, orderByComparator);
	}

	/**
	* Removes all the standards country chains where stdId = &#63; and chainCode = &#63; and compDate = &#63; from the database.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param compDate the comp date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBystdIdDateChCode(long stdId,
		java.lang.String chainCode, java.util.Date compDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBystdIdDateChCode(stdId, chainCode, compDate);
	}

	/**
	* Returns the number of standards country chains where stdId = &#63; and chainCode = &#63; and compDate = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param compDate the comp date
	* @return the number of matching standards country chains
	* @throws SystemException if a system exception occurred
	*/
	public static int countBystdIdDateChCode(long stdId,
		java.lang.String chainCode, java.util.Date compDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBystdIdDateChCode(stdId, chainCode, compDate);
	}

	/**
	* Returns all the standards country chains where stdId = &#63; and chainCode = &#63; and regionCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param regionCode the region code
	* @return the matching standards country chains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> findByStdIdChainRegion(
		long stdId, java.lang.String chainCode, java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdIdChainRegion(stdId, chainCode, regionCode);
	}

	/**
	* Returns a range of all the standards country chains where stdId = &#63; and chainCode = &#63; and regionCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param regionCode the region code
	* @param start the lower bound of the range of standards country chains
	* @param end the upper bound of the range of standards country chains (not inclusive)
	* @return the range of matching standards country chains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> findByStdIdChainRegion(
		long stdId, java.lang.String chainCode, java.lang.String regionCode,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdIdChainRegion(stdId, chainCode, regionCode, start,
			end);
	}

	/**
	* Returns an ordered range of all the standards country chains where stdId = &#63; and chainCode = &#63; and regionCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param regionCode the region code
	* @param start the lower bound of the range of standards country chains
	* @param end the upper bound of the range of standards country chains (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standards country chains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> findByStdIdChainRegion(
		long stdId, java.lang.String chainCode, java.lang.String regionCode,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdIdChainRegion(stdId, chainCode, regionCode, start,
			end, orderByComparator);
	}

	/**
	* Returns the first standards country chain in the ordered set where stdId = &#63; and chainCode = &#63; and regionCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param regionCode the region code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards country chain
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException if a matching standards country chain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCountryChain findByStdIdChainRegion_First(
		long stdId, java.lang.String chainCode, java.lang.String regionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdIdChainRegion_First(stdId, chainCode, regionCode,
			orderByComparator);
	}

	/**
	* Returns the first standards country chain in the ordered set where stdId = &#63; and chainCode = &#63; and regionCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param regionCode the region code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards country chain, or <code>null</code> if a matching standards country chain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCountryChain fetchByStdIdChainRegion_First(
		long stdId, java.lang.String chainCode, java.lang.String regionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStdIdChainRegion_First(stdId, chainCode, regionCode,
			orderByComparator);
	}

	/**
	* Returns the last standards country chain in the ordered set where stdId = &#63; and chainCode = &#63; and regionCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param regionCode the region code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards country chain
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException if a matching standards country chain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCountryChain findByStdIdChainRegion_Last(
		long stdId, java.lang.String chainCode, java.lang.String regionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdIdChainRegion_Last(stdId, chainCode, regionCode,
			orderByComparator);
	}

	/**
	* Returns the last standards country chain in the ordered set where stdId = &#63; and chainCode = &#63; and regionCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param regionCode the region code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards country chain, or <code>null</code> if a matching standards country chain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCountryChain fetchByStdIdChainRegion_Last(
		long stdId, java.lang.String chainCode, java.lang.String regionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStdIdChainRegion_Last(stdId, chainCode, regionCode,
			orderByComparator);
	}

	/**
	* Returns the standards country chains before and after the current standards country chain in the ordered set where stdId = &#63; and chainCode = &#63; and regionCode = &#63;.
	*
	* @param standardsCountryChainPK the primary key of the current standards country chain
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param regionCode the region code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards country chain
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException if a standards country chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCountryChain[] findByStdIdChainRegion_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK standardsCountryChainPK,
		long stdId, java.lang.String chainCode, java.lang.String regionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdIdChainRegion_PrevAndNext(standardsCountryChainPK,
			stdId, chainCode, regionCode, orderByComparator);
	}

	/**
	* Removes all the standards country chains where stdId = &#63; and chainCode = &#63; and regionCode = &#63; from the database.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param regionCode the region code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStdIdChainRegion(long stdId,
		java.lang.String chainCode, java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStdIdChainRegion(stdId, chainCode, regionCode);
	}

	/**
	* Returns the number of standards country chains where stdId = &#63; and chainCode = &#63; and regionCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param regionCode the region code
	* @return the number of matching standards country chains
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStdIdChainRegion(long stdId,
		java.lang.String chainCode, java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByStdIdChainRegion(stdId, chainCode, regionCode);
	}

	/**
	* Returns all the standards country chains where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @return the matching standards country chains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> findByStdIdChain(
		long stdId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdIdChain(stdId, chainCode);
	}

	/**
	* Returns a range of all the standards country chains where stdId = &#63; and chainCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param start the lower bound of the range of standards country chains
	* @param end the upper bound of the range of standards country chains (not inclusive)
	* @return the range of matching standards country chains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> findByStdIdChain(
		long stdId, java.lang.String chainCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdIdChain(stdId, chainCode, start, end);
	}

	/**
	* Returns an ordered range of all the standards country chains where stdId = &#63; and chainCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param start the lower bound of the range of standards country chains
	* @param end the upper bound of the range of standards country chains (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standards country chains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> findByStdIdChain(
		long stdId, java.lang.String chainCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdIdChain(stdId, chainCode, start, end,
			orderByComparator);
	}

	/**
	* Returns the first standards country chain in the ordered set where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards country chain
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException if a matching standards country chain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCountryChain findByStdIdChain_First(
		long stdId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdIdChain_First(stdId, chainCode, orderByComparator);
	}

	/**
	* Returns the first standards country chain in the ordered set where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards country chain, or <code>null</code> if a matching standards country chain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCountryChain fetchByStdIdChain_First(
		long stdId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStdIdChain_First(stdId, chainCode, orderByComparator);
	}

	/**
	* Returns the last standards country chain in the ordered set where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards country chain
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException if a matching standards country chain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCountryChain findByStdIdChain_Last(
		long stdId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdIdChain_Last(stdId, chainCode, orderByComparator);
	}

	/**
	* Returns the last standards country chain in the ordered set where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards country chain, or <code>null</code> if a matching standards country chain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCountryChain fetchByStdIdChain_Last(
		long stdId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStdIdChain_Last(stdId, chainCode, orderByComparator);
	}

	/**
	* Returns the standards country chains before and after the current standards country chain in the ordered set where stdId = &#63; and chainCode = &#63;.
	*
	* @param standardsCountryChainPK the primary key of the current standards country chain
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards country chain
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException if a standards country chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCountryChain[] findByStdIdChain_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK standardsCountryChainPK,
		long stdId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdIdChain_PrevAndNext(standardsCountryChainPK,
			stdId, chainCode, orderByComparator);
	}

	/**
	* Removes all the standards country chains where stdId = &#63; and chainCode = &#63; from the database.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStdIdChain(long stdId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStdIdChain(stdId, chainCode);
	}

	/**
	* Returns the number of standards country chains where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @return the number of matching standards country chains
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStdIdChain(long stdId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStdIdChain(stdId, chainCode);
	}

	/**
	* Caches the standards country chain in the entity cache if it is enabled.
	*
	* @param standardsCountryChain the standards country chain
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.StandardsCountryChain standardsCountryChain) {
		getPersistence().cacheResult(standardsCountryChain);
	}

	/**
	* Caches the standards country chains in the entity cache if it is enabled.
	*
	* @param standardsCountryChains the standards country chains
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> standardsCountryChains) {
		getPersistence().cacheResult(standardsCountryChains);
	}

	/**
	* Creates a new standards country chain with the primary key. Does not add the standards country chain to the database.
	*
	* @param standardsCountryChainPK the primary key for the new standards country chain
	* @return the new standards country chain
	*/
	public static com.ihg.brandstandards.db.model.StandardsCountryChain create(
		com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK standardsCountryChainPK) {
		return getPersistence().create(standardsCountryChainPK);
	}

	/**
	* Removes the standards country chain with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsCountryChainPK the primary key of the standards country chain
	* @return the standards country chain that was removed
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException if a standards country chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCountryChain remove(
		com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK standardsCountryChainPK)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(standardsCountryChainPK);
	}

	public static com.ihg.brandstandards.db.model.StandardsCountryChain updateImpl(
		com.ihg.brandstandards.db.model.StandardsCountryChain standardsCountryChain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(standardsCountryChain);
	}

	/**
	* Returns the standards country chain with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsCountryChainException} if it could not be found.
	*
	* @param standardsCountryChainPK the primary key of the standards country chain
	* @return the standards country chain
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException if a standards country chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCountryChain findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK standardsCountryChainPK)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(standardsCountryChainPK);
	}

	/**
	* Returns the standards country chain with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param standardsCountryChainPK the primary key of the standards country chain
	* @return the standards country chain, or <code>null</code> if a standards country chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCountryChain fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK standardsCountryChainPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(standardsCountryChainPK);
	}

	/**
	* Returns all the standards country chains.
	*
	* @return the standards country chains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the standards country chains.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards country chains
	* @param end the upper bound of the range of standards country chains (not inclusive)
	* @return the range of standards country chains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the standards country chains.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards country chains
	* @param end the upper bound of the range of standards country chains (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of standards country chains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the standards country chains from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of standards country chains.
	*
	* @return the number of standards country chains
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StandardsCountryChainPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StandardsCountryChainPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					StandardsCountryChainPersistence.class.getName());

			ReferenceRegistry.registerReference(StandardsCountryChainUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(StandardsCountryChainPersistence persistence) {
	}

	private static StandardsCountryChainPersistence _persistence;
}