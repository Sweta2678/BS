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

import com.ihg.brandstandards.db.model.Workflow;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the workflow service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see WorkflowPersistenceImpl
 * @see WorkflowUtil
 * @generated
 */
public interface WorkflowPersistence extends BasePersistence<Workflow> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkflowUtil} to access the workflow persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the workflow in the entity cache if it is enabled.
	*
	* @param workflow the workflow
	*/
	public void cacheResult(com.ihg.brandstandards.db.model.Workflow workflow);

	/**
	* Caches the workflows in the entity cache if it is enabled.
	*
	* @param workflows the workflows
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.Workflow> workflows);

	/**
	* Creates a new workflow with the primary key. Does not add the workflow to the database.
	*
	* @param workflowActvtId the primary key for the new workflow
	* @return the new workflow
	*/
	public com.ihg.brandstandards.db.model.Workflow create(long workflowActvtId);

	/**
	* Removes the workflow with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workflowActvtId the primary key of the workflow
	* @return the workflow that was removed
	* @throws com.ihg.brandstandards.db.NoSuchWorkflowException if a workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Workflow remove(long workflowActvtId)
		throws com.ihg.brandstandards.db.NoSuchWorkflowException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.Workflow updateImpl(
		com.ihg.brandstandards.db.model.Workflow workflow)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the workflow with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchWorkflowException} if it could not be found.
	*
	* @param workflowActvtId the primary key of the workflow
	* @return the workflow
	* @throws com.ihg.brandstandards.db.NoSuchWorkflowException if a workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Workflow findByPrimaryKey(
		long workflowActvtId)
		throws com.ihg.brandstandards.db.NoSuchWorkflowException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the workflow with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param workflowActvtId the primary key of the workflow
	* @return the workflow, or <code>null</code> if a workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.Workflow fetchByPrimaryKey(
		long workflowActvtId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the workflows.
	*
	* @return the workflows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Workflow> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the workflows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of workflows
	* @param end the upper bound of the range of workflows (not inclusive)
	* @return the range of workflows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Workflow> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the workflows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of workflows
	* @param end the upper bound of the range of workflows (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of workflows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.Workflow> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the workflows from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of workflows.
	*
	* @return the number of workflows
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}