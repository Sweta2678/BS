package com.ihg.me2.wall.dto;

public class SubscriptionDTO {
	
	private long userId;
	private long classPK;
	private boolean isCategory;

		
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getClassPK() {
		return classPK;
	}
	public void setClassPK(long classPK) {
		this.classPK = classPK;
	}
		
	public boolean isCategory() {
		return isCategory;
	}
	public void setCategory(boolean isCategory) {
		this.isCategory = isCategory;
	}	
		
}
