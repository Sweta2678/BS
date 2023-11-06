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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Mummanedi
 */
public class DepartmentFinderUtil {
	public static com.ihg.brandstandards.db.model.Department createDepartment()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().createDepartment();
	}

	public static com.ihg.brandstandards.db.model.Department getActiveDepartmentByName(
		java.lang.String deptName, java.lang.String activeInd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getActiveDepartmentByName(deptName, activeInd);
	}

	public static java.util.List<java.lang.Object> getPublicationActiveDepartment(
		long departmentId, java.lang.String activeInd) {
		return getFinder()
				   .getPublicationActiveDepartment(departmentId, activeInd);
	}

	public static DepartmentFinder getFinder() {
		if (_finder == null) {
			_finder = (DepartmentFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					DepartmentFinder.class.getName());

			ReferenceRegistry.registerReference(DepartmentFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(DepartmentFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(DepartmentFinderUtil.class,
			"_finder");
	}

	private static DepartmentFinder _finder;
}