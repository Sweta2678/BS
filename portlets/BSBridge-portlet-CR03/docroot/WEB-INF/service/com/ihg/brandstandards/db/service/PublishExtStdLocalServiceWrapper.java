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
 * Provides a wrapper for {@link PublishExtStdLocalService}.
 *
 * @author Mummanedi
 * @see PublishExtStdLocalService
 * @generated
 */
public class PublishExtStdLocalServiceWrapper
	implements PublishExtStdLocalService,
		ServiceWrapper<PublishExtStdLocalService> {
	public PublishExtStdLocalServiceWrapper(
		PublishExtStdLocalService publishExtStdLocalService) {
		_publishExtStdLocalService = publishExtStdLocalService;
	}

	/**
	* Adds the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. to the database. Also notifies the appropriate model listeners.
	*
	* @param publishExtStd the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	* @return the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishExtStd addPublishExtStd(
		com.ihg.brandstandards.db.model.PublishExtStd publishExtStd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishExtStdLocalService.addPublishExtStd(publishExtStd);
	}

	/**
	* Creates a new Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key. Does not add the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. to the database.
	*
	* @param stdId the primary key for the new Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	* @return the new Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishExtStd createPublishExtStd(
		long stdId) {
		return _publishExtStdLocalService.createPublishExtStd(stdId);
	}

	/**
	* Deletes the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stdId the primary key of the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	* @return the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. that was removed
	* @throws PortalException if a Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishExtStd deletePublishExtStd(
		long stdId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishExtStdLocalService.deletePublishExtStd(stdId);
	}

	/**
	* Deletes the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. from the database. Also notifies the appropriate model listeners.
	*
	* @param publishExtStd the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	* @return the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishExtStd deletePublishExtStd(
		com.ihg.brandstandards.db.model.PublishExtStd publishExtStd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishExtStdLocalService.deletePublishExtStd(publishExtStd);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _publishExtStdLocalService.dynamicQuery();
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
		return _publishExtStdLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishExtStdModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _publishExtStdLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishExtStdModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _publishExtStdLocalService.dynamicQuery(dynamicQuery, start,
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
		return _publishExtStdLocalService.dynamicQueryCount(dynamicQuery);
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
		return _publishExtStdLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.PublishExtStd fetchPublishExtStd(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return _publishExtStdLocalService.fetchPublishExtStd(stdId);
	}

	/**
	* Returns the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key.
	*
	* @param stdId the primary key of the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	* @return the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	* @throws PortalException if a Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishExtStd getPublishExtStd(
		long stdId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishExtStdLocalService.getPublishExtStd(stdId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishExtStdLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishExtStdModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s
	* @param end the upper bound of the range of Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s (not inclusive)
	* @return the range of Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.PublishExtStd> getPublishExtStds(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishExtStdLocalService.getPublishExtStds(start, end);
	}

	/**
	* Returns the number of Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s.
	*
	* @return the number of Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPublishExtStdsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishExtStdLocalService.getPublishExtStdsCount();
	}

	/**
	* Updates the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param publishExtStd the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	* @return the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishExtStd updatePublishExtStd(
		com.ihg.brandstandards.db.model.PublishExtStd publishExtStd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishExtStdLocalService.updatePublishExtStd(publishExtStd);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _publishExtStdLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_publishExtStdLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _publishExtStdLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void clearCache() {
		_publishExtStdLocalService.clearCache();
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.PublishExtStd> getPublishedStandards(
		long stdId, java.lang.String stdType, java.lang.String brandCd,
		java.lang.String filterOn, java.lang.String isNonMatch,
		java.lang.String fromDate, java.lang.String toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishExtStdLocalService.getPublishedStandards(stdId, stdType,
			brandCd, filterOn, isNonMatch, fromDate, toDate);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.PublishExtStd> getPublishedStandards(
		java.lang.String brandCd, java.lang.String filterOn,
		java.lang.String isNonMatch, java.lang.String fromDate,
		java.lang.String toDate, java.lang.String filterIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishExtStdLocalService.getPublishedStandards(brandCd,
			filterOn, isNonMatch, fromDate, toDate, filterIds);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.PublishExtStd> getPublishedSpecs(
		java.lang.String stdType, java.lang.String brandCd,
		java.lang.String fromDate, java.lang.String toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishExtStdLocalService.getPublishedSpecs(stdType, brandCd,
			fromDate, toDate);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PublishExtStdLocalService getWrappedPublishExtStdLocalService() {
		return _publishExtStdLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPublishExtStdLocalService(
		PublishExtStdLocalService publishExtStdLocalService) {
		_publishExtStdLocalService = publishExtStdLocalService;
	}

	@Override
	public PublishExtStdLocalService getWrappedService() {
		return _publishExtStdLocalService;
	}

	@Override
	public void setWrappedService(
		PublishExtStdLocalService publishExtStdLocalService) {
		_publishExtStdLocalService = publishExtStdLocalService;
	}

	private PublishExtStdLocalService _publishExtStdLocalService;
}