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

import com.ihg.brandstandards.db.model.SpecialWordDictionary;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the special word dictionary service. This utility wraps {@link SpecialWordDictionaryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see SpecialWordDictionaryPersistence
 * @see SpecialWordDictionaryPersistenceImpl
 * @generated
 */
public class SpecialWordDictionaryUtil {
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
	public static void clearCache(SpecialWordDictionary specialWordDictionary) {
		getPersistence().clearCache(specialWordDictionary);
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
	public static List<SpecialWordDictionary> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SpecialWordDictionary> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SpecialWordDictionary> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SpecialWordDictionary update(
		SpecialWordDictionary specialWordDictionary) throws SystemException {
		return getPersistence().update(specialWordDictionary);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SpecialWordDictionary update(
		SpecialWordDictionary specialWordDictionary,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(specialWordDictionary, serviceContext);
	}

	/**
	* Returns all the special word dictionaries where localeCode = &#63;.
	*
	* @param localeCode the locale code
	* @return the matching special word dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.SpecialWordDictionary> findByLocaleCode(
		java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLocaleCode(localeCode);
	}

	/**
	* Returns a range of all the special word dictionaries where localeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpecialWordDictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param localeCode the locale code
	* @param start the lower bound of the range of special word dictionaries
	* @param end the upper bound of the range of special word dictionaries (not inclusive)
	* @return the range of matching special word dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.SpecialWordDictionary> findByLocaleCode(
		java.lang.String localeCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLocaleCode(localeCode, start, end);
	}

	/**
	* Returns an ordered range of all the special word dictionaries where localeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpecialWordDictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param localeCode the locale code
	* @param start the lower bound of the range of special word dictionaries
	* @param end the upper bound of the range of special word dictionaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching special word dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.SpecialWordDictionary> findByLocaleCode(
		java.lang.String localeCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLocaleCode(localeCode, start, end, orderByComparator);
	}

	/**
	* Returns the first special word dictionary in the ordered set where localeCode = &#63;.
	*
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching special word dictionary
	* @throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException if a matching special word dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpecialWordDictionary findByLocaleCode_First(
		java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLocaleCode_First(localeCode, orderByComparator);
	}

	/**
	* Returns the first special word dictionary in the ordered set where localeCode = &#63;.
	*
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching special word dictionary, or <code>null</code> if a matching special word dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpecialWordDictionary fetchByLocaleCode_First(
		java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLocaleCode_First(localeCode, orderByComparator);
	}

	/**
	* Returns the last special word dictionary in the ordered set where localeCode = &#63;.
	*
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching special word dictionary
	* @throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException if a matching special word dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpecialWordDictionary findByLocaleCode_Last(
		java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLocaleCode_Last(localeCode, orderByComparator);
	}

	/**
	* Returns the last special word dictionary in the ordered set where localeCode = &#63;.
	*
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching special word dictionary, or <code>null</code> if a matching special word dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpecialWordDictionary fetchByLocaleCode_Last(
		java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLocaleCode_Last(localeCode, orderByComparator);
	}

	/**
	* Returns the special word dictionaries before and after the current special word dictionary in the ordered set where localeCode = &#63;.
	*
	* @param specialWordId the primary key of the current special word dictionary
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next special word dictionary
	* @throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException if a special word dictionary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpecialWordDictionary[] findByLocaleCode_PrevAndNext(
		long specialWordId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLocaleCode_PrevAndNext(specialWordId, localeCode,
			orderByComparator);
	}

	/**
	* Removes all the special word dictionaries where localeCode = &#63; from the database.
	*
	* @param localeCode the locale code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLocaleCode(java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLocaleCode(localeCode);
	}

	/**
	* Returns the number of special word dictionaries where localeCode = &#63;.
	*
	* @param localeCode the locale code
	* @return the number of matching special word dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLocaleCode(java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLocaleCode(localeCode);
	}

	/**
	* Returns the special word dictionary where replacedWordTxt = &#63; and localeCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException} if it could not be found.
	*
	* @param replacedWordTxt the replaced word txt
	* @param localeCode the locale code
	* @return the matching special word dictionary
	* @throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException if a matching special word dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpecialWordDictionary findByReplacedWordTxtAndLocaleCode(
		java.lang.String replacedWordTxt, java.lang.String localeCode)
		throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReplacedWordTxtAndLocaleCode(replacedWordTxt,
			localeCode);
	}

	/**
	* Returns the special word dictionary where replacedWordTxt = &#63; and localeCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param replacedWordTxt the replaced word txt
	* @param localeCode the locale code
	* @return the matching special word dictionary, or <code>null</code> if a matching special word dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpecialWordDictionary fetchByReplacedWordTxtAndLocaleCode(
		java.lang.String replacedWordTxt, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByReplacedWordTxtAndLocaleCode(replacedWordTxt,
			localeCode);
	}

	/**
	* Returns the special word dictionary where replacedWordTxt = &#63; and localeCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param replacedWordTxt the replaced word txt
	* @param localeCode the locale code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching special word dictionary, or <code>null</code> if a matching special word dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpecialWordDictionary fetchByReplacedWordTxtAndLocaleCode(
		java.lang.String replacedWordTxt, java.lang.String localeCode,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByReplacedWordTxtAndLocaleCode(replacedWordTxt,
			localeCode, retrieveFromCache);
	}

	/**
	* Removes the special word dictionary where replacedWordTxt = &#63; and localeCode = &#63; from the database.
	*
	* @param replacedWordTxt the replaced word txt
	* @param localeCode the locale code
	* @return the special word dictionary that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpecialWordDictionary removeByReplacedWordTxtAndLocaleCode(
		java.lang.String replacedWordTxt, java.lang.String localeCode)
		throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByReplacedWordTxtAndLocaleCode(replacedWordTxt,
			localeCode);
	}

	/**
	* Returns the number of special word dictionaries where replacedWordTxt = &#63; and localeCode = &#63;.
	*
	* @param replacedWordTxt the replaced word txt
	* @param localeCode the locale code
	* @return the number of matching special word dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByReplacedWordTxtAndLocaleCode(
		java.lang.String replacedWordTxt, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByReplacedWordTxtAndLocaleCode(replacedWordTxt,
			localeCode);
	}

	/**
	* Returns all the special word dictionaries where replacementWordTxt = &#63; and localeCode = &#63;.
	*
	* @param replacementWordTxt the replacement word txt
	* @param localeCode the locale code
	* @return the matching special word dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.SpecialWordDictionary> findByReplacementWordTxtAndLocaleCode(
		java.lang.String replacementWordTxt, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReplacementWordTxtAndLocaleCode(replacementWordTxt,
			localeCode);
	}

	/**
	* Returns a range of all the special word dictionaries where replacementWordTxt = &#63; and localeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpecialWordDictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param replacementWordTxt the replacement word txt
	* @param localeCode the locale code
	* @param start the lower bound of the range of special word dictionaries
	* @param end the upper bound of the range of special word dictionaries (not inclusive)
	* @return the range of matching special word dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.SpecialWordDictionary> findByReplacementWordTxtAndLocaleCode(
		java.lang.String replacementWordTxt, java.lang.String localeCode,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReplacementWordTxtAndLocaleCode(replacementWordTxt,
			localeCode, start, end);
	}

	/**
	* Returns an ordered range of all the special word dictionaries where replacementWordTxt = &#63; and localeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpecialWordDictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param replacementWordTxt the replacement word txt
	* @param localeCode the locale code
	* @param start the lower bound of the range of special word dictionaries
	* @param end the upper bound of the range of special word dictionaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching special word dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.SpecialWordDictionary> findByReplacementWordTxtAndLocaleCode(
		java.lang.String replacementWordTxt, java.lang.String localeCode,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReplacementWordTxtAndLocaleCode(replacementWordTxt,
			localeCode, start, end, orderByComparator);
	}

	/**
	* Returns the first special word dictionary in the ordered set where replacementWordTxt = &#63; and localeCode = &#63;.
	*
	* @param replacementWordTxt the replacement word txt
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching special word dictionary
	* @throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException if a matching special word dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpecialWordDictionary findByReplacementWordTxtAndLocaleCode_First(
		java.lang.String replacementWordTxt, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReplacementWordTxtAndLocaleCode_First(replacementWordTxt,
			localeCode, orderByComparator);
	}

	/**
	* Returns the first special word dictionary in the ordered set where replacementWordTxt = &#63; and localeCode = &#63;.
	*
	* @param replacementWordTxt the replacement word txt
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching special word dictionary, or <code>null</code> if a matching special word dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpecialWordDictionary fetchByReplacementWordTxtAndLocaleCode_First(
		java.lang.String replacementWordTxt, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByReplacementWordTxtAndLocaleCode_First(replacementWordTxt,
			localeCode, orderByComparator);
	}

	/**
	* Returns the last special word dictionary in the ordered set where replacementWordTxt = &#63; and localeCode = &#63;.
	*
	* @param replacementWordTxt the replacement word txt
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching special word dictionary
	* @throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException if a matching special word dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpecialWordDictionary findByReplacementWordTxtAndLocaleCode_Last(
		java.lang.String replacementWordTxt, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReplacementWordTxtAndLocaleCode_Last(replacementWordTxt,
			localeCode, orderByComparator);
	}

	/**
	* Returns the last special word dictionary in the ordered set where replacementWordTxt = &#63; and localeCode = &#63;.
	*
	* @param replacementWordTxt the replacement word txt
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching special word dictionary, or <code>null</code> if a matching special word dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpecialWordDictionary fetchByReplacementWordTxtAndLocaleCode_Last(
		java.lang.String replacementWordTxt, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByReplacementWordTxtAndLocaleCode_Last(replacementWordTxt,
			localeCode, orderByComparator);
	}

	/**
	* Returns the special word dictionaries before and after the current special word dictionary in the ordered set where replacementWordTxt = &#63; and localeCode = &#63;.
	*
	* @param specialWordId the primary key of the current special word dictionary
	* @param replacementWordTxt the replacement word txt
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next special word dictionary
	* @throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException if a special word dictionary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpecialWordDictionary[] findByReplacementWordTxtAndLocaleCode_PrevAndNext(
		long specialWordId, java.lang.String replacementWordTxt,
		java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByReplacementWordTxtAndLocaleCode_PrevAndNext(specialWordId,
			replacementWordTxt, localeCode, orderByComparator);
	}

	/**
	* Removes all the special word dictionaries where replacementWordTxt = &#63; and localeCode = &#63; from the database.
	*
	* @param replacementWordTxt the replacement word txt
	* @param localeCode the locale code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByReplacementWordTxtAndLocaleCode(
		java.lang.String replacementWordTxt, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByReplacementWordTxtAndLocaleCode(replacementWordTxt,
			localeCode);
	}

	/**
	* Returns the number of special word dictionaries where replacementWordTxt = &#63; and localeCode = &#63;.
	*
	* @param replacementWordTxt the replacement word txt
	* @param localeCode the locale code
	* @return the number of matching special word dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByReplacementWordTxtAndLocaleCode(
		java.lang.String replacementWordTxt, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByReplacementWordTxtAndLocaleCode(replacementWordTxt,
			localeCode);
	}

	/**
	* Caches the special word dictionary in the entity cache if it is enabled.
	*
	* @param specialWordDictionary the special word dictionary
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.SpecialWordDictionary specialWordDictionary) {
		getPersistence().cacheResult(specialWordDictionary);
	}

	/**
	* Caches the special word dictionaries in the entity cache if it is enabled.
	*
	* @param specialWordDictionaries the special word dictionaries
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.SpecialWordDictionary> specialWordDictionaries) {
		getPersistence().cacheResult(specialWordDictionaries);
	}

	/**
	* Creates a new special word dictionary with the primary key. Does not add the special word dictionary to the database.
	*
	* @param specialWordId the primary key for the new special word dictionary
	* @return the new special word dictionary
	*/
	public static com.ihg.brandstandards.db.model.SpecialWordDictionary create(
		long specialWordId) {
		return getPersistence().create(specialWordId);
	}

	/**
	* Removes the special word dictionary with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param specialWordId the primary key of the special word dictionary
	* @return the special word dictionary that was removed
	* @throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException if a special word dictionary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpecialWordDictionary remove(
		long specialWordId)
		throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(specialWordId);
	}

	public static com.ihg.brandstandards.db.model.SpecialWordDictionary updateImpl(
		com.ihg.brandstandards.db.model.SpecialWordDictionary specialWordDictionary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(specialWordDictionary);
	}

	/**
	* Returns the special word dictionary with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException} if it could not be found.
	*
	* @param specialWordId the primary key of the special word dictionary
	* @return the special word dictionary
	* @throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException if a special word dictionary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpecialWordDictionary findByPrimaryKey(
		long specialWordId)
		throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(specialWordId);
	}

	/**
	* Returns the special word dictionary with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param specialWordId the primary key of the special word dictionary
	* @return the special word dictionary, or <code>null</code> if a special word dictionary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpecialWordDictionary fetchByPrimaryKey(
		long specialWordId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(specialWordId);
	}

	/**
	* Returns all the special word dictionaries.
	*
	* @return the special word dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.SpecialWordDictionary> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the special word dictionaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpecialWordDictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of special word dictionaries
	* @param end the upper bound of the range of special word dictionaries (not inclusive)
	* @return the range of special word dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.SpecialWordDictionary> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the special word dictionaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpecialWordDictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of special word dictionaries
	* @param end the upper bound of the range of special word dictionaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of special word dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.SpecialWordDictionary> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the special word dictionaries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of special word dictionaries.
	*
	* @return the number of special word dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SpecialWordDictionaryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SpecialWordDictionaryPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					SpecialWordDictionaryPersistence.class.getName());

			ReferenceRegistry.registerReference(SpecialWordDictionaryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SpecialWordDictionaryPersistence persistence) {
	}

	private static SpecialWordDictionaryPersistence _persistence;
}