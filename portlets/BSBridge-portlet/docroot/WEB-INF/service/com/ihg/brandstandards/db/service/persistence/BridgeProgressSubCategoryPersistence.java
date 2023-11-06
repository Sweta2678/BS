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

import com.ihg.brandstandards.db.model.BridgeProgressSubCategory;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the bridge progress sub category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgeProgressSubCategoryPersistenceImpl
 * @see BridgeProgressSubCategoryUtil
 * @generated
 */
public interface BridgeProgressSubCategoryPersistence extends BasePersistence<BridgeProgressSubCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BridgeProgressSubCategoryUtil} to access the bridge progress sub category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the bridge progress sub category where progressSubCategoryId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBridgeProgressSubCategoryException} if it could not be found.
	*
	* @param progressSubCategoryId the progress sub category ID
	* @return the matching bridge progress sub category
	* @throws com.ihg.brandstandards.db.NoSuchBridgeProgressSubCategoryException if a matching bridge progress sub category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressSubCategory findBybridgeProgressSubCategoryId(
		long progressSubCategoryId)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressSubCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge progress sub category where progressSubCategoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param progressSubCategoryId the progress sub category ID
	* @return the matching bridge progress sub category, or <code>null</code> if a matching bridge progress sub category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressSubCategory fetchBybridgeProgressSubCategoryId(
		long progressSubCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge progress sub category where progressSubCategoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param progressSubCategoryId the progress sub category ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching bridge progress sub category, or <code>null</code> if a matching bridge progress sub category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressSubCategory fetchBybridgeProgressSubCategoryId(
		long progressSubCategoryId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the bridge progress sub category where progressSubCategoryId = &#63; from the database.
	*
	* @param progressSubCategoryId the progress sub category ID
	* @return the bridge progress sub category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressSubCategory removeBybridgeProgressSubCategoryId(
		long progressSubCategoryId)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressSubCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge progress sub categories where progressSubCategoryId = &#63;.
	*
	* @param progressSubCategoryId the progress sub category ID
	* @return the number of matching bridge progress sub categories
	* @throws SystemException if a system exception occurred
	*/
	public int countBybridgeProgressSubCategoryId(long progressSubCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bridge progress sub categories where progressCategoryId = &#63;.
	*
	* @param progressCategoryId the progress category ID
	* @return the matching bridge progress sub categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgeProgressSubCategory> findByprogressCategoryId(
		long progressCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bridge progress sub categories where progressCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressSubCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param progressCategoryId the progress category ID
	* @param start the lower bound of the range of bridge progress sub categories
	* @param end the upper bound of the range of bridge progress sub categories (not inclusive)
	* @return the range of matching bridge progress sub categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgeProgressSubCategory> findByprogressCategoryId(
		long progressCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bridge progress sub categories where progressCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressSubCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param progressCategoryId the progress category ID
	* @param start the lower bound of the range of bridge progress sub categories
	* @param end the upper bound of the range of bridge progress sub categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bridge progress sub categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgeProgressSubCategory> findByprogressCategoryId(
		long progressCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bridge progress sub category in the ordered set where progressCategoryId = &#63;.
	*
	* @param progressCategoryId the progress category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge progress sub category
	* @throws com.ihg.brandstandards.db.NoSuchBridgeProgressSubCategoryException if a matching bridge progress sub category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressSubCategory findByprogressCategoryId_First(
		long progressCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressSubCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bridge progress sub category in the ordered set where progressCategoryId = &#63;.
	*
	* @param progressCategoryId the progress category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge progress sub category, or <code>null</code> if a matching bridge progress sub category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressSubCategory fetchByprogressCategoryId_First(
		long progressCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bridge progress sub category in the ordered set where progressCategoryId = &#63;.
	*
	* @param progressCategoryId the progress category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge progress sub category
	* @throws com.ihg.brandstandards.db.NoSuchBridgeProgressSubCategoryException if a matching bridge progress sub category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressSubCategory findByprogressCategoryId_Last(
		long progressCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressSubCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bridge progress sub category in the ordered set where progressCategoryId = &#63;.
	*
	* @param progressCategoryId the progress category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge progress sub category, or <code>null</code> if a matching bridge progress sub category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressSubCategory fetchByprogressCategoryId_Last(
		long progressCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge progress sub categories before and after the current bridge progress sub category in the ordered set where progressCategoryId = &#63;.
	*
	* @param progressSubCategoryId the primary key of the current bridge progress sub category
	* @param progressCategoryId the progress category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bridge progress sub category
	* @throws com.ihg.brandstandards.db.NoSuchBridgeProgressSubCategoryException if a bridge progress sub category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressSubCategory[] findByprogressCategoryId_PrevAndNext(
		long progressSubCategoryId, long progressCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressSubCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bridge progress sub categories where progressCategoryId = &#63; from the database.
	*
	* @param progressCategoryId the progress category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByprogressCategoryId(long progressCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge progress sub categories where progressCategoryId = &#63;.
	*
	* @param progressCategoryId the progress category ID
	* @return the number of matching bridge progress sub categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByprogressCategoryId(long progressCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the bridge progress sub category in the entity cache if it is enabled.
	*
	* @param bridgeProgressSubCategory the bridge progress sub category
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.BridgeProgressSubCategory bridgeProgressSubCategory);

	/**
	* Caches the bridge progress sub categories in the entity cache if it is enabled.
	*
	* @param bridgeProgressSubCategories the bridge progress sub categories
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.BridgeProgressSubCategory> bridgeProgressSubCategories);

	/**
	* Creates a new bridge progress sub category with the primary key. Does not add the bridge progress sub category to the database.
	*
	* @param progressSubCategoryId the primary key for the new bridge progress sub category
	* @return the new bridge progress sub category
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressSubCategory create(
		long progressSubCategoryId);

	/**
	* Removes the bridge progress sub category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param progressSubCategoryId the primary key of the bridge progress sub category
	* @return the bridge progress sub category that was removed
	* @throws com.ihg.brandstandards.db.NoSuchBridgeProgressSubCategoryException if a bridge progress sub category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressSubCategory remove(
		long progressSubCategoryId)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressSubCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.BridgeProgressSubCategory updateImpl(
		com.ihg.brandstandards.db.model.BridgeProgressSubCategory bridgeProgressSubCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge progress sub category with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgeProgressSubCategoryException} if it could not be found.
	*
	* @param progressSubCategoryId the primary key of the bridge progress sub category
	* @return the bridge progress sub category
	* @throws com.ihg.brandstandards.db.NoSuchBridgeProgressSubCategoryException if a bridge progress sub category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressSubCategory findByPrimaryKey(
		long progressSubCategoryId)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressSubCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge progress sub category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param progressSubCategoryId the primary key of the bridge progress sub category
	* @return the bridge progress sub category, or <code>null</code> if a bridge progress sub category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressSubCategory fetchByPrimaryKey(
		long progressSubCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bridge progress sub categories.
	*
	* @return the bridge progress sub categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgeProgressSubCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bridge progress sub categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressSubCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge progress sub categories
	* @param end the upper bound of the range of bridge progress sub categories (not inclusive)
	* @return the range of bridge progress sub categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgeProgressSubCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bridge progress sub categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressSubCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge progress sub categories
	* @param end the upper bound of the range of bridge progress sub categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bridge progress sub categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgeProgressSubCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bridge progress sub categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge progress sub categories.
	*
	* @return the number of bridge progress sub categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}