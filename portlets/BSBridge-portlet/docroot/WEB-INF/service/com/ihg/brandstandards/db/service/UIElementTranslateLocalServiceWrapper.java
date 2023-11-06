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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UIElementTranslateLocalService}.
 *
 * @author Mummanedi
 * @see UIElementTranslateLocalService
 * @generated
 */
public class UIElementTranslateLocalServiceWrapper
	implements UIElementTranslateLocalService,
		ServiceWrapper<UIElementTranslateLocalService> {
	public UIElementTranslateLocalServiceWrapper(
		UIElementTranslateLocalService uiElementTranslateLocalService) {
		_uiElementTranslateLocalService = uiElementTranslateLocalService;
	}

	/**
	* Adds the u i element translate to the database. Also notifies the appropriate model listeners.
	*
	* @param uiElementTranslate the u i element translate
	* @return the u i element translate that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.UIElementTranslate addUIElementTranslate(
		com.ihg.brandstandards.db.model.UIElementTranslate uiElementTranslate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uiElementTranslateLocalService.addUIElementTranslate(uiElementTranslate);
	}

	/**
	* Creates a new u i element translate with the primary key. Does not add the u i element translate to the database.
	*
	* @param uiElementTranslatePK the primary key for the new u i element translate
	* @return the new u i element translate
	*/
	@Override
	public com.ihg.brandstandards.db.model.UIElementTranslate createUIElementTranslate(
		com.ihg.brandstandards.db.service.persistence.UIElementTranslatePK uiElementTranslatePK) {
		return _uiElementTranslateLocalService.createUIElementTranslate(uiElementTranslatePK);
	}

	/**
	* Deletes the u i element translate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param uiElementTranslatePK the primary key of the u i element translate
	* @return the u i element translate that was removed
	* @throws PortalException if a u i element translate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.UIElementTranslate deleteUIElementTranslate(
		com.ihg.brandstandards.db.service.persistence.UIElementTranslatePK uiElementTranslatePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _uiElementTranslateLocalService.deleteUIElementTranslate(uiElementTranslatePK);
	}

	/**
	* Deletes the u i element translate from the database. Also notifies the appropriate model listeners.
	*
	* @param uiElementTranslate the u i element translate
	* @return the u i element translate that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.UIElementTranslate deleteUIElementTranslate(
		com.ihg.brandstandards.db.model.UIElementTranslate uiElementTranslate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uiElementTranslateLocalService.deleteUIElementTranslate(uiElementTranslate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _uiElementTranslateLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uiElementTranslateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UIElementTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _uiElementTranslateLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UIElementTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uiElementTranslateLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uiElementTranslateLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uiElementTranslateLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.UIElementTranslate fetchUIElementTranslate(
		com.ihg.brandstandards.db.service.persistence.UIElementTranslatePK uiElementTranslatePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uiElementTranslateLocalService.fetchUIElementTranslate(uiElementTranslatePK);
	}

	/**
	* Returns the u i element translate with the primary key.
	*
	* @param uiElementTranslatePK the primary key of the u i element translate
	* @return the u i element translate
	* @throws PortalException if a u i element translate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.UIElementTranslate getUIElementTranslate(
		com.ihg.brandstandards.db.service.persistence.UIElementTranslatePK uiElementTranslatePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _uiElementTranslateLocalService.getUIElementTranslate(uiElementTranslatePK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _uiElementTranslateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the u i element translates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UIElementTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of u i element translates
	* @param end the upper bound of the range of u i element translates (not inclusive)
	* @return the range of u i element translates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.UIElementTranslate> getUIElementTranslates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uiElementTranslateLocalService.getUIElementTranslates(start, end);
	}

	/**
	* Returns the number of u i element translates.
	*
	* @return the number of u i element translates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getUIElementTranslatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uiElementTranslateLocalService.getUIElementTranslatesCount();
	}

	/**
	* Updates the u i element translate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param uiElementTranslate the u i element translate
	* @return the u i element translate that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.UIElementTranslate updateUIElementTranslate(
		com.ihg.brandstandards.db.model.UIElementTranslate uiElementTranslate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uiElementTranslateLocalService.updateUIElementTranslate(uiElementTranslate);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _uiElementTranslateLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_uiElementTranslateLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _uiElementTranslateLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void clearCache() {
		_uiElementTranslateLocalService.clearCache();
	}

	@Override
	public com.ihg.brandstandards.db.model.UIElementTranslate getUIElementTranslateObject() {
		return _uiElementTranslateLocalService.getUIElementTranslateObject();
	}

	@Override
	public com.ihg.brandstandards.db.model.UIElementTranslate addNewUIElementData(
		com.ihg.brandstandards.db.model.UIElementTranslate uiElementData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uiElementTranslateLocalService.addNewUIElementData(uiElementData);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.UIElementTranslate> getByElementId(
		long elementId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uiElementTranslateLocalService.getByElementId(elementId);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.UIElementTranslate> getByLocaleCode(
		java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _uiElementTranslateLocalService.getByLocaleCode(localeCode);
	}

	@Override
	public com.ihg.brandstandards.db.model.UIElementTranslate getByIdAndLocaleCode(
		long elementId, java.lang.String localeCode)
		throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException,
			com.liferay.portal.kernel.exception.SystemException {
		return _uiElementTranslateLocalService.getByIdAndLocaleCode(elementId,
			localeCode);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public UIElementTranslateLocalService getWrappedUIElementTranslateLocalService() {
		return _uiElementTranslateLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedUIElementTranslateLocalService(
		UIElementTranslateLocalService uiElementTranslateLocalService) {
		_uiElementTranslateLocalService = uiElementTranslateLocalService;
	}

	@Override
	public UIElementTranslateLocalService getWrappedService() {
		return _uiElementTranslateLocalService;
	}

	@Override
	public void setWrappedService(
		UIElementTranslateLocalService uiElementTranslateLocalService) {
		_uiElementTranslateLocalService = uiElementTranslateLocalService;
	}

	private UIElementTranslateLocalService _uiElementTranslateLocalService;
}