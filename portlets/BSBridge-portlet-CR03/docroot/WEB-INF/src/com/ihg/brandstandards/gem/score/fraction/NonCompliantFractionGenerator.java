package com.ihg.brandstandards.gem.score.fraction;

public class NonCompliantFractionGenerator extends FractionGenerator
{
    public NonCompliantFractionGenerator()
    {
        numerator = 0;
        denominator = 0;
        maxNumerator = 25;
        maxDenominator = 25;
        continueLoop = true;
    }
    
    public int[] getNext()
    {
        if ((numerator == maxDenominator - 2 ) && denominator == maxDenominator)
        {
            continueLoop = false;
        }
        if (numerator < denominator)
        {
            numerator++;
            if(denominator == numerator)
            {
                numerator = 0;
                denominator++;
            }
        }
        else if (denominator <= maxDenominator && denominator == numerator)
        {
            denominator++;
            numerator = 0;
        }
        int next[] = {numerator, denominator};
        return next;
    }
}
