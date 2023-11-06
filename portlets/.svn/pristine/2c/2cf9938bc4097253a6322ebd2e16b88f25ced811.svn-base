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

import com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the bridge progress discrepancy service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgeProgressDiscrepancyPersistenceImpl
 * @see BridgeProgressDiscrepancyUtil
 * @generated
 */
public interface BridgeProgressDiscrepancyPersistence extends BasePersistence<BridgeProgressDiscrepancy> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BridgeProgressDiscrepancyUtil} to access the bridge progress discrepancy persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the bridge progress discrepancies where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @return the matching bridge progress discrepancies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy> findBypublicationPublishRgn(
		long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bridge progress discrepancies where publishId = &#63; and regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressDiscrepancyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param start the lower bound of the range of bridge progress discrepancies
	* @param end the upper bound of the range of bridge progress discrepancies (not inclusive)
	* @return the range of matching bridge progress discrepancies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy> findBypublicationPublishRgn(
		long publishId, long regionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bridge progress discrepancies where publishId = &#63; and regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressDiscrepancyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param start the lower bound of the range of bridge progress discrepancies
	* @param end the upper bound of the range of bridge progress discrepancies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bridge progress discrepancies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy> findBypublicationPublishRgn(
		long publishId, long regionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge progress discrepancy
	* @throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException if a matching bridge progress discrepancy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy findBypublicationPublishRgn_First(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge progress discrepancy, or <code>null</code> if a matching bridge progress discrepancy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy fetchBypublicationPublishRgn_First(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge progress discrepancy
	* @throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException if a matching bridge progress discrepancy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy findBypublicationPublishRgn_Last(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge progress discrepancy, or <code>null</code> if a matching bridge progress discrepancy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy fetchBypublicationPublishRgn_Last(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge progress discrepancies before and after the current bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param bridgeProgressDiscrepancyPK the primary key of the current bridge progress discrepancy
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bridge progress discrepancy
	* @throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException if a bridge progress discrepancy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy[] findBypublicationPublishRgn_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.BridgeProgressDiscrepancyPK bridgeProgressDiscrepancyPK,
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bridge progress discrepancies where publishId = &#63; and regionId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBypublicationPublishRgn(long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge progress discrepancies where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @return the number of matching bridge progress discrepancies
	* @throws SystemException if a system exception occurred
	*/
	public int countBypublicationPublishRgn(long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bridge progress discrepancies where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @return the matching bridge progress discrepancies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy> findBypublicationPublishRgnCategory(
		long publishId, long regionId, long progressCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bridge progress discrepancies where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressDiscrepancyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @param start the lower bound of the range of bridge progress discrepancies
	* @param end the upper bound of the range of bridge progress discrepancies (not inclusive)
	* @return the range of matching bridge progress discrepancies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy> findBypublicationPublishRgnCategory(
		long publishId, long regionId, long progressCategoryId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bridge progress discrepancies where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressDiscrepancyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @param start the lower bound of the range of bridge progress discrepancies
	* @param end the upper bound of the range of bridge progress discrepancies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bridge progress discrepancies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy> findBypublicationPublishRgnCategory(
		long publishId, long regionId, long progressCategoryId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge progress discrepancy
	* @throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException if a matching bridge progress discrepancy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy findBypublicationPublishRgnCategory_First(
		long publishId, long regionId, long progressCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge progress discrepancy, or <code>null</code> if a matching bridge progress discrepancy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy fetchBypublicationPublishRgnCategory_First(
		long publishId, long regionId, long progressCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge progress discrepancy
	* @throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException if a matching bridge progress discrepancy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy findBypublicationPublishRgnCategory_Last(
		long publishId, long regionId, long progressCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge progress discrepancy, or <code>null</code> if a matching bridge progress discrepancy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy fetchBypublicationPublishRgnCategory_Last(
		long publishId, long regionId, long progressCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge progress discrepancies before and after the current bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63;.
	*
	* @param bridgeProgressDiscrepancyPK the primary key of the current bridge progress discrepancy
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bridge progress discrepancy
	* @throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException if a bridge progress discrepancy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy[] findBypublicationPublishRgnCategory_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.BridgeProgressDiscrepancyPK bridgeProgressDiscrepancyPK,
		long publishId, long regionId, long progressCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bridge progress discrepancies where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBypublicationPublishRgnCategory(long publishId,
		long regionId, long progressCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge progress discrepancies where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @return the number of matching bridge progress discrepancies
	* @throws SystemException if a system exception occurred
	*/
	public int countBypublicationPublishRgnCategory(long publishId,
		long regionId, long progressCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge progress discrepancy where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63; and progressSubCategoryId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException} if it could not be found.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @param progressSubCategoryId the progress sub category ID
	* @return the matching bridge progress discrepancy
	* @throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException if a matching bridge progress discrepancy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy findBypublicationPublishRgnCatSubCat(
		long publishId, long regionId, long progressCategoryId,
		long progressSubCategoryId)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge progress discrepancy where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63; and progressSubCategoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @param progressSubCategoryId the progress sub category ID
	* @return the matching bridge progress discrepancy, or <code>null</code> if a matching bridge progress discrepancy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy fetchBypublicationPublishRgnCatSubCat(
		long publishId, long regionId, long progressCategoryId,
		long progressSubCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge progress discrepancy where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63; and progressSubCategoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @param progressSubCategoryId the progress sub category ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching bridge progress discrepancy, or <code>null</code> if a matching bridge progress discrepancy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy fetchBypublicationPublishRgnCatSubCat(
		long publishId, long regionId, long progressCategoryId,
		long progressSubCategoryId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the bridge progress discrepancy where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63; and progressSubCategoryId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @param progressSubCategoryId the progress sub category ID
	* @return the bridge progress discrepancy that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy removeBypublicationPublishRgnCatSubCat(
		long publishId, long regionId, long progressCategoryId,
		long progressSubCategoryId)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge progress discrepancies where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63; and progressSubCategoryId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @param progressSubCategoryId the progress sub category ID
	* @return the number of matching bridge progress discrepancies
	* @throws SystemException if a system exception occurred
	*/
	public int countBypublicationPublishRgnCatSubCat(long publishId,
		long regionId, long progressCategoryId, long progressSubCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the bridge progress discrepancy in the entity cache if it is enabled.
	*
	* @param bridgeProgressDiscrepancy the bridge progress discrepancy
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy bridgeProgressDiscrepancy);

	/**
	* Caches the bridge progress discrepancies in the entity cache if it is enabled.
	*
	* @param bridgeProgressDiscrepancies the bridge progress discrepancies
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy> bridgeProgressDiscrepancies);

	/**
	* Creates a new bridge progress discrepancy with the primary key. Does not add the bridge progress discrepancy to the database.
	*
	* @param bridgeProgressDiscrepancyPK the primary key for the new bridge progress discrepancy
	* @return the new bridge progress discrepancy
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy create(
		com.ihg.brandstandards.db.service.persistence.BridgeProgressDiscrepancyPK bridgeProgressDiscrepancyPK);

	/**
	* Removes the bridge progress discrepancy with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bridgeProgressDiscrepancyPK the primary key of the bridge progress discrepancy
	* @return the bridge progress discrepancy that was removed
	* @throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException if a bridge progress discrepancy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy remove(
		com.ihg.brandstandards.db.service.persistence.BridgeProgressDiscrepancyPK bridgeProgressDiscrepancyPK)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy updateImpl(
		com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy bridgeProgressDiscrepancy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge progress discrepancy with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException} if it could not be found.
	*
	* @param bridgeProgressDiscrepancyPK the primary key of the bridge progress discrepancy
	* @return the bridge progress discrepancy
	* @throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException if a bridge progress discrepancy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.BridgeProgressDiscrepancyPK bridgeProgressDiscrepancyPK)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge progress discrepancy with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bridgeProgressDiscrepancyPK the primary key of the bridge progress discrepancy
	* @return the bridge progress discrepancy, or <code>null</code> if a bridge progress discrepancy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.BridgeProgressDiscrepancyPK bridgeProgressDiscrepancyPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bridge progress discrepancies.
	*
	* @return the bridge progress discrepancies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bridge progress discrepancies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressDiscrepancyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge progress discrepancies
	* @param end the upper bound of the range of bridge progress discrepancies (not inclusive)
	* @return the range of bridge progress discrepancies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bridge progress discrepancies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressDiscrepancyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge progress discrepancies
	* @param end the upper bound of the range of bridge progress discrepancies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bridge progress discrepancies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bridge progress discrepancies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge progress discrepancies.
	*
	* @return the number of bridge progress discrepancies
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}