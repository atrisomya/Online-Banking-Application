package com.Model;

public class Accountant {
	private String accId;
	private String password;
	private String accName;
	private String branch;
	
	public Accountant() {
		
	}

	public Accountant(String accId, String password, String accName, String branch) {
		super();
		this.accId = accId;
		this.password = password;
		this.accName = accName;
		this.branch = branch;
	}

	public String getAccId() {
		return accId;
	}

	public void setAccId(String accId) {
		this.accId = accId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Accountant [accId=" + accId + ", password=" + password + ", accName=" + accName + ", branch=" + branch
				+ "]";
	}
	
	
	
	
}
