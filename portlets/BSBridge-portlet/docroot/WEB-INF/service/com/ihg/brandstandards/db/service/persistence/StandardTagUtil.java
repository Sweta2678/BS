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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the standard tag service. This utility wraps {@link StandardTagPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardTagPersistence
 * @see StandardTagPersistenceImpl
 * @generated
 */
public class StandardTagUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(StandardTag standardTag) {
		getPersistence().clearCache(standardTag);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StandardTag> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StandardTag> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StandardTag> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static StandardTag update(StandardTag standardTag)
		throws SystemException {
		return getPersistence().update(standardTag);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static StandardTag update(StandardTag standardTag,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(standardTag, serviceContext);
	}

	/**
	* Returns all the standard tags where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the matching standard tags
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardTag> findBystdId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystdId(stdId);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.StandardTag> findBystdId(
		long stdId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystdId(stdId, start, end);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.StandardTag> findBystdId(
		long stdId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystdId(stdId, start, end, orderByComparator);
	}

	/**
	* Returns the first standard tag in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standard tag
	* @throws com.ihg.brandstandards.db.NoSuchStandardTagException if a matching standard tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardTag findBystdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardTagException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystdId_First(stdId, orderByComparator);
	}

	/**
	* Returns the first standard tag in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standard tag, or <code>null</code> if a matching standard tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardTag fetchBystdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBystdId_First(stdId, orderByComparator);
	}

	/**
	* Returns the last standard tag in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standard tag
	* @throws com.ihg.brandstandards.db.NoSuchStandardTagException if a matching standard tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardTag findBystdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardTagException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystdId_Last(stdId, orderByComparator);
	}

	/**
	* Returns the last standard tag in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standard tag, or <code>null</code> if a matching standard tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardTag fetchBystdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBystdId_Last(stdId, orderByComparator);
	}

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
	public static com.ihg.brandstandards.db.model.StandardTag[] findBystdId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.StandardTagPK standardTagPK,
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardTagException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBystdId_PrevAndNext(standardTagPK, stdId,
			orderByComparator);
	}

	/**
	* Removes all the standard tags where stdId = &#63; from the database.
	*
	* @param stdId the std ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBystdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBystdId(stdId);
	}

	/**
	* Returns the number of standard tags where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the number of matching standard tags
	* @throws SystemException if a system exception occurred
	*/
	public static int countBystdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBystdId(stdId);
	}

	/**
	* Returns all the standard tags where tag = &#63;.
	*
	* @param tag the tag
	* @return the matching standard tags
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardTag> findBytag(
		java.lang.String tag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBytag(tag);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.StandardTag> findBytag(
		java.lang.String tag, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBytag(tag, start, end);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.StandardTag> findBytag(
		java.lang.String tag, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBytag(tag, start, end, orderByComparator);
	}

	/**
	* Returns the first standard tag in the ordered set where tag = &#63;.
	*
	* @param tag the tag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standard tag
	* @throws com.ihg.brandstandards.db.NoSuchStandardTagException if a matching standard tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardTag findBytag_First(
		java.lang.String tag,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardTagException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBytag_First(tag, orderByComparator);
	}

	/**
	* Returns the first standard tag in the ordered set where tag = &#63;.
	*
	* @param tag the tag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standard tag, or <code>null</code> if a matching standard tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardTag fetchBytag_First(
		java.lang.String tag,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBytag_First(tag, orderByComparator);
	}

	/**
	* Returns the last standard tag in the ordered set where tag = &#63;.
	*
	* @param tag the tag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standard tag
	* @throws com.ihg.brandstandards.db.NoSuchStandardTagException if a matching standard tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardTag findBytag_Last(
		java.lang.String tag,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardTagException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBytag_Last(tag, orderByComparator);
	}

	/**
	* Returns the last standard tag in the ordered set where tag = &#63;.
	*
	* @param tag the tag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standard tag, or <code>null</code> if a matching standard tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardTag fetchBytag_Last(
		java.lang.String tag,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBytag_Last(tag, orderByComparator);
	}

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
	public static com.ihg.brandstandards.db.model.StandardTag[] findBytag_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.StandardTagPK standardTagPK,
		java.lang.String tag,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardTagException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBytag_PrevAndNext(standardTagPK, tag, orderByComparator);
	}

	/**
	* Removes all the standard tags where tag = &#63; from the database.
	*
	* @param tag the tag
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBytag(java.lang.String tag)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBytag(tag);
	}

	/**
	* Returns the number of standard tags where tag = &#63;.
	*
	* @param tag the tag
	* @return the number of matching standard tags
	* @throws SystemException if a system exception occurred
	*/
	public static int countBytag(java.lang.String tag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBytag(tag);
	}

	/**
	* Returns the standard tag where stdId = &#63; and tag = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchStandardTagException} if it could not be found.
	*
	* @param stdId the std ID
	* @param tag the tag
	* @return the matching standard tag
	* @throws com.ihg.brandstandards.db.NoSuchStandardTagException if a matching standard tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardTag findBystdIdWithTag(
		long stdId, java.lang.String tag)
		throws com.ihg.brandstandards.db.NoSuchStandardTagException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystdIdWithTag(stdId, tag);
	}

	/**
	* Returns the standard tag where stdId = &#63; and tag = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param stdId the std ID
	* @param tag the tag
	* @return the matching standard tag, or <code>null</code> if a matching standard tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardTag fetchBystdIdWithTag(
		long stdId, java.lang.String tag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBystdIdWithTag(stdId, tag);
	}

	/**
	* Returns the standard tag where stdId = &#63; and tag = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param stdId the std ID
	* @param tag the tag
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching standard tag, or <code>null</code> if a matching standard tag could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardTag fetchBystdIdWithTag(
		long stdId, java.lang.String tag, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBystdIdWithTag(stdId, tag, retrieveFromCache);
	}

	/**
	* Removes the standard tag where stdId = &#63; and tag = &#63; from the database.
	*
	* @param stdId the std ID
	* @param tag the tag
	* @return the standard tag that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardTag removeBystdIdWithTag(
		long stdId, java.lang.String tag)
		throws com.ihg.brandstandards.db.NoSuchStandardTagException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeBystdIdWithTag(stdId, tag);
	}

	/**
	* Returns the number of standard tags where stdId = &#63; and tag = &#63;.
	*
	* @param stdId the std ID
	* @param tag the tag
	* @return the number of matching standard tags
	* @throws SystemException if a system exception occurred
	*/
	public static int countBystdIdWithTag(long stdId, java.lang.String tag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBystdIdWithTag(stdId, tag);
	}

	/**
	* Caches the standard tag in the entity cache if it is enabled.
	*
	* @param standardTag the standard tag
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.StandardTag standardTag) {
		getPersistence().cacheResult(standardTag);
	}

	/**
	* Caches the standard tags in the entity cache if it is enabled.
	*
	* @param standardTags the standard tags
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.StandardTag> standardTags) {
		getPersistence().cacheResult(standardTags);
	}

	/**
	* Creates a new standard tag with the primary key. Does not add the standard tag to the database.
	*
	* @param standardTagPK the primary key for the new standard tag
	* @return the new standard tag
	*/
	public static com.ihg.brandstandards.db.model.StandardTag create(
		com.ihg.brandstandards.db.service.persistence.StandardTagPK standardTagPK) {
		return getPersistence().create(standardTagPK);
	}

	/**
	* Removes the standard tag with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param standardTagPK the primary key of the standard tag
	* @return the standard tag that was removed
	* @throws com.ihg.brandstandards.db.NoSuchStandardTagException if a standard tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardTag remove(
		com.ihg.brandstandards.db.service.persistence.StandardTagPK standardTagPK)
		throws com.ihg.brandstandards.db.NoSuchStandardTagException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(standardTagPK);
	}

	public static com.ihg.brandstandards.db.model.StandardTag updateImpl(
		com.ihg.brandstandards.db.model.StandardTag standardTag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(standardTag);
	}

	/**
	* Returns the standard tag with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardTagException} if it could not be found.
	*
	* @param standardTagPK the primary key of the standard tag
	* @return the standard tag
	* @throws com.ihg.brandstandards.db.NoSuchStandardTagException if a standard tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardTag findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardTagPK standardTagPK)
		throws com.ihg.brandstandards.db.NoSuchStandardTagException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(standardTagPK);
	}

	/**
	* Returns the standard tag with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param standardTagPK the primary key of the standard tag
	* @return the standard tag, or <code>null</code> if a standard tag with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardTag fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardTagPK standardTagPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(standardTagPK);
	}

	/**
	* Returns all the standard tags.
	*
	* @return the standard tags
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardTag> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.StandardTag> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.StandardTag> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the standard tags from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of standard tags.
	*
	* @return the number of standard tags
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StandardTagPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StandardTagPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					StandardTagPersistence.class.getName());

			ReferenceRegistry.registerReference(StandardTagUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(StandardTagPersistence persistence) {
	}

	private static StandardTagPersistence _persistence;
}