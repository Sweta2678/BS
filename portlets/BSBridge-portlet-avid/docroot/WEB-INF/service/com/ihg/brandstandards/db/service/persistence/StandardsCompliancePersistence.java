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

import com.ihg.brandstandards.db.model.StandardsCompliance;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the standards compliance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsCompliancePersistenceImpl
 * @see StandardsComplianceUtil
 * @generated
 */
public interface StandardsCompliancePersistence extends BasePersistence<StandardsCompliance> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StandardsComplianceUtil} to access the standards compliance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the standards compliances where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @return the matching standards compliances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCompliance> findByStdChain(
		long stdId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the standards compliances where stdId = &#63; and chainCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsComplianceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param start the lower bound of the range of standards compliances
	* @param end the upper bound of the range of standards compliances (not inclusive)
	* @return the range of matching standards compliances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCompliance> findByStdChain(
		long stdId, java.lang.String chainCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the standards compliances where stdId = &#63; and chainCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsComplianceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param start the lower bound of the range of standards compliances
	* @param end the upper bound of the range of standards compliances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standards compliances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCompliance> findByStdChain(
		long stdId, java.lang.String chainCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standards compliance in the ordered set where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards compliance
	* @throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException if a matching standards compliance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCompliance findByStdChain_First(
		long stdId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standards compliance in the ordered set where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards compliance, or <code>null</code> if a matching standards compliance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCompliance fetchByStdChain_First(
		long stdId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standards compliance in the ordered set where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards compliance
	* @throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException if a matching standards compliance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCompliance findByStdChain_Last(
		long stdId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standards compliance in the ordered set where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards compliance, or <code>null</code> if a matching standards compliance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCompliance fetchByStdChain_Last(
		long stdId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards compliances before and after the current standards compliance in the ordered set where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdComplianceId the primary key of the current standards compliance
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards compliance
	* @throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException if a standards compliance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCompliance[] findByStdChain_PrevAndNext(
		long stdComplianceId, long stdId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standards compliances where stdId = &#63; and chainCode = &#63; from the database.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStdChain(long stdId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standards compliances where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @return the number of matching standards compliances
	* @throws SystemException if a system exception occurred
	*/
	public int countByStdChain(long stdId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards compliance where stdId = &#63; and chainCode = &#63; and countryCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsComplianceException} if it could not be found.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param countryCode the country code
	* @return the matching standards compliance
	* @throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException if a matching standards compliance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCompliance findByStdChainCountry(
		long stdId, java.lang.String chainCode, java.lang.String countryCode)
		throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards compliance where stdId = &#63; and chainCode = &#63; and countryCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param countryCode the country code
	* @return the matching standards compliance, or <code>null</code> if a matching standards compliance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCompliance fetchByStdChainCountry(
		long stdId, java.lang.String chainCode, java.lang.String countryCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards compliance where stdId = &#63; and chainCode = &#63; and countryCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param countryCode the country code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching standards compliance, or <code>null</code> if a matching standards compliance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCompliance fetchByStdChainCountry(
		long stdId, java.lang.String chainCode, java.lang.String countryCode,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the standards compliance where stdId = &#63; and chainCode = &#63; and countryCode = &#63; from the database.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param countryCode the country code
	* @return the standards compliance that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCompliance removeByStdChainCountry(
		long stdId, java.lang.String chainCode, java.lang.String countryCode)
		throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standards compliances where stdId = &#63; and chainCode = &#63; and countryCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param countryCode the country code
	* @return the number of matching standards compliances
	* @throws SystemException if a system exception occurred
	*/
	public int countByStdChainCountry(long stdId, java.lang.String chainCode,
		java.lang.String countryCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the standards compliance in the entity cache if it is enabled.
	*
	* @param standardsCompliance the standards compliance
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.StandardsCompliance standardsCompliance);

	/**
	* Caches the standards compliances in the entity cache if it is enabled.
	*
	* @param standardsCompliances the standards compliances
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.StandardsCompliance> standardsCompliances);

	/**
	* Creates a new standards compliance with the primary key. Does not add the standards compliance to the database.
	*
	* @param stdComplianceId the primary key for the new standards compliance
	* @return the new standards compliance
	*/
	public com.ihg.brandstandards.db.model.StandardsCompliance create(
		long stdComplianceId);

	/**
	* Removes the standards compliance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stdComplianceId the primary key of the standards compliance
	* @return the standards compliance that was removed
	* @throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException if a standards compliance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCompliance remove(
		long stdComplianceId)
		throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.StandardsCompliance updateImpl(
		com.ihg.brandstandards.db.model.StandardsCompliance standardsCompliance)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards compliance with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsComplianceException} if it could not be found.
	*
	* @param stdComplianceId the primary key of the standards compliance
	* @return the standards compliance
	* @throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException if a standards compliance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCompliance findByPrimaryKey(
		long stdComplianceId)
		throws com.ihg.brandstandards.db.NoSuchStandardsComplianceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards compliance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param stdComplianceId the primary key of the standards compliance
	* @return the standards compliance, or <code>null</code> if a standards compliance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCompliance fetchByPrimaryKey(
		long stdComplianceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the standards compliances.
	*
	* @return the standards compliances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCompliance> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the standards compliances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsComplianceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards compliances
	* @param end the upper bound of the range of standards compliances (not inclusive)
	* @return the range of standards compliances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCompliance> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the standards compliances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsComplianceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards compliances
	* @param end the upper bound of the range of standards compliances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of standards compliances
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCompliance> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standards compliances from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standards compliances.
	*
	* @return the number of standards compliances
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}