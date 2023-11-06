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

import com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the spread sheet attribute update service. This utility wraps {@link SpreadSheetAttributeUpdatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see SpreadSheetAttributeUpdatePersistence
 * @see SpreadSheetAttributeUpdatePersistenceImpl
 * @generated
 */
public class SpreadSheetAttributeUpdateUtil {
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
		SpreadSheetAttributeUpdate spreadSheetAttributeUpdate) {
		getPersistence().clearCache(spreadSheetAttributeUpdate);
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
	public static List<SpreadSheetAttributeUpdate> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SpreadSheetAttributeUpdate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SpreadSheetAttributeUpdate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SpreadSheetAttributeUpdate update(
		SpreadSheetAttributeUpdate spreadSheetAttributeUpdate)
		throws SystemException {
		return getPersistence().update(spreadSheetAttributeUpdate);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SpreadSheetAttributeUpdate update(
		SpreadSheetAttributeUpdate spreadSheetAttributeUpdate,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(spreadSheetAttributeUpdate, serviceContext);
	}

	/**
	* Returns all the spread sheet attribute updates where status = &#63;.
	*
	* @param status the status
	* @return the matching spread sheet attribute updates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate> findBystatus(
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystatus(status);
	}

	/**
	* Returns a range of all the spread sheet attribute updates where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpreadSheetAttributeUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of spread sheet attribute updates
	* @param end the upper bound of the range of spread sheet attribute updates (not inclusive)
	* @return the range of matching spread sheet attribute updates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate> findBystatus(
		java.lang.String status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the spread sheet attribute updates where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpreadSheetAttributeUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of spread sheet attribute updates
	* @param end the upper bound of the range of spread sheet attribute updates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching spread sheet attribute updates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate> findBystatus(
		java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBystatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first spread sheet attribute update in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching spread sheet attribute update
	* @throws com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException if a matching spread sheet attribute update could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate findBystatus_First(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystatus_First(status, orderByComparator);
	}

	/**
	* Returns the first spread sheet attribute update in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching spread sheet attribute update, or <code>null</code> if a matching spread sheet attribute update could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate fetchBystatus_First(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBystatus_First(status, orderByComparator);
	}

	/**
	* Returns the last spread sheet attribute update in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching spread sheet attribute update
	* @throws com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException if a matching spread sheet attribute update could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate findBystatus_Last(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last spread sheet attribute update in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching spread sheet attribute update, or <code>null</code> if a matching spread sheet attribute update could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate fetchBystatus_Last(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBystatus_Last(status, orderByComparator);
	}

	/**
	* Returns the spread sheet attribute updates before and after the current spread sheet attribute update in the ordered set where status = &#63;.
	*
	* @param speardSheetId the primary key of the current spread sheet attribute update
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next spread sheet attribute update
	* @throws com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException if a spread sheet attribute update with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate[] findBystatus_PrevAndNext(
		long speardSheetId, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBystatus_PrevAndNext(speardSheetId, status,
			orderByComparator);
	}

	/**
	* Removes all the spread sheet attribute updates where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBystatus(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBystatus(status);
	}

	/**
	* Returns the number of spread sheet attribute updates where status = &#63;.
	*
	* @param status the status
	* @return the number of matching spread sheet attribute updates
	* @throws SystemException if a system exception occurred
	*/
	public static int countBystatus(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBystatus(status);
	}

	/**
	* Caches the spread sheet attribute update in the entity cache if it is enabled.
	*
	* @param spreadSheetAttributeUpdate the spread sheet attribute update
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate spreadSheetAttributeUpdate) {
		getPersistence().cacheResult(spreadSheetAttributeUpdate);
	}

	/**
	* Caches the spread sheet attribute updates in the entity cache if it is enabled.
	*
	* @param spreadSheetAttributeUpdates the spread sheet attribute updates
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate> spreadSheetAttributeUpdates) {
		getPersistence().cacheResult(spreadSheetAttributeUpdates);
	}

	/**
	* Creates a new spread sheet attribute update with the primary key. Does not add the spread sheet attribute update to the database.
	*
	* @param speardSheetId the primary key for the new spread sheet attribute update
	* @return the new spread sheet attribute update
	*/
	public static com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate create(
		long speardSheetId) {
		return getPersistence().create(speardSheetId);
	}

	/**
	* Removes the spread sheet attribute update with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param speardSheetId the primary key of the spread sheet attribute update
	* @return the spread sheet attribute update that was removed
	* @throws com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException if a spread sheet attribute update with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate remove(
		long speardSheetId)
		throws com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(speardSheetId);
	}

	public static com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate updateImpl(
		com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate spreadSheetAttributeUpdate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spreadSheetAttributeUpdate);
	}

	/**
	* Returns the spread sheet attribute update with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException} if it could not be found.
	*
	* @param speardSheetId the primary key of the spread sheet attribute update
	* @return the spread sheet attribute update
	* @throws com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException if a spread sheet attribute update with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate findByPrimaryKey(
		long speardSheetId)
		throws com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(speardSheetId);
	}

	/**
	* Returns the spread sheet attribute update with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param speardSheetId the primary key of the spread sheet attribute update
	* @return the spread sheet attribute update, or <code>null</code> if a spread sheet attribute update with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate fetchByPrimaryKey(
		long speardSheetId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(speardSheetId);
	}

	/**
	* Returns all the spread sheet attribute updates.
	*
	* @return the spread sheet attribute updates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the spread sheet attribute updates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpreadSheetAttributeUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of spread sheet attribute updates
	* @param end the upper bound of the range of spread sheet attribute updates (not inclusive)
	* @return the range of spread sheet attribute updates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the spread sheet attribute updates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpreadSheetAttributeUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of spread sheet attribute updates
	* @param end the upper bound of the range of spread sheet attribute updates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of spread sheet attribute updates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the spread sheet attribute updates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of spread sheet attribute updates.
	*
	* @return the number of spread sheet attribute updates
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SpreadSheetAttributeUpdatePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SpreadSheetAttributeUpdatePersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					SpreadSheetAttributeUpdatePersistence.class.getName());

			ReferenceRegistry.registerReference(SpreadSheetAttributeUpdateUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		SpreadSheetAttributeUpdatePersistence persistence) {
	}

	private static SpreadSheetAttributeUpdatePersistence _persistence;
}