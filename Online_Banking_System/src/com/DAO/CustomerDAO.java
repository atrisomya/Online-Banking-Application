package com.DAO;

import java.util.List;

import com.Exceptions.CustomerException;
import com.Model.Transactions;

public interface CustomerDAO {
	public int LoginCustomer(String email, String password)throws CustomerException; 
	
	public int viewBalance(int accountNumber) throws CustomerException;
	
	public int Deposit(int accountNumber, int amount) throws CustomerException; 
	
	public int withdraw(int accountNumber, int amount) throws CustomerException;
	
	public String transfer(int accountNumber1, int amount, int accountNumber2) throws CustomerException; 
	
	public List<Transactions> viewTransaction(int accountNumber) throws CustomerException;
	
	public int getAccNo(String email);
}
