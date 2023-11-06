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

import com.ihg.brandstandards.db.model.Image;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see ImagePersistenceImpl
 * @see ImageUtil
 * @generated
 */
public interface ImagePersistence extends BasePersistence<Image> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ImageUtil} to access the image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the image in the entity cache if it is enabled.
	*
	* @param image the image
	*/
	public void cacheResult(com.ihg.brandstandards.db.model.Image image);

	/**
	* Caches the images in the entity cache if it is enabled.
	*
	* @param images the images
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.Image> images);

	/**
	* Creates a new image with the primary key. Does not add the image to the database.
	*
	* @param imageId the primary key for the new image
	* @return the new image
	*/
	public com.ihg.brandstandards.db.model.Image create(long imageId);

	/**
	* Removes the image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param imageId the primary key of the image
	* @return the image that was removed
	* @throws com.ihg.brandstandards.db.NoSuchImageException if a image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Image remove(long imageId)
		throws com.ihg.brandstandards.db.NoSuchImageException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.Image updateImpl(
		com.ihg.brandstandards.db.model.Image image)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the image with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchImageException} if it could not be found.
	*
	* @param imageId the primary key of the image
	* @return the image
	* @throws com.ihg.brandstandards.db.NoSuchImageException if a image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Image findByPrimaryKey(long imageId)
		throws com.ihg.brandstandards.db.NoSuchImageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the image with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param imageId the primary key of the image
	* @return the image, or <code>null</code> if a image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Image fetchByPrimaryKey(long imageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the images.
	*
	* @return the images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Image> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of images
	* @param end the upper bound of the range of images (not inclusive)
	* @return the range of images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Image> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of images
	* @param end the upper bound of the range of images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Image> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the images from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of images.
	*
	* @return the number of images
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}