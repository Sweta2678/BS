package com.ihg.me2.search;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONSerializable;


/**
 * @author vijaykumar.singh
 *
 */
public class Hotel implements JSONSerializable
{
	private String holidex;
	private String facilityId;
	private String brandName;
	private String managementTypeCode;
	private String chainCode;
	private String brandCode;
	private String locationStatus;
	private String address1;
	private String address2;
	private String city;
	private String stateCode;
	private String postalCode;
	private String country;
	private String countryCode;
	private String region;
	private String phoneNumber;
	private String locationTypeCode;
	private String stateName;
	private String geoloc;
	
	public String getHolidex()
	{
		return holidex;
	}
	
	public void setHolidex(String holidex)
	{
		this.holidex = holidex;
	}
	
	public String getFacilityId()
	{
		return facilityId;
	}
	
	public void setFacilityId(String facilityId)
	{
		this.facilityId = facilityId;
	}
	
	public String getBrandName()
	{
		return brandName;
	}
	
	public void setBrandName(String brandName)
	{
		this.brandName = brandName;
	}
	
	public String getManagementTypeCode()
	{
		return managementTypeCode;
	}
	
	public void setManagementTypeCode(String managementTypeCode)
	{
		this.managementTypeCode = managementTypeCode;
	}
	
	public String getChainCode()
	{
		return chainCode;
	}
	
	public void setChainCode(String chainCode)
	{
		this.chainCode = chainCode;
	}
	
	public String getBrandCode()
	{
		return brandCode;
	}
	
	public void setBrandCode(String brandCode)
	{
		this.brandCode = brandCode;
	}
	
	public String getLocationStatus()
	{
		return locationStatus;
	}
	
	public void setLocationStatus(String locationStatus)
	{
		this.locationStatus = locationStatus;
	}
	
	public String getAddress1()
	{
		return address1;
	}
	
	public void setAddress1(String address1)
	{
		this.address1 = address1;
	}
	
	public String getAddress2()
	{
		return address2;
	}
	
	public void setAddress2(String address2)
	{
		this.address2 = address2;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public String getStateCode()
	{
		return stateCode;
	}
	
	public void setStateCode(String stateCode)
	{
		this.stateCode = stateCode;
	}
	
	public String getPostalCode()
	{
		return postalCode;
	}
	
	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}
	
	public String getCountry()
	{
		return country;
	}
	
	public void setCountry(String country)
	{
		this.country = country;
	}
	
	public String getCountryCode()
	{
		return countryCode;
	}
	
	public void setCountryCode(String countryCode)
	{
		this.countryCode = countryCode;
	}
	
	public String getRegion()
	{
		return region;
	}
	
	public void setRegion(String region)
	{
		this.region = region;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	public String getLocationTypeCode()
	{
		return locationTypeCode;
	}
	
	public void setLocationTypeCode(String locationTypeCode)
	{
		this.locationTypeCode = locationTypeCode;
	}
	
	public String getStateName()
	{
		return stateName;
	}
	
	public void setStateName(String stateName)
	{
		this.stateName = stateName;
	}
	
	public String getGeoloc()
	{
		return geoloc;
	}
	
	public void setGeoloc(String geoloc)
	{
		this.geoloc = geoloc;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Hotel [holidex=");
		builder.append(holidex);
		builder.append(", facilityId=");
		builder.append(facilityId);
		builder.append(", brandName=");
		builder.append(brandName);
		builder.append(", managementTypeCode=");
		builder.append(managementTypeCode);
		builder.append(", chainCode=");
		builder.append(chainCode);
		builder.append(", brandCode=");
		builder.append(brandCode);
		builder.append(", locationStatus=");
		builder.append(locationStatus);
		builder.append(", address1=");
		builder.append(address1);
		builder.append(", address2=");
		builder.append(address2);
		builder.append(", city=");
		builder.append(city);
		builder.append(", stateCode=");
		builder.append(stateCode);
		builder.append(", postalCode=");
		builder.append(postalCode);
		builder.append(", country=");
		builder.append(country);
		builder.append(", countryCode=");
		builder.append(countryCode);
		builder.append(", region=");
		builder.append(region);
		builder.append(", phoneNumber=");
		builder.append(phoneNumber);
		builder.append(", locationTypeCode=");
		builder.append(locationTypeCode);
		builder.append(", stateName=");
		builder.append(stateName);
		builder.append(", geoloc=");
		builder.append(geoloc);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public String toJSONString()
	{
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("holidex", getHolidex());
		json.put("brandName", getBrandName());
		json.put("facilityId", getFacilityId());
		return json.toString();
	}

}
