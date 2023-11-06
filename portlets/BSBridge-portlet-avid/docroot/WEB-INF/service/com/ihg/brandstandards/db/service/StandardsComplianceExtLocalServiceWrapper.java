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
 * Provides a wrapper for {@link StandardsComplianceExtLocalService}.
 *
 * @author Mummanedi
 * @see StandardsComplianceExtLocalService
 * @generated
 */
public class StandardsComplianceExtLocalServiceWrapper
	implements StandardsComplianceExtLocalService,
		ServiceWrapper<StandardsComplianceExtLocalService> {
	public StandardsComplianceExtLocalServiceWrapper(
		StandardsComplianceExtLocalService standardsComplianceExtLocalService) {
		_standardsComplianceExtLocalService = standardsComplianceExtLocalService;
	}

	/**
	* Adds the standards compliance ext to the database. Also notifies the appropriate model listeners.
	*
	* @param standardsComplianceExt the standards compliance ext
	* @return the standards compliance ext that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsComplianceExt addStandardsComplianceExt(
		com.ihg.brandstandards.db.model.StandardsComplianceExt standardsComplianceExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsComplianceExtLocalService.addStandardsComplianceExt(standardsComplianceExt);
	}

	/**
	* Creates a new standards compliance ext with the primary key. Does not add the standards compliance ext to the database.
	*
	* @param stdComplianceId the primary key for the new standards compliance ext
	* @return the new standards compliance ext
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsComplianceExt createStandardsComplianceExt(
		long stdComplianceId) {
		return _standardsComplianceExtLocalService.createStandardsComplianceExt(stdComplianceId);
	}

	/**
	* Deletes the standards compliance ext with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stdComplianceId the primary key of the standards compliance ext
	* @return the standards compliance ext that was removed
	* @throws PortalException if a standards compliance ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsComplianceExt deleteStandardsComplianceExt(
		long stdComplianceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsComplianceExtLocalService.deleteStandardsComplianceExt(stdComplianceId);
	}

	/**
	* Deletes the standards compliance ext from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsComplianceExt the standards compliance ext
	* @return the standards compliance ext that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsComplianceExt deleteStandardsComplianceExt(
		com.ihg.brandstandards.db.model.StandardsComplianceExt standardsComplianceExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsComplianceExtLocalService.deleteStandardsComplianceExt(standardsComplianceExt);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _standardsComplianceExtLocalService.dynamicQuery();
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
		return _standardsComplianceExtLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsComplianceExtLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsComplianceExtLocalService.dynamicQuery(dynamicQuery,
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
		return _standardsComplianceExtLocalService.dynamicQueryCount(dynamicQuery);
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
		return _standardsComplianceExtLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsComplianceExt fetchStandardsComplianceExt(
		long stdComplianceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsComplianceExtLocalService.fetchStandardsComplianceExt(stdComplianceId);
	}

	/**
	* Returns the standards compliance ext with the primary key.
	*
	* @param stdComplianceId the primary key of the standards compliance ext
	* @return the standards compliance ext
	* @throws PortalException if a standards compliance ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsComplianceExt getStandardsComplianceExt(
		long stdComplianceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsComplianceExtLocalService.getStandardsComplianceExt(stdComplianceId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsComplianceExtLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsComplianceExt> getStandardsComplianceExts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsComplianceExtLocalService.getStandardsComplianceExts(start,
			end);
	}

	/**
	* Returns the number of standards compliance exts.
	*
	* @return the number of standards compliance exts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getStandardsComplianceExtsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsComplianceExtLocalService.getStandardsComplianceExtsCount();
	}

	/**
	* Updates the standards compliance ext in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param standardsComplianceExt the standards compliance ext
	* @return the standards compliance ext that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsComplianceExt updateStandardsComplianceExt(
		com.ihg.brandstandards.db.model.StandardsComplianceExt standardsComplianceExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsComplianceExtLocalService.updateStandardsComplianceExt(standardsComplianceExt);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _standardsComplianceExtLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_standardsComplianceExtLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _standardsComplianceExtLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void clearCache() {
		_standardsComplianceExtLocalService.clearCache();
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsComplianceExt> getComplianceByRegion(
		java.lang.String query, long stdId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsComplianceExtLocalService.getComplianceByRegion(query,
			stdId, chainCode);
	}

	@Override
	public java.util.List<java.lang.Object> getRegionStatus(long stdId,
		java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsComplianceExtLocalService.getRegionStatus(stdId,
			chainCode);
	}

	@Override
	public java.util.List<java.lang.Object> getRegionCmplyExprCount(
		long stdId, java.lang.String chainCd, java.lang.String rgnName,
		java.lang.String cmply_expr_value, java.lang.String rule_cd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsComplianceExtLocalService.getRegionCmplyExprCount(stdId,
			chainCd, rgnName, cmply_expr_value, rule_cd);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public StandardsComplianceExtLocalService getWrappedStandardsComplianceExtLocalService() {
		return _standardsComplianceExtLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedStandardsComplianceExtLocalService(
		StandardsComplianceExtLocalService standardsComplianceExtLocalService) {
		_standardsComplianceExtLocalService = standardsComplianceExtLocalService;
	}

	@Override
	public StandardsComplianceExtLocalService getWrappedService() {
		return _standardsComplianceExtLocalService;
	}

	@Override
	public void setWrappedService(
		StandardsComplianceExtLocalService standardsComplianceExtLocalService) {
		_standardsComplianceExtLocalService = standardsComplianceExtLocalService;
	}

	private StandardsComplianceExtLocalService _standardsComplianceExtLocalService;
}