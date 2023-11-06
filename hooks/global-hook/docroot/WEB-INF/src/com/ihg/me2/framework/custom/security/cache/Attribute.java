package com.ihg.me2.framework.custom.security.cache;

public class Attribute{
	
    private String id;

    private String source;

    private String name;

    private String sourcetype;

    private String solrEntryClassName;
    
    private String utilClassName;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getSource ()
    {
        return source;
    }

    public void setSource (String source)
    {
        this.source = source;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getSourcetype ()
    {
        return sourcetype;
    }

    public void setSourcetype (String sourcetype)
    {
        this.sourcetype = sourcetype;
    }

    public String getSolrEntryClassName ()
    {
        return solrEntryClassName;
    }

    public void setSolrEntryClassName (String solrEntryClassName)
    {
        this.solrEntryClassName = solrEntryClassName;
    }

    public String getUtilClassName() {
		return utilClassName;
	}
    
    public void setUtilClassName(String utilClassName) {
		this.utilClassName = utilClassName;
	}
    
	@Override
	public String toString() {
		return "ClassPojo [id = " + id + ", source = " + source + ", name = " + name + ", sourcetype = " + sourcetype
				+ ", solrEntryClassName = " + solrEntryClassName + ", utilClassName = " + utilClassName + "]";
	}
}
