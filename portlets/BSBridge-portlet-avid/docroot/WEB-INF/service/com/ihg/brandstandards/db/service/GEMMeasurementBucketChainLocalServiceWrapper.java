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
 * Provides a wrapper for {@link GEMMeasurementBucketChainLocalService}.
 *
 * @author Mummanedi
 * @see GEMMeasurementBucketChainLocalService
 * @generated
 */
public class GEMMeasurementBucketChainLocalServiceWrapper
	implements GEMMeasurementBucketChainLocalService,
		ServiceWrapper<GEMMeasurementBucketChainLocalService> {
	public GEMMeasurementBucketChainLocalServiceWrapper(
		GEMMeasurementBucketChainLocalService gemMeasurementBucketChainLocalService) {
		_gemMeasurementBucketChainLocalService = gemMeasurementBucketChainLocalService;
	}

	/**
	* Adds the g e m measurement bucket chain to the database. Also notifies the appropriate model listeners.
	*
	* @param gemMeasurementBucketChain the g e m measurement bucket chain
	* @return the g e m measurement bucket chain that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMMeasurementBucketChain addGEMMeasurementBucketChain(
		com.ihg.brandstandards.db.model.GEMMeasurementBucketChain gemMeasurementBucketChain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemMeasurementBucketChainLocalService.addGEMMeasurementBucketChain(gemMeasurementBucketChain);
	}

	/**
	* Creates a new g e m measurement bucket chain with the primary key. Does not add the g e m measurement bucket chain to the database.
	*
	* @param measurementBucketChainId the primary key for the new g e m measurement bucket chain
	* @return the new g e m measurement bucket chain
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMMeasurementBucketChain createGEMMeasurementBucketChain(
		long measurementBucketChainId) {
		return _gemMeasurementBucketChainLocalService.createGEMMeasurementBucketChain(measurementBucketChainId);
	}

	/**
	* Deletes the g e m measurement bucket chain with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param measurementBucketChainId the primary key of the g e m measurement bucket chain
	* @return the g e m measurement bucket chain that was removed
	* @throws PortalException if a g e m measurement bucket chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMMeasurementBucketChain deleteGEMMeasurementBucketChain(
		long measurementBucketChainId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gemMeasurementBucketChainLocalService.deleteGEMMeasurementBucketChain(measurementBucketChainId);
	}

	/**
	* Deletes the g e m measurement bucket chain from the database. Also notifies the appropriate model listeners.
	*
	* @param gemMeasurementBucketChain the g e m measurement bucket chain
	* @return the g e m measurement bucket chain that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMMeasurementBucketChain deleteGEMMeasurementBucketChain(
		com.ihg.brandstandards.db.model.GEMMeasurementBucketChain gemMeasurementBucketChain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemMeasurementBucketChainLocalService.deleteGEMMeasurementBucketChain(gemMeasurementBucketChain);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _gemMeasurementBucketChainLocalService.dynamicQuery();
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
		return _gemMeasurementBucketChainLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementBucketChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _gemMeasurementBucketChainLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementBucketChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _gemMeasurementBucketChainLocalService.dynamicQuery(dynamicQuery,
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
		return _gemMeasurementBucketChainLocalService.dynamicQueryCount(dynamicQuery);
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
		return _gemMeasurementBucketChainLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMMeasurementBucketChain fetchGEMMeasurementBucketChain(
		long measurementBucketChainId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemMeasurementBucketChainLocalService.fetchGEMMeasurementBucketChain(measurementBucketChainId);
	}

	/**
	* Returns the g e m measurement bucket chain with the primary key.
	*
	* @param measurementBucketChainId the primary key of the g e m measurement bucket chain
	* @return the g e m measurement bucket chain
	* @throws PortalException if a g e m measurement bucket chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMMeasurementBucketChain getGEMMeasurementBucketChain(
		long measurementBucketChainId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gemMeasurementBucketChainLocalService.getGEMMeasurementBucketChain(measurementBucketChainId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gemMeasurementBucketChainLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the g e m measurement bucket chains.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementBucketChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m measurement bucket chains
	* @param end the upper bound of the range of g e m measurement bucket chains (not inclusive)
	* @return the range of g e m measurement bucket chains
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.GEMMeasurementBucketChain> getGEMMeasurementBucketChains(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemMeasurementBucketChainLocalService.getGEMMeasurementBucketChains(start,
			end);
	}

	/**
	* Returns the number of g e m measurement bucket chains.
	*
	* @return the number of g e m measurement bucket chains
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGEMMeasurementBucketChainsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemMeasurementBucketChainLocalService.getGEMMeasurementBucketChainsCount();
	}

	/**
	* Updates the g e m measurement bucket chain in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param gemMeasurementBucketChain the g e m measurement bucket chain
	* @return the g e m measurement bucket chain that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GEMMeasurementBucketChain updateGEMMeasurementBucketChain(
		com.ihg.brandstandards.db.model.GEMMeasurementBucketChain gemMeasurementBucketChain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gemMeasurementBucketChainLocalService.updateGEMMeasurementBucketChain(gemMeasurementBucketChain);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _gemMeasurementBucketChainLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_gemMeasurementBucketChainLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _gemMeasurementBucketChainLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void clearCache() {
		_gemMeasurementBucketChainLocalService.clearCache();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GEMMeasurementBucketChainLocalService getWrappedGEMMeasurementBucketChainLocalService() {
		return _gemMeasurementBucketChainLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGEMMeasurementBucketChainLocalService(
		GEMMeasurementBucketChainLocalService gemMeasurementBucketChainLocalService) {
		_gemMeasurementBucketChainLocalService = gemMeasurementBucketChainLocalService;
	}

	@Override
	public GEMMeasurementBucketChainLocalService getWrappedService() {
		return _gemMeasurementBucketChainLocalService;
	}

	@Override
	public void setWrappedService(
		GEMMeasurementBucketChainLocalService gemMeasurementBucketChainLocalService) {
		_gemMeasurementBucketChainLocalService = gemMeasurementBucketChainLocalService;
	}

	private GEMMeasurementBucketChainLocalService _gemMeasurementBucketChainLocalService;
}