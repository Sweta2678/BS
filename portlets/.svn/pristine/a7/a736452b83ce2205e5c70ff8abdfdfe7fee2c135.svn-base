package com.ihg.brandstandards.db.service.persistence;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ihg.brandstandards.custom.model.CMSSearchCriteria;
import com.ihg.brandstandards.db.model.StandardsExt;
import com.ihg.brandstandards.db.model.Taxonomy;
import com.ihg.brandstandards.db.model.impl.StandardsExtImpl;
import com.ihg.brandstandards.db.service.TaxonomyLocalServiceUtil;
import com.ihg.brandstandards.report.FieldMapping;
import com.ihg.brandstandards.report.ReportConfig;
import com.ihg.brandstandards.report.ReportConfigLoader;
import com.ihg.brandstandards.util.BSCommonConstants;
import com.ihg.brandstandards.util.StandardsListUtil;
import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

/**
 * Finder for Standards + associated Indexes.
 * 
 * @author KryvorA
 * 
 */
public class StandardsExtFinderImpl extends BasePersistenceImpl<StandardsExt> implements StandardsExtFinder
{
    private static final String TEXT_EXACT_MATCH = "exact";
    private static final String TEXT_ANY_WORD_MATCH = "any";
    private static final Log LOG = LogFactoryUtil.getLog(StandardsExtFinderImpl.class);
    private static final String STD_TBL_STD_ID_EQ = "S.STD_ID = ";
    private static final int RECORD_TYPE_STD = 1;
    private static final int RECORD_TYPE_SPEC = 2;
    private static final int RECORD_TYPE_GDLN = 3;

    private static final int FLG_MANUAL = 30;
    private static final int FLG_CORP_DEPARTMENT = 35;

    private static final String CFG_FIELD_NAME_AUDIT_LOG_COM = "auditLogComments";
    private static final String CFG_FIELD_NAME_STD_MANUAL = "stdManual";
    private static final String CFG_FIELD_NAME_STD_MANUAL_BUILD = "stdManualBuild";
    private static final String CFG_FIELD_NAME_STD_MANUAL_OPERATE = "stdManualOperate";
    private static final String CFG_FIELD_NAME_STD_MANUAL_BUILD_CD = "257";
    private static final String CFG_FIELD_NAME_STD_MANUAL_OPERATE_CD = "258";
    private static final String CFG_FIELD_NAME_BI_CHANGE_TYPE = "biChangeTypeCd";
    private static final String CFG_FIELD_NAME_HIST_MNL = "historicalManualDesc";
    private static final String CFG_FIELD_NAME_STD_CORP_DEP = "stdCorporateDepartment";
    private static final String CFG_FIELD_NAME_STD_BRAND = "stdBrandCd";
    private static final String CFG_FILTER_OUT_SAME_CAT_REC = "standardsWithSameCategory";
    private static final String CFG_FIELD_NAME_CROSS_REFERENCE = "stdCrossReferences";
    private static final String CFG_FIELD_NAME_HISTORICAL = "historicalStatusDesc";
    private static final String CFG_FIELD_NAME_STD_STATUS = "stdStatus";
    private static final String CFG_FIELD_NAME_STD_HIST_STATUS = "auditLogStatus";
    private static final String CFG_FIELD_NAME_COMPLY_RULE_EXPIRES = "expires";

    /**
     * Find All Standards and associated Indexes.
     * 
     * @param criteriaMap - search criteria
     * @return List of standards
     * @throws SystemException - exception
     */
    public List<StandardsExt> getStandards(final Map<String, ?> criteriaMap) throws SystemException
    {
        final CMSSearchCriteria criteria = (CMSSearchCriteria) criteriaMap.get("StandardsSearchCriteria");
        List<StandardsExt> standards = null;
        ReportConfig config = ReportConfigLoader.getReportConfig(criteria.getReportId());
        config.setSecLanguage(criteria.getSecondLangLocaleCd());

        try
        {
            if (criteria.isEmpty())
            {
                standards = getRecords(config, criteria.getPreferedBrand(), criteria.getDiscontFilter());
            }
            else
            {
                standards = getRecords(criteria, config);
            }
        }
        catch (Exception e)
        {
            throw new SystemException(e);
        }

        postProcessingReport(config, standards);
        return standards;
    }

    /**
     * Fetch all records without filtering.
     * 
     * @param config report configuration
     * @return list of records
     */
    private List<StandardsExt> getRecords(ReportConfig config, String preferBrand, String discontFilter)
    {
        final StringBuilder query = buildSelectClause();
        final StringBuilder from = buildFromClause();
        final StringBuilder where = buildWhereClause();
        updateQueryWithSecondLanguage(config, null, query, from, where, false);
        updateQueryWithAssignImage(null, from, where, false);
        //updateQueryWithStdImage(where);
        updateQueryWithRules(config, query, from, where, preferBrand);
        updateQueryWithConfig(config, query, from, where, preferBrand, discontFilter);
        updateQueryWithAuditLogComments(null, config, query, from, where);
        query.append(from);
        query.append(where);

        LOG.debug("Get all Standards Query : " + query);
        List<StandardsExt> list = runQuery(query.toString());
        final List<StandardsExt> standards = new ArrayList<StandardsExt>();

        for (StandardsExt std : list)
        {
            if (!standards.contains(std))
            {
                standards.add(std);
            }
        }

        return standards;
    }

    /**
     * Update where clause with Standard Image.
     * 
     * @param where - where clause
     */
    private void updateQueryWithStdImage(StringBuilder where)
    {
        where.append(" AND S.STD_ID = SIMG.STD_ID(+) ");
    }

    /**
     * Update query clauses with configuration specific fields.
     * 
     * @param config Report Configuration
     * @param select - select clause
     * @param from - from clause
     * @param where - where clause
     */
    private void updateQueryWithConfig(ReportConfig config, StringBuilder select, StringBuilder from, StringBuilder where,
            String preferBrand, String discontFilter)
    {
        updateQueryWithStdStatus(config, select, from, where, preferBrand, discontFilter);
        updateQueryWithStdManual(config, select, from, where);
        updateQueryWithStdCorpDepartment(config, select, from, where);
        updateQueryWithStdBrand(config, select, from, where);
        updateQueryWithBIChangeType(config, select, from, where);
        updateQueryWithHistoricalManual(config, select, from, where);
        updateQueryWithFilterOutRecords(config, where);
        updateQueryWithConfigPreFiltering(config, select, from, where);
        updateQueryWithCrossReferencing(config, select, from, where);
        updateQueryWithAuditBrand(config, select, from, where);
    }

    /**
     * 
     * @param config
     * @param select
     * @param from
     * @param where
     */
    private void updateQueryWithStdStatus(ReportConfig config, StringBuilder select, StringBuilder from, StringBuilder where,
            String preferBrand, String discontFilter)
    {
        FieldMapping field = getFiledByName(CFG_FIELD_NAME_AUDIT_LOG_COM, config);
        if (existsClassFiledName(CFG_FIELD_NAME_STD_STATUS, config) || existsClassFiledName(CFG_FIELD_NAME_STD_HIST_STATUS, config) || "true".equalsIgnoreCase(discontFilter))
        {
            if (existsClassFiledName(CFG_FIELD_NAME_AUDIT_LOG_COM, config) && "all".equals((field == null ? null : field.getReturnEntries())) || BSCommonConstants.ALL_BRAND.equalsIgnoreCase(preferBrand))
            {
                select.append(" , '0' STD_STAT_DESC ");
            }
            else
            {
                select.append(" , CASE WHEN CHS.CHAIN_CD = '" + preferBrand + "' THEN CHS.STAT_ID ELSE 0 END \"STD_STAT_DESC\" ");

                from.append(", (SELECT STD_ID , STAT_ID , CHAIN_CD FROM CHAIN_STD WHERE ACTV_IND = 'Y' AND CHAIN_CD = '" + preferBrand + "') CHS ");

                where.append(" AND " + STD_TBL_STD_ID_EQ + "CHS.STD_ID(+) ");
                if ("true".equalsIgnoreCase(discontFilter))
                {
                    where.append(" AND S.STD_ID NOT IN (SELECT s.std_id from STD s, CHAIN_STD cs , STAT st where s.std_id = cs.std_id and cs.chain_cd = '"
                            + preferBrand + "' and cs.stat_id = st.stat_id and st.stat_cd IN ('D_FOR_REF','D_NOT_RQ','D_RPLCD')) ");
                }

            }
        }
        else
        {
            select.append(" , '0' STD_STAT_DESC ");
        }
    }

    /**
     * 
     * @param config
     * @param select
     * @param from
     * @param where
     */
    private void updateQueryWithAuditBrand(ReportConfig config, StringBuilder select, StringBuilder from, StringBuilder where)
    {
        if (existsClassFiledName(CFG_FIELD_NAME_HISTORICAL, config))
        {
            select.append(" , AUDIT_LOG.CHAIN_CD AS AUDIT_BRAND ");
        }
        else
        {
            select.append(" , 'none' AUDIT_BRAND ");
        }
    }

    /**
     * Update query with cross-referencing, which is available on configuration
     * 
     * @param config
     * @param select
     * @param from
     * @param where
     */
    private void updateQueryWithCrossReferencing(ReportConfig config, StringBuilder select, StringBuilder from,
            StringBuilder where)
    {
        if (existsClassFiledName(CFG_FIELD_NAME_CROSS_REFERENCE, config))
        {
            select.append(" , NVL(XF.CROSS_ID,'') AS REFERENCED_STD_ID ");

            from.append(" , (SELECT xref.REFERRING_STD_ID AS REFERRING_ID, ");
            from.append("  LISTAGG(xref.REFERENCED_STD_ID, ' ') WITHIN GROUP (ORDER BY xref.disp_order_nbr, xref.REFERENCED_STD_ID) AS CROSS_ID ");
            from.append("  FROM STD_XREF xref ");
            from.append("  GROUP BY xref.REFERRING_STD_ID) XF ");

            where.append(" AND " + STD_TBL_STD_ID_EQ + "XF.REFERRING_ID(+) ");
        }
        else
        {
            select.append(" , '' REFERENCED_STD_ID ");
        }
    }

