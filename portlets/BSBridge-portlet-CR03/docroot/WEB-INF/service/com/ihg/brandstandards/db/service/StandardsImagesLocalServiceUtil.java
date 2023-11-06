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
 * Provides the local service utility for StandardsImages. This utility wraps
 * {@link com.ihg.brandstandards.db.service.impl.StandardsImagesLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mummanedi
 * @see StandardsImagesLocalService
 * @see com.ihg.brandstandards.db.service.base.StandardsImagesLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.StandardsImagesLocalServiceImpl
 * @generated
 */
public class StandardsImagesLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.StandardsImagesLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the standards images to the database. Also notifies the appropriate model listeners.
	*
	* @param standardsImages the standards images
	* @return the standards images that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages addStandardsImages(
		com.ihg.brandstandards.db.model.StandardsImages standardsImages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addStandardsImages(standardsImages);
	}

	/**
	* Creates a new standards images with the primary key. Does not add the standards images to the database.
	*
	* @param stdImageId the primary key for the new standards images
	* @return the new standards images
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages createStandardsImages(
		long stdImageId) {
		return getService().createStandardsImages(stdImageId);
	}

	/**
	* Deletes the standards images with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stdImageId the primary key of the standards images
	* @return the standards images that was removed
	* @throws PortalException if a standards images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages deleteStandardsImages(
		long stdImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStandardsImages(stdImageId);
	}

	/**
	* Deletes the standards images from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsImages the standards images
	* @return the standards images that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages deleteStandardsImages(
		com.ihg.brandstandards.db.model.StandardsImages standardsImages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStandardsImages(standardsImages);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.ihg.brandstandards.db.model.StandardsImages fetchStandardsImages(
		long stdImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchStandardsImages(stdImageId);
	}

	/**
	* Returns the standards images with the primary key.
	*
	* @param stdImageId the primary key of the standards images
	* @return the standards images
	* @throws PortalException if a standards images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages getStandardsImages(
		long stdImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardsImages(stdImageId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> getStandardsImageses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardsImageses(start, end);
	}

	/**
	* Returns the number of standards imageses.
	*
	* @return the number of standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static int getStandardsImagesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardsImagesesCount();
	}

	/**
	* Updates the standards images in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param standardsImages the standards images
	* @return the standards images that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages updateStandardsImages(
		com.ihg.brandstandards.db.model.StandardsImages standardsImages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateStandardsImages(standardsImages);
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

	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> getStdImages(
		long imageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStdImages(imageId);
	}

	public static java.util.List<java.lang.String> StandardsImagesCount(
		long imageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().StandardsImagesCount(imageId);
	}

	/**
	* Find Images by Std Id.
	*
	* @return list of Images.
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> getStandardsImagesByStdId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardsImagesByStdId(stdId);
	}

	/**
	* Find all parent stdImages by StdId
	*
	* @throws SystemException
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> getParentStdImages(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getParentStdImages(stdId);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> getParentStdImagesByLocaleCode(
		long stdId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getParentStdImagesByLocaleCode(stdId, localeCode);
	}

	/**
	* find all images by parentId and stdId
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> getStdImagesByParentImageIdStdId(
		long parentImageId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getStdImagesByParentImageIdStdId(parentImageId, stdId);
	}

	/**
	* Find images of particular stdId, parentImageId and localeCode
	*
	* @throws SystemException
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> getStdImagesByParentImageIdStdIdLocaleCd(
		long parentImageId, long stdId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getStdImagesByParentImageIdStdIdLocaleCd(parentImageId,
			stdId, localeCode);
	}

	/**
	* This method deletes images deep down, that is, cascade delete along with children stdImages
	*
	* @param stdImage
	* @throws SystemException
	* @throws NoSuchStandardsImagesException
	*/
	public static void deleteStdImagesDeep(long stdImageId)
		throws com.ihg.brandstandards.db.NoSuchStandardsImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteStdImagesDeep(stdImageId);
	}

	/**
	* @param imageId
	* @param stdId
	* @param localeCd
	* @return
	* @throws SystemException
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> getStandardsImagesByImageIdStdIdLocaleCd(
		long imageId, long stdId, java.lang.String localeCd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getStandardsImagesByImageIdStdIdLocaleCd(imageId, stdId,
			localeCd);
	}

	/**
	* Get Standards Images translation by passing  stdId, regionId and locales.
	*
	* @param stdId
	* @param regionId
	* @param locales
	* @return
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> getStandardImagesByStdIdAndRgnIdAndLocale(
		long stdId, java.lang.String regionId,
		java.util.List<java.lang.String> locales) {
		return getService()
				   .getStandardImagesByStdIdAndRgnIdAndLocale(stdId, regionId,
			locales);
	}

	public static void clearService() {
		_service = null;
	}

	public static StandardsImagesLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					StandardsImagesLocalService.class.getName());

			if (invokableLocalService instanceof StandardsImagesLocalService) {
				_service = (StandardsImagesLocalService)invokableLocalService;
			}
			else {
				_service = new StandardsImagesLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(StandardsImagesLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(StandardsImagesLocalService service) {
	}

	private static StandardsImagesLocalService _service;
}