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

import com.ihg.grs.common.NoSuchFeedbackDetailException;
import com.ihg.grs.common.model.FeedbackDetail;
import com.ihg.grs.common.model.impl.FeedbackDetailImpl;
import com.ihg.grs.common.model.impl.FeedbackDetailModelImpl;

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
 * The persistence implementation for the feedback detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gulam.vora
 * @see FeedbackDetailPersistence
 * @see FeedbackDetailUtil
 * @generated
 */
public class FeedbackDetailPersistenceImpl extends BasePersistenceImpl<FeedbackDetail>
	implements FeedbackDetailPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FeedbackDetailUtil} to access the feedback detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FeedbackDetailImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FeedbackDetailModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackDetailModelImpl.FINDER_CACHE_ENABLED,
			FeedbackDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FeedbackDetailModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackDetailModelImpl.FINDER_CACHE_ENABLED,
			FeedbackDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FeedbackDetailModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public FeedbackDetailPersistenceImpl() {
		setModelClass(FeedbackDetail.class);
	}

	/**
	 * Caches the feedback detail in the entity cache if it is enabled.
	 *
	 * @param feedbackDetail the feedback detail
	 */
	@Override
	public void cacheResult(FeedbackDetail feedbackDetail) {
		EntityCacheUtil.putResult(FeedbackDetailModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackDetailImpl.class, feedbackDetail.getPrimaryKey(),
			feedbackDetail);

		feedbackDetail.resetOriginalValues();
	}

	/**
	 * Caches the feedback details in the entity cache if it is enabled.
	 *
	 * @param feedbackDetails the feedback details
	 */
	@Override
	public void cacheResult(List<FeedbackDetail> feedbackDetails) {
		for (FeedbackDetail feedbackDetail : feedbackDetails) {
			if (EntityCacheUtil.getResult(
						FeedbackDetailModelImpl.ENTITY_CACHE_ENABLED,
						FeedbackDetailImpl.class, feedbackDetail.getPrimaryKey()) == null) {
				cacheResult(feedbackDetail);
			}
			else {
				feedbackDetail.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all feedback details.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FeedbackDetailImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FeedbackDetailImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the feedback detail.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FeedbackDetail feedbackDetail) {
		EntityCacheUtil.removeResult(FeedbackDetailModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackDetailImpl.class, feedbackDetail.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FeedbackDetail> feedbackDetails) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FeedbackDetail feedbackDetail : feedbackDetails) {
			EntityCacheUtil.removeResult(FeedbackDetailModelImpl.ENTITY_CACHE_ENABLED,
				FeedbackDetailImpl.class, feedbackDetail.getPrimaryKey());
		}
	}

	/**
	 * Creates a new feedback detail with the primary key. Does not add the feedback detail to the database.
	 *
	 * @param PORTAL_FEEDBACK_DTL_ID the primary key for the new feedback detail
	 * @return the new feedback detail
	 */
	@Override
	public FeedbackDetail create(int PORTAL_FEEDBACK_DTL_ID) {
		FeedbackDetail feedbackDetail = new FeedbackDetailImpl();

		feedbackDetail.setNew(true);
		feedbackDetail.setPrimaryKey(PORTAL_FEEDBACK_DTL_ID);

		return feedbackDetail;
	}

	/**
	 * Removes the feedback detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PORTAL_FEEDBACK_DTL_ID the primary key of the feedback detail
	 * @return the feedback detail that was removed
	 * @throws com.ihg.grs.common.NoSuchFeedbackDetailException if a feedback detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeedbackDetail remove(int PORTAL_FEEDBACK_DTL_ID)
		throws NoSuchFeedbackDetailException, SystemException {
		return remove((Serializable)PORTAL_FEEDBACK_DTL_ID);
	}

	/**
	 * Removes the feedback detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the feedback detail
	 * @return the feedback detail that was removed
	 * @throws com.ihg.grs.common.NoSuchFeedbackDetailException if a feedback detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeedbackDetail remove(Serializable primaryKey)
		throws NoSuchFeedbackDetailException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FeedbackDetail feedbackDetail = (FeedbackDetail)session.get(FeedbackDetailImpl.class,
					primaryKey);

			if (feedbackDetail == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFeedbackDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(feedbackDetail);
		}
		catch (NoSuchFeedbackDetailException nsee) {
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
	protected FeedbackDetail removeImpl(FeedbackDetail feedbackDetail)
		throws SystemException {
		feedbackDetail = toUnwrappedModel(feedbackDetail);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(feedbackDetail)) {
				feedbackDetail = (FeedbackDetail)session.get(FeedbackDetailImpl.class,
						feedbackDetail.getPrimaryKeyObj());
			}

			if (feedbackDetail != null) {
				session.delete(feedbackDetail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (feedbackDetail != null) {
			clearCache(feedbackDetail);
		}

		return feedbackDetail;
	}

	@Override
	public FeedbackDetail updateImpl(
		com.ihg.grs.common.model.FeedbackDetail feedbackDetail)
		throws SystemException {
		feedbackDetail = toUnwrappedModel(feedbackDetail);

		boolean isNew = feedbackDetail.isNew();

		Session session = null;

		try {
			session = openSession();

			if (feedbackDetail.isNew()) {
				session.save(feedbackDetail);

				feedbackDetail.setNew(false);
			}
			else {
				session.evict(feedbackDetail);
				session.saveOrUpdate(feedbackDetail);
			}

			session.flush();
			session.clear();
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

		EntityCacheUtil.putResult(FeedbackDetailModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackDetailImpl.class, feedbackDetail.getPrimaryKey(),
			feedbackDetail);

		feedbackDetail.resetOriginalValues();

		return feedbackDetail;
	}

	protected FeedbackDetail toUnwrappedModel(FeedbackDetail feedbackDetail) {
		if (feedbackDetail instanceof FeedbackDetailImpl) {
			return feedbackDetail;
		}

		FeedbackDetailImpl feedbackDetailImpl = new FeedbackDetailImpl();

		feedbackDetailImpl.setNew(feedbackDetail.isNew());
		feedbackDetailImpl.setPrimaryKey(feedbackDetail.getPrimaryKey());

		feedbackDetailImpl.setPORTAL_FEEDBACK_DTL_ID(feedbackDetail.getPORTAL_FEEDBACK_DTL_ID());
		feedbackDetailImpl.setFeedbackId(feedbackDetail.getFeedbackId());
		feedbackDetailImpl.setFeedbackType(feedbackDetail.getFeedbackType());
		feedbackDetailImpl.setSubject(feedbackDetail.getSubject());
		feedbackDetailImpl.setMessage(feedbackDetail.getMessage());
		feedbackDetailImpl.setFileName(feedbackDetail.getFileName());
		feedbackDetailImpl.setFileContent(feedbackDetail.getFileContent());
		feedbackDetailImpl.setCreateUserId(feedbackDetail.getCreateUserId());
		feedbackDetailImpl.setCreatedate(feedbackDetail.getCreatedate());
		feedbackDetailImpl.setLastUpdateUserId(feedbackDetail.getLastUpdateUserId());
		feedbackDetailImpl.setUpdatedate(feedbackDetail.getUpdatedate());

		return feedbackDetailImpl;
	}

	/**
	 * Returns the feedback detail with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the feedback detail
	 * @return the feedback detail
	 * @throws com.ihg.grs.common.NoSuchFeedbackDetailException if a feedback detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeedbackDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFeedbackDetailException, SystemException {
		FeedbackDetail feedbackDetail = fetchByPrimaryKey(primaryKey);

		if (feedbackDetail == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFeedbackDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return feedbackDetail;
	}

	/**
	 * Returns the feedback detail with the primary key or throws a {@link com.ihg.grs.common.NoSuchFeedbackDetailException} if it could not be found.
	 *
	 * @param PORTAL_FEEDBACK_DTL_ID the primary key of the feedback detail
	 * @return the feedback detail
	 * @throws com.ihg.grs.common.NoSuchFeedbackDetailException if a feedback detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeedbackDetail findByPrimaryKey(int PORTAL_FEEDBACK_DTL_ID)
		throws NoSuchFeedbackDetailException, SystemException {
		return findByPrimaryKey((Serializable)PORTAL_FEEDBACK_DTL_ID);
	}

	/**
	 * Returns the feedback detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the feedback detail
	 * @return the feedback detail, or <code>null</code> if a feedback detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeedbackDetail fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FeedbackDetail feedbackDetail = (FeedbackDetail)EntityCacheUtil.getResult(FeedbackDetailModelImpl.ENTITY_CACHE_ENABLED,
				FeedbackDetailImpl.class, primaryKey);

		if (feedbackDetail == _nullFeedbackDetail) {
			return null;
		}

		if (feedbackDetail == null) {
			Session session = null;

			try {
				session = openSession();

				feedbackDetail = (FeedbackDetail)session.get(FeedbackDetailImpl.class,
						primaryKey);

				if (feedbackDetail != null) {
					cacheResult(feedbackDetail);
				}
				else {
					EntityCacheUtil.putResult(FeedbackDetailModelImpl.ENTITY_CACHE_ENABLED,
						FeedbackDetailImpl.class, primaryKey,
						_nullFeedbackDetail);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FeedbackDetailModelImpl.ENTITY_CACHE_ENABLED,
					FeedbackDetailImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return feedbackDetail;
	}

	/**
	 * Returns the feedback detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param PORTAL_FEEDBACK_DTL_ID the primary key of the feedback detail
	 * @return the feedback detail, or <code>null</code> if a feedback detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeedbackDetail fetchByPrimaryKey(int PORTAL_FEEDBACK_DTL_ID)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)PORTAL_FEEDBACK_DTL_ID);
	}

	/**
	 * Returns all the feedback details.
	 *
	 * @return the feedback details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FeedbackDetail> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<FeedbackDetail> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<FeedbackDetail> findAll(int start, int end,
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

		List<FeedbackDetail> list = (List<FeedbackDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FEEDBACKDETAIL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FEEDBACKDETAIL;

				if (pagination) {
					sql = sql.concat(FeedbackDetailModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FeedbackDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FeedbackDetail>(list);
				}
				else {
					list = (List<FeedbackDetail>)QueryUtil.list(q,
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
	 * Removes all the feedback details from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FeedbackDetail feedbackDetail : findAll()) {
			remove(feedbackDetail);
		}
	}

	/**
	 * Returns the number of feedback details.
	 *
	 * @return the number of feedback details
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

				Query q = session.createQuery(_SQL_COUNT_FEEDBACKDETAIL);

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
	 * Initializes the feedback detail persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.grs.common.model.FeedbackDetail")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FeedbackDetail>> listenersList = new ArrayList<ModelListener<FeedbackDetail>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FeedbackDetail>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FeedbackDetailImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FEEDBACKDETAIL = "SELECT feedbackDetail FROM FeedbackDetail feedbackDetail";
	private static final String _SQL_COUNT_FEEDBACKDETAIL = "SELECT COUNT(feedbackDetail) FROM FeedbackDetail feedbackDetail";
	private static final String _ORDER_BY_ENTITY_ALIAS = "feedbackDetail.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FeedbackDetail exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FeedbackDetailPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"feedbackId", "feedbackType", "subject", "message", "fileName",
				"fileContent", "createUserId", "createdate", "lastUpdateUserId",
				"updatedate"
			});
	private static FeedbackDetail _nullFeedbackDetail = new FeedbackDetailImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FeedbackDetail> toCacheModel() {
				return _nullFeedbackDetailCacheModel;
			}
		};

	private static CacheModel<FeedbackDetail> _nullFeedbackDetailCacheModel = new CacheModel<FeedbackDetail>() {
			@Override
			public FeedbackDetail toEntityModel() {
				return _nullFeedbackDetail;
			}
		};
}