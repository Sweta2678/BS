package com.ihg.brandstandards.gem.score;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.math.NumberUtils;

import com.ihg.brandstandards.custom.gem.model.GEMScoreModel;
import com.ihg.brandstandards.db.model.GEMManagementBucket;
import com.ihg.brandstandards.db.service.GEMManagementBucketLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMQlReportLocalServiceUtil;
import com.ihg.brandstandards.gem.score.fraction.FractionGenerator;
import com.ihg.brandstandards.gem.score.fraction.FractionGeneratorConstants;
import com.ihg.brandstandards.gem.score.fraction.FractionGeneratorFactory;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class GEMScore extends AbstractScoreCalculator
{
    private static final Log LOG = LogFactoryUtil.getLog(GEMScore.class);
    
    private static final float MIN_COMPL_PST = 85.0F;
    private static final float MAX_NON_COMPL_PST = 15.0F;
    
    // score = pointsEarned/pointsPossible
    
    //Compliant == 1 pointsEarned / 1 pointsPossible
    //NonCompliant  == X pointsEarned / Y pointsPossible
    
    //Score (NrCompl(1pt) + NrNonCompl(X))/(NrCompl(1pt) + NrNonCompl(Y))
    
    
    @Override
    public void calculate(long publishId, long rgnId, String brandCode)
    {
        List<GEMScoreModel> scoringPoints = GEMQlReportLocalServiceUtil.getScoringPoints(publishId, rgnId);
        List<Long> bucketIds = new ArrayList<Long>();
        for (GEMScoreModel point : scoringPoints)
        {
        	if (!bucketIds.contains(point.getBucketId()))
        	{
        		bucketIds.add(point.getBucketId());
        	}
        }
        
        for (long bucketId : bucketIds )
        {
            List<GEMScoreModel> bktPoints = getBucketPoints(scoringPoints, bucketId);
            calculateScoring(bktPoints);
        }
        GEMQlReportLocalServiceUtil.setScoringPoints(scoringPoints);
    }
    
    @Override
    public String calculateScorePercent(long publishId, long rgnId, String brandCode, String bucketId, String importantQty, String criticalQty, String autoFailQty)
    {
        List<GEMScoreModel> scoringPoints = GEMQlReportLocalServiceUtil.getScoringPoints(publishId, rgnId);
        long importantNonCmpl = NumberUtils.toLong(importantQty);
        long criticalNonCmpl = NumberUtils.toLong(criticalQty);
        long autoFailNonCmpl = NumberUtils.toLong(autoFailQty);
        long bktId = NumberUtils.toLong(bucketId);
        
        List<GEMScoreModel> bktPoints = getBucketPoints(scoringPoints, bktId);
        String scorePercent = calculateScorePercent(bktPoints, bktId, importantNonCmpl, criticalNonCmpl, autoFailNonCmpl);
        return scorePercent;
    }

	private List<GEMScoreModel> getBucketPoints(List<GEMScoreModel> scoringPoints, long bucketId) 
	{
		List<GEMScoreModel> bktPoints = new ArrayList<GEMScoreModel>();

		if (!scoringPoints.isEmpty()) 
		{
			for (GEMScoreModel point : scoringPoints)
			{
				if (point.getBucketId() == bucketId) 
				{
					bktPoints.add(point);
				}
			}
		}
		return bktPoints;
	}
	
    private void calculateScoring(List<GEMScoreModel> bktPoints)
    {
//        FractionGenerator complGeneratorAutoFail = FractionGeneratorFactory.getFractionGenerator(FractionGeneratorConstants.GEN_TYPE_AUTO_FAIL_COMPLIANT); 
        FractionGenerator nonComplGeneratorAutoFail = FractionGeneratorFactory.getFractionGenerator(FractionGeneratorConstants.GEN_TYPE_AUTO_FAIL_NON_COMPLIANT);
        FractionGenerator complGeneratorImportant = FractionGeneratorFactory.getFractionGenerator(FractionGeneratorConstants.GEN_TYPE_IMPORTANT_COMPLIANT); 
        FractionGenerator nonComplGeneratorImportant = FractionGeneratorFactory.getFractionGenerator(FractionGeneratorConstants.GEN_TYPE_IMPORTANT_NON_COMPLIANT);
//        FractionGenerator complGeneratorCritical = FractionGeneratorFactory.getFractionGenerator(FractionGeneratorConstants.GEN_TYPE_CRITICAL_COMPLIANT); 
        FractionGenerator nonComplGeneratorCritical = FractionGeneratorFactory.getFractionGenerator(FractionGeneratorConstants.GEN_TYPE_CRITICAL_NON_COMPLIANT);
        
        GEMScoreModel important = getScorePointBySeverity(bktPoints, "Important");
        GEMScoreModel critical = getScorePointBySeverity(bktPoints, "Critical");
        GEMScoreModel autoFail = getScorePointBySeverity(bktPoints, "Auto Fail");

        float importantPrcnt = 0;
        float criticalPrcnt = 0;

        // Important
        if (important.getTotalMsrmnt() == 0)
        {
            important.setCmplNumerator(0);
            important.setCmplDenominator(0);
            important.setNonCmplNumerator(0);
            important.setNonCmplDenominator(0);
        }
        else
        {
            double totlNonCmply = Math.ceil(0.15 * important.getTotalMsrmnt());
            boolean stop = false;
            for ( ; (complGeneratorImportant.getNumerator() <= complGeneratorImportant.getMaxDenominator() && 
                    complGeneratorImportant.getDenominator() <= complGeneratorImportant.getMaxDenominator());  )
            {
                int compl[] = complGeneratorImportant.getNext();
                int cmplNumerator = compl[0];
                int cmplDenominator = compl[1];
                
                for ( ; (nonComplGeneratorImportant.getNumerator() < nonComplGeneratorImportant.getMaxDenominator() && 
                        nonComplGeneratorImportant.getDenominator() <= nonComplGeneratorImportant.getMaxDenominator() && nonComplGeneratorImportant.isContinueLoop());  )
                {
                    int nonCompl[] = nonComplGeneratorImportant.getNext();
                    int nonCmplNumerator = nonCompl[0];
                    int nonCmplDenominator = nonCompl[1];
                    // miss more then 15%
                    importantPrcnt = (float)( ((totlNonCmply * nonCmplNumerator) + 
                            ((important.getTotalMsrmnt() - (totlNonCmply)) * cmplNumerator) + 
                            (critical.getTotalMsrmnt()) + (autoFail.getTotalMsrmnt()) )
                            / 
                            ((totlNonCmply * nonCmplDenominator) + 
                            ((important.getTotalMsrmnt() - (totlNonCmply)) * cmplDenominator) + 
                            (critical.getTotalMsrmnt()) + (autoFail.getTotalMsrmnt()) ) ) * 100; 
                    
                    // miss less then 15%
                    float imortantPassPrcnt = (float)( (((totlNonCmply-1) * nonCmplNumerator) + 
                            ((important.getTotalMsrmnt() - (totlNonCmply-1)) * cmplNumerator) + 
                            (critical.getTotalMsrmnt()) + (autoFail.getTotalMsrmnt()) )
                            / 
                            (((totlNonCmply-1) * nonCmplDenominator) + 
                            ((important.getTotalMsrmnt() - (totlNonCmply-1)) * cmplDenominator) + 
                            (critical.getTotalMsrmnt()) + (autoFail.getTotalMsrmnt()) ) ) * 100; 
                    
                    if (importantPrcnt < MIN_COMPL_PST && imortantPassPrcnt > MIN_COMPL_PST)
                    {
                        important.setCmplNumerator(cmplNumerator);
                        important.setCmplDenominator(cmplDenominator);
                        important.setNonCmplNumerator(nonCmplNumerator);
                        important.setNonCmplDenominator(nonCmplDenominator);
                        stop = true;
                        break;
                    }
                }
                if (stop)
                {
                    break;
                }
            }  
        }

        // critical
        if (critical.getTotalMsrmnt() == 0)
        {
            critical.setCmplNumerator(0);
            critical.setCmplDenominator(0);
            critical.setNonCmplNumerator(0);
            critical.setNonCmplDenominator(0);
        }
        else
        {
            double totlNonCmply = Math.ceil(0.15 * critical.getTotalMsrmnt());
            int cmplNumerator = 1; 
            int cmplDenominator = 1; 
            
            for ( ; (nonComplGeneratorCritical.getNumerator() < nonComplGeneratorCritical.getMaxDenominator() && 
                    nonComplGeneratorCritical.getDenominator() <= nonComplGeneratorCritical.getMaxDenominator() && nonComplGeneratorCritical.isContinueLoop());  )
            {
                int nonCompl[] = nonComplGeneratorCritical.getNext();
                int nonCmplNumerator = nonCompl[0];
                int nonCmplDenominator = nonCompl[1];
                
                criticalPrcnt = (float)( ((totlNonCmply * nonCmplNumerator) + 
                        ((critical.getTotalMsrmnt() - (totlNonCmply)) * cmplNumerator) + 
                        (important.getTotalMsrmnt() * important.getCmplNumerator()) + (autoFail.getTotalMsrmnt()) )
                        / 
                        ((totlNonCmply * nonCmplDenominator) + 
                        ((critical.getTotalMsrmnt() - (totlNonCmply)) * cmplDenominator) + 
                        (important.getTotalMsrmnt() * important.getCmplDenominator()) + (autoFail.getTotalMsrmnt()) ) ) * 100; 
                
                // miss less then 15%
                float criticalPassPrcnt = (float)( (((totlNonCmply-1) * nonCmplNumerator) + 
                        ((critical.getTotalMsrmnt() - (totlNonCmply-1)) * cmplNumerator) + 
                        (important.getTotalMsrmnt() * important.getCmplNumerator()) + (autoFail.getTotalMsrmnt()) )
                        / 
                        (((totlNonCmply-1) * nonCmplDenominator) + 
                        ((critical.getTotalMsrmnt() - (totlNonCmply-1)) * cmplDenominator) + 
                        (important.getTotalMsrmnt() * important.getCmplDenominator()) + (autoFail.getTotalMsrmnt()) ) ) * 100; 
                
                if (criticalPrcnt < MIN_COMPL_PST && criticalPassPrcnt > MIN_COMPL_PST)
                {
                    critical.setCmplNumerator(cmplNumerator);
                    critical.setCmplDenominator(cmplDenominator);
                    critical.setNonCmplNumerator(nonCmplNumerator);
                    critical.setNonCmplDenominator(nonCmplDenominator);
                    break;
                }
            }
        }
        
        // Auto Fail
        if (autoFail.getTotalMsrmnt() == 0)
        {
            autoFail.setCmplNumerator(0);
            autoFail.setCmplDenominator(0);
            autoFail.setNonCmplNumerator(0);
            autoFail.setNonCmplDenominator(0);
        }
        else
        {
            for ( ; nonComplGeneratorAutoFail.getDenominator() <= nonComplGeneratorAutoFail.getMaxDenominator();  )
            {
                int nonCompl[] = nonComplGeneratorAutoFail.getNext();
                int nonCmplNumerator = nonCompl[0];
                int nonCmplDenominator = nonCompl[1];
                
                float autoFailPrcnt = (float)
                        ( (float)((important.getTotalMsrmnt() * important.getCmplNumerator()) + critical.getTotalMsrmnt() + (autoFail.getTotalMsrmnt() - 1) + 0 ) * 100
                        /
                        (float)((important.getTotalMsrmnt() * important.getCmplDenominator()) + critical.getTotalMsrmnt() + (autoFail.getTotalMsrmnt()) + nonCmplDenominator ) );
                
                if (autoFailPrcnt < MIN_COMPL_PST)
                {
                    if ( autoFail.getTotalMsrmnt() > 0)
                    {
                        autoFail.setCmplNumerator(important.getCmplNumerator());
                        autoFail.setCmplDenominator(important.getCmplDenominator());
                    }
                    else 
                    {
                        autoFail.setCmplNumerator(0);
                        autoFail.setCmplDenominator(0);
                    }
                    autoFail.setNonCmplNumerator(nonCmplNumerator);
                    autoFail.setNonCmplDenominator(nonCmplDenominator);
                    break;
                }
            }
        }
    }
    
    private GEMScoreModel getScorePointBySeverity(List<GEMScoreModel> bktPoints, String severityNm)
    {
    	GEMScoreModel result = null;
        for (GEMScoreModel point : bktPoints)
        {
        	if (point.getSeverityName().equals(severityNm))
			{
        		result = point;
        		break;
			}
        }  
        return result;
    }
       
    private String calculateScorePercent(List<GEMScoreModel> scoringPoints, long bucketId, long importantNonCmpl, long criticalNonCmpl, long autoFailNonCmpl)
    {
        String scorePercent = "100";
        
        String bucketName = scoringPoints.isEmpty() ? null : scoringPoints.get(0).getBucketName();
        
        if( !"IHG WAY".equalsIgnoreCase(bucketName) && (importantNonCmpl > 0 || criticalNonCmpl > 0 || autoFailNonCmpl > 0))
        {
            float importantTotalNumerator = 0;
            float importantTotalDenominator = 0;
            float criticalTotalNumerator = 0;
            float criticalTotalDenominator = 0;
            float autoFailTotalNumerator = 0;
            float autoFailTotalDenominator = 0;
            
            for (GEMScoreModel point : scoringPoints)
            {
                if (bucketId == point.getBucketId())
                {
                    if ("Important".equals(point.getSeverityName()))
                    {
                        long total = point.getTotalMsrmnt() - importantNonCmpl;
                        importantTotalNumerator = (total * point.getCmplNumerator()  + importantNonCmpl * point.getNonCmplNumerator());
                        importantTotalDenominator = (total * point.getCmplDenominator() + importantNonCmpl * point.getNonCmplDenominator());
                    }
                    else if ("Critical".equals(point.getSeverityName()))
                    {
                        long total = point.getTotalMsrmnt() - criticalNonCmpl;
                        criticalTotalNumerator = (total + criticalNonCmpl * point.getNonCmplNumerator());
                        criticalTotalDenominator = (total + criticalNonCmpl * point.getNonCmplDenominator());
                    }
                    else if ("Auto Fail".equals(point.getSeverityName()))
                    {
                        long total = point.getTotalMsrmnt();
                        autoFailTotalNumerator = (total - autoFailNonCmpl);
                        autoFailTotalDenominator = (total + autoFailNonCmpl * point.getNonCmplDenominator());
                    }
                }
            }
            float totalNumerator = importantTotalNumerator + criticalTotalNumerator + autoFailTotalNumerator;
            float totalDenominator = importantTotalDenominator + criticalTotalDenominator + autoFailTotalDenominator;
            
            if (totalDenominator > 0)
            {
                float totalPercent = round( (totalNumerator/totalDenominator * 100), 2);
                if (totalPercent > 0)
                {
                    scorePercent = String.valueOf(totalPercent);
                }
            }
        }
        
        return scorePercent + "%";
    }
    
    public float round(float d, int decimalPlace) 
    {
        return BigDecimal.valueOf(d).setScale(decimalPlace, BigDecimal.ROUND_HALF_UP).floatValue();
   }
}
