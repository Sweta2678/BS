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

import com.ihg.brandstandards.db.model.StandardsDisplayOrder;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the standards display order service. This utility wraps {@link StandardsDisplayOrderPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsDisplayOrderPersistence
 * @see StandardsDisplayOrderPersistenceImpl
 * @generated
 */
public class StandardsDisplayOrderUtil {
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
	public static void clearCache(StandardsDisplayOrder standardsDisplayOrder) {
		getPersistence().clearCache(standardsDisplayOrder);
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
	public static List<StandardsDisplayOrder> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StandardsDisplayOrder> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StandardsDisplayOrder> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static StandardsDisplayOrder update(
		StandardsDisplayOrder standardsDisplayOrder) throws SystemException {
		return getPersistence().update(standardsDisplayOrder);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static StandardsDisplayOrder update(
		StandardsDisplayOrder standardsDisplayOrder,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(standardsDisplayOrder, serviceContext);
	}

	/**
	* Returns the standards display order where stdId = &#63; and chainCode = &#63; and regionCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException} if it could not be found.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param regionCode the region code
	* @return the matching standards display order
	* @throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException if a matching standards display order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsDisplayOrder findByStdIdChainIdRegionCode(
		long stdId, java.lang.String chainCode, java.lang.String regionCode)
		throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdIdChainIdRegionCode(stdId, chainCode, regionCode);
	}

	/**
	* Returns the standards display order where stdId = &#63; and chainCode = &#63; and regionCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param regionCode the region code
	* @return the matching standards display order, or <code>null</code> if a matching standards display order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsDisplayOrder fetchByStdIdChainIdRegionCode(
		long stdId, java.lang.String chainCode, java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStdIdChainIdRegionCode(stdId, chainCode, regionCode);
	}

	/**
	* Returns the standards display order where stdId = &#63; and chainCode = &#63; and regionCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param regionCode the region code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching standards display order, or <code>null</code> if a matching standards display order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsDisplayOrder fetchByStdIdChainIdRegionCode(
		long stdId, java.lang.String chainCode, java.lang.String regionCode,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStdIdChainIdRegionCode(stdId, chainCode, regionCode,
			retrieveFromCache);
	}

	/**
	* Removes the standards display order where stdId = &#63; and chainCode = &#63; and regionCode = &#63; from the database.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param regionCode the region code
	* @return the standards display order that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsDisplayOrder removeByStdIdChainIdRegionCode(
		long stdId, java.lang.String chainCode, java.lang.String regionCode)
		throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByStdIdChainIdRegionCode(stdId, chainCode, regionCode);
	}

	/**
	* Returns the number of standards display orders where stdId = &#63; and chainCode = &#63; and regionCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param regionCode the region code
	* @return the number of matching standards display orders
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStdIdChainIdRegionCode(long stdId,
		java.lang.String chainCode, java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByStdIdChainIdRegionCode(stdId, chainCode, regionCode);
	}

	/**
	* Returns all the standards display orders where chainCode = &#63; and regionCode = &#63;.
	*
	* @param chainCode the chain code
	* @param regionCode the region code
	* @return the matching standards display orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsDisplayOrder> findByChainCodeRegionCode(
		java.lang.String chainCode, java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByChainCodeRegionCode(chainCode, regionCode);
	}

	/**
	* Returns a range of all the standards display orders where chainCode = &#63; and regionCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsDisplayOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param chainCode the chain code
	* @param regionCode the region code
	* @param start the lower bound of the range of standards display orders
	* @param end the upper bound of the range of standards display orders (not inclusive)
	* @return the range of matching standards display orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsDisplayOrder> findByChainCodeRegionCode(
		java.lang.String chainCode, java.lang.String regionCode, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByChainCodeRegionCode(chainCode, regionCode, start, end);
	}

	/**
	* Returns an ordered range of all the standards display orders where chainCode = &#63; and regionCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsDisplayOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param chainCode the chain code
	* @param regionCode the region code
	* @param start the lower bound of the range of standards display orders
	* @param end the upper bound of the range of standards display orders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standards display orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsDisplayOrder> findByChainCodeRegionCode(
		java.lang.String chainCode, java.lang.String regionCode, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByChainCodeRegionCode(chainCode, regionCode, start,
			end, orderByComparator);
	}

	/**
	* Returns the first standards display order in the ordered set where chainCode = &#63; and regionCode = &#63;.
	*
	* @param chainCode the chain code
	* @param regionCode the region code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards display order
	* @throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException if a matching standards display order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsDisplayOrder findByChainCodeRegionCode_First(
		java.lang.String chainCode, java.lang.String regionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByChainCodeRegionCode_First(chainCode, regionCode,
			orderByComparator);
	}

	/**
	* Returns the first standards display order in the ordered set where chainCode = &#63; and regionCode = &#63;.
	*
	* @param chainCode the chain code
	* @param regionCode the region code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards display order, or <code>null</code> if a matching standards display order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsDisplayOrder fetchByChainCodeRegionCode_First(
		java.lang.String chainCode, java.lang.String regionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByChainCodeRegionCode_First(chainCode, regionCode,
			orderByComparator);
	}

	/**
	* Returns the last standards display order in the ordered set where chainCode = &#63; and regionCode = &#63;.
	*
	* @param chainCode the chain code
	* @param regionCode the region code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards display order
	* @throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException if a matching standards display order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsDisplayOrder findByChainCodeRegionCode_Last(
		java.lang.String chainCode, java.lang.String regionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByChainCodeRegionCode_Last(chainCode, regionCode,
			orderByComparator);
	}

	/**
	* Returns the last standards display order in the ordered set where chainCode = &#63; and regionCode = &#63;.
	*
	* @param chainCode the chain code
	* @param regionCode the region code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards display order, or <code>null</code> if a matching standards display order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsDisplayOrder fetchByChainCodeRegionCode_Last(
		java.lang.String chainCode, java.lang.String regionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByChainCodeRegionCode_Last(chainCode, regionCode,
			orderByComparator);
	}

	/**
	* Returns the standards display orders before and after the current standards display order in the ordered set where chainCode = &#63; and regionCode = &#63;.
	*
	* @param standardsDisplayOrderPK the primary key of the current standards display order
	* @param chainCode the chain code
	* @param regionCode the region code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards display order
	* @throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException if a standards display order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsDisplayOrder[] findByChainCodeRegionCode_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.StandardsDisplayOrderPK standardsDisplayOrderPK,
		java.lang.String chainCode, java.lang.String regionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByChainCodeRegionCode_PrevAndNext(standardsDisplayOrderPK,
			chainCode, regionCode, orderByComparator);
	}

	/**
	* Removes all the standards display orders where chainCode = &#63; and regionCode = &#63; from the database.
	*
	* @param chainCode the chain code
	* @param regionCode the region code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByChainCodeRegionCode(java.lang.String chainCode,
		java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByChainCodeRegionCode(chainCode, regionCode);
	}

	/**
	* Returns the number of standards display orders where chainCode = &#63; and regionCode = &#63;.
	*
	* @param chainCode the chain code
	* @param regionCode the region code
	* @return the number of matching standards display orders
	* @throws SystemException if a system exception occurred
	*/
	public static int countByChainCodeRegionCode(java.lang.String chainCode,
		java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByChainCodeRegionCode(chainCode, regionCode);
	}

	/**
	* Caches the standards display order in the entity cache if it is enabled.
	*
	* @param standardsDisplayOrder the standards display order
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.StandardsDisplayOrder standardsDisplayOrder) {
		getPersistence().cacheResult(standardsDisplayOrder);
	}

	/**
	* Caches the standards display orders in the entity cache if it is enabled.
	*
	* @param standardsDisplayOrders the standards display orders
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.StandardsDisplayOrder> standardsDisplayOrders) {
		getPersistence().cacheResult(standardsDisplayOrders);
	}

	/**
	* Creates a new standards display order with the primary key. Does not add the standards display order to the database.
	*
	* @param standardsDisplayOrderPK the primary key for the new standards display order
	* @return the new standards display order
	*/
	public static com.ihg.brandstandards.db.model.StandardsDisplayOrder create(
		com.ihg.brandstandards.db.service.persistence.StandardsDisplayOrderPK standardsDisplayOrderPK) {
		return getPersistence().create(standardsDisplayOrderPK);
	}

	/**
	* Removes the standards display order with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsDisplayOrderPK the primary key of the standards display order
	* @return the standards display order that was removed
	* @throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException if a standards display order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsDisplayOrder remove(
		com.ihg.brandstandards.db.service.persistence.StandardsDisplayOrderPK standardsDisplayOrderPK)
		throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(standardsDisplayOrderPK);
	}

	public static com.ihg.brandstandards.db.model.StandardsDisplayOrder updateImpl(
		com.ihg.brandstandards.db.model.StandardsDisplayOrder standardsDisplayOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(standardsDisplayOrder);
	}

	/**
	* Returns the standards display order with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException} if it could not be found.
	*
	* @param standardsDisplayOrderPK the primary key of the standards display order
	* @return the standards display order
	* @throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException if a standards display order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsDisplayOrder findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardsDisplayOrderPK standardsDisplayOrderPK)
		throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(standardsDisplayOrderPK);
	}

	/**
	* Returns the standards display order with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param standardsDisplayOrderPK the primary key of the standards display order
	* @return the standards display order, or <code>null</code> if a standards display order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsDisplayOrder fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardsDisplayOrderPK standardsDisplayOrderPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(standardsDisplayOrderPK);
	}

	/**
	* Returns all the standards display orders.
	*
	* @return the standards display orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsDisplayOrder> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the standards display orders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsDisplayOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards display orders
	* @param end the upper bound of the range of standards display orders (not inclusive)
	* @return the range of standards display orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsDisplayOrder> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the standards display orders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsDisplayOrderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards display orders
	* @param end the upper bound of the range of standards display orders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of standards display orders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsDisplayOrder> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the standards display orders from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of standards display orders.
	*
	* @return the number of standards display orders
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StandardsDisplayOrderPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StandardsDisplayOrderPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					StandardsDisplayOrderPersistence.class.getName());

			ReferenceRegistry.registerReference(StandardsDisplayOrderUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(StandardsDisplayOrderPersistence persistence) {
	}

	private static StandardsDisplayOrderPersistence _persistence;
}