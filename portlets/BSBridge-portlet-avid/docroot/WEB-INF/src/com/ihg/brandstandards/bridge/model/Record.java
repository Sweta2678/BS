package com.ihg.brandstandards.bridge.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Record
{
    private String id;
    private String parentId;
    private String type;
    private String name;
    private String className;
    private String fieldName;
    private Object value;
    private boolean isRequired;
    private boolean isMultivalue;
    private boolean encodeValue;
    private boolean isValid = true;
    private int row;
    private String columnName;
    private Map<String, List<Record>> fields;
    private List<BadCell> badCell;

    public Record()
    {
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getClassName()
    {
        return className;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getParentId()
    {
        return parentId;
    }

    public void setParentId(String parentId)
    {
        this.parentId = parentId;
    }

    public String getFieldName()
    {
        return fieldName;
    }

    public void setFieldName(String fieldName)
    {
        this.fieldName = fieldName;
    }

    public Object getValue()
    {
        return value;
    }

    public void setValue(Object value)
    {
        this.value = value;
    }

    public boolean isRequired()
    {
        return isRequired;
    }

    public void setRequired(boolean isRequired)
    {
        this.isRequired = isRequired;
    }

    public boolean isMultivalue()
    {
        return isMultivalue;
    }

    public void setMultivalue(boolean isMultivalue)
    {
        this.isMultivalue = isMultivalue;
    }

    public boolean isEncodeValue()
    {
        return encodeValue;
    }

    public void setEncodeValue(boolean encodeValue)
    {
        this.encodeValue = encodeValue;
    }

    public boolean isValid()
    {
        return isValid;
    }

    public void setValid(boolean isValid)
    {
        this.isValid = isValid;
    }

    public int getRow()
    {
        return row;
    }

    public void setRow(int row)
    {
        this.row = row;
    }

    public String getColumnName()
    {
        return columnName;
    }

    public void setColumnName(String columnName)
    {
        this.columnName = columnName;
    }

    public Map<String, List<Record>> getFields()
    {
        return fields;
    }

    public void setFields(Map<String, List<Record>> fields)
    {
        this.fields = fields;
    }

    public void addField(String className, Record field)
    {
        if (this.fields == null)
        {
            this.fields = new HashMap<String, List<Record>>();
        }

        List<Record> records = this.fields.get(className);
        if (records == null)
        {
            records = new ArrayList<Record>();
            this.fields.put(className, records);
        }
        records.add(field);
    }

    public List<BadCell> getBadCell()
    {
        return badCell;
    }

    public void setBadCell(List<BadCell> badCell)
    {
        this.badCell = badCell;
    }

    public void addBadCell(BadCell badCell)
    {
        if (this.badCell == null)
            this.badCell = new ArrayList<BadCell>();
        
        this.badCell.add(badCell);
    }
}
