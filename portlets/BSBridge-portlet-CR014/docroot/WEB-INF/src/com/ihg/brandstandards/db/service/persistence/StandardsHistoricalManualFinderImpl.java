package com.ihg.brandstandards.db.service.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ihg.brandstandards.db.model.HistManualChain;
import com.ihg.brandstandards.db.model.HistManualRegion;
import com.ihg.brandstandards.db.model.HistManuals;
import com.ihg.brandstandards.db.model.StandardsHistoricalManual;
import com.ihg.brandstandards.db.model.impl.HistManualChainImpl;
import com.ihg.brandstandards.db.model.impl.HistManualRegionImpl;
import com.ihg.brandstandards.db.model.impl.HistManualsImpl;
import com.ihg.brandstandards.db.model.impl.StandardsHistoricalManualImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

/**
 * Finder class for Historical Manuals linked to a Standard.
 * 
 * @author kryvora
 * 
 */
public class StandardsHistoricalManualFinderImpl extends BasePersistenceImpl<StandardsHistoricalManual> implements
        StandardsHistoricalManualFinder
{
    /**
     * Find linked Historical Manuals by Standard Id.
     * 
     * @param stdId - standard id
     * @return list
     * @throws SystemException - exception.
     */
    public List<StandardsHistoricalManual> findStdHistoricalManualsByStdId(long stdId) throws SystemException
    {
        List<StandardsHistoricalManual> historicalManuals = new ArrayList<StandardsHistoricalManual>();

        StringBuilder query = new StringBuilder();
        query.append("SELECT s.std_mnl_id, s.std_id, s.hst_mnl_id, s.mnl_chng_desc, s.std_mnl_title, s.create_by, s.create_date, s.last_upd_by, s.last_upd_date, ");
        query.append(" m.hst_mnl_id, m.mnl_typ, m.mnl_title, m.publish_dt, m.stat_desc, m.create_by, m.create_date, m.last_upd_by, m.last_upd_date, ");
        query.append(" br.hst_mnl_id, br.chn_cd, br.create_by, br.create_date, br.last_upd_by, br.last_upd_date, ");
        query.append(" rg.hst_mnl_id, rg.rgn_cd, rg.create_by, rg.create_date, rg.last_upd_by, rg.last_upd_date ");
        query.append(" FROM STD_MNL s, HIST_MNL m, MNL_RGN rg, MNL_CHN br ");
        query.append(" WHERE s.std_id = ? ");
        query.append(" AND m.hst_mnl_id = s.hst_mnl_id ");
        query.append(" AND m.hst_mnl_id = br.hst_mnl_id ");
        query.append(" AND m.hst_mnl_id = rg.hst_mnl_id ");
        query.append(" ORDER BY m.mnl_title ASC");

        Session session = null;
        try
        {
            session = openSession();
            SQLQuery q = session.createSQLQuery(query.toString());
            q.addEntity("StandardsHistoricalManual", StandardsHistoricalManualImpl.class);
            q.addEntity("HistManuals", HistManualsImpl.class);
            q.addEntity("HistManualChain", HistManualChainImpl.class);
            q.addEntity("HistManualRegion", HistManualRegionImpl.class);
            QueryPos queryPos = QueryPos.getInstance(q);
            queryPos.add(stdId);

            List<?> tmpList = q.list();

            getStandardsHistoricalManualsFromResultset(historicalManuals, tmpList);
            grabAllRegionsChainsForManula(historicalManuals);
        }
        catch (Exception e)
        {
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
     * Extract Historical Manuals from result set.
     * 
     * @param historicalManuals - Historical Manuals
     * @param tmpList - result set
     */
    private void getStandardsHistoricalManualsFromResultset(List<StandardsHistoricalManual> historicalManuals, List<?> tmpList)
    {
        Map<Long, HistManuals> manualMap = new HashMap<Long, HistManuals>();
        Map<Long, StandardsHistoricalManual> stdManualMap = new HashMap<Long, StandardsHistoricalManual>();

        for (int i = 0; i < tmpList.size(); i++)
        {
            Object[] obj = (Object[]) tmpList.get(i);
            HistManuals manual = null;
            HistManualChain manualChain = null;
            HistManualRegion manualRegion = null;
            for (int j = 0; j < obj.length; j++)
            {
                if (obj[j] instanceof StandardsHistoricalManual)
                {
                    StandardsHistoricalManual stdMnl = (StandardsHistoricalManual) obj[j];
                    if (!stdManualMap.containsKey(stdMnl.getStdMnlId()))
                    {
                        stdManualMap.put(stdMnl.getStdMnlId(), stdMnl);
                    }
                }
                else if (obj[j] instanceof HistManuals)
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
        for (Map.Entry<Long, StandardsHistoricalManual> entry : stdManualMap.entrySet())
        {
            StandardsHistoricalManual stdManual = entry.getValue();
            HistManuals manual = manualMap.get(stdManual.getHistManualId());
            stdManual.setChain(manual.getChain());
            stdManual.setRegion(manual.getRegion());
            stdManual.setHistManualTitle(manual.getTitle());
            stdManual.setHistManualType(manual.getType());
            historicalManuals.add(stdManual);
        }
    }

    /**
     * Find Brands and Regions for Historical Manuals.
     * 
     * @param historicalManuals - list of Manuals
     * @throws SystemException - exception
     */
    private void grabAllRegionsChainsForManula(List<StandardsHistoricalManual> historicalManuals) throws SystemException
    {
        List<Long> mnlId = new ArrayList<Long>();
        for (StandardsHistoricalManual manual : historicalManuals)
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
     * Update Historical Manuals with Brands.
     * 
     * @param historicalManuals - Historical Manuals
     * @param mnlId - manual ids
     * @throws SystemException - exception
     */
    private void updateChains(List<StandardsHistoricalManual> historicalManuals, List<Long> mnlId) throws SystemException
    {
        StringBuilder query = new StringBuilder();
        query.append("SELECT br.hst_mnl_id, br.chn_cd, br.create_by, br.create_date, br.last_upd_by, br.last_upd_date ");
        query.append(" FROM MNL_CHN br ");
        query.append(" WHERE ( br.hst_mnl_id = ? ");

        for (int i = 1; i < mnlId.size(); i++)
        {
            query.append(" OR br.hst_mnl_id = ? ");
        }
        query.append(") ");

        Session session = null;
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

            for (StandardsHistoricalManual manual : historicalManuals)
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
     * Update Historical Manuals with Regions.
     * 
     * @param historicalManuals - Historical Manuals
     * @param mnlId - manual ids
     * @throws SystemException - exception
     */
    private void updateRegions(List<StandardsHistoricalManual> historicalManuals, List<Long> mnlId) throws SystemException
    {
        StringBuilder query = new StringBuilder();
        query.append("SELECT rg.hst_mnl_id, rg.rgn_cd, rg.create_by, rg.create_date, rg.last_upd_by, rg.last_upd_date ");
        query.append(" FROM MNL_RGN rg ");
        query.append(" WHERE ( rg.hst_mnl_id = ? ");

        for (int i = 1; i < mnlId.size(); i++)
        {
            query.append(" OR rg.hst_mnl_id = ? ");
        }
        query.append(") ");

        Session session = null;
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

            for (StandardsHistoricalManual manual : historicalManuals)
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
        return obj == null || obj.isEmpty();
    }

    /**
     * Verify if String is null or empty.
     * 
     * @param obj - string
     * @return true/false
     */
    public boolean isNullOrBlank(String obj)
    {
        return obj == null || obj.isEmpty();
    }

}
