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

import com.ihg.brandstandards.db.model.GEMTemplateCategory;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the g e m template category service. This utility wraps {@link GEMTemplateCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMTemplateCategoryPersistence
 * @see GEMTemplateCategoryPersistenceImpl
 * @generated
 */
public class GEMTemplateCategoryUtil {
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
	public static void clearCache(GEMTemplateCategory gemTemplateCategory) {
		getPersistence().clearCache(gemTemplateCategory);
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
	public static List<GEMTemplateCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GEMTemplateCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GEMTemplateCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GEMTemplateCategory update(
		GEMTemplateCategory gemTemplateCategory) throws SystemException {
		return getPersistence().update(gemTemplateCategory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GEMTemplateCategory update(
		GEMTemplateCategory gemTemplateCategory, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(gemTemplateCategory, serviceContext);
	}

	/**
	* Returns all the g e m template categories where templateId = &#63;.
	*
	* @param templateId the template ID
	* @return the matching g e m template categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplateCategory> findByTemplateId(
		long templateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTemplateId(templateId);
	}

	/**
	* Returns a range of all the g e m template categories where templateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templateId the template ID
	* @param start the lower bound of the range of g e m template categories
	* @param end the upper bound of the range of g e m template categories (not inclusive)
	* @return the range of matching g e m template categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplateCategory> findByTemplateId(
		long templateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTemplateId(templateId, start, end);
	}

	/**
	* Returns an ordered range of all the g e m template categories where templateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templateId the template ID
	* @param start the lower bound of the range of g e m template categories
	* @param end the upper bound of the range of g e m template categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g e m template categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplateCategory> findByTemplateId(
		long templateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateId(templateId, start, end, orderByComparator);
	}

	/**
	* Returns the first g e m template category in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template category
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException if a matching g e m template category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplateCategory findByTemplateId_First(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateId_First(templateId, orderByComparator);
	}

	/**
	* Returns the first g e m template category in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template category, or <code>null</code> if a matching g e m template category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplateCategory fetchByTemplateId_First(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplateId_First(templateId, orderByComparator);
	}

	/**
	* Returns the last g e m template category in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template category
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException if a matching g e m template category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplateCategory findByTemplateId_Last(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateId_Last(templateId, orderByComparator);
	}

	/**
	* Returns the last g e m template category in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template category, or <code>null</code> if a matching g e m template category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplateCategory fetchByTemplateId_Last(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplateId_Last(templateId, orderByComparator);
	}

	/**
	* Returns the g e m template categories before and after the current g e m template category in the ordered set where templateId = &#63;.
	*
	* @param templateCatgyId the primary key of the current g e m template category
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g e m template category
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException if a g e m template category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplateCategory[] findByTemplateId_PrevAndNext(
		long templateCatgyId, long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateId_PrevAndNext(templateCatgyId, templateId,
			orderByComparator);
	}

	/**
	* Removes all the g e m template categories where templateId = &#63; from the database.
	*
	* @param templateId the template ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTemplateId(long templateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTemplateId(templateId);
	}

	/**
	* Returns the number of g e m template categories where templateId = &#63;.
	*
	* @param templateId the template ID
	* @return the number of matching g e m template categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTemplateId(long templateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTemplateId(templateId);
	}

	/**
	* Caches the g e m template category in the entity cache if it is enabled.
	*
	* @param gemTemplateCategory the g e m template category
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.GEMTemplateCategory gemTemplateCategory) {
		getPersistence().cacheResult(gemTemplateCategory);
	}

	/**
	* Caches the g e m template categories in the entity cache if it is enabled.
	*
	* @param gemTemplateCategories the g e m template categories
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GEMTemplateCategory> gemTemplateCategories) {
		getPersistence().cacheResult(gemTemplateCategories);
	}

	/**
	* Creates a new g e m template category with the primary key. Does not add the g e m template category to the database.
	*
	* @param templateCatgyId the primary key for the new g e m template category
	* @return the new g e m template category
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplateCategory create(
		long templateCatgyId) {
		return getPersistence().create(templateCatgyId);
	}

	/**
	* Removes the g e m template category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param templateCatgyId the primary key of the g e m template category
	* @return the g e m template category that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException if a g e m template category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplateCategory remove(
		long templateCatgyId)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(templateCatgyId);
	}

	public static com.ihg.brandstandards.db.model.GEMTemplateCategory updateImpl(
		com.ihg.brandstandards.db.model.GEMTemplateCategory gemTemplateCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(gemTemplateCategory);
	}

	/**
	* Returns the g e m template category with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException} if it could not be found.
	*
	* @param templateCatgyId the primary key of the g e m template category
	* @return the g e m template category
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException if a g e m template category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplateCategory findByPrimaryKey(
		long templateCatgyId)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(templateCatgyId);
	}

	/**
	* Returns the g e m template category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param templateCatgyId the primary key of the g e m template category
	* @return the g e m template category, or <code>null</code> if a g e m template category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplateCategory fetchByPrimaryKey(
		long templateCatgyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(templateCatgyId);
	}

	/**
	* Returns all the g e m template categories.
	*
	* @return the g e m template categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplateCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the g e m template categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m template categories
	* @param end the upper bound of the range of g e m template categories (not inclusive)
	* @return the range of g e m template categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplateCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the g e m template categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m template categories
	* @param end the upper bound of the range of g e m template categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of g e m template categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplateCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the g e m template categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of g e m template categories.
	*
	* @return the number of g e m template categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GEMTemplateCategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GEMTemplateCategoryPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					GEMTemplateCategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(GEMTemplateCategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GEMTemplateCategoryPersistence persistence) {
	}

	private static GEMTemplateCategoryPersistence _persistence;
}