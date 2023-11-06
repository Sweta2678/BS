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

import com.ihg.brandstandards.db.model.HistManualChain;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the hist manual chain service. This utility wraps {@link HistManualChainPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see HistManualChainPersistence
 * @see HistManualChainPersistenceImpl
 * @generated
 */
public class HistManualChainUtil {
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
	public static void clearCache(HistManualChain histManualChain) {
		getPersistence().clearCache(histManualChain);
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
	public static List<HistManualChain> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<HistManualChain> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<HistManualChain> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static HistManualChain update(HistManualChain histManualChain)
		throws SystemException {
		return getPersistence().update(histManualChain);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static HistManualChain update(HistManualChain histManualChain,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(histManualChain, serviceContext);
	}

	/**
	* Returns all the hist manual chains where histManualId = &#63;.
	*
	* @param histManualId the hist manual ID
	* @return the matching hist manual chains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.HistManualChain> findByhistManualId(
		long histManualId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByhistManualId(histManualId);
	}

	/**
	* Returns a range of all the hist manual chains where histManualId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param histManualId the hist manual ID
	* @param start the lower bound of the range of hist manual chains
	* @param end the upper bound of the range of hist manual chains (not inclusive)
	* @return the range of matching hist manual chains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.HistManualChain> findByhistManualId(
		long histManualId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByhistManualId(histManualId, start, end);
	}

	/**
	* Returns an ordered range of all the hist manual chains where histManualId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param histManualId the hist manual ID
	* @param start the lower bound of the range of hist manual chains
	* @param end the upper bound of the range of hist manual chains (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching hist manual chains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.HistManualChain> findByhistManualId(
		long histManualId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByhistManualId(histManualId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first hist manual chain in the ordered set where histManualId = &#63;.
	*
	* @param histManualId the hist manual ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching hist manual chain
	* @throws com.ihg.brandstandards.db.NoSuchHistManualChainException if a matching hist manual chain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.HistManualChain findByhistManualId_First(
		long histManualId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchHistManualChainException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByhistManualId_First(histManualId, orderByComparator);
	}

	/**
	* Returns the first hist manual chain in the ordered set where histManualId = &#63;.
	*
	* @param histManualId the hist manual ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching hist manual chain, or <code>null</code> if a matching hist manual chain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.HistManualChain fetchByhistManualId_First(
		long histManualId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByhistManualId_First(histManualId, orderByComparator);
	}

	/**
	* Returns the last hist manual chain in the ordered set where histManualId = &#63;.
	*
	* @param histManualId the hist manual ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching hist manual chain
	* @throws com.ihg.brandstandards.db.NoSuchHistManualChainException if a matching hist manual chain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.HistManualChain findByhistManualId_Last(
		long histManualId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchHistManualChainException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByhistManualId_Last(histManualId, orderByComparator);
	}

	/**
	* Returns the last hist manual chain in the ordered set where histManualId = &#63;.
	*
	* @param histManualId the hist manual ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching hist manual chain, or <code>null</code> if a matching hist manual chain could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.HistManualChain fetchByhistManualId_Last(
		long histManualId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByhistManualId_Last(histManualId, orderByComparator);
	}

	/**
	* Returns the hist manual chains before and after the current hist manual chain in the ordered set where histManualId = &#63;.
	*
	* @param histManualChainPK the primary key of the current hist manual chain
	* @param histManualId the hist manual ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next hist manual chain
	* @throws com.ihg.brandstandards.db.NoSuchHistManualChainException if a hist manual chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.HistManualChain[] findByhistManualId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.HistManualChainPK histManualChainPK,
		long histManualId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchHistManualChainException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByhistManualId_PrevAndNext(histManualChainPK,
			histManualId, orderByComparator);
	}

	/**
	* Removes all the hist manual chains where histManualId = &#63; from the database.
	*
	* @param histManualId the hist manual ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByhistManualId(long histManualId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByhistManualId(histManualId);
	}

	/**
	* Returns the number of hist manual chains where histManualId = &#63;.
	*
	* @param histManualId the hist manual ID
	* @return the number of matching hist manual chains
	* @throws SystemException if a system exception occurred
	*/
	public static int countByhistManualId(long histManualId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByhistManualId(histManualId);
	}

	/**
	* Caches the hist manual chain in the entity cache if it is enabled.
	*
	* @param histManualChain the hist manual chain
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.HistManualChain histManualChain) {
		getPersistence().cacheResult(histManualChain);
	}

	/**
	* Caches the hist manual chains in the entity cache if it is enabled.
	*
	* @param histManualChains the hist manual chains
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.HistManualChain> histManualChains) {
		getPersistence().cacheResult(histManualChains);
	}

	/**
	* Creates a new hist manual chain with the primary key. Does not add the hist manual chain to the database.
	*
	* @param histManualChainPK the primary key for the new hist manual chain
	* @return the new hist manual chain
	*/
	public static com.ihg.brandstandards.db.model.HistManualChain create(
		com.ihg.brandstandards.db.service.persistence.HistManualChainPK histManualChainPK) {
		return getPersistence().create(histManualChainPK);
	}

	/**
	* Removes the hist manual chain with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param histManualChainPK the primary key of the hist manual chain
	* @return the hist manual chain that was removed
	* @throws com.ihg.brandstandards.db.NoSuchHistManualChainException if a hist manual chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.HistManualChain remove(
		com.ihg.brandstandards.db.service.persistence.HistManualChainPK histManualChainPK)
		throws com.ihg.brandstandards.db.NoSuchHistManualChainException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(histManualChainPK);
	}

	public static com.ihg.brandstandards.db.model.HistManualChain updateImpl(
		com.ihg.brandstandards.db.model.HistManualChain histManualChain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(histManualChain);
	}

	/**
	* Returns the hist manual chain with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchHistManualChainException} if it could not be found.
	*
	* @param histManualChainPK the primary key of the hist manual chain
	* @return the hist manual chain
	* @throws com.ihg.brandstandards.db.NoSuchHistManualChainException if a hist manual chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.HistManualChain findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.HistManualChainPK histManualChainPK)
		throws com.ihg.brandstandards.db.NoSuchHistManualChainException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(histManualChainPK);
	}

	/**
	* Returns the hist manual chain with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param histManualChainPK the primary key of the hist manual chain
	* @return the hist manual chain, or <code>null</code> if a hist manual chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.HistManualChain fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.HistManualChainPK histManualChainPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(histManualChainPK);
	}

	/**
	* Returns all the hist manual chains.
	*
	* @return the hist manual chains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.HistManualChain> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the hist manual chains.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of hist manual chains
	* @param end the upper bound of the range of hist manual chains (not inclusive)
	* @return the range of hist manual chains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.HistManualChain> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the hist manual chains.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of hist manual chains
	* @param end the upper bound of the range of hist manual chains (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of hist manual chains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.HistManualChain> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the hist manual chains from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of hist manual chains.
	*
	* @return the number of hist manual chains
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static HistManualChainPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (HistManualChainPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					HistManualChainPersistence.class.getName());

			ReferenceRegistry.registerReference(HistManualChainUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(HistManualChainPersistence persistence) {
	}

	private static HistManualChainPersistence _persistence;
}