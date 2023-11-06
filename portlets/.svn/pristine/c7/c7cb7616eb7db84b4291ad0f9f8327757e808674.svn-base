/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.me2.brandstandards.custom.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import com.ihg.me2.brandstandards.custom.pojo.StandardsSearchCriteria;
import com.ihg.me2.brandstandards.custom.util.StandardsListUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * <a href="QueryUtils.java.html"><b><i>View Source</i></b></a>.
 * 
 * @project: Brand Standards.
 * @author chintan.akhani
 */
public class QueryUtils
{
    public static final String SEARCH_OPTION_EXACT = "exact";
    public static final String SEARCH_OPTION_ANY = "any";
    public static final String SPACE_AND_SPACE = " AND ";
    public static final String COLUMN_TYPE_NUMBER_START = " = ";
    public static final String COLUMN_TYPE_NUMBER_END = "";

    public static final String COLUMN_TYPE_STRING_MATCH_START = " like '%";
    public static final String COLUMN_TYPE_STRING_MATCH_END = "%'";

    public static final String COLUMN_TYPE_STRING_EXACT_START = " like '";
    public static final String COLUMN_TYPE_STRING_EXACT_END = "'";
    public static final String DEFAULT_LOCALE = "en_GB";
    public static final String COLUMN_TYPE_STRING_EXACT_MATCH_START = "'(^|\\s)";
    public static final String COLUMN_TYPE_STRING_EXACT_MATCH_END = "(\\s|,|\\.|$)'";


    public static final Log LOG = LogFactoryUtil.getLog(QueryUtils.class);

    /**
     * @param publishId publication id
     * @param stdId This is a long object
     * @param locale This is a String object
     * @param countryCode This is a String object
     * @return String
     */
    public static String getSupportingMaterial(long publishId, long stdId, String locale, String countryCode)
    {
        StringBuilder query = new StringBuilder();
        if (Validator.isNotNull(stdId))
        {
            
        	query = new StringBuilder();
            //Published Standards
        	query.append(" WITH PUB_STD AS (select ps.std_id, ps.prnt_std_id, ps.PUBLISH_STD_VER_ID, ps.stat_desc, ");
        	query.append(" ps.disp_order_nbr, ps.title_txt, ps.std_typ, ps.std_desc , CASE ");
        	query.append(" WHEN CTRY.std_cmply_deadline_dt > SYSDATE THEN CTRY.std_cmply_deadline_dt ELSE NULL ");
        	query.append(" END AS cmply_dt ");
        	query.append(" from publish_std ps, PUBLISH_CTRY_STD CTRY ");
        	query.append(" where publish_id = ");
        	query.append(publishId);
        	query.append(" and ps.PUBLISH_STD_VER_ID = ctry.PUBLISH_STD_VER_ID and ctry.ctry_nm_cd = '");
        	query.append(countryCode);
        	query.append("' ), ");
        	//Attachments
            query.append("ATTACHMENTS AS (SELECT null as prnt_std_id,  std.STD_ID AS ATTCHSTDID, attch.publish_std_attachment_id AS STDATTCHID,");
            query.append(" attch.attachment_typ AS ATTTYPE, attch.attachment_title_txt AS ATTTITLE, ");
            query.append("attch.attachment_path_txt AS ATTPATH, attch.prnt_publish_std_attachment_id AS ATTPRNTID");
            query.append(" ,attch.CHG_STAT_CD AS ATTSTATCD,attch.LOCALE_CD AS ATTLOCALECD, null AS EXTSTDID,null AS EXTLINKID,");
            query.append("null AS EXTTITLE,null AS EXTURL,null AS EXTPRNTID,null AS EXTSTATCD,null AS EXTLOCALECD ");
            query.append("FROM publish_std_attachment attch, PUB_STD std ");
            query.append("WHERE attch.PUBLISH_STD_VER_ID = std.PUBLISH_STD_VER_ID ");
            query.append(" AND attch.PUBLISH_STD_VER_ID = ").append(stdId).append(" ");
            query.append("AND attch.ctry_nm_cd =  '");
            query.append(countryCode);
            query.append("' AND (attch.prnt_publish_std_attachment_id = attch.publish_std_attachment_id ");
            query.append(" OR attch.locale_cd IN ('").append(locale).append("','").append(DEFAULT_LOCALE).append("'))),");
            
            query.append("LINKS AS (SELECT null as prnt_std_id, null AS ATTCHSTDID, null AS STDATTCHID, null AS ATTTYPE, null AS ATTTITLE, null AS ATTPATH, ");
            query.append("null AS ATTPRNTID,null AS ATTSTATCD, null AS ATTLOCALECD, ");
            query.append("std.STD_ID, links.PUBLISH_STD_EXTL_LINK_ID, links.link_title_txt, links.url_txt, ");
            query.append("links.prnt_publish_std_extl_link_id, links.chg_stat_cd, links.locale_cd ");
            query.append("FROM PUBLISH_STD_EXTL_LINK links, PUB_STD std ");
            query.append("WHERE links.publish_std_ver_id = std.publish_std_ver_id ");
            query.append("AND links.publish_std_ver_id = ").append(stdId).append(" ");
            query.append("AND links.ctry_nm_cd = '").append(countryCode).append("' ");
            query.append(" AND (links.publish_std_extl_link_id = links.prnt_publish_std_extl_link_id ");
            query.append(" OR links.locale_cd IN ('").append(locale).append("','").append(DEFAULT_LOCALE).append("'))) ");
            query.append("(SELECT * FROM attachments UNION SELECT * FROM links)");
        }
        if (LOG.isDebugEnabled())
        {
            LOG.debug("ids :::" + stdId + " \n query for publish std ::" + query.toString());
        }
        
        return query.toString();
    }

    /**
     * @param stdId This is a long object
     * @param locale This is a String object
     * @param countryCode This is a String object
     * @return String
     */
    public static String getRelatedImages(long stdId, String locale, String countryCode)
    {
        StringBuilder query = new StringBuilder();
        if (Validator.isNotNull(stdId))
        {
            query.append("SELECT si.publish_std_image_id, si.image_identifier, si.image_title_txt, si.prnt_publish_std_image_id, ");
            query.append("si.chg_stat_cd, s.std_id, si.locale_cd ");
            query.append("FROM publish_std s, publish_std_image si, publish_ctry_std pcs ");
            query.append("WHERE s.publish_std_ver_id = si.publish_std_ver_id ");
            query.append("AND s.publish_std_ver_id = ").append(stdId).append(" ");
            query.append("AND pcs.publish_std_ver_id = s.publish_std_ver_id ");
            query.append("AND pcs.ctry_nm_cd = '").append(countryCode).append("' ");
            query.append("AND si.ctry_nm_cd = '").append(countryCode).append("' ");
            query.append("AND (si.publish_std_image_id = si.prnt_publish_std_image_id OR ");
            query.append("si.locale_cd IN ('").append(locale).append("','").append(DEFAULT_LOCALE).append("')) ");

            if (LOG.isDebugEnabled())
            {
                LOG.debug("query for related images ::" + query.toString());
            }
        }
        return query.toString();
    }

    /**
     * @param structureId This is a String object
     * @param categoryId This is a long object
     * @param brandCode This is a long object
     * @return String This method is used for home page and help page web content
     */
    public static String getArticle(String structureId, long categoryId, long brandCode)
    {
        StringBuilder query = new StringBuilder();
        if (brandCode == 0l)
        {
            query.append("WITH ARTICLE AS (SELECT A.RESOURCEPRIMKEY FROM JOURNALARTICLE A  WHERE A.STRUCTUREID ='");
            query.append(structureId);
            query.append("') (SELECT C.CLASSPK FROM ASSETENTRY C JOIN ASSETENTRIES_ASSETCATEGORIES D ");
            query.append("ON (C.ENTRYID = D.ENTRYID) WHERE D.CATEGORYID = ");
            query.append(categoryId);
            query.append(" AND C.CLASSPK IN (SELECT RESOURCEPRIMKEY FROM ARTICLE))");
        }
        else
        {
            query.append("WITH ARTICLE AS (SELECT A.RESOURCEPRIMKEY FROM JOURNALARTICLE A  WHERE A.STRUCTUREID ='");
            query.append(structureId);
            query.append("') (SELECT C.CLASSPK FROM ASSETENTRY C JOIN ASSETENTRIES_ASSETCATEGORIES D ");
            query.append("ON (C.ENTRYID = D.ENTRYID) JOIN ASSETENTRIES_ASSETCATEGORIES E ");
            query.append("ON (C.ENTRYID = E.ENTRYID) WHERE D.CATEGORYID = ");
            query.append(categoryId);
            query.append(" AND E.CATEGORYID = ");
            query.append(brandCode);
            query.append(" AND C.CLASSPK IN (SELECT RESOURCEPRIMKEY FROM ARTICLE))");
        }
        if (LOG.isDebugEnabled())
        {
            LOG.debug(query.toString());
        }
        return query.toString();
    }

    /**
     * Get where clause lower case.
     * 
     * @param values - list of values
     * @param columnName - column name
     * @param expressionStart - expression start
     * @param expressionEnd - expression end
     * @return - where clause.
     */
    public static StringBuilder getWhereClause(final List<String> values, final String columnName, final String expressionStart,
            final String expressionEnd)
    {
        return getWhereClause(values, columnName, expressionStart, expressionEnd, false);
    }

    /**
     * Get where clause.
     * 
     * @param values - list of values
     * @param columnName - column name
     * @param expressionStart - expression start
     * @param expressionEnd - expression end
     * @param upperCase - is upper case
     * @return - where clause.
     */
    public static StringBuilder getWhereClause(final List<String> values, final String columnName, final String expressionStart,
            final String expressionEnd, final boolean upperCase)
    {
        final StringBuilder clause = new StringBuilder("( ");
        for (int i = 0; i < values.size(); i++)
        {
            if (i != 0)
            {
                clause.append(" or ");
            }
            clause.append(getWhereClause(values.get(i), columnName, expressionStart, expressionEnd, upperCase));
        }
        clause.append(" )");
        return clause;
    }

    /**
     * Add exact word to the clause.
     * @param values list of values
     * @param columnName column
     * @param expressionStart start expression
     * @param expressionEnd end expression
     * @param upperCase flag
     * @return 
     */
    public static StringBuilder getWhereClauseForExactWords(final List<String> values, final String columnName,
            final String expressionStart, final String expressionEnd, final boolean upperCase)
    {
        final StringBuilder clause = new StringBuilder("( ");
        for (int i = 0; i < values.size(); i++)
        {
            if (i != 0)
            {
                clause.append(" OR ");
            }
            clause.append(getWhereExactClause(values.get(i), columnName, expressionStart, expressionEnd, upperCase));
        }
        clause.append(" )");
        return clause;
    }

    /**
     * Get where exact clause.
     * 
     * @param value - value
     * @param columnName - column name
     * @param expressionStart - expression start
     * @param expressionEnd - expression end
     * @param upperCase - is upper case
     * @return - condition for where clause.
     */
    public static StringBuilder getWhereExactClause(final String value, final String columnName, final String expressionStart,
            final String expressionEnd, final boolean upperCase)
    {
        final StringBuilder clause = new StringBuilder();
        String newVal = escapeStringSql(value);
        if (upperCase)
        {
            newVal = newVal.toUpperCase();
        }
        clause.append("regexp_instr(");
        clause.append(columnName).append(",");
        clause.append(expressionStart).append(newVal).append(expressionEnd).append(") > 0");
        return clause;
    }

    /**
     * @param values This is a List<String> object
     * @param columnName This is a String object
     * @param expressionStart This is a String object
     * @param expressionEnd This is a String object
     * @param upperCase This is a boolean object
     * @return StringBuilder
     */
    public static StringBuilder getWhereClauseForAllWords(final List<String> values, final String columnName,
            final String expressionStart, final String expressionEnd, final boolean upperCase)
    {
        final StringBuilder clause = new StringBuilder("( ");
        for (int i = 0; i < values.size(); i++)
        {
            if (i != 0)
            {
                clause.append(SPACE_AND_SPACE);
            }
            clause.append(getWhereClause(values.get(i), columnName, expressionStart, expressionEnd, upperCase));
        }
        clause.append(" )");
        return clause;
    }

    /**
     * Get where clause lower case.
     * 
     * @param value - value
     * @param columnName - column name
     * @param expressionStart - expression start
     * @param expressionEnd - expression end
     * @return - condition for where clause.
     */
    public static StringBuilder getWhereClause(final String value, final String columnName, final String expressionStart,
            final String expressionEnd)
    {
        return getWhereClause(value, columnName, expressionStart, expressionEnd, false);
    }

    /**
     * Get where clause.
     * 
     * @param value - value
     * @param columnName - column name
     * @param expressionStart - expression start
     * @param expressionEnd - expression end
     * @param upperCase - is upper case
     * @return - condition for where clause.
     */
    public static StringBuilder getWhereClause(final String value, final String columnName, final String expressionStart,
            final String expressionEnd, final boolean upperCase)
    {
        final StringBuilder clause = new StringBuilder();
        String newVal = escapeStringSql(value);
        if (upperCase)
        {
            newVal = newVal.toUpperCase();
        }
        clause.append(columnName).append(expressionStart).append(newVal).append(expressionEnd);
        return clause;
    }

    /**
     * Escape QSL reserved characters.
     * 
     * @param string source
     * @return escaped string
     */
    public static String escapeStringSql(String string)
    {
        String escStr = StringUtils.replace(string, "'", "''");
        escStr = StringUtils.replace(escStr, "&", "' || chr(38) || '");
        return escStr;
    }

    /**
     * @param selectQuery1 This is a StringBuilder object
     * @param selectQuery2 This is a StringBuilder object
     * @param selectQuery3 This is a StringBuilder object
     * @param tables This is a List<StringBuilder> object
     * @param clauses This is a List<StringBuilder> object
     * @param clauses1 This is a List<StringBuilder> object
     * @param clauses2 This is a List<StringBuilder> object
     * @return String
     */
    public static String buildQuery(StringBuilder selectQuery1, StringBuilder selectQuery2, StringBuilder selectQuery3,
            List<StringBuilder> tables, List<StringBuilder> clauses, List<StringBuilder> clauses1, List<StringBuilder> clauses2)
    {
        StringBuilder sqlQuery = selectQuery1;
        if (!clauses.isEmpty())
        {
            boolean appendAnd = false;
            sqlQuery.append(SPACE_AND_SPACE);
            for (StringBuilder clause : clauses)
            {
                if (appendAnd)
                {
                    sqlQuery.append(SPACE_AND_SPACE);
                }
                appendAnd = true;
                sqlQuery.append(" ").append(clause);
            }
        }
        sqlQuery.append(selectQuery2);
        if (!clauses1.isEmpty())
        {
            sqlQuery.append(SPACE_AND_SPACE);
            boolean appendAnd = false;
            for (StringBuilder clause : clauses1)
            {
                if (appendAnd)
                {
                    sqlQuery.append(SPACE_AND_SPACE);
                }
                appendAnd = true;
                sqlQuery.append(" ").append(clause);
            }
        }
        if (selectQuery3 != null && selectQuery3.length() > 0)
        {
            sqlQuery.append(")");
        }
        sqlQuery.append(selectQuery3);
        if (!clauses2.isEmpty())
        {
            sqlQuery.append(SPACE_AND_SPACE);
            for (StringBuilder clause : clauses2)
            {

                sqlQuery.append(" ").append(clause);
            }
            sqlQuery.append(" ) ");
        }

        if (selectQuery3 != null && selectQuery3.length() > 0)
        {
            sqlQuery.append(") )");
        }
        return sqlQuery.toString();
    }
    
    public static StringBuilder getWhereClauseForImageAnyWords(final List<String> values, final String expressionStart, final String expressionEnd)
    {
        final StringBuilder clause = new StringBuilder(" ( ");
        for (int i = 0; i < values.size(); i++)
        {
            if (i != 0)
            {
                clause.append(" OR ");
            }
            clause.append(getWhereExactClause(values.get(i), "upper(im.image_title_txt)", expressionStart, expressionEnd));
            clause.append(" OR ");
            clause.append(getWhereExactClause(values.get(i), "upper(im.image_desc)", expressionStart, expressionEnd));
        }
        clause.append(" ) ");
        return clause;
    }
    
    
    // *********** Stnd tag match any words *************
    public static StringBuilder getWhereClauseForTagsAnyWords(final List<String> values, final String expressionStart, final String expressionEnd)
    {
        final StringBuilder clause = new StringBuilder(" ( ");
        for (int i = 0; i < values.size(); i++)
        {
            if (i != 0)
            {
                clause.append(" OR ");
            }
            clause.append(getWhereExactClause(values.get(i), "upper(stdTag.TAG_TXT)", expressionStart, expressionEnd));
            clause.append(" OR ");
            clause.append(getWhereExactClause(values.get(i), "upper(stdTag.TAG_TXT)", expressionStart, expressionEnd));
        }
        clause.append(" ) ");
        return clause;
    }

    public static StringBuilder getWhereClauseForImageExactWords(final List<String> values, final String expressionStart, final String expressionEnd)
    {
        final StringBuilder clause = new StringBuilder(" ( ");
        for (int i = 0; i < values.size(); i++)
        {
            if (i != 0)
            {
                clause.append(" OR ");
            }
            clause.append(getWhereExactClause(values.get(i), "upper(im.image_title_txt)", expressionStart, expressionEnd));
            clause.append(" OR ");
            clause.append(getWhereExactClause(values.get(i), 
                    "upper(replace(replace(replace(replace(replace(im.image_desc, CHR(13), ' '), CHR(10), ' '), CHR(9), ' '), '   ', ' '), '  ', ' '))", 
                    expressionStart, expressionEnd));
        }
        clause.append(" ) ");
        return clause;
    }
    
    
    //***************Stnd tag Match Exact phrase *****************************//
    
    public static StringBuilder getWhereClauseForTagsExactWords(final List<String> values, final String expressionStart, final String expressionEnd)
    {
        final StringBuilder clause = new StringBuilder(" ( ");
        for (int i = 0; i < values.size(); i++)
        {
            if (i != 0)
            {
                clause.append(" OR ");
            }
            clause.append(getWhereExactClause(values.get(i), "upper(stdTag.TAG_TXT)", expressionStart, expressionEnd));
            clause.append(" OR ");
            clause.append(getWhereExactClause(values.get(i), 
                    "upper(replace(replace(replace(replace(replace(stdTag.TAG_TXT, CHR(13), ' '), CHR(10), ' '), CHR(9), ' '), '   ', ' '), '  ', ' '))", 
                    expressionStart, expressionEnd));
        }
        clause.append(" ) ");
        return clause;
    }
    
    public static StringBuilder getWhereClauseForImageAllWords(final List<String> values, final String expressionStart, final String expressionEnd)
    {
        final StringBuilder clause = new StringBuilder(" ( ");
        for (int i = 0; i < values.size(); i++)
        {
            if (i != 0)
            {
                clause.append(") AND (");
            }
            clause.append(getWhereClause(values.get(i), "upper(im.image_title_txt)", expressionStart, expressionEnd, true));
            clause.append(" OR ");
            clause.append(getWhereClause(values.get(i), "upper(im.image_desc)", expressionStart, expressionEnd, true));
        }
        clause.append(" ) ");
        return clause;
    }

