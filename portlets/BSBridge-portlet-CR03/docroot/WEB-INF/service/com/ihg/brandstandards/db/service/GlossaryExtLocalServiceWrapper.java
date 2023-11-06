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
 * Provides a wrapper for {@link GlossaryExtLocalService}.
 *
 * @author Mummanedi
 * @see GlossaryExtLocalService
 * @generated
 */
public class GlossaryExtLocalServiceWrapper implements GlossaryExtLocalService,
	ServiceWrapper<GlossaryExtLocalService> {
	public GlossaryExtLocalServiceWrapper(
		GlossaryExtLocalService glossaryExtLocalService) {
		_glossaryExtLocalService = glossaryExtLocalService;
	}

	/**
	* Adds the glossary ext to the database. Also notifies the appropriate model listeners.
	*
	* @param glossaryExt the glossary ext
	* @return the glossary ext that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GlossaryExt addGlossaryExt(
		com.ihg.brandstandards.db.model.GlossaryExt glossaryExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryExtLocalService.addGlossaryExt(glossaryExt);
	}

	/**
	* Creates a new glossary ext with the primary key. Does not add the glossary ext to the database.
	*
	* @param glossaryId the primary key for the new glossary ext
	* @return the new glossary ext
	*/
	@Override
	public com.ihg.brandstandards.db.model.GlossaryExt createGlossaryExt(
		long glossaryId) {
		return _glossaryExtLocalService.createGlossaryExt(glossaryId);
	}

	/**
	* Deletes the glossary ext with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param glossaryId the primary key of the glossary ext
	* @return the glossary ext that was removed
	* @throws PortalException if a glossary ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GlossaryExt deleteGlossaryExt(
		long glossaryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _glossaryExtLocalService.deleteGlossaryExt(glossaryId);
	}

	/**
	* Deletes the glossary ext from the database. Also notifies the appropriate model listeners.
	*
	* @param glossaryExt the glossary ext
	* @return the glossary ext that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GlossaryExt deleteGlossaryExt(
		com.ihg.brandstandards.db.model.GlossaryExt glossaryExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryExtLocalService.deleteGlossaryExt(glossaryExt);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _glossaryExtLocalService.dynamicQuery();
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
		return _glossaryExtLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _glossaryExtLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _glossaryExtLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _glossaryExtLocalService.dynamicQueryCount(dynamicQuery);
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
		return _glossaryExtLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.GlossaryExt fetchGlossaryExt(
		long glossaryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryExtLocalService.fetchGlossaryExt(glossaryId);
	}

	/**
	* Returns the glossary ext with the primary key.
	*
	* @param glossaryId the primary key of the glossary ext
	* @return the glossary ext
	* @throws PortalException if a glossary ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GlossaryExt getGlossaryExt(
		long glossaryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _glossaryExtLocalService.getGlossaryExt(glossaryId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _glossaryExtLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the glossary exts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of glossary exts
	* @param end the upper bound of the range of glossary exts (not inclusive)
	* @return the range of glossary exts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.GlossaryExt> getGlossaryExts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryExtLocalService.getGlossaryExts(start, end);
	}

	/**
	* Returns the number of glossary exts.
	*
	* @return the number of glossary exts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGlossaryExtsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryExtLocalService.getGlossaryExtsCount();
	}

	/**
	* Updates the glossary ext in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param glossaryExt the glossary ext
	* @return the glossary ext that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GlossaryExt updateGlossaryExt(
		com.ihg.brandstandards.db.model.GlossaryExt glossaryExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryExtLocalService.updateGlossaryExt(glossaryExt);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _glossaryExtLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_glossaryExtLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _glossaryExtLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Get Glossary By Brand code and char selected as input.
	*
	* @param brandCode  User selected Brand code.
	* @param visibleChar User Selected first char of Glossary.
	* @return List of @GlossaryExt object.
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.GlossaryExt> getGlossaryByBrandCodeAndVisibleChar(
		java.lang.String brandCode, java.lang.String visibleChar) {
		return _glossaryExtLocalService.getGlossaryByBrandCodeAndVisibleChar(brandCode,
			visibleChar);
	}

	@Override
	public void clearCache() {
		_glossaryExtLocalService.clearCache();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GlossaryExtLocalService getWrappedGlossaryExtLocalService() {
		return _glossaryExtLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGlossaryExtLocalService(
		GlossaryExtLocalService glossaryExtLocalService) {
		_glossaryExtLocalService = glossaryExtLocalService;
	}

	@Override
	public GlossaryExtLocalService getWrappedService() {
		return _glossaryExtLocalService;
	}

	@Override
	public void setWrappedService(
		GlossaryExtLocalService glossaryExtLocalService) {
		_glossaryExtLocalService = glossaryExtLocalService;
	}

	private GlossaryExtLocalService _glossaryExtLocalService;
}