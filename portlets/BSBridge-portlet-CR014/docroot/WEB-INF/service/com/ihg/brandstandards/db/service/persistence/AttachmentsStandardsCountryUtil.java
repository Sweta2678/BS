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

import com.ihg.brandstandards.db.model.AttachmentsStandardsCountry;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the attachments standards country service. This utility wraps {@link AttachmentsStandardsCountryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see AttachmentsStandardsCountryPersistence
 * @see AttachmentsStandardsCountryPersistenceImpl
 * @generated
 */
public class AttachmentsStandardsCountryUtil {
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
	public static void clearCache(
		AttachmentsStandardsCountry attachmentsStandardsCountry) {
		getPersistence().clearCache(attachmentsStandardsCountry);
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
	public static List<AttachmentsStandardsCountry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AttachmentsStandardsCountry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AttachmentsStandardsCountry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static AttachmentsStandardsCountry update(
		AttachmentsStandardsCountry attachmentsStandardsCountry)
		throws SystemException {
		return getPersistence().update(attachmentsStandardsCountry);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static AttachmentsStandardsCountry update(
		AttachmentsStandardsCountry attachmentsStandardsCountry,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(attachmentsStandardsCountry, serviceContext);
	}

	/**
	* Returns all the attachments standards countries where attachmentId = &#63;.
	*
	* @param attachmentId the attachment ID
	* @return the matching attachments standards countries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandardsCountry> findByattachmentId(
		long attachmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByattachmentId(attachmentId);
	}

	/**
	* Returns a range of all the attachments standards countries where attachmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param attachmentId the attachment ID
	* @param start the lower bound of the range of attachments standards countries
	* @param end the upper bound of the range of attachments standards countries (not inclusive)
	* @return the range of matching attachments standards countries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandardsCountry> findByattachmentId(
		long attachmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByattachmentId(attachmentId, start, end);
	}

	/**
	* Returns an ordered range of all the attachments standards countries where attachmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param attachmentId the attachment ID
	* @param start the lower bound of the range of attachments standards countries
	* @param end the upper bound of the range of attachments standards countries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching attachments standards countries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandardsCountry> findByattachmentId(
		long attachmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByattachmentId(attachmentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first attachments standards country in the ordered set where attachmentId = &#63;.
	*
	* @param attachmentId the attachment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attachments standards country
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsCountryException if a matching attachments standards country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandardsCountry findByattachmentId_First(
		long attachmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByattachmentId_First(attachmentId, orderByComparator);
	}

	/**
	* Returns the first attachments standards country in the ordered set where attachmentId = &#63;.
	*
	* @param attachmentId the attachment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching attachments standards country, or <code>null</code> if a matching attachments standards country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandardsCountry fetchByattachmentId_First(
		long attachmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByattachmentId_First(attachmentId, orderByComparator);
	}

	/**
	* Returns the last attachments standards country in the ordered set where attachmentId = &#63;.
	*
	* @param attachmentId the attachment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attachments standards country
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsCountryException if a matching attachments standards country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandardsCountry findByattachmentId_Last(
		long attachmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByattachmentId_Last(attachmentId, orderByComparator);
	}

	/**
	* Returns the last attachments standards country in the ordered set where attachmentId = &#63;.
	*
	* @param attachmentId the attachment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching attachments standards country, or <code>null</code> if a matching attachments standards country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandardsCountry fetchByattachmentId_Last(
		long attachmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByattachmentId_Last(attachmentId, orderByComparator);
	}

	/**
	* Returns the attachments standards countries before and after the current attachments standards country in the ordered set where attachmentId = &#63;.
	*
	* @param attachmentsStandardsCountryPK the primary key of the current attachments standards country
	* @param attachmentId the attachment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next attachments standards country
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsCountryException if a attachments standards country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandardsCountry[] findByattachmentId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsCountryPK attachmentsStandardsCountryPK,
		long attachmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByattachmentId_PrevAndNext(attachmentsStandardsCountryPK,
			attachmentId, orderByComparator);
	}

	/**
	* Removes all the attachments standards countries where attachmentId = &#63; from the database.
	*
	* @param attachmentId the attachment ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByattachmentId(long attachmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByattachmentId(attachmentId);
	}

	/**
	* Returns the number of attachments standards countries where attachmentId = &#63;.
	*
	* @param attachmentId the attachment ID
	* @return the number of matching attachments standards countries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByattachmentId(long attachmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByattachmentId(attachmentId);
	}

	/**
	* Caches the attachments standards country in the entity cache if it is enabled.
	*
	* @param attachmentsStandardsCountry the attachments standards country
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.AttachmentsStandardsCountry attachmentsStandardsCountry) {
		getPersistence().cacheResult(attachmentsStandardsCountry);
	}

	/**
	* Caches the attachments standards countries in the entity cache if it is enabled.
	*
	* @param attachmentsStandardsCountries the attachments standards countries
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandardsCountry> attachmentsStandardsCountries) {
		getPersistence().cacheResult(attachmentsStandardsCountries);
	}

	/**
	* Creates a new attachments standards country with the primary key. Does not add the attachments standards country to the database.
	*
	* @param attachmentsStandardsCountryPK the primary key for the new attachments standards country
	* @return the new attachments standards country
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandardsCountry create(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsCountryPK attachmentsStandardsCountryPK) {
		return getPersistence().create(attachmentsStandardsCountryPK);
	}

	/**
	* Removes the attachments standards country with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param attachmentsStandardsCountryPK the primary key of the attachments standards country
	* @return the attachments standards country that was removed
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsCountryException if a attachments standards country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandardsCountry remove(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsCountryPK attachmentsStandardsCountryPK)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(attachmentsStandardsCountryPK);
	}

	public static com.ihg.brandstandards.db.model.AttachmentsStandardsCountry updateImpl(
		com.ihg.brandstandards.db.model.AttachmentsStandardsCountry attachmentsStandardsCountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(attachmentsStandardsCountry);
	}

	/**
	* Returns the attachments standards country with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchAttachmentsStandardsCountryException} if it could not be found.
	*
	* @param attachmentsStandardsCountryPK the primary key of the attachments standards country
	* @return the attachments standards country
	* @throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsCountryException if a attachments standards country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandardsCountry findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsCountryPK attachmentsStandardsCountryPK)
		throws com.ihg.brandstandards.db.NoSuchAttachmentsStandardsCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(attachmentsStandardsCountryPK);
	}

	/**
	* Returns the attachments standards country with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param attachmentsStandardsCountryPK the primary key of the attachments standards country
	* @return the attachments standards country, or <code>null</code> if a attachments standards country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.AttachmentsStandardsCountry fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsCountryPK attachmentsStandardsCountryPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(attachmentsStandardsCountryPK);
	}

	/**
	* Returns all the attachments standards countries.
	*
	* @return the attachments standards countries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandardsCountry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandardsCountry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the attachments standards countries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of attachments standards countries
	* @param end the upper bound of the range of attachments standards countries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of attachments standards countries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.AttachmentsStandardsCountry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the attachments standards countries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of attachments standards countries.
	*
	* @return the number of attachments standards countries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AttachmentsStandardsCountryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AttachmentsStandardsCountryPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					AttachmentsStandardsCountryPersistence.class.getName());

			ReferenceRegistry.registerReference(AttachmentsStandardsCountryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		AttachmentsStandardsCountryPersistence persistence) {
	}

	private static AttachmentsStandardsCountryPersistence _persistence;
}