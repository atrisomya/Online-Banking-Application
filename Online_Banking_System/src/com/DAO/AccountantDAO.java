package com.DAO;

import com.Exceptions.AccountantException;

public interface AccountantDAO {
	
	public String Login(String email, String password) throws AccountantException; 
	
}
