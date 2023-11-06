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

import com.ihg.brandstandards.db.model.GEMTrigger;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the g e m trigger service. This utility wraps {@link GEMTriggerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMTriggerPersistence
 * @see GEMTriggerPersistenceImpl
 * @generated
 */
public class GEMTriggerUtil {
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
	public static void clearCache(GEMTrigger gemTrigger) {
		getPersistence().clearCache(gemTrigger);
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
	public static List<GEMTrigger> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GEMTrigger> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GEMTrigger> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GEMTrigger update(GEMTrigger gemTrigger)
		throws SystemException {
		return getPersistence().update(gemTrigger);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GEMTrigger update(GEMTrigger gemTrigger,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(gemTrigger, serviceContext);
	}

	/**
	* Returns all the g e m triggers where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @return the matching g e m triggers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTrigger> findByPublishId(
		long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPublishId(publishId);
	}

	/**
	* Returns a range of all the g e m triggers where publishId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTriggerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param start the lower bound of the range of g e m triggers
	* @param end the upper bound of the range of g e m triggers (not inclusive)
	* @return the range of matching g e m triggers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTrigger> findByPublishId(
		long publishId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPublishId(publishId, start, end);
	}

	/**
	* Returns an ordered range of all the g e m triggers where publishId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTriggerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param start the lower bound of the range of g e m triggers
	* @param end the upper bound of the range of g e m triggers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g e m triggers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTrigger> findByPublishId(
		long publishId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishId(publishId, start, end, orderByComparator);
	}

	/**
	* Returns the first g e m trigger in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m trigger
	* @throws com.ihg.brandstandards.db.NoSuchGEMTriggerException if a matching g e m trigger could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTrigger findByPublishId_First(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTriggerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishId_First(publishId, orderByComparator);
	}

	/**
	* Returns the first g e m trigger in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m trigger, or <code>null</code> if a matching g e m trigger could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTrigger fetchByPublishId_First(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishId_First(publishId, orderByComparator);
	}

	/**
	* Returns the last g e m trigger in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m trigger
	* @throws com.ihg.brandstandards.db.NoSuchGEMTriggerException if a matching g e m trigger could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTrigger findByPublishId_Last(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTriggerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishId_Last(publishId, orderByComparator);
	}

	/**
	* Returns the last g e m trigger in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m trigger, or <code>null</code> if a matching g e m trigger could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTrigger fetchByPublishId_Last(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishId_Last(publishId, orderByComparator);
	}

	/**
	* Returns the g e m triggers before and after the current g e m trigger in the ordered set where publishId = &#63;.
	*
	* @param triggerId the primary key of the current g e m trigger
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g e m trigger
	* @throws com.ihg.brandstandards.db.NoSuchGEMTriggerException if a g e m trigger with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTrigger[] findByPublishId_PrevAndNext(
		long triggerId, long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTriggerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishId_PrevAndNext(triggerId, publishId,
			orderByComparator);
	}

	/**
	* Removes all the g e m triggers where publishId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPublishId(long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPublishId(publishId);
	}

	/**
	* Returns the number of g e m triggers where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @return the number of matching g e m triggers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPublishId(long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPublishId(publishId);
	}

	/**
	* Returns the g e m trigger where publishId = &#63; and question = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchGEMTriggerException} if it could not be found.
	*
	* @param publishId the publish ID
	* @param question the question
	* @return the matching g e m trigger
	* @throws com.ihg.brandstandards.db.NoSuchGEMTriggerException if a matching g e m trigger could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTrigger findByPublishIdAndQuestion(
		long publishId, java.lang.String question)
		throws com.ihg.brandstandards.db.NoSuchGEMTriggerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPublishIdAndQuestion(publishId, question);
	}

	/**
	* Returns the g e m trigger where publishId = &#63; and question = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param publishId the publish ID
	* @param question the question
	* @return the matching g e m trigger, or <code>null</code> if a matching g e m trigger could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTrigger fetchByPublishIdAndQuestion(
		long publishId, java.lang.String question)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPublishIdAndQuestion(publishId, question);
	}

	/**
	* Returns the g e m trigger where publishId = &#63; and question = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param publishId the publish ID
	* @param question the question
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching g e m trigger, or <code>null</code> if a matching g e m trigger could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTrigger fetchByPublishIdAndQuestion(
		long publishId, java.lang.String question, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishIdAndQuestion(publishId, question,
			retrieveFromCache);
	}

	/**
	* Removes the g e m trigger where publishId = &#63; and question = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param question the question
	* @return the g e m trigger that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTrigger removeByPublishIdAndQuestion(
		long publishId, java.lang.String question)
		throws com.ihg.brandstandards.db.NoSuchGEMTriggerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByPublishIdAndQuestion(publishId, question);
	}

	/**
	* Returns the number of g e m triggers where publishId = &#63; and question = &#63;.
	*
	* @param publishId the publish ID
	* @param question the question
	* @return the number of matching g e m triggers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPublishIdAndQuestion(long publishId,
		java.lang.String question)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPublishIdAndQuestion(publishId, question);
	}

	/**
	* Caches the g e m trigger in the entity cache if it is enabled.
	*
	* @param gemTrigger the g e m trigger
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.GEMTrigger gemTrigger) {
		getPersistence().cacheResult(gemTrigger);
	}

	/**
	* Caches the g e m triggers in the entity cache if it is enabled.
	*
	* @param gemTriggers the g e m triggers
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GEMTrigger> gemTriggers) {
		getPersistence().cacheResult(gemTriggers);
	}

	/**
	* Creates a new g e m trigger with the primary key. Does not add the g e m trigger to the database.
	*
	* @param triggerId the primary key for the new g e m trigger
	* @return the new g e m trigger
	*/
	public static com.ihg.brandstandards.db.model.GEMTrigger create(
		long triggerId) {
		return getPersistence().create(triggerId);
	}

	/**
	* Removes the g e m trigger with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param triggerId the primary key of the g e m trigger
	* @return the g e m trigger that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGEMTriggerException if a g e m trigger with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTrigger remove(
		long triggerId)
		throws com.ihg.brandstandards.db.NoSuchGEMTriggerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(triggerId);
	}

	public static com.ihg.brandstandards.db.model.GEMTrigger updateImpl(
		com.ihg.brandstandards.db.model.GEMTrigger gemTrigger)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(gemTrigger);
	}

	/**
	* Returns the g e m trigger with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMTriggerException} if it could not be found.
	*
	* @param triggerId the primary key of the g e m trigger
	* @return the g e m trigger
	* @throws com.ihg.brandstandards.db.NoSuchGEMTriggerException if a g e m trigger with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTrigger findByPrimaryKey(
		long triggerId)
		throws com.ihg.brandstandards.db.NoSuchGEMTriggerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(triggerId);
	}

	/**
	* Returns the g e m trigger with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param triggerId the primary key of the g e m trigger
	* @return the g e m trigger, or <code>null</code> if a g e m trigger with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTrigger fetchByPrimaryKey(
		long triggerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(triggerId);
	}

	/**
	* Returns all the g e m triggers.
	*
	* @return the g e m triggers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTrigger> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the g e m triggers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTriggerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m triggers
	* @param end the upper bound of the range of g e m triggers (not inclusive)
	* @return the range of g e m triggers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTrigger> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the g e m triggers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTriggerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m triggers
	* @param end the upper bound of the range of g e m triggers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of g e m triggers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTrigger> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the g e m triggers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of g e m triggers.
	*
	* @return the number of g e m triggers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GEMTriggerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GEMTriggerPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					GEMTriggerPersistence.class.getName());

			ReferenceRegistry.registerReference(GEMTriggerUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GEMTriggerPersistence persistence) {
	}

	private static GEMTriggerPersistence _persistence;
}