package com.ihg.brandstandards.gem.score.fraction;

public class AutoFailNonCompliantFractionGenerator extends FractionGenerator
{
    public AutoFailNonCompliantFractionGenerator()
    {
        numerator = 0;
        denominator = 0;
        maxNumerator = 25;
        maxDenominator = 1000;
    }

    /**
     * 
     * @return array contains 
     */
    public int[] getNext()
    {
         denominator++;
         int next[] = {numerator, denominator};
         return next;
    }

}
