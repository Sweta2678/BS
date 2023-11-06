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

import com.ihg.brandstandards.db.model.MustPublish;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the must publish service. This utility wraps {@link MustPublishPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see MustPublishPersistence
 * @see MustPublishPersistenceImpl
 * @generated
 */
public class MustPublishUtil {
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
	public static void clearCache(MustPublish mustPublish) {
		getPersistence().clearCache(mustPublish);
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
	public static List<MustPublish> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MustPublish> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MustPublish> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MustPublish update(MustPublish mustPublish)
		throws SystemException {
		return getPersistence().update(mustPublish);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MustPublish update(MustPublish mustPublish,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(mustPublish, serviceContext);
	}

	/**
	* Caches the must publish in the entity cache if it is enabled.
	*
	* @param mustPublish the must publish
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.MustPublish mustPublish) {
		getPersistence().cacheResult(mustPublish);
	}

	/**
	* Caches the must publishs in the entity cache if it is enabled.
	*
	* @param mustPublishs the must publishs
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.MustPublish> mustPublishs) {
		getPersistence().cacheResult(mustPublishs);
	}

	/**
	* Creates a new must publish with the primary key. Does not add the must publish to the database.
	*
	* @param stdId the primary key for the new must publish
	* @return the new must publish
	*/
	public static com.ihg.brandstandards.db.model.MustPublish create(long stdId) {
		return getPersistence().create(stdId);
	}

	/**
	* Removes the must publish with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stdId the primary key of the must publish
	* @return the must publish that was removed
	* @throws com.ihg.brandstandards.db.NoSuchMustPublishException if a must publish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.MustPublish remove(long stdId)
		throws com.ihg.brandstandards.db.NoSuchMustPublishException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(stdId);
	}

	public static com.ihg.brandstandards.db.model.MustPublish updateImpl(
		com.ihg.brandstandards.db.model.MustPublish mustPublish)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(mustPublish);
	}

	/**
	* Returns the must publish with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchMustPublishException} if it could not be found.
	*
	* @param stdId the primary key of the must publish
	* @return the must publish
	* @throws com.ihg.brandstandards.db.NoSuchMustPublishException if a must publish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.MustPublish findByPrimaryKey(
		long stdId)
		throws com.ihg.brandstandards.db.NoSuchMustPublishException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(stdId);
	}

	/**
	* Returns the must publish with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param stdId the primary key of the must publish
	* @return the must publish, or <code>null</code> if a must publish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.MustPublish fetchByPrimaryKey(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(stdId);
	}

	/**
	* Returns all the must publishs.
	*
	* @return the must publishs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.MustPublish> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the must publishs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.MustPublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of must publishs
	* @param end the upper bound of the range of must publishs (not inclusive)
	* @return the range of must publishs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.MustPublish> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the must publishs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.MustPublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of must publishs
	* @param end the upper bound of the range of must publishs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of must publishs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.MustPublish> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the must publishs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of must publishs.
	*
	* @return the number of must publishs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MustPublishPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MustPublishPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					MustPublishPersistence.class.getName());

			ReferenceRegistry.registerReference(MustPublishUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(MustPublishPersistence persistence) {
	}

	private static MustPublishPersistence _persistence;
}