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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the glossary service. This utility wraps {@link GlossaryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GlossaryPersistence
 * @see GlossaryPersistenceImpl
 * @generated
 */
public class GlossaryUtil {
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
	public static void clearCache(Glossary glossary) {
		getPersistence().clearCache(glossary);
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
	public static List<Glossary> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Glossary> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Glossary> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Glossary update(Glossary glossary) throws SystemException {
		return getPersistence().update(glossary);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Glossary update(Glossary glossary,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(glossary, serviceContext);
	}

	/**
	* Returns all the glossaries where glossaryId = &#63; and glossaryTermText LIKE &#63;.
	*
	* @param glossaryId the glossary ID
	* @param glossaryTermText the glossary term text
	* @return the matching glossaries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Glossary> findByglossaryId(
		long glossaryId, java.lang.String glossaryTermText)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByglossaryId(glossaryId, glossaryTermText);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.Glossary> findByglossaryId(
		long glossaryId, java.lang.String glossaryTermText, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByglossaryId(glossaryId, glossaryTermText, start, end);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.Glossary> findByglossaryId(
		long glossaryId, java.lang.String glossaryTermText, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByglossaryId(glossaryId, glossaryTermText, start, end,
			orderByComparator);
	}

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
	public static com.ihg.brandstandards.db.model.Glossary findByglossaryId_First(
		long glossaryId, java.lang.String glossaryTermText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGlossaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByglossaryId_First(glossaryId, glossaryTermText,
			orderByComparator);
	}

	/**
	* Returns the first glossary in the ordered set where glossaryId = &#63; and glossaryTermText LIKE &#63;.
	*
	* @param glossaryId the glossary ID
	* @param glossaryTermText the glossary term text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching glossary, or <code>null</code> if a matching glossary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Glossary fetchByglossaryId_First(
		long glossaryId, java.lang.String glossaryTermText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByglossaryId_First(glossaryId, glossaryTermText,
			orderByComparator);
	}

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
	public static com.ihg.brandstandards.db.model.Glossary findByglossaryId_Last(
		long glossaryId, java.lang.String glossaryTermText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGlossaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByglossaryId_Last(glossaryId, glossaryTermText,
			orderByComparator);
	}

	/**
	* Returns the last glossary in the ordered set where glossaryId = &#63; and glossaryTermText LIKE &#63;.
	*
	* @param glossaryId the glossary ID
	* @param glossaryTermText the glossary term text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching glossary, or <code>null</code> if a matching glossary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Glossary fetchByglossaryId_Last(
		long glossaryId, java.lang.String glossaryTermText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByglossaryId_Last(glossaryId, glossaryTermText,
			orderByComparator);
	}

	/**
	* Removes all the glossaries where glossaryId = &#63; and glossaryTermText LIKE &#63; from the database.
	*
	* @param glossaryId the glossary ID
	* @param glossaryTermText the glossary term text
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByglossaryId(long glossaryId,
		java.lang.String glossaryTermText)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByglossaryId(glossaryId, glossaryTermText);
	}

	/**
	* Returns the number of glossaries where glossaryId = &#63; and glossaryTermText LIKE &#63;.
	*
	* @param glossaryId the glossary ID
	* @param glossaryTermText the glossary term text
	* @return the number of matching glossaries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByglossaryId(long glossaryId,
		java.lang.String glossaryTermText)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByglossaryId(glossaryId, glossaryTermText);
	}

	/**
	* Returns the glossary where glossaryTermText = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchGlossaryException} if it could not be found.
	*
	* @param glossaryTermText the glossary term text
	* @return the matching glossary
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryException if a matching glossary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Glossary findByglossaryTermText(
		java.lang.String glossaryTermText)
		throws com.ihg.brandstandards.db.NoSuchGlossaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByglossaryTermText(glossaryTermText);
	}

	/**
	* Returns the glossary where glossaryTermText = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param glossaryTermText the glossary term text
	* @return the matching glossary, or <code>null</code> if a matching glossary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Glossary fetchByglossaryTermText(
		java.lang.String glossaryTermText)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByglossaryTermText(glossaryTermText);
	}

	/**
	* Returns the glossary where glossaryTermText = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param glossaryTermText the glossary term text
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching glossary, or <code>null</code> if a matching glossary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Glossary fetchByglossaryTermText(
		java.lang.String glossaryTermText, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByglossaryTermText(glossaryTermText, retrieveFromCache);
	}

	/**
	* Removes the glossary where glossaryTermText = &#63; from the database.
	*
	* @param glossaryTermText the glossary term text
	* @return the glossary that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Glossary removeByglossaryTermText(
		java.lang.String glossaryTermText)
		throws com.ihg.brandstandards.db.NoSuchGlossaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByglossaryTermText(glossaryTermText);
	}

	/**
	* Returns the number of glossaries where glossaryTermText = &#63;.
	*
	* @param glossaryTermText the glossary term text
	* @return the number of matching glossaries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByglossaryTermText(java.lang.String glossaryTermText)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByglossaryTermText(glossaryTermText);
	}

	/**
	* Caches the glossary in the entity cache if it is enabled.
	*
	* @param glossary the glossary
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.Glossary glossary) {
		getPersistence().cacheResult(glossary);
	}

	/**
	* Caches the glossaries in the entity cache if it is enabled.
	*
	* @param glossaries the glossaries
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.Glossary> glossaries) {
		getPersistence().cacheResult(glossaries);
	}

	/**
	* Creates a new glossary with the primary key. Does not add the glossary to the database.
	*
	* @param glossaryId the primary key for the new glossary
	* @return the new glossary
	*/
	public static com.ihg.brandstandards.db.model.Glossary create(
		long glossaryId) {
		return getPersistence().create(glossaryId);
	}

	/**
	* Removes the glossary with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param glossaryId the primary key of the glossary
	* @return the glossary that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryException if a glossary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Glossary remove(
		long glossaryId)
		throws com.ihg.brandstandards.db.NoSuchGlossaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(glossaryId);
	}

	public static com.ihg.brandstandards.db.model.Glossary updateImpl(
		com.ihg.brandstandards.db.model.Glossary glossary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(glossary);
	}

	/**
	* Returns the glossary with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGlossaryException} if it could not be found.
	*
	* @param glossaryId the primary key of the glossary
	* @return the glossary
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryException if a glossary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Glossary findByPrimaryKey(
		long glossaryId)
		throws com.ihg.brandstandards.db.NoSuchGlossaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(glossaryId);
	}

	/**
	* Returns the glossary with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param glossaryId the primary key of the glossary
	* @return the glossary, or <code>null</code> if a glossary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Glossary fetchByPrimaryKey(
		long glossaryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(glossaryId);
	}

	/**
	* Returns all the glossaries.
	*
	* @return the glossaries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Glossary> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.Glossary> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.Glossary> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the glossaries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of glossaries.
	*
	* @return the number of glossaries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GlossaryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GlossaryPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					GlossaryPersistence.class.getName());

			ReferenceRegistry.registerReference(GlossaryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GlossaryPersistence persistence) {
	}

	private static GlossaryPersistence _persistence;
}