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
 * Provides a wrapper for {@link PublishedPdfListLocalService}.
 *
 * @author Mummanedi
 * @see PublishedPdfListLocalService
 * @generated
 */
public class PublishedPdfListLocalServiceWrapper
	implements PublishedPdfListLocalService,
		ServiceWrapper<PublishedPdfListLocalService> {
	public PublishedPdfListLocalServiceWrapper(
		PublishedPdfListLocalService publishedPdfListLocalService) {
		_publishedPdfListLocalService = publishedPdfListLocalService;
	}

	/**
	* Adds the published pdf list to the database. Also notifies the appropriate model listeners.
	*
	* @param publishedPdfList the published pdf list
	* @return the published pdf list that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishedPdfList addPublishedPdfList(
		com.ihg.brandstandards.db.model.PublishedPdfList publishedPdfList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishedPdfListLocalService.addPublishedPdfList(publishedPdfList);
	}

	/**
	* Creates a new published pdf list with the primary key. Does not add the published pdf list to the database.
	*
	* @param pdfId the primary key for the new published pdf list
	* @return the new published pdf list
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishedPdfList createPublishedPdfList(
		long pdfId) {
		return _publishedPdfListLocalService.createPublishedPdfList(pdfId);
	}

	/**
	* Deletes the published pdf list with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pdfId the primary key of the published pdf list
	* @return the published pdf list that was removed
	* @throws PortalException if a published pdf list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishedPdfList deletePublishedPdfList(
		long pdfId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishedPdfListLocalService.deletePublishedPdfList(pdfId);
	}

	/**
	* Deletes the published pdf list from the database. Also notifies the appropriate model listeners.
	*
	* @param publishedPdfList the published pdf list
	* @return the published pdf list that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishedPdfList deletePublishedPdfList(
		com.ihg.brandstandards.db.model.PublishedPdfList publishedPdfList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishedPdfListLocalService.deletePublishedPdfList(publishedPdfList);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _publishedPdfListLocalService.dynamicQuery();
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
		return _publishedPdfListLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _publishedPdfListLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishedPdfListLocalService.dynamicQuery(dynamicQuery, start,
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
		return _publishedPdfListLocalService.dynamicQueryCount(dynamicQuery);
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
		return _publishedPdfListLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.PublishedPdfList fetchPublishedPdfList(
		long pdfId) throws com.liferay.portal.kernel.exception.SystemException {
		return _publishedPdfListLocalService.fetchPublishedPdfList(pdfId);
	}

	/**
	* Returns the published pdf list with the primary key.
	*
	* @param pdfId the primary key of the published pdf list
	* @return the published pdf list
	* @throws PortalException if a published pdf list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishedPdfList getPublishedPdfList(
		long pdfId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishedPdfListLocalService.getPublishedPdfList(pdfId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishedPdfListLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> getPublishedPdfLists(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishedPdfListLocalService.getPublishedPdfLists(start, end);
	}

	/**
	* Returns the number of published pdf lists.
	*
	* @return the number of published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPublishedPdfListsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishedPdfListLocalService.getPublishedPdfListsCount();
	}

	/**
	* Updates the published pdf list in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param publishedPdfList the published pdf list
	* @return the published pdf list that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishedPdfList updatePublishedPdfList(
		com.ihg.brandstandards.db.model.PublishedPdfList publishedPdfList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishedPdfListLocalService.updatePublishedPdfList(publishedPdfList);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _publishedPdfListLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_publishedPdfListLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _publishedPdfListLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void clearCache() {
		_publishedPdfListLocalService.clearCache();
	}

	@Override
	public com.ihg.brandstandards.db.model.PublishedPdfList addPublishedPdfList(
		java.lang.String pdfChainCode, java.lang.String pdfCtryCode,
		java.lang.String pdfBuildType, int pdfYearNumber,
		java.lang.String pdfLocaleCode, long pdfVersionNumber,
		java.lang.String pdfFileName, java.lang.String pdfFileURLText,
		long publishId, java.lang.String pageSizeOrientationType,
		java.lang.String createdBy, java.util.Date createDate,
		java.lang.String updatedBy, java.util.Date updateDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishedPdfListLocalService.addPublishedPdfList(pdfChainCode,
			pdfCtryCode, pdfBuildType, pdfYearNumber, pdfLocaleCode,
			pdfVersionNumber, pdfFileName, pdfFileURLText, publishId,
			pageSizeOrientationType, createdBy, createDate, updatedBy,
			updateDate);
	}

	@Override
	public com.ihg.brandstandards.db.model.PublishedPdfList updatePublishedPdfList(
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
		return _publishedPdfListLocalService.updatePublishedPdfList(pdfId,
			pdfChainCode, pdfCtryCode, pdfBuildType, pdfYearNumber,
			pdfLocaleCode, pdfVersionNumber, pdfFileName, pdfFileURLText,
			publishId, pageSizeOrientationType, createdBy, createDate,
			updatedBy, updateDate);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> getByPdfChainCode(
		java.lang.String pdfChainCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishedPdfListLocalService.getByPdfChainCode(pdfChainCode);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> getByPdfCtryCode(
		java.lang.String pdfCtryCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishedPdfListLocalService.getByPdfCtryCode(pdfCtryCode);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> getByPdfFileName(
		java.lang.String pdfFileName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishedPdfListLocalService.getByPdfFileName(pdfFileName);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> getByPdfFileURLText(
		java.lang.String pdfFileURLText)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishedPdfListLocalService.getByPdfFileURLText(pdfFileURLText);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> getByPdfFileNameAndURL(
		java.lang.String pdfFileName, java.lang.String pdfFileURLText)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishedPdfListLocalService.getByPdfFileNameAndURL(pdfFileName,
			pdfFileURLText);
	}

	@Override
	public com.ihg.brandstandards.db.model.PublishedPdfList getByPdfManualParams(
		long publishId, java.lang.String pdfCtryCode,
		java.lang.String pdfLocaleCode, java.lang.String pdfBuildType,
		java.lang.String pageSizeOrientationType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishedPdfListLocalService.getByPdfManualParams(publishId,
			pdfCtryCode, pdfLocaleCode, pdfBuildType, pageSizeOrientationType);
	}

	@Override
	public java.lang.String getPublishedPDFFullManualURL(long publishId,
		java.lang.String pdfCtryCode, java.lang.String pdfLocaleCode,
		java.lang.String pdfBuildType, java.lang.String pageSizeOrientationType) {
		return _publishedPdfListLocalService.getPublishedPDFFullManualURL(publishId,
			pdfCtryCode, pdfLocaleCode, pdfBuildType, pageSizeOrientationType);
	}

	@Override
	public java.util.Map<java.lang.String, java.util.LinkedHashMap<java.lang.String, java.lang.String>> getPublishedPDFListByParams(
		long publishId, java.lang.String pdfCtryCode,
		java.util.List<java.lang.String> pdfBuildTypes,
		java.lang.String pageSizeOrientationType) {
		return _publishedPdfListLocalService.getPublishedPDFListByParams(publishId,
			pdfCtryCode, pdfBuildTypes, pageSizeOrientationType);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PublishedPdfListLocalService getWrappedPublishedPdfListLocalService() {
		return _publishedPdfListLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPublishedPdfListLocalService(
		PublishedPdfListLocalService publishedPdfListLocalService) {
		_publishedPdfListLocalService = publishedPdfListLocalService;
	}

	@Override
	public PublishedPdfListLocalService getWrappedService() {
		return _publishedPdfListLocalService;
	}

	@Override
	public void setWrappedService(
		PublishedPdfListLocalService publishedPdfListLocalService) {
		_publishedPdfListLocalService = publishedPdfListLocalService;
	}

	private PublishedPdfListLocalService _publishedPdfListLocalService;
}