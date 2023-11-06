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

import com.ihg.brandstandards.db.NoSuchPublishStandardsExtException;
import com.ihg.brandstandards.db.model.PublishStandardsExt;
import com.ihg.brandstandards.db.model.impl.PublishStandardsExtImpl;
import com.ihg.brandstandards.db.model.impl.PublishStandardsExtModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the Custom Query mapping to createlist of standards with translations. service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see PublishStandardsExtPersistence
 * @see PublishStandardsExtUtil
 * @generated
 */
public class PublishStandardsExtPersistenceImpl extends BasePersistenceImpl<PublishStandardsExt>
	implements PublishStandardsExtPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PublishStandardsExtUtil} to access the Custom Query mapping to createlist of standards with translations. persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PublishStandardsExtImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PublishStandardsExtModelImpl.ENTITY_CACHE_ENABLED,
			PublishStandardsExtModelImpl.FINDER_CACHE_ENABLED,
			PublishStandardsExtImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PublishStandardsExtModelImpl.ENTITY_CACHE_ENABLED,
			PublishStandardsExtModelImpl.FINDER_CACHE_ENABLED,
			PublishStandardsExtImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PublishStandardsExtModelImpl.ENTITY_CACHE_ENABLED,
			PublishStandardsExtModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public PublishStandardsExtPersistenceImpl() {
		setModelClass(PublishStandardsExt.class);
	}

	/**
	 * Caches the Custom Query mapping to createlist of standards with translations. in the entity cache if it is enabled.
	 *
	 * @param publishStandardsExt the Custom Query mapping to createlist of standards with translations.
	 */
	@Override
	public void cacheResult(PublishStandardsExt publishStandardsExt) {
		EntityCacheUtil.putResult(PublishStandardsExtModelImpl.ENTITY_CACHE_ENABLED,
			PublishStandardsExtImpl.class, publishStandardsExt.getPrimaryKey(),
			publishStandardsExt);

		publishStandardsExt.resetOriginalValues();
	}

	/**
	 * Caches the Custom Query mapping to createlist of standards with translations.s in the entity cache if it is enabled.
	 *
	 * @param publishStandardsExts the Custom Query mapping to createlist of standards with translations.s
	 */
	@Override
	public void cacheResult(List<PublishStandardsExt> publishStandardsExts) {
		for (PublishStandardsExt publishStandardsExt : publishStandardsExts) {
			if (EntityCacheUtil.getResult(
						PublishStandardsExtModelImpl.ENTITY_CACHE_ENABLED,
						PublishStandardsExtImpl.class,
						publishStandardsExt.getPrimaryKey()) == null) {
				cacheResult(publishStandardsExt);
			}
			else {
				publishStandardsExt.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all Custom Query mapping to createlist of standards with translations.s.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PublishStandardsExtImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PublishStandardsExtImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the Custom Query mapping to createlist of standards with translations..
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PublishStandardsExt publishStandardsExt) {
		EntityCacheUtil.removeResult(PublishStandardsExtModelImpl.ENTITY_CACHE_ENABLED,
			PublishStandardsExtImpl.class, publishStandardsExt.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PublishStandardsExt> publishStandardsExts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PublishStandardsExt publishStandardsExt : publishStandardsExts) {
			EntityCacheUtil.removeResult(PublishStandardsExtModelImpl.ENTITY_CACHE_ENABLED,
				PublishStandardsExtImpl.class,
				publishStandardsExt.getPrimaryKey());
		}
	}

	/**
	 * Creates a new Custom Query mapping to createlist of standards with translations. with the primary key. Does not add the Custom Query mapping to createlist of standards with translations. to the database.
	 *
	 * @param publishStdId the primary key for the new Custom Query mapping to createlist of standards with translations.
	 * @return the new Custom Query mapping to createlist of standards with translations.
	 */
	@Override
	public PublishStandardsExt create(long publishStdId) {
		PublishStandardsExt publishStandardsExt = new PublishStandardsExtImpl();

		publishStandardsExt.setNew(true);
		publishStandardsExt.setPrimaryKey(publishStdId);

		return publishStandardsExt;
	}

	/**
	 * Removes the Custom Query mapping to createlist of standards with translations. with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param publishStdId the primary key of the Custom Query mapping to createlist of standards with translations.
	 * @return the Custom Query mapping to createlist of standards with translations. that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchPublishStandardsExtException if a Custom Query mapping to createlist of standards with translations. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStandardsExt remove(long publishStdId)
		throws NoSuchPublishStandardsExtException, SystemException {
		return remove((Serializable)publishStdId);
	}

	/**
	 * Removes the Custom Query mapping to createlist of standards with translations. with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the Custom Query mapping to createlist of standards with translations.
	 * @return the Custom Query mapping to createlist of standards with translations. that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchPublishStandardsExtException if a Custom Query mapping to createlist of standards with translations. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStandardsExt remove(Serializable primaryKey)
		throws NoSuchPublishStandardsExtException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PublishStandardsExt publishStandardsExt = (PublishStandardsExt)session.get(PublishStandardsExtImpl.class,
					primaryKey);

			if (publishStandardsExt == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPublishStandardsExtException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(publishStandardsExt);
		}
		catch (NoSuchPublishStandardsExtException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected PublishStandardsExt removeImpl(
		PublishStandardsExt publishStandardsExt) throws SystemException {
		publishStandardsExt = toUnwrappedModel(publishStandardsExt);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(publishStandardsExt)) {
				publishStandardsExt = (PublishStandardsExt)session.get(PublishStandardsExtImpl.class,
						publishStandardsExt.getPrimaryKeyObj());
			}

			if (publishStandardsExt != null) {
				session.delete(publishStandardsExt);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (publishStandardsExt != null) {
			clearCache(publishStandardsExt);
		}

		return publishStandardsExt;
	}

	@Override
	public PublishStandardsExt updateImpl(
		com.ihg.brandstandards.db.model.PublishStandardsExt publishStandardsExt)
		throws SystemException {
		publishStandardsExt = toUnwrappedModel(publishStandardsExt);

		boolean isNew = publishStandardsExt.isNew();

		Session session = null;

		try {
			session = openSession();

			if (publishStandardsExt.isNew()) {
				session.save(publishStandardsExt);

				publishStandardsExt.setNew(false);
			}
			else {
				session.merge(publishStandardsExt);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(PublishStandardsExtModelImpl.ENTITY_CACHE_ENABLED,
			PublishStandardsExtImpl.class, publishStandardsExt.getPrimaryKey(),
			publishStandardsExt);

		return publishStandardsExt;
	}

	protected PublishStandardsExt toUnwrappedModel(
		PublishStandardsExt publishStandardsExt) {
		if (publishStandardsExt instanceof PublishStandardsExtImpl) {
			return publishStandardsExt;
		}

		PublishStandardsExtImpl publishStandardsExtImpl = new PublishStandardsExtImpl();

		publishStandardsExtImpl.setNew(publishStandardsExt.isNew());
		publishStandardsExtImpl.setPrimaryKey(publishStandardsExt.getPrimaryKey());

		publishStandardsExtImpl.setPublishStdId(publishStandardsExt.getPublishStdId());
		publishStandardsExtImpl.setPublishId(publishStandardsExt.getPublishId());
		publishStandardsExtImpl.setStdId(publishStandardsExt.getStdId());
		publishStandardsExtImpl.setParentPublishId(publishStandardsExt.getParentPublishId());
		publishStandardsExtImpl.setStdTyp(publishStandardsExt.getStdTyp());
		publishStandardsExtImpl.setTitle(publishStandardsExt.getTitle());
		publishStandardsExtImpl.setPrevPublishTitle(publishStandardsExt.getPrevPublishTitle());
		publishStandardsExtImpl.setDescription(publishStandardsExt.getDescription());
		publishStandardsExtImpl.setPrevDescription(publishStandardsExt.getPrevDescription());
		publishStandardsExtImpl.setAuthor(publishStandardsExt.getAuthor());
		publishStandardsExtImpl.setBusinessOwner(publishStandardsExt.getBusinessOwner());
		publishStandardsExtImpl.setEffectiveDate(publishStandardsExt.getEffectiveDate());
		publishStandardsExtImpl.setImplDate(publishStandardsExt.getImplDate());
		publishStandardsExtImpl.setPrevCmplyDate(publishStandardsExt.getPrevCmplyDate());
		publishStandardsExtImpl.setWaiver(publishStandardsExt.getWaiver());
		publishStandardsExtImpl.setStatus(publishStandardsExt.getStatus());
		publishStandardsExtImpl.setCategory(publishStandardsExt.getCategory());
		publishStandardsExtImpl.setCreatedBy(publishStandardsExt.getCreatedBy());
		publishStandardsExtImpl.setChange(publishStandardsExt.getChange());
		publishStandardsExtImpl.setIsGlobal(publishStandardsExt.getIsGlobal());
		publishStandardsExtImpl.setRegionCode(publishStandardsExt.getRegionCode());
		publishStandardsExtImpl.setNotes(publishStandardsExt.getNotes());
		publishStandardsExtImpl.setFramework(publishStandardsExt.getFramework());
		publishStandardsExtImpl.setInternalReference(publishStandardsExt.getInternalReference());
		publishStandardsExtImpl.setRegion(publishStandardsExt.getRegion());
		publishStandardsExtImpl.setStatusIdentifier(publishStandardsExt.getStatusIdentifier());
		publishStandardsExtImpl.setSortOrder(publishStandardsExt.getSortOrder());
		publishStandardsExtImpl.setLocaleCode(publishStandardsExt.getLocaleCode());
		publishStandardsExtImpl.setTaxonomyId(publishStandardsExt.getTaxonomyId());
		publishStandardsExtImpl.setPrntTaxonomyId(publishStandardsExt.getPrntTaxonomyId());
		publishStandardsExtImpl.setAttachmentExists(publishStandardsExt.getAttachmentExists());
		publishStandardsExtImpl.setAttachmentList(publishStandardsExt.getAttachmentList());
		publishStandardsExtImpl.setLinkExists(publishStandardsExt.getLinkExists());
		publishStandardsExtImpl.setLinkList(publishStandardsExt.getLinkList());
		publishStandardsExtImpl.setImageExists(publishStandardsExt.getImageExists());
		publishStandardsExtImpl.setStdXrefListStdId(publishStandardsExt.getStdXrefListStdId());
		publishStandardsExtImpl.setAttachmentStatus(publishStandardsExt.getAttachmentStatus());
		publishStandardsExtImpl.setLinkStatus(publishStandardsExt.getLinkStatus());
		publishStandardsExtImpl.setImageStatus(publishStandardsExt.getImageStatus());
		publishStandardsExtImpl.setImageIdList(publishStandardsExt.getImageIdList());
		publishStandardsExtImpl.setIndexOrder(publishStandardsExt.getIndexOrder());
		publishStandardsExtImpl.setPublishTaxonomyId(publishStandardsExt.getPublishTaxonomyId());
		publishStandardsExtImpl.setParentTaxonomyId(publishStandardsExt.getParentTaxonomyId());
		publishStandardsExtImpl.setIndexTitle(publishStandardsExt.getIndexTitle());
		publishStandardsExtImpl.setIndexLvl(publishStandardsExt.getIndexLvl());
		publishStandardsExtImpl.setTaxonomyPath(publishStandardsExt.getTaxonomyPath());
		publishStandardsExtImpl.setLevelSortOrder(publishStandardsExt.getLevelSortOrder());
		publishStandardsExtImpl.setIndexDescription(publishStandardsExt.getIndexDescription());
		publishStandardsExtImpl.setMatchedId(publishStandardsExt.getMatchedId());
		publishStandardsExtImpl.setExpiryDate(publishStandardsExt.getExpiryDate());
		publishStandardsExtImpl.setPrevExpiryDate(publishStandardsExt.getPrevExpiryDate());
		publishStandardsExtImpl.setExpiredStdId(publishStandardsExt.getExpiredStdId());
		publishStandardsExtImpl.setFlagStdId(publishStandardsExt.getFlagStdId());
		publishStandardsExtImpl.setPrevFlagStdId(publishStandardsExt.getPrevFlagStdId());
		publishStandardsExtImpl.setTitleChange(publishStandardsExt.getTitleChange());
		publishStandardsExtImpl.setCmplyChange(publishStandardsExt.getCmplyChange());
		publishStandardsExtImpl.setExprChange(publishStandardsExt.getExprChange());
		publishStandardsExtImpl.setHlcChange(publishStandardsExt.getHlcChange());
		publishStandardsExtImpl.setChangedStatus(publishStandardsExt.getChangedStatus());

		return publishStandardsExtImpl;
	}

	/**
	 * Returns the Custom Query mapping to createlist of standards with translations. with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the Custom Query mapping to createlist of standards with translations.
	 * @return the Custom Query mapping to createlist of standards with translations.
	 * @throws com.ihg.brandstandards.db.NoSuchPublishStandardsExtException if a Custom Query mapping to createlist of standards with translations. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStandardsExt findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPublishStandardsExtException, SystemException {
		PublishStandardsExt publishStandardsExt = fetchByPrimaryKey(primaryKey);

		if (publishStandardsExt == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPublishStandardsExtException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return publishStandardsExt;
	}

	/**
	 * Returns the Custom Query mapping to createlist of standards with translations. with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchPublishStandardsExtException} if it could not be found.
	 *
	 * @param publishStdId the primary key of the Custom Query mapping to createlist of standards with translations.
	 * @return the Custom Query mapping to createlist of standards with translations.
	 * @throws com.ihg.brandstandards.db.NoSuchPublishStandardsExtException if a Custom Query mapping to createlist of standards with translations. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStandardsExt findByPrimaryKey(long publishStdId)
		throws NoSuchPublishStandardsExtException, SystemException {
		return findByPrimaryKey((Serializable)publishStdId);
	}

	/**
	 * Returns the Custom Query mapping to createlist of standards with translations. with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the Custom Query mapping to createlist of standards with translations.
	 * @return the Custom Query mapping to createlist of standards with translations., or <code>null</code> if a Custom Query mapping to createlist of standards with translations. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStandardsExt fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PublishStandardsExt publishStandardsExt = (PublishStandardsExt)EntityCacheUtil.getResult(PublishStandardsExtModelImpl.ENTITY_CACHE_ENABLED,
				PublishStandardsExtImpl.class, primaryKey);

		if (publishStandardsExt == _nullPublishStandardsExt) {
			return null;
		}

		if (publishStandardsExt == null) {
			Session session = null;

			try {
				session = openSession();

				publishStandardsExt = (PublishStandardsExt)session.get(PublishStandardsExtImpl.class,
						primaryKey);

				if (publishStandardsExt != null) {
					cacheResult(publishStandardsExt);
				}
				else {
					EntityCacheUtil.putResult(PublishStandardsExtModelImpl.ENTITY_CACHE_ENABLED,
						PublishStandardsExtImpl.class, primaryKey,
						_nullPublishStandardsExt);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PublishStandardsExtModelImpl.ENTITY_CACHE_ENABLED,
					PublishStandardsExtImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return publishStandardsExt;
	}

	/**
	 * Returns the Custom Query mapping to createlist of standards with translations. with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param publishStdId the primary key of the Custom Query mapping to createlist of standards with translations.
	 * @return the Custom Query mapping to createlist of standards with translations., or <code>null</code> if a Custom Query mapping to createlist of standards with translations. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishStandardsExt fetchByPrimaryKey(long publishStdId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)publishStdId);
	}

	/**
	 * Returns all the Custom Query mapping to createlist of standards with translations.s.
	 *
	 * @return the Custom Query mapping to createlist of standards with translations.s
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishStandardsExt> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Custom Query mapping to createlist of standards with translations.s.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishStandardsExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of Custom Query mapping to createlist of standards with translations.s
	 * @param end the upper bound of the range of Custom Query mapping to createlist of standards with translations.s (not inclusive)
	 * @return the range of Custom Query mapping to createlist of standards with translations.s
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishStandardsExt> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the Custom Query mapping to createlist of standards with translations.s.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishStandardsExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of Custom Query mapping to createlist of standards with translations.s
	 * @param end the upper bound of the range of Custom Query mapping to createlist of standards with translations.s (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Custom Query mapping to createlist of standards with translations.s
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishStandardsExt> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<PublishStandardsExt> list = (List<PublishStandardsExt>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PUBLISHSTANDARDSEXT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PUBLISHSTANDARDSEXT;

				if (pagination) {
					sql = sql.concat(PublishStandardsExtModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PublishStandardsExt>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PublishStandardsExt>(list);
				}
				else {
					list = (List<PublishStandardsExt>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the Custom Query mapping to createlist of standards with translations.s from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PublishStandardsExt publishStandardsExt : findAll()) {
			remove(publishStandardsExt);
		}
	}

	/**
	 * Returns the number of Custom Query mapping to createlist of standards with translations.s.
	 *
	 * @return the number of Custom Query mapping to createlist of standards with translations.s
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PUBLISHSTANDARDSEXT);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the Custom Query mapping to createlist of standards with translations. persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.PublishStandardsExt")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PublishStandardsExt>> listenersList = new ArrayList<ModelListener<PublishStandardsExt>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PublishStandardsExt>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(PublishStandardsExtImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PUBLISHSTANDARDSEXT = "SELECT publishStandardsExt FROM PublishStandardsExt publishStandardsExt";
	private static final String _SQL_COUNT_PUBLISHSTANDARDSEXT = "SELECT COUNT(publishStandardsExt) FROM PublishStandardsExt publishStandardsExt";
	private static final String _ORDER_BY_ENTITY_ALIAS = "publishStandardsExt.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PublishStandardsExt exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PublishStandardsExtPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"publishStdId", "publishId", "stdId", "parentPublishId",
				"stdTyp", "title", "prevPublishTitle", "description",
				"prevDescription", "author", "businessOwner", "effectiveDate",
				"implDate", "prevCmplyDate", "waiver", "status", "category",
				"createdBy", "change", "isGlobal", "regionCode", "notes",
				"framework", "internalReference", "region", "statusIdentifier",
				"sortOrder", "localeCode", "taxonomyId", "prntTaxonomyId",
				"attachmentExists", "attachmentList", "linkExists", "linkList",
				"imageExists", "stdXrefListStdId", "attachmentStatus",
				"linkStatus", "imageStatus", "imageIdList", "indexOrder",
				"publishTaxonomyId", "parentTaxonomyId", "indexTitle",
				"indexLvl", "taxonomyPath", "levelSortOrder", "indexDescription",
				"matchedId", "expiryDate", "prevExpiryDate", "expiredStdId",
				"flagStdId", "prevFlagStdId", "titleChange", "cmplyChange",
				"exprChange", "hlcChange", "changedStatus"
			});
	private static PublishStandardsExt _nullPublishStandardsExt = new PublishStandardsExtImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PublishStandardsExt> toCacheModel() {
				return _nullPublishStandardsExtCacheModel;
			}
		};

	private static CacheModel<PublishStandardsExt> _nullPublishStandardsExtCacheModel =
		new CacheModel<PublishStandardsExt>() {
			@Override
			public PublishStandardsExt toEntityModel() {
				return _nullPublishStandardsExt;
			}
		};
}