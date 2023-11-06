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

package com.ihg.brandstandards.db.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UniqueGroupLocalService}.
 *
 * @author Mummanedi
 * @see UniqueGroupLocalService
 * @generated
 */
public class UniqueGroupLocalServiceWrapper implements UniqueGroupLocalService,
	ServiceWrapper<UniqueGroupLocalService> {
	public UniqueGroupLocalServiceWrapper(
		UniqueGroupLocalService uniqueGroupLocalService) {
		_uniqueGroupLocalService = uniqueGroupLocalService;
	}

	/**
	* Adds the unique group to the database. Also notifies the appropriate model listeners.
	*
	* @param uniqueGroup the unique group
	* @return the unique group that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.UniqueGroup addUniqueGroup(
		com.ihg.brandstandards.db.model.UniqueGroup uniqueGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uniqueGroupLocalService.addUniqueGroup(uniqueGroup);
	}

	/**
	* Creates a new unique group with the primary key. Does not add the unique group to the database.
	*
	* @param uniqueGroupId the primary key for the new unique group
	* @return the new unique group
	*/
	@Override
	public com.ihg.brandstandards.db.model.UniqueGroup createUniqueGroup(
		long uniqueGroupId) {
		return _uniqueGroupLocalService.createUniqueGroup(uniqueGroupId);
	}

	/**
	* Deletes the unique group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param uniqueGroupId the primary key of the unique group
	* @return the unique group that was removed
	* @throws PortalException if a unique group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.UniqueGroup deleteUniqueGroup(
		long uniqueGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _uniqueGroupLocalService.deleteUniqueGroup(uniqueGroupId);
	}

	/**
	* Deletes the unique group from the database. Also notifies the appropriate model listeners.
	*
	* @param uniqueGroup the unique group
	* @return the unique group that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.UniqueGroup deleteUniqueGroup(
		com.ihg.brandstandards.db.model.UniqueGroup uniqueGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uniqueGroupLocalService.deleteUniqueGroup(uniqueGroup);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _uniqueGroupLocalService.dynamicQuery();
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
		return _uniqueGroupLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UniqueGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _uniqueGroupLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UniqueGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _uniqueGroupLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _uniqueGroupLocalService.dynamicQueryCount(dynamicQuery);
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
		return _uniqueGroupLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.UniqueGroup fetchUniqueGroup(
		long uniqueGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uniqueGroupLocalService.fetchUniqueGroup(uniqueGroupId);
	}

	/**
	* Returns the unique group with the primary key.
	*
	* @param uniqueGroupId the primary key of the unique group
	* @return the unique group
	* @throws PortalException if a unique group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.UniqueGroup getUniqueGroup(
		long uniqueGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _uniqueGroupLocalService.getUniqueGroup(uniqueGroupId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _uniqueGroupLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the unique groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UniqueGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of unique groups
	* @param end the upper bound of the range of unique groups (not inclusive)
	* @return the range of unique groups
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.UniqueGroup> getUniqueGroups(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uniqueGroupLocalService.getUniqueGroups(start, end);
	}

	/**
	* Returns the number of unique groups.
	*
	* @return the number of unique groups
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getUniqueGroupsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uniqueGroupLocalService.getUniqueGroupsCount();
	}

	/**
	* Updates the unique group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param uniqueGroup the unique group
	* @return the unique group that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.UniqueGroup updateUniqueGroup(
		com.ihg.brandstandards.db.model.UniqueGroup uniqueGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uniqueGroupLocalService.updateUniqueGroup(uniqueGroup);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _uniqueGroupLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_uniqueGroupLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _uniqueGroupLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void clearCache() {
		_uniqueGroupLocalService.clearCache();
	}

	/**
	* Get all unique country groups for current publication and region
	*
	* @param publishId
	* @param regionId
	* @return List<GEMUniqueGroup>
	* @throws SystemException
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.UniqueGroup> getUniqueGroupsByRegionAndPublication(
		long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uniqueGroupLocalService.getUniqueGroupsByRegionAndPublication(publishId,
			regionId);
	}

	/**
	* @param publishId
	* @param regionId
	* @return List<GroupCountryDetails>
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.custom.model.GroupCountryDetails> getGroupAndCountryDetails(
		long publishId, long regionId, java.lang.String groupType) {
		return _uniqueGroupLocalService.getGroupAndCountryDetails(publishId,
			regionId, groupType);
	}

	/**
	* This method return a map of Groups and Group Countries where the standard belongs to.
	*
	* @param publishId
	* @param regionId
	* @param groupType
	* @param stdId
	* @return Map<String, String>
	*/
	@Override
	public java.util.Map<java.lang.String, java.lang.String> getStdUniqueGrpAndCtrys(
		long publishId, long regionId, java.lang.String groupType,
		java.lang.String stdId) {
		return _uniqueGroupLocalService.getStdUniqueGrpAndCtrys(publishId,
			regionId, groupType, stdId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public UniqueGroupLocalService getWrappedUniqueGroupLocalService() {
		return _uniqueGroupLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedUniqueGroupLocalService(
		UniqueGroupLocalService uniqueGroupLocalService) {
		_uniqueGroupLocalService = uniqueGroupLocalService;
	}

	@Override
	public UniqueGroupLocalService getWrappedService() {
		return _uniqueGroupLocalService;
	}

	@Override
	public void setWrappedService(
		UniqueGroupLocalService uniqueGroupLocalService) {
		_uniqueGroupLocalService = uniqueGroupLocalService;
	}

	private UniqueGroupLocalService _uniqueGroupLocalService;
}