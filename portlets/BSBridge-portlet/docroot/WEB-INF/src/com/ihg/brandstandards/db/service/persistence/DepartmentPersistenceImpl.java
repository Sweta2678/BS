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

import com.ihg.brandstandards.db.NoSuchDepartmentException;
import com.ihg.brandstandards.db.model.Department;
import com.ihg.brandstandards.db.model.impl.DepartmentImpl;
import com.ihg.brandstandards.db.model.impl.DepartmentModelImpl;

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
 * The persistence implementation for the department service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see DepartmentPersistence
 * @see DepartmentUtil
 * @generated
 */
public class DepartmentPersistenceImpl extends BasePersistenceImpl<Department>
	implements DepartmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DepartmentUtil} to access the department persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DepartmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
			DepartmentModelImpl.FINDER_CACHE_ENABLED, DepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
			DepartmentModelImpl.FINDER_CACHE_ENABLED, DepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
			DepartmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVEINDICATOR =
		new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
			DepartmentModelImpl.FINDER_CACHE_ENABLED, DepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActiveIndicator",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVEINDICATOR =
		new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
			DepartmentModelImpl.FINDER_CACHE_ENABLED, DepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActiveIndicator",
			new String[] { String.class.getName() },
			DepartmentModelImpl.ACTIVEIND_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVEINDICATOR = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
			DepartmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByActiveIndicator", new String[] { String.class.getName() });

	/**
	 * Returns all the departments where activeInd = &#63;.
	 *
	 * @param activeInd the active ind
	 * @return the matching departments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Department> findByActiveIndicator(String activeInd)
		throws SystemException {
		return findByActiveIndicator(activeInd, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the departments where activeInd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param activeInd the active ind
	 * @param start the lower bound of the range of departments
	 * @param end the upper bound of the range of departments (not inclusive)
	 * @return the range of matching departments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Department> findByActiveIndicator(String activeInd, int start,
		int end) throws SystemException {
		return findByActiveIndicator(activeInd, start, end, null);
	}

	/**
	 * Returns an ordered range of all the departments where activeInd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param activeInd the active ind
	 * @param start the lower bound of the range of departments
	 * @param end the upper bound of the range of departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching departments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Department> findByActiveIndicator(String activeInd, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVEINDICATOR;
			finderArgs = new Object[] { activeInd };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVEINDICATOR;
			finderArgs = new Object[] { activeInd, start, end, orderByComparator };
		}

		List<Department> list = (List<Department>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Department department : list) {
				if (!Validator.equals(activeInd, department.getActiveInd())) {
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

			query.append(_SQL_SELECT_DEPARTMENT_WHERE);

			boolean bindActiveInd = false;

			if (activeInd == null) {
				query.append(_FINDER_COLUMN_ACTIVEINDICATOR_ACTIVEIND_1);
			}
			else if (activeInd.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ACTIVEINDICATOR_ACTIVEIND_3);
			}
			else {
				bindActiveInd = true;

				query.append(_FINDER_COLUMN_ACTIVEINDICATOR_ACTIVEIND_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DepartmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindActiveInd) {
					qPos.add(activeInd.toLowerCase());
				}

				if (!pagination) {
					list = (List<Department>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Department>(list);
				}
				else {
					list = (List<Department>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first department in the ordered set where activeInd = &#63;.
	 *
	 * @param activeInd the active ind
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department
	 * @throws com.ihg.brandstandards.db.NoSuchDepartmentException if a matching department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Department findByActiveIndicator_First(String activeInd,
		OrderByComparator orderByComparator)
		throws NoSuchDepartmentException, SystemException {
		Department department = fetchByActiveIndicator_First(activeInd,
				orderByComparator);

		if (department != null) {
			return department;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("activeInd=");
		msg.append(activeInd);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDepartmentException(msg.toString());
	}

	/**
	 * Returns the first department in the ordered set where activeInd = &#63;.
	 *
	 * @param activeInd the active ind
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department, or <code>null</code> if a matching department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Department fetchByActiveIndicator_First(String activeInd,
		OrderByComparator orderByComparator) throws SystemException {
		List<Department> list = findByActiveIndicator(activeInd, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last department in the ordered set where activeInd = &#63;.
	 *
	 * @param activeInd the active ind
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department
	 * @throws com.ihg.brandstandards.db.NoSuchDepartmentException if a matching department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Department findByActiveIndicator_Last(String activeInd,
		OrderByComparator orderByComparator)
		throws NoSuchDepartmentException, SystemException {
		Department department = fetchByActiveIndicator_Last(activeInd,
				orderByComparator);

		if (department != null) {
			return department;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("activeInd=");
		msg.append(activeInd);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDepartmentException(msg.toString());
	}

	/**
	 * Returns the last department in the ordered set where activeInd = &#63;.
	 *
	 * @param activeInd the active ind
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department, or <code>null</code> if a matching department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Department fetchByActiveIndicator_Last(String activeInd,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByActiveIndicator(activeInd);

		if (count == 0) {
			return null;
		}

		List<Department> list = findByActiveIndicator(activeInd, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the departments before and after the current department in the ordered set where activeInd = &#63;.
	 *
	 * @param departmentId the primary key of the current department
	 * @param activeInd the active ind
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next department
	 * @throws com.ihg.brandstandards.db.NoSuchDepartmentException if a department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Department[] findByActiveIndicator_PrevAndNext(long departmentId,
		String activeInd, OrderByComparator orderByComparator)
		throws NoSuchDepartmentException, SystemException {
		Department department = findByPrimaryKey(departmentId);

		Session session = null;

		try {
			session = openSession();

			Department[] array = new DepartmentImpl[3];

			array[0] = getByActiveIndicator_PrevAndNext(session, department,
					activeInd, orderByComparator, true);

			array[1] = department;

			array[2] = getByActiveIndicator_PrevAndNext(session, department,
					activeInd, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Department getByActiveIndicator_PrevAndNext(Session session,
		Department department, String activeInd,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DEPARTMENT_WHERE);

		boolean bindActiveInd = false;

		if (activeInd == null) {
			query.append(_FINDER_COLUMN_ACTIVEINDICATOR_ACTIVEIND_1);
		}
		else if (activeInd.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ACTIVEINDICATOR_ACTIVEIND_3);
		}
		else {
			bindActiveInd = true;

			query.append(_FINDER_COLUMN_ACTIVEINDICATOR_ACTIVEIND_2);
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
			query.append(DepartmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindActiveInd) {
			qPos.add(activeInd.toLowerCase());
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(department);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Department> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the departments where activeInd = &#63; from the database.
	 *
	 * @param activeInd the active ind
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByActiveIndicator(String activeInd)
		throws SystemException {
		for (Department department : findByActiveIndicator(activeInd,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(department);
		}
	}

	/**
	 * Returns the number of departments where activeInd = &#63;.
	 *
	 * @param activeInd the active ind
	 * @return the number of matching departments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByActiveIndicator(String activeInd)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ACTIVEINDICATOR;

		Object[] finderArgs = new Object[] { activeInd };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DEPARTMENT_WHERE);

			boolean bindActiveInd = false;

			if (activeInd == null) {
				query.append(_FINDER_COLUMN_ACTIVEINDICATOR_ACTIVEIND_1);
			}
			else if (activeInd.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ACTIVEINDICATOR_ACTIVEIND_3);
			}
			else {
				bindActiveInd = true;

				query.append(_FINDER_COLUMN_ACTIVEINDICATOR_ACTIVEIND_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindActiveInd) {
					qPos.add(activeInd.toLowerCase());
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

	private static final String _FINDER_COLUMN_ACTIVEINDICATOR_ACTIVEIND_1 = "department.activeInd IS NULL";
	private static final String _FINDER_COLUMN_ACTIVEINDICATOR_ACTIVEIND_2 = "lower(department.activeInd) = ?";
	private static final String _FINDER_COLUMN_ACTIVEINDICATOR_ACTIVEIND_3 = "(department.activeInd IS NULL OR department.activeInd = '')";

	public DepartmentPersistenceImpl() {
		setModelClass(Department.class);
	}

	/**
	 * Caches the department in the entity cache if it is enabled.
	 *
	 * @param department the department
	 */
	@Override
	public void cacheResult(Department department) {
		EntityCacheUtil.putResult(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
			DepartmentImpl.class, department.getPrimaryKey(), department);

		department.resetOriginalValues();
	}

	/**
	 * Caches the departments in the entity cache if it is enabled.
	 *
	 * @param departments the departments
	 */
	@Override
	public void cacheResult(List<Department> departments) {
		for (Department department : departments) {
			if (EntityCacheUtil.getResult(
						DepartmentModelImpl.ENTITY_CACHE_ENABLED,
						DepartmentImpl.class, department.getPrimaryKey()) == null) {
				cacheResult(department);
			}
			else {
				department.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all departments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DepartmentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DepartmentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the department.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Department department) {
		EntityCacheUtil.removeResult(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
			DepartmentImpl.class, department.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Department> departments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Department department : departments) {
			EntityCacheUtil.removeResult(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
				DepartmentImpl.class, department.getPrimaryKey());
		}
	}

	/**
	 * Creates a new department with the primary key. Does not add the department to the database.
	 *
	 * @param departmentId the primary key for the new department
	 * @return the new department
	 */
	@Override
	public Department create(long departmentId) {
		Department department = new DepartmentImpl();

		department.setNew(true);
		department.setPrimaryKey(departmentId);

		return department;
	}

	/**
	 * Removes the department with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param departmentId the primary key of the department
	 * @return the department that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchDepartmentException if a department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Department remove(long departmentId)
		throws NoSuchDepartmentException, SystemException {
		return remove((Serializable)departmentId);
	}

	/**
	 * Removes the department with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the department
	 * @return the department that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchDepartmentException if a department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Department remove(Serializable primaryKey)
		throws NoSuchDepartmentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Department department = (Department)session.get(DepartmentImpl.class,
					primaryKey);

			if (department == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDepartmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(department);
		}
		catch (NoSuchDepartmentException nsee) {
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
	protected Department removeImpl(Department department)
		throws SystemException {
		department = toUnwrappedModel(department);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(department)) {
				department = (Department)session.get(DepartmentImpl.class,
						department.getPrimaryKeyObj());
			}

			if (department != null) {
				session.delete(department);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (department != null) {
			clearCache(department);
		}

		return department;
	}

	@Override
	public Department updateImpl(
		com.ihg.brandstandards.db.model.Department department)
		throws SystemException {
		department = toUnwrappedModel(department);

		boolean isNew = department.isNew();

		DepartmentModelImpl departmentModelImpl = (DepartmentModelImpl)department;

		Session session = null;

		try {
			session = openSession();

			if (department.isNew()) {
				session.save(department);

				department.setNew(false);
			}
			else {
				session.merge(department);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DepartmentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((departmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVEINDICATOR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						departmentModelImpl.getOriginalActiveInd()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVEINDICATOR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVEINDICATOR,
					args);

				args = new Object[] { departmentModelImpl.getActiveInd() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVEINDICATOR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVEINDICATOR,
					args);
			}
		}

		EntityCacheUtil.putResult(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
			DepartmentImpl.class, department.getPrimaryKey(), department);

		return department;
	}

	protected Department toUnwrappedModel(Department department) {
		if (department instanceof DepartmentImpl) {
			return department;
		}

		DepartmentImpl departmentImpl = new DepartmentImpl();

		departmentImpl.setNew(department.isNew());
		departmentImpl.setPrimaryKey(department.getPrimaryKey());

		departmentImpl.setDepartmentId(department.getDepartmentId());
		departmentImpl.setDepartmentName(department.getDepartmentName());
		departmentImpl.setDescription(department.getDescription());
		departmentImpl.setActiveInd(department.getActiveInd());
		departmentImpl.setCreatorId(department.getCreatorId());
		departmentImpl.setCreatedDate(department.getCreatedDate());
		departmentImpl.setUpdatedBy(department.getUpdatedBy());
		departmentImpl.setUpdatedDate(department.getUpdatedDate());

		return departmentImpl;
	}

	/**
	 * Returns the department with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the department
	 * @return the department
	 * @throws com.ihg.brandstandards.db.NoSuchDepartmentException if a department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Department findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDepartmentException, SystemException {
		Department department = fetchByPrimaryKey(primaryKey);

		if (department == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDepartmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return department;
	}

	/**
	 * Returns the department with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchDepartmentException} if it could not be found.
	 *
	 * @param departmentId the primary key of the department
	 * @return the department
	 * @throws com.ihg.brandstandards.db.NoSuchDepartmentException if a department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Department findByPrimaryKey(long departmentId)
		throws NoSuchDepartmentException, SystemException {
		return findByPrimaryKey((Serializable)departmentId);
	}

	/**
	 * Returns the department with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the department
	 * @return the department, or <code>null</code> if a department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Department fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Department department = (Department)EntityCacheUtil.getResult(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
				DepartmentImpl.class, primaryKey);

		if (department == _nullDepartment) {
			return null;
		}

		if (department == null) {
			Session session = null;

			try {
				session = openSession();

				department = (Department)session.get(DepartmentImpl.class,
						primaryKey);

				if (department != null) {
					cacheResult(department);
				}
				else {
					EntityCacheUtil.putResult(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
						DepartmentImpl.class, primaryKey, _nullDepartment);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
					DepartmentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return department;
	}

	/**
	 * Returns the department with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param departmentId the primary key of the department
	 * @return the department, or <code>null</code> if a department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Department fetchByPrimaryKey(long departmentId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)departmentId);
	}

	/**
	 * Returns all the departments.
	 *
	 * @return the departments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Department> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the departments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of departments
	 * @param end the upper bound of the range of departments (not inclusive)
	 * @return the range of departments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Department> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the departments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of departments
	 * @param end the upper bound of the range of departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of departments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Department> findAll(int start, int end,
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

		List<Department> list = (List<Department>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DEPARTMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DEPARTMENT;

				if (pagination) {
					sql = sql.concat(DepartmentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Department>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Department>(list);
				}
				else {
					list = (List<Department>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the departments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Department department : findAll()) {
			remove(department);
		}
	}

	/**
	 * Returns the number of departments.
	 *
	 * @return the number of departments
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

				Query q = session.createQuery(_SQL_COUNT_DEPARTMENT);

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
	 * Initializes the department persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.Department")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Department>> listenersList = new ArrayList<ModelListener<Department>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Department>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DepartmentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DEPARTMENT = "SELECT department FROM Department department";
	private static final String _SQL_SELECT_DEPARTMENT_WHERE = "SELECT department FROM Department department WHERE ";
	private static final String _SQL_COUNT_DEPARTMENT = "SELECT COUNT(department) FROM Department department";
	private static final String _SQL_COUNT_DEPARTMENT_WHERE = "SELECT COUNT(department) FROM Department department WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "department.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Department exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Department exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DepartmentPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"departmentId", "departmentName", "description", "activeInd",
				"creatorId", "createdDate", "updatedBy", "updatedDate"
			});
	private static Department _nullDepartment = new DepartmentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Department> toCacheModel() {
				return _nullDepartmentCacheModel;
			}
		};

	private static CacheModel<Department> _nullDepartmentCacheModel = new CacheModel<Department>() {
			@Override
			public Department toEntityModel() {
				return _nullDepartment;
			}
		};
}