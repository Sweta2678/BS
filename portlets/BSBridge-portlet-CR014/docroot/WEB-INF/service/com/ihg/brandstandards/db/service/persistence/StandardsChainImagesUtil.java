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

import com.ihg.brandstandards.db.model.StandardsChainImages;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the standards chain images service. This utility wraps {@link StandardsChainImagesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsChainImagesPersistence
 * @see StandardsChainImagesPersistenceImpl
 * @generated
 */
public class StandardsChainImagesUtil {
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
	public static void clearCache(StandardsChainImages standardsChainImages) {
		getPersistence().clearCache(standardsChainImages);
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
	public static List<StandardsChainImages> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StandardsChainImages> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StandardsChainImages> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static StandardsChainImages update(
		StandardsChainImages standardsChainImages) throws SystemException {
		return getPersistence().update(standardsChainImages);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static StandardsChainImages update(
		StandardsChainImages standardsChainImages, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(standardsChainImages, serviceContext);
	}

	/**
	* Returns all the standards chain imageses where stdImageId = &#63;.
	*
	* @param stdImageId the std image ID
	* @return the matching standards chain imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsChainImages> findBystdImageId(
		long stdImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystdImageId(stdImageId);
	}

	/**
	* Returns a range of all the standards chain imageses where stdImageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsChainImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdImageId the std image ID
	* @param start the lower bound of the range of standards chain imageses
	* @param end the upper bound of the range of standards chain imageses (not inclusive)
	* @return the range of matching standards chain imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsChainImages> findBystdImageId(
		long stdImageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystdImageId(stdImageId, start, end);
	}

	/**
	* Returns an ordered range of all the standards chain imageses where stdImageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsChainImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdImageId the std image ID
	* @param start the lower bound of the range of standards chain imageses
	* @param end the upper bound of the range of standards chain imageses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standards chain imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsChainImages> findBystdImageId(
		long stdImageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBystdImageId(stdImageId, start, end, orderByComparator);
	}

	/**
	* Returns the first standards chain images in the ordered set where stdImageId = &#63;.
	*
	* @param stdImageId the std image ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards chain images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsChainImagesException if a matching standards chain images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsChainImages findBystdImageId_First(
		long stdImageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsChainImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBystdImageId_First(stdImageId, orderByComparator);
	}

	/**
	* Returns the first standards chain images in the ordered set where stdImageId = &#63;.
	*
	* @param stdImageId the std image ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards chain images, or <code>null</code> if a matching standards chain images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsChainImages fetchBystdImageId_First(
		long stdImageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBystdImageId_First(stdImageId, orderByComparator);
	}

	/**
	* Returns the last standards chain images in the ordered set where stdImageId = &#63;.
	*
	* @param stdImageId the std image ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards chain images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsChainImagesException if a matching standards chain images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsChainImages findBystdImageId_Last(
		long stdImageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsChainImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBystdImageId_Last(stdImageId, orderByComparator);
	}

	/**
	* Returns the last standards chain images in the ordered set where stdImageId = &#63;.
	*
	* @param stdImageId the std image ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards chain images, or <code>null</code> if a matching standards chain images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsChainImages fetchBystdImageId_Last(
		long stdImageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBystdImageId_Last(stdImageId, orderByComparator);
	}

	/**
	* Returns the standards chain imageses before and after the current standards chain images in the ordered set where stdImageId = &#63;.
	*
	* @param standardsChainImagesPK the primary key of the current standards chain images
	* @param stdImageId the std image ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards chain images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsChainImagesException if a standards chain images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsChainImages[] findBystdImageId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.StandardsChainImagesPK standardsChainImagesPK,
		long stdImageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsChainImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBystdImageId_PrevAndNext(standardsChainImagesPK,
			stdImageId, orderByComparator);
	}

	/**
	* Removes all the standards chain imageses where stdImageId = &#63; from the database.
	*
	* @param stdImageId the std image ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBystdImageId(long stdImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBystdImageId(stdImageId);
	}

	/**
	* Returns the number of standards chain imageses where stdImageId = &#63;.
	*
	* @param stdImageId the std image ID
	* @return the number of matching standards chain imageses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBystdImageId(long stdImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBystdImageId(stdImageId);
	}

	/**
	* Caches the standards chain images in the entity cache if it is enabled.
	*
	* @param standardsChainImages the standards chain images
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.StandardsChainImages standardsChainImages) {
		getPersistence().cacheResult(standardsChainImages);
	}

	/**
	* Caches the standards chain imageses in the entity cache if it is enabled.
	*
	* @param standardsChainImageses the standards chain imageses
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.StandardsChainImages> standardsChainImageses) {
		getPersistence().cacheResult(standardsChainImageses);
	}

	/**
	* Creates a new standards chain images with the primary key. Does not add the standards chain images to the database.
	*
	* @param standardsChainImagesPK the primary key for the new standards chain images
	* @return the new standards chain images
	*/
	public static com.ihg.brandstandards.db.model.StandardsChainImages create(
		com.ihg.brandstandards.db.service.persistence.StandardsChainImagesPK standardsChainImagesPK) {
		return getPersistence().create(standardsChainImagesPK);
	}

	/**
	* Removes the standards chain images with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsChainImagesPK the primary key of the standards chain images
	* @return the standards chain images that was removed
	* @throws com.ihg.brandstandards.db.NoSuchStandardsChainImagesException if a standards chain images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsChainImages remove(
		com.ihg.brandstandards.db.service.persistence.StandardsChainImagesPK standardsChainImagesPK)
		throws com.ihg.brandstandards.db.NoSuchStandardsChainImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(standardsChainImagesPK);
	}

	public static com.ihg.brandstandards.db.model.StandardsChainImages updateImpl(
		com.ihg.brandstandards.db.model.StandardsChainImages standardsChainImages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(standardsChainImages);
	}

	/**
	* Returns the standards chain images with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsChainImagesException} if it could not be found.
	*
	* @param standardsChainImagesPK the primary key of the standards chain images
	* @return the standards chain images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsChainImagesException if a standards chain images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsChainImages findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardsChainImagesPK standardsChainImagesPK)
		throws com.ihg.brandstandards.db.NoSuchStandardsChainImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(standardsChainImagesPK);
	}

	/**
	* Returns the standards chain images with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param standardsChainImagesPK the primary key of the standards chain images
	* @return the standards chain images, or <code>null</code> if a standards chain images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsChainImages fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardsChainImagesPK standardsChainImagesPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(standardsChainImagesPK);
	}

	/**
	* Returns all the standards chain imageses.
	*
	* @return the standards chain imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsChainImages> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the standards chain imageses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsChainImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards chain imageses
	* @param end the upper bound of the range of standards chain imageses (not inclusive)
	* @return the range of standards chain imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsChainImages> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the standards chain imageses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsChainImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards chain imageses
	* @param end the upper bound of the range of standards chain imageses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of standards chain imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsChainImages> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the standards chain imageses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of standards chain imageses.
	*
	* @return the number of standards chain imageses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StandardsChainImagesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StandardsChainImagesPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					StandardsChainImagesPersistence.class.getName());

			ReferenceRegistry.registerReference(StandardsChainImagesUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(StandardsChainImagesPersistence persistence) {
	}

	private static StandardsChainImagesPersistence _persistence;
}