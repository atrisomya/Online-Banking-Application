package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.Exceptions.AccountantException;
import com.Exceptions.CustomerException;
import com.Model.Customer;
import com.Model.Transactions;
import com.Utility.DBUtil;

public class AccountantDAOImpl implements AccountantDAO {

	@Override
	public String Login(String email, String password) throws AccountantException {

		String ans = "Invalid ID or password";
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("select accName from accountant where accId = ? AND password = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ans = "Welcome " + rs.getString("accName") + "!";
			} else {
				throw new AccountantException(ans);
			}
			
		} catch (SQLException e) {
			throw new AccountantException(e.getMessage());
		}
		
		
		return ans;
	
	}

	@Override
	public String addCustomer(String name, String email, String password, int phoneNumber, String address, int balance) throws CustomerException {
		String ans = "Inserted data is incorrect.";
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("insert into customer(name, email, password, phoneNumber, address, balance) values(?, ?, ?, ?, ?, ?)");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setInt(4, phoneNumber);
			ps.setString(5, address);
			ps.setInt(6, balance);
			int res = ps.executeUpdate();
			if(res > 0) {
				int acc = getAccountNumber(email);
				ans = "Account added successfully. Customer account number is: " + acc;
			} else {
				System.out.println("Inserted data is incorrect.");
			}
			
			
		} catch (SQLException e) {
			throw new CustomerException("Inserted data is incorrect.");
		}
		
		return ans;
	}

	@Override
	public String updateAddress(int accountNumber, String address) throws CustomerException {
		String ans = "Could not find the customer. Try again";
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("update customer set address = ? where accountNumber = ?");
			ps.setString(1, address);
			ps.setInt(2, accountNumber);
			int res = ps.executeUpdate();
			
			if(res > 0) {
				ans = "Address Updated successfully.";
			} else {
				throw new CustomerException("Could not find the customer.");
			}
			
		} catch (SQLException e) {
			throw new CustomerException(ans);
		}
		
		return ans;
	}

	@Override
	public Customer viewCustomer(int accountNumber) throws CustomerException {
		Customer customer = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			
			PreparedStatement ps= conn.prepareStatement("select * from customer where accountNumber = ?");			
			
			ps.setInt(1, accountNumber);
			
			
			ResultSet rs= ps.executeQuery();
			
			
			if(rs.next()) {
				
					int acc = rs.getInt("accountNumber");
				
					String n = rs.getString("name");
					
					int b = rs.getInt("balance");
					
					String e = rs.getString("email");
					
					String p = rs.getString("password");
					
					int m = rs.getInt("phoneNumber");
					
					String ad = rs.getString("address");
					
					customer = new Customer(acc, n, e, p, m, ad, b);
					
			}else
				throw new CustomerException("Invalid Account No. ");
			
			 
			
			
		} catch (SQLException e) {
			throw new CustomerException("Invalid Account No. ");
		}
		
		
		
		return customer;

	}

	@Override
	public String deleteCustomer(int accountNumber) throws CustomerException {
		String ans = "Could not find the customer with the given account Number";
		try(Connection conn= DBUtil.provideConnection()) {
		 
		 
		
		 PreparedStatement ps=conn.prepareStatement("delete from customer where accountNumber = ?");

		 ps.setInt(1, accountNumber);
	
	     
		int x=ps.executeUpdate();
		 
		 if(x > 0) {
			 System.out.println("Account deleted sucessfully..!");
			 System.out.println("-------------------------------");
		 }else {
			 System.out.println("Deletion failed...Account Not Found");
			 System.out.println("------------------------------------");
		 }	
		}catch(SQLException e) {
			
			e.printStackTrace();
			ans=e.getMessage();
		}
		
		return ans;
	}

	@Override
	public List<Customer> viewAllCustomer() throws CustomerException {
		List<Customer> list = new ArrayList<>();
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("select * from customer");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int accno = rs.getInt("accountNumber");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				int phoneNumber = rs.getInt("phoneNumber");
				String address = rs.getString("address");
				int balance = rs.getInt("balance");
				
				Customer cus = new Customer(accno, name, email, password, phoneNumber, address, balance);
				list.add(cus);
			} 
			
		} catch(SQLException e) {
			throw new CustomerException("Data could not be retrieved.");
		}
		
		return list;
	}

	@Override
	public String updateName(String name, int accountNumber) throws CustomerException {
		String ans = "Could not find the customer. Try again";
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement(" update customer set name = ? where accountNumber = ?");
			ps.setString(1, name);
			ps.setInt(2, accountNumber);
			int res = ps.executeUpdate();
			
			if(res > 0) {
				ans = "Name updated successfully.";
			} else {
				throw new CustomerException("Could not find the customer.");
			}
			
		} catch (SQLException e) {
			throw new CustomerException(ans);
		}
		
		return ans;
	}

	@Override
	public String updateEmail(String email, int accountNumber) throws CustomerException {
		String ans = "Could not find the customer. Try again";
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement(" update customer set email = ? where accountNumber = ?");
			ps.setString(1, email);
			ps.setInt(2, accountNumber);
			int res = ps.executeUpdate();
			
			if(res > 0) {
				ans = "Email updated successfully.";
			} else {
				throw new CustomerException("Could not find the customer.");
			}
			
		} catch (SQLException e) {
			throw new CustomerException(ans);
		}
		
		return ans;
	}

	@Override
	public String updatePhoneNumber(int phoneNumber, int accountNumber) throws CustomerException {
		String ans = "Could not find the customer. Try again";
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement(" update customer set phoneNumber = ? where accountNumber = ?");
			ps.setInt(1, phoneNumber);
			ps.setInt(2, accountNumber);
			int res = ps.executeUpdate();
			
			if(res > 0) {
				ans = "Phone Number updated successfully.";
			} else {
				throw new CustomerException("Could not find the customer.");
			}
			
		} catch (SQLException e) {
			throw new CustomerException(ans);
		}
		
		return ans;
	}

	@Override
	public List<Transactions> viewTransaction(int accountNumber) throws CustomerException {
		List<Transactions> list = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			if(checkAccount(accountNumber)) {
			
				PreparedStatement ps=conn.prepareStatement("select * from transactions where accountNumber = ?");
				ps.setInt(1, accountNumber);
				
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					
					while(rs.next()) {
						int tid = rs.getInt("transactionId");
						int accNo = rs.getInt("accountNumber");
						int dep = rs.getInt("deposit");
						int with = rs.getInt("withdraw");
						Timestamp t = rs.getTimestamp("timeOfTransaction");
						
						Transactions ts = new Transactions(tid, accNo, dep, with, t);
						list.add(ts);
					}
					
				} else {
					throw new CustomerException("No transactions have been made by this account number.");
				}
			
			} else {
				
				throw new CustomerException("Invalid account number.");
			
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return list;
	}

	@Override
	public List<Transactions> viewTransaction() throws CustomerException {
		List<Transactions> list = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from transactions");
			
			ResultSet rs = ps.executeQuery();
			
				while(rs.next()) {
					int tid = rs.getInt("transactionId");
					int accNo = rs.getInt("accountNumber");
					int dep = rs.getInt("deposit");
					int with = rs.getInt("withdraw");
					Timestamp t = rs.getTimestamp("timeOfTransaction");
					
					Transactions ts = new Transactions(tid, accNo, dep, with, t);
					list.add(ts);
				}  
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return list;
	}

	@Override
	public int getAccountNumberUsingEmail(String email) throws CustomerException {
		int accNo = -1;
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("select accountNumber from customer where email = ?");
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				accNo = rs.getInt("accountNumber");
			} else {
				throw new CustomerException("Invalid email.");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return accNo;
	}
	
	private int getAccountNumber(String email) throws CustomerException {
		int accNo = -1;
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("select accountNumber from customer where email = ?");
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				accNo = rs.getInt("accountNumber");
			} else {
				throw new CustomerException("Invalid email.");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return accNo;
	}
	private boolean checkAccount(int accountNumber) {
		
		try(Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from Customer where accountNumber=?;");
			
			ps.setInt(1, accountNumber);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
		
	}

	@Override
	public String addAccountant(String email, String password, String name) throws AccountantException {
		String response = "Accountant could not be added.";
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("insert into accountant values(?, ?, ?)");
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3, name);
			int ans = ps.executeUpdate();
			if(ans > 0) {
				response = "Accountant added sucessfully!";
				
			} else {
				throw new AccountantException(response);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			response = e.getMessage();
		}
		
		
		return response;
	}
	
}
