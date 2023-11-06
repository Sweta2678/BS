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

import com.ihg.brandstandards.db.NoSuchUIElementException;
import com.ihg.brandstandards.db.model.UIElement;
import com.ihg.brandstandards.db.model.impl.UIElementImpl;
import com.ihg.brandstandards.db.model.impl.UIElementModelImpl;

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
 * The persistence implementation for the u i element service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see UIElementPersistence
 * @see UIElementUtil
 * @generated
 */
public class UIElementPersistenceImpl extends BasePersistenceImpl<UIElement>
	implements UIElementPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UIElementUtil} to access the u i element persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UIElementImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UIElementModelImpl.ENTITY_CACHE_ENABLED,
			UIElementModelImpl.FINDER_CACHE_ENABLED, UIElementImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UIElementModelImpl.ENTITY_CACHE_ENABLED,
			UIElementModelImpl.FINDER_CACHE_ENABLED, UIElementImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UIElementModelImpl.ENTITY_CACHE_ENABLED,
			UIElementModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_ELEMENTKEY = new FinderPath(UIElementModelImpl.ENTITY_CACHE_ENABLED,
			UIElementModelImpl.FINDER_CACHE_ENABLED, UIElementImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByElementKey",
			new String[] { String.class.getName() },
			UIElementModelImpl.ELEMENTKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ELEMENTKEY = new FinderPath(UIElementModelImpl.ENTITY_CACHE_ENABLED,
			UIElementModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByElementKey",
			new String[] { String.class.getName() });

	/**
	 * Returns the u i element where elementKey = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchUIElementException} if it could not be found.
	 *
	 * @param elementKey the element key
	 * @return the matching u i element
	 * @throws com.ihg.brandstandards.db.NoSuchUIElementException if a matching u i element could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElement findByElementKey(String elementKey)
		throws NoSuchUIElementException, SystemException {
		UIElement uiElement = fetchByElementKey(elementKey);

		if (uiElement == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("elementKey=");
			msg.append(elementKey);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUIElementException(msg.toString());
		}

		return uiElement;
	}

	/**
	 * Returns the u i element where elementKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param elementKey the element key
	 * @return the matching u i element, or <code>null</code> if a matching u i element could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElement fetchByElementKey(String elementKey)
		throws SystemException {
		return fetchByElementKey(elementKey, true);
	}

	/**
	 * Returns the u i element where elementKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param elementKey the element key
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching u i element, or <code>null</code> if a matching u i element could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElement fetchByElementKey(String elementKey,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { elementKey };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ELEMENTKEY,
					finderArgs, this);
		}

		if (result instanceof UIElement) {
			UIElement uiElement = (UIElement)result;

			if (!Validator.equals(elementKey, uiElement.getElementKey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_UIELEMENT_WHERE);

			boolean bindElementKey = false;

			if (elementKey == null) {
				query.append(_FINDER_COLUMN_ELEMENTKEY_ELEMENTKEY_1);
			}
			else if (elementKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ELEMENTKEY_ELEMENTKEY_3);
			}
			else {
				bindElementKey = true;

				query.append(_FINDER_COLUMN_ELEMENTKEY_ELEMENTKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindElementKey) {
					qPos.add(elementKey);
				}

				List<UIElement> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ELEMENTKEY,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"UIElementPersistenceImpl.fetchByElementKey(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					UIElement uiElement = list.get(0);

					result = uiElement;

					cacheResult(uiElement);

					if ((uiElement.getElementKey() == null) ||
							!uiElement.getElementKey().equals(elementKey)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ELEMENTKEY,
							finderArgs, uiElement);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ELEMENTKEY,
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
			return (UIElement)result;
		}
	}

	/**
	 * Removes the u i element where elementKey = &#63; from the database.
	 *
	 * @param elementKey the element key
	 * @return the u i element that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElement removeByElementKey(String elementKey)
		throws NoSuchUIElementException, SystemException {
		UIElement uiElement = findByElementKey(elementKey);

		return remove(uiElement);
	}

	/**
	 * Returns the number of u i elements where elementKey = &#63;.
	 *
	 * @param elementKey the element key
	 * @return the number of matching u i elements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByElementKey(String elementKey) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ELEMENTKEY;

		Object[] finderArgs = new Object[] { elementKey };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_UIELEMENT_WHERE);

			boolean bindElementKey = false;

			if (elementKey == null) {
				query.append(_FINDER_COLUMN_ELEMENTKEY_ELEMENTKEY_1);
			}
			else if (elementKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ELEMENTKEY_ELEMENTKEY_3);
			}
			else {
				bindElementKey = true;

				query.append(_FINDER_COLUMN_ELEMENTKEY_ELEMENTKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindElementKey) {
					qPos.add(elementKey);
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

	private static final String _FINDER_COLUMN_ELEMENTKEY_ELEMENTKEY_1 = "uiElement.elementKey IS NULL";
	private static final String _FINDER_COLUMN_ELEMENTKEY_ELEMENTKEY_2 = "uiElement.elementKey = ?";
	private static final String _FINDER_COLUMN_ELEMENTKEY_ELEMENTKEY_3 = "(uiElement.elementKey IS NULL OR uiElement.elementKey = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MODULENAME =
		new FinderPath(UIElementModelImpl.ENTITY_CACHE_ENABLED,
			UIElementModelImpl.FINDER_CACHE_ENABLED, UIElementImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByModuleName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODULENAME =
		new FinderPath(UIElementModelImpl.ENTITY_CACHE_ENABLED,
			UIElementModelImpl.FINDER_CACHE_ENABLED, UIElementImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByModuleName",
			new String[] { String.class.getName() },
			UIElementModelImpl.MODULENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MODULENAME = new FinderPath(UIElementModelImpl.ENTITY_CACHE_ENABLED,
			UIElementModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByModuleName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the u i elements where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @return the matching u i elements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UIElement> findByModuleName(String moduleName)
		throws SystemException {
		return findByModuleName(moduleName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the u i elements where moduleName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UIElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param moduleName the module name
	 * @param start the lower bound of the range of u i elements
	 * @param end the upper bound of the range of u i elements (not inclusive)
	 * @return the range of matching u i elements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UIElement> findByModuleName(String moduleName, int start,
		int end) throws SystemException {
		return findByModuleName(moduleName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the u i elements where moduleName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UIElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param moduleName the module name
	 * @param start the lower bound of the range of u i elements
	 * @param end the upper bound of the range of u i elements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching u i elements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UIElement> findByModuleName(String moduleName, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODULENAME;
			finderArgs = new Object[] { moduleName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MODULENAME;
			finderArgs = new Object[] { moduleName, start, end, orderByComparator };
		}

		List<UIElement> list = (List<UIElement>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UIElement uiElement : list) {
				if (!Validator.equals(moduleName, uiElement.getModuleName())) {
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

			query.append(_SQL_SELECT_UIELEMENT_WHERE);

			boolean bindModuleName = false;

			if (moduleName == null) {
				query.append(_FINDER_COLUMN_MODULENAME_MODULENAME_1);
			}
			else if (moduleName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MODULENAME_MODULENAME_3);
			}
			else {
				bindModuleName = true;

				query.append(_FINDER_COLUMN_MODULENAME_MODULENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UIElementModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindModuleName) {
					qPos.add(moduleName);
				}

				if (!pagination) {
					list = (List<UIElement>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UIElement>(list);
				}
				else {
					list = (List<UIElement>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first u i element in the ordered set where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching u i element
	 * @throws com.ihg.brandstandards.db.NoSuchUIElementException if a matching u i element could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElement findByModuleName_First(String moduleName,
		OrderByComparator orderByComparator)
		throws NoSuchUIElementException, SystemException {
		UIElement uiElement = fetchByModuleName_First(moduleName,
				orderByComparator);

		if (uiElement != null) {
			return uiElement;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("moduleName=");
		msg.append(moduleName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUIElementException(msg.toString());
	}

	/**
	 * Returns the first u i element in the ordered set where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching u i element, or <code>null</code> if a matching u i element could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElement fetchByModuleName_First(String moduleName,
		OrderByComparator orderByComparator) throws SystemException {
		List<UIElement> list = findByModuleName(moduleName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last u i element in the ordered set where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching u i element
	 * @throws com.ihg.brandstandards.db.NoSuchUIElementException if a matching u i element could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElement findByModuleName_Last(String moduleName,
		OrderByComparator orderByComparator)
		throws NoSuchUIElementException, SystemException {
		UIElement uiElement = fetchByModuleName_Last(moduleName,
				orderByComparator);

		if (uiElement != null) {
			return uiElement;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("moduleName=");
		msg.append(moduleName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUIElementException(msg.toString());
	}

	/**
	 * Returns the last u i element in the ordered set where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching u i element, or <code>null</code> if a matching u i element could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElement fetchByModuleName_Last(String moduleName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByModuleName(moduleName);

		if (count == 0) {
			return null;
		}

		List<UIElement> list = findByModuleName(moduleName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the u i elements before and after the current u i element in the ordered set where moduleName = &#63;.
	 *
	 * @param elementId the primary key of the current u i element
	 * @param moduleName the module name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next u i element
	 * @throws com.ihg.brandstandards.db.NoSuchUIElementException if a u i element with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElement[] findByModuleName_PrevAndNext(long elementId,
		String moduleName, OrderByComparator orderByComparator)
		throws NoSuchUIElementException, SystemException {
		UIElement uiElement = findByPrimaryKey(elementId);

		Session session = null;

		try {
			session = openSession();

			UIElement[] array = new UIElementImpl[3];

			array[0] = getByModuleName_PrevAndNext(session, uiElement,
					moduleName, orderByComparator, true);

			array[1] = uiElement;

			array[2] = getByModuleName_PrevAndNext(session, uiElement,
					moduleName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UIElement getByModuleName_PrevAndNext(Session session,
		UIElement uiElement, String moduleName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_UIELEMENT_WHERE);

		boolean bindModuleName = false;

		if (moduleName == null) {
			query.append(_FINDER_COLUMN_MODULENAME_MODULENAME_1);
		}
		else if (moduleName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_MODULENAME_MODULENAME_3);
		}
		else {
			bindModuleName = true;

			query.append(_FINDER_COLUMN_MODULENAME_MODULENAME_2);
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
			query.append(UIElementModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindModuleName) {
			qPos.add(moduleName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(uiElement);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UIElement> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the u i elements where moduleName = &#63; from the database.
	 *
	 * @param moduleName the module name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByModuleName(String moduleName) throws SystemException {
		for (UIElement uiElement : findByModuleName(moduleName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(uiElement);
		}
	}

	/**
	 * Returns the number of u i elements where moduleName = &#63;.
	 *
	 * @param moduleName the module name
	 * @return the number of matching u i elements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByModuleName(String moduleName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MODULENAME;

		Object[] finderArgs = new Object[] { moduleName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_UIELEMENT_WHERE);

			boolean bindModuleName = false;

			if (moduleName == null) {
				query.append(_FINDER_COLUMN_MODULENAME_MODULENAME_1);
			}
			else if (moduleName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_MODULENAME_MODULENAME_3);
			}
			else {
				bindModuleName = true;

				query.append(_FINDER_COLUMN_MODULENAME_MODULENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindModuleName) {
					qPos.add(moduleName);
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

	private static final String _FINDER_COLUMN_MODULENAME_MODULENAME_1 = "uiElement.moduleName IS NULL";
	private static final String _FINDER_COLUMN_MODULENAME_MODULENAME_2 = "uiElement.moduleName = ?";
	private static final String _FINDER_COLUMN_MODULENAME_MODULENAME_3 = "(uiElement.moduleName IS NULL OR uiElement.moduleName = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_KEYANDMODULENAME = new FinderPath(UIElementModelImpl.ENTITY_CACHE_ENABLED,
			UIElementModelImpl.FINDER_CACHE_ENABLED, UIElementImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByKeyAndModuleName",
			new String[] { String.class.getName(), String.class.getName() },
			UIElementModelImpl.ELEMENTKEY_COLUMN_BITMASK |
			UIElementModelImpl.MODULENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_KEYANDMODULENAME = new FinderPath(UIElementModelImpl.ENTITY_CACHE_ENABLED,
			UIElementModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByKeyAndModuleName",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the u i element where elementKey = &#63; and moduleName = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchUIElementException} if it could not be found.
	 *
	 * @param elementKey the element key
	 * @param moduleName the module name
	 * @return the matching u i element
	 * @throws com.ihg.brandstandards.db.NoSuchUIElementException if a matching u i element could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElement findByKeyAndModuleName(String elementKey, String moduleName)
		throws NoSuchUIElementException, SystemException {
		UIElement uiElement = fetchByKeyAndModuleName(elementKey, moduleName);

		if (uiElement == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("elementKey=");
			msg.append(elementKey);

			msg.append(", moduleName=");
			msg.append(moduleName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUIElementException(msg.toString());
		}

		return uiElement;
	}

	/**
	 * Returns the u i element where elementKey = &#63; and moduleName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param elementKey the element key
	 * @param moduleName the module name
	 * @return the matching u i element, or <code>null</code> if a matching u i element could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElement fetchByKeyAndModuleName(String elementKey,
		String moduleName) throws SystemException {
		return fetchByKeyAndModuleName(elementKey, moduleName, true);
	}

	/**
	 * Returns the u i element where elementKey = &#63; and moduleName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param elementKey the element key
	 * @param moduleName the module name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching u i element, or <code>null</code> if a matching u i element could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElement fetchByKeyAndModuleName(String elementKey,
		String moduleName, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { elementKey, moduleName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_KEYANDMODULENAME,
					finderArgs, this);
		}

		if (result instanceof UIElement) {
			UIElement uiElement = (UIElement)result;

			if (!Validator.equals(elementKey, uiElement.getElementKey()) ||
					!Validator.equals(moduleName, uiElement.getModuleName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_UIELEMENT_WHERE);

			boolean bindElementKey = false;

			if (elementKey == null) {
				query.append(_FINDER_COLUMN_KEYANDMODULENAME_ELEMENTKEY_1);
			}
			else if (elementKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_KEYANDMODULENAME_ELEMENTKEY_3);
			}
			else {
				bindElementKey = true;

				query.append(_FINDER_COLUMN_KEYANDMODULENAME_ELEMENTKEY_2);
			}

			boolean bindModuleName = false;

			if (moduleName == null) {
				query.append(_FINDER_COLUMN_KEYANDMODULENAME_MODULENAME_1);
			}
			else if (moduleName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_KEYANDMODULENAME_MODULENAME_3);
			}
			else {
				bindModuleName = true;

				query.append(_FINDER_COLUMN_KEYANDMODULENAME_MODULENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindElementKey) {
					qPos.add(elementKey);
				}

				if (bindModuleName) {
					qPos.add(moduleName);
				}

				List<UIElement> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEYANDMODULENAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"UIElementPersistenceImpl.fetchByKeyAndModuleName(String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					UIElement uiElement = list.get(0);

					result = uiElement;

					cacheResult(uiElement);

					if ((uiElement.getElementKey() == null) ||
							!uiElement.getElementKey().equals(elementKey) ||
							(uiElement.getModuleName() == null) ||
							!uiElement.getModuleName().equals(moduleName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEYANDMODULENAME,
							finderArgs, uiElement);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEYANDMODULENAME,
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
			return (UIElement)result;
		}
	}

	/**
	 * Removes the u i element where elementKey = &#63; and moduleName = &#63; from the database.
	 *
	 * @param elementKey the element key
	 * @param moduleName the module name
	 * @return the u i element that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElement removeByKeyAndModuleName(String elementKey,
		String moduleName) throws NoSuchUIElementException, SystemException {
		UIElement uiElement = findByKeyAndModuleName(elementKey, moduleName);

		return remove(uiElement);
	}

	/**
	 * Returns the number of u i elements where elementKey = &#63; and moduleName = &#63;.
	 *
	 * @param elementKey the element key
	 * @param moduleName the module name
	 * @return the number of matching u i elements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByKeyAndModuleName(String elementKey, String moduleName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_KEYANDMODULENAME;

		Object[] finderArgs = new Object[] { elementKey, moduleName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_UIELEMENT_WHERE);

			boolean bindElementKey = false;

			if (elementKey == null) {
				query.append(_FINDER_COLUMN_KEYANDMODULENAME_ELEMENTKEY_1);
			}
			else if (elementKey.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_KEYANDMODULENAME_ELEMENTKEY_3);
			}
			else {
				bindElementKey = true;

				query.append(_FINDER_COLUMN_KEYANDMODULENAME_ELEMENTKEY_2);
			}

			boolean bindModuleName = false;

			if (moduleName == null) {
				query.append(_FINDER_COLUMN_KEYANDMODULENAME_MODULENAME_1);
			}
			else if (moduleName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_KEYANDMODULENAME_MODULENAME_3);
			}
			else {
				bindModuleName = true;

				query.append(_FINDER_COLUMN_KEYANDMODULENAME_MODULENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindElementKey) {
					qPos.add(elementKey);
				}

				if (bindModuleName) {
					qPos.add(moduleName);
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

	private static final String _FINDER_COLUMN_KEYANDMODULENAME_ELEMENTKEY_1 = "uiElement.elementKey IS NULL AND ";
	private static final String _FINDER_COLUMN_KEYANDMODULENAME_ELEMENTKEY_2 = "uiElement.elementKey = ? AND ";
	private static final String _FINDER_COLUMN_KEYANDMODULENAME_ELEMENTKEY_3 = "(uiElement.elementKey IS NULL OR uiElement.elementKey = '') AND ";
	private static final String _FINDER_COLUMN_KEYANDMODULENAME_MODULENAME_1 = "uiElement.moduleName IS NULL";
	private static final String _FINDER_COLUMN_KEYANDMODULENAME_MODULENAME_2 = "uiElement.moduleName = ?";
	private static final String _FINDER_COLUMN_KEYANDMODULENAME_MODULENAME_3 = "(uiElement.moduleName IS NULL OR uiElement.moduleName = '')";

	public UIElementPersistenceImpl() {
		setModelClass(UIElement.class);
	}

	/**
	 * Caches the u i element in the entity cache if it is enabled.
	 *
	 * @param uiElement the u i element
	 */
	@Override
	public void cacheResult(UIElement uiElement) {
		EntityCacheUtil.putResult(UIElementModelImpl.ENTITY_CACHE_ENABLED,
			UIElementImpl.class, uiElement.getPrimaryKey(), uiElement);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ELEMENTKEY,
			new Object[] { uiElement.getElementKey() }, uiElement);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEYANDMODULENAME,
			new Object[] { uiElement.getElementKey(), uiElement.getModuleName() },
			uiElement);

		uiElement.resetOriginalValues();
	}

	/**
	 * Caches the u i elements in the entity cache if it is enabled.
	 *
	 * @param uiElements the u i elements
	 */
	@Override
	public void cacheResult(List<UIElement> uiElements) {
		for (UIElement uiElement : uiElements) {
			if (EntityCacheUtil.getResult(
						UIElementModelImpl.ENTITY_CACHE_ENABLED,
						UIElementImpl.class, uiElement.getPrimaryKey()) == null) {
				cacheResult(uiElement);
			}
			else {
				uiElement.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all u i elements.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UIElementImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UIElementImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the u i element.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UIElement uiElement) {
		EntityCacheUtil.removeResult(UIElementModelImpl.ENTITY_CACHE_ENABLED,
			UIElementImpl.class, uiElement.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(uiElement);
	}

	@Override
	public void clearCache(List<UIElement> uiElements) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UIElement uiElement : uiElements) {
			EntityCacheUtil.removeResult(UIElementModelImpl.ENTITY_CACHE_ENABLED,
				UIElementImpl.class, uiElement.getPrimaryKey());

			clearUniqueFindersCache(uiElement);
		}
	}

	protected void cacheUniqueFindersCache(UIElement uiElement) {
		if (uiElement.isNew()) {
			Object[] args = new Object[] { uiElement.getElementKey() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ELEMENTKEY, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ELEMENTKEY, args,
				uiElement);

			args = new Object[] {
					uiElement.getElementKey(), uiElement.getModuleName()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KEYANDMODULENAME,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEYANDMODULENAME,
				args, uiElement);
		}
		else {
			UIElementModelImpl uiElementModelImpl = (UIElementModelImpl)uiElement;

			if ((uiElementModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ELEMENTKEY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { uiElement.getElementKey() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ELEMENTKEY,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ELEMENTKEY,
					args, uiElement);
			}

			if ((uiElementModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_KEYANDMODULENAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						uiElement.getElementKey(), uiElement.getModuleName()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KEYANDMODULENAME,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEYANDMODULENAME,
					args, uiElement);
			}
		}
	}

	protected void clearUniqueFindersCache(UIElement uiElement) {
		UIElementModelImpl uiElementModelImpl = (UIElementModelImpl)uiElement;

		Object[] args = new Object[] { uiElement.getElementKey() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ELEMENTKEY, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ELEMENTKEY, args);

		if ((uiElementModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ELEMENTKEY.getColumnBitmask()) != 0) {
			args = new Object[] { uiElementModelImpl.getOriginalElementKey() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ELEMENTKEY, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ELEMENTKEY, args);
		}

		args = new Object[] { uiElement.getElementKey(), uiElement.getModuleName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KEYANDMODULENAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEYANDMODULENAME, args);

		if ((uiElementModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_KEYANDMODULENAME.getColumnBitmask()) != 0) {
			args = new Object[] {
					uiElementModelImpl.getOriginalElementKey(),
					uiElementModelImpl.getOriginalModuleName()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KEYANDMODULENAME,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEYANDMODULENAME,
				args);
		}
	}

	/**
	 * Creates a new u i element with the primary key. Does not add the u i element to the database.
	 *
	 * @param elementId the primary key for the new u i element
	 * @return the new u i element
	 */
	@Override
	public UIElement create(long elementId) {
		UIElement uiElement = new UIElementImpl();

		uiElement.setNew(true);
		uiElement.setPrimaryKey(elementId);

		return uiElement;
	}

	/**
	 * Removes the u i element with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param elementId the primary key of the u i element
	 * @return the u i element that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchUIElementException if a u i element with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElement remove(long elementId)
		throws NoSuchUIElementException, SystemException {
		return remove((Serializable)elementId);
	}

	/**
	 * Removes the u i element with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the u i element
	 * @return the u i element that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchUIElementException if a u i element with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElement remove(Serializable primaryKey)
		throws NoSuchUIElementException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UIElement uiElement = (UIElement)session.get(UIElementImpl.class,
					primaryKey);

			if (uiElement == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUIElementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(uiElement);
		}
		catch (NoSuchUIElementException nsee) {
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
	protected UIElement removeImpl(UIElement uiElement)
		throws SystemException {
		uiElement = toUnwrappedModel(uiElement);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(uiElement)) {
				uiElement = (UIElement)session.get(UIElementImpl.class,
						uiElement.getPrimaryKeyObj());
			}

			if (uiElement != null) {
				session.delete(uiElement);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (uiElement != null) {
			clearCache(uiElement);
		}

		return uiElement;
	}

	@Override
	public UIElement updateImpl(
		com.ihg.brandstandards.db.model.UIElement uiElement)
		throws SystemException {
		uiElement = toUnwrappedModel(uiElement);

		boolean isNew = uiElement.isNew();

		UIElementModelImpl uiElementModelImpl = (UIElementModelImpl)uiElement;

		Session session = null;

		try {
			session = openSession();

			if (uiElement.isNew()) {
				session.save(uiElement);

				uiElement.setNew(false);
			}
			else {
				session.merge(uiElement);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UIElementModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((uiElementModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODULENAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						uiElementModelImpl.getOriginalModuleName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MODULENAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODULENAME,
					args);

				args = new Object[] { uiElementModelImpl.getModuleName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MODULENAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MODULENAME,
					args);
			}
		}

		EntityCacheUtil.putResult(UIElementModelImpl.ENTITY_CACHE_ENABLED,
			UIElementImpl.class, uiElement.getPrimaryKey(), uiElement);

		clearUniqueFindersCache(uiElement);
		cacheUniqueFindersCache(uiElement);

		return uiElement;
	}

	protected UIElement toUnwrappedModel(UIElement uiElement) {
		if (uiElement instanceof UIElementImpl) {
			return uiElement;
		}

		UIElementImpl uiElementImpl = new UIElementImpl();

		uiElementImpl.setNew(uiElement.isNew());
		uiElementImpl.setPrimaryKey(uiElement.getPrimaryKey());

		uiElementImpl.setElementId(uiElement.getElementId());
		uiElementImpl.setElementKey(uiElement.getElementKey());
		uiElementImpl.setModuleName(uiElement.getModuleName());
		uiElementImpl.setCreatorId(uiElement.getCreatorId());
		uiElementImpl.setCreatedDate(uiElement.getCreatedDate());
		uiElementImpl.setUpdatedBy(uiElement.getUpdatedBy());
		uiElementImpl.setUpdatedDate(uiElement.getUpdatedDate());

		return uiElementImpl;
	}

	/**
	 * Returns the u i element with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the u i element
	 * @return the u i element
	 * @throws com.ihg.brandstandards.db.NoSuchUIElementException if a u i element with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElement findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUIElementException, SystemException {
		UIElement uiElement = fetchByPrimaryKey(primaryKey);

		if (uiElement == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUIElementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return uiElement;
	}

	/**
	 * Returns the u i element with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchUIElementException} if it could not be found.
	 *
	 * @param elementId the primary key of the u i element
	 * @return the u i element
	 * @throws com.ihg.brandstandards.db.NoSuchUIElementException if a u i element with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElement findByPrimaryKey(long elementId)
		throws NoSuchUIElementException, SystemException {
		return findByPrimaryKey((Serializable)elementId);
	}

	/**
	 * Returns the u i element with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the u i element
	 * @return the u i element, or <code>null</code> if a u i element with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElement fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UIElement uiElement = (UIElement)EntityCacheUtil.getResult(UIElementModelImpl.ENTITY_CACHE_ENABLED,
				UIElementImpl.class, primaryKey);

		if (uiElement == _nullUIElement) {
			return null;
		}

		if (uiElement == null) {
			Session session = null;

			try {
				session = openSession();

				uiElement = (UIElement)session.get(UIElementImpl.class,
						primaryKey);

				if (uiElement != null) {
					cacheResult(uiElement);
				}
				else {
					EntityCacheUtil.putResult(UIElementModelImpl.ENTITY_CACHE_ENABLED,
						UIElementImpl.class, primaryKey, _nullUIElement);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UIElementModelImpl.ENTITY_CACHE_ENABLED,
					UIElementImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return uiElement;
	}

	/**
	 * Returns the u i element with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param elementId the primary key of the u i element
	 * @return the u i element, or <code>null</code> if a u i element with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UIElement fetchByPrimaryKey(long elementId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)elementId);
	}

	/**
	 * Returns all the u i elements.
	 *
	 * @return the u i elements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UIElement> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the u i elements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UIElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of u i elements
	 * @param end the upper bound of the range of u i elements (not inclusive)
	 * @return the range of u i elements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UIElement> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the u i elements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UIElementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of u i elements
	 * @param end the upper bound of the range of u i elements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of u i elements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UIElement> findAll(int start, int end,
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

		List<UIElement> list = (List<UIElement>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_UIELEMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_UIELEMENT;

				if (pagination) {
					sql = sql.concat(UIElementModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UIElement>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UIElement>(list);
				}
				else {
					list = (List<UIElement>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the u i elements from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UIElement uiElement : findAll()) {
			remove(uiElement);
		}
	}

	/**
	 * Returns the number of u i elements.
	 *
	 * @return the number of u i elements
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

				Query q = session.createQuery(_SQL_COUNT_UIELEMENT);

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
	 * Initializes the u i element persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.UIElement")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UIElement>> listenersList = new ArrayList<ModelListener<UIElement>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UIElement>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UIElementImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_UIELEMENT = "SELECT uiElement FROM UIElement uiElement";
	private static final String _SQL_SELECT_UIELEMENT_WHERE = "SELECT uiElement FROM UIElement uiElement WHERE ";
	private static final String _SQL_COUNT_UIELEMENT = "SELECT COUNT(uiElement) FROM UIElement uiElement";
	private static final String _SQL_COUNT_UIELEMENT_WHERE = "SELECT COUNT(uiElement) FROM UIElement uiElement WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "uiElement.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UIElement exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UIElement exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UIElementPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"elementId", "elementKey", "moduleName", "creatorId",
				"createdDate", "updatedBy", "updatedDate"
			});
	private static UIElement _nullUIElement = new UIElementImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UIElement> toCacheModel() {
				return _nullUIElementCacheModel;
			}
		};

	private static CacheModel<UIElement> _nullUIElementCacheModel = new CacheModel<UIElement>() {
			@Override
			public UIElement toEntityModel() {
				return _nullUIElement;
			}
		};
}