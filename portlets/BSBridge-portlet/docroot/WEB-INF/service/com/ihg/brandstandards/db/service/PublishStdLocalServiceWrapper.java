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
 * Provides a wrapper for {@link PublishStdLocalService}.
 *
 * @author Mummanedi
 * @see PublishStdLocalService
 * @generated
 */
public class PublishStdLocalServiceWrapper implements PublishStdLocalService,
	ServiceWrapper<PublishStdLocalService> {
	public PublishStdLocalServiceWrapper(
		PublishStdLocalService publishStdLocalService) {
		_publishStdLocalService = publishStdLocalService;
	}

	/**
	* Adds the publish std to the database. Also notifies the appropriate model listeners.
	*
	* @param publishStd the publish std
	* @return the publish std that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishStd addPublishStd(
		com.ihg.brandstandards.db.model.PublishStd publishStd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishStdLocalService.addPublishStd(publishStd);
	}

	/**
	* Creates a new publish std with the primary key. Does not add the publish std to the database.
	*
	* @param publishStdVerId the primary key for the new publish std
	* @return the new publish std
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishStd createPublishStd(
		long publishStdVerId) {
		return _publishStdLocalService.createPublishStd(publishStdVerId);
	}

	/**
	* Deletes the publish std with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param publishStdVerId the primary key of the publish std
	* @return the publish std that was removed
	* @throws PortalException if a publish std with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishStd deletePublishStd(
		long publishStdVerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishStdLocalService.deletePublishStd(publishStdVerId);
	}

	/**
	* Deletes the publish std from the database. Also notifies the appropriate model listeners.
	*
	* @param publishStd the publish std
	* @return the publish std that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishStd deletePublishStd(
		com.ihg.brandstandards.db.model.PublishStd publishStd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishStdLocalService.deletePublishStd(publishStd);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _publishStdLocalService.dynamicQuery();
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
		return _publishStdLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishStdModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _publishStdLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishStdModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _publishStdLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _publishStdLocalService.dynamicQueryCount(dynamicQuery);
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
		return _publishStdLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.PublishStd fetchPublishStd(
		long publishStdVerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishStdLocalService.fetchPublishStd(publishStdVerId);
	}

	/**
	* Returns the publish std with the primary key.
	*
	* @param publishStdVerId the primary key of the publish std
	* @return the publish std
	* @throws PortalException if a publish std with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishStd getPublishStd(
		long publishStdVerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishStdLocalService.getPublishStd(publishStdVerId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishStdLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the publish stds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishStdModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of publish stds
	* @param end the upper bound of the range of publish stds (not inclusive)
	* @return the range of publish stds
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.PublishStd> getPublishStds(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishStdLocalService.getPublishStds(start, end);
	}

	/**
	* Returns the number of publish stds.
	*
	* @return the number of publish stds
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPublishStdsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishStdLocalService.getPublishStdsCount();
	}

	/**
	* Updates the publish std in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param publishStd the publish std
	* @return the publish std that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishStd updatePublishStd(
		com.ihg.brandstandards.db.model.PublishStd publishStd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishStdLocalService.updatePublishStd(publishStd);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _publishStdLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_publishStdLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _publishStdLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void clearCache() {
		_publishStdLocalService.clearCache();
	}

	@Override
	public com.ihg.brandstandards.db.model.PublishStd getPublishForStdId(
		long publishId, long standardId)
		throws com.ihg.brandstandards.db.NoSuchPublishStdException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishStdLocalService.getPublishForStdId(publishId, standardId);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.PublishStd> getAssociatedStandards(
		long parentStdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishStdLocalService.getAssociatedStandards(parentStdId);
	}

	@Override
	public java.util.List getAssociatedStds(java.lang.String query) {
		return _publishStdLocalService.getAssociatedStds(query);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.PublishStd> getStandardsByCountryAndBrand(
		long publishId, long taxonomyId, java.lang.String chainCode,
		java.lang.String countryCode, java.lang.String stdType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishStdLocalService.getStandardsByCountryAndBrand(publishId,
			taxonomyId, chainCode, countryCode, stdType);
	}

	@Override
	public com.ihg.brandstandards.db.model.PublishStd getStandardByBrand(
		long standardId, long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishStdLocalService.getStandardByBrand(standardId, publishId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PublishStdLocalService getWrappedPublishStdLocalService() {
		return _publishStdLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPublishStdLocalService(
		PublishStdLocalService publishStdLocalService) {
		_publishStdLocalService = publishStdLocalService;
	}

	@Override
	public PublishStdLocalService getWrappedService() {
		return _publishStdLocalService;
	}

	@Override
	public void setWrappedService(PublishStdLocalService publishStdLocalService) {
		_publishStdLocalService = publishStdLocalService;
	}

	private PublishStdLocalService _publishStdLocalService;
}