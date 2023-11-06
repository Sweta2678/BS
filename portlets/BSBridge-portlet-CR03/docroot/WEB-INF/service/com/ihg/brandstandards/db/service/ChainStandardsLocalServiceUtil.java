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
 * Provides the local service utility for ChainStandards. This utility wraps
 * {@link com.ihg.brandstandards.db.service.impl.ChainStandardsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mummanedi
 * @see ChainStandardsLocalService
 * @see com.ihg.brandstandards.db.service.base.ChainStandardsLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.ChainStandardsLocalServiceImpl
 * @generated
 */
public class ChainStandardsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.ChainStandardsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the chain standards to the database. Also notifies the appropriate model listeners.
	*
	* @param chainStandards the chain standards
	* @return the chain standards that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainStandards addChainStandards(
		com.ihg.brandstandards.db.model.ChainStandards chainStandards)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addChainStandards(chainStandards);
	}

	/**
	* Creates a new chain standards with the primary key. Does not add the chain standards to the database.
	*
	* @param chainStandardsPK the primary key for the new chain standards
	* @return the new chain standards
	*/
	public static com.ihg.brandstandards.db.model.ChainStandards createChainStandards(
		com.ihg.brandstandards.db.service.persistence.ChainStandardsPK chainStandardsPK) {
		return getService().createChainStandards(chainStandardsPK);
	}

	/**
	* Deletes the chain standards with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param chainStandardsPK the primary key of the chain standards
	* @return the chain standards that was removed
	* @throws PortalException if a chain standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainStandards deleteChainStandards(
		com.ihg.brandstandards.db.service.persistence.ChainStandardsPK chainStandardsPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteChainStandards(chainStandardsPK);
	}

	/**
	* Deletes the chain standards from the database. Also notifies the appropriate model listeners.
	*
	* @param chainStandards the chain standards
	* @return the chain standards that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainStandards deleteChainStandards(
		com.ihg.brandstandards.db.model.ChainStandards chainStandards)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteChainStandards(chainStandards);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.ihg.brandstandards.db.model.ChainStandards fetchChainStandards(
		com.ihg.brandstandards.db.service.persistence.ChainStandardsPK chainStandardsPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchChainStandards(chainStandardsPK);
	}

	/**
	* Returns the chain standards with the primary key.
	*
	* @param chainStandardsPK the primary key of the chain standards
	* @return the chain standards
	* @throws PortalException if a chain standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainStandards getChainStandards(
		com.ihg.brandstandards.db.service.persistence.ChainStandardsPK chainStandardsPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getChainStandards(chainStandardsPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the chain standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of chain standardses
	* @param end the upper bound of the range of chain standardses (not inclusive)
	* @return the range of chain standardses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ChainStandards> getChainStandardses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getChainStandardses(start, end);
	}

	/**
	* Returns the number of chain standardses.
	*
	* @return the number of chain standardses
	* @throws SystemException if a system exception occurred
	*/
	public static int getChainStandardsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getChainStandardsesCount();
	}

	/**
	* Updates the chain standards in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param chainStandards the chain standards
	* @return the chain standards that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ChainStandards updateChainStandards(
		com.ihg.brandstandards.db.model.ChainStandards chainStandards)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateChainStandards(chainStandards);
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

	public static com.ihg.brandstandards.db.model.ChainStandards getChainStandardsObject() {
		return getService().getChainStandardsObject();
	}

	public static void clearCache() {
		getService().clearCache();
	}

	public static java.util.List<com.ihg.brandstandards.db.model.ChainStandards> getChainStandardsByStdId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getChainStandardsByStdId(stdId);
	}

	public static com.ihg.brandstandards.db.model.ChainStandards getChainStandardsByChainCode(
		long stdId, java.lang.String chainCode)
		throws com.ihg.brandstandards.db.NoSuchChainStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getChainStandardsByChainCode(stdId, chainCode);
	}

	public static com.ihg.brandstandards.db.model.ChainStandards getChainStandardsByChainCodeAll(
		long stdId, java.lang.String chainCode)
		throws com.ihg.brandstandards.db.NoSuchChainStandardsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getChainStandardsByChainCodeAll(stdId, chainCode);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.ChainStandards> getChainStandardsByStdIdAll(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getChainStandardsByStdIdAll(stdId);
	}

	public static java.util.List<java.lang.Long> getStandardsByChain(
		java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getStandardsByChain(chainCode);
	}

	public static void clearService() {
		_service = null;
	}

	public static ChainStandardsLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ChainStandardsLocalService.class.getName());

			if (invokableLocalService instanceof ChainStandardsLocalService) {
				_service = (ChainStandardsLocalService)invokableLocalService;
			}
			else {
				_service = new ChainStandardsLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ChainStandardsLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ChainStandardsLocalService service) {
	}

	private static ChainStandardsLocalService _service;
}