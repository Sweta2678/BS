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

import com.ihg.brandstandards.db.model.BridgePublish;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the bridge publish service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgePublishPersistenceImpl
 * @see BridgePublishUtil
 * @generated
 */
public interface BridgePublishPersistence extends BasePersistence<BridgePublish> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BridgePublishUtil} to access the bridge publish persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the bridge publishs where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @return the matching bridge publishs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublish> findByPublishId(
		long publishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bridge publishs where publishId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param start the lower bound of the range of bridge publishs
	* @param end the upper bound of the range of bridge publishs (not inclusive)
	* @return the range of matching bridge publishs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublish> findByPublishId(
		long publishId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bridge publishs where publishId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param start the lower bound of the range of bridge publishs
	* @param end the upper bound of the range of bridge publishs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bridge publishs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublish> findByPublishId(
		long publishId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bridge publish in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge publish
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishException if a matching bridge publish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublish findByPublishId_First(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bridge publish in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge publish, or <code>null</code> if a matching bridge publish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublish fetchByPublishId_First(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bridge publish in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge publish
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishException if a matching bridge publish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublish findByPublishId_Last(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bridge publish in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge publish, or <code>null</code> if a matching bridge publish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublish fetchByPublishId_Last(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publishs before and after the current bridge publish in the ordered set where publishId = &#63;.
	*
	* @param bridgePublishId the primary key of the current bridge publish
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bridge publish
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishException if a bridge publish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublish[] findByPublishId_PrevAndNext(
		long bridgePublishId, long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bridge publishs where publishId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPublishId(long publishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge publishs where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @return the number of matching bridge publishs
	* @throws SystemException if a system exception occurred
	*/
	public int countByPublishId(long publishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bridge publishs where publishId = &#63; and standardId = &#63;.
	*
	* @param publishId the publish ID
	* @param standardId the standard ID
	* @return the matching bridge publishs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublish> findByPublishIdAndStdId(
		long publishId, long standardId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bridge publishs where publishId = &#63; and standardId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param standardId the standard ID
	* @param start the lower bound of the range of bridge publishs
	* @param end the upper bound of the range of bridge publishs (not inclusive)
	* @return the range of matching bridge publishs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublish> findByPublishIdAndStdId(
		long publishId, long standardId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bridge publishs where publishId = &#63; and standardId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param standardId the standard ID
	* @param start the lower bound of the range of bridge publishs
	* @param end the upper bound of the range of bridge publishs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bridge publishs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublish> findByPublishIdAndStdId(
		long publishId, long standardId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bridge publish in the ordered set where publishId = &#63; and standardId = &#63;.
	*
	* @param publishId the publish ID
	* @param standardId the standard ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge publish
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishException if a matching bridge publish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublish findByPublishIdAndStdId_First(
		long publishId, long standardId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bridge publish in the ordered set where publishId = &#63; and standardId = &#63;.
	*
	* @param publishId the publish ID
	* @param standardId the standard ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge publish, or <code>null</code> if a matching bridge publish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublish fetchByPublishIdAndStdId_First(
		long publishId, long standardId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bridge publish in the ordered set where publishId = &#63; and standardId = &#63;.
	*
	* @param publishId the publish ID
	* @param standardId the standard ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge publish
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishException if a matching bridge publish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublish findByPublishIdAndStdId_Last(
		long publishId, long standardId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bridge publish in the ordered set where publishId = &#63; and standardId = &#63;.
	*
	* @param publishId the publish ID
	* @param standardId the standard ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge publish, or <code>null</code> if a matching bridge publish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublish fetchByPublishIdAndStdId_Last(
		long publishId, long standardId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publishs before and after the current bridge publish in the ordered set where publishId = &#63; and standardId = &#63;.
	*
	* @param bridgePublishId the primary key of the current bridge publish
	* @param publishId the publish ID
	* @param standardId the standard ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bridge publish
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishException if a bridge publish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublish[] findByPublishIdAndStdId_PrevAndNext(
		long bridgePublishId, long publishId, long standardId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bridge publishs where publishId = &#63; and standardId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param standardId the standard ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPublishIdAndStdId(long publishId, long standardId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge publishs where publishId = &#63; and standardId = &#63;.
	*
	* @param publishId the publish ID
	* @param standardId the standard ID
	* @return the number of matching bridge publishs
	* @throws SystemException if a system exception occurred
	*/
	public int countByPublishIdAndStdId(long publishId, long standardId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bridge publishs where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @return the matching bridge publishs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublish> findByPublishIdAndRegionId(
		long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bridge publishs where publishId = &#63; and regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param start the lower bound of the range of bridge publishs
	* @param end the upper bound of the range of bridge publishs (not inclusive)
	* @return the range of matching bridge publishs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublish> findByPublishIdAndRegionId(
		long publishId, long regionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bridge publishs where publishId = &#63; and regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param start the lower bound of the range of bridge publishs
	* @param end the upper bound of the range of bridge publishs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bridge publishs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublish> findByPublishIdAndRegionId(
		long publishId, long regionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bridge publish in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge publish
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishException if a matching bridge publish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublish findByPublishIdAndRegionId_First(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bridge publish in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge publish, or <code>null</code> if a matching bridge publish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublish fetchByPublishIdAndRegionId_First(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bridge publish in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge publish
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishException if a matching bridge publish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublish findByPublishIdAndRegionId_Last(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bridge publish in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge publish, or <code>null</code> if a matching bridge publish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublish fetchByPublishIdAndRegionId_Last(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publishs before and after the current bridge publish in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param bridgePublishId the primary key of the current bridge publish
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bridge publish
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishException if a bridge publish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublish[] findByPublishIdAndRegionId_PrevAndNext(
		long bridgePublishId, long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bridge publishs where publishId = &#63; and regionId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPublishIdAndRegionId(long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge publishs where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @return the number of matching bridge publishs
	* @throws SystemException if a system exception occurred
	*/
	public int countByPublishIdAndRegionId(long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publish where publishId = &#63; and regionId = &#63; and standardId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBridgePublishException} if it could not be found.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param standardId the standard ID
	* @return the matching bridge publish
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishException if a matching bridge publish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublish findByPublishIdRegionIdAndStdId(
		long publishId, long regionId, long standardId)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publish where publishId = &#63; and regionId = &#63; and standardId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param standardId the standard ID
	* @return the matching bridge publish, or <code>null</code> if a matching bridge publish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublish fetchByPublishIdRegionIdAndStdId(
		long publishId, long regionId, long standardId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publish where publishId = &#63; and regionId = &#63; and standardId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param standardId the standard ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching bridge publish, or <code>null</code> if a matching bridge publish could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublish fetchByPublishIdRegionIdAndStdId(
		long publishId, long regionId, long standardId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the bridge publish where publishId = &#63; and regionId = &#63; and standardId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param standardId the standard ID
	* @return the bridge publish that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublish removeByPublishIdRegionIdAndStdId(
		long publishId, long regionId, long standardId)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge publishs where publishId = &#63; and regionId = &#63; and standardId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param standardId the standard ID
	* @return the number of matching bridge publishs
	* @throws SystemException if a system exception occurred
	*/
	public int countByPublishIdRegionIdAndStdId(long publishId, long regionId,
		long standardId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the bridge publish in the entity cache if it is enabled.
	*
	* @param bridgePublish the bridge publish
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.BridgePublish bridgePublish);

	/**
	* Caches the bridge publishs in the entity cache if it is enabled.
	*
	* @param bridgePublishs the bridge publishs
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.BridgePublish> bridgePublishs);

	/**
	* Creates a new bridge publish with the primary key. Does not add the bridge publish to the database.
	*
	* @param bridgePublishId the primary key for the new bridge publish
	* @return the new bridge publish
	*/
	public com.ihg.brandstandards.db.model.BridgePublish create(
		long bridgePublishId);

	/**
	* Removes the bridge publish with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bridgePublishId the primary key of the bridge publish
	* @return the bridge publish that was removed
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishException if a bridge publish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublish remove(
		long bridgePublishId)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.BridgePublish updateImpl(
		com.ihg.brandstandards.db.model.BridgePublish bridgePublish)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publish with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgePublishException} if it could not be found.
	*
	* @param bridgePublishId the primary key of the bridge publish
	* @return the bridge publish
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishException if a bridge publish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublish findByPrimaryKey(
		long bridgePublishId)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publish with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bridgePublishId the primary key of the bridge publish
	* @return the bridge publish, or <code>null</code> if a bridge publish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublish fetchByPrimaryKey(
		long bridgePublishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bridge publishs.
	*
	* @return the bridge publishs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublish> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bridge publishs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge publishs
	* @param end the upper bound of the range of bridge publishs (not inclusive)
	* @return the range of bridge publishs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublish> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bridge publishs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge publishs
	* @param end the upper bound of the range of bridge publishs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bridge publishs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublish> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bridge publishs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge publishs.
	*
	* @return the number of bridge publishs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}