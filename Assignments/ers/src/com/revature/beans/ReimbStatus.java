package com.revature.beans;

public class ReimbStatus {
	
	public int statusId;
	public String statusName;
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public ReimbStatus(int statusId, String statusName) {
		super();
		this.statusId = statusId;
		this.statusName = statusName;
	}
	public ReimbStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ReimbStatus [statusId=" + statusId + ", statusName=" + statusName + "]";
	}
	public ReimbStatus(int statusId) {
		super();
		this.statusId = statusId;
	}
	
	
}
