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

import com.ihg.brandstandards.db.model.FlagCategory;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the flag category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see FlagCategoryPersistenceImpl
 * @see FlagCategoryUtil
 * @generated
 */
public interface FlagCategoryPersistence extends BasePersistence<FlagCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FlagCategoryUtil} to access the flag category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the flag categories where parentCatId = &#63; and activeInd = &#63;.
	*
	* @param parentCatId the parent cat ID
	* @param activeInd the active ind
	* @return the matching flag categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.FlagCategory> findByparentCatId(
		long parentCatId, java.lang.String activeInd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the flag categories where parentCatId = &#63; and activeInd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentCatId the parent cat ID
	* @param activeInd the active ind
	* @param start the lower bound of the range of flag categories
	* @param end the upper bound of the range of flag categories (not inclusive)
	* @return the range of matching flag categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.FlagCategory> findByparentCatId(
		long parentCatId, java.lang.String activeInd, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the flag categories where parentCatId = &#63; and activeInd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentCatId the parent cat ID
	* @param activeInd the active ind
	* @param start the lower bound of the range of flag categories
	* @param end the upper bound of the range of flag categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching flag categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.FlagCategory> findByparentCatId(
		long parentCatId, java.lang.String activeInd, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first flag category in the ordered set where parentCatId = &#63; and activeInd = &#63;.
	*
	* @param parentCatId the parent cat ID
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flag category
	* @throws com.ihg.brandstandards.db.NoSuchFlagCategoryException if a matching flag category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.FlagCategory findByparentCatId_First(
		long parentCatId, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchFlagCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first flag category in the ordered set where parentCatId = &#63; and activeInd = &#63;.
	*
	* @param parentCatId the parent cat ID
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flag category, or <code>null</code> if a matching flag category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.FlagCategory fetchByparentCatId_First(
		long parentCatId, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last flag category in the ordered set where parentCatId = &#63; and activeInd = &#63;.
	*
	* @param parentCatId the parent cat ID
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flag category
	* @throws com.ihg.brandstandards.db.NoSuchFlagCategoryException if a matching flag category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.FlagCategory findByparentCatId_Last(
		long parentCatId, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchFlagCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last flag category in the ordered set where parentCatId = &#63; and activeInd = &#63;.
	*
	* @param parentCatId the parent cat ID
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flag category, or <code>null</code> if a matching flag category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.FlagCategory fetchByparentCatId_Last(
		long parentCatId, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flag categories before and after the current flag category in the ordered set where parentCatId = &#63; and activeInd = &#63;.
	*
	* @param flagCategoryPK the primary key of the current flag category
	* @param parentCatId the parent cat ID
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next flag category
	* @throws com.ihg.brandstandards.db.NoSuchFlagCategoryException if a flag category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.FlagCategory[] findByparentCatId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.FlagCategoryPK flagCategoryPK,
		long parentCatId, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchFlagCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the flag categories where parentCatId = &#63; and activeInd = &#63; from the database.
	*
	* @param parentCatId the parent cat ID
	* @param activeInd the active ind
	* @throws SystemException if a system exception occurred
	*/
	public void removeByparentCatId(long parentCatId, java.lang.String activeInd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of flag categories where parentCatId = &#63; and activeInd = &#63;.
	*
	* @param parentCatId the parent cat ID
	* @param activeInd the active ind
	* @return the number of matching flag categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByparentCatId(long parentCatId, java.lang.String activeInd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the flag categories where catOrField = &#63; and activeInd = &#63;.
	*
	* @param catOrField the cat or field
	* @param activeInd the active ind
	* @return the matching flag categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.FlagCategory> findBycatOrField(
		java.lang.String catOrField, java.lang.String activeInd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the flag categories where catOrField = &#63; and activeInd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param catOrField the cat or field
	* @param activeInd the active ind
	* @param start the lower bound of the range of flag categories
	* @param end the upper bound of the range of flag categories (not inclusive)
	* @return the range of matching flag categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.FlagCategory> findBycatOrField(
		java.lang.String catOrField, java.lang.String activeInd, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the flag categories where catOrField = &#63; and activeInd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param catOrField the cat or field
	* @param activeInd the active ind
	* @param start the lower bound of the range of flag categories
	* @param end the upper bound of the range of flag categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching flag categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.FlagCategory> findBycatOrField(
		java.lang.String catOrField, java.lang.String activeInd, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first flag category in the ordered set where catOrField = &#63; and activeInd = &#63;.
	*
	* @param catOrField the cat or field
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flag category
	* @throws com.ihg.brandstandards.db.NoSuchFlagCategoryException if a matching flag category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.FlagCategory findBycatOrField_First(
		java.lang.String catOrField, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchFlagCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first flag category in the ordered set where catOrField = &#63; and activeInd = &#63;.
	*
	* @param catOrField the cat or field
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flag category, or <code>null</code> if a matching flag category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.FlagCategory fetchBycatOrField_First(
		java.lang.String catOrField, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last flag category in the ordered set where catOrField = &#63; and activeInd = &#63;.
	*
	* @param catOrField the cat or field
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flag category
	* @throws com.ihg.brandstandards.db.NoSuchFlagCategoryException if a matching flag category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.FlagCategory findBycatOrField_Last(
		java.lang.String catOrField, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchFlagCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last flag category in the ordered set where catOrField = &#63; and activeInd = &#63;.
	*
	* @param catOrField the cat or field
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flag category, or <code>null</code> if a matching flag category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.FlagCategory fetchBycatOrField_Last(
		java.lang.String catOrField, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flag categories before and after the current flag category in the ordered set where catOrField = &#63; and activeInd = &#63;.
	*
	* @param flagCategoryPK the primary key of the current flag category
	* @param catOrField the cat or field
	* @param activeInd the active ind
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next flag category
	* @throws com.ihg.brandstandards.db.NoSuchFlagCategoryException if a flag category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.FlagCategory[] findBycatOrField_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.FlagCategoryPK flagCategoryPK,
		java.lang.String catOrField, java.lang.String activeInd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchFlagCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the flag categories where catOrField = &#63; and activeInd = &#63; from the database.
	*
	* @param catOrField the cat or field
	* @param activeInd the active ind
	* @throws SystemException if a system exception occurred
	*/
	public void removeBycatOrField(java.lang.String catOrField,
		java.lang.String activeInd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of flag categories where catOrField = &#63; and activeInd = &#63;.
	*
	* @param catOrField the cat or field
	* @param activeInd the active ind
	* @return the number of matching flag categories
	* @throws SystemException if a system exception occurred
	*/
	public int countBycatOrField(java.lang.String catOrField,
		java.lang.String activeInd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the flag category in the entity cache if it is enabled.
	*
	* @param flagCategory the flag category
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.FlagCategory flagCategory);

	/**
	* Caches the flag categories in the entity cache if it is enabled.
	*
	* @param flagCategories the flag categories
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.FlagCategory> flagCategories);

	/**
	* Creates a new flag category with the primary key. Does not add the flag category to the database.
	*
	* @param flagCategoryPK the primary key for the new flag category
	* @return the new flag category
	*/
	public com.ihg.brandstandards.db.model.FlagCategory create(
		com.ihg.brandstandards.db.service.persistence.FlagCategoryPK flagCategoryPK);

	/**
	* Removes the flag category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param flagCategoryPK the primary key of the flag category
	* @return the flag category that was removed
	* @throws com.ihg.brandstandards.db.NoSuchFlagCategoryException if a flag category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.FlagCategory remove(
		com.ihg.brandstandards.db.service.persistence.FlagCategoryPK flagCategoryPK)
		throws com.ihg.brandstandards.db.NoSuchFlagCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.FlagCategory updateImpl(
		com.ihg.brandstandards.db.model.FlagCategory flagCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flag category with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchFlagCategoryException} if it could not be found.
	*
	* @param flagCategoryPK the primary key of the flag category
	* @return the flag category
	* @throws com.ihg.brandstandards.db.NoSuchFlagCategoryException if a flag category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.FlagCategory findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.FlagCategoryPK flagCategoryPK)
		throws com.ihg.brandstandards.db.NoSuchFlagCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flag category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param flagCategoryPK the primary key of the flag category
	* @return the flag category, or <code>null</code> if a flag category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.FlagCategory fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.FlagCategoryPK flagCategoryPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the flag categories.
	*
	* @return the flag categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.FlagCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the flag categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flag categories
	* @param end the upper bound of the range of flag categories (not inclusive)
	* @return the range of flag categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.FlagCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the flag categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flag categories
	* @param end the upper bound of the range of flag categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of flag categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.FlagCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the flag categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of flag categories.
	*
	* @return the number of flag categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}