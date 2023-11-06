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

import com.ihg.brandstandards.db.model.StandardsImages;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the standards images service. This utility wraps {@link StandardsImagesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsImagesPersistence
 * @see StandardsImagesPersistenceImpl
 * @generated
 */
public class StandardsImagesUtil {
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
	public static void clearCache(StandardsImages standardsImages) {
		getPersistence().clearCache(standardsImages);
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
	public static List<StandardsImages> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StandardsImages> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StandardsImages> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static StandardsImages update(StandardsImages standardsImages)
		throws SystemException {
		return getPersistence().update(standardsImages);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static StandardsImages update(StandardsImages standardsImages,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(standardsImages, serviceContext);
	}

	/**
	* Returns all the standards imageses where imageId = &#63;.
	*
	* @param imageId the image ID
	* @return the matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> findByimageId(
		long imageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByimageId(imageId);
	}

	/**
	* Returns a range of all the standards imageses where imageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param imageId the image ID
	* @param start the lower bound of the range of standards imageses
	* @param end the upper bound of the range of standards imageses (not inclusive)
	* @return the range of matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> findByimageId(
		long imageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByimageId(imageId, start, end);
	}

	/**
	* Returns an ordered range of all the standards imageses where imageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param imageId the image ID
	* @param start the lower bound of the range of standards imageses
	* @param end the upper bound of the range of standards imageses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> findByimageId(
		long imageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByimageId(imageId, start, end, orderByComparator);
	}

	/**
	* Returns the first standards images in the ordered set where imageId = &#63;.
	*
	* @param imageId the image ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages findByimageId_First(
		long imageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByimageId_First(imageId, orderByComparator);
	}

	/**
	* Returns the first standards images in the ordered set where imageId = &#63;.
	*
	* @param imageId the image ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards images, or <code>null</code> if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages fetchByimageId_First(
		long imageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByimageId_First(imageId, orderByComparator);
	}

	/**
	* Returns the last standards images in the ordered set where imageId = &#63;.
	*
	* @param imageId the image ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages findByimageId_Last(
		long imageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByimageId_Last(imageId, orderByComparator);
	}

	/**
	* Returns the last standards images in the ordered set where imageId = &#63;.
	*
	* @param imageId the image ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards images, or <code>null</code> if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages fetchByimageId_Last(
		long imageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByimageId_Last(imageId, orderByComparator);
	}

	/**
	* Returns the standards imageses before and after the current standards images in the ordered set where imageId = &#63;.
	*
	* @param stdImageId the primary key of the current standards images
	* @param imageId the image ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a standards images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages[] findByimageId_PrevAndNext(
		long stdImageId, long imageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByimageId_PrevAndNext(stdImageId, imageId,
			orderByComparator);
	}

	/**
	* Removes all the standards imageses where imageId = &#63; from the database.
	*
	* @param imageId the image ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByimageId(long imageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByimageId(imageId);
	}

	/**
	* Returns the number of standards imageses where imageId = &#63;.
	*
	* @param imageId the image ID
	* @return the number of matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByimageId(long imageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByimageId(imageId);
	}

	/**
	* Returns all the standards imageses where imageId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param imageId the image ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @return the matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> findByImageIdStdIdLocaleCd(
		long imageId, long stdId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByImageIdStdIdLocaleCd(imageId, stdId, localeCode);
	}

	/**
	* Returns a range of all the standards imageses where imageId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param imageId the image ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param start the lower bound of the range of standards imageses
	* @param end the upper bound of the range of standards imageses (not inclusive)
	* @return the range of matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> findByImageIdStdIdLocaleCd(
		long imageId, long stdId, java.lang.String localeCode, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByImageIdStdIdLocaleCd(imageId, stdId, localeCode,
			start, end);
	}

	/**
	* Returns an ordered range of all the standards imageses where imageId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param imageId the image ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param start the lower bound of the range of standards imageses
	* @param end the upper bound of the range of standards imageses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> findByImageIdStdIdLocaleCd(
		long imageId, long stdId, java.lang.String localeCode, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByImageIdStdIdLocaleCd(imageId, stdId, localeCode,
			start, end, orderByComparator);
	}

	/**
	* Returns the first standards images in the ordered set where imageId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param imageId the image ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages findByImageIdStdIdLocaleCd_First(
		long imageId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByImageIdStdIdLocaleCd_First(imageId, stdId,
			localeCode, orderByComparator);
	}

	/**
	* Returns the first standards images in the ordered set where imageId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param imageId the image ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards images, or <code>null</code> if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages fetchByImageIdStdIdLocaleCd_First(
		long imageId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByImageIdStdIdLocaleCd_First(imageId, stdId,
			localeCode, orderByComparator);
	}

	/**
	* Returns the last standards images in the ordered set where imageId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param imageId the image ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages findByImageIdStdIdLocaleCd_Last(
		long imageId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByImageIdStdIdLocaleCd_Last(imageId, stdId, localeCode,
			orderByComparator);
	}

	/**
	* Returns the last standards images in the ordered set where imageId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param imageId the image ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards images, or <code>null</code> if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages fetchByImageIdStdIdLocaleCd_Last(
		long imageId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByImageIdStdIdLocaleCd_Last(imageId, stdId,
			localeCode, orderByComparator);
	}

	/**
	* Returns the standards imageses before and after the current standards images in the ordered set where imageId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param stdImageId the primary key of the current standards images
	* @param imageId the image ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a standards images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages[] findByImageIdStdIdLocaleCd_PrevAndNext(
		long stdImageId, long imageId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByImageIdStdIdLocaleCd_PrevAndNext(stdImageId, imageId,
			stdId, localeCode, orderByComparator);
	}

	/**
	* Removes all the standards imageses where imageId = &#63; and stdId = &#63; and localeCode = &#63; from the database.
	*
	* @param imageId the image ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByImageIdStdIdLocaleCd(long imageId, long stdId,
		java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByImageIdStdIdLocaleCd(imageId, stdId, localeCode);
	}

	/**
	* Returns the number of standards imageses where imageId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param imageId the image ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @return the number of matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByImageIdStdIdLocaleCd(long imageId, long stdId,
		java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByImageIdStdIdLocaleCd(imageId, stdId, localeCode);
	}

	/**
	* Returns all the standards imageses where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> findByStdId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId(stdId);
	}

	/**
	* Returns a range of all the standards imageses where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of standards imageses
	* @param end the upper bound of the range of standards imageses (not inclusive)
	* @return the range of matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> findByStdId(
		long stdId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId(stdId, start, end);
	}

	/**
	* Returns an ordered range of all the standards imageses where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of standards imageses
	* @param end the upper bound of the range of standards imageses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> findByStdId(
		long stdId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId(stdId, start, end, orderByComparator);
	}

	/**
	* Returns the first standards images in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages findByStdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId_First(stdId, orderByComparator);
	}

	/**
	* Returns the first standards images in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards images, or <code>null</code> if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages fetchByStdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStdId_First(stdId, orderByComparator);
	}

	/**
	* Returns the last standards images in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages findByStdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStdId_Last(stdId, orderByComparator);
	}

	/**
	* Returns the last standards images in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards images, or <code>null</code> if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages fetchByStdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStdId_Last(stdId, orderByComparator);
	}

	/**
	* Returns the standards imageses before and after the current standards images in the ordered set where stdId = &#63;.
	*
	* @param stdImageId the primary key of the current standards images
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a standards images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages[] findByStdId_PrevAndNext(
		long stdImageId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStdId_PrevAndNext(stdImageId, stdId, orderByComparator);
	}

	/**
	* Removes all the standards imageses where stdId = &#63; from the database.
	*
	* @param stdId the std ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStdId(stdId);
	}

	/**
	* Returns the number of standards imageses where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the number of matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStdId(stdId);
	}

	/**
	* Returns all the standards imageses where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> findByparentsStdId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByparentsStdId(stdId);
	}

	/**
	* Returns a range of all the standards imageses where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of standards imageses
	* @param end the upper bound of the range of standards imageses (not inclusive)
	* @return the range of matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> findByparentsStdId(
		long stdId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByparentsStdId(stdId, start, end);
	}

	/**
	* Returns an ordered range of all the standards imageses where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of standards imageses
	* @param end the upper bound of the range of standards imageses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> findByparentsStdId(
		long stdId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentsStdId(stdId, start, end, orderByComparator);
	}

	/**
	* Returns the first standards images in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages findByparentsStdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentsStdId_First(stdId, orderByComparator);
	}

	/**
	* Returns the first standards images in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards images, or <code>null</code> if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages fetchByparentsStdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByparentsStdId_First(stdId, orderByComparator);
	}

	/**
	* Returns the last standards images in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages findByparentsStdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByparentsStdId_Last(stdId, orderByComparator);
	}

	/**
	* Returns the last standards images in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards images, or <code>null</code> if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages fetchByparentsStdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByparentsStdId_Last(stdId, orderByComparator);
	}

	/**
	* Returns the standards imageses before and after the current standards images in the ordered set where stdId = &#63;.
	*
	* @param stdImageId the primary key of the current standards images
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a standards images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages[] findByparentsStdId_PrevAndNext(
		long stdImageId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentsStdId_PrevAndNext(stdImageId, stdId,
			orderByComparator);
	}

	/**
	* Removes all the standards imageses where stdId = &#63; from the database.
	*
	* @param stdId the std ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByparentsStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByparentsStdId(stdId);
	}

	/**
	* Returns the number of standards imageses where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the number of matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByparentsStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByparentsStdId(stdId);
	}

	/**
	* Returns all the standards imageses where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @return the matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> findByparentsStdIdLocaleCode(
		long stdId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByparentsStdIdLocaleCode(stdId, localeCode);
	}

	/**
	* Returns a range of all the standards imageses where stdId = &#63; and localeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param start the lower bound of the range of standards imageses
	* @param end the upper bound of the range of standards imageses (not inclusive)
	* @return the range of matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> findByparentsStdIdLocaleCode(
		long stdId, java.lang.String localeCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentsStdIdLocaleCode(stdId, localeCode, start, end);
	}

	/**
	* Returns an ordered range of all the standards imageses where stdId = &#63; and localeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param start the lower bound of the range of standards imageses
	* @param end the upper bound of the range of standards imageses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> findByparentsStdIdLocaleCode(
		long stdId, java.lang.String localeCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentsStdIdLocaleCode(stdId, localeCode, start, end,
			orderByComparator);
	}

	/**
	* Returns the first standards images in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages findByparentsStdIdLocaleCode_First(
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentsStdIdLocaleCode_First(stdId, localeCode,
			orderByComparator);
	}

	/**
	* Returns the first standards images in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards images, or <code>null</code> if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages fetchByparentsStdIdLocaleCode_First(
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByparentsStdIdLocaleCode_First(stdId, localeCode,
			orderByComparator);
	}

	/**
	* Returns the last standards images in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages findByparentsStdIdLocaleCode_Last(
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentsStdIdLocaleCode_Last(stdId, localeCode,
			orderByComparator);
	}

	/**
	* Returns the last standards images in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards images, or <code>null</code> if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages fetchByparentsStdIdLocaleCode_Last(
		long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByparentsStdIdLocaleCode_Last(stdId, localeCode,
			orderByComparator);
	}

	/**
	* Returns the standards imageses before and after the current standards images in the ordered set where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdImageId the primary key of the current standards images
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a standards images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages[] findByparentsStdIdLocaleCode_PrevAndNext(
		long stdImageId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByparentsStdIdLocaleCode_PrevAndNext(stdImageId, stdId,
			localeCode, orderByComparator);
	}

	/**
	* Removes all the standards imageses where stdId = &#63; and localeCode = &#63; from the database.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByparentsStdIdLocaleCode(long stdId,
		java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByparentsStdIdLocaleCode(stdId, localeCode);
	}

	/**
	* Returns the number of standards imageses where stdId = &#63; and localeCode = &#63;.
	*
	* @param stdId the std ID
	* @param localeCode the locale code
	* @return the number of matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByparentsStdIdLocaleCode(long stdId,
		java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByparentsStdIdLocaleCode(stdId, localeCode);
	}

	/**
	* Returns all the standards imageses where parentImageId = &#63; and stdId = &#63;.
	*
	* @param parentImageId the parent image ID
	* @param stdId the std ID
	* @return the matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> findByParentImageIdStdId(
		long parentImageId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParentImageIdStdId(parentImageId, stdId);
	}

	/**
	* Returns a range of all the standards imageses where parentImageId = &#63; and stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentImageId the parent image ID
	* @param stdId the std ID
	* @param start the lower bound of the range of standards imageses
	* @param end the upper bound of the range of standards imageses (not inclusive)
	* @return the range of matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> findByParentImageIdStdId(
		long parentImageId, long stdId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentImageIdStdId(parentImageId, stdId, start, end);
	}

	/**
	* Returns an ordered range of all the standards imageses where parentImageId = &#63; and stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentImageId the parent image ID
	* @param stdId the std ID
	* @param start the lower bound of the range of standards imageses
	* @param end the upper bound of the range of standards imageses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> findByParentImageIdStdId(
		long parentImageId, long stdId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentImageIdStdId(parentImageId, stdId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first standards images in the ordered set where parentImageId = &#63; and stdId = &#63;.
	*
	* @param parentImageId the parent image ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages findByParentImageIdStdId_First(
		long parentImageId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentImageIdStdId_First(parentImageId, stdId,
			orderByComparator);
	}

	/**
	* Returns the first standards images in the ordered set where parentImageId = &#63; and stdId = &#63;.
	*
	* @param parentImageId the parent image ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards images, or <code>null</code> if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages fetchByParentImageIdStdId_First(
		long parentImageId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentImageIdStdId_First(parentImageId, stdId,
			orderByComparator);
	}

	/**
	* Returns the last standards images in the ordered set where parentImageId = &#63; and stdId = &#63;.
	*
	* @param parentImageId the parent image ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages findByParentImageIdStdId_Last(
		long parentImageId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentImageIdStdId_Last(parentImageId, stdId,
			orderByComparator);
	}

	/**
	* Returns the last standards images in the ordered set where parentImageId = &#63; and stdId = &#63;.
	*
	* @param parentImageId the parent image ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards images, or <code>null</code> if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages fetchByParentImageIdStdId_Last(
		long parentImageId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentImageIdStdId_Last(parentImageId, stdId,
			orderByComparator);
	}

	/**
	* Returns the standards imageses before and after the current standards images in the ordered set where parentImageId = &#63; and stdId = &#63;.
	*
	* @param stdImageId the primary key of the current standards images
	* @param parentImageId the parent image ID
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a standards images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages[] findByParentImageIdStdId_PrevAndNext(
		long stdImageId, long parentImageId, long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentImageIdStdId_PrevAndNext(stdImageId,
			parentImageId, stdId, orderByComparator);
	}

	/**
	* Removes all the standards imageses where parentImageId = &#63; and stdId = &#63; from the database.
	*
	* @param parentImageId the parent image ID
	* @param stdId the std ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParentImageIdStdId(long parentImageId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParentImageIdStdId(parentImageId, stdId);
	}

	/**
	* Returns the number of standards imageses where parentImageId = &#63; and stdId = &#63;.
	*
	* @param parentImageId the parent image ID
	* @param stdId the std ID
	* @return the number of matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParentImageIdStdId(long parentImageId, long stdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByParentImageIdStdId(parentImageId, stdId);
	}

	/**
	* Returns all the standards imageses where parentImageId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param parentImageId the parent image ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @return the matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> findByParentImageIdStdIdLocaleCd(
		long parentImageId, long stdId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentImageIdStdIdLocaleCd(parentImageId, stdId,
			localeCode);
	}

	/**
	* Returns a range of all the standards imageses where parentImageId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentImageId the parent image ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param start the lower bound of the range of standards imageses
	* @param end the upper bound of the range of standards imageses (not inclusive)
	* @return the range of matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> findByParentImageIdStdIdLocaleCd(
		long parentImageId, long stdId, java.lang.String localeCode, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentImageIdStdIdLocaleCd(parentImageId, stdId,
			localeCode, start, end);
	}

	/**
	* Returns an ordered range of all the standards imageses where parentImageId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentImageId the parent image ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param start the lower bound of the range of standards imageses
	* @param end the upper bound of the range of standards imageses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> findByParentImageIdStdIdLocaleCd(
		long parentImageId, long stdId, java.lang.String localeCode, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentImageIdStdIdLocaleCd(parentImageId, stdId,
			localeCode, start, end, orderByComparator);
	}

	/**
	* Returns the first standards images in the ordered set where parentImageId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param parentImageId the parent image ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages findByParentImageIdStdIdLocaleCd_First(
		long parentImageId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentImageIdStdIdLocaleCd_First(parentImageId,
			stdId, localeCode, orderByComparator);
	}

	/**
	* Returns the first standards images in the ordered set where parentImageId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param parentImageId the parent image ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards images, or <code>null</code> if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages fetchByParentImageIdStdIdLocaleCd_First(
		long parentImageId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentImageIdStdIdLocaleCd_First(parentImageId,
			stdId, localeCode, orderByComparator);
	}

	/**
	* Returns the last standards images in the ordered set where parentImageId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param parentImageId the parent image ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages findByParentImageIdStdIdLocaleCd_Last(
		long parentImageId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentImageIdStdIdLocaleCd_Last(parentImageId, stdId,
			localeCode, orderByComparator);
	}

	/**
	* Returns the last standards images in the ordered set where parentImageId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param parentImageId the parent image ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards images, or <code>null</code> if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages fetchByParentImageIdStdIdLocaleCd_Last(
		long parentImageId, long stdId, java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentImageIdStdIdLocaleCd_Last(parentImageId,
			stdId, localeCode, orderByComparator);
	}

	/**
	* Returns the standards imageses before and after the current standards images in the ordered set where parentImageId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param stdImageId the primary key of the current standards images
	* @param parentImageId the parent image ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a standards images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages[] findByParentImageIdStdIdLocaleCd_PrevAndNext(
		long stdImageId, long parentImageId, long stdId,
		java.lang.String localeCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentImageIdStdIdLocaleCd_PrevAndNext(stdImageId,
			parentImageId, stdId, localeCode, orderByComparator);
	}

	/**
	* Removes all the standards imageses where parentImageId = &#63; and stdId = &#63; and localeCode = &#63; from the database.
	*
	* @param parentImageId the parent image ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParentImageIdStdIdLocaleCd(long parentImageId,
		long stdId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByParentImageIdStdIdLocaleCd(parentImageId, stdId, localeCode);
	}

	/**
	* Returns the number of standards imageses where parentImageId = &#63; and stdId = &#63; and localeCode = &#63;.
	*
	* @param parentImageId the parent image ID
	* @param stdId the std ID
	* @param localeCode the locale code
	* @return the number of matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParentImageIdStdIdLocaleCd(long parentImageId,
		long stdId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByParentImageIdStdIdLocaleCd(parentImageId, stdId,
			localeCode);
	}

	/**
	* Returns all the standards imageses where parentImageId = &#63;.
	*
	* @param parentImageId the parent image ID
	* @return the matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> findByParentId(
		long parentImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParentId(parentImageId);
	}

	/**
	* Returns a range of all the standards imageses where parentImageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentImageId the parent image ID
	* @param start the lower bound of the range of standards imageses
	* @param end the upper bound of the range of standards imageses (not inclusive)
	* @return the range of matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> findByParentId(
		long parentImageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParentId(parentImageId, start, end);
	}

	/**
	* Returns an ordered range of all the standards imageses where parentImageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentImageId the parent image ID
	* @param start the lower bound of the range of standards imageses
	* @param end the upper bound of the range of standards imageses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> findByParentId(
		long parentImageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentId(parentImageId, start, end, orderByComparator);
	}

	/**
	* Returns the first standards images in the ordered set where parentImageId = &#63;.
	*
	* @param parentImageId the parent image ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages findByParentId_First(
		long parentImageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentId_First(parentImageId, orderByComparator);
	}

	/**
	* Returns the first standards images in the ordered set where parentImageId = &#63;.
	*
	* @param parentImageId the parent image ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards images, or <code>null</code> if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages fetchByParentId_First(
		long parentImageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentId_First(parentImageId, orderByComparator);
	}

	/**
	* Returns the last standards images in the ordered set where parentImageId = &#63;.
	*
	* @param parentImageId the parent image ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages findByParentId_Last(
		long parentImageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentId_Last(parentImageId, orderByComparator);
	}

	/**
	* Returns the last standards images in the ordered set where parentImageId = &#63;.
	*
	* @param parentImageId the parent image ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards images, or <code>null</code> if a matching standards images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages fetchByParentId_Last(
		long parentImageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentId_Last(parentImageId, orderByComparator);
	}

	/**
	* Returns the standards imageses before and after the current standards images in the ordered set where parentImageId = &#63;.
	*
	* @param stdImageId the primary key of the current standards images
	* @param parentImageId the parent image ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a standards images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages[] findByParentId_PrevAndNext(
		long stdImageId, long parentImageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentId_PrevAndNext(stdImageId, parentImageId,
			orderByComparator);
	}

	/**
	* Removes all the standards imageses where parentImageId = &#63; from the database.
	*
	* @param parentImageId the parent image ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParentId(long parentImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParentId(parentImageId);
	}

	/**
	* Returns the number of standards imageses where parentImageId = &#63;.
	*
	* @param parentImageId the parent image ID
	* @return the number of matching standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParentId(long parentImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByParentId(parentImageId);
	}

	/**
	* Caches the standards images in the entity cache if it is enabled.
	*
	* @param standardsImages the standards images
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.StandardsImages standardsImages) {
		getPersistence().cacheResult(standardsImages);
	}

	/**
	* Caches the standards imageses in the entity cache if it is enabled.
	*
	* @param standardsImageses the standards imageses
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.StandardsImages> standardsImageses) {
		getPersistence().cacheResult(standardsImageses);
	}

	/**
	* Creates a new standards images with the primary key. Does not add the standards images to the database.
	*
	* @param stdImageId the primary key for the new standards images
	* @return the new standards images
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages create(
		long stdImageId) {
		return getPersistence().create(stdImageId);
	}

	/**
	* Removes the standards images with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param stdImageId the primary key of the standards images
	* @return the standards images that was removed
	* @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a standards images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages remove(
		long stdImageId)
		throws com.ihg.brandstandards.db.NoSuchStandardsImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(stdImageId);
	}

	public static com.ihg.brandstandards.db.model.StandardsImages updateImpl(
		com.ihg.brandstandards.db.model.StandardsImages standardsImages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(standardsImages);
	}

	/**
	* Returns the standards images with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsImagesException} if it could not be found.
	*
	* @param stdImageId the primary key of the standards images
	* @return the standards images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsImagesException if a standards images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages findByPrimaryKey(
		long stdImageId)
		throws com.ihg.brandstandards.db.NoSuchStandardsImagesException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(stdImageId);
	}

	/**
	* Returns the standards images with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param stdImageId the primary key of the standards images
	* @return the standards images, or <code>null</code> if a standards images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsImages fetchByPrimaryKey(
		long stdImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(stdImageId);
	}

	/**
	* Returns all the standards imageses.
	*
	* @return the standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the standards imageses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards imageses
	* @param end the upper bound of the range of standards imageses (not inclusive)
	* @return the range of standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the standards imageses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards imageses
	* @param end the upper bound of the range of standards imageses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the standards imageses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of standards imageses.
	*
	* @return the number of standards imageses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StandardsImagesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StandardsImagesPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					StandardsImagesPersistence.class.getName());

			ReferenceRegistry.registerReference(StandardsImagesUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(StandardsImagesPersistence persistence) {
	}

	private static StandardsImagesPersistence _persistence;
}