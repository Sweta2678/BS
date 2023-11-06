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
 * Provides the local service utility for SpreadSheetAttributeUpdate. This utility wraps
 * {@link com.ihg.brandstandards.db.service.impl.SpreadSheetAttributeUpdateLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mummanedi
 * @see SpreadSheetAttributeUpdateLocalService
 * @see com.ihg.brandstandards.db.service.base.SpreadSheetAttributeUpdateLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.SpreadSheetAttributeUpdateLocalServiceImpl
 * @generated
 */
public class SpreadSheetAttributeUpdateLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.SpreadSheetAttributeUpdateLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the spread sheet attribute update to the database. Also notifies the appropriate model listeners.
	*
	* @param spreadSheetAttributeUpdate the spread sheet attribute update
	* @return the spread sheet attribute update that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate addSpreadSheetAttributeUpdate(
		com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate spreadSheetAttributeUpdate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addSpreadSheetAttributeUpdate(spreadSheetAttributeUpdate);
	}

	/**
	* Creates a new spread sheet attribute update with the primary key. Does not add the spread sheet attribute update to the database.
	*
	* @param speardSheetId the primary key for the new spread sheet attribute update
	* @return the new spread sheet attribute update
	*/
	public static com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate createSpreadSheetAttributeUpdate(
		long speardSheetId) {
		return getService().createSpreadSheetAttributeUpdate(speardSheetId);
	}

	/**
	* Deletes the spread sheet attribute update with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param speardSheetId the primary key of the spread sheet attribute update
	* @return the spread sheet attribute update that was removed
	* @throws PortalException if a spread sheet attribute update with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate deleteSpreadSheetAttributeUpdate(
		long speardSheetId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSpreadSheetAttributeUpdate(speardSheetId);
	}

	/**
	* Deletes the spread sheet attribute update from the database. Also notifies the appropriate model listeners.
	*
	* @param spreadSheetAttributeUpdate the spread sheet attribute update
	* @return the spread sheet attribute update that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate deleteSpreadSheetAttributeUpdate(
		com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate spreadSheetAttributeUpdate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteSpreadSheetAttributeUpdate(spreadSheetAttributeUpdate);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpreadSheetAttributeUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpreadSheetAttributeUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate fetchSpreadSheetAttributeUpdate(
		long speardSheetId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSpreadSheetAttributeUpdate(speardSheetId);
	}

	/**
	* Returns the spread sheet attribute update with the primary key.
	*
	* @param speardSheetId the primary key of the spread sheet attribute update
	* @return the spread sheet attribute update
	* @throws PortalException if a spread sheet attribute update with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate getSpreadSheetAttributeUpdate(
		long speardSheetId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSpreadSheetAttributeUpdate(speardSheetId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the spread sheet attribute updates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpreadSheetAttributeUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of spread sheet attribute updates
	* @param end the upper bound of the range of spread sheet attribute updates (not inclusive)
	* @return the range of spread sheet attribute updates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate> getSpreadSheetAttributeUpdates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSpreadSheetAttributeUpdates(start, end);
	}

	/**
	* Returns the number of spread sheet attribute updates.
	*
	* @return the number of spread sheet attribute updates
	* @throws SystemException if a system exception occurred
	*/
	public static int getSpreadSheetAttributeUpdatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSpreadSheetAttributeUpdatesCount();
	}

	/**
	* Updates the spread sheet attribute update in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spreadSheetAttributeUpdate the spread sheet attribute update
	* @return the spread sheet attribute update that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate updateSpreadSheetAttributeUpdate(
		com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate spreadSheetAttributeUpdate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateSpreadSheetAttributeUpdate(spreadSheetAttributeUpdate);
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

	public static java.lang.String recordsNotAvailable(
		java.util.List<java.lang.Long> allStdIds,
		java.util.Map<java.lang.String, java.util.List<java.lang.Long>> stdIdsMap,
		com.liferay.portal.model.User user, java.lang.String region,
		java.lang.String environment) {
		return getService()
				   .recordsNotAvailable(allStdIds, stdIdsMap, user, region,
			environment);
	}

	/**
	* @param stdIds This is a list of Long values
	* @return List This method will return an object of List
	*/
	public static java.util.List getStandardDetails(
		java.util.List<java.lang.Long> stdIds) {
		return getService().getStandardDetails(stdIds);
	}

	/**
	* @param status
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate> getAttributeRequestList(
		java.lang.String status) {
		return getService().getAttributeRequestList(status);
	}

	/**
	* @param stdId
	*/
	public static java.util.List<java.lang.Long> getFlagCategoryIdForStandard(
		long stdId) {
		return getService().getFlagCategoryIdForStandard(stdId);
	}

	public static java.util.Map<java.lang.String, java.lang.Long> getFlagCategories() {
		return getService().getFlagCategories();
	}

	/**
	* @param userId
	* @param environment
	* @param template
	* @param message
	* @param log
	* @param requestId
	*/
	public static void sendEmailNotification(long userId,
		java.lang.String environment, java.lang.String template,
		java.lang.String message, java.lang.String log,
		java.lang.String requestId) {
		getService()
			.sendEmailNotification(userId, environment, template, message, log,
			requestId);
	}

	/**
	* @param stdIds
	* @return Map
	*/
	public static java.util.Map<java.lang.Long, java.util.List<java.lang.Long>> getStandardFlagCaterogies(
		java.util.List<java.lang.Long> stdIds) {
		return getService().getStandardFlagCaterogies(stdIds);
	}

	public static void clearCache() {
		getService().clearCache();
	}

	/**
	* @param user
	* @param metadata
	* @param jobType
	* @return boolean
	*/
	public static boolean addToJobQueue(com.liferay.portal.model.User user,
		java.lang.String metadata, java.lang.String jobType) {
		return getService().addToJobQueue(user, metadata, jobType);
	}

	public static void clearService() {
		_service = null;
	}

	public static SpreadSheetAttributeUpdateLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SpreadSheetAttributeUpdateLocalService.class.getName());

			if (invokableLocalService instanceof SpreadSheetAttributeUpdateLocalService) {
				_service = (SpreadSheetAttributeUpdateLocalService)invokableLocalService;
			}
			else {
				_service = new SpreadSheetAttributeUpdateLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SpreadSheetAttributeUpdateLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SpreadSheetAttributeUpdateLocalService service) {
	}

	private static SpreadSheetAttributeUpdateLocalService _service;
}