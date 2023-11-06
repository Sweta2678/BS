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
 * Provides the local service utility for FlagCategory. This utility wraps
 * {@link com.ihg.brandstandards.db.service.impl.FlagCategoryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mummanedi
 * @see FlagCategoryLocalService
 * @see com.ihg.brandstandards.db.service.base.FlagCategoryLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.FlagCategoryLocalServiceImpl
 * @generated
 */
public class FlagCategoryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.FlagCategoryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the flag category to the database. Also notifies the appropriate model listeners.
	*
	* @param flagCategory the flag category
	* @return the flag category that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagCategory addFlagCategory(
		com.ihg.brandstandards.db.model.FlagCategory flagCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addFlagCategory(flagCategory);
	}

	/**
	* Creates a new flag category with the primary key. Does not add the flag category to the database.
	*
	* @param flagCategoryPK the primary key for the new flag category
	* @return the new flag category
	*/
	public static com.ihg.brandstandards.db.model.FlagCategory createFlagCategory(
		com.ihg.brandstandards.db.service.persistence.FlagCategoryPK flagCategoryPK) {
		return getService().createFlagCategory(flagCategoryPK);
	}

	/**
	* Deletes the flag category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param flagCategoryPK the primary key of the flag category
	* @return the flag category that was removed
	* @throws PortalException if a flag category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagCategory deleteFlagCategory(
		com.ihg.brandstandards.db.service.persistence.FlagCategoryPK flagCategoryPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFlagCategory(flagCategoryPK);
	}

	/**
	* Deletes the flag category from the database. Also notifies the appropriate model listeners.
	*
	* @param flagCategory the flag category
	* @return the flag category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagCategory deleteFlagCategory(
		com.ihg.brandstandards.db.model.FlagCategory flagCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFlagCategory(flagCategory);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.ihg.brandstandards.db.model.FlagCategory fetchFlagCategory(
		com.ihg.brandstandards.db.service.persistence.FlagCategoryPK flagCategoryPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchFlagCategory(flagCategoryPK);
	}

	/**
	* Returns the flag category with the primary key.
	*
	* @param flagCategoryPK the primary key of the flag category
	* @return the flag category
	* @throws PortalException if a flag category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagCategory getFlagCategory(
		com.ihg.brandstandards.db.service.persistence.FlagCategoryPK flagCategoryPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getFlagCategory(flagCategoryPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the flag categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flag categories
	* @param end the upper bound of the range of flag categories (not inclusive)
	* @return the range of flag categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.FlagCategory> getFlagCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFlagCategories(start, end);
	}

	/**
	* Returns the number of flag categories.
	*
	* @return the number of flag categories
	* @throws SystemException if a system exception occurred
	*/
	public static int getFlagCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFlagCategoriesCount();
	}

	/**
	* Updates the flag category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param flagCategory the flag category
	* @return the flag category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.FlagCategory updateFlagCategory(
		com.ihg.brandstandards.db.model.FlagCategory flagCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateFlagCategory(flagCategory);
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

	public static java.util.List<com.ihg.brandstandards.db.model.FlagCategory> getFlagCategoryByParentId(
		long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFlagCategoryByParentId(parentId);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.FlagCategory> getFlagCategoriesForParentIds(
		java.lang.String commaSeparateParentIds) {
		return getService().getFlagCategoriesForParentIds(commaSeparateParentIds);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.FlagCategory> getFlagCategoryByType(
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFlagCategoryByType(type);
	}

	public static com.ihg.brandstandards.db.model.FlagCategory getFlagCategory(
		long categoryId)
		throws com.ihg.brandstandards.db.NoSuchFlagCategoryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getFlagCategory(categoryId);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.FlagCategory> getFlagCategories(
		java.lang.String query) {
		return getService().getFlagCategories(query);
	}

	public static void clearService() {
		_service = null;
	}

	public static FlagCategoryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FlagCategoryLocalService.class.getName());

			if (invokableLocalService instanceof FlagCategoryLocalService) {
				_service = (FlagCategoryLocalService)invokableLocalService;
			}
			else {
				_service = new FlagCategoryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(FlagCategoryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(FlagCategoryLocalService service) {
	}

	private static FlagCategoryLocalService _service;
}