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

import com.ihg.brandstandards.db.model.StandardTag;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the standard tag service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardTagPersistenceImpl
 * @see StandardTagUtil
 * @generated
 */
public interface StandardTagPersistence extends BasePersistence<StandardTag> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StandardTagUtil} to access the standard tag persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the standard tags where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the matching standard tags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardTag> findBystdId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the standard tags where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of standard tags
	* @param end the upper bound of the range of standard tags (not inclusive)
	* @return the range of matching standard tags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardTag> findBystdId(
		long stdId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the standard tags where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of standard tags
	* @param end the upper bound of the range of standard tags (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standard tags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardTag> findBystdId(
		long stdId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standard tag in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standard tag
	* @throws com.ihg.brandstandards.db.NoSuchStandardTagException if a matching standard tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardTag findBystdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardTagException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standard tag in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standard tag, or <code>null</code> if a matching standard tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardTag fetchBystdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standard tag in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standard tag
	* @throws com.ihg.brandstandards.db.NoSuchStandardTagException if a matching standard tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardTag findBystdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardTagException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standard tag in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standard tag, or <code>null</code> if a matching standard tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardTag fetchBystdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standard tags before and after the current standard tag in the ordered set where stdId = &#63;.
	*
	* @param standardTagPK the primary key of the current standard tag
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standard tag
	* @throws com.ihg.brandstandards.db.NoSuchStandardTagException if a standard tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardTag[] findBystdId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.StandardTagPK standardTagPK,
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardTagException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standard tags where stdId = &#63; from the database.
	*
	* @param stdId the std ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBystdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standard tags where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the number of matching standard tags
	* @throws SystemException if a system exception occurred
	*/
	public int countBystdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the standard tags where tag = &#63;.
	*
	* @param tag the tag
	* @return the matching standard tags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardTag> findBytag(
		java.lang.String tag)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the standard tags where tag = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tag the tag
	* @param start the lower bound of the range of standard tags
	* @param end the upper bound of the range of standard tags (not inclusive)
	* @return the range of matching standard tags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardTag> findBytag(
		java.lang.String tag, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the standard tags where tag = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tag the tag
	* @param start the lower bound of the range of standard tags
	* @param end the upper bound of the range of standard tags (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standard tags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardTag> findBytag(
		java.lang.String tag, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standard tag in the ordered set where tag = &#63;.
	*
	* @param tag the tag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standard tag
	* @throws com.ihg.brandstandards.db.NoSuchStandardTagException if a matching standard tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardTag findBytag_First(
		java.lang.String tag,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardTagException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standard tag in the ordered set where tag = &#63;.
	*
	* @param tag the tag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standard tag, or <code>null</code> if a matching standard tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardTag fetchBytag_First(
		java.lang.String tag,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standard tag in the ordered set where tag = &#63;.
	*
	* @param tag the tag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standard tag
	* @throws com.ihg.brandstandards.db.NoSuchStandardTagException if a matching standard tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardTag findBytag_Last(
		java.lang.String tag,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardTagException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standard tag in the ordered set where tag = &#63;.
	*
	* @param tag the tag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standard tag, or <code>null</code> if a matching standard tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardTag fetchBytag_Last(
		java.lang.String tag,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standard tags before and after the current standard tag in the ordered set where tag = &#63;.
	*
	* @param standardTagPK the primary key of the current standard tag
	* @param tag the tag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standard tag
	* @throws com.ihg.brandstandards.db.NoSuchStandardTagException if a standard tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardTag[] findBytag_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.StandardTagPK standardTagPK,
		java.lang.String tag,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardTagException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standard tags where tag = &#63; from the database.
	*
	* @param tag the tag
	* @throws SystemException if a system exception occurred
	*/
	public void removeBytag(java.lang.String tag)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standard tags where tag = &#63;.
	*
	* @param tag the tag
	* @return the number of matching standard tags
	* @throws SystemException if a system exception occurred
	*/
	public int countBytag(java.lang.String tag)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standard tag where stdId = &#63; and tag = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchStandardTagException} if it could not be found.
	*
	* @param stdId the std ID
	* @param tag the tag
	* @return the matching standard tag
	* @throws com.ihg.brandstandards.db.NoSuchStandardTagException if a matching standard tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardTag findBystdIdWithTag(
		long stdId, java.lang.String tag)
		throws com.ihg.brandstandards.db.NoSuchStandardTagException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standard tag where stdId = &#63; and tag = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param stdId the std ID
	* @param tag the tag
	* @return the matching standard tag, or <code>null</code> if a matching standard tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardTag fetchBystdIdWithTag(
		long stdId, java.lang.String tag)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standard tag where stdId = &#63; and tag = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param stdId the std ID
	* @param tag the tag
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching standard tag, or <code>null</code> if a matching standard tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardTag fetchBystdIdWithTag(
		long stdId, java.lang.String tag, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the standard tag where stdId = &#63; and tag = &#63; from the database.
	*
	* @param stdId the std ID
	* @param tag the tag
	* @return the standard tag that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardTag removeBystdIdWithTag(
		long stdId, java.lang.String tag)
		throws com.ihg.brandstandards.db.NoSuchStandardTagException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standard tags where stdId = &#63; and tag = &#63;.
	*
	* @param stdId the std ID
	* @param tag the tag
	* @return the number of matching standard tags
	* @throws SystemException if a system exception occurred
	*/
	public int countBystdIdWithTag(long stdId, java.lang.String tag)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the standard tag in the entity cache if it is enabled.
	*
	* @param standardTag the standard tag
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.StandardTag standardTag);

	/**
	* Caches the standard tags in the entity cache if it is enabled.
	*
	* @param standardTags the standard tags
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.StandardTag> standardTags);

	/**
	* Creates a new standard tag with the primary key. Does not add the standard tag to the database.
	*
	* @param standardTagPK the primary key for the new standard tag
	* @return the new standard tag
	*/
	public com.ihg.brandstandards.db.model.StandardTag create(
		com.ihg.brandstandards.db.service.persistence.StandardTagPK standardTagPK);

	/**
	* Removes the standard tag with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param standardTagPK the primary key of the standard tag
	* @return the standard tag that was removed
	* @throws com.ihg.brandstandards.db.NoSuchStandardTagException if a standard tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardTag remove(
		com.ihg.brandstandards.db.service.persistence.StandardTagPK standardTagPK)
		throws com.ihg.brandstandards.db.NoSuchStandardTagException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.StandardTag updateImpl(
		com.ihg.brandstandards.db.model.StandardTag standardTag)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standard tag with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardTagException} if it could not be found.
	*
	* @param standardTagPK the primary key of the standard tag
	* @return the standard tag
	* @throws com.ihg.brandstandards.db.NoSuchStandardTagException if a standard tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardTag findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardTagPK standardTagPK)
		throws com.ihg.brandstandards.db.NoSuchStandardTagException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standard tag with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param standardTagPK the primary key of the standard tag
	* @return the standard tag, or <code>null</code> if a standard tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardTag fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardTagPK standardTagPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the standard tags.
	*
	* @return the standard tags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardTag> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the standard tags.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standard tags
	* @param end the upper bound of the range of standard tags (not inclusive)
	* @return the range of standard tags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardTag> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the standard tags.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standard tags
	* @param end the upper bound of the range of standard tags (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of standard tags
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardTag> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standard tags from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standard tags.
	*
	* @return the number of standard tags
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}