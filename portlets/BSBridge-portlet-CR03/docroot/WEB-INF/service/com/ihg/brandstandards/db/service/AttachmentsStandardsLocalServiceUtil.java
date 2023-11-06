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
 * Provides the local service utility for AttachmentsStandards. This utility wraps
 * {@link com.ihg.brandstandards.db.service.impl.AttachmentsStandardsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mummanedi
 * @see AttachmentsStandardsLocalService
 * @see com.ihg.brandstandards.db.service.base.AttachmentsStandardsLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.AttachmentsStandardsLocalServiceImpl
 * @generated
 */
public class AttachmentsStandardsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.AttachmentsStandardsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the attachments standards to the database. Also notifies the appropriate model listeners.
	*
	* @param attachmentsStandards the attachments standards
	* @return the attachments standards that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards addAttachmentsStandards(
		com.ihg.brandstandards.db.model.AttachmentsStandards attachmentsStandards)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addAttachmentsStandards(attachmentsStandards);
	}

	/**
	* Creates a new attachments standards with the primary key. Does not add the attachments standards to the database.
	*
	* @param attachmentsStandardsPK the primary key for the new attachments standards
	* @return the new attachments standards
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards createAttachmentsStandards(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK attachmentsStandardsPK) {
		return getService().createAttachmentsStandards(attachmentsStandardsPK);
	}

	/**
	* Deletes the attachments standards with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param attachmentsStandardsPK the primary key of the attachments standards
	* @return the attachments standards that was removed
	* @throws PortalException if a attachments standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards deleteAttachmentsStandards(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK attachmentsStandardsPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAttachmentsStandards(attachmentsStandardsPK);
	}

	/**
	* Deletes the attachments standards from the database. Also notifies the appropriate model listeners.
	*
	* @param attachmentsStandards the attachments standards
	* @return the attachments standards that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards deleteAttachmentsStandards(
		com.ihg.brandstandards.db.model.AttachmentsStandards attachmentsStandards)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAttachmentsStandards(attachmentsStandards);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.ihg.brandstandards.db.model.AttachmentsStandards fetchAttachmentsStandards(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK attachmentsStandardsPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAttachmentsStandards(attachmentsStandardsPK);
	}

	/**
	* Returns the attachments standards with the primary key.
	*
	* @param attachmentsStandardsPK the primary key of the attachments standards
	* @return the attachments standards
	* @throws PortalException if a attachments standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards getAttachmentsStandards(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK attachmentsStandardsPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAttachmentsStandards(attachmentsStandardsPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the attachments standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of attachments standardses
	* @param end the upper bound of the range of attachments standardses (not inclusive)
	* @return the range of attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> getAttachmentsStandardses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAttachmentsStandardses(start, end);
	}

	/**
	* Returns the number of attachments standardses.
	*
	* @return the number of attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int getAttachmentsStandardsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAttachmentsStandardsesCount();
	}

	/**
	* Updates the attachments standards in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param attachmentsStandards the attachments standards
	* @return the attachments standards that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards updateAttachmentsStandards(
		com.ihg.brandstandards.db.model.AttachmentsStandards attachmentsStandards)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAttachmentsStandards(attachmentsStandards);
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

	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> getAttachmentsStandardsByStandardId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAttachmentsStandardsByStandardId(stdId);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> getAttachmentsStandardsByParentId(
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAttachmentsStandardsByParentId(parentId);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> getAttachmentsStandardsByParentIdStdIdLangId(
		long parentId, long stdId, java.lang.String langCd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getAttachmentsStandardsByParentIdStdIdLangId(parentId,
			stdId, langCd);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> getAttachmentsStandardsByLocaleCdStdId(
		java.lang.String localeCd, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getAttachmentsStandardsByLocaleCdStdId(localeCd, stdId);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> getAttachmentsStandardsByParentIdStdId(
		long parentId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getAttachmentsStandardsByParentIdStdId(parentId, stdId);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> getAttachmentsStandardsParentsByStdId(
		long standardId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAttachmentsStandardsParentsByStdId(standardId);
	}

	public static com.ihg.brandstandards.db.model.AttachmentsStandards getAttachmentsStandardsByParentIdAttachId(
		long parentAttachId, long attachId)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getAttachmentsStandardsByParentIdAttachId(parentAttachId,
			attachId);
	}

	public static com.ihg.brandstandards.db.model.AttachmentsStandards getAttchmentByAttachmendId(
		long attachmentId) {
		return getService().getAttchmentByAttachmendId(attachmentId);
	}

	/**
	* Get Standards attachment translation by passing  stdId, regionId and locales.
	*
	* @param stdId
	* @param regionId
	* @param locales
	* @return
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> getStandardAttachmentsByStdIdAndRgnIdAndLocale(
		long stdId, java.lang.String regionId,
		java.util.List<java.lang.String> locales) {
		return getService()
				   .getStandardAttachmentsByStdIdAndRgnIdAndLocale(stdId,
			regionId, locales);
	}

	public static void clearService() {
		_service = null;
	}

	public static AttachmentsStandardsLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AttachmentsStandardsLocalService.class.getName());

			if (invokableLocalService instanceof AttachmentsStandardsLocalService) {
				_service = (AttachmentsStandardsLocalService)invokableLocalService;
			}
			else {
				_service = new AttachmentsStandardsLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(AttachmentsStandardsLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(AttachmentsStandardsLocalService service) {
	}

	private static AttachmentsStandardsLocalService _service;
}