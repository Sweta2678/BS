package com.ihg.brandstandards.db.service.persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.ihg.brandstandards.db.model.GEMRole;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class GEMRoleFinderImpl extends BasePersistenceImpl<GEMRole> implements GEMRoleFinder {
	
	private static final Log LOG = LogFactoryUtil.getLog(GEMRoleFinderImpl.class);
	
	/**
	 * This method will re-calculate the GEM ROLES and adds missing roles. It does not update or delete any existing roles.
	 * @return boolean
	 */
	public boolean refreshGemRoles(String userName) {
		long start = new Date().getTime();
		StringBuffer query = new StringBuffer("DECLARE l_user VARCHAR2(50) := '").append(userName).append("'; l_rgn_id NUMBER;");
		query.append(" CURSOR l_gem_role_cur IS");
		query.append(" WITH");
		query.append(" 	REGINAL_ROLE AS (");
		query.append(" 		SELECT DISTINCT p.CHAIN_CD, ps.RGN_CD, ps.BUS_OWNER_NM, p.CHAIN_CD || '|' || ps.RGN_CD || '|' || ps.BUS_OWNER_NM AS ROLE_KEY FROM");
		query.append(" 		(SELECT PUBLISH_ID, CHAIN_CD FROM PUBLISH p WHERE p.PUBLISH_ENVIRONMENT_NM='PRODUCTION' AND p.PUBLISH_STAT_CD='ACTIVE') p, ");
		query.append("		PUBLISH_STD ps WHERE p.PUBLISH_ID=ps.PUBLISH_ID AND ps.RGN_CD <> 'GLBL' AND ps.BUS_OWNER_NM != 'To Be Assigned' ORDER BY ps.BUS_OWNER_NM),");
		query.append(" 	GLOBAL_ROLES AS (");
		query.append("   	SELECT DISTINCT DECODE(p.CHAIN_CD, 'All', 'GL',  p.CHAIN_CD) CHAIN_CD, ps.RGN_CD, ps.BUS_OWNER_NM, p.CHAIN_CD || '|Global|' || ps.BUS_OWNER_NM AS ROLE_KEY FROM");
		query.append(" 		(SELECT PUBLISH_ID, CHAIN_CD FROM PUBLISH p WHERE p.PUBLISH_ENVIRONMENT_NM='PRODUCTION' AND p.PUBLISH_STAT_CD='ACTIVE'");
		query.append(" 		UNION SELECT PUBLISH_ID, 'All' FROM PUBLISH p WHERE p.PUBLISH_ENVIRONMENT_NM='PRODUCTION' AND p.PUBLISH_STAT_CD='ACTIVE') p,");
		query.append(" 		PUBLISH_STD ps WHERE p.PUBLISH_ID = ps.PUBLISH_ID AND ps.RGN_CD = 'GLBL' AND ps.BUS_OWNER_NM != 'To Be Assigned' ORDER BY ps.BUS_OWNER_NM),");
		query.append("  GEM_FINAL_ROLES AS (SELECT * FROM REGINAL_ROLE UNION SELECT * FROM GLOBAL_ROLES)");
		query.append("  SELECT * FROM GEM_FINAL_ROLES ORDER BY BUS_OWNER_NM, ROLE_KEY;");
		
		query.append(" l_sql VARCHAR2(600) := 'INSERT INTO GEM_GRP(gem_grp_id, rgn_id, chain_cd, gem_grp_cd, owner_grp_id, owner_grp_nm, bus_owner_nm, delegate_1_nm, delegate_2_nm, creat_usr_id, creat_ts, lst_updt_usr_id, lst_updt_ts) ' ||");
		query.append(" 'SELECT :gemGrpId, :rgnId, :chainCd, :ownGrpCd, NULL, NULL, :busOwnerNm, NULL, NULL, :usr, SYSDATE, :usr, SYSDATE FROM dual ' ||");
		query.append(" 'WHERE NOT EXISTS (SELECT GEM_GRP_ID FROM GEM_GRP WHERE LOWER(GEM_GRP_CD) = LOWER(:ownGrpCd))';");
		
		query.append(" BEGIN");
		query.append(" 	FOR rec IN l_gem_role_cur LOOP");
		query.append(" 		SELECT RGN_ID INTO l_rgn_id FROM BRNDSTND_RGN WHERE rgn_cd=rec.RGN_CD AND PRNT_RGN_ID IS NULL;");
		query.append(" 		EXECUTE IMMEDIATE l_sql");
		query.append(" 		USING GEM_GRP_ID_SEQ.nextval, l_rgn_id, rec.CHAIN_CD, rec.ROLE_KEY, rec.BUS_OWNER_NM, l_user, l_user, rec.ROLE_KEY;");
		query.append(" 	END LOOP;");
        query.append("  COMMIT; ");
		query.append(" END;");
		
		boolean success = true;
		Connection conn = null;
        CallableStatement colstmt = null;
        try
        {
            conn = getDataSource().getConnection();
            colstmt = conn.prepareCall(query.toString());
            colstmt.executeQuery();
        }
        catch (SQLException e)
        {
            success = false;
            LOG.debug("GEM ROLES REFRESH Query: " + query);
            LOG.error("Failed to REFRESH GEM ROLES", e);
        }
        finally
        {
        	LOG.debug("GEM ROLES REFRESH Query took: " + (new Date().getTime() - start) + "ms");
            closeConnection(conn, colstmt);
        }
        return success;
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
}
