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

import com.ihg.grs.common.model.Feedback;
import com.ihg.grs.common.service.FeedbackLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author gulam.vora
 * @generated
 */
public abstract class FeedbackActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public FeedbackActionableDynamicQuery() throws SystemException {
		setBaseLocalService(FeedbackLocalServiceUtil.getService());
		setClass(Feedback.class);

		setClassLoader(com.ihg.grs.common.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("feedbackId");
	}
}