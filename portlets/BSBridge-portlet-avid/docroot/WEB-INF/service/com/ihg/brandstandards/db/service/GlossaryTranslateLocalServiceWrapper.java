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
 * Provides a wrapper for {@link GlossaryTranslateLocalService}.
 *
 * @author Mummanedi
 * @see GlossaryTranslateLocalService
 * @generated
 */
public class GlossaryTranslateLocalServiceWrapper
	implements GlossaryTranslateLocalService,
		ServiceWrapper<GlossaryTranslateLocalService> {
	public GlossaryTranslateLocalServiceWrapper(
		GlossaryTranslateLocalService glossaryTranslateLocalService) {
		_glossaryTranslateLocalService = glossaryTranslateLocalService;
	}

	/**
	* Adds the glossary translate to the database. Also notifies the appropriate model listeners.
	*
	* @param glossaryTranslate the glossary translate
	* @return the glossary translate that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GlossaryTranslate addGlossaryTranslate(
		com.ihg.brandstandards.db.model.GlossaryTranslate glossaryTranslate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryTranslateLocalService.addGlossaryTranslate(glossaryTranslate);
	}

	/**
	* Creates a new glossary translate with the primary key. Does not add the glossary translate to the database.
	*
	* @param glossaryXlatId the primary key for the new glossary translate
	* @return the new glossary translate
	*/
	@Override
	public com.ihg.brandstandards.db.model.GlossaryTranslate createGlossaryTranslate(
		long glossaryXlatId) {
		return _glossaryTranslateLocalService.createGlossaryTranslate(glossaryXlatId);
	}

	/**
	* Deletes the glossary translate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param glossaryXlatId the primary key of the glossary translate
	* @return the glossary translate that was removed
	* @throws PortalException if a glossary translate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GlossaryTranslate deleteGlossaryTranslate(
		long glossaryXlatId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _glossaryTranslateLocalService.deleteGlossaryTranslate(glossaryXlatId);
	}

	/**
	* Deletes the glossary translate from the database. Also notifies the appropriate model listeners.
	*
	* @param glossaryTranslate the glossary translate
	* @return the glossary translate that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GlossaryTranslate deleteGlossaryTranslate(
		com.ihg.brandstandards.db.model.GlossaryTranslate glossaryTranslate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryTranslateLocalService.deleteGlossaryTranslate(glossaryTranslate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _glossaryTranslateLocalService.dynamicQuery();
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
		return _glossaryTranslateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _glossaryTranslateLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _glossaryTranslateLocalService.dynamicQuery(dynamicQuery, start,
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
		return _glossaryTranslateLocalService.dynamicQueryCount(dynamicQuery);
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
		return _glossaryTranslateLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.GlossaryTranslate fetchGlossaryTranslate(
		long glossaryXlatId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryTranslateLocalService.fetchGlossaryTranslate(glossaryXlatId);
	}

	/**
	* Returns the glossary translate with the primary key.
	*
	* @param glossaryXlatId the primary key of the glossary translate
	* @return the glossary translate
	* @throws PortalException if a glossary translate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GlossaryTranslate getGlossaryTranslate(
		long glossaryXlatId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _glossaryTranslateLocalService.getGlossaryTranslate(glossaryXlatId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _glossaryTranslateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the glossary translates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of glossary translates
	* @param end the upper bound of the range of glossary translates (not inclusive)
	* @return the range of glossary translates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.GlossaryTranslate> getGlossaryTranslates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryTranslateLocalService.getGlossaryTranslates(start, end);
	}

	/**
	* Returns the number of glossary translates.
	*
	* @return the number of glossary translates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGlossaryTranslatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryTranslateLocalService.getGlossaryTranslatesCount();
	}

	/**
	* Updates the glossary translate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param glossaryTranslate the glossary translate
	* @return the glossary translate that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GlossaryTranslate updateGlossaryTranslate(
		com.ihg.brandstandards.db.model.GlossaryTranslate glossaryTranslate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryTranslateLocalService.updateGlossaryTranslate(glossaryTranslate);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _glossaryTranslateLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_glossaryTranslateLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _glossaryTranslateLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void clearCache() {
		_glossaryTranslateLocalService.clearCache();
	}

	@Override
	public com.ihg.brandstandards.db.model.GlossaryTranslate getGlossaryTranslateObject() {
		return _glossaryTranslateLocalService.getGlossaryTranslateObject();
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.GlossaryTranslate> getGlossarriesByGlossaryId(
		long glossaryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryTranslateLocalService.getGlossarriesByGlossaryId(glossaryId);
	}

	/**
	* Get GlosasryTranslate by glossaryId, localeCode.
	*
	* @param glossaryId Glossaryid.
	* @param localeCode localeCode.
	* @throws SystemException SystemException.
	* @throws NoSuchGlossaryTranslateException NoSuchGlossaryTranslateException.
	* @return GlosasryTranslate GlosasryTranslate.
	*/
	@Override
	public com.ihg.brandstandards.db.model.GlossaryTranslate getByGlossaryIdLocaleCode(
		long glossaryId, java.lang.String localeCode)
		throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException,
			com.liferay.portal.kernel.exception.SystemException {
		return _glossaryTranslateLocalService.getByGlossaryIdLocaleCode(glossaryId,
			localeCode);
	}

	@Override
	public com.ihg.brandstandards.db.model.GlossaryTranslate getGlossaryByLangCd(
		long glossaryId, java.lang.String langCode) {
		return _glossaryTranslateLocalService.getGlossaryByLangCd(glossaryId,
			langCode);
	}

	/**
	* Get lsit GlosasryTranslate by localeCode.
	*
	* @param regionId Regionid.
	* @return List<GlossaryTranslate> List<GlossaryTranslate>.
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.GlossaryTranslate> getByLocaleCode(
		java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryTranslateLocalService.getByLocaleCode(localeCode);
	}

	/**
	* Remove Glossay translate entry from database by passing glossary Id
	*
	* @param glossaryId Glossary Id to passed for which translate need to delete.
	* @throws SystemException SystemException throws if system request is fail.
	*/
	@Override
	public void removeGlossaryTranslateByGlossaryId(long glossaryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_glossaryTranslateLocalService.removeGlossaryTranslateByGlossaryId(glossaryId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GlossaryTranslateLocalService getWrappedGlossaryTranslateLocalService() {
		return _glossaryTranslateLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGlossaryTranslateLocalService(
		GlossaryTranslateLocalService glossaryTranslateLocalService) {
		_glossaryTranslateLocalService = glossaryTranslateLocalService;
	}

	@Override
	public GlossaryTranslateLocalService getWrappedService() {
		return _glossaryTranslateLocalService;
	}

	@Override
	public void setWrappedService(
		GlossaryTranslateLocalService glossaryTranslateLocalService) {
		_glossaryTranslateLocalService = glossaryTranslateLocalService;
	}

	private GlossaryTranslateLocalService _glossaryTranslateLocalService;
}