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
 * Provides the local service utility for PublishStd. This utility wraps
 * {@link com.ihg.brandstandards.db.service.impl.PublishStdLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mummanedi
 * @see PublishStdLocalService
 * @see com.ihg.brandstandards.db.service.base.PublishStdLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.PublishStdLocalServiceImpl
 * @generated
 */
public class PublishStdLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.PublishStdLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the publish std to the database. Also notifies the appropriate model listeners.
	*
	* @param publishStd the publish std
	* @return the publish std that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishStd addPublishStd(
		com.ihg.brandstandards.db.model.PublishStd publishStd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPublishStd(publishStd);
	}

	/**
	* Creates a new publish std with the primary key. Does not add the publish std to the database.
	*
	* @param publishStdVerId the primary key for the new publish std
	* @return the new publish std
	*/
	public static com.ihg.brandstandards.db.model.PublishStd createPublishStd(
		long publishStdVerId) {
		return getService().createPublishStd(publishStdVerId);
	}

	/**
	* Deletes the publish std with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param publishStdVerId the primary key of the publish std
	* @return the publish std that was removed
	* @throws PortalException if a publish std with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishStd deletePublishStd(
		long publishStdVerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePublishStd(publishStdVerId);
	}

	/**
	* Deletes the publish std from the database. Also notifies the appropriate model listeners.
	*
	* @param publishStd the publish std
	* @return the publish std that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishStd deletePublishStd(
		com.ihg.brandstandards.db.model.PublishStd publishStd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePublishStd(publishStd);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishStdModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.ihg.brandstandards.db.model.PublishStd fetchPublishStd(
		long publishStdVerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPublishStd(publishStdVerId);
	}

	/**
	* Returns the publish std with the primary key.
	*
	* @param publishStdVerId the primary key of the publish std
	* @return the publish std
	* @throws PortalException if a publish std with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishStd getPublishStd(
		long publishStdVerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPublishStd(publishStdVerId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.ihg.brandstandards.db.model.PublishStd> getPublishStds(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPublishStds(start, end);
	}

	/**
	* Returns the number of publish stds.
	*
	* @return the number of publish stds
	* @throws SystemException if a system exception occurred
	*/
	public static int getPublishStdsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPublishStdsCount();
	}

	/**
	* Updates the publish std in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param publishStd the publish std
	* @return the publish std that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishStd updatePublishStd(
		com.ihg.brandstandards.db.model.PublishStd publishStd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePublishStd(publishStd);
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

	public static com.ihg.brandstandards.db.model.PublishStd getPublishForStdId(
		long publishId, long standardId)
		throws com.ihg.brandstandards.db.NoSuchPublishStdException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPublishForStdId(publishId, standardId);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.PublishStd> getAssociatedStandards(
		long parentStdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAssociatedStandards(parentStdId);
	}

	public static java.util.List getAssociatedStds(java.lang.String query) {
		return getService().getAssociatedStds(query);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.PublishStd> getStandardsByCountryAndBrand(
		long publishId, long taxonomyId, java.lang.String chainCode,
		java.lang.String countryCode, java.lang.String stdType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getStandardsByCountryAndBrand(publishId, taxonomyId,
			chainCode, countryCode, stdType);
	}

	public static com.ihg.brandstandards.db.model.PublishStd getStandardByBrand(
		long standardId, long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardByBrand(standardId, publishId);
	}

	public static void clearService() {
		_service = null;
	}

	public static PublishStdLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PublishStdLocalService.class.getName());

			if (invokableLocalService instanceof PublishStdLocalService) {
				_service = (PublishStdLocalService)invokableLocalService;
			}
			else {
				_service = new PublishStdLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PublishStdLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(PublishStdLocalService service) {
	}

	private static PublishStdLocalService _service;
}