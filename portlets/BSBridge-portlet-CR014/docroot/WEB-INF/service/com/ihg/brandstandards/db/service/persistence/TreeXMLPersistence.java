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

import com.ihg.brandstandards.db.model.TreeXML;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the tree x m l service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see TreeXMLPersistenceImpl
 * @see TreeXMLUtil
 * @generated
 */
public interface TreeXMLPersistence extends BasePersistence<TreeXML> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TreeXMLUtil} to access the tree x m l persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the tree x m l in the entity cache if it is enabled.
	*
	* @param treeXML the tree x m l
	*/
	public void cacheResult(com.ihg.brandstandards.db.model.TreeXML treeXML);

	/**
	* Caches the tree x m ls in the entity cache if it is enabled.
	*
	* @param treeXMLs the tree x m ls
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.TreeXML> treeXMLs);

	/**
	* Creates a new tree x m l with the primary key. Does not add the tree x m l to the database.
	*
	* @param ID the primary key for the new tree x m l
	* @return the new tree x m l
	*/
	public com.ihg.brandstandards.db.model.TreeXML create(long ID);

	/**
	* Removes the tree x m l with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the tree x m l
	* @return the tree x m l that was removed
	* @throws com.ihg.brandstandards.db.NoSuchTreeXMLException if a tree x m l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.TreeXML remove(long ID)
		throws com.ihg.brandstandards.db.NoSuchTreeXMLException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.TreeXML updateImpl(
		com.ihg.brandstandards.db.model.TreeXML treeXML)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tree x m l with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchTreeXMLException} if it could not be found.
	*
	* @param ID the primary key of the tree x m l
	* @return the tree x m l
	* @throws com.ihg.brandstandards.db.NoSuchTreeXMLException if a tree x m l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.TreeXML findByPrimaryKey(long ID)
		throws com.ihg.brandstandards.db.NoSuchTreeXMLException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tree x m l with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the tree x m l
	* @return the tree x m l, or <code>null</code> if a tree x m l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.TreeXML fetchByPrimaryKey(long ID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tree x m ls.
	*
	* @return the tree x m ls
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.TreeXML> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tree x m ls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TreeXMLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tree x m ls
	* @param end the upper bound of the range of tree x m ls (not inclusive)
	* @return the range of tree x m ls
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.TreeXML> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tree x m ls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TreeXMLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tree x m ls
	* @param end the upper bound of the range of tree x m ls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tree x m ls
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.TreeXML> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tree x m ls from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tree x m ls.
	*
	* @return the number of tree x m ls
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}