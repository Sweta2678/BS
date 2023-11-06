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
 * Provides a wrapper for {@link AttachmentsStandardsCountryLocalService}.
 *
 * @author Mummanedi
 * @see AttachmentsStandardsCountryLocalService
 * @generated
 */
public class AttachmentsStandardsCountryLocalServiceWrapper
	implements AttachmentsStandardsCountryLocalService,
		ServiceWrapper<AttachmentsStandardsCountryLocalService> {
	public AttachmentsStandardsCountryLocalServiceWrapper(
		AttachmentsStandardsCountryLocalService attachmentsStandardsCountryLocalService) {
		_attachmentsStandardsCountryLocalService = attachmentsStandardsCountryLocalService;
	}

	/**
	* Adds the attachments standards country to the database. Also notifies the appropriate model listeners.
	*
	* @param attachmentsStandardsCountry the attachments standards country
	* @return the attachments standards country that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.AttachmentsStandardsCountry addAttachmentsStandardsCountry(
		com.ihg.brandstandards.db.model.AttachmentsStandardsCountry attachmentsStandardsCountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _attachmentsStandardsCountryLocalService.addAttachmentsStandardsCountry(attachmentsStandardsCountry);
	}

	/**
	* Creates a new attachments standards country with the primary key. Does not add the attachments standards country to the database.
	*
	* @param attachmentsStandardsCountryPK the primary key for the new attachments standards country
	* @return the new attachments standards country
	*/
	@Override
	public com.ihg.brandstandards.db.model.AttachmentsStandardsCountry createAttachmentsStandardsCountry(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsCountryPK attachmentsStandardsCountryPK) {
		return _attachmentsStandardsCountryLocalService.createAttachmentsStandardsCountry(attachmentsStandardsCountryPK);
	}

	/**
	* Deletes the attachments standards country with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param attachmentsStandardsCountryPK the primary key of the attachments standards country
	* @return the attachments standards country that was removed
	* @throws PortalException if a attachments standards country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.AttachmentsStandardsCountry deleteAttachmentsStandardsCountry(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsCountryPK attachmentsStandardsCountryPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _attachmentsStandardsCountryLocalService.deleteAttachmentsStandardsCountry(attachmentsStandardsCountryPK);
	}

	/**
	* Deletes the attachments standards country from the database. Also notifies the appropriate model listeners.
	*
	* @param attachmentsStandardsCountry the attachments standards country
	* @return the attachments standards country that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.AttachmentsStandardsCountry deleteAttachmentsStandardsCountry(
		com.ihg.brandstandards.db.model.AttachmentsStandardsCountry attachmentsStandardsCountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _attachmentsStandardsCountryLocalService.deleteAttachmentsStandardsCountry(attachmentsStandardsCountry);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _attachmentsStandardsCountryLocalService.dynamicQuery();
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
		return _attachmentsStandardsCountryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _attachmentsStandardsCountryLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _attachmentsStandardsCountryLocalService.dynamicQuery(dynamicQuery,
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
		return _attachmentsStandardsCountryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _attachmentsStandardsCountryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.AttachmentsStandardsCountry fetchAttachmentsStandardsCountry(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsCountryPK attachmentsStandardsCountryPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _attachmentsStandardsCountryLocalService.fetchAttachmentsStandardsCountry(attachmentsStandardsCountryPK);
	}

	/**
	* Returns the attachments standards country with the primary key.
	*
	* @param attachmentsStandardsCountryPK the primary key of the attachments standards country
	* @return the attachments standards country
	* @throws PortalException if a attachments standards country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.AttachmentsStandardsCountry getAttachmentsStandardsCountry(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsCountryPK attachmentsStandardsCountryPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _attachmentsStandardsCountryLocalService.getAttachmentsStandardsCountry(attachmentsStandardsCountryPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _attachmentsStandardsCountryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the attachments standards countries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of attachments standards countries
	* @param end the upper bound of the range of attachments standards countries (not inclusive)
	* @return the range of attachments standards countries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandardsCountry> getAttachmentsStandardsCountries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _attachmentsStandardsCountryLocalService.getAttachmentsStandardsCountries(start,
			end);
	}

	/**
	* Returns the number of attachments standards countries.
	*
	* @return the number of attachments standards countries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAttachmentsStandardsCountriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _attachmentsStandardsCountryLocalService.getAttachmentsStandardsCountriesCount();
	}

	/**
	* Updates the attachments standards country in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param attachmentsStandardsCountry the attachments standards country
	* @return the attachments standards country that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.AttachmentsStandardsCountry updateAttachmentsStandardsCountry(
		com.ihg.brandstandards.db.model.AttachmentsStandardsCountry attachmentsStandardsCountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _attachmentsStandardsCountryLocalService.updateAttachmentsStandardsCountry(attachmentsStandardsCountry);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _attachmentsStandardsCountryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_attachmentsStandardsCountryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _attachmentsStandardsCountryLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandardsCountry> getAttachmentsStandardsCountryByAttachmentId(
		long attachmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _attachmentsStandardsCountryLocalService.getAttachmentsStandardsCountryByAttachmentId(attachmentId);
	}

	@Override
	public void clearCache() {
		_attachmentsStandardsCountryLocalService.clearCache();
	}

	@Override
	public java.lang.String assignAttachementAttributeToCountry(
		java.lang.String fromCountryCode, java.lang.String toCountryCode) {
		return _attachmentsStandardsCountryLocalService.assignAttachementAttributeToCountry(fromCountryCode,
			toCountryCode);
	}

	@Override
	public java.lang.String deleteCountryAttachementAttribute(
		java.lang.String ctryNameCode) {
		return _attachmentsStandardsCountryLocalService.deleteCountryAttachementAttribute(ctryNameCode);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AttachmentsStandardsCountryLocalService getWrappedAttachmentsStandardsCountryLocalService() {
		return _attachmentsStandardsCountryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAttachmentsStandardsCountryLocalService(
		AttachmentsStandardsCountryLocalService attachmentsStandardsCountryLocalService) {
		_attachmentsStandardsCountryLocalService = attachmentsStandardsCountryLocalService;
	}

	@Override
	public AttachmentsStandardsCountryLocalService getWrappedService() {
		return _attachmentsStandardsCountryLocalService;
	}

	@Override
	public void setWrappedService(
		AttachmentsStandardsCountryLocalService attachmentsStandardsCountryLocalService) {
		_attachmentsStandardsCountryLocalService = attachmentsStandardsCountryLocalService;
	}

	private AttachmentsStandardsCountryLocalService _attachmentsStandardsCountryLocalService;
}