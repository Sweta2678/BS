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

import com.ihg.brandstandards.db.model.ChainExternalLinkStandards;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the chain external link standards service. This utility wraps {@link ChainExternalLinkStandardsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see ChainExternalLinkStandardsPersistence
 * @see ChainExternalLinkStandardsPersistenceImpl
 * @generated
 */
public class ChainExternalLinkStandardsUtil {
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
		ChainExternalLinkStandards chainExternalLinkStandards) {
		getPersistence().clearCache(chainExternalLinkStandards);
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
	public static List<ChainExternalLinkStandards> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ChainExternalLinkStandards> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ChainExternalLinkStandards> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ChainExternalLinkStandards update(
		ChainExternalLinkStandards chainExternalLinkStandards)
		throws SystemException {
		return getPersistence().update(chainExternalLinkStandards);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ChainExternalLinkStandards update(
		ChainExternalLinkStandards chainExternalLinkStandards,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(chainExternalLinkStandards, serviceContext);
	}

	/**
	* Returns all the chain external link standardses where extLinkId = &#63;.
	*
	* @param extLinkId the ext link ID
	* @return the matching chain external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ChainExternalLinkStandards> findByLinkId(
		long extLinkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLinkId(extLinkId);
	}

	/**
	* Returns a range of all the chain external link standardses where extLinkId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param extLinkId the ext link ID
	* @param start the lower bound of the range of chain external link standardses
	* @param end the upper bound of the range of chain external link standardses (not inclusive)
	* @return the range of matching chain external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ChainExternalLinkStandards> findByLinkId(
		long extLinkId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLinkId(extLinkId, start, end);
	}

	/**
	* Returns an ordered range of all the chain external link standardses where extLinkId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param extLinkId the ext link ID
	* @param start the lower bound of the range of chain external link standardses
	* @param end the upper bound of the range of chain external link standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching chain external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ChainExternalLinkStandards> findByLinkId(
		long extLinkId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLinkId(extLinkId, start, end, orderByComparator);
	}

	/**
	* Returns the first chain external link standards in the ordered set where extLinkId = &#63;.
	*
	* @param extLinkId the ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching chain external link standards
	* @throws com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException if a matching chain external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainExternalLinkStandards findByLinkId_First(
		long extLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLinkId_First(extLinkId, orderByComparator);
	}

	/**
	* Returns the first chain external link standards in the ordered set where extLinkId = &#63;.
	*
	* @param extLinkId the ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching chain external link standards, or <code>null</code> if a matching chain external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainExternalLinkStandards fetchByLinkId_First(
		long extLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLinkId_First(extLinkId, orderByComparator);
	}

	/**
	* Returns the last chain external link standards in the ordered set where extLinkId = &#63;.
	*
	* @param extLinkId the ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching chain external link standards
	* @throws com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException if a matching chain external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainExternalLinkStandards findByLinkId_Last(
		long extLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLinkId_Last(extLinkId, orderByComparator);
	}

	/**
	* Returns the last chain external link standards in the ordered set where extLinkId = &#63;.
	*
	* @param extLinkId the ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching chain external link standards, or <code>null</code> if a matching chain external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainExternalLinkStandards fetchByLinkId_Last(
		long extLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLinkId_Last(extLinkId, orderByComparator);
	}

	/**
	* Returns the chain external link standardses before and after the current chain external link standards in the ordered set where extLinkId = &#63;.
	*
	* @param chainExternalLinkStandardsPK the primary key of the current chain external link standards
	* @param extLinkId the ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next chain external link standards
	* @throws com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException if a chain external link standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainExternalLinkStandards[] findByLinkId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.ChainExternalLinkStandardsPK chainExternalLinkStandardsPK,
		long extLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLinkId_PrevAndNext(chainExternalLinkStandardsPK,
			extLinkId, orderByComparator);
	}

	/**
	* Removes all the chain external link standardses where extLinkId = &#63; from the database.
	*
	* @param extLinkId the ext link ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLinkId(long extLinkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLinkId(extLinkId);
	}

	/**
	* Returns the number of chain external link standardses where extLinkId = &#63;.
	*
	* @param extLinkId the ext link ID
	* @return the number of matching chain external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLinkId(long extLinkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLinkId(extLinkId);
	}

	/**
	* Caches the chain external link standards in the entity cache if it is enabled.
	*
	* @param chainExternalLinkStandards the chain external link standards
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.ChainExternalLinkStandards chainExternalLinkStandards) {
		getPersistence().cacheResult(chainExternalLinkStandards);
	}

	/**
	* Caches the chain external link standardses in the entity cache if it is enabled.
	*
	* @param chainExternalLinkStandardses the chain external link standardses
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.ChainExternalLinkStandards> chainExternalLinkStandardses) {
		getPersistence().cacheResult(chainExternalLinkStandardses);
	}

	/**
	* Creates a new chain external link standards with the primary key. Does not add the chain external link standards to the database.
	*
	* @param chainExternalLinkStandardsPK the primary key for the new chain external link standards
	* @return the new chain external link standards
	*/
	public static com.ihg.brandstandards.db.model.ChainExternalLinkStandards create(
		com.ihg.brandstandards.db.service.persistence.ChainExternalLinkStandardsPK chainExternalLinkStandardsPK) {
		return getPersistence().create(chainExternalLinkStandardsPK);
	}

	/**
	* Removes the chain external link standards with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param chainExternalLinkStandardsPK the primary key of the chain external link standards
	* @return the chain external link standards that was removed
	* @throws com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException if a chain external link standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainExternalLinkStandards remove(
		com.ihg.brandstandards.db.service.persistence.ChainExternalLinkStandardsPK chainExternalLinkStandardsPK)
		throws com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(chainExternalLinkStandardsPK);
	}

	public static com.ihg.brandstandards.db.model.ChainExternalLinkStandards updateImpl(
		com.ihg.brandstandards.db.model.ChainExternalLinkStandards chainExternalLinkStandards)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(chainExternalLinkStandards);
	}

	/**
	* Returns the chain external link standards with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException} if it could not be found.
	*
	* @param chainExternalLinkStandardsPK the primary key of the chain external link standards
	* @return the chain external link standards
	* @throws com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException if a chain external link standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainExternalLinkStandards findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.ChainExternalLinkStandardsPK chainExternalLinkStandardsPK)
		throws com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(chainExternalLinkStandardsPK);
	}

	/**
	* Returns the chain external link standards with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param chainExternalLinkStandardsPK the primary key of the chain external link standards
	* @return the chain external link standards, or <code>null</code> if a chain external link standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainExternalLinkStandards fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.ChainExternalLinkStandardsPK chainExternalLinkStandardsPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(chainExternalLinkStandardsPK);
	}

	/**
	* Returns all the chain external link standardses.
	*
	* @return the chain external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ChainExternalLinkStandards> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the chain external link standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of chain external link standardses
	* @param end the upper bound of the range of chain external link standardses (not inclusive)
	* @return the range of chain external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ChainExternalLinkStandards> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the chain external link standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of chain external link standardses
	* @param end the upper bound of the range of chain external link standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of chain external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ChainExternalLinkStandards> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the chain external link standardses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of chain external link standardses.
	*
	* @return the number of chain external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ChainExternalLinkStandardsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ChainExternalLinkStandardsPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					ChainExternalLinkStandardsPersistence.class.getName());

			ReferenceRegistry.registerReference(ChainExternalLinkStandardsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		ChainExternalLinkStandardsPersistence persistence) {
	}

	private static ChainExternalLinkStandardsPersistence _persistence;
}