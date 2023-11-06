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

package com.ihg.grs.common.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DirectoryLocalService}.
 *
 * @author gulam.vora
 * @see DirectoryLocalService
 * @generated
 */
public class DirectoryLocalServiceWrapper implements DirectoryLocalService,
	ServiceWrapper<DirectoryLocalService> {
	public DirectoryLocalServiceWrapper(
		DirectoryLocalService directoryLocalService) {
		_directoryLocalService = directoryLocalService;
	}

	/**
	* Adds the directory to the database. Also notifies the appropriate model listeners.
	*
	* @param directory the directory
	* @return the directory that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.grs.common.model.Directory addDirectory(
		com.ihg.grs.common.model.Directory directory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _directoryLocalService.addDirectory(directory);
	}

	/**
	* Creates a new directory with the primary key. Does not add the directory to the database.
	*
	* @param directoryId the primary key for the new directory
	* @return the new directory
	*/
	@Override
	public com.ihg.grs.common.model.Directory createDirectory(int directoryId) {
		return _directoryLocalService.createDirectory(directoryId);
	}

	/**
	* Deletes the directory with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param directoryId the primary key of the directory
	* @return the directory that was removed
	* @throws PortalException if a directory with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.grs.common.model.Directory deleteDirectory(int directoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _directoryLocalService.deleteDirectory(directoryId);
	}

	/**
	* Deletes the directory from the database. Also notifies the appropriate model listeners.
	*
	* @param directory the directory
	* @return the directory that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.grs.common.model.Directory deleteDirectory(
		com.ihg.grs.common.model.Directory directory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _directoryLocalService.deleteDirectory(directory);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _directoryLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _directoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.grs.common.model.impl.DirectoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _directoryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.grs.common.model.impl.DirectoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _directoryLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _directoryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _directoryLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.ihg.grs.common.model.Directory fetchDirectory(int directoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _directoryLocalService.fetchDirectory(directoryId);
	}

	/**
	* Returns the directory with the primary key.
	*
	* @param directoryId the primary key of the directory
	* @return the directory
	* @throws PortalException if a directory with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.grs.common.model.Directory getDirectory(int directoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _directoryLocalService.getDirectory(directoryId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _directoryLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.ihg.grs.common.model.Directory> getDirectories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _directoryLocalService.getDirectories(start, end);
	}

	/**
	* Returns the number of directories.
	*
	* @return the number of directories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDirectoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _directoryLocalService.getDirectoriesCount();
	}

	/**
	* Updates the directory in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param directory the directory
	* @return the directory that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.grs.common.model.Directory updateDirectory(
		com.ihg.grs.common.model.Directory directory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _directoryLocalService.updateDirectory(directory);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _directoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_directoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _directoryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DirectoryLocalService getWrappedDirectoryLocalService() {
		return _directoryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDirectoryLocalService(
		DirectoryLocalService directoryLocalService) {
		_directoryLocalService = directoryLocalService;
	}

	@Override
	public DirectoryLocalService getWrappedService() {
		return _directoryLocalService;
	}

	@Override
	public void setWrappedService(DirectoryLocalService directoryLocalService) {
		_directoryLocalService = directoryLocalService;
	}

	private DirectoryLocalService _directoryLocalService;
}