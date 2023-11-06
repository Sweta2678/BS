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
 * Provides the local service utility for BridgePublishPreview. This utility wraps
 * {@link com.ihg.brandstandards.db.service.impl.BridgePublishPreviewLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mummanedi
 * @see BridgePublishPreviewLocalService
 * @see com.ihg.brandstandards.db.service.base.BridgePublishPreviewLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.BridgePublishPreviewLocalServiceImpl
 * @generated
 */
public class BridgePublishPreviewLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.BridgePublishPreviewLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the bridge publish preview to the database. Also notifies the appropriate model listeners.
	*
	* @param bridgePublishPreview the bridge publish preview
	* @return the bridge publish preview that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishPreview addBridgePublishPreview(
		com.ihg.brandstandards.db.model.BridgePublishPreview bridgePublishPreview)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBridgePublishPreview(bridgePublishPreview);
	}

	/**
	* Creates a new bridge publish preview with the primary key. Does not add the bridge publish preview to the database.
	*
	* @param stdId the primary key for the new bridge publish preview
	* @return the new bridge publish preview
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishPreview createBridgePublishPreview(
		long stdId) {
		return getService().createBridgePublishPreview(stdId);
	}

	/**
	* Deletes the bridge publish preview with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stdId the primary key of the bridge publish preview
	* @return the bridge publish preview that was removed
	* @throws PortalException if a bridge publish preview with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishPreview deleteBridgePublishPreview(
		long stdId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBridgePublishPreview(stdId);
	}

	/**
	* Deletes the bridge publish preview from the database. Also notifies the appropriate model listeners.
	*
	* @param bridgePublishPreview the bridge publish preview
	* @return the bridge publish preview that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishPreview deleteBridgePublishPreview(
		com.ihg.brandstandards.db.model.BridgePublishPreview bridgePublishPreview)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBridgePublishPreview(bridgePublishPreview);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishPreviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishPreviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.ihg.brandstandards.db.model.BridgePublishPreview fetchBridgePublishPreview(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBridgePublishPreview(stdId);
	}

	/**
	* Returns the bridge publish preview with the primary key.
	*
	* @param stdId the primary key of the bridge publish preview
	* @return the bridge publish preview
	* @throws PortalException if a bridge publish preview with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishPreview getBridgePublishPreview(
		long stdId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBridgePublishPreview(stdId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the bridge publish previews.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishPreviewModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge publish previews
	* @param end the upper bound of the range of bridge publish previews (not inclusive)
	* @return the range of bridge publish previews
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishPreview> getBridgePublishPreviews(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBridgePublishPreviews(start, end);
	}

	/**
	* Returns the number of bridge publish previews.
	*
	* @return the number of bridge publish previews
	* @throws SystemException if a system exception occurred
	*/
	public static int getBridgePublishPreviewsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBridgePublishPreviewsCount();
	}

	/**
	* Updates the bridge publish preview in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bridgePublishPreview the bridge publish preview
	* @return the bridge publish preview that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishPreview updateBridgePublishPreview(
		com.ihg.brandstandards.db.model.BridgePublishPreview bridgePublishPreview)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBridgePublishPreview(bridgePublishPreview);
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

	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishPreview> getBridgePublishPreviewByRegionBrand(
		java.lang.String chainCd, long regionCd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getBridgePublishPreviewByRegionBrand(chainCd, regionCd);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishPreview> getBridgePublishPreview(
		java.lang.String groupName, java.lang.String chainCd, long regionId,
		java.lang.String filterIds, java.lang.String searchIds,
		java.lang.String selByState, java.lang.String locale,
		long bridgePublishId, java.lang.String groupType) {
		return getService()
				   .getBridgePublishPreview(groupName, chainCd, regionId,
			filterIds, searchIds, selByState, locale, bridgePublishId, groupType);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishPreview> searchStandardsById(
		java.lang.String stdIds, java.lang.String brand, boolean isMust)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().searchStandardsById(stdIds, brand, isMust);
	}

	public static java.util.List<com.ihg.brandstandards.custom.model.CountryList> getGroupsByCountryStatus(
		java.lang.String query) {
		return getService().getGroupsByCountryStatus(query);
	}

	public static void clearService() {
		_service = null;
	}

	public static BridgePublishPreviewLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BridgePublishPreviewLocalService.class.getName());

			if (invokableLocalService instanceof BridgePublishPreviewLocalService) {
				_service = (BridgePublishPreviewLocalService)invokableLocalService;
			}
			else {
				_service = new BridgePublishPreviewLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BridgePublishPreviewLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(BridgePublishPreviewLocalService service) {
	}

	private static BridgePublishPreviewLocalService _service;
}