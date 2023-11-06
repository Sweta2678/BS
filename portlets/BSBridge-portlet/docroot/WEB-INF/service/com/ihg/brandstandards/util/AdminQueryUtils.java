package com.ihg.brandstandards.util;


/**
 * All custom queries for BSAdmin portlet are written here.
 */
public class AdminQueryUtils extends QueryUtils
{
	
	public static String assignStandardsAttributToCountry(String fromCountryCode, String toCountryCode){
		
		StringBuffer query = new StringBuffer();
		
		query.append("DECLARE CURSOR CUR_STD_CTR_ID IS ");
		query.append("SELECT * FROM CTRY_STD CS WHERE CS.CTRY_NM_CD = ");
		query.append("'"+fromCountryCode+"'");
		query.append(" ; ");
		query.append("V_STD_ROW  CTRY_STD%ROWTYPE; ");
		query.append("V_TO_CTRY_CD VARCHAR(3):= '"+toCountryCode+"' ; ");
		query.append(" V_SN INT; ");
		
		query.append("BEGIN ");
		query.append("OPEN CUR_STD_CTR_ID; ");
		query.append("LOOP ");
		query.append("BEGIN ");
		query.append("FETCH CUR_STD_CTR_ID INTO V_STD_ROW; ");
		query.append("SELECT COUNT(STD_ID) INTO V_SN FROM CTRY_STD WHERE CTRY_NM_CD = V_TO_CTRY_CD AND STD_ID = V_STD_ROW.STD_ID ; ");
		
		query.append("IF(V_SN=0) THEN ");
		query.append("INSERT INTO CTRY_STD(STD_ID, CTRY_NM_CD, CREAT_USR_ID, CREAT_TS, LST_UPDT_USR_ID, LST_UPDT_TS) ");
		query.append("VALUES(V_STD_ROW.STD_ID, V_TO_CTRY_CD, V_STD_ROW.CREAT_USR_ID, V_STD_ROW.CREAT_TS, V_STD_ROW.LST_UPDT_USR_ID, V_STD_ROW.LST_UPDT_TS) ; ");
		query.append("END IF; ");
		query.append("EXIT WHEN CUR_STD_CTR_ID%NOTFOUND; ");
		
		query.append("EXCEPTION WHEN OTHERS THEN ");
		query.append("ROLLBACK; ");
		query.append("END; ");
		query.append("END LOOP; ");
		query.append("COMMIT; ");
		query.append("END; ");
		
		return query.toString();
		
	}
	
	public static String assignAttachementAttributeToCountry(String fromCountryCode, String toCountryCode){

		StringBuffer query = new StringBuffer();
		
		query.append("DECLARE  CURSOR CUR_ATTACH_CTR_ID IS ");
		query.append("SELECT * FROM STD_ATTACHMENT_CTRY SA WHERE SA.CTRY_NM_CD = ");
		query.append("'"+fromCountryCode+"' ");
		query.append(" AND SA.STD_ATTACHEMENT_ID IN (SELECT STD_ATTACHEMENT_ID FROM STD_ATTACHMENT WHERE STD_ID IN ( ");
		query.append("SELECT CS.STD_ID FROM CTRY_STD CS WHERE CS.CTRY_NM_CD = ");
		query.append("'"+fromCountryCode+"' ");
		query.append(" INTERSECT SELECT CT.STD_ID FROM CTRY_STD CT WHERE CT.CTRY_NM_CD = ");
		query.append("'"+toCountryCode+"'");
		query.append(" ) ) ; ");
		
		query.append("V_ATTACHMENT_ROW  STD_ATTACHMENT_CTRY%ROWTYPE; ");
		query.append("V_TO_CTRY_CD VARCHAR(3):= '"+toCountryCode+"' ; ");
		query.append("V_SN INT; ");
		query.append("BEGIN ");
		query.append("OPEN CUR_ATTACH_CTR_ID; ");
		query.append("LOOP ");
		
		query.append("BEGIN ");
		query.append("FETCH CUR_ATTACH_CTR_ID INTO V_ATTACHMENT_ROW; ");
		query.append("SELECT COUNT(STD_ATTACHEMENT_ID) INTO V_SN FROM STD_ATTACHMENT_CTRY WHERE ");
		query.append("STD_ATTACHEMENT_ID = V_ATTACHMENT_ROW.STD_ATTACHEMENT_ID AND ");
		query.append("CTRY_NM_CD=V_TO_CTRY_CD; ");
		
		query.append("IF(V_SN=0) THEN ");
		query.append("INSERT INTO STD_ATTACHMENT_CTRY(STD_ATTACHEMENT_ID, LOCALE_CD, CTRY_NM_CD, CREAT_USR_ID, CREAT_TS, LST_UPDT_USR_ID, LST_UPDT_TS) ");
		query.append("VALUES(V_ATTACHMENT_ROW.STD_ATTACHEMENT_ID, V_ATTACHMENT_ROW.LOCALE_CD, V_TO_CTRY_CD, V_ATTACHMENT_ROW.CREAT_USR_ID, ");
		query.append("V_ATTACHMENT_ROW.CREAT_TS, V_ATTACHMENT_ROW.LST_UPDT_USR_ID, V_ATTACHMENT_ROW.LST_UPDT_TS); ");
		query.append("END IF; ");
		
		query.append("EXIT WHEN CUR_ATTACH_CTR_ID%NOTFOUND; ");
		query.append("EXCEPTION WHEN OTHERS THEN ");
		query.append("ROLLBACK; ");
		query.append("END; ");
		query.append("END LOOP; ");
		query.append("COMMIT; ");
		query.append("END;");
		
		return query.toString();
		
	}
	
