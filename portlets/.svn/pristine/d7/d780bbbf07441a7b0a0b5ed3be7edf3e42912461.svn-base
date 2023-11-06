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

import com.ihg.brandstandards.db.model.ChainAttachmentsStandards;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the chain attachments standards service. This utility wraps {@link ChainAttachmentsStandardsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see ChainAttachmentsStandardsPersistence
 * @see ChainAttachmentsStandardsPersistenceImpl
 * @generated
 */
public class ChainAttachmentsStandardsUtil {
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
		ChainAttachmentsStandards chainAttachmentsStandards) {
		getPersistence().clearCache(chainAttachmentsStandards);
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
	public static List<ChainAttachmentsStandards> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ChainAttachmentsStandards> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ChainAttachmentsStandards> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ChainAttachmentsStandards update(
		ChainAttachmentsStandards chainAttachmentsStandards)
		throws SystemException {
		return getPersistence().update(chainAttachmentsStandards);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ChainAttachmentsStandards update(
		ChainAttachmentsStandards chainAttachmentsStandards,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(chainAttachmentsStandards, serviceContext);
	}

	/**
	* Returns all the chain attachments standardses where attachmentId = &#63;.
	*
	* @param attachmentId the attachment ID
	* @return the matching chain attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ChainAttachmentsStandards> findByAttachmentId(
		long attachmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAttachmentId(attachmentId);
	}

	/**
	* Returns a range of all the chain attachments standardses where attachmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainAttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param attachmentId the attachment ID
	* @param start the lower bound of the range of chain attachments standardses
	* @param end the upper bound of the range of chain attachments standardses (not inclusive)
	* @return the range of matching chain attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ChainAttachmentsStandards> findByAttachmentId(
		long attachmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAttachmentId(attachmentId, start, end);
	}

	/**
	* Returns an ordered range of all the chain attachments standardses where attachmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainAttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param attachmentId the attachment ID
	* @param start the lower bound of the range of chain attachments standardses
	* @param end the upper bound of the range of chain attachments standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching chain attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ChainAttachmentsStandards> findByAttachmentId(
		long attachmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAttachmentId(attachmentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first chain attachments standards in the ordered set where attachmentId = &#63;.
	*
	* @param attachmentId the attachment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching chain attachments standards
	* @throws com.ihg.brandstandards.db.NoSuchChainAttachmentsStandardsException if a matching chain attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainAttachmentsStandards findByAttachmentId_First(
		long attachmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchChainAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAttachmentId_First(attachmentId, orderByComparator);
	}

	/**
	* Returns the first chain attachments standards in the ordered set where attachmentId = &#63;.
	*
	* @param attachmentId the attachment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching chain attachments standards, or <code>null</code> if a matching chain attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainAttachmentsStandards fetchByAttachmentId_First(
		long attachmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAttachmentId_First(attachmentId, orderByComparator);
	}

	/**
	* Returns the last chain attachments standards in the ordered set where attachmentId = &#63;.
	*
	* @param attachmentId the attachment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching chain attachments standards
	* @throws com.ihg.brandstandards.db.NoSuchChainAttachmentsStandardsException if a matching chain attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainAttachmentsStandards findByAttachmentId_Last(
		long attachmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchChainAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAttachmentId_Last(attachmentId, orderByComparator);
	}

	/**
	* Returns the last chain attachments standards in the ordered set where attachmentId = &#63;.
	*
	* @param attachmentId the attachment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching chain attachments standards, or <code>null</code> if a matching chain attachments standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainAttachmentsStandards fetchByAttachmentId_Last(
		long attachmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAttachmentId_Last(attachmentId, orderByComparator);
	}

	/**
	* Returns the chain attachments standardses before and after the current chain attachments standards in the ordered set where attachmentId = &#63;.
	*
	* @param chainAttachmentId the primary key of the current chain attachments standards
	* @param attachmentId the attachment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next chain attachments standards
	* @throws com.ihg.brandstandards.db.NoSuchChainAttachmentsStandardsException if a chain attachments standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainAttachmentsStandards[] findByAttachmentId_PrevAndNext(
		long chainAttachmentId, long attachmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchChainAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAttachmentId_PrevAndNext(chainAttachmentId,
			attachmentId, orderByComparator);
	}

	/**
	* Removes all the chain attachments standardses where attachmentId = &#63; from the database.
	*
	* @param attachmentId the attachment ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAttachmentId(long attachmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAttachmentId(attachmentId);
	}

	/**
	* Returns the number of chain attachments standardses where attachmentId = &#63;.
	*
	* @param attachmentId the attachment ID
	* @return the number of matching chain attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAttachmentId(long attachmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAttachmentId(attachmentId);
	}

	/**
	* Caches the chain attachments standards in the entity cache if it is enabled.
	*
	* @param chainAttachmentsStandards the chain attachments standards
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.ChainAttachmentsStandards chainAttachmentsStandards) {
		getPersistence().cacheResult(chainAttachmentsStandards);
	}

	/**
	* Caches the chain attachments standardses in the entity cache if it is enabled.
	*
	* @param chainAttachmentsStandardses the chain attachments standardses
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.ChainAttachmentsStandards> chainAttachmentsStandardses) {
		getPersistence().cacheResult(chainAttachmentsStandardses);
	}

	/**
	* Creates a new chain attachments standards with the primary key. Does not add the chain attachments standards to the database.
	*
	* @param chainAttachmentId the primary key for the new chain attachments standards
	* @return the new chain attachments standards
	*/
	public static com.ihg.brandstandards.db.model.ChainAttachmentsStandards create(
		long chainAttachmentId) {
		return getPersistence().create(chainAttachmentId);
	}

	/**
	* Removes the chain attachments standards with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param chainAttachmentId the primary key of the chain attachments standards
	* @return the chain attachments standards that was removed
	* @throws com.ihg.brandstandards.db.NoSuchChainAttachmentsStandardsException if a chain attachments standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainAttachmentsStandards remove(
		long chainAttachmentId)
		throws com.ihg.brandstandards.db.NoSuchChainAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(chainAttachmentId);
	}

	public static com.ihg.brandstandards.db.model.ChainAttachmentsStandards updateImpl(
		com.ihg.brandstandards.db.model.ChainAttachmentsStandards chainAttachmentsStandards)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(chainAttachmentsStandards);
	}

	/**
	* Returns the chain attachments standards with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchChainAttachmentsStandardsException} if it could not be found.
	*
	* @param chainAttachmentId the primary key of the chain attachments standards
	* @return the chain attachments standards
	* @throws com.ihg.brandstandards.db.NoSuchChainAttachmentsStandardsException if a chain attachments standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainAttachmentsStandards findByPrimaryKey(
		long chainAttachmentId)
		throws com.ihg.brandstandards.db.NoSuchChainAttachmentsStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(chainAttachmentId);
	}

	/**
	* Returns the chain attachments standards with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param chainAttachmentId the primary key of the chain attachments standards
	* @return the chain attachments standards, or <code>null</code> if a chain attachments standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainAttachmentsStandards fetchByPrimaryKey(
		long chainAttachmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(chainAttachmentId);
	}

	/**
	* Returns all the chain attachments standardses.
	*
	* @return the chain attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ChainAttachmentsStandards> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the chain attachments standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainAttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of chain attachments standardses
	* @param end the upper bound of the range of chain attachments standardses (not inclusive)
	* @return the range of chain attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ChainAttachmentsStandards> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the chain attachments standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainAttachmentsStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of chain attachments standardses
	* @param end the upper bound of the range of chain attachments standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of chain attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ChainAttachmentsStandards> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the chain attachments standardses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of chain attachments standardses.
	*
	* @return the number of chain attachments standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ChainAttachmentsStandardsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ChainAttachmentsStandardsPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					ChainAttachmentsStandardsPersistence.class.getName());

			ReferenceRegistry.registerReference(ChainAttachmentsStandardsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ChainAttachmentsStandardsPersistence persistence) {
	}

	private static ChainAttachmentsStandardsPersistence _persistence;
}