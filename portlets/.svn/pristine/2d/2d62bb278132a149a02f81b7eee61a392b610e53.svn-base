package com.ihg.brandstandards.db.service.persistence;

import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.ihg.brandstandards.custom.model.CMSSearchCriteria;
import com.ihg.brandstandards.db.NoSuchStandardsException;
import com.ihg.brandstandards.db.model.PublishExtStd;
import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.Taxonomy;
import com.ihg.brandstandards.db.model.impl.PublishExtStdImpl;
import com.ihg.brandstandards.db.model.impl.StandardsImpl;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.ihg.brandstandards.db.service.TaxonomyLocalServiceUtil;
import com.ihg.brandstandards.util.BSCommonConstants;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.ihg.brandstandards.util.StandardsListUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

/**
 * Find Standards based on search criteria.
 * 
 * @author KhandeN
 * 
 */
public class StandardsFinderImpl extends BasePersistenceImpl<Standards> implements StandardsFinder
{
    private static final Log LOG = LogFactoryUtil.getLog(StandardsFinderImpl.class);

    /**
     * Find Standards based on search criteria.
     * 
     * @param criteriaMap - search criteria
     * @param approverFlag - is approver flag
     * @param standardId - standard id
     * @param stdType - record type (STD, SPEC, GDLN)
     * @return list of records.
     * @throws SystemException - exception
     */
    public List<Standards> getStandardsAdvancedFilterResults(final Map<String, ?> criteriaMap, final boolean approverFlag,
            final String standardId, final String stdType, final String preferBrand, final String discontFilter)
            throws SystemException
    {
        final CMSSearchCriteria criteria = (CMSSearchCriteria) criteriaMap.get("StandardsSearchCriteria");
        final List<String> arlBrands = criteria.getBrands();
        final List<String> arlCountries = criteria.getCountries();
        final List<String> searchCriteria = criteria.getSearchCriteria();
        final List<String> arlStatus = criteria.getStatus();
        final List<String> arlTechWriter = criteria.getTechWriter();
        final List<String> arlStdOwner = criteria.getStdOwner();
        final List<String> arlCategory = criteria.getCategory();
        final List<String> arlAttachType = criteria.getAttachType();
        final List<String> arlChangeType = criteria.getChangeType();
        final List<String> arlRationale = criteria.getRationale();
        final List<String> arlFlags = criteria.getFlags();
        final List<String> arlImpactAssmnt = criteria.getImpact();
        final List<String> arlStandardsIds = criteria.getStandardsIds();
        final List<String> assignedImages = criteria.getImageId();
        final List<String> auditLogBrands = criteria.getAuditLogBrands();
        final String fromLaunchDate = criteria.getFromLaunchDate();
        final String toLaunchDate = criteria.getToLaunchDate();
        final String fromCompDate = criteria.getFromCompDate();
        final String toCompDate = criteria.getToCompDate();
        final String brandHallmark = criteria.getBrandHallmark();
        final String histManual = criteria.getHistManual();
        final String index = criteria.getIndex();
        final List<String> arlAuthor = criteria.getAuthors();
        final String logSearch = criteria.getSearchLog();
        final String logDate = criteria.getLogDate();
        final String toLogDate = criteria.getToLogDate();
        final String enteredBy = criteria.getEnteredBy();
        final String internalReference = criteria.getInternalReference();
        final boolean hasLinks = criteria.isHasLinks();
        final boolean hasGuidelines = criteria.isHasGuidelines();
        final boolean hasCrossReference = criteria.isHasCrossReference();
        final boolean indxBranchOnly = criteria.isBranchOnly();
        final String textSearchType = criteria.getTextSearchType();
        List<Standards> arlResults = new ArrayList<Standards>();
        Session session = null;
        final List<StringBuilder> tables = new ArrayList<StringBuilder>();
        final List<StringBuilder> clauses = new ArrayList<StringBuilder>();
        StringBuilder rationaleClause = null;
        String stat_id = StringPool.BLANK;
        if ("true".equals(discontFilter))
        {
            stat_id = "nvl((select chn.stat_id from chain_std chn, stat dst where chn.ACTV_IND = 'Y' AND chn.std_id = a.std_id AND chn.stat_id = dst.stat_id AND (dst.stat_cd NOT IN ('D_FOR_REF','D_NOT_RQ','D_RPLCD')) AND chn.chain_cd = '"
                    + preferBrand + "'), 0) \"STAT_ID\"";
        }
        else
        {
            stat_id = "nvl((select chn.stat_id from chain_std chn where chn.ACTV_IND = 'Y' AND chn.std_id = a.std_id AND chn.chain_cd = '"
                    + preferBrand + "'), 0) \"STAT_ID\"";
        }
        try
        {
            session = openSession();
            final StringBuilder selectQuery = new StringBuilder(
                    " select distinct a.std_id, a.prnt_std_id, a.std_typ, a.title_txt, a.std_desc, a.BUS_OWNER_NM, a.EFF_DT,   "
                            + " a.implmnt_deadline_dt, a.waiver_ind, a.stat_desc, a.area_catgy_cd, a.gbl_rgn_ind, a.chng_desc, a.rgn_cd, a.author_nm_txt,   "
                            + " a.note_txt, a.framework_std_ind, a.STD_MGR_ID, a.creator_scrn_nm, a.creat_usr_id, a.creat_ts, a.lst_updt_usr_id, a.lst_updt_ts,"
                            + stat_id + " , a.RGN_ID, a.DISP_ORDER_NBR ");
            tables.add(new StringBuilder("std a"));
            if (!StandardsListUtil.isNullOrBlank(arlBrands))
            {
                tables.add(new StringBuilder("chain_std b"));
                clauses.add(new StringBuilder("a.std_id = b.std_id"));
                clauses.add(StandardsListUtil.getWhereClause(arlBrands, "b.chain_cd",
                        StandardsListUtil.COLUMN_TYPE_STRING_EXACT_START, StandardsListUtil.COLUMN_TYPE_STRING_EXACT_END));
                clauses.add(new StringBuilder("b.ACTV_IND = 'Y' "));    // TO AVOID INACTIVE BRAND.
                if (!StandardsListUtil.isNullOrBlank(arlStatus) || "true".equals(discontFilter))
                {
                    tables.add(new StringBuilder("stat st"));
                    clauses.add(new StringBuilder("b.stat_id = st.stat_id"));
                    if (!StandardsListUtil.isNullOrBlank(arlStatus))
                    {
                        clauses.add(StandardsListUtil.getWhereClause(arlStatus, "st.stat_cd",
                                StandardsListUtil.COLUMN_TYPE_STRING_EXACT_START, StandardsListUtil.COLUMN_TYPE_STRING_EXACT_END));
                    }
                    if ("true".equals(discontFilter))
                    {
                        clauses.add(new StringBuilder("(st.stat_cd NOT IN ('D_FOR_REF','D_NOT_RQ','D_RPLCD'))"));
                    }
                }
            }
            else if (!StandardsListUtil.isNullOrBlank(arlStatus) || "true".equals(discontFilter))
            {
                tables.add(new StringBuilder("chain_std b"));
                clauses.add(new StringBuilder("a.std_id = b.std_id"));
                clauses.add(new StringBuilder("b.ACTV_IND = 'Y' "));    // TO AVOID INACTIVE BRAND.
                tables.add(new StringBuilder("stat st"));
                clauses.add(new StringBuilder("b.stat_id = st.stat_id"));

                if (!StandardsListUtil.isNullOrBlank(arlStatus))
                {
                    clauses.add(StandardsListUtil.getWhereClause(arlStatus, "st.stat_cd",
                            StandardsListUtil.COLUMN_TYPE_STRING_EXACT_START, StandardsListUtil.COLUMN_TYPE_STRING_EXACT_END));
                }
                if ("true".equals(discontFilter))
                {
                    clauses.add(new StringBuilder("(st.stat_cd NOT IN ('D_FOR_REF','D_NOT_RQ','D_RPLCD'))"));
                }
            }

            if (!StandardsListUtil.isNullOrBlank(arlCountries))
            {
                tables.add(new StringBuilder("ctry_std c"));
                clauses.add(new StringBuilder("a.std_id = c.std_id"));
                clauses.add(StandardsListUtil.getWhereClause(arlCountries, "c.ctry_nm_cd",
                        StandardsListUtil.COLUMN_TYPE_STRING_EXACT_START, StandardsListUtil.COLUMN_TYPE_STRING_EXACT_END));
            }
            if (!StandardsListUtil.isNullOrBlank(arlFlags))
            {
                tables.add(new StringBuilder("flag_std d"));
                clauses.add(new StringBuilder("a.std_id = d.std_id"));
                clauses.add(StandardsListUtil.getWhereClause(arlFlags, "d.flag_catgy_id",
                        StandardsListUtil.COLUMN_TYPE_NUMBER_START, StandardsListUtil.COLUMN_TYPE_NUMBER_END));
            }
            if (!StandardsListUtil.IsNullOrBlank(logSearch) && logSearch.equals("Y"))
            {	
                tables.add(new StringBuilder("workflow_actv_log e"));
                clauses.add(new StringBuilder("a.std_id = e.object_id"));
                if (!StandardsListUtil.isNullOrBlank(arlAuthor))
                {
                    clauses.add(StandardsListUtil.getWhereClause(arlAuthor, "e.creat_usr_id",
                            StandardsListUtil.COLUMN_TYPE_NUMBER_START, StandardsListUtil.COLUMN_TYPE_NUMBER_END));
                }
                if (!StandardsListUtil.isNullOrBlank(auditLogBrands) && !auditLogBrands.contains("all"))
                {
                    clauses.add(StandardsListUtil.getWhereClause(auditLogBrands, "e.chain_cd",
                            StandardsListUtil.COLUMN_TYPE_STRING_EXACT_START, StandardsListUtil.COLUMN_TYPE_STRING_EXACT_END));
                }
                clauses.add(StandardsListUtil.getWhereClauseDate(logDate, toLogDate, "e.creat_ts"));

            }
            if (!StandardsListUtil.IsNullOrBlank(index))
            {
                if (!stdType.equals(StandardsListUtil.STD_TYPE_STANDARD))
                {
                    return arlResults;
                }
                final long indexLong = Long.parseLong(index);
                final List<String> arlIndex = new ArrayList<String>();
                arlIndex.add(String.valueOf(indexLong));
                if (!indxBranchOnly)
                {
                    addChildTaxonomies(indexLong, arlIndex);
                }
                tables.add(new StringBuilder("taxonomy_std e"));
                clauses.add(new StringBuilder("a.std_id = e.std_id"));
                StringBuilder strIndexes = StandardsListUtil.getWhereClause(arlIndex, "e.taxonomy_id",
                        StandardsListUtil.COLUMN_TYPE_NUMBER_START, StandardsListUtil.COLUMN_TYPE_NUMBER_END);
                //logger.debug("Indexes  : "+ strIndexes);
                clauses.add(strIndexes);
            }

            if (!StandardsListUtil.isNullOrBlank(arlAttachType))
            {
                tables.add(new StringBuilder("std_attachment f"));
                clauses.add(new StringBuilder("a.std_id = f.std_id"));
                clauses.add(StandardsListUtil.getWhereClause(arlAttachType, "f.attachment_typ",
                        StandardsListUtil.COLUMN_TYPE_STRING_EXACT_START, StandardsListUtil.COLUMN_TYPE_STRING_EXACT_END));
            }
            if (hasLinks)
            {
                tables.add(new StringBuilder("std_extl_link g"));
                clauses.add(new StringBuilder("a.std_id = g.std_id"));
                clauses.add(new StringBuilder("exists (select std_id from std_extl_link where a.std_id = g.std_id)"));

            }
            if (!StandardsListUtil.IsNullOrBlank(enteredBy))
            {
                clauses.add(new StringBuilder("a.rgn_cd = '" + enteredBy + "'"));
            }
            if (!StandardsListUtil.IsNullOrBlank(internalReference))
            {
                clauses.add(new StringBuilder("UPPER(a.STD_MGR_ID) LIKE '" + internalReference.toUpperCase() + "%' "));
            }
            if (!StandardsListUtil.IsNullOrBlank(histManual))
            {
                tables.add(new StringBuilder("std_mnl h"));
                clauses.add(new StringBuilder("a.std_id = h.std_id and h.hst_mnl_id = " + histManual));
            }
            if (!StandardsListUtil.isNullOrBlank(searchCriteria))
            {
                if (stdType.equals(StandardsListUtil.STD_TYPE_GDLN))
                {
                    if ("any".equals(textSearchType))
                    {
                        StringBuilder search  = new StringBuilder("( ");
                        search.append(StandardsListUtil.getWhereClauseForExactWords(searchCriteria, "upper(a.std_desc)",
                                StandardsListUtil.COLUMN_TYPE_STRING_EXACT_MATCH_START, StandardsListUtil.COLUMN_TYPE_STRING_EXACT_MATCH_END,
                                true));
                        search.append(" OR ");
                        search.append(StandardsListUtil.getWhereClauseForImageAnyWords(searchCriteria, "a.std_id",
                                StandardsListUtil.COLUMN_TYPE_STRING_EXACT_MATCH_START, StandardsListUtil.COLUMN_TYPE_STRING_EXACT_MATCH_END,
                                true));
                        search.append(" )");
                        clauses.add(search);
                        
                    }
                    else if ("exact".equals(textSearchType))
                    {
                        StringBuilder search  = new StringBuilder("( ");
                        search.append(StandardsListUtil.getWhereClauseForExactWords(searchCriteria, "upper(a.std_desc)",
                                StandardsListUtil.COLUMN_TYPE_STRING_EXACT_MATCH_START, StandardsListUtil.COLUMN_TYPE_STRING_EXACT_MATCH_END,
                                true));
                        search.append(" OR ");
                        search.append(StandardsListUtil.getWhereClauseForImageExactWords(searchCriteria, "a.std_id",
                                StandardsListUtil.COLUMN_TYPE_STRING_EXACT_MATCH_START, StandardsListUtil.COLUMN_TYPE_STRING_EXACT_MATCH_END,
                                true));
                        search.append(" )");
                        clauses.add(search);
                        
                    }
                    else
                    {
                        StringBuilder search  = new StringBuilder("( ");
                        search.append(StandardsListUtil.getWhereClauseForAllWords(searchCriteria, "upper(a.std_desc)",
                                StandardsListUtil.COLUMN_TYPE_STRING_MATCH_START, StandardsListUtil.COLUMN_TYPE_STRING_MATCH_END,
                                true));
                        search.append(" OR ");
                        search.append(StandardsListUtil.getWhereClauseForImageAllWords(searchCriteria, "a.std_id",
                                StandardsListUtil.COLUMN_TYPE_STRING_MATCH_START, StandardsListUtil.COLUMN_TYPE_STRING_MATCH_END,
                                true));
                        search.append(" )");
                        clauses.add(search);

                    }
                }
                else
                {
                    if ("any".equals(textSearchType))
                    {
                        StringBuilder search  = new StringBuilder("( ");
                        search.append(StandardsListUtil.getWhereClauseForExactWords(searchCriteria, "upper(a.title_txt)",
                                StandardsListUtil.COLUMN_TYPE_STRING_EXACT_MATCH_START, StandardsListUtil.COLUMN_TYPE_STRING_EXACT_MATCH_END,
                                true));
                        search.append(" OR ");
                        search.append(StandardsListUtil.getWhereClauseForImageAnyWords(searchCriteria, "a.std_id",
                                StandardsListUtil.COLUMN_TYPE_STRING_EXACT_MATCH_START, StandardsListUtil.COLUMN_TYPE_STRING_EXACT_MATCH_END,
                                true));
                        search.append(" )");
                        clauses.add(search);
                    }
                    else if ("exact".equals(textSearchType))
                    {
                        StringBuilder search  = new StringBuilder("( ");
                        search.append(StandardsListUtil.getWhereClauseForExactWords(searchCriteria, "upper(a.title_txt)",
                                StandardsListUtil.COLUMN_TYPE_STRING_EXACT_MATCH_START, StandardsListUtil.COLUMN_TYPE_STRING_EXACT_MATCH_END,
                                true));
                        search.append(" OR ");
                        search.append(StandardsListUtil.getWhereClauseForImageExactWords(searchCriteria, "a.std_id",
                                StandardsListUtil.COLUMN_TYPE_STRING_EXACT_MATCH_START, StandardsListUtil.COLUMN_TYPE_STRING_EXACT_MATCH_END,
                                true));
                        search.append(" )");
                        clauses.add(search);
                    }
                    else
                    {
                        StringBuilder search  = new StringBuilder("( ");
                        search.append(StandardsListUtil.getWhereClauseForAllWords(searchCriteria, "upper(a.title_txt)",
                                StandardsListUtil.COLUMN_TYPE_STRING_MATCH_START, StandardsListUtil.COLUMN_TYPE_STRING_MATCH_END,
                                true));
                        search.append(" OR ");
                        search.append(StandardsListUtil.getWhereClauseForImageAllWords(searchCriteria, "a.std_id",
                                StandardsListUtil.COLUMN_TYPE_STRING_MATCH_START, StandardsListUtil.COLUMN_TYPE_STRING_MATCH_END,
                                true));
                        search.append(" )");
                        clauses.add(search);
                    }
                }
            }
            if (!StandardsListUtil.isNullOrBlank(arlRationale))
            {
                // Check if rational is the only argument.
                if (stdType.equals(StandardsListUtil.STD_TYPE_GDLN))
                {
                    return arlResults;
                }
                rationaleClause = StandardsListUtil.getWhereClause(arlRationale, "upper(a.std_desc)",
                        StandardsListUtil.COLUMN_TYPE_STRING_MATCH_START, StandardsListUtil.COLUMN_TYPE_STRING_MATCH_END, true);
                clauses.add(rationaleClause);
            }
            if (!StandardsListUtil.isNullOrBlank(arlStandardsIds))
            {

                StringBuilder strIds = StandardsListUtil.getWhereClause(arlStandardsIds, "a.std_id",
                        StandardsListUtil.COLUMN_TYPE_NUMBER_START, StandardsListUtil.COLUMN_TYPE_NUMBER_END);
                clauses.add(strIds);
            }

            if (!StandardsListUtil.isNullOrBlank(arlTechWriter))
            {
                clauses.add(StandardsListUtil.getWhereClause(arlTechWriter, "a.author_nm_txt",
                        StandardsListUtil.COLUMN_TYPE_STRING_MATCH_START, StandardsListUtil.COLUMN_TYPE_STRING_MATCH_END));
            }
            if (!StandardsListUtil.isNullOrBlank(arlStdOwner))
            {
                clauses.add(StandardsListUtil.getWhereClause(arlStdOwner, "a.bus_owner_nm",
                        StandardsListUtil.COLUMN_TYPE_STRING_EXACT_START, StandardsListUtil.COLUMN_TYPE_STRING_EXACT_END));
            }
            if (!StandardsListUtil.IsNullOrBlank(brandHallmark) && "Y".equals(brandHallmark))
            {
                clauses.add(new StringBuilder("a.waiver_ind = 'Y'"));
            }
            if (!StandardsListUtil.isNullOrBlank(arlCategory))
            {
                clauses.add(StandardsListUtil.getWhereClause(arlCategory, "a.area_catgy_cd",
                        StandardsListUtil.COLUMN_TYPE_STRING_EXACT_START, StandardsListUtil.COLUMN_TYPE_STRING_EXACT_END));
            }
            if (!StandardsListUtil.isNullOrBlank(arlChangeType))
            {
                clauses.add(StandardsListUtil.getWhereClause(arlChangeType, "a.chng_desc",
                        StandardsListUtil.COLUMN_TYPE_STRING_EXACT_START, StandardsListUtil.COLUMN_TYPE_STRING_EXACT_END));
            }
            if (!StandardsListUtil.IsNullOrBlank(fromLaunchDate) || !StandardsListUtil.IsNullOrBlank(toLaunchDate))
            {
                clauses.add(StandardsListUtil.getWhereClauseDate(fromLaunchDate, toLaunchDate, "a.EFF_DT"));
            }
            if (!StandardsListUtil.IsNullOrBlank(fromCompDate) || !StandardsListUtil.IsNullOrBlank(toCompDate))
            {
                clauses.add(StandardsListUtil.getWhereClauseDate(fromCompDate, toCompDate, "a.implmnt_deadline_dt"));
            }

            if (hasGuidelines)
            {
                if (stdType.equals(StandardsListUtil.STD_TYPE_STANDARD))
                {
                    clauses.add(new StringBuilder(
                            "exists (select std2.std_id from std std2 where a.std_id = std2.prnt_std_id and std2.std_typ='GDLN')"));
                }
                else if (stdType.equals(StandardsListUtil.STD_TYPE_SPEC))
                {
                    return arlResults;
                }
            }

            if (hasCrossReference)
            {
                tables.add(new StringBuilder("std_xref xref"));
                clauses.add(new StringBuilder("a.std_id = xref.referring_std_id"));
                clauses.add(new StringBuilder(
                        "exists (select referring_std_id from std_xref where a.std_id = xref.referring_std_id)"));
            }
            if (!StandardsListUtil.isNullOrBlank(arlImpactAssmnt))
            {
                if (!stdType.equals(StandardsListUtil.STD_TYPE_STANDARD))
                {
                    return arlResults;
                }
                tables.add(new StringBuilder("bus_impact_assmt_mnl bia"));
                clauses.add(new StringBuilder("a.std_id = bia.std_id"));

                final List<String> profitLossImpact = criteria.getProfitLossImpact();
                if (!StandardsListUtil.isNullOrBlank(profitLossImpact))
                {
                    clauses.add(StandardsListUtil.getWhereClause(profitLossImpact, "bia.profit_loss_impact_cd",
                            StandardsListUtil.COLUMN_TYPE_STRING_EXACT_START, StandardsListUtil.COLUMN_TYPE_STRING_EXACT_END));
                }
                final List<String> capExImpact = criteria.getCapExImpact();
                if (!StandardsListUtil.isNullOrBlank(capExImpact))
                {
                    clauses.add(StandardsListUtil.getWhereClause(capExImpact, "bia.cap_expense_impact_cd",
                            StandardsListUtil.COLUMN_TYPE_STRING_EXACT_START, StandardsListUtil.COLUMN_TYPE_STRING_EXACT_END));
                }
                final List<String> implementationImpact = criteria.getImplementationImpact();
                if (!StandardsListUtil.isNullOrBlank(implementationImpact))
                {
                    clauses.add(StandardsListUtil.getWhereClause(implementationImpact, "bia.implmnt_timescale_cd",
                            StandardsListUtil.COLUMN_TYPE_STRING_EXACT_START, StandardsListUtil.COLUMN_TYPE_STRING_EXACT_END));
                }
                final List<String> changeFromRegionalImpact = criteria.getChangeFromRegionalImpact();
                if (!StandardsListUtil.isNullOrBlank(changeFromRegionalImpact))
                {
                    clauses.add(StandardsListUtil.getWhereClause(changeFromRegionalImpact, "bia.CHG_FROM_RGN_TO_GBL_DESC",
                            StandardsListUtil.COLUMN_TYPE_STRING_EXACT_START, StandardsListUtil.COLUMN_TYPE_STRING_EXACT_END));
                }
                if (!StandardsListUtil.isNullOrBlank(criteria.getImpactComments()))
                {
                    clauses.add(StandardsListUtil.getWhereClause(criteria.getImpactComments(), "upper(bia.CMT_TXT)",
                            StandardsListUtil.COLUMN_TYPE_STRING_MATCH_START, StandardsListUtil.COLUMN_TYPE_STRING_MATCH_END,
                            true));
                }
            }
            else if (!StandardsListUtil.isNullOrBlank(criteria.getImpactComments()))
            {
                if (!stdType.equals(StandardsListUtil.STD_TYPE_STANDARD))
                {
                    return arlResults;
                }
                tables.add(new StringBuilder("bus_impact_assmt_mnl bia"));
                clauses.add(new StringBuilder("a.std_id = bia.std_id"));

                clauses.add(StandardsListUtil.getWhereClause(criteria.getImpactComments(), "upper(bia.CMT_TXT)",
                        StandardsListUtil.COLUMN_TYPE_STRING_MATCH_START, StandardsListUtil.COLUMN_TYPE_STRING_MATCH_END, true));
            }

            if (!StandardsListUtil.isNullOrBlank(assignedImages))
            {
                tables.add(new StringBuilder("std_image simg"));
                clauses.add(new StringBuilder("a.std_id = simg.std_id"));
                clauses.add(StandardsListUtil.getWhereClause(assignedImages, "simg.image_id",
                        StandardsListUtil.COLUMN_TYPE_NUMBER_START, StandardsListUtil.COLUMN_TYPE_NUMBER_END));
            }

            // General criterias. (Not part of advance folter screen.
            if (!StandardsListUtil.IsNullOrBlank(standardId))
            {
                clauses.add(new StringBuilder("a.prnt_std_id=" + standardId));
            }
            if (!approverFlag)
            {
                clauses.add(new StringBuilder(" a.stat_desc != 'DSCNTND' "));
            }
            clauses.add(new StringBuilder(" a.stat_desc != 'DELETED' "));
            clauses.add(new StringBuilder("a.std_typ='" + stdType + "'" ));

            String sqlQuery = StandardsListUtil.buildQuery(selectQuery, tables, clauses);
            LOG.debug("SQL Query is " + sqlQuery);
            SQLQuery q = session.createSQLQuery(sqlQuery);
            q.addEntity("Standards", StandardsImpl.class);

            arlResults = (List<Standards>) q.list();
            List<Standards> arlResult = new ArrayList<Standards>(arlResults);
            List<Standards> newList = new ArrayList<Standards>();
            for (Standards element : arlResult)
            {
                if (!newList.contains(element))
                {
                    newList.add(element);
                }
            }
            arlResults = newList;
            LOG.debug("size of list after removing duplicates " + arlResults.size());
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
        return arlResults;
    }

    /**
     * Add children to specified Taxonomy/Index.
     * 
     * @param index - Index id
     * @param arlIndex - list of Indexes
     * @throws SystemException - exception
     */
    public void addChildTaxonomies(long index, List arlIndex) throws SystemException
    {
        final List<Taxonomy> arlTaxonomies = TaxonomyLocalServiceUtil.getTaxonomiesByParentId(index);
        for (Taxonomy taxonomy : arlTaxonomies)
        {
            arlIndex.add(String.valueOf(taxonomy.getTaxId()));
            LOG.debug("the values in arlIndex are " + taxonomy.getTaxId());
            addChildTaxonomies(taxonomy.getTaxId(), arlIndex);
        }
    }

    /**
     * Finder method for access it through StandardsLocalServiceUtil
     * 
     * @param standardId
     * @return
     * @throws NoSuchStandardsException
     * @throws SystemException
     */
    public List<Standards> findByStandardId(long standardId, String regionCode, String[] brands) throws SystemException
    {
        String brandName = StringPool.BLANK;
        String region = StringPool.BLANK;
        if (Validator.isNotNull(brands))
        {
            StringBuilder brandNames = new StringBuilder();
            for (String brand : brands)
            {
                if (brandNames.length() > 0)
                {
                    brandNames.append(StringPool.COMMA);
                }
                brandNames.append(StringPool.APOSTROPHE);
                brandNames.append(brand);
                brandNames.append(StringPool.APOSTROPHE);
            }
            brandName = brandNames.toString();
        }
        if (Validator.isNotNull(regionCode))
        {
            StringBuilder regionNames = new StringBuilder();
            regionNames.append(StringPool.APOSTROPHE);
            regionNames.append(regionCode);
            regionNames.append(StringPool.APOSTROPHE);
            if (!BrandStandardsUtil.REGION_GLOBAL.equals(regionCode))
            {
                regionNames.append(StringPool.COMMA);
                regionNames.append(StringPool.APOSTROPHE);
                regionNames.append(BrandStandardsUtil.REGION_GLOBAL);
                regionNames.append(StringPool.APOSTROPHE);
            }
            region = regionNames.toString();
        }

        StringBuilder sql = new StringBuilder("select s.* from std s, chain_std cs WHERE s.std_id=cs.std_id AND cs.ACTV_IND = 'Y' and cs.chain_cd in (");
        	sql.append(brandName);
        	sql.append(") and s.rgn_cd in (");
        	sql.append(region);
        	sql.append(") and s.std_id = ");
        	sql.append(standardId);
        	sql.append(" AND s.stat_desc != 'DELETED'");
        	
        List<Standards> standards = Collections.emptyList();
        Session session = null;
        try
        {
            session = openSession();
            SQLQuery q = session.createSQLQuery(sql.toString());
            q.addEntity("Standards", StandardsImpl.class);
            q.setCacheable(false);
            standards = q.list();
        }
        catch (Exception e)
        {
            LOG.debug("CMS Failed on Query: " + sql);
            throw new SystemException(e);
        }
        finally
        {
            closeSession(session);
        }
        return standards;
    }

    /**
     * 
     * @param stdId
     * @return
     * @throws SystemException
     */
    public List<Standards> getStandards(long stdId) throws SystemException
    {
        String sql = "select * from std x join std_xref y on x.std_id=y.referenced_std_id where y.referring_std_id = "
                + stdId + " AND x.stat_desc != 'DELETED' order by y.disp_order_nbr asc";
        List<Standards> standards = Collections.emptyList();
        Session session = null;
        try
        {
            session = openSession();
            SQLQuery q = session.createSQLQuery(sql);
            q.setCacheable(false);
            q.addEntity("Standards", StandardsImpl.class);
            standards = q.list();
        }
        catch (Exception e)
        {
            LOG.debug("CMS Failed on Query: " + sql);
            throw new SystemException(e);
        }
        finally
        {
            closeSession(session);
        }
        return standards;
    }

    /**
     * Find Record by Std Id.
     * @param stdId
     * @param chainCode
     * @param stdType
     * @param discontFilter
     * @return
     * @throws SystemException
     */
    public Standards getStdByStdId(long stdId, String chainCode, String discontFilter) throws SystemException
    {
        StringBuilder tables = new StringBuilder("std a ");
        StringBuilder clauses = new StringBuilder();
        clauses.append(" a.std_id = ").append(stdId).append(StringPool.SPACE);
        
        final StringBuilder selectQuery = new StringBuilder(" select a.std_id, a.prnt_std_id, a.std_typ, a.title_txt, a.std_desc, ");
        selectQuery.append("a.BUS_OWNER_NM, a.EFF_DT, a.implmnt_deadline_dt, a.waiver_ind, a.stat_desc, a.area_catgy_cd, ");
        selectQuery.append("a.gbl_rgn_ind, a.chng_desc, a.rgn_cd, a.author_nm_txt, a.note_txt, a.framework_std_ind, ");
        selectQuery.append("a.creator_scrn_nm, a.creat_usr_id, a.creat_ts, a.lst_updt_usr_id, a.lst_updt_ts, ");

        if (!BSCommonConstants.ALL_BRAND.equals(chainCode))
        {
            selectQuery.append("nvl(cs.stat_id, 0) \"STAT_ID\", ");
            tables.append(", chain_std cs "); 

            clauses.append("AND a.std_id = cs.std_id ");
            clauses.append("and cs.chain_cd = '");
            clauses.append(chainCode).append("' ");
            clauses.append("and cs.ACTV_IND = 'Y' ");
            if ("true".equals(discontFilter))
            {
                tables.append(", stat st ");
                clauses.append("and cs.stat_id = st.stat_id ");
                clauses.append("and (st.stat_cd NOT IN ('D_FOR_REF','D_NOT_RQ','D_RPLCD')) ");
            }
        }
        else 
        {
            selectQuery.append("0 \"STAT_ID\", ");
        }
        selectQuery.append("a.RGN_ID, a.DISP_ORDER_NBR , a.STD_MGR_ID ");
        clauses.append("AND a.stat_desc != 'DELETED' ");

        StringBuilder sqlQuery = new StringBuilder(selectQuery.toString());
        sqlQuery.append("from ");
        sqlQuery.append(tables.toString());
        sqlQuery.append("where ");
        sqlQuery.append(clauses.toString());
        
        Session session = null;
        Standards standards = null;
        try
        {
            session = openSession();
            SQLQuery q = session.createSQLQuery(sqlQuery.toString());
            q.setCacheable(false);
            q.addEntity("Standards", StandardsImpl.class);

            List<Standards> list = (List<Standards>) q.list();
            if (list != null && !list.isEmpty())
            {
                standards = (Standards) list.get(0);
            }
        }
        catch (Exception e)
        {
            LOG.debug("CMS Failed on Query: " + sqlQuery.toString());
            throw new SystemException(e);
        }
        finally
        {
            closeSession(session);
        }
        return standards;
    }

    /**
     * Find Record by Std Id.
     * @param stdId
     * @param chainCode
     * @param stdType
     * @param discontFilter
     * @return
     * @throws SystemException
     */
    public List<Standards> getStandardsByStdId(List<Long> stdIds, String chainCode, String discontFilter) throws SystemException
    {
        StringBuilder tables = new StringBuilder("std a ");
        StringBuilder clauses = new StringBuilder();
//        clauses.append(" a.std_id = ").append(stdId).append(StringPool.SPACE);
        
        if (stdIds.size() > 1000)
        {
            clauses.append(" ( ");
            for (int from = 0; from < stdIds.size(); from += 1000)
            {
                if (from > 0)
                {
                    clauses.append(" OR ");
                }
                int to = from + 999 > stdIds.size() - 1 ? stdIds.size() - 1 : from + 999;
                String stdIdStr = StringUtils.join(stdIds.subList(from, to), ',');
                clauses.append(" a.std_id IN (").append(stdIdStr).append(") ");
            }
            clauses.append(" ) ");
        }
        else 
        {
            clauses.append(" a.std_id IN (").append(StringUtils.join(stdIds, ',')).append(") ");
        }
        
        final StringBuilder selectQuery = new StringBuilder(" select a.std_id, a.prnt_std_id, a.std_typ, a.title_txt, a.std_desc, ");
        selectQuery.append("a.BUS_OWNER_NM, a.EFF_DT, a.implmnt_deadline_dt, a.waiver_ind, a.stat_desc, a.area_catgy_cd, ");
        selectQuery.append("a.gbl_rgn_ind, a.chng_desc, a.rgn_cd, a.author_nm_txt, a.note_txt, a.framework_std_ind, ");
        selectQuery.append("a.creator_scrn_nm, a.creat_usr_id, a.creat_ts, a.lst_updt_usr_id, a.lst_updt_ts, ");

        if (!BSCommonConstants.ALL_BRAND.equals(chainCode))
        {
            selectQuery.append("nvl(cs.stat_id, 0) \"STAT_ID\", ");
            tables.append(", chain_std cs "); 

            clauses.append("AND a.std_id = cs.std_id ");
            clauses.append("and cs.chain_cd = '");
            clauses.append(chainCode).append("' ");
            clauses.append("and cs.ACTV_IND = 'Y' ");
            if ("true".equals(discontFilter))
            {
                tables.append(", stat st ");
                clauses.append("and cs.stat_id = st.stat_id ");
                clauses.append("and (st.stat_cd NOT IN ('D_FOR_REF','D_NOT_RQ','D_RPLCD')) ");
            }
        }
        else 
        {
            selectQuery.append("0 \"STAT_ID\", ");
        }
        selectQuery.append("a.RGN_ID, a.DISP_ORDER_NBR , a.STD_MGR_ID ");
        clauses.append("AND a.stat_desc != 'DELETED' ");

        StringBuilder sqlQuery = new StringBuilder(selectQuery.toString());
        sqlQuery.append("from ");
        sqlQuery.append(tables.toString());
        sqlQuery.append("where ");
        sqlQuery.append(clauses.toString());
        
        Session session = null;
        List<Standards> standards = null;
        try
        {
            session = openSession();
            SQLQuery q = session.createSQLQuery(sqlQuery.toString());
            q.setCacheable(false);
            q.addEntity("Standards", StandardsImpl.class);

            standards = (List<Standards>) q.list();
        }
        catch (Exception e)
        {
            LOG.debug("CMS Failed on Query: " + sqlQuery.toString());
            throw new SystemException(e);
        }
        finally
        {
            closeSession(session);
        }
        return standards;
    }

    public List<Standards> getStdsByBrand(long stdId, String chainCode, String stdType, boolean fetchAll, String discontFilter)
            throws SystemException
    {
        StringBuilder tables = new StringBuilder("STD a ");
        StringBuilder clauses = new StringBuilder("a.std_typ = '").append(stdType).append("' ");
        final StringBuilder selectQuery = new StringBuilder();
        selectQuery.append("SELECT a.std_id, a.prnt_std_id, a.std_typ, a.title_txt, a.std_desc, a.BUS_OWNER_NM, a.EFF_DT, ");
        selectQuery.append("a.implmnt_deadline_dt, a.waiver_ind, a.stat_desc, a.area_catgy_cd, a.gbl_rgn_ind, a.chng_desc, a.rgn_cd, a.author_nm_txt, ");
        selectQuery.append("a.note_txt, a.framework_std_ind, a.creator_scrn_nm, a.creat_usr_id, a.creat_ts, a.lst_updt_usr_id, a.lst_updt_ts, ");
        
        if (!fetchAll && !BSCommonConstants.ALL_BRAND.equals(chainCode))
        {
            selectQuery.append("cs.stat_id AS STAT_ID, ");
            tables.append(",CHAIN_STD cs "); 

            clauses.append("and a.std_id = cs.std_id ");
            clauses.append("and cs.chain_cd = '").append(chainCode);
            clauses.append("' and cs.ACTV_IND = 'Y' ");    // TO AVOID INACTIVE BRAND.
            if ("true".equals(discontFilter))
            {
                tables.append(",stat st ");
                clauses.append("and cs.stat_id = st.stat_id ");
                clauses.append("and (st.stat_cd NOT IN ('D_FOR_REF','D_NOT_RQ','D_RPLCD')) ");
            }
        }
        else
        {
            selectQuery.append("nvl((select chn.stat_id from chain_std chn where chn.std_id = a.std_id and chn.ACTV_IND = 'Y' AND  chn.chain_cd = '");
            selectQuery.append(chainCode).append("'), 0) AS STAT_ID, ");
        }
        selectQuery.append("a.RGN_ID, a.DISP_ORDER_NBR , a.STD_MGR_ID ");
        
        String orderBy;
        if(StandardsListUtil.STD_TYPE_STANDARD.equals(stdType))
        {
            orderBy =  " order by a.creat_ts desc " ;
        }
        else
        {
//            orderBy = " order by a.disp_order_nbr, a.std_id " ;
            orderBy = " order by a.std_id " ;
            clauses.append("and a.prnt_std_id = ").append(stdId).append(StringPool.SPACE);
        }
        clauses.append("AND a.stat_desc != 'DELETED' ");

        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append(selectQuery);
        sqlQuery.append("from ");
        sqlQuery.append(tables);
        sqlQuery.append("where ");
        sqlQuery.append(clauses);
        sqlQuery.append(orderBy);
        
        List<Standards> standards = Collections.emptyList();
        Session session = null;
        try
        {
            session = openSession();
            SQLQuery q = session.createSQLQuery(sqlQuery.toString());
            q.setCacheable(false);
            q.addEntity("Standards", StandardsImpl.class);

            standards = (List<Standards>) q.list();
        }
        catch (Exception e)
        {
            LOG.debug("CMS Failed on Standards Search Query: " + sqlQuery.toString());
            throw new SystemException(e);
        }
        finally
        {
            closeSession(session);
        }
        return standards;
    }
    
    public List<PublishExtStd> getPublishedStandards(long stdId, String stdType, String brandCd, String filterOn,
            String isNonMatch, String fromDate, String toDate) throws SystemException
    {
        List<PublishExtStd> standards = Collections.emptyList();
        Session session = null;
        StringBuilder query = new StringBuilder();

        try
        {
            query.append("SELECT null as cmply_dt, ps.std_id, ps.prnt_std_id, ps.title_txt, sc.expired_by_ref_txt, ");
            query.append("ps.rgn_cd, ps.gbl_rgn_ind, ps.framework_std_ind ");
            query.append("FROM publish_std ps, std_ctry_chain sc, std s, ");
            query.append("(SELECT p.publish_id AS publish_id, p.chain_cd AS chain_cd FROM publish p WHERE p.chain_cd = '");
            query.append(brandCd);
            query.append("' AND p.publish_environment_nm = 'PRODUCTION' AND p.publish_stat_cd = 'ACTIVE') pub ");
            query.append("WHERE ps.std_typ = '");
            query.append(stdType);
            query.append("' AND pub.publish_id = ps.publish_id AND sc.std_id = ps.std_id AND s.std_id = ps.std_id AND pub.chain_cd = sc.chain_cd AND s.stat_desc != 'DELETED' ");
            if (BrandStandardsUtil.STD_TYPE_SPEC.equals(stdType))
            {
                query.append("AND ps.prnt_std_id = " + stdId + " ");
            }

            if (Validator.isNotNull(filterOn) && !"true".equals(isNonMatch))
            {
                DateFormat df = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
                Date fDate = df.parse(fromDate);
                Date tDate = df.parse(toDate);
                DateFormat df1 = new SimpleDateFormat("dd-MMM-yy HH:mm:ss");
                fromDate = df1.format(fDate);
                toDate = df1.format(tDate);
                query.append("AND sc.cmply_dt between to_date('");
                query.append(fromDate);
                query.append("','DD-Mon-RR HH24:MI:ss') AND to_date('");
                query.append(toDate);
                query.append("','DD-Mon-RR HH24:MI:ss') ");
            }
            query.append("group by  ps.prnt_std_id, ps.std_id, ps.title_txt, sc.expired_by_ref_txt, ps.rgn_cd, ps.gbl_rgn_ind, ps.framework_std_ind");
            //System.out.println("Compliance Finder Query   :  "+ query);
            session = openSession();
            SQLQuery q = session.createSQLQuery(query.toString());
            q.setCacheable(false);
            q.addEntity("PublishExtStd", PublishExtStdImpl.class);

            standards = (List<PublishExtStd>) q.list();
        }
        catch (ParseException e1)
        {
            LOG.error("Error while converting dates in desired format" + e1.getMessage());
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
        return standards;
    }
    
    public List<PublishExtStd> getPublishedStandards(String brandCd, String filterOn,
            String isNonMatch, String fromDate, String toDate, String filterIds) throws SystemException
    {
        List<PublishExtStd> standards = Collections.emptyList();
        Session session = null;
        StringBuilder query = new StringBuilder();

        try
        {
            query.append("SELECT null as cmply_dt, ps.std_id, ps.prnt_std_id, ps.title_txt, sc.expired_by_ref_txt, ");
            query.append("ps.rgn_cd, ps.gbl_rgn_ind, ps.framework_std_ind ");
            query.append("FROM publish_std ps, std_ctry_chain sc, std s, ");
            query.append("(SELECT p.publish_id AS publish_id, p.chain_cd AS chain_cd FROM publish p WHERE p.chain_cd = '");
            query.append(brandCd);
            query.append("' AND p.publish_environment_nm = 'PRODUCTION' AND p.publish_stat_cd = 'ACTIVE') pub ");
            query.append("WHERE pub.publish_id = ps.publish_id AND sc.std_id = ps.std_id AND s.std_id = ps.std_id AND pub.chain_cd = sc.chain_cd AND s.stat_desc != 'DELETED' ");
            
            if(filterIds!=null && !"".equals(filterIds.trim()))
            {
            	filterIds = filterIds.replace(" ", ", ");
            	query.append(" AND ps.std_id in (select prnt_std_id from std s, CHAIN_STD cs where s.std_id in("+ filterIds +") and s.std_id=cs.std_id and cs.CHAIN_CD='"+brandCd+"') ");
            }
            if (Validator.isNotNull(filterOn) && !"true".equals(isNonMatch))
            {
                DateFormat df = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
                Date fDate = df.parse(fromDate);
                Date tDate = df.parse(toDate);
                DateFormat df1 = new SimpleDateFormat("dd-MMM-yy HH:mm:ss");
                fromDate = df1.format(fDate);
                toDate = df1.format(tDate);
                query.append("AND sc.cmply_dt between to_date('");
                query.append(fromDate);
                query.append("','DD-Mon-RR HH24:MI:ss') AND to_date('");
                query.append(toDate);
                query.append("','DD-Mon-RR HH24:MI:ss') ");
            }
            query.append("group by ps.prnt_std_id, ps.std_id, ps.title_txt, sc.expired_by_ref_txt, ps.rgn_cd, ps.gbl_rgn_ind, ps.framework_std_ind");
            LOG.debug("Compliance Finder Query   :  "+ query);
            session = openSession();
            SQLQuery q = session.createSQLQuery(query.toString());
            q.setCacheable(false);
            q.addEntity("PublishExtStd", PublishExtStdImpl.class);

            standards = (List<PublishExtStd>) q.list();
        }
        catch (ParseException e1)
        {
            LOG.error("Error while converting dates in desired format" + e1.getMessage());
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
        return standards;
    }

    public List<PublishExtStd> getPublishedSpecs(String stdType, String brandCd, String fromDate, String toDate)
            throws SystemException
    {
        List<PublishExtStd> specs = Collections.emptyList();
        Session session = null;
        StringBuilder query = new StringBuilder();
        StringBuilder specQuery = new StringBuilder();
        try
        {
            DateFormat df = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
            Date fDate = df.parse(fromDate);
            Date tDate = df.parse(toDate);
            DateFormat df1 = new SimpleDateFormat("dd-MMM-yy HH:mm:ss");
            fromDate = df1.format(fDate);
            toDate = df1.format(tDate);
            specQuery.append("(select sc.cmply_dt, ps.prnt_std_id as prnt_id, ps.publish_id from publish_std ps, std_ctry_chain sc, (select p.publish_id as publish_id, p.chain_cd as chain_cd from publish p where p.chain_cd = '");
            specQuery.append(brandCd);
            specQuery.append("' and p.publish_stat_cd = 'ACTIVE' and p.publish_environment_nm = 'PRODUCTION') pub where ps.std_typ='");
            specQuery.append(stdType);
            specQuery.append("' and pub.publish_id = ps.publish_id and sc.std_id = ps.std_id and pub.chain_cd = sc.chain_cd and sc.cmply_dt between to_date('");
            specQuery.append(fromDate);
            specQuery.append("','DD-Mon-RR HH24:MI:ss') and to_date('");
            specQuery.append(toDate);
            specQuery.append("','DD-Mon-RR HH24:MI:ss') group by sc.cmply_dt, ps.prnt_std_id, ps.publish_id) xyz ");
            query.append("select to_date(to_char(sc.cmply_dt, 'DD-MON-RR'), 'DD-MON-RR') as cmply_dt, ps.std_id, ps.prnt_std_id, ps.title_txt, sc.expired_by_ref_txt, ps.rgn_cd, ps.gbl_rgn_ind, ps.framework_std_ind ");
            query.append("from publish_std ps, std_ctry_chain sc, std s, ");
            query.append(specQuery);
            query.append("where xyz.prnt_id = ps.publish_std_ver_id and sc.std_id = ps.std_id and xyz.publish_id = ps.publish_id and s.stat_desc != 'DELETED' and s.std_id = ps.std_id and sc.chain_cd = '");
            query.append(brandCd).append("' ");
            query.append("group by to_date(to_char(sc.cmply_dt, 'DD-MON-RR'), 'DD-MON-RR'), ps.std_id, ps.prnt_std_id, ps.title_txt, sc.expired_by_ref_txt, ps.rgn_cd, ps.gbl_rgn_ind, ps.framework_std_ind");

            session = openSession();
            SQLQuery q = session.createSQLQuery(query.toString());
            q.setCacheable(false);
            q.addEntity("PublishExtStd", PublishExtStdImpl.class);

            specs = (List<PublishExtStd>) q.list();
        }
        catch (ParseException e1)
        {
            LOG.error("Error while converting dates in desired format" + e1.getMessage());
        }
        catch (Exception e)
        {
            throw new SystemException(e);
        }
        finally
        {
            closeSession(session);
        }
        return specs;
    }
    
    public void unLockRecords(String stdIds, String chainCode) throws SystemException
    {
    	StringBuilder unLockQuery  = new StringBuilder("DECLARE l_std_ids CLOB := ?; BEGIN ");
    	unLockQuery.append(" UPDATE STD SET STAT_DESC='");
    	unLockQuery.append(BSCommonConstants.AVAILABLE_STATUS);
    	unLockQuery.append("' WHERE STD_ID IN (SELECT s.STD_ID FROM STD s, CHAIN_STD cs WHERE");
    	unLockQuery.append(" s.STD_ID=cs.STD_ID AND s.STAT_DESC='");
    	unLockQuery.append(BSCommonConstants.PUBLISH_LOCK_STATUS);
    	unLockQuery.append("' AND cs.CHAIN_CD='");
    	unLockQuery.append(chainCode);
    	unLockQuery.append("' AND s.STD_ID IN (SELECT COLUMN_VALUE AS STD_ID FROM TABLE(brandstandardspublish.delimclob_to_num_table(l_std_ids)))); COMMIT;");
    	unLockQuery.append(" END;");

        if(LOG.isDebugEnabled()){
        	LOG.debug("Unlock records query: " + unLockQuery.toString());
        }
        
        Connection conn = null;
        CallableStatement colstmt = null;
        try {
        	conn = getDataSource().getConnection();
            colstmt = conn.prepareCall(unLockQuery.toString());
            Reader reader = new StringReader(stdIds);
            colstmt.setCharacterStream(1, reader, stdIds.length());
            colstmt.executeQuery();
        } catch(Exception e) {
        	LOG.debug("Unlock records query: " + unLockQuery.toString());
            LOG.error("Failed to unlock records", e);
            throw new SystemException("Failed to unlock records", e);
        }
        finally
        {
            closeConnection(conn, colstmt);
        }
    }
    
    public void lockRecords(String stdIds, String chainCode) throws SystemException
    {
        StringBuilder lockQuery  = new StringBuilder("DECLARE l_std_ids CLOB := ?; BEGIN ");
        lockQuery.append(" UPDATE STD SET STAT_DESC='");
        lockQuery.append(BSCommonConstants.PUBLISH_LOCK_STATUS);
    	lockQuery.append("' WHERE STD_ID IN (SELECT s.STD_ID FROM STD s, CHAIN_STD cs WHERE");
    	lockQuery.append(" s.STD_ID=cs.STD_ID AND s.STAT_DESC!='DELETED' AND cs.CHAIN_CD='");
    	lockQuery.append(chainCode);
    	lockQuery.append("' AND s.STD_ID IN (SELECT COLUMN_VALUE AS STD_ID FROM TABLE(brandstandardspublish.delimclob_to_num_table(l_std_ids)))); COMMIT;");
    	lockQuery.append(" END;");
    	
        if(LOG.isDebugEnabled()){
        	LOG.debug("Lock records query: " + lockQuery.toString());
        }
        
        Connection conn = null;
        CallableStatement colstmt = null;
        try {
            conn = getDataSource().getConnection();
            colstmt = conn.prepareCall(lockQuery.toString());
            Reader reader = new StringReader(stdIds);
            colstmt.setCharacterStream(1, reader, stdIds.length());
            colstmt.executeQuery();
        } catch(Exception e) {
        	LOG.debug("Lock records query: " + lockQuery.toString());
            LOG.error("Failed to unlock records", e);
            throw new SystemException("Failed to unlock records", e);
        }
        finally
        {
            closeConnection(conn, colstmt);
        }
    }
    
    public void setStandardsStatusUnlock(String chainCode) throws SystemException
    {
        StringBuilder releaseAllLocksQuery  = new StringBuilder("UPDATE STD SET STAT_DESC='");
    	releaseAllLocksQuery.append(BSCommonConstants.AVAILABLE_STATUS);
    	releaseAllLocksQuery.append("' WHERE STD_ID IN (SELECT s.STD_ID FROM STD s, CHAIN_STD cs WHERE");
    	releaseAllLocksQuery.append(" s.STD_ID=cs.STD_ID AND s.STAT_DESC='");
    	releaseAllLocksQuery.append(BSCommonConstants.PUBLISH_LOCK_STATUS);
    	releaseAllLocksQuery.append("' AND cs.CHAIN_CD='");
    	releaseAllLocksQuery.append(chainCode);
    	releaseAllLocksQuery.append("')");
    	
        if(LOG.isDebugEnabled()){
        	LOG.debug("Unlock records query: " + releaseAllLocksQuery.toString());
        }
        Session session = null;
        try {
        	session = openSession();
            SQLQuery q = session.createSQLQuery(releaseAllLocksQuery.toString());
            q.executeUpdate();
        } catch(Exception e) {
        	LOG.debug("Unlock records query: " + releaseAllLocksQuery.toString());
            LOG.error("Failed to set unlocked status", e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
    }
    
    public long getLockedStandardsCount(String chainCode)
    {
        long standardsCount = 0;
        StringBuilder lockedCountQuery  = new StringBuilder("SELECT COUNT(s.STD_ID) FROM STD s, CHAIN_STD cs WHERE s.STD_ID=cs.STD_ID AND s.STAT_DESC='");
        lockedCountQuery.append(BSCommonConstants.PUBLISH_LOCK_STATUS);
        lockedCountQuery.append("' AND cs.CHAIN_CD='");
        lockedCountQuery.append(chainCode);
        lockedCountQuery.append("'");
        Session session = null;
        try
        {
            session = openSession();
             SQLQuery q = session.createSQLQuery(lockedCountQuery.toString());
             List arlUnlockedRecords = q.list();
             if(arlUnlockedRecords != null && arlUnlockedRecords.size() > 0){
            	 BigDecimal stdCount = (BigDecimal) arlUnlockedRecords.get(0);
            	 standardsCount = stdCount.longValue();
             }
        }
        catch(Exception e)
        {
        	LOG.debug("locked standards count query: " + lockedCountQuery.toString());
            LOG.error("Failed to get locked standards count", e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return standardsCount;
    }
    
    /**
     * 
     * @param stdId
     * @param regionId
     * @param chainCode
     * @return List<Standards>
     */
    public List<Standards> getStandardsByChainAndRegion (long stdId, long regionId, String regionCode, String chainCode, String stdType) {
    	
    	long anotherRegionId = 0l;
    	
    	Session session = null;
    	List<Standards> standards = new ArrayList<Standards>();
    	StringBuilder query = new StringBuilder();
    	query.append("WITH STD_DETAILS AS (SELECT STD_ID, PRNT_STD_ID, STD_TYP, TITLE_TXT, BUS_OWNER_NM, EFF_DT, IMPLMNT_DEADLINE_DT, ");
    	query.append("WAIVER_IND, STAT_DESC, AREA_CATGY_CD, GBL_RGN_IND, CHNG_DESC, RGN_CD, AUTHOR_NM_TXT, FRAMEWORK_STD_IND, ");
    	query.append("CREATOR_SCRN_NM, CREAT_USR_ID, CREAT_TS, LST_UPDT_USR_ID, LST_UPDT_TS,STD_DESC, NOTE_TXT, STD_MGR_ID, STAT_ID, ");
    	query.append("RGN_ID from std where prnt_std_id = ");
    	query.append(stdId);
    	query.append(" AND STAT_DESC != 'DELETED' ");
        if (Validator.isNotNull(stdType)) {
        	query.append(" AND STD_TYP = '");
        	query.append(stdType);
        	query.append("' ) , ");
        } else {
        	query.append(" ) , ");
        }
        query.append(" STAT_DETAILS AS (SELECT stat_id from stat where rgn_id in (1, ");
        query.append(regionId);
        query.append(" ) and stat_cd in ('D_FOR_REF', 'D_NOT_RQ', 'D_RPLCD')),");
        if (!"GLBL".equals(regionCode)) {
        	query.append("CTRY AS (select unique b.rgn_id, a.std_id from ctry_std a, brndstnd_ctry b where a.std_id in (select std_id from STD_DETAILS) ");
        	query.append("and a.ctry_nm_cd = b.ctry_nm_cd and b.rgn_id = ");
        	query.append(regionId);
			query.append("), ");
        }
		query.append(" CHAIN AS (select std_id from chain_std where actv_ind = 'Y' AND  chain_cd = '");
		query.append(chainCode);
		query.append("'");
		query.append(" and std_id in (select std_id from STD_DETAILS) AND stat_id not in (select stat_id from STAT_DETAILS)),");
        	query.append("ORDER_NUM AS (SELECT COALESCE(disp_order_nbr,0) AS disp_order_nbr, std_id FROM std_display_order WHERE std_id IN ");
        query.append("(SELECT std_id FROM std_details) and rgn_cd = '");
        query.append(regionCode);
        query.append("' and chain_cd = '");
        query.append(chainCode);
        query.append("') ");
        if (!"GLBL".equals(regionCode)) {
        	query.append(" SELECT sd.*, orderNum.disp_order_nbr FROM std_details sd, order_num orderNum, CTRY ctr, CHAIN chn  where ");
        	query.append(" sd.std_id = chn.std_id AND sd.std_id = ctr.std_id AND sd.std_id = orderNum.std_id(+)");
        } else {
        	query.append(" SELECT sd.*, orderNum.disp_order_nbr FROM std_details sd, order_num orderNum, CHAIN chn  where ");
        	query.append(" sd.std_id = chn.std_id AND sd.std_id = orderNum.std_id(+)");
        }
        try {
        	session = openSession();
        	SQLQuery q = session.createSQLQuery(query.toString());
        	q.addEntity("Standards", StandardsImpl.class);
        	standards = q.list();
        } catch (Exception e) {
        	LOG.error(e.getMessage(), e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
       return standards;
    }

    public long getTableSequenceEntryCount(String query)
    {
        long standardsCount = 0;
        Session session = null;
        try
        {
            session = openSession();
             SQLQuery q = session.createSQLQuery(query);
             List result = q.list();
             if(result != null && result.size() > 0){
            	 BigDecimal stdCount = (BigDecimal) result.get(0);
            	 standardsCount = stdCount.longValue();
             }
        }
        catch(Exception e)
        {
        	LOG.debug("Table Sequence Entry Count query: " + query);
            LOG.error("Failed to get TableSequenceEntryCount", e);
        }
         finally
         {
             if (session != null)
             {
                 closeSession(session);
             }
         }
        return standardsCount;
    }

    private void closeConnection(Connection conn, CallableStatement colstmt)
    {
        if (colstmt != null)
        {
            try
            {
                colstmt.close();
            }
            catch (SQLException e)
            {
                LOG.error(StackTraceUtil.getStackTrace(e));
            }
        }
        if (conn != null)
        {
            try
            {
                conn.close();
            }
            catch (SQLException e)
            {
                LOG.error(StackTraceUtil.getStackTrace(e));
            }
        }
    }
}
