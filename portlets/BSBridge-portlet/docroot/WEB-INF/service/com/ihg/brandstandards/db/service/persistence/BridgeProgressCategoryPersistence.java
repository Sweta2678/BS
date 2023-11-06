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

import com.ihg.brandstandards.db.model.BridgeProgressCategory;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the bridge progress category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgeProgressCategoryPersistenceImpl
 * @see BridgeProgressCategoryUtil
 * @generated
 */
public interface BridgeProgressCategoryPersistence extends BasePersistence<BridgeProgressCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BridgeProgressCategoryUtil} to access the bridge progress category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the bridge progress category where progressCategoryName = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBridgeProgressCategoryException} if it could not be found.
	*
	* @param progressCategoryName the progress category name
	* @return the matching bridge progress category
	* @throws com.ihg.brandstandards.db.NoSuchBridgeProgressCategoryException if a matching bridge progress category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressCategory findByprogressCategoryName(
		java.lang.String progressCategoryName)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge progress category where progressCategoryName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param progressCategoryName the progress category name
	* @return the matching bridge progress category, or <code>null</code> if a matching bridge progress category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressCategory fetchByprogressCategoryName(
		java.lang.String progressCategoryName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge progress category where progressCategoryName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param progressCategoryName the progress category name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching bridge progress category, or <code>null</code> if a matching bridge progress category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressCategory fetchByprogressCategoryName(
		java.lang.String progressCategoryName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the bridge progress category where progressCategoryName = &#63; from the database.
	*
	* @param progressCategoryName the progress category name
	* @return the bridge progress category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressCategory removeByprogressCategoryName(
		java.lang.String progressCategoryName)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge progress categories where progressCategoryName = &#63;.
	*
	* @param progressCategoryName the progress category name
	* @return the number of matching bridge progress categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByprogressCategoryName(
		java.lang.String progressCategoryName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the bridge progress category in the entity cache if it is enabled.
	*
	* @param bridgeProgressCategory the bridge progress category
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.BridgeProgressCategory bridgeProgressCategory);

	/**
	* Caches the bridge progress categories in the entity cache if it is enabled.
	*
	* @param bridgeProgressCategories the bridge progress categories
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.BridgeProgressCategory> bridgeProgressCategories);

	/**
	* Creates a new bridge progress category with the primary key. Does not add the bridge progress category to the database.
	*
	* @param progressCategoryId the primary key for the new bridge progress category
	* @return the new bridge progress category
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressCategory create(
		long progressCategoryId);

	/**
	* Removes the bridge progress category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param progressCategoryId the primary key of the bridge progress category
	* @return the bridge progress category that was removed
	* @throws com.ihg.brandstandards.db.NoSuchBridgeProgressCategoryException if a bridge progress category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressCategory remove(
		long progressCategoryId)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.BridgeProgressCategory updateImpl(
		com.ihg.brandstandards.db.model.BridgeProgressCategory bridgeProgressCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge progress category with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgeProgressCategoryException} if it could not be found.
	*
	* @param progressCategoryId the primary key of the bridge progress category
	* @return the bridge progress category
	* @throws com.ihg.brandstandards.db.NoSuchBridgeProgressCategoryException if a bridge progress category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressCategory findByPrimaryKey(
		long progressCategoryId)
		throws com.ihg.brandstandards.db.NoSuchBridgeProgressCategoryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge progress category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param progressCategoryId the primary key of the bridge progress category
	* @return the bridge progress category, or <code>null</code> if a bridge progress category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeProgressCategory fetchByPrimaryKey(
		long progressCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bridge progress categories.
	*
	* @return the bridge progress categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgeProgressCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bridge progress categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge progress categories
	* @param end the upper bound of the range of bridge progress categories (not inclusive)
	* @return the range of bridge progress categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgeProgressCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bridge progress categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge progress categories
	* @param end the upper bound of the range of bridge progress categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bridge progress categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgeProgressCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bridge progress categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge progress categories.
	*
	* @return the number of bridge progress categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}