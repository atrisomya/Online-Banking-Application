package com.Model;

import java.security.Timestamp;

public class Transactions {
	private int transactionId;
	private int accountNumber;
	private String branch;
	private String ifscCode;
	private int deposit;
	private int withdraw;
	private Timestamp timeOfTransaction;
	
	public Transactions() {
		
	}

	public Transactions(int transactionId, int accountNumber, String branch, String ifscCode, int deposit, int withdraw,
			Timestamp timeOfTransaction) {
		super();
		this.transactionId = transactionId;
		this.accountNumber = accountNumber;
		this.branch = branch;
		this.ifscCode = ifscCode;
		this.deposit = deposit;
		this.withdraw = withdraw;
		this.timeOfTransaction = timeOfTransaction;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}

	public Timestamp getTimeOfTransaction() {
		return timeOfTransaction;
	}

	public void setTimeOfTransaction(Timestamp timeOfTransaction) {
		this.timeOfTransaction = timeOfTransaction;
	}

	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", accountNumber=" + accountNumber + ", branch="
				+ branch + ", ifscCode=" + ifscCode + ", deposit=" + deposit + ", withdraw=" + withdraw
				+ ", timeOfTransaction=" + timeOfTransaction + "]";
	}

	
	
}
