package com.ihg.brandstandards.bridge.util;

import java.util.Collection;
import java.util.Map;

public interface ModelData
{

    public Object get(String property);

    public Map<String, Object> getProperties();

    public Collection<String> getPropertyNames();

    public Object remove(String property);

    public Object set(String property, Object value);
}