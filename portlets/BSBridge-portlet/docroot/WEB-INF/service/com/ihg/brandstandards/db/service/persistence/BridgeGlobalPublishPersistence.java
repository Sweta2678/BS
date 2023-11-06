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

import com.ihg.brandstandards.db.model.BridgeGlobalPublish;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the bridge global publish service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgeGlobalPublishPersistenceImpl
 * @see BridgeGlobalPublishUtil
 * @generated
 */
public interface BridgeGlobalPublishPersistence extends BasePersistence<BridgeGlobalPublish> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BridgeGlobalPublishUtil} to access the bridge global publish persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the bridge global publish where publishId = &#63; and stdId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException} if it could not be found.
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @return the matching bridge global publish
	* @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException if a matching bridge global publish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeGlobalPublish findByPublishIdAndStdId(
		long publishId, long stdId)
		throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge global publish where publishId = &#63; and stdId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @return the matching bridge global publish, or <code>null</code> if a matching bridge global publish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeGlobalPublish fetchByPublishIdAndStdId(
		long publishId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge global publish where publishId = &#63; and stdId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching bridge global publish, or <code>null</code> if a matching bridge global publish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeGlobalPublish fetchByPublishIdAndStdId(
		long publishId, long stdId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the bridge global publish where publishId = &#63; and stdId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @return the bridge global publish that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeGlobalPublish removeByPublishIdAndStdId(
		long publishId, long stdId)
		throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge global publishs where publishId = &#63; and stdId = &#63;.
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @return the number of matching bridge global publishs
	* @throws SystemException if a system exception occurred
	*/
	public int countByPublishIdAndStdId(long publishId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge global publish where stdId = &#63; and mustPublishInd = &#63; and publishId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException} if it could not be found.
	*
	* @param stdId the std ID
	* @param mustPublishInd the must publish ind
	* @param publishId the publish ID
	* @return the matching bridge global publish
	* @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException if a matching bridge global publish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeGlobalPublish findByStdIdAndMustPublishInd(
		long stdId, java.lang.String mustPublishInd, long publishId)
		throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge global publish where stdId = &#63; and mustPublishInd = &#63; and publishId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param stdId the std ID
	* @param mustPublishInd the must publish ind
	* @param publishId the publish ID
	* @return the matching bridge global publish, or <code>null</code> if a matching bridge global publish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeGlobalPublish fetchByStdIdAndMustPublishInd(
		long stdId, java.lang.String mustPublishInd, long publishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge global publish where stdId = &#63; and mustPublishInd = &#63; and publishId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param stdId the std ID
	* @param mustPublishInd the must publish ind
	* @param publishId the publish ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching bridge global publish, or <code>null</code> if a matching bridge global publish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeGlobalPublish fetchByStdIdAndMustPublishInd(
		long stdId, java.lang.String mustPublishInd, long publishId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the bridge global publish where stdId = &#63; and mustPublishInd = &#63; and publishId = &#63; from the database.
	*
	* @param stdId the std ID
	* @param mustPublishInd the must publish ind
	* @param publishId the publish ID
	* @return the bridge global publish that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeGlobalPublish removeByStdIdAndMustPublishInd(
		long stdId, java.lang.String mustPublishInd, long publishId)
		throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge global publishs where stdId = &#63; and mustPublishInd = &#63; and publishId = &#63;.
	*
	* @param stdId the std ID
	* @param mustPublishInd the must publish ind
	* @param publishId the publish ID
	* @return the number of matching bridge global publishs
	* @throws SystemException if a system exception occurred
	*/
	public int countByStdIdAndMustPublishInd(long stdId,
		java.lang.String mustPublishInd, long publishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the bridge global publish in the entity cache if it is enabled.
	*
	* @param bridgeGlobalPublish the bridge global publish
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.BridgeGlobalPublish bridgeGlobalPublish);

	/**
	* Caches the bridge global publishs in the entity cache if it is enabled.
	*
	* @param bridgeGlobalPublishs the bridge global publishs
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublish> bridgeGlobalPublishs);

	/**
	* Creates a new bridge global publish with the primary key. Does not add the bridge global publish to the database.
	*
	* @param globalPublishId the primary key for the new bridge global publish
	* @return the new bridge global publish
	*/
	public com.ihg.brandstandards.db.model.BridgeGlobalPublish create(
		long globalPublishId);

	/**
	* Removes the bridge global publish with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param globalPublishId the primary key of the bridge global publish
	* @return the bridge global publish that was removed
	* @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException if a bridge global publish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeGlobalPublish remove(
		long globalPublishId)
		throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.BridgeGlobalPublish updateImpl(
		com.ihg.brandstandards.db.model.BridgeGlobalPublish bridgeGlobalPublish)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge global publish with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException} if it could not be found.
	*
	* @param globalPublishId the primary key of the bridge global publish
	* @return the bridge global publish
	* @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException if a bridge global publish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeGlobalPublish findByPrimaryKey(
		long globalPublishId)
		throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge global publish with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param globalPublishId the primary key of the bridge global publish
	* @return the bridge global publish, or <code>null</code> if a bridge global publish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeGlobalPublish fetchByPrimaryKey(
		long globalPublishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bridge global publishs.
	*
	* @return the bridge global publishs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublish> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bridge global publishs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge global publishs
	* @param end the upper bound of the range of bridge global publishs (not inclusive)
	* @return the range of bridge global publishs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublish> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bridge global publishs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge global publishs
	* @param end the upper bound of the range of bridge global publishs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bridge global publishs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublish> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bridge global publishs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge global publishs.
	*
	* @return the number of bridge global publishs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}