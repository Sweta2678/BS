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

import com.ihg.brandstandards.db.model.BridgePublishStatus;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the bridge publish status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgePublishStatusPersistenceImpl
 * @see BridgePublishStatusUtil
 * @generated
 */
public interface BridgePublishStatusPersistence extends BasePersistence<BridgePublishStatus> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BridgePublishStatusUtil} to access the bridge publish status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the bridge publish status in the entity cache if it is enabled.
	*
	* @param bridgePublishStatus the bridge publish status
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.BridgePublishStatus bridgePublishStatus);

	/**
	* Caches the bridge publish statuses in the entity cache if it is enabled.
	*
	* @param bridgePublishStatuses the bridge publish statuses
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.BridgePublishStatus> bridgePublishStatuses);

	/**
	* Creates a new bridge publish status with the primary key. Does not add the bridge publish status to the database.
	*
	* @param publishStatusCode the primary key for the new bridge publish status
	* @return the new bridge publish status
	*/
	public com.ihg.brandstandards.db.model.BridgePublishStatus create(
		java.lang.String publishStatusCode);

	/**
	* Removes the bridge publish status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param publishStatusCode the primary key of the bridge publish status
	* @return the bridge publish status that was removed
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishStatusException if a bridge publish status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishStatus remove(
		java.lang.String publishStatusCode)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.BridgePublishStatus updateImpl(
		com.ihg.brandstandards.db.model.BridgePublishStatus bridgePublishStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publish status with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgePublishStatusException} if it could not be found.
	*
	* @param publishStatusCode the primary key of the bridge publish status
	* @return the bridge publish status
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishStatusException if a bridge publish status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishStatus findByPrimaryKey(
		java.lang.String publishStatusCode)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishStatusException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publish status with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param publishStatusCode the primary key of the bridge publish status
	* @return the bridge publish status, or <code>null</code> if a bridge publish status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishStatus fetchByPrimaryKey(
		java.lang.String publishStatusCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bridge publish statuses.
	*
	* @return the bridge publish statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishStatus> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bridge publish statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge publish statuses
	* @param end the upper bound of the range of bridge publish statuses (not inclusive)
	* @return the range of bridge publish statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishStatus> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bridge publish statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge publish statuses
	* @param end the upper bound of the range of bridge publish statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bridge publish statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bridge publish statuses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge publish statuses.
	*
	* @return the number of bridge publish statuses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}