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

import com.ihg.brandstandards.db.model.HistManualRegion;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the hist manual region service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see HistManualRegionPersistenceImpl
 * @see HistManualRegionUtil
 * @generated
 */
public interface HistManualRegionPersistence extends BasePersistence<HistManualRegion> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HistManualRegionUtil} to access the hist manual region persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the hist manual regions where histManualId = &#63;.
	*
	* @param histManualId the hist manual ID
	* @return the matching hist manual regions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.HistManualRegion> findByhistManualId(
		long histManualId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the hist manual regions where histManualId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param histManualId the hist manual ID
	* @param start the lower bound of the range of hist manual regions
	* @param end the upper bound of the range of hist manual regions (not inclusive)
	* @return the range of matching hist manual regions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.HistManualRegion> findByhistManualId(
		long histManualId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the hist manual regions where histManualId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param histManualId the hist manual ID
	* @param start the lower bound of the range of hist manual regions
	* @param end the upper bound of the range of hist manual regions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching hist manual regions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.HistManualRegion> findByhistManualId(
		long histManualId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first hist manual region in the ordered set where histManualId = &#63;.
	*
	* @param histManualId the hist manual ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching hist manual region
	* @throws com.ihg.brandstandards.db.NoSuchHistManualRegionException if a matching hist manual region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.HistManualRegion findByhistManualId_First(
		long histManualId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchHistManualRegionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first hist manual region in the ordered set where histManualId = &#63;.
	*
	* @param histManualId the hist manual ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching hist manual region, or <code>null</code> if a matching hist manual region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.HistManualRegion fetchByhistManualId_First(
		long histManualId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last hist manual region in the ordered set where histManualId = &#63;.
	*
	* @param histManualId the hist manual ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching hist manual region
	* @throws com.ihg.brandstandards.db.NoSuchHistManualRegionException if a matching hist manual region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.HistManualRegion findByhistManualId_Last(
		long histManualId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchHistManualRegionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last hist manual region in the ordered set where histManualId = &#63;.
	*
	* @param histManualId the hist manual ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching hist manual region, or <code>null</code> if a matching hist manual region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.HistManualRegion fetchByhistManualId_Last(
		long histManualId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the hist manual regions before and after the current hist manual region in the ordered set where histManualId = &#63;.
	*
	* @param histManualRegionPK the primary key of the current hist manual region
	* @param histManualId the hist manual ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next hist manual region
	* @throws com.ihg.brandstandards.db.NoSuchHistManualRegionException if a hist manual region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.HistManualRegion[] findByhistManualId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.HistManualRegionPK histManualRegionPK,
		long histManualId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchHistManualRegionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the hist manual regions where histManualId = &#63; from the database.
	*
	* @param histManualId the hist manual ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByhistManualId(long histManualId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of hist manual regions where histManualId = &#63;.
	*
	* @param histManualId the hist manual ID
	* @return the number of matching hist manual regions
	* @throws SystemException if a system exception occurred
	*/
	public int countByhistManualId(long histManualId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the hist manual region in the entity cache if it is enabled.
	*
	* @param histManualRegion the hist manual region
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.HistManualRegion histManualRegion);

	/**
	* Caches the hist manual regions in the entity cache if it is enabled.
	*
	* @param histManualRegions the hist manual regions
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.HistManualRegion> histManualRegions);

	/**
	* Creates a new hist manual region with the primary key. Does not add the hist manual region to the database.
	*
	* @param histManualRegionPK the primary key for the new hist manual region
	* @return the new hist manual region
	*/
	public com.ihg.brandstandards.db.model.HistManualRegion create(
		com.ihg.brandstandards.db.service.persistence.HistManualRegionPK histManualRegionPK);

	/**
	* Removes the hist manual region with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param histManualRegionPK the primary key of the hist manual region
	* @return the hist manual region that was removed
	* @throws com.ihg.brandstandards.db.NoSuchHistManualRegionException if a hist manual region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.HistManualRegion remove(
		com.ihg.brandstandards.db.service.persistence.HistManualRegionPK histManualRegionPK)
		throws com.ihg.brandstandards.db.NoSuchHistManualRegionException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.HistManualRegion updateImpl(
		com.ihg.brandstandards.db.model.HistManualRegion histManualRegion)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the hist manual region with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchHistManualRegionException} if it could not be found.
	*
	* @param histManualRegionPK the primary key of the hist manual region
	* @return the hist manual region
	* @throws com.ihg.brandstandards.db.NoSuchHistManualRegionException if a hist manual region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.HistManualRegion findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.HistManualRegionPK histManualRegionPK)
		throws com.ihg.brandstandards.db.NoSuchHistManualRegionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the hist manual region with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param histManualRegionPK the primary key of the hist manual region
	* @return the hist manual region, or <code>null</code> if a hist manual region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.HistManualRegion fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.HistManualRegionPK histManualRegionPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the hist manual regions.
	*
	* @return the hist manual regions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.HistManualRegion> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the hist manual regions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of hist manual regions
	* @param end the upper bound of the range of hist manual regions (not inclusive)
	* @return the range of hist manual regions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.HistManualRegion> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the hist manual regions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of hist manual regions
	* @param end the upper bound of the range of hist manual regions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of hist manual regions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.HistManualRegion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the hist manual regions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of hist manual regions.
	*
	* @return the number of hist manual regions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}