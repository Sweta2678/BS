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

import com.ihg.brandstandards.db.model.Glossary;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the glossary service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GlossaryPersistenceImpl
 * @see GlossaryUtil
 * @generated
 */
public interface GlossaryPersistence extends BasePersistence<Glossary> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GlossaryUtil} to access the glossary persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the glossaries where glossaryId = &#63; and glossaryTermText LIKE &#63;.
	*
	* @param glossaryId the glossary ID
	* @param glossaryTermText the glossary term text
	* @return the matching glossaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Glossary> findByglossaryId(
		long glossaryId, java.lang.String glossaryTermText)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the glossaries where glossaryId = &#63; and glossaryTermText LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param glossaryId the glossary ID
	* @param glossaryTermText the glossary term text
	* @param start the lower bound of the range of glossaries
	* @param end the upper bound of the range of glossaries (not inclusive)
	* @return the range of matching glossaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Glossary> findByglossaryId(
		long glossaryId, java.lang.String glossaryTermText, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the glossaries where glossaryId = &#63; and glossaryTermText LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param glossaryId the glossary ID
	* @param glossaryTermText the glossary term text
	* @param start the lower bound of the range of glossaries
	* @param end the upper bound of the range of glossaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching glossaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Glossary> findByglossaryId(
		long glossaryId, java.lang.String glossaryTermText, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first glossary in the ordered set where glossaryId = &#63; and glossaryTermText LIKE &#63;.
	*
	* @param glossaryId the glossary ID
	* @param glossaryTermText the glossary term text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching glossary
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryException if a matching glossary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Glossary findByglossaryId_First(
		long glossaryId, java.lang.String glossaryTermText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGlossaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first glossary in the ordered set where glossaryId = &#63; and glossaryTermText LIKE &#63;.
	*
	* @param glossaryId the glossary ID
	* @param glossaryTermText the glossary term text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching glossary, or <code>null</code> if a matching glossary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Glossary fetchByglossaryId_First(
		long glossaryId, java.lang.String glossaryTermText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last glossary in the ordered set where glossaryId = &#63; and glossaryTermText LIKE &#63;.
	*
	* @param glossaryId the glossary ID
	* @param glossaryTermText the glossary term text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching glossary
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryException if a matching glossary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Glossary findByglossaryId_Last(
		long glossaryId, java.lang.String glossaryTermText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGlossaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last glossary in the ordered set where glossaryId = &#63; and glossaryTermText LIKE &#63;.
	*
	* @param glossaryId the glossary ID
	* @param glossaryTermText the glossary term text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching glossary, or <code>null</code> if a matching glossary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Glossary fetchByglossaryId_Last(
		long glossaryId, java.lang.String glossaryTermText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the glossaries where glossaryId = &#63; and glossaryTermText LIKE &#63; from the database.
	*
	* @param glossaryId the glossary ID
	* @param glossaryTermText the glossary term text
	* @throws SystemException if a system exception occurred
	*/
	public void removeByglossaryId(long glossaryId,
		java.lang.String glossaryTermText)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of glossaries where glossaryId = &#63; and glossaryTermText LIKE &#63;.
	*
	* @param glossaryId the glossary ID
	* @param glossaryTermText the glossary term text
	* @return the number of matching glossaries
	* @throws SystemException if a system exception occurred
	*/
	public int countByglossaryId(long glossaryId,
		java.lang.String glossaryTermText)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the glossary where glossaryTermText = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchGlossaryException} if it could not be found.
	*
	* @param glossaryTermText the glossary term text
	* @return the matching glossary
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryException if a matching glossary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Glossary findByglossaryTermText(
		java.lang.String glossaryTermText)
		throws com.ihg.brandstandards.db.NoSuchGlossaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the glossary where glossaryTermText = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param glossaryTermText the glossary term text
	* @return the matching glossary, or <code>null</code> if a matching glossary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Glossary fetchByglossaryTermText(
		java.lang.String glossaryTermText)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the glossary where glossaryTermText = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param glossaryTermText the glossary term text
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching glossary, or <code>null</code> if a matching glossary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Glossary fetchByglossaryTermText(
		java.lang.String glossaryTermText, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the glossary where glossaryTermText = &#63; from the database.
	*
	* @param glossaryTermText the glossary term text
	* @return the glossary that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Glossary removeByglossaryTermText(
		java.lang.String glossaryTermText)
		throws com.ihg.brandstandards.db.NoSuchGlossaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of glossaries where glossaryTermText = &#63;.
	*
	* @param glossaryTermText the glossary term text
	* @return the number of matching glossaries
	* @throws SystemException if a system exception occurred
	*/
	public int countByglossaryTermText(java.lang.String glossaryTermText)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the glossary in the entity cache if it is enabled.
	*
	* @param glossary the glossary
	*/
	public void cacheResult(com.ihg.brandstandards.db.model.Glossary glossary);

	/**
	* Caches the glossaries in the entity cache if it is enabled.
	*
	* @param glossaries the glossaries
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.Glossary> glossaries);

	/**
	* Creates a new glossary with the primary key. Does not add the glossary to the database.
	*
	* @param glossaryId the primary key for the new glossary
	* @return the new glossary
	*/
	public com.ihg.brandstandards.db.model.Glossary create(long glossaryId);

	/**
	* Removes the glossary with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param glossaryId the primary key of the glossary
	* @return the glossary that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryException if a glossary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Glossary remove(long glossaryId)
		throws com.ihg.brandstandards.db.NoSuchGlossaryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.Glossary updateImpl(
		com.ihg.brandstandards.db.model.Glossary glossary)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the glossary with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGlossaryException} if it could not be found.
	*
	* @param glossaryId the primary key of the glossary
	* @return the glossary
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryException if a glossary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Glossary findByPrimaryKey(
		long glossaryId)
		throws com.ihg.brandstandards.db.NoSuchGlossaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the glossary with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param glossaryId the primary key of the glossary
	* @return the glossary, or <code>null</code> if a glossary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Glossary fetchByPrimaryKey(
		long glossaryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the glossaries.
	*
	* @return the glossaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Glossary> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the glossaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of glossaries
	* @param end the upper bound of the range of glossaries (not inclusive)
	* @return the range of glossaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Glossary> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the glossaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of glossaries
	* @param end the upper bound of the range of glossaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of glossaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Glossary> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the glossaries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of glossaries.
	*
	* @return the number of glossaries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}