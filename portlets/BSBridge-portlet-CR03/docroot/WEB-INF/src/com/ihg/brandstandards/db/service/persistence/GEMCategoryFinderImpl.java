package com.ihg.brandstandards.db.service.persistence;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ihg.brandstandards.db.model.GEMCategory;
import com.ihg.brandstandards.db.model.impl.GEMCategoryImpl;
import com.ihg.brandstandards.gem.util.GemConstants;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class GEMCategoryFinderImpl extends BasePersistenceImpl<GEMCategory> implements GEMCategoryFinder {
	
	private static final Log LOG = LogFactoryUtil.getLog(GEMCategoryFinderImpl.class);
	
	/**
	 * This method will return matching CMS category id for GEM Category based on the gem category name and CMS lookup parent ids.
	 * @param cmsLookupCatgyIds Comma separated CMS Look up PRNT_FLAG_CATGY_IDs. Ex: 419, 412
	 * @param The GEM Category Name
	 * @return long 
	 */
	@SuppressWarnings("rawtypes")
	public long getGEMMappingCMSCategoryId(String cmsLookupCatgyIds, String gemCategoryName) {
		StringBuffer query = new StringBuffer("SELECT FLAG_CATGY_ID FROM FLAG_CATGY WHERE PRNT_FLAG_CATGY_ID IN (");
		query.append(cmsLookupCatgyIds).append(") AND FLAG_CATGY_VAL='").append(gemCategoryName).append("'");
		long cmsCategoryId = 0;
		Session session = null;
		try {
            session = openSession();
            SQLQuery q = session.createSQLQuery(query.toString());
            List arlUnlockedRecords = q.list();
            if(arlUnlockedRecords != null && arlUnlockedRecords.size() > 0){
            	BigDecimal stdCount = (BigDecimal) arlUnlockedRecords.get(0);
            	cmsCategoryId = stdCount.longValue();
            }
        } catch(Exception e) {
        	LOG.debug("GEM Mapping CMS CategoryId query: " + query.toString());
            LOG.error("Failed to get GEM Mapping CMS CategoryId", e);
        } finally {
            if (session != null) {
                closeSession(session);
            }
        }
        return cmsCategoryId;
	}
	
	/**
	 * This method will return a List of Gem Categories based on the gem template id passed to it.
	 * @param gemTemplateIds The Gem Template Id
	 * @return List<GEMCategory>
	 */
	@SuppressWarnings("unchecked")
	public List<GEMCategory> getGEMTemplateCategories(long gemTemplateId) {
		List<GEMCategory> templateCategories = new ArrayList<GEMCategory>();
		StringBuffer query = new StringBuffer("SELECT c.*");
		query.append(" FROM GEM_CATGY c, GEM_TEMPLATE_CATGY tc WHERE c.GEM_CATGY_ID=tc.GEM_CATGY_ID AND tc.GEM_TEMPLATE_ID=");
		query.append(gemTemplateId);
		query.append(" ORDER BY tc.DISP_ORDER_NBR");
		
		Session session = null;
		try {
            session = openSession();
            SQLQuery sqlQuery = session.createSQLQuery(query.toString());
            sqlQuery.addEntity("c", GEMCategoryImpl.class);
            templateCategories = sqlQuery.list();
        } catch(Exception e) {
        	LOG.debug("getGEMTemplateCategories query: " + query.toString());
            LOG.error("Failed to get GEM Template Categories for gemTemplateIds:"+gemTemplateId, e);
        } finally {
            if (session != null) {
                closeSession(session);
            }
        }
        return templateCategories;
	}
	
	/**
	 * This method will return a map of gemCategoryId and Gem Category Name based on the gem template id passed to it.
	 * @param gemTemplateIds The Gem Template Id
	 * @return Map<Long, String>
	 */
	@SuppressWarnings("rawtypes")
	public Map<Long, String> getGEMTemplateCategoriesInMap(long gemTemplateId) {
		Map<Long, String> templateCategoriesMap = new LinkedHashMap<Long, String>();
		StringBuffer query = new StringBuffer("SELECT c.GEM_CATGY_ID, c.GEM_CATGY_NM");
		query.append(" FROM GEM_CATGY c, GEM_TEMPLATE_CATGY tc WHERE c.GEM_CATGY_ID=tc.GEM_CATGY_ID AND tc.GEM_TEMPLATE_ID=");
		query.append(gemTemplateId);
		query.append(" ORDER BY tc.DISP_ORDER_NBR");
		
		Session session = null;
		try {
            session = openSession();
            SQLQuery sqlQuery = session.createSQLQuery(query.toString());
            List results = sqlQuery.list();
            if(results != null && results.size() > 0) {
	            for(int i = 0; i < results.size(); i++){
	            	Object[] obj = (Object[]) results.get(i);
	            	templateCategoriesMap.put(((BigDecimal) obj[0]).longValue(), (String) obj[1]);
	            }
            }
        } catch(Exception e) {
        	LOG.debug("getGEMTemplateCategories query: " + query.toString());
            LOG.error("Failed to get GEM Template Categories for gemTemplateIds:"+gemTemplateId, e);
        } finally {
            if (session != null) {
                closeSession(session);
            }
        }
        return templateCategoriesMap;
	}
	
	/**
	 * This method will return a map of gemCategoryId and Gem Category Name based on the gem template ids passed to it.
	 * @param gemSESATemplateIds Comma Separated Gem Template Ids
	 * @return Map<Long, String>
	 */
	@SuppressWarnings("rawtypes")
	public Map<Long, String> getQLFormSAAndSECategories(String gemSESATemplateIds) {
		Map<Long, String> qlFormCategoriesMap = new LinkedHashMap<Long, String>();
		StringBuffer query = new StringBuffer("SELECT DISTINCT GEM_CATGY_ID, GEM_CATGY_NM FROM (SELECT c.GEM_CATGY_ID, c.GEM_CATGY_NM FROM GEM_CATGY c, GEM_TEMPLATE_CATGY tc");
		query.append(" WHERE c.GEM_CATGY_ID=tc.GEM_CATGY_ID AND tc.GEM_TEMPLATE_ID IN (");
		query.append(gemSESATemplateIds);
		query.append(") AND c.GEM_CATGY_NM NOT IN (");
		int counter = 0;
		for(String excludeCategory : GemConstants.QLFORM_EXCLUDE_CATEGORIES.split(StringPool.COMMA)){
			if(counter > 0){
				query.append(StringPool.COMMA);
			}
			query.append("'");
			query.append(excludeCategory);
			query.append("'");
			counter++;
		}
		query.append(") ORDER BY tc.DISP_ORDER_NBR)");
		
		Session session = null;
		try {
            session = openSession();
            SQLQuery sqlQuery = session.createSQLQuery(query.toString());
            List results = sqlQuery.list();
            if(results != null && results.size() > 0) {
	            for(int i = 0; i < results.size(); i++){
	            	Object[] obj = (Object[]) results.get(i);
	            	qlFormCategoriesMap.put(((BigDecimal) obj[0]).longValue(), (String) obj[1]);
	            }
            }
        } catch(Exception e) {
        	LOG.debug("getGEMTemplateCategories query: " + query.toString());
            LOG.error("Failed to get GEM Template Categories for gemTemplateIds:"+gemSESATemplateIds, e);
        } finally {
            if (session != null) {
                closeSession(session);
            }
        }
        return qlFormCategoriesMap;
	}
	
	/**
	 * This method will return a map of gemCategoryId and Gem Category Name based on the gem SE template id passed to it.
	 * @param gemSETemplateId the Gem SE template Id
	 * @return Map<Long, String>
	 */
	@SuppressWarnings("rawtypes")
	public Map<Long, String> getScoringSECategories(long gemSETemplateId) {
		Map<Long, String> qlCategoriesMap = new LinkedHashMap<Long, String>();
		StringBuffer query = new StringBuffer("WITH SE_DUP_CATGY AS (SELECT c.GEM_CATGY_ID, c.GEM_CATGY_NM, c.GEM_CATGY_CD, c.GEM_PRNT_CATGY_ID, tc.DISP_ORDER_NBR");
		query.append(" FROM GEM_CATGY c, GEM_TEMPLATE_CATGY tc WHERE c.GEM_CATGY_ID=tc.GEM_CATGY_ID AND tc.GEM_TEMPLATE_ID=");
		query.append(gemSETemplateId);
		query.append(" AND tc.duplicatable_ind='Y' ORDER BY tc.DISP_ORDER_NBR)");
		query.append(" SELECT GEM_CATGY_ID, GEM_CATGY_NM FROM SE_DUP_CATGY WHERE");
		query.append(" GEM_PRNT_CATGY_ID NOT IN (SELECT GEM_CATGY_CD FROM SE_DUP_CATGY) ORDER BY DISP_ORDER_NBR");
		
		Session session = null;
		try {
            session = openSession();
            SQLQuery sqlQuery = session.createSQLQuery(query.toString());
            List results = sqlQuery.list();
            if(results != null && results.size() > 0) {
	            for(int i = 0; i < results.size(); i++){
	            	Object[] obj = (Object[]) results.get(i);
	            	qlCategoriesMap.put(((BigDecimal) obj[0]).longValue(), (String) obj[1]);
	            }
            }
        } catch(Exception e) {
        	LOG.debug("getQLFormSECategories query: " + query.toString());
            LOG.error("Failed to get GEM SE Template Categories for QLForm:"+gemSETemplateId, e);
        } finally {
            if (session != null) {
                closeSession(session);
            }
        }
        return qlCategoriesMap;
	}
}
