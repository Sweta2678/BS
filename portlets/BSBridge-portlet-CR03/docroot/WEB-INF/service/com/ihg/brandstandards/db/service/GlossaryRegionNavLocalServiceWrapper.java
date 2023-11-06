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
 * Provides a wrapper for {@link GlossaryRegionNavLocalService}.
 *
 * @author Mummanedi
 * @see GlossaryRegionNavLocalService
 * @generated
 */
public class GlossaryRegionNavLocalServiceWrapper
	implements GlossaryRegionNavLocalService,
		ServiceWrapper<GlossaryRegionNavLocalService> {
	public GlossaryRegionNavLocalServiceWrapper(
		GlossaryRegionNavLocalService glossaryRegionNavLocalService) {
		_glossaryRegionNavLocalService = glossaryRegionNavLocalService;
	}

	/**
	* Adds the glossary region nav to the database. Also notifies the appropriate model listeners.
	*
	* @param glossaryRegionNav the glossary region nav
	* @return the glossary region nav that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GlossaryRegionNav addGlossaryRegionNav(
		com.ihg.brandstandards.db.model.GlossaryRegionNav glossaryRegionNav)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryRegionNavLocalService.addGlossaryRegionNav(glossaryRegionNav);
	}

	/**
	* Creates a new glossary region nav with the primary key. Does not add the glossary region nav to the database.
	*
	* @param glossaryRgnNavId the primary key for the new glossary region nav
	* @return the new glossary region nav
	*/
	@Override
	public com.ihg.brandstandards.db.model.GlossaryRegionNav createGlossaryRegionNav(
		long glossaryRgnNavId) {
		return _glossaryRegionNavLocalService.createGlossaryRegionNav(glossaryRgnNavId);
	}

	/**
	* Deletes the glossary region nav with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param glossaryRgnNavId the primary key of the glossary region nav
	* @return the glossary region nav that was removed
	* @throws PortalException if a glossary region nav with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GlossaryRegionNav deleteGlossaryRegionNav(
		long glossaryRgnNavId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _glossaryRegionNavLocalService.deleteGlossaryRegionNav(glossaryRgnNavId);
	}

	/**
	* Deletes the glossary region nav from the database. Also notifies the appropriate model listeners.
	*
	* @param glossaryRegionNav the glossary region nav
	* @return the glossary region nav that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GlossaryRegionNav deleteGlossaryRegionNav(
		com.ihg.brandstandards.db.model.GlossaryRegionNav glossaryRegionNav)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryRegionNavLocalService.deleteGlossaryRegionNav(glossaryRegionNav);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _glossaryRegionNavLocalService.dynamicQuery();
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
		return _glossaryRegionNavLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryRegionNavModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _glossaryRegionNavLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryRegionNavModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _glossaryRegionNavLocalService.dynamicQuery(dynamicQuery, start,
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
		return _glossaryRegionNavLocalService.dynamicQueryCount(dynamicQuery);
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
		return _glossaryRegionNavLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.GlossaryRegionNav fetchGlossaryRegionNav(
		long glossaryRgnNavId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryRegionNavLocalService.fetchGlossaryRegionNav(glossaryRgnNavId);
	}

	/**
	* Returns the glossary region nav with the primary key.
	*
	* @param glossaryRgnNavId the primary key of the glossary region nav
	* @return the glossary region nav
	* @throws PortalException if a glossary region nav with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GlossaryRegionNav getGlossaryRegionNav(
		long glossaryRgnNavId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _glossaryRegionNavLocalService.getGlossaryRegionNav(glossaryRgnNavId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _glossaryRegionNavLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the glossary region navs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryRegionNavModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of glossary region navs
	* @param end the upper bound of the range of glossary region navs (not inclusive)
	* @return the range of glossary region navs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.GlossaryRegionNav> getGlossaryRegionNavs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryRegionNavLocalService.getGlossaryRegionNavs(start, end);
	}

	/**
	* Returns the number of glossary region navs.
	*
	* @return the number of glossary region navs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGlossaryRegionNavsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryRegionNavLocalService.getGlossaryRegionNavsCount();
	}

	/**
	* Updates the glossary region nav in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param glossaryRegionNav the glossary region nav
	* @return the glossary region nav that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.GlossaryRegionNav updateGlossaryRegionNav(
		com.ihg.brandstandards.db.model.GlossaryRegionNav glossaryRegionNav)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryRegionNavLocalService.updateGlossaryRegionNav(glossaryRegionNav);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _glossaryRegionNavLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_glossaryRegionNavLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _glossaryRegionNavLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void clearCache() {
		_glossaryRegionNavLocalService.clearCache();
	}

	/**
	* Get list of @GlossaryRegionNav object by glossaryId.
	*
	* @param glossaryId GlossaryId of selected Glossary.
	* @return List of @GlossaryRegionNav object.
	* @throws SystemException SystemException throws if system request is fail.
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.GlossaryRegionNav> getRegionNavsByGlossaryId(
		long glossaryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryRegionNavLocalService.getRegionNavsByGlossaryId(glossaryId);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.GlossaryRegionNav> getAllRegionNavs(
		long regionId, java.lang.String status, java.lang.String termChar) {
		return _glossaryRegionNavLocalService.getAllRegionNavs(regionId,
			status, termChar);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.GlossaryRegionNav> getAllRegionNavs(
		long regionId, java.lang.String chainCode, java.lang.String status,
		java.lang.String termChar) {
		return _glossaryRegionNavLocalService.getAllRegionNavs(regionId,
			chainCode, status, termChar);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.GlossaryRegionNav> getAllRegionGlossaries(
		long regionId, java.lang.String chainCode, java.lang.String status) {
		return _glossaryRegionNavLocalService.getAllRegionGlossaries(regionId,
			chainCode, status);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.GlossaryRegionNav> getAllRegionGlossaries(
		long regionId, java.lang.String status) {
		return _glossaryRegionNavLocalService.getAllRegionGlossaries(regionId,
			status);
	}

	/**
	* Get List<GlossaryRegionNav> by Glossaryid, RegionId.
	*
	* @param glossaryId Glossaryid.
	* @param regionId Regionid.
	* @throws SystemException SystemException.
	* @return List<GlossaryRegionNav> List<GlossaryRegionNav>.
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.GlossaryRegionNav> getListByGlossaryIdAndReginoId(
		long glossaryId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryRegionNavLocalService.getListByGlossaryIdAndReginoId(glossaryId,
			regionId);
	}

	/**
	* Get Brand comma seprate by Glossaryid and Regionid.
	*
	* @param glossaryId Glossaryid.
	* @param regionId Regionid.
	* @throws SystemException SystemException.
	* @return String String.
	*/
	@Override
	public java.lang.String getRegionCodesByglossaryIdAndRegionId(
		long glossaryId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryRegionNavLocalService.getRegionCodesByglossaryIdAndRegionId(glossaryId,
			regionId);
	}

	/**
	* Get GlossaryRegionNav by Glossaryid, Regionid, and ChainCode.
	*
	* @param glossaryId Glossaryid.
	* @param regionId Regionid.
	* @param chainCode ChainCode.
	* @throws NoSuchGlossaryRegionNavException NoSuchGlossaryRegionNavException.
	* @throws SystemException SystemException.
	* @return GlossaryRegionNav GlossaryRegionNav.
	*/
	@Override
	public com.ihg.brandstandards.db.model.GlossaryRegionNav getGlossaryRegionNavByGlossaryIdRegionIdChainCode(
		long glossaryId, long regionId, java.lang.String chainCode)
		throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException,
			com.liferay.portal.kernel.exception.SystemException {
		return _glossaryRegionNavLocalService.getGlossaryRegionNavByGlossaryIdRegionIdChainCode(glossaryId,
			regionId, chainCode);
	}

	/**
	* Delete GlossaryRegionNav by Glossaryid, Regionid, and ChainCode.
	*
	* @see com.ihg.brandstandards.db.service.GlossaryRegionNavLocalService#removeByGlossaryIdRegionIdChainCode(long,
	long, java.lang.String)
	* @param glossaryId Glossaryid.
	* @param regionId Regionid.
	* @param chainCode ChainCode.
	* @throws NoSuchGlossaryRegionNavException NoSuchGlossaryRegionNavException.
	* @throws SystemException SystemException.
	* @return void void.
	*/
	@Override
	public void removeByGlossaryIdRegionIdChainCode(long glossaryId,
		long regionId, java.lang.String chainCode)
		throws com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException,
			com.liferay.portal.kernel.exception.SystemException {
		_glossaryRegionNavLocalService.removeByGlossaryIdRegionIdChainCode(glossaryId,
			regionId, chainCode);
	}

	/**
	* Get list of object of @GlossaryRegionNav by passing chaincode, navItemText.
	*
	* @param chainCode User selected chain code.
	* @param navItemText User selected glossary Nav text.
	* @return List of @GlossaryRegionNav object.
	* @throws SystemException SystemException throws if system request is fail.
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.GlossaryRegionNav> getGlossayByBrand(
		java.lang.String chainCode, java.lang.String navItemText)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _glossaryRegionNavLocalService.getGlossayByBrand(chainCode,
			navItemText);
	}

	/**
	* Remove Glossay Region Nav entry from database by passing glossary Id
	*
	* @param glossaryId Glossary Id to passed for which region nav entry need to delete.
	* @throws SystemException SystemException throws if system request is fail.
	*/
	@Override
	public void removeGlossayRegionByGlossayId(long glossaryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_glossaryRegionNavLocalService.removeGlossayRegionByGlossayId(glossaryId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GlossaryRegionNavLocalService getWrappedGlossaryRegionNavLocalService() {
		return _glossaryRegionNavLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGlossaryRegionNavLocalService(
		GlossaryRegionNavLocalService glossaryRegionNavLocalService) {
		_glossaryRegionNavLocalService = glossaryRegionNavLocalService;
	}

	@Override
	public GlossaryRegionNavLocalService getWrappedService() {
		return _glossaryRegionNavLocalService;
	}

	@Override
	public void setWrappedService(
		GlossaryRegionNavLocalService glossaryRegionNavLocalService) {
		_glossaryRegionNavLocalService = glossaryRegionNavLocalService;
	}

	private GlossaryRegionNavLocalService _glossaryRegionNavLocalService;
}