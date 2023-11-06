package com.ihg.brandstandards.db.service.persistence;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ihg.brandstandards.db.model.PublishStandardsExt;
import com.ihg.brandstandards.db.model.impl.PublishStandardsExtImpl;
import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

/**
 * @author Lakshminarayana Mummanedi
 */
public class PublishStandardsExtFinderImpl  extends BasePersistenceImpl<PublishStandardsExt> implements PublishStandardsExtFinder
{
	private static final Log LOG = LogFactoryUtil.getLog(PublishStandardsExtFinderImpl.class);
	
	public List<PublishStandardsExt> getStandardsByCountryAndBrand(String localeCode, String chainCode, String countryCode, String stdType, String query)
    {
        List<PublishStandardsExt> arlDisplayStandards = new ArrayList<PublishStandardsExt>();
        Session session = null;
        try
        {
            session = openSession();
            SQLQuery q = session.createSQLQuery(query);
            @SuppressWarnings("rawtypes")
            List arlStandards = q.list();

            for (int i = 0; i < arlStandards.size(); i++)
            {
                PublishStandardsExt standards = new PublishStandardsExtImpl();
                Object[] obj = (Object[]) arlStandards.get(i);
                standards.setPublishStdId(((BigDecimal) obj[0]).longValue());
                standards.setTitle((String) obj[1]);
                standards.setDescription((String) obj[2]);
                standards.setStatus((String) obj[3]);
                standards.setStdTyp((String) obj[4]);
                standards.setStdId(((BigDecimal) obj[8]).longValue());
                standards.setParentPublishId(((BigDecimal) obj[9]).longValue());
                if (Validator.isNotNull(String.valueOf(obj[10])))
                {
                    standards.setAttachmentExists("true");
                }
                if (Validator.isNotNull(String.valueOf(obj[11])))
                {
                    standards.setLinkExists("true");
                }
                if (Validator.isNotNull(String.valueOf(obj[12])))
                {
                    standards.setImageExists("true");
                }
                standards.setAttachmentStatus((String) obj[13]);
                standards.setLinkStatus((String) obj[14]);
                standards.setImageStatus((String) obj[15]);

                if (stdType.equals("STD"))
                {
                    standards.setTaxonomyId(((BigDecimal) obj[16]).longValue());
                }
                arlDisplayStandards.add(standards);
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

        return arlDisplayStandards;
    }
	
	public List<PublishStandardsExt> getSearchResults(String localeCode, String chainCode, String countryCode, String stdType, String query)
    {
        List<PublishStandardsExt> arlDisplayResults = new ArrayList<PublishStandardsExt>();
        Session session = null;
        try
        {
            session = openSession();
            SQLQuery q = session.createSQLQuery(query);
            @SuppressWarnings("rawtypes")
            List arlStandards = q.list();

            for (int i = 0; i < arlStandards.size(); i++)
            {
                PublishStandardsExt standards = new PublishStandardsExtImpl();
                Object[] obj = (Object[]) arlStandards.get(i);
                standards.setIndexOrder(((BigDecimal) obj[0]).longValue());
                standards.setPublishTaxonomyId(((BigDecimal) obj[1]).longValue());
                standards.setParentTaxonomyId(((BigDecimal) obj[2]).longValue());
                standards.setIndexLvl(((BigDecimal) obj[3]).longValue());
                standards.setLevelSortOrder(((BigDecimal) obj[4]).longValue());
                standards.setPublishId(((BigDecimal) obj[5]).longValue());
                //LOG.debug("the value of taxonomy path in finder is "+(String)obj[6]);
                standards.setTaxonomyPath((String) obj[6]);
                standards.setIndexDescription((String) obj[7]);
                standards.setPublishStdId(((BigDecimal) obj[8]).longValue());
                standards.setParentPublishId(((BigDecimal) obj[9]).longValue());
                standards.setStdId(((BigDecimal) obj[10]).longValue());
                standards.setStdTyp((String) obj[11]);
                standards.setTitle((String) obj[12]);
                standards.setDescription((String) obj[13]);
                standards.setStatus((String) obj[14]);
                if (Validator.isNotNull(String.valueOf(obj[15])))
                {
                    standards.setAttachmentExists("true");
                }
                //standards.setAttachmentStatus((String)obj[16]);
                if (Validator.isNotNull(String.valueOf(obj[16])))
                {
                    standards.setImageExists("true");
                }
                standards.setImageStatus((String) obj[17]);
                if (Validator.isNotNull(String.valueOf(obj[18])))
                {
                    standards.setLinkExists("true");
                }
                standards.setImplDate((Date) obj[19]);
                standards.setSortOrder(((BigDecimal) obj[20]).longValue());
                standards.setImageIdList((String) obj[21]);
                standards.setAttachmentList((String) obj[22]);
                standards.setLinkList((String) obj[23]);
                standards.setStdXrefListStdId((String) obj[24]);
                standards.setIndexTitle((String) obj[25]);
                standards.setExpiryDate((Date) obj[26]);
                standards.setFlagStdId((String) obj[27]);
                boolean isMatch = ((BigDecimal) obj[28]).intValue() == 1 ? true : false;
                standards.setSearchMatches(isMatch);
                standards.setImageStatus((String) obj[29]);

                arlDisplayResults.add(standards);
            }
        }
        catch (ORMException orm)
        {
            LOG.error("Catch ORMException.", orm);
        }
        catch (Exception e)
        {
            LOG.error("Catch exception.", e);
        }
        finally
        {
            closeSession(session);
        }
        LOG.info("the size of arlStandards before returning from finder is " + arlDisplayResults.size());
        return arlDisplayResults;
    }
	
    /**
     * Fetch all indexes from OBSM Publish for OBSM Index Sorting
     */
    public List<PublishStandardsExt> getAllIndexes(String query)
    {
        List<PublishStandardsExt> arlDisplayResults = new ArrayList<PublishStandardsExt>();
        Session session = null;
        try
        {
            session = openSession();
            SQLQuery q = session.createSQLQuery(query);
            @SuppressWarnings("rawtypes")
            List arlStandards = q.list();

            for (int i = 0; i < arlStandards.size(); i++)
            {
                PublishStandardsExt standards = new PublishStandardsExtImpl();
                Object[] obj = (Object[]) arlStandards.get(i);
                standards.setIndexOrder(((BigDecimal) obj[0]).longValue());
                standards.setPublishTaxonomyId(((BigDecimal) obj[1]).longValue());
                standards.setParentTaxonomyId(((BigDecimal) obj[2]).longValue());
                standards.setIndexLvl(((BigDecimal) obj[3]).longValue());
                standards.setLevelSortOrder(((BigDecimal) obj[4]).longValue());
                standards.setPublishId(((BigDecimal) obj[5]).longValue());
                standards.setTaxonomyPath((String) obj[6]);
                standards.setIndexDescription((String) obj[7]);
                standards.setIndexTitle((String) obj[25]);
                arlDisplayResults.add(standards);
            }
        }
        catch (ORMException orm)
        {
            LOG.error("Catch ORMException.", orm);
        }
        catch (Exception e)
        {
            LOG.error("Catch exception.", e);
        }
        finally
        {
            closeSession(session);
        }
        LOG.info("All Indexes size is " + arlDisplayResults.size());
        return arlDisplayResults;
    }
    
    /**
     * Fetch all indexes from CMS for Bridge Standards Index Sorting
     */
    public List<PublishStandardsExt> getCMSAllIndexes(String query)
    {
        List<PublishStandardsExt> arlDisplayResults = new ArrayList<PublishStandardsExt>();
        Session session = null;
        try
        {
            session = openSession();
            SQLQuery q = session.createSQLQuery(query);
            @SuppressWarnings("rawtypes")
            List arlStandards = q.list();

            for (int i = 0; i < arlStandards.size(); i++)
            {
                PublishStandardsExt standards = new PublishStandardsExtImpl();
                Object[] obj = (Object[]) arlStandards.get(i);
                standards.setIndexOrder(((BigDecimal) obj[0]).longValue());
                standards.setPublishTaxonomyId(((BigDecimal) obj[1]).longValue());
                standards.setParentTaxonomyId(((BigDecimal) obj[2]).longValue());
                standards.setIndexLvl(((BigDecimal) obj[3]).longValue());
                standards.setLevelSortOrder(((BigDecimal) obj[4]).longValue());
                standards.setPublishId(((BigDecimal) obj[5]).longValue());
                standards.setTaxonomyPath((String) obj[6]);
                standards.setIndexDescription((String) obj[7]);
                standards.setIndexTitle((String) obj[8]);
                arlDisplayResults.add(standards);
            }
        }
        catch (ORMException orm)
        {
            LOG.error("Catch ORMException.", orm);
        }
        catch (Exception e)
        {
            LOG.error("Catch exception.", e);
        }
        finally
        {
            closeSession(session);
        }
        return arlDisplayResults;
    }

    /**
     * This method will return the list to display on what changed on screen.
     * 
     * @param query
     * @return
     */
    public List<PublishStandardsExt> getWhatChangedOnList(String query, boolean indexQuery) {
        List<PublishStandardsExt> arlDisplayResults = new ArrayList<PublishStandardsExt>();
        Session session = null;
        try {
            session = openSession();
            SQLQuery q = session.createSQLQuery(query);
            @SuppressWarnings("rawtypes")
            List arlStandards = q.list();
            if (arlStandards != null && arlStandards.size() > 0) {
                for (int i = 0; i < arlStandards.size(); i++) {
                    PublishStandardsExt standardsExt = new PublishStandardsExtImpl();
                    Object[] obj = (Object[]) arlStandards.get(i);
                    standardsExt.setIndexOrder(((BigDecimal) obj[0]).longValue());
                    standardsExt.setTaxonomyId(((BigDecimal) obj[1]).longValue());
                    standardsExt.setPublishTaxonomyId(((BigDecimal) obj[2]).longValue());
                    standardsExt.setParentTaxonomyId(((BigDecimal) obj[3]).longValue());
                    standardsExt.setIndexLvl(((BigDecimal) obj[4]).longValue());
                    standardsExt.setLevelSortOrder(((BigDecimal) obj[5]).longValue());
                    standardsExt.setPublishId(((BigDecimal) obj[6]).longValue());
                    standardsExt.setTaxonomyPath((String) obj[7]);
                    standardsExt.setIndexDescription((String) obj[8]);
                    standardsExt.setIndexTitle((String) obj[9]);
                    if(!indexQuery) {
	                    standardsExt.setPublishStdId(((BigDecimal) obj[10]).longValue());
	                    standardsExt.setParentPublishId(((BigDecimal) obj[11]).longValue());
	                    standardsExt.setStdId(((BigDecimal) obj[12]).longValue());
	                    standardsExt.setStdTyp((String) obj[13]);
	                    standardsExt.setTitle((String) obj[14]);
	                    standardsExt.setDescription((String) obj[15]);
	                    standardsExt.setStatus((String) obj[16]);
	                    standardsExt.setImplDate((Date) obj[17]);
	                    standardsExt.setExpiryDate((Date) obj[18]);
	                    standardsExt.setFlagStdId((String) obj[19]);
	                    standardsExt.setSortOrder(((BigDecimal) obj[20]).longValue());
	                    
	                    standardsExt.setPrevPublishTitle((String) obj[21]);
	                    standardsExt.setPrevDescription((String) obj[22]);
	                    standardsExt.setPrevCmplyDate((Date) obj[23]);
	                    standardsExt.setPrevExpiryDate((Date) obj[24]);
	                    standardsExt.setPrevFlagStdId((String) obj[25]);
	                    standardsExt.setTitleChange((String) obj[26]);
	                    standardsExt.setCmplyChange((String) obj[27]);
	                    standardsExt.setExprChange((String) obj[28]);
	                    standardsExt.setHlcChange((String) obj[29]);
	                    standardsExt.setChangedStatus((String) obj[30]);
                    }
                    arlDisplayResults.add(standardsExt);
                }
            }
        } catch (Exception e) {
            LOG.error("Catch exception.", e);
        } finally {
            closeSession(session);
        }
        return arlDisplayResults;
    }

}
