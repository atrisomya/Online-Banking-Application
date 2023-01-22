package com.UseCase;

import java.util.List;
import java.util.Scanner;

import com.DAO.CustomerDAO;
import com.DAO.CustomerDAOImpl;
import com.Exceptions.CustomerException;
import com.Model.Transactions;

public class depwithtran {

	public static void main(String[] args) {
		CustomerDAO c = new CustomerDAOImpl();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter account number: ");
		int acc = sc.nextInt();
		sc.close();
		try {
			List<Transactions> list = c.viewTransaction(acc);
			list.forEach(n -> {
				System.out.println("=================================");
				System.out.println();
				System.out.println("Transaction ID: " + n.getTransactionId());
				System.out.println("Account Number: " + n.getAccountNumber());
				System.out.println("Amount Deposited: " + n.getDeposit());
				System.out.println("Amount Withdrawn: " + n.getClass());
				System.out.println("Time of transaction: " + n.getTimeOfTransaction());
				System.out.println();
				System.out.println("=================================");
			});
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
	}

}
