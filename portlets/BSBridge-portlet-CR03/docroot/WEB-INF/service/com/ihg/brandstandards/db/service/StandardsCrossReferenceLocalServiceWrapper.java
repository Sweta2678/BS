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
 * Provides a wrapper for {@link StandardsCrossReferenceLocalService}.
 *
 * @author Mummanedi
 * @see StandardsCrossReferenceLocalService
 * @generated
 */
public class StandardsCrossReferenceLocalServiceWrapper
	implements StandardsCrossReferenceLocalService,
		ServiceWrapper<StandardsCrossReferenceLocalService> {
	public StandardsCrossReferenceLocalServiceWrapper(
		StandardsCrossReferenceLocalService standardsCrossReferenceLocalService) {
		_standardsCrossReferenceLocalService = standardsCrossReferenceLocalService;
	}

	/**
	* Adds the standards cross reference to the database. Also notifies the appropriate model listeners.
	*
	* @param standardsCrossReference the standards cross reference
	* @return the standards cross reference that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsCrossReference addStandardsCrossReference(
		com.ihg.brandstandards.db.model.StandardsCrossReference standardsCrossReference)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsCrossReferenceLocalService.addStandardsCrossReference(standardsCrossReference);
	}

	/**
	* Creates a new standards cross reference with the primary key. Does not add the standards cross reference to the database.
	*
	* @param standardsCrossReferencePK the primary key for the new standards cross reference
	* @return the new standards cross reference
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsCrossReference createStandardsCrossReference(
		com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK standardsCrossReferencePK) {
		return _standardsCrossReferenceLocalService.createStandardsCrossReference(standardsCrossReferencePK);
	}

	/**
	* Deletes the standards cross reference with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsCrossReferencePK the primary key of the standards cross reference
	* @return the standards cross reference that was removed
	* @throws PortalException if a standards cross reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsCrossReference deleteStandardsCrossReference(
		com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK standardsCrossReferencePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsCrossReferenceLocalService.deleteStandardsCrossReference(standardsCrossReferencePK);
	}

	/**
	* Deletes the standards cross reference from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsCrossReference the standards cross reference
	* @return the standards cross reference that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsCrossReference deleteStandardsCrossReference(
		com.ihg.brandstandards.db.model.StandardsCrossReference standardsCrossReference)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsCrossReferenceLocalService.deleteStandardsCrossReference(standardsCrossReference);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _standardsCrossReferenceLocalService.dynamicQuery();
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
		return _standardsCrossReferenceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCrossReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _standardsCrossReferenceLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCrossReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _standardsCrossReferenceLocalService.dynamicQuery(dynamicQuery,
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
		return _standardsCrossReferenceLocalService.dynamicQueryCount(dynamicQuery);
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
		return _standardsCrossReferenceLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsCrossReference fetchStandardsCrossReference(
		com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK standardsCrossReferencePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsCrossReferenceLocalService.fetchStandardsCrossReference(standardsCrossReferencePK);
	}

	/**
	* Returns the standards cross reference with the primary key.
	*
	* @param standardsCrossReferencePK the primary key of the standards cross reference
	* @return the standards cross reference
	* @throws PortalException if a standards cross reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsCrossReference getStandardsCrossReference(
		com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK standardsCrossReferencePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsCrossReferenceLocalService.getStandardsCrossReference(standardsCrossReferencePK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsCrossReferenceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the standards cross references.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCrossReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards cross references
	* @param end the upper bound of the range of standards cross references (not inclusive)
	* @return the range of standards cross references
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCrossReference> getStandardsCrossReferences(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsCrossReferenceLocalService.getStandardsCrossReferences(start,
			end);
	}

	/**
	* Returns the number of standards cross references.
	*
	* @return the number of standards cross references
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getStandardsCrossReferencesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsCrossReferenceLocalService.getStandardsCrossReferencesCount();
	}

	/**
	* Updates the standards cross reference in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param standardsCrossReference the standards cross reference
	* @return the standards cross reference that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsCrossReference updateStandardsCrossReference(
		com.ihg.brandstandards.db.model.StandardsCrossReference standardsCrossReference)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsCrossReferenceLocalService.updateStandardsCrossReference(standardsCrossReference);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _standardsCrossReferenceLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_standardsCrossReferenceLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _standardsCrossReferenceLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void clearCache() {
		_standardsCrossReferenceLocalService.clearCache();
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Standards> getXStandardsOthers(
		long stdId) {
		return _standardsCrossReferenceLocalService.getXStandardsOthers(stdId);
	}

	@Override
	public void addCrossReferences(long userId, java.util.Date currDate,
		long stdId, java.lang.String crossRefIds) {
		_standardsCrossReferenceLocalService.addCrossReferences(userId,
			currDate, stdId, crossRefIds);
	}

	@Override
	public void deleteCrossReferences(long stdId, java.lang.String crossRefIds) {
		_standardsCrossReferenceLocalService.deleteCrossReferences(stdId,
			crossRefIds);
	}

	@Override
	public void updateStdOrder(long stdId, java.lang.String stdIds) {
		_standardsCrossReferenceLocalService.updateStdOrder(stdId, stdIds);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public StandardsCrossReferenceLocalService getWrappedStandardsCrossReferenceLocalService() {
		return _standardsCrossReferenceLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedStandardsCrossReferenceLocalService(
		StandardsCrossReferenceLocalService standardsCrossReferenceLocalService) {
		_standardsCrossReferenceLocalService = standardsCrossReferenceLocalService;
	}

	@Override
	public StandardsCrossReferenceLocalService getWrappedService() {
		return _standardsCrossReferenceLocalService;
	}

	@Override
	public void setWrappedService(
		StandardsCrossReferenceLocalService standardsCrossReferenceLocalService) {
		_standardsCrossReferenceLocalService = standardsCrossReferenceLocalService;
	}

	private StandardsCrossReferenceLocalService _standardsCrossReferenceLocalService;
}