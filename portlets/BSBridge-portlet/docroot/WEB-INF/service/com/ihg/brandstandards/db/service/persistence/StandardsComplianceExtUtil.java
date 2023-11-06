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

import com.ihg.brandstandards.db.model.StandardsComplianceExt;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the standards compliance ext service. This utility wraps {@link StandardsComplianceExtPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsComplianceExtPersistence
 * @see StandardsComplianceExtPersistenceImpl
 * @generated
 */
public class StandardsComplianceExtUtil {
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
	public static void clearCache(StandardsComplianceExt standardsComplianceExt) {
		getPersistence().clearCache(standardsComplianceExt);
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
	public static List<StandardsComplianceExt> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StandardsComplianceExt> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StandardsComplianceExt> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static StandardsComplianceExt update(
		StandardsComplianceExt standardsComplianceExt)
		throws SystemException {
		return getPersistence().update(standardsComplianceExt);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static StandardsComplianceExt update(
		StandardsComplianceExt standardsComplianceExt,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(standardsComplianceExt, serviceContext);
	}

	/**
	* Caches the standards compliance ext in the entity cache if it is enabled.
	*
	* @param standardsComplianceExt the standards compliance ext
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.StandardsComplianceExt standardsComplianceExt) {
		getPersistence().cacheResult(standardsComplianceExt);
	}

	/**
	* Caches the standards compliance exts in the entity cache if it is enabled.
	*
	* @param standardsComplianceExts the standards compliance exts
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.StandardsComplianceExt> standardsComplianceExts) {
		getPersistence().cacheResult(standardsComplianceExts);
	}

	/**
	* Creates a new standards compliance ext with the primary key. Does not add the standards compliance ext to the database.
	*
	* @param stdComplianceId the primary key for the new standards compliance ext
	* @return the new standards compliance ext
	*/
	public static com.ihg.brandstandards.db.model.StandardsComplianceExt create(
		long stdComplianceId) {
		return getPersistence().create(stdComplianceId);
	}

	/**
	* Removes the standards compliance ext with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stdComplianceId the primary key of the standards compliance ext
	* @return the standards compliance ext that was removed
	* @throws com.ihg.brandstandards.db.NoSuchStandardsComplianceExtException if a standards compliance ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsComplianceExt remove(
		long stdComplianceId)
		throws com.ihg.brandstandards.db.NoSuchStandardsComplianceExtException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(stdComplianceId);
	}

	public static com.ihg.brandstandards.db.model.StandardsComplianceExt updateImpl(
		com.ihg.brandstandards.db.model.StandardsComplianceExt standardsComplianceExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(standardsComplianceExt);
	}

	/**
	* Returns the standards compliance ext with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsComplianceExtException} if it could not be found.
	*
	* @param stdComplianceId the primary key of the standards compliance ext
	* @return the standards compliance ext
	* @throws com.ihg.brandstandards.db.NoSuchStandardsComplianceExtException if a standards compliance ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsComplianceExt findByPrimaryKey(
		long stdComplianceId)
		throws com.ihg.brandstandards.db.NoSuchStandardsComplianceExtException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(stdComplianceId);
	}

	/**
	* Returns the standards compliance ext with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param stdComplianceId the primary key of the standards compliance ext
	* @return the standards compliance ext, or <code>null</code> if a standards compliance ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsComplianceExt fetchByPrimaryKey(
		long stdComplianceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(stdComplianceId);
	}

	/**
	* Returns all the standards compliance exts.
	*
	* @return the standards compliance exts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsComplianceExt> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the standards compliance exts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsComplianceExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards compliance exts
	* @param end the upper bound of the range of standards compliance exts (not inclusive)
	* @return the range of standards compliance exts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsComplianceExt> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the standards compliance exts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsComplianceExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards compliance exts
	* @param end the upper bound of the range of standards compliance exts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of standards compliance exts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsComplianceExt> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the standards compliance exts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of standards compliance exts.
	*
	* @return the number of standards compliance exts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StandardsComplianceExtPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StandardsComplianceExtPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					StandardsComplianceExtPersistence.class.getName());

			ReferenceRegistry.registerReference(StandardsComplianceExtUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(StandardsComplianceExtPersistence persistence) {
	}

	private static StandardsComplianceExtPersistence _persistence;
}