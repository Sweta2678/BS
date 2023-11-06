/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ihg.brandstandards.db.model.impl;

import java.util.List;
import java.util.Map;

import com.ihg.brandstandards.db.model.StandardsExt;

/**
 * The model implementation for the StandardsExt service. Represents a row in the &quot;STD&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.model.StandardsExt} interface.
 * </p>
 *
 * @author Mummanedi
 */
public class StandardsExtImpl extends StandardsExtBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a Custom Query mapping between STD and Taxonomy tables. model instance should use the {@link StandardsExt} interface instead.
	 */
    private String auditStatus;
    private long indexOrder;
    private String stdManualBuild;
    private String stdManualOperate;
    private Map<String, String> countryChngStat;
    private List<Long> flags;
    
    public StandardsExtImpl() {
    }
    
    /**
     * Get Audit status. For example Audit.
     * 
     * @return the auditStatus
     */
    public String getAuditStatus()
    {
        return auditStatus;
    }

    /**
     * Set Audit status.
     * 
     * @param auditStatus the auditStatus to set
     */
    public void setAuditStatus(String auditStatus)
    {
        this.auditStatus = auditStatus;
    }

    /**
     * Getter for index order.
     * 
     * @return the indexOrder
     */
    public long getIndexOrder()
    {
        return indexOrder;
    }

    /**
     * Setter for index order.
     * 
     * @param indexOrder the indexOrder to set
     */
    public void setIndexOrder(long indexOrder)
    {
        this.indexOrder = indexOrder;
    }

    /**
     * Getter for stdManualBuild.
     * 
     * @return the stdManualBuild
     */
    public String getStdManualBuild()
    {
        return stdManualBuild;
    }

    /**
     * Setter for stdManualBuild.
     * 
     * @param stdManualBuild the stdManualBuild to set
     */
    public void setStdManualBuild(String stdManualBuild)
    {
        this.stdManualBuild = stdManualBuild;
    }

    /**
     * Getter for stdManualOperate.
     * 
     * @return the stdManualOperate
     */
    public String getStdManualOperate()
    {
        return stdManualOperate;
    }

    /**
     * Setter for stdManualOperate.
     * 
     * @param stdManualOperate the stdManualOperate to set
     */
    public void setStdManualOperate(String stdManualOperate)
    {
        this.stdManualOperate = stdManualOperate;
    }

    /**
     * Getter for country change status map.
     * @return the countryChngStat
     */
    public Map<String, String> getCountryChngStat()
    {
        return countryChngStat;
    }

    /**
     * Setter for country change status map.
     * @param countryChngStat the countryChngStat to set
     */
    public void setCountryChngStat(Map<String, String> countryChngStat)
    {
        this.countryChngStat = countryChngStat;
    }
    
    public List<Long> getFlags() {
        return flags;
    }

    public void setFlags(List<Long> flags) {
        this.flags = flags;
    }
}