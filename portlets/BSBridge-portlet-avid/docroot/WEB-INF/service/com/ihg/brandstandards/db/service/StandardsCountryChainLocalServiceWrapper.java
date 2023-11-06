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
 * Provides a wrapper for {@link StandardsCountryChainLocalService}.
 *
 * @author Mummanedi
 * @see StandardsCountryChainLocalService
 * @generated
 */
public class StandardsCountryChainLocalServiceWrapper
	implements StandardsCountryChainLocalService,
		ServiceWrapper<StandardsCountryChainLocalService> {
	public StandardsCountryChainLocalServiceWrapper(
		StandardsCountryChainLocalService standardsCountryChainLocalService) {
		_standardsCountryChainLocalService = standardsCountryChainLocalService;
	}

	/**
	* Adds the standards country chain to the database. Also notifies the appropriate model listeners.
	*
	* @param standardsCountryChain the standards country chain
	* @return the standards country chain that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsCountryChain addStandardsCountryChain(
		com.ihg.brandstandards.db.model.StandardsCountryChain standardsCountryChain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsCountryChainLocalService.addStandardsCountryChain(standardsCountryChain);
	}

	/**
	* Creates a new standards country chain with the primary key. Does not add the standards country chain to the database.
	*
	* @param standardsCountryChainPK the primary key for the new standards country chain
	* @return the new standards country chain
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsCountryChain createStandardsCountryChain(
		com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK standardsCountryChainPK) {
		return _standardsCountryChainLocalService.createStandardsCountryChain(standardsCountryChainPK);
	}

	/**
	* Deletes the standards country chain with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsCountryChainPK the primary key of the standards country chain
	* @return the standards country chain that was removed
	* @throws PortalException if a standards country chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsCountryChain deleteStandardsCountryChain(
		com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK standardsCountryChainPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsCountryChainLocalService.deleteStandardsCountryChain(standardsCountryChainPK);
	}

	/**
	* Deletes the standards country chain from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsCountryChain the standards country chain
	* @return the standards country chain that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsCountryChain deleteStandardsCountryChain(
		com.ihg.brandstandards.db.model.StandardsCountryChain standardsCountryChain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsCountryChainLocalService.deleteStandardsCountryChain(standardsCountryChain);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _standardsCountryChainLocalService.dynamicQuery();
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
		return _standardsCountryChainLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _standardsCountryChainLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _standardsCountryChainLocalService.dynamicQuery(dynamicQuery,
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
		return _standardsCountryChainLocalService.dynamicQueryCount(dynamicQuery);
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
		return _standardsCountryChainLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsCountryChain fetchStandardsCountryChain(
		com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK standardsCountryChainPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsCountryChainLocalService.fetchStandardsCountryChain(standardsCountryChainPK);
	}

	/**
	* Returns the standards country chain with the primary key.
	*
	* @param standardsCountryChainPK the primary key of the standards country chain
	* @return the standards country chain
	* @throws PortalException if a standards country chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsCountryChain getStandardsCountryChain(
		com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK standardsCountryChainPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsCountryChainLocalService.getStandardsCountryChain(standardsCountryChainPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsCountryChainLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the standards country chains.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards country chains
	* @param end the upper bound of the range of standards country chains (not inclusive)
	* @return the range of standards country chains
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> getStandardsCountryChains(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsCountryChainLocalService.getStandardsCountryChains(start,
			end);
	}

	/**
	* Returns the number of standards country chains.
	*
	* @return the number of standards country chains
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getStandardsCountryChainsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsCountryChainLocalService.getStandardsCountryChainsCount();
	}

	/**
	* Updates the standards country chain in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param standardsCountryChain the standards country chain
	* @return the standards country chain that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsCountryChain updateStandardsCountryChain(
		com.ihg.brandstandards.db.model.StandardsCountryChain standardsCountryChain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsCountryChainLocalService.updateStandardsCountryChain(standardsCountryChain);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _standardsCountryChainLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_standardsCountryChainLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _standardsCountryChainLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void clearCache() {
		_standardsCountryChainLocalService.clearCache();
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> getStandardsCountryChain(
		long stdId, java.lang.String chainCode, java.util.Date compDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsCountryChainLocalService.getStandardsCountryChain(stdId,
			chainCode, compDate);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> getStandardsCountryChains(
		long stdId, java.lang.String chainCode, java.util.Date startDate) {
		return _standardsCountryChainLocalService.getStandardsCountryChains(stdId,
			chainCode, startDate);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> getStandardsChainRegion(
		long stdId, java.lang.String chainCode, java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsCountryChainLocalService.getStandardsChainRegion(stdId,
			chainCode, regionCode);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountryChain> getStandardsChain(
		long stdId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsCountryChainLocalService.getStandardsChain(stdId,
			chainCode);
	}

	/**
	* Update Compliance Deadline for specified countries or whole region.
	*
	* @param stdId standard id
	* @param compDatesMap country code / compliance deadline map
	* @param brandCode brand code
	* @param regionCode region code
	*/
	@Override
	public java.lang.String updateComplianceDeadline(java.lang.Long stdId,
		java.util.Map<java.lang.String, java.util.Date> compDatesMap,
		java.lang.String brandCode, java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsCountryChainLocalService.updateComplianceDeadline(stdId,
			compDatesMap, brandCode, regionCode);
	}

	@Override
	public java.lang.String getDefaultComplianceDate(long stdId,
		java.lang.String chainCD, java.lang.String regionCd) {
		return _standardsCountryChainLocalService.getDefaultComplianceDate(stdId,
			chainCD, regionCd);
	}

	@Override
	public java.lang.String getDefaulExpiryDate(long stdId,
		java.lang.String chainCD, java.lang.String regionCd) {
		return _standardsCountryChainLocalService.getDefaulExpiryDate(stdId,
			chainCD, regionCd);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public StandardsCountryChainLocalService getWrappedStandardsCountryChainLocalService() {
		return _standardsCountryChainLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedStandardsCountryChainLocalService(
		StandardsCountryChainLocalService standardsCountryChainLocalService) {
		_standardsCountryChainLocalService = standardsCountryChainLocalService;
	}

	@Override
	public StandardsCountryChainLocalService getWrappedService() {
		return _standardsCountryChainLocalService;
	}

	@Override
	public void setWrappedService(
		StandardsCountryChainLocalService standardsCountryChainLocalService) {
		_standardsCountryChainLocalService = standardsCountryChainLocalService;
	}

	private StandardsCountryChainLocalService _standardsCountryChainLocalService;
}