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
 * Provides the local service utility for PublishedPdfList. This utility wraps
 * {@link com.ihg.brandstandards.db.service.impl.PublishedPdfListLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mummanedi
 * @see PublishedPdfListLocalService
 * @see com.ihg.brandstandards.db.service.base.PublishedPdfListLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.PublishedPdfListLocalServiceImpl
 * @generated
 */
public class PublishedPdfListLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.PublishedPdfListLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the published pdf list to the database. Also notifies the appropriate model listeners.
	*
	* @param publishedPdfList the published pdf list
	* @return the published pdf list that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList addPublishedPdfList(
		com.ihg.brandstandards.db.model.PublishedPdfList publishedPdfList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPublishedPdfList(publishedPdfList);
	}

	/**
	* Creates a new published pdf list with the primary key. Does not add the published pdf list to the database.
	*
	* @param pdfId the primary key for the new published pdf list
	* @return the new published pdf list
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList createPublishedPdfList(
		long pdfId) {
		return getService().createPublishedPdfList(pdfId);
	}

	/**
	* Deletes the published pdf list with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pdfId the primary key of the published pdf list
	* @return the published pdf list that was removed
	* @throws PortalException if a published pdf list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList deletePublishedPdfList(
		long pdfId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePublishedPdfList(pdfId);
	}

	/**
	* Deletes the published pdf list from the database. Also notifies the appropriate model listeners.
	*
	* @param publishedPdfList the published pdf list
	* @return the published pdf list that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList deletePublishedPdfList(
		com.ihg.brandstandards.db.model.PublishedPdfList publishedPdfList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePublishedPdfList(publishedPdfList);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.ihg.brandstandards.db.model.PublishedPdfList fetchPublishedPdfList(
		long pdfId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPublishedPdfList(pdfId);
	}

	/**
	* Returns the published pdf list with the primary key.
	*
	* @param pdfId the primary key of the published pdf list
	* @return the published pdf list
	* @throws PortalException if a published pdf list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList getPublishedPdfList(
		long pdfId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPublishedPdfList(pdfId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the published pdf lists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of published pdf lists
	* @param end the upper bound of the range of published pdf lists (not inclusive)
	* @return the range of published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> getPublishedPdfLists(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPublishedPdfLists(start, end);
	}

	/**
	* Returns the number of published pdf lists.
	*
	* @return the number of published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static int getPublishedPdfListsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPublishedPdfListsCount();
	}

	/**
	* Updates the published pdf list in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param publishedPdfList the published pdf list
	* @return the published pdf list that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList updatePublishedPdfList(
		com.ihg.brandstandards.db.model.PublishedPdfList publishedPdfList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePublishedPdfList(publishedPdfList);
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

	public static com.ihg.brandstandards.db.model.PublishedPdfList addPublishedPdfList(
		java.lang.String pdfChainCode, java.lang.String pdfCtryCode,
		java.lang.String pdfBuildType, int pdfYearNumber,
		java.lang.String pdfLocaleCode, long pdfVersionNumber,
		java.lang.String pdfFileName, java.lang.String pdfFileURLText,
		long publishId, java.lang.String pageSizeOrientationType,
		java.lang.String createdBy, java.util.Date createDate,
		java.lang.String updatedBy, java.util.Date updateDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addPublishedPdfList(pdfChainCode, pdfCtryCode,
			pdfBuildType, pdfYearNumber, pdfLocaleCode, pdfVersionNumber,
			pdfFileName, pdfFileURLText, publishId, pageSizeOrientationType,
			createdBy, createDate, updatedBy, updateDate);
	}

	public static com.ihg.brandstandards.db.model.PublishedPdfList updatePublishedPdfList(
		long pdfId, java.lang.String pdfChainCode,
		java.lang.String pdfCtryCode, java.lang.String pdfBuildType,
		int pdfYearNumber, java.lang.String pdfLocaleCode,
		long pdfVersionNumber, java.lang.String pdfFileName,
		java.lang.String pdfFileURLText, long publishId,
		java.lang.String pageSizeOrientationType, java.lang.String createdBy,
		java.util.Date createDate, java.lang.String updatedBy,
		java.util.Date updateDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updatePublishedPdfList(pdfId, pdfChainCode, pdfCtryCode,
			pdfBuildType, pdfYearNumber, pdfLocaleCode, pdfVersionNumber,
			pdfFileName, pdfFileURLText, publishId, pageSizeOrientationType,
			createdBy, createDate, updatedBy, updateDate);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> getByPdfChainCode(
		java.lang.String pdfChainCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getByPdfChainCode(pdfChainCode);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> getByPdfCtryCode(
		java.lang.String pdfCtryCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getByPdfCtryCode(pdfCtryCode);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> getByPdfFileName(
		java.lang.String pdfFileName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getByPdfFileName(pdfFileName);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> getByPdfFileURLText(
		java.lang.String pdfFileURLText)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getByPdfFileURLText(pdfFileURLText);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> getByPdfFileNameAndURL(
		java.lang.String pdfFileName, java.lang.String pdfFileURLText)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getByPdfFileNameAndURL(pdfFileName, pdfFileURLText);
	}

	public static com.ihg.brandstandards.db.model.PublishedPdfList getByPdfManualParams(
		long publishId, java.lang.String pdfCtryCode,
		java.lang.String pdfLocaleCode, java.lang.String pdfBuildType,
		java.lang.String pageSizeOrientationType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getByPdfManualParams(publishId, pdfCtryCode, pdfLocaleCode,
			pdfBuildType, pageSizeOrientationType);
	}

	public static java.lang.String getPublishedPDFFullManualURL(
		long publishId, java.lang.String pdfCtryCode,
		java.lang.String pdfLocaleCode, java.lang.String pdfBuildType,
		java.lang.String pageSizeOrientationType) {
		return getService()
				   .getPublishedPDFFullManualURL(publishId, pdfCtryCode,
			pdfLocaleCode, pdfBuildType, pageSizeOrientationType);
	}

	public static java.util.Map<java.lang.String, java.util.LinkedHashMap<java.lang.String, java.lang.String>> getPublishedPDFListByParams(
		long publishId, java.lang.String pdfCtryCode,
		java.util.List<java.lang.String> pdfBuildTypes,
		java.lang.String pageSizeOrientationType) {
		return getService()
				   .getPublishedPDFListByParams(publishId, pdfCtryCode,
			pdfBuildTypes, pageSizeOrientationType);
	}

	public static void clearService() {
		_service = null;
	}

	public static PublishedPdfListLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PublishedPdfListLocalService.class.getName());

			if (invokableLocalService instanceof PublishedPdfListLocalService) {
				_service = (PublishedPdfListLocalService)invokableLocalService;
			}
			else {
				_service = new PublishedPdfListLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PublishedPdfListLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(PublishedPdfListLocalService service) {
	}

	private static PublishedPdfListLocalService _service;
}