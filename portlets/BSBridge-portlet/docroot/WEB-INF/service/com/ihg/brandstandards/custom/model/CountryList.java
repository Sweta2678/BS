package com.ihg.brandstandards.custom.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CountryList implements Serializable {
 
	private long stdId;
	private String countryList;
	private String status;
	private String complianceDate;
	
	
	
	public String getComplianceDate() {
		return complianceDate;
	}
	
	public void setComplianceDate(String complianceDate) {
		this.complianceDate = complianceDate;
	}
	public long getStdId() {
		return stdId;
	}
	public void setStdId(long stdId) {
		this.stdId = stdId;
	}
	public String getCountryList() {
		return countryList;
	}
	public void setCountryList(String countryList) {
		this.countryList = countryList;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
            return true;
        }
		if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
		CountryList object = (CountryList) obj;
		return countryList.equals(object.getCountryList());
	}
	
}
