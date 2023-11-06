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

import com.ihg.brandstandards.db.model.FlagStandards;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the flag standards service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see FlagStandardsPersistenceImpl
 * @see FlagStandardsUtil
 * @generated
 */
public interface FlagStandardsPersistence extends BasePersistence<FlagStandards> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FlagStandardsUtil} to access the flag standards persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the flag standardses where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the matching flag standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.FlagStandards> findByStdId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the flag standardses where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of flag standardses
	* @param end the upper bound of the range of flag standardses (not inclusive)
	* @return the range of matching flag standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.FlagStandards> findByStdId(
		long stdId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the flag standardses where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of flag standardses
	* @param end the upper bound of the range of flag standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching flag standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.FlagStandards> findByStdId(
		long stdId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first flag standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flag standards
	* @throws com.ihg.brandstandards.db.NoSuchFlagStandardsException if a matching flag standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.FlagStandards findByStdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchFlagStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first flag standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flag standards, or <code>null</code> if a matching flag standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.FlagStandards fetchByStdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last flag standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flag standards
	* @throws com.ihg.brandstandards.db.NoSuchFlagStandardsException if a matching flag standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.FlagStandards findByStdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchFlagStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last flag standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flag standards, or <code>null</code> if a matching flag standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.FlagStandards fetchByStdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flag standardses before and after the current flag standards in the ordered set where stdId = &#63;.
	*
	* @param flagStandardsPK the primary key of the current flag standards
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next flag standards
	* @throws com.ihg.brandstandards.db.NoSuchFlagStandardsException if a flag standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.FlagStandards[] findByStdId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.FlagStandardsPK flagStandardsPK,
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchFlagStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the flag standardses where stdId = &#63; from the database.
	*
	* @param stdId the std ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of flag standardses where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the number of matching flag standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flag standards where flagCatId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchFlagStandardsException} if it could not be found.
	*
	* @param flagCatId the flag cat ID
	* @return the matching flag standards
	* @throws com.ihg.brandstandards.db.NoSuchFlagStandardsException if a matching flag standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.FlagStandards findByFlagCatId(
		long flagCatId)
		throws com.ihg.brandstandards.db.NoSuchFlagStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flag standards where flagCatId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param flagCatId the flag cat ID
	* @return the matching flag standards, or <code>null</code> if a matching flag standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.FlagStandards fetchByFlagCatId(
		long flagCatId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flag standards where flagCatId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param flagCatId the flag cat ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching flag standards, or <code>null</code> if a matching flag standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.FlagStandards fetchByFlagCatId(
		long flagCatId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the flag standards where flagCatId = &#63; from the database.
	*
	* @param flagCatId the flag cat ID
	* @return the flag standards that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.FlagStandards removeByFlagCatId(
		long flagCatId)
		throws com.ihg.brandstandards.db.NoSuchFlagStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of flag standardses where flagCatId = &#63;.
	*
	* @param flagCatId the flag cat ID
	* @return the number of matching flag standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countByFlagCatId(long flagCatId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flag standards where stdId = &#63; and flagCatId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchFlagStandardsException} if it could not be found.
	*
	* @param stdId the std ID
	* @param flagCatId the flag cat ID
	* @return the matching flag standards
	* @throws com.ihg.brandstandards.db.NoSuchFlagStandardsException if a matching flag standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.FlagStandards findByStandardAndCategoryId(
		long stdId, long flagCatId)
		throws com.ihg.brandstandards.db.NoSuchFlagStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flag standards where stdId = &#63; and flagCatId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param stdId the std ID
	* @param flagCatId the flag cat ID
	* @return the matching flag standards, or <code>null</code> if a matching flag standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.FlagStandards fetchByStandardAndCategoryId(
		long stdId, long flagCatId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flag standards where stdId = &#63; and flagCatId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param stdId the std ID
	* @param flagCatId the flag cat ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching flag standards, or <code>null</code> if a matching flag standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.FlagStandards fetchByStandardAndCategoryId(
		long stdId, long flagCatId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the flag standards where stdId = &#63; and flagCatId = &#63; from the database.
	*
	* @param stdId the std ID
	* @param flagCatId the flag cat ID
	* @return the flag standards that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.FlagStandards removeByStandardAndCategoryId(
		long stdId, long flagCatId)
		throws com.ihg.brandstandards.db.NoSuchFlagStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of flag standardses where stdId = &#63; and flagCatId = &#63;.
	*
	* @param stdId the std ID
	* @param flagCatId the flag cat ID
	* @return the number of matching flag standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countByStandardAndCategoryId(long stdId, long flagCatId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the flag standards in the entity cache if it is enabled.
	*
	* @param flagStandards the flag standards
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.FlagStandards flagStandards);

	/**
	* Caches the flag standardses in the entity cache if it is enabled.
	*
	* @param flagStandardses the flag standardses
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.FlagStandards> flagStandardses);

	/**
	* Creates a new flag standards with the primary key. Does not add the flag standards to the database.
	*
	* @param flagStandardsPK the primary key for the new flag standards
	* @return the new flag standards
	*/
	public com.ihg.brandstandards.db.model.FlagStandards create(
		com.ihg.brandstandards.db.service.persistence.FlagStandardsPK flagStandardsPK);

	/**
	* Removes the flag standards with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param flagStandardsPK the primary key of the flag standards
	* @return the flag standards that was removed
	* @throws com.ihg.brandstandards.db.NoSuchFlagStandardsException if a flag standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.FlagStandards remove(
		com.ihg.brandstandards.db.service.persistence.FlagStandardsPK flagStandardsPK)
		throws com.ihg.brandstandards.db.NoSuchFlagStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.FlagStandards updateImpl(
		com.ihg.brandstandards.db.model.FlagStandards flagStandards)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flag standards with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchFlagStandardsException} if it could not be found.
	*
	* @param flagStandardsPK the primary key of the flag standards
	* @return the flag standards
	* @throws com.ihg.brandstandards.db.NoSuchFlagStandardsException if a flag standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.FlagStandards findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.FlagStandardsPK flagStandardsPK)
		throws com.ihg.brandstandards.db.NoSuchFlagStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flag standards with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param flagStandardsPK the primary key of the flag standards
	* @return the flag standards, or <code>null</code> if a flag standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.FlagStandards fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.FlagStandardsPK flagStandardsPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the flag standardses.
	*
	* @return the flag standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.FlagStandards> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the flag standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flag standardses
	* @param end the upper bound of the range of flag standardses (not inclusive)
	* @return the range of flag standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.FlagStandards> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the flag standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flag standardses
	* @param end the upper bound of the range of flag standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of flag standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.FlagStandards> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the flag standardses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of flag standardses.
	*
	* @return the number of flag standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}