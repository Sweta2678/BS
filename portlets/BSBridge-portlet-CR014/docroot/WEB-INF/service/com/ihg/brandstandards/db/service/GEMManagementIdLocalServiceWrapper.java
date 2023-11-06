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
 * Provides a wrapper for {@link GEMManagementIdLocalService}.
 *
 * @author Mummanedi
 * @see GEMManagementIdLocalService
 * @generated
 */
public class GEMManagementIdLocalServiceWrapper
	implements GEMManagementIdLocalService,
		ServiceWrapper<GEMManagementIdLocalService> {
	public GEMManagementIdLocalServiceWrapper(
		GEMManagementIdLocalService gemManagementIdLocalService) {
		_gemManagementIdLocalService = gemManagementIdLocalService;
	}

	/**
	* Adds the g e m management ID to the database. Also notifies the appropriate model listeners.
	*
	* @param gemManagementId the g e m management ID
	* @return the g e m management ID that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMManagementId addGEMManagementId(
		com.ihg.brandstandards.db.model.GEMManagementId gemManagementId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemManagementIdLocalService.addGEMManagementId(gemManagementId);
	}

	/**
	* Creates a new g e m management ID with the primary key. Does not add the g e m management ID to the database.
	*
	* @param managementId the primary key for the new g e m management ID
	* @return the new g e m management ID
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMManagementId createGEMManagementId(
		long managementId) {
		return _gemManagementIdLocalService.createGEMManagementId(managementId);
	}

	/**
	* Deletes the g e m management ID with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param managementId the primary key of the g e m management ID
	* @return the g e m management ID that was removed
	* @throws PortalException if a g e m management ID with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMManagementId deleteGEMManagementId(
		long managementId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gemManagementIdLocalService.deleteGEMManagementId(managementId);
	}

	/**
	* Deletes the g e m management ID from the database. Also notifies the appropriate model listeners.
	*
	* @param gemManagementId the g e m management ID
	* @return the g e m management ID that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMManagementId deleteGEMManagementId(
		com.ihg.brandstandards.db.model.GEMManagementId gemManagementId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemManagementIdLocalService.deleteGEMManagementId(gemManagementId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _gemManagementIdLocalService.dynamicQuery();
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
		return _gemManagementIdLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMManagementIdModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _gemManagementIdLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMManagementIdModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _gemManagementIdLocalService.dynamicQuery(dynamicQuery, start,
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
		return _gemManagementIdLocalService.dynamicQueryCount(dynamicQuery);
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
		return _gemManagementIdLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMManagementId fetchGEMManagementId(
		long managementId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemManagementIdLocalService.fetchGEMManagementId(managementId);
	}

	/**
	* Returns the g e m management ID with the primary key.
	*
	* @param managementId the primary key of the g e m management ID
	* @return the g e m management ID
	* @throws PortalException if a g e m management ID with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMManagementId getGEMManagementId(
		long managementId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gemManagementIdLocalService.getGEMManagementId(managementId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gemManagementIdLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the g e m management IDs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMManagementIdModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m management IDs
	* @param end the upper bound of the range of g e m management IDs (not inclusive)
	* @return the range of g e m management IDs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.GEMManagementId> getGEMManagementIds(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemManagementIdLocalService.getGEMManagementIds(start, end);
	}

	/**
	* Returns the number of g e m management IDs.
	*
	* @return the number of g e m management IDs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGEMManagementIdsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemManagementIdLocalService.getGEMManagementIdsCount();
	}

	/**
	* Updates the g e m management ID in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param gemManagementId the g e m management ID
	* @return the g e m management ID that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMManagementId updateGEMManagementId(
		com.ihg.brandstandards.db.model.GEMManagementId gemManagementId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemManagementIdLocalService.updateGEMManagementId(gemManagementId);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _gemManagementIdLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_gemManagementIdLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _gemManagementIdLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* @param regionId
	* @param subBrandCode
	* @return Map<String, Map<Stirng, String>>
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.GEMManagementId> getManagementIdsByRegionAndBrand(
		long regionId, java.lang.String subBrandCodes) {
		return _gemManagementIdLocalService.getManagementIdsByRegionAndBrand(regionId,
			subBrandCodes);
	}

	/**
	* @param countryCode
	* @param chainCode
	* @return Map<String, Map<Stirng, String>>
	* @throws SystemException
	* @throws NoSuchGEMManagementIdException
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMManagementId getManagementIdsByCountryAndBrand(
		java.lang.String countryCode, java.lang.String chainCode)
		throws com.ihg.brandstandards.db.NoSuchGEMManagementIdException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gemManagementIdLocalService.getManagementIdsByCountryAndBrand(countryCode,
			chainCode);
	}

	@Override
	public void clearCache() {
		_gemManagementIdLocalService.clearCache();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GEMManagementIdLocalService getWrappedGEMManagementIdLocalService() {
		return _gemManagementIdLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGEMManagementIdLocalService(
		GEMManagementIdLocalService gemManagementIdLocalService) {
		_gemManagementIdLocalService = gemManagementIdLocalService;
	}

	@Override
	public GEMManagementIdLocalService getWrappedService() {
		return _gemManagementIdLocalService;
	}

	@Override
	public void setWrappedService(
		GEMManagementIdLocalService gemManagementIdLocalService) {
		_gemManagementIdLocalService = gemManagementIdLocalService;
	}

	private GEMManagementIdLocalService _gemManagementIdLocalService;
}