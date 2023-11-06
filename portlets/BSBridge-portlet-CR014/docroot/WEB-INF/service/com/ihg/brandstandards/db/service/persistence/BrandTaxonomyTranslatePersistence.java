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

import com.ihg.brandstandards.db.model.BrandTaxonomyTranslate;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the brand taxonomy translate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BrandTaxonomyTranslatePersistenceImpl
 * @see BrandTaxonomyTranslateUtil
 * @generated
 */
public interface BrandTaxonomyTranslatePersistence extends BasePersistence<BrandTaxonomyTranslate> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BrandTaxonomyTranslateUtil} to access the brand taxonomy translate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the brand taxonomy translate in the entity cache if it is enabled.
	*
	* @param brandTaxonomyTranslate the brand taxonomy translate
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.BrandTaxonomyTranslate brandTaxonomyTranslate);

	/**
	* Caches the brand taxonomy translates in the entity cache if it is enabled.
	*
	* @param brandTaxonomyTranslates the brand taxonomy translates
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomyTranslate> brandTaxonomyTranslates);

	/**
	* Creates a new brand taxonomy translate with the primary key. Does not add the brand taxonomy translate to the database.
	*
	* @param brandTaxonomyTranslatePK the primary key for the new brand taxonomy translate
	* @return the new brand taxonomy translate
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomyTranslate create(
		com.ihg.brandstandards.db.service.persistence.BrandTaxonomyTranslatePK brandTaxonomyTranslatePK);

	/**
	* Removes the brand taxonomy translate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param brandTaxonomyTranslatePK the primary key of the brand taxonomy translate
	* @return the brand taxonomy translate that was removed
	* @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyTranslateException if a brand taxonomy translate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomyTranslate remove(
		com.ihg.brandstandards.db.service.persistence.BrandTaxonomyTranslatePK brandTaxonomyTranslatePK)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyTranslateException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.BrandTaxonomyTranslate updateImpl(
		com.ihg.brandstandards.db.model.BrandTaxonomyTranslate brandTaxonomyTranslate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the brand taxonomy translate with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBrandTaxonomyTranslateException} if it could not be found.
	*
	* @param brandTaxonomyTranslatePK the primary key of the brand taxonomy translate
	* @return the brand taxonomy translate
	* @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyTranslateException if a brand taxonomy translate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomyTranslate findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.BrandTaxonomyTranslatePK brandTaxonomyTranslatePK)
		throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyTranslateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the brand taxonomy translate with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param brandTaxonomyTranslatePK the primary key of the brand taxonomy translate
	* @return the brand taxonomy translate, or <code>null</code> if a brand taxonomy translate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BrandTaxonomyTranslate fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.BrandTaxonomyTranslatePK brandTaxonomyTranslatePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the brand taxonomy translates.
	*
	* @return the brand taxonomy translates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomyTranslate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the brand taxonomy translates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BrandTaxonomyTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of brand taxonomy translates
	* @param end the upper bound of the range of brand taxonomy translates (not inclusive)
	* @return the range of brand taxonomy translates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomyTranslate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the brand taxonomy translates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BrandTaxonomyTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of brand taxonomy translates
	* @param end the upper bound of the range of brand taxonomy translates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of brand taxonomy translates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BrandTaxonomyTranslate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the brand taxonomy translates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of brand taxonomy translates.
	*
	* @return the number of brand taxonomy translates
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}