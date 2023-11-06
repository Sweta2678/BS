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
 * Provides the local service utility for PublishExtStd. This utility wraps
 * {@link com.ihg.brandstandards.db.service.impl.PublishExtStdLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mummanedi
 * @see PublishExtStdLocalService
 * @see com.ihg.brandstandards.db.service.base.PublishExtStdLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.PublishExtStdLocalServiceImpl
 * @generated
 */
public class PublishExtStdLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.PublishExtStdLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. to the database. Also notifies the appropriate model listeners.
	*
	* @param publishExtStd the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	* @return the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishExtStd addPublishExtStd(
		com.ihg.brandstandards.db.model.PublishExtStd publishExtStd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPublishExtStd(publishExtStd);
	}

	/**
	* Creates a new Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key. Does not add the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. to the database.
	*
	* @param stdId the primary key for the new Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	* @return the new Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	*/
	public static com.ihg.brandstandards.db.model.PublishExtStd createPublishExtStd(
		long stdId) {
		return getService().createPublishExtStd(stdId);
	}

	/**
	* Deletes the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stdId the primary key of the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	* @return the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. that was removed
	* @throws PortalException if a Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishExtStd deletePublishExtStd(
		long stdId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePublishExtStd(stdId);
	}

	/**
	* Deletes the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. from the database. Also notifies the appropriate model listeners.
	*
	* @param publishExtStd the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	* @return the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishExtStd deletePublishExtStd(
		com.ihg.brandstandards.db.model.PublishExtStd publishExtStd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePublishExtStd(publishExtStd);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishExtStdModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.ihg.brandstandards.db.model.PublishExtStd fetchPublishExtStd(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPublishExtStd(stdId);
	}

	/**
	* Returns the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key.
	*
	* @param stdId the primary key of the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	* @return the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	* @throws PortalException if a Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishExtStd getPublishExtStd(
		long stdId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPublishExtStd(stdId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.ihg.brandstandards.db.model.PublishExtStd> getPublishExtStds(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPublishExtStds(start, end);
	}

	/**
	* Returns the number of Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s.
	*
	* @return the number of Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.s
	* @throws SystemException if a system exception occurred
	*/
	public static int getPublishExtStdsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPublishExtStdsCount();
	}

	/**
	* Updates the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param publishExtStd the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	* @return the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishExtStd updatePublishExtStd(
		com.ihg.brandstandards.db.model.PublishExtStd publishExtStd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePublishExtStd(publishExtStd);
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

	public static java.util.List<com.ihg.brandstandards.db.model.PublishExtStd> getPublishedStandards(
		long stdId, java.lang.String stdType, java.lang.String brandCd,
		java.lang.String filterOn, java.lang.String isNonMatch,
		java.lang.String fromDate, java.lang.String toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getPublishedStandards(stdId, stdType, brandCd, filterOn,
			isNonMatch, fromDate, toDate);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.PublishExtStd> getPublishedStandards(
		java.lang.String brandCd, java.lang.String filterOn,
		java.lang.String isNonMatch, java.lang.String fromDate,
		java.lang.String toDate, java.lang.String filterIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getPublishedStandards(brandCd, filterOn, isNonMatch,
			fromDate, toDate, filterIds);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.PublishExtStd> getPublishedSpecs(
		java.lang.String stdType, java.lang.String brandCd,
		java.lang.String fromDate, java.lang.String toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPublishedSpecs(stdType, brandCd, fromDate, toDate);
	}

	public static void clearService() {
		_service = null;
	}

	public static PublishExtStdLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PublishExtStdLocalService.class.getName());

			if (invokableLocalService instanceof PublishExtStdLocalService) {
				_service = (PublishExtStdLocalService)invokableLocalService;
			}
			else {
				_service = new PublishExtStdLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PublishExtStdLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(PublishExtStdLocalService service) {
	}

	private static PublishExtStdLocalService _service;
}