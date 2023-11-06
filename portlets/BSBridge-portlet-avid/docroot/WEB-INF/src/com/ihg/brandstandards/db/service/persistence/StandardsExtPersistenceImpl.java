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

import com.ihg.brandstandards.db.NoSuchStandardsExtException;
import com.ihg.brandstandards.db.model.StandardsExt;
import com.ihg.brandstandards.db.model.impl.StandardsExtImpl;
import com.ihg.brandstandards.db.model.impl.StandardsExtModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
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
 * The persistence implementation for the Custom Query mapping between STD and Taxonomy tables. service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsExtPersistence
 * @see StandardsExtUtil
 * @generated
 */
public class StandardsExtPersistenceImpl extends BasePersistenceImpl<StandardsExt>
	implements StandardsExtPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StandardsExtUtil} to access the Custom Query mapping between STD and Taxonomy tables. persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StandardsExtImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StandardsExtModelImpl.ENTITY_CACHE_ENABLED,
			StandardsExtModelImpl.FINDER_CACHE_ENABLED, StandardsExtImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StandardsExtModelImpl.ENTITY_CACHE_ENABLED,
			StandardsExtModelImpl.FINDER_CACHE_ENABLED, StandardsExtImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StandardsExtModelImpl.ENTITY_CACHE_ENABLED,
			StandardsExtModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_STDID = new FinderPath(StandardsExtModelImpl.ENTITY_CACHE_ENABLED,
			StandardsExtModelImpl.FINDER_CACHE_ENABLED, StandardsExtImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByStdId",
			new String[] { Long.class.getName() },
			StandardsExtModelImpl.STDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDID = new FinderPath(StandardsExtModelImpl.ENTITY_CACHE_ENABLED,
			StandardsExtModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStdId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the Custom Query mapping between STD and Taxonomy tables. where stdId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsExtException} if it could not be found.
	 *
	 * @param stdId the std ID
	 * @return the matching Custom Query mapping between STD and Taxonomy tables.
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsExtException if a matching Custom Query mapping between STD and Taxonomy tables. could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsExt findByStdId(long stdId)
		throws NoSuchStandardsExtException, SystemException {
		StandardsExt standardsExt = fetchByStdId(stdId);

		if (standardsExt == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("stdId=");
			msg.append(stdId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchStandardsExtException(msg.toString());
		}

		return standardsExt;
	}

	/**
	 * Returns the Custom Query mapping between STD and Taxonomy tables. where stdId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param stdId the std ID
	 * @return the matching Custom Query mapping between STD and Taxonomy tables., or <code>null</code> if a matching Custom Query mapping between STD and Taxonomy tables. could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsExt fetchByStdId(long stdId) throws SystemException {
		return fetchByStdId(stdId, true);
	}

	/**
	 * Returns the Custom Query mapping between STD and Taxonomy tables. where stdId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param stdId the std ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching Custom Query mapping between STD and Taxonomy tables., or <code>null</code> if a matching Custom Query mapping between STD and Taxonomy tables. could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsExt fetchByStdId(long stdId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { stdId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_STDID,
					finderArgs, this);
		}

		if (result instanceof StandardsExt) {
			StandardsExt standardsExt = (StandardsExt)result;

			if ((stdId != standardsExt.getStdId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_STANDARDSEXT_WHERE);

			query.append(_FINDER_COLUMN_STDID_STDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				List<StandardsExt> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"StandardsExtPersistenceImpl.fetchByStdId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					StandardsExt standardsExt = list.get(0);

					result = standardsExt;

					cacheResult(standardsExt);

					if ((standardsExt.getStdId() != stdId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDID,
							finderArgs, standardsExt);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (StandardsExt)result;
		}
	}

	/**
	 * Removes the Custom Query mapping between STD and Taxonomy tables. where stdId = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @return the Custom Query mapping between STD and Taxonomy tables. that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsExt removeByStdId(long stdId)
		throws NoSuchStandardsExtException, SystemException {
		StandardsExt standardsExt = findByStdId(stdId);

		return remove(standardsExt);
	}

	/**
	 * Returns the number of Custom Query mapping between STD and Taxonomy tables.s where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @return the number of matching Custom Query mapping between STD and Taxonomy tables.s
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStdId(long stdId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STDID;

		Object[] finderArgs = new Object[] { stdId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STANDARDSEXT_WHERE);

			query.append(_FINDER_COLUMN_STDID_STDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STDID_STDID_2 = "standardsExt.id.stdId = ?";

	public StandardsExtPersistenceImpl() {
		setModelClass(StandardsExt.class);
	}

	/**
	 * Caches the Custom Query mapping between STD and Taxonomy tables. in the entity cache if it is enabled.
	 *
	 * @param standardsExt the Custom Query mapping between STD and Taxonomy tables.
	 */
	@Override
	public void cacheResult(StandardsExt standardsExt) {
		EntityCacheUtil.putResult(StandardsExtModelImpl.ENTITY_CACHE_ENABLED,
			StandardsExtImpl.class, standardsExt.getPrimaryKey(), standardsExt);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDID,
			new Object[] { standardsExt.getStdId() }, standardsExt);

		standardsExt.resetOriginalValues();
	}

	/**
	 * Caches the Custom Query mapping between STD and Taxonomy tables.s in the entity cache if it is enabled.
	 *
	 * @param standardsExts the Custom Query mapping between STD and Taxonomy tables.s
	 */
	@Override
	public void cacheResult(List<StandardsExt> standardsExts) {
		for (StandardsExt standardsExt : standardsExts) {
			if (EntityCacheUtil.getResult(
						StandardsExtModelImpl.ENTITY_CACHE_ENABLED,
						StandardsExtImpl.class, standardsExt.getPrimaryKey()) == null) {
				cacheResult(standardsExt);
			}
			else {
				standardsExt.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all Custom Query mapping between STD and Taxonomy tables.s.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StandardsExtImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StandardsExtImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the Custom Query mapping between STD and Taxonomy tables..
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StandardsExt standardsExt) {
		EntityCacheUtil.removeResult(StandardsExtModelImpl.ENTITY_CACHE_ENABLED,
			StandardsExtImpl.class, standardsExt.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(standardsExt);
	}

	@Override
	public void clearCache(List<StandardsExt> standardsExts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StandardsExt standardsExt : standardsExts) {
			EntityCacheUtil.removeResult(StandardsExtModelImpl.ENTITY_CACHE_ENABLED,
				StandardsExtImpl.class, standardsExt.getPrimaryKey());

			clearUniqueFindersCache(standardsExt);
		}
	}

	protected void cacheUniqueFindersCache(StandardsExt standardsExt) {
		if (standardsExt.isNew()) {
			Object[] args = new Object[] { standardsExt.getStdId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STDID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDID, args,
				standardsExt);
		}
		else {
			StandardsExtModelImpl standardsExtModelImpl = (StandardsExtModelImpl)standardsExt;

			if ((standardsExtModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_STDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { standardsExt.getStdId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STDID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDID, args,
					standardsExt);
			}
		}
	}

	protected void clearUniqueFindersCache(StandardsExt standardsExt) {
		StandardsExtModelImpl standardsExtModelImpl = (StandardsExtModelImpl)standardsExt;

		Object[] args = new Object[] { standardsExt.getStdId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDID, args);

		if ((standardsExtModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_STDID.getColumnBitmask()) != 0) {
			args = new Object[] { standardsExtModelImpl.getOriginalStdId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDID, args);
		}
	}

	/**
	 * Creates a new Custom Query mapping between STD and Taxonomy tables. with the primary key. Does not add the Custom Query mapping between STD and Taxonomy tables. to the database.
	 *
	 * @param standardsExtPK the primary key for the new Custom Query mapping between STD and Taxonomy tables.
	 * @return the new Custom Query mapping between STD and Taxonomy tables.
	 */
	@Override
	public StandardsExt create(StandardsExtPK standardsExtPK) {
		StandardsExt standardsExt = new StandardsExtImpl();

		standardsExt.setNew(true);
		standardsExt.setPrimaryKey(standardsExtPK);

		return standardsExt;
	}

	/**
	 * Removes the Custom Query mapping between STD and Taxonomy tables. with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param standardsExtPK the primary key of the Custom Query mapping between STD and Taxonomy tables.
	 * @return the Custom Query mapping between STD and Taxonomy tables. that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsExtException if a Custom Query mapping between STD and Taxonomy tables. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsExt remove(StandardsExtPK standardsExtPK)
		throws NoSuchStandardsExtException, SystemException {
		return remove((Serializable)standardsExtPK);
	}

	/**
	 * Removes the Custom Query mapping between STD and Taxonomy tables. with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the Custom Query mapping between STD and Taxonomy tables.
	 * @return the Custom Query mapping between STD and Taxonomy tables. that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsExtException if a Custom Query mapping between STD and Taxonomy tables. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsExt remove(Serializable primaryKey)
		throws NoSuchStandardsExtException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StandardsExt standardsExt = (StandardsExt)session.get(StandardsExtImpl.class,
					primaryKey);

			if (standardsExt == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStandardsExtException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(standardsExt);
		}
		catch (NoSuchStandardsExtException nsee) {
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
	protected StandardsExt removeImpl(StandardsExt standardsExt)
		throws SystemException {
		standardsExt = toUnwrappedModel(standardsExt);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(standardsExt)) {
				standardsExt = (StandardsExt)session.get(StandardsExtImpl.class,
						standardsExt.getPrimaryKeyObj());
			}

			if (standardsExt != null) {
				session.delete(standardsExt);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (standardsExt != null) {
			clearCache(standardsExt);
		}

		return standardsExt;
	}

	@Override
	public StandardsExt updateImpl(
		com.ihg.brandstandards.db.model.StandardsExt standardsExt)
		throws SystemException {
		standardsExt = toUnwrappedModel(standardsExt);

		boolean isNew = standardsExt.isNew();

		Session session = null;

		try {
			session = openSession();

			if (standardsExt.isNew()) {
				session.save(standardsExt);

				standardsExt.setNew(false);
			}
			else {
				session.merge(standardsExt);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StandardsExtModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(StandardsExtModelImpl.ENTITY_CACHE_ENABLED,
			StandardsExtImpl.class, standardsExt.getPrimaryKey(), standardsExt);

		clearUniqueFindersCache(standardsExt);
		cacheUniqueFindersCache(standardsExt);

		return standardsExt;
	}

	protected StandardsExt toUnwrappedModel(StandardsExt standardsExt) {
		if (standardsExt instanceof StandardsExtImpl) {
			return standardsExt;
		}

		StandardsExtImpl standardsExtImpl = new StandardsExtImpl();

		standardsExtImpl.setNew(standardsExt.isNew());
		standardsExtImpl.setPrimaryKey(standardsExt.getPrimaryKey());

		standardsExtImpl.setStdId(standardsExt.getStdId());
		standardsExtImpl.setAuditLogId(standardsExt.getAuditLogId());
		standardsExtImpl.setStdManual(standardsExt.getStdManual());
		standardsExtImpl.setStdCorporateDepartment(standardsExt.getStdCorporateDepartment());
		standardsExtImpl.setStdBrandCd(standardsExt.getStdBrandCd());
		standardsExtImpl.setBiImpactAssmntId(standardsExt.getBiImpactAssmntId());
		standardsExtImpl.setStdCountryCd(standardsExt.getStdCountryCd());
		standardsExtImpl.setStdPrntId(standardsExt.getStdPrntId());
		standardsExtImpl.setStdOrigStdId(standardsExt.getStdOrigStdId());
		standardsExtImpl.setStdPubStatCd(standardsExt.getStdPubStatCd());
		standardsExtImpl.setStdType(standardsExt.getStdType());
		standardsExtImpl.setStdTitle(standardsExt.getStdTitle());
		standardsExtImpl.setStdDescription(standardsExt.getStdDescription());
		standardsExtImpl.setStdBusinessOwner(standardsExt.getStdBusinessOwner());
		standardsExtImpl.setStdStatus(standardsExt.getStdStatus());
		standardsExtImpl.setStdAuthor(standardsExt.getStdAuthor());
		standardsExtImpl.setStdCategory(standardsExt.getStdCategory());
		standardsExtImpl.setStdGlobal(standardsExt.getStdGlobal());
		standardsExtImpl.setStdRegionCode(standardsExt.getStdRegionCode());
		standardsExtImpl.setStdFramework(standardsExt.getStdFramework());
		standardsExtImpl.setStdChange(standardsExt.getStdChange());
		standardsExtImpl.setStdCreatedBy(standardsExt.getStdCreatedBy());
		standardsExtImpl.setStdUpdatedDate(standardsExt.getStdUpdatedDate());
		standardsExtImpl.setStdImageCount(standardsExt.getStdImageCount());
		standardsExtImpl.setStdImageTitle(standardsExt.getStdImageTitle());
		standardsExtImpl.setStdInternalReference(standardsExt.getStdInternalReference());
		standardsExtImpl.setStdOrderNumber(standardsExt.getStdOrderNumber());
		standardsExtImpl.setIndexId(standardsExt.getIndexId());
		standardsExtImpl.setIndexOrigId(standardsExt.getIndexOrigId());
		standardsExtImpl.setIndexPrntId(standardsExt.getIndexPrntId());
		standardsExtImpl.setIndexTitle(standardsExt.getIndexTitle());
		standardsExtImpl.setIndexLevel(standardsExt.getIndexLevel());
		standardsExtImpl.setIndexLevelSortOrder(standardsExt.getIndexLevelSortOrder());
		standardsExtImpl.setIndexPath(standardsExt.getIndexPath());
		standardsExtImpl.setAuditLogComments(standardsExt.getAuditLogComments());
		standardsExtImpl.setAuditLogTitle(standardsExt.getAuditLogTitle());
		standardsExtImpl.setAuditLogDate(standardsExt.getAuditLogDate());
		standardsExtImpl.setAuditLogStatus(standardsExt.getAuditLogStatus());
		standardsExtImpl.setAuditLogPrevStatus(standardsExt.getAuditLogPrevStatus());
		standardsExtImpl.setHistManualDesc(standardsExt.getHistManualDesc());
		standardsExtImpl.setSecLangIndexTitle(standardsExt.getSecLangIndexTitle());
		standardsExtImpl.setSecLangIndexDesc(standardsExt.getSecLangIndexDesc());
		standardsExtImpl.setSecLangIndexImgPath(standardsExt.getSecLangIndexImgPath());
		standardsExtImpl.setSecLangStdTitle(standardsExt.getSecLangStdTitle());
		standardsExtImpl.setSecLangStdDesc(standardsExt.getSecLangStdDesc());
		standardsExtImpl.setBiChangeTypeCd(standardsExt.getBiChangeTypeCd());
		standardsExtImpl.setBiRegionCd(standardsExt.getBiRegionCd());
		standardsExtImpl.setBiProfileLossImpactCd(standardsExt.getBiProfileLossImpactCd());
		standardsExtImpl.setBiCapExpenseImpactCd(standardsExt.getBiCapExpenseImpactCd());
		standardsExtImpl.setBiImplTimeScaleCd(standardsExt.getBiImplTimeScaleCd());
		standardsExtImpl.setBiComments(standardsExt.getBiComments());
		standardsExtImpl.setBiBrandCd(standardsExt.getBiBrandCd());
		standardsExtImpl.setStdCrossReferences(standardsExt.getStdCrossReferences());
		standardsExtImpl.setAuditBrand(standardsExt.getAuditBrand());
		standardsExtImpl.setGlobalRule(standardsExt.getGlobalRule());
		standardsExtImpl.setAmeaRule(standardsExt.getAmeaRule());
		standardsExtImpl.setAmerRule(standardsExt.getAmerRule());
		standardsExtImpl.setEuroRule(standardsExt.getEuroRule());
		standardsExtImpl.setGcRule(standardsExt.getGcRule());
		standardsExtImpl.setExpires(standardsExt.getExpires());

		return standardsExtImpl;
	}

	/**
	 * Returns the Custom Query mapping between STD and Taxonomy tables. with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the Custom Query mapping between STD and Taxonomy tables.
	 * @return the Custom Query mapping between STD and Taxonomy tables.
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsExtException if a Custom Query mapping between STD and Taxonomy tables. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsExt findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStandardsExtException, SystemException {
		StandardsExt standardsExt = fetchByPrimaryKey(primaryKey);

		if (standardsExt == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStandardsExtException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return standardsExt;
	}

	/**
	 * Returns the Custom Query mapping between STD and Taxonomy tables. with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsExtException} if it could not be found.
	 *
	 * @param standardsExtPK the primary key of the Custom Query mapping between STD and Taxonomy tables.
	 * @return the Custom Query mapping between STD and Taxonomy tables.
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsExtException if a Custom Query mapping between STD and Taxonomy tables. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsExt findByPrimaryKey(StandardsExtPK standardsExtPK)
		throws NoSuchStandardsExtException, SystemException {
		return findByPrimaryKey((Serializable)standardsExtPK);
	}

	/**
	 * Returns the Custom Query mapping between STD and Taxonomy tables. with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the Custom Query mapping between STD and Taxonomy tables.
	 * @return the Custom Query mapping between STD and Taxonomy tables., or <code>null</code> if a Custom Query mapping between STD and Taxonomy tables. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsExt fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StandardsExt standardsExt = (StandardsExt)EntityCacheUtil.getResult(StandardsExtModelImpl.ENTITY_CACHE_ENABLED,
				StandardsExtImpl.class, primaryKey);

		if (standardsExt == _nullStandardsExt) {
			return null;
		}

		if (standardsExt == null) {
			Session session = null;

			try {
				session = openSession();

				standardsExt = (StandardsExt)session.get(StandardsExtImpl.class,
						primaryKey);

				if (standardsExt != null) {
					cacheResult(standardsExt);
				}
				else {
					EntityCacheUtil.putResult(StandardsExtModelImpl.ENTITY_CACHE_ENABLED,
						StandardsExtImpl.class, primaryKey, _nullStandardsExt);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StandardsExtModelImpl.ENTITY_CACHE_ENABLED,
					StandardsExtImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return standardsExt;
	}

	/**
	 * Returns the Custom Query mapping between STD and Taxonomy tables. with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param standardsExtPK the primary key of the Custom Query mapping between STD and Taxonomy tables.
	 * @return the Custom Query mapping between STD and Taxonomy tables., or <code>null</code> if a Custom Query mapping between STD and Taxonomy tables. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsExt fetchByPrimaryKey(StandardsExtPK standardsExtPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)standardsExtPK);
	}

	/**
	 * Returns all the Custom Query mapping between STD and Taxonomy tables.s.
	 *
	 * @return the Custom Query mapping between STD and Taxonomy tables.s
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsExt> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Custom Query mapping between STD and Taxonomy tables.s.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of Custom Query mapping between STD and Taxonomy tables.s
	 * @param end the upper bound of the range of Custom Query mapping between STD and Taxonomy tables.s (not inclusive)
	 * @return the range of Custom Query mapping between STD and Taxonomy tables.s
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsExt> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the Custom Query mapping between STD and Taxonomy tables.s.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of Custom Query mapping between STD and Taxonomy tables.s
	 * @param end the upper bound of the range of Custom Query mapping between STD and Taxonomy tables.s (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Custom Query mapping between STD and Taxonomy tables.s
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsExt> findAll(int start, int end,
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

		List<StandardsExt> list = (List<StandardsExt>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STANDARDSEXT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STANDARDSEXT;

				if (pagination) {
					sql = sql.concat(StandardsExtModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StandardsExt>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsExt>(list);
				}
				else {
					list = (List<StandardsExt>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the Custom Query mapping between STD and Taxonomy tables.s from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StandardsExt standardsExt : findAll()) {
			remove(standardsExt);
		}
	}

	/**
	 * Returns the number of Custom Query mapping between STD and Taxonomy tables.s.
	 *
	 * @return the number of Custom Query mapping between STD and Taxonomy tables.s
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

				Query q = session.createQuery(_SQL_COUNT_STANDARDSEXT);

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
	 * Initializes the Custom Query mapping between STD and Taxonomy tables. persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.StandardsExt")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StandardsExt>> listenersList = new ArrayList<ModelListener<StandardsExt>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StandardsExt>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StandardsExtImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STANDARDSEXT = "SELECT standardsExt FROM StandardsExt standardsExt";
	private static final String _SQL_SELECT_STANDARDSEXT_WHERE = "SELECT standardsExt FROM StandardsExt standardsExt WHERE ";
	private static final String _SQL_COUNT_STANDARDSEXT = "SELECT COUNT(standardsExt) FROM StandardsExt standardsExt";
	private static final String _SQL_COUNT_STANDARDSEXT_WHERE = "SELECT COUNT(standardsExt) FROM StandardsExt standardsExt WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "standardsExt.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StandardsExt exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StandardsExt exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StandardsExtPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"stdId", "auditLogId", "stdManual", "stdCorporateDepartment",
				"stdBrandCd", "biImpactAssmntId", "stdCountryCd", "stdPrntId",
				"stdOrigStdId", "stdPubStatCd", "stdType", "stdTitle",
				"stdDescription", "stdBusinessOwner", "stdStatus", "stdAuthor",
				"stdCategory", "stdGlobal", "stdRegionCode", "stdFramework",
				"stdChange", "stdCreatedBy", "stdUpdatedDate", "stdImageCount",
				"stdImageTitle", "stdInternalReference", "stdOrderNumber",
				"indexId", "indexOrigId", "indexPrntId", "indexTitle",
				"indexLevel", "indexLevelSortOrder", "indexPath",
				"auditLogComments", "auditLogTitle", "auditLogDate",
				"auditLogStatus", "auditLogPrevStatus", "histManualDesc",
				"secLangIndexTitle", "secLangIndexDesc", "secLangIndexImgPath",
				"secLangStdTitle", "secLangStdDesc", "biChangeTypeCd",
				"biRegionCd", "biProfileLossImpactCd", "biCapExpenseImpactCd",
				"biImplTimeScaleCd", "biComments", "biBrandCd",
				"stdCrossReferences", "auditBrand", "globalRule", "ameaRule",
				"amerRule", "euroRule", "gcRule", "expires"
			});
	private static StandardsExt _nullStandardsExt = new StandardsExtImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StandardsExt> toCacheModel() {
				return _nullStandardsExtCacheModel;
			}
		};

	private static CacheModel<StandardsExt> _nullStandardsExtCacheModel = new CacheModel<StandardsExt>() {
			@Override
			public StandardsExt toEntityModel() {
				return _nullStandardsExt;
			}
		};
}