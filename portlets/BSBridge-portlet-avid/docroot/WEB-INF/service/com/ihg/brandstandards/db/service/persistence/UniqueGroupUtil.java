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

import com.ihg.brandstandards.db.model.UniqueGroup;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the unique group service. This utility wraps {@link UniqueGroupPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see UniqueGroupPersistence
 * @see UniqueGroupPersistenceImpl
 * @generated
 */
public class UniqueGroupUtil {
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
	public static void clearCache(UniqueGroup uniqueGroup) {
		getPersistence().clearCache(uniqueGroup);
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
	public static List<UniqueGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UniqueGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UniqueGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static UniqueGroup update(UniqueGroup uniqueGroup)
		throws SystemException {
		return getPersistence().update(uniqueGroup);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static UniqueGroup update(UniqueGroup uniqueGroup,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(uniqueGroup, serviceContext);
	}

	/**
	* Returns all the unique groups where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @return the matching unique groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.UniqueGroup> findBypublicationAndRegion(
		long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBypublicationAndRegion(publishId, regionId);
	}

	/**
	* Returns a range of all the unique groups where publishId = &#63; and regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UniqueGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param start the lower bound of the range of unique groups
	* @param end the upper bound of the range of unique groups (not inclusive)
	* @return the range of matching unique groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.UniqueGroup> findBypublicationAndRegion(
		long publishId, long regionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublicationAndRegion(publishId, regionId, start, end);
	}

	/**
	* Returns an ordered range of all the unique groups where publishId = &#63; and regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UniqueGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param start the lower bound of the range of unique groups
	* @param end the upper bound of the range of unique groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching unique groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.UniqueGroup> findBypublicationAndRegion(
		long publishId, long regionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublicationAndRegion(publishId, regionId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first unique group in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching unique group
	* @throws com.ihg.brandstandards.db.NoSuchUniqueGroupException if a matching unique group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UniqueGroup findBypublicationAndRegion_First(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchUniqueGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublicationAndRegion_First(publishId, regionId,
			orderByComparator);
	}

	/**
	* Returns the first unique group in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching unique group, or <code>null</code> if a matching unique group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UniqueGroup fetchBypublicationAndRegion_First(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBypublicationAndRegion_First(publishId, regionId,
			orderByComparator);
	}

	/**
	* Returns the last unique group in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching unique group
	* @throws com.ihg.brandstandards.db.NoSuchUniqueGroupException if a matching unique group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UniqueGroup findBypublicationAndRegion_Last(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchUniqueGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublicationAndRegion_Last(publishId, regionId,
			orderByComparator);
	}

	/**
	* Returns the last unique group in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching unique group, or <code>null</code> if a matching unique group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UniqueGroup fetchBypublicationAndRegion_Last(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBypublicationAndRegion_Last(publishId, regionId,
			orderByComparator);
	}

	/**
	* Returns the unique groups before and after the current unique group in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param uniqueGroupId the primary key of the current unique group
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next unique group
	* @throws com.ihg.brandstandards.db.NoSuchUniqueGroupException if a unique group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UniqueGroup[] findBypublicationAndRegion_PrevAndNext(
		long uniqueGroupId, long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchUniqueGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublicationAndRegion_PrevAndNext(uniqueGroupId,
			publishId, regionId, orderByComparator);
	}

	/**
	* Removes all the unique groups where publishId = &#63; and regionId = &#63; from the database.
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
	* Returns the number of unique groups where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @return the number of matching unique groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countBypublicationAndRegion(long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBypublicationAndRegion(publishId, regionId);
	}

	/**
	* Caches the unique group in the entity cache if it is enabled.
	*
	* @param uniqueGroup the unique group
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.UniqueGroup uniqueGroup) {
		getPersistence().cacheResult(uniqueGroup);
	}

	/**
	* Caches the unique groups in the entity cache if it is enabled.
	*
	* @param uniqueGroups the unique groups
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.UniqueGroup> uniqueGroups) {
		getPersistence().cacheResult(uniqueGroups);
	}

	/**
	* Creates a new unique group with the primary key. Does not add the unique group to the database.
	*
	* @param uniqueGroupId the primary key for the new unique group
	* @return the new unique group
	*/
	public static com.ihg.brandstandards.db.model.UniqueGroup create(
		long uniqueGroupId) {
		return getPersistence().create(uniqueGroupId);
	}

	/**
	* Removes the unique group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param uniqueGroupId the primary key of the unique group
	* @return the unique group that was removed
	* @throws com.ihg.brandstandards.db.NoSuchUniqueGroupException if a unique group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UniqueGroup remove(
		long uniqueGroupId)
		throws com.ihg.brandstandards.db.NoSuchUniqueGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(uniqueGroupId);
	}

	public static com.ihg.brandstandards.db.model.UniqueGroup updateImpl(
		com.ihg.brandstandards.db.model.UniqueGroup uniqueGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(uniqueGroup);
	}

	/**
	* Returns the unique group with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchUniqueGroupException} if it could not be found.
	*
	* @param uniqueGroupId the primary key of the unique group
	* @return the unique group
	* @throws com.ihg.brandstandards.db.NoSuchUniqueGroupException if a unique group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UniqueGroup findByPrimaryKey(
		long uniqueGroupId)
		throws com.ihg.brandstandards.db.NoSuchUniqueGroupException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(uniqueGroupId);
	}

	/**
	* Returns the unique group with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param uniqueGroupId the primary key of the unique group
	* @return the unique group, or <code>null</code> if a unique group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UniqueGroup fetchByPrimaryKey(
		long uniqueGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(uniqueGroupId);
	}

	/**
	* Returns all the unique groups.
	*
	* @return the unique groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.UniqueGroup> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the unique groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UniqueGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of unique groups
	* @param end the upper bound of the range of unique groups (not inclusive)
	* @return the range of unique groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.UniqueGroup> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the unique groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UniqueGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of unique groups
	* @param end the upper bound of the range of unique groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of unique groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.UniqueGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the unique groups from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of unique groups.
	*
	* @return the number of unique groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UniqueGroupPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UniqueGroupPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					UniqueGroupPersistence.class.getName());

			ReferenceRegistry.registerReference(UniqueGroupUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(UniqueGroupPersistence persistence) {
	}

	private static UniqueGroupPersistence _persistence;
}