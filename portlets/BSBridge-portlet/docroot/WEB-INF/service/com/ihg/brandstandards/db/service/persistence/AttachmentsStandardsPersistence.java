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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the attachments standards service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see AttachmentsStandardsPersistenceImpl
 * @see AttachmentsStandardsUtil
 * @generated
 */
public interface AttachmentsStandardsPersistence extends BasePersistence<AttachmentsStandards> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AttachmentsStandardsUtil} to access the attachments standards persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the attachments standardses where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByStdId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByStdId(
		long stdId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByStdId(
		long stdId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first attachments standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attachments standards
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.AttachmentsStandards findByStdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first attachments standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.AttachmentsStandards fetchByStdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last attachments standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attachments standards
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.AttachmentsStandards findByStdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last attachments standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.AttachmentsStandards fetchByStdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.AttachmentsStandards[] findByStdId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK attachmentsStandardsPK,
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the attachments standardses where stdId = &#63; from the database.
	*
	* @param stdId the std ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of attachments standardses where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the number of matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the attachments standards where attachmentId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException} if it could not be found.
	*
	* @param attachmentId the attachment ID
	* @return the matching attachments standards
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.AttachmentsStandards findByattachmentId(
		long attachmentId)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the attachments standards where attachmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param attachmentId the attachment ID
	* @return the matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.AttachmentsStandards fetchByattachmentId(
		long attachmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the attachments standards where attachmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param attachmentId the attachment ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.AttachmentsStandards fetchByattachmentId(
		long attachmentId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the attachments standards where attachmentId = &#63; from the database.
	*
	* @param attachmentId the attachment ID
	* @return the attachments standards that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.AttachmentsStandards removeByattachmentId(
		long attachmentId)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of attachments standardses where attachmentId = &#63;.
	*
	* @param attachmentId the attachment ID
	* @return the number of matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countByattachmentId(long attachmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the attachments standardses where parentAttachmentId = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @return the matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByparentAttachmentId(
		long parentAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByparentAttachmentId(
		long parentAttachmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByparentAttachmentId(
		long parentAttachmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first attachments standards in the ordered set where parentAttachmentId = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attachments standards
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.AttachmentsStandards findByparentAttachmentId_First(
		long parentAttachmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first attachments standards in the ordered set where parentAttachmentId = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.AttachmentsStandards fetchByparentAttachmentId_First(
		long parentAttachmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last attachments standards in the ordered set where parentAttachmentId = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attachments standards
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.AttachmentsStandards findByparentAttachmentId_Last(
		long parentAttachmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last attachments standards in the ordered set where parentAttachmentId = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.AttachmentsStandards fetchByparentAttachmentId_Last(
		long parentAttachmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.AttachmentsStandards[] findByparentAttachmentId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK attachmentsStandardsPK,
		long parentAttachmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the attachments standardses where parentAttachmentId = &#63; from the database.
	*
	* @param parentAttachmentId the parent attachment ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByparentAttachmentId(long parentAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of attachments standardses where parentAttachmentId = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @return the number of matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countByparentAttachmentId(long parentAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the attachments standardses where parentAttachmentId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @return the matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByparentIdStdIdLocaleCd(
		long parentAttachmentId, long stdId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByparentIdStdIdLocaleCd(
		long parentAttachmentId, long stdId, java.lang.String localeCode,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByparentIdStdIdLocaleCd(
		long parentAttachmentId, long stdId, java.lang.String localeCode,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.AttachmentsStandards findByparentIdStdIdLocaleCd_First(
		long parentAttachmentId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.AttachmentsStandards fetchByparentIdStdIdLocaleCd_First(
		long parentAttachmentId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.AttachmentsStandards findByparentIdStdIdLocaleCd_Last(
		long parentAttachmentId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.AttachmentsStandards fetchByparentIdStdIdLocaleCd_Last(
		long parentAttachmentId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.AttachmentsStandards[] findByparentIdStdIdLocaleCd_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK attachmentsStandardsPK,
		long parentAttachmentId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the attachments standardses where parentAttachmentId = &#63; and stdId = &#63; and localeCode = &#63; from the database.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByparentIdStdIdLocaleCd(long parentAttachmentId,
		long stdId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of attachments standardses where parentAttachmentId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @return the number of matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countByparentIdStdIdLocaleCd(long parentAttachmentId,
		long stdId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the attachments standardses where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @return the matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByStdIdLocaleCd(
		long stdId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByStdIdLocaleCd(
		long stdId, java.lang.String localeCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByStdIdLocaleCd(
		long stdId, java.lang.String localeCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.AttachmentsStandards findByStdIdLocaleCd_First(
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first attachments standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.AttachmentsStandards fetchByStdIdLocaleCd_First(
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.AttachmentsStandards findByStdIdLocaleCd_Last(
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last attachments standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.AttachmentsStandards fetchByStdIdLocaleCd_Last(
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.AttachmentsStandards[] findByStdIdLocaleCd_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK attachmentsStandardsPK,
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the attachments standardses where stdId = &#63; and localeCode = &#63; from the database.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStdIdLocaleCd(long stdId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of attachments standardses where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @return the number of matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countByStdIdLocaleCd(long stdId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the attachments standardses where parentAttachmentId = &#63; and stdId = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param stdId the std ID
	* @return the matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByParentIdStdId(
		long parentAttachmentId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByParentIdStdId(
		long parentAttachmentId, long stdId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findByParentIdStdId(
		long parentAttachmentId, long stdId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.AttachmentsStandards findByParentIdStdId_First(
		long parentAttachmentId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first attachments standards in the ordered set where parentAttachmentId = &#63; and stdId = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.AttachmentsStandards fetchByParentIdStdId_First(
		long parentAttachmentId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.AttachmentsStandards findByParentIdStdId_Last(
		long parentAttachmentId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last attachments standards in the ordered set where parentAttachmentId = &#63; and stdId = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.AttachmentsStandards fetchByParentIdStdId_Last(
		long parentAttachmentId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.AttachmentsStandards[] findByParentIdStdId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK attachmentsStandardsPK,
		long parentAttachmentId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the attachments standardses where parentAttachmentId = &#63; and stdId = &#63; from the database.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param stdId the std ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentIdStdId(long parentAttachmentId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of attachments standardses where parentAttachmentId = &#63; and stdId = &#63;.
	*
	* @param parentAttachmentId the parent attachment ID
	* @param stdId the std ID
	* @return the number of matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentIdStdId(long parentAttachmentId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the attachments standards where attachmentId = &#63; and parentAttachmentId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException} if it could not be found.
	*
	* @param attachmentId the attachment ID
	* @param parentAttachmentId the parent attachment ID
	* @return the matching attachments standards
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.AttachmentsStandards findByParentIdAttachId(
		long attachmentId, long parentAttachmentId)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the attachments standards where attachmentId = &#63; and parentAttachmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param attachmentId the attachment ID
	* @param parentAttachmentId the parent attachment ID
	* @return the matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.AttachmentsStandards fetchByParentIdAttachId(
		long attachmentId, long parentAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the attachments standards where attachmentId = &#63; and parentAttachmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param attachmentId the attachment ID
	* @param parentAttachmentId the parent attachment ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching attachments standards, or <code>null</code> if a matching attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.AttachmentsStandards fetchByParentIdAttachId(
		long attachmentId, long parentAttachmentId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the attachments standards where attachmentId = &#63; and parentAttachmentId = &#63; from the database.
	*
	* @param attachmentId the attachment ID
	* @param parentAttachmentId the parent attachment ID
	* @return the attachments standards that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.AttachmentsStandards removeByParentIdAttachId(
		long attachmentId, long parentAttachmentId)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of attachments standardses where attachmentId = &#63; and parentAttachmentId = &#63;.
	*
	* @param attachmentId the attachment ID
	* @param parentAttachmentId the parent attachment ID
	* @return the number of matching attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentIdAttachId(long attachmentId,
		long parentAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the attachments standards in the entity cache if it is enabled.
	*
	* @param attachmentsStandards the attachments standards
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.AttachmentsStandards attachmentsStandards);

	/**
	* Caches the attachments standardses in the entity cache if it is enabled.
	*
	* @param attachmentsStandardses the attachments standardses
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> attachmentsStandardses);

	/**
	* Creates a new attachments standards with the primary key. Does not add the attachments standards to the database.
	*
	* @param attachmentsStandardsPK the primary key for the new attachments standards
	* @return the new attachments standards
	*/
	public com.ihg.brandstandards.db.model.AttachmentsStandards create(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK attachmentsStandardsPK);

	/**
	* Removes the attachments standards with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param attachmentsStandardsPK the primary key of the attachments standards
	* @return the attachments standards that was removed
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a attachments standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.AttachmentsStandards remove(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK attachmentsStandardsPK)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.AttachmentsStandards updateImpl(
		com.ihg.brandstandards.db.model.AttachmentsStandards attachmentsStandards)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the attachments standards with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException} if it could not be found.
	*
	* @param attachmentsStandardsPK the primary key of the attachments standards
	* @return the attachments standards
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException if a attachments standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.AttachmentsStandards findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK attachmentsStandardsPK)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the attachments standards with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param attachmentsStandardsPK the primary key of the attachments standards
	* @return the attachments standards, or <code>null</code> if a attachments standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.AttachmentsStandards fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK attachmentsStandardsPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the attachments standardses.
	*
	* @return the attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandards> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the attachments standardses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of attachments standardses.
	*
	* @return the number of attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}