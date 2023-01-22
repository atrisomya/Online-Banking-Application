package com.UseCase;

import java.util.Scanner;

import com.DAO.AccountantDAO;
import com.DAO.AccountantDAOImpl;
import com.Exceptions.CustomerException;
import com.Model.Customer;

public class viewAccountUseCase {
	public static void main(String[] args) {
		
		AccountantDAO a = new AccountantDAOImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter account number: ");
		int acc = sc.nextInt();
		
		try {
			Customer n = a.viewCustomer(acc);
			System.out.println("Name: " + n.getName());
			System.out.println("Account Number: " + n.getAccountNumber());
			System.out.println("Email: " + n.getEmail());
			System.out.println("Phone Number: " + n.getPhoneNumber());
			System.out.println("Address: " + n.getAddress());
			System.out.println("Balance: " + n.getBalance());
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
}
