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
 * Provides a wrapper for {@link ChainStandardsLocalService}.
 *
 * @author Mummanedi
 * @see ChainStandardsLocalService
 * @generated
 */
public class ChainStandardsLocalServiceWrapper
	implements ChainStandardsLocalService,
		ServiceWrapper<ChainStandardsLocalService> {
	public ChainStandardsLocalServiceWrapper(
		ChainStandardsLocalService chainStandardsLocalService) {
		_chainStandardsLocalService = chainStandardsLocalService;
	}

	/**
	* Adds the chain standards to the database. Also notifies the appropriate model listeners.
	*
	* @param chainStandards the chain standards
	* @return the chain standards that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.ChainStandards addChainStandards(
		com.ihg.brandstandards.db.model.ChainStandards chainStandards)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chainStandardsLocalService.addChainStandards(chainStandards);
	}

	/**
	* Creates a new chain standards with the primary key. Does not add the chain standards to the database.
	*
	* @param chainStandardsPK the primary key for the new chain standards
	* @return the new chain standards
	*/
	@Override
	public com.ihg.brandstandards.db.model.ChainStandards createChainStandards(
		com.ihg.brandstandards.db.service.persistence.ChainStandardsPK chainStandardsPK) {
		return _chainStandardsLocalService.createChainStandards(chainStandardsPK);
	}

	/**
	* Deletes the chain standards with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param chainStandardsPK the primary key of the chain standards
	* @return the chain standards that was removed
	* @throws PortalException if a chain standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.ChainStandards deleteChainStandards(
		com.ihg.brandstandards.db.service.persistence.ChainStandardsPK chainStandardsPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _chainStandardsLocalService.deleteChainStandards(chainStandardsPK);
	}

	/**
	* Deletes the chain standards from the database. Also notifies the appropriate model listeners.
	*
	* @param chainStandards the chain standards
	* @return the chain standards that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.ChainStandards deleteChainStandards(
		com.ihg.brandstandards.db.model.ChainStandards chainStandards)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chainStandardsLocalService.deleteChainStandards(chainStandards);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _chainStandardsLocalService.dynamicQuery();
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
		return _chainStandardsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _chainStandardsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _chainStandardsLocalService.dynamicQuery(dynamicQuery, start,
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
		return _chainStandardsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _chainStandardsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.ChainStandards fetchChainStandards(
		com.ihg.brandstandards.db.service.persistence.ChainStandardsPK chainStandardsPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chainStandardsLocalService.fetchChainStandards(chainStandardsPK);
	}

	/**
	* Returns the chain standards with the primary key.
	*
	* @param chainStandardsPK the primary key of the chain standards
	* @return the chain standards
	* @throws PortalException if a chain standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.ChainStandards getChainStandards(
		com.ihg.brandstandards.db.service.persistence.ChainStandardsPK chainStandardsPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _chainStandardsLocalService.getChainStandards(chainStandardsPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _chainStandardsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the chain standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of chain standardses
	* @param end the upper bound of the range of chain standardses (not inclusive)
	* @return the range of chain standardses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.ChainStandards> getChainStandardses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chainStandardsLocalService.getChainStandardses(start, end);
	}

	/**
	* Returns the number of chain standardses.
	*
	* @return the number of chain standardses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getChainStandardsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chainStandardsLocalService.getChainStandardsesCount();
	}

	/**
	* Updates the chain standards in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param chainStandards the chain standards
	* @return the chain standards that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.ChainStandards updateChainStandards(
		com.ihg.brandstandards.db.model.ChainStandards chainStandards)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chainStandardsLocalService.updateChainStandards(chainStandards);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _chainStandardsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_chainStandardsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _chainStandardsLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.ihg.brandstandards.db.model.ChainStandards getChainStandardsObject() {
		return _chainStandardsLocalService.getChainStandardsObject();
	}

	@Override
	public void clearCache() {
		_chainStandardsLocalService.clearCache();
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.ChainStandards> getChainStandardsByStdId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return _chainStandardsLocalService.getChainStandardsByStdId(stdId);
	}

	@Override
	public com.ihg.brandstandards.db.model.ChainStandards getChainStandardsByChainCode(
		long stdId, java.lang.String chainCode)
		throws com.ihg.brandstandards.db.NoSuchChainStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return _chainStandardsLocalService.getChainStandardsByChainCode(stdId,
			chainCode);
	}

	@Override
	public com.ihg.brandstandards.db.model.ChainStandards getChainStandardsByChainCodeAll(
		long stdId, java.lang.String chainCode)
		throws com.ihg.brandstandards.db.NoSuchChainStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return _chainStandardsLocalService.getChainStandardsByChainCodeAll(stdId,
			chainCode);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.ChainStandards> getChainStandardsByStdIdAll(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return _chainStandardsLocalService.getChainStandardsByStdIdAll(stdId);
	}

	@Override
	public java.util.List<java.lang.Long> getStandardsByChain(
		java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _chainStandardsLocalService.getStandardsByChain(chainCode);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ChainStandardsLocalService getWrappedChainStandardsLocalService() {
		return _chainStandardsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedChainStandardsLocalService(
		ChainStandardsLocalService chainStandardsLocalService) {
		_chainStandardsLocalService = chainStandardsLocalService;
	}

	@Override
	public ChainStandardsLocalService getWrappedService() {
		return _chainStandardsLocalService;
	}

	@Override
	public void setWrappedService(
		ChainStandardsLocalService chainStandardsLocalService) {
		_chainStandardsLocalService = chainStandardsLocalService;
	}

	private ChainStandardsLocalService _chainStandardsLocalService;
}