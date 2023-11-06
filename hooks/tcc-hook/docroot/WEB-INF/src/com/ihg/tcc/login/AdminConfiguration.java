package com.ihg.tcc.login;

import java.util.ArrayList;
import java.util.List;

public class AdminConfiguration 
{
	private String signatureNumber;
	private String virtuosoNumber;
	private List<String> defaultRoleToAccessMenu = new ArrayList<String>();
	private String configuration1;
	private String configuration2;
	private String iataNo;
	
	
	public String getSignatureNumber() {
		return signatureNumber;
	}
	public void setSignatureNumber(String signatureNumber) {
		this.signatureNumber = signatureNumber;
	}
	public String getVirtuosoNumber() {
		return virtuosoNumber;
	}
	public void setVirtuosoNumber(String virtuosoNumber) {
		this.virtuosoNumber = virtuosoNumber;
	}
	public List<String> getDefaultRoleToAccessMenu() {
		return defaultRoleToAccessMenu;
	}
	public void setDefaultRoleToAccessMenu(List<String> defaultRoleToAccessMenu) {
		this.defaultRoleToAccessMenu = defaultRoleToAccessMenu;
	}
	public String getConfiguration1() {
		return configuration1;
	}
	public void setConfiguration1(String configuration1) {
		this.configuration1 = configuration1;
	}
	public String getConfiguration2() {
		return configuration2;
	}
	public void setConfiguration2(String configuration2) {
		this.configuration2 = configuration2;
	}
	public String getIataNo() {
		return iataNo;
	}
	public void setIataNo(String iataNo) {
		this.iataNo = iataNo;
	}
}