	public static String assignLinkAttributeToCountry(String fromCountryCode, String toCountryCode){
		
		StringBuffer query = new StringBuffer();
		
		query.append("DECLARE CURSOR CUR_LINK_CTR_ID IS ");
		query.append("SELECT * FROM STD_LINK_CTRY SC WHERE SC.CTRY_NM_CD = ");
		query.append("'"+fromCountryCode+"' ");
		query.append("AND SC.STD_EXTL_LINK_ID IN ( ");
		query.append("SELECT STD_EXTL_LINK_ID FROM STD_EXTL_LINK WHERE STD_ID IN ( ");
		query.append("SELECT CS.STD_ID FROM CTRY_STD CS WHERE CS.CTRY_NM_CD = ");
		query.append("'"+fromCountryCode+"' ");
		query.append("INTERSECT SELECT CT.STD_ID FROM CTRY_STD CT WHERE CT.CTRY_NM_CD = ");
		query.append("'"+toCountryCode+"'");
		query.append(" ) ); ");
		
		query.append("V_LINK_ROW  STD_LINK_CTRY%ROWTYPE; ");
		query.append("V_TO_CTRY_CD VARCHAR(3):='"+toCountryCode+"' ; ");
		query.append(" V_SN INT; ");
		query.append("BEGIN ");
		query.append("OPEN CUR_LINK_CTR_ID; ");
		
		query.append("LOOP ");
		query.append("BEGIN ");
		query.append("FETCH CUR_LINK_CTR_ID INTO V_LINK_ROW; ");
		query.append("SELECT COUNT(STD_EXTL_LINK_ID) INTO V_SN FROM STD_LINK_CTRY WHERE STD_EXTL_LINK_ID = V_LINK_ROW.STD_EXTL_LINK_ID AND CTRY_NM_CD = V_TO_CTRY_CD; ");
		query.append("IF(V_SN=0) THEN ");
		
		query.append("INSERT INTO STD_LINK_CTRY(STD_EXTL_LINK_ID, CTRY_NM_CD, CREAT_USR_ID, CREAT_TS, LST_UPDT_USR_ID, LST_UPDT_TS) ");
		query.append("VALUES (V_LINK_ROW.STD_EXTL_LINK_ID, V_TO_CTRY_CD, V_LINK_ROW.CREAT_USR_ID, V_LINK_ROW.CREAT_TS, V_LINK_ROW.LST_UPDT_USR_ID, V_LINK_ROW.LST_UPDT_TS); ");
		query.append("END IF; ");
		query.append("EXIT WHEN CUR_LINK_CTR_ID%NOTFOUND; ");
		
		query.append("EXCEPTION WHEN OTHERS THEN ");
		query.append("ROLLBACK; ");
		query.append("END; ");
		query.append("END LOOP; ");
		query.append("COMMIT; ");
		query.append("END;");
		
		return query.toString();
	}
	
