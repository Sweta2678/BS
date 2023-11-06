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

import com.ihg.brandstandards.db.model.TaxonomyStandards;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the taxonomy standards service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see TaxonomyStandardsPersistenceImpl
 * @see TaxonomyStandardsUtil
 * @generated
 */
public interface TaxonomyStandardsPersistence extends BasePersistence<TaxonomyStandards> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaxonomyStandardsUtil} to access the taxonomy standards persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the taxonomy standards where stdId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchTaxonomyStandardsException} if it could not be found.
	*
	* @param stdId the std ID
	* @return the matching taxonomy standards
	* @throws com.ihg.brandstandards.db.NoSuchTaxonomyStandardsException if a matching taxonomy standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.TaxonomyStandards findByStdId(
		long stdId)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the taxonomy standards where stdId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param stdId the std ID
	* @return the matching taxonomy standards, or <code>null</code> if a matching taxonomy standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.TaxonomyStandards fetchByStdId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the taxonomy standards where stdId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param stdId the std ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching taxonomy standards, or <code>null</code> if a matching taxonomy standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.TaxonomyStandards fetchByStdId(
		long stdId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the taxonomy standards where stdId = &#63; from the database.
	*
	* @param stdId the std ID
	* @return the taxonomy standards that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.TaxonomyStandards removeByStdId(
		long stdId)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of taxonomy standardses where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the number of matching taxonomy standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the taxonomy standards in the entity cache if it is enabled.
	*
	* @param taxonomyStandards the taxonomy standards
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.TaxonomyStandards taxonomyStandards);

	/**
	* Caches the taxonomy standardses in the entity cache if it is enabled.
	*
	* @param taxonomyStandardses the taxonomy standardses
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.TaxonomyStandards> taxonomyStandardses);

	/**
	* Creates a new taxonomy standards with the primary key. Does not add the taxonomy standards to the database.
	*
	* @param stdId the primary key for the new taxonomy standards
	* @return the new taxonomy standards
	*/
	public com.ihg.brandstandards.db.model.TaxonomyStandards create(long stdId);

	/**
	* Removes the taxonomy standards with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stdId the primary key of the taxonomy standards
	* @return the taxonomy standards that was removed
	* @throws com.ihg.brandstandards.db.NoSuchTaxonomyStandardsException if a taxonomy standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.TaxonomyStandards remove(long stdId)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.TaxonomyStandards updateImpl(
		com.ihg.brandstandards.db.model.TaxonomyStandards taxonomyStandards)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the taxonomy standards with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchTaxonomyStandardsException} if it could not be found.
	*
	* @param stdId the primary key of the taxonomy standards
	* @return the taxonomy standards
	* @throws com.ihg.brandstandards.db.NoSuchTaxonomyStandardsException if a taxonomy standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.TaxonomyStandards findByPrimaryKey(
		long stdId)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the taxonomy standards with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param stdId the primary key of the taxonomy standards
	* @return the taxonomy standards, or <code>null</code> if a taxonomy standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.TaxonomyStandards fetchByPrimaryKey(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the taxonomy standardses.
	*
	* @return the taxonomy standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.TaxonomyStandards> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the taxonomy standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of taxonomy standardses
	* @param end the upper bound of the range of taxonomy standardses (not inclusive)
	* @return the range of taxonomy standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.TaxonomyStandards> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the taxonomy standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of taxonomy standardses
	* @param end the upper bound of the range of taxonomy standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of taxonomy standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.TaxonomyStandards> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the taxonomy standardses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of taxonomy standardses.
	*
	* @return the number of taxonomy standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}