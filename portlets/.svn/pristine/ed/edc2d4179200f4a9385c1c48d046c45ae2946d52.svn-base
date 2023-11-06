package com.ihg.brandstandards.db.service.persistence;

import com.ihg.brandstandards.db.model.MustPublish;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

/**
 * 
 * @author AkhaniC
 *
 */
public class MustPublishFinderImpl extends BasePersistenceImpl<MustPublish> implements MustPublishFinder {

	Log LOG = LogFactoryUtil.getLog(MustPublishFinderImpl.class);
	/**
	 * @param query
	 * @return boolean
	 */
	public boolean deleteRegionalRecordCountries (String query) {
		boolean isDeleted = false;
		Session session = null;
		try {
			session = openSession();
			SQLQuery q = session.createSQLQuery(query.toString());
            q.executeUpdate();
            isDeleted = true;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		} finally {
			if (session != null) {
				closeSession(session);
			}
		}
		return isDeleted;
	}
}
