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
 * Provides the local service utility for GEMStdCategory. This utility wraps
 * {@link com.ihg.brandstandards.db.service.impl.GEMStdCategoryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mummanedi
 * @see GEMStdCategoryLocalService
 * @see com.ihg.brandstandards.db.service.base.GEMStdCategoryLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.GEMStdCategoryLocalServiceImpl
 * @generated
 */
public class GEMStdCategoryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.GEMStdCategoryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the g e m std category to the database. Also notifies the appropriate model listeners.
	*
	* @param gemStdCategory the g e m std category
	* @return the g e m std category that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMStdCategory addGEMStdCategory(
		com.ihg.brandstandards.db.model.GEMStdCategory gemStdCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addGEMStdCategory(gemStdCategory);
	}

	/**
	* Creates a new g e m std category with the primary key. Does not add the g e m std category to the database.
	*
	* @param gemStdCategoryId the primary key for the new g e m std category
	* @return the new g e m std category
	*/
	public static com.ihg.brandstandards.db.model.GEMStdCategory createGEMStdCategory(
		long gemStdCategoryId) {
		return getService().createGEMStdCategory(gemStdCategoryId);
	}

	/**
	* Deletes the g e m std category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param gemStdCategoryId the primary key of the g e m std category
	* @return the g e m std category that was removed
	* @throws PortalException if a g e m std category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMStdCategory deleteGEMStdCategory(
		long gemStdCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteGEMStdCategory(gemStdCategoryId);
	}

	/**
	* Deletes the g e m std category from the database. Also notifies the appropriate model listeners.
	*
	* @param gemStdCategory the g e m std category
	* @return the g e m std category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMStdCategory deleteGEMStdCategory(
		com.ihg.brandstandards.db.model.GEMStdCategory gemStdCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteGEMStdCategory(gemStdCategory);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMStdCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMStdCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.ihg.brandstandards.db.model.GEMStdCategory fetchGEMStdCategory(
		long gemStdCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchGEMStdCategory(gemStdCategoryId);
	}

	/**
	* Returns the g e m std category with the primary key.
	*
	* @param gemStdCategoryId the primary key of the g e m std category
	* @return the g e m std category
	* @throws PortalException if a g e m std category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMStdCategory getGEMStdCategory(
		long gemStdCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getGEMStdCategory(gemStdCategoryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the g e m std categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMStdCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m std categories
	* @param end the upper bound of the range of g e m std categories (not inclusive)
	* @return the range of g e m std categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> getGEMStdCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGEMStdCategories(start, end);
	}

	/**
	* Returns the number of g e m std categories.
	*
	* @return the number of g e m std categories
	* @throws SystemException if a system exception occurred
	*/
	public static int getGEMStdCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGEMStdCategoriesCount();
	}

	/**
	* Updates the g e m std category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param gemStdCategory the g e m std category
	* @return the g e m std category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMStdCategory updateGEMStdCategory(
		com.ihg.brandstandards.db.model.GEMStdCategory gemStdCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateGEMStdCategory(gemStdCategory);
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

	public static com.ihg.brandstandards.db.model.GEMStdCategory getByStdCatgyMapping(
		long stdId, long categoryId, java.lang.String templateType,
		java.lang.String chainCode)
		throws com.ihg.brandstandards.db.NoSuchGEMStdCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getByStdCatgyMapping(stdId, categoryId, templateType,
			chainCode);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> getByCatgyTemplateAndChain(
		long categoryId, java.lang.String templateType,
		java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getByCatgyTemplateAndChain(categoryId, templateType,
			chainCode);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> getByCatgyAndChain(
		long categoryId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByCatgyAndChain(categoryId, chainCode);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.GEMStdCategory> getByCategoryId(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByCategoryId(categoryId);
	}

	public static com.ihg.brandstandards.db.model.GEMStdCategory addGEMStdCategoryMaping(
		long stdId, long categoryId, java.lang.String templateType,
		java.lang.String chainCode, java.lang.String creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addGEMStdCategoryMaping(stdId, categoryId, templateType,
			chainCode, creatorId);
	}

	public static com.ihg.brandstandards.db.model.GEMStdCategory updateGEMStdCategoryMaping(
		long stdId, long categoryId, java.lang.String templateType,
		java.lang.String chainCode, java.lang.String creatorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateGEMStdCategoryMaping(stdId, categoryId, templateType,
			chainCode, creatorId);
	}

	public static void clearService() {
		_service = null;
	}

	public static GEMStdCategoryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					GEMStdCategoryLocalService.class.getName());

			if (invokableLocalService instanceof GEMStdCategoryLocalService) {
				_service = (GEMStdCategoryLocalService)invokableLocalService;
			}
			else {
				_service = new GEMStdCategoryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(GEMStdCategoryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(GEMStdCategoryLocalService service) {
	}

	private static GEMStdCategoryLocalService _service;
}