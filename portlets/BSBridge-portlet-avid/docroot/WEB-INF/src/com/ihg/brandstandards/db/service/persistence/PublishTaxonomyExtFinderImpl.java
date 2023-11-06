package com.ihg.brandstandards.db.service.persistence;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ihg.brandstandards.db.model.PublishTaxonomyExt;
import com.ihg.brandstandards.db.model.impl.PublishTaxonomyExtImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class PublishTaxonomyExtFinderImpl extends BasePersistenceImpl<PublishTaxonomyExt> implements PublishTaxonomyExtFinder
{
    private static final Log LOG = LogFactoryUtil.getLog(PublishTaxonomyExtFinderImpl.class);

    public List<PublishTaxonomyExt> getIndexPathByStandardsId(final long standardsId) throws SystemException
    {
        Session session = null;
        List<PublishTaxonomyExt> arlResults = new ArrayList<PublishTaxonomyExt>();
        try
        {
            session = openSession();
            final String query = " SELECT TAX.* FROM (SELECT T.PUBLISH_TAXONOMY_ID, T.PRNT_PUBLISH_TAXONOMY_ID, T.TITLE_TXT, LEVEL AS LVL, T.HIER_LVL_NBR, SUBSTR(SYS_CONNECT_BY_PATH(T.TITLE_TXT, ' -> '), 21) AS PATH" + 
                                 " FROM PUBLISH_TAXONOMY T START WITH T.PUBLISH_TAXONOMY_ID = 1 CONNECT BY NOCYCLE PRIOR T.PUBLISH_TAXONOMY_ID = T.PRNT_PUBLISH_TAXONOMY_ID " +
                                 " ORDER BY T.PUBLISH_TAXONOMY_ID, T.PRNT_PUBLISH_TAXONOMY_ID, T.HIER_LVL_NBR) TAX, PUBLISH_TAXONOMY_STD TS " +
                                 " WHERE TAX.PUBLISH_TAXONOMY_ID = TS.TAXONOMY_ID  AND TS.PUBLISH_STD_VER_ID = ?";
            if (LOG.isDebugEnabled())
            {
                LOG.debug(query);
            }
            final SQLQuery sqlQuery = session.createSQLQuery(query);
            final QueryPos qPos = QueryPos.getInstance(sqlQuery);
            sqlQuery.addEntity("PublishTaxonomyExt", PublishTaxonomyExtImpl.class);
            qPos.add(standardsId);
            arlResults = (List<PublishTaxonomyExt>) sqlQuery.list();
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        finally
        {
            closeSession(session);
        }
        return arlResults;
    }

    public List<PublishTaxonomyExt> getIndexPathByChainCode(String chainCode, String query) throws SystemException
    {
        List<PublishTaxonomyExt> arlTaxonomy = new ArrayList<PublishTaxonomyExt>();
        Session session = null;
        try
        {
            session = openSession();

            if (LOG.isDebugEnabled())
            {
                LOG.debug(query);
            }
            SQLQuery sqlQuery = session.createSQLQuery(query);
            List arlTax = sqlQuery.list();

            for (int i = 0; i < arlTax.size(); i++)
            {
                Object[] obj = (Object[]) arlTax.get(i);
                PublishTaxonomyExt tax = new PublishTaxonomyExtImpl();
                tax.setIndexOrder(((BigDecimal) obj[0]).longValue());
                tax.setPublishTaxId(((BigDecimal) obj[1]).longValue());
                tax.setPublishParentId(((BigDecimal) obj[2]).longValue());
                tax.setLvl(String.valueOf(((BigDecimal) obj[2]).longValue()));
                tax.setLevelSortOrder(((BigDecimal) obj[4]).longValue());
                tax.setPublishId(((BigDecimal) obj[5]).longValue());
                tax.setPath((String) obj[6]);
                arlTaxonomy.add(tax);
            }
        }
        catch (Exception e)
        {
            LOG.info(e);
        }
        finally
        {
            closeSession(session);
        }
        return arlTaxonomy;
    }
}
