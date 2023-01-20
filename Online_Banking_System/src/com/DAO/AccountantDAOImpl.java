package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.Exceptions.AccountException;
import com.Exceptions.AccountantException;
import com.Exceptions.CustomerException;
import com.Model.Customer;
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
	public int addCustomer(String name, String email, String password, int phoneNumber, String address, int balance) throws CustomerException {
		int ans = -1;
		
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
				PreparedStatement p2 = con.prepareStatement("select cusId from customer where phoneNumber = ?");
				p2.setInt(1, phoneNumber);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					ans = rs.getInt("cusId");
				}
			} else {
				throw new CustomerException("Inserted data is incorrect.");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ans;
	}

	@Override
	public String addAccount(int balance, int cusId) throws AccountException {
		String ans = "Inserted data is incorrect.";
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("insert into account(balance, cusId) values(?, ?)");
			ps.setInt(1, balance);
			ps.setInt(2, cusId);
			int res = ps.executeUpdate();
			if(res > 0) {
				ans = "Customer added successfully.";
			} else {
				throw new AccountException(ans);
			}
			
		} catch (SQLException e) {
			throw new AccountException(ans);
		}
		
		return ans;
	}

	@Override
	public String updateCustomer(int accountNumber, String address) throws CustomerException {
		String ans = "Could not find the customer. Try again";
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement(" update customer c JOIN account a ON c.cusId = a.cusId where a.accountNumber = ? set c.address = ?");
			int res = ps.executeUpdate();
			
			if(res > 0) {
				ans = "Updated successfully.";
			} else {
				throw new CustomerException("Could not find the customer.");
			}
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		return ans;
	}

	@Override
	public Customer viewCustomer(int accountNumber) throws CustomerException {
		Customer customer = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			
			PreparedStatement ps= conn.prepareStatement("select * from customer c JOIN account a on a.cusId=c.cusId where accountNumber = ?");			
			
			ps.setInt(1, accountNumber);
			
			
			ResultSet rs= ps.executeQuery();
			
			
			if(rs.next()) {
				
					
					String n = rs.getString("name");
					
					int b = rs.getInt("balance");
					
					String e = rs.getString("email");
					
					String p = rs.getString("password");
					
					int m = rs.getInt("phoneNumber");
					
					String ad = rs.getString("address");
					
					customer = new Customer();
					customer.setName(n);
					customer.setBalance(b);
					customer.setEmail(e);
					customer.setPassword(p);
					customer.setPhoneNumber(m);
					customer.setAddress(ad);
				
			}else
				throw new CustomerException("Invalid Account No. ");
			
			 
			
			
		} catch (SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		
		
		
		return customer;

	}

	@Override
	public int getCustomer(String email, String phoneNumber) throws CustomerException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Customer> viewAllCustomer() throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCustomer(int accountNumber) throws CustomerException {
		String ans = "Could not find the customer with the given account Number";
		try(Connection conn= DBUtil.provideConnection()) {
		 
		 
		
		 PreparedStatement ps=conn.prepareStatement("delete c from customer c JOIN account a on c.cusId = a.cusId where a.accountNumber = ?");

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


}
