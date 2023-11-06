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

import com.ihg.brandstandards.db.model.StandardsRegionChain;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the standards region chain service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsRegionChainPersistenceImpl
 * @see StandardsRegionChainUtil
 * @generated
 */
public interface StandardsRegionChainPersistence extends BasePersistence<StandardsRegionChain> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StandardsRegionChainUtil} to access the standards region chain persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the standards region chains where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @return the matching standards region chains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsRegionChain> findBystdIdChnCd(
		long stdId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the standards region chains where stdId = &#63; and chainCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsRegionChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param start the lower bound of the range of standards region chains
	* @param end the upper bound of the range of standards region chains (not inclusive)
	* @return the range of matching standards region chains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsRegionChain> findBystdIdChnCd(
		long stdId, java.lang.String chainCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the standards region chains where stdId = &#63; and chainCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsRegionChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param start the lower bound of the range of standards region chains
	* @param end the upper bound of the range of standards region chains (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standards region chains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsRegionChain> findBystdIdChnCd(
		long stdId, java.lang.String chainCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standards region chain in the ordered set where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards region chain
	* @throws com.ihg.brandstandards.db.NoSuchStandardsRegionChainException if a matching standards region chain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsRegionChain findBystdIdChnCd_First(
		long stdId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsRegionChainException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standards region chain in the ordered set where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards region chain, or <code>null</code> if a matching standards region chain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsRegionChain fetchBystdIdChnCd_First(
		long stdId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standards region chain in the ordered set where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards region chain
	* @throws com.ihg.brandstandards.db.NoSuchStandardsRegionChainException if a matching standards region chain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsRegionChain findBystdIdChnCd_Last(
		long stdId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsRegionChainException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standards region chain in the ordered set where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards region chain, or <code>null</code> if a matching standards region chain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsRegionChain fetchBystdIdChnCd_Last(
		long stdId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards region chains before and after the current standards region chain in the ordered set where stdId = &#63; and chainCode = &#63;.
	*
	* @param standardsRegionChainPK the primary key of the current standards region chain
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards region chain
	* @throws com.ihg.brandstandards.db.NoSuchStandardsRegionChainException if a standards region chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsRegionChain[] findBystdIdChnCd_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.StandardsRegionChainPK standardsRegionChainPK,
		long stdId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsRegionChainException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standards region chains where stdId = &#63; and chainCode = &#63; from the database.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @throws SystemException if a system exception occurred
	*/
	public void removeBystdIdChnCd(long stdId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standards region chains where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @return the number of matching standards region chains
	* @throws SystemException if a system exception occurred
	*/
	public int countBystdIdChnCd(long stdId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards region chain where stdId = &#63; and regionCode = &#63; and chainCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsRegionChainException} if it could not be found.
	*
	* @param stdId the std ID
	* @param regionCode the region code
	* @param chainCode the chain code
	* @return the matching standards region chain
	* @throws com.ihg.brandstandards.db.NoSuchStandardsRegionChainException if a matching standards region chain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsRegionChain findBystdIdRgnCdChnCd(
		long stdId, java.lang.String regionCode, java.lang.String chainCode)
		throws com.ihg.brandstandards.db.NoSuchStandardsRegionChainException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards region chain where stdId = &#63; and regionCode = &#63; and chainCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param stdId the std ID
	* @param regionCode the region code
	* @param chainCode the chain code
	* @return the matching standards region chain, or <code>null</code> if a matching standards region chain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsRegionChain fetchBystdIdRgnCdChnCd(
		long stdId, java.lang.String regionCode, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards region chain where stdId = &#63; and regionCode = &#63; and chainCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param stdId the std ID
	* @param regionCode the region code
	* @param chainCode the chain code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching standards region chain, or <code>null</code> if a matching standards region chain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsRegionChain fetchBystdIdRgnCdChnCd(
		long stdId, java.lang.String regionCode, java.lang.String chainCode,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the standards region chain where stdId = &#63; and regionCode = &#63; and chainCode = &#63; from the database.
	*
	* @param stdId the std ID
	* @param regionCode the region code
	* @param chainCode the chain code
	* @return the standards region chain that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsRegionChain removeBystdIdRgnCdChnCd(
		long stdId, java.lang.String regionCode, java.lang.String chainCode)
		throws com.ihg.brandstandards.db.NoSuchStandardsRegionChainException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standards region chains where stdId = &#63; and regionCode = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param regionCode the region code
	* @param chainCode the chain code
	* @return the number of matching standards region chains
	* @throws SystemException if a system exception occurred
	*/
	public int countBystdIdRgnCdChnCd(long stdId, java.lang.String regionCode,
		java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the standards region chain in the entity cache if it is enabled.
	*
	* @param standardsRegionChain the standards region chain
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.StandardsRegionChain standardsRegionChain);

	/**
	* Caches the standards region chains in the entity cache if it is enabled.
	*
	* @param standardsRegionChains the standards region chains
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.StandardsRegionChain> standardsRegionChains);

	/**
	* Creates a new standards region chain with the primary key. Does not add the standards region chain to the database.
	*
	* @param standardsRegionChainPK the primary key for the new standards region chain
	* @return the new standards region chain
	*/
	public com.ihg.brandstandards.db.model.StandardsRegionChain create(
		com.ihg.brandstandards.db.service.persistence.StandardsRegionChainPK standardsRegionChainPK);

	/**
	* Removes the standards region chain with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsRegionChainPK the primary key of the standards region chain
	* @return the standards region chain that was removed
	* @throws com.ihg.brandstandards.db.NoSuchStandardsRegionChainException if a standards region chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsRegionChain remove(
		com.ihg.brandstandards.db.service.persistence.StandardsRegionChainPK standardsRegionChainPK)
		throws com.ihg.brandstandards.db.NoSuchStandardsRegionChainException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.StandardsRegionChain updateImpl(
		com.ihg.brandstandards.db.model.StandardsRegionChain standardsRegionChain)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards region chain with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsRegionChainException} if it could not be found.
	*
	* @param standardsRegionChainPK the primary key of the standards region chain
	* @return the standards region chain
	* @throws com.ihg.brandstandards.db.NoSuchStandardsRegionChainException if a standards region chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsRegionChain findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardsRegionChainPK standardsRegionChainPK)
		throws com.ihg.brandstandards.db.NoSuchStandardsRegionChainException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards region chain with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param standardsRegionChainPK the primary key of the standards region chain
	* @return the standards region chain, or <code>null</code> if a standards region chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsRegionChain fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardsRegionChainPK standardsRegionChainPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the standards region chains.
	*
	* @return the standards region chains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsRegionChain> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the standards region chains.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsRegionChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards region chains
	* @param end the upper bound of the range of standards region chains (not inclusive)
	* @return the range of standards region chains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsRegionChain> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the standards region chains.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsRegionChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards region chains
	* @param end the upper bound of the range of standards region chains (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of standards region chains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsRegionChain> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standards region chains from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standards region chains.
	*
	* @return the number of standards region chains
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}