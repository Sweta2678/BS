package com.ihg.brandstandards.db.service.persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ihg.brandstandards.db.model.GEMTemplate;
import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class GEMTemplateFinderImpl extends BasePersistenceImpl<GEMTemplate> implements GEMTemplateFinder {
	
	private static final Log LOG = LogFactoryUtil.getLog(GEMTemplateFinderImpl.class);
	
	/**
	 * @param templateId
	 * Delete template configuration
	 */
	public void deleteTemplateConfigurations (long templateId) throws SystemException {
		
		StringBuilder templateQuery = new StringBuilder();
        templateQuery.append("BEGIN ");
        templateQuery.append("DELETE FROM GEM_GEN_RPT_VAL WHERE GEM_GEN_RPT_ID IN (SELECT GEM_GEN_RPT_ID FROM GEM_GEN_RPT WHERE GEM_TEMPLATE_ID=?);");
        templateQuery.append("DELETE FROM GEM_GEN_RPT WHERE GEM_TEMPLATE_ID=?;");
        templateQuery.append("DELETE from GEM_TEMPLATE_VAL WHERE GEM_TEMPLATE_COL_ID IN (SELECT GEM_TEMPLATE_COL_ID FROM GEM_TEMPLATE_COL WHERE GEM_TEMPLATE_ID=?);");
        templateQuery.append("DELETE from GEM_TEMPLATE_COL WHERE GEM_TEMPLATE_ID=?;");
        templateQuery.append("DELETE FROM GEM_TEMPLATE_CATGY WHERE GEM_TEMPLATE_ID=?;");
        //Delete GEM Measurement data
        templateQuery.append("DELETE FROM GEM_MSRMNT_BUCKET_CHAIN WHERE GEM_MSRMNT_ID IN (SELECT GEM_MSRMNT_ID FROM GEM_MSRMNT WHERE GEM_TEMPLATE_ID = ?);");
        templateQuery.append("DELETE FROM GEM_MSRMNT_FORMULA_DTL WHERE GEM_MSRMNT_FORMULA_ID IN (SELECT GEM_MSRMNT_FORMULA_ID FROM GEM_MSRMNT_FORMULA WHERE GEM_MSRMNT_ID IN ");
        templateQuery.append(" (SELECT GEM_MSRMNT_ID FROM GEM_MSRMNT WHERE GEM_TEMPLATE_ID = ?));");
        templateQuery.append("DELETE FROM GEM_MSRMNT_FORMULA WHERE GEM_MSRMNT_ID IN (SELECT GEM_MSRMNT_ID FROM GEM_MSRMNT WHERE GEM_TEMPLATE_ID = ?);");
        templateQuery.append("DELETE FROM GEM_CHAIN_MSRMNT WHERE GEM_MSRMNT_ID IN (SELECT GEM_MSRMNT_ID FROM GEM_MSRMNT WHERE GEM_TEMPLATE_ID = ?);");
        templateQuery.append("DELETE FROM QLTY_LEAD_RPT WHERE GEM_MSRMNT_ID IN (SELECT GEM_MSRMNT_ID FROM GEM_MSRMNT WHERE GEM_TEMPLATE_ID = ?);");
        
        templateQuery.append("DELETE FROM GEM_MSRMNT WHERE GEM_TEMPLATE_ID = ?;");
        //Delete GEM template reference
        templateQuery.append("DELETE FROM GEM_PUB_REF_TEMPLATE WHERE GEM_TEMPLATE_ID = ?;");
        //Delete GEM Template
        templateQuery.append("DELETE FROM GEM_TEMPLATE WHERE GEM_TEMPLATE_ID=?;");
        
        templateQuery.append("END; ");

        Connection conn = null;
        CallableStatement colstmt = null;
        try
        {
            conn = getDataSource().getConnection();
            colstmt = conn.prepareCall(templateQuery.toString());
            colstmt.setLong(1, templateId);
            colstmt.setLong(2, templateId);
            colstmt.setLong(3, templateId);
            colstmt.setLong(4, templateId);
            colstmt.setLong(5, templateId);
            colstmt.setLong(6, templateId);
            colstmt.setLong(7, templateId);
            colstmt.setLong(8, templateId);
            colstmt.setLong(9, templateId);
            colstmt.setLong(10, templateId);
            colstmt.setLong(11, templateId);
            colstmt.setLong(12, templateId);
            colstmt.setLong(13, templateId);
            colstmt.executeQuery();
        }
        catch (SQLException e)
        {
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
	
	/**
	 * @param conn
	 * @param colstmt
	 * Close connection
	 */
	private void closeConnection(Connection conn, PreparedStatement colstmt)
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
	
	/**
	 * 
	 * @param sequenceName
	 * @return primaryKey
	 */
	public long getSequenceNumber (String sequenceName) {
		long primaryKey = 0l;
		StringBuffer query = new StringBuffer();
		query.append("select ");
		query.append(sequenceName);
		query.append(".nextval from dual");
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getDataSource().getConnection();
			pst = conn.prepareStatement(query.toString());
			synchronized( this ) {
			   ResultSet rs = pst.executeQuery();
			   if(rs.next()) {
				   primaryKey = rs.getLong(1);				   
			   }
			   if (LOG.isDebugEnabled()) {
					LOG.debug("Sequence : "+sequenceName +" id is : "+primaryKey);
			   }
			}
		} catch (ORMException e) {
			LOG.error(e.getMessage(), e);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		} finally {
            if (conn != null) {
            	closeConnection(conn, pst);
            }
        }
		return primaryKey;
	}
	
	/**
	 * 
	 * @param columnId
	 * @param columnValue
	 * @param categoryId
	 * @param orderNumber
	 * @param createUserId
	 * @return boolean
	 * @throws SystemException
	 */
    public boolean insertTemplateValueUsingSequence (long columnId, String columnValue, long categoryId, long orderNumber, String createUserId) throws SystemException
    {
    	    Connection conn = null;
	        CallableStatement colstmt = null;
	        boolean inserted = false;
	        StringBuffer query = new StringBuffer("INSERT INTO gem_template_val(gem_template_col_id, GEM_CATGY_ID, COL_VAL, DISP_ORDER_NBR, GEM_TEMPLATE_VAL_ID, ");
            query.append(" creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts)");
            query.append(" VALUES (?, ?, ?, ?, gem_template_val_id_seq.nextval, ?, SYSDATE, ?, SYSDATE)");
	        try {
	            conn = getDataSource().getConnection();
	            colstmt = conn.prepareCall(query.toString());
	            colstmt.setLong(1, columnId);
	            colstmt.setLong(2, categoryId);
	            colstmt.setString(3, columnValue);
	            colstmt.setLong(4, orderNumber);
	            colstmt.setString(5, createUserId);
	            colstmt.setString(6, createUserId);
	            colstmt.executeQuery();
	            inserted = true;
	        } catch (SQLException e) {
	        	LOG.debug("Failed GEM Template Val Query : " + query);
	        	LOG.error(e);
	        	throw new SystemException(e);
	        } finally {
	            closeConnection(conn, colstmt);
	        }
        return inserted;
    }


}
