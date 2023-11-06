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

import com.ihg.grs.common.model.FeedbackDetail;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the feedback detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gulam.vora
 * @see FeedbackDetailPersistenceImpl
 * @see FeedbackDetailUtil
 * @generated
 */
public interface FeedbackDetailPersistence extends BasePersistence<FeedbackDetail> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FeedbackDetailUtil} to access the feedback detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the feedback detail in the entity cache if it is enabled.
	*
	* @param feedbackDetail the feedback detail
	*/
	public void cacheResult(
		com.ihg.grs.common.model.FeedbackDetail feedbackDetail);

	/**
	* Caches the feedback details in the entity cache if it is enabled.
	*
	* @param feedbackDetails the feedback details
	*/
	public void cacheResult(
		java.util.List<com.ihg.grs.common.model.FeedbackDetail> feedbackDetails);

	/**
	* Creates a new feedback detail with the primary key. Does not add the feedback detail to the database.
	*
	* @param PORTAL_FEEDBACK_DTL_ID the primary key for the new feedback detail
	* @return the new feedback detail
	*/
	public com.ihg.grs.common.model.FeedbackDetail create(
		int PORTAL_FEEDBACK_DTL_ID);

	/**
	* Removes the feedback detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PORTAL_FEEDBACK_DTL_ID the primary key of the feedback detail
	* @return the feedback detail that was removed
	* @throws com.ihg.grs.common.NoSuchFeedbackDetailException if a feedback detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.grs.common.model.FeedbackDetail remove(
		int PORTAL_FEEDBACK_DTL_ID)
		throws com.ihg.grs.common.NoSuchFeedbackDetailException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.grs.common.model.FeedbackDetail updateImpl(
		com.ihg.grs.common.model.FeedbackDetail feedbackDetail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the feedback detail with the primary key or throws a {@link com.ihg.grs.common.NoSuchFeedbackDetailException} if it could not be found.
	*
	* @param PORTAL_FEEDBACK_DTL_ID the primary key of the feedback detail
	* @return the feedback detail
	* @throws com.ihg.grs.common.NoSuchFeedbackDetailException if a feedback detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.grs.common.model.FeedbackDetail findByPrimaryKey(
		int PORTAL_FEEDBACK_DTL_ID)
		throws com.ihg.grs.common.NoSuchFeedbackDetailException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the feedback detail with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param PORTAL_FEEDBACK_DTL_ID the primary key of the feedback detail
	* @return the feedback detail, or <code>null</code> if a feedback detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.grs.common.model.FeedbackDetail fetchByPrimaryKey(
		int PORTAL_FEEDBACK_DTL_ID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the feedback details.
	*
	* @return the feedback details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.grs.common.model.FeedbackDetail> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the feedback details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.grs.common.model.impl.FeedbackDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of feedback details
	* @param end the upper bound of the range of feedback details (not inclusive)
	* @return the range of feedback details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.grs.common.model.FeedbackDetail> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the feedback details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.grs.common.model.impl.FeedbackDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of feedback details
	* @param end the upper bound of the range of feedback details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of feedback details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.grs.common.model.FeedbackDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the feedback details from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of feedback details.
	*
	* @return the number of feedback details
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}