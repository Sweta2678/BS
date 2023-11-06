package com.ihg.brandstandards.bridge.model;

import java.io.Serializable;
import java.util.Collection; 
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BaseModelData implements ModelData, Serializable
{
    private static final long serialVersionUID = 5807839871606099024L;
    protected Map<String, Object> map;

    
    public BaseModelData()
    {
    }

    public BaseModelData(Map<String, Object> properties)
    {
        setProperties(properties);
    }

    public Object get(String property)
    {
        Object value = null;
        if (map != null)
        {
            value = map.get(property);
        }
        return value;
    }

    public Object get(String property, Object valueWhenNull)
    {
        return (get(property) == null) ? valueWhenNull : get(property);
    }

    public Map<String, Object> getProperties()
    {
        Map<String, Object> newMap = new HashMap<String, Object>();
        if (map != null) {
          newMap.putAll(map);
        }
        return newMap;
    }

    public Collection<String> getPropertyNames()
    {
        Set<String> set = new HashSet<String>();
        if (map != null)
        {
            set.addAll(map.keySet());
        }
        return set;
    }

    public Object remove(String property)
    {
        return null;
    }

    public Object set(String property, Object value)
    {
        if (map == null)
        {
            map = new HashMap<String, Object>();
        }

        return map.put(property, value);
    }

    public void setProperties(Map<String, Object> properties)
    {
        for (String property : properties.keySet())
        {
            set(property, properties.get(property));
        }
    }
}