	public static String assignImageAttributeToCountry(String fromCountryCode, String toCountryCode){
		
		StringBuffer query = new StringBuffer();
		
		query.append("DECLARE CURSOR CUR_IMG_CTR_ID IS ");
		query.append("SELECT  * FROM STD_IMAGE_CTRY SI  WHERE SI.CTRY_NM_CD = ");
		query.append("'"+fromCountryCode+"'");
		query.append("AND SI.STD_IMAGE_ID IN ( ");
		query.append("SELECT STD_IMAGE_ID FROM STD_IMAGE WHERE STD_ID IN ( ");
		query.append("SELECT CS.STD_ID FROM CTRY_STD CS WHERE CS.CTRY_NM_CD = ");
		query.append("'"+fromCountryCode+"'");
		query.append(" INTERSECT SELECT CT.STD_ID FROM CTRY_STD CT WHERE CT.CTRY_NM_CD = ");
		query.append("'"+toCountryCode+"'");
		query.append(" ) ); ");
		
		query.append("V_ROW  STD_IMAGE_CTRY%ROWTYPE; ");
		query.append("V_CTRY_CD VARCHAR(3):= '"+toCountryCode+"'; ");
		query.append("V_SN INT; ");
		query.append("BEGIN ");
		query.append("OPEN CUR_IMG_CTR_ID; ");
		
		query.append("LOOP ");
		query.append("BEGIN ");
		query.append("FETCH CUR_IMG_CTR_ID INTO V_ROW; ");
		query.append("SELECT COUNT(STD_IMAGE_ID) INTO V_SN FROM STD_IMAGE_CTRY WHERE ");
		query.append("STD_IMAGE_ID = V_ROW.STD_IMAGE_ID and CTRY_NM_CD=V_CTRY_CD; ");
		
		query.append("IF(V_SN=0) THEN ");
		query.append("INSERT INTO STD_IMAGE_CTRY (STD_IMAGE_ID,CTRY_NM_CD,CREAT_USR_ID,CREAT_TS,LST_UPDT_USR_ID,LST_UPDT_TS) ");
		query.append("VALUES (V_ROW.STD_IMAGE_ID,V_CTRY_CD,V_ROW.CREAT_USR_ID,V_ROW.CREAT_TS,V_ROW.LST_UPDT_USR_ID,V_ROW.LST_UPDT_TS); ");
		query.append("END IF; ");
		
		query.append("EXIT WHEN CUR_IMG_CTR_ID%NOTFOUND; ");
		query.append("EXCEPTION WHEN OTHERS THEN ");
		query.append("ROLLBACK; ");
		query.append("END; ");
		query.append("END LOOP; ");
		query.append("COMMIT; ");
		query.append("END;");
		
		return query.toString();
	}
	
