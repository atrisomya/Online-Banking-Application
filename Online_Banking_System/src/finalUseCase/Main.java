package finalUseCase;

import java.util.List;
import java.util.Scanner;

import com.ConsoleColors.ConsoleColors;
import com.DAO.AccountantDAO;
import com.DAO.AccountantDAOImpl;
import com.DAO.CustomerDAO;
import com.DAO.CustomerDAOImpl;
import com.Exceptions.AccountantException;
import com.Exceptions.CustomerException;
import com.Model.Customer;
import com.Model.Transactions;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void accountantMenu() {
		
		System.out.println(ConsoleColors.GREEN_BOLD
				+ "+==============================================================+" + "\n"
				+ "|         Welcome to Accountant Portal                         |" + "\n"
				+ "+==============================================================+" + "\n"
				+ "|                                                              |" + "\n"
				+ "|  1. Add New Customer Account                                 |" + "\n"
				+ "|  2. Update Name of an existing accountholder                 |" + "\n"
				+ "|  3. Update Email of an existing accountholder                |" + "\n"
				+ "|  4. Update Contact Number of an existing accountholder       |" + "\n"
				+ "|  5. Update Address of an existing accountholder              |" + "\n"
				+ "|  6. Remove the account by account number                     |" + "\n"
				+ "|  7. View particular account details by giving account number |" + "\n"
				+ "|  8. View the details of all accountholders                   |" + "\n"
				+ "|  9. View deposit and withdrawal operations for Customer      |" + "\n"
				+ "|  10. Get account number from Customer Email                  |" + "\n"
				+ "|  11. Add new accountant                                      |" + "\n"
				+ "|  12. LOGOUT                                                  |" + "\n"
				+ "|  13. Exit the application                                    |" + "\n"
				+ "|                                                              |" + "\n"
				+ "+==============================================================+" + "\n"
				+ConsoleColors.RESET);
		
		try {
			
			AccountantDAO a = new AccountantDAOImpl();
			
			String ch = sc.nextLine();
			int choice = Integer.parseInt(ch);
			
			if(choice == 1) {
				
				System.out.println(ConsoleColors.YELLOW+"Enter customer name: "+ConsoleColors.RESET);
				String name = sc.nextLine();
				
				System.out.println(ConsoleColors.YELLOW+"Enter Email: "+ConsoleColors.RESET);
				String email = sc.nextLine();
				
				System.out.println(ConsoleColors.YELLOW+"Enter Password: "+ConsoleColors.RESET);
				String password = sc.nextLine();
				
				System.out.println(ConsoleColors.YELLOW+"Enter Phone Number: "+ConsoleColors.RESET);
				int phone = sc.nextInt();
				sc.nextLine();
				
				System.out.println(ConsoleColors.YELLOW+"Enter Address: "+ConsoleColors.RESET);
				String address = sc.nextLine();
				
				System.out.println(ConsoleColors.YELLOW+"Enter Balance: "+ConsoleColors.RESET);
				int bal = sc.nextInt();
				sc.nextLine();
				
				String ans = "Account could not be added.";
				
				try {
					ans = a.addCustomer(name, email, password, phone, address, bal);
					System.out.println(ConsoleColors.YELLOW+ans+ConsoleColors.RESET);
					accountantMenu();
					
				} catch (CustomerException e) {
					
					System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+e.getMessage()+ConsoleColors.RESET);
					accountantMenu();
				}
				
				
			} else if(choice == 2) {
				
				System.out.println(ConsoleColors.YELLOW_BOLD+"Enter account number: "+ConsoleColors.RESET);
				int acc = sc.nextInt();
				sc.nextLine();
				
				System.out.println(ConsoleColors.YELLOW_BOLD+"Enter new name"+ConsoleColors.RESET);
				String name = sc.nextLine();
				
				try {
					
					String res = a.updateName(name, acc);
					System.out.println(ConsoleColors.YELLOW_BOLD+res+ConsoleColors.RESET);
					accountantMenu();
					
				} catch (CustomerException e) {
					
					System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+e.getMessage()+ConsoleColors.RESET);
					accountantMenu();
				}
				
				
			} else if(choice == 3) {
				
				System.out.println(ConsoleColors.YELLOW_BOLD+"Enter account number: "+ConsoleColors.RESET);
				int acc = sc.nextInt();
				sc.nextLine();
				
				System.out.println(ConsoleColors.YELLOW_BOLD+"Enter new email"+ConsoleColors.RESET);
				String email = sc.nextLine();
				
				try {
					
					String eres = a.updateEmail(email, acc);
					System.out.println(ConsoleColors.YELLOW_BOLD+eres+ConsoleColors.RESET);
					accountantMenu();
					
				} catch (CustomerException e) {
					
					System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+e.getMessage()+ConsoleColors.RESET);
					accountantMenu();
					
				}
				
			} else if(choice == 4) {
				
				System.out.println(ConsoleColors.YELLOW_BOLD+"Enter account number: "+ConsoleColors.RESET);
				int acc = sc.nextInt();
				sc.nextLine();
				
				System.out.println(ConsoleColors.YELLOW_BOLD+"Enter new phone number"+ConsoleColors.RESET);
				 int phone = sc.nextInt();
				sc.nextLine();
				try {
					String pres = a.updatePhoneNumber(phone, acc);
					System.out.println(ConsoleColors.YELLOW_BOLD+pres+ConsoleColors.RESET);
					accountantMenu();
				} catch (CustomerException e) {
					System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+e.getMessage()+ConsoleColors.RESET);
					accountantMenu();
				}
				
			} else if(choice == 5) {
				
				System.out.println(ConsoleColors.YELLOW_BOLD+"Enter account number: "+ConsoleColors.RESET);
				int acc = sc.nextInt();
				sc.nextLine();
				
				System.out.println(ConsoleColors.YELLOW_BOLD+"Enter new address"+ConsoleColors.RESET);
				String address = sc.nextLine();
				try {
					
					String confirmation = a.updateAddress(acc, address);
					System.out.println(ConsoleColors.YELLOW_BOLD+confirmation+ConsoleColors.RESET);
					accountantMenu();
					
				} catch (CustomerException e) {
					
					System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+e.getMessage()+ConsoleColors.RESET);
					accountantMenu();
					
				}
				
			} else if(choice == 6) {
				
				System.out.println(ConsoleColors.YELLOW_BOLD+"Enter Account Number to be deleted: "+ConsoleColors.RESET);
				int acc = sc.nextInt();
				sc.nextLine();
				try {
					String res = a.deleteCustomer(acc);
					accountantMenu();
				} catch (CustomerException e) {
					System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+e.getMessage()+ConsoleColors.RESET);
					accountantMenu();
				}

				
			} else if(choice == 7) {
				
				System.out.println(ConsoleColors.YELLOW_BOLD+"Enter account number: "+ConsoleColors.RESET);
				int acc = sc.nextInt();
				sc.nextLine();
				
				try {
					Customer n = a.viewCustomer(acc);
					System.out.println(ConsoleColors.RED_BOLD+"================================================"+ConsoleColors.RESET);
					System.out.println();
					System.out.println(ConsoleColors.GREEN_BOLD+"Name: " + n.getName()+ConsoleColors.RESET);
					System.out.println(ConsoleColors.GREEN_BOLD+"Account Number: " + n.getAccountNumber()+ConsoleColors.RESET);
					System.out.println(ConsoleColors.GREEN_BOLD+"Email: " + n.getEmail()+ConsoleColors.RESET);
					System.out.println(ConsoleColors.GREEN_BOLD+"Phone Number: " + n.getPhoneNumber()+ConsoleColors.RESET);
					System.out.println(ConsoleColors.GREEN_BOLD+"Address: " + n.getAddress()+ConsoleColors.RESET);
					System.out.println(ConsoleColors.GREEN_BOLD+"Balance: " + n.getBalance()+ConsoleColors.RESET);
					System.out.println();
					System.out.println(ConsoleColors.RED_BOLD+"================================================"+ConsoleColors.RESET);
				
					
					accountantMenu();
					
				} catch (CustomerException e) {
					System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+e.getMessage()+ConsoleColors.RESET);
					accountantMenu();
				}
				
				
			} else if(choice == 8) {
				try {
					List<Customer> list = a.viewAllCustomer();
					list.forEach(n -> {
						System.out.println(ConsoleColors.RED_BOLD+"================================================"+ConsoleColors.RESET);
						System.out.println();
						System.out.println(ConsoleColors.GREEN_BOLD+"Name: " + n.getName()+ConsoleColors.RESET);
						System.out.println(ConsoleColors.GREEN_BOLD+"Account Number: " + n.getAccountNumber()+ConsoleColors.RESET);
						System.out.println(ConsoleColors.GREEN_BOLD+"Email: " + n.getEmail()+ConsoleColors.RESET);
						System.out.println(ConsoleColors.GREEN_BOLD+"Phone Number: " + n.getPhoneNumber()+ConsoleColors.RESET);
						System.out.println(ConsoleColors.GREEN_BOLD+"Address: " + n.getAddress()+ConsoleColors.RESET);
						System.out.println(ConsoleColors.GREEN_BOLD+"Balance: " + n.getBalance()+ConsoleColors.RESET);
						System.out.println();
						System.out.println(ConsoleColors.RED_BOLD+"================================================"+ConsoleColors.RESET);
					
					});
					accountantMenu();
				} catch (CustomerException e) {
					System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+e.getMessage()+ConsoleColors.RESET);
					accountantMenu();
				}
				
				
			} else if(choice == 9) {
				System.out.println(ConsoleColors.YELLOW_BOLD+"Enter account number: "+ConsoleColors.RESET);
				int acc = sc.nextInt();
				sc.nextLine();
				try {
					List<Transactions> list = a.viewTransaction(acc);
					list.forEach(n -> {
						System.out.println(ConsoleColors.RED_BOLD+"================================================"+ConsoleColors.RESET);
						System.out.println();
						System.out.println(ConsoleColors.GREEN_BOLD+"Transaction ID: " + n.getTransactionId()+ConsoleColors.RESET);
						System.out.println(ConsoleColors.GREEN_BOLD+"Account Number: " + n.getAccountNumber()+ConsoleColors.RESET);
						System.out.println(ConsoleColors.GREEN_BOLD+"Amount Deposited: " + n.getDeposit()+ConsoleColors.RESET);
						System.out.println(ConsoleColors.GREEN_BOLD+"Amount Withdrawn: " + n.getClass()+ConsoleColors.RESET);
						System.out.println(ConsoleColors.GREEN_BOLD+"Time of transaction: " + n.getTimeOfTransaction()+ConsoleColors.RESET);
						System.out.println();
						System.out.println(ConsoleColors.RED_BOLD+"================================================"+ConsoleColors.RESET);
					});
					accountantMenu();
				} catch (CustomerException e) {
					System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+e.getMessage()+ConsoleColors.RESET);
					accountantMenu();
				}
			} else if(choice == 10)  {
				
				System.out.println(ConsoleColors.YELLOW_BOLD+"Enter email: "+ConsoleColors.RESET);
				String email = sc.nextLine();
				
				int accountNo = a.getAccountNumberUsingEmail(email);
				
				System.out.println("Account Number for the customer is: " + accountNo+ConsoleColors.RESET);
				accountantMenu();
				
			} else if(choice == 11) {
				
				System.out.println(ConsoleColors.YELLOW_BOLD+"Enter Accountant Email ID: "+ConsoleColors.RESET);
				String email = sc.nextLine();
				System.out.println(ConsoleColors.YELLOW_BOLD+"Enter accountant password: "+ConsoleColors.RESET);
				String password = sc.nextLine();
				System.out.println(ConsoleColors.YELLOW_BOLD+"Enter accountant name: "+ConsoleColors.RESET);
				String name = sc.nextLine();
				
				String ans = a.addAccountant(email, password, name);
				if(ans.equals("Accountant added sucessfully!") == true) {
					System.out.println(ConsoleColors.YELLOW_BOLD+ans+ConsoleColors.RESET);
				} else {
					System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+ans+ConsoleColors.RESET);
				}
				accountantMenu();
				
			} else if(choice == 12){
				menu();
			} else if(choice == 13) {
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"Thank you for using this application."+ConsoleColors.RESET);
				sc.close();
			} else {
				System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+"Invalid selection."+ConsoleColors.RESET);
				accountantMenu();
			}
			
			
			
		} catch (Exception e) {
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+"Invalid entry! Try again."+ConsoleColors.RESET);
			accountantMenu();
		}
		
	}
	
	public static void accountantAuth() {
		
		AccountantDAO a = new AccountantDAOImpl();
		
		System.out.println(ConsoleColors.YELLOW_BOLD+"To access the acccountant menu you need to login first. \r\n"+ConsoleColors.RESET);
		
		System.out.println(ConsoleColors.YELLOW_BOLD+"Enter username: "+ConsoleColors.RESET);
		String user = sc.nextLine();
		System.out.println(ConsoleColors.YELLOW_BOLD+"Enter password: "+ConsoleColors.RESET);
		String password = sc.nextLine();
		
		try {
			String response = a.Login(user, password);
			System.out.println(ConsoleColors.YELLOW_BOLD+response+ConsoleColors.RESET);
			accountantMenu();
		} catch (AccountantException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+e.getMessage()+ConsoleColors.RESET);
			menu();
		}
		
		
	}
	
	public static void customerMenu(int accountNo) {
		
		System.out.println(ConsoleColors.GREEN_BOLD+
				 			  "+================================+" +"\n"
				 			 +"|   Welcome To Customer Portal   |" +"\n"
							+ "+================================+" +"\n"
				 			+ "|                                |" +"\n"
							+ "|   1. View Balance              |" +"\n"
							+ "|   2. Deposit Money             |" +"\n"
							+ "|   3. Withdraw Money            |" +"\n"
							+ "|   4. Transfer Money            |" +"\n"
							+ "|   5. View Transaction History  |" +"\n"
							+ "|   6. LOGOUT                    |" +"\n"
							+ "|   7. Exit the application      |" +"\n"
							+ "|                                |" +"\n"
							+ "+================================+" +"\n"
							+ConsoleColors.RESET);
		
		CustomerDAO c = new CustomerDAOImpl();
		
		try {
			
			String ch = sc.nextLine();
			int choice = Integer.parseInt(ch);
			
			if(choice == 1) {
				
				try {
					int res = c.viewBalance(accountNo);
					if(res != -1) {
						System.out.println(ConsoleColors.YELLOW_BOLD+"Balance: " + res+ConsoleColors.RESET);
						customerMenu(accountNo);
					} else {
						System.out.println("Invalid account number.");
						customerMenu(accountNo);
					}
				} catch (CustomerException e) {
					System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+e.getMessage()+ConsoleColors.RESET);
					customerMenu(accountNo);
				}
				
			} else if(choice == 2) {
				
				
				System.out.println(ConsoleColors.YELLOW_BOLD+"Enter amount to be deposited: "+ConsoleColors.RESET);
				int amount = sc.nextInt();
				sc.nextLine();
				
				int dep = c.Deposit(accountNo, amount);
				
				if(dep != -1) {
					System.out.println("Transaction Done.");
					System.out.println("New Balance: " + dep);
					customerMenu(accountNo);
				} else {
					System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+"Transaction failed."+ConsoleColors.RESET);
					customerMenu(accountNo);
				}
				
				
			} else if(choice == 3) {
				
				
				System.out.println(ConsoleColors.YELLOW_BOLD+"Enter amount to be withdrawn: "+ConsoleColors.RESET);
				int amount = sc.nextInt();
				sc.nextLine();
				
				int w = c.withdraw(accountNo, amount);
				
				if(w != -1) {
					System.out.println("Transaction Done.");
					System.out.println("New Balance: " + w);
					customerMenu(accountNo);
				} else {
					System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+"Transaction failed."+ConsoleColors.RESET);
					customerMenu(accountNo);
				}
				
				
			} else if(choice == 4) {
				
				System.out.println(ConsoleColors.YELLOW_BOLD+"Enter amount to be transferred: "+ConsoleColors.RESET);
				int amount = sc.nextInt();
				sc.nextLine();
				
				System.out.println(ConsoleColors.YELLOW_BOLD+"Enter Account Number: "+ConsoleColors.RESET);
				int acc = sc.nextInt();
				sc.nextLine();
				
				String response = c.transfer(accountNo, amount, acc);
				System.out.println(response);
				
				customerMenu(accountNo);
				
			} else if(choice == 5) {
				
				try {
					List<Transactions> list = c.viewTransaction(accountNo);
					list.forEach(n -> {
						System.out.println(ConsoleColors.RED_BOLD+"======================================"+ConsoleColors.RESET);
						System.out.println();
						System.out.println(ConsoleColors.GREEN_BOLD+"Transaction ID: " + n.getTransactionId()+ConsoleColors.RESET);
						System.out.println(ConsoleColors.GREEN_BOLD+"Account Number: " + n.getAccountNumber()+ConsoleColors.RESET);
						System.out.println(ConsoleColors.GREEN_BOLD+"Amount Deposited: " + n.getDeposit()+ConsoleColors.RESET);
						System.out.println(ConsoleColors.GREEN_BOLD+"Amount Withdrawn: " + n.getClass()+ConsoleColors.RESET);
						System.out.println(ConsoleColors.GREEN_BOLD+"Time of transaction: " + n.getTimeOfTransaction()+ConsoleColors.RESET);
						System.out.println();
						System.out.println(ConsoleColors.RED_BOLD+"======================================"+ConsoleColors.RESET);
					});
					customerMenu(accountNo);
				} catch (CustomerException e) {
					System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+e.getMessage()+ConsoleColors.RESET);
					customerMenu(accountNo);
				}
				
			} else if(choice == 6) {
				menu();
			} else if(choice == 7) {
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"Thank you for using this application."+ConsoleColors.RESET);
				sc.close();
			} else {
				System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+"Invalid selection."+ConsoleColors.RESET);
				customerMenu(accountNo);
			}
			
			
		} catch (Exception e) {
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+"Invalid entry! Try again."+ConsoleColors.RESET);
			customerMenu(accountNo);
		}
		
		
	}
	
	public static void customerAuth() {
		
		CustomerDAO c = new CustomerDAOImpl();
		
		System.out.println(ConsoleColors.YELLOW_BOLD+"To access the Customer menu you need to login first. \r\n"+ConsoleColors.RESET);
		
		System.out.println(ConsoleColors.YELLOW_BOLD+"Enter username: "+ConsoleColors.RESET);
		String user = sc.nextLine();
		System.out.println(ConsoleColors.YELLOW_BOLD+"Enter password: "+ConsoleColors.RESET);
		String password = sc.nextLine();
		
		try {
			int accountNo = c.LoginCustomer(user, password);
			
			customerMenu(accountNo);
		} catch (CustomerException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+e.getMessage()+ConsoleColors.RESET);
			menu();
		}
		
	}
	
	
	public static void menu() {
		System.out.println(ConsoleColors.GREEN_BOLD+
	 			  "+================================+" +"\n"
	 			 +"|   Welcome To Banking System    |" +"\n"
				+ "+================================+" +"\n"
	 			+ "|                                |" +"\n"
				+ "|   1. Accountant Portal         |" +"\n"
				+ "|   2. Customer Portal           |" +"\n"
				+ "|   0. Exit the application      |" +"\n"
				+ "|                                |" +"\n"
				+ "+================================+" +"\n"
				+ConsoleColors.RESET);
		
		
		try {
			String ch = sc.nextLine();
			int choice = Integer.parseInt(ch);
			
			if(choice == 1) {
				System.out.println(ConsoleColors.GREEN_BOLD+"========================================================"+ConsoleColors.RESET);
				accountantAuth();
			} else if(choice == 2) {
				System.out.println(ConsoleColors.GREEN_BOLD+"========================================================="+ConsoleColors.RESET);
				customerAuth();
			} else if(choice == 0) {
				System.out.println(ConsoleColors.GREEN_BOLD+"========================================================="+ConsoleColors.RESET);
				System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT+"Thank you for using the Online Banking System. "+ConsoleColors.RESET);
				sc.close();
			} else {
				System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+"Invalid selection"+ConsoleColors.RESET);
				menu();
			}
			
			
		} catch (Exception e) {
			System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT+"Invalid entry! Try again. ");
			menu();
		}
		
	}
	
	
	public static void main(String[] args) {
		
		
		
		menu();
		
	}

}
