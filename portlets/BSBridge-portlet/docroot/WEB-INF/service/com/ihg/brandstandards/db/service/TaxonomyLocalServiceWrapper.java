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
 * Provides a wrapper for {@link TaxonomyLocalService}.
 *
 * @author Mummanedi
 * @see TaxonomyLocalService
 * @generated
 */
public class TaxonomyLocalServiceWrapper implements TaxonomyLocalService,
	ServiceWrapper<TaxonomyLocalService> {
	public TaxonomyLocalServiceWrapper(
		TaxonomyLocalService taxonomyLocalService) {
		_taxonomyLocalService = taxonomyLocalService;
	}

	/**
	* Adds the taxonomy to the database. Also notifies the appropriate model listeners.
	*
	* @param taxonomy the taxonomy
	* @return the taxonomy that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.Taxonomy addTaxonomy(
		com.ihg.brandstandards.db.model.Taxonomy taxonomy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyLocalService.addTaxonomy(taxonomy);
	}

	/**
	* Creates a new taxonomy with the primary key. Does not add the taxonomy to the database.
	*
	* @param taxId the primary key for the new taxonomy
	* @return the new taxonomy
	*/
	@Override
	public com.ihg.brandstandards.db.model.Taxonomy createTaxonomy(long taxId) {
		return _taxonomyLocalService.createTaxonomy(taxId);
	}

	/**
	* Deletes the taxonomy with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taxId the primary key of the taxonomy
	* @return the taxonomy that was removed
	* @throws PortalException if a taxonomy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.Taxonomy deleteTaxonomy(long taxId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyLocalService.deleteTaxonomy(taxId);
	}

	/**
	* Deletes the taxonomy from the database. Also notifies the appropriate model listeners.
	*
	* @param taxonomy the taxonomy
	* @return the taxonomy that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.Taxonomy deleteTaxonomy(
		com.ihg.brandstandards.db.model.Taxonomy taxonomy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyLocalService.deleteTaxonomy(taxonomy);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _taxonomyLocalService.dynamicQuery();
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
		return _taxonomyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _taxonomyLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _taxonomyLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _taxonomyLocalService.dynamicQueryCount(dynamicQuery);
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
		return _taxonomyLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.Taxonomy fetchTaxonomy(long taxId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyLocalService.fetchTaxonomy(taxId);
	}

	/**
	* Returns the taxonomy with the primary key.
	*
	* @param taxId the primary key of the taxonomy
	* @return the taxonomy
	* @throws PortalException if a taxonomy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.Taxonomy getTaxonomy(long taxId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyLocalService.getTaxonomy(taxId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the taxonomies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of taxonomies
	* @param end the upper bound of the range of taxonomies (not inclusive)
	* @return the range of taxonomies
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Taxonomy> getTaxonomies(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyLocalService.getTaxonomies(start, end);
	}

	/**
	* Returns the number of taxonomies.
	*
	* @return the number of taxonomies
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTaxonomiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyLocalService.getTaxonomiesCount();
	}

	/**
	* Updates the taxonomy in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param taxonomy the taxonomy
	* @return the taxonomy that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.Taxonomy updateTaxonomy(
		com.ihg.brandstandards.db.model.Taxonomy taxonomy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyLocalService.updateTaxonomy(taxonomy);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _taxonomyLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_taxonomyLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _taxonomyLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void clearCache() {
		_taxonomyLocalService.clearCache();
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Taxonomy> getTaxonomiesByCreatorId(
		java.lang.String creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyLocalService.getTaxonomiesByCreatorId(creatorId);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Taxonomy> getTaxonomiesByParentId(
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyLocalService.getTaxonomiesByParentId(parentId);
	}

	@Override
	public com.ihg.brandstandards.db.model.Taxonomy getTaxonomyByTaxId(
		long taxId)
		throws com.ihg.brandstandards.db.NoSuchTaxonomyException,
			com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyLocalService.getTaxonomyByTaxId(taxId);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Taxonomy> getTreeItems()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyLocalService.getTreeItems();
	}

	@Override
	public void updateTaxonomyPosition(
		com.ihg.brandstandards.db.model.Taxonomy taxonomyObj,
		com.ihg.brandstandards.db.model.Taxonomy taxonomyRef, long pos)
		throws com.liferay.portal.kernel.exception.SystemException {
		_taxonomyLocalService.updateTaxonomyPosition(taxonomyObj, taxonomyRef,
			pos);
	}

	@Override
	public int getTaxonomyCountByPid(long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyLocalService.getTaxonomyCountByPid(parentId);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Taxonomy> getTaxonomiesById(
		long Id) throws com.liferay.portal.kernel.exception.SystemException {
		return _taxonomyLocalService.getTaxonomiesById(Id);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TaxonomyLocalService getWrappedTaxonomyLocalService() {
		return _taxonomyLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTaxonomyLocalService(
		TaxonomyLocalService taxonomyLocalService) {
		_taxonomyLocalService = taxonomyLocalService;
	}

	@Override
	public TaxonomyLocalService getWrappedService() {
		return _taxonomyLocalService;
	}

	@Override
	public void setWrappedService(TaxonomyLocalService taxonomyLocalService) {
		_taxonomyLocalService = taxonomyLocalService;
	}

	private TaxonomyLocalService _taxonomyLocalService;
}