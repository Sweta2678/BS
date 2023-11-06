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

import com.ihg.brandstandards.db.model.HistManualChain;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the hist manual chain service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see HistManualChainPersistenceImpl
 * @see HistManualChainUtil
 * @generated
 */
public interface HistManualChainPersistence extends BasePersistence<HistManualChain> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HistManualChainUtil} to access the hist manual chain persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the hist manual chains where histManualId = &#63;.
	*
	* @param histManualId the hist manual ID
	* @return the matching hist manual chains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.HistManualChain> findByhistManualId(
		long histManualId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the hist manual chains where histManualId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param histManualId the hist manual ID
	* @param start the lower bound of the range of hist manual chains
	* @param end the upper bound of the range of hist manual chains (not inclusive)
	* @return the range of matching hist manual chains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.HistManualChain> findByhistManualId(
		long histManualId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the hist manual chains where histManualId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param histManualId the hist manual ID
	* @param start the lower bound of the range of hist manual chains
	* @param end the upper bound of the range of hist manual chains (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching hist manual chains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.HistManualChain> findByhistManualId(
		long histManualId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first hist manual chain in the ordered set where histManualId = &#63;.
	*
	* @param histManualId the hist manual ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching hist manual chain
	* @throws com.ihg.brandstandards.db.NoSuchHistManualChainException if a matching hist manual chain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.HistManualChain findByhistManualId_First(
		long histManualId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchHistManualChainException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first hist manual chain in the ordered set where histManualId = &#63;.
	*
	* @param histManualId the hist manual ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching hist manual chain, or <code>null</code> if a matching hist manual chain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.HistManualChain fetchByhistManualId_First(
		long histManualId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last hist manual chain in the ordered set where histManualId = &#63;.
	*
	* @param histManualId the hist manual ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching hist manual chain
	* @throws com.ihg.brandstandards.db.NoSuchHistManualChainException if a matching hist manual chain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.HistManualChain findByhistManualId_Last(
		long histManualId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchHistManualChainException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last hist manual chain in the ordered set where histManualId = &#63;.
	*
	* @param histManualId the hist manual ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching hist manual chain, or <code>null</code> if a matching hist manual chain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.HistManualChain fetchByhistManualId_Last(
		long histManualId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the hist manual chains before and after the current hist manual chain in the ordered set where histManualId = &#63;.
	*
	* @param histManualChainPK the primary key of the current hist manual chain
	* @param histManualId the hist manual ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next hist manual chain
	* @throws com.ihg.brandstandards.db.NoSuchHistManualChainException if a hist manual chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.HistManualChain[] findByhistManualId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.HistManualChainPK histManualChainPK,
		long histManualId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchHistManualChainException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the hist manual chains where histManualId = &#63; from the database.
	*
	* @param histManualId the hist manual ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByhistManualId(long histManualId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of hist manual chains where histManualId = &#63;.
	*
	* @param histManualId the hist manual ID
	* @return the number of matching hist manual chains
	* @throws SystemException if a system exception occurred
	*/
	public int countByhistManualId(long histManualId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the hist manual chain in the entity cache if it is enabled.
	*
	* @param histManualChain the hist manual chain
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.HistManualChain histManualChain);

	/**
	* Caches the hist manual chains in the entity cache if it is enabled.
	*
	* @param histManualChains the hist manual chains
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.HistManualChain> histManualChains);

	/**
	* Creates a new hist manual chain with the primary key. Does not add the hist manual chain to the database.
	*
	* @param histManualChainPK the primary key for the new hist manual chain
	* @return the new hist manual chain
	*/
	public com.ihg.brandstandards.db.model.HistManualChain create(
		com.ihg.brandstandards.db.service.persistence.HistManualChainPK histManualChainPK);

	/**
	* Removes the hist manual chain with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param histManualChainPK the primary key of the hist manual chain
	* @return the hist manual chain that was removed
	* @throws com.ihg.brandstandards.db.NoSuchHistManualChainException if a hist manual chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.HistManualChain remove(
		com.ihg.brandstandards.db.service.persistence.HistManualChainPK histManualChainPK)
		throws com.ihg.brandstandards.db.NoSuchHistManualChainException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.HistManualChain updateImpl(
		com.ihg.brandstandards.db.model.HistManualChain histManualChain)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the hist manual chain with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchHistManualChainException} if it could not be found.
	*
	* @param histManualChainPK the primary key of the hist manual chain
	* @return the hist manual chain
	* @throws com.ihg.brandstandards.db.NoSuchHistManualChainException if a hist manual chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.HistManualChain findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.HistManualChainPK histManualChainPK)
		throws com.ihg.brandstandards.db.NoSuchHistManualChainException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the hist manual chain with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param histManualChainPK the primary key of the hist manual chain
	* @return the hist manual chain, or <code>null</code> if a hist manual chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.HistManualChain fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.HistManualChainPK histManualChainPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the hist manual chains.
	*
	* @return the hist manual chains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.HistManualChain> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the hist manual chains.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of hist manual chains
	* @param end the upper bound of the range of hist manual chains (not inclusive)
	* @return the range of hist manual chains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.HistManualChain> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the hist manual chains.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of hist manual chains
	* @param end the upper bound of the range of hist manual chains (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of hist manual chains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.HistManualChain> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the hist manual chains from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of hist manual chains.
	*
	* @return the number of hist manual chains
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}