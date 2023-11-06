package com.ihg.brandstandards.bridge.model;

public class BadCell
{
    private String worksheet;
    private int row;
    private int col;
    private Object value;
    private String columnName;
    private String errorMessage; 

    public BadCell()
    {
    }


    public BadCell(String worksheet, int row, int col, Object value, String columnName, String errorMessage)
    {
        super();
        this.worksheet = worksheet;
        this.row = row;
        this.col = col;
        this.value = value;
        this.columnName = columnName;
        this.errorMessage = errorMessage;
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

    public int getCol()
    {
        return col;
    }

    public void setCol(int col)
    {
        this.col = col;
    }

    public Object getValue()
    {
        return value;
    }

    public void setValue(Object value)
    {
        this.value = value;
    }

    public String getColumnName()
    {
        return columnName;
    }

    public void setColumnName(String columnName)
    {
        this.columnName = columnName;
    }


    public String getErrorMessage()
    {
        return errorMessage;
    }


    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }
}
