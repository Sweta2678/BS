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
 * Provides the local service utility for GlossaryTranslate. This utility wraps
 * {@link com.ihg.brandstandards.db.service.impl.GlossaryTranslateLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mummanedi
 * @see GlossaryTranslateLocalService
 * @see com.ihg.brandstandards.db.service.base.GlossaryTranslateLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.GlossaryTranslateLocalServiceImpl
 * @generated
 */
public class GlossaryTranslateLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.GlossaryTranslateLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the glossary translate to the database. Also notifies the appropriate model listeners.
	*
	* @param glossaryTranslate the glossary translate
	* @return the glossary translate that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryTranslate addGlossaryTranslate(
		com.ihg.brandstandards.db.model.GlossaryTranslate glossaryTranslate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addGlossaryTranslate(glossaryTranslate);
	}

	/**
	* Creates a new glossary translate with the primary key. Does not add the glossary translate to the database.
	*
	* @param glossaryXlatId the primary key for the new glossary translate
	* @return the new glossary translate
	*/
	public static com.ihg.brandstandards.db.model.GlossaryTranslate createGlossaryTranslate(
		long glossaryXlatId) {
		return getService().createGlossaryTranslate(glossaryXlatId);
	}

	/**
	* Deletes the glossary translate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param glossaryXlatId the primary key of the glossary translate
	* @return the glossary translate that was removed
	* @throws PortalException if a glossary translate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryTranslate deleteGlossaryTranslate(
		long glossaryXlatId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteGlossaryTranslate(glossaryXlatId);
	}

	/**
	* Deletes the glossary translate from the database. Also notifies the appropriate model listeners.
	*
	* @param glossaryTranslate the glossary translate
	* @return the glossary translate that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryTranslate deleteGlossaryTranslate(
		com.ihg.brandstandards.db.model.GlossaryTranslate glossaryTranslate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteGlossaryTranslate(glossaryTranslate);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.ihg.brandstandards.db.model.GlossaryTranslate fetchGlossaryTranslate(
		long glossaryXlatId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchGlossaryTranslate(glossaryXlatId);
	}

	/**
	* Returns the glossary translate with the primary key.
	*
	* @param glossaryXlatId the primary key of the glossary translate
	* @return the glossary translate
	* @throws PortalException if a glossary translate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryTranslate getGlossaryTranslate(
		long glossaryXlatId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getGlossaryTranslate(glossaryXlatId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the glossary translates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of glossary translates
	* @param end the upper bound of the range of glossary translates (not inclusive)
	* @return the range of glossary translates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryTranslate> getGlossaryTranslates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGlossaryTranslates(start, end);
	}

	/**
	* Returns the number of glossary translates.
	*
	* @return the number of glossary translates
	* @throws SystemException if a system exception occurred
	*/
	public static int getGlossaryTranslatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGlossaryTranslatesCount();
	}

	/**
	* Updates the glossary translate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param glossaryTranslate the glossary translate
	* @return the glossary translate that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GlossaryTranslate updateGlossaryTranslate(
		com.ihg.brandstandards.db.model.GlossaryTranslate glossaryTranslate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateGlossaryTranslate(glossaryTranslate);
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

	public static com.ihg.brandstandards.db.model.GlossaryTranslate getGlossaryTranslateObject() {
		return getService().getGlossaryTranslateObject();
	}

	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryTranslate> getGlossarriesByGlossaryId(
		long glossaryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGlossarriesByGlossaryId(glossaryId);
	}

	/**
	* Get GlosasryTranslate by glossaryId, localeCode.
	*
	* @param glossaryId Glossaryid.
	* @param localeCode localeCode.
	* @throws SystemException SystemException.
	* @throws NoSuchGlossaryTranslateException NoSuchGlossaryTranslateException.
	* @return GlosasryTranslate GlosasryTranslate.
	*/
	public static com.ihg.brandstandards.db.model.GlossaryTranslate getByGlossaryIdLocaleCode(
		long glossaryId, java.lang.String localeCode)
		throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getByGlossaryIdLocaleCode(glossaryId, localeCode);
	}

	public static com.ihg.brandstandards.db.model.GlossaryTranslate getGlossaryByLangCd(
		long glossaryId, java.lang.String langCode) {
		return getService().getGlossaryByLangCd(glossaryId, langCode);
	}

	/**
	* Get lsit GlosasryTranslate by localeCode.
	*
	* @param regionId Regionid.
	* @return List<GlossaryTranslate> List<GlossaryTranslate>.
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryTranslate> getByLocaleCode(
		java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByLocaleCode(localeCode);
	}

	/**
	* Remove Glossay translate entry from database by passing glossary Id
	*
	* @param glossaryId Glossary Id to passed for which translate need to delete.
	* @throws SystemException SystemException throws if system request is fail.
	*/
	public static void removeGlossaryTranslateByGlossaryId(long glossaryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().removeGlossaryTranslateByGlossaryId(glossaryId);
	}

	public static void clearService() {
		_service = null;
	}

	public static GlossaryTranslateLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					GlossaryTranslateLocalService.class.getName());

			if (invokableLocalService instanceof GlossaryTranslateLocalService) {
				_service = (GlossaryTranslateLocalService)invokableLocalService;
			}
			else {
				_service = new GlossaryTranslateLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(GlossaryTranslateLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(GlossaryTranslateLocalService service) {
	}

	private static GlossaryTranslateLocalService _service;
}