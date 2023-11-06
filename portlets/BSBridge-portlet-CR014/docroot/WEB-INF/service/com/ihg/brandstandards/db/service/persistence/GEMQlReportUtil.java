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

import com.ihg.brandstandards.db.model.GEMQlReport;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the g e m ql report service. This utility wraps {@link GEMQlReportPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMQlReportPersistence
 * @see GEMQlReportPersistenceImpl
 * @generated
 */
public class GEMQlReportUtil {
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
	public static void clearCache(GEMQlReport gemQlReport) {
		getPersistence().clearCache(gemQlReport);
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
	public static List<GEMQlReport> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GEMQlReport> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GEMQlReport> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GEMQlReport update(GEMQlReport gemQlReport)
		throws SystemException {
		return getPersistence().update(gemQlReport);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GEMQlReport update(GEMQlReport gemQlReport,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(gemQlReport, serviceContext);
	}

	/**
	* Returns all the g e m ql reports where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @return the matching g e m ql reports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMQlReport> findByPublishIdRegionId(
		long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPublishIdRegionId(publishId);
	}

	/**
	* Returns a range of all the g e m ql reports where publishId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMQlReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param start the lower bound of the range of g e m ql reports
	* @param end the upper bound of the range of g e m ql reports (not inclusive)
	* @return the range of matching g e m ql reports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMQlReport> findByPublishIdRegionId(
		long publishId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPublishIdRegionId(publishId, start, end);
	}

	/**
	* Returns an ordered range of all the g e m ql reports where publishId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMQlReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param start the lower bound of the range of g e m ql reports
	* @param end the upper bound of the range of g e m ql reports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g e m ql reports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMQlReport> findByPublishIdRegionId(
		long publishId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdRegionId(publishId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first g e m ql report in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m ql report
	* @throws com.ihg.brandstandards.db.NoSuchGEMQlReportException if a matching g e m ql report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMQlReport findByPublishIdRegionId_First(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMQlReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdRegionId_First(publishId, orderByComparator);
	}

	/**
	* Returns the first g e m ql report in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m ql report, or <code>null</code> if a matching g e m ql report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMQlReport fetchByPublishIdRegionId_First(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishIdRegionId_First(publishId, orderByComparator);
	}

	/**
	* Returns the last g e m ql report in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m ql report
	* @throws com.ihg.brandstandards.db.NoSuchGEMQlReportException if a matching g e m ql report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMQlReport findByPublishIdRegionId_Last(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMQlReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdRegionId_Last(publishId, orderByComparator);
	}

	/**
	* Returns the last g e m ql report in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m ql report, or <code>null</code> if a matching g e m ql report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMQlReport fetchByPublishIdRegionId_Last(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishIdRegionId_Last(publishId, orderByComparator);
	}

	/**
	* Returns the g e m ql reports before and after the current g e m ql report in the ordered set where publishId = &#63;.
	*
	* @param qlReportId the primary key of the current g e m ql report
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g e m ql report
	* @throws com.ihg.brandstandards.db.NoSuchGEMQlReportException if a g e m ql report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMQlReport[] findByPublishIdRegionId_PrevAndNext(
		long qlReportId, long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMQlReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdRegionId_PrevAndNext(qlReportId, publishId,
			orderByComparator);
	}

	/**
	* Removes all the g e m ql reports where publishId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPublishIdRegionId(long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPublishIdRegionId(publishId);
	}

	/**
	* Returns the number of g e m ql reports where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @return the number of matching g e m ql reports
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPublishIdRegionId(long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPublishIdRegionId(publishId);
	}

	/**
	* Caches the g e m ql report in the entity cache if it is enabled.
	*
	* @param gemQlReport the g e m ql report
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.GEMQlReport gemQlReport) {
		getPersistence().cacheResult(gemQlReport);
	}

	/**
	* Caches the g e m ql reports in the entity cache if it is enabled.
	*
	* @param gemQlReports the g e m ql reports
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GEMQlReport> gemQlReports) {
		getPersistence().cacheResult(gemQlReports);
	}

	/**
	* Creates a new g e m ql report with the primary key. Does not add the g e m ql report to the database.
	*
	* @param qlReportId the primary key for the new g e m ql report
	* @return the new g e m ql report
	*/
	public static com.ihg.brandstandards.db.model.GEMQlReport create(
		long qlReportId) {
		return getPersistence().create(qlReportId);
	}

	/**
	* Removes the g e m ql report with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param qlReportId the primary key of the g e m ql report
	* @return the g e m ql report that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGEMQlReportException if a g e m ql report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMQlReport remove(
		long qlReportId)
		throws com.ihg.brandstandards.db.NoSuchGEMQlReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(qlReportId);
	}

	public static com.ihg.brandstandards.db.model.GEMQlReport updateImpl(
		com.ihg.brandstandards.db.model.GEMQlReport gemQlReport)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(gemQlReport);
	}

	/**
	* Returns the g e m ql report with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMQlReportException} if it could not be found.
	*
	* @param qlReportId the primary key of the g e m ql report
	* @return the g e m ql report
	* @throws com.ihg.brandstandards.db.NoSuchGEMQlReportException if a g e m ql report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMQlReport findByPrimaryKey(
		long qlReportId)
		throws com.ihg.brandstandards.db.NoSuchGEMQlReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(qlReportId);
	}

	/**
	* Returns the g e m ql report with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param qlReportId the primary key of the g e m ql report
	* @return the g e m ql report, or <code>null</code> if a g e m ql report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMQlReport fetchByPrimaryKey(
		long qlReportId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(qlReportId);
	}

	/**
	* Returns all the g e m ql reports.
	*
	* @return the g e m ql reports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMQlReport> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the g e m ql reports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMQlReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m ql reports
	* @param end the upper bound of the range of g e m ql reports (not inclusive)
	* @return the range of g e m ql reports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMQlReport> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the g e m ql reports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMQlReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m ql reports
	* @param end the upper bound of the range of g e m ql reports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of g e m ql reports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMQlReport> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the g e m ql reports from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of g e m ql reports.
	*
	* @return the number of g e m ql reports
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GEMQlReportPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GEMQlReportPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					GEMQlReportPersistence.class.getName());

			ReferenceRegistry.registerReference(GEMQlReportUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GEMQlReportPersistence persistence) {
	}

	private static GEMQlReportPersistence _persistence;
}