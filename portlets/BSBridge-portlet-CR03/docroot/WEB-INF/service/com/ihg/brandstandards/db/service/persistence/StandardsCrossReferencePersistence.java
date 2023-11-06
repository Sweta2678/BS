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

import com.ihg.brandstandards.db.model.StandardsCrossReference;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the standards cross reference service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsCrossReferencePersistenceImpl
 * @see StandardsCrossReferenceUtil
 * @generated
 */
public interface StandardsCrossReferencePersistence extends BasePersistence<StandardsCrossReference> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StandardsCrossReferenceUtil} to access the standards cross reference persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the standards cross references where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the matching standards cross references
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCrossReference> findByStdId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the standards cross references where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCrossReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of standards cross references
	* @param end the upper bound of the range of standards cross references (not inclusive)
	* @return the range of matching standards cross references
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCrossReference> findByStdId(
		long stdId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the standards cross references where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCrossReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of standards cross references
	* @param end the upper bound of the range of standards cross references (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standards cross references
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCrossReference> findByStdId(
		long stdId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standards cross reference in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards cross reference
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException if a matching standards cross reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCrossReference findByStdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standards cross reference in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards cross reference, or <code>null</code> if a matching standards cross reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCrossReference fetchByStdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standards cross reference in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards cross reference
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException if a matching standards cross reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCrossReference findByStdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standards cross reference in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards cross reference, or <code>null</code> if a matching standards cross reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCrossReference fetchByStdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards cross references before and after the current standards cross reference in the ordered set where stdId = &#63;.
	*
	* @param standardsCrossReferencePK the primary key of the current standards cross reference
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards cross reference
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException if a standards cross reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCrossReference[] findByStdId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK standardsCrossReferencePK,
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standards cross references where stdId = &#63; from the database.
	*
	* @param stdId the std ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standards cross references where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the number of matching standards cross references
	* @throws SystemException if a system exception occurred
	*/
	public int countByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the standards cross references where xrefStdId = &#63;.
	*
	* @param xrefStdId the xref std ID
	* @return the matching standards cross references
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCrossReference> findByrefStdId(
		long xrefStdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the standards cross references where xrefStdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCrossReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param xrefStdId the xref std ID
	* @param start the lower bound of the range of standards cross references
	* @param end the upper bound of the range of standards cross references (not inclusive)
	* @return the range of matching standards cross references
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCrossReference> findByrefStdId(
		long xrefStdId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the standards cross references where xrefStdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCrossReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param xrefStdId the xref std ID
	* @param start the lower bound of the range of standards cross references
	* @param end the upper bound of the range of standards cross references (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standards cross references
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCrossReference> findByrefStdId(
		long xrefStdId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standards cross reference in the ordered set where xrefStdId = &#63;.
	*
	* @param xrefStdId the xref std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards cross reference
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException if a matching standards cross reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCrossReference findByrefStdId_First(
		long xrefStdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standards cross reference in the ordered set where xrefStdId = &#63;.
	*
	* @param xrefStdId the xref std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards cross reference, or <code>null</code> if a matching standards cross reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCrossReference fetchByrefStdId_First(
		long xrefStdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standards cross reference in the ordered set where xrefStdId = &#63;.
	*
	* @param xrefStdId the xref std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards cross reference
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException if a matching standards cross reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCrossReference findByrefStdId_Last(
		long xrefStdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standards cross reference in the ordered set where xrefStdId = &#63;.
	*
	* @param xrefStdId the xref std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards cross reference, or <code>null</code> if a matching standards cross reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCrossReference fetchByrefStdId_Last(
		long xrefStdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards cross references before and after the current standards cross reference in the ordered set where xrefStdId = &#63;.
	*
	* @param standardsCrossReferencePK the primary key of the current standards cross reference
	* @param xrefStdId the xref std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards cross reference
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException if a standards cross reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCrossReference[] findByrefStdId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK standardsCrossReferencePK,
		long xrefStdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standards cross references where xrefStdId = &#63; from the database.
	*
	* @param xrefStdId the xref std ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByrefStdId(long xrefStdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standards cross references where xrefStdId = &#63;.
	*
	* @param xrefStdId the xref std ID
	* @return the number of matching standards cross references
	* @throws SystemException if a system exception occurred
	*/
	public int countByrefStdId(long xrefStdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the standards cross reference in the entity cache if it is enabled.
	*
	* @param standardsCrossReference the standards cross reference
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.StandardsCrossReference standardsCrossReference);

	/**
	* Caches the standards cross references in the entity cache if it is enabled.
	*
	* @param standardsCrossReferences the standards cross references
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.StandardsCrossReference> standardsCrossReferences);

	/**
	* Creates a new standards cross reference with the primary key. Does not add the standards cross reference to the database.
	*
	* @param standardsCrossReferencePK the primary key for the new standards cross reference
	* @return the new standards cross reference
	*/
	public com.ihg.brandstandards.db.model.StandardsCrossReference create(
		com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK standardsCrossReferencePK);

	/**
	* Removes the standards cross reference with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsCrossReferencePK the primary key of the standards cross reference
	* @return the standards cross reference that was removed
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException if a standards cross reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCrossReference remove(
		com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK standardsCrossReferencePK)
		throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.StandardsCrossReference updateImpl(
		com.ihg.brandstandards.db.model.StandardsCrossReference standardsCrossReference)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards cross reference with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException} if it could not be found.
	*
	* @param standardsCrossReferencePK the primary key of the standards cross reference
	* @return the standards cross reference
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException if a standards cross reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCrossReference findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK standardsCrossReferencePK)
		throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards cross reference with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param standardsCrossReferencePK the primary key of the standards cross reference
	* @return the standards cross reference, or <code>null</code> if a standards cross reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCrossReference fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK standardsCrossReferencePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the standards cross references.
	*
	* @return the standards cross references
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCrossReference> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the standards cross references.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCrossReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards cross references
	* @param end the upper bound of the range of standards cross references (not inclusive)
	* @return the range of standards cross references
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCrossReference> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the standards cross references.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCrossReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards cross references
	* @param end the upper bound of the range of standards cross references (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of standards cross references
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCrossReference> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standards cross references from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standards cross references.
	*
	* @return the number of standards cross references
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}