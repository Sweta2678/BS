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
 * Provides a wrapper for {@link StandardsLocalService}.
 *
 * @author Mummanedi
 * @see StandardsLocalService
 * @generated
 */
public class StandardsLocalServiceWrapper implements StandardsLocalService,
	ServiceWrapper<StandardsLocalService> {
	public StandardsLocalServiceWrapper(
		StandardsLocalService standardsLocalService) {
		_standardsLocalService = standardsLocalService;
	}

	/**
	* Adds the standards to the database. Also notifies the appropriate model listeners.
	*
	* @param standards the standards
	* @return the standards that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.Standards addStandards(
		com.ihg.brandstandards.db.model.Standards standards)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.addStandards(standards);
	}

	/**
	* Creates a new standards with the primary key. Does not add the standards to the database.
	*
	* @param stdId the primary key for the new standards
	* @return the new standards
	*/
	@Override
	public com.ihg.brandstandards.db.model.Standards createStandards(long stdId) {
		return _standardsLocalService.createStandards(stdId);
	}

	/**
	* Deletes the standards with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stdId the primary key of the standards
	* @return the standards that was removed
	* @throws PortalException if a standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.Standards deleteStandards(long stdId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.deleteStandards(stdId);
	}

	/**
	* Deletes the standards from the database. Also notifies the appropriate model listeners.
	*
	* @param standards the standards
	* @return the standards that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.Standards deleteStandards(
		com.ihg.brandstandards.db.model.Standards standards)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.deleteStandards(standards);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _standardsLocalService.dynamicQuery();
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
		return _standardsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _standardsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _standardsLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _standardsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _standardsLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.Standards fetchStandards(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.fetchStandards(stdId);
	}

	/**
	* Returns the standards with the primary key.
	*
	* @param stdId the primary key of the standards
	* @return the standards
	* @throws PortalException if a standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.Standards getStandards(long stdId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.getStandards(stdId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standardses
	* @param end the upper bound of the range of standardses (not inclusive)
	* @return the range of standardses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Standards> getStandardses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.getStandardses(start, end);
	}

	/**
	* Returns the number of standardses.
	*
	* @return the number of standardses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getStandardsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.getStandardsesCount();
	}

	/**
	* Updates the standards in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param standards the standards
	* @return the standards that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.Standards updateStandards(
		com.ihg.brandstandards.db.model.Standards standards)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.updateStandards(standards);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _standardsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_standardsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _standardsLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void clearCache() {
		_standardsLocalService.clearCache();
	}

	/**
	* Fetch Standards
	*
	* @param approverFlag
	* @return List of Standards
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Standards> getStandards(
		boolean approverFlag, java.lang.String brandCode,
		java.lang.String discontFilter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.getStandards(approverFlag, brandCode,
			discontFilter);
	}

	/**
	* Fetch Specifications for the Standard
	*
	* @return List of Specifications
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Standards> getSpecifications(
		long standardsId, boolean approverFlag, java.lang.String brandCode,
		java.lang.String discontFilter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.getSpecifications(standardsId,
			approverFlag, brandCode, discontFilter);
	}

	/**
	* @param standardsId
	* @param approverFlag
	* @param brandCode
	* @param fetchAll
	* @return
	* @throws SystemException
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Standards> getSpecifications(
		long standardsId, boolean approverFlag, java.lang.String brandCode,
		boolean fetchAll, java.lang.String discontFilter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.getSpecifications(standardsId,
			approverFlag, brandCode, fetchAll, discontFilter);
	}

	/**
	* Fetch Guidelines for the Standard
	*
	* @return List of Guidelines
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Standards> getGuidelines(
		long standardsId, boolean approverFlag, java.lang.String brandCode,
		java.lang.String discontFilter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.getGuidelines(standardsId, approverFlag,
			brandCode, discontFilter);
	}

	/**
	* @param standardsId
	* @param approverFlag
	* @param brandCode
	* @param fetchAll
	* @return
	* @throws SystemException
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Standards> getGuidelines(
		long standardsId, boolean approverFlag, java.lang.String brandCode,
		boolean fetchAll, java.lang.String discontFilter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.getGuidelines(standardsId, approverFlag,
			brandCode, fetchAll, discontFilter);
	}

	/**
	* Fetch records count by record type
	*
	* @return count of records
	*/
	@Override
	public long getStdTypeCount(java.lang.String typ)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.getStdTypeCount(typ);
	}

	/**
	* Count specified record type for approver
	*
	* @return count
	*/
	@Override
	public int getStdTypeCount(java.lang.String typ, boolean approver)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.getStdTypeCount(typ, approver);
	}

	/**
	* Fetch records by record type
	*
	* @return List of records
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Standards> getStdTypeList(
		java.lang.String typ)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.getStdTypeList(typ);
	}

	/**
	* Fetch records by record type for approver
	*
	* @return List of records
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Standards> getStdTypeList(
		java.lang.String typ, boolean approver)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.getStdTypeList(typ, approver);
	}

	/**
	* Fetch Standards for the filter
	*
	* @return List of Standards
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Standards> getStandardsAdvancedFilterResults(
		java.util.Map<java.lang.String, ?> criteriaMap, boolean approverFlag,
		java.lang.String standardId, java.lang.String stdType,
		java.lang.String preferBrand, java.lang.String discontFilter) {
		return _standardsLocalService.getStandardsAdvancedFilterResults(criteriaMap,
			approverFlag, standardId, stdType, preferBrand, discontFilter);
	}

	/**
	* Fetch Specifications for the filter
	*
	* @return List of Specifications
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Standards> getSpecificationsFilterResults(
		java.util.Map<java.lang.String, ?> criteriaMap, boolean approverFlag,
		java.lang.String standardId, java.lang.String stdType,
		java.lang.String preferBrand, java.lang.String discontFilter,
		java.util.List<java.lang.Long> prntStdIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.getSpecificationsFilterResults(criteriaMap,
			approverFlag, standardId, stdType, preferBrand, discontFilter,
			prntStdIds);
	}

	/**
	* Fetch Guidelines for the filter
	*
	* @return List of Guidelines
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Standards> getGuidelinesFilterResults(
		java.util.Map<java.lang.String, ?> criteriaMap, boolean approverFlag,
		java.lang.String standardId, java.lang.String stdType,
		java.lang.String preferBrand, java.lang.String discontFilter,
		java.util.List<java.lang.Long> prntStdIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.getGuidelinesFilterResults(criteriaMap,
			approverFlag, standardId, stdType, preferBrand, discontFilter,
			prntStdIds);
	}

	/**
	* Fetch Specifications for the filter
	*
	* @return List of Specifications
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Standards> getSearchSpecificationsFilterResults(
		java.util.Map<java.lang.String, ?> criteriaMap, boolean approverFlag,
		java.lang.String standardId, java.lang.String stdType,
		java.lang.String preferBrand, java.lang.String discontFilter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.getSearchSpecificationsFilterResults(criteriaMap,
			approverFlag, standardId, stdType, preferBrand, discontFilter);
	}

	/**
	* Fetch Guidelines for the filter
	*
	* @return List of Guidelines
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Standards> getSearchGuidelinesFilterResults(
		java.util.Map<java.lang.String, ?> criteriaMap, boolean approverFlag,
		java.lang.String standardId, java.lang.String stdType,
		java.lang.String preferBrand, java.lang.String discontFitler)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.getSearchGuidelinesFilterResults(criteriaMap,
			approverFlag, standardId, stdType, preferBrand, discontFitler);
	}

	/**
	* Fetch Standards
	*
	* @return List of Specifications
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Standards> getStandardsByTaxonomyId(
		long taxonomyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.getStandardsByTaxonomyId(taxonomyId);
	}

	/**
	* @param stdId
	* @param regionCode
	* @param brands
	* @return
	* @throws SystemException
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Standards> getSTD(
		long stdId, java.lang.String regionCode, java.lang.String[] brands)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.getSTD(stdId, regionCode, brands);
	}

	/**
	* @param stdId
	* @return
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Standards> getCrossStandards(
		long stdId) {
		return _standardsLocalService.getCrossStandards(stdId);
	}

	/**
	* Get Standards by Standard Id and Record Type
	*
	* @param stdId
	* @param guideLine
	* @return
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Standards> getStandardsByStdIdRecordType(
		long stdId, java.lang.String recordType) {
		return _standardsLocalService.getStandardsByStdIdRecordType(stdId,
			recordType);
	}

	/**
	* Set Standards status to unlock
	*
	* @exception SystemException exception
	*/
	@Override
	public void setStandardsStatusUnlock(java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		_standardsLocalService.setStandardsStatusUnlock(chainCode);
	}

	/**
	* Get Locked Standards count
	*
	* @return count
	*/
	@Override
	public long getLockedStandardsCount(java.lang.String chainCode) {
		return _standardsLocalService.getLockedStandardsCount(chainCode);
	}

	/**
	* Find Standards by Author Name.
	*
	* @param authorName author name
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Standards> getStandardsByAuthor(
		java.lang.String authorName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.getStandardsByAuthor(authorName);
	}

	/**
	* Find Standards by Owner Name.
	*
	* @param ownerName owner name
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Standards> getStandardsByOwner(
		java.lang.String ownerName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.getStandardsByOwner(ownerName);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Standards> getStandardsByParent(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.getStandardsByParent(stdId);
	}

	@Override
	public java.util.List<java.lang.Long> getStandardsByRegion(long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.getStandardsByRegion(regionId);
	}

	/**
	* Find Spec/GDLN by Parent stdId.
	*
	* @param stdId
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Standards> getByParentId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.getByParentId(stdId);
	}

	/**
	* Find standards by region code and parent id.
	*
	* @param regionCode
	* @param prnt_std_id
	* @return List<Standards>
	* @throws SystemException
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Standards> getByRegionCodeAndParentId(
		java.lang.String regionCode, long prnt_std_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.getByRegionCodeAndParentId(regionCode,
			prnt_std_id);
	}

	@Override
	public void unLockRecords(java.lang.String stdIds,
		java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		_standardsLocalService.unLockRecords(stdIds, chainCode);
	}

	@Override
	public void lockRecords(java.lang.String stdIds, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		_standardsLocalService.lockRecords(stdIds, chainCode);
	}

	/**
	* @param stdId
	* @param regionId
	* @param chainCode
	* @return List<Standards>
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Standards> getStandardsByChainAndRegion(
		long stdId, long regionId, java.lang.String regionCode,
		java.lang.String chainCode, java.lang.String stdType) {
		return _standardsLocalService.getStandardsByChainAndRegion(stdId,
			regionId, regionCode, chainCode, stdType);
	}

	/**
	* This method will return the counter result of query (Ex:SELECT MAX(std_id) FROM STD)
	*
	* @param query
	* @return
	*/
	@Override
	public long getTableSequenceEntryCount(java.lang.String query) {
		return _standardsLocalService.getTableSequenceEntryCount(query);
	}

	/**
	* Get active Bridge Publish Ids for specified standard id.
	*
	* @param stdId standard id
	* @return String
	*/
	@Override
	public java.util.List<java.lang.Long> getBridgePublishIdsByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsLocalService.getBridgePublishIdsByStdId(stdId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public StandardsLocalService getWrappedStandardsLocalService() {
		return _standardsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedStandardsLocalService(
		StandardsLocalService standardsLocalService) {
		_standardsLocalService = standardsLocalService;
	}

	@Override
	public StandardsLocalService getWrappedService() {
		return _standardsLocalService;
	}

	@Override
	public void setWrappedService(StandardsLocalService standardsLocalService) {
		_standardsLocalService = standardsLocalService;
	}

	private StandardsLocalService _standardsLocalService;
}