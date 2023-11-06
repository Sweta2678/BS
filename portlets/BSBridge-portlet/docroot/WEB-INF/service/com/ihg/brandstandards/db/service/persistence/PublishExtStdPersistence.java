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

import com.ihg.brandstandards.db.model.PublishExtStd;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see PublishExtStdPersistenceImpl
 * @see PublishExtStdUtil
 * @generated
 */
public interface PublishExtStdPersistence extends BasePersistence<PublishExtStd> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PublishExtStdUtil} to access the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. in the entity cache if it is enabled.
	*
	* @param publishExtStd the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.PublishExtStd publishExtStd);

	/**
	* Caches the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s in the entity cache if it is enabled.
	*
	* @param publishExtStds the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.PublishExtStd> publishExtStds);

	/**
	* Creates a new Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key. Does not add the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. to the database.
	*
	* @param stdId the primary key for the new Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	* @return the new Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	*/
	public com.ihg.brandstandards.db.model.PublishExtStd create(long stdId);

	/**
	* Removes the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stdId the primary key of the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	* @return the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. that was removed
	* @throws com.ihg.brandstandards.db.NoSuchPublishExtStdException if a Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishExtStd remove(long stdId)
		throws com.ihg.brandstandards.db.NoSuchPublishExtStdException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.PublishExtStd updateImpl(
		com.ihg.brandstandards.db.model.PublishExtStd publishExtStd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchPublishExtStdException} if it could not be found.
	*
	* @param stdId the primary key of the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	* @return the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	* @throws com.ihg.brandstandards.db.NoSuchPublishExtStdException if a Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishExtStd findByPrimaryKey(
		long stdId)
		throws com.ihg.brandstandards.db.NoSuchPublishExtStdException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param stdId the primary key of the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	* @return the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables., or <code>null</code> if a Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishExtStd fetchByPrimaryKey(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s.
	*
	* @return the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.PublishExtStd> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishExtStdModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s
	* @param end the upper bound of the range of Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s (not inclusive)
	* @return the range of Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.PublishExtStd> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishExtStdModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s
	* @param end the upper bound of the range of Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.PublishExtStd> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s.
	*
	* @return the number of Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}