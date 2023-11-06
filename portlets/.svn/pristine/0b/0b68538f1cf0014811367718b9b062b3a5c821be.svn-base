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

package com.ihg.grs.common.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FeedbackLocalService}.
 *
 * @author gulam.vora
 * @see FeedbackLocalService
 * @generated
 */
public class FeedbackLocalServiceWrapper implements FeedbackLocalService,
	ServiceWrapper<FeedbackLocalService> {
	public FeedbackLocalServiceWrapper(
		FeedbackLocalService feedbackLocalService) {
		_feedbackLocalService = feedbackLocalService;
	}

	/**
	* Adds the feedback to the database. Also notifies the appropriate model listeners.
	*
	* @param feedback the feedback
	* @return the feedback that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.grs.common.model.Feedback addFeedback(
		com.ihg.grs.common.model.Feedback feedback)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _feedbackLocalService.addFeedback(feedback);
	}

	/**
	* Creates a new feedback with the primary key. Does not add the feedback to the database.
	*
	* @param feedbackId the primary key for the new feedback
	* @return the new feedback
	*/
	@Override
	public com.ihg.grs.common.model.Feedback createFeedback(int feedbackId) {
		return _feedbackLocalService.createFeedback(feedbackId);
	}

	/**
	* Deletes the feedback with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param feedbackId the primary key of the feedback
	* @return the feedback that was removed
	* @throws PortalException if a feedback with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.grs.common.model.Feedback deleteFeedback(int feedbackId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _feedbackLocalService.deleteFeedback(feedbackId);
	}

	/**
	* Deletes the feedback from the database. Also notifies the appropriate model listeners.
	*
	* @param feedback the feedback
	* @return the feedback that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.grs.common.model.Feedback deleteFeedback(
		com.ihg.grs.common.model.Feedback feedback)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _feedbackLocalService.deleteFeedback(feedback);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _feedbackLocalService.dynamicQuery();
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
		return _feedbackLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.grs.common.model.impl.FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _feedbackLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.grs.common.model.impl.FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _feedbackLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _feedbackLocalService.dynamicQueryCount(dynamicQuery);
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
		return _feedbackLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.ihg.grs.common.model.Feedback fetchFeedback(int feedbackId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _feedbackLocalService.fetchFeedback(feedbackId);
	}

	/**
	* Returns the feedback with the primary key.
	*
	* @param feedbackId the primary key of the feedback
	* @return the feedback
	* @throws PortalException if a feedback with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.grs.common.model.Feedback getFeedback(int feedbackId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _feedbackLocalService.getFeedback(feedbackId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _feedbackLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the feedbacks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.grs.common.model.impl.FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of feedbacks
	* @param end the upper bound of the range of feedbacks (not inclusive)
	* @return the range of feedbacks
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.grs.common.model.Feedback> getFeedbacks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _feedbackLocalService.getFeedbacks(start, end);
	}

	/**
	* Returns the number of feedbacks.
	*
	* @return the number of feedbacks
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFeedbacksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _feedbackLocalService.getFeedbacksCount();
	}

	/**
	* Updates the feedback in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param feedback the feedback
	* @return the feedback that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.grs.common.model.Feedback updateFeedback(
		com.ihg.grs.common.model.Feedback feedback)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _feedbackLocalService.updateFeedback(feedback);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _feedbackLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_feedbackLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _feedbackLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void addFeedback(com.ihg.grs.common.model.Feedback feedback,
		java.util.List<com.ihg.grs.common.model.FeedbackDetail> feedbackDetails,
		java.lang.String userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_feedbackLocalService.addFeedback(feedback, feedbackDetails, userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FeedbackLocalService getWrappedFeedbackLocalService() {
		return _feedbackLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFeedbackLocalService(
		FeedbackLocalService feedbackLocalService) {
		_feedbackLocalService = feedbackLocalService;
	}

	@Override
	public FeedbackLocalService getWrappedService() {
		return _feedbackLocalService;
	}

	@Override
	public void setWrappedService(FeedbackLocalService feedbackLocalService) {
		_feedbackLocalService = feedbackLocalService;
	}

	private FeedbackLocalService _feedbackLocalService;
}