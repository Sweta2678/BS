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

import com.ihg.brandstandards.db.model.ExternalLinkStandards;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the external link standards service. This utility wraps {@link ExternalLinkStandardsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see ExternalLinkStandardsPersistence
 * @see ExternalLinkStandardsPersistenceImpl
 * @generated
 */
public class ExternalLinkStandardsUtil {
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
	public static void clearCache(ExternalLinkStandards externalLinkStandards) {
		getPersistence().clearCache(externalLinkStandards);
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
	public static List<ExternalLinkStandards> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ExternalLinkStandards> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ExternalLinkStandards> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ExternalLinkStandards update(
		ExternalLinkStandards externalLinkStandards) throws SystemException {
		return getPersistence().update(externalLinkStandards);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ExternalLinkStandards update(
		ExternalLinkStandards externalLinkStandards,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(externalLinkStandards, serviceContext);
	}

	/**
	* Returns all the external link standardses where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByStdId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId(stdId);
	}

	/**
	* Returns a range of all the external link standardses where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @return the range of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByStdId(
		long stdId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId(stdId, start, end);
	}

	/**
	* Returns an ordered range of all the external link standardses where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByStdId(
		long stdId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId(stdId, start, end, orderByComparator);
	}

	/**
	* Returns the first external link standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards findByStdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId_First(stdId, orderByComparator);
	}

	/**
	* Returns the first external link standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards, or <code>null</code> if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards fetchByStdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStdId_First(stdId, orderByComparator);
	}

	/**
	* Returns the last external link standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards findByStdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId_Last(stdId, orderByComparator);
	}

	/**
	* Returns the last external link standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards, or <code>null</code> if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards fetchByStdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStdId_Last(stdId, orderByComparator);
	}

	/**
	* Returns the external link standardses before and after the current external link standards in the ordered set where stdId = &#63;.
	*
	* @param extLinkId the primary key of the current external link standards
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a external link standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards[] findByStdId_PrevAndNext(
		long extLinkId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdId_PrevAndNext(extLinkId, stdId, orderByComparator);
	}

	/**
	* Removes all the external link standardses where stdId = &#63; from the database.
	*
	* @param stdId the std ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStdId(stdId);
	}

	/**
	* Returns the number of external link standardses where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the number of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStdId(stdId);
	}

	/**
	* Returns all the external link standardses where parentExtLinkId = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @return the matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByParentExtLinkId(
		long parentExtLinkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParentExtLinkId(parentExtLinkId);
	}

	/**
	* Returns a range of all the external link standardses where parentExtLinkId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentExtLinkId the parent ext link ID
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @return the range of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByParentExtLinkId(
		long parentExtLinkId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentExtLinkId(parentExtLinkId, start, end);
	}

	/**
	* Returns an ordered range of all the external link standardses where parentExtLinkId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentExtLinkId the parent ext link ID
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByParentExtLinkId(
		long parentExtLinkId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentExtLinkId(parentExtLinkId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first external link standards in the ordered set where parentExtLinkId = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards findByParentExtLinkId_First(
		long parentExtLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentExtLinkId_First(parentExtLinkId,
			orderByComparator);
	}

	/**
	* Returns the first external link standards in the ordered set where parentExtLinkId = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards, or <code>null</code> if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards fetchByParentExtLinkId_First(
		long parentExtLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentExtLinkId_First(parentExtLinkId,
			orderByComparator);
	}

	/**
	* Returns the last external link standards in the ordered set where parentExtLinkId = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards findByParentExtLinkId_Last(
		long parentExtLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentExtLinkId_Last(parentExtLinkId,
			orderByComparator);
	}

	/**
	* Returns the last external link standards in the ordered set where parentExtLinkId = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards, or <code>null</code> if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards fetchByParentExtLinkId_Last(
		long parentExtLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentExtLinkId_Last(parentExtLinkId,
			orderByComparator);
	}

	/**
	* Returns the external link standardses before and after the current external link standards in the ordered set where parentExtLinkId = &#63;.
	*
	* @param extLinkId the primary key of the current external link standards
	* @param parentExtLinkId the parent ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a external link standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards[] findByParentExtLinkId_PrevAndNext(
		long extLinkId, long parentExtLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentExtLinkId_PrevAndNext(extLinkId,
			parentExtLinkId, orderByComparator);
	}

	/**
	* Removes all the external link standardses where parentExtLinkId = &#63; from the database.
	*
	* @param parentExtLinkId the parent ext link ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParentExtLinkId(long parentExtLinkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParentExtLinkId(parentExtLinkId);
	}

	/**
	* Returns the number of external link standardses where parentExtLinkId = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @return the number of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParentExtLinkId(long parentExtLinkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByParentExtLinkId(parentExtLinkId);
	}

	/**
	* Returns all the external link standardses where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @return the matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByparentIdStdIdLocaleCd(
		long parentExtLinkId, long stdId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentIdStdIdLocaleCd(parentExtLinkId, stdId,
			localeCode);
	}

	/**
	* Returns a range of all the external link standardses where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @return the range of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByparentIdStdIdLocaleCd(
		long parentExtLinkId, long stdId, java.lang.String localeCode,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentIdStdIdLocaleCd(parentExtLinkId, stdId,
			localeCode, start, end);
	}

	/**
	* Returns an ordered range of all the external link standardses where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByparentIdStdIdLocaleCd(
		long parentExtLinkId, long stdId, java.lang.String localeCode,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentIdStdIdLocaleCd(parentExtLinkId, stdId,
			localeCode, start, end, orderByComparator);
	}

	/**
	* Returns the first external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards findByparentIdStdIdLocaleCd_First(
		long parentExtLinkId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentIdStdIdLocaleCd_First(parentExtLinkId, stdId,
			localeCode, orderByComparator);
	}

	/**
	* Returns the first external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards, or <code>null</code> if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards fetchByparentIdStdIdLocaleCd_First(
		long parentExtLinkId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByparentIdStdIdLocaleCd_First(parentExtLinkId, stdId,
			localeCode, orderByComparator);
	}

	/**
	* Returns the last external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards findByparentIdStdIdLocaleCd_Last(
		long parentExtLinkId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentIdStdIdLocaleCd_Last(parentExtLinkId, stdId,
			localeCode, orderByComparator);
	}

	/**
	* Returns the last external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards, or <code>null</code> if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards fetchByparentIdStdIdLocaleCd_Last(
		long parentExtLinkId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByparentIdStdIdLocaleCd_Last(parentExtLinkId, stdId,
			localeCode, orderByComparator);
	}

	/**
	* Returns the external link standardses before and after the current external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param extLinkId the primary key of the current external link standards
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a external link standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards[] findByparentIdStdIdLocaleCd_PrevAndNext(
		long extLinkId, long parentExtLinkId, long stdId,
		java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentIdStdIdLocaleCd_PrevAndNext(extLinkId,
			parentExtLinkId, stdId, localeCode, orderByComparator);
	}

	/**
	* Removes all the external link standardses where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63; from the database.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByparentIdStdIdLocaleCd(long parentExtLinkId,
		long stdId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByparentIdStdIdLocaleCd(parentExtLinkId, stdId, localeCode);
	}

	/**
	* Returns the number of external link standardses where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @return the number of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByparentIdStdIdLocaleCd(long parentExtLinkId,
		long stdId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByparentIdStdIdLocaleCd(parentExtLinkId, stdId,
			localeCode);
	}

	/**
	* Returns all the external link standardses where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @return the matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByStdIdLocaleCd(
		long stdId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdIdLocaleCd(stdId, localeCode);
	}

	/**
	* Returns a range of all the external link standardses where stdId = &#63; and localeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @return the range of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByStdIdLocaleCd(
		long stdId, java.lang.String localeCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdIdLocaleCd(stdId, localeCode, start, end);
	}

	/**
	* Returns an ordered range of all the external link standardses where stdId = &#63; and localeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByStdIdLocaleCd(
		long stdId, java.lang.String localeCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdIdLocaleCd(stdId, localeCode, start, end,
			orderByComparator);
	}

	/**
	* Returns the first external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards findByStdIdLocaleCd_First(
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdIdLocaleCd_First(stdId, localeCode,
			orderByComparator);
	}

	/**
	* Returns the first external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards, or <code>null</code> if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards fetchByStdIdLocaleCd_First(
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStdIdLocaleCd_First(stdId, localeCode,
			orderByComparator);
	}

	/**
	* Returns the last external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards findByStdIdLocaleCd_Last(
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdIdLocaleCd_Last(stdId, localeCode,
			orderByComparator);
	}

	/**
	* Returns the last external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards, or <code>null</code> if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards fetchByStdIdLocaleCd_Last(
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStdIdLocaleCd_Last(stdId, localeCode,
			orderByComparator);
	}

	/**
	* Returns the external link standardses before and after the current external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param extLinkId the primary key of the current external link standards
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a external link standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards[] findByStdIdLocaleCd_PrevAndNext(
		long extLinkId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdIdLocaleCd_PrevAndNext(extLinkId, stdId,
			localeCode, orderByComparator);
	}

	/**
	* Removes all the external link standardses where stdId = &#63; and localeCode = &#63; from the database.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStdIdLocaleCd(long stdId,
		java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStdIdLocaleCd(stdId, localeCode);
	}

	/**
	* Returns the number of external link standardses where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @return the number of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStdIdLocaleCd(long stdId,
		java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStdIdLocaleCd(stdId, localeCode);
	}

	/**
	* Returns all the external link standardses where parentExtLinkId = &#63; and stdId = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @return the matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByParentIdStdId(
		long parentExtLinkId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParentIdStdId(parentExtLinkId, stdId);
	}

	/**
	* Returns a range of all the external link standardses where parentExtLinkId = &#63; and stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @return the range of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByParentIdStdId(
		long parentExtLinkId, long stdId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentIdStdId(parentExtLinkId, stdId, start, end);
	}

	/**
	* Returns an ordered range of all the external link standardses where parentExtLinkId = &#63; and stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByParentIdStdId(
		long parentExtLinkId, long stdId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentIdStdId(parentExtLinkId, stdId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards findByParentIdStdId_First(
		long parentExtLinkId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentIdStdId_First(parentExtLinkId, stdId,
			orderByComparator);
	}

	/**
	* Returns the first external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards, or <code>null</code> if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards fetchByParentIdStdId_First(
		long parentExtLinkId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentIdStdId_First(parentExtLinkId, stdId,
			orderByComparator);
	}

	/**
	* Returns the last external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards findByParentIdStdId_Last(
		long parentExtLinkId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentIdStdId_Last(parentExtLinkId, stdId,
			orderByComparator);
	}

	/**
	* Returns the last external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards, or <code>null</code> if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards fetchByParentIdStdId_Last(
		long parentExtLinkId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentIdStdId_Last(parentExtLinkId, stdId,
			orderByComparator);
	}

	/**
	* Returns the external link standardses before and after the current external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63;.
	*
	* @param extLinkId the primary key of the current external link standards
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a external link standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards[] findByParentIdStdId_PrevAndNext(
		long extLinkId, long parentExtLinkId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentIdStdId_PrevAndNext(extLinkId, parentExtLinkId,
			stdId, orderByComparator);
	}

	/**
	* Removes all the external link standardses where parentExtLinkId = &#63; and stdId = &#63; from the database.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParentIdStdId(long parentExtLinkId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParentIdStdId(parentExtLinkId, stdId);
	}

	/**
	* Returns the number of external link standardses where parentExtLinkId = &#63; and stdId = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @return the number of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParentIdStdId(long parentExtLinkId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByParentIdStdId(parentExtLinkId, stdId);
	}

	/**
	* Returns all the external link standardses where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findBystdParents(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystdParents(stdId);
	}

	/**
	* Returns a range of all the external link standardses where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @return the range of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findBystdParents(
		long stdId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystdParents(stdId, start, end);
	}

	/**
	* Returns an ordered range of all the external link standardses where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findBystdParents(
		long stdId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBystdParents(stdId, start, end, orderByComparator);
	}

	/**
	* Returns the first external link standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards findBystdParents_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystdParents_First(stdId, orderByComparator);
	}

	/**
	* Returns the first external link standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards, or <code>null</code> if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards fetchBystdParents_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBystdParents_First(stdId, orderByComparator);
	}

	/**
	* Returns the last external link standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards findBystdParents_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystdParents_Last(stdId, orderByComparator);
	}

	/**
	* Returns the last external link standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards, or <code>null</code> if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards fetchBystdParents_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBystdParents_Last(stdId, orderByComparator);
	}

	/**
	* Returns the external link standardses before and after the current external link standards in the ordered set where stdId = &#63;.
	*
	* @param extLinkId the primary key of the current external link standards
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a external link standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards[] findBystdParents_PrevAndNext(
		long extLinkId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBystdParents_PrevAndNext(extLinkId, stdId,
			orderByComparator);
	}

	/**
	* Removes all the external link standardses where stdId = &#63; from the database.
	*
	* @param stdId the std ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBystdParents(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBystdParents(stdId);
	}

	/**
	* Returns the number of external link standardses where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the number of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBystdParents(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBystdParents(stdId);
	}

	/**
	* Returns all the external link standardses where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @return the matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findBystdParentsLocaleCode(
		long stdId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystdParentsLocaleCode(stdId, localeCode);
	}

	/**
	* Returns a range of all the external link standardses where stdId = &#63; and localeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @return the range of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findBystdParentsLocaleCode(
		long stdId, java.lang.String localeCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBystdParentsLocaleCode(stdId, localeCode, start, end);
	}

	/**
	* Returns an ordered range of all the external link standardses where stdId = &#63; and localeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findBystdParentsLocaleCode(
		long stdId, java.lang.String localeCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBystdParentsLocaleCode(stdId, localeCode, start, end,
			orderByComparator);
	}

	/**
	* Returns the first external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards findBystdParentsLocaleCode_First(
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBystdParentsLocaleCode_First(stdId, localeCode,
			orderByComparator);
	}

	/**
	* Returns the first external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards, or <code>null</code> if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards fetchBystdParentsLocaleCode_First(
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBystdParentsLocaleCode_First(stdId, localeCode,
			orderByComparator);
	}

	/**
	* Returns the last external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards findBystdParentsLocaleCode_Last(
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBystdParentsLocaleCode_Last(stdId, localeCode,
			orderByComparator);
	}

	/**
	* Returns the last external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards, or <code>null</code> if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards fetchBystdParentsLocaleCode_Last(
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBystdParentsLocaleCode_Last(stdId, localeCode,
			orderByComparator);
	}

	/**
	* Returns the external link standardses before and after the current external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param extLinkId the primary key of the current external link standards
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a external link standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards[] findBystdParentsLocaleCode_PrevAndNext(
		long extLinkId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBystdParentsLocaleCode_PrevAndNext(extLinkId, stdId,
			localeCode, orderByComparator);
	}

	/**
	* Removes all the external link standardses where stdId = &#63; and localeCode = &#63; from the database.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBystdParentsLocaleCode(long stdId,
		java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBystdParentsLocaleCode(stdId, localeCode);
	}

	/**
	* Returns the number of external link standardses where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @return the number of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBystdParentsLocaleCode(long stdId,
		java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBystdParentsLocaleCode(stdId, localeCode);
	}

	/**
	* Caches the external link standards in the entity cache if it is enabled.
	*
	* @param externalLinkStandards the external link standards
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.ExternalLinkStandards externalLinkStandards) {
		getPersistence().cacheResult(externalLinkStandards);
	}

	/**
	* Caches the external link standardses in the entity cache if it is enabled.
	*
	* @param externalLinkStandardses the external link standardses
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> externalLinkStandardses) {
		getPersistence().cacheResult(externalLinkStandardses);
	}

	/**
	* Creates a new external link standards with the primary key. Does not add the external link standards to the database.
	*
	* @param extLinkId the primary key for the new external link standards
	* @return the new external link standards
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards create(
		long extLinkId) {
		return getPersistence().create(extLinkId);
	}

	/**
	* Removes the external link standards with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param extLinkId the primary key of the external link standards
	* @return the external link standards that was removed
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a external link standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards remove(
		long extLinkId)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(extLinkId);
	}

	public static com.ihg.brandstandards.db.model.ExternalLinkStandards updateImpl(
		com.ihg.brandstandards.db.model.ExternalLinkStandards externalLinkStandards)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(externalLinkStandards);
	}

	/**
	* Returns the external link standards with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException} if it could not be found.
	*
	* @param extLinkId the primary key of the external link standards
	* @return the external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a external link standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards findByPrimaryKey(
		long extLinkId)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(extLinkId);
	}

	/**
	* Returns the external link standards with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param extLinkId the primary key of the external link standards
	* @return the external link standards, or <code>null</code> if a external link standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandards fetchByPrimaryKey(
		long extLinkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(extLinkId);
	}

	/**
	* Returns all the external link standardses.
	*
	* @return the external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the external link standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @return the range of external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the external link standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the external link standardses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of external link standardses.
	*
	* @return the number of external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ExternalLinkStandardsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ExternalLinkStandardsPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					ExternalLinkStandardsPersistence.class.getName());

			ReferenceRegistry.registerReference(ExternalLinkStandardsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ExternalLinkStandardsPersistence persistence) {
	}

	private static ExternalLinkStandardsPersistence _persistence;
}