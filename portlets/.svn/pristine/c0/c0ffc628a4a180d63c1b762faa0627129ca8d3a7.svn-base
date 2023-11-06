package com.ihg.brandstandards.db.service.persistence;
import com.ihg.brandstandards.db.model.Department;
import com.ihg.brandstandards.db.model.impl.DepartmentImpl;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.util.List;

public class DepartmentFinderImpl  extends BasePersistenceImpl<Department> implements DepartmentFinder{

	 private static final Log LOG = LogFactoryUtil.getLog(DepartmentFinderImpl.class);
	
	 public Department createDepartment() throws SystemException
	    {
	        Session session = null;
	        Department department = null;
	        
	        try
	        {
	            session = openSession();
	            final String query = "SELECT GEM_DEPT_ID_SEQ.nextval AS GEM_DEPT_ID, '' AS GEM_DEPT_NM, '' AS GEM_DEPT_DESC, 'Y' AS ACTV_IND,"+
	            					  "0 AS CREAT_USR_ID, SYSDATE AS CREAT_TS, 0 AS LST_UPDT_USR_ID, SYSDATE AS LST_UPDT_TS FROM dual";
	            if (LOG.isDebugEnabled()) {
	                LOG.debug("New Department : " + query);
	            }
	            final SQLQuery sqlQuery = session.createSQLQuery(query);
	            sqlQuery.addEntity("Department", DepartmentImpl.class);
	            List<Department> departmentList = sqlQuery.list();
	            department = departmentList.get(0);
	            department.setPrimaryKey(department.getDepartmentId());
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
	        return department;
	    }
	 
	 
	 public Department getActiveDepartmentByName(String deptName, String activeInd) throws SystemException
	    {
	        Session session = null;
	        Department department = null;
	        
	        try
	        {
	            session = openSession();
	            final String query = "Select * from GEM_DEPT where GEM_DEPT_NM='"+deptName+"'";
	            if (LOG.isDebugEnabled()) {
	                LOG.debug("Get Active deparment by Name : " + query);
	            }
	            final SQLQuery sqlQuery = session.createSQLQuery(query);
	            sqlQuery.addEntity("Department", DepartmentImpl.class);
	            List<Department> departmentList = sqlQuery.list();
	            if(departmentList.size()>0){
	            department = departmentList.get(0);
	            department.setPrimaryKey(department.getDepartmentId());
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
	        return department;
	    }
	 public List<Object> getPublicationActiveDepartment(long departmentId, String activeInd)
		{
			List<Object> results = null;
			Session session = null;
			StringBuffer query = new StringBuffer();
			
			   
			query.append("Select count(*) from GEM_DEPT gd, GEM_PUBLISH_DEPT gpd where gpd.GEM_DEPT_ID = gd.GEM_DEPT_ID AND gd.ACTV_IND='"+activeInd+"' AND gd.GEM_DEPT_ID ="+departmentId+"");
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
