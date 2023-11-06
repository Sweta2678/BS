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

import com.ihg.brandstandards.db.model.StandardsHistoricalManual;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the standards historical manual service. This utility wraps {@link StandardsHistoricalManualPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsHistoricalManualPersistence
 * @see StandardsHistoricalManualPersistenceImpl
 * @generated
 */
public class StandardsHistoricalManualUtil {
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
		StandardsHistoricalManual standardsHistoricalManual) {
		getPersistence().clearCache(standardsHistoricalManual);
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
	public static List<StandardsHistoricalManual> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StandardsHistoricalManual> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StandardsHistoricalManual> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static StandardsHistoricalManual update(
		StandardsHistoricalManual standardsHistoricalManual)
		throws SystemException {
		return getPersistence().update(standardsHistoricalManual);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static StandardsHistoricalManual update(
		StandardsHistoricalManual standardsHistoricalManual,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(standardsHistoricalManual, serviceContext);
	}

	/**
	* Returns all the standards historical manuals where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the matching standards historical manuals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsHistoricalManual> findByStdId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId(stdId);
	}

	/**
	* Returns a range of all the standards historical manuals where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsHistoricalManualModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of standards historical manuals
	* @param end the upper bound of the range of standards historical manuals (not inclusive)
	* @return the range of matching standards historical manuals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsHistoricalManual> findByStdId(
		long stdId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId(stdId, start, end);
	}

	/**
	* Returns an ordered range of all the standards historical manuals where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsHistoricalManualModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of standards historical manuals
	* @param end the upper bound of the range of standards historical manuals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standards historical manuals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsHistoricalManual> findByStdId(
		long stdId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId(stdId, start, end, orderByComparator);
	}

	/**
	* Returns the first standards historical manual in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards historical manual
	* @throws com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException if a matching standards historical manual could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsHistoricalManual findByStdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId_First(stdId, orderByComparator);
	}

	/**
	* Returns the first standards historical manual in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards historical manual, or <code>null</code> if a matching standards historical manual could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsHistoricalManual fetchByStdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStdId_First(stdId, orderByComparator);
	}

	/**
	* Returns the last standards historical manual in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards historical manual
	* @throws com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException if a matching standards historical manual could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsHistoricalManual findByStdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId_Last(stdId, orderByComparator);
	}

	/**
	* Returns the last standards historical manual in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards historical manual, or <code>null</code> if a matching standards historical manual could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsHistoricalManual fetchByStdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStdId_Last(stdId, orderByComparator);
	}

	/**
	* Returns the standards historical manuals before and after the current standards historical manual in the ordered set where stdId = &#63;.
	*
	* @param stdMnlId the primary key of the current standards historical manual
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards historical manual
	* @throws com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException if a standards historical manual with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsHistoricalManual[] findByStdId_PrevAndNext(
		long stdMnlId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdId_PrevAndNext(stdMnlId, stdId, orderByComparator);
	}

	/**
	* Removes all the standards historical manuals where stdId = &#63; from the database.
	*
	* @param stdId the std ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStdId(stdId);
	}

	/**
	* Returns the number of standards historical manuals where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the number of matching standards historical manuals
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStdId(stdId);
	}

	/**
	* Returns all the standards historical manuals where histManualId = &#63;.
	*
	* @param histManualId the hist manual ID
	* @return the matching standards historical manuals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsHistoricalManual> findByHistManualId(
		long histManualId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByHistManualId(histManualId);
	}

	/**
	* Returns a range of all the standards historical manuals where histManualId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsHistoricalManualModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param histManualId the hist manual ID
	* @param start the lower bound of the range of standards historical manuals
	* @param end the upper bound of the range of standards historical manuals (not inclusive)
	* @return the range of matching standards historical manuals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsHistoricalManual> findByHistManualId(
		long histManualId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByHistManualId(histManualId, start, end);
	}

	/**
	* Returns an ordered range of all the standards historical manuals where histManualId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsHistoricalManualModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param histManualId the hist manual ID
	* @param start the lower bound of the range of standards historical manuals
	* @param end the upper bound of the range of standards historical manuals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standards historical manuals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsHistoricalManual> findByHistManualId(
		long histManualId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByHistManualId(histManualId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first standards historical manual in the ordered set where histManualId = &#63;.
	*
	* @param histManualId the hist manual ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards historical manual
	* @throws com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException if a matching standards historical manual could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsHistoricalManual findByHistManualId_First(
		long histManualId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByHistManualId_First(histManualId, orderByComparator);
	}

	/**
	* Returns the first standards historical manual in the ordered set where histManualId = &#63;.
	*
	* @param histManualId the hist manual ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards historical manual, or <code>null</code> if a matching standards historical manual could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsHistoricalManual fetchByHistManualId_First(
		long histManualId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByHistManualId_First(histManualId, orderByComparator);
	}

	/**
	* Returns the last standards historical manual in the ordered set where histManualId = &#63;.
	*
	* @param histManualId the hist manual ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards historical manual
	* @throws com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException if a matching standards historical manual could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsHistoricalManual findByHistManualId_Last(
		long histManualId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByHistManualId_Last(histManualId, orderByComparator);
	}

	/**
	* Returns the last standards historical manual in the ordered set where histManualId = &#63;.
	*
	* @param histManualId the hist manual ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards historical manual, or <code>null</code> if a matching standards historical manual could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsHistoricalManual fetchByHistManualId_Last(
		long histManualId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByHistManualId_Last(histManualId, orderByComparator);
	}

	/**
	* Returns the standards historical manuals before and after the current standards historical manual in the ordered set where histManualId = &#63;.
	*
	* @param stdMnlId the primary key of the current standards historical manual
	* @param histManualId the hist manual ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards historical manual
	* @throws com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException if a standards historical manual with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsHistoricalManual[] findByHistManualId_PrevAndNext(
		long stdMnlId, long histManualId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByHistManualId_PrevAndNext(stdMnlId, histManualId,
			orderByComparator);
	}

	/**
	* Removes all the standards historical manuals where histManualId = &#63; from the database.
	*
	* @param histManualId the hist manual ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByHistManualId(long histManualId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByHistManualId(histManualId);
	}

	/**
	* Returns the number of standards historical manuals where histManualId = &#63;.
	*
	* @param histManualId the hist manual ID
	* @return the number of matching standards historical manuals
	* @throws SystemException if a system exception occurred
	*/
	public static int countByHistManualId(long histManualId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByHistManualId(histManualId);
	}

	/**
	* Caches the standards historical manual in the entity cache if it is enabled.
	*
	* @param standardsHistoricalManual the standards historical manual
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.StandardsHistoricalManual standardsHistoricalManual) {
		getPersistence().cacheResult(standardsHistoricalManual);
	}

	/**
	* Caches the standards historical manuals in the entity cache if it is enabled.
	*
	* @param standardsHistoricalManuals the standards historical manuals
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.StandardsHistoricalManual> standardsHistoricalManuals) {
		getPersistence().cacheResult(standardsHistoricalManuals);
	}

	/**
	* Creates a new standards historical manual with the primary key. Does not add the standards historical manual to the database.
	*
	* @param stdMnlId the primary key for the new standards historical manual
	* @return the new standards historical manual
	*/
	public static com.ihg.brandstandards.db.model.StandardsHistoricalManual create(
		long stdMnlId) {
		return getPersistence().create(stdMnlId);
	}

	/**
	* Removes the standards historical manual with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stdMnlId the primary key of the standards historical manual
	* @return the standards historical manual that was removed
	* @throws com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException if a standards historical manual with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsHistoricalManual remove(
		long stdMnlId)
		throws com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(stdMnlId);
	}

	public static com.ihg.brandstandards.db.model.StandardsHistoricalManual updateImpl(
		com.ihg.brandstandards.db.model.StandardsHistoricalManual standardsHistoricalManual)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(standardsHistoricalManual);
	}

	/**
	* Returns the standards historical manual with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException} if it could not be found.
	*
	* @param stdMnlId the primary key of the standards historical manual
	* @return the standards historical manual
	* @throws com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException if a standards historical manual with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsHistoricalManual findByPrimaryKey(
		long stdMnlId)
		throws com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(stdMnlId);
	}

	/**
	* Returns the standards historical manual with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param stdMnlId the primary key of the standards historical manual
	* @return the standards historical manual, or <code>null</code> if a standards historical manual with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsHistoricalManual fetchByPrimaryKey(
		long stdMnlId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(stdMnlId);
	}

	/**
	* Returns all the standards historical manuals.
	*
	* @return the standards historical manuals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsHistoricalManual> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the standards historical manuals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsHistoricalManualModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards historical manuals
	* @param end the upper bound of the range of standards historical manuals (not inclusive)
	* @return the range of standards historical manuals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsHistoricalManual> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the standards historical manuals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsHistoricalManualModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards historical manuals
	* @param end the upper bound of the range of standards historical manuals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of standards historical manuals
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsHistoricalManual> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the standards historical manuals from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of standards historical manuals.
	*
	* @return the number of standards historical manuals
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StandardsHistoricalManualPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StandardsHistoricalManualPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					StandardsHistoricalManualPersistence.class.getName());

			ReferenceRegistry.registerReference(StandardsHistoricalManualUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(StandardsHistoricalManualPersistence persistence) {
	}

	private static StandardsHistoricalManualPersistence _persistence;
}