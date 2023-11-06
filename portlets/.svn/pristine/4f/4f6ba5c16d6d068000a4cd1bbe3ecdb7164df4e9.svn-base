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

import com.ihg.brandstandards.db.model.GEMGeneratedReportVal;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the g e m generated report val service. This utility wraps {@link GEMGeneratedReportValPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMGeneratedReportValPersistence
 * @see GEMGeneratedReportValPersistenceImpl
 * @generated
 */
public class GEMGeneratedReportValUtil {
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
	public static void clearCache(GEMGeneratedReportVal gemGeneratedReportVal) {
		getPersistence().clearCache(gemGeneratedReportVal);
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
	public static List<GEMGeneratedReportVal> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GEMGeneratedReportVal> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GEMGeneratedReportVal> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GEMGeneratedReportVal update(
		GEMGeneratedReportVal gemGeneratedReportVal) throws SystemException {
		return getPersistence().update(gemGeneratedReportVal);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GEMGeneratedReportVal update(
		GEMGeneratedReportVal gemGeneratedReportVal,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(gemGeneratedReportVal, serviceContext);
	}

	/**
	* Returns all the g e m generated report vals where reportId = &#63;.
	*
	* @param reportId the report ID
	* @return the matching g e m generated report vals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMGeneratedReportVal> findByReportId(
		long reportId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByReportId(reportId);
	}

	/**
	* Returns a range of all the g e m generated report vals where reportId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMGeneratedReportValModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportId the report ID
	* @param start the lower bound of the range of g e m generated report vals
	* @param end the upper bound of the range of g e m generated report vals (not inclusive)
	* @return the range of matching g e m generated report vals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMGeneratedReportVal> findByReportId(
		long reportId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByReportId(reportId, start, end);
	}

	/**
	* Returns an ordered range of all the g e m generated report vals where reportId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMGeneratedReportValModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportId the report ID
	* @param start the lower bound of the range of g e m generated report vals
	* @param end the upper bound of the range of g e m generated report vals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g e m generated report vals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMGeneratedReportVal> findByReportId(
		long reportId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReportId(reportId, start, end, orderByComparator);
	}

	/**
	* Returns the first g e m generated report val in the ordered set where reportId = &#63;.
	*
	* @param reportId the report ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m generated report val
	* @throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException if a matching g e m generated report val could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMGeneratedReportVal findByReportId_First(
		long reportId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByReportId_First(reportId, orderByComparator);
	}

	/**
	* Returns the first g e m generated report val in the ordered set where reportId = &#63;.
	*
	* @param reportId the report ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m generated report val, or <code>null</code> if a matching g e m generated report val could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMGeneratedReportVal fetchByReportId_First(
		long reportId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByReportId_First(reportId, orderByComparator);
	}

	/**
	* Returns the last g e m generated report val in the ordered set where reportId = &#63;.
	*
	* @param reportId the report ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m generated report val
	* @throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException if a matching g e m generated report val could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMGeneratedReportVal findByReportId_Last(
		long reportId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByReportId_Last(reportId, orderByComparator);
	}

	/**
	* Returns the last g e m generated report val in the ordered set where reportId = &#63;.
	*
	* @param reportId the report ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m generated report val, or <code>null</code> if a matching g e m generated report val could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMGeneratedReportVal fetchByReportId_Last(
		long reportId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByReportId_Last(reportId, orderByComparator);
	}

	/**
	* Returns the g e m generated report vals before and after the current g e m generated report val in the ordered set where reportId = &#63;.
	*
	* @param gemGeneratedReportValPK the primary key of the current g e m generated report val
	* @param reportId the report ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g e m generated report val
	* @throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException if a g e m generated report val with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMGeneratedReportVal[] findByReportId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.GEMGeneratedReportValPK gemGeneratedReportValPK,
		long reportId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReportId_PrevAndNext(gemGeneratedReportValPK,
			reportId, orderByComparator);
	}

	/**
	* Removes all the g e m generated report vals where reportId = &#63; from the database.
	*
	* @param reportId the report ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByReportId(long reportId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByReportId(reportId);
	}

	/**
	* Returns the number of g e m generated report vals where reportId = &#63;.
	*
	* @param reportId the report ID
	* @return the number of matching g e m generated report vals
	* @throws SystemException if a system exception occurred
	*/
	public static int countByReportId(long reportId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByReportId(reportId);
	}

	/**
	* Caches the g e m generated report val in the entity cache if it is enabled.
	*
	* @param gemGeneratedReportVal the g e m generated report val
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.GEMGeneratedReportVal gemGeneratedReportVal) {
		getPersistence().cacheResult(gemGeneratedReportVal);
	}

	/**
	* Caches the g e m generated report vals in the entity cache if it is enabled.
	*
	* @param gemGeneratedReportVals the g e m generated report vals
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GEMGeneratedReportVal> gemGeneratedReportVals) {
		getPersistence().cacheResult(gemGeneratedReportVals);
	}

	/**
	* Creates a new g e m generated report val with the primary key. Does not add the g e m generated report val to the database.
	*
	* @param gemGeneratedReportValPK the primary key for the new g e m generated report val
	* @return the new g e m generated report val
	*/
	public static com.ihg.brandstandards.db.model.GEMGeneratedReportVal create(
		com.ihg.brandstandards.db.service.persistence.GEMGeneratedReportValPK gemGeneratedReportValPK) {
		return getPersistence().create(gemGeneratedReportValPK);
	}

	/**
	* Removes the g e m generated report val with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param gemGeneratedReportValPK the primary key of the g e m generated report val
	* @return the g e m generated report val that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException if a g e m generated report val with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMGeneratedReportVal remove(
		com.ihg.brandstandards.db.service.persistence.GEMGeneratedReportValPK gemGeneratedReportValPK)
		throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(gemGeneratedReportValPK);
	}

	public static com.ihg.brandstandards.db.model.GEMGeneratedReportVal updateImpl(
		com.ihg.brandstandards.db.model.GEMGeneratedReportVal gemGeneratedReportVal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(gemGeneratedReportVal);
	}

	/**
	* Returns the g e m generated report val with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException} if it could not be found.
	*
	* @param gemGeneratedReportValPK the primary key of the g e m generated report val
	* @return the g e m generated report val
	* @throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException if a g e m generated report val with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMGeneratedReportVal findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.GEMGeneratedReportValPK gemGeneratedReportValPK)
		throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(gemGeneratedReportValPK);
	}

	/**
	* Returns the g e m generated report val with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param gemGeneratedReportValPK the primary key of the g e m generated report val
	* @return the g e m generated report val, or <code>null</code> if a g e m generated report val with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMGeneratedReportVal fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.GEMGeneratedReportValPK gemGeneratedReportValPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(gemGeneratedReportValPK);
	}

	/**
	* Returns all the g e m generated report vals.
	*
	* @return the g e m generated report vals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMGeneratedReportVal> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the g e m generated report vals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMGeneratedReportValModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m generated report vals
	* @param end the upper bound of the range of g e m generated report vals (not inclusive)
	* @return the range of g e m generated report vals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMGeneratedReportVal> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the g e m generated report vals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMGeneratedReportValModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m generated report vals
	* @param end the upper bound of the range of g e m generated report vals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of g e m generated report vals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMGeneratedReportVal> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the g e m generated report vals from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of g e m generated report vals.
	*
	* @return the number of g e m generated report vals
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GEMGeneratedReportValPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GEMGeneratedReportValPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					GEMGeneratedReportValPersistence.class.getName());

			ReferenceRegistry.registerReference(GEMGeneratedReportValUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GEMGeneratedReportValPersistence persistence) {
	}

	private static GEMGeneratedReportValPersistence _persistence;
}