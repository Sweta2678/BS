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

import com.ihg.brandstandards.db.model.GlossaryExt;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the glossary ext service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GlossaryExtPersistenceImpl
 * @see GlossaryExtUtil
 * @generated
 */
public interface GlossaryExtPersistence extends BasePersistence<GlossaryExt> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GlossaryExtUtil} to access the glossary ext persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the glossary ext in the entity cache if it is enabled.
	*
	* @param glossaryExt the glossary ext
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.GlossaryExt glossaryExt);

	/**
	* Caches the glossary exts in the entity cache if it is enabled.
	*
	* @param glossaryExts the glossary exts
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GlossaryExt> glossaryExts);

	/**
	* Creates a new glossary ext with the primary key. Does not add the glossary ext to the database.
	*
	* @param glossaryId the primary key for the new glossary ext
	* @return the new glossary ext
	*/
	public com.ihg.brandstandards.db.model.GlossaryExt create(long glossaryId);

	/**
	* Removes the glossary ext with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param glossaryId the primary key of the glossary ext
	* @return the glossary ext that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryExtException if a glossary ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GlossaryExt remove(long glossaryId)
		throws com.ihg.brandstandards.db.NoSuchGlossaryExtException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.GlossaryExt updateImpl(
		com.ihg.brandstandards.db.model.GlossaryExt glossaryExt)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the glossary ext with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGlossaryExtException} if it could not be found.
	*
	* @param glossaryId the primary key of the glossary ext
	* @return the glossary ext
	* @throws com.ihg.brandstandards.db.NoSuchGlossaryExtException if a glossary ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GlossaryExt findByPrimaryKey(
		long glossaryId)
		throws com.ihg.brandstandards.db.NoSuchGlossaryExtException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the glossary ext with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param glossaryId the primary key of the glossary ext
	* @return the glossary ext, or <code>null</code> if a glossary ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GlossaryExt fetchByPrimaryKey(
		long glossaryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the glossary exts.
	*
	* @return the glossary exts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GlossaryExt> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the glossary exts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of glossary exts
	* @param end the upper bound of the range of glossary exts (not inclusive)
	* @return the range of glossary exts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GlossaryExt> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the glossary exts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of glossary exts
	* @param end the upper bound of the range of glossary exts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of glossary exts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GlossaryExt> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the glossary exts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of glossary exts.
	*
	* @return the number of glossary exts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}