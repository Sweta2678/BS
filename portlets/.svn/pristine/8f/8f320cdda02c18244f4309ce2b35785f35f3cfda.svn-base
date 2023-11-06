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
 * Provides the local service utility for GlossaryExt. This utility wraps
 * {@link com.ihg.brandstandards.db.service.impl.GlossaryExtLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mummanedi
 * @see GlossaryExtLocalService
 * @see com.ihg.brandstandards.db.service.base.GlossaryExtLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.GlossaryExtLocalServiceImpl
 * @generated
 */
public class GlossaryExtLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.GlossaryExtLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the glossary ext to the database. Also notifies the appropriate model listeners.
	*
	* @param glossaryExt the glossary ext
	* @return the glossary ext that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryExt addGlossaryExt(
		com.ihg.brandstandards.db.model.GlossaryExt glossaryExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addGlossaryExt(glossaryExt);
	}

	/**
	* Creates a new glossary ext with the primary key. Does not add the glossary ext to the database.
	*
	* @param glossaryId the primary key for the new glossary ext
	* @return the new glossary ext
	*/
	public static com.ihg.brandstandards.db.model.GlossaryExt createGlossaryExt(
		long glossaryId) {
		return getService().createGlossaryExt(glossaryId);
	}

	/**
	* Deletes the glossary ext with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param glossaryId the primary key of the glossary ext
	* @return the glossary ext that was removed
	* @throws PortalException if a glossary ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryExt deleteGlossaryExt(
		long glossaryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteGlossaryExt(glossaryId);
	}

	/**
	* Deletes the glossary ext from the database. Also notifies the appropriate model listeners.
	*
	* @param glossaryExt the glossary ext
	* @return the glossary ext that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryExt deleteGlossaryExt(
		com.ihg.brandstandards.db.model.GlossaryExt glossaryExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteGlossaryExt(glossaryExt);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.ihg.brandstandards.db.model.GlossaryExt fetchGlossaryExt(
		long glossaryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchGlossaryExt(glossaryId);
	}

	/**
	* Returns the glossary ext with the primary key.
	*
	* @param glossaryId the primary key of the glossary ext
	* @return the glossary ext
	* @throws PortalException if a glossary ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryExt getGlossaryExt(
		long glossaryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getGlossaryExt(glossaryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the glossary exts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of glossary exts
	* @param end the upper bound of the range of glossary exts (not inclusive)
	* @return the range of glossary exts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryExt> getGlossaryExts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGlossaryExts(start, end);
	}

	/**
	* Returns the number of glossary exts.
	*
	* @return the number of glossary exts
	* @throws SystemException if a system exception occurred
	*/
	public static int getGlossaryExtsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGlossaryExtsCount();
	}

	/**
	* Updates the glossary ext in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param glossaryExt the glossary ext
	* @return the glossary ext that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryExt updateGlossaryExt(
		com.ihg.brandstandards.db.model.GlossaryExt glossaryExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateGlossaryExt(glossaryExt);
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

	/**
	* Get Glossary By Brand code and char selected as input.
	*
	* @param brandCode  User selected Brand code.
	* @param visibleChar User Selected first char of Glossary.
	* @return List of @GlossaryExt object.
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryExt> getGlossaryByBrandCodeAndVisibleChar(
		java.lang.String brandCode, java.lang.String visibleChar) {
		return getService()
				   .getGlossaryByBrandCodeAndVisibleChar(brandCode, visibleChar);
	}

	public static void clearCache() {
		getService().clearCache();
	}

	public static void clearService() {
		_service = null;
	}

	public static GlossaryExtLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					GlossaryExtLocalService.class.getName());

			if (invokableLocalService instanceof GlossaryExtLocalService) {
				_service = (GlossaryExtLocalService)invokableLocalService;
			}
			else {
				_service = new GlossaryExtLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(GlossaryExtLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(GlossaryExtLocalService service) {
	}

	private static GlossaryExtLocalService _service;
}