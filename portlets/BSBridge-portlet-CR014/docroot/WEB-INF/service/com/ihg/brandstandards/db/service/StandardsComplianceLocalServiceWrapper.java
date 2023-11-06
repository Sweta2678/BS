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
 * Provides a wrapper for {@link StandardsComplianceLocalService}.
 *
 * @author Mummanedi
 * @see StandardsComplianceLocalService
 * @generated
 */
public class StandardsComplianceLocalServiceWrapper
	implements StandardsComplianceLocalService,
		ServiceWrapper<StandardsComplianceLocalService> {
	public StandardsComplianceLocalServiceWrapper(
		StandardsComplianceLocalService standardsComplianceLocalService) {
		_standardsComplianceLocalService = standardsComplianceLocalService;
	}

	/**
	* Adds the standards compliance to the database. Also notifies the appropriate model listeners.
	*
	* @param standardsCompliance the standards compliance
	* @return the standards compliance that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsCompliance addStandardsCompliance(
		com.ihg.brandstandards.db.model.StandardsCompliance standardsCompliance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsComplianceLocalService.addStandardsCompliance(standardsCompliance);
	}

	/**
	* Creates a new standards compliance with the primary key. Does not add the standards compliance to the database.
	*
	* @param stdComplianceId the primary key for the new standards compliance
	* @return the new standards compliance
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsCompliance createStandardsCompliance(
		long stdComplianceId) {
		return _standardsComplianceLocalService.createStandardsCompliance(stdComplianceId);
	}

	/**
	* Deletes the standards compliance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stdComplianceId the primary key of the standards compliance
	* @return the standards compliance that was removed
	* @throws PortalException if a standards compliance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsCompliance deleteStandardsCompliance(
		long stdComplianceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsComplianceLocalService.deleteStandardsCompliance(stdComplianceId);
	}

	/**
	* Deletes the standards compliance from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsCompliance the standards compliance
	* @return the standards compliance that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsCompliance deleteStandardsCompliance(
		com.ihg.brandstandards.db.model.StandardsCompliance standardsCompliance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsComplianceLocalService.deleteStandardsCompliance(standardsCompliance);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _standardsComplianceLocalService.dynamicQuery();
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
		return _standardsComplianceLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsComplianceLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsComplianceLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _standardsComplianceLocalService.dynamicQueryCount(dynamicQuery);
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
		return _standardsComplianceLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsCompliance fetchStandardsCompliance(
		long stdComplianceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsComplianceLocalService.fetchStandardsCompliance(stdComplianceId);
	}

	/**
	* Returns the standards compliance with the primary key.
	*
	* @param stdComplianceId the primary key of the standards compliance
	* @return the standards compliance
	* @throws PortalException if a standards compliance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsCompliance getStandardsCompliance(
		long stdComplianceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsComplianceLocalService.getStandardsCompliance(stdComplianceId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsComplianceLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCompliance> getStandardsCompliances(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsComplianceLocalService.getStandardsCompliances(start,
			end);
	}

	/**
	* Returns the number of standards compliances.
	*
	* @return the number of standards compliances
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getStandardsCompliancesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsComplianceLocalService.getStandardsCompliancesCount();
	}

	/**
	* Updates the standards compliance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param standardsCompliance the standards compliance
	* @return the standards compliance that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsCompliance updateStandardsCompliance(
		com.ihg.brandstandards.db.model.StandardsCompliance standardsCompliance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsComplianceLocalService.updateStandardsCompliance(standardsCompliance);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _standardsComplianceLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_standardsComplianceLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _standardsComplianceLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void clearCache() {
		_standardsComplianceLocalService.clearCache();
	}

	@Override
	public void saveStandardCompliance(long stdId, java.lang.String chainCode,
		java.lang.String ruleDate, java.lang.String complianceExpiry,
		java.lang.String stdCompliance)
		throws com.liferay.portal.kernel.exception.SystemException {
		_standardsComplianceLocalService.saveStandardCompliance(stdId,
			chainCode, ruleDate, complianceExpiry, stdCompliance);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCompliance> getStandardsComplianceByStdId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsComplianceLocalService.getStandardsComplianceByStdId(stdId);
	}

	/**
	* @param stdId
	* @param chainCode
	* @return
	* @throws SystemException
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCompliance> getStandardsComplianceByStdIdAndChainCode(
		long stdId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsComplianceLocalService.getStandardsComplianceByStdIdAndChainCode(stdId,
			chainCode);
	}

	/**
	* @param stdId
	* @param chainCode
	* @param countryCode
	* @return
	* @throws SystemException
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsCompliance getStandardsComplianceByStdIdChainCodeCountryCode(
		long stdId, java.lang.String chainCode, java.lang.String countryCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsComplianceLocalService.getStandardsComplianceByStdIdChainCodeCountryCode(stdId,
			chainCode, countryCode);
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsCompliance createStandardsCompliance()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsComplianceLocalService.createStandardsCompliance();
	}

	@Override
	public void saveStandardsCompliance(
		com.ihg.brandstandards.db.model.StandardsCompliance stdCompliance)
		throws com.liferay.portal.kernel.exception.SystemException {
		_standardsComplianceLocalService.saveStandardsCompliance(stdCompliance);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public StandardsComplianceLocalService getWrappedStandardsComplianceLocalService() {
		return _standardsComplianceLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedStandardsComplianceLocalService(
		StandardsComplianceLocalService standardsComplianceLocalService) {
		_standardsComplianceLocalService = standardsComplianceLocalService;
	}

	@Override
	public StandardsComplianceLocalService getWrappedService() {
		return _standardsComplianceLocalService;
	}

	@Override
	public void setWrappedService(
		StandardsComplianceLocalService standardsComplianceLocalService) {
		_standardsComplianceLocalService = standardsComplianceLocalService;
	}

	private StandardsComplianceLocalService _standardsComplianceLocalService;
}