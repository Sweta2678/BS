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

import com.ihg.brandstandards.db.model.GlossaryRegionNav;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the glossary region nav service. This utility wraps {@link GlossaryRegionNavPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GlossaryRegionNavPersistence
 * @see GlossaryRegionNavPersistenceImpl
 * @generated
 */
public class GlossaryRegionNavUtil {
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
	public static void clearCache(GlossaryRegionNav glossaryRegionNav) {
		getPersistence().clearCache(glossaryRegionNav);
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
	public static List<GlossaryRegionNav> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GlossaryRegionNav> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GlossaryRegionNav> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GlossaryRegionNav update(GlossaryRegionNav glossaryRegionNav)
		throws SystemException {
		return getPersistence().update(glossaryRegionNav);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GlossaryRegionNav update(
		GlossaryRegionNav glossaryRegionNav, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(glossaryRegionNav, serviceContext);
	}

	/**
	* Returns all the glossary region navs where glossaryId = &#63; and regionId = &#63;.
	*
	* @param glossaryId the glossary ID
	* @param regionId the region ID
	* @return the matching glossary region navs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryRegionNav> findByglossaryIdAndRegionId(
		long glossaryId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByglossaryIdAndRegionId(glossaryId, regionId);
	}

	/**
	* Returns a range of all the glossary region navs where glossaryId = &#63; and regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryRegionNavModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param glossaryId the glossary ID
	* @param regionId the region ID
	* @param start the lower bound of the range of glossary region navs
	* @param end the upper bound of the range of glossary region navs (not inclusive)
	* @return the range of matching glossary region navs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryRegionNav> findByglossaryIdAndRegionId(
		long glossaryId, long regionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByglossaryIdAndRegionId(glossaryId, regionId, start, end);
	}

	/**
	* Returns an ordered range of all the glossary region navs where glossaryId = &#63; and regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryRegionNavModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param glossaryId the glossary ID
	* @param regionId the region ID
	* @param start the lower bound of the range of glossary region navs
	* @param end the upper bound of the range of glossary region navs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching glossary region navs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryRegionNav> findByglossaryIdAndRegionId(
		long glossaryId, long regionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByglossaryIdAndRegionId(glossaryId, regionId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first glossary region nav in the ordered set where glossaryId = &#63; and regionId = &#63;.
	*
	* @param glossaryId the glossary ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching glossary region nav
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a matching glossary region nav could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav findByglossaryIdAndRegionId_First(
		long glossaryId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByglossaryIdAndRegionId_First(glossaryId, regionId,
			orderByComparator);
	}

	/**
	* Returns the first glossary region nav in the ordered set where glossaryId = &#63; and regionId = &#63;.
	*
	* @param glossaryId the glossary ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching glossary region nav, or <code>null</code> if a matching glossary region nav could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav fetchByglossaryIdAndRegionId_First(
		long glossaryId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByglossaryIdAndRegionId_First(glossaryId, regionId,
			orderByComparator);
	}

	/**
	* Returns the last glossary region nav in the ordered set where glossaryId = &#63; and regionId = &#63;.
	*
	* @param glossaryId the glossary ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching glossary region nav
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a matching glossary region nav could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav findByglossaryIdAndRegionId_Last(
		long glossaryId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByglossaryIdAndRegionId_Last(glossaryId, regionId,
			orderByComparator);
	}

	/**
	* Returns the last glossary region nav in the ordered set where glossaryId = &#63; and regionId = &#63;.
	*
	* @param glossaryId the glossary ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching glossary region nav, or <code>null</code> if a matching glossary region nav could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav fetchByglossaryIdAndRegionId_Last(
		long glossaryId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByglossaryIdAndRegionId_Last(glossaryId, regionId,
			orderByComparator);
	}

	/**
	* Returns the glossary region navs before and after the current glossary region nav in the ordered set where glossaryId = &#63; and regionId = &#63;.
	*
	* @param glossaryRgnNavId the primary key of the current glossary region nav
	* @param glossaryId the glossary ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next glossary region nav
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a glossary region nav with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav[] findByglossaryIdAndRegionId_PrevAndNext(
		long glossaryRgnNavId, long glossaryId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByglossaryIdAndRegionId_PrevAndNext(glossaryRgnNavId,
			glossaryId, regionId, orderByComparator);
	}

	/**
	* Removes all the glossary region navs where glossaryId = &#63; and regionId = &#63; from the database.
	*
	* @param glossaryId the glossary ID
	* @param regionId the region ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByglossaryIdAndRegionId(long glossaryId,
		long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByglossaryIdAndRegionId(glossaryId, regionId);
	}

	/**
	* Returns the number of glossary region navs where glossaryId = &#63; and regionId = &#63;.
	*
	* @param glossaryId the glossary ID
	* @param regionId the region ID
	* @return the number of matching glossary region navs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByglossaryIdAndRegionId(long glossaryId,
		long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByglossaryIdAndRegionId(glossaryId, regionId);
	}

	/**
	* Returns the glossary region nav where glossaryId = &#63; and regionId = &#63; and chainCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException} if it could not be found.
	*
	* @param glossaryId the glossary ID
	* @param regionId the region ID
	* @param chainCode the chain code
	* @return the matching glossary region nav
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a matching glossary region nav could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav findByglossaryIdRegionIdChainCode(
		long glossaryId, long regionId, java.lang.String chainCode)
		throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByglossaryIdRegionIdChainCode(glossaryId, regionId,
			chainCode);
	}

	/**
	* Returns the glossary region nav where glossaryId = &#63; and regionId = &#63; and chainCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param glossaryId the glossary ID
	* @param regionId the region ID
	* @param chainCode the chain code
	* @return the matching glossary region nav, or <code>null</code> if a matching glossary region nav could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav fetchByglossaryIdRegionIdChainCode(
		long glossaryId, long regionId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByglossaryIdRegionIdChainCode(glossaryId, regionId,
			chainCode);
	}

	/**
	* Returns the glossary region nav where glossaryId = &#63; and regionId = &#63; and chainCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param glossaryId the glossary ID
	* @param regionId the region ID
	* @param chainCode the chain code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching glossary region nav, or <code>null</code> if a matching glossary region nav could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav fetchByglossaryIdRegionIdChainCode(
		long glossaryId, long regionId, java.lang.String chainCode,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByglossaryIdRegionIdChainCode(glossaryId, regionId,
			chainCode, retrieveFromCache);
	}

	/**
	* Removes the glossary region nav where glossaryId = &#63; and regionId = &#63; and chainCode = &#63; from the database.
	*
	* @param glossaryId the glossary ID
	* @param regionId the region ID
	* @param chainCode the chain code
	* @return the glossary region nav that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav removeByglossaryIdRegionIdChainCode(
		long glossaryId, long regionId, java.lang.String chainCode)
		throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByglossaryIdRegionIdChainCode(glossaryId, regionId,
			chainCode);
	}

	/**
	* Returns the number of glossary region navs where glossaryId = &#63; and regionId = &#63; and chainCode = &#63;.
	*
	* @param glossaryId the glossary ID
	* @param regionId the region ID
	* @param chainCode the chain code
	* @return the number of matching glossary region navs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByglossaryIdRegionIdChainCode(long glossaryId,
		long regionId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByglossaryIdRegionIdChainCode(glossaryId, regionId,
			chainCode);
	}

	/**
	* Returns all the glossary region navs where regionId = &#63; and chainCode = &#63; and activeInd = &#63; and navItemText = &#63;.
	*
	* @param regionId the region ID
	* @param chainCode the chain code
	* @param activeInd the active ind
	* @param navItemText the nav item text
	* @return the matching glossary region navs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryRegionNav> findByglossaryRegionId(
		long regionId, java.lang.String chainCode, java.lang.String activeInd,
		java.lang.String navItemText)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByglossaryRegionId(regionId, chainCode, activeInd,
			navItemText);
	}

	/**
	* Returns a range of all the glossary region navs where regionId = &#63; and chainCode = &#63; and activeInd = &#63; and navItemText = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryRegionNavModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param regionId the region ID
	* @param chainCode the chain code
	* @param activeInd the active ind
	* @param navItemText the nav item text
	* @param start the lower bound of the range of glossary region navs
	* @param end the upper bound of the range of glossary region navs (not inclusive)
	* @return the range of matching glossary region navs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryRegionNav> findByglossaryRegionId(
		long regionId, java.lang.String chainCode, java.lang.String activeInd,
		java.lang.String navItemText, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByglossaryRegionId(regionId, chainCode, activeInd,
			navItemText, start, end);
	}

	/**
	* Returns an ordered range of all the glossary region navs where regionId = &#63; and chainCode = &#63; and activeInd = &#63; and navItemText = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryRegionNavModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param regionId the region ID
	* @param chainCode the chain code
	* @param activeInd the active ind
	* @param navItemText the nav item text
	* @param start the lower bound of the range of glossary region navs
	* @param end the upper bound of the range of glossary region navs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching glossary region navs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryRegionNav> findByglossaryRegionId(
		long regionId, java.lang.String chainCode, java.lang.String activeInd,
		java.lang.String navItemText, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByglossaryRegionId(regionId, chainCode, activeInd,
			navItemText, start, end, orderByComparator);
	}

	/**
	* Returns the first glossary region nav in the ordered set where regionId = &#63; and chainCode = &#63; and activeInd = &#63; and navItemText = &#63;.
	*
	* @param regionId the region ID
	* @param chainCode the chain code
	* @param activeInd the active ind
	* @param navItemText the nav item text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching glossary region nav
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a matching glossary region nav could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav findByglossaryRegionId_First(
		long regionId, java.lang.String chainCode, java.lang.String activeInd,
		java.lang.String navItemText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByglossaryRegionId_First(regionId, chainCode,
			activeInd, navItemText, orderByComparator);
	}

	/**
	* Returns the first glossary region nav in the ordered set where regionId = &#63; and chainCode = &#63; and activeInd = &#63; and navItemText = &#63;.
	*
	* @param regionId the region ID
	* @param chainCode the chain code
	* @param activeInd the active ind
	* @param navItemText the nav item text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching glossary region nav, or <code>null</code> if a matching glossary region nav could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav fetchByglossaryRegionId_First(
		long regionId, java.lang.String chainCode, java.lang.String activeInd,
		java.lang.String navItemText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByglossaryRegionId_First(regionId, chainCode,
			activeInd, navItemText, orderByComparator);
	}

	/**
	* Returns the last glossary region nav in the ordered set where regionId = &#63; and chainCode = &#63; and activeInd = &#63; and navItemText = &#63;.
	*
	* @param regionId the region ID
	* @param chainCode the chain code
	* @param activeInd the active ind
	* @param navItemText the nav item text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching glossary region nav
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a matching glossary region nav could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav findByglossaryRegionId_Last(
		long regionId, java.lang.String chainCode, java.lang.String activeInd,
		java.lang.String navItemText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByglossaryRegionId_Last(regionId, chainCode, activeInd,
			navItemText, orderByComparator);
	}

	/**
	* Returns the last glossary region nav in the ordered set where regionId = &#63; and chainCode = &#63; and activeInd = &#63; and navItemText = &#63;.
	*
	* @param regionId the region ID
	* @param chainCode the chain code
	* @param activeInd the active ind
	* @param navItemText the nav item text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching glossary region nav, or <code>null</code> if a matching glossary region nav could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav fetchByglossaryRegionId_Last(
		long regionId, java.lang.String chainCode, java.lang.String activeInd,
		java.lang.String navItemText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByglossaryRegionId_Last(regionId, chainCode,
			activeInd, navItemText, orderByComparator);
	}

	/**
	* Returns the glossary region navs before and after the current glossary region nav in the ordered set where regionId = &#63; and chainCode = &#63; and activeInd = &#63; and navItemText = &#63;.
	*
	* @param glossaryRgnNavId the primary key of the current glossary region nav
	* @param regionId the region ID
	* @param chainCode the chain code
	* @param activeInd the active ind
	* @param navItemText the nav item text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next glossary region nav
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a glossary region nav with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav[] findByglossaryRegionId_PrevAndNext(
		long glossaryRgnNavId, long regionId, java.lang.String chainCode,
		java.lang.String activeInd, java.lang.String navItemText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByglossaryRegionId_PrevAndNext(glossaryRgnNavId,
			regionId, chainCode, activeInd, navItemText, orderByComparator);
	}

	/**
	* Removes all the glossary region navs where regionId = &#63; and chainCode = &#63; and activeInd = &#63; and navItemText = &#63; from the database.
	*
	* @param regionId the region ID
	* @param chainCode the chain code
	* @param activeInd the active ind
	* @param navItemText the nav item text
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByglossaryRegionId(long regionId,
		java.lang.String chainCode, java.lang.String activeInd,
		java.lang.String navItemText)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByglossaryRegionId(regionId, chainCode, activeInd,
			navItemText);
	}

	/**
	* Returns the number of glossary region navs where regionId = &#63; and chainCode = &#63; and activeInd = &#63; and navItemText = &#63;.
	*
	* @param regionId the region ID
	* @param chainCode the chain code
	* @param activeInd the active ind
	* @param navItemText the nav item text
	* @return the number of matching glossary region navs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByglossaryRegionId(long regionId,
		java.lang.String chainCode, java.lang.String activeInd,
		java.lang.String navItemText)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByglossaryRegionId(regionId, chainCode, activeInd,
			navItemText);
	}

	/**
	* Returns all the glossary region navs where regionId = &#63; and chainCode = &#63; and activeInd = &#63;.
	*
	* @param regionId the region ID
	* @param chainCode the chain code
	* @param activeInd the active ind
	* @return the matching glossary region navs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryRegionNav> findByallGlossaryRegionId(
		long regionId, java.lang.String chainCode, java.lang.String activeInd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByallGlossaryRegionId(regionId, chainCode, activeInd);
	}

	/**
	* Returns a range of all the glossary region navs where regionId = &#63; and chainCode = &#63; and activeInd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryRegionNavModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param regionId the region ID
	* @param chainCode the chain code
	* @param activeInd the active ind
	* @param start the lower bound of the range of glossary region navs
	* @param end the upper bound of the range of glossary region navs (not inclusive)
	* @return the range of matching glossary region navs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryRegionNav> findByallGlossaryRegionId(
		long regionId, java.lang.String chainCode, java.lang.String activeInd,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByallGlossaryRegionId(regionId, chainCode, activeInd,
			start, end);
	}

	/**
	* Returns an ordered range of all the glossary region navs where regionId = &#63; and chainCode = &#63; and activeInd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryRegionNavModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param regionId the region ID
	* @param chainCode the chain code
	* @param activeInd the active ind
	* @param start the lower bound of the range of glossary region navs
	* @param end the upper bound of the range of glossary region navs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching glossary region navs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryRegionNav> findByallGlossaryRegionId(
		long regionId, java.lang.String chainCode, java.lang.String activeInd,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByallGlossaryRegionId(regionId, chainCode, activeInd,
			start, end, orderByComparator);
	}

	/**
	* Returns the first glossary region nav in the ordered set where regionId = &#63; and chainCode = &#63; and activeInd = &#63;.
	*
	* @param regionId the region ID
	* @param chainCode the chain code
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching glossary region nav
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a matching glossary region nav could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav findByallGlossaryRegionId_First(
		long regionId, java.lang.String chainCode, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByallGlossaryRegionId_First(regionId, chainCode,
			activeInd, orderByComparator);
	}

	/**
	* Returns the first glossary region nav in the ordered set where regionId = &#63; and chainCode = &#63; and activeInd = &#63;.
	*
	* @param regionId the region ID
	* @param chainCode the chain code
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching glossary region nav, or <code>null</code> if a matching glossary region nav could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav fetchByallGlossaryRegionId_First(
		long regionId, java.lang.String chainCode, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByallGlossaryRegionId_First(regionId, chainCode,
			activeInd, orderByComparator);
	}

	/**
	* Returns the last glossary region nav in the ordered set where regionId = &#63; and chainCode = &#63; and activeInd = &#63;.
	*
	* @param regionId the region ID
	* @param chainCode the chain code
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching glossary region nav
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a matching glossary region nav could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav findByallGlossaryRegionId_Last(
		long regionId, java.lang.String chainCode, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByallGlossaryRegionId_Last(regionId, chainCode,
			activeInd, orderByComparator);
	}

	/**
	* Returns the last glossary region nav in the ordered set where regionId = &#63; and chainCode = &#63; and activeInd = &#63;.
	*
	* @param regionId the region ID
	* @param chainCode the chain code
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching glossary region nav, or <code>null</code> if a matching glossary region nav could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav fetchByallGlossaryRegionId_Last(
		long regionId, java.lang.String chainCode, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByallGlossaryRegionId_Last(regionId, chainCode,
			activeInd, orderByComparator);
	}

	/**
	* Returns the glossary region navs before and after the current glossary region nav in the ordered set where regionId = &#63; and chainCode = &#63; and activeInd = &#63;.
	*
	* @param glossaryRgnNavId the primary key of the current glossary region nav
	* @param regionId the region ID
	* @param chainCode the chain code
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next glossary region nav
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a glossary region nav with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav[] findByallGlossaryRegionId_PrevAndNext(
		long glossaryRgnNavId, long regionId, java.lang.String chainCode,
		java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByallGlossaryRegionId_PrevAndNext(glossaryRgnNavId,
			regionId, chainCode, activeInd, orderByComparator);
	}

	/**
	* Removes all the glossary region navs where regionId = &#63; and chainCode = &#63; and activeInd = &#63; from the database.
	*
	* @param regionId the region ID
	* @param chainCode the chain code
	* @param activeInd the active ind
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByallGlossaryRegionId(long regionId,
		java.lang.String chainCode, java.lang.String activeInd)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByallGlossaryRegionId(regionId, chainCode, activeInd);
	}

	/**
	* Returns the number of glossary region navs where regionId = &#63; and chainCode = &#63; and activeInd = &#63;.
	*
	* @param regionId the region ID
	* @param chainCode the chain code
	* @param activeInd the active ind
	* @return the number of matching glossary region navs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByallGlossaryRegionId(long regionId,
		java.lang.String chainCode, java.lang.String activeInd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByallGlossaryRegionId(regionId, chainCode, activeInd);
	}

	/**
	* Returns all the glossary region navs where chainCode = &#63; and navItemText = &#63;.
	*
	* @param chainCode the chain code
	* @param navItemText the nav item text
	* @return the matching glossary region navs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryRegionNav> findByglossaryByChainCode(
		java.lang.String chainCode, java.lang.String navItemText)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByglossaryByChainCode(chainCode, navItemText);
	}

	/**
	* Returns a range of all the glossary region navs where chainCode = &#63; and navItemText = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryRegionNavModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param chainCode the chain code
	* @param navItemText the nav item text
	* @param start the lower bound of the range of glossary region navs
	* @param end the upper bound of the range of glossary region navs (not inclusive)
	* @return the range of matching glossary region navs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryRegionNav> findByglossaryByChainCode(
		java.lang.String chainCode, java.lang.String navItemText, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByglossaryByChainCode(chainCode, navItemText, start, end);
	}

	/**
	* Returns an ordered range of all the glossary region navs where chainCode = &#63; and navItemText = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryRegionNavModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param chainCode the chain code
	* @param navItemText the nav item text
	* @param start the lower bound of the range of glossary region navs
	* @param end the upper bound of the range of glossary region navs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching glossary region navs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryRegionNav> findByglossaryByChainCode(
		java.lang.String chainCode, java.lang.String navItemText, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByglossaryByChainCode(chainCode, navItemText, start,
			end, orderByComparator);
	}

	/**
	* Returns the first glossary region nav in the ordered set where chainCode = &#63; and navItemText = &#63;.
	*
	* @param chainCode the chain code
	* @param navItemText the nav item text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching glossary region nav
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a matching glossary region nav could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav findByglossaryByChainCode_First(
		java.lang.String chainCode, java.lang.String navItemText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByglossaryByChainCode_First(chainCode, navItemText,
			orderByComparator);
	}

	/**
	* Returns the first glossary region nav in the ordered set where chainCode = &#63; and navItemText = &#63;.
	*
	* @param chainCode the chain code
	* @param navItemText the nav item text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching glossary region nav, or <code>null</code> if a matching glossary region nav could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav fetchByglossaryByChainCode_First(
		java.lang.String chainCode, java.lang.String navItemText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByglossaryByChainCode_First(chainCode, navItemText,
			orderByComparator);
	}

	/**
	* Returns the last glossary region nav in the ordered set where chainCode = &#63; and navItemText = &#63;.
	*
	* @param chainCode the chain code
	* @param navItemText the nav item text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching glossary region nav
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a matching glossary region nav could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav findByglossaryByChainCode_Last(
		java.lang.String chainCode, java.lang.String navItemText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByglossaryByChainCode_Last(chainCode, navItemText,
			orderByComparator);
	}

	/**
	* Returns the last glossary region nav in the ordered set where chainCode = &#63; and navItemText = &#63;.
	*
	* @param chainCode the chain code
	* @param navItemText the nav item text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching glossary region nav, or <code>null</code> if a matching glossary region nav could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav fetchByglossaryByChainCode_Last(
		java.lang.String chainCode, java.lang.String navItemText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByglossaryByChainCode_Last(chainCode, navItemText,
			orderByComparator);
	}

	/**
	* Returns the glossary region navs before and after the current glossary region nav in the ordered set where chainCode = &#63; and navItemText = &#63;.
	*
	* @param glossaryRgnNavId the primary key of the current glossary region nav
	* @param chainCode the chain code
	* @param navItemText the nav item text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next glossary region nav
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a glossary region nav with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav[] findByglossaryByChainCode_PrevAndNext(
		long glossaryRgnNavId, java.lang.String chainCode,
		java.lang.String navItemText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByglossaryByChainCode_PrevAndNext(glossaryRgnNavId,
			chainCode, navItemText, orderByComparator);
	}

	/**
	* Removes all the glossary region navs where chainCode = &#63; and navItemText = &#63; from the database.
	*
	* @param chainCode the chain code
	* @param navItemText the nav item text
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByglossaryByChainCode(java.lang.String chainCode,
		java.lang.String navItemText)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByglossaryByChainCode(chainCode, navItemText);
	}

	/**
	* Returns the number of glossary region navs where chainCode = &#63; and navItemText = &#63;.
	*
	* @param chainCode the chain code
	* @param navItemText the nav item text
	* @return the number of matching glossary region navs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByglossaryByChainCode(java.lang.String chainCode,
		java.lang.String navItemText)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByglossaryByChainCode(chainCode, navItemText);
	}

	/**
	* Returns all the glossary region navs where glossaryId = &#63;.
	*
	* @param glossaryId the glossary ID
	* @return the matching glossary region navs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryRegionNav> findByglossaryId(
		long glossaryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByglossaryId(glossaryId);
	}

	/**
	* Returns a range of all the glossary region navs where glossaryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryRegionNavModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param glossaryId the glossary ID
	* @param start the lower bound of the range of glossary region navs
	* @param end the upper bound of the range of glossary region navs (not inclusive)
	* @return the range of matching glossary region navs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryRegionNav> findByglossaryId(
		long glossaryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByglossaryId(glossaryId, start, end);
	}

	/**
	* Returns an ordered range of all the glossary region navs where glossaryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryRegionNavModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param glossaryId the glossary ID
	* @param start the lower bound of the range of glossary region navs
	* @param end the upper bound of the range of glossary region navs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching glossary region navs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryRegionNav> findByglossaryId(
		long glossaryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByglossaryId(glossaryId, start, end, orderByComparator);
	}

	/**
	* Returns the first glossary region nav in the ordered set where glossaryId = &#63;.
	*
	* @param glossaryId the glossary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching glossary region nav
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a matching glossary region nav could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav findByglossaryId_First(
		long glossaryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByglossaryId_First(glossaryId, orderByComparator);
	}

	/**
	* Returns the first glossary region nav in the ordered set where glossaryId = &#63;.
	*
	* @param glossaryId the glossary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching glossary region nav, or <code>null</code> if a matching glossary region nav could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav fetchByglossaryId_First(
		long glossaryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByglossaryId_First(glossaryId, orderByComparator);
	}

	/**
	* Returns the last glossary region nav in the ordered set where glossaryId = &#63;.
	*
	* @param glossaryId the glossary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching glossary region nav
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a matching glossary region nav could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav findByglossaryId_Last(
		long glossaryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByglossaryId_Last(glossaryId, orderByComparator);
	}

	/**
	* Returns the last glossary region nav in the ordered set where glossaryId = &#63;.
	*
	* @param glossaryId the glossary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching glossary region nav, or <code>null</code> if a matching glossary region nav could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav fetchByglossaryId_Last(
		long glossaryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByglossaryId_Last(glossaryId, orderByComparator);
	}

	/**
	* Returns the glossary region navs before and after the current glossary region nav in the ordered set where glossaryId = &#63;.
	*
	* @param glossaryRgnNavId the primary key of the current glossary region nav
	* @param glossaryId the glossary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next glossary region nav
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a glossary region nav with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav[] findByglossaryId_PrevAndNext(
		long glossaryRgnNavId, long glossaryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByglossaryId_PrevAndNext(glossaryRgnNavId, glossaryId,
			orderByComparator);
	}

	/**
	* Removes all the glossary region navs where glossaryId = &#63; from the database.
	*
	* @param glossaryId the glossary ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByglossaryId(long glossaryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByglossaryId(glossaryId);
	}

	/**
	* Returns the number of glossary region navs where glossaryId = &#63;.
	*
	* @param glossaryId the glossary ID
	* @return the number of matching glossary region navs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByglossaryId(long glossaryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByglossaryId(glossaryId);
	}

	/**
	* Caches the glossary region nav in the entity cache if it is enabled.
	*
	* @param glossaryRegionNav the glossary region nav
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.GlossaryRegionNav glossaryRegionNav) {
		getPersistence().cacheResult(glossaryRegionNav);
	}

	/**
	* Caches the glossary region navs in the entity cache if it is enabled.
	*
	* @param glossaryRegionNavs the glossary region navs
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GlossaryRegionNav> glossaryRegionNavs) {
		getPersistence().cacheResult(glossaryRegionNavs);
	}

	/**
	* Creates a new glossary region nav with the primary key. Does not add the glossary region nav to the database.
	*
	* @param glossaryRgnNavId the primary key for the new glossary region nav
	* @return the new glossary region nav
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav create(
		long glossaryRgnNavId) {
		return getPersistence().create(glossaryRgnNavId);
	}

	/**
	* Removes the glossary region nav with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param glossaryRgnNavId the primary key of the glossary region nav
	* @return the glossary region nav that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a glossary region nav with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav remove(
		long glossaryRgnNavId)
		throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(glossaryRgnNavId);
	}

	public static com.ihg.brandstandards.db.model.GlossaryRegionNav updateImpl(
		com.ihg.brandstandards.db.model.GlossaryRegionNav glossaryRegionNav)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(glossaryRegionNav);
	}

	/**
	* Returns the glossary region nav with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException} if it could not be found.
	*
	* @param glossaryRgnNavId the primary key of the glossary region nav
	* @return the glossary region nav
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException if a glossary region nav with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav findByPrimaryKey(
		long glossaryRgnNavId)
		throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(glossaryRgnNavId);
	}

	/**
	* Returns the glossary region nav with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param glossaryRgnNavId the primary key of the glossary region nav
	* @return the glossary region nav, or <code>null</code> if a glossary region nav with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryRegionNav fetchByPrimaryKey(
		long glossaryRgnNavId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(glossaryRgnNavId);
	}

	/**
	* Returns all the glossary region navs.
	*
	* @return the glossary region navs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryRegionNav> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the glossary region navs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryRegionNavModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of glossary region navs
	* @param end the upper bound of the range of glossary region navs (not inclusive)
	* @return the range of glossary region navs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryRegionNav> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the glossary region navs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryRegionNavModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of glossary region navs
	* @param end the upper bound of the range of glossary region navs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of glossary region navs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryRegionNav> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the glossary region navs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of glossary region navs.
	*
	* @return the number of glossary region navs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GlossaryRegionNavPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GlossaryRegionNavPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					GlossaryRegionNavPersistence.class.getName());

			ReferenceRegistry.registerReference(GlossaryRegionNavUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GlossaryRegionNavPersistence persistence) {
	}

	private static GlossaryRegionNavPersistence _persistence;
}