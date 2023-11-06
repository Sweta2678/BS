package com.ihg.brandstandards.bridge.util;

import java.util.Map;

import com.ihg.brandstandards.bridge.model.BaseModelData;

public class XlsModelData extends BaseModelData {

    private static final long serialVersionUID = -182235965397317394L;
    public String worksheet;
    private int row;
    private int columnCount;
    private String id;
    private String parentId;
    private String type;
    private String name;
    private boolean isValid;
    private String invalidData;

    public XlsModelData()
    {
    }

    public XlsModelData(Map<String, Object> properties)
    {
        super(properties);
    }

    public String getWorksheet()
    {
        return worksheet;
    }

    public void setWorksheet(String worksheet)
    {
        this.worksheet = worksheet;
    }

    public int getRow()
    {
        return row;
    }

    public void setRow(int row)
    {
        this.row = row;
    }

    public int getColumnCount()
    {
        return columnCount;
    }

    public void setColumnCount(int columnCount)
    {
        this.columnCount = columnCount;
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

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isValid()
    {
        return isValid;
    }

    public void setValid(boolean isValid)
    {
        this.isValid = isValid;
    }

    public String getInvalidData()
    {
        return invalidData;
    }

    public void setInvalidData(String invalidData)
    {
        this.invalidData = invalidData;
    }

	@Override
	public String toString() {
		
		return id;
	} 
    
   
 }