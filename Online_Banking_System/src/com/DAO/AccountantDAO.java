package com.DAO;

import java.util.List;

import com.Exceptions.AccountException;
import com.Exceptions.AccountantException;
import com.Exceptions.CustomerException;
import com.Model.Customer;

public interface AccountantDAO {
	
	public String Login(String email, String password) throws AccountantException; 
	public int addCustomer(String name, String email, String password, int phoneNumber, String address, int balance) throws CustomerException;
	public String addAccount(int balance, int cusId) throws AccountException;
	public String updateCustomer(int accountNumber,String address) throws CustomerException;
	public  Customer viewCustomer(String accountNumber) throws CustomerException;
	public int getCustomer(String email,String phoneNumber) throws CustomerException;
	public List<Customer> viewAllCustomer() throws CustomerException;
	public String deleteCustomer(int accountNumber) throws CustomerException;
}
