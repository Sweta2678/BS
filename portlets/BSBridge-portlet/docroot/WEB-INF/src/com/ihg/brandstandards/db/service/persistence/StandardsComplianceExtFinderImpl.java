package com.ihg.brandstandards.db.service.persistence;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ihg.brandstandards.db.model.StandardsComplianceExt;
import com.ihg.brandstandards.db.model.impl.StandardsComplianceExtImpl;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class StandardsComplianceExtFinderImpl extends BasePersistenceImpl<StandardsComplianceExt> implements StandardsComplianceExtFinder
{
    private static final Log LOG = LogFactoryUtil.getLog(StandardsComplianceExtFinderImpl.class);

	public List<StandardsComplianceExt> getComplianceByRegion(String sqlQuery, long stdId, String chainCode) throws SystemException
	{
		List results = new ArrayList();
		List<StandardsComplianceExt> arlCompliance = new ArrayList<StandardsComplianceExt>();
		Session session = null;
		
		StringBuffer query = new StringBuffer();
		query.append("	SELECT DISTINCT sc.std_cmply_id, sc.std_id, br.rgn_cd, sc.cmply_expr_rule_cd, sc.cmply_expr_dt, sc.chain_cd,	");
		query.append("	sc.cmply_rule_mo_qty, sc.rule_dt_cd,  sc.cmply_expr_dt AS expr_dt,	");
		query.append("	  CASE 	");
		query.append("	    WHEN sc.cmply_expr_rule_cd = 'C' THEN	");
		query.append("	        CASE WHEN sc.rule_dt_cd = 'R' THEN	");
		query.append("	            to_char(nvl(sc.cmply_rule_mo_qty, 0))	");
		query.append("	        ELSE	");
		query.append("	             to_char(sc.cmply_expr_dt, 'DD-Mon-YYYY')	");
		query.append("	        END	");
		query.append("	    END cmply_dt_str,	");
		query.append("	    CASE 	");
		query.append("	    WHEN sc.cmply_expr_rule_cd = 'E' THEN 	");
		query.append("	       to_char(sc.cmply_expr_dt, 'DD-Mon-YYYY')	");
		query.append("	    END expr_dt_str, sc.ctry_nm_cd	");
		query.append("	  FROM std s, std_cmply sc, brndstnd_ctry bc, brndstnd_rgn br	");
		query.append("	  where 	");
		query.append("	  s.std_id = sc.std_id and	");
		query.append("	  sc.ctry_nm_cd = bc.ctry_nm_cd and	");
		query.append("	  bc.rgn_id = br.rgn_id  AND 	");
		query.append("	  s.stat_desc != 'DELETED' AND 	");
		query.append("	  s.std_typ != 'GDLN'  AND	");
		query.append("	  s.std_id = "+stdId+" AND 	");
		query.append("	  chain_cd = '"+chainCode+"'  	");
		query.append("	  order by br.rgn_cd	");
	
    	try
    	{
    		session = openSession();
    	
			 SQLQuery q = session.createSQLQuery(query.toString());
			// q.addEntity("StandardsComplianceExt", StandardsComplianceExtImpl.class);
			 results = q.list();
			 for(int i=0;i<results.size();i++)
			 {
				 StandardsComplianceExt compliance = new StandardsComplianceExtImpl();
				  Object[] obj = (Object[]) results.get(i);
				 compliance.setStdComplianceId(((BigDecimal) obj[0]).longValue());
				 compliance.setStdId(((BigDecimal) obj[1]).longValue());
				 compliance.setRegionCode((String)obj[2]);
				 compliance.setComplianceExpiryRule((String)obj[3]);
				 compliance.setComplianceExpiryDate((Date)obj[4]);
				 compliance.setChainCode((String)obj[5]);
				 compliance.setComplianceRuleMonths(((BigDecimal) obj[6]).longValue());
				 compliance.setRuleDate((String)obj[7]);
				 if(obj[8]!=null)
				 {
					 compliance.setExpiryDate(new SimpleDateFormat("dd-MMM-yyyy").format((Date)obj[8]));
				 }
				 compliance.setComplianceDateString((String)obj[9]);
				 compliance.setExpiryDateString((String)obj[10]);
				 compliance.setCountryCode((String)obj[11]);
				 arlCompliance.add(compliance);
			 }
		
    	}
    	catch(Exception e)
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
		return arlCompliance;
	}
	
	public List<Object> getRegionStatus(long stdId, String chainCd)
	{
		List<Object> results = null;
		Session session = null;
		StringBuffer query = new StringBuffer();
		query.append("SELECT count(br.rgn_cd), br.rgn_cd as rgn_cd,MAX(sc.cmply_expr_rule_cd) as Max_Value,Max(sc.rule_dt_cd) as Max_Rule_Value");
		query.append(" from std s, std_cmply sc,ctry_std cs, brndstnd_ctry bc, brndstnd_rgn br ");	
		query.append(" where s.std_id = sc.std_id and cs.std_id = sc.std_id and   cs.ctry_nm_cd = bc.ctry_nm_cd and 	 sc.ctry_nm_cd = bc.ctry_nm_cd ");	
		query.append("and  bc.rgn_id = br.rgn_id  AND s.stat_desc != 'DELETED' AND  ");
		query.append(" s.std_typ != 'GDLN' AND s.std_id = "+ stdId + " AND chain_cd = '"+ chainCd +"' ");
		query.append("   AND  (sc.cmply_expr_dt IS NOT NULL OR sc.cmply_rule_mo_qty >0)  ");
		query.append("group by (sc.std_id), br.rgn_cd ");
		
		try
		{
			session = openSession();
			SQLQuery q = session.createSQLQuery(query.toString());
			results = q.list();
		}
		catch(Exception e)
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
		return results;
	}
	
	public List<Object> getRegionCmplyExprCount(long stdId, String chainCd,String rgnName,String cmply_expr_value,String rule_cd)
	{
		List<Object> results = null;
		Session session = null;
		StringBuffer query = new StringBuffer();
		
		   
		query.append("Select count(*) from std_cmply sc,std s  where  sc.rule_dt_cd='"+rule_cd+"' AND sc.cmply_expr_rule_cd='"+cmply_expr_value+"'");
		query.append("AND s.std_id = sc.std_id AND sc.std_id="+stdId+" and sc.chain_cd='"+chainCd+"'AND s.stat_desc != 'DELETED'");	
		query.append("AND  s.std_typ != 'GDLN' AND  (sc.cmply_expr_dt IS NOT NULL OR sc.cmply_rule_mo_qty >0)");	
		query.append("AND ctry_nm_cd IN(Select cs.ctry_nm_cd from ctry_std cs,brndstnd_ctry bc where  std_id = "+stdId+" and   cs.ctry_nm_cd = bc.ctry_nm_cd and rgn_id=(Select rgn_id from brndstnd_rgn where rgn_cd='"+rgnName+"' AND PRNT_RGN_ID IS NULL))");
		if(cmply_expr_value.equals("C")&& rule_cd.equals("R")){
			query.append("group by sc.cmply_rule_mo_qty");
			
		}else{
			query.append("group by sc.cmply_expr_dt");
		}
		try
		{
			session = openSession();
			SQLQuery q = session.createSQLQuery(query.toString());
			results = q.list();
		}
		catch(Exception e)
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
		return results;
	}
}
