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
 * Provides a wrapper for {@link WorkflowLocalService}.
 *
 * @author Mummanedi
 * @see WorkflowLocalService
 * @generated
 */
public class WorkflowLocalServiceWrapper implements WorkflowLocalService,
	ServiceWrapper<WorkflowLocalService> {
	public WorkflowLocalServiceWrapper(
		WorkflowLocalService workflowLocalService) {
		_workflowLocalService = workflowLocalService;
	}

	/**
	* Adds the workflow to the database. Also notifies the appropriate model listeners.
	*
	* @param workflow the workflow
	* @return the workflow that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.Workflow addWorkflow(
		com.ihg.brandstandards.db.model.Workflow workflow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowLocalService.addWorkflow(workflow);
	}

	/**
	* Creates a new workflow with the primary key. Does not add the workflow to the database.
	*
	* @param workflowActvtId the primary key for the new workflow
	* @return the new workflow
	*/
	@Override
	public com.ihg.brandstandards.db.model.Workflow createWorkflow(
		long workflowActvtId) {
		return _workflowLocalService.createWorkflow(workflowActvtId);
	}

	/**
	* Deletes the workflow with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workflowActvtId the primary key of the workflow
	* @return the workflow that was removed
	* @throws PortalException if a workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.Workflow deleteWorkflow(
		long workflowActvtId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workflowLocalService.deleteWorkflow(workflowActvtId);
	}

	/**
	* Deletes the workflow from the database. Also notifies the appropriate model listeners.
	*
	* @param workflow the workflow
	* @return the workflow that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.Workflow deleteWorkflow(
		com.ihg.brandstandards.db.model.Workflow workflow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowLocalService.deleteWorkflow(workflow);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _workflowLocalService.dynamicQuery();
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
		return _workflowLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _workflowLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _workflowLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _workflowLocalService.dynamicQueryCount(dynamicQuery);
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
		return _workflowLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.Workflow fetchWorkflow(
		long workflowActvtId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowLocalService.fetchWorkflow(workflowActvtId);
	}

	/**
	* Returns the workflow with the primary key.
	*
	* @param workflowActvtId the primary key of the workflow
	* @return the workflow
	* @throws PortalException if a workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.Workflow getWorkflow(
		long workflowActvtId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workflowLocalService.getWorkflow(workflowActvtId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workflowLocalService.getPersistedModel(primaryKeyObj);
	}

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
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Workflow> getWorkflows(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowLocalService.getWorkflows(start, end);
	}

	/**
	* Returns the number of workflows.
	*
	* @return the number of workflows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getWorkflowsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowLocalService.getWorkflowsCount();
	}

	/**
	* Updates the workflow in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param workflow the workflow
	* @return the workflow that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.Workflow updateWorkflow(
		com.ihg.brandstandards.db.model.Workflow workflow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowLocalService.updateWorkflow(workflow);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _workflowLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_workflowLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _workflowLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void clearCache() {
		_workflowLocalService.clearCache();
	}

	@Override
	public com.ihg.brandstandards.db.model.Workflow getWorkflowObject() {
		return _workflowLocalService.getWorkflowObject();
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Workflow> getLogByObjectId(
		long objectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowLocalService.getLogByObjectId(objectId);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Workflow> getLogBySTDObjectId(
		long objectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowLocalService.getLogBySTDObjectId(objectId);
	}

	/**
	* Fetch last audit log entry.
	*
	* @param stdId standard id
	* @return Workflow
	*/
	@Override
	public com.ihg.brandstandards.db.model.Workflow getLastLogBySTDObjectId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowLocalService.getLastLogBySTDObjectId(stdId);
	}

	/**
	* Fetch last audit log entry.
	*
	* @param stdId standard id
	* @param brandCd Brand
	* @return Workflow
	*/
	@Override
	public com.ihg.brandstandards.db.model.Workflow getLastLogBySTDObjectId(
		long stdId, java.lang.String brandCd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowLocalService.getLastLogBySTDObjectId(stdId, brandCd);
	}

	/**
	* Fetch last audit log entry.
	*
	* @param stdId standard id
	* @param brandCd Brand
	* @return Workflow
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.Workflow> getLastLogByStdIdBrand(
		long stdId, java.util.Collection<java.lang.Object> brandCd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowLocalService.getLastLogByStdIdBrand(stdId, brandCd);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public WorkflowLocalService getWrappedWorkflowLocalService() {
		return _workflowLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedWorkflowLocalService(
		WorkflowLocalService workflowLocalService) {
		_workflowLocalService = workflowLocalService;
	}

	@Override
	public WorkflowLocalService getWrappedService() {
		return _workflowLocalService;
	}

	@Override
	public void setWrappedService(WorkflowLocalService workflowLocalService) {
		_workflowLocalService = workflowLocalService;
	}

	private WorkflowLocalService _workflowLocalService;
}