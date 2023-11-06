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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Standards. This utility wraps
 * {@link com.ihg.brandstandards.db.service.impl.StandardsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mummanedi
 * @see StandardsLocalService
 * @see com.ihg.brandstandards.db.service.base.StandardsLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.StandardsLocalServiceImpl
 * @generated
 */
public class StandardsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.StandardsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the standards to the database. Also notifies the appropriate model listeners.
	*
	* @param standards the standards
	* @return the standards that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Standards addStandards(
		com.ihg.brandstandards.db.model.Standards standards)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addStandards(standards);
	}

	/**
	* Creates a new standards with the primary key. Does not add the standards to the database.
	*
	* @param stdId the primary key for the new standards
	* @return the new standards
	*/
	public static com.ihg.brandstandards.db.model.Standards createStandards(
		long stdId) {
		return getService().createStandards(stdId);
	}

	/**
	* Deletes the standards with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stdId the primary key of the standards
	* @return the standards that was removed
	* @throws PortalException if a standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Standards deleteStandards(
		long stdId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStandards(stdId);
	}

	/**
	* Deletes the standards from the database. Also notifies the appropriate model listeners.
	*
	* @param standards the standards
	* @return the standards that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Standards deleteStandards(
		com.ihg.brandstandards.db.model.Standards standards)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStandards(standards);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.ihg.brandstandards.db.model.Standards fetchStandards(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchStandards(stdId);
	}

	/**
	* Returns the standards with the primary key.
	*
	* @param stdId the primary key of the standards
	* @return the standards
	* @throws PortalException if a standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Standards getStandards(
		long stdId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandards(stdId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.ihg.brandstandards.db.model.Standards> getStandardses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardses(start, end);
	}

	/**
	* Returns the number of standardses.
	*
	* @return the number of standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int getStandardsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardsesCount();
	}

	/**
	* Updates the standards in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param standards the standards
	* @return the standards that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Standards updateStandards(
		com.ihg.brandstandards.db.model.Standards standards)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateStandards(standards);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearCache() {
		getService().clearCache();
	}

	/**
	* Fetch Standards
	*
	* @param approverFlag
	* @return List of Standards
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Standards> getStandards(
		boolean approverFlag, java.lang.String brandCode,
		java.lang.String discontFilter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandards(approverFlag, brandCode, discontFilter);
	}

	/**
	* Fetch Specifications for the Standard
	*
	* @return List of Specifications
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Standards> getSpecifications(
		long standardsId, boolean approverFlag, java.lang.String brandCode,
		java.lang.String discontFilter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSpecifications(standardsId, approverFlag, brandCode,
			discontFilter);
	}

	/**
	* @param standardsId
	* @param approverFlag
	* @param brandCode
	* @param fetchAll
	* @return
	* @throws SystemException
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Standards> getSpecifications(
		long standardsId, boolean approverFlag, java.lang.String brandCode,
		boolean fetchAll, java.lang.String discontFilter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSpecifications(standardsId, approverFlag, brandCode,
			fetchAll, discontFilter);
	}

	/**
	* Fetch Guidelines for the Standard
	*
	* @return List of Guidelines
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Standards> getGuidelines(
		long standardsId, boolean approverFlag, java.lang.String brandCode,
		java.lang.String discontFilter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getGuidelines(standardsId, approverFlag, brandCode,
			discontFilter);
	}

	/**
	* @param standardsId
	* @param approverFlag
	* @param brandCode
	* @param fetchAll
	* @return
	* @throws SystemException
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Standards> getGuidelines(
		long standardsId, boolean approverFlag, java.lang.String brandCode,
		boolean fetchAll, java.lang.String discontFilter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getGuidelines(standardsId, approverFlag, brandCode,
			fetchAll, discontFilter);
	}

	/**
	* Fetch records count by record type
	*
	* @return count of records
	*/
	public static long getStdTypeCount(java.lang.String typ)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStdTypeCount(typ);
	}

	/**
	* Count specified record type for approver
	*
	* @return count
	*/
	public static int getStdTypeCount(java.lang.String typ, boolean approver)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStdTypeCount(typ, approver);
	}

	/**
	* Fetch records by record type
	*
	* @return List of records
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Standards> getStdTypeList(
		java.lang.String typ)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStdTypeList(typ);
	}

	/**
	* Fetch records by record type for approver
	*
	* @return List of records
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Standards> getStdTypeList(
		java.lang.String typ, boolean approver)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStdTypeList(typ, approver);
	}

	/**
	* Fetch Standards for the filter
	*
	* @return List of Standards
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Standards> getStandardsAdvancedFilterResults(
		java.util.Map<java.lang.String, ?> criteriaMap, boolean approverFlag,
		java.lang.String standardId, java.lang.String stdType,
		java.lang.String preferBrand, java.lang.String discontFilter) {
		return getService()
				   .getStandardsAdvancedFilterResults(criteriaMap,
			approverFlag, standardId, stdType, preferBrand, discontFilter);
	}

	/**
	* Fetch Specifications for the filter
	*
	* @return List of Specifications
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Standards> getSpecificationsFilterResults(
		java.util.Map<java.lang.String, ?> criteriaMap, boolean approverFlag,
		java.lang.String standardId, java.lang.String stdType,
		java.lang.String preferBrand, java.lang.String discontFilter,
		java.util.List<java.lang.Long> prntStdIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSpecificationsFilterResults(criteriaMap, approverFlag,
			standardId, stdType, preferBrand, discontFilter, prntStdIds);
	}

	/**
	* Fetch Guidelines for the filter
	*
	* @return List of Guidelines
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Standards> getGuidelinesFilterResults(
		java.util.Map<java.lang.String, ?> criteriaMap, boolean approverFlag,
		java.lang.String standardId, java.lang.String stdType,
		java.lang.String preferBrand, java.lang.String discontFilter,
		java.util.List<java.lang.Long> prntStdIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getGuidelinesFilterResults(criteriaMap, approverFlag,
			standardId, stdType, preferBrand, discontFilter, prntStdIds);
	}

	/**
	* Fetch Specifications for the filter
	*
	* @return List of Specifications
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Standards> getSearchSpecificationsFilterResults(
		java.util.Map<java.lang.String, ?> criteriaMap, boolean approverFlag,
		java.lang.String standardId, java.lang.String stdType,
		java.lang.String preferBrand, java.lang.String discontFilter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSearchSpecificationsFilterResults(criteriaMap,
			approverFlag, standardId, stdType, preferBrand, discontFilter);
	}

	/**
	* Fetch Guidelines for the filter
	*
	* @return List of Guidelines
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Standards> getSearchGuidelinesFilterResults(
		java.util.Map<java.lang.String, ?> criteriaMap, boolean approverFlag,
		java.lang.String standardId, java.lang.String stdType,
		java.lang.String preferBrand, java.lang.String discontFitler)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSearchGuidelinesFilterResults(criteriaMap, approverFlag,
			standardId, stdType, preferBrand, discontFitler);
	}

	/**
	* Fetch Standards
	*
	* @return List of Specifications
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Standards> getStandardsByTaxonomyId(
		long taxonomyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardsByTaxonomyId(taxonomyId);
	}

	/**
	* @param stdId
	* @param regionCode
	* @param brands
	* @return
	* @throws SystemException
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Standards> getSTD(
		long stdId, java.lang.String regionCode, java.lang.String[] brands)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSTD(stdId, regionCode, brands);
	}

	/**
	* @param stdId
	* @return
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Standards> getCrossStandards(
		long stdId) {
		return getService().getCrossStandards(stdId);
	}

	/**
	* Get Standards by Standard Id and Record Type
	*
	* @param stdId
	* @param guideLine
	* @return
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Standards> getStandardsByStdIdRecordType(
		long stdId, java.lang.String recordType) {
		return getService().getStandardsByStdIdRecordType(stdId, recordType);
	}

	/**
	* Set Standards status to unlock
	*
	* @exception SystemException exception
	*/
	public static void setStandardsStatusUnlock(java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().setStandardsStatusUnlock(chainCode);
	}

	/**
	* Get Locked Standards count
	*
	* @return count
	*/
	public static long getLockedStandardsCount(java.lang.String chainCode) {
		return getService().getLockedStandardsCount(chainCode);
	}

	/**
	* Find Standards by Author Name.
	*
	* @param authorName author name
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Standards> getStandardsByAuthor(
		java.lang.String authorName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardsByAuthor(authorName);
	}

	/**
	* Find Standards by Owner Name.
	*
	* @param ownerName owner name
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Standards> getStandardsByOwner(
		java.lang.String ownerName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardsByOwner(ownerName);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.Standards> getStandardsByParent(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardsByParent(stdId);
	}

	public static java.util.List<java.lang.Long> getStandardsByRegion(
		long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardsByRegion(regionId);
	}

	/**
	* Find Spec/GDLN by Parent stdId.
	*
	* @param stdId
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Standards> getByParentId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByParentId(stdId);
	}

	/**
	* Find standards by region code and parent id.
	*
	* @param regionCode
	* @param prnt_std_id
	* @return List<Standards>
	* @throws SystemException
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Standards> getByRegionCodeAndParentId(
		java.lang.String regionCode, long prnt_std_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByRegionCodeAndParentId(regionCode, prnt_std_id);
	}

	public static void unLockRecords(java.lang.String stdIds,
		java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().unLockRecords(stdIds, chainCode);
	}

	public static void lockRecords(java.lang.String stdIds,
		java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().lockRecords(stdIds, chainCode);
	}

	/**
	* @param stdId
	* @param regionId
	* @param chainCode
	* @return List<Standards>
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Standards> getStandardsByChainAndRegion(
		long stdId, long regionId, java.lang.String regionCode,
		java.lang.String chainCode, java.lang.String stdType) {
		return getService()
				   .getStandardsByChainAndRegion(stdId, regionId, regionCode,
			chainCode, stdType);
	}

	/**
	* This method will return the counter result of query (Ex:SELECT MAX(std_id) FROM STD)
	*
	* @param query
	* @return
	*/
	public static long getTableSequenceEntryCount(java.lang.String query) {
		return getService().getTableSequenceEntryCount(query);
	}

	/**
	* Get active Bridge Publish Ids for specified standard id.
	*
	* @param stdId standard id
	* @return String
	*/
	public static java.util.List<java.lang.Long> getBridgePublishIdsByStdId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBridgePublishIdsByStdId(stdId);
	}

	public static void clearService() {
		_service = null;
	}

	public static StandardsLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					StandardsLocalService.class.getName());

			if (invokableLocalService instanceof StandardsLocalService) {
				_service = (StandardsLocalService)invokableLocalService;
			}
			else {
				_service = new StandardsLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(StandardsLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(StandardsLocalService service) {
	}

	private static StandardsLocalService _service;
}