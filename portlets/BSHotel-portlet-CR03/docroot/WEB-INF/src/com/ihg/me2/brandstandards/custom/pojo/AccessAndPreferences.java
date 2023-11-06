/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.me2.brandstandards.custom.pojo;

import java.io.Serializable;
import java.util.List;

import com.liferay.portal.model.User;

/**
 * <a href="AccessAndPreferences.java.html"><b><i>View Source</i></b></a>.
 * 
 * Project: Brand Standards
 * 
 * @author Niranjan Khandekar
 */
public class AccessAndPreferences implements Serializable {
	private String chain;
	private String buildType;
	private String selectedLanguage;
	private String holidexCode;
	private String country;
	private String userType;
	private String locationName;
	private String defaultLocation;
	private String langCode;
	private String pdfLangCode;
	private String langName;
	private String paperSize;
	private String countryName;
	private String chainName;
	private String defaultChain;
	private long publishId;
	private long userId;
	private int recordsPerPage;
	private int recordsPerWCOPage;
	private int pageNumber;
	private List languages;
	private List chains;
	private List locations;
	private List countries;
	private List manuals;

	private User user;

	/**
	 * Default constructor.
	 */
	public AccessAndPreferences() {
	}

	/**
	 * 
	 * @return List
	 */
	public List getChains() {
		return chains;
	}

	/**
	 * 
	 * @param chains
	 *            This is a List object
	 */
	public void setChains(List chains) {
		this.chains = chains;
	}

	/**
	 * 
	 * @return List
	 */
	public List getLocations() {
		return locations;
	}

	/**
	 * 
	 * @param locations
	 *            This is a List object
	 */
	public void setLocations(List locations) {
		this.locations = locations;
	}

	/**
	 * 
	 * @return String
	 */
	public String getBuildType() {
		return buildType;
	}

	/**
	 * 
	 * @param buildType
	 *            This is a String object
	 */
	public void setBuildType(String buildType) {
		this.buildType = buildType;
	}

	/**
	 * 
	 * @return List
	 */
	public List getLanguages() {
		return languages;
	}

	/**
	 * 
	 * @param languages
	 *            This is a List object
	 */
	public void setLanguages(List languages) {
		this.languages = languages;
	}

	/**
	 * 
	 * @return String
	 */
	public String getSelectedLanguage() {
		return selectedLanguage;
	}

	/**
	 * 
	 * @param selectedLanguage
	 *            This is a String object
	 */
	public void setSelectedLanguage(String selectedLanguage) {
		this.selectedLanguage = selectedLanguage;
	}

	/**
	 * 
	 * @return String
	 */
	public String getHolidexCode() {
		return holidexCode;
	}

	/**
	 * 
	 * @param holidexCode
	 *            This is a String object
	 */

	public void setHolidexCode(String holidexCode) {
		this.holidexCode = holidexCode;
	}

	/**
	 * 
	 * @return long
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * 
	 * @param userId
	 *            This is a long object
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * 
	 * @return User
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 
	 * @param user
	 *            This is a User object
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 
	 * @return String
	 */
	public String getChain() {
		return chain;
	}

	/**
	 * 
	 * @param chain
	 *            This is a String object
	 */
	public void setChain(String chain) {
		this.chain = chain;
	}

	/**
	 * 
	 * @return String
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 
	 * @param country
	 *            This is a String object
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * 
	 * @return String
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * 
	 * @param userType
	 *            This is a String object
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * 
	 * @return String
	 */
	public String getLocationName() {
		return locationName;
	}

	/**
	 * 
	 * @param locationName
	 *            This is a String object
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	/**
	 * 
	 * @return String
	 */
	public String getDefaultLocation() {
		return defaultLocation;
	}

	/**
	 * 
	 * @param defaultLocation
	 *            This is a String object
	 */
	public void setDefaultLocation(String defaultLocation) {
		this.defaultLocation = defaultLocation;
	}

	/**
	 * 
	 * @return String
	 */
	public String getLangCode() {
		return langCode;
	}

	/**
	 * 
	 * @param langCode
	 *            This is a String object
	 */
	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	/**
	 * 
	 * @return String
	 */
	public String getPdfLangCode() {
		return pdfLangCode;
	}

	/**
	 * 
	 * @param pdfLangCode
	 *            This is a String object
	 */
	public void setPdfLangCode(String pdfLangCode) {
		this.pdfLangCode = pdfLangCode;
	}

	/**
	 * 
	 * @return String
	 */
	public String getLangName() {
		return langName;
	}

	/**
	 * 
	 * @param langName
	 *            This is a String object
	 */
	public void setLangName(String langName) {
		this.langName = langName;
	}

	/**
	 * 
	 * @return List
	 */
	public List getCountries() {
		return countries;
	}

	/**
	 * 
	 * @param countries
	 *            This is a List object
	 */
	public void setCountries(List countries) {
		this.countries = countries;
	}

	/**
	 * 
	 * @return List
	 */
	public List getManuals() {
		return manuals;
	}

	/**
	 * 
	 * @param manuals
	 *            This is a List object
	 */
	public void setManuals(List manuals) {
		this.manuals = manuals;
	}

	/**
	 * 
	 * @return String
	 */
	public String getPaperSize() {
		return paperSize;
	}

	/**
	 * 
	 * @param paperSize
	 *            This is a String object
	 */
	public void setPaperSize(String paperSize) {
		this.paperSize = paperSize;
	}

	/**
	 * 
	 * @return String
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * 
	 * @param countryName
	 *            This is a String object
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * 
	 * @return String
	 */
	public String getChainName() {
		return chainName;
	}

	/**
	 * 
	 * @param chainName
	 *            This is a String object
	 */
	public void setChainName(String chainName) {
		this.chainName = chainName;
	}

	/**
	 * 
	 * @return String
	 */
	public String getDefaultChain() {
		return defaultChain;
	}

	/**
	 * 
	 * @param defaultChain
	 *            This is a String object
	 */
	public void setDefaultChain(String defaultChain) {
		this.defaultChain = defaultChain;
	}

	/**
	 * 
	 * @return long
	 */
	public long getPublishId() {
		return publishId;
	}

	/**
	 * 
	 * @param publishId
	 *            This is a long object
	 */
	public void setPublishId(long publishId) {
		this.publishId = publishId;
	}

	/**
	 * 
	 * @return int
	 */
	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	/**
	 * 
	 * @param recordsPerPage
	 *            This is an integer object
	 */
	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	/**
	 * @return the recordsPerWCOPage
	 */
	public int getRecordsPerWCOPage() {
		return recordsPerWCOPage;
	}

	/**
	 * @param recordsPerWCOPage
	 *            the recordsPerWCOPage to set
	 */
	public void setRecordsPerWCOPage(int recordsPerWCOPage) {
		this.recordsPerWCOPage = recordsPerWCOPage;
	}

	/**
	 * 
	 * @return int
	 */
	public int getPageNumber() {
		return pageNumber;
	}

	/**
	 * 
	 * @param pageNumber
	 *            This is an integer object
	 */
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

}
