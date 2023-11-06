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

import com.ihg.brandstandards.db.model.BridgePublishCountryStateEx;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the bridge publish country state ex service. This utility wraps {@link BridgePublishCountryStateExPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgePublishCountryStateExPersistence
 * @see BridgePublishCountryStateExPersistenceImpl
 * @generated
 */
public class BridgePublishCountryStateExUtil {
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
	public static void clearCache(
		BridgePublishCountryStateEx bridgePublishCountryStateEx) {
		getPersistence().clearCache(bridgePublishCountryStateEx);
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
	public static List<BridgePublishCountryStateEx> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BridgePublishCountryStateEx> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BridgePublishCountryStateEx> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static BridgePublishCountryStateEx update(
		BridgePublishCountryStateEx bridgePublishCountryStateEx)
		throws SystemException {
		return getPersistence().update(bridgePublishCountryStateEx);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static BridgePublishCountryStateEx update(
		BridgePublishCountryStateEx bridgePublishCountryStateEx,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(bridgePublishCountryStateEx, serviceContext);
	}

	/**
	* Caches the bridge publish country state ex in the entity cache if it is enabled.
	*
	* @param bridgePublishCountryStateEx the bridge publish country state ex
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.BridgePublishCountryStateEx bridgePublishCountryStateEx) {
		getPersistence().cacheResult(bridgePublishCountryStateEx);
	}

	/**
	* Caches the bridge publish country state exs in the entity cache if it is enabled.
	*
	* @param bridgePublishCountryStateExs the bridge publish country state exs
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.BridgePublishCountryStateEx> bridgePublishCountryStateExs) {
		getPersistence().cacheResult(bridgePublishCountryStateExs);
	}

	/**
	* Creates a new bridge publish country state ex with the primary key. Does not add the bridge publish country state ex to the database.
	*
	* @param bridgePublishCountryStateExPK the primary key for the new bridge publish country state ex
	* @return the new bridge publish country state ex
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishCountryStateEx create(
		com.ihg.brandstandards.db.service.persistence.BridgePublishCountryStateExPK bridgePublishCountryStateExPK) {
		return getPersistence().create(bridgePublishCountryStateExPK);
	}

	/**
	* Removes the bridge publish country state ex with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bridgePublishCountryStateExPK the primary key of the bridge publish country state ex
	* @return the bridge publish country state ex that was removed
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishCountryStateExException if a bridge publish country state ex with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishCountryStateEx remove(
		com.ihg.brandstandards.db.service.persistence.BridgePublishCountryStateExPK bridgePublishCountryStateExPK)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishCountryStateExException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(bridgePublishCountryStateExPK);
	}

	public static com.ihg.brandstandards.db.model.BridgePublishCountryStateEx updateImpl(
		com.ihg.brandstandards.db.model.BridgePublishCountryStateEx bridgePublishCountryStateEx)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(bridgePublishCountryStateEx);
	}

	/**
	* Returns the bridge publish country state ex with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgePublishCountryStateExException} if it could not be found.
	*
	* @param bridgePublishCountryStateExPK the primary key of the bridge publish country state ex
	* @return the bridge publish country state ex
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishCountryStateExException if a bridge publish country state ex with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishCountryStateEx findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.BridgePublishCountryStateExPK bridgePublishCountryStateExPK)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishCountryStateExException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(bridgePublishCountryStateExPK);
	}

	/**
	* Returns the bridge publish country state ex with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bridgePublishCountryStateExPK the primary key of the bridge publish country state ex
	* @return the bridge publish country state ex, or <code>null</code> if a bridge publish country state ex with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishCountryStateEx fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.BridgePublishCountryStateExPK bridgePublishCountryStateExPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(bridgePublishCountryStateExPK);
	}

	/**
	* Returns all the bridge publish country state exs.
	*
	* @return the bridge publish country state exs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishCountryStateEx> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the bridge publish country state exs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishCountryStateExModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge publish country state exs
	* @param end the upper bound of the range of bridge publish country state exs (not inclusive)
	* @return the range of bridge publish country state exs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishCountryStateEx> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the bridge publish country state exs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishCountryStateExModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge publish country state exs
	* @param end the upper bound of the range of bridge publish country state exs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bridge publish country state exs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishCountryStateEx> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the bridge publish country state exs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of bridge publish country state exs.
	*
	* @return the number of bridge publish country state exs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BridgePublishCountryStateExPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BridgePublishCountryStateExPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					BridgePublishCountryStateExPersistence.class.getName());

			ReferenceRegistry.registerReference(BridgePublishCountryStateExUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		BridgePublishCountryStateExPersistence persistence) {
	}

	private static BridgePublishCountryStateExPersistence _persistence;
}