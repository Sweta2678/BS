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

package com.ihg.brandstandards.db.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TreeXMLLocalService}.
 *
 * @author Mummanedi
 * @see TreeXMLLocalService
 * @generated
 */
public class TreeXMLLocalServiceWrapper implements TreeXMLLocalService,
	ServiceWrapper<TreeXMLLocalService> {
	public TreeXMLLocalServiceWrapper(TreeXMLLocalService treeXMLLocalService) {
		_treeXMLLocalService = treeXMLLocalService;
	}

	/**
	* Adds the tree x m l to the database. Also notifies the appropriate model listeners.
	*
	* @param treeXML the tree x m l
	* @return the tree x m l that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.TreeXML addTreeXML(
		com.ihg.brandstandards.db.model.TreeXML treeXML)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _treeXMLLocalService.addTreeXML(treeXML);
	}

	/**
	* Creates a new tree x m l with the primary key. Does not add the tree x m l to the database.
	*
	* @param ID the primary key for the new tree x m l
	* @return the new tree x m l
	*/
	@Override
	public com.ihg.brandstandards.db.model.TreeXML createTreeXML(long ID) {
		return _treeXMLLocalService.createTreeXML(ID);
	}

	/**
	* Deletes the tree x m l with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the tree x m l
	* @return the tree x m l that was removed
	* @throws PortalException if a tree x m l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.TreeXML deleteTreeXML(long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _treeXMLLocalService.deleteTreeXML(ID);
	}

	/**
	* Deletes the tree x m l from the database. Also notifies the appropriate model listeners.
	*
	* @param treeXML the tree x m l
	* @return the tree x m l that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.TreeXML deleteTreeXML(
		com.ihg.brandstandards.db.model.TreeXML treeXML)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _treeXMLLocalService.deleteTreeXML(treeXML);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _treeXMLLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _treeXMLLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TreeXMLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _treeXMLLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TreeXMLModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _treeXMLLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _treeXMLLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _treeXMLLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.TreeXML fetchTreeXML(long ID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _treeXMLLocalService.fetchTreeXML(ID);
	}

	/**
	* Returns the tree x m l with the primary key.
	*
	* @param ID the primary key of the tree x m l
	* @return the tree x m l
	* @throws PortalException if a tree x m l with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.TreeXML getTreeXML(long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _treeXMLLocalService.getTreeXML(ID);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _treeXMLLocalService.getPersistedModel(primaryKeyObj);
	}

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
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.TreeXML> getTreeXMLs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _treeXMLLocalService.getTreeXMLs(start, end);
	}

	/**
	* Returns the number of tree x m ls.
	*
	* @return the number of tree x m ls
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTreeXMLsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _treeXMLLocalService.getTreeXMLsCount();
	}

	/**
	* Updates the tree x m l in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param treeXML the tree x m l
	* @return the tree x m l that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.TreeXML updateTreeXML(
		com.ihg.brandstandards.db.model.TreeXML treeXML)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _treeXMLLocalService.updateTreeXML(treeXML);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _treeXMLLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_treeXMLLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _treeXMLLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public void clearCache() {
		_treeXMLLocalService.clearCache();
	}

	@Override
	public java.lang.String insertAdminTaxonomy(java.lang.Long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _treeXMLLocalService.insertAdminTaxonomy(id);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TreeXMLLocalService getWrappedTreeXMLLocalService() {
		return _treeXMLLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTreeXMLLocalService(
		TreeXMLLocalService treeXMLLocalService) {
		_treeXMLLocalService = treeXMLLocalService;
	}

	@Override
	public TreeXMLLocalService getWrappedService() {
		return _treeXMLLocalService;
	}

	@Override
	public void setWrappedService(TreeXMLLocalService treeXMLLocalService) {
		_treeXMLLocalService = treeXMLLocalService;
	}

	private TreeXMLLocalService _treeXMLLocalService;
}