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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the g e m template category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMTemplateCategoryPersistenceImpl
 * @see GEMTemplateCategoryUtil
 * @generated
 */
public interface GEMTemplateCategoryPersistence extends BasePersistence<GEMTemplateCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GEMTemplateCategoryUtil} to access the g e m template category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the g e m template categories where templateId = &#63;.
	*
	* @param templateId the template ID
	* @return the matching g e m template categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplateCategory> findByTemplateId(
		long templateId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplateCategory> findByTemplateId(
		long templateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplateCategory> findByTemplateId(
		long templateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g e m template category in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template category
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException if a matching g e m template category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplateCategory findByTemplateId_First(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g e m template category in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template category, or <code>null</code> if a matching g e m template category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplateCategory fetchByTemplateId_First(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g e m template category in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template category
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException if a matching g e m template category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplateCategory findByTemplateId_Last(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g e m template category in the ordered set where templateId = &#63;.
	*
	* @param templateId the template ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template category, or <code>null</code> if a matching g e m template category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplateCategory fetchByTemplateId_Last(
		long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.GEMTemplateCategory[] findByTemplateId_PrevAndNext(
		long templateCatgyId, long templateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the g e m template categories where templateId = &#63; from the database.
	*
	* @param templateId the template ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTemplateId(long templateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m template categories where templateId = &#63;.
	*
	* @param templateId the template ID
	* @return the number of matching g e m template categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByTemplateId(long templateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the g e m template category in the entity cache if it is enabled.
	*
	* @param gemTemplateCategory the g e m template category
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.GEMTemplateCategory gemTemplateCategory);

	/**
	* Caches the g e m template categories in the entity cache if it is enabled.
	*
	* @param gemTemplateCategories the g e m template categories
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GEMTemplateCategory> gemTemplateCategories);

	/**
	* Creates a new g e m template category with the primary key. Does not add the g e m template category to the database.
	*
	* @param templateCatgyId the primary key for the new g e m template category
	* @return the new g e m template category
	*/
	public com.ihg.brandstandards.db.model.GEMTemplateCategory create(
		long templateCatgyId);

	/**
	* Removes the g e m template category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param templateCatgyId the primary key of the g e m template category
	* @return the g e m template category that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException if a g e m template category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplateCategory remove(
		long templateCatgyId)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.GEMTemplateCategory updateImpl(
		com.ihg.brandstandards.db.model.GEMTemplateCategory gemTemplateCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m template category with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException} if it could not be found.
	*
	* @param templateCatgyId the primary key of the g e m template category
	* @return the g e m template category
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException if a g e m template category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplateCategory findByPrimaryKey(
		long templateCatgyId)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m template category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param templateCatgyId the primary key of the g e m template category
	* @return the g e m template category, or <code>null</code> if a g e m template category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplateCategory fetchByPrimaryKey(
		long templateCatgyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the g e m template categories.
	*
	* @return the g e m template categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplateCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplateCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplateCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the g e m template categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m template categories.
	*
	* @return the number of g e m template categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}