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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for SpreadSheetAttributeUpdate. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Mummanedi
 * @see SpreadSheetAttributeUpdateLocalServiceUtil
 * @see com.ihg.brandstandards.db.service.base.SpreadSheetAttributeUpdateLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.SpreadSheetAttributeUpdateLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SpreadSheetAttributeUpdateLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SpreadSheetAttributeUpdateLocalServiceUtil} to access the spread sheet attribute update local service. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.SpreadSheetAttributeUpdateLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the spread sheet attribute update to the database. Also notifies the appropriate model listeners.
	*
	* @param spreadSheetAttributeUpdate the spread sheet attribute update
	* @return the spread sheet attribute update that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate addSpreadSheetAttributeUpdate(
		com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate spreadSheetAttributeUpdate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new spread sheet attribute update with the primary key. Does not add the spread sheet attribute update to the database.
	*
	* @param speardSheetId the primary key for the new spread sheet attribute update
	* @return the new spread sheet attribute update
	*/
	public com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate createSpreadSheetAttributeUpdate(
		long speardSheetId);

	/**
	* Deletes the spread sheet attribute update with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param speardSheetId the primary key of the spread sheet attribute update
	* @return the spread sheet attribute update that was removed
	* @throws PortalException if a spread sheet attribute update with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate deleteSpreadSheetAttributeUpdate(
		long speardSheetId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the spread sheet attribute update from the database. Also notifies the appropriate model listeners.
	*
	* @param spreadSheetAttributeUpdate the spread sheet attribute update
	* @return the spread sheet attribute update that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate deleteSpreadSheetAttributeUpdate(
		com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate spreadSheetAttributeUpdate)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpreadSheetAttributeUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpreadSheetAttributeUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate fetchSpreadSheetAttributeUpdate(
		long speardSheetId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the spread sheet attribute update with the primary key.
	*
	* @param speardSheetId the primary key of the spread sheet attribute update
	* @return the spread sheet attribute update
	* @throws PortalException if a spread sheet attribute update with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate getSpreadSheetAttributeUpdate(
		long speardSheetId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the spread sheet attribute updates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpreadSheetAttributeUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of spread sheet attribute updates
	* @param end the upper bound of the range of spread sheet attribute updates (not inclusive)
	* @return the range of spread sheet attribute updates
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate> getSpreadSheetAttributeUpdates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of spread sheet attribute updates.
	*
	* @return the number of spread sheet attribute updates
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSpreadSheetAttributeUpdatesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the spread sheet attribute update in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spreadSheetAttributeUpdate the spread sheet attribute update
	* @return the spread sheet attribute update that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate updateSpreadSheetAttributeUpdate(
		com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate spreadSheetAttributeUpdate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public java.lang.String recordsNotAvailable(
		java.util.List<java.lang.Long> allStdIds,
		java.util.Map<java.lang.String, java.util.List<java.lang.Long>> stdIdsMap,
		com.liferay.portal.model.User user, java.lang.String region,
		java.lang.String environment);

	/**
	* @param stdIds This is a list of Long values
	* @return List This method will return an object of List
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List getStandardDetails(
		java.util.List<java.lang.Long> stdIds);

	/**
	* @param status
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate> getAttributeRequestList(
		java.lang.String status);

	/**
	* @param stdId
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.lang.Long> getFlagCategoryIdForStandard(
		long stdId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Map<java.lang.String, java.lang.Long> getFlagCategories();

	/**
	* @param userId
	* @param environment
	* @param template
	* @param message
	* @param log
	* @param requestId
	*/
	public void sendEmailNotification(long userId,
		java.lang.String environment, java.lang.String template,
		java.lang.String message, java.lang.String log,
		java.lang.String requestId);

	/**
	* @param stdIds
	* @return Map
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Map<java.lang.Long, java.util.List<java.lang.Long>> getStandardFlagCaterogies(
		java.util.List<java.lang.Long> stdIds);

	public void clearCache();

	/**
	* @param user
	* @param metadata
	* @param jobType
	* @return boolean
	*/
	public boolean addToJobQueue(com.liferay.portal.model.User user,
		java.lang.String metadata, java.lang.String jobType);
}