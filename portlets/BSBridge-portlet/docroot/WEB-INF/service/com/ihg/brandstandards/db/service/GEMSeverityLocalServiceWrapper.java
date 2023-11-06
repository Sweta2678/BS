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
 * Provides a wrapper for {@link GEMSeverityLocalService}.
 *
 * @author Mummanedi
 * @see GEMSeverityLocalService
 * @generated
 */
public class GEMSeverityLocalServiceWrapper implements GEMSeverityLocalService,
	ServiceWrapper<GEMSeverityLocalService> {
	public GEMSeverityLocalServiceWrapper(
		GEMSeverityLocalService gemSeverityLocalService) {
		_gemSeverityLocalService = gemSeverityLocalService;
	}

	/**
	* Adds the g e m severity to the database. Also notifies the appropriate model listeners.
	*
	* @param gemSeverity the g e m severity
	* @return the g e m severity that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMSeverity addGEMSeverity(
		com.ihg.brandstandards.db.model.GEMSeverity gemSeverity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemSeverityLocalService.addGEMSeverity(gemSeverity);
	}

	/**
	* Creates a new g e m severity with the primary key. Does not add the g e m severity to the database.
	*
	* @param severityId the primary key for the new g e m severity
	* @return the new g e m severity
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMSeverity createGEMSeverity(
		long severityId) {
		return _gemSeverityLocalService.createGEMSeverity(severityId);
	}

	/**
	* Deletes the g e m severity with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param severityId the primary key of the g e m severity
	* @return the g e m severity that was removed
	* @throws PortalException if a g e m severity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMSeverity deleteGEMSeverity(
		long severityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gemSeverityLocalService.deleteGEMSeverity(severityId);
	}

	/**
	* Deletes the g e m severity from the database. Also notifies the appropriate model listeners.
	*
	* @param gemSeverity the g e m severity
	* @return the g e m severity that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMSeverity deleteGEMSeverity(
		com.ihg.brandstandards.db.model.GEMSeverity gemSeverity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemSeverityLocalService.deleteGEMSeverity(gemSeverity);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _gemSeverityLocalService.dynamicQuery();
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
		return _gemSeverityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMSeverityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _gemSeverityLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMSeverityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _gemSeverityLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _gemSeverityLocalService.dynamicQueryCount(dynamicQuery);
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
		return _gemSeverityLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMSeverity fetchGEMSeverity(
		long severityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemSeverityLocalService.fetchGEMSeverity(severityId);
	}

	/**
	* Returns the g e m severity with the primary key.
	*
	* @param severityId the primary key of the g e m severity
	* @return the g e m severity
	* @throws PortalException if a g e m severity with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMSeverity getGEMSeverity(
		long severityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gemSeverityLocalService.getGEMSeverity(severityId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gemSeverityLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the g e m severities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMSeverityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m severities
	* @param end the upper bound of the range of g e m severities (not inclusive)
	* @return the range of g e m severities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.GEMSeverity> getGEMSeverities(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemSeverityLocalService.getGEMSeverities(start, end);
	}

	/**
	* Returns the number of g e m severities.
	*
	* @return the number of g e m severities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGEMSeveritiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemSeverityLocalService.getGEMSeveritiesCount();
	}

	/**
	* Updates the g e m severity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param gemSeverity the g e m severity
	* @return the g e m severity that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMSeverity updateGEMSeverity(
		com.ihg.brandstandards.db.model.GEMSeverity gemSeverity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemSeverityLocalService.updateGEMSeverity(gemSeverity);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _gemSeverityLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_gemSeverityLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _gemSeverityLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void clearCache() {
		_gemSeverityLocalService.clearCache();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GEMSeverityLocalService getWrappedGEMSeverityLocalService() {
		return _gemSeverityLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGEMSeverityLocalService(
		GEMSeverityLocalService gemSeverityLocalService) {
		_gemSeverityLocalService = gemSeverityLocalService;
	}

	@Override
	public GEMSeverityLocalService getWrappedService() {
		return _gemSeverityLocalService;
	}

	@Override
	public void setWrappedService(
		GEMSeverityLocalService gemSeverityLocalService) {
		_gemSeverityLocalService = gemSeverityLocalService;
	}

	private GEMSeverityLocalService _gemSeverityLocalService;
}