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

package com.ihg.grs.common.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GlossaryLocalService}.
 *
 * @author gulam.vora
 * @see GlossaryLocalService
 * @generated
 */
public class GlossaryLocalServiceWrapper implements GlossaryLocalService,
	ServiceWrapper<GlossaryLocalService> {
	public GlossaryLocalServiceWrapper(
		GlossaryLocalService glossaryLocalService) {
		_glossaryLocalService = glossaryLocalService;
	}

	/**
	* Adds the glossary to the database. Also notifies the appropriate model listeners.
	*
	* @param glossary the glossary
	* @return the glossary that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.grs.common.model.Glossary addGlossary(
		com.ihg.grs.common.model.Glossary glossary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryLocalService.addGlossary(glossary);
	}

	/**
	* Creates a new glossary with the primary key. Does not add the glossary to the database.
	*
	* @param glossaryId the primary key for the new glossary
	* @return the new glossary
	*/
	@Override
	public com.ihg.grs.common.model.Glossary createGlossary(int glossaryId) {
		return _glossaryLocalService.createGlossary(glossaryId);
	}

	/**
	* Deletes the glossary with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param glossaryId the primary key of the glossary
	* @return the glossary that was removed
	* @throws PortalException if a glossary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.grs.common.model.Glossary deleteGlossary(int glossaryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _glossaryLocalService.deleteGlossary(glossaryId);
	}

	/**
	* Deletes the glossary from the database. Also notifies the appropriate model listeners.
	*
	* @param glossary the glossary
	* @return the glossary that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.grs.common.model.Glossary deleteGlossary(
		com.ihg.grs.common.model.Glossary glossary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryLocalService.deleteGlossary(glossary);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _glossaryLocalService.dynamicQuery();
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
		return _glossaryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.grs.common.model.impl.GlossaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _glossaryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.grs.common.model.impl.GlossaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _glossaryLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _glossaryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _glossaryLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.ihg.grs.common.model.Glossary fetchGlossary(int glossaryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryLocalService.fetchGlossary(glossaryId);
	}

	/**
	* Returns the glossary with the primary key.
	*
	* @param glossaryId the primary key of the glossary
	* @return the glossary
	* @throws PortalException if a glossary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.grs.common.model.Glossary getGlossary(int glossaryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _glossaryLocalService.getGlossary(glossaryId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _glossaryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the glossaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.grs.common.model.impl.GlossaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of glossaries
	* @param end the upper bound of the range of glossaries (not inclusive)
	* @return the range of glossaries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.grs.common.model.Glossary> getGlossaries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryLocalService.getGlossaries(start, end);
	}

	/**
	* Returns the number of glossaries.
	*
	* @return the number of glossaries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGlossariesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryLocalService.getGlossariesCount();
	}

	/**
	* Updates the glossary in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param glossary the glossary
	* @return the glossary that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.grs.common.model.Glossary updateGlossary(
		com.ihg.grs.common.model.Glossary glossary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryLocalService.updateGlossary(glossary);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _glossaryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_glossaryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _glossaryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GlossaryLocalService getWrappedGlossaryLocalService() {
		return _glossaryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGlossaryLocalService(
		GlossaryLocalService glossaryLocalService) {
		_glossaryLocalService = glossaryLocalService;
	}

	@Override
	public GlossaryLocalService getWrappedService() {
		return _glossaryLocalService;
	}

	@Override
	public void setWrappedService(GlossaryLocalService glossaryLocalService) {
		_glossaryLocalService = glossaryLocalService;
	}

	private GlossaryLocalService _glossaryLocalService;
}