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

import com.ihg.brandstandards.db.model.BridgeGlobalPublish;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the bridge global publish service. This utility wraps {@link BridgeGlobalPublishPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgeGlobalPublishPersistence
 * @see BridgeGlobalPublishPersistenceImpl
 * @generated
 */
public class BridgeGlobalPublishUtil {
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
	public static void clearCache(BridgeGlobalPublish bridgeGlobalPublish) {
		getPersistence().clearCache(bridgeGlobalPublish);
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
	public static List<BridgeGlobalPublish> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BridgeGlobalPublish> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BridgeGlobalPublish> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static BridgeGlobalPublish update(
		BridgeGlobalPublish bridgeGlobalPublish) throws SystemException {
		return getPersistence().update(bridgeGlobalPublish);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static BridgeGlobalPublish update(
		BridgeGlobalPublish bridgeGlobalPublish, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(bridgeGlobalPublish, serviceContext);
	}

	/**
	* Returns the bridge global publish where publishId = &#63; and stdId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException} if it could not be found.
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @return the matching bridge global publish
	* @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException if a matching bridge global publish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublish findByPublishIdAndStdId(
		long publishId, long stdId)
		throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPublishIdAndStdId(publishId, stdId);
	}

	/**
	* Returns the bridge global publish where publishId = &#63; and stdId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @return the matching bridge global publish, or <code>null</code> if a matching bridge global publish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublish fetchByPublishIdAndStdId(
		long publishId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPublishIdAndStdId(publishId, stdId);
	}

	/**
	* Returns the bridge global publish where publishId = &#63; and stdId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching bridge global publish, or <code>null</code> if a matching bridge global publish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublish fetchByPublishIdAndStdId(
		long publishId, long stdId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishIdAndStdId(publishId, stdId, retrieveFromCache);
	}

	/**
	* Removes the bridge global publish where publishId = &#63; and stdId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @return the bridge global publish that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublish removeByPublishIdAndStdId(
		long publishId, long stdId)
		throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByPublishIdAndStdId(publishId, stdId);
	}

	/**
	* Returns the number of bridge global publishs where publishId = &#63; and stdId = &#63;.
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @return the number of matching bridge global publishs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPublishIdAndStdId(long publishId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPublishIdAndStdId(publishId, stdId);
	}

	/**
	* Returns the bridge global publish where stdId = &#63; and mustPublishInd = &#63; and publishId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException} if it could not be found.
	*
	* @param stdId the std ID
	* @param mustPublishInd the must publish ind
	* @param publishId the publish ID
	* @return the matching bridge global publish
	* @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException if a matching bridge global publish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublish findByStdIdAndMustPublishInd(
		long stdId, java.lang.String mustPublishInd, long publishId)
		throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdIdAndMustPublishInd(stdId, mustPublishInd,
			publishId);
	}

	/**
	* Returns the bridge global publish where stdId = &#63; and mustPublishInd = &#63; and publishId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param stdId the std ID
	* @param mustPublishInd the must publish ind
	* @param publishId the publish ID
	* @return the matching bridge global publish, or <code>null</code> if a matching bridge global publish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublish fetchByStdIdAndMustPublishInd(
		long stdId, java.lang.String mustPublishInd, long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStdIdAndMustPublishInd(stdId, mustPublishInd,
			publishId);
	}

	/**
	* Returns the bridge global publish where stdId = &#63; and mustPublishInd = &#63; and publishId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param stdId the std ID
	* @param mustPublishInd the must publish ind
	* @param publishId the publish ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching bridge global publish, or <code>null</code> if a matching bridge global publish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublish fetchByStdIdAndMustPublishInd(
		long stdId, java.lang.String mustPublishInd, long publishId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStdIdAndMustPublishInd(stdId, mustPublishInd,
			publishId, retrieveFromCache);
	}

	/**
	* Removes the bridge global publish where stdId = &#63; and mustPublishInd = &#63; and publishId = &#63; from the database.
	*
	* @param stdId the std ID
	* @param mustPublishInd the must publish ind
	* @param publishId the publish ID
	* @return the bridge global publish that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublish removeByStdIdAndMustPublishInd(
		long stdId, java.lang.String mustPublishInd, long publishId)
		throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByStdIdAndMustPublishInd(stdId, mustPublishInd,
			publishId);
	}

	/**
	* Returns the number of bridge global publishs where stdId = &#63; and mustPublishInd = &#63; and publishId = &#63;.
	*
	* @param stdId the std ID
	* @param mustPublishInd the must publish ind
	* @param publishId the publish ID
	* @return the number of matching bridge global publishs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStdIdAndMustPublishInd(long stdId,
		java.lang.String mustPublishInd, long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByStdIdAndMustPublishInd(stdId, mustPublishInd,
			publishId);
	}

	/**
	* Caches the bridge global publish in the entity cache if it is enabled.
	*
	* @param bridgeGlobalPublish the bridge global publish
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.BridgeGlobalPublish bridgeGlobalPublish) {
		getPersistence().cacheResult(bridgeGlobalPublish);
	}

	/**
	* Caches the bridge global publishs in the entity cache if it is enabled.
	*
	* @param bridgeGlobalPublishs the bridge global publishs
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublish> bridgeGlobalPublishs) {
		getPersistence().cacheResult(bridgeGlobalPublishs);
	}

	/**
	* Creates a new bridge global publish with the primary key. Does not add the bridge global publish to the database.
	*
	* @param globalPublishId the primary key for the new bridge global publish
	* @return the new bridge global publish
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublish create(
		long globalPublishId) {
		return getPersistence().create(globalPublishId);
	}

	/**
	* Removes the bridge global publish with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param globalPublishId the primary key of the bridge global publish
	* @return the bridge global publish that was removed
	* @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException if a bridge global publish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublish remove(
		long globalPublishId)
		throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(globalPublishId);
	}

	public static com.ihg.brandstandards.db.model.BridgeGlobalPublish updateImpl(
		com.ihg.brandstandards.db.model.BridgeGlobalPublish bridgeGlobalPublish)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(bridgeGlobalPublish);
	}

	/**
	* Returns the bridge global publish with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException} if it could not be found.
	*
	* @param globalPublishId the primary key of the bridge global publish
	* @return the bridge global publish
	* @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException if a bridge global publish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublish findByPrimaryKey(
		long globalPublishId)
		throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(globalPublishId);
	}

	/**
	* Returns the bridge global publish with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param globalPublishId the primary key of the bridge global publish
	* @return the bridge global publish, or <code>null</code> if a bridge global publish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublish fetchByPrimaryKey(
		long globalPublishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(globalPublishId);
	}

	/**
	* Returns all the bridge global publishs.
	*
	* @return the bridge global publishs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublish> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the bridge global publishs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge global publishs
	* @param end the upper bound of the range of bridge global publishs (not inclusive)
	* @return the range of bridge global publishs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublish> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the bridge global publishs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge global publishs
	* @param end the upper bound of the range of bridge global publishs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bridge global publishs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublish> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the bridge global publishs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of bridge global publishs.
	*
	* @return the number of bridge global publishs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BridgeGlobalPublishPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BridgeGlobalPublishPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					BridgeGlobalPublishPersistence.class.getName());

			ReferenceRegistry.registerReference(BridgeGlobalPublishUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BridgeGlobalPublishPersistence persistence) {
	}

	private static BridgeGlobalPublishPersistence _persistence;
}