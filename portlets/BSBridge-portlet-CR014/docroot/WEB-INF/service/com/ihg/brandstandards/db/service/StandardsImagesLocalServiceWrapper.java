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
 * Provides a wrapper for {@link StandardsImagesLocalService}.
 *
 * @author Mummanedi
 * @see StandardsImagesLocalService
 * @generated
 */
public class StandardsImagesLocalServiceWrapper
	implements StandardsImagesLocalService,
		ServiceWrapper<StandardsImagesLocalService> {
	public StandardsImagesLocalServiceWrapper(
		StandardsImagesLocalService standardsImagesLocalService) {
		_standardsImagesLocalService = standardsImagesLocalService;
	}

	/**
	* Adds the standards images to the database. Also notifies the appropriate model listeners.
	*
	* @param standardsImages the standards images
	* @return the standards images that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsImages addStandardsImages(
		com.ihg.brandstandards.db.model.StandardsImages standardsImages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsImagesLocalService.addStandardsImages(standardsImages);
	}

	/**
	* Creates a new standards images with the primary key. Does not add the standards images to the database.
	*
	* @param stdImageId the primary key for the new standards images
	* @return the new standards images
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsImages createStandardsImages(
		long stdImageId) {
		return _standardsImagesLocalService.createStandardsImages(stdImageId);
	}

	/**
	* Deletes the standards images with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stdImageId the primary key of the standards images
	* @return the standards images that was removed
	* @throws PortalException if a standards images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsImages deleteStandardsImages(
		long stdImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsImagesLocalService.deleteStandardsImages(stdImageId);
	}

	/**
	* Deletes the standards images from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsImages the standards images
	* @return the standards images that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsImages deleteStandardsImages(
		com.ihg.brandstandards.db.model.StandardsImages standardsImages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsImagesLocalService.deleteStandardsImages(standardsImages);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _standardsImagesLocalService.dynamicQuery();
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
		return _standardsImagesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _standardsImagesLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _standardsImagesLocalService.dynamicQuery(dynamicQuery, start,
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
		return _standardsImagesLocalService.dynamicQueryCount(dynamicQuery);
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
		return _standardsImagesLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsImages fetchStandardsImages(
		long stdImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsImagesLocalService.fetchStandardsImages(stdImageId);
	}

	/**
	* Returns the standards images with the primary key.
	*
	* @param stdImageId the primary key of the standards images
	* @return the standards images
	* @throws PortalException if a standards images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsImages getStandardsImages(
		long stdImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsImagesLocalService.getStandardsImages(stdImageId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsImagesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the standards imageses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards imageses
	* @param end the upper bound of the range of standards imageses (not inclusive)
	* @return the range of standards imageses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsImages> getStandardsImageses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsImagesLocalService.getStandardsImageses(start, end);
	}

	/**
	* Returns the number of standards imageses.
	*
	* @return the number of standards imageses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getStandardsImagesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsImagesLocalService.getStandardsImagesesCount();
	}

	/**
	* Updates the standards images in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param standardsImages the standards images
	* @return the standards images that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsImages updateStandardsImages(
		com.ihg.brandstandards.db.model.StandardsImages standardsImages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsImagesLocalService.updateStandardsImages(standardsImages);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _standardsImagesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_standardsImagesLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _standardsImagesLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void clearCache() {
		_standardsImagesLocalService.clearCache();
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsImages> getStdImages(
		long imageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsImagesLocalService.getStdImages(imageId);
	}

	@Override
	public java.util.List<java.lang.String> StandardsImagesCount(long imageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsImagesLocalService.StandardsImagesCount(imageId);
	}

	/**
	* Find Images by Std Id.
	*
	* @return list of Images.
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsImages> getStandardsImagesByStdId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsImagesLocalService.getStandardsImagesByStdId(stdId);
	}

	/**
	* Find all parent stdImages by StdId
	*
	* @throws SystemException
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsImages> getParentStdImages(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsImagesLocalService.getParentStdImages(stdId);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsImages> getParentStdImagesByLocaleCode(
		long stdId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsImagesLocalService.getParentStdImagesByLocaleCode(stdId,
			localeCode);
	}

	/**
	* find all images by parentId and stdId
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsImages> getStdImagesByParentImageIdStdId(
		long parentImageId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsImagesLocalService.getStdImagesByParentImageIdStdId(parentImageId,
			stdId);
	}

	/**
	* Find images of particular stdId, parentImageId and localeCode
	*
	* @throws SystemException
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsImages> getStdImagesByParentImageIdStdIdLocaleCd(
		long parentImageId, long stdId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsImagesLocalService.getStdImagesByParentImageIdStdIdLocaleCd(parentImageId,
			stdId, localeCode);
	}

	/**
	* This method deletes images deep down, that is, cascade delete along with children stdImages
	*
	* @param stdImage
	* @throws SystemException
	* @throws NoSuchStandardsImagesException
	*/
	@Override
	public void deleteStdImagesDeep(long stdImageId)
		throws com.ihg.brandstandards.db.NoSuchStandardsImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		_standardsImagesLocalService.deleteStdImagesDeep(stdImageId);
	}

	/**
	* @param imageId
	* @param stdId
	* @param localeCd
	* @return
	* @throws SystemException
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsImages> getStandardsImagesByImageIdStdIdLocaleCd(
		long imageId, long stdId, java.lang.String localeCd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsImagesLocalService.getStandardsImagesByImageIdStdIdLocaleCd(imageId,
			stdId, localeCd);
	}

	/**
	* Get Standards Images translation by passing  stdId, regionId and locales.
	*
	* @param stdId
	* @param regionId
	* @param locales
	* @return
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsImages> getStandardImagesByStdIdAndRgnIdAndLocale(
		long stdId, java.lang.String regionId,
		java.util.List<java.lang.String> locales) {
		return _standardsImagesLocalService.getStandardImagesByStdIdAndRgnIdAndLocale(stdId,
			regionId, locales);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public StandardsImagesLocalService getWrappedStandardsImagesLocalService() {
		return _standardsImagesLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedStandardsImagesLocalService(
		StandardsImagesLocalService standardsImagesLocalService) {
		_standardsImagesLocalService = standardsImagesLocalService;
	}

	@Override
	public StandardsImagesLocalService getWrappedService() {
		return _standardsImagesLocalService;
	}

	@Override
	public void setWrappedService(
		StandardsImagesLocalService standardsImagesLocalService) {
		_standardsImagesLocalService = standardsImagesLocalService;
	}

	private StandardsImagesLocalService _standardsImagesLocalService;
}