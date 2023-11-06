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

import com.ihg.brandstandards.db.model.BridgePublishImport;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the bridge publish import service. This utility wraps {@link BridgePublishImportPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgePublishImportPersistence
 * @see BridgePublishImportPersistenceImpl
 * @generated
 */
public class BridgePublishImportUtil {
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
	public static void clearCache(BridgePublishImport bridgePublishImport) {
		getPersistence().clearCache(bridgePublishImport);
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
	public static List<BridgePublishImport> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BridgePublishImport> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BridgePublishImport> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static BridgePublishImport update(
		BridgePublishImport bridgePublishImport) throws SystemException {
		return getPersistence().update(bridgePublishImport);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static BridgePublishImport update(
		BridgePublishImport bridgePublishImport, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(bridgePublishImport, serviceContext);
	}

	/**
	* Returns all the bridge publish imports where publishId = &#63; and stdId = &#63;.
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @return the matching bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishImport> findByPublishIdAndStdId(
		long publishId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPublishIdAndStdId(publishId, stdId);
	}

	/**
	* Returns a range of all the bridge publish imports where publishId = &#63; and stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishImportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @param start the lower bound of the range of bridge publish imports
	* @param end the upper bound of the range of bridge publish imports (not inclusive)
	* @return the range of matching bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishImport> findByPublishIdAndStdId(
		long publishId, long stdId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndStdId(publishId, stdId, start, end);
	}

	/**
	* Returns an ordered range of all the bridge publish imports where publishId = &#63; and stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishImportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @param start the lower bound of the range of bridge publish imports
	* @param end the upper bound of the range of bridge publish imports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishImport> findByPublishIdAndStdId(
		long publishId, long stdId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndStdId(publishId, stdId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first bridge publish import in the ordered set where publishId = &#63; and stdId = &#63;.
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge publish import
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishImport findByPublishIdAndStdId_First(
		long publishId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndStdId_First(publishId, stdId,
			orderByComparator);
	}

	/**
	* Returns the first bridge publish import in the ordered set where publishId = &#63; and stdId = &#63;.
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge publish import, or <code>null</code> if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishImport fetchByPublishIdAndStdId_First(
		long publishId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishIdAndStdId_First(publishId, stdId,
			orderByComparator);
	}

	/**
	* Returns the last bridge publish import in the ordered set where publishId = &#63; and stdId = &#63;.
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge publish import
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishImport findByPublishIdAndStdId_Last(
		long publishId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndStdId_Last(publishId, stdId,
			orderByComparator);
	}

	/**
	* Returns the last bridge publish import in the ordered set where publishId = &#63; and stdId = &#63;.
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge publish import, or <code>null</code> if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishImport fetchByPublishIdAndStdId_Last(
		long publishId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishIdAndStdId_Last(publishId, stdId,
			orderByComparator);
	}

	/**
	* Returns the bridge publish imports before and after the current bridge publish import in the ordered set where publishId = &#63; and stdId = &#63;.
	*
	* @param publishImportId the primary key of the current bridge publish import
	* @param publishId the publish ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bridge publish import
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a bridge publish import with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishImport[] findByPublishIdAndStdId_PrevAndNext(
		long publishImportId, long publishId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndStdId_PrevAndNext(publishImportId,
			publishId, stdId, orderByComparator);
	}

	/**
	* Removes all the bridge publish imports where publishId = &#63; and stdId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPublishIdAndStdId(long publishId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPublishIdAndStdId(publishId, stdId);
	}

	/**
	* Returns the number of bridge publish imports where publishId = &#63; and stdId = &#63;.
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @return the number of matching bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPublishIdAndStdId(long publishId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPublishIdAndStdId(publishId, stdId);
	}

	/**
	* Returns the bridge publish import where publishId = &#63; and regionId = &#63; and stdId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBridgePublishImportException} if it could not be found.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param stdId the std ID
	* @return the matching bridge publish import
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishImport findByPublishIdRegionIdStdId(
		long publishId, long regionId, long stdId)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdRegionIdStdId(publishId, regionId, stdId);
	}

	/**
	* Returns the bridge publish import where publishId = &#63; and regionId = &#63; and stdId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param stdId the std ID
	* @return the matching bridge publish import, or <code>null</code> if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishImport fetchByPublishIdRegionIdStdId(
		long publishId, long regionId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishIdRegionIdStdId(publishId, regionId, stdId);
	}

	/**
	* Returns the bridge publish import where publishId = &#63; and regionId = &#63; and stdId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param stdId the std ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching bridge publish import, or <code>null</code> if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishImport fetchByPublishIdRegionIdStdId(
		long publishId, long regionId, long stdId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishIdRegionIdStdId(publishId, regionId, stdId,
			retrieveFromCache);
	}

	/**
	* Removes the bridge publish import where publishId = &#63; and regionId = &#63; and stdId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param stdId the std ID
	* @return the bridge publish import that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishImport removeByPublishIdRegionIdStdId(
		long publishId, long regionId, long stdId)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByPublishIdRegionIdStdId(publishId, regionId, stdId);
	}

	/**
	* Returns the number of bridge publish imports where publishId = &#63; and regionId = &#63; and stdId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param stdId the std ID
	* @return the number of matching bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPublishIdRegionIdStdId(long publishId,
		long regionId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPublishIdRegionIdStdId(publishId, regionId, stdId);
	}

	/**
	* Returns all the bridge publish imports where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @return the matching bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishImport> findByPublishIdAndRegionId(
		long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPublishIdAndRegionId(publishId, regionId);
	}

	/**
	* Returns a range of all the bridge publish imports where publishId = &#63; and regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishImportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param start the lower bound of the range of bridge publish imports
	* @param end the upper bound of the range of bridge publish imports (not inclusive)
	* @return the range of matching bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishImport> findByPublishIdAndRegionId(
		long publishId, long regionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndRegionId(publishId, regionId, start, end);
	}

	/**
	* Returns an ordered range of all the bridge publish imports where publishId = &#63; and regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishImportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param start the lower bound of the range of bridge publish imports
	* @param end the upper bound of the range of bridge publish imports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishImport> findByPublishIdAndRegionId(
		long publishId, long regionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndRegionId(publishId, regionId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first bridge publish import in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge publish import
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishImport findByPublishIdAndRegionId_First(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndRegionId_First(publishId, regionId,
			orderByComparator);
	}

	/**
	* Returns the first bridge publish import in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge publish import, or <code>null</code> if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishImport fetchByPublishIdAndRegionId_First(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishIdAndRegionId_First(publishId, regionId,
			orderByComparator);
	}

	/**
	* Returns the last bridge publish import in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge publish import
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishImport findByPublishIdAndRegionId_Last(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndRegionId_Last(publishId, regionId,
			orderByComparator);
	}

	/**
	* Returns the last bridge publish import in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge publish import, or <code>null</code> if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishImport fetchByPublishIdAndRegionId_Last(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishIdAndRegionId_Last(publishId, regionId,
			orderByComparator);
	}

	/**
	* Returns the bridge publish imports before and after the current bridge publish import in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishImportId the primary key of the current bridge publish import
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bridge publish import
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a bridge publish import with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishImport[] findByPublishIdAndRegionId_PrevAndNext(
		long publishImportId, long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndRegionId_PrevAndNext(publishImportId,
			publishId, regionId, orderByComparator);
	}

	/**
	* Removes all the bridge publish imports where publishId = &#63; and regionId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPublishIdAndRegionId(long publishId,
		long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPublishIdAndRegionId(publishId, regionId);
	}

	/**
	* Returns the number of bridge publish imports where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @return the number of matching bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPublishIdAndRegionId(long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPublishIdAndRegionId(publishId, regionId);
	}

	/**
	* Returns all the bridge publish imports where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @return the matching bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishImport> findByPublishId(
		long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPublishId(publishId);
	}

	/**
	* Returns a range of all the bridge publish imports where publishId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishImportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param start the lower bound of the range of bridge publish imports
	* @param end the upper bound of the range of bridge publish imports (not inclusive)
	* @return the range of matching bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishImport> findByPublishId(
		long publishId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPublishId(publishId, start, end);
	}

	/**
	* Returns an ordered range of all the bridge publish imports where publishId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishImportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param start the lower bound of the range of bridge publish imports
	* @param end the upper bound of the range of bridge publish imports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishImport> findByPublishId(
		long publishId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishId(publishId, start, end, orderByComparator);
	}

	/**
	* Returns the first bridge publish import in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge publish import
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishImport findByPublishId_First(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishId_First(publishId, orderByComparator);
	}

	/**
	* Returns the first bridge publish import in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge publish import, or <code>null</code> if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishImport fetchByPublishId_First(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishId_First(publishId, orderByComparator);
	}

	/**
	* Returns the last bridge publish import in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge publish import
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishImport findByPublishId_Last(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishId_Last(publishId, orderByComparator);
	}

	/**
	* Returns the last bridge publish import in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge publish import, or <code>null</code> if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishImport fetchByPublishId_Last(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishId_Last(publishId, orderByComparator);
	}

	/**
	* Returns the bridge publish imports before and after the current bridge publish import in the ordered set where publishId = &#63;.
	*
	* @param publishImportId the primary key of the current bridge publish import
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bridge publish import
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a bridge publish import with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishImport[] findByPublishId_PrevAndNext(
		long publishImportId, long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishId_PrevAndNext(publishImportId, publishId,
			orderByComparator);
	}

	/**
	* Removes all the bridge publish imports where publishId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPublishId(long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPublishId(publishId);
	}

	/**
	* Returns the number of bridge publish imports where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @return the number of matching bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPublishId(long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPublishId(publishId);
	}

	/**
	* Caches the bridge publish import in the entity cache if it is enabled.
	*
	* @param bridgePublishImport the bridge publish import
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.BridgePublishImport bridgePublishImport) {
		getPersistence().cacheResult(bridgePublishImport);
	}

	/**
	* Caches the bridge publish imports in the entity cache if it is enabled.
	*
	* @param bridgePublishImports the bridge publish imports
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.BridgePublishImport> bridgePublishImports) {
		getPersistence().cacheResult(bridgePublishImports);
	}

	/**
	* Creates a new bridge publish import with the primary key. Does not add the bridge publish import to the database.
	*
	* @param publishImportId the primary key for the new bridge publish import
	* @return the new bridge publish import
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishImport create(
		long publishImportId) {
		return getPersistence().create(publishImportId);
	}

	/**
	* Removes the bridge publish import with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param publishImportId the primary key of the bridge publish import
	* @return the bridge publish import that was removed
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a bridge publish import with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishImport remove(
		long publishImportId)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(publishImportId);
	}

	public static com.ihg.brandstandards.db.model.BridgePublishImport updateImpl(
		com.ihg.brandstandards.db.model.BridgePublishImport bridgePublishImport)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(bridgePublishImport);
	}

	/**
	* Returns the bridge publish import with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgePublishImportException} if it could not be found.
	*
	* @param publishImportId the primary key of the bridge publish import
	* @return the bridge publish import
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a bridge publish import with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishImport findByPrimaryKey(
		long publishImportId)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(publishImportId);
	}

	/**
	* Returns the bridge publish import with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param publishImportId the primary key of the bridge publish import
	* @return the bridge publish import, or <code>null</code> if a bridge publish import with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishImport fetchByPrimaryKey(
		long publishImportId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(publishImportId);
	}

	/**
	* Returns all the bridge publish imports.
	*
	* @return the bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishImport> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the bridge publish imports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishImportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge publish imports
	* @param end the upper bound of the range of bridge publish imports (not inclusive)
	* @return the range of bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishImport> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the bridge publish imports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishImportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge publish imports
	* @param end the upper bound of the range of bridge publish imports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishImport> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the bridge publish imports from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of bridge publish imports.
	*
	* @return the number of bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BridgePublishImportPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BridgePublishImportPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					BridgePublishImportPersistence.class.getName());

			ReferenceRegistry.registerReference(BridgePublishImportUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BridgePublishImportPersistence persistence) {
	}

	private static BridgePublishImportPersistence _persistence;
}