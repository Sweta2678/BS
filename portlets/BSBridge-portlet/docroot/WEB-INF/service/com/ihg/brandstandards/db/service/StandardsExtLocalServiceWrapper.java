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
 * Provides a wrapper for {@link StandardsExtLocalService}.
 *
 * @author Mummanedi
 * @see StandardsExtLocalService
 * @generated
 */
public class StandardsExtLocalServiceWrapper implements StandardsExtLocalService,
	ServiceWrapper<StandardsExtLocalService> {
	public StandardsExtLocalServiceWrapper(
		StandardsExtLocalService standardsExtLocalService) {
		_standardsExtLocalService = standardsExtLocalService;
	}

	/**
	* Adds the Custom Query mapping between STD and Taxonomy tables. to the database. Also notifies the appropriate model listeners.
	*
	* @param standardsExt the Custom Query mapping between STD and Taxonomy tables.
	* @return the Custom Query mapping between STD and Taxonomy tables. that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsExt addStandardsExt(
		com.ihg.brandstandards.db.model.StandardsExt standardsExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsExtLocalService.addStandardsExt(standardsExt);
	}

	/**
	* Creates a new Custom Query mapping between STD and Taxonomy tables. with the primary key. Does not add the Custom Query mapping between STD and Taxonomy tables. to the database.
	*
	* @param standardsExtPK the primary key for the new Custom Query mapping between STD and Taxonomy tables.
	* @return the new Custom Query mapping between STD and Taxonomy tables.
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsExt createStandardsExt(
		com.ihg.brandstandards.db.service.persistence.StandardsExtPK standardsExtPK) {
		return _standardsExtLocalService.createStandardsExt(standardsExtPK);
	}

	/**
	* Deletes the Custom Query mapping between STD and Taxonomy tables. with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsExtPK the primary key of the Custom Query mapping between STD and Taxonomy tables.
	* @return the Custom Query mapping between STD and Taxonomy tables. that was removed
	* @throws PortalException if a Custom Query mapping between STD and Taxonomy tables. with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsExt deleteStandardsExt(
		com.ihg.brandstandards.db.service.persistence.StandardsExtPK standardsExtPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsExtLocalService.deleteStandardsExt(standardsExtPK);
	}

	/**
	* Deletes the Custom Query mapping between STD and Taxonomy tables. from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsExt the Custom Query mapping between STD and Taxonomy tables.
	* @return the Custom Query mapping between STD and Taxonomy tables. that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsExt deleteStandardsExt(
		com.ihg.brandstandards.db.model.StandardsExt standardsExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsExtLocalService.deleteStandardsExt(standardsExt);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _standardsExtLocalService.dynamicQuery();
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
		return _standardsExtLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _standardsExtLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _standardsExtLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _standardsExtLocalService.dynamicQueryCount(dynamicQuery);
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
		return _standardsExtLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsExt fetchStandardsExt(
		com.ihg.brandstandards.db.service.persistence.StandardsExtPK standardsExtPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsExtLocalService.fetchStandardsExt(standardsExtPK);
	}

	/**
	* Returns the Custom Query mapping between STD and Taxonomy tables. with the primary key.
	*
	* @param standardsExtPK the primary key of the Custom Query mapping between STD and Taxonomy tables.
	* @return the Custom Query mapping between STD and Taxonomy tables.
	* @throws PortalException if a Custom Query mapping between STD and Taxonomy tables. with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsExt getStandardsExt(
		com.ihg.brandstandards.db.service.persistence.StandardsExtPK standardsExtPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsExtLocalService.getStandardsExt(standardsExtPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsExtLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the Custom Query mapping between STD and Taxonomy tables.s.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Custom Query mapping between STD and Taxonomy tables.s
	* @param end the upper bound of the range of Custom Query mapping between STD and Taxonomy tables.s (not inclusive)
	* @return the range of Custom Query mapping between STD and Taxonomy tables.s
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsExt> getStandardsExts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsExtLocalService.getStandardsExts(start, end);
	}

	/**
	* Returns the number of Custom Query mapping between STD and Taxonomy tables.s.
	*
	* @return the number of Custom Query mapping between STD and Taxonomy tables.s
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getStandardsExtsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsExtLocalService.getStandardsExtsCount();
	}

	/**
	* Updates the Custom Query mapping between STD and Taxonomy tables. in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param standardsExt the Custom Query mapping between STD and Taxonomy tables.
	* @return the Custom Query mapping between STD and Taxonomy tables. that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsExt updateStandardsExt(
		com.ihg.brandstandards.db.model.StandardsExt standardsExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsExtLocalService.updateStandardsExt(standardsExt);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _standardsExtLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_standardsExtLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _standardsExtLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void clearCache() {
		_standardsExtLocalService.clearCache();
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsExt getStandardsExtObject() {
		return _standardsExtLocalService.getStandardsExtObject();
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsExt> getStandards(
		java.util.Map<java.lang.String, ?> criteriaMap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsExtLocalService.getStandards(criteriaMap);
	}

	@Override
	public java.util.List<java.lang.Long> getStandardsByChain(
		java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsExtLocalService.getStandardsByChain(chainCode);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public StandardsExtLocalService getWrappedStandardsExtLocalService() {
		return _standardsExtLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedStandardsExtLocalService(
		StandardsExtLocalService standardsExtLocalService) {
		_standardsExtLocalService = standardsExtLocalService;
	}

	@Override
	public StandardsExtLocalService getWrappedService() {
		return _standardsExtLocalService;
	}

	@Override
	public void setWrappedService(
		StandardsExtLocalService standardsExtLocalService) {
		_standardsExtLocalService = standardsExtLocalService;
	}

	private StandardsExtLocalService _standardsExtLocalService;
}