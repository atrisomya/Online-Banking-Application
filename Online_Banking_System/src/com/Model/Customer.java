package com.Model;

public class Customer {
	
	private int accountNumber;
	private String name;
	private String email;
	private String password;
	private int phoneNumber;
	private String address;
	private int balance;
	private String ifscCode;
	private String branch;
	
	public Customer() {
		
	}

	public Customer(int accountNumber, String name, String email, String password, int phoneNumber, String address,
			int balance, String ifscCode, String branch) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.balance = balance;
		this.ifscCode = ifscCode;
		this.branch = branch;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Customer [accountNumber=" + accountNumber + ", name=" + name + ", email=" + email + ", password="
				+ password + ", phoneNumber=" + phoneNumber + ", address=" + address + ", balance=" + balance
				+ ", ifscCode=" + ifscCode + ", branch=" + branch + "]";
	}
	
	
	
	
}
