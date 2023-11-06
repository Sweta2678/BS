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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the standards cross reference service. This utility wraps {@link StandardsCrossReferencePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsCrossReferencePersistence
 * @see StandardsCrossReferencePersistenceImpl
 * @generated
 */
public class StandardsCrossReferenceUtil {
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
	public static void clearCache(
		StandardsCrossReference standardsCrossReference) {
		getPersistence().clearCache(standardsCrossReference);
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
	public static List<StandardsCrossReference> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StandardsCrossReference> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StandardsCrossReference> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static StandardsCrossReference update(
		StandardsCrossReference standardsCrossReference)
		throws SystemException {
		return getPersistence().update(standardsCrossReference);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static StandardsCrossReference update(
		StandardsCrossReference standardsCrossReference,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(standardsCrossReference, serviceContext);
	}

	/**
	* Returns all the standards cross references where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the matching standards cross references
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCrossReference> findByStdId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId(stdId);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCrossReference> findByStdId(
		long stdId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId(stdId, start, end);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCrossReference> findByStdId(
		long stdId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId(stdId, start, end, orderByComparator);
	}

	/**
	* Returns the first standards cross reference in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards cross reference
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException if a matching standards cross reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCrossReference findByStdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId_First(stdId, orderByComparator);
	}

	/**
	* Returns the first standards cross reference in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards cross reference, or <code>null</code> if a matching standards cross reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCrossReference fetchByStdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStdId_First(stdId, orderByComparator);
	}

	/**
	* Returns the last standards cross reference in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards cross reference
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException if a matching standards cross reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCrossReference findByStdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId_Last(stdId, orderByComparator);
	}

	/**
	* Returns the last standards cross reference in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards cross reference, or <code>null</code> if a matching standards cross reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCrossReference fetchByStdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStdId_Last(stdId, orderByComparator);
	}

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
	public static com.ihg.brandstandards.db.model.StandardsCrossReference[] findByStdId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK standardsCrossReferencePK,
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdId_PrevAndNext(standardsCrossReferencePK, stdId,
			orderByComparator);
	}

	/**
	* Removes all the standards cross references where stdId = &#63; from the database.
	*
	* @param stdId the std ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStdId(stdId);
	}

	/**
	* Returns the number of standards cross references where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the number of matching standards cross references
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStdId(stdId);
	}

	/**
	* Returns all the standards cross references where xrefStdId = &#63;.
	*
	* @param xrefStdId the xref std ID
	* @return the matching standards cross references
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCrossReference> findByrefStdId(
		long xrefStdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByrefStdId(xrefStdId);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCrossReference> findByrefStdId(
		long xrefStdId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByrefStdId(xrefStdId, start, end);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCrossReference> findByrefStdId(
		long xrefStdId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByrefStdId(xrefStdId, start, end, orderByComparator);
	}

	/**
	* Returns the first standards cross reference in the ordered set where xrefStdId = &#63;.
	*
	* @param xrefStdId the xref std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards cross reference
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException if a matching standards cross reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCrossReference findByrefStdId_First(
		long xrefStdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByrefStdId_First(xrefStdId, orderByComparator);
	}

	/**
	* Returns the first standards cross reference in the ordered set where xrefStdId = &#63;.
	*
	* @param xrefStdId the xref std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards cross reference, or <code>null</code> if a matching standards cross reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCrossReference fetchByrefStdId_First(
		long xrefStdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByrefStdId_First(xrefStdId, orderByComparator);
	}

	/**
	* Returns the last standards cross reference in the ordered set where xrefStdId = &#63;.
	*
	* @param xrefStdId the xref std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards cross reference
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException if a matching standards cross reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCrossReference findByrefStdId_Last(
		long xrefStdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByrefStdId_Last(xrefStdId, orderByComparator);
	}

	/**
	* Returns the last standards cross reference in the ordered set where xrefStdId = &#63;.
	*
	* @param xrefStdId the xref std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards cross reference, or <code>null</code> if a matching standards cross reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCrossReference fetchByrefStdId_Last(
		long xrefStdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByrefStdId_Last(xrefStdId, orderByComparator);
	}

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
	public static com.ihg.brandstandards.db.model.StandardsCrossReference[] findByrefStdId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK standardsCrossReferencePK,
		long xrefStdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByrefStdId_PrevAndNext(standardsCrossReferencePK,
			xrefStdId, orderByComparator);
	}

	/**
	* Removes all the standards cross references where xrefStdId = &#63; from the database.
	*
	* @param xrefStdId the xref std ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByrefStdId(long xrefStdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByrefStdId(xrefStdId);
	}

	/**
	* Returns the number of standards cross references where xrefStdId = &#63;.
	*
	* @param xrefStdId the xref std ID
	* @return the number of matching standards cross references
	* @throws SystemException if a system exception occurred
	*/
	public static int countByrefStdId(long xrefStdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByrefStdId(xrefStdId);
	}

	/**
	* Caches the standards cross reference in the entity cache if it is enabled.
	*
	* @param standardsCrossReference the standards cross reference
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.StandardsCrossReference standardsCrossReference) {
		getPersistence().cacheResult(standardsCrossReference);
	}

	/**
	* Caches the standards cross references in the entity cache if it is enabled.
	*
	* @param standardsCrossReferences the standards cross references
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.StandardsCrossReference> standardsCrossReferences) {
		getPersistence().cacheResult(standardsCrossReferences);
	}

	/**
	* Creates a new standards cross reference with the primary key. Does not add the standards cross reference to the database.
	*
	* @param standardsCrossReferencePK the primary key for the new standards cross reference
	* @return the new standards cross reference
	*/
	public static com.ihg.brandstandards.db.model.StandardsCrossReference create(
		com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK standardsCrossReferencePK) {
		return getPersistence().create(standardsCrossReferencePK);
	}

	/**
	* Removes the standards cross reference with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsCrossReferencePK the primary key of the standards cross reference
	* @return the standards cross reference that was removed
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException if a standards cross reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCrossReference remove(
		com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK standardsCrossReferencePK)
		throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(standardsCrossReferencePK);
	}

	public static com.ihg.brandstandards.db.model.StandardsCrossReference updateImpl(
		com.ihg.brandstandards.db.model.StandardsCrossReference standardsCrossReference)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(standardsCrossReference);
	}

	/**
	* Returns the standards cross reference with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException} if it could not be found.
	*
	* @param standardsCrossReferencePK the primary key of the standards cross reference
	* @return the standards cross reference
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException if a standards cross reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCrossReference findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK standardsCrossReferencePK)
		throws com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(standardsCrossReferencePK);
	}

	/**
	* Returns the standards cross reference with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param standardsCrossReferencePK the primary key of the standards cross reference
	* @return the standards cross reference, or <code>null</code> if a standards cross reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCrossReference fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK standardsCrossReferencePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(standardsCrossReferencePK);
	}

	/**
	* Returns all the standards cross references.
	*
	* @return the standards cross references
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCrossReference> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCrossReference> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCrossReference> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the standards cross references from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of standards cross references.
	*
	* @return the number of standards cross references
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StandardsCrossReferencePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StandardsCrossReferencePersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					StandardsCrossReferencePersistence.class.getName());

			ReferenceRegistry.registerReference(StandardsCrossReferenceUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(StandardsCrossReferencePersistence persistence) {
	}

	private static StandardsCrossReferencePersistence _persistence;
}