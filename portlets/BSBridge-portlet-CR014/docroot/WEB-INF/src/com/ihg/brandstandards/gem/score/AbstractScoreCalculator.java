package com.ihg.brandstandards.gem.score;

public abstract class AbstractScoreCalculator
{
    protected long pointsEarned;
    protected long pointsPossible;

    protected int complNumerator;
    protected int complDenominator;
    protected int nonComplNumerator;
    protected int nonComplDenominator;

    public abstract void calculate(long publishId, long rgnId, String brandCode);
    public abstract String calculateScorePercent(long publishId, long rgnId, String brandCode, String bucketId, String importantQty, String criticalQty, String autoFailQty);
    
    public long getPointsEarned()
    {
        return pointsEarned;
    }

    public void setPointsEarned(long pointsEarned)
    {
        this.pointsEarned = pointsEarned;
    }

    public long getPointsPossible()
    {
        return pointsPossible;
    }

    public void setPointsPossible(long pointsPossible)
    {
        this.pointsPossible = pointsPossible;
    }

    public int getComplNumerator()
    {
        return complNumerator;
    }

    public void setComplNumerator(int complNumerator)
    {
        this.complNumerator = complNumerator;
    }

    public int getComplDenominator()
    {
        return complDenominator;
    }

    public void setComplDenominator(int complDenominator)
    {
        this.complDenominator = complDenominator;
    }

    public int getNonComplNumerator()
    {
        return nonComplNumerator;
    }

    public void setNonComplNumerator(int nonComplNumerator)
    {
        this.nonComplNumerator = nonComplNumerator;
    }

    public int getNonComplDenominator()
    {
        return nonComplDenominator;
    }

    public void setNonComplDenominator(int nonComplDenominator)
    {
        this.nonComplDenominator = nonComplDenominator;
    }
}