	public static String assignExpiryDateToCountry(String fromCountryCode, String toCountryCode)
	{
		
		StringBuffer query = new StringBuffer();
		
		query.append(" DECLARE CURSOR CUR_CMPLDATE_CTR_ID IS");
		query.append(" SELECT * FROM STD_CMPLY SC WHERE SC.RULE_DT_CD = 'D' AND SC.CMPLY_EXPR_RULE_CD = 'E' AND SC.CTRY_NM_CD = ");
		query.append("'"+fromCountryCode+"' ");
		query.append(" AND SC.STD_ID IN ( ");
		query.append(" SELECT CS.STD_ID FROM CTRY_STD CS WHERE CS.CTRY_NM_CD = ");
		query.append("'"+fromCountryCode+"' ");
		query.append(" INTERSECT SELECT CT.STD_ID FROM CTRY_STD CT WHERE CT.CTRY_NM_CD = ");
		query.append("'"+toCountryCode+"' ); ");
		
		query.append(" V_CMPLDATE_ROW STD_CMPLY%ROWTYPE;");
		query.append(" V_TO_CTRY_CD VARCHAR(3):= ");
		query.append(" '"+toCountryCode+"' ; ");
		query.append(" V_STD_CMPLY_REC_COUNT NUMBER(3) :=0 ; ");
		
		query.append(" BEGIN OPEN CUR_CMPLDATE_CTR_ID; ");
		query.append(" LOOP BEGIN");
		query.append(" FETCH CUR_CMPLDATE_CTR_ID INTO V_CMPLDATE_ROW;");
		query.append(" EXIT WHEN CUR_CMPLDATE_CTR_ID%NOTFOUND;");
		  
		query.append(" SELECT COUNT(*) INTO V_STD_CMPLY_REC_COUNT FROM STD_CMPLY SC");
		query.append(" WHERE SC.STD_ID   = V_CMPLDATE_ROW.STD_ID");
		query.append(" AND SC.CTRY_NM_CD = V_TO_CTRY_CD");
		query.append(" AND SC.CHAIN_CD = V_CMPLDATE_ROW.CHAIN_CD;");
		      
		query.append(" IF (V_STD_CMPLY_REC_COUNT > 0) THEN");
		query.append(" UPDATE STD_CMPLY SET CMPLY_EXPR_DT = V_CMPLDATE_ROW.CMPLY_EXPR_DT, CMPLY_EXPR_RULE_CD = V_CMPLDATE_ROW.CMPLY_EXPR_RULE_CD WHERE STD_ID = V_CMPLDATE_ROW.STD_ID");
		query.append(" AND CTRY_NM_CD    = V_TO_CTRY_CD");
		query.append(" AND CHAIN_CD = V_CMPLDATE_ROW.CHAIN_CD;");
		        
		query.append(" ELSE INSERT INTO STD_CMPLY (");
		query.append(" STD_CMPLY_ID,STD_ID, CTRY_NM_CD, CHAIN_CD, CMPLY_EXPR_DT, CMPLY_EXPR_RULE_CD, CMPLY_RULE_MO_QTY, RULE_DT_CD, CREAT_USR_ID, CREAT_TS,LST_UPDT_USR_ID, LST_UPDT_TS )");
		query.append(" VALUES (");
		query.append(" (select max(STD_CMPLY_ID) + 1 from STD_CMPLY), V_CMPLDATE_ROW.STD_ID, V_TO_CTRY_CD, V_CMPLDATE_ROW.CHAIN_CD, ");
		query.append(" V_CMPLDATE_ROW.CMPLY_EXPR_DT, V_CMPLDATE_ROW.CMPLY_EXPR_RULE_CD, V_CMPLDATE_ROW.CMPLY_RULE_MO_QTY, V_CMPLDATE_ROW.RULE_DT_CD,");
		query.append(" V_CMPLDATE_ROW.CREAT_USR_ID, V_CMPLDATE_ROW.CREAT_TS, V_CMPLDATE_ROW.LST_UPDT_USR_ID, V_CMPLDATE_ROW.LST_UPDT_TS);");

		query.append(" END IF;");
		query.append(" EXCEPTION WHEN OTHERS THEN ROLLBACK;");
		query.append(" END; END LOOP;");
		query.append(" COMMIT; END; "); 
		      
		return query.toString();
	}
	
