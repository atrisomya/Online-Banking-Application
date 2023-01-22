package com.UseCase;

import java.util.Scanner;

import com.DAO.AccountantDAO;
import com.DAO.AccountantDAOImpl;
import com.Exceptions.CustomerException;

public class accountantUsecase {
	public static void main(String[] args) {
		AccountantDAO a = new AccountantDAOImpl();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter customer name: ");
		String name = sc.next();
		System.out.println("Enter Email: ");
		String email = sc.next();
		System.out.println("Enter Password: ");
		String password = sc.next();
		System.out.println("Enter Phone Number: ");
		int phone = sc.nextInt();
		System.out.println("Enter Address: ");
		String address = sc.next();
		System.out.println("Enter Balance: ");
		int bal = sc.nextInt();
		String ans = "Account could not be added.";
		try {
			ans = a.addCustomer(name, email, password, phone, address, bal);
			System.out.println(ans);
			
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
}
