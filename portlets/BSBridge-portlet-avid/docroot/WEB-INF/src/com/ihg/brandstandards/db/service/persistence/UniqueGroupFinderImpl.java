package com.ihg.brandstandards.db.service.persistence;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ihg.brandstandards.custom.model.GroupCountryDetails;
import com.ihg.brandstandards.db.model.UniqueGroup;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class UniqueGroupFinderImpl extends BasePersistenceImpl<UniqueGroup> implements UniqueGroupFinder {

	private static final Log LOG = LogFactoryUtil.getLog(UniqueGroupFinderImpl.class);
    
    /**
     * 
     * @param query
     * @return List<GroupCountryDetails>
     */
    public List<GroupCountryDetails> getGroupAndCountryDetails (long publishId, long regionId, String groupType) {
    	List<GroupCountryDetails> groupDetails = new ArrayList<GroupCountryDetails>();
    	Session session =null;
    	try {
    		//Get Region code
    		String regionCode = BrandStandardsUtil.getRegionCode(regionId);
    		session = openSession();
    		StringBuilder query = new StringBuilder();
    		
    		query.append(" with group_details as (SELECT grp.unique_grp_id, grp.grp_nm  ");
    		query.append(" FROM unique_grp grp WHERE grp.publish_id = ");
    		query.append(publishId);
    		query.append(" AND grp.rgn_id = ");
    		query.append(regionId);
    		query.append(" AND grp.unique_grp_typ_cd = '");
    		query.append(groupType);
    		query.append("' ), grp_ctry  as (select unique_grp_id, listagg(ctry_nm_cd, ';') within GROUP ( ");
    		query.append(" ORDER BY unique_grp_ctry_id) AS country from unique_grp_ctry where ");
    		query.append(" unique_grp_id in (select unique_grp_id from group_details)  group by unique_grp_id) ");
    		query.append(" (select grp.unique_grp_id, grp.grp_nm, ctr.country from ");
    		query.append(" group_details grp, grp_ctry ctr where  grp.unique_grp_id = ctr.unique_grp_id ) ");
    		SQLQuery sql = session.createSQLQuery(query.toString());
    		List result = sql.list();
    		GroupCountryDetails group = null;
    		if (result != null &&  result.size() > 0) {
	    		String countryList = null;
    			for (int i=0; i < result.size(); i++) {
	    			group = new GroupCountryDetails();
	    			Object[] obj = (Object[]) result.get(i);
	    			group.setGroupId(((BigDecimal) obj[0]).longValue());
	    			group.setGroupName((String) obj[1]);
	    			//Get country Name from country code
	    			if (obj[2] != null) {
	    				countryList = BrandStandardsUtil.getCountryList((String) obj[2], regionCode).replaceAll(",", ", ");
	    				group.setCountryList(countryList);
	    			}
	    			groupDetails.add(group);
	    		}
    		}
    	} catch (Exception e) {
    		LOG.error(e.getMessage(), e);
    	}
    	return groupDetails;
    }
    
    /**
     * This method return a map of Groups and Group Countries where the standard belongs to.
     * @param publishId
     * @param regionId
     * @param groupType
     * @param stdId
     * @return
     */
    public Map<String, String> getStdUniqueGrpAndCtrys(long publishId, long regionId, String groupType, String stdId){
    	Session session =null;
    	Map<String, String> stdGrpCtryDetails = new LinkedHashMap<String, String>();
    	StringBuffer query = new StringBuffer("SELECT ug.GEM_GRP_NM, (SELECT LISTAGG(ugc.CTRY_NM_CD, ';') WITHIN GROUP (ORDER BY ugc.GEM_UNIQUE_GRP_CTRY_ID)"); 
    	query.append("FROM GEM_UNIQUE_GRP_CTRY ugc WHERE ugc.GEM_UNIQUE_GRP_ID=ug.GEM_UNIQUE_GRP_ID) STD_GRP_COUNTRIES");
    	query.append(" FROM GEM_UNIQUE_GRP ug, GEM_UNIQUE_GRP_DTL UGD WHERE ug.GEM_UNIQUE_GRP_ID=ugd.GEM_UNIQUE_GRP_ID");
    	query.append(" AND ug.PUBLISH_ID=").append(publishId);
    	query.append(" AND ug.RGN_ID=").append(regionId);
    	query.append(" AND ug.GRP_TYP='").append(groupType);
    	query.append("' AND ugd.STD_ID=").append(stdId);
    	query.append(" ORDER BY ug.GEM_UNIQUE_GRP_ID");
    	try {
    		session = openSession();
			SQLQuery sql = session.createSQLQuery(query.toString());
			@SuppressWarnings("rawtypes")
			List result = sql.list();
			if (result != null &&  result.size() > 0) {
				String countryList = StringPool.BLANK;
				for (int i=0; i < result.size(); i++) {
					Object[] obj = (Object[]) result.get(i);
					//Get country Name from country code
					if (obj[1] != null) {
						String regionCode = BrandStandardsUtil.getRegionCode(regionId);
			    		countryList = BrandStandardsUtil.getCountryList((String) obj[1], regionCode).replaceAll(",", ", ");
					}
					stdGrpCtryDetails.put((String) obj[0], countryList);
				}
			}
    	} catch (Exception e) {
    		LOG.error("Failed getGroupAndCountryDetails Query "+query.toString());
    		LOG.error(e.getMessage(), e);
    	}
        finally {
            if (session != null) {
                closeSession(session);
            }
        }
    	return stdGrpCtryDetails;
    }

}