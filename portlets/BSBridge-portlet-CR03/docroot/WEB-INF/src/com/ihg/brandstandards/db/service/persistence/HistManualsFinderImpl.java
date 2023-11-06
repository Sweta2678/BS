package com.ihg.brandstandards.db.service.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ihg.brandstandards.db.model.HistManualChain;
import com.ihg.brandstandards.db.model.HistManualRegion;
import com.ihg.brandstandards.db.model.HistManuals;
import com.ihg.brandstandards.db.model.impl.HistManualChainImpl;
import com.ihg.brandstandards.db.model.impl.HistManualRegionImpl;
import com.ihg.brandstandards.db.model.impl.HistManualsImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

/**
 * Find Historical Manuals.
 * 
 * @author kryvora
 * 
 */
public class HistManualsFinderImpl extends BasePersistenceImpl<HistManuals> implements HistManualsFinder
{
    private static final Log LOG = LogFactoryUtil.getLog(HistManualsFinderImpl.class);

    /**
     * Find Historical Manuals.
     * 
     * @param brand - brands
     * @param region - regions
     * @param manualType - manual type
     * @return list of manuals
     * @throws SystemException - exception
     */
    public List<HistManuals> findHistoricalManualsByFilter(List<String> brand, List<String> region, List<String> manualType)
            throws SystemException
    {
        List<HistManuals> historicalManuals = new ArrayList<HistManuals>();

        StringBuilder query = new StringBuilder();
        query.append("SELECT m.hst_mnl_id, m.mnl_typ, m.mnl_title, m.publish_dt, m.stat_desc, m.create_by, m.create_date, m.last_upd_by, m.last_upd_date, ");
        // query.append(" br.chn_cd, rg.rgn_cd ");
        query.append(" br.hst_mnl_id, br.chn_cd, br.create_by, br.create_date, br.last_upd_by, br.last_upd_date, ");
        query.append(" rg.hst_mnl_id, rg.rgn_cd, rg.create_by, rg.create_date, rg.last_upd_by, rg.last_upd_date ");
        query.append(" FROM HIST_MNL m, MNL_RGN rg, MNL_CHN br ");
        query.append(" WHERE m.hst_mnl_id = br.hst_mnl_id ");
        query.append(" AND m.hst_mnl_id = rg.hst_mnl_id ");
        generateHistoricalManualsQueryFiltering(brand, region, manualType, query);
        query.append(" AND UPPER(m.stat_desc) <> 'DELETED' ");
        query.append(" ORDER BY m.mnl_title ASC ");
        Session session = null;
        //LOG.debug("Query = " + query.toString());

        try
        {
            session = openSession();
            SQLQuery q = session.createSQLQuery(query.toString());
            q.addEntity("HistManuals", HistManualsImpl.class);
            q.addEntity("HistManualChain", HistManualChainImpl.class);
            q.addEntity("HistManualRegion", HistManualRegionImpl.class);
            generateHistoricalManualQueryPos(brand, region, manualType, q);
            List<?> tmpList = q.list();
            getHistoricalManualsFromResultset(historicalManuals, tmpList);
            grabAllRegionsChainsForManuals(historicalManuals);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            throw new SystemException(e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return historicalManuals;
    }

    /**
     * Generate Query.
     * 
     * @param brand - brands
     * @param region - regions
     * @param manualType - manual types
     * @param q - SQLQuery object
     */
    private void generateHistoricalManualQueryPos(List<String> brand, List<String> region, List<String> manualType, SQLQuery q)
    {
        QueryPos queryPos = QueryPos.getInstance(q);

        if (!isNullOrBlank(brand))
        {
            for (String str : brand)
            {
                queryPos.add(str.toUpperCase());
            }

        }
        if (!isNullOrBlank(region))
        {
            for (String str : region)
            {
                queryPos.add(str.toUpperCase());
            }
        }
        if (!isNullOrBlank(manualType))
        {
            for (String str : manualType)
            {
                queryPos.add(str.toUpperCase());
            }
        }
    }

    /**
     * Create Filtering.
     * 
     * @param brand - brands
     * @param region - regions
     * @param manualType - manual types
     * @param query - query
     */
    private void generateHistoricalManualsQueryFiltering(List<String> brand, List<String> region, List<String> manualType,
            StringBuilder query)
    {
        if (!isNullOrBlank(brand))
        {
            for (int i = 0; i < brand.size(); i++)
            {
                if (i == 0)
                {
                    query.append(" AND ( UPPER(br.chn_cd) = ? ");
                }
                else
                {
                    query.append(" OR UPPER(br.chn_cd) = ? ");
                }
            }
            query.append(") ");
        }
        if (!isNullOrBlank(region))
        {
            for (int i = 0; i < region.size(); i++)
            {
                if (i == 0)
                {

                    query.append(" AND ( UPPER(rg.rgn_cd) = ? ");
                }
                else
                {
                    query.append(" OR UPPER(rg.rgn_cd) = ? ");
                }
            }
            query.append(") ");
        }
        if (!isNullOrBlank(manualType))
        {
            for (int i = 0; i < manualType.size(); i++)
            {
                if (i == 0)
                {
                    query.append(" AND ( UPPER(m.mnl_typ) = ? ");
                }
                else
                {
                    query.append(" OR UPPER(m.mnl_typ) = ? ");
                }
            }
            query.append(") ");
        }
    }

    /**
     * Get Historical Manuals from resultset.
     * 
     * @param historicalManuals - list of manuals
     * @param tmpList - list from resultset
     */
    private void getHistoricalManualsFromResultset(List<HistManuals> historicalManuals, List<?> tmpList)
    {
        Map<Long, HistManuals> manualMap = new HashMap<Long, HistManuals>();
        for (int i = 0; i < tmpList.size(); i++)
        {
            Object[] obj = (Object[]) tmpList.get(i);
            HistManuals manual = null;
            HistManualChain manualChain = null;
            HistManualRegion manualRegion = null;
            for (int j = 0; j < obj.length; j++)
            {
                if (obj[j] instanceof HistManuals)
                {
                    manual = (HistManuals) obj[j];
                }
                else if (obj[j] instanceof HistManualChain)
                {
                    manualChain = (HistManualChain) obj[j];
                }
                else if (obj[j] instanceof HistManualRegion)
                {
                    manualRegion = (HistManualRegion) obj[j];
                }
            }

            if (!manualMap.containsKey(manual.getHistManualId()))
            {
                manualMap.put(manual.getHistManualId(), manual);
                historicalManuals.add(manual);
            }

            HistManuals tmpManual = manualMap.get(manual.getHistManualId());
            if (!isNullOrBlank(manualRegion.getRegionCode()))
            {
                if (!isNullOrBlank(tmpManual.getRegion()))
                {
                    if (!tmpManual.getRegion().contains(manualRegion.getRegionCode()))
                    {
                        tmpManual.setRegion(tmpManual.getRegion() + ", " + manualRegion.getRegionCode());
                    }
                }
                else
                {
                    tmpManual.setRegion(manualRegion.getRegionCode());
                }
            }
            if (!isNullOrBlank(manualChain.getChainCode()))
            {
                if (!isNullOrBlank(tmpManual.getChain()))
                {
                    if (!tmpManual.getChain().contains(manualChain.getChainCode()))
                    {
                        tmpManual.setChain(tmpManual.getChain() + ", " + manualChain.getChainCode());
                    }
                }
                else
                {
                    tmpManual.setChain(manualChain.getChainCode());
                }
            }
        }
    }

    /**
     * Populate Regions and Brands for Manuals.
     * 
     * @param historicalManuals - list of manuals
     * @throws SystemException - exception
     */
    private void grabAllRegionsChainsForManuals(List<HistManuals> historicalManuals) throws SystemException
    {
        List<Long> mnlId = new ArrayList<Long>();
        for (HistManuals manual : historicalManuals)
        {
            if (!mnlId.contains(manual.getHistManualId()))
            {
                mnlId.add(manual.getHistManualId());
            }
        }

        if (!mnlId.isEmpty())
        {
            updateRegions(historicalManuals, mnlId);
            updateChains(historicalManuals, mnlId);
        }

    }

    /**
     * Update Brands.
     * 
     * @param historicalManuals - manuals
     * @param mnlId - manual ids
     * @throws SystemException - exception
     */
    private void updateChains(List<HistManuals> historicalManuals, List<Long> mnlId) throws SystemException
    {
        StringBuilder query = new StringBuilder();
        query.append("SELECT br.hst_mnl_id, br.chn_cd, br.create_by, br.create_date, br.last_upd_by, br.last_upd_date ");
        query.append(" FROM MNL_CHN br ");
        query.append(" WHERE ( br.hst_mnl_id = ? ");
        Session session = null;
        for (int i = 1; i < mnlId.size(); i++)
        {
            query.append(" OR br.hst_mnl_id = ? ");
        }
        query.append(") ");

        try
        {
            session = openSession();
            SQLQuery q = session.createSQLQuery(query.toString());
            q.addEntity("HistManualChain", HistManualChainImpl.class);
            QueryPos queryPos = QueryPos.getInstance(q);
            for (int i = 0; i < mnlId.size(); i++)
            {
                queryPos.add(mnlId.get(i));
            }

            List<HistManualChain> list = (List<HistManualChain>) q.list();
            Map<Long, List<String>> chainMap = new HashMap<Long, List<String>>();

            for (HistManualChain chain : list)
            {
                if (chainMap.get(chain.getHistManualId()) == null)
                {
                    chainMap.put(chain.getHistManualId(), new ArrayList<String>());
                }
                chainMap.get(chain.getHistManualId()).add(chain.getChainCode());
            }

            for (HistManuals manual : historicalManuals)
            {
                List<String> chains = chainMap.get(manual.getHistManualId());

                for (String chainCode : chains)
                {
                    if (!isNullOrBlank(manual.getChain()))
                    {
                        if (!manual.getChain().contains(chainCode))
                        {
                            manual.setChain(manual.getChain() + ", " + chainCode);
                        }
                    }
                    else
                    {
                        manual.setChain(chainCode);
                    }
                }
            }
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            throw new SystemException(e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
    }

    /**
     * Update Regions for Manuals.
     * 
     * @param historicalManuals - manuals
     * @param mnlId - manual ids
     * @throws SystemException - exception
     */
    private void updateRegions(List<HistManuals> historicalManuals, List<Long> mnlId) throws SystemException
    {
        StringBuilder query = new StringBuilder();
        query.append("SELECT rg.hst_mnl_id, rg.rgn_cd, rg.create_by, rg.create_date, rg.last_upd_by, rg.last_upd_date ");
        query.append(" FROM MNL_RGN rg ");
        query.append(" WHERE ( rg.hst_mnl_id = ? ");
        Session session = null;
        for (int i = 1; i < mnlId.size(); i++)
        {
            query.append(" OR rg.hst_mnl_id = ? ");
        }
        query.append(") ");

        try
        {
            session = openSession();
            SQLQuery q = session.createSQLQuery(query.toString());
            q.addEntity("HistManualRegion", HistManualRegionImpl.class);
            QueryPos queryPos = QueryPos.getInstance(q);
            for (int i = 0; i < mnlId.size(); i++)
            {
                queryPos.add(mnlId.get(i));
            }

            List<HistManualRegion> list = (List<HistManualRegion>) q.list();
            Map<Long, List<String>> regMap = new HashMap<Long, List<String>>();

            for (HistManualRegion reg : list)
            {
                if (regMap.get(reg.getHistManualId()) == null)
                {
                    regMap.put(reg.getHistManualId(), new ArrayList<String>());
                }
                regMap.get(reg.getHistManualId()).add(reg.getRegionCode());
            }

            for (HistManuals manual : historicalManuals)
            {
                List<String> regions = regMap.get(manual.getHistManualId());

                for (String rgCode : regions)
                {
                    if (!isNullOrBlank(manual.getRegion()))
                    {
                        if (!manual.getRegion().contains(rgCode))
                        {
                            manual.setRegion(manual.getRegion() + ", " + rgCode);
                        }
                    }
                    else
                    {
                        manual.setRegion(rgCode);
                    }
                }
            }

        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            throw new SystemException(e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
    }

    /**
     * Verify if list is null or empty.
     * 
     * @param obj - list
     * @return true/false
     */
    public boolean isNullOrBlank(List<?> obj)
    {
        if (obj == null)
        {
            return true;
        }
        if (obj.isEmpty())
        {
            return true;
        }
        return false;
    }

    /**
     * Verify if String is null or empty.
     * 
     * @param obj - string
     * @return true/false
     */
    public boolean isNullOrBlank(String obj)
    {
        if (obj == null)
        {
            return true;
        }
        if (obj.isEmpty())
        {
            return true;
        }
        return false;
    }
}
