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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for FeedbackDetail. This utility wraps
 * {@link com.ihg.grs.common.service.impl.FeedbackDetailLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author gulam.vora
 * @see FeedbackDetailLocalService
 * @see com.ihg.grs.common.service.base.FeedbackDetailLocalServiceBaseImpl
 * @see com.ihg.grs.common.service.impl.FeedbackDetailLocalServiceImpl
 * @generated
 */
public class FeedbackDetailLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.grs.common.service.impl.FeedbackDetailLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the feedback detail to the database. Also notifies the appropriate model listeners.
	*
	* @param feedbackDetail the feedback detail
	* @return the feedback detail that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.grs.common.model.FeedbackDetail addFeedbackDetail(
		com.ihg.grs.common.model.FeedbackDetail feedbackDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addFeedbackDetail(feedbackDetail);
	}

	/**
	* Creates a new feedback detail with the primary key. Does not add the feedback detail to the database.
	*
	* @param PORTAL_FEEDBACK_DTL_ID the primary key for the new feedback detail
	* @return the new feedback detail
	*/
	public static com.ihg.grs.common.model.FeedbackDetail createFeedbackDetail(
		int PORTAL_FEEDBACK_DTL_ID) {
		return getService().createFeedbackDetail(PORTAL_FEEDBACK_DTL_ID);
	}

	/**
	* Deletes the feedback detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param PORTAL_FEEDBACK_DTL_ID the primary key of the feedback detail
	* @return the feedback detail that was removed
	* @throws PortalException if a feedback detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.grs.common.model.FeedbackDetail deleteFeedbackDetail(
		int PORTAL_FEEDBACK_DTL_ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFeedbackDetail(PORTAL_FEEDBACK_DTL_ID);
	}

	/**
	* Deletes the feedback detail from the database. Also notifies the appropriate model listeners.
	*
	* @param feedbackDetail the feedback detail
	* @return the feedback detail that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.grs.common.model.FeedbackDetail deleteFeedbackDetail(
		com.ihg.grs.common.model.FeedbackDetail feedbackDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFeedbackDetail(feedbackDetail);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.grs.common.model.impl.FeedbackDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.grs.common.model.impl.FeedbackDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.ihg.grs.common.model.FeedbackDetail fetchFeedbackDetail(
		int PORTAL_FEEDBACK_DTL_ID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchFeedbackDetail(PORTAL_FEEDBACK_DTL_ID);
	}

	/**
	* Returns the feedback detail with the primary key.
	*
	* @param PORTAL_FEEDBACK_DTL_ID the primary key of the feedback detail
	* @return the feedback detail
	* @throws PortalException if a feedback detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.grs.common.model.FeedbackDetail getFeedbackDetail(
		int PORTAL_FEEDBACK_DTL_ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getFeedbackDetail(PORTAL_FEEDBACK_DTL_ID);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

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
	public static java.util.List<com.ihg.grs.common.model.FeedbackDetail> getFeedbackDetails(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFeedbackDetails(start, end);
	}

	/**
	* Returns the number of feedback details.
	*
	* @return the number of feedback details
	* @throws SystemException if a system exception occurred
	*/
	public static int getFeedbackDetailsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFeedbackDetailsCount();
	}

	/**
	* Updates the feedback detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param feedbackDetail the feedback detail
	* @return the feedback detail that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.grs.common.model.FeedbackDetail updateFeedbackDetail(
		com.ihg.grs.common.model.FeedbackDetail feedbackDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateFeedbackDetail(feedbackDetail);
	}

	public static com.ihg.grs.common.model.FeedbackDetailFileContentBlobModel getFileContentBlobModel(
		java.io.Serializable primaryKey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFileContentBlobModel(primaryKey);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearService() {
		_service = null;
	}

	public static FeedbackDetailLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FeedbackDetailLocalService.class.getName());

			if (invokableLocalService instanceof FeedbackDetailLocalService) {
				_service = (FeedbackDetailLocalService)invokableLocalService;
			}
			else {
				_service = new FeedbackDetailLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(FeedbackDetailLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(FeedbackDetailLocalService service) {
	}

	private static FeedbackDetailLocalService _service;
}