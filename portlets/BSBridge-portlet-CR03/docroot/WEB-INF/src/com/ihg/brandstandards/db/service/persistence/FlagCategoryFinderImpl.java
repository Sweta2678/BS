package com.ihg.brandstandards.db.service.persistence;

import java.util.ArrayList;
import java.util.List;

import com.ihg.brandstandards.db.model.FlagCategory;
import com.ihg.brandstandards.db.model.impl.FlagCategoryImpl;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class FlagCategoryFinderImpl extends BasePersistenceImpl<FlagCategory> implements FlagCategoryFinder {
	
	private static final Log LOG = LogFactoryUtil.getLog(FlagCategoryFinderImpl.class);
	
	@SuppressWarnings("unchecked")
	public List<FlagCategory> getFlagCategoriesForParentIds(String commaSeparateParentIds) {
    	List<FlagCategory> flagCategories = new ArrayList<FlagCategory>();
		Session session = null;
        try {
            session = openSession();
            SQLQuery query = session.createSQLQuery("SELECT * FROM FLAG_CATGY WHERE ACTV_IND='Y' AND PRNT_FLAG_CATGY_ID IN ("+commaSeparateParentIds+")");
            query.addEntity("FlagCategory", FlagCategoryImpl.class);
            flagCategories = (List<FlagCategory>) query.list();
        } catch (Exception e) {
            LOG.error("Failed to get Falg Categories for parents"+commaSeparateParentIds, e);
        }
        finally {
            if (session != null) {
                closeSession(session);
            }
        }
        return flagCategories;
    }
	
	@SuppressWarnings("unchecked")
	public List<FlagCategory> getFlagCategories(String query) {
    	List<FlagCategory> flagCategories = new ArrayList<FlagCategory>();
		Session session = null;
        try {
            session = openSession();
            SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity("FlagCategory", FlagCategoryImpl.class);
            flagCategories = (List<FlagCategory>) sqlQuery.list();
        } catch (Exception e) {
            LOG.error("Failed to get Falg Categories for query"+query, e);
        }
        finally {
            if (session != null) {
                closeSession(session);
            }
        }
        return flagCategories;
    }
}
