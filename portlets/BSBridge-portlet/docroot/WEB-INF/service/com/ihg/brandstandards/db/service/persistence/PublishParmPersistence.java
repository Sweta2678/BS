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

import com.ihg.brandstandards.db.model.PublishParm;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the publish parm service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see PublishParmPersistenceImpl
 * @see PublishParmUtil
 * @generated
 */
public interface PublishParmPersistence extends BasePersistence<PublishParm> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PublishParmUtil} to access the publish parm persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the publish parms where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @return the matching publish parms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.PublishParm> findByPublishId(
		long publishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the publish parms where publishId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishParmModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param start the lower bound of the range of publish parms
	* @param end the upper bound of the range of publish parms (not inclusive)
	* @return the range of matching publish parms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.PublishParm> findByPublishId(
		long publishId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the publish parms where publishId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishParmModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param start the lower bound of the range of publish parms
	* @param end the upper bound of the range of publish parms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching publish parms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.PublishParm> findByPublishId(
		long publishId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first publish parm in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publish parm
	* @throws com.ihg.brandstandards.db.NoSuchPublishParmException if a matching publish parm could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishParm findByPublishId_First(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishParmException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first publish parm in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publish parm, or <code>null</code> if a matching publish parm could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishParm fetchByPublishId_First(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last publish parm in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publish parm
	* @throws com.ihg.brandstandards.db.NoSuchPublishParmException if a matching publish parm could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishParm findByPublishId_Last(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishParmException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last publish parm in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publish parm, or <code>null</code> if a matching publish parm could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishParm fetchByPublishId_Last(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publish parms before and after the current publish parm in the ordered set where publishId = &#63;.
	*
	* @param publishParmId the primary key of the current publish parm
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next publish parm
	* @throws com.ihg.brandstandards.db.NoSuchPublishParmException if a publish parm with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishParm[] findByPublishId_PrevAndNext(
		long publishParmId, long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishParmException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the publish parms where publishId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPublishId(long publishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of publish parms where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @return the number of matching publish parms
	* @throws SystemException if a system exception occurred
	*/
	public int countByPublishId(long publishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the publish parm in the entity cache if it is enabled.
	*
	* @param publishParm the publish parm
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.PublishParm publishParm);

	/**
	* Caches the publish parms in the entity cache if it is enabled.
	*
	* @param publishParms the publish parms
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.PublishParm> publishParms);

	/**
	* Creates a new publish parm with the primary key. Does not add the publish parm to the database.
	*
	* @param publishParmId the primary key for the new publish parm
	* @return the new publish parm
	*/
	public com.ihg.brandstandards.db.model.PublishParm create(
		long publishParmId);

	/**
	* Removes the publish parm with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param publishParmId the primary key of the publish parm
	* @return the publish parm that was removed
	* @throws com.ihg.brandstandards.db.NoSuchPublishParmException if a publish parm with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishParm remove(
		long publishParmId)
		throws com.ihg.brandstandards.db.NoSuchPublishParmException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.PublishParm updateImpl(
		com.ihg.brandstandards.db.model.PublishParm publishParm)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publish parm with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchPublishParmException} if it could not be found.
	*
	* @param publishParmId the primary key of the publish parm
	* @return the publish parm
	* @throws com.ihg.brandstandards.db.NoSuchPublishParmException if a publish parm with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishParm findByPrimaryKey(
		long publishParmId)
		throws com.ihg.brandstandards.db.NoSuchPublishParmException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publish parm with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param publishParmId the primary key of the publish parm
	* @return the publish parm, or <code>null</code> if a publish parm with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishParm fetchByPrimaryKey(
		long publishParmId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the publish parms.
	*
	* @return the publish parms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.PublishParm> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the publish parms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishParmModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of publish parms
	* @param end the upper bound of the range of publish parms (not inclusive)
	* @return the range of publish parms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.PublishParm> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the publish parms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishParmModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of publish parms
	* @param end the upper bound of the range of publish parms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of publish parms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.PublishParm> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the publish parms from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of publish parms.
	*
	* @return the number of publish parms
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}