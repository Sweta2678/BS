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
 * Provides a wrapper for {@link GEMUniqueGroupLocalService}.
 *
 * @author Mummanedi
 * @see GEMUniqueGroupLocalService
 * @generated
 */
public class GEMUniqueGroupLocalServiceWrapper
	implements GEMUniqueGroupLocalService,
		ServiceWrapper<GEMUniqueGroupLocalService> {
	public GEMUniqueGroupLocalServiceWrapper(
		GEMUniqueGroupLocalService gemUniqueGroupLocalService) {
		_gemUniqueGroupLocalService = gemUniqueGroupLocalService;
	}

	/**
	* Adds the g e m unique group to the database. Also notifies the appropriate model listeners.
	*
	* @param gemUniqueGroup the g e m unique group
	* @return the g e m unique group that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMUniqueGroup addGEMUniqueGroup(
		com.ihg.brandstandards.db.model.GEMUniqueGroup gemUniqueGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemUniqueGroupLocalService.addGEMUniqueGroup(gemUniqueGroup);
	}

	/**
	* Creates a new g e m unique group with the primary key. Does not add the g e m unique group to the database.
	*
	* @param uniqueGroupId the primary key for the new g e m unique group
	* @return the new g e m unique group
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMUniqueGroup createGEMUniqueGroup(
		long uniqueGroupId) {
		return _gemUniqueGroupLocalService.createGEMUniqueGroup(uniqueGroupId);
	}

	/**
	* Deletes the g e m unique group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param uniqueGroupId the primary key of the g e m unique group
	* @return the g e m unique group that was removed
	* @throws PortalException if a g e m unique group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMUniqueGroup deleteGEMUniqueGroup(
		long uniqueGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gemUniqueGroupLocalService.deleteGEMUniqueGroup(uniqueGroupId);
	}

	/**
	* Deletes the g e m unique group from the database. Also notifies the appropriate model listeners.
	*
	* @param gemUniqueGroup the g e m unique group
	* @return the g e m unique group that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMUniqueGroup deleteGEMUniqueGroup(
		com.ihg.brandstandards.db.model.GEMUniqueGroup gemUniqueGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemUniqueGroupLocalService.deleteGEMUniqueGroup(gemUniqueGroup);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _gemUniqueGroupLocalService.dynamicQuery();
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
		return _gemUniqueGroupLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMUniqueGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _gemUniqueGroupLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMUniqueGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _gemUniqueGroupLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _gemUniqueGroupLocalService.dynamicQueryCount(dynamicQuery);
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
		return _gemUniqueGroupLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMUniqueGroup fetchGEMUniqueGroup(
		long uniqueGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemUniqueGroupLocalService.fetchGEMUniqueGroup(uniqueGroupId);
	}

	/**
	* Returns the g e m unique group with the primary key.
	*
	* @param uniqueGroupId the primary key of the g e m unique group
	* @return the g e m unique group
	* @throws PortalException if a g e m unique group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMUniqueGroup getGEMUniqueGroup(
		long uniqueGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gemUniqueGroupLocalService.getGEMUniqueGroup(uniqueGroupId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gemUniqueGroupLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the g e m unique groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMUniqueGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m unique groups
	* @param end the upper bound of the range of g e m unique groups (not inclusive)
	* @return the range of g e m unique groups
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.GEMUniqueGroup> getGEMUniqueGroups(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemUniqueGroupLocalService.getGEMUniqueGroups(start, end);
	}

	/**
	* Returns the number of g e m unique groups.
	*
	* @return the number of g e m unique groups
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGEMUniqueGroupsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemUniqueGroupLocalService.getGEMUniqueGroupsCount();
	}

	/**
	* Updates the g e m unique group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param gemUniqueGroup the g e m unique group
	* @return the g e m unique group that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMUniqueGroup updateGEMUniqueGroup(
		com.ihg.brandstandards.db.model.GEMUniqueGroup gemUniqueGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemUniqueGroupLocalService.updateGEMUniqueGroup(gemUniqueGroup);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _gemUniqueGroupLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_gemUniqueGroupLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _gemUniqueGroupLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void clearCache() {
		_gemUniqueGroupLocalService.clearCache();
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
	public java.util.List<com.ihg.brandstandards.db.model.GEMUniqueGroup> getUniqueGroupsByRegionAndPublication(
		long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemUniqueGroupLocalService.getUniqueGroupsByRegionAndPublication(publishId,
			regionId);
	}

	/**
	* @param publishId
	* @param regionId
	* @param groupType
	* @return List<GEMUniqueGroup>
	* @throws SystemException
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.GEMUniqueGroup> getUniqueGroupsByRegionAndPublicationAndType(
		long publishId, long regionId, java.lang.String groupType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemUniqueGroupLocalService.getUniqueGroupsByRegionAndPublicationAndType(publishId,
			regionId, groupType);
	}

	/**
	* @param chainCd
	* @param regionId
	* @param filterIds
	* @param searchIds
	* @param selByState
	* @param locale
	* @return List<BridgePublishPreview>
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishPreview> getBridgePublishPreview(
		java.lang.String groupName, java.lang.String chainCd, long regionId,
		java.lang.String filterIds, java.lang.String searchIds,
		java.lang.String selByState, java.lang.String locale,
		long bridgePublishId, java.lang.String groupType) {
		return _gemUniqueGroupLocalService.getBridgePublishPreview(groupName,
			chainCd, regionId, filterIds, searchIds, selByState, locale,
			bridgePublishId, groupType);
	}

	/**
	* @param publishId
	* @param regionId
	* @return List<GroupCountryDetails>
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.custom.model.GroupCountryDetails> getGroupAndCountryDetails(
		long publishId, long regionId, java.lang.String groupType) {
		return _gemUniqueGroupLocalService.getGroupAndCountryDetails(publishId,
			regionId, groupType);
	}

	/**
	* This method return a map of Groups and Group Countries where the standard belongs to.
	*
	* @param publishId
	* @param regionId
	* @param groupType
	* @param stdId
	* @return
	*/
	@Override
	public java.util.Map<java.lang.String, java.lang.String> getStdUniqueGrpAndCtrys(
		long publishId, long regionId, java.lang.String groupType,
		java.lang.String stdId) {
		return _gemUniqueGroupLocalService.getStdUniqueGrpAndCtrys(publishId,
			regionId, groupType, stdId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GEMUniqueGroupLocalService getWrappedGEMUniqueGroupLocalService() {
		return _gemUniqueGroupLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGEMUniqueGroupLocalService(
		GEMUniqueGroupLocalService gemUniqueGroupLocalService) {
		_gemUniqueGroupLocalService = gemUniqueGroupLocalService;
	}

	@Override
	public GEMUniqueGroupLocalService getWrappedService() {
		return _gemUniqueGroupLocalService;
	}

	@Override
	public void setWrappedService(
		GEMUniqueGroupLocalService gemUniqueGroupLocalService) {
		_gemUniqueGroupLocalService = gemUniqueGroupLocalService;
	}

	private GEMUniqueGroupLocalService _gemUniqueGroupLocalService;
}