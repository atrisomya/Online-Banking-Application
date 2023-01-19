package com.DAO;

import com.Exceptions.AccountException;
import com.Exceptions.AccountantException;
import com.Exceptions.CustomerException;

public interface AccountantDAO {
	
	public String Login(String email, String password) throws AccountantException; 
	public int addCustomer(String name, String email, String password, int phoneNumber, String address, int balance) throws CustomerException;
	public String addAccount(int balance, int cusId) throws AccountException;
}
