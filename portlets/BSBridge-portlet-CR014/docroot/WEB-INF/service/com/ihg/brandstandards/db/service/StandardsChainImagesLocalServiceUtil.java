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
 * Provides the local service utility for StandardsChainImages. This utility wraps
 * {@link com.ihg.brandstandards.db.service.impl.StandardsChainImagesLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mummanedi
 * @see StandardsChainImagesLocalService
 * @see com.ihg.brandstandards.db.service.base.StandardsChainImagesLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.StandardsChainImagesLocalServiceImpl
 * @generated
 */
public class StandardsChainImagesLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.StandardsChainImagesLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the standards chain images to the database. Also notifies the appropriate model listeners.
	*
	* @param standardsChainImages the standards chain images
	* @return the standards chain images that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsChainImages addStandardsChainImages(
		com.ihg.brandstandards.db.model.StandardsChainImages standardsChainImages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addStandardsChainImages(standardsChainImages);
	}

	/**
	* Creates a new standards chain images with the primary key. Does not add the standards chain images to the database.
	*
	* @param standardsChainImagesPK the primary key for the new standards chain images
	* @return the new standards chain images
	*/
	public static com.ihg.brandstandards.db.model.StandardsChainImages createStandardsChainImages(
		com.ihg.brandstandards.db.service.persistence.StandardsChainImagesPK standardsChainImagesPK) {
		return getService().createStandardsChainImages(standardsChainImagesPK);
	}

	/**
	* Deletes the standards chain images with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsChainImagesPK the primary key of the standards chain images
	* @return the standards chain images that was removed
	* @throws PortalException if a standards chain images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsChainImages deleteStandardsChainImages(
		com.ihg.brandstandards.db.service.persistence.StandardsChainImagesPK standardsChainImagesPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStandardsChainImages(standardsChainImagesPK);
	}

	/**
	* Deletes the standards chain images from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsChainImages the standards chain images
	* @return the standards chain images that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsChainImages deleteStandardsChainImages(
		com.ihg.brandstandards.db.model.StandardsChainImages standardsChainImages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStandardsChainImages(standardsChainImages);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsChainImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.ihg.brandstandards.db.model.StandardsChainImages fetchStandardsChainImages(
		com.ihg.brandstandards.db.service.persistence.StandardsChainImagesPK standardsChainImagesPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchStandardsChainImages(standardsChainImagesPK);
	}

	/**
	* Returns the standards chain images with the primary key.
	*
	* @param standardsChainImagesPK the primary key of the standards chain images
	* @return the standards chain images
	* @throws PortalException if a standards chain images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsChainImages getStandardsChainImages(
		com.ihg.brandstandards.db.service.persistence.StandardsChainImagesPK standardsChainImagesPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardsChainImages(standardsChainImagesPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsChainImages> getStandardsChainImageses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardsChainImageses(start, end);
	}

	/**
	* Returns the number of standards chain imageses.
	*
	* @return the number of standards chain imageses
	* @throws SystemException if a system exception occurred
	*/
	public static int getStandardsChainImagesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardsChainImagesesCount();
	}

	/**
	* Updates the standards chain images in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param standardsChainImages the standards chain images
	* @return the standards chain images that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsChainImages updateStandardsChainImages(
		com.ihg.brandstandards.db.model.StandardsChainImages standardsChainImages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateStandardsChainImages(standardsChainImages);
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

	public static com.ihg.brandstandards.db.model.StandardsChainImages getStandardsChainImagesObject() {
		return getService().getStandardsChainImagesObject();
	}

	public static java.util.List<com.ihg.brandstandards.db.model.StandardsChainImages> getChainImagesByStdImageId(
		long stdImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getChainImagesByStdImageId(stdImageId);
	}

	public static void clearService() {
		_service = null;
	}

	public static StandardsChainImagesLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					StandardsChainImagesLocalService.class.getName());

			if (invokableLocalService instanceof StandardsChainImagesLocalService) {
				_service = (StandardsChainImagesLocalService)invokableLocalService;
			}
			else {
				_service = new StandardsChainImagesLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(StandardsChainImagesLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(StandardsChainImagesLocalService service) {
	}

	private static StandardsChainImagesLocalService _service;
}