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

import com.ihg.brandstandards.db.model.BridgePublishPreview;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the bridge publish preview service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgePublishPreviewPersistenceImpl
 * @see BridgePublishPreviewUtil
 * @generated
 */
public interface BridgePublishPreviewPersistence extends BasePersistence<BridgePublishPreview> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BridgePublishPreviewUtil} to access the bridge publish preview persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the bridge publish preview in the entity cache if it is enabled.
	*
	* @param bridgePublishPreview the bridge publish preview
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.BridgePublishPreview bridgePublishPreview);

	/**
	* Caches the bridge publish previews in the entity cache if it is enabled.
	*
	* @param bridgePublishPreviews the bridge publish previews
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.BridgePublishPreview> bridgePublishPreviews);

	/**
	* Creates a new bridge publish preview with the primary key. Does not add the bridge publish preview to the database.
	*
	* @param stdId the primary key for the new bridge publish preview
	* @return the new bridge publish preview
	*/
	public com.ihg.brandstandards.db.model.BridgePublishPreview create(
		long stdId);

	/**
	* Removes the bridge publish preview with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stdId the primary key of the bridge publish preview
	* @return the bridge publish preview that was removed
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishPreviewException if a bridge publish preview with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishPreview remove(
		long stdId)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishPreviewException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.BridgePublishPreview updateImpl(
		com.ihg.brandstandards.db.model.BridgePublishPreview bridgePublishPreview)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publish preview with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgePublishPreviewException} if it could not be found.
	*
	* @param stdId the primary key of the bridge publish preview
	* @return the bridge publish preview
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishPreviewException if a bridge publish preview with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishPreview findByPrimaryKey(
		long stdId)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishPreviewException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publish preview with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param stdId the primary key of the bridge publish preview
	* @return the bridge publish preview, or <code>null</code> if a bridge publish preview with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishPreview fetchByPrimaryKey(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bridge publish previews.
	*
	* @return the bridge publish previews
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishPreview> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bridge publish previews.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishPreviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge publish previews
	* @param end the upper bound of the range of bridge publish previews (not inclusive)
	* @return the range of bridge publish previews
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishPreview> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bridge publish previews.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishPreviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge publish previews
	* @param end the upper bound of the range of bridge publish previews (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bridge publish previews
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishPreview> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bridge publish previews from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge publish previews.
	*
	* @return the number of bridge publish previews
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}