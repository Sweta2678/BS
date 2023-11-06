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

import com.ihg.brandstandards.db.NoSuchUIElementTranslateException;
import com.ihg.brandstandards.db.model.UIElementTranslate;
import com.ihg.brandstandards.db.model.impl.UIElementTranslateImpl;
import com.ihg.brandstandards.db.model.impl.UIElementTranslateModelImpl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the u i element translate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see UIElementTranslatePersistence
 * @see UIElementTranslateUtil
 * @generated
 */
public class UIElementTranslatePersistenceImpl extends BasePersistenceImpl<UIElementTranslate>
	implements UIElementTranslatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UIElementTranslateUtil} to access the u i element translate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UIElementTranslateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UIElementTranslateModelImpl.ENTITY_CACHE_ENABLED,
			UIElementTranslateModelImpl.FINDER_CACHE_ENABLED,
			UIElementTranslateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UIElementTranslateModelImpl.ENTITY_CACHE_ENABLED,
			UIElementTranslateModelImpl.FINDER_CACHE_ENABLED,
			UIElementTranslateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UIElementTranslateModelImpl.ENTITY_CACHE_ENABLED,
			UIElementTranslateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ELEMENTID =
		new FinderPath(UIElementTranslateModelImpl.ENTITY_CACHE_ENABLED,
			UIElementTranslateModelImpl.FINDER_CACHE_ENABLED,
			UIElementTranslateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByElementId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ELEMENTID =
		new FinderPath(UIElementTranslateModelImpl.ENTITY_CACHE_ENABLED,
			UIElementTranslateModelImpl.FINDER_CACHE_ENABLED,
			UIElementTranslateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByElementId",
			new String[] { Long.class.getName() },
			UIElementTranslateModelImpl.ELEMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ELEMENTID = new FinderPath(UIElementTranslateModelImpl.ENTITY_CACHE_ENABLED,
			UIElementTranslateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByElementId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the u i element translates where elementId = &#63;.
	 *
	 * @param elementId the element ID
	 * @return the matching u i element translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UIElementTranslate> findByElementId(long elementId)
		throws SystemException {
		return findByElementId(elementId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the u i element translates where elementId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UIElementTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param elementId the element ID
	 * @param start the lower bound of the range of u i element translates
	 * @param end the upper bound of the range of u i element translates (not inclusive)
	 * @return the range of matching u i element translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UIElementTranslate> findByElementId(long elementId, int start,
		int end) throws SystemException {
		return findByElementId(elementId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the u i element translates where elementId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UIElementTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param elementId the element ID
	 * @param start the lower bound of the range of u i element translates
	 * @param end the upper bound of the range of u i element translates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching u i element translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UIElementTranslate> findByElementId(long elementId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ELEMENTID;
			finderArgs = new Object[] { elementId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ELEMENTID;
			finderArgs = new Object[] { elementId, start, end, orderByComparator };
		}

		List<UIElementTranslate> list = (List<UIElementTranslate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UIElementTranslate uiElementTranslate : list) {
				if ((elementId != uiElementTranslate.getElementId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_UIELEMENTTRANSLATE_WHERE);

			query.append(_FINDER_COLUMN_ELEMENTID_ELEMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UIElementTranslateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(elementId);

				if (!pagination) {
					list = (List<UIElementTranslate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UIElementTranslate>(list);
				}
				else {
					list = (List<UIElementTranslate>)QueryUtil.list(q,
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
	 * Returns the first u i element translate in the ordered set where elementId = &#63;.
	 *
	 * @param elementId the element ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching u i element translate
	 * @throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException if a matching u i element translate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElementTranslate findByElementId_First(long elementId,
		OrderByComparator orderByComparator)
		throws NoSuchUIElementTranslateException, SystemException {
		UIElementTranslate uiElementTranslate = fetchByElementId_First(elementId,
				orderByComparator);

		if (uiElementTranslate != null) {
			return uiElementTranslate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("elementId=");
		msg.append(elementId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUIElementTranslateException(msg.toString());
	}

	/**
	 * Returns the first u i element translate in the ordered set where elementId = &#63;.
	 *
	 * @param elementId the element ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching u i element translate, or <code>null</code> if a matching u i element translate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElementTranslate fetchByElementId_First(long elementId,
		OrderByComparator orderByComparator) throws SystemException {
		List<UIElementTranslate> list = findByElementId(elementId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last u i element translate in the ordered set where elementId = &#63;.
	 *
	 * @param elementId the element ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching u i element translate
	 * @throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException if a matching u i element translate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElementTranslate findByElementId_Last(long elementId,
		OrderByComparator orderByComparator)
		throws NoSuchUIElementTranslateException, SystemException {
		UIElementTranslate uiElementTranslate = fetchByElementId_Last(elementId,
				orderByComparator);

		if (uiElementTranslate != null) {
			return uiElementTranslate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("elementId=");
		msg.append(elementId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUIElementTranslateException(msg.toString());
	}

	/**
	 * Returns the last u i element translate in the ordered set where elementId = &#63;.
	 *
	 * @param elementId the element ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching u i element translate, or <code>null</code> if a matching u i element translate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElementTranslate fetchByElementId_Last(long elementId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByElementId(elementId);

		if (count == 0) {
			return null;
		}

		List<UIElementTranslate> list = findByElementId(elementId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the u i element translates before and after the current u i element translate in the ordered set where elementId = &#63;.
	 *
	 * @param uiElementTranslatePK the primary key of the current u i element translate
	 * @param elementId the element ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next u i element translate
	 * @throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException if a u i element translate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElementTranslate[] findByElementId_PrevAndNext(
		UIElementTranslatePK uiElementTranslatePK, long elementId,
		OrderByComparator orderByComparator)
		throws NoSuchUIElementTranslateException, SystemException {
		UIElementTranslate uiElementTranslate = findByPrimaryKey(uiElementTranslatePK);

		Session session = null;

		try {
			session = openSession();

			UIElementTranslate[] array = new UIElementTranslateImpl[3];

			array[0] = getByElementId_PrevAndNext(session, uiElementTranslate,
					elementId, orderByComparator, true);

			array[1] = uiElementTranslate;

			array[2] = getByElementId_PrevAndNext(session, uiElementTranslate,
					elementId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UIElementTranslate getByElementId_PrevAndNext(Session session,
		UIElementTranslate uiElementTranslate, long elementId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_UIELEMENTTRANSLATE_WHERE);

		query.append(_FINDER_COLUMN_ELEMENTID_ELEMENTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(UIElementTranslateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(elementId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(uiElementTranslate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UIElementTranslate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the u i element translates where elementId = &#63; from the database.
	 *
	 * @param elementId the element ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByElementId(long elementId) throws SystemException {
		for (UIElementTranslate uiElementTranslate : findByElementId(
				elementId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(uiElementTranslate);
		}
	}

	/**
	 * Returns the number of u i element translates where elementId = &#63;.
	 *
	 * @param elementId the element ID
	 * @return the number of matching u i element translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByElementId(long elementId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ELEMENTID;

		Object[] finderArgs = new Object[] { elementId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_UIELEMENTTRANSLATE_WHERE);

			query.append(_FINDER_COLUMN_ELEMENTID_ELEMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(elementId);

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

	private static final String _FINDER_COLUMN_ELEMENTID_ELEMENTID_2 = "uiElementTranslate.id.elementId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LOCALECODE =
		new FinderPath(UIElementTranslateModelImpl.ENTITY_CACHE_ENABLED,
			UIElementTranslateModelImpl.FINDER_CACHE_ENABLED,
			UIElementTranslateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLocaleCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCALECODE =
		new FinderPath(UIElementTranslateModelImpl.ENTITY_CACHE_ENABLED,
			UIElementTranslateModelImpl.FINDER_CACHE_ENABLED,
			UIElementTranslateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLocaleCode",
			new String[] { String.class.getName() },
			UIElementTranslateModelImpl.LOCALECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LOCALECODE = new FinderPath(UIElementTranslateModelImpl.ENTITY_CACHE_ENABLED,
			UIElementTranslateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLocaleCode",
			new String[] { String.class.getName() });

	/**
	 * Returns all the u i element translates where localeCode = &#63;.
	 *
	 * @param localeCode the locale code
	 * @return the matching u i element translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UIElementTranslate> findByLocaleCode(String localeCode)
		throws SystemException {
		return findByLocaleCode(localeCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the u i element translates where localeCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UIElementTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param localeCode the locale code
	 * @param start the lower bound of the range of u i element translates
	 * @param end the upper bound of the range of u i element translates (not inclusive)
	 * @return the range of matching u i element translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UIElementTranslate> findByLocaleCode(String localeCode,
		int start, int end) throws SystemException {
		return findByLocaleCode(localeCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the u i element translates where localeCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UIElementTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param localeCode the locale code
	 * @param start the lower bound of the range of u i element translates
	 * @param end the upper bound of the range of u i element translates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching u i element translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UIElementTranslate> findByLocaleCode(String localeCode,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCALECODE;
			finderArgs = new Object[] { localeCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LOCALECODE;
			finderArgs = new Object[] { localeCode, start, end, orderByComparator };
		}

		List<UIElementTranslate> list = (List<UIElementTranslate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UIElementTranslate uiElementTranslate : list) {
				if (!Validator.equals(localeCode,
							uiElementTranslate.getLocaleCode())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_UIELEMENTTRANSLATE_WHERE);

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_LOCALECODE_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LOCALECODE_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_LOCALECODE_LOCALECODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UIElementTranslateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLocaleCode) {
					qPos.add(localeCode);
				}

				if (!pagination) {
					list = (List<UIElementTranslate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UIElementTranslate>(list);
				}
				else {
					list = (List<UIElementTranslate>)QueryUtil.list(q,
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
	 * Returns the first u i element translate in the ordered set where localeCode = &#63;.
	 *
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching u i element translate
	 * @throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException if a matching u i element translate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElementTranslate findByLocaleCode_First(String localeCode,
		OrderByComparator orderByComparator)
		throws NoSuchUIElementTranslateException, SystemException {
		UIElementTranslate uiElementTranslate = fetchByLocaleCode_First(localeCode,
				orderByComparator);

		if (uiElementTranslate != null) {
			return uiElementTranslate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("localeCode=");
		msg.append(localeCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUIElementTranslateException(msg.toString());
	}

	/**
	 * Returns the first u i element translate in the ordered set where localeCode = &#63;.
	 *
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching u i element translate, or <code>null</code> if a matching u i element translate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElementTranslate fetchByLocaleCode_First(String localeCode,
		OrderByComparator orderByComparator) throws SystemException {
		List<UIElementTranslate> list = findByLocaleCode(localeCode, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last u i element translate in the ordered set where localeCode = &#63;.
	 *
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching u i element translate
	 * @throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException if a matching u i element translate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElementTranslate findByLocaleCode_Last(String localeCode,
		OrderByComparator orderByComparator)
		throws NoSuchUIElementTranslateException, SystemException {
		UIElementTranslate uiElementTranslate = fetchByLocaleCode_Last(localeCode,
				orderByComparator);

		if (uiElementTranslate != null) {
			return uiElementTranslate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("localeCode=");
		msg.append(localeCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUIElementTranslateException(msg.toString());
	}

	/**
	 * Returns the last u i element translate in the ordered set where localeCode = &#63;.
	 *
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching u i element translate, or <code>null</code> if a matching u i element translate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElementTranslate fetchByLocaleCode_Last(String localeCode,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLocaleCode(localeCode);

		if (count == 0) {
			return null;
		}

		List<UIElementTranslate> list = findByLocaleCode(localeCode, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the u i element translates before and after the current u i element translate in the ordered set where localeCode = &#63;.
	 *
	 * @param uiElementTranslatePK the primary key of the current u i element translate
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next u i element translate
	 * @throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException if a u i element translate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElementTranslate[] findByLocaleCode_PrevAndNext(
		UIElementTranslatePK uiElementTranslatePK, String localeCode,
		OrderByComparator orderByComparator)
		throws NoSuchUIElementTranslateException, SystemException {
		UIElementTranslate uiElementTranslate = findByPrimaryKey(uiElementTranslatePK);

		Session session = null;

		try {
			session = openSession();

			UIElementTranslate[] array = new UIElementTranslateImpl[3];

			array[0] = getByLocaleCode_PrevAndNext(session, uiElementTranslate,
					localeCode, orderByComparator, true);

			array[1] = uiElementTranslate;

			array[2] = getByLocaleCode_PrevAndNext(session, uiElementTranslate,
					localeCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UIElementTranslate getByLocaleCode_PrevAndNext(Session session,
		UIElementTranslate uiElementTranslate, String localeCode,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_UIELEMENTTRANSLATE_WHERE);

		boolean bindLocaleCode = false;

		if (localeCode == null) {
			query.append(_FINDER_COLUMN_LOCALECODE_LOCALECODE_1);
		}
		else if (localeCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_LOCALECODE_LOCALECODE_3);
		}
		else {
			bindLocaleCode = true;

			query.append(_FINDER_COLUMN_LOCALECODE_LOCALECODE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(UIElementTranslateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLocaleCode) {
			qPos.add(localeCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(uiElementTranslate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UIElementTranslate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the u i element translates where localeCode = &#63; from the database.
	 *
	 * @param localeCode the locale code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLocaleCode(String localeCode) throws SystemException {
		for (UIElementTranslate uiElementTranslate : findByLocaleCode(
				localeCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(uiElementTranslate);
		}
	}

	/**
	 * Returns the number of u i element translates where localeCode = &#63;.
	 *
	 * @param localeCode the locale code
	 * @return the number of matching u i element translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLocaleCode(String localeCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LOCALECODE;

		Object[] finderArgs = new Object[] { localeCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_UIELEMENTTRANSLATE_WHERE);

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_LOCALECODE_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LOCALECODE_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_LOCALECODE_LOCALECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLocaleCode) {
					qPos.add(localeCode);
				}

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

	private static final String _FINDER_COLUMN_LOCALECODE_LOCALECODE_1 = "uiElementTranslate.id.localeCode IS NULL";
	private static final String _FINDER_COLUMN_LOCALECODE_LOCALECODE_2 = "uiElementTranslate.id.localeCode = ?";
	private static final String _FINDER_COLUMN_LOCALECODE_LOCALECODE_3 = "(uiElementTranslate.id.localeCode IS NULL OR uiElementTranslate.id.localeCode = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_IDANDLOCALECODE = new FinderPath(UIElementTranslateModelImpl.ENTITY_CACHE_ENABLED,
			UIElementTranslateModelImpl.FINDER_CACHE_ENABLED,
			UIElementTranslateImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByIdAndLocaleCode",
			new String[] { Long.class.getName(), String.class.getName() },
			UIElementTranslateModelImpl.ELEMENTID_COLUMN_BITMASK |
			UIElementTranslateModelImpl.LOCALECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IDANDLOCALECODE = new FinderPath(UIElementTranslateModelImpl.ENTITY_CACHE_ENABLED,
			UIElementTranslateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByIdAndLocaleCode",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the u i element translate where elementId = &#63; and localeCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchUIElementTranslateException} if it could not be found.
	 *
	 * @param elementId the element ID
	 * @param localeCode the locale code
	 * @return the matching u i element translate
	 * @throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException if a matching u i element translate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElementTranslate findByIdAndLocaleCode(long elementId,
		String localeCode)
		throws NoSuchUIElementTranslateException, SystemException {
		UIElementTranslate uiElementTranslate = fetchByIdAndLocaleCode(elementId,
				localeCode);

		if (uiElementTranslate == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("elementId=");
			msg.append(elementId);

			msg.append(", localeCode=");
			msg.append(localeCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUIElementTranslateException(msg.toString());
		}

		return uiElementTranslate;
	}

	/**
	 * Returns the u i element translate where elementId = &#63; and localeCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param elementId the element ID
	 * @param localeCode the locale code
	 * @return the matching u i element translate, or <code>null</code> if a matching u i element translate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElementTranslate fetchByIdAndLocaleCode(long elementId,
		String localeCode) throws SystemException {
		return fetchByIdAndLocaleCode(elementId, localeCode, true);
	}

	/**
	 * Returns the u i element translate where elementId = &#63; and localeCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param elementId the element ID
	 * @param localeCode the locale code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching u i element translate, or <code>null</code> if a matching u i element translate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElementTranslate fetchByIdAndLocaleCode(long elementId,
		String localeCode, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { elementId, localeCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_IDANDLOCALECODE,
					finderArgs, this);
		}

		if (result instanceof UIElementTranslate) {
			UIElementTranslate uiElementTranslate = (UIElementTranslate)result;

			if ((elementId != uiElementTranslate.getElementId()) ||
					!Validator.equals(localeCode,
						uiElementTranslate.getLocaleCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_UIELEMENTTRANSLATE_WHERE);

			query.append(_FINDER_COLUMN_IDANDLOCALECODE_ELEMENTID_2);

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_IDANDLOCALECODE_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_IDANDLOCALECODE_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_IDANDLOCALECODE_LOCALECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(elementId);

				if (bindLocaleCode) {
					qPos.add(localeCode);
				}

				List<UIElementTranslate> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDANDLOCALECODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"UIElementTranslatePersistenceImpl.fetchByIdAndLocaleCode(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					UIElementTranslate uiElementTranslate = list.get(0);

					result = uiElementTranslate;

					cacheResult(uiElementTranslate);

					if ((uiElementTranslate.getElementId() != elementId) ||
							(uiElementTranslate.getLocaleCode() == null) ||
							!uiElementTranslate.getLocaleCode()
												   .equals(localeCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDANDLOCALECODE,
							finderArgs, uiElementTranslate);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IDANDLOCALECODE,
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
			return (UIElementTranslate)result;
		}
	}

	/**
	 * Removes the u i element translate where elementId = &#63; and localeCode = &#63; from the database.
	 *
	 * @param elementId the element ID
	 * @param localeCode the locale code
	 * @return the u i element translate that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElementTranslate removeByIdAndLocaleCode(long elementId,
		String localeCode)
		throws NoSuchUIElementTranslateException, SystemException {
		UIElementTranslate uiElementTranslate = findByIdAndLocaleCode(elementId,
				localeCode);

		return remove(uiElementTranslate);
	}

	/**
	 * Returns the number of u i element translates where elementId = &#63; and localeCode = &#63;.
	 *
	 * @param elementId the element ID
	 * @param localeCode the locale code
	 * @return the number of matching u i element translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByIdAndLocaleCode(long elementId, String localeCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IDANDLOCALECODE;

		Object[] finderArgs = new Object[] { elementId, localeCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_UIELEMENTTRANSLATE_WHERE);

			query.append(_FINDER_COLUMN_IDANDLOCALECODE_ELEMENTID_2);

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_IDANDLOCALECODE_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_IDANDLOCALECODE_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_IDANDLOCALECODE_LOCALECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(elementId);

				if (bindLocaleCode) {
					qPos.add(localeCode);
				}

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

	private static final String _FINDER_COLUMN_IDANDLOCALECODE_ELEMENTID_2 = "uiElementTranslate.id.elementId = ? AND ";
	private static final String _FINDER_COLUMN_IDANDLOCALECODE_LOCALECODE_1 = "uiElementTranslate.id.localeCode IS NULL";
	private static final String _FINDER_COLUMN_IDANDLOCALECODE_LOCALECODE_2 = "uiElementTranslate.id.localeCode = ?";
	private static final String _FINDER_COLUMN_IDANDLOCALECODE_LOCALECODE_3 = "(uiElementTranslate.id.localeCode IS NULL OR uiElementTranslate.id.localeCode = '')";

	public UIElementTranslatePersistenceImpl() {
		setModelClass(UIElementTranslate.class);
	}

	/**
	 * Caches the u i element translate in the entity cache if it is enabled.
	 *
	 * @param uiElementTranslate the u i element translate
	 */
	@Override
	public void cacheResult(UIElementTranslate uiElementTranslate) {
		EntityCacheUtil.putResult(UIElementTranslateModelImpl.ENTITY_CACHE_ENABLED,
			UIElementTranslateImpl.class, uiElementTranslate.getPrimaryKey(),
			uiElementTranslate);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDANDLOCALECODE,
			new Object[] {
				uiElementTranslate.getElementId(),
				uiElementTranslate.getLocaleCode()
			}, uiElementTranslate);

		uiElementTranslate.resetOriginalValues();
	}

	/**
	 * Caches the u i element translates in the entity cache if it is enabled.
	 *
	 * @param uiElementTranslates the u i element translates
	 */
	@Override
	public void cacheResult(List<UIElementTranslate> uiElementTranslates) {
		for (UIElementTranslate uiElementTranslate : uiElementTranslates) {
			if (EntityCacheUtil.getResult(
						UIElementTranslateModelImpl.ENTITY_CACHE_ENABLED,
						UIElementTranslateImpl.class,
						uiElementTranslate.getPrimaryKey()) == null) {
				cacheResult(uiElementTranslate);
			}
			else {
				uiElementTranslate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all u i element translates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UIElementTranslateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UIElementTranslateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the u i element translate.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UIElementTranslate uiElementTranslate) {
		EntityCacheUtil.removeResult(UIElementTranslateModelImpl.ENTITY_CACHE_ENABLED,
			UIElementTranslateImpl.class, uiElementTranslate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(uiElementTranslate);
	}

	@Override
	public void clearCache(List<UIElementTranslate> uiElementTranslates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UIElementTranslate uiElementTranslate : uiElementTranslates) {
			EntityCacheUtil.removeResult(UIElementTranslateModelImpl.ENTITY_CACHE_ENABLED,
				UIElementTranslateImpl.class, uiElementTranslate.getPrimaryKey());

			clearUniqueFindersCache(uiElementTranslate);
		}
	}

	protected void cacheUniqueFindersCache(
		UIElementTranslate uiElementTranslate) {
		if (uiElementTranslate.isNew()) {
			Object[] args = new Object[] {
					uiElementTranslate.getElementId(),
					uiElementTranslate.getLocaleCode()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IDANDLOCALECODE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDANDLOCALECODE,
				args, uiElementTranslate);
		}
		else {
			UIElementTranslateModelImpl uiElementTranslateModelImpl = (UIElementTranslateModelImpl)uiElementTranslate;

			if ((uiElementTranslateModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_IDANDLOCALECODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						uiElementTranslate.getElementId(),
						uiElementTranslate.getLocaleCode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IDANDLOCALECODE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDANDLOCALECODE,
					args, uiElementTranslate);
			}
		}
	}

	protected void clearUniqueFindersCache(
		UIElementTranslate uiElementTranslate) {
		UIElementTranslateModelImpl uiElementTranslateModelImpl = (UIElementTranslateModelImpl)uiElementTranslate;

		Object[] args = new Object[] {
				uiElementTranslate.getElementId(),
				uiElementTranslate.getLocaleCode()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDANDLOCALECODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IDANDLOCALECODE, args);

		if ((uiElementTranslateModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_IDANDLOCALECODE.getColumnBitmask()) != 0) {
			args = new Object[] {
					uiElementTranslateModelImpl.getOriginalElementId(),
					uiElementTranslateModelImpl.getOriginalLocaleCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDANDLOCALECODE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IDANDLOCALECODE,
				args);
		}
	}

	/**
	 * Creates a new u i element translate with the primary key. Does not add the u i element translate to the database.
	 *
	 * @param uiElementTranslatePK the primary key for the new u i element translate
	 * @return the new u i element translate
	 */
	@Override
	public UIElementTranslate create(UIElementTranslatePK uiElementTranslatePK) {
		UIElementTranslate uiElementTranslate = new UIElementTranslateImpl();

		uiElementTranslate.setNew(true);
		uiElementTranslate.setPrimaryKey(uiElementTranslatePK);

		return uiElementTranslate;
	}

	/**
	 * Removes the u i element translate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param uiElementTranslatePK the primary key of the u i element translate
	 * @return the u i element translate that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException if a u i element translate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElementTranslate remove(UIElementTranslatePK uiElementTranslatePK)
		throws NoSuchUIElementTranslateException, SystemException {
		return remove((Serializable)uiElementTranslatePK);
	}

	/**
	 * Removes the u i element translate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the u i element translate
	 * @return the u i element translate that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException if a u i element translate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElementTranslate remove(Serializable primaryKey)
		throws NoSuchUIElementTranslateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UIElementTranslate uiElementTranslate = (UIElementTranslate)session.get(UIElementTranslateImpl.class,
					primaryKey);

			if (uiElementTranslate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUIElementTranslateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(uiElementTranslate);
		}
		catch (NoSuchUIElementTranslateException nsee) {
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
	protected UIElementTranslate removeImpl(
		UIElementTranslate uiElementTranslate) throws SystemException {
		uiElementTranslate = toUnwrappedModel(uiElementTranslate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(uiElementTranslate)) {
				uiElementTranslate = (UIElementTranslate)session.get(UIElementTranslateImpl.class,
						uiElementTranslate.getPrimaryKeyObj());
			}

			if (uiElementTranslate != null) {
				session.delete(uiElementTranslate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (uiElementTranslate != null) {
			clearCache(uiElementTranslate);
		}

		return uiElementTranslate;
	}

	@Override
	public UIElementTranslate updateImpl(
		com.ihg.brandstandards.db.model.UIElementTranslate uiElementTranslate)
		throws SystemException {
		uiElementTranslate = toUnwrappedModel(uiElementTranslate);

		boolean isNew = uiElementTranslate.isNew();

		UIElementTranslateModelImpl uiElementTranslateModelImpl = (UIElementTranslateModelImpl)uiElementTranslate;

		Session session = null;

		try {
			session = openSession();

			if (uiElementTranslate.isNew()) {
				session.save(uiElementTranslate);

				uiElementTranslate.setNew(false);
			}
			else {
				session.merge(uiElementTranslate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UIElementTranslateModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((uiElementTranslateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ELEMENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						uiElementTranslateModelImpl.getOriginalElementId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ELEMENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ELEMENTID,
					args);

				args = new Object[] { uiElementTranslateModelImpl.getElementId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ELEMENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ELEMENTID,
					args);
			}

			if ((uiElementTranslateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCALECODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						uiElementTranslateModelImpl.getOriginalLocaleCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCALECODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCALECODE,
					args);

				args = new Object[] { uiElementTranslateModelImpl.getLocaleCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCALECODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCALECODE,
					args);
			}
		}

		EntityCacheUtil.putResult(UIElementTranslateModelImpl.ENTITY_CACHE_ENABLED,
			UIElementTranslateImpl.class, uiElementTranslate.getPrimaryKey(),
			uiElementTranslate);

		clearUniqueFindersCache(uiElementTranslate);
		cacheUniqueFindersCache(uiElementTranslate);

		return uiElementTranslate;
	}

	protected UIElementTranslate toUnwrappedModel(
		UIElementTranslate uiElementTranslate) {
		if (uiElementTranslate instanceof UIElementTranslateImpl) {
			return uiElementTranslate;
		}

		UIElementTranslateImpl uiElementTranslateImpl = new UIElementTranslateImpl();

		uiElementTranslateImpl.setNew(uiElementTranslate.isNew());
		uiElementTranslateImpl.setPrimaryKey(uiElementTranslate.getPrimaryKey());

		uiElementTranslateImpl.setElementId(uiElementTranslate.getElementId());
		uiElementTranslateImpl.setLocaleCode(uiElementTranslate.getLocaleCode());
		uiElementTranslateImpl.setElementValue(uiElementTranslate.getElementValue());
		uiElementTranslateImpl.setCreatorId(uiElementTranslate.getCreatorId());
		uiElementTranslateImpl.setCreatedDate(uiElementTranslate.getCreatedDate());
		uiElementTranslateImpl.setUpdatedBy(uiElementTranslate.getUpdatedBy());
		uiElementTranslateImpl.setUpdatedDate(uiElementTranslate.getUpdatedDate());

		return uiElementTranslateImpl;
	}

	/**
	 * Returns the u i element translate with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the u i element translate
	 * @return the u i element translate
	 * @throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException if a u i element translate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElementTranslate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUIElementTranslateException, SystemException {
		UIElementTranslate uiElementTranslate = fetchByPrimaryKey(primaryKey);

		if (uiElementTranslate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUIElementTranslateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return uiElementTranslate;
	}

	/**
	 * Returns the u i element translate with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchUIElementTranslateException} if it could not be found.
	 *
	 * @param uiElementTranslatePK the primary key of the u i element translate
	 * @return the u i element translate
	 * @throws com.ihg.brandstandards.db.NoSuchUIElementTranslateException if a u i element translate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElementTranslate findByPrimaryKey(
		UIElementTranslatePK uiElementTranslatePK)
		throws NoSuchUIElementTranslateException, SystemException {
		return findByPrimaryKey((Serializable)uiElementTranslatePK);
	}

	/**
	 * Returns the u i element translate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the u i element translate
	 * @return the u i element translate, or <code>null</code> if a u i element translate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElementTranslate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UIElementTranslate uiElementTranslate = (UIElementTranslate)EntityCacheUtil.getResult(UIElementTranslateModelImpl.ENTITY_CACHE_ENABLED,
				UIElementTranslateImpl.class, primaryKey);

		if (uiElementTranslate == _nullUIElementTranslate) {
			return null;
		}

		if (uiElementTranslate == null) {
			Session session = null;

			try {
				session = openSession();

				uiElementTranslate = (UIElementTranslate)session.get(UIElementTranslateImpl.class,
						primaryKey);

				if (uiElementTranslate != null) {
					cacheResult(uiElementTranslate);
				}
				else {
					EntityCacheUtil.putResult(UIElementTranslateModelImpl.ENTITY_CACHE_ENABLED,
						UIElementTranslateImpl.class, primaryKey,
						_nullUIElementTranslate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UIElementTranslateModelImpl.ENTITY_CACHE_ENABLED,
					UIElementTranslateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return uiElementTranslate;
	}

	/**
	 * Returns the u i element translate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param uiElementTranslatePK the primary key of the u i element translate
	 * @return the u i element translate, or <code>null</code> if a u i element translate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElementTranslate fetchByPrimaryKey(
		UIElementTranslatePK uiElementTranslatePK) throws SystemException {
		return fetchByPrimaryKey((Serializable)uiElementTranslatePK);
	}

	/**
	 * Returns all the u i element translates.
	 *
	 * @return the u i element translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UIElementTranslate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the u i element translates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UIElementTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of u i element translates
	 * @param end the upper bound of the range of u i element translates (not inclusive)
	 * @return the range of u i element translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UIElementTranslate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the u i element translates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UIElementTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of u i element translates
	 * @param end the upper bound of the range of u i element translates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of u i element translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UIElementTranslate> findAll(int start, int end,
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

		List<UIElementTranslate> list = (List<UIElementTranslate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_UIELEMENTTRANSLATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_UIELEMENTTRANSLATE;

				if (pagination) {
					sql = sql.concat(UIElementTranslateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UIElementTranslate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UIElementTranslate>(list);
				}
				else {
					list = (List<UIElementTranslate>)QueryUtil.list(q,
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
	 * Removes all the u i element translates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UIElementTranslate uiElementTranslate : findAll()) {
			remove(uiElementTranslate);
		}
	}

	/**
	 * Returns the number of u i element translates.
	 *
	 * @return the number of u i element translates
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

				Query q = session.createQuery(_SQL_COUNT_UIELEMENTTRANSLATE);

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
	 * Initializes the u i element translate persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.UIElementTranslate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UIElementTranslate>> listenersList = new ArrayList<ModelListener<UIElementTranslate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UIElementTranslate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UIElementTranslateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_UIELEMENTTRANSLATE = "SELECT uiElementTranslate FROM UIElementTranslate uiElementTranslate";
	private static final String _SQL_SELECT_UIELEMENTTRANSLATE_WHERE = "SELECT uiElementTranslate FROM UIElementTranslate uiElementTranslate WHERE ";
	private static final String _SQL_COUNT_UIELEMENTTRANSLATE = "SELECT COUNT(uiElementTranslate) FROM UIElementTranslate uiElementTranslate";
	private static final String _SQL_COUNT_UIELEMENTTRANSLATE_WHERE = "SELECT COUNT(uiElementTranslate) FROM UIElementTranslate uiElementTranslate WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "uiElementTranslate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UIElementTranslate exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UIElementTranslate exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UIElementTranslatePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"elementId", "localeCode", "elementValue", "creatorId",
				"createdDate", "updatedBy", "updatedDate"
			});
	private static UIElementTranslate _nullUIElementTranslate = new UIElementTranslateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UIElementTranslate> toCacheModel() {
				return _nullUIElementTranslateCacheModel;
			}
		};

	private static CacheModel<UIElementTranslate> _nullUIElementTranslateCacheModel =
		new CacheModel<UIElementTranslate>() {
			@Override
			public UIElementTranslate toEntityModel() {
				return _nullUIElementTranslate;
			}
		};
}