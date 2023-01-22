package com.UseCase;

import java.util.Scanner;

import com.DAO.CustomerDAO;
import com.DAO.CustomerDAOImpl;
import com.Exceptions.CustomerException;

public class customerlogin {
	public static void main(String[] args) {
		CustomerDAO c = new CustomerDAOImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter email");
		String email = sc.next();
		System.out.println("Enter password");
		String password = sc.next();
		sc.close();
		
		try {
			int res = c.LoginCustomer(email, password);
			System.out.println(res);
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
	}
}
