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

import com.ihg.brandstandards.db.model.GEMStdCategory;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the g e m std category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMStdCategoryPersistenceImpl
 * @see GEMStdCategoryUtil
 * @generated
 */
public interface GEMStdCategoryPersistence extends BasePersistence<GEMStdCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GEMStdCategoryUtil} to access the g e m std category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the g e m std category where stdId = &#63; and categoryId = &#63; and templateType = &#63; and chainCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchGEMStdCategoryException} if it could not be found.
	*
	* @param stdId the std ID
	* @param categoryId the category ID
	* @param templateType the template type
	* @param chainCode the chain code
	* @return the matching g e m std category
	* @throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException if a matching g e m std category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMStdCategory findByStdCatgyMapping(
		long stdId, long categoryId, java.lang.String templateType,
		java.lang.String chainCode)
		throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m std category where stdId = &#63; and categoryId = &#63; and templateType = &#63; and chainCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param stdId the std ID
	* @param categoryId the category ID
	* @param templateType the template type
	* @param chainCode the chain code
	* @return the matching g e m std category, or <code>null</code> if a matching g e m std category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMStdCategory fetchByStdCatgyMapping(
		long stdId, long categoryId, java.lang.String templateType,
		java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m std category where stdId = &#63; and categoryId = &#63; and templateType = &#63; and chainCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param stdId the std ID
	* @param categoryId the category ID
	* @param templateType the template type
	* @param chainCode the chain code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching g e m std category, or <code>null</code> if a matching g e m std category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMStdCategory fetchByStdCatgyMapping(
		long stdId, long categoryId, java.lang.String templateType,
		java.lang.String chainCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the g e m std category where stdId = &#63; and categoryId = &#63; and templateType = &#63; and chainCode = &#63; from the database.
	*
	* @param stdId the std ID
	* @param categoryId the category ID
	* @param templateType the template type
	* @param chainCode the chain code
	* @return the g e m std category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMStdCategory removeByStdCatgyMapping(
		long stdId, long categoryId, java.lang.String templateType,
		java.lang.String chainCode)
		throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m std categories where stdId = &#63; and categoryId = &#63; and templateType = &#63; and chainCode = &#63;.
	*
	* @param stdId the std ID
	* @param categoryId the category ID
	* @param templateType the template type
	* @param chainCode the chain code
	* @return the number of matching g e m std categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByStdCatgyMapping(long stdId, long categoryId,
		java.lang.String templateType, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the g e m std categories where categoryId = &#63; and templateType = &#63; and chainCode = &#63;.
	*
	* @param categoryId the category ID
	* @param templateType the template type
	* @param chainCode the chain code
	* @return the matching g e m std categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> findByCatgyTemplateAndChain(
		long categoryId, java.lang.String templateType,
		java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the g e m std categories where categoryId = &#63; and templateType = &#63; and chainCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMStdCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param templateType the template type
	* @param chainCode the chain code
	* @param start the lower bound of the range of g e m std categories
	* @param end the upper bound of the range of g e m std categories (not inclusive)
	* @return the range of matching g e m std categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> findByCatgyTemplateAndChain(
		long categoryId, java.lang.String templateType,
		java.lang.String chainCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the g e m std categories where categoryId = &#63; and templateType = &#63; and chainCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMStdCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param templateType the template type
	* @param chainCode the chain code
	* @param start the lower bound of the range of g e m std categories
	* @param end the upper bound of the range of g e m std categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g e m std categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> findByCatgyTemplateAndChain(
		long categoryId, java.lang.String templateType,
		java.lang.String chainCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g e m std category in the ordered set where categoryId = &#63; and templateType = &#63; and chainCode = &#63;.
	*
	* @param categoryId the category ID
	* @param templateType the template type
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m std category
	* @throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException if a matching g e m std category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMStdCategory findByCatgyTemplateAndChain_First(
		long categoryId, java.lang.String templateType,
		java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g e m std category in the ordered set where categoryId = &#63; and templateType = &#63; and chainCode = &#63;.
	*
	* @param categoryId the category ID
	* @param templateType the template type
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m std category, or <code>null</code> if a matching g e m std category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMStdCategory fetchByCatgyTemplateAndChain_First(
		long categoryId, java.lang.String templateType,
		java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g e m std category in the ordered set where categoryId = &#63; and templateType = &#63; and chainCode = &#63;.
	*
	* @param categoryId the category ID
	* @param templateType the template type
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m std category
	* @throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException if a matching g e m std category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMStdCategory findByCatgyTemplateAndChain_Last(
		long categoryId, java.lang.String templateType,
		java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g e m std category in the ordered set where categoryId = &#63; and templateType = &#63; and chainCode = &#63;.
	*
	* @param categoryId the category ID
	* @param templateType the template type
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m std category, or <code>null</code> if a matching g e m std category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMStdCategory fetchByCatgyTemplateAndChain_Last(
		long categoryId, java.lang.String templateType,
		java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m std categories before and after the current g e m std category in the ordered set where categoryId = &#63; and templateType = &#63; and chainCode = &#63;.
	*
	* @param gemStdCategoryId the primary key of the current g e m std category
	* @param categoryId the category ID
	* @param templateType the template type
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g e m std category
	* @throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException if a g e m std category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMStdCategory[] findByCatgyTemplateAndChain_PrevAndNext(
		long gemStdCategoryId, long categoryId, java.lang.String templateType,
		java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the g e m std categories where categoryId = &#63; and templateType = &#63; and chainCode = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param templateType the template type
	* @param chainCode the chain code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCatgyTemplateAndChain(long categoryId,
		java.lang.String templateType, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m std categories where categoryId = &#63; and templateType = &#63; and chainCode = &#63;.
	*
	* @param categoryId the category ID
	* @param templateType the template type
	* @param chainCode the chain code
	* @return the number of matching g e m std categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCatgyTemplateAndChain(long categoryId,
		java.lang.String templateType, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the g e m std categories where categoryId = &#63; and chainCode = &#63;.
	*
	* @param categoryId the category ID
	* @param chainCode the chain code
	* @return the matching g e m std categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> findByCatgyAndChain(
		long categoryId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the g e m std categories where categoryId = &#63; and chainCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMStdCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param chainCode the chain code
	* @param start the lower bound of the range of g e m std categories
	* @param end the upper bound of the range of g e m std categories (not inclusive)
	* @return the range of matching g e m std categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> findByCatgyAndChain(
		long categoryId, java.lang.String chainCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the g e m std categories where categoryId = &#63; and chainCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMStdCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param chainCode the chain code
	* @param start the lower bound of the range of g e m std categories
	* @param end the upper bound of the range of g e m std categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g e m std categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> findByCatgyAndChain(
		long categoryId, java.lang.String chainCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g e m std category in the ordered set where categoryId = &#63; and chainCode = &#63;.
	*
	* @param categoryId the category ID
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m std category
	* @throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException if a matching g e m std category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMStdCategory findByCatgyAndChain_First(
		long categoryId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g e m std category in the ordered set where categoryId = &#63; and chainCode = &#63;.
	*
	* @param categoryId the category ID
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m std category, or <code>null</code> if a matching g e m std category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMStdCategory fetchByCatgyAndChain_First(
		long categoryId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g e m std category in the ordered set where categoryId = &#63; and chainCode = &#63;.
	*
	* @param categoryId the category ID
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m std category
	* @throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException if a matching g e m std category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMStdCategory findByCatgyAndChain_Last(
		long categoryId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g e m std category in the ordered set where categoryId = &#63; and chainCode = &#63;.
	*
	* @param categoryId the category ID
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m std category, or <code>null</code> if a matching g e m std category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMStdCategory fetchByCatgyAndChain_Last(
		long categoryId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m std categories before and after the current g e m std category in the ordered set where categoryId = &#63; and chainCode = &#63;.
	*
	* @param gemStdCategoryId the primary key of the current g e m std category
	* @param categoryId the category ID
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g e m std category
	* @throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException if a g e m std category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMStdCategory[] findByCatgyAndChain_PrevAndNext(
		long gemStdCategoryId, long categoryId, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the g e m std categories where categoryId = &#63; and chainCode = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param chainCode the chain code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCatgyAndChain(long categoryId,
		java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m std categories where categoryId = &#63; and chainCode = &#63;.
	*
	* @param categoryId the category ID
	* @param chainCode the chain code
	* @return the number of matching g e m std categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCatgyAndChain(long categoryId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the g e m std categories where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the matching g e m std categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> findByCategoryId(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the g e m std categories where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMStdCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of g e m std categories
	* @param end the upper bound of the range of g e m std categories (not inclusive)
	* @return the range of matching g e m std categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> findByCategoryId(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the g e m std categories where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMStdCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of g e m std categories
	* @param end the upper bound of the range of g e m std categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g e m std categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> findByCategoryId(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g e m std category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m std category
	* @throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException if a matching g e m std category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMStdCategory findByCategoryId_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g e m std category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m std category, or <code>null</code> if a matching g e m std category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMStdCategory fetchByCategoryId_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g e m std category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m std category
	* @throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException if a matching g e m std category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMStdCategory findByCategoryId_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g e m std category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m std category, or <code>null</code> if a matching g e m std category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMStdCategory fetchByCategoryId_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m std categories before and after the current g e m std category in the ordered set where categoryId = &#63;.
	*
	* @param gemStdCategoryId the primary key of the current g e m std category
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g e m std category
	* @throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException if a g e m std category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMStdCategory[] findByCategoryId_PrevAndNext(
		long gemStdCategoryId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the g e m std categories where categoryId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryId(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m std categories where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the number of matching g e m std categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryId(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the g e m std category in the entity cache if it is enabled.
	*
	* @param gemStdCategory the g e m std category
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.GEMStdCategory gemStdCategory);

	/**
	* Caches the g e m std categories in the entity cache if it is enabled.
	*
	* @param gemStdCategories the g e m std categories
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> gemStdCategories);

	/**
	* Creates a new g e m std category with the primary key. Does not add the g e m std category to the database.
	*
	* @param gemStdCategoryId the primary key for the new g e m std category
	* @return the new g e m std category
	*/
	public com.ihg.brandstandards.db.model.GEMStdCategory create(
		long gemStdCategoryId);

	/**
	* Removes the g e m std category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param gemStdCategoryId the primary key of the g e m std category
	* @return the g e m std category that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException if a g e m std category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMStdCategory remove(
		long gemStdCategoryId)
		throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.GEMStdCategory updateImpl(
		com.ihg.brandstandards.db.model.GEMStdCategory gemStdCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m std category with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMStdCategoryException} if it could not be found.
	*
	* @param gemStdCategoryId the primary key of the g e m std category
	* @return the g e m std category
	* @throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException if a g e m std category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMStdCategory findByPrimaryKey(
		long gemStdCategoryId)
		throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m std category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param gemStdCategoryId the primary key of the g e m std category
	* @return the g e m std category, or <code>null</code> if a g e m std category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMStdCategory fetchByPrimaryKey(
		long gemStdCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the g e m std categories.
	*
	* @return the g e m std categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the g e m std categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMStdCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m std categories
	* @param end the upper bound of the range of g e m std categories (not inclusive)
	* @return the range of g e m std categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the g e m std categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMStdCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m std categories
	* @param end the upper bound of the range of g e m std categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of g e m std categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the g e m std categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m std categories.
	*
	* @return the number of g e m std categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}