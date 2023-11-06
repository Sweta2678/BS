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

package com.ihg.brandstandards.db.service.persistence;

import com.ihg.brandstandards.db.model.GEMTemplate;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the g e m template service. This utility wraps {@link GEMTemplatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMTemplatePersistence
 * @see GEMTemplatePersistenceImpl
 * @generated
 */
public class GEMTemplateUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(GEMTemplate gemTemplate) {
		getPersistence().clearCache(gemTemplate);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GEMTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GEMTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GEMTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GEMTemplate update(GEMTemplate gemTemplate)
		throws SystemException {
		return getPersistence().update(gemTemplate);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GEMTemplate update(GEMTemplate gemTemplate,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(gemTemplate, serviceContext);
	}

	/**
	* Returns all the g e m templates where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @return the matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByPublishId(
		long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPublishId(publishId);
	}

	/**
	* Returns a range of all the g e m templates where publishId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param start the lower bound of the range of g e m templates
	* @param end the upper bound of the range of g e m templates (not inclusive)
	* @return the range of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByPublishId(
		long publishId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPublishId(publishId, start, end);
	}

	/**
	* Returns an ordered range of all the g e m templates where publishId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param start the lower bound of the range of g e m templates
	* @param end the upper bound of the range of g e m templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByPublishId(
		long publishId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishId(publishId, start, end, orderByComparator);
	}

	/**
	* Returns the first g e m template in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate findByPublishId_First(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishId_First(publishId, orderByComparator);
	}

	/**
	* Returns the first g e m template in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template, or <code>null</code> if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate fetchByPublishId_First(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishId_First(publishId, orderByComparator);
	}

	/**
	* Returns the last g e m template in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate findByPublishId_Last(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishId_Last(publishId, orderByComparator);
	}

	/**
	* Returns the last g e m template in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template, or <code>null</code> if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate fetchByPublishId_Last(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishId_Last(publishId, orderByComparator);
	}

	/**
	* Returns the g e m templates before and after the current g e m template in the ordered set where publishId = &#63;.
	*
	* @param templateId the primary key of the current g e m template
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a g e m template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate[] findByPublishId_PrevAndNext(
		long templateId, long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishId_PrevAndNext(templateId, publishId,
			orderByComparator);
	}

	/**
	* Removes all the g e m templates where publishId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPublishId(long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPublishId(publishId);
	}

	/**
	* Returns the number of g e m templates where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @return the number of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPublishId(long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPublishId(publishId);
	}

	/**
	* Returns all the g e m templates where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @return the matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByPublishIdAndRgnId(
		long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPublishIdAndRgnId(publishId, regionId);
	}

	/**
	* Returns a range of all the g e m templates where publishId = &#63; and regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param start the lower bound of the range of g e m templates
	* @param end the upper bound of the range of g e m templates (not inclusive)
	* @return the range of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByPublishIdAndRgnId(
		long publishId, long regionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndRgnId(publishId, regionId, start, end);
	}

	/**
	* Returns an ordered range of all the g e m templates where publishId = &#63; and regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param start the lower bound of the range of g e m templates
	* @param end the upper bound of the range of g e m templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByPublishIdAndRgnId(
		long publishId, long regionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndRgnId(publishId, regionId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first g e m template in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate findByPublishIdAndRgnId_First(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndRgnId_First(publishId, regionId,
			orderByComparator);
	}

	/**
	* Returns the first g e m template in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template, or <code>null</code> if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate fetchByPublishIdAndRgnId_First(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishIdAndRgnId_First(publishId, regionId,
			orderByComparator);
	}

	/**
	* Returns the last g e m template in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate findByPublishIdAndRgnId_Last(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndRgnId_Last(publishId, regionId,
			orderByComparator);
	}

	/**
	* Returns the last g e m template in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template, or <code>null</code> if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate fetchByPublishIdAndRgnId_Last(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishIdAndRgnId_Last(publishId, regionId,
			orderByComparator);
	}

	/**
	* Returns the g e m templates before and after the current g e m template in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param templateId the primary key of the current g e m template
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a g e m template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate[] findByPublishIdAndRgnId_PrevAndNext(
		long templateId, long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndRgnId_PrevAndNext(templateId, publishId,
			regionId, orderByComparator);
	}

	/**
	* Removes all the g e m templates where publishId = &#63; and regionId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPublishIdAndRgnId(long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPublishIdAndRgnId(publishId, regionId);
	}

	/**
	* Returns the number of g e m templates where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @return the number of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPublishIdAndRgnId(long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPublishIdAndRgnId(publishId, regionId);
	}

	/**
	* Returns all the g e m templates where publishId = &#63; and regionId = &#63; and templateType = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param templateType the template type
	* @return the matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByPublishIdAndRgnIdAndType(
		long publishId, long regionId, java.lang.String templateType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndRgnIdAndType(publishId, regionId,
			templateType);
	}

	/**
	* Returns a range of all the g e m templates where publishId = &#63; and regionId = &#63; and templateType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param templateType the template type
	* @param start the lower bound of the range of g e m templates
	* @param end the upper bound of the range of g e m templates (not inclusive)
	* @return the range of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByPublishIdAndRgnIdAndType(
		long publishId, long regionId, java.lang.String templateType,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndRgnIdAndType(publishId, regionId,
			templateType, start, end);
	}

	/**
	* Returns an ordered range of all the g e m templates where publishId = &#63; and regionId = &#63; and templateType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param templateType the template type
	* @param start the lower bound of the range of g e m templates
	* @param end the upper bound of the range of g e m templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByPublishIdAndRgnIdAndType(
		long publishId, long regionId, java.lang.String templateType,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndRgnIdAndType(publishId, regionId,
			templateType, start, end, orderByComparator);
	}

	/**
	* Returns the first g e m template in the ordered set where publishId = &#63; and regionId = &#63; and templateType = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate findByPublishIdAndRgnIdAndType_First(
		long publishId, long regionId, java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndRgnIdAndType_First(publishId, regionId,
			templateType, orderByComparator);
	}

	/**
	* Returns the first g e m template in the ordered set where publishId = &#63; and regionId = &#63; and templateType = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template, or <code>null</code> if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate fetchByPublishIdAndRgnIdAndType_First(
		long publishId, long regionId, java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishIdAndRgnIdAndType_First(publishId, regionId,
			templateType, orderByComparator);
	}

	/**
	* Returns the last g e m template in the ordered set where publishId = &#63; and regionId = &#63; and templateType = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate findByPublishIdAndRgnIdAndType_Last(
		long publishId, long regionId, java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndRgnIdAndType_Last(publishId, regionId,
			templateType, orderByComparator);
	}

	/**
	* Returns the last g e m template in the ordered set where publishId = &#63; and regionId = &#63; and templateType = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template, or <code>null</code> if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate fetchByPublishIdAndRgnIdAndType_Last(
		long publishId, long regionId, java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishIdAndRgnIdAndType_Last(publishId, regionId,
			templateType, orderByComparator);
	}

	/**
	* Returns the g e m templates before and after the current g e m template in the ordered set where publishId = &#63; and regionId = &#63; and templateType = &#63;.
	*
	* @param templateId the primary key of the current g e m template
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a g e m template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate[] findByPublishIdAndRgnIdAndType_PrevAndNext(
		long templateId, long publishId, long regionId,
		java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndRgnIdAndType_PrevAndNext(templateId,
			publishId, regionId, templateType, orderByComparator);
	}

	/**
	* Removes all the g e m templates where publishId = &#63; and regionId = &#63; and templateType = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param templateType the template type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPublishIdAndRgnIdAndType(long publishId,
		long regionId, java.lang.String templateType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByPublishIdAndRgnIdAndType(publishId, regionId, templateType);
	}

	/**
	* Returns the number of g e m templates where publishId = &#63; and regionId = &#63; and templateType = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param templateType the template type
	* @return the number of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPublishIdAndRgnIdAndType(long publishId,
		long regionId, java.lang.String templateType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPublishIdAndRgnIdAndType(publishId, regionId,
			templateType);
	}

	/**
	* Returns the g e m template where templateType = &#63; and regionId = &#63; and publishId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchGEMTemplateException} if it could not be found.
	*
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @return the matching g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate findByTypeAndRegionAndPublication(
		java.lang.String templateType, long regionId, long publishId)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeAndRegionAndPublication(templateType, regionId,
			publishId);
	}

	/**
	* Returns the g e m template where templateType = &#63; and regionId = &#63; and publishId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @return the matching g e m template, or <code>null</code> if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate fetchByTypeAndRegionAndPublication(
		java.lang.String templateType, long regionId, long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeAndRegionAndPublication(templateType, regionId,
			publishId);
	}

	/**
	* Returns the g e m template where templateType = &#63; and regionId = &#63; and publishId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching g e m template, or <code>null</code> if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate fetchByTypeAndRegionAndPublication(
		java.lang.String templateType, long regionId, long publishId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeAndRegionAndPublication(templateType, regionId,
			publishId, retrieveFromCache);
	}

	/**
	* Removes the g e m template where templateType = &#63; and regionId = &#63; and publishId = &#63; from the database.
	*
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @return the g e m template that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate removeByTypeAndRegionAndPublication(
		java.lang.String templateType, long regionId, long publishId)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByTypeAndRegionAndPublication(templateType, regionId,
			publishId);
	}

	/**
	* Returns the number of g e m templates where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	*
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @return the number of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTypeAndRegionAndPublication(
		java.lang.String templateType, long regionId, long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByTypeAndRegionAndPublication(templateType, regionId,
			publishId);
	}

	/**
	* Returns all the g e m templates where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	*
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @return the matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByTypeAndRegionAndPublicationList(
		java.lang.String templateType, long regionId, long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeAndRegionAndPublicationList(templateType,
			regionId, publishId);
	}

	/**
	* Returns a range of all the g e m templates where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @param start the lower bound of the range of g e m templates
	* @param end the upper bound of the range of g e m templates (not inclusive)
	* @return the range of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByTypeAndRegionAndPublicationList(
		java.lang.String templateType, long regionId, long publishId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeAndRegionAndPublicationList(templateType,
			regionId, publishId, start, end);
	}

	/**
	* Returns an ordered range of all the g e m templates where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @param start the lower bound of the range of g e m templates
	* @param end the upper bound of the range of g e m templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByTypeAndRegionAndPublicationList(
		java.lang.String templateType, long regionId, long publishId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeAndRegionAndPublicationList(templateType,
			regionId, publishId, start, end, orderByComparator);
	}

	/**
	* Returns the first g e m template in the ordered set where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	*
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate findByTypeAndRegionAndPublicationList_First(
		java.lang.String templateType, long regionId, long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeAndRegionAndPublicationList_First(templateType,
			regionId, publishId, orderByComparator);
	}

	/**
	* Returns the first g e m template in the ordered set where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	*
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template, or <code>null</code> if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate fetchByTypeAndRegionAndPublicationList_First(
		java.lang.String templateType, long regionId, long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeAndRegionAndPublicationList_First(templateType,
			regionId, publishId, orderByComparator);
	}

	/**
	* Returns the last g e m template in the ordered set where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	*
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate findByTypeAndRegionAndPublicationList_Last(
		java.lang.String templateType, long regionId, long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeAndRegionAndPublicationList_Last(templateType,
			regionId, publishId, orderByComparator);
	}

	/**
	* Returns the last g e m template in the ordered set where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	*
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template, or <code>null</code> if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate fetchByTypeAndRegionAndPublicationList_Last(
		java.lang.String templateType, long regionId, long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTypeAndRegionAndPublicationList_Last(templateType,
			regionId, publishId, orderByComparator);
	}

	/**
	* Returns the g e m templates before and after the current g e m template in the ordered set where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	*
	* @param templateId the primary key of the current g e m template
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a g e m template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate[] findByTypeAndRegionAndPublicationList_PrevAndNext(
		long templateId, java.lang.String templateType, long regionId,
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTypeAndRegionAndPublicationList_PrevAndNext(templateId,
			templateType, regionId, publishId, orderByComparator);
	}

	/**
	* Removes all the g e m templates where templateType = &#63; and regionId = &#63; and publishId = &#63; from the database.
	*
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTypeAndRegionAndPublicationList(
		java.lang.String templateType, long regionId, long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByTypeAndRegionAndPublicationList(templateType, regionId,
			publishId);
	}

	/**
	* Returns the number of g e m templates where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	*
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @return the number of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTypeAndRegionAndPublicationList(
		java.lang.String templateType, long regionId, long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByTypeAndRegionAndPublicationList(templateType,
			regionId, publishId);
	}

	/**
	* Returns all the g e m templates where publishId = &#63; and templateType = &#63;.
	*
	* @param publishId the publish ID
	* @param templateType the template type
	* @return the matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByPublishIdAndTemplateType(
		long publishId, java.lang.String templateType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndTemplateType(publishId, templateType);
	}

	/**
	* Returns a range of all the g e m templates where publishId = &#63; and templateType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param templateType the template type
	* @param start the lower bound of the range of g e m templates
	* @param end the upper bound of the range of g e m templates (not inclusive)
	* @return the range of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByPublishIdAndTemplateType(
		long publishId, java.lang.String templateType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndTemplateType(publishId, templateType,
			start, end);
	}

	/**
	* Returns an ordered range of all the g e m templates where publishId = &#63; and templateType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param templateType the template type
	* @param start the lower bound of the range of g e m templates
	* @param end the upper bound of the range of g e m templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByPublishIdAndTemplateType(
		long publishId, java.lang.String templateType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndTemplateType(publishId, templateType,
			start, end, orderByComparator);
	}

	/**
	* Returns the first g e m template in the ordered set where publishId = &#63; and templateType = &#63;.
	*
	* @param publishId the publish ID
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate findByPublishIdAndTemplateType_First(
		long publishId, java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndTemplateType_First(publishId,
			templateType, orderByComparator);
	}

	/**
	* Returns the first g e m template in the ordered set where publishId = &#63; and templateType = &#63;.
	*
	* @param publishId the publish ID
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template, or <code>null</code> if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate fetchByPublishIdAndTemplateType_First(
		long publishId, java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishIdAndTemplateType_First(publishId,
			templateType, orderByComparator);
	}

	/**
	* Returns the last g e m template in the ordered set where publishId = &#63; and templateType = &#63;.
	*
	* @param publishId the publish ID
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate findByPublishIdAndTemplateType_Last(
		long publishId, java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndTemplateType_Last(publishId,
			templateType, orderByComparator);
	}

	/**
	* Returns the last g e m template in the ordered set where publishId = &#63; and templateType = &#63;.
	*
	* @param publishId the publish ID
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template, or <code>null</code> if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate fetchByPublishIdAndTemplateType_Last(
		long publishId, java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishIdAndTemplateType_Last(publishId,
			templateType, orderByComparator);
	}

	/**
	* Returns the g e m templates before and after the current g e m template in the ordered set where publishId = &#63; and templateType = &#63;.
	*
	* @param templateId the primary key of the current g e m template
	* @param publishId the publish ID
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a g e m template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate[] findByPublishIdAndTemplateType_PrevAndNext(
		long templateId, long publishId, java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndTemplateType_PrevAndNext(templateId,
			publishId, templateType, orderByComparator);
	}

	/**
	* Removes all the g e m templates where publishId = &#63; and templateType = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param templateType the template type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPublishIdAndTemplateType(long publishId,
		java.lang.String templateType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByPublishIdAndTemplateType(publishId, templateType);
	}

	/**
	* Returns the number of g e m templates where publishId = &#63; and templateType = &#63;.
	*
	* @param publishId the publish ID
	* @param templateType the template type
	* @return the number of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPublishIdAndTemplateType(long publishId,
		java.lang.String templateType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPublishIdAndTemplateType(publishId, templateType);
	}

	/**
	* Returns all the g e m templates where templateType = &#63;.
	*
	* @param templateType the template type
	* @return the matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByTemplateType(
		java.lang.String templateType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTemplateType(templateType);
	}

	/**
	* Returns a range of all the g e m templates where templateType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templateType the template type
	* @param start the lower bound of the range of g e m templates
	* @param end the upper bound of the range of g e m templates (not inclusive)
	* @return the range of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByTemplateType(
		java.lang.String templateType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTemplateType(templateType, start, end);
	}

	/**
	* Returns an ordered range of all the g e m templates where templateType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templateType the template type
	* @param start the lower bound of the range of g e m templates
	* @param end the upper bound of the range of g e m templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByTemplateType(
		java.lang.String templateType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateType(templateType, start, end,
			orderByComparator);
	}

	/**
	* Returns the first g e m template in the ordered set where templateType = &#63;.
	*
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate findByTemplateType_First(
		java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateType_First(templateType, orderByComparator);
	}

	/**
	* Returns the first g e m template in the ordered set where templateType = &#63;.
	*
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template, or <code>null</code> if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate fetchByTemplateType_First(
		java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplateType_First(templateType, orderByComparator);
	}

	/**
	* Returns the last g e m template in the ordered set where templateType = &#63;.
	*
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate findByTemplateType_Last(
		java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateType_Last(templateType, orderByComparator);
	}

	/**
	* Returns the last g e m template in the ordered set where templateType = &#63;.
	*
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template, or <code>null</code> if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate fetchByTemplateType_Last(
		java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTemplateType_Last(templateType, orderByComparator);
	}

	/**
	* Returns the g e m templates before and after the current g e m template in the ordered set where templateType = &#63;.
	*
	* @param templateId the primary key of the current g e m template
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a g e m template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate[] findByTemplateType_PrevAndNext(
		long templateId, java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTemplateType_PrevAndNext(templateId, templateType,
			orderByComparator);
	}

	/**
	* Removes all the g e m templates where templateType = &#63; from the database.
	*
	* @param templateType the template type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTemplateType(java.lang.String templateType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTemplateType(templateType);
	}

	/**
	* Returns the number of g e m templates where templateType = &#63;.
	*
	* @param templateType the template type
	* @return the number of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTemplateType(java.lang.String templateType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTemplateType(templateType);
	}

	/**
	* Caches the g e m template in the entity cache if it is enabled.
	*
	* @param gemTemplate the g e m template
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.GEMTemplate gemTemplate) {
		getPersistence().cacheResult(gemTemplate);
	}

	/**
	* Caches the g e m templates in the entity cache if it is enabled.
	*
	* @param gemTemplates the g e m templates
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> gemTemplates) {
		getPersistence().cacheResult(gemTemplates);
	}

	/**
	* Creates a new g e m template with the primary key. Does not add the g e m template to the database.
	*
	* @param templateId the primary key for the new g e m template
	* @return the new g e m template
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate create(
		long templateId) {
		return getPersistence().create(templateId);
	}

	/**
	* Removes the g e m template with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param templateId the primary key of the g e m template
	* @return the g e m template that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a g e m template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate remove(
		long templateId)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(templateId);
	}

	public static com.ihg.brandstandards.db.model.GEMTemplate updateImpl(
		com.ihg.brandstandards.db.model.GEMTemplate gemTemplate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(gemTemplate);
	}

	/**
	* Returns the g e m template with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMTemplateException} if it could not be found.
	*
	* @param templateId the primary key of the g e m template
	* @return the g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a g e m template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate findByPrimaryKey(
		long templateId)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(templateId);
	}

	/**
	* Returns the g e m template with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param templateId the primary key of the g e m template
	* @return the g e m template, or <code>null</code> if a g e m template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplate fetchByPrimaryKey(
		long templateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(templateId);
	}

	/**
	* Returns all the g e m templates.
	*
	* @return the g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the g e m templates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m templates
	* @param end the upper bound of the range of g e m templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the g e m templates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of g e m templates.
	*
	* @return the number of g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GEMTemplatePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GEMTemplatePersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					GEMTemplatePersistence.class.getName());

			ReferenceRegistry.registerReference(GEMTemplateUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GEMTemplatePersistence persistence) {
	}

	private static GEMTemplatePersistence _persistence;
}