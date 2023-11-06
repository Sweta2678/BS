package com.ihg.brandstandards.bridge.model;

import java.util.HashMap;
import java.util.Map;

public class BridgePublishCountryStateModel
{
 
    private Map<String, String> countryState = new HashMap<String, String>();

    private String type = "";
    
    private Map<String, BridgePublishCountryStateModel> specifications = new HashMap<String, BridgePublishCountryStateModel>();
    
    private Map<String, BridgePublishCountryStateModel> guidelines = new HashMap<String, BridgePublishCountryStateModel>();
        
    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
    
    /**
     * @return the state
     */
    public Map<String, String> getCountryState()
    {
        return countryState;
    }

    /**
     * @param state the state to set
     */
    public void setCountryState(Map<String, String> countryState)
    {
        this.countryState = countryState;
    }
    
    public Map<String, BridgePublishCountryStateModel> getSpecifications()
    {
        return specifications;
    }

    public void setSpecifications(Map<String, BridgePublishCountryStateModel> specifications)
    {
        this.specifications = specifications;
    }

    public Map<String, BridgePublishCountryStateModel> getGuidelines()
    {
        return guidelines;
    }

    public void setGuidelines(Map<String, BridgePublishCountryStateModel> guidelines)
    {
        this.guidelines = guidelines;
    }
    
    public Map<String, BridgePublishCountryStateModel> getChildPojos(String type)
    {
        if(type.equals("SPEC"))
        {
            return specifications;
        }
        return guidelines;
    }
    public void setChildPojos(String type, Map<String, BridgePublishCountryStateModel> childPojos)
    {
        if(type.equals("SPEC"))
        {
            specifications = childPojos;
        }
        else
        {
            guidelines = childPojos;
        }
    }    
}
