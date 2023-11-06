package com.ihg.brandstandards.custom.gem.model;

public class GEMScoreModel extends BaseGemModel
{
    private long scorPntId;
    private long rgnId;
    private long bucketId;
    private String bucketName;
    private long severityId;
    private String severityName;
    private long cmplNumerator;
    private long cmplDenominator;
    private long nonCmplNumerator;
    private long nonCmplDenominator;
    private long totalMsrmnt;
    private long netMsrmnt;
    private long nonCmplMsrmnt;

    public long getScorPntId()
    {
        return scorPntId;
    }

    public void setScorPntId(long scorPntId)
    {
        this.scorPntId = scorPntId;
    }

    public long getRgnId()
    {
        return rgnId;
    }

    public void setRgnId(long rgnId)
    {
        this.rgnId = rgnId;
    }

    public long getBucketId()
    {
        return bucketId;
    }

    public void setBucketId(long bucketId)
    {
        this.bucketId = bucketId;
    }

    public String getBucketName()
    {
        return bucketName;
    }

    public void setBucketName(String bucketName)
    {
        this.bucketName = bucketName;
    }

    public long getSeverityId()
    {
        return severityId;
    }

    public void setSeverityId(long severityId)
    {
        this.severityId = severityId;
    }

    public long getCmplNumerator()
    {
        return cmplNumerator;
    }

    public void setCmplNumerator(long cmplNumerator)
    {
        this.cmplNumerator = cmplNumerator;
    }

    public long getCmplDenominator()
    {
        return cmplDenominator;
    }

    public void setCmplDenominator(long cmplDenominator)
    {
        this.cmplDenominator = cmplDenominator;
    }

    public long getNonCmplNumerator()
    {
        return nonCmplNumerator;
    }

    public void setNonCmplNumerator(long nonCmplNumerator)
    {
        this.nonCmplNumerator = nonCmplNumerator;
    }

    public long getNonCmplDenominator()
    {
        return nonCmplDenominator;
    }

    public void setNonCmplDenominator(long nonCmplDenominator)
    {
        this.nonCmplDenominator = nonCmplDenominator;
    }

    public long getTotalMsrmnt()
    {
        return totalMsrmnt;
    }

    public void setTotalMsrmnt(long totalMsrmnt)
    {
        this.totalMsrmnt = totalMsrmnt;
    }

    public long getNetMsrmnt()
    {
        return netMsrmnt;
    }

    public void setNetMsrmnt(long netMsrmnt)
    {
        this.netMsrmnt = netMsrmnt;
    }

    public long getNonCmplMsrmnt()
    {
        return nonCmplMsrmnt;
    }

    public void setNonCmplMsrmnt(long nonCmplMsrmnt)
    {
        this.nonCmplMsrmnt = nonCmplMsrmnt;
    }

    public String getSeverityName()
    {
        return severityName;
    }

    public void setSeverityName(String severityName)
    {
        this.severityName = severityName;
    }
}
