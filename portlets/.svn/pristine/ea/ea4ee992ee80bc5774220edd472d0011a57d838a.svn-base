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

import com.ihg.brandstandards.db.model.StandardsRegion;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the standards region service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsRegionPersistenceImpl
 * @see StandardsRegionUtil
 * @generated
 */
public interface StandardsRegionPersistence extends BasePersistence<StandardsRegion> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StandardsRegionUtil} to access the standards region persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the standards region where regionId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsRegionException} if it could not be found.
	*
	* @param regionId the region ID
	* @return the matching standards region
	* @throws com.ihg.brandstandards.db.NoSuchStandardsRegionException if a matching standards region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsRegion findByregionId(
		long regionId)
		throws com.ihg.brandstandards.db.NoSuchStandardsRegionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards region where regionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param regionId the region ID
	* @return the matching standards region, or <code>null</code> if a matching standards region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsRegion fetchByregionId(
		long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards region where regionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param regionId the region ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching standards region, or <code>null</code> if a matching standards region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsRegion fetchByregionId(
		long regionId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the standards region where regionId = &#63; from the database.
	*
	* @param regionId the region ID
	* @return the standards region that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsRegion removeByregionId(
		long regionId)
		throws com.ihg.brandstandards.db.NoSuchStandardsRegionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standards regions where regionId = &#63;.
	*
	* @param regionId the region ID
	* @return the number of matching standards regions
	* @throws SystemException if a system exception occurred
	*/
	public int countByregionId(long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards region where regionCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsRegionException} if it could not be found.
	*
	* @param regionCode the region code
	* @return the matching standards region
	* @throws com.ihg.brandstandards.db.NoSuchStandardsRegionException if a matching standards region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsRegion findByRegionCode(
		java.lang.String regionCode)
		throws com.ihg.brandstandards.db.NoSuchStandardsRegionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards region where regionCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param regionCode the region code
	* @return the matching standards region, or <code>null</code> if a matching standards region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsRegion fetchByRegionCode(
		java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards region where regionCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param regionCode the region code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching standards region, or <code>null</code> if a matching standards region could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsRegion fetchByRegionCode(
		java.lang.String regionCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the standards region where regionCode = &#63; from the database.
	*
	* @param regionCode the region code
	* @return the standards region that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsRegion removeByRegionCode(
		java.lang.String regionCode)
		throws com.ihg.brandstandards.db.NoSuchStandardsRegionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standards regions where regionCode = &#63;.
	*
	* @param regionCode the region code
	* @return the number of matching standards regions
	* @throws SystemException if a system exception occurred
	*/
	public int countByRegionCode(java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the standards region in the entity cache if it is enabled.
	*
	* @param standardsRegion the standards region
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.StandardsRegion standardsRegion);

	/**
	* Caches the standards regions in the entity cache if it is enabled.
	*
	* @param standardsRegions the standards regions
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.StandardsRegion> standardsRegions);

	/**
	* Creates a new standards region with the primary key. Does not add the standards region to the database.
	*
	* @param regionId the primary key for the new standards region
	* @return the new standards region
	*/
	public com.ihg.brandstandards.db.model.StandardsRegion create(long regionId);

	/**
	* Removes the standards region with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param regionId the primary key of the standards region
	* @return the standards region that was removed
	* @throws com.ihg.brandstandards.db.NoSuchStandardsRegionException if a standards region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsRegion remove(long regionId)
		throws com.ihg.brandstandards.db.NoSuchStandardsRegionException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.StandardsRegion updateImpl(
		com.ihg.brandstandards.db.model.StandardsRegion standardsRegion)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards region with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsRegionException} if it could not be found.
	*
	* @param regionId the primary key of the standards region
	* @return the standards region
	* @throws com.ihg.brandstandards.db.NoSuchStandardsRegionException if a standards region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsRegion findByPrimaryKey(
		long regionId)
		throws com.ihg.brandstandards.db.NoSuchStandardsRegionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards region with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param regionId the primary key of the standards region
	* @return the standards region, or <code>null</code> if a standards region with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsRegion fetchByPrimaryKey(
		long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the standards regions.
	*
	* @return the standards regions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsRegion> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the standards regions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards regions
	* @param end the upper bound of the range of standards regions (not inclusive)
	* @return the range of standards regions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsRegion> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the standards regions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards regions
	* @param end the upper bound of the range of standards regions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of standards regions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsRegion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standards regions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standards regions.
	*
	* @return the number of standards regions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}