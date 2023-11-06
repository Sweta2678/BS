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

import com.ihg.brandstandards.db.model.BrandTaxonomy;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the brand taxonomy service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BrandTaxonomyPersistenceImpl
 * @see BrandTaxonomyUtil
 * @generated
 */
public interface BrandTaxonomyPersistence extends BasePersistence<BrandTaxonomy> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BrandTaxonomyUtil} to access the brand taxonomy persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the brand taxonomy where id = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBrandTaxonomyException} if it could not be found.
	*
	* @param id the ID
	* @return the matching brand taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomy findByid(long id)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the brand taxonomy where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param id the ID
	* @return the matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomy fetchByid(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the brand taxonomy where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param id the ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomy fetchByid(long id,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the brand taxonomy where id = &#63; from the database.
	*
	* @param id the ID
	* @return the brand taxonomy that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomy removeByid(long id)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of brand taxonomies where id = &#63;.
	*
	* @param id the ID
	* @return the number of matching brand taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public int countByid(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the brand taxonomies where taxId = &#63;.
	*
	* @param taxId the tax ID
	* @return the matching brand taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomy> findBytaxId(
		long taxId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the brand taxonomies where taxId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BrandTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param taxId the tax ID
	* @param start the lower bound of the range of brand taxonomies
	* @param end the upper bound of the range of brand taxonomies (not inclusive)
	* @return the range of matching brand taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomy> findBytaxId(
		long taxId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the brand taxonomies where taxId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BrandTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param taxId the tax ID
	* @param start the lower bound of the range of brand taxonomies
	* @param end the upper bound of the range of brand taxonomies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching brand taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomy> findBytaxId(
		long taxId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first brand taxonomy in the ordered set where taxId = &#63;.
	*
	* @param taxId the tax ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching brand taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomy findBytaxId_First(
		long taxId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first brand taxonomy in the ordered set where taxId = &#63;.
	*
	* @param taxId the tax ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomy fetchBytaxId_First(
		long taxId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last brand taxonomy in the ordered set where taxId = &#63;.
	*
	* @param taxId the tax ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching brand taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomy findBytaxId_Last(
		long taxId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last brand taxonomy in the ordered set where taxId = &#63;.
	*
	* @param taxId the tax ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomy fetchBytaxId_Last(
		long taxId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the brand taxonomies before and after the current brand taxonomy in the ordered set where taxId = &#63;.
	*
	* @param id the primary key of the current brand taxonomy
	* @param taxId the tax ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next brand taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a brand taxonomy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomy[] findBytaxId_PrevAndNext(
		long id, long taxId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the brand taxonomies where taxId = &#63; from the database.
	*
	* @param taxId the tax ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBytaxId(long taxId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of brand taxonomies where taxId = &#63;.
	*
	* @param taxId the tax ID
	* @return the number of matching brand taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public int countBytaxId(long taxId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the brand taxonomies where chain = &#63;.
	*
	* @param chain the chain
	* @return the matching brand taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomy> findBychain(
		java.lang.String chain)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the brand taxonomies where chain = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BrandTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param chain the chain
	* @param start the lower bound of the range of brand taxonomies
	* @param end the upper bound of the range of brand taxonomies (not inclusive)
	* @return the range of matching brand taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomy> findBychain(
		java.lang.String chain, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the brand taxonomies where chain = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BrandTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param chain the chain
	* @param start the lower bound of the range of brand taxonomies
	* @param end the upper bound of the range of brand taxonomies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching brand taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomy> findBychain(
		java.lang.String chain, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first brand taxonomy in the ordered set where chain = &#63;.
	*
	* @param chain the chain
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching brand taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomy findBychain_First(
		java.lang.String chain,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first brand taxonomy in the ordered set where chain = &#63;.
	*
	* @param chain the chain
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomy fetchBychain_First(
		java.lang.String chain,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last brand taxonomy in the ordered set where chain = &#63;.
	*
	* @param chain the chain
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching brand taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomy findBychain_Last(
		java.lang.String chain,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last brand taxonomy in the ordered set where chain = &#63;.
	*
	* @param chain the chain
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomy fetchBychain_Last(
		java.lang.String chain,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the brand taxonomies before and after the current brand taxonomy in the ordered set where chain = &#63;.
	*
	* @param id the primary key of the current brand taxonomy
	* @param chain the chain
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next brand taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a brand taxonomy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomy[] findBychain_PrevAndNext(
		long id, java.lang.String chain,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the brand taxonomies where chain = &#63; from the database.
	*
	* @param chain the chain
	* @throws SystemException if a system exception occurred
	*/
	public void removeBychain(java.lang.String chain)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of brand taxonomies where chain = &#63;.
	*
	* @param chain the chain
	* @return the number of matching brand taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public int countBychain(java.lang.String chain)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the brand taxonomy where taxId = &#63; and chain = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBrandTaxonomyException} if it could not be found.
	*
	* @param taxId the tax ID
	* @param chain the chain
	* @return the matching brand taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomy findByTaxIdAndChainCd(
		long taxId, java.lang.String chain)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the brand taxonomy where taxId = &#63; and chain = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param taxId the tax ID
	* @param chain the chain
	* @return the matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomy fetchByTaxIdAndChainCd(
		long taxId, java.lang.String chain)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the brand taxonomy where taxId = &#63; and chain = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param taxId the tax ID
	* @param chain the chain
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomy fetchByTaxIdAndChainCd(
		long taxId, java.lang.String chain, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the brand taxonomy where taxId = &#63; and chain = &#63; from the database.
	*
	* @param taxId the tax ID
	* @param chain the chain
	* @return the brand taxonomy that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomy removeByTaxIdAndChainCd(
		long taxId, java.lang.String chain)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of brand taxonomies where taxId = &#63; and chain = &#63;.
	*
	* @param taxId the tax ID
	* @param chain the chain
	* @return the number of matching brand taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public int countByTaxIdAndChainCd(long taxId, java.lang.String chain)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the brand taxonomies where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @return the matching brand taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomy> findBycreatorId(
		java.lang.String creatorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the brand taxonomies where creatorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BrandTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param creatorId the creator ID
	* @param start the lower bound of the range of brand taxonomies
	* @param end the upper bound of the range of brand taxonomies (not inclusive)
	* @return the range of matching brand taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomy> findBycreatorId(
		java.lang.String creatorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the brand taxonomies where creatorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BrandTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param creatorId the creator ID
	* @param start the lower bound of the range of brand taxonomies
	* @param end the upper bound of the range of brand taxonomies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching brand taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomy> findBycreatorId(
		java.lang.String creatorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first brand taxonomy in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching brand taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomy findBycreatorId_First(
		java.lang.String creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first brand taxonomy in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomy fetchBycreatorId_First(
		java.lang.String creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last brand taxonomy in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching brand taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomy findBycreatorId_Last(
		java.lang.String creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last brand taxonomy in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomy fetchBycreatorId_Last(
		java.lang.String creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the brand taxonomies before and after the current brand taxonomy in the ordered set where creatorId = &#63;.
	*
	* @param id the primary key of the current brand taxonomy
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next brand taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a brand taxonomy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomy[] findBycreatorId_PrevAndNext(
		long id, java.lang.String creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the brand taxonomies where creatorId = &#63; from the database.
	*
	* @param creatorId the creator ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBycreatorId(java.lang.String creatorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of brand taxonomies where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @return the number of matching brand taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public int countBycreatorId(java.lang.String creatorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the brand taxonomy in the entity cache if it is enabled.
	*
	* @param brandTaxonomy the brand taxonomy
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.BrandTaxonomy brandTaxonomy);

	/**
	* Caches the brand taxonomies in the entity cache if it is enabled.
	*
	* @param brandTaxonomies the brand taxonomies
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomy> brandTaxonomies);

	/**
	* Creates a new brand taxonomy with the primary key. Does not add the brand taxonomy to the database.
	*
	* @param id the primary key for the new brand taxonomy
	* @return the new brand taxonomy
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomy create(long id);

	/**
	* Removes the brand taxonomy with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the brand taxonomy
	* @return the brand taxonomy that was removed
	* @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a brand taxonomy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomy remove(long id)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.BrandTaxonomy updateImpl(
		com.ihg.brandstandards.db.model.BrandTaxonomy brandTaxonomy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the brand taxonomy with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBrandTaxonomyException} if it could not be found.
	*
	* @param id the primary key of the brand taxonomy
	* @return the brand taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a brand taxonomy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomy findByPrimaryKey(
		long id)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the brand taxonomy with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the brand taxonomy
	* @return the brand taxonomy, or <code>null</code> if a brand taxonomy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomy fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the brand taxonomies.
	*
	* @return the brand taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomy> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the brand taxonomies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BrandTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of brand taxonomies
	* @param end the upper bound of the range of brand taxonomies (not inclusive)
	* @return the range of brand taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomy> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the brand taxonomies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BrandTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of brand taxonomies
	* @param end the upper bound of the range of brand taxonomies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of brand taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the brand taxonomies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of brand taxonomies.
	*
	* @return the number of brand taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}