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

import com.ihg.brandstandards.db.model.Taxonomy;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the taxonomy service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see TaxonomyPersistenceImpl
 * @see TaxonomyUtil
 * @generated
 */
public interface TaxonomyPersistence extends BasePersistence<Taxonomy> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaxonomyUtil} to access the taxonomy persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the taxonomy where taxId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchTaxonomyException} if it could not be found.
	*
	* @param taxId the tax ID
	* @return the matching taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchTaxonomyException if a matching taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Taxonomy findBytaxId(long taxId)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the taxonomy where taxId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param taxId the tax ID
	* @return the matching taxonomy, or <code>null</code> if a matching taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Taxonomy fetchBytaxId(long taxId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the taxonomy where taxId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param taxId the tax ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching taxonomy, or <code>null</code> if a matching taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Taxonomy fetchBytaxId(long taxId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the taxonomy where taxId = &#63; from the database.
	*
	* @param taxId the tax ID
	* @return the taxonomy that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Taxonomy removeBytaxId(long taxId)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of taxonomies where taxId = &#63;.
	*
	* @param taxId the tax ID
	* @return the number of matching taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public int countBytaxId(long taxId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the taxonomies where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @return the matching taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Taxonomy> findByparentId(
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the taxonomies where parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentId the parent ID
	* @param start the lower bound of the range of taxonomies
	* @param end the upper bound of the range of taxonomies (not inclusive)
	* @return the range of matching taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Taxonomy> findByparentId(
		long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the taxonomies where parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentId the parent ID
	* @param start the lower bound of the range of taxonomies
	* @param end the upper bound of the range of taxonomies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Taxonomy> findByparentId(
		long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first taxonomy in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchTaxonomyException if a matching taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Taxonomy findByparentId_First(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first taxonomy in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching taxonomy, or <code>null</code> if a matching taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Taxonomy fetchByparentId_First(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last taxonomy in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchTaxonomyException if a matching taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Taxonomy findByparentId_Last(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last taxonomy in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching taxonomy, or <code>null</code> if a matching taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Taxonomy fetchByparentId_Last(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the taxonomies before and after the current taxonomy in the ordered set where parentId = &#63;.
	*
	* @param taxId the primary key of the current taxonomy
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchTaxonomyException if a taxonomy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Taxonomy[] findByparentId_PrevAndNext(
		long taxId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the taxonomies where parentId = &#63; from the database.
	*
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByparentId(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of taxonomies where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @return the number of matching taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public int countByparentId(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the taxonomies where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @return the matching taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Taxonomy> findBycreatorId(
		java.lang.String creatorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the taxonomies where creatorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param creatorId the creator ID
	* @param start the lower bound of the range of taxonomies
	* @param end the upper bound of the range of taxonomies (not inclusive)
	* @return the range of matching taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Taxonomy> findBycreatorId(
		java.lang.String creatorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the taxonomies where creatorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param creatorId the creator ID
	* @param start the lower bound of the range of taxonomies
	* @param end the upper bound of the range of taxonomies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Taxonomy> findBycreatorId(
		java.lang.String creatorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first taxonomy in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchTaxonomyException if a matching taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Taxonomy findBycreatorId_First(
		java.lang.String creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first taxonomy in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching taxonomy, or <code>null</code> if a matching taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Taxonomy fetchBycreatorId_First(
		java.lang.String creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last taxonomy in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchTaxonomyException if a matching taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Taxonomy findBycreatorId_Last(
		java.lang.String creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last taxonomy in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching taxonomy, or <code>null</code> if a matching taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Taxonomy fetchBycreatorId_Last(
		java.lang.String creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the taxonomies before and after the current taxonomy in the ordered set where creatorId = &#63;.
	*
	* @param taxId the primary key of the current taxonomy
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchTaxonomyException if a taxonomy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Taxonomy[] findBycreatorId_PrevAndNext(
		long taxId, java.lang.String creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the taxonomies where creatorId = &#63; from the database.
	*
	* @param creatorId the creator ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBycreatorId(java.lang.String creatorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of taxonomies where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @return the number of matching taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public int countBycreatorId(java.lang.String creatorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the taxonomy in the entity cache if it is enabled.
	*
	* @param taxonomy the taxonomy
	*/
	public void cacheResult(com.ihg.brandstandards.db.model.Taxonomy taxonomy);

	/**
	* Caches the taxonomies in the entity cache if it is enabled.
	*
	* @param taxonomies the taxonomies
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.Taxonomy> taxonomies);

	/**
	* Creates a new taxonomy with the primary key. Does not add the taxonomy to the database.
	*
	* @param taxId the primary key for the new taxonomy
	* @return the new taxonomy
	*/
	public com.ihg.brandstandards.db.model.Taxonomy create(long taxId);

	/**
	* Removes the taxonomy with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taxId the primary key of the taxonomy
	* @return the taxonomy that was removed
	* @throws com.ihg.brandstandards.db.NoSuchTaxonomyException if a taxonomy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Taxonomy remove(long taxId)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.Taxonomy updateImpl(
		com.ihg.brandstandards.db.model.Taxonomy taxonomy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the taxonomy with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchTaxonomyException} if it could not be found.
	*
	* @param taxId the primary key of the taxonomy
	* @return the taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchTaxonomyException if a taxonomy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Taxonomy findByPrimaryKey(long taxId)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the taxonomy with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param taxId the primary key of the taxonomy
	* @return the taxonomy, or <code>null</code> if a taxonomy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Taxonomy fetchByPrimaryKey(
		long taxId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the taxonomies.
	*
	* @return the taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Taxonomy> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the taxonomies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of taxonomies
	* @param end the upper bound of the range of taxonomies (not inclusive)
	* @return the range of taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Taxonomy> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the taxonomies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of taxonomies
	* @param end the upper bound of the range of taxonomies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Taxonomy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the taxonomies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of taxonomies.
	*
	* @return the number of taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}