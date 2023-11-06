package com.ihg.me2.framework.custom.security.cache;


import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "attributes")
public class SecurityAttributes {
	
	    private ArrayList<Attribute> attribute;

	    public ArrayList<Attribute> getAttribute ()
	    {
	        return attribute;
	    }

	    public void setAttribute (ArrayList<Attribute> attribute)
	    {
	        this.attribute = attribute;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [attribute = "+attribute+"]";
	    }
	    
	
}

