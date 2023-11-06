package com.ihg.brandstandards.db.service.persistence;

import java.util.List;

import com.ihg.brandstandards.db.model.UniqueGroupCountry;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class UniqueGroupCountryFinderImpl extends BasePersistenceImpl<UniqueGroupCountry> implements UniqueGroupCountryFinder {
	
	private final Log LOG = LogFactoryUtil.getLog(UniqueGroupCountryFinderImpl.class);
	/**
	 * 
	 * @param groupName
	 * @param publishId
	 * @param regionId
	 * @return String
	 */
	public String getCountryListOfUniqueGroup (String groupName, long publishId, long regionId) {
		
		Session session = null;
		String countryList = null;
		try {
			session =  openSession();
			StringBuilder queryString = new StringBuilder();
			queryString.append("SELECT listagg(ctry_nm_cd, ';') within GROUP (ORDER BY unique_grp_ctry_id) AS countryList");
			queryString.append(" from unique_grp_ctry where unique_grp_id in (select unique_grp_id from unique_grp where ");
			queryString.append(" publish_id = ");
			queryString.append(publishId);
			queryString.append(" AND rgn_id = ");
			queryString.append(regionId);
			queryString.append(" AND grp_nm = '");
			queryString.append(groupName);
			queryString.append("') group by unique_grp_id ");
			SQLQuery query = session.createSQLQuery(queryString.toString());
			List results = query.list();
			if (Validator.isNotNull(results) && results.size() > 0) {
				countryList = (String) results.get(0);
			}
			
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		} finally {
			if (session != null) {
				closeSession(session);
			}
		}
		
		return countryList;
	}

}
