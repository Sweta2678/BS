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

import com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the bridge progress discrepancy service. This utility wraps {@link BridgeProgressDiscrepancyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgeProgressDiscrepancyPersistence
 * @see BridgeProgressDiscrepancyPersistenceImpl
 * @generated
 */
public class BridgeProgressDiscrepancyUtil {
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
		BridgeProgressDiscrepancy bridgeProgressDiscrepancy) {
		getPersistence().clearCache(bridgeProgressDiscrepancy);
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
	public static List<BridgeProgressDiscrepancy> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BridgeProgressDiscrepancy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BridgeProgressDiscrepancy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static BridgeProgressDiscrepancy update(
		BridgeProgressDiscrepancy bridgeProgressDiscrepancy)
		throws SystemException {
		return getPersistence().update(bridgeProgressDiscrepancy);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static BridgeProgressDiscrepancy update(
		BridgeProgressDiscrepancy bridgeProgressDiscrepancy,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(bridgeProgressDiscrepancy, serviceContext);
	}

	/**
	* Returns all the bridge progress discrepancies where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @return the matching bridge progress discrepancies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy> findBypublicationPublishRgn(
		long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBypublicationPublishRgn(publishId, regionId);
	}

	/**
	* Returns a range of all the bridge progress discrepancies where publishId = &#63; and regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressDiscrepancyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param start the lower bound of the range of bridge progress discrepancies
	* @param end the upper bound of the range of bridge progress discrepancies (not inclusive)
	* @return the range of matching bridge progress discrepancies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy> findBypublicationPublishRgn(
		long publishId, long regionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublicationPublishRgn(publishId, regionId, start, end);
	}

	/**
	* Returns an ordered range of all the bridge progress discrepancies where publishId = &#63; and regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressDiscrepancyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param start the lower bound of the range of bridge progress discrepancies
	* @param end the upper bound of the range of bridge progress discrepancies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bridge progress discrepancies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy> findBypublicationPublishRgn(
		long publishId, long regionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublicationPublishRgn(publishId, regionId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge progress discrepancy
	* @throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException if a matching bridge progress discrepancy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy findBypublicationPublishRgn_First(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublicationPublishRgn_First(publishId, regionId,
			orderByComparator);
	}

	/**
	* Returns the first bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge progress discrepancy, or <code>null</code> if a matching bridge progress discrepancy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy fetchBypublicationPublishRgn_First(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBypublicationPublishRgn_First(publishId, regionId,
			orderByComparator);
	}

	/**
	* Returns the last bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge progress discrepancy
	* @throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException if a matching bridge progress discrepancy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy findBypublicationPublishRgn_Last(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublicationPublishRgn_Last(publishId, regionId,
			orderByComparator);
	}

	/**
	* Returns the last bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge progress discrepancy, or <code>null</code> if a matching bridge progress discrepancy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy fetchBypublicationPublishRgn_Last(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBypublicationPublishRgn_Last(publishId, regionId,
			orderByComparator);
	}

	/**
	* Returns the bridge progress discrepancies before and after the current bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param bridgeProgressDiscrepancyPK the primary key of the current bridge progress discrepancy
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bridge progress discrepancy
	* @throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException if a bridge progress discrepancy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy[] findBypublicationPublishRgn_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.BridgeProgressDiscrepancyPK bridgeProgressDiscrepancyPK,
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublicationPublishRgn_PrevAndNext(bridgeProgressDiscrepancyPK,
			publishId, regionId, orderByComparator);
	}

	/**
	* Removes all the bridge progress discrepancies where publishId = &#63; and regionId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBypublicationPublishRgn(long publishId,
		long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBypublicationPublishRgn(publishId, regionId);
	}

	/**
	* Returns the number of bridge progress discrepancies where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @return the number of matching bridge progress discrepancies
	* @throws SystemException if a system exception occurred
	*/
	public static int countBypublicationPublishRgn(long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBypublicationPublishRgn(publishId, regionId);
	}

	/**
	* Returns all the bridge progress discrepancies where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @return the matching bridge progress discrepancies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy> findBypublicationPublishRgnCategory(
		long publishId, long regionId, long progressCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublicationPublishRgnCategory(publishId, regionId,
			progressCategoryId);
	}

	/**
	* Returns a range of all the bridge progress discrepancies where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressDiscrepancyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @param start the lower bound of the range of bridge progress discrepancies
	* @param end the upper bound of the range of bridge progress discrepancies (not inclusive)
	* @return the range of matching bridge progress discrepancies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy> findBypublicationPublishRgnCategory(
		long publishId, long regionId, long progressCategoryId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublicationPublishRgnCategory(publishId, regionId,
			progressCategoryId, start, end);
	}

	/**
	* Returns an ordered range of all the bridge progress discrepancies where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressDiscrepancyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @param start the lower bound of the range of bridge progress discrepancies
	* @param end the upper bound of the range of bridge progress discrepancies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bridge progress discrepancies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy> findBypublicationPublishRgnCategory(
		long publishId, long regionId, long progressCategoryId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublicationPublishRgnCategory(publishId, regionId,
			progressCategoryId, start, end, orderByComparator);
	}

	/**
	* Returns the first bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge progress discrepancy
	* @throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException if a matching bridge progress discrepancy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy findBypublicationPublishRgnCategory_First(
		long publishId, long regionId, long progressCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublicationPublishRgnCategory_First(publishId,
			regionId, progressCategoryId, orderByComparator);
	}

	/**
	* Returns the first bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge progress discrepancy, or <code>null</code> if a matching bridge progress discrepancy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy fetchBypublicationPublishRgnCategory_First(
		long publishId, long regionId, long progressCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBypublicationPublishRgnCategory_First(publishId,
			regionId, progressCategoryId, orderByComparator);
	}

	/**
	* Returns the last bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge progress discrepancy
	* @throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException if a matching bridge progress discrepancy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy findBypublicationPublishRgnCategory_Last(
		long publishId, long regionId, long progressCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublicationPublishRgnCategory_Last(publishId,
			regionId, progressCategoryId, orderByComparator);
	}

	/**
	* Returns the last bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge progress discrepancy, or <code>null</code> if a matching bridge progress discrepancy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy fetchBypublicationPublishRgnCategory_Last(
		long publishId, long regionId, long progressCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBypublicationPublishRgnCategory_Last(publishId,
			regionId, progressCategoryId, orderByComparator);
	}

	/**
	* Returns the bridge progress discrepancies before and after the current bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63;.
	*
	* @param bridgeProgressDiscrepancyPK the primary key of the current bridge progress discrepancy
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bridge progress discrepancy
	* @throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException if a bridge progress discrepancy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy[] findBypublicationPublishRgnCategory_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.BridgeProgressDiscrepancyPK bridgeProgressDiscrepancyPK,
		long publishId, long regionId, long progressCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublicationPublishRgnCategory_PrevAndNext(bridgeProgressDiscrepancyPK,
			publishId, regionId, progressCategoryId, orderByComparator);
	}

	/**
	* Removes all the bridge progress discrepancies where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBypublicationPublishRgnCategory(long publishId,
		long regionId, long progressCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeBypublicationPublishRgnCategory(publishId, regionId,
			progressCategoryId);
	}

	/**
	* Returns the number of bridge progress discrepancies where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @return the number of matching bridge progress discrepancies
	* @throws SystemException if a system exception occurred
	*/
	public static int countBypublicationPublishRgnCategory(long publishId,
		long regionId, long progressCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBypublicationPublishRgnCategory(publishId, regionId,
			progressCategoryId);
	}

	/**
	* Returns the bridge progress discrepancy where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63; and progressSubCategoryId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException} if it could not be found.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @param progressSubCategoryId the progress sub category ID
	* @return the matching bridge progress discrepancy
	* @throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException if a matching bridge progress discrepancy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy findBypublicationPublishRgnCatSubCat(
		long publishId, long regionId, long progressCategoryId,
		long progressSubCategoryId)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBypublicationPublishRgnCatSubCat(publishId, regionId,
			progressCategoryId, progressSubCategoryId);
	}

	/**
	* Returns the bridge progress discrepancy where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63; and progressSubCategoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @param progressSubCategoryId the progress sub category ID
	* @return the matching bridge progress discrepancy, or <code>null</code> if a matching bridge progress discrepancy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy fetchBypublicationPublishRgnCatSubCat(
		long publishId, long regionId, long progressCategoryId,
		long progressSubCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBypublicationPublishRgnCatSubCat(publishId, regionId,
			progressCategoryId, progressSubCategoryId);
	}

	/**
	* Returns the bridge progress discrepancy where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63; and progressSubCategoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @param progressSubCategoryId the progress sub category ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching bridge progress discrepancy, or <code>null</code> if a matching bridge progress discrepancy could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy fetchBypublicationPublishRgnCatSubCat(
		long publishId, long regionId, long progressCategoryId,
		long progressSubCategoryId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBypublicationPublishRgnCatSubCat(publishId, regionId,
			progressCategoryId, progressSubCategoryId, retrieveFromCache);
	}

	/**
	* Removes the bridge progress discrepancy where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63; and progressSubCategoryId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @param progressSubCategoryId the progress sub category ID
	* @return the bridge progress discrepancy that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy removeBypublicationPublishRgnCatSubCat(
		long publishId, long regionId, long progressCategoryId,
		long progressSubCategoryId)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeBypublicationPublishRgnCatSubCat(publishId, regionId,
			progressCategoryId, progressSubCategoryId);
	}

	/**
	* Returns the number of bridge progress discrepancies where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63; and progressSubCategoryId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param progressCategoryId the progress category ID
	* @param progressSubCategoryId the progress sub category ID
	* @return the number of matching bridge progress discrepancies
	* @throws SystemException if a system exception occurred
	*/
	public static int countBypublicationPublishRgnCatSubCat(long publishId,
		long regionId, long progressCategoryId, long progressSubCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBypublicationPublishRgnCatSubCat(publishId, regionId,
			progressCategoryId, progressSubCategoryId);
	}

	/**
	* Caches the bridge progress discrepancy in the entity cache if it is enabled.
	*
	* @param bridgeProgressDiscrepancy the bridge progress discrepancy
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy bridgeProgressDiscrepancy) {
		getPersistence().cacheResult(bridgeProgressDiscrepancy);
	}

	/**
	* Caches the bridge progress discrepancies in the entity cache if it is enabled.
	*
	* @param bridgeProgressDiscrepancies the bridge progress discrepancies
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy> bridgeProgressDiscrepancies) {
		getPersistence().cacheResult(bridgeProgressDiscrepancies);
	}

	/**
	* Creates a new bridge progress discrepancy with the primary key. Does not add the bridge progress discrepancy to the database.
	*
	* @param bridgeProgressDiscrepancyPK the primary key for the new bridge progress discrepancy
	* @return the new bridge progress discrepancy
	*/
	public static com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy create(
		com.ihg.brandstandards.db.service.persistence.BridgeProgressDiscrepancyPK bridgeProgressDiscrepancyPK) {
		return getPersistence().create(bridgeProgressDiscrepancyPK);
	}

	/**
	* Removes the bridge progress discrepancy with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bridgeProgressDiscrepancyPK the primary key of the bridge progress discrepancy
	* @return the bridge progress discrepancy that was removed
	* @throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException if a bridge progress discrepancy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy remove(
		com.ihg.brandstandards.db.service.persistence.BridgeProgressDiscrepancyPK bridgeProgressDiscrepancyPK)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(bridgeProgressDiscrepancyPK);
	}

	public static com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy updateImpl(
		com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy bridgeProgressDiscrepancy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(bridgeProgressDiscrepancy);
	}

	/**
	* Returns the bridge progress discrepancy with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException} if it could not be found.
	*
	* @param bridgeProgressDiscrepancyPK the primary key of the bridge progress discrepancy
	* @return the bridge progress discrepancy
	* @throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException if a bridge progress discrepancy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.BridgeProgressDiscrepancyPK bridgeProgressDiscrepancyPK)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(bridgeProgressDiscrepancyPK);
	}

	/**
	* Returns the bridge progress discrepancy with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bridgeProgressDiscrepancyPK the primary key of the bridge progress discrepancy
	* @return the bridge progress discrepancy, or <code>null</code> if a bridge progress discrepancy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.BridgeProgressDiscrepancyPK bridgeProgressDiscrepancyPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(bridgeProgressDiscrepancyPK);
	}

	/**
	* Returns all the bridge progress discrepancies.
	*
	* @return the bridge progress discrepancies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the bridge progress discrepancies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressDiscrepancyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge progress discrepancies
	* @param end the upper bound of the range of bridge progress discrepancies (not inclusive)
	* @return the range of bridge progress discrepancies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the bridge progress discrepancies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressDiscrepancyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge progress discrepancies
	* @param end the upper bound of the range of bridge progress discrepancies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bridge progress discrepancies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the bridge progress discrepancies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of bridge progress discrepancies.
	*
	* @return the number of bridge progress discrepancies
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BridgeProgressDiscrepancyPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BridgeProgressDiscrepancyPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					BridgeProgressDiscrepancyPersistence.class.getName());

			ReferenceRegistry.registerReference(BridgeProgressDiscrepancyUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BridgeProgressDiscrepancyPersistence persistence) {
	}

	private static BridgeProgressDiscrepancyPersistence _persistence;
}