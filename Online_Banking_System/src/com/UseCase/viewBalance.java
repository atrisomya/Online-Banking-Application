package com.UseCase;

import java.util.Scanner;

import com.DAO.CustomerDAO;
import com.DAO.CustomerDAOImpl;
import com.Exceptions.CustomerException;

public class viewBalance {

	public static void main(String[] args) {
		CustomerDAO c = new CustomerDAOImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter account number: ");
		int acc = sc.nextInt();
		
		sc.close();
		
		try {
			int res = c.viewBalance(acc);
			if(res != -1) {
				System.out.println("Balance: " + res);
			} else {
				System.out.println("Invalid account number.");
			}
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
