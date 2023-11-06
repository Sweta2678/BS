package com.ihg.brandstandards.bridge.util;


import java.io.Serializable;

@SuppressWarnings("serial")
public class CtryData implements Serializable {
 
	private String stdId;
	private String countryList;
	private String status;
	private String complianceDate;
	
	
	
	public String getComplianceDate() {
		return complianceDate;
	}
	
	public void setComplianceDate(String complianceDate) {
		this.complianceDate = complianceDate;
	}
	public String getStdId() {
		return stdId;
	}
	public void setStdId(String stdId) {
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
		CtryData object = (CtryData) obj;
		return stdId.equals(object.getStdId()) && status.equals(object.getStatus()) && complianceDate.equals(object.getComplianceDate());
	}
	
}
