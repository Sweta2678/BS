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

import com.ihg.brandstandards.db.model.Publication;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the publication service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see PublicationPersistenceImpl
 * @see PublicationUtil
 * @generated
 */
public interface PublicationPersistence extends BasePersistence<Publication> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PublicationUtil} to access the publication persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the publications where chainCode = &#63; and publishStatCd = &#63;.
	*
	* @param chainCode the chain code
	* @param publishStatCd the publish stat cd
	* @return the matching publications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Publication> findByChainCodeAndStatus(
		java.lang.String chainCode, java.lang.String publishStatCd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the publications where chainCode = &#63; and publishStatCd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param chainCode the chain code
	* @param publishStatCd the publish stat cd
	* @param start the lower bound of the range of publications
	* @param end the upper bound of the range of publications (not inclusive)
	* @return the range of matching publications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Publication> findByChainCodeAndStatus(
		java.lang.String chainCode, java.lang.String publishStatCd, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the publications where chainCode = &#63; and publishStatCd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param chainCode the chain code
	* @param publishStatCd the publish stat cd
	* @param start the lower bound of the range of publications
	* @param end the upper bound of the range of publications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching publications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Publication> findByChainCodeAndStatus(
		java.lang.String chainCode, java.lang.String publishStatCd, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first publication in the ordered set where chainCode = &#63; and publishStatCd = &#63;.
	*
	* @param chainCode the chain code
	* @param publishStatCd the publish stat cd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication findByChainCodeAndStatus_First(
		java.lang.String chainCode, java.lang.String publishStatCd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first publication in the ordered set where chainCode = &#63; and publishStatCd = &#63;.
	*
	* @param chainCode the chain code
	* @param publishStatCd the publish stat cd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publication, or <code>null</code> if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication fetchByChainCodeAndStatus_First(
		java.lang.String chainCode, java.lang.String publishStatCd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last publication in the ordered set where chainCode = &#63; and publishStatCd = &#63;.
	*
	* @param chainCode the chain code
	* @param publishStatCd the publish stat cd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication findByChainCodeAndStatus_Last(
		java.lang.String chainCode, java.lang.String publishStatCd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last publication in the ordered set where chainCode = &#63; and publishStatCd = &#63;.
	*
	* @param chainCode the chain code
	* @param publishStatCd the publish stat cd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publication, or <code>null</code> if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication fetchByChainCodeAndStatus_Last(
		java.lang.String chainCode, java.lang.String publishStatCd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publications before and after the current publication in the ordered set where chainCode = &#63; and publishStatCd = &#63;.
	*
	* @param publishId the primary key of the current publication
	* @param chainCode the chain code
	* @param publishStatCd the publish stat cd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a publication with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication[] findByChainCodeAndStatus_PrevAndNext(
		long publishId, java.lang.String chainCode,
		java.lang.String publishStatCd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the publications where chainCode = &#63; and publishStatCd = &#63; from the database.
	*
	* @param chainCode the chain code
	* @param publishStatCd the publish stat cd
	* @throws SystemException if a system exception occurred
	*/
	public void removeByChainCodeAndStatus(java.lang.String chainCode,
		java.lang.String publishStatCd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of publications where chainCode = &#63; and publishStatCd = &#63;.
	*
	* @param chainCode the chain code
	* @param publishStatCd the publish stat cd
	* @return the number of matching publications
	* @throws SystemException if a system exception occurred
	*/
	public int countByChainCodeAndStatus(java.lang.String chainCode,
		java.lang.String publishStatCd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publication where publishStatCd = &#63; and publishEnvName = &#63; and chainCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublicationException} if it could not be found.
	*
	* @param publishStatCd the publish stat cd
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @return the matching publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication findByPublishStatEnvChn(
		java.lang.String publishStatCd, java.lang.String publishEnvName,
		java.lang.String chainCode)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publication where publishStatCd = &#63; and publishEnvName = &#63; and chainCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param publishStatCd the publish stat cd
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @return the matching publication, or <code>null</code> if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication fetchByPublishStatEnvChn(
		java.lang.String publishStatCd, java.lang.String publishEnvName,
		java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publication where publishStatCd = &#63; and publishEnvName = &#63; and chainCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param publishStatCd the publish stat cd
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching publication, or <code>null</code> if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication fetchByPublishStatEnvChn(
		java.lang.String publishStatCd, java.lang.String publishEnvName,
		java.lang.String chainCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the publication where publishStatCd = &#63; and publishEnvName = &#63; and chainCode = &#63; from the database.
	*
	* @param publishStatCd the publish stat cd
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @return the publication that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication removeByPublishStatEnvChn(
		java.lang.String publishStatCd, java.lang.String publishEnvName,
		java.lang.String chainCode)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of publications where publishStatCd = &#63; and publishEnvName = &#63; and chainCode = &#63;.
	*
	* @param publishStatCd the publish stat cd
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @return the number of matching publications
	* @throws SystemException if a system exception occurred
	*/
	public int countByPublishStatEnvChn(java.lang.String publishStatCd,
		java.lang.String publishEnvName, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the publications where publishEnvName = &#63; and chainCode = &#63;.
	*
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @return the matching publications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Publication> findByPublishEnvChn(
		java.lang.String publishEnvName, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the publications where publishEnvName = &#63; and chainCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @param start the lower bound of the range of publications
	* @param end the upper bound of the range of publications (not inclusive)
	* @return the range of matching publications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Publication> findByPublishEnvChn(
		java.lang.String publishEnvName, java.lang.String chainCode, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the publications where publishEnvName = &#63; and chainCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @param start the lower bound of the range of publications
	* @param end the upper bound of the range of publications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching publications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Publication> findByPublishEnvChn(
		java.lang.String publishEnvName, java.lang.String chainCode, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first publication in the ordered set where publishEnvName = &#63; and chainCode = &#63;.
	*
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication findByPublishEnvChn_First(
		java.lang.String publishEnvName, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first publication in the ordered set where publishEnvName = &#63; and chainCode = &#63;.
	*
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publication, or <code>null</code> if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication fetchByPublishEnvChn_First(
		java.lang.String publishEnvName, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last publication in the ordered set where publishEnvName = &#63; and chainCode = &#63;.
	*
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication findByPublishEnvChn_Last(
		java.lang.String publishEnvName, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last publication in the ordered set where publishEnvName = &#63; and chainCode = &#63;.
	*
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publication, or <code>null</code> if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication fetchByPublishEnvChn_Last(
		java.lang.String publishEnvName, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publications before and after the current publication in the ordered set where publishEnvName = &#63; and chainCode = &#63;.
	*
	* @param publishId the primary key of the current publication
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a publication with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication[] findByPublishEnvChn_PrevAndNext(
		long publishId, java.lang.String publishEnvName,
		java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the publications where publishEnvName = &#63; and chainCode = &#63; from the database.
	*
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPublishEnvChn(java.lang.String publishEnvName,
		java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of publications where publishEnvName = &#63; and chainCode = &#63;.
	*
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @return the number of matching publications
	* @throws SystemException if a system exception occurred
	*/
	public int countByPublishEnvChn(java.lang.String publishEnvName,
		java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publication where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublicationException} if it could not be found.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @return the matching publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication findByPublishObject(
		java.lang.String chainCode, java.lang.String publishEnvName,
		java.lang.String publishStatCd)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publication where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @return the matching publication, or <code>null</code> if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication fetchByPublishObject(
		java.lang.String chainCode, java.lang.String publishEnvName,
		java.lang.String publishStatCd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publication where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching publication, or <code>null</code> if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication fetchByPublishObject(
		java.lang.String chainCode, java.lang.String publishEnvName,
		java.lang.String publishStatCd, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the publication where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63; from the database.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @return the publication that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication removeByPublishObject(
		java.lang.String chainCode, java.lang.String publishEnvName,
		java.lang.String publishStatCd)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of publications where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @return the number of matching publications
	* @throws SystemException if a system exception occurred
	*/
	public int countByPublishObject(java.lang.String chainCode,
		java.lang.String publishEnvName, java.lang.String publishStatCd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the publications where chainCode = &#63; and publishEnvName = &#63;.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @return the matching publications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Publication> findByPublishHistory(
		java.lang.String chainCode, java.lang.String publishEnvName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the publications where chainCode = &#63; and publishEnvName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param start the lower bound of the range of publications
	* @param end the upper bound of the range of publications (not inclusive)
	* @return the range of matching publications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Publication> findByPublishHistory(
		java.lang.String chainCode, java.lang.String publishEnvName, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the publications where chainCode = &#63; and publishEnvName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param start the lower bound of the range of publications
	* @param end the upper bound of the range of publications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching publications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Publication> findByPublishHistory(
		java.lang.String chainCode, java.lang.String publishEnvName, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first publication in the ordered set where chainCode = &#63; and publishEnvName = &#63;.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication findByPublishHistory_First(
		java.lang.String chainCode, java.lang.String publishEnvName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first publication in the ordered set where chainCode = &#63; and publishEnvName = &#63;.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publication, or <code>null</code> if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication fetchByPublishHistory_First(
		java.lang.String chainCode, java.lang.String publishEnvName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last publication in the ordered set where chainCode = &#63; and publishEnvName = &#63;.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication findByPublishHistory_Last(
		java.lang.String chainCode, java.lang.String publishEnvName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last publication in the ordered set where chainCode = &#63; and publishEnvName = &#63;.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publication, or <code>null</code> if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication fetchByPublishHistory_Last(
		java.lang.String chainCode, java.lang.String publishEnvName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publications before and after the current publication in the ordered set where chainCode = &#63; and publishEnvName = &#63;.
	*
	* @param publishId the primary key of the current publication
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a publication with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication[] findByPublishHistory_PrevAndNext(
		long publishId, java.lang.String chainCode,
		java.lang.String publishEnvName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the publications where chainCode = &#63; and publishEnvName = &#63; from the database.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPublishHistory(java.lang.String chainCode,
		java.lang.String publishEnvName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of publications where chainCode = &#63; and publishEnvName = &#63;.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @return the number of matching publications
	* @throws SystemException if a system exception occurred
	*/
	public int countByPublishHistory(java.lang.String chainCode,
		java.lang.String publishEnvName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the publications where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @return the matching publications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Publication> findByPublishInActiveHistory(
		java.lang.String chainCode, java.lang.String publishEnvName,
		java.lang.String publishStatCd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the publications where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @param start the lower bound of the range of publications
	* @param end the upper bound of the range of publications (not inclusive)
	* @return the range of matching publications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Publication> findByPublishInActiveHistory(
		java.lang.String chainCode, java.lang.String publishEnvName,
		java.lang.String publishStatCd, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the publications where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @param start the lower bound of the range of publications
	* @param end the upper bound of the range of publications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching publications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Publication> findByPublishInActiveHistory(
		java.lang.String chainCode, java.lang.String publishEnvName,
		java.lang.String publishStatCd, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first publication in the ordered set where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication findByPublishInActiveHistory_First(
		java.lang.String chainCode, java.lang.String publishEnvName,
		java.lang.String publishStatCd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first publication in the ordered set where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publication, or <code>null</code> if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication fetchByPublishInActiveHistory_First(
		java.lang.String chainCode, java.lang.String publishEnvName,
		java.lang.String publishStatCd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last publication in the ordered set where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication findByPublishInActiveHistory_Last(
		java.lang.String chainCode, java.lang.String publishEnvName,
		java.lang.String publishStatCd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last publication in the ordered set where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publication, or <code>null</code> if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication fetchByPublishInActiveHistory_Last(
		java.lang.String chainCode, java.lang.String publishEnvName,
		java.lang.String publishStatCd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publications before and after the current publication in the ordered set where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	*
	* @param publishId the primary key of the current publication
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a publication with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication[] findByPublishInActiveHistory_PrevAndNext(
		long publishId, java.lang.String chainCode,
		java.lang.String publishEnvName, java.lang.String publishStatCd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the publications where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63; from the database.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPublishInActiveHistory(java.lang.String chainCode,
		java.lang.String publishEnvName, java.lang.String publishStatCd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of publications where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @return the number of matching publications
	* @throws SystemException if a system exception occurred
	*/
	public int countByPublishInActiveHistory(java.lang.String chainCode,
		java.lang.String publishEnvName, java.lang.String publishStatCd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the publication in the entity cache if it is enabled.
	*
	* @param publication the publication
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.Publication publication);

	/**
	* Caches the publications in the entity cache if it is enabled.
	*
	* @param publications the publications
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.Publication> publications);

	/**
	* Creates a new publication with the primary key. Does not add the publication to the database.
	*
	* @param publishId the primary key for the new publication
	* @return the new publication
	*/
	public com.ihg.brandstandards.db.model.Publication create(long publishId);

	/**
	* Removes the publication with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param publishId the primary key of the publication
	* @return the publication that was removed
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a publication with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication remove(long publishId)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.Publication updateImpl(
		com.ihg.brandstandards.db.model.Publication publication)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publication with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchPublicationException} if it could not be found.
	*
	* @param publishId the primary key of the publication
	* @return the publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a publication with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication findByPrimaryKey(
		long publishId)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publication with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param publishId the primary key of the publication
	* @return the publication, or <code>null</code> if a publication with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Publication fetchByPrimaryKey(
		long publishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the publications.
	*
	* @return the publications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Publication> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the publications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of publications
	* @param end the upper bound of the range of publications (not inclusive)
	* @return the range of publications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Publication> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the publications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of publications
	* @param end the upper bound of the range of publications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of publications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Publication> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the publications from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of publications.
	*
	* @return the number of publications
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}