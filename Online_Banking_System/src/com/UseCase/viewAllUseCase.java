package com.UseCase;

import java.util.List;

import com.DAO.AccountantDAO;
import com.DAO.AccountantDAOImpl;
import com.Exceptions.CustomerException;
import com.Model.Customer;

public class viewAllUseCase {

	public static void main(String[] args) {
		AccountantDAO a = new AccountantDAOImpl();
		
		try {
			List<Customer> list = a.viewAllCustomer();
			list.forEach(n -> {
				System.out.println("Name: " + n.getName());
				System.out.println("Account Number: " + n.getAccountNumber());
				System.out.println("Email: " + n.getEmail());
				System.out.println("Phone Number: " + n.getPhoneNumber());
				System.out.println("Address: " + n.getAddress());
				System.out.println("Balance: " + n.getBalance());
			});
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
