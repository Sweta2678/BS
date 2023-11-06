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

import com.ihg.brandstandards.db.model.PublishTaxonomy;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the publish taxonomy service. This utility wraps {@link PublishTaxonomyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see PublishTaxonomyPersistence
 * @see PublishTaxonomyPersistenceImpl
 * @generated
 */
public class PublishTaxonomyUtil {
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
	public static void clearCache(PublishTaxonomy publishTaxonomy) {
		getPersistence().clearCache(publishTaxonomy);
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
	public static List<PublishTaxonomy> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PublishTaxonomy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PublishTaxonomy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static PublishTaxonomy update(PublishTaxonomy publishTaxonomy)
		throws SystemException {
		return getPersistence().update(publishTaxonomy);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static PublishTaxonomy update(PublishTaxonomy publishTaxonomy,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(publishTaxonomy, serviceContext);
	}

	/**
	* Returns the publish taxonomy where taxId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublishTaxonomyException} if it could not be found.
	*
	* @param taxId the tax ID
	* @return the matching publish taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException if a matching publish taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishTaxonomy findBypublishTaxId(
		long taxId)
		throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBypublishTaxId(taxId);
	}

	/**
	* Returns the publish taxonomy where taxId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param taxId the tax ID
	* @return the matching publish taxonomy, or <code>null</code> if a matching publish taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishTaxonomy fetchBypublishTaxId(
		long taxId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBypublishTaxId(taxId);
	}

	/**
	* Returns the publish taxonomy where taxId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param taxId the tax ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching publish taxonomy, or <code>null</code> if a matching publish taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishTaxonomy fetchBypublishTaxId(
		long taxId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBypublishTaxId(taxId, retrieveFromCache);
	}

	/**
	* Removes the publish taxonomy where taxId = &#63; from the database.
	*
	* @param taxId the tax ID
	* @return the publish taxonomy that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishTaxonomy removeBypublishTaxId(
		long taxId)
		throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeBypublishTaxId(taxId);
	}

	/**
	* Returns the number of publish taxonomies where taxId = &#63;.
	*
	* @param taxId the tax ID
	* @return the number of matching publish taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static int countBypublishTaxId(long taxId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBypublishTaxId(taxId);
	}

	/**
	* Returns all the publish taxonomies where publishParentId = &#63;.
	*
	* @param publishParentId the publish parent ID
	* @return the matching publish taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishTaxonomy> findBypublishParentId(
		long publishParentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBypublishParentId(publishParentId);
	}

	/**
	* Returns a range of all the publish taxonomies where publishParentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishParentId the publish parent ID
	* @param start the lower bound of the range of publish taxonomies
	* @param end the upper bound of the range of publish taxonomies (not inclusive)
	* @return the range of matching publish taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishTaxonomy> findBypublishParentId(
		long publishParentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublishParentId(publishParentId, start, end);
	}

	/**
	* Returns an ordered range of all the publish taxonomies where publishParentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishParentId the publish parent ID
	* @param start the lower bound of the range of publish taxonomies
	* @param end the upper bound of the range of publish taxonomies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching publish taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishTaxonomy> findBypublishParentId(
		long publishParentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublishParentId(publishParentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first publish taxonomy in the ordered set where publishParentId = &#63;.
	*
	* @param publishParentId the publish parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publish taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException if a matching publish taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishTaxonomy findBypublishParentId_First(
		long publishParentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublishParentId_First(publishParentId,
			orderByComparator);
	}

	/**
	* Returns the first publish taxonomy in the ordered set where publishParentId = &#63;.
	*
	* @param publishParentId the publish parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publish taxonomy, or <code>null</code> if a matching publish taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishTaxonomy fetchBypublishParentId_First(
		long publishParentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBypublishParentId_First(publishParentId,
			orderByComparator);
	}

	/**
	* Returns the last publish taxonomy in the ordered set where publishParentId = &#63;.
	*
	* @param publishParentId the publish parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publish taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException if a matching publish taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishTaxonomy findBypublishParentId_Last(
		long publishParentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublishParentId_Last(publishParentId,
			orderByComparator);
	}

	/**
	* Returns the last publish taxonomy in the ordered set where publishParentId = &#63;.
	*
	* @param publishParentId the publish parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publish taxonomy, or <code>null</code> if a matching publish taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishTaxonomy fetchBypublishParentId_Last(
		long publishParentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBypublishParentId_Last(publishParentId,
			orderByComparator);
	}

	/**
	* Returns the publish taxonomies before and after the current publish taxonomy in the ordered set where publishParentId = &#63;.
	*
	* @param publishTaxId the primary key of the current publish taxonomy
	* @param publishParentId the publish parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next publish taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException if a publish taxonomy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishTaxonomy[] findBypublishParentId_PrevAndNext(
		long publishTaxId, long publishParentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublishParentId_PrevAndNext(publishTaxId,
			publishParentId, orderByComparator);
	}

	/**
	* Removes all the publish taxonomies where publishParentId = &#63; from the database.
	*
	* @param publishParentId the publish parent ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBypublishParentId(long publishParentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBypublishParentId(publishParentId);
	}

	/**
	* Returns the number of publish taxonomies where publishParentId = &#63;.
	*
	* @param publishParentId the publish parent ID
	* @return the number of matching publish taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static int countBypublishParentId(long publishParentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBypublishParentId(publishParentId);
	}

	/**
	* Returns all the publish taxonomies where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @return the matching publish taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishTaxonomy> findBycreatorId(
		java.lang.String creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycreatorId(creatorId);
	}

	/**
	* Returns a range of all the publish taxonomies where creatorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param creatorId the creator ID
	* @param start the lower bound of the range of publish taxonomies
	* @param end the upper bound of the range of publish taxonomies (not inclusive)
	* @return the range of matching publish taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishTaxonomy> findBycreatorId(
		java.lang.String creatorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycreatorId(creatorId, start, end);
	}

	/**
	* Returns an ordered range of all the publish taxonomies where creatorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param creatorId the creator ID
	* @param start the lower bound of the range of publish taxonomies
	* @param end the upper bound of the range of publish taxonomies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching publish taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishTaxonomy> findBycreatorId(
		java.lang.String creatorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycreatorId(creatorId, start, end, orderByComparator);
	}

	/**
	* Returns the first publish taxonomy in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publish taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException if a matching publish taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishTaxonomy findBycreatorId_First(
		java.lang.String creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycreatorId_First(creatorId, orderByComparator);
	}

	/**
	* Returns the first publish taxonomy in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publish taxonomy, or <code>null</code> if a matching publish taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishTaxonomy fetchBycreatorId_First(
		java.lang.String creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycreatorId_First(creatorId, orderByComparator);
	}

	/**
	* Returns the last publish taxonomy in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publish taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException if a matching publish taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishTaxonomy findBycreatorId_Last(
		java.lang.String creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycreatorId_Last(creatorId, orderByComparator);
	}

	/**
	* Returns the last publish taxonomy in the ordered set where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publish taxonomy, or <code>null</code> if a matching publish taxonomy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishTaxonomy fetchBycreatorId_Last(
		java.lang.String creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycreatorId_Last(creatorId, orderByComparator);
	}

	/**
	* Returns the publish taxonomies before and after the current publish taxonomy in the ordered set where creatorId = &#63;.
	*
	* @param publishTaxId the primary key of the current publish taxonomy
	* @param creatorId the creator ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next publish taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException if a publish taxonomy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishTaxonomy[] findBycreatorId_PrevAndNext(
		long publishTaxId, java.lang.String creatorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycreatorId_PrevAndNext(publishTaxId, creatorId,
			orderByComparator);
	}

	/**
	* Removes all the publish taxonomies where creatorId = &#63; from the database.
	*
	* @param creatorId the creator ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBycreatorId(java.lang.String creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBycreatorId(creatorId);
	}

	/**
	* Returns the number of publish taxonomies where creatorId = &#63;.
	*
	* @param creatorId the creator ID
	* @return the number of matching publish taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static int countBycreatorId(java.lang.String creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBycreatorId(creatorId);
	}

	/**
	* Caches the publish taxonomy in the entity cache if it is enabled.
	*
	* @param publishTaxonomy the publish taxonomy
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.PublishTaxonomy publishTaxonomy) {
		getPersistence().cacheResult(publishTaxonomy);
	}

	/**
	* Caches the publish taxonomies in the entity cache if it is enabled.
	*
	* @param publishTaxonomies the publish taxonomies
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.PublishTaxonomy> publishTaxonomies) {
		getPersistence().cacheResult(publishTaxonomies);
	}

	/**
	* Creates a new publish taxonomy with the primary key. Does not add the publish taxonomy to the database.
	*
	* @param publishTaxId the primary key for the new publish taxonomy
	* @return the new publish taxonomy
	*/
	public static com.ihg.brandstandards.db.model.PublishTaxonomy create(
		long publishTaxId) {
		return getPersistence().create(publishTaxId);
	}

	/**
	* Removes the publish taxonomy with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param publishTaxId the primary key of the publish taxonomy
	* @return the publish taxonomy that was removed
	* @throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException if a publish taxonomy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishTaxonomy remove(
		long publishTaxId)
		throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(publishTaxId);
	}

	public static com.ihg.brandstandards.db.model.PublishTaxonomy updateImpl(
		com.ihg.brandstandards.db.model.PublishTaxonomy publishTaxonomy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(publishTaxonomy);
	}

	/**
	* Returns the publish taxonomy with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchPublishTaxonomyException} if it could not be found.
	*
	* @param publishTaxId the primary key of the publish taxonomy
	* @return the publish taxonomy
	* @throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException if a publish taxonomy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishTaxonomy findByPrimaryKey(
		long publishTaxId)
		throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(publishTaxId);
	}

	/**
	* Returns the publish taxonomy with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param publishTaxId the primary key of the publish taxonomy
	* @return the publish taxonomy, or <code>null</code> if a publish taxonomy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishTaxonomy fetchByPrimaryKey(
		long publishTaxId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(publishTaxId);
	}

	/**
	* Returns all the publish taxonomies.
	*
	* @return the publish taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishTaxonomy> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the publish taxonomies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of publish taxonomies
	* @param end the upper bound of the range of publish taxonomies (not inclusive)
	* @return the range of publish taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishTaxonomy> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the publish taxonomies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of publish taxonomies
	* @param end the upper bound of the range of publish taxonomies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of publish taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishTaxonomy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the publish taxonomies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of publish taxonomies.
	*
	* @return the number of publish taxonomies
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PublishTaxonomyPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PublishTaxonomyPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					PublishTaxonomyPersistence.class.getName());

			ReferenceRegistry.registerReference(PublishTaxonomyUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PublishTaxonomyPersistence persistence) {
	}

	private static PublishTaxonomyPersistence _persistence;
}