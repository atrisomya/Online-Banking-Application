package com.DAO;

import java.util.List;

import com.Exceptions.AccountantException;
import com.Exceptions.CustomerException;
import com.Model.Customer;
import com.Model.Transactions;

public interface AccountantDAO {
	
	public String Login(String email, String password) throws AccountantException; 
	public String addAccountant(String email, String password, String name) throws AccountantException;
	public String addCustomer(String name, String email, String password, int phoneNumber, String address, int balance) throws CustomerException;
	public String updateName(String name, int accountNumber) throws CustomerException;
	public String updateEmail(String email, int accountNumber) throws CustomerException;
	public String updatePhoneNumber(int phoneNumber, int accountNumber) throws CustomerException;
	public String updateAddress(int accountNumber,String address) throws CustomerException;
	public  Customer viewCustomer(int accountNumber) throws CustomerException;
	public List<Customer> viewAllCustomer() throws CustomerException;
	public String deleteCustomer(int accountNumber) throws CustomerException;
	public List<Transactions> viewTransaction(int accountNumber) throws CustomerException;
	public List<Transactions> viewTransaction() throws CustomerException;
	public int getAccountNumberUsingEmail(String email) throws CustomerException;
}
