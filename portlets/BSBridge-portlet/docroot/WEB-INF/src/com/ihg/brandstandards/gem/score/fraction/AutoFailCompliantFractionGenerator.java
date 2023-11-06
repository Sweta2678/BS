package com.ihg.brandstandards.gem.score.fraction;

public class AutoFailCompliantFractionGenerator extends FractionGenerator
{
    public AutoFailCompliantFractionGenerator()
    {
        numerator = 0;
        denominator = 0;
        maxNumerator = 25;
        maxDenominator = 25;
    }
       
    /**
     * 
     * @return array contains index = 0 -- numerator, index = 1 -- denominator 
     */
    public int[] getNext()
    {
        if (numerator == 0 && denominator == 0)
        {
            int next[] = {numerator, denominator};
            denominator++;
            return next;

        }
        else if (second)
        {
            second = false;
            int next[] = {numerator, denominator};
            return next;
        }
        else
        {
            denominator++;
            int next[] = {numerator, denominator};
            if (denominator >= maxDenominator)
            {
                denominator = 0;
                if (numerator == 0)
                {
                    numerator = 1;
                    second = true;
                }
                else
                {
                    numerator = 0;
                    second = true;
                    int nexta[] = {numerator, denominator};
                    next = nexta;
                }
            }
            return next;
        }
    }

}
