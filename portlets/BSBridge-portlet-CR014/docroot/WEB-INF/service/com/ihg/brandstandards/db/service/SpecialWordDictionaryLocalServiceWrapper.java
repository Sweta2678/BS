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
 * Provides a wrapper for {@link SpecialWordDictionaryLocalService}.
 *
 * @author Mummanedi
 * @see SpecialWordDictionaryLocalService
 * @generated
 */
public class SpecialWordDictionaryLocalServiceWrapper
	implements SpecialWordDictionaryLocalService,
		ServiceWrapper<SpecialWordDictionaryLocalService> {
	public SpecialWordDictionaryLocalServiceWrapper(
		SpecialWordDictionaryLocalService specialWordDictionaryLocalService) {
		_specialWordDictionaryLocalService = specialWordDictionaryLocalService;
	}

	/**
	* Adds the special word dictionary to the database. Also notifies the appropriate model listeners.
	*
	* @param specialWordDictionary the special word dictionary
	* @return the special word dictionary that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.SpecialWordDictionary addSpecialWordDictionary(
		com.ihg.brandstandards.db.model.SpecialWordDictionary specialWordDictionary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _specialWordDictionaryLocalService.addSpecialWordDictionary(specialWordDictionary);
	}

	/**
	* Creates a new special word dictionary with the primary key. Does not add the special word dictionary to the database.
	*
	* @param specialWordId the primary key for the new special word dictionary
	* @return the new special word dictionary
	*/
	@Override
	public com.ihg.brandstandards.db.model.SpecialWordDictionary createSpecialWordDictionary(
		long specialWordId) {
		return _specialWordDictionaryLocalService.createSpecialWordDictionary(specialWordId);
	}

	/**
	* Deletes the special word dictionary with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param specialWordId the primary key of the special word dictionary
	* @return the special word dictionary that was removed
	* @throws PortalException if a special word dictionary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.SpecialWordDictionary deleteSpecialWordDictionary(
		long specialWordId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _specialWordDictionaryLocalService.deleteSpecialWordDictionary(specialWordId);
	}

	/**
	* Deletes the special word dictionary from the database. Also notifies the appropriate model listeners.
	*
	* @param specialWordDictionary the special word dictionary
	* @return the special word dictionary that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.SpecialWordDictionary deleteSpecialWordDictionary(
		com.ihg.brandstandards.db.model.SpecialWordDictionary specialWordDictionary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _specialWordDictionaryLocalService.deleteSpecialWordDictionary(specialWordDictionary);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _specialWordDictionaryLocalService.dynamicQuery();
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
		return _specialWordDictionaryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpecialWordDictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _specialWordDictionaryLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpecialWordDictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _specialWordDictionaryLocalService.dynamicQuery(dynamicQuery,
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
		return _specialWordDictionaryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _specialWordDictionaryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.SpecialWordDictionary fetchSpecialWordDictionary(
		long specialWordId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _specialWordDictionaryLocalService.fetchSpecialWordDictionary(specialWordId);
	}

	/**
	* Returns the special word dictionary with the primary key.
	*
	* @param specialWordId the primary key of the special word dictionary
	* @return the special word dictionary
	* @throws PortalException if a special word dictionary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.SpecialWordDictionary getSpecialWordDictionary(
		long specialWordId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _specialWordDictionaryLocalService.getSpecialWordDictionary(specialWordId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _specialWordDictionaryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the special word dictionaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpecialWordDictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of special word dictionaries
	* @param end the upper bound of the range of special word dictionaries (not inclusive)
	* @return the range of special word dictionaries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.SpecialWordDictionary> getSpecialWordDictionaries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _specialWordDictionaryLocalService.getSpecialWordDictionaries(start,
			end);
	}

	/**
	* Returns the number of special word dictionaries.
	*
	* @return the number of special word dictionaries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSpecialWordDictionariesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _specialWordDictionaryLocalService.getSpecialWordDictionariesCount();
	}

	/**
	* Updates the special word dictionary in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param specialWordDictionary the special word dictionary
	* @return the special word dictionary that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.SpecialWordDictionary updateSpecialWordDictionary(
		com.ihg.brandstandards.db.model.SpecialWordDictionary specialWordDictionary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _specialWordDictionaryLocalService.updateSpecialWordDictionary(specialWordDictionary);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _specialWordDictionaryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_specialWordDictionaryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _specialWordDictionaryLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void clearCache() {
		_specialWordDictionaryLocalService.clearCache();
	}

	@Override
	public com.ihg.brandstandards.db.model.SpecialWordDictionary getByReplacedWordTxtAndLocaleCode(
		java.lang.String replacedWordTxt, java.lang.String localeCode) {
		return _specialWordDictionaryLocalService.getByReplacedWordTxtAndLocaleCode(replacedWordTxt,
			localeCode);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.SpecialWordDictionary> getByReplacementWordTxtAndLocaleCode(
		java.lang.String replacementWordTxt, java.lang.String localeCode) {
		return _specialWordDictionaryLocalService.getByReplacementWordTxtAndLocaleCode(replacementWordTxt,
			localeCode);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.SpecialWordDictionary> getByLocaleCode(
		java.lang.String localeCode) {
		return _specialWordDictionaryLocalService.getByLocaleCode(localeCode);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SpecialWordDictionaryLocalService getWrappedSpecialWordDictionaryLocalService() {
		return _specialWordDictionaryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSpecialWordDictionaryLocalService(
		SpecialWordDictionaryLocalService specialWordDictionaryLocalService) {
		_specialWordDictionaryLocalService = specialWordDictionaryLocalService;
	}

	@Override
	public SpecialWordDictionaryLocalService getWrappedService() {
		return _specialWordDictionaryLocalService;
	}

	@Override
	public void setWrappedService(
		SpecialWordDictionaryLocalService specialWordDictionaryLocalService) {
		_specialWordDictionaryLocalService = specialWordDictionaryLocalService;
	}

	private SpecialWordDictionaryLocalService _specialWordDictionaryLocalService;
}