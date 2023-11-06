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

import com.ihg.brandstandards.db.model.BridgePublishStatus;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the bridge publish status service. This utility wraps {@link BridgePublishStatusPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgePublishStatusPersistence
 * @see BridgePublishStatusPersistenceImpl
 * @generated
 */
public class BridgePublishStatusUtil {
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
	public static void clearCache(BridgePublishStatus bridgePublishStatus) {
		getPersistence().clearCache(bridgePublishStatus);
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
	public static List<BridgePublishStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BridgePublishStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BridgePublishStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static BridgePublishStatus update(
		BridgePublishStatus bridgePublishStatus) throws SystemException {
		return getPersistence().update(bridgePublishStatus);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static BridgePublishStatus update(
		BridgePublishStatus bridgePublishStatus, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(bridgePublishStatus, serviceContext);
	}

	/**
	* Caches the bridge publish status in the entity cache if it is enabled.
	*
	* @param bridgePublishStatus the bridge publish status
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.BridgePublishStatus bridgePublishStatus) {
		getPersistence().cacheResult(bridgePublishStatus);
	}

	/**
	* Caches the bridge publish statuses in the entity cache if it is enabled.
	*
	* @param bridgePublishStatuses the bridge publish statuses
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.BridgePublishStatus> bridgePublishStatuses) {
		getPersistence().cacheResult(bridgePublishStatuses);
	}

	/**
	* Creates a new bridge publish status with the primary key. Does not add the bridge publish status to the database.
	*
	* @param publishStatusCode the primary key for the new bridge publish status
	* @return the new bridge publish status
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishStatus create(
		java.lang.String publishStatusCode) {
		return getPersistence().create(publishStatusCode);
	}

	/**
	* Removes the bridge publish status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param publishStatusCode the primary key of the bridge publish status
	* @return the bridge publish status that was removed
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishStatusException if a bridge publish status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishStatus remove(
		java.lang.String publishStatusCode)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishStatusException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(publishStatusCode);
	}

	public static com.ihg.brandstandards.db.model.BridgePublishStatus updateImpl(
		com.ihg.brandstandards.db.model.BridgePublishStatus bridgePublishStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(bridgePublishStatus);
	}

	/**
	* Returns the bridge publish status with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgePublishStatusException} if it could not be found.
	*
	* @param publishStatusCode the primary key of the bridge publish status
	* @return the bridge publish status
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishStatusException if a bridge publish status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishStatus findByPrimaryKey(
		java.lang.String publishStatusCode)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishStatusException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(publishStatusCode);
	}

	/**
	* Returns the bridge publish status with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param publishStatusCode the primary key of the bridge publish status
	* @return the bridge publish status, or <code>null</code> if a bridge publish status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishStatus fetchByPrimaryKey(
		java.lang.String publishStatusCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(publishStatusCode);
	}

	/**
	* Returns all the bridge publish statuses.
	*
	* @return the bridge publish statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishStatus> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the bridge publish statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge publish statuses
	* @param end the upper bound of the range of bridge publish statuses (not inclusive)
	* @return the range of bridge publish statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishStatus> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the bridge publish statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge publish statuses
	* @param end the upper bound of the range of bridge publish statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bridge publish statuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the bridge publish statuses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of bridge publish statuses.
	*
	* @return the number of bridge publish statuses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BridgePublishStatusPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BridgePublishStatusPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					BridgePublishStatusPersistence.class.getName());

			ReferenceRegistry.registerReference(BridgePublishStatusUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BridgePublishStatusPersistence persistence) {
	}

	private static BridgePublishStatusPersistence _persistence;
}