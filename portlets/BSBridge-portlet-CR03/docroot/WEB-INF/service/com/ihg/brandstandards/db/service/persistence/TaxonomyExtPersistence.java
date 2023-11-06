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

import com.ihg.brandstandards.db.model.TaxonomyExt;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the Custom Query mapping to create index path. service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see TaxonomyExtPersistenceImpl
 * @see TaxonomyExtUtil
 * @generated
 */
public interface TaxonomyExtPersistence extends BasePersistence<TaxonomyExt> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaxonomyExtUtil} to access the Custom Query mapping to create index path. persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the Custom Query mapping to create index path. where taxId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchTaxonomyExtException} if it could not be found.
	*
	* @param taxId the tax ID
	* @return the matching Custom Query mapping to create index path.
	* @throws com.ihg.brandstandards.db.NoSuchTaxonomyExtException if a matching Custom Query mapping to create index path. could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.TaxonomyExt findBytaxId(long taxId)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyExtException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Custom Query mapping to create index path. where taxId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param taxId the tax ID
	* @return the matching Custom Query mapping to create index path., or <code>null</code> if a matching Custom Query mapping to create index path. could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.TaxonomyExt fetchBytaxId(long taxId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Custom Query mapping to create index path. where taxId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param taxId the tax ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching Custom Query mapping to create index path., or <code>null</code> if a matching Custom Query mapping to create index path. could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.TaxonomyExt fetchBytaxId(
		long taxId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the Custom Query mapping to create index path. where taxId = &#63; from the database.
	*
	* @param taxId the tax ID
	* @return the Custom Query mapping to create index path. that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.TaxonomyExt removeBytaxId(long taxId)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyExtException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Custom Query mapping to create index path.s where taxId = &#63;.
	*
	* @param taxId the tax ID
	* @return the number of matching Custom Query mapping to create index path.s
	* @throws SystemException if a system exception occurred
	*/
	public int countBytaxId(long taxId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the Custom Query mapping to create index path. in the entity cache if it is enabled.
	*
	* @param taxonomyExt the Custom Query mapping to create index path.
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.TaxonomyExt taxonomyExt);

	/**
	* Caches the Custom Query mapping to create index path.s in the entity cache if it is enabled.
	*
	* @param taxonomyExts the Custom Query mapping to create index path.s
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.TaxonomyExt> taxonomyExts);

	/**
	* Creates a new Custom Query mapping to create index path. with the primary key. Does not add the Custom Query mapping to create index path. to the database.
	*
	* @param taxId the primary key for the new Custom Query mapping to create index path.
	* @return the new Custom Query mapping to create index path.
	*/
	public com.ihg.brandstandards.db.model.TaxonomyExt create(long taxId);

	/**
	* Removes the Custom Query mapping to create index path. with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taxId the primary key of the Custom Query mapping to create index path.
	* @return the Custom Query mapping to create index path. that was removed
	* @throws com.ihg.brandstandards.db.NoSuchTaxonomyExtException if a Custom Query mapping to create index path. with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.TaxonomyExt remove(long taxId)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyExtException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.TaxonomyExt updateImpl(
		com.ihg.brandstandards.db.model.TaxonomyExt taxonomyExt)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Custom Query mapping to create index path. with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchTaxonomyExtException} if it could not be found.
	*
	* @param taxId the primary key of the Custom Query mapping to create index path.
	* @return the Custom Query mapping to create index path.
	* @throws com.ihg.brandstandards.db.NoSuchTaxonomyExtException if a Custom Query mapping to create index path. with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.TaxonomyExt findByPrimaryKey(
		long taxId)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyExtException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Custom Query mapping to create index path. with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param taxId the primary key of the Custom Query mapping to create index path.
	* @return the Custom Query mapping to create index path., or <code>null</code> if a Custom Query mapping to create index path. with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.TaxonomyExt fetchByPrimaryKey(
		long taxId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the Custom Query mapping to create index path.s.
	*
	* @return the Custom Query mapping to create index path.s
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.TaxonomyExt> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the Custom Query mapping to create index path.s.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Custom Query mapping to create index path.s
	* @param end the upper bound of the range of Custom Query mapping to create index path.s (not inclusive)
	* @return the range of Custom Query mapping to create index path.s
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.TaxonomyExt> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the Custom Query mapping to create index path.s.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Custom Query mapping to create index path.s
	* @param end the upper bound of the range of Custom Query mapping to create index path.s (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of Custom Query mapping to create index path.s
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.TaxonomyExt> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Custom Query mapping to create index path.s from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Custom Query mapping to create index path.s.
	*
	* @return the number of Custom Query mapping to create index path.s
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}