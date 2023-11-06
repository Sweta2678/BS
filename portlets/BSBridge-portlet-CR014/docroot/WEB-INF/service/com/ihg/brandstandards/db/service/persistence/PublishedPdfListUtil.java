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

import com.ihg.brandstandards.db.model.PublishedPdfList;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the published pdf list service. This utility wraps {@link PublishedPdfListPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see PublishedPdfListPersistence
 * @see PublishedPdfListPersistenceImpl
 * @generated
 */
public class PublishedPdfListUtil {
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
	public static void clearCache(PublishedPdfList publishedPdfList) {
		getPersistence().clearCache(publishedPdfList);
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
	public static List<PublishedPdfList> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PublishedPdfList> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PublishedPdfList> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static PublishedPdfList update(PublishedPdfList publishedPdfList)
		throws SystemException {
		return getPersistence().update(publishedPdfList);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static PublishedPdfList update(PublishedPdfList publishedPdfList,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(publishedPdfList, serviceContext);
	}

	/**
	* Returns the published pdf list where pdfId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublishedPdfListException} if it could not be found.
	*
	* @param pdfId the pdf ID
	* @return the matching published pdf list
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList findByPdfId(
		long pdfId)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPdfId(pdfId);
	}

	/**
	* Returns the published pdf list where pdfId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param pdfId the pdf ID
	* @return the matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList fetchByPdfId(
		long pdfId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPdfId(pdfId);
	}

	/**
	* Returns the published pdf list where pdfId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param pdfId the pdf ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList fetchByPdfId(
		long pdfId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPdfId(pdfId, retrieveFromCache);
	}

	/**
	* Removes the published pdf list where pdfId = &#63; from the database.
	*
	* @param pdfId the pdf ID
	* @return the published pdf list that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList removeByPdfId(
		long pdfId)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByPdfId(pdfId);
	}

	/**
	* Returns the number of published pdf lists where pdfId = &#63;.
	*
	* @param pdfId the pdf ID
	* @return the number of matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPdfId(long pdfId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPdfId(pdfId);
	}

	/**
	* Returns all the published pdf lists where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @return the matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findByPublishId(
		long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPublishId(publishId);
	}

	/**
	* Returns a range of all the published pdf lists where publishId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param start the lower bound of the range of published pdf lists
	* @param end the upper bound of the range of published pdf lists (not inclusive)
	* @return the range of matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findByPublishId(
		long publishId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPublishId(publishId, start, end);
	}

	/**
	* Returns an ordered range of all the published pdf lists where publishId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param start the lower bound of the range of published pdf lists
	* @param end the upper bound of the range of published pdf lists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findByPublishId(
		long publishId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishId(publishId, start, end, orderByComparator);
	}

	/**
	* Returns the first published pdf list in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching published pdf list
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList findByPublishId_First(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishId_First(publishId, orderByComparator);
	}

	/**
	* Returns the first published pdf list in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList fetchByPublishId_First(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishId_First(publishId, orderByComparator);
	}

	/**
	* Returns the last published pdf list in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching published pdf list
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList findByPublishId_Last(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishId_Last(publishId, orderByComparator);
	}

	/**
	* Returns the last published pdf list in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList fetchByPublishId_Last(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishId_Last(publishId, orderByComparator);
	}

	/**
	* Returns the published pdf lists before and after the current published pdf list in the ordered set where publishId = &#63;.
	*
	* @param pdfId the primary key of the current published pdf list
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next published pdf list
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a published pdf list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList[] findByPublishId_PrevAndNext(
		long pdfId, long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishId_PrevAndNext(pdfId, publishId,
			orderByComparator);
	}

	/**
	* Removes all the published pdf lists where publishId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPublishId(long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPublishId(publishId);
	}

	/**
	* Returns the number of published pdf lists where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @return the number of matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPublishId(long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPublishId(publishId);
	}

	/**
	* Returns all the published pdf lists where pdfChainCode = &#63;.
	*
	* @param pdfChainCode the pdf chain code
	* @return the matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findByPdfChainCode(
		java.lang.String pdfChainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPdfChainCode(pdfChainCode);
	}

	/**
	* Returns a range of all the published pdf lists where pdfChainCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pdfChainCode the pdf chain code
	* @param start the lower bound of the range of published pdf lists
	* @param end the upper bound of the range of published pdf lists (not inclusive)
	* @return the range of matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findByPdfChainCode(
		java.lang.String pdfChainCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPdfChainCode(pdfChainCode, start, end);
	}

	/**
	* Returns an ordered range of all the published pdf lists where pdfChainCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pdfChainCode the pdf chain code
	* @param start the lower bound of the range of published pdf lists
	* @param end the upper bound of the range of published pdf lists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findByPdfChainCode(
		java.lang.String pdfChainCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPdfChainCode(pdfChainCode, start, end,
			orderByComparator);
	}

	/**
	* Returns the first published pdf list in the ordered set where pdfChainCode = &#63;.
	*
	* @param pdfChainCode the pdf chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching published pdf list
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList findByPdfChainCode_First(
		java.lang.String pdfChainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPdfChainCode_First(pdfChainCode, orderByComparator);
	}

	/**
	* Returns the first published pdf list in the ordered set where pdfChainCode = &#63;.
	*
	* @param pdfChainCode the pdf chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList fetchByPdfChainCode_First(
		java.lang.String pdfChainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPdfChainCode_First(pdfChainCode, orderByComparator);
	}

	/**
	* Returns the last published pdf list in the ordered set where pdfChainCode = &#63;.
	*
	* @param pdfChainCode the pdf chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching published pdf list
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList findByPdfChainCode_Last(
		java.lang.String pdfChainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPdfChainCode_Last(pdfChainCode, orderByComparator);
	}

	/**
	* Returns the last published pdf list in the ordered set where pdfChainCode = &#63;.
	*
	* @param pdfChainCode the pdf chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList fetchByPdfChainCode_Last(
		java.lang.String pdfChainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPdfChainCode_Last(pdfChainCode, orderByComparator);
	}

	/**
	* Returns the published pdf lists before and after the current published pdf list in the ordered set where pdfChainCode = &#63;.
	*
	* @param pdfId the primary key of the current published pdf list
	* @param pdfChainCode the pdf chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next published pdf list
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a published pdf list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList[] findByPdfChainCode_PrevAndNext(
		long pdfId, java.lang.String pdfChainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPdfChainCode_PrevAndNext(pdfId, pdfChainCode,
			orderByComparator);
	}

	/**
	* Removes all the published pdf lists where pdfChainCode = &#63; from the database.
	*
	* @param pdfChainCode the pdf chain code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPdfChainCode(java.lang.String pdfChainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPdfChainCode(pdfChainCode);
	}

	/**
	* Returns the number of published pdf lists where pdfChainCode = &#63;.
	*
	* @param pdfChainCode the pdf chain code
	* @return the number of matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPdfChainCode(java.lang.String pdfChainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPdfChainCode(pdfChainCode);
	}

	/**
	* Returns all the published pdf lists where pdfCtryCode = &#63;.
	*
	* @param pdfCtryCode the pdf ctry code
	* @return the matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findByPdfCtryCode(
		java.lang.String pdfCtryCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPdfCtryCode(pdfCtryCode);
	}

	/**
	* Returns a range of all the published pdf lists where pdfCtryCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pdfCtryCode the pdf ctry code
	* @param start the lower bound of the range of published pdf lists
	* @param end the upper bound of the range of published pdf lists (not inclusive)
	* @return the range of matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findByPdfCtryCode(
		java.lang.String pdfCtryCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPdfCtryCode(pdfCtryCode, start, end);
	}

	/**
	* Returns an ordered range of all the published pdf lists where pdfCtryCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pdfCtryCode the pdf ctry code
	* @param start the lower bound of the range of published pdf lists
	* @param end the upper bound of the range of published pdf lists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findByPdfCtryCode(
		java.lang.String pdfCtryCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPdfCtryCode(pdfCtryCode, start, end, orderByComparator);
	}

	/**
	* Returns the first published pdf list in the ordered set where pdfCtryCode = &#63;.
	*
	* @param pdfCtryCode the pdf ctry code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching published pdf list
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList findByPdfCtryCode_First(
		java.lang.String pdfCtryCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPdfCtryCode_First(pdfCtryCode, orderByComparator);
	}

	/**
	* Returns the first published pdf list in the ordered set where pdfCtryCode = &#63;.
	*
	* @param pdfCtryCode the pdf ctry code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList fetchByPdfCtryCode_First(
		java.lang.String pdfCtryCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPdfCtryCode_First(pdfCtryCode, orderByComparator);
	}

	/**
	* Returns the last published pdf list in the ordered set where pdfCtryCode = &#63;.
	*
	* @param pdfCtryCode the pdf ctry code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching published pdf list
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList findByPdfCtryCode_Last(
		java.lang.String pdfCtryCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPdfCtryCode_Last(pdfCtryCode, orderByComparator);
	}

	/**
	* Returns the last published pdf list in the ordered set where pdfCtryCode = &#63;.
	*
	* @param pdfCtryCode the pdf ctry code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList fetchByPdfCtryCode_Last(
		java.lang.String pdfCtryCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPdfCtryCode_Last(pdfCtryCode, orderByComparator);
	}

	/**
	* Returns the published pdf lists before and after the current published pdf list in the ordered set where pdfCtryCode = &#63;.
	*
	* @param pdfId the primary key of the current published pdf list
	* @param pdfCtryCode the pdf ctry code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next published pdf list
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a published pdf list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList[] findByPdfCtryCode_PrevAndNext(
		long pdfId, java.lang.String pdfCtryCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPdfCtryCode_PrevAndNext(pdfId, pdfCtryCode,
			orderByComparator);
	}

	/**
	* Removes all the published pdf lists where pdfCtryCode = &#63; from the database.
	*
	* @param pdfCtryCode the pdf ctry code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPdfCtryCode(java.lang.String pdfCtryCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPdfCtryCode(pdfCtryCode);
	}

	/**
	* Returns the number of published pdf lists where pdfCtryCode = &#63;.
	*
	* @param pdfCtryCode the pdf ctry code
	* @return the number of matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPdfCtryCode(java.lang.String pdfCtryCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPdfCtryCode(pdfCtryCode);
	}

	/**
	* Returns all the published pdf lists where pdfFileName = &#63;.
	*
	* @param pdfFileName the pdf file name
	* @return the matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findByPdfFileName(
		java.lang.String pdfFileName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPdfFileName(pdfFileName);
	}

	/**
	* Returns a range of all the published pdf lists where pdfFileName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pdfFileName the pdf file name
	* @param start the lower bound of the range of published pdf lists
	* @param end the upper bound of the range of published pdf lists (not inclusive)
	* @return the range of matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findByPdfFileName(
		java.lang.String pdfFileName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPdfFileName(pdfFileName, start, end);
	}

	/**
	* Returns an ordered range of all the published pdf lists where pdfFileName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pdfFileName the pdf file name
	* @param start the lower bound of the range of published pdf lists
	* @param end the upper bound of the range of published pdf lists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findByPdfFileName(
		java.lang.String pdfFileName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPdfFileName(pdfFileName, start, end, orderByComparator);
	}

	/**
	* Returns the first published pdf list in the ordered set where pdfFileName = &#63;.
	*
	* @param pdfFileName the pdf file name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching published pdf list
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList findByPdfFileName_First(
		java.lang.String pdfFileName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPdfFileName_First(pdfFileName, orderByComparator);
	}

	/**
	* Returns the first published pdf list in the ordered set where pdfFileName = &#63;.
	*
	* @param pdfFileName the pdf file name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList fetchByPdfFileName_First(
		java.lang.String pdfFileName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPdfFileName_First(pdfFileName, orderByComparator);
	}

	/**
	* Returns the last published pdf list in the ordered set where pdfFileName = &#63;.
	*
	* @param pdfFileName the pdf file name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching published pdf list
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList findByPdfFileName_Last(
		java.lang.String pdfFileName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPdfFileName_Last(pdfFileName, orderByComparator);
	}

	/**
	* Returns the last published pdf list in the ordered set where pdfFileName = &#63;.
	*
	* @param pdfFileName the pdf file name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList fetchByPdfFileName_Last(
		java.lang.String pdfFileName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPdfFileName_Last(pdfFileName, orderByComparator);
	}

	/**
	* Returns the published pdf lists before and after the current published pdf list in the ordered set where pdfFileName = &#63;.
	*
	* @param pdfId the primary key of the current published pdf list
	* @param pdfFileName the pdf file name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next published pdf list
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a published pdf list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList[] findByPdfFileName_PrevAndNext(
		long pdfId, java.lang.String pdfFileName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPdfFileName_PrevAndNext(pdfId, pdfFileName,
			orderByComparator);
	}

	/**
	* Removes all the published pdf lists where pdfFileName = &#63; from the database.
	*
	* @param pdfFileName the pdf file name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPdfFileName(java.lang.String pdfFileName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPdfFileName(pdfFileName);
	}

	/**
	* Returns the number of published pdf lists where pdfFileName = &#63;.
	*
	* @param pdfFileName the pdf file name
	* @return the number of matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPdfFileName(java.lang.String pdfFileName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPdfFileName(pdfFileName);
	}

	/**
	* Returns all the published pdf lists where pdfFileURLText = &#63;.
	*
	* @param pdfFileURLText the pdf file u r l text
	* @return the matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findByPdfFileURLText(
		java.lang.String pdfFileURLText)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPdfFileURLText(pdfFileURLText);
	}

	/**
	* Returns a range of all the published pdf lists where pdfFileURLText = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pdfFileURLText the pdf file u r l text
	* @param start the lower bound of the range of published pdf lists
	* @param end the upper bound of the range of published pdf lists (not inclusive)
	* @return the range of matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findByPdfFileURLText(
		java.lang.String pdfFileURLText, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPdfFileURLText(pdfFileURLText, start, end);
	}

	/**
	* Returns an ordered range of all the published pdf lists where pdfFileURLText = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pdfFileURLText the pdf file u r l text
	* @param start the lower bound of the range of published pdf lists
	* @param end the upper bound of the range of published pdf lists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findByPdfFileURLText(
		java.lang.String pdfFileURLText, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPdfFileURLText(pdfFileURLText, start, end,
			orderByComparator);
	}

	/**
	* Returns the first published pdf list in the ordered set where pdfFileURLText = &#63;.
	*
	* @param pdfFileURLText the pdf file u r l text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching published pdf list
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList findByPdfFileURLText_First(
		java.lang.String pdfFileURLText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPdfFileURLText_First(pdfFileURLText, orderByComparator);
	}

	/**
	* Returns the first published pdf list in the ordered set where pdfFileURLText = &#63;.
	*
	* @param pdfFileURLText the pdf file u r l text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList fetchByPdfFileURLText_First(
		java.lang.String pdfFileURLText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPdfFileURLText_First(pdfFileURLText,
			orderByComparator);
	}

	/**
	* Returns the last published pdf list in the ordered set where pdfFileURLText = &#63;.
	*
	* @param pdfFileURLText the pdf file u r l text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching published pdf list
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList findByPdfFileURLText_Last(
		java.lang.String pdfFileURLText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPdfFileURLText_Last(pdfFileURLText, orderByComparator);
	}

	/**
	* Returns the last published pdf list in the ordered set where pdfFileURLText = &#63;.
	*
	* @param pdfFileURLText the pdf file u r l text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList fetchByPdfFileURLText_Last(
		java.lang.String pdfFileURLText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPdfFileURLText_Last(pdfFileURLText, orderByComparator);
	}

	/**
	* Returns the published pdf lists before and after the current published pdf list in the ordered set where pdfFileURLText = &#63;.
	*
	* @param pdfId the primary key of the current published pdf list
	* @param pdfFileURLText the pdf file u r l text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next published pdf list
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a published pdf list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList[] findByPdfFileURLText_PrevAndNext(
		long pdfId, java.lang.String pdfFileURLText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPdfFileURLText_PrevAndNext(pdfId, pdfFileURLText,
			orderByComparator);
	}

	/**
	* Removes all the published pdf lists where pdfFileURLText = &#63; from the database.
	*
	* @param pdfFileURLText the pdf file u r l text
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPdfFileURLText(java.lang.String pdfFileURLText)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPdfFileURLText(pdfFileURLText);
	}

	/**
	* Returns the number of published pdf lists where pdfFileURLText = &#63;.
	*
	* @param pdfFileURLText the pdf file u r l text
	* @return the number of matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPdfFileURLText(java.lang.String pdfFileURLText)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPdfFileURLText(pdfFileURLText);
	}

	/**
	* Returns all the published pdf lists where pdfFileName = &#63; and pdfFileURLText = &#63;.
	*
	* @param pdfFileName the pdf file name
	* @param pdfFileURLText the pdf file u r l text
	* @return the matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findByPdfFileNameAndURL(
		java.lang.String pdfFileName, java.lang.String pdfFileURLText)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPdfFileNameAndURL(pdfFileName, pdfFileURLText);
	}

	/**
	* Returns a range of all the published pdf lists where pdfFileName = &#63; and pdfFileURLText = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pdfFileName the pdf file name
	* @param pdfFileURLText the pdf file u r l text
	* @param start the lower bound of the range of published pdf lists
	* @param end the upper bound of the range of published pdf lists (not inclusive)
	* @return the range of matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findByPdfFileNameAndURL(
		java.lang.String pdfFileName, java.lang.String pdfFileURLText,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPdfFileNameAndURL(pdfFileName, pdfFileURLText, start,
			end);
	}

	/**
	* Returns an ordered range of all the published pdf lists where pdfFileName = &#63; and pdfFileURLText = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pdfFileName the pdf file name
	* @param pdfFileURLText the pdf file u r l text
	* @param start the lower bound of the range of published pdf lists
	* @param end the upper bound of the range of published pdf lists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findByPdfFileNameAndURL(
		java.lang.String pdfFileName, java.lang.String pdfFileURLText,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPdfFileNameAndURL(pdfFileName, pdfFileURLText, start,
			end, orderByComparator);
	}

	/**
	* Returns the first published pdf list in the ordered set where pdfFileName = &#63; and pdfFileURLText = &#63;.
	*
	* @param pdfFileName the pdf file name
	* @param pdfFileURLText the pdf file u r l text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching published pdf list
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList findByPdfFileNameAndURL_First(
		java.lang.String pdfFileName, java.lang.String pdfFileURLText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPdfFileNameAndURL_First(pdfFileName, pdfFileURLText,
			orderByComparator);
	}

	/**
	* Returns the first published pdf list in the ordered set where pdfFileName = &#63; and pdfFileURLText = &#63;.
	*
	* @param pdfFileName the pdf file name
	* @param pdfFileURLText the pdf file u r l text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList fetchByPdfFileNameAndURL_First(
		java.lang.String pdfFileName, java.lang.String pdfFileURLText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPdfFileNameAndURL_First(pdfFileName, pdfFileURLText,
			orderByComparator);
	}

	/**
	* Returns the last published pdf list in the ordered set where pdfFileName = &#63; and pdfFileURLText = &#63;.
	*
	* @param pdfFileName the pdf file name
	* @param pdfFileURLText the pdf file u r l text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching published pdf list
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList findByPdfFileNameAndURL_Last(
		java.lang.String pdfFileName, java.lang.String pdfFileURLText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPdfFileNameAndURL_Last(pdfFileName, pdfFileURLText,
			orderByComparator);
	}

	/**
	* Returns the last published pdf list in the ordered set where pdfFileName = &#63; and pdfFileURLText = &#63;.
	*
	* @param pdfFileName the pdf file name
	* @param pdfFileURLText the pdf file u r l text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList fetchByPdfFileNameAndURL_Last(
		java.lang.String pdfFileName, java.lang.String pdfFileURLText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPdfFileNameAndURL_Last(pdfFileName, pdfFileURLText,
			orderByComparator);
	}

	/**
	* Returns the published pdf lists before and after the current published pdf list in the ordered set where pdfFileName = &#63; and pdfFileURLText = &#63;.
	*
	* @param pdfId the primary key of the current published pdf list
	* @param pdfFileName the pdf file name
	* @param pdfFileURLText the pdf file u r l text
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next published pdf list
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a published pdf list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList[] findByPdfFileNameAndURL_PrevAndNext(
		long pdfId, java.lang.String pdfFileName,
		java.lang.String pdfFileURLText,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPdfFileNameAndURL_PrevAndNext(pdfId, pdfFileName,
			pdfFileURLText, orderByComparator);
	}

	/**
	* Removes all the published pdf lists where pdfFileName = &#63; and pdfFileURLText = &#63; from the database.
	*
	* @param pdfFileName the pdf file name
	* @param pdfFileURLText the pdf file u r l text
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPdfFileNameAndURL(java.lang.String pdfFileName,
		java.lang.String pdfFileURLText)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPdfFileNameAndURL(pdfFileName, pdfFileURLText);
	}

	/**
	* Returns the number of published pdf lists where pdfFileName = &#63; and pdfFileURLText = &#63;.
	*
	* @param pdfFileName the pdf file name
	* @param pdfFileURLText the pdf file u r l text
	* @return the number of matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPdfFileNameAndURL(java.lang.String pdfFileName,
		java.lang.String pdfFileURLText)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPdfFileNameAndURL(pdfFileName, pdfFileURLText);
	}

	/**
	* Returns all the published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfLocaleCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	*
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfLocaleCode the pdf locale code
	* @param pdfBuildType the pdf build type
	* @param pageSizeOrientationType the page size orientation type
	* @return the matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findByPdfManualParams(
		long publishId, java.lang.String pdfCtryCode,
		java.lang.String pdfLocaleCode, java.lang.String pdfBuildType,
		java.lang.String pageSizeOrientationType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPdfManualParams(publishId, pdfCtryCode,
			pdfLocaleCode, pdfBuildType, pageSizeOrientationType);
	}

	/**
	* Returns a range of all the published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfLocaleCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfLocaleCode the pdf locale code
	* @param pdfBuildType the pdf build type
	* @param pageSizeOrientationType the page size orientation type
	* @param start the lower bound of the range of published pdf lists
	* @param end the upper bound of the range of published pdf lists (not inclusive)
	* @return the range of matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findByPdfManualParams(
		long publishId, java.lang.String pdfCtryCode,
		java.lang.String pdfLocaleCode, java.lang.String pdfBuildType,
		java.lang.String pageSizeOrientationType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPdfManualParams(publishId, pdfCtryCode,
			pdfLocaleCode, pdfBuildType, pageSizeOrientationType, start, end);
	}

	/**
	* Returns an ordered range of all the published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfLocaleCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfLocaleCode the pdf locale code
	* @param pdfBuildType the pdf build type
	* @param pageSizeOrientationType the page size orientation type
	* @param start the lower bound of the range of published pdf lists
	* @param end the upper bound of the range of published pdf lists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findByPdfManualParams(
		long publishId, java.lang.String pdfCtryCode,
		java.lang.String pdfLocaleCode, java.lang.String pdfBuildType,
		java.lang.String pageSizeOrientationType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPdfManualParams(publishId, pdfCtryCode,
			pdfLocaleCode, pdfBuildType, pageSizeOrientationType, start, end,
			orderByComparator);
	}

	/**
	* Returns the first published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfLocaleCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	*
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfLocaleCode the pdf locale code
	* @param pdfBuildType the pdf build type
	* @param pageSizeOrientationType the page size orientation type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching published pdf list
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList findByPdfManualParams_First(
		long publishId, java.lang.String pdfCtryCode,
		java.lang.String pdfLocaleCode, java.lang.String pdfBuildType,
		java.lang.String pageSizeOrientationType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPdfManualParams_First(publishId, pdfCtryCode,
			pdfLocaleCode, pdfBuildType, pageSizeOrientationType,
			orderByComparator);
	}

	/**
	* Returns the first published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfLocaleCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	*
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfLocaleCode the pdf locale code
	* @param pdfBuildType the pdf build type
	* @param pageSizeOrientationType the page size orientation type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList fetchByPdfManualParams_First(
		long publishId, java.lang.String pdfCtryCode,
		java.lang.String pdfLocaleCode, java.lang.String pdfBuildType,
		java.lang.String pageSizeOrientationType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPdfManualParams_First(publishId, pdfCtryCode,
			pdfLocaleCode, pdfBuildType, pageSizeOrientationType,
			orderByComparator);
	}

	/**
	* Returns the last published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfLocaleCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	*
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfLocaleCode the pdf locale code
	* @param pdfBuildType the pdf build type
	* @param pageSizeOrientationType the page size orientation type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching published pdf list
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList findByPdfManualParams_Last(
		long publishId, java.lang.String pdfCtryCode,
		java.lang.String pdfLocaleCode, java.lang.String pdfBuildType,
		java.lang.String pageSizeOrientationType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPdfManualParams_Last(publishId, pdfCtryCode,
			pdfLocaleCode, pdfBuildType, pageSizeOrientationType,
			orderByComparator);
	}

	/**
	* Returns the last published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfLocaleCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	*
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfLocaleCode the pdf locale code
	* @param pdfBuildType the pdf build type
	* @param pageSizeOrientationType the page size orientation type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList fetchByPdfManualParams_Last(
		long publishId, java.lang.String pdfCtryCode,
		java.lang.String pdfLocaleCode, java.lang.String pdfBuildType,
		java.lang.String pageSizeOrientationType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPdfManualParams_Last(publishId, pdfCtryCode,
			pdfLocaleCode, pdfBuildType, pageSizeOrientationType,
			orderByComparator);
	}

	/**
	* Returns the published pdf lists before and after the current published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfLocaleCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	*
	* @param pdfId the primary key of the current published pdf list
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfLocaleCode the pdf locale code
	* @param pdfBuildType the pdf build type
	* @param pageSizeOrientationType the page size orientation type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next published pdf list
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a published pdf list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList[] findByPdfManualParams_PrevAndNext(
		long pdfId, long publishId, java.lang.String pdfCtryCode,
		java.lang.String pdfLocaleCode, java.lang.String pdfBuildType,
		java.lang.String pageSizeOrientationType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPdfManualParams_PrevAndNext(pdfId, publishId,
			pdfCtryCode, pdfLocaleCode, pdfBuildType, pageSizeOrientationType,
			orderByComparator);
	}

	/**
	* Removes all the published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfLocaleCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfLocaleCode the pdf locale code
	* @param pdfBuildType the pdf build type
	* @param pageSizeOrientationType the page size orientation type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPdfManualParams(long publishId,
		java.lang.String pdfCtryCode, java.lang.String pdfLocaleCode,
		java.lang.String pdfBuildType, java.lang.String pageSizeOrientationType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByPdfManualParams(publishId, pdfCtryCode, pdfLocaleCode,
			pdfBuildType, pageSizeOrientationType);
	}

	/**
	* Returns the number of published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfLocaleCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	*
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfLocaleCode the pdf locale code
	* @param pdfBuildType the pdf build type
	* @param pageSizeOrientationType the page size orientation type
	* @return the number of matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPdfManualParams(long publishId,
		java.lang.String pdfCtryCode, java.lang.String pdfLocaleCode,
		java.lang.String pdfBuildType, java.lang.String pageSizeOrientationType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPdfManualParams(publishId, pdfCtryCode,
			pdfLocaleCode, pdfBuildType, pageSizeOrientationType);
	}

	/**
	* Returns all the published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	*
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfBuildType the pdf build type
	* @param pageSizeOrientationType the page size orientation type
	* @return the matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findByPublishPdfManualParams(
		long publishId, java.lang.String pdfCtryCode,
		java.lang.String pdfBuildType, java.lang.String pageSizeOrientationType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishPdfManualParams(publishId, pdfCtryCode,
			pdfBuildType, pageSizeOrientationType);
	}

	/**
	* Returns a range of all the published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfBuildType the pdf build type
	* @param pageSizeOrientationType the page size orientation type
	* @param start the lower bound of the range of published pdf lists
	* @param end the upper bound of the range of published pdf lists (not inclusive)
	* @return the range of matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findByPublishPdfManualParams(
		long publishId, java.lang.String pdfCtryCode,
		java.lang.String pdfBuildType,
		java.lang.String pageSizeOrientationType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishPdfManualParams(publishId, pdfCtryCode,
			pdfBuildType, pageSizeOrientationType, start, end);
	}

	/**
	* Returns an ordered range of all the published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfBuildType the pdf build type
	* @param pageSizeOrientationType the page size orientation type
	* @param start the lower bound of the range of published pdf lists
	* @param end the upper bound of the range of published pdf lists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findByPublishPdfManualParams(
		long publishId, java.lang.String pdfCtryCode,
		java.lang.String pdfBuildType,
		java.lang.String pageSizeOrientationType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishPdfManualParams(publishId, pdfCtryCode,
			pdfBuildType, pageSizeOrientationType, start, end, orderByComparator);
	}

	/**
	* Returns the first published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	*
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfBuildType the pdf build type
	* @param pageSizeOrientationType the page size orientation type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching published pdf list
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList findByPublishPdfManualParams_First(
		long publishId, java.lang.String pdfCtryCode,
		java.lang.String pdfBuildType,
		java.lang.String pageSizeOrientationType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishPdfManualParams_First(publishId, pdfCtryCode,
			pdfBuildType, pageSizeOrientationType, orderByComparator);
	}

	/**
	* Returns the first published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	*
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfBuildType the pdf build type
	* @param pageSizeOrientationType the page size orientation type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList fetchByPublishPdfManualParams_First(
		long publishId, java.lang.String pdfCtryCode,
		java.lang.String pdfBuildType,
		java.lang.String pageSizeOrientationType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishPdfManualParams_First(publishId, pdfCtryCode,
			pdfBuildType, pageSizeOrientationType, orderByComparator);
	}

	/**
	* Returns the last published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	*
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfBuildType the pdf build type
	* @param pageSizeOrientationType the page size orientation type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching published pdf list
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList findByPublishPdfManualParams_Last(
		long publishId, java.lang.String pdfCtryCode,
		java.lang.String pdfBuildType,
		java.lang.String pageSizeOrientationType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishPdfManualParams_Last(publishId, pdfCtryCode,
			pdfBuildType, pageSizeOrientationType, orderByComparator);
	}

	/**
	* Returns the last published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	*
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfBuildType the pdf build type
	* @param pageSizeOrientationType the page size orientation type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList fetchByPublishPdfManualParams_Last(
		long publishId, java.lang.String pdfCtryCode,
		java.lang.String pdfBuildType,
		java.lang.String pageSizeOrientationType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishPdfManualParams_Last(publishId, pdfCtryCode,
			pdfBuildType, pageSizeOrientationType, orderByComparator);
	}

	/**
	* Returns the published pdf lists before and after the current published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	*
	* @param pdfId the primary key of the current published pdf list
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfBuildType the pdf build type
	* @param pageSizeOrientationType the page size orientation type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next published pdf list
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a published pdf list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList[] findByPublishPdfManualParams_PrevAndNext(
		long pdfId, long publishId, java.lang.String pdfCtryCode,
		java.lang.String pdfBuildType,
		java.lang.String pageSizeOrientationType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishPdfManualParams_PrevAndNext(pdfId, publishId,
			pdfCtryCode, pdfBuildType, pageSizeOrientationType,
			orderByComparator);
	}

	/**
	* Removes all the published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfBuildType the pdf build type
	* @param pageSizeOrientationType the page size orientation type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPublishPdfManualParams(long publishId,
		java.lang.String pdfCtryCode, java.lang.String pdfBuildType,
		java.lang.String pageSizeOrientationType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByPublishPdfManualParams(publishId, pdfCtryCode,
			pdfBuildType, pageSizeOrientationType);
	}

	/**
	* Returns the number of published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	*
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfBuildType the pdf build type
	* @param pageSizeOrientationType the page size orientation type
	* @return the number of matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPublishPdfManualParams(long publishId,
		java.lang.String pdfCtryCode, java.lang.String pdfBuildType,
		java.lang.String pageSizeOrientationType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPublishPdfManualParams(publishId, pdfCtryCode,
			pdfBuildType, pageSizeOrientationType);
	}

	/**
	* Returns all the published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63;.
	*
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfBuildType the pdf build type
	* @return the matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findByPublishedPDFParams(
		long publishId, java.lang.String pdfCtryCode,
		java.lang.String pdfBuildType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishedPDFParams(publishId, pdfCtryCode,
			pdfBuildType);
	}

	/**
	* Returns a range of all the published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfBuildType the pdf build type
	* @param start the lower bound of the range of published pdf lists
	* @param end the upper bound of the range of published pdf lists (not inclusive)
	* @return the range of matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findByPublishedPDFParams(
		long publishId, java.lang.String pdfCtryCode,
		java.lang.String pdfBuildType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishedPDFParams(publishId, pdfCtryCode,
			pdfBuildType, start, end);
	}

	/**
	* Returns an ordered range of all the published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfBuildType the pdf build type
	* @param start the lower bound of the range of published pdf lists
	* @param end the upper bound of the range of published pdf lists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findByPublishedPDFParams(
		long publishId, java.lang.String pdfCtryCode,
		java.lang.String pdfBuildType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishedPDFParams(publishId, pdfCtryCode,
			pdfBuildType, start, end, orderByComparator);
	}

	/**
	* Returns the first published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63;.
	*
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfBuildType the pdf build type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching published pdf list
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList findByPublishedPDFParams_First(
		long publishId, java.lang.String pdfCtryCode,
		java.lang.String pdfBuildType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishedPDFParams_First(publishId, pdfCtryCode,
			pdfBuildType, orderByComparator);
	}

	/**
	* Returns the first published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63;.
	*
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfBuildType the pdf build type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList fetchByPublishedPDFParams_First(
		long publishId, java.lang.String pdfCtryCode,
		java.lang.String pdfBuildType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishedPDFParams_First(publishId, pdfCtryCode,
			pdfBuildType, orderByComparator);
	}

	/**
	* Returns the last published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63;.
	*
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfBuildType the pdf build type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching published pdf list
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList findByPublishedPDFParams_Last(
		long publishId, java.lang.String pdfCtryCode,
		java.lang.String pdfBuildType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishedPDFParams_Last(publishId, pdfCtryCode,
			pdfBuildType, orderByComparator);
	}

	/**
	* Returns the last published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63;.
	*
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfBuildType the pdf build type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList fetchByPublishedPDFParams_Last(
		long publishId, java.lang.String pdfCtryCode,
		java.lang.String pdfBuildType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishedPDFParams_Last(publishId, pdfCtryCode,
			pdfBuildType, orderByComparator);
	}

	/**
	* Returns the published pdf lists before and after the current published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63;.
	*
	* @param pdfId the primary key of the current published pdf list
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfBuildType the pdf build type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next published pdf list
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a published pdf list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList[] findByPublishedPDFParams_PrevAndNext(
		long pdfId, long publishId, java.lang.String pdfCtryCode,
		java.lang.String pdfBuildType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishedPDFParams_PrevAndNext(pdfId, publishId,
			pdfCtryCode, pdfBuildType, orderByComparator);
	}

	/**
	* Removes all the published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfBuildType the pdf build type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPublishedPDFParams(long publishId,
		java.lang.String pdfCtryCode, java.lang.String pdfBuildType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByPublishedPDFParams(publishId, pdfCtryCode, pdfBuildType);
	}

	/**
	* Returns the number of published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63;.
	*
	* @param publishId the publish ID
	* @param pdfCtryCode the pdf ctry code
	* @param pdfBuildType the pdf build type
	* @return the number of matching published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPublishedPDFParams(long publishId,
		java.lang.String pdfCtryCode, java.lang.String pdfBuildType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPublishedPDFParams(publishId, pdfCtryCode,
			pdfBuildType);
	}

	/**
	* Caches the published pdf list in the entity cache if it is enabled.
	*
	* @param publishedPdfList the published pdf list
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.PublishedPdfList publishedPdfList) {
		getPersistence().cacheResult(publishedPdfList);
	}

	/**
	* Caches the published pdf lists in the entity cache if it is enabled.
	*
	* @param publishedPdfLists the published pdf lists
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> publishedPdfLists) {
		getPersistence().cacheResult(publishedPdfLists);
	}

	/**
	* Creates a new published pdf list with the primary key. Does not add the published pdf list to the database.
	*
	* @param pdfId the primary key for the new published pdf list
	* @return the new published pdf list
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList create(
		long pdfId) {
		return getPersistence().create(pdfId);
	}

	/**
	* Removes the published pdf list with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pdfId the primary key of the published pdf list
	* @return the published pdf list that was removed
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a published pdf list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList remove(
		long pdfId)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(pdfId);
	}

	public static com.ihg.brandstandards.db.model.PublishedPdfList updateImpl(
		com.ihg.brandstandards.db.model.PublishedPdfList publishedPdfList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(publishedPdfList);
	}

	/**
	* Returns the published pdf list with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchPublishedPdfListException} if it could not be found.
	*
	* @param pdfId the primary key of the published pdf list
	* @return the published pdf list
	* @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a published pdf list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList findByPrimaryKey(
		long pdfId)
		throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(pdfId);
	}

	/**
	* Returns the published pdf list with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param pdfId the primary key of the published pdf list
	* @return the published pdf list, or <code>null</code> if a published pdf list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishedPdfList fetchByPrimaryKey(
		long pdfId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(pdfId);
	}

	/**
	* Returns all the published pdf lists.
	*
	* @return the published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the published pdf lists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of published pdf lists
	* @param end the upper bound of the range of published pdf lists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishedPdfList> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the published pdf lists from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of published pdf lists.
	*
	* @return the number of published pdf lists
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PublishedPdfListPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PublishedPdfListPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					PublishedPdfListPersistence.class.getName());

			ReferenceRegistry.registerReference(PublishedPdfListUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PublishedPdfListPersistence persistence) {
	}

	private static PublishedPdfListPersistence _persistence;
}