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

import com.ihg.brandstandards.db.model.Standards;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the standards service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsPersistenceImpl
 * @see StandardsUtil
 * @generated
 */
public interface StandardsPersistence extends BasePersistence<Standards> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StandardsUtil} to access the standards persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the standards where stdId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsException} if it could not be found.
	*
	* @param stdId the std ID
	* @return the matching standards
	* @throws com.ihg.brandstandards.db.NoSuchStandardsException if a matching standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards findByStdId(long stdId)
		throws com.ihg.brandstandards.db.NoSuchStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards where stdId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param stdId the std ID
	* @return the matching standards, or <code>null</code> if a matching standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards fetchByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards where stdId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param stdId the std ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching standards, or <code>null</code> if a matching standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards fetchByStdId(long stdId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the standards where stdId = &#63; from the database.
	*
	* @param stdId the std ID
	* @return the standards that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards removeByStdId(long stdId)
		throws com.ihg.brandstandards.db.NoSuchStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standardses where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the number of matching standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the standardses where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @return the matching standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Standards> findByParentId(
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the standardses where parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentId the parent ID
	* @param start the lower bound of the range of standardses
	* @param end the upper bound of the range of standardses (not inclusive)
	* @return the range of matching standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Standards> findByParentId(
		long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the standardses where parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentId the parent ID
	* @param start the lower bound of the range of standardses
	* @param end the upper bound of the range of standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Standards> findByParentId(
		long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standards in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards
	* @throws com.ihg.brandstandards.db.NoSuchStandardsException if a matching standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards findByParentId_First(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standards in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards, or <code>null</code> if a matching standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards fetchByParentId_First(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standards in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards
	* @throws com.ihg.brandstandards.db.NoSuchStandardsException if a matching standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards findByParentId_Last(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standards in the ordered set where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards, or <code>null</code> if a matching standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards fetchByParentId_Last(
		long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standardses before and after the current standards in the ordered set where parentId = &#63;.
	*
	* @param stdId the primary key of the current standards
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards
	* @throws com.ihg.brandstandards.db.NoSuchStandardsException if a standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards[] findByParentId_PrevAndNext(
		long stdId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standardses where parentId = &#63; from the database.
	*
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentId(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standardses where parentId = &#63;.
	*
	* @param parentId the parent ID
	* @return the number of matching standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentId(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards where stdTyp = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsException} if it could not be found.
	*
	* @param stdTyp the std typ
	* @return the matching standards
	* @throws com.ihg.brandstandards.db.NoSuchStandardsException if a matching standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards findBystdTyp(
		java.lang.String stdTyp)
		throws com.ihg.brandstandards.db.NoSuchStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards where stdTyp = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param stdTyp the std typ
	* @return the matching standards, or <code>null</code> if a matching standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards fetchBystdTyp(
		java.lang.String stdTyp)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards where stdTyp = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param stdTyp the std typ
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching standards, or <code>null</code> if a matching standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards fetchBystdTyp(
		java.lang.String stdTyp, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the standards where stdTyp = &#63; from the database.
	*
	* @param stdTyp the std typ
	* @return the standards that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards removeBystdTyp(
		java.lang.String stdTyp)
		throws com.ihg.brandstandards.db.NoSuchStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standardses where stdTyp = &#63;.
	*
	* @param stdTyp the std typ
	* @return the number of matching standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countBystdTyp(java.lang.String stdTyp)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards where status = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsException} if it could not be found.
	*
	* @param status the status
	* @return the matching standards
	* @throws com.ihg.brandstandards.db.NoSuchStandardsException if a matching standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards findBystatus(
		java.lang.String status)
		throws com.ihg.brandstandards.db.NoSuchStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards where status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param status the status
	* @return the matching standards, or <code>null</code> if a matching standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards fetchBystatus(
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards where status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param status the status
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching standards, or <code>null</code> if a matching standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards fetchBystatus(
		java.lang.String status, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the standards where status = &#63; from the database.
	*
	* @param status the status
	* @return the standards that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards removeBystatus(
		java.lang.String status)
		throws com.ihg.brandstandards.db.NoSuchStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standardses where status = &#63;.
	*
	* @param status the status
	* @return the number of matching standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countBystatus(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the standardses where author = &#63;.
	*
	* @param author the author
	* @return the matching standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Standards> findByAuthor(
		java.lang.String author)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the standardses where author = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param author the author
	* @param start the lower bound of the range of standardses
	* @param end the upper bound of the range of standardses (not inclusive)
	* @return the range of matching standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Standards> findByAuthor(
		java.lang.String author, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the standardses where author = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param author the author
	* @param start the lower bound of the range of standardses
	* @param end the upper bound of the range of standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Standards> findByAuthor(
		java.lang.String author, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standards in the ordered set where author = &#63;.
	*
	* @param author the author
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards
	* @throws com.ihg.brandstandards.db.NoSuchStandardsException if a matching standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards findByAuthor_First(
		java.lang.String author,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standards in the ordered set where author = &#63;.
	*
	* @param author the author
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards, or <code>null</code> if a matching standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards fetchByAuthor_First(
		java.lang.String author,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standards in the ordered set where author = &#63;.
	*
	* @param author the author
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards
	* @throws com.ihg.brandstandards.db.NoSuchStandardsException if a matching standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards findByAuthor_Last(
		java.lang.String author,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standards in the ordered set where author = &#63;.
	*
	* @param author the author
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards, or <code>null</code> if a matching standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards fetchByAuthor_Last(
		java.lang.String author,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standardses before and after the current standards in the ordered set where author = &#63;.
	*
	* @param stdId the primary key of the current standards
	* @param author the author
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards
	* @throws com.ihg.brandstandards.db.NoSuchStandardsException if a standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards[] findByAuthor_PrevAndNext(
		long stdId, java.lang.String author,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standardses where author = &#63; from the database.
	*
	* @param author the author
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAuthor(java.lang.String author)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standardses where author = &#63;.
	*
	* @param author the author
	* @return the number of matching standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countByAuthor(java.lang.String author)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the standardses where businessOwner = &#63;.
	*
	* @param businessOwner the business owner
	* @return the matching standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Standards> findByBusinessOwner(
		java.lang.String businessOwner)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the standardses where businessOwner = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param businessOwner the business owner
	* @param start the lower bound of the range of standardses
	* @param end the upper bound of the range of standardses (not inclusive)
	* @return the range of matching standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Standards> findByBusinessOwner(
		java.lang.String businessOwner, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the standardses where businessOwner = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param businessOwner the business owner
	* @param start the lower bound of the range of standardses
	* @param end the upper bound of the range of standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Standards> findByBusinessOwner(
		java.lang.String businessOwner, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standards in the ordered set where businessOwner = &#63;.
	*
	* @param businessOwner the business owner
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards
	* @throws com.ihg.brandstandards.db.NoSuchStandardsException if a matching standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards findByBusinessOwner_First(
		java.lang.String businessOwner,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standards in the ordered set where businessOwner = &#63;.
	*
	* @param businessOwner the business owner
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards, or <code>null</code> if a matching standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards fetchByBusinessOwner_First(
		java.lang.String businessOwner,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standards in the ordered set where businessOwner = &#63;.
	*
	* @param businessOwner the business owner
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards
	* @throws com.ihg.brandstandards.db.NoSuchStandardsException if a matching standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards findByBusinessOwner_Last(
		java.lang.String businessOwner,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standards in the ordered set where businessOwner = &#63;.
	*
	* @param businessOwner the business owner
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards, or <code>null</code> if a matching standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards fetchByBusinessOwner_Last(
		java.lang.String businessOwner,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standardses before and after the current standards in the ordered set where businessOwner = &#63;.
	*
	* @param stdId the primary key of the current standards
	* @param businessOwner the business owner
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards
	* @throws com.ihg.brandstandards.db.NoSuchStandardsException if a standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards[] findByBusinessOwner_PrevAndNext(
		long stdId, java.lang.String businessOwner,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standardses where businessOwner = &#63; from the database.
	*
	* @param businessOwner the business owner
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBusinessOwner(java.lang.String businessOwner)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standardses where businessOwner = &#63;.
	*
	* @param businessOwner the business owner
	* @return the number of matching standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countByBusinessOwner(java.lang.String businessOwner)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the standardses where regionCode = &#63; and parentId = &#63;.
	*
	* @param regionCode the region code
	* @param parentId the parent ID
	* @return the matching standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Standards> findByregionCodeAndParentId(
		java.lang.String regionCode, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the standardses where regionCode = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param regionCode the region code
	* @param parentId the parent ID
	* @param start the lower bound of the range of standardses
	* @param end the upper bound of the range of standardses (not inclusive)
	* @return the range of matching standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Standards> findByregionCodeAndParentId(
		java.lang.String regionCode, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the standardses where regionCode = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param regionCode the region code
	* @param parentId the parent ID
	* @param start the lower bound of the range of standardses
	* @param end the upper bound of the range of standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Standards> findByregionCodeAndParentId(
		java.lang.String regionCode, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standards in the ordered set where regionCode = &#63; and parentId = &#63;.
	*
	* @param regionCode the region code
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards
	* @throws com.ihg.brandstandards.db.NoSuchStandardsException if a matching standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards findByregionCodeAndParentId_First(
		java.lang.String regionCode, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standards in the ordered set where regionCode = &#63; and parentId = &#63;.
	*
	* @param regionCode the region code
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards, or <code>null</code> if a matching standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards fetchByregionCodeAndParentId_First(
		java.lang.String regionCode, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standards in the ordered set where regionCode = &#63; and parentId = &#63;.
	*
	* @param regionCode the region code
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards
	* @throws com.ihg.brandstandards.db.NoSuchStandardsException if a matching standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards findByregionCodeAndParentId_Last(
		java.lang.String regionCode, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standards in the ordered set where regionCode = &#63; and parentId = &#63;.
	*
	* @param regionCode the region code
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards, or <code>null</code> if a matching standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards fetchByregionCodeAndParentId_Last(
		java.lang.String regionCode, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standardses before and after the current standards in the ordered set where regionCode = &#63; and parentId = &#63;.
	*
	* @param stdId the primary key of the current standards
	* @param regionCode the region code
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards
	* @throws com.ihg.brandstandards.db.NoSuchStandardsException if a standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards[] findByregionCodeAndParentId_PrevAndNext(
		long stdId, java.lang.String regionCode, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standardses where regionCode = &#63; and parentId = &#63; from the database.
	*
	* @param regionCode the region code
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByregionCodeAndParentId(java.lang.String regionCode,
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standardses where regionCode = &#63; and parentId = &#63;.
	*
	* @param regionCode the region code
	* @param parentId the parent ID
	* @return the number of matching standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countByregionCodeAndParentId(java.lang.String regionCode,
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the standards in the entity cache if it is enabled.
	*
	* @param standards the standards
	*/
	public void cacheResult(com.ihg.brandstandards.db.model.Standards standards);

	/**
	* Caches the standardses in the entity cache if it is enabled.
	*
	* @param standardses the standardses
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.Standards> standardses);

	/**
	* Creates a new standards with the primary key. Does not add the standards to the database.
	*
	* @param stdId the primary key for the new standards
	* @return the new standards
	*/
	public com.ihg.brandstandards.db.model.Standards create(long stdId);

	/**
	* Removes the standards with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stdId the primary key of the standards
	* @return the standards that was removed
	* @throws com.ihg.brandstandards.db.NoSuchStandardsException if a standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards remove(long stdId)
		throws com.ihg.brandstandards.db.NoSuchStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.Standards updateImpl(
		com.ihg.brandstandards.db.model.Standards standards)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsException} if it could not be found.
	*
	* @param stdId the primary key of the standards
	* @return the standards
	* @throws com.ihg.brandstandards.db.NoSuchStandardsException if a standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards findByPrimaryKey(
		long stdId)
		throws com.ihg.brandstandards.db.NoSuchStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param stdId the primary key of the standards
	* @return the standards, or <code>null</code> if a standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Standards fetchByPrimaryKey(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the standardses.
	*
	* @return the standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Standards> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standardses
	* @param end the upper bound of the range of standardses (not inclusive)
	* @return the range of standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Standards> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standardses
	* @param end the upper bound of the range of standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Standards> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standardses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standardses.
	*
	* @return the number of standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}