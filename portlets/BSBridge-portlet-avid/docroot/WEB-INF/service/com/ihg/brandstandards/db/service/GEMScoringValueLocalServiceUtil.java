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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for GEMScoringValue. This utility wraps
 * {@link com.ihg.brandstandards.db.service.impl.GEMScoringValueLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mummanedi
 * @see GEMScoringValueLocalService
 * @see com.ihg.brandstandards.db.service.base.GEMScoringValueLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.GEMScoringValueLocalServiceImpl
 * @generated
 */
public class GEMScoringValueLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.GEMScoringValueLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the g e m scoring value to the database. Also notifies the appropriate model listeners.
	*
	* @param gemScoringValue the g e m scoring value
	* @return the g e m scoring value that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMScoringValue addGEMScoringValue(
		com.ihg.brandstandards.db.model.GEMScoringValue gemScoringValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addGEMScoringValue(gemScoringValue);
	}

	/**
	* Creates a new g e m scoring value with the primary key. Does not add the g e m scoring value to the database.
	*
	* @param scoringId the primary key for the new g e m scoring value
	* @return the new g e m scoring value
	*/
	public static com.ihg.brandstandards.db.model.GEMScoringValue createGEMScoringValue(
		long scoringId) {
		return getService().createGEMScoringValue(scoringId);
	}

	/**
	* Deletes the g e m scoring value with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scoringId the primary key of the g e m scoring value
	* @return the g e m scoring value that was removed
	* @throws PortalException if a g e m scoring value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMScoringValue deleteGEMScoringValue(
		long scoringId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteGEMScoringValue(scoringId);
	}

	/**
	* Deletes the g e m scoring value from the database. Also notifies the appropriate model listeners.
	*
	* @param gemScoringValue the g e m scoring value
	* @return the g e m scoring value that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMScoringValue deleteGEMScoringValue(
		com.ihg.brandstandards.db.model.GEMScoringValue gemScoringValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteGEMScoringValue(gemScoringValue);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMScoringValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMScoringValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.ihg.brandstandards.db.model.GEMScoringValue fetchGEMScoringValue(
		long scoringId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchGEMScoringValue(scoringId);
	}

	/**
	* Returns the g e m scoring value with the primary key.
	*
	* @param scoringId the primary key of the g e m scoring value
	* @return the g e m scoring value
	* @throws PortalException if a g e m scoring value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMScoringValue getGEMScoringValue(
		long scoringId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getGEMScoringValue(scoringId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the g e m scoring values.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMScoringValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m scoring values
	* @param end the upper bound of the range of g e m scoring values (not inclusive)
	* @return the range of g e m scoring values
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMScoringValue> getGEMScoringValues(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGEMScoringValues(start, end);
	}

	/**
	* Returns the number of g e m scoring values.
	*
	* @return the number of g e m scoring values
	* @throws SystemException if a system exception occurred
	*/
	public static int getGEMScoringValuesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGEMScoringValuesCount();
	}

	/**
	* Updates the g e m scoring value in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param gemScoringValue the g e m scoring value
	* @return the g e m scoring value that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMScoringValue updateGEMScoringValue(
		com.ihg.brandstandards.db.model.GEMScoringValue gemScoringValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateGEMScoringValue(gemScoringValue);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearCache() {
		getService().clearCache();
	}

	public static void clearService() {
		_service = null;
	}

	public static GEMScoringValueLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					GEMScoringValueLocalService.class.getName());

			if (invokableLocalService instanceof GEMScoringValueLocalService) {
				_service = (GEMScoringValueLocalService)invokableLocalService;
			}
			else {
				_service = new GEMScoringValueLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(GEMScoringValueLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(GEMScoringValueLocalService service) {
	}

	private static GEMScoringValueLocalService _service;
}