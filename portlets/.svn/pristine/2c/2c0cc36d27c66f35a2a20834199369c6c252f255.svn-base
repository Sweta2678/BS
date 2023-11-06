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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for PublishedPdfList. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Mummanedi
 * @see PublishedPdfListLocalServiceUtil
 * @see com.ihg.brandstandards.db.service.base.PublishedPdfListLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.PublishedPdfListLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface PublishedPdfListLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PublishedPdfListLocalServiceUtil} to access the published pdf list local service. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.PublishedPdfListLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the published pdf list to the database. Also notifies the appropriate model listeners.
	*
	* @param publishedPdfList the published pdf list
	* @return the published pdf list that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishedPdfList addPublishedPdfList(
		com.ihg.brandstandards.db.model.PublishedPdfList publishedPdfList)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new published pdf list with the primary key. Does not add the published pdf list to the database.
	*
	* @param pdfId the primary key for the new published pdf list
	* @return the new published pdf list
	*/
	public com.ihg.brandstandards.db.model.PublishedPdfList createPublishedPdfList(
		long pdfId);

	/**
	* Deletes the published pdf list with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pdfId the primary key of the published pdf list
	* @return the published pdf list that was removed
	* @throws PortalException if a published pdf list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishedPdfList deletePublishedPdfList(
		long pdfId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the published pdf list from the database. Also notifies the appropriate model listeners.
	*
	* @param publishedPdfList the published pdf list
	* @return the published pdf list that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishedPdfList deletePublishedPdfList(
		com.ihg.brandstandards.db.model.PublishedPdfList publishedPdfList)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.ihg.brandstandards.db.model.PublishedPdfList fetchPublishedPdfList(
		long pdfId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the published pdf list with the primary key.
	*
	* @param pdfId the primary key of the published pdf list
	* @return the published pdf list
	* @throws PortalException if a published pdf list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.ihg.brandstandards.db.model.PublishedPdfList getPublishedPdfList(
		long pdfId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> getPublishedPdfLists(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of published pdf lists.
	*
	* @return the number of published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPublishedPdfListsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the published pdf list in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param publishedPdfList the published pdf list
	* @return the published pdf list that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishedPdfList updatePublishedPdfList(
		com.ihg.brandstandards.db.model.PublishedPdfList publishedPdfList)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public void clearCache();

	public com.ihg.brandstandards.db.model.PublishedPdfList addPublishedPdfList(
		java.lang.String pdfChainCode, java.lang.String pdfCtryCode,
		java.lang.String pdfBuildType, int pdfYearNumber,
		java.lang.String pdfLocaleCode, long pdfVersionNumber,
		java.lang.String pdfFileName, java.lang.String pdfFileURLText,
		long publishId, java.lang.String pageSizeOrientationType,
		java.lang.String createdBy, java.util.Date createDate,
		java.lang.String updatedBy, java.util.Date updateDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> getByPdfChainCode(
		java.lang.String pdfChainCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> getByPdfCtryCode(
		java.lang.String pdfCtryCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> getByPdfFileName(
		java.lang.String pdfFileName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> getByPdfFileURLText(
		java.lang.String pdfFileURLText)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> getByPdfFileNameAndURL(
		java.lang.String pdfFileName, java.lang.String pdfFileURLText)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.ihg.brandstandards.db.model.PublishedPdfList getByPdfManualParams(
		long publishId, java.lang.String pdfCtryCode,
		java.lang.String pdfLocaleCode, java.lang.String pdfBuildType,
		java.lang.String pageSizeOrientationType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getPublishedPDFFullManualURL(long publishId,
		java.lang.String pdfCtryCode, java.lang.String pdfLocaleCode,
		java.lang.String pdfBuildType, java.lang.String pageSizeOrientationType);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Map<java.lang.String, java.util.LinkedHashMap<java.lang.String, java.lang.String>> getPublishedPDFListByParams(
		long publishId, java.lang.String pdfCtryCode,
		java.util.List<java.lang.String> pdfBuildTypes,
		java.lang.String pageSizeOrientationType);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPublishedManualCount(long publishId);
}