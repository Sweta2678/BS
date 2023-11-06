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
 * Provides a wrapper for {@link BrandArticleLocalService}.
 *
 * @author Mummanedi
 * @see BrandArticleLocalService
 * @generated
 */
public class BrandArticleLocalServiceWrapper implements BrandArticleLocalService,
	ServiceWrapper<BrandArticleLocalService> {
	public BrandArticleLocalServiceWrapper(
		BrandArticleLocalService brandArticleLocalService) {
		_brandArticleLocalService = brandArticleLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _brandArticleLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_brandArticleLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _brandArticleLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List getJournalArticleResourcPrimKey(
		java.lang.String query) {
		return _brandArticleLocalService.getJournalArticleResourcPrimKey(query);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BrandArticleLocalService getWrappedBrandArticleLocalService() {
		return _brandArticleLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBrandArticleLocalService(
		BrandArticleLocalService brandArticleLocalService) {
		_brandArticleLocalService = brandArticleLocalService;
	}

	@Override
	public BrandArticleLocalService getWrappedService() {
		return _brandArticleLocalService;
	}

	@Override
	public void setWrappedService(
		BrandArticleLocalService brandArticleLocalService) {
		_brandArticleLocalService = brandArticleLocalService;
	}

	private BrandArticleLocalService _brandArticleLocalService;
}