	public static String assignComplianceDateToCountry(String fromCountryCode, String toCountryCode)
	{
		
		StringBuffer query = new StringBuffer();
		
		query.append(" DECLARE CURSOR CUR_CMPLDATE_CTR_ID IS");
		query.append(" SELECT * FROM STD_CMPLY SC WHERE SC.RULE_DT_CD = 'D' AND SC.CMPLY_EXPR_RULE_CD = 'C' AND SC.CTRY_NM_CD = ");
		query.append("'"+fromCountryCode+"' ");
		query.append(" AND SC.STD_ID IN ( ");
		query.append(" SELECT CS.STD_ID FROM CTRY_STD CS WHERE CS.CTRY_NM_CD = ");
		query.append("'"+fromCountryCode+"' ");
		query.append(" INTERSECT SELECT CT.STD_ID FROM CTRY_STD CT WHERE CT.CTRY_NM_CD = ");
		query.append("'"+toCountryCode+"' ); ");
		
		query.append(" V_CMPLDATE_ROW STD_CMPLY%ROWTYPE;");
		query.append(" V_TO_CTRY_CD VARCHAR(3):= ");
		query.append(" '"+toCountryCode+"' ; ");
		query.append(" V_STD_CMPLY_REC_COUNT NUMBER(3) :=0 ; ");
		
		query.append(" BEGIN OPEN CUR_CMPLDATE_CTR_ID; ");
		query.append(" LOOP BEGIN");
		query.append(" FETCH CUR_CMPLDATE_CTR_ID INTO V_CMPLDATE_ROW;");
		query.append(" EXIT WHEN CUR_CMPLDATE_CTR_ID%NOTFOUND;");
		  
		query.append(" SELECT COUNT(*) INTO V_STD_CMPLY_REC_COUNT FROM STD_CMPLY SC");
		query.append(" WHERE SC.STD_ID   = V_CMPLDATE_ROW.STD_ID");
		query.append(" AND SC.CTRY_NM_CD = V_TO_CTRY_CD");
		query.append(" AND SC.CHAIN_CD = V_CMPLDATE_ROW.CHAIN_CD;");
		      
		query.append(" IF (V_STD_CMPLY_REC_COUNT > 0) THEN");
		query.append(" UPDATE STD_CMPLY SET CMPLY_EXPR_DT = V_CMPLDATE_ROW.CMPLY_EXPR_DT, CMPLY_EXPR_RULE_CD = V_CMPLDATE_ROW.CMPLY_EXPR_RULE_CD WHERE STD_ID = V_CMPLDATE_ROW.STD_ID");
		query.append(" AND CTRY_NM_CD    = V_TO_CTRY_CD");
		query.append(" AND CHAIN_CD = V_CMPLDATE_ROW.CHAIN_CD;");
		        
		query.append(" ELSE INSERT INTO STD_CMPLY (");
		query.append(" STD_CMPLY_ID,STD_ID, CTRY_NM_CD, CHAIN_CD, CMPLY_EXPR_DT, CMPLY_EXPR_RULE_CD, CMPLY_RULE_MO_QTY, RULE_DT_CD, CREAT_USR_ID, CREAT_TS,LST_UPDT_USR_ID, LST_UPDT_TS )");
		query.append(" VALUES (");
		query.append(" (select max(STD_CMPLY_ID) + 1 from STD_CMPLY), V_CMPLDATE_ROW.STD_ID, V_TO_CTRY_CD, V_CMPLDATE_ROW.CHAIN_CD, ");
		query.append(" V_CMPLDATE_ROW.CMPLY_EXPR_DT, V_CMPLDATE_ROW.CMPLY_EXPR_RULE_CD, V_CMPLDATE_ROW.CMPLY_RULE_MO_QTY, V_CMPLDATE_ROW.RULE_DT_CD,");
		query.append(" V_CMPLDATE_ROW.CREAT_USR_ID, V_CMPLDATE_ROW.CREAT_TS, V_CMPLDATE_ROW.LST_UPDT_USR_ID, V_CMPLDATE_ROW.LST_UPDT_TS);");
	
		query.append(" END IF;");
		query.append(" EXCEPTION WHEN OTHERS THEN ROLLBACK;");
		query.append(" END; END LOOP;");
		query.append(" COMMIT; END; "); 
		      
		return query.toString();
	}

	public static String commonStdCount(String fromCountryCode, String toCountryCode){
		
		StringBuffer query = new StringBuffer();
		query.append(" WITH STDID AS (");
		query.append(" SELECT CS.STD_ID FROM CTRY_STD CS WHERE CS.CTRY_NM_CD = ");
		query.append("'"+fromCountryCode+"'");
		query.append(" INTERSECT ");
		query.append(" SELECT CT.STD_ID FROM CTRY_STD CT WHERE CT.CTRY_NM_CD = ");
		query.append("'"+toCountryCode+"' ) ");
		query.append(" SELECT COUNT(*) AS myCount FROM STDID");
		
		return query.toString();
	}
}
