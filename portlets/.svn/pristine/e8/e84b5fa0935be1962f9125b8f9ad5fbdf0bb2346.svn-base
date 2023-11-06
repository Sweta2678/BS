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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the standards display order service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsDisplayOrderPersistenceImpl
 * @see StandardsDisplayOrderUtil
 * @generated
 */
public interface StandardsDisplayOrderPersistence extends BasePersistence<StandardsDisplayOrder> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StandardsDisplayOrderUtil} to access the standards display order persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

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
	public com.ihg.brandstandards.db.model.StandardsDisplayOrder findByStdIdChainIdRegionCode(
		long stdId, java.lang.String chainCode, java.lang.String regionCode)
		throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards display order where stdId = &#63; and chainCode = &#63; and regionCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param regionCode the region code
	* @return the matching standards display order, or <code>null</code> if a matching standards display order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsDisplayOrder fetchByStdIdChainIdRegionCode(
		long stdId, java.lang.String chainCode, java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.StandardsDisplayOrder fetchByStdIdChainIdRegionCode(
		long stdId, java.lang.String chainCode, java.lang.String regionCode,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the standards display order where stdId = &#63; and chainCode = &#63; and regionCode = &#63; from the database.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param regionCode the region code
	* @return the standards display order that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsDisplayOrder removeByStdIdChainIdRegionCode(
		long stdId, java.lang.String chainCode, java.lang.String regionCode)
		throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standards display orders where stdId = &#63; and chainCode = &#63; and regionCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param regionCode the region code
	* @return the number of matching standards display orders
	* @throws SystemException if a system exception occurred
	*/
	public int countByStdIdChainIdRegionCode(long stdId,
		java.lang.String chainCode, java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the standards display orders where chainCode = &#63; and regionCode = &#63;.
	*
	* @param chainCode the chain code
	* @param regionCode the region code
	* @return the matching standards display orders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsDisplayOrder> findByChainCodeRegionCode(
		java.lang.String chainCode, java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.StandardsDisplayOrder> findByChainCodeRegionCode(
		java.lang.String chainCode, java.lang.String regionCode, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.StandardsDisplayOrder> findByChainCodeRegionCode(
		java.lang.String chainCode, java.lang.String regionCode, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.StandardsDisplayOrder findByChainCodeRegionCode_First(
		java.lang.String chainCode, java.lang.String regionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standards display order in the ordered set where chainCode = &#63; and regionCode = &#63;.
	*
	* @param chainCode the chain code
	* @param regionCode the region code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards display order, or <code>null</code> if a matching standards display order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsDisplayOrder fetchByChainCodeRegionCode_First(
		java.lang.String chainCode, java.lang.String regionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.StandardsDisplayOrder findByChainCodeRegionCode_Last(
		java.lang.String chainCode, java.lang.String regionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standards display order in the ordered set where chainCode = &#63; and regionCode = &#63;.
	*
	* @param chainCode the chain code
	* @param regionCode the region code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards display order, or <code>null</code> if a matching standards display order could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsDisplayOrder fetchByChainCodeRegionCode_Last(
		java.lang.String chainCode, java.lang.String regionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.StandardsDisplayOrder[] findByChainCodeRegionCode_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.StandardsDisplayOrderPK standardsDisplayOrderPK,
		java.lang.String chainCode, java.lang.String regionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standards display orders where chainCode = &#63; and regionCode = &#63; from the database.
	*
	* @param chainCode the chain code
	* @param regionCode the region code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByChainCodeRegionCode(java.lang.String chainCode,
		java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standards display orders where chainCode = &#63; and regionCode = &#63;.
	*
	* @param chainCode the chain code
	* @param regionCode the region code
	* @return the number of matching standards display orders
	* @throws SystemException if a system exception occurred
	*/
	public int countByChainCodeRegionCode(java.lang.String chainCode,
		java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the standards display order in the entity cache if it is enabled.
	*
	* @param standardsDisplayOrder the standards display order
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.StandardsDisplayOrder standardsDisplayOrder);

	/**
	* Caches the standards display orders in the entity cache if it is enabled.
	*
	* @param standardsDisplayOrders the standards display orders
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.StandardsDisplayOrder> standardsDisplayOrders);

	/**
	* Creates a new standards display order with the primary key. Does not add the standards display order to the database.
	*
	* @param standardsDisplayOrderPK the primary key for the new standards display order
	* @return the new standards display order
	*/
	public com.ihg.brandstandards.db.model.StandardsDisplayOrder create(
		com.ihg.brandstandards.db.service.persistence.StandardsDisplayOrderPK standardsDisplayOrderPK);

	/**
	* Removes the standards display order with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsDisplayOrderPK the primary key of the standards display order
	* @return the standards display order that was removed
	* @throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException if a standards display order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsDisplayOrder remove(
		com.ihg.brandstandards.db.service.persistence.StandardsDisplayOrderPK standardsDisplayOrderPK)
		throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.StandardsDisplayOrder updateImpl(
		com.ihg.brandstandards.db.model.StandardsDisplayOrder standardsDisplayOrder)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards display order with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException} if it could not be found.
	*
	* @param standardsDisplayOrderPK the primary key of the standards display order
	* @return the standards display order
	* @throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException if a standards display order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsDisplayOrder findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardsDisplayOrderPK standardsDisplayOrderPK)
		throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards display order with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param standardsDisplayOrderPK the primary key of the standards display order
	* @return the standards display order, or <code>null</code> if a standards display order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsDisplayOrder fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardsDisplayOrderPK standardsDisplayOrderPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the standards display orders.
	*
	* @return the standards display orders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsDisplayOrder> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.StandardsDisplayOrder> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.StandardsDisplayOrder> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standards display orders from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standards display orders.
	*
	* @return the number of standards display orders
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}