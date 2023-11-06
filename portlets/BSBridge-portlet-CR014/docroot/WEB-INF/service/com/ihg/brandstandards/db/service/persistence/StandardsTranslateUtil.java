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

import com.ihg.brandstandards.db.model.StandardsTranslate;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the standards translate service. This utility wraps {@link StandardsTranslatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsTranslatePersistence
 * @see StandardsTranslatePersistenceImpl
 * @generated
 */
public class StandardsTranslateUtil {
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
	public static void clearCache(StandardsTranslate standardsTranslate) {
		getPersistence().clearCache(standardsTranslate);
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
	public static List<StandardsTranslate> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StandardsTranslate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StandardsTranslate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static StandardsTranslate update(
		StandardsTranslate standardsTranslate) throws SystemException {
		return getPersistence().update(standardsTranslate);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static StandardsTranslate update(
		StandardsTranslate standardsTranslate, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(standardsTranslate, serviceContext);
	}

	/**
	* Returns all the standards translates where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the matching standards translates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsTranslate> findByStdId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId(stdId);
	}

	/**
	* Returns a range of all the standards translates where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of standards translates
	* @param end the upper bound of the range of standards translates (not inclusive)
	* @return the range of matching standards translates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsTranslate> findByStdId(
		long stdId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId(stdId, start, end);
	}

	/**
	* Returns an ordered range of all the standards translates where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of standards translates
	* @param end the upper bound of the range of standards translates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standards translates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsTranslate> findByStdId(
		long stdId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId(stdId, start, end, orderByComparator);
	}

	/**
	* Returns the first standards translate in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards translate
	* @throws com.ihg.brandstandards.db.NoSuchStandardsTranslateException if a matching standards translate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsTranslate findByStdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsTranslateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId_First(stdId, orderByComparator);
	}

	/**
	* Returns the first standards translate in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards translate, or <code>null</code> if a matching standards translate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsTranslate fetchByStdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStdId_First(stdId, orderByComparator);
	}

	/**
	* Returns the last standards translate in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards translate
	* @throws com.ihg.brandstandards.db.NoSuchStandardsTranslateException if a matching standards translate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsTranslate findByStdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsTranslateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId_Last(stdId, orderByComparator);
	}

	/**
	* Returns the last standards translate in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards translate, or <code>null</code> if a matching standards translate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsTranslate fetchByStdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStdId_Last(stdId, orderByComparator);
	}

	/**
	* Returns the standards translates before and after the current standards translate in the ordered set where stdId = &#63;.
	*
	* @param standardsTranslatePK the primary key of the current standards translate
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards translate
	* @throws com.ihg.brandstandards.db.NoSuchStandardsTranslateException if a standards translate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsTranslate[] findByStdId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.StandardsTranslatePK standardsTranslatePK,
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsTranslateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdId_PrevAndNext(standardsTranslatePK, stdId,
			orderByComparator);
	}

	/**
	* Removes all the standards translates where stdId = &#63; from the database.
	*
	* @param stdId the std ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStdId(stdId);
	}

	/**
	* Returns the number of standards translates where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the number of matching standards translates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStdId(stdId);
	}

	/**
	* Caches the standards translate in the entity cache if it is enabled.
	*
	* @param standardsTranslate the standards translate
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.StandardsTranslate standardsTranslate) {
		getPersistence().cacheResult(standardsTranslate);
	}

	/**
	* Caches the standards translates in the entity cache if it is enabled.
	*
	* @param standardsTranslates the standards translates
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.StandardsTranslate> standardsTranslates) {
		getPersistence().cacheResult(standardsTranslates);
	}

	/**
	* Creates a new standards translate with the primary key. Does not add the standards translate to the database.
	*
	* @param standardsTranslatePK the primary key for the new standards translate
	* @return the new standards translate
	*/
	public static com.ihg.brandstandards.db.model.StandardsTranslate create(
		com.ihg.brandstandards.db.service.persistence.StandardsTranslatePK standardsTranslatePK) {
		return getPersistence().create(standardsTranslatePK);
	}

	/**
	* Removes the standards translate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsTranslatePK the primary key of the standards translate
	* @return the standards translate that was removed
	* @throws com.ihg.brandstandards.db.NoSuchStandardsTranslateException if a standards translate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsTranslate remove(
		com.ihg.brandstandards.db.service.persistence.StandardsTranslatePK standardsTranslatePK)
		throws com.ihg.brandstandards.db.NoSuchStandardsTranslateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(standardsTranslatePK);
	}

	public static com.ihg.brandstandards.db.model.StandardsTranslate updateImpl(
		com.ihg.brandstandards.db.model.StandardsTranslate standardsTranslate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(standardsTranslate);
	}

	/**
	* Returns the standards translate with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsTranslateException} if it could not be found.
	*
	* @param standardsTranslatePK the primary key of the standards translate
	* @return the standards translate
	* @throws com.ihg.brandstandards.db.NoSuchStandardsTranslateException if a standards translate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsTranslate findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardsTranslatePK standardsTranslatePK)
		throws com.ihg.brandstandards.db.NoSuchStandardsTranslateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(standardsTranslatePK);
	}

	/**
	* Returns the standards translate with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param standardsTranslatePK the primary key of the standards translate
	* @return the standards translate, or <code>null</code> if a standards translate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsTranslate fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardsTranslatePK standardsTranslatePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(standardsTranslatePK);
	}

	/**
	* Returns all the standards translates.
	*
	* @return the standards translates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsTranslate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the standards translates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards translates
	* @param end the upper bound of the range of standards translates (not inclusive)
	* @return the range of standards translates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsTranslate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the standards translates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards translates
	* @param end the upper bound of the range of standards translates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of standards translates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsTranslate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the standards translates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of standards translates.
	*
	* @return the number of standards translates
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StandardsTranslatePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StandardsTranslatePersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					StandardsTranslatePersistence.class.getName());

			ReferenceRegistry.registerReference(StandardsTranslateUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(StandardsTranslatePersistence persistence) {
	}

	private static StandardsTranslatePersistence _persistence;
}