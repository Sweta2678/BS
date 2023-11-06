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
 * Provides a wrapper for {@link GEMGeneratedReportValLocalService}.
 *
 * @author Mummanedi
 * @see GEMGeneratedReportValLocalService
 * @generated
 */
public class GEMGeneratedReportValLocalServiceWrapper
	implements GEMGeneratedReportValLocalService,
		ServiceWrapper<GEMGeneratedReportValLocalService> {
	public GEMGeneratedReportValLocalServiceWrapper(
		GEMGeneratedReportValLocalService gemGeneratedReportValLocalService) {
		_gemGeneratedReportValLocalService = gemGeneratedReportValLocalService;
	}

	/**
	* Adds the g e m generated report val to the database. Also notifies the appropriate model listeners.
	*
	* @param gemGeneratedReportVal the g e m generated report val
	* @return the g e m generated report val that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMGeneratedReportVal addGEMGeneratedReportVal(
		com.ihg.brandstandards.db.model.GEMGeneratedReportVal gemGeneratedReportVal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemGeneratedReportValLocalService.addGEMGeneratedReportVal(gemGeneratedReportVal);
	}

	/**
	* Creates a new g e m generated report val with the primary key. Does not add the g e m generated report val to the database.
	*
	* @param gemGeneratedReportValPK the primary key for the new g e m generated report val
	* @return the new g e m generated report val
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMGeneratedReportVal createGEMGeneratedReportVal(
		com.ihg.brandstandards.db.service.persistence.GEMGeneratedReportValPK gemGeneratedReportValPK) {
		return _gemGeneratedReportValLocalService.createGEMGeneratedReportVal(gemGeneratedReportValPK);
	}

	/**
	* Deletes the g e m generated report val with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param gemGeneratedReportValPK the primary key of the g e m generated report val
	* @return the g e m generated report val that was removed
	* @throws PortalException if a g e m generated report val with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMGeneratedReportVal deleteGEMGeneratedReportVal(
		com.ihg.brandstandards.db.service.persistence.GEMGeneratedReportValPK gemGeneratedReportValPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gemGeneratedReportValLocalService.deleteGEMGeneratedReportVal(gemGeneratedReportValPK);
	}

	/**
	* Deletes the g e m generated report val from the database. Also notifies the appropriate model listeners.
	*
	* @param gemGeneratedReportVal the g e m generated report val
	* @return the g e m generated report val that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMGeneratedReportVal deleteGEMGeneratedReportVal(
		com.ihg.brandstandards.db.model.GEMGeneratedReportVal gemGeneratedReportVal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemGeneratedReportValLocalService.deleteGEMGeneratedReportVal(gemGeneratedReportVal);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _gemGeneratedReportValLocalService.dynamicQuery();
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
		return _gemGeneratedReportValLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMGeneratedReportValModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _gemGeneratedReportValLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMGeneratedReportValModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _gemGeneratedReportValLocalService.dynamicQuery(dynamicQuery,
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
		return _gemGeneratedReportValLocalService.dynamicQueryCount(dynamicQuery);
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
		return _gemGeneratedReportValLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMGeneratedReportVal fetchGEMGeneratedReportVal(
		com.ihg.brandstandards.db.service.persistence.GEMGeneratedReportValPK gemGeneratedReportValPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemGeneratedReportValLocalService.fetchGEMGeneratedReportVal(gemGeneratedReportValPK);
	}

	/**
	* Returns the g e m generated report val with the primary key.
	*
	* @param gemGeneratedReportValPK the primary key of the g e m generated report val
	* @return the g e m generated report val
	* @throws PortalException if a g e m generated report val with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMGeneratedReportVal getGEMGeneratedReportVal(
		com.ihg.brandstandards.db.service.persistence.GEMGeneratedReportValPK gemGeneratedReportValPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gemGeneratedReportValLocalService.getGEMGeneratedReportVal(gemGeneratedReportValPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gemGeneratedReportValLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the g e m generated report vals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMGeneratedReportValModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m generated report vals
	* @param end the upper bound of the range of g e m generated report vals (not inclusive)
	* @return the range of g e m generated report vals
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.GEMGeneratedReportVal> getGEMGeneratedReportVals(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemGeneratedReportValLocalService.getGEMGeneratedReportVals(start,
			end);
	}

	/**
	* Returns the number of g e m generated report vals.
	*
	* @return the number of g e m generated report vals
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGEMGeneratedReportValsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemGeneratedReportValLocalService.getGEMGeneratedReportValsCount();
	}

	/**
	* Updates the g e m generated report val in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param gemGeneratedReportVal the g e m generated report val
	* @return the g e m generated report val that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMGeneratedReportVal updateGEMGeneratedReportVal(
		com.ihg.brandstandards.db.model.GEMGeneratedReportVal gemGeneratedReportVal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemGeneratedReportValLocalService.updateGEMGeneratedReportVal(gemGeneratedReportVal);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _gemGeneratedReportValLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_gemGeneratedReportValLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _gemGeneratedReportValLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void clearCache() {
		_gemGeneratedReportValLocalService.clearCache();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GEMGeneratedReportValLocalService getWrappedGEMGeneratedReportValLocalService() {
		return _gemGeneratedReportValLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGEMGeneratedReportValLocalService(
		GEMGeneratedReportValLocalService gemGeneratedReportValLocalService) {
		_gemGeneratedReportValLocalService = gemGeneratedReportValLocalService;
	}

	@Override
	public GEMGeneratedReportValLocalService getWrappedService() {
		return _gemGeneratedReportValLocalService;
	}

	@Override
	public void setWrappedService(
		GEMGeneratedReportValLocalService gemGeneratedReportValLocalService) {
		_gemGeneratedReportValLocalService = gemGeneratedReportValLocalService;
	}

	private GEMGeneratedReportValLocalService _gemGeneratedReportValLocalService;
}