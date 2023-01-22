package com.UseCase;

import java.util.Scanner;

import com.DAO.AccountantDAO;
import com.DAO.AccountantDAOImpl;
import com.Exceptions.CustomerException;

public class deleteCustomerUseCase {

	public static void main(String[] args) {
		AccountantDAO a = new AccountantDAOImpl();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Account Number to be deleted: ");
		int acc = sc.nextInt();
		sc.close();
		try {
			String res = a.deleteCustomer(acc);
			System.out.println(res);
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}

	}

}
