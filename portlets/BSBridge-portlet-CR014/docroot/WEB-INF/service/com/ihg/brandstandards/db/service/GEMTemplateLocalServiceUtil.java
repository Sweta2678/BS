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
 * Provides the local service utility for GEMTemplate. This utility wraps
 * {@link com.ihg.brandstandards.db.service.impl.GEMTemplateLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mummanedi
 * @see GEMTemplateLocalService
 * @see com.ihg.brandstandards.db.service.base.GEMTemplateLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.GEMTemplateLocalServiceImpl
 * @generated
 */
public class GEMTemplateLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.GEMTemplateLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the g e m template to the database. Also notifies the appropriate model listeners.
	*
	* @param gemTemplate the g e m template
	* @return the g e m template that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate addGEMTemplate(
		com.ihg.brandstandards.db.model.GEMTemplate gemTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addGEMTemplate(gemTemplate);
	}

	/**
	* Creates a new g e m template with the primary key. Does not add the g e m template to the database.
	*
	* @param templateId the primary key for the new g e m template
	* @return the new g e m template
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate createGEMTemplate(
		long templateId) {
		return getService().createGEMTemplate(templateId);
	}

	/**
	* Deletes the g e m template with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param templateId the primary key of the g e m template
	* @return the g e m template that was removed
	* @throws PortalException if a g e m template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate deleteGEMTemplate(
		long templateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteGEMTemplate(templateId);
	}

	/**
	* Deletes the g e m template from the database. Also notifies the appropriate model listeners.
	*
	* @param gemTemplate the g e m template
	* @return the g e m template that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate deleteGEMTemplate(
		com.ihg.brandstandards.db.model.GEMTemplate gemTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteGEMTemplate(gemTemplate);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.ihg.brandstandards.db.model.GEMTemplate fetchGEMTemplate(
		long templateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchGEMTemplate(templateId);
	}

	/**
	* Returns the g e m template with the primary key.
	*
	* @param templateId the primary key of the g e m template
	* @return the g e m template
	* @throws PortalException if a g e m template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate getGEMTemplate(
		long templateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getGEMTemplate(templateId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the g e m templates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m templates
	* @param end the upper bound of the range of g e m templates (not inclusive)
	* @return the range of g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> getGEMTemplates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGEMTemplates(start, end);
	}

	/**
	* Returns the number of g e m templates.
	*
	* @return the number of g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static int getGEMTemplatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGEMTemplatesCount();
	}

	/**
	* Updates the g e m template in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param gemTemplate the g e m template
	* @return the g e m template that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate updateGEMTemplate(
		com.ihg.brandstandards.db.model.GEMTemplate gemTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateGEMTemplate(gemTemplate);
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

	/**
	* @param templateType
	* @param regionId
	* @param publishId
	* @return
	* @throws NoSuchGEMTemplateException
	* @throws SystemException
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate getByTypeAndRegionAndPublication(
		java.lang.String templateType, long regionId, long publishId)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getByTypeAndRegionAndPublication(templateType, regionId,
			publishId);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> getByTypeAndRegionAndPublicationList(
		java.lang.String templateType, long regionId, long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getByTypeAndRegionAndPublicationList(templateType,
			regionId, publishId);
	}

	/**
	* @param publishId This is a publish department id
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> getByPublishId(
		long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByPublishId(publishId);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> getByPublishIdAndRgnId(
		long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByPublishIdAndRgnId(publishId, regionId);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> getByPublishIdAndRgnIdAndType(
		long publishId, long regionId, java.lang.String templateType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getByPublishIdAndRgnIdAndType(publishId, regionId,
			templateType);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> getByPublishIdAndTemplateType(
		long publishId, java.lang.String templateType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getByPublishIdAndTemplateType(publishId, templateType);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> getByTemplateType(
		java.lang.String templateType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByTemplateType(templateType);
	}

	/**
	* @param templateId
	Delete data from template, columns and values table.
	*/
	public static void deleteTemplateConfigurations(long templateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTemplateConfigurations(templateId);
	}

	/**
	* @param sequenceNumber
	* @return primaryKey
	*/
	public static long getSequenceNumber(java.lang.String sequenceNumber) {
		return getService().getSequenceNumber(sequenceNumber);
	}

	/**
	* @param columnId
	* @param columnValue
	* @param categoryId
	* @param orderNumber
	* @param createUserId
	* @return boolean
	* @throws SystemException
	*/
	public static boolean insertTemplateValueUsingSequence(long columnId,
		java.lang.String columnValue, long categoryId, long orderNumber,
		java.lang.String createUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .insertTemplateValueUsingSequence(columnId, columnValue,
			categoryId, orderNumber, createUserId);
	}

	public static void clearService() {
		_service = null;
	}

	public static GEMTemplateLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					GEMTemplateLocalService.class.getName());

			if (invokableLocalService instanceof GEMTemplateLocalService) {
				_service = (GEMTemplateLocalService)invokableLocalService;
			}
			else {
				_service = new GEMTemplateLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(GEMTemplateLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(GEMTemplateLocalService service) {
	}

	private static GEMTemplateLocalService _service;
}