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

import com.ihg.brandstandards.db.model.GEMTemplateReference;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the g e m template reference service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMTemplateReferencePersistenceImpl
 * @see GEMTemplateReferenceUtil
 * @generated
 */
public interface GEMTemplateReferencePersistence extends BasePersistence<GEMTemplateReference> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GEMTemplateReferenceUtil} to access the g e m template reference persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the g e m template references where publishDeptId = &#63; and regionId = &#63;.
	*
	* @param publishDeptId the publish dept ID
	* @param regionId the region ID
	* @return the matching g e m template references
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplateReference> findByPublishIdAndRgnId(
		long publishDeptId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the g e m template references where publishDeptId = &#63; and regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishDeptId the publish dept ID
	* @param regionId the region ID
	* @param start the lower bound of the range of g e m template references
	* @param end the upper bound of the range of g e m template references (not inclusive)
	* @return the range of matching g e m template references
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplateReference> findByPublishIdAndRgnId(
		long publishDeptId, long regionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the g e m template references where publishDeptId = &#63; and regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishDeptId the publish dept ID
	* @param regionId the region ID
	* @param start the lower bound of the range of g e m template references
	* @param end the upper bound of the range of g e m template references (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching g e m template references
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplateReference> findByPublishIdAndRgnId(
		long publishDeptId, long regionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g e m template reference in the ordered set where publishDeptId = &#63; and regionId = &#63;.
	*
	* @param publishDeptId the publish dept ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template reference
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException if a matching g e m template reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplateReference findByPublishIdAndRgnId_First(
		long publishDeptId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first g e m template reference in the ordered set where publishDeptId = &#63; and regionId = &#63;.
	*
	* @param publishDeptId the publish dept ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching g e m template reference, or <code>null</code> if a matching g e m template reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplateReference fetchByPublishIdAndRgnId_First(
		long publishDeptId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g e m template reference in the ordered set where publishDeptId = &#63; and regionId = &#63;.
	*
	* @param publishDeptId the publish dept ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template reference
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException if a matching g e m template reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplateReference findByPublishIdAndRgnId_Last(
		long publishDeptId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last g e m template reference in the ordered set where publishDeptId = &#63; and regionId = &#63;.
	*
	* @param publishDeptId the publish dept ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching g e m template reference, or <code>null</code> if a matching g e m template reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplateReference fetchByPublishIdAndRgnId_Last(
		long publishDeptId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m template references before and after the current g e m template reference in the ordered set where publishDeptId = &#63; and regionId = &#63;.
	*
	* @param templateRefId the primary key of the current g e m template reference
	* @param publishDeptId the publish dept ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next g e m template reference
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException if a g e m template reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplateReference[] findByPublishIdAndRgnId_PrevAndNext(
		long templateRefId, long publishDeptId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the g e m template references where publishDeptId = &#63; and regionId = &#63; from the database.
	*
	* @param publishDeptId the publish dept ID
	* @param regionId the region ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPublishIdAndRgnId(long publishDeptId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m template references where publishDeptId = &#63; and regionId = &#63;.
	*
	* @param publishDeptId the publish dept ID
	* @param regionId the region ID
	* @return the number of matching g e m template references
	* @throws SystemException if a system exception occurred
	*/
	public int countByPublishIdAndRgnId(long publishDeptId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the g e m template reference in the entity cache if it is enabled.
	*
	* @param gemTemplateReference the g e m template reference
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.GEMTemplateReference gemTemplateReference);

	/**
	* Caches the g e m template references in the entity cache if it is enabled.
	*
	* @param gemTemplateReferences the g e m template references
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GEMTemplateReference> gemTemplateReferences);

	/**
	* Creates a new g e m template reference with the primary key. Does not add the g e m template reference to the database.
	*
	* @param templateRefId the primary key for the new g e m template reference
	* @return the new g e m template reference
	*/
	public com.ihg.brandstandards.db.model.GEMTemplateReference create(
		long templateRefId);

	/**
	* Removes the g e m template reference with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param templateRefId the primary key of the g e m template reference
	* @return the g e m template reference that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException if a g e m template reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplateReference remove(
		long templateRefId)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.GEMTemplateReference updateImpl(
		com.ihg.brandstandards.db.model.GEMTemplateReference gemTemplateReference)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m template reference with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException} if it could not be found.
	*
	* @param templateRefId the primary key of the g e m template reference
	* @return the g e m template reference
	* @throws com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException if a g e m template reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplateReference findByPrimaryKey(
		long templateRefId)
		throws com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m template reference with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param templateRefId the primary key of the g e m template reference
	* @return the g e m template reference, or <code>null</code> if a g e m template reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMTemplateReference fetchByPrimaryKey(
		long templateRefId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the g e m template references.
	*
	* @return the g e m template references
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplateReference> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the g e m template references.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m template references
	* @param end the upper bound of the range of g e m template references (not inclusive)
	* @return the range of g e m template references
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplateReference> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the g e m template references.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m template references
	* @param end the upper bound of the range of g e m template references (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of g e m template references
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMTemplateReference> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the g e m template references from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m template references.
	*
	* @return the number of g e m template references
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}