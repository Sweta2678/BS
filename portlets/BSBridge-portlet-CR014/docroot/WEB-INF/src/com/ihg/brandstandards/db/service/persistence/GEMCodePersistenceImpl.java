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

import com.ihg.brandstandards.db.NoSuchGEMCodeException;
import com.ihg.brandstandards.db.model.GEMCode;
import com.ihg.brandstandards.db.model.impl.GEMCodeImpl;
import com.ihg.brandstandards.db.model.impl.GEMCodeModelImpl;

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
 * The persistence implementation for the g e m code service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMCodePersistence
 * @see GEMCodeUtil
 * @generated
 */
public class GEMCodePersistenceImpl extends BasePersistenceImpl<GEMCode>
	implements GEMCodePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GEMCodeUtil} to access the g e m code persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GEMCodeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GEMCodeModelImpl.ENTITY_CACHE_ENABLED,
			GEMCodeModelImpl.FINDER_CACHE_ENABLED, GEMCodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GEMCodeModelImpl.ENTITY_CACHE_ENABLED,
			GEMCodeModelImpl.FINDER_CACHE_ENABLED, GEMCodeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GEMCodeModelImpl.ENTITY_CACHE_ENABLED,
			GEMCodeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public GEMCodePersistenceImpl() {
		setModelClass(GEMCode.class);
	}

	/**
	 * Caches the g e m code in the entity cache if it is enabled.
	 *
	 * @param gemCode the g e m code
	 */
	@Override
	public void cacheResult(GEMCode gemCode) {
		EntityCacheUtil.putResult(GEMCodeModelImpl.ENTITY_CACHE_ENABLED,
			GEMCodeImpl.class, gemCode.getPrimaryKey(), gemCode);

		gemCode.resetOriginalValues();
	}

	/**
	 * Caches the g e m codes in the entity cache if it is enabled.
	 *
	 * @param gemCodes the g e m codes
	 */
	@Override
	public void cacheResult(List<GEMCode> gemCodes) {
		for (GEMCode gemCode : gemCodes) {
			if (EntityCacheUtil.getResult(
						GEMCodeModelImpl.ENTITY_CACHE_ENABLED,
						GEMCodeImpl.class, gemCode.getPrimaryKey()) == null) {
				cacheResult(gemCode);
			}
			else {
				gemCode.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g e m codes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GEMCodeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GEMCodeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g e m code.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GEMCode gemCode) {
		EntityCacheUtil.removeResult(GEMCodeModelImpl.ENTITY_CACHE_ENABLED,
			GEMCodeImpl.class, gemCode.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GEMCode> gemCodes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GEMCode gemCode : gemCodes) {
			EntityCacheUtil.removeResult(GEMCodeModelImpl.ENTITY_CACHE_ENABLED,
				GEMCodeImpl.class, gemCode.getPrimaryKey());
		}
	}

	/**
	 * Creates a new g e m code with the primary key. Does not add the g e m code to the database.
	 *
	 * @param code the primary key for the new g e m code
	 * @return the new g e m code
	 */
	@Override
	public GEMCode create(String code) {
		GEMCode gemCode = new GEMCodeImpl();

		gemCode.setNew(true);
		gemCode.setPrimaryKey(code);

		return gemCode;
	}

	/**
	 * Removes the g e m code with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param code the primary key of the g e m code
	 * @return the g e m code that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMCodeException if a g e m code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCode remove(String code)
		throws NoSuchGEMCodeException, SystemException {
		return remove((Serializable)code);
	}

	/**
	 * Removes the g e m code with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g e m code
	 * @return the g e m code that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMCodeException if a g e m code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCode remove(Serializable primaryKey)
		throws NoSuchGEMCodeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GEMCode gemCode = (GEMCode)session.get(GEMCodeImpl.class, primaryKey);

			if (gemCode == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGEMCodeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gemCode);
		}
		catch (NoSuchGEMCodeException nsee) {
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
	protected GEMCode removeImpl(GEMCode gemCode) throws SystemException {
		gemCode = toUnwrappedModel(gemCode);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gemCode)) {
				gemCode = (GEMCode)session.get(GEMCodeImpl.class,
						gemCode.getPrimaryKeyObj());
			}

			if (gemCode != null) {
				session.delete(gemCode);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gemCode != null) {
			clearCache(gemCode);
		}

		return gemCode;
	}

	@Override
	public GEMCode updateImpl(com.ihg.brandstandards.db.model.GEMCode gemCode)
		throws SystemException {
		gemCode = toUnwrappedModel(gemCode);

		boolean isNew = gemCode.isNew();

		Session session = null;

		try {
			session = openSession();

			if (gemCode.isNew()) {
				session.save(gemCode);

				gemCode.setNew(false);
			}
			else {
				session.merge(gemCode);
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

		EntityCacheUtil.putResult(GEMCodeModelImpl.ENTITY_CACHE_ENABLED,
			GEMCodeImpl.class, gemCode.getPrimaryKey(), gemCode);

		return gemCode;
	}

	protected GEMCode toUnwrappedModel(GEMCode gemCode) {
		if (gemCode instanceof GEMCodeImpl) {
			return gemCode;
		}

		GEMCodeImpl gemCodeImpl = new GEMCodeImpl();

		gemCodeImpl.setNew(gemCode.isNew());
		gemCodeImpl.setPrimaryKey(gemCode.getPrimaryKey());

		gemCodeImpl.setCode(gemCode.getCode());
		gemCodeImpl.setCodeDesc(gemCode.getCodeDesc());
		gemCodeImpl.setCodeVal(gemCode.getCodeVal());
		gemCodeImpl.setCreatorId(gemCode.getCreatorId());
		gemCodeImpl.setCreatedDate(gemCode.getCreatedDate());
		gemCodeImpl.setUpdatedBy(gemCode.getUpdatedBy());
		gemCodeImpl.setUpdatedDate(gemCode.getUpdatedDate());

		return gemCodeImpl;
	}

	/**
	 * Returns the g e m code with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m code
	 * @return the g e m code
	 * @throws com.ihg.brandstandards.db.NoSuchGEMCodeException if a g e m code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCode findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGEMCodeException, SystemException {
		GEMCode gemCode = fetchByPrimaryKey(primaryKey);

		if (gemCode == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGEMCodeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gemCode;
	}

	/**
	 * Returns the g e m code with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMCodeException} if it could not be found.
	 *
	 * @param code the primary key of the g e m code
	 * @return the g e m code
	 * @throws com.ihg.brandstandards.db.NoSuchGEMCodeException if a g e m code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCode findByPrimaryKey(String code)
		throws NoSuchGEMCodeException, SystemException {
		return findByPrimaryKey((Serializable)code);
	}

	/**
	 * Returns the g e m code with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m code
	 * @return the g e m code, or <code>null</code> if a g e m code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCode fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GEMCode gemCode = (GEMCode)EntityCacheUtil.getResult(GEMCodeModelImpl.ENTITY_CACHE_ENABLED,
				GEMCodeImpl.class, primaryKey);

		if (gemCode == _nullGEMCode) {
			return null;
		}

		if (gemCode == null) {
			Session session = null;

			try {
				session = openSession();

				gemCode = (GEMCode)session.get(GEMCodeImpl.class, primaryKey);

				if (gemCode != null) {
					cacheResult(gemCode);
				}
				else {
					EntityCacheUtil.putResult(GEMCodeModelImpl.ENTITY_CACHE_ENABLED,
						GEMCodeImpl.class, primaryKey, _nullGEMCode);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GEMCodeModelImpl.ENTITY_CACHE_ENABLED,
					GEMCodeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gemCode;
	}

	/**
	 * Returns the g e m code with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param code the primary key of the g e m code
	 * @return the g e m code, or <code>null</code> if a g e m code with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMCode fetchByPrimaryKey(String code) throws SystemException {
		return fetchByPrimaryKey((Serializable)code);
	}

	/**
	 * Returns all the g e m codes.
	 *
	 * @return the g e m codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMCode> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m codes
	 * @param end the upper bound of the range of g e m codes (not inclusive)
	 * @return the range of g e m codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMCode> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMCodeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m codes
	 * @param end the upper bound of the range of g e m codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g e m codes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMCode> findAll(int start, int end,
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

		List<GEMCode> list = (List<GEMCode>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEMCODE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEMCODE;

				if (pagination) {
					sql = sql.concat(GEMCodeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GEMCode>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMCode>(list);
				}
				else {
					list = (List<GEMCode>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the g e m codes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GEMCode gemCode : findAll()) {
			remove(gemCode);
		}
	}

	/**
	 * Returns the number of g e m codes.
	 *
	 * @return the number of g e m codes
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

				Query q = session.createQuery(_SQL_COUNT_GEMCODE);

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
	 * Initializes the g e m code persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.GEMCode")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GEMCode>> listenersList = new ArrayList<ModelListener<GEMCode>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GEMCode>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GEMCodeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEMCODE = "SELECT gemCode FROM GEMCode gemCode";
	private static final String _SQL_COUNT_GEMCODE = "SELECT COUNT(gemCode) FROM GEMCode gemCode";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gemCode.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GEMCode exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GEMCodePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"code", "codeDesc", "codeVal", "creatorId", "createdDate",
				"updatedBy", "updatedDate"
			});
	private static GEMCode _nullGEMCode = new GEMCodeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GEMCode> toCacheModel() {
				return _nullGEMCodeCacheModel;
			}
		};

	private static CacheModel<GEMCode> _nullGEMCodeCacheModel = new CacheModel<GEMCode>() {
			@Override
			public GEMCode toEntityModel() {
				return _nullGEMCode;
			}
		};
}