    /**
     * Update query with pre-filtering, which is available on configuration.
     * 
     * @param config report configuration
     * @param select select clause
     * @param from from clause
     * @param where where clause
     */
    private void updateQueryWithConfigPreFiltering(ReportConfig config, StringBuilder select, StringBuilder from,
            StringBuilder where)
    {
        if (config.getSelectClause() != null)
        {
            select.append(" ").append(config.getSelectClause()).append(" ");
        }

        if (config.getTable() != null)
        {
            from.append(" ").append(config.getTable()).append(" ");
        }

        if (config.getWhereClause() != null)
        {
            where.append(" ").append(config.getWhereClause()).append(" ");
        }
    }

    /**
     * Update query with audit log comments.
     * 
     * @param config report config
     * @param where where clause
     */
    private void updateQueryWithAuditLogComments(final CMSSearchCriteria criteria, ReportConfig config,
            StringBuilder select, StringBuilder from, StringBuilder where)
    {
        if (existsClassFiledName(CFG_FIELD_NAME_AUDIT_LOG_COM, config))
        {
            select.append(" , AUDIT_LOG.WORKFLOW_ACTV_LOG_ID, AUDIT_LOG.CMT_TXT AS AUDIT_LOG_TXT, AUDIT_LOG.TITLE_TXT AS AUDIT_LOG_TITLE_TXT, AUDIT_LOG.LST_UPDT_TS AS AUDIT_LOG_UPD_TS,  AUDIT_LOG.CURRENT_STAT_CD AS AUDIT_LOG_CURRENT_STAT_CD,  AUDIT_LOG.PREV_STAT_CD AS AUDIT_LOG_PREV_STAT_CD ");

            from.append(" , (SELECT WAL.WORKFLOW_ACTV_LOG_ID, WAL.OBJECT_ID, WAL.CMT_TXT, WAL.TITLE_TXT, WAL.LST_UPDT_TS, WAL.CREAT_USR_ID, WAL.CREAT_TS, WAL.CURRENT_STAT_CD,  WAL.PREV_STAT_CD, WAL.CHAIN_CD ");
            from.append("    FROM WORKFLOW_ACTV_LOG WAL ");
            from.append("    WHERE WAL.OBJECT_TYP IN ('STD', 'SPEC', 'GDLN'))  AUDIT_LOG ");

            where.append(" AND S.STD_ID = AUDIT_LOG.OBJECT_ID(+) ");

            FieldMapping field = getFiledByName(CFG_FIELD_NAME_AUDIT_LOG_COM, config);
            if ("last".equals(field.getReturnEntries()))
            {
                where.append(" AND (AUDIT_LOG.WORKFLOW_ACTV_LOG_ID = ");
                where.append("       (SELECT MAX(WORKFLOW_ACTV_LOG_ID) ");
                where.append("        FROM WORKFLOW_ACTV_LOG ");
                where.append("        WHERE OBJECT_TYP IN ('STD', 'SPEC', 'GDLN') ");
                where.append("        AND OBJECT_ID = AUDIT_LOG.OBJECT_ID) ");
                where.append("        OR AUDIT_LOG.WORKFLOW_ACTV_LOG_ID IS NULL) ");
            }

            if (criteria != null && "Y".equals(criteria.getSearchLog()))
            {
                addAuditLogCriteria(criteria, where);
            }
        }
        else
        {
            select.append(" , 0 WORKFLOW_ACTV_LOG_ID, NULL AUDIT_LOG_TXT, NULL AUDIT_LOG_TITLE_TXT, NULL AUDIT_LOG_UPD_TS, NULL AUDIT_LOG_CURRENT_STAT_CD, NULL AUDIT_LOG_PREV_STAT_CD ");

            if (criteria != null && "Y".equals(criteria.getSearchLog()))
            {
                from.append(" , WORKFLOW_ACTV_LOG  AUDIT_LOG ");
                where.append(" AND S.STD_ID = AUDIT_LOG.OBJECT_ID ");
                addAuditLogCriteria(criteria, where);
            }
        }
    }

    /**
     * Add criteria for Audit Log.
     * 
     * @param criteria search criteria
     * @param where where clause
     */
    private void addAuditLogCriteria(final CMSSearchCriteria criteria, StringBuilder where)
    {
        if (!StandardsListUtil.isNullOrBlank(criteria.getAuthors()))
        {
            where.append(" AND ");
            where.append(StandardsListUtil.getWhereClause(criteria.getAuthors(), "AUDIT_LOG.CREAT_USR_ID",
                    StandardsListUtil.COLUMN_TYPE_NUMBER_START, StandardsListUtil.COLUMN_TYPE_NUMBER_END).toString());
            where.append(" ");
        }
        where.append(" AND ");
        where.append(StandardsListUtil.getWhereClauseDate(criteria.getLogDate(), criteria.getToLogDate(), "AUDIT_LOG.CREAT_TS"));
        where.append(" ");
    }

    /**
     * Update query with Standard Manual.
     * 
     * @param config report config
     * @param where where clause
     */
    private void updateQueryWithStdManual(ReportConfig config, StringBuilder select, StringBuilder from, StringBuilder where)
    {
        if (existsClassFiledName(CFG_FIELD_NAME_STD_MANUAL, config)
                || existsClassFiledName(CFG_FIELD_NAME_STD_MANUAL_BUILD, config)
                || existsClassFiledName(CFG_FIELD_NAME_STD_MANUAL_OPERATE, config))
        {
            select.append(" , NVL(MAN.FLAG_CATGY_ID, 0) AS STD_MANUAL_FLG ");

            from.append(" , (SELECT FC.FLAG_CATGY_VAL, FC.FLAG_CATGY_ID, FS.STD_ID ");
            from.append("    FROM FLAG_CATGY FC, FLAG_STD FS ");
            // 30 is for Manual Flag
            from.append("    WHERE FC.PRNT_FLAG_CATGY_ID = " + FLG_MANUAL + " ");
            from.append("    AND FC.FLAG_CATGY_ID = FS.FLAG_CATGY_ID) MAN ");

            where.append(" AND  S.STD_ID = MAN.STD_ID(+) ");
        }
        else
        {
            select.append(" , '0' STD_MANUAL_FLG ");
        }
    }

    /**
     * Update query with Standard Corporate Department.
     * 
     * @param config report config
     * @param where where clause
     */
    private void updateQueryWithStdCorpDepartment(ReportConfig config, StringBuilder select, StringBuilder from,
            StringBuilder where)
    {
        if (existsClassFiledName(CFG_FIELD_NAME_STD_CORP_DEP, config))
        {
            select.append(" , NVL(DEPMNT.FLAG_CATGY_VAL, 'none') AS STD_CORP_DEPMNT_FLG ");

            from.append(" , (SELECT FC.FLAG_CATGY_VAL, FS.STD_ID ");
            from.append("    FROM FLAG_CATGY FC, FLAG_STD FS ");
            // 35 is for Corporate Department Flag
            from.append("    WHERE FC.PRNT_FLAG_CATGY_ID = " + FLG_CORP_DEPARTMENT + " ");
            from.append("    AND FC.FLAG_CATGY_ID = FS.FLAG_CATGY_ID) DEPMNT ");

            where.append(" AND  S.STD_ID = DEPMNT.STD_ID(+) ");
        }
        else
        {
            select.append(" , 'none' STD_CORP_DEPMNT_FLG ");
        }
    }

    /**
     * Update query with Standard Brand.
     * 
     * @param config report config
     * @param where where clause
     */
    private void updateQueryWithStdBrand(ReportConfig config, StringBuilder select, StringBuilder from, StringBuilder where)
    {
        if (existsClassFiledName(CFG_FIELD_NAME_STD_BRAND, config))
        {
            select.append(" , CH.CHAIN_CD AS STD_BRAND_CD ");

            from.append("  , CHAIN_STD CH ");

            where.append(" AND  S.STD_ID = CH.STD_ID ");
            where.append(" AND CH.ACTV_IND = 'Y' "); // TO AVOID INACTIVE BRAND.
        }
        else
        {
            select.append(" , 'none' STD_BRAND_CD ");
        }
    }

    /**
     * Update query with Business Impact Change Type.
     * 
     * @param config report config
     * @param where where clause
     */
    private void updateQueryWithBIChangeType(ReportConfig config, StringBuilder select, StringBuilder from, StringBuilder where)
    {
        if (existsClassFiledName(CFG_FIELD_NAME_BI_CHANGE_TYPE, config))
        {
            select.append(" , BI.BUS_IMPACT_ASSMT_MNL_ID AS BI_ASSMT_ID, BI.CHG_FROM_RGN_TO_GBL_DESC AS BI_CHG_FROM_RGN, BI.RGN_CD AS BI_RGN_CD, ");
            select.append(" BI.PROFIT_LOSS_IMPACT_CD AS BI_PROFIT_LOSS_IMPACT_CD, BI.CAP_EXPENSE_IMPACT_CD AS BI_CAP_EXPENSE_IMPACT_CD, ");
            select.append(" BI.IMPLMNT_TIMESCALE_CD AS BI_IMPLMNT_TIMESCALE_CD, BI.CMT_TXT AS BI_DESC, BI.CHAIN_CD AS BI_CHAIN_CD ");

            from.append("  , BUS_IMPACT_ASSMT_MNL BI ");

            where.append(" AND  S.STD_ID = BI.STD_ID(+) ");
        }
        else
        {
            select.append(" , 0 BI_ASSMT_ID, NULL BI_CHG_FROM_RGN, NULL BI_RGN_CD, NULL BI_PROFIT_LOSS_IMPACT_CD, ");
            select.append(" NULL BI_CAP_EXPENSE_IMPACT_CD, NULL BI_IMPLMNT_TIMESCALE_CD, NULL BI_DESC, NULL BI_CHAIN_CD ");
        }
    }

