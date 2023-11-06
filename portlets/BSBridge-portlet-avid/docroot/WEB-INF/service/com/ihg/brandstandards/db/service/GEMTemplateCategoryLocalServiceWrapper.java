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
 * Provides a wrapper for {@link GEMTemplateCategoryLocalService}.
 *
 * @author Mummanedi
 * @see GEMTemplateCategoryLocalService
 * @generated
 */
public class GEMTemplateCategoryLocalServiceWrapper
	implements GEMTemplateCategoryLocalService,
		ServiceWrapper<GEMTemplateCategoryLocalService> {
	public GEMTemplateCategoryLocalServiceWrapper(
		GEMTemplateCategoryLocalService gemTemplateCategoryLocalService) {
		_gemTemplateCategoryLocalService = gemTemplateCategoryLocalService;
	}

	/**
	* Adds the g e m template category to the database. Also notifies the appropriate model listeners.
	*
	* @param gemTemplateCategory the g e m template category
	* @return the g e m template category that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMTemplateCategory addGEMTemplateCategory(
		com.ihg.brandstandards.db.model.GEMTemplateCategory gemTemplateCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemTemplateCategoryLocalService.addGEMTemplateCategory(gemTemplateCategory);
	}

	/**
	* Creates a new g e m template category with the primary key. Does not add the g e m template category to the database.
	*
	* @param templateCatgyId the primary key for the new g e m template category
	* @return the new g e m template category
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMTemplateCategory createGEMTemplateCategory(
		long templateCatgyId) {
		return _gemTemplateCategoryLocalService.createGEMTemplateCategory(templateCatgyId);
	}

	/**
	* Deletes the g e m template category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param templateCatgyId the primary key of the g e m template category
	* @return the g e m template category that was removed
	* @throws PortalException if a g e m template category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMTemplateCategory deleteGEMTemplateCategory(
		long templateCatgyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gemTemplateCategoryLocalService.deleteGEMTemplateCategory(templateCatgyId);
	}

	/**
	* Deletes the g e m template category from the database. Also notifies the appropriate model listeners.
	*
	* @param gemTemplateCategory the g e m template category
	* @return the g e m template category that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMTemplateCategory deleteGEMTemplateCategory(
		com.ihg.brandstandards.db.model.GEMTemplateCategory gemTemplateCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemTemplateCategoryLocalService.deleteGEMTemplateCategory(gemTemplateCategory);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _gemTemplateCategoryLocalService.dynamicQuery();
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
		return _gemTemplateCategoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _gemTemplateCategoryLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _gemTemplateCategoryLocalService.dynamicQuery(dynamicQuery,
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
		return _gemTemplateCategoryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _gemTemplateCategoryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMTemplateCategory fetchGEMTemplateCategory(
		long templateCatgyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemTemplateCategoryLocalService.fetchGEMTemplateCategory(templateCatgyId);
	}

	/**
	* Returns the g e m template category with the primary key.
	*
	* @param templateCatgyId the primary key of the g e m template category
	* @return the g e m template category
	* @throws PortalException if a g e m template category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMTemplateCategory getGEMTemplateCategory(
		long templateCatgyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gemTemplateCategoryLocalService.getGEMTemplateCategory(templateCatgyId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gemTemplateCategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the g e m template categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m template categories
	* @param end the upper bound of the range of g e m template categories (not inclusive)
	* @return the range of g e m template categories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplateCategory> getGEMTemplateCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemTemplateCategoryLocalService.getGEMTemplateCategories(start,
			end);
	}

	/**
	* Returns the number of g e m template categories.
	*
	* @return the number of g e m template categories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGEMTemplateCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemTemplateCategoryLocalService.getGEMTemplateCategoriesCount();
	}

	/**
	* Updates the g e m template category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param gemTemplateCategory the g e m template category
	* @return the g e m template category that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMTemplateCategory updateGEMTemplateCategory(
		com.ihg.brandstandards.db.model.GEMTemplateCategory gemTemplateCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemTemplateCategoryLocalService.updateGEMTemplateCategory(gemTemplateCategory);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _gemTemplateCategoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_gemTemplateCategoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _gemTemplateCategoryLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void clearCache() {
		_gemTemplateCategoryLocalService.clearCache();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GEMTemplateCategoryLocalService getWrappedGEMTemplateCategoryLocalService() {
		return _gemTemplateCategoryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGEMTemplateCategoryLocalService(
		GEMTemplateCategoryLocalService gemTemplateCategoryLocalService) {
		_gemTemplateCategoryLocalService = gemTemplateCategoryLocalService;
	}

	@Override
	public GEMTemplateCategoryLocalService getWrappedService() {
		return _gemTemplateCategoryLocalService;
	}

	@Override
	public void setWrappedService(
		GEMTemplateCategoryLocalService gemTemplateCategoryLocalService) {
		_gemTemplateCategoryLocalService = gemTemplateCategoryLocalService;
	}

	private GEMTemplateCategoryLocalService _gemTemplateCategoryLocalService;
}