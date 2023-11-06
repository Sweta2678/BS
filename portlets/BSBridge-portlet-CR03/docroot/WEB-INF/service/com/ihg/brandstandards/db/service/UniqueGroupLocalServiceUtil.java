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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for UniqueGroup. This utility wraps
 * {@link com.ihg.brandstandards.db.service.impl.UniqueGroupLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mummanedi
 * @see UniqueGroupLocalService
 * @see com.ihg.brandstandards.db.service.base.UniqueGroupLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.UniqueGroupLocalServiceImpl
 * @generated
 */
public class UniqueGroupLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.UniqueGroupLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the unique group to the database. Also notifies the appropriate model listeners.
	*
	* @param uniqueGroup the unique group
	* @return the unique group that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UniqueGroup addUniqueGroup(
		com.ihg.brandstandards.db.model.UniqueGroup uniqueGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addUniqueGroup(uniqueGroup);
	}

	/**
	* Creates a new unique group with the primary key. Does not add the unique group to the database.
	*
	* @param uniqueGroupId the primary key for the new unique group
	* @return the new unique group
	*/
	public static com.ihg.brandstandards.db.model.UniqueGroup createUniqueGroup(
		long uniqueGroupId) {
		return getService().createUniqueGroup(uniqueGroupId);
	}

	/**
	* Deletes the unique group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param uniqueGroupId the primary key of the unique group
	* @return the unique group that was removed
	* @throws PortalException if a unique group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UniqueGroup deleteUniqueGroup(
		long uniqueGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUniqueGroup(uniqueGroupId);
	}

	/**
	* Deletes the unique group from the database. Also notifies the appropriate model listeners.
	*
	* @param uniqueGroup the unique group
	* @return the unique group that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UniqueGroup deleteUniqueGroup(
		com.ihg.brandstandards.db.model.UniqueGroup uniqueGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUniqueGroup(uniqueGroup);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.ihg.brandstandards.db.model.UniqueGroup fetchUniqueGroup(
		long uniqueGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchUniqueGroup(uniqueGroupId);
	}

	/**
	* Returns the unique group with the primary key.
	*
	* @param uniqueGroupId the primary key of the unique group
	* @return the unique group
	* @throws PortalException if a unique group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UniqueGroup getUniqueGroup(
		long uniqueGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUniqueGroup(uniqueGroupId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.ihg.brandstandards.db.model.UniqueGroup> getUniqueGroups(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUniqueGroups(start, end);
	}

	/**
	* Returns the number of unique groups.
	*
	* @return the number of unique groups
	* @throws SystemException if a system exception occurred
	*/
	public static int getUniqueGroupsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUniqueGroupsCount();
	}

	/**
	* Updates the unique group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param uniqueGroup the unique group
	* @return the unique group that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UniqueGroup updateUniqueGroup(
		com.ihg.brandstandards.db.model.UniqueGroup uniqueGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUniqueGroup(uniqueGroup);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearCache() {
		getService().clearCache();
	}

	/**
	* Get all unique country groups for current publication and region
	*
	* @param publishId
	* @param regionId
	* @return List<GEMUniqueGroup>
	* @throws SystemException
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.UniqueGroup> getUniqueGroupsByRegionAndPublication(
		long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getUniqueGroupsByRegionAndPublication(publishId, regionId);
	}

	/**
	* @param publishId
	* @param regionId
	* @return List<GroupCountryDetails>
	*/
	public static java.util.List<com.ihg.brandstandards.custom.model.GroupCountryDetails> getGroupAndCountryDetails(
		long publishId, long regionId, java.lang.String groupType) {
		return getService()
				   .getGroupAndCountryDetails(publishId, regionId, groupType);
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
	public static java.util.Map<java.lang.String, java.lang.String> getStdUniqueGrpAndCtrys(
		long publishId, long regionId, java.lang.String groupType,
		java.lang.String stdId) {
		return getService()
				   .getStdUniqueGrpAndCtrys(publishId, regionId, groupType,
			stdId);
	}

	public static void clearService() {
		_service = null;
	}

	public static UniqueGroupLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					UniqueGroupLocalService.class.getName());

			if (invokableLocalService instanceof UniqueGroupLocalService) {
				_service = (UniqueGroupLocalService)invokableLocalService;
			}
			else {
				_service = new UniqueGroupLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(UniqueGroupLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(UniqueGroupLocalService service) {
	}

	private static UniqueGroupLocalService _service;
}