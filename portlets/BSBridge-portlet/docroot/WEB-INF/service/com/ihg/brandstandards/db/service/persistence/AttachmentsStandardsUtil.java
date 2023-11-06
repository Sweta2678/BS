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

package com.ihg.brandstandards.db.service.persistence;

import com.ihg.brandstandards.db.model.AttachmentsStandards;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the attachments standards service. This utility wraps {@link AttachmentsStandardsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see AttachmentsStandardsPersistence
 * @see AttachmentsStandardsPersistenceImpl
 * @generated
 */
public class AttachmentsStandardsUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(AttachmentsStandards attachmentsStandards) {
		getPersistence().clearCache(attachmentsStandards);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AttachmentsStandards> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AttachmentsStandards> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AttachmentsStandards> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static AttachmentsStandards update(
		AttachmentsStandards attachmentsStandards) throws SystemException {
		return getPersistence().update(attachmentsStandards);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static AttachmentsStandards update(
		AttachmentsStandards attachmentsStandards, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(attachmentsStandards, serviceContext);
	}

	/**
	* Returns all the attachments standardses where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByStdId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId(stdId);
	}

	/**
	* Returns a range of all the attachments standardses where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of attachments standardses
	* @param end the upper bound of the range of attachments standardses (not inclusive)
	* @return the range of matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByStdId(
		long stdId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId(stdId, start, end);
	}

	/**
	* Returns an ordered range of all the attachments standardses where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of attachments standardses
	* @param end the upper bound of the range of attachments standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByStdId(
		long stdId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId(stdId, start, end, orderByComparator);
	}

	/**
	* Returns the first attachments standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attachments standards
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards findByStdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId_First(stdId, orderByComparator);
	}

	/**
	* Returns the first attachments standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards fetchByStdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStdId_First(stdId, orderByComparator);
	}

	/**
	* Returns the last attachments standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attachments standards
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards findByStdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId_Last(stdId, orderByComparator);
	}

	/**
	* Returns the last attachments standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards fetchByStdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStdId_Last(stdId, orderByComparator);
	}

	/**
	* Returns the attachments standardses before and after the current attachments standards in the ordered set where stdId = &#63;.
	*
	* @param attachmentsStandardsPK the primary key of the current attachments standards
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next attachments standards
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a attachments standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards[] findByStdId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK attachmentsStandardsPK,
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdId_PrevAndNext(attachmentsStandardsPK, stdId,
			orderByComparator);
	}

	/**
	* Removes all the attachments standardses where stdId = &#63; from the database.
	*
	* @param stdId the std ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStdId(stdId);
	}

	/**
	* Returns the number of attachments standardses where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the number of matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStdId(stdId);
	}

	/**
	* Returns the attachments standards where attachmentId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException} if it could not be found.
	*
	* @param attachmentId the attachment ID
	* @return the matching attachments standards
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards findByattachmentId(
		long attachmentId)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByattachmentId(attachmentId);
	}

	/**
	* Returns the attachments standards where attachmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param attachmentId the attachment ID
	* @return the matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards fetchByattachmentId(
		long attachmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByattachmentId(attachmentId);
	}

	/**
	* Returns the attachments standards where attachmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param attachmentId the attachment ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards fetchByattachmentId(
		long attachmentId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByattachmentId(attachmentId, retrieveFromCache);
	}

	/**
	* Removes the attachments standards where attachmentId = &#63; from the database.
	*
	* @param attachmentId the attachment ID
	* @return the attachments standards that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards removeByattachmentId(
		long attachmentId)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByattachmentId(attachmentId);
	}

	/**
	* Returns the number of attachments standardses where attachmentId = &#63;.
	*
	* @param attachmentId the attachment ID
	* @return the number of matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByattachmentId(long attachmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByattachmentId(attachmentId);
	}

	/**
	* Returns all the attachments standardses where parentAttachmentId = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @return the matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByparentAttachmentId(
		long parentAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByparentAttachmentId(parentAttachmentId);
	}

	/**
	* Returns a range of all the attachments standardses where parentAttachmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentAttachmentId the parent attachment ID
	* @param start the lower bound of the range of attachments standardses
	* @param end the upper bound of the range of attachments standardses (not inclusive)
	* @return the range of matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByparentAttachmentId(
		long parentAttachmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentAttachmentId(parentAttachmentId, start, end);
	}

	/**
	* Returns an ordered range of all the attachments standardses where parentAttachmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentAttachmentId the parent attachment ID
	* @param start the lower bound of the range of attachments standardses
	* @param end the upper bound of the range of attachments standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByparentAttachmentId(
		long parentAttachmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentAttachmentId(parentAttachmentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first attachments standards in the ordered set where parentAttachmentId = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attachments standards
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards findByparentAttachmentId_First(
		long parentAttachmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentAttachmentId_First(parentAttachmentId,
			orderByComparator);
	}

	/**
	* Returns the first attachments standards in the ordered set where parentAttachmentId = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards fetchByparentAttachmentId_First(
		long parentAttachmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByparentAttachmentId_First(parentAttachmentId,
			orderByComparator);
	}

	/**
	* Returns the last attachments standards in the ordered set where parentAttachmentId = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attachments standards
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards findByparentAttachmentId_Last(
		long parentAttachmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentAttachmentId_Last(parentAttachmentId,
			orderByComparator);
	}

	/**
	* Returns the last attachments standards in the ordered set where parentAttachmentId = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards fetchByparentAttachmentId_Last(
		long parentAttachmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByparentAttachmentId_Last(parentAttachmentId,
			orderByComparator);
	}

	/**
	* Returns the attachments standardses before and after the current attachments standards in the ordered set where parentAttachmentId = &#63;.
	*
	* @param attachmentsStandardsPK the primary key of the current attachments standards
	* @param parentAttachmentId the parent attachment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next attachments standards
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a attachments standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards[] findByparentAttachmentId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK attachmentsStandardsPK,
		long parentAttachmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentAttachmentId_PrevAndNext(attachmentsStandardsPK,
			parentAttachmentId, orderByComparator);
	}

	/**
	* Removes all the attachments standardses where parentAttachmentId = &#63; from the database.
	*
	* @param parentAttachmentId the parent attachment ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByparentAttachmentId(long parentAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByparentAttachmentId(parentAttachmentId);
	}

	/**
	* Returns the number of attachments standardses where parentAttachmentId = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @return the number of matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByparentAttachmentId(long parentAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByparentAttachmentId(parentAttachmentId);
	}

	/**
	* Returns all the attachments standardses where parentAttachmentId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @return the matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByparentIdStdIdLocaleCd(
		long parentAttachmentId, long stdId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentIdStdIdLocaleCd(parentAttachmentId, stdId,
			localeCode);
	}

	/**
	* Returns a range of all the attachments standardses where parentAttachmentId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentAttachmentId the parent attachment ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param start the lower bound of the range of attachments standardses
	* @param end the upper bound of the range of attachments standardses (not inclusive)
	* @return the range of matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByparentIdStdIdLocaleCd(
		long parentAttachmentId, long stdId, java.lang.String localeCode,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentIdStdIdLocaleCd(parentAttachmentId, stdId,
			localeCode, start, end);
	}

	/**
	* Returns an ordered range of all the attachments standardses where parentAttachmentId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentAttachmentId the parent attachment ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param start the lower bound of the range of attachments standardses
	* @param end the upper bound of the range of attachments standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByparentIdStdIdLocaleCd(
		long parentAttachmentId, long stdId, java.lang.String localeCode,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentIdStdIdLocaleCd(parentAttachmentId, stdId,
			localeCode, start, end, orderByComparator);
	}

	/**
	* Returns the first attachments standards in the ordered set where parentAttachmentId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attachments standards
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards findByparentIdStdIdLocaleCd_First(
		long parentAttachmentId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentIdStdIdLocaleCd_First(parentAttachmentId,
			stdId, localeCode, orderByComparator);
	}

	/**
	* Returns the first attachments standards in the ordered set where parentAttachmentId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards fetchByparentIdStdIdLocaleCd_First(
		long parentAttachmentId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByparentIdStdIdLocaleCd_First(parentAttachmentId,
			stdId, localeCode, orderByComparator);
	}

	/**
	* Returns the last attachments standards in the ordered set where parentAttachmentId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attachments standards
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards findByparentIdStdIdLocaleCd_Last(
		long parentAttachmentId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentIdStdIdLocaleCd_Last(parentAttachmentId, stdId,
			localeCode, orderByComparator);
	}

	/**
	* Returns the last attachments standards in the ordered set where parentAttachmentId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards fetchByparentIdStdIdLocaleCd_Last(
		long parentAttachmentId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByparentIdStdIdLocaleCd_Last(parentAttachmentId,
			stdId, localeCode, orderByComparator);
	}

	/**
	* Returns the attachments standardses before and after the current attachments standards in the ordered set where parentAttachmentId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param attachmentsStandardsPK the primary key of the current attachments standards
	* @param parentAttachmentId the parent attachment ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next attachments standards
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a attachments standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards[] findByparentIdStdIdLocaleCd_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK attachmentsStandardsPK,
		long parentAttachmentId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentIdStdIdLocaleCd_PrevAndNext(attachmentsStandardsPK,
			parentAttachmentId, stdId, localeCode, orderByComparator);
	}

	/**
	* Removes all the attachments standardses where parentAttachmentId = &#63; and stdId = &#63; and localeCode = &#63; from the database.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByparentIdStdIdLocaleCd(long parentAttachmentId,
		long stdId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByparentIdStdIdLocaleCd(parentAttachmentId, stdId, localeCode);
	}

	/**
	* Returns the number of attachments standardses where parentAttachmentId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @return the number of matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByparentIdStdIdLocaleCd(long parentAttachmentId,
		long stdId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByparentIdStdIdLocaleCd(parentAttachmentId, stdId,
			localeCode);
	}

	/**
	* Returns all the attachments standardses where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @return the matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByStdIdLocaleCd(
		long stdId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdIdLocaleCd(stdId, localeCode);
	}

	/**
	* Returns a range of all the attachments standardses where stdId = &#63; and localeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param start the lower bound of the range of attachments standardses
	* @param end the upper bound of the range of attachments standardses (not inclusive)
	* @return the range of matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByStdIdLocaleCd(
		long stdId, java.lang.String localeCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdIdLocaleCd(stdId, localeCode, start, end);
	}

	/**
	* Returns an ordered range of all the attachments standardses where stdId = &#63; and localeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param start the lower bound of the range of attachments standardses
	* @param end the upper bound of the range of attachments standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByStdIdLocaleCd(
		long stdId, java.lang.String localeCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdIdLocaleCd(stdId, localeCode, start, end,
			orderByComparator);
	}

	/**
	* Returns the first attachments standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attachments standards
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards findByStdIdLocaleCd_First(
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdIdLocaleCd_First(stdId, localeCode,
			orderByComparator);
	}

	/**
	* Returns the first attachments standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards fetchByStdIdLocaleCd_First(
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStdIdLocaleCd_First(stdId, localeCode,
			orderByComparator);
	}

	/**
	* Returns the last attachments standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attachments standards
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards findByStdIdLocaleCd_Last(
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdIdLocaleCd_Last(stdId, localeCode,
			orderByComparator);
	}

	/**
	* Returns the last attachments standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards fetchByStdIdLocaleCd_Last(
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStdIdLocaleCd_Last(stdId, localeCode,
			orderByComparator);
	}

	/**
	* Returns the attachments standardses before and after the current attachments standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param attachmentsStandardsPK the primary key of the current attachments standards
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next attachments standards
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a attachments standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards[] findByStdIdLocaleCd_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK attachmentsStandardsPK,
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdIdLocaleCd_PrevAndNext(attachmentsStandardsPK,
			stdId, localeCode, orderByComparator);
	}

	/**
	* Removes all the attachments standardses where stdId = &#63; and localeCode = &#63; from the database.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStdIdLocaleCd(long stdId,
		java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStdIdLocaleCd(stdId, localeCode);
	}

	/**
	* Returns the number of attachments standardses where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @return the number of matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStdIdLocaleCd(long stdId,
		java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStdIdLocaleCd(stdId, localeCode);
	}

	/**
	* Returns all the attachments standardses where parentAttachmentId = &#63; and stdId = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param stdId the std ID
	* @return the matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByParentIdStdId(
		long parentAttachmentId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParentIdStdId(parentAttachmentId, stdId);
	}

	/**
	* Returns a range of all the attachments standardses where parentAttachmentId = &#63; and stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentAttachmentId the parent attachment ID
	* @param stdId the std ID
	* @param start the lower bound of the range of attachments standardses
	* @param end the upper bound of the range of attachments standardses (not inclusive)
	* @return the range of matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByParentIdStdId(
		long parentAttachmentId, long stdId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentIdStdId(parentAttachmentId, stdId, start, end);
	}

	/**
	* Returns an ordered range of all the attachments standardses where parentAttachmentId = &#63; and stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentAttachmentId the parent attachment ID
	* @param stdId the std ID
	* @param start the lower bound of the range of attachments standardses
	* @param end the upper bound of the range of attachments standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByParentIdStdId(
		long parentAttachmentId, long stdId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentIdStdId(parentAttachmentId, stdId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first attachments standards in the ordered set where parentAttachmentId = &#63; and stdId = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attachments standards
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards findByParentIdStdId_First(
		long parentAttachmentId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentIdStdId_First(parentAttachmentId, stdId,
			orderByComparator);
	}

	/**
	* Returns the first attachments standards in the ordered set where parentAttachmentId = &#63; and stdId = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards fetchByParentIdStdId_First(
		long parentAttachmentId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentIdStdId_First(parentAttachmentId, stdId,
			orderByComparator);
	}

	/**
	* Returns the last attachments standards in the ordered set where parentAttachmentId = &#63; and stdId = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attachments standards
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards findByParentIdStdId_Last(
		long parentAttachmentId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentIdStdId_Last(parentAttachmentId, stdId,
			orderByComparator);
	}

	/**
	* Returns the last attachments standards in the ordered set where parentAttachmentId = &#63; and stdId = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards fetchByParentIdStdId_Last(
		long parentAttachmentId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentIdStdId_Last(parentAttachmentId, stdId,
			orderByComparator);
	}

	/**
	* Returns the attachments standardses before and after the current attachments standards in the ordered set where parentAttachmentId = &#63; and stdId = &#63;.
	*
	* @param attachmentsStandardsPK the primary key of the current attachments standards
	* @param parentAttachmentId the parent attachment ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next attachments standards
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a attachments standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards[] findByParentIdStdId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK attachmentsStandardsPK,
		long parentAttachmentId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentIdStdId_PrevAndNext(attachmentsStandardsPK,
			parentAttachmentId, stdId, orderByComparator);
	}

	/**
	* Removes all the attachments standardses where parentAttachmentId = &#63; and stdId = &#63; from the database.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param stdId the std ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParentIdStdId(long parentAttachmentId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParentIdStdId(parentAttachmentId, stdId);
	}

	/**
	* Returns the number of attachments standardses where parentAttachmentId = &#63; and stdId = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param stdId the std ID
	* @return the number of matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParentIdStdId(long parentAttachmentId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByParentIdStdId(parentAttachmentId, stdId);
	}

	/**
	* Returns the attachments standards where attachmentId = &#63; and parentAttachmentId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException} if it could not be found.
	*
	* @param attachmentId the attachment ID
	* @param parentAttachmentId the parent attachment ID
	* @return the matching attachments standards
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards findByParentIdAttachId(
		long attachmentId, long parentAttachmentId)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentIdAttachId(attachmentId, parentAttachmentId);
	}

	/**
	* Returns the attachments standards where attachmentId = &#63; and parentAttachmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param attachmentId the attachment ID
	* @param parentAttachmentId the parent attachment ID
	* @return the matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards fetchByParentIdAttachId(
		long attachmentId, long parentAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentIdAttachId(attachmentId, parentAttachmentId);
	}

	/**
	* Returns the attachments standards where attachmentId = &#63; and parentAttachmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param attachmentId the attachment ID
	* @param parentAttachmentId the parent attachment ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards fetchByParentIdAttachId(
		long attachmentId, long parentAttachmentId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentIdAttachId(attachmentId, parentAttachmentId,
			retrieveFromCache);
	}

	/**
	* Removes the attachments standards where attachmentId = &#63; and parentAttachmentId = &#63; from the database.
	*
	* @param attachmentId the attachment ID
	* @param parentAttachmentId the parent attachment ID
	* @return the attachments standards that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards removeByParentIdAttachId(
		long attachmentId, long parentAttachmentId)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByParentIdAttachId(attachmentId, parentAttachmentId);
	}

	/**
	* Returns the number of attachments standardses where attachmentId = &#63; and parentAttachmentId = &#63;.
	*
	* @param attachmentId the attachment ID
	* @param parentAttachmentId the parent attachment ID
	* @return the number of matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParentIdAttachId(long attachmentId,
		long parentAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByParentIdAttachId(attachmentId, parentAttachmentId);
	}

	/**
	* Caches the attachments standards in the entity cache if it is enabled.
	*
	* @param attachmentsStandards the attachments standards
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.AttachmentsStandards attachmentsStandards) {
		getPersistence().cacheResult(attachmentsStandards);
	}

	/**
	* Caches the attachments standardses in the entity cache if it is enabled.
	*
	* @param attachmentsStandardses the attachments standardses
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> attachmentsStandardses) {
		getPersistence().cacheResult(attachmentsStandardses);
	}

	/**
	* Creates a new attachments standards with the primary key. Does not add the attachments standards to the database.
	*
	* @param attachmentsStandardsPK the primary key for the new attachments standards
	* @return the new attachments standards
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards create(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK attachmentsStandardsPK) {
		return getPersistence().create(attachmentsStandardsPK);
	}

	/**
	* Removes the attachments standards with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param attachmentsStandardsPK the primary key of the attachments standards
	* @return the attachments standards that was removed
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a attachments standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards remove(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK attachmentsStandardsPK)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(attachmentsStandardsPK);
	}

	public static com.ihg.brandstandards.db.model.AttachmentsStandards updateImpl(
		com.ihg.brandstandards.db.model.AttachmentsStandards attachmentsStandards)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(attachmentsStandards);
	}

	/**
	* Returns the attachments standards with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException} if it could not be found.
	*
	* @param attachmentsStandardsPK the primary key of the attachments standards
	* @return the attachments standards
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a attachments standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK attachmentsStandardsPK)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(attachmentsStandardsPK);
	}

	/**
	* Returns the attachments standards with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param attachmentsStandardsPK the primary key of the attachments standards
	* @return the attachments standards, or <code>null</code> if a attachments standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandards fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK attachmentsStandardsPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(attachmentsStandardsPK);
	}

	/**
	* Returns all the attachments standardses.
	*
	* @return the attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the attachments standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of attachments standardses
	* @param end the upper bound of the range of attachments standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the attachments standardses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of attachments standardses.
	*
	* @return the number of attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AttachmentsStandardsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AttachmentsStandardsPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					AttachmentsStandardsPersistence.class.getName());

			ReferenceRegistry.registerReference(AttachmentsStandardsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(AttachmentsStandardsPersistence persistence) {
	}

	private static AttachmentsStandardsPersistence _persistence;
}