    /**
     * Update query with Historical Manual.
     * 
     * @param config report config
     * @param where where clause
     */
    private void updateQueryWithHistoricalManual(ReportConfig config, StringBuilder select, StringBuilder from,
            StringBuilder where)
    {
        if (existsClassFiledName(CFG_FIELD_NAME_HIST_MNL, config))
        {
            select.append(" , HM.MNL_TITLE ");

            from.append("  , HIST_MNL HM, STD_MNL SM ");

            where.append(" AND HM.HST_MNL_ID = SM.HST_MNL_ID ");
            where.append(" AND S.STD_ID = SM.STD_ID(+) ");
        }
        else
        {
            select.append(" , null MNL_TITLE ");
        }
    }

    /**
     * Update query with filter out records.
     * 
     * @param config report config
     * @param where where clause
     */
    private void updateQueryWithFilterOutRecords(ReportConfig config, StringBuilder where)
    {
        if (CFG_FILTER_OUT_SAME_CAT_REC.equals(config.getRecord().getFilterOut()))
        {
            where.append(" AND (S.STD_ID IN ( ");
            where.append("      SELECT TS1.STD_ID ");
            where.append("      FROM TAXONOMY_STD TS1 ");
            where.append("      WHERE TS1.TAXONOMY_ID in ( ");
            where.append("      SELECT TXNM_ID ");
            where.append("      FROM ( ");
            where.append("      SELECT T1.TAXONOMY_ID TXNM_ID, COUNT(T1.TAXONOMY_ID) CNT ");
            where.append("      FROM TAXONOMY_STD T1, STD S1 ");
            where.append("      WHERE T1.STD_ID = S1.STD_ID ");
            where.append("       AND S1.STD_TYP = 'STD' ");
            where.append("       GROUP BY T1.TAXONOMY_ID) ");
            where.append("       WHERE CNT > 1)) ");
            where.append("    OR S.PRNT_STD_ID IN ( ");
            where.append("      SELECT TS2.STD_ID ");
            where.append("      FROM TAXONOMY_STD TS2 ");
            where.append("      where TS2.TAXONOMY_ID in ( ");
            where.append("      SELECT TXNM_ID ");
            where.append("      FROM ( ");
            where.append("      SELECT T2.TAXONOMY_ID TXNM_ID, COUNT(T2.TAXONOMY_ID) CNT ");
            where.append("       FROM TAXONOMY_STD T2, STD S2 ");
            where.append("       WHERE T2.STD_ID = S2.STD_ID ");
            where.append("       AND S2.STD_TYP = 'STD' ");
            where.append("       GROUP BY T2.TAXONOMY_ID) ");
            where.append("       WHERE CNT > 1))) ");
        }
    }

    /**
     * Post processing of the report.
     * 
     * @param config report configuration
     * @param standards list of records
     */
    private void postProcessingReport(ReportConfig config, List<StandardsExt> standards)
    {
        if (!StandardsListUtil.isNullOrBlank(standards))
        {
            filterOutRecords(config, standards);
            combineManualForSameRecord(config, standards);
        }
    }

    /**
     * Combine different Manual types for the same record.
     * 
     * @param config - report configuration
     * @param standards all records
     */
    private void combineManualForSameRecord(ReportConfig config, List<StandardsExt> standards)
    {
        if ("combineManualTypesForSameRecord".equals(config.getRecord().getFilterOut()))
        {
            LOG.debug("Combine records when Manual has multiple types.");
            Map<Long, List<StandardsExt>> allRecords = new HashMap<Long, List<StandardsExt>>();
            for (StandardsExt rec : standards)
            {
                String manual = rec.getStdManual();
                if (CFG_FIELD_NAME_STD_MANUAL_OPERATE_CD.equals(manual))
                {
                    rec.setStdManualOperate(manual);
                }
                else if (CFG_FIELD_NAME_STD_MANUAL_BUILD_CD.equals(manual))
                {
                    rec.setStdManualBuild(manual);
                }

                List<StandardsExt> entryList = allRecords.get(rec.getStdId());
                if (entryList == null)
                {
                    List<StandardsExt> stdLst = new ArrayList<StandardsExt>();
                    stdLst.add(rec);
                    allRecords.put(rec.getStdId(), stdLst);
                }
                else
                {
                    entryList.add(rec);
                }
            }

            List<StandardsExt> deleteRec = new ArrayList<StandardsExt>();

            for (Map.Entry<Long, List<StandardsExt>> entry : allRecords.entrySet())
            {
                List<StandardsExt> recs = entry.getValue();
                for (int indx = 0; indx < recs.size(); indx++)
                {
                    StandardsExt rec = recs.get(indx);

                    for (int yndx = indx + 1; yndx < recs.size(); yndx++)
                    {
                        StandardsExt recIn = recs.get(yndx);

                        if (rec == recIn || deleteRec.contains(recIn))
                        {
                            continue;
                        }
                        if (matchImpactAssessmentRec(rec, recIn))
                        {
                            String manual = rec.getStdManual();
                            String manualIn = recIn.getStdManual();
                            if (CFG_FIELD_NAME_STD_MANUAL_OPERATE_CD.equals(manual))
                            {
                                rec.setStdManualOperate(manual);
                            }
                            else if (CFG_FIELD_NAME_STD_MANUAL_OPERATE_CD.equals(manualIn))
                            {
                                rec.setStdManualOperate(manualIn);
                            }
                            if (CFG_FIELD_NAME_STD_MANUAL_BUILD_CD.equals(manual))
                            {
                                rec.setStdManualBuild(manual);
                            }
                            else if (CFG_FIELD_NAME_STD_MANUAL_BUILD_CD.equals(manualIn))
                            {
                                rec.setStdManualBuild(manualIn);
                            }

                            deleteRec.add(recIn);
                            break;
                        }
                    }
                }
            }

            standards.removeAll(deleteRec);
        }
    }

    /**
     * Compare two records.
     * 
     * @param rec1 record
     * @param rec2 record
     * @return true/false
     */
    private boolean matchImpactAssessmentRec(final StandardsExt rec1, final StandardsExt rec2)
    {
        boolean match = false;

        if (rec1.getStdId() == rec2.getStdId())
        {
            if ("STD".equals(rec1.getStdType()))
            {
                if (equalsString(rec1.getStdBrandCd(), rec2.getStdBrandCd()))
                {
                    if (equalsString(rec1.getBiRegionCd(), rec2.getBiRegionCd()))
                    {
                        if (equalsString(rec1.getBiProfileLossImpactCd(), rec2.getBiProfileLossImpactCd()))
                        {
                            if (equalsString(rec1.getBiCapExpenseImpactCd(), rec2.getBiCapExpenseImpactCd()))
                            {
                                if (equalsString(rec1.getBiImplTimeScaleCd(), rec2.getBiImplTimeScaleCd()))
                                {
                                    if (equalsString(rec1.getStdCorporateDepartment(), rec2.getStdCorporateDepartment()))
                                    {
                                        match = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else
            {
                if (equalsString(rec1.getStdBrandCd(), rec2.getStdBrandCd()))
                {
                    if (equalsString(rec1.getStdCorporateDepartment(), rec2.getStdCorporateDepartment()))
                    {
                        match = true;
                    }
                }
            }
        }

        return match;
    }

    /**
     * Compare strings.
     * 
     * @param str1 string one
     * @param str2 string two
     * @return true/false
     */
    private boolean equalsString(final String str1, final String str2)
    {
        if (str1 == null && str2 == null)
        {
            return true;
        }
        else if (str1 != null)
        {
            return str1.equals(str2);
        }
        return false;
    }

    /**
     * Filter out records from the report.
     * 
     * @param config - report configuration
     * @param standards all records
     */
    private void filterOutRecords(ReportConfig config, List<StandardsExt> standards)
    {
        if (CFG_FILTER_OUT_SAME_CAT_REC.equals(config.getRecord().getFilterOut()))
        {
            LOG.debug("Remove Index records when all Standards having same Category.");
            // remove records with same Category
            Map<Long, List<StandardsExt>> allIndexRecords = new HashMap<Long, List<StandardsExt>>();
            for (StandardsExt rec : standards)
            {
                if ("STD".equals(rec.getStdType()))
                {
                    List<StandardsExt> entryList = allIndexRecords.get(rec.getIndexId());
                    if (entryList == null)
                    {
                        List<StandardsExt> stdLst = new ArrayList<StandardsExt>();
                        stdLst.add(rec);
                        allIndexRecords.put(rec.getIndexId(), stdLst);
                    }
                    else
                    {
                        entryList.add(rec);
                    }
                }
            }

            // compare Categories
            List<Long> deleteIndex = new ArrayList<Long>();

            Set<Long> keySet = allIndexRecords.keySet();
            for (Long key : keySet)
            {
                List<StandardsExt> recs = allIndexRecords.get(key);
                String catDesc = recs.get(0).getStdCategory();
                boolean deleteRecord = true;
                for (StandardsExt std : recs)
                {
                    if (!catDesc.equals(std.getStdCategory()))
                    {
                        deleteRecord = false;
                        break;
                    }
                }
                if (deleteRecord)
                {
                    deleteIndex.add(key);
                }
            }
            List<StandardsExt> newStandards = new ArrayList<StandardsExt>();

            for (StandardsExt rec : standards)
            {
                if (!deleteIndex.contains(rec.getIndexId()))
                {
                    newStandards.add(rec);
                }
            }
            standards.clear();
            standards.addAll(newStandards);
        }
    }

    /**
     * Verify if Record Configuration contains specified field name.
     * 
     * @param fieldName field name
     * @param config Report Configuration
     * @return true/false
     */
    private boolean existsClassFiledName(String fieldName, ReportConfig config)
    {
        boolean found = false;
        for (FieldMapping field : config.getRecord().getField())
        {
            if (fieldName.equals(field.getClassFieldName()))
            {
                found = true;
                break;
            }
        }
        return found;
    }

    /**
     * Get Field from Record Configuration.
     * 
     * @param fieldName field name
     * @param config Report Configuration
     * @return FieldMapping
     */
    private FieldMapping getFiledByName(String fieldName, ReportConfig config)
    {
        FieldMapping theField = null;
        for (FieldMapping field : config.getRecord().getField())
        {
            if (fieldName.equals(field.getClassFieldName()))
            {
                theField = field;
                break;
            }
        }
        return theField;
    }

    /**
     * Fetch records using specified criteria.
     * 
     * @param criteria - search criteria
     * @param config Report Configuration
     * @return list of records
     * @throws SystemException - exception
     */
    private List<StandardsExt> getRecords(final CMSSearchCriteria criteria, ReportConfig config) throws SystemException
    {
        final List<StandardsExt> standards = new ArrayList<StandardsExt>();
        final List<Long> stdIds = new ArrayList<Long>();
        final List<Long> missedStdIds = new ArrayList<Long>();

        String query = buildQuery(criteria, StandardsListUtil.STD_TYPE_STANDARD, config);
        List<StandardsExt> records = runQuery(query);
        LOG.debug("Fetch STD records for config = " + config.getId() + " query returned " + records.size() + " records.");
        addToList(records, standards, stdIds, missedStdIds, RECORD_TYPE_STD);

        if (allowRunQuery(criteria, StandardsListUtil.STD_TYPE_SPEC))
        {
            query = buildQuery(criteria, StandardsListUtil.STD_TYPE_SPEC, config);
            records = runQuery(query);
            LOG.debug("Fetch SPEC records for config = " + config.getId() + " query returned " + records.size() + " records.");
            addToList(records, standards, stdIds, missedStdIds, RECORD_TYPE_SPEC);
        }
        if (allowRunQuery(criteria, StandardsListUtil.STD_TYPE_GDLN))
        {
            query = buildQuery(criteria, StandardsListUtil.STD_TYPE_GDLN, config);
            records = runQuery(query);
            LOG.debug("Fetch GDLN records for config = " + config.getId() + " query returned " + records.size() + " records.");
            addToList(records, standards, stdIds, missedStdIds, RECORD_TYPE_GDLN);
        }

        if (!missedStdIds.isEmpty())
        {
            query = buildQuery(criteria, config, missedStdIds);
            List<StandardsExt> missedRecords = runQuery(query);
            LOG.debug("Fetch missed STD records for config = " + config.getId() + " query returned " + records.size()
                    + " records.");
            standards.addAll(missedRecords);
        }

        if (criteria.isFetchAllSpecGuideline())
        {
            query = buildQueryPrntStdId(criteria, config, stdIds);
            records = runQuery(query);
            addToList(records, standards, stdIds, missedStdIds, RECORD_TYPE_SPEC);
        }

        return standards;
    }

    /**
     * Add records to final list.
     * 
     * @param records - records from database
     * @param standards - resulting list
     */
    private void addToList(final List<StandardsExt> records, final List<StandardsExt> standards, final List<Long> stdIds,
            final List<Long> missedStdIds, int recType)
    {
        for (StandardsExt std : records)
        {
            if (!standards.contains(std))
            {
                standards.add(std);
            }
            if (recType == RECORD_TYPE_STD && !stdIds.contains(std.getStdId()))
            {
                stdIds.add(std.getStdId());
            }
            else if (!stdIds.contains(std.getStdPrntId()))
            {
                stdIds.add(std.getStdPrntId());
                missedStdIds.add(std.getStdPrntId());
            }
        }
    }

    /**
     * Run provided query.
     * 
     * @param query - query
     * @return list of records
     */
    @SuppressWarnings("unchecked")
    private List<StandardsExt> runQuery(final String query)
    {
        Session session = null;
        List<StandardsExt> result = new ArrayList<StandardsExt>();
        try
        {
            session = openSession();
            final SQLQuery qry = session.createSQLQuery(query);
            qry.addEntity("StandardsExt", StandardsExtImpl.class);
            result = (List<StandardsExt>) qry.list();
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return result;
    }

    /**
     * Build query for search criteria.
     * 
     * @param criteria - search criteria
     * @param stdType - record type
     * @param config Report Configuration
     * @return - query
     * @throws SystemException - exception
     */
    private String buildQuery(final CMSSearchCriteria criteria, final String stdType, final ReportConfig config)
            throws SystemException
    {
        final StringBuilder query = buildSelectClause();
        final StringBuilder from = buildFromClause();
        final StringBuilder where = buildWhereClause();
        updateQueryWithSecondLanguage(config, criteria, query, from, where, false);
        updateQueryWithAssignImage(criteria, from, where, false);
        updateQueryWithRules(config, query, from, where, criteria.getPreferedBrand());
        updateQueryWithConfig(config, query, from, where, criteria.getPreferedBrand(), criteria.getDiscontFilter());
        updateQueryWithAuditLogComments(criteria, config, query, from, where);
        buildConditions(criteria, from, where, stdType);
        query.append(from);
        query.append(where);
        LOG.debug("Query for type: " + stdType + " ==" + query);
        return query.toString();
    }

    /**
     * Build query to fetch specified standards.
     * 
     * @param criteria - search criteria
     * @param config Report Configuration
     * @param stdIds standards needs to be selected from database
     * @return - query
     * @throws SystemException - exception
     */
    private String buildQuery(final CMSSearchCriteria criteria, final ReportConfig config, final List<Long> stdIds)
            throws SystemException
    {
        final StringBuilder query = buildSelectClause();
        final StringBuilder from = buildFromClause();
        final StringBuilder where = buildWhereClause();
        updateQueryWithSecondLanguage(config, criteria, query, from, where, true);
        updateQueryWithAssignImage(criteria, from, where, true);
        updateQueryWithRules(config, query, from, where, criteria.getPreferedBrand());
        updateQueryWithConfig(config, query, from, where, criteria.getPreferedBrand(), criteria.getDiscontFilter());
        updateQueryWithAuditLogComments(null, config, query, from, where);
        updateQueryWithStandards(stdIds, where);
        query.append(from);
        query.append(where);
        LOG.debug("Query for missing Standards ==" + query);
        return query.toString();
    }

    /**
     * Build query to fetch standards by parent id.
     * 
     * @param criteria - search criteria
     * @param config Report Configuration
     * @param stdIds standards needs to be selected from database
     * @return - query
     * @throws SystemException - exception
     */
    private String buildQueryPrntStdId(final CMSSearchCriteria criteria, final ReportConfig config, final List<Long> stdIds)
            throws SystemException
    {
        final StringBuilder query = buildSelectClause();
        final StringBuilder from = buildFromClause();
        final StringBuilder where = buildWhereClause();
        updateQueryWithSecondLanguage(config, criteria, query, from, where, true);
        updateQueryWithAssignImage(criteria, from, where, true);
        updateQueryWithRules(config, query, from, where, criteria.getPreferedBrand());
        //        updateQueryWithStdImage(where);
        updateQueryWithConfig(config, query, from, where, criteria.getPreferedBrand(), criteria.getDiscontFilter());
        updateQueryWithAuditLogComments(null, config, query, from, where);
        updateQueryWithPrntStdId(stdIds, where);
        query.append(from);
        query.append(where);
        LOG.debug("Query for Parent Standard Id ==" + query);
        return query.toString();
    }

    /**
     * Update query with Standards
     * 
     * @param stdIds list of Standard id
     * @param where where clause
     */
    private void updateQueryWithStandards(final List<Long> stdIds, final StringBuilder where)
    {
        where.append(" AND ( ");

        StringBuilder build = new StringBuilder();
        for (Long id : stdIds)
        {
            if (build.length() == 0)
            {
                build.append(" S.STD_ID = " + id.toString());
            }
            else
            {
                build.append(" OR S.STD_ID = " + id.toString());
            }
        }
        where.append(build);
        where.append(" ) ");
    }

    /**
     * Update query with Parent Standard IDs.
     * 
     * @param stdIds list of Standard id
     * @param where where clause
     */
    private void updateQueryWithPrntStdId(final List<Long> stdIds, final StringBuilder where)
    {
        where.append(" AND S.STD_TYP != 'STD' ");
        where.append(" AND ( ");

        StringBuilder build = new StringBuilder();
        for (Long id : stdIds)
        {
            if (build.length() == 0)
            {
                build.append(" S.PRNT_STD_ID = " + id.toString());
            }
            else
            {
                build.append(" OR S.PRNT_STD_ID = " + id.toString());
            }
        }
        where.append(build);
        where.append(" ) ");
    }

    /**
     * Verify if system can run query for record type.
     * 
     * @param criteria - search criteria
     * @param stdType - record type
     * @return true/false
     */
    private boolean allowRunQuery(final CMSSearchCriteria criteria, final String stdType)
    {
        boolean allow = true;

        if (StandardsListUtil.STD_TYPE_GDLN.equals(stdType))
        {
            if (!StandardsListUtil.isNullOrBlank(criteria.getRationale())
                    || !StandardsListUtil.isNullOrBlank(criteria.getImpact())
                    || !StandardsListUtil.isNullOrBlank(criteria.getImpactComments()))
            {
                allow = false;
            }
        }
        else if (StandardsListUtil.STD_TYPE_SPEC.equals(stdType))
        {
            if (criteria.isHasGuidelines() || !StandardsListUtil.isNullOrBlank(criteria.getImpact())
                    || !StandardsListUtil.isNullOrBlank(criteria.getImpactComments()))
            {
                allow = false;
            }
        }
        return allow;
    }

    /**
     * Build conditions for query.
     * 
     * @param criteria - search criteria
     * @param from - from clause
     * @param where - where clause
     * @param stdType - record type
     * @throws SystemException - exception
     */
    private void buildConditions(final CMSSearchCriteria criteria, final StringBuilder from, final StringBuilder where,
            final String stdType) throws SystemException
    {
        final List<String> table = new ArrayList<String>();
        final List<String> whereClause = new ArrayList<String>();

        addBrandsCondition(criteria, table, whereClause);
        addCountriesCondition(criteria, table, whereClause);
        addFlagsCondition(criteria, table, whereClause);
        addIndexCondition(criteria, table, whereClause, stdType);
        addRecordIdCondition(criteria, whereClause);
        addAttachmentTypeCondition(criteria, table, whereClause);
        addHasLinksCondition(criteria, table, whereClause);
        addHistManualCondition(criteria, table, whereClause);
        addTitleTextCondition(criteria, whereClause, stdType);
        addRationaleCondition(criteria, whereClause, stdType);
        addStatusCondition(criteria, table, whereClause);
        addTechWriterCondition(criteria, whereClause);
        addStdOwnerCondition(criteria, whereClause);
        addBrandHallmarkCondition(criteria, whereClause);
        addCategoryCondition(criteria, whereClause);
        addChangeTypeCondition(criteria, whereClause);
        addLaunchDateCondition(criteria, whereClause);
        addCompDateCondition(criteria, whereClause);
        addHasGuidelinesCondition(criteria, whereClause, stdType);
        addImpactCondition(criteria, table, whereClause);
        addRegionCondition(criteria, whereClause);
        addInternalReferenceCondition(criteria, whereClause);
        addAuditLogCondition(criteria, table, whereClause);
        addCrossReferenceCondition(criteria, table, whereClause);

        // General criteria. Not part of advance search screen.
        whereClause.add("S.STD_TYP = '" + stdType + "' ");

        for (String tbl : table)
        {
            if (from.indexOf(tbl) < 0)
            {
                from.append(", ").append(tbl);
            }
        }

        for (String str : whereClause)
        {
            where.append(" AND ").append(str);
        }
    }

    /**
     * 
     * @param criteria
     * @param table
     * @param whereClause
     */
    private void addCrossReferenceCondition(CMSSearchCriteria criteria, List<String> table, List<String> whereClause)
    {
        addBooleanConditionsForCrossRef(criteria.isHasCrossReference(), "STD_XREF", "XREF", "REFERRING_STD_ID", table,
                whereClause);
    }

    /**
     * 
     * @param hasCrossReference
     * @param tableName
     * @param tableAlias
     * @param criteriaColumn
     * @param table
     * @param whereClause
     */
    private void addBooleanConditionsForCrossRef(boolean hasCrossReference, String tableName, String tableAlias,
            String criteriaColumn, List<String> table, List<String> whereClause)
    {
        if (hasCrossReference)
        {
            table.add(tableName + " " + tableAlias);
            whereClause.add(STD_TBL_STD_ID_EQ + tableAlias + ".REFERRING_STD_ID");
            final String exists = "EXISTS (SELECT " + criteriaColumn + " FROM " + tableName + " WHERE S.STD_ID = " + tableAlias
                    + ".REFERRING_STD_ID)";
            whereClause.add(exists);
        }
    }

    /**
     * Add filter for Brands.
     * 
     * @param criteria - search criteria
     * @param table - list of tables
     * @param whereClause - list of where clause conditions
     */
    private void addBrandsCondition(final CMSSearchCriteria criteria, final List<String> table,
            final List<String> whereClause)
    {
        addListConditions(criteria.getBrands(), "CHAIN_STD", "CH", "CHAIN_CD", table, whereClause);
        if (!StandardsListUtil.isNullOrBlank(criteria.getBrands()))
        {
            whereClause.add(" CH.ACTV_IND = 'Y' "); // TO AVOID INACTIVE BRAND.
        }
    }

    /**
     * Add filter for Countries.
     * 
     * @param criteria - search criteria
     * @param table - list of tables
     * @param whereClause - list of where clause conditions
     */
    private void addCountriesCondition(final CMSSearchCriteria criteria, final List<String> table,
            final List<String> whereClause)
    {
        addListConditions(criteria.getCountries(), "CTRY_STD", "CT", "CTRY_NM_CD", table, whereClause);
    }

    /**
     * Add filter for Flags.
     * 
     * @param criteria - search criteria
     * @param table - list of tables
     * @param whereClause - list of where clause conditions
     */
    private void addFlagsCondition(final CMSSearchCriteria criteria, final List<String> table,
            final List<String> whereClause)
    {
        addListConditionsNumber(criteria.getFlags(), "FLAG_STD", "FL", "FLAG_CATGY_ID", table, whereClause);
    }

    /**
     * Add filter for Index.
     * 
     * @param criteria - search criteria
     * @param table - list of tables
     * @param whereClause - list of where clause conditions
     * @param stdType - record type
     * @throws SystemException - exception
     */
    private void addIndexCondition(final CMSSearchCriteria criteria, final List<String> table,
            final List<String> whereClause, final String stdType) throws SystemException
    {
        final String index = criteria.getIndex();
        if (!StandardsListUtil.IsNullOrBlank(index))
        {
            final List<String> indexes = new ArrayList<String>();
            indexes.add(index);
            final long indexId = Long.parseLong(index);
            if (!criteria.isBranchOnly())
            {
                addChildIndexes(indexId, indexes);
            }

            addListConditionsNumber(indexes, "TS", "TAXONOMY_ID", whereClause);
        }
    }

    /**
     * Add filter for Standard, Specification or Guideline Id.
     * 
     * @param criteria - search criteria
     * @param whereClause - list of where clause conditions
     */
    private void addRecordIdCondition(final CMSSearchCriteria criteria, final List<String> whereClause)
    {
        if (!StandardsListUtil.isNullOrBlank(criteria.getStandardsIds()))
        {
            whereClause.add(StandardsListUtil.getWhereClause(criteria.getStandardsIds(), "S.STD_ID",
                    StandardsListUtil.COLUMN_TYPE_NUMBER_START, StandardsListUtil.COLUMN_TYPE_NUMBER_END, true).toString());
        }
    }

    /**
     * Add filter for Attachment Type.
     * 
     * @param criteria - search criteria
     * @param table - list of tables
     * @param whereClause - list of where clause conditions
     */
    private void addAttachmentTypeCondition(final CMSSearchCriteria criteria, final List<String> table,
            final List<String> whereClause)
    {
        addListConditions(criteria.getAttachType(), "STD_ATTACHMENT", "AT", "ATTACHMENT_TYP", table, whereClause);
    }

    /**
     * Add filter for Has Links flag.
     * 
     * @param criteria - search criteria
     * @param table - list of tables
     * @param whereClause - list of where clause conditions
     */
    private void addHasLinksCondition(final CMSSearchCriteria criteria, final List<String> table,
            final List<String> whereClause)
    {
        addBooleanConditions(criteria.isHasLinks(), "STD_EXTL_LINK", "EXL", "STD_ID", table, whereClause);
    }

    /**
     * Add filter for Historical Manual.
     * 
     * @param criteria - search criteria
     * @param table - list of tables
     * @param whereClause - list of where clause conditions
     */
    private void addHistManualCondition(final CMSSearchCriteria criteria, final List<String> table,
            final List<String> whereClause)
    {
        if (!StandardsListUtil.IsNullOrBlank(criteria.getHistManual()))
        {
            table.add("STD_MNL ML");
            whereClause.add(STD_TBL_STD_ID_EQ + "ML.STD_ID AND ML.HST_MNL_ID = " + criteria.getHistManual());
        }
    }

    /**
     * Add filter for Title Text (Search Criteria).
     * 
     * @param criteria - search criteria
     * @param whereClause - list of where clause conditions
     * @param stdType - record type
     */
    private void addTitleTextCondition(final CMSSearchCriteria criteria, final List<String> whereClause,
            final String stdType)
    {
        final List<String> searchText = criteria.getTitleText();
        if (!StandardsListUtil.isNullOrBlank(searchText))
        {
            final String textSearchType = criteria.getTextSearchType();
            if (StandardsListUtil.STD_TYPE_GDLN.equals(stdType))
            {
                if (TEXT_ANY_WORD_MATCH.equals(textSearchType) || TEXT_EXACT_MATCH.equals(textSearchType))
                {
                    whereClause.add(StandardsListUtil.getWhereClause(searchText, "UPPER(S.STD_DESC)",
                            StandardsListUtil.COLUMN_TYPE_STRING_MATCH_START, StandardsListUtil.COLUMN_TYPE_STRING_MATCH_END,
                            true).toString());
                }
                else
                {
                    whereClause.add(StandardsListUtil.getWhereClauseForAllWords(searchText, "UPPER(S.STD_DESC)",
                            StandardsListUtil.COLUMN_TYPE_STRING_MATCH_START, StandardsListUtil.COLUMN_TYPE_STRING_MATCH_END,
                            true).toString());
                }
            }
            else
            {
                if (TEXT_ANY_WORD_MATCH.equals(textSearchType) || TEXT_EXACT_MATCH.equals(textSearchType))
                {
                    whereClause.add(StandardsListUtil.getWhereClause(searchText, "UPPER(S.TITLE_TXT)",
                            StandardsListUtil.COLUMN_TYPE_STRING_MATCH_START, StandardsListUtil.COLUMN_TYPE_STRING_MATCH_END,
                            true).toString());
                }
                else
                {
                    whereClause.add(StandardsListUtil.getWhereClauseForAllWords(searchText, "UPPER(S.TITLE_TXT)",
                            StandardsListUtil.COLUMN_TYPE_STRING_MATCH_START, StandardsListUtil.COLUMN_TYPE_STRING_MATCH_END,
                            true).toString());
                }

            }
        }
    }

    /**
     * Add filter for Rationale.
     * 
     * @param criteria - search criteria
     * @param whereClause - list of where clause conditions
     * @param stdType - record type
     */
    private void addRationaleCondition(final CMSSearchCriteria criteria, final List<String> whereClause,
            final String stdType)
    {
        if (!StandardsListUtil.STD_TYPE_GDLN.equals(stdType) && !StandardsListUtil.isNullOrBlank(criteria.getRationale()))
        {
            whereClause.add(StandardsListUtil.getWhereClause(criteria.getRationale(), "UPPER(S.STD_DESC)",
                    StandardsListUtil.COLUMN_TYPE_STRING_MATCH_START, StandardsListUtil.COLUMN_TYPE_STRING_MATCH_END, true)
                    .toString());
        }
    }

    /**
     * Add filter for Status.
     * 
     * @param criteria - search criteria
     * @param whereClause - list of where clause conditions
     */
    private void addStatusCondition(final CMSSearchCriteria criteria, final List<String> table,
            final List<String> whereClause)
    {
        if (!StandardsListUtil.isNullOrBlank(criteria.getStatus()))
        {
            if (!table.contains("CHAIN_STD CH"))
            {
                table.add("CHAIN_STD CH");
                whereClause.add("S.STD_ID = CH.STD_ID");
                whereClause.add(" CH.ACTV_IND = 'Y' "); // TO AVOID INACTIVE BRAND.
            }
            table.add("STAT ST");
            whereClause.add("CH.STAT_ID = ST.STAT_ID");
            whereClause.add(StandardsListUtil.getWhereClause(criteria.getStatus(), "ST.STAT_CD",
                    StandardsListUtil.COLUMN_TYPE_STRING_EXACT_START, StandardsListUtil.COLUMN_TYPE_STRING_EXACT_END).toString());
        }
    }

    /**
     * Add filter for Technical Writer.
     * 
     * @param criteria - search criteria
     * @param whereClause - list of where clause conditions
     */
    private void addTechWriterCondition(final CMSSearchCriteria criteria, final List<String> whereClause)
    {
        if (!StandardsListUtil.isNullOrBlank(criteria.getTechWriter()))
        {
            whereClause.add(StandardsListUtil.getWhereClause(criteria.getTechWriter(), "S.AUTHOR_NM_TXT",
                    StandardsListUtil.COLUMN_TYPE_STRING_MATCH_START, StandardsListUtil.COLUMN_TYPE_STRING_MATCH_END).toString());
        }
    }

    /**
     * Add filter for Record Owner.
     * 
     * @param criteria - search criteria
     * @param whereClause - list of where clause conditions
     */
    private void addStdOwnerCondition(final CMSSearchCriteria criteria, final List<String> whereClause)
    {
        if (!StandardsListUtil.isNullOrBlank(criteria.getStdOwner()))
        {
            whereClause.add(StandardsListUtil.getWhereClause(criteria.getStdOwner(), "S.BUS_OWNER_NM",
                    StandardsListUtil.COLUMN_TYPE_STRING_EXACT_START, StandardsListUtil.COLUMN_TYPE_STRING_EXACT_END).toString());
        }
    }

    /**
     * Add filter for Brand Hallmark.
     * 
     * @param criteria - search criteria
     * @param whereClause - list of where clause conditions
     */
    private void addBrandHallmarkCondition(final CMSSearchCriteria criteria, final List<String> whereClause)
    {
        if ("Y".equalsIgnoreCase(criteria.getBrandHallmark()))
        {
            whereClause.add("S.WAIVER_IND = 'Y'");
        }
    }

    /**
     * Add filter for Categories.
     * 
     * @param criteria - search criteria
     * @param whereClause - list of where clause conditions
     */
    private void addCategoryCondition(final CMSSearchCriteria criteria, final List<String> whereClause)
    {
        if (!StandardsListUtil.isNullOrBlank(criteria.getCategory()))
        {
            whereClause.add(StandardsListUtil.getWhereClause(criteria.getCategory(), "S.AREA_CATGY_CD",
                    StandardsListUtil.COLUMN_TYPE_STRING_EXACT_START, StandardsListUtil.COLUMN_TYPE_STRING_EXACT_END).toString());
        }
    }

    /**
     * Add filter for Change Type.
     * 
     * @param criteria - search criteria
     * @param whereClause - list of where clause conditions
     */
    private void addChangeTypeCondition(final CMSSearchCriteria criteria, final List<String> whereClause)
    {
        if (!StandardsListUtil.isNullOrBlank(criteria.getChangeType()))
        {
            whereClause.add(StandardsListUtil.getWhereClause(criteria.getChangeType(), "S.CHNG_DESC",
                    StandardsListUtil.COLUMN_TYPE_STRING_EXACT_START, StandardsListUtil.COLUMN_TYPE_STRING_EXACT_END).toString());
        }
    }

    /**
     * Add filter for Launch Date.
     * 
     * @param criteria - search criteria
     * @param whereClause - list of where clause conditions
     */
    private void addLaunchDateCondition(final CMSSearchCriteria criteria, final List<String> whereClause)
    {
        if (!StandardsListUtil.IsNullOrBlank(criteria.getFromLaunchDate())
                || !StandardsListUtil.IsNullOrBlank(criteria.getToLaunchDate()))
        {
            whereClause.add(StandardsListUtil.getWhereClauseDate(criteria.getFromLaunchDate(), criteria.getToLaunchDate(),
                    "S.EFF_DT").toString());
        }
    }

    /**
     * Add filter for Compliance Deadline.
     * 
     * @param criteria - search criteria
     * @param whereClause - list of where clause conditions
     */
    private void addCompDateCondition(final CMSSearchCriteria criteria, final List<String> whereClause)
    {
        if (!StandardsListUtil.IsNullOrBlank(criteria.getFromCompDate())
                || !StandardsListUtil.IsNullOrBlank(criteria.getToCompDate()))
        {
            whereClause.add(StandardsListUtil.getWhereClauseDate(criteria.getFromCompDate(), criteria.getToCompDate(),
                    "S.IMPLMNT_DEADLINE_DT").toString());
        }
    }

    /**
     * Add filter for Region.
     * 
     * @param criteria - search criteria
     * @param whereClause - list of where clause conditions
     */
    private void addRegionCondition(final CMSSearchCriteria criteria, final List<String> whereClause)
    {
        if (!StandardsListUtil.IsNullOrBlank(criteria.getEnteredBy()))
        {
            whereClause.add("S.RGN_CD = '" + criteria.getEnteredBy() + "'");
        }
    }

    /**
     * Add filter for Internal Reference.
     * 
     * @param criteria - search criteria
     * @param whereClause - list of where clause conditions
     */
    private void addInternalReferenceCondition(final CMSSearchCriteria criteria, final List<String> whereClause)
    {
        if (!StandardsListUtil.IsNullOrBlank(criteria.getInternalReference()))
        {
            whereClause.add("UPPER(S.STD_MGR_ID) LIKE '" + criteria.getInternalReference().toUpperCase() + "%'");
        }
    }

    /**
     * Add filter for has guideline flag.
     * 
     * @param criteria - search criteria
     * @param whereClause - list of where clause conditions
     * @param stdType - record type
     */
    private void addHasGuidelinesCondition(final CMSSearchCriteria criteria, final List<String> whereClause,
            final String stdType)
    {
        if (criteria.isHasGuidelines() && StandardsListUtil.STD_TYPE_STANDARD.equals(stdType))
        {
            whereClause
                    .add("EXISTS (SELECT STD2.STD_ID FROM STD STD2 WHERE S.STD_ID = STD2.PRNT_STD_ID AND STD2.STD_TYP = 'GDLN')");
        }
    }

    /**
     * Add filter for Profit & Loss, CapEx, Implementation Impacts.
     * 
     * @param criteria - search criteria
     * @param table - list of tables
     * @param whereClause - list of where clause conditions
     */
    private void addImpactCondition(final CMSSearchCriteria criteria, final List<String> table,
            final List<String> whereClause)
    {
        if (!StandardsListUtil.isNullOrBlank(criteria.getImpact()))
        {
            table.add("BUS_IMPACT_ASSMT_MNL BIA");
            whereClause.add(STD_TBL_STD_ID_EQ + "BIA.STD_ID");
            addListConditions(criteria.getProfitLossImpact(), "BIA", "PROFIT_LOSS_IMPACT_CD", whereClause);
            addListConditions(criteria.getCapExImpact(), "BIA", "CAP_EXPENSE_IMPACT_CD", whereClause);
            addListConditions(criteria.getImplementationImpact(), "BIA", "IMPLMNT_TIMESCALE_CD", whereClause);
            addListConditions(criteria.getChangeFromRegionalImpact(), "BIA", "CHG_FROM_RGN_TO_GBL_DESC", whereClause);

            if (!StandardsListUtil.isNullOrBlank(criteria.getImpactComments()))
            {
                whereClause.add(StandardsListUtil.getWhereClause(criteria.getImpactComments(), "UPPER(BIA.CMT_TXT)",
                        StandardsListUtil.COLUMN_TYPE_STRING_MATCH_START, StandardsListUtil.COLUMN_TYPE_STRING_MATCH_END, true)
                        .toString());
            }
        }
        else if (!StandardsListUtil.isNullOrBlank(criteria.getImpactComments()))
        {
            table.add("BUS_IMPACT_ASSMT_MNL BIA");
            whereClause.add(STD_TBL_STD_ID_EQ + "BIA.STD_ID");

            whereClause.add(StandardsListUtil.getWhereClause(criteria.getImpactComments(), "UPPER(BIA.CMT_TXT)",
                    StandardsListUtil.COLUMN_TYPE_STRING_MATCH_START, StandardsListUtil.COLUMN_TYPE_STRING_MATCH_END, true)
                    .toString());
        }
    }

    /**
     * Add filter for Assigned Images.
     * 
     * @param criteria - search criteria
     * @param from - from clause
     * @param where - where clause conditions
     * @param isParentSearch - flag to search for parent id
     */
    private void updateQueryWithAssignImage(final CMSSearchCriteria criteria, final StringBuilder from,
            final StringBuilder where, final boolean isParentSearch)
    {
        if (criteria != null && !StandardsListUtil.isNullOrBlank(criteria.getImageId()))
        {
            from.append(" , (SELECT SM.STD_ID, COUNT(SM.STD_ID) AS IMG_CNT, ");
            from.append("  LISTAGG(SM.IMAGE_TITLE_TXT, ', ') WITHIN GROUP (ORDER BY SM.STD_ID) AS IMG_TITLE ");
            from.append("  FROM STD_IMAGE SM ");
            from.append("  WHERE ");
            from.append(StandardsListUtil.getWhereClause(criteria.getImageId(), "SM.IMAGE_ID",
                    StandardsListUtil.COLUMN_TYPE_NUMBER_START, StandardsListUtil.COLUMN_TYPE_NUMBER_END, true).toString());
            from.append("  GROUP BY SM.STD_ID) SIMG ");

            if (isParentSearch)
            {
                where.append(" AND " + STD_TBL_STD_ID_EQ + "SIMG.STD_ID(+) ");
            }
            else
            {
                where.append(" AND " + STD_TBL_STD_ID_EQ + "SIMG.STD_ID");

            }
        }
        else
        {
            from.append(" , (SELECT SM.STD_ID, COUNT(SM.STD_ID) AS IMG_CNT, ");
            from.append("  LISTAGG(SM.IMAGE_TITLE_TXT, ', ') WITHIN GROUP (ORDER BY SM.STD_ID) AS IMG_TITLE ");
            from.append("  FROM STD_IMAGE SM ");
            from.append("  GROUP BY SM.STD_ID) SIMG ");
            where.append(" AND " + STD_TBL_STD_ID_EQ + "SIMG.STD_ID(+) ");
        }
    }

    /**
     * Add filter for Second Language.
     * 
     * @param config report configuration
     * @param criteria - search criteria
     * @param from - from clause
     * @param where - where clause conditions
     * @param isParentSearch - flag to search for parent id
     */
    private void updateQueryWithSecondLanguage(final ReportConfig config, final CMSSearchCriteria criteria,
            final StringBuilder query, final StringBuilder from, final StringBuilder where, final boolean isParentSearch)
    {
        if (!StandardsListUtil.IsNullOrBlank(config.getSecLanguage()))
        {
            query.append(" , TAX_SEC_LANG.title_txt AS SEC_LANG_INDX_TITLE, ");
            query.append(" TAX_SEC_LANG.taxonomy_desc AS SEC_LANG_INDX_DESC, ");
            query.append(" TAX_SEC_LANG.image_path_txt AS SEC_LANG_INDX_IMG_PATH, ");
            query.append(" CASE WHEN S.STD_TYP = 'GDLN' THEN ");
            query.append("  STD_SEC_LANG.STD_DESC ");
            query.append(" ELSE ");
            query.append("  STD_SEC_LANG.TITLE_TXT ");
            query.append(" END AS SEC_LANG_STD_TITLE, ");
            query.append(" STD_SEC_LANG.STD_DESC AS SEC_LANG_STD_DESC ");

            //            if (criteria == null)
            //            {
            //                from.append(" , (SELECT std_id, title_txt, std_desc, note_txt, cmt_txt FROM std_xlat ) STD_SEC_LANG , ");
            //                from.append("  (SELECT taxonomy_id, title_txt, taxonomy_desc, image_path_txt FROM taxonomy_xlat ) TAX_SEC_LANG ");
            //            }
            //            else
            //            {
            from.append(" , (SELECT std_id, title_txt, std_desc, note_txt, cmt_txt FROM std_xlat WHERE locale_cd = '"
                    + config.getSecLanguage() + "') STD_SEC_LANG , ");
            from.append("  (SELECT taxonomy_id, title_txt, taxonomy_desc, image_path_txt FROM taxonomy_xlat WHERE locale_cd = '"
                    + config.getSecLanguage() + "') TAX_SEC_LANG ");
            //            }

            //            if (!isParentSearch)
            //            {
            //                where.append(" AND " + STD_TBL_STD_ID_EQ + "STD_SEC_LANG.STD_ID(+) ");
            //                where.append(" AND " + "TAX.TAXONOMY_ID = TAX_SEC_LANG.TAXONOMY_ID(+) ");
            //            }
            //            else
            //            {
            where.append(" AND " + STD_TBL_STD_ID_EQ + "STD_SEC_LANG.STD_ID(+) ");
            where.append(" AND " + "TAX.TAXONOMY_ID = TAX_SEC_LANG.TAXONOMY_ID(+) ");
            //            }
        }
        else
        {
            query.append(" , NULL AS SEC_LANG_INDX_TITLE, ");
            query.append(" NULL AS SEC_LANG_INDX_DESC, ");
            query.append(" NULL AS SEC_LANG_INDX_IMG_PATH, ");
            query.append(" NULL AS SEC_LANG_STD_TITLE, ");
            query.append(" NULL AS SEC_LANG_STD_DESC ");
        }
    }

    /**
     * Add filter for Profit & Loss, CapEx, Implementation Impacts.
     * 
     * @param criteria - search criteria
     * @param table - list of tables
     * @param whereClause - list of where clause conditions
     */
    private void addAuditLogCondition(final CMSSearchCriteria criteria, final List<String> table,
            final List<String> whereClause)
    {
        /*        
                if (!StandardsListUtil.IsNullOrBlank(criteria.getSearchLog()))
                {
                    if (!StandardsListUtil.isNullOrBlank(criteria.getAuthors()))
                    {
                        whereClause.add(StandardsListUtil.getWhereClause(criteria.getAuthors(), "AUDIT_LOG.CREAT_USR_ID",
                                StandardsListUtil.COLUMN_TYPE_NUMBER_START, StandardsListUtil.COLUMN_TYPE_NUMBER_END).toString());
                    }
                    whereClause.add(StandardsListUtil.getWhereClauseDate(criteria.getLogDate(), criteria.getToLogDate(), "AUDIT_LOG.CREAT_TS"));
                    
                    
                    table.add("BUS_IMPACT_ASSMT_MNL BIA");
                    
                    whereClause.add(STD_TBL_STD_ID_EQ + "BIA.STD_ID");
                    
                    addListConditions(criteria.getProfitLossImpact(), "BIA", "PROFIT_LOSS_IMPACT_CD", whereClause);
                    addListConditions(criteria.getCapExImpact(), "BIA", "CAP_EXPENSE_IMPACT_CD", whereClause);
                    addListConditions(criteria.getImplementationImpact(), "BIA", "IMPLMNT_TIMESCALE_CD", whereClause);
                    addListConditions(criteria.getChangeFromRegionalImpact(), "BIA", "CHG_FROM_RGN_TO_GBL_DESC", whereClause);
                    
                    if (!StandardsListUtil.isNullOrBlank(criteria.getImpactComments()))
                    {
                        whereClause.add(StandardsListUtil.getWhereClause(criteria.getImpactComments(), "UPPER(BIA.CMT_TXT)",
                            StandardsListUtil.COLUMN_TYPE_STRING_MATCH_START, StandardsListUtil.COLUMN_TYPE_STRING_MATCH_END, true).toString());
                    }
                }
                else if (!StandardsListUtil.isNullOrBlank(criteria.getImpactComments()))
                {
                    table.add("BUS_IMPACT_ASSMT_MNL BIA");
                    whereClause.add(STD_TBL_STD_ID_EQ + "BIA.STD_ID");

                    whereClause.add(StandardsListUtil.getWhereClause(criteria.getImpactComments(), "UPPER(BIA.CMT_TXT)",
                            StandardsListUtil.COLUMN_TYPE_STRING_MATCH_START, StandardsListUtil.COLUMN_TYPE_STRING_MATCH_END, true).toString());
                }
        */
    }

    /**
     * Add conditions for list values.
     * 
     * @param criteria - search criteria
     * @param tableName - table name for condition
     * @param tableAlias - table alias
     * @param criteriaColumn - column name in the table
     * @param table - list of tables for query
     * @param whereClause - where clause for query
     */
    private void addListConditions(final List<String> criteria, final String tableName, final String tableAlias,
            final String criteriaColumn, final List<String> table, final List<String> whereClause)
    {
        if (!StandardsListUtil.isNullOrBlank(criteria))
        {
            table.add(tableName + " " + tableAlias);
            whereClause.add(STD_TBL_STD_ID_EQ + tableAlias + ".STD_ID");
            final StringBuilder buff = StandardsListUtil.getWhereClause(criteria, tableAlias + "." + criteriaColumn,
                    StandardsListUtil.COLUMN_TYPE_STRING_EXACT_START, StandardsListUtil.COLUMN_TYPE_STRING_EXACT_END);
            whereClause.add(buff.toString());
        }
    }

    /**
     * Add conditions for list values.
     * 
     * @param criteria - search criteria
     * @param tableName - table name for condition
     * @param tableAlias - table alias
     * @param criteriaColumn - column name in the table
     * @param table - list of tables for query
     * @param whereClause - where clause for query
     */
    private void addListConditionsNumber(final List<String> criteria, final String tableName, final String tableAlias,
            final String criteriaColumn, final List<String> table, final List<String> whereClause)
    {
        if (!StandardsListUtil.isNullOrBlank(criteria))
        {
            table.add(tableName + " " + tableAlias);
            whereClause.add(STD_TBL_STD_ID_EQ + tableAlias + ".STD_ID");
            final StringBuilder buff = StandardsListUtil.getWhereClause(criteria, tableAlias + "." + criteriaColumn,
                    StandardsListUtil.COLUMN_TYPE_NUMBER_START, StandardsListUtil.COLUMN_TYPE_NUMBER_END);
            whereClause.add(buff.toString());
        }
    }

    /**
     * Add conditions for list values.
     * 
     * @param criteria - search criteria
     * @param tableAlias - table alias
     * @param criteriaColumn - column name in the table
     * @param whereClause - where clause for query
     */
    private void addListConditions(final List<String> criteria, final String tableAlias, final String criteriaColumn,
            final List<String> whereClause)
    {
        if (!StandardsListUtil.isNullOrBlank(criteria))
        {
            final StringBuilder buff = StandardsListUtil.getWhereClause(criteria, tableAlias + "." + criteriaColumn,
                    StandardsListUtil.COLUMN_TYPE_STRING_EXACT_START, StandardsListUtil.COLUMN_TYPE_STRING_EXACT_END);
            whereClause.add(buff.toString());
        }
    }

    /**
     * Add conditions for list values.
     * 
     * @param criteria - search criteria
     * @param tableAlias - table alias
     * @param criteriaColumn - column name in the table
     * @param whereClause - where clause for query
     */
    private void addListConditionsNumber(final List<String> criteria, final String tableAlias, final String criteriaColumn,
            final List<String> whereClause)
    {
        if (!StandardsListUtil.isNullOrBlank(criteria))
        {
            final StringBuilder buff = StandardsListUtil.getWhereClause(criteria, tableAlias + "." + criteriaColumn,
                    StandardsListUtil.COLUMN_TYPE_NUMBER_START, StandardsListUtil.COLUMN_TYPE_NUMBER_END);
            whereClause.add(buff.toString());
        }
    }

    /**
     * Add condition for boolean value.
     * 
     * @param criteria - search criteria
     * @param tableName - table name
     * @param tableAlias - table alias
     * @param criteriaColumn - column for criteria
     * @param table - list of tables for query
     * @param whereClause - list of conditions in where clause
     */
    private void addBooleanConditions(final boolean criteria, final String tableName, final String tableAlias,
            final String criteriaColumn, final List<String> table, final List<String> whereClause)
    {
        if (criteria)
        {
            table.add(tableName + " " + tableAlias);
            whereClause.add(STD_TBL_STD_ID_EQ + tableAlias + ".STD_ID");
            final String exists = "EXISTS (SELECT " + criteriaColumn + " FROM " + tableName + " WHERE S.STD_ID = " + tableAlias
                    + ".STD_ID)";
            whereClause.add(exists);
        }
    }

    /**
     * Add all children to current index.
     * 
     * @param index - current index
     * @param indexes - list of indexes
     * @throws SystemException - exception
     */
    public void addChildIndexes(final long index, final List<String> indexes) throws SystemException
    {
        final List<Taxonomy> taxonomies = TaxonomyLocalServiceUtil.getTaxonomiesByParentId(index);
        for (Taxonomy taxonomy : taxonomies)
        {
            indexes.add(String.valueOf(taxonomy.getTaxId()));
            LOG.debug("the values in arlIndex are " + taxonomy.getTaxId());
            addChildIndexes(taxonomy.getTaxId(), indexes);
        }
    }

    /**
     * Build SELECT clause to fetch Standards and associated Indexes.
     * 
     * @return select clause of the query
     */
    private StringBuilder buildSelectClause()
    {
        final StringBuilder query = new StringBuilder();
        query.append(" SELECT DISTINCT ");
        query.append(" TAX.TAXONOMY_ID \"INDX_TAXONOMY_ID\", ");
        query.append(" TAX.TAXONOMY_ID AS ORIG_INDX_TAXONOMY_ID, ");
        query.append(" TAX.PRNT_TAXONOMY_ID \"INDX_PRNT_TAXONOMY_ID\", ");
        query.append(" TAX.TITLE_TXT \"INDX_TITLE_TXT\", ");
        query.append(" TAX.TLEVEL \"INDX_LEVEL\", ");
        query.append(" TAX.HIER_LVL_NBR \"INDX_HIER_LVL_NBR\", ");
        query.append(" TAX.PATH \"INDX_PATH\", ");
        query.append(" S.STD_ID, ");
        query.append(" S.PRNT_STD_ID \"STD_PRNT_STD_ID\", ");
        query.append(" 0 AS STD_ORIG_STD_ID, ");
        query.append(" 'none' AS STD_CTRY_CD, ");
        query.append(" NULL AS STD_PUBLISH_STAT_CD, ");
        query.append(" S.STD_TYP, ");
        query.append(" CASE WHEN S.STD_TYP = 'GDLN' THEN ");
        query.append("     S.STD_DESC ");
        query.append(" ELSE ");
        query.append("     S.TITLE_TXT ");
        query.append(" END \"STD_TITLE_TXT\", ");
        query.append(" S.STD_DESC, ");
        query.append(" S.DISP_ORDER_NBR, ");
        query.append(" S.BUS_OWNER_NM \"STD_BUS_OWNER_NM\", ");
        query.append(" S.AUTHOR_NM_TXT \"STD_AUTHOR_NM\", ");
        query.append(" S.AREA_CATGY_CD \"STD_AREA_CATGY_CD\", ");
        query.append(" S.CHNG_DESC \"STD_CHNG_DESC\", ");
        query.append(" S.CREATOR_SCRN_NM \"STD_CREATOR_SCRN_NM\", ");
        query.append(" DECODE(S.GBL_RGN_IND, 'N', NVL((SELECT CTRY_NM_CD FROM CTRY_STD WHERE STD_ID = S.STD_ID and ROWNUM = 1), 'N'), S.GBL_RGN_IND) AS STD_GBL_RGN_IND, ");
        query.append(" S.RGN_CD \"STD_RGN_CD\", ");
        query.append(" S.FRAMEWORK_STD_IND, ");
        query.append(" S.STD_MGR_ID, ");
        query.append(" S.LST_UPDT_TS \"STD_LST_UPDT_TS\", ");
        query.append(" NVL(SIMG.IMG_CNT, 0) AS STD_IMG_CNT, SIMG.IMG_TITLE AS STD_IMG_TITLE ");

        return query;
    }

    /**
     * Build FROM clause to fetch Standards and associated Indexes.
     * 
     * @return FROM clause of the query
     */
    private StringBuilder buildFromClause()
    {
        final StringBuilder query = new StringBuilder();
        query.append(" FROM ");
        query.append(" (SELECT T.TAXONOMY_ID, T.PRNT_TAXONOMY_ID, T.TITLE_TXT, (LEVEL - 1) \"TLEVEL\", T.HIER_LVL_NBR, ");
        query.append("  SUBSTR(SYS_CONNECT_BY_PATH(TITLE_TXT, ' -> '), 21) \"PATH\" ");
        query.append("  FROM TAXONOMY T ");
        query.append(" START WITH T.TAXONOMY_ID = 1 ");
        query.append(" CONNECT BY NOCYCLE PRIOR T.TAXONOMY_ID = T.PRNT_TAXONOMY_ID ");
        query.append(" ) TAX, ");
        query.append(" STD S, TAXONOMY_STD TS ");

        return query;
    }

    /**
     * Build WHERE clause to fetch Standards and associated Indexes.
     * 
     * @return WHEER clause of the query
     */
    private StringBuilder buildWhereClause()
    {
        final StringBuilder query = new StringBuilder();
        query.append(" WHERE TS.TAXONOMY_ID = TAX.TAXONOMY_ID ");
        query.append(" AND (TS.STD_ID = S.STD_ID OR TS.STD_ID = S.PRNT_STD_ID) ");
        query.append(" AND S.STAT_DESC != 'DELETED' ");

        return query;
    }

    /**
     * Add rules to the query.
     */
    private void updateQueryWithRules(ReportConfig config, StringBuilder select, StringBuilder from, StringBuilder where, String prefBrand)
    {
        if (existsClassFiledName(CFG_FIELD_NAME_COMPLY_RULE_EXPIRES, config) && !BSCommonConstants.ALL_BRAND.equalsIgnoreCase(prefBrand))
        {
            select.append(", NVL((SELECT COMPLY.CMPLY_RULE_MO_NBR FROM STD_RGN_CHAIN COMPLY WHERE COMPLY.CHAIN_CD = '");
            select.append(prefBrand);
            select.append("' AND COMPLY.STD_ID = S.STD_ID AND COMPLY.RGN_CD = 'GLBL'), NULL) GLBL_RUL");
            select.append(", NVL((SELECT COMPLY.CMPLY_RULE_MO_NBR FROM STD_RGN_CHAIN COMPLY WHERE COMPLY.CHAIN_CD = '");
            select.append(prefBrand);
            select.append("' AND COMPLY.STD_ID = S.STD_ID AND COMPLY.RGN_CD = 'AMEA'), NULL) AMEA_RUL");
            select.append(", NVL((SELECT COMPLY.CMPLY_RULE_MO_NBR FROM STD_RGN_CHAIN COMPLY WHERE COMPLY.CHAIN_CD = '");
            select.append(prefBrand);
            select.append("' AND COMPLY.STD_ID = S.STD_ID AND COMPLY.RGN_CD = 'AMER'), NULL) AMER_RUL");
            select.append(", NVL((SELECT COMPLY.CMPLY_RULE_MO_NBR FROM STD_RGN_CHAIN COMPLY WHERE COMPLY.CHAIN_CD = '");
            select.append(prefBrand);
            select.append("' AND COMPLY.STD_ID = S.STD_ID AND COMPLY.RGN_CD = 'EURO'), NULL) EURO_RUL");
            select.append(", NVL((SELECT COMPLY.CMPLY_RULE_MO_NBR FROM STD_RGN_CHAIN COMPLY WHERE COMPLY.CHAIN_CD = '");
            select.append(prefBrand);
            select.append("' AND COMPLY.STD_ID = S.STD_ID AND COMPLY.RGN_CD = 'GC'), NULL) GC_RUL");
            select.append(", NVL((SELECT LISTAGG(COMPLY.EXPIRED_BY_REF_TXT,',')  WITHIN GROUP (ORDER BY COMPLY.STD_ID) ");
            select.append("FROM STD_RGN_CHAIN COMPLY WHERE COMPLY.CHAIN_CD = '");
            select.append(prefBrand);
            select.append("' AND COMPLY.STD_ID = S.STD_ID GROUP BY COMPLY.STD_ID), NULL) EXPIRES ");
        }
        else
        {
            select.append(", '' GLBL_RUL, '' AMEA_RUL, '' AMER_RUL, '' EURO_RUL, '' GC_RUL, '' EXPIRES ");
        }
    }
    
    public List<Long> getStandardsByChain(String chainCode) throws SystemException
    {
    	List<Long> arlStandards = new ArrayList<Long>();
    	Session session = null;
    	try
    	{
    		session = openSession();
    		String query = "SELECT std_id FROM chain_std WHERE actv_ind = 'Y' AND chain_cd = '" + chainCode + "'";
            SQLQuery q = session.createSQLQuery(query);
            List arlStandardsExt = q.list();
            
            for(int i=0; i<arlStandardsExt.size(); i++)
            {
            	BigDecimal d = (BigDecimal) arlStandardsExt.get(i);
            	long l = d.longValue();
            	arlStandards.add(l);
            }
            	
    	}
    	catch (ORMException orm)
        {
    		LOG.error("Catch ORMException: ", orm);
        }
        catch (Exception e)
        {
        	LOG.error("Catch Exception: ", e);
        }
        finally
        {
            closeSession(session);
        }
    	return arlStandards;
    }
}
