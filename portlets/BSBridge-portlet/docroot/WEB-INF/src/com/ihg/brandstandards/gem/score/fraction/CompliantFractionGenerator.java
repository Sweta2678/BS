package com.ihg.brandstandards.gem.score.fraction;

public class CompliantFractionGenerator extends FractionGenerator
{
    public CompliantFractionGenerator()
    {
        numerator = 0;
        denominator = 0;
        maxNumerator = 25;
        maxDenominator = 25;
    }
    
    public int[] getNext()
    {
        numerator++;
        denominator++;
        int next[] = {numerator, denominator};
        return next;
    }
}
