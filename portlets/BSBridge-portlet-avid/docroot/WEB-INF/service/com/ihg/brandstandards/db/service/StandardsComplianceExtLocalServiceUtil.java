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
 * Provides the local service utility for StandardsComplianceExt. This utility wraps
 * {@link com.ihg.brandstandards.db.service.impl.StandardsComplianceExtLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mummanedi
 * @see StandardsComplianceExtLocalService
 * @see com.ihg.brandstandards.db.service.base.StandardsComplianceExtLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.StandardsComplianceExtLocalServiceImpl
 * @generated
 */
public class StandardsComplianceExtLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.StandardsComplianceExtLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the standards compliance ext to the database. Also notifies the appropriate model listeners.
	*
	* @param standardsComplianceExt the standards compliance ext
	* @return the standards compliance ext that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsComplianceExt addStandardsComplianceExt(
		com.ihg.brandstandards.db.model.StandardsComplianceExt standardsComplianceExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addStandardsComplianceExt(standardsComplianceExt);
	}

	/**
	* Creates a new standards compliance ext with the primary key. Does not add the standards compliance ext to the database.
	*
	* @param stdComplianceId the primary key for the new standards compliance ext
	* @return the new standards compliance ext
	*/
	public static com.ihg.brandstandards.db.model.StandardsComplianceExt createStandardsComplianceExt(
		long stdComplianceId) {
		return getService().createStandardsComplianceExt(stdComplianceId);
	}

	/**
	* Deletes the standards compliance ext with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stdComplianceId the primary key of the standards compliance ext
	* @return the standards compliance ext that was removed
	* @throws PortalException if a standards compliance ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsComplianceExt deleteStandardsComplianceExt(
		long stdComplianceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStandardsComplianceExt(stdComplianceId);
	}

	/**
	* Deletes the standards compliance ext from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsComplianceExt the standards compliance ext
	* @return the standards compliance ext that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsComplianceExt deleteStandardsComplianceExt(
		com.ihg.brandstandards.db.model.StandardsComplianceExt standardsComplianceExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStandardsComplianceExt(standardsComplianceExt);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsComplianceExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsComplianceExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.ihg.brandstandards.db.model.StandardsComplianceExt fetchStandardsComplianceExt(
		long stdComplianceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchStandardsComplianceExt(stdComplianceId);
	}

	/**
	* Returns the standards compliance ext with the primary key.
	*
	* @param stdComplianceId the primary key of the standards compliance ext
	* @return the standards compliance ext
	* @throws PortalException if a standards compliance ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsComplianceExt getStandardsComplianceExt(
		long stdComplianceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardsComplianceExt(stdComplianceId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the standards compliance exts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsComplianceExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards compliance exts
	* @param end the upper bound of the range of standards compliance exts (not inclusive)
	* @return the range of standards compliance exts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsComplianceExt> getStandardsComplianceExts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardsComplianceExts(start, end);
	}

	/**
	* Returns the number of standards compliance exts.
	*
	* @return the number of standards compliance exts
	* @throws SystemException if a system exception occurred
	*/
	public static int getStandardsComplianceExtsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardsComplianceExtsCount();
	}

	/**
	* Updates the standards compliance ext in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param standardsComplianceExt the standards compliance ext
	* @return the standards compliance ext that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsComplianceExt updateStandardsComplianceExt(
		com.ihg.brandstandards.db.model.StandardsComplianceExt standardsComplianceExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateStandardsComplianceExt(standardsComplianceExt);
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

	public static java.util.List<com.ihg.brandstandards.db.model.StandardsComplianceExt> getComplianceByRegion(
		java.lang.String query, long stdId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getComplianceByRegion(query, stdId, chainCode);
	}

	public static java.util.List<java.lang.Object> getRegionStatus(long stdId,
		java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRegionStatus(stdId, chainCode);
	}

	public static java.util.List<java.lang.Object> getRegionCmplyExprCount(
		long stdId, java.lang.String chainCd, java.lang.String rgnName,
		java.lang.String cmply_expr_value, java.lang.String rule_cd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getRegionCmplyExprCount(stdId, chainCd, rgnName,
			cmply_expr_value, rule_cd);
	}

	public static void clearService() {
		_service = null;
	}

	public static StandardsComplianceExtLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					StandardsComplianceExtLocalService.class.getName());

			if (invokableLocalService instanceof StandardsComplianceExtLocalService) {
				_service = (StandardsComplianceExtLocalService)invokableLocalService;
			}
			else {
				_service = new StandardsComplianceExtLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(StandardsComplianceExtLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(StandardsComplianceExtLocalService service) {
	}

	private static StandardsComplianceExtLocalService _service;
}