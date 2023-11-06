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

import com.ihg.brandstandards.db.model.GEMMeasurement;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the g e m measurement service. This utility wraps {@link GEMMeasurementPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMMeasurementPersistence
 * @see GEMMeasurementPersistenceImpl
 * @generated
 */
public class GEMMeasurementUtil {
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
	public static void clearCache(GEMMeasurement gemMeasurement) {
		getPersistence().clearCache(gemMeasurement);
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
	public static List<GEMMeasurement> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GEMMeasurement> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GEMMeasurement> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GEMMeasurement update(GEMMeasurement gemMeasurement)
		throws SystemException {
		return getPersistence().update(gemMeasurement);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GEMMeasurement update(GEMMeasurement gemMeasurement,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(gemMeasurement, serviceContext);
	}

	/**
	* Returns all the g e m measurements where templateId = &#63;.
	*
	* @param templateId the template ID
	* @return the matching g e m measurements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMMeasurement> findByTemplateId(
		long templateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTemplateId(templateId);
	}

	/**
	* Returns a range of all the g e m measurements where templateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templateId the template ID
	* @param start the lower bound of the range of g e m measurements
	* @param end the upper bound of the range of g e m measurements (not inclusive)
	* @return the range of matching g e m measurements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMMeasurement> findByTemplateId(
		long templateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTemplateId(templateId, start, end);
	}

	/**
	* Returns an ordered range of all the g e m measurements where templateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templateId the template ID
	* @param start the lower bound of the range of g e m measurements
	* @param end the upper bound of the range of g e m measurements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g e m measurements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMMeasurement> findByTemplateId(
		long templateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateId(templateId, start, end, orderByComparator);
	}

	/**
	* Returns the first g e m measurement in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m measurement
	* @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException if a matching g e m measurement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurement findByTemplateId_First(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateId_First(templateId, orderByComparator);
	}

	/**
	* Returns the first g e m measurement in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m measurement, or <code>null</code> if a matching g e m measurement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurement fetchByTemplateId_First(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplateId_First(templateId, orderByComparator);
	}

	/**
	* Returns the last g e m measurement in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m measurement
	* @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException if a matching g e m measurement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurement findByTemplateId_Last(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateId_Last(templateId, orderByComparator);
	}

	/**
	* Returns the last g e m measurement in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m measurement, or <code>null</code> if a matching g e m measurement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurement fetchByTemplateId_Last(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplateId_Last(templateId, orderByComparator);
	}

	/**
	* Returns the g e m measurements before and after the current g e m measurement in the ordered set where templateId = &#63;.
	*
	* @param measurementId the primary key of the current g e m measurement
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g e m measurement
	* @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException if a g e m measurement with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurement[] findByTemplateId_PrevAndNext(
		long measurementId, long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateId_PrevAndNext(measurementId, templateId,
			orderByComparator);
	}

	/**
	* Removes all the g e m measurements where templateId = &#63; from the database.
	*
	* @param templateId the template ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTemplateId(long templateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTemplateId(templateId);
	}

	/**
	* Returns the number of g e m measurements where templateId = &#63;.
	*
	* @param templateId the template ID
	* @return the number of matching g e m measurements
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTemplateId(long templateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTemplateId(templateId);
	}

	/**
	* Returns all the g e m measurements where templateId = &#63; and measurementType = &#63;.
	*
	* @param templateId the template ID
	* @param measurementType the measurement type
	* @return the matching g e m measurements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMMeasurement> findByTemplateIdAndType(
		long templateId, java.lang.String measurementType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateIdAndType(templateId, measurementType);
	}

	/**
	* Returns a range of all the g e m measurements where templateId = &#63; and measurementType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templateId the template ID
	* @param measurementType the measurement type
	* @param start the lower bound of the range of g e m measurements
	* @param end the upper bound of the range of g e m measurements (not inclusive)
	* @return the range of matching g e m measurements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMMeasurement> findByTemplateIdAndType(
		long templateId, java.lang.String measurementType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateIdAndType(templateId, measurementType, start,
			end);
	}

	/**
	* Returns an ordered range of all the g e m measurements where templateId = &#63; and measurementType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templateId the template ID
	* @param measurementType the measurement type
	* @param start the lower bound of the range of g e m measurements
	* @param end the upper bound of the range of g e m measurements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g e m measurements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMMeasurement> findByTemplateIdAndType(
		long templateId, java.lang.String measurementType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateIdAndType(templateId, measurementType, start,
			end, orderByComparator);
	}

	/**
	* Returns the first g e m measurement in the ordered set where templateId = &#63; and measurementType = &#63;.
	*
	* @param templateId the template ID
	* @param measurementType the measurement type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m measurement
	* @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException if a matching g e m measurement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurement findByTemplateIdAndType_First(
		long templateId, java.lang.String measurementType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateIdAndType_First(templateId, measurementType,
			orderByComparator);
	}

	/**
	* Returns the first g e m measurement in the ordered set where templateId = &#63; and measurementType = &#63;.
	*
	* @param templateId the template ID
	* @param measurementType the measurement type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m measurement, or <code>null</code> if a matching g e m measurement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurement fetchByTemplateIdAndType_First(
		long templateId, java.lang.String measurementType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplateIdAndType_First(templateId, measurementType,
			orderByComparator);
	}

	/**
	* Returns the last g e m measurement in the ordered set where templateId = &#63; and measurementType = &#63;.
	*
	* @param templateId the template ID
	* @param measurementType the measurement type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m measurement
	* @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException if a matching g e m measurement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurement findByTemplateIdAndType_Last(
		long templateId, java.lang.String measurementType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateIdAndType_Last(templateId, measurementType,
			orderByComparator);
	}

	/**
	* Returns the last g e m measurement in the ordered set where templateId = &#63; and measurementType = &#63;.
	*
	* @param templateId the template ID
	* @param measurementType the measurement type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m measurement, or <code>null</code> if a matching g e m measurement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurement fetchByTemplateIdAndType_Last(
		long templateId, java.lang.String measurementType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplateIdAndType_Last(templateId, measurementType,
			orderByComparator);
	}

	/**
	* Returns the g e m measurements before and after the current g e m measurement in the ordered set where templateId = &#63; and measurementType = &#63;.
	*
	* @param measurementId the primary key of the current g e m measurement
	* @param templateId the template ID
	* @param measurementType the measurement type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g e m measurement
	* @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException if a g e m measurement with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurement[] findByTemplateIdAndType_PrevAndNext(
		long measurementId, long templateId, java.lang.String measurementType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateIdAndType_PrevAndNext(measurementId,
			templateId, measurementType, orderByComparator);
	}

	/**
	* Removes all the g e m measurements where templateId = &#63; and measurementType = &#63; from the database.
	*
	* @param templateId the template ID
	* @param measurementType the measurement type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTemplateIdAndType(long templateId,
		java.lang.String measurementType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTemplateIdAndType(templateId, measurementType);
	}

	/**
	* Returns the number of g e m measurements where templateId = &#63; and measurementType = &#63;.
	*
	* @param templateId the template ID
	* @param measurementType the measurement type
	* @return the number of matching g e m measurements
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTemplateIdAndType(long templateId,
		java.lang.String measurementType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByTemplateIdAndType(templateId, measurementType);
	}

	/**
	* Returns the g e m measurement where measurementName = &#63; and measurementType = &#63; and templateId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchGEMMeasurementException} if it could not be found.
	*
	* @param measurementName the measurement name
	* @param measurementType the measurement type
	* @param templateId the template ID
	* @return the matching g e m measurement
	* @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException if a matching g e m measurement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurement findByNameTypeAndTemplateId(
		java.lang.String measurementName, java.lang.String measurementType,
		long templateId)
		throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNameTypeAndTemplateId(measurementName,
			measurementType, templateId);
	}

	/**
	* Returns the g e m measurement where measurementName = &#63; and measurementType = &#63; and templateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param measurementName the measurement name
	* @param measurementType the measurement type
	* @param templateId the template ID
	* @return the matching g e m measurement, or <code>null</code> if a matching g e m measurement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurement fetchByNameTypeAndTemplateId(
		java.lang.String measurementName, java.lang.String measurementType,
		long templateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNameTypeAndTemplateId(measurementName,
			measurementType, templateId);
	}

	/**
	* Returns the g e m measurement where measurementName = &#63; and measurementType = &#63; and templateId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param measurementName the measurement name
	* @param measurementType the measurement type
	* @param templateId the template ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching g e m measurement, or <code>null</code> if a matching g e m measurement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurement fetchByNameTypeAndTemplateId(
		java.lang.String measurementName, java.lang.String measurementType,
		long templateId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNameTypeAndTemplateId(measurementName,
			measurementType, templateId, retrieveFromCache);
	}

	/**
	* Removes the g e m measurement where measurementName = &#63; and measurementType = &#63; and templateId = &#63; from the database.
	*
	* @param measurementName the measurement name
	* @param measurementType the measurement type
	* @param templateId the template ID
	* @return the g e m measurement that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurement removeByNameTypeAndTemplateId(
		java.lang.String measurementName, java.lang.String measurementType,
		long templateId)
		throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByNameTypeAndTemplateId(measurementName,
			measurementType, templateId);
	}

	/**
	* Returns the number of g e m measurements where measurementName = &#63; and measurementType = &#63; and templateId = &#63;.
	*
	* @param measurementName the measurement name
	* @param measurementType the measurement type
	* @param templateId the template ID
	* @return the number of matching g e m measurements
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNameTypeAndTemplateId(
		java.lang.String measurementName, java.lang.String measurementType,
		long templateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByNameTypeAndTemplateId(measurementName,
			measurementType, templateId);
	}

	/**
	* Caches the g e m measurement in the entity cache if it is enabled.
	*
	* @param gemMeasurement the g e m measurement
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.GEMMeasurement gemMeasurement) {
		getPersistence().cacheResult(gemMeasurement);
	}

	/**
	* Caches the g e m measurements in the entity cache if it is enabled.
	*
	* @param gemMeasurements the g e m measurements
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GEMMeasurement> gemMeasurements) {
		getPersistence().cacheResult(gemMeasurements);
	}

	/**
	* Creates a new g e m measurement with the primary key. Does not add the g e m measurement to the database.
	*
	* @param measurementId the primary key for the new g e m measurement
	* @return the new g e m measurement
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurement create(
		long measurementId) {
		return getPersistence().create(measurementId);
	}

	/**
	* Removes the g e m measurement with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param measurementId the primary key of the g e m measurement
	* @return the g e m measurement that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException if a g e m measurement with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurement remove(
		long measurementId)
		throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(measurementId);
	}

	public static com.ihg.brandstandards.db.model.GEMMeasurement updateImpl(
		com.ihg.brandstandards.db.model.GEMMeasurement gemMeasurement)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(gemMeasurement);
	}

	/**
	* Returns the g e m measurement with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMMeasurementException} if it could not be found.
	*
	* @param measurementId the primary key of the g e m measurement
	* @return the g e m measurement
	* @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException if a g e m measurement with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurement findByPrimaryKey(
		long measurementId)
		throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(measurementId);
	}

	/**
	* Returns the g e m measurement with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param measurementId the primary key of the g e m measurement
	* @return the g e m measurement, or <code>null</code> if a g e m measurement with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMMeasurement fetchByPrimaryKey(
		long measurementId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(measurementId);
	}

	/**
	* Returns all the g e m measurements.
	*
	* @return the g e m measurements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMMeasurement> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the g e m measurements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m measurements
	* @param end the upper bound of the range of g e m measurements (not inclusive)
	* @return the range of g e m measurements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMMeasurement> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the g e m measurements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m measurements
	* @param end the upper bound of the range of g e m measurements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of g e m measurements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMMeasurement> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the g e m measurements from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of g e m measurements.
	*
	* @return the number of g e m measurements
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GEMMeasurementPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GEMMeasurementPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					GEMMeasurementPersistence.class.getName());

			ReferenceRegistry.registerReference(GEMMeasurementUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GEMMeasurementPersistence persistence) {
	}

	private static GEMMeasurementPersistence _persistence;
}