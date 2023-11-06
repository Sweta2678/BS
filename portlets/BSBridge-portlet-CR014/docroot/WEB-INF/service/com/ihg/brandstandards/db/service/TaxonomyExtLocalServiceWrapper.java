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
 * Provides a wrapper for {@link TaxonomyExtLocalService}.
 *
 * @author Mummanedi
 * @see TaxonomyExtLocalService
 * @generated
 */
public class TaxonomyExtLocalServiceWrapper implements TaxonomyExtLocalService,
	ServiceWrapper<TaxonomyExtLocalService> {
	public TaxonomyExtLocalServiceWrapper(
		TaxonomyExtLocalService taxonomyExtLocalService) {
		_taxonomyExtLocalService = taxonomyExtLocalService;
	}

	/**
	* Adds the Custom Query mapping to create index path. to the database. Also notifies the appropriate model listeners.
	*
	* @param taxonomyExt the Custom Query mapping to create index path.
	* @return the Custom Query mapping to create index path. that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.TaxonomyExt addTaxonomyExt(
		com.ihg.brandstandards.db.model.TaxonomyExt taxonomyExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyExtLocalService.addTaxonomyExt(taxonomyExt);
	}

	/**
	* Creates a new Custom Query mapping to create index path. with the primary key. Does not add the Custom Query mapping to create index path. to the database.
	*
	* @param taxId the primary key for the new Custom Query mapping to create index path.
	* @return the new Custom Query mapping to create index path.
	*/
	@Override
	public com.ihg.brandstandards.db.model.TaxonomyExt createTaxonomyExt(
		long taxId) {
		return _taxonomyExtLocalService.createTaxonomyExt(taxId);
	}

	/**
	* Deletes the Custom Query mapping to create index path. with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taxId the primary key of the Custom Query mapping to create index path.
	* @return the Custom Query mapping to create index path. that was removed
	* @throws PortalException if a Custom Query mapping to create index path. with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.TaxonomyExt deleteTaxonomyExt(
		long taxId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyExtLocalService.deleteTaxonomyExt(taxId);
	}

	/**
	* Deletes the Custom Query mapping to create index path. from the database. Also notifies the appropriate model listeners.
	*
	* @param taxonomyExt the Custom Query mapping to create index path.
	* @return the Custom Query mapping to create index path. that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.TaxonomyExt deleteTaxonomyExt(
		com.ihg.brandstandards.db.model.TaxonomyExt taxonomyExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyExtLocalService.deleteTaxonomyExt(taxonomyExt);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _taxonomyExtLocalService.dynamicQuery();
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
		return _taxonomyExtLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _taxonomyExtLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _taxonomyExtLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _taxonomyExtLocalService.dynamicQueryCount(dynamicQuery);
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
		return _taxonomyExtLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.TaxonomyExt fetchTaxonomyExt(
		long taxId) throws com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyExtLocalService.fetchTaxonomyExt(taxId);
	}

	/**
	* Returns the Custom Query mapping to create index path. with the primary key.
	*
	* @param taxId the primary key of the Custom Query mapping to create index path.
	* @return the Custom Query mapping to create index path.
	* @throws PortalException if a Custom Query mapping to create index path. with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.TaxonomyExt getTaxonomyExt(
		long taxId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyExtLocalService.getTaxonomyExt(taxId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyExtLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the Custom Query mapping to create index path.s.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Custom Query mapping to create index path.s
	* @param end the upper bound of the range of Custom Query mapping to create index path.s (not inclusive)
	* @return the range of Custom Query mapping to create index path.s
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.TaxonomyExt> getTaxonomyExts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyExtLocalService.getTaxonomyExts(start, end);
	}

	/**
	* Returns the number of Custom Query mapping to create index path.s.
	*
	* @return the number of Custom Query mapping to create index path.s
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTaxonomyExtsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyExtLocalService.getTaxonomyExtsCount();
	}

	/**
	* Updates the Custom Query mapping to create index path. in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param taxonomyExt the Custom Query mapping to create index path.
	* @return the Custom Query mapping to create index path. that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.TaxonomyExt updateTaxonomyExt(
		com.ihg.brandstandards.db.model.TaxonomyExt taxonomyExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyExtLocalService.updateTaxonomyExt(taxonomyExt);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _taxonomyExtLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_taxonomyExtLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _taxonomyExtLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void clearCache() {
		_taxonomyExtLocalService.clearCache();
	}

	/**
	* Fetch all Indexes for specified Standard from database.
	*
	* @param standardsId - Standard Id
	* @return - Index path
	* @throws SystemException - exception
	*/
	@Override
	public java.lang.String getIndexPathByStandardId(long standardsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyExtLocalService.getIndexPathByStandardId(standardsId);
	}

	/**
	* Fetch all Indexes from database.
	*
	* @return - list of Indexes
	* @throws SystemException - exception
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.TaxonomyExt> getAllIndexes()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyExtLocalService.getAllIndexes();
	}

	/**
	* Fetch all Indexes from database order by Index Id.
	*
	* @return - list of Indexes
	* @throws SystemException - exception
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.TaxonomyExt> getAllIndexesOdrById()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyExtLocalService.getAllIndexesOdrById();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TaxonomyExtLocalService getWrappedTaxonomyExtLocalService() {
		return _taxonomyExtLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTaxonomyExtLocalService(
		TaxonomyExtLocalService taxonomyExtLocalService) {
		_taxonomyExtLocalService = taxonomyExtLocalService;
	}

	@Override
	public TaxonomyExtLocalService getWrappedService() {
		return _taxonomyExtLocalService;
	}

	@Override
	public void setWrappedService(
		TaxonomyExtLocalService taxonomyExtLocalService) {
		_taxonomyExtLocalService = taxonomyExtLocalService;
	}

	private TaxonomyExtLocalService _taxonomyExtLocalService;
}