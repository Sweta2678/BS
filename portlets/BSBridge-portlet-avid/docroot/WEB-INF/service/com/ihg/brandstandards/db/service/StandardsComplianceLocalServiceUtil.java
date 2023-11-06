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
 * Provides the local service utility for StandardsCompliance. This utility wraps
 * {@link com.ihg.brandstandards.db.service.impl.StandardsComplianceLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mummanedi
 * @see StandardsComplianceLocalService
 * @see com.ihg.brandstandards.db.service.base.StandardsComplianceLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.StandardsComplianceLocalServiceImpl
 * @generated
 */
public class StandardsComplianceLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.StandardsComplianceLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the standards compliance to the database. Also notifies the appropriate model listeners.
	*
	* @param standardsCompliance the standards compliance
	* @return the standards compliance that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCompliance addStandardsCompliance(
		com.ihg.brandstandards.db.model.StandardsCompliance standardsCompliance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addStandardsCompliance(standardsCompliance);
	}

	/**
	* Creates a new standards compliance with the primary key. Does not add the standards compliance to the database.
	*
	* @param stdComplianceId the primary key for the new standards compliance
	* @return the new standards compliance
	*/
	public static com.ihg.brandstandards.db.model.StandardsCompliance createStandardsCompliance(
		long stdComplianceId) {
		return getService().createStandardsCompliance(stdComplianceId);
	}

	/**
	* Deletes the standards compliance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stdComplianceId the primary key of the standards compliance
	* @return the standards compliance that was removed
	* @throws PortalException if a standards compliance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCompliance deleteStandardsCompliance(
		long stdComplianceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStandardsCompliance(stdComplianceId);
	}

	/**
	* Deletes the standards compliance from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsCompliance the standards compliance
	* @return the standards compliance that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCompliance deleteStandardsCompliance(
		com.ihg.brandstandards.db.model.StandardsCompliance standardsCompliance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStandardsCompliance(standardsCompliance);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsComplianceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsComplianceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.ihg.brandstandards.db.model.StandardsCompliance fetchStandardsCompliance(
		long stdComplianceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchStandardsCompliance(stdComplianceId);
	}

	/**
	* Returns the standards compliance with the primary key.
	*
	* @param stdComplianceId the primary key of the standards compliance
	* @return the standards compliance
	* @throws PortalException if a standards compliance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCompliance getStandardsCompliance(
		long stdComplianceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardsCompliance(stdComplianceId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the standards compliances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsComplianceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards compliances
	* @param end the upper bound of the range of standards compliances (not inclusive)
	* @return the range of standards compliances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCompliance> getStandardsCompliances(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardsCompliances(start, end);
	}

	/**
	* Returns the number of standards compliances.
	*
	* @return the number of standards compliances
	* @throws SystemException if a system exception occurred
	*/
	public static int getStandardsCompliancesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardsCompliancesCount();
	}

	/**
	* Updates the standards compliance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param standardsCompliance the standards compliance
	* @return the standards compliance that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsCompliance updateStandardsCompliance(
		com.ihg.brandstandards.db.model.StandardsCompliance standardsCompliance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateStandardsCompliance(standardsCompliance);
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

	public static void saveStandardCompliance(long stdId,
		java.lang.String chainCode, java.lang.String ruleDate,
		java.lang.String complianceExpiry, java.lang.String stdCompliance)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.saveStandardCompliance(stdId, chainCode, ruleDate,
			complianceExpiry, stdCompliance);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCompliance> getStandardsComplianceByStdId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardsComplianceByStdId(stdId);
	}

	/**
	* @param stdId
	* @param chainCode
	* @return
	* @throws SystemException
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCompliance> getStandardsComplianceByStdIdAndChainCode(
		long stdId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getStandardsComplianceByStdIdAndChainCode(stdId, chainCode);
	}

	/**
	* @param stdId
	* @param chainCode
	* @param countryCode
	* @return
	* @throws SystemException
	*/
	public static com.ihg.brandstandards.db.model.StandardsCompliance getStandardsComplianceByStdIdChainCodeCountryCode(
		long stdId, java.lang.String chainCode, java.lang.String countryCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getStandardsComplianceByStdIdChainCodeCountryCode(stdId,
			chainCode, countryCode);
	}

	public static com.ihg.brandstandards.db.model.StandardsCompliance createStandardsCompliance()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().createStandardsCompliance();
	}

	public static void saveStandardsCompliance(
		com.ihg.brandstandards.db.model.StandardsCompliance stdCompliance)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().saveStandardsCompliance(stdCompliance);
	}

	public static java.lang.String assignComplianceDateToCountry(
		java.lang.String fromCountryCode, java.lang.String toCountryCode) {
		return getService()
				   .assignComplianceDateToCountry(fromCountryCode, toCountryCode);
	}

	public static java.lang.String assignExpiryDateToCountry(
		java.lang.String fromCountryCode, java.lang.String toCountryCode) {
		return getService()
				   .assignExpiryDateToCountry(fromCountryCode, toCountryCode);
	}

	public static java.lang.String deleteComplianceExpiryDateAttribute(
		java.lang.String ctryNameCode, java.lang.String cmplExprRuleCd) {
		return getService()
				   .deleteComplianceExpiryDateAttribute(ctryNameCode,
			cmplExprRuleCd);
	}

	public static void clearService() {
		_service = null;
	}

	public static StandardsComplianceLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					StandardsComplianceLocalService.class.getName());

			if (invokableLocalService instanceof StandardsComplianceLocalService) {
				_service = (StandardsComplianceLocalService)invokableLocalService;
			}
			else {
				_service = new StandardsComplianceLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(StandardsComplianceLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(StandardsComplianceLocalService service) {
	}

	private static StandardsComplianceLocalService _service;
}