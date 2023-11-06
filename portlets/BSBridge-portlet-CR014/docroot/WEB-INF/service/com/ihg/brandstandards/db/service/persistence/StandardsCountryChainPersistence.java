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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the standards country chain service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsCountryChainPersistenceImpl
 * @see StandardsCountryChainUtil
 * @generated
 */
public interface StandardsCountryChainPersistence extends BasePersistence<StandardsCountryChain> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StandardsCountryChainUtil} to access the standards country chain persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the standards country chains where stdId = &#63; and chainCode = &#63; and compDate = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param compDate the comp date
	* @return the matching standards country chains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> findBystdIdDateChCode(
		long stdId, java.lang.String chainCode, java.util.Date compDate)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> findBystdIdDateChCode(
		long stdId, java.lang.String chainCode, java.util.Date compDate,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> findBystdIdDateChCode(
		long stdId, java.lang.String chainCode, java.util.Date compDate,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.StandardsCountryChain findBystdIdDateChCode_First(
		long stdId, java.lang.String chainCode, java.util.Date compDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.StandardsCountryChain fetchBystdIdDateChCode_First(
		long stdId, java.lang.String chainCode, java.util.Date compDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.StandardsCountryChain findBystdIdDateChCode_Last(
		long stdId, java.lang.String chainCode, java.util.Date compDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.StandardsCountryChain fetchBystdIdDateChCode_Last(
		long stdId, java.lang.String chainCode, java.util.Date compDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.StandardsCountryChain[] findBystdIdDateChCode_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK standardsCountryChainPK,
		long stdId, java.lang.String chainCode, java.util.Date compDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standards country chains where stdId = &#63; and chainCode = &#63; and compDate = &#63; from the database.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param compDate the comp date
	* @throws SystemException if a system exception occurred
	*/
	public void removeBystdIdDateChCode(long stdId, java.lang.String chainCode,
		java.util.Date compDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standards country chains where stdId = &#63; and chainCode = &#63; and compDate = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param compDate the comp date
	* @return the number of matching standards country chains
	* @throws SystemException if a system exception occurred
	*/
	public int countBystdIdDateChCode(long stdId, java.lang.String chainCode,
		java.util.Date compDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the standards country chains where stdId = &#63; and chainCode = &#63; and regionCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param regionCode the region code
	* @return the matching standards country chains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> findByStdIdChainRegion(
		long stdId, java.lang.String chainCode, java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> findByStdIdChainRegion(
		long stdId, java.lang.String chainCode, java.lang.String regionCode,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> findByStdIdChainRegion(
		long stdId, java.lang.String chainCode, java.lang.String regionCode,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.StandardsCountryChain findByStdIdChainRegion_First(
		long stdId, java.lang.String chainCode, java.lang.String regionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.StandardsCountryChain fetchByStdIdChainRegion_First(
		long stdId, java.lang.String chainCode, java.lang.String regionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.StandardsCountryChain findByStdIdChainRegion_Last(
		long stdId, java.lang.String chainCode, java.lang.String regionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.StandardsCountryChain fetchByStdIdChainRegion_Last(
		long stdId, java.lang.String chainCode, java.lang.String regionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.StandardsCountryChain[] findByStdIdChainRegion_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK standardsCountryChainPK,
		long stdId, java.lang.String chainCode, java.lang.String regionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standards country chains where stdId = &#63; and chainCode = &#63; and regionCode = &#63; from the database.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param regionCode the region code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStdIdChainRegion(long stdId,
		java.lang.String chainCode, java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standards country chains where stdId = &#63; and chainCode = &#63; and regionCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param regionCode the region code
	* @return the number of matching standards country chains
	* @throws SystemException if a system exception occurred
	*/
	public int countByStdIdChainRegion(long stdId, java.lang.String chainCode,
		java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the standards country chains where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @return the matching standards country chains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> findByStdIdChain(
		long stdId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> findByStdIdChain(
		long stdId, java.lang.String chainCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> findByStdIdChain(
		long stdId, java.lang.String chainCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.StandardsCountryChain findByStdIdChain_First(
		long stdId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standards country chain in the ordered set where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards country chain, or <code>null</code> if a matching standards country chain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCountryChain fetchByStdIdChain_First(
		long stdId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.StandardsCountryChain findByStdIdChain_Last(
		long stdId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standards country chain in the ordered set where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards country chain, or <code>null</code> if a matching standards country chain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCountryChain fetchByStdIdChain_Last(
		long stdId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.StandardsCountryChain[] findByStdIdChain_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK standardsCountryChainPK,
		long stdId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standards country chains where stdId = &#63; and chainCode = &#63; from the database.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStdIdChain(long stdId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standards country chains where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @return the number of matching standards country chains
	* @throws SystemException if a system exception occurred
	*/
	public int countByStdIdChain(long stdId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the standards country chain in the entity cache if it is enabled.
	*
	* @param standardsCountryChain the standards country chain
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.StandardsCountryChain standardsCountryChain);

	/**
	* Caches the standards country chains in the entity cache if it is enabled.
	*
	* @param standardsCountryChains the standards country chains
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> standardsCountryChains);

	/**
	* Creates a new standards country chain with the primary key. Does not add the standards country chain to the database.
	*
	* @param standardsCountryChainPK the primary key for the new standards country chain
	* @return the new standards country chain
	*/
	public com.ihg.brandstandards.db.model.StandardsCountryChain create(
		com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK standardsCountryChainPK);

	/**
	* Removes the standards country chain with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsCountryChainPK the primary key of the standards country chain
	* @return the standards country chain that was removed
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException if a standards country chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCountryChain remove(
		com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK standardsCountryChainPK)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.StandardsCountryChain updateImpl(
		com.ihg.brandstandards.db.model.StandardsCountryChain standardsCountryChain)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards country chain with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsCountryChainException} if it could not be found.
	*
	* @param standardsCountryChainPK the primary key of the standards country chain
	* @return the standards country chain
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException if a standards country chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCountryChain findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK standardsCountryChainPK)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryChainException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards country chain with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param standardsCountryChainPK the primary key of the standards country chain
	* @return the standards country chain, or <code>null</code> if a standards country chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCountryChain fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK standardsCountryChainPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the standards country chains.
	*
	* @return the standards country chains
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standards country chains from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standards country chains.
	*
	* @return the number of standards country chains
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}