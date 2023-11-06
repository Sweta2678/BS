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

import com.ihg.brandstandards.db.NoSuchStandardsComplianceExtException;
import com.ihg.brandstandards.db.model.StandardsComplianceExt;
import com.ihg.brandstandards.db.model.impl.StandardsComplianceExtImpl;
import com.ihg.brandstandards.db.model.impl.StandardsComplianceExtModelImpl;

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
 * The persistence implementation for the standards compliance ext service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsComplianceExtPersistence
 * @see StandardsComplianceExtUtil
 * @generated
 */
public class StandardsComplianceExtPersistenceImpl extends BasePersistenceImpl<StandardsComplianceExt>
	implements StandardsComplianceExtPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StandardsComplianceExtUtil} to access the standards compliance ext persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StandardsComplianceExtImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StandardsComplianceExtModelImpl.ENTITY_CACHE_ENABLED,
			StandardsComplianceExtModelImpl.FINDER_CACHE_ENABLED,
			StandardsComplianceExtImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StandardsComplianceExtModelImpl.ENTITY_CACHE_ENABLED,
			StandardsComplianceExtModelImpl.FINDER_CACHE_ENABLED,
			StandardsComplianceExtImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StandardsComplianceExtModelImpl.ENTITY_CACHE_ENABLED,
			StandardsComplianceExtModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public StandardsComplianceExtPersistenceImpl() {
		setModelClass(StandardsComplianceExt.class);
	}

	/**
	 * Caches the standards compliance ext in the entity cache if it is enabled.
	 *
	 * @param standardsComplianceExt the standards compliance ext
	 */
	@Override
	public void cacheResult(StandardsComplianceExt standardsComplianceExt) {
		EntityCacheUtil.putResult(StandardsComplianceExtModelImpl.ENTITY_CACHE_ENABLED,
			StandardsComplianceExtImpl.class,
			standardsComplianceExt.getPrimaryKey(), standardsComplianceExt);

		standardsComplianceExt.resetOriginalValues();
	}

	/**
	 * Caches the standards compliance exts in the entity cache if it is enabled.
	 *
	 * @param standardsComplianceExts the standards compliance exts
	 */
	@Override
	public void cacheResult(
		List<StandardsComplianceExt> standardsComplianceExts) {
		for (StandardsComplianceExt standardsComplianceExt : standardsComplianceExts) {
			if (EntityCacheUtil.getResult(
						StandardsComplianceExtModelImpl.ENTITY_CACHE_ENABLED,
						StandardsComplianceExtImpl.class,
						standardsComplianceExt.getPrimaryKey()) == null) {
				cacheResult(standardsComplianceExt);
			}
			else {
				standardsComplianceExt.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all standards compliance exts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StandardsComplianceExtImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StandardsComplianceExtImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the standards compliance ext.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StandardsComplianceExt standardsComplianceExt) {
		EntityCacheUtil.removeResult(StandardsComplianceExtModelImpl.ENTITY_CACHE_ENABLED,
			StandardsComplianceExtImpl.class,
			standardsComplianceExt.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StandardsComplianceExt> standardsComplianceExts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StandardsComplianceExt standardsComplianceExt : standardsComplianceExts) {
			EntityCacheUtil.removeResult(StandardsComplianceExtModelImpl.ENTITY_CACHE_ENABLED,
				StandardsComplianceExtImpl.class,
				standardsComplianceExt.getPrimaryKey());
		}
	}

	/**
	 * Creates a new standards compliance ext with the primary key. Does not add the standards compliance ext to the database.
	 *
	 * @param stdComplianceId the primary key for the new standards compliance ext
	 * @return the new standards compliance ext
	 */
	@Override
	public StandardsComplianceExt create(long stdComplianceId) {
		StandardsComplianceExt standardsComplianceExt = new StandardsComplianceExtImpl();

		standardsComplianceExt.setNew(true);
		standardsComplianceExt.setPrimaryKey(stdComplianceId);

		return standardsComplianceExt;
	}

	/**
	 * Removes the standards compliance ext with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stdComplianceId the primary key of the standards compliance ext
	 * @return the standards compliance ext that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsComplianceExtException if a standards compliance ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsComplianceExt remove(long stdComplianceId)
		throws NoSuchStandardsComplianceExtException, SystemException {
		return remove((Serializable)stdComplianceId);
	}

	/**
	 * Removes the standards compliance ext with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the standards compliance ext
	 * @return the standards compliance ext that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsComplianceExtException if a standards compliance ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsComplianceExt remove(Serializable primaryKey)
		throws NoSuchStandardsComplianceExtException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StandardsComplianceExt standardsComplianceExt = (StandardsComplianceExt)session.get(StandardsComplianceExtImpl.class,
					primaryKey);

			if (standardsComplianceExt == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStandardsComplianceExtException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(standardsComplianceExt);
		}
		catch (NoSuchStandardsComplianceExtException nsee) {
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
	protected StandardsComplianceExt removeImpl(
		StandardsComplianceExt standardsComplianceExt)
		throws SystemException {
		standardsComplianceExt = toUnwrappedModel(standardsComplianceExt);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(standardsComplianceExt)) {
				standardsComplianceExt = (StandardsComplianceExt)session.get(StandardsComplianceExtImpl.class,
						standardsComplianceExt.getPrimaryKeyObj());
			}

			if (standardsComplianceExt != null) {
				session.delete(standardsComplianceExt);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (standardsComplianceExt != null) {
			clearCache(standardsComplianceExt);
		}

		return standardsComplianceExt;
	}

	@Override
	public StandardsComplianceExt updateImpl(
		com.ihg.brandstandards.db.model.StandardsComplianceExt standardsComplianceExt)
		throws SystemException {
		standardsComplianceExt = toUnwrappedModel(standardsComplianceExt);

		boolean isNew = standardsComplianceExt.isNew();

		Session session = null;

		try {
			session = openSession();

			if (standardsComplianceExt.isNew()) {
				session.save(standardsComplianceExt);

				standardsComplianceExt.setNew(false);
			}
			else {
				session.merge(standardsComplianceExt);
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

		EntityCacheUtil.putResult(StandardsComplianceExtModelImpl.ENTITY_CACHE_ENABLED,
			StandardsComplianceExtImpl.class,
			standardsComplianceExt.getPrimaryKey(), standardsComplianceExt);

		return standardsComplianceExt;
	}

	protected StandardsComplianceExt toUnwrappedModel(
		StandardsComplianceExt standardsComplianceExt) {
		if (standardsComplianceExt instanceof StandardsComplianceExtImpl) {
			return standardsComplianceExt;
		}

		StandardsComplianceExtImpl standardsComplianceExtImpl = new StandardsComplianceExtImpl();

		standardsComplianceExtImpl.setNew(standardsComplianceExt.isNew());
		standardsComplianceExtImpl.setPrimaryKey(standardsComplianceExt.getPrimaryKey());

		standardsComplianceExtImpl.setStdComplianceId(standardsComplianceExt.getStdComplianceId());
		standardsComplianceExtImpl.setStdId(standardsComplianceExt.getStdId());
		standardsComplianceExtImpl.setCountryCode(standardsComplianceExt.getCountryCode());
		standardsComplianceExtImpl.setRegionCode(standardsComplianceExt.getRegionCode());
		standardsComplianceExtImpl.setChainCode(standardsComplianceExt.getChainCode());
		standardsComplianceExtImpl.setComplianceExpiryDate(standardsComplianceExt.getComplianceExpiryDate());
		standardsComplianceExtImpl.setComplianceExpiryRule(standardsComplianceExt.getComplianceExpiryRule());
		standardsComplianceExtImpl.setComplianceRuleMonths(standardsComplianceExt.getComplianceRuleMonths());
		standardsComplianceExtImpl.setRuleDate(standardsComplianceExt.getRuleDate());
		standardsComplianceExtImpl.setExpiryDate(standardsComplianceExt.getExpiryDate());
		standardsComplianceExtImpl.setComplianceDateString(standardsComplianceExt.getComplianceDateString());
		standardsComplianceExtImpl.setExpiryDateString(standardsComplianceExt.getExpiryDateString());

		return standardsComplianceExtImpl;
	}

	/**
	 * Returns the standards compliance ext with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards compliance ext
	 * @return the standards compliance ext
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsComplianceExtException if a standards compliance ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsComplianceExt findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStandardsComplianceExtException, SystemException {
		StandardsComplianceExt standardsComplianceExt = fetchByPrimaryKey(primaryKey);

		if (standardsComplianceExt == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStandardsComplianceExtException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return standardsComplianceExt;
	}

	/**
	 * Returns the standards compliance ext with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsComplianceExtException} if it could not be found.
	 *
	 * @param stdComplianceId the primary key of the standards compliance ext
	 * @return the standards compliance ext
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsComplianceExtException if a standards compliance ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsComplianceExt findByPrimaryKey(long stdComplianceId)
		throws NoSuchStandardsComplianceExtException, SystemException {
		return findByPrimaryKey((Serializable)stdComplianceId);
	}

	/**
	 * Returns the standards compliance ext with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards compliance ext
	 * @return the standards compliance ext, or <code>null</code> if a standards compliance ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsComplianceExt fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StandardsComplianceExt standardsComplianceExt = (StandardsComplianceExt)EntityCacheUtil.getResult(StandardsComplianceExtModelImpl.ENTITY_CACHE_ENABLED,
				StandardsComplianceExtImpl.class, primaryKey);

		if (standardsComplianceExt == _nullStandardsComplianceExt) {
			return null;
		}

		if (standardsComplianceExt == null) {
			Session session = null;

			try {
				session = openSession();

				standardsComplianceExt = (StandardsComplianceExt)session.get(StandardsComplianceExtImpl.class,
						primaryKey);

				if (standardsComplianceExt != null) {
					cacheResult(standardsComplianceExt);
				}
				else {
					EntityCacheUtil.putResult(StandardsComplianceExtModelImpl.ENTITY_CACHE_ENABLED,
						StandardsComplianceExtImpl.class, primaryKey,
						_nullStandardsComplianceExt);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StandardsComplianceExtModelImpl.ENTITY_CACHE_ENABLED,
					StandardsComplianceExtImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return standardsComplianceExt;
	}

	/**
	 * Returns the standards compliance ext with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stdComplianceId the primary key of the standards compliance ext
	 * @return the standards compliance ext, or <code>null</code> if a standards compliance ext with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsComplianceExt fetchByPrimaryKey(long stdComplianceId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)stdComplianceId);
	}

	/**
	 * Returns all the standards compliance exts.
	 *
	 * @return the standards compliance exts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsComplianceExt> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards compliance exts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsComplianceExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards compliance exts
	 * @param end the upper bound of the range of standards compliance exts (not inclusive)
	 * @return the range of standards compliance exts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsComplianceExt> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards compliance exts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsComplianceExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards compliance exts
	 * @param end the upper bound of the range of standards compliance exts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of standards compliance exts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsComplianceExt> findAll(int start, int end,
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

		List<StandardsComplianceExt> list = (List<StandardsComplianceExt>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STANDARDSCOMPLIANCEEXT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STANDARDSCOMPLIANCEEXT;

				if (pagination) {
					sql = sql.concat(StandardsComplianceExtModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StandardsComplianceExt>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsComplianceExt>(list);
				}
				else {
					list = (List<StandardsComplianceExt>)QueryUtil.list(q,
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
	 * Removes all the standards compliance exts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StandardsComplianceExt standardsComplianceExt : findAll()) {
			remove(standardsComplianceExt);
		}
	}

	/**
	 * Returns the number of standards compliance exts.
	 *
	 * @return the number of standards compliance exts
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

				Query q = session.createQuery(_SQL_COUNT_STANDARDSCOMPLIANCEEXT);

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
	 * Initializes the standards compliance ext persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.StandardsComplianceExt")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StandardsComplianceExt>> listenersList = new ArrayList<ModelListener<StandardsComplianceExt>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StandardsComplianceExt>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StandardsComplianceExtImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STANDARDSCOMPLIANCEEXT = "SELECT standardsComplianceExt FROM StandardsComplianceExt standardsComplianceExt";
	private static final String _SQL_COUNT_STANDARDSCOMPLIANCEEXT = "SELECT COUNT(standardsComplianceExt) FROM StandardsComplianceExt standardsComplianceExt";
	private static final String _ORDER_BY_ENTITY_ALIAS = "standardsComplianceExt.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StandardsComplianceExt exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StandardsComplianceExtPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"stdComplianceId", "stdId", "countryCode", "regionCode",
				"chainCode", "complianceExpiryDate", "complianceExpiryRule",
				"complianceRuleMonths", "RuleDate", "expiryDate",
				"complianceDateString", "expiryDateString"
			});
	private static StandardsComplianceExt _nullStandardsComplianceExt = new StandardsComplianceExtImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StandardsComplianceExt> toCacheModel() {
				return _nullStandardsComplianceExtCacheModel;
			}
		};

	private static CacheModel<StandardsComplianceExt> _nullStandardsComplianceExtCacheModel =
		new CacheModel<StandardsComplianceExt>() {
			@Override
			public StandardsComplianceExt toEntityModel() {
				return _nullStandardsComplianceExt;
			}
		};
}