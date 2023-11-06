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

import com.ihg.brandstandards.db.model.UIElementTranslate;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the u i element translate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see UIElementTranslatePersistenceImpl
 * @see UIElementTranslateUtil
 * @generated
 */
public interface UIElementTranslatePersistence extends BasePersistence<UIElementTranslate> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UIElementTranslateUtil} to access the u i element translate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the u i element translates where elementId = &#63;.
	*
	* @param elementId the element ID
	* @return the matching u i element translates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.UIElementTranslate> findByElementId(
		long elementId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the u i element translates where elementId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UIElementTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param elementId the element ID
	* @param start the lower bound of the range of u i element translates
	* @param end the upper bound of the range of u i element translates (not inclusive)
	* @return the range of matching u i element translates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.UIElementTranslate> findByElementId(
		long elementId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the u i element translates where elementId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UIElementTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param elementId the element ID
	* @param start the lower bound of the range of u i element translates
	* @param end the upper bound of the range of u i element translates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching u i element translates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.UIElementTranslate> findByElementId(
		long elementId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first u i element translate in the ordered set where elementId = &#63;.
	*
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching u i element translate
	* @throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException if a matching u i element translate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UIElementTranslate findByElementId_First(
		long elementId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first u i element translate in the ordered set where elementId = &#63;.
	*
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching u i element translate, or <code>null</code> if a matching u i element translate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UIElementTranslate fetchByElementId_First(
		long elementId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last u i element translate in the ordered set where elementId = &#63;.
	*
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching u i element translate
	* @throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException if a matching u i element translate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UIElementTranslate findByElementId_Last(
		long elementId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last u i element translate in the ordered set where elementId = &#63;.
	*
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching u i element translate, or <code>null</code> if a matching u i element translate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UIElementTranslate fetchByElementId_Last(
		long elementId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the u i element translates before and after the current u i element translate in the ordered set where elementId = &#63;.
	*
	* @param uiElementTranslatePK the primary key of the current u i element translate
	* @param elementId the element ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next u i element translate
	* @throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException if a u i element translate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UIElementTranslate[] findByElementId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.UIElementTranslatePK uiElementTranslatePK,
		long elementId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the u i element translates where elementId = &#63; from the database.
	*
	* @param elementId the element ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByElementId(long elementId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of u i element translates where elementId = &#63;.
	*
	* @param elementId the element ID
	* @return the number of matching u i element translates
	* @throws SystemException if a system exception occurred
	*/
	public int countByElementId(long elementId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the u i element translates where localeCode = &#63;.
	*
	* @param localeCode the locale code
	* @return the matching u i element translates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.UIElementTranslate> findByLocaleCode(
		java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the u i element translates where localeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UIElementTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param localeCode the locale code
	* @param start the lower bound of the range of u i element translates
	* @param end the upper bound of the range of u i element translates (not inclusive)
	* @return the range of matching u i element translates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.UIElementTranslate> findByLocaleCode(
		java.lang.String localeCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the u i element translates where localeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UIElementTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param localeCode the locale code
	* @param start the lower bound of the range of u i element translates
	* @param end the upper bound of the range of u i element translates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching u i element translates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.UIElementTranslate> findByLocaleCode(
		java.lang.String localeCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first u i element translate in the ordered set where localeCode = &#63;.
	*
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching u i element translate
	* @throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException if a matching u i element translate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UIElementTranslate findByLocaleCode_First(
		java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first u i element translate in the ordered set where localeCode = &#63;.
	*
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching u i element translate, or <code>null</code> if a matching u i element translate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UIElementTranslate fetchByLocaleCode_First(
		java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last u i element translate in the ordered set where localeCode = &#63;.
	*
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching u i element translate
	* @throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException if a matching u i element translate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UIElementTranslate findByLocaleCode_Last(
		java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last u i element translate in the ordered set where localeCode = &#63;.
	*
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching u i element translate, or <code>null</code> if a matching u i element translate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UIElementTranslate fetchByLocaleCode_Last(
		java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the u i element translates before and after the current u i element translate in the ordered set where localeCode = &#63;.
	*
	* @param uiElementTranslatePK the primary key of the current u i element translate
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next u i element translate
	* @throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException if a u i element translate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UIElementTranslate[] findByLocaleCode_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.UIElementTranslatePK uiElementTranslatePK,
		java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the u i element translates where localeCode = &#63; from the database.
	*
	* @param localeCode the locale code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLocaleCode(java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of u i element translates where localeCode = &#63;.
	*
	* @param localeCode the locale code
	* @return the number of matching u i element translates
	* @throws SystemException if a system exception occurred
	*/
	public int countByLocaleCode(java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the u i element translate where elementId = &#63; and localeCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchUIElementTranslateException} if it could not be found.
	*
	* @param elementId the element ID
	* @param localeCode the locale code
	* @return the matching u i element translate
	* @throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException if a matching u i element translate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UIElementTranslate findByIdAndLocaleCode(
		long elementId, java.lang.String localeCode)
		throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the u i element translate where elementId = &#63; and localeCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param elementId the element ID
	* @param localeCode the locale code
	* @return the matching u i element translate, or <code>null</code> if a matching u i element translate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UIElementTranslate fetchByIdAndLocaleCode(
		long elementId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the u i element translate where elementId = &#63; and localeCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param elementId the element ID
	* @param localeCode the locale code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching u i element translate, or <code>null</code> if a matching u i element translate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UIElementTranslate fetchByIdAndLocaleCode(
		long elementId, java.lang.String localeCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the u i element translate where elementId = &#63; and localeCode = &#63; from the database.
	*
	* @param elementId the element ID
	* @param localeCode the locale code
	* @return the u i element translate that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UIElementTranslate removeByIdAndLocaleCode(
		long elementId, java.lang.String localeCode)
		throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of u i element translates where elementId = &#63; and localeCode = &#63;.
	*
	* @param elementId the element ID
	* @param localeCode the locale code
	* @return the number of matching u i element translates
	* @throws SystemException if a system exception occurred
	*/
	public int countByIdAndLocaleCode(long elementId,
		java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the u i element translate in the entity cache if it is enabled.
	*
	* @param uiElementTranslate the u i element translate
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.UIElementTranslate uiElementTranslate);

	/**
	* Caches the u i element translates in the entity cache if it is enabled.
	*
	* @param uiElementTranslates the u i element translates
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.UIElementTranslate> uiElementTranslates);

	/**
	* Creates a new u i element translate with the primary key. Does not add the u i element translate to the database.
	*
	* @param uiElementTranslatePK the primary key for the new u i element translate
	* @return the new u i element translate
	*/
	public com.ihg.brandstandards.db.model.UIElementTranslate create(
		com.ihg.brandstandards.db.service.persistence.UIElementTranslatePK uiElementTranslatePK);

	/**
	* Removes the u i element translate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param uiElementTranslatePK the primary key of the u i element translate
	* @return the u i element translate that was removed
	* @throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException if a u i element translate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UIElementTranslate remove(
		com.ihg.brandstandards.db.service.persistence.UIElementTranslatePK uiElementTranslatePK)
		throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.UIElementTranslate updateImpl(
		com.ihg.brandstandards.db.model.UIElementTranslate uiElementTranslate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the u i element translate with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchUIElementTranslateException} if it could not be found.
	*
	* @param uiElementTranslatePK the primary key of the u i element translate
	* @return the u i element translate
	* @throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException if a u i element translate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UIElementTranslate findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.UIElementTranslatePK uiElementTranslatePK)
		throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the u i element translate with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param uiElementTranslatePK the primary key of the u i element translate
	* @return the u i element translate, or <code>null</code> if a u i element translate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UIElementTranslate fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.UIElementTranslatePK uiElementTranslatePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the u i element translates.
	*
	* @return the u i element translates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.UIElementTranslate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the u i element translates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UIElementTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of u i element translates
	* @param end the upper bound of the range of u i element translates (not inclusive)
	* @return the range of u i element translates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.UIElementTranslate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the u i element translates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UIElementTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of u i element translates
	* @param end the upper bound of the range of u i element translates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of u i element translates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.UIElementTranslate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the u i element translates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of u i element translates.
	*
	* @return the number of u i element translates
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}