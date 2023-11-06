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
 * Provides a wrapper for {@link GEMMeasurementTypeLocalService}.
 *
 * @author Mummanedi
 * @see GEMMeasurementTypeLocalService
 * @generated
 */
public class GEMMeasurementTypeLocalServiceWrapper
	implements GEMMeasurementTypeLocalService,
		ServiceWrapper<GEMMeasurementTypeLocalService> {
	public GEMMeasurementTypeLocalServiceWrapper(
		GEMMeasurementTypeLocalService gemMeasurementTypeLocalService) {
		_gemMeasurementTypeLocalService = gemMeasurementTypeLocalService;
	}

	/**
	* Adds the g e m measurement type to the database. Also notifies the appropriate model listeners.
	*
	* @param gemMeasurementType the g e m measurement type
	* @return the g e m measurement type that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMMeasurementType addGEMMeasurementType(
		com.ihg.brandstandards.db.model.GEMMeasurementType gemMeasurementType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemMeasurementTypeLocalService.addGEMMeasurementType(gemMeasurementType);
	}

	/**
	* Creates a new g e m measurement type with the primary key. Does not add the g e m measurement type to the database.
	*
	* @param measurementType the primary key for the new g e m measurement type
	* @return the new g e m measurement type
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMMeasurementType createGEMMeasurementType(
		java.lang.String measurementType) {
		return _gemMeasurementTypeLocalService.createGEMMeasurementType(measurementType);
	}

	/**
	* Deletes the g e m measurement type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param measurementType the primary key of the g e m measurement type
	* @return the g e m measurement type that was removed
	* @throws PortalException if a g e m measurement type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMMeasurementType deleteGEMMeasurementType(
		java.lang.String measurementType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gemMeasurementTypeLocalService.deleteGEMMeasurementType(measurementType);
	}

	/**
	* Deletes the g e m measurement type from the database. Also notifies the appropriate model listeners.
	*
	* @param gemMeasurementType the g e m measurement type
	* @return the g e m measurement type that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMMeasurementType deleteGEMMeasurementType(
		com.ihg.brandstandards.db.model.GEMMeasurementType gemMeasurementType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemMeasurementTypeLocalService.deleteGEMMeasurementType(gemMeasurementType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _gemMeasurementTypeLocalService.dynamicQuery();
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
		return _gemMeasurementTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _gemMeasurementTypeLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _gemMeasurementTypeLocalService.dynamicQuery(dynamicQuery,
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
		return _gemMeasurementTypeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _gemMeasurementTypeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMMeasurementType fetchGEMMeasurementType(
		java.lang.String measurementType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemMeasurementTypeLocalService.fetchGEMMeasurementType(measurementType);
	}

	/**
	* Returns the g e m measurement type with the primary key.
	*
	* @param measurementType the primary key of the g e m measurement type
	* @return the g e m measurement type
	* @throws PortalException if a g e m measurement type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMMeasurementType getGEMMeasurementType(
		java.lang.String measurementType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gemMeasurementTypeLocalService.getGEMMeasurementType(measurementType);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gemMeasurementTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the g e m measurement types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m measurement types
	* @param end the upper bound of the range of g e m measurement types (not inclusive)
	* @return the range of g e m measurement types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.GEMMeasurementType> getGEMMeasurementTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemMeasurementTypeLocalService.getGEMMeasurementTypes(start, end);
	}

	/**
	* Returns the number of g e m measurement types.
	*
	* @return the number of g e m measurement types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGEMMeasurementTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemMeasurementTypeLocalService.getGEMMeasurementTypesCount();
	}

	/**
	* Updates the g e m measurement type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param gemMeasurementType the g e m measurement type
	* @return the g e m measurement type that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMMeasurementType updateGEMMeasurementType(
		com.ihg.brandstandards.db.model.GEMMeasurementType gemMeasurementType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemMeasurementTypeLocalService.updateGEMMeasurementType(gemMeasurementType);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _gemMeasurementTypeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_gemMeasurementTypeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _gemMeasurementTypeLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void clearCache() {
		_gemMeasurementTypeLocalService.clearCache();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GEMMeasurementTypeLocalService getWrappedGEMMeasurementTypeLocalService() {
		return _gemMeasurementTypeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGEMMeasurementTypeLocalService(
		GEMMeasurementTypeLocalService gemMeasurementTypeLocalService) {
		_gemMeasurementTypeLocalService = gemMeasurementTypeLocalService;
	}

	@Override
	public GEMMeasurementTypeLocalService getWrappedService() {
		return _gemMeasurementTypeLocalService;
	}

	@Override
	public void setWrappedService(
		GEMMeasurementTypeLocalService gemMeasurementTypeLocalService) {
		_gemMeasurementTypeLocalService = gemMeasurementTypeLocalService;
	}

	private GEMMeasurementTypeLocalService _gemMeasurementTypeLocalService;
}