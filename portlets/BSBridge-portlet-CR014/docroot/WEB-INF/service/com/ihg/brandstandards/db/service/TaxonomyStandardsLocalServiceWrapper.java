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
 * Provides a wrapper for {@link TaxonomyStandardsLocalService}.
 *
 * @author Mummanedi
 * @see TaxonomyStandardsLocalService
 * @generated
 */
public class TaxonomyStandardsLocalServiceWrapper
	implements TaxonomyStandardsLocalService,
		ServiceWrapper<TaxonomyStandardsLocalService> {
	public TaxonomyStandardsLocalServiceWrapper(
		TaxonomyStandardsLocalService taxonomyStandardsLocalService) {
		_taxonomyStandardsLocalService = taxonomyStandardsLocalService;
	}

	/**
	* Adds the taxonomy standards to the database. Also notifies the appropriate model listeners.
	*
	* @param taxonomyStandards the taxonomy standards
	* @return the taxonomy standards that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.TaxonomyStandards addTaxonomyStandards(
		com.ihg.brandstandards.db.model.TaxonomyStandards taxonomyStandards)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyStandardsLocalService.addTaxonomyStandards(taxonomyStandards);
	}

	/**
	* Creates a new taxonomy standards with the primary key. Does not add the taxonomy standards to the database.
	*
	* @param stdId the primary key for the new taxonomy standards
	* @return the new taxonomy standards
	*/
	@Override
	public com.ihg.brandstandards.db.model.TaxonomyStandards createTaxonomyStandards(
		long stdId) {
		return _taxonomyStandardsLocalService.createTaxonomyStandards(stdId);
	}

	/**
	* Deletes the taxonomy standards with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stdId the primary key of the taxonomy standards
	* @return the taxonomy standards that was removed
	* @throws PortalException if a taxonomy standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.TaxonomyStandards deleteTaxonomyStandards(
		long stdId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyStandardsLocalService.deleteTaxonomyStandards(stdId);
	}

	/**
	* Deletes the taxonomy standards from the database. Also notifies the appropriate model listeners.
	*
	* @param taxonomyStandards the taxonomy standards
	* @return the taxonomy standards that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.TaxonomyStandards deleteTaxonomyStandards(
		com.ihg.brandstandards.db.model.TaxonomyStandards taxonomyStandards)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyStandardsLocalService.deleteTaxonomyStandards(taxonomyStandards);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _taxonomyStandardsLocalService.dynamicQuery();
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
		return _taxonomyStandardsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _taxonomyStandardsLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _taxonomyStandardsLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _taxonomyStandardsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _taxonomyStandardsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.TaxonomyStandards fetchTaxonomyStandards(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyStandardsLocalService.fetchTaxonomyStandards(stdId);
	}

	/**
	* Returns the taxonomy standards with the primary key.
	*
	* @param stdId the primary key of the taxonomy standards
	* @return the taxonomy standards
	* @throws PortalException if a taxonomy standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.TaxonomyStandards getTaxonomyStandards(
		long stdId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyStandardsLocalService.getTaxonomyStandards(stdId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyStandardsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the taxonomy standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of taxonomy standardses
	* @param end the upper bound of the range of taxonomy standardses (not inclusive)
	* @return the range of taxonomy standardses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.TaxonomyStandards> getTaxonomyStandardses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyStandardsLocalService.getTaxonomyStandardses(start, end);
	}

	/**
	* Returns the number of taxonomy standardses.
	*
	* @return the number of taxonomy standardses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTaxonomyStandardsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyStandardsLocalService.getTaxonomyStandardsesCount();
	}

	/**
	* Updates the taxonomy standards in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param taxonomyStandards the taxonomy standards
	* @return the taxonomy standards that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.TaxonomyStandards updateTaxonomyStandards(
		com.ihg.brandstandards.db.model.TaxonomyStandards taxonomyStandards)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyStandardsLocalService.updateTaxonomyStandards(taxonomyStandards);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _taxonomyStandardsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_taxonomyStandardsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _taxonomyStandardsLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void clearCache() {
		_taxonomyStandardsLocalService.clearCache();
	}

	@Override
	public com.ihg.brandstandards.db.model.TaxonomyStandards getTaxonomyStandardsObject() {
		return _taxonomyStandardsLocalService.getTaxonomyStandardsObject();
	}

	@Override
	public com.ihg.brandstandards.db.model.TaxonomyStandards getTaxonomyStandardsByStdId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyStandardsLocalService.getTaxonomyStandardsByStdId(stdId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TaxonomyStandardsLocalService getWrappedTaxonomyStandardsLocalService() {
		return _taxonomyStandardsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTaxonomyStandardsLocalService(
		TaxonomyStandardsLocalService taxonomyStandardsLocalService) {
		_taxonomyStandardsLocalService = taxonomyStandardsLocalService;
	}

	@Override
	public TaxonomyStandardsLocalService getWrappedService() {
		return _taxonomyStandardsLocalService;
	}

	@Override
	public void setWrappedService(
		TaxonomyStandardsLocalService taxonomyStandardsLocalService) {
		_taxonomyStandardsLocalService = taxonomyStandardsLocalService;
	}

	private TaxonomyStandardsLocalService _taxonomyStandardsLocalService;
}