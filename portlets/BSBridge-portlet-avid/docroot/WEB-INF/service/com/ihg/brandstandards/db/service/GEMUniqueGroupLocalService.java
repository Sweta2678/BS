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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for GEMUniqueGroup. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Mummanedi
 * @see GEMUniqueGroupLocalServiceUtil
 * @see com.ihg.brandstandards.db.service.base.GEMUniqueGroupLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.GEMUniqueGroupLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface GEMUniqueGroupLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GEMUniqueGroupLocalServiceUtil} to access the g e m unique group local service. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.GEMUniqueGroupLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the g e m unique group to the database. Also notifies the appropriate model listeners.
	*
	* @param gemUniqueGroup the g e m unique group
	* @return the g e m unique group that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMUniqueGroup addGEMUniqueGroup(
		com.ihg.brandstandards.db.model.GEMUniqueGroup gemUniqueGroup)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new g e m unique group with the primary key. Does not add the g e m unique group to the database.
	*
	* @param uniqueGroupId the primary key for the new g e m unique group
	* @return the new g e m unique group
	*/
	public com.ihg.brandstandards.db.model.GEMUniqueGroup createGEMUniqueGroup(
		long uniqueGroupId);

	/**
	* Deletes the g e m unique group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param uniqueGroupId the primary key of the g e m unique group
	* @return the g e m unique group that was removed
	* @throws PortalException if a g e m unique group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMUniqueGroup deleteGEMUniqueGroup(
		long uniqueGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the g e m unique group from the database. Also notifies the appropriate model listeners.
	*
	* @param gemUniqueGroup the g e m unique group
	* @return the g e m unique group that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMUniqueGroup deleteGEMUniqueGroup(
		com.ihg.brandstandards.db.model.GEMUniqueGroup gemUniqueGroup)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.ihg.brandstandards.db.model.GEMUniqueGroup fetchGEMUniqueGroup(
		long uniqueGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m unique group with the primary key.
	*
	* @param uniqueGroupId the primary key of the g e m unique group
	* @return the g e m unique group
	* @throws PortalException if a g e m unique group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.ihg.brandstandards.db.model.GEMUniqueGroup getGEMUniqueGroup(
		long uniqueGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.GEMUniqueGroup> getGEMUniqueGroups(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m unique groups.
	*
	* @return the number of g e m unique groups
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getGEMUniqueGroupsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the g e m unique group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param gemUniqueGroup the g e m unique group
	* @return the g e m unique group that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMUniqueGroup updateGEMUniqueGroup(
		com.ihg.brandstandards.db.model.GEMUniqueGroup gemUniqueGroup)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public void clearCache();

	/**
	* Get all unique country groups for current publication and region
	*
	* @param publishId
	* @param regionId
	* @return List<GEMUniqueGroup>
	* @throws SystemException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.GEMUniqueGroup> getUniqueGroupsByRegionAndPublication(
		long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* @param publishId
	* @param regionId
	* @param groupType
	* @return List<GEMUniqueGroup>
	* @throws SystemException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.GEMUniqueGroup> getUniqueGroupsByRegionAndPublicationAndType(
		long publishId, long regionId, java.lang.String groupType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* @param chainCd
	* @param regionId
	* @param filterIds
	* @param searchIds
	* @param selByState
	* @param locale
	* @return List<BridgePublishPreview>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishPreview> getBridgePublishPreview(
		java.lang.String groupName, java.lang.String chainCd, long regionId,
		java.lang.String filterIds, java.lang.String searchIds,
		java.lang.String selByState, java.lang.String locale,
		long bridgePublishId, java.lang.String groupType);

	/**
	* @param publishId
	* @param regionId
	* @return List<GroupCountryDetails>
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.custom.model.GroupCountryDetails> getGroupAndCountryDetails(
		long publishId, long regionId, java.lang.String groupType);

	/**
	* This method return a map of Groups and Group Countries where the standard belongs to.
	*
	* @param publishId
	* @param regionId
	* @param groupType
	* @param stdId
	* @return
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Map<java.lang.String, java.lang.String> getStdUniqueGrpAndCtrys(
		long publishId, long regionId, java.lang.String groupType,
		java.lang.String stdId);
}