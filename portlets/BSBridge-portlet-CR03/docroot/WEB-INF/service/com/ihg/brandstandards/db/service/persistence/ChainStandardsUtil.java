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

import com.ihg.brandstandards.db.model.ChainStandards;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the chain standards service. This utility wraps {@link ChainStandardsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see ChainStandardsPersistence
 * @see ChainStandardsPersistenceImpl
 * @generated
 */
public class ChainStandardsUtil {
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
	public static void clearCache(ChainStandards chainStandards) {
		getPersistence().clearCache(chainStandards);
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
	public static List<ChainStandards> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ChainStandards> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ChainStandards> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ChainStandards update(ChainStandards chainStandards)
		throws SystemException {
		return getPersistence().update(chainStandards);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ChainStandards update(ChainStandards chainStandards,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(chainStandards, serviceContext);
	}

	/**
	* Returns all the chain standardses where stdId = &#63; and isActive = &#63;.
	*
	* @param stdId the std ID
	* @param isActive the is active
	* @return the matching chain standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ChainStandards> findByStdId(
		long stdId, java.lang.String isActive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId(stdId, isActive);
	}

	/**
	* Returns a range of all the chain standardses where stdId = &#63; and isActive = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param isActive the is active
	* @param start the lower bound of the range of chain standardses
	* @param end the upper bound of the range of chain standardses (not inclusive)
	* @return the range of matching chain standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ChainStandards> findByStdId(
		long stdId, java.lang.String isActive, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId(stdId, isActive, start, end);
	}

	/**
	* Returns an ordered range of all the chain standardses where stdId = &#63; and isActive = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param isActive the is active
	* @param start the lower bound of the range of chain standardses
	* @param end the upper bound of the range of chain standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching chain standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ChainStandards> findByStdId(
		long stdId, java.lang.String isActive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdId(stdId, isActive, start, end, orderByComparator);
	}

	/**
	* Returns the first chain standards in the ordered set where stdId = &#63; and isActive = &#63;.
	*
	* @param stdId the std ID
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching chain standards
	* @throws com.ihg.brandstandards.db.NoSuchChainStandardsException if a matching chain standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainStandards findByStdId_First(
		long stdId, java.lang.String isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchChainStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdId_First(stdId, isActive, orderByComparator);
	}

	/**
	* Returns the first chain standards in the ordered set where stdId = &#63; and isActive = &#63;.
	*
	* @param stdId the std ID
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching chain standards, or <code>null</code> if a matching chain standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainStandards fetchByStdId_First(
		long stdId, java.lang.String isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStdId_First(stdId, isActive, orderByComparator);
	}

	/**
	* Returns the last chain standards in the ordered set where stdId = &#63; and isActive = &#63;.
	*
	* @param stdId the std ID
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching chain standards
	* @throws com.ihg.brandstandards.db.NoSuchChainStandardsException if a matching chain standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainStandards findByStdId_Last(
		long stdId, java.lang.String isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchChainStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdId_Last(stdId, isActive, orderByComparator);
	}

	/**
	* Returns the last chain standards in the ordered set where stdId = &#63; and isActive = &#63;.
	*
	* @param stdId the std ID
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching chain standards, or <code>null</code> if a matching chain standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainStandards fetchByStdId_Last(
		long stdId, java.lang.String isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStdId_Last(stdId, isActive, orderByComparator);
	}

	/**
	* Returns the chain standardses before and after the current chain standards in the ordered set where stdId = &#63; and isActive = &#63;.
	*
	* @param chainStandardsPK the primary key of the current chain standards
	* @param stdId the std ID
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next chain standards
	* @throws com.ihg.brandstandards.db.NoSuchChainStandardsException if a chain standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainStandards[] findByStdId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.ChainStandardsPK chainStandardsPK,
		long stdId, java.lang.String isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchChainStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdId_PrevAndNext(chainStandardsPK, stdId, isActive,
			orderByComparator);
	}

	/**
	* Removes all the chain standardses where stdId = &#63; and isActive = &#63; from the database.
	*
	* @param stdId the std ID
	* @param isActive the is active
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStdId(long stdId, java.lang.String isActive)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStdId(stdId, isActive);
	}

	/**
	* Returns the number of chain standardses where stdId = &#63; and isActive = &#63;.
	*
	* @param stdId the std ID
	* @param isActive the is active
	* @return the number of matching chain standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStdId(long stdId, java.lang.String isActive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStdId(stdId, isActive);
	}

	/**
	* Returns the chain standards where stdId = &#63; and chainCode = &#63; and isActive = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchChainStandardsException} if it could not be found.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param isActive the is active
	* @return the matching chain standards
	* @throws com.ihg.brandstandards.db.NoSuchChainStandardsException if a matching chain standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainStandards findByChainCode(
		long stdId, java.lang.String chainCode, java.lang.String isActive)
		throws com.ihg.brandstandards.db.NoSuchChainStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByChainCode(stdId, chainCode, isActive);
	}

	/**
	* Returns the chain standards where stdId = &#63; and chainCode = &#63; and isActive = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param isActive the is active
	* @return the matching chain standards, or <code>null</code> if a matching chain standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainStandards fetchByChainCode(
		long stdId, java.lang.String chainCode, java.lang.String isActive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByChainCode(stdId, chainCode, isActive);
	}

	/**
	* Returns the chain standards where stdId = &#63; and chainCode = &#63; and isActive = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param isActive the is active
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching chain standards, or <code>null</code> if a matching chain standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainStandards fetchByChainCode(
		long stdId, java.lang.String chainCode, java.lang.String isActive,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByChainCode(stdId, chainCode, isActive,
			retrieveFromCache);
	}

	/**
	* Removes the chain standards where stdId = &#63; and chainCode = &#63; and isActive = &#63; from the database.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param isActive the is active
	* @return the chain standards that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainStandards removeByChainCode(
		long stdId, java.lang.String chainCode, java.lang.String isActive)
		throws com.ihg.brandstandards.db.NoSuchChainStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByChainCode(stdId, chainCode, isActive);
	}

	/**
	* Returns the number of chain standardses where stdId = &#63; and chainCode = &#63; and isActive = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param isActive the is active
	* @return the number of matching chain standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByChainCode(long stdId, java.lang.String chainCode,
		java.lang.String isActive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByChainCode(stdId, chainCode, isActive);
	}

	/**
	* Returns the chain standards where stdId = &#63; and chainCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchChainStandardsException} if it could not be found.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @return the matching chain standards
	* @throws com.ihg.brandstandards.db.NoSuchChainStandardsException if a matching chain standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainStandards findByChainCodeAll(
		long stdId, java.lang.String chainCode)
		throws com.ihg.brandstandards.db.NoSuchChainStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByChainCodeAll(stdId, chainCode);
	}

	/**
	* Returns the chain standards where stdId = &#63; and chainCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @return the matching chain standards, or <code>null</code> if a matching chain standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainStandards fetchByChainCodeAll(
		long stdId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByChainCodeAll(stdId, chainCode);
	}

	/**
	* Returns the chain standards where stdId = &#63; and chainCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching chain standards, or <code>null</code> if a matching chain standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainStandards fetchByChainCodeAll(
		long stdId, java.lang.String chainCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByChainCodeAll(stdId, chainCode, retrieveFromCache);
	}

	/**
	* Removes the chain standards where stdId = &#63; and chainCode = &#63; from the database.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @return the chain standards that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainStandards removeByChainCodeAll(
		long stdId, java.lang.String chainCode)
		throws com.ihg.brandstandards.db.NoSuchChainStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByChainCodeAll(stdId, chainCode);
	}

	/**
	* Returns the number of chain standardses where stdId = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param chainCode the chain code
	* @return the number of matching chain standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByChainCodeAll(long stdId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByChainCodeAll(stdId, chainCode);
	}

	/**
	* Returns all the chain standardses where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the matching chain standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ChainStandards> findByStdIdAll(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdIdAll(stdId);
	}

	/**
	* Returns a range of all the chain standardses where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of chain standardses
	* @param end the upper bound of the range of chain standardses (not inclusive)
	* @return the range of matching chain standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ChainStandards> findByStdIdAll(
		long stdId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdIdAll(stdId, start, end);
	}

	/**
	* Returns an ordered range of all the chain standardses where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of chain standardses
	* @param end the upper bound of the range of chain standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching chain standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ChainStandards> findByStdIdAll(
		long stdId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdIdAll(stdId, start, end, orderByComparator);
	}

	/**
	* Returns the first chain standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching chain standards
	* @throws com.ihg.brandstandards.db.NoSuchChainStandardsException if a matching chain standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainStandards findByStdIdAll_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchChainStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdIdAll_First(stdId, orderByComparator);
	}

	/**
	* Returns the first chain standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching chain standards, or <code>null</code> if a matching chain standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainStandards fetchByStdIdAll_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStdIdAll_First(stdId, orderByComparator);
	}

	/**
	* Returns the last chain standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching chain standards
	* @throws com.ihg.brandstandards.db.NoSuchChainStandardsException if a matching chain standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainStandards findByStdIdAll_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchChainStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdIdAll_Last(stdId, orderByComparator);
	}

	/**
	* Returns the last chain standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching chain standards, or <code>null</code> if a matching chain standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainStandards fetchByStdIdAll_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStdIdAll_Last(stdId, orderByComparator);
	}

	/**
	* Returns the chain standardses before and after the current chain standards in the ordered set where stdId = &#63;.
	*
	* @param chainStandardsPK the primary key of the current chain standards
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next chain standards
	* @throws com.ihg.brandstandards.db.NoSuchChainStandardsException if a chain standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainStandards[] findByStdIdAll_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.ChainStandardsPK chainStandardsPK,
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchChainStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdIdAll_PrevAndNext(chainStandardsPK, stdId,
			orderByComparator);
	}

	/**
	* Removes all the chain standardses where stdId = &#63; from the database.
	*
	* @param stdId the std ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStdIdAll(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStdIdAll(stdId);
	}

	/**
	* Returns the number of chain standardses where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the number of matching chain standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStdIdAll(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStdIdAll(stdId);
	}

	/**
	* Caches the chain standards in the entity cache if it is enabled.
	*
	* @param chainStandards the chain standards
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.ChainStandards chainStandards) {
		getPersistence().cacheResult(chainStandards);
	}

	/**
	* Caches the chain standardses in the entity cache if it is enabled.
	*
	* @param chainStandardses the chain standardses
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.ChainStandards> chainStandardses) {
		getPersistence().cacheResult(chainStandardses);
	}

	/**
	* Creates a new chain standards with the primary key. Does not add the chain standards to the database.
	*
	* @param chainStandardsPK the primary key for the new chain standards
	* @return the new chain standards
	*/
	public static com.ihg.brandstandards.db.model.ChainStandards create(
		com.ihg.brandstandards.db.service.persistence.ChainStandardsPK chainStandardsPK) {
		return getPersistence().create(chainStandardsPK);
	}

	/**
	* Removes the chain standards with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param chainStandardsPK the primary key of the chain standards
	* @return the chain standards that was removed
	* @throws com.ihg.brandstandards.db.NoSuchChainStandardsException if a chain standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainStandards remove(
		com.ihg.brandstandards.db.service.persistence.ChainStandardsPK chainStandardsPK)
		throws com.ihg.brandstandards.db.NoSuchChainStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(chainStandardsPK);
	}

	public static com.ihg.brandstandards.db.model.ChainStandards updateImpl(
		com.ihg.brandstandards.db.model.ChainStandards chainStandards)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(chainStandards);
	}

	/**
	* Returns the chain standards with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchChainStandardsException} if it could not be found.
	*
	* @param chainStandardsPK the primary key of the chain standards
	* @return the chain standards
	* @throws com.ihg.brandstandards.db.NoSuchChainStandardsException if a chain standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainStandards findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.ChainStandardsPK chainStandardsPK)
		throws com.ihg.brandstandards.db.NoSuchChainStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(chainStandardsPK);
	}

	/**
	* Returns the chain standards with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param chainStandardsPK the primary key of the chain standards
	* @return the chain standards, or <code>null</code> if a chain standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainStandards fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.ChainStandardsPK chainStandardsPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(chainStandardsPK);
	}

	/**
	* Returns all the chain standardses.
	*
	* @return the chain standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ChainStandards> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the chain standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of chain standardses
	* @param end the upper bound of the range of chain standardses (not inclusive)
	* @return the range of chain standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ChainStandards> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the chain standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of chain standardses
	* @param end the upper bound of the range of chain standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of chain standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ChainStandards> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the chain standardses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of chain standardses.
	*
	* @return the number of chain standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ChainStandardsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ChainStandardsPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					ChainStandardsPersistence.class.getName());

			ReferenceRegistry.registerReference(ChainStandardsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ChainStandardsPersistence persistence) {
	}

	private static ChainStandardsPersistence _persistence;
}