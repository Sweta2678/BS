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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the taxonomy service. This utility wraps {@link TaxonomyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see TaxonomyPersistence
 * @see TaxonomyPersistenceImpl
 * @generated
 */
public class TaxonomyUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Taxonomy taxonomy) {
		getPersistence().clearCache(taxonomy);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Taxonomy> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Taxonomy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Taxonomy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Taxonomy update(Taxonomy taxonomy) throws SystemException {
		return getPersistence().update(taxonomy);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Taxonomy update(Taxonomy taxonomy,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(taxonomy, serviceContext);
	}

	/**
	* Returns the taxonomy where taxId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchTaxonomyException} if it could not be found.
	*
	* @param taxId the tax ID
	* @return the matching taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchTaxonomyException if a matching taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Taxonomy findBytaxId(
		long taxId)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBytaxId(taxId);
	}

	/**
	* Returns the taxonomy where taxId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param taxId the tax ID
	* @return the matching taxonomy, or <code>null</code> if a matching taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Taxonomy fetchBytaxId(
		long taxId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBytaxId(taxId);
	}

	/**
	* Returns the taxonomy where taxId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param taxId the tax ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching taxonomy, or <code>null</code> if a matching taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Taxonomy fetchBytaxId(
		long taxId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBytaxId(taxId, retrieveFromCache);
	}

	/**
	* Removes the taxonomy where taxId = &#63; from the database.
	*
	* @param taxId the tax ID
	* @return the taxonomy that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Taxonomy removeBytaxId(
		long taxId)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeBytaxId(taxId);
	}

	/**
	* Returns the number of taxonomies where taxId = &#63;.
	*
	* @param taxId the tax ID
	* @return the number of matching taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static int countBytaxId(long taxId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBytaxId(taxId);
	}

	/**
	* Returns all the taxonomies where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @return the matching taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Taxonomy> findByparentId(
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByparentId(parentId);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.Taxonomy> findByparentId(
		long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByparentId(parentId, start, end);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.Taxonomy> findByparentId(
		long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentId(parentId, start, end, orderByComparator);
	}

	/**
	* Returns the first taxonomy in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchTaxonomyException if a matching taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Taxonomy findByparentId_First(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByparentId_First(parentId, orderByComparator);
	}

	/**
	* Returns the first taxonomy in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching taxonomy, or <code>null</code> if a matching taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Taxonomy fetchByparentId_First(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByparentId_First(parentId, orderByComparator);
	}

	/**
	* Returns the last taxonomy in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchTaxonomyException if a matching taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Taxonomy findByparentId_Last(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByparentId_Last(parentId, orderByComparator);
	}

	/**
	* Returns the last taxonomy in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching taxonomy, or <code>null</code> if a matching taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Taxonomy fetchByparentId_Last(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByparentId_Last(parentId, orderByComparator);
	}

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
	public static com.ihg.brandstandards.db.model.Taxonomy[] findByparentId_PrevAndNext(
		long taxId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentId_PrevAndNext(taxId, parentId,
			orderByComparator);
	}

	/**
	* Removes all the taxonomies where parentId = &#63; from the database.
	*
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByparentId(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByparentId(parentId);
	}

	/**
	* Returns the number of taxonomies where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @return the number of matching taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByparentId(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByparentId(parentId);
	}

	/**
	* Returns all the taxonomies where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @return the matching taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Taxonomy> findBycreatorId(
		java.lang.String creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycreatorId(creatorId);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.Taxonomy> findBycreatorId(
		java.lang.String creatorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycreatorId(creatorId, start, end);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.Taxonomy> findBycreatorId(
		java.lang.String creatorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycreatorId(creatorId, start, end, orderByComparator);
	}

	/**
	* Returns the first taxonomy in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchTaxonomyException if a matching taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Taxonomy findBycreatorId_First(
		java.lang.String creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycreatorId_First(creatorId, orderByComparator);
	}

	/**
	* Returns the first taxonomy in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching taxonomy, or <code>null</code> if a matching taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Taxonomy fetchBycreatorId_First(
		java.lang.String creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycreatorId_First(creatorId, orderByComparator);
	}

	/**
	* Returns the last taxonomy in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchTaxonomyException if a matching taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Taxonomy findBycreatorId_Last(
		java.lang.String creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycreatorId_Last(creatorId, orderByComparator);
	}

	/**
	* Returns the last taxonomy in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching taxonomy, or <code>null</code> if a matching taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Taxonomy fetchBycreatorId_Last(
		java.lang.String creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycreatorId_Last(creatorId, orderByComparator);
	}

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
	public static com.ihg.brandstandards.db.model.Taxonomy[] findBycreatorId_PrevAndNext(
		long taxId, java.lang.String creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycreatorId_PrevAndNext(taxId, creatorId,
			orderByComparator);
	}

	/**
	* Removes all the taxonomies where creatorId = &#63; from the database.
	*
	* @param creatorId the creator ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBycreatorId(java.lang.String creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBycreatorId(creatorId);
	}

	/**
	* Returns the number of taxonomies where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @return the number of matching taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static int countBycreatorId(java.lang.String creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBycreatorId(creatorId);
	}

	/**
	* Caches the taxonomy in the entity cache if it is enabled.
	*
	* @param taxonomy the taxonomy
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.Taxonomy taxonomy) {
		getPersistence().cacheResult(taxonomy);
	}

	/**
	* Caches the taxonomies in the entity cache if it is enabled.
	*
	* @param taxonomies the taxonomies
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.Taxonomy> taxonomies) {
		getPersistence().cacheResult(taxonomies);
	}

	/**
	* Creates a new taxonomy with the primary key. Does not add the taxonomy to the database.
	*
	* @param taxId the primary key for the new taxonomy
	* @return the new taxonomy
	*/
	public static com.ihg.brandstandards.db.model.Taxonomy create(long taxId) {
		return getPersistence().create(taxId);
	}

	/**
	* Removes the taxonomy with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taxId the primary key of the taxonomy
	* @return the taxonomy that was removed
	* @throws com.ihg.brandstandards.db.NoSuchTaxonomyException if a taxonomy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Taxonomy remove(long taxId)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(taxId);
	}

	public static com.ihg.brandstandards.db.model.Taxonomy updateImpl(
		com.ihg.brandstandards.db.model.Taxonomy taxonomy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(taxonomy);
	}

	/**
	* Returns the taxonomy with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchTaxonomyException} if it could not be found.
	*
	* @param taxId the primary key of the taxonomy
	* @return the taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchTaxonomyException if a taxonomy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Taxonomy findByPrimaryKey(
		long taxId)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(taxId);
	}

	/**
	* Returns the taxonomy with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param taxId the primary key of the taxonomy
	* @return the taxonomy, or <code>null</code> if a taxonomy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Taxonomy fetchByPrimaryKey(
		long taxId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(taxId);
	}

	/**
	* Returns all the taxonomies.
	*
	* @return the taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Taxonomy> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.Taxonomy> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.Taxonomy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the taxonomies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of taxonomies.
	*
	* @return the number of taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TaxonomyPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TaxonomyPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					TaxonomyPersistence.class.getName());

			ReferenceRegistry.registerReference(TaxonomyUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TaxonomyPersistence persistence) {
	}

	private static TaxonomyPersistence _persistence;
}