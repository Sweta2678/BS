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

import com.ihg.brandstandards.db.model.GEMTemplateReference;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the g e m template reference service. This utility wraps {@link GEMTemplateReferencePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMTemplateReferencePersistence
 * @see GEMTemplateReferencePersistenceImpl
 * @generated
 */
public class GEMTemplateReferenceUtil {
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
	public static void clearCache(GEMTemplateReference gemTemplateReference) {
		getPersistence().clearCache(gemTemplateReference);
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
	public static List<GEMTemplateReference> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GEMTemplateReference> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GEMTemplateReference> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GEMTemplateReference update(
		GEMTemplateReference gemTemplateReference) throws SystemException {
		return getPersistence().update(gemTemplateReference);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GEMTemplateReference update(
		GEMTemplateReference gemTemplateReference, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(gemTemplateReference, serviceContext);
	}

	/**
	* Returns all the g e m template references where publishDeptId = &#63; and regionId = &#63;.
	*
	* @param publishDeptId the publish dept ID
	* @param regionId the region ID
	* @return the matching g e m template references
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplateReference> findByPublishIdAndRgnId(
		long publishDeptId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPublishIdAndRgnId(publishDeptId, regionId);
	}

	/**
	* Returns a range of all the g e m template references where publishDeptId = &#63; and regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishDeptId the publish dept ID
	* @param regionId the region ID
	* @param start the lower bound of the range of g e m template references
	* @param end the upper bound of the range of g e m template references (not inclusive)
	* @return the range of matching g e m template references
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplateReference> findByPublishIdAndRgnId(
		long publishDeptId, long regionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndRgnId(publishDeptId, regionId, start, end);
	}

	/**
	* Returns an ordered range of all the g e m template references where publishDeptId = &#63; and regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishDeptId the publish dept ID
	* @param regionId the region ID
	* @param start the lower bound of the range of g e m template references
	* @param end the upper bound of the range of g e m template references (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g e m template references
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplateReference> findByPublishIdAndRgnId(
		long publishDeptId, long regionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndRgnId(publishDeptId, regionId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first g e m template reference in the ordered set where publishDeptId = &#63; and regionId = &#63;.
	*
	* @param publishDeptId the publish dept ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template reference
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException if a matching g e m template reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplateReference findByPublishIdAndRgnId_First(
		long publishDeptId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndRgnId_First(publishDeptId, regionId,
			orderByComparator);
	}

	/**
	* Returns the first g e m template reference in the ordered set where publishDeptId = &#63; and regionId = &#63;.
	*
	* @param publishDeptId the publish dept ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template reference, or <code>null</code> if a matching g e m template reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplateReference fetchByPublishIdAndRgnId_First(
		long publishDeptId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishIdAndRgnId_First(publishDeptId, regionId,
			orderByComparator);
	}

	/**
	* Returns the last g e m template reference in the ordered set where publishDeptId = &#63; and regionId = &#63;.
	*
	* @param publishDeptId the publish dept ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template reference
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException if a matching g e m template reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplateReference findByPublishIdAndRgnId_Last(
		long publishDeptId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndRgnId_Last(publishDeptId, regionId,
			orderByComparator);
	}

	/**
	* Returns the last g e m template reference in the ordered set where publishDeptId = &#63; and regionId = &#63;.
	*
	* @param publishDeptId the publish dept ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template reference, or <code>null</code> if a matching g e m template reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplateReference fetchByPublishIdAndRgnId_Last(
		long publishDeptId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishIdAndRgnId_Last(publishDeptId, regionId,
			orderByComparator);
	}

	/**
	* Returns the g e m template references before and after the current g e m template reference in the ordered set where publishDeptId = &#63; and regionId = &#63;.
	*
	* @param templateRefId the primary key of the current g e m template reference
	* @param publishDeptId the publish dept ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g e m template reference
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException if a g e m template reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplateReference[] findByPublishIdAndRgnId_PrevAndNext(
		long templateRefId, long publishDeptId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishIdAndRgnId_PrevAndNext(templateRefId,
			publishDeptId, regionId, orderByComparator);
	}

	/**
	* Removes all the g e m template references where publishDeptId = &#63; and regionId = &#63; from the database.
	*
	* @param publishDeptId the publish dept ID
	* @param regionId the region ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPublishIdAndRgnId(long publishDeptId,
		long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPublishIdAndRgnId(publishDeptId, regionId);
	}

	/**
	* Returns the number of g e m template references where publishDeptId = &#63; and regionId = &#63;.
	*
	* @param publishDeptId the publish dept ID
	* @param regionId the region ID
	* @return the number of matching g e m template references
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPublishIdAndRgnId(long publishDeptId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPublishIdAndRgnId(publishDeptId, regionId);
	}

	/**
	* Caches the g e m template reference in the entity cache if it is enabled.
	*
	* @param gemTemplateReference the g e m template reference
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.GEMTemplateReference gemTemplateReference) {
		getPersistence().cacheResult(gemTemplateReference);
	}

	/**
	* Caches the g e m template references in the entity cache if it is enabled.
	*
	* @param gemTemplateReferences the g e m template references
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GEMTemplateReference> gemTemplateReferences) {
		getPersistence().cacheResult(gemTemplateReferences);
	}

	/**
	* Creates a new g e m template reference with the primary key. Does not add the g e m template reference to the database.
	*
	* @param templateRefId the primary key for the new g e m template reference
	* @return the new g e m template reference
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplateReference create(
		long templateRefId) {
		return getPersistence().create(templateRefId);
	}

	/**
	* Removes the g e m template reference with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param templateRefId the primary key of the g e m template reference
	* @return the g e m template reference that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException if a g e m template reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplateReference remove(
		long templateRefId)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(templateRefId);
	}

	public static com.ihg.brandstandards.db.model.GEMTemplateReference updateImpl(
		com.ihg.brandstandards.db.model.GEMTemplateReference gemTemplateReference)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(gemTemplateReference);
	}

	/**
	* Returns the g e m template reference with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException} if it could not be found.
	*
	* @param templateRefId the primary key of the g e m template reference
	* @return the g e m template reference
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException if a g e m template reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplateReference findByPrimaryKey(
		long templateRefId)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(templateRefId);
	}

	/**
	* Returns the g e m template reference with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param templateRefId the primary key of the g e m template reference
	* @return the g e m template reference, or <code>null</code> if a g e m template reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMTemplateReference fetchByPrimaryKey(
		long templateRefId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(templateRefId);
	}

	/**
	* Returns all the g e m template references.
	*
	* @return the g e m template references
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplateReference> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the g e m template references.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m template references
	* @param end the upper bound of the range of g e m template references (not inclusive)
	* @return the range of g e m template references
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplateReference> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the g e m template references.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m template references
	* @param end the upper bound of the range of g e m template references (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of g e m template references
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMTemplateReference> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the g e m template references from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of g e m template references.
	*
	* @return the number of g e m template references
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GEMTemplateReferencePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GEMTemplateReferencePersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					GEMTemplateReferencePersistence.class.getName());

			ReferenceRegistry.registerReference(GEMTemplateReferenceUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GEMTemplateReferencePersistence persistence) {
	}

	private static GEMTemplateReferencePersistence _persistence;
}