package com.ihg.brandstandards.gem.score.fraction;

public class FractionGeneratorFactory
{
    
    public static FractionGenerator getFractionGenerator(int type)
    {
        FractionGenerator generator;
        
        if (type == FractionGeneratorConstants.GEN_TYPE_IMPORTANT_COMPLIANT)
        {
            generator = new CompliantFractionGenerator();
        }
        else if (type == FractionGeneratorConstants.GEN_TYPE_IMPORTANT_NON_COMPLIANT)
        {
            generator = new NonCompliantFractionGenerator();
        }
        else if (type == FractionGeneratorConstants.GEN_TYPE_CRITICAL_COMPLIANT)
        {
            generator = new CompliantFractionGenerator();
        }
        else if (type == FractionGeneratorConstants.GEN_TYPE_CRITICAL_NON_COMPLIANT)
        {
            generator = new NonCompliantFractionGenerator();
        }
        else if (type == FractionGeneratorConstants.GEN_TYPE_AUTO_FAIL_COMPLIANT)
        {
            generator = new AutoFailCompliantFractionGenerator();
        }
        else if (type == FractionGeneratorConstants.GEN_TYPE_AUTO_FAIL_NON_COMPLIANT)
        {
            generator = new AutoFailNonCompliantFractionGenerator();
        }
        else
        {
            generator = new FractionGenerator();
        }
        return generator;
    }
}
