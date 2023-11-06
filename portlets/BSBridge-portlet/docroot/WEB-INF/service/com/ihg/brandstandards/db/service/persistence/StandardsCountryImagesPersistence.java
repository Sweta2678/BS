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

import com.ihg.brandstandards.db.model.StandardsCountryImages;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the standards country images service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsCountryImagesPersistenceImpl
 * @see StandardsCountryImagesUtil
 * @generated
 */
public interface StandardsCountryImagesPersistence extends BasePersistence<StandardsCountryImages> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StandardsCountryImagesUtil} to access the standards country images persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the standards country imageses where stdImageId = &#63;.
	*
	* @param stdImageId the std image ID
	* @return the matching standards country imageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountryImages> findBystdImageId(
		long stdImageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the standards country imageses where stdImageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdImageId the std image ID
	* @param start the lower bound of the range of standards country imageses
	* @param end the upper bound of the range of standards country imageses (not inclusive)
	* @return the range of matching standards country imageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountryImages> findBystdImageId(
		long stdImageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the standards country imageses where stdImageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdImageId the std image ID
	* @param start the lower bound of the range of standards country imageses
	* @param end the upper bound of the range of standards country imageses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standards country imageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountryImages> findBystdImageId(
		long stdImageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standards country images in the ordered set where stdImageId = &#63;.
	*
	* @param stdImageId the std image ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards country images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCountryImagesException if a matching standards country images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCountryImages findBystdImageId_First(
		long stdImageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryImagesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standards country images in the ordered set where stdImageId = &#63;.
	*
	* @param stdImageId the std image ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards country images, or <code>null</code> if a matching standards country images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCountryImages fetchBystdImageId_First(
		long stdImageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standards country images in the ordered set where stdImageId = &#63;.
	*
	* @param stdImageId the std image ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards country images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCountryImagesException if a matching standards country images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCountryImages findBystdImageId_Last(
		long stdImageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryImagesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standards country images in the ordered set where stdImageId = &#63;.
	*
	* @param stdImageId the std image ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards country images, or <code>null</code> if a matching standards country images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCountryImages fetchBystdImageId_Last(
		long stdImageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards country imageses before and after the current standards country images in the ordered set where stdImageId = &#63;.
	*
	* @param standardsCountryImagesPK the primary key of the current standards country images
	* @param stdImageId the std image ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards country images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCountryImagesException if a standards country images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCountryImages[] findBystdImageId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.StandardsCountryImagesPK standardsCountryImagesPK,
		long stdImageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryImagesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standards country imageses where stdImageId = &#63; from the database.
	*
	* @param stdImageId the std image ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBystdImageId(long stdImageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standards country imageses where stdImageId = &#63;.
	*
	* @param stdImageId the std image ID
	* @return the number of matching standards country imageses
	* @throws SystemException if a system exception occurred
	*/
	public int countBystdImageId(long stdImageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the standards country images in the entity cache if it is enabled.
	*
	* @param standardsCountryImages the standards country images
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.StandardsCountryImages standardsCountryImages);

	/**
	* Caches the standards country imageses in the entity cache if it is enabled.
	*
	* @param standardsCountryImageses the standards country imageses
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.StandardsCountryImages> standardsCountryImageses);

	/**
	* Creates a new standards country images with the primary key. Does not add the standards country images to the database.
	*
	* @param standardsCountryImagesPK the primary key for the new standards country images
	* @return the new standards country images
	*/
	public com.ihg.brandstandards.db.model.StandardsCountryImages create(
		com.ihg.brandstandards.db.service.persistence.StandardsCountryImagesPK standardsCountryImagesPK);

	/**
	* Removes the standards country images with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsCountryImagesPK the primary key of the standards country images
	* @return the standards country images that was removed
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCountryImagesException if a standards country images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCountryImages remove(
		com.ihg.brandstandards.db.service.persistence.StandardsCountryImagesPK standardsCountryImagesPK)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryImagesException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.StandardsCountryImages updateImpl(
		com.ihg.brandstandards.db.model.StandardsCountryImages standardsCountryImages)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards country images with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsCountryImagesException} if it could not be found.
	*
	* @param standardsCountryImagesPK the primary key of the standards country images
	* @return the standards country images
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCountryImagesException if a standards country images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCountryImages findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardsCountryImagesPK standardsCountryImagesPK)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryImagesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards country images with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param standardsCountryImagesPK the primary key of the standards country images
	* @return the standards country images, or <code>null</code> if a standards country images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCountryImages fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardsCountryImagesPK standardsCountryImagesPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the standards country imageses.
	*
	* @return the standards country imageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountryImages> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the standards country imageses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards country imageses
	* @param end the upper bound of the range of standards country imageses (not inclusive)
	* @return the range of standards country imageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountryImages> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the standards country imageses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards country imageses
	* @param end the upper bound of the range of standards country imageses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of standards country imageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountryImages> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standards country imageses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standards country imageses.
	*
	* @return the number of standards country imageses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}