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

import com.ihg.brandstandards.db.model.GEMGeneratedReport;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the g e m generated report service. This utility wraps {@link GEMGeneratedReportPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMGeneratedReportPersistence
 * @see GEMGeneratedReportPersistenceImpl
 * @generated
 */
public class GEMGeneratedReportUtil {
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
	public static void clearCache(GEMGeneratedReport gemGeneratedReport) {
		getPersistence().clearCache(gemGeneratedReport);
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
	public static List<GEMGeneratedReport> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GEMGeneratedReport> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GEMGeneratedReport> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GEMGeneratedReport update(
		GEMGeneratedReport gemGeneratedReport) throws SystemException {
		return getPersistence().update(gemGeneratedReport);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GEMGeneratedReport update(
		GEMGeneratedReport gemGeneratedReport, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(gemGeneratedReport, serviceContext);
	}

	/**
	* Returns all the g e m generated reports where templateId = &#63;.
	*
	* @param templateId the template ID
	* @return the matching g e m generated reports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMGeneratedReport> findByTemplateId(
		long templateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTemplateId(templateId);
	}

	/**
	* Returns a range of all the g e m generated reports where templateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMGeneratedReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templateId the template ID
	* @param start the lower bound of the range of g e m generated reports
	* @param end the upper bound of the range of g e m generated reports (not inclusive)
	* @return the range of matching g e m generated reports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMGeneratedReport> findByTemplateId(
		long templateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTemplateId(templateId, start, end);
	}

	/**
	* Returns an ordered range of all the g e m generated reports where templateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMGeneratedReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templateId the template ID
	* @param start the lower bound of the range of g e m generated reports
	* @param end the upper bound of the range of g e m generated reports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g e m generated reports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMGeneratedReport> findByTemplateId(
		long templateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateId(templateId, start, end, orderByComparator);
	}

	/**
	* Returns the first g e m generated report in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m generated report
	* @throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportException if a matching g e m generated report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMGeneratedReport findByTemplateId_First(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateId_First(templateId, orderByComparator);
	}

	/**
	* Returns the first g e m generated report in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m generated report, or <code>null</code> if a matching g e m generated report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMGeneratedReport fetchByTemplateId_First(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplateId_First(templateId, orderByComparator);
	}

	/**
	* Returns the last g e m generated report in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m generated report
	* @throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportException if a matching g e m generated report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMGeneratedReport findByTemplateId_Last(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateId_Last(templateId, orderByComparator);
	}

	/**
	* Returns the last g e m generated report in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m generated report, or <code>null</code> if a matching g e m generated report could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMGeneratedReport fetchByTemplateId_Last(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplateId_Last(templateId, orderByComparator);
	}

	/**
	* Returns the g e m generated reports before and after the current g e m generated report in the ordered set where templateId = &#63;.
	*
	* @param reportId the primary key of the current g e m generated report
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g e m generated report
	* @throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportException if a g e m generated report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMGeneratedReport[] findByTemplateId_PrevAndNext(
		long reportId, long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateId_PrevAndNext(reportId, templateId,
			orderByComparator);
	}

	/**
	* Removes all the g e m generated reports where templateId = &#63; from the database.
	*
	* @param templateId the template ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTemplateId(long templateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTemplateId(templateId);
	}

	/**
	* Returns the number of g e m generated reports where templateId = &#63;.
	*
	* @param templateId the template ID
	* @return the number of matching g e m generated reports
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTemplateId(long templateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTemplateId(templateId);
	}

	/**
	* Caches the g e m generated report in the entity cache if it is enabled.
	*
	* @param gemGeneratedReport the g e m generated report
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.GEMGeneratedReport gemGeneratedReport) {
		getPersistence().cacheResult(gemGeneratedReport);
	}

	/**
	* Caches the g e m generated reports in the entity cache if it is enabled.
	*
	* @param gemGeneratedReports the g e m generated reports
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GEMGeneratedReport> gemGeneratedReports) {
		getPersistence().cacheResult(gemGeneratedReports);
	}

	/**
	* Creates a new g e m generated report with the primary key. Does not add the g e m generated report to the database.
	*
	* @param reportId the primary key for the new g e m generated report
	* @return the new g e m generated report
	*/
	public static com.ihg.brandstandards.db.model.GEMGeneratedReport create(
		long reportId) {
		return getPersistence().create(reportId);
	}

	/**
	* Removes the g e m generated report with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param reportId the primary key of the g e m generated report
	* @return the g e m generated report that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportException if a g e m generated report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMGeneratedReport remove(
		long reportId)
		throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(reportId);
	}

	public static com.ihg.brandstandards.db.model.GEMGeneratedReport updateImpl(
		com.ihg.brandstandards.db.model.GEMGeneratedReport gemGeneratedReport)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(gemGeneratedReport);
	}

	/**
	* Returns the g e m generated report with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMGeneratedReportException} if it could not be found.
	*
	* @param reportId the primary key of the g e m generated report
	* @return the g e m generated report
	* @throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportException if a g e m generated report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMGeneratedReport findByPrimaryKey(
		long reportId)
		throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(reportId);
	}

	/**
	* Returns the g e m generated report with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param reportId the primary key of the g e m generated report
	* @return the g e m generated report, or <code>null</code> if a g e m generated report with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMGeneratedReport fetchByPrimaryKey(
		long reportId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(reportId);
	}

	/**
	* Returns all the g e m generated reports.
	*
	* @return the g e m generated reports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMGeneratedReport> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the g e m generated reports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMGeneratedReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m generated reports
	* @param end the upper bound of the range of g e m generated reports (not inclusive)
	* @return the range of g e m generated reports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMGeneratedReport> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the g e m generated reports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMGeneratedReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m generated reports
	* @param end the upper bound of the range of g e m generated reports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of g e m generated reports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMGeneratedReport> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the g e m generated reports from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of g e m generated reports.
	*
	* @return the number of g e m generated reports
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GEMGeneratedReportPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GEMGeneratedReportPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					GEMGeneratedReportPersistence.class.getName());

			ReferenceRegistry.registerReference(GEMGeneratedReportUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GEMGeneratedReportPersistence persistence) {
	}

	private static GEMGeneratedReportPersistence _persistence;
}