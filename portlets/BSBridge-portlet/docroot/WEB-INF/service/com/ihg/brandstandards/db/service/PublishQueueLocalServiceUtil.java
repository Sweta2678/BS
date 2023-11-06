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
 * Provides the local service utility for PublishQueue. This utility wraps
 * {@link com.ihg.brandstandards.db.service.impl.PublishQueueLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mummanedi
 * @see PublishQueueLocalService
 * @see com.ihg.brandstandards.db.service.base.PublishQueueLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.PublishQueueLocalServiceImpl
 * @generated
 */
public class PublishQueueLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.PublishQueueLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the publish queue to the database. Also notifies the appropriate model listeners.
	*
	* @param publishQueue the publish queue
	* @return the publish queue that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishQueue addPublishQueue(
		com.ihg.brandstandards.db.model.PublishQueue publishQueue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPublishQueue(publishQueue);
	}

	/**
	* Creates a new publish queue with the primary key. Does not add the publish queue to the database.
	*
	* @param publishQueueId the primary key for the new publish queue
	* @return the new publish queue
	*/
	public static com.ihg.brandstandards.db.model.PublishQueue createPublishQueue(
		long publishQueueId) {
		return getService().createPublishQueue(publishQueueId);
	}

	/**
	* Deletes the publish queue with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param publishQueueId the primary key of the publish queue
	* @return the publish queue that was removed
	* @throws PortalException if a publish queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishQueue deletePublishQueue(
		long publishQueueId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePublishQueue(publishQueueId);
	}

	/**
	* Deletes the publish queue from the database. Also notifies the appropriate model listeners.
	*
	* @param publishQueue the publish queue
	* @return the publish queue that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishQueue deletePublishQueue(
		com.ihg.brandstandards.db.model.PublishQueue publishQueue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePublishQueue(publishQueue);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.ihg.brandstandards.db.model.PublishQueue fetchPublishQueue(
		long publishQueueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPublishQueue(publishQueueId);
	}

	/**
	* Returns the publish queue with the primary key.
	*
	* @param publishQueueId the primary key of the publish queue
	* @return the publish queue
	* @throws PortalException if a publish queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishQueue getPublishQueue(
		long publishQueueId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPublishQueue(publishQueueId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the publish queues.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of publish queues
	* @param end the upper bound of the range of publish queues (not inclusive)
	* @return the range of publish queues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishQueue> getPublishQueues(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPublishQueues(start, end);
	}

	/**
	* Returns the number of publish queues.
	*
	* @return the number of publish queues
	* @throws SystemException if a system exception occurred
	*/
	public static int getPublishQueuesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPublishQueuesCount();
	}

	/**
	* Updates the publish queue in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param publishQueue the publish queue
	* @return the publish queue that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishQueue updatePublishQueue(
		com.ihg.brandstandards.db.model.PublishQueue publishQueue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePublishQueue(publishQueue);
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

	public static com.ihg.brandstandards.db.model.PublishQueue createPublishQueueOraSecuence()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().createPublishQueueOraSecuence();
	}

	public static com.ihg.brandstandards.db.model.PublishQueue clonePublishQueue(
		long publishQueueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().clonePublishQueue(publishQueueId);
	}

	public static com.ihg.brandstandards.db.model.PublishQueue findPublishQueueByPublishId(
		long publishId)
		throws com.ihg.brandstandards.db.NoSuchPublishQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findPublishQueueByPublishId(publishId);
	}

	public static void clearCache() {
		getService().clearCache();
	}

	public static java.lang.String validateStdIds(java.lang.String stdIds,
		java.lang.String chainCd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().validateStdIds(stdIds, chainCd);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.PublishQueue> findPublishQueueByEnvironment(
		java.lang.String envType, int count)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findPublishQueueByEnvironment(envType, count);
	}

	public static int updatePublishQueueStatus(long publishQueueId,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePublishQueueStatus(publishQueueId, status);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.StandardsExt> getStandards(
		java.util.Map<java.lang.String, ?> criteriaMap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandards(criteriaMap);
	}

	public static void createManuals(long publishQueueId,
		java.lang.String environment)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().createManuals(publishQueueId, environment);
	}

	public static void createReport(java.lang.String metaData,
		java.lang.String userId, java.lang.String emailAddr)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().createReport(metaData, userId, emailAddr);
	}

	public static void createReport(java.lang.String metaData,
		java.lang.String userId, java.lang.String emailAddr,
		java.lang.String link, java.lang.String jobType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().createReport(metaData, userId, emailAddr, link, jobType);
	}

	public static java.util.Map<java.lang.String, java.lang.String> getLocalesByStdId(
		java.util.List<java.lang.Long> stdIds, java.lang.String brand)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLocalesByStdId(stdIds, brand);
	}

	public static java.util.Map<java.lang.String, java.lang.String> getLocalesByBrand(
		java.lang.String brand)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLocalesByBrand(brand);
	}

	public static void clearService() {
		_service = null;
	}

	public static PublishQueueLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PublishQueueLocalService.class.getName());

			if (invokableLocalService instanceof PublishQueueLocalService) {
				_service = (PublishQueueLocalService)invokableLocalService;
			}
			else {
				_service = new PublishQueueLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PublishQueueLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(PublishQueueLocalService service) {
	}

	private static PublishQueueLocalService _service;
}