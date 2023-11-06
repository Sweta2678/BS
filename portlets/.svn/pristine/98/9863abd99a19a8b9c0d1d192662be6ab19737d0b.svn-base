package com.ihg.brandstandards.util;

import java.util.ArrayList;
import java.util.List;

import com.ihg.brandstandards.db.model.Standards;

/**
 * Wrapper for Standards.
 * 
 * @author KhandeN
 * 
 */
public class StandardsListWrapper
{
    private Standards standards;

    // private long stdId =standards.getStdId();

    /**
     * Default constructor.
     */
    public StandardsListWrapper()
    {
        super();
    }

    /**
     * Preferred constructor.
     * 
     * @param standards - standard.
     */
    public StandardsListWrapper(final Standards standards)
    {
        super();
        this.standards = standards;
    }

    /**
     * Unwrap StandardsListWrapper to list of Standards.
     * 
     * @param stdWrapperList list of StandardsListWrapper
     * @return list of Standards
     */
    public static List<Standards> unwrappedList(final List<StandardsListWrapper> stdWrapperList)
    {
        if (stdWrapperList == null)
        {
            return new ArrayList<Standards>(0);
        }

        final List<Standards> standardsList = new ArrayList<Standards>(stdWrapperList.size());
        for (StandardsListWrapper su : stdWrapperList)
        {
            standardsList.add(su.getStandards());
        }

        return standardsList;
    }

    /**
     * Wrap list of Standards into StandardsListWrapper list.
     * 
     * @param standardsList - list of Standards
     * @return list of StandardsListWrapper
     */
    public static List<StandardsListWrapper> wrappedList(final List<Standards> standardsList)
    {
        if (standardsList == null)
        {
            return new ArrayList<StandardsListWrapper>(0);
        }

        final List<StandardsListWrapper> standardWrapperList = new ArrayList<StandardsListWrapper>(standardsList.size());
        for (Standards b : standardsList)
        {
            standardWrapperList.add(new StandardsListWrapper(b));
        }

        return standardWrapperList;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final StandardsListWrapper other = (StandardsListWrapper) obj;
        if (standards == null)
        {
            if (other.standards != null)
            {
                return false;
            }
        }
        else if (standards.getStdId() != other.standards.getStdId())
        {
            return false;
        }
        return true;
    }

    /**
     * Get Standard record.
     * 
     * @return Standards
     */
    public Standards getStandards()
    {
        return standards;
    }

    @Override
    public int hashCode()
    {
        int hashCode = 0;
        final long stdId = this.getStandards().getStdId();
        hashCode = 23 + (int) (stdId ^ (stdId >>> 32));

        return hashCode;
    }

    /**
     * Set Standard record.
     * 
     * @param standards - Standard record.
     */
    public void setStandards(final Standards standards)
    {
        this.standards = standards;
    }

}
