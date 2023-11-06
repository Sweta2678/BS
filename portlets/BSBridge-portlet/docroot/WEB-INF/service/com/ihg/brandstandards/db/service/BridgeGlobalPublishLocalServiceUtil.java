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
 * Provides the local service utility for BridgeGlobalPublish. This utility wraps
 * {@link com.ihg.brandstandards.db.service.impl.BridgeGlobalPublishLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mummanedi
 * @see BridgeGlobalPublishLocalService
 * @see com.ihg.brandstandards.db.service.base.BridgeGlobalPublishLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.BridgeGlobalPublishLocalServiceImpl
 * @generated
 */
public class BridgeGlobalPublishLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.BridgeGlobalPublishLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the bridge global publish to the database. Also notifies the appropriate model listeners.
	*
	* @param bridgeGlobalPublish the bridge global publish
	* @return the bridge global publish that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublish addBridgeGlobalPublish(
		com.ihg.brandstandards.db.model.BridgeGlobalPublish bridgeGlobalPublish)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBridgeGlobalPublish(bridgeGlobalPublish);
	}

	/**
	* Creates a new bridge global publish with the primary key. Does not add the bridge global publish to the database.
	*
	* @param globalPublishId the primary key for the new bridge global publish
	* @return the new bridge global publish
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublish createBridgeGlobalPublish(
		long globalPublishId) {
		return getService().createBridgeGlobalPublish(globalPublishId);
	}

	/**
	* Deletes the bridge global publish with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param globalPublishId the primary key of the bridge global publish
	* @return the bridge global publish that was removed
	* @throws PortalException if a bridge global publish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublish deleteBridgeGlobalPublish(
		long globalPublishId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBridgeGlobalPublish(globalPublishId);
	}

	/**
	* Deletes the bridge global publish from the database. Also notifies the appropriate model listeners.
	*
	* @param bridgeGlobalPublish the bridge global publish
	* @return the bridge global publish that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublish deleteBridgeGlobalPublish(
		com.ihg.brandstandards.db.model.BridgeGlobalPublish bridgeGlobalPublish)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBridgeGlobalPublish(bridgeGlobalPublish);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.ihg.brandstandards.db.model.BridgeGlobalPublish fetchBridgeGlobalPublish(
		long globalPublishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBridgeGlobalPublish(globalPublishId);
	}

	/**
	* Returns the bridge global publish with the primary key.
	*
	* @param globalPublishId the primary key of the bridge global publish
	* @return the bridge global publish
	* @throws PortalException if a bridge global publish with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublish getBridgeGlobalPublish(
		long globalPublishId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBridgeGlobalPublish(globalPublishId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the bridge global publishs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge global publishs
	* @param end the upper bound of the range of bridge global publishs (not inclusive)
	* @return the range of bridge global publishs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublish> getBridgeGlobalPublishs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBridgeGlobalPublishs(start, end);
	}

	/**
	* Returns the number of bridge global publishs.
	*
	* @return the number of bridge global publishs
	* @throws SystemException if a system exception occurred
	*/
	public static int getBridgeGlobalPublishsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBridgeGlobalPublishsCount();
	}

	/**
	* Updates the bridge global publish in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bridgeGlobalPublish the bridge global publish
	* @return the bridge global publish that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublish updateBridgeGlobalPublish(
		com.ihg.brandstandards.db.model.BridgeGlobalPublish bridgeGlobalPublish)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBridgeGlobalPublish(bridgeGlobalPublish);
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

	public static java.util.List getMustPublishStandardsByIdsAndBrand(
		java.lang.String stdIdsByCommaSeprated, java.lang.String brand,
		boolean mustPublish) {
		return getService()
				   .getMustPublishStandardsByIdsAndBrand(stdIdsByCommaSeprated,
			brand, mustPublish);
	}

	public static java.util.Map<java.lang.String, java.lang.Long> getTotalIssuesforMustpublish(
		java.lang.String isMustPublish, long publishId, java.lang.String brand) {
		return getService()
				   .getTotalIssuesforMustpublish(isMustPublish, publishId, brand);
	}

	public static com.ihg.brandstandards.db.model.BridgeGlobalPublish getByPublishIdAndStdId(
		long publishId, long stdId) {
		return getService().getByPublishIdAndStdId(publishId, stdId);
	}

	public static com.ihg.brandstandards.db.model.BridgeGlobalPublish getByStdIdAndMustPublishInd(
		long publishId, long stdId, java.lang.String mustPublishInd) {
		return getService()
				   .getByStdIdAndMustPublishInd(publishId, stdId, mustPublishInd);
	}

	public static java.util.List<java.lang.Long> getGlobalStandardsByPublishIdAndIndicator(
		java.lang.String indicator, long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getGlobalStandardsByPublishIdAndIndicator(indicator,
			publishId);
	}

	public static com.ihg.brandstandards.db.model.BridgeGlobalPublish getNewBridgeGlobalPublish() {
		return getService().getNewBridgeGlobalPublish();
	}

	public static com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry getNewBridgeGlobalPublishCountry() {
		return getService().getNewBridgeGlobalPublishCountry();
	}

	public static java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry> getBridgeGlobalPublishCountryByGlobalPublishIdAndRegionId(
		long bridgeGlobalPublishId, long regionId) {
		return getService()
				   .getBridgeGlobalPublishCountryByGlobalPublishIdAndRegionId(bridgeGlobalPublishId,
			regionId);
	}

	public static java.util.Map<java.lang.String, java.lang.String> importGlobalMustPublishStandards(
		long publishId, java.lang.String chainCode,
		java.lang.String screenName, java.lang.String stdIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .importGlobalMustPublishStandards(publishId, chainCode,
			screenName, stdIds);
	}

	public static void clearService() {
		_service = null;
	}

	public static BridgeGlobalPublishLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BridgeGlobalPublishLocalService.class.getName());

			if (invokableLocalService instanceof BridgeGlobalPublishLocalService) {
				_service = (BridgeGlobalPublishLocalService)invokableLocalService;
			}
			else {
				_service = new BridgeGlobalPublishLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BridgeGlobalPublishLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(BridgeGlobalPublishLocalService service) {
	}

	private static BridgeGlobalPublishLocalService _service;
}