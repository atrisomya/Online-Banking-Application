package com.UseCase;

import java.util.Scanner;

import com.DAO.AccountantDAO;
import com.DAO.AccountantDAOImpl;
import com.Exceptions.CustomerException;

public class UpdateUsecase {

	public static void main(String[] args) {
		
		AccountantDAO a = new AccountantDAOImpl();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter account number: ");
		int acc = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter new address");
		String address = sc.nextLine();
		try {
			String confirmation = a.updateAddress(acc, address);
			System.out.println(confirmation);
		} catch (CustomerException e) {
			
			System.out.println(e.getMessage());
		}
		
		System.out.println("Enter new name");
		String name = sc.nextLine();
		
		try {
			String res = a.updateName(name, acc);
			System.out.println(res);
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Enter new email");
		String email = sc.nextLine();
		
		try {
			String eres = a.updateEmail(email, acc);
			System.out.println(eres);
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Enter new phone number");
		 int phone = sc.nextInt();
		
		try {
			String pres = a.updatePhoneNumber(phone, acc);
			System.out.println(pres);
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
	

}
