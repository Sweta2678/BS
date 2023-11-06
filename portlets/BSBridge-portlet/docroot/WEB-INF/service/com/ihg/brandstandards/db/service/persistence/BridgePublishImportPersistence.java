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

import com.ihg.brandstandards.db.model.BridgePublishImport;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the bridge publish import service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgePublishImportPersistenceImpl
 * @see BridgePublishImportUtil
 * @generated
 */
public interface BridgePublishImportPersistence extends BasePersistence<BridgePublishImport> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BridgePublishImportUtil} to access the bridge publish import persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the bridge publish imports where publishId = &#63; and stdId = &#63;.
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @return the matching bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishImport> findByPublishIdAndStdId(
		long publishId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bridge publish imports where publishId = &#63; and stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishImportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @param start the lower bound of the range of bridge publish imports
	* @param end the upper bound of the range of bridge publish imports (not inclusive)
	* @return the range of matching bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishImport> findByPublishIdAndStdId(
		long publishId, long stdId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bridge publish imports where publishId = &#63; and stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishImportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @param start the lower bound of the range of bridge publish imports
	* @param end the upper bound of the range of bridge publish imports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishImport> findByPublishIdAndStdId(
		long publishId, long stdId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bridge publish import in the ordered set where publishId = &#63; and stdId = &#63;.
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge publish import
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishImport findByPublishIdAndStdId_First(
		long publishId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bridge publish import in the ordered set where publishId = &#63; and stdId = &#63;.
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge publish import, or <code>null</code> if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishImport fetchByPublishIdAndStdId_First(
		long publishId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bridge publish import in the ordered set where publishId = &#63; and stdId = &#63;.
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge publish import
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishImport findByPublishIdAndStdId_Last(
		long publishId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bridge publish import in the ordered set where publishId = &#63; and stdId = &#63;.
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge publish import, or <code>null</code> if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishImport fetchByPublishIdAndStdId_Last(
		long publishId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publish imports before and after the current bridge publish import in the ordered set where publishId = &#63; and stdId = &#63;.
	*
	* @param publishImportId the primary key of the current bridge publish import
	* @param publishId the publish ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bridge publish import
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a bridge publish import with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishImport[] findByPublishIdAndStdId_PrevAndNext(
		long publishImportId, long publishId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bridge publish imports where publishId = &#63; and stdId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPublishIdAndStdId(long publishId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge publish imports where publishId = &#63; and stdId = &#63;.
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @return the number of matching bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public int countByPublishIdAndStdId(long publishId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publish import where publishId = &#63; and regionId = &#63; and stdId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBridgePublishImportException} if it could not be found.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param stdId the std ID
	* @return the matching bridge publish import
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishImport findByPublishIdRegionIdStdId(
		long publishId, long regionId, long stdId)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publish import where publishId = &#63; and regionId = &#63; and stdId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param stdId the std ID
	* @return the matching bridge publish import, or <code>null</code> if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishImport fetchByPublishIdRegionIdStdId(
		long publishId, long regionId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publish import where publishId = &#63; and regionId = &#63; and stdId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param stdId the std ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching bridge publish import, or <code>null</code> if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishImport fetchByPublishIdRegionIdStdId(
		long publishId, long regionId, long stdId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the bridge publish import where publishId = &#63; and regionId = &#63; and stdId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param stdId the std ID
	* @return the bridge publish import that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishImport removeByPublishIdRegionIdStdId(
		long publishId, long regionId, long stdId)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge publish imports where publishId = &#63; and regionId = &#63; and stdId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param stdId the std ID
	* @return the number of matching bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public int countByPublishIdRegionIdStdId(long publishId, long regionId,
		long stdId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bridge publish imports where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @return the matching bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishImport> findByPublishIdAndRegionId(
		long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bridge publish imports where publishId = &#63; and regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishImportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param start the lower bound of the range of bridge publish imports
	* @param end the upper bound of the range of bridge publish imports (not inclusive)
	* @return the range of matching bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishImport> findByPublishIdAndRegionId(
		long publishId, long regionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bridge publish imports where publishId = &#63; and regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishImportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param start the lower bound of the range of bridge publish imports
	* @param end the upper bound of the range of bridge publish imports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishImport> findByPublishIdAndRegionId(
		long publishId, long regionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bridge publish import in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge publish import
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishImport findByPublishIdAndRegionId_First(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bridge publish import in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge publish import, or <code>null</code> if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishImport fetchByPublishIdAndRegionId_First(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bridge publish import in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge publish import
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishImport findByPublishIdAndRegionId_Last(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bridge publish import in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge publish import, or <code>null</code> if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishImport fetchByPublishIdAndRegionId_Last(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publish imports before and after the current bridge publish import in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishImportId the primary key of the current bridge publish import
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bridge publish import
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a bridge publish import with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishImport[] findByPublishIdAndRegionId_PrevAndNext(
		long publishImportId, long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bridge publish imports where publishId = &#63; and regionId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPublishIdAndRegionId(long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge publish imports where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @return the number of matching bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public int countByPublishIdAndRegionId(long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bridge publish imports where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @return the matching bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishImport> findByPublishId(
		long publishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bridge publish imports where publishId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishImportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param start the lower bound of the range of bridge publish imports
	* @param end the upper bound of the range of bridge publish imports (not inclusive)
	* @return the range of matching bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishImport> findByPublishId(
		long publishId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bridge publish imports where publishId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishImportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param start the lower bound of the range of bridge publish imports
	* @param end the upper bound of the range of bridge publish imports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishImport> findByPublishId(
		long publishId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bridge publish import in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge publish import
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishImport findByPublishId_First(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bridge publish import in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge publish import, or <code>null</code> if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishImport fetchByPublishId_First(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bridge publish import in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge publish import
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishImport findByPublishId_Last(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bridge publish import in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge publish import, or <code>null</code> if a matching bridge publish import could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishImport fetchByPublishId_Last(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publish imports before and after the current bridge publish import in the ordered set where publishId = &#63;.
	*
	* @param publishImportId the primary key of the current bridge publish import
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bridge publish import
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a bridge publish import with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishImport[] findByPublishId_PrevAndNext(
		long publishImportId, long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bridge publish imports where publishId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPublishId(long publishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge publish imports where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @return the number of matching bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public int countByPublishId(long publishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the bridge publish import in the entity cache if it is enabled.
	*
	* @param bridgePublishImport the bridge publish import
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.BridgePublishImport bridgePublishImport);

	/**
	* Caches the bridge publish imports in the entity cache if it is enabled.
	*
	* @param bridgePublishImports the bridge publish imports
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.BridgePublishImport> bridgePublishImports);

	/**
	* Creates a new bridge publish import with the primary key. Does not add the bridge publish import to the database.
	*
	* @param publishImportId the primary key for the new bridge publish import
	* @return the new bridge publish import
	*/
	public com.ihg.brandstandards.db.model.BridgePublishImport create(
		long publishImportId);

	/**
	* Removes the bridge publish import with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param publishImportId the primary key of the bridge publish import
	* @return the bridge publish import that was removed
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a bridge publish import with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishImport remove(
		long publishImportId)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.BridgePublishImport updateImpl(
		com.ihg.brandstandards.db.model.BridgePublishImport bridgePublishImport)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publish import with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgePublishImportException} if it could not be found.
	*
	* @param publishImportId the primary key of the bridge publish import
	* @return the bridge publish import
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a bridge publish import with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishImport findByPrimaryKey(
		long publishImportId)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publish import with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param publishImportId the primary key of the bridge publish import
	* @return the bridge publish import, or <code>null</code> if a bridge publish import with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishImport fetchByPrimaryKey(
		long publishImportId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bridge publish imports.
	*
	* @return the bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishImport> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bridge publish imports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishImportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge publish imports
	* @param end the upper bound of the range of bridge publish imports (not inclusive)
	* @return the range of bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishImport> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bridge publish imports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishImportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge publish imports
	* @param end the upper bound of the range of bridge publish imports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishImport> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bridge publish imports from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge publish imports.
	*
	* @return the number of bridge publish imports
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}