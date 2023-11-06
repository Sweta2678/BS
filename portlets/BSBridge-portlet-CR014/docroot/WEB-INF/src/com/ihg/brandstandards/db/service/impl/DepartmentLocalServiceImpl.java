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

package com.ihg.brandstandards.db.service.impl;

import com.ihg.brandstandards.db.model.Department;
import com.ihg.brandstandards.db.service.base.DepartmentLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

/**
 * The implementation of the department local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.DepartmentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.DepartmentLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.DepartmentLocalServiceUtil
 */
public class DepartmentLocalServiceImpl extends DepartmentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.DepartmentLocalServiceUtil} to access the department local service.
	 */
	
	/**
	 * @param activeInd
	 * @return List<Department>
	 * @throws SystemException
	 */
	public List<Department> getActiveDepartments (String activeInd) throws SystemException {
		return departmentPersistence.findByActiveIndicator(activeInd);
	}
	
	public List<Department> getActiveDepartments (String activeInd,int start, int end,OrderByComparator orderByComparator) throws SystemException {
		return departmentPersistence.findByActiveIndicator(activeInd, start, end, orderByComparator);
	}
	
	public Department createDepartment() throws SystemException {
		return departmentFinder.createDepartment();
	}
	
	public List<Object> getPublicationActiveDepartment(long departmentId, String activeInd){
		return departmentFinder.getPublicationActiveDepartment(departmentId, activeInd);
	}
	  
	public Department getActiveDepartmentByName(String deptName, String activeInd) throws SystemException {
		return departmentFinder.getActiveDepartmentByName(deptName, activeInd);
	}
}