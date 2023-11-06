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

import com.ihg.brandstandards.db.model.UIElement;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the u i element service. This utility wraps {@link UIElementPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see UIElementPersistence
 * @see UIElementPersistenceImpl
 * @generated
 */
public class UIElementUtil {
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
	public static void clearCache(UIElement uiElement) {
		getPersistence().clearCache(uiElement);
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
	public static List<UIElement> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UIElement> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UIElement> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static UIElement update(UIElement uiElement)
		throws SystemException {
		return getPersistence().update(uiElement);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static UIElement update(UIElement uiElement,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(uiElement, serviceContext);
	}

	/**
	* Returns the u i element where elementKey = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchUIElementException} if it could not be found.
	*
	* @param elementKey the element key
	* @return the matching u i element
	* @throws com.ihg.brandstandards.db.NoSuchUIElementException if a matching u i element could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UIElement findByElementKey(
		java.lang.String elementKey)
		throws com.ihg.brandstandards.db.NoSuchUIElementException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByElementKey(elementKey);
	}

	/**
	* Returns the u i element where elementKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param elementKey the element key
	* @return the matching u i element, or <code>null</code> if a matching u i element could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UIElement fetchByElementKey(
		java.lang.String elementKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByElementKey(elementKey);
	}

	/**
	* Returns the u i element where elementKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param elementKey the element key
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching u i element, or <code>null</code> if a matching u i element could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UIElement fetchByElementKey(
		java.lang.String elementKey, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByElementKey(elementKey, retrieveFromCache);
	}

	/**
	* Removes the u i element where elementKey = &#63; from the database.
	*
	* @param elementKey the element key
	* @return the u i element that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UIElement removeByElementKey(
		java.lang.String elementKey)
		throws com.ihg.brandstandards.db.NoSuchUIElementException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByElementKey(elementKey);
	}

	/**
	* Returns the number of u i elements where elementKey = &#63;.
	*
	* @param elementKey the element key
	* @return the number of matching u i elements
	* @throws SystemException if a system exception occurred
	*/
	public static int countByElementKey(java.lang.String elementKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByElementKey(elementKey);
	}

	/**
	* Returns all the u i elements where moduleName = &#63;.
	*
	* @param moduleName the module name
	* @return the matching u i elements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.UIElement> findByModuleName(
		java.lang.String moduleName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByModuleName(moduleName);
	}

	/**
	* Returns a range of all the u i elements where moduleName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UIElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param moduleName the module name
	* @param start the lower bound of the range of u i elements
	* @param end the upper bound of the range of u i elements (not inclusive)
	* @return the range of matching u i elements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.UIElement> findByModuleName(
		java.lang.String moduleName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByModuleName(moduleName, start, end);
	}

	/**
	* Returns an ordered range of all the u i elements where moduleName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UIElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param moduleName the module name
	* @param start the lower bound of the range of u i elements
	* @param end the upper bound of the range of u i elements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching u i elements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.UIElement> findByModuleName(
		java.lang.String moduleName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleName(moduleName, start, end, orderByComparator);
	}

	/**
	* Returns the first u i element in the ordered set where moduleName = &#63;.
	*
	* @param moduleName the module name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching u i element
	* @throws com.ihg.brandstandards.db.NoSuchUIElementException if a matching u i element could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UIElement findByModuleName_First(
		java.lang.String moduleName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchUIElementException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleName_First(moduleName, orderByComparator);
	}

	/**
	* Returns the first u i element in the ordered set where moduleName = &#63;.
	*
	* @param moduleName the module name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching u i element, or <code>null</code> if a matching u i element could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UIElement fetchByModuleName_First(
		java.lang.String moduleName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByModuleName_First(moduleName, orderByComparator);
	}

	/**
	* Returns the last u i element in the ordered set where moduleName = &#63;.
	*
	* @param moduleName the module name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching u i element
	* @throws com.ihg.brandstandards.db.NoSuchUIElementException if a matching u i element could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UIElement findByModuleName_Last(
		java.lang.String moduleName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchUIElementException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleName_Last(moduleName, orderByComparator);
	}

	/**
	* Returns the last u i element in the ordered set where moduleName = &#63;.
	*
	* @param moduleName the module name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching u i element, or <code>null</code> if a matching u i element could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UIElement fetchByModuleName_Last(
		java.lang.String moduleName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByModuleName_Last(moduleName, orderByComparator);
	}

	/**
	* Returns the u i elements before and after the current u i element in the ordered set where moduleName = &#63;.
	*
	* @param elementId the primary key of the current u i element
	* @param moduleName the module name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next u i element
	* @throws com.ihg.brandstandards.db.NoSuchUIElementException if a u i element with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UIElement[] findByModuleName_PrevAndNext(
		long elementId, java.lang.String moduleName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchUIElementException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByModuleName_PrevAndNext(elementId, moduleName,
			orderByComparator);
	}

	/**
	* Removes all the u i elements where moduleName = &#63; from the database.
	*
	* @param moduleName the module name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByModuleName(java.lang.String moduleName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByModuleName(moduleName);
	}

	/**
	* Returns the number of u i elements where moduleName = &#63;.
	*
	* @param moduleName the module name
	* @return the number of matching u i elements
	* @throws SystemException if a system exception occurred
	*/
	public static int countByModuleName(java.lang.String moduleName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByModuleName(moduleName);
	}

	/**
	* Returns the u i element where elementKey = &#63; and moduleName = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchUIElementException} if it could not be found.
	*
	* @param elementKey the element key
	* @param moduleName the module name
	* @return the matching u i element
	* @throws com.ihg.brandstandards.db.NoSuchUIElementException if a matching u i element could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UIElement findByKeyAndModuleName(
		java.lang.String elementKey, java.lang.String moduleName)
		throws com.ihg.brandstandards.db.NoSuchUIElementException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByKeyAndModuleName(elementKey, moduleName);
	}

	/**
	* Returns the u i element where elementKey = &#63; and moduleName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param elementKey the element key
	* @param moduleName the module name
	* @return the matching u i element, or <code>null</code> if a matching u i element could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UIElement fetchByKeyAndModuleName(
		java.lang.String elementKey, java.lang.String moduleName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByKeyAndModuleName(elementKey, moduleName);
	}

	/**
	* Returns the u i element where elementKey = &#63; and moduleName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param elementKey the element key
	* @param moduleName the module name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching u i element, or <code>null</code> if a matching u i element could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UIElement fetchByKeyAndModuleName(
		java.lang.String elementKey, java.lang.String moduleName,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByKeyAndModuleName(elementKey, moduleName,
			retrieveFromCache);
	}

	/**
	* Removes the u i element where elementKey = &#63; and moduleName = &#63; from the database.
	*
	* @param elementKey the element key
	* @param moduleName the module name
	* @return the u i element that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UIElement removeByKeyAndModuleName(
		java.lang.String elementKey, java.lang.String moduleName)
		throws com.ihg.brandstandards.db.NoSuchUIElementException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByKeyAndModuleName(elementKey, moduleName);
	}

	/**
	* Returns the number of u i elements where elementKey = &#63; and moduleName = &#63;.
	*
	* @param elementKey the element key
	* @param moduleName the module name
	* @return the number of matching u i elements
	* @throws SystemException if a system exception occurred
	*/
	public static int countByKeyAndModuleName(java.lang.String elementKey,
		java.lang.String moduleName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByKeyAndModuleName(elementKey, moduleName);
	}

	/**
	* Caches the u i element in the entity cache if it is enabled.
	*
	* @param uiElement the u i element
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.UIElement uiElement) {
		getPersistence().cacheResult(uiElement);
	}

	/**
	* Caches the u i elements in the entity cache if it is enabled.
	*
	* @param uiElements the u i elements
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.UIElement> uiElements) {
		getPersistence().cacheResult(uiElements);
	}

	/**
	* Creates a new u i element with the primary key. Does not add the u i element to the database.
	*
	* @param elementId the primary key for the new u i element
	* @return the new u i element
	*/
	public static com.ihg.brandstandards.db.model.UIElement create(
		long elementId) {
		return getPersistence().create(elementId);
	}

	/**
	* Removes the u i element with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param elementId the primary key of the u i element
	* @return the u i element that was removed
	* @throws com.ihg.brandstandards.db.NoSuchUIElementException if a u i element with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UIElement remove(
		long elementId)
		throws com.ihg.brandstandards.db.NoSuchUIElementException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(elementId);
	}

	public static com.ihg.brandstandards.db.model.UIElement updateImpl(
		com.ihg.brandstandards.db.model.UIElement uiElement)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(uiElement);
	}

	/**
	* Returns the u i element with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchUIElementException} if it could not be found.
	*
	* @param elementId the primary key of the u i element
	* @return the u i element
	* @throws com.ihg.brandstandards.db.NoSuchUIElementException if a u i element with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UIElement findByPrimaryKey(
		long elementId)
		throws com.ihg.brandstandards.db.NoSuchUIElementException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(elementId);
	}

	/**
	* Returns the u i element with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param elementId the primary key of the u i element
	* @return the u i element, or <code>null</code> if a u i element with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UIElement fetchByPrimaryKey(
		long elementId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(elementId);
	}

	/**
	* Returns all the u i elements.
	*
	* @return the u i elements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.UIElement> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the u i elements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UIElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of u i elements
	* @param end the upper bound of the range of u i elements (not inclusive)
	* @return the range of u i elements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.UIElement> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the u i elements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UIElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of u i elements
	* @param end the upper bound of the range of u i elements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of u i elements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.UIElement> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the u i elements from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of u i elements.
	*
	* @return the number of u i elements
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UIElementPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UIElementPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					UIElementPersistence.class.getName());

			ReferenceRegistry.registerReference(UIElementUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(UIElementPersistence persistence) {
	}

	private static UIElementPersistence _persistence;
}