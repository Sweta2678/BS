package com.ihg.brandstandards.gem.score.fraction;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class FractionGenerator
{
	private static final Log LOG = LogFactoryUtil.getLog(FractionGenerator.class);
			
    protected int numerator;
    protected int denominator;
    protected int maxNumerator = 25;
    protected int maxDenominator = 25;
    protected boolean second = true;
    protected boolean continueLoop = true;
    
    
    /**
     * 
     * @return array contains index = 0 -- numerator, index = 1 -- denominator 
     */
    public int[] getNext()
    {

        if (denominator > maxDenominator)
        {
            denominator = 1;
            numerator = 1;
            second = true;
        }
        
        if (numerator == 1 && denominator == 1)
        {
            int next[] = {numerator, denominator};
            denominator++;
            return next;
            
        }
        // workaround to get 1/2
        else if (second)
        {
            second = false;
            int next[] = {numerator, denominator};
            return next;
        }
        else if (numerator == denominator)
        {
            numerator = 1;
            denominator++;
            int next[] = {numerator, denominator};
            return next;
        }
        else if (numerator < denominator)
        {
            numerator++;
            int next[] = {numerator, denominator};
            
            if (denominator >= maxDenominator && numerator >= maxNumerator)
            {
                denominator = 1;
                numerator = 1;
                second = true;
            }
            return next;
        }
        else
        {
            denominator = 1;
            numerator = 1;
            second = true;
            int next[] = {numerator, denominator};
            return next;
        }
/*
    	if (denominator < maxDenominator)
        {
            denominator++;
        }
        else if (numerator < maxDenominator && denominator >= maxDenominator)
        {
            numerator++;
            if (numerator < maxDenominator)
            {
                denominator = numerator + 1;
            }
        }
        LOG.debug("numerator = " + numerator + " denominator = " + denominator);
        int next[] = {numerator, denominator};
        return next;
*/
    }

    public int getNumerator()
    {
        return numerator;
    }

    public void setNumerator(int numerator)
    {
        this.numerator = numerator;
    }

    public int getDenominator()
    {
        return denominator;
    }

    public void setDenominator(int denominator)
    {
        this.denominator = denominator;
    }

    public int getMaxNumerator()
    {
        return maxNumerator;
    }

    public void setMaxNumerator(int maxNumerator)
    {
        this.maxNumerator = maxNumerator;
    }

    public int getMaxDenominator()
    {
        return maxDenominator;
    }

    public void setMaxDenominator(int maxDenominator)
    {
        this.maxDenominator = maxDenominator;
    }

    public boolean isContinueLoop()
    {
        return continueLoop;
    }

    public void setContinueLoop(boolean continueLoop)
    {
        this.continueLoop = continueLoop;
    }
}
