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

package com.ihg.grs.common.service.impl;

import com.ihg.grs.common.model.Feedback;
import com.ihg.grs.common.model.FeedbackDetail;
import com.ihg.grs.common.service.base.FeedbackLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the feedback local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.ihg.grs.common.service.FeedbackLocalService} interface. <p> This
 * is a local service. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM. </p>
 *
 * @author gulam.vora
 * @see com.ihg.grs.common.service.base.FeedbackLocalServiceBaseImpl
 * @see com.ihg.grs.common.service.FeedbackLocalServiceUtil
 */
public class FeedbackLocalServiceImpl extends FeedbackLocalServiceBaseImpl
{

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link com.ihg.grs.common.service.FeedbackLocalServiceUtil} to access the
	 * feedback local service.
	 */

	private Log _log = LogFactoryUtil.getLog(getClass());

	public void addFeedback(Feedback feedback, List<FeedbackDetail> feedbackDetails, String userId)
		throws SystemException
	{
		Date currentDate = new Date();
		feedback.setCreateUserId(userId);
		feedback.setCreatedate(currentDate);
		feedback.setLastUpdateUserId(userId);
		feedback.setUpdatedate(currentDate);
		if (_log.isDebugEnabled())
			_log.debug("Persisting: " + feedback);
		feedback.persist();
		for (FeedbackDetail feedbackDetail : feedbackDetails)
		{
			feedbackDetail.setCreateUserId(userId);
			feedbackDetail.setCreatedate(currentDate);
			feedbackDetail.setLastUpdateUserId(userId);
			feedbackDetail.setUpdatedate(currentDate);
			if (_log.isDebugEnabled())
				_log.debug("Persisting: " + feedbackDetail);
			feedbackDetail.persist();
		}
	}
}
