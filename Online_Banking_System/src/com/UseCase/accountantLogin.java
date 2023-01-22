package com.UseCase;

import java.util.Scanner;

import com.DAO.AccountantDAO;
import com.DAO.AccountantDAOImpl;
import com.Exceptions.AccountantException;

public class accountantLogin {
	public static void main(String[] args) {
		AccountantDAO a = new AccountantDAOImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter email");
		String email = sc.next();
		System.out.println("Enter password");
		String password = sc.next();
		sc.close();
		try {
			String response = a.Login(email, password);
			System.out.println(response);
		} catch (AccountantException e) {
			System.out.println(e.getMessage());
		}
	}
}
