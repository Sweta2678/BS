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

import com.ihg.brandstandards.db.model.ExternalLinkStandards;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the external link standards service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see ExternalLinkStandardsPersistenceImpl
 * @see ExternalLinkStandardsUtil
 * @generated
 */
public interface ExternalLinkStandardsPersistence extends BasePersistence<ExternalLinkStandards> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExternalLinkStandardsUtil} to access the external link standards persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the external link standardses where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByStdId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the external link standardses where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @return the range of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByStdId(
		long stdId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the external link standardses where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByStdId(
		long stdId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first external link standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards findByStdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first external link standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards, or <code>null</code> if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards fetchByStdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last external link standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards findByStdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last external link standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards, or <code>null</code> if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards fetchByStdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the external link standardses before and after the current external link standards in the ordered set where stdId = &#63;.
	*
	* @param extLinkId the primary key of the current external link standards
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a external link standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards[] findByStdId_PrevAndNext(
		long extLinkId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the external link standardses where stdId = &#63; from the database.
	*
	* @param stdId the std ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of external link standardses where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the number of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the external link standardses where parentExtLinkId = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @return the matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByParentExtLinkId(
		long parentExtLinkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the external link standardses where parentExtLinkId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentExtLinkId the parent ext link ID
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @return the range of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByParentExtLinkId(
		long parentExtLinkId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the external link standardses where parentExtLinkId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentExtLinkId the parent ext link ID
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByParentExtLinkId(
		long parentExtLinkId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first external link standards in the ordered set where parentExtLinkId = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards findByParentExtLinkId_First(
		long parentExtLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first external link standards in the ordered set where parentExtLinkId = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards, or <code>null</code> if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards fetchByParentExtLinkId_First(
		long parentExtLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last external link standards in the ordered set where parentExtLinkId = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards findByParentExtLinkId_Last(
		long parentExtLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last external link standards in the ordered set where parentExtLinkId = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards, or <code>null</code> if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards fetchByParentExtLinkId_Last(
		long parentExtLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the external link standardses before and after the current external link standards in the ordered set where parentExtLinkId = &#63;.
	*
	* @param extLinkId the primary key of the current external link standards
	* @param parentExtLinkId the parent ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a external link standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards[] findByParentExtLinkId_PrevAndNext(
		long extLinkId, long parentExtLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the external link standardses where parentExtLinkId = &#63; from the database.
	*
	* @param parentExtLinkId the parent ext link ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentExtLinkId(long parentExtLinkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of external link standardses where parentExtLinkId = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @return the number of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentExtLinkId(long parentExtLinkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the external link standardses where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @return the matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByparentIdStdIdLocaleCd(
		long parentExtLinkId, long stdId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the external link standardses where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @return the range of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByparentIdStdIdLocaleCd(
		long parentExtLinkId, long stdId, java.lang.String localeCode,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the external link standardses where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByparentIdStdIdLocaleCd(
		long parentExtLinkId, long stdId, java.lang.String localeCode,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards findByparentIdStdIdLocaleCd_First(
		long parentExtLinkId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards, or <code>null</code> if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards fetchByparentIdStdIdLocaleCd_First(
		long parentExtLinkId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards findByparentIdStdIdLocaleCd_Last(
		long parentExtLinkId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards, or <code>null</code> if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards fetchByparentIdStdIdLocaleCd_Last(
		long parentExtLinkId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the external link standardses before and after the current external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param extLinkId the primary key of the current external link standards
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a external link standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards[] findByparentIdStdIdLocaleCd_PrevAndNext(
		long extLinkId, long parentExtLinkId, long stdId,
		java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the external link standardses where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63; from the database.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByparentIdStdIdLocaleCd(long parentExtLinkId, long stdId,
		java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of external link standardses where parentExtLinkId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @return the number of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countByparentIdStdIdLocaleCd(long parentExtLinkId, long stdId,
		java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the external link standardses where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @return the matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByStdIdLocaleCd(
		long stdId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the external link standardses where stdId = &#63; and localeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @return the range of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByStdIdLocaleCd(
		long stdId, java.lang.String localeCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the external link standardses where stdId = &#63; and localeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByStdIdLocaleCd(
		long stdId, java.lang.String localeCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards findByStdIdLocaleCd_First(
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards, or <code>null</code> if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards fetchByStdIdLocaleCd_First(
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards findByStdIdLocaleCd_Last(
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards, or <code>null</code> if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards fetchByStdIdLocaleCd_Last(
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the external link standardses before and after the current external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param extLinkId the primary key of the current external link standards
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a external link standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards[] findByStdIdLocaleCd_PrevAndNext(
		long extLinkId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the external link standardses where stdId = &#63; and localeCode = &#63; from the database.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStdIdLocaleCd(long stdId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of external link standardses where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @return the number of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countByStdIdLocaleCd(long stdId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the external link standardses where parentExtLinkId = &#63; and stdId = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @return the matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByParentIdStdId(
		long parentExtLinkId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the external link standardses where parentExtLinkId = &#63; and stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @return the range of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByParentIdStdId(
		long parentExtLinkId, long stdId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the external link standardses where parentExtLinkId = &#63; and stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findByParentIdStdId(
		long parentExtLinkId, long stdId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards findByParentIdStdId_First(
		long parentExtLinkId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards, or <code>null</code> if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards fetchByParentIdStdId_First(
		long parentExtLinkId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards findByParentIdStdId_Last(
		long parentExtLinkId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards, or <code>null</code> if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards fetchByParentIdStdId_Last(
		long parentExtLinkId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the external link standardses before and after the current external link standards in the ordered set where parentExtLinkId = &#63; and stdId = &#63;.
	*
	* @param extLinkId the primary key of the current external link standards
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a external link standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards[] findByParentIdStdId_PrevAndNext(
		long extLinkId, long parentExtLinkId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the external link standardses where parentExtLinkId = &#63; and stdId = &#63; from the database.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentIdStdId(long parentExtLinkId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of external link standardses where parentExtLinkId = &#63; and stdId = &#63;.
	*
	* @param parentExtLinkId the parent ext link ID
	* @param stdId the std ID
	* @return the number of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentIdStdId(long parentExtLinkId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the external link standardses where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findBystdParents(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the external link standardses where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @return the range of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findBystdParents(
		long stdId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the external link standardses where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findBystdParents(
		long stdId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first external link standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards findBystdParents_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first external link standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards, or <code>null</code> if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards fetchBystdParents_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last external link standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards findBystdParents_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last external link standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards, or <code>null</code> if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards fetchBystdParents_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the external link standardses before and after the current external link standards in the ordered set where stdId = &#63;.
	*
	* @param extLinkId the primary key of the current external link standards
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a external link standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards[] findBystdParents_PrevAndNext(
		long extLinkId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the external link standardses where stdId = &#63; from the database.
	*
	* @param stdId the std ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBystdParents(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of external link standardses where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the number of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countBystdParents(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the external link standardses where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @return the matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findBystdParentsLocaleCode(
		long stdId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the external link standardses where stdId = &#63; and localeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @return the range of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findBystdParentsLocaleCode(
		long stdId, java.lang.String localeCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the external link standardses where stdId = &#63; and localeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findBystdParentsLocaleCode(
		long stdId, java.lang.String localeCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards findBystdParentsLocaleCode_First(
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards, or <code>null</code> if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards fetchBystdParentsLocaleCode_First(
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards findBystdParentsLocaleCode_Last(
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards, or <code>null</code> if a matching external link standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards fetchBystdParentsLocaleCode_Last(
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the external link standardses before and after the current external link standards in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param extLinkId the primary key of the current external link standards
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a external link standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards[] findBystdParentsLocaleCode_PrevAndNext(
		long extLinkId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the external link standardses where stdId = &#63; and localeCode = &#63; from the database.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @throws SystemException if a system exception occurred
	*/
	public void removeBystdParentsLocaleCode(long stdId,
		java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of external link standardses where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @return the number of matching external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countBystdParentsLocaleCode(long stdId,
		java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the external link standards in the entity cache if it is enabled.
	*
	* @param externalLinkStandards the external link standards
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.ExternalLinkStandards externalLinkStandards);

	/**
	* Caches the external link standardses in the entity cache if it is enabled.
	*
	* @param externalLinkStandardses the external link standardses
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> externalLinkStandardses);

	/**
	* Creates a new external link standards with the primary key. Does not add the external link standards to the database.
	*
	* @param extLinkId the primary key for the new external link standards
	* @return the new external link standards
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards create(
		long extLinkId);

	/**
	* Removes the external link standards with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param extLinkId the primary key of the external link standards
	* @return the external link standards that was removed
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a external link standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards remove(
		long extLinkId)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.ExternalLinkStandards updateImpl(
		com.ihg.brandstandards.db.model.ExternalLinkStandards externalLinkStandards)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the external link standards with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException} if it could not be found.
	*
	* @param extLinkId the primary key of the external link standards
	* @return the external link standards
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException if a external link standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards findByPrimaryKey(
		long extLinkId)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the external link standards with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param extLinkId the primary key of the external link standards
	* @return the external link standards, or <code>null</code> if a external link standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandards fetchByPrimaryKey(
		long extLinkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the external link standardses.
	*
	* @return the external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the external link standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @return the range of external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the external link standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of external link standardses
	* @param end the upper bound of the range of external link standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the external link standardses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of external link standardses.
	*
	* @return the number of external link standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}