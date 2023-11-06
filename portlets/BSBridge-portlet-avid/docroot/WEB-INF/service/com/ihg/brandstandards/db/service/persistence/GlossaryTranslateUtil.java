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

import com.ihg.brandstandards.db.model.GlossaryTranslate;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the glossary translate service. This utility wraps {@link GlossaryTranslatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GlossaryTranslatePersistence
 * @see GlossaryTranslatePersistenceImpl
 * @generated
 */
public class GlossaryTranslateUtil {
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
	public static void clearCache(GlossaryTranslate glossaryTranslate) {
		getPersistence().clearCache(glossaryTranslate);
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
	public static List<GlossaryTranslate> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GlossaryTranslate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GlossaryTranslate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GlossaryTranslate update(GlossaryTranslate glossaryTranslate)
		throws SystemException {
		return getPersistence().update(glossaryTranslate);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GlossaryTranslate update(
		GlossaryTranslate glossaryTranslate, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(glossaryTranslate, serviceContext);
	}

	/**
	* Returns the glossary translate where glossaryId = &#63; and langCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchGlossaryTranslateException} if it could not be found.
	*
	* @param glossaryId the glossary ID
	* @param langCode the lang code
	* @return the matching glossary translate
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException if a matching glossary translate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryTranslate findByglossaryIdLocaleCode(
		long glossaryId, java.lang.String langCode)
		throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByglossaryIdLocaleCode(glossaryId, langCode);
	}

	/**
	* Returns the glossary translate where glossaryId = &#63; and langCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param glossaryId the glossary ID
	* @param langCode the lang code
	* @return the matching glossary translate, or <code>null</code> if a matching glossary translate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryTranslate fetchByglossaryIdLocaleCode(
		long glossaryId, java.lang.String langCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByglossaryIdLocaleCode(glossaryId, langCode);
	}

	/**
	* Returns the glossary translate where glossaryId = &#63; and langCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param glossaryId the glossary ID
	* @param langCode the lang code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching glossary translate, or <code>null</code> if a matching glossary translate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryTranslate fetchByglossaryIdLocaleCode(
		long glossaryId, java.lang.String langCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByglossaryIdLocaleCode(glossaryId, langCode,
			retrieveFromCache);
	}

	/**
	* Removes the glossary translate where glossaryId = &#63; and langCode = &#63; from the database.
	*
	* @param glossaryId the glossary ID
	* @param langCode the lang code
	* @return the glossary translate that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryTranslate removeByglossaryIdLocaleCode(
		long glossaryId, java.lang.String langCode)
		throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByglossaryIdLocaleCode(glossaryId, langCode);
	}

	/**
	* Returns the number of glossary translates where glossaryId = &#63; and langCode = &#63;.
	*
	* @param glossaryId the glossary ID
	* @param langCode the lang code
	* @return the number of matching glossary translates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByglossaryIdLocaleCode(long glossaryId,
		java.lang.String langCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByglossaryIdLocaleCode(glossaryId, langCode);
	}

	/**
	* Returns all the glossary translates where langCode = &#63;.
	*
	* @param langCode the lang code
	* @return the matching glossary translates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryTranslate> findBylangCode(
		java.lang.String langCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBylangCode(langCode);
	}

	/**
	* Returns a range of all the glossary translates where langCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param langCode the lang code
	* @param start the lower bound of the range of glossary translates
	* @param end the upper bound of the range of glossary translates (not inclusive)
	* @return the range of matching glossary translates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryTranslate> findBylangCode(
		java.lang.String langCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBylangCode(langCode, start, end);
	}

	/**
	* Returns an ordered range of all the glossary translates where langCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param langCode the lang code
	* @param start the lower bound of the range of glossary translates
	* @param end the upper bound of the range of glossary translates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching glossary translates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryTranslate> findBylangCode(
		java.lang.String langCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBylangCode(langCode, start, end, orderByComparator);
	}

	/**
	* Returns the first glossary translate in the ordered set where langCode = &#63;.
	*
	* @param langCode the lang code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching glossary translate
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException if a matching glossary translate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryTranslate findBylangCode_First(
		java.lang.String langCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBylangCode_First(langCode, orderByComparator);
	}

	/**
	* Returns the first glossary translate in the ordered set where langCode = &#63;.
	*
	* @param langCode the lang code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching glossary translate, or <code>null</code> if a matching glossary translate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryTranslate fetchBylangCode_First(
		java.lang.String langCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBylangCode_First(langCode, orderByComparator);
	}

	/**
	* Returns the last glossary translate in the ordered set where langCode = &#63;.
	*
	* @param langCode the lang code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching glossary translate
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException if a matching glossary translate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryTranslate findBylangCode_Last(
		java.lang.String langCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBylangCode_Last(langCode, orderByComparator);
	}

	/**
	* Returns the last glossary translate in the ordered set where langCode = &#63;.
	*
	* @param langCode the lang code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching glossary translate, or <code>null</code> if a matching glossary translate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryTranslate fetchBylangCode_Last(
		java.lang.String langCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBylangCode_Last(langCode, orderByComparator);
	}

	/**
	* Returns the glossary translates before and after the current glossary translate in the ordered set where langCode = &#63;.
	*
	* @param glossaryXlatId the primary key of the current glossary translate
	* @param langCode the lang code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next glossary translate
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException if a glossary translate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryTranslate[] findBylangCode_PrevAndNext(
		long glossaryXlatId, java.lang.String langCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBylangCode_PrevAndNext(glossaryXlatId, langCode,
			orderByComparator);
	}

	/**
	* Removes all the glossary translates where langCode = &#63; from the database.
	*
	* @param langCode the lang code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBylangCode(java.lang.String langCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBylangCode(langCode);
	}

	/**
	* Returns the number of glossary translates where langCode = &#63;.
	*
	* @param langCode the lang code
	* @return the number of matching glossary translates
	* @throws SystemException if a system exception occurred
	*/
	public static int countBylangCode(java.lang.String langCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBylangCode(langCode);
	}

	/**
	* Returns all the glossary translates where glossaryId = &#63;.
	*
	* @param glossaryId the glossary ID
	* @return the matching glossary translates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryTranslate> findByGlossaryId(
		long glossaryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGlossaryId(glossaryId);
	}

	/**
	* Returns a range of all the glossary translates where glossaryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param glossaryId the glossary ID
	* @param start the lower bound of the range of glossary translates
	* @param end the upper bound of the range of glossary translates (not inclusive)
	* @return the range of matching glossary translates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryTranslate> findByGlossaryId(
		long glossaryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGlossaryId(glossaryId, start, end);
	}

	/**
	* Returns an ordered range of all the glossary translates where glossaryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param glossaryId the glossary ID
	* @param start the lower bound of the range of glossary translates
	* @param end the upper bound of the range of glossary translates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching glossary translates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryTranslate> findByGlossaryId(
		long glossaryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGlossaryId(glossaryId, start, end, orderByComparator);
	}

	/**
	* Returns the first glossary translate in the ordered set where glossaryId = &#63;.
	*
	* @param glossaryId the glossary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching glossary translate
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException if a matching glossary translate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryTranslate findByGlossaryId_First(
		long glossaryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGlossaryId_First(glossaryId, orderByComparator);
	}

	/**
	* Returns the first glossary translate in the ordered set where glossaryId = &#63;.
	*
	* @param glossaryId the glossary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching glossary translate, or <code>null</code> if a matching glossary translate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryTranslate fetchByGlossaryId_First(
		long glossaryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGlossaryId_First(glossaryId, orderByComparator);
	}

	/**
	* Returns the last glossary translate in the ordered set where glossaryId = &#63;.
	*
	* @param glossaryId the glossary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching glossary translate
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException if a matching glossary translate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryTranslate findByGlossaryId_Last(
		long glossaryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGlossaryId_Last(glossaryId, orderByComparator);
	}

	/**
	* Returns the last glossary translate in the ordered set where glossaryId = &#63;.
	*
	* @param glossaryId the glossary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching glossary translate, or <code>null</code> if a matching glossary translate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryTranslate fetchByGlossaryId_Last(
		long glossaryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGlossaryId_Last(glossaryId, orderByComparator);
	}

	/**
	* Returns the glossary translates before and after the current glossary translate in the ordered set where glossaryId = &#63;.
	*
	* @param glossaryXlatId the primary key of the current glossary translate
	* @param glossaryId the glossary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next glossary translate
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException if a glossary translate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryTranslate[] findByGlossaryId_PrevAndNext(
		long glossaryXlatId, long glossaryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGlossaryId_PrevAndNext(glossaryXlatId, glossaryId,
			orderByComparator);
	}

	/**
	* Removes all the glossary translates where glossaryId = &#63; from the database.
	*
	* @param glossaryId the glossary ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGlossaryId(long glossaryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGlossaryId(glossaryId);
	}

	/**
	* Returns the number of glossary translates where glossaryId = &#63;.
	*
	* @param glossaryId the glossary ID
	* @return the number of matching glossary translates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGlossaryId(long glossaryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGlossaryId(glossaryId);
	}

	/**
	* Caches the glossary translate in the entity cache if it is enabled.
	*
	* @param glossaryTranslate the glossary translate
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.GlossaryTranslate glossaryTranslate) {
		getPersistence().cacheResult(glossaryTranslate);
	}

	/**
	* Caches the glossary translates in the entity cache if it is enabled.
	*
	* @param glossaryTranslates the glossary translates
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GlossaryTranslate> glossaryTranslates) {
		getPersistence().cacheResult(glossaryTranslates);
	}

	/**
	* Creates a new glossary translate with the primary key. Does not add the glossary translate to the database.
	*
	* @param glossaryXlatId the primary key for the new glossary translate
	* @return the new glossary translate
	*/
	public static com.ihg.brandstandards.db.model.GlossaryTranslate create(
		long glossaryXlatId) {
		return getPersistence().create(glossaryXlatId);
	}

	/**
	* Removes the glossary translate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param glossaryXlatId the primary key of the glossary translate
	* @return the glossary translate that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException if a glossary translate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryTranslate remove(
		long glossaryXlatId)
		throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(glossaryXlatId);
	}

	public static com.ihg.brandstandards.db.model.GlossaryTranslate updateImpl(
		com.ihg.brandstandards.db.model.GlossaryTranslate glossaryTranslate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(glossaryTranslate);
	}

	/**
	* Returns the glossary translate with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGlossaryTranslateException} if it could not be found.
	*
	* @param glossaryXlatId the primary key of the glossary translate
	* @return the glossary translate
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException if a glossary translate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryTranslate findByPrimaryKey(
		long glossaryXlatId)
		throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(glossaryXlatId);
	}

	/**
	* Returns the glossary translate with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param glossaryXlatId the primary key of the glossary translate
	* @return the glossary translate, or <code>null</code> if a glossary translate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryTranslate fetchByPrimaryKey(
		long glossaryXlatId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(glossaryXlatId);
	}

	/**
	* Returns all the glossary translates.
	*
	* @return the glossary translates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryTranslate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the glossary translates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of glossary translates
	* @param end the upper bound of the range of glossary translates (not inclusive)
	* @return the range of glossary translates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryTranslate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the glossary translates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of glossary translates
	* @param end the upper bound of the range of glossary translates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of glossary translates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryTranslate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the glossary translates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of glossary translates.
	*
	* @return the number of glossary translates
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GlossaryTranslatePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GlossaryTranslatePersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					GlossaryTranslatePersistence.class.getName());

			ReferenceRegistry.registerReference(GlossaryTranslateUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GlossaryTranslatePersistence persistence) {
	}

	private static GlossaryTranslatePersistence _persistence;
}