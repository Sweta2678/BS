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

import com.ihg.brandstandards.db.model.ChainExternalLinkStandards;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the chain external link standards service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see ChainExternalLinkStandardsPersistenceImpl
 * @see ChainExternalLinkStandardsUtil
 * @generated
 */
public interface ChainExternalLinkStandardsPersistence extends BasePersistence<ChainExternalLinkStandards> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ChainExternalLinkStandardsUtil} to access the chain external link standards persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the chain external link standardses where extLinkId = &#63;.
	*
	* @param extLinkId the ext link ID
	* @return the matching chain external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ChainExternalLinkStandards> findByLinkId(
		long extLinkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the chain external link standardses where extLinkId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param extLinkId the ext link ID
	* @param start the lower bound of the range of chain external link standardses
	* @param end the upper bound of the range of chain external link standardses (not inclusive)
	* @return the range of matching chain external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ChainExternalLinkStandards> findByLinkId(
		long extLinkId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the chain external link standardses where extLinkId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param extLinkId the ext link ID
	* @param start the lower bound of the range of chain external link standardses
	* @param end the upper bound of the range of chain external link standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching chain external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ChainExternalLinkStandards> findByLinkId(
		long extLinkId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first chain external link standards in the ordered set where extLinkId = &#63;.
	*
	* @param extLinkId the ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching chain external link standards
	* @throws com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException if a matching chain external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ChainExternalLinkStandards findByLinkId_First(
		long extLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first chain external link standards in the ordered set where extLinkId = &#63;.
	*
	* @param extLinkId the ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching chain external link standards, or <code>null</code> if a matching chain external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ChainExternalLinkStandards fetchByLinkId_First(
		long extLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last chain external link standards in the ordered set where extLinkId = &#63;.
	*
	* @param extLinkId the ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching chain external link standards
	* @throws com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException if a matching chain external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ChainExternalLinkStandards findByLinkId_Last(
		long extLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last chain external link standards in the ordered set where extLinkId = &#63;.
	*
	* @param extLinkId the ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching chain external link standards, or <code>null</code> if a matching chain external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ChainExternalLinkStandards fetchByLinkId_Last(
		long extLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the chain external link standardses before and after the current chain external link standards in the ordered set where extLinkId = &#63;.
	*
	* @param chainExternalLinkStandardsPK the primary key of the current chain external link standards
	* @param extLinkId the ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next chain external link standards
	* @throws com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException if a chain external link standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ChainExternalLinkStandards[] findByLinkId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.ChainExternalLinkStandardsPK chainExternalLinkStandardsPK,
		long extLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the chain external link standardses where extLinkId = &#63; from the database.
	*
	* @param extLinkId the ext link ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLinkId(long extLinkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of chain external link standardses where extLinkId = &#63;.
	*
	* @param extLinkId the ext link ID
	* @return the number of matching chain external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countByLinkId(long extLinkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the chain external link standards in the entity cache if it is enabled.
	*
	* @param chainExternalLinkStandards the chain external link standards
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.ChainExternalLinkStandards chainExternalLinkStandards);

	/**
	* Caches the chain external link standardses in the entity cache if it is enabled.
	*
	* @param chainExternalLinkStandardses the chain external link standardses
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.ChainExternalLinkStandards> chainExternalLinkStandardses);

	/**
	* Creates a new chain external link standards with the primary key. Does not add the chain external link standards to the database.
	*
	* @param chainExternalLinkStandardsPK the primary key for the new chain external link standards
	* @return the new chain external link standards
	*/
	public com.ihg.brandstandards.db.model.ChainExternalLinkStandards create(
		com.ihg.brandstandards.db.service.persistence.ChainExternalLinkStandardsPK chainExternalLinkStandardsPK);

	/**
	* Removes the chain external link standards with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param chainExternalLinkStandardsPK the primary key of the chain external link standards
	* @return the chain external link standards that was removed
	* @throws com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException if a chain external link standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ChainExternalLinkStandards remove(
		com.ihg.brandstandards.db.service.persistence.ChainExternalLinkStandardsPK chainExternalLinkStandardsPK)
		throws com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.ChainExternalLinkStandards updateImpl(
		com.ihg.brandstandards.db.model.ChainExternalLinkStandards chainExternalLinkStandards)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the chain external link standards with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException} if it could not be found.
	*
	* @param chainExternalLinkStandardsPK the primary key of the chain external link standards
	* @return the chain external link standards
	* @throws com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException if a chain external link standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ChainExternalLinkStandards findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.ChainExternalLinkStandardsPK chainExternalLinkStandardsPK)
		throws com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the chain external link standards with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param chainExternalLinkStandardsPK the primary key of the chain external link standards
	* @return the chain external link standards, or <code>null</code> if a chain external link standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ChainExternalLinkStandards fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.ChainExternalLinkStandardsPK chainExternalLinkStandardsPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the chain external link standardses.
	*
	* @return the chain external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ChainExternalLinkStandards> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the chain external link standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of chain external link standardses
	* @param end the upper bound of the range of chain external link standardses (not inclusive)
	* @return the range of chain external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ChainExternalLinkStandards> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the chain external link standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of chain external link standardses
	* @param end the upper bound of the range of chain external link standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of chain external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ChainExternalLinkStandards> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the chain external link standardses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of chain external link standardses.
	*
	* @return the number of chain external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}