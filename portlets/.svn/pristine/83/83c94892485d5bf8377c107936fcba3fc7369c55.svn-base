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

import com.ihg.brandstandards.db.model.FlagStandards;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the flag standards service. This utility wraps {@link FlagStandardsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see FlagStandardsPersistence
 * @see FlagStandardsPersistenceImpl
 * @generated
 */
public class FlagStandardsUtil {
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
	public static void clearCache(FlagStandards flagStandards) {
		getPersistence().clearCache(flagStandards);
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
	public static List<FlagStandards> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FlagStandards> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FlagStandards> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static FlagStandards update(FlagStandards flagStandards)
		throws SystemException {
		return getPersistence().update(flagStandards);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static FlagStandards update(FlagStandards flagStandards,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(flagStandards, serviceContext);
	}

	/**
	* Returns all the flag standardses where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the matching flag standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.FlagStandards> findByStdId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId(stdId);
	}

	/**
	* Returns a range of all the flag standardses where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of flag standardses
	* @param end the upper bound of the range of flag standardses (not inclusive)
	* @return the range of matching flag standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.FlagStandards> findByStdId(
		long stdId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId(stdId, start, end);
	}

	/**
	* Returns an ordered range of all the flag standardses where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of flag standardses
	* @param end the upper bound of the range of flag standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching flag standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.FlagStandards> findByStdId(
		long stdId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId(stdId, start, end, orderByComparator);
	}

	/**
	* Returns the first flag standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flag standards
	* @throws com.ihg.brandstandards.db.NoSuchFlagStandardsException if a matching flag standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagStandards findByStdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchFlagStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId_First(stdId, orderByComparator);
	}

	/**
	* Returns the first flag standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flag standards, or <code>null</code> if a matching flag standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagStandards fetchByStdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStdId_First(stdId, orderByComparator);
	}

	/**
	* Returns the last flag standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flag standards
	* @throws com.ihg.brandstandards.db.NoSuchFlagStandardsException if a matching flag standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagStandards findByStdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchFlagStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId_Last(stdId, orderByComparator);
	}

	/**
	* Returns the last flag standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flag standards, or <code>null</code> if a matching flag standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagStandards fetchByStdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStdId_Last(stdId, orderByComparator);
	}

	/**
	* Returns the flag standardses before and after the current flag standards in the ordered set where stdId = &#63;.
	*
	* @param flagStandardsPK the primary key of the current flag standards
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next flag standards
	* @throws com.ihg.brandstandards.db.NoSuchFlagStandardsException if a flag standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagStandards[] findByStdId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.FlagStandardsPK flagStandardsPK,
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchFlagStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdId_PrevAndNext(flagStandardsPK, stdId,
			orderByComparator);
	}

	/**
	* Removes all the flag standardses where stdId = &#63; from the database.
	*
	* @param stdId the std ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStdId(stdId);
	}

	/**
	* Returns the number of flag standardses where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the number of matching flag standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStdId(stdId);
	}

	/**
	* Returns the flag standards where flagCatId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchFlagStandardsException} if it could not be found.
	*
	* @param flagCatId the flag cat ID
	* @return the matching flag standards
	* @throws com.ihg.brandstandards.db.NoSuchFlagStandardsException if a matching flag standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagStandards findByFlagCatId(
		long flagCatId)
		throws com.ihg.brandstandards.db.NoSuchFlagStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFlagCatId(flagCatId);
	}

	/**
	* Returns the flag standards where flagCatId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param flagCatId the flag cat ID
	* @return the matching flag standards, or <code>null</code> if a matching flag standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagStandards fetchByFlagCatId(
		long flagCatId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFlagCatId(flagCatId);
	}

	/**
	* Returns the flag standards where flagCatId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param flagCatId the flag cat ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching flag standards, or <code>null</code> if a matching flag standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagStandards fetchByFlagCatId(
		long flagCatId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByFlagCatId(flagCatId, retrieveFromCache);
	}

	/**
	* Removes the flag standards where flagCatId = &#63; from the database.
	*
	* @param flagCatId the flag cat ID
	* @return the flag standards that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagStandards removeByFlagCatId(
		long flagCatId)
		throws com.ihg.brandstandards.db.NoSuchFlagStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByFlagCatId(flagCatId);
	}

	/**
	* Returns the number of flag standardses where flagCatId = &#63;.
	*
	* @param flagCatId the flag cat ID
	* @return the number of matching flag standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFlagCatId(long flagCatId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFlagCatId(flagCatId);
	}

	/**
	* Returns the flag standards where stdId = &#63; and flagCatId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchFlagStandardsException} if it could not be found.
	*
	* @param stdId the std ID
	* @param flagCatId the flag cat ID
	* @return the matching flag standards
	* @throws com.ihg.brandstandards.db.NoSuchFlagStandardsException if a matching flag standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagStandards findByStandardAndCategoryId(
		long stdId, long flagCatId)
		throws com.ihg.brandstandards.db.NoSuchFlagStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStandardAndCategoryId(stdId, flagCatId);
	}

	/**
	* Returns the flag standards where stdId = &#63; and flagCatId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param stdId the std ID
	* @param flagCatId the flag cat ID
	* @return the matching flag standards, or <code>null</code> if a matching flag standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagStandards fetchByStandardAndCategoryId(
		long stdId, long flagCatId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStandardAndCategoryId(stdId, flagCatId);
	}

	/**
	* Returns the flag standards where stdId = &#63; and flagCatId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param stdId the std ID
	* @param flagCatId the flag cat ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching flag standards, or <code>null</code> if a matching flag standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagStandards fetchByStandardAndCategoryId(
		long stdId, long flagCatId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStandardAndCategoryId(stdId, flagCatId,
			retrieveFromCache);
	}

	/**
	* Removes the flag standards where stdId = &#63; and flagCatId = &#63; from the database.
	*
	* @param stdId the std ID
	* @param flagCatId the flag cat ID
	* @return the flag standards that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagStandards removeByStandardAndCategoryId(
		long stdId, long flagCatId)
		throws com.ihg.brandstandards.db.NoSuchFlagStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByStandardAndCategoryId(stdId, flagCatId);
	}

	/**
	* Returns the number of flag standardses where stdId = &#63; and flagCatId = &#63;.
	*
	* @param stdId the std ID
	* @param flagCatId the flag cat ID
	* @return the number of matching flag standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStandardAndCategoryId(long stdId, long flagCatId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStandardAndCategoryId(stdId, flagCatId);
	}

	/**
	* Caches the flag standards in the entity cache if it is enabled.
	*
	* @param flagStandards the flag standards
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.FlagStandards flagStandards) {
		getPersistence().cacheResult(flagStandards);
	}

	/**
	* Caches the flag standardses in the entity cache if it is enabled.
	*
	* @param flagStandardses the flag standardses
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.FlagStandards> flagStandardses) {
		getPersistence().cacheResult(flagStandardses);
	}

	/**
	* Creates a new flag standards with the primary key. Does not add the flag standards to the database.
	*
	* @param flagStandardsPK the primary key for the new flag standards
	* @return the new flag standards
	*/
	public static com.ihg.brandstandards.db.model.FlagStandards create(
		com.ihg.brandstandards.db.service.persistence.FlagStandardsPK flagStandardsPK) {
		return getPersistence().create(flagStandardsPK);
	}

	/**
	* Removes the flag standards with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param flagStandardsPK the primary key of the flag standards
	* @return the flag standards that was removed
	* @throws com.ihg.brandstandards.db.NoSuchFlagStandardsException if a flag standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagStandards remove(
		com.ihg.brandstandards.db.service.persistence.FlagStandardsPK flagStandardsPK)
		throws com.ihg.brandstandards.db.NoSuchFlagStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(flagStandardsPK);
	}

	public static com.ihg.brandstandards.db.model.FlagStandards updateImpl(
		com.ihg.brandstandards.db.model.FlagStandards flagStandards)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(flagStandards);
	}

	/**
	* Returns the flag standards with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchFlagStandardsException} if it could not be found.
	*
	* @param flagStandardsPK the primary key of the flag standards
	* @return the flag standards
	* @throws com.ihg.brandstandards.db.NoSuchFlagStandardsException if a flag standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagStandards findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.FlagStandardsPK flagStandardsPK)
		throws com.ihg.brandstandards.db.NoSuchFlagStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(flagStandardsPK);
	}

	/**
	* Returns the flag standards with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param flagStandardsPK the primary key of the flag standards
	* @return the flag standards, or <code>null</code> if a flag standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagStandards fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.FlagStandardsPK flagStandardsPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(flagStandardsPK);
	}

	/**
	* Returns all the flag standardses.
	*
	* @return the flag standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.FlagStandards> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the flag standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flag standardses
	* @param end the upper bound of the range of flag standardses (not inclusive)
	* @return the range of flag standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.FlagStandards> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the flag standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flag standardses
	* @param end the upper bound of the range of flag standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of flag standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.FlagStandards> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the flag standardses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of flag standardses.
	*
	* @return the number of flag standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FlagStandardsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FlagStandardsPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					FlagStandardsPersistence.class.getName());

			ReferenceRegistry.registerReference(FlagStandardsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(FlagStandardsPersistence persistence) {
	}

	private static FlagStandardsPersistence _persistence;
}