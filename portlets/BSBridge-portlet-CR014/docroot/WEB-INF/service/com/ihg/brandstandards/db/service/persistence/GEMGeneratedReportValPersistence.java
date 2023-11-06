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

import com.ihg.brandstandards.db.model.GEMGeneratedReportVal;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the g e m generated report val service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMGeneratedReportValPersistenceImpl
 * @see GEMGeneratedReportValUtil
 * @generated
 */
public interface GEMGeneratedReportValPersistence extends BasePersistence<GEMGeneratedReportVal> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GEMGeneratedReportValUtil} to access the g e m generated report val persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the g e m generated report vals where reportId = &#63;.
	*
	* @param reportId the report ID
	* @return the matching g e m generated report vals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMGeneratedReportVal> findByReportId(
		long reportId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the g e m generated report vals where reportId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMGeneratedReportValModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportId the report ID
	* @param start the lower bound of the range of g e m generated report vals
	* @param end the upper bound of the range of g e m generated report vals (not inclusive)
	* @return the range of matching g e m generated report vals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMGeneratedReportVal> findByReportId(
		long reportId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the g e m generated report vals where reportId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMGeneratedReportValModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param reportId the report ID
	* @param start the lower bound of the range of g e m generated report vals
	* @param end the upper bound of the range of g e m generated report vals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g e m generated report vals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMGeneratedReportVal> findByReportId(
		long reportId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g e m generated report val in the ordered set where reportId = &#63;.
	*
	* @param reportId the report ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m generated report val
	* @throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException if a matching g e m generated report val could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMGeneratedReportVal findByReportId_First(
		long reportId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g e m generated report val in the ordered set where reportId = &#63;.
	*
	* @param reportId the report ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m generated report val, or <code>null</code> if a matching g e m generated report val could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMGeneratedReportVal fetchByReportId_First(
		long reportId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g e m generated report val in the ordered set where reportId = &#63;.
	*
	* @param reportId the report ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m generated report val
	* @throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException if a matching g e m generated report val could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMGeneratedReportVal findByReportId_Last(
		long reportId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g e m generated report val in the ordered set where reportId = &#63;.
	*
	* @param reportId the report ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m generated report val, or <code>null</code> if a matching g e m generated report val could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMGeneratedReportVal fetchByReportId_Last(
		long reportId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m generated report vals before and after the current g e m generated report val in the ordered set where reportId = &#63;.
	*
	* @param gemGeneratedReportValPK the primary key of the current g e m generated report val
	* @param reportId the report ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g e m generated report val
	* @throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException if a g e m generated report val with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMGeneratedReportVal[] findByReportId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.GEMGeneratedReportValPK gemGeneratedReportValPK,
		long reportId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the g e m generated report vals where reportId = &#63; from the database.
	*
	* @param reportId the report ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByReportId(long reportId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m generated report vals where reportId = &#63;.
	*
	* @param reportId the report ID
	* @return the number of matching g e m generated report vals
	* @throws SystemException if a system exception occurred
	*/
	public int countByReportId(long reportId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the g e m generated report val in the entity cache if it is enabled.
	*
	* @param gemGeneratedReportVal the g e m generated report val
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.GEMGeneratedReportVal gemGeneratedReportVal);

	/**
	* Caches the g e m generated report vals in the entity cache if it is enabled.
	*
	* @param gemGeneratedReportVals the g e m generated report vals
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GEMGeneratedReportVal> gemGeneratedReportVals);

	/**
	* Creates a new g e m generated report val with the primary key. Does not add the g e m generated report val to the database.
	*
	* @param gemGeneratedReportValPK the primary key for the new g e m generated report val
	* @return the new g e m generated report val
	*/
	public com.ihg.brandstandards.db.model.GEMGeneratedReportVal create(
		com.ihg.brandstandards.db.service.persistence.GEMGeneratedReportValPK gemGeneratedReportValPK);

	/**
	* Removes the g e m generated report val with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param gemGeneratedReportValPK the primary key of the g e m generated report val
	* @return the g e m generated report val that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException if a g e m generated report val with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMGeneratedReportVal remove(
		com.ihg.brandstandards.db.service.persistence.GEMGeneratedReportValPK gemGeneratedReportValPK)
		throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.GEMGeneratedReportVal updateImpl(
		com.ihg.brandstandards.db.model.GEMGeneratedReportVal gemGeneratedReportVal)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m generated report val with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException} if it could not be found.
	*
	* @param gemGeneratedReportValPK the primary key of the g e m generated report val
	* @return the g e m generated report val
	* @throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException if a g e m generated report val with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMGeneratedReportVal findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.GEMGeneratedReportValPK gemGeneratedReportValPK)
		throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m generated report val with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param gemGeneratedReportValPK the primary key of the g e m generated report val
	* @return the g e m generated report val, or <code>null</code> if a g e m generated report val with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMGeneratedReportVal fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.GEMGeneratedReportValPK gemGeneratedReportValPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the g e m generated report vals.
	*
	* @return the g e m generated report vals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMGeneratedReportVal> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the g e m generated report vals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMGeneratedReportValModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m generated report vals
	* @param end the upper bound of the range of g e m generated report vals (not inclusive)
	* @return the range of g e m generated report vals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMGeneratedReportVal> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the g e m generated report vals.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMGeneratedReportValModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m generated report vals
	* @param end the upper bound of the range of g e m generated report vals (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of g e m generated report vals
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMGeneratedReportVal> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the g e m generated report vals from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m generated report vals.
	*
	* @return the number of g e m generated report vals
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}