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

package com.ihg.grs.common.service.persistence;

import com.ihg.grs.common.model.Glossary;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the glossary service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gulam.vora
 * @see GlossaryPersistenceImpl
 * @see GlossaryUtil
 * @generated
 */
public interface GlossaryPersistence extends BasePersistence<Glossary> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GlossaryUtil} to access the glossary persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the glossary in the entity cache if it is enabled.
	*
	* @param glossary the glossary
	*/
	public void cacheResult(com.ihg.grs.common.model.Glossary glossary);

	/**
	* Caches the glossaries in the entity cache if it is enabled.
	*
	* @param glossaries the glossaries
	*/
	public void cacheResult(
		java.util.List<com.ihg.grs.common.model.Glossary> glossaries);

	/**
	* Creates a new glossary with the primary key. Does not add the glossary to the database.
	*
	* @param glossaryId the primary key for the new glossary
	* @return the new glossary
	*/
	public com.ihg.grs.common.model.Glossary create(int glossaryId);

	/**
	* Removes the glossary with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param glossaryId the primary key of the glossary
	* @return the glossary that was removed
	* @throws com.ihg.grs.common.NoSuchGlossaryException if a glossary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.grs.common.model.Glossary remove(int glossaryId)
		throws com.ihg.grs.common.NoSuchGlossaryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.grs.common.model.Glossary updateImpl(
		com.ihg.grs.common.model.Glossary glossary)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the glossary with the primary key or throws a {@link com.ihg.grs.common.NoSuchGlossaryException} if it could not be found.
	*
	* @param glossaryId the primary key of the glossary
	* @return the glossary
	* @throws com.ihg.grs.common.NoSuchGlossaryException if a glossary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.grs.common.model.Glossary findByPrimaryKey(int glossaryId)
		throws com.ihg.grs.common.NoSuchGlossaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the glossary with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param glossaryId the primary key of the glossary
	* @return the glossary, or <code>null</code> if a glossary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.grs.common.model.Glossary fetchByPrimaryKey(int glossaryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the glossaries.
	*
	* @return the glossaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.grs.common.model.Glossary> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the glossaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.grs.common.model.impl.GlossaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of glossaries
	* @param end the upper bound of the range of glossaries (not inclusive)
	* @return the range of glossaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.grs.common.model.Glossary> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the glossaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.grs.common.model.impl.GlossaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of glossaries
	* @param end the upper bound of the range of glossaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of glossaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.grs.common.model.Glossary> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the glossaries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of glossaries.
	*
	* @return the number of glossaries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}