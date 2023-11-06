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
 * Provides a wrapper for {@link PublishQueueLocalService}.
 *
 * @author Mummanedi
 * @see PublishQueueLocalService
 * @generated
 */
public class PublishQueueLocalServiceWrapper implements PublishQueueLocalService,
	ServiceWrapper<PublishQueueLocalService> {
	public PublishQueueLocalServiceWrapper(
		PublishQueueLocalService publishQueueLocalService) {
		_publishQueueLocalService = publishQueueLocalService;
	}

	/**
	* Adds the publish queue to the database. Also notifies the appropriate model listeners.
	*
	* @param publishQueue the publish queue
	* @return the publish queue that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishQueue addPublishQueue(
		com.ihg.brandstandards.db.model.PublishQueue publishQueue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishQueueLocalService.addPublishQueue(publishQueue);
	}

	/**
	* Creates a new publish queue with the primary key. Does not add the publish queue to the database.
	*
	* @param publishQueueId the primary key for the new publish queue
	* @return the new publish queue
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishQueue createPublishQueue(
		long publishQueueId) {
		return _publishQueueLocalService.createPublishQueue(publishQueueId);
	}

	/**
	* Deletes the publish queue with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param publishQueueId the primary key of the publish queue
	* @return the publish queue that was removed
	* @throws PortalException if a publish queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishQueue deletePublishQueue(
		long publishQueueId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishQueueLocalService.deletePublishQueue(publishQueueId);
	}

	/**
	* Deletes the publish queue from the database. Also notifies the appropriate model listeners.
	*
	* @param publishQueue the publish queue
	* @return the publish queue that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishQueue deletePublishQueue(
		com.ihg.brandstandards.db.model.PublishQueue publishQueue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishQueueLocalService.deletePublishQueue(publishQueue);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _publishQueueLocalService.dynamicQuery();
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
		return _publishQueueLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _publishQueueLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishQueueLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _publishQueueLocalService.dynamicQueryCount(dynamicQuery);
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
		return _publishQueueLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.PublishQueue fetchPublishQueue(
		long publishQueueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishQueueLocalService.fetchPublishQueue(publishQueueId);
	}

	/**
	* Returns the publish queue with the primary key.
	*
	* @param publishQueueId the primary key of the publish queue
	* @return the publish queue
	* @throws PortalException if a publish queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishQueue getPublishQueue(
		long publishQueueId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishQueueLocalService.getPublishQueue(publishQueueId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishQueueLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.PublishQueue> getPublishQueues(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishQueueLocalService.getPublishQueues(start, end);
	}

	/**
	* Returns the number of publish queues.
	*
	* @return the number of publish queues
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPublishQueuesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishQueueLocalService.getPublishQueuesCount();
	}

	/**
	* Updates the publish queue in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param publishQueue the publish queue
	* @return the publish queue that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishQueue updatePublishQueue(
		com.ihg.brandstandards.db.model.PublishQueue publishQueue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishQueueLocalService.updatePublishQueue(publishQueue);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _publishQueueLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_publishQueueLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _publishQueueLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.ihg.brandstandards.db.model.PublishQueue createPublishQueueOraSecuence()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishQueueLocalService.createPublishQueueOraSecuence();
	}

	@Override
	public com.ihg.brandstandards.db.model.PublishQueue clonePublishQueue(
		long publishQueueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishQueueLocalService.clonePublishQueue(publishQueueId);
	}

	@Override
	public com.ihg.brandstandards.db.model.PublishQueue findPublishQueueByPublishId(
		long publishId)
		throws com.ihg.brandstandards.db.NoSuchPublishQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishQueueLocalService.findPublishQueueByPublishId(publishId);
	}

	@Override
	public void clearCache() {
		_publishQueueLocalService.clearCache();
	}

	@Override
	public java.lang.String validateStdIds(java.lang.String stdIds,
		java.lang.String chainCd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishQueueLocalService.validateStdIds(stdIds, chainCd);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.PublishQueue> findPublishQueueByEnvironment(
		java.lang.String envType, int count)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishQueueLocalService.findPublishQueueByEnvironment(envType,
			count);
	}

	@Override
	public int updatePublishQueueStatus(long publishQueueId,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishQueueLocalService.updatePublishQueueStatus(publishQueueId,
			status);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsExt> getStandards(
		java.util.Map<java.lang.String, ?> criteriaMap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishQueueLocalService.getStandards(criteriaMap);
	}

	@Override
	public void createManuals(long publishQueueId, java.lang.String environment)
		throws com.liferay.portal.kernel.exception.SystemException {
		_publishQueueLocalService.createManuals(publishQueueId, environment);
	}

	@Override
	public void createReport(java.lang.String metaData,
		java.lang.String userId, java.lang.String emailAddr)
		throws com.liferay.portal.kernel.exception.SystemException {
		_publishQueueLocalService.createReport(metaData, userId, emailAddr);
	}

	@Override
	public void createReport(java.lang.String metaData,
		java.lang.String userId, java.lang.String emailAddr,
		java.lang.String link, java.lang.String jobType)
		throws com.liferay.portal.kernel.exception.SystemException {
		_publishQueueLocalService.createReport(metaData, userId, emailAddr,
			link, jobType);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getLocalesByStdId(
		java.util.List<java.lang.Long> stdIds, java.lang.String brand)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishQueueLocalService.getLocalesByStdId(stdIds, brand);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getLocalesByBrand(
		java.lang.String brand)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishQueueLocalService.getLocalesByBrand(brand);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PublishQueueLocalService getWrappedPublishQueueLocalService() {
		return _publishQueueLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPublishQueueLocalService(
		PublishQueueLocalService publishQueueLocalService) {
		_publishQueueLocalService = publishQueueLocalService;
	}

	@Override
	public PublishQueueLocalService getWrappedService() {
		return _publishQueueLocalService;
	}

	@Override
	public void setWrappedService(
		PublishQueueLocalService publishQueueLocalService) {
		_publishQueueLocalService = publishQueueLocalService;
	}

	private PublishQueueLocalService _publishQueueLocalService;
}