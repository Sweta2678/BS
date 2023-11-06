package com.ihg.brandstandards.db.service.persistence;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.bridge.util.BridgeQueryUtils;
import com.ihg.brandstandards.bridge.util.ProgressQueryUtils;
import com.ihg.brandstandards.custom.model.Standard;
import com.ihg.brandstandards.db.model.BridgePublish;
import com.ihg.brandstandards.db.model.PublishQueue;
import com.ihg.brandstandards.db.model.PublishStandardsExt;
import com.ihg.brandstandards.db.model.impl.BridgePublishImpl;
import com.ihg.brandstandards.db.model.impl.PublishQueueImpl;
import com.ihg.brandstandards.db.model.impl.PublishStandardsExtImpl;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class BridgePublishFinderImpl extends BasePersistenceImpl<BridgePublish> implements BridgePublishFinder
{
    private static final Log LOG = LogFactoryUtil.getLog(BridgePublishFinderImpl.class);
    /**
     * 
     * @param query
     * @return List<Long>
     */
    public List<Long> getStandardIds(long publishId)
    {
        String query = BridgeQueryUtils.getAllStdIdForPublication(publishId);
        List<Long> stdIds = getLongValues(query, "STD_ID");
        return stdIds;
    }
    
    /**
     * Get Progress for different types based on progressType.
     * @param publishId Publish Id
     * @param chainCode Brand code
     * @param regionId Region Id
     * @param allRegions flag to fetch data for all Regions
     * @param progressType type of requested progress
     * @return Map feature, action count
     * @throws SystemException exception
     */
    public Map<String, Long> getBridgeProgress(long publishId, String chainCode, Date publishDate, long regionId, 
            boolean allRegions, String progressType) throws SystemException 
    {
        if (BridgeConstants.PROGRESS_TYPE_OVERALL.equals(progressType))
        {
            return getOverallProgress(publishId, regionId, allRegions);
        }
        else if (BridgeConstants.PROGRESS_TYPE_COMPLIANCE.equals(progressType))
        {
            return getComplianceProgress(publishId, regionId, chainCode, publishDate, allRegions);
        }
        else if (BridgeConstants.PROGRESS_TYPE_NOTIFICATIONS.equals(progressType))
        {
            return getNotificationsProgress(publishId, regionId, chainCode, publishDate, allRegions);
        }
        else if (BridgeConstants.PROGRESS_TYPE_INDEX_TRANS.equals(progressType))
        {
            return getIndexTranslationProgress(publishId, chainCode, regionId, allRegions);
        }
        else if (BridgeConstants.PROGRESS_TYPE_CONTENT_TRANS.equals(progressType))
        {
            return getTranslationProgress(publishId, regionId, allRegions);
        }
        else if (BridgeConstants.PROGRESS_TYPE_ATTACH_TRANS.equals(progressType))
        {
            return getAttachTranslationProgress(publishId, chainCode, regionId, allRegions);
        }
        else if (BridgeConstants.PROGRESS_TYPE_LINKS_TRANS.equals(progressType))
        {
            return getLinksTranslationProgress(publishId, chainCode, regionId, allRegions);
        }
        else if (BridgeConstants.PROGRESS_TYPE_IMAGE_TRANS.equals(progressType))
        {
            return getImageTranslationProgress(publishId, chainCode, regionId, allRegions);
        }
        else
        {
            LOG.error("Un Supported Progress Type");
            return new HashMap<String, Long>();
        }
    }
    
    /**
     * This method will return the overall progress status for a region.
     * @param publishId the bridge publish id.
     * @param regionId the region id.
     * @param allRegions boolean to specify consider all regions.
     * @return
     */
    public Map<String, Long> getOverallProgress(long publishId, long regionId, boolean allRegions) 
    {
        Map<String, Long> overAllProgress = new HashMap<String, Long>();
        String query = null;
        if(allRegions){
            query = ProgressQueryUtils.getAllRGNOverAllProgressQuery(publishId);
            if(LOG.isDebugEnabled()){
            	LOG.debug("AllRGNOverAllProgressQuery = " + query);
            }
        } else {
            query = ProgressQueryUtils.getOverAllProgressQuery(publishId, regionId);
            if(LOG.isDebugEnabled()){
            	LOG.debug("OverAllProgressQuery = " + query);
            }
        }
        Session session = null;
        try
        {
            long startTime = new Date().getTime();
            session = openSession();
            SQLQuery sqlQuery = session.createSQLQuery(query);
            List results = sqlQuery.list();
            if(results != null && results.size() == 9)
            {
                Object[] obj = (Object[]) results.get(0);
                overAllProgress.put(BridgeConstants.COUNT_DISCONTINUED, ((BigDecimal) obj[1]).longValue());
                obj = (Object[]) results.get(1);
                overAllProgress.put(BridgeConstants.COUNT_UNATTRIBUTE_BRND, ((BigDecimal) obj[1]).longValue());
                obj = (Object[]) results.get(2);
                overAllProgress.put(BridgeConstants.COUNT_UNATTRIBUTE_RGN, ((BigDecimal) obj[1]).longValue());
                obj = (Object[]) results.get(3);
                overAllProgress.put(BridgeConstants.COUNT_OVERRIDDEN, ((BigDecimal) obj[1]).longValue());
                obj = (Object[]) results.get(4);
                overAllProgress.put(BridgeConstants.COUNT_GLBL_MUST, ((BigDecimal) obj[1]).longValue());
                obj = (Object[]) results.get(5);
                overAllProgress.put(BridgeConstants.COUNT_GLBL_NOT_IN_MUST, ((BigDecimal) obj[1]).longValue());
                obj = (Object[]) results.get(6);
                overAllProgress.put(BridgeConstants.COUNT_GLBL_MUST_NOT, ((BigDecimal) obj[1]).longValue());
                obj = (Object[]) results.get(7);
                overAllProgress.put(BridgeConstants.COUNT_SELECT_STATE, ((BigDecimal) obj[1]).longValue());
                obj = (Object[]) results.get(8);
                overAllProgress.put(BridgeConstants.COUNT_MISS_XREF, ((BigDecimal) obj[1]).longValue());
            }
            if(LOG.isDebugEnabled()){
            	LOG.debug("getOverallProgress: publishId = " + publishId + " regionId = " + regionId + " query exceute time is " + (new Date().getTime() - startTime) + " mls");
            }
        }
        catch (ORMException e)
        {
            LOG.debug("Failed Query : " + query);
            LOG.error("Failed to execute query", e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return overAllProgress;
    }
  
    /**
     * This method will return the compliance progress status for a region.
     * @param publishId the bridge publish id.
     * @param regionId the region id.
     * @param allRegions boolean to specify consider all regions.
     * @return
     */
    public Map<String, Long> getComplianceProgress(long publishId, long regionId, String chainCode, Date publishDate, boolean allRegions) 
    {
        Map<String, Long> complianceProgress = new HashMap<String, Long>();
        
        String query = ProgressQueryUtils.getComplianceProgressQuery(publishId, regionId, chainCode, publishDate, allRegions);
        Session session = null;
        try
        {
            long startTime = new Date().getTime();
            session = openSession();
            SQLQuery sqlQuery = session.createSQLQuery(query);
            List results = sqlQuery.list();
            if(results != null && results.size() == 2)
            {
                Object[] obj = (Object[]) results.get(0);
                complianceProgress.put(BridgeConstants.COUNT_EXPIRED, ((BigDecimal) obj[1]).longValue());
                obj = (Object[]) results.get(1);
                complianceProgress.put(BridgeConstants.COUNT_COMPLIANT, ((BigDecimal) obj[1]).longValue());
            }
            if(LOG.isDebugEnabled()){
            	LOG.debug("getComplianceProgress: publishId = " + publishId + " chainCode = " + chainCode + " regionId = " + regionId + " query exceute time is " + (new Date().getTime() - startTime) + " mls");
            	LOG.debug(query);
            }
        }
        catch (ORMException e)
        {
            LOG.debug(query);
            LOG.error("Failed to execute getComplianceProgress query", e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
       
        return complianceProgress;
    }
    
    /**
     * This method will return the notifications progress status for a region.
     * @param publishId the bridge publish id.
     * @param regionId the region id.
     * @param allRegions boolean to specify consider all regions.
     * @return
     */
    public Map<String, Long> getNotificationsProgress(long publishId, long regionId, String chainCode, Date publishDate, boolean allRegions) 
    {
        Map<String, Long> notificationsProgress = new HashMap<String, Long>();
        
        String query = ProgressQueryUtils.getNotificationsProgressQuery(publishId, regionId);
        Session session = null;
        try
        {
            long startTime = new Date().getTime();
            session = openSession();
            SQLQuery sqlQuery = session.createSQLQuery(query);
            List results = sqlQuery.list();
            if(results != null && results.size() == 1)
            {
                Object[] obj = (Object[]) results.get(0);
                notificationsProgress.put(BridgeConstants.COUNT_NOTIFICATIONS, ((BigDecimal) obj[1]).longValue());
            }
            if(LOG.isDebugEnabled()){
            	LOG.debug("getNotificationsProgress: publishId = " + publishId + " chainCode = " + chainCode + " regionId = " + regionId + " query exceute time is " + (new Date().getTime() - startTime) + " mls");
            	LOG.debug(query);
            }
        }
        catch (ORMException e)
        {
            LOG.debug(query);
            LOG.error("Failed to execute getNotificationsProgress query", e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
       
        return notificationsProgress;
    }

    /**
     * Fetch content translation progress for specified Publication and Region.
     * @param publishId publication id
     * @param regionId region
     * @return Map locale and not translated items count.
     * @throws SystemException exceptionMap<String, Long> Map<String, Long> 
     */
    public Map<String, Long> getTranslationProgress(long publishId, long regionId, boolean allRegions) throws SystemException
    {
        Map<String, Long> localeCnt = new HashMap<String, Long>();
        Connection conn = null;
        CallableStatement colstmt = null;
        String cntQuery = ProgressQueryUtils.getContentTranslationProgressQuery(allRegions);
        String regionCd = BrandStandardsUtil.getRegionCode(regionId);
        
        try
        {
            long startTime = new Date().getTime();
            conn = getDataSource().getConnection();
            colstmt = conn.prepareCall(cntQuery);
            colstmt.setLong(1, publishId);
            colstmt.setLong(2, regionId);
            colstmt.setString(3, regionCd);
            colstmt.registerOutParameter(4, Types.VARCHAR);
            colstmt.executeQuery();
            String obj = (String)colstmt.getObject(4);
            
            if (obj != null && !obj.isEmpty())
            {
                String[] counts = obj.split(";");
                for (String item : counts)
                {
                    String[] cntItem = item.split(":");
                    localeCnt.put(cntItem[0], Long.valueOf(cntItem[1]));
                }
            }
            if(LOG.isDebugEnabled()){
            	LOG.debug("getTranslationProgress: publishId = " + publishId + " regionId = " + regionId + " query exceute time is " + (new Date().getTime() - startTime) + " mls");
            	LOG.debug(cntQuery);
            }
        }
        catch (SQLException e)
        {
            LOG.debug("Failed Query : " + cntQuery);
            LOG.error(e);
            throw new SystemException(e);
        }
        finally
        {
            closeConnection(conn, colstmt);
        }
        
        return localeCnt;
    }
    
    /**
     * Fetch Index translation progress for specified Publication and Region.
     * @param publishId publication id
     * @param chainCode brand
     * @param regionId region
     * @return Map locale and not translated items count.
     * @throws SystemException exceptionMap<String, Long> Map<String, Long> 
     */
    public Map<String, Long> getAttachTranslationProgress(long publishId, String chainCode, long regionId, boolean allRegions) throws SystemException
    {
        Map<String, Long> localeCnt = new HashMap<String, Long>();
        Connection conn = null;
        CallableStatement colstmt = null;
        String cntQuery = ProgressQueryUtils.getAttachTranslationProgressQuery(allRegions);
        String regionCd = BrandStandardsUtil.getRegionCode(regionId);
        
        try
        {
            long startTime = new Date().getTime();
            conn = getDataSource().getConnection();
            colstmt = conn.prepareCall(cntQuery);
            colstmt.setLong(1, publishId);
            colstmt.setLong(2, regionId);
            colstmt.setString(3, regionCd);
            colstmt.setString(4, chainCode);
            colstmt.registerOutParameter(5, Types.VARCHAR);
            colstmt.executeQuery();
            String obj = (String)colstmt.getObject(5);
            
            if (obj != null && !obj.isEmpty())
            {
                String[] counts = obj.split(";");
                for (String item : counts)
                {
                    String[] cntItem = item.split(":");
                    localeCnt.put(cntItem[0], Long.valueOf(cntItem[1]));
                }
            }
            if(LOG.isDebugEnabled()){
            	LOG.debug("getAttachTranslationProgress: publishId = " + publishId + " chainCode = " + chainCode + " regionId = " + regionId + " query exceute time is " + (new Date().getTime() - startTime) + " mls");
            	LOG.debug("Query : " + cntQuery);
            }
        }
        catch (SQLException e)
        {
            LOG.debug("Failed Query : " + cntQuery);
            LOG.error(e);
            throw new SystemException(e);
        }
        finally
        {
            closeConnection(conn, colstmt);
        }
        
        return localeCnt;
    }
    
    /**
     * Fetch Index translation progress for specified Publication and Region.
     * @param publishId publication id
     * @param regionId region
     * @return Map locale and not translated items count.
     * @throws SystemException exceptionMap<String, Long> Map<String, Long> 
     */
    public Map<String, Long> getLinksTranslationProgress(long publishId, String chainCode, long regionId, boolean allRegions) throws SystemException
    {
        Map<String, Long> localeCnt = new HashMap<String, Long>();
        Connection conn = null;
        CallableStatement colstmt = null;
        String cntQuery = ProgressQueryUtils.getLinksTranslationProgressQuery(allRegions);
        String regionCd = BrandStandardsUtil.getRegionCode(regionId);
        
        try
        {
            long startTime = new Date().getTime();
            conn = getDataSource().getConnection();
            colstmt = conn.prepareCall(cntQuery);
            colstmt.setLong(1, publishId);
            colstmt.setLong(2, regionId);
            colstmt.setString(3, regionCd);
            colstmt.setString(4, chainCode);
            colstmt.registerOutParameter(5, Types.VARCHAR);
            colstmt.executeQuery();
            String obj = (String)colstmt.getObject(5);
            
            if (obj != null && !obj.isEmpty())
            {
                String[] counts = obj.split(";");
                for (String item : counts)
                {
                    String[] cntItem = item.split(":");
                    localeCnt.put(cntItem[0], Long.valueOf(cntItem[1]));
                }
            }
            if(LOG.isDebugEnabled()){
            	LOG.debug("getLinksTranslationProgress: publishId = " + publishId + " chainCode = " + chainCode + " regionId = " + regionId + " query exceute time is " + (new Date().getTime() - startTime) + " mls");
            	LOG.debug("Query : " + cntQuery);
            }
        }
        catch (SQLException e)
        {
            LOG.debug("Failed Query : " + cntQuery);
            LOG.error(e);
            throw new SystemException(e);
        }
        finally
        {
            closeConnection(conn, colstmt);
        }
        
        return localeCnt;
    }
    
    /**
     * Fetch Index translation progress for specified Publication and Region.
     * @param publishId publication id
     * @param regionId region
     * @return Map locale and not translated items count.
     * @throws SystemException exceptionMap<String, Long> Map<String, Long> 
     */
    public Map<String, Long> getImageTranslationProgress(long publishId, String chainCode, long regionId, boolean allRegions) throws SystemException
    {
        Map<String, Long> localeCnt = new HashMap<String, Long>();
        Connection conn = null;
        CallableStatement colstmt = null;
        String cntQuery = ProgressQueryUtils.getImageTranslationProgressQuery(allRegions);
        String regionCd = BrandStandardsUtil.getRegionCode(regionId);
        
        try
        {
            long startTime = new Date().getTime();
            conn = getDataSource().getConnection();
            colstmt = conn.prepareCall(cntQuery);
            colstmt.setLong(1, publishId);
            colstmt.setLong(2, regionId);
            colstmt.setString(3, regionCd);
            colstmt.setString(4, chainCode);
            colstmt.registerOutParameter(5, Types.VARCHAR);
            colstmt.executeQuery();
            String obj = (String)colstmt.getObject(5);
            
            if (obj != null && !obj.isEmpty())
            {
                String[] counts = obj.split(";");
                for (String item : counts)
                {
                    String[] cntItem = item.split(":");
                    localeCnt.put(cntItem[0], Long.valueOf(cntItem[1]));
                }
            }
            if(LOG.isDebugEnabled()){
            	LOG.debug("getImageTranslationProgress: publishId = " + publishId + " chainCode = " + chainCode + " regionId = " + regionId + " query exceute time is " + (new Date().getTime() - startTime) + " mls");
            	LOG.debug("Query : " + cntQuery);
            }
        }
        catch (SQLException e)
        {
            LOG.debug("Failed Query : " + cntQuery);
            LOG.error(e);
            throw new SystemException(e);
        }
        finally
        {
            closeConnection(conn, colstmt);
        }
        
        return localeCnt;
    }
    
    /**
     * Fetch Index translation progress for specified Publication and Region.
     * @param publishId publication id
     * @param regionId region
     * @return Map locale and not translated items count.
     * @throws SystemException exceptionMap<String, Long> Map<String, Long> 
     */
    public Map<String, Long> getIndexTranslationProgress(long publishId, String chainCode, long regionId, boolean allRegions) throws SystemException
    {
        Map<String, Long> localeCnt = new HashMap<String, Long>();
        Connection conn = null;
        CallableStatement colstmt = null;
        String cntQuery = ProgressQueryUtils.getIndexTranslationProgressQuery(allRegions);
        String regionCd = BrandStandardsUtil.getRegionCode(regionId);
        
        try
        {
            long startTime = new Date().getTime();
            conn = getDataSource().getConnection();
            colstmt = conn.prepareCall(cntQuery);
            colstmt.setLong(1, publishId);
            colstmt.setString(2, chainCode);
            colstmt.setString(3, regionCd);
            colstmt.registerOutParameter(4, Types.VARCHAR); 

            colstmt.executeQuery();
            String obj = null;
            obj = (String)colstmt.getObject(4);
            
            if (obj != null && !obj.isEmpty())
            {
                String[] counts = obj.split(";");
                for (String item : counts)
                {
                    String[] cntItem = item.split(":");
                    localeCnt.put(cntItem[0], Long.valueOf(cntItem[1]));
                }
            }
            if(LOG.isDebugEnabled()){
            	LOG.debug("getIndexTranslationProgress: publishId = " + publishId + " chainCode = " + chainCode + " regionCd = " + regionCd + " query exceute time is " + (new Date().getTime() - startTime) + " mls");
            	LOG.debug("getIndexTranslationProgress Query : " + cntQuery);
            }
        }
        catch (SQLException e)
        {
            LOG.debug("Failed Query : " + cntQuery);
            LOG.error(e);
            throw new SystemException(e);
        }
        finally
        {
            closeConnection(conn, colstmt);
        }
        
        return localeCnt;
    }
    
    /**
     * This method will return the list standards based on overall progress report. 
     * @param publishId
     * @param regionId
     * @param statIndText
     * @return
     */
    public List<PublishStandardsExt> getProgressViewDetailsStandards(long publishId, long regionId, String chainCode, Date publishDate, 
            String localeCode, String statIndText)
    {
        List<PublishStandardsExt> arlDisplayResults = new ArrayList<PublishStandardsExt>();
        String query = ProgressQueryUtils.getProgressViewDetailsQuery(publishId, regionId, chainCode, publishDate, localeCode, statIndText);
        if(LOG.isDebugEnabled())
        {
            LOG.debug("View Details for " + statIndText + " Qury: " + query);
        }
        Session session = null;
        try
        {
            session = openSession();
            SQLQuery q = session.createSQLQuery(query);
            @SuppressWarnings("rawtypes")
            List arlStandards = q.list();
            
        	if(BridgeConstants.STAT_IND_NOFITICATION.equalsIgnoreCase(statIndText) || BridgeConstants.STAT_IND_ALL_NOFITICATION.equalsIgnoreCase(statIndText)) {
        		for (int i = 0; i < arlStandards.size(); i++) {
        			PublishStandardsExt standards = new PublishStandardsExtImpl();
	                Object[] obj = (Object[]) arlStandards.get(i);
	                standards.setTaxonomyId(((BigDecimal) obj[0]).longValue());
	                standards.setPublishId(((BigDecimal) obj[1]).longValue());
	                standards.setStdId(((BigDecimal) obj[2]).longValue());
	                standards.setStdTyp((String) obj[3]);
	                standards.setTitle((String) obj[4]);
	                standards.setIndexTitle((String) obj[5]);
	                standards.setIndexDescription((String) obj[6]);
	                standards.setCmplDateStr((String) obj[7]);
	                standards.setStatus((String) obj[8]);
	                standards.setCategory((String) obj[9]);
	                standards.setFramework((String) obj[10]);
	                arlDisplayResults.add(standards);
                }
        	} else {
        		for (int i = 0; i < arlStandards.size(); i++) {
        			PublishStandardsExt standards = new PublishStandardsExtImpl();
	                Object[] obj = (Object[]) arlStandards.get(i);
	                standards.setIndexOrder(((BigDecimal) obj[0]).longValue());
	                standards.setTaxonomyId(((BigDecimal) obj[1]).longValue());
	                standards.setParentTaxonomyId(((BigDecimal) obj[2]).longValue());
	                standards.setIndexLvl(((BigDecimal) obj[3]).longValue());
	                standards.setLevelSortOrder(((BigDecimal) obj[4]).longValue());
	                standards.setTaxonomyPath((String) obj[5]);
	                standards.setIndexDescription((String) obj[6]);
	                standards.setIndexTitle((String) obj[7]);
	                standards.setParentPublishId(((BigDecimal) obj[8]).longValue());
	                standards.setPublishStdId(((BigDecimal) obj[9]).longValue());
	                standards.setStdId(((BigDecimal) obj[9]).longValue());
	                standards.setStdTyp((String) obj[10]);
	                standards.setTitle((String) obj[11]);
	                standards.setDescription((String) obj[12]);
	                standards.setStatus((String) obj[13]);
	                standards.setSortOrder(((BigDecimal) obj[14]).longValue());
	                
	                if(BridgeConstants.STAT_IND_ALL.equals(statIndText))
	                {
	                    boolean isRemovable = ((BigDecimal) obj[15]).longValue() == 1L ? true : false;
	                    standards.setRemovable(isRemovable);
	                }
	
	                setDetailsPerType(statIndText, standards, obj); 
	                
	                arlDisplayResults.add(standards);
                }
        	}
        }
        catch (Exception e)
        {
            LOG.debug("Bridge Progress View Detail Query: " + query);
            LOG.error(e);
        }
        finally
        {
            closeSession(session);
        }
        return arlDisplayResults;
    }

    private void setDetailsPerType(String statIndText, PublishStandardsExt standards, Object[] obj)
    {
        if(BridgeConstants.STAT_IND_MISS_TRANS_INDEX.equalsIgnoreCase(statIndText))
        {
            standards.setIndexTitleXlat((String) obj[15]);
        } 
        else if(BridgeConstants.STAT_IND_MISS_TRANS_CONTENT.equalsIgnoreCase(statIndText))
        {
            standards.setStdTitleXlat((String) obj[15]);
            standards.setCategory((String) obj[16]);
            standards.setIsGlobal((String) obj[17]);
            standards.setFramework((String) obj[18]);
            standards.setManual((String) obj[19]);
            standards.setRegionCode((String) obj[21]);
        } 
        else if(BridgeConstants.STAT_IND_MISS_TRANS_ATTACH.equalsIgnoreCase(statIndText))
        {
            standards.setAttachmentListXlat((String) obj[15]);
            standards.setCategory((String) obj[16]);
            standards.setIsGlobal((String) obj[17]);
            standards.setFramework((String) obj[18]);
            standards.setManual((String) obj[19]);
            standards.setAttachmentList((String) obj[20]);
            standards.setRegionCode((String) obj[21]);
        } 
        else if(BridgeConstants.STAT_IND_MISS_TRANS_LINKS.equalsIgnoreCase(statIndText))
        {
            standards.setLinkListXlat((String) obj[15]);
            standards.setCategory((String) obj[16]);
            standards.setIsGlobal((String) obj[17]);
            standards.setFramework((String) obj[18]);
            standards.setManual((String) obj[19]);
            standards.setLinkList((String) obj[20]);
            standards.setRegionCode((String) obj[21]);
        } 
        else if(BridgeConstants.STAT_IND_MISS_TRANS_IMAGES.equalsIgnoreCase(statIndText))
        {
            standards.setImageListXlat((String) obj[15]);
            standards.setCategory((String) obj[16]);
            standards.setIsGlobal((String) obj[17]);
            standards.setFramework((String) obj[18]);
            standards.setManual((String) obj[19]);
            standards.setImageList((String) obj[20]);
            standards.setRegionCode((String) obj[21]);
        }
    }
    
    /**
     * This method will return the list standards based on translation progress report. 
     * @param publishId
     * @param regionId
     * @param statIndText
     * @return
     */
    public List getTranslationViewDetailsStandards(long publishId, long regionId, String localeCode)
    {
        List displayResults = new ArrayList();
        String query = ProgressQueryUtils.getTranslationViewDetailsQuery(publishId, regionId, localeCode);
        Session session = null;
        try
        {
            session = openSession();
            SQLQuery q = session.createSQLQuery(query);
            displayResults = q.list();
        }
        catch (Exception e)
        {
            LOG.debug("Bridge Translation View Detail Query: " + query);
            LOG.error("Failed to execute query", e);
        }
        finally
        {
            closeSession(session);
        }
        return displayResults;
    }
    
    /**
     * 
     * @param query
     * @return List<Long>
     */
    public List<PublishQueue> getPublishQueueRecords(String brandCode, String environment, String status)
    {
        String query = BridgeQueryUtils.getPublishQueueRecords(brandCode, environment, status);
        List<PublishQueue> list = new ArrayList<PublishQueue>();
        Session session = null;
        try
        {
            session = openSession();
            SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity("pq", PublishQueueImpl.class);
            list = sqlQuery.list();
        }
        catch (Exception e)
        {
            LOG.debug("Bridge Translation View Detail Query: " + query);
            LOG.error("Failed to execute query", e);
        }
        finally
        {
            closeSession(session);
        }
        return list;
    }
    
    public List<PublishStandardsExt> getUnpublishedDetailsStandards(long publishId, long regionId, String chainCode, String regionCode, String stdIds)
    {
        List<PublishStandardsExt> arlDisplayResults = new ArrayList<PublishStandardsExt>();
        String query = BridgeQueryUtils.getUnpublishStandardsQuery(publishId, regionId, chainCode, regionCode, stdIds);
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
                standards.setTaxonomyId(((BigDecimal) obj[1]).longValue());
                standards.setParentTaxonomyId(((BigDecimal) obj[2]).longValue());
                standards.setIndexLvl(((BigDecimal) obj[3]).longValue());
                standards.setLevelSortOrder(((BigDecimal) obj[4]).longValue());
                standards.setTaxonomyPath((String) obj[5]);
                standards.setIndexDescription((String) obj[6]);
                standards.setIndexTitle((String) obj[7]);
                standards.setParentPublishId(((BigDecimal) obj[8]).longValue());
                standards.setPublishStdId(((BigDecimal) obj[9]).longValue());
                standards.setStdId(((BigDecimal) obj[9]).longValue());
                standards.setStdTyp((String) obj[10]);
                standards.setRegionCode((String) obj[11]);
                standards.setIsGlobal((String) obj[12]);
                standards.setFramework((String) obj[13]);
                standards.setTitle((String) obj[14]);
                standards.setDescription((String) obj[15]);
                standards.setStatus((String) obj[16]);
                standards.setSortOrder(((BigDecimal) obj[17]).longValue());
                standards.setRegion((String) obj[18]);
                arlDisplayResults.add(standards);
            }
        }
        catch (Exception e)
        {
            LOG.debug("Bridge Unpublish View Detail Query: " + query);
            LOG.error(e);
        }
        finally
        {
            closeSession(session);
        }
        return arlDisplayResults;
    }
    
    /**
     * Delete records from publication for specified Region.
     * @param publishId publication id
     * @param regionId region id
     */
    public void resetBridgePublication(long bridgePublishId, long regionId, String chainCode, String userScreenName) throws SystemException
    {
        String resetQuery = BridgeQueryUtils.getResetPublicationQuery(bridgePublishId, regionId, chainCode, userScreenName);
        Connection conn = null;
        CallableStatement colstmt = null;
        try
        {
            conn = getDataSource().getConnection();
            colstmt = conn.prepareCall(resetQuery);
            colstmt.executeQuery();
        }
        catch (SQLException e)
        {
        	LOG.error("Reset Publication Failed Query->"+resetQuery);
            try
            {
                if (conn != null)
                {
                    conn.rollback();
                }
            }
            catch (SQLException e1)
            {
                LOG.error(e);
            }
            LOG.error(e);
            throw new SystemException(e);
        }
        finally
        {
            closeConnection(conn, colstmt);
        }
    }

    public List<PublishStandardsExt> getMyPublicationByBrand(String chainCode, String regionCode, String query) throws SystemException
    {
        List<PublishStandardsExt> arlDisplayStandards = new ArrayList<PublishStandardsExt>();
    	Session session = null;
    	try
    	{
    		session = openSession();
    		if(LOG.isDebugEnabled()){
            	LOG.debug("Search for Standards query = " + query);
    		}
            SQLQuery q = session.createSQLQuery(query);
            List arlStandards = q.list();
            if(LOG.isDebugEnabled()){
            	LOG.debug("Found " + arlStandards.size() + " records.");
            }
            for (int i = 0; i < arlStandards.size(); i++)
            {
                PublishStandardsExt standards = new PublishStandardsExtImpl();
                Object[] obj = (Object[]) arlStandards.get(i);
                standards.setIndexOrder(((BigDecimal) obj[0]).longValue());
                standards.setTaxonomyId(((BigDecimal) obj[1]).longValue());
                standards.setParentTaxonomyId(((BigDecimal) obj[2]).longValue());
                standards.setIndexLvl(((BigDecimal) obj[3]).longValue());
                standards.setLevelSortOrder(((BigDecimal) obj[4]).longValue());
                standards.setTaxonomyPath((String) obj[5]);
                standards.setIndexTitle((String) obj[6]);
                standards.setParentPublishId(((BigDecimal) obj[7]).longValue());
                standards.setPublishStdId(((BigDecimal) obj[8]).longValue());
                standards.setStdId(((BigDecimal) obj[9]).longValue());
                standards.setStdTyp((String) obj[10]);
                standards.setTitle((String) obj[11]);
                standards.setDescription((String) obj[12]);
                standards.setStatus((String) obj[13]);
                //If object length is greater than 18 then it is a my publication query result else it is for import
                if (obj.length > 18) {
                	if (obj[14] != null) {
                		standards.setStdXrefListStdId((String) obj[14]);
                	}
                		standards.setStatus((String) obj[15]);
                		standards.setSortOrder(((BigDecimal) obj[16]).longValue());
                	standards.setRegionCode((String) obj[17]);
                	//Should we allow user to delete this standard or not will be decided by this value
                	standards.setRemovable(GetterUtil.getBoolean((String) obj[18]));
                	standards.setRegion((String) obj[19]);
                	standards.setIsGlobal((String) obj[20]);
//                	standards.setErrorType((String) obj[21]);
                } else {
                	if (obj[14] != null) {
                		standards.setSortOrder(((BigDecimal) obj[14]).longValue());
                	} else {
                		standards.setSortOrder(0l);
                	}
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

    public void updateUnpublishedToPublishedRecords(long publishId, String brandCode, long regionId, String screenName, String stdIds)
    {
        Connection conn = null;
        CallableStatement colstmt = null;
        String query = BridgeQueryUtils.updateUnpublishedToPublishedRecords(publishId, brandCode, regionId, screenName, stdIds);
        try
        {
            conn = getDataSource().getConnection();
            colstmt = conn.prepareCall(query);
            colstmt.executeQuery();
        }
        catch (SQLException e)
        {
            LOG.debug("update Unpublished To PublishedRecords Procedure Query: " + query);
            LOG.error(e);
        }
        finally
        {
            closeConnection(conn, colstmt);
        }
    }
    
    /**
     * 
     * @param query String object
     */
    public void createDraftPublication(long publishId, String brandCode, String screenName)
    {
        
    	Connection conn = null;
        CallableStatement colstmt = null;
        String query = BridgeQueryUtils.createPublication(publishId, brandCode, screenName);
        if (LOG.isDebugEnabled()) 
        {
            LOG.debug("create publication query :" + query);
            LOG.debug("publishId = " + publishId + " brandCode = " + brandCode + " screenName = " + screenName);
        }
        try
        {
            conn = getDataSource().getConnection();
            colstmt = conn.prepareCall(query);
            colstmt.setString(1, brandCode);
            colstmt.setLong(2, publishId);
            colstmt.setString(3, screenName);
            colstmt.executeQuery();
        }
        catch (SQLException e)
        {
            LOG.error("Failed to execute Unpublished To PublishedRecords Procedure Query: ", e);
        }
        finally
        {
            closeConnection(conn, colstmt);
        }
    }
    
    /**
     * 
     * @param publishId
     * @return long
     */
    public long getStandardCountForPublication (long publishId) {
    	long count = 0l;
        String query = BridgeQueryUtils.getStandardCountForPublication(publishId);
    	Session session = null;
    	try {
	    	session = openSession();
	    	SQLQuery q = session.createSQLQuery(query);
	    	count = GetterUtil.getLong(q.uniqueResult().toString());
	    	if (LOG.isDebugEnabled()) {
	    		LOG.debug("Total standards :"+count);
	    	}
    	} catch (Exception e)
        {
    	    LOG.error("Failed to execute query", e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
    	return count;
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
                LOG.error(e);
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
                LOG.error(e);
            }
        }
    }
    
    public BridgePublish createOraSequence() throws SystemException
    {
        Session session = null;
        BridgePublish pubImport = null;
        try
        {
            session = openSession();
            final String query = "SELECT BRIDGE_PUBLISH_ID_SEQ.nextval AS BRIDGE_PUBLISH_ID, " +
                                 "-1 PUBLISH_ID, NULL STD_ID, 0 RGN_ID, NULL UNPUBLISH_IND, " +
                                 "NULL CREAT_USR_ID, SYSDATE CREAT_TS, NULL LST_UPDT_USR_ID, SYSDATE LST_UPDT_TS FROM dual";
//            if (LOG.isDebugEnabled())
//            {
//                LOG.debug("BridgePublishImport Query : " + query);
//            }
            
            final SQLQuery sqlQuery = session.createSQLQuery(query);
            sqlQuery.addEntity("BridgePublish", BridgePublishImpl.class);
            @SuppressWarnings("unchecked")
            List<BridgePublish> list = (List<BridgePublish>) sqlQuery.list();
            pubImport = (BridgePublish) (list.get(0));
//            if (LOG.isDebugEnabled())
//            {
//                LOG.debug("New BridgePublishImport id : " + pubImport.getPrimaryKey() + " ::: " + pubImport.getPublishImportId());
//            }
            pubImport.setPrimaryKey(pubImport.getBridgePublishId());
        }
        catch (Exception e)
        {
            LOG.error(e);
            throw new SystemException(e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return pubImport;
    }

    public boolean updateBridgePublishAndCountryFromImport(long bridgePublishId, long prodPublishId, String brandCode, long regionId, String screenName) throws SystemException
    {	
        long startTime = new Date().getTime();
    	boolean flag = false;
        Connection conn = null;
        CallableStatement colstmt = null;
        String query = BridgeQueryUtils.updateBridgePublishAndCountryFromImport(bridgePublishId, prodPublishId, brandCode, regionId, screenName);
       
        try
        {
        	conn = getDataSource().getConnection();
            colstmt = conn.prepareCall(query);
            colstmt.executeQuery();
            if (LOG.isDebugEnabled())
            {
                LOG.debug("after executing update");
            }
            flag = true;
            if(LOG.isDebugEnabled()){
            	LOG.debug("updateBridgePublishAndCountryFromImport: move records from Import to Publish took " + (new Date().getTime() - startTime) + " ms");
            }
        }
        catch (SQLException e)
        {
        	LOG.debug("update import To PublishedRecords Procedure Query: " + query);
            LOG.error("SQL Exception:", e);
        }
        catch(Exception e)
        {
            LOG.error(e);
        }
        finally
        {
            closeConnection(conn, colstmt);
        }
        return flag;
    }
    
    public List<Long> getBridgePublishStandardsByParent(String query) throws SystemException
    {
        List<Long> stdIds = getLongValues(query, "STD_ID");
        return stdIds;
    }
    
    public BridgePublish getBridgePublishStandardsById(String query) throws SystemException
    {
    	
    	Session session = null;
    	List arlStandards = new ArrayList();
    	List<Long> arlStdId = new ArrayList<Long>();
    	
    	BridgePublish bridgePublish = new BridgePublishImpl();
    	long stdId = 0;
    	try
    	{
    		session = openSession();
    		
            SQLQuery q = session.createSQLQuery(query);
            List<BridgePublish> list = (List<BridgePublish>) q.list();
            bridgePublish = list.get(0);
    	}
    	catch(Exception e)
    	{
            LOG.debug("Failed Query : " + query);
            LOG.error("Failed to execute query", e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
    	return bridgePublish;
    }
    
    /**
     * @param query
     * @return List<Standards>
     * @author Chintan
     */
    public List<Standard> getStandardDetails (String query) {
    	List<Standard> standardList = new ArrayList<Standard>();
    	Session session = null;
    	try
    	{
    		session = openSession();
            SQLQuery q = session.createSQLQuery(query);
            List result = q.list();
            if (result != null && !result.isEmpty()) {
            	for (int i = 0; i < result.size(); i++)
                {
                    Standard standard = new Standard();
                    Object[] obj = (Object[]) result.get(i);
                    standard.setTaxonomyPath((String) obj[0]);
                    standard.setTaxonomyId(((BigDecimal) obj[1]).longValue());
                    standard.setTaxonomyText((String) obj[2]);
                    standard.setStdId(((BigDecimal) obj[4]).longValue());
                    standard.setParentStdId(((BigDecimal) obj[5]).longValue());
                    standard.setStdType((String) obj[6]);
                    standard.setTitle((String) obj[7]);
                    standard.setRegionCode((String) obj[9]);
                    standard.setDescription((String) obj[10]);
                    standard.setStatus((String) obj[11]);
                    standard.setCurRegion((String) obj[12]);
                    standardList.add(standard); 
                }
            }
    	} catch(Exception e)
    	{
            LOG.debug("Failed Query : " + query);
            LOG.error("Failed to execute query", e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
    	return standardList;
    }

    public List<PublishStandardsExt> getPublishedStandardsCompliance(List<Long> stdIds, String stdType, String brandCd, String regionCode, 
            String fromDate, String toDate) throws SystemException
    {
        return getStandardsCompliance(stdIds, stdType, "PRODUCTION", brandCd, regionCode, fromDate, toDate);
    }
    
    public List<PublishStandardsExt> getBridgeStandardsCompliance(List<Long> stdIds, String stdType, String brandCd, String regionCode, 
            String fromDate, String toDate) throws SystemException
    {
        return getStandardsCompliance(stdIds, stdType, "BRIDGE", brandCd, regionCode, fromDate, toDate);
    }
    
    public List<PublishStandardsExt> getStandardsCompliance(List<Long> stdIds, String stdType, String environment, String brandCd, 
            String regionCode, String fromDate, String toDate) throws SystemException
    {
        List<PublishStandardsExt> standards = new ArrayList<PublishStandardsExt>();
        Session session = null;
        String query = BridgeQueryUtils.getStandardsCompliance(stdIds, stdType, environment, brandCd, regionCode, fromDate, toDate);
                
        try
        {
            session = openSession();
            SQLQuery q = session.createSQLQuery(query);
            q.setCacheable(false);
            
            @SuppressWarnings("rawtypes")
            List list = q.list();
            for (int i = 0; i < list.size(); i++)
            {
                Object[] obj = (Object[]) list.get(i);

                PublishStandardsExt standard = new PublishStandardsExtImpl();
                
                standard.setStdId(((BigDecimal) obj[0]).longValue());
                standard.setPublishStdId(((BigDecimal) obj[0]).longValue());
                standard.setParentPublishId(((BigDecimal) obj[1]).longValue());
                standard.setStdTyp((String) obj[2]);
                standard.setTitle((String) obj[3]);
                standard.setDescription((String) obj[4]);
                standard.setCategory((String) obj[5]);
                standard.setIsGlobal((String) obj[6]);
                standard.setRegionCode((String) obj[7]);
                standard.setFramework((String) obj[8]);
                standard.setSortOrder(((BigDecimal) obj[9]).longValue());
                standard.setImplDate((Date) obj[10]);
                standard.setExpiryDate((Date) obj[11]);
                standard.setCmplDateStr((String) obj[12]);
                standard.setExpiryDateStr((String) obj[13]);
                standard.setTaxonomyId(((BigDecimal) obj[14]).longValue());
                standard.setParentTaxonomyId(((BigDecimal) obj[15]).longValue());
                standard.setIndexOrder(((BigDecimal) obj[16]).longValue());
                standard.setIndexTitle((String) obj[17]);
                standard.setIndexLvl(((BigDecimal) obj[18]).longValue());
                standard.setTaxonomyPath((String) obj[19]);
                standard.setLevelSortOrder(((BigDecimal) obj[20]).longValue());
                standard.setIndexDescription((String) obj[21]);

                standards.add(standard);
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
        return standards;
    }
    
    public Map<String, String> getPublishedStandardComplianceDetails(long stdId, String brandCd, String regionCode) throws SystemException
    {
        return getStandardComplianceDetails(stdId, "PRODUCTION", brandCd, regionCode);
    }
    
    public Map<String, String> getBridgeStandardComplianceDetails(long stdId, String brandCd, String regionCode) throws SystemException
    {
        return getStandardComplianceDetails(stdId, "BRIDGE", brandCd, regionCode);
    }

    public Map<String, String> getStandardComplianceDetails(long stdId, String environment, String brandCd, String regionCode) throws SystemException
    {
        Map<String, String> complDetails = new HashMap<String, String>();
        Session session = null;
        String query = BridgeQueryUtils.getStandardComplianceDetails(stdId, environment, brandCd, regionCode);
        try
        {
            session = openSession();
            SQLQuery q = session.createSQLQuery(query);
            q.setCacheable(false);
            
            @SuppressWarnings("rawtypes")
            List list = q.list();
            
            for (int i = 0; i < list.size(); i++)
            {
                Object[] obj = (Object[]) list.get(i);

                String key = (String) obj[1];
                String value = (String) obj[3];
                complDetails.put(key, value);
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
        return complDetails;
    }
    
    /**
     * 
     * @param publishQueueId
     * @param publishId
     * @param emailAddress
     */
    public void createManuals(long publishQueueId, long publishId, String emailAddress, String userName,String regionCodes)
    {
        Connection conn = null;
        CallableStatement colstmt = null;
        String query = BridgeQueryUtils.createManuals(publishQueueId, publishId, emailAddress, userName,regionCodes);
        try
        {
            if (LOG.isDebugEnabled()) {
            	LOG.debug("create manuals query: " + query);
            }
        	conn = getDataSource().getConnection();
            colstmt = conn.prepareCall(query);
            colstmt.executeQuery();
        }
        catch (SQLException e)
        {
            LOG.error(e);
        }
        finally
        {
            closeConnection(conn, colstmt);
        }
    }
    
    /**
     * Run procedure to populate standards into bpridge_publish and bridge_publish_ctry tables. 
     * @param bridgePublishId
     * @param prodPublishId
     * @param brandCode
     * @param regionId
     * @param stdIds
     * @param screenName
     */
    public void addStdToBridgeForAddById(long bridgePublishId, long prodPublishId, String brandCode, long regionId, List<Long> stdIds, String screenName)
    {
        Connection conn = null;
        CallableStatement colstmt = null;
        String query = BridgeQueryUtils.addStdToBridgeForAddById(bridgePublishId, prodPublishId, brandCode, regionId, stdIds, screenName);
        try
        {
            if (LOG.isDebugEnabled()) {
                LOG.debug("add standards into bpridge_publish and bridge_publish_ctry query: " + query);
            }
            conn = getDataSource().getConnection();
            colstmt = conn.prepareCall(query);
            colstmt.executeQuery();
        }
        catch (SQLException e)
        {
            LOG.debug("add standards into bpridge_publish and bridge_publish_ctry query: " + query);
            LOG.error("Failed to execute query", e);
        }
        finally
        {
            closeConnection(conn, colstmt);
        }
    }
    
    /**
     * 
     * @param publishId
     * @param regionId
     * @return List<Long>
     * @throws SystemException
     */
    public List<Long> getMissingReferences(long publishId, long regionId) throws SystemException
    {
    	String query = BridgeQueryUtils.getMissingReferenceIds(publishId, regionId);
    	List<Long> missingStdIds = getLongValues(query, "STD_ID");
    	return missingStdIds;
    }

    /**
     * Get active Bridge Publish Ids for specified standard id.
     * @param stdId standard id
     * @return String
     */
    public List<Long> getBridgePublishIdsByStdId(long stdId) throws SystemException
    {
        String query = BridgeQueryUtils.getBridgePublishIdByStdIdQuery(stdId);
        List<Long> publishIds = getLongValues(query, "PUBLISH_ID");
        return publishIds;
    }
    
    /**
     * 
     * @param publishId
     * @param stdId
     * @return regionIds List<Long>
     */
    public List<Long> getRegionsByPublishIdAndStdId (long publishId, long stdId) {
    	String query = BridgeQueryUtils.getRegionsByPublishIdAndStdIdQuery(publishId, stdId);
    	List<Long> regionIds = getLongValues(query, "RGN_ID");
        return regionIds;
    }
    
    /**
     * Fetch list of long values based on provided query.
     * @param query query
     * @return List of longs or empty list when no data found.
     */
    public List<Long> getLongValues(String query, String columnName)
    {
        Session session = null;
        List<Long> longVal = new ArrayList<Long>();
        try
        {
            session = openSession();
            SQLQuery q = session.createSQLQuery(query);
            q.addScalar(columnName, Type.LONG);
            longVal = q.list();
            
//            List longVals = q.list();
//            for (int i = 0; i < longVals.size(); i++)
//            {
//                BigDecimal obj = (BigDecimal)longVals.get(i);
//                long id = obj.longValue();
//                longVal.add(id);
//            }
        }
        catch(Exception e)
        {
            LOG.debug("Failed Query : " + query);
            LOG.error("Failed to execute query", e);
        }
        finally
        {
            if (session != null)
            {
                closeSession(session);
            }
        }
        return longVal;
    }
}
