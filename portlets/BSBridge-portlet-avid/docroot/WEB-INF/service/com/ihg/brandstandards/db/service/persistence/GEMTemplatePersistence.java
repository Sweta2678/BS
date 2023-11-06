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

import com.ihg.brandstandards.db.model.GEMTemplate;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the g e m template service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMTemplatePersistenceImpl
 * @see GEMTemplateUtil
 * @generated
 */
public interface GEMTemplatePersistence extends BasePersistence<GEMTemplate> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GEMTemplateUtil} to access the g e m template persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the g e m templates where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @return the matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByPublishId(
		long publishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the g e m templates where publishId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param start the lower bound of the range of g e m templates
	* @param end the upper bound of the range of g e m templates (not inclusive)
	* @return the range of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByPublishId(
		long publishId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the g e m templates where publishId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param start the lower bound of the range of g e m templates
	* @param end the upper bound of the range of g e m templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByPublishId(
		long publishId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g e m template in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate findByPublishId_First(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g e m template in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template, or <code>null</code> if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate fetchByPublishId_First(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g e m template in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate findByPublishId_Last(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g e m template in the ordered set where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template, or <code>null</code> if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate fetchByPublishId_Last(
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m templates before and after the current g e m template in the ordered set where publishId = &#63;.
	*
	* @param templateId the primary key of the current g e m template
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a g e m template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate[] findByPublishId_PrevAndNext(
		long templateId, long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the g e m templates where publishId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPublishId(long publishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m templates where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @return the number of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public int countByPublishId(long publishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the g e m templates where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @return the matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByPublishIdAndRgnId(
		long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the g e m templates where publishId = &#63; and regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param start the lower bound of the range of g e m templates
	* @param end the upper bound of the range of g e m templates (not inclusive)
	* @return the range of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByPublishIdAndRgnId(
		long publishId, long regionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the g e m templates where publishId = &#63; and regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param start the lower bound of the range of g e m templates
	* @param end the upper bound of the range of g e m templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByPublishIdAndRgnId(
		long publishId, long regionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g e m template in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate findByPublishIdAndRgnId_First(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g e m template in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template, or <code>null</code> if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate fetchByPublishIdAndRgnId_First(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g e m template in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate findByPublishIdAndRgnId_Last(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g e m template in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template, or <code>null</code> if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate fetchByPublishIdAndRgnId_Last(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m templates before and after the current g e m template in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param templateId the primary key of the current g e m template
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a g e m template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate[] findByPublishIdAndRgnId_PrevAndNext(
		long templateId, long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the g e m templates where publishId = &#63; and regionId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPublishIdAndRgnId(long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m templates where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @return the number of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public int countByPublishIdAndRgnId(long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the g e m templates where publishId = &#63; and regionId = &#63; and templateType = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param templateType the template type
	* @return the matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByPublishIdAndRgnIdAndType(
		long publishId, long regionId, java.lang.String templateType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the g e m templates where publishId = &#63; and regionId = &#63; and templateType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param templateType the template type
	* @param start the lower bound of the range of g e m templates
	* @param end the upper bound of the range of g e m templates (not inclusive)
	* @return the range of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByPublishIdAndRgnIdAndType(
		long publishId, long regionId, java.lang.String templateType,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the g e m templates where publishId = &#63; and regionId = &#63; and templateType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param templateType the template type
	* @param start the lower bound of the range of g e m templates
	* @param end the upper bound of the range of g e m templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByPublishIdAndRgnIdAndType(
		long publishId, long regionId, java.lang.String templateType,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g e m template in the ordered set where publishId = &#63; and regionId = &#63; and templateType = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate findByPublishIdAndRgnIdAndType_First(
		long publishId, long regionId, java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g e m template in the ordered set where publishId = &#63; and regionId = &#63; and templateType = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template, or <code>null</code> if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate fetchByPublishIdAndRgnIdAndType_First(
		long publishId, long regionId, java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g e m template in the ordered set where publishId = &#63; and regionId = &#63; and templateType = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate findByPublishIdAndRgnIdAndType_Last(
		long publishId, long regionId, java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g e m template in the ordered set where publishId = &#63; and regionId = &#63; and templateType = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template, or <code>null</code> if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate fetchByPublishIdAndRgnIdAndType_Last(
		long publishId, long regionId, java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m templates before and after the current g e m template in the ordered set where publishId = &#63; and regionId = &#63; and templateType = &#63;.
	*
	* @param templateId the primary key of the current g e m template
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a g e m template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate[] findByPublishIdAndRgnIdAndType_PrevAndNext(
		long templateId, long publishId, long regionId,
		java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the g e m templates where publishId = &#63; and regionId = &#63; and templateType = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param templateType the template type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPublishIdAndRgnIdAndType(long publishId, long regionId,
		java.lang.String templateType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m templates where publishId = &#63; and regionId = &#63; and templateType = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param templateType the template type
	* @return the number of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public int countByPublishIdAndRgnIdAndType(long publishId, long regionId,
		java.lang.String templateType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m template where templateType = &#63; and regionId = &#63; and publishId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchGEMTemplateException} if it could not be found.
	*
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @return the matching g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate findByTypeAndRegionAndPublication(
		java.lang.String templateType, long regionId, long publishId)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m template where templateType = &#63; and regionId = &#63; and publishId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @return the matching g e m template, or <code>null</code> if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate fetchByTypeAndRegionAndPublication(
		java.lang.String templateType, long regionId, long publishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m template where templateType = &#63; and regionId = &#63; and publishId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching g e m template, or <code>null</code> if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate fetchByTypeAndRegionAndPublication(
		java.lang.String templateType, long regionId, long publishId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the g e m template where templateType = &#63; and regionId = &#63; and publishId = &#63; from the database.
	*
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @return the g e m template that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate removeByTypeAndRegionAndPublication(
		java.lang.String templateType, long regionId, long publishId)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m templates where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	*
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @return the number of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public int countByTypeAndRegionAndPublication(
		java.lang.String templateType, long regionId, long publishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the g e m templates where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	*
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @return the matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByTypeAndRegionAndPublicationList(
		java.lang.String templateType, long regionId, long publishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the g e m templates where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @param start the lower bound of the range of g e m templates
	* @param end the upper bound of the range of g e m templates (not inclusive)
	* @return the range of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByTypeAndRegionAndPublicationList(
		java.lang.String templateType, long regionId, long publishId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the g e m templates where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @param start the lower bound of the range of g e m templates
	* @param end the upper bound of the range of g e m templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByTypeAndRegionAndPublicationList(
		java.lang.String templateType, long regionId, long publishId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g e m template in the ordered set where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	*
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate findByTypeAndRegionAndPublicationList_First(
		java.lang.String templateType, long regionId, long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g e m template in the ordered set where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	*
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template, or <code>null</code> if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate fetchByTypeAndRegionAndPublicationList_First(
		java.lang.String templateType, long regionId, long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g e m template in the ordered set where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	*
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate findByTypeAndRegionAndPublicationList_Last(
		java.lang.String templateType, long regionId, long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g e m template in the ordered set where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	*
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template, or <code>null</code> if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate fetchByTypeAndRegionAndPublicationList_Last(
		java.lang.String templateType, long regionId, long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m templates before and after the current g e m template in the ordered set where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	*
	* @param templateId the primary key of the current g e m template
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a g e m template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate[] findByTypeAndRegionAndPublicationList_PrevAndNext(
		long templateId, java.lang.String templateType, long regionId,
		long publishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the g e m templates where templateType = &#63; and regionId = &#63; and publishId = &#63; from the database.
	*
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTypeAndRegionAndPublicationList(
		java.lang.String templateType, long regionId, long publishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m templates where templateType = &#63; and regionId = &#63; and publishId = &#63;.
	*
	* @param templateType the template type
	* @param regionId the region ID
	* @param publishId the publish ID
	* @return the number of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public int countByTypeAndRegionAndPublicationList(
		java.lang.String templateType, long regionId, long publishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the g e m templates where publishId = &#63; and templateType = &#63;.
	*
	* @param publishId the publish ID
	* @param templateType the template type
	* @return the matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByPublishIdAndTemplateType(
		long publishId, java.lang.String templateType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the g e m templates where publishId = &#63; and templateType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param templateType the template type
	* @param start the lower bound of the range of g e m templates
	* @param end the upper bound of the range of g e m templates (not inclusive)
	* @return the range of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByPublishIdAndTemplateType(
		long publishId, java.lang.String templateType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the g e m templates where publishId = &#63; and templateType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param templateType the template type
	* @param start the lower bound of the range of g e m templates
	* @param end the upper bound of the range of g e m templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByPublishIdAndTemplateType(
		long publishId, java.lang.String templateType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g e m template in the ordered set where publishId = &#63; and templateType = &#63;.
	*
	* @param publishId the publish ID
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate findByPublishIdAndTemplateType_First(
		long publishId, java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g e m template in the ordered set where publishId = &#63; and templateType = &#63;.
	*
	* @param publishId the publish ID
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template, or <code>null</code> if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate fetchByPublishIdAndTemplateType_First(
		long publishId, java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g e m template in the ordered set where publishId = &#63; and templateType = &#63;.
	*
	* @param publishId the publish ID
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate findByPublishIdAndTemplateType_Last(
		long publishId, java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g e m template in the ordered set where publishId = &#63; and templateType = &#63;.
	*
	* @param publishId the publish ID
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template, or <code>null</code> if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate fetchByPublishIdAndTemplateType_Last(
		long publishId, java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m templates before and after the current g e m template in the ordered set where publishId = &#63; and templateType = &#63;.
	*
	* @param templateId the primary key of the current g e m template
	* @param publishId the publish ID
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a g e m template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate[] findByPublishIdAndTemplateType_PrevAndNext(
		long templateId, long publishId, java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the g e m templates where publishId = &#63; and templateType = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param templateType the template type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPublishIdAndTemplateType(long publishId,
		java.lang.String templateType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m templates where publishId = &#63; and templateType = &#63;.
	*
	* @param publishId the publish ID
	* @param templateType the template type
	* @return the number of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public int countByPublishIdAndTemplateType(long publishId,
		java.lang.String templateType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the g e m templates where templateType = &#63;.
	*
	* @param templateType the template type
	* @return the matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByTemplateType(
		java.lang.String templateType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the g e m templates where templateType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templateType the template type
	* @param start the lower bound of the range of g e m templates
	* @param end the upper bound of the range of g e m templates (not inclusive)
	* @return the range of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByTemplateType(
		java.lang.String templateType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the g e m templates where templateType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param templateType the template type
	* @param start the lower bound of the range of g e m templates
	* @param end the upper bound of the range of g e m templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findByTemplateType(
		java.lang.String templateType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g e m template in the ordered set where templateType = &#63;.
	*
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate findByTemplateType_First(
		java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g e m template in the ordered set where templateType = &#63;.
	*
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template, or <code>null</code> if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate fetchByTemplateType_First(
		java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g e m template in the ordered set where templateType = &#63;.
	*
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate findByTemplateType_Last(
		java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g e m template in the ordered set where templateType = &#63;.
	*
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template, or <code>null</code> if a matching g e m template could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate fetchByTemplateType_Last(
		java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m templates before and after the current g e m template in the ordered set where templateType = &#63;.
	*
	* @param templateId the primary key of the current g e m template
	* @param templateType the template type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a g e m template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate[] findByTemplateType_PrevAndNext(
		long templateId, java.lang.String templateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the g e m templates where templateType = &#63; from the database.
	*
	* @param templateType the template type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTemplateType(java.lang.String templateType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m templates where templateType = &#63;.
	*
	* @param templateType the template type
	* @return the number of matching g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public int countByTemplateType(java.lang.String templateType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the g e m template in the entity cache if it is enabled.
	*
	* @param gemTemplate the g e m template
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.GEMTemplate gemTemplate);

	/**
	* Caches the g e m templates in the entity cache if it is enabled.
	*
	* @param gemTemplates the g e m templates
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> gemTemplates);

	/**
	* Creates a new g e m template with the primary key. Does not add the g e m template to the database.
	*
	* @param templateId the primary key for the new g e m template
	* @return the new g e m template
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate create(long templateId);

	/**
	* Removes the g e m template with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param templateId the primary key of the g e m template
	* @return the g e m template that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a g e m template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate remove(long templateId)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.GEMTemplate updateImpl(
		com.ihg.brandstandards.db.model.GEMTemplate gemTemplate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m template with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMTemplateException} if it could not be found.
	*
	* @param templateId the primary key of the g e m template
	* @return the g e m template
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateException if a g e m template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate findByPrimaryKey(
		long templateId)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m template with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param templateId the primary key of the g e m template
	* @return the g e m template, or <code>null</code> if a g e m template with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplate fetchByPrimaryKey(
		long templateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the g e m templates.
	*
	* @return the g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the g e m templates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m templates
	* @param end the upper bound of the range of g e m templates (not inclusive)
	* @return the range of g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the g e m templates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m templates
	* @param end the upper bound of the range of g e m templates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the g e m templates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m templates.
	*
	* @return the number of g e m templates
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}