    // ******************** stnd tag search All words **************************//
    public static StringBuilder getWhereClauseForTagsAllWords(final List<String> values, final String expressionStart, final String expressionEnd)
    {
        final StringBuilder clause = new StringBuilder(" ( ");
        for (int i = 0; i < values.size(); i++)
        {
            if (i != 0)
            {
                clause.append(") AND (");
            }
            clause.append(getWhereClause(values.get(i), "upper(stdTag.TAG_TXT)", expressionStart, expressionEnd, true));
            clause.append(" OR ");
            clause.append(getWhereClause(values.get(i), "upper(stdTag.TAG_TXT)", expressionStart, expressionEnd, true));
        }
        clause.append(" ) ");
        return clause;
    }


    public static StringBuilder getWhereExactClause(final String value, final String columnName, final String expressionStart,
            final String expressionEnd)
    {
        final StringBuilder clause = new StringBuilder();
        String newVal = escapeStringSql(value).toUpperCase();
        clause.append("regexp_instr(");
        clause.append(columnName).append(",");
        clause.append(expressionStart).append(newVal).append(expressionEnd).append(") > 0");
        return clause;
    }

    /**
     * used to display standards on the search standards screen and to generate PDFs.
     * 
     * @param publishId
     * @param localeCode This is a String object
     * @param countryCode This is a String object
     * @param criteria This is a StandardsSearchCriteria object
     * @return String
     */
    public static String generateSearchQuery(long publishId, String localeCode, String countryCode, StandardsSearchCriteria criteria)
    {
        List<StringBuilder> tables = new ArrayList<StringBuilder>();
        List<StringBuilder> clauses = new ArrayList<StringBuilder>();
        List<StringBuilder> hotelLifeCycleClause = new ArrayList<StringBuilder>();
        List<StringBuilder> specialismClause = new ArrayList<StringBuilder>();
        List<StringBuilder> hotelDeptClause = new ArrayList<StringBuilder>();
        List<StringBuilder> guestJourneyClause = new ArrayList<StringBuilder>();
        List<StringBuilder> hotelLocClause = new ArrayList<StringBuilder>();
        List<String> searchCriteria = criteria.getSearchCriteria();
        List<String> replacedSearchCriteria = criteria.getReplacedSearchCriteria();
        List<String> idCriteria = criteria.getIdSearchCriteria();
        List<String> arlHotelLifeCycle = criteria.getHotelLifecycleForQuery();
        List<String> arlSpecialism = criteria.getSpecialism();
        List<String> arlDeptApplicability = criteria.getDeptApplicability();
        List<String> arlHotelLocations = criteria.getLocHotel();
        List<String> arlGuestJourney = criteria.getGuestJourney();
        String compliance = criteria.getComplianceDeadline();
        String textSearchType = criteria.getTextSearchType();
        boolean hasLinks = criteria.isHasLinks();
        boolean hasImages = criteria.isHasImages();
        boolean hasAttachments = criteria.isHasAttachments();
        boolean hasSOP = criteria.isHasSOP();
        boolean hasTM = criteria.isHasTrainingMaterial();

        StringBuilder sqlQuery1 = new StringBuilder();
        StringBuilder sqlQuery2 = new StringBuilder();
        StringBuilder sqlQuery3 = new StringBuilder();
        StringBuilder flagQuery = new StringBuilder();

        sqlQuery1 = new StringBuilder("SELECT * FROM ( WITH ");

        sqlQuery1.append("TAXONOMY AS (");
        if (DEFAULT_LOCALE.equals(localeCode))
        {
            sqlQuery1.append(" SELECT TAX.INDX_ORDER, TAX.PUBLISH_TAXONOMY_ID, TAX.PRNT_PUBLISH_TAXONOMY_ID, TAX.LVL, ");
            sqlQuery1.append(" TAX.HIER_LVL_NBR, TAX.publish_id, TAX.TITLE_TXT, TAX.PATH, TAX.TAXONOMY_DESC ");
            sqlQuery1.append(" FROM (SELECT ROWNUM AS INDX_ORDER, T.PUBLISH_TAXONOMY_ID, T.PRNT_PUBLISH_TAXONOMY_ID, ");
            sqlQuery1.append(" (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, T.publish_id, ");
            sqlQuery1.append("  T.TAXONOMY_DESC, T.TITLE_TXT, ");
            sqlQuery1.append("  SUBSTR(SYS_CONNECT_BY_PATH(t.title_txt, ' &#8594; '), 31) AS PATH ");
            sqlQuery1.append("  FROM PUBLISH_TAXONOMY T ");
            sqlQuery1.append("  WHERE T.publish_id = ").append(publishId);
            sqlQuery1.append("  START WITH T.TAXONOMY_ID = 1 ");
            sqlQuery1.append("  CONNECT BY NOCYCLE PRIOR T.PUBLISH_TAXONOMY_ID = T.PRNT_PUBLISH_TAXONOMY_ID ) TAX ), ");
        }
        else
        {
            sqlQuery1.append(" SELECT TAX_DEF.INDX_ORDER, TAX_DEF.PUBLISH_TAXONOMY_ID, TAX_DEF.PRNT_PUBLISH_TAXONOMY_ID, ");
            sqlQuery1.append(" TAX_DEF.LVL, TAX_DEF.HIER_LVL_NBR, TAX_DEF.publish_id, ");
            sqlQuery1.append(" decode(TAX_PREF.TITLE_TXT, NULL, TAX_DEF.TITLE_TXT, TAX_PREF.TITLE_TXT) AS TITLE_TXT, ");
            sqlQuery1.append(" decode(TAX_PREF.TITLE_TXT, NULL, TAX_DEF.PATH, TAX_PREF.PATH) AS PATH, ");
            sqlQuery1.append(" decode(TAX_PREF.TAXONOMY_DESC, NULL, TAX_DEF.TAXONOMY_DESC, TAX_PREF.TAXONOMY_DESC) AS TAXONOMY_DESC ");
            sqlQuery1.append(" FROM (SELECT ROWNUM AS INDX_ORDER, T.PUBLISH_TAXONOMY_ID, T.PRNT_PUBLISH_TAXONOMY_ID, ");
            sqlQuery1.append("        (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, T.publish_id, ");
            sqlQuery1.append("        (SELECT DECODE(ptx.TAXONOMY_DESC, NULL, t.TAXONOMY_DESC, 'No Translation Found', t.TAXONOMY_DESC, '', t.TAXONOMY_DESC, ptx.TAXONOMY_DESC) ");
            sqlQuery1.append("        FROM PUBLISH_TAXONOMY_XLAT ptx ");
            sqlQuery1.append("        WHERE t.publish_taxonomy_id = ptx.publish_taxonomy_id(+) ");
            sqlQuery1.append("        AND ptx.locale_cd = '").append(localeCode).append("' ) AS TAXONOMY_DESC, ");
            sqlQuery1.append(" (SELECT DECODE(ptx.title_txt, NULL, t.title_txt, 'No Translation Found', t.title_txt, '', t.title_txt, ptx.title_txt) ");
            sqlQuery1.append(" FROM PUBLISH_TAXONOMY_XLAT ptx ");
            sqlQuery1.append(" WHERE t.publish_taxonomy_id   = ptx.publish_taxonomy_id(+) ");
            sqlQuery1.append(" AND ptx.locale_cd = '").append(localeCode).append("' ) AS TITLE_TXT, ");
            sqlQuery1.append(" SUBSTR(SYS_CONNECT_BY_PATH(   (SELECT DECODE(ptx.title_txt, NULL, t.title_txt, 'No Translation Found', t.title_txt, '', t.title_txt, ptx.title_txt) AS title ");
            sqlQuery1.append("        FROM PUBLISH_TAXONOMY_XLAT ptx ");
            sqlQuery1.append("        WHERE t.publish_taxonomy_id   = ptx.publish_taxonomy_id(+) ");
            sqlQuery1.append("        AND ptx.locale_cd = '").append(localeCode).append("' ) , ' &#8594; '),  19) AS PATH ");
            sqlQuery1.append("FROM PUBLISH_TAXONOMY T ");
            sqlQuery1.append("WHERE T.publish_id = ").append(publishId).append(" ");
            sqlQuery1.append("START WITH T.TAXONOMY_ID = 1 CONNECT BY NOCYCLE PRIOR T.PUBLISH_TAXONOMY_ID = T.PRNT_PUBLISH_TAXONOMY_ID ) TAX_PREF, ");
            sqlQuery1.append("    (SELECT ROWNUM AS INDX_ORDER, T.PUBLISH_TAXONOMY_ID, T.PRNT_PUBLISH_TAXONOMY_ID, ");
            sqlQuery1.append("    (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, T.publish_id, ");
            sqlQuery1.append("    T.TAXONOMY_DESC, T.TITLE_TXT, SUBSTR(SYS_CONNECT_BY_PATH(t.title_txt , ' &#8594; '), 31) AS PATH ");
            sqlQuery1.append("FROM PUBLISH_TAXONOMY T ");
            sqlQuery1.append("WHERE T.publish_id = ").append(publishId).append(" ");
            sqlQuery1.append("START WITH T.TAXONOMY_ID = 1 CONNECT BY NOCYCLE PRIOR T.PUBLISH_TAXONOMY_ID = T.PRNT_PUBLISH_TAXONOMY_ID ) TAX_DEF ");
            sqlQuery1.append("WHERE TAX_DEF.PUBLISH_TAXONOMY_ID = TAX_PREF.PUBLISH_TAXONOMY_ID ), ");
        }
        
        sqlQuery1.append(" SEL_PUBLISH AS (SELECT PUBLISH_ID, TO_DATE(PUBLISH_DT, 'DD-MON-YYYY') AS PUBLISH_DT FROM PUBLISH WHERE PUBLISH_ID=").append(publishId).append("),");
        
        sqlQuery1.append(" PUB_STD AS (SELECT s.publish_std_ver_id, s.prnt_std_id, s.std_id, s.std_typ, sx.locale_cd, ");
        sqlQuery1.append(" CASE WHEN (TO_DATE(pcs.std_cmply_deadline_dt, 'DD-MON-YYYY') > sp.PUBLISH_DT AND pcs.std_cmply_deadline_dt > SYSDATE)");
        sqlQuery1.append(" THEN pcs.std_cmply_deadline_dt ELSE NULL END AS cmply_dt,");
        sqlQuery1.append(" DECODE(sx.title_txt, NULL, s.title_txt, sx.title_txt) AS title_txt, ");
        sqlQuery1.append(" DECODE(sx.std_desc, NULL, s.std_desc, sx.std_desc) AS std_desc, ");
        sqlQuery1.append(" pcs.publish_stat_cd  AS stat_desc, ");
        sqlQuery1.append(" pcs.disp_order_nbr, pcs.ctry_nm_cd, pcs.expr_dt ");
        sqlQuery1.append(" FROM SEL_PUBLISH sp, PUBLISH_STD S, PUBLISH_STD_XLAT SX, PUBLISH_CTRY_STD pcs ");
        sqlQuery1.append(" WHERE sp.publish_id = s.publish_id");
        sqlQuery1.append(" AND s.publish_std_ver_id = sx.publish_std_ver_id(+) ");
        sqlQuery1.append(" AND '").append(localeCode).append("' = sx.locale_cd(+) ");
        sqlQuery1.append(" AND s.publish_std_ver_id = pcs.publish_std_ver_id ");
        sqlQuery1.append(" AND pcs.ctry_nm_cd = '").append(countryCode).append("'), ");
        
        if (!StandardsListUtil.isNullOrBlank(idCriteria))
        {
            sqlQuery1.append("SELECTED_STD_REC AS (SELECT publish_std_ver_id, prnt_std_id, std_id, std_typ, locale_cd, cmply_dt, title_txt, std_desc, ");
            sqlQuery1.append(" stat_desc, disp_order_nbr, ctry_nm_cd, expr_dt ");
            sqlQuery1.append(" FROM PUB_STD ");
            sqlQuery1.append(" WHERE prnt_std_id IN ");
            sqlQuery1.append("(SELECT DISTINCT ps.prnt_std_id FROM PUB_STD ps ");
            sqlQuery1.append(" WHERE ( ");
            for (int i = 0; i < idCriteria.size(); i++)
            {
                sqlQuery1.append(" ps.std_id = ").append(idCriteria.get(i)).append(" ");
                if (i != idCriteria.size() - 1)
                {
                    sqlQuery1.append(" OR ");
                }
            }
            sqlQuery1.append(" ))), ");
        }
        
        sqlQuery1.append("ATTACHMENTS AS (SELECT attch.PUBLISH_STD_VER_ID,  'yes' AS attachment_exists, ");
        sqlQuery1.append(" LISTAGG(attch.attachment_typ || ':::' || attch.attachment_title_txt || ':::' || attch.attachment_path_txt || ':::' || attch.CHG_STAT_CD, ';;; ') ");
        sqlQuery1.append(" WITHIN GROUP (ORDER BY attch.PUBLISH_STD_VER_ID, attch.CHG_STAT_CD) AS ATTACH_LST ");
        sqlQuery1.append(" FROM publish_std_attachment attch, PUB_STD std  ");
        sqlQuery1.append(" WHERE attch.publish_std_ver_id = std.publish_std_ver_id ");
        sqlQuery1.append(" AND attch.locale_cd in ('");
        sqlQuery1.append(localeCode);
        sqlQuery1.append("', 'en_GB')");
        sqlQuery1.append(" AND attch.CTRY_NM_CD='");
        sqlQuery1.append(countryCode);
        sqlQuery1.append("' GROUP BY attch.PUBLISH_STD_VER_ID), ");
        
        sqlQuery1.append("LINKS AS (SELECT links.publish_std_ver_id, 'yes' AS link_exists, ");
        sqlQuery1.append(" LISTAGG(links.link_title_txt || ':::' || links.url_txt || ':::' ||  links.chg_stat_cd, ';;; ') ");
        sqlQuery1.append(" WITHIN GROUP (ORDER BY links.publish_std_ver_id) AS LINK_LST ");
        sqlQuery1.append(" FROM PUBLISH_STD_EXTL_LINK links, PUB_STD std  ");
        sqlQuery1.append(" WHERE links.publish_std_ver_id = std.publish_std_ver_id ");
        sqlQuery1.append(" AND links.locale_cd in ('");
        sqlQuery1.append(localeCode);
        sqlQuery1.append("', 'en_GB')");
        sqlQuery1.append(" AND links.ctry_nm_cd = '");
        sqlQuery1.append(countryCode);
        sqlQuery1.append("' GROUP BY links.publish_std_ver_id), ");
        
        sqlQuery1.append("IMAGES AS (SELECT img.publish_std_ver_id, ");//  img.chg_stat_cd,
        sqlQuery1.append(" 'yes' AS img_exists, LISTAGG(img.image_identifier || ':::' || img.image_title_txt ||  ':::' || img.chg_stat_cd || ';;; ') ");
        sqlQuery1.append(" WITHIN GROUP (ORDER BY img.publish_std_ver_id, img.chg_stat_cd) AS IMG_LST_ID ");
        sqlQuery1.append(" FROM PUBLISH_STD_IMAGE img, PUB_STD std ");
        sqlQuery1.append(" WHERE  std.publish_std_ver_id = img.publish_std_ver_id ");
        sqlQuery1.append(" AND img.locale_cd in ('");
        sqlQuery1.append(localeCode);
        sqlQuery1.append("', 'en_GB')");
        sqlQuery1.append(" AND img.CTRY_NM_CD='");
        sqlQuery1.append(countryCode);
        sqlQuery1.append("' GROUP BY img.PUBLISH_STD_VER_ID), "); //, img.CHG_STAT_CD
        if (!StandardsListUtil.isNullOrBlank(searchCriteria))
        {
            sqlQuery1.append(" IMAGESEARCH AS (SELECT im.publish_std_ver_id, im.image_title_txt");
            sqlQuery1.append(" FROM publish_std_image im, pub_std std ");
            sqlQuery1.append(" WHERE std.publish_std_ver_id = im.publish_std_ver_id ");
            sqlQuery1.append(" AND im.locale_cd IN ('");
            sqlQuery1.append(localeCode);
            sqlQuery1.append("', 'en_GB')");
            sqlQuery1.append(" AND im.ctry_nm_cd = '");
            sqlQuery1.append(countryCode);
            sqlQuery1.append("' ");
            if (SEARCH_OPTION_ANY.equals(textSearchType))
            {
                sqlQuery1.append("AND (");
                sqlQuery1.append(getWhereClauseForImageAnyWords(searchCriteria, COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END));
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
                {
                    sqlQuery1.append("OR ");
                    sqlQuery1.append(getWhereClauseForImageAnyWords(replacedSearchCriteria, COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END));
                }
                sqlQuery1.append(") ");
            }
            else if (SEARCH_OPTION_EXACT.equals(textSearchType))
            {
                sqlQuery1.append("AND (");
                sqlQuery1.append(getWhereClauseForImageExactWords(searchCriteria, COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END));
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
                {
                    sqlQuery1.append("OR ");
                    sqlQuery1.append(getWhereClauseForImageExactWords(replacedSearchCriteria, COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END));
                }
                sqlQuery1.append(") ");
            }
            else
            {
                sqlQuery1.append("AND (");
                sqlQuery1.append(getWhereClauseForImageAllWords(searchCriteria, COLUMN_TYPE_STRING_MATCH_START, COLUMN_TYPE_STRING_MATCH_END));
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
                {
                    sqlQuery1.append("OR ");
                    sqlQuery1.append(getWhereClauseForImageAllWords(replacedSearchCriteria, COLUMN_TYPE_STRING_MATCH_START, COLUMN_TYPE_STRING_MATCH_END));
                }
                sqlQuery1.append(") ");
            }
            
            sqlQuery1.append("), ");
        }
        
       // ************************Standard Tag Search starts****************************************// 
        if (!StandardsListUtil.isNullOrBlank(searchCriteria))
        {
        	
            sqlQuery1.append(" TAGSEARCH AS (SELECT stdTag.STD_ID,stdTag.TAG_TXT");
            sqlQuery1.append(" FROM STD_TAG stdTag, pub_std std ");
            sqlQuery1.append(" WHERE std.std_id = stdTag.STD_ID ");
            if (SEARCH_OPTION_ANY.equals(textSearchType))
            {
                sqlQuery1.append("AND (");
                sqlQuery1.append(getWhereClauseForTagsAnyWords(searchCriteria, COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END));
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
                {
                    sqlQuery1.append("OR ");
                    sqlQuery1.append(getWhereClauseForTagsAnyWords(replacedSearchCriteria, COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END));
                }
                sqlQuery1.append(") ");
            }
            else if (SEARCH_OPTION_EXACT.equals(textSearchType))
            {
                sqlQuery1.append("AND (");
                sqlQuery1.append(getWhereClauseForTagsExactWords(searchCriteria, COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END));
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
                {
                    sqlQuery1.append("OR ");
                    sqlQuery1.append(getWhereClauseForTagsExactWords(replacedSearchCriteria, COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END));
                }
                sqlQuery1.append(") ");
            }
            else
            {
                sqlQuery1.append("AND (");
                sqlQuery1.append(getWhereClauseForTagsAllWords(searchCriteria, COLUMN_TYPE_STRING_MATCH_START, COLUMN_TYPE_STRING_MATCH_END));
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
                {
                    sqlQuery1.append("OR ");
                    sqlQuery1.append(getWhereClauseForTagsAllWords(replacedSearchCriteria, COLUMN_TYPE_STRING_MATCH_START, COLUMN_TYPE_STRING_MATCH_END));
                }
                sqlQuery1.append(") ");
            }
            
            sqlQuery1.append("), ");
        }
        // ************************Standard Tag Search Ends****************************************// 
  
        sqlQuery1.append("STD_XREF AS (SELECT xref.referring_std_ver_id AS referring_std_id, " );
        sqlQuery1.append(" LISTAGG((SELECT std_id FROM pub_std WHERE publish_std_ver_id = xref.referenced_std_ver_id), ', ') ");
        sqlQuery1.append(" WITHIN GROUP (ORDER BY xref.disp_order_nbr, xref.referenced_std_ver_id) AS XREF_LST_STD_ID ");
        sqlQuery1.append(" FROM PUB_STD std, publish_std_xref xref, publish_ctry_std pctry ");
        sqlQuery1.append(" WHERE std.PUBLISH_STD_VER_ID = xref.referenced_std_ver_id and std.PUBLISH_STD_VER_ID = pctry.PUBLISH_STD_VER_ID");
        sqlQuery1.append(" AND pctry.ctry_nm_cd = '").append(countryCode).append("' ");
        sqlQuery1.append(" GROUP BY xref.referring_std_ver_id ), ");

        sqlQuery1.append("STD_FLAG AS (SELECT pfs.PUBLISH_STD_VER_ID, " ).append("LISTAGG(pfs.flag_catgy_Id, ', ') ");
        sqlQuery1.append(" WITHIN GROUP (ORDER BY  pfs.PUBLISH_STD_VER_ID) AS FLAG_ID");
        sqlQuery1.append(" FROM PUB_STD pubs, publish_flag_std pfs ");
        sqlQuery1.append(" WHERE pubs.PUBLISH_STD_VER_ID = pfs.PUBLISH_STD_VER_ID ");
        sqlQuery1.append(" GROUP BY pfs.PUBLISH_STD_VER_ID ), ");
        
        sqlQuery1.append("DIRECT_MATCH AS (SELECT tax.indx_order, tax.publish_taxonomy_id,tax.prnt_publish_taxonomy_id, tax.lvl, tax.hier_lvl_nbr, tax.publish_id, tax.path, tax.taxonomy_desc, ");
        sqlQuery1.append(" ps.publish_std_ver_id, ps.prnt_std_id,  ps.std_id, ps.std_typ, ps.title_txt, ps.std_desc, ps.stat_desc, att.attachment_exists, ");
        sqlQuery1.append(" img.img_exists, 'NO_CHANGE' as img_stat_cd, lnk.link_exists, ps.cmply_dt, "); //img.chg_stat_cd as img_stat_cd,
        sqlQuery1.append(" ps.disp_order_nbr, img.img_lst_id, att.attach_lst, lnk.link_lst, xref.xref_lst_std_id, tax.title_txt as index_title, ps.expr_dt, flg.flag_id ");
        
        if (!StandardsListUtil.isNullOrBlank(searchCriteria))
        {
            sqlQuery1.append(", 1 match_rec "); 
            sqlQuery1.append(", decode(imgsrch.publish_std_ver_id, NULL, '', 'IMG_MATCH') match_img,TAGSRCH.TAG_TXT ");
        } else
        {
            sqlQuery1.append(", 0 match_rec, '' match_img ");
        }
        sqlQuery1.append(" FROM TAXONOMY TAX, PUBLISH_TAXONOMY_STD PTS,  ");
        if (!StandardsListUtil.isNullOrBlank(searchCriteria))
        {
            sqlQuery1.append(" TAGSEARCH TAGSRCH, ");
            
        }
        if (!StandardsListUtil.isNullOrBlank(idCriteria))
        {
            sqlQuery1.append(" SELECTED_STD_REC PS, ");
        }
        else
        {
            sqlQuery1.append(" PUB_STD PS, ");
        }
        sqlQuery1.append("ATTACHMENTS ATT, IMAGES IMG, LINKS LNK, STD_XREF XREF, STD_FLAG FLG ");
        if (!StandardsListUtil.isNullOrBlank(searchCriteria))
        {
            sqlQuery1.append(", IMAGESEARCH IMGSRCH  ");
        }

        sqlQuery3 = new StringBuilder(" WHERE pts.taxonomy_id = tax.publish_taxonomy_id ");
        sqlQuery3.append(" AND (pts.publish_std_ver_id = ps.prnt_std_id) ");
//        sqlQuery3.append(" AND (pts.publish_std_ver_id = ps.publish_std_ver_id OR pts.publish_std_ver_id = ps.prnt_std_id) ");
        sqlQuery3.append(" AND ps.publish_std_ver_id = att.publish_std_ver_id(+) AND ps.publish_std_ver_id = lnk.publish_std_ver_id(+) ");
        sqlQuery3.append(" AND ps.publish_std_ver_id = img.publish_std_ver_id(+) ");
        if (!StandardsListUtil.isNullOrBlank(searchCriteria))
        {
            sqlQuery3.append("AND ps.publish_std_ver_id = imgsrch.publish_std_ver_id(+)");
        }
        sqlQuery3.append(" AND ps.publish_std_ver_id = xref.referring_std_id(+)  ");
        sqlQuery3.append(" AND ps.publish_std_ver_id = flg.publish_std_ver_id(+)  ");
        if (!StandardsListUtil.isNullOrBlank(searchCriteria))
        {
        sqlQuery3.append(" AND  ps.std_id = TAGSRCH.STD_ID(+) ");
        }

        sqlQuery2 = new StringBuilder(" )( SELECT * FROM direct_match ");
        if (!criteria.isEmpty())
        {
            sqlQuery2.append(" UNION ");
            sqlQuery2.append(" SELECT tax.indx_order, tax.publish_taxonomy_id,tax.prnt_publish_taxonomy_id, tax.lvl, tax.hier_lvl_nbr, tax.publish_id, tax.path, tax.taxonomy_desc, ");
            sqlQuery2.append(" ps.publish_std_ver_id, ps.prnt_std_id, ps.std_id, ps.std_typ, ps.title_txt, ps.std_desc, ps.stat_desc, att.attachment_exists, ");
            sqlQuery2.append(" img.img_exists, 'NO_CHANGE' as img_stat_cd, lnk.link_exists, ps.cmply_dt, ");//img.chg_stat_cd as img_stat_cd,
            sqlQuery2.append(" ps.disp_order_nbr, img.img_lst_id, att.attach_lst, lnk.link_lst, xref.xref_lst_std_id, tax.title_txt as index_title, ps.expr_dt, flg.flag_id, 0 match_rec, '' match_img ");
            if (!StandardsListUtil.isNullOrBlank(searchCriteria))
            {
            	 sqlQuery2.append(", TAGSRCH.TAG_TXT ");
            }
            sqlQuery2.append(" FROM ");
            sqlQuery2.append(" TAXONOMY TAX, PUBLISH_TAXONOMY_STD PTS, ");
            
            if (!StandardsListUtil.isNullOrBlank(searchCriteria))
            {
              sqlQuery2.append(" TAGSEARCH TAGSRCH, ");
            }
            if (!StandardsListUtil.isNullOrBlank(idCriteria))
            {
                sqlQuery2.append(" SELECTED_STD_REC PS, ");
            }
            else
            {
                sqlQuery2.append(" PUB_STD PS, ");
            }
            sqlQuery2.append(" ATTACHMENTS ATT, IMAGES IMG, LINKS LNK, STD_XREF XREF, STD_FLAG FLG ");
            
            sqlQuery2.append(" WHERE pts.taxonomy_id = tax.publish_taxonomy_id ");
            sqlQuery2.append(" AND pts.publish_std_ver_id IN (SELECT DISTINCT prnt_std_id FROM direct_match) ");
            sqlQuery2.append(" AND ps.publish_std_ver_id NOT IN (SELECT publish_std_ver_id FROM direct_match) ");
            sqlQuery2.append(" AND pts.publish_std_ver_id = ps.prnt_std_id AND ps.publish_std_ver_id = att.publish_std_ver_id(+) ");
            sqlQuery2.append(" AND ps.publish_std_ver_id = lnk.publish_std_ver_id(+) AND ps.publish_std_ver_id = img.publish_std_ver_id(+) ");
            sqlQuery2.append(" AND ps.publish_std_ver_id = xref.referring_std_id(+) AND ps.publish_std_ver_id = flg.publish_std_ver_id(+) ");
            if (!StandardsListUtil.isNullOrBlank(searchCriteria))
            {
            sqlQuery2.append(" AND  ps.std_id = TAGSRCH.STD_ID(+) ");
            }
        }
        sqlQuery2.append(")) ");

        if (!StandardsListUtil.isNullOrBlank(searchCriteria))
        {
            if (SEARCH_OPTION_ANY.equals(textSearchType) || SEARCH_OPTION_EXACT.equals(textSearchType))
            {
                StringBuilder search = new StringBuilder(" AND ( ");
                search.append(" (ps.std_typ = 'GDLN' AND ");
                search.append(getWhereClauseForExactWords(searchCriteria, "upper(ps.std_desc)",
                        COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                search.append(" ) OR ");
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
                {
                    search.append(" (ps.std_typ = 'GDLN' AND ");
                    search.append(getWhereClauseForExactWords(replacedSearchCriteria, "upper(ps.std_desc)",
                            COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                    search.append(" ) OR ");
                }
                
                search.append(" (ps.std_typ != 'GDLN' AND ");
                search.append(getWhereClauseForExactWords(searchCriteria, "upper(ps.title_txt)",
                        COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                search.append(" ) ");
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
                {
                    search.append(" OR (ps.std_typ != 'GDLN' AND ");
                    search.append(getWhereClauseForExactWords(replacedSearchCriteria, "upper(ps.title_txt)",
                            COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                    search.append(" ) ");
                }
                search.append(" OR ps.publish_std_ver_id = imgsrch.publish_std_ver_id ");
                search.append(" OR  ps.std_id = TAGSRCH.STD_ID) ");
                

                sqlQuery3.append(search);
            }
            else
            {
              StringBuilder search = new StringBuilder(" AND ( ");
              search.append(" (ps.std_typ = 'GDLN' AND ");
              search.append(getWhereClauseForAllWords(searchCriteria, "upper(ps.std_desc)",
                      COLUMN_TYPE_STRING_MATCH_START, COLUMN_TYPE_STRING_MATCH_END, true));
              search.append(" ) OR ");
              if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
              {
                  search.append(" (ps.std_typ = 'GDLN' AND ");
                  search.append(getWhereClauseForAllWords(replacedSearchCriteria, "upper(ps.std_desc)",
                          COLUMN_TYPE_STRING_MATCH_START, COLUMN_TYPE_STRING_MATCH_END, true));
                  search.append(" ) OR ");
              }
              
              search.append(" (ps.std_typ != 'GDLN' AND ");
              search.append(getWhereClauseForAllWords(searchCriteria, "upper(ps.title_txt)",
                      COLUMN_TYPE_STRING_MATCH_START, COLUMN_TYPE_STRING_MATCH_END, true));
              search.append(" ) ");
              if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
              {
                  search.append(" OR (ps.std_typ != 'GDLN' AND ");
                  search.append(getWhereClauseForAllWords(replacedSearchCriteria, "upper(ps.title_txt)",
                          COLUMN_TYPE_STRING_MATCH_START, COLUMN_TYPE_STRING_MATCH_END, true));
                  search.append(" ) ");
              }
              search.append(" OR ps.publish_std_ver_id = imgsrch.publish_std_ver_id ");
              search.append(" OR   ps.std_id = TAGSRCH.STD_ID) ");

              sqlQuery3.append(search);
            }
        }

        if (!StandardsListUtil.isNullOrBlank(arlHotelLifeCycle) || !StandardsListUtil.isNullOrBlank(arlSpecialism) || 
        		!StandardsListUtil.isNullOrBlank(arlDeptApplicability) || !StandardsListUtil.isNullOrBlank(arlGuestJourney)
                || !StandardsListUtil.isNullOrBlank(arlHotelLocations))
        {
            flagQuery = new StringBuilder(" ps.publish_std_ver_id IN ");
            flagQuery.append(" (SELECT pubs.publish_std_ver_id FROM publish_flag_std pfs, pub_std pubs ");
            flagQuery.append(" WHERE pubs.publish_std_ver_id = pfs.publish_std_ver_id ");
            
            if (!StandardsListUtil.isNullOrBlank(arlHotelLifeCycle))
            {
                hotelLifeCycleClause.add(getWhereClause(arlHotelLifeCycle, "pfs.flag_catgy_id", COLUMN_TYPE_NUMBER_START,
                        COLUMN_TYPE_NUMBER_END));
                String hotelLifeCycleQuery = buildFlagsQuery(flagQuery, hotelLifeCycleClause);
                clauses.add(new StringBuilder(hotelLifeCycleQuery));
            }
            
            if (!StandardsListUtil.isNullOrBlank(arlSpecialism))
            {
                specialismClause.add(getWhereClause(arlSpecialism, "pfs.flag_catgy_id", COLUMN_TYPE_NUMBER_START,
                        COLUMN_TYPE_NUMBER_END));
                String specialismQuery = buildFlagsQuery(flagQuery, specialismClause);
                clauses.add(new StringBuilder(specialismQuery));
            }
            
            if (!StandardsListUtil.isNullOrBlank(arlDeptApplicability))
            {
                hotelDeptClause.add(getWhereClause(arlDeptApplicability, "pfs.flag_catgy_id", COLUMN_TYPE_NUMBER_START,
                        COLUMN_TYPE_NUMBER_END));
                String deptQuery = buildFlagsQuery(flagQuery, hotelDeptClause);
                clauses.add(new StringBuilder(deptQuery));
            }
            if (!StandardsListUtil.isNullOrBlank(arlGuestJourney))
            {
                guestJourneyClause.add(getWhereClause(arlGuestJourney, "pfs.flag_catgy_id", COLUMN_TYPE_NUMBER_START,
                        COLUMN_TYPE_NUMBER_END));
                String guestQuery = buildFlagsQuery(flagQuery, guestJourneyClause);
                clauses.add(new StringBuilder(guestQuery));
            }
            if (!StandardsListUtil.isNullOrBlank(arlHotelLocations))
            {
                hotelLocClause.add(getWhereClause(arlHotelLocations, "pfs.flag_catgy_id", COLUMN_TYPE_NUMBER_START,
                        COLUMN_TYPE_NUMBER_END));
                String locnQuery = buildFlagsQuery(flagQuery, hotelLocClause);
                clauses.add(new StringBuilder(locnQuery));
            }
        }

        if (hasLinks)
        {
            tables.add(new StringBuilder("PUBLISH_STD_EXTL_LINK sel"));
            clauses.add(new StringBuilder("ps.publish_std_ver_id = sel.publish_std_ver_id"));
            clauses.add(new StringBuilder("EXISTS (SELECT publish_std_ver_id FROM publish_std_extl_link WHERE ps.publish_std_ver_id = sel.publish_std_ver_id AND sel.locale_cd in ('")
                    .append(localeCode).append("', 'en_GB'))"));
        }
        if (hasAttachments || hasSOP || hasTM)
        {
            tables.add(new StringBuilder("PUBLISH_STD_ATTACHMENT psa"));
            clauses.add(new StringBuilder("ps.publish_std_ver_id = psa.publish_std_ver_id"));
        }
        if (hasAttachments)
        {
            clauses.add(new StringBuilder("EXISTS (SELECT publish_std_ver_id FROM publish_std_attachment WHERE ps.publish_std_ver_id = psa.publish_std_ver_id AND psa.locale_cd in ('")
                    .append(localeCode).append("', 'en_GB'))"));
        }
        if (hasImages)
        {
            tables.add(new StringBuilder("PUBLISH_STD_IMAGE psi"));
            clauses.add(new StringBuilder("ps.publish_std_ver_id = psi.publish_std_ver_id"));
            clauses.add(new StringBuilder("EXISTS (SELECT publish_std_ver_id FROM publish_std_image WHERE ps.publish_std_ver_id = psi.publish_std_ver_id AND psi.locale_cd in ('")
                    .append(localeCode).append("', 'en_GB'))"));
        }
        if (hasSOP)
        {
            clauses.add(new StringBuilder("psa.attachment_typ = 'SOP'"));
        }
        if (hasTM)
        {
            clauses.add(new StringBuilder("(psa.attachment_typ = 'INTNL_TRAINING' OR psa.attachment_typ = 'HTL_TRAINING')"));
        }
        if (!StandardsListUtil.IsNullOrBlank(compliance))
        {
            if ("0d".equals(compliance))
            {
                clauses.add(new StringBuilder("ps.cmply_dt BETWEEN to_date('").append(StandardsListUtil.now())
                        .append("','DD-MON-YY') AND to_date('").append(StandardsListUtil.getComplianceDeadline("0d"))
                        .append("','DD-MON-YY')"));
            }
            if ("7d".equals(compliance))
            {
                clauses.add(new StringBuilder("ps.cmply_dt BETWEEN to_date('").append(StandardsListUtil.now())
                        .append("','DD-MON-YY') AND to_date('").append(StandardsListUtil.getComplianceDeadline("7d"))
                        .append("','DD-MON-YY')"));
            }
            if ("1m".equals(compliance))
            {
                clauses.add(new StringBuilder("ps.cmply_dt BETWEEN to_date('").append(StandardsListUtil.now())
                        .append("','DD-MON-YY') AND to_date('").append(StandardsListUtil.getComplianceDeadline("1m"))
                        .append("','DD-MON-YY')"));
            }
            if ("3m".equals(compliance))
            {
                clauses.add(new StringBuilder("ps.cmply_dt BETWEEN to_date('").append(StandardsListUtil.now())
                        .append("','DD-MON-YY') AND to_date('").append(StandardsListUtil.getComplianceDeadline("3m"))
                        .append("','DD-MON-YY')"));
            }
            if ("6m".equals(compliance))
            {
                clauses.add(new StringBuilder("ps.cmply_dt BETWEEN to_date('").append(StandardsListUtil.now())
                        .append("','DD-MON-YY') and  to_date('").append(StandardsListUtil.getComplianceDeadline("6m"))
                        .append("','DD-MON-YY')"));
            }
            if ("12m".equals(compliance))
            {
                clauses.add(new StringBuilder("ps.cmply_dt BETWEEN to_date('").append(StandardsListUtil.now())
                        .append("','DD-MON-YY') AND to_date('").append(StandardsListUtil.getComplianceDeadline("12m"))
                        .append("','DD-MON-YY')"));
            }
            if ("12m+".equals(compliance))
            {
                clauses.add(new StringBuilder("ps.cmply_dt >= to_date('").append(StandardsListUtil.getComplianceDeadline("12m+"))
                        .append("','DD-MON-YY')"));
            }
        }
        String query = buildQuery(sqlQuery1, sqlQuery2, sqlQuery3, tables, clauses);
        if (LOG.isDebugEnabled())
        {
            LOG.debug("query  " + query);
        }
        return query;
    }

    /**
     * @author: khanden
     * @param selectQuery1 This is a StringBuilder object
     * @param selectQuery2 This is a StringBuilder object
     * @param selectQuery3 This is a StringBuilder object
     * @param tables This is a List<StringBuilder> object
     * @param clauses This is a List<StringBuilder> object
     * @return String
     */
    public static String buildQuery(StringBuilder selectQuery1, StringBuilder selectQuery2, StringBuilder selectQuery3,
            List<StringBuilder> tables, List<StringBuilder> clauses)
    {
        StringBuilder sqlQuery = selectQuery1;
        boolean appendComma = false;
        if (!tables.isEmpty())
        {
            sqlQuery.append(" ,");

            for (StringBuilder table : tables)
            {
                if (appendComma)
                {
                    sqlQuery.append(" ,");
                }
                appendComma = true;
                sqlQuery.append(" ").append(table);
            }
        }
        sqlQuery.append(selectQuery3);
        if (!clauses.isEmpty())
        {
            sqlQuery.append(SPACE_AND_SPACE);
            boolean appendAnd = false;
            for (StringBuilder clause : clauses)
            {
                if (appendAnd)
                {
                    sqlQuery.append(SPACE_AND_SPACE);
                }
                appendAnd = true;
                sqlQuery.append(" ").append(clause);
            }
        }
        sqlQuery.append(selectQuery2);
        return sqlQuery.toString();
    }

    /**
     * @param selectQuery This is a StringBuilder object
     * @param clauses This is a List<StringBuilder> object
     * @return String
     */
    public static String buildFlagsQuery(StringBuilder selectQuery, List<StringBuilder> clauses)
    {
        StringBuilder sqlQuery = new StringBuilder();
        sqlQuery.append(selectQuery.toString());
        if (!clauses.isEmpty())
        {
            sqlQuery.append(SPACE_AND_SPACE);
            boolean appendAnd = false;
            for (StringBuilder clause : clauses)
            {
                if (appendAnd)
                {
                    sqlQuery.append(SPACE_AND_SPACE);
                }
                appendAnd = true;
                sqlQuery.append(StringPool.SPACE);
                sqlQuery.append(clause);
                ;
            }
        }
        sqlQuery.append(" ) ");
        return sqlQuery.toString();
    }

    /**
     * @author: kryvora Fetch all indexes for the Brand for production.
     * @param publishId publication ID
     * @return string
     */
    public static String getAllIndexQueryProd(final long publishId)
    {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT tax.indx_order, tax.publish_taxonomy_id, tax.prnt_publish_taxonomy_id,  tax.lvl, ");
        builder.append("tax.hier_lvl_nbr, tax.publish_id, tax.path, tax.taxonomy_desc, 0 publish_std_ver_id, ");
        builder.append("0 prnt_std_id,  0 std_id, NULL std_typ, NULL title_txt, NULL std_desc, NULL stat_desc, ");
        builder.append("NULL attachment_exists,  NULL attch_stat_cd,  NULL img_exists, NULL img_stat_cd, NULL link_exists, ");
        builder.append("NULL link_stat_cd, NULL cmply_dt, 0 disp_order_nbr, NULL img_lst_id, NULL attach_lst, NULL link_lst, ");
        builder.append("NULL xref_lst_std_id, tax.title_txt as index_title  FROM (SELECT rownum AS INDX_ORDER, t.publish_taxonomy_id, ");
        builder.append("t.prnt_publish_taxonomy_id,t.taxonomy_desc, t.title_txt, (level - 1) AS LVL, ");
        builder.append("t.hier_lvl_nbr, t.publish_id, substr(sys_connect_by_path( t.title_txt , ' &#8594; '),  31) AS PATH ");
        builder.append("FROM publish_taxonomy T ");
        builder.append("WHERE T.publish_id = ").append(publishId).append(" ");
        builder.append("START WITH t.taxonomy_id = 1 ");
        builder.append("CONNECT BY PRIOR t.publish_taxonomy_id = t.prnt_publish_taxonomy_id ORDER SIBLINGS BY t.hier_lvl_nbr ) TAX ");
        return builder.toString();
    }

    /**
     * @author: kryvora Fetch all indexes for the Brand for Staging.
     * @param publishId publication ID
     * @return string
     */
    public static String getAllIndexQueryStage(final long publishId)
    {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT tax.indx_order, tax.stage_taxonomy_id, tax.prnt_stage_taxomomy_id as prnt_stage_taxonomy_id, tax.lvl,");
        builder.append(" tax.hier_lvl_nbr, tax.publish_id, tax.path, tax.taxonomy_desc, 0 publish_std_ver_id,");
        builder.append(" 0 prnt_std_id,  0 std_id, NULL std_typ, NULL title_txt, NULL std_desc, NULL stat_desc,");
        builder.append(" NULL attachment_exists,  NULL attch_stat_cd,  NULL img_exists, NULL img_stat_cd, NULL link_exists,");
        builder.append(" NULL link_stat_cd, NULL cmply_dt, 0 disp_order_nbr, NULL img_lst_id, NULL attach_lst, NULL link_lst,");
        builder.append(" NULL xref_lst_std_id, tax.title_txT AS INDEX_TITLE  FROM (SELECT rownum as indx_order, t.stage_taxonomy_id,");
        builder.append(" t.prnt_stage_taxomomy_id, t.taxonomy_desc, t.title_txt, (level - 1) AS LVL,");
        builder.append(" t.hier_lvl_nbr, t.publish_id, substr(sys_connect_by_path(t.title_txt , ' &#8594; '),  31) AS PATH");
        builder.append(" FROM stage_taxonomy t");
        builder.append(" WHERE t.publish_id = ").append(publishId).append(" ");
        builder.append(" START WITH t.taxonomy_id = 1");
        builder.append(" CONNECT BY PRIOR t.stage_taxonomy_id = t.prnt_stage_taxomomy_id ORDER SIBLINGS BY t.hier_lvl_nbr) TAX");
        return builder.toString();
    }

    /**
     * @param localeCode This is a String object
     * @param chainCode This is a String object
     * @param countryCode This is a String object
     * @param criteria This is a StandardsSearchCriteria object
     * @return String
     */
    public static String generateSearchQueryForAllSupportingMaterial(long publishId, String localeCode, String chainCode, String countryCode,
            StandardsSearchCriteria criteria)
    {
        List<StringBuilder> tables = new ArrayList<StringBuilder>();
        List<StringBuilder> clauses = new ArrayList<StringBuilder>();
        List<StringBuilder> hotelLifeCycleClause = new ArrayList<StringBuilder>();
        List<StringBuilder> specialismClause = new ArrayList<StringBuilder>();
        List<StringBuilder> hotelDeptClause = new ArrayList<StringBuilder>();
        List<StringBuilder> guestJourneyClause = new ArrayList<StringBuilder>();
        List<StringBuilder> hotelLocClause = new ArrayList<StringBuilder>();
        List<String> searchCriteria = criteria.getSearchCriteria();
        List<String> replacedSearchCriteria = criteria.getReplacedSearchCriteria();
        List<String> idCriteria = criteria.getIdSearchCriteria();
        List<String> arlHotelLifeCycle = criteria.getHotelLifecycleForQuery();
        List<String> arlSpecialism = criteria.getSpecialism();
        List<String> arlDeptApplicability = criteria.getDeptApplicability();
        List<String> arlGuestJourney = criteria.getGuestJourney();
        List<String> arlHotelLocations = criteria.getLocHotel();
        String compliance = criteria.getComplianceDeadline();
        String textSearchType = criteria.getTextSearchType();
        boolean hasLinks = criteria.isHasLinks();
        boolean hasImages = criteria.isHasImages();
        boolean hasAttachments = criteria.isHasAttachments();
        boolean hasSOP = criteria.isHasSOP();
        boolean hasTM = criteria.isHasTrainingMaterial();

        StringBuilder sqlQuery1 = new StringBuilder();
        StringBuilder sqlQuery2 = new StringBuilder();
        StringBuilder sqlQuery3 = new StringBuilder();
        StringBuilder flagQuery = new StringBuilder();
        //Publication
        sqlQuery1 = new StringBuilder();
        //Published Standards
        sqlQuery1.append(" WITH PUB_STD AS (select ps.std_id, ps.prnt_std_id, ps.PUBLISH_STD_VER_ID, ps.stat_desc, ");
        sqlQuery1.append(" ps.disp_order_nbr, ps.title_txt, ps.std_typ, ps.std_desc , CASE ");
        sqlQuery1.append(" WHEN CTRY.std_cmply_deadline_dt > SYSDATE THEN CTRY.std_cmply_deadline_dt ELSE NULL ");
        sqlQuery1.append(" END AS cmply_dt ");
        sqlQuery1.append(" from publish_std ps, PUBLISH_CTRY_STD CTRY ");
        sqlQuery1.append(" where publish_id = ");
        sqlQuery1.append(publishId);
        sqlQuery1.append(" and ps.PUBLISH_STD_VER_ID = ctry.PUBLISH_STD_VER_ID and ctry.ctry_nm_cd = '");
        sqlQuery1.append(countryCode);
        sqlQuery1.append("' ), ");
        //Attachments
        sqlQuery1.append(" ATTACHMENTS AS (SELECT std.STD_ID AS ATTCHSTDID, attch.publish_std_attachment_id AS STDATTCHID, ");
        sqlQuery1.append(" attch.attachment_typ AS ATTTYPE, attch.attachment_title_txt AS ATTTITLE, ");
        sqlQuery1.append(" attch.attachment_path_txt AS ATTPATH,attch.prnt_publish_std_attachment_id AS ATTPRNTID, ");
        sqlQuery1.append(" attch.CHG_STAT_CD AS ATTSTATCD,attch.LOCALE_CD AS ATTLOCALECD, ");
        sqlQuery1.append(" attch.PUBLISH_STD_VER_ID as ATTVERID, std.PRNT_STD_ID AS ATTSTDPRNTID,null AS EXTSTDID,null AS EXTLINKID,null AS EXTTITLE,");
        sqlQuery1.append(" null AS EXTURL,null AS EXTPRNTID,null AS EXTSTATCD,null AS EXTLOCALECD, null as EXTVERID, null as EXTSTDPRNTID ");
        sqlQuery1.append(" FROM publish_std_attachment attch, PUB_STD std WHERE attch.PUBLISH_STD_VER_ID = std.PUBLISH_STD_VER_ID ");
        sqlQuery1.append(" AND ( attch.publish_std_attachment_id = attch.prnt_publish_std_attachment_id ");
        sqlQuery1.append(" or attch.locale_cd in ('");
        sqlQuery1.append(localeCode);
        sqlQuery1.append("','en_GB'))");
        sqlQuery1.append(" AND attch.PUBLISH_STD_VER_ID = std.PUBLISH_STD_VER_ID ");
        sqlQuery1.append(" AND attch.ctry_nm_cd='");
        sqlQuery1.append(countryCode);
        sqlQuery1.append("'),");
        //Links
        sqlQuery1.append(" LINKS AS (SELECT null AS ATTCHSTDID,null AS STDATTCHID,null AS ATTTYPE,");
        sqlQuery1.append(" null AS ATTTITLE,null AS ATTPATH,null AS ATTPRNTID,null AS ATTSTATCD,null AS ATTLOCALECD, null as ATTVERID,null as ATTSTDPRNTID,");
        sqlQuery1.append(" std.STD_ID AS EXTSTDID,links.PUBLISH_STD_EXTL_LINK_ID as EXTLINKID, links.link_title_txt as EXTTITLE, links.url_txt as EXTURL, ");
        sqlQuery1.append(" links.prnt_publish_std_extl_link_id as EXTPRNTID,links.CHG_STAT_CD as EXTSTATCD,links.LOCALE_CD as EXTLOCALECD,");
        sqlQuery1.append(" links.PUBLISH_STD_VER_ID as EXTVERID, std.PRNT_STD_ID AS EXTSTDPRNTID FROM PUBLISH_STD_EXTL_LINK links, PUB_STD std   ");
        sqlQuery1.append(" WHERE links.PUBLISH_STD_VER_ID = std.PUBLISH_STD_VER_ID AND ");
        sqlQuery1.append(" (links.PUBLISH_STD_EXTL_LINK_ID = links.PRNT_PUBLISH_STD_EXTL_LINK_ID or links.locale_cd in ('");
        sqlQuery1.append(localeCode);
        sqlQuery1.append("','en_GB'))");
        sqlQuery1.append(" AND links.PUBLISH_STD_VER_ID = std.PUBLISH_STD_VER_ID ");
        sqlQuery1.append(" AND links.ctry_nm_cd='");
        sqlQuery1.append(countryCode);
        sqlQuery1.append("'),");
        
        sqlQuery1.append(" selected_std_id AS ( select distinct ps.prnt_std_id AS publish_std_ver_id ");
        sqlQuery1.append(" FROM PUB_STD ps  ");
        
        if (!StandardsListUtil.isNullOrBlank(idCriteria))
        {
            sqlQuery1.append(" WHERE ( ");
            for (int i = 0; i < idCriteria.size(); i++)
            {
                sqlQuery1.append(" ps.std_id = ").append(idCriteria.get(i)).append(" ");
                if (i != idCriteria.size() - 1)
                {
                    sqlQuery1.append(" OR ");
                }

            }
            sqlQuery1.append(" ) ");
        }
        sqlQuery1.append(" ),");
        
        sqlQuery1.append(" supporting_material AS ( select * from ATTACHMENTS union select * from links),");
        
        sqlQuery1.append(" selected_records AS (");
        sqlQuery1.append("SELECT s.publish_std_ver_id, s.prnt_std_id, s.std_id, s.std_typ, sx.locale_cd,decode(sx.title_txt, ");
        sqlQuery1.append("NULL, s.title_txt, sx.title_txt)  AS title_txt,");
        sqlQuery1.append("decode(sx.std_desc, NULL, s.std_desc, sx.std_desc) AS std_desc,s.stat_desc, s.disp_order_nbr, ");
        sqlQuery1.append("s.cmply_dt FROM PUB_STD S,");
        sqlQuery1.append("PUBLISH_STD_XLAT SX, selected_std_id SEL_IDS  WHERE  ");
        sqlQuery1.append("s.publish_std_ver_id = sx.publish_std_ver_id(+) AND '");
        sqlQuery1.append(localeCode);
        sqlQuery1.append("' = sx.locale_cd(+) ");
        sqlQuery1.append(" AND s.prnt_std_ID  = SEL_IDS.PUBLISH_STD_VER_ID ");
        sqlQuery1.append("),");

        if (!StandardsListUtil.isNullOrBlank(searchCriteria))
        {
            sqlQuery1.append(" IMAGESEARCH AS ( SELECT im.publish_std_ver_id,  im.image_title_txt");
            sqlQuery1.append(" FROM publish_std_image im, pub_std std ");
            sqlQuery1.append(" WHERE std.publish_std_ver_id = im.publish_std_ver_id ");
            sqlQuery1.append(" AND im.locale_cd in ('");
            sqlQuery1.append(localeCode);
            sqlQuery1.append("', 'en_GB' ) ");
            sqlQuery1.append(" AND im.ctry_nm_cd = '");
            sqlQuery1.append(countryCode);
            sqlQuery1.append("' ");
            if (SEARCH_OPTION_ANY.equals(textSearchType))
            {
                sqlQuery1.append("AND (");
                sqlQuery1.append(getWhereClauseForImageAnyWords(searchCriteria, COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END));
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
                {
                    sqlQuery1.append("OR ");
                    sqlQuery1.append(getWhereClauseForImageAnyWords(replacedSearchCriteria, COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END));
                }
                sqlQuery1.append(") ");
            }
            else if (SEARCH_OPTION_EXACT.equals(textSearchType))
            {
                sqlQuery1.append("AND (");
                sqlQuery1.append(getWhereClauseForImageExactWords(searchCriteria, COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END));
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
                {
                    sqlQuery1.append("OR ");
                    sqlQuery1.append(getWhereClauseForImageExactWords(replacedSearchCriteria, COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END));
                }
                sqlQuery1.append(") ");
            }
            else
            {
                sqlQuery1.append("AND (");
                sqlQuery1.append(getWhereClauseForImageAllWords(searchCriteria, COLUMN_TYPE_STRING_MATCH_START, COLUMN_TYPE_STRING_MATCH_END));
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
                {
                    sqlQuery1.append("OR ");
                    sqlQuery1.append(getWhereClauseForImageAllWords(replacedSearchCriteria, COLUMN_TYPE_STRING_MATCH_START, COLUMN_TYPE_STRING_MATCH_END));
                }
                sqlQuery1.append(") ");
            }
            
            sqlQuery1.append("), ");
        }
        sqlQuery1.append(" DIRECT_MATCH AS (SELECT distinct ps.prnt_std_id, attchstdid, stdattchid, atttype, atttitle, attpath, attprntid, attstatcd, ");
        sqlQuery1.append("attlocalecd, extstdid, extlinkid, exttitle, ");
        sqlQuery1.append("exturl, extprntid,  extstatcd, extlocalecd, ps.cmply_dt ");
        sqlQuery1.append("FROM selected_records ps, supporting_material sm");
        if (!StandardsListUtil.isNullOrBlank(searchCriteria))
        {
            sqlQuery1.append(", IMAGESEARCH IMGSRCH");
        }
        sqlQuery3 = new StringBuilder(" WHERE ")
                .append(" (ps.prnt_std_id = sm.attstdprntid or ps.prnt_std_id = sm.extstdprntid) AND (ps.std_id = attchstdid or ps.std_id = extstdid) ");
        if (!StandardsListUtil.isNullOrBlank(searchCriteria))
        {
            sqlQuery3.append(" AND ps.publish_std_ver_id = imgsrch.publish_std_ver_id(+)");
        }
        sqlQuery2 = new StringBuilder(" )(SELECT * FROM direct_match ");
        if (!criteria.isEmpty()) {
	        sqlQuery2.append(" UNION SELECT  distinct ps.prnt_std_id, attchstdid, stdattchid, atttype, atttitle, attpath, attprntid, attstatcd, attlocalecd, extstdid, extlinkid, exttitle,");
	        sqlQuery2.append(" exturl, extprntid,  extstatcd,  extlocalecd , ps.cmply_dt");
	        sqlQuery2.append(" FROM  selected_records PS, supporting_material sm ");
	        sqlQuery2.append(" WHERE (PS.PUBLISH_STD_VER_ID = sm.ATTVERID  OR  ps.publish_std_ver_id = sm.extverid ) ");
	        sqlQuery2.append(" AND ps.prnt_std_id IN (SELECT distinct prnt_std_id FROM direct_match) ");
        }
        sqlQuery2.append(")");
        if (!StandardsListUtil.isNullOrBlank(searchCriteria))
        {
            if (SEARCH_OPTION_ANY.equals(textSearchType) || SEARCH_OPTION_EXACT.equals(textSearchType))
            {
                StringBuilder search = new StringBuilder(" AND ( ");
                search.append(" (ps.std_typ = 'GDLN' AND ");
                search.append(getWhereClauseForExactWords(searchCriteria, "upper(ps.std_desc)",
                        COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                search.append(" ) OR ");
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
                {
                    search.append(" (ps.std_typ = 'GDLN' AND ");
                    search.append(getWhereClauseForExactWords(replacedSearchCriteria, "upper(ps.std_desc)",
                            COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                    search.append(" ) OR ");
                }
                
                search.append(" (ps.std_typ != 'GDLN' AND ");
                search.append(getWhereClauseForExactWords(searchCriteria, "upper(ps.title_txt)",
                        COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                search.append(" ) ");
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
                {
                    search.append(" OR (ps.std_typ != 'GDLN' AND ");
                    search.append(getWhereClauseForExactWords(replacedSearchCriteria, "upper(ps.title_txt)",
                            COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                    search.append(" ) ");
                }
                search.append(" OR ps.publish_std_ver_id = imgsrch.publish_std_ver_id) ");

                sqlQuery3.append(search);
            }
            else
            {
              StringBuilder search = new StringBuilder(" AND ( ");
              search.append(" (ps.std_typ = 'GDLN' AND ");
              search.append(getWhereClauseForAllWords(searchCriteria, "upper(ps.std_desc)",
                      COLUMN_TYPE_STRING_MATCH_START, COLUMN_TYPE_STRING_MATCH_END, true));
              search.append(" ) OR ");
              if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
              {
                  search.append(" (ps.std_typ = 'GDLN' AND ");
                  search.append(getWhereClauseForAllWords(replacedSearchCriteria, "upper(ps.std_desc)",
                          COLUMN_TYPE_STRING_MATCH_START, COLUMN_TYPE_STRING_MATCH_END, true));
                  search.append(" ) OR ");
              }
              
              search.append(" (ps.std_typ != 'GDLN' AND ");
              search.append(getWhereClauseForAllWords(searchCriteria, "upper(ps.title_txt)",
                      COLUMN_TYPE_STRING_MATCH_START, COLUMN_TYPE_STRING_MATCH_END, true));
              search.append(" ) ");
              if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
              {
                  search.append(" OR (ps.std_typ != 'GDLN' AND ");
                  search.append(getWhereClauseForAllWords(replacedSearchCriteria, "upper(ps.title_txt)",
                          COLUMN_TYPE_STRING_MATCH_START, COLUMN_TYPE_STRING_MATCH_END, true));
                  search.append(" ) ");
              }
              search.append(" OR ps.publish_std_ver_id = imgsrch.publish_std_ver_id) ");

              sqlQuery3.append(search);
            }
        }

        if (!StandardsListUtil.isNullOrBlank(arlHotelLifeCycle) || !StandardsListUtil.isNullOrBlank(arlSpecialism) || 
        		!StandardsListUtil.isNullOrBlank(arlDeptApplicability) || !StandardsListUtil.isNullOrBlank(arlGuestJourney)
                || !StandardsListUtil.isNullOrBlank(arlHotelLocations))
        {
            String deptQuery = "";
            String guestQuery = "";
            String locnQuery = "";
            String hotelLifeCycleQuery = "";
            String specialismQuery = "";
            
            flagQuery = new StringBuilder(" PS.PUBLISH_STD_VER_ID IN ");
            flagQuery.append(" (SELECT pubs.publish_std_ver_id FROM publish_flag_std pfs, pub_std pubs ");
            flagQuery.append(" WHERE pubs.publish_std_ver_id = pfs.publish_std_ver_id  ");
            
            if (!StandardsListUtil.isNullOrBlank(arlHotelLifeCycle))
            {
            	hotelLifeCycleClause.add(getWhereClause(arlHotelLifeCycle, "pfs.flag_catgy_id", COLUMN_TYPE_NUMBER_START,
                        COLUMN_TYPE_NUMBER_END));
                hotelLifeCycleQuery = buildFlagsQuery(flagQuery, hotelLifeCycleClause);
                clauses.add(new StringBuilder(hotelLifeCycleQuery));
            }
           
            if (!StandardsListUtil.isNullOrBlank(arlSpecialism))
            {
                specialismClause.add(getWhereClause(arlSpecialism, "pfs.flag_catgy_id", COLUMN_TYPE_NUMBER_START,
                        COLUMN_TYPE_NUMBER_END));
                specialismQuery = buildFlagsQuery(flagQuery, specialismClause);
                clauses.add(new StringBuilder(specialismQuery));
            }

            if (!StandardsListUtil.isNullOrBlank(arlDeptApplicability))
            {
                hotelDeptClause.add(getWhereClause(arlDeptApplicability, "pfs.flag_catgy_id", COLUMN_TYPE_NUMBER_START,
                        COLUMN_TYPE_NUMBER_END));
                deptQuery = buildFlagsQuery(flagQuery, hotelDeptClause);
                clauses.add(new StringBuilder(deptQuery));
            }
            if (!StandardsListUtil.isNullOrBlank(arlGuestJourney))
            {
                guestJourneyClause.add(getWhereClause(arlGuestJourney, "pfs.flag_catgy_id", COLUMN_TYPE_NUMBER_START,
                        COLUMN_TYPE_NUMBER_END));
                guestQuery = buildFlagsQuery(flagQuery, guestJourneyClause);
                clauses.add(new StringBuilder(guestQuery));
            }
            if (!StandardsListUtil.isNullOrBlank(arlHotelLocations))
            {
                hotelLocClause.add(getWhereClause(arlHotelLocations, "pfs.flag_catgy_id", COLUMN_TYPE_NUMBER_START,
                        COLUMN_TYPE_NUMBER_END));
                locnQuery = buildFlagsQuery(flagQuery, hotelLocClause);
                clauses.add(new StringBuilder(locnQuery));
            }
        }
        if (hasLinks)
        {
            clauses.add(new StringBuilder("ps.publish_std_ver_id = sm.extverid"));
        }
        if (hasAttachments || hasSOP || hasTM)
        {
            clauses.add(new StringBuilder("ps.publish_std_ver_id = sm.attverid"));
        }
        if (hasImages)
        {
            tables.add(new StringBuilder("PUBLISH_STD_IMAGE psi"));
            clauses.add(new StringBuilder("(psi.publish_std_image_id = psi.prnt_publish_std_image_id OR psi.locale_cd in ('")
                    .append(localeCode)
                    .append("','en_GB' )) AND (ps.PUBLISH_STD_VER_ID = psi.PUBLISH_STD_VER_ID OR ps.prnt_std_id = ")
                    .append("(SELECT tps.prnt_std_id from pub_std tps WHERE tps.publish_std_ver_id = psi.publish_std_ver_id ")
                    .append("))"));
        }
        if (hasSOP)
        {
            clauses.add(new StringBuilder("sm.atttype = 'SOP'"));
        }
        if (hasTM)
        {
            clauses.add(new StringBuilder("( sm.atttype = 'INTNL_TRAINING' OR sm.atttype = 'HTL_TRAINING' )"));
        }
        if (compliance != null && compliance.trim().length() != 0)
        {
            tables.add(new StringBuilder("PUBLISH_CTRY_STD scc"));
            clauses.add(new StringBuilder("ps.publish_std_ver_id = scc.publish_std_ver_id"));
            if ("0d".equals(compliance))
            {
                clauses.add(new StringBuilder("ps.cmply_dt between to_date('").append(StandardsListUtil.now())
                        .append("','DD-MON-YY') AND to_date('").append(StandardsListUtil.getComplianceDeadline("0d"))
                        .append("','DD-MON-YY')"));
            }
            if ("7d".equals(compliance))
            {
                clauses.add(new StringBuilder("ps.cmply_dt between  to_date('").append(StandardsListUtil.now())
                        .append("','DD-MON-YY') AND  ").append("to_date('").append(StandardsListUtil.getComplianceDeadline("7d"))
                        .append("','DD-MON-YY')"));
            }
            if ("1m".equals(compliance))
            {
                clauses.add(new StringBuilder("ps.cmply_dt between  to_date('").append(StandardsListUtil.now())
                        .append("','DD-MON-YY') AND  ").append("to_date('").append(StandardsListUtil.getComplianceDeadline("1m"))
                        .append("','DD-MON-YY')"));
            }
            if ("3m".equals(compliance))
            {
                clauses.add(new StringBuilder("ps.cmply_dt between  to_date('").append(StandardsListUtil.now())
                        .append("','DD-MON-YY') AND  ").append("to_date('").append(StandardsListUtil.getComplianceDeadline("3m"))
                        .append("','DD-MON-YY')"));
            }
            if ("6m".equals(compliance))
            {
                clauses.add(new StringBuilder("ps.cmply_dt between  to_date('").append(StandardsListUtil.now())
                        .append("','DD-MON-YY') AND  ").append("to_date('").append(StandardsListUtil.getComplianceDeadline("6m"))
                        .append("','DD-MON-YY')"));
            }
            if ("12m".equals(compliance))
            {
                clauses.add(new StringBuilder("ps.cmply_dt between  to_date('").append(StandardsListUtil.now())
                        .append("','DD-MON-YY') AND  ").append("to_date('")
                        .append(StandardsListUtil.getComplianceDeadline("12m")).append("','DD-MON-YY')"));
            }
            if ("12m+".equals(compliance))
            {
                clauses.add(new StringBuilder("ps.cmply_dt >=  to_date('").append(StandardsListUtil.getComplianceDeadline("12m+"))
                        .append("','DD-MON-YY')"));
            }
        }
        String query = buildQuery(sqlQuery1, sqlQuery2, sqlQuery3, tables, clauses);
        if (LOG.isDebugEnabled())
        {
            LOG.debug("query ------ " + query);
        }
        return query;
    }

    /**
     * @param stdId This is a long object
     * @param locale This is a String object
     * @param countryCode This is a String object
     * @return String
     */
    public static String getRelatedImagesForStaging(long stdId, String locale, String countryCode)
    {
        StringBuilder query = new StringBuilder();
        if (Validator.isNotNull(stdId))
        {
            query.append("SELECT si.stage_std_image_id, si.image_identifier, si.image_title_txt, si.prnt_stage_std_image_id, ");
            query.append("si.chg_stat_cd, s.std_id, si.locale_cd ");
            query.append("FROM stage_std s, stage_std_image si, stage_ctry_std pcs ");
            query.append("WHERE s.stage_std_ver_id = si.stage_std_ver_id ");
            query.append("AND s.stage_std_ver_id = ").append(stdId).append(" ");
            query.append("AND pcs.stage_std_ver_id = s.stage_std_ver_id ");
            query.append("AND pcs.ctry_nm_cd = '").append(countryCode).append("' ");
            query.append("AND si.ctry_nm_cd = '").append(countryCode).append("' ");
            query.append("AND (si.stage_std_image_id = si.prnt_stage_std_image_id OR si.locale_cd IN ('");
            query.append(locale).append("','").append(DEFAULT_LOCALE).append("')) ");

            if (LOG.isDebugEnabled())
            {
                LOG.debug("query for STAGING related images ::" + query.toString());
            }
        }
        return query.toString();
    }

    /**
     * @param publishId publication id
     * @param stdId This is a long object
     * @param locale This is a String object
     * @param countryCode This is a String object
     * @return String
     */
    public static String getStagingSupportingMaterial(long publishId, long stdId, String locale, String countryCode)
    {
        StringBuilder query = new StringBuilder();
        if (Validator.isNotNull(stdId))
        {
        	//Stage Standards
        	query.append("WITH STAGING_STD AS (select ps.std_id, ps.prnt_std_id, ps.STAGE_STD_VER_ID, ps.stat_desc, ");
        	query.append(" ps.disp_order_nbr, ps.title_txt, ps.std_typ, ps.std_desc , CASE ");
        	query.append(" WHEN CTRY.std_cmply_deadline_dt > SYSDATE THEN CTRY.std_cmply_deadline_dt ELSE NULL ");
        	query.append(" END AS cmply_dt ");
        	query.append(" from stage_std ps, STAGE_CTRY_STD CTRY ");
        	query.append(" where publish_id = ");
        	query.append(publishId);
        	query.append(" and ps.STAGE_STD_VER_ID = ctry.STAGE_STD_VER_ID and ctry.ctry_nm_cd = '");
        	query.append(countryCode);
        	query.append("' ), ");
            //Attachments
            query.append("ATTACHMENTS AS (SELECT null as prnt_std_id, std.STD_ID AS ATTCHSTDID, attch.stage_std_attachment_id AS STDATTCHID,");
            query.append(" attch.attachment_typ AS ATTTYPE, attch.attachment_title_txt AS ATTTITLE,");
            query.append(" attch.attachment_path_txt AS ATTPATH,attch.prnt_stage_std_attachment_id AS ATTPRNTID,");
            query.append(" attch.CHG_STAT_CD AS ATTSTATCD,attch.LOCALE_CD AS ATTLOCALECD, null AS EXTSTDID,");
            query.append(" null AS EXTLINKID, null AS EXTTITLE, null AS EXTURL,");
            query.append(" null AS EXTPRNTID,null AS EXTSTATCD,null AS EXTLOCALECD ");
            query.append("FROM stage_std_attachment attch, STAGING_STD std ");
            query.append("WHERE attch.stage_std_ver_id = std.stage_std_ver_id ");
            query.append("AND attch.stage_std_ver_id = ").append(stdId).append(" ");
            query.append("AND attch.ctry_nm_cd = '").append(countryCode).append("' ");
            query.append("AND (attch.prnt_stage_std_attachment_id = attch.stage_std_attachment_id ");
            query.append("OR attch.locale_cd in ('").append(locale).append("','").append(DEFAULT_LOCALE).append("'))),");
            //Links
            query.append("LINKS AS (SELECT null as prnt_std_id, null AS ATTCHSTDID, null AS STDATTCHID, null AS ATTTYPE, null AS ATTTITLE,");
            query.append(" null AS ATTPATH, null AS ATTPRNTID, null AS ATTSTATCD, null AS ATTLOCALECD, std.STD_ID,");
            query.append(" links.stage_std_extl_link_id, links.link_title_txt, links.url_txt, links.prnt_stage_std_extl_link_id,");
            query.append(" links.CHG_STAT_CD, links.LOCALE_CD FROM STAGE_STD_EXTL_LINK links, STAGING_STD std ");
            query.append("WHERE links.stage_std_ver_id = std.stage_std_ver_id ");
            query.append(" AND links.stage_std_ver_id = ").append(stdId).append(" ");
            query.append(" AND links.ctry_nm_cd = '").append(countryCode).append("' ");
            query.append(" AND (links.stage_std_extl_link_id = links.prnt_stage_std_extl_link_id ");
            query.append(" OR links.locale_cd IN ('").append(locale).append("','").append(DEFAULT_LOCALE).append("'))) ");
            query.append("(SELECT * FROM attachments UNION SELECT * FROM links)");
        }
        if (LOG.isDebugEnabled())
        {
            LOG.debug("ids :::" + stdId);
            LOG.debug("query for staging std ::" + query.toString());
        }
        return query.toString();
    }

    /**
     * @param localeCode This is a String object
     * @param chainCode This is a String object
     * @param countryCode This is a String object
     * @param criteria This is a StandardsSearchCriteria object
     * @return String
     */
    public static String generateSearchQueryForStagingSupportingMaterial(long publishId, String localeCode, String chainCode, String countryCode, StandardsSearchCriteria criteria)
    {
        List<StringBuilder> tables = new ArrayList<StringBuilder>();
        List<StringBuilder> clauses = new ArrayList<StringBuilder>();
        List<StringBuilder> hotelLifeCycleClause = new ArrayList<StringBuilder>();
        List<StringBuilder> specialismClause = new ArrayList<StringBuilder>();
        List<StringBuilder> hotelDeptClause = new ArrayList<StringBuilder>();
        List<StringBuilder> guestJourneyClause = new ArrayList<StringBuilder>();
        List<StringBuilder> hotelLocClause = new ArrayList<StringBuilder>();
        List<String> searchCriteria = criteria.getSearchCriteria();
        List<String> replacedSearchCriteria = criteria.getReplacedSearchCriteria();
        List<String> idCriteria = criteria.getIdSearchCriteria();
        List<String> arlHotelLifeCycle = criteria.getHotelLifecycleForQuery();
        List<String> arlSpecialism = criteria.getSpecialism();
        List<String> arlDeptApplicability = criteria.getDeptApplicability();
        List<String> arlGuestJourney = criteria.getGuestJourney();
        List<String> arlHotelLocations = criteria.getLocHotel();
        String compliance = criteria.getComplianceDeadline();
        String textSearchType = criteria.getTextSearchType();
        boolean hasLinks = criteria.isHasLinks();
        boolean hasImages = criteria.isHasImages();
        boolean hasAttachments = criteria.isHasAttachments();
        boolean hasSOP = criteria.isHasSOP();
        boolean hasTM = criteria.isHasTrainingMaterial();

        StringBuilder sqlQuery1 = new StringBuilder();
        StringBuilder sqlQuery2 = new StringBuilder();
        StringBuilder sqlQuery3 = new StringBuilder();
        StringBuilder flagQuery = new StringBuilder();

        sqlQuery1 = new StringBuilder();
        //Stage Standards
        sqlQuery1.append("WITH STAGING_STD AS (select ps.std_id, ps.prnt_std_id, ps.stage_std_ver_id, ps.stat_desc, ");
        sqlQuery1.append(" ps.disp_order_nbr, ps.title_txt, ps.std_typ, ps.std_desc , CASE ");
        sqlQuery1.append(" WHEN CTRY.std_cmply_deadline_dt > SYSDATE THEN CTRY.std_cmply_deadline_dt ELSE NULL ");
        sqlQuery1.append(" END AS cmply_dt ");
        sqlQuery1.append(" from stage_std ps, STAGE_CTRY_STD CTRY ");
        sqlQuery1.append(" where publish_id = ");
        sqlQuery1.append(publishId);
        sqlQuery1.append(" and ps.STAGE_STD_VER_ID = ctry.STAGE_STD_VER_ID and ctry.ctry_nm_cd = '");
        sqlQuery1.append(countryCode);
        sqlQuery1.append("' ), ");
        //Attachments
        sqlQuery1.append(" ATTACHMENTS AS (SELECT std.STD_ID AS ATTCHSTDID, attch.stage_std_attachment_id AS STDATTCHID,");
        sqlQuery1.append(" attch.attachment_typ AS ATTTYPE,attch.attachment_title_txt AS ATTTITLE,attch.attachment_path_txt AS ATTPATH,attch.prnt_stage_std_attachment_id AS ATTPRNTID,");
        sqlQuery1.append(" attch.CHG_STAT_CD AS ATTSTATCD, attch.LOCALE_CD AS ATTLOCALECD,attch.STAGE_STD_VER_ID as ATTVERID, std.PRNT_STD_ID as ATTSTDPRNTID, ");
        sqlQuery1.append(" null AS EXTSTDID,null AS EXTLINKID,null AS EXTTITLE,null AS EXTURL,null AS EXTPRNTID,null AS EXTSTATCD,null AS EXTLOCALECD, null as EXTVERID, ");
        sqlQuery1.append(" null AS EXTSTDPRNTID FROM stage_std_attachment attch, STAGING_STD std WHERE attch.STAGE_STD_VER_ID = std.STAGE_STD_VER_ID ");
        sqlQuery1.append(" AND  (attch.stage_std_attachment_id = attch.prnt_stage_std_attachment_id or ");
        sqlQuery1.append(" attch.locale_cd in ('");
        sqlQuery1.append(localeCode);
        sqlQuery1.append("','en_GB'))");
        sqlQuery1.append(" AND attch.ctry_nm_cd='");
        sqlQuery1.append(countryCode);
        sqlQuery1.append("'),");
        //Links
        sqlQuery1.append(" LINKS AS (SELECT null AS ATTCHSTDID,null AS STDATTCHID,null AS ATTTYPE,null AS ATTTITLE,null AS ATTPATH,null AS ATTPRNTID,null AS ATTSTATCD,");
        sqlQuery1.append(" null AS ATTLOCALECD, null as ATTVERID, null as ATTSTDPRNTID,");
        sqlQuery1.append(" std.STD_ID AS EXTSTDID,links.STAGE_STD_EXTL_LINK_ID AS EXTLINKID,");
        sqlQuery1.append(" links.link_title_txt AS EXTTITLE,links.url_txt AS EXTURL,links.prnt_stage_std_extl_link_id AS EXTPRNTID, links.CHG_STAT_CD as EXTSTATCD,");
        sqlQuery1.append(" links.LOCALE_CD AS EXTLOCALECD,links.STAGE_STD_VER_ID as EXTVERID, std.PRNT_STD_ID AS EXTSTDPRNTID FROM STAGE_STD_EXTL_LINK links, STAGING_STD std ");
        sqlQuery1.append(" WHERE links.STAGE_STD_VER_ID = std.STAGE_STD_VER_ID ");
        sqlQuery1.append(" AND ( links.STAGE_STD_EXTL_LINK_ID = links.PRNT_STAGE_STD_EXTL_LINK_ID or links.locale_cd in ('");
        sqlQuery1.append(localeCode);
        sqlQuery1.append("','en_GB' ))");
        sqlQuery1.append(" AND links.ctry_nm_cd='");
        sqlQuery1.append(countryCode);
        sqlQuery1.append("'),");
        //Selected standards
        sqlQuery1.append(" selected_std_id AS ( select distinct ps.prnt_std_id AS stage_std_ver_id ");
        sqlQuery1.append(" FROM staging_std ps  ");
        if (!StandardsListUtil.isNullOrBlank(idCriteria))
        {
            sqlQuery1.append(" WHERE ( ");
            for (int i = 0; i < idCriteria.size(); i++)
            {
                sqlQuery1.append(" ps.std_id = ").append(idCriteria.get(i)).append(" ");
                if (i != idCriteria.size() - 1)
                {
                    sqlQuery1.append(" OR ");
                }
            }
            sqlQuery1.append(" ) ");
        }
        sqlQuery1.append("),");
        
        sqlQuery1.append("supporting_material AS ( select * from ATTACHMENTS union select * from links),");
        
        sqlQuery1.append("selected_records AS (");
        sqlQuery1.append("SELECT s.stage_std_ver_id, s.prnt_std_id, s.std_id, s.std_typ, sx.locale_cd,");
        sqlQuery1.append("decode(sx.title_txt, NULL, s.title_txt, sx.title_txt)  AS title_txt,");
        sqlQuery1.append("decode(sx.std_desc, NULL, s.std_desc, sx.std_desc) AS std_desc,s.stat_desc, s.disp_order_nbr,");
        sqlQuery1.append(" s.cmply_dt FROM STAGING_STD S, ");
        sqlQuery1.append("STAGE_STD_XLAT SX, selected_std_id SEL_IDS  ");
        sqlQuery1.append("WHERE ");
        sqlQuery1.append("s.stage_std_ver_id = sx.stage_std_ver_id(+) AND  s.prnt_std_ID  = SEL_IDS.STAGE_STD_VER_ID AND '");
        sqlQuery1.append(localeCode);
        sqlQuery1.append("' = sx.locale_cd(+) ");
        sqlQuery1.append(" ),");
        
        if (!StandardsListUtil.isNullOrBlank(searchCriteria))
        {
            sqlQuery1.append(" IMAGESEARCH AS ( SELECT im.STAGE_STD_VER_ID,  im.image_title_txt ");
            sqlQuery1.append("FROM stage_std_image im, staging_std std ");
            sqlQuery1.append(" WHERE  std.STAGE_STD_VER_ID = im.STAGE_STD_VER_ID   ");
            sqlQuery1.append(" AND im.locale_cd in ('");
            sqlQuery1.append(localeCode);
            sqlQuery1.append("', 'en_GB' ) ");
            sqlQuery1.append(" AND im.CTRY_NM_CD='");
            sqlQuery1.append(countryCode);
            sqlQuery1.append("' ");
            if (SEARCH_OPTION_ANY.equals(textSearchType))
            {
                sqlQuery1.append("AND (");
                sqlQuery1.append(getWhereClauseForImageAnyWords(searchCriteria, COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END));
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
                {
                    sqlQuery1.append("OR ");
                    sqlQuery1.append(getWhereClauseForImageAnyWords(replacedSearchCriteria, COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END));
                }
                sqlQuery1.append(") ");
            }
            else if (SEARCH_OPTION_EXACT.equals(textSearchType))
            {
                sqlQuery1.append("AND (");
                sqlQuery1.append(getWhereClauseForImageExactWords(searchCriteria, COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END));
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
                {
                    sqlQuery1.append("OR ");
                    sqlQuery1.append(getWhereClauseForImageExactWords(replacedSearchCriteria, COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END));
                }
                sqlQuery1.append(") ");
            }
            else
            {
                sqlQuery1.append("AND (");
                sqlQuery1.append(getWhereClauseForImageAllWords(searchCriteria, COLUMN_TYPE_STRING_MATCH_START, COLUMN_TYPE_STRING_MATCH_END));
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
                {
                    sqlQuery1.append("OR ");
                    sqlQuery1.append(getWhereClauseForImageAllWords(replacedSearchCriteria, COLUMN_TYPE_STRING_MATCH_START, COLUMN_TYPE_STRING_MATCH_END));
                }
                sqlQuery1.append(") ");
            }
            
            sqlQuery1.append("), ");
        }

        sqlQuery1.append(" direct_match AS ( SELECT distinct ps.prnt_std_id, ATTCHSTDID, STDATTCHID, ATTTYPE, ATTTITLE, ATTPATH, ATTPRNTID, ATTSTATCD, ATTLOCALECD, EXTSTDID, ");
        sqlQuery1.append("EXTLINKID, EXTTITLE, EXTURL, EXTPRNTID,  EXTSTATCD,  EXTLOCALECD ,  ps.cmply_dt");
        sqlQuery1.append("    FROM   selected_records PS, supporting_material sm ");
        if (!StandardsListUtil.isNullOrBlank(searchCriteria))
        {
            sqlQuery1.append(", IMAGESEARCH IMGSRCH");
        }
        sqlQuery3 = new StringBuilder(" WHERE (PS.PRNT_STD_ID = sm.ATTSTDPRNTID OR PS.PRNT_STD_ID   = sm.EXTSTDPRNTID) AND (ps.std_id = attchstdid or ps.std_id = extstdid)  ");
        if (!StandardsListUtil.isNullOrBlank(searchCriteria))
        {
            sqlQuery3.append(" AND ps.STAGE_STD_VER_ID = IMGSRCH.STAGE_STD_VER_ID(+)");
        }
        sqlQuery2 = new StringBuilder(" )( SELECT * FROM direct_match ");
        if (!criteria.isEmpty()) {
	        sqlQuery2
	                .append(" UNION select distinct  ps.prnt_std_id, ATTCHSTDID, STDATTCHID, ATTTYPE, ATTTITLE, ATTPATH, ATTPRNTID, ATTSTATCD, ATTLOCALECD, EXTSTDID, EXTLINKID, EXTTITLE,");
	        sqlQuery2.append("EXTURL, EXTPRNTID,  EXTSTATCD,  EXTLOCALECD ,  ps.cmply_dt ");
	        sqlQuery2.append(" FROM  selected_records PS, supporting_material sm  ");
	        sqlQuery2.append(" WHERE (ps.stage_std_ver_id = sm.attverid  or ps.stage_std_ver_id = sm.extverid)  AND  ");
	        sqlQuery2.append("ps.prnt_std_id IN (SELECT distinct prnt_std_id FROM direct_match) ");
        }
        sqlQuery2.append(")");
        if (!StandardsListUtil.isNullOrBlank(searchCriteria))
        {
            
            if (SEARCH_OPTION_ANY.equals(textSearchType) || SEARCH_OPTION_EXACT.equals(textSearchType))
            {
                StringBuilder search = new StringBuilder(" AND ( ");
                search.append(" (ps.std_typ = 'GDLN' AND ");
                search.append(getWhereClauseForExactWords(searchCriteria, "upper(ps.std_desc)",
                        COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                search.append(" ) OR ");
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
                {
                    search.append(" (ps.std_typ = 'GDLN' AND ");
                    search.append(getWhereClauseForExactWords(replacedSearchCriteria, "upper(ps.std_desc)",
                            COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                    search.append(" ) OR ");
                }
                
                search.append(" (ps.std_typ != 'GDLN' AND ");
                search.append(getWhereClauseForExactWords(searchCriteria, "upper(ps.title_txt)",
                        COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                search.append(" ) ");
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
                {
                    search.append(" OR (ps.std_typ != 'GDLN' AND ");
                    search.append(getWhereClauseForExactWords(replacedSearchCriteria, "upper(ps.title_txt)",
                            COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                    search.append(" ) ");
                }
                search.append(" OR ps.stage_std_ver_id = imgsrch.stage_std_ver_id) ");

                sqlQuery3.append(search);
            }
            else
            {
                StringBuilder search = new StringBuilder(" AND ( ");
                search.append(" (ps.std_typ = 'GDLN' AND ");
                search.append(getWhereClauseForAllWords(searchCriteria, "upper(ps.std_desc)",
                        COLUMN_TYPE_STRING_MATCH_START, COLUMN_TYPE_STRING_MATCH_END, true));
                search.append(" ) OR ");
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
                {
                    search.append(" (ps.std_typ = 'GDLN' AND ");
                    search.append(getWhereClauseForAllWords(replacedSearchCriteria, "upper(ps.std_desc)",
                            COLUMN_TYPE_STRING_MATCH_START, COLUMN_TYPE_STRING_MATCH_END, true));
                    search.append(" ) OR ");
                }
                 
                search.append(" (ps.std_typ != 'GDLN' AND ");
                search.append(getWhereClauseForAllWords(searchCriteria, "upper(ps.title_txt)",
                        COLUMN_TYPE_STRING_MATCH_START, COLUMN_TYPE_STRING_MATCH_END, true));
                search.append(" ) ");
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
                {
                    search.append(" OR (ps.std_typ != 'GDLN' AND ");
                    search.append(getWhereClauseForAllWords(replacedSearchCriteria, "upper(ps.title_txt)",
                            COLUMN_TYPE_STRING_MATCH_START, COLUMN_TYPE_STRING_MATCH_END, true));
                    search.append(" ) ");
                }
                search.append(" OR ps.stage_std_ver_id = imgsrch.stage_std_ver_id) ");
                
                sqlQuery3.append(search);
            }
        }

        if (!StandardsListUtil.isNullOrBlank(arlHotelLifeCycle) || !StandardsListUtil.isNullOrBlank(arlSpecialism) || 
        		!StandardsListUtil.isNullOrBlank(arlDeptApplicability) || !StandardsListUtil.isNullOrBlank(arlGuestJourney)
                || !StandardsListUtil.isNullOrBlank(arlHotelLocations))
        {
            String deptQuery = "";
            String guestQuery = "";
            String locnQuery = "";
            String hotelLifeCycleQuery = "";
            String specialismQuery = "";
            flagQuery = new StringBuilder(" PS.STAGE_STD_VER_ID   IN ");
            flagQuery.append(" (select pubs.STAGE_STD_VER_ID from stage_flag_std pfs, staging_std pubs ");
            flagQuery
                    .append(" where pubs.STAGE_STD_VER_ID =  pfs.STAGE_STD_VER_ID ");
           
            if (!StandardsListUtil.isNullOrBlank(arlHotelLifeCycle))
            {
                hotelLifeCycleClause.add(getWhereClause(arlHotelLifeCycle, "pfs.flag_catgy_id", COLUMN_TYPE_NUMBER_START,
                        COLUMN_TYPE_NUMBER_END));
                 hotelLifeCycleQuery = buildFlagsQuery(flagQuery, hotelLifeCycleClause);
                clauses.add(new StringBuilder(hotelLifeCycleQuery));
            }
            
            if (!StandardsListUtil.isNullOrBlank(arlSpecialism))
            {
                specialismClause.add(getWhereClause(arlSpecialism, "pfs.flag_catgy_id", COLUMN_TYPE_NUMBER_START,
                        COLUMN_TYPE_NUMBER_END));
                 specialismQuery = buildFlagsQuery(flagQuery, specialismClause);
                clauses.add(new StringBuilder(specialismQuery));
            }
            
            if (!StandardsListUtil.isNullOrBlank(arlDeptApplicability))
            {
                hotelDeptClause.add(getWhereClause(arlDeptApplicability, "pfs.flag_catgy_id", COLUMN_TYPE_NUMBER_START,
                        COLUMN_TYPE_NUMBER_END));
                deptQuery = buildFlagsQuery(flagQuery, hotelDeptClause);
                clauses.add(new StringBuilder(deptQuery));
            }
            if (!StandardsListUtil.isNullOrBlank(arlGuestJourney))
            {
                guestJourneyClause.add(getWhereClause(arlGuestJourney, "pfs.flag_catgy_id", COLUMN_TYPE_NUMBER_START,
                        COLUMN_TYPE_NUMBER_END));
                guestQuery = buildFlagsQuery(flagQuery, guestJourneyClause);
                clauses.add(new StringBuilder(guestQuery));
            }
            if (!StandardsListUtil.isNullOrBlank(arlHotelLocations))
            {
                hotelLocClause.add(getWhereClause(arlHotelLocations, "pfs.flag_catgy_id", COLUMN_TYPE_NUMBER_START,
                        COLUMN_TYPE_NUMBER_END));
                locnQuery = buildFlagsQuery(flagQuery, hotelLocClause);
                clauses.add(new StringBuilder(locnQuery));
            }
        }

        if (hasLinks)
        {
            clauses.add(new StringBuilder("PS.STAGE_STD_VER_ID = sm.EXTVERID"));
        }
        if (hasAttachments || hasSOP || hasTM)
        {
            clauses.add(new StringBuilder("PS.STAGE_STD_VER_ID = sm.ATTVERID"));
        }
        if (hasImages)
        {
            tables.add(new StringBuilder("STAGE_STD_IMAGE psi"));
            clauses.add(new StringBuilder("(psi.stage_std_image_id = psi.prnt_stage_std_image_id or psi.locale_cd in ('")
                    .append(localeCode)
                    .append("','en_GB' )) AND (ps.STAGE_STD_VER_ID = psi.STAGE_STD_VER_ID or ps.prnt_std_id = ")
                    .append("(select tps.prnt_std_id from staging_std tps where tps.stage_std_ver_id = psi.stage_std_ver_id ")
                    .append(")) "));
        }
        if (hasSOP)
        {

            clauses.add(new StringBuilder("sm.ATTTYPE = 'SOP'"));
        }
        if (hasTM)
        {
            clauses.add(new StringBuilder("( sm.ATTTYPE = 'INTNL_TRAINING' or sm.ATTTYPE = 'HTL_TRAINING' )"));
        }
        if (compliance != null && compliance.trim().length() != 0)
        {
            tables.add(new StringBuilder("STAGE_CTRY_STD scc"));
            clauses.add(new StringBuilder("ps.STAGE_STD_VER_ID = scc.STAGE_STD_VER_ID"));
            if ("0d".equals(compliance))
            {
                clauses.add(new StringBuilder("ps.cmply_dt between to_date('").append(StandardsListUtil.now())
                        .append("','DD-MON-YY') and ").append("to_date('").append(StandardsListUtil.getComplianceDeadline("0d"))
                        .append("','DD-MON-YY')"));
            }
            if ("7d".equals(compliance))
            {
                clauses.add(new StringBuilder("ps.cmply_dt between  to_date('").append(StandardsListUtil.now())
                        .append("','DD-MON-YY') and ").append("to_date('").append(StandardsListUtil.getComplianceDeadline("7d"))
                        .append("','DD-MON-YY')"));
            }
            if ("1m".equals(compliance))
            {
                clauses.add(new StringBuilder("ps.cmply_dt between  to_date('").append(StandardsListUtil.now())
                        .append("','DD-MON-YY') and ").append("to_date('").append(StandardsListUtil.getComplianceDeadline("1m"))
                        .append("','DD-MON-YY')"));
            }
            if ("3m".equals(compliance))
            {
                clauses.add(new StringBuilder("ps.cmply_dt between  to_date('").append(StandardsListUtil.now())
                        .append("','DD-MON-YY') and ").append("to_date('").append(StandardsListUtil.getComplianceDeadline("3m"))
                        .append("','DD-MON-YY')"));
            }
            if ("6m".equals(compliance))
            {
                clauses.add(new StringBuilder("ps.cmply_dt between  to_date('").append(StandardsListUtil.now())
                        .append("','DD-MON-YY') and ").append("to_date('").append(StandardsListUtil.getComplianceDeadline("6m"))
                        .append("','DD-MON-YY')"));
            }
            if ("12m".equals(compliance))
            {
                clauses.add(new StringBuilder("ps.cmply_dt between  to_date('").append(StandardsListUtil.now())
                        .append("','DD-MON-YY') and ").append("to_date('").append(StandardsListUtil.getComplianceDeadline("12m"))
                        .append("','DD-MON-YY')"));
            }
            if ("12m+".equals(compliance))
            {
                clauses.add(new StringBuilder("ps.cmply_dt >=  to_date('").append(StandardsListUtil.getComplianceDeadline("12m+"))
                        .append("','DD-MON-YY')"));
            }
        }
        String query = buildQuery(sqlQuery1, sqlQuery2, sqlQuery3, tables, clauses);
        if (LOG.isDebugEnabled())
        {
            LOG.debug("query ------ " + query);
        }
        return query;
    }

    /** used to display standards on the STAGING search standards screen and to generate PDFs.
     * 
     * @param publishId publication id
     * @param localeCode This is a String object
     * @param countryCode This is a String object
     * @param criteria This is a StandardsSearchCriteria object
     * @return String
     */
    public static String generateSearchQueryStaging(long publishId, String localeCode, String countryCode, StandardsSearchCriteria criteria)
    {
        List<StringBuilder> tables = new ArrayList<StringBuilder>();
        List<StringBuilder> clauses = new ArrayList<StringBuilder>();
        List<StringBuilder> hotelLifeCycleClause = new ArrayList<StringBuilder>();
        List<StringBuilder> specialismClause = new ArrayList<StringBuilder>();
        List<StringBuilder> hotelDeptClause = new ArrayList<StringBuilder>();
        List<StringBuilder> guestJourneyClause = new ArrayList<StringBuilder>();
        List<StringBuilder> hotelLocClause = new ArrayList<StringBuilder>();
        List<String> searchCriteria = criteria.getSearchCriteria();
        List<String> replacedSearchCriteria = criteria.getReplacedSearchCriteria();
        List<String> idCriteria = criteria.getIdSearchCriteria();
        List<String> arlHotelLifeCycle = criteria.getHotelLifecycleForQuery();
        List<String> arlSpecialism = criteria.getSpecialism();
        List<String> arlDeptApplicability = criteria.getDeptApplicability();
        List<String> arlHotelLocations = criteria.getLocHotel();
        List<String> arlGuestJourney = criteria.getGuestJourney();
        String compliance = criteria.getComplianceDeadline();
        String textSearchType = criteria.getTextSearchType();
        boolean hasLinks = criteria.isHasLinks();
        boolean hasImages = criteria.isHasImages();
        boolean hasAttachments = criteria.isHasAttachments();
        boolean hasSOP = criteria.isHasSOP();
        boolean hasTM = criteria.isHasTrainingMaterial();

        StringBuilder sqlQuery1 = new StringBuilder();
        StringBuilder sqlQuery2 = new StringBuilder();
        StringBuilder sqlQuery3 = new StringBuilder();
        StringBuilder flagQuery = new StringBuilder();

        sqlQuery1 = new StringBuilder("SELECT * FROM ( WITH ");

        sqlQuery1.append("TAXONOMY AS (");
        if (DEFAULT_LOCALE.equals(localeCode))
        {
            sqlQuery1.append(" SELECT TAX.INDX_ORDER, TAX.STAGE_TAXONOMY_ID, TAX.PRNT_STAGE_TAXONOMY_ID, TAX.LVL, ");
            sqlQuery1.append(" TAX.HIER_LVL_NBR, TAX.publish_id, TAX.TITLE_TXT, TAX.PATH, TAX.TAXONOMY_DESC ");
            sqlQuery1.append(" FROM (SELECT ROWNUM AS INDX_ORDER, T.STAGE_TAXONOMY_ID, T.PRNT_STAGE_TAXOMOMY_ID AS PRNT_STAGE_TAXONOMY_ID, ");
            sqlQuery1.append(" (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, T.publish_id, ");
            sqlQuery1.append("  T.TAXONOMY_DESC, T.TITLE_TXT, ");
            sqlQuery1.append("  SUBSTR(SYS_CONNECT_BY_PATH(t.title_txt, ' &#8594; '), 31) AS PATH ");
            sqlQuery1.append("  FROM STAGE_TAXONOMY T ");
            sqlQuery1.append("  WHERE T.publish_id = ").append(publishId);
            sqlQuery1.append("  START WITH T.TAXONOMY_ID = 1 ");
            sqlQuery1.append("  CONNECT BY NOCYCLE PRIOR T.STAGE_TAXONOMY_ID = T.PRNT_STAGE_TAXOMOMY_ID ) TAX ), ");
        }
        else
        {
            sqlQuery1.append(" SELECT TAX_DEF.INDX_ORDER, TAX_DEF.STAGE_TAXONOMY_ID, TAX_DEF.PRNT_STAGE_TAXONOMY_ID, ");
            sqlQuery1.append(" TAX_DEF.LVL, TAX_DEF.HIER_LVL_NBR, TAX_DEF.publish_id, ");
            sqlQuery1.append(" decode(TAX_PREF.TITLE_TXT, NULL, TAX_DEF.TITLE_TXT, TAX_PREF.TITLE_TXT) AS TITLE_TXT, ");
            sqlQuery1.append(" decode(TAX_PREF.TITLE_TXT, NULL, TAX_DEF.PATH, TAX_PREF.PATH) AS PATH, ");
            sqlQuery1.append(" decode(TAX_PREF.TAXONOMY_DESC, NULL, TAX_DEF.TAXONOMY_DESC, TAX_PREF.TAXONOMY_DESC) AS TAXONOMY_DESC ");
            sqlQuery1.append(" FROM (SELECT ROWNUM AS INDX_ORDER, T.STAGE_TAXONOMY_ID, T.PRNT_STAGE_TAXOMOMY_ID AS PRNT_STAGE_TAXONOMY_ID, ");
            sqlQuery1.append("        (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, T.publish_id, ");
            sqlQuery1.append("        (SELECT DECODE(ptx.TAXONOMY_DESC, NULL, t.TAXONOMY_DESC, 'No Translation Found', t.TAXONOMY_DESC, '', t.TAXONOMY_DESC, ptx.TAXONOMY_DESC) ");
            sqlQuery1.append("        FROM STAGE_TAXONOMY_XLAT ptx ");
            sqlQuery1.append("        WHERE t.stage_taxonomy_id = ptx.stage_taxonomy_id(+) ");
            sqlQuery1.append("        AND ptx.locale_cd = '").append(localeCode).append("' ) AS TAXONOMY_DESC, ");
            sqlQuery1.append(" (SELECT DECODE(ptx.title_txt, NULL, t.title_txt, 'No Translation Found', t.title_txt, '', t.title_txt, ptx.title_txt) ");
            sqlQuery1.append(" FROM STAGE_TAXONOMY_XLAT ptx ");
            sqlQuery1.append(" WHERE t.stage_taxonomy_id   = ptx.stage_taxonomy_id(+) ");
            sqlQuery1.append(" AND ptx.locale_cd = '").append(localeCode).append("' ) AS TITLE_TXT, ");
            sqlQuery1.append(" SUBSTR(SYS_CONNECT_BY_PATH(   (SELECT DECODE(ptx.title_txt, NULL, t.title_txt, 'No Translation Found', t.title_txt, '', t.title_txt, ptx.title_txt) AS title ");
            sqlQuery1.append("        FROM STAGE_TAXONOMY_XLAT ptx ");
            sqlQuery1.append("        WHERE t.stage_taxonomy_id   = ptx.stage_taxonomy_id(+) ");
            sqlQuery1.append("        AND ptx.locale_cd = '").append(localeCode).append("' ) , ' &#8594; '),  19) AS PATH ");
            sqlQuery1.append("FROM STAGE_TAXONOMY T ");
            sqlQuery1.append("WHERE T.publish_id = ").append(publishId).append(" ");
            sqlQuery1.append("START WITH T.TAXONOMY_ID = 1 CONNECT BY NOCYCLE PRIOR T.STAGE_TAXONOMY_ID = T.PRNT_STAGE_TAXOMOMY_ID ) TAX_PREF, ");
            sqlQuery1.append("    (SELECT ROWNUM AS INDX_ORDER, T.STAGE_TAXONOMY_ID, T.PRNT_STAGE_TAXOMOMY_ID AS PRNT_STAGE_TAXONOMY_ID, ");
            sqlQuery1.append("    (LEVEL - 1) AS LVL, T.HIER_LVL_NBR, T.publish_id, ");
            sqlQuery1.append("    T.TAXONOMY_DESC, T.TITLE_TXT, SUBSTR(SYS_CONNECT_BY_PATH(t.title_txt , ' &#8594; '), 31) AS PATH ");
            sqlQuery1.append("FROM STAGE_TAXONOMY T ");
            sqlQuery1.append("WHERE T.publish_id = ").append(publishId).append(" ");
            sqlQuery1.append("START WITH T.TAXONOMY_ID = 1 CONNECT BY NOCYCLE PRIOR T.STAGE_TAXONOMY_ID = T.PRNT_STAGE_TAXOMOMY_ID ) TAX_DEF ");
            sqlQuery1.append("WHERE TAX_DEF.STAGE_TAXONOMY_ID = TAX_PREF.STAGE_TAXONOMY_ID ), ");
        }
        
        sqlQuery1.append(" SEL_PUBLISH AS (SELECT PUBLISH_ID, TO_DATE(PUBLISH_DT, 'DD-MON-YYYY') AS PUBLISH_DT FROM PUBLISH WHERE PUBLISH_ID=").append(publishId).append("),");
        
        sqlQuery1.append(" PUB_STD AS (SELECT s.stage_std_ver_id, s.prnt_std_id, s.std_id, s.std_typ, sx.locale_cd, ");
        sqlQuery1.append(" CASE WHEN (TO_DATE(pcs.std_cmply_deadline_dt, 'DD-MON-YYYY') > sp.PUBLISH_DT AND pcs.std_cmply_deadline_dt > SYSDATE)");
        sqlQuery1.append(" THEN pcs.std_cmply_deadline_dt ELSE NULL END AS cmply_dt,");
        sqlQuery1.append(" DECODE(sx.title_txt, NULL, s.title_txt, sx.title_txt) AS title_txt, ");
        sqlQuery1.append(" DECODE(sx.std_desc, NULL, s.std_desc, sx.std_desc) AS std_desc, ");
        sqlQuery1.append(" pcs.publish_stat_cd  AS stat_desc, ");
        sqlQuery1.append(" pcs.disp_order_nbr, pcs.ctry_nm_cd, pcs.expr_dt ");
        sqlQuery1.append(" FROM SEL_PUBLISH sp, STAGE_STD S, STAGE_STD_XLAT SX, STAGE_CTRY_STD pcs ");
        sqlQuery1.append(" WHERE sp.publish_id = s.publish_id");
        sqlQuery1.append(" AND s.stage_std_ver_id = sx.stage_std_ver_id(+) ");
        sqlQuery1.append(" AND '").append(localeCode).append("' = sx.locale_cd(+) ");
        sqlQuery1.append(" AND s.stage_std_ver_id = pcs.stage_std_ver_id ");
        sqlQuery1.append(" AND pcs.ctry_nm_cd = '").append(countryCode).append("'), ");
        
        if (!StandardsListUtil.isNullOrBlank(idCriteria))
        {
            sqlQuery1.append("SELECTED_STD_REC AS (SELECT stage_std_ver_id, prnt_std_id, std_id, std_typ, locale_cd, cmply_dt, title_txt, std_desc, ");
            sqlQuery1.append(" stat_desc, disp_order_nbr, ctry_nm_cd, expr_dt ");
            sqlQuery1.append(" FROM PUB_STD ");
            sqlQuery1.append(" WHERE prnt_std_id IN ");
            sqlQuery1.append("(SELECT DISTINCT ps.prnt_std_id FROM PUB_STD ps ");
            sqlQuery1.append(" WHERE ( ");
            for (int i = 0; i < idCriteria.size(); i++)
            {
                sqlQuery1.append(" ps.std_id = ").append(idCriteria.get(i)).append(" ");
                if (i != idCriteria.size() - 1)
                {
                    sqlQuery1.append(" OR ");
                }
            }
            sqlQuery1.append(" ))), ");
        }
        
        sqlQuery1.append("ATTACHMENTS AS (SELECT attch.stage_std_ver_id,  'yes' AS attachment_exists, ");
        sqlQuery1.append(" LISTAGG(attch.attachment_typ || ':::' || attch.attachment_title_txt || ':::' || attch.attachment_path_txt || ':::' || attch.CHG_STAT_CD, ';;; ') ");
        sqlQuery1.append(" WITHIN GROUP (ORDER BY attch.stage_std_ver_id, attch.CHG_STAT_CD) AS ATTACH_LST ");
        sqlQuery1.append(" FROM stage_std_attachment attch, PUB_STD std  ");
        sqlQuery1.append(" WHERE attch.stage_std_ver_id = std.stage_std_ver_id ");
        sqlQuery1.append(" AND attch.locale_cd in ('");
        sqlQuery1.append(localeCode);
        sqlQuery1.append("', 'en_GB')");
        sqlQuery1.append(" AND attch.CTRY_NM_CD='");
        sqlQuery1.append(countryCode);
        sqlQuery1.append("' GROUP BY attch.stage_std_ver_id), ");
        
        sqlQuery1.append("LINKS AS (SELECT links.stage_std_ver_id, 'yes' AS link_exists, ");
        sqlQuery1.append(" LISTAGG(links.link_title_txt || ':::' || links.url_txt || ':::' ||  links.chg_stat_cd, ';;; ') ");
        sqlQuery1.append(" WITHIN GROUP (ORDER BY links.stage_std_ver_id) AS LINK_LST ");
        sqlQuery1.append(" FROM STAGE_STD_EXTL_LINK links, PUB_STD std  ");
        sqlQuery1.append(" WHERE links.stage_std_ver_id = std.stage_std_ver_id ");
        sqlQuery1.append(" AND links.locale_cd in ('");
        sqlQuery1.append(localeCode);
        sqlQuery1.append("', 'en_GB')");
        sqlQuery1.append(" AND links.ctry_nm_cd = '");
        sqlQuery1.append(countryCode);
        sqlQuery1.append("' GROUP BY links.stage_std_ver_id), ");
        
        sqlQuery1.append("IMAGES AS (SELECT img.stage_std_ver_id, 'yes' AS img_exists, LISTAGG(img.image_identifier || ':::' || img.image_title_txt || ':::' || img.chg_stat_cd || ';;; ') ");
        sqlQuery1.append(" WITHIN GROUP (ORDER BY img.stage_std_ver_id,img.chg_stat_cd) AS IMG_LST_ID "); 
        sqlQuery1.append(" FROM STAGE_STD_IMAGE img, PUB_STD std ");
        sqlQuery1.append(" WHERE  std.stage_std_ver_id = img.stage_std_ver_id ");
        sqlQuery1.append(" AND img.locale_cd in ('");
        sqlQuery1.append(localeCode);
        sqlQuery1.append("', 'en_GB')");
        sqlQuery1.append(" AND img.CTRY_NM_CD='");
        sqlQuery1.append(countryCode);
        sqlQuery1.append("' GROUP BY img.stage_std_ver_id), ");//, img.CHG_STAT_CD
        if (!StandardsListUtil.isNullOrBlank(searchCriteria))
        {
            sqlQuery1.append(" IMAGESEARCH AS (SELECT im.stage_std_ver_id, im.image_title_txt ");
            sqlQuery1.append(" FROM stage_std_image im, pub_std std ");
            sqlQuery1.append(" WHERE std.stage_std_ver_id = im.stage_std_ver_id ");
            sqlQuery1.append(" AND im.locale_cd IN ('");
            sqlQuery1.append(localeCode);
            sqlQuery1.append("', 'en_GB')");
            sqlQuery1.append(" AND im.ctry_nm_cd = '");
            sqlQuery1.append(countryCode);
            sqlQuery1.append("' ");
            if (SEARCH_OPTION_ANY.equals(textSearchType))
            {
                sqlQuery1.append("AND (");
                sqlQuery1.append(getWhereClauseForImageAnyWords(searchCriteria, COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END));
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
                {
                    sqlQuery1.append("OR ");
                    sqlQuery1.append(getWhereClauseForImageAnyWords(replacedSearchCriteria, COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END));
                }
                sqlQuery1.append(") ");
            }
            else if (SEARCH_OPTION_EXACT.equals(textSearchType))
            {
                sqlQuery1.append("AND (");
                sqlQuery1.append(getWhereClauseForImageExactWords(searchCriteria, COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END));
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
                {
                    sqlQuery1.append("OR ");
                    sqlQuery1.append(getWhereClauseForImageExactWords(replacedSearchCriteria, COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END));
                }
                sqlQuery1.append(") ");
            }
            else
            {
                sqlQuery1.append("AND (");
                sqlQuery1.append(getWhereClauseForImageAllWords(searchCriteria, COLUMN_TYPE_STRING_MATCH_START, COLUMN_TYPE_STRING_MATCH_END));
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
                {
                    sqlQuery1.append("OR ");
                    sqlQuery1.append(getWhereClauseForImageAllWords(replacedSearchCriteria, COLUMN_TYPE_STRING_MATCH_START, COLUMN_TYPE_STRING_MATCH_END));
                }
                sqlQuery1.append(") ");
            }
            
            sqlQuery1.append("), ");
        }
        // ************************Standard Tag Search starts****************************************// 
        if (!StandardsListUtil.isNullOrBlank(searchCriteria))
        {
        	
            sqlQuery1.append(" TAGSEARCH AS (SELECT stdTag.STD_ID,stdTag.TAG_TXT");
            sqlQuery1.append(" FROM STD_TAG stdTag, pub_std std ");
            sqlQuery1.append(" WHERE std.std_id = stdTag.STD_ID ");
            if (SEARCH_OPTION_ANY.equals(textSearchType))
            {
                sqlQuery1.append("AND (");
                sqlQuery1.append(getWhereClauseForTagsAnyWords(searchCriteria, COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END));
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
                {
                    sqlQuery1.append("OR ");
                    sqlQuery1.append(getWhereClauseForTagsAnyWords(replacedSearchCriteria, COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END));
                }
                sqlQuery1.append(") ");
            }
            else if (SEARCH_OPTION_EXACT.equals(textSearchType))
            {
                sqlQuery1.append("AND (");
                sqlQuery1.append(getWhereClauseForTagsExactWords(searchCriteria, COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END));
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
                {
                    sqlQuery1.append("OR ");
                    sqlQuery1.append(getWhereClauseForTagsExactWords(replacedSearchCriteria, COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END));
                }
                sqlQuery1.append(") ");
            }
            else
            {
                sqlQuery1.append("AND (");
                sqlQuery1.append(getWhereClauseForTagsAllWords(searchCriteria, COLUMN_TYPE_STRING_MATCH_START, COLUMN_TYPE_STRING_MATCH_END));
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
                {
                    sqlQuery1.append("OR ");
                    sqlQuery1.append(getWhereClauseForTagsAllWords(replacedSearchCriteria, COLUMN_TYPE_STRING_MATCH_START, COLUMN_TYPE_STRING_MATCH_END));
                }
                sqlQuery1.append(") ");
            }
            
            sqlQuery1.append("), ");
        }
        // ************************Standard Tag Search Ends****************************************// 
        sqlQuery1.append("STD_XREF AS (SELECT xref.referring_std_ver_id AS referring_std_id, " );
        sqlQuery1.append(" LISTAGG((SELECT std_id FROM pub_std WHERE stage_std_ver_id = xref.referenced_std_ver_id), ', ') ");
        sqlQuery1.append(" WITHIN GROUP (ORDER BY xref.disp_order_nbr, xref.referenced_std_ver_id) AS XREF_LST_STD_ID ");
        sqlQuery1.append(" FROM PUB_STD std, stage_std_xref xref, stage_ctry_std pctry ");
        sqlQuery1.append(" WHERE std.stage_std_ver_id = xref.referenced_std_ver_id and std.stage_std_ver_id = pctry.stage_std_ver_id");
        sqlQuery1.append(" AND pctry.ctry_nm_cd = '").append(countryCode).append("' ");
        sqlQuery1.append(" GROUP BY xref.referring_std_ver_id ), ");

        sqlQuery1.append("STD_FLAG AS (SELECT pfs.stage_std_ver_id, " ).append("LISTAGG(pfs.flag_catgy_Id, ', ') ");
        sqlQuery1.append(" WITHIN GROUP (ORDER BY  pfs.stage_std_ver_id) AS FLAG_ID");
        sqlQuery1.append(" FROM PUB_STD pubs, stage_flag_std pfs ");
        sqlQuery1.append(" WHERE pubs.stage_std_ver_id = pfs.stage_std_ver_id ");
        sqlQuery1.append(" GROUP BY pfs.stage_std_ver_id ), ");
        
        sqlQuery1.append("DIRECT_MATCH AS (SELECT tax.indx_order, tax.stage_taxonomy_id, tax.prnt_stage_taxonomy_id,  tax.lvl, tax.hier_lvl_nbr, tax.publish_id, tax.path, tax.taxonomy_desc, ");
        sqlQuery1.append(" ps.stage_std_ver_id, ps.prnt_std_id,  ps.std_id, ps.std_typ, ps.title_txt, ps.std_desc, ps.stat_desc, att.attachment_exists, ");
        sqlQuery1.append(" img.img_exists, 'NO_CHANGE' as img_stat_cd, lnk.link_exists, ps.cmply_dt, "); //img.chg_stat_cd as img_stat_cd,
        sqlQuery1.append(" ps.disp_order_nbr, img.img_lst_id, att.attach_lst, lnk.link_lst, xref.xref_lst_std_id, tax.title_txt as index_title, ps.expr_dt, flg.flag_id ");
        
        if (!StandardsListUtil.isNullOrBlank(searchCriteria))
        {
            sqlQuery1.append(", 1 match_rec "); 
            sqlQuery1.append(", decode(imgsrch.stage_std_ver_id, NULL, '', 'IMG_MATCH') match_img ");
        } else
        {
            sqlQuery1.append(", 0 match_rec, '' match_img ");
        }
        sqlQuery1.append(" FROM TAXONOMY TAX, STAGE_TAXONOMY_STD PTS,  ");
        if (!StandardsListUtil.isNullOrBlank(searchCriteria))
        {
            sqlQuery1.append(" TAGSEARCH TAGSRCH, ");
            
        }
        if (!StandardsListUtil.isNullOrBlank(idCriteria))
        {
            sqlQuery1.append(" SELECTED_STD_REC PS, ");
        }
        else
        {
            sqlQuery1.append(" PUB_STD PS, ");
        }
        sqlQuery1.append("ATTACHMENTS ATT, IMAGES IMG, LINKS LNK, STD_XREF XREF, STD_FLAG FLG ");
        if (!StandardsListUtil.isNullOrBlank(searchCriteria))
        {
            sqlQuery1.append(", IMAGESEARCH IMGSRCH ");
        }

        sqlQuery3 = new StringBuilder(" WHERE pts.taxonomy_id = tax.stage_taxonomy_id ");
        sqlQuery3.append(" AND (pts.stage_std_ver_id = ps.prnt_std_id) ");
//        sqlQuery3.append(" AND (pts.stage_std_ver_id = ps.stage_std_ver_id OR pts.stage_std_ver_id = ps.prnt_std_id) ");
        sqlQuery3.append(" AND ps.stage_std_ver_id = att.stage_std_ver_id(+) AND ps.stage_std_ver_id = lnk.stage_std_ver_id(+) ");
        sqlQuery3.append(" AND ps.stage_std_ver_id = img.stage_std_ver_id(+) ");
        if (!StandardsListUtil.isNullOrBlank(searchCriteria))
        {
            sqlQuery3.append("AND ps.stage_std_ver_id = imgsrch.stage_std_ver_id(+)");
        }
        sqlQuery3.append(" AND ps.stage_std_ver_id = xref.referring_std_id(+)  ");
        sqlQuery3.append(" AND ps.stage_std_ver_id = flg.stage_std_ver_id(+)  ");
        if (!StandardsListUtil.isNullOrBlank(searchCriteria))
        {
        sqlQuery3.append(" AND  ps.std_id = TAGSRCH.STD_ID(+) ");
        }

        sqlQuery2 = new StringBuilder(" )( SELECT * FROM direct_match ");
        if (!criteria.isEmpty())
        {
            sqlQuery2.append(" UNION ");
            sqlQuery2.append(" SELECT tax.indx_order, tax.stage_taxonomy_id, tax.prnt_stage_taxonomy_id, tax.lvl, tax.hier_lvl_nbr, tax.publish_id, tax.path, tax.taxonomy_desc, ");
            sqlQuery2.append(" ps.stage_std_ver_id, ps.prnt_std_id, ps.std_id, ps.std_typ, ps.title_txt, ps.std_desc, ps.stat_desc, att.attachment_exists, ");
            sqlQuery2.append(" img.img_exists, 'NO_CHANGE' as img_stat_cd, lnk.link_exists, ps.cmply_dt, "); //img.chg_stat_cd as img_stat_cd,
            sqlQuery2.append(" ps.disp_order_nbr, img.img_lst_id, att.attach_lst, lnk.link_lst, xref.xref_lst_std_id, tax.title_txt as index_title, ps.expr_dt, flg.flag_id, 0 match_rec, '' match_img ");
            if (!StandardsListUtil.isNullOrBlank(searchCriteria))
            {
            	 sqlQuery2.append(", TAGSRCH.TAG_TXT ");
            }
            sqlQuery2.append(" FROM ");
            sqlQuery2.append(" TAXONOMY TAX, STAGE_TAXONOMY_STD PTS, ");
            if (!StandardsListUtil.isNullOrBlank(searchCriteria))
            {
              sqlQuery2.append(" TAGSEARCH TAGSRCH, ");
            }
            if (!StandardsListUtil.isNullOrBlank(idCriteria))
            {
                sqlQuery2.append(" SELECTED_STD_REC PS, ");
            }
            else
            {
                sqlQuery2.append(" PUB_STD PS, ");
            }
            sqlQuery2.append(" ATTACHMENTS ATT, IMAGES IMG, LINKS LNK, STD_XREF XREF, STD_FLAG FLG ");
            sqlQuery2.append(" WHERE pts.taxonomy_id = tax.stage_taxonomy_id ");
            sqlQuery2.append(" AND pts.stage_std_ver_id IN (SELECT DISTINCT prnt_std_id FROM direct_match) ");
            sqlQuery2.append(" AND ps.stage_std_ver_id NOT IN (SELECT stage_std_ver_id FROM direct_match) ");
            sqlQuery2.append(" AND pts.stage_std_ver_id = ps.prnt_std_id AND ps.stage_std_ver_id = att.stage_std_ver_id(+) ");
            sqlQuery2.append(" AND ps.stage_std_ver_id = lnk.stage_std_ver_id(+) AND ps.stage_std_ver_id = img.stage_std_ver_id(+) ");
            sqlQuery2.append(" AND ps.stage_std_ver_id = xref.referring_std_id(+) AND ps.stage_std_ver_id = flg.stage_std_ver_id(+) ");
            if (!StandardsListUtil.isNullOrBlank(searchCriteria))
            {
            sqlQuery2.append(" AND  ps.std_id = TAGSRCH.STD_ID(+) ");
            }
        }
        sqlQuery2.append(")) ");

        if (!StandardsListUtil.isNullOrBlank(searchCriteria))
        {
            if (SEARCH_OPTION_ANY.equals(textSearchType) || SEARCH_OPTION_EXACT.equals(textSearchType))
            {
                StringBuilder search = new StringBuilder(" AND ( ");
                search.append(" (ps.std_typ = 'GDLN' AND ");
                search.append(getWhereClauseForExactWords(searchCriteria, "upper(ps.std_desc)",
                        COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                search.append(" ) OR ");
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
                {
                    search.append(" (ps.std_typ = 'GDLN' AND ");
                    search.append(getWhereClauseForExactWords(replacedSearchCriteria, "upper(ps.std_desc)",
                            COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                    search.append(" ) OR ");
                }
                
                search.append(" (ps.std_typ != 'GDLN' AND ");
                search.append(getWhereClauseForExactWords(searchCriteria, "upper(ps.title_txt)",
                        COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                search.append(" ) ");
                if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
                {
                    search.append(" OR (ps.std_typ != 'GDLN' AND ");
                    search.append(getWhereClauseForExactWords(replacedSearchCriteria, "upper(ps.title_txt)",
                            COLUMN_TYPE_STRING_EXACT_MATCH_START, COLUMN_TYPE_STRING_EXACT_MATCH_END, true));
                    search.append(" ) ");
                }
                search.append(" OR ps.stage_std_ver_id = imgsrch.stage_std_ver_id) ");
                search.append(" OR  ps.std_id = TAGSRCH.STD_ID) ");

                sqlQuery3.append(search);
            }
            else
            {
              StringBuilder search = new StringBuilder(" AND ( ");
              search.append(" (ps.std_typ = 'GDLN' AND ");
              search.append(getWhereClauseForAllWords(searchCriteria, "upper(ps.std_desc)",
                      COLUMN_TYPE_STRING_MATCH_START, COLUMN_TYPE_STRING_MATCH_END, true));
              search.append(" ) OR ");
              if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
              {
                  search.append(" (ps.std_typ = 'GDLN' AND ");
                  search.append(getWhereClauseForAllWords(replacedSearchCriteria, "upper(ps.std_desc)",
                          COLUMN_TYPE_STRING_MATCH_START, COLUMN_TYPE_STRING_MATCH_END, true));
                  search.append(" ) OR ");
              }
              
              search.append(" (ps.std_typ != 'GDLN' AND ");
              search.append(getWhereClauseForAllWords(searchCriteria, "upper(ps.title_txt)",
                      COLUMN_TYPE_STRING_MATCH_START, COLUMN_TYPE_STRING_MATCH_END, true));
              search.append(" ) ");
              if (!StandardsListUtil.isNullOrBlank(replacedSearchCriteria))
              {
                  search.append(" OR (ps.std_typ != 'GDLN' AND ");
                  search.append(getWhereClauseForAllWords(replacedSearchCriteria, "upper(ps.title_txt)",
                          COLUMN_TYPE_STRING_MATCH_START, COLUMN_TYPE_STRING_MATCH_END, true));
                  search.append(" ) ");
              }
              search.append(" OR ps.stage_std_ver_id = imgsrch.stage_std_ver_id) ");
              search.append(" OR ps.std_id = TAGSRCH.STD_ID) ");
              sqlQuery3.append(search);
            }
        }

        if (!StandardsListUtil.isNullOrBlank(arlHotelLifeCycle) || !StandardsListUtil.isNullOrBlank(arlSpecialism) || 
                !StandardsListUtil.isNullOrBlank(arlDeptApplicability) || !StandardsListUtil.isNullOrBlank(arlGuestJourney)
                || !StandardsListUtil.isNullOrBlank(arlHotelLocations))
        {
            flagQuery = new StringBuilder(" ps.stage_std_ver_id IN ");
            flagQuery.append(" (SELECT pubs.stage_std_ver_id FROM stage_flag_std pfs, pub_std pubs ");
            flagQuery.append(" WHERE pubs.stage_std_ver_id = pfs.stage_std_ver_id ");
            
            if (!StandardsListUtil.isNullOrBlank(arlHotelLifeCycle))
            {
                hotelLifeCycleClause.add(getWhereClause(arlHotelLifeCycle, "pfs.flag_catgy_id", COLUMN_TYPE_NUMBER_START,
                        COLUMN_TYPE_NUMBER_END));
                String hotelLifeCycleQuery = buildFlagsQuery(flagQuery, hotelLifeCycleClause);
                clauses.add(new StringBuilder(hotelLifeCycleQuery));
            }
            
            if (!StandardsListUtil.isNullOrBlank(arlSpecialism))
            {
                specialismClause.add(getWhereClause(arlSpecialism, "pfs.flag_catgy_id", COLUMN_TYPE_NUMBER_START,
                        COLUMN_TYPE_NUMBER_END));
                String specialismQuery = buildFlagsQuery(flagQuery, specialismClause);
                clauses.add(new StringBuilder(specialismQuery));
            }
            
            if (!StandardsListUtil.isNullOrBlank(arlDeptApplicability))
            {
                hotelDeptClause.add(getWhereClause(arlDeptApplicability, "pfs.flag_catgy_id", COLUMN_TYPE_NUMBER_START,
                        COLUMN_TYPE_NUMBER_END));
                String deptQuery = buildFlagsQuery(flagQuery, hotelDeptClause);
                clauses.add(new StringBuilder(deptQuery));
            }
            if (!StandardsListUtil.isNullOrBlank(arlGuestJourney))
            {
                guestJourneyClause.add(getWhereClause(arlGuestJourney, "pfs.flag_catgy_id", COLUMN_TYPE_NUMBER_START,
                        COLUMN_TYPE_NUMBER_END));
                String guestQuery = buildFlagsQuery(flagQuery, guestJourneyClause);
                clauses.add(new StringBuilder(guestQuery));
            }
            if (!StandardsListUtil.isNullOrBlank(arlHotelLocations))
            {
                hotelLocClause.add(getWhereClause(arlHotelLocations, "pfs.flag_catgy_id", COLUMN_TYPE_NUMBER_START,
                        COLUMN_TYPE_NUMBER_END));
                String locnQuery = buildFlagsQuery(flagQuery, hotelLocClause);
                clauses.add(new StringBuilder(locnQuery));
            }
        }

        if (hasLinks)
        {
            tables.add(new StringBuilder("STAGE_STD_EXTL_LINK sel"));
            clauses.add(new StringBuilder("ps.stage_std_ver_id = sel.stage_std_ver_id"));
            clauses.add(new StringBuilder("EXISTS (SELECT stage_std_ver_id FROM stage_std_extl_link WHERE ps.stage_std_ver_id = sel.stage_std_ver_id AND sel.locale_cd in ('")
                    .append(localeCode).append("', 'en_GB'))"));
        }
        if (hasAttachments || hasSOP || hasTM)
        {
            tables.add(new StringBuilder("STAGE_STD_ATTACHMENT psa"));
            clauses.add(new StringBuilder("ps.stage_std_ver_id = psa.stage_std_ver_id"));
        }
        if (hasAttachments)
        {
            clauses.add(new StringBuilder("EXISTS (SELECT stage_std_ver_id FROM stage_std_attachment WHERE ps.stage_std_ver_id = psa.stage_std_ver_id AND psa.locale_cd in ('")
                    .append(localeCode).append("', 'en_GB'))"));
        }
        if (hasImages)
        {
            tables.add(new StringBuilder("STAGE_STD_IMAGE psi"));
            clauses.add(new StringBuilder("ps.stage_std_ver_id = psi.stage_std_ver_id"));
            clauses.add(new StringBuilder("EXISTS (SELECT stage_std_ver_id FROM stage_std_image WHERE ps.stage_std_ver_id = psi.stage_std_ver_id AND psi.locale_cd in ('")
                    .append(localeCode).append("', 'en_GB'))"));
        }
        if (hasSOP)
        {
            clauses.add(new StringBuilder("psa.attachment_typ = 'SOP'"));
        }
        if (hasTM)
        {
            clauses.add(new StringBuilder("(psa.attachment_typ = 'INTNL_TRAINING' OR psa.attachment_typ = 'HTL_TRAINING')"));
        }
        if (!StandardsListUtil.IsNullOrBlank(compliance))
        {
            if ("0d".equals(compliance))
            {
                clauses.add(new StringBuilder("ps.cmply_dt BETWEEN to_date('").append(StandardsListUtil.now())
                        .append("','DD-MON-YY') AND to_date('").append(StandardsListUtil.getComplianceDeadline("0d"))
                        .append("','DD-MON-YY')"));
            }
            if ("7d".equals(compliance))
            {
                clauses.add(new StringBuilder("ps.cmply_dt BETWEEN to_date('").append(StandardsListUtil.now())
                        .append("','DD-MON-YY') AND to_date('").append(StandardsListUtil.getComplianceDeadline("7d"))
                        .append("','DD-MON-YY')"));
            }
            if ("1m".equals(compliance))
            {
                clauses.add(new StringBuilder("ps.cmply_dt BETWEEN to_date('").append(StandardsListUtil.now())
                        .append("','DD-MON-YY') AND to_date('").append(StandardsListUtil.getComplianceDeadline("1m"))
                        .append("','DD-MON-YY')"));
            }
            if ("3m".equals(compliance))
            {
                clauses.add(new StringBuilder("ps.cmply_dt BETWEEN to_date('").append(StandardsListUtil.now())
                        .append("','DD-MON-YY') AND to_date('").append(StandardsListUtil.getComplianceDeadline("3m"))
                        .append("','DD-MON-YY')"));
            }
            if ("6m".equals(compliance))
            {
                clauses.add(new StringBuilder("ps.cmply_dt BETWEEN to_date('").append(StandardsListUtil.now())
                        .append("','DD-MON-YY') and  to_date('").append(StandardsListUtil.getComplianceDeadline("6m"))
                        .append("','DD-MON-YY')"));
            }
            if ("12m".equals(compliance))
            {
                clauses.add(new StringBuilder("ps.cmply_dt BETWEEN to_date('").append(StandardsListUtil.now())
                        .append("','DD-MON-YY') AND to_date('").append(StandardsListUtil.getComplianceDeadline("12m"))
                        .append("','DD-MON-YY')"));
            }
            if ("12m+".equals(compliance))
            {
                clauses.add(new StringBuilder("ps.cmply_dt >= to_date('").append(StandardsListUtil.getComplianceDeadline("12m+"))
                        .append("','DD-MON-YY')"));
            }
        }
        String query = buildQuery(sqlQuery1, sqlQuery2, sqlQuery3, tables, clauses);

        if (LOG.isDebugEnabled())
        {
            LOG.debug("staging query " + query);
        }
        return query;
    }

    /**
     * @param publishId publication id
     * @param std_id long object
     * @param countryCode String object
     * @return String
     */
    public static String getAllAssociatedStandards (long publishId, long std_id, String countryCode, String langCode) 
    {
        StringBuilder query = new StringBuilder();
        query.append("WITH ");
        query.append("STD_REC AS (SELECT prnt_std_id FROM publish_std WHERE std_id = ").append(std_id);
        query.append(" AND publish_id = ").append(publishId).append(")");
        query.append("(SELECT DISTINCT ps.std_id, decode(sx.title_txt, NULL, ps.title_txt, sx.title_txt) AS title_text,");
        query.append(" decode(sx.std_desc, NULL, ps.std_desc, sx.std_desc) AS std_desc, ps.std_typ, ps.disp_order_nbr, ps.prnt_std_id");
        query.append(" FROM publish_std ps, publish_std_xlat sx, std_rec st, publish_ctry_std pc");
        query.append(" WHERE ps.prnt_std_id = st.prnt_std_id");
        query.append(" AND ps.publish_id = ").append(publishId);
        query.append(" AND ps.publish_std_ver_id = pc.publish_std_ver_id");
        query.append(" AND pc.ctry_nm_cd = '").append(countryCode).append("'");
        query.append(" AND ps.publish_std_ver_id = sx.publish_std_ver_id(+)");
        query.append(" AND '").append(langCode).append("' = sx.locale_cd(+)) ORDER BY ps.std_typ DESC");
        if (LOG.isDebugEnabled()) {
            LOG.debug("reference query for production :" + query.toString());
        }
        return query.toString();
    }
    
    
    /**
     * @param publishId publication id
     * @param std_id long object
     * @param countryCode String object
     * @return String
     */
    public static String getAllAssociatedStandardsForStaging (long publishId, long std_id, String countryCode, String langCode) 
    {
        StringBuilder query = new StringBuilder();
        query.append("WITH ");
        query.append("STD_REC AS (SELECT prnt_std_id FROM stage_std WHERE std_id = ").append(std_id);
        query.append(" AND publish_id = ").append(publishId).append(")");
        query.append("(SELECT DISTINCT ps.std_id, decode(sx.title_txt, NULL, ps.title_txt, sx.title_txt) as title_text,");
        query.append(" decode(sx.std_desc, NULL, ps.std_desc, sx.std_desc) AS std_desc, ps.std_typ, ps.disp_order_nbr, ps.prnt_std_id");
        query.append(" FROM stage_std ps, stage_std_xlat sx, std_rec st, stage_ctry_std pc");
        query.append(" WHERE ps.prnt_std_id = st.prnt_std_id");
        query.append(" AND ps.publish_id = ").append(publishId);
        query.append(" AND ps.stage_std_ver_id = pc.stage_std_ver_id AND pc.ctry_nm_cd = '").append(countryCode).append("'");
        query.append(" AND ps.stage_std_ver_id = sx.stage_std_ver_id(+)");
        query.append(" AND '").append(langCode).append("' = sx.locale_cd(+)) ORDER BY ps.std_typ DESC");
        if (LOG.isDebugEnabled()) {
            LOG.debug("reference query for staging :" + query.toString());
        }
        return query.toString();
    }

    public static String getSpecialismCategoriesQuery(){
    	StringBuilder query = new StringBuilder();
    	query.append("SELECT FLAG_CATGY_ID, PRNT_FLAG_CATGY_ID, CATGY_CD, FLAG_CATGY_VAL, CREAT_USR_ID, CREAT_TS, LST_UPDT_USR_ID, LST_UPDT_TS, ACTV_IND, DISP_ORDER_NBR"); 
    	query.append(" FROM (SELECT f.*, 1 AS priority FROM flag_catgy f WHERE f.flag_catgy_id IN (258) AND f.actv_ind='Y'");
    	query.append("  UNION SELECT f.*, 2 AS priority FROM flag_catgy f WHERE f.flag_catgy_id != 401 AND f.prnt_flag_catgy_id IN (92) AND f.actv_ind='Y'");
    	query.append("  UNION SELECT f.*, 3 AS priority FROM flag_catgy f WHERE f.prnt_flag_catgy_id IN (93) AND f.actv_ind='Y'");
    	query.append("  UNION SELECT f.*, 4 AS priority FROM flag_catgy f WHERE f.flag_catgy_id IN (401) AND f.actv_ind='Y'");
    	query.append("  UNION SELECT f.*, 5 AS priority FROM flag_catgy f WHERE f.prnt_flag_catgy_id IN (500) AND f.actv_ind='Y'");
    	query.append(") ORDER BY priority, disp_order_nbr");
    	return query.toString();
    }
}
