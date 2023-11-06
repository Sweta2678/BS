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
 * Provides a wrapper for {@link GEMTemplateValuesLocalService}.
 *
 * @author Mummanedi
 * @see GEMTemplateValuesLocalService
 * @generated
 */
public class GEMTemplateValuesLocalServiceWrapper
	implements GEMTemplateValuesLocalService,
		ServiceWrapper<GEMTemplateValuesLocalService> {
	public GEMTemplateValuesLocalServiceWrapper(
		GEMTemplateValuesLocalService gemTemplateValuesLocalService) {
		_gemTemplateValuesLocalService = gemTemplateValuesLocalService;
	}

	/**
	* Adds the g e m template values to the database. Also notifies the appropriate model listeners.
	*
	* @param gemTemplateValues the g e m template values
	* @return the g e m template values that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMTemplateValues addGEMTemplateValues(
		com.ihg.brandstandards.db.model.GEMTemplateValues gemTemplateValues)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemTemplateValuesLocalService.addGEMTemplateValues(gemTemplateValues);
	}

	/**
	* Creates a new g e m template values with the primary key. Does not add the g e m template values to the database.
	*
	* @param valueId the primary key for the new g e m template values
	* @return the new g e m template values
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMTemplateValues createGEMTemplateValues(
		long valueId) {
		return _gemTemplateValuesLocalService.createGEMTemplateValues(valueId);
	}

	/**
	* Deletes the g e m template values with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param valueId the primary key of the g e m template values
	* @return the g e m template values that was removed
	* @throws PortalException if a g e m template values with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMTemplateValues deleteGEMTemplateValues(
		long valueId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gemTemplateValuesLocalService.deleteGEMTemplateValues(valueId);
	}

	/**
	* Deletes the g e m template values from the database. Also notifies the appropriate model listeners.
	*
	* @param gemTemplateValues the g e m template values
	* @return the g e m template values that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMTemplateValues deleteGEMTemplateValues(
		com.ihg.brandstandards.db.model.GEMTemplateValues gemTemplateValues)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemTemplateValuesLocalService.deleteGEMTemplateValues(gemTemplateValues);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _gemTemplateValuesLocalService.dynamicQuery();
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
		return _gemTemplateValuesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateValuesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _gemTemplateValuesLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateValuesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _gemTemplateValuesLocalService.dynamicQuery(dynamicQuery, start,
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
		return _gemTemplateValuesLocalService.dynamicQueryCount(dynamicQuery);
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
		return _gemTemplateValuesLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMTemplateValues fetchGEMTemplateValues(
		long valueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemTemplateValuesLocalService.fetchGEMTemplateValues(valueId);
	}

	/**
	* Returns the g e m template values with the primary key.
	*
	* @param valueId the primary key of the g e m template values
	* @return the g e m template values
	* @throws PortalException if a g e m template values with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMTemplateValues getGEMTemplateValues(
		long valueId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gemTemplateValuesLocalService.getGEMTemplateValues(valueId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gemTemplateValuesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the g e m template valueses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateValuesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m template valueses
	* @param end the upper bound of the range of g e m template valueses (not inclusive)
	* @return the range of g e m template valueses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplateValues> getGEMTemplateValueses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemTemplateValuesLocalService.getGEMTemplateValueses(start, end);
	}

	/**
	* Returns the number of g e m template valueses.
	*
	* @return the number of g e m template valueses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGEMTemplateValuesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemTemplateValuesLocalService.getGEMTemplateValuesesCount();
	}

	/**
	* Updates the g e m template values in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param gemTemplateValues the g e m template values
	* @return the g e m template values that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMTemplateValues updateGEMTemplateValues(
		com.ihg.brandstandards.db.model.GEMTemplateValues gemTemplateValues)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemTemplateValuesLocalService.updateGEMTemplateValues(gemTemplateValues);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _gemTemplateValuesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_gemTemplateValuesLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _gemTemplateValuesLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void clearCache() {
		_gemTemplateValuesLocalService.clearCache();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GEMTemplateValuesLocalService getWrappedGEMTemplateValuesLocalService() {
		return _gemTemplateValuesLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGEMTemplateValuesLocalService(
		GEMTemplateValuesLocalService gemTemplateValuesLocalService) {
		_gemTemplateValuesLocalService = gemTemplateValuesLocalService;
	}

	@Override
	public GEMTemplateValuesLocalService getWrappedService() {
		return _gemTemplateValuesLocalService;
	}

	@Override
	public void setWrappedService(
		GEMTemplateValuesLocalService gemTemplateValuesLocalService) {
		_gemTemplateValuesLocalService = gemTemplateValuesLocalService;
	}

	private GEMTemplateValuesLocalService _gemTemplateValuesLocalService;
}