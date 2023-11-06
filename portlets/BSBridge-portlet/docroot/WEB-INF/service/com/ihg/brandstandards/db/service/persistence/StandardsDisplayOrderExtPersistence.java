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

import com.ihg.brandstandards.db.model.StandardsDisplayOrderExt;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the standards display order ext service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsDisplayOrderExtPersistenceImpl
 * @see StandardsDisplayOrderExtUtil
 * @generated
 */
public interface StandardsDisplayOrderExtPersistence extends BasePersistence<StandardsDisplayOrderExt> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StandardsDisplayOrderExtUtil} to access the standards display order ext persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the standards display order ext in the entity cache if it is enabled.
	*
	* @param standardsDisplayOrderExt the standards display order ext
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.StandardsDisplayOrderExt standardsDisplayOrderExt);

	/**
	* Caches the standards display order exts in the entity cache if it is enabled.
	*
	* @param standardsDisplayOrderExts the standards display order exts
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.StandardsDisplayOrderExt> standardsDisplayOrderExts);

	/**
	* Creates a new standards display order ext with the primary key. Does not add the standards display order ext to the database.
	*
	* @param stdId the primary key for the new standards display order ext
	* @return the new standards display order ext
	*/
	public com.ihg.brandstandards.db.model.StandardsDisplayOrderExt create(
		long stdId);

	/**
	* Removes the standards display order ext with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stdId the primary key of the standards display order ext
	* @return the standards display order ext that was removed
	* @throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderExtException if a standards display order ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsDisplayOrderExt remove(
		long stdId)
		throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderExtException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.StandardsDisplayOrderExt updateImpl(
		com.ihg.brandstandards.db.model.StandardsDisplayOrderExt standardsDisplayOrderExt)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards display order ext with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderExtException} if it could not be found.
	*
	* @param stdId the primary key of the standards display order ext
	* @return the standards display order ext
	* @throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderExtException if a standards display order ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsDisplayOrderExt findByPrimaryKey(
		long stdId)
		throws com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderExtException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards display order ext with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param stdId the primary key of the standards display order ext
	* @return the standards display order ext, or <code>null</code> if a standards display order ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsDisplayOrderExt fetchByPrimaryKey(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the standards display order exts.
	*
	* @return the standards display order exts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsDisplayOrderExt> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the standards display order exts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsDisplayOrderExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards display order exts
	* @param end the upper bound of the range of standards display order exts (not inclusive)
	* @return the range of standards display order exts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsDisplayOrderExt> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the standards display order exts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsDisplayOrderExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards display order exts
	* @param end the upper bound of the range of standards display order exts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of standards display order exts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsDisplayOrderExt> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standards display order exts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standards display order exts.
	*
	* @return the number of standards display order exts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}