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

package com.ihg.grs.common.service.persistence;

import com.ihg.grs.common.model.Directory;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the directory service. This utility wraps {@link DirectoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gulam.vora
 * @see DirectoryPersistence
 * @see DirectoryPersistenceImpl
 * @generated
 */
public class DirectoryUtil {
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
	public static void clearCache(Directory directory) {
		getPersistence().clearCache(directory);
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
	public static List<Directory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Directory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Directory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Directory update(Directory directory)
		throws SystemException {
		return getPersistence().update(directory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Directory update(Directory directory,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(directory, serviceContext);
	}

	/**
	* Caches the directory in the entity cache if it is enabled.
	*
	* @param directory the directory
	*/
	public static void cacheResult(com.ihg.grs.common.model.Directory directory) {
		getPersistence().cacheResult(directory);
	}

	/**
	* Caches the directories in the entity cache if it is enabled.
	*
	* @param directories the directories
	*/
	public static void cacheResult(
		java.util.List<com.ihg.grs.common.model.Directory> directories) {
		getPersistence().cacheResult(directories);
	}

	/**
	* Creates a new directory with the primary key. Does not add the directory to the database.
	*
	* @param directoryId the primary key for the new directory
	* @return the new directory
	*/
	public static com.ihg.grs.common.model.Directory create(int directoryId) {
		return getPersistence().create(directoryId);
	}

	/**
	* Removes the directory with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param directoryId the primary key of the directory
	* @return the directory that was removed
	* @throws com.ihg.grs.common.NoSuchDirectoryException if a directory with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.grs.common.model.Directory remove(int directoryId)
		throws com.ihg.grs.common.NoSuchDirectoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(directoryId);
	}

	public static com.ihg.grs.common.model.Directory updateImpl(
		com.ihg.grs.common.model.Directory directory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(directory);
	}

	/**
	* Returns the directory with the primary key or throws a {@link com.ihg.grs.common.NoSuchDirectoryException} if it could not be found.
	*
	* @param directoryId the primary key of the directory
	* @return the directory
	* @throws com.ihg.grs.common.NoSuchDirectoryException if a directory with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.grs.common.model.Directory findByPrimaryKey(
		int directoryId)
		throws com.ihg.grs.common.NoSuchDirectoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(directoryId);
	}

	/**
	* Returns the directory with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param directoryId the primary key of the directory
	* @return the directory, or <code>null</code> if a directory with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.grs.common.model.Directory fetchByPrimaryKey(
		int directoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(directoryId);
	}

	/**
	* Returns all the directories.
	*
	* @return the directories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.grs.common.model.Directory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the directories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.grs.common.model.impl.DirectoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of directories
	* @param end the upper bound of the range of directories (not inclusive)
	* @return the range of directories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.grs.common.model.Directory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the directories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.grs.common.model.impl.DirectoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of directories
	* @param end the upper bound of the range of directories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of directories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.grs.common.model.Directory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the directories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of directories.
	*
	* @return the number of directories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DirectoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DirectoryPersistence)PortletBeanLocatorUtil.locate(com.ihg.grs.common.service.ClpSerializer.getServletContextName(),
					DirectoryPersistence.class.getName());

			ReferenceRegistry.registerReference(DirectoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DirectoryPersistence persistence) {
	}

	private static DirectoryPersistence _persistence;
}