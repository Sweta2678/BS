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

import com.ihg.brandstandards.db.model.Publication;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the publication service. This utility wraps {@link PublicationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see PublicationPersistence
 * @see PublicationPersistenceImpl
 * @generated
 */
public class PublicationUtil {
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
	public static void clearCache(Publication publication) {
		getPersistence().clearCache(publication);
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
	public static List<Publication> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Publication> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Publication> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Publication update(Publication publication)
		throws SystemException {
		return getPersistence().update(publication);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Publication update(Publication publication,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(publication, serviceContext);
	}

	/**
	* Returns all the publications where chainCode = &#63; and publishStatCd = &#63;.
	*
	* @param chainCode the chain code
	* @param publishStatCd the publish stat cd
	* @return the matching publications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Publication> findByChainCodeAndStatus(
		java.lang.String chainCode, java.lang.String publishStatCd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByChainCodeAndStatus(chainCode, publishStatCd);
	}

	/**
	* Returns a range of all the publications where chainCode = &#63; and publishStatCd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param chainCode the chain code
	* @param publishStatCd the publish stat cd
	* @param start the lower bound of the range of publications
	* @param end the upper bound of the range of publications (not inclusive)
	* @return the range of matching publications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Publication> findByChainCodeAndStatus(
		java.lang.String chainCode, java.lang.String publishStatCd, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByChainCodeAndStatus(chainCode, publishStatCd, start,
			end);
	}

	/**
	* Returns an ordered range of all the publications where chainCode = &#63; and publishStatCd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param chainCode the chain code
	* @param publishStatCd the publish stat cd
	* @param start the lower bound of the range of publications
	* @param end the upper bound of the range of publications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching publications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Publication> findByChainCodeAndStatus(
		java.lang.String chainCode, java.lang.String publishStatCd, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByChainCodeAndStatus(chainCode, publishStatCd, start,
			end, orderByComparator);
	}

	/**
	* Returns the first publication in the ordered set where chainCode = &#63; and publishStatCd = &#63;.
	*
	* @param chainCode the chain code
	* @param publishStatCd the publish stat cd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication findByChainCodeAndStatus_First(
		java.lang.String chainCode, java.lang.String publishStatCd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByChainCodeAndStatus_First(chainCode, publishStatCd,
			orderByComparator);
	}

	/**
	* Returns the first publication in the ordered set where chainCode = &#63; and publishStatCd = &#63;.
	*
	* @param chainCode the chain code
	* @param publishStatCd the publish stat cd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publication, or <code>null</code> if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication fetchByChainCodeAndStatus_First(
		java.lang.String chainCode, java.lang.String publishStatCd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByChainCodeAndStatus_First(chainCode, publishStatCd,
			orderByComparator);
	}

	/**
	* Returns the last publication in the ordered set where chainCode = &#63; and publishStatCd = &#63;.
	*
	* @param chainCode the chain code
	* @param publishStatCd the publish stat cd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication findByChainCodeAndStatus_Last(
		java.lang.String chainCode, java.lang.String publishStatCd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByChainCodeAndStatus_Last(chainCode, publishStatCd,
			orderByComparator);
	}

	/**
	* Returns the last publication in the ordered set where chainCode = &#63; and publishStatCd = &#63;.
	*
	* @param chainCode the chain code
	* @param publishStatCd the publish stat cd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publication, or <code>null</code> if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication fetchByChainCodeAndStatus_Last(
		java.lang.String chainCode, java.lang.String publishStatCd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByChainCodeAndStatus_Last(chainCode, publishStatCd,
			orderByComparator);
	}

	/**
	* Returns the publications before and after the current publication in the ordered set where chainCode = &#63; and publishStatCd = &#63;.
	*
	* @param publishId the primary key of the current publication
	* @param chainCode the chain code
	* @param publishStatCd the publish stat cd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a publication with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication[] findByChainCodeAndStatus_PrevAndNext(
		long publishId, java.lang.String chainCode,
		java.lang.String publishStatCd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByChainCodeAndStatus_PrevAndNext(publishId, chainCode,
			publishStatCd, orderByComparator);
	}

	/**
	* Removes all the publications where chainCode = &#63; and publishStatCd = &#63; from the database.
	*
	* @param chainCode the chain code
	* @param publishStatCd the publish stat cd
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByChainCodeAndStatus(java.lang.String chainCode,
		java.lang.String publishStatCd)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByChainCodeAndStatus(chainCode, publishStatCd);
	}

	/**
	* Returns the number of publications where chainCode = &#63; and publishStatCd = &#63;.
	*
	* @param chainCode the chain code
	* @param publishStatCd the publish stat cd
	* @return the number of matching publications
	* @throws SystemException if a system exception occurred
	*/
	public static int countByChainCodeAndStatus(java.lang.String chainCode,
		java.lang.String publishStatCd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByChainCodeAndStatus(chainCode, publishStatCd);
	}

	/**
	* Returns the publication where publishStatCd = &#63; and publishEnvName = &#63; and chainCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublicationException} if it could not be found.
	*
	* @param publishStatCd the publish stat cd
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @return the matching publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication findByPublishStatEnvChn(
		java.lang.String publishStatCd, java.lang.String publishEnvName,
		java.lang.String chainCode)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishStatEnvChn(publishStatCd, publishEnvName,
			chainCode);
	}

	/**
	* Returns the publication where publishStatCd = &#63; and publishEnvName = &#63; and chainCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param publishStatCd the publish stat cd
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @return the matching publication, or <code>null</code> if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication fetchByPublishStatEnvChn(
		java.lang.String publishStatCd, java.lang.String publishEnvName,
		java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishStatEnvChn(publishStatCd, publishEnvName,
			chainCode);
	}

	/**
	* Returns the publication where publishStatCd = &#63; and publishEnvName = &#63; and chainCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param publishStatCd the publish stat cd
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching publication, or <code>null</code> if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication fetchByPublishStatEnvChn(
		java.lang.String publishStatCd, java.lang.String publishEnvName,
		java.lang.String chainCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishStatEnvChn(publishStatCd, publishEnvName,
			chainCode, retrieveFromCache);
	}

	/**
	* Removes the publication where publishStatCd = &#63; and publishEnvName = &#63; and chainCode = &#63; from the database.
	*
	* @param publishStatCd the publish stat cd
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @return the publication that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication removeByPublishStatEnvChn(
		java.lang.String publishStatCd, java.lang.String publishEnvName,
		java.lang.String chainCode)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByPublishStatEnvChn(publishStatCd, publishEnvName,
			chainCode);
	}

	/**
	* Returns the number of publications where publishStatCd = &#63; and publishEnvName = &#63; and chainCode = &#63;.
	*
	* @param publishStatCd the publish stat cd
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @return the number of matching publications
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPublishStatEnvChn(java.lang.String publishStatCd,
		java.lang.String publishEnvName, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPublishStatEnvChn(publishStatCd, publishEnvName,
			chainCode);
	}

	/**
	* Returns all the publications where publishEnvName = &#63; and chainCode = &#63;.
	*
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @return the matching publications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Publication> findByPublishEnvChn(
		java.lang.String publishEnvName, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPublishEnvChn(publishEnvName, chainCode);
	}

	/**
	* Returns a range of all the publications where publishEnvName = &#63; and chainCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @param start the lower bound of the range of publications
	* @param end the upper bound of the range of publications (not inclusive)
	* @return the range of matching publications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Publication> findByPublishEnvChn(
		java.lang.String publishEnvName, java.lang.String chainCode, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishEnvChn(publishEnvName, chainCode, start, end);
	}

	/**
	* Returns an ordered range of all the publications where publishEnvName = &#63; and chainCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @param start the lower bound of the range of publications
	* @param end the upper bound of the range of publications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching publications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Publication> findByPublishEnvChn(
		java.lang.String publishEnvName, java.lang.String chainCode, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishEnvChn(publishEnvName, chainCode, start, end,
			orderByComparator);
	}

	/**
	* Returns the first publication in the ordered set where publishEnvName = &#63; and chainCode = &#63;.
	*
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication findByPublishEnvChn_First(
		java.lang.String publishEnvName, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishEnvChn_First(publishEnvName, chainCode,
			orderByComparator);
	}

	/**
	* Returns the first publication in the ordered set where publishEnvName = &#63; and chainCode = &#63;.
	*
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publication, or <code>null</code> if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication fetchByPublishEnvChn_First(
		java.lang.String publishEnvName, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishEnvChn_First(publishEnvName, chainCode,
			orderByComparator);
	}

	/**
	* Returns the last publication in the ordered set where publishEnvName = &#63; and chainCode = &#63;.
	*
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication findByPublishEnvChn_Last(
		java.lang.String publishEnvName, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishEnvChn_Last(publishEnvName, chainCode,
			orderByComparator);
	}

	/**
	* Returns the last publication in the ordered set where publishEnvName = &#63; and chainCode = &#63;.
	*
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publication, or <code>null</code> if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication fetchByPublishEnvChn_Last(
		java.lang.String publishEnvName, java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishEnvChn_Last(publishEnvName, chainCode,
			orderByComparator);
	}

	/**
	* Returns the publications before and after the current publication in the ordered set where publishEnvName = &#63; and chainCode = &#63;.
	*
	* @param publishId the primary key of the current publication
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a publication with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication[] findByPublishEnvChn_PrevAndNext(
		long publishId, java.lang.String publishEnvName,
		java.lang.String chainCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishEnvChn_PrevAndNext(publishId, publishEnvName,
			chainCode, orderByComparator);
	}

	/**
	* Removes all the publications where publishEnvName = &#63; and chainCode = &#63; from the database.
	*
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPublishEnvChn(java.lang.String publishEnvName,
		java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPublishEnvChn(publishEnvName, chainCode);
	}

	/**
	* Returns the number of publications where publishEnvName = &#63; and chainCode = &#63;.
	*
	* @param publishEnvName the publish env name
	* @param chainCode the chain code
	* @return the number of matching publications
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPublishEnvChn(java.lang.String publishEnvName,
		java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPublishEnvChn(publishEnvName, chainCode);
	}

	/**
	* Returns the publication where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublicationException} if it could not be found.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @return the matching publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication findByPublishObject(
		java.lang.String chainCode, java.lang.String publishEnvName,
		java.lang.String publishStatCd)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishObject(chainCode, publishEnvName, publishStatCd);
	}

	/**
	* Returns the publication where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @return the matching publication, or <code>null</code> if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication fetchByPublishObject(
		java.lang.String chainCode, java.lang.String publishEnvName,
		java.lang.String publishStatCd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishObject(chainCode, publishEnvName,
			publishStatCd);
	}

	/**
	* Returns the publication where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching publication, or <code>null</code> if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication fetchByPublishObject(
		java.lang.String chainCode, java.lang.String publishEnvName,
		java.lang.String publishStatCd, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishObject(chainCode, publishEnvName,
			publishStatCd, retrieveFromCache);
	}

	/**
	* Removes the publication where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63; from the database.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @return the publication that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication removeByPublishObject(
		java.lang.String chainCode, java.lang.String publishEnvName,
		java.lang.String publishStatCd)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByPublishObject(chainCode, publishEnvName,
			publishStatCd);
	}

	/**
	* Returns the number of publications where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @return the number of matching publications
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPublishObject(java.lang.String chainCode,
		java.lang.String publishEnvName, java.lang.String publishStatCd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPublishObject(chainCode, publishEnvName,
			publishStatCd);
	}

	/**
	* Returns all the publications where chainCode = &#63; and publishEnvName = &#63;.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @return the matching publications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Publication> findByPublishHistory(
		java.lang.String chainCode, java.lang.String publishEnvName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPublishHistory(chainCode, publishEnvName);
	}

	/**
	* Returns a range of all the publications where chainCode = &#63; and publishEnvName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param start the lower bound of the range of publications
	* @param end the upper bound of the range of publications (not inclusive)
	* @return the range of matching publications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Publication> findByPublishHistory(
		java.lang.String chainCode, java.lang.String publishEnvName, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishHistory(chainCode, publishEnvName, start, end);
	}

	/**
	* Returns an ordered range of all the publications where chainCode = &#63; and publishEnvName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param start the lower bound of the range of publications
	* @param end the upper bound of the range of publications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching publications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Publication> findByPublishHistory(
		java.lang.String chainCode, java.lang.String publishEnvName, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishHistory(chainCode, publishEnvName, start, end,
			orderByComparator);
	}

	/**
	* Returns the first publication in the ordered set where chainCode = &#63; and publishEnvName = &#63;.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication findByPublishHistory_First(
		java.lang.String chainCode, java.lang.String publishEnvName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishHistory_First(chainCode, publishEnvName,
			orderByComparator);
	}

	/**
	* Returns the first publication in the ordered set where chainCode = &#63; and publishEnvName = &#63;.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publication, or <code>null</code> if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication fetchByPublishHistory_First(
		java.lang.String chainCode, java.lang.String publishEnvName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishHistory_First(chainCode, publishEnvName,
			orderByComparator);
	}

	/**
	* Returns the last publication in the ordered set where chainCode = &#63; and publishEnvName = &#63;.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication findByPublishHistory_Last(
		java.lang.String chainCode, java.lang.String publishEnvName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishHistory_Last(chainCode, publishEnvName,
			orderByComparator);
	}

	/**
	* Returns the last publication in the ordered set where chainCode = &#63; and publishEnvName = &#63;.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publication, or <code>null</code> if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication fetchByPublishHistory_Last(
		java.lang.String chainCode, java.lang.String publishEnvName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishHistory_Last(chainCode, publishEnvName,
			orderByComparator);
	}

	/**
	* Returns the publications before and after the current publication in the ordered set where chainCode = &#63; and publishEnvName = &#63;.
	*
	* @param publishId the primary key of the current publication
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a publication with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication[] findByPublishHistory_PrevAndNext(
		long publishId, java.lang.String chainCode,
		java.lang.String publishEnvName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishHistory_PrevAndNext(publishId, chainCode,
			publishEnvName, orderByComparator);
	}

	/**
	* Removes all the publications where chainCode = &#63; and publishEnvName = &#63; from the database.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPublishHistory(java.lang.String chainCode,
		java.lang.String publishEnvName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPublishHistory(chainCode, publishEnvName);
	}

	/**
	* Returns the number of publications where chainCode = &#63; and publishEnvName = &#63;.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @return the number of matching publications
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPublishHistory(java.lang.String chainCode,
		java.lang.String publishEnvName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPublishHistory(chainCode, publishEnvName);
	}

	/**
	* Returns all the publications where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @return the matching publications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Publication> findByPublishInActiveHistory(
		java.lang.String chainCode, java.lang.String publishEnvName,
		java.lang.String publishStatCd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishInActiveHistory(chainCode, publishEnvName,
			publishStatCd);
	}

	/**
	* Returns a range of all the publications where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @param start the lower bound of the range of publications
	* @param end the upper bound of the range of publications (not inclusive)
	* @return the range of matching publications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Publication> findByPublishInActiveHistory(
		java.lang.String chainCode, java.lang.String publishEnvName,
		java.lang.String publishStatCd, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishInActiveHistory(chainCode, publishEnvName,
			publishStatCd, start, end);
	}

	/**
	* Returns an ordered range of all the publications where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @param start the lower bound of the range of publications
	* @param end the upper bound of the range of publications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching publications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Publication> findByPublishInActiveHistory(
		java.lang.String chainCode, java.lang.String publishEnvName,
		java.lang.String publishStatCd, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishInActiveHistory(chainCode, publishEnvName,
			publishStatCd, start, end, orderByComparator);
	}

	/**
	* Returns the first publication in the ordered set where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication findByPublishInActiveHistory_First(
		java.lang.String chainCode, java.lang.String publishEnvName,
		java.lang.String publishStatCd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishInActiveHistory_First(chainCode,
			publishEnvName, publishStatCd, orderByComparator);
	}

	/**
	* Returns the first publication in the ordered set where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publication, or <code>null</code> if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication fetchByPublishInActiveHistory_First(
		java.lang.String chainCode, java.lang.String publishEnvName,
		java.lang.String publishStatCd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishInActiveHistory_First(chainCode,
			publishEnvName, publishStatCd, orderByComparator);
	}

	/**
	* Returns the last publication in the ordered set where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication findByPublishInActiveHistory_Last(
		java.lang.String chainCode, java.lang.String publishEnvName,
		java.lang.String publishStatCd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishInActiveHistory_Last(chainCode,
			publishEnvName, publishStatCd, orderByComparator);
	}

	/**
	* Returns the last publication in the ordered set where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publication, or <code>null</code> if a matching publication could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication fetchByPublishInActiveHistory_Last(
		java.lang.String chainCode, java.lang.String publishEnvName,
		java.lang.String publishStatCd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishInActiveHistory_Last(chainCode,
			publishEnvName, publishStatCd, orderByComparator);
	}

	/**
	* Returns the publications before and after the current publication in the ordered set where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	*
	* @param publishId the primary key of the current publication
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a publication with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication[] findByPublishInActiveHistory_PrevAndNext(
		long publishId, java.lang.String chainCode,
		java.lang.String publishEnvName, java.lang.String publishStatCd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishInActiveHistory_PrevAndNext(publishId,
			chainCode, publishEnvName, publishStatCd, orderByComparator);
	}

	/**
	* Removes all the publications where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63; from the database.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPublishInActiveHistory(
		java.lang.String chainCode, java.lang.String publishEnvName,
		java.lang.String publishStatCd)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByPublishInActiveHistory(chainCode, publishEnvName,
			publishStatCd);
	}

	/**
	* Returns the number of publications where chainCode = &#63; and publishEnvName = &#63; and publishStatCd = &#63;.
	*
	* @param chainCode the chain code
	* @param publishEnvName the publish env name
	* @param publishStatCd the publish stat cd
	* @return the number of matching publications
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPublishInActiveHistory(
		java.lang.String chainCode, java.lang.String publishEnvName,
		java.lang.String publishStatCd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPublishInActiveHistory(chainCode, publishEnvName,
			publishStatCd);
	}

	/**
	* Caches the publication in the entity cache if it is enabled.
	*
	* @param publication the publication
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.Publication publication) {
		getPersistence().cacheResult(publication);
	}

	/**
	* Caches the publications in the entity cache if it is enabled.
	*
	* @param publications the publications
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.Publication> publications) {
		getPersistence().cacheResult(publications);
	}

	/**
	* Creates a new publication with the primary key. Does not add the publication to the database.
	*
	* @param publishId the primary key for the new publication
	* @return the new publication
	*/
	public static com.ihg.brandstandards.db.model.Publication create(
		long publishId) {
		return getPersistence().create(publishId);
	}

	/**
	* Removes the publication with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param publishId the primary key of the publication
	* @return the publication that was removed
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a publication with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication remove(
		long publishId)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(publishId);
	}

	public static com.ihg.brandstandards.db.model.Publication updateImpl(
		com.ihg.brandstandards.db.model.Publication publication)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(publication);
	}

	/**
	* Returns the publication with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchPublicationException} if it could not be found.
	*
	* @param publishId the primary key of the publication
	* @return the publication
	* @throws com.ihg.brandstandards.db.NoSuchPublicationException if a publication with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication findByPrimaryKey(
		long publishId)
		throws com.ihg.brandstandards.db.NoSuchPublicationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(publishId);
	}

	/**
	* Returns the publication with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param publishId the primary key of the publication
	* @return the publication, or <code>null</code> if a publication with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.Publication fetchByPrimaryKey(
		long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(publishId);
	}

	/**
	* Returns all the publications.
	*
	* @return the publications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Publication> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the publications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of publications
	* @param end the upper bound of the range of publications (not inclusive)
	* @return the range of publications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Publication> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the publications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of publications
	* @param end the upper bound of the range of publications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of publications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.Publication> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the publications from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of publications.
	*
	* @return the number of publications
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PublicationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PublicationPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					PublicationPersistence.class.getName());

			ReferenceRegistry.registerReference(PublicationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PublicationPersistence persistence) {
	}

	private static PublicationPersistence _persistence;
}