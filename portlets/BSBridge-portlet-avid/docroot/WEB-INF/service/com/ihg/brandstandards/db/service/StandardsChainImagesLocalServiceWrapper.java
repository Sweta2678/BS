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
 * Provides a wrapper for {@link StandardsChainImagesLocalService}.
 *
 * @author Mummanedi
 * @see StandardsChainImagesLocalService
 * @generated
 */
public class StandardsChainImagesLocalServiceWrapper
	implements StandardsChainImagesLocalService,
		ServiceWrapper<StandardsChainImagesLocalService> {
	public StandardsChainImagesLocalServiceWrapper(
		StandardsChainImagesLocalService standardsChainImagesLocalService) {
		_standardsChainImagesLocalService = standardsChainImagesLocalService;
	}

	/**
	* Adds the standards chain images to the database. Also notifies the appropriate model listeners.
	*
	* @param standardsChainImages the standards chain images
	* @return the standards chain images that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsChainImages addStandardsChainImages(
		com.ihg.brandstandards.db.model.StandardsChainImages standardsChainImages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsChainImagesLocalService.addStandardsChainImages(standardsChainImages);
	}

	/**
	* Creates a new standards chain images with the primary key. Does not add the standards chain images to the database.
	*
	* @param standardsChainImagesPK the primary key for the new standards chain images
	* @return the new standards chain images
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsChainImages createStandardsChainImages(
		com.ihg.brandstandards.db.service.persistence.StandardsChainImagesPK standardsChainImagesPK) {
		return _standardsChainImagesLocalService.createStandardsChainImages(standardsChainImagesPK);
	}

	/**
	* Deletes the standards chain images with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsChainImagesPK the primary key of the standards chain images
	* @return the standards chain images that was removed
	* @throws PortalException if a standards chain images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsChainImages deleteStandardsChainImages(
		com.ihg.brandstandards.db.service.persistence.StandardsChainImagesPK standardsChainImagesPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsChainImagesLocalService.deleteStandardsChainImages(standardsChainImagesPK);
	}

	/**
	* Deletes the standards chain images from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsChainImages the standards chain images
	* @return the standards chain images that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsChainImages deleteStandardsChainImages(
		com.ihg.brandstandards.db.model.StandardsChainImages standardsChainImages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsChainImagesLocalService.deleteStandardsChainImages(standardsChainImages);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _standardsChainImagesLocalService.dynamicQuery();
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
		return _standardsChainImagesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsChainImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _standardsChainImagesLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsChainImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _standardsChainImagesLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _standardsChainImagesLocalService.dynamicQueryCount(dynamicQuery);
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
		return _standardsChainImagesLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsChainImages fetchStandardsChainImages(
		com.ihg.brandstandards.db.service.persistence.StandardsChainImagesPK standardsChainImagesPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsChainImagesLocalService.fetchStandardsChainImages(standardsChainImagesPK);
	}

	/**
	* Returns the standards chain images with the primary key.
	*
	* @param standardsChainImagesPK the primary key of the standards chain images
	* @return the standards chain images
	* @throws PortalException if a standards chain images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsChainImages getStandardsChainImages(
		com.ihg.brandstandards.db.service.persistence.StandardsChainImagesPK standardsChainImagesPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsChainImagesLocalService.getStandardsChainImages(standardsChainImagesPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsChainImagesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the standards chain imageses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsChainImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards chain imageses
	* @param end the upper bound of the range of standards chain imageses (not inclusive)
	* @return the range of standards chain imageses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsChainImages> getStandardsChainImageses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsChainImagesLocalService.getStandardsChainImageses(start,
			end);
	}

	/**
	* Returns the number of standards chain imageses.
	*
	* @return the number of standards chain imageses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getStandardsChainImagesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsChainImagesLocalService.getStandardsChainImagesesCount();
	}

	/**
	* Updates the standards chain images in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param standardsChainImages the standards chain images
	* @return the standards chain images that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsChainImages updateStandardsChainImages(
		com.ihg.brandstandards.db.model.StandardsChainImages standardsChainImages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsChainImagesLocalService.updateStandardsChainImages(standardsChainImages);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _standardsChainImagesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_standardsChainImagesLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _standardsChainImagesLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void clearCache() {
		_standardsChainImagesLocalService.clearCache();
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsChainImages getStandardsChainImagesObject() {
		return _standardsChainImagesLocalService.getStandardsChainImagesObject();
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsChainImages> getChainImagesByStdImageId(
		long stdImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsChainImagesLocalService.getChainImagesByStdImageId(stdImageId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public StandardsChainImagesLocalService getWrappedStandardsChainImagesLocalService() {
		return _standardsChainImagesLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedStandardsChainImagesLocalService(
		StandardsChainImagesLocalService standardsChainImagesLocalService) {
		_standardsChainImagesLocalService = standardsChainImagesLocalService;
	}

	@Override
	public StandardsChainImagesLocalService getWrappedService() {
		return _standardsChainImagesLocalService;
	}

	@Override
	public void setWrappedService(
		StandardsChainImagesLocalService standardsChainImagesLocalService) {
		_standardsChainImagesLocalService = standardsChainImagesLocalService;
	}

	private StandardsChainImagesLocalService _standardsChainImagesLocalService;
}