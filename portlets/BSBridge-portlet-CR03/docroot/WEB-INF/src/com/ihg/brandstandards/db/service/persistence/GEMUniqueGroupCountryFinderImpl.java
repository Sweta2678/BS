package com.ihg.brandstandards.db.service.persistence;

import java.util.List;

import com.ihg.brandstandards.db.model.GEMUniqueGroupCountry;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class GEMUniqueGroupCountryFinderImpl extends BasePersistenceImpl<GEMUniqueGroupCountry> implements GEMUniqueGroupCountryFinder  {

	private final Log LOG = LogFactoryUtil.getLog(GEMUniqueGroupCountryFinderImpl.class);
	/**
	 * 
	 * @param groupName
	 * @param publishId
	 * @param regionId
	 * @return String
	 */
	public String getCountryListOfUniqueGroup (String groupName, String groupType, long publishId, long regionId) {
		
		Session session = null;
		String countryList = null;
		try {
			StringBuilder queryString = new StringBuilder();
			queryString.append("SELECT listagg(ctry_nm_cd, ';') within GROUP (ORDER BY gem_unique_grp_ctry_id) AS countryList");
			queryString.append(" from gem_unique_grp_ctry where gem_unique_grp_id in (select gem_unique_grp_id from gem_unique_grp where ");
			queryString.append(" publish_id = ");
			queryString.append(publishId);
			queryString.append(" AND rgn_id = ");
			queryString.append(regionId);
			queryString.append(" AND gem_grp_nm = '");
			queryString.append(groupName);
			queryString.append("' AND grp_typ='");
			queryString.append(groupType);
			queryString.append("') group by gem_unique_grp_id ");
			session = openSession();
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
	
	/**
	 * 
	 * @param groupId
	 * @return String
	 */
	public String getCountryListOfUniqueGroup (long groupId) {
		return null;
	}
}
