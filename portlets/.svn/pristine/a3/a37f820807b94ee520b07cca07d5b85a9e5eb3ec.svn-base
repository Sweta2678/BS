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
 * Provides the local service utility for StandardsCountryExt. This utility wraps
 * {@link com.ihg.brandstandards.db.service.impl.StandardsCountryExtLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mummanedi
 * @see StandardsCountryExtLocalService
 * @see com.ihg.brandstandards.db.service.base.StandardsCountryExtLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.StandardsCountryExtLocalServiceImpl
 * @generated
 */
public class StandardsCountryExtLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.StandardsCountryExtLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the standards country ext to the database. Also notifies the appropriate model listeners.
	*
	* @param standardsCountryExt the standards country ext
	* @return the standards country ext that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCountryExt addStandardsCountryExt(
		com.ihg.brandstandards.db.model.StandardsCountryExt standardsCountryExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addStandardsCountryExt(standardsCountryExt);
	}

	/**
	* Creates a new standards country ext with the primary key. Does not add the standards country ext to the database.
	*
	* @param rowNum the primary key for the new standards country ext
	* @return the new standards country ext
	*/
	public static com.ihg.brandstandards.db.model.StandardsCountryExt createStandardsCountryExt(
		long rowNum) {
		return getService().createStandardsCountryExt(rowNum);
	}

	/**
	* Deletes the standards country ext with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rowNum the primary key of the standards country ext
	* @return the standards country ext that was removed
	* @throws PortalException if a standards country ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCountryExt deleteStandardsCountryExt(
		long rowNum)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStandardsCountryExt(rowNum);
	}

	/**
	* Deletes the standards country ext from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsCountryExt the standards country ext
	* @return the standards country ext that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCountryExt deleteStandardsCountryExt(
		com.ihg.brandstandards.db.model.StandardsCountryExt standardsCountryExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStandardsCountryExt(standardsCountryExt);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.ihg.brandstandards.db.model.StandardsCountryExt fetchStandardsCountryExt(
		long rowNum) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchStandardsCountryExt(rowNum);
	}

	/**
	* Returns the standards country ext with the primary key.
	*
	* @param rowNum the primary key of the standards country ext
	* @return the standards country ext
	* @throws PortalException if a standards country ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCountryExt getStandardsCountryExt(
		long rowNum)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardsCountryExt(rowNum);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the standards country exts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards country exts
	* @param end the upper bound of the range of standards country exts (not inclusive)
	* @return the range of standards country exts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCountryExt> getStandardsCountryExts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardsCountryExts(start, end);
	}

	/**
	* Returns the number of standards country exts.
	*
	* @return the number of standards country exts
	* @throws SystemException if a system exception occurred
	*/
	public static int getStandardsCountryExtsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardsCountryExtsCount();
	}

	/**
	* Updates the standards country ext in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param standardsCountryExt the standards country ext
	* @return the standards country ext that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCountryExt updateStandardsCountryExt(
		com.ihg.brandstandards.db.model.StandardsCountryExt standardsCountryExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateStandardsCountryExt(standardsCountryExt);
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

	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCountryExt> getCountryListByStdIdAndRegionId(
		long stdId, long regionId, long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCountryListByStdIdAndRegionId(stdId, regionId, publishId);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCountryExt> getCountryListByStdIdAndRegionIdForMyPublication(
		long stdId, long regionId, long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCountryListByStdIdAndRegionIdForMyPublication(stdId,
			regionId, publishId);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCountryExt> getRegionBasedCountryStatus(
		long stdId, java.lang.String chainCd, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRegionBasedCountryStatus(stdId, chainCd, regionId);
	}

	public static java.lang.String getRegionCodeByCountryCode(
		java.lang.String ctryCode) {
		return getService().getRegionCodeByCountryCode(ctryCode);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCountryExt> getCountryRegionList() {
		return getService().getCountryRegionList();
	}

	public static java.util.List<java.lang.String> getCountryListByRegionCode(
		java.lang.String regionCode) {
		return getService().getCountryListByRegionCode(regionCode);
	}

	public static java.util.List<java.lang.String> getCountryListBySubRegionCode(
		java.lang.String subRegionCode) {
		return getService().getCountryListBySubRegionCode(subRegionCode);
	}

	public static java.util.List<java.lang.String> getAllStdCountryList() {
		return getService().getAllStdCountryList();
	}

	public static void clearService() {
		_service = null;
	}

	public static StandardsCountryExtLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					StandardsCountryExtLocalService.class.getName());

			if (invokableLocalService instanceof StandardsCountryExtLocalService) {
				_service = (StandardsCountryExtLocalService)invokableLocalService;
			}
			else {
				_service = new StandardsCountryExtLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(StandardsCountryExtLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(StandardsCountryExtLocalService service) {
	}

	private static StandardsCountryExtLocalService _service;
}