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

import com.ihg.brandstandards.db.model.PublishStd;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the publish std service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see PublishStdPersistenceImpl
 * @see PublishStdUtil
 * @generated
 */
public interface PublishStdPersistence extends BasePersistence<PublishStd> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PublishStdUtil} to access the publish std persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the publish std where publishId = &#63; and stdId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublishStdException} if it could not be found.
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @return the matching publish std
	* @throws com.ihg.brandstandards.db.NoSuchPublishStdException if a matching publish std could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishStd findBypublishForStdId(
		long publishId, long stdId)
		throws com.ihg.brandstandards.db.NoSuchPublishStdException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publish std where publishId = &#63; and stdId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @return the matching publish std, or <code>null</code> if a matching publish std could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishStd fetchBypublishForStdId(
		long publishId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publish std where publishId = &#63; and stdId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching publish std, or <code>null</code> if a matching publish std could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishStd fetchBypublishForStdId(
		long publishId, long stdId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the publish std where publishId = &#63; and stdId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @return the publish std that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishStd removeBypublishForStdId(
		long publishId, long stdId)
		throws com.ihg.brandstandards.db.NoSuchPublishStdException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of publish stds where publishId = &#63; and stdId = &#63;.
	*
	* @param publishId the publish ID
	* @param stdId the std ID
	* @return the number of matching publish stds
	* @throws SystemException if a system exception occurred
	*/
	public int countBypublishForStdId(long publishId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publish std where publishStdVerId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublishStdException} if it could not be found.
	*
	* @param publishStdVerId the publish std ver ID
	* @return the matching publish std
	* @throws com.ihg.brandstandards.db.NoSuchPublishStdException if a matching publish std could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishStd findBypublishStdId(
		long publishStdVerId)
		throws com.ihg.brandstandards.db.NoSuchPublishStdException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publish std where publishStdVerId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param publishStdVerId the publish std ver ID
	* @return the matching publish std, or <code>null</code> if a matching publish std could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishStd fetchBypublishStdId(
		long publishStdVerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publish std where publishStdVerId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param publishStdVerId the publish std ver ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching publish std, or <code>null</code> if a matching publish std could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishStd fetchBypublishStdId(
		long publishStdVerId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the publish std where publishStdVerId = &#63; from the database.
	*
	* @param publishStdVerId the publish std ver ID
	* @return the publish std that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishStd removeBypublishStdId(
		long publishStdVerId)
		throws com.ihg.brandstandards.db.NoSuchPublishStdException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of publish stds where publishStdVerId = &#63;.
	*
	* @param publishStdVerId the publish std ver ID
	* @return the number of matching publish stds
	* @throws SystemException if a system exception occurred
	*/
	public int countBypublishStdId(long publishStdVerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publish std where stdTyp = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublishStdException} if it could not be found.
	*
	* @param stdTyp the std typ
	* @return the matching publish std
	* @throws com.ihg.brandstandards.db.NoSuchPublishStdException if a matching publish std could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishStd findBystdTyp(
		java.lang.String stdTyp)
		throws com.ihg.brandstandards.db.NoSuchPublishStdException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publish std where stdTyp = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param stdTyp the std typ
	* @return the matching publish std, or <code>null</code> if a matching publish std could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishStd fetchBystdTyp(
		java.lang.String stdTyp)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publish std where stdTyp = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param stdTyp the std typ
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching publish std, or <code>null</code> if a matching publish std could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishStd fetchBystdTyp(
		java.lang.String stdTyp, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the publish std where stdTyp = &#63; from the database.
	*
	* @param stdTyp the std typ
	* @return the publish std that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishStd removeBystdTyp(
		java.lang.String stdTyp)
		throws com.ihg.brandstandards.db.NoSuchPublishStdException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of publish stds where stdTyp = &#63;.
	*
	* @param stdTyp the std typ
	* @return the number of matching publish stds
	* @throws SystemException if a system exception occurred
	*/
	public int countBystdTyp(java.lang.String stdTyp)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publish std where status = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublishStdException} if it could not be found.
	*
	* @param status the status
	* @return the matching publish std
	* @throws com.ihg.brandstandards.db.NoSuchPublishStdException if a matching publish std could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishStd findBystatus(
		java.lang.String status)
		throws com.ihg.brandstandards.db.NoSuchPublishStdException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publish std where status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param status the status
	* @return the matching publish std, or <code>null</code> if a matching publish std could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishStd fetchBystatus(
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publish std where status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param status the status
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching publish std, or <code>null</code> if a matching publish std could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishStd fetchBystatus(
		java.lang.String status, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the publish std where status = &#63; from the database.
	*
	* @param status the status
	* @return the publish std that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishStd removeBystatus(
		java.lang.String status)
		throws com.ihg.brandstandards.db.NoSuchPublishStdException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of publish stds where status = &#63;.
	*
	* @param status the status
	* @return the number of matching publish stds
	* @throws SystemException if a system exception occurred
	*/
	public int countBystatus(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the publish stds where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @return the matching publish stds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.PublishStd> findByparentPublishId(
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the publish stds where parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishStdModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentId the parent ID
	* @param start the lower bound of the range of publish stds
	* @param end the upper bound of the range of publish stds (not inclusive)
	* @return the range of matching publish stds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.PublishStd> findByparentPublishId(
		long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the publish stds where parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishStdModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentId the parent ID
	* @param start the lower bound of the range of publish stds
	* @param end the upper bound of the range of publish stds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching publish stds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.PublishStd> findByparentPublishId(
		long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first publish std in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publish std
	* @throws com.ihg.brandstandards.db.NoSuchPublishStdException if a matching publish std could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishStd findByparentPublishId_First(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishStdException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first publish std in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publish std, or <code>null</code> if a matching publish std could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishStd fetchByparentPublishId_First(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last publish std in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publish std
	* @throws com.ihg.brandstandards.db.NoSuchPublishStdException if a matching publish std could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishStd findByparentPublishId_Last(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishStdException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last publish std in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publish std, or <code>null</code> if a matching publish std could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishStd fetchByparentPublishId_Last(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publish stds before and after the current publish std in the ordered set where parentId = &#63;.
	*
	* @param publishStdVerId the primary key of the current publish std
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next publish std
	* @throws com.ihg.brandstandards.db.NoSuchPublishStdException if a publish std with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishStd[] findByparentPublishId_PrevAndNext(
		long publishStdVerId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishStdException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the publish stds where parentId = &#63; from the database.
	*
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByparentPublishId(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of publish stds where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @return the number of matching publish stds
	* @throws SystemException if a system exception occurred
	*/
	public int countByparentPublishId(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the publish std in the entity cache if it is enabled.
	*
	* @param publishStd the publish std
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.PublishStd publishStd);

	/**
	* Caches the publish stds in the entity cache if it is enabled.
	*
	* @param publishStds the publish stds
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.PublishStd> publishStds);

	/**
	* Creates a new publish std with the primary key. Does not add the publish std to the database.
	*
	* @param publishStdVerId the primary key for the new publish std
	* @return the new publish std
	*/
	public com.ihg.brandstandards.db.model.PublishStd create(
		long publishStdVerId);

	/**
	* Removes the publish std with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param publishStdVerId the primary key of the publish std
	* @return the publish std that was removed
	* @throws com.ihg.brandstandards.db.NoSuchPublishStdException if a publish std with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishStd remove(
		long publishStdVerId)
		throws com.ihg.brandstandards.db.NoSuchPublishStdException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.PublishStd updateImpl(
		com.ihg.brandstandards.db.model.PublishStd publishStd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publish std with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchPublishStdException} if it could not be found.
	*
	* @param publishStdVerId the primary key of the publish std
	* @return the publish std
	* @throws com.ihg.brandstandards.db.NoSuchPublishStdException if a publish std with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishStd findByPrimaryKey(
		long publishStdVerId)
		throws com.ihg.brandstandards.db.NoSuchPublishStdException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publish std with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param publishStdVerId the primary key of the publish std
	* @return the publish std, or <code>null</code> if a publish std with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishStd fetchByPrimaryKey(
		long publishStdVerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the publish stds.
	*
	* @return the publish stds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.PublishStd> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the publish stds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishStdModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of publish stds
	* @param end the upper bound of the range of publish stds (not inclusive)
	* @return the range of publish stds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.PublishStd> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the publish stds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishStdModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of publish stds
	* @param end the upper bound of the range of publish stds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of publish stds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.PublishStd> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the publish stds from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of publish stds.
	*
	* @return the number of publish stds
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}