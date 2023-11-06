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

import com.ihg.brandstandards.db.model.GEMUniqueGroup;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the g e m unique group service. This utility wraps {@link GEMUniqueGroupPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMUniqueGroupPersistence
 * @see GEMUniqueGroupPersistenceImpl
 * @generated
 */
public class GEMUniqueGroupUtil {
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
	public static void clearCache(GEMUniqueGroup gemUniqueGroup) {
		getPersistence().clearCache(gemUniqueGroup);
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
	public static List<GEMUniqueGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GEMUniqueGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GEMUniqueGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GEMUniqueGroup update(GEMUniqueGroup gemUniqueGroup)
		throws SystemException {
		return getPersistence().update(gemUniqueGroup);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GEMUniqueGroup update(GEMUniqueGroup gemUniqueGroup,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(gemUniqueGroup, serviceContext);
	}

	/**
	* Returns all the g e m unique groups where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @return the matching g e m unique groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMUniqueGroup> findBypublicationAndRegion(
		long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBypublicationAndRegion(publishId, regionId);
	}

	/**
	* Returns a range of all the g e m unique groups where publishId = &#63; and regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMUniqueGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param start the lower bound of the range of g e m unique groups
	* @param end the upper bound of the range of g e m unique groups (not inclusive)
	* @return the range of matching g e m unique groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMUniqueGroup> findBypublicationAndRegion(
		long publishId, long regionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublicationAndRegion(publishId, regionId, start, end);
	}

	/**
	* Returns an ordered range of all the g e m unique groups where publishId = &#63; and regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMUniqueGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param start the lower bound of the range of g e m unique groups
	* @param end the upper bound of the range of g e m unique groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g e m unique groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMUniqueGroup> findBypublicationAndRegion(
		long publishId, long regionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublicationAndRegion(publishId, regionId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first g e m unique group in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m unique group
	* @throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException if a matching g e m unique group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMUniqueGroup findBypublicationAndRegion_First(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublicationAndRegion_First(publishId, regionId,
			orderByComparator);
	}

	/**
	* Returns the first g e m unique group in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m unique group, or <code>null</code> if a matching g e m unique group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMUniqueGroup fetchBypublicationAndRegion_First(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBypublicationAndRegion_First(publishId, regionId,
			orderByComparator);
	}

	/**
	* Returns the last g e m unique group in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m unique group
	* @throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException if a matching g e m unique group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMUniqueGroup findBypublicationAndRegion_Last(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublicationAndRegion_Last(publishId, regionId,
			orderByComparator);
	}

	/**
	* Returns the last g e m unique group in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m unique group, or <code>null</code> if a matching g e m unique group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMUniqueGroup fetchBypublicationAndRegion_Last(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBypublicationAndRegion_Last(publishId, regionId,
			orderByComparator);
	}

	/**
	* Returns the g e m unique groups before and after the current g e m unique group in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param uniqueGroupId the primary key of the current g e m unique group
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g e m unique group
	* @throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException if a g e m unique group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMUniqueGroup[] findBypublicationAndRegion_PrevAndNext(
		long uniqueGroupId, long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublicationAndRegion_PrevAndNext(uniqueGroupId,
			publishId, regionId, orderByComparator);
	}

	/**
	* Removes all the g e m unique groups where publishId = &#63; and regionId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBypublicationAndRegion(long publishId,
		long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBypublicationAndRegion(publishId, regionId);
	}

	/**
	* Returns the number of g e m unique groups where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @return the number of matching g e m unique groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countBypublicationAndRegion(long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBypublicationAndRegion(publishId, regionId);
	}

	/**
	* Returns all the g e m unique groups where publishId = &#63; and regionId = &#63; and groupType = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param groupType the group type
	* @return the matching g e m unique groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMUniqueGroup> findBypublicationAndRegionAndType(
		long publishId, long regionId, java.lang.String groupType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublicationAndRegionAndType(publishId, regionId,
			groupType);
	}

	/**
	* Returns a range of all the g e m unique groups where publishId = &#63; and regionId = &#63; and groupType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMUniqueGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param groupType the group type
	* @param start the lower bound of the range of g e m unique groups
	* @param end the upper bound of the range of g e m unique groups (not inclusive)
	* @return the range of matching g e m unique groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMUniqueGroup> findBypublicationAndRegionAndType(
		long publishId, long regionId, java.lang.String groupType, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublicationAndRegionAndType(publishId, regionId,
			groupType, start, end);
	}

	/**
	* Returns an ordered range of all the g e m unique groups where publishId = &#63; and regionId = &#63; and groupType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMUniqueGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param groupType the group type
	* @param start the lower bound of the range of g e m unique groups
	* @param end the upper bound of the range of g e m unique groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g e m unique groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMUniqueGroup> findBypublicationAndRegionAndType(
		long publishId, long regionId, java.lang.String groupType, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublicationAndRegionAndType(publishId, regionId,
			groupType, start, end, orderByComparator);
	}

	/**
	* Returns the first g e m unique group in the ordered set where publishId = &#63; and regionId = &#63; and groupType = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param groupType the group type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m unique group
	* @throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException if a matching g e m unique group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMUniqueGroup findBypublicationAndRegionAndType_First(
		long publishId, long regionId, java.lang.String groupType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublicationAndRegionAndType_First(publishId,
			regionId, groupType, orderByComparator);
	}

	/**
	* Returns the first g e m unique group in the ordered set where publishId = &#63; and regionId = &#63; and groupType = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param groupType the group type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m unique group, or <code>null</code> if a matching g e m unique group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMUniqueGroup fetchBypublicationAndRegionAndType_First(
		long publishId, long regionId, java.lang.String groupType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBypublicationAndRegionAndType_First(publishId,
			regionId, groupType, orderByComparator);
	}

	/**
	* Returns the last g e m unique group in the ordered set where publishId = &#63; and regionId = &#63; and groupType = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param groupType the group type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m unique group
	* @throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException if a matching g e m unique group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMUniqueGroup findBypublicationAndRegionAndType_Last(
		long publishId, long regionId, java.lang.String groupType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublicationAndRegionAndType_Last(publishId, regionId,
			groupType, orderByComparator);
	}

	/**
	* Returns the last g e m unique group in the ordered set where publishId = &#63; and regionId = &#63; and groupType = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param groupType the group type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m unique group, or <code>null</code> if a matching g e m unique group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMUniqueGroup fetchBypublicationAndRegionAndType_Last(
		long publishId, long regionId, java.lang.String groupType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBypublicationAndRegionAndType_Last(publishId,
			regionId, groupType, orderByComparator);
	}

	/**
	* Returns the g e m unique groups before and after the current g e m unique group in the ordered set where publishId = &#63; and regionId = &#63; and groupType = &#63;.
	*
	* @param uniqueGroupId the primary key of the current g e m unique group
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param groupType the group type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g e m unique group
	* @throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException if a g e m unique group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMUniqueGroup[] findBypublicationAndRegionAndType_PrevAndNext(
		long uniqueGroupId, long publishId, long regionId,
		java.lang.String groupType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublicationAndRegionAndType_PrevAndNext(uniqueGroupId,
			publishId, regionId, groupType, orderByComparator);
	}

	/**
	* Removes all the g e m unique groups where publishId = &#63; and regionId = &#63; and groupType = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param groupType the group type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBypublicationAndRegionAndType(long publishId,
		long regionId, java.lang.String groupType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeBypublicationAndRegionAndType(publishId, regionId, groupType);
	}

	/**
	* Returns the number of g e m unique groups where publishId = &#63; and regionId = &#63; and groupType = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param groupType the group type
	* @return the number of matching g e m unique groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countBypublicationAndRegionAndType(long publishId,
		long regionId, java.lang.String groupType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBypublicationAndRegionAndType(publishId, regionId,
			groupType);
	}

	/**
	* Caches the g e m unique group in the entity cache if it is enabled.
	*
	* @param gemUniqueGroup the g e m unique group
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.GEMUniqueGroup gemUniqueGroup) {
		getPersistence().cacheResult(gemUniqueGroup);
	}

	/**
	* Caches the g e m unique groups in the entity cache if it is enabled.
	*
	* @param gemUniqueGroups the g e m unique groups
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GEMUniqueGroup> gemUniqueGroups) {
		getPersistence().cacheResult(gemUniqueGroups);
	}

	/**
	* Creates a new g e m unique group with the primary key. Does not add the g e m unique group to the database.
	*
	* @param uniqueGroupId the primary key for the new g e m unique group
	* @return the new g e m unique group
	*/
	public static com.ihg.brandstandards.db.model.GEMUniqueGroup create(
		long uniqueGroupId) {
		return getPersistence().create(uniqueGroupId);
	}

	/**
	* Removes the g e m unique group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param uniqueGroupId the primary key of the g e m unique group
	* @return the g e m unique group that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException if a g e m unique group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMUniqueGroup remove(
		long uniqueGroupId)
		throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(uniqueGroupId);
	}

	public static com.ihg.brandstandards.db.model.GEMUniqueGroup updateImpl(
		com.ihg.brandstandards.db.model.GEMUniqueGroup gemUniqueGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(gemUniqueGroup);
	}

	/**
	* Returns the g e m unique group with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException} if it could not be found.
	*
	* @param uniqueGroupId the primary key of the g e m unique group
	* @return the g e m unique group
	* @throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException if a g e m unique group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMUniqueGroup findByPrimaryKey(
		long uniqueGroupId)
		throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(uniqueGroupId);
	}

	/**
	* Returns the g e m unique group with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param uniqueGroupId the primary key of the g e m unique group
	* @return the g e m unique group, or <code>null</code> if a g e m unique group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMUniqueGroup fetchByPrimaryKey(
		long uniqueGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(uniqueGroupId);
	}

	/**
	* Returns all the g e m unique groups.
	*
	* @return the g e m unique groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMUniqueGroup> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the g e m unique groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMUniqueGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m unique groups
	* @param end the upper bound of the range of g e m unique groups (not inclusive)
	* @return the range of g e m unique groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMUniqueGroup> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the g e m unique groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMUniqueGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m unique groups
	* @param end the upper bound of the range of g e m unique groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of g e m unique groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMUniqueGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the g e m unique groups from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of g e m unique groups.
	*
	* @return the number of g e m unique groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GEMUniqueGroupPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GEMUniqueGroupPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					GEMUniqueGroupPersistence.class.getName());

			ReferenceRegistry.registerReference(GEMUniqueGroupUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GEMUniqueGroupPersistence persistence) {
	}

	private static GEMUniqueGroupPersistence _persistence;
}