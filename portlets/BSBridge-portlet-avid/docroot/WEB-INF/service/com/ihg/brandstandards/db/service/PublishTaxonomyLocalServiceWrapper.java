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
 * Provides a wrapper for {@link PublishTaxonomyLocalService}.
 *
 * @author Mummanedi
 * @see PublishTaxonomyLocalService
 * @generated
 */
public class PublishTaxonomyLocalServiceWrapper
	implements PublishTaxonomyLocalService,
		ServiceWrapper<PublishTaxonomyLocalService> {
	public PublishTaxonomyLocalServiceWrapper(
		PublishTaxonomyLocalService publishTaxonomyLocalService) {
		_publishTaxonomyLocalService = publishTaxonomyLocalService;
	}

	/**
	* Adds the publish taxonomy to the database. Also notifies the appropriate model listeners.
	*
	* @param publishTaxonomy the publish taxonomy
	* @return the publish taxonomy that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishTaxonomy addPublishTaxonomy(
		com.ihg.brandstandards.db.model.PublishTaxonomy publishTaxonomy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishTaxonomyLocalService.addPublishTaxonomy(publishTaxonomy);
	}

	/**
	* Creates a new publish taxonomy with the primary key. Does not add the publish taxonomy to the database.
	*
	* @param publishTaxId the primary key for the new publish taxonomy
	* @return the new publish taxonomy
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishTaxonomy createPublishTaxonomy(
		long publishTaxId) {
		return _publishTaxonomyLocalService.createPublishTaxonomy(publishTaxId);
	}

	/**
	* Deletes the publish taxonomy with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param publishTaxId the primary key of the publish taxonomy
	* @return the publish taxonomy that was removed
	* @throws PortalException if a publish taxonomy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishTaxonomy deletePublishTaxonomy(
		long publishTaxId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishTaxonomyLocalService.deletePublishTaxonomy(publishTaxId);
	}

	/**
	* Deletes the publish taxonomy from the database. Also notifies the appropriate model listeners.
	*
	* @param publishTaxonomy the publish taxonomy
	* @return the publish taxonomy that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishTaxonomy deletePublishTaxonomy(
		com.ihg.brandstandards.db.model.PublishTaxonomy publishTaxonomy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishTaxonomyLocalService.deletePublishTaxonomy(publishTaxonomy);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _publishTaxonomyLocalService.dynamicQuery();
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
		return _publishTaxonomyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _publishTaxonomyLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _publishTaxonomyLocalService.dynamicQuery(dynamicQuery, start,
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
		return _publishTaxonomyLocalService.dynamicQueryCount(dynamicQuery);
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
		return _publishTaxonomyLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.PublishTaxonomy fetchPublishTaxonomy(
		long publishTaxId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishTaxonomyLocalService.fetchPublishTaxonomy(publishTaxId);
	}

	/**
	* Returns the publish taxonomy with the primary key.
	*
	* @param publishTaxId the primary key of the publish taxonomy
	* @return the publish taxonomy
	* @throws PortalException if a publish taxonomy with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishTaxonomy getPublishTaxonomy(
		long publishTaxId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishTaxonomyLocalService.getPublishTaxonomy(publishTaxId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishTaxonomyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the publish taxonomies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of publish taxonomies
	* @param end the upper bound of the range of publish taxonomies (not inclusive)
	* @return the range of publish taxonomies
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.PublishTaxonomy> getPublishTaxonomies(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishTaxonomyLocalService.getPublishTaxonomies(start, end);
	}

	/**
	* Returns the number of publish taxonomies.
	*
	* @return the number of publish taxonomies
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPublishTaxonomiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishTaxonomyLocalService.getPublishTaxonomiesCount();
	}

	/**
	* Updates the publish taxonomy in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param publishTaxonomy the publish taxonomy
	* @return the publish taxonomy that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishTaxonomy updatePublishTaxonomy(
		com.ihg.brandstandards.db.model.PublishTaxonomy publishTaxonomy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishTaxonomyLocalService.updatePublishTaxonomy(publishTaxonomy);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _publishTaxonomyLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_publishTaxonomyLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _publishTaxonomyLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void clearCache() {
		_publishTaxonomyLocalService.clearCache();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PublishTaxonomyLocalService getWrappedPublishTaxonomyLocalService() {
		return _publishTaxonomyLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPublishTaxonomyLocalService(
		PublishTaxonomyLocalService publishTaxonomyLocalService) {
		_publishTaxonomyLocalService = publishTaxonomyLocalService;
	}

	@Override
	public PublishTaxonomyLocalService getWrappedService() {
		return _publishTaxonomyLocalService;
	}

	@Override
	public void setWrappedService(
		PublishTaxonomyLocalService publishTaxonomyLocalService) {
		_publishTaxonomyLocalService = publishTaxonomyLocalService;
	}

	private PublishTaxonomyLocalService _publishTaxonomyLocalService;
}