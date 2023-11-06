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

import com.ihg.brandstandards.db.NoSuchHistManualAttachmentException;
import com.ihg.brandstandards.db.model.HistManualAttachment;
import com.ihg.brandstandards.db.model.impl.HistManualAttachmentImpl;
import com.ihg.brandstandards.db.model.impl.HistManualAttachmentModelImpl;

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
 * The persistence implementation for the hist manual attachment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see HistManualAttachmentPersistence
 * @see HistManualAttachmentUtil
 * @generated
 */
public class HistManualAttachmentPersistenceImpl extends BasePersistenceImpl<HistManualAttachment>
	implements HistManualAttachmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link HistManualAttachmentUtil} to access the hist manual attachment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = HistManualAttachmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HistManualAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			HistManualAttachmentModelImpl.FINDER_CACHE_ENABLED,
			HistManualAttachmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HistManualAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			HistManualAttachmentModelImpl.FINDER_CACHE_ENABLED,
			HistManualAttachmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HistManualAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			HistManualAttachmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public HistManualAttachmentPersistenceImpl() {
		setModelClass(HistManualAttachment.class);
	}

	/**
	 * Caches the hist manual attachment in the entity cache if it is enabled.
	 *
	 * @param histManualAttachment the hist manual attachment
	 */
	@Override
	public void cacheResult(HistManualAttachment histManualAttachment) {
		EntityCacheUtil.putResult(HistManualAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			HistManualAttachmentImpl.class,
			histManualAttachment.getPrimaryKey(), histManualAttachment);

		histManualAttachment.resetOriginalValues();
	}

	/**
	 * Caches the hist manual attachments in the entity cache if it is enabled.
	 *
	 * @param histManualAttachments the hist manual attachments
	 */
	@Override
	public void cacheResult(List<HistManualAttachment> histManualAttachments) {
		for (HistManualAttachment histManualAttachment : histManualAttachments) {
			if (EntityCacheUtil.getResult(
						HistManualAttachmentModelImpl.ENTITY_CACHE_ENABLED,
						HistManualAttachmentImpl.class,
						histManualAttachment.getPrimaryKey()) == null) {
				cacheResult(histManualAttachment);
			}
			else {
				histManualAttachment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all hist manual attachments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(HistManualAttachmentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(HistManualAttachmentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the hist manual attachment.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HistManualAttachment histManualAttachment) {
		EntityCacheUtil.removeResult(HistManualAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			HistManualAttachmentImpl.class, histManualAttachment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<HistManualAttachment> histManualAttachments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (HistManualAttachment histManualAttachment : histManualAttachments) {
			EntityCacheUtil.removeResult(HistManualAttachmentModelImpl.ENTITY_CACHE_ENABLED,
				HistManualAttachmentImpl.class,
				histManualAttachment.getPrimaryKey());
		}
	}

	/**
	 * Creates a new hist manual attachment with the primary key. Does not add the hist manual attachment to the database.
	 *
	 * @param histManualId the primary key for the new hist manual attachment
	 * @return the new hist manual attachment
	 */
	@Override
	public HistManualAttachment create(long histManualId) {
		HistManualAttachment histManualAttachment = new HistManualAttachmentImpl();

		histManualAttachment.setNew(true);
		histManualAttachment.setPrimaryKey(histManualId);

		return histManualAttachment;
	}

	/**
	 * Removes the hist manual attachment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param histManualId the primary key of the hist manual attachment
	 * @return the hist manual attachment that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchHistManualAttachmentException if a hist manual attachment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManualAttachment remove(long histManualId)
		throws NoSuchHistManualAttachmentException, SystemException {
		return remove((Serializable)histManualId);
	}

	/**
	 * Removes the hist manual attachment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the hist manual attachment
	 * @return the hist manual attachment that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchHistManualAttachmentException if a hist manual attachment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManualAttachment remove(Serializable primaryKey)
		throws NoSuchHistManualAttachmentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			HistManualAttachment histManualAttachment = (HistManualAttachment)session.get(HistManualAttachmentImpl.class,
					primaryKey);

			if (histManualAttachment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHistManualAttachmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(histManualAttachment);
		}
		catch (NoSuchHistManualAttachmentException nsee) {
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
	protected HistManualAttachment removeImpl(
		HistManualAttachment histManualAttachment) throws SystemException {
		histManualAttachment = toUnwrappedModel(histManualAttachment);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(histManualAttachment)) {
				histManualAttachment = (HistManualAttachment)session.get(HistManualAttachmentImpl.class,
						histManualAttachment.getPrimaryKeyObj());
			}

			if (histManualAttachment != null) {
				session.delete(histManualAttachment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (histManualAttachment != null) {
			clearCache(histManualAttachment);
		}

		return histManualAttachment;
	}

	@Override
	public HistManualAttachment updateImpl(
		com.ihg.brandstandards.db.model.HistManualAttachment histManualAttachment)
		throws SystemException {
		histManualAttachment = toUnwrappedModel(histManualAttachment);

		boolean isNew = histManualAttachment.isNew();

		Session session = null;

		try {
			session = openSession();

			if (histManualAttachment.isNew()) {
				session.save(histManualAttachment);

				histManualAttachment.setNew(false);
			}
			else {
				session.merge(histManualAttachment);
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

		EntityCacheUtil.putResult(HistManualAttachmentModelImpl.ENTITY_CACHE_ENABLED,
			HistManualAttachmentImpl.class,
			histManualAttachment.getPrimaryKey(), histManualAttachment);

		return histManualAttachment;
	}

	protected HistManualAttachment toUnwrappedModel(
		HistManualAttachment histManualAttachment) {
		if (histManualAttachment instanceof HistManualAttachmentImpl) {
			return histManualAttachment;
		}

		HistManualAttachmentImpl histManualAttachmentImpl = new HistManualAttachmentImpl();

		histManualAttachmentImpl.setNew(histManualAttachment.isNew());
		histManualAttachmentImpl.setPrimaryKey(histManualAttachment.getPrimaryKey());

		histManualAttachmentImpl.setHistManualId(histManualAttachment.getHistManualId());
		histManualAttachmentImpl.setAttachmentPath(histManualAttachment.getAttachmentPath());
		histManualAttachmentImpl.setCreatorId(histManualAttachment.getCreatorId());
		histManualAttachmentImpl.setCreatedDate(histManualAttachment.getCreatedDate());
		histManualAttachmentImpl.setUpdatedBy(histManualAttachment.getUpdatedBy());
		histManualAttachmentImpl.setUpdatedDate(histManualAttachment.getUpdatedDate());

		return histManualAttachmentImpl;
	}

	/**
	 * Returns the hist manual attachment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the hist manual attachment
	 * @return the hist manual attachment
	 * @throws com.ihg.brandstandards.db.NoSuchHistManualAttachmentException if a hist manual attachment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManualAttachment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHistManualAttachmentException, SystemException {
		HistManualAttachment histManualAttachment = fetchByPrimaryKey(primaryKey);

		if (histManualAttachment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHistManualAttachmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return histManualAttachment;
	}

	/**
	 * Returns the hist manual attachment with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchHistManualAttachmentException} if it could not be found.
	 *
	 * @param histManualId the primary key of the hist manual attachment
	 * @return the hist manual attachment
	 * @throws com.ihg.brandstandards.db.NoSuchHistManualAttachmentException if a hist manual attachment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManualAttachment findByPrimaryKey(long histManualId)
		throws NoSuchHistManualAttachmentException, SystemException {
		return findByPrimaryKey((Serializable)histManualId);
	}

	/**
	 * Returns the hist manual attachment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the hist manual attachment
	 * @return the hist manual attachment, or <code>null</code> if a hist manual attachment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManualAttachment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		HistManualAttachment histManualAttachment = (HistManualAttachment)EntityCacheUtil.getResult(HistManualAttachmentModelImpl.ENTITY_CACHE_ENABLED,
				HistManualAttachmentImpl.class, primaryKey);

		if (histManualAttachment == _nullHistManualAttachment) {
			return null;
		}

		if (histManualAttachment == null) {
			Session session = null;

			try {
				session = openSession();

				histManualAttachment = (HistManualAttachment)session.get(HistManualAttachmentImpl.class,
						primaryKey);

				if (histManualAttachment != null) {
					cacheResult(histManualAttachment);
				}
				else {
					EntityCacheUtil.putResult(HistManualAttachmentModelImpl.ENTITY_CACHE_ENABLED,
						HistManualAttachmentImpl.class, primaryKey,
						_nullHistManualAttachment);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(HistManualAttachmentModelImpl.ENTITY_CACHE_ENABLED,
					HistManualAttachmentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return histManualAttachment;
	}

	/**
	 * Returns the hist manual attachment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param histManualId the primary key of the hist manual attachment
	 * @return the hist manual attachment, or <code>null</code> if a hist manual attachment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManualAttachment fetchByPrimaryKey(long histManualId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)histManualId);
	}

	/**
	 * Returns all the hist manual attachments.
	 *
	 * @return the hist manual attachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<HistManualAttachment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the hist manual attachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of hist manual attachments
	 * @param end the upper bound of the range of hist manual attachments (not inclusive)
	 * @return the range of hist manual attachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<HistManualAttachment> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the hist manual attachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualAttachmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of hist manual attachments
	 * @param end the upper bound of the range of hist manual attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of hist manual attachments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<HistManualAttachment> findAll(int start, int end,
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

		List<HistManualAttachment> list = (List<HistManualAttachment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_HISTMANUALATTACHMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HISTMANUALATTACHMENT;

				if (pagination) {
					sql = sql.concat(HistManualAttachmentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<HistManualAttachment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<HistManualAttachment>(list);
				}
				else {
					list = (List<HistManualAttachment>)QueryUtil.list(q,
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
	 * Removes all the hist manual attachments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (HistManualAttachment histManualAttachment : findAll()) {
			remove(histManualAttachment);
		}
	}

	/**
	 * Returns the number of hist manual attachments.
	 *
	 * @return the number of hist manual attachments
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

				Query q = session.createQuery(_SQL_COUNT_HISTMANUALATTACHMENT);

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
	 * Initializes the hist manual attachment persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.HistManualAttachment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<HistManualAttachment>> listenersList = new ArrayList<ModelListener<HistManualAttachment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<HistManualAttachment>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(HistManualAttachmentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_HISTMANUALATTACHMENT = "SELECT histManualAttachment FROM HistManualAttachment histManualAttachment";
	private static final String _SQL_COUNT_HISTMANUALATTACHMENT = "SELECT COUNT(histManualAttachment) FROM HistManualAttachment histManualAttachment";
	private static final String _ORDER_BY_ENTITY_ALIAS = "histManualAttachment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No HistManualAttachment exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(HistManualAttachmentPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"histManualId", "attachmentPath", "creatorId", "createdDate",
				"updatedBy", "updatedDate"
			});
	private static HistManualAttachment _nullHistManualAttachment = new HistManualAttachmentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<HistManualAttachment> toCacheModel() {
				return _nullHistManualAttachmentCacheModel;
			}
		};

	private static CacheModel<HistManualAttachment> _nullHistManualAttachmentCacheModel =
		new CacheModel<HistManualAttachment>() {
			@Override
			public HistManualAttachment toEntityModel() {
				return _nullHistManualAttachment;
			}
		};
}