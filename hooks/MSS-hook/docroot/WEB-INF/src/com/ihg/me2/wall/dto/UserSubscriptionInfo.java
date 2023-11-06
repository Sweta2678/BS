package com.ihg.me2.wall.dto;

import com.liferay.portlet.messageboards.model.MBMessage;

import java.util.ArrayList;
import java.util.List;

public class UserSubscriptionInfo {
	
	private long userId;
	private String userName;
	private List<Long> threadIds = new ArrayList<Long>();
	private List<Long> categoryIds = new ArrayList<Long>();
	private List<MBMessage> mbMessages = new ArrayList<MBMessage>();;
	
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<Long> getThreadIds() {
		return threadIds;
	}
	public void setThreadIds(List<Long> threadIds) {
		this.threadIds = threadIds;
	}
	public List<Long> getCategoryIds() {
		return categoryIds;
	}
	public void setCategoryIds(List<Long> categoryIds) {
		this.categoryIds = categoryIds;
	}
	public List<MBMessage> getMbMessages() {
		return mbMessages;
	}
	public void setMbMessages(List<MBMessage> mbMessages) {
		this.mbMessages = mbMessages;
	}

}
