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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the brand taxonomy service. This utility wraps {@link BrandTaxonomyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BrandTaxonomyPersistence
 * @see BrandTaxonomyPersistenceImpl
 * @generated
 */
public class BrandTaxonomyUtil {
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
	public static void clearCache(BrandTaxonomy brandTaxonomy) {
		getPersistence().clearCache(brandTaxonomy);
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
	public static List<BrandTaxonomy> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BrandTaxonomy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BrandTaxonomy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static BrandTaxonomy update(BrandTaxonomy brandTaxonomy)
		throws SystemException {
		return getPersistence().update(brandTaxonomy);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static BrandTaxonomy update(BrandTaxonomy brandTaxonomy,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(brandTaxonomy, serviceContext);
	}

	/**
	* Returns the brand taxonomy where id = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBrandTaxonomyException} if it could not be found.
	*
	* @param id the ID
	* @return the matching brand taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BrandTaxonomy findByid(
		long id)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByid(id);
	}

	/**
	* Returns the brand taxonomy where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param id the ID
	* @return the matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BrandTaxonomy fetchByid(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByid(id);
	}

	/**
	* Returns the brand taxonomy where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param id the ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BrandTaxonomy fetchByid(
		long id, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByid(id, retrieveFromCache);
	}

	/**
	* Removes the brand taxonomy where id = &#63; from the database.
	*
	* @param id the ID
	* @return the brand taxonomy that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BrandTaxonomy removeByid(
		long id)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByid(id);
	}

	/**
	* Returns the number of brand taxonomies where id = &#63;.
	*
	* @param id the ID
	* @return the number of matching brand taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByid(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByid(id);
	}

	/**
	* Returns all the brand taxonomies where taxId = &#63;.
	*
	* @param taxId the tax ID
	* @return the matching brand taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomy> findBytaxId(
		long taxId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBytaxId(taxId);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomy> findBytaxId(
		long taxId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBytaxId(taxId, start, end);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomy> findBytaxId(
		long taxId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBytaxId(taxId, start, end, orderByComparator);
	}

	/**
	* Returns the first brand taxonomy in the ordered set where taxId = &#63;.
	*
	* @param taxId the tax ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching brand taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BrandTaxonomy findBytaxId_First(
		long taxId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBytaxId_First(taxId, orderByComparator);
	}

	/**
	* Returns the first brand taxonomy in the ordered set where taxId = &#63;.
	*
	* @param taxId the tax ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BrandTaxonomy fetchBytaxId_First(
		long taxId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBytaxId_First(taxId, orderByComparator);
	}

	/**
	* Returns the last brand taxonomy in the ordered set where taxId = &#63;.
	*
	* @param taxId the tax ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching brand taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BrandTaxonomy findBytaxId_Last(
		long taxId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBytaxId_Last(taxId, orderByComparator);
	}

	/**
	* Returns the last brand taxonomy in the ordered set where taxId = &#63;.
	*
	* @param taxId the tax ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BrandTaxonomy fetchBytaxId_Last(
		long taxId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBytaxId_Last(taxId, orderByComparator);
	}

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
	public static com.ihg.brandstandards.db.model.BrandTaxonomy[] findBytaxId_PrevAndNext(
		long id, long taxId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBytaxId_PrevAndNext(id, taxId, orderByComparator);
	}

	/**
	* Removes all the brand taxonomies where taxId = &#63; from the database.
	*
	* @param taxId the tax ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBytaxId(long taxId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBytaxId(taxId);
	}

	/**
	* Returns the number of brand taxonomies where taxId = &#63;.
	*
	* @param taxId the tax ID
	* @return the number of matching brand taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static int countBytaxId(long taxId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBytaxId(taxId);
	}

	/**
	* Returns all the brand taxonomies where chain = &#63;.
	*
	* @param chain the chain
	* @return the matching brand taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomy> findBychain(
		java.lang.String chain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBychain(chain);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomy> findBychain(
		java.lang.String chain, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBychain(chain, start, end);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomy> findBychain(
		java.lang.String chain, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBychain(chain, start, end, orderByComparator);
	}

	/**
	* Returns the first brand taxonomy in the ordered set where chain = &#63;.
	*
	* @param chain the chain
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching brand taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BrandTaxonomy findBychain_First(
		java.lang.String chain,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBychain_First(chain, orderByComparator);
	}

	/**
	* Returns the first brand taxonomy in the ordered set where chain = &#63;.
	*
	* @param chain the chain
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BrandTaxonomy fetchBychain_First(
		java.lang.String chain,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBychain_First(chain, orderByComparator);
	}

	/**
	* Returns the last brand taxonomy in the ordered set where chain = &#63;.
	*
	* @param chain the chain
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching brand taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BrandTaxonomy findBychain_Last(
		java.lang.String chain,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBychain_Last(chain, orderByComparator);
	}

	/**
	* Returns the last brand taxonomy in the ordered set where chain = &#63;.
	*
	* @param chain the chain
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BrandTaxonomy fetchBychain_Last(
		java.lang.String chain,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBychain_Last(chain, orderByComparator);
	}

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
	public static com.ihg.brandstandards.db.model.BrandTaxonomy[] findBychain_PrevAndNext(
		long id, java.lang.String chain,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBychain_PrevAndNext(id, chain, orderByComparator);
	}

	/**
	* Removes all the brand taxonomies where chain = &#63; from the database.
	*
	* @param chain the chain
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBychain(java.lang.String chain)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBychain(chain);
	}

	/**
	* Returns the number of brand taxonomies where chain = &#63;.
	*
	* @param chain the chain
	* @return the number of matching brand taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static int countBychain(java.lang.String chain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBychain(chain);
	}

	/**
	* Returns the brand taxonomy where taxId = &#63; and chain = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBrandTaxonomyException} if it could not be found.
	*
	* @param taxId the tax ID
	* @param chain the chain
	* @return the matching brand taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BrandTaxonomy findByTaxIdAndChainCd(
		long taxId, java.lang.String chain)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTaxIdAndChainCd(taxId, chain);
	}

	/**
	* Returns the brand taxonomy where taxId = &#63; and chain = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param taxId the tax ID
	* @param chain the chain
	* @return the matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BrandTaxonomy fetchByTaxIdAndChainCd(
		long taxId, java.lang.String chain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTaxIdAndChainCd(taxId, chain);
	}

	/**
	* Returns the brand taxonomy where taxId = &#63; and chain = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param taxId the tax ID
	* @param chain the chain
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BrandTaxonomy fetchByTaxIdAndChainCd(
		long taxId, java.lang.String chain, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTaxIdAndChainCd(taxId, chain, retrieveFromCache);
	}

	/**
	* Removes the brand taxonomy where taxId = &#63; and chain = &#63; from the database.
	*
	* @param taxId the tax ID
	* @param chain the chain
	* @return the brand taxonomy that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BrandTaxonomy removeByTaxIdAndChainCd(
		long taxId, java.lang.String chain)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByTaxIdAndChainCd(taxId, chain);
	}

	/**
	* Returns the number of brand taxonomies where taxId = &#63; and chain = &#63;.
	*
	* @param taxId the tax ID
	* @param chain the chain
	* @return the number of matching brand taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTaxIdAndChainCd(long taxId, java.lang.String chain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTaxIdAndChainCd(taxId, chain);
	}

	/**
	* Returns all the brand taxonomies where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @return the matching brand taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomy> findBycreatorId(
		java.lang.String creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycreatorId(creatorId);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomy> findBycreatorId(
		java.lang.String creatorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycreatorId(creatorId, start, end);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomy> findBycreatorId(
		java.lang.String creatorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycreatorId(creatorId, start, end, orderByComparator);
	}

	/**
	* Returns the first brand taxonomy in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching brand taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BrandTaxonomy findBycreatorId_First(
		java.lang.String creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycreatorId_First(creatorId, orderByComparator);
	}

	/**
	* Returns the first brand taxonomy in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BrandTaxonomy fetchBycreatorId_First(
		java.lang.String creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycreatorId_First(creatorId, orderByComparator);
	}

	/**
	* Returns the last brand taxonomy in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching brand taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BrandTaxonomy findBycreatorId_Last(
		java.lang.String creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycreatorId_Last(creatorId, orderByComparator);
	}

	/**
	* Returns the last brand taxonomy in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BrandTaxonomy fetchBycreatorId_Last(
		java.lang.String creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycreatorId_Last(creatorId, orderByComparator);
	}

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
	public static com.ihg.brandstandards.db.model.BrandTaxonomy[] findBycreatorId_PrevAndNext(
		long id, java.lang.String creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycreatorId_PrevAndNext(id, creatorId, orderByComparator);
	}

	/**
	* Removes all the brand taxonomies where creatorId = &#63; from the database.
	*
	* @param creatorId the creator ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBycreatorId(java.lang.String creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBycreatorId(creatorId);
	}

	/**
	* Returns the number of brand taxonomies where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @return the number of matching brand taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static int countBycreatorId(java.lang.String creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBycreatorId(creatorId);
	}

	/**
	* Caches the brand taxonomy in the entity cache if it is enabled.
	*
	* @param brandTaxonomy the brand taxonomy
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.BrandTaxonomy brandTaxonomy) {
		getPersistence().cacheResult(brandTaxonomy);
	}

	/**
	* Caches the brand taxonomies in the entity cache if it is enabled.
	*
	* @param brandTaxonomies the brand taxonomies
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomy> brandTaxonomies) {
		getPersistence().cacheResult(brandTaxonomies);
	}

	/**
	* Creates a new brand taxonomy with the primary key. Does not add the brand taxonomy to the database.
	*
	* @param id the primary key for the new brand taxonomy
	* @return the new brand taxonomy
	*/
	public static com.ihg.brandstandards.db.model.BrandTaxonomy create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the brand taxonomy with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the brand taxonomy
	* @return the brand taxonomy that was removed
	* @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a brand taxonomy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BrandTaxonomy remove(long id)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static com.ihg.brandstandards.db.model.BrandTaxonomy updateImpl(
		com.ihg.brandstandards.db.model.BrandTaxonomy brandTaxonomy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(brandTaxonomy);
	}

	/**
	* Returns the brand taxonomy with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBrandTaxonomyException} if it could not be found.
	*
	* @param id the primary key of the brand taxonomy
	* @return the brand taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a brand taxonomy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BrandTaxonomy findByPrimaryKey(
		long id)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the brand taxonomy with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the brand taxonomy
	* @return the brand taxonomy, or <code>null</code> if a brand taxonomy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BrandTaxonomy fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the brand taxonomies.
	*
	* @return the brand taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomy> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomy> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the brand taxonomies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of brand taxonomies.
	*
	* @return the number of brand taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BrandTaxonomyPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BrandTaxonomyPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					BrandTaxonomyPersistence.class.getName());

			ReferenceRegistry.registerReference(BrandTaxonomyUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BrandTaxonomyPersistence persistence) {
	}

	private static BrandTaxonomyPersistence _persistence;
}