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
 * Provides the local service utility for StandardsRegionChain. This utility wraps
 * {@link com.ihg.brandstandards.db.service.impl.StandardsRegionChainLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mummanedi
 * @see StandardsRegionChainLocalService
 * @see com.ihg.brandstandards.db.service.base.StandardsRegionChainLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.StandardsRegionChainLocalServiceImpl
 * @generated
 */
public class StandardsRegionChainLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.StandardsRegionChainLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the standards region chain to the database. Also notifies the appropriate model listeners.
	*
	* @param standardsRegionChain the standards region chain
	* @return the standards region chain that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsRegionChain addStandardsRegionChain(
		com.ihg.brandstandards.db.model.StandardsRegionChain standardsRegionChain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addStandardsRegionChain(standardsRegionChain);
	}

	/**
	* Creates a new standards region chain with the primary key. Does not add the standards region chain to the database.
	*
	* @param standardsRegionChainPK the primary key for the new standards region chain
	* @return the new standards region chain
	*/
	public static com.ihg.brandstandards.db.model.StandardsRegionChain createStandardsRegionChain(
		com.ihg.brandstandards.db.service.persistence.StandardsRegionChainPK standardsRegionChainPK) {
		return getService().createStandardsRegionChain(standardsRegionChainPK);
	}

	/**
	* Deletes the standards region chain with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsRegionChainPK the primary key of the standards region chain
	* @return the standards region chain that was removed
	* @throws PortalException if a standards region chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsRegionChain deleteStandardsRegionChain(
		com.ihg.brandstandards.db.service.persistence.StandardsRegionChainPK standardsRegionChainPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStandardsRegionChain(standardsRegionChainPK);
	}

	/**
	* Deletes the standards region chain from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsRegionChain the standards region chain
	* @return the standards region chain that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsRegionChain deleteStandardsRegionChain(
		com.ihg.brandstandards.db.model.StandardsRegionChain standardsRegionChain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteStandardsRegionChain(standardsRegionChain);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsRegionChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsRegionChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.ihg.brandstandards.db.model.StandardsRegionChain fetchStandardsRegionChain(
		com.ihg.brandstandards.db.service.persistence.StandardsRegionChainPK standardsRegionChainPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchStandardsRegionChain(standardsRegionChainPK);
	}

	/**
	* Returns the standards region chain with the primary key.
	*
	* @param standardsRegionChainPK the primary key of the standards region chain
	* @return the standards region chain
	* @throws PortalException if a standards region chain with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsRegionChain getStandardsRegionChain(
		com.ihg.brandstandards.db.service.persistence.StandardsRegionChainPK standardsRegionChainPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardsRegionChain(standardsRegionChainPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the standards region chains.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsRegionChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards region chains
	* @param end the upper bound of the range of standards region chains (not inclusive)
	* @return the range of standards region chains
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsRegionChain> getStandardsRegionChains(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardsRegionChains(start, end);
	}

	/**
	* Returns the number of standards region chains.
	*
	* @return the number of standards region chains
	* @throws SystemException if a system exception occurred
	*/
	public static int getStandardsRegionChainsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardsRegionChainsCount();
	}

	/**
	* Updates the standards region chain in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param standardsRegionChain the standards region chain
	* @return the standards region chain that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsRegionChain updateStandardsRegionChain(
		com.ihg.brandstandards.db.model.StandardsRegionChain standardsRegionChain)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateStandardsRegionChain(standardsRegionChain);
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

	public static void deleteStandardsRegionChainByStdIdChnCd(long stdId,
		java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteStandardsRegionChainByStdIdChnCd(stdId, chainCode);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.StandardsRegionChain> getStandardsRgnchainByStdId(
		long stdId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardsRgnchainByStdId(stdId, chainCode);
	}

	public static void cleanUpDataUtility() {
		getService().cleanUpDataUtility();
	}

	public static java.util.Set<java.lang.String> getRegions(
		com.ihg.brandstandards.db.model.Standards standard,
		java.util.Set<java.lang.String> allRegions)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRegions(standard, allRegions);
	}

	public static com.ihg.brandstandards.db.model.StandardsRegionChain getByStandardsRegionChain(
		long stdId, java.lang.String regionCode, java.lang.String chainCode) {
		return getService()
				   .getByStandardsRegionChain(stdId, regionCode, chainCode);
	}

	public static void clearService() {
		_service = null;
	}

	public static StandardsRegionChainLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					StandardsRegionChainLocalService.class.getName());

			if (invokableLocalService instanceof StandardsRegionChainLocalService) {
				_service = (StandardsRegionChainLocalService)invokableLocalService;
			}
			else {
				_service = new StandardsRegionChainLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(StandardsRegionChainLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(StandardsRegionChainLocalService service) {
	}

	private static StandardsRegionChainLocalService _